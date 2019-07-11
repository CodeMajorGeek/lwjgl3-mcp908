package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCake extends Block {

   private IIcon field_150038_a;
   private IIcon field_150037_b;
   private IIcon field_150039_M;
   private static final String __OBFID = "CL_00000211";


   protected BlockCake() {
      super(Material.field_151568_F);
      this.func_149675_a(true);
   }

   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
      int var5 = p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_);
      float var6 = 0.0625F;
      float var7 = (float)(1 + var5 * 2) / 16.0F;
      float var8 = 0.5F;
      this.func_149676_a(var7, 0.0F, var6, 1.0F - var6, var8, 1.0F - var6);
   }

   public void func_149683_g() {
      float var1 = 0.0625F;
      float var2 = 0.5F;
      this.func_149676_a(var1, 0.0F, var1, 1.0F - var1, var2, 1.0F - var1);
   }

   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
      int var5 = p_149668_1_.func_72805_g(p_149668_2_, p_149668_3_, p_149668_4_);
      float var6 = 0.0625F;
      float var7 = (float)(1 + var5 * 2) / 16.0F;
      float var8 = 0.5F;
      return AxisAlignedBB.func_72330_a((double)((float)p_149668_2_ + var7), (double)p_149668_3_, (double)((float)p_149668_4_ + var6), (double)((float)(p_149668_2_ + 1) - var6), (double)((float)p_149668_3_ + var8 - var6), (double)((float)(p_149668_4_ + 1) - var6));
   }

   public AxisAlignedBB func_149633_g(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_) {
      int var5 = p_149633_1_.func_72805_g(p_149633_2_, p_149633_3_, p_149633_4_);
      float var6 = 0.0625F;
      float var7 = (float)(1 + var5 * 2) / 16.0F;
      float var8 = 0.5F;
      return AxisAlignedBB.func_72330_a((double)((float)p_149633_2_ + var7), (double)p_149633_3_, (double)((float)p_149633_4_ + var6), (double)((float)(p_149633_2_ + 1) - var6), (double)((float)p_149633_3_ + var8), (double)((float)(p_149633_4_ + 1) - var6));
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      return p_149691_1_ == 1?this.field_150038_a:(p_149691_1_ == 0?this.field_150037_b:(p_149691_2_ > 0 && p_149691_1_ == 4?this.field_150039_M:this.field_149761_L));
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149761_L = p_149651_1_.func_94245_a(this.func_149641_N() + "_side");
      this.field_150039_M = p_149651_1_.func_94245_a(this.func_149641_N() + "_inner");
      this.field_150038_a = p_149651_1_.func_94245_a(this.func_149641_N() + "_top");
      this.field_150037_b = p_149651_1_.func_94245_a(this.func_149641_N() + "_bottom");
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
      this.func_150036_b(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, p_149727_5_);
      return true;
   }

   public void func_149699_a(World p_149699_1_, int p_149699_2_, int p_149699_3_, int p_149699_4_, EntityPlayer p_149699_5_) {
      this.func_150036_b(p_149699_1_, p_149699_2_, p_149699_3_, p_149699_4_, p_149699_5_);
   }

   private void func_150036_b(World p_150036_1_, int p_150036_2_, int p_150036_3_, int p_150036_4_, EntityPlayer p_150036_5_) {
      if(p_150036_5_.func_71043_e(false)) {
         p_150036_5_.func_71024_bL().func_75122_a(2, 0.1F);
         int var6 = p_150036_1_.func_72805_g(p_150036_2_, p_150036_3_, p_150036_4_) + 1;
         if(var6 >= 6) {
            p_150036_1_.func_147468_f(p_150036_2_, p_150036_3_, p_150036_4_);
         } else {
            p_150036_1_.func_72921_c(p_150036_2_, p_150036_3_, p_150036_4_, var6, 2);
         }
      }

   }

   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
      return !super.func_149742_c(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_)?false:this.func_149718_j(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_);
   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      if(!this.func_149718_j(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_)) {
         p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
      }

   }

   public boolean func_149718_j(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
      return p_149718_1_.func_147439_a(p_149718_2_, p_149718_3_ - 1, p_149718_4_).func_149688_o().func_76220_a();
   }

   public int func_149745_a(Random p_149745_1_) {
      return 0;
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return null;
   }

   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
      return Items.field_151105_aU;
   }
}
