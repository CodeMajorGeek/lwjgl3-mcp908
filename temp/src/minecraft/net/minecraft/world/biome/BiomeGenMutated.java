package net.minecraft.world.biome;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeGenMutated extends BiomeGenBase {

   protected BiomeGenBase field_150611_aD;
   private static final String __OBFID = "CL_00000178";


   public BiomeGenMutated(int p_i45381_1_, BiomeGenBase p_i45381_2_) {
      super(p_i45381_1_);
      this.field_150611_aD = p_i45381_2_;
      this.func_150557_a(p_i45381_2_.field_76790_z, true);
      this.field_76791_y = p_i45381_2_.field_76791_y + " M";
      this.field_76752_A = p_i45381_2_.field_76752_A;
      this.field_76753_B = p_i45381_2_.field_76753_B;
      this.field_76754_C = p_i45381_2_.field_76754_C;
      this.field_76748_D = p_i45381_2_.field_76748_D;
      this.field_76749_E = p_i45381_2_.field_76749_E;
      this.field_76750_F = p_i45381_2_.field_76750_F;
      this.field_76751_G = p_i45381_2_.field_76751_G;
      this.field_76759_H = p_i45381_2_.field_76759_H;
      this.field_76766_R = p_i45381_2_.field_76766_R;
      this.field_76765_S = p_i45381_2_.field_76765_S;
      this.field_76762_K = new ArrayList(p_i45381_2_.field_76762_K);
      this.field_76761_J = new ArrayList(p_i45381_2_.field_76761_J);
      this.field_82914_M = new ArrayList(p_i45381_2_.field_82914_M);
      this.field_76755_L = new ArrayList(p_i45381_2_.field_76755_L);
      this.field_76750_F = p_i45381_2_.field_76750_F;
      this.field_76751_G = p_i45381_2_.field_76751_G;
      this.field_76748_D = p_i45381_2_.field_76748_D + 0.1F;
      this.field_76749_E = p_i45381_2_.field_76749_E + 0.2F;
   }

   public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
      this.field_150611_aD.field_76760_I.func_150512_a(p_76728_1_, p_76728_2_, this, p_76728_3_, p_76728_4_);
   }

   public void func_150573_a(World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_) {
      this.field_150611_aD.func_150573_a(p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
   }

   public float func_76741_f() {
      return this.field_150611_aD.func_76741_f();
   }

   public WorldGenAbstractTree func_150567_a(Random p_150567_1_) {
      return this.field_150611_aD.func_150567_a(p_150567_1_);
   }

   public int func_150571_c(int p_150571_1_, int p_150571_2_, int p_150571_3_) {
      return this.field_150611_aD.func_150571_c(p_150571_1_, p_150571_2_, p_150571_2_);
   }

   public int func_150558_b(int p_150558_1_, int p_150558_2_, int p_150558_3_) {
      return this.field_150611_aD.func_150558_b(p_150558_1_, p_150558_2_, p_150558_2_);
   }

   public Class func_150562_l() {
      return this.field_150611_aD.func_150562_l();
   }

   public boolean func_150569_a(BiomeGenBase p_150569_1_) {
      return this.field_150611_aD.func_150569_a(p_150569_1_);
   }

   public BiomeGenBase.TempCategory func_150561_m() {
      return this.field_150611_aD.func_150561_m();
   }
}
