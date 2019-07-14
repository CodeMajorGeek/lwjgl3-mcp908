package fr.lwjgl3binding.input;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.nio.DoubleBuffer;

import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWWindowSizeCallback;

import fr.lwjgl3binding.display.Display;

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
	
	private static int eventX;
	private static int eventY;

	public static void init(long windowId) {

		Mouse.windowId = windowId;

		glfwSetCursorPosCallback(windowId, cursorPosCallback);
		glfwSetMouseButtonCallback(windowId, mouseButtonCallback);
		
		created = true;
	}

	public static void destroy() {

		cursorPosCallback.free();
		mouseButtonCallback.free();
	}

	public static boolean next() {
		return next;
	}

	public static void setCursorPosition(int x, int y) {

		Mouse.x = x;
		Mouse.y = y;
		glfwSetCursorPos(windowId, x, y);
		dx = 0;
		dy = 0;
	}

	public static void setGrabbed(boolean grabbed) {

		glfwSetInputMode(windowId, GLFW_CURSOR, grabbed ? GLFW_CURSOR_HIDDEN : GLFW_CURSOR_NORMAL);

		if (grabbed)
			setCursorPosition(Display.getWidth() / 2, Display.getHeight() / 2);

		Mouse.grabbed = grabbed;
	}

	public static int getEventButton() {
		next = false;
		return lastEventButtonId;
	}

	public static boolean getEventButtonState() {
		next = false;
		return lastEventButtonState == GLFW_PRESS;
	}

	public static int getEventDWheel() {
		next = false;
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
		return eventX;
	}

	public static int getEventY() {
		return eventY;
	}

	private static GLFWCursorPosCallback cursorPosCallback = new GLFWCursorPosCallback() {

		@Override
		public void invoke(long window, double x, double y) {

			Mouse.x = (int) x;
			Mouse.y = (int) y;
			
			if (grabbed) {

				dx += x;
				dy += y;

				setCursorPosition(Display.getWidth() / 2, Display.getHeight() / 2);
			}
		}
	};
	
	private static GLFWMouseButtonCallback mouseButtonCallback = new GLFWMouseButtonCallback() {

		@Override
		public void invoke(long window, int button, int action, int mods) {
			
			lastEventButtonId = button;
			lastEventButtonState = action;
			
			DoubleBuffer xPos = memAllocDouble(1);
			DoubleBuffer yPos = memAllocDouble(1);

			glfwGetCursorPos(windowId, xPos, yPos);
			
			eventX = (int) xPos.get();
			eventY = (int) yPos.get();
			
			memFree(xPos);
			memFree(yPos);
			
			next = true;
		}		
	};
}
