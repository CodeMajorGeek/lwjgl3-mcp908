package org.jglrxavpok.audiokode.decoders

import org.jglrxavpok.audiokode.SoundEngine
import org.jglrxavpok.audiokode.StreamingBufferSize
import org.jglrxavpok.audiokode.StreamingInfo
import org.jglrxavpok.audiokode.filters.AudioFilter
import org.lwjgl.openal.AL10
import org.lwjgl.stb.STBVorbis.*
import org.lwjgl.stb.STBVorbisInfo
import org.lwjgl.system.MemoryStack.*
import java.io.InputStream
import java.nio.ByteBuffer
import org.lwjgl.BufferUtils
import java.io.IOException

object StreamingVorbisDecoderPushdata: StreamingDecoder {

    private val STBDecoderKey = "stb decoder"
    private val AudioStreamKey = "audio stream"
    private val ByteBufferKey = "ByteBuffer"

    override fun prepare(input: InputStream, filter: AudioFilter): StreamingInfo {
        val stream = AudioStream(input)
        stream.refill()
        val (header, headerLength) = stream.extractContent()
        stackPush()
        val data = ByteBuffer.allocateDirect(header.size)
        data.put(header, 0, headerLength)
        data.flip()

        val error = stackMallocInt(1)
        val consumed = stackMallocInt(1)

        val decoderInstance = stb_vorbis_open_pushdata(data, consumed, error, null)
        stream.consume(consumed[0])
        if(error[0] != 0) {
            throw IOException("Error while loading streaming ogg audio: ${error[0]} (stb_vorbis)")
        }

        val info = stb_vorbis_get_info(decoderInstance, STBVorbisInfo.malloc())
        val format = when(info.channels()) {
            1 -> AL10.AL_FORMAT_MONO16
            2 -> AL10.AL_FORMAT_STEREO16
            else -> kotlin.error("Unknown channel count ${info.channels()}")
        }
        val result = StreamingInfo(this, format, info.sample_rate(), info.channels(), input.buffered(), filter)
        result.payload[STBDecoderKey] = decoderInstance
        result.payload[AudioStreamKey] = stream
        result.payload[ByteBufferKey] = BufferUtils.createByteBuffer(StreamingBufferSize)
        stackPop()

        return result
    }


    override fun loadNextChunk(bufferID: Int, info: StreamingInfo, engine: SoundEngine): Boolean {
        val stream = info.payload[AudioStreamKey] as AudioStream
        val decoder = info.payload[STBDecoderKey] as Long
        val buffer = info.payload[ByteBufferKey] as ByteBuffer

        stackPush()
        val channelsOut = stackMallocInt(1)
        val samplesOut = stackMallocInt(1)
        val samplesPointerPointer = stackMallocPointer(1)

        var completelyConsumed = stream.length == 0 && stream.eof
        if(completelyConsumed) {
            stackPop()
            return true
        }

        do {
            val eof = stream.refill()

            val (data, dataLength) = stream.extractContent()
            buffer.rewind()
            buffer.put(data, 0, dataLength)
            buffer.flip()


            val consumed = stb_vorbis_decode_frame_pushdata(decoder, buffer, channelsOut, samplesPointerPointer, samplesOut)
            stream.consume(consumed)
            val samples = samplesOut.get(0)

            channelsOut.rewind()
            samplesOut.rewind()

            completelyConsumed = stream.length == 0 && eof
        } while (samples == 0 && !completelyConsumed)

        if(completelyConsumed) {
            stb_vorbis_close(decoder)
        }

        val channels = channelsOut.get(0)
        val samples = samplesOut.get(0)

        val output_pp = samplesPointerPointer.getPointerBuffer(channels) // float**
        val finalOutput = stackMallocShort(samples * channels)
        for (c in 0 until channels) {
            val channel = output_pp.getFloatBuffer(c, samples) // float*
            for (s in 0 until samples) {
                val sample = channel.get(s)
                val shortSamples = ((sample * Short.MAX_VALUE).coerceIn(Short.MIN_VALUE.toFloat(), Short.MAX_VALUE.toFloat())).toShort()
                finalOutput.put(c + s * channels, shortSamples)
            }
        }

        finalOutput.rewind()

        engine.bufferData(bufferID, info.format, finalOutput, info.frequency)
        stackPop()

        return completelyConsumed
    }

}

private class AudioStream(val input: InputStream) {
    private val buffer = ByteArray(StreamingBufferSize)
    var length = 0
        private set
    private val data = ExtractedData(buffer, length)
    private val tail = ByteArray(StreamingBufferSize)
    internal var eof = false

    fun extractContent(): ExtractedData {
        data.length = length
        return data
    }

    fun consume(n: Int) {
        //for (i in 0 until length)
        //    buffer[i] = if(i+n < buffer.size) buffer[i+n] else 0
        System.arraycopy(buffer, n, buffer, 0, if(n+length > buffer.size) buffer.size-n else length) // shift

        length -= n
        if(length < 0)
            length = 0
    }

    fun refill(): Boolean {
        val tailSize = buffer.size-length
        val read = readChunk(input, tail, tailSize)
        System.arraycopy(tail, 0, buffer, length, read)

        length += read

        return eof
    }

    private fun readChunk(input: InputStream, chunk: ByteArray, totalSize: Int): Int {
        var total = 0
        do {
            val read = input.read(chunk, total, totalSize-total)
            if(read != -1) {
                total += read
            } else {
                eof = true
            }
        } while(read != -1 && total < totalSize)
        return total
    }
}

data class ExtractedData(val buffer: ByteArray, var length: Int)