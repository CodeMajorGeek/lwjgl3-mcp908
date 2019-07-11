package org.jglrxavpok.audiokode

import org.jglrxavpok.audiokode.decoders.Decoders
import org.jglrxavpok.audiokode.decoders.DirectVorbisDecoder
import org.jglrxavpok.audiokode.decoders.DirectWaveDecoder
import org.jglrxavpok.audiokode.filters.AudioFilter
import org.jglrxavpok.audiokode.filters.NoFilter
import org.jglrxavpok.audiokode.finders.*
import org.lwjgl.openal.AL
import org.lwjgl.openal.AL10.*
import org.lwjgl.openal.ALC
import org.lwjgl.openal.ALC10.*
import org.lwjgl.openal.ALC10.ALC_DEFAULT_DEVICE_SPECIFIER
import org.lwjgl.openal.ALC10.alcGetString
import org.lwjgl.openal.ALC10.alcMakeContextCurrent
import java.nio.ByteBuffer
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.nio.ShortBuffer

open class SoundEngine: Disposable {

    val listener = Listener()
    private val finders = mutableListOf<AudioFinder>()
    private val sourcePool = Pool { createNewSource() }
    private val streamingSourcePool = Pool { createNewStreamingSource() }
    private val bufferPool = Pool { createNewBuffer() }
    private val autoDispose = mutableListOf<Source>()
    private val createdBuffers = hashSetOf<Buffer>()
    private val createdSources = hashSetOf<Source>()
    private var masterGain = 1f

    fun initWithDefaultOpenAL() {
        initWithOpenAL(alcGetString(0, ALC_DEFAULT_DEVICE_SPECIFIER))
    }

    fun initWithOpenAL(deviceName: String) {
        val device = alcOpenDevice(deviceName)
        val attributes = intArrayOf(0)
        val context = alcCreateContext(device, attributes)
        alcMakeContextCurrent(context)
        val alcCapabilities = ALC.createCapabilities(device)
        AL.createCapabilities(alcCapabilities)

        checkErrors("post AL init")

        init()
    }

    open fun init() {
        if( ! Decoders.contains(DirectWaveDecoder))
            Decoders.add(DirectWaveDecoder)
        if( ! Decoders.contains(DirectVorbisDecoder))
            Decoders.add(DirectVorbisDecoder)

        addFinder(ClasspathFinder)
        addFinder(DiskRelativeFinder)
        addFinder(DiskAbsoluteFinder)
    }

    fun addFinder(finder: AudioFinder) {
        finders += finder
    }

    /**
     * Prepares a source ready to play a background sound
     */
    fun backgroundSound(identifier: String, looping: Boolean, filter: AudioFilter = NoFilter, gain: Float = 1f, pitch: Float = 1f): Source {
        val source = prepareDirectSource(identifier, looping, filter)
        source.gain = gain
        source.pitch = pitch
        alSourcei(source.alID, AL_SOURCE_RELATIVE, AL_TRUE) // the source will play exactly where the listener is
        return source
    }

    private fun prepareDirectSource(identifier: String, looping: Boolean, filter: AudioFilter): Source {
        val source = newSource()
        source.identifier = identifier
        source.looping = looping
        checkErrors("post generation")

        val buffer = decodeDirect(identifier, filter)
        checkErrors("post decode")

        source.bindBuffer(buffer)
        checkErrors("post bind")
        return source
    }

    fun sound(identifier: String, looping: Boolean, filter: AudioFilter = NoFilter, position: Vector3D = NullVector, velocity: Vector3D = NullVector, gain: Float = 1f, pitch: Float = 1f): Source {
        val source = prepareDirectSource(identifier, looping, filter)
        source.position = position
        source.velocity = velocity
        source.gain = gain
        source.pitch = pitch
        alSourcei(source.alID, AL_SOURCE_RELATIVE, AL_FALSE)
        return source
    }

    fun backgroundMusic(identifier: String, looping: Boolean, filter: AudioFilter = NoFilter, gain: Float = 1f, pitch: Float = 1f): Source {
        val source = prepareStreamingSource(identifier, looping, filter)
        source.gain = gain
        source.pitch = pitch
        alSourcei(source.alID, AL_SOURCE_RELATIVE, AL_TRUE) // the source will play exactly where the listener is
        return source
    }

