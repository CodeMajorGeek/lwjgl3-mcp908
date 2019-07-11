import org.jglrxavpok.audiokode.ThreadedSoundEngine

object TestMasterGain {

    @JvmStatic fun main(args: Array<String>) {
        val engine = ThreadedSoundEngine()
        engine.initWithDefaultOpenAL()
        engine.setMasterGain(.015f)
        engine.quickplayBackgroundMusic("TestWav")
    }
}