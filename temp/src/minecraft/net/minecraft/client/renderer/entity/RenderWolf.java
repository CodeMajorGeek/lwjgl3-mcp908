package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderWolf extends RenderLiving {

   private static final ResourceLocation field_110917_a = new ResourceLocation("textures/entity/wolf/wolf.png");
   private static final ResourceLocation field_110915_f = new ResourceLocation("textures/entity/wolf/wolf_tame.png");
   private static final ResourceLocation field_110916_g = new ResourceLocation("textures/entity/wolf/wolf_angry.png");
   private static final ResourceLocation field_110918_h = new ResourceLocation("textures/entity/wolf/wolf_collar.png");
   private static final String __OBFID = "CL_00001036";


   public RenderWolf(ModelBase p_i1269_1_, ModelBase p_i1269_2_, float p_i1269_3_) {
      super(p_i1269_1_, p_i1269_3_);
      this.func_77042_a(p_i1269_2_);
   }

   protected float func_77044_a(EntityWolf p_77044_1_, float p_77044_2_) {
      return p_77044_1_.func_70920_v();
   }

   protected int func_77032_a(EntityWolf p_77032_1_, int p_77032_2_, float p_77032_3_) {
      if(p_77032_2_ == 0 && p_77032_1_.func_70921_u()) {
         float var5 = p_77032_1_.func_70013_c(p_77032_3_) * p_77032_1_.func_70915_j(p_77032_3_);
         this.func_110776_a(field_110917_a);
         GL11.glColor3f(var5, var5, var5);
         return 1;
      } else if(p_77032_2_ == 1 && p_77032_1_.func_70909_n()) {
         this.func_110776_a(field_110918_h);
         int var4 = p_77032_1_.func_82186_bH();
         GL11.glColor3f(EntitySheep.field_70898_d[var4][0], EntitySheep.field_70898_d[var4][1], EntitySheep.field_70898_d[var4][2]);
         return 1;
      } else {
         return -1;
      }
   }

   protected ResourceLocation func_110775_a(EntityWolf p_110775_1_) {
      return p_110775_1_.func_70909_n()?field_110915_f:(p_110775_1_.func_70919_bu()?field_110916_g:field_110917_a);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_77032_a(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
      return this.func_77032_a((EntityWolf)p_77032_1_, p_77032_2_, p_77032_3_);
   }

   // $FF: synthetic method
   protected float func_77044_a(EntityLivingBase p_77044_1_, float p_77044_2_) {
      return this.func_77044_a((EntityWolf)p_77044_1_, p_77044_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntityWolf)p_110775_1_);
   }

}
