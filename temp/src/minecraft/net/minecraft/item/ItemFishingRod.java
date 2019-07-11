package net.minecraft.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemFishingRod extends Item {

   private IIcon field_94598_a;
   private static final String __OBFID = "CL_00000034";


   public ItemFishingRod() {
      this.func_77656_e(64);
      this.func_77625_d(1);
      this.func_77637_a(CreativeTabs.field_78040_i);
   }

   public boolean func_77662_d() {
      return true;
   }

   public boolean func_77629_n_() {
      return true;
   }

   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      if(p_77659_3_.field_71104_cf != null) {
         int var4 = p_77659_3_.field_71104_cf.func_146034_e();
         p_77659_1_.func_77972_a(var4, p_77659_3_);
         p_77659_3_.func_71038_i();
      } else {
         p_77659_2_.func_72956_a(p_77659_3_, "random.bow", 0.5F, 0.4F / (field_77697_d.nextFloat() * 0.4F + 0.8F));
         if(!p_77659_2_.field_72995_K) {
            p_77659_2_.func_72838_d(new EntityFishHook(p_77659_2_, p_77659_3_));
         }

         p_77659_3_.func_71038_i();
      }

      return p_77659_1_;
   }

   public void func_94581_a(IIconRegister p_94581_1_) {
      this.field_77791_bV = p_94581_1_.func_94245_a(this.func_111208_A() + "_uncast");
      this.field_94598_a = p_94581_1_.func_94245_a(this.func_111208_A() + "_cast");
   }

   public IIcon func_94597_g() {
      return this.field_94598_a;
   }

   public boolean func_77616_k(ItemStack p_77616_1_) {
      return super.func_77616_k(p_77616_1_);
   }

   public int func_77619_b() {
      return 1;
   }
}
