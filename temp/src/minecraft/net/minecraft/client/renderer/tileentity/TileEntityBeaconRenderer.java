package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TileEntityBeaconRenderer extends TileEntitySpecialRenderer {

   private static final ResourceLocation field_147523_b = new ResourceLocation("textures/entity/beacon_beam.png");
   private static final String __OBFID = "CL_00000962";


   public void func_147500_a(TileEntityBeacon p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_) {
      float var9 = p_147500_1_.func_146002_i();
      GL11.glAlphaFunc(516, 0.1F);
      if(var9 > 0.0F) {
         Tessellator var10 = Tessellator.field_78398_a;
         this.func_147499_a(field_147523_b);
         GL11.glTexParameterf(3553, 10242, 10497.0F);
         GL11.glTexParameterf(3553, 10243, 10497.0F);
         GL11.glDisable(2896);
         GL11.glDisable(2884);
         GL11.glDisable(3042);
         GL11.glDepthMask(true);
         OpenGlHelper.func_148821_a(770, 1, 1, 0);
         float var11 = (float)p_147500_1_.func_145831_w().func_82737_E() + p_147500_8_;
         float var12 = -var11 * 0.2F - (float)MathHelper.func_76141_d(-var11 * 0.1F);
         byte var13 = 1;
         double var14 = (double)var11 * 0.025D * (1.0D - (double)(var13 & 1) * 2.5D);
         var10.func_78382_b();
         var10.func_78370_a(255, 255, 255, 32);
         double var16 = (double)var13 * 0.2D;
         double var18 = 0.5D + Math.cos(var14 + 2.356194490192345D) * var16;
         double var20 = 0.5D + Math.sin(var14 + 2.356194490192345D) * var16;
         double var22 = 0.5D + Math.cos(var14 + 0.7853981633974483D) * var16;
         double var24 = 0.5D + Math.sin(var14 + 0.7853981633974483D) * var16;
         double var26 = 0.5D + Math.cos(var14 + 3.9269908169872414D) * var16;
         double var28 = 0.5D + Math.sin(var14 + 3.9269908169872414D) * var16;
         double var30 = 0.5D + Math.cos(var14 + 5.497787143782138D) * var16;
         double var32 = 0.5D + Math.sin(var14 + 5.497787143782138D) * var16;
         double var34 = (double)(256.0F * var9);
         double var36 = 0.0D;
         double var38 = 1.0D;
         double var40 = (double)(-1.0F + var12);
         double var42 = (double)(256.0F * var9) * (0.5D / var16) + var40;
         var10.func_78374_a(p_147500_2_ + var18, p_147500_4_ + var34, p_147500_6_ + var20, var38, var42);
         var10.func_78374_a(p_147500_2_ + var18, p_147500_4_, p_147500_6_ + var20, var38, var40);
         var10.func_78374_a(p_147500_2_ + var22, p_147500_4_, p_147500_6_ + var24, var36, var40);
         var10.func_78374_a(p_147500_2_ + var22, p_147500_4_ + var34, p_147500_6_ + var24, var36, var42);
         var10.func_78374_a(p_147500_2_ + var30, p_147500_4_ + var34, p_147500_6_ + var32, var38, var42);
         var10.func_78374_a(p_147500_2_ + var30, p_147500_4_, p_147500_6_ + var32, var38, var40);
         var10.func_78374_a(p_147500_2_ + var26, p_147500_4_, p_147500_6_ + var28, var36, var40);
         var10.func_78374_a(p_147500_2_ + var26, p_147500_4_ + var34, p_147500_6_ + var28, var36, var42);
         var10.func_78374_a(p_147500_2_ + var22, p_147500_4_ + var34, p_147500_6_ + var24, var38, var42);
         var10.func_78374_a(p_147500_2_ + var22, p_147500_4_, p_147500_6_ + var24, var38, var40);
         var10.func_78374_a(p_147500_2_ + var30, p_147500_4_, p_147500_6_ + var32, var36, var40);
         var10.func_78374_a(p_147500_2_ + var30, p_147500_4_ + var34, p_147500_6_ + var32, var36, var42);
         var10.func_78374_a(p_147500_2_ + var26, p_147500_4_ + var34, p_147500_6_ + var28, var38, var42);
         var10.func_78374_a(p_147500_2_ + var26, p_147500_4_, p_147500_6_ + var28, var38, var40);
         var10.func_78374_a(p_147500_2_ + var18, p_147500_4_, p_147500_6_ + var20, var36, var40);
         var10.func_78374_a(p_147500_2_ + var18, p_147500_4_ + var34, p_147500_6_ + var20, var36, var42);
         var10.func_78381_a();
         GL11.glEnable(3042);
         OpenGlHelper.func_148821_a(770, 771, 1, 0);
         GL11.glDepthMask(false);
         var10.func_78382_b();
         var10.func_78370_a(255, 255, 255, 32);
         double var44 = 0.2D;
         double var15 = 0.2D;
         double var17 = 0.8D;
         double var19 = 0.2D;
         double var21 = 0.2D;
         double var23 = 0.8D;
         double var25 = 0.8D;
         double var27 = 0.8D;
         double var29 = (double)(256.0F * var9);
         double var31 = 0.0D;
         double var33 = 1.0D;
         double var35 = (double)(-1.0F + var12);
         double var37 = (double)(256.0F * var9) + var35;
         var10.func_78374_a(p_147500_2_ + var44, p_147500_4_ + var29, p_147500_6_ + var15, var33, var37);
         var10.func_78374_a(p_147500_2_ + var44, p_147500_4_, p_147500_6_ + var15, var33, var35);
         var10.func_78374_a(p_147500_2_ + var17, p_147500_4_, p_147500_6_ + var19, var31, var35);
         var10.func_78374_a(p_147500_2_ + var17, p_147500_4_ + var29, p_147500_6_ + var19, var31, var37);
         var10.func_78374_a(p_147500_2_ + var25, p_147500_4_ + var29, p_147500_6_ + var27, var33, var37);
         var10.func_78374_a(p_147500_2_ + var25, p_147500_4_, p_147500_6_ + var27, var33, var35);
         var10.func_78374_a(p_147500_2_ + var21, p_147500_4_, p_147500_6_ + var23, var31, var35);
         var10.func_78374_a(p_147500_2_ + var21, p_147500_4_ + var29, p_147500_6_ + var23, var31, var37);
         var10.func_78374_a(p_147500_2_ + var17, p_147500_4_ + var29, p_147500_6_ + var19, var33, var37);
         var10.func_78374_a(p_147500_2_ + var17, p_147500_4_, p_147500_6_ + var19, var33, var35);
         var10.func_78374_a(p_147500_2_ + var25, p_147500_4_, p_147500_6_ + var27, var31, var35);
         var10.func_78374_a(p_147500_2_ + var25, p_147500_4_ + var29, p_147500_6_ + var27, var31, var37);
         var10.func_78374_a(p_147500_2_ + var21, p_147500_4_ + var29, p_147500_6_ + var23, var33, var37);
         var10.func_78374_a(p_147500_2_ + var21, p_147500_4_, p_147500_6_ + var23, var33, var35);
         var10.func_78374_a(p_147500_2_ + var44, p_147500_4_, p_147500_6_ + var15, var31, var35);
         var10.func_78374_a(p_147500_2_ + var44, p_147500_4_ + var29, p_147500_6_ + var15, var31, var37);
         var10.func_78381_a();
         GL11.glEnable(2896);
         GL11.glEnable(3553);
         GL11.glDepthMask(true);
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_147500_a(TileEntity p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_) {
      this.func_147500_a((TileEntityBeacon)p_147500_1_, p_147500_2_, p_147500_4_, p_147500_6_, p_147500_8_);
   }

}
