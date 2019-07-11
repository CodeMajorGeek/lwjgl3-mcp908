package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.WorldSettings;

public class CommandGameMode extends CommandBase {

   private static final String __OBFID = "CL_00000448";


   public String func_71517_b() {
      return "gamemode";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.gamemode.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      if(p_71515_2_.length > 0) {
         WorldSettings.GameType var3 = this.func_71539_b(p_71515_1_, p_71515_2_[0]);
         EntityPlayerMP var4 = p_71515_2_.length >= 2?func_82359_c(p_71515_1_, p_71515_2_[1]):func_71521_c(p_71515_1_);
         var4.func_71033_a(var3);
         var4.field_70143_R = 0.0F;
         ChatComponentTranslation var5 = new ChatComponentTranslation("gameMode." + var3.func_77149_b(), new Object[0]);
         if(var4 != p_71515_1_) {
            func_152374_a(p_71515_1_, this, 1, "commands.gamemode.success.other", new Object[]{var4.func_70005_c_(), var5});
         } else {
            func_152374_a(p_71515_1_, this, 1, "commands.gamemode.success.self", new Object[]{var5});
         }

      } else {
         throw new WrongUsageException("commands.gamemode.usage", new Object[0]);
      }
   }

   protected WorldSettings.GameType func_71539_b(ICommandSender p_71539_1_, String p_71539_2_) {
      return !p_71539_2_.equalsIgnoreCase(WorldSettings.GameType.SURVIVAL.func_77149_b()) && !p_71539_2_.equalsIgnoreCase("s")?(!p_71539_2_.equalsIgnoreCase(WorldSettings.GameType.CREATIVE.func_77149_b()) && !p_71539_2_.equalsIgnoreCase("c")?(!p_71539_2_.equalsIgnoreCase(WorldSettings.GameType.ADVENTURE.func_77149_b()) && !p_71539_2_.equalsIgnoreCase("a")?WorldSettings.func_77161_a(func_71532_a(p_71539_1_, p_71539_2_, 0, WorldSettings.GameType.values().length - 2)):WorldSettings.GameType.ADVENTURE):WorldSettings.GameType.CREATIVE):WorldSettings.GameType.SURVIVAL;
   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      return p_71516_2_.length == 1?func_71530_a(p_71516_2_, new String[]{"survival", "creative", "adventure"}):(p_71516_2_.length == 2?func_71530_a(p_71516_2_, this.func_71538_c()):null);
   }

   protected String[] func_71538_c() {
      return MinecraftServer.func_71276_C().func_71213_z();
   }

   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
      return p_82358_2_ == 1;
   }
}
