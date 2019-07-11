import org.jglrxavpok.audiokode.SoundEngine

object TestStreamingWav {

    @JvmStatic fun main(args: Array<String>) {
        val engine = SoundEngine()
        engine.initWithDefaultOpenAL()
        val source = engine.backgroundMusic("TestWav", false)
        source.play()
        source.gain = 0.15f
        while(source.isPlaying()) {
            engine.update()
            Thread.sleep(1)
        }
        println("End!")
    }
}