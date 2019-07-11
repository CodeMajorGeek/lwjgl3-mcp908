package fr.lwjgl3binding.display;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.glfw.GLFWWindowSizeCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.opengl.GLUtil;

import fr.lwjgl3binding.input.Keyboard;
import fr.lwjgl3binding.input.Mouse;

public class Display {

	private static long windowId;

	private static boolean created = false;
	private static boolean wasResized = false;

	private static final IntBuffer WIDTH = memAllocInt(1);
	private static final IntBuffer HEIGHT = memAllocInt(1);

	public static void create(int width, int height, String title) throws RuntimeException {

		if (!glfwInit())
			throw new RuntimeException("Can't initialize GLFW !");

		windowId = glfwCreateWindow(width, height, title, NULL, NULL);

		if (windowId == NULL) {

			glfwTerminate();
			throw new RuntimeException("Can't create GLFW window !");
		} else
			created = true;

		glfwSetWindowSizeCallback(windowId, windowSizeCallback);

		glfwMakeContextCurrent(windowId);
		GL.createCapabilities();

		WIDTH.put(width).flip();
		HEIGHT.put(height).flip();

		GLUtil.setupDebugMessageCallback();
	}

	public static void destroy() {

		glfwSetWindowShouldClose(windowId, true);
		glfwDestroyWindow(windowId);
		windowSizeCallback.free();
		Keyboard.destroy();
		Mouse.destroy();
		GL.destroy();
		glfwTerminate();

		memFree(WIDTH);
		memFree(HEIGHT);
	}

	public static void sync(int limitFrameRate) {
		glfwWindowHint(GLFW_REFRESH_RATE, limitFrameRate);
	}

	public static void update() {

		glfwSwapBuffers(windowId);
		glfwPollEvents();
	}

	public static void setFullscreen(boolean fullscreen) {

	}

	public static void setResizable(boolean resizable) {
		glfwWindowHint(GLFW_RESIZABLE, resizable ? GLFW_TRUE : GLFW_FALSE);
	}

	public static void setVSyncEnabled(boolean vSyncEnabled) {
		glfwSwapInterval(vSyncEnabled ? GLFW_TRUE : GLFW_FALSE);
	}

	public static void setTitle(String title) {
		glfwSetWindowTitle(windowId, title);
	}

	public static void setSize(int width, int height) {
		
		glfwSetWindowSize(windowId, width, height);
		setWidth(width);
		setHeight(height);
	}

	public static void setIcon(ByteBuffer[] iconBuffers) {

	}

	private static void setWidth(int width) {

		WIDTH.rewind();
		WIDTH.put(width).flip();
	}

	private static void setHeight(int height) {

		HEIGHT.rewind();
		HEIGHT.put(height).flip();
	}

	public static int getWidth() {
		return WIDTH.get(1);
	}

	public static int getHeight() {
		return HEIGHT.get(1);
	}
	
	//TODO: temp fix value
	public static int getFrequency() {
		return 60;
	}
	
	public static GLCapabilities getCapabilities() {
		return GL.getCapabilities();
	}
	
	public static boolean isCreated() {
		return created;
	}

	public static boolean isCloseRequested() {
		return glfwWindowShouldClose(windowId);
	}

	public static boolean wasResized() {
		return wasResized;
	}

	private static GLFWWindowSizeCallback windowSizeCallback = new GLFWWindowSizeCallback() {

		@Override
		public void invoke(long window, int width, int height) {

			WIDTH.rewind();
			WIDTH.put(width).flip();

			HEIGHT.rewind();
			HEIGHT.put(height).flip();

			wasResized = true;
		}
	};
}
