package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.IIcon;

public class ItemBlockWithMetadata extends ItemBlock {

   private Block field_150950_b;
   private static final String __OBFID = "CL_00001769";


   public ItemBlockWithMetadata(Block p_i45326_1_, Block p_i45326_2_) {
      super(p_i45326_1_);
      this.field_150950_b = p_i45326_2_;
      this.func_77656_e(0);
      this.func_77627_a(true);
   }

   public IIcon func_77617_a(int p_77617_1_) {
      return this.field_150950_b.func_149691_a(2, p_77617_1_);
   }

   public int func_77647_b(int p_77647_1_) {
      return p_77647_1_;
   }
}
