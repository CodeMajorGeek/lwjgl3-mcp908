package net.minecraft.client.renderer;

import com.google.common.collect.Maps;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.particle.EntityAuraFX;
import net.minecraft.client.particle.EntityBlockDustFX;
import net.minecraft.client.particle.EntityBreakingFX;
import net.minecraft.client.particle.EntityBubbleFX;
import net.minecraft.client.particle.EntityCloudFX;
import net.minecraft.client.particle.EntityCritFX;
import net.minecraft.client.particle.EntityDiggingFX;
import net.minecraft.client.particle.EntityDropParticleFX;
import net.minecraft.client.particle.EntityEnchantmentTableParticleFX;
import net.minecraft.client.particle.EntityExplodeFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.client.particle.EntityFishWakeFX;
import net.minecraft.client.particle.EntityFlameFX;
import net.minecraft.client.particle.EntityFootStepFX;
import net.minecraft.client.particle.EntityHeartFX;
import net.minecraft.client.particle.EntityHugeExplodeFX;
import net.minecraft.client.particle.EntityLargeExplodeFX;
import net.minecraft.client.particle.EntityLavaFX;
import net.minecraft.client.particle.EntityNoteFX;
import net.minecraft.client.particle.EntityPortalFX;
import net.minecraft.client.particle.EntityReddustFX;
import net.minecraft.client.particle.EntitySmokeFX;
import net.minecraft.client.particle.EntitySnowShovelFX;
import net.minecraft.client.particle.EntitySpellParticleFX;
import net.minecraft.client.particle.EntitySplashFX;
import net.minecraft.client.particle.EntitySuspendFX;
import net.minecraft.client.renderer.DestroyBlockProgress;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.EntitySorter;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.OpenGlCapsChecker;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.RenderList;
import net.minecraft.client.renderer.RenderSorter;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.util.RenderDistanceSorter;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemRecord;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.IWorldAccess;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.ARBOcclusionQuery;
import org.lwjgl.opengl.GL11;

public class RenderGlobal implements IWorldAccess {

   private static final Logger field_147599_m = LogManager.getLogger();
   private static final ResourceLocation field_110927_h = new ResourceLocation("textures/environment/moon_phases.png");
   private static final ResourceLocation field_110928_i = new ResourceLocation("textures/environment/sun.png");
   private static final ResourceLocation field_110925_j = new ResourceLocation("textures/environment/clouds.png");
   private static final ResourceLocation field_110926_k = new ResourceLocation("textures/environment/end_sky.png");
   public List field_147598_a = new ArrayList();
   private WorldClient field_72769_h;
   private final TextureManager field_72770_i;
   private List field_72767_j = new ArrayList();
   private WorldRenderer[] field_72768_k;
   private WorldRenderer[] field_72765_l;
   private int field_72766_m;
   private int field_72763_n;
   private int field_72764_o;
   private int field_72778_p;
   private Minecraft field_72777_q;
   private RenderBlocks field_147592_B;
   private IntBuffer field_72775_s;
   private boolean field_72774_t;
   private int field_72773_u;
   private int field_72772_v;
   private int field_72771_w;
   private int field_72781_x;
   private int field_72780_y;
   private int field_72779_z;
   private int field_72741_A;
   private int field_72742_B;
   private int field_72743_C;
   private int field_72737_D;
   private final Map field_72738_E = new HashMap();
   private final Map field_147593_P = Maps.newHashMap();
   private IIcon[] field_94141_F;
   private boolean field_147595_R;
   private int field_147594_S;
   private int field_72739_F = -1;
   private int field_72740_G = 2;
   private int field_72748_H;
   private int field_72749_I;
   private int field_72750_J;
   IntBuffer field_72761_c = GLAllocation.func_74527_f(64);
   private int field_72751_K;
   private int field_72744_L;
   private int field_72745_M;
   private int field_72746_N;
   private int field_72747_O;
   private int field_72753_P;
   private int field_72752_Q;
   private List field_72755_R = new ArrayList();
   private RenderList[] field_72754_S = new RenderList[]{new RenderList(), new RenderList(), new RenderList(), new RenderList()};
   double field_72758_d = -9999.0D;
   double field_72759_e = -9999.0D;
   double field_72756_f = -9999.0D;
   double field_147596_f = -9999.0D;
   double field_147597_g = -9999.0D;
   double field_147602_h = -9999.0D;
   int field_147603_i = -999;
   int field_147600_j = -999;
   int field_147601_k = -999;
   int field_72757_g;
   private static final String __OBFID = "CL_00000954";


   public RenderGlobal(Minecraft p_i1249_1_) {
      this.field_72777_q = p_i1249_1_;
      this.field_72770_i = p_i1249_1_.func_110434_K();
      byte var2 = 34;
      byte var3 = 16;
      this.field_72778_p = GLAllocation.func_74526_a(var2 * var2 * var3 * 3);
      this.field_147595_R = false;
      this.field_147594_S = GLAllocation.func_74526_a(1);
      this.field_72774_t = OpenGlCapsChecker.func_74371_a();
      if(this.field_72774_t) {
         this.field_72761_c.clear();
         this.field_72775_s = GLAllocation.func_74527_f(var2 * var2 * var3);
         this.field_72775_s.clear();
         this.field_72775_s.position(0);
         this.field_72775_s.limit(var2 * var2 * var3);
         ARBOcclusionQuery.glGenQueriesARB(this.field_72775_s);
      }

      this.field_72772_v = GLAllocation.func_74526_a(3);
      GL11.glPushMatrix();
      GL11.glNewList(this.field_72772_v, 4864);
      this.func_72730_g();
      GL11.glEndList();
      GL11.glPopMatrix();
      Tessellator var4 = Tessellator.field_78398_a;
      this.field_72771_w = this.field_72772_v + 1;
      GL11.glNewList(this.field_72771_w, 4864);
      byte var6 = 64;
      int var7 = 256 / var6 + 2;
      float var5 = 16.0F;

      int var8;
      int var9;
      for(var8 = -var6 * var7; var8 <= var6 * var7; var8 += var6) {
         for(var9 = -var6 * var7; var9 <= var6 * var7; var9 += var6) {
            var4.func_78382_b();
            var4.func_78377_a((double)(var8 + 0), (double)var5, (double)(var9 + 0));
            var4.func_78377_a((double)(var8 + var6), (double)var5, (double)(var9 + 0));
            var4.func_78377_a((double)(var8 + var6), (double)var5, (double)(var9 + var6));
            var4.func_78377_a((double)(var8 + 0), (double)var5, (double)(var9 + var6));
            var4.func_78381_a();
         }
      }

      GL11.glEndList();
      this.field_72781_x = this.field_72772_v + 2;
      GL11.glNewList(this.field_72781_x, 4864);
      var5 = -16.0F;
      var4.func_78382_b();

      for(var8 = -var6 * var7; var8 <= var6 * var7; var8 += var6) {
         for(var9 = -var6 * var7; var9 <= var6 * var7; var9 += var6) {
            var4.func_78377_a((double)(var8 + var6), (double)var5, (double)(var9 + 0));
            var4.func_78377_a((double)(var8 + 0), (double)var5, (double)(var9 + 0));
            var4.func_78377_a((double)(var8 + 0), (double)var5, (double)(var9 + var6));
            var4.func_78377_a((double)(var8 + var6), (double)var5, (double)(var9 + var6));
         }
      }

      var4.func_78381_a();
      GL11.glEndList();
   }

   private void func_72730_g() {
      Random var1 = new Random(10842L);
      Tessellator var2 = Tessellator.field_78398_a;
      var2.func_78382_b();

      for(int var3 = 0; var3 < 1500; ++var3) {
         double var4 = (double)(var1.nextFloat() * 2.0F - 1.0F);
         double var6 = (double)(var1.nextFloat() * 2.0F - 1.0F);
         double var8 = (double)(var1.nextFloat() * 2.0F - 1.0F);
         double var10 = (double)(0.15F + var1.nextFloat() * 0.1F);
         double var12 = var4 * var4 + var6 * var6 + var8 * var8;
         if(var12 < 1.0D && var12 > 0.01D) {
            var12 = 1.0D / Math.sqrt(var12);
            var4 *= var12;
            var6 *= var12;
            var8 *= var12;
            double var14 = var4 * 100.0D;
            double var16 = var6 * 100.0D;
            double var18 = var8 * 100.0D;
            double var20 = Math.atan2(var4, var8);
            double var22 = Math.sin(var20);
            double var24 = Math.cos(var20);
            double var26 = Math.atan2(Math.sqrt(var4 * var4 + var8 * var8), var6);
            double var28 = Math.sin(var26);
            double var30 = Math.cos(var26);
            double var32 = var1.nextDouble() * 3.141592653589793D * 2.0D;
            double var34 = Math.sin(var32);
            double var36 = Math.cos(var32);

            for(int var38 = 0; var38 < 4; ++var38) {
               double var39 = 0.0D;
               double var41 = (double)((var38 & 2) - 1) * var10;
               double var43 = (double)((var38 + 1 & 2) - 1) * var10;
               double var47 = var41 * var36 - var43 * var34;
               double var49 = var43 * var36 + var41 * var34;
               double var53 = var47 * var28 + var39 * var30;
               double var55 = var39 * var28 - var47 * var30;
               double var57 = var55 * var22 - var49 * var24;
               double var61 = var49 * var22 + var55 * var24;
               var2.func_78377_a(var14 + var57, var16 + var53, var18 + var61);
            }
         }
      }

      var2.func_78381_a();
   }

   public void func_72732_a(WorldClient p_72732_1_) {
      if(this.field_72769_h != null) {
         this.field_72769_h.func_72848_b(this);
      }

      this.field_72758_d = -9999.0D;
      this.field_72759_e = -9999.0D;
      this.field_72756_f = -9999.0D;
      this.field_147596_f = -9999.0D;
      this.field_147597_g = -9999.0D;
      this.field_147602_h = -9999.0D;
      this.field_147603_i = -9999;
      this.field_147600_j = -9999;
      this.field_147601_k = -9999;
      RenderManager.field_78727_a.func_78717_a(p_72732_1_);
      this.field_72769_h = p_72732_1_;
      this.field_147592_B = new RenderBlocks(p_72732_1_);
      if(p_72732_1_ != null) {
         p_72732_1_.func_72954_a(this);
         this.func_72712_a();
      }

   }

   public void func_72712_a() {
      if(this.field_72769_h != null) {
         Blocks.field_150362_t.func_150122_b(this.field_72777_q.field_71474_y.field_74347_j);
         Blocks.field_150361_u.func_150122_b(this.field_72777_q.field_71474_y.field_74347_j);
         this.field_72739_F = this.field_72777_q.field_71474_y.field_151451_c;
         int var1;
         if(this.field_72765_l != null) {
            for(var1 = 0; var1 < this.field_72765_l.length; ++var1) {
               this.field_72765_l[var1].func_78911_c();
            }
         }

         var1 = this.field_72739_F * 2 + 1;
         this.field_72766_m = var1;
         this.field_72763_n = 16;
         this.field_72764_o = var1;
         this.field_72765_l = new WorldRenderer[this.field_72766_m * this.field_72763_n * this.field_72764_o];
         this.field_72768_k = new WorldRenderer[this.field_72766_m * this.field_72763_n * this.field_72764_o];
         int var2 = 0;
         int var3 = 0;
         this.field_72780_y = 0;
         this.field_72779_z = 0;
         this.field_72741_A = 0;
         this.field_72742_B = this.field_72766_m;
         this.field_72743_C = this.field_72763_n;
         this.field_72737_D = this.field_72764_o;

         int var4;
         for(var4 = 0; var4 < this.field_72767_j.size(); ++var4) {
            ((WorldRenderer)this.field_72767_j.get(var4)).field_78939_q = false;
         }

         this.field_72767_j.clear();
         this.field_147598_a.clear();
         this.func_147584_b();

         for(var4 = 0; var4 < this.field_72766_m; ++var4) {
            for(int var5 = 0; var5 < this.field_72763_n; ++var5) {
               for(int var6 = 0; var6 < this.field_72764_o; ++var6) {
                  this.field_72765_l[(var6 * this.field_72763_n + var5) * this.field_72766_m + var4] = new WorldRenderer(this.field_72769_h, this.field_147598_a, var4 * 16, var5 * 16, var6 * 16, this.field_72778_p + var2);
                  if(this.field_72774_t) {
                     this.field_72765_l[(var6 * this.field_72763_n + var5) * this.field_72766_m + var4].field_78934_v = this.field_72775_s.get(var3);
                  }

                  this.field_72765_l[(var6 * this.field_72763_n + var5) * this.field_72766_m + var4].field_78935_u = false;
                  this.field_72765_l[(var6 * this.field_72763_n + var5) * this.field_72766_m + var4].field_78936_t = true;
                  this.field_72765_l[(var6 * this.field_72763_n + var5) * this.field_72766_m + var4].field_78927_l = true;
                  this.field_72765_l[(var6 * this.field_72763_n + var5) * this.field_72766_m + var4].field_78937_s = var3++;
                  this.field_72765_l[(var6 * this.field_72763_n + var5) * this.field_72766_m + var4].func_78914_f();
                  this.field_72768_k[(var6 * this.field_72763_n + var5) * this.field_72766_m + var4] = this.field_72765_l[(var6 * this.field_72763_n + var5) * this.field_72766_m + var4];
                  this.field_72767_j.add(this.field_72765_l[(var6 * this.field_72763_n + var5) * this.field_72766_m + var4]);
                  var2 += 3;
               }
            }
         }

         if(this.field_72769_h != null) {
            EntityLivingBase var7 = this.field_72777_q.field_71451_h;
            if(var7 != null) {
               this.func_72722_c(MathHelper.func_76128_c(var7.field_70165_t), MathHelper.func_76128_c(var7.field_70163_u), MathHelper.func_76128_c(var7.field_70161_v));
               Arrays.sort(this.field_72768_k, new EntitySorter(var7));
            }
         }

         this.field_72740_G = 2;
      }
   }