    fun music(identifier: String, looping: Boolean, filter: AudioFilter = NoFilter, position: Vector3D = NullVector, velocity: Vector3D = NullVector, gain: Float = 1f, pitch: Float = 1f): Source {
        val source = prepareStreamingSource(identifier, looping, filter)
        source.position = position
        source.velocity = velocity
        source.gain = gain
        source.pitch = pitch
        alSourcei(source.alID, AL_SOURCE_RELATIVE, AL_FALSE)
        return source
    }

    private fun prepareStreamingSource(identifier: String, looping: Boolean, filter: AudioFilter = NoFilter): Source {
        val infos = prepareStreaming(identifier, filter)

        val source = newStreamingSource()
        source.info = infos

        source.identifier = identifier
        source.looping = looping

        source.prepareRotatingBuffers()
        return source
    }

    /**
     * Plays a background sound immediately and set its resources up to be disposed after being played
     */
    fun quickplayBackgroundSound(identifier: String, filter: AudioFilter = NoFilter, gain: Float = 1f, pitch: Float = 1f) {
        val source = backgroundSound(identifier, false, filter, gain, pitch)
        autoDispose += source
        source.play()
    }

    private fun random(list: List<String>): String {
        val index = Math.round(Math.random() * (list.size-1)).toInt()
        return list[index]
    }

    fun quickplayMusic(identifiers: List<String>, looping: Boolean = false, filter: AudioFilter = NoFilter, position: Vector3D = NullVector, velocity: Vector3D = NullVector, gain: Float = 1f, pitch: Float = 1f) {
        val chosen = random(identifiers)
        quickplayMusic(chosen, looping, filter, position, velocity, gain, pitch)
    }

    fun quickplayMusic(identifier: String, looping: Boolean = false, filter: AudioFilter = NoFilter, position: Vector3D = NullVector, velocity: Vector3D = NullVector, gain: Float = 1f, pitch: Float = 1f) {
        val source = music(identifier, looping, filter, position, velocity, gain, pitch)
        autoDispose += source
        source.play()
    }

    fun quickplaySound(identifiers: List<String>, filter: AudioFilter = NoFilter, position: Vector3D = NullVector, velocity: Vector3D = NullVector, gain: Float = 1f, pitch: Float = 1f) {
        val chosen = random(identifiers)
        quickplaySound(chosen, filter, position, velocity, gain, pitch)
    }

    fun quickplaySound(identifier: String, filter: AudioFilter = NoFilter, position: Vector3D = NullVector, velocity: Vector3D = NullVector, gain: Float = 1f, pitch: Float = 1f) {
        val source = sound(identifier, false, filter, position, velocity, gain, pitch)
        autoDispose += source
        source.play()
    }

    fun quickplayBackgroundMusic(identifiers: List<String>, looping: Boolean = false, filter: AudioFilter = NoFilter, gain: Float = 1f, pitch: Float = 1f) {
        val chosen = random(identifiers)
        quickplayBackgroundMusic(chosen, looping, filter, gain, pitch)
    }

    fun quickplayBackgroundMusic(identifier: String, looping: Boolean = false, filter: AudioFilter = NoFilter, gain: Float = 1f, pitch: Float = 1f) {
        val source = backgroundMusic(identifier, looping, filter, gain, pitch)
        autoDispose += source
        source.play()
    }

    private fun prepareStreaming(identifier: String, filter: AudioFilter): StreamingInfo {
        val validFinders = finders.reversed()
                .map { it.findAudio(identifier) }
                .filter { it != AUDIO_NOT_FOUND }
        if(validFinders.isNotEmpty()) {
            val finder = validFinders[0]
            val infos = finder.streamDecoder.prepare(finder.inputProvider().buffered(), filter)
            infos.inputProvider = finder.inputProvider
            return infos
        }
        throw IOException("Could not find audio file with identifier $identifier")
    }

    private fun decodeDirect(identifier: String, filter: AudioFilter): Buffer {
        finders.reversed()
                .map { it.findAudio(identifier) }
                .filter { it != AUDIO_NOT_FOUND }
                .forEach { return it.decoder.decode(readData(it.inputProvider()), this, filter) } // remember: this 'return' returns from decodeDirect!
        throw IOException("Could not find audio file with identifier $identifier")
    }

    private fun readData(input: InputStream): ByteArray {
        val buffer = ByteArrayOutputStream()
        var nRead: Int
        val data = ByteArray(1024)
        do {
            nRead = input.read(data, 0, data.size)
            if(nRead != -1)
                buffer.write(data, 0, nRead)
        } while (nRead != -1)

        buffer.flush()
        return buffer.toByteArray()
    }

