package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public abstract class WorldGenAbstractTree extends WorldGenerator {

   private static final String __OBFID = "CL_00000399";


   public WorldGenAbstractTree(boolean p_i45448_1_) {
      super(p_i45448_1_);
   }

   protected boolean func_150523_a(Block p_150523_1_) {
      return p_150523_1_.func_149688_o() == Material.field_151579_a || p_150523_1_.func_149688_o() == Material.field_151584_j || p_150523_1_ == Blocks.field_150349_c || p_150523_1_ == Blocks.field_150346_d || p_150523_1_ == Blocks.field_150364_r || p_150523_1_ == Blocks.field_150363_s || p_150523_1_ == Blocks.field_150345_g || p_150523_1_ == Blocks.field_150395_bd;
   }

   public void func_150524_b(World p_150524_1_, Random p_150524_2_, int p_150524_3_, int p_150524_4_, int p_150524_5_) {}
}
