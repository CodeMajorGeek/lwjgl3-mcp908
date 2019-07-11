package net.minecraft.world.gen.layer;

import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayerAddIsland;
import net.minecraft.world.gen.layer.GenLayerAddMushroomIsland;
import net.minecraft.world.gen.layer.GenLayerAddSnow;
import net.minecraft.world.gen.layer.GenLayerBiome;
import net.minecraft.world.gen.layer.GenLayerBiomeEdge;
import net.minecraft.world.gen.layer.GenLayerDeepOcean;
import net.minecraft.world.gen.layer.GenLayerEdge;
import net.minecraft.world.gen.layer.GenLayerFuzzyZoom;
import net.minecraft.world.gen.layer.GenLayerHills;
import net.minecraft.world.gen.layer.GenLayerIsland;
import net.minecraft.world.gen.layer.GenLayerRareBiome;
import net.minecraft.world.gen.layer.GenLayerRemoveTooMuchOcean;
import net.minecraft.world.gen.layer.GenLayerRiver;
import net.minecraft.world.gen.layer.GenLayerRiverInit;
import net.minecraft.world.gen.layer.GenLayerRiverMix;
import net.minecraft.world.gen.layer.GenLayerShore;
import net.minecraft.world.gen.layer.GenLayerSmooth;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public abstract class GenLayer {

   private long field_75907_b;
   protected GenLayer field_75909_a;
   private long field_75908_c;
   protected long field_75906_d;
   private static final String __OBFID = "CL_00000559";


   public static GenLayer[] func_75901_a(long p_75901_0_, WorldType p_75901_2_) {
      boolean var3 = false;
      GenLayerIsland var4 = new GenLayerIsland(1L);
      GenLayerFuzzyZoom var11 = new GenLayerFuzzyZoom(2000L, var4);
      GenLayerAddIsland var12 = new GenLayerAddIsland(1L, var11);
      GenLayerZoom var13 = new GenLayerZoom(2001L, var12);
      var12 = new GenLayerAddIsland(2L, var13);
      var12 = new GenLayerAddIsland(50L, var12);
      var12 = new GenLayerAddIsland(70L, var12);
      GenLayerRemoveTooMuchOcean var14 = new GenLayerRemoveTooMuchOcean(2L, var12);
      GenLayerAddSnow var15 = new GenLayerAddSnow(2L, var14);
      var12 = new GenLayerAddIsland(3L, var15);
      GenLayerEdge var16 = new GenLayerEdge(2L, var12, GenLayerEdge.Mode.COOL_WARM);
      var16 = new GenLayerEdge(2L, var16, GenLayerEdge.Mode.HEAT_ICE);
      var16 = new GenLayerEdge(3L, var16, GenLayerEdge.Mode.SPECIAL);
      var13 = new GenLayerZoom(2002L, var16);
      var13 = new GenLayerZoom(2003L, var13);
      var12 = new GenLayerAddIsland(4L, var13);
      GenLayerAddMushroomIsland var17 = new GenLayerAddMushroomIsland(5L, var12);
      GenLayerDeepOcean var18 = new GenLayerDeepOcean(4L, var17);
      GenLayer var19 = GenLayerZoom.func_75915_a(1000L, var18, 0);
      byte var5 = 4;
      if(p_75901_2_ == WorldType.field_77135_d) {
         var5 = 6;
      }

      if(var3) {
         var5 = 4;
      }

      GenLayer var6 = GenLayerZoom.func_75915_a(1000L, var19, 0);
      GenLayerRiverInit var20 = new GenLayerRiverInit(100L, var6);
      Object var7 = new GenLayerBiome(200L, var19, p_75901_2_);
      if(!var3) {
         GenLayer var23 = GenLayerZoom.func_75915_a(1000L, (GenLayer)var7, 2);
         var7 = new GenLayerBiomeEdge(1000L, var23);
      }

      GenLayer var8 = GenLayerZoom.func_75915_a(1000L, var20, 2);
      GenLayerHills var24 = new GenLayerHills(1000L, (GenLayer)var7, var8);
      var6 = GenLayerZoom.func_75915_a(1000L, var20, 2);
      var6 = GenLayerZoom.func_75915_a(1000L, var6, var5);
      GenLayerRiver var21 = new GenLayerRiver(1L, var6);
      GenLayerSmooth var22 = new GenLayerSmooth(1000L, var21);
      var7 = new GenLayerRareBiome(1001L, var24);

      for(int var9 = 0; var9 < var5; ++var9) {
         var7 = new GenLayerZoom((long)(1000 + var9), (GenLayer)var7);
         if(var9 == 0) {
            var7 = new GenLayerAddIsland(3L, (GenLayer)var7);
         }

         if(var9 == 1) {
            var7 = new GenLayerShore(1000L, (GenLayer)var7);
         }
      }

      GenLayerSmooth var25 = new GenLayerSmooth(1000L, (GenLayer)var7);
      GenLayerRiverMix var26 = new GenLayerRiverMix(100L, var25, var22);
      GenLayerVoronoiZoom var10 = new GenLayerVoronoiZoom(10L, var26);
      var26.func_75905_a(p_75901_0_);
      var10.func_75905_a(p_75901_0_);
      return new GenLayer[]{var26, var10, var26};
   }

   public GenLayer(long p_i2125_1_) {
      this.field_75906_d = p_i2125_1_;
      this.field_75906_d *= this.field_75906_d * 6364136223846793005L + 1442695040888963407L;
      this.field_75906_d += p_i2125_1_;
      this.field_75906_d *= this.field_75906_d * 6364136223846793005L + 1442695040888963407L;
      this.field_75906_d += p_i2125_1_;
      this.field_75906_d *= this.field_75906_d * 6364136223846793005L + 1442695040888963407L;
      this.field_75906_d += p_i2125_1_;
   }

   public void func_75905_a(long p_75905_1_) {
      this.field_75907_b = p_75905_1_;
      if(this.field_75909_a != null) {
         this.field_75909_a.func_75905_a(p_75905_1_);
      }

      this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
      this.field_75907_b += this.field_75906_d;
      this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
      this.field_75907_b += this.field_75906_d;
      this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
      this.field_75907_b += this.field_75906_d;
   }

   public void func_75903_a(long p_75903_1_, long p_75903_3_) {
      this.field_75908_c = this.field_75907_b;
      this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
      this.field_75908_c += p_75903_1_;
      this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
      this.field_75908_c += p_75903_3_;
      this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
      this.field_75908_c += p_75903_1_;
      this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
      this.field_75908_c += p_75903_3_;
   }

   protected int func_75902_a(int p_75902_1_) {
      int var2 = (int)((this.field_75908_c >> 24) % (long)p_75902_1_);
      if(var2 < 0) {
         var2 += p_75902_1_;
      }

      this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
      this.field_75908_c += this.field_75907_b;
      return var2;
   }

   public abstract int[] func_75904_a(int var1, int var2, int var3, int var4);

   protected static boolean func_151616_a(final int p_151616_0_, final int p_151616_1_) {
      if(p_151616_0_ == p_151616_1_) {
         return true;
      } else if(p_151616_0_ != BiomeGenBase.field_150607_aa.field_76756_M && p_151616_0_ != BiomeGenBase.field_150608_ab.field_76756_M) {
         try {
            return BiomeGenBase.func_150568_d(p_151616_0_) != null && BiomeGenBase.func_150568_d(p_151616_1_) != null?BiomeGenBase.func_150568_d(p_151616_0_).func_150569_a(BiomeGenBase.func_150568_d(p_151616_1_)):false;
         } catch (Throwable var5) {
            CrashReport var3 = CrashReport.func_85055_a(var5, "Comparing biomes");
            CrashReportCategory var4 = var3.func_85058_a("Biomes being compared");
            var4.func_71507_a("Biome A ID", Integer.valueOf(p_151616_0_));
            var4.func_71507_a("Biome B ID", Integer.valueOf(p_151616_1_));
            var4.func_71500_a("Biome A", new Callable() {

               private static final String __OBFID = "CL_00000560";

               public String call() {
                  return String.valueOf(BiomeGenBase.func_150568_d(p_151616_0_));
               }
               // $FF: synthetic method
               public Object call() {
                  return this.call();
               }
            });
            var4.func_71500_a("Biome B", new Callable() {

               private static final String __OBFID = "CL_00000561";

               public String call() {
                  return String.valueOf(BiomeGenBase.func_150568_d(p_151616_1_));
               }
               // $FF: synthetic method
               public Object call() {
                  return this.call();
               }
            });
            throw new ReportedException(var3);
         }
      } else {
         return p_151616_1_ == BiomeGenBase.field_150607_aa.field_76756_M || p_151616_1_ == BiomeGenBase.field_150608_ab.field_76756_M;
      }
   }

   protected static boolean func_151618_b(int p_151618_0_) {
      return p_151618_0_ == BiomeGenBase.field_76771_b.field_76756_M || p_151618_0_ == BiomeGenBase.field_150575_M.field_76756_M || p_151618_0_ == BiomeGenBase.field_76776_l.field_76756_M;
   }

   protected int func_151619_a(int ... p_151619_1_) {
      return p_151619_1_[this.func_75902_a(p_151619_1_.length)];
   }

   protected int func_151617_b(int p_151617_1_, int p_151617_2_, int p_151617_3_, int p_151617_4_) {
      return p_151617_2_ == p_151617_3_ && p_151617_3_ == p_151617_4_?p_151617_2_:(p_151617_1_ == p_151617_2_ && p_151617_1_ == p_151617_3_?p_151617_1_:(p_151617_1_ == p_151617_2_ && p_151617_1_ == p_151617_4_?p_151617_1_:(p_151617_1_ == p_151617_3_ && p_151617_1_ == p_151617_4_?p_151617_1_:(p_151617_1_ == p_151617_2_ && p_151617_3_ != p_151617_4_?p_151617_1_:(p_151617_1_ == p_151617_3_ && p_151617_2_ != p_151617_4_?p_151617_1_:(p_151617_1_ == p_151617_4_ && p_151617_2_ != p_151617_3_?p_151617_1_:(p_151617_2_ == p_151617_3_ && p_151617_1_ != p_151617_4_?p_151617_2_:(p_151617_2_ == p_151617_4_ && p_151617_1_ != p_151617_3_?p_151617_2_:(p_151617_3_ == p_151617_4_ && p_151617_1_ != p_151617_2_?p_151617_3_:this.func_151619_a(new int[]{p_151617_1_, p_151617_2_, p_151617_3_, p_151617_4_}))))))))));
   }
}
