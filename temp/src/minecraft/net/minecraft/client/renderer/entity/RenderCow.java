package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;

public class RenderCow extends RenderLiving {

   private static final ResourceLocation field_110833_a = new ResourceLocation("textures/entity/cow/cow.png");
   private static final String __OBFID = "CL_00000984";


   public RenderCow(ModelBase p_i1253_1_, float p_i1253_2_) {
      super(p_i1253_1_, p_i1253_2_);
   }

   protected ResourceLocation func_110775_a(EntityCow p_110775_1_) {
      return field_110833_a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntityCow)p_110775_1_);
   }

}
