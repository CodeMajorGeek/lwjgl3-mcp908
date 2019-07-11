package net.minecraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemRedstone extends Item {

   private static final String __OBFID = "CL_00000058";


   public ItemRedstone() {
      this.func_77637_a(CreativeTabs.field_78028_d);
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      if(p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_) != Blocks.field_150431_aC) {
         if(p_77648_7_ == 0) {
            --p_77648_5_;
         }

         if(p_77648_7_ == 1) {
            ++p_77648_5_;
         }

         if(p_77648_7_ == 2) {
            --p_77648_6_;
         }

         if(p_77648_7_ == 3) {
            ++p_77648_6_;
         }

         if(p_77648_7_ == 4) {
            --p_77648_4_;
         }

         if(p_77648_7_ == 5) {
            ++p_77648_4_;
         }

         if(!p_77648_3_.func_147437_c(p_77648_4_, p_77648_5_, p_77648_6_)) {
            return false;
         }
      }

      if(!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) {
         return false;
      } else {
         if(Blocks.field_150488_af.func_149742_c(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_)) {
            --p_77648_1_.field_77994_a;
            p_77648_3_.func_147449_b(p_77648_4_, p_77648_5_, p_77648_6_, Blocks.field_150488_af);
         }

         return true;
      }
   }
}
