package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockStem extends BlockBush implements IGrowable {

   private final Block field_149877_a;
   private IIcon field_149876_b;
   private static final String __OBFID = "CL_00000316";


   protected BlockStem(Block p_i45430_1_) {
      this.field_149877_a = p_i45430_1_;
      this.func_149675_a(true);
      float var2 = 0.125F;
      this.func_149676_a(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, 0.25F, 0.5F + var2);
      this.func_149647_a((CreativeTabs)null);
   }

   protected boolean func_149854_a(Block p_149854_1_) {
      return p_149854_1_ == Blocks.field_150458_ak;
   }

   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      super.func_149674_a(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
      if(p_149674_1_.func_72957_l(p_149674_2_, p_149674_3_ + 1, p_149674_4_) >= 9) {
         float var6 = this.func_149875_n(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);
         if(p_149674_5_.nextInt((int)(25.0F / var6) + 1) == 0) {
            int var7 = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_);
            if(var7 < 7) {
               ++var7;
               p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, var7, 2);
            } else {
               if(p_149674_1_.func_147439_a(p_149674_2_ - 1, p_149674_3_, p_149674_4_) == this.field_149877_a) {
                  return;
               }

               if(p_149674_1_.func_147439_a(p_149674_2_ + 1, p_149674_3_, p_149674_4_) == this.field_149877_a) {
                  return;
               }

               if(p_149674_1_.func_147439_a(p_149674_2_, p_149674_3_, p_149674_4_ - 1) == this.field_149877_a) {
                  return;
               }

               if(p_149674_1_.func_147439_a(p_149674_2_, p_149674_3_, p_149674_4_ + 1) == this.field_149877_a) {
                  return;
               }

               int var8 = p_149674_5_.nextInt(4);
               int var9 = p_149674_2_;
               int var10 = p_149674_4_;
               if(var8 == 0) {
                  var9 = p_149674_2_ - 1;
               }

               if(var8 == 1) {
                  ++var9;
               }

               if(var8 == 2) {
                  var10 = p_149674_4_ - 1;
               }

               if(var8 == 3) {
                  ++var10;
               }

               Block var11 = p_149674_1_.func_147439_a(var9, p_149674_3_ - 1, var10);
               if(p_149674_1_.func_147439_a(var9, p_149674_3_, var10).field_149764_J == Material.field_151579_a && (var11 == Blocks.field_150458_ak || var11 == Blocks.field_150346_d || var11 == Blocks.field_150349_c)) {
                  p_149674_1_.func_147449_b(var9, p_149674_3_, var10, this.field_149877_a);
               }
            }
         }
      }

   }

   public void func_149874_m(World p_149874_1_, int p_149874_2_, int p_149874_3_, int p_149874_4_) {
      int var5 = p_149874_1_.func_72805_g(p_149874_2_, p_149874_3_, p_149874_4_) + MathHelper.func_76136_a(p_149874_1_.field_73012_v, 2, 5);
      if(var5 > 7) {
         var5 = 7;
      }

      p_149874_1_.func_72921_c(p_149874_2_, p_149874_3_, p_149874_4_, var5, 2);
   }

   private float func_149875_n(World p_149875_1_, int p_149875_2_, int p_149875_3_, int p_149875_4_) {
      float var5 = 1.0F;
      Block var6 = p_149875_1_.func_147439_a(p_149875_2_, p_149875_3_, p_149875_4_ - 1);
      Block var7 = p_149875_1_.func_147439_a(p_149875_2_, p_149875_3_, p_149875_4_ + 1);
      Block var8 = p_149875_1_.func_147439_a(p_149875_2_ - 1, p_149875_3_, p_149875_4_);
      Block var9 = p_149875_1_.func_147439_a(p_149875_2_ + 1, p_149875_3_, p_149875_4_);
      Block var10 = p_149875_1_.func_147439_a(p_149875_2_ - 1, p_149875_3_, p_149875_4_ - 1);
      Block var11 = p_149875_1_.func_147439_a(p_149875_2_ + 1, p_149875_3_, p_149875_4_ - 1);
      Block var12 = p_149875_1_.func_147439_a(p_149875_2_ + 1, p_149875_3_, p_149875_4_ + 1);
      Block var13 = p_149875_1_.func_147439_a(p_149875_2_ - 1, p_149875_3_, p_149875_4_ + 1);
      boolean var14 = var8 == this || var9 == this;
      boolean var15 = var6 == this || var7 == this;
      boolean var16 = var10 == this || var11 == this || var12 == this || var13 == this;

      for(int var17 = p_149875_2_ - 1; var17 <= p_149875_2_ + 1; ++var17) {
         for(int var18 = p_149875_4_ - 1; var18 <= p_149875_4_ + 1; ++var18) {
            Block var19 = p_149875_1_.func_147439_a(var17, p_149875_3_ - 1, var18);
            float var20 = 0.0F;
            if(var19 == Blocks.field_150458_ak) {
               var20 = 1.0F;
               if(p_149875_1_.func_72805_g(var17, p_149875_3_ - 1, var18) > 0) {
                  var20 = 3.0F;
               }
            }

            if(var17 != p_149875_2_ || var18 != p_149875_4_) {
               var20 /= 4.0F;
            }

            var5 += var20;
         }
      }

      if(var16 || var14 && var15) {
         var5 /= 2.0F;
      }

      return var5;
   }

   public int func_149741_i(int p_149741_1_) {
      int var2 = p_149741_1_ * 32;
      int var3 = 255 - p_149741_1_ * 8;
      int var4 = p_149741_1_ * 4;
      return var2 << 16 | var3 << 8 | var4;
   }

   public int func_149720_d(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
      return this.func_149741_i(p_149720_1_.func_72805_g(p_149720_2_, p_149720_3_, p_149720_4_));
   }

   public void func_149683_g() {
      float var1 = 0.125F;
      this.func_149676_a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.25F, 0.5F + var1);
   }

   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
      this.field_149756_F = (double)((float)(p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_) * 2 + 2) / 16.0F);
      float var5 = 0.125F;
      this.func_149676_a(0.5F - var5, 0.0F, 0.5F - var5, 0.5F + var5, (float)this.field_149756_F, 0.5F + var5);
   }

   public int func_149645_b() {
      return 19;
   }

   public int func_149873_e(IBlockAccess p_149873_1_, int p_149873_2_, int p_149873_3_, int p_149873_4_) {
      int var5 = p_149873_1_.func_72805_g(p_149873_2_, p_149873_3_, p_149873_4_);
      return var5 < 7?-1:(p_149873_1_.func_147439_a(p_149873_2_ - 1, p_149873_3_, p_149873_4_) == this.field_149877_a?0:(p_149873_1_.func_147439_a(p_149873_2_ + 1, p_149873_3_, p_149873_4_) == this.field_149877_a?1:(p_149873_1_.func_147439_a(p_149873_2_, p_149873_3_, p_149873_4_ - 1) == this.field_149877_a?2:(p_149873_1_.func_147439_a(p_149873_2_, p_149873_3_, p_149873_4_ + 1) == this.field_149877_a?3:-1))));
   }

   public void func_149690_a(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
      super.func_149690_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_, p_149690_7_);
      if(!p_149690_1_.field_72995_K) {
         Item var8 = null;
         if(this.field_149877_a == Blocks.field_150423_aK) {
            var8 = Items.field_151080_bb;
         }

         if(this.field_149877_a == Blocks.field_150440_ba) {
            var8 = Items.field_151081_bc;
         }

         for(int var9 = 0; var9 < 3; ++var9) {
            if(p_149690_1_.field_73012_v.nextInt(15) <= p_149690_5_) {
               this.func_149642_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, new ItemStack(var8));
            }
         }

      }
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return null;
   }

   public int func_149745_a(Random p_149745_1_) {
      return 1;
   }

   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
      return this.field_149877_a == Blocks.field_150423_aK?Items.field_151080_bb:(this.field_149877_a == Blocks.field_150440_ba?Items.field_151081_bc:Item.func_150899_d(0));
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149761_L = p_149651_1_.func_94245_a(this.func_149641_N() + "_disconnected");
      this.field_149876_b = p_149651_1_.func_94245_a(this.func_149641_N() + "_connected");
   }

   public IIcon func_149872_i() {
      return this.field_149876_b;
   }

   public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
      return p_149851_1_.func_72805_g(p_149851_2_, p_149851_3_, p_149851_4_) != 7;
   }

   public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
      return true;
   }

   public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
      this.func_149874_m(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_);
   }
}
