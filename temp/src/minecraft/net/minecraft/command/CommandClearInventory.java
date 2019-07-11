package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;

public class CommandClearInventory extends CommandBase {

   private static final String __OBFID = "CL_00000218";


   public String func_71517_b() {
      return "clear";
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.clear.usage";
   }

   public int func_82362_a() {
      return 2;
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      EntityPlayerMP var3 = p_71515_2_.length == 0?func_71521_c(p_71515_1_):func_82359_c(p_71515_1_, p_71515_2_[0]);
      Item var4 = p_71515_2_.length >= 2?func_147179_f(p_71515_1_, p_71515_2_[1]):null;
      int var5 = p_71515_2_.length >= 3?func_71528_a(p_71515_1_, p_71515_2_[2], 0):-1;
      if(p_71515_2_.length >= 2 && var4 == null) {
         throw new CommandException("commands.clear.failure", new Object[]{var3.func_70005_c_()});
      } else {
         int var6 = var3.field_71071_by.func_146027_a(var4, var5);
         var3.field_71069_bz.func_75142_b();
         if(!var3.field_71075_bZ.field_75098_d) {
            var3.func_71113_k();
         }

         if(var6 == 0) {
            throw new CommandException("commands.clear.failure", new Object[]{var3.func_70005_c_()});
         } else {
            func_152373_a(p_71515_1_, this, "commands.clear.success", new Object[]{var3.func_70005_c_(), Integer.valueOf(var6)});
         }
      }
   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      return p_71516_2_.length == 1?func_71530_a(p_71516_2_, this.func_147209_d()):(p_71516_2_.length == 2?func_71531_a(p_71516_2_, Item.field_150901_e.func_148742_b()):null);
   }

   protected String[] func_147209_d() {
      return MinecraftServer.func_71276_C().func_71213_z();
   }

   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
      return p_82358_2_ == 0;
   }
}
