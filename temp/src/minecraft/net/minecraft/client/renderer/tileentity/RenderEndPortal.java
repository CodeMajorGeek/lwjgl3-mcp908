package net.minecraft.client.renderer.tileentity;

import java.nio.FloatBuffer;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEndPortal;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderEndPortal extends TileEntitySpecialRenderer {

   private static final ResourceLocation field_147529_c = new ResourceLocation("textures/environment/end_sky.png");
   private static final ResourceLocation field_147526_d = new ResourceLocation("textures/entity/end_portal.png");
   private static final Random field_147527_e = new Random(31100L);
   FloatBuffer field_147528_b = GLAllocation.func_74529_h(16);
   private static final String __OBFID = "CL_00000972";


   public void func_147500_a(TileEntityEndPortal p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_) {
      float var9 = (float)this.field_147501_a.field_147560_j;
      float var10 = (float)this.field_147501_a.field_147561_k;
      float var11 = (float)this.field_147501_a.field_147558_l;
      GL11.glDisable(2896);
      field_147527_e.setSeed(31100L);
      float var12 = 0.75F;

      for(int var13 = 0; var13 < 16; ++var13) {
         GL11.glPushMatrix();
         float var14 = (float)(16 - var13);
         float var15 = 0.0625F;
         float var16 = 1.0F / (var14 + 1.0F);
         if(var13 == 0) {
            this.func_147499_a(field_147529_c);
            var16 = 0.1F;
            var14 = 65.0F;
            var15 = 0.125F;
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
         }

         if(var13 == 1) {
            this.func_147499_a(field_147526_d);
            GL11.glEnable(3042);
            GL11.glBlendFunc(1, 1);
            var15 = 0.5F;
         }

         float var17 = (float)(-(p_147500_4_ + (double)var12));
         float var18 = var17 + ActiveRenderInfo.field_74590_b;
         float var19 = var17 + var14 + ActiveRenderInfo.field_74590_b;
         float var20 = var18 / var19;
         var20 += (float)(p_147500_4_ + (double)var12);
         GL11.glTranslatef(var9, var20, var11);
         GL11.glTexGeni(8192, 9472, 9217);
         GL11.glTexGeni(8193, 9472, 9217);
         GL11.glTexGeni(8194, 9472, 9217);
         GL11.glTexGeni(8195, 9472, 9216);
         GL11.glTexGen(8192, 9473, this.func_147525_a(1.0F, 0.0F, 0.0F, 0.0F));
         GL11.glTexGen(8193, 9473, this.func_147525_a(0.0F, 0.0F, 1.0F, 0.0F));
         GL11.glTexGen(8194, 9473, this.func_147525_a(0.0F, 0.0F, 0.0F, 1.0F));
         GL11.glTexGen(8195, 9474, this.func_147525_a(0.0F, 1.0F, 0.0F, 0.0F));
         GL11.glEnable(3168);
         GL11.glEnable(3169);
         GL11.glEnable(3170);
         GL11.glEnable(3171);
         GL11.glPopMatrix();
         GL11.glMatrixMode(5890);
         GL11.glPushMatrix();
         GL11.glLoadIdentity();
         GL11.glTranslatef(0.0F, (float)(Minecraft.func_71386_F() % 700000L) / 700000.0F, 0.0F);
         GL11.glScalef(var15, var15, var15);
         GL11.glTranslatef(0.5F, 0.5F, 0.0F);
         GL11.glRotatef((float)(var13 * var13 * 4321 + var13 * 9) * 2.0F, 0.0F, 0.0F, 1.0F);
         GL11.glTranslatef(-0.5F, -0.5F, 0.0F);
         GL11.glTranslatef(-var9, -var11, -var10);
         var18 = var17 + ActiveRenderInfo.field_74590_b;
         GL11.glTranslatef(ActiveRenderInfo.field_74592_a * var14 / var18, ActiveRenderInfo.field_74591_c * var14 / var18, -var10);
         Tessellator var23 = Tessellator.field_78398_a;
         var23.func_78382_b();
         var20 = field_147527_e.nextFloat() * 0.5F + 0.1F;
         float var21 = field_147527_e.nextFloat() * 0.5F + 0.4F;
         float var22 = field_147527_e.nextFloat() * 0.5F + 0.5F;
         if(var13 == 0) {
            var22 = 1.0F;
            var21 = 1.0F;
            var20 = 1.0F;
         }

         var23.func_78369_a(var20 * var16, var21 * var16, var22 * var16, 1.0F);
         var23.func_78377_a(p_147500_2_, p_147500_4_ + (double)var12, p_147500_6_);
         var23.func_78377_a(p_147500_2_, p_147500_4_ + (double)var12, p_147500_6_ + 1.0D);
         var23.func_78377_a(p_147500_2_ + 1.0D, p_147500_4_ + (double)var12, p_147500_6_ + 1.0D);
         var23.func_78377_a(p_147500_2_ + 1.0D, p_147500_4_ + (double)var12, p_147500_6_);
         var23.func_78381_a();
         GL11.glPopMatrix();
         GL11.glMatrixMode(5888);
      }

      GL11.glDisable(3042);
      GL11.glDisable(3168);
      GL11.glDisable(3169);
      GL11.glDisable(3170);
      GL11.glDisable(3171);
      GL11.glEnable(2896);
   }

   private FloatBuffer func_147525_a(float p_147525_1_, float p_147525_2_, float p_147525_3_, float p_147525_4_) {
      this.field_147528_b.clear();
      this.field_147528_b.put(p_147525_1_).put(p_147525_2_).put(p_147525_3_).put(p_147525_4_);
      this.field_147528_b.flip();
      return this.field_147528_b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_147500_a(TileEntity p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_) {
      this.func_147500_a((TileEntityEndPortal)p_147500_1_, p_147500_2_, p_147500_4_, p_147500_6_, p_147500_8_);
   }

}
