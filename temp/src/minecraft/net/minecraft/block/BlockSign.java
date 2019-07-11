package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSign extends BlockContainer {

   private Class field_149968_a;
   private boolean field_149967_b;
   private static final String __OBFID = "CL_00000306";


   protected BlockSign(Class p_i45426_1_, boolean p_i45426_2_) {
      super(Material.field_151575_d);
      this.field_149967_b = p_i45426_2_;
      this.field_149968_a = p_i45426_1_;
      float var3 = 0.25F;
      float var4 = 1.0F;
      this.func_149676_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var4, 0.5F + var3);
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      return Blocks.field_150344_f.func_149733_h(p_149691_1_);
   }

   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
      return null;
   }

   public AxisAlignedBB func_149633_g(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_) {
      this.func_149719_a(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
      return super.func_149633_g(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
   }

   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
      if(!this.field_149967_b) {
         int var5 = p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_);
         float var6 = 0.28125F;
         float var7 = 0.78125F;
         float var8 = 0.0F;
         float var9 = 1.0F;
         float var10 = 0.125F;
         this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         if(var5 == 2) {
            this.func_149676_a(var8, var6, 1.0F - var10, var9, var7, 1.0F);
         }

         if(var5 == 3) {
            this.func_149676_a(var8, var6, 0.0F, var9, var7, var10);
         }

         if(var5 == 4) {
            this.func_149676_a(1.0F - var10, var6, var8, 1.0F, var7, var9);
         }

         if(var5 == 5) {
            this.func_149676_a(0.0F, var6, var8, var10, var7, var9);
         }

      }
   }

   public int func_149645_b() {
      return -1;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149655_b(IBlockAccess p_149655_1_, int p_149655_2_, int p_149655_3_, int p_149655_4_) {
      return true;
   }

   public boolean func_149662_c() {
      return false;
   }

   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
      try {
         return (TileEntity)this.field_149968_a.newInstance();
      } catch (Exception var4) {
         throw new RuntimeException(var4);
      }
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Items.field_151155_ap;
   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      boolean var6 = false;
      if(this.field_149967_b) {
         if(!p_149695_1_.func_147439_a(p_149695_2_, p_149695_3_ - 1, p_149695_4_).func_149688_o().func_76220_a()) {
            var6 = true;
         }
      } else {
         int var7 = p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_);
         var6 = true;
         if(var7 == 2 && p_149695_1_.func_147439_a(p_149695_2_, p_149695_3_, p_149695_4_ + 1).func_149688_o().func_76220_a()) {
            var6 = false;
         }

         if(var7 == 3 && p_149695_1_.func_147439_a(p_149695_2_, p_149695_3_, p_149695_4_ - 1).func_149688_o().func_76220_a()) {
            var6 = false;
         }

         if(var7 == 4 && p_149695_1_.func_147439_a(p_149695_2_ + 1, p_149695_3_, p_149695_4_).func_149688_o().func_76220_a()) {
            var6 = false;
         }

         if(var7 == 5 && p_149695_1_.func_147439_a(p_149695_2_ - 1, p_149695_3_, p_149695_4_).func_149688_o().func_76220_a()) {
            var6 = false;
         }
      }

      if(var6) {
         this.func_149697_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_), 0);
         p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
      }

      super.func_149695_a(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_5_);
   }

   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
      return Items.field_151155_ap;
   }

   public void func_149651_a(IIconRegister p_149651_1_) {}
}
