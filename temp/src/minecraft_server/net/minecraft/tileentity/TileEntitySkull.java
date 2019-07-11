package net.minecraft.tileentity;

import com.google.common.collect.Iterables;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.util.UUID;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.StringUtils;

public class TileEntitySkull extends TileEntity {

   private int field_145908_a;
   private int field_145910_i;
   private GameProfile field_152110_j = null;
   private static final String __OBFID = "CL_00000364";


   public void func_145841_b(NBTTagCompound p_145841_1_) {
      super.func_145841_b(p_145841_1_);
      p_145841_1_.func_74774_a("SkullType", (byte)(this.field_145908_a & 255));
      p_145841_1_.func_74774_a("Rot", (byte)(this.field_145910_i & 255));
      if(this.field_152110_j != null) {
         NBTTagCompound var2 = new NBTTagCompound();
         NBTUtil.func_152460_a(var2, this.field_152110_j);
         p_145841_1_.func_74782_a("Owner", var2);
      }

   }

   public void func_145839_a(NBTTagCompound p_145839_1_) {
      super.func_145839_a(p_145839_1_);
      this.field_145908_a = p_145839_1_.func_74771_c("SkullType");
      this.field_145910_i = p_145839_1_.func_74771_c("Rot");
      if(this.field_145908_a == 3) {
         if(p_145839_1_.func_150297_b("Owner", 10)) {
            this.field_152110_j = NBTUtil.func_152459_a(p_145839_1_.func_74775_l("Owner"));
         } else if(p_145839_1_.func_150297_b("ExtraType", 8) && !StringUtils.func_151246_b(p_145839_1_.func_74779_i("ExtraType"))) {
            this.field_152110_j = new GameProfile((UUID)null, p_145839_1_.func_74779_i("ExtraType"));
            this.func_152109_d();
         }
      }

   }

   public GameProfile func_152108_a() {
      return this.field_152110_j;
   }

   public Packet func_145844_m() {
      NBTTagCompound var1 = new NBTTagCompound();
      this.func_145841_b(var1);
      return new S35PacketUpdateTileEntity(this.field_145851_c, this.field_145848_d, this.field_145849_e, 4, var1);
   }

   public void func_152107_a(int p_152107_1_) {
      this.field_145908_a = p_152107_1_;
      this.field_152110_j = null;
   }

   public void func_152106_a(GameProfile p_152106_1_) {
      this.field_145908_a = 3;
      this.field_152110_j = p_152106_1_;
      this.func_152109_d();
   }

   private void func_152109_d() {
      if(this.field_152110_j != null && !StringUtils.func_151246_b(this.field_152110_j.getName())) {
         if(!this.field_152110_j.isComplete() || !this.field_152110_j.getProperties().containsKey("textures")) {
            GameProfile var1 = MinecraftServer.func_71276_C().func_152358_ax().func_152655_a(this.field_152110_j.getName());
            if(var1 != null) {
               Property var2 = (Property)Iterables.getFirst(var1.getProperties().get("textures"), (Object)null);
               if(var2 == null) {
                  var1 = MinecraftServer.func_71276_C().func_147130_as().fillProfileProperties(var1, true);
               }

               this.field_152110_j = var1;
               this.func_70296_d();
            }
         }
      }
   }

   public int func_145904_a() {
      return this.field_145908_a;
   }

   public void func_145903_a(int p_145903_1_) {
      this.field_145910_i = p_145903_1_;
   }
}
