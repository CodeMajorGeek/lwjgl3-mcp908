package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockEndPortalFrame extends Block {

   private IIcon field_150023_a;
   private IIcon field_150022_b;
   private static final String __OBFID = "CL_00000237";


   public BlockEndPortalFrame() {
      super(Material.field_151576_e);
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      return p_149691_1_ == 1?this.field_150023_a:(p_149691_1_ == 0?Blocks.field_150377_bs.func_149733_h(p_149691_1_):this.field_149761_L);
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149761_L = p_149651_1_.func_94245_a(this.func_149641_N() + "_side");
      this.field_150023_a = p_149651_1_.func_94245_a(this.func_149641_N() + "_top");
      this.field_150022_b = p_149651_1_.func_94245_a(this.func_149641_N() + "_eye");
   }

   public IIcon func_150021_e() {
      return this.field_150022_b;
   }

   public boolean func_149662_c() {
      return false;
   }

   public int func_149645_b() {
      return 26;
   }

   public void func_149683_g() {
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
   }

   public void func_149743_a(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
      super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
      int var8 = p_149743_1_.func_72805_g(p_149743_2_, p_149743_3_, p_149743_4_);
      if(func_150020_b(var8)) {
         this.func_149676_a(0.3125F, 0.8125F, 0.3125F, 0.6875F, 1.0F, 0.6875F);
         super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
      }

      this.func_149683_g();
   }

   public static boolean func_150020_b(int p_150020_0_) {
      return (p_150020_0_ & 4) != 0;
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return null;
   }

   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
      int var7 = ((MathHelper.func_76128_c((double)(p_149689_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3) + 2) % 4;
      p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, var7, 2);
   }

   public boolean func_149740_M() {
      return true;
   }

   public int func_149736_g(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_) {
      int var6 = p_149736_1_.func_72805_g(p_149736_2_, p_149736_3_, p_149736_4_);
      return func_150020_b(var6)?15:0;
   }
}
