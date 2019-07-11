package net.minecraft.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MinecraftError;
import org.lwjgl.opengl.GL11;

public class LoadingScreenRenderer implements IProgressUpdate {

   private String field_73727_a = "";
   private Minecraft field_73725_b;
   private String field_73726_c = "";
   private long field_73723_d = Minecraft.func_71386_F();
   private boolean field_73724_e;
   private ScaledResolution field_146587_f;
   private Framebuffer field_146588_g;
   private static final String __OBFID = "CL_00000655";


   public LoadingScreenRenderer(Minecraft p_i1017_1_) {
      this.field_73725_b = p_i1017_1_;
      this.field_146587_f = new ScaledResolution(p_i1017_1_, p_i1017_1_.field_71443_c, p_i1017_1_.field_71440_d);
      this.field_146588_g = new Framebuffer(p_i1017_1_.field_71443_c, p_i1017_1_.field_71440_d, false);
      this.field_146588_g.func_147607_a(9728);
   }

   public void func_73721_b(String p_73721_1_) {
      this.field_73724_e = false;
      this.func_73722_d(p_73721_1_);
   }

   public void func_73720_a(String p_73720_1_) {
      this.field_73724_e = true;
      this.func_73722_d(p_73720_1_);
   }

   public void func_73722_d(String p_73722_1_) {
      this.field_73726_c = p_73722_1_;
      if(!this.field_73725_b.field_71425_J) {
         if(!this.field_73724_e) {
            throw new MinecraftError();
         }
      } else {
         GL11.glClear(256);
         GL11.glMatrixMode(5889);
         GL11.glLoadIdentity();
         if(OpenGlHelper.func_148822_b()) {
            int var2 = this.field_146587_f.func_78325_e();
            GL11.glOrtho(0.0D, (double)(this.field_146587_f.func_78326_a() * var2), (double)(this.field_146587_f.func_78328_b() * var2), 0.0D, 100.0D, 300.0D);
         } else {
            ScaledResolution var3 = new ScaledResolution(this.field_73725_b, this.field_73725_b.field_71443_c, this.field_73725_b.field_71440_d);
            GL11.glOrtho(0.0D, var3.func_78327_c(), var3.func_78324_d(), 0.0D, 100.0D, 300.0D);
         }

         GL11.glMatrixMode(5888);
         GL11.glLoadIdentity();
         GL11.glTranslatef(0.0F, 0.0F, -200.0F);
      }
   }

   public void func_73719_c(String p_73719_1_) {
      if(!this.field_73725_b.field_71425_J) {
         if(!this.field_73724_e) {
            throw new MinecraftError();
         }
      } else {
         this.field_73723_d = 0L;
         this.field_73727_a = p_73719_1_;
         this.func_73718_a(-1);
         this.field_73723_d = 0L;
      }
   }

   public void func_73718_a(int p_73718_1_) {
      if(!this.field_73725_b.field_71425_J) {
         if(!this.field_73724_e) {
            throw new MinecraftError();
         }
      } else {
         long var2 = Minecraft.func_71386_F();
         if(var2 - this.field_73723_d >= 100L) {
            this.field_73723_d = var2;
            ScaledResolution var4 = new ScaledResolution(this.field_73725_b, this.field_73725_b.field_71443_c, this.field_73725_b.field_71440_d);
            int var5 = var4.func_78325_e();
            int var6 = var4.func_78326_a();
            int var7 = var4.func_78328_b();
            if(OpenGlHelper.func_148822_b()) {
               this.field_146588_g.func_147614_f();
            } else {
               GL11.glClear(256);
            }

            this.field_146588_g.func_147610_a(false);
            GL11.glMatrixMode(5889);
            GL11.glLoadIdentity();
            GL11.glOrtho(0.0D, var4.func_78327_c(), var4.func_78324_d(), 0.0D, 100.0D, 300.0D);
            GL11.glMatrixMode(5888);
            GL11.glLoadIdentity();
            GL11.glTranslatef(0.0F, 0.0F, -200.0F);
            if(!OpenGlHelper.func_148822_b()) {
               GL11.glClear(16640);
            }

            Tessellator var8 = Tessellator.field_78398_a;
            this.field_73725_b.func_110434_K().func_110577_a(Gui.field_110325_k);
            float var9 = 32.0F;
            var8.func_78382_b();
            var8.func_78378_d(4210752);
            var8.func_78374_a(0.0D, (double)var7, 0.0D, 0.0D, (double)((float)var7 / var9));
            var8.func_78374_a((double)var6, (double)var7, 0.0D, (double)((float)var6 / var9), (double)((float)var7 / var9));
            var8.func_78374_a((double)var6, 0.0D, 0.0D, (double)((float)var6 / var9), 0.0D);
            var8.func_78374_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
            var8.func_78381_a();
            if(p_73718_1_ >= 0) {
               byte var10 = 100;
               byte var11 = 2;
               int var12 = var6 / 2 - var10 / 2;
               int var13 = var7 / 2 + 16;
               GL11.glDisable(3553);
               var8.func_78382_b();
               var8.func_78378_d(8421504);
               var8.func_78377_a((double)var12, (double)var13, 0.0D);
               var8.func_78377_a((double)var12, (double)(var13 + var11), 0.0D);
               var8.func_78377_a((double)(var12 + var10), (double)(var13 + var11), 0.0D);
               var8.func_78377_a((double)(var12 + var10), (double)var13, 0.0D);
               var8.func_78378_d(8454016);
               var8.func_78377_a((double)var12, (double)var13, 0.0D);
               var8.func_78377_a((double)var12, (double)(var13 + var11), 0.0D);
               var8.func_78377_a((double)(var12 + p_73718_1_), (double)(var13 + var11), 0.0D);
               var8.func_78377_a((double)(var12 + p_73718_1_), (double)var13, 0.0D);
               var8.func_78381_a();
               GL11.glEnable(3553);
            }

            GL11.glEnable(3042);
            OpenGlHelper.func_148821_a(770, 771, 1, 0);
            this.field_73725_b.field_71466_p.func_78261_a(this.field_73726_c, (var6 - this.field_73725_b.field_71466_p.func_78256_a(this.field_73726_c)) / 2, var7 / 2 - 4 - 16, 16777215);
            this.field_73725_b.field_71466_p.func_78261_a(this.field_73727_a, (var6 - this.field_73725_b.field_71466_p.func_78256_a(this.field_73727_a)) / 2, var7 / 2 - 4 + 8, 16777215);
            this.field_146588_g.func_147609_e();
            if(OpenGlHelper.func_148822_b()) {
               this.field_146588_g.func_147615_c(var6 * var5, var7 * var5);
            }

            this.field_73725_b.func_147120_f();

            try {
               Thread.yield();
            } catch (Exception var14) {
               ;
            }

         }
      }
   }

   public void func_146586_a() {}
}
