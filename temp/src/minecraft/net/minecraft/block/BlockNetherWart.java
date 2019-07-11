package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockNetherWart extends BlockBush {

   private IIcon[] field_149883_a;
   private static final String __OBFID = "CL_00000274";


   protected BlockNetherWart() {
      this.func_149675_a(true);
      float var1 = 0.5F;
      this.func_149676_a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.25F, 0.5F + var1);
      this.func_149647_a((CreativeTabs)null);
   }

   protected boolean func_149854_a(Block p_149854_1_) {
      return p_149854_1_ == Blocks.field_150425_aM;
   }

   public boolean func_149718_j(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
      return this.func_149854_a(p_149718_1_.func_147439_a(p_149718_2_, p_149718_3_ - 1, p_149718_4_));
   }

   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      int var6 = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_);
      if(var6 < 3 && p_149674_5_.nextInt(10) == 0) {
         ++var6;
         p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, var6, 2);
      }

      super.func_149674_a(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      return p_149691_2_ >= 3?this.field_149883_a[2]:(p_149691_2_ > 0?this.field_149883_a[1]:this.field_149883_a[0]);
   }

   public int func_149645_b() {
      return 6;
   }

   public void func_149690_a(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
      if(!p_149690_1_.field_72995_K) {
         int var8 = 1;
         if(p_149690_5_ >= 3) {
            var8 = 2 + p_149690_1_.field_73012_v.nextInt(3);
            if(p_149690_7_ > 0) {
               var8 += p_149690_1_.field_73012_v.nextInt(p_149690_7_ + 1);
            }
         }

         for(int var9 = 0; var9 < var8; ++var9) {
            this.func_149642_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, new ItemStack(Items.field_151075_bm));
         }

      }
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return null;
   }

   public int func_149745_a(Random p_149745_1_) {
      return 0;
   }

   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
      return Items.field_151075_bm;
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149883_a = new IIcon[3];

      for(int var2 = 0; var2 < this.field_149883_a.length; ++var2) {
         this.field_149883_a[var2] = p_149651_1_.func_94245_a(this.func_149641_N() + "_stage_" + var2);
      }

   }
}
