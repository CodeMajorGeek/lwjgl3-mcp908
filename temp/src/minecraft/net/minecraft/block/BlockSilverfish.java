package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import org.apache.commons.lang3.tuple.ImmutablePair;

public class BlockSilverfish extends Block {

   public static final String[] field_150198_a = new String[]{"stone", "cobble", "brick", "mossybrick", "crackedbrick", "chiseledbrick"};
   private static final String __OBFID = "CL_00000271";


   public BlockSilverfish() {
      super(Material.field_151571_B);
      this.func_149711_c(0.0F);
      this.func_149647_a(CreativeTabs.field_78031_c);
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      switch(p_149691_2_) {
      case 1:
         return Blocks.field_150347_e.func_149733_h(p_149691_1_);
      case 2:
         return Blocks.field_150417_aV.func_149733_h(p_149691_1_);
      case 3:
         return Blocks.field_150417_aV.func_149691_a(p_149691_1_, 1);
      case 4:
         return Blocks.field_150417_aV.func_149691_a(p_149691_1_, 2);
      case 5:
         return Blocks.field_150417_aV.func_149691_a(p_149691_1_, 3);
      default:
         return Blocks.field_150348_b.func_149733_h(p_149691_1_);
      }
   }

   public void func_149651_a(IIconRegister p_149651_1_) {}

   public void func_149664_b(World p_149664_1_, int p_149664_2_, int p_149664_3_, int p_149664_4_, int p_149664_5_) {
      if(!p_149664_1_.field_72995_K) {
         EntitySilverfish var6 = new EntitySilverfish(p_149664_1_);
         var6.func_70012_b((double)p_149664_2_ + 0.5D, (double)p_149664_3_, (double)p_149664_4_ + 0.5D, 0.0F, 0.0F);
         p_149664_1_.func_72838_d(var6);
         var6.func_70656_aK();
      }

      super.func_149664_b(p_149664_1_, p_149664_2_, p_149664_3_, p_149664_4_, p_149664_5_);
   }

   public int func_149745_a(Random p_149745_1_) {
      return 0;
   }

   public static boolean func_150196_a(Block p_150196_0_) {
      return p_150196_0_ == Blocks.field_150348_b || p_150196_0_ == Blocks.field_150347_e || p_150196_0_ == Blocks.field_150417_aV;
   }

   public static int func_150195_a(Block p_150195_0_, int p_150195_1_) {
      if(p_150195_1_ == 0) {
         if(p_150195_0_ == Blocks.field_150347_e) {
            return 1;
         }

         if(p_150195_0_ == Blocks.field_150417_aV) {
            return 2;
         }
      } else if(p_150195_0_ == Blocks.field_150417_aV) {
         switch(p_150195_1_) {
         case 1:
            return 3;
         case 2:
            return 4;
         case 3:
            return 5;
         }
      }

      return 0;
   }

   public static ImmutablePair func_150197_b(int p_150197_0_) {
      switch(p_150197_0_) {
      case 1:
         return new ImmutablePair(Blocks.field_150347_e, Integer.valueOf(0));
      case 2:
         return new ImmutablePair(Blocks.field_150417_aV, Integer.valueOf(0));
      case 3:
         return new ImmutablePair(Blocks.field_150417_aV, Integer.valueOf(1));
      case 4:
         return new ImmutablePair(Blocks.field_150417_aV, Integer.valueOf(2));
      case 5:
         return new ImmutablePair(Blocks.field_150417_aV, Integer.valueOf(3));
      default:
         return new ImmutablePair(Blocks.field_150348_b, Integer.valueOf(0));
      }
   }

   protected ItemStack func_149644_j(int p_149644_1_) {
      switch(p_149644_1_) {
      case 1:
         return new ItemStack(Blocks.field_150347_e);
      case 2:
         return new ItemStack(Blocks.field_150417_aV);
      case 3:
         return new ItemStack(Blocks.field_150417_aV, 1, 1);
      case 4:
         return new ItemStack(Blocks.field_150417_aV, 1, 2);
      case 5:
         return new ItemStack(Blocks.field_150417_aV, 1, 3);
      default:
         return new ItemStack(Blocks.field_150348_b);
      }
   }

   public void func_149690_a(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
      if(!p_149690_1_.field_72995_K) {
         EntitySilverfish var8 = new EntitySilverfish(p_149690_1_);
         var8.func_70012_b((double)p_149690_2_ + 0.5D, (double)p_149690_3_, (double)p_149690_4_ + 0.5D, 0.0F, 0.0F);
         p_149690_1_.func_72838_d(var8);
         var8.func_70656_aK();
      }

   }

   public int func_149643_k(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_) {
      return p_149643_1_.func_72805_g(p_149643_2_, p_149643_3_, p_149643_4_);
   }

   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
      for(int var4 = 0; var4 < field_150198_a.length; ++var4) {
         p_149666_3_.add(new ItemStack(p_149666_1_, 1, var4));
      }

   }

}
