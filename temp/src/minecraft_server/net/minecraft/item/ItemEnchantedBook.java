package net.minecraft.item;

import java.util.Random;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.WeightedRandomChestContent;

public class ItemEnchantedBook extends Item {

   private static final String __OBFID = "CL_00000025";


   public boolean func_77616_k(ItemStack p_77616_1_) {
      return false;
   }

   public EnumRarity func_77613_e(ItemStack p_77613_1_) {
      return this.func_92110_g(p_77613_1_).func_74745_c() > 0?EnumRarity.uncommon:super.func_77613_e(p_77613_1_);
   }

   public NBTTagList func_92110_g(ItemStack p_92110_1_) {
      return p_92110_1_.field_77990_d != null && p_92110_1_.field_77990_d.func_150297_b("StoredEnchantments", 9)?(NBTTagList)p_92110_1_.field_77990_d.func_74781_a("StoredEnchantments"):new NBTTagList();
   }

   public void func_92115_a(ItemStack p_92115_1_, EnchantmentData p_92115_2_) {
      NBTTagList var3 = this.func_92110_g(p_92115_1_);
      boolean var4 = true;

      for(int var5 = 0; var5 < var3.func_74745_c(); ++var5) {
         NBTTagCompound var6 = var3.func_150305_b(var5);
         if(var6.func_74765_d("id") == p_92115_2_.field_76302_b.field_77352_x) {
            if(var6.func_74765_d("lvl") < p_92115_2_.field_76303_c) {
               var6.func_74777_a("lvl", (short)p_92115_2_.field_76303_c);
            }

            var4 = false;
            break;
         }
      }

      if(var4) {
         NBTTagCompound var7 = new NBTTagCompound();
         var7.func_74777_a("id", (short)p_92115_2_.field_76302_b.field_77352_x);
         var7.func_74777_a("lvl", (short)p_92115_2_.field_76303_c);
         var3.func_74742_a(var7);
      }

      if(!p_92115_1_.func_77942_o()) {
         p_92115_1_.func_77982_d(new NBTTagCompound());
      }

      p_92115_1_.func_77978_p().func_74782_a("StoredEnchantments", var3);
   }

   public ItemStack func_92111_a(EnchantmentData p_92111_1_) {
      ItemStack var2 = new ItemStack(this);
      this.func_92115_a(var2, p_92111_1_);
      return var2;
   }

   public WeightedRandomChestContent func_92114_b(Random p_92114_1_) {
      return this.func_92112_a(p_92114_1_, 1, 1, 1);
   }

   public WeightedRandomChestContent func_92112_a(Random p_92112_1_, int p_92112_2_, int p_92112_3_, int p_92112_4_) {
      ItemStack var5 = new ItemStack(Items.field_151122_aG, 1, 0);
      EnchantmentHelper.func_77504_a(p_92112_1_, var5, 30);
      return new WeightedRandomChestContent(var5, p_92112_2_, p_92112_3_, p_92112_4_);
   }
}
