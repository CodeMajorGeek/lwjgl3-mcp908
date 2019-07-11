package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderSheep extends RenderLiving {

   private static final ResourceLocation field_110885_a = new ResourceLocation("textures/entity/sheep/sheep_fur.png");
   private static final ResourceLocation field_110884_f = new ResourceLocation("textures/entity/sheep/sheep.png");
   private static final String __OBFID = "CL_00001021";


   public RenderSheep(ModelBase p_i1266_1_, ModelBase p_i1266_2_, float p_i1266_3_) {
      super(p_i1266_1_, p_i1266_3_);
      this.func_77042_a(p_i1266_2_);
   }

   protected int func_77032_a(EntitySheep p_77032_1_, int p_77032_2_, float p_77032_3_) {
      if(p_77032_2_ == 0 && !p_77032_1_.func_70892_o()) {
         this.func_110776_a(field_110885_a);
         if(p_77032_1_.func_94056_bM() && "jeb_".equals(p_77032_1_.func_94057_bL())) {
            boolean var9 = true;
            int var5 = p_77032_1_.field_70173_aa / 25 + p_77032_1_.func_145782_y();
            int var6 = var5 % EntitySheep.field_70898_d.length;
            int var7 = (var5 + 1) % EntitySheep.field_70898_d.length;
            float var8 = ((float)(p_77032_1_.field_70173_aa % 25) + p_77032_3_) / 25.0F;
            GL11.glColor3f(EntitySheep.field_70898_d[var6][0] * (1.0F - var8) + EntitySheep.field_70898_d[var7][0] * var8, EntitySheep.field_70898_d[var6][1] * (1.0F - var8) + EntitySheep.field_70898_d[var7][1] * var8, EntitySheep.field_70898_d[var6][2] * (1.0F - var8) + EntitySheep.field_70898_d[var7][2] * var8);
         } else {
            int var4 = p_77032_1_.func_70896_n();
            GL11.glColor3f(EntitySheep.field_70898_d[var4][0], EntitySheep.field_70898_d[var4][1], EntitySheep.field_70898_d[var4][2]);
         }

         return 1;
      } else {
         return -1;
      }
   }

   protected ResourceLocation func_110775_a(EntitySheep p_110775_1_) {
      return field_110884_f;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_77032_a(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
      return this.func_77032_a((EntitySheep)p_77032_1_, p_77032_2_, p_77032_3_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntitySheep)p_110775_1_);
   }

}