   public void func_147589_a(EntityLivingBase p_147589_1_, ICamera p_147589_2_, float p_147589_3_) {
      if(this.field_72740_G > 0) {
         --this.field_72740_G;
      } else {
         double var4 = p_147589_1_.field_70169_q + (p_147589_1_.field_70165_t - p_147589_1_.field_70169_q) * (double)p_147589_3_;
         double var6 = p_147589_1_.field_70167_r + (p_147589_1_.field_70163_u - p_147589_1_.field_70167_r) * (double)p_147589_3_;
         double var8 = p_147589_1_.field_70166_s + (p_147589_1_.field_70161_v - p_147589_1_.field_70166_s) * (double)p_147589_3_;
         this.field_72769_h.field_72984_F.func_76320_a("prepare");
         TileEntityRendererDispatcher.field_147556_a.func_147542_a(this.field_72769_h, this.field_72777_q.func_110434_K(), this.field_72777_q.field_71466_p, this.field_72777_q.field_71451_h, p_147589_3_);
         RenderManager.field_78727_a.func_147938_a(this.field_72769_h, this.field_72777_q.func_110434_K(), this.field_72777_q.field_71466_p, this.field_72777_q.field_71451_h, this.field_72777_q.field_147125_j, this.field_72777_q.field_71474_y, p_147589_3_);
         this.field_72748_H = 0;
         this.field_72749_I = 0;
         this.field_72750_J = 0;
         EntityLivingBase var10 = this.field_72777_q.field_71451_h;
         double var11 = var10.field_70142_S + (var10.field_70165_t - var10.field_70142_S) * (double)p_147589_3_;
         double var13 = var10.field_70137_T + (var10.field_70163_u - var10.field_70137_T) * (double)p_147589_3_;
         double var15 = var10.field_70136_U + (var10.field_70161_v - var10.field_70136_U) * (double)p_147589_3_;
         TileEntityRendererDispatcher.field_147554_b = var11;
         TileEntityRendererDispatcher.field_147555_c = var13;
         TileEntityRendererDispatcher.field_147552_d = var15;
         this.field_72769_h.field_72984_F.func_76318_c("staticentities");
         if(this.field_147595_R) {
            RenderManager.field_78725_b = 0.0D;
            RenderManager.field_78726_c = 0.0D;
            RenderManager.field_78723_d = 0.0D;
            this.func_147591_f();
         }

         GL11.glMatrixMode(5888);
         GL11.glPushMatrix();
         GL11.glTranslated(-var11, -var13, -var15);
         GL11.glCallList(this.field_147594_S);
         GL11.glPopMatrix();
         RenderManager.field_78725_b = var11;
         RenderManager.field_78726_c = var13;
         RenderManager.field_78723_d = var15;
         this.field_72777_q.field_71460_t.func_78463_b((double)p_147589_3_);
         this.field_72769_h.field_72984_F.func_76318_c("global");
         List var17 = this.field_72769_h.func_72910_y();
         this.field_72748_H = var17.size();

         int var18;
         Entity var19;
         for(var18 = 0; var18 < this.field_72769_h.field_73007_j.size(); ++var18) {
            var19 = (Entity)this.field_72769_h.field_73007_j.get(var18);
            ++this.field_72749_I;
            if(var19.func_145770_h(var4, var6, var8)) {
               RenderManager.field_78727_a.func_147937_a(var19, p_147589_3_);
            }
         }

         this.field_72769_h.field_72984_F.func_76318_c("entities");

         for(var18 = 0; var18 < var17.size(); ++var18) {
            var19 = (Entity)var17.get(var18);
            boolean var20 = var19.func_145770_h(var4, var6, var8) && (var19.field_70158_ak || p_147589_2_.func_78546_a(var19.field_70121_D) || var19.field_70153_n == this.field_72777_q.field_71439_g);
            if(!var20 && var19 instanceof EntityLiving) {
               EntityLiving var21 = (EntityLiving)var19;
               if(var21.func_110167_bD() && var21.func_110166_bE() != null) {
                  Entity var22 = var21.func_110166_bE();
                  var20 = p_147589_2_.func_78546_a(var22.field_70121_D);
               }
            }

            if(var20 && (var19 != this.field_72777_q.field_71451_h || this.field_72777_q.field_71474_y.field_74320_O != 0 || this.field_72777_q.field_71451_h.func_70608_bn()) && this.field_72769_h.func_72899_e(MathHelper.func_76128_c(var19.field_70165_t), 0, MathHelper.func_76128_c(var19.field_70161_v))) {
               ++this.field_72749_I;
               RenderManager.field_78727_a.func_147937_a(var19, p_147589_3_);
            }
         }

         this.field_72769_h.field_72984_F.func_76318_c("blockentities");
         RenderHelper.func_74519_b();

         for(var18 = 0; var18 < this.field_147598_a.size(); ++var18) {
            TileEntityRendererDispatcher.field_147556_a.func_147544_a((TileEntity)this.field_147598_a.get(var18), p_147589_3_);
         }

         this.field_72777_q.field_71460_t.func_78483_a((double)p_147589_3_);
         this.field_72769_h.field_72984_F.func_76319_b();
      }
   }

   public String func_72735_c() {
      return "C: " + this.field_72746_N + "/" + this.field_72751_K + ". F: " + this.field_72744_L + ", O: " + this.field_72745_M + ", E: " + this.field_72747_O;
   }

   public String func_72723_d() {
      return "E: " + this.field_72749_I + "/" + this.field_72748_H + ". B: " + this.field_72750_J + ", I: " + (this.field_72748_H - this.field_72750_J - this.field_72749_I);
   }

   public void func_147584_b() {
      this.field_147595_R = true;
   }

   public void func_147591_f() {
      this.field_72769_h.field_72984_F.func_76320_a("staticentityrebuild");
      GL11.glPushMatrix();
      GL11.glNewList(this.field_147594_S, 4864);
      List var1 = this.field_72769_h.func_72910_y();
      this.field_147595_R = false;

      for(int var2 = 0; var2 < var1.size(); ++var2) {
         Entity var3 = (Entity)var1.get(var2);
         if(RenderManager.field_78727_a.func_78713_a(var3).func_147905_a()) {
            this.field_147595_R = this.field_147595_R || !RenderManager.field_78727_a.func_147936_a(var3, 0.0F, true);
         }
      }

      GL11.glEndList();
      GL11.glPopMatrix();
      this.field_72769_h.field_72984_F.func_76319_b();
   }

   private void func_72722_c(int p_72722_1_, int p_72722_2_, int p_72722_3_) {
      p_72722_1_ -= 8;
      p_72722_2_ -= 8;
      p_72722_3_ -= 8;
      this.field_72780_y = Integer.MAX_VALUE;
      this.field_72779_z = Integer.MAX_VALUE;
      this.field_72741_A = Integer.MAX_VALUE;
      this.field_72742_B = Integer.MIN_VALUE;
      this.field_72743_C = Integer.MIN_VALUE;
      this.field_72737_D = Integer.MIN_VALUE;
      int var4 = this.field_72766_m * 16;
      int var5 = var4 / 2;

      for(int var6 = 0; var6 < this.field_72766_m; ++var6) {
         int var7 = var6 * 16;
         int var8 = var7 + var5 - p_72722_1_;
         if(var8 < 0) {
            var8 -= var4 - 1;
         }

         var8 /= var4;
         var7 -= var8 * var4;
         if(var7 < this.field_72780_y) {
            this.field_72780_y = var7;
         }

         if(var7 > this.field_72742_B) {
            this.field_72742_B = var7;
         }

         for(int var9 = 0; var9 < this.field_72764_o; ++var9) {
            int var10 = var9 * 16;
            int var11 = var10 + var5 - p_72722_3_;
            if(var11 < 0) {
               var11 -= var4 - 1;
            }

            var11 /= var4;
            var10 -= var11 * var4;
            if(var10 < this.field_72741_A) {
               this.field_72741_A = var10;
            }

            if(var10 > this.field_72737_D) {
               this.field_72737_D = var10;
            }

            for(int var12 = 0; var12 < this.field_72763_n; ++var12) {
               int var13 = var12 * 16;
               if(var13 < this.field_72779_z) {
                  this.field_72779_z = var13;
               }

               if(var13 > this.field_72743_C) {
                  this.field_72743_C = var13;
               }

               WorldRenderer var14 = this.field_72765_l[(var9 * this.field_72763_n + var12) * this.field_72766_m + var6];
               boolean var15 = var14.field_78939_q;
               var14.func_78913_a(var7, var13, var10);
               if(!var15 && var14.field_78939_q) {
                  this.field_72767_j.add(var14);
               }
            }
         }
      }

   }

