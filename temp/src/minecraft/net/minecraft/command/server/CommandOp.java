package net.minecraft.command.server;

import com.mojang.authlib.GameProfile;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;

public class CommandOp extends CommandBase {

   private static final String __OBFID = "CL_00000694";


   public String func_71517_b() {
      return "op";
   }

   public int func_82362_a() {
      return 3;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.op.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      if(p_71515_2_.length == 1 && p_71515_2_[0].length() > 0) {
         MinecraftServer var3 = MinecraftServer.func_71276_C();
         GameProfile var4 = var3.func_152358_ax().func_152655_a(p_71515_2_[0]);
         if(var4 == null) {
            throw new CommandException("commands.op.failed", new Object[]{p_71515_2_[0]});
         } else {
            var3.func_71203_ab().func_152605_a(var4);
            func_152373_a(p_71515_1_, this, "commands.op.success", new Object[]{p_71515_2_[0]});
         }
      } else {
         throw new WrongUsageException("commands.op.usage", new Object[0]);
      }
   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      if(p_71516_2_.length == 1) {
         String var3 = p_71516_2_[p_71516_2_.length - 1];
         ArrayList var4 = new ArrayList();
         GameProfile[] var5 = MinecraftServer.func_71276_C().func_152357_F();
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            GameProfile var8 = var5[var7];
            if(!MinecraftServer.func_71276_C().func_71203_ab().func_152596_g(var8) && func_71523_a(var3, var8.getName())) {
               var4.add(var8.getName());
            }
         }

         return var4;
      } else {
         return null;
      }
   }
}
