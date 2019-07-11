import org.jglrxavpok.audiokode.SoundEngine
import org.jglrxavpok.audiokode.filters.NegateFilter

object TestFiltered {
    @JvmStatic fun main(args: Array<String>) {
        val engine = SoundEngine()
        engine.initWithDefaultOpenAL()
        engine.quickplayBackgroundMusic("TestWav", looping = false, filter = NegateFilter)
        while(engine.isSomethingPlaying()) {
            engine.update()
            Thread.sleep(1)
        }
    }
}