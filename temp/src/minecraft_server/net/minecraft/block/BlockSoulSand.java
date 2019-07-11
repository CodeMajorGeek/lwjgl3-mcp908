package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockSoulSand extends Block {

   private static final String __OBFID = "CL_00000310";


   public BlockSoulSand() {
      super(Material.field_151595_p);
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
      float var5 = 0.125F;
      return AxisAlignedBB.func_72330_a((double)p_149668_2_, (double)p_149668_3_, (double)p_149668_4_, (double)(p_149668_2_ + 1), (double)((float)(p_149668_3_ + 1) - var5), (double)(p_149668_4_ + 1));
   }

   public void func_149670_a(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_) {
      p_149670_5_.field_70159_w *= 0.4D;
      p_149670_5_.field_70179_y *= 0.4D;
   }
}
