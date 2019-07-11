package net.minecraft.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemPotion extends Item {

   private HashMap field_77836_a = new HashMap();
   private static final Map field_77835_b = new LinkedHashMap();
   private static final String __OBFID = "CL_00000055";


   public ItemPotion() {
      this.func_77625_d(1);
      this.func_77627_a(true);
      this.func_77656_e(0);
      this.func_77637_a(CreativeTabs.field_78038_k);
   }

   public List func_77832_l(ItemStack p_77832_1_) {
      if(p_77832_1_.func_77942_o() && p_77832_1_.func_77978_p().func_150297_b("CustomPotionEffects", 9)) {
         ArrayList var7 = new ArrayList();
         NBTTagList var3 = p_77832_1_.func_77978_p().func_150295_c("CustomPotionEffects", 10);

         for(int var4 = 0; var4 < var3.func_74745_c(); ++var4) {
            NBTTagCompound var5 = var3.func_150305_b(var4);
            PotionEffect var6 = PotionEffect.func_82722_b(var5);
            if(var6 != null) {
               var7.add(var6);
            }
         }

         return var7;
      } else {
         List var2 = (List)this.field_77836_a.get(Integer.valueOf(p_77832_1_.func_77960_j()));
         if(var2 == null) {
            var2 = PotionHelper.func_77917_b(p_77832_1_.func_77960_j(), false);
            this.field_77836_a.put(Integer.valueOf(p_77832_1_.func_77960_j()), var2);
         }

         return var2;
      }
   }

   public List func_77834_f(int p_77834_1_) {
      List var2 = (List)this.field_77836_a.get(Integer.valueOf(p_77834_1_));
      if(var2 == null) {
         var2 = PotionHelper.func_77917_b(p_77834_1_, false);
         this.field_77836_a.put(Integer.valueOf(p_77834_1_), var2);
      }

      return var2;
   }

   public ItemStack func_77654_b(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
      if(!p_77654_3_.field_71075_bZ.field_75098_d) {
         --p_77654_1_.field_77994_a;
      }

      if(!p_77654_2_.field_72995_K) {
         List var4 = this.func_77832_l(p_77654_1_);
         if(var4 != null) {
            Iterator var5 = var4.iterator();

            while(var5.hasNext()) {
               PotionEffect var6 = (PotionEffect)var5.next();
               p_77654_3_.func_70690_d(new PotionEffect(var6));
            }
         }
      }

      if(!p_77654_3_.field_71075_bZ.field_75098_d) {
         if(p_77654_1_.field_77994_a <= 0) {
            return new ItemStack(Items.field_151069_bo);
         }

         p_77654_3_.field_71071_by.func_70441_a(new ItemStack(Items.field_151069_bo));
      }

      return p_77654_1_;
   }

   public int func_77626_a(ItemStack p_77626_1_) {
      return 32;
   }

   public EnumAction func_77661_b(ItemStack p_77661_1_) {
      return EnumAction.drink;
   }

   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      if(func_77831_g(p_77659_1_.func_77960_j())) {
         if(!p_77659_3_.field_71075_bZ.field_75098_d) {
            --p_77659_1_.field_77994_a;
         }

         p_77659_2_.func_72956_a(p_77659_3_, "random.bow", 0.5F, 0.4F / (field_77697_d.nextFloat() * 0.4F + 0.8F));
         if(!p_77659_2_.field_72995_K) {
            p_77659_2_.func_72838_d(new EntityPotion(p_77659_2_, p_77659_3_, p_77659_1_));
         }

         return p_77659_1_;
      } else {
         p_77659_3_.func_71008_a(p_77659_1_, this.func_77626_a(p_77659_1_));
         return p_77659_1_;
      }
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      return false;
   }

   public static boolean func_77831_g(int p_77831_0_) {
      return (p_77831_0_ & 16384) != 0;
   }

   public String func_77653_i(ItemStack p_77653_1_) {
      if(p_77653_1_.func_77960_j() == 0) {
         return StatCollector.func_74838_a("item.emptyPotion.name").trim();
      } else {
         String var2 = "";
         if(func_77831_g(p_77653_1_.func_77960_j())) {
            var2 = StatCollector.func_74838_a("potion.prefix.grenade").trim() + " ";
         }

         List var3 = Items.field_151068_bn.func_77832_l(p_77653_1_);
         String var4;
         if(var3 != null && !var3.isEmpty()) {
            var4 = ((PotionEffect)var3.get(0)).func_76453_d();
            var4 = var4 + ".postfix";
            return var2 + StatCollector.func_74838_a(var4).trim();
         } else {
            var4 = PotionHelper.func_77905_c(p_77653_1_.func_77960_j());
            return StatCollector.func_74838_a(var4).trim() + " " + super.func_77653_i(p_77653_1_);
         }
      }
   }

}
