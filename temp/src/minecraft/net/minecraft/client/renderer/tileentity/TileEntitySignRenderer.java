package net.minecraft.client.renderer.tileentity;

import net.minecraft.block.Block;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelSign;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TileEntitySignRenderer extends TileEntitySpecialRenderer {

   private static final ResourceLocation field_147513_b = new ResourceLocation("textures/entity/sign.png");
   private final ModelSign field_147514_c = new ModelSign();
   private static final String __OBFID = "CL_00000970";


   public void func_147500_a(TileEntitySign p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_) {
      Block var9 = p_147500_1_.func_145838_q();
      GL11.glPushMatrix();
      float var10 = 0.6666667F;
      float var12;
      if(var9 == Blocks.field_150472_an) {
         GL11.glTranslatef((float)p_147500_2_ + 0.5F, (float)p_147500_4_ + 0.75F * var10, (float)p_147500_6_ + 0.5F);
         float var11 = (float)(p_147500_1_.func_145832_p() * 360) / 16.0F;
         GL11.glRotatef(-var11, 0.0F, 1.0F, 0.0F);
         this.field_147514_c.field_78165_b.field_78806_j = true;
      } else {
         int var16 = p_147500_1_.func_145832_p();
         var12 = 0.0F;
         if(var16 == 2) {
            var12 = 180.0F;
         }

         if(var16 == 4) {
            var12 = 90.0F;
         }

         if(var16 == 5) {
            var12 = -90.0F;
         }

         GL11.glTranslatef((float)p_147500_2_ + 0.5F, (float)p_147500_4_ + 0.75F * var10, (float)p_147500_6_ + 0.5F);
         GL11.glRotatef(-var12, 0.0F, 1.0F, 0.0F);
         GL11.glTranslatef(0.0F, -0.3125F, -0.4375F);
         this.field_147514_c.field_78165_b.field_78806_j = false;
      }

      this.func_147499_a(field_147513_b);
      GL11.glPushMatrix();
      GL11.glScalef(var10, -var10, -var10);
      this.field_147514_c.func_78164_a();
      GL11.glPopMatrix();
      FontRenderer var17 = this.func_147498_b();
      var12 = 0.016666668F * var10;
      GL11.glTranslatef(0.0F, 0.5F * var10, 0.07F * var10);
      GL11.glScalef(var12, -var12, var12);
      GL11.glNormal3f(0.0F, 0.0F, -1.0F * var12);
      GL11.glDepthMask(false);
      byte var13 = 0;

      for(int var14 = 0; var14 < p_147500_1_.field_145915_a.length; ++var14) {
         String var15 = p_147500_1_.field_145915_a[var14];
         if(var14 == p_147500_1_.field_145918_i) {
            var15 = "> " + var15 + " <";
            var17.func_78276_b(var15, -var17.func_78256_a(var15) / 2, var14 * 10 - p_147500_1_.field_145915_a.length * 5, var13);
         } else {
            var17.func_78276_b(var15, -var17.func_78256_a(var15) / 2, var14 * 10 - p_147500_1_.field_145915_a.length * 5, var13);
         }
      }

      GL11.glDepthMask(true);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glPopMatrix();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_147500_a(TileEntity p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_) {
      this.func_147500_a((TileEntitySign)p_147500_1_, p_147500_2_, p_147500_4_, p_147500_6_, p_147500_8_);
   }

}
