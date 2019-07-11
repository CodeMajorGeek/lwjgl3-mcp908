package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class BlockStainedGlass extends BlockBreakable {

   private static final IIcon[] field_149998_a = new IIcon[16];
   private static final String __OBFID = "CL_00000312";


   public BlockStainedGlass(Material p_i45427_1_) {
      super("glass", p_i45427_1_, false);
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   public int func_149692_a(int p_149692_1_) {
      return p_149692_1_;
   }

   public int func_149745_a(Random p_149745_1_) {
      return 0;
   }

   protected boolean func_149700_E() {
      return true;
   }

   public boolean func_149686_d() {
      return false;
   }

}
