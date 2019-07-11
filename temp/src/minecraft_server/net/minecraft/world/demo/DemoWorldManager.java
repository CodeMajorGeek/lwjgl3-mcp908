package net.minecraft.world.demo;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.server.management.ItemInWorldManager;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class DemoWorldManager extends ItemInWorldManager {

   private boolean field_73105_c;
   private boolean field_73103_d;
   private int field_73104_e;
   private int field_73102_f;
   private static final String __OBFID = "CL_00001429";


   public DemoWorldManager(World p_i1513_1_) {
      super(p_i1513_1_);
   }

   public void func_73075_a() {
      super.func_73075_a();
      ++this.field_73102_f;
      long var1 = this.field_73092_a.func_82737_E();
      long var3 = var1 / 24000L + 1L;
      if(!this.field_73105_c && this.field_73102_f > 20) {
         this.field_73105_c = true;
         this.field_73090_b.field_71135_a.func_147359_a(new S2BPacketChangeGameState(5, 0.0F));
      }

      this.field_73103_d = var1 > 120500L;
      if(this.field_73103_d) {
         ++this.field_73104_e;
      }

      if(var1 % 24000L == 500L) {
         if(var3 <= 6L) {
            this.field_73090_b.func_145747_a(new ChatComponentTranslation("demo.day." + var3, new Object[0]));
         }
      } else if(var3 == 1L) {
         if(var1 == 100L) {
            this.field_73090_b.field_71135_a.func_147359_a(new S2BPacketChangeGameState(5, 101.0F));
         } else if(var1 == 175L) {
            this.field_73090_b.field_71135_a.func_147359_a(new S2BPacketChangeGameState(5, 102.0F));
         } else if(var1 == 250L) {
            this.field_73090_b.field_71135_a.func_147359_a(new S2BPacketChangeGameState(5, 103.0F));
         }
      } else if(var3 == 5L && var1 % 24000L == 22000L) {
         this.field_73090_b.func_145747_a(new ChatComponentTranslation("demo.day.warning", new Object[0]));
      }

   }

   private void func_73101_e() {
      if(this.field_73104_e > 100) {
         this.field_73090_b.func_145747_a(new ChatComponentTranslation("demo.reminder", new Object[0]));
         this.field_73104_e = 0;
      }

   }

   public void func_73074_a(int p_73074_1_, int p_73074_2_, int p_73074_3_, int p_73074_4_) {
      if(this.field_73103_d) {
         this.func_73101_e();
      } else {
         super.func_73074_a(p_73074_1_, p_73074_2_, p_73074_3_, p_73074_4_);
      }
   }

   public void func_73082_a(int p_73082_1_, int p_73082_2_, int p_73082_3_) {
      if(!this.field_73103_d) {
         super.func_73082_a(p_73082_1_, p_73082_2_, p_73082_3_);
      }
   }

   public boolean func_73084_b(int p_73084_1_, int p_73084_2_, int p_73084_3_) {
      return this.field_73103_d?false:super.func_73084_b(p_73084_1_, p_73084_2_, p_73084_3_);
   }

   public boolean func_73085_a(EntityPlayer p_73085_1_, World p_73085_2_, ItemStack p_73085_3_) {
      if(this.field_73103_d) {
         this.func_73101_e();
         return false;
      } else {
         return super.func_73085_a(p_73085_1_, p_73085_2_, p_73085_3_);
      }
   }

   public boolean func_73078_a(EntityPlayer p_73078_1_, World p_73078_2_, ItemStack p_73078_3_, int p_73078_4_, int p_73078_5_, int p_73078_6_, int p_73078_7_, float p_73078_8_, float p_73078_9_, float p_73078_10_) {
      if(this.field_73103_d) {
         this.func_73101_e();
         return false;
      } else {
         return super.func_73078_a(p_73078_1_, p_73078_2_, p_73078_3_, p_73078_4_, p_73078_5_, p_73078_6_, p_73078_7_, p_73078_8_, p_73078_9_, p_73078_10_);
      }
   }
}
