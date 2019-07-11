package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockEnchantmentTable extends BlockContainer {

   private IIcon field_149950_a;
   private IIcon field_149949_b;
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

   public void func_149734_b(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
      super.func_149734_b(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_, p_149734_5_);

      for(int var6 = p_149734_2_ - 2; var6 <= p_149734_2_ + 2; ++var6) {
         for(int var7 = p_149734_4_ - 2; var7 <= p_149734_4_ + 2; ++var7) {
            if(var6 > p_149734_2_ - 2 && var6 < p_149734_2_ + 2 && var7 == p_149734_4_ - 1) {
               var7 = p_149734_4_ + 2;
            }

            if(p_149734_5_.nextInt(16) == 0) {
               for(int var8 = p_149734_3_; var8 <= p_149734_3_ + 1; ++var8) {
                  if(p_149734_1_.func_147439_a(var6, var8, var7) == Blocks.field_150342_X) {
                     if(!p_149734_1_.func_147437_c((var6 - p_149734_2_) / 2 + p_149734_2_, var8, (var7 - p_149734_4_) / 2 + p_149734_4_)) {
                        break;
                     }

                     p_149734_1_.func_72869_a("enchantmenttable", (double)p_149734_2_ + 0.5D, (double)p_149734_3_ + 2.0D, (double)p_149734_4_ + 0.5D, (double)((float)(var6 - p_149734_2_) + p_149734_5_.nextFloat()) - 0.5D, (double)((float)(var8 - p_149734_3_) - p_149734_5_.nextFloat() - 1.0F), (double)((float)(var7 - p_149734_4_) + p_149734_5_.nextFloat()) - 0.5D);
                  }
               }
            }
         }
      }

   }

   public boolean func_149662_c() {
      return false;
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      return p_149691_1_ == 0?this.field_149949_b:(p_149691_1_ == 1?this.field_149950_a:this.field_149761_L);
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

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149761_L = p_149651_1_.func_94245_a(this.func_149641_N() + "_" + "side");
      this.field_149950_a = p_149651_1_.func_94245_a(this.func_149641_N() + "_" + "top");
      this.field_149949_b = p_149651_1_.func_94245_a(this.func_149641_N() + "_" + "bottom");
   }
}
