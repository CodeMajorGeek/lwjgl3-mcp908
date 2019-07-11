package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.Facing;
import net.minecraft.world.IBlockAccess;

public class BlockBreakable extends Block {

   private boolean field_149996_a;
   private String field_149995_b;
   private static final String __OBFID = "CL_00000254";


   protected BlockBreakable(String p_i45411_1_, Material p_i45411_2_, boolean p_i45411_3_) {
      super(p_i45411_2_);
      this.field_149996_a = p_i45411_3_;
      this.field_149995_b = p_i45411_1_;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
      Block var6 = p_149646_1_.func_147439_a(p_149646_2_, p_149646_3_, p_149646_4_);
      if(this == Blocks.field_150359_w || this == Blocks.field_150399_cn) {
         if(p_149646_1_.func_72805_g(p_149646_2_, p_149646_3_, p_149646_4_) != p_149646_1_.func_72805_g(p_149646_2_ - Facing.field_71586_b[p_149646_5_], p_149646_3_ - Facing.field_71587_c[p_149646_5_], p_149646_4_ - Facing.field_71585_d[p_149646_5_])) {
            return true;
         }

         if(var6 == this) {
            return false;
         }
      }

      return !this.field_149996_a && var6 == this?false:super.func_149646_a(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149761_L = p_149651_1_.func_94245_a(this.field_149995_b);
   }
}
