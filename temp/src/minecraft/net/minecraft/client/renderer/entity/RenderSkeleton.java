package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelSkeleton;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderSkeleton extends RenderBiped {

   private static final ResourceLocation field_110862_k = new ResourceLocation("textures/entity/skeleton/skeleton.png");
   private static final ResourceLocation field_110861_l = new ResourceLocation("textures/entity/skeleton/wither_skeleton.png");
   private static final String __OBFID = "CL_00001023";


   public RenderSkeleton() {
      super(new ModelSkeleton(), 0.5F);
   }

   protected void func_77041_b(EntitySkeleton p_77041_1_, float p_77041_2_) {
      if(p_77041_1_.func_82202_m() == 1) {
         GL11.glScalef(1.2F, 1.2F, 1.2F);
      }

   }

   protected void func_82422_c() {
      GL11.glTranslatef(0.09375F, 0.1875F, 0.0F);
   }

   protected ResourceLocation func_110775_a(EntitySkeleton p_110775_1_) {
      return p_110775_1_.func_82202_m() == 1?field_110861_l:field_110862_k;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(EntityLiving p_110775_1_) {
      return this.func_110775_a((EntitySkeleton)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
      this.func_77041_b((EntitySkeleton)p_77041_1_, p_77041_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntitySkeleton)p_110775_1_);
   }

}
