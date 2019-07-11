package net.minecraft.client.renderer.tileentity;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureCompass;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.MapData;
import org.lwjgl.opengl.GL11;

public class RenderItemFrame extends Render {

   private static final ResourceLocation field_110789_a = new ResourceLocation("textures/map/map_background.png");
   private final RenderBlocks field_147916_f = new RenderBlocks();
   private final Minecraft field_147917_g = Minecraft.func_71410_x();
   private IIcon field_94147_f;
   private static final String __OBFID = "CL_00001002";


   public void func_94143_a(IIconRegister p_94143_1_) {
      this.field_94147_f = p_94143_1_.func_94245_a("itemframe_background");
   }

   public void func_76986_a(EntityItemFrame p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      GL11.glPushMatrix();
      double var10 = p_76986_1_.field_70165_t - p_76986_2_ - 0.5D;
      double var12 = p_76986_1_.field_70163_u - p_76986_4_ - 0.5D;
      double var14 = p_76986_1_.field_70161_v - p_76986_6_ - 0.5D;
      int var16 = p_76986_1_.field_146063_b + Direction.field_71583_a[p_76986_1_.field_82332_a];
      int var17 = p_76986_1_.field_146064_c;
      int var18 = p_76986_1_.field_146062_d + Direction.field_71581_b[p_76986_1_.field_82332_a];
      GL11.glTranslated((double)var16 - var10, (double)var17 - var12, (double)var18 - var14);
      if(p_76986_1_.func_82335_i() != null && p_76986_1_.func_82335_i().func_77973_b() == Items.field_151098_aY) {
         this.func_147915_b(p_76986_1_);
      } else {
         this.func_82403_a(p_76986_1_);
      }

      this.func_82402_b(p_76986_1_);
      GL11.glPopMatrix();
      this.func_147914_a(p_76986_1_, p_76986_2_ + (double)((float)Direction.field_71583_a[p_76986_1_.field_82332_a] * 0.3F), p_76986_4_ - 0.25D, p_76986_6_ + (double)((float)Direction.field_71581_b[p_76986_1_.field_82332_a] * 0.3F));
   }

   protected ResourceLocation func_110775_a(EntityItemFrame p_110775_1_) {
      return null;
   }

   private void func_147915_b(EntityItemFrame p_147915_1_) {
      GL11.glPushMatrix();
      GL11.glRotatef(p_147915_1_.field_70177_z, 0.0F, 1.0F, 0.0F);
      this.field_76990_c.field_78724_e.func_110577_a(TextureMap.field_110575_b);
      Block var2 = Blocks.field_150344_f;
      float var3 = 0.0625F;
      float var4 = 1.0F;
      float var5 = var4 / 2.0F;
      GL11.glPushMatrix();
      this.field_147916_f.func_147770_b(0.0D, (double)(0.5F - var5 + 0.0625F), (double)(0.5F - var5 + 0.0625F), (double)var3, (double)(0.5F + var5 - 0.0625F), (double)(0.5F + var5 - 0.0625F));
      this.field_147916_f.func_147757_a(this.field_94147_f);
      this.field_147916_f.func_147800_a(var2, 0, 1.0F);
      this.field_147916_f.func_147771_a();
      this.field_147916_f.func_147762_c();
      GL11.glPopMatrix();
      this.field_147916_f.func_147757_a(Blocks.field_150344_f.func_149691_a(1, 2));
      GL11.glPushMatrix();
      this.field_147916_f.func_147770_b(0.0D, (double)(0.5F - var5), (double)(0.5F - var5), (double)(var3 + 1.0E-4F), (double)(var3 + 0.5F - var5), (double)(0.5F + var5));
      this.field_147916_f.func_147800_a(var2, 0, 1.0F);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      this.field_147916_f.func_147770_b(0.0D, (double)(0.5F + var5 - var3), (double)(0.5F - var5), (double)(var3 + 1.0E-4F), (double)(0.5F + var5), (double)(0.5F + var5));
      this.field_147916_f.func_147800_a(var2, 0, 1.0F);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      this.field_147916_f.func_147770_b(0.0D, (double)(0.5F - var5), (double)(0.5F - var5), (double)var3, (double)(0.5F + var5), (double)(var3 + 0.5F - var5));
      this.field_147916_f.func_147800_a(var2, 0, 1.0F);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      this.field_147916_f.func_147770_b(0.0D, (double)(0.5F - var5), (double)(0.5F + var5 - var3), (double)var3, (double)(0.5F + var5), (double)(0.5F + var5));
      this.field_147916_f.func_147800_a(var2, 0, 1.0F);
      GL11.glPopMatrix();
      this.field_147916_f.func_147762_c();
      this.field_147916_f.func_147771_a();
      GL11.glPopMatrix();
   }

