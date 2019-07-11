package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockStoneBrick extends Block {

   public static final String[] field_150142_a = new String[]{"default", "mossy", "cracked", "chiseled"};
   public static final String[] field_150141_b = new String[]{null, "mossy", "cracked", "carved"};
   private static final String __OBFID = "CL_00000318";


   public BlockStoneBrick() {
      super(Material.field_151576_e);
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   public int func_149692_a(int p_149692_1_) {
      return p_149692_1_;
   }

}
