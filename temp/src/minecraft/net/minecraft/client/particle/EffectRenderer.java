package net.minecraft.client.particle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EntityDiggingFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class EffectRenderer {

   private static final ResourceLocation field_110737_b = new ResourceLocation("textures/particle/particles.png");
   protected World field_78878_a;
   private List[] field_78876_b = new List[4];
   private TextureManager field_78877_c;
   private Random field_78875_d = new Random();
   private static final String __OBFID = "CL_00000915";


   public EffectRenderer(World p_i1220_1_, TextureManager p_i1220_2_) {
      if(p_i1220_1_ != null) {
         this.field_78878_a = p_i1220_1_;
      }

      this.field_78877_c = p_i1220_2_;

      for(int var3 = 0; var3 < 4; ++var3) {
         this.field_78876_b[var3] = new ArrayList();
      }

   }

   public void func_78873_a(EntityFX p_78873_1_) {
      int var2 = p_78873_1_.func_70537_b();
      if(this.field_78876_b[var2].size() >= 4000) {
         this.field_78876_b[var2].remove(0);
      }

      this.field_78876_b[var2].add(p_78873_1_);
   }

   public void func_78868_a() {
      for(final int var1 = 0; var1 < 4; ++var1) {
         for(int var2 = 0; var2 < this.field_78876_b[var1].size(); ++var2) {
            final EntityFX var3 = (EntityFX)this.field_78876_b[var1].get(var2);

            try {
               var3.func_70071_h_();
            } catch (Throwable var8) {
               CrashReport var5 = CrashReport.func_85055_a(var8, "Ticking Particle");
               CrashReportCategory var6 = var5.func_85058_a("Particle being ticked");
               var6.func_71500_a("Particle", new Callable() {

                  private static final String __OBFID = "CL_00000916";

                  public String call() {
                     return var3.toString();
                  }
                  // $FF: synthetic method
                  public Object call() {
                     return this.call();
                  }
               });
               var6.func_71500_a("Particle Type", new Callable() {

                  private static final String __OBFID = "CL_00000917";

                  public String call() {
                     return var1 == 0?"MISC_TEXTURE":(var1 == 1?"TERRAIN_TEXTURE":(var1 == 2?"ITEM_TEXTURE":(var1 == 3?"ENTITY_PARTICLE_TEXTURE":"Unknown - " + var1)));
                  }
                  // $FF: synthetic method
                  public Object call() {
                     return this.call();
                  }
               });
               throw new ReportedException(var5);
            }

            if(var3.field_70128_L) {
               this.field_78876_b[var1].remove(var2--);
            }
         }
      }

   }

   public void func_78874_a(Entity p_78874_1_, float p_78874_2_) {
      float var3 = ActiveRenderInfo.field_74588_d;
      float var4 = ActiveRenderInfo.field_74586_f;
      float var5 = ActiveRenderInfo.field_74587_g;
      float var6 = ActiveRenderInfo.field_74596_h;
      float var7 = ActiveRenderInfo.field_74589_e;
      EntityFX.field_70556_an = p_78874_1_.field_70142_S + (p_78874_1_.field_70165_t - p_78874_1_.field_70142_S) * (double)p_78874_2_;
      EntityFX.field_70554_ao = p_78874_1_.field_70137_T + (p_78874_1_.field_70163_u - p_78874_1_.field_70137_T) * (double)p_78874_2_;
      EntityFX.field_70555_ap = p_78874_1_.field_70136_U + (p_78874_1_.field_70161_v - p_78874_1_.field_70136_U) * (double)p_78874_2_;

      for(final int var8 = 0; var8 < 3; ++var8) {
         if(!this.field_78876_b[var8].isEmpty()) {
            switch(var8) {
            case 0:
            default:
               this.field_78877_c.func_110577_a(field_110737_b);
               break;
            case 1:
               this.field_78877_c.func_110577_a(TextureMap.field_110575_b);
               break;
            case 2:
               this.field_78877_c.func_110577_a(TextureMap.field_110576_c);
            }

            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDepthMask(false);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glAlphaFunc(516, 0.003921569F);
            Tessellator var9 = Tessellator.field_78398_a;
            var9.func_78382_b();

            for(int var10 = 0; var10 < this.field_78876_b[var8].size(); ++var10) {
               final EntityFX var11 = (EntityFX)this.field_78876_b[var8].get(var10);
               var9.func_78380_c(var11.func_70070_b(p_78874_2_));

               try {
                  var11.func_70539_a(var9, p_78874_2_, var3, var7, var4, var5, var6);
               } catch (Throwable var16) {
                  CrashReport var13 = CrashReport.func_85055_a(var16, "Rendering Particle");
                  CrashReportCategory var14 = var13.func_85058_a("Particle being rendered");
                  var14.func_71500_a("Particle", new Callable() {

                     private static final String __OBFID = "CL_00000918";

                     public String call() {
                        return var11.toString();
                     }
                     // $FF: synthetic method
                     public Object call() {
                        return this.call();
                     }
                  });
                  var14.func_71500_a("Particle Type", new Callable() {

                     private static final String __OBFID = "CL_00000919";

                     public String call() {
                        return var8 == 0?"MISC_TEXTURE":(var8 == 1?"TERRAIN_TEXTURE":(var8 == 2?"ITEM_TEXTURE":(var8 == 3?"ENTITY_PARTICLE_TEXTURE":"Unknown - " + var8)));
                     }
                     // $FF: synthetic method
                     public Object call() {
                        return this.call();
                     }
                  });
                  throw new ReportedException(var13);
               }
            }

            var9.func_78381_a();
            GL11.glDisable(3042);
            GL11.glDepthMask(true);
            GL11.glAlphaFunc(516, 0.1F);
         }
      }

   }

   public void func_78872_b(Entity p_78872_1_, float p_78872_2_) {
      float var3 = 0.017453292F;
      float var4 = MathHelper.func_76134_b(p_78872_1_.field_70177_z * 0.017453292F);
      float var5 = MathHelper.func_76126_a(p_78872_1_.field_70177_z * 0.017453292F);
      float var6 = -var5 * MathHelper.func_76126_a(p_78872_1_.field_70125_A * 0.017453292F);
      float var7 = var4 * MathHelper.func_76126_a(p_78872_1_.field_70125_A * 0.017453292F);
      float var8 = MathHelper.func_76134_b(p_78872_1_.field_70125_A * 0.017453292F);
      byte var9 = 3;
      List var10 = this.field_78876_b[var9];
      if(!var10.isEmpty()) {
         Tessellator var11 = Tessellator.field_78398_a;

         for(int var12 = 0; var12 < var10.size(); ++var12) {
            EntityFX var13 = (EntityFX)var10.get(var12);
            var11.func_78380_c(var13.func_70070_b(p_78872_2_));
            var13.func_70539_a(var11, p_78872_2_, var4, var8, var5, var6, var7);
         }

      }
   }

   public void func_78870_a(World p_78870_1_) {
      this.field_78878_a = p_78870_1_;

      for(int var2 = 0; var2 < 4; ++var2) {
         this.field_78876_b[var2].clear();
      }

   }

   public void func_147215_a(int p_147215_1_, int p_147215_2_, int p_147215_3_, Block p_147215_4_, int p_147215_5_) {
      if(p_147215_4_.func_149688_o() != Material.field_151579_a) {
         byte var6 = 4;

         for(int var7 = 0; var7 < var6; ++var7) {
            for(int var8 = 0; var8 < var6; ++var8) {
               for(int var9 = 0; var9 < var6; ++var9) {
                  double var10 = (double)p_147215_1_ + ((double)var7 + 0.5D) / (double)var6;
                  double var12 = (double)p_147215_2_ + ((double)var8 + 0.5D) / (double)var6;
                  double var14 = (double)p_147215_3_ + ((double)var9 + 0.5D) / (double)var6;
                  this.func_78873_a((new EntityDiggingFX(this.field_78878_a, var10, var12, var14, var10 - (double)p_147215_1_ - 0.5D, var12 - (double)p_147215_2_ - 0.5D, var14 - (double)p_147215_3_ - 0.5D, p_147215_4_, p_147215_5_)).func_70596_a(p_147215_1_, p_147215_2_, p_147215_3_));
               }
            }
         }

      }
   }

   public void func_78867_a(int p_78867_1_, int p_78867_2_, int p_78867_3_, int p_78867_4_) {
      Block var5 = this.field_78878_a.func_147439_a(p_78867_1_, p_78867_2_, p_78867_3_);
      if(var5.func_149688_o() != Material.field_151579_a) {
         float var6 = 0.1F;
         double var7 = (double)p_78867_1_ + this.field_78875_d.nextDouble() * (var5.func_149753_y() - var5.func_149704_x() - (double)(var6 * 2.0F)) + (double)var6 + var5.func_149704_x();
         double var9 = (double)p_78867_2_ + this.field_78875_d.nextDouble() * (var5.func_149669_A() - var5.func_149665_z() - (double)(var6 * 2.0F)) + (double)var6 + var5.func_149665_z();
         double var11 = (double)p_78867_3_ + this.field_78875_d.nextDouble() * (var5.func_149693_C() - var5.func_149706_B() - (double)(var6 * 2.0F)) + (double)var6 + var5.func_149706_B();
         if(p_78867_4_ == 0) {
            var9 = (double)p_78867_2_ + var5.func_149665_z() - (double)var6;
         }

         if(p_78867_4_ == 1) {
            var9 = (double)p_78867_2_ + var5.func_149669_A() + (double)var6;
         }

         if(p_78867_4_ == 2) {
            var11 = (double)p_78867_3_ + var5.func_149706_B() - (double)var6;
         }

         if(p_78867_4_ == 3) {
            var11 = (double)p_78867_3_ + var5.func_149693_C() + (double)var6;
         }

         if(p_78867_4_ == 4) {
            var7 = (double)p_78867_1_ + var5.func_149704_x() - (double)var6;
         }

         if(p_78867_4_ == 5) {
            var7 = (double)p_78867_1_ + var5.func_149753_y() + (double)var6;
         }

         this.func_78873_a((new EntityDiggingFX(this.field_78878_a, var7, var9, var11, 0.0D, 0.0D, 0.0D, var5, this.field_78878_a.func_72805_g(p_78867_1_, p_78867_2_, p_78867_3_))).func_70596_a(p_78867_1_, p_78867_2_, p_78867_3_).func_70543_e(0.2F).func_70541_f(0.6F));
      }
   }

   public String func_78869_b() {
      return "" + (this.field_78876_b[0].size() + this.field_78876_b[1].size() + this.field_78876_b[2].size());
   }

}
