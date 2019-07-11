package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BlockGrass extends Block implements IGrowable {

   private static final Logger field_149992_a = LogManager.getLogger();
   private static final String __OBFID = "CL_00000251";


   protected BlockGrass() {
      super(Material.field_151577_b);
      this.func_149675_a(true);
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      if(!p_149674_1_.field_72995_K) {
         if(p_149674_1_.func_72957_l(p_149674_2_, p_149674_3_ + 1, p_149674_4_) < 4 && p_149674_1_.func_147439_a(p_149674_2_, p_149674_3_ + 1, p_149674_4_).func_149717_k() > 2) {
            p_149674_1_.func_147449_b(p_149674_2_, p_149674_3_, p_149674_4_, Blocks.field_150346_d);
         } else if(p_149674_1_.func_72957_l(p_149674_2_, p_149674_3_ + 1, p_149674_4_) >= 9) {
            for(int var6 = 0; var6 < 4; ++var6) {
               int var7 = p_149674_2_ + p_149674_5_.nextInt(3) - 1;
               int var8 = p_149674_3_ + p_149674_5_.nextInt(5) - 3;
               int var9 = p_149674_4_ + p_149674_5_.nextInt(3) - 1;
               Block var10 = p_149674_1_.func_147439_a(var7, var8 + 1, var9);
               if(p_149674_1_.func_147439_a(var7, var8, var9) == Blocks.field_150346_d && p_149674_1_.func_72805_g(var7, var8, var9) == 0 && p_149674_1_.func_72957_l(var7, var8 + 1, var9) >= 4 && var10.func_149717_k() <= 2) {
                  p_149674_1_.func_147449_b(var7, var8, var9, Blocks.field_150349_c);
               }
            }
         }

      }
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Blocks.field_150346_d.func_149650_a(0, p_149650_2_, p_149650_3_);
   }

   public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
      return true;
   }

   public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
      return true;
   }

   public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
      int var6 = 0;

      while(var6 < 128) {
         int var7 = p_149853_3_;
         int var8 = p_149853_4_ + 1;
         int var9 = p_149853_5_;
         int var10 = 0;

         while(true) {
            if(var10 < var6 / 16) {
               var7 += p_149853_2_.nextInt(3) - 1;
               var8 += (p_149853_2_.nextInt(3) - 1) * p_149853_2_.nextInt(3) / 2;
               var9 += p_149853_2_.nextInt(3) - 1;
               if(p_149853_1_.func_147439_a(var7, var8 - 1, var9) == Blocks.field_150349_c && !p_149853_1_.func_147439_a(var7, var8, var9).func_149721_r()) {
                  ++var10;
                  continue;
               }
            } else if(p_149853_1_.func_147439_a(var7, var8, var9).field_149764_J == Material.field_151579_a) {
               if(p_149853_2_.nextInt(8) != 0) {
                  if(Blocks.field_150329_H.func_149718_j(p_149853_1_, var7, var8, var9)) {
                     p_149853_1_.func_147465_d(var7, var8, var9, Blocks.field_150329_H, 1, 3);
                  }
               } else {
                  String var13 = p_149853_1_.func_72807_a(var7, var9).func_150572_a(p_149853_2_, var7, var8, var9);
                  field_149992_a.debug("Flower in " + p_149853_1_.func_72807_a(var7, var9).field_76791_y + ": " + var13);
                  BlockFlower var11 = BlockFlower.func_149857_e(var13);
                  if(var11 != null && var11.func_149718_j(p_149853_1_, var7, var8, var9)) {
                     int var12 = BlockFlower.func_149856_f(var13);
                     p_149853_1_.func_147465_d(var7, var8, var9, var11, var12, 3);
                  }
               }
            }

            ++var6;
            break;
         }
      }

   }

}
