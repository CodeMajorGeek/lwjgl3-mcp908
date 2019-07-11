package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityDaylightDetector;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDaylightDetector extends BlockContainer {

   private IIcon[] field_149958_a = new IIcon[2];
   private static final String __OBFID = "CL_00000223";


   public BlockDaylightDetector() {
      super(Material.field_151575_d);
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F);
      this.func_149647_a(CreativeTabs.field_78028_d);
   }

   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F);
   }

   public int func_149709_b(IBlockAccess p_149709_1_, int p_149709_2_, int p_149709_3_, int p_149709_4_, int p_149709_5_) {
      return p_149709_1_.func_72805_g(p_149709_2_, p_149709_3_, p_149709_4_);
   }

   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {}

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {}

   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {}

   public void func_149957_e(World p_149957_1_, int p_149957_2_, int p_149957_3_, int p_149957_4_) {
      if(!p_149957_1_.field_73011_w.field_76576_e) {
         int var5 = p_149957_1_.func_72805_g(p_149957_2_, p_149957_3_, p_149957_4_);
         int var6 = p_149957_1_.func_72972_b(EnumSkyBlock.Sky, p_149957_2_, p_149957_3_, p_149957_4_) - p_149957_1_.field_73008_k;
         float var7 = p_149957_1_.func_72929_e(1.0F);
         if(var7 < 3.1415927F) {
            var7 += (0.0F - var7) * 0.2F;
         } else {
            var7 += (6.2831855F - var7) * 0.2F;
         }

         var6 = Math.round((float)var6 * MathHelper.func_76134_b(var7));
         if(var6 < 0) {
            var6 = 0;
         }

         if(var6 > 15) {
            var6 = 15;
         }

         if(var5 != var6) {
            p_149957_1_.func_72921_c(p_149957_2_, p_149957_3_, p_149957_4_, var6, 3);
         }

      }
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149744_f() {
      return true;
   }

   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
      return new TileEntityDaylightDetector();
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      return p_149691_1_ == 1?this.field_149958_a[0]:this.field_149958_a[1];
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149958_a[0] = p_149651_1_.func_94245_a(this.func_149641_N() + "_top");
      this.field_149958_a[1] = p_149651_1_.func_94245_a(this.func_149641_N() + "_side");
   }
}
