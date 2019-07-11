package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSeeds extends Item {

   private Block field_150925_a;
   private Block field_77838_b;
   private static final String __OBFID = "CL_00000061";


   public ItemSeeds(Block p_i45352_1_, Block p_i45352_2_) {
      this.field_150925_a = p_i45352_1_;
      this.field_77838_b = p_i45352_2_;
      this.func_77637_a(CreativeTabs.field_78035_l);
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      if(p_77648_7_ != 1) {
         return false;
      } else if(p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_) && p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_ + 1, p_77648_6_, p_77648_7_, p_77648_1_)) {
         if(p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_) == this.field_77838_b && p_77648_3_.func_147437_c(p_77648_4_, p_77648_5_ + 1, p_77648_6_)) {
            p_77648_3_.func_147449_b(p_77648_4_, p_77648_5_ + 1, p_77648_6_, this.field_150925_a);
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
