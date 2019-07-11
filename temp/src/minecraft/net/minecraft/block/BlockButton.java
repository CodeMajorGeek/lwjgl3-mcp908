package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockButton extends Block {

   private final boolean field_150047_a;
   private static final String __OBFID = "CL_00000209";


   protected BlockButton(boolean p_i45396_1_) {
      super(Material.field_151594_q);
      this.func_149675_a(true);
      this.func_149647_a(CreativeTabs.field_78028_d);
      this.field_150047_a = p_i45396_1_;
   }

   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
      return null;
   }

   public int func_149738_a(World p_149738_1_) {
      return this.field_150047_a?30:20;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149707_d(World p_149707_1_, int p_149707_2_, int p_149707_3_, int p_149707_4_, int p_149707_5_) {
      return p_149707_5_ == 2 && p_149707_1_.func_147439_a(p_149707_2_, p_149707_3_, p_149707_4_ + 1).func_149721_r()?true:(p_149707_5_ == 3 && p_149707_1_.func_147439_a(p_149707_2_, p_149707_3_, p_149707_4_ - 1).func_149721_r()?true:(p_149707_5_ == 4 && p_149707_1_.func_147439_a(p_149707_2_ + 1, p_149707_3_, p_149707_4_).func_149721_r()?true:p_149707_5_ == 5 && p_149707_1_.func_147439_a(p_149707_2_ - 1, p_149707_3_, p_149707_4_).func_149721_r()));
   }

   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
      return p_149742_1_.func_147439_a(p_149742_2_ - 1, p_149742_3_, p_149742_4_).func_149721_r()?true:(p_149742_1_.func_147439_a(p_149742_2_ + 1, p_149742_3_, p_149742_4_).func_149721_r()?true:(p_149742_1_.func_147439_a(p_149742_2_, p_149742_3_, p_149742_4_ - 1).func_149721_r()?true:p_149742_1_.func_147439_a(p_149742_2_, p_149742_3_, p_149742_4_ + 1).func_149721_r()));
   }

   public int func_149660_a(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_) {
      int var10 = p_149660_1_.func_72805_g(p_149660_2_, p_149660_3_, p_149660_4_);
      int var11 = var10 & 8;
      var10 &= 7;
      if(p_149660_5_ == 2 && p_149660_1_.func_147439_a(p_149660_2_, p_149660_3_, p_149660_4_ + 1).func_149721_r()) {
         var10 = 4;
      } else if(p_149660_5_ == 3 && p_149660_1_.func_147439_a(p_149660_2_, p_149660_3_, p_149660_4_ - 1).func_149721_r()) {
         var10 = 3;
      } else if(p_149660_5_ == 4 && p_149660_1_.func_147439_a(p_149660_2_ + 1, p_149660_3_, p_149660_4_).func_149721_r()) {
         var10 = 2;
      } else if(p_149660_5_ == 5 && p_149660_1_.func_147439_a(p_149660_2_ - 1, p_149660_3_, p_149660_4_).func_149721_r()) {
         var10 = 1;
      } else {
         var10 = this.func_150045_e(p_149660_1_, p_149660_2_, p_149660_3_, p_149660_4_);
      }

      return var10 + var11;
   }

   private int func_150045_e(World p_150045_1_, int p_150045_2_, int p_150045_3_, int p_150045_4_) {
      return p_150045_1_.func_147439_a(p_150045_2_ - 1, p_150045_3_, p_150045_4_).func_149721_r()?1:(p_150045_1_.func_147439_a(p_150045_2_ + 1, p_150045_3_, p_150045_4_).func_149721_r()?2:(p_150045_1_.func_147439_a(p_150045_2_, p_150045_3_, p_150045_4_ - 1).func_149721_r()?3:(p_150045_1_.func_147439_a(p_150045_2_, p_150045_3_, p_150045_4_ + 1).func_149721_r()?4:1)));
   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      if(this.func_150044_m(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_)) {
         int var6 = p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_) & 7;
         boolean var7 = false;
         if(!p_149695_1_.func_147439_a(p_149695_2_ - 1, p_149695_3_, p_149695_4_).func_149721_r() && var6 == 1) {
            var7 = true;
         }

         if(!p_149695_1_.func_147439_a(p_149695_2_ + 1, p_149695_3_, p_149695_4_).func_149721_r() && var6 == 2) {
            var7 = true;
         }

         if(!p_149695_1_.func_147439_a(p_149695_2_, p_149695_3_, p_149695_4_ - 1).func_149721_r() && var6 == 3) {
            var7 = true;
         }

         if(!p_149695_1_.func_147439_a(p_149695_2_, p_149695_3_, p_149695_4_ + 1).func_149721_r() && var6 == 4) {
            var7 = true;
         }

         if(var7) {
            this.func_149697_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_), 0);
            p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
         }
      }

   }

   private boolean func_150044_m(World p_150044_1_, int p_150044_2_, int p_150044_3_, int p_150044_4_) {
      if(!this.func_149742_c(p_150044_1_, p_150044_2_, p_150044_3_, p_150044_4_)) {
         this.func_149697_b(p_150044_1_, p_150044_2_, p_150044_3_, p_150044_4_, p_150044_1_.func_72805_g(p_150044_2_, p_150044_3_, p_150044_4_), 0);
         p_150044_1_.func_147468_f(p_150044_2_, p_150044_3_, p_150044_4_);
         return false;
      } else {
         return true;
      }
   }

   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
      int var5 = p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_);
      this.func_150043_b(var5);
   }

   private void func_150043_b(int p_150043_1_) {
      int var2 = p_150043_1_ & 7;
      boolean var3 = (p_150043_1_ & 8) > 0;
      float var4 = 0.375F;
      float var5 = 0.625F;
      float var6 = 0.1875F;
      float var7 = 0.125F;
      if(var3) {
         var7 = 0.0625F;
      }

      if(var2 == 1) {
         this.func_149676_a(0.0F, var4, 0.5F - var6, var7, var5, 0.5F + var6);
      } else if(var2 == 2) {
         this.func_149676_a(1.0F - var7, var4, 0.5F - var6, 1.0F, var5, 0.5F + var6);
      } else if(var2 == 3) {
         this.func_149676_a(0.5F - var6, var4, 0.0F, 0.5F + var6, var5, var7);
      } else if(var2 == 4) {
         this.func_149676_a(0.5F - var6, var4, 1.0F - var7, 0.5F + var6, var5, 1.0F);
      }

   }

   public void func_149699_a(World p_149699_1_, int p_149699_2_, int p_149699_3_, int p_149699_4_, EntityPlayer p_149699_5_) {}

   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
      int var10 = p_149727_1_.func_72805_g(p_149727_2_, p_149727_3_, p_149727_4_);
      int var11 = var10 & 7;
      int var12 = 8 - (var10 & 8);
      if(var12 == 0) {
         return true;
      } else {
         p_149727_1_.func_72921_c(p_149727_2_, p_149727_3_, p_149727_4_, var11 + var12, 3);
         p_149727_1_.func_147458_c(p_149727_2_, p_149727_3_, p_149727_4_, p_149727_2_, p_149727_3_, p_149727_4_);
         p_149727_1_.func_72908_a((double)p_149727_2_ + 0.5D, (double)p_149727_3_ + 0.5D, (double)p_149727_4_ + 0.5D, "random.click", 0.3F, 0.6F);
         this.func_150042_a(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, var11);
         p_149727_1_.func_147464_a(p_149727_2_, p_149727_3_, p_149727_4_, this, this.func_149738_a(p_149727_1_));
         return true;
      }
   }

   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
      if((p_149749_6_ & 8) > 0) {
         int var7 = p_149749_6_ & 7;
         this.func_150042_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, var7);
      }

      super.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
   }

   public int func_149709_b(IBlockAccess p_149709_1_, int p_149709_2_, int p_149709_3_, int p_149709_4_, int p_149709_5_) {
      return (p_149709_1_.func_72805_g(p_149709_2_, p_149709_3_, p_149709_4_) & 8) > 0?15:0;
   }

   public int func_149748_c(IBlockAccess p_149748_1_, int p_149748_2_, int p_149748_3_, int p_149748_4_, int p_149748_5_) {
      int var6 = p_149748_1_.func_72805_g(p_149748_2_, p_149748_3_, p_149748_4_);
      if((var6 & 8) == 0) {
         return 0;
      } else {
         int var7 = var6 & 7;
         return var7 == 5 && p_149748_5_ == 1?15:(var7 == 4 && p_149748_5_ == 2?15:(var7 == 3 && p_149748_5_ == 3?15:(var7 == 2 && p_149748_5_ == 4?15:(var7 == 1 && p_149748_5_ == 5?15:0))));
      }
   }

   public boolean func_149744_f() {
      return true;
   }

   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      if(!p_149674_1_.field_72995_K) {
         int var6 = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_);
         if((var6 & 8) != 0) {
            if(this.field_150047_a) {
               this.func_150046_n(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);
            } else {
               p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, var6 & 7, 3);
               int var7 = var6 & 7;
               this.func_150042_a(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, var7);
               p_149674_1_.func_72908_a((double)p_149674_2_ + 0.5D, (double)p_149674_3_ + 0.5D, (double)p_149674_4_ + 0.5D, "random.click", 0.3F, 0.5F);
               p_149674_1_.func_147458_c(p_149674_2_, p_149674_3_, p_149674_4_, p_149674_2_, p_149674_3_, p_149674_4_);
            }

         }
      }
   }

   public void func_149683_g() {
      float var1 = 0.1875F;
      float var2 = 0.125F;
      float var3 = 0.125F;
      this.func_149676_a(0.5F - var1, 0.5F - var2, 0.5F - var3, 0.5F + var1, 0.5F + var2, 0.5F + var3);
   }

   public void func_149670_a(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_) {
      if(!p_149670_1_.field_72995_K) {
         if(this.field_150047_a) {
            if((p_149670_1_.func_72805_g(p_149670_2_, p_149670_3_, p_149670_4_) & 8) == 0) {
               this.func_150046_n(p_149670_1_, p_149670_2_, p_149670_3_, p_149670_4_);
            }
         }
      }
   }

   private void func_150046_n(World p_150046_1_, int p_150046_2_, int p_150046_3_, int p_150046_4_) {
      int var5 = p_150046_1_.func_72805_g(p_150046_2_, p_150046_3_, p_150046_4_);
      int var6 = var5 & 7;
      boolean var7 = (var5 & 8) != 0;
      this.func_150043_b(var5);
      List var9 = p_150046_1_.func_72872_a(EntityArrow.class, AxisAlignedBB.func_72330_a((double)p_150046_2_ + this.field_149759_B, (double)p_150046_3_ + this.field_149760_C, (double)p_150046_4_ + this.field_149754_D, (double)p_150046_2_ + this.field_149755_E, (double)p_150046_3_ + this.field_149756_F, (double)p_150046_4_ + this.field_149757_G));
      boolean var8 = !var9.isEmpty();
      if(var8 && !var7) {
         p_150046_1_.func_72921_c(p_150046_2_, p_150046_3_, p_150046_4_, var6 | 8, 3);
         this.func_150042_a(p_150046_1_, p_150046_2_, p_150046_3_, p_150046_4_, var6);
         p_150046_1_.func_147458_c(p_150046_2_, p_150046_3_, p_150046_4_, p_150046_2_, p_150046_3_, p_150046_4_);
         p_150046_1_.func_72908_a((double)p_150046_2_ + 0.5D, (double)p_150046_3_ + 0.5D, (double)p_150046_4_ + 0.5D, "random.click", 0.3F, 0.6F);
      }

      if(!var8 && var7) {
         p_150046_1_.func_72921_c(p_150046_2_, p_150046_3_, p_150046_4_, var6, 3);
         this.func_150042_a(p_150046_1_, p_150046_2_, p_150046_3_, p_150046_4_, var6);
         p_150046_1_.func_147458_c(p_150046_2_, p_150046_3_, p_150046_4_, p_150046_2_, p_150046_3_, p_150046_4_);
         p_150046_1_.func_72908_a((double)p_150046_2_ + 0.5D, (double)p_150046_3_ + 0.5D, (double)p_150046_4_ + 0.5D, "random.click", 0.3F, 0.5F);
      }

      if(var8) {
         p_150046_1_.func_147464_a(p_150046_2_, p_150046_3_, p_150046_4_, this, this.func_149738_a(p_150046_1_));
      }

   }

   private void func_150042_a(World p_150042_1_, int p_150042_2_, int p_150042_3_, int p_150042_4_, int p_150042_5_) {
      p_150042_1_.func_147459_d(p_150042_2_, p_150042_3_, p_150042_4_, this);
      if(p_150042_5_ == 1) {
         p_150042_1_.func_147459_d(p_150042_2_ - 1, p_150042_3_, p_150042_4_, this);
      } else if(p_150042_5_ == 2) {
         p_150042_1_.func_147459_d(p_150042_2_ + 1, p_150042_3_, p_150042_4_, this);
      } else if(p_150042_5_ == 3) {
         p_150042_1_.func_147459_d(p_150042_2_, p_150042_3_, p_150042_4_ - 1, this);
      } else if(p_150042_5_ == 4) {
         p_150042_1_.func_147459_d(p_150042_2_, p_150042_3_, p_150042_4_ + 1, this);
      } else {
         p_150042_1_.func_147459_d(p_150042_2_, p_150042_3_ - 1, p_150042_4_, this);
      }

   }

   public void func_149651_a(IIconRegister p_149651_1_) {}
}
