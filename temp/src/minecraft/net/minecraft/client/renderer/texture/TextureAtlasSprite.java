package net.minecraft.client.renderer.texture;

import com.google.common.collect.Lists;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.data.AnimationFrame;
import net.minecraft.client.resources.data.AnimationMetadataSection;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.IIcon;
import net.minecraft.util.ReportedException;

public class TextureAtlasSprite implements IIcon {

   private final String field_110984_i;
   protected List field_110976_a = Lists.newArrayList();
   private AnimationMetadataSection field_110982_k;
   protected boolean field_130222_e;
   private boolean field_147966_k;
   protected int field_110975_c;
   protected int field_110974_d;
   protected int field_130223_c;
   protected int field_130224_d;
   private float field_110979_l;
   private float field_110980_m;
   private float field_110977_n;
   private float field_110978_o;
   protected int field_110973_g;
   protected int field_110983_h;
   private static final String __OBFID = "CL_00001062";


   protected TextureAtlasSprite(String p_i1282_1_) {
      this.field_110984_i = p_i1282_1_;
   }

   public void func_110971_a(int p_110971_1_, int p_110971_2_, int p_110971_3_, int p_110971_4_, boolean p_110971_5_) {
      this.field_110975_c = p_110971_3_;
      this.field_110974_d = p_110971_4_;
      this.field_130222_e = p_110971_5_;
      float var6 = (float)(0.009999999776482582D / (double)p_110971_1_);
      float var7 = (float)(0.009999999776482582D / (double)p_110971_2_);
      this.field_110979_l = (float)p_110971_3_ / (float)((double)p_110971_1_) + var6;
      this.field_110980_m = (float)(p_110971_3_ + this.field_130223_c) / (float)((double)p_110971_1_) - var6;
      this.field_110977_n = (float)p_110971_4_ / (float)p_110971_2_ + var7;
      this.field_110978_o = (float)(p_110971_4_ + this.field_130224_d) / (float)p_110971_2_ - var7;
      if(this.field_147966_k) {
         float var8 = 8.0F / (float)p_110971_1_;
         float var9 = 8.0F / (float)p_110971_2_;
         this.field_110979_l += var8;
         this.field_110980_m -= var8;
         this.field_110977_n += var9;
         this.field_110978_o -= var9;
      }

   }

   public void func_94217_a(TextureAtlasSprite p_94217_1_) {
      this.field_110975_c = p_94217_1_.field_110975_c;
      this.field_110974_d = p_94217_1_.field_110974_d;
      this.field_130223_c = p_94217_1_.field_130223_c;
      this.field_130224_d = p_94217_1_.field_130224_d;
      this.field_130222_e = p_94217_1_.field_130222_e;
      this.field_110979_l = p_94217_1_.field_110979_l;
      this.field_110980_m = p_94217_1_.field_110980_m;
      this.field_110977_n = p_94217_1_.field_110977_n;
      this.field_110978_o = p_94217_1_.field_110978_o;
   }

   public int func_130010_a() {
      return this.field_110975_c;
   }

   public int func_110967_i() {
      return this.field_110974_d;
   }

   public int func_94211_a() {
      return this.field_130223_c;
   }

   public int func_94216_b() {
      return this.field_130224_d;
   }

   public float func_94209_e() {
      return this.field_110979_l;
   }

   public float func_94212_f() {
      return this.field_110980_m;
   }

   public float func_94214_a(double p_94214_1_) {
      float var3 = this.field_110980_m - this.field_110979_l;
      return this.field_110979_l + var3 * (float)p_94214_1_ / 16.0F;
   }

   public float func_94206_g() {
      return this.field_110977_n;
   }

   public float func_94210_h() {
      return this.field_110978_o;
   }

   public float func_94207_b(double p_94207_1_) {
      float var3 = this.field_110978_o - this.field_110977_n;
      return this.field_110977_n + var3 * ((float)p_94207_1_ / 16.0F);
   }

   public String func_94215_i() {
      return this.field_110984_i;
   }

