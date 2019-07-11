package net.minecraft.block;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockWall extends Block {

   public static final String[] field_150092_a = new String[]{"normal", "mossy"};
   private static final String __OBFID = "CL_00000331";


   public BlockWall(Block p_i45435_1_) {
      super(p_i45435_1_.field_149764_J);
      this.func_149711_c(p_i45435_1_.field_149782_v);
      this.func_149752_b(p_i45435_1_.field_149781_w / 3.0F);
      this.func_149672_a(p_i45435_1_.field_149762_H);
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      return p_149691_2_ == 1?Blocks.field_150341_Y.func_149733_h(p_149691_1_):Blocks.field_150347_e.func_149733_h(p_149691_1_);
   }

   public int func_149645_b() {
      return 32;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149655_b(IBlockAccess p_149655_1_, int p_149655_2_, int p_149655_3_, int p_149655_4_) {
      return false;
   }

   public boolean func_149662_c() {
      return false;
   }

   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
      boolean var5 = this.func_150091_e(p_149719_1_, p_149719_2_, p_149719_3_, p_149719_4_ - 1);
      boolean var6 = this.func_150091_e(p_149719_1_, p_149719_2_, p_149719_3_, p_149719_4_ + 1);
      boolean var7 = this.func_150091_e(p_149719_1_, p_149719_2_ - 1, p_149719_3_, p_149719_4_);
      boolean var8 = this.func_150091_e(p_149719_1_, p_149719_2_ + 1, p_149719_3_, p_149719_4_);
      float var9 = 0.25F;
      float var10 = 0.75F;
      float var11 = 0.25F;
      float var12 = 0.75F;
      float var13 = 1.0F;
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

      if(var5 && var6 && !var7 && !var8) {
         var13 = 0.8125F;
         var9 = 0.3125F;
         var10 = 0.6875F;
      } else if(!var5 && !var6 && var7 && var8) {
         var13 = 0.8125F;
         var11 = 0.3125F;
         var12 = 0.6875F;
      }

      this.func_149676_a(var9, 0.0F, var11, var10, var13, var12);
   }

   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
      this.func_149719_a(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
      this.field_149756_F = 1.5D;
      return super.func_149668_a(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
   }

   public boolean func_150091_e(IBlockAccess p_150091_1_, int p_150091_2_, int p_150091_3_, int p_150091_4_) {
      Block var5 = p_150091_1_.func_147439_a(p_150091_2_, p_150091_3_, p_150091_4_);
      return var5 != this && var5 != Blocks.field_150396_be?(var5.field_149764_J.func_76218_k() && var5.func_149686_d()?var5.field_149764_J != Material.field_151572_C:false):true;
   }

   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
      p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
      p_149666_3_.add(new ItemStack(p_149666_1_, 1, 1));
   }

   public int func_149692_a(int p_149692_1_) {
      return p_149692_1_;
   }

   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
      return p_149646_5_ == 0?super.func_149646_a(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_):true;
   }

   public void func_149651_a(IIconRegister p_149651_1_) {}

}
