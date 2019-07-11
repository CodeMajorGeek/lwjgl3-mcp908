package net.minecraft.item;

import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class ItemLead extends Item {

   private static final String __OBFID = "CL_00000045";


   public ItemLead() {
      this.func_77637_a(CreativeTabs.field_78040_i);
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      Block var11 = p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_);
      if(var11.func_149645_b() == 11) {
         if(p_77648_3_.field_72995_K) {
            return true;
         } else {
            func_150909_a(p_77648_2_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_);
            return true;
         }
      } else {
         return false;
      }
   }

   public static boolean func_150909_a(EntityPlayer p_150909_0_, World p_150909_1_, int p_150909_2_, int p_150909_3_, int p_150909_4_) {
      EntityLeashKnot var5 = EntityLeashKnot.func_110130_b(p_150909_1_, p_150909_2_, p_150909_3_, p_150909_4_);
      boolean var6 = false;
      double var7 = 7.0D;
      List var9 = p_150909_1_.func_72872_a(EntityLiving.class, AxisAlignedBB.func_72330_a((double)p_150909_2_ - var7, (double)p_150909_3_ - var7, (double)p_150909_4_ - var7, (double)p_150909_2_ + var7, (double)p_150909_3_ + var7, (double)p_150909_4_ + var7));
      if(var9 != null) {
         Iterator var10 = var9.iterator();

         while(var10.hasNext()) {
            EntityLiving var11 = (EntityLiving)var10.next();
            if(var11.func_110167_bD() && var11.func_110166_bE() == p_150909_0_) {
               if(var5 == null) {
                  var5 = EntityLeashKnot.func_110129_a(p_150909_1_, p_150909_2_, p_150909_3_, p_150909_4_);
               }

               var11.func_110162_b(var5, true);
               var6 = true;
            }
         }
      }

      return var6;
   }
}
