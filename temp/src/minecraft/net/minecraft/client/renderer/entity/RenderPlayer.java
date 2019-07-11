package net.minecraft.client.renderer.entity;

import com.mojang.authlib.GameProfile;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;
import org.lwjgl.opengl.GL11;

public class RenderPlayer extends RendererLivingEntity {

   private static final ResourceLocation field_110826_a = new ResourceLocation("textures/entity/steve.png");
   private ModelBiped field_77109_a;
   private ModelBiped field_77108_b;
   private ModelBiped field_77111_i;
   private static final String __OBFID = "CL_00001020";


   public RenderPlayer() {
      super(new ModelBiped(0.0F), 0.5F);
      this.field_77109_a = (ModelBiped)this.field_77045_g;
      this.field_77108_b = new ModelBiped(1.0F);
      this.field_77111_i = new ModelBiped(0.5F);
   }

   protected int func_77032_a(AbstractClientPlayer p_77032_1_, int p_77032_2_, float p_77032_3_) {
      ItemStack var4 = p_77032_1_.field_71071_by.func_70440_f(3 - p_77032_2_);
      if(var4 != null) {
         Item var5 = var4.func_77973_b();
         if(var5 instanceof ItemArmor) {
            ItemArmor var6 = (ItemArmor)var5;
            this.func_110776_a(RenderBiped.func_110857_a(var6, p_77032_2_));
            ModelBiped var7 = p_77032_2_ == 2?this.field_77111_i:this.field_77108_b;
            var7.field_78116_c.field_78806_j = p_77032_2_ == 0;
            var7.field_78114_d.field_78806_j = p_77032_2_ == 0;
            var7.field_78115_e.field_78806_j = p_77032_2_ == 1 || p_77032_2_ == 2;
            var7.field_78112_f.field_78806_j = p_77032_2_ == 1;
            var7.field_78113_g.field_78806_j = p_77032_2_ == 1;
            var7.field_78123_h.field_78806_j = p_77032_2_ == 2 || p_77032_2_ == 3;
            var7.field_78124_i.field_78806_j = p_77032_2_ == 2 || p_77032_2_ == 3;
            this.func_77042_a(var7);
            var7.field_78095_p = this.field_77045_g.field_78095_p;
            var7.field_78093_q = this.field_77045_g.field_78093_q;
            var7.field_78091_s = this.field_77045_g.field_78091_s;
            if(var6.func_82812_d() == ItemArmor.ArmorMaterial.CLOTH) {
               int var8 = var6.func_82814_b(var4);
               float var9 = (float)(var8 >> 16 & 255) / 255.0F;
               float var10 = (float)(var8 >> 8 & 255) / 255.0F;
               float var11 = (float)(var8 & 255) / 255.0F;
               GL11.glColor3f(var9, var10, var11);
               if(var4.func_77948_v()) {
                  return 31;
               }

               return 16;
            }

            GL11.glColor3f(1.0F, 1.0F, 1.0F);
            if(var4.func_77948_v()) {
               return 15;
            }

            return 1;
         }
      }

      return -1;
   }

   protected void func_82408_c(AbstractClientPlayer p_82408_1_, int p_82408_2_, float p_82408_3_) {
      ItemStack var4 = p_82408_1_.field_71071_by.func_70440_f(3 - p_82408_2_);
      if(var4 != null) {
         Item var5 = var4.func_77973_b();
         if(var5 instanceof ItemArmor) {
            this.func_110776_a(RenderBiped.func_110858_a((ItemArmor)var5, p_82408_2_, "overlay"));
            GL11.glColor3f(1.0F, 1.0F, 1.0F);
         }
      }

   }

   public void func_76986_a(AbstractClientPlayer p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      GL11.glColor3f(1.0F, 1.0F, 1.0F);
      ItemStack var10 = p_76986_1_.field_71071_by.func_70448_g();
      this.field_77108_b.field_78120_m = this.field_77111_i.field_78120_m = this.field_77109_a.field_78120_m = var10 != null?1:0;
      if(var10 != null && p_76986_1_.func_71052_bv() > 0) {
         EnumAction var11 = var10.func_77975_n();
         if(var11 == EnumAction.block) {
            this.field_77108_b.field_78120_m = this.field_77111_i.field_78120_m = this.field_77109_a.field_78120_m = 3;
         } else if(var11 == EnumAction.bow) {
            this.field_77108_b.field_78118_o = this.field_77111_i.field_78118_o = this.field_77109_a.field_78118_o = true;
         }
      }

      this.field_77108_b.field_78117_n = this.field_77111_i.field_78117_n = this.field_77109_a.field_78117_n = p_76986_1_.func_70093_af();
      double var13 = p_76986_4_ - (double)p_76986_1_.field_70129_M;
      if(p_76986_1_.func_70093_af() && !(p_76986_1_ instanceof EntityPlayerSP)) {
         var13 -= 0.125D;
      }

      super.func_76986_a((EntityLivingBase)p_76986_1_, p_76986_2_, var13, p_76986_6_, p_76986_8_, p_76986_9_);
      this.field_77108_b.field_78118_o = this.field_77111_i.field_78118_o = this.field_77109_a.field_78118_o = false;
      this.field_77108_b.field_78117_n = this.field_77111_i.field_78117_n = this.field_77109_a.field_78117_n = false;
      this.field_77108_b.field_78120_m = this.field_77111_i.field_78120_m = this.field_77109_a.field_78120_m = 0;
   }

