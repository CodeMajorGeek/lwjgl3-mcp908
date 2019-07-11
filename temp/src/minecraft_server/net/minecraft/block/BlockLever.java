package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLever extends Block {

   private static final String __OBFID = "CL_00000264";


   protected BlockLever() {
      super(Material.field_151594_q);
      this.func_149647_a(CreativeTabs.field_78028_d);
   }

   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
      return null;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public int func_149645_b() {
      return 12;
   }

   public boolean func_149707_d(World p_149707_1_, int p_149707_2_, int p_149707_3_, int p_149707_4_, int p_149707_5_) {
      return p_149707_5_ == 0 && p_149707_1_.func_147439_a(p_149707_2_, p_149707_3_ + 1, p_149707_4_).func_149721_r()?true:(p_149707_5_ == 1 && World.func_147466_a(p_149707_1_, p_149707_2_, p_149707_3_ - 1, p_149707_4_)?true:(p_149707_5_ == 2 && p_149707_1_.func_147439_a(p_149707_2_, p_149707_3_, p_149707_4_ + 1).func_149721_r()?true:(p_149707_5_ == 3 && p_149707_1_.func_147439_a(p_149707_2_, p_149707_3_, p_149707_4_ - 1).func_149721_r()?true:(p_149707_5_ == 4 && p_149707_1_.func_147439_a(p_149707_2_ + 1, p_149707_3_, p_149707_4_).func_149721_r()?true:p_149707_5_ == 5 && p_149707_1_.func_147439_a(p_149707_2_ - 1, p_149707_3_, p_149707_4_).func_149721_r()))));
   }

   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
      return p_149742_1_.func_147439_a(p_149742_2_ - 1, p_149742_3_, p_149742_4_).func_149721_r()?true:(p_149742_1_.func_147439_a(p_149742_2_ + 1, p_149742_3_, p_149742_4_).func_149721_r()?true:(p_149742_1_.func_147439_a(p_149742_2_, p_149742_3_, p_149742_4_ - 1).func_149721_r()?true:(p_149742_1_.func_147439_a(p_149742_2_, p_149742_3_, p_149742_4_ + 1).func_149721_r()?true:(World.func_147466_a(p_149742_1_, p_149742_2_, p_149742_3_ - 1, p_149742_4_)?true:p_149742_1_.func_147439_a(p_149742_2_, p_149742_3_ + 1, p_149742_4_).func_149721_r()))));
   }

   public int func_149660_a(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_) {
      int var11 = p_149660_9_ & 8;
      int var10 = p_149660_9_ & 7;
      byte var12 = -1;
      if(p_149660_5_ == 0 && p_149660_1_.func_147439_a(p_149660_2_, p_149660_3_ + 1, p_149660_4_).func_149721_r()) {
         var12 = 0;
      }

      if(p_149660_5_ == 1 && World.func_147466_a(p_149660_1_, p_149660_2_, p_149660_3_ - 1, p_149660_4_)) {
         var12 = 5;
      }

      if(p_149660_5_ == 2 && p_149660_1_.func_147439_a(p_149660_2_, p_149660_3_, p_149660_4_ + 1).func_149721_r()) {
         var12 = 4;
      }

      if(p_149660_5_ == 3 && p_149660_1_.func_147439_a(p_149660_2_, p_149660_3_, p_149660_4_ - 1).func_149721_r()) {
         var12 = 3;
      }

      if(p_149660_5_ == 4 && p_149660_1_.func_147439_a(p_149660_2_ + 1, p_149660_3_, p_149660_4_).func_149721_r()) {
         var12 = 2;
      }

      if(p_149660_5_ == 5 && p_149660_1_.func_147439_a(p_149660_2_ - 1, p_149660_3_, p_149660_4_).func_149721_r()) {
         var12 = 1;
      }

      return var12 + var11;
   }

   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
      int var7 = p_149689_1_.func_72805_g(p_149689_2_, p_149689_3_, p_149689_4_);
      int var8 = var7 & 7;
      int var9 = var7 & 8;
      if(var8 == func_149819_b(1)) {
         if((MathHelper.func_76128_c((double)(p_149689_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 1) == 0) {
            p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 5 | var9, 2);
         } else {
            p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 6 | var9, 2);
         }
      } else if(var8 == func_149819_b(0)) {
         if((MathHelper.func_76128_c((double)(p_149689_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 1) == 0) {
            p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 7 | var9, 2);
         } else {
            p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 0 | var9, 2);
         }
      }

   }

   public static int func_149819_b(int p_149819_0_) {
      switch(p_149819_0_) {
      case 0:
         return 0;
      case 1:
         return 5;
      case 2:
         return 4;
      case 3:
         return 3;
      case 4:
         return 2;
      case 5:
         return 1;
      default:
         return -1;
      }
   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      if(this.func_149820_e(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_)) {
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

         if(!World.func_147466_a(p_149695_1_, p_149695_2_, p_149695_3_ - 1, p_149695_4_) && var6 == 5) {
            var7 = true;
         }

         if(!World.func_147466_a(p_149695_1_, p_149695_2_, p_149695_3_ - 1, p_149695_4_) && var6 == 6) {
            var7 = true;
         }

         if(!p_149695_1_.func_147439_a(p_149695_2_, p_149695_3_ + 1, p_149695_4_).func_149721_r() && var6 == 0) {
            var7 = true;
         }

         if(!p_149695_1_.func_147439_a(p_149695_2_, p_149695_3_ + 1, p_149695_4_).func_149721_r() && var6 == 7) {
            var7 = true;
         }

         if(var7) {
            this.func_149697_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_), 0);
            p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
         }
      }

   }

   private boolean func_149820_e(World p_149820_1_, int p_149820_2_, int p_149820_3_, int p_149820_4_) {
      if(!this.func_149742_c(p_149820_1_, p_149820_2_, p_149820_3_, p_149820_4_)) {
         this.func_149697_b(p_149820_1_, p_149820_2_, p_149820_3_, p_149820_4_, p_149820_1_.func_72805_g(p_149820_2_, p_149820_3_, p_149820_4_), 0);
         p_149820_1_.func_147468_f(p_149820_2_, p_149820_3_, p_149820_4_);
         return false;
      } else {
         return true;
      }
   }

   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
      int var5 = p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_) & 7;
      float var6 = 0.1875F;
      if(var5 == 1) {
         this.func_149676_a(0.0F, 0.2F, 0.5F - var6, var6 * 2.0F, 0.8F, 0.5F + var6);
      } else if(var5 == 2) {
         this.func_149676_a(1.0F - var6 * 2.0F, 0.2F, 0.5F - var6, 1.0F, 0.8F, 0.5F + var6);
      } else if(var5 == 3) {
         this.func_149676_a(0.5F - var6, 0.2F, 0.0F, 0.5F + var6, 0.8F, var6 * 2.0F);
      } else if(var5 == 4) {
         this.func_149676_a(0.5F - var6, 0.2F, 1.0F - var6 * 2.0F, 0.5F + var6, 0.8F, 1.0F);
      } else if(var5 != 5 && var5 != 6) {
         if(var5 == 0 || var5 == 7) {
            var6 = 0.25F;
            this.func_149676_a(0.5F - var6, 0.4F, 0.5F - var6, 0.5F + var6, 1.0F, 0.5F + var6);
         }
      } else {
         var6 = 0.25F;
         this.func_149676_a(0.5F - var6, 0.0F, 0.5F - var6, 0.5F + var6, 0.6F, 0.5F + var6);
      }

   }

   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
      if(p_149727_1_.field_72995_K) {
         return true;
      } else {
         int var10 = p_149727_1_.func_72805_g(p_149727_2_, p_149727_3_, p_149727_4_);
         int var11 = var10 & 7;
         int var12 = 8 - (var10 & 8);
         p_149727_1_.func_72921_c(p_149727_2_, p_149727_3_, p_149727_4_, var11 + var12, 3);
         p_149727_1_.func_72908_a((double)p_149727_2_ + 0.5D, (double)p_149727_3_ + 0.5D, (double)p_149727_4_ + 0.5D, "random.click", 0.3F, var12 > 0?0.6F:0.5F);
         p_149727_1_.func_147459_d(p_149727_2_, p_149727_3_, p_149727_4_, this);
         if(var11 == 1) {
            p_149727_1_.func_147459_d(p_149727_2_ - 1, p_149727_3_, p_149727_4_, this);
         } else if(var11 == 2) {
            p_149727_1_.func_147459_d(p_149727_2_ + 1, p_149727_3_, p_149727_4_, this);
         } else if(var11 == 3) {
            p_149727_1_.func_147459_d(p_149727_2_, p_149727_3_, p_149727_4_ - 1, this);
         } else if(var11 == 4) {
            p_149727_1_.func_147459_d(p_149727_2_, p_149727_3_, p_149727_4_ + 1, this);
         } else if(var11 != 5 && var11 != 6) {
            if(var11 == 0 || var11 == 7) {
               p_149727_1_.func_147459_d(p_149727_2_, p_149727_3_ + 1, p_149727_4_, this);
            }
         } else {
            p_149727_1_.func_147459_d(p_149727_2_, p_149727_3_ - 1, p_149727_4_, this);
         }

         return true;
      }
   }

   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
      if((p_149749_6_ & 8) > 0) {
         p_149749_1_.func_147459_d(p_149749_2_, p_149749_3_, p_149749_4_, this);
         int var7 = p_149749_6_ & 7;
         if(var7 == 1) {
            p_149749_1_.func_147459_d(p_149749_2_ - 1, p_149749_3_, p_149749_4_, this);
         } else if(var7 == 2) {
            p_149749_1_.func_147459_d(p_149749_2_ + 1, p_149749_3_, p_149749_4_, this);
         } else if(var7 == 3) {
            p_149749_1_.func_147459_d(p_149749_2_, p_149749_3_, p_149749_4_ - 1, this);
         } else if(var7 == 4) {
            p_149749_1_.func_147459_d(p_149749_2_, p_149749_3_, p_149749_4_ + 1, this);
         } else if(var7 != 5 && var7 != 6) {
            if(var7 == 0 || var7 == 7) {
               p_149749_1_.func_147459_d(p_149749_2_, p_149749_3_ + 1, p_149749_4_, this);
            }
         } else {
            p_149749_1_.func_147459_d(p_149749_2_, p_149749_3_ - 1, p_149749_4_, this);
         }
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
         return var7 == 0 && p_149748_5_ == 0?15:(var7 == 7 && p_149748_5_ == 0?15:(var7 == 6 && p_149748_5_ == 1?15:(var7 == 5 && p_149748_5_ == 1?15:(var7 == 4 && p_149748_5_ == 2?15:(var7 == 3 && p_149748_5_ == 3?15:(var7 == 2 && p_149748_5_ == 4?15:(var7 == 1 && p_149748_5_ == 5?15:0)))))));
      }
   }

   public boolean func_149744_f() {
      return true;
   }
}
