package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.entity.Entity;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.world.World;

public class C02PacketUseEntity extends Packet {

   private int field_149567_a;
   private C02PacketUseEntity.Action field_149566_b;
   private static final String __OBFID = "CL_00001357";


   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_149567_a = p_148837_1_.readInt();
      this.field_149566_b = C02PacketUseEntity.Action.field_151421_c[p_148837_1_.readByte() % C02PacketUseEntity.Action.field_151421_c.length];
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.writeInt(this.field_149567_a);
      p_148840_1_.writeByte(this.field_149566_b.field_151418_d);
   }

   public void func_148833_a(INetHandlerPlayServer p_148833_1_) {
      p_148833_1_.func_147340_a(this);
   }

   public Entity func_149564_a(World p_149564_1_) {
      return p_149564_1_.func_73045_a(this.field_149567_a);
   }

   public C02PacketUseEntity.Action func_149565_c() {
      return this.field_149566_b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_148833_a((INetHandlerPlayServer)p_148833_1_);
   }

   public static enum Action {

      INTERACT("INTERACT", 0, 0),
      ATTACK("ATTACK", 1, 1);
      private static final C02PacketUseEntity.Action[] field_151421_c = new C02PacketUseEntity.Action[values().length];
      private final int field_151418_d;
      // $FF: synthetic field
      private static final C02PacketUseEntity.Action[] $VALUES = new C02PacketUseEntity.Action[]{INTERACT, ATTACK};
      private static final String __OBFID = "CL_00001358";


      private Action(String p_i45250_1_, int p_i45250_2_, int p_i45250_3_) {
         this.field_151418_d = p_i45250_3_;
      }

      static {
         C02PacketUseEntity.Action[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            C02PacketUseEntity.Action var3 = var0[var2];
            field_151421_c[var3.field_151418_d] = var3;
         }

      }
   }
}
