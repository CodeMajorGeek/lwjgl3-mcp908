package net.minecraft.world;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;

public class ChunkCache implements IBlockAccess {

   private int field_72818_a;
   private int field_72816_b;
   private Chunk[][] field_72817_c;
   private boolean field_72814_d;
   private World field_72815_e;
   private static final String __OBFID = "CL_00000155";


   public ChunkCache(World p_i1964_1_, int p_i1964_2_, int p_i1964_3_, int p_i1964_4_, int p_i1964_5_, int p_i1964_6_, int p_i1964_7_, int p_i1964_8_) {
      this.field_72815_e = p_i1964_1_;
      this.field_72818_a = p_i1964_2_ - p_i1964_8_ >> 4;
      this.field_72816_b = p_i1964_4_ - p_i1964_8_ >> 4;
      int var9 = p_i1964_5_ + p_i1964_8_ >> 4;
      int var10 = p_i1964_7_ + p_i1964_8_ >> 4;
      this.field_72817_c = new Chunk[var9 - this.field_72818_a + 1][var10 - this.field_72816_b + 1];
      this.field_72814_d = true;

      int var11;
      int var12;
      Chunk var13;
      for(var11 = this.field_72818_a; var11 <= var9; ++var11) {
         for(var12 = this.field_72816_b; var12 <= var10; ++var12) {
            var13 = p_i1964_1_.func_72964_e(var11, var12);
            if(var13 != null) {
               this.field_72817_c[var11 - this.field_72818_a][var12 - this.field_72816_b] = var13;
            }
         }
      }

      for(var11 = p_i1964_2_ >> 4; var11 <= p_i1964_5_ >> 4; ++var11) {
         for(var12 = p_i1964_4_ >> 4; var12 <= p_i1964_7_ >> 4; ++var12) {
            var13 = this.field_72817_c[var11 - this.field_72818_a][var12 - this.field_72816_b];
            if(var13 != null && !var13.func_76606_c(p_i1964_3_, p_i1964_6_)) {
               this.field_72814_d = false;
            }
         }
      }

   }

   public boolean func_72806_N() {
      return this.field_72814_d;
   }

   public Block func_147439_a(int p_147439_1_, int p_147439_2_, int p_147439_3_) {
      Block var4 = Blocks.field_150350_a;
      if(p_147439_2_ >= 0 && p_147439_2_ < 256) {
         int var5 = (p_147439_1_ >> 4) - this.field_72818_a;
         int var6 = (p_147439_3_ >> 4) - this.field_72816_b;
         if(var5 >= 0 && var5 < this.field_72817_c.length && var6 >= 0 && var6 < this.field_72817_c[var5].length) {
            Chunk var7 = this.field_72817_c[var5][var6];
            if(var7 != null) {
               var4 = var7.func_150810_a(p_147439_1_ & 15, p_147439_2_, p_147439_3_ & 15);
            }
         }
      }

      return var4;
   }

   public TileEntity func_147438_o(int p_147438_1_, int p_147438_2_, int p_147438_3_) {
      int var4 = (p_147438_1_ >> 4) - this.field_72818_a;
      int var5 = (p_147438_3_ >> 4) - this.field_72816_b;
      return this.field_72817_c[var4][var5].func_150806_e(p_147438_1_ & 15, p_147438_2_, p_147438_3_ & 15);
   }

   public int func_72802_i(int p_72802_1_, int p_72802_2_, int p_72802_3_, int p_72802_4_) {
      int var5 = this.func_72810_a(EnumSkyBlock.Sky, p_72802_1_, p_72802_2_, p_72802_3_);
      int var6 = this.func_72810_a(EnumSkyBlock.Block, p_72802_1_, p_72802_2_, p_72802_3_);
      if(var6 < p_72802_4_) {
         var6 = p_72802_4_;
      }

      return var5 << 20 | var6 << 4;
   }

   public int func_72805_g(int p_72805_1_, int p_72805_2_, int p_72805_3_) {
      if(p_72805_2_ < 0) {
         return 0;
      } else if(p_72805_2_ >= 256) {
         return 0;
      } else {
         int var4 = (p_72805_1_ >> 4) - this.field_72818_a;
         int var5 = (p_72805_3_ >> 4) - this.field_72816_b;
         return this.field_72817_c[var4][var5].func_76628_c(p_72805_1_ & 15, p_72805_2_, p_72805_3_ & 15);
      }
   }