   private void func_82403_a(EntityItemFrame p_82403_1_) {
      GL11.glPushMatrix();
      GL11.glRotatef(p_82403_1_.field_70177_z, 0.0F, 1.0F, 0.0F);
      this.field_76990_c.field_78724_e.func_110577_a(TextureMap.field_110575_b);
      Block var2 = Blocks.field_150344_f;
      float var3 = 0.0625F;
      float var4 = 0.75F;
      float var5 = var4 / 2.0F;
      GL11.glPushMatrix();
      this.field_147916_f.func_147770_b(0.0D, (double)(0.5F - var5 + 0.0625F), (double)(0.5F - var5 + 0.0625F), (double)(var3 * 0.5F), (double)(0.5F + var5 - 0.0625F), (double)(0.5F + var5 - 0.0625F));
      this.field_147916_f.func_147757_a(this.field_94147_f);
      this.field_147916_f.func_147800_a(var2, 0, 1.0F);
      this.field_147916_f.func_147771_a();
      this.field_147916_f.func_147762_c();
      GL11.glPopMatrix();
      this.field_147916_f.func_147757_a(Blocks.field_150344_f.func_149691_a(1, 2));
      GL11.glPushMatrix();
      this.field_147916_f.func_147770_b(0.0D, (double)(0.5F - var5), (double)(0.5F - var5), (double)(var3 + 1.0E-4F), (double)(var3 + 0.5F - var5), (double)(0.5F + var5));
      this.field_147916_f.func_147800_a(var2, 0, 1.0F);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      this.field_147916_f.func_147770_b(0.0D, (double)(0.5F + var5 - var3), (double)(0.5F - var5), (double)(var3 + 1.0E-4F), (double)(0.5F + var5), (double)(0.5F + var5));
      this.field_147916_f.func_147800_a(var2, 0, 1.0F);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      this.field_147916_f.func_147770_b(0.0D, (double)(0.5F - var5), (double)(0.5F - var5), (double)var3, (double)(0.5F + var5), (double)(var3 + 0.5F - var5));
      this.field_147916_f.func_147800_a(var2, 0, 1.0F);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      this.field_147916_f.func_147770_b(0.0D, (double)(0.5F - var5), (double)(0.5F + var5 - var3), (double)var3, (double)(0.5F + var5), (double)(0.5F + var5));
      this.field_147916_f.func_147800_a(var2, 0, 1.0F);
      GL11.glPopMatrix();
      this.field_147916_f.func_147762_c();
      this.field_147916_f.func_147771_a();
      GL11.glPopMatrix();
   }

