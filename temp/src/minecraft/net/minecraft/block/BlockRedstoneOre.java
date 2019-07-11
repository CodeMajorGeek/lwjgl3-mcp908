package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockRedstoneOre extends Block {

   private boolean field_150187_a;
   private static final String __OBFID = "CL_00000294";


   public BlockRedstoneOre(boolean p_i45420_1_) {
      super(Material.field_151576_e);
      if(p_i45420_1_) {
         this.func_149675_a(true);
      }

      this.field_150187_a = p_i45420_1_;
   }

   public int func_149738_a(World p_149738_1_) {
      return 30;
   }

   public void func_149699_a(World p_149699_1_, int p_149699_2_, int p_149699_3_, int p_149699_4_, EntityPlayer p_149699_5_) {
      this.func_150185_e(p_149699_1_, p_149699_2_, p_149699_3_, p_149699_4_);
      super.func_149699_a(p_149699_1_, p_149699_2_, p_149699_3_, p_149699_4_, p_149699_5_);
   }

   public void func_149724_b(World p_149724_1_, int p_149724_2_, int p_149724_3_, int p_149724_4_, Entity p_149724_5_) {
      this.func_150185_e(p_149724_1_, p_149724_2_, p_149724_3_, p_149724_4_);
      super.func_149724_b(p_149724_1_, p_149724_2_, p_149724_3_, p_149724_4_, p_149724_5_);
   }

   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
      this.func_150185_e(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_);
      return super.func_149727_a(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, p_149727_5_, p_149727_6_, p_149727_7_, p_149727_8_, p_149727_9_);
   }

   private void func_150185_e(World p_150185_1_, int p_150185_2_, int p_150185_3_, int p_150185_4_) {
      this.func_150186_m(p_150185_1_, p_150185_2_, p_150185_3_, p_150185_4_);
      if(this == Blocks.field_150450_ax) {
         p_150185_1_.func_147449_b(p_150185_2_, p_150185_3_, p_150185_4_, Blocks.field_150439_ay);
      }

   }

   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      if(this == Blocks.field_150439_ay) {
         p_149674_1_.func_147449_b(p_149674_2_, p_149674_3_, p_149674_4_, Blocks.field_150450_ax);
      }

   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Items.field_151137_ax;
   }

   public int func_149679_a(int p_149679_1_, Random p_149679_2_) {
      return this.func_149745_a(p_149679_2_) + p_149679_2_.nextInt(p_149679_1_ + 1);
   }

   public int func_149745_a(Random p_149745_1_) {
      return 4 + p_149745_1_.nextInt(2);
   }

   public void func_149690_a(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
      super.func_149690_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_, p_149690_7_);
      if(this.func_149650_a(p_149690_5_, p_149690_1_.field_73012_v, p_149690_7_) != Item.func_150898_a(this)) {
         int var8 = 1 + p_149690_1_.field_73012_v.nextInt(5);
         this.func_149657_c(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, var8);
      }

   }

   public void func_149734_b(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
      if(this.field_150187_a) {
         this.func_150186_m(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_);
      }

   }

   private void func_150186_m(World p_150186_1_, int p_150186_2_, int p_150186_3_, int p_150186_4_) {
      Random var5 = p_150186_1_.field_73012_v;
      double var6 = 0.0625D;

      for(int var8 = 0; var8 < 6; ++var8) {
         double var9 = (double)((float)p_150186_2_ + var5.nextFloat());
         double var11 = (double)((float)p_150186_3_ + var5.nextFloat());
         double var13 = (double)((float)p_150186_4_ + var5.nextFloat());
         if(var8 == 0 && !p_150186_1_.func_147439_a(p_150186_2_, p_150186_3_ + 1, p_150186_4_).func_149662_c()) {
            var11 = (double)(p_150186_3_ + 1) + var6;
         }

         if(var8 == 1 && !p_150186_1_.func_147439_a(p_150186_2_, p_150186_3_ - 1, p_150186_4_).func_149662_c()) {
            var11 = (double)(p_150186_3_ + 0) - var6;
         }

         if(var8 == 2 && !p_150186_1_.func_147439_a(p_150186_2_, p_150186_3_, p_150186_4_ + 1).func_149662_c()) {
            var13 = (double)(p_150186_4_ + 1) + var6;
         }

         if(var8 == 3 && !p_150186_1_.func_147439_a(p_150186_2_, p_150186_3_, p_150186_4_ - 1).func_149662_c()) {
            var13 = (double)(p_150186_4_ + 0) - var6;
         }

         if(var8 == 4 && !p_150186_1_.func_147439_a(p_150186_2_ + 1, p_150186_3_, p_150186_4_).func_149662_c()) {
            var9 = (double)(p_150186_2_ + 1) + var6;
         }

         if(var8 == 5 && !p_150186_1_.func_147439_a(p_150186_2_ - 1, p_150186_3_, p_150186_4_).func_149662_c()) {
            var9 = (double)(p_150186_2_ + 0) - var6;
         }

         if(var9 < (double)p_150186_2_ || var9 > (double)(p_150186_2_ + 1) || var11 < 0.0D || var11 > (double)(p_150186_3_ + 1) || var13 < (double)p_150186_4_ || var13 > (double)(p_150186_4_ + 1)) {
            p_150186_1_.func_72869_a("reddust", var9, var11, var13, 0.0D, 0.0D, 0.0D);
         }
      }

   }

   protected ItemStack func_149644_j(int p_149644_1_) {
      return new ItemStack(Blocks.field_150450_ax);
   }
}
