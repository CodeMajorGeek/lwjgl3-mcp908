import org.jglrxavpok.audiokode.SoundEngine
import org.jglrxavpok.audiokode.filters.AudioFilter
import java.nio.ShortBuffer

object ComposeFiltersTest {
    @JvmStatic fun main(args: Array<String>) {
        val engine = SoundEngine()
        engine.initWithDefaultOpenAL()
        engine.quickplayBackgroundSound("TestWav", filter = filterB * filterA)
        engine.dispose()
    }

    val filterA = object: AudioFilter {
        override fun invoke(pcmData: ShortBuffer): ShortBuffer {
            println("Filter A: ${pcmData.remaining()}")
            return pcmData
        }
    }

    val filterB = object: AudioFilter {
        override fun invoke(pcmData: ShortBuffer): ShortBuffer {
            println("Filter B: ${pcmData.remaining()}")
            return pcmData
        }
    }
}