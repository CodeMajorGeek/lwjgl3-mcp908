package org.jglrxavpok.audiokode.filters

import java.nio.ShortBuffer

interface AudioFilter {
    operator fun invoke(pcmData: ShortBuffer): ShortBuffer

    operator fun times(other: AudioFilter): AudioFilter {
        return CompositeFilter(other, this)
    }
}

class CompositeFilter(val first: AudioFilter, val second: AudioFilter): AudioFilter {
    override fun invoke(pcmData: ShortBuffer): ShortBuffer = second(first(pcmData))
}

val NoFilter = object : AudioFilter {
    override fun invoke(pcmData: ShortBuffer) = pcmData
}