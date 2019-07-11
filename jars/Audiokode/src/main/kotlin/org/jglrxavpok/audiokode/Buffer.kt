package org.jglrxavpok.audiokode

import org.jglrxavpok.audiokode.decoders.DirectWaveDecoder

class Buffer(val alID: Int, val engine: SoundEngine): Disposable {
    var data: ByteArray = byteArrayOf()

    var codec = DirectWaveDecoder
    var frequency = 0
    var format = 0

    override fun dispose() {
        engine.disposeBuffer(this)
    }
}