   public int func_72719_a(EntityLivingBase p_72719_1_, int p_72719_2_, double p_72719_3_) {
      this.field_72769_h.field_72984_F.func_76320_a("sortchunks");

      for(int var5 = 0; var5 < 10; ++var5) {
         this.field_72752_Q = (this.field_72752_Q + 1) % this.field_72765_l.length;
         WorldRenderer var6 = this.field_72765_l[this.field_72752_Q];
         if(var6.field_78939_q && !this.field_72767_j.contains(var6)) {
            this.field_72767_j.add(var6);
         }
      }

      if(this.field_72777_q.field_71474_y.field_151451_c != this.field_72739_F) {
         this.func_72712_a();
      }

      if(p_72719_2_ == 0) {
         this.field_72751_K = 0;
         this.field_72753_P = 0;
         this.field_72744_L = 0;
         this.field_72745_M = 0;
         this.field_72746_N = 0;
         this.field_72747_O = 0;
      }

      double var39 = p_72719_1_.field_70142_S + (p_72719_1_.field_70165_t - p_72719_1_.field_70142_S) * p_72719_3_;
      double var7 = p_72719_1_.field_70137_T + (p_72719_1_.field_70163_u - p_72719_1_.field_70137_T) * p_72719_3_;
      double var9 = p_72719_1_.field_70136_U + (p_72719_1_.field_70161_v - p_72719_1_.field_70136_U) * p_72719_3_;
      double var11 = p_72719_1_.field_70165_t - this.field_72758_d;
      double var13 = p_72719_1_.field_70163_u - this.field_72759_e;
      double var15 = p_72719_1_.field_70161_v - this.field_72756_f;
      if(this.field_147603_i != p_72719_1_.field_70176_ah || this.field_147600_j != p_72719_1_.field_70162_ai || this.field_147601_k != p_72719_1_.field_70164_aj || var11 * var11 + var13 * var13 + var15 * var15 > 16.0D) {
         this.field_72758_d = p_72719_1_.field_70165_t;
         this.field_72759_e = p_72719_1_.field_70163_u;
         this.field_72756_f = p_72719_1_.field_70161_v;
         this.field_147603_i = p_72719_1_.field_70176_ah;
         this.field_147600_j = p_72719_1_.field_70162_ai;
         this.field_147601_k = p_72719_1_.field_70164_aj;
         this.func_72722_c(MathHelper.func_76128_c(p_72719_1_.field_70165_t), MathHelper.func_76128_c(p_72719_1_.field_70163_u), MathHelper.func_76128_c(p_72719_1_.field_70161_v));
         Arrays.sort(this.field_72768_k, new EntitySorter(p_72719_1_));
      }

      double var17 = p_72719_1_.field_70165_t - this.field_147596_f;
      double var19 = p_72719_1_.field_70163_u - this.field_147597_g;
      double var21 = p_72719_1_.field_70161_v - this.field_147602_h;
      int var23;
      if(var17 * var17 + var19 * var19 + var21 * var21 > 1.0D) {
         this.field_147596_f = p_72719_1_.field_70165_t;
         this.field_147597_g = p_72719_1_.field_70163_u;
         this.field_147602_h = p_72719_1_.field_70161_v;

         for(var23 = 0; var23 < 27; ++var23) {
            this.field_72768_k[var23].func_147889_b(p_72719_1_);
         }
      }

      RenderHelper.func_74518_a();
      byte var40 = 0;
      if(this.field_72774_t && this.field_72777_q.field_71474_y.field_74349_h && !this.field_72777_q.field_71474_y.field_74337_g && p_72719_2_ == 0) {
         byte var24 = 0;
         int var25 = 16;
         this.func_72720_a(var24, var25);

         for(int var26 = var24; var26 < var25; ++var26) {
            this.field_72768_k[var26].field_78936_t = true;
         }

         this.field_72769_h.field_72984_F.func_76318_c("render");
         var23 = var40 + this.func_72724_a(var24, var25, p_72719_2_, p_72719_3_);

         do {
            this.field_72769_h.field_72984_F.func_76318_c("occ");
            int var41 = var25;
            var25 *= 2;
            if(var25 > this.field_72768_k.length) {
               var25 = this.field_72768_k.length;
            }

            GL11.glDisable(3553);
            GL11.glDisable(2896);
            GL11.glDisable(3008);
            GL11.glDisable(2912);
            GL11.glColorMask(false, false, false, false);
            GL11.glDepthMask(false);
            this.field_72769_h.field_72984_F.func_76320_a("check");
            this.func_72720_a(var41, var25);
            this.field_72769_h.field_72984_F.func_76319_b();
            GL11.glPushMatrix();
            float var42 = 0.0F;
            float var27 = 0.0F;
            float var28 = 0.0F;

            for(int var29 = var41; var29 < var25; ++var29) {
               if(this.field_72768_k[var29].func_78906_e()) {
                  this.field_72768_k[var29].field_78927_l = false;
               } else {
                  if(!this.field_72768_k[var29].field_78927_l) {
                     this.field_72768_k[var29].field_78936_t = true;
                  }

                  if(this.field_72768_k[var29].field_78927_l && !this.field_72768_k[var29].field_78935_u) {
                     float var30 = MathHelper.func_76129_c(this.field_72768_k[var29].func_78912_a(p_72719_1_));
                     int var31 = (int)(1.0F + var30 / 128.0F);
                     if(this.field_72773_u % var31 == var29 % var31) {
                        WorldRenderer var32 = this.field_72768_k[var29];
                        float var33 = (float)((double)var32.field_78918_f - var39);
                        float var34 = (float)((double)var32.field_78919_g - var7);
                        float var35 = (float)((double)var32.field_78931_h - var9);
                        float var36 = var33 - var42;
                        float var37 = var34 - var27;
                        float var38 = var35 - var28;
                        if(var36 != 0.0F || var37 != 0.0F || var38 != 0.0F) {
                           GL11.glTranslatef(var36, var37, var38);
                           var42 += var36;
                           var27 += var37;
                           var28 += var38;
                        }

                        this.field_72769_h.field_72984_F.func_76320_a("bb");
                        ARBOcclusionQuery.glBeginQueryARB('\u8914', this.field_72768_k[var29].field_78934_v);
                        this.field_72768_k[var29].func_78904_d();
                        ARBOcclusionQuery.glEndQueryARB('\u8914');
                        this.field_72769_h.field_72984_F.func_76319_b();
                        this.field_72768_k[var29].field_78935_u = true;
                     }
                  }
               }
            }

            GL11.glPopMatrix();
            if(this.field_72777_q.field_71474_y.field_74337_g) {
               if(EntityRenderer.field_78515_b == 0) {
                  GL11.glColorMask(false, true, true, true);
               } else {
                  GL11.glColorMask(true, false, false, true);
               }
            } else {
               GL11.glColorMask(true, true, true, true);
            }

            GL11.glDepthMask(true);
            GL11.glEnable(3553);
            GL11.glEnable(3008);
            GL11.glEnable(2912);
            this.field_72769_h.field_72984_F.func_76318_c("render");
            var23 += this.func_72724_a(var41, var25, p_72719_2_, p_72719_3_);
         } while(var25 < this.field_72768_k.length);
      } else {
         this.field_72769_h.field_72984_F.func_76318_c("render");
         var23 = var40 + this.func_72724_a(0, this.field_72768_k.length, p_72719_2_, p_72719_3_);
      }

      this.field_72769_h.field_72984_F.func_76319_b();
      return var23;
   }

   private void func_72720_a(int p_72720_1_, int p_72720_2_) {
      for(int var3 = p_72720_1_; var3 < p_72720_2_; ++var3) {
         if(this.field_72768_k[var3].field_78935_u) {
            this.field_72761_c.clear();
            ARBOcclusionQuery.glGetQueryObjectuARB(this.field_72768_k[var3].field_78934_v, '\u8867', this.field_72761_c);
            if(this.field_72761_c.get(0) != 0) {
               this.field_72768_k[var3].field_78935_u = false;
               this.field_72761_c.clear();
               ARBOcclusionQuery.glGetQueryObjectuARB(this.field_72768_k[var3].field_78934_v, '\u8866', this.field_72761_c);
               this.field_72768_k[var3].field_78936_t = this.field_72761_c.get(0) != 0;
            }
         }
      }

   }

   private int func_72724_a(int p_72724_1_, int p_72724_2_, int p_72724_3_, double p_72724_4_) {
      this.field_72755_R.clear();
      int var6 = 0;
      int var7 = p_72724_1_;
      int var8 = p_72724_2_;
      byte var9 = 1;
      if(p_72724_3_ == 1) {
         var7 = this.field_72768_k.length - 1 - p_72724_1_;
         var8 = this.field_72768_k.length - 1 - p_72724_2_;
         var9 = -1;
      }

      for(int var10 = var7; var10 != var8; var10 += var9) {
         if(p_72724_3_ == 0) {
            ++this.field_72751_K;
            if(this.field_72768_k[var10].field_78928_m[p_72724_3_]) {
               ++this.field_72747_O;
            } else if(!this.field_72768_k[var10].field_78927_l) {
               ++this.field_72744_L;
            } else if(this.field_72774_t && !this.field_72768_k[var10].field_78936_t) {
               ++this.field_72745_M;
            } else {
               ++this.field_72746_N;
            }
         }

         if(!this.field_72768_k[var10].field_78928_m[p_72724_3_] && this.field_72768_k[var10].field_78927_l && (!this.field_72774_t || this.field_72768_k[var10].field_78936_t)) {
            int var11 = this.field_72768_k[var10].func_78909_a(p_72724_3_);
            if(var11 >= 0) {
               this.field_72755_R.add(this.field_72768_k[var10]);
               ++var6;
            }
         }
      }

      EntityLivingBase var22 = this.field_72777_q.field_71451_h;
      double var23 = var22.field_70142_S + (var22.field_70165_t - var22.field_70142_S) * p_72724_4_;
      double var13 = var22.field_70137_T + (var22.field_70163_u - var22.field_70137_T) * p_72724_4_;
      double var15 = var22.field_70136_U + (var22.field_70161_v - var22.field_70136_U) * p_72724_4_;
      int var17 = 0;

      int var18;
      for(var18 = 0; var18 < this.field_72754_S.length; ++var18) {
         this.field_72754_S[var18].func_78421_b();
      }

      int var20;
      int var21;
      for(var18 = 0; var18 < this.field_72755_R.size(); ++var18) {
         WorldRenderer var19 = (WorldRenderer)this.field_72755_R.get(var18);
         var20 = -1;

         for(var21 = 0; var21 < var17; ++var21) {
            if(this.field_72754_S[var21].func_78418_a(var19.field_78918_f, var19.field_78919_g, var19.field_78931_h)) {
               var20 = var21;
            }
         }

         if(var20 < 0) {
            var20 = var17++;
            this.field_72754_S[var20].func_78422_a(var19.field_78918_f, var19.field_78919_g, var19.field_78931_h, var23, var13, var15);
         }

         this.field_72754_S[var20].func_78420_a(var19.func_78909_a(p_72724_3_));
      }

      var18 = MathHelper.func_76128_c(var23);
      int var24 = MathHelper.func_76128_c(var15);
      var20 = var18 - (var18 & 1023);
      var21 = var24 - (var24 & 1023);
      Arrays.sort(this.field_72754_S, new RenderDistanceSorter(var20, var21));
      this.func_72733_a(p_72724_3_, p_72724_4_);
      return var6;
   }

   public void func_72733_a(int p_72733_1_, double p_72733_2_) {
      this.field_72777_q.field_71460_t.func_78463_b(p_72733_2_);

      for(int var4 = 0; var4 < this.field_72754_S.length; ++var4) {
         this.field_72754_S[var4].func_78419_a();
      }

      this.field_72777_q.field_71460_t.func_78483_a(p_72733_2_);
   }

   public void func_72734_e() {
      ++this.field_72773_u;
      if(this.field_72773_u % 20 == 0) {
         Iterator var1 = this.field_72738_E.values().iterator();

         while(var1.hasNext()) {
            DestroyBlockProgress var2 = (DestroyBlockProgress)var1.next();
            int var3 = var2.func_82743_f();
            if(this.field_72773_u - var3 > 400) {
               var1.remove();
            }
         }
      }

   }

