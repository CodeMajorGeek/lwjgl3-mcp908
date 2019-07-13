package net.minecraft.client.audio;

import static org.lwjgl.openal.AL10.*;
import static org.lwjgl.openal.ALC10.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.ALC;
import org.lwjgl.openal.ALCCapabilities;
import org.lwjgl.openal.ALCapabilities;

import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EntityPlayer;

public class SoundManager {

	private static final String __OBFID = "CL_00001141";

	private long alContext;
	private long alDevice;

	private ALCCapabilities alcCapabilities;
	private ALCapabilities alCapabilities;

	private static final Logger LOGGER = LogManager.getLogger();
	private SoundHandler soundHandler;
	private GameSettings gameSettings;
	
	private List<ALAudioEvent> alAudioEvents = new ArrayList<ALAudioEvent>();

	public SoundManager(SoundHandler soundHandler, GameSettings gameSettings) {

		this.soundHandler = soundHandler;
		this.gameSettings = gameSettings;

		initializeOpenAL();

		LOGGER.info("SoundSystem created by CodeMajorGeek started !");
	}

	public void reloadSoundSystem() {

		cleanUpOpenAL();
		initializeOpenAL();

		LOGGER.info("SoundSystem reloaded !");
	}

	public void playSound(ISound sound) {
		
		ALAudioEvent alAudioEvent = new ALAudioEvent(sound, soundHandler);
		
		alSourcePlay(alAudioEvent.getSourcePointer());
		
		alAudioEvents.add(alAudioEvent);
	}

	public void addDelayedSound(ISound sound, int delay) {

	}

	public void setListener(EntityPlayer player, float val) {

	}

	public void pauseAllSounds() {

	}

	public void stopAllSounds() {

	}

	public void unloadSoundSystem() {
		
		cleanUpOpenAL();
		LOGGER.info("SoundSystem unloaded !");
	}

	public void updateAllSounds() {
		
		for(ALAudioEvent e : alAudioEvents)
			if(!e.isPlaying()) e.cleanUp();
	}

	public void resumeAllSounds() {

	}

	public void setSoundCategoryVolume(SoundCategory soundCategory, float level) {

	}

	public void stopSound(ISound sound) {

	}

	public boolean isSoundPlaying(ISound sound) {

		for(ALAudioEvent e : alAudioEvents)
			if(e.getSound().equals(sound)) 
				return e.isPlaying();
		return false;
	}

	private void initializeOpenAL() {

		final String defaultDeviceName = alcGetString(0, ALC_DEFAULT_DEVICE_SPECIFIER);
		alDevice = alcOpenDevice(defaultDeviceName);

		int[] attributes = { 0 };
		alContext = alcCreateContext(alDevice, attributes);
		alcMakeContextCurrent(alContext);

		alcCapabilities = ALC.createCapabilities(alDevice);
		alCapabilities = AL.createCapabilities(alcCapabilities);

		LOGGER.info("OpenAL initialized !");
	}

	private void cleanUpOpenAL() {
		
		for(ALAudioEvent e : alAudioEvents)
			e.cleanUp();
		
		alcDestroyContext(alContext);
		alcCloseDevice(alDevice);
	}
}
