package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S33PacketUpdateSign extends Packet {

   private int field_149352_a;
   private int field_149350_b;
   private int field_149351_c;
   private String[] field_149349_d;
   private static final String __OBFID = "CL_00001338";


   public S33PacketUpdateSign() {}

   public S33PacketUpdateSign(int p_i45231_1_, int p_i45231_2_, int p_i45231_3_, String[] p_i45231_4_) {
      this.field_149352_a = p_i45231_1_;
      this.field_149350_b = p_i45231_2_;
      this.field_149351_c = p_i45231_3_;
      this.field_149349_d = new String[]{p_i45231_4_[0], p_i45231_4_[1], p_i45231_4_[2], p_i45231_4_[3]};
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_149352_a = p_148837_1_.readInt();
      this.field_149350_b = p_148837_1_.readShort();
      this.field_149351_c = p_148837_1_.readInt();
      this.field_149349_d = new String[4];

      for(int var2 = 0; var2 < 4; ++var2) {
         this.field_149349_d[var2] = p_148837_1_.func_150789_c(15);
      }

   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.writeInt(this.field_149352_a);
      p_148840_1_.writeShort(this.field_149350_b);
      p_148840_1_.writeInt(this.field_149351_c);

      for(int var2 = 0; var2 < 4; ++var2) {
         p_148840_1_.func_150785_a(this.field_149349_d[var2]);
      }

   }

   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
      p_148833_1_.func_147248_a(this);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_148833_a((INetHandlerPlayClient)p_148833_1_);
   }
}
