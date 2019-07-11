package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockMycelium extends Block {

   private static final String __OBFID = "CL_00000273";


   protected BlockMycelium() {
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
                  p_149674_1_.func_147449_b(var7, var8, var9, this);
               }
            }
         }

      }
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Blocks.field_150346_d.func_149650_a(0, p_149650_2_, p_149650_3_);
   }
}
