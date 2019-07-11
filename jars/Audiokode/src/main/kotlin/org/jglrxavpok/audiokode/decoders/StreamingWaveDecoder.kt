package org.jglrxavpok.audiokode.decoders

import org.jglrxavpok.audiokode.SoundEngine
import org.jglrxavpok.audiokode.StreamingBufferSize
import org.jglrxavpok.audiokode.StreamingInfo
import org.jglrxavpok.audiokode.filters.AudioFilter
import org.lwjgl.openal.AL10
import java.io.IOException
import java.io.InputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder
import javax.sound.sampled.AudioSystem

object StreamingWaveDecoder: StreamingDecoder {
    private val SampleSizeInBitsKey = "sampleSizeInBits"
    private val IsBigEndianKey = "isBigEndian"

    override fun prepare(input: InputStream, filter: AudioFilter): StreamingInfo {
        val ais = AudioSystem.getAudioInputStream(input)
        //get format of data
        val audioFormat = ais.format

        // get channels
        val channels: Int
        channels = when {
            audioFormat.channels == 1 ->
                when {
                    audioFormat.sampleSizeInBits == 8 -> AL10.AL_FORMAT_MONO8
                    audioFormat.sampleSizeInBits == 16 -> AL10.AL_FORMAT_MONO16
                    else -> throw IOException("Illegal sample size ${audioFormat.sampleSizeInBits}")
                }
            audioFormat.channels == 2 ->
                when {
                    audioFormat.sampleSizeInBits == 8 -> AL10.AL_FORMAT_STEREO8
                    audioFormat.sampleSizeInBits == 16 -> AL10.AL_FORMAT_STEREO16
                    else -> throw IOException("Illegal sample size ${audioFormat.sampleSizeInBits}")
                }
            else -> throw IOException("Only mono or stereo is supported, found ${audioFormat.channels} channels")
        }

        val result = StreamingInfo(this, channels, audioFormat.sampleRate.toInt(), audioFormat.channels, input, filter)
        result.payload[SampleSizeInBitsKey] = audioFormat.sampleSizeInBits
        result.payload[IsBigEndianKey] = audioFormat.isBigEndian
        return result
    }

    override fun loadNextChunk(bufferID: Int, info: StreamingInfo, engine: SoundEngine): Boolean {
        val buffer: ByteBuffer
        val buf = ByteArray(StreamingBufferSize)
        var read: Int
        var total = 0
        var eof = false
        do {
            read = info.input.read(buf, total, buf.size - total)
            if(read != -1 && total < buf.size)
                total += read

            if(read == -1) {
                eof = true
            }
        } while(read != -1 && total < buf.size)
        val sampleSizeInBits = info.payload[SampleSizeInBitsKey] as Int
        val isBigEndian = info.payload[IsBigEndianKey] as Boolean
        buffer = DirectWaveDecoder.convertAudioBytes(buf, sampleSizeInBits == 16, if (isBigEndian) ByteOrder.BIG_ENDIAN else ByteOrder.LITTLE_ENDIAN)

        engine.bufferData(bufferID, info.format, buffer, info.frequency, info.filter)
        return eof
    }
}