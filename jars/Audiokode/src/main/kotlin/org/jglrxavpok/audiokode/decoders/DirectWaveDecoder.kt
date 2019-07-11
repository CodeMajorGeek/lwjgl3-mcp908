package org.jglrxavpok.audiokode.decoders

import java.nio.ByteBuffer
import org.jglrxavpok.audiokode.Buffer
import org.jglrxavpok.audiokode.SoundEngine
import org.jglrxavpok.audiokode.filters.AudioFilter
import org.lwjgl.openal.AL10
import javax.sound.sampled.AudioSystem
import java.io.ByteArrayInputStream
import java.io.IOException
import java.nio.ByteOrder


object DirectWaveDecoder : AudioDecoder {
    override val streamingVariant: StreamingDecoder = StreamingWaveDecoder

    override val extension: String = "wav"
    // FIXME FROM LWJGL2 WaveData

    override fun decode(raw: ByteArray, engine: SoundEngine, filter: AudioFilter): Buffer {
        val input = ByteArrayInputStream(raw)
        val ais = AudioSystem.getAudioInputStream(input)
        //get format of data
        val audioFormat = ais.format

        // get channels
        val channelsFormat: Int
        channelsFormat = when {
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

        //read data into buffer
        val buffer: ByteBuffer
        var available = ais.available()
        if (available <= 0) {
            available = ais.format.channels * ais.frameLength.toInt() * ais.format.sampleSizeInBits / 8
        }
        val buf = ByteArray(ais.available())
        var read: Int
        var total = 0
        do {
            read = ais.read(buf, total, buf.size - total)
            if(read != -1 && total < buf.size)
                total += read
        } while(read != -1 && total < buf.size)
        buffer = convertAudioBytes(buf, audioFormat.sampleSizeInBits == 16, if (audioFormat.isBigEndian) ByteOrder.BIG_ENDIAN else ByteOrder.LITTLE_ENDIAN)


        val result = engine.newBuffer()
        result.format = channelsFormat
        result.frequency = audioFormat.sampleRate.toInt()
        engine.upload(result, buffer, filter)

        ais.close()
        input.close()
        return result
    }

    internal fun convertAudioBytes(audioBytes: ByteArray, twoBytesData: Boolean, order: ByteOrder): ByteBuffer {
        val dest = ByteBuffer.allocateDirect(audioBytes.size)
        dest.order(ByteOrder.nativeOrder())
        val src = ByteBuffer.wrap(audioBytes)
        src.order(order)
        if (twoBytesData) {
            val destShort = dest.asShortBuffer()
            val srcShort = src.asShortBuffer()
            destShort.put(srcShort)
        } else {
            dest.put(src)
        }
        dest.rewind()
        return dest
    }


}
