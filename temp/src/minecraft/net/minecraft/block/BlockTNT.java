package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockTNT extends Block {

   private IIcon field_150116_a;
   private IIcon field_150115_b;
   private static final String __OBFID = "CL_00000324";


   public BlockTNT() {
      super(Material.field_151590_u);
      this.func_149647_a(CreativeTabs.field_78028_d);
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      return p_149691_1_ == 0?this.field_150115_b:(p_149691_1_ == 1?this.field_150116_a:this.field_149761_L);
   }

   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
      super.func_149726_b(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
      if(p_149726_1_.func_72864_z(p_149726_2_, p_149726_3_, p_149726_4_)) {
         this.func_149664_b(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_, 1);
         p_149726_1_.func_147468_f(p_149726_2_, p_149726_3_, p_149726_4_);
      }

   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      if(p_149695_1_.func_72864_z(p_149695_2_, p_149695_3_, p_149695_4_)) {
         this.func_149664_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, 1);
         p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
      }

   }

   public int func_149745_a(Random p_149745_1_) {
      return 1;
   }

   public void func_149723_a(World p_149723_1_, int p_149723_2_, int p_149723_3_, int p_149723_4_, Explosion p_149723_5_) {
      if(!p_149723_1_.field_72995_K) {
         EntityTNTPrimed var6 = new EntityTNTPrimed(p_149723_1_, (double)((float)p_149723_2_ + 0.5F), (double)((float)p_149723_3_ + 0.5F), (double)((float)p_149723_4_ + 0.5F), p_149723_5_.func_94613_c());
         var6.field_70516_a = p_149723_1_.field_73012_v.nextInt(var6.field_70516_a / 4) + var6.field_70516_a / 8;
         p_149723_1_.func_72838_d(var6);
      }
   }

   public void func_149664_b(World p_149664_1_, int p_149664_2_, int p_149664_3_, int p_149664_4_, int p_149664_5_) {
      this.func_150114_a(p_149664_1_, p_149664_2_, p_149664_3_, p_149664_4_, p_149664_5_, (EntityLivingBase)null);
   }

   public void func_150114_a(World p_150114_1_, int p_150114_2_, int p_150114_3_, int p_150114_4_, int p_150114_5_, EntityLivingBase p_150114_6_) {
      if(!p_150114_1_.field_72995_K) {
         if((p_150114_5_ & 1) == 1) {
            EntityTNTPrimed var7 = new EntityTNTPrimed(p_150114_1_, (double)((float)p_150114_2_ + 0.5F), (double)((float)p_150114_3_ + 0.5F), (double)((float)p_150114_4_ + 0.5F), p_150114_6_);
            p_150114_1_.func_72838_d(var7);
            p_150114_1_.func_72956_a(var7, "game.tnt.primed", 1.0F, 1.0F);
         }

      }
   }

   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
      if(p_149727_5_.func_71045_bC() != null && p_149727_5_.func_71045_bC().func_77973_b() == Items.field_151033_d) {
         this.func_150114_a(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, 1, p_149727_5_);
         p_149727_1_.func_147468_f(p_149727_2_, p_149727_3_, p_149727_4_);
         p_149727_5_.func_71045_bC().func_77972_a(1, p_149727_5_);
         return true;
      } else {
         return super.func_149727_a(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, p_149727_5_, p_149727_6_, p_149727_7_, p_149727_8_, p_149727_9_);
      }
   }

   public void func_149670_a(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_) {
      if(p_149670_5_ instanceof EntityArrow && !p_149670_1_.field_72995_K) {
         EntityArrow var6 = (EntityArrow)p_149670_5_;
         if(var6.func_70027_ad()) {
            this.func_150114_a(p_149670_1_, p_149670_2_, p_149670_3_, p_149670_4_, 1, var6.field_70250_c instanceof EntityLivingBase?(EntityLivingBase)var6.field_70250_c:null);
            p_149670_1_.func_147468_f(p_149670_2_, p_149670_3_, p_149670_4_);
         }
      }

   }

   public boolean func_149659_a(Explosion p_149659_1_) {
      return false;
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149761_L = p_149651_1_.func_94245_a(this.func_149641_N() + "_side");
      this.field_150116_a = p_149651_1_.func_94245_a(this.func_149641_N() + "_top");
      this.field_150115_b = p_149651_1_.func_94245_a(this.func_149641_N() + "_bottom");
   }
}
