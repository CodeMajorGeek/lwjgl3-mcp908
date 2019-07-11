package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockSandStone extends Block {

   public static final String[] field_150157_a = new String[]{"default", "chiseled", "smooth"};
   private static final String[] field_150156_b = new String[]{"normal", "carved", "smooth"};
   private static final String __OBFID = "CL_00000304";


   public BlockSandStone() {
      super(Material.field_151576_e);
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   public int func_149692_a(int p_149692_1_) {
      return p_149692_1_;
   }

}
