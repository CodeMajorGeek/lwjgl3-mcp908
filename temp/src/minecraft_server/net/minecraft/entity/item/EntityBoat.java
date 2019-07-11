package net.minecraft.entity.item;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityBoat extends Entity {

   private boolean field_70279_a;
   private double field_70276_b;
   private int field_70277_c;
   private double field_70274_d;
   private double field_70275_e;
   private double field_70272_f;
   private double field_70273_g;
   private double field_70281_h;
   private static final String __OBFID = "CL_00001667";


   public EntityBoat(World p_i1704_1_) {
      super(p_i1704_1_);
      this.field_70279_a = true;
      this.field_70276_b = 0.07D;
      this.field_70156_m = true;
      this.func_70105_a(1.5F, 0.6F);
      this.field_70129_M = this.field_70131_O / 2.0F;
   }

   protected boolean func_70041_e_() {
      return false;
   }

   protected void func_70088_a() {
      this.field_70180_af.func_75682_a(17, new Integer(0));
      this.field_70180_af.func_75682_a(18, new Integer(1));
      this.field_70180_af.func_75682_a(19, new Float(0.0F));
   }

   public AxisAlignedBB func_70114_g(Entity p_70114_1_) {
      return p_70114_1_.field_70121_D;
   }

   public AxisAlignedBB func_70046_E() {
      return this.field_70121_D;
   }

   public boolean func_70104_M() {
      return true;
   }

   public EntityBoat(World p_i1705_1_, double p_i1705_2_, double p_i1705_4_, double p_i1705_6_) {
      this(p_i1705_1_);
      this.func_70107_b(p_i1705_2_, p_i1705_4_ + (double)this.field_70129_M, p_i1705_6_);
      this.field_70159_w = 0.0D;
      this.field_70181_x = 0.0D;
      this.field_70179_y = 0.0D;
      this.field_70169_q = p_i1705_2_;
      this.field_70167_r = p_i1705_4_;
      this.field_70166_s = p_i1705_6_;
   }

   public double func_70042_X() {
      return (double)this.field_70131_O * 0.0D - 0.30000001192092896D;
   }

   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
      if(this.func_85032_ar()) {
         return false;
      } else if(!this.field_70170_p.field_72995_K && !this.field_70128_L) {
         this.func_70269_c(-this.func_70267_i());
         this.func_70265_b(10);
         this.func_70266_a(this.func_70271_g() + p_70097_2_ * 10.0F);
         this.func_70018_K();
         boolean var3 = p_70097_1_.func_76346_g() instanceof EntityPlayer && ((EntityPlayer)p_70097_1_.func_76346_g()).field_71075_bZ.field_75098_d;
         if(var3 || this.func_70271_g() > 40.0F) {
            if(this.field_70153_n != null) {
               this.field_70153_n.func_70078_a(this);
            }

            if(!var3) {
               this.func_145778_a(Items.field_151124_az, 1, 0.0F);
            }

            this.func_70106_y();
         }

         return true;
      } else {
         return true;
      }
   }

   public boolean func_70067_L() {
      return !this.field_70128_L;
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if(this.func_70268_h() > 0) {
         this.func_70265_b(this.func_70268_h() - 1);
      }

      if(this.func_70271_g() > 0.0F) {
         this.func_70266_a(this.func_70271_g() - 1.0F);
      }

      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      byte var1 = 5;
      double var2 = 0.0D;

      for(int var4 = 0; var4 < var1; ++var4) {
         double var5 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * (double)(var4 + 0) / (double)var1 - 0.125D;
         double var7 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * (double)(var4 + 1) / (double)var1 - 0.125D;
         AxisAlignedBB var9 = AxisAlignedBB.func_72330_a(this.field_70121_D.field_72340_a, var5, this.field_70121_D.field_72339_c, this.field_70121_D.field_72336_d, var7, this.field_70121_D.field_72334_f);
         if(this.field_70170_p.func_72830_b(var9, Material.field_151586_h)) {
            var2 += 1.0D / (double)var1;
         }
      }

      double var19 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
      double var6;
      double var8;
      int var10;
      if(var19 > 0.26249999999999996D) {
         var6 = Math.cos((double)this.field_70177_z * 3.141592653589793D / 180.0D);
         var8 = Math.sin((double)this.field_70177_z * 3.141592653589793D / 180.0D);

         for(var10 = 0; (double)var10 < 1.0D + var19 * 60.0D; ++var10) {
            double var11 = (double)(this.field_70146_Z.nextFloat() * 2.0F - 1.0F);
            double var13 = (double)(this.field_70146_Z.nextInt(2) * 2 - 1) * 0.7D;
            double var15;
            double var17;
            if(this.field_70146_Z.nextBoolean()) {
               var15 = this.field_70165_t - var6 * var11 * 0.8D + var8 * var13;
               var17 = this.field_70161_v - var8 * var11 * 0.8D - var6 * var13;
               this.field_70170_p.func_72869_a("splash", var15, this.field_70163_u - 0.125D, var17, this.field_70159_w, this.field_70181_x, this.field_70179_y);
            } else {
               var15 = this.field_70165_t + var6 + var8 * var11 * 0.7D;
               var17 = this.field_70161_v + var8 - var6 * var11 * 0.7D;
               this.field_70170_p.func_72869_a("splash", var15, this.field_70163_u - 0.125D, var17, this.field_70159_w, this.field_70181_x, this.field_70179_y);
            }
         }
      }

      double var24;
      double var26;
      if(this.field_70170_p.field_72995_K && this.field_70279_a) {
         if(this.field_70277_c > 0) {
            var6 = this.field_70165_t + (this.field_70274_d - this.field_70165_t) / (double)this.field_70277_c;
            var8 = this.field_70163_u + (this.field_70275_e - this.field_70163_u) / (double)this.field_70277_c;
            var24 = this.field_70161_v + (this.field_70272_f - this.field_70161_v) / (double)this.field_70277_c;
            var26 = MathHelper.func_76138_g(this.field_70273_g - (double)this.field_70177_z);
            this.field_70177_z = (float)((double)this.field_70177_z + var26 / (double)this.field_70277_c);
            this.field_70125_A = (float)((double)this.field_70125_A + (this.field_70281_h - (double)this.field_70125_A) / (double)this.field_70277_c);
            --this.field_70277_c;
            this.func_70107_b(var6, var8, var24);
            this.func_70101_b(this.field_70177_z, this.field_70125_A);
         } else {
            var6 = this.field_70165_t + this.field_70159_w;
            var8 = this.field_70163_u + this.field_70181_x;
            var24 = this.field_70161_v + this.field_70179_y;
            this.func_70107_b(var6, var8, var24);
            if(this.field_70122_E) {
               this.field_70159_w *= 0.5D;
               this.field_70181_x *= 0.5D;
               this.field_70179_y *= 0.5D;
            }

            this.field_70159_w *= 0.9900000095367432D;
            this.field_70181_x *= 0.949999988079071D;
            this.field_70179_y *= 0.9900000095367432D;
         }

      } else {
         if(var2 < 1.0D) {
            var6 = var2 * 2.0D - 1.0D;
            this.field_70181_x += 0.03999999910593033D * var6;
         } else {
            if(this.field_70181_x < 0.0D) {
               this.field_70181_x /= 2.0D;
            }

            this.field_70181_x += 0.007000000216066837D;
         }

         if(this.field_70153_n != null && this.field_70153_n instanceof EntityLivingBase) {
            EntityLivingBase var20 = (EntityLivingBase)this.field_70153_n;
            float var21 = this.field_70153_n.field_70177_z + -var20.field_70702_br * 90.0F;
            this.field_70159_w += -Math.sin((double)(var21 * 3.1415927F / 180.0F)) * this.field_70276_b * (double)var20.field_70701_bs * 0.05000000074505806D;
            this.field_70179_y += Math.cos((double)(var21 * 3.1415927F / 180.0F)) * this.field_70276_b * (double)var20.field_70701_bs * 0.05000000074505806D;
         }

         var6 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
         if(var6 > 0.35D) {
            var8 = 0.35D / var6;
            this.field_70159_w *= var8;
            this.field_70179_y *= var8;
            var6 = 0.35D;
         }

         if(var6 > var19 && this.field_70276_b < 0.35D) {
            this.field_70276_b += (0.35D - this.field_70276_b) / 35.0D;
            if(this.field_70276_b > 0.35D) {
               this.field_70276_b = 0.35D;
            }
         } else {
            this.field_70276_b -= (this.field_70276_b - 0.07D) / 35.0D;
            if(this.field_70276_b < 0.07D) {
               this.field_70276_b = 0.07D;
            }
         }

         int var22;
         for(var22 = 0; var22 < 4; ++var22) {
            int var23 = MathHelper.func_76128_c(this.field_70165_t + ((double)(var22 % 2) - 0.5D) * 0.8D);
            var10 = MathHelper.func_76128_c(this.field_70161_v + ((double)(var22 / 2) - 0.5D) * 0.8D);

            for(int var25 = 0; var25 < 2; ++var25) {
               int var12 = MathHelper.func_76128_c(this.field_70163_u) + var25;
               Block var27 = this.field_70170_p.func_147439_a(var23, var12, var10);
               if(var27 == Blocks.field_150431_aC) {
                  this.field_70170_p.func_147468_f(var23, var12, var10);
                  this.field_70123_F = false;
               } else if(var27 == Blocks.field_150392_bi) {
                  this.field_70170_p.func_147480_a(var23, var12, var10, true);
                  this.field_70123_F = false;
               }
            }
         }

         if(this.field_70122_E) {
            this.field_70159_w *= 0.5D;
            this.field_70181_x *= 0.5D;
            this.field_70179_y *= 0.5D;
         }

         this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
         if(this.field_70123_F && var19 > 0.2D) {
            if(!this.field_70170_p.field_72995_K && !this.field_70128_L) {
               this.func_70106_y();

               for(var22 = 0; var22 < 3; ++var22) {
                  this.func_145778_a(Item.func_150898_a(Blocks.field_150344_f), 1, 0.0F);
               }

               for(var22 = 0; var22 < 2; ++var22) {
                  this.func_145778_a(Items.field_151055_y, 1, 0.0F);
               }
            }
         } else {
            this.field_70159_w *= 0.9900000095367432D;
            this.field_70181_x *= 0.949999988079071D;
            this.field_70179_y *= 0.9900000095367432D;
         }

         this.field_70125_A = 0.0F;
         var8 = (double)this.field_70177_z;
         var24 = this.field_70169_q - this.field_70165_t;
         var26 = this.field_70166_s - this.field_70161_v;
         if(var24 * var24 + var26 * var26 > 0.001D) {
            var8 = (double)((float)(Math.atan2(var26, var24) * 180.0D / 3.141592653589793D));
         }

         double var14 = MathHelper.func_76138_g(var8 - (double)this.field_70177_z);
         if(var14 > 20.0D) {
            var14 = 20.0D;
         }

         if(var14 < -20.0D) {
            var14 = -20.0D;
         }

         this.field_70177_z = (float)((double)this.field_70177_z + var14);
         this.func_70101_b(this.field_70177_z, this.field_70125_A);
         if(!this.field_70170_p.field_72995_K) {
            List var16 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
            if(var16 != null && !var16.isEmpty()) {
               for(int var28 = 0; var28 < var16.size(); ++var28) {
                  Entity var18 = (Entity)var16.get(var28);
                  if(var18 != this.field_70153_n && var18.func_70104_M() && var18 instanceof EntityBoat) {
                     var18.func_70108_f(this);
                  }
               }
            }

            if(this.field_70153_n != null && this.field_70153_n.field_70128_L) {
               this.field_70153_n = null;
            }

         }
      }
   }

   public void func_70043_V() {
      if(this.field_70153_n != null) {
         double var1 = Math.cos((double)this.field_70177_z * 3.141592653589793D / 180.0D) * 0.4D;
         double var3 = Math.sin((double)this.field_70177_z * 3.141592653589793D / 180.0D) * 0.4D;
         this.field_70153_n.func_70107_b(this.field_70165_t + var1, this.field_70163_u + this.func_70042_X() + this.field_70153_n.func_70033_W(), this.field_70161_v + var3);
      }
   }

   protected void func_70014_b(NBTTagCompound p_70014_1_) {}

   protected void func_70037_a(NBTTagCompound p_70037_1_) {}

   public boolean func_130002_c(EntityPlayer p_130002_1_) {
      if(this.field_70153_n != null && this.field_70153_n instanceof EntityPlayer && this.field_70153_n != p_130002_1_) {
         return true;
      } else {
         if(!this.field_70170_p.field_72995_K) {
            p_130002_1_.func_70078_a(this);
         }

         return true;
      }
   }

   protected void func_70064_a(double p_70064_1_, boolean p_70064_3_) {
      int var4 = MathHelper.func_76128_c(this.field_70165_t);
      int var5 = MathHelper.func_76128_c(this.field_70163_u);
      int var6 = MathHelper.func_76128_c(this.field_70161_v);
      if(p_70064_3_) {
         if(this.field_70143_R > 3.0F) {
            this.func_70069_a(this.field_70143_R);
            if(!this.field_70170_p.field_72995_K && !this.field_70128_L) {
               this.func_70106_y();

               int var7;
               for(var7 = 0; var7 < 3; ++var7) {
                  this.func_145778_a(Item.func_150898_a(Blocks.field_150344_f), 1, 0.0F);
               }

               for(var7 = 0; var7 < 2; ++var7) {
                  this.func_145778_a(Items.field_151055_y, 1, 0.0F);
               }
            }

            this.field_70143_R = 0.0F;
         }
      } else if(this.field_70170_p.func_147439_a(var4, var5 - 1, var6).func_149688_o() != Material.field_151586_h && p_70064_1_ < 0.0D) {
         this.field_70143_R = (float)((double)this.field_70143_R - p_70064_1_);
      }

   }

   public void func_70266_a(float p_70266_1_) {
      this.field_70180_af.func_75692_b(19, Float.valueOf(p_70266_1_));
   }

   public float func_70271_g() {
      return this.field_70180_af.func_111145_d(19);
   }

   public void func_70265_b(int p_70265_1_) {
      this.field_70180_af.func_75692_b(17, Integer.valueOf(p_70265_1_));
   }

   public int func_70268_h() {
      return this.field_70180_af.func_75679_c(17);
   }

   public void func_70269_c(int p_70269_1_) {
      this.field_70180_af.func_75692_b(18, Integer.valueOf(p_70269_1_));
   }

   public int func_70267_i() {
      return this.field_70180_af.func_75679_c(18);
   }
}
