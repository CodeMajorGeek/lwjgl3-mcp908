package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEndPortal;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockEndPortal extends BlockContainer {

   public static boolean field_149948_a;
   private static final String __OBFID = "CL_00000236";


   protected BlockEndPortal(Material p_i45404_1_) {
      super(p_i45404_1_);
      this.func_149715_a(1.0F);
   }

   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
      return new TileEntityEndPortal();
   }

   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
      float var5 = 0.0625F;
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, var5, 1.0F);
   }

   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
      return p_149646_5_ != 0?false:super.func_149646_a(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
   }

   public void func_149743_a(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {}

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public int func_149745_a(Random p_149745_1_) {
      return 0;
   }

   public void func_149670_a(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_) {
      if(p_149670_5_.field_70154_o == null && p_149670_5_.field_70153_n == null && !p_149670_1_.field_72995_K) {
         p_149670_5_.func_71027_c(1);
      }

   }

   public void func_149734_b(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
      double var6 = (double)((float)p_149734_2_ + p_149734_5_.nextFloat());
      double var8 = (double)((float)p_149734_3_ + 0.8F);
      double var10 = (double)((float)p_149734_4_ + p_149734_5_.nextFloat());
      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = 0.0D;
      p_149734_1_.func_72869_a("smoke", var6, var8, var10, var12, var14, var16);
   }

   public int func_149645_b() {
      return -1;
   }

   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
      if(!field_149948_a) {
         if(p_149726_1_.field_73011_w.field_76574_g != 0) {
            p_149726_1_.func_147468_f(p_149726_2_, p_149726_3_, p_149726_4_);
         }

      }
   }

   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
      return Item.func_150899_d(0);
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149761_L = p_149651_1_.func_94245_a("portal");
   }

   public MapColor func_149728_f(int p_149728_1_) {
      return MapColor.field_151654_J;
   }
}
