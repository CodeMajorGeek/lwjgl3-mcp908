package net.minecraft.world.biome;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class WorldChunkManager {

   private GenLayer field_76944_d;
   private GenLayer field_76945_e;
   private BiomeCache field_76942_f;
   private List field_76943_g;
   private static final String __OBFID = "CL_00000166";


   protected WorldChunkManager() {
      this.field_76942_f = new BiomeCache(this);
      this.field_76943_g = new ArrayList();
      this.field_76943_g.add(BiomeGenBase.field_76767_f);
      this.field_76943_g.add(BiomeGenBase.field_76772_c);
      this.field_76943_g.add(BiomeGenBase.field_76768_g);
      this.field_76943_g.add(BiomeGenBase.field_76784_u);
      this.field_76943_g.add(BiomeGenBase.field_76785_t);
      this.field_76943_g.add(BiomeGenBase.field_76782_w);
      this.field_76943_g.add(BiomeGenBase.field_76792_x);
   }

   public WorldChunkManager(long p_i1975_1_, WorldType p_i1975_3_) {
      this();
      GenLayer[] var4 = GenLayer.func_75901_a(p_i1975_1_, p_i1975_3_);
      this.field_76944_d = var4[0];
      this.field_76945_e = var4[1];
   }

   public WorldChunkManager(World p_i1976_1_) {
      this(p_i1976_1_.func_72905_C(), p_i1976_1_.func_72912_H().func_76067_t());
   }

   public List func_76932_a() {
      return this.field_76943_g;
   }

   public BiomeGenBase func_76935_a(int p_76935_1_, int p_76935_2_) {
      return this.field_76942_f.func_76837_b(p_76935_1_, p_76935_2_);
   }

   public float[] func_76936_a(float[] p_76936_1_, int p_76936_2_, int p_76936_3_, int p_76936_4_, int p_76936_5_) {
      IntCache.func_76446_a();
      if(p_76936_1_ == null || p_76936_1_.length < p_76936_4_ * p_76936_5_) {
         p_76936_1_ = new float[p_76936_4_ * p_76936_5_];
      }

      int[] var6 = this.field_76945_e.func_75904_a(p_76936_2_, p_76936_3_, p_76936_4_, p_76936_5_);

      for(int var7 = 0; var7 < p_76936_4_ * p_76936_5_; ++var7) {
         try {
            float var8 = (float)BiomeGenBase.func_150568_d(var6[var7]).func_76744_g() / 65536.0F;
            if(var8 > 1.0F) {
               var8 = 1.0F;
            }

            p_76936_1_[var7] = var8;
         } catch (Throwable var11) {
            CrashReport var9 = CrashReport.func_85055_a(var11, "Invalid Biome id");
            CrashReportCategory var10 = var9.func_85058_a("DownfallBlock");
            var10.func_71507_a("biome id", Integer.valueOf(var7));
            var10.func_71507_a("downfalls[] size", Integer.valueOf(p_76936_1_.length));
            var10.func_71507_a("x", Integer.valueOf(p_76936_2_));
            var10.func_71507_a("z", Integer.valueOf(p_76936_3_));
            var10.func_71507_a("w", Integer.valueOf(p_76936_4_));
            var10.func_71507_a("h", Integer.valueOf(p_76936_5_));
            throw new ReportedException(var9);
         }
      }

      return p_76936_1_;
   }

   public float func_76939_a(float p_76939_1_, int p_76939_2_) {
      return p_76939_1_;
   }

   public BiomeGenBase[] func_76937_a(BiomeGenBase[] p_76937_1_, int p_76937_2_, int p_76937_3_, int p_76937_4_, int p_76937_5_) {
      IntCache.func_76446_a();
      if(p_76937_1_ == null || p_76937_1_.length < p_76937_4_ * p_76937_5_) {
         p_76937_1_ = new BiomeGenBase[p_76937_4_ * p_76937_5_];
      }

      int[] var6 = this.field_76944_d.func_75904_a(p_76937_2_, p_76937_3_, p_76937_4_, p_76937_5_);

      try {
         for(int var7 = 0; var7 < p_76937_4_ * p_76937_5_; ++var7) {
            p_76937_1_[var7] = BiomeGenBase.func_150568_d(var6[var7]);
         }

         return p_76937_1_;
      } catch (Throwable var10) {
         CrashReport var8 = CrashReport.func_85055_a(var10, "Invalid Biome id");
         CrashReportCategory var9 = var8.func_85058_a("RawBiomeBlock");
         var9.func_71507_a("biomes[] size", Integer.valueOf(p_76937_1_.length));
         var9.func_71507_a("x", Integer.valueOf(p_76937_2_));
         var9.func_71507_a("z", Integer.valueOf(p_76937_3_));
         var9.func_71507_a("w", Integer.valueOf(p_76937_4_));
         var9.func_71507_a("h", Integer.valueOf(p_76937_5_));
         throw new ReportedException(var8);
      }
   }

   public BiomeGenBase[] func_76933_b(BiomeGenBase[] p_76933_1_, int p_76933_2_, int p_76933_3_, int p_76933_4_, int p_76933_5_) {
      return this.func_76931_a(p_76933_1_, p_76933_2_, p_76933_3_, p_76933_4_, p_76933_5_, true);
   }

   public BiomeGenBase[] func_76931_a(BiomeGenBase[] p_76931_1_, int p_76931_2_, int p_76931_3_, int p_76931_4_, int p_76931_5_, boolean p_76931_6_) {
      IntCache.func_76446_a();
      if(p_76931_1_ == null || p_76931_1_.length < p_76931_4_ * p_76931_5_) {
         p_76931_1_ = new BiomeGenBase[p_76931_4_ * p_76931_5_];
      }

      if(p_76931_6_ && p_76931_4_ == 16 && p_76931_5_ == 16 && (p_76931_2_ & 15) == 0 && (p_76931_3_ & 15) == 0) {
         BiomeGenBase[] var9 = this.field_76942_f.func_76839_e(p_76931_2_, p_76931_3_);
         System.arraycopy(var9, 0, p_76931_1_, 0, p_76931_4_ * p_76931_5_);
         return p_76931_1_;
      } else {
         int[] var7 = this.field_76945_e.func_75904_a(p_76931_2_, p_76931_3_, p_76931_4_, p_76931_5_);

         for(int var8 = 0; var8 < p_76931_4_ * p_76931_5_; ++var8) {
            p_76931_1_[var8] = BiomeGenBase.func_150568_d(var7[var8]);
         }

         return p_76931_1_;
      }
   }

   public boolean func_76940_a(int p_76940_1_, int p_76940_2_, int p_76940_3_, List p_76940_4_) {
      IntCache.func_76446_a();
      int var5 = p_76940_1_ - p_76940_3_ >> 2;
      int var6 = p_76940_2_ - p_76940_3_ >> 2;
      int var7 = p_76940_1_ + p_76940_3_ >> 2;
      int var8 = p_76940_2_ + p_76940_3_ >> 2;
      int var9 = var7 - var5 + 1;
      int var10 = var8 - var6 + 1;
      int[] var11 = this.field_76944_d.func_75904_a(var5, var6, var9, var10);

      try {
         for(int var12 = 0; var12 < var9 * var10; ++var12) {
            BiomeGenBase var16 = BiomeGenBase.func_150568_d(var11[var12]);
            if(!p_76940_4_.contains(var16)) {
               return false;
            }
         }

         return true;
      } catch (Throwable var15) {
         CrashReport var13 = CrashReport.func_85055_a(var15, "Invalid Biome id");
         CrashReportCategory var14 = var13.func_85058_a("Layer");
         var14.func_71507_a("Layer", this.field_76944_d.toString());
         var14.func_71507_a("x", Integer.valueOf(p_76940_1_));
         var14.func_71507_a("z", Integer.valueOf(p_76940_2_));
         var14.func_71507_a("radius", Integer.valueOf(p_76940_3_));
         var14.func_71507_a("allowed", p_76940_4_);
         throw new ReportedException(var13);
      }
   }

   public ChunkPosition func_150795_a(int p_150795_1_, int p_150795_2_, int p_150795_3_, List p_150795_4_, Random p_150795_5_) {
      IntCache.func_76446_a();
      int var6 = p_150795_1_ - p_150795_3_ >> 2;
      int var7 = p_150795_2_ - p_150795_3_ >> 2;
      int var8 = p_150795_1_ + p_150795_3_ >> 2;
      int var9 = p_150795_2_ + p_150795_3_ >> 2;
      int var10 = var8 - var6 + 1;
      int var11 = var9 - var7 + 1;
      int[] var12 = this.field_76944_d.func_75904_a(var6, var7, var10, var11);
      ChunkPosition var13 = null;
      int var14 = 0;

      for(int var15 = 0; var15 < var10 * var11; ++var15) {
         int var16 = var6 + var15 % var10 << 2;
         int var17 = var7 + var15 / var10 << 2;
         BiomeGenBase var18 = BiomeGenBase.func_150568_d(var12[var15]);
         if(p_150795_4_.contains(var18) && (var13 == null || p_150795_5_.nextInt(var14 + 1) == 0)) {
            var13 = new ChunkPosition(var16, 0, var17);
            ++var14;
         }
      }

      return var13;
   }

   public void func_76938_b() {
      this.field_76942_f.func_76838_a();
   }
}
