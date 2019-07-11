package net.minecraft.client.renderer;

import fr.lwjgl3binding.display.Display;

public class OpenGlCapsChecker
{
    private static final String __OBFID = "CL_00000649";

    /**
     * Checks if we support OpenGL occlusion.
     */
    public static boolean checkARBOcclusion()
    {
        return Display.getCapabilities().GL_ARB_occlusion_query;
    }
}
