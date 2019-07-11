package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Direction;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockVine extends Block {

   private static final String __OBFID = "CL_00000330";


   public BlockVine() {
      super(Material.field_151582_l);
      this.func_149675_a(true);
      this.func_149647_a(CreativeTabs.field_78031_c);
   }

   public void func_149683_g() {
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public int func_149645_b() {
      return 20;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
      float var5 = 0.0625F;
      int var6 = p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_);
      float var7 = 1.0F;
      float var8 = 1.0F;
      float var9 = 1.0F;
      float var10 = 0.0F;
      float var11 = 0.0F;
      float var12 = 0.0F;
      boolean var13 = var6 > 0;
      if((var6 & 2) != 0) {
         var10 = Math.max(var10, 0.0625F);
         var7 = 0.0F;
         var8 = 0.0F;
         var11 = 1.0F;
         var9 = 0.0F;
         var12 = 1.0F;
         var13 = true;
      }

      if((var6 & 8) != 0) {
         var7 = Math.min(var7, 0.9375F);
         var10 = 1.0F;
         var8 = 0.0F;
         var11 = 1.0F;
         var9 = 0.0F;
         var12 = 1.0F;
         var13 = true;
      }

      if((var6 & 4) != 0) {
         var12 = Math.max(var12, 0.0625F);
         var9 = 0.0F;
         var7 = 0.0F;
         var10 = 1.0F;
         var8 = 0.0F;
         var11 = 1.0F;
         var13 = true;
      }

      if((var6 & 1) != 0) {
         var9 = Math.min(var9, 0.9375F);
         var12 = 1.0F;
         var7 = 0.0F;
         var10 = 1.0F;
         var8 = 0.0F;
         var11 = 1.0F;
         var13 = true;
      }

      if(!var13 && this.func_150093_a(p_149719_1_.func_147439_a(p_149719_2_, p_149719_3_ + 1, p_149719_4_))) {
         var8 = Math.min(var8, 0.9375F);
         var11 = 1.0F;
         var7 = 0.0F;
         var10 = 1.0F;
         var9 = 0.0F;
         var12 = 1.0F;
      }

      this.func_149676_a(var7, var8, var9, var10, var11, var12);
   }

   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
      return null;
   }

   public boolean func_149707_d(World p_149707_1_, int p_149707_2_, int p_149707_3_, int p_149707_4_, int p_149707_5_) {
      switch(p_149707_5_) {
      case 1:
         return this.func_150093_a(p_149707_1_.func_147439_a(p_149707_2_, p_149707_3_ + 1, p_149707_4_));
      case 2:
         return this.func_150093_a(p_149707_1_.func_147439_a(p_149707_2_, p_149707_3_, p_149707_4_ + 1));
      case 3:
         return this.func_150093_a(p_149707_1_.func_147439_a(p_149707_2_, p_149707_3_, p_149707_4_ - 1));
      case 4:
         return this.func_150093_a(p_149707_1_.func_147439_a(p_149707_2_ + 1, p_149707_3_, p_149707_4_));
      case 5:
         return this.func_150093_a(p_149707_1_.func_147439_a(p_149707_2_ - 1, p_149707_3_, p_149707_4_));
      default:
         return false;
      }
   }

   private boolean func_150093_a(Block p_150093_1_) {
      return p_150093_1_.func_149686_d() && p_150093_1_.field_149764_J.func_76230_c();
   }

   private boolean func_150094_e(World p_150094_1_, int p_150094_2_, int p_150094_3_, int p_150094_4_) {
      int var5 = p_150094_1_.func_72805_g(p_150094_2_, p_150094_3_, p_150094_4_);
      int var6 = var5;
      if(var5 > 0) {
         for(int var7 = 0; var7 <= 3; ++var7) {
            int var8 = 1 << var7;
            if((var5 & var8) != 0 && !this.func_150093_a(p_150094_1_.func_147439_a(p_150094_2_ + Direction.field_71583_a[var7], p_150094_3_, p_150094_4_ + Direction.field_71581_b[var7])) && (p_150094_1_.func_147439_a(p_150094_2_, p_150094_3_ + 1, p_150094_4_) != this || (p_150094_1_.func_72805_g(p_150094_2_, p_150094_3_ + 1, p_150094_4_) & var8) == 0)) {
               var6 &= ~var8;
            }
         }
      }

      if(var6 == 0 && !this.func_150093_a(p_150094_1_.func_147439_a(p_150094_2_, p_150094_3_ + 1, p_150094_4_))) {
         return false;
      } else {
         if(var6 != var5) {
            p_150094_1_.func_72921_c(p_150094_2_, p_150094_3_, p_150094_4_, var6, 2);
         }

         return true;
      }
   }

   public int func_149635_D() {
      return ColorizerFoliage.func_77468_c();
   }

   public int func_149741_i(int p_149741_1_) {
      return ColorizerFoliage.func_77468_c();
   }

   public int func_149720_d(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
      return p_149720_1_.func_72807_a(p_149720_2_, p_149720_4_).func_150571_c(p_149720_2_, p_149720_3_, p_149720_4_);
   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      if(!p_149695_1_.field_72995_K && !this.func_150094_e(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_)) {
         this.func_149697_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_), 0);
         p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
      }

   }

   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      if(!p_149674_1_.field_72995_K && p_149674_1_.field_73012_v.nextInt(4) == 0) {
         byte var6 = 4;
         int var7 = 5;
         boolean var8 = false;

         int var9;
         int var10;
         int var11;
         label134:
         for(var9 = p_149674_2_ - var6; var9 <= p_149674_2_ + var6; ++var9) {
            for(var10 = p_149674_4_ - var6; var10 <= p_149674_4_ + var6; ++var10) {
               for(var11 = p_149674_3_ - 1; var11 <= p_149674_3_ + 1; ++var11) {
                  if(p_149674_1_.func_147439_a(var9, var11, var10) == this) {
                     --var7;
                     if(var7 <= 0) {
                        var8 = true;
                        break label134;
                     }
                  }
               }
            }
         }

         var9 = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_);
         var10 = p_149674_1_.field_73012_v.nextInt(6);
         var11 = Direction.field_71579_d[var10];
         int var13;
         if(var10 == 1 && p_149674_3_ < 255 && p_149674_1_.func_147437_c(p_149674_2_, p_149674_3_ + 1, p_149674_4_)) {
            if(var8) {
               return;
            }

            int var15 = p_149674_1_.field_73012_v.nextInt(16) & var9;
            if(var15 > 0) {
               for(var13 = 0; var13 <= 3; ++var13) {
                  if(!this.func_150093_a(p_149674_1_.func_147439_a(p_149674_2_ + Direction.field_71583_a[var13], p_149674_3_ + 1, p_149674_4_ + Direction.field_71581_b[var13]))) {
                     var15 &= ~(1 << var13);
                  }
               }

               if(var15 > 0) {
                  p_149674_1_.func_147465_d(p_149674_2_, p_149674_3_ + 1, p_149674_4_, this, var15, 2);
               }
            }
         } else {
            Block var12;
            int var14;
            if(var10 >= 2 && var10 <= 5 && (var9 & 1 << var11) == 0) {
               if(var8) {
                  return;
               }

               var12 = p_149674_1_.func_147439_a(p_149674_2_ + Direction.field_71583_a[var11], p_149674_3_, p_149674_4_ + Direction.field_71581_b[var11]);
               if(var12.field_149764_J == Material.field_151579_a) {
                  var13 = var11 + 1 & 3;
                  var14 = var11 + 3 & 3;
                  if((var9 & 1 << var13) != 0 && this.func_150093_a(p_149674_1_.func_147439_a(p_149674_2_ + Direction.field_71583_a[var11] + Direction.field_71583_a[var13], p_149674_3_, p_149674_4_ + Direction.field_71581_b[var11] + Direction.field_71581_b[var13]))) {
                     p_149674_1_.func_147465_d(p_149674_2_ + Direction.field_71583_a[var11], p_149674_3_, p_149674_4_ + Direction.field_71581_b[var11], this, 1 << var13, 2);
                  } else if((var9 & 1 << var14) != 0 && this.func_150093_a(p_149674_1_.func_147439_a(p_149674_2_ + Direction.field_71583_a[var11] + Direction.field_71583_a[var14], p_149674_3_, p_149674_4_ + Direction.field_71581_b[var11] + Direction.field_71581_b[var14]))) {
                     p_149674_1_.func_147465_d(p_149674_2_ + Direction.field_71583_a[var11], p_149674_3_, p_149674_4_ + Direction.field_71581_b[var11], this, 1 << var14, 2);
                  } else if((var9 & 1 << var13) != 0 && p_149674_1_.func_147437_c(p_149674_2_ + Direction.field_71583_a[var11] + Direction.field_71583_a[var13], p_149674_3_, p_149674_4_ + Direction.field_71581_b[var11] + Direction.field_71581_b[var13]) && this.func_150093_a(p_149674_1_.func_147439_a(p_149674_2_ + Direction.field_71583_a[var13], p_149674_3_, p_149674_4_ + Direction.field_71581_b[var13]))) {
                     p_149674_1_.func_147465_d(p_149674_2_ + Direction.field_71583_a[var11] + Direction.field_71583_a[var13], p_149674_3_, p_149674_4_ + Direction.field_71581_b[var11] + Direction.field_71581_b[var13], this, 1 << (var11 + 2 & 3), 2);
                  } else if((var9 & 1 << var14) != 0 && p_149674_1_.func_147437_c(p_149674_2_ + Direction.field_71583_a[var11] + Direction.field_71583_a[var14], p_149674_3_, p_149674_4_ + Direction.field_71581_b[var11] + Direction.field_71581_b[var14]) && this.func_150093_a(p_149674_1_.func_147439_a(p_149674_2_ + Direction.field_71583_a[var14], p_149674_3_, p_149674_4_ + Direction.field_71581_b[var14]))) {
                     p_149674_1_.func_147465_d(p_149674_2_ + Direction.field_71583_a[var11] + Direction.field_71583_a[var14], p_149674_3_, p_149674_4_ + Direction.field_71581_b[var11] + Direction.field_71581_b[var14], this, 1 << (var11 + 2 & 3), 2);
                  } else if(this.func_150093_a(p_149674_1_.func_147439_a(p_149674_2_ + Direction.field_71583_a[var11], p_149674_3_ + 1, p_149674_4_ + Direction.field_71581_b[var11]))) {
                     p_149674_1_.func_147465_d(p_149674_2_ + Direction.field_71583_a[var11], p_149674_3_, p_149674_4_ + Direction.field_71581_b[var11], this, 0, 2);
                  }
               } else if(var12.field_149764_J.func_76218_k() && var12.func_149686_d()) {
                  p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, var9 | 1 << var11, 2);
               }
            } else if(p_149674_3_ > 1) {
               var12 = p_149674_1_.func_147439_a(p_149674_2_, p_149674_3_ - 1, p_149674_4_);
               if(var12.field_149764_J == Material.field_151579_a) {
                  var13 = p_149674_1_.field_73012_v.nextInt(16) & var9;
                  if(var13 > 0) {
                     p_149674_1_.func_147465_d(p_149674_2_, p_149674_3_ - 1, p_149674_4_, this, var13, 2);
                  }
               } else if(var12 == this) {
                  var13 = p_149674_1_.field_73012_v.nextInt(16) & var9;
                  var14 = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_ - 1, p_149674_4_);
                  if(var14 != (var14 | var13)) {
                     p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_ - 1, p_149674_4_, var14 | var13, 2);
                  }
               }
            }
         }
      }

   }

   public int func_149660_a(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_) {
      byte var10 = 0;
      switch(p_149660_5_) {
      case 2:
         var10 = 1;
         break;
      case 3:
         var10 = 4;
         break;
      case 4:
         var10 = 8;
         break;
      case 5:
         var10 = 2;
      }

      return var10 != 0?var10:p_149660_9_;
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return null;
   }

   public int func_149745_a(Random p_149745_1_) {
      return 0;
   }

   public void func_149636_a(World p_149636_1_, EntityPlayer p_149636_2_, int p_149636_3_, int p_149636_4_, int p_149636_5_, int p_149636_6_) {
      if(!p_149636_1_.field_72995_K && p_149636_2_.func_71045_bC() != null && p_149636_2_.func_71045_bC().func_77973_b() == Items.field_151097_aZ) {
         p_149636_2_.func_71064_a(StatList.field_75934_C[Block.func_149682_b(this)], 1);
         this.func_149642_a(p_149636_1_, p_149636_3_, p_149636_4_, p_149636_5_, new ItemStack(Blocks.field_150395_bd, 1, 0));
      } else {
         super.func_149636_a(p_149636_1_, p_149636_2_, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_);
      }

   }
}
