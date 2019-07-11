package org.jglrxavpok.audiokode

import org.jglrxavpok.audiokode.decoders.StreamingDecoder
import org.jglrxavpok.audiokode.filters.AudioFilter
import org.lwjgl.openal.AL10.*
import java.io.InputStream

class StreamingSource(engine: SoundEngine): Source(engine) {

    private val ROTATING_BUFFER_COUNT = 8
    lateinit var info: StreamingInfo
    private var eof = false

    override fun update() {
        updateStream()
        super.update()
    }

    fun updateStream() {
        var processed = alGetSourcei(alID, AL_BUFFERS_PROCESSED)
        val replay = processed == ROTATING_BUFFER_COUNT
        while(processed > 0) {
            val bufID = alSourceUnqueueBuffers(alID)
            if (!eof) {
                if (!loadNext(bufID)) {
                    eof = true
                }
                alSourceQueueBuffers(alID, bufID)
            }
            processed--
        }
        if(replay)
            alSourcePlay(alID)
    }

    private fun loadNext(bufferID: Int): Boolean {
        val eof = info.decoder.loadNextChunk(bufferID, info, engine)
        if(eof && looping) {
            this.eof = false
            val provider = info.inputProvider
            val inputStream = provider().buffered()
            info = info.decoder.prepare(inputStream, info.filter)
            info.inputProvider = provider
            return loadNext(bufferID)
        }
        return ! eof
    }

    fun prepareRotatingBuffers() {
        alSourcei(alID, AL_BUFFER, 0)
        val buffers = IntArray(ROTATING_BUFFER_COUNT)
        alGenBuffers(buffers)
        for(id in buffers)
            loadNext(id)
        alSourceQueueBuffers(alID, buffers)
    }
}

data class StreamingInfo(val decoder: StreamingDecoder, val format: Int, val frequency: Int, val channels: Int, val input: InputStream, val filter: AudioFilter) {
    val payload = hashMapOf<String, Any>()
    lateinit var inputProvider: () -> InputStream
}