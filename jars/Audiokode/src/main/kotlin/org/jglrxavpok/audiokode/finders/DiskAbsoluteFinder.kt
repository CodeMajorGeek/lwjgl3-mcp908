package org.jglrxavpok.audiokode.finders

import org.jglrxavpok.audiokode.decoders.Decoders
import java.io.File
import java.io.FileInputStream

object DiskAbsoluteFinder: AudioFinder {
    override fun findAudio(identifier: String): AudioInfo {
        for((extension, decoder, streaming) in Decoders.map { Triple(it.extension, it, it.streamingVariant) }) {
            val file = File("$identifier.$extension")
            if(file.exists()) {
                return AudioInfo({FileInputStream(file)}, decoder, streaming)
            }
        }
        return AUDIO_NOT_FOUND
    }
}