   public void func_94219_l() {
      ++this.field_110983_h;
      if(this.field_110983_h >= this.field_110982_k.func_110472_a(this.field_110973_g)) {
         int var1 = this.field_110982_k.func_110468_c(this.field_110973_g);
         int var2 = this.field_110982_k.func_110473_c() == 0?this.field_110976_a.size():this.field_110982_k.func_110473_c();
         this.field_110973_g = (this.field_110973_g + 1) % var2;
         this.field_110983_h = 0;
         int var3 = this.field_110982_k.func_110468_c(this.field_110973_g);
         if(var1 != var3 && var3 >= 0 && var3 < this.field_110976_a.size()) {
            TextureUtil.func_147955_a((int[][])this.field_110976_a.get(var3), this.field_130223_c, this.field_130224_d, this.field_110975_c, this.field_110974_d, false, false);
         }
      }

   }

   public int[][] func_147965_a(int p_147965_1_) {
      return (int[][])this.field_110976_a.get(p_147965_1_);
   }

   public int func_110970_k() {
      return this.field_110976_a.size();
   }

   public void func_110966_b(int p_110966_1_) {
      this.field_130223_c = p_110966_1_;
   }

   public void func_110969_c(int p_110969_1_) {
      this.field_130224_d = p_110969_1_;
   }

   public void func_147964_a(BufferedImage[] p_147964_1_, AnimationMetadataSection p_147964_2_, boolean p_147964_3_) {
      this.func_130102_n();
      this.field_147966_k = p_147964_3_;
      int var4 = p_147964_1_[0].getWidth();
      int var5 = p_147964_1_[0].getHeight();
      this.field_130223_c = var4;
      this.field_130224_d = var5;
      if(p_147964_3_) {
         this.field_130223_c += 16;
         this.field_130224_d += 16;
      }

      int[][] var6 = new int[p_147964_1_.length][];

      int var7;
      for(var7 = 0; var7 < p_147964_1_.length; ++var7) {
         BufferedImage var8 = p_147964_1_[var7];
         if(var8 != null) {
            if(var7 > 0 && (var8.getWidth() != var4 >> var7 || var8.getHeight() != var5 >> var7)) {
               throw new RuntimeException(String.format("Unable to load miplevel: %d, image is size: %dx%d, expected %dx%d", new Object[]{Integer.valueOf(var7), Integer.valueOf(var8.getWidth()), Integer.valueOf(var8.getHeight()), Integer.valueOf(var4 >> var7), Integer.valueOf(var5 >> var7)}));
            }

            var6[var7] = new int[var8.getWidth() * var8.getHeight()];
            var8.getRGB(0, 0, var8.getWidth(), var8.getHeight(), var6[var7], 0, var8.getWidth());
         }
      }

      if(p_147964_2_ == null) {
         if(var5 != var4) {
            throw new RuntimeException("broken aspect ratio and not an animation");
         }

         this.func_147961_a(var6);
         this.field_110976_a.add(this.func_147960_a(var6, var4, var5));
      } else {
         var7 = var5 / var4;
         int var12 = var4;
         int var9 = var4;
         this.field_130224_d = this.field_130223_c;
         int var11;
         if(p_147964_2_.func_110473_c() > 0) {
            Iterator var10 = p_147964_2_.func_130073_e().iterator();

            while(var10.hasNext()) {
               var11 = ((Integer)var10.next()).intValue();
               if(var11 >= var7) {
                  throw new RuntimeException("invalid frameindex " + var11);
               }

               this.func_130099_d(var11);
               this.field_110976_a.set(var11, this.func_147960_a(func_147962_a(var6, var12, var9, var11), var12, var9));
            }

            this.field_110982_k = p_147964_2_;
         } else {
            ArrayList var13 = Lists.newArrayList();

            for(var11 = 0; var11 < var7; ++var11) {
               this.field_110976_a.add(this.func_147960_a(func_147962_a(var6, var12, var9, var11), var12, var9));
               var13.add(new AnimationFrame(var11, -1));
            }

            this.field_110982_k = new AnimationMetadataSection(var13, this.field_130223_c, this.field_130224_d, p_147964_2_.func_110469_d());
         }
      }

   }

