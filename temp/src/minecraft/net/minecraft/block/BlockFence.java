package net.minecraft.block;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemLead;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFence extends Block {

   private final String field_149827_a;
   private static final String __OBFID = "CL_00000242";


   public BlockFence(String p_i45406_1_, Material p_i45406_2_) {
      super(p_i45406_2_);
      this.field_149827_a = p_i45406_1_;
      this.func_149647_a(CreativeTabs.field_78031_c);
   }

   public void func_149743_a(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {
      boolean var8 = this.func_149826_e(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_ - 1);
      boolean var9 = this.func_149826_e(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_ + 1);
      boolean var10 = this.func_149826_e(p_149743_1_, p_149743_2_ - 1, p_149743_3_, p_149743_4_);
      boolean var11 = this.func_149826_e(p_149743_1_, p_149743_2_ + 1, p_149743_3_, p_149743_4_);
      float var12 = 0.375F;
      float var13 = 0.625F;
      float var14 = 0.375F;
      float var15 = 0.625F;
      if(var8) {
         var14 = 0.0F;
      }

      if(var9) {
         var15 = 1.0F;
      }

      if(var8 || var9) {
         this.func_149676_a(var12, 0.0F, var14, var13, 1.5F, var15);
         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
      }

      var14 = 0.375F;
      var15 = 0.625F;
      if(var10) {
         var12 = 0.0F;
      }

      if(var11) {
         var13 = 1.0F;
      }

      if(var10 || var11 || !var8 && !var9) {
         this.func_149676_a(var12, 0.0F, var14, var13, 1.5F, var15);
         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
      }

      if(var8) {
         var14 = 0.0F;
      }

      if(var9) {
         var15 = 1.0F;
      }

      this.func_149676_a(var12, 0.0F, var14, var13, 1.0F, var15);
   }

   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
      boolean var5 = this.func_149826_e(p_149719_1_, p_149719_2_, p_149719_3_, p_149719_4_ - 1);
      boolean var6 = this.func_149826_e(p_149719_1_, p_149719_2_, p_149719_3_, p_149719_4_ + 1);
      boolean var7 = this.func_149826_e(p_149719_1_, p_149719_2_ - 1, p_149719_3_, p_149719_4_);
      boolean var8 = this.func_149826_e(p_149719_1_, p_149719_2_ + 1, p_149719_3_, p_149719_4_);
      float var9 = 0.375F;
      float var10 = 0.625F;
      float var11 = 0.375F;
      float var12 = 0.625F;
      if(var5) {
         var11 = 0.0F;
      }

      if(var6) {
         var12 = 1.0F;
      }

      if(var7) {
         var9 = 0.0F;
      }

      if(var8) {
         var10 = 1.0F;
      }

      this.func_149676_a(var9, 0.0F, var11, var10, 1.0F, var12);
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149655_b(IBlockAccess p_149655_1_, int p_149655_2_, int p_149655_3_, int p_149655_4_) {
      return false;
   }

   public int func_149645_b() {
      return 11;
   }

   public boolean func_149826_e(IBlockAccess p_149826_1_, int p_149826_2_, int p_149826_3_, int p_149826_4_) {
      Block var5 = p_149826_1_.func_147439_a(p_149826_2_, p_149826_3_, p_149826_4_);
      return var5 != this && var5 != Blocks.field_150396_be?(var5.field_149764_J.func_76218_k() && var5.func_149686_d()?var5.field_149764_J != Material.field_151572_C:false):true;
   }

   public static boolean func_149825_a(Block p_149825_0_) {
      return p_149825_0_ == Blocks.field_150422_aJ || p_149825_0_ == Blocks.field_150386_bk;
   }

   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
      return true;
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149761_L = p_149651_1_.func_94245_a(this.field_149827_a);
   }

   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
      return p_149727_1_.field_72995_K?true:ItemLead.func_150909_a(p_149727_5_, p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_);
   }
}
