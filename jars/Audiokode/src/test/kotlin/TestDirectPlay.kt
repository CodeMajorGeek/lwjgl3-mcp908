import org.jglrxavpok.audiokode.SoundEngine

object TestDirectPlay {

    @JvmStatic fun main(args: Array<String>) {
        val engine = SoundEngine()
        engine.initWithDefaultOpenAL()
        val source = engine.backgroundSound("TestWav", false)
        source.play()
        while(source.isPlaying()) {
            Thread.sleep(1)
        }
    }
}