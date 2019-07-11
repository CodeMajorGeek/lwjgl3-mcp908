package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBat;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderBat extends RenderLiving {

   private static final ResourceLocation field_110835_a = new ResourceLocation("textures/entity/bat.png");
   private int field_82446_a;
   private static final String __OBFID = "CL_00000979";


   public RenderBat() {
      super(new ModelBat(), 0.25F);
      this.field_82446_a = ((ModelBat)this.field_77045_g).func_82889_a();
   }

   public void func_76986_a(EntityBat p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      int var10 = ((ModelBat)this.field_77045_g).func_82889_a();
      if(var10 != this.field_82446_a) {
         this.field_82446_a = var10;
         this.field_77045_g = new ModelBat();
      }

      super.func_76986_a((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   protected ResourceLocation func_110775_a(EntityBat p_110775_1_) {
      return field_110835_a;
   }

   protected void func_77041_b(EntityBat p_77041_1_, float p_77041_2_) {
      GL11.glScalef(0.35F, 0.35F, 0.35F);
   }

   protected void func_77039_a(EntityBat p_77039_1_, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
      super.func_77039_a(p_77039_1_, p_77039_2_, p_77039_4_, p_77039_6_);
   }

   protected void func_77043_a(EntityBat p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
      if(!p_77043_1_.func_82235_h()) {
         GL11.glTranslatef(0.0F, MathHelper.func_76134_b(p_77043_2_ * 0.3F) * 0.1F, 0.0F);
      } else {
         GL11.glTranslatef(0.0F, -0.1F, 0.0F);
      }

      super.func_77043_a(p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityBat)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
      this.func_77041_b((EntityBat)p_77041_1_, p_77041_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77043_a(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
      this.func_77043_a((EntityBat)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77039_a(EntityLivingBase p_77039_1_, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
      this.func_77039_a((EntityBat)p_77039_1_, p_77039_2_, p_77039_4_, p_77039_6_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityBat)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntityBat)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityBat)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

}
