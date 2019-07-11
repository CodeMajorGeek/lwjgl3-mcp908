package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneDiode;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRedstoneRepeater extends BlockRedstoneDiode {

   public static final double[] field_149973_b = new double[]{-0.0625D, 0.0625D, 0.1875D, 0.3125D};
   private static final int[] field_149974_M = new int[]{1, 2, 3, 4};
   private static final String __OBFID = "CL_00000301";


   protected BlockRedstoneRepeater(boolean p_i45424_1_) {
      super(p_i45424_1_);
   }

   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
      int var10 = p_149727_1_.func_72805_g(p_149727_2_, p_149727_3_, p_149727_4_);
      int var11 = (var10 & 12) >> 2;
      var11 = var11 + 1 << 2 & 12;
      p_149727_1_.func_72921_c(p_149727_2_, p_149727_3_, p_149727_4_, var11 | var10 & 3, 3);
      return true;
   }

   protected int func_149901_b(int p_149901_1_) {
      return field_149974_M[(p_149901_1_ & 12) >> 2] * 2;
   }

   protected BlockRedstoneDiode func_149906_e() {
      return Blocks.field_150416_aS;
   }

   protected BlockRedstoneDiode func_149898_i() {
      return Blocks.field_150413_aR;
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Items.field_151107_aW;
   }

   public int func_149645_b() {
      return 15;
   }

   public boolean func_149910_g(IBlockAccess p_149910_1_, int p_149910_2_, int p_149910_3_, int p_149910_4_, int p_149910_5_) {
      return this.func_149902_h(p_149910_1_, p_149910_2_, p_149910_3_, p_149910_4_, p_149910_5_) > 0;
   }

   protected boolean func_149908_a(Block p_149908_1_) {
      return func_149909_d(p_149908_1_);
   }

   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
      super.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
      this.func_149911_e(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_);
   }

}
