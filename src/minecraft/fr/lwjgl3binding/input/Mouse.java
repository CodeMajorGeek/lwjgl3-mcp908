package fr.lwjgl3binding.input;

import static org.lwjgl.glfw.GLFW.*;

public class Mouse {

	private static long windowId;
	private static boolean created = false;

	private static boolean next = false;
	private static boolean grabbed = false;

	private static int lastEventButtonId;
	private static int lastEventButtonState;

	private static int currentEventDWheel;
	private static int DWheel;
	
	private static int x;
	private static int y;
	private static int dx;
	private static int dy;

	public static void init(long windowId) {
		Mouse.windowId = windowId;
		created = true;
	}
	
	public static void destroy() {
		
	}
	
	public static boolean next() {

		if (!next)
			return next;
		else
			next = false;
		return true;
	}
	
	public static void setCursorPosition(int x, int y) {
		
		Mouse.x = x;
		Mouse.y = y;
		glfwSetCursorPos(windowId, x, y);
	}
	
	public static void setGrabbed(boolean grabbed) {
		Mouse.grabbed = grabbed;
	}
	
	public static int getEventButton() {
		return lastEventButtonId;
	}

	public static boolean getEventButtonState() {
		return lastEventButtonState == GLFW_PRESS;
	}

	public static int getEventDWheel() {
		return currentEventDWheel;
	}
	
	public static int getDWheel() {
		return DWheel;
	}
	
	public static boolean isCreated() {
		return created;
	}
	
	public static boolean isButtonDown(int buttonId) {
		return glfwGetMouseButton(windowId, buttonId) == GLFW_PRESS;
	}
	
	public static int getX() {
		return x;
	}
	
	public static int getY() {
		return y;
	}
	
	public static int getDX() {
		return dx;
	}
	
	public static int getDY() {
		return dy;
	}
	
	public static int getEventX() {
		return x;
	}
	
	public static int getEventY() {
		return y;
	}
}
