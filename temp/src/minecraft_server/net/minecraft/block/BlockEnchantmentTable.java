package net.minecraft.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.minecraft.world.World;

public class BlockEnchantmentTable extends BlockContainer {

   private static final String __OBFID = "CL_00000235";


   protected BlockEnchantmentTable() {
      super(Material.field_151576_e);
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
      this.func_149713_g(0);
      this.func_149647_a(CreativeTabs.field_78031_c);
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149662_c() {
      return false;
   }

   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
      return new TileEntityEnchantmentTable();
   }

   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
      if(p_149727_1_.field_72995_K) {
         return true;
      } else {
         TileEntityEnchantmentTable var10 = (TileEntityEnchantmentTable)p_149727_1_.func_147438_o(p_149727_2_, p_149727_3_, p_149727_4_);
         p_149727_5_.func_71002_c(p_149727_2_, p_149727_3_, p_149727_4_, var10.func_145921_b()?var10.func_145919_a():null);
         return true;
      }
   }

   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
      super.func_149689_a(p_149689_1_, p_149689_2_, p_149689_3_, p_149689_4_, p_149689_5_, p_149689_6_);
      if(p_149689_6_.func_82837_s()) {
         ((TileEntityEnchantmentTable)p_149689_1_.func_147438_o(p_149689_2_, p_149689_3_, p_149689_4_)).func_145920_a(p_149689_6_.func_82833_r());
      }

   }
}
