package net.minecraft.client.renderer.entity;

import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;
import java.util.Map;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;
import org.lwjgl.opengl.GL11;

public class RenderBiped extends RenderLiving {

   protected ModelBiped field_77071_a;
   protected float field_77070_b;
   protected ModelBiped field_82423_g;
   protected ModelBiped field_82425_h;
   private static final Map field_110859_k = Maps.newHashMap();
   private static final String[] field_82424_k = new String[]{"leather", "chainmail", "iron", "diamond", "gold"};
   private static final String __OBFID = "CL_00001001";


   public RenderBiped(ModelBiped p_i1257_1_, float p_i1257_2_) {
      this(p_i1257_1_, p_i1257_2_, 1.0F);
   }

   public RenderBiped(ModelBiped p_i1258_1_, float p_i1258_2_, float p_i1258_3_) {
      super(p_i1258_1_, p_i1258_2_);
      this.field_77071_a = p_i1258_1_;
      this.field_77070_b = p_i1258_3_;
      this.func_82421_b();
   }

   protected void func_82421_b() {
      this.field_82423_g = new ModelBiped(1.0F);
      this.field_82425_h = new ModelBiped(0.5F);
   }

   public static ResourceLocation func_110857_a(ItemArmor p_110857_0_, int p_110857_1_) {
      return func_110858_a(p_110857_0_, p_110857_1_, (String)null);
   }

   public static ResourceLocation func_110858_a(ItemArmor p_110858_0_, int p_110858_1_, String p_110858_2_) {
      String var3 = String.format("textures/models/armor/%s_layer_%d%s.png", new Object[]{field_82424_k[p_110858_0_.field_77880_c], Integer.valueOf(p_110858_1_ == 2?2:1), p_110858_2_ == null?"":String.format("_%s", new Object[]{p_110858_2_})});
      ResourceLocation var4 = (ResourceLocation)field_110859_k.get(var3);
      if(var4 == null) {
         var4 = new ResourceLocation(var3);
         field_110859_k.put(var3, var4);
      }

      return var4;
   }

