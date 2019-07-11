package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSnow extends Block {

   private static final String __OBFID = "CL_00000309";


   protected BlockSnow() {
      super(Material.field_151597_y);
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
      this.func_149675_a(true);
      this.func_149647_a(CreativeTabs.field_78031_c);
      this.func_150154_b(0);
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149761_L = p_149651_1_.func_94245_a("snow");
   }

   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
      int var5 = p_149668_1_.func_72805_g(p_149668_2_, p_149668_3_, p_149668_4_) & 7;
      float var6 = 0.125F;
      return AxisAlignedBB.func_72330_a((double)p_149668_2_ + this.field_149759_B, (double)p_149668_3_ + this.field_149760_C, (double)p_149668_4_ + this.field_149754_D, (double)p_149668_2_ + this.field_149755_E, (double)((float)p_149668_3_ + (float)var5 * var6), (double)p_149668_4_ + this.field_149757_G);
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public void func_149683_g() {
      this.func_150154_b(0);
   }

   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
      this.func_150154_b(p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_));
   }

   protected void func_150154_b(int p_150154_1_) {
      int var2 = p_150154_1_ & 7;
      float var3 = (float)(2 * (1 + var2)) / 16.0F;
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, var3, 1.0F);
   }

   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
      Block var5 = p_149742_1_.func_147439_a(p_149742_2_, p_149742_3_ - 1, p_149742_4_);
      return var5 != Blocks.field_150432_aD && var5 != Blocks.field_150403_cj?(var5.func_149688_o() == Material.field_151584_j?true:(var5 == this && (p_149742_1_.func_72805_g(p_149742_2_, p_149742_3_ - 1, p_149742_4_) & 7) == 7?true:var5.func_149662_c() && var5.field_149764_J.func_76230_c())):false;
   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      this.func_150155_m(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
   }

   private boolean func_150155_m(World p_150155_1_, int p_150155_2_, int p_150155_3_, int p_150155_4_) {
      if(!this.func_149742_c(p_150155_1_, p_150155_2_, p_150155_3_, p_150155_4_)) {
         this.func_149697_b(p_150155_1_, p_150155_2_, p_150155_3_, p_150155_4_, p_150155_1_.func_72805_g(p_150155_2_, p_150155_3_, p_150155_4_), 0);
         p_150155_1_.func_147468_f(p_150155_2_, p_150155_3_, p_150155_4_);
         return false;
      } else {
         return true;
      }
   }

   public void func_149636_a(World p_149636_1_, EntityPlayer p_149636_2_, int p_149636_3_, int p_149636_4_, int p_149636_5_, int p_149636_6_) {
      int var7 = p_149636_6_ & 7;
      this.func_149642_a(p_149636_1_, p_149636_3_, p_149636_4_, p_149636_5_, new ItemStack(Items.field_151126_ay, var7 + 1, 0));
      p_149636_1_.func_147468_f(p_149636_3_, p_149636_4_, p_149636_5_);
      p_149636_2_.func_71064_a(StatList.field_75934_C[Block.func_149682_b(this)], 1);
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Items.field_151126_ay;
   }

   public int func_149745_a(Random p_149745_1_) {
      return 0;
   }

   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      if(p_149674_1_.func_72972_b(EnumSkyBlock.Block, p_149674_2_, p_149674_3_, p_149674_4_) > 11) {
         this.func_149697_b(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_), 0);
         p_149674_1_.func_147468_f(p_149674_2_, p_149674_3_, p_149674_4_);
      }

   }

   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
      return p_149646_5_ == 1?true:super.func_149646_a(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
   }
}
