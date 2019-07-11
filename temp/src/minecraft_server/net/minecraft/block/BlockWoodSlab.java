package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BlockWoodSlab extends BlockSlab {

   public static final String[] field_150005_b = new String[]{"oak", "spruce", "birch", "jungle", "acacia", "big_oak"};
   private static final String __OBFID = "CL_00000337";


   public BlockWoodSlab(boolean p_i45437_1_) {
      super(p_i45437_1_, Material.field_151575_d);
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Item.func_150898_a(Blocks.field_150376_bx);
   }

   protected ItemStack func_149644_j(int p_149644_1_) {
      return new ItemStack(Item.func_150898_a(Blocks.field_150376_bx), 2, p_149644_1_ & 7);
   }

   public String func_150002_b(int p_150002_1_) {
      if(p_150002_1_ < 0 || p_150002_1_ >= field_150005_b.length) {
         p_150002_1_ = 0;
      }

      return super.func_149739_a() + "." + field_150005_b[p_150002_1_];
   }

}
