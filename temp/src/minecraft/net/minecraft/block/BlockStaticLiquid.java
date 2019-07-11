package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BlockStaticLiquid extends BlockLiquid {

   private static final String __OBFID = "CL_00000315";


   protected BlockStaticLiquid(Material p_i45429_1_) {
      super(p_i45429_1_);
      this.func_149675_a(false);
      if(p_i45429_1_ == Material.field_151587_i) {
         this.func_149675_a(true);
      }

   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      super.func_149695_a(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_5_);
      if(p_149695_1_.func_147439_a(p_149695_2_, p_149695_3_, p_149695_4_) == this) {
         this.func_149818_n(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
      }

   }

   private void func_149818_n(World p_149818_1_, int p_149818_2_, int p_149818_3_, int p_149818_4_) {
      int var5 = p_149818_1_.func_72805_g(p_149818_2_, p_149818_3_, p_149818_4_);
      p_149818_1_.func_147465_d(p_149818_2_, p_149818_3_, p_149818_4_, Block.func_149729_e(Block.func_149682_b(this) - 1), var5, 2);
      p_149818_1_.func_147464_a(p_149818_2_, p_149818_3_, p_149818_4_, Block.func_149729_e(Block.func_149682_b(this) - 1), this.func_149738_a(p_149818_1_));
   }

   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      if(this.field_149764_J == Material.field_151587_i) {
         int var6 = p_149674_5_.nextInt(3);

         int var7;
         for(var7 = 0; var7 < var6; ++var7) {
            p_149674_2_ += p_149674_5_.nextInt(3) - 1;
            ++p_149674_3_;
            p_149674_4_ += p_149674_5_.nextInt(3) - 1;
            Block var8 = p_149674_1_.func_147439_a(p_149674_2_, p_149674_3_, p_149674_4_);
            if(var8.field_149764_J == Material.field_151579_a) {
               if(this.func_149817_o(p_149674_1_, p_149674_2_ - 1, p_149674_3_, p_149674_4_) || this.func_149817_o(p_149674_1_, p_149674_2_ + 1, p_149674_3_, p_149674_4_) || this.func_149817_o(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_ - 1) || this.func_149817_o(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_ + 1) || this.func_149817_o(p_149674_1_, p_149674_2_, p_149674_3_ - 1, p_149674_4_) || this.func_149817_o(p_149674_1_, p_149674_2_, p_149674_3_ + 1, p_149674_4_)) {
                  p_149674_1_.func_147449_b(p_149674_2_, p_149674_3_, p_149674_4_, Blocks.field_150480_ab);
                  return;
               }
            } else if(var8.field_149764_J.func_76230_c()) {
               return;
            }
         }

         if(var6 == 0) {
            var7 = p_149674_2_;
            int var10 = p_149674_4_;

            for(int var9 = 0; var9 < 3; ++var9) {
               p_149674_2_ = var7 + p_149674_5_.nextInt(3) - 1;
               p_149674_4_ = var10 + p_149674_5_.nextInt(3) - 1;
               if(p_149674_1_.func_147437_c(p_149674_2_, p_149674_3_ + 1, p_149674_4_) && this.func_149817_o(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_)) {
                  p_149674_1_.func_147449_b(p_149674_2_, p_149674_3_ + 1, p_149674_4_, Blocks.field_150480_ab);
               }
            }
         }
      }

   }

   private boolean func_149817_o(World p_149817_1_, int p_149817_2_, int p_149817_3_, int p_149817_4_) {
      return p_149817_1_.func_147439_a(p_149817_2_, p_149817_3_, p_149817_4_).func_149688_o().func_76217_h();
   }
}
