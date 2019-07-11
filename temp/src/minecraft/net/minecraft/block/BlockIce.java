package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockIce extends BlockBreakable {

   private static final String __OBFID = "CL_00000259";


   public BlockIce() {
      super("ice", Material.field_151588_w, false);
      this.field_149765_K = 0.98F;
      this.func_149675_a(true);
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   public int func_149701_w() {
      return 1;
   }

   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
      return super.func_149646_a(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, 1 - p_149646_5_);
   }

   public void func_149636_a(World p_149636_1_, EntityPlayer p_149636_2_, int p_149636_3_, int p_149636_4_, int p_149636_5_, int p_149636_6_) {
      p_149636_2_.func_71064_a(StatList.field_75934_C[Block.func_149682_b(this)], 1);
      p_149636_2_.func_71020_j(0.025F);
      if(this.func_149700_E() && EnchantmentHelper.func_77502_d(p_149636_2_)) {
         ItemStack var9 = this.func_149644_j(p_149636_6_);
         if(var9 != null) {
            this.func_149642_a(p_149636_1_, p_149636_3_, p_149636_4_, p_149636_5_, var9);
         }
      } else {
         if(p_149636_1_.field_73011_w.field_76575_d) {
            p_149636_1_.func_147468_f(p_149636_3_, p_149636_4_, p_149636_5_);
            return;
         }

         int var7 = EnchantmentHelper.func_77517_e(p_149636_2_);
         this.func_149697_b(p_149636_1_, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_, var7);
         Material var8 = p_149636_1_.func_147439_a(p_149636_3_, p_149636_4_ - 1, p_149636_5_).func_149688_o();
         if(var8.func_76230_c() || var8.func_76224_d()) {
            p_149636_1_.func_147449_b(p_149636_3_, p_149636_4_, p_149636_5_, Blocks.field_150358_i);
         }
      }

   }

   public int func_149745_a(Random p_149745_1_) {
      return 0;
   }

   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      if(p_149674_1_.func_72972_b(EnumSkyBlock.Block, p_149674_2_, p_149674_3_, p_149674_4_) > 11 - this.func_149717_k()) {
         if(p_149674_1_.field_73011_w.field_76575_d) {
            p_149674_1_.func_147468_f(p_149674_2_, p_149674_3_, p_149674_4_);
            return;
         }

         this.func_149697_b(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_), 0);
         p_149674_1_.func_147449_b(p_149674_2_, p_149674_3_, p_149674_4_, Blocks.field_150355_j);
      }

   }

   public int func_149656_h() {
      return 0;
   }
}