   public void func_72714_a(float p_72714_1_) {
      if(this.field_72777_q.field_71441_e.field_73011_w.field_76574_g == 1) {
         GL11.glDisable(2912);
         GL11.glDisable(3008);
         GL11.glEnable(3042);
         OpenGlHelper.func_148821_a(770, 771, 1, 0);
         RenderHelper.func_74518_a();
         GL11.glDepthMask(false);
         this.field_72770_i.func_110577_a(field_110926_k);
         Tessellator var21 = Tessellator.field_78398_a;

         for(int var22 = 0; var22 < 6; ++var22) {
            GL11.glPushMatrix();
            if(var22 == 1) {
               GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
            }

            if(var22 == 2) {
               GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
            }

            if(var22 == 3) {
               GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
            }

            if(var22 == 4) {
               GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
            }

            if(var22 == 5) {
               GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
            }

            var21.func_78382_b();
            var21.func_78378_d(2631720);
            var21.func_78374_a(-100.0D, -100.0D, -100.0D, 0.0D, 0.0D);
            var21.func_78374_a(-100.0D, -100.0D, 100.0D, 0.0D, 16.0D);
            var21.func_78374_a(100.0D, -100.0D, 100.0D, 16.0D, 16.0D);
            var21.func_78374_a(100.0D, -100.0D, -100.0D, 16.0D, 0.0D);
            var21.func_78381_a();
            GL11.glPopMatrix();
         }

         GL11.glDepthMask(true);
         GL11.glEnable(3553);
         GL11.glEnable(3008);
      } else if(this.field_72777_q.field_71441_e.field_73011_w.func_76569_d()) {
         GL11.glDisable(3553);
         Vec3 var2 = this.field_72769_h.func_72833_a(this.field_72777_q.field_71451_h, p_72714_1_);
         float var3 = (float)var2.field_72450_a;
         float var4 = (float)var2.field_72448_b;
         float var5 = (float)var2.field_72449_c;
         float var8;
         if(this.field_72777_q.field_71474_y.field_74337_g) {
            float var6 = (var3 * 30.0F + var4 * 59.0F + var5 * 11.0F) / 100.0F;
            float var7 = (var3 * 30.0F + var4 * 70.0F) / 100.0F;
            var8 = (var3 * 30.0F + var5 * 70.0F) / 100.0F;
            var3 = var6;
            var4 = var7;
            var5 = var8;
         }

         GL11.glColor3f(var3, var4, var5);
         Tessellator var23 = Tessellator.field_78398_a;
         GL11.glDepthMask(false);
         GL11.glEnable(2912);
         GL11.glColor3f(var3, var4, var5);
         GL11.glCallList(this.field_72771_w);
         GL11.glDisable(2912);
         GL11.glDisable(3008);
         GL11.glEnable(3042);
         OpenGlHelper.func_148821_a(770, 771, 1, 0);
         RenderHelper.func_74518_a();
         float[] var24 = this.field_72769_h.field_73011_w.func_76560_a(this.field_72769_h.func_72826_c(p_72714_1_), p_72714_1_);
         float var9;
         float var10;
         float var11;
         float var12;
         if(var24 != null) {
            GL11.glDisable(3553);
            GL11.glShadeModel(7425);
            GL11.glPushMatrix();
            GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(MathHelper.func_76126_a(this.field_72769_h.func_72929_e(p_72714_1_)) < 0.0F?180.0F:0.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
            var8 = var24[0];
            var9 = var24[1];
            var10 = var24[2];
            float var13;
            if(this.field_72777_q.field_71474_y.field_74337_g) {
               var11 = (var8 * 30.0F + var9 * 59.0F + var10 * 11.0F) / 100.0F;
               var12 = (var8 * 30.0F + var9 * 70.0F) / 100.0F;
               var13 = (var8 * 30.0F + var10 * 70.0F) / 100.0F;
               var8 = var11;
               var9 = var12;
               var10 = var13;
            }

            var23.func_78371_b(6);
            var23.func_78369_a(var8, var9, var10, var24[3]);
            var23.func_78377_a(0.0D, 100.0D, 0.0D);
            byte var26 = 16;
            var23.func_78369_a(var24[0], var24[1], var24[2], 0.0F);

            for(int var27 = 0; var27 <= var26; ++var27) {
               var13 = (float)var27 * 3.1415927F * 2.0F / (float)var26;
               float var14 = MathHelper.func_76126_a(var13);
               float var15 = MathHelper.func_76134_b(var13);
               var23.func_78377_a((double)(var14 * 120.0F), (double)(var15 * 120.0F), (double)(-var15 * 40.0F * var24[3]));
            }

            var23.func_78381_a();
            GL11.glPopMatrix();
            GL11.glShadeModel(7424);
         }

         GL11.glEnable(3553);
         OpenGlHelper.func_148821_a(770, 1, 1, 0);
         GL11.glPushMatrix();
         var8 = 1.0F - this.field_72769_h.func_72867_j(p_72714_1_);
         var9 = 0.0F;
         var10 = 0.0F;
         var11 = 0.0F;
         GL11.glColor4f(1.0F, 1.0F, 1.0F, var8);
         GL11.glTranslatef(var9, var10, var11);
         GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(this.field_72769_h.func_72826_c(p_72714_1_) * 360.0F, 1.0F, 0.0F, 0.0F);
         var12 = 30.0F;
         this.field_72770_i.func_110577_a(field_110928_i);
         var23.func_78382_b();
         var23.func_78374_a((double)(-var12), 100.0D, (double)(-var12), 0.0D, 0.0D);
         var23.func_78374_a((double)var12, 100.0D, (double)(-var12), 1.0D, 0.0D);
         var23.func_78374_a((double)var12, 100.0D, (double)var12, 1.0D, 1.0D);
         var23.func_78374_a((double)(-var12), 100.0D, (double)var12, 0.0D, 1.0D);
         var23.func_78381_a();
         var12 = 20.0F;
         this.field_72770_i.func_110577_a(field_110927_h);
         int var28 = this.field_72769_h.func_72853_d();
         int var29 = var28 % 4;
         int var30 = var28 / 4 % 2;
         float var16 = (float)(var29 + 0) / 4.0F;
         float var17 = (float)(var30 + 0) / 2.0F;
         float var18 = (float)(var29 + 1) / 4.0F;
         float var19 = (float)(var30 + 1) / 2.0F;
         var23.func_78382_b();
         var23.func_78374_a((double)(-var12), -100.0D, (double)var12, (double)var18, (double)var19);
         var23.func_78374_a((double)var12, -100.0D, (double)var12, (double)var16, (double)var19);
         var23.func_78374_a((double)var12, -100.0D, (double)(-var12), (double)var16, (double)var17);
         var23.func_78374_a((double)(-var12), -100.0D, (double)(-var12), (double)var18, (double)var17);
         var23.func_78381_a();
         GL11.glDisable(3553);
         float var20 = this.field_72769_h.func_72880_h(p_72714_1_) * var8;
         if(var20 > 0.0F) {
            GL11.glColor4f(var20, var20, var20, var20);
            GL11.glCallList(this.field_72772_v);
         }

         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glDisable(3042);
         GL11.glEnable(3008);
         GL11.glEnable(2912);
         GL11.glPopMatrix();
         GL11.glDisable(3553);
         GL11.glColor3f(0.0F, 0.0F, 0.0F);
         double var25 = this.field_72777_q.field_71439_g.func_70666_h(p_72714_1_).field_72448_b - this.field_72769_h.func_72919_O();
         if(var25 < 0.0D) {
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 12.0F, 0.0F);
            GL11.glCallList(this.field_72781_x);
            GL11.glPopMatrix();
            var10 = 1.0F;
            var11 = -((float)(var25 + 65.0D));
            var12 = -var10;
            var23.func_78382_b();
            var23.func_78384_a(0, 255);
            var23.func_78377_a((double)(-var10), (double)var11, (double)var10);
            var23.func_78377_a((double)var10, (double)var11, (double)var10);
            var23.func_78377_a((double)var10, (double)var12, (double)var10);
            var23.func_78377_a((double)(-var10), (double)var12, (double)var10);
            var23.func_78377_a((double)(-var10), (double)var12, (double)(-var10));
            var23.func_78377_a((double)var10, (double)var12, (double)(-var10));
            var23.func_78377_a((double)var10, (double)var11, (double)(-var10));
            var23.func_78377_a((double)(-var10), (double)var11, (double)(-var10));
            var23.func_78377_a((double)var10, (double)var12, (double)(-var10));
            var23.func_78377_a((double)var10, (double)var12, (double)var10);
            var23.func_78377_a((double)var10, (double)var11, (double)var10);
            var23.func_78377_a((double)var10, (double)var11, (double)(-var10));
            var23.func_78377_a((double)(-var10), (double)var11, (double)(-var10));
            var23.func_78377_a((double)(-var10), (double)var11, (double)var10);
            var23.func_78377_a((double)(-var10), (double)var12, (double)var10);
            var23.func_78377_a((double)(-var10), (double)var12, (double)(-var10));
            var23.func_78377_a((double)(-var10), (double)var12, (double)(-var10));
            var23.func_78377_a((double)(-var10), (double)var12, (double)var10);
            var23.func_78377_a((double)var10, (double)var12, (double)var10);
            var23.func_78377_a((double)var10, (double)var12, (double)(-var10));
            var23.func_78381_a();
         }

         if(this.field_72769_h.field_73011_w.func_76561_g()) {
            GL11.glColor3f(var3 * 0.2F + 0.04F, var4 * 0.2F + 0.04F, var5 * 0.6F + 0.1F);
         } else {
            GL11.glColor3f(var3, var4, var5);
         }

         GL11.glPushMatrix();
         GL11.glTranslatef(0.0F, -((float)(var25 - 16.0D)), 0.0F);
         GL11.glCallList(this.field_72781_x);
         GL11.glPopMatrix();
         GL11.glEnable(3553);
         GL11.glDepthMask(true);
      }
   }

   public void func_72718_b(float p_72718_1_) {
      if(this.field_72777_q.field_71441_e.field_73011_w.func_76569_d()) {
         if(this.field_72777_q.field_71474_y.field_74347_j) {
            this.func_72736_c(p_72718_1_);
         } else {
            GL11.glDisable(2884);
            float var2 = (float)(this.field_72777_q.field_71451_h.field_70137_T + (this.field_72777_q.field_71451_h.field_70163_u - this.field_72777_q.field_71451_h.field_70137_T) * (double)p_72718_1_);
            byte var3 = 32;
            int var4 = 256 / var3;
            Tessellator var5 = Tessellator.field_78398_a;
            this.field_72770_i.func_110577_a(field_110925_j);
            GL11.glEnable(3042);
            OpenGlHelper.func_148821_a(770, 771, 1, 0);
            Vec3 var6 = this.field_72769_h.func_72824_f(p_72718_1_);
            float var7 = (float)var6.field_72450_a;
            float var8 = (float)var6.field_72448_b;
            float var9 = (float)var6.field_72449_c;
            float var10;
            if(this.field_72777_q.field_71474_y.field_74337_g) {
               var10 = (var7 * 30.0F + var8 * 59.0F + var9 * 11.0F) / 100.0F;
               float var11 = (var7 * 30.0F + var8 * 70.0F) / 100.0F;
               float var12 = (var7 * 30.0F + var9 * 70.0F) / 100.0F;
               var7 = var10;
               var8 = var11;
               var9 = var12;
            }

            var10 = 4.8828125E-4F;
            double var24 = (double)((float)this.field_72773_u + p_72718_1_);
            double var13 = this.field_72777_q.field_71451_h.field_70169_q + (this.field_72777_q.field_71451_h.field_70165_t - this.field_72777_q.field_71451_h.field_70169_q) * (double)p_72718_1_ + var24 * 0.029999999329447746D;
            double var15 = this.field_72777_q.field_71451_h.field_70166_s + (this.field_72777_q.field_71451_h.field_70161_v - this.field_72777_q.field_71451_h.field_70166_s) * (double)p_72718_1_;
            int var17 = MathHelper.func_76128_c(var13 / 2048.0D);
            int var18 = MathHelper.func_76128_c(var15 / 2048.0D);
            var13 -= (double)(var17 * 2048);
            var15 -= (double)(var18 * 2048);
            float var19 = this.field_72769_h.field_73011_w.func_76571_f() - var2 + 0.33F;
            float var20 = (float)(var13 * (double)var10);
            float var21 = (float)(var15 * (double)var10);
            var5.func_78382_b();
            var5.func_78369_a(var7, var8, var9, 0.8F);

            for(int var22 = -var3 * var4; var22 < var3 * var4; var22 += var3) {
               for(int var23 = -var3 * var4; var23 < var3 * var4; var23 += var3) {
                  var5.func_78374_a((double)(var22 + 0), (double)var19, (double)(var23 + var3), (double)((float)(var22 + 0) * var10 + var20), (double)((float)(var23 + var3) * var10 + var21));
                  var5.func_78374_a((double)(var22 + var3), (double)var19, (double)(var23 + var3), (double)((float)(var22 + var3) * var10 + var20), (double)((float)(var23 + var3) * var10 + var21));
                  var5.func_78374_a((double)(var22 + var3), (double)var19, (double)(var23 + 0), (double)((float)(var22 + var3) * var10 + var20), (double)((float)(var23 + 0) * var10 + var21));
                  var5.func_78374_a((double)(var22 + 0), (double)var19, (double)(var23 + 0), (double)((float)(var22 + 0) * var10 + var20), (double)((float)(var23 + 0) * var10 + var21));
               }
            }

            var5.func_78381_a();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(3042);
            GL11.glEnable(2884);
         }
      }
   }

   public boolean func_72721_a(double p_72721_1_, double p_72721_3_, double p_72721_5_, float p_72721_7_) {
      return false;
   }

