package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelQuadruped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderMooshroom extends RenderLiving {

   private static final ResourceLocation field_110880_a = new ResourceLocation("textures/entity/cow/mooshroom.png");
   private static final String __OBFID = "CL_00001016";


   public RenderMooshroom(ModelBase p_i1263_1_, float p_i1263_2_) {
      super(p_i1263_1_, p_i1263_2_);
   }

   public void func_76986_a(EntityMooshroom p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      super.func_76986_a((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   protected ResourceLocation func_110775_a(EntityMooshroom p_110775_1_) {
      return field_110880_a;
   }

   protected void func_77029_c(EntityMooshroom p_77029_1_, float p_77029_2_) {
      super.func_77029_c(p_77029_1_, p_77029_2_);
      if(!p_77029_1_.func_70631_g_()) {
         this.func_110776_a(TextureMap.field_110575_b);
         GL11.glEnable(2884);
         GL11.glPushMatrix();
         GL11.glScalef(1.0F, -1.0F, 1.0F);
         GL11.glTranslatef(0.2F, 0.4F, 0.5F);
         GL11.glRotatef(42.0F, 0.0F, 1.0F, 0.0F);
         this.field_147909_c.func_147800_a(Blocks.field_150337_Q, 0, 1.0F);
         GL11.glTranslatef(0.1F, 0.0F, -0.6F);
         GL11.glRotatef(42.0F, 0.0F, 1.0F, 0.0F);
         this.field_147909_c.func_147800_a(Blocks.field_150337_Q, 0, 1.0F);
         GL11.glPopMatrix();
         GL11.glPushMatrix();
         ((ModelQuadruped)this.field_77045_g).field_78150_a.func_78794_c(0.0625F);
         GL11.glScalef(1.0F, -1.0F, 1.0F);
         GL11.glTranslatef(0.0F, 0.75F, -0.2F);
         GL11.glRotatef(12.0F, 0.0F, 1.0F, 0.0F);
         this.field_147909_c.func_147800_a(Blocks.field_150337_Q, 0, 1.0F);
         GL11.glPopMatrix();
         GL11.glDisable(2884);
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityMooshroom)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   // $FF: synthetic method
   protected void func_77029_c(EntityLivingBase p_77029_1_, float p_77029_2_) {
      this.func_77029_c((EntityMooshroom)p_77029_1_, p_77029_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityMooshroom)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntityMooshroom)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityMooshroom)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

}
