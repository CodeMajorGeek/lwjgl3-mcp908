package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDungeons extends WorldGenerator {

   private static final WeightedRandomChestContent[] field_111189_a = new WeightedRandomChestContent[]{new WeightedRandomChestContent(Items.field_151141_av, 0, 1, 1, 10), new WeightedRandomChestContent(Items.field_151042_j, 0, 1, 4, 10), new WeightedRandomChestContent(Items.field_151025_P, 0, 1, 1, 10), new WeightedRandomChestContent(Items.field_151015_O, 0, 1, 4, 10), new WeightedRandomChestContent(Items.field_151016_H, 0, 1, 4, 10), new WeightedRandomChestContent(Items.field_151007_F, 0, 1, 4, 10), new WeightedRandomChestContent(Items.field_151133_ar, 0, 1, 1, 10), new WeightedRandomChestContent(Items.field_151153_ao, 0, 1, 1, 1), new WeightedRandomChestContent(Items.field_151137_ax, 0, 1, 4, 10), new WeightedRandomChestContent(Items.field_151096_cd, 0, 1, 1, 10), new WeightedRandomChestContent(Items.field_151093_ce, 0, 1, 1, 10), new WeightedRandomChestContent(Items.field_151057_cb, 0, 1, 1, 10), new WeightedRandomChestContent(Items.field_151136_bY, 0, 1, 1, 2), new WeightedRandomChestContent(Items.field_151138_bX, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151125_bZ, 0, 1, 1, 1)};
   private static final String __OBFID = "CL_00000425";


   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      byte var6 = 3;
      int var7 = p_76484_2_.nextInt(2) + 2;
      int var8 = p_76484_2_.nextInt(2) + 2;
      int var9 = 0;

      int var10;
      int var11;
      int var12;
      for(var10 = p_76484_3_ - var7 - 1; var10 <= p_76484_3_ + var7 + 1; ++var10) {
         for(var11 = p_76484_4_ - 1; var11 <= p_76484_4_ + var6 + 1; ++var11) {
            for(var12 = p_76484_5_ - var8 - 1; var12 <= p_76484_5_ + var8 + 1; ++var12) {
               Material var13 = p_76484_1_.func_147439_a(var10, var11, var12).func_149688_o();
               if(var11 == p_76484_4_ - 1 && !var13.func_76220_a()) {
                  return false;
               }

               if(var11 == p_76484_4_ + var6 + 1 && !var13.func_76220_a()) {
                  return false;
               }

               if((var10 == p_76484_3_ - var7 - 1 || var10 == p_76484_3_ + var7 + 1 || var12 == p_76484_5_ - var8 - 1 || var12 == p_76484_5_ + var8 + 1) && var11 == p_76484_4_ && p_76484_1_.func_147437_c(var10, var11, var12) && p_76484_1_.func_147437_c(var10, var11 + 1, var12)) {
                  ++var9;
               }
            }
         }
      }

      if(var9 >= 1 && var9 <= 5) {
         for(var10 = p_76484_3_ - var7 - 1; var10 <= p_76484_3_ + var7 + 1; ++var10) {
            for(var11 = p_76484_4_ + var6; var11 >= p_76484_4_ - 1; --var11) {
               for(var12 = p_76484_5_ - var8 - 1; var12 <= p_76484_5_ + var8 + 1; ++var12) {
                  if(var10 != p_76484_3_ - var7 - 1 && var11 != p_76484_4_ - 1 && var12 != p_76484_5_ - var8 - 1 && var10 != p_76484_3_ + var7 + 1 && var11 != p_76484_4_ + var6 + 1 && var12 != p_76484_5_ + var8 + 1) {
                     p_76484_1_.func_147468_f(var10, var11, var12);
                  } else if(var11 >= 0 && !p_76484_1_.func_147439_a(var10, var11 - 1, var12).func_149688_o().func_76220_a()) {
                     p_76484_1_.func_147468_f(var10, var11, var12);
                  } else if(p_76484_1_.func_147439_a(var10, var11, var12).func_149688_o().func_76220_a()) {
                     if(var11 == p_76484_4_ - 1 && p_76484_2_.nextInt(4) != 0) {
                        p_76484_1_.func_147465_d(var10, var11, var12, Blocks.field_150341_Y, 0, 2);
                     } else {
                        p_76484_1_.func_147465_d(var10, var11, var12, Blocks.field_150347_e, 0, 2);
                     }
                  }
               }
            }
         }

         var10 = 0;

         while(var10 < 2) {
            var11 = 0;

            while(true) {
               if(var11 < 3) {
                  label197: {
                     var12 = p_76484_3_ + p_76484_2_.nextInt(var7 * 2 + 1) - var7;
                     int var14 = p_76484_5_ + p_76484_2_.nextInt(var8 * 2 + 1) - var8;
                     if(p_76484_1_.func_147437_c(var12, p_76484_4_, var14)) {
                        int var15 = 0;
                        if(p_76484_1_.func_147439_a(var12 - 1, p_76484_4_, var14).func_149688_o().func_76220_a()) {
                           ++var15;
                        }

                        if(p_76484_1_.func_147439_a(var12 + 1, p_76484_4_, var14).func_149688_o().func_76220_a()) {
                           ++var15;
                        }

                        if(p_76484_1_.func_147439_a(var12, p_76484_4_, var14 - 1).func_149688_o().func_76220_a()) {
                           ++var15;
                        }

                        if(p_76484_1_.func_147439_a(var12, p_76484_4_, var14 + 1).func_149688_o().func_76220_a()) {
                           ++var15;
                        }

                        if(var15 == 1) {
                           p_76484_1_.func_147465_d(var12, p_76484_4_, var14, Blocks.field_150486_ae, 0, 2);
                           WeightedRandomChestContent[] var16 = WeightedRandomChestContent.func_92080_a(field_111189_a, new WeightedRandomChestContent[]{Items.field_151134_bR.func_92114_b(p_76484_2_)});
                           TileEntityChest var17 = (TileEntityChest)p_76484_1_.func_147438_o(var12, p_76484_4_, var14);
                           if(var17 != null) {
                              WeightedRandomChestContent.func_76293_a(p_76484_2_, var16, var17, 8);
                           }
                           break label197;
                        }
                     }

                     ++var11;
                     continue;
                  }
               }

               ++var10;
               break;
            }
         }

         p_76484_1_.func_147465_d(p_76484_3_, p_76484_4_, p_76484_5_, Blocks.field_150474_ac, 0, 2);
         TileEntityMobSpawner var18 = (TileEntityMobSpawner)p_76484_1_.func_147438_o(p_76484_3_, p_76484_4_, p_76484_5_);
         if(var18 != null) {
            var18.func_145881_a().func_98272_a(this.func_76543_b(p_76484_2_));
         } else {
            System.err.println("Failed to fetch mob spawner entity at (" + p_76484_3_ + ", " + p_76484_4_ + ", " + p_76484_5_ + ")");
         }

         return true;
      } else {
         return false;
      }
   }

   private String func_76543_b(Random p_76543_1_) {
      int var2 = p_76543_1_.nextInt(4);
      return var2 == 0?"Skeleton":(var2 == 1?"Zombie":(var2 == 2?"Zombie":(var2 == 3?"Spider":"")));
   }

}
