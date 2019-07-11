package net.minecraft.block;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BlockBed extends BlockDirectional {

   public static final int[][] field_149981_a = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
   private IIcon[] field_149980_b;
   private IIcon[] field_149982_M;
   private IIcon[] field_149983_N;
   private static final String __OBFID = "CL_00000198";


   public BlockBed() {
      super(Material.field_151580_n);
      this.func_149978_e();
   }

   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
      if(p_149727_1_.field_72995_K) {
         return true;
      } else {
         int var10 = p_149727_1_.func_72805_g(p_149727_2_, p_149727_3_, p_149727_4_);
         if(!func_149975_b(var10)) {
            int var11 = func_149895_l(var10);
            p_149727_2_ += field_149981_a[var11][0];
            p_149727_4_ += field_149981_a[var11][1];
            if(p_149727_1_.func_147439_a(p_149727_2_, p_149727_3_, p_149727_4_) != this) {
               return true;
            }

            var10 = p_149727_1_.func_72805_g(p_149727_2_, p_149727_3_, p_149727_4_);
         }

         if(p_149727_1_.field_73011_w.func_76567_e() && p_149727_1_.func_72807_a(p_149727_2_, p_149727_4_) != BiomeGenBase.field_76778_j) {
            if(func_149976_c(var10)) {
               EntityPlayer var19 = null;
               Iterator var12 = p_149727_1_.field_73010_i.iterator();

               while(var12.hasNext()) {
                  EntityPlayer var21 = (EntityPlayer)var12.next();
                  if(var21.func_70608_bn()) {
                     ChunkCoordinates var14 = var21.field_71081_bT;
                     if(var14.field_71574_a == p_149727_2_ && var14.field_71572_b == p_149727_3_ && var14.field_71573_c == p_149727_4_) {
                        var19 = var21;
                     }
                  }
               }

               if(var19 != null) {
                  p_149727_5_.func_146105_b(new ChatComponentTranslation("tile.bed.occupied", new Object[0]));
                  return true;
               }

               func_149979_a(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, false);
            }

            EntityPlayer.EnumStatus var20 = p_149727_5_.func_71018_a(p_149727_2_, p_149727_3_, p_149727_4_);
            if(var20 == EntityPlayer.EnumStatus.OK) {
               func_149979_a(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, true);
               return true;
            } else {
               if(var20 == EntityPlayer.EnumStatus.NOT_POSSIBLE_NOW) {
                  p_149727_5_.func_146105_b(new ChatComponentTranslation("tile.bed.noSleep", new Object[0]));
               } else if(var20 == EntityPlayer.EnumStatus.NOT_SAFE) {
                  p_149727_5_.func_146105_b(new ChatComponentTranslation("tile.bed.notSafe", new Object[0]));
               }

               return true;
            }
         } else {
            double var18 = (double)p_149727_2_ + 0.5D;
            double var13 = (double)p_149727_3_ + 0.5D;
            double var15 = (double)p_149727_4_ + 0.5D;
            p_149727_1_.func_147468_f(p_149727_2_, p_149727_3_, p_149727_4_);
            int var17 = func_149895_l(var10);
            p_149727_2_ += field_149981_a[var17][0];
            p_149727_4_ += field_149981_a[var17][1];
            if(p_149727_1_.func_147439_a(p_149727_2_, p_149727_3_, p_149727_4_) == this) {
               p_149727_1_.func_147468_f(p_149727_2_, p_149727_3_, p_149727_4_);
               var18 = (var18 + (double)p_149727_2_ + 0.5D) / 2.0D;
               var13 = (var13 + (double)p_149727_3_ + 0.5D) / 2.0D;
               var15 = (var15 + (double)p_149727_4_ + 0.5D) / 2.0D;
            }

            p_149727_1_.func_72885_a((Entity)null, (double)((float)p_149727_2_ + 0.5F), (double)((float)p_149727_3_ + 0.5F), (double)((float)p_149727_4_ + 0.5F), 5.0F, true, true);
            return true;
         }
      }
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      if(p_149691_1_ == 0) {
         return Blocks.field_150344_f.func_149733_h(p_149691_1_);
      } else {
         int var3 = func_149895_l(p_149691_2_);
         int var4 = Direction.field_71584_h[var3][p_149691_1_];
         int var5 = func_149975_b(p_149691_2_)?1:0;
         return (var5 != 1 || var4 != 2) && (var5 != 0 || var4 != 3)?(var4 != 5 && var4 != 4?this.field_149983_N[var5]:this.field_149982_M[var5]):this.field_149980_b[var5];
      }
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149983_N = new IIcon[]{p_149651_1_.func_94245_a(this.func_149641_N() + "_feet_top"), p_149651_1_.func_94245_a(this.func_149641_N() + "_head_top")};
      this.field_149980_b = new IIcon[]{p_149651_1_.func_94245_a(this.func_149641_N() + "_feet_end"), p_149651_1_.func_94245_a(this.func_149641_N() + "_head_end")};
      this.field_149982_M = new IIcon[]{p_149651_1_.func_94245_a(this.func_149641_N() + "_feet_side"), p_149651_1_.func_94245_a(this.func_149641_N() + "_head_side")};
   }

   public int func_149645_b() {
      return 14;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149662_c() {
      return false;
   }

   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
      this.func_149978_e();
   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      int var6 = p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_);
      int var7 = func_149895_l(var6);
      if(func_149975_b(var6)) {
         if(p_149695_1_.func_147439_a(p_149695_2_ - field_149981_a[var7][0], p_149695_3_, p_149695_4_ - field_149981_a[var7][1]) != this) {
            p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
         }
      } else if(p_149695_1_.func_147439_a(p_149695_2_ + field_149981_a[var7][0], p_149695_3_, p_149695_4_ + field_149981_a[var7][1]) != this) {
         p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
         if(!p_149695_1_.field_72995_K) {
            this.func_149697_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, var6, 0);
         }
      }

   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return func_149975_b(p_149650_1_)?Item.func_150899_d(0):Items.field_151104_aV;
   }

   private void func_149978_e() {
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5625F, 1.0F);
   }

   public static boolean func_149975_b(int p_149975_0_) {
      return (p_149975_0_ & 8) != 0;
   }

   public static boolean func_149976_c(int p_149976_0_) {
      return (p_149976_0_ & 4) != 0;
   }

   public static void func_149979_a(World p_149979_0_, int p_149979_1_, int p_149979_2_, int p_149979_3_, boolean p_149979_4_) {
      int var5 = p_149979_0_.func_72805_g(p_149979_1_, p_149979_2_, p_149979_3_);
      if(p_149979_4_) {
         var5 |= 4;
      } else {
         var5 &= -5;
      }

      p_149979_0_.func_72921_c(p_149979_1_, p_149979_2_, p_149979_3_, var5, 4);
   }

   public static ChunkCoordinates func_149977_a(World p_149977_0_, int p_149977_1_, int p_149977_2_, int p_149977_3_, int p_149977_4_) {
      int var5 = p_149977_0_.func_72805_g(p_149977_1_, p_149977_2_, p_149977_3_);
      int var6 = BlockDirectional.func_149895_l(var5);

      for(int var7 = 0; var7 <= 1; ++var7) {
         int var8 = p_149977_1_ - field_149981_a[var6][0] * var7 - 1;
         int var9 = p_149977_3_ - field_149981_a[var6][1] * var7 - 1;
         int var10 = var8 + 2;
         int var11 = var9 + 2;

         for(int var12 = var8; var12 <= var10; ++var12) {
            for(int var13 = var9; var13 <= var11; ++var13) {
               if(World.func_147466_a(p_149977_0_, var12, p_149977_2_ - 1, var13) && !p_149977_0_.func_147439_a(var12, p_149977_2_, var13).func_149688_o().func_76218_k() && !p_149977_0_.func_147439_a(var12, p_149977_2_ + 1, var13).func_149688_o().func_76218_k()) {
                  if(p_149977_4_ <= 0) {
                     return new ChunkCoordinates(var12, p_149977_2_, var13);
                  }

                  --p_149977_4_;
               }
            }
         }
      }

      return null;
   }

   public void func_149690_a(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
      if(!func_149975_b(p_149690_5_)) {
         super.func_149690_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_, 0);
      }

   }

   public int func_149656_h() {
      return 1;
   }

   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
      return Items.field_151104_aV;
   }

   public void func_149681_a(World p_149681_1_, int p_149681_2_, int p_149681_3_, int p_149681_4_, int p_149681_5_, EntityPlayer p_149681_6_) {
      if(p_149681_6_.field_71075_bZ.field_75098_d && func_149975_b(p_149681_5_)) {
         int var7 = func_149895_l(p_149681_5_);
         p_149681_2_ -= field_149981_a[var7][0];
         p_149681_4_ -= field_149981_a[var7][1];
         if(p_149681_1_.func_147439_a(p_149681_2_, p_149681_3_, p_149681_4_) == this) {
            p_149681_1_.func_147468_f(p_149681_2_, p_149681_3_, p_149681_4_);
         }
      }

   }

}
