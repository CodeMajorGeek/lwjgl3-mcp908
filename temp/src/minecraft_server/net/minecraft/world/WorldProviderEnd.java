package net.minecraft.world;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderEnd;

public class WorldProviderEnd extends WorldProvider {

   private static final String __OBFID = "CL_00000389";


   public void func_76572_b() {
      this.field_76578_c = new WorldChunkManagerHell(BiomeGenBase.field_76779_k, 0.0F);
      this.field_76574_g = 1;
      this.field_76576_e = true;
   }

   public IChunkProvider func_76555_c() {
      return new ChunkProviderEnd(this.field_76579_a, this.field_76579_a.func_72905_C());
   }

   public float func_76563_a(long p_76563_1_, float p_76563_3_) {
      return 0.0F;
   }

   public boolean func_76567_e() {
      return false;
   }

   public boolean func_76569_d() {
      return false;
   }

   public boolean func_76566_a(int p_76566_1_, int p_76566_2_) {
      return this.field_76579_a.func_147474_b(p_76566_1_, p_76566_2_).func_149688_o().func_76230_c();
   }

   public ChunkCoordinates func_76554_h() {
      return new ChunkCoordinates(100, 50, 0);
   }

   public int func_76557_i() {
      return 50;
   }

   public String func_80007_l() {
      return "The End";
   }
}
