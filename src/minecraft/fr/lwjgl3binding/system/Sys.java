package fr.lwjgl3binding.system;

import static org.lwjgl.glfw.GLFW.*;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Sys {

	public static long getTime() {
		return (long) glfwGetTime();
	}
	
	public static void openURL(String url) throws IOException, URISyntaxException {
		
		if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
		    Desktop.getDesktop().browse(new URI(url));
		}
	}

}
