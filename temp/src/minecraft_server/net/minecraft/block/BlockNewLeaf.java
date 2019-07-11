package net.minecraft.block;

import net.minecraft.block.BlockLeaves;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockNewLeaf extends BlockLeaves {

   public static final String[][] field_150132_N = new String[][]{{"leaves_acacia", "leaves_big_oak"}, {"leaves_acacia_opaque", "leaves_big_oak_opaque"}};
   public static final String[] field_150133_O = new String[]{"acacia", "big_oak"};
   private static final String __OBFID = "CL_00000276";


   protected void func_150124_c(World p_150124_1_, int p_150124_2_, int p_150124_3_, int p_150124_4_, int p_150124_5_, int p_150124_6_) {
      if((p_150124_5_ & 3) == 1 && p_150124_1_.field_73012_v.nextInt(p_150124_6_) == 0) {
         this.func_149642_a(p_150124_1_, p_150124_2_, p_150124_3_, p_150124_4_, new ItemStack(Items.field_151034_e, 1, 0));
      }

   }

   public int func_149692_a(int p_149692_1_) {
      return super.func_149692_a(p_149692_1_) + 4;
   }

   public int func_149643_k(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_) {
      return p_149643_1_.func_72805_g(p_149643_2_, p_149643_3_, p_149643_4_) & 3;
   }

   public String[] func_150125_e() {
      return field_150133_O;
   }

}
