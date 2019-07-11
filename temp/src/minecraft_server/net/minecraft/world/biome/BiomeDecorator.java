package net.minecraft.world.biome;

import java.util.Random;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.world.gen.feature.WorldGenCactus;
import net.minecraft.world.gen.feature.WorldGenClay;
import net.minecraft.world.gen.feature.WorldGenDeadBush;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenPumpkin;
import net.minecraft.world.gen.feature.WorldGenReed;
import net.minecraft.world.gen.feature.WorldGenSand;
import net.minecraft.world.gen.feature.WorldGenWaterlily;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeDecorator {

   protected World field_76815_a;
   protected Random field_76813_b;
   protected int field_76814_c;
   protected int field_76811_d;
   protected WorldGenerator field_76809_f = new WorldGenClay(4);
   protected WorldGenerator field_76810_g;
   protected WorldGenerator field_76822_h;
   protected WorldGenerator field_76823_i;
   protected WorldGenerator field_76820_j;
   protected WorldGenerator field_76821_k;
   protected WorldGenerator field_76818_l;
   protected WorldGenerator field_76819_m;
   protected WorldGenerator field_76816_n;
   protected WorldGenerator field_76817_o;
   protected WorldGenerator field_76831_p;
   protected WorldGenFlowers field_150514_p;
   protected WorldGenerator field_76828_s;
   protected WorldGenerator field_76827_t;
   protected WorldGenerator field_76826_u;
   protected WorldGenerator field_76825_v;
   protected WorldGenerator field_76824_w;
   protected WorldGenerator field_76834_x;
   protected int field_76833_y;
   protected int field_76832_z;
   protected int field_76802_A;
   protected int field_76803_B;
   protected int field_76804_C;
   protected int field_76798_D;
   protected int field_76799_E;
   protected int field_76800_F;
   protected int field_76801_G;
   protected int field_76805_H;
   protected int field_76806_I;
   protected int field_76807_J;
   public boolean field_76808_K;
   private static final String __OBFID = "CL_00000164";


   public BiomeDecorator() {
      this.field_76810_g = new WorldGenSand(Blocks.field_150354_m, 7);
      this.field_76822_h = new WorldGenSand(Blocks.field_150351_n, 6);
      this.field_76823_i = new WorldGenMinable(Blocks.field_150346_d, 32);
      this.field_76820_j = new WorldGenMinable(Blocks.field_150351_n, 32);
      this.field_76821_k = new WorldGenMinable(Blocks.field_150365_q, 16);
      this.field_76818_l = new WorldGenMinable(Blocks.field_150366_p, 8);
      this.field_76819_m = new WorldGenMinable(Blocks.field_150352_o, 8);
      this.field_76816_n = new WorldGenMinable(Blocks.field_150450_ax, 7);
      this.field_76817_o = new WorldGenMinable(Blocks.field_150482_ag, 7);
      this.field_76831_p = new WorldGenMinable(Blocks.field_150369_x, 6);
      this.field_150514_p = new WorldGenFlowers(Blocks.field_150327_N);
      this.field_76828_s = new WorldGenFlowers(Blocks.field_150338_P);
      this.field_76827_t = new WorldGenFlowers(Blocks.field_150337_Q);
      this.field_76826_u = new WorldGenBigMushroom();
      this.field_76825_v = new WorldGenReed();
      this.field_76824_w = new WorldGenCactus();
      this.field_76834_x = new WorldGenWaterlily();
      this.field_76802_A = 2;
      this.field_76803_B = 1;
      this.field_76801_G = 1;
      this.field_76805_H = 3;
      this.field_76806_I = 1;
      this.field_76808_K = true;
   }

   public void func_150512_a(World p_150512_1_, Random p_150512_2_, BiomeGenBase p_150512_3_, int p_150512_4_, int p_150512_5_) {
      if(this.field_76815_a != null) {
         throw new RuntimeException("Already decorating!!");
      } else {
         this.field_76815_a = p_150512_1_;
         this.field_76813_b = p_150512_2_;
         this.field_76814_c = p_150512_4_;
         this.field_76811_d = p_150512_5_;
         this.func_150513_a(p_150512_3_);
         this.field_76815_a = null;
         this.field_76813_b = null;
      }
   }

   protected void func_150513_a(BiomeGenBase p_150513_1_) {
      this.func_76797_b();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < this.field_76805_H; ++var2) {
         var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
         var4 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
         this.field_76810_g.func_76484_a(this.field_76815_a, this.field_76813_b, var3, this.field_76815_a.func_72825_h(var3, var4), var4);
      }

      for(var2 = 0; var2 < this.field_76806_I; ++var2) {
         var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
         var4 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
         this.field_76809_f.func_76484_a(this.field_76815_a, this.field_76813_b, var3, this.field_76815_a.func_72825_h(var3, var4), var4);
      }

      for(var2 = 0; var2 < this.field_76801_G; ++var2) {
         var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
         var4 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
         this.field_76822_h.func_76484_a(this.field_76815_a, this.field_76813_b, var3, this.field_76815_a.func_72825_h(var3, var4), var4);
      }

      var2 = this.field_76832_z;
      if(this.field_76813_b.nextInt(10) == 0) {
         ++var2;
      }

      int var5;
      int var6;
      for(var3 = 0; var3 < var2; ++var3) {
         var4 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
         var5 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
         var6 = this.field_76815_a.func_72976_f(var4, var5);
         WorldGenAbstractTree var7 = p_150513_1_.func_150567_a(this.field_76813_b);
         var7.func_76487_a(1.0D, 1.0D, 1.0D);
         if(var7.func_76484_a(this.field_76815_a, this.field_76813_b, var4, var6, var5)) {
            var7.func_150524_b(this.field_76815_a, this.field_76813_b, var4, var6, var5);
         }
      }

      for(var3 = 0; var3 < this.field_76807_J; ++var3) {
         var4 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
         var5 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
         this.field_76826_u.func_76484_a(this.field_76815_a, this.field_76813_b, var4, this.field_76815_a.func_72976_f(var4, var5), var5);
      }

      for(var3 = 0; var3 < this.field_76802_A; ++var3) {
         var4 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
         var5 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
         var6 = this.field_76813_b.nextInt(this.field_76815_a.func_72976_f(var4, var5) + 32);
         String var9 = p_150513_1_.func_150572_a(this.field_76813_b, var4, var6, var5);
         BlockFlower var8 = BlockFlower.func_149857_e(var9);
         if(var8.func_149688_o() != Material.field_151579_a) {
            this.field_150514_p.func_150550_a(var8, BlockFlower.func_149856_f(var9));
            this.field_150514_p.func_76484_a(this.field_76815_a, this.field_76813_b, var4, var6, var5);
         }
      }

      for(var3 = 0; var3 < this.field_76803_B; ++var3) {
         var4 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
         var5 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
         var6 = this.field_76813_b.nextInt(this.field_76815_a.func_72976_f(var4, var5) * 2);
         WorldGenerator var10 = p_150513_1_.func_76730_b(this.field_76813_b);
         var10.func_76484_a(this.field_76815_a, this.field_76813_b, var4, var6, var5);
      }

      for(var3 = 0; var3 < this.field_76804_C; ++var3) {
         var4 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
         var5 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
         var6 = this.field_76813_b.nextInt(this.field_76815_a.func_72976_f(var4, var5) * 2);
         (new WorldGenDeadBush(Blocks.field_150330_I)).func_76484_a(this.field_76815_a, this.field_76813_b, var4, var6, var5);
      }

      for(var3 = 0; var3 < this.field_76833_y; ++var3) {
         var4 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
         var5 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;

         for(var6 = this.field_76813_b.nextInt(this.field_76815_a.func_72976_f(var4, var5) * 2); var6 > 0 && this.field_76815_a.func_147437_c(var4, var6 - 1, var5); --var6) {
            ;
         }

         this.field_76834_x.func_76484_a(this.field_76815_a, this.field_76813_b, var4, var6, var5);
      }

      for(var3 = 0; var3 < this.field_76798_D; ++var3) {
         if(this.field_76813_b.nextInt(4) == 0) {
            var4 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var5 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            var6 = this.field_76815_a.func_72976_f(var4, var5);
            this.field_76828_s.func_76484_a(this.field_76815_a, this.field_76813_b, var4, var6, var5);
         }

         if(this.field_76813_b.nextInt(8) == 0) {
            var4 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var5 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            var6 = this.field_76813_b.nextInt(this.field_76815_a.func_72976_f(var4, var5) * 2);
            this.field_76827_t.func_76484_a(this.field_76815_a, this.field_76813_b, var4, var6, var5);
         }
      }

      if(this.field_76813_b.nextInt(4) == 0) {
         var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
         var4 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
         var5 = this.field_76813_b.nextInt(this.field_76815_a.func_72976_f(var3, var4) * 2);
         this.field_76828_s.func_76484_a(this.field_76815_a, this.field_76813_b, var3, var5, var4);
      }

      if(this.field_76813_b.nextInt(8) == 0) {
         var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
         var4 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
         var5 = this.field_76813_b.nextInt(this.field_76815_a.func_72976_f(var3, var4) * 2);
         this.field_76827_t.func_76484_a(this.field_76815_a, this.field_76813_b, var3, var5, var4);
      }

      for(var3 = 0; var3 < this.field_76799_E; ++var3) {
         var4 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
         var5 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
         var6 = this.field_76813_b.nextInt(this.field_76815_a.func_72976_f(var4, var5) * 2);
         this.field_76825_v.func_76484_a(this.field_76815_a, this.field_76813_b, var4, var6, var5);
      }

      for(var3 = 0; var3 < 10; ++var3) {
         var4 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
         var5 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
         var6 = this.field_76813_b.nextInt(this.field_76815_a.func_72976_f(var4, var5) * 2);
         this.field_76825_v.func_76484_a(this.field_76815_a, this.field_76813_b, var4, var6, var5);
      }

      if(this.field_76813_b.nextInt(32) == 0) {
         var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
         var4 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
         var5 = this.field_76813_b.nextInt(this.field_76815_a.func_72976_f(var3, var4) * 2);
         (new WorldGenPumpkin()).func_76484_a(this.field_76815_a, this.field_76813_b, var3, var5, var4);
      }

      for(var3 = 0; var3 < this.field_76800_F; ++var3) {
         var4 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
         var5 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
         var6 = this.field_76813_b.nextInt(this.field_76815_a.func_72976_f(var4, var5) * 2);
         this.field_76824_w.func_76484_a(this.field_76815_a, this.field_76813_b, var4, var6, var5);
      }

      if(this.field_76808_K) {
         for(var3 = 0; var3 < 50; ++var3) {
            var4 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var5 = this.field_76813_b.nextInt(this.field_76813_b.nextInt(248) + 8);
            var6 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            (new WorldGenLiquids(Blocks.field_150358_i)).func_76484_a(this.field_76815_a, this.field_76813_b, var4, var5, var6);
         }

         for(var3 = 0; var3 < 20; ++var3) {
            var4 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var5 = this.field_76813_b.nextInt(this.field_76813_b.nextInt(this.field_76813_b.nextInt(240) + 8) + 8);
            var6 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            (new WorldGenLiquids(Blocks.field_150356_k)).func_76484_a(this.field_76815_a, this.field_76813_b, var4, var5, var6);
         }
      }

   }

   protected void func_76795_a(int p_76795_1_, WorldGenerator p_76795_2_, int p_76795_3_, int p_76795_4_) {
      for(int var5 = 0; var5 < p_76795_1_; ++var5) {
         int var6 = this.field_76814_c + this.field_76813_b.nextInt(16);
         int var7 = this.field_76813_b.nextInt(p_76795_4_ - p_76795_3_) + p_76795_3_;
         int var8 = this.field_76811_d + this.field_76813_b.nextInt(16);
         p_76795_2_.func_76484_a(this.field_76815_a, this.field_76813_b, var6, var7, var8);
      }

   }

   protected void func_76793_b(int p_76793_1_, WorldGenerator p_76793_2_, int p_76793_3_, int p_76793_4_) {
      for(int var5 = 0; var5 < p_76793_1_; ++var5) {
         int var6 = this.field_76814_c + this.field_76813_b.nextInt(16);
         int var7 = this.field_76813_b.nextInt(p_76793_4_) + this.field_76813_b.nextInt(p_76793_4_) + (p_76793_3_ - p_76793_4_);
         int var8 = this.field_76811_d + this.field_76813_b.nextInt(16);
         p_76793_2_.func_76484_a(this.field_76815_a, this.field_76813_b, var6, var7, var8);
      }

   }

   protected void func_76797_b() {
      this.func_76795_a(20, this.field_76823_i, 0, 256);
      this.func_76795_a(10, this.field_76820_j, 0, 256);
      this.func_76795_a(20, this.field_76821_k, 0, 128);
      this.func_76795_a(20, this.field_76818_l, 0, 64);
      this.func_76795_a(2, this.field_76819_m, 0, 32);
      this.func_76795_a(8, this.field_76816_n, 0, 16);
      this.func_76795_a(1, this.field_76817_o, 0, 16);
      this.func_76793_b(1, this.field_76831_p, 16, 16);
   }
}
