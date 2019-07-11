package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockBrewingStand extends BlockContainer {

   private Random field_149961_a = new Random();
   private IIcon field_149960_b;
   private static final String __OBFID = "CL_00000207";


   public BlockBrewingStand() {
      super(Material.field_151573_f);
   }

   public boolean func_149662_c() {
      return false;
   }

   public int func_149645_b() {
      return 25;
   }

   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
      return new TileEntityBrewingStand();
   }

   public boolean func_149686_d() {
      return false;
   }

   public void func_149743_a(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {
      this.func_149676_a(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.875F, 0.5625F);
      super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
      this.func_149683_g();
      super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
   }

   public void func_149683_g() {
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
   }

   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
      if(p_149727_1_.field_72995_K) {
         return true;
      } else {
         TileEntityBrewingStand var10 = (TileEntityBrewingStand)p_149727_1_.func_147438_o(p_149727_2_, p_149727_3_, p_149727_4_);
         if(var10 != null) {
            p_149727_5_.func_146098_a(var10);
         }

         return true;
      }
   }

   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
      if(p_149689_6_.func_82837_s()) {
         ((TileEntityBrewingStand)p_149689_1_.func_147438_o(p_149689_2_, p_149689_3_, p_149689_4_)).func_145937_a(p_149689_6_.func_82833_r());
      }

   }

   public void func_149734_b(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
      double var6 = (double)((float)p_149734_2_ + 0.4F + p_149734_5_.nextFloat() * 0.2F);
      double var8 = (double)((float)p_149734_3_ + 0.7F + p_149734_5_.nextFloat() * 0.3F);
      double var10 = (double)((float)p_149734_4_ + 0.4F + p_149734_5_.nextFloat() * 0.2F);
      p_149734_1_.func_72869_a("smoke", var6, var8, var10, 0.0D, 0.0D, 0.0D);
   }

   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
      TileEntity var7 = p_149749_1_.func_147438_o(p_149749_2_, p_149749_3_, p_149749_4_);
      if(var7 instanceof TileEntityBrewingStand) {
         TileEntityBrewingStand var8 = (TileEntityBrewingStand)var7;

         for(int var9 = 0; var9 < var8.func_70302_i_(); ++var9) {
            ItemStack var10 = var8.func_70301_a(var9);
            if(var10 != null) {
               float var11 = this.field_149961_a.nextFloat() * 0.8F + 0.1F;
               float var12 = this.field_149961_a.nextFloat() * 0.8F + 0.1F;
               float var13 = this.field_149961_a.nextFloat() * 0.8F + 0.1F;

               while(var10.field_77994_a > 0) {
                  int var14 = this.field_149961_a.nextInt(21) + 10;
                  if(var14 > var10.field_77994_a) {
                     var14 = var10.field_77994_a;
                  }

                  var10.field_77994_a -= var14;
                  EntityItem var15 = new EntityItem(p_149749_1_, (double)((float)p_149749_2_ + var11), (double)((float)p_149749_3_ + var12), (double)((float)p_149749_4_ + var13), new ItemStack(var10.func_77973_b(), var14, var10.func_77960_j()));
                  float var16 = 0.05F;
                  var15.field_70159_w = (double)((float)this.field_149961_a.nextGaussian() * var16);
                  var15.field_70181_x = (double)((float)this.field_149961_a.nextGaussian() * var16 + 0.2F);
                  var15.field_70179_y = (double)((float)this.field_149961_a.nextGaussian() * var16);
                  p_149749_1_.func_72838_d(var15);
               }
            }
         }
      }

      super.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Items.field_151067_bt;
   }

   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
      return Items.field_151067_bt;
   }

   public boolean func_149740_M() {
      return true;
   }

   public int func_149736_g(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_) {
      return Container.func_94526_b((IInventory)p_149736_1_.func_147438_o(p_149736_2_, p_149736_3_, p_149736_4_));
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      super.func_149651_a(p_149651_1_);
      this.field_149960_b = p_149651_1_.func_94245_a(this.func_149641_N() + "_base");
   }

   public IIcon func_149959_e() {
      return this.field_149960_b;
   }
}
