package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;

public class BlockMobSpawner extends BlockContainer {

   private static final String __OBFID = "CL_00000269";


   protected BlockMobSpawner() {
      super(Material.field_151576_e);
   }

   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
      return new TileEntityMobSpawner();
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return null;
   }

   public int func_149745_a(Random p_149745_1_) {
      return 0;
   }

   public void func_149690_a(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
      super.func_149690_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_, p_149690_7_);
      int var8 = 15 + p_149690_1_.field_73012_v.nextInt(15) + p_149690_1_.field_73012_v.nextInt(15);
      this.func_149657_c(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, var8);
   }

   public boolean func_149662_c() {
      return false;
   }

   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
      return Item.func_150899_d(0);
   }
}
