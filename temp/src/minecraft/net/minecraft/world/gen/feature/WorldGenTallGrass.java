package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenTallGrass extends WorldGenerator {

   private Block field_150522_a;
   private int field_76534_b;
   private static final String __OBFID = "CL_00000437";


   public WorldGenTallGrass(Block p_i45466_1_, int p_i45466_2_) {
      this.field_150522_a = p_i45466_1_;
      this.field_76534_b = p_i45466_2_;
   }

   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      Block var6;
      while(((var6 = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_, p_76484_5_)).func_149688_o() == Material.field_151579_a || var6.func_149688_o() == Material.field_151584_j) && p_76484_4_ > 0) {
         --p_76484_4_;
      }

      for(int var7 = 0; var7 < 128; ++var7) {
         int var8 = p_76484_3_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
         int var9 = p_76484_4_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
         int var10 = p_76484_5_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
         if(p_76484_1_.func_147437_c(var8, var9, var10) && this.field_150522_a.func_149718_j(p_76484_1_, var8, var9, var10)) {
            p_76484_1_.func_147465_d(var8, var9, var10, this.field_150522_a, this.field_76534_b, 2);
         }
      }

      return true;
   }
}
