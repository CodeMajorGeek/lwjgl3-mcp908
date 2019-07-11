package net.minecraft.command.server;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;

public class CommandAchievement extends CommandBase {

   private static final String __OBFID = "CL_00000113";


   public String func_71517_b() {
      return "achievement";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.achievement.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      if(p_71515_2_.length >= 2) {
         StatBase var3 = StatList.func_151177_a(p_71515_2_[1]);
         if(var3 == null && !p_71515_2_[1].equals("*")) {
            throw new CommandException("commands.achievement.unknownAchievement", new Object[]{p_71515_2_[1]});
         }

         EntityPlayerMP var4;
         if(p_71515_2_.length >= 3) {
            var4 = func_82359_c(p_71515_1_, p_71515_2_[2]);
         } else {
            var4 = func_71521_c(p_71515_1_);
         }

         if(p_71515_2_[0].equalsIgnoreCase("give")) {
            if(var3 == null) {
               Iterator var5 = AchievementList.field_76007_e.iterator();

               while(var5.hasNext()) {
                  Achievement var6 = (Achievement)var5.next();
                  var4.func_71029_a(var6);
               }

               func_152373_a(p_71515_1_, this, "commands.achievement.give.success.all", new Object[]{var4.func_70005_c_()});
            } else {
               if(var3 instanceof Achievement) {
                  Achievement var9 = (Achievement)var3;

                  ArrayList var10;
                  for(var10 = Lists.newArrayList(); var9.field_75992_c != null && !var4.func_147099_x().func_77443_a(var9.field_75992_c); var9 = var9.field_75992_c) {
                     var10.add(var9.field_75992_c);
                  }

                  Iterator var7 = Lists.reverse(var10).iterator();

                  while(var7.hasNext()) {
                     Achievement var8 = (Achievement)var7.next();
                     var4.func_71029_a(var8);
                  }
               }

               var4.func_71029_a(var3);
               func_152373_a(p_71515_1_, this, "commands.achievement.give.success.one", new Object[]{var4.func_70005_c_(), var3.func_150955_j()});
            }

            return;
         }
      }

      throw new WrongUsageException("commands.achievement.usage", new Object[0]);
   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      if(p_71516_2_.length == 1) {
         return func_71530_a(p_71516_2_, new String[]{"give"});
      } else if(p_71516_2_.length != 2) {
         return p_71516_2_.length == 3?func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z()):null;
      } else {
         ArrayList var3 = Lists.newArrayList();
         Iterator var4 = StatList.field_75940_b.iterator();

         while(var4.hasNext()) {
            StatBase var5 = (StatBase)var4.next();
            var3.add(var5.field_75975_e);
         }

         return func_71531_a(p_71516_2_, var3);
      }
   }

   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
      return p_82358_2_ == 2;
   }
}