   protected ResourceLocation func_110775_a(AbstractClientPlayer p_110775_1_) {
      return p_110775_1_.func_110306_p();
   }

   protected void func_77029_c(AbstractClientPlayer p_77029_1_, float p_77029_2_) {
      GL11.glColor3f(1.0F, 1.0F, 1.0F);
      super.func_77029_c(p_77029_1_, p_77029_2_);
      super.func_85093_e(p_77029_1_, p_77029_2_);
      ItemStack var3 = p_77029_1_.field_71071_by.func_70440_f(3);
      if(var3 != null) {
         GL11.glPushMatrix();
         this.field_77109_a.field_78116_c.func_78794_c(0.0625F);
         float var4;
         if(var3.func_77973_b() instanceof ItemBlock) {
            if(RenderBlocks.func_147739_a(Block.func_149634_a(var3.func_77973_b()).func_149645_b())) {
               var4 = 0.625F;
               GL11.glTranslatef(0.0F, -0.25F, 0.0F);
               GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
               GL11.glScalef(var4, -var4, -var4);
            }

            this.field_76990_c.field_78721_f.func_78443_a(p_77029_1_, var3, 0);
         } else if(var3.func_77973_b() == Items.field_151144_bL) {
            var4 = 1.0625F;
            GL11.glScalef(var4, -var4, -var4);
            GameProfile var5 = null;
            if(var3.func_77942_o()) {
               NBTTagCompound var6 = var3.func_77978_p();
               if(var6.func_150297_b("SkullOwner", 10)) {
                  var5 = NBTUtil.func_152459_a(var6.func_74775_l("SkullOwner"));
               } else if(var6.func_150297_b("SkullOwner", 8) && !StringUtils.func_151246_b(var6.func_74779_i("SkullOwner"))) {
                  var5 = new GameProfile((UUID)null, var6.func_74779_i("SkullOwner"));
               }
            }

            TileEntitySkullRenderer.field_147536_b.func_152674_a(-0.5F, 0.0F, -0.5F, 1, 180.0F, var3.func_77960_j(), var5);
         }

         GL11.glPopMatrix();
      }

      float var7;
      if(p_77029_1_.func_70005_c_().equals("deadmau5") && p_77029_1_.func_152123_o()) {
         this.func_110776_a(p_77029_1_.func_110306_p());

         for(int var20 = 0; var20 < 2; ++var20) {
            float var22 = p_77029_1_.field_70126_B + (p_77029_1_.field_70177_z - p_77029_1_.field_70126_B) * p_77029_2_ - (p_77029_1_.field_70760_ar + (p_77029_1_.field_70761_aq - p_77029_1_.field_70760_ar) * p_77029_2_);
            float var25 = p_77029_1_.field_70127_C + (p_77029_1_.field_70125_A - p_77029_1_.field_70127_C) * p_77029_2_;
            GL11.glPushMatrix();
            GL11.glRotatef(var22, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(var25, 1.0F, 0.0F, 0.0F);
            GL11.glTranslatef(0.375F * (float)(var20 * 2 - 1), 0.0F, 0.0F);
            GL11.glTranslatef(0.0F, -0.375F, 0.0F);
            GL11.glRotatef(-var25, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(-var22, 0.0F, 1.0F, 0.0F);
            var7 = 1.3333334F;
            GL11.glScalef(var7, var7, var7);
            this.field_77109_a.func_78110_b(0.0625F);
            GL11.glPopMatrix();
         }
      }

      boolean var21 = p_77029_1_.func_152122_n();
      float var11;
      if(var21 && !p_77029_1_.func_82150_aj() && !p_77029_1_.func_82238_cc()) {
         this.func_110776_a(p_77029_1_.func_110303_q());
         GL11.glPushMatrix();
         GL11.glTranslatef(0.0F, 0.0F, 0.125F);
         double var23 = p_77029_1_.field_71091_bM + (p_77029_1_.field_71094_bP - p_77029_1_.field_71091_bM) * (double)p_77029_2_ - (p_77029_1_.field_70169_q + (p_77029_1_.field_70165_t - p_77029_1_.field_70169_q) * (double)p_77029_2_);
         double var27 = p_77029_1_.field_71096_bN + (p_77029_1_.field_71095_bQ - p_77029_1_.field_71096_bN) * (double)p_77029_2_ - (p_77029_1_.field_70167_r + (p_77029_1_.field_70163_u - p_77029_1_.field_70167_r) * (double)p_77029_2_);
         double var9 = p_77029_1_.field_71097_bO + (p_77029_1_.field_71085_bR - p_77029_1_.field_71097_bO) * (double)p_77029_2_ - (p_77029_1_.field_70166_s + (p_77029_1_.field_70161_v - p_77029_1_.field_70166_s) * (double)p_77029_2_);
         var11 = p_77029_1_.field_70760_ar + (p_77029_1_.field_70761_aq - p_77029_1_.field_70760_ar) * p_77029_2_;
         double var12 = (double)MathHelper.func_76126_a(var11 * 3.1415927F / 180.0F);
         double var14 = (double)(-MathHelper.func_76134_b(var11 * 3.1415927F / 180.0F));
         float var16 = (float)var27 * 10.0F;
         if(var16 < -6.0F) {
            var16 = -6.0F;
         }

         if(var16 > 32.0F) {
            var16 = 32.0F;
         }

         float var17 = (float)(var23 * var12 + var9 * var14) * 100.0F;
         float var18 = (float)(var23 * var14 - var9 * var12) * 100.0F;
         if(var17 < 0.0F) {
            var17 = 0.0F;
         }

         float var19 = p_77029_1_.field_71107_bF + (p_77029_1_.field_71109_bG - p_77029_1_.field_71107_bF) * p_77029_2_;
         var16 += MathHelper.func_76126_a((p_77029_1_.field_70141_P + (p_77029_1_.field_70140_Q - p_77029_1_.field_70141_P) * p_77029_2_) * 6.0F) * 32.0F * var19;
         if(p_77029_1_.func_70093_af()) {
            var16 += 25.0F;
         }

         GL11.glRotatef(6.0F + var17 / 2.0F + var16, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(var18 / 2.0F, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(-var18 / 2.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
         this.field_77109_a.func_78111_c(0.0625F);
         GL11.glPopMatrix();
      }

      ItemStack var24 = p_77029_1_.field_71071_by.func_70448_g();
      if(var24 != null) {
         GL11.glPushMatrix();
         this.field_77109_a.field_78112_f.func_78794_c(0.0625F);
         GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
         if(p_77029_1_.field_71104_cf != null) {
            var24 = new ItemStack(Items.field_151055_y);
         }

         EnumAction var26 = null;
         if(p_77029_1_.func_71052_bv() > 0) {
            var26 = var24.func_77975_n();
         }

         if(var24.func_77973_b() instanceof ItemBlock && RenderBlocks.func_147739_a(Block.func_149634_a(var24.func_77973_b()).func_149645_b())) {
            var7 = 0.5F;
            GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
            var7 *= 0.75F;
            GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(-var7, -var7, var7);
         } else if(var24.func_77973_b() == Items.field_151031_f) {
            var7 = 0.625F;
            GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
            GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(var7, -var7, var7);
            GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         } else if(var24.func_77973_b().func_77662_d()) {
            var7 = 0.625F;
            if(var24.func_77973_b().func_77629_n_()) {
               GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
               GL11.glTranslatef(0.0F, -0.125F, 0.0F);
            }

            if(p_77029_1_.func_71052_bv() > 0 && var26 == EnumAction.block) {
               GL11.glTranslatef(0.05F, 0.0F, -0.1F);
               GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(-10.0F, 1.0F, 0.0F, 0.0F);
               GL11.glRotatef(-60.0F, 0.0F, 0.0F, 1.0F);
            }

            GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
            GL11.glScalef(var7, -var7, var7);
            GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         } else {
            var7 = 0.375F;
            GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
            GL11.glScalef(var7, var7, var7);
            GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
         }

         float var10;
         int var28;
         float var30;
         if(var24.func_77973_b().func_77623_v()) {
            for(var28 = 0; var28 <= 1; ++var28) {
               int var8 = var24.func_77973_b().func_82790_a(var24, var28);
               var30 = (float)(var8 >> 16 & 255) / 255.0F;
               var10 = (float)(var8 >> 8 & 255) / 255.0F;
               var11 = (float)(var8 & 255) / 255.0F;
               GL11.glColor4f(var30, var10, var11, 1.0F);
               this.field_76990_c.field_78721_f.func_78443_a(p_77029_1_, var24, var28);
            }
         } else {
            var28 = var24.func_77973_b().func_82790_a(var24, 0);
            float var29 = (float)(var28 >> 16 & 255) / 255.0F;
            var30 = (float)(var28 >> 8 & 255) / 255.0F;
            var10 = (float)(var28 & 255) / 255.0F;
            GL11.glColor4f(var29, var30, var10, 1.0F);
            this.field_76990_c.field_78721_f.func_78443_a(p_77029_1_, var24, 0);
         }

         GL11.glPopMatrix();
      }

   }

   protected void func_77041_b(AbstractClientPlayer p_77041_1_, float p_77041_2_) {
      float var3 = 0.9375F;
      GL11.glScalef(var3, var3, var3);
   }

   protected void func_96449_a(AbstractClientPlayer p_96449_1_, double p_96449_2_, double p_96449_4_, double p_96449_6_, String p_96449_8_, float p_96449_9_, double p_96449_10_) {
      if(p_96449_10_ < 100.0D) {
         Scoreboard var12 = p_96449_1_.func_96123_co();
         ScoreObjective var13 = var12.func_96539_a(2);
         if(var13 != null) {
            Score var14 = var12.func_96529_a(p_96449_1_.func_70005_c_(), var13);
            if(p_96449_1_.func_70608_bn()) {
               this.func_147906_a(p_96449_1_, var14.func_96652_c() + " " + var13.func_96678_d(), p_96449_2_, p_96449_4_ - 1.5D, p_96449_6_, 64);
            } else {
               this.func_147906_a(p_96449_1_, var14.func_96652_c() + " " + var13.func_96678_d(), p_96449_2_, p_96449_4_, p_96449_6_, 64);
            }

            p_96449_4_ += (double)((float)this.func_76983_a().field_78288_b * 1.15F * p_96449_9_);
         }
      }

      super.func_96449_a(p_96449_1_, p_96449_2_, p_96449_4_, p_96449_6_, p_96449_8_, p_96449_9_, p_96449_10_);
   }

   public void func_82441_a(EntityPlayer p_82441_1_) {
      float var2 = 1.0F;
      GL11.glColor3f(var2, var2, var2);
      this.field_77109_a.field_78095_p = 0.0F;
      this.field_77109_a.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, p_82441_1_);
      this.field_77109_a.field_78112_f.func_78785_a(0.0625F);
   }

   protected void func_77039_a(AbstractClientPlayer p_77039_1_, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
      if(p_77039_1_.func_70089_S() && p_77039_1_.func_70608_bn()) {
         super.func_77039_a(p_77039_1_, p_77039_2_ + (double)p_77039_1_.field_71079_bU, p_77039_4_ + (double)p_77039_1_.field_71082_cx, p_77039_6_ + (double)p_77039_1_.field_71089_bV);
      } else {
         super.func_77039_a(p_77039_1_, p_77039_2_, p_77039_4_, p_77039_6_);
      }

   }

   protected void func_77043_a(AbstractClientPlayer p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
      if(p_77043_1_.func_70089_S() && p_77043_1_.func_70608_bn()) {
         GL11.glRotatef(p_77043_1_.func_71051_bG(), 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(this.func_77037_a(p_77043_1_), 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(270.0F, 0.0F, 1.0F, 0.0F);
      } else {
         super.func_77043_a(p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_96449_a(EntityLivingBase p_96449_1_, double p_96449_2_, double p_96449_4_, double p_96449_6_, String p_96449_8_, float p_96449_9_, double p_96449_10_) {
      this.func_96449_a((AbstractClientPlayer)p_96449_1_, p_96449_2_, p_96449_4_, p_96449_6_, p_96449_8_, p_96449_9_, p_96449_10_);
   }

   // $FF: synthetic method
   protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
      this.func_77041_b((AbstractClientPlayer)p_77041_1_, p_77041_2_);
   }

   // $FF: synthetic method
   protected void func_82408_c(EntityLivingBase p_82408_1_, int p_82408_2_, float p_82408_3_) {
      this.func_82408_c((AbstractClientPlayer)p_82408_1_, p_82408_2_, p_82408_3_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_77032_a(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
      return this.func_77032_a((AbstractClientPlayer)p_77032_1_, p_77032_2_, p_77032_3_);
   }

   // $FF: synthetic method
   protected void func_77029_c(EntityLivingBase p_77029_1_, float p_77029_2_) {
      this.func_77029_c((AbstractClientPlayer)p_77029_1_, p_77029_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77043_a(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
      this.func_77043_a((AbstractClientPlayer)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77039_a(EntityLivingBase p_77039_1_, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
      this.func_77039_a((AbstractClientPlayer)p_77039_1_, p_77039_2_, p_77039_4_, p_77039_6_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((AbstractClientPlayer)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((AbstractClientPlayer)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((AbstractClientPlayer)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

}
