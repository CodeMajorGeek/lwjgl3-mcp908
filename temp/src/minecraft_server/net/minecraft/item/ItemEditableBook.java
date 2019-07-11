package net.minecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemWritableBook;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StringUtils;
import net.minecraft.world.World;

public class ItemEditableBook extends Item {

   private static final String __OBFID = "CL_00000077";


   public ItemEditableBook() {
      this.func_77625_d(1);
   }

   public static boolean func_77828_a(NBTTagCompound p_77828_0_) {
      if(!ItemWritableBook.func_150930_a(p_77828_0_)) {
         return false;
      } else if(!p_77828_0_.func_150297_b("title", 8)) {
         return false;
      } else {
         String var1 = p_77828_0_.func_74779_i("title");
         return var1 != null && var1.length() <= 16?p_77828_0_.func_150297_b("author", 8):false;
      }
   }

   public String func_77653_i(ItemStack p_77653_1_) {
      if(p_77653_1_.func_77942_o()) {
         NBTTagCompound var2 = p_77653_1_.func_77978_p();
         String var3 = var2.func_74779_i("title");
         if(!StringUtils.func_151246_b(var3)) {
            return var3;
         }
      }

      return super.func_77653_i(p_77653_1_);
   }

   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      p_77659_3_.func_71048_c(p_77659_1_);
      return p_77659_1_;
   }

   public boolean func_77651_p() {
      return true;
   }
}
