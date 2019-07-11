import org.jglrxavpok.audiokode.SoundEngine

object TestStreamingVorbis {

    @JvmStatic fun main(args: Array<String>) {
        val engine = SoundEngine()
        engine.initWithDefaultOpenAL()
        val source = engine.backgroundMusic("TestVorbis", false)
        source.play()
        source.gain = 0.25f
        while(source.isPlaying()) {
            engine.update()
        }
        println("End!")
    }
}