   public void func_72736_c(float p_72736_1_) {
      GL11.glDisable(2884);
      float var2 = (float)(this.field_72777_q.field_71451_h.field_70137_T + (this.field_72777_q.field_71451_h.field_70163_u - this.field_72777_q.field_71451_h.field_70137_T) * (double)p_72736_1_);
      Tessellator var3 = Tessellator.field_78398_a;
      float var4 = 12.0F;
      float var5 = 4.0F;
      double var6 = (double)((float)this.field_72773_u + p_72736_1_);
      double var8 = (this.field_72777_q.field_71451_h.field_70169_q + (this.field_72777_q.field_71451_h.field_70165_t - this.field_72777_q.field_71451_h.field_70169_q) * (double)p_72736_1_ + var6 * 0.029999999329447746D) / (double)var4;
      double var10 = (this.field_72777_q.field_71451_h.field_70166_s + (this.field_72777_q.field_71451_h.field_70161_v - this.field_72777_q.field_71451_h.field_70166_s) * (double)p_72736_1_) / (double)var4 + 0.33000001311302185D;
      float var12 = this.field_72769_h.field_73011_w.func_76571_f() - var2 + 0.33F;
      int var13 = MathHelper.func_76128_c(var8 / 2048.0D);
      int var14 = MathHelper.func_76128_c(var10 / 2048.0D);
      var8 -= (double)(var13 * 2048);
      var10 -= (double)(var14 * 2048);
      this.field_72770_i.func_110577_a(field_110925_j);
      GL11.glEnable(3042);
      OpenGlHelper.func_148821_a(770, 771, 1, 0);
      Vec3 var15 = this.field_72769_h.func_72824_f(p_72736_1_);
      float var16 = (float)var15.field_72450_a;
      float var17 = (float)var15.field_72448_b;
      float var18 = (float)var15.field_72449_c;
      float var19;
      float var20;
      float var21;
      if(this.field_72777_q.field_71474_y.field_74337_g) {
         var19 = (var16 * 30.0F + var17 * 59.0F + var18 * 11.0F) / 100.0F;
         var20 = (var16 * 30.0F + var17 * 70.0F) / 100.0F;
         var21 = (var16 * 30.0F + var18 * 70.0F) / 100.0F;
         var16 = var19;
         var17 = var20;
         var18 = var21;
      }

      var19 = (float)(var8 * 0.0D);
      var20 = (float)(var10 * 0.0D);
      var21 = 0.00390625F;
      var19 = (float)MathHelper.func_76128_c(var8) * var21;
      var20 = (float)MathHelper.func_76128_c(var10) * var21;
      float var22 = (float)(var8 - (double)MathHelper.func_76128_c(var8));
      float var23 = (float)(var10 - (double)MathHelper.func_76128_c(var10));
      byte var24 = 8;
      byte var25 = 4;
      float var26 = 9.765625E-4F;
      GL11.glScalef(var4, 1.0F, var4);

      for(int var27 = 0; var27 < 2; ++var27) {
         if(var27 == 0) {
            GL11.glColorMask(false, false, false, false);
         } else if(this.field_72777_q.field_71474_y.field_74337_g) {
            if(EntityRenderer.field_78515_b == 0) {
               GL11.glColorMask(false, true, true, true);
            } else {
               GL11.glColorMask(true, false, false, true);
            }
         } else {
            GL11.glColorMask(true, true, true, true);
         }

         for(int var28 = -var25 + 1; var28 <= var25; ++var28) {
            for(int var29 = -var25 + 1; var29 <= var25; ++var29) {
               var3.func_78382_b();
               float var30 = (float)(var28 * var24);
               float var31 = (float)(var29 * var24);
               float var32 = var30 - var22;
               float var33 = var31 - var23;
               if(var12 > -var5 - 1.0F) {
                  var3.func_78369_a(var16 * 0.7F, var17 * 0.7F, var18 * 0.7F, 0.8F);
                  var3.func_78375_b(0.0F, -1.0F, 0.0F);
                  var3.func_78374_a((double)(var32 + 0.0F), (double)(var12 + 0.0F), (double)(var33 + (float)var24), (double)((var30 + 0.0F) * var21 + var19), (double)((var31 + (float)var24) * var21 + var20));
                  var3.func_78374_a((double)(var32 + (float)var24), (double)(var12 + 0.0F), (double)(var33 + (float)var24), (double)((var30 + (float)var24) * var21 + var19), (double)((var31 + (float)var24) * var21 + var20));
                  var3.func_78374_a((double)(var32 + (float)var24), (double)(var12 + 0.0F), (double)(var33 + 0.0F), (double)((var30 + (float)var24) * var21 + var19), (double)((var31 + 0.0F) * var21 + var20));
                  var3.func_78374_a((double)(var32 + 0.0F), (double)(var12 + 0.0F), (double)(var33 + 0.0F), (double)((var30 + 0.0F) * var21 + var19), (double)((var31 + 0.0F) * var21 + var20));
               }

               if(var12 <= var5 + 1.0F) {
                  var3.func_78369_a(var16, var17, var18, 0.8F);
                  var3.func_78375_b(0.0F, 1.0F, 0.0F);
                  var3.func_78374_a((double)(var32 + 0.0F), (double)(var12 + var5 - var26), (double)(var33 + (float)var24), (double)((var30 + 0.0F) * var21 + var19), (double)((var31 + (float)var24) * var21 + var20));
                  var3.func_78374_a((double)(var32 + (float)var24), (double)(var12 + var5 - var26), (double)(var33 + (float)var24), (double)((var30 + (float)var24) * var21 + var19), (double)((var31 + (float)var24) * var21 + var20));
                  var3.func_78374_a((double)(var32 + (float)var24), (double)(var12 + var5 - var26), (double)(var33 + 0.0F), (double)((var30 + (float)var24) * var21 + var19), (double)((var31 + 0.0F) * var21 + var20));
                  var3.func_78374_a((double)(var32 + 0.0F), (double)(var12 + var5 - var26), (double)(var33 + 0.0F), (double)((var30 + 0.0F) * var21 + var19), (double)((var31 + 0.0F) * var21 + var20));
               }

               var3.func_78369_a(var16 * 0.9F, var17 * 0.9F, var18 * 0.9F, 0.8F);
               int var34;
               if(var28 > -1) {
                  var3.func_78375_b(-1.0F, 0.0F, 0.0F);

                  for(var34 = 0; var34 < var24; ++var34) {
                     var3.func_78374_a((double)(var32 + (float)var34 + 0.0F), (double)(var12 + 0.0F), (double)(var33 + (float)var24), (double)((var30 + (float)var34 + 0.5F) * var21 + var19), (double)((var31 + (float)var24) * var21 + var20));
                     var3.func_78374_a((double)(var32 + (float)var34 + 0.0F), (double)(var12 + var5), (double)(var33 + (float)var24), (double)((var30 + (float)var34 + 0.5F) * var21 + var19), (double)((var31 + (float)var24) * var21 + var20));
                     var3.func_78374_a((double)(var32 + (float)var34 + 0.0F), (double)(var12 + var5), (double)(var33 + 0.0F), (double)((var30 + (float)var34 + 0.5F) * var21 + var19), (double)((var31 + 0.0F) * var21 + var20));
                     var3.func_78374_a((double)(var32 + (float)var34 + 0.0F), (double)(var12 + 0.0F), (double)(var33 + 0.0F), (double)((var30 + (float)var34 + 0.5F) * var21 + var19), (double)((var31 + 0.0F) * var21 + var20));
                  }
               }

               if(var28 <= 1) {
                  var3.func_78375_b(1.0F, 0.0F, 0.0F);

                  for(var34 = 0; var34 < var24; ++var34) {
                     var3.func_78374_a((double)(var32 + (float)var34 + 1.0F - var26), (double)(var12 + 0.0F), (double)(var33 + (float)var24), (double)((var30 + (float)var34 + 0.5F) * var21 + var19), (double)((var31 + (float)var24) * var21 + var20));
                     var3.func_78374_a((double)(var32 + (float)var34 + 1.0F - var26), (double)(var12 + var5), (double)(var33 + (float)var24), (double)((var30 + (float)var34 + 0.5F) * var21 + var19), (double)((var31 + (float)var24) * var21 + var20));
                     var3.func_78374_a((double)(var32 + (float)var34 + 1.0F - var26), (double)(var12 + var5), (double)(var33 + 0.0F), (double)((var30 + (float)var34 + 0.5F) * var21 + var19), (double)((var31 + 0.0F) * var21 + var20));
                     var3.func_78374_a((double)(var32 + (float)var34 + 1.0F - var26), (double)(var12 + 0.0F), (double)(var33 + 0.0F), (double)((var30 + (float)var34 + 0.5F) * var21 + var19), (double)((var31 + 0.0F) * var21 + var20));
                  }
               }

               var3.func_78369_a(var16 * 0.8F, var17 * 0.8F, var18 * 0.8F, 0.8F);
               if(var29 > -1) {
                  var3.func_78375_b(0.0F, 0.0F, -1.0F);

                  for(var34 = 0; var34 < var24; ++var34) {
                     var3.func_78374_a((double)(var32 + 0.0F), (double)(var12 + var5), (double)(var33 + (float)var34 + 0.0F), (double)((var30 + 0.0F) * var21 + var19), (double)((var31 + (float)var34 + 0.5F) * var21 + var20));
                     var3.func_78374_a((double)(var32 + (float)var24), (double)(var12 + var5), (double)(var33 + (float)var34 + 0.0F), (double)((var30 + (float)var24) * var21 + var19), (double)((var31 + (float)var34 + 0.5F) * var21 + var20));
                     var3.func_78374_a((double)(var32 + (float)var24), (double)(var12 + 0.0F), (double)(var33 + (float)var34 + 0.0F), (double)((var30 + (float)var24) * var21 + var19), (double)((var31 + (float)var34 + 0.5F) * var21 + var20));
                     var3.func_78374_a((double)(var32 + 0.0F), (double)(var12 + 0.0F), (double)(var33 + (float)var34 + 0.0F), (double)((var30 + 0.0F) * var21 + var19), (double)((var31 + (float)var34 + 0.5F) * var21 + var20));
                  }
               }

               if(var29 <= 1) {
                  var3.func_78375_b(0.0F, 0.0F, 1.0F);

                  for(var34 = 0; var34 < var24; ++var34) {
                     var3.func_78374_a((double)(var32 + 0.0F), (double)(var12 + var5), (double)(var33 + (float)var34 + 1.0F - var26), (double)((var30 + 0.0F) * var21 + var19), (double)((var31 + (float)var34 + 0.5F) * var21 + var20));
                     var3.func_78374_a((double)(var32 + (float)var24), (double)(var12 + var5), (double)(var33 + (float)var34 + 1.0F - var26), (double)((var30 + (float)var24) * var21 + var19), (double)((var31 + (float)var34 + 0.5F) * var21 + var20));
                     var3.func_78374_a((double)(var32 + (float)var24), (double)(var12 + 0.0F), (double)(var33 + (float)var34 + 1.0F - var26), (double)((var30 + (float)var24) * var21 + var19), (double)((var31 + (float)var34 + 0.5F) * var21 + var20));
                     var3.func_78374_a((double)(var32 + 0.0F), (double)(var12 + 0.0F), (double)(var33 + (float)var34 + 1.0F - var26), (double)((var30 + 0.0F) * var21 + var19), (double)((var31 + (float)var34 + 0.5F) * var21 + var20));
                  }
               }

               var3.func_78381_a();
            }
         }
      }

      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(3042);
      GL11.glEnable(2884);
   }

   public boolean func_72716_a(EntityLivingBase p_72716_1_, boolean p_72716_2_) {
      byte var3 = 2;
      RenderSorter var4 = new RenderSorter(p_72716_1_);
      WorldRenderer[] var5 = new WorldRenderer[var3];
      ArrayList var6 = null;
      int var7 = this.field_72767_j.size();
      int var8 = 0;
      this.field_72769_h.field_72984_F.func_76320_a("nearChunksSearch");

      int var9;
      WorldRenderer var10;
      int var11;
      int var12;
      label136:
      for(var9 = 0; var9 < var7; ++var9) {
         var10 = (WorldRenderer)this.field_72767_j.get(var9);
         if(var10 != null) {
            if(!p_72716_2_) {
               if(var10.func_78912_a(p_72716_1_) > 272.0F) {
                  for(var11 = 0; var11 < var3 && (var5[var11] == null || var4.compare(var5[var11], var10) <= 0); ++var11) {
                     ;
                  }

                  --var11;
                  if(var11 > 0) {
                     var12 = var11;

                     while(true) {
                        --var12;
                        if(var12 == 0) {
                           var5[var11] = var10;
                           continue label136;
                        }

                        var5[var12 - 1] = var5[var12];
                     }
                  }
                  continue;
               }
            } else if(!var10.field_78927_l) {
               continue;
            }

            if(var6 == null) {
               var6 = new ArrayList();
            }

            ++var8;
            var6.add(var10);
            this.field_72767_j.set(var9, (Object)null);
         }
      }

      this.field_72769_h.field_72984_F.func_76319_b();
      this.field_72769_h.field_72984_F.func_76320_a("sort");
      if(var6 != null) {
         if(var6.size() > 1) {
            Collections.sort(var6, var4);
         }

         for(var9 = var6.size() - 1; var9 >= 0; --var9) {
            var10 = (WorldRenderer)var6.get(var9);
            var10.func_147892_a(p_72716_1_);
            var10.field_78939_q = false;
         }
      }

      this.field_72769_h.field_72984_F.func_76319_b();
      var9 = 0;
      this.field_72769_h.field_72984_F.func_76320_a("rebuild");

      int var16;
      for(var16 = var3 - 1; var16 >= 0; --var16) {
         WorldRenderer var17 = var5[var16];
         if(var17 != null) {
            if(!var17.field_78927_l && var16 != var3 - 1) {
               var5[var16] = null;
               var5[0] = null;
               break;
            }

            var5[var16].func_147892_a(p_72716_1_);
            var5[var16].field_78939_q = false;
            ++var9;
         }
      }

      this.field_72769_h.field_72984_F.func_76319_b();
      this.field_72769_h.field_72984_F.func_76320_a("cleanup");
      var16 = 0;
      var11 = 0;

      for(var12 = this.field_72767_j.size(); var16 != var12; ++var16) {
         WorldRenderer var13 = (WorldRenderer)this.field_72767_j.get(var16);
         if(var13 != null) {
            boolean var14 = false;

            for(int var15 = 0; var15 < var3 && !var14; ++var15) {
               if(var13 == var5[var15]) {
                  var14 = true;
               }
            }

            if(!var14) {
               if(var11 != var16) {
                  this.field_72767_j.set(var11, var13);
               }

               ++var11;
            }
         }
      }

      this.field_72769_h.field_72984_F.func_76319_b();
      this.field_72769_h.field_72984_F.func_76320_a("trim");

      while(true) {
         --var16;
         if(var16 < var11) {
            this.field_72769_h.field_72984_F.func_76319_b();
            return var7 == var8 + var9;
         }

         this.field_72767_j.remove(var16);
      }
   }

