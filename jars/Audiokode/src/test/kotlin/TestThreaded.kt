import org.jglrxavpok.audiokode.ThreadedSoundEngine

object TestThreaded {
    @JvmStatic fun main(args: Array<String>) {
        val engine = ThreadedSoundEngine()
        engine.initWithDefaultOpenAL()
        engine.quickplayBackgroundMusic("TestVorbis2", gain=0.25f)
    }
}