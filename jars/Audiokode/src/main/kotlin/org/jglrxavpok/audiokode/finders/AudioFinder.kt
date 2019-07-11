package org.jglrxavpok.audiokode.finders

import org.jglrxavpok.audiokode.decoders.AudioDecoder
import org.jglrxavpok.audiokode.decoders.DirectWaveDecoder
import org.jglrxavpok.audiokode.decoders.StreamingDecoder
import org.jglrxavpok.audiokode.decoders.StreamingWaveDecoder
import java.io.ByteArrayInputStream
import java.io.InputStream

interface AudioFinder {
    fun findAudio(identifier: String): AudioInfo
}

data class AudioInfo(val inputProvider: () -> InputStream, val decoder: AudioDecoder, val streamDecoder: StreamingDecoder)

val AUDIO_NOT_FOUND = AudioInfo({ByteArrayInputStream(byteArrayOf(0))}, DirectWaveDecoder, StreamingWaveDecoder)