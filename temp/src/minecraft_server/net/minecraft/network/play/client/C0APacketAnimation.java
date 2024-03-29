package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;

public class C0APacketAnimation extends Packet {

   private int field_149424_a;
   private int field_149423_b;
   private static final String __OBFID = "CL_00001345";


   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_149424_a = p_148837_1_.readInt();
      this.field_149423_b = p_148837_1_.readByte();
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.writeInt(this.field_149424_a);
      p_148840_1_.writeByte(this.field_149423_b);
   }

   public void func_148833_a(INetHandlerPlayServer p_148833_1_) {
      p_148833_1_.func_147350_a(this);
   }

   public String func_148835_b() {
      return String.format("id=%d, type=%d", new Object[]{Integer.valueOf(this.field_149424_a), Integer.valueOf(this.field_149423_b)});
   }

   public int func_149421_d() {
      return this.field_149423_b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_148833_a((INetHandlerPlayServer)p_148833_1_);
   }
}
