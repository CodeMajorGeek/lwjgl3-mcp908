package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;

public class CommandGive extends CommandBase {

   private static final String __OBFID = "CL_00000502";


   public String func_71517_b() {
      return "give";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.give.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
      if(p_71515_2_.length < 2) {
         throw new WrongUsageException("commands.give.usage", new Object[0]);
      } else {
         EntityPlayerMP var3 = func_82359_c(p_71515_1_, p_71515_2_[0]);
         Item var4 = func_147179_f(p_71515_1_, p_71515_2_[1]);
         int var5 = 1;
         int var6 = 0;
         if(p_71515_2_.length >= 3) {
            var5 = func_71532_a(p_71515_1_, p_71515_2_[2], 1, 64);
         }

         if(p_71515_2_.length >= 4) {
            var6 = func_71526_a(p_71515_1_, p_71515_2_[3]);
         }

         ItemStack var7 = new ItemStack(var4, var5, var6);
         if(p_71515_2_.length >= 5) {
            String var8 = func_147178_a(p_71515_1_, p_71515_2_, 4).func_150260_c();

            try {
               NBTBase var9 = JsonToNBT.func_150315_a(var8);
               if(!(var9 instanceof NBTTagCompound)) {
                  func_152373_a(p_71515_1_, this, "commands.give.tagError", new Object[]{"Not a valid tag"});
                  return;
               }

               var7.func_77982_d((NBTTagCompound)var9);
            } catch (NBTException var10) {
               func_152373_a(p_71515_1_, this, "commands.give.tagError", new Object[]{var10.getMessage()});
               return;
            }
         }

         EntityItem var11 = var3.func_71019_a(var7, false);
         var11.field_145804_b = 0;
         var11.func_145797_a(var3.func_70005_c_());
         func_152373_a(p_71515_1_, this, "commands.give.success", new Object[]{var7.func_151000_E(), Integer.valueOf(var5), var3.func_70005_c_()});
      }
   }

   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
      return p_71516_2_.length == 1?func_71530_a(p_71516_2_, this.func_71536_c()):(p_71516_2_.length == 2?func_71531_a(p_71516_2_, Item.field_150901_e.func_148742_b()):null);
   }

   protected String[] func_71536_c() {
      return MinecraftServer.func_71276_C().func_71213_z();
   }

   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
      return p_82358_2_ == 0;
   }
}
