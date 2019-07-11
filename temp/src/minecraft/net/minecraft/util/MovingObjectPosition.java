package net.minecraft.util;

import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;

public class MovingObjectPosition {

   public MovingObjectPosition.MovingObjectType field_72313_a;
   public int field_72311_b;
   public int field_72312_c;
   public int field_72309_d;
   public int field_72310_e;
   public Vec3 field_72307_f;
   public Entity field_72308_g;
   private static final String __OBFID = "CL_00000610";


   public MovingObjectPosition(int p_i2303_1_, int p_i2303_2_, int p_i2303_3_, int p_i2303_4_, Vec3 p_i2303_5_) {
      this(p_i2303_1_, p_i2303_2_, p_i2303_3_, p_i2303_4_, p_i2303_5_, true);
   }

   public MovingObjectPosition(int p_i45481_1_, int p_i45481_2_, int p_i45481_3_, int p_i45481_4_, Vec3 p_i45481_5_, boolean p_i45481_6_) {
      this.field_72313_a = p_i45481_6_?MovingObjectPosition.MovingObjectType.BLOCK:MovingObjectPosition.MovingObjectType.MISS;
      this.field_72311_b = p_i45481_1_;
      this.field_72312_c = p_i45481_2_;
      this.field_72309_d = p_i45481_3_;
      this.field_72310_e = p_i45481_4_;
      this.field_72307_f = Vec3.func_72443_a(p_i45481_5_.field_72450_a, p_i45481_5_.field_72448_b, p_i45481_5_.field_72449_c);
   }

   public MovingObjectPosition(Entity p_i2304_1_) {
      this(p_i2304_1_, Vec3.func_72443_a(p_i2304_1_.field_70165_t, p_i2304_1_.field_70163_u, p_i2304_1_.field_70161_v));
   }

   public MovingObjectPosition(Entity p_i45482_1_, Vec3 p_i45482_2_) {
      this.field_72313_a = MovingObjectPosition.MovingObjectType.ENTITY;
      this.field_72308_g = p_i45482_1_;
      this.field_72307_f = p_i45482_2_;
   }

   public String toString() {
      return "HitResult{type=" + this.field_72313_a + ", x=" + this.field_72311_b + ", y=" + this.field_72312_c + ", z=" + this.field_72309_d + ", f=" + this.field_72310_e + ", pos=" + this.field_72307_f + ", entity=" + this.field_72308_g + '}';
   }

   public static enum MovingObjectType {

      MISS("MISS", 0),
      BLOCK("BLOCK", 1),
      ENTITY("ENTITY", 2);
      // $FF: synthetic field
      private static final MovingObjectPosition.MovingObjectType[] $VALUES = new MovingObjectPosition.MovingObjectType[]{MISS, BLOCK, ENTITY};
      private static final String __OBFID = "CL_00000611";


      private MovingObjectType(String p_i2302_1_, int p_i2302_2_) {}

   }
}
