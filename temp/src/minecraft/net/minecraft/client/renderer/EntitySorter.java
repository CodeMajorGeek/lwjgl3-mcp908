package net.minecraft.client.renderer;

import java.util.Comparator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;

public class EntitySorter implements Comparator {

   private double field_78949_a;
   private double field_78947_b;
   private double field_78948_c;
   private static final String __OBFID = "CL_00000944";


   public EntitySorter(Entity p_i1242_1_) {
      this.field_78949_a = -p_i1242_1_.field_70165_t;
      this.field_78947_b = -p_i1242_1_.field_70163_u;
      this.field_78948_c = -p_i1242_1_.field_70161_v;
   }

   public int compare(WorldRenderer p_compare_1_, WorldRenderer p_compare_2_) {
      double var3 = (double)p_compare_1_.field_78925_n + this.field_78949_a;
      double var5 = (double)p_compare_1_.field_78926_o + this.field_78947_b;
      double var7 = (double)p_compare_1_.field_78940_p + this.field_78948_c;
      double var9 = (double)p_compare_2_.field_78925_n + this.field_78949_a;
      double var11 = (double)p_compare_2_.field_78926_o + this.field_78947_b;
      double var13 = (double)p_compare_2_.field_78940_p + this.field_78948_c;
      return (int)((var3 * var3 + var5 * var5 + var7 * var7 - (var9 * var9 + var11 * var11 + var13 * var13)) * 1024.0D);
   }

   // $FF: synthetic method
   public int compare(Object p_compare_1_, Object p_compare_2_) {
      return this.compare((WorldRenderer)p_compare_1_, (WorldRenderer)p_compare_2_);
   }
}
