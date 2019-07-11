package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGeneratorBonusChest extends WorldGenerator {

   private final WeightedRandomChestContent[] field_76546_a;
   private final int field_76545_b;
   private static final String __OBFID = "CL_00000403";


   public WorldGeneratorBonusChest(WeightedRandomChestContent[] p_i2010_1_, int p_i2010_2_) {
      this.field_76546_a = p_i2010_1_;
      this.field_76545_b = p_i2010_2_;
   }

   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      Block var6;
      while(((var6 = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_, p_76484_5_)).func_149688_o() == Material.field_151579_a || var6.func_149688_o() == Material.field_151584_j) && p_76484_4_ > 1) {
         --p_76484_4_;
      }

      if(p_76484_4_ < 1) {
         return false;
      } else {
         ++p_76484_4_;

         for(int var7 = 0; var7 < 4; ++var7) {
            int var8 = p_76484_3_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
            int var9 = p_76484_4_ + p_76484_2_.nextInt(3) - p_76484_2_.nextInt(3);
            int var10 = p_76484_5_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
            if(p_76484_1_.func_147437_c(var8, var9, var10) && World.func_147466_a(p_76484_1_, var8, var9 - 1, var10)) {
               p_76484_1_.func_147465_d(var8, var9, var10, Blocks.field_150486_ae, 0, 2);
               TileEntityChest var11 = (TileEntityChest)p_76484_1_.func_147438_o(var8, var9, var10);
               if(var11 != null && var11 != null) {
                  WeightedRandomChestContent.func_76293_a(p_76484_2_, this.field_76546_a, var11, this.field_76545_b);
               }

               if(p_76484_1_.func_147437_c(var8 - 1, var9, var10) && World.func_147466_a(p_76484_1_, var8 - 1, var9 - 1, var10)) {
                  p_76484_1_.func_147465_d(var8 - 1, var9, var10, Blocks.field_150478_aa, 0, 2);
               }

               if(p_76484_1_.func_147437_c(var8 + 1, var9, var10) && World.func_147466_a(p_76484_1_, var8 - 1, var9 - 1, var10)) {
                  p_76484_1_.func_147465_d(var8 + 1, var9, var10, Blocks.field_150478_aa, 0, 2);
               }

               if(p_76484_1_.func_147437_c(var8, var9, var10 - 1) && World.func_147466_a(p_76484_1_, var8 - 1, var9 - 1, var10)) {
                  p_76484_1_.func_147465_d(var8, var9, var10 - 1, Blocks.field_150478_aa, 0, 2);
               }

               if(p_76484_1_.func_147437_c(var8, var9, var10 + 1) && World.func_147466_a(p_76484_1_, var8 - 1, var9 - 1, var10)) {
                  p_76484_1_.func_147465_d(var8, var9, var10 + 1, Blocks.field_150478_aa, 0, 2);
               }

               return true;
            }
         }

         return false;
      }
   }
}
