package net.minecraft.world.gen;

import net.minecraft.block.Block;

public class FlatLayerInfo {

   private Block field_151537_a;
   private int field_82664_a;
   private int field_82663_c;
   private int field_82661_d;
   private static final String __OBFID = "CL_00000441";


   public FlatLayerInfo(int p_i45467_1_, Block p_i45467_2_) {
      this.field_82664_a = 1;
      this.field_82664_a = p_i45467_1_;
      this.field_151537_a = p_i45467_2_;
   }

   public FlatLayerInfo(int p_i45468_1_, Block p_i45468_2_, int p_i45468_3_) {
      this(p_i45468_1_, p_i45468_2_);
      this.field_82663_c = p_i45468_3_;
   }

   public int func_82657_a() {
      return this.field_82664_a;
   }

   public Block func_151536_b() {
      return this.field_151537_a;
   }

   public int func_82658_c() {
      return this.field_82663_c;
   }

   public int func_82656_d() {
      return this.field_82661_d;
   }

   public void func_82660_d(int p_82660_1_) {
      this.field_82661_d = p_82660_1_;
   }

   public String toString() {
      String var1 = Integer.toString(Block.func_149682_b(this.field_151537_a));
      if(this.field_82664_a > 1) {
         var1 = this.field_82664_a + "x" + var1;
      }

      if(this.field_82663_c > 0) {
         var1 = var1 + ":" + this.field_82663_c;
      }

      return var1;
   }
}
