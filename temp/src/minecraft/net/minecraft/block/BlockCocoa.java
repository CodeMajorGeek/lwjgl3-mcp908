package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockLog;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCocoa extends BlockDirectional implements IGrowable {

   private IIcon[] field_149989_a;
   private static final String __OBFID = "CL_00000216";


   public BlockCocoa() {
      super(Material.field_151585_k);
      this.func_149675_a(true);
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      return this.field_149989_a[2];
   }

   public IIcon func_149988_b(int p_149988_1_) {
      if(p_149988_1_ < 0 || p_149988_1_ >= this.field_149989_a.length) {
         p_149988_1_ = this.field_149989_a.length - 1;
      }

      return this.field_149989_a[p_149988_1_];
   }

   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      if(!this.func_149718_j(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_)) {
         this.func_149697_b(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_), 0);
         p_149674_1_.func_147465_d(p_149674_2_, p_149674_3_, p_149674_4_, func_149729_e(0), 0, 2);
      } else if(p_149674_1_.field_73012_v.nextInt(5) == 0) {
         int var6 = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_);
         int var7 = func_149987_c(var6);
         if(var7 < 2) {
            ++var7;
            p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, var7 << 2 | func_149895_l(var6), 2);
         }
      }

   }

   public boolean func_149718_j(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
      int var5 = func_149895_l(p_149718_1_.func_72805_g(p_149718_2_, p_149718_3_, p_149718_4_));
      p_149718_2_ += Direction.field_71583_a[var5];
      p_149718_4_ += Direction.field_71581_b[var5];
      Block var6 = p_149718_1_.func_147439_a(p_149718_2_, p_149718_3_, p_149718_4_);
      return var6 == Blocks.field_150364_r && BlockLog.func_150165_c(p_149718_1_.func_72805_g(p_149718_2_, p_149718_3_, p_149718_4_)) == 3;
   }

   public int func_149645_b() {
      return 28;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149662_c() {
      return false;
   }

   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
      this.func_149719_a(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
      return super.func_149668_a(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
   }

   public AxisAlignedBB func_149633_g(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_) {
      this.func_149719_a(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
      return super.func_149633_g(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
   }

   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
      int var5 = p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_);
      int var6 = func_149895_l(var5);
      int var7 = func_149987_c(var5);
      int var8 = 4 + var7 * 2;
      int var9 = 5 + var7 * 2;
      float var10 = (float)var8 / 2.0F;
      switch(var6) {
      case 0:
         this.func_149676_a((8.0F - var10) / 16.0F, (12.0F - (float)var9) / 16.0F, (15.0F - (float)var8) / 16.0F, (8.0F + var10) / 16.0F, 0.75F, 0.9375F);
         break;
      case 1:
         this.func_149676_a(0.0625F, (12.0F - (float)var9) / 16.0F, (8.0F - var10) / 16.0F, (1.0F + (float)var8) / 16.0F, 0.75F, (8.0F + var10) / 16.0F);
         break;
      case 2:
         this.func_149676_a((8.0F - var10) / 16.0F, (12.0F - (float)var9) / 16.0F, 0.0625F, (8.0F + var10) / 16.0F, 0.75F, (1.0F + (float)var8) / 16.0F);
         break;
      case 3:
         this.func_149676_a((15.0F - (float)var8) / 16.0F, (12.0F - (float)var9) / 16.0F, (8.0F - var10) / 16.0F, 0.9375F, 0.75F, (8.0F + var10) / 16.0F);
      }

   }

   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
      int var7 = ((MathHelper.func_76128_c((double)(p_149689_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3) + 0) % 4;
      p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, var7, 2);
   }

   public int func_149660_a(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_) {
      if(p_149660_5_ == 1 || p_149660_5_ == 0) {
         p_149660_5_ = 2;
      }

      return Direction.field_71580_e[Direction.field_71579_d[p_149660_5_]];
   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      if(!this.func_149718_j(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_)) {
         this.func_149697_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_), 0);
         p_149695_1_.func_147465_d(p_149695_2_, p_149695_3_, p_149695_4_, func_149729_e(0), 0, 2);
      }

   }

   public static int func_149987_c(int p_149987_0_) {
      return (p_149987_0_ & 12) >> 2;
   }

   public void func_149690_a(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
      int var8 = func_149987_c(p_149690_5_);
      byte var9 = 1;
      if(var8 >= 2) {
         var9 = 3;
      }

      for(int var10 = 0; var10 < var9; ++var10) {
         this.func_149642_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, new ItemStack(Items.field_151100_aR, 1, 3));
      }

   }

   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
      return Items.field_151100_aR;
   }

   public int func_149643_k(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_) {
      return 3;
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149989_a = new IIcon[3];

      for(int var2 = 0; var2 < this.field_149989_a.length; ++var2) {
         this.field_149989_a[var2] = p_149651_1_.func_94245_a(this.func_149641_N() + "_stage_" + var2);
      }

   }

   public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
      int var6 = p_149851_1_.func_72805_g(p_149851_2_, p_149851_3_, p_149851_4_);
      int var7 = func_149987_c(var6);
      return var7 < 2;
   }

   public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
      return true;
   }

   public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
      int var6 = p_149853_1_.func_72805_g(p_149853_3_, p_149853_4_, p_149853_5_);
      int var7 = BlockDirectional.func_149895_l(var6);
      int var8 = func_149987_c(var6);
      ++var8;
      p_149853_1_.func_72921_c(p_149853_3_, p_149853_4_, p_149853_5_, var8 << 2 | var7, 2);
   }
}
