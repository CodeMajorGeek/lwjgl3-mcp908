package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Items;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderFireball extends Render {

   private float field_77002_a;
   private static final String __OBFID = "CL_00000995";


   public RenderFireball(float p_i1254_1_) {
      this.field_77002_a = p_i1254_1_;
   }

   public void func_76986_a(EntityFireball p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      GL11.glPushMatrix();
      this.func_110777_b(p_76986_1_);
      GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
      GL11.glEnable('\u803a');
      float var10 = this.field_77002_a;
      GL11.glScalef(var10 / 1.0F, var10 / 1.0F, var10 / 1.0F);
      IIcon var11 = Items.field_151059_bz.func_77617_a(0);
      Tessellator var12 = Tessellator.field_78398_a;
      float var13 = var11.func_94209_e();
      float var14 = var11.func_94212_f();
      float var15 = var11.func_94206_g();
      float var16 = var11.func_94210_h();
      float var17 = 1.0F;
      float var18 = 0.5F;
      float var19 = 0.25F;
      GL11.glRotatef(180.0F - this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
      var12.func_78382_b();
      var12.func_78375_b(0.0F, 1.0F, 0.0F);
      var12.func_78374_a((double)(0.0F - var18), (double)(0.0F - var19), 0.0D, (double)var13, (double)var16);
      var12.func_78374_a((double)(var17 - var18), (double)(0.0F - var19), 0.0D, (double)var14, (double)var16);
      var12.func_78374_a((double)(var17 - var18), (double)(1.0F - var19), 0.0D, (double)var14, (double)var15);
      var12.func_78374_a((double)(0.0F - var18), (double)(1.0F - var19), 0.0D, (double)var13, (double)var15);
      var12.func_78381_a();
      GL11.glDisable('\u803a');
      GL11.glPopMatrix();
   }

   protected ResourceLocation func_110775_a(EntityFireball p_110775_1_) {
      return TextureMap.field_110576_c;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntityFireball)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityFireball)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
