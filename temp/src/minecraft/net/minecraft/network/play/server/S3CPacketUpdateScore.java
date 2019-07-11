package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.scoreboard.Score;

public class S3CPacketUpdateScore extends Packet {

   private String field_149329_a = "";
   private String field_149327_b = "";
   private int field_149328_c;
   private int field_149326_d;
   private static final String __OBFID = "CL_00001335";


   public S3CPacketUpdateScore() {}

   public S3CPacketUpdateScore(Score p_i45227_1_, int p_i45227_2_) {
      this.field_149329_a = p_i45227_1_.func_96653_e();
      this.field_149327_b = p_i45227_1_.func_96645_d().func_96679_b();
      this.field_149328_c = p_i45227_1_.func_96652_c();
      this.field_149326_d = p_i45227_2_;
   }

   public S3CPacketUpdateScore(String p_i45228_1_) {
      this.field_149329_a = p_i45228_1_;
      this.field_149327_b = "";
      this.field_149328_c = 0;
      this.field_149326_d = 1;
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_149329_a = p_148837_1_.func_150789_c(16);
      this.field_149326_d = p_148837_1_.readByte();
      if(this.field_149326_d != 1) {
         this.field_149327_b = p_148837_1_.func_150789_c(16);
         this.field_149328_c = p_148837_1_.readInt();
      }

   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_150785_a(this.field_149329_a);
      p_148840_1_.writeByte(this.field_149326_d);
      if(this.field_149326_d != 1) {
         p_148840_1_.func_150785_a(this.field_149327_b);
         p_148840_1_.writeInt(this.field_149328_c);
      }

   }

   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
      p_148833_1_.func_147250_a(this);
   }

   public String func_149324_c() {
      return this.field_149329_a;
   }

   public String func_149321_d() {
      return this.field_149327_b;
   }

   public int func_149323_e() {
      return this.field_149328_c;
   }

   public int func_149322_f() {
      return this.field_149326_d;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_148833_a((INetHandlerPlayClient)p_148833_1_);
   }
}
