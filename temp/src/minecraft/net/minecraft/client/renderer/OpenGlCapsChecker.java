package net.minecraft.client.renderer;

import org.lwjgl.opengl.GLContext;

public class OpenGlCapsChecker {

   private static final String __OBFID = "CL_00000649";


   public static boolean func_74371_a() {
      return GLContext.getCapabilities().GL_ARB_occlusion_query;
   }
}
