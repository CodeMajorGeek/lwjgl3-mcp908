package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelVillager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderVillager extends RenderLiving {

   private static final ResourceLocation field_110903_f = new ResourceLocation("textures/entity/villager/villager.png");
   private static final ResourceLocation field_110904_g = new ResourceLocation("textures/entity/villager/farmer.png");
   private static final ResourceLocation field_110908_h = new ResourceLocation("textures/entity/villager/librarian.png");
   private static final ResourceLocation field_110907_k = new ResourceLocation("textures/entity/villager/priest.png");
   private static final ResourceLocation field_110905_l = new ResourceLocation("textures/entity/villager/smith.png");
   private static final ResourceLocation field_110906_m = new ResourceLocation("textures/entity/villager/butcher.png");
   protected ModelVillager field_77056_a;
   private static final String __OBFID = "CL_00001032";


   public RenderVillager() {
      super(new ModelVillager(0.0F), 0.5F);
      this.field_77056_a = (ModelVillager)this.field_77045_g;
   }

   protected int func_77032_a(EntityVillager p_77032_1_, int p_77032_2_, float p_77032_3_) {
      return -1;
   }

   public void func_76986_a(EntityVillager p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      super.func_76986_a((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   protected ResourceLocation func_110775_a(EntityVillager p_110775_1_) {
      switch(p_110775_1_.func_70946_n()) {
      case 0:
         return field_110904_g;
      case 1:
         return field_110908_h;
      case 2:
         return field_110907_k;
      case 3:
         return field_110905_l;
      case 4:
         return field_110906_m;
      default:
         return field_110903_f;
      }
   }

   protected void func_77029_c(EntityVillager p_77029_1_, float p_77029_2_) {
      super.func_77029_c(p_77029_1_, p_77029_2_);
   }

   protected void func_77041_b(EntityVillager p_77041_1_, float p_77041_2_) {
      float var3 = 0.9375F;
      if(p_77041_1_.func_70874_b() < 0) {
         var3 = (float)((double)var3 * 0.5D);
         this.field_76989_e = 0.25F;
      } else {
         this.field_76989_e = 0.5F;
      }

      GL11.glScalef(var3, var3, var3);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityVillager)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   // $FF: synthetic method
   protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
      this.func_77041_b((EntityVillager)p_77041_1_, p_77041_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_77032_a(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
      return this.func_77032_a((EntityVillager)p_77032_1_, p_77032_2_, p_77032_3_);
   }

   // $FF: synthetic method
   protected void func_77029_c(EntityLivingBase p_77029_1_, float p_77029_2_) {
      this.func_77029_c((EntityVillager)p_77029_1_, p_77029_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityVillager)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntityVillager)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityVillager)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

}
