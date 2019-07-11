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

public class BlockCarpet extends Block {

   private static final String __OBFID = "CL_00000338";


   protected BlockCarpet() {
      super(Material.field_151593_r);
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
      this.func_149675_a(true);
      this.func_149647_a(CreativeTabs.field_78031_c);
      this.func_150089_b(0);
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      return Blocks.field_150325_L.func_149691_a(p_149691_1_, p_149691_2_);
   }

   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
      byte var5 = 0;
      float var6 = 0.0625F;
      return AxisAlignedBB.func_72330_a((double)p_149668_2_ + this.field_149759_B, (double)p_149668_3_ + this.field_149760_C, (double)p_149668_4_ + this.field_149754_D, (double)p_149668_2_ + this.field_149755_E, (double)((float)p_149668_3_ + (float)var5 * var6), (double)p_149668_4_ + this.field_149757_G);
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public void func_149683_g() {
      this.func_150089_b(0);
   }

   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
      this.func_150089_b(p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_));
   }

   protected void func_150089_b(int p_150089_1_) {
      byte var2 = 0;
      float var3 = (float)(1 * (1 + var2)) / 16.0F;
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, var3, 1.0F);
   }

   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
      return super.func_149742_c(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_) && this.func_149718_j(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_);
   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      this.func_150090_e(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
   }

   private boolean func_150090_e(World p_150090_1_, int p_150090_2_, int p_150090_3_, int p_150090_4_) {
      if(!this.func_149718_j(p_150090_1_, p_150090_2_, p_150090_3_, p_150090_4_)) {
         this.func_149697_b(p_150090_1_, p_150090_2_, p_150090_3_, p_150090_4_, p_150090_1_.func_72805_g(p_150090_2_, p_150090_3_, p_150090_4_), 0);
         p_150090_1_.func_147468_f(p_150090_2_, p_150090_3_, p_150090_4_);
         return false;
      } else {
         return true;
      }
   }

   public boolean func_149718_j(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
      return !p_149718_1_.func_147437_c(p_149718_2_, p_149718_3_ - 1, p_149718_4_);
   }

   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
      return p_149646_5_ == 1?true:super.func_149646_a(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
   }

   public int func_149692_a(int p_149692_1_) {
      return p_149692_1_;
   }

   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
      for(int var4 = 0; var4 < 16; ++var4) {
         p_149666_3_.add(new ItemStack(p_149666_1_, 1, var4));
      }

   }

   public void func_149651_a(IIconRegister p_149651_1_) {}
}
