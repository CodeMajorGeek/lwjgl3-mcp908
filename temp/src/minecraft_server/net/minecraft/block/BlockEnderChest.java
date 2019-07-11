package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockEnderChest extends BlockContainer {

   private static final String __OBFID = "CL_00000238";


   protected BlockEnderChest() {
      super(Material.field_151576_e);
      this.func_149647_a(CreativeTabs.field_78031_c);
      this.func_149676_a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public int func_149645_b() {
      return 22;
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Item.func_150898_a(Blocks.field_150343_Z);
   }

   public int func_149745_a(Random p_149745_1_) {
      return 8;
   }

   protected boolean func_149700_E() {
      return true;
   }

   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
      byte var7 = 0;
      int var8 = MathHelper.func_76128_c((double)(p_149689_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3;
      if(var8 == 0) {
         var7 = 2;
      }

      if(var8 == 1) {
         var7 = 5;
      }

      if(var8 == 2) {
         var7 = 3;
      }

      if(var8 == 3) {
         var7 = 4;
      }

      p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, var7, 2);
   }

   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
      InventoryEnderChest var10 = p_149727_5_.func_71005_bN();
      TileEntityEnderChest var11 = (TileEntityEnderChest)p_149727_1_.func_147438_o(p_149727_2_, p_149727_3_, p_149727_4_);
      if(var10 != null && var11 != null) {
         if(p_149727_1_.func_147439_a(p_149727_2_, p_149727_3_ + 1, p_149727_4_).func_149721_r()) {
            return true;
         } else if(p_149727_1_.field_72995_K) {
            return true;
         } else {
            var10.func_146031_a(var11);
            p_149727_5_.func_71007_a(var10);
            return true;
         }
      } else {
         return true;
      }
   }

   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
      return new TileEntityEnderChest();
   }
}
