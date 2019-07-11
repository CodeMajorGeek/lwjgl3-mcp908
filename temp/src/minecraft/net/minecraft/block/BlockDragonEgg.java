package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDragonEgg extends Block {

   private static final String __OBFID = "CL_00000232";


   public BlockDragonEgg() {
      super(Material.field_151566_D);
      this.func_149676_a(0.0625F, 0.0F, 0.0625F, 0.9375F, 1.0F, 0.9375F);
   }

   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
      p_149726_1_.func_147464_a(p_149726_2_, p_149726_3_, p_149726_4_, this, this.func_149738_a(p_149726_1_));
   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      p_149695_1_.func_147464_a(p_149695_2_, p_149695_3_, p_149695_4_, this, this.func_149738_a(p_149695_1_));
   }

   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      this.func_150018_e(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);
   }

   private void func_150018_e(World p_150018_1_, int p_150018_2_, int p_150018_3_, int p_150018_4_) {
      if(BlockFalling.func_149831_e(p_150018_1_, p_150018_2_, p_150018_3_ - 1, p_150018_4_) && p_150018_3_ >= 0) {
         byte var5 = 32;
         if(!BlockFalling.field_149832_M && p_150018_1_.func_72904_c(p_150018_2_ - var5, p_150018_3_ - var5, p_150018_4_ - var5, p_150018_2_ + var5, p_150018_3_ + var5, p_150018_4_ + var5)) {
            EntityFallingBlock var6 = new EntityFallingBlock(p_150018_1_, (double)((float)p_150018_2_ + 0.5F), (double)((float)p_150018_3_ + 0.5F), (double)((float)p_150018_4_ + 0.5F), this);
            p_150018_1_.func_72838_d(var6);
         } else {
            p_150018_1_.func_147468_f(p_150018_2_, p_150018_3_, p_150018_4_);

            while(BlockFalling.func_149831_e(p_150018_1_, p_150018_2_, p_150018_3_ - 1, p_150018_4_) && p_150018_3_ > 0) {
               --p_150018_3_;
            }

            if(p_150018_3_ > 0) {
               p_150018_1_.func_147465_d(p_150018_2_, p_150018_3_, p_150018_4_, this, 0, 2);
            }
         }
      }

   }

   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
      this.func_150019_m(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_);
      return true;
   }

   public void func_149699_a(World p_149699_1_, int p_149699_2_, int p_149699_3_, int p_149699_4_, EntityPlayer p_149699_5_) {
      this.func_150019_m(p_149699_1_, p_149699_2_, p_149699_3_, p_149699_4_);
   }

   private void func_150019_m(World p_150019_1_, int p_150019_2_, int p_150019_3_, int p_150019_4_) {
      if(p_150019_1_.func_147439_a(p_150019_2_, p_150019_3_, p_150019_4_) == this) {
         for(int var5 = 0; var5 < 1000; ++var5) {
            int var6 = p_150019_2_ + p_150019_1_.field_73012_v.nextInt(16) - p_150019_1_.field_73012_v.nextInt(16);
            int var7 = p_150019_3_ + p_150019_1_.field_73012_v.nextInt(8) - p_150019_1_.field_73012_v.nextInt(8);
            int var8 = p_150019_4_ + p_150019_1_.field_73012_v.nextInt(16) - p_150019_1_.field_73012_v.nextInt(16);
            if(p_150019_1_.func_147439_a(var6, var7, var8).field_149764_J == Material.field_151579_a) {
               if(!p_150019_1_.field_72995_K) {
                  p_150019_1_.func_147465_d(var6, var7, var8, this, p_150019_1_.func_72805_g(p_150019_2_, p_150019_3_, p_150019_4_), 2);
                  p_150019_1_.func_147468_f(p_150019_2_, p_150019_3_, p_150019_4_);
               } else {
                  short var9 = 128;

                  for(int var10 = 0; var10 < var9; ++var10) {
                     double var11 = p_150019_1_.field_73012_v.nextDouble();
                     float var13 = (p_150019_1_.field_73012_v.nextFloat() - 0.5F) * 0.2F;
                     float var14 = (p_150019_1_.field_73012_v.nextFloat() - 0.5F) * 0.2F;
                     float var15 = (p_150019_1_.field_73012_v.nextFloat() - 0.5F) * 0.2F;
                     double var16 = (double)var6 + (double)(p_150019_2_ - var6) * var11 + (p_150019_1_.field_73012_v.nextDouble() - 0.5D) * 1.0D + 0.5D;
                     double var18 = (double)var7 + (double)(p_150019_3_ - var7) * var11 + p_150019_1_.field_73012_v.nextDouble() * 1.0D - 0.5D;
                     double var20 = (double)var8 + (double)(p_150019_4_ - var8) * var11 + (p_150019_1_.field_73012_v.nextDouble() - 0.5D) * 1.0D + 0.5D;
                     p_150019_1_.func_72869_a("portal", var16, var18, var20, (double)var13, (double)var14, (double)var15);
                  }
               }

               return;
            }
         }

      }
   }

   public int func_149738_a(World p_149738_1_) {
      return 5;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
      return true;
   }

   public int func_149645_b() {
      return 27;
   }

   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
      return Item.func_150899_d(0);
   }
}
