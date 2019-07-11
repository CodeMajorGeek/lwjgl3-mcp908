package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class BlockTorch extends Block {

   private static final String __OBFID = "CL_00000325";


   protected BlockTorch() {
      super(Material.field_151594_q);
      this.func_149675_a(true);
      this.func_149647_a(CreativeTabs.field_78031_c);
   }

   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
      return null;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public int func_149645_b() {
      return 2;
   }

   private boolean func_150107_m(World p_150107_1_, int p_150107_2_, int p_150107_3_, int p_150107_4_) {
      if(World.func_147466_a(p_150107_1_, p_150107_2_, p_150107_3_, p_150107_4_)) {
         return true;
      } else {
         Block var5 = p_150107_1_.func_147439_a(p_150107_2_, p_150107_3_, p_150107_4_);
         return var5 == Blocks.field_150422_aJ || var5 == Blocks.field_150386_bk || var5 == Blocks.field_150359_w || var5 == Blocks.field_150463_bK;
      }
   }

   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
      return p_149742_1_.func_147445_c(p_149742_2_ - 1, p_149742_3_, p_149742_4_, true)?true:(p_149742_1_.func_147445_c(p_149742_2_ + 1, p_149742_3_, p_149742_4_, true)?true:(p_149742_1_.func_147445_c(p_149742_2_, p_149742_3_, p_149742_4_ - 1, true)?true:(p_149742_1_.func_147445_c(p_149742_2_, p_149742_3_, p_149742_4_ + 1, true)?true:this.func_150107_m(p_149742_1_, p_149742_2_, p_149742_3_ - 1, p_149742_4_))));
   }

   public int func_149660_a(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_) {
      int var10 = p_149660_9_;
      if(p_149660_5_ == 1 && this.func_150107_m(p_149660_1_, p_149660_2_, p_149660_3_ - 1, p_149660_4_)) {
         var10 = 5;
      }

      if(p_149660_5_ == 2 && p_149660_1_.func_147445_c(p_149660_2_, p_149660_3_, p_149660_4_ + 1, true)) {
         var10 = 4;
      }

      if(p_149660_5_ == 3 && p_149660_1_.func_147445_c(p_149660_2_, p_149660_3_, p_149660_4_ - 1, true)) {
         var10 = 3;
      }

      if(p_149660_5_ == 4 && p_149660_1_.func_147445_c(p_149660_2_ + 1, p_149660_3_, p_149660_4_, true)) {
         var10 = 2;
      }

      if(p_149660_5_ == 5 && p_149660_1_.func_147445_c(p_149660_2_ - 1, p_149660_3_, p_149660_4_, true)) {
         var10 = 1;
      }

      return var10;
   }

   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      super.func_149674_a(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
      if(p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_) == 0) {
         this.func_149726_b(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);
      }

   }

   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
      if(p_149726_1_.func_72805_g(p_149726_2_, p_149726_3_, p_149726_4_) == 0) {
         if(p_149726_1_.func_147445_c(p_149726_2_ - 1, p_149726_3_, p_149726_4_, true)) {
            p_149726_1_.func_72921_c(p_149726_2_, p_149726_3_, p_149726_4_, 1, 2);
         } else if(p_149726_1_.func_147445_c(p_149726_2_ + 1, p_149726_3_, p_149726_4_, true)) {
            p_149726_1_.func_72921_c(p_149726_2_, p_149726_3_, p_149726_4_, 2, 2);
         } else if(p_149726_1_.func_147445_c(p_149726_2_, p_149726_3_, p_149726_4_ - 1, true)) {
            p_149726_1_.func_72921_c(p_149726_2_, p_149726_3_, p_149726_4_, 3, 2);
         } else if(p_149726_1_.func_147445_c(p_149726_2_, p_149726_3_, p_149726_4_ + 1, true)) {
            p_149726_1_.func_72921_c(p_149726_2_, p_149726_3_, p_149726_4_, 4, 2);
         } else if(this.func_150107_m(p_149726_1_, p_149726_2_, p_149726_3_ - 1, p_149726_4_)) {
            p_149726_1_.func_72921_c(p_149726_2_, p_149726_3_, p_149726_4_, 5, 2);
         }
      }

      this.func_150109_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      this.func_150108_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_5_);
   }

   protected boolean func_150108_b(World p_150108_1_, int p_150108_2_, int p_150108_3_, int p_150108_4_, Block p_150108_5_) {
      if(this.func_150109_e(p_150108_1_, p_150108_2_, p_150108_3_, p_150108_4_)) {
         int var6 = p_150108_1_.func_72805_g(p_150108_2_, p_150108_3_, p_150108_4_);
         boolean var7 = false;
         if(!p_150108_1_.func_147445_c(p_150108_2_ - 1, p_150108_3_, p_150108_4_, true) && var6 == 1) {
            var7 = true;
         }

         if(!p_150108_1_.func_147445_c(p_150108_2_ + 1, p_150108_3_, p_150108_4_, true) && var6 == 2) {
            var7 = true;
         }

         if(!p_150108_1_.func_147445_c(p_150108_2_, p_150108_3_, p_150108_4_ - 1, true) && var6 == 3) {
            var7 = true;
         }

         if(!p_150108_1_.func_147445_c(p_150108_2_, p_150108_3_, p_150108_4_ + 1, true) && var6 == 4) {
            var7 = true;
         }

         if(!this.func_150107_m(p_150108_1_, p_150108_2_, p_150108_3_ - 1, p_150108_4_) && var6 == 5) {
            var7 = true;
         }

         if(var7) {
            this.func_149697_b(p_150108_1_, p_150108_2_, p_150108_3_, p_150108_4_, p_150108_1_.func_72805_g(p_150108_2_, p_150108_3_, p_150108_4_), 0);
            p_150108_1_.func_147468_f(p_150108_2_, p_150108_3_, p_150108_4_);
            return true;
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   protected boolean func_150109_e(World p_150109_1_, int p_150109_2_, int p_150109_3_, int p_150109_4_) {
      if(!this.func_149742_c(p_150109_1_, p_150109_2_, p_150109_3_, p_150109_4_)) {
         if(p_150109_1_.func_147439_a(p_150109_2_, p_150109_3_, p_150109_4_) == this) {
            this.func_149697_b(p_150109_1_, p_150109_2_, p_150109_3_, p_150109_4_, p_150109_1_.func_72805_g(p_150109_2_, p_150109_3_, p_150109_4_), 0);
            p_150109_1_.func_147468_f(p_150109_2_, p_150109_3_, p_150109_4_);
         }

         return false;
      } else {
         return true;
      }
   }

   public MovingObjectPosition func_149731_a(World p_149731_1_, int p_149731_2_, int p_149731_3_, int p_149731_4_, Vec3 p_149731_5_, Vec3 p_149731_6_) {
      int var7 = p_149731_1_.func_72805_g(p_149731_2_, p_149731_3_, p_149731_4_) & 7;
      float var8 = 0.15F;
      if(var7 == 1) {
         this.func_149676_a(0.0F, 0.2F, 0.5F - var8, var8 * 2.0F, 0.8F, 0.5F + var8);
      } else if(var7 == 2) {
         this.func_149676_a(1.0F - var8 * 2.0F, 0.2F, 0.5F - var8, 1.0F, 0.8F, 0.5F + var8);
      } else if(var7 == 3) {
         this.func_149676_a(0.5F - var8, 0.2F, 0.0F, 0.5F + var8, 0.8F, var8 * 2.0F);
      } else if(var7 == 4) {
         this.func_149676_a(0.5F - var8, 0.2F, 1.0F - var8 * 2.0F, 0.5F + var8, 0.8F, 1.0F);
      } else {
         var8 = 0.1F;
         this.func_149676_a(0.5F - var8, 0.0F, 0.5F - var8, 0.5F + var8, 0.6F, 0.5F + var8);
      }

      return super.func_149731_a(p_149731_1_, p_149731_2_, p_149731_3_, p_149731_4_, p_149731_5_, p_149731_6_);
   }

   public void func_149734_b(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
      int var6 = p_149734_1_.func_72805_g(p_149734_2_, p_149734_3_, p_149734_4_);
      double var7 = (double)((float)p_149734_2_ + 0.5F);
      double var9 = (double)((float)p_149734_3_ + 0.7F);
      double var11 = (double)((float)p_149734_4_ + 0.5F);
      double var13 = 0.2199999988079071D;
      double var15 = 0.27000001072883606D;
      if(var6 == 1) {
         p_149734_1_.func_72869_a("smoke", var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
         p_149734_1_.func_72869_a("flame", var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
      } else if(var6 == 2) {
         p_149734_1_.func_72869_a("smoke", var7 + var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
         p_149734_1_.func_72869_a("flame", var7 + var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
      } else if(var6 == 3) {
         p_149734_1_.func_72869_a("smoke", var7, var9 + var13, var11 - var15, 0.0D, 0.0D, 0.0D);
         p_149734_1_.func_72869_a("flame", var7, var9 + var13, var11 - var15, 0.0D, 0.0D, 0.0D);
      } else if(var6 == 4) {
         p_149734_1_.func_72869_a("smoke", var7, var9 + var13, var11 + var15, 0.0D, 0.0D, 0.0D);
         p_149734_1_.func_72869_a("flame", var7, var9 + var13, var11 + var15, 0.0D, 0.0D, 0.0D);
      } else {
         p_149734_1_.func_72869_a("smoke", var7, var9, var11, 0.0D, 0.0D, 0.0D);
         p_149734_1_.func_72869_a("flame", var7, var9, var11, 0.0D, 0.0D, 0.0D);
      }

   }
}
