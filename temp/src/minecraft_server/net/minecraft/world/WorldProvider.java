package net.minecraft.world;

import net.minecraft.init.Blocks;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderFlat;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.FlatGeneratorInfo;

public abstract class WorldProvider {

   public static final float[] field_111203_a = new float[]{1.0F, 0.75F, 0.5F, 0.25F, 0.0F, 0.25F, 0.5F, 0.75F};
   public World field_76579_a;
   public WorldType field_76577_b;
   public String field_82913_c;
   public WorldChunkManager field_76578_c;
   public boolean field_76575_d;
   public boolean field_76576_e;
   public float[] field_76573_f = new float[16];
   public int field_76574_g;
   private float[] field_76580_h = new float[4];
   private static final String __OBFID = "CL_00000386";


   public final void func_76558_a(World p_76558_1_) {
      this.field_76579_a = p_76558_1_;
      this.field_76577_b = p_76558_1_.func_72912_H().func_76067_t();
      this.field_82913_c = p_76558_1_.func_72912_H().func_82571_y();
      this.func_76572_b();
      this.func_76556_a();
   }

   protected void func_76556_a() {
      float var1 = 0.0F;

      for(int var2 = 0; var2 <= 15; ++var2) {
         float var3 = 1.0F - (float)var2 / 15.0F;
         this.field_76573_f[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
      }

   }

   protected void func_76572_b() {
      if(this.field_76579_a.func_72912_H().func_76067_t() == WorldType.field_77138_c) {
         FlatGeneratorInfo var1 = FlatGeneratorInfo.func_82651_a(this.field_76579_a.func_72912_H().func_82571_y());
         this.field_76578_c = new WorldChunkManagerHell(BiomeGenBase.func_150568_d(var1.func_82648_a()), 0.5F);
      } else {
         this.field_76578_c = new WorldChunkManager(this.field_76579_a);
      }

   }

   public IChunkProvider func_76555_c() {
      return (IChunkProvider)(this.field_76577_b == WorldType.field_77138_c?new ChunkProviderFlat(this.field_76579_a, this.field_76579_a.func_72905_C(), this.field_76579_a.func_72912_H().func_76089_r(), this.field_82913_c):new ChunkProviderGenerate(this.field_76579_a, this.field_76579_a.func_72905_C(), this.field_76579_a.func_72912_H().func_76089_r()));
   }

   public boolean func_76566_a(int p_76566_1_, int p_76566_2_) {
      return this.field_76579_a.func_147474_b(p_76566_1_, p_76566_2_) == Blocks.field_150349_c;
   }

   public float func_76563_a(long p_76563_1_, float p_76563_3_) {
      int var4 = (int)(p_76563_1_ % 24000L);
      float var5 = ((float)var4 + p_76563_3_) / 24000.0F - 0.25F;
      if(var5 < 0.0F) {
         ++var5;
      }

      if(var5 > 1.0F) {
         --var5;
      }

      float var6 = var5;
      var5 = 1.0F - (float)((Math.cos((double)var5 * 3.141592653589793D) + 1.0D) / 2.0D);
      var5 = var6 + (var5 - var6) / 3.0F;
      return var5;
   }

   public int func_76559_b(long p_76559_1_) {
      return (int)(p_76559_1_ / 24000L % 8L + 8L) % 8;
   }

   public boolean func_76569_d() {
      return true;
   }

   public boolean func_76567_e() {
      return true;
   }

   public static WorldProvider func_76570_a(int p_76570_0_) {
      return (WorldProvider)(p_76570_0_ == -1?new WorldProviderHell():(p_76570_0_ == 0?new WorldProviderSurface():(p_76570_0_ == 1?new WorldProviderEnd():null)));
   }

   public ChunkCoordinates func_76554_h() {
      return null;
   }

   public int func_76557_i() {
      return this.field_76577_b == WorldType.field_77138_c?4:64;
   }

   public abstract String func_80007_l();

}
