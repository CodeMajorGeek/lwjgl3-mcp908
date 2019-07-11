package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.EnumDifficulty;

public class CommandDifficulty extends CommandBase {

   private static final String __OBFID = "CL_00000422";


   public String func_71517_b() {
      return "difficulty";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.difficulty.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      if(p_71515_2_.length > 0) {
         EnumDifficulty var3 = this.func_147201_h(p_71515_1_, p_71515_2_[0]);
         MinecraftServer.func_71276_C().func_147139_a(var3);
         func_152373_a(p_71515_1_, this, "commands.difficulty.success", new Object[]{new ChatComponentTranslation(var3.func_151526_b(), new Object[0])});
      } else {
         throw new WrongUsageException("commands.difficulty.usage", new Object[0]);
      }
   }

   protected EnumDifficulty func_147201_h(ICommandSender p_147201_1_, String p_147201_2_) {
      return !p_147201_2_.equalsIgnoreCase("peaceful") && !p_147201_2_.equalsIgnoreCase("p")?(!p_147201_2_.equalsIgnoreCase("easy") && !p_147201_2_.equalsIgnoreCase("e")?(!p_147201_2_.equalsIgnoreCase("normal") && !p_147201_2_.equalsIgnoreCase("n")?(!p_147201_2_.equalsIgnoreCase("hard") && !p_147201_2_.equalsIgnoreCase("h")?EnumDifficulty.func_151523_a(func_71532_a(p_147201_1_, p_147201_2_, 0, 3)):EnumDifficulty.HARD):EnumDifficulty.NORMAL):EnumDifficulty.EASY):EnumDifficulty.PEACEFUL;
   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      return p_71516_2_.length == 1?func_71530_a(p_71516_2_, new String[]{"peaceful", "easy", "normal", "hard"}):null;
   }
}
