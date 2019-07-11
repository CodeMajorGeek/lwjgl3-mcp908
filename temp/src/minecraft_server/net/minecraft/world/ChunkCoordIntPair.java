package net.minecraft.world;

import net.minecraft.world.ChunkPosition;

public class ChunkCoordIntPair {

   public final int field_77276_a;
   public final int field_77275_b;
   private static final String __OBFID = "CL_00000133";


   public ChunkCoordIntPair(int p_i1947_1_, int p_i1947_2_) {
      this.field_77276_a = p_i1947_1_;
      this.field_77275_b = p_i1947_2_;
   }

   public static long func_77272_a(int p_77272_0_, int p_77272_1_) {
      return (long)p_77272_0_ & 4294967295L | ((long)p_77272_1_ & 4294967295L) << 32;
   }

   public int hashCode() {
      int var1 = 1664525 * this.field_77276_a + 1013904223;
      int var2 = 1664525 * (this.field_77275_b ^ -559038737) + 1013904223;
      return var1 ^ var2;
   }

   public boolean equals(Object p_equals_1_) {
      if(this == p_equals_1_) {
         return true;
      } else if(!(p_equals_1_ instanceof ChunkCoordIntPair)) {
         return false;
      } else {
         ChunkCoordIntPair var2 = (ChunkCoordIntPair)p_equals_1_;
         return this.field_77276_a == var2.field_77276_a && this.field_77275_b == var2.field_77275_b;
      }
   }

   public int func_77273_a() {
      return (this.field_77276_a << 4) + 8;
   }

   public int func_77274_b() {
      return (this.field_77275_b << 4) + 8;
   }

   public ChunkPosition func_151349_a(int p_151349_1_) {
      return new ChunkPosition(this.func_77273_a(), p_151349_1_, this.func_77274_b());
   }

   public String toString() {
      return "[" + this.field_77276_a + ", " + this.field_77275_b + "]";
   }
}
