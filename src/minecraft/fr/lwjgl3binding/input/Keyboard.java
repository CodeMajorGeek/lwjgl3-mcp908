package fr.lwjgl3binding.input;

import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.glfw.GLFWKeyCallback;

public class Keyboard {
	
	private static long windowId;
	private static boolean created = false;
	
	private static boolean next = false;
	private static boolean repeatEvents = false;
	
	private static int lastEventKeyId;
	private static int lastEventKeyScancode;
	private static int lastEventKeyState;
	
	public static void init(long windowId) {
		
		Keyboard.windowId = windowId;
		created = true;
		
		glfwSetKeyCallback(windowId, keyCallback);
	}
	
	public static void destroy() {
		
		keyCallback.free();
	}
	
	public static boolean next() {
		return next;
	}
	
	public static void enableRepeatEvents(boolean repeatEvents) {
		Keyboard.repeatEvents = repeatEvents;
	}
	
	public static int getEventKey() {
		next = false;
		return lastEventKeyId;
	}
	
	public static String getKeyName(int keyId) {
		return glfwGetKeyName(keyId, 0);
	}
	
	public static boolean getEventKeyState() {
		next = false;
		return lastEventKeyState == GLFW_PRESS;
	}
	
	public static char getEventCharacter() {
		return glfwGetKeyName(lastEventKeyId, lastEventKeyScancode).charAt(0);
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
	
	private static GLFWKeyCallback keyCallback = new GLFWKeyCallback() {

		@Override
		public void invoke(long window, int key, int scancode, int action, int mods) {
			
			lastEventKeyId = key;
			lastEventKeyScancode = scancode;
			lastEventKeyState = action;
			
			next = true;
		}
	};
}
