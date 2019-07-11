package org.jglrxavpok.audiokode.filters

import org.lwjgl.BufferUtils
import java.nio.ShortBuffer

val NegateFilter = object: AudioFilter {
    override fun invoke(pcmData: ShortBuffer): ShortBuffer {
        val result = BufferUtils.createShortBuffer(pcmData.remaining())
        while(pcmData.hasRemaining())
            result.put((-pcmData.get()).toShort())
        result.flip()
        return result
    }

}