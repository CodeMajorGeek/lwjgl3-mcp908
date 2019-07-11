import org.jglrxavpok.audiokode.SoundEngine

object QuickplayMusic {
    @JvmStatic fun main(args: Array<String>) {
        val engine = SoundEngine()
        engine.initWithDefaultOpenAL()
        engine.quickplayBackgroundMusic("TestWav")
        while(engine.isSomethingPlaying()) {
            engine.update()
            Thread.sleep(1)
        }
    }
}