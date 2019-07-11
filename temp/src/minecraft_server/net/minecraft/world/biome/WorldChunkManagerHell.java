package net.minecraft.world.biome;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;

public class WorldChunkManagerHell extends WorldChunkManager {

   private BiomeGenBase field_76947_d;
   private float field_76946_f;
   private static final String __OBFID = "CL_00000169";


   public WorldChunkManagerHell(BiomeGenBase p_i45374_1_, float p_i45374_2_) {
      this.field_76947_d = p_i45374_1_;
      this.field_76946_f = p_i45374_2_;
   }

   public BiomeGenBase func_76935_a(int p_76935_1_, int p_76935_2_) {
      return this.field_76947_d;
   }

   public BiomeGenBase[] func_76937_a(BiomeGenBase[] p_76937_1_, int p_76937_2_, int p_76937_3_, int p_76937_4_, int p_76937_5_) {
      if(p_76937_1_ == null || p_76937_1_.length < p_76937_4_ * p_76937_5_) {
         p_76937_1_ = new BiomeGenBase[p_76937_4_ * p_76937_5_];
      }

      Arrays.fill(p_76937_1_, 0, p_76937_4_ * p_76937_5_, this.field_76947_d);
      return p_76937_1_;
   }

   public float[] func_76936_a(float[] p_76936_1_, int p_76936_2_, int p_76936_3_, int p_76936_4_, int p_76936_5_) {
      if(p_76936_1_ == null || p_76936_1_.length < p_76936_4_ * p_76936_5_) {
         p_76936_1_ = new float[p_76936_4_ * p_76936_5_];
      }

      Arrays.fill(p_76936_1_, 0, p_76936_4_ * p_76936_5_, this.field_76946_f);
      return p_76936_1_;
   }

   public BiomeGenBase[] func_76933_b(BiomeGenBase[] p_76933_1_, int p_76933_2_, int p_76933_3_, int p_76933_4_, int p_76933_5_) {
      if(p_76933_1_ == null || p_76933_1_.length < p_76933_4_ * p_76933_5_) {
         p_76933_1_ = new BiomeGenBase[p_76933_4_ * p_76933_5_];
      }

      Arrays.fill(p_76933_1_, 0, p_76933_4_ * p_76933_5_, this.field_76947_d);
      return p_76933_1_;
   }

   public BiomeGenBase[] func_76931_a(BiomeGenBase[] p_76931_1_, int p_76931_2_, int p_76931_3_, int p_76931_4_, int p_76931_5_, boolean p_76931_6_) {
      return this.func_76933_b(p_76931_1_, p_76931_2_, p_76931_3_, p_76931_4_, p_76931_5_);
   }

   public ChunkPosition func_150795_a(int p_150795_1_, int p_150795_2_, int p_150795_3_, List p_150795_4_, Random p_150795_5_) {
      return p_150795_4_.contains(this.field_76947_d)?new ChunkPosition(p_150795_1_ - p_150795_3_ + p_150795_5_.nextInt(p_150795_3_ * 2 + 1), 0, p_150795_2_ - p_150795_3_ + p_150795_5_.nextInt(p_150795_3_ * 2 + 1)):null;
   }

   public boolean func_76940_a(int p_76940_1_, int p_76940_2_, int p_76940_3_, List p_76940_4_) {
      return p_76940_4_.contains(this.field_76947_d);
   }
}
