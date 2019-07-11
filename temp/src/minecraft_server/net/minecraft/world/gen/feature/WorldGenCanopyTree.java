package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenCanopyTree extends WorldGenAbstractTree {

   private static final String __OBFID = "CL_00000430";


   public WorldGenCanopyTree(boolean p_i45461_1_) {
      super(p_i45461_1_);
   }

   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      int var6 = p_76484_2_.nextInt(3) + p_76484_2_.nextInt(2) + 6;
      boolean var7 = true;
      if(p_76484_4_ >= 1 && p_76484_4_ + var6 + 1 <= 256) {
         int var10;
         int var11;
         for(int var8 = p_76484_4_; var8 <= p_76484_4_ + 1 + var6; ++var8) {
            byte var9 = 1;
            if(var8 == p_76484_4_) {
               var9 = 0;
            }

            if(var8 >= p_76484_4_ + 1 + var6 - 2) {
               var9 = 2;
            }

            for(var10 = p_76484_3_ - var9; var10 <= p_76484_3_ + var9 && var7; ++var10) {
               for(var11 = p_76484_5_ - var9; var11 <= p_76484_5_ + var9 && var7; ++var11) {
                  if(var8 >= 0 && var8 < 256) {
                     Block var12 = p_76484_1_.func_147439_a(var10, var8, var11);
                     if(!this.func_150523_a(var12)) {
                        var7 = false;
                     }
                  } else {
                     var7 = false;
                  }
               }
            }
         }

         if(!var7) {
            return false;
         } else {
            Block var20 = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_);
            if((var20 == Blocks.field_150349_c || var20 == Blocks.field_150346_d) && p_76484_4_ < 256 - var6 - 1) {
               this.func_150515_a(p_76484_1_, p_76484_3_, p_76484_4_ - 1, p_76484_5_, Blocks.field_150346_d);
               this.func_150515_a(p_76484_1_, p_76484_3_ + 1, p_76484_4_ - 1, p_76484_5_, Blocks.field_150346_d);
               this.func_150515_a(p_76484_1_, p_76484_3_ + 1, p_76484_4_ - 1, p_76484_5_ + 1, Blocks.field_150346_d);
               this.func_150515_a(p_76484_1_, p_76484_3_, p_76484_4_ - 1, p_76484_5_ + 1, Blocks.field_150346_d);
               int var21 = p_76484_2_.nextInt(4);
               var10 = var6 - p_76484_2_.nextInt(4);
               var11 = 2 - p_76484_2_.nextInt(3);
               int var22 = p_76484_3_;
               int var13 = p_76484_5_;
               int var14 = 0;

               int var15;
               int var16;
               for(var15 = 0; var15 < var6; ++var15) {
                  var16 = p_76484_4_ + var15;
                  if(var15 >= var10 && var11 > 0) {
                     var22 += Direction.field_71583_a[var21];
                     var13 += Direction.field_71581_b[var21];
                     --var11;
                  }

                  Block var17 = p_76484_1_.func_147439_a(var22, var16, var13);
                  if(var17.func_149688_o() == Material.field_151579_a || var17.func_149688_o() == Material.field_151584_j) {
                     this.func_150516_a(p_76484_1_, var22, var16, var13, Blocks.field_150363_s, 1);
                     this.func_150516_a(p_76484_1_, var22 + 1, var16, var13, Blocks.field_150363_s, 1);
                     this.func_150516_a(p_76484_1_, var22, var16, var13 + 1, Blocks.field_150363_s, 1);
                     this.func_150516_a(p_76484_1_, var22 + 1, var16, var13 + 1, Blocks.field_150363_s, 1);
                     var14 = var16;
                  }
               }

               for(var15 = -2; var15 <= 0; ++var15) {
                  for(var16 = -2; var16 <= 0; ++var16) {
                     byte var23 = -1;
                     this.func_150526_a(p_76484_1_, var22 + var15, var14 + var23, var13 + var16);
                     this.func_150526_a(p_76484_1_, 1 + var22 - var15, var14 + var23, var13 + var16);
                     this.func_150526_a(p_76484_1_, var22 + var15, var14 + var23, 1 + var13 - var16);
                     this.func_150526_a(p_76484_1_, 1 + var22 - var15, var14 + var23, 1 + var13 - var16);
                     if((var15 > -2 || var16 > -1) && (var15 != -1 || var16 != -2)) {
                        byte var24 = 1;
                        this.func_150526_a(p_76484_1_, var22 + var15, var14 + var24, var13 + var16);
                        this.func_150526_a(p_76484_1_, 1 + var22 - var15, var14 + var24, var13 + var16);
                        this.func_150526_a(p_76484_1_, var22 + var15, var14 + var24, 1 + var13 - var16);
                        this.func_150526_a(p_76484_1_, 1 + var22 - var15, var14 + var24, 1 + var13 - var16);
                     }
                  }
               }

               if(p_76484_2_.nextBoolean()) {
                  this.func_150526_a(p_76484_1_, var22, var14 + 2, var13);
                  this.func_150526_a(p_76484_1_, var22 + 1, var14 + 2, var13);
                  this.func_150526_a(p_76484_1_, var22 + 1, var14 + 2, var13 + 1);
                  this.func_150526_a(p_76484_1_, var22, var14 + 2, var13 + 1);
               }

               for(var15 = -3; var15 <= 4; ++var15) {
                  for(var16 = -3; var16 <= 4; ++var16) {
                     if((var15 != -3 || var16 != -3) && (var15 != -3 || var16 != 4) && (var15 != 4 || var16 != -3) && (var15 != 4 || var16 != 4) && (Math.abs(var15) < 3 || Math.abs(var16) < 3)) {
                        this.func_150526_a(p_76484_1_, var22 + var15, var14, var13 + var16);
                     }
                  }
               }

               for(var15 = -1; var15 <= 2; ++var15) {
                  for(var16 = -1; var16 <= 2; ++var16) {
                     if((var15 < 0 || var15 > 1 || var16 < 0 || var16 > 1) && p_76484_2_.nextInt(3) <= 0) {
                        int var25 = p_76484_2_.nextInt(3) + 2;

                        int var18;
                        for(var18 = 0; var18 < var25; ++var18) {
                           this.func_150516_a(p_76484_1_, p_76484_3_ + var15, var14 - var18 - 1, p_76484_5_ + var16, Blocks.field_150363_s, 1);
                        }

                        int var19;
                        for(var18 = -1; var18 <= 1; ++var18) {
                           for(var19 = -1; var19 <= 1; ++var19) {
                              this.func_150526_a(p_76484_1_, var22 + var15 + var18, var14 - 0, var13 + var16 + var19);
                           }
                        }

                        for(var18 = -2; var18 <= 2; ++var18) {
                           for(var19 = -2; var19 <= 2; ++var19) {
                              if(Math.abs(var18) != 2 || Math.abs(var19) != 2) {
                                 this.func_150526_a(p_76484_1_, var22 + var15 + var18, var14 - 1, var13 + var16 + var19);
                              }
                           }
                        }
                     }
                  }
               }

               return true;
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }

   private void func_150526_a(World p_150526_1_, int p_150526_2_, int p_150526_3_, int p_150526_4_) {
      Block var5 = p_150526_1_.func_147439_a(p_150526_2_, p_150526_3_, p_150526_4_);
      if(var5.func_149688_o() == Material.field_151579_a) {
         this.func_150516_a(p_150526_1_, p_150526_2_, p_150526_3_, p_150526_4_, Blocks.field_150361_u, 1);
      }

   }
}
