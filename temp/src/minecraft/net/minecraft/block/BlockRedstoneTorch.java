package net.minecraft.block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRedstoneTorch extends BlockTorch {

   private boolean field_150113_a;
   private static Map field_150112_b = new HashMap();
   private static final String __OBFID = "CL_00000298";


   private boolean func_150111_a(World p_150111_1_, int p_150111_2_, int p_150111_3_, int p_150111_4_, boolean p_150111_5_) {
      if(!field_150112_b.containsKey(p_150111_1_)) {
         field_150112_b.put(p_150111_1_, new ArrayList());
      }

      List var6 = (List)field_150112_b.get(p_150111_1_);
      if(p_150111_5_) {
         var6.add(new BlockRedstoneTorch.Toggle(p_150111_2_, p_150111_3_, p_150111_4_, p_150111_1_.func_82737_E()));
      }

      int var7 = 0;

      for(int var8 = 0; var8 < var6.size(); ++var8) {
         BlockRedstoneTorch.Toggle var9 = (BlockRedstoneTorch.Toggle)var6.get(var8);
         if(var9.field_150847_a == p_150111_2_ && var9.field_150845_b == p_150111_3_ && var9.field_150846_c == p_150111_4_) {
            ++var7;
            if(var7 >= 8) {
               return true;
            }
         }
      }

      return false;
   }

   protected BlockRedstoneTorch(boolean p_i45423_1_) {
      this.field_150113_a = p_i45423_1_;
      this.func_149675_a(true);
      this.func_149647_a((CreativeTabs)null);
   }

   public int func_149738_a(World p_149738_1_) {
      return 2;
   }

   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
      if(p_149726_1_.func_72805_g(p_149726_2_, p_149726_3_, p_149726_4_) == 0) {
         super.func_149726_b(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
      }

      if(this.field_150113_a) {
         p_149726_1_.func_147459_d(p_149726_2_, p_149726_3_ - 1, p_149726_4_, this);
         p_149726_1_.func_147459_d(p_149726_2_, p_149726_3_ + 1, p_149726_4_, this);
         p_149726_1_.func_147459_d(p_149726_2_ - 1, p_149726_3_, p_149726_4_, this);
         p_149726_1_.func_147459_d(p_149726_2_ + 1, p_149726_3_, p_149726_4_, this);
         p_149726_1_.func_147459_d(p_149726_2_, p_149726_3_, p_149726_4_ - 1, this);
         p_149726_1_.func_147459_d(p_149726_2_, p_149726_3_, p_149726_4_ + 1, this);
      }

   }

   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
      if(this.field_150113_a) {
         p_149749_1_.func_147459_d(p_149749_2_, p_149749_3_ - 1, p_149749_4_, this);
         p_149749_1_.func_147459_d(p_149749_2_, p_149749_3_ + 1, p_149749_4_, this);
         p_149749_1_.func_147459_d(p_149749_2_ - 1, p_149749_3_, p_149749_4_, this);
         p_149749_1_.func_147459_d(p_149749_2_ + 1, p_149749_3_, p_149749_4_, this);
         p_149749_1_.func_147459_d(p_149749_2_, p_149749_3_, p_149749_4_ - 1, this);
         p_149749_1_.func_147459_d(p_149749_2_, p_149749_3_, p_149749_4_ + 1, this);
      }

   }

   public int func_149709_b(IBlockAccess p_149709_1_, int p_149709_2_, int p_149709_3_, int p_149709_4_, int p_149709_5_) {
      if(!this.field_150113_a) {
         return 0;
      } else {
         int var6 = p_149709_1_.func_72805_g(p_149709_2_, p_149709_3_, p_149709_4_);
         return var6 == 5 && p_149709_5_ == 1?0:(var6 == 3 && p_149709_5_ == 3?0:(var6 == 4 && p_149709_5_ == 2?0:(var6 == 1 && p_149709_5_ == 5?0:(var6 == 2 && p_149709_5_ == 4?0:15))));
      }
   }

   private boolean func_150110_m(World p_150110_1_, int p_150110_2_, int p_150110_3_, int p_150110_4_) {
      int var5 = p_150110_1_.func_72805_g(p_150110_2_, p_150110_3_, p_150110_4_);
      return var5 == 5 && p_150110_1_.func_94574_k(p_150110_2_, p_150110_3_ - 1, p_150110_4_, 0)?true:(var5 == 3 && p_150110_1_.func_94574_k(p_150110_2_, p_150110_3_, p_150110_4_ - 1, 2)?true:(var5 == 4 && p_150110_1_.func_94574_k(p_150110_2_, p_150110_3_, p_150110_4_ + 1, 3)?true:(var5 == 1 && p_150110_1_.func_94574_k(p_150110_2_ - 1, p_150110_3_, p_150110_4_, 4)?true:var5 == 2 && p_150110_1_.func_94574_k(p_150110_2_ + 1, p_150110_3_, p_150110_4_, 5))));
   }

   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      boolean var6 = this.func_150110_m(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);
      List var7 = (List)field_150112_b.get(p_149674_1_);

      while(var7 != null && !var7.isEmpty() && p_149674_1_.func_82737_E() - ((BlockRedstoneTorch.Toggle)var7.get(0)).field_150844_d > 60L) {
         var7.remove(0);
      }

      if(this.field_150113_a) {
         if(var6) {
            p_149674_1_.func_147465_d(p_149674_2_, p_149674_3_, p_149674_4_, Blocks.field_150437_az, p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_), 3);
            if(this.func_150111_a(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, true)) {
               p_149674_1_.func_72908_a((double)((float)p_149674_2_ + 0.5F), (double)((float)p_149674_3_ + 0.5F), (double)((float)p_149674_4_ + 0.5F), "random.fizz", 0.5F, 2.6F + (p_149674_1_.field_73012_v.nextFloat() - p_149674_1_.field_73012_v.nextFloat()) * 0.8F);

               for(int var8 = 0; var8 < 5; ++var8) {
                  double var9 = (double)p_149674_2_ + p_149674_5_.nextDouble() * 0.6D + 0.2D;
                  double var11 = (double)p_149674_3_ + p_149674_5_.nextDouble() * 0.6D + 0.2D;
                  double var13 = (double)p_149674_4_ + p_149674_5_.nextDouble() * 0.6D + 0.2D;
                  p_149674_1_.func_72869_a("smoke", var9, var11, var13, 0.0D, 0.0D, 0.0D);
               }
            }
         }
      } else if(!var6 && !this.func_150111_a(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, false)) {
         p_149674_1_.func_147465_d(p_149674_2_, p_149674_3_, p_149674_4_, Blocks.field_150429_aA, p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_), 3);
      }

   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      if(!this.func_150108_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_5_)) {
         boolean var6 = this.func_150110_m(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
         if(this.field_150113_a && var6 || !this.field_150113_a && !var6) {
            p_149695_1_.func_147464_a(p_149695_2_, p_149695_3_, p_149695_4_, this, this.func_149738_a(p_149695_1_));
         }

      }
   }

   public int func_149748_c(IBlockAccess p_149748_1_, int p_149748_2_, int p_149748_3_, int p_149748_4_, int p_149748_5_) {
      return p_149748_5_ == 0?this.func_149709_b(p_149748_1_, p_149748_2_, p_149748_3_, p_149748_4_, p_149748_5_):0;
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Item.func_150898_a(Blocks.field_150429_aA);
   }

   public boolean func_149744_f() {
      return true;
   }

   public void func_149734_b(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
      if(this.field_150113_a) {
         int var6 = p_149734_1_.func_72805_g(p_149734_2_, p_149734_3_, p_149734_4_);
         double var7 = (double)((float)p_149734_2_ + 0.5F) + (double)(p_149734_5_.nextFloat() - 0.5F) * 0.2D;
         double var9 = (double)((float)p_149734_3_ + 0.7F) + (double)(p_149734_5_.nextFloat() - 0.5F) * 0.2D;
         double var11 = (double)((float)p_149734_4_ + 0.5F) + (double)(p_149734_5_.nextFloat() - 0.5F) * 0.2D;
         double var13 = 0.2199999988079071D;
         double var15 = 0.27000001072883606D;
         if(var6 == 1) {
            p_149734_1_.func_72869_a("reddust", var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
         } else if(var6 == 2) {
            p_149734_1_.func_72869_a("reddust", var7 + var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
         } else if(var6 == 3) {
            p_149734_1_.func_72869_a("reddust", var7, var9 + var13, var11 - var15, 0.0D, 0.0D, 0.0D);
         } else if(var6 == 4) {
            p_149734_1_.func_72869_a("reddust", var7, var9 + var13, var11 + var15, 0.0D, 0.0D, 0.0D);
         } else {
            p_149734_1_.func_72869_a("reddust", var7, var9, var11, 0.0D, 0.0D, 0.0D);
         }

      }
   }

   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
      return Item.func_150898_a(Blocks.field_150429_aA);
   }

   public boolean func_149667_c(Block p_149667_1_) {
      return p_149667_1_ == Blocks.field_150437_az || p_149667_1_ == Blocks.field_150429_aA;
   }


   static class Toggle {

      int field_150847_a;
      int field_150845_b;
      int field_150846_c;
      long field_150844_d;
      private static final String __OBFID = "CL_00000299";


      public Toggle(int p_i45422_1_, int p_i45422_2_, int p_i45422_3_, long p_i45422_4_) {
         this.field_150847_a = p_i45422_1_;
         this.field_150845_b = p_i45422_2_;
         this.field_150846_c = p_i45422_3_;
         this.field_150844_d = p_i45422_4_;
      }
   }
}
