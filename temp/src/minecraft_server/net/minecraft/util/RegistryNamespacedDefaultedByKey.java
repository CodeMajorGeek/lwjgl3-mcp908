package net.minecraft.util;

import net.minecraft.util.RegistryNamespaced;

public class RegistryNamespacedDefaultedByKey extends RegistryNamespaced {

   private final String field_148760_d;
   private Object field_148761_e;
   private static final String __OBFID = "CL_00001196";


   public RegistryNamespacedDefaultedByKey(String p_i45127_1_) {
      this.field_148760_d = p_i45127_1_;
   }

   public void func_148756_a(int p_148756_1_, String p_148756_2_, Object p_148756_3_) {
      if(this.field_148760_d.equals(p_148756_2_)) {
         this.field_148761_e = p_148756_3_;
      }

      super.func_148756_a(p_148756_1_, p_148756_2_, p_148756_3_);
   }

   public Object func_82594_a(String p_82594_1_) {
      Object var2 = super.func_82594_a(p_82594_1_);
      return var2 == null?this.field_148761_e:var2;
   }

   public Object func_148754_a(int p_148754_1_) {
      Object var2 = super.func_148754_a(p_148754_1_);
      return var2 == null?this.field_148761_e:var2;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object func_82594_a(Object p_82594_1_) {
      return this.func_82594_a((String)p_82594_1_);
   }
}
