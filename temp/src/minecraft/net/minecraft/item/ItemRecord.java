package net.minecraft.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.block.BlockJukebox;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemRecord extends Item {

   private static final Map field_150928_b = new HashMap();
   public final String field_150929_a;
   private static final String __OBFID = "CL_00000057";


   protected ItemRecord(String p_i45350_1_) {
      this.field_150929_a = p_i45350_1_;
      this.field_77777_bU = 1;
      this.func_77637_a(CreativeTabs.field_78026_f);
      field_150928_b.put(p_i45350_1_, this);
   }

   public IIcon func_77617_a(int p_77617_1_) {
      return this.field_77791_bV;
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      if(p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_) == Blocks.field_150421_aI && p_77648_3_.func_72805_g(p_77648_4_, p_77648_5_, p_77648_6_) == 0) {
         if(p_77648_3_.field_72995_K) {
            return true;
         } else {
            ((BlockJukebox)Blocks.field_150421_aI).func_149926_b(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_1_);
            p_77648_3_.func_72889_a((EntityPlayer)null, 1005, p_77648_4_, p_77648_5_, p_77648_6_, Item.func_150891_b(this));
            --p_77648_1_.field_77994_a;
            return true;
         }
      } else {
         return false;
      }
   }

   public void func_77624_a(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
      p_77624_3_.add(this.func_150927_i());
   }

   public String func_150927_i() {
      return StatCollector.func_74838_a("item.record." + this.field_150929_a + ".desc");
   }

   public EnumRarity func_77613_e(ItemStack p_77613_1_) {
      return EnumRarity.rare;
   }

   public static ItemRecord func_150926_b(String p_150926_0_) {
      return (ItemRecord)field_150928_b.get(p_150926_0_);
   }

}
