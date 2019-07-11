package net.minecraft.entity.ai;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;

public class EntityAINearestAttackableTarget extends EntityAITarget {

   private final Class field_75307_b;
   private final int field_75308_c;
   private final EntityAINearestAttackableTarget.Sorter field_75306_g;
   private final IEntitySelector field_82643_g;
   private EntityLivingBase field_75309_a;
   private static final String __OBFID = "CL_00001620";


   public EntityAINearestAttackableTarget(EntityCreature p_i1663_1_, Class p_i1663_2_, int p_i1663_3_, boolean p_i1663_4_) {
      this(p_i1663_1_, p_i1663_2_, p_i1663_3_, p_i1663_4_, false);
   }

   public EntityAINearestAttackableTarget(EntityCreature p_i1664_1_, Class p_i1664_2_, int p_i1664_3_, boolean p_i1664_4_, boolean p_i1664_5_) {
      this(p_i1664_1_, p_i1664_2_, p_i1664_3_, p_i1664_4_, p_i1664_5_, (IEntitySelector)null);
   }

   public EntityAINearestAttackableTarget(EntityCreature p_i1665_1_, Class p_i1665_2_, int p_i1665_3_, boolean p_i1665_4_, boolean p_i1665_5_, final IEntitySelector p_i1665_6_) {
      super(p_i1665_1_, p_i1665_4_, p_i1665_5_);
      this.field_75307_b = p_i1665_2_;
      this.field_75308_c = p_i1665_3_;
      this.field_75306_g = new EntityAINearestAttackableTarget.Sorter(p_i1665_1_);
      this.func_75248_a(1);
      this.field_82643_g = new IEntitySelector() {

         private static final String __OBFID = "CL_00001621";

         public boolean func_82704_a(Entity p_82704_1_) {
            return !(p_82704_1_ instanceof EntityLivingBase)?false:(p_i1665_6_ != null && !p_i1665_6_.func_82704_a(p_82704_1_)?false:EntityAINearestAttackableTarget.this.func_75296_a((EntityLivingBase)p_82704_1_, false));
         }
      };
   }

   public boolean func_75250_a() {
      if(this.field_75308_c > 0 && this.field_75299_d.func_70681_au().nextInt(this.field_75308_c) != 0) {
         return false;
      } else {
         double var1 = this.func_111175_f();
         List var3 = this.field_75299_d.field_70170_p.func_82733_a(this.field_75307_b, this.field_75299_d.field_70121_D.func_72314_b(var1, 4.0D, var1), this.field_82643_g);
         Collections.sort(var3, this.field_75306_g);
         if(var3.isEmpty()) {
            return false;
         } else {
            this.field_75309_a = (EntityLivingBase)var3.get(0);
            return true;
         }
      }
   }

   public void func_75249_e() {
      this.field_75299_d.func_70624_b(this.field_75309_a);
      super.func_75249_e();
   }

   public static class Sorter implements Comparator {

      private final Entity field_75459_b;
      private static final String __OBFID = "CL_00001622";


      public Sorter(Entity p_i1662_1_) {
         this.field_75459_b = p_i1662_1_;
      }

      public int compare(Entity p_compare_1_, Entity p_compare_2_) {
         double var3 = this.field_75459_b.func_70068_e(p_compare_1_);
         double var5 = this.field_75459_b.func_70068_e(p_compare_2_);
         return var3 < var5?-1:(var3 > var5?1:0);
      }

      // $FF: synthetic method
      public int compare(Object p_compare_1_, Object p_compare_2_) {
         return this.compare((Entity)p_compare_1_, (Entity)p_compare_2_);
      }
   }
}