   public void func_72717_a(Tessellator p_72717_1_, EntityPlayer p_72717_2_, float p_72717_3_) {
      double var4 = p_72717_2_.field_70142_S + (p_72717_2_.field_70165_t - p_72717_2_.field_70142_S) * (double)p_72717_3_;
      double var6 = p_72717_2_.field_70137_T + (p_72717_2_.field_70163_u - p_72717_2_.field_70137_T) * (double)p_72717_3_;
      double var8 = p_72717_2_.field_70136_U + (p_72717_2_.field_70161_v - p_72717_2_.field_70136_U) * (double)p_72717_3_;
      if(!this.field_72738_E.isEmpty()) {
         OpenGlHelper.func_148821_a(774, 768, 1, 0);
         this.field_72770_i.func_110577_a(TextureMap.field_110575_b);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
         GL11.glPushMatrix();
         GL11.glPolygonOffset(-3.0F, -3.0F);
         GL11.glEnable('\u8037');
         GL11.glAlphaFunc(516, 0.1F);
         GL11.glEnable(3008);
         p_72717_1_.func_78382_b();
         p_72717_1_.func_78373_b(-var4, -var6, -var8);
         p_72717_1_.func_78383_c();
         Iterator var10 = this.field_72738_E.values().iterator();

         while(var10.hasNext()) {
            DestroyBlockProgress var11 = (DestroyBlockProgress)var10.next();
            double var12 = (double)var11.func_73110_b() - var4;
            double var14 = (double)var11.func_73109_c() - var6;
            double var16 = (double)var11.func_73108_d() - var8;
            if(var12 * var12 + var14 * var14 + var16 * var16 > 1024.0D) {
               var10.remove();
            } else {
               Block var18 = this.field_72769_h.func_147439_a(var11.func_73110_b(), var11.func_73109_c(), var11.func_73108_d());
               if(var18.func_149688_o() != Material.field_151579_a) {
                  this.field_147592_B.func_147792_a(var18, var11.func_73110_b(), var11.func_73109_c(), var11.func_73108_d(), this.field_94141_F[var11.func_73106_e()]);
               }
            }
         }

         p_72717_1_.func_78381_a();
         p_72717_1_.func_78373_b(0.0D, 0.0D, 0.0D);
         GL11.glDisable(3008);
         GL11.glPolygonOffset(0.0F, 0.0F);
         GL11.glDisable('\u8037');
         GL11.glEnable(3008);
         GL11.glDepthMask(true);
         GL11.glPopMatrix();
      }

   }

