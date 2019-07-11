package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSnow extends ItemBlockWithMetadata {

   private static final String __OBFID = "CL_00000068";


   public ItemSnow(Block p_i45354_1_, Block p_i45354_2_) {
      super(p_i45354_1_, p_i45354_2_);
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      if(p_77648_1_.field_77994_a == 0) {
         return false;
      } else if(!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) {
         return false;
      } else {
         Block var11 = p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_);
         if(var11 == Blocks.field_150431_aC) {
            int var12 = p_77648_3_.func_72805_g(p_77648_4_, p_77648_5_, p_77648_6_);
            int var13 = var12 & 7;
            if(var13 <= 6 && p_77648_3_.func_72855_b(this.field_150939_a.func_149668_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_)) && p_77648_3_.func_72921_c(p_77648_4_, p_77648_5_, p_77648_6_, var13 + 1 | var12 & -8, 2)) {
               p_77648_3_.func_72908_a((double)((float)p_77648_4_ + 0.5F), (double)((float)p_77648_5_ + 0.5F), (double)((float)p_77648_6_ + 0.5F), this.field_150939_a.field_149762_H.func_150496_b(), (this.field_150939_a.field_149762_H.func_150497_c() + 1.0F) / 2.0F, this.field_150939_a.field_149762_H.func_150494_d() * 0.8F);
               --p_77648_1_.field_77994_a;
               return true;
            }
         }

         return super.func_77648_a(p_77648_1_, p_77648_2_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_);
      }
   }
}
