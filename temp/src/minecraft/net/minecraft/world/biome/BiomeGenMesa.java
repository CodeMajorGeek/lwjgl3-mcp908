package net.minecraft.world.biome;

import java.util.Arrays;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeGenMesa extends BiomeGenBase {

   private byte[] field_150621_aC;
   private long field_150622_aD;
   private NoiseGeneratorPerlin field_150623_aE;
   private NoiseGeneratorPerlin field_150624_aF;
   private NoiseGeneratorPerlin field_150625_aG;
   private boolean field_150626_aH;
   private boolean field_150620_aI;
   private static final String __OBFID = "CL_00000176";


   public BiomeGenMesa(int p_i45380_1_, boolean p_i45380_2_, boolean p_i45380_3_) {
      super(p_i45380_1_);
      this.field_150626_aH = p_i45380_2_;
      this.field_150620_aI = p_i45380_3_;
      this.func_76745_m();
      this.func_76732_a(2.0F, 0.0F);
      this.field_76762_K.clear();
      this.field_76752_A = Blocks.field_150354_m;
      this.field_150604_aj = 1;
      this.field_76753_B = Blocks.field_150406_ce;
      this.field_76760_I.field_76832_z = -999;
      this.field_76760_I.field_76804_C = 20;
      this.field_76760_I.field_76799_E = 3;
      this.field_76760_I.field_76800_F = 5;
      this.field_76760_I.field_76802_A = 0;
      this.field_76762_K.clear();
      if(p_i45380_3_) {
         this.field_76760_I.field_76832_z = 5;
      }

   }

   public WorldGenAbstractTree func_150567_a(Random p_150567_1_) {
      return this.field_76757_N;
   }

   public int func_150571_c(int p_150571_1_, int p_150571_2_, int p_150571_3_) {
      return 10387789;
   }

   public int func_150558_b(int p_150558_1_, int p_150558_2_, int p_150558_3_) {
      return 9470285;
   }

   public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
      super.func_76728_a(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
   }

   public void func_150573_a(World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_) {
      if(this.field_150621_aC == null || this.field_150622_aD != p_150573_1_.func_72905_C()) {
         this.func_150619_a(p_150573_1_.func_72905_C());
      }

      if(this.field_150623_aE == null || this.field_150624_aF == null || this.field_150622_aD != p_150573_1_.func_72905_C()) {
         Random var9 = new Random(this.field_150622_aD);
         this.field_150623_aE = new NoiseGeneratorPerlin(var9, 4);
         this.field_150624_aF = new NoiseGeneratorPerlin(var9, 1);
      }

      this.field_150622_aD = p_150573_1_.func_72905_C();
      double var25 = 0.0D;
      int var11;
      int var12;
      if(this.field_150626_aH) {
         var11 = (p_150573_5_ & -16) + (p_150573_6_ & 15);
         var12 = (p_150573_6_ & -16) + (p_150573_5_ & 15);
         double var13 = Math.min(Math.abs(p_150573_7_), this.field_150623_aE.func_151601_a((double)var11 * 0.25D, (double)var12 * 0.25D));
         if(var13 > 0.0D) {
            double var15 = 0.001953125D;
            double var17 = Math.abs(this.field_150624_aF.func_151601_a((double)var11 * var15, (double)var12 * var15));
            var25 = var13 * var13 * 2.5D;
            double var19 = Math.ceil(var17 * 50.0D) + 14.0D;
            if(var25 > var19) {
               var25 = var19;
            }

            var25 += 64.0D;
         }
      }

      var11 = p_150573_5_ & 15;
      var12 = p_150573_6_ & 15;
      boolean var26 = true;
      Block var14 = Blocks.field_150406_ce;
      Block var27 = this.field_76753_B;
      int var16 = (int)(p_150573_7_ / 3.0D + 3.0D + p_150573_2_.nextDouble() * 0.25D);
      boolean var28 = Math.cos(p_150573_7_ / 3.0D * 3.141592653589793D) > 0.0D;
      int var18 = -1;
      boolean var29 = false;
      int var20 = p_150573_3_.length / 256;

      for(int var21 = 255; var21 >= 0; --var21) {
         int var22 = (var12 * 16 + var11) * var20 + var21;
         if((p_150573_3_[var22] == null || p_150573_3_[var22].func_149688_o() == Material.field_151579_a) && var21 < (int)var25) {
            p_150573_3_[var22] = Blocks.field_150348_b;
         }

         if(var21 <= 0 + p_150573_2_.nextInt(5)) {
            p_150573_3_[var22] = Blocks.field_150357_h;
         } else {
            Block var23 = p_150573_3_[var22];
            if(var23 != null && var23.func_149688_o() != Material.field_151579_a) {
               if(var23 == Blocks.field_150348_b) {
                  byte var24;
                  if(var18 == -1) {
                     var29 = false;
                     if(var16 <= 0) {
                        var14 = null;
                        var27 = Blocks.field_150348_b;
                     } else if(var21 >= 59 && var21 <= 64) {
                        var14 = Blocks.field_150406_ce;
                        var27 = this.field_76753_B;
                     }

                     if(var21 < 63 && (var14 == null || var14.func_149688_o() == Material.field_151579_a)) {
                        var14 = Blocks.field_150355_j;
                     }

                     var18 = var16 + Math.max(0, var21 - 63);
                     if(var21 >= 62) {
                        if(this.field_150620_aI && var21 > 86 + var16 * 2) {
                           if(var28) {
                              p_150573_3_[var22] = Blocks.field_150346_d;
                              p_150573_4_[var22] = 1;
                           } else {
                              p_150573_3_[var22] = Blocks.field_150349_c;
                           }
                        } else if(var21 > 66 + var16) {
                           var24 = 16;
                           if(var21 >= 64 && var21 <= 127) {
                              if(!var28) {
                                 var24 = this.func_150618_d(p_150573_5_, var21, p_150573_6_);
                              }
                           } else {
                              var24 = 1;
                           }

                           if(var24 < 16) {
                              p_150573_3_[var22] = Blocks.field_150406_ce;
                              p_150573_4_[var22] = (byte)var24;
                           } else {
                              p_150573_3_[var22] = Blocks.field_150405_ch;
                           }
                        } else {
                           p_150573_3_[var22] = this.field_76752_A;
                           p_150573_4_[var22] = (byte)this.field_150604_aj;
                           var29 = true;
                        }
                     } else {
                        p_150573_3_[var22] = var27;
                        if(var27 == Blocks.field_150406_ce) {
                           p_150573_4_[var22] = 1;
                        }
                     }
                  } else if(var18 > 0) {
                     --var18;
                     if(var29) {
                        p_150573_3_[var22] = Blocks.field_150406_ce;
                        p_150573_4_[var22] = 1;
                     } else {
                        var24 = this.func_150618_d(p_150573_5_, var21, p_150573_6_);
                        if(var24 < 16) {
                           p_150573_3_[var22] = Blocks.field_150406_ce;
                           p_150573_4_[var22] = var24;
                        } else {
                           p_150573_3_[var22] = Blocks.field_150405_ch;
                        }
                     }
                  }
               }
            } else {
               var18 = -1;
            }
         }
      }

   }

   private void func_150619_a(long p_150619_1_) {
      this.field_150621_aC = new byte[64];
      Arrays.fill(this.field_150621_aC, (byte)16);
      Random var3 = new Random(p_150619_1_);
      this.field_150625_aG = new NoiseGeneratorPerlin(var3, 1);

      int var4;
      for(var4 = 0; var4 < 64; ++var4) {
         var4 += var3.nextInt(5) + 1;
         if(var4 < 64) {
            this.field_150621_aC[var4] = 1;
         }
      }

      var4 = var3.nextInt(4) + 2;

      int var5;
      int var6;
      int var7;
      int var8;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var3.nextInt(3) + 1;
         var7 = var3.nextInt(64);

         for(var8 = 0; var7 + var8 < 64 && var8 < var6; ++var8) {
            this.field_150621_aC[var7 + var8] = 4;
         }
      }

      var5 = var3.nextInt(4) + 2;

      int var9;
      for(var6 = 0; var6 < var5; ++var6) {
         var7 = var3.nextInt(3) + 2;
         var8 = var3.nextInt(64);

         for(var9 = 0; var8 + var9 < 64 && var9 < var7; ++var9) {
            this.field_150621_aC[var8 + var9] = 12;
         }
      }

      var6 = var3.nextInt(4) + 2;

      for(var7 = 0; var7 < var6; ++var7) {
         var8 = var3.nextInt(3) + 1;
         var9 = var3.nextInt(64);

         for(int var10 = 0; var9 + var10 < 64 && var10 < var8; ++var10) {
            this.field_150621_aC[var9 + var10] = 14;
         }
      }

      var7 = var3.nextInt(3) + 3;
      var8 = 0;

      for(var9 = 0; var9 < var7; ++var9) {
         byte var12 = 1;
         var8 += var3.nextInt(16) + 4;

         for(int var11 = 0; var8 + var11 < 64 && var11 < var12; ++var11) {
            this.field_150621_aC[var8 + var11] = 0;
            if(var8 + var11 > 1 && var3.nextBoolean()) {
               this.field_150621_aC[var8 + var11 - 1] = 8;
            }

            if(var8 + var11 < 63 && var3.nextBoolean()) {
               this.field_150621_aC[var8 + var11 + 1] = 8;
            }
         }
      }

   }

   private byte func_150618_d(int p_150618_1_, int p_150618_2_, int p_150618_3_) {
      int var4 = (int)Math.round(this.field_150625_aG.func_151601_a((double)p_150618_1_ * 1.0D / 512.0D, (double)p_150618_1_ * 1.0D / 512.0D) * 2.0D);
      return this.field_150621_aC[(p_150618_2_ + var4 + 64) % 64];
   }

   protected BiomeGenBase func_150566_k() {
      boolean var1 = this.field_76756_M == BiomeGenBase.field_150589_Z.field_76756_M;
      BiomeGenMesa var2 = new BiomeGenMesa(this.field_76756_M + 128, var1, this.field_150620_aI);
      if(!var1) {
         var2.func_150570_a(field_150591_g);
         var2.func_76735_a(this.field_76791_y + " M");
      } else {
         var2.func_76735_a(this.field_76791_y + " (Bryce)");
      }

      var2.func_150557_a(this.field_76790_z, true);
      return var2;
   }
}
