package org.jglrxavpok.audiokode.decoders

import org.jglrxavpok.audiokode.SoundEngine
import org.jglrxavpok.audiokode.StreamingInfo
import org.jglrxavpok.audiokode.filters.AudioFilter
import java.io.InputStream

interface StreamingDecoder {

    fun prepare(input: InputStream, filter: AudioFilter): StreamingInfo
    fun loadNextChunk(bufferID: Int, info: StreamingInfo, engine: SoundEngine): Boolean
}