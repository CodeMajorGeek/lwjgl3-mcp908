package net.minecraft.command.server;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;

public class CommandListPlayers extends CommandBase {

   private static final String __OBFID = "CL_00000615";


   public String func_71517_b() {
      return "list";
   }

   public int func_82362_a() {
      return 0;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.players.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      p_71515_1_.func_145747_a(new ChatComponentTranslation("commands.players.list", new Object[]{Integer.valueOf(MinecraftServer.func_71276_C().func_71233_x()), Integer.valueOf(MinecraftServer.func_71276_C().func_71275_y())}));
      p_71515_1_.func_145747_a(new ChatComponentText(MinecraftServer.func_71276_C().func_71203_ab().func_152609_b(p_71515_2_.length > 0 && "uuids".equalsIgnoreCase(p_71515_2_[0]))));
   }
}
