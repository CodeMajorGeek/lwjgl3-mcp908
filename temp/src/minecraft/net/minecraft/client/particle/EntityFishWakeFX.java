package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

public class EntityFishWakeFX extends EntityFX {

   private static final String __OBFID = "CL_00000933";


   public EntityFishWakeFX(World p_i45073_1_, double p_i45073_2_, double p_i45073_4_, double p_i45073_6_, double p_i45073_8_, double p_i45073_10_, double p_i45073_12_) {
      super(p_i45073_1_, p_i45073_2_, p_i45073_4_, p_i45073_6_, 0.0D, 0.0D, 0.0D);
      this.field_70159_w *= 0.30000001192092896D;
      this.field_70181_x = (double)((float)Math.random() * 0.2F + 0.1F);
      this.field_70179_y *= 0.30000001192092896D;
      this.field_70552_h = 1.0F;
      this.field_70553_i = 1.0F;
      this.field_70551_j = 1.0F;
      this.func_70536_a(19);
      this.func_70105_a(0.01F, 0.01F);
      this.field_70547_e = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
      this.field_70545_g = 0.0F;
      this.field_70159_w = p_i45073_8_;
      this.field_70181_x = p_i45073_10_;
      this.field_70179_y = p_i45073_12_;
   }

   public void func_70071_h_() {
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      this.field_70181_x -= (double)this.field_70545_g;
      this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
      this.field_70159_w *= 0.9800000190734863D;
      this.field_70181_x *= 0.9800000190734863D;
      this.field_70179_y *= 0.9800000190734863D;
      int var1 = 60 - this.field_70547_e;
      float var2 = (float)var1 * 0.001F;
      this.func_70105_a(var2, var2);
      this.func_70536_a(19 + var1 % 4);
      if(this.field_70547_e-- <= 0) {
         this.func_70106_y();
      }

   }
}
