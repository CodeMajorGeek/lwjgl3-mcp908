package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPistonExtension extends Block {

   private IIcon field_150088_a;
   private static final String __OBFID = "CL_00000367";


   public BlockPistonExtension() {
      super(Material.field_76233_E);
      this.func_149672_a(field_149780_i);
      this.func_149711_c(0.5F);
   }

   public void func_150086_a(IIcon p_150086_1_) {
      this.field_150088_a = p_150086_1_;
   }

   public void func_150087_e() {
      this.field_150088_a = null;
   }

   public void func_149681_a(World p_149681_1_, int p_149681_2_, int p_149681_3_, int p_149681_4_, int p_149681_5_, EntityPlayer p_149681_6_) {
      if(p_149681_6_.field_71075_bZ.field_75098_d) {
         int var7 = func_150085_b(p_149681_5_);
         Block var8 = p_149681_1_.func_147439_a(p_149681_2_ - Facing.field_71586_b[var7], p_149681_3_ - Facing.field_71587_c[var7], p_149681_4_ - Facing.field_71585_d[var7]);
         if(var8 == Blocks.field_150331_J || var8 == Blocks.field_150320_F) {
            p_149681_1_.func_147468_f(p_149681_2_ - Facing.field_71586_b[var7], p_149681_3_ - Facing.field_71587_c[var7], p_149681_4_ - Facing.field_71585_d[var7]);
         }
      }

      super.func_149681_a(p_149681_1_, p_149681_2_, p_149681_3_, p_149681_4_, p_149681_5_, p_149681_6_);
   }

   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
      super.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
      int var7 = Facing.field_71588_a[func_150085_b(p_149749_6_)];
      p_149749_2_ += Facing.field_71586_b[var7];
      p_149749_3_ += Facing.field_71587_c[var7];
      p_149749_4_ += Facing.field_71585_d[var7];
      Block var8 = p_149749_1_.func_147439_a(p_149749_2_, p_149749_3_, p_149749_4_);
      if(var8 == Blocks.field_150331_J || var8 == Blocks.field_150320_F) {
         p_149749_6_ = p_149749_1_.func_72805_g(p_149749_2_, p_149749_3_, p_149749_4_);
         if(BlockPistonBase.func_150075_c(p_149749_6_)) {
            var8.func_149697_b(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_6_, 0);
            p_149749_1_.func_147468_f(p_149749_2_, p_149749_3_, p_149749_4_);
         }
      }

   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      int var3 = func_150085_b(p_149691_2_);
      return p_149691_1_ == var3?(this.field_150088_a != null?this.field_150088_a:((p_149691_2_ & 8) != 0?BlockPistonBase.func_150074_e("piston_top_sticky"):BlockPistonBase.func_150074_e("piston_top_normal"))):(var3 < 6 && p_149691_1_ == Facing.field_71588_a[var3]?BlockPistonBase.func_150074_e("piston_top_normal"):BlockPistonBase.func_150074_e("piston_side"));
   }

   public void func_149651_a(IIconRegister p_149651_1_) {}

   public int func_149645_b() {
      return 17;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
      return false;
   }

   public boolean func_149707_d(World p_149707_1_, int p_149707_2_, int p_149707_3_, int p_149707_4_, int p_149707_5_) {
      return false;
   }

   public int func_149745_a(Random p_149745_1_) {
      return 0;
   }

   public void func_149743_a(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {
      int var8 = p_149743_1_.func_72805_g(p_149743_2_, p_149743_3_, p_149743_4_);
      float var9 = 0.25F;
      float var10 = 0.375F;
      float var11 = 0.625F;
      float var12 = 0.25F;
      float var13 = 0.75F;
      switch(func_150085_b(var8)) {
      case 0:
         this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
         this.func_149676_a(0.375F, 0.25F, 0.375F, 0.625F, 1.0F, 0.625F);
         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
         break;
      case 1:
         this.func_149676_a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
         this.func_149676_a(0.375F, 0.0F, 0.375F, 0.625F, 0.75F, 0.625F);
         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
         break;
      case 2:
         this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
         this.func_149676_a(0.25F, 0.375F, 0.25F, 0.75F, 0.625F, 1.0F);
         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
         break;
      case 3:
         this.func_149676_a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
         this.func_149676_a(0.25F, 0.375F, 0.0F, 0.75F, 0.625F, 0.75F);
         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
         break;
      case 4:
         this.func_149676_a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
         this.func_149676_a(0.375F, 0.25F, 0.25F, 0.625F, 0.75F, 1.0F);
         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
         break;
      case 5:
         this.func_149676_a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
         this.func_149676_a(0.0F, 0.375F, 0.25F, 0.75F, 0.625F, 0.75F);
         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
      }

      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
      int var5 = p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_);
      float var6 = 0.25F;
      switch(func_150085_b(var5)) {
      case 0:
         this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
         break;
      case 1:
         this.func_149676_a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
         break;
      case 2:
         this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
         break;
      case 3:
         this.func_149676_a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
         break;
      case 4:
         this.func_149676_a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
         break;
      case 5:
         this.func_149676_a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      }

   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      int var6 = func_150085_b(p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_));
      Block var7 = p_149695_1_.func_147439_a(p_149695_2_ - Facing.field_71586_b[var6], p_149695_3_ - Facing.field_71587_c[var6], p_149695_4_ - Facing.field_71585_d[var6]);
      if(var7 != Blocks.field_150331_J && var7 != Blocks.field_150320_F) {
         p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
      } else {
         var7.func_149695_a(p_149695_1_, p_149695_2_ - Facing.field_71586_b[var6], p_149695_3_ - Facing.field_71587_c[var6], p_149695_4_ - Facing.field_71585_d[var6], p_149695_5_);
      }

   }

   public static int func_150085_b(int p_150085_0_) {
      return MathHelper.func_76125_a(p_150085_0_ & 7, 0, Facing.field_71586_b.length - 1);
   }

   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
      int var5 = p_149694_1_.func_72805_g(p_149694_2_, p_149694_3_, p_149694_4_);
      return (var5 & 8) != 0?Item.func_150898_a(Blocks.field_150320_F):Item.func_150898_a(Blocks.field_150331_J);
   }
}
