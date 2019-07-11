package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDoublePlant extends WorldGenerator {

   private int field_150549_a;
   private static final String __OBFID = "CL_00000408";


   public void func_150548_a(int p_150548_1_) {
      this.field_150549_a = p_150548_1_;
   }

   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      boolean var6 = false;

      for(int var7 = 0; var7 < 64; ++var7) {
         int var8 = p_76484_3_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
         int var9 = p_76484_4_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
         int var10 = p_76484_5_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
         if(p_76484_1_.func_147437_c(var8, var9, var10) && (!p_76484_1_.field_73011_w.field_76576_e || var9 < 254) && Blocks.field_150398_cm.func_149742_c(p_76484_1_, var8, var9, var10)) {
            Blocks.field_150398_cm.func_149889_c(p_76484_1_, var8, var9, var10, this.field_150549_a, 2);
            var6 = true;
         }
      }

      return var6;
   }
}
