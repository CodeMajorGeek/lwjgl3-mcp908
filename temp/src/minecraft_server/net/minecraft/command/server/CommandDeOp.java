package net.minecraft.command.server;

import com.mojang.authlib.GameProfile;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;

public class CommandDeOp extends CommandBase {

   private static final String __OBFID = "CL_00000244";


   public String func_71517_b() {
      return "deop";
   }

   public int func_82362_a() {
      return 3;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.deop.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      if(p_71515_2_.length == 1 && p_71515_2_[0].length() > 0) {
         MinecraftServer var3 = MinecraftServer.func_71276_C();
         GameProfile var4 = var3.func_71203_ab().func_152603_m().func_152700_a(p_71515_2_[0]);
         if(var4 == null) {
            throw new CommandException("commands.deop.failed", new Object[]{p_71515_2_[0]});
         } else {
            var3.func_71203_ab().func_152610_b(var4);
            func_152373_a(p_71515_1_, this, "commands.deop.success", new Object[]{p_71515_2_[0]});
         }
      } else {
         throw new WrongUsageException("commands.deop.usage", new Object[0]);
      }
   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      return p_71516_2_.length == 1?func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71203_ab().func_152606_n()):null;
   }
}
