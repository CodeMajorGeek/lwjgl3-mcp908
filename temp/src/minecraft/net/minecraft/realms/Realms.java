package net.minecraft.realms;

import com.mojang.authlib.GameProfile;
import java.net.Proxy;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.realms.RealmsScreen;
import net.minecraft.util.Session;
import net.minecraft.world.WorldSettings;

public class Realms {

   private static final String __OBFID = "CL_00001892";


   public static boolean isTouchScreen() {
      return Minecraft.func_71410_x().field_71474_y.field_85185_A;
   }

   public static Proxy getProxy() {
      return Minecraft.func_71410_x().func_110437_J();
   }

   public static String sessionId() {
      Session var0 = Minecraft.func_71410_x().func_110432_I();
      return var0 == null?null:var0.func_111286_b();
   }

   public static String userName() {
      Session var0 = Minecraft.func_71410_x().func_110432_I();
      return var0 == null?null:var0.func_111285_a();
   }

   public static long currentTimeMillis() {
      return Minecraft.func_71386_F();
   }

   public static String getSessionId() {
      return Minecraft.func_71410_x().func_110432_I().func_111286_b();
   }

   public static String getName() {
      return Minecraft.func_71410_x().func_110432_I().func_111285_a();
   }

   public static String uuidToName(String p_uuidToName_0_) {
      return Minecraft.func_71410_x().func_152347_ac().fillProfileProperties(new GameProfile(UUID.fromString(p_uuidToName_0_.replaceAll("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})", "$1-$2-$3-$4-$5")), (String)null), false).getName();
   }

   public static void setScreen(RealmsScreen p_setScreen_0_) {
      Minecraft.func_71410_x().func_147108_a(p_setScreen_0_.getProxy());
   }

   public static String getGameDirectoryPath() {
      return Minecraft.func_71410_x().field_71412_D.getAbsolutePath();
   }

   public static int survivalId() {
      return WorldSettings.GameType.SURVIVAL.func_77148_a();
   }

   public static int creativeId() {
      return WorldSettings.GameType.CREATIVE.func_77148_a();
   }

   public static int adventureId() {
      return WorldSettings.GameType.ADVENTURE.func_77148_a();
   }
}
