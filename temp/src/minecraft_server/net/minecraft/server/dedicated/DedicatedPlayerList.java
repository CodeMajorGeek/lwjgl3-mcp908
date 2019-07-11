package net.minecraft.server.dedicated;

import com.mojang.authlib.GameProfile;
import java.io.IOException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.management.ServerConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DedicatedPlayerList extends ServerConfigurationManager {

   private static final Logger field_164439_d = LogManager.getLogger();
   private static final String __OBFID = "CL_00001783";


   public DedicatedPlayerList(DedicatedServer p_i1503_1_) {
      super(p_i1503_1_);
      this.func_152611_a(p_i1503_1_.func_71327_a("view-distance", 10));
      this.field_72405_c = p_i1503_1_.func_71327_a("max-players", 20);
      this.func_72371_a(p_i1503_1_.func_71332_a("white-list", false));
      if(!p_i1503_1_.func_71264_H()) {
         this.func_152608_h().func_152686_a(true);
         this.func_72363_f().func_152686_a(true);
      }

      this.func_152620_y();
      this.func_152617_w();
      this.func_152619_x();
      this.func_152618_v();
      this.func_72417_t();
      this.func_72418_v();
      this.func_72419_u();
      if(!this.func_152599_k().func_152691_c().exists()) {
         this.func_72421_w();
      }

   }

   public void func_72371_a(boolean p_72371_1_) {
      super.func_72371_a(p_72371_1_);
      this.func_72365_p().func_71328_a("white-list", Boolean.valueOf(p_72371_1_));
      this.func_72365_p().func_71326_a();
   }

   public void func_152605_a(GameProfile p_152605_1_) {
      super.func_152605_a(p_152605_1_);
      this.func_72419_u();
   }

   public void func_152610_b(GameProfile p_152610_1_) {
      super.func_152610_b(p_152610_1_);
      this.func_72419_u();
   }

   public void func_152597_c(GameProfile p_152597_1_) {
      super.func_152597_c(p_152597_1_);
      this.func_72421_w();
   }

   public void func_152601_d(GameProfile p_152601_1_) {
      super.func_152601_d(p_152601_1_);
      this.func_72421_w();
   }

   public void func_72362_j() {
      this.func_72418_v();
   }

   private void func_152618_v() {
      try {
         this.func_72363_f().func_152678_f();
      } catch (IOException var2) {
         field_164439_d.warn("Failed to save ip banlist: ", var2);
      }

   }

   private void func_152617_w() {
      try {
         this.func_152608_h().func_152678_f();
      } catch (IOException var2) {
         field_164439_d.warn("Failed to save user banlist: ", var2);
      }

   }

   private void func_152619_x() {
      try {
         this.func_72363_f().func_152679_g();
      } catch (IOException var2) {
         field_164439_d.warn("Failed to load ip banlist: ", var2);
      }

   }

   private void func_152620_y() {
      try {
         this.func_152608_h().func_152679_g();
      } catch (IOException var2) {
         field_164439_d.warn("Failed to load user banlist: ", var2);
      }

   }

   private void func_72417_t() {
      try {
         this.func_152603_m().func_152679_g();
      } catch (Exception var2) {
         field_164439_d.warn("Failed to load operators list: ", var2);
      }

   }

   private void func_72419_u() {
      try {
         this.func_152603_m().func_152678_f();
      } catch (Exception var2) {
         field_164439_d.warn("Failed to save operators list: ", var2);
      }

   }

   private void func_72418_v() {
      try {
         this.func_152599_k().func_152679_g();
      } catch (Exception var2) {
         field_164439_d.warn("Failed to load white-list: ", var2);
      }

   }

   private void func_72421_w() {
      try {
         this.func_152599_k().func_152678_f();
      } catch (Exception var2) {
         field_164439_d.warn("Failed to save white-list: ", var2);
      }

   }

   public boolean func_152607_e(GameProfile p_152607_1_) {
      return !this.func_72383_n() || this.func_152596_g(p_152607_1_) || this.func_152599_k().func_152705_a(p_152607_1_);
   }

   public DedicatedServer func_72365_p() {
      return (DedicatedServer)super.func_72365_p();
   }

   // $FF: synthetic method
   public MinecraftServer func_72365_p() {
      return this.func_72365_p();
   }

}
