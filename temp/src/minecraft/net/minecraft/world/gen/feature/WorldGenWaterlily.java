package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenWaterlily extends WorldGenerator {

   private static final String __OBFID = "CL_00000189";


   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      for(int var6 = 0; var6 < 10; ++var6) {
         int var7 = p_76484_3_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
         int var8 = p_76484_4_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
         int var9 = p_76484_5_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
         if(p_76484_1_.func_147437_c(var7, var8, var9) && Blocks.field_150392_bi.func_149742_c(p_76484_1_, var7, var8, var9)) {
            p_76484_1_.func_147465_d(var7, var8, var9, Blocks.field_150392_bi, 0, 2);
         }
      }

      return true;
   }
}
