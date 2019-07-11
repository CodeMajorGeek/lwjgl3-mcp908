package net.minecraft.client.renderer.entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.model.ModelHorse;
import net.minecraft.client.model.ModelOcelot;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.model.ModelSheep1;
import net.minecraft.client.model.ModelSheep2;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.model.ModelSquid;
import net.minecraft.client.model.ModelWolf;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderBat;
import net.minecraft.client.renderer.entity.RenderBlaze;
import net.minecraft.client.renderer.entity.RenderBoat;
import net.minecraft.client.renderer.entity.RenderCaveSpider;
import net.minecraft.client.renderer.entity.RenderChicken;
import net.minecraft.client.renderer.entity.RenderCow;
import net.minecraft.client.renderer.entity.RenderCreeper;
import net.minecraft.client.renderer.entity.RenderDragon;
import net.minecraft.client.renderer.entity.RenderEnderman;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderFallingBlock;
import net.minecraft.client.renderer.entity.RenderFireball;
import net.minecraft.client.renderer.entity.RenderFish;
import net.minecraft.client.renderer.entity.RenderGhast;
import net.minecraft.client.renderer.entity.RenderGiantZombie;
import net.minecraft.client.renderer.entity.RenderHorse;
import net.minecraft.client.renderer.entity.RenderIronGolem;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderLeashKnot;
import net.minecraft.client.renderer.entity.RenderLightningBolt;
import net.minecraft.client.renderer.entity.RenderMagmaCube;
import net.minecraft.client.renderer.entity.RenderMinecart;
import net.minecraft.client.renderer.entity.RenderMinecartMobSpawner;
import net.minecraft.client.renderer.entity.RenderMooshroom;
import net.minecraft.client.renderer.entity.RenderOcelot;
import net.minecraft.client.renderer.entity.RenderPainting;
import net.minecraft.client.renderer.entity.RenderPig;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.RenderSheep;
import net.minecraft.client.renderer.entity.RenderSilverfish;
import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.client.renderer.entity.RenderSlime;
import net.minecraft.client.renderer.entity.RenderSnowMan;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.client.renderer.entity.RenderSquid;
import net.minecraft.client.renderer.entity.RenderTNTPrimed;
import net.minecraft.client.renderer.entity.RenderTntMinecart;
import net.minecraft.client.renderer.entity.RenderVillager;
import net.minecraft.client.renderer.entity.RenderWitch;
import net.minecraft.client.renderer.entity.RenderWither;
import net.minecraft.client.renderer.entity.RenderWolf;
import net.minecraft.client.renderer.entity.RenderXPOrb;
import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.tileentity.RenderEnderCrystal;
import net.minecraft.client.renderer.tileentity.RenderItemFrame;
import net.minecraft.client.renderer.tileentity.RenderWitherSkull;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityMinecartMobSpawner;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityMinecartTNT;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ReportedException;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class RenderManager {

   private Map field_78729_o = new HashMap();
   public static RenderManager field_78727_a = new RenderManager();
   private FontRenderer field_78736_p;
   public static double field_78725_b;
   public static double field_78726_c;
   public static double field_78723_d;
   public TextureManager field_78724_e;
   public ItemRenderer field_78721_f;
   public World field_78722_g;
   public EntityLivingBase field_78734_h;
   public Entity field_147941_i;
   public float field_78735_i;
   public float field_78732_j;
   public GameSettings field_78733_k;
   public double field_78730_l;
   public double field_78731_m;
   public double field_78728_n;
   public static boolean field_85095_o;
   private static final String __OBFID = "CL_00000991";


   private RenderManager() {
      this.field_78729_o.put(EntityCaveSpider.class, new RenderCaveSpider());
      this.field_78729_o.put(EntitySpider.class, new RenderSpider());
      this.field_78729_o.put(EntityPig.class, new RenderPig(new ModelPig(), new ModelPig(0.5F), 0.7F));
      this.field_78729_o.put(EntitySheep.class, new RenderSheep(new ModelSheep2(), new ModelSheep1(), 0.7F));
      this.field_78729_o.put(EntityCow.class, new RenderCow(new ModelCow(), 0.7F));
      this.field_78729_o.put(EntityMooshroom.class, new RenderMooshroom(new ModelCow(), 0.7F));
      this.field_78729_o.put(EntityWolf.class, new RenderWolf(new ModelWolf(), new ModelWolf(), 0.5F));
      this.field_78729_o.put(EntityChicken.class, new RenderChicken(new ModelChicken(), 0.3F));
      this.field_78729_o.put(EntityOcelot.class, new RenderOcelot(new ModelOcelot(), 0.4F));
      this.field_78729_o.put(EntitySilverfish.class, new RenderSilverfish());
      this.field_78729_o.put(EntityCreeper.class, new RenderCreeper());
      this.field_78729_o.put(EntityEnderman.class, new RenderEnderman());
      this.field_78729_o.put(EntitySnowman.class, new RenderSnowMan());
      this.field_78729_o.put(EntitySkeleton.class, new RenderSkeleton());
      this.field_78729_o.put(EntityWitch.class, new RenderWitch());
      this.field_78729_o.put(EntityBlaze.class, new RenderBlaze());
      this.field_78729_o.put(EntityZombie.class, new RenderZombie());
      this.field_78729_o.put(EntitySlime.class, new RenderSlime(new ModelSlime(16), new ModelSlime(0), 0.25F));
      this.field_78729_o.put(EntityMagmaCube.class, new RenderMagmaCube());
      this.field_78729_o.put(EntityPlayer.class, new RenderPlayer());
      this.field_78729_o.put(EntityGiantZombie.class, new RenderGiantZombie(new ModelZombie(), 0.5F, 6.0F));
      this.field_78729_o.put(EntityGhast.class, new RenderGhast());
      this.field_78729_o.put(EntitySquid.class, new RenderSquid(new ModelSquid(), 0.7F));
      this.field_78729_o.put(EntityVillager.class, new RenderVillager());
      this.field_78729_o.put(EntityIronGolem.class, new RenderIronGolem());
      this.field_78729_o.put(EntityBat.class, new RenderBat());
      this.field_78729_o.put(EntityDragon.class, new RenderDragon());
      this.field_78729_o.put(EntityEnderCrystal.class, new RenderEnderCrystal());
      this.field_78729_o.put(EntityWither.class, new RenderWither());
      this.field_78729_o.put(Entity.class, new RenderEntity());
      this.field_78729_o.put(EntityPainting.class, new RenderPainting());
      this.field_78729_o.put(EntityItemFrame.class, new RenderItemFrame());
      this.field_78729_o.put(EntityLeashKnot.class, new RenderLeashKnot());
      this.field_78729_o.put(EntityArrow.class, new RenderArrow());
      this.field_78729_o.put(EntitySnowball.class, new RenderSnowball(Items.field_151126_ay));
      this.field_78729_o.put(EntityEnderPearl.class, new RenderSnowball(Items.field_151079_bi));
      this.field_78729_o.put(EntityEnderEye.class, new RenderSnowball(Items.field_151061_bv));
      this.field_78729_o.put(EntityEgg.class, new RenderSnowball(Items.field_151110_aK));
      this.field_78729_o.put(EntityPotion.class, new RenderSnowball(Items.field_151068_bn, 16384));
      this.field_78729_o.put(EntityExpBottle.class, new RenderSnowball(Items.field_151062_by));
      this.field_78729_o.put(EntityFireworkRocket.class, new RenderSnowball(Items.field_151152_bP));
      this.field_78729_o.put(EntityLargeFireball.class, new RenderFireball(2.0F));
      this.field_78729_o.put(EntitySmallFireball.class, new RenderFireball(0.5F));
      this.field_78729_o.put(EntityWitherSkull.class, new RenderWitherSkull());
      this.field_78729_o.put(EntityItem.class, new RenderItem());
      this.field_78729_o.put(EntityXPOrb.class, new RenderXPOrb());
      this.field_78729_o.put(EntityTNTPrimed.class, new RenderTNTPrimed());
      this.field_78729_o.put(EntityFallingBlock.class, new RenderFallingBlock());
      this.field_78729_o.put(EntityMinecartTNT.class, new RenderTntMinecart());
      this.field_78729_o.put(EntityMinecartMobSpawner.class, new RenderMinecartMobSpawner());
      this.field_78729_o.put(EntityMinecart.class, new RenderMinecart());
      this.field_78729_o.put(EntityBoat.class, new RenderBoat());
      this.field_78729_o.put(EntityFishHook.class, new RenderFish());
      this.field_78729_o.put(EntityHorse.class, new RenderHorse(new ModelHorse(), 0.75F));
      this.field_78729_o.put(EntityLightningBolt.class, new RenderLightningBolt());
      Iterator var1 = this.field_78729_o.values().iterator();

      while(var1.hasNext()) {
         Render var2 = (Render)var1.next();
         var2.func_76976_a(this);
      }

   }

   public Render func_78715_a(Class p_78715_1_) {
      Render var2 = (Render)this.field_78729_o.get(p_78715_1_);
      if(var2 == null && p_78715_1_ != Entity.class) {
         var2 = this.func_78715_a(p_78715_1_.getSuperclass());
         this.field_78729_o.put(p_78715_1_, var2);
      }

      return var2;
   }

   public Render func_78713_a(Entity p_78713_1_) {
      return this.func_78715_a(p_78713_1_.getClass());
   }

   public void func_147938_a(World p_147938_1_, TextureManager p_147938_2_, FontRenderer p_147938_3_, EntityLivingBase p_147938_4_, Entity p_147938_5_, GameSettings p_147938_6_, float p_147938_7_) {
      this.field_78722_g = p_147938_1_;
      this.field_78724_e = p_147938_2_;
      this.field_78733_k = p_147938_6_;
      this.field_78734_h = p_147938_4_;
      this.field_147941_i = p_147938_5_;
      this.field_78736_p = p_147938_3_;
      if(p_147938_4_.func_70608_bn()) {
         Block var8 = p_147938_1_.func_147439_a(MathHelper.func_76128_c(p_147938_4_.field_70165_t), MathHelper.func_76128_c(p_147938_4_.field_70163_u), MathHelper.func_76128_c(p_147938_4_.field_70161_v));
         if(var8 == Blocks.field_150324_C) {
            int var9 = p_147938_1_.func_72805_g(MathHelper.func_76128_c(p_147938_4_.field_70165_t), MathHelper.func_76128_c(p_147938_4_.field_70163_u), MathHelper.func_76128_c(p_147938_4_.field_70161_v));
            int var10 = var9 & 3;
            this.field_78735_i = (float)(var10 * 90 + 180);
            this.field_78732_j = 0.0F;
         }
      } else {
         this.field_78735_i = p_147938_4_.field_70126_B + (p_147938_4_.field_70177_z - p_147938_4_.field_70126_B) * p_147938_7_;
         this.field_78732_j = p_147938_4_.field_70127_C + (p_147938_4_.field_70125_A - p_147938_4_.field_70127_C) * p_147938_7_;
      }

      if(p_147938_6_.field_74320_O == 2) {
         this.field_78735_i += 180.0F;
      }

      this.field_78730_l = p_147938_4_.field_70142_S + (p_147938_4_.field_70165_t - p_147938_4_.field_70142_S) * (double)p_147938_7_;
      this.field_78731_m = p_147938_4_.field_70137_T + (p_147938_4_.field_70163_u - p_147938_4_.field_70137_T) * (double)p_147938_7_;
      this.field_78728_n = p_147938_4_.field_70136_U + (p_147938_4_.field_70161_v - p_147938_4_.field_70136_U) * (double)p_147938_7_;
   }

   public boolean func_147937_a(Entity p_147937_1_, float p_147937_2_) {
      return this.func_147936_a(p_147937_1_, p_147937_2_, false);
   }

   public boolean func_147936_a(Entity p_147936_1_, float p_147936_2_, boolean p_147936_3_) {
      if(p_147936_1_.field_70173_aa == 0) {
         p_147936_1_.field_70142_S = p_147936_1_.field_70165_t;
         p_147936_1_.field_70137_T = p_147936_1_.field_70163_u;
         p_147936_1_.field_70136_U = p_147936_1_.field_70161_v;
      }

      double var4 = p_147936_1_.field_70142_S + (p_147936_1_.field_70165_t - p_147936_1_.field_70142_S) * (double)p_147936_2_;
      double var6 = p_147936_1_.field_70137_T + (p_147936_1_.field_70163_u - p_147936_1_.field_70137_T) * (double)p_147936_2_;
      double var8 = p_147936_1_.field_70136_U + (p_147936_1_.field_70161_v - p_147936_1_.field_70136_U) * (double)p_147936_2_;
      float var10 = p_147936_1_.field_70126_B + (p_147936_1_.field_70177_z - p_147936_1_.field_70126_B) * p_147936_2_;
      int var11 = p_147936_1_.func_70070_b(p_147936_2_);
      if(p_147936_1_.func_70027_ad()) {
         var11 = 15728880;
      }

      int var12 = var11 % 65536;
      int var13 = var11 / 65536;
      OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)var12 / 1.0F, (float)var13 / 1.0F);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      return this.func_147939_a(p_147936_1_, var4 - field_78725_b, var6 - field_78726_c, var8 - field_78723_d, var10, p_147936_2_, p_147936_3_);
   }

   public boolean func_147940_a(Entity p_147940_1_, double p_147940_2_, double p_147940_4_, double p_147940_6_, float p_147940_8_, float p_147940_9_) {
      return this.func_147939_a(p_147940_1_, p_147940_2_, p_147940_4_, p_147940_6_, p_147940_8_, p_147940_9_, false);
   }

   public boolean func_147939_a(Entity p_147939_1_, double p_147939_2_, double p_147939_4_, double p_147939_6_, float p_147939_8_, float p_147939_9_, boolean p_147939_10_) {
      Render var11 = null;

      try {
         var11 = this.func_78713_a(p_147939_1_);
         if(var11 != null && this.field_78724_e != null) {
            if(!var11.func_147905_a() || p_147939_10_) {
               try {
                  var11.func_76986_a(p_147939_1_, p_147939_2_, p_147939_4_, p_147939_6_, p_147939_8_, p_147939_9_);
               } catch (Throwable var18) {
                  throw new ReportedException(CrashReport.func_85055_a(var18, "Rendering entity in world"));
               }

               try {
                  var11.func_76979_b(p_147939_1_, p_147939_2_, p_147939_4_, p_147939_6_, p_147939_8_, p_147939_9_);
               } catch (Throwable var17) {
                  throw new ReportedException(CrashReport.func_85055_a(var17, "Post-rendering entity in world"));
               }

               if(field_85095_o && !p_147939_1_.func_82150_aj() && !p_147939_10_) {
                  try {
                     this.func_85094_b(p_147939_1_, p_147939_2_, p_147939_4_, p_147939_6_, p_147939_8_, p_147939_9_);
                  } catch (Throwable var16) {
                     throw new ReportedException(CrashReport.func_85055_a(var16, "Rendering entity hitbox in world"));
                  }
               }
            }
         } else if(this.field_78724_e != null) {
            return false;
         }

         return true;
      } catch (Throwable var19) {
         CrashReport var13 = CrashReport.func_85055_a(var19, "Rendering entity in world");
         CrashReportCategory var14 = var13.func_85058_a("Entity being rendered");
         p_147939_1_.func_85029_a(var14);
         CrashReportCategory var15 = var13.func_85058_a("Renderer details");
         var15.func_71507_a("Assigned renderer", var11);
         var15.func_71507_a("Location", CrashReportCategory.func_85074_a(p_147939_2_, p_147939_4_, p_147939_6_));
         var15.func_71507_a("Rotation", Float.valueOf(p_147939_8_));
         var15.func_71507_a("Delta", Float.valueOf(p_147939_9_));
         throw new ReportedException(var13);
      }
   }

   private void func_85094_b(Entity p_85094_1_, double p_85094_2_, double p_85094_4_, double p_85094_6_, float p_85094_8_, float p_85094_9_) {
      GL11.glDepthMask(false);
      GL11.glDisable(3553);
      GL11.glDisable(2896);
      GL11.glDisable(2884);
      GL11.glDisable(3042);
      float var10 = p_85094_1_.field_70130_N / 2.0F;
      AxisAlignedBB var11 = AxisAlignedBB.func_72330_a(p_85094_2_ - (double)var10, p_85094_4_, p_85094_6_ - (double)var10, p_85094_2_ + (double)var10, p_85094_4_ + (double)p_85094_1_.field_70131_O, p_85094_6_ + (double)var10);
      RenderGlobal.func_147590_a(var11, 16777215);
      GL11.glEnable(3553);
      GL11.glEnable(2896);
      GL11.glEnable(2884);
      GL11.glDisable(3042);
      GL11.glDepthMask(true);
   }

   public void func_78717_a(World p_78717_1_) {
      this.field_78722_g = p_78717_1_;
   }

   public double func_78714_a(double p_78714_1_, double p_78714_3_, double p_78714_5_) {
      double var7 = p_78714_1_ - this.field_78730_l;
      double var9 = p_78714_3_ - this.field_78731_m;
      double var11 = p_78714_5_ - this.field_78728_n;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   public FontRenderer func_78716_a() {
      return this.field_78736_p;
   }

   public void func_94178_a(IIconRegister p_94178_1_) {
      Iterator var2 = this.field_78729_o.values().iterator();

      while(var2.hasNext()) {
         Render var3 = (Render)var2.next();
         var3.func_94143_a(p_94178_1_);
      }

   }

}
