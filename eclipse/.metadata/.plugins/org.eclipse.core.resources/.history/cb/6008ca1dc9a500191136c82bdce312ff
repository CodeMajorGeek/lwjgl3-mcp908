package fr.lwjgl3binding.input;

import static org.lwjgl.glfw.GLFW.*;

public class Keyboard {
	
	private static long windowId;
	private static boolean created = false;
	
	private static boolean next = false;
	private static boolean repeatEvents = false;
	
	private static int lastEventKeyId;
	private static int lastEventKeyState;
	
	public static void init(long windowId) {
		
		Keyboard.windowId = windowId;
		created = true;
	}
	
	public static void destroy() {
		
	}
	
	public static boolean next() {
		
		if(!next)
			return next;
		else
			next = false;
		return true;
	}
	
	public static void enableRepeatEvents(boolean repeatEvents) {
		Keyboard.repeatEvents = repeatEvents;
	}
	
	public static int getEventKey() {
		return lastEventKeyId;
	}
	
	//TODO: temp fix char
	public static String getKeyName(int keyId) {
		return "z";
	}
	
	public static boolean getEventKeyState() {
		return lastEventKeyState == GLFW_PRESS;
	}
	
	//TODO: temp fix char
	public static char getEventCharacter() {
		return 'z';
	}
	
	public static boolean isKeyDown(int keyId) {
		return  glfwGetKey(windowId, keyId) == GLFW_PRESS;
	}
	
	public static boolean isRepeatEvent() {
		return repeatEvents;
	}
	
	public static boolean isCreated() {
		return created;
	}
}