   protected int func_77032_a(EntityLiving p_77032_1_, int p_77032_2_, float p_77032_3_) {
      ItemStack var4 = p_77032_1_.func_130225_q(3 - p_77032_2_);
      if(var4 != null) {
         Item var5 = var4.func_77973_b();
         if(var5 instanceof ItemArmor) {
            ItemArmor var6 = (ItemArmor)var5;
            this.func_110776_a(func_110857_a(var6, p_77032_2_));
            ModelBiped var7 = p_77032_2_ == 2?this.field_82425_h:this.field_82423_g;
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

   protected void func_82408_c(EntityLiving p_82408_1_, int p_82408_2_, float p_82408_3_) {
      ItemStack var4 = p_82408_1_.func_130225_q(3 - p_82408_2_);
      if(var4 != null) {
         Item var5 = var4.func_77973_b();
         if(var5 instanceof ItemArmor) {
            this.func_110776_a(func_110858_a((ItemArmor)var5, p_82408_2_, "overlay"));
            float var6 = 1.0F;
            GL11.glColor3f(1.0F, 1.0F, 1.0F);
         }
      }

   }

   public void func_76986_a(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      GL11.glColor3f(1.0F, 1.0F, 1.0F);
      ItemStack var10 = p_76986_1_.func_70694_bm();
      this.func_82420_a(p_76986_1_, var10);
      double var11 = p_76986_4_ - (double)p_76986_1_.field_70129_M;
      if(p_76986_1_.func_70093_af()) {
         var11 -= 0.125D;
      }

      super.func_76986_a(p_76986_1_, p_76986_2_, var11, p_76986_6_, p_76986_8_, p_76986_9_);
      this.field_82423_g.field_78118_o = this.field_82425_h.field_78118_o = this.field_77071_a.field_78118_o = false;
      this.field_82423_g.field_78117_n = this.field_82425_h.field_78117_n = this.field_77071_a.field_78117_n = false;
      this.field_82423_g.field_78120_m = this.field_82425_h.field_78120_m = this.field_77071_a.field_78120_m = 0;
   }

   protected ResourceLocation func_110775_a(EntityLiving p_110775_1_) {
      return null;
   }

   protected void func_82420_a(EntityLiving p_82420_1_, ItemStack p_82420_2_) {
      this.field_82423_g.field_78120_m = this.field_82425_h.field_78120_m = this.field_77071_a.field_78120_m = p_82420_2_ != null?1:0;
      this.field_82423_g.field_78117_n = this.field_82425_h.field_78117_n = this.field_77071_a.field_78117_n = p_82420_1_.func_70093_af();
   }

   protected void func_77029_c(EntityLiving p_77029_1_, float p_77029_2_) {
      GL11.glColor3f(1.0F, 1.0F, 1.0F);
      super.func_77029_c(p_77029_1_, p_77029_2_);
      ItemStack var3 = p_77029_1_.func_70694_bm();
      ItemStack var4 = p_77029_1_.func_130225_q(3);
      Item var5;
      float var6;
      if(var4 != null) {
         GL11.glPushMatrix();
         this.field_77071_a.field_78116_c.func_78794_c(0.0625F);
         var5 = var4.func_77973_b();
         if(var5 instanceof ItemBlock) {
            if(RenderBlocks.func_147739_a(Block.func_149634_a(var5).func_149645_b())) {
               var6 = 0.625F;
               GL11.glTranslatef(0.0F, -0.25F, 0.0F);
               GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
               GL11.glScalef(var6, -var6, -var6);
            }

            this.field_76990_c.field_78721_f.func_78443_a(p_77029_1_, var4, 0);
         } else if(var5 == Items.field_151144_bL) {
            var6 = 1.0625F;
            GL11.glScalef(var6, -var6, -var6);
            GameProfile var7 = null;
            if(var4.func_77942_o()) {
               NBTTagCompound var8 = var4.func_77978_p();
               if(var8.func_150297_b("SkullOwner", 10)) {
                  var7 = NBTUtil.func_152459_a(var8.func_74775_l("SkullOwner"));
               } else if(var8.func_150297_b("SkullOwner", 8) && !StringUtils.func_151246_b(var8.func_74779_i("SkullOwner"))) {
                  var7 = new GameProfile((UUID)null, var8.func_74779_i("SkullOwner"));
               }
            }

            TileEntitySkullRenderer.field_147536_b.func_152674_a(-0.5F, 0.0F, -0.5F, 1, 180.0F, var4.func_77960_j(), var7);
         }

         GL11.glPopMatrix();
      }

      if(var3 != null && var3.func_77973_b() != null) {
         var5 = var3.func_77973_b();
         GL11.glPushMatrix();
         if(this.field_77045_g.field_78091_s) {
            var6 = 0.5F;
            GL11.glTranslatef(0.0F, 0.625F, 0.0F);
            GL11.glRotatef(-20.0F, -1.0F, 0.0F, 0.0F);
            GL11.glScalef(var6, var6, var6);
         }

         this.field_77071_a.field_78112_f.func_78794_c(0.0625F);
         GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
         if(var5 instanceof ItemBlock && RenderBlocks.func_147739_a(Block.func_149634_a(var5).func_149645_b())) {
            var6 = 0.5F;
            GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
            var6 *= 0.75F;
            GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(-var6, -var6, var6);
         } else if(var5 == Items.field_151031_f) {
            var6 = 0.625F;
            GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
            GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(var6, -var6, var6);
            GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         } else if(var5.func_77662_d()) {
            var6 = 0.625F;
            if(var5.func_77629_n_()) {
               GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
               GL11.glTranslatef(0.0F, -0.125F, 0.0F);
            }

            this.func_82422_c();
            GL11.glScalef(var6, -var6, var6);
            GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         } else {
            var6 = 0.375F;
            GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
            GL11.glScalef(var6, var6, var6);
            GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
         }

         float var9;
         int var11;
         float var14;
         if(var3.func_77973_b().func_77623_v()) {
            for(var11 = 0; var11 <= 1; ++var11) {
               int var12 = var3.func_77973_b().func_82790_a(var3, var11);
               var14 = (float)(var12 >> 16 & 255) / 255.0F;
               var9 = (float)(var12 >> 8 & 255) / 255.0F;
               float var10 = (float)(var12 & 255) / 255.0F;
               GL11.glColor4f(var14, var9, var10, 1.0F);
               this.field_76990_c.field_78721_f.func_78443_a(p_77029_1_, var3, var11);
            }
         } else {
            var11 = var3.func_77973_b().func_82790_a(var3, 0);
            float var13 = (float)(var11 >> 16 & 255) / 255.0F;
            var14 = (float)(var11 >> 8 & 255) / 255.0F;
            var9 = (float)(var11 & 255) / 255.0F;
            GL11.glColor4f(var13, var14, var9, 1.0F);
            this.field_76990_c.field_78721_f.func_78443_a(p_77029_1_, var3, 0);
         }

         GL11.glPopMatrix();
      }

   }

   protected void func_82422_c() {
      GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
   }

   // $FF: synthetic method
   protected void func_82408_c(EntityLivingBase p_82408_1_, int p_82408_2_, float p_82408_3_) {
      this.func_82408_c((EntityLiving)p_82408_1_, p_82408_2_, p_82408_3_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_77032_a(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
      return this.func_77032_a((EntityLiving)p_77032_1_, p_77032_2_, p_77032_3_);
   }

   // $FF: synthetic method
   protected void func_77029_c(EntityLivingBase p_77029_1_, float p_77029_2_) {
      this.func_77029_c((EntityLiving)p_77029_1_, p_77029_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntityLiving)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

}
