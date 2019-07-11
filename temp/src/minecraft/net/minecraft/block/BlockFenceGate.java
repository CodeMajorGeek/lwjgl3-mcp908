package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFenceGate extends BlockDirectional {

   private static final String __OBFID = "CL_00000243";


   public BlockFenceGate() {
      super(Material.field_151575_d);
      this.func_149647_a(CreativeTabs.field_78028_d);
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      return Blocks.field_150344_f.func_149733_h(p_149691_1_);
   }

   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
      return !p_149742_1_.func_147439_a(p_149742_2_, p_149742_3_ - 1, p_149742_4_).func_149688_o().func_76220_a()?false:super.func_149742_c(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_);
   }

   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
      int var5 = p_149668_1_.func_72805_g(p_149668_2_, p_149668_3_, p_149668_4_);
      return func_149896_b(var5)?null:(var5 != 2 && var5 != 0?AxisAlignedBB.func_72330_a((double)((float)p_149668_2_ + 0.375F), (double)p_149668_3_, (double)p_149668_4_, (double)((float)p_149668_2_ + 0.625F), (double)((float)p_149668_3_ + 1.5F), (double)(p_149668_4_ + 1)):AxisAlignedBB.func_72330_a((double)p_149668_2_, (double)p_149668_3_, (double)((float)p_149668_4_ + 0.375F), (double)(p_149668_2_ + 1), (double)((float)p_149668_3_ + 1.5F), (double)((float)p_149668_4_ + 0.625F)));
   }

   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
      int var5 = func_149895_l(p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_));
      if(var5 != 2 && var5 != 0) {
         this.func_149676_a(0.375F, 0.0F, 0.0F, 0.625F, 1.0F, 1.0F);
      } else {
         this.func_149676_a(0.0F, 0.0F, 0.375F, 1.0F, 1.0F, 0.625F);
      }

   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149655_b(IBlockAccess p_149655_1_, int p_149655_2_, int p_149655_3_, int p_149655_4_) {
      return func_149896_b(p_149655_1_.func_72805_g(p_149655_2_, p_149655_3_, p_149655_4_));
   }

   public int func_149645_b() {
      return 21;
   }

   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
      int var7 = (MathHelper.func_76128_c((double)(p_149689_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3) % 4;
      p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, var7, 2);
   }

   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
      int var10 = p_149727_1_.func_72805_g(p_149727_2_, p_149727_3_, p_149727_4_);
      if(func_149896_b(var10)) {
         p_149727_1_.func_72921_c(p_149727_2_, p_149727_3_, p_149727_4_, var10 & -5, 2);
      } else {
         int var11 = (MathHelper.func_76128_c((double)(p_149727_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3) % 4;
         int var12 = func_149895_l(var10);
         if(var12 == (var11 + 2) % 4) {
            var10 = var11;
         }

         p_149727_1_.func_72921_c(p_149727_2_, p_149727_3_, p_149727_4_, var10 | 4, 2);
      }

      p_149727_1_.func_72889_a(p_149727_5_, 1003, p_149727_2_, p_149727_3_, p_149727_4_, 0);
      return true;
   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      if(!p_149695_1_.field_72995_K) {
         int var6 = p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_);
         boolean var7 = p_149695_1_.func_72864_z(p_149695_2_, p_149695_3_, p_149695_4_);
         if(var7 || p_149695_5_.func_149744_f()) {
            if(var7 && !func_149896_b(var6)) {
               p_149695_1_.func_72921_c(p_149695_2_, p_149695_3_, p_149695_4_, var6 | 4, 2);
               p_149695_1_.func_72889_a((EntityPlayer)null, 1003, p_149695_2_, p_149695_3_, p_149695_4_, 0);
            } else if(!var7 && func_149896_b(var6)) {
               p_149695_1_.func_72921_c(p_149695_2_, p_149695_3_, p_149695_4_, var6 & -5, 2);
               p_149695_1_.func_72889_a((EntityPlayer)null, 1003, p_149695_2_, p_149695_3_, p_149695_4_, 0);
            }
         }

      }
   }

   public static boolean func_149896_b(int p_149896_0_) {
      return (p_149896_0_ & 4) != 0;
   }

   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
      return true;
   }

   public void func_149651_a(IIconRegister p_149651_1_) {}
}
