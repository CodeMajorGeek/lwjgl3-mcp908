package net.minecraft.entity.item;

import java.util.ArrayList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityPainting extends EntityHanging {

   public EntityPainting.EnumArt field_70522_e;
   private static final String __OBFID = "CL_00001556";


   public EntityPainting(World p_i1599_1_) {
      super(p_i1599_1_);
   }

   public EntityPainting(World p_i1600_1_, int p_i1600_2_, int p_i1600_3_, int p_i1600_4_, int p_i1600_5_) {
      super(p_i1600_1_, p_i1600_2_, p_i1600_3_, p_i1600_4_, p_i1600_5_);
      ArrayList var6 = new ArrayList();
      EntityPainting.EnumArt[] var7 = EntityPainting.EnumArt.values();
      int var8 = var7.length;

      for(int var9 = 0; var9 < var8; ++var9) {
         EntityPainting.EnumArt var10 = var7[var9];
         this.field_70522_e = var10;
         this.func_82328_a(p_i1600_5_);
         if(this.func_70518_d()) {
            var6.add(var10);
         }
      }

      if(!var6.isEmpty()) {
         this.field_70522_e = (EntityPainting.EnumArt)var6.get(this.field_70146_Z.nextInt(var6.size()));
      }

      this.func_82328_a(p_i1600_5_);
   }

   public EntityPainting(World p_i1601_1_, int p_i1601_2_, int p_i1601_3_, int p_i1601_4_, int p_i1601_5_, String p_i1601_6_) {
      this(p_i1601_1_, p_i1601_2_, p_i1601_3_, p_i1601_4_, p_i1601_5_);
      EntityPainting.EnumArt[] var7 = EntityPainting.EnumArt.values();
      int var8 = var7.length;

      for(int var9 = 0; var9 < var8; ++var9) {
         EntityPainting.EnumArt var10 = var7[var9];
         if(var10.field_75702_A.equals(p_i1601_6_)) {
            this.field_70522_e = var10;
            break;
         }
      }

      this.func_82328_a(p_i1601_5_);
   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      p_70014_1_.func_74778_a("Motive", this.field_70522_e.field_75702_A);
      super.func_70014_b(p_70014_1_);
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      String var2 = p_70037_1_.func_74779_i("Motive");
      EntityPainting.EnumArt[] var3 = EntityPainting.EnumArt.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         EntityPainting.EnumArt var6 = var3[var5];
         if(var6.field_75702_A.equals(var2)) {
            this.field_70522_e = var6;
         }
      }

      if(this.field_70522_e == null) {
         this.field_70522_e = EntityPainting.EnumArt.Kebab;
      }

      super.func_70037_a(p_70037_1_);
   }

   public int func_82329_d() {
      return this.field_70522_e.field_75703_B;
   }

   public int func_82330_g() {
      return this.field_70522_e.field_75704_C;
   }

   public void func_110128_b(Entity p_110128_1_) {
      if(p_110128_1_ instanceof EntityPlayer) {
         EntityPlayer var2 = (EntityPlayer)p_110128_1_;
         if(var2.field_71075_bZ.field_75098_d) {
            return;
         }
      }

      this.func_70099_a(new ItemStack(Items.field_151159_an), 0.0F);
   }

   public static enum EnumArt {

      Kebab("Kebab", 0, "Kebab", 16, 16, 0, 0),
      Aztec("Aztec", 1, "Aztec", 16, 16, 16, 0),
      Alban("Alban", 2, "Alban", 16, 16, 32, 0),
      Aztec2("Aztec2", 3, "Aztec2", 16, 16, 48, 0),
      Bomb("Bomb", 4, "Bomb", 16, 16, 64, 0),
      Plant("Plant", 5, "Plant", 16, 16, 80, 0),
      Wasteland("Wasteland", 6, "Wasteland", 16, 16, 96, 0),
      Pool("Pool", 7, "Pool", 32, 16, 0, 32),
      Courbet("Courbet", 8, "Courbet", 32, 16, 32, 32),
      Sea("Sea", 9, "Sea", 32, 16, 64, 32),
      Sunset("Sunset", 10, "Sunset", 32, 16, 96, 32),
      Creebet("Creebet", 11, "Creebet", 32, 16, 128, 32),
      Wanderer("Wanderer", 12, "Wanderer", 16, 32, 0, 64),
      Graham("Graham", 13, "Graham", 16, 32, 16, 64),
      Match("Match", 14, "Match", 32, 32, 0, 128),
      Bust("Bust", 15, "Bust", 32, 32, 32, 128),
      Stage("Stage", 16, "Stage", 32, 32, 64, 128),
      Void("Void", 17, "Void", 32, 32, 96, 128),
      SkullAndRoses("SkullAndRoses", 18, "SkullAndRoses", 32, 32, 128, 128),
      Wither("Wither", 19, "Wither", 32, 32, 160, 128),
      Fighters("Fighters", 20, "Fighters", 64, 32, 0, 96),
      Pointer("Pointer", 21, "Pointer", 64, 64, 0, 192),
      Pigscene("Pigscene", 22, "Pigscene", 64, 64, 64, 192),
      BurningSkull("BurningSkull", 23, "BurningSkull", 64, 64, 128, 192),
      Skeleton("Skeleton", 24, "Skeleton", 64, 48, 192, 64),
      DonkeyKong("DonkeyKong", 25, "DonkeyKong", 64, 48, 192, 112);
      public static final int field_75728_z = "SkullAndRoses".length();
      public final String field_75702_A;
      public final int field_75703_B;
      public final int field_75704_C;
      public final int field_75699_D;
      public final int field_75700_E;
      // $FF: synthetic field
      private static final EntityPainting.EnumArt[] $VALUES = new EntityPainting.EnumArt[]{Kebab, Aztec, Alban, Aztec2, Bomb, Plant, Wasteland, Pool, Courbet, Sea, Sunset, Creebet, Wanderer, Graham, Match, Bust, Stage, Void, SkullAndRoses, Wither, Fighters, Pointer, Pigscene, BurningSkull, Skeleton, DonkeyKong};
      private static final String __OBFID = "CL_00001557";


      private EnumArt(String p_i1598_1_, int p_i1598_2_, String p_i1598_3_, int p_i1598_4_, int p_i1598_5_, int p_i1598_6_, int p_i1598_7_) {
         this.field_75702_A = p_i1598_3_;
         this.field_75703_B = p_i1598_4_;
         this.field_75704_C = p_i1598_5_;
         this.field_75699_D = p_i1598_6_;
         this.field_75700_E = p_i1598_7_;
      }

   }
}
