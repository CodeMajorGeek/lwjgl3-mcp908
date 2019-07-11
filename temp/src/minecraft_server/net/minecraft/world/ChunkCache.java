package net.minecraft.world;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
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

   public int func_72879_k(int p_72879_1_, int p_72879_2_, int p_72879_3_, int p_72879_4_) {
      return this.func_147439_a(p_72879_1_, p_72879_2_, p_72879_3_).func_149748_c(this, p_72879_1_, p_72879_2_, p_72879_3_, p_72879_4_);
   }
}
