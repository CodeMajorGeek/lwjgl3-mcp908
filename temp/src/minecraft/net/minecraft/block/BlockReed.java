package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockReed extends Block {

   private static final String __OBFID = "CL_00000300";


   protected BlockReed() {
      super(Material.field_151585_k);
      float var1 = 0.375F;
      this.func_149676_a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 1.0F, 0.5F + var1);
      this.func_149675_a(true);
   }

   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      if(p_149674_1_.func_147439_a(p_149674_2_, p_149674_3_ - 1, p_149674_4_) == Blocks.field_150436_aH || this.func_150170_e(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_)) {
         if(p_149674_1_.func_147437_c(p_149674_2_, p_149674_3_ + 1, p_149674_4_)) {
            int var6;
            for(var6 = 1; p_149674_1_.func_147439_a(p_149674_2_, p_149674_3_ - var6, p_149674_4_) == this; ++var6) {
               ;
            }

            if(var6 < 3) {
               int var7 = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_);
               if(var7 == 15) {
                  p_149674_1_.func_147449_b(p_149674_2_, p_149674_3_ + 1, p_149674_4_, this);
                  p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, 0, 4);
               } else {
                  p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, var7 + 1, 4);
               }
            }
         }

      }
   }

   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
      Block var5 = p_149742_1_.func_147439_a(p_149742_2_, p_149742_3_ - 1, p_149742_4_);
      return var5 == this?true:(var5 != Blocks.field_150349_c && var5 != Blocks.field_150346_d && var5 != Blocks.field_150354_m?false:(p_149742_1_.func_147439_a(p_149742_2_ - 1, p_149742_3_ - 1, p_149742_4_).func_149688_o() == Material.field_151586_h?true:(p_149742_1_.func_147439_a(p_149742_2_ + 1, p_149742_3_ - 1, p_149742_4_).func_149688_o() == Material.field_151586_h?true:(p_149742_1_.func_147439_a(p_149742_2_, p_149742_3_ - 1, p_149742_4_ - 1).func_149688_o() == Material.field_151586_h?true:p_149742_1_.func_147439_a(p_149742_2_, p_149742_3_ - 1, p_149742_4_ + 1).func_149688_o() == Material.field_151586_h))));
   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      this.func_150170_e(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
   }

   protected final boolean func_150170_e(World p_150170_1_, int p_150170_2_, int p_150170_3_, int p_150170_4_) {
      if(!this.func_149718_j(p_150170_1_, p_150170_2_, p_150170_3_, p_150170_4_)) {
         this.func_149697_b(p_150170_1_, p_150170_2_, p_150170_3_, p_150170_4_, p_150170_1_.func_72805_g(p_150170_2_, p_150170_3_, p_150170_4_), 0);
         p_150170_1_.func_147468_f(p_150170_2_, p_150170_3_, p_150170_4_);
         return false;
      } else {
         return true;
      }
   }

   public boolean func_149718_j(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
      return this.func_149742_c(p_149718_1_, p_149718_2_, p_149718_3_, p_149718_4_);
   }

   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
      return null;
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Items.field_151120_aE;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public int func_149645_b() {
      return 1;
   }

   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
      return Items.field_151120_aE;
   }

   public int func_149720_d(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
      return p_149720_1_.func_72807_a(p_149720_2_, p_149720_4_).func_150558_b(p_149720_2_, p_149720_3_, p_149720_4_);
   }
}
