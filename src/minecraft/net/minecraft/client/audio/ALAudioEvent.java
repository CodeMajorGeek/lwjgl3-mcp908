package net.minecraft.client.audio;

import static org.lwjgl.openal.AL10.*;
import static org.lwjgl.stb.STBVorbis.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.io.File;
import java.io.IOException;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

import net.minecraft.client.Minecraft;

public class ALAudioEvent {
	
	private ISound sound;
	private SoundHandler soundHandler;
	
	private int sourcePointer;
	private int bufferPointer;
	
	public ALAudioEvent(ISound sound, SoundHandler soundHandler) {
		
		this.sound = sound;
		this.soundHandler = soundHandler;
		
		loadSoundInOpenAL(sound);
	}

	private void loadSoundInOpenAL(ISound sound) {

		File soundFile = getSoundFile(sound);

		IntBuffer channelsBuffer = memAllocInt(1);
		IntBuffer sampleRateBuffer = memAllocInt(1);

		int format = -1;
		ShortBuffer rawAudioBuffer = stb_vorbis_decode_filename(soundFile.getAbsolutePath(), channelsBuffer,
				sampleRateBuffer);

		if (channelsBuffer.get(0) == 1)
			format = AL_FORMAT_MONO16;
		else if (channelsBuffer.get(0) == 2)
			format = AL_FORMAT_STEREO16;

		int bufferPointer = alGenBuffers();
		alBufferData(bufferPointer, format, rawAudioBuffer, sampleRateBuffer.get(0));

		memFree(rawAudioBuffer);
		
		int sourcePointer = alGenSources();
		alSourcei(sourcePointer, AL_BUFFER, bufferPointer);
		
		this.bufferPointer = bufferPointer;
		this.sourcePointer = sourcePointer;
	}
	
	private File getSoundFile(ISound sound) {

		SoundEventAccessorComposite soundEventAcessorComposite = soundHandler.func_147680_a(sound.func_147650_b());
		SoundPoolEntry soundPoolEntry = soundEventAcessorComposite.func_148720_g();

		try {

			return Minecraft.getMinecraft().getDefaultRessourcePack().getFile(soundPoolEntry.func_148652_a());
		} catch (IOException e) {

			e.printStackTrace();
			return null;
		}
	}
	
	public void cleanUp() {
		
		alDeleteSources(sourcePointer);
		alDeleteBuffers(bufferPointer);
	}
	
	public int getSourcePointer() {
		return sourcePointer;
	}
	
	public int getBufferPointer() {
		return bufferPointer;
	}
	
	public ISound getSound() {
		return sound;
	}
	
	public boolean isPlaying() { 
		return alGetSourcei(getSourcePointer(), AL_SOURCE_STATE) == AL_PLAYING;
	}
}