package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockWood extends Block {

   public static final String[] field_150096_a = new String[]{"oak", "spruce", "birch", "jungle", "acacia", "big_oak"};
   private static final String __OBFID = "CL_00000335";


   public BlockWood() {
      super(Material.field_151575_d);
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   public int func_149692_a(int p_149692_1_) {
      return p_149692_1_;
   }

}
