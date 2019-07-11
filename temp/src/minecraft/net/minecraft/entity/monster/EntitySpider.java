package net.minecraft.entity.monster;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntitySpider extends EntityMob {

   private static final String __OBFID = "CL_00001699";


   public EntitySpider(World p_i1743_1_) {
      super(p_i1743_1_);
      this.func_70105_a(1.4F, 0.9F);
   }

   protected void func_70088_a() {
      super.func_70088_a();
      this.field_70180_af.func_75682_a(16, new Byte((byte)0));
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if(!this.field_70170_p.field_72995_K) {
         this.func_70839_e(this.field_70123_F);
      }

   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(16.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.800000011920929D);
   }

   protected Entity func_70782_k() {
      float var1 = this.func_70013_c(1.0F);
      if(var1 < 0.5F) {
         double var2 = 16.0D;
         return this.field_70170_p.func_72856_b(this, var2);
      } else {
         return null;
      }
   }

   protected String func_70639_aQ() {
      return "mob.spider.say";
   }

   protected String func_70621_aR() {
      return "mob.spider.say";
   }

   protected String func_70673_aS() {
      return "mob.spider.death";
   }

   protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
      this.func_85030_a("mob.spider.step", 0.15F, 1.0F);
   }

   protected void func_70785_a(Entity p_70785_1_, float p_70785_2_) {
      float var3 = this.func_70013_c(1.0F);
      if(var3 > 0.5F && this.field_70146_Z.nextInt(100) == 0) {
         this.field_70789_a = null;
      } else {
         if(p_70785_2_ > 2.0F && p_70785_2_ < 6.0F && this.field_70146_Z.nextInt(10) == 0) {
            if(this.field_70122_E) {
               double var4 = p_70785_1_.field_70165_t - this.field_70165_t;
               double var6 = p_70785_1_.field_70161_v - this.field_70161_v;
               float var8 = MathHelper.func_76133_a(var4 * var4 + var6 * var6);
               this.field_70159_w = var4 / (double)var8 * 0.5D * 0.800000011920929D + this.field_70159_w * 0.20000000298023224D;
               this.field_70179_y = var6 / (double)var8 * 0.5D * 0.800000011920929D + this.field_70179_y * 0.20000000298023224D;
               this.field_70181_x = 0.4000000059604645D;
            }
         } else {
            super.func_70785_a(p_70785_1_, p_70785_2_);
         }

      }
   }

   protected Item func_146068_u() {
      return Items.field_151007_F;
   }

   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
      super.func_70628_a(p_70628_1_, p_70628_2_);
      if(p_70628_1_ && (this.field_70146_Z.nextInt(3) == 0 || this.field_70146_Z.nextInt(1 + p_70628_2_) > 0)) {
         this.func_145779_a(Items.field_151070_bp, 1);
      }

   }

   public boolean func_70617_f_() {
      return this.func_70841_p();
   }

   public void func_70110_aj() {}

   public EnumCreatureAttribute func_70668_bt() {
      return EnumCreatureAttribute.ARTHROPOD;
   }

   public boolean func_70687_e(PotionEffect p_70687_1_) {
      return p_70687_1_.func_76456_a() == Potion.field_76436_u.field_76415_H?false:super.func_70687_e(p_70687_1_);
   }

   public boolean func_70841_p() {
      return (this.field_70180_af.func_75683_a(16) & 1) != 0;
   }

   public void func_70839_e(boolean p_70839_1_) {
      byte var2 = this.field_70180_af.func_75683_a(16);
      if(p_70839_1_) {
         var2 = (byte)(var2 | 1);
      } else {
         var2 &= -2;
      }

      this.field_70180_af.func_75692_b(16, Byte.valueOf(var2));
   }

   public IEntityLivingData func_110161_a(IEntityLivingData p_110161_1_) {
      Object p_110161_1_1 = super.func_110161_a(p_110161_1_);
      if(this.field_70170_p.field_73012_v.nextInt(100) == 0) {
         EntitySkeleton var2 = new EntitySkeleton(this.field_70170_p);
         var2.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
         var2.func_110161_a((IEntityLivingData)null);
         this.field_70170_p.func_72838_d(var2);
         var2.func_70078_a(this);
      }

      if(p_110161_1_1 == null) {
         p_110161_1_1 = new EntitySpider.GroupData();
         if(this.field_70170_p.field_73013_u == EnumDifficulty.HARD && this.field_70170_p.field_73012_v.nextFloat() < 0.1F * this.field_70170_p.func_147462_b(this.field_70165_t, this.field_70163_u, this.field_70161_v)) {
            ((EntitySpider.GroupData)p_110161_1_1).func_111104_a(this.field_70170_p.field_73012_v);
         }
      }

      if(p_110161_1_1 instanceof EntitySpider.GroupData) {
         int var4 = ((EntitySpider.GroupData)p_110161_1_1).field_111105_a;
         if(var4 > 0 && Potion.field_76425_a[var4] != null) {
            this.func_70690_d(new PotionEffect(var4, Integer.MAX_VALUE));
         }
      }

      return (IEntityLivingData)p_110161_1_1;
   }

   public static class GroupData implements IEntityLivingData {

      public int field_111105_a;
      private static final String __OBFID = "CL_00001700";


      public void func_111104_a(Random p_111104_1_) {
         int var2 = p_111104_1_.nextInt(5);
         if(var2 <= 1) {
            this.field_111105_a = Potion.field_76424_c.field_76415_H;
         } else if(var2 <= 2) {
            this.field_111105_a = Potion.field_76420_g.field_76415_H;
         } else if(var2 <= 3) {
            this.field_111105_a = Potion.field_76428_l.field_76415_H;
         } else if(var2 <= 4) {
            this.field_111105_a = Potion.field_76441_p.field_76415_H;
         }

      }
   }
}
