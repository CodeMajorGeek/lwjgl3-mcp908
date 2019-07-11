package net.minecraft.network;

import com.google.common.collect.BiMap;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.PacketBuffer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Packet {

   private static final Logger field_148841_a = LogManager.getLogger();
   private static final String __OBFID = "CL_00001272";


   public static Packet func_148839_a(BiMap p_148839_0_, int p_148839_1_) {
      try {
         Class var2 = (Class)p_148839_0_.get(Integer.valueOf(p_148839_1_));
         return var2 == null?null:(Packet)var2.newInstance();
      } catch (Exception var3) {
         field_148841_a.error("Couldn\'t create packet " + p_148839_1_, var3);
         return null;
      }
   }

   public static void func_148838_a(ByteBuf p_148838_0_, byte[] p_148838_1_) {
      p_148838_0_.writeShort(p_148838_1_.length);
      p_148838_0_.writeBytes(p_148838_1_);
   }

   public static byte[] func_148834_a(ByteBuf p_148834_0_) throws IOException {
      short var1 = p_148834_0_.readShort();
      if(var1 < 0) {
         throw new IOException("Key was smaller than nothing!  Weird key!");
      } else {
         byte[] var2 = new byte[var1];
         p_148834_0_.readBytes(var2);
         return var2;
      }
   }

   public abstract void func_148837_a(PacketBuffer var1) throws IOException;

   public abstract void func_148840_b(PacketBuffer var1) throws IOException;

   public abstract void func_148833_a(INetHandler var1);

   public boolean func_148836_a() {
      return false;
   }

   public String toString() {
      return this.getClass().getSimpleName();
   }

   public String func_148835_b() {
      return "";
   }

}
