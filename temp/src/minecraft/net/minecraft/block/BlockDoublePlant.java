package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDoublePlant extends BlockBush implements IGrowable {

   public static final String[] field_149892_a = new String[]{"sunflower", "syringa", "grass", "fern", "rose", "paeonia"};
   private IIcon[] field_149893_M;
   private IIcon[] field_149894_N;
   public IIcon[] field_149891_b;
   private static final String __OBFID = "CL_00000231";


   public BlockDoublePlant() {
      super(Material.field_151585_k);
      this.func_149711_c(0.0F);
      this.func_149672_a(field_149779_h);
      this.func_149663_c("doublePlant");
   }

   public int func_149645_b() {
      return 40;
   }

   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public int func_149885_e(IBlockAccess p_149885_1_, int p_149885_2_, int p_149885_3_, int p_149885_4_) {
      int var5 = p_149885_1_.func_72805_g(p_149885_2_, p_149885_3_, p_149885_4_);
      return !func_149887_c(var5)?var5 & 7:p_149885_1_.func_72805_g(p_149885_2_, p_149885_3_ - 1, p_149885_4_) & 7;
   }

   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
      return super.func_149742_c(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_) && p_149742_1_.func_147437_c(p_149742_2_, p_149742_3_ + 1, p_149742_4_);
   }

   protected void func_149855_e(World p_149855_1_, int p_149855_2_, int p_149855_3_, int p_149855_4_) {
      if(!this.func_149718_j(p_149855_1_, p_149855_2_, p_149855_3_, p_149855_4_)) {
         int var5 = p_149855_1_.func_72805_g(p_149855_2_, p_149855_3_, p_149855_4_);
         if(!func_149887_c(var5)) {
            this.func_149697_b(p_149855_1_, p_149855_2_, p_149855_3_, p_149855_4_, var5, 0);
            if(p_149855_1_.func_147439_a(p_149855_2_, p_149855_3_ + 1, p_149855_4_) == this) {
               p_149855_1_.func_147465_d(p_149855_2_, p_149855_3_ + 1, p_149855_4_, Blocks.field_150350_a, 0, 2);
            }
         }

         p_149855_1_.func_147465_d(p_149855_2_, p_149855_3_, p_149855_4_, Blocks.field_150350_a, 0, 2);
      }

   }

   public boolean func_149718_j(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
      int var5 = p_149718_1_.func_72805_g(p_149718_2_, p_149718_3_, p_149718_4_);
      return func_149887_c(var5)?p_149718_1_.func_147439_a(p_149718_2_, p_149718_3_ - 1, p_149718_4_) == this:p_149718_1_.func_147439_a(p_149718_2_, p_149718_3_ + 1, p_149718_4_) == this && super.func_149718_j(p_149718_1_, p_149718_2_, p_149718_3_, p_149718_4_);
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      if(func_149887_c(p_149650_1_)) {
         return null;
      } else {
         int var4 = func_149890_d(p_149650_1_);
         return var4 != 3 && var4 != 2?Item.func_150898_a(this):null;
      }
   }

   public int func_149692_a(int p_149692_1_) {
      return func_149887_c(p_149692_1_)?0:p_149692_1_ & 7;
   }

   public static boolean func_149887_c(int p_149887_0_) {
      return (p_149887_0_ & 8) != 0;
   }

   public static int func_149890_d(int p_149890_0_) {
      return p_149890_0_ & 7;
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      return func_149887_c(p_149691_2_)?this.field_149893_M[0]:this.field_149893_M[p_149691_2_ & 7];
   }

   public IIcon func_149888_a(boolean p_149888_1_, int p_149888_2_) {
      return p_149888_1_?this.field_149894_N[p_149888_2_]:this.field_149893_M[p_149888_2_];
   }

   public int func_149720_d(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
      int var5 = this.func_149885_e(p_149720_1_, p_149720_2_, p_149720_3_, p_149720_4_);
      return var5 != 2 && var5 != 3?16777215:p_149720_1_.func_72807_a(p_149720_2_, p_149720_4_).func_150558_b(p_149720_2_, p_149720_3_, p_149720_4_);
   }

   public void func_149889_c(World p_149889_1_, int p_149889_2_, int p_149889_3_, int p_149889_4_, int p_149889_5_, int p_149889_6_) {
      p_149889_1_.func_147465_d(p_149889_2_, p_149889_3_, p_149889_4_, this, p_149889_5_, p_149889_6_);
      p_149889_1_.func_147465_d(p_149889_2_, p_149889_3_ + 1, p_149889_4_, this, 8, p_149889_6_);
   }

   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
      int var7 = ((MathHelper.func_76128_c((double)(p_149689_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3) + 2) % 4;
      p_149689_1_.func_147465_d(p_149689_2_, p_149689_3_ + 1, p_149689_4_, this, 8 | var7, 2);
   }

   public void func_149636_a(World p_149636_1_, EntityPlayer p_149636_2_, int p_149636_3_, int p_149636_4_, int p_149636_5_, int p_149636_6_) {
      if(p_149636_1_.field_72995_K || p_149636_2_.func_71045_bC() == null || p_149636_2_.func_71045_bC().func_77973_b() != Items.field_151097_aZ || func_149887_c(p_149636_6_) || !this.func_149886_b(p_149636_1_, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_, p_149636_2_)) {
         super.func_149636_a(p_149636_1_, p_149636_2_, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_);
      }
   }

   public void func_149681_a(World p_149681_1_, int p_149681_2_, int p_149681_3_, int p_149681_4_, int p_149681_5_, EntityPlayer p_149681_6_) {
      if(func_149887_c(p_149681_5_)) {
         if(p_149681_1_.func_147439_a(p_149681_2_, p_149681_3_ - 1, p_149681_4_) == this) {
            if(!p_149681_6_.field_71075_bZ.field_75098_d) {
               int var7 = p_149681_1_.func_72805_g(p_149681_2_, p_149681_3_ - 1, p_149681_4_);
               int var8 = func_149890_d(var7);
               if(var8 != 3 && var8 != 2) {
                  p_149681_1_.func_147480_a(p_149681_2_, p_149681_3_ - 1, p_149681_4_, true);
               } else {
                  if(!p_149681_1_.field_72995_K && p_149681_6_.func_71045_bC() != null && p_149681_6_.func_71045_bC().func_77973_b() == Items.field_151097_aZ) {
                     this.func_149886_b(p_149681_1_, p_149681_2_, p_149681_3_, p_149681_4_, var7, p_149681_6_);
                  }

                  p_149681_1_.func_147468_f(p_149681_2_, p_149681_3_ - 1, p_149681_4_);
               }
            } else {
               p_149681_1_.func_147468_f(p_149681_2_, p_149681_3_ - 1, p_149681_4_);
            }
         }
      } else if(p_149681_6_.field_71075_bZ.field_75098_d && p_149681_1_.func_147439_a(p_149681_2_, p_149681_3_ + 1, p_149681_4_) == this) {
         p_149681_1_.func_147465_d(p_149681_2_, p_149681_3_ + 1, p_149681_4_, Blocks.field_150350_a, 0, 2);
      }

      super.func_149681_a(p_149681_1_, p_149681_2_, p_149681_3_, p_149681_4_, p_149681_5_, p_149681_6_);
   }

   private boolean func_149886_b(World p_149886_1_, int p_149886_2_, int p_149886_3_, int p_149886_4_, int p_149886_5_, EntityPlayer p_149886_6_) {
      int var7 = func_149890_d(p_149886_5_);
      if(var7 != 3 && var7 != 2) {
         return false;
      } else {
         p_149886_6_.func_71064_a(StatList.field_75934_C[Block.func_149682_b(this)], 1);
         byte var8 = 1;
         if(var7 == 3) {
            var8 = 2;
         }

         this.func_149642_a(p_149886_1_, p_149886_2_, p_149886_3_, p_149886_4_, new ItemStack(Blocks.field_150329_H, 2, var8));
         return true;
      }
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149893_M = new IIcon[field_149892_a.length];
      this.field_149894_N = new IIcon[field_149892_a.length];

      for(int var2 = 0; var2 < this.field_149893_M.length; ++var2) {
         this.field_149893_M[var2] = p_149651_1_.func_94245_a("double_plant_" + field_149892_a[var2] + "_bottom");
         this.field_149894_N[var2] = p_149651_1_.func_94245_a("double_plant_" + field_149892_a[var2] + "_top");
      }

      this.field_149891_b = new IIcon[2];
      this.field_149891_b[0] = p_149651_1_.func_94245_a("double_plant_sunflower_front");
      this.field_149891_b[1] = p_149651_1_.func_94245_a("double_plant_sunflower_back");
   }

   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
      for(int var4 = 0; var4 < this.field_149893_M.length; ++var4) {
         p_149666_3_.add(new ItemStack(p_149666_1_, 1, var4));
      }

   }

   public int func_149643_k(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_) {
      int var5 = p_149643_1_.func_72805_g(p_149643_2_, p_149643_3_, p_149643_4_);
      return func_149887_c(var5)?func_149890_d(p_149643_1_.func_72805_g(p_149643_2_, p_149643_3_ - 1, p_149643_4_)):func_149890_d(var5);
   }

   public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
      int var6 = this.func_149885_e(p_149851_1_, p_149851_2_, p_149851_3_, p_149851_4_);
      return var6 != 2 && var6 != 3;
   }

   public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
      return true;
   }

   public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
      int var6 = this.func_149885_e(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_);
      this.func_149642_a(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_, new ItemStack(this, 1, var6));
   }

}
