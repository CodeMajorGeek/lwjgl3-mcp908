package net.minecraft.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIDoorInteract;
import net.minecraft.world.EnumDifficulty;

public class EntityAIBreakDoor extends EntityAIDoorInteract {

   private int field_75359_i;
   private int field_75358_j = -1;
   private static final String __OBFID = "CL_00001577";


   public EntityAIBreakDoor(EntityLiving p_i1618_1_) {
      super(p_i1618_1_);
   }

   public boolean func_75250_a() {
      return !super.func_75250_a()?false:(!this.field_75356_a.field_70170_p.func_82736_K().func_82766_b("mobGriefing")?false:!this.field_151504_e.func_150015_f(this.field_75356_a.field_70170_p, this.field_75354_b, this.field_75355_c, this.field_75352_d));
   }

   public void func_75249_e() {
      super.func_75249_e();
      this.field_75359_i = 0;
   }

   public boolean func_75253_b() {
      double var1 = this.field_75356_a.func_70092_e((double)this.field_75354_b, (double)this.field_75355_c, (double)this.field_75352_d);
      return this.field_75359_i <= 240 && !this.field_151504_e.func_150015_f(this.field_75356_a.field_70170_p, this.field_75354_b, this.field_75355_c, this.field_75352_d) && var1 < 4.0D;
   }

   public void func_75251_c() {
      super.func_75251_c();
      this.field_75356_a.field_70170_p.func_147443_d(this.field_75356_a.func_145782_y(), this.field_75354_b, this.field_75355_c, this.field_75352_d, -1);
   }

   public void func_75246_d() {
      super.func_75246_d();
      if(this.field_75356_a.func_70681_au().nextInt(20) == 0) {
         this.field_75356_a.field_70170_p.func_72926_e(1010, this.field_75354_b, this.field_75355_c, this.field_75352_d, 0);
      }

      ++this.field_75359_i;
      int var1 = (int)((float)this.field_75359_i / 240.0F * 10.0F);
      if(var1 != this.field_75358_j) {
         this.field_75356_a.field_70170_p.func_147443_d(this.field_75356_a.func_145782_y(), this.field_75354_b, this.field_75355_c, this.field_75352_d, var1);
         this.field_75358_j = var1;
      }

      if(this.field_75359_i == 240 && this.field_75356_a.field_70170_p.field_73013_u == EnumDifficulty.HARD) {
         this.field_75356_a.field_70170_p.func_147468_f(this.field_75354_b, this.field_75355_c, this.field_75352_d);
         this.field_75356_a.field_70170_p.func_72926_e(1012, this.field_75354_b, this.field_75355_c, this.field_75352_d, 0);
         this.field_75356_a.field_70170_p.func_72926_e(2001, this.field_75354_b, this.field_75355_c, this.field_75352_d, Block.func_149682_b(this.field_151504_e));
      }

   }
}
