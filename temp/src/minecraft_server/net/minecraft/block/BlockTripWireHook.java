package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTripWireHook extends Block {

   private static final String __OBFID = "CL_00000329";


   public BlockTripWireHook() {
      super(Material.field_151594_q);
      this.func_149647_a(CreativeTabs.field_78028_d);
      this.func_149675_a(true);
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
      return 29;
   }

   public int func_149738_a(World p_149738_1_) {
      return 10;
   }

   public boolean func_149707_d(World p_149707_1_, int p_149707_2_, int p_149707_3_, int p_149707_4_, int p_149707_5_) {
      return p_149707_5_ == 2 && p_149707_1_.func_147439_a(p_149707_2_, p_149707_3_, p_149707_4_ + 1).func_149721_r()?true:(p_149707_5_ == 3 && p_149707_1_.func_147439_a(p_149707_2_, p_149707_3_, p_149707_4_ - 1).func_149721_r()?true:(p_149707_5_ == 4 && p_149707_1_.func_147439_a(p_149707_2_ + 1, p_149707_3_, p_149707_4_).func_149721_r()?true:p_149707_5_ == 5 && p_149707_1_.func_147439_a(p_149707_2_ - 1, p_149707_3_, p_149707_4_).func_149721_r()));
   }

   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
      return p_149742_1_.func_147439_a(p_149742_2_ - 1, p_149742_3_, p_149742_4_).func_149721_r()?true:(p_149742_1_.func_147439_a(p_149742_2_ + 1, p_149742_3_, p_149742_4_).func_149721_r()?true:(p_149742_1_.func_147439_a(p_149742_2_, p_149742_3_, p_149742_4_ - 1).func_149721_r()?true:p_149742_1_.func_147439_a(p_149742_2_, p_149742_3_, p_149742_4_ + 1).func_149721_r()));
   }

   public int func_149660_a(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_) {
      byte var10 = 0;
      if(p_149660_5_ == 2 && p_149660_1_.func_147445_c(p_149660_2_, p_149660_3_, p_149660_4_ + 1, true)) {
         var10 = 2;
      }

      if(p_149660_5_ == 3 && p_149660_1_.func_147445_c(p_149660_2_, p_149660_3_, p_149660_4_ - 1, true)) {
         var10 = 0;
      }

      if(p_149660_5_ == 4 && p_149660_1_.func_147445_c(p_149660_2_ + 1, p_149660_3_, p_149660_4_, true)) {
         var10 = 1;
      }

      if(p_149660_5_ == 5 && p_149660_1_.func_147445_c(p_149660_2_ - 1, p_149660_3_, p_149660_4_, true)) {
         var10 = 3;
      }

      return var10;
   }

   public void func_149714_e(World p_149714_1_, int p_149714_2_, int p_149714_3_, int p_149714_4_, int p_149714_5_) {
      this.func_150136_a(p_149714_1_, p_149714_2_, p_149714_3_, p_149714_4_, false, p_149714_5_, false, -1, 0);
   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      if(p_149695_5_ != this) {
         if(this.func_150137_e(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_)) {
            int var6 = p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_);
            int var7 = var6 & 3;
            boolean var8 = false;
            if(!p_149695_1_.func_147439_a(p_149695_2_ - 1, p_149695_3_, p_149695_4_).func_149721_r() && var7 == 3) {
               var8 = true;
            }

            if(!p_149695_1_.func_147439_a(p_149695_2_ + 1, p_149695_3_, p_149695_4_).func_149721_r() && var7 == 1) {
               var8 = true;
            }

            if(!p_149695_1_.func_147439_a(p_149695_2_, p_149695_3_, p_149695_4_ - 1).func_149721_r() && var7 == 0) {
               var8 = true;
            }

            if(!p_149695_1_.func_147439_a(p_149695_2_, p_149695_3_, p_149695_4_ + 1).func_149721_r() && var7 == 2) {
               var8 = true;
            }

            if(var8) {
               this.func_149697_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, var6, 0);
               p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
            }
         }

      }
   }

   public void func_150136_a(World p_150136_1_, int p_150136_2_, int p_150136_3_, int p_150136_4_, boolean p_150136_5_, int p_150136_6_, boolean p_150136_7_, int p_150136_8_, int p_150136_9_) {
      int var10 = p_150136_6_ & 3;
      boolean var11 = (p_150136_6_ & 4) == 4;
      boolean var12 = (p_150136_6_ & 8) == 8;
      boolean var13 = !p_150136_5_;
      boolean var14 = false;
      boolean var15 = !World.func_147466_a(p_150136_1_, p_150136_2_, p_150136_3_ - 1, p_150136_4_);
      int var16 = Direction.field_71583_a[var10];
      int var17 = Direction.field_71581_b[var10];
      int var18 = 0;
      int[] var19 = new int[42];

      int var20;
      int var21;
      int var22;
      int var24;
      for(var20 = 1; var20 < 42; ++var20) {
         var21 = p_150136_2_ + var16 * var20;
         var22 = p_150136_4_ + var17 * var20;
         Block var23 = p_150136_1_.func_147439_a(var21, p_150136_3_, var22);
         if(var23 == Blocks.field_150479_bC) {
            var24 = p_150136_1_.func_72805_g(var21, p_150136_3_, var22);
            if((var24 & 3) == Direction.field_71580_e[var10]) {
               var18 = var20;
            }
            break;
         }

         if(var23 != Blocks.field_150473_bD && var20 != p_150136_8_) {
            var19[var20] = -1;
            var13 = false;
         } else {
            var24 = var20 == p_150136_8_?p_150136_9_:p_150136_1_.func_72805_g(var21, p_150136_3_, var22);
            boolean var25 = (var24 & 8) != 8;
            boolean var26 = (var24 & 1) == 1;
            boolean var27 = (var24 & 2) == 2;
            var13 &= var27 == var15;
            var14 |= var25 && var26;
            var19[var20] = var24;
            if(var20 == p_150136_8_) {
               p_150136_1_.func_147464_a(p_150136_2_, p_150136_3_, p_150136_4_, this, this.func_149738_a(p_150136_1_));
               var13 &= var25;
            }
         }
      }

      var13 &= var18 > 1;
      var14 &= var13;
      var20 = (var13?4:0) | (var14?8:0);
      p_150136_6_ = var10 | var20;
      int var28;
      if(var18 > 0) {
         var21 = p_150136_2_ + var16 * var18;
         var22 = p_150136_4_ + var17 * var18;
         var28 = Direction.field_71580_e[var10];
         p_150136_1_.func_72921_c(var21, p_150136_3_, var22, var28 | var20, 3);
         this.func_150134_a(p_150136_1_, var21, p_150136_3_, var22, var28);
         this.func_150135_a(p_150136_1_, var21, p_150136_3_, var22, var13, var14, var11, var12);
      }

      this.func_150135_a(p_150136_1_, p_150136_2_, p_150136_3_, p_150136_4_, var13, var14, var11, var12);
      if(!p_150136_5_) {
         p_150136_1_.func_72921_c(p_150136_2_, p_150136_3_, p_150136_4_, p_150136_6_, 3);
         if(p_150136_7_) {
            this.func_150134_a(p_150136_1_, p_150136_2_, p_150136_3_, p_150136_4_, var10);
         }
      }

      if(var11 != var13) {
         for(var21 = 1; var21 < var18; ++var21) {
            var22 = p_150136_2_ + var16 * var21;
            var28 = p_150136_4_ + var17 * var21;
            var24 = var19[var21];
            if(var24 >= 0) {
               if(var13) {
                  var24 |= 4;
               } else {
                  var24 &= -5;
               }

               p_150136_1_.func_72921_c(var22, p_150136_3_, var28, var24, 3);
            }
         }
      }

   }

   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      this.func_150136_a(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, false, p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_), true, -1, 0);
   }

   private void func_150135_a(World p_150135_1_, int p_150135_2_, int p_150135_3_, int p_150135_4_, boolean p_150135_5_, boolean p_150135_6_, boolean p_150135_7_, boolean p_150135_8_) {
      if(p_150135_6_ && !p_150135_8_) {
         p_150135_1_.func_72908_a((double)p_150135_2_ + 0.5D, (double)p_150135_3_ + 0.1D, (double)p_150135_4_ + 0.5D, "random.click", 0.4F, 0.6F);
      } else if(!p_150135_6_ && p_150135_8_) {
         p_150135_1_.func_72908_a((double)p_150135_2_ + 0.5D, (double)p_150135_3_ + 0.1D, (double)p_150135_4_ + 0.5D, "random.click", 0.4F, 0.5F);
      } else if(p_150135_5_ && !p_150135_7_) {
         p_150135_1_.func_72908_a((double)p_150135_2_ + 0.5D, (double)p_150135_3_ + 0.1D, (double)p_150135_4_ + 0.5D, "random.click", 0.4F, 0.7F);
      } else if(!p_150135_5_ && p_150135_7_) {
         p_150135_1_.func_72908_a((double)p_150135_2_ + 0.5D, (double)p_150135_3_ + 0.1D, (double)p_150135_4_ + 0.5D, "random.bowhit", 0.4F, 1.2F / (p_150135_1_.field_73012_v.nextFloat() * 0.2F + 0.9F));
      }

   }

   private void func_150134_a(World p_150134_1_, int p_150134_2_, int p_150134_3_, int p_150134_4_, int p_150134_5_) {
      p_150134_1_.func_147459_d(p_150134_2_, p_150134_3_, p_150134_4_, this);
      if(p_150134_5_ == 3) {
         p_150134_1_.func_147459_d(p_150134_2_ - 1, p_150134_3_, p_150134_4_, this);
      } else if(p_150134_5_ == 1) {
         p_150134_1_.func_147459_d(p_150134_2_ + 1, p_150134_3_, p_150134_4_, this);
      } else if(p_150134_5_ == 0) {
         p_150134_1_.func_147459_d(p_150134_2_, p_150134_3_, p_150134_4_ - 1, this);
      } else if(p_150134_5_ == 2) {
         p_150134_1_.func_147459_d(p_150134_2_, p_150134_3_, p_150134_4_ + 1, this);
      }

   }

   private boolean func_150137_e(World p_150137_1_, int p_150137_2_, int p_150137_3_, int p_150137_4_) {
      if(!this.func_149742_c(p_150137_1_, p_150137_2_, p_150137_3_, p_150137_4_)) {
         this.func_149697_b(p_150137_1_, p_150137_2_, p_150137_3_, p_150137_4_, p_150137_1_.func_72805_g(p_150137_2_, p_150137_3_, p_150137_4_), 0);
         p_150137_1_.func_147468_f(p_150137_2_, p_150137_3_, p_150137_4_);
         return false;
      } else {
         return true;
      }
   }

   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
      int var5 = p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_) & 3;
      float var6 = 0.1875F;
      if(var5 == 3) {
         this.func_149676_a(0.0F, 0.2F, 0.5F - var6, var6 * 2.0F, 0.8F, 0.5F + var6);
      } else if(var5 == 1) {
         this.func_149676_a(1.0F - var6 * 2.0F, 0.2F, 0.5F - var6, 1.0F, 0.8F, 0.5F + var6);
      } else if(var5 == 0) {
         this.func_149676_a(0.5F - var6, 0.2F, 0.0F, 0.5F + var6, 0.8F, var6 * 2.0F);
      } else if(var5 == 2) {
         this.func_149676_a(0.5F - var6, 0.2F, 1.0F - var6 * 2.0F, 0.5F + var6, 0.8F, 1.0F);
      }

   }

   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
      boolean var7 = (p_149749_6_ & 4) == 4;
      boolean var8 = (p_149749_6_ & 8) == 8;
      if(var7 || var8) {
         this.func_150136_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, true, p_149749_6_, false, -1, 0);
      }

      if(var8) {
         p_149749_1_.func_147459_d(p_149749_2_, p_149749_3_, p_149749_4_, this);
         int var9 = p_149749_6_ & 3;
         if(var9 == 3) {
            p_149749_1_.func_147459_d(p_149749_2_ - 1, p_149749_3_, p_149749_4_, this);
         } else if(var9 == 1) {
            p_149749_1_.func_147459_d(p_149749_2_ + 1, p_149749_3_, p_149749_4_, this);
         } else if(var9 == 0) {
            p_149749_1_.func_147459_d(p_149749_2_, p_149749_3_, p_149749_4_ - 1, this);
         } else if(var9 == 2) {
            p_149749_1_.func_147459_d(p_149749_2_, p_149749_3_, p_149749_4_ + 1, this);
         }
      }

      super.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
   }

   public int func_149709_b(IBlockAccess p_149709_1_, int p_149709_2_, int p_149709_3_, int p_149709_4_, int p_149709_5_) {
      return (p_149709_1_.func_72805_g(p_149709_2_, p_149709_3_, p_149709_4_) & 8) == 8?15:0;
   }

   public int func_149748_c(IBlockAccess p_149748_1_, int p_149748_2_, int p_149748_3_, int p_149748_4_, int p_149748_5_) {
      int var6 = p_149748_1_.func_72805_g(p_149748_2_, p_149748_3_, p_149748_4_);
      if((var6 & 8) != 8) {
         return 0;
      } else {
         int var7 = var6 & 3;
         return var7 == 2 && p_149748_5_ == 2?15:(var7 == 0 && p_149748_5_ == 3?15:(var7 == 1 && p_149748_5_ == 4?15:(var7 == 3 && p_149748_5_ == 5?15:0)));
      }
   }

   public boolean func_149744_f() {
      return true;
   }
}
