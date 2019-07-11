package net.minecraft.client.renderer.entity;

import java.util.Random;
import java.util.concurrent.Callable;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemCloth;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderItem extends Render {

   private static final ResourceLocation field_110798_h = new ResourceLocation("textures/misc/enchanted_item_glint.png");
   private RenderBlocks field_147913_i = new RenderBlocks();
   private Random field_77025_h = new Random();
   public boolean field_77024_a = true;
   public float field_77023_b;
   public static boolean field_82407_g;
   private static final String __OBFID = "CL_00001003";


   public RenderItem() {
      this.field_76989_e = 0.15F;
      this.field_76987_f = 0.75F;
   }

   public void func_76986_a(EntityItem p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      ItemStack var10 = p_76986_1_.func_92059_d();
      if(var10.func_77973_b() != null) {
         this.func_110777_b(p_76986_1_);
         TextureUtil.func_152777_a(false, false, 1.0F);
         this.field_77025_h.setSeed(187L);
         GL11.glPushMatrix();
         float var11 = MathHelper.func_76126_a(((float)p_76986_1_.field_70292_b + p_76986_9_) / 10.0F + p_76986_1_.field_70290_d) * 0.1F + 0.1F;
         float var12 = (((float)p_76986_1_.field_70292_b + p_76986_9_) / 20.0F + p_76986_1_.field_70290_d) * 57.295776F;
         byte var13 = 1;
         if(p_76986_1_.func_92059_d().field_77994_a > 1) {
            var13 = 2;
         }

         if(p_76986_1_.func_92059_d().field_77994_a > 5) {
            var13 = 3;
         }

         if(p_76986_1_.func_92059_d().field_77994_a > 20) {
            var13 = 4;
         }

         if(p_76986_1_.func_92059_d().field_77994_a > 40) {
            var13 = 5;
         }

         GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_ + var11, (float)p_76986_6_);
         GL11.glEnable('\u803a');
         float var18;
         float var19;
         int var25;
         if(var10.func_94608_d() == 0 && var10.func_77973_b() instanceof ItemBlock && RenderBlocks.func_147739_a(Block.func_149634_a(var10.func_77973_b()).func_149645_b())) {
            Block var22 = Block.func_149634_a(var10.func_77973_b());
            GL11.glRotatef(var12, 0.0F, 1.0F, 0.0F);
            if(field_82407_g) {
               GL11.glScalef(1.25F, 1.25F, 1.25F);
               GL11.glTranslatef(0.0F, 0.05F, 0.0F);
               GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
            }

            float var24 = 0.25F;
            var25 = var22.func_149645_b();
            if(var25 == 1 || var25 == 19 || var25 == 12 || var25 == 2) {
               var24 = 0.5F;
            }

            if(var22.func_149701_w() > 0) {
               GL11.glAlphaFunc(516, 0.1F);
               GL11.glEnable(3042);
               OpenGlHelper.func_148821_a(770, 771, 1, 0);
            }

            GL11.glScalef(var24, var24, var24);

            for(int var26 = 0; var26 < var13; ++var26) {
               GL11.glPushMatrix();
               if(var26 > 0) {
                  var18 = (this.field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.2F / var24;
                  var19 = (this.field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.2F / var24;
                  float var20 = (this.field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.2F / var24;
                  GL11.glTranslatef(var18, var19, var20);
               }

               this.field_147913_i.func_147800_a(var22, var10.func_77960_j(), 1.0F);
               GL11.glPopMatrix();
            }

            if(var22.func_149701_w() > 0) {
               GL11.glDisable(3042);
            }
         } else {
            float var17;
            if(var10.func_94608_d() == 1 && var10.func_77973_b().func_77623_v()) {
               if(field_82407_g) {
                  GL11.glScalef(0.5128205F, 0.5128205F, 0.5128205F);
                  GL11.glTranslatef(0.0F, -0.05F, 0.0F);
               } else {
                  GL11.glScalef(0.5F, 0.5F, 0.5F);
               }

               for(int var21 = 0; var21 <= 1; ++var21) {
                  this.field_77025_h.setSeed(187L);
                  IIcon var23 = var10.func_77973_b().func_77618_c(var10.func_77960_j(), var21);
                  if(this.field_77024_a) {
                     var25 = var10.func_77973_b().func_82790_a(var10, var21);
                     var17 = (float)(var25 >> 16 & 255) / 255.0F;
                     var18 = (float)(var25 >> 8 & 255) / 255.0F;
                     var19 = (float)(var25 & 255) / 255.0F;
                     GL11.glColor4f(var17, var18, var19, 1.0F);
                     this.func_77020_a(p_76986_1_, var23, var13, p_76986_9_, var17, var18, var19);
                  } else {
                     this.func_77020_a(p_76986_1_, var23, var13, p_76986_9_, 1.0F, 1.0F, 1.0F);
                  }
               }
            } else {
               if(var10 != null && var10.func_77973_b() instanceof ItemCloth) {
                  GL11.glAlphaFunc(516, 0.1F);
                  GL11.glEnable(3042);
                  OpenGlHelper.func_148821_a(770, 771, 1, 0);
               }

               if(field_82407_g) {
                  GL11.glScalef(0.5128205F, 0.5128205F, 0.5128205F);
                  GL11.glTranslatef(0.0F, -0.05F, 0.0F);
               } else {
                  GL11.glScalef(0.5F, 0.5F, 0.5F);
               }

               IIcon var14 = var10.func_77954_c();
               if(this.field_77024_a) {
                  int var15 = var10.func_77973_b().func_82790_a(var10, 0);
                  float var16 = (float)(var15 >> 16 & 255) / 255.0F;
                  var17 = (float)(var15 >> 8 & 255) / 255.0F;
                  var18 = (float)(var15 & 255) / 255.0F;
                  this.func_77020_a(p_76986_1_, var14, var13, p_76986_9_, var16, var17, var18);
               } else {
                  this.func_77020_a(p_76986_1_, var14, var13, p_76986_9_, 1.0F, 1.0F, 1.0F);
               }

               if(var10 != null && var10.func_77973_b() instanceof ItemCloth) {
                  GL11.glDisable(3042);
               }
            }
         }

         GL11.glDisable('\u803a');
         GL11.glPopMatrix();
         this.func_110777_b(p_76986_1_);
         TextureUtil.func_147945_b();
      }
   }

   protected ResourceLocation func_110775_a(EntityItem p_110775_1_) {
      return this.field_76990_c.field_78724_e.func_130087_a(p_110775_1_.func_92059_d().func_94608_d());
   }

   private void func_77020_a(EntityItem p_77020_1_, IIcon p_77020_2_, int p_77020_3_, float p_77020_4_, float p_77020_5_, float p_77020_6_, float p_77020_7_) {
      Tessellator var8 = Tessellator.field_78398_a;
      if(p_77020_2_ == null) {
         TextureManager var9 = Minecraft.func_71410_x().func_110434_K();
         ResourceLocation var10 = var9.func_130087_a(p_77020_1_.func_92059_d().func_94608_d());
         p_77020_2_ = ((TextureMap)var9.func_110581_b(var10)).func_110572_b("missingno");
      }

      float var25 = ((IIcon)p_77020_2_).func_94209_e();
      float var26 = ((IIcon)p_77020_2_).func_94212_f();
      float var11 = ((IIcon)p_77020_2_).func_94206_g();
      float var12 = ((IIcon)p_77020_2_).func_94210_h();
      float var13 = 1.0F;
      float var14 = 0.5F;
      float var15 = 0.25F;
      float var17;
      if(this.field_76990_c.field_78733_k.field_74347_j) {
         GL11.glPushMatrix();
         if(field_82407_g) {
            GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
         } else {
            GL11.glRotatef((((float)p_77020_1_.field_70292_b + p_77020_4_) / 20.0F + p_77020_1_.field_70290_d) * 57.295776F, 0.0F, 1.0F, 0.0F);
         }

         float var16 = 0.0625F;
         var17 = 0.021875F;
         ItemStack var18 = p_77020_1_.func_92059_d();
         int var19 = var18.field_77994_a;
         byte var24;
         if(var19 < 2) {
            var24 = 1;
         } else if(var19 < 16) {
            var24 = 2;
         } else if(var19 < 32) {
            var24 = 3;
         } else {
            var24 = 4;
         }

         GL11.glTranslatef(-var14, -var15, -((var16 + var17) * (float)var24 / 2.0F));

         for(int var20 = 0; var20 < var24; ++var20) {
            GL11.glTranslatef(0.0F, 0.0F, var16 + var17);
            if(var18.func_94608_d() == 0) {
               this.func_110776_a(TextureMap.field_110575_b);
            } else {
               this.func_110776_a(TextureMap.field_110576_c);
            }

            GL11.glColor4f(p_77020_5_, p_77020_6_, p_77020_7_, 1.0F);
            ItemRenderer.func_78439_a(var8, var26, var11, var25, var12, ((IIcon)p_77020_2_).func_94211_a(), ((IIcon)p_77020_2_).func_94216_b(), var16);
            if(var18.func_77962_s()) {
               GL11.glDepthFunc(514);
               GL11.glDisable(2896);
               this.field_76990_c.field_78724_e.func_110577_a(field_110798_h);
               GL11.glEnable(3042);
               GL11.glBlendFunc(768, 1);
               float var21 = 0.76F;
               GL11.glColor4f(0.5F * var21, 0.25F * var21, 0.8F * var21, 1.0F);
               GL11.glMatrixMode(5890);
               GL11.glPushMatrix();
               float var22 = 0.125F;
               GL11.glScalef(var22, var22, var22);
               float var23 = (float)(Minecraft.func_71386_F() % 3000L) / 3000.0F * 8.0F;
               GL11.glTranslatef(var23, 0.0F, 0.0F);
               GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
               ItemRenderer.func_78439_a(var8, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, var16);
               GL11.glPopMatrix();
               GL11.glPushMatrix();
               GL11.glScalef(var22, var22, var22);
               var23 = (float)(Minecraft.func_71386_F() % 4873L) / 4873.0F * 8.0F;
               GL11.glTranslatef(-var23, 0.0F, 0.0F);
               GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
               ItemRenderer.func_78439_a(var8, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, var16);
               GL11.glPopMatrix();
               GL11.glMatrixMode(5888);
               GL11.glDisable(3042);
               GL11.glEnable(2896);
               GL11.glDepthFunc(515);
            }
         }

         GL11.glPopMatrix();
      } else {
         for(int var27 = 0; var27 < p_77020_3_; ++var27) {
            GL11.glPushMatrix();
            if(var27 > 0) {
               var17 = (this.field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.3F;
               float var28 = (this.field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.3F;
               float var29 = (this.field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.3F;
               GL11.glTranslatef(var17, var28, var29);
            }

            if(!field_82407_g) {
               GL11.glRotatef(180.0F - this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
            }

            GL11.glColor4f(p_77020_5_, p_77020_6_, p_77020_7_, 1.0F);
            var8.func_78382_b();
            var8.func_78375_b(0.0F, 1.0F, 0.0F);
            var8.func_78374_a((double)(0.0F - var14), (double)(0.0F - var15), 0.0D, (double)var25, (double)var12);
            var8.func_78374_a((double)(var13 - var14), (double)(0.0F - var15), 0.0D, (double)var26, (double)var12);
            var8.func_78374_a((double)(var13 - var14), (double)(1.0F - var15), 0.0D, (double)var26, (double)var11);
            var8.func_78374_a((double)(0.0F - var14), (double)(1.0F - var15), 0.0D, (double)var25, (double)var11);
            var8.func_78381_a();
            GL11.glPopMatrix();
         }
      }

   }

   public void func_77015_a(FontRenderer p_77015_1_, TextureManager p_77015_2_, ItemStack p_77015_3_, int p_77015_4_, int p_77015_5_) {
      int var6 = p_77015_3_.func_77960_j();
      Object var7 = p_77015_3_.func_77954_c();
      int var9;
      float var12;
      float var17;
      float var18;
      if(p_77015_3_.func_94608_d() == 0 && RenderBlocks.func_147739_a(Block.func_149634_a(p_77015_3_.func_77973_b()).func_149645_b())) {
         p_77015_2_.func_110577_a(TextureMap.field_110575_b);
         Block var16 = Block.func_149634_a(p_77015_3_.func_77973_b());
         GL11.glEnable(3008);
         if(var16.func_149701_w() != 0) {
            GL11.glAlphaFunc(516, 0.1F);
            GL11.glEnable(3042);
            OpenGlHelper.func_148821_a(770, 771, 1, 0);
         } else {
            GL11.glAlphaFunc(516, 0.5F);
            GL11.glDisable(3042);
         }

         GL11.glPushMatrix();
         GL11.glTranslatef((float)(p_77015_4_ - 2), (float)(p_77015_5_ + 3), -3.0F + this.field_77023_b);
         GL11.glScalef(10.0F, 10.0F, 10.0F);
         GL11.glTranslatef(1.0F, 0.5F, 1.0F);
         GL11.glScalef(1.0F, 1.0F, -1.0F);
         GL11.glRotatef(210.0F, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         var9 = p_77015_3_.func_77973_b().func_82790_a(p_77015_3_, 0);
         var17 = (float)(var9 >> 16 & 255) / 255.0F;
         var18 = (float)(var9 >> 8 & 255) / 255.0F;
         var12 = (float)(var9 & 255) / 255.0F;
         if(this.field_77024_a) {
            GL11.glColor4f(var17, var18, var12, 1.0F);
         }

         GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
         this.field_147913_i.field_147844_c = this.field_77024_a;
         this.field_147913_i.func_147800_a(var16, var6, 1.0F);
         this.field_147913_i.field_147844_c = true;
         if(var16.func_149701_w() == 0) {
            GL11.glAlphaFunc(516, 0.1F);
         }

         GL11.glPopMatrix();
      } else if(p_77015_3_.func_77973_b().func_77623_v()) {
         GL11.glDisable(2896);
         GL11.glEnable(3008);
         p_77015_2_.func_110577_a(TextureMap.field_110576_c);
         GL11.glDisable(3008);
         GL11.glDisable(3553);
         GL11.glEnable(3042);
         OpenGlHelper.func_148821_a(0, 0, 0, 0);
         GL11.glColorMask(false, false, false, true);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         Tessellator var8 = Tessellator.field_78398_a;
         var8.func_78382_b();
         var8.func_78378_d(-1);
         var8.func_78377_a((double)(p_77015_4_ - 2), (double)(p_77015_5_ + 18), (double)this.field_77023_b);
         var8.func_78377_a((double)(p_77015_4_ + 18), (double)(p_77015_5_ + 18), (double)this.field_77023_b);
         var8.func_78377_a((double)(p_77015_4_ + 18), (double)(p_77015_5_ - 2), (double)this.field_77023_b);
         var8.func_78377_a((double)(p_77015_4_ - 2), (double)(p_77015_5_ - 2), (double)this.field_77023_b);
         var8.func_78381_a();
         GL11.glColorMask(true, true, true, true);
         GL11.glEnable(3553);
         GL11.glEnable(3008);
         OpenGlHelper.func_148821_a(770, 771, 1, 0);

         for(var9 = 0; var9 <= 1; ++var9) {
            IIcon var10 = p_77015_3_.func_77973_b().func_77618_c(var6, var9);
            int var11 = p_77015_3_.func_77973_b().func_82790_a(p_77015_3_, var9);
            var12 = (float)(var11 >> 16 & 255) / 255.0F;
            float var13 = (float)(var11 >> 8 & 255) / 255.0F;
            float var14 = (float)(var11 & 255) / 255.0F;
            if(this.field_77024_a) {
               GL11.glColor4f(var12, var13, var14, 1.0F);
            }

            this.func_94149_a(p_77015_4_, p_77015_5_, var10, 16, 16);
         }

         GL11.glEnable(2896);
      } else {
         GL11.glDisable(2896);
         GL11.glEnable(3042);
         OpenGlHelper.func_148821_a(770, 771, 1, 0);
         ResourceLocation var15 = p_77015_2_.func_130087_a(p_77015_3_.func_94608_d());
         p_77015_2_.func_110577_a(var15);
         if(var7 == null) {
            var7 = ((TextureMap)Minecraft.func_71410_x().func_110434_K().func_110581_b(var15)).func_110572_b("missingno");
         }

         var9 = p_77015_3_.func_77973_b().func_82790_a(p_77015_3_, 0);
         var17 = (float)(var9 >> 16 & 255) / 255.0F;
         var18 = (float)(var9 >> 8 & 255) / 255.0F;
         var12 = (float)(var9 & 255) / 255.0F;
         if(this.field_77024_a) {
            GL11.glColor4f(var17, var18, var12, 1.0F);
         }

         this.func_94149_a(p_77015_4_, p_77015_5_, (IIcon)var7, 16, 16);
         GL11.glEnable(2896);
         GL11.glDisable(3042);
      }

      GL11.glEnable(2884);
   }

   public void func_82406_b(FontRenderer p_82406_1_, TextureManager p_82406_2_, final ItemStack p_82406_3_, int p_82406_4_, int p_82406_5_) {
      if(p_82406_3_ != null) {
         this.field_77023_b += 50.0F;

         try {
            this.func_77015_a(p_82406_1_, p_82406_2_, p_82406_3_, p_82406_4_, p_82406_5_);
         } catch (Throwable var9) {
            CrashReport var7 = CrashReport.func_85055_a(var9, "Rendering item");
            CrashReportCategory var8 = var7.func_85058_a("Item being rendered");
            var8.func_71500_a("Item Type", new Callable() {

               private static final String __OBFID = "CL_00001004";

               public String call() {
                  return String.valueOf(p_82406_3_.func_77973_b());
               }
               // $FF: synthetic method
               public Object call() {
                  return this.call();
               }
            });
            var8.func_71500_a("Item Aux", new Callable() {

               private static final String __OBFID = "CL_00001005";

               public String call() {
                  return String.valueOf(p_82406_3_.func_77960_j());
               }
               // $FF: synthetic method
               public Object call() {
                  return this.call();
               }
            });
            var8.func_71500_a("Item NBT", new Callable() {

               private static final String __OBFID = "CL_00001006";

               public String call() {
                  return String.valueOf(p_82406_3_.func_77978_p());
               }
               // $FF: synthetic method
               public Object call() {
                  return this.call();
               }
            });
            var8.func_71500_a("Item Foil", new Callable() {

               private static final String __OBFID = "CL_00001007";

               public String call() {
                  return String.valueOf(p_82406_3_.func_77962_s());
               }
               // $FF: synthetic method
               public Object call() {
                  return this.call();
               }
            });
            throw new ReportedException(var7);
         }

         if(p_82406_3_.func_77962_s()) {
            GL11.glDepthFunc(514);
            GL11.glDisable(2896);
            GL11.glDepthMask(false);
            p_82406_2_.func_110577_a(field_110798_h);
            GL11.glEnable(3008);
            GL11.glEnable(3042);
            GL11.glColor4f(0.5F, 0.25F, 0.8F, 1.0F);
            this.func_77018_a(p_82406_4_ * 431278612 + p_82406_5_ * 32178161, p_82406_4_ - 2, p_82406_5_ - 2, 20, 20);
            OpenGlHelper.func_148821_a(770, 771, 1, 0);
            GL11.glDepthMask(true);
            GL11.glEnable(2896);
            GL11.glDepthFunc(515);
         }

         this.field_77023_b -= 50.0F;
      }
   }

   private void func_77018_a(int p_77018_1_, int p_77018_2_, int p_77018_3_, int p_77018_4_, int p_77018_5_) {
      for(int var6 = 0; var6 < 2; ++var6) {
         OpenGlHelper.func_148821_a(772, 1, 0, 0);
         float var7 = 0.00390625F;
         float var8 = 0.00390625F;
         float var9 = (float)(Minecraft.func_71386_F() % (long)(3000 + var6 * 1873)) / (3000.0F + (float)(var6 * 1873)) * 256.0F;
         float var10 = 0.0F;
         Tessellator var11 = Tessellator.field_78398_a;
         float var12 = 4.0F;
         if(var6 == 1) {
            var12 = -1.0F;
         }

         var11.func_78382_b();
         var11.func_78374_a((double)(p_77018_2_ + 0), (double)(p_77018_3_ + p_77018_5_), (double)this.field_77023_b, (double)((var9 + (float)p_77018_5_ * var12) * var7), (double)((var10 + (float)p_77018_5_) * var8));
         var11.func_78374_a((double)(p_77018_2_ + p_77018_4_), (double)(p_77018_3_ + p_77018_5_), (double)this.field_77023_b, (double)((var9 + (float)p_77018_4_ + (float)p_77018_5_ * var12) * var7), (double)((var10 + (float)p_77018_5_) * var8));
         var11.func_78374_a((double)(p_77018_2_ + p_77018_4_), (double)(p_77018_3_ + 0), (double)this.field_77023_b, (double)((var9 + (float)p_77018_4_) * var7), (double)((var10 + 0.0F) * var8));
         var11.func_78374_a((double)(p_77018_2_ + 0), (double)(p_77018_3_ + 0), (double)this.field_77023_b, (double)((var9 + 0.0F) * var7), (double)((var10 + 0.0F) * var8));
         var11.func_78381_a();
      }

   }

   public void func_77021_b(FontRenderer p_77021_1_, TextureManager p_77021_2_, ItemStack p_77021_3_, int p_77021_4_, int p_77021_5_) {
      this.func_94148_a(p_77021_1_, p_77021_2_, p_77021_3_, p_77021_4_, p_77021_5_, (String)null);
   }

   public void func_94148_a(FontRenderer p_94148_1_, TextureManager p_94148_2_, ItemStack p_94148_3_, int p_94148_4_, int p_94148_5_, String p_94148_6_) {
      if(p_94148_3_ != null) {
         if(p_94148_3_.field_77994_a > 1 || p_94148_6_ != null) {
            String var7 = p_94148_6_ == null?String.valueOf(p_94148_3_.field_77994_a):p_94148_6_;
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            GL11.glDisable(3042);
            p_94148_1_.func_78261_a(var7, p_94148_4_ + 19 - 2 - p_94148_1_.func_78256_a(var7), p_94148_5_ + 6 + 3, 16777215);
            GL11.glEnable(2896);
            GL11.glEnable(2929);
         }

         if(p_94148_3_.func_77951_h()) {
            int var12 = (int)Math.round(13.0D - (double)p_94148_3_.func_77952_i() * 13.0D / (double)p_94148_3_.func_77958_k());
            int var8 = (int)Math.round(255.0D - (double)p_94148_3_.func_77952_i() * 255.0D / (double)p_94148_3_.func_77958_k());
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            GL11.glDisable(3553);
            GL11.glDisable(3008);
            GL11.glDisable(3042);
            Tessellator var9 = Tessellator.field_78398_a;
            int var10 = 255 - var8 << 16 | var8 << 8;
            int var11 = (255 - var8) / 4 << 16 | 16128;
            this.func_77017_a(var9, p_94148_4_ + 2, p_94148_5_ + 13, 13, 2, 0);
            this.func_77017_a(var9, p_94148_4_ + 2, p_94148_5_ + 13, 12, 1, var11);
            this.func_77017_a(var9, p_94148_4_ + 2, p_94148_5_ + 13, var12, 1, var10);
            GL11.glEnable(3042);
            GL11.glEnable(3008);
            GL11.glEnable(3553);
            GL11.glEnable(2896);
            GL11.glEnable(2929);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         }

      }
   }

   private void func_77017_a(Tessellator p_77017_1_, int p_77017_2_, int p_77017_3_, int p_77017_4_, int p_77017_5_, int p_77017_6_) {
      p_77017_1_.func_78382_b();
      p_77017_1_.func_78378_d(p_77017_6_);
      p_77017_1_.func_78377_a((double)(p_77017_2_ + 0), (double)(p_77017_3_ + 0), 0.0D);
      p_77017_1_.func_78377_a((double)(p_77017_2_ + 0), (double)(p_77017_3_ + p_77017_5_), 0.0D);
      p_77017_1_.func_78377_a((double)(p_77017_2_ + p_77017_4_), (double)(p_77017_3_ + p_77017_5_), 0.0D);
      p_77017_1_.func_78377_a((double)(p_77017_2_ + p_77017_4_), (double)(p_77017_3_ + 0), 0.0D);
      p_77017_1_.func_78381_a();
   }

   public void func_94149_a(int p_94149_1_, int p_94149_2_, IIcon p_94149_3_, int p_94149_4_, int p_94149_5_) {
      Tessellator var6 = Tessellator.field_78398_a;
      var6.func_78382_b();
      var6.func_78374_a((double)(p_94149_1_ + 0), (double)(p_94149_2_ + p_94149_5_), (double)this.field_77023_b, (double)p_94149_3_.func_94209_e(), (double)p_94149_3_.func_94210_h());
      var6.func_78374_a((double)(p_94149_1_ + p_94149_4_), (double)(p_94149_2_ + p_94149_5_), (double)this.field_77023_b, (double)p_94149_3_.func_94212_f(), (double)p_94149_3_.func_94210_h());
      var6.func_78374_a((double)(p_94149_1_ + p_94149_4_), (double)(p_94149_2_ + 0), (double)this.field_77023_b, (double)p_94149_3_.func_94212_f(), (double)p_94149_3_.func_94206_g());
      var6.func_78374_a((double)(p_94149_1_ + 0), (double)(p_94149_2_ + 0), (double)this.field_77023_b, (double)p_94149_3_.func_94209_e(), (double)p_94149_3_.func_94206_g());
      var6.func_78381_a();
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntityItem)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityItem)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

}
