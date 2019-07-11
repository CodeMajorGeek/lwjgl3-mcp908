package net.minecraft.world;

import net.minecraft.profiler.Profiler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.storage.DerivedWorldInfo;
import net.minecraft.world.storage.ISaveHandler;

public class WorldServerMulti extends WorldServer {

   private static final String __OBFID = "CL_00001430";


   public WorldServerMulti(MinecraftServer p_i45283_1_, ISaveHandler p_i45283_2_, String p_i45283_3_, int p_i45283_4_, WorldSettings p_i45283_5_, WorldServer p_i45283_6_, Profiler p_i45283_7_) {
      super(p_i45283_1_, p_i45283_2_, p_i45283_3_, p_i45283_4_, p_i45283_5_, p_i45283_7_);
      this.field_72988_C = p_i45283_6_.field_72988_C;
      this.field_96442_D = p_i45283_6_.func_96441_U();
      this.field_72986_A = new DerivedWorldInfo(p_i45283_6_.func_72912_H());
   }

   protected void func_73042_a() throws MinecraftException {}
}
