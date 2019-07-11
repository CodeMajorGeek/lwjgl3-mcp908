package net.minecraft.world;

import java.util.Iterator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.S25PacketBlockBreakAnim;
import net.minecraft.network.play.server.S28PacketEffect;
import net.minecraft.network.play.server.S29PacketSoundEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.IWorldAccess;
import net.minecraft.world.WorldServer;

public class WorldManager implements IWorldAccess {

   private MinecraftServer field_72783_a;
   private WorldServer field_72782_b;
   private static final String __OBFID = "CL_00001433";


   public WorldManager(MinecraftServer p_i1517_1_, WorldServer p_i1517_2_) {
      this.field_72783_a = p_i1517_1_;
      this.field_72782_b = p_i1517_2_;
   }

   public void func_72708_a(String p_72708_1_, double p_72708_2_, double p_72708_4_, double p_72708_6_, double p_72708_8_, double p_72708_10_, double p_72708_12_) {}

   public void func_72703_a(Entity p_72703_1_) {
      this.field_72782_b.func_73039_n().func_72786_a(p_72703_1_);
   }

   public void func_72709_b(Entity p_72709_1_) {
      this.field_72782_b.func_73039_n().func_72790_b(p_72709_1_);
   }

   public void func_72704_a(String p_72704_1_, double p_72704_2_, double p_72704_4_, double p_72704_6_, float p_72704_8_, float p_72704_9_) {
      this.field_72783_a.func_71203_ab().func_148541_a(p_72704_2_, p_72704_4_, p_72704_6_, p_72704_8_ > 1.0F?(double)(16.0F * p_72704_8_):16.0D, this.field_72782_b.field_73011_w.field_76574_g, new S29PacketSoundEffect(p_72704_1_, p_72704_2_, p_72704_4_, p_72704_6_, p_72704_8_, p_72704_9_));
   }

   public void func_85102_a(EntityPlayer p_85102_1_, String p_85102_2_, double p_85102_3_, double p_85102_5_, double p_85102_7_, float p_85102_9_, float p_85102_10_) {
      this.field_72783_a.func_71203_ab().func_148543_a(p_85102_1_, p_85102_3_, p_85102_5_, p_85102_7_, p_85102_9_ > 1.0F?(double)(16.0F * p_85102_9_):16.0D, this.field_72782_b.field_73011_w.field_76574_g, new S29PacketSoundEffect(p_85102_2_, p_85102_3_, p_85102_5_, p_85102_7_, p_85102_9_, p_85102_10_));
   }

   public void func_147585_a(int p_147585_1_, int p_147585_2_, int p_147585_3_, int p_147585_4_, int p_147585_5_, int p_147585_6_) {}

   public void func_147586_a(int p_147586_1_, int p_147586_2_, int p_147586_3_) {
      this.field_72782_b.func_73040_p().func_151250_a(p_147586_1_, p_147586_2_, p_147586_3_);
   }

   public void func_147588_b(int p_147588_1_, int p_147588_2_, int p_147588_3_) {}

   public void func_72702_a(String p_72702_1_, int p_72702_2_, int p_72702_3_, int p_72702_4_) {}

   public void func_72706_a(EntityPlayer p_72706_1_, int p_72706_2_, int p_72706_3_, int p_72706_4_, int p_72706_5_, int p_72706_6_) {
      this.field_72783_a.func_71203_ab().func_148543_a(p_72706_1_, (double)p_72706_3_, (double)p_72706_4_, (double)p_72706_5_, 64.0D, this.field_72782_b.field_73011_w.field_76574_g, new S28PacketEffect(p_72706_2_, p_72706_3_, p_72706_4_, p_72706_5_, p_72706_6_, false));
   }

   public void func_82746_a(int p_82746_1_, int p_82746_2_, int p_82746_3_, int p_82746_4_, int p_82746_5_) {
      this.field_72783_a.func_71203_ab().func_148540_a(new S28PacketEffect(p_82746_1_, p_82746_2_, p_82746_3_, p_82746_4_, p_82746_5_, true));
   }

   public void func_147587_b(int p_147587_1_, int p_147587_2_, int p_147587_3_, int p_147587_4_, int p_147587_5_) {
      Iterator var6 = this.field_72783_a.func_71203_ab().field_72404_b.iterator();

      while(var6.hasNext()) {
         EntityPlayerMP var7 = (EntityPlayerMP)var6.next();
         if(var7 != null && var7.field_70170_p == this.field_72782_b && var7.func_145782_y() != p_147587_1_) {
            double var8 = (double)p_147587_2_ - var7.field_70165_t;
            double var10 = (double)p_147587_3_ - var7.field_70163_u;
            double var12 = (double)p_147587_4_ - var7.field_70161_v;
            if(var8 * var8 + var10 * var10 + var12 * var12 < 1024.0D) {
               var7.field_71135_a.func_147359_a(new S25PacketBlockBreakAnim(p_147587_1_, p_147587_2_, p_147587_3_, p_147587_4_, p_147587_5_));
            }
         }
      }

   }

   public void func_147584_b() {}
}
