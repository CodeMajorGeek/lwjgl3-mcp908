package net.minecraft.client.renderer.entity;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.entity.RenderMinecart;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityMinecartTNT;
import net.minecraft.init.Blocks;
import org.lwjgl.opengl.GL11;

public class RenderTntMinecart extends RenderMinecart {

   private static final String __OBFID = "CL_00001029";


   protected void func_147910_a(EntityMinecartTNT p_147910_1_, float p_147910_2_, Block p_147910_3_, int p_147910_4_) {
      int var5 = p_147910_1_.func_94104_d();
      if(var5 > -1 && (float)var5 - p_147910_2_ + 1.0F < 10.0F) {
         float var6 = 1.0F - ((float)var5 - p_147910_2_ + 1.0F) / 10.0F;
         if(var6 < 0.0F) {
            var6 = 0.0F;
         }

         if(var6 > 1.0F) {
            var6 = 1.0F;
         }

         var6 *= var6;
         var6 *= var6;
         float var7 = 1.0F + var6 * 0.3F;
         GL11.glScalef(var7, var7, var7);
      }

      super.func_147910_a(p_147910_1_, p_147910_2_, p_147910_3_, p_147910_4_);
      if(var5 > -1 && var5 / 5 % 2 == 0) {
         GL11.glDisable(3553);
         GL11.glDisable(2896);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 772);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, (1.0F - ((float)var5 - p_147910_2_ + 1.0F) / 100.0F) * 0.8F);
         GL11.glPushMatrix();
         this.field_94145_f.func_147800_a(Blocks.field_150335_W, 0, 1.0F);
         GL11.glPopMatrix();
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glDisable(3042);
         GL11.glEnable(2896);
         GL11.glEnable(3553);
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_147910_a(EntityMinecart p_147910_1_, float p_147910_2_, Block p_147910_3_, int p_147910_4_) {
      this.func_147910_a((EntityMinecartTNT)p_147910_1_, p_147910_2_, p_147910_3_, p_147910_4_);
   }
}
