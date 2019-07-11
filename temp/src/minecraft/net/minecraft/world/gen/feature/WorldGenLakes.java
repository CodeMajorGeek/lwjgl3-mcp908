package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenLakes extends WorldGenerator {

   private Block field_150556_a;
   private static final String __OBFID = "CL_00000418";


   public WorldGenLakes(Block p_i45455_1_) {
      this.field_150556_a = p_i45455_1_;
   }

   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      p_76484_3_ -= 8;

      for(p_76484_5_ -= 8; p_76484_4_ > 5 && p_76484_1_.func_147437_c(p_76484_3_, p_76484_4_, p_76484_5_); --p_76484_4_) {
         ;
      }

      if(p_76484_4_ <= 4) {
         return false;
      } else {
         p_76484_4_ -= 4;
         boolean[] var6 = new boolean[2048];
         int var7 = p_76484_2_.nextInt(4) + 4;

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            double var9 = p_76484_2_.nextDouble() * 6.0D + 3.0D;
            double var11 = p_76484_2_.nextDouble() * 4.0D + 2.0D;
            double var13 = p_76484_2_.nextDouble() * 6.0D + 3.0D;
            double var15 = p_76484_2_.nextDouble() * (16.0D - var9 - 2.0D) + 1.0D + var9 / 2.0D;
            double var17 = p_76484_2_.nextDouble() * (8.0D - var11 - 4.0D) + 2.0D + var11 / 2.0D;
            double var19 = p_76484_2_.nextDouble() * (16.0D - var13 - 2.0D) + 1.0D + var13 / 2.0D;

            for(int var21 = 1; var21 < 15; ++var21) {
               for(int var22 = 1; var22 < 15; ++var22) {
                  for(int var23 = 1; var23 < 7; ++var23) {
                     double var24 = ((double)var21 - var15) / (var9 / 2.0D);
                     double var26 = ((double)var23 - var17) / (var11 / 2.0D);
                     double var28 = ((double)var22 - var19) / (var13 / 2.0D);
                     double var30 = var24 * var24 + var26 * var26 + var28 * var28;
                     if(var30 < 1.0D) {
                        var6[(var21 * 16 + var22) * 8 + var23] = true;
                     }
                  }
               }
            }
         }

         int var10;
         int var32;
         boolean var34;
         for(var8 = 0; var8 < 16; ++var8) {
            for(var32 = 0; var32 < 16; ++var32) {
               for(var10 = 0; var10 < 8; ++var10) {
                  var34 = !var6[(var8 * 16 + var32) * 8 + var10] && (var8 < 15 && var6[((var8 + 1) * 16 + var32) * 8 + var10] || var8 > 0 && var6[((var8 - 1) * 16 + var32) * 8 + var10] || var32 < 15 && var6[(var8 * 16 + var32 + 1) * 8 + var10] || var32 > 0 && var6[(var8 * 16 + (var32 - 1)) * 8 + var10] || var10 < 7 && var6[(var8 * 16 + var32) * 8 + var10 + 1] || var10 > 0 && var6[(var8 * 16 + var32) * 8 + (var10 - 1)]);
                  if(var34) {
                     Material var12 = p_76484_1_.func_147439_a(p_76484_3_ + var8, p_76484_4_ + var10, p_76484_5_ + var32).func_149688_o();
                     if(var10 >= 4 && var12.func_76224_d()) {
                        return false;
                     }

                     if(var10 < 4 && !var12.func_76220_a() && p_76484_1_.func_147439_a(p_76484_3_ + var8, p_76484_4_ + var10, p_76484_5_ + var32) != this.field_150556_a) {
                        return false;
                     }
                  }
               }
            }
         }

         for(var8 = 0; var8 < 16; ++var8) {
            for(var32 = 0; var32 < 16; ++var32) {
               for(var10 = 0; var10 < 8; ++var10) {
                  if(var6[(var8 * 16 + var32) * 8 + var10]) {
                     p_76484_1_.func_147465_d(p_76484_3_ + var8, p_76484_4_ + var10, p_76484_5_ + var32, var10 >= 4?Blocks.field_150350_a:this.field_150556_a, 0, 2);
                  }
               }
            }
         }

         for(var8 = 0; var8 < 16; ++var8) {
            for(var32 = 0; var32 < 16; ++var32) {
               for(var10 = 4; var10 < 8; ++var10) {
                  if(var6[(var8 * 16 + var32) * 8 + var10] && p_76484_1_.func_147439_a(p_76484_3_ + var8, p_76484_4_ + var10 - 1, p_76484_5_ + var32) == Blocks.field_150346_d && p_76484_1_.func_72972_b(EnumSkyBlock.Sky, p_76484_3_ + var8, p_76484_4_ + var10, p_76484_5_ + var32) > 0) {
                     BiomeGenBase var35 = p_76484_1_.func_72807_a(p_76484_3_ + var8, p_76484_5_ + var32);
                     if(var35.field_76752_A == Blocks.field_150391_bh) {
                        p_76484_1_.func_147465_d(p_76484_3_ + var8, p_76484_4_ + var10 - 1, p_76484_5_ + var32, Blocks.field_150391_bh, 0, 2);
                     } else {
                        p_76484_1_.func_147465_d(p_76484_3_ + var8, p_76484_4_ + var10 - 1, p_76484_5_ + var32, Blocks.field_150349_c, 0, 2);
                     }
                  }
               }
            }
         }

         if(this.field_150556_a.func_149688_o() == Material.field_151587_i) {
            for(var8 = 0; var8 < 16; ++var8) {
               for(var32 = 0; var32 < 16; ++var32) {
                  for(var10 = 0; var10 < 8; ++var10) {
                     var34 = !var6[(var8 * 16 + var32) * 8 + var10] && (var8 < 15 && var6[((var8 + 1) * 16 + var32) * 8 + var10] || var8 > 0 && var6[((var8 - 1) * 16 + var32) * 8 + var10] || var32 < 15 && var6[(var8 * 16 + var32 + 1) * 8 + var10] || var32 > 0 && var6[(var8 * 16 + (var32 - 1)) * 8 + var10] || var10 < 7 && var6[(var8 * 16 + var32) * 8 + var10 + 1] || var10 > 0 && var6[(var8 * 16 + var32) * 8 + (var10 - 1)]);
                     if(var34 && (var10 < 4 || p_76484_2_.nextInt(2) != 0) && p_76484_1_.func_147439_a(p_76484_3_ + var8, p_76484_4_ + var10, p_76484_5_ + var32).func_149688_o().func_76220_a()) {
                        p_76484_1_.func_147465_d(p_76484_3_ + var8, p_76484_4_ + var10, p_76484_5_ + var32, Blocks.field_150348_b, 0, 2);
                     }
                  }
               }
            }
         }

         if(this.field_150556_a.func_149688_o() == Material.field_151586_h) {
            for(var8 = 0; var8 < 16; ++var8) {
               for(var32 = 0; var32 < 16; ++var32) {
                  byte var33 = 4;
                  if(p_76484_1_.func_72884_u(p_76484_3_ + var8, p_76484_4_ + var33, p_76484_5_ + var32)) {
                     p_76484_1_.func_147465_d(p_76484_3_ + var8, p_76484_4_ + var33, p_76484_5_ + var32, Blocks.field_150432_aD, 0, 2);
                  }
               }
            }
         }

         return true;
      }
   }
}
