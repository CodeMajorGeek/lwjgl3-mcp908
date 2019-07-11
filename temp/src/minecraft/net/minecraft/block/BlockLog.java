package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public abstract class BlockLog extends BlockRotatedPillar {

   protected IIcon[] field_150167_a;
   protected IIcon[] field_150166_b;
   private static final String __OBFID = "CL_00000266";


   public BlockLog() {
      super(Material.field_151575_d);
      this.func_149647_a(CreativeTabs.field_78030_b);
      this.func_149711_c(2.0F);
      this.func_149672_a(field_149766_f);
   }

   public static int func_150165_c(int p_150165_0_) {
      return p_150165_0_ & 3;
   }

   public int func_149745_a(Random p_149745_1_) {
      return 1;
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Item.func_150898_a(this);
   }

   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
      byte var7 = 4;
      int var8 = var7 + 1;
      if(p_149749_1_.func_72904_c(p_149749_2_ - var8, p_149749_3_ - var8, p_149749_4_ - var8, p_149749_2_ + var8, p_149749_3_ + var8, p_149749_4_ + var8)) {
         for(int var9 = -var7; var9 <= var7; ++var9) {
            for(int var10 = -var7; var10 <= var7; ++var10) {
               for(int var11 = -var7; var11 <= var7; ++var11) {
                  if(p_149749_1_.func_147439_a(p_149749_2_ + var9, p_149749_3_ + var10, p_149749_4_ + var11).func_149688_o() == Material.field_151584_j) {
                     int var12 = p_149749_1_.func_72805_g(p_149749_2_ + var9, p_149749_3_ + var10, p_149749_4_ + var11);
                     if((var12 & 8) == 0) {
                        p_149749_1_.func_72921_c(p_149749_2_ + var9, p_149749_3_ + var10, p_149749_4_ + var11, var12 | 8, 4);
                     }
                  }
               }
            }
         }
      }

   }

   protected IIcon func_150163_b(int p_150163_1_) {
      return this.field_150167_a[p_150163_1_ % this.field_150167_a.length];
   }

   protected IIcon func_150161_d(int p_150161_1_) {
      return this.field_150166_b[p_150161_1_ % this.field_150166_b.length];
   }
}