   public void func_72731_b(EntityPlayer p_72731_1_, MovingObjectPosition p_72731_2_, int p_72731_3_, float p_72731_4_) {
      if(p_72731_3_ == 0 && p_72731_2_.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
         GL11.glEnable(3042);
         OpenGlHelper.func_148821_a(770, 771, 1, 0);
         GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.4F);
         GL11.glLineWidth(2.0F);
         GL11.glDisable(3553);
         GL11.glDepthMask(false);
         float var5 = 0.002F;
         Block var6 = this.field_72769_h.func_147439_a(p_72731_2_.field_72311_b, p_72731_2_.field_72312_c, p_72731_2_.field_72309_d);
         if(var6.func_149688_o() != Material.field_151579_a) {
            var6.func_149719_a(this.field_72769_h, p_72731_2_.field_72311_b, p_72731_2_.field_72312_c, p_72731_2_.field_72309_d);
            double var7 = p_72731_1_.field_70142_S + (p_72731_1_.field_70165_t - p_72731_1_.field_70142_S) * (double)p_72731_4_;
            double var9 = p_72731_1_.field_70137_T + (p_72731_1_.field_70163_u - p_72731_1_.field_70137_T) * (double)p_72731_4_;
            double var11 = p_72731_1_.field_70136_U + (p_72731_1_.field_70161_v - p_72731_1_.field_70136_U) * (double)p_72731_4_;
            func_147590_a(var6.func_149633_g(this.field_72769_h, p_72731_2_.field_72311_b, p_72731_2_.field_72312_c, p_72731_2_.field_72309_d).func_72314_b((double)var5, (double)var5, (double)var5).func_72325_c(-var7, -var9, -var11), -1);
         }

         GL11.glDepthMask(true);
         GL11.glEnable(3553);
         GL11.glDisable(3042);
      }

   }

   public static void func_147590_a(AxisAlignedBB p_147590_0_, int p_147590_1_) {
      Tessellator var2 = Tessellator.field_78398_a;
      var2.func_78371_b(3);
      if(p_147590_1_ != -1) {
         var2.func_78378_d(p_147590_1_);
      }

      var2.func_78377_a(p_147590_0_.field_72340_a, p_147590_0_.field_72338_b, p_147590_0_.field_72339_c);
      var2.func_78377_a(p_147590_0_.field_72336_d, p_147590_0_.field_72338_b, p_147590_0_.field_72339_c);
      var2.func_78377_a(p_147590_0_.field_72336_d, p_147590_0_.field_72338_b, p_147590_0_.field_72334_f);
      var2.func_78377_a(p_147590_0_.field_72340_a, p_147590_0_.field_72338_b, p_147590_0_.field_72334_f);
      var2.func_78377_a(p_147590_0_.field_72340_a, p_147590_0_.field_72338_b, p_147590_0_.field_72339_c);
      var2.func_78381_a();
      var2.func_78371_b(3);
      if(p_147590_1_ != -1) {
         var2.func_78378_d(p_147590_1_);
      }

      var2.func_78377_a(p_147590_0_.field_72340_a, p_147590_0_.field_72337_e, p_147590_0_.field_72339_c);
      var2.func_78377_a(p_147590_0_.field_72336_d, p_147590_0_.field_72337_e, p_147590_0_.field_72339_c);
      var2.func_78377_a(p_147590_0_.field_72336_d, p_147590_0_.field_72337_e, p_147590_0_.field_72334_f);
      var2.func_78377_a(p_147590_0_.field_72340_a, p_147590_0_.field_72337_e, p_147590_0_.field_72334_f);
      var2.func_78377_a(p_147590_0_.field_72340_a, p_147590_0_.field_72337_e, p_147590_0_.field_72339_c);
      var2.func_78381_a();
      var2.func_78371_b(1);
      if(p_147590_1_ != -1) {
         var2.func_78378_d(p_147590_1_);
      }

      var2.func_78377_a(p_147590_0_.field_72340_a, p_147590_0_.field_72338_b, p_147590_0_.field_72339_c);
      var2.func_78377_a(p_147590_0_.field_72340_a, p_147590_0_.field_72337_e, p_147590_0_.field_72339_c);
      var2.func_78377_a(p_147590_0_.field_72336_d, p_147590_0_.field_72338_b, p_147590_0_.field_72339_c);
      var2.func_78377_a(p_147590_0_.field_72336_d, p_147590_0_.field_72337_e, p_147590_0_.field_72339_c);
      var2.func_78377_a(p_147590_0_.field_72336_d, p_147590_0_.field_72338_b, p_147590_0_.field_72334_f);
      var2.func_78377_a(p_147590_0_.field_72336_d, p_147590_0_.field_72337_e, p_147590_0_.field_72334_f);
      var2.func_78377_a(p_147590_0_.field_72340_a, p_147590_0_.field_72338_b, p_147590_0_.field_72334_f);
      var2.func_78377_a(p_147590_0_.field_72340_a, p_147590_0_.field_72337_e, p_147590_0_.field_72334_f);
      var2.func_78381_a();
   }

   public void func_72725_b(int p_72725_1_, int p_72725_2_, int p_72725_3_, int p_72725_4_, int p_72725_5_, int p_72725_6_) {
      int var7 = MathHelper.func_76137_a(p_72725_1_, 16);
      int var8 = MathHelper.func_76137_a(p_72725_2_, 16);
      int var9 = MathHelper.func_76137_a(p_72725_3_, 16);
      int var10 = MathHelper.func_76137_a(p_72725_4_, 16);
      int var11 = MathHelper.func_76137_a(p_72725_5_, 16);
      int var12 = MathHelper.func_76137_a(p_72725_6_, 16);

      for(int var13 = var7; var13 <= var10; ++var13) {
         int var14 = var13 % this.field_72766_m;
         if(var14 < 0) {
            var14 += this.field_72766_m;
         }

         for(int var15 = var8; var15 <= var11; ++var15) {
            int var16 = var15 % this.field_72763_n;
            if(var16 < 0) {
               var16 += this.field_72763_n;
            }

            for(int var17 = var9; var17 <= var12; ++var17) {
               int var18 = var17 % this.field_72764_o;
               if(var18 < 0) {
                  var18 += this.field_72764_o;
               }

               int var19 = (var18 * this.field_72763_n + var16) * this.field_72766_m + var14;
               WorldRenderer var20 = this.field_72765_l[var19];
               if(var20 != null && !var20.field_78939_q) {
                  this.field_72767_j.add(var20);
                  var20.func_78914_f();
               }
            }
         }
      }

   }

   public void func_147586_a(int p_147586_1_, int p_147586_2_, int p_147586_3_) {
      this.func_72725_b(p_147586_1_ - 1, p_147586_2_ - 1, p_147586_3_ - 1, p_147586_1_ + 1, p_147586_2_ + 1, p_147586_3_ + 1);
   }

   public void func_147588_b(int p_147588_1_, int p_147588_2_, int p_147588_3_) {
      this.func_72725_b(p_147588_1_ - 1, p_147588_2_ - 1, p_147588_3_ - 1, p_147588_1_ + 1, p_147588_2_ + 1, p_147588_3_ + 1);
   }

   public void func_147585_a(int p_147585_1_, int p_147585_2_, int p_147585_3_, int p_147585_4_, int p_147585_5_, int p_147585_6_) {
      this.func_72725_b(p_147585_1_ - 1, p_147585_2_ - 1, p_147585_3_ - 1, p_147585_4_ + 1, p_147585_5_ + 1, p_147585_6_ + 1);
   }

   public void func_72729_a(ICamera p_72729_1_, float p_72729_2_) {
      for(int var3 = 0; var3 < this.field_72765_l.length; ++var3) {
         if(!this.field_72765_l[var3].func_78906_e() && (!this.field_72765_l[var3].field_78927_l || (var3 + this.field_72757_g & 15) == 0)) {
            this.field_72765_l[var3].func_78908_a(p_72729_1_);
         }
      }

      ++this.field_72757_g;
   }

   public void func_72702_a(String p_72702_1_, int p_72702_2_, int p_72702_3_, int p_72702_4_) {
      ChunkCoordinates var5 = new ChunkCoordinates(p_72702_2_, p_72702_3_, p_72702_4_);
      ISound var6 = (ISound)this.field_147593_P.get(var5);
      if(var6 != null) {
         this.field_72777_q.func_147118_V().func_147683_b(var6);
         this.field_147593_P.remove(var5);
      }

      if(p_72702_1_ != null) {
         ItemRecord var7 = ItemRecord.func_150926_b(p_72702_1_);
         if(var7 != null) {
            this.field_72777_q.field_71456_v.func_73833_a(var7.func_150927_i());
         }

         PositionedSoundRecord var8 = PositionedSoundRecord.func_147675_a(new ResourceLocation(p_72702_1_), (float)p_72702_2_, (float)p_72702_3_, (float)p_72702_4_);
         this.field_147593_P.put(var5, var8);
         this.field_72777_q.func_147118_V().func_147682_a(var8);
      }

   }

   public void func_72704_a(String p_72704_1_, double p_72704_2_, double p_72704_4_, double p_72704_6_, float p_72704_8_, float p_72704_9_) {}

   public void func_85102_a(EntityPlayer p_85102_1_, String p_85102_2_, double p_85102_3_, double p_85102_5_, double p_85102_7_, float p_85102_9_, float p_85102_10_) {}

   public void func_72708_a(String p_72708_1_, final double p_72708_2_, final double p_72708_4_, final double p_72708_6_, double p_72708_8_, double p_72708_10_, double p_72708_12_) {
      try {
         this.func_72726_b(p_72708_1_, p_72708_2_, p_72708_4_, p_72708_6_, p_72708_8_, p_72708_10_, p_72708_12_);
      } catch (Throwable var17) {
         CrashReport var15 = CrashReport.func_85055_a(var17, "Exception while adding particle");
         CrashReportCategory var16 = var15.func_85058_a("Particle being added");
         var16.func_71507_a("Name", p_72708_1_);
         var16.func_71500_a("Position", new Callable() {

            private static final String __OBFID = "CL_00000955";

            public String call() {
               return CrashReportCategory.func_85074_a(p_72708_2_, p_72708_4_, p_72708_6_);
            }
            // $FF: synthetic method
            public Object call() {
               return this.call();
            }
         });
         throw new ReportedException(var15);
      }
   }

   public EntityFX func_72726_b(String p_72726_1_, double p_72726_2_, double p_72726_4_, double p_72726_6_, double p_72726_8_, double p_72726_10_, double p_72726_12_) {
      if(this.field_72777_q != null && this.field_72777_q.field_71451_h != null && this.field_72777_q.field_71452_i != null) {
         int var14 = this.field_72777_q.field_71474_y.field_74362_aa;
         if(var14 == 1 && this.field_72769_h.field_73012_v.nextInt(3) == 0) {
            var14 = 2;
         }

         double var15 = this.field_72777_q.field_71451_h.field_70165_t - p_72726_2_;
         double var17 = this.field_72777_q.field_71451_h.field_70163_u - p_72726_4_;
         double var19 = this.field_72777_q.field_71451_h.field_70161_v - p_72726_6_;
         Object var21 = null;
         if(p_72726_1_.equals("hugeexplosion")) {
            this.field_72777_q.field_71452_i.func_78873_a(var21 = new EntityHugeExplodeFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_));
         } else if(p_72726_1_.equals("largeexplode")) {
            this.field_72777_q.field_71452_i.func_78873_a(var21 = new EntityLargeExplodeFX(this.field_72770_i, this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_));
         } else if(p_72726_1_.equals("fireworksSpark")) {
            this.field_72777_q.field_71452_i.func_78873_a(var21 = new EntityFireworkSparkFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, this.field_72777_q.field_71452_i));
         }

         if(var21 != null) {
            return (EntityFX)var21;
         } else {
            double var22 = 16.0D;
            if(var15 * var15 + var17 * var17 + var19 * var19 > var22 * var22) {
               return null;
            } else if(var14 > 1) {
               return null;
            } else {
               if(p_72726_1_.equals("bubble")) {
                  var21 = new EntityBubbleFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if(p_72726_1_.equals("suspended")) {
                  var21 = new EntitySuspendFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if(p_72726_1_.equals("depthsuspend")) {
                  var21 = new EntityAuraFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if(p_72726_1_.equals("townaura")) {
                  var21 = new EntityAuraFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if(p_72726_1_.equals("crit")) {
                  var21 = new EntityCritFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if(p_72726_1_.equals("magicCrit")) {
                  var21 = new EntityCritFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
                  ((EntityFX)var21).func_70538_b(((EntityFX)var21).func_70534_d() * 0.3F, ((EntityFX)var21).func_70542_f() * 0.8F, ((EntityFX)var21).func_70535_g());
                  ((EntityFX)var21).func_94053_h();
               } else if(p_72726_1_.equals("smoke")) {
                  var21 = new EntitySmokeFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if(p_72726_1_.equals("mobSpell")) {
                  var21 = new EntitySpellParticleFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, 0.0D, 0.0D, 0.0D);
                  ((EntityFX)var21).func_70538_b((float)p_72726_8_, (float)p_72726_10_, (float)p_72726_12_);
               } else if(p_72726_1_.equals("mobSpellAmbient")) {
                  var21 = new EntitySpellParticleFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, 0.0D, 0.0D, 0.0D);
                  ((EntityFX)var21).func_82338_g(0.15F);
                  ((EntityFX)var21).func_70538_b((float)p_72726_8_, (float)p_72726_10_, (float)p_72726_12_);
               } else if(p_72726_1_.equals("spell")) {
                  var21 = new EntitySpellParticleFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if(p_72726_1_.equals("instantSpell")) {
                  var21 = new EntitySpellParticleFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
                  ((EntitySpellParticleFX)var21).func_70589_b(144);
               } else if(p_72726_1_.equals("witchMagic")) {
                  var21 = new EntitySpellParticleFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
                  ((EntitySpellParticleFX)var21).func_70589_b(144);
                  float var24 = this.field_72769_h.field_73012_v.nextFloat() * 0.5F + 0.35F;
                  ((EntityFX)var21).func_70538_b(1.0F * var24, 0.0F * var24, 1.0F * var24);
               } else if(p_72726_1_.equals("note")) {
                  var21 = new EntityNoteFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if(p_72726_1_.equals("portal")) {
                  var21 = new EntityPortalFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if(p_72726_1_.equals("enchantmenttable")) {
                  var21 = new EntityEnchantmentTableParticleFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if(p_72726_1_.equals("explode")) {
                  var21 = new EntityExplodeFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if(p_72726_1_.equals("flame")) {
                  var21 = new EntityFlameFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if(p_72726_1_.equals("lava")) {
                  var21 = new EntityLavaFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_);
               } else if(p_72726_1_.equals("footstep")) {
                  var21 = new EntityFootStepFX(this.field_72770_i, this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_);
               } else if(p_72726_1_.equals("splash")) {
                  var21 = new EntitySplashFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if(p_72726_1_.equals("wake")) {
                  var21 = new EntityFishWakeFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if(p_72726_1_.equals("largesmoke")) {
                  var21 = new EntitySmokeFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, 2.5F);
               } else if(p_72726_1_.equals("cloud")) {
                  var21 = new EntityCloudFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if(p_72726_1_.equals("reddust")) {
                  var21 = new EntityReddustFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, (float)p_72726_8_, (float)p_72726_10_, (float)p_72726_12_);
               } else if(p_72726_1_.equals("snowballpoof")) {
                  var21 = new EntityBreakingFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, Items.field_151126_ay);
               } else if(p_72726_1_.equals("dripWater")) {
                  var21 = new EntityDropParticleFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, Material.field_151586_h);
               } else if(p_72726_1_.equals("dripLava")) {
                  var21 = new EntityDropParticleFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, Material.field_151587_i);
               } else if(p_72726_1_.equals("snowshovel")) {
                  var21 = new EntitySnowShovelFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if(p_72726_1_.equals("slime")) {
                  var21 = new EntityBreakingFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, Items.field_151123_aH);
               } else if(p_72726_1_.equals("heart")) {
                  var21 = new EntityHeartFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
               } else if(p_72726_1_.equals("angryVillager")) {
                  var21 = new EntityHeartFX(this.field_72769_h, p_72726_2_, p_72726_4_ + 0.5D, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
                  ((EntityFX)var21).func_70536_a(81);
                  ((EntityFX)var21).func_70538_b(1.0F, 1.0F, 1.0F);
               } else if(p_72726_1_.equals("happyVillager")) {
                  var21 = new EntityAuraFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
                  ((EntityFX)var21).func_70536_a(82);
                  ((EntityFX)var21).func_70538_b(1.0F, 1.0F, 1.0F);
               } else {
                  int var26;
                  String[] var27;
                  if(p_72726_1_.startsWith("iconcrack_")) {
                     var27 = p_72726_1_.split("_", 3);
                     int var25 = Integer.parseInt(var27[1]);
                     if(var27.length > 2) {
                        var26 = Integer.parseInt(var27[2]);
                        var21 = new EntityBreakingFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, Item.func_150899_d(var25), var26);
                     } else {
                        var21 = new EntityBreakingFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, Item.func_150899_d(var25), 0);
                     }
                  } else {
                     Block var28;
                     if(p_72726_1_.startsWith("blockcrack_")) {
                        var27 = p_72726_1_.split("_", 3);
                        var28 = Block.func_149729_e(Integer.parseInt(var27[1]));
                        var26 = Integer.parseInt(var27[2]);
                        var21 = (new EntityDiggingFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, var28, var26)).func_90019_g(var26);
                     } else if(p_72726_1_.startsWith("blockdust_")) {
                        var27 = p_72726_1_.split("_", 3);
                        var28 = Block.func_149729_e(Integer.parseInt(var27[1]));
                        var26 = Integer.parseInt(var27[2]);
                        var21 = (new EntityBlockDustFX(this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, var28, var26)).func_90019_g(var26);
                     }
                  }
               }

               if(var21 != null) {
                  this.field_72777_q.field_71452_i.func_78873_a((EntityFX)var21);
               }

               return (EntityFX)var21;
            }
         }
      } else {
         return null;
      }
   }

   public void func_72703_a(Entity p_72703_1_) {}

   public void func_72709_b(Entity p_72709_1_) {}

   public void func_72728_f() {
      GLAllocation.func_74523_b(this.field_72778_p);
   }

   public void func_82746_a(int p_82746_1_, int p_82746_2_, int p_82746_3_, int p_82746_4_, int p_82746_5_) {
      Random var6 = this.field_72769_h.field_73012_v;
      switch(p_82746_1_) {
      case 1013:
      case 1018:
         if(this.field_72777_q.field_71451_h != null) {
            double var7 = (double)p_82746_2_ - this.field_72777_q.field_71451_h.field_70165_t;
            double var9 = (double)p_82746_3_ - this.field_72777_q.field_71451_h.field_70163_u;
            double var11 = (double)p_82746_4_ - this.field_72777_q.field_71451_h.field_70161_v;
            double var13 = Math.sqrt(var7 * var7 + var9 * var9 + var11 * var11);
            double var15 = this.field_72777_q.field_71451_h.field_70165_t;
            double var17 = this.field_72777_q.field_71451_h.field_70163_u;
            double var19 = this.field_72777_q.field_71451_h.field_70161_v;
            if(var13 > 0.0D) {
               var15 += var7 / var13 * 2.0D;
               var17 += var9 / var13 * 2.0D;
               var19 += var11 / var13 * 2.0D;
            }

            if(p_82746_1_ == 1013) {
               this.field_72769_h.func_72980_b(var15, var17, var19, "mob.wither.spawn", 1.0F, 1.0F, false);
            } else if(p_82746_1_ == 1018) {
               this.field_72769_h.func_72980_b(var15, var17, var19, "mob.enderdragon.end", 5.0F, 1.0F, false);
            }
         }
      default:
      }
   }

   public void func_72706_a(EntityPlayer p_72706_1_, int p_72706_2_, int p_72706_3_, int p_72706_4_, int p_72706_5_, int p_72706_6_) {
      Random var7 = this.field_72769_h.field_73012_v;
      Block var8 = null;
      double var9;
      double var11;
      double var13;
      String var15;
      int var16;
      double var22;
      double var26;
      double var28;
      double var30;
      int var40;
      double var41;
      switch(p_72706_2_) {
      case 1000:
         this.field_72769_h.func_72980_b((double)p_72706_3_, (double)p_72706_4_, (double)p_72706_5_, "random.click", 1.0F, 1.0F, false);
         break;
      case 1001:
         this.field_72769_h.func_72980_b((double)p_72706_3_, (double)p_72706_4_, (double)p_72706_5_, "random.click", 1.0F, 1.2F, false);
         break;
      case 1002:
         this.field_72769_h.func_72980_b((double)p_72706_3_, (double)p_72706_4_, (double)p_72706_5_, "random.bow", 1.0F, 1.2F, false);
         break;
      case 1003:
         if(Math.random() < 0.5D) {
            this.field_72769_h.func_72980_b((double)p_72706_3_ + 0.5D, (double)p_72706_4_ + 0.5D, (double)p_72706_5_ + 0.5D, "random.door_open", 1.0F, this.field_72769_h.field_73012_v.nextFloat() * 0.1F + 0.9F, false);
         } else {
            this.field_72769_h.func_72980_b((double)p_72706_3_ + 0.5D, (double)p_72706_4_ + 0.5D, (double)p_72706_5_ + 0.5D, "random.door_close", 1.0F, this.field_72769_h.field_73012_v.nextFloat() * 0.1F + 0.9F, false);
         }
         break;
      case 1004:
         this.field_72769_h.func_72980_b((double)((float)p_72706_3_ + 0.5F), (double)((float)p_72706_4_ + 0.5F), (double)((float)p_72706_5_ + 0.5F), "random.fizz", 0.5F, 2.6F + (var7.nextFloat() - var7.nextFloat()) * 0.8F, false);
         break;
      case 1005:
         if(Item.func_150899_d(p_72706_6_) instanceof ItemRecord) {
            this.field_72769_h.func_72934_a("records." + ((ItemRecord)Item.func_150899_d(p_72706_6_)).field_150929_a, p_72706_3_, p_72706_4_, p_72706_5_);
         } else {
            this.field_72769_h.func_72934_a((String)null, p_72706_3_, p_72706_4_, p_72706_5_);
         }
         break;
      case 1007:
         this.field_72769_h.func_72980_b((double)p_72706_3_ + 0.5D, (double)p_72706_4_ + 0.5D, (double)p_72706_5_ + 0.5D, "mob.ghast.charge", 10.0F, (var7.nextFloat() - var7.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1008:
         this.field_72769_h.func_72980_b((double)p_72706_3_ + 0.5D, (double)p_72706_4_ + 0.5D, (double)p_72706_5_ + 0.5D, "mob.ghast.fireball", 10.0F, (var7.nextFloat() - var7.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1009:
         this.field_72769_h.func_72980_b((double)p_72706_3_ + 0.5D, (double)p_72706_4_ + 0.5D, (double)p_72706_5_ + 0.5D, "mob.ghast.fireball", 2.0F, (var7.nextFloat() - var7.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1010:
         this.field_72769_h.func_72980_b((double)p_72706_3_ + 0.5D, (double)p_72706_4_ + 0.5D, (double)p_72706_5_ + 0.5D, "mob.zombie.wood", 2.0F, (var7.nextFloat() - var7.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1011:
         this.field_72769_h.func_72980_b((double)p_72706_3_ + 0.5D, (double)p_72706_4_ + 0.5D, (double)p_72706_5_ + 0.5D, "mob.zombie.metal", 2.0F, (var7.nextFloat() - var7.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1012:
         this.field_72769_h.func_72980_b((double)p_72706_3_ + 0.5D, (double)p_72706_4_ + 0.5D, (double)p_72706_5_ + 0.5D, "mob.zombie.woodbreak", 2.0F, (var7.nextFloat() - var7.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1014:
         this.field_72769_h.func_72980_b((double)p_72706_3_ + 0.5D, (double)p_72706_4_ + 0.5D, (double)p_72706_5_ + 0.5D, "mob.wither.shoot", 2.0F, (var7.nextFloat() - var7.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1015:
         this.field_72769_h.func_72980_b((double)p_72706_3_ + 0.5D, (double)p_72706_4_ + 0.5D, (double)p_72706_5_ + 0.5D, "mob.bat.takeoff", 0.05F, (var7.nextFloat() - var7.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1016:
         this.field_72769_h.func_72980_b((double)p_72706_3_ + 0.5D, (double)p_72706_4_ + 0.5D, (double)p_72706_5_ + 0.5D, "mob.zombie.infect", 2.0F, (var7.nextFloat() - var7.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1017:
         this.field_72769_h.func_72980_b((double)p_72706_3_ + 0.5D, (double)p_72706_4_ + 0.5D, (double)p_72706_5_ + 0.5D, "mob.zombie.unfect", 2.0F, (var7.nextFloat() - var7.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1020:
         this.field_72769_h.func_72980_b((double)((float)p_72706_3_ + 0.5F), (double)((float)p_72706_4_ + 0.5F), (double)((float)p_72706_5_ + 0.5F), "random.anvil_break", 1.0F, this.field_72769_h.field_73012_v.nextFloat() * 0.1F + 0.9F, false);
         break;
      case 1021:
         this.field_72769_h.func_72980_b((double)((float)p_72706_3_ + 0.5F), (double)((float)p_72706_4_ + 0.5F), (double)((float)p_72706_5_ + 0.5F), "random.anvil_use", 1.0F, this.field_72769_h.field_73012_v.nextFloat() * 0.1F + 0.9F, false);
         break;
      case 1022:
         this.field_72769_h.func_72980_b((double)((float)p_72706_3_ + 0.5F), (double)((float)p_72706_4_ + 0.5F), (double)((float)p_72706_5_ + 0.5F), "random.anvil_land", 0.3F, this.field_72769_h.field_73012_v.nextFloat() * 0.1F + 0.9F, false);
         break;
      case 2000:
         int var34 = p_72706_6_ % 3 - 1;
         int var10 = p_72706_6_ / 3 % 3 - 1;
         var11 = (double)p_72706_3_ + (double)var34 * 0.6D + 0.5D;
         var13 = (double)p_72706_4_ + 0.5D;
         double var35 = (double)p_72706_5_ + (double)var10 * 0.6D + 0.5D;

         for(int var37 = 0; var37 < 10; ++var37) {
            double var38 = var7.nextDouble() * 0.2D + 0.01D;
            double var39 = var11 + (double)var34 * 0.01D + (var7.nextDouble() - 0.5D) * (double)var10 * 0.5D;
            var22 = var13 + (var7.nextDouble() - 0.5D) * 0.5D;
            var41 = var35 + (double)var10 * 0.01D + (var7.nextDouble() - 0.5D) * (double)var34 * 0.5D;
            var26 = (double)var34 * var38 + var7.nextGaussian() * 0.01D;
            var28 = -0.03D + var7.nextGaussian() * 0.01D;
            var30 = (double)var10 * var38 + var7.nextGaussian() * 0.01D;
            this.func_72708_a("smoke", var39, var22, var41, var26, var28, var30);
         }

         return;
      case 2001:
         var8 = Block.func_149729_e(p_72706_6_ & 4095);
         if(var8.func_149688_o() != Material.field_151579_a) {
            this.field_72777_q.func_147118_V().func_147682_a(new PositionedSoundRecord(new ResourceLocation(var8.field_149762_H.func_150495_a()), (var8.field_149762_H.func_150497_c() + 1.0F) / 2.0F, var8.field_149762_H.func_150494_d() * 0.8F, (float)p_72706_3_ + 0.5F, (float)p_72706_4_ + 0.5F, (float)p_72706_5_ + 0.5F));
         }

         this.field_72777_q.field_71452_i.func_147215_a(p_72706_3_, p_72706_4_, p_72706_5_, var8, p_72706_6_ >> 12 & 255);
         break;
      case 2002:
         var9 = (double)p_72706_3_;
         var11 = (double)p_72706_4_;
         var13 = (double)p_72706_5_;
         var15 = "iconcrack_" + Item.func_150891_b(Items.field_151068_bn) + "_" + p_72706_6_;

         for(var16 = 0; var16 < 8; ++var16) {
            this.func_72708_a(var15, var9, var11, var13, var7.nextGaussian() * 0.15D, var7.nextDouble() * 0.2D, var7.nextGaussian() * 0.15D);
         }

         var16 = Items.field_151068_bn.func_77620_a(p_72706_6_);
         float var17 = (float)(var16 >> 16 & 255) / 255.0F;
         float var18 = (float)(var16 >> 8 & 255) / 255.0F;
         float var19 = (float)(var16 >> 0 & 255) / 255.0F;
         String var20 = "spell";
         if(Items.field_151068_bn.func_77833_h(p_72706_6_)) {
            var20 = "instantSpell";
         }

         for(var40 = 0; var40 < 100; ++var40) {
            var22 = var7.nextDouble() * 4.0D;
            var41 = var7.nextDouble() * 3.141592653589793D * 2.0D;
            var26 = Math.cos(var41) * var22;
            var28 = 0.01D + var7.nextDouble() * 0.5D;
            var30 = Math.sin(var41) * var22;
            EntityFX var42 = this.func_72726_b(var20, var9 + var26 * 0.1D, var11 + 0.3D, var13 + var30 * 0.1D, var26, var28, var30);
            if(var42 != null) {
               float var33 = 0.75F + var7.nextFloat() * 0.25F;
               var42.func_70538_b(var17 * var33, var18 * var33, var19 * var33);
               var42.func_70543_e((float)var22);
            }
         }

         this.field_72769_h.func_72980_b((double)p_72706_3_ + 0.5D, (double)p_72706_4_ + 0.5D, (double)p_72706_5_ + 0.5D, "game.potion.smash", 1.0F, this.field_72769_h.field_73012_v.nextFloat() * 0.1F + 0.9F, false);
         break;
      case 2003:
         var9 = (double)p_72706_3_ + 0.5D;
         var11 = (double)p_72706_4_;
         var13 = (double)p_72706_5_ + 0.5D;
         var15 = "iconcrack_" + Item.func_150891_b(Items.field_151061_bv);

         for(var16 = 0; var16 < 8; ++var16) {
            this.func_72708_a(var15, var9, var11, var13, var7.nextGaussian() * 0.15D, var7.nextDouble() * 0.2D, var7.nextGaussian() * 0.15D);
         }

         for(double var36 = 0.0D; var36 < 6.283185307179586D; var36 += 0.15707963267948966D) {
            this.func_72708_a("portal", var9 + Math.cos(var36) * 5.0D, var11 - 0.4D, var13 + Math.sin(var36) * 5.0D, Math.cos(var36) * -5.0D, 0.0D, Math.sin(var36) * -5.0D);
            this.func_72708_a("portal", var9 + Math.cos(var36) * 5.0D, var11 - 0.4D, var13 + Math.sin(var36) * 5.0D, Math.cos(var36) * -7.0D, 0.0D, Math.sin(var36) * -7.0D);
         }

         return;
      case 2004:
         for(var40 = 0; var40 < 20; ++var40) {
            var22 = (double)p_72706_3_ + 0.5D + ((double)this.field_72769_h.field_73012_v.nextFloat() - 0.5D) * 2.0D;
            var41 = (double)p_72706_4_ + 0.5D + ((double)this.field_72769_h.field_73012_v.nextFloat() - 0.5D) * 2.0D;
            var26 = (double)p_72706_5_ + 0.5D + ((double)this.field_72769_h.field_73012_v.nextFloat() - 0.5D) * 2.0D;
            this.field_72769_h.func_72869_a("smoke", var22, var41, var26, 0.0D, 0.0D, 0.0D);
            this.field_72769_h.func_72869_a("flame", var22, var41, var26, 0.0D, 0.0D, 0.0D);
         }

         return;
      case 2005:
         ItemDye.func_150918_a(this.field_72769_h, p_72706_3_, p_72706_4_, p_72706_5_, p_72706_6_);
         break;
      case 2006:
         var8 = this.field_72769_h.func_147439_a(p_72706_3_, p_72706_4_, p_72706_5_);
         if(var8.func_149688_o() != Material.field_151579_a) {
            double var21 = (double)Math.min(0.2F + (float)p_72706_6_ / 15.0F, 10.0F);
            if(var21 > 2.5D) {
               var21 = 2.5D;
            }

            int var23 = (int)(150.0D * var21);

            for(int var24 = 0; var24 < var23; ++var24) {
               float var25 = MathHelper.func_151240_a(var7, 0.0F, 6.2831855F);
               var26 = (double)MathHelper.func_151240_a(var7, 0.75F, 1.0F);
               var28 = 0.20000000298023224D + var21 / 100.0D;
               var30 = (double)(MathHelper.func_76134_b(var25) * 0.2F) * var26 * var26 * (var21 + 0.2D);
               double var32 = (double)(MathHelper.func_76126_a(var25) * 0.2F) * var26 * var26 * (var21 + 0.2D);
               this.field_72769_h.func_72869_a("blockdust_" + Block.func_149682_b(var8) + "_" + this.field_72769_h.func_72805_g(p_72706_3_, p_72706_4_, p_72706_5_), (double)((float)p_72706_3_ + 0.5F), (double)((float)p_72706_4_ + 1.0F), (double)((float)p_72706_5_ + 0.5F), var30, var28, var32);
            }
         }
      }

   }

   public void func_147587_b(int p_147587_1_, int p_147587_2_, int p_147587_3_, int p_147587_4_, int p_147587_5_) {
      if(p_147587_5_ >= 0 && p_147587_5_ < 10) {
         DestroyBlockProgress var6 = (DestroyBlockProgress)this.field_72738_E.get(Integer.valueOf(p_147587_1_));
         if(var6 == null || var6.func_73110_b() != p_147587_2_ || var6.func_73109_c() != p_147587_3_ || var6.func_73108_d() != p_147587_4_) {
            var6 = new DestroyBlockProgress(p_147587_1_, p_147587_2_, p_147587_3_, p_147587_4_);
            this.field_72738_E.put(Integer.valueOf(p_147587_1_), var6);
         }

         var6.func_73107_a(p_147587_5_);
         var6.func_82744_b(this.field_72773_u);
      } else {
         this.field_72738_E.remove(Integer.valueOf(p_147587_1_));
      }

   }

   public void func_94140_a(IIconRegister p_94140_1_) {
      this.field_94141_F = new IIcon[10];

      for(int var2 = 0; var2 < this.field_94141_F.length; ++var2) {
         this.field_94141_F[var2] = p_94140_1_.func_94245_a("destroy_stage_" + var2);
      }

   }

}
