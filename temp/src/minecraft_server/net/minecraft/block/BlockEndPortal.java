package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
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

   public MapColor func_149728_f(int p_149728_1_) {
      return MapColor.field_151654_J;
   }
}
