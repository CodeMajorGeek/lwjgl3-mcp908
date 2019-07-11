package net.minecraft.client.renderer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.shader.TesselatorVertexState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCache;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import org.lwjgl.opengl.GL11;

public class WorldRenderer {

   private TesselatorVertexState field_147894_y;
   public World field_78924_a;
   private int field_78942_y = -1;
   private static Tessellator field_78941_z = Tessellator.field_78398_a;
   public static int field_78922_b;
   public int field_78923_c;
   public int field_78920_d;
   public int field_78921_e;
   public int field_78918_f;
   public int field_78919_g;
   public int field_78931_h;
   public int field_78932_i;
   public int field_78929_j;
   public int field_78930_k;
   public boolean field_78927_l;
   public boolean[] field_78928_m = new boolean[2];
   public int field_78925_n;
   public int field_78926_o;
   public int field_78940_p;
   public boolean field_78939_q;
   public AxisAlignedBB field_78938_r;
   public int field_78937_s;
   public boolean field_78936_t = true;
   public boolean field_78935_u;
   public int field_78934_v;
   public boolean field_78933_w;
   private boolean field_78915_A;
   public List field_147895_x = new ArrayList();
   private List field_147893_C;
   private int field_78917_C;
   private static final String __OBFID = "CL_00000942";


   public WorldRenderer(World p_i1240_1_, List p_i1240_2_, int p_i1240_3_, int p_i1240_4_, int p_i1240_5_, int p_i1240_6_) {
      this.field_78924_a = p_i1240_1_;
      this.field_147894_y = null;
      this.field_147893_C = p_i1240_2_;
      this.field_78942_y = p_i1240_6_;
      this.field_78923_c = -999;
      this.func_78913_a(p_i1240_3_, p_i1240_4_, p_i1240_5_);
      this.field_78939_q = false;
   }

   public void func_78913_a(int p_78913_1_, int p_78913_2_, int p_78913_3_) {
      if(p_78913_1_ != this.field_78923_c || p_78913_2_ != this.field_78920_d || p_78913_3_ != this.field_78921_e) {
         this.func_78910_b();
         this.field_78923_c = p_78913_1_;
         this.field_78920_d = p_78913_2_;
         this.field_78921_e = p_78913_3_;
         this.field_78925_n = p_78913_1_ + 8;
         this.field_78926_o = p_78913_2_ + 8;
         this.field_78940_p = p_78913_3_ + 8;
         this.field_78932_i = p_78913_1_ & 1023;
         this.field_78929_j = p_78913_2_;
         this.field_78930_k = p_78913_3_ & 1023;
         this.field_78918_f = p_78913_1_ - this.field_78932_i;
         this.field_78919_g = p_78913_2_ - this.field_78929_j;
         this.field_78931_h = p_78913_3_ - this.field_78930_k;
         float var4 = 6.0F;
         this.field_78938_r = AxisAlignedBB.func_72330_a((double)((float)p_78913_1_ - var4), (double)((float)p_78913_2_ - var4), (double)((float)p_78913_3_ - var4), (double)((float)(p_78913_1_ + 16) + var4), (double)((float)(p_78913_2_ + 16) + var4), (double)((float)(p_78913_3_ + 16) + var4));
         GL11.glNewList(this.field_78942_y + 2, 4864);
         RenderItem.func_76980_a(AxisAlignedBB.func_72330_a((double)((float)this.field_78932_i - var4), (double)((float)this.field_78929_j - var4), (double)((float)this.field_78930_k - var4), (double)((float)(this.field_78932_i + 16) + var4), (double)((float)(this.field_78929_j + 16) + var4), (double)((float)(this.field_78930_k + 16) + var4)));
         GL11.glEndList();
         this.func_78914_f();
      }
   }

   private void func_78905_g() {
      GL11.glTranslatef((float)this.field_78932_i, (float)this.field_78929_j, (float)this.field_78930_k);
   }

