package org.jglrxavpok.audiokode

class ThreadedSoundEngine: SoundEngine() {

    var stopped = false

    override fun init() {
        super.init()
        val thread = Thread {
            while(!stopped) {
                this.update()
            }
        }
        thread.priority = Thread.MAX_PRIORITY
        thread.isDaemon = false
        thread.start()
    }

    override fun dispose() {
        super.dispose()
        stopped = true
    }
}