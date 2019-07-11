package net.minecraft.world.biome;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBlockBlob;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenTaiga extends BiomeGenBase {

   private static final WorldGenTaiga1 field_150639_aC = new WorldGenTaiga1();
   private static final WorldGenTaiga2 field_150640_aD = new WorldGenTaiga2(false);
   private static final WorldGenMegaPineTree field_150641_aE = new WorldGenMegaPineTree(false, false);
   private static final WorldGenMegaPineTree field_150642_aF = new WorldGenMegaPineTree(false, true);
   private static final WorldGenBlockBlob field_150643_aG = new WorldGenBlockBlob(Blocks.field_150341_Y, 0);
   private int field_150644_aH;
   private static final String __OBFID = "CL_00000186";


   public BiomeGenTaiga(int p_i45385_1_, int p_i45385_2_) {
      super(p_i45385_1_);
      this.field_150644_aH = p_i45385_2_;
      this.field_76762_K.add(new BiomeGenBase.SpawnListEntry(EntityWolf.class, 8, 4, 4));
      this.field_76760_I.field_76832_z = 10;
      if(p_i45385_2_ != 1 && p_i45385_2_ != 2) {
         this.field_76760_I.field_76803_B = 1;
         this.field_76760_I.field_76798_D = 1;
      } else {
         this.field_76760_I.field_76803_B = 7;
         this.field_76760_I.field_76804_C = 1;
         this.field_76760_I.field_76798_D = 3;
      }

   }

   public WorldGenAbstractTree func_150567_a(Random p_150567_1_) {
      return (WorldGenAbstractTree)((this.field_150644_aH == 1 || this.field_150644_aH == 2) && p_150567_1_.nextInt(3) == 0?(this.field_150644_aH != 2 && p_150567_1_.nextInt(13) != 0?field_150641_aE:field_150642_aF):(p_150567_1_.nextInt(3) == 0?field_150639_aC:field_150640_aD));
   }

   public WorldGenerator func_76730_b(Random p_76730_1_) {
      return p_76730_1_.nextInt(5) > 0?new WorldGenTallGrass(Blocks.field_150329_H, 2):new WorldGenTallGrass(Blocks.field_150329_H, 1);
   }

   public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
      int var5;
      int var6;
      int var7;
      int var8;
      if(this.field_150644_aH == 1 || this.field_150644_aH == 2) {
         var5 = p_76728_2_.nextInt(3);

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = p_76728_3_ + p_76728_2_.nextInt(16) + 8;
            var8 = p_76728_4_ + p_76728_2_.nextInt(16) + 8;
            int var9 = p_76728_1_.func_72976_f(var7, var8);
            field_150643_aG.func_76484_a(p_76728_1_, p_76728_2_, var7, var9, var8);
         }
      }

      field_150610_ae.func_150548_a(3);

      for(var5 = 0; var5 < 7; ++var5) {
         var6 = p_76728_3_ + p_76728_2_.nextInt(16) + 8;
         var7 = p_76728_4_ + p_76728_2_.nextInt(16) + 8;
         var8 = p_76728_2_.nextInt(p_76728_1_.func_72976_f(var6, var7) + 32);
         field_150610_ae.func_76484_a(p_76728_1_, p_76728_2_, var6, var8, var7);
      }

      super.func_76728_a(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
   }

   public void func_150573_a(World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_) {
      if(this.field_150644_aH == 1 || this.field_150644_aH == 2) {
         this.field_76752_A = Blocks.field_150349_c;
         this.field_150604_aj = 0;
         this.field_76753_B = Blocks.field_150346_d;
         if(p_150573_7_ > 1.75D) {
            this.field_76752_A = Blocks.field_150346_d;
            this.field_150604_aj = 1;
         } else if(p_150573_7_ > -0.95D) {
            this.field_76752_A = Blocks.field_150346_d;
            this.field_150604_aj = 2;
         }
      }

      this.func_150560_b(p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
   }

   protected BiomeGenBase func_150566_k() {
      return this.field_76756_M == BiomeGenBase.field_150578_U.field_76756_M?(new BiomeGenTaiga(this.field_76756_M + 128, 2)).func_150557_a(5858897, true).func_76735_a("Mega Spruce Taiga").func_76733_a(5159473).func_76732_a(0.25F, 0.8F).func_150570_a(new BiomeGenBase.Height(this.field_76748_D, this.field_76749_E)):super.func_150566_k();
   }

}
