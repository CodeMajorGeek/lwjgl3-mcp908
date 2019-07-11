package net.minecraft.client.renderer.entity;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelEnderman;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderEnderman extends RenderLiving {

   private static final ResourceLocation field_110840_a = new ResourceLocation("textures/entity/enderman/enderman_eyes.png");
   private static final ResourceLocation field_110839_f = new ResourceLocation("textures/entity/enderman/enderman.png");
   private ModelEnderman field_77078_a;
   private Random field_77077_b = new Random();
   private static final String __OBFID = "CL_00000989";


   public RenderEnderman() {
      super(new ModelEnderman(), 0.5F);
      this.field_77078_a = (ModelEnderman)super.field_77045_g;
      this.func_77042_a(this.field_77078_a);
   }

   public void func_76986_a(EntityEnderman p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.field_77078_a.field_78126_a = p_76986_1_.func_146080_bZ().func_149688_o() != Material.field_151579_a;
      this.field_77078_a.field_78125_b = p_76986_1_.func_70823_r();
      if(p_76986_1_.func_70823_r()) {
         double var10 = 0.02D;
         p_76986_2_ += this.field_77077_b.nextGaussian() * var10;
         p_76986_6_ += this.field_77077_b.nextGaussian() * var10;
      }

      super.func_76986_a((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   protected ResourceLocation func_110775_a(EntityEnderman p_110775_1_) {
      return field_110839_f;
   }

   protected void func_77029_c(EntityEnderman p_77029_1_, float p_77029_2_) {
      super.func_77029_c(p_77029_1_, p_77029_2_);
      if(p_77029_1_.func_146080_bZ().func_149688_o() != Material.field_151579_a) {
         GL11.glEnable('\u803a');
         GL11.glPushMatrix();
         float var3 = 0.5F;
         GL11.glTranslatef(0.0F, 0.6875F, -0.75F);
         var3 *= 1.0F;
         GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         GL11.glScalef(-var3, -var3, var3);
         int var4 = p_77029_1_.func_70070_b(p_77029_2_);
         int var5 = var4 % 65536;
         int var6 = var4 / 65536;
         OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)var5 / 1.0F, (float)var6 / 1.0F);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         this.func_110776_a(TextureMap.field_110575_b);
         this.field_147909_c.func_147800_a(p_77029_1_.func_146080_bZ(), p_77029_1_.func_70824_q(), 1.0F);
         GL11.glPopMatrix();
         GL11.glDisable('\u803a');
      }

   }

   protected int func_77032_a(EntityEnderman p_77032_1_, int p_77032_2_, float p_77032_3_) {
      if(p_77032_2_ != 0) {
         return -1;
      } else {
         this.func_110776_a(field_110840_a);
         float var4 = 1.0F;
         GL11.glEnable(3042);
         GL11.glDisable(3008);
         GL11.glBlendFunc(1, 1);
         GL11.glDisable(2896);
         if(p_77032_1_.func_82150_aj()) {
            GL11.glDepthMask(false);
         } else {
            GL11.glDepthMask(true);
         }

         char var5 = '\uf0f0';
         int var6 = var5 % 65536;
         int var7 = var5 / 65536;
         OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)var6 / 1.0F, (float)var7 / 1.0F);
         GL11.glEnable(2896);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, var4);
         return 1;
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityEnderman)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_77032_a(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
      return this.func_77032_a((EntityEnderman)p_77032_1_, p_77032_2_, p_77032_3_);
   }

   // $FF: synthetic method
   protected void func_77029_c(EntityLivingBase p_77029_1_, float p_77029_2_) {
      this.func_77029_c((EntityEnderman)p_77029_1_, p_77029_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityEnderman)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntityEnderman)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityEnderman)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

}
