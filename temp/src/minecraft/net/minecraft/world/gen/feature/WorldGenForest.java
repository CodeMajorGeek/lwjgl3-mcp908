package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenForest extends WorldGenAbstractTree {

   private boolean field_150531_a;
   private static final String __OBFID = "CL_00000401";


   public WorldGenForest(boolean p_i45449_1_, boolean p_i45449_2_) {
      super(p_i45449_1_);
      this.field_150531_a = p_i45449_2_;
   }

   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      int var6 = p_76484_2_.nextInt(3) + 5;
      if(this.field_150531_a) {
         var6 += p_76484_2_.nextInt(7);
      }

      boolean var7 = true;
      if(p_76484_4_ >= 1 && p_76484_4_ + var6 + 1 <= 256) {
         int var10;
         int var11;
         for(int var8 = p_76484_4_; var8 <= p_76484_4_ + 1 + var6; ++var8) {
            byte var9 = 1;
            if(var8 == p_76484_4_) {
               var9 = 0;
            }

            if(var8 >= p_76484_4_ + 1 + var6 - 2) {
               var9 = 2;
            }

            for(var10 = p_76484_3_ - var9; var10 <= p_76484_3_ + var9 && var7; ++var10) {
               for(var11 = p_76484_5_ - var9; var11 <= p_76484_5_ + var9 && var7; ++var11) {
                  if(var8 >= 0 && var8 < 256) {
                     Block var12 = p_76484_1_.func_147439_a(var10, var8, var11);
                     if(!this.func_150523_a(var12)) {
                        var7 = false;
                     }
                  } else {
                     var7 = false;
                  }
               }
            }
         }

         if(!var7) {
            return false;
         } else {
            Block var17 = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_);
            if((var17 == Blocks.field_150349_c || var17 == Blocks.field_150346_d || var17 == Blocks.field_150458_ak) && p_76484_4_ < 256 - var6 - 1) {
               this.func_150515_a(p_76484_1_, p_76484_3_, p_76484_4_ - 1, p_76484_5_, Blocks.field_150346_d);

               int var18;
               for(var18 = p_76484_4_ - 3 + var6; var18 <= p_76484_4_ + var6; ++var18) {
                  var10 = var18 - (p_76484_4_ + var6);
                  var11 = 1 - var10 / 2;

                  for(int var20 = p_76484_3_ - var11; var20 <= p_76484_3_ + var11; ++var20) {
                     int var13 = var20 - p_76484_3_;

                     for(int var14 = p_76484_5_ - var11; var14 <= p_76484_5_ + var11; ++var14) {
                        int var15 = var14 - p_76484_5_;
                        if(Math.abs(var13) != var11 || Math.abs(var15) != var11 || p_76484_2_.nextInt(2) != 0 && var10 != 0) {
                           Block var16 = p_76484_1_.func_147439_a(var20, var18, var14);
                           if(var16.func_149688_o() == Material.field_151579_a || var16.func_149688_o() == Material.field_151584_j) {
                              this.func_150516_a(p_76484_1_, var20, var18, var14, Blocks.field_150362_t, 2);
                           }
                        }
                     }
                  }
               }

               for(var18 = 0; var18 < var6; ++var18) {
                  Block var19 = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ + var18, p_76484_5_);
                  if(var19.func_149688_o() == Material.field_151579_a || var19.func_149688_o() == Material.field_151584_j) {
                     this.func_150516_a(p_76484_1_, p_76484_3_, p_76484_4_ + var18, p_76484_5_, Blocks.field_150364_r, 2);
                  }
               }

               return true;
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }
}
