package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenIceSpike extends WorldGenerator {

   private static final String __OBFID = "CL_00000417";


   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      while(p_76484_1_.func_147437_c(p_76484_3_, p_76484_4_, p_76484_5_) && p_76484_4_ > 2) {
         --p_76484_4_;
      }

      if(p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_, p_76484_5_) != Blocks.field_150433_aE) {
         return false;
      } else {
         p_76484_4_ += p_76484_2_.nextInt(4);
         int var6 = p_76484_2_.nextInt(4) + 7;
         int var7 = var6 / 4 + p_76484_2_.nextInt(2);
         if(var7 > 1 && p_76484_2_.nextInt(60) == 0) {
            p_76484_4_ += 10 + p_76484_2_.nextInt(30);
         }

         int var8;
         int var10;
         int var11;
         for(var8 = 0; var8 < var6; ++var8) {
            float var9 = (1.0F - (float)var8 / (float)var6) * (float)var7;
            var10 = MathHelper.func_76123_f(var9);

            for(var11 = -var10; var11 <= var10; ++var11) {
               float var12 = (float)MathHelper.func_76130_a(var11) - 0.25F;

               for(int var13 = -var10; var13 <= var10; ++var13) {
                  float var14 = (float)MathHelper.func_76130_a(var13) - 0.25F;
                  if((var11 == 0 && var13 == 0 || var12 * var12 + var14 * var14 <= var9 * var9) && (var11 != -var10 && var11 != var10 && var13 != -var10 && var13 != var10 || p_76484_2_.nextFloat() <= 0.75F)) {
                     Block var15 = p_76484_1_.func_147439_a(p_76484_3_ + var11, p_76484_4_ + var8, p_76484_5_ + var13);
                     if(var15.func_149688_o() == Material.field_151579_a || var15 == Blocks.field_150346_d || var15 == Blocks.field_150433_aE || var15 == Blocks.field_150432_aD) {
                        this.func_150515_a(p_76484_1_, p_76484_3_ + var11, p_76484_4_ + var8, p_76484_5_ + var13, Blocks.field_150403_cj);
                     }

                     if(var8 != 0 && var10 > 1) {
                        var15 = p_76484_1_.func_147439_a(p_76484_3_ + var11, p_76484_4_ - var8, p_76484_5_ + var13);
                        if(var15.func_149688_o() == Material.field_151579_a || var15 == Blocks.field_150346_d || var15 == Blocks.field_150433_aE || var15 == Blocks.field_150432_aD) {
                           this.func_150515_a(p_76484_1_, p_76484_3_ + var11, p_76484_4_ - var8, p_76484_5_ + var13, Blocks.field_150403_cj);
                        }
                     }
                  }
               }
            }
         }

         var8 = var7 - 1;
         if(var8 < 0) {
            var8 = 0;
         } else if(var8 > 1) {
            var8 = 1;
         }

         for(int var16 = -var8; var16 <= var8; ++var16) {
            var10 = -var8;

            while(var10 <= var8) {
               var11 = p_76484_4_ - 1;
               int var17 = 50;
               if(Math.abs(var16) == 1 && Math.abs(var10) == 1) {
                  var17 = p_76484_2_.nextInt(5);
               }

               while(true) {
                  if(var11 > 50) {
                     Block var18 = p_76484_1_.func_147439_a(p_76484_3_ + var16, var11, p_76484_5_ + var10);
                     if(var18.func_149688_o() == Material.field_151579_a || var18 == Blocks.field_150346_d || var18 == Blocks.field_150433_aE || var18 == Blocks.field_150432_aD || var18 == Blocks.field_150403_cj) {
                        this.func_150515_a(p_76484_1_, p_76484_3_ + var16, var11, p_76484_5_ + var10, Blocks.field_150403_cj);
                        --var11;
                        --var17;
                        if(var17 <= 0) {
                           var11 -= p_76484_2_.nextInt(5) + 1;
                           var17 = p_76484_2_.nextInt(5);
                        }
                        continue;
                     }
                  }

                  ++var10;
                  break;
               }
            }
         }

         return true;
      }
   }
}
