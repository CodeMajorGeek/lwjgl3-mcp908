package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPane extends Block {

   private final String field_150100_a;
   private final boolean field_150099_b;
   private final String field_150101_M;
   private IIcon field_150102_N;
   private static final String __OBFID = "CL_00000322";


   protected BlockPane(String p_i45432_1_, String p_i45432_2_, Material p_i45432_3_, boolean p_i45432_4_) {
      super(p_i45432_3_);
      this.field_150100_a = p_i45432_2_;
      this.field_150099_b = p_i45432_4_;
      this.field_150101_M = p_i45432_1_;
      this.func_149647_a(CreativeTabs.field_78031_c);
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return !this.field_150099_b?null:super.func_149650_a(p_149650_1_, p_149650_2_, p_149650_3_);
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public int func_149645_b() {
      return this.field_149764_J == Material.field_151592_s?41:18;
   }

   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
      return p_149646_1_.func_147439_a(p_149646_2_, p_149646_3_, p_149646_4_) == this?false:super.func_149646_a(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
   }

   public void func_149743_a(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {
      boolean var8 = this.func_150098_a(p_149743_1_.func_147439_a(p_149743_2_, p_149743_3_, p_149743_4_ - 1));
      boolean var9 = this.func_150098_a(p_149743_1_.func_147439_a(p_149743_2_, p_149743_3_, p_149743_4_ + 1));
      boolean var10 = this.func_150098_a(p_149743_1_.func_147439_a(p_149743_2_ - 1, p_149743_3_, p_149743_4_));
      boolean var11 = this.func_150098_a(p_149743_1_.func_147439_a(p_149743_2_ + 1, p_149743_3_, p_149743_4_));
      if((!var10 || !var11) && (var10 || var11 || var8 || var9)) {
         if(var10 && !var11) {
            this.func_149676_a(0.0F, 0.0F, 0.4375F, 0.5F, 1.0F, 0.5625F);
            super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
         } else if(!var10 && var11) {
            this.func_149676_a(0.5F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
            super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
         }
      } else {
         this.func_149676_a(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
      }

      if((!var8 || !var9) && (var10 || var11 || var8 || var9)) {
         if(var8 && !var9) {
            this.func_149676_a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 0.5F);
            super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
         } else if(!var8 && var9) {
            this.func_149676_a(0.4375F, 0.0F, 0.5F, 0.5625F, 1.0F, 1.0F);
            super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
         }
      } else {
         this.func_149676_a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 1.0F);
         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
      }

   }

   public void func_149683_g() {
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
      float var5 = 0.4375F;
      float var6 = 0.5625F;
      float var7 = 0.4375F;
      float var8 = 0.5625F;
      boolean var9 = this.func_150098_a(p_149719_1_.func_147439_a(p_149719_2_, p_149719_3_, p_149719_4_ - 1));
      boolean var10 = this.func_150098_a(p_149719_1_.func_147439_a(p_149719_2_, p_149719_3_, p_149719_4_ + 1));
      boolean var11 = this.func_150098_a(p_149719_1_.func_147439_a(p_149719_2_ - 1, p_149719_3_, p_149719_4_));
      boolean var12 = this.func_150098_a(p_149719_1_.func_147439_a(p_149719_2_ + 1, p_149719_3_, p_149719_4_));
      if((!var11 || !var12) && (var11 || var12 || var9 || var10)) {
         if(var11 && !var12) {
            var5 = 0.0F;
         } else if(!var11 && var12) {
            var6 = 1.0F;
         }
      } else {
         var5 = 0.0F;
         var6 = 1.0F;
      }

      if((!var9 || !var10) && (var11 || var12 || var9 || var10)) {
         if(var9 && !var10) {
            var7 = 0.0F;
         } else if(!var9 && var10) {
            var8 = 1.0F;
         }
      } else {
         var7 = 0.0F;
         var8 = 1.0F;
      }

      this.func_149676_a(var5, 0.0F, var7, var6, 1.0F, var8);
   }

   public IIcon func_150097_e() {
      return this.field_150102_N;
   }

   public final boolean func_150098_a(Block p_150098_1_) {
      return p_150098_1_.func_149730_j() || p_150098_1_ == this || p_150098_1_ == Blocks.field_150359_w || p_150098_1_ == Blocks.field_150399_cn || p_150098_1_ == Blocks.field_150397_co || p_150098_1_ instanceof BlockPane;
   }

   protected boolean func_149700_E() {
      return true;
   }

   protected ItemStack func_149644_j(int p_149644_1_) {
      return new ItemStack(Item.func_150898_a(this), 1, p_149644_1_);
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149761_L = p_149651_1_.func_94245_a(this.field_150101_M);
      this.field_150102_N = p_149651_1_.func_94245_a(this.field_150100_a);
   }
}
