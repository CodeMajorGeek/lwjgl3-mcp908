package org.jglrxavpok.audiokode.decoders

import org.jglrxavpok.audiokode.Buffer
import org.jglrxavpok.audiokode.SoundEngine
import org.jglrxavpok.audiokode.filters.AudioFilter
import org.lwjgl.BufferUtils

import org.lwjgl.openal.AL10.AL_FORMAT_STEREO16
import org.lwjgl.openal.AL10.AL_FORMAT_MONO16
import org.lwjgl.stb.STBVorbis.stb_vorbis_decode_memory
import org.lwjgl.system.MemoryStack.stackPop
import org.lwjgl.system.MemoryStack.stackMallocInt
import org.lwjgl.system.MemoryStack.stackPush
import org.lwjgl.system.libc.LibCStdlib.free
import java.io.IOException


object DirectVorbisDecoder : AudioDecoder {
    override val streamingVariant: StreamingDecoder = StreamingVorbisDecoderPushdata

    override val extension: String = "ogg"

    // From LWJGL3 wiki
    override fun decode(raw: ByteArray, engine: SoundEngine, filter: AudioFilter): Buffer {
        stackPush()
        val channelsBuffer = stackMallocInt(1)
        stackPush()
        val sampleRateBuffer = stackMallocInt(1)

        val rawBuffer = BufferUtils.createByteBuffer(raw.size)
        rawBuffer.put(raw)
        rawBuffer.flip()

        val rawAudioBuffer = stb_vorbis_decode_memory(rawBuffer, channelsBuffer, sampleRateBuffer)

        //Retrieve the extra information that was stored in the buffers by the function
        val channels = channelsBuffer.get()
        val sampleRate = sampleRateBuffer.get()
        //Free the space we allocated earlier
        stackPop()
        stackPop()

        //Find the correct OpenAL format
        val format: Int
        format = when (channels) {
            1 -> AL_FORMAT_MONO16
            2 -> AL_FORMAT_STEREO16
            else -> throw IOException("Unsupported amount of channels: $channels")
        }

        val result = engine.newBuffer()
        result.frequency = sampleRate
        result.format = format
        engine.upload(result, rawAudioBuffer, filter)

        free(rawAudioBuffer)
        return result
    }
}