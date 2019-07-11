package net.minecraft.command.server;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.util.ChunkCoordinates;

public class CommandSetDefaultSpawnpoint extends CommandBase {

   private static final String __OBFID = "CL_00000973";


   public String func_71517_b() {
      return "setworldspawn";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.setworldspawn.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      if(p_71515_2_.length == 3) {
         if(p_71515_1_.func_130014_f_() == null) {
            throw new WrongUsageException("commands.setworldspawn.usage", new Object[0]);
         }

         byte var3 = 0;
         int var7 = var3 + 1;
         int var4 = func_71532_a(p_71515_1_, p_71515_2_[var3], -30000000, 30000000);
         int var5 = func_71532_a(p_71515_1_, p_71515_2_[var7++], 0, 256);
         int var6 = func_71532_a(p_71515_1_, p_71515_2_[var7++], -30000000, 30000000);
         p_71515_1_.func_130014_f_().func_72950_A(var4, var5, var6);
         func_152373_a(p_71515_1_, this, "commands.setworldspawn.success", new Object[]{Integer.valueOf(var4), Integer.valueOf(var5), Integer.valueOf(var6)});
      } else {
         if(p_71515_2_.length != 0) {
            throw new WrongUsageException("commands.setworldspawn.usage", new Object[0]);
         }

         ChunkCoordinates var8 = func_71521_c(p_71515_1_).func_82114_b();
         p_71515_1_.func_130014_f_().func_72950_A(var8.field_71574_a, var8.field_71572_b, var8.field_71573_c);
         func_152373_a(p_71515_1_, this, "commands.setworldspawn.success", new Object[]{Integer.valueOf(var8.field_71574_a), Integer.valueOf(var8.field_71572_b), Integer.valueOf(var8.field_71573_c)});
      }

   }
}
