package net.minecraft.command.server;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class CommandSetBlock extends CommandBase {

   private static final String __OBFID = "CL_00000949";


   public String func_71517_b() {
      return "setblock";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.setblock.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      if(p_71515_2_.length >= 4) {
         int var3 = p_71515_1_.func_82114_b().field_71574_a;
         int var4 = p_71515_1_.func_82114_b().field_71572_b;
         int var5 = p_71515_1_.func_82114_b().field_71573_c;
         var3 = MathHelper.func_76128_c(func_110666_a(p_71515_1_, (double)var3, p_71515_2_[0]));
         var4 = MathHelper.func_76128_c(func_110666_a(p_71515_1_, (double)var4, p_71515_2_[1]));
         var5 = MathHelper.func_76128_c(func_110666_a(p_71515_1_, (double)var5, p_71515_2_[2]));
         Block var6 = CommandBase.func_147180_g(p_71515_1_, p_71515_2_[3]);
         int var7 = 0;
         if(p_71515_2_.length >= 5) {
            var7 = func_71532_a(p_71515_1_, p_71515_2_[4], 0, 15);
         }

         World var8 = p_71515_1_.func_130014_f_();
         if(!var8.func_72899_e(var3, var4, var5)) {
            throw new CommandException("commands.setblock.outOfWorld", new Object[0]);
         } else {
            NBTTagCompound var9 = new NBTTagCompound();
            boolean var10 = false;
            if(p_71515_2_.length >= 7 && var6.func_149716_u()) {
               String var11 = func_147178_a(p_71515_1_, p_71515_2_, 6).func_150260_c();

               try {
                  NBTBase var12 = JsonToNBT.func_150315_a(var11);
                  if(!(var12 instanceof NBTTagCompound)) {
                     throw new CommandException("commands.setblock.tagError", new Object[]{"Not a valid tag"});
                  }

                  var9 = (NBTTagCompound)var12;
                  var10 = true;
               } catch (NBTException var13) {
                  throw new CommandException("commands.setblock.tagError", new Object[]{var13.getMessage()});
               }
            }

            if(p_71515_2_.length >= 6) {
               if(p_71515_2_[5].equals("destroy")) {
                  var8.func_147480_a(var3, var4, var5, true);
               } else if(p_71515_2_[5].equals("keep") && !var8.func_147437_c(var3, var4, var5)) {
                  throw new CommandException("commands.setblock.noChange", new Object[0]);
               }
            }

            if(!var8.func_147465_d(var3, var4, var5, var6, var7, 3)) {
               throw new CommandException("commands.setblock.noChange", new Object[0]);
            } else {
               if(var10) {
                  TileEntity var14 = var8.func_147438_o(var3, var4, var5);
                  if(var14 != null) {
                     var9.func_74768_a("x", var3);
                     var9.func_74768_a("y", var4);
                     var9.func_74768_a("z", var5);
                     var14.func_145839_a(var9);
                  }
               }

               func_152373_a(p_71515_1_, this, "commands.setblock.success", new Object[0]);
            }
         }
      } else {
         throw new WrongUsageException("commands.setblock.usage", new Object[0]);
      }
   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      return p_71516_2_.length == 4?func_71531_a(p_71516_2_, Block.field_149771_c.func_148742_b()):(p_71516_2_.length == 6?func_71530_a(p_71516_2_, new String[]{"replace", "destroy", "keep"}):null);
   }
}