    private fun createNewSource(): Source {
        val source = Source(this)
        val id = alGenSources()
        source.alID = id
        source.gain = 1f
        source.position = NullVector
        source.velocity = NullVector
        source.pitch = 1f

        createdSources += source
        return source
    }

    private fun createNewStreamingSource(): StreamingSource {
        val source = StreamingSource(this)
        val id = alGenSources()
        source.alID = id
        source.gain = 1f
        source.position = NullVector
        source.velocity = NullVector
        source.pitch = 1f

        createdSources += source
        return source
    }

    open fun update() {
        updateListener()

        autoDispose.filterNot { it.isPlaying() }.forEach(Source::dispose)
        autoDispose.removeIf { ! it.isPlaying() }

        createdSources.forEach { it.update() }
    }

    fun updateListener() {
        alListener3f(AL_POSITION, listener.position.x, listener.position.y, listener.position.z)
        alListener3f(AL_VELOCITY, listener.velocity.x, listener.velocity.y, listener.velocity.z)
        alListenerfv(AL_POSITION, floatArrayOf(
                listener.lookDirection.x, listener.lookDirection.y, listener.lookDirection.z,
                listener.up.x, listener.up.y, listener.up.z
        ))
    }

    internal fun sourcePosition(source: Source, value: Vector3D) {
        alSource3f(source.alID, AL_POSITION, value.x, value.y, value.z)
    }

    internal fun sourceVelocity(source: Source, value: Vector3D) {
        alSource3f(source.alID, AL_VELOCITY, value.x, value.y, value.z)
    }

    internal fun sourceGain(source: Source, value: Float) {
        alSourcef(source.alID, AL_GAIN, value*masterGain)
    }

    internal fun sourcePitch(source: Source, value: Float) {
        alSourcef(source.alID, AL_PITCH, value)
    }

    internal fun sourceLooping(source: Source, value: Boolean) {
        alSourcei(source.alID, AL_LOOPING, if(value) AL_TRUE else AL_FALSE)
    }

    internal fun bindSourceBuffer(source: Source, buffer: Buffer) {
        alSourcei(source.alID, AL_BUFFER, buffer.alID)
    }

    internal fun upload(buffer: Buffer, raw: ByteArray, filter: AudioFilter) {
        val dataBuffer = ByteBuffer.allocateDirect(raw.size)
        dataBuffer.put(raw)
        dataBuffer.flip()
        upload(buffer, dataBuffer, filter)
    }

    internal fun upload(buffer: Buffer, raw: ShortBuffer, filter: AudioFilter) {
        val format = buffer.format
        val frequency = buffer.frequency
        bufferData(buffer.alID, format, filter(raw), frequency)
    }

    fun bufferData(alID: Int, format: Int, pcmData: ShortBuffer, frequency: Int, filter: AudioFilter = NoFilter) {
        alBufferData(alID, format, filter(pcmData), frequency)
    }

    fun bufferData(alID: Int, format: Int, pcmData: ByteBuffer, frequency: Int, filter: AudioFilter = NoFilter) {
        bufferData(alID, format, pcmData.asShortBuffer(), frequency, filter)
    }

    fun upload(buffer: Buffer, raw: ByteBuffer, filter: AudioFilter) {
        upload(buffer, raw.asShortBuffer(), filter)
    }

    fun createNewBuffer(): Buffer {
        val buffer = Buffer(alGenBuffers(), this)
        createdBuffers += buffer
        return buffer
    }

    fun newStreamingSource(): StreamingSource {
        return streamingSourcePool.get()
    }

    fun newSource(): Source {
        return sourcePool.get()
    }

    fun newBuffer(): Buffer {
        return bufferPool.get()
    }

    internal fun disposeSource(source: Source) {
        sourcePool.add(source)
        alSourcei(source.alID, AL_BUFFER, 0)
    }

    internal fun disposeBuffer(buffer: Buffer) {
        bufferPool.add(buffer)
    }

    override fun dispose() {
        alDeleteSources(createdSources.map { it.alID }.toIntArray())
        alDeleteBuffers(createdBuffers.map { it.alID }.toIntArray())
    }

    fun isSomethingPlaying(): Boolean {
        return createdSources.any { it.isPlaying() }
    }

    fun getMasterGain() = masterGain

    fun setMasterGain(master: Float) {
        masterGain = master
        createdSources.forEach {
            sourceGain(it, it.gain) // update source gain
        }
    }
}
