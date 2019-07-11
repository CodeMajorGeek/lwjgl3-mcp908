package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMycelium extends Block {

   private IIcon field_150200_a;
   private IIcon field_150199_b;
   private static final String __OBFID = "CL_00000273";


   protected BlockMycelium() {
      super(Material.field_151577_b);
      this.func_149675_a(true);
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      return p_149691_1_ == 1?this.field_150200_a:(p_149691_1_ == 0?Blocks.field_150346_d.func_149733_h(p_149691_1_):this.field_149761_L);
   }

   public IIcon func_149673_e(IBlockAccess p_149673_1_, int p_149673_2_, int p_149673_3_, int p_149673_4_, int p_149673_5_) {
      if(p_149673_5_ == 1) {
         return this.field_150200_a;
      } else if(p_149673_5_ == 0) {
         return Blocks.field_150346_d.func_149733_h(p_149673_5_);
      } else {
         Material var6 = p_149673_1_.func_147439_a(p_149673_2_, p_149673_3_ + 1, p_149673_4_).func_149688_o();
         return var6 != Material.field_151597_y && var6 != Material.field_151596_z?this.field_149761_L:this.field_150199_b;
      }
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149761_L = p_149651_1_.func_94245_a(this.func_149641_N() + "_side");
      this.field_150200_a = p_149651_1_.func_94245_a(this.func_149641_N() + "_top");
      this.field_150199_b = p_149651_1_.func_94245_a("grass_side_snowed");
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

   public void func_149734_b(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
      super.func_149734_b(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_, p_149734_5_);
      if(p_149734_5_.nextInt(10) == 0) {
         p_149734_1_.func_72869_a("townaura", (double)((float)p_149734_2_ + p_149734_5_.nextFloat()), (double)((float)p_149734_3_ + 1.1F), (double)((float)p_149734_4_ + p_149734_5_.nextFloat()), 0.0D, 0.0D, 0.0D);
      }

   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Blocks.field_150346_d.func_149650_a(0, p_149650_2_, p_149650_3_);
   }
}