   private void func_82402_b(EntityItemFrame p_82402_1_) {
      ItemStack var2 = p_82402_1_.func_82335_i();
      if(var2 != null) {
         EntityItem var3 = new EntityItem(p_82402_1_.field_70170_p, 0.0D, 0.0D, 0.0D, var2);
         Item var4 = var3.func_92059_d().func_77973_b();
         var3.func_92059_d().field_77994_a = 1;
         var3.field_70290_d = 0.0F;
         GL11.glPushMatrix();
         GL11.glTranslatef(-0.453125F * (float)Direction.field_71583_a[p_82402_1_.field_82332_a], -0.18F, -0.453125F * (float)Direction.field_71581_b[p_82402_1_.field_82332_a]);
         GL11.glRotatef(180.0F + p_82402_1_.field_70177_z, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef((float)(-90 * p_82402_1_.func_82333_j()), 0.0F, 0.0F, 1.0F);
         switch(p_82402_1_.func_82333_j()) {
         case 1:
            GL11.glTranslatef(-0.16F, -0.16F, 0.0F);
            break;
         case 2:
            GL11.glTranslatef(0.0F, -0.32F, 0.0F);
            break;
         case 3:
            GL11.glTranslatef(0.16F, -0.16F, 0.0F);
         }

         if(var4 == Items.field_151098_aY) {
            this.field_76990_c.field_78724_e.func_110577_a(field_110789_a);
            Tessellator var5 = Tessellator.field_78398_a;
            GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
            float var6 = 0.0078125F;
            GL11.glScalef(var6, var6, var6);
            switch(p_82402_1_.func_82333_j()) {
            case 0:
               GL11.glTranslatef(-64.0F, -87.0F, -1.5F);
               break;
            case 1:
               GL11.glTranslatef(-66.5F, -84.5F, -1.5F);
               break;
            case 2:
               GL11.glTranslatef(-64.0F, -82.0F, -1.5F);
               break;
            case 3:
               GL11.glTranslatef(-61.5F, -84.5F, -1.5F);
            }

            GL11.glNormal3f(0.0F, 0.0F, -1.0F);
            MapData var7 = Items.field_151098_aY.func_77873_a(var3.func_92059_d(), p_82402_1_.field_70170_p);
            GL11.glTranslatef(0.0F, 0.0F, -1.0F);
            if(var7 != null) {
               this.field_147917_g.field_71460_t.func_147701_i().func_148250_a(var7, true);
            }
         } else {
            if(var4 == Items.field_151111_aL) {
               TextureManager var12 = Minecraft.func_71410_x().func_110434_K();
               var12.func_110577_a(TextureMap.field_110576_c);
               TextureAtlasSprite var14 = ((TextureMap)var12.func_110581_b(TextureMap.field_110576_c)).func_110572_b(Items.field_151111_aL.func_77650_f(var3.func_92059_d()).func_94215_i());
               if(var14 instanceof TextureCompass) {
                  TextureCompass var15 = (TextureCompass)var14;
                  double var8 = var15.field_94244_i;
                  double var10 = var15.field_94242_j;
                  var15.field_94244_i = 0.0D;
                  var15.field_94242_j = 0.0D;
                  var15.func_94241_a(p_82402_1_.field_70170_p, p_82402_1_.field_70165_t, p_82402_1_.field_70161_v, (double)MathHelper.func_76142_g((float)(180 + p_82402_1_.field_82332_a * 90)), false, true);
                  var15.field_94244_i = var8;
                  var15.field_94242_j = var10;
               }
            }

            RenderItem.field_82407_g = true;
            RenderManager.field_78727_a.func_147940_a(var3, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
            RenderItem.field_82407_g = false;
            if(var4 == Items.field_151111_aL) {
               TextureAtlasSprite var13 = ((TextureMap)Minecraft.func_71410_x().func_110434_K().func_110581_b(TextureMap.field_110576_c)).func_110572_b(Items.field_151111_aL.func_77650_f(var3.func_92059_d()).func_94215_i());
               if(var13.func_110970_k() > 0) {
                  var13.func_94219_l();
               }
            }
         }

         GL11.glPopMatrix();
      }
   }

   protected void func_147914_a(EntityItemFrame p_147914_1_, double p_147914_2_, double p_147914_4_, double p_147914_6_) {
      if(Minecraft.func_71382_s() && p_147914_1_.func_82335_i() != null && p_147914_1_.func_82335_i().func_82837_s() && this.field_76990_c.field_147941_i == p_147914_1_) {
         float var8 = 1.6F;
         float var9 = 0.016666668F * var8;
         double var10 = p_147914_1_.func_70068_e(this.field_76990_c.field_78734_h);
         float var12 = p_147914_1_.func_70093_af()?32.0F:64.0F;
         if(var10 < (double)(var12 * var12)) {
            String var13 = p_147914_1_.func_82335_i().func_82833_r();
            if(p_147914_1_.func_70093_af()) {
               FontRenderer var14 = this.func_76983_a();
               GL11.glPushMatrix();
               GL11.glTranslatef((float)p_147914_2_ + 0.0F, (float)p_147914_4_ + p_147914_1_.field_70131_O + 0.5F, (float)p_147914_6_);
               GL11.glNormal3f(0.0F, 1.0F, 0.0F);
               GL11.glRotatef(-this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
               GL11.glScalef(-var9, -var9, var9);
               GL11.glDisable(2896);
               GL11.glTranslatef(0.0F, 0.25F / var9, 0.0F);
               GL11.glDepthMask(false);
               GL11.glEnable(3042);
               GL11.glBlendFunc(770, 771);
               Tessellator var15 = Tessellator.field_78398_a;
               GL11.glDisable(3553);
               var15.func_78382_b();
               int var16 = var14.func_78256_a(var13) / 2;
               var15.func_78369_a(0.0F, 0.0F, 0.0F, 0.25F);
               var15.func_78377_a((double)(-var16 - 1), -1.0D, 0.0D);
               var15.func_78377_a((double)(-var16 - 1), 8.0D, 0.0D);
               var15.func_78377_a((double)(var16 + 1), 8.0D, 0.0D);
               var15.func_78377_a((double)(var16 + 1), -1.0D, 0.0D);
               var15.func_78381_a();
               GL11.glEnable(3553);
               GL11.glDepthMask(true);
               var14.func_78276_b(var13, -var14.func_78256_a(var13) / 2, 0, 553648127);
               GL11.glEnable(2896);
               GL11.glDisable(3042);
               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
               GL11.glPopMatrix();
            } else {
               this.func_147906_a(p_147914_1_, var13, p_147914_2_, p_147914_4_, p_147914_6_, 64);
            }
         }
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntityItemFrame)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityItemFrame)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

}