   public void func_147963_d(int p_147963_1_) {
      ArrayList var2 = Lists.newArrayList();

      for(int var3 = 0; var3 < this.field_110976_a.size(); ++var3) {
         final int[][] var4 = (int[][])this.field_110976_a.get(var3);
         if(var4 != null) {
            try {
               var2.add(TextureUtil.func_147949_a(p_147963_1_, this.field_130223_c, var4));
            } catch (Throwable var8) {
               CrashReport var6 = CrashReport.func_85055_a(var8, "Generating mipmaps for frame");
               CrashReportCategory var7 = var6.func_85058_a("Frame being iterated");
               var7.func_71507_a("Frame index", Integer.valueOf(var3));
               var7.func_71500_a("Frame sizes", new Callable() {

                  private static final String __OBFID = "CL_00001063";

                  public String call() {
                     StringBuilder var1 = new StringBuilder();
                     int[][] var2 = var4;
                     int var3 = var2.length;

                     for(int var4x = 0; var4x < var3; ++var4x) {
                        int[] var5 = var2[var4x];
                        if(var1.length() > 0) {
                           var1.append(", ");
                        }

                        var1.append(var5 == null?"null":Integer.valueOf(var5.length));
                     }

                     return var1.toString();
                  }
                  // $FF: synthetic method
                  public Object call() {
                     return this.call();
                  }
               });
               throw new ReportedException(var6);
            }
         }
      }

      this.func_110968_a(var2);
   }

   private void func_147961_a(int[][] p_147961_1_) {
      int[] var2 = p_147961_1_[0];
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;

      int var7;
      for(var7 = 0; var7 < var2.length; ++var7) {
         if((var2[var7] & -16777216) != 0) {
            var4 += var2[var7] >> 16 & 255;
            var5 += var2[var7] >> 8 & 255;
            var6 += var2[var7] >> 0 & 255;
            ++var3;
         }
      }

      if(var3 != 0) {
         var4 /= var3;
         var5 /= var3;
         var6 /= var3;

         for(var7 = 0; var7 < var2.length; ++var7) {
            if((var2[var7] & -16777216) == 0) {
               var2[var7] = var4 << 16 | var5 << 8 | var6;
            }
         }

      }
   }

   private int[][] func_147960_a(int[][] p_147960_1_, int p_147960_2_, int p_147960_3_) {
      if(!this.field_147966_k) {
         return p_147960_1_;
      } else {
         int[][] var4 = new int[p_147960_1_.length][];

         for(int var5 = 0; var5 < p_147960_1_.length; ++var5) {
            int[] var6 = p_147960_1_[var5];
            if(var6 != null) {
               int[] var7 = new int[(p_147960_2_ + 16 >> var5) * (p_147960_3_ + 16 >> var5)];
               System.arraycopy(var6, 0, var7, 0, var6.length);
               var4[var5] = TextureUtil.func_147948_a(var7, p_147960_2_ >> var5, p_147960_3_ >> var5, 8 >> var5);
            }
         }

         return var4;
      }
   }

   private void func_130099_d(int p_130099_1_) {
      if(this.field_110976_a.size() <= p_130099_1_) {
         for(int var2 = this.field_110976_a.size(); var2 <= p_130099_1_; ++var2) {
            this.field_110976_a.add((Object)null);
         }

      }
   }

   private static int[][] func_147962_a(int[][] p_147962_0_, int p_147962_1_, int p_147962_2_, int p_147962_3_) {
      int[][] var4 = new int[p_147962_0_.length][];

      for(int var5 = 0; var5 < p_147962_0_.length; ++var5) {
         int[] var6 = p_147962_0_[var5];
         if(var6 != null) {
            var4[var5] = new int[(p_147962_1_ >> var5) * (p_147962_2_ >> var5)];
            System.arraycopy(var6, p_147962_3_ * var4[var5].length, var4[var5], 0, var4[var5].length);
         }
      }

      return var4;
   }

   public void func_130103_l() {
      this.field_110976_a.clear();
   }

   public boolean func_130098_m() {
      return this.field_110982_k != null;
   }

   public void func_110968_a(List p_110968_1_) {
      this.field_110976_a = p_110968_1_;
   }

   private void func_130102_n() {
      this.field_110982_k = null;
      this.func_110968_a(Lists.newArrayList());
      this.field_110973_g = 0;
      this.field_110983_h = 0;
   }

   public String toString() {
      return "TextureAtlasSprite{name=\'" + this.field_110984_i + '\'' + ", frameCount=" + this.field_110976_a.size() + ", rotated=" + this.field_130222_e + ", x=" + this.field_110975_c + ", y=" + this.field_110974_d + ", height=" + this.field_130224_d + ", width=" + this.field_130223_c + ", u0=" + this.field_110979_l + ", u1=" + this.field_110980_m + ", v0=" + this.field_110977_n + ", v1=" + this.field_110978_o + '}';
   }
}