   public BiomeGenBase func_72807_a(int p_72807_1_, int p_72807_2_) {
      return this.field_72815_e.func_72807_a(p_72807_1_, p_72807_2_);
   }

   public boolean func_147437_c(int p_147437_1_, int p_147437_2_, int p_147437_3_) {
      return this.func_147439_a(p_147437_1_, p_147437_2_, p_147437_3_).func_149688_o() == Material.field_151579_a;
   }

   public int func_72810_a(EnumSkyBlock p_72810_1_, int p_72810_2_, int p_72810_3_, int p_72810_4_) {
      if(p_72810_3_ < 0) {
         p_72810_3_ = 0;
      }

      if(p_72810_3_ >= 256) {
         p_72810_3_ = 255;
      }

      if(p_72810_3_ >= 0 && p_72810_3_ < 256 && p_72810_2_ >= -30000000 && p_72810_4_ >= -30000000 && p_72810_2_ < 30000000 && p_72810_4_ <= 30000000) {
         if(p_72810_1_ == EnumSkyBlock.Sky && this.field_72815_e.field_73011_w.field_76576_e) {
            return 0;
         } else {
            int var5;
            int var6;
            if(this.func_147439_a(p_72810_2_, p_72810_3_, p_72810_4_).func_149710_n()) {
               var5 = this.func_72812_b(p_72810_1_, p_72810_2_, p_72810_3_ + 1, p_72810_4_);
               var6 = this.func_72812_b(p_72810_1_, p_72810_2_ + 1, p_72810_3_, p_72810_4_);
               int var7 = this.func_72812_b(p_72810_1_, p_72810_2_ - 1, p_72810_3_, p_72810_4_);
               int var8 = this.func_72812_b(p_72810_1_, p_72810_2_, p_72810_3_, p_72810_4_ + 1);
               int var9 = this.func_72812_b(p_72810_1_, p_72810_2_, p_72810_3_, p_72810_4_ - 1);
               if(var6 > var5) {
                  var5 = var6;
               }

               if(var7 > var5) {
                  var5 = var7;
               }

               if(var8 > var5) {
                  var5 = var8;
               }

               if(var9 > var5) {
                  var5 = var9;
               }

               return var5;
            } else {
               var5 = (p_72810_2_ >> 4) - this.field_72818_a;
               var6 = (p_72810_4_ >> 4) - this.field_72816_b;
               return this.field_72817_c[var5][var6].func_76614_a(p_72810_1_, p_72810_2_ & 15, p_72810_3_, p_72810_4_ & 15);
            }
         }
      } else {
         return p_72810_1_.field_77198_c;
      }
   }

   public int func_72812_b(EnumSkyBlock p_72812_1_, int p_72812_2_, int p_72812_3_, int p_72812_4_) {
      if(p_72812_3_ < 0) {
         p_72812_3_ = 0;
      }

      if(p_72812_3_ >= 256) {
         p_72812_3_ = 255;
      }

      if(p_72812_3_ >= 0 && p_72812_3_ < 256 && p_72812_2_ >= -30000000 && p_72812_4_ >= -30000000 && p_72812_2_ < 30000000 && p_72812_4_ <= 30000000) {
         int var5 = (p_72812_2_ >> 4) - this.field_72818_a;
         int var6 = (p_72812_4_ >> 4) - this.field_72816_b;
         return this.field_72817_c[var5][var6].func_76614_a(p_72812_1_, p_72812_2_ & 15, p_72812_3_, p_72812_4_ & 15);
      } else {
         return p_72812_1_.field_77198_c;
      }
   }

   public int func_72800_K() {
      return 256;
   }

   public int func_72879_k(int p_72879_1_, int p_72879_2_, int p_72879_3_, int p_72879_4_) {
      return this.func_147439_a(p_72879_1_, p_72879_2_, p_72879_3_).func_149748_c(this, p_72879_1_, p_72879_2_, p_72879_3_, p_72879_4_);
   }
}
