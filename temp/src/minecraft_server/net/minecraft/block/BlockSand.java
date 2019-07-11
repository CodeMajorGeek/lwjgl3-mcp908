package net.minecraft.block;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.MapColor;

public class BlockSand extends BlockFalling {

   public static final String[] field_149838_a = new String[]{"default", "red"};
   private static final String __OBFID = "CL_00000303";


   public int func_149692_a(int p_149692_1_) {
      return p_149692_1_;
   }

   public MapColor func_149728_f(int p_149728_1_) {
      return p_149728_1_ == 1?MapColor.field_151664_l:MapColor.field_151658_d;
   }

}
