package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;

public class WorldGenShrub extends WorldGenTrees {

   private int field_150528_a;
   private int field_150527_b;
   private static final String __OBFID = "CL_00000411";


   public WorldGenShrub(int p_i2015_1_, int p_i2015_2_) {
      super(false);
      this.field_150527_b = p_i2015_1_;
      this.field_150528_a = p_i2015_2_;
   }

   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      Block var6;
      while(((var6 = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_, p_76484_5_)).func_149688_o() == Material.field_151579_a || var6.func_149688_o() == Material.field_151584_j) && p_76484_4_ > 0) {
         --p_76484_4_;
      }

      Block var7 = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_, p_76484_5_);
      if(var7 == Blocks.field_150346_d || var7 == Blocks.field_150349_c) {
         ++p_76484_4_;
         this.func_150516_a(p_76484_1_, p_76484_3_, p_76484_4_, p_76484_5_, Blocks.field_150364_r, this.field_150527_b);

         for(int var8 = p_76484_4_; var8 <= p_76484_4_ + 2; ++var8) {
            int var9 = var8 - p_76484_4_;
            int var10 = 2 - var9;

            for(int var11 = p_76484_3_ - var10; var11 <= p_76484_3_ + var10; ++var11) {
               int var12 = var11 - p_76484_3_;

               for(int var13 = p_76484_5_ - var10; var13 <= p_76484_5_ + var10; ++var13) {
                  int var14 = var13 - p_76484_5_;
                  if((Math.abs(var12) != var10 || Math.abs(var14) != var10 || p_76484_2_.nextInt(2) != 0) && !p_76484_1_.func_147439_a(var11, var8, var13).func_149730_j()) {
                     this.func_150516_a(p_76484_1_, var11, var8, var13, Blocks.field_150362_t, this.field_150528_a);
                  }
               }
            }
         }
      }

      return true;
   }
}
