package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenIcePath extends WorldGenerator {

   private Block field_150555_a;
   private int field_150554_b;
   private static final String __OBFID = "CL_00000416";


   public WorldGenIcePath(int p_i45454_1_) {
      this.field_150555_a = Blocks.field_150403_cj;
      this.field_150554_b = p_i45454_1_;
   }

   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      while(p_76484_1_.func_147437_c(p_76484_3_, p_76484_4_, p_76484_5_) && p_76484_4_ > 2) {
         --p_76484_4_;
      }

      if(p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_, p_76484_5_) != Blocks.field_150433_aE) {
         return false;
      } else {
         int var6 = p_76484_2_.nextInt(this.field_150554_b - 2) + 2;
         byte var7 = 1;

         for(int var8 = p_76484_3_ - var6; var8 <= p_76484_3_ + var6; ++var8) {
            for(int var9 = p_76484_5_ - var6; var9 <= p_76484_5_ + var6; ++var9) {
               int var10 = var8 - p_76484_3_;
               int var11 = var9 - p_76484_5_;
               if(var10 * var10 + var11 * var11 <= var6 * var6) {
                  for(int var12 = p_76484_4_ - var7; var12 <= p_76484_4_ + var7; ++var12) {
                     Block var13 = p_76484_1_.func_147439_a(var8, var12, var9);
                     if(var13 == Blocks.field_150346_d || var13 == Blocks.field_150433_aE || var13 == Blocks.field_150432_aD) {
                        p_76484_1_.func_147465_d(var8, var12, var9, this.field_150555_a, 0, 2);
                     }
                  }
               }
            }
         }

         return true;
      }
   }
}
