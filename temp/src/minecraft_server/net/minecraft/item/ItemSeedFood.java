package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSeedFood extends ItemFood {

   private Block field_150908_b;
   private Block field_82809_c;
   private static final String __OBFID = "CL_00000060";


   public ItemSeedFood(int p_i45351_1_, float p_i45351_2_, Block p_i45351_3_, Block p_i45351_4_) {
      super(p_i45351_1_, p_i45351_2_, false);
      this.field_150908_b = p_i45351_3_;
      this.field_82809_c = p_i45351_4_;
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      if(p_77648_7_ != 1) {
         return false;
      } else if(p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_) && p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_ + 1, p_77648_6_, p_77648_7_, p_77648_1_)) {
         if(p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_) == this.field_82809_c && p_77648_3_.func_147437_c(p_77648_4_, p_77648_5_ + 1, p_77648_6_)) {
            p_77648_3_.func_147449_b(p_77648_4_, p_77648_5_ + 1, p_77648_6_, this.field_150908_b);
            --p_77648_1_.field_77994_a;
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }
}
