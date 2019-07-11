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
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer
import org.lwjgl.BufferUtils

/**
 * Still reads all the file contents to the memory. OpenAL has only small buffers streamed to it though.
 */
object StreamingVorbisDecoder: StreamingDecoder {

    private val STBDecoderKey = "stb decoder"

    override fun prepare(input: InputStream, filter: AudioFilter): StreamingInfo {
        val buf = readAll(input)
        stackPush()
        val data = ByteBuffer.allocateDirect(buf.size)
        data.put(buf)
        data.flip()

        val error = stackMallocInt(1)

        val decoderInstance = stb_vorbis_open_memory(data, error, null)

        val infos = stb_vorbis_get_info(decoderInstance, STBVorbisInfo.malloc())
        val format = when(infos.channels()) {
            1 -> AL10.AL_FORMAT_MONO16
            2 -> AL10.AL_FORMAT_STEREO16
            else -> kotlin.error("Unknown channel count ${infos.channels()}")
        }
        val result = StreamingInfo(this, format, infos.sample_rate(), infos.channels(), input.buffered(), filter)
        result.payload[STBDecoderKey] = decoderInstance
        stackPop()

        return result
    }

    private fun readAll(input: InputStream): ByteArray {
        val out = ByteArrayOutputStream()
        var read: Int
        val buf = ByteArray(2048)
        do {
            read = input.read(buf)
            if(read != -1) {
                out.write(buf, 0, read)
            }
        } while(read != -1)
        return out.toByteArray()
    }

    override fun loadNextChunk(bufferID: Int, info: StreamingInfo, engine: SoundEngine): Boolean {
        var samples = 0

        val pcm = BufferUtils.createShortBuffer(StreamingBufferSize)
        val decoder = info.payload[STBDecoderKey] as Long
        while (samples < StreamingBufferSize) {
            val samplesPerChannel = stb_vorbis_get_samples_short_interleaved(decoder, info.channels, pcm)
            if (samplesPerChannel == 0) {
                break
            }

            samples += samplesPerChannel * info.channels
        }

        if (samples == 0) {
            return true
        }

        engine.bufferData(bufferID, info.format, pcm, info.frequency, info.filter)
        return false
    }

}