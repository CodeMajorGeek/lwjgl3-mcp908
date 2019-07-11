package net.minecraft.item;

import net.minecraft.block.BlockLeaves;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemLeaves extends ItemBlock {

   private final BlockLeaves field_150940_b;
   private static final String __OBFID = "CL_00000046";


   public ItemLeaves(BlockLeaves p_i45344_1_) {
      super(p_i45344_1_);
      this.field_150940_b = p_i45344_1_;
      this.func_77656_e(0);
      this.func_77627_a(true);
   }

   public int func_77647_b(int p_77647_1_) {
      return p_77647_1_ | 4;
   }

   public String func_77667_c(ItemStack p_77667_1_) {
      int var2 = p_77667_1_.func_77960_j();
      if(var2 < 0 || var2 >= this.field_150940_b.func_150125_e().length) {
         var2 = 0;
      }

      return super.func_77658_a() + "." + this.field_150940_b.func_150125_e()[var2];
   }
}
