package net.minecraft.client.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.MovingSoundMinecartRiding;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.network.play.client.C0CPacketInput;
import net.minecraft.network.play.client.C0DPacketCloseWindow;
import net.minecraft.network.play.client.C13PacketPlayerAbilities;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Session;
import net.minecraft.world.World;

public class EntityClientPlayerMP extends EntityPlayerSP {

   public final NetHandlerPlayClient field_71174_a;
   private final StatFileWriter field_146108_bO;
   private double field_71179_j;
   private double field_71177_cg;
   private double field_71178_ch;
   private double field_71175_ci;
   private float field_71176_cj;
   private float field_71172_ck;
   private boolean field_71173_cl;
   private boolean field_71170_cm;
   private boolean field_71171_cn;
   private int field_71168_co;
   private boolean field_71169_cp;
   private String field_142022_ce;
   private static final String __OBFID = "CL_00000887";


   public EntityClientPlayerMP(Minecraft p_i45064_1_, World p_i45064_2_, Session p_i45064_3_, NetHandlerPlayClient p_i45064_4_, StatFileWriter p_i45064_5_) {
      super(p_i45064_1_, p_i45064_2_, p_i45064_3_, 0);
      this.field_71174_a = p_i45064_4_;
      this.field_146108_bO = p_i45064_5_;
   }

   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
      return false;
   }

   public void func_70691_i(float p_70691_1_) {}

   public void func_70078_a(Entity p_70078_1_) {
      super.func_70078_a(p_70078_1_);
      if(p_70078_1_ instanceof EntityMinecart) {
         this.field_71159_c.func_147118_V().func_147682_a(new MovingSoundMinecartRiding(this, (EntityMinecart)p_70078_1_));
      }

   }

   public void func_70071_h_() {
      if(this.field_70170_p.func_72899_e(MathHelper.func_76128_c(this.field_70165_t), 0, MathHelper.func_76128_c(this.field_70161_v))) {
         super.func_70071_h_();
         if(this.func_70115_ae()) {
            this.field_71174_a.func_147297_a(new C03PacketPlayer.C05PacketPlayerLook(this.field_70177_z, this.field_70125_A, this.field_70122_E));
            this.field_71174_a.func_147297_a(new C0CPacketInput(this.field_70702_br, this.field_70701_bs, this.field_71158_b.field_78901_c, this.field_71158_b.field_78899_d));
         } else {
            this.func_71166_b();
         }

      }
   }

   public void func_71166_b() {
      boolean var1 = this.func_70051_ag();
      if(var1 != this.field_71171_cn) {
         if(var1) {
            this.field_71174_a.func_147297_a(new C0BPacketEntityAction(this, 4));
         } else {
            this.field_71174_a.func_147297_a(new C0BPacketEntityAction(this, 5));
         }

         this.field_71171_cn = var1;
      }

      boolean var2 = this.func_70093_af();
      if(var2 != this.field_71170_cm) {
         if(var2) {
            this.field_71174_a.func_147297_a(new C0BPacketEntityAction(this, 1));
         } else {
            this.field_71174_a.func_147297_a(new C0BPacketEntityAction(this, 2));
         }

         this.field_71170_cm = var2;
      }

      double var3 = this.field_70165_t - this.field_71179_j;
      double var5 = this.field_70121_D.field_72338_b - this.field_71177_cg;
      double var7 = this.field_70161_v - this.field_71175_ci;
      double var9 = (double)(this.field_70177_z - this.field_71176_cj);
      double var11 = (double)(this.field_70125_A - this.field_71172_ck);
      boolean var13 = var3 * var3 + var5 * var5 + var7 * var7 > 9.0E-4D || this.field_71168_co >= 20;
      boolean var14 = var9 != 0.0D || var11 != 0.0D;
      if(this.field_70154_o != null) {
         this.field_71174_a.func_147297_a(new C03PacketPlayer.C06PacketPlayerPosLook(this.field_70159_w, -999.0D, -999.0D, this.field_70179_y, this.field_70177_z, this.field_70125_A, this.field_70122_E));
         var13 = false;
      } else if(var13 && var14) {
         this.field_71174_a.func_147297_a(new C03PacketPlayer.C06PacketPlayerPosLook(this.field_70165_t, this.field_70121_D.field_72338_b, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A, this.field_70122_E));
      } else if(var13) {
         this.field_71174_a.func_147297_a(new C03PacketPlayer.C04PacketPlayerPosition(this.field_70165_t, this.field_70121_D.field_72338_b, this.field_70163_u, this.field_70161_v, this.field_70122_E));
      } else if(var14) {
         this.field_71174_a.func_147297_a(new C03PacketPlayer.C05PacketPlayerLook(this.field_70177_z, this.field_70125_A, this.field_70122_E));
      } else {
         this.field_71174_a.func_147297_a(new C03PacketPlayer(this.field_70122_E));
      }

      ++this.field_71168_co;
      this.field_71173_cl = this.field_70122_E;
      if(var13) {
         this.field_71179_j = this.field_70165_t;
         this.field_71177_cg = this.field_70121_D.field_72338_b;
         this.field_71178_ch = this.field_70163_u;
         this.field_71175_ci = this.field_70161_v;
         this.field_71168_co = 0;
      }

      if(var14) {
         this.field_71176_cj = this.field_70177_z;
         this.field_71172_ck = this.field_70125_A;
      }

   }

   public EntityItem func_71040_bB(boolean p_71040_1_) {
      int var2 = p_71040_1_?3:4;
      this.field_71174_a.func_147297_a(new C07PacketPlayerDigging(var2, 0, 0, 0, 0));
      return null;
   }

   protected void func_71012_a(EntityItem p_71012_1_) {}

   public void func_71165_d(String p_71165_1_) {
      this.field_71174_a.func_147297_a(new C01PacketChatMessage(p_71165_1_));
   }

   public void func_71038_i() {
      super.func_71038_i();
      this.field_71174_a.func_147297_a(new C0APacketAnimation(this, 1));
   }

   public void func_71004_bE() {
      this.field_71174_a.func_147297_a(new C16PacketClientStatus(C16PacketClientStatus.EnumState.PERFORM_RESPAWN));
   }

   protected void func_70665_d(DamageSource p_70665_1_, float p_70665_2_) {
      if(!this.func_85032_ar()) {
         this.func_70606_j(this.func_110143_aJ() - p_70665_2_);
      }
   }

   public void func_71053_j() {
      this.field_71174_a.func_147297_a(new C0DPacketCloseWindow(this.field_71070_bA.field_75152_c));
      this.func_92015_f();
   }

   public void func_92015_f() {
      this.field_71071_by.func_70437_b((ItemStack)null);
      super.func_71053_j();
   }

   public void func_71150_b(float p_71150_1_) {
      if(this.field_71169_cp) {
         super.func_71150_b(p_71150_1_);
      } else {
         this.func_70606_j(p_71150_1_);
         this.field_71169_cp = true;
      }

   }

   public void func_71064_a(StatBase p_71064_1_, int p_71064_2_) {
      if(p_71064_1_ != null) {
         if(p_71064_1_.field_75972_f) {
            super.func_71064_a(p_71064_1_, p_71064_2_);
         }

      }
   }

   public void func_71016_p() {
      this.field_71174_a.func_147297_a(new C13PacketPlayerAbilities(this.field_71075_bZ));
   }

   protected void func_110318_g() {
      this.field_71174_a.func_147297_a(new C0BPacketEntityAction(this, 6, (int)(this.func_110319_bJ() * 100.0F)));
   }

   public void func_110322_i() {
      this.field_71174_a.func_147297_a(new C0BPacketEntityAction(this, 7));
   }

   public void func_142020_c(String p_142020_1_) {
      this.field_142022_ce = p_142020_1_;
   }

   public String func_142021_k() {
      return this.field_142022_ce;
   }

   public StatFileWriter func_146107_m() {
      return this.field_146108_bO;
   }
}