   public void func_147892_a(EntityLivingBase p_147892_1_) {
      if(this.field_78939_q) {
         this.field_78939_q = false;
         int var2 = this.field_78923_c;
         int var3 = this.field_78920_d;
         int var4 = this.field_78921_e;
         int var5 = this.field_78923_c + 16;
         int var6 = this.field_78920_d + 16;
         int var7 = this.field_78921_e + 16;

         for(int var8 = 0; var8 < 2; ++var8) {
            this.field_78928_m[var8] = true;
         }

         Chunk.field_76640_a = false;
         HashSet var26 = new HashSet();
         var26.addAll(this.field_147895_x);
         this.field_147895_x.clear();
         Minecraft var9 = Minecraft.func_71410_x();
         EntityLivingBase var10 = var9.field_71451_h;
         int var11 = MathHelper.func_76128_c(var10.field_70165_t);
         int var12 = MathHelper.func_76128_c(var10.field_70163_u);
         int var13 = MathHelper.func_76128_c(var10.field_70161_v);
         byte var14 = 1;
         ChunkCache var15 = new ChunkCache(this.field_78924_a, var2 - var14, var3 - var14, var4 - var14, var5 + var14, var6 + var14, var7 + var14, var14);
         if(!var15.func_72806_N()) {
            ++field_78922_b;
            RenderBlocks var16 = new RenderBlocks(var15);
            this.field_78917_C = 0;
            this.field_147894_y = null;

            for(int var17 = 0; var17 < 2; ++var17) {
               boolean var18 = false;
               boolean var19 = false;
               boolean var20 = false;

               for(int var21 = var3; var21 < var6; ++var21) {
                  for(int var22 = var4; var22 < var7; ++var22) {
                     for(int var23 = var2; var23 < var5; ++var23) {
                        Block var24 = var15.func_147439_a(var23, var21, var22);
                        if(var24.func_149688_o() != Material.field_151579_a) {
                           if(!var20) {
                              var20 = true;
                              this.func_147890_b(var17);
                           }

                           if(var17 == 0 && var24.func_149716_u()) {
                              TileEntity var25 = var15.func_147438_o(var23, var21, var22);
                              if(TileEntityRendererDispatcher.field_147556_a.func_147545_a(var25)) {
                                 this.field_147895_x.add(var25);
                              }
                           }

                           int var28 = var24.func_149701_w();
                           if(var28 > var17) {
                              var18 = true;
                           } else if(var28 == var17) {
                              var19 |= var16.func_147805_b(var24, var23, var21, var22);
                              if(var24.func_149645_b() == 0 && var23 == var11 && var21 == var12 && var22 == var13) {
                                 var16.func_147786_a(true);
                                 var16.func_147753_b(true);
                                 var16.func_147805_b(var24, var23, var21, var22);
                                 var16.func_147786_a(false);
                                 var16.func_147753_b(false);
                              }
                           }
                        }
                     }
                  }
               }

               if(var19) {
                  this.field_78928_m[var17] = false;
               }

               if(var20) {
                  this.func_147891_a(var17, p_147892_1_);
               } else {
                  var19 = false;
               }

               if(!var18) {
                  break;
               }
            }
         }

         HashSet var27 = new HashSet();
         var27.addAll(this.field_147895_x);
         var27.removeAll(var26);
         this.field_147893_C.addAll(var27);
         var26.removeAll(this.field_147895_x);
         this.field_147893_C.removeAll(var26);
         this.field_78933_w = Chunk.field_76640_a;
         this.field_78915_A = true;
      }
   }

   private void func_147890_b(int p_147890_1_) {
      GL11.glNewList(this.field_78942_y + p_147890_1_, 4864);
      GL11.glPushMatrix();
      this.func_78905_g();
      float var2 = 1.000001F;
      GL11.glTranslatef(-8.0F, -8.0F, -8.0F);
      GL11.glScalef(var2, var2, var2);
      GL11.glTranslatef(8.0F, 8.0F, 8.0F);
      field_78941_z.func_78382_b();
      field_78941_z.func_78373_b((double)(-this.field_78923_c), (double)(-this.field_78920_d), (double)(-this.field_78921_e));
   }

   private void func_147891_a(int p_147891_1_, EntityLivingBase p_147891_2_) {
      if(p_147891_1_ == 1 && !this.field_78928_m[p_147891_1_]) {
         this.field_147894_y = field_78941_z.func_147564_a((float)p_147891_2_.field_70165_t, (float)p_147891_2_.field_70163_u, (float)p_147891_2_.field_70161_v);
      }

      this.field_78917_C += field_78941_z.func_78381_a();
      GL11.glPopMatrix();
      GL11.glEndList();
      field_78941_z.func_78373_b(0.0D, 0.0D, 0.0D);
   }

   public void func_147889_b(EntityLivingBase p_147889_1_) {
      if(this.field_147894_y != null && !this.field_78928_m[1]) {
         this.func_147890_b(1);
         field_78941_z.func_147565_a(this.field_147894_y);
         this.func_147891_a(1, p_147889_1_);
      }
   }

   public float func_78912_a(Entity p_78912_1_) {
      float var2 = (float)(p_78912_1_.field_70165_t - (double)this.field_78925_n);
      float var3 = (float)(p_78912_1_.field_70163_u - (double)this.field_78926_o);
      float var4 = (float)(p_78912_1_.field_70161_v - (double)this.field_78940_p);
      return var2 * var2 + var3 * var3 + var4 * var4;
   }

   public void func_78910_b() {
      for(int var1 = 0; var1 < 2; ++var1) {
         this.field_78928_m[var1] = true;
      }

      this.field_78927_l = false;
      this.field_78915_A = false;
      this.field_147894_y = null;
   }

   public void func_78911_c() {
      this.func_78910_b();
      this.field_78924_a = null;
   }

   public int func_78909_a(int p_78909_1_) {
      return !this.field_78927_l?-1:(!this.field_78928_m[p_78909_1_]?this.field_78942_y + p_78909_1_:-1);
   }

   public void func_78908_a(ICamera p_78908_1_) {
      this.field_78927_l = p_78908_1_.func_78546_a(this.field_78938_r);
   }

   public void func_78904_d() {
      GL11.glCallList(this.field_78942_y + 2);
   }

   public boolean func_78906_e() {
      return !this.field_78915_A?false:this.field_78928_m[0] && this.field_78928_m[1];
   }

   public void func_78914_f() {
      this.field_78939_q = true;
   }

}
