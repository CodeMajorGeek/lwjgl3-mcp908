package net.minecraft.world.biome;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeGenSwamp extends BiomeGenBase {

   private static final String __OBFID = "CL_00000185";


   protected BiomeGenSwamp(int p_i1988_1_) {
      super(p_i1988_1_);
      this.field_76760_I.field_76832_z = 2;
      this.field_76760_I.field_76802_A = 1;
      this.field_76760_I.field_76804_C = 1;
      this.field_76760_I.field_76798_D = 8;
      this.field_76760_I.field_76799_E = 10;
      this.field_76760_I.field_76806_I = 1;
      this.field_76760_I.field_76833_y = 4;
      this.field_76760_I.field_76805_H = 0;
      this.field_76760_I.field_76801_G = 0;
      this.field_76760_I.field_76803_B = 5;
      this.field_76759_H = 14745518;
      this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntitySlime.class, 1, 1, 1));
   }

   public WorldGenAbstractTree func_150567_a(Random p_150567_1_) {
      return this.field_76763_Q;
   }

   public int func_150558_b(int p_150558_1_, int p_150558_2_, int p_150558_3_) {
      double var4 = field_150606_ad.func_151601_a((double)p_150558_1_ * 0.0225D, (double)p_150558_3_ * 0.0225D);
      return var4 < -0.1D?5011004:6975545;
   }

   public int func_150571_c(int p_150571_1_, int p_150571_2_, int p_150571_3_) {
      return 6975545;
   }

   public String func_150572_a(Random p_150572_1_, int p_150572_2_, int p_150572_3_, int p_150572_4_) {
      return BlockFlower.field_149859_a[1];
   }

   public void func_150573_a(World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_) {
      double var9 = field_150606_ad.func_151601_a((double)p_150573_5_ * 0.25D, (double)p_150573_6_ * 0.25D);
      if(var9 > 0.0D) {
         int var11 = p_150573_5_ & 15;
         int var12 = p_150573_6_ & 15;
         int var13 = p_150573_3_.length / 256;

         for(int var14 = 255; var14 >= 0; --var14) {
            int var15 = (var12 * 16 + var11) * var13 + var14;
            if(p_150573_3_[var15] == null || p_150573_3_[var15].func_149688_o() != Material.field_151579_a) {
               if(var14 == 62 && p_150573_3_[var15] != Blocks.field_150355_j) {
                  p_150573_3_[var15] = Blocks.field_150355_j;
                  if(var9 < 0.12D) {
                     p_150573_3_[var15 + 1] = Blocks.field_150392_bi;
                  }
               }
               break;
            }
         }
      }

      this.func_150560_b(p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
   }
}
