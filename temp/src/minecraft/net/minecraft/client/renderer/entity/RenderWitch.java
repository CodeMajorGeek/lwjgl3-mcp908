package net.minecraft.client.renderer.entity;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelWitch;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderWitch extends RenderLiving {

   private static final ResourceLocation field_110910_a = new ResourceLocation("textures/entity/witch.png");
   private final ModelWitch field_82414_a;
   private static final String __OBFID = "CL_00001033";


   public RenderWitch() {
      super(new ModelWitch(0.0F), 0.5F);
      this.field_82414_a = (ModelWitch)this.field_77045_g;
   }

   public void func_76986_a(EntityWitch p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      ItemStack var10 = p_76986_1_.func_70694_bm();
      this.field_82414_a.field_82900_g = var10 != null;
      super.func_76986_a((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   protected ResourceLocation func_110775_a(EntityWitch p_110775_1_) {
      return field_110910_a;
   }

   protected void func_77029_c(EntityWitch p_77029_1_, float p_77029_2_) {
      GL11.glColor3f(1.0F, 1.0F, 1.0F);
      super.func_77029_c(p_77029_1_, p_77029_2_);
      ItemStack var3 = p_77029_1_.func_70694_bm();
      if(var3 != null) {
         GL11.glPushMatrix();
         float var4;
         if(this.field_77045_g.field_78091_s) {
            var4 = 0.5F;
            GL11.glTranslatef(0.0F, 0.625F, 0.0F);
            GL11.glRotatef(-20.0F, -1.0F, 0.0F, 0.0F);
            GL11.glScalef(var4, var4, var4);
         }

         this.field_82414_a.field_82898_f.func_78794_c(0.0625F);
         GL11.glTranslatef(-0.0625F, 0.53125F, 0.21875F);
         if(var3.func_77973_b() instanceof ItemBlock && RenderBlocks.func_147739_a(Block.func_149634_a(var3.func_77973_b()).func_149645_b())) {
            var4 = 0.5F;
            GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
            var4 *= 0.75F;
            GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(var4, -var4, var4);
         } else if(var3.func_77973_b() == Items.field_151031_f) {
            var4 = 0.625F;
            GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
            GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(var4, -var4, var4);
            GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         } else if(var3.func_77973_b().func_77662_d()) {
            var4 = 0.625F;
            if(var3.func_77973_b().func_77629_n_()) {
               GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
               GL11.glTranslatef(0.0F, -0.125F, 0.0F);
            }

            this.func_82410_b();
            GL11.glScalef(var4, -var4, var4);
            GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         } else {
            var4 = 0.375F;
            GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
            GL11.glScalef(var4, var4, var4);
            GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
         }

         GL11.glRotatef(-15.0F, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(40.0F, 0.0F, 0.0F, 1.0F);
         this.field_76990_c.field_78721_f.func_78443_a(p_77029_1_, var3, 0);
         if(var3.func_77973_b().func_77623_v()) {
            this.field_76990_c.field_78721_f.func_78443_a(p_77029_1_, var3, 1);
         }

         GL11.glPopMatrix();
      }

   }

   protected void func_82410_b() {
      GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
   }

   protected void func_77041_b(EntityWitch p_77041_1_, float p_77041_2_) {
      float var3 = 0.9375F;
      GL11.glScalef(var3, var3, var3);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityWitch)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   // $FF: synthetic method
   protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
      this.func_77041_b((EntityWitch)p_77041_1_, p_77041_2_);
   }

   // $FF: synthetic method
   protected void func_77029_c(EntityLivingBase p_77029_1_, float p_77029_2_) {
      this.func_77029_c((EntityWitch)p_77029_1_, p_77029_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityWitch)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntityWitch)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityWitch)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

}
