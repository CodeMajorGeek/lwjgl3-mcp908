package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class BlockLeavesBase extends Block {

   protected boolean field_150121_P;
   private static final String __OBFID = "CL_00000326";


   protected BlockLeavesBase(Material p_i45433_1_, boolean p_i45433_2_) {
      super(p_i45433_1_);
      this.field_150121_P = p_i45433_2_;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
      Block var6 = p_149646_1_.func_147439_a(p_149646_2_, p_149646_3_, p_149646_4_);
      return !this.field_150121_P && var6 == this?false:super.func_149646_a(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
   }
}
