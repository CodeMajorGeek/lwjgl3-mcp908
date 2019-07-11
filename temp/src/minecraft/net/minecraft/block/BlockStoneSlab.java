package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockStoneSlab extends BlockSlab {

   public static final String[] field_150006_b = new String[]{"stone", "sand", "wood", "cobble", "brick", "smoothStoneBrick", "netherBrick", "quartz"};
   private IIcon field_150007_M;
   private static final String __OBFID = "CL_00000320";


   public BlockStoneSlab(boolean p_i45431_1_) {
      super(p_i45431_1_, Material.field_151576_e);
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      int var3 = p_149691_2_ & 7;
      if(this.field_150004_a && (p_149691_2_ & 8) != 0) {
         p_149691_1_ = 1;
      }

      return var3 == 0?(p_149691_1_ != 1 && p_149691_1_ != 0?this.field_150007_M:this.field_149761_L):(var3 == 1?Blocks.field_150322_A.func_149733_h(p_149691_1_):(var3 == 2?Blocks.field_150344_f.func_149733_h(p_149691_1_):(var3 == 3?Blocks.field_150347_e.func_149733_h(p_149691_1_):(var3 == 4?Blocks.field_150336_V.func_149733_h(p_149691_1_):(var3 == 5?Blocks.field_150417_aV.func_149691_a(p_149691_1_, 0):(var3 == 6?Blocks.field_150385_bj.func_149733_h(1):(var3 == 7?Blocks.field_150371_ca.func_149733_h(p_149691_1_):this.field_149761_L)))))));
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149761_L = p_149651_1_.func_94245_a("stone_slab_top");
      this.field_150007_M = p_149651_1_.func_94245_a("stone_slab_side");
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Item.func_150898_a(Blocks.field_150333_U);
   }

   protected ItemStack func_149644_j(int p_149644_1_) {
      return new ItemStack(Item.func_150898_a(Blocks.field_150333_U), 2, p_149644_1_ & 7);
   }

   public String func_150002_b(int p_150002_1_) {
      if(p_150002_1_ < 0 || p_150002_1_ >= field_150006_b.length) {
         p_150002_1_ = 0;
      }

      return super.func_149739_a() + "." + field_150006_b[p_150002_1_];
   }

   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
      if(p_149666_1_ != Item.func_150898_a(Blocks.field_150334_T)) {
         for(int var4 = 0; var4 <= 7; ++var4) {
            if(var4 != 2) {
               p_149666_3_.add(new ItemStack(p_149666_1_, 1, var4));
            }
         }

      }
   }

}
