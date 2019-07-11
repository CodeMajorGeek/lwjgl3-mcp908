package net.minecraft.tileentity;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockHopper;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.IHopper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Facing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class TileEntityHopper extends TileEntity implements IHopper {

   private ItemStack[] field_145900_a = new ItemStack[5];
   private String field_145902_i;
   private int field_145901_j = -1;
   private static final String __OBFID = "CL_00000359";


   public void func_145839_a(NBTTagCompound p_145839_1_) {
      super.func_145839_a(p_145839_1_);
      NBTTagList var2 = p_145839_1_.func_150295_c("Items", 10);
      this.field_145900_a = new ItemStack[this.func_70302_i_()];
      if(p_145839_1_.func_150297_b("CustomName", 8)) {
         this.field_145902_i = p_145839_1_.func_74779_i("CustomName");
      }

      this.field_145901_j = p_145839_1_.func_74762_e("TransferCooldown");

      for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
         NBTTagCompound var4 = var2.func_150305_b(var3);
         byte var5 = var4.func_74771_c("Slot");
         if(var5 >= 0 && var5 < this.field_145900_a.length) {
            this.field_145900_a[var5] = ItemStack.func_77949_a(var4);
         }
      }

   }

   public void func_145841_b(NBTTagCompound p_145841_1_) {
      super.func_145841_b(p_145841_1_);
      NBTTagList var2 = new NBTTagList();

      for(int var3 = 0; var3 < this.field_145900_a.length; ++var3) {
         if(this.field_145900_a[var3] != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.func_74774_a("Slot", (byte)var3);
            this.field_145900_a[var3].func_77955_b(var4);
            var2.func_74742_a(var4);
         }
      }

      p_145841_1_.func_74782_a("Items", var2);
      p_145841_1_.func_74768_a("TransferCooldown", this.field_145901_j);
      if(this.func_145818_k_()) {
         p_145841_1_.func_74778_a("CustomName", this.field_145902_i);
      }

   }

   public void func_70296_d() {
      super.func_70296_d();
   }

   public int func_70302_i_() {
      return this.field_145900_a.length;
   }

   public ItemStack func_70301_a(int p_70301_1_) {
      return this.field_145900_a[p_70301_1_];
   }

   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
      if(this.field_145900_a[p_70298_1_] != null) {
         ItemStack var3;
         if(this.field_145900_a[p_70298_1_].field_77994_a <= p_70298_2_) {
            var3 = this.field_145900_a[p_70298_1_];
            this.field_145900_a[p_70298_1_] = null;
            return var3;
         } else {
            var3 = this.field_145900_a[p_70298_1_].func_77979_a(p_70298_2_);
            if(this.field_145900_a[p_70298_1_].field_77994_a == 0) {
               this.field_145900_a[p_70298_1_] = null;
            }

            return var3;
         }
      } else {
         return null;
      }
   }

   public ItemStack func_70304_b(int p_70304_1_) {
      if(this.field_145900_a[p_70304_1_] != null) {
         ItemStack var2 = this.field_145900_a[p_70304_1_];
         this.field_145900_a[p_70304_1_] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
      this.field_145900_a[p_70299_1_] = p_70299_2_;
      if(p_70299_2_ != null && p_70299_2_.field_77994_a > this.func_70297_j_()) {
         p_70299_2_.field_77994_a = this.func_70297_j_();
      }

   }

   public String func_145825_b() {
      return this.func_145818_k_()?this.field_145902_i:"container.hopper";
   }

   public boolean func_145818_k_() {
      return this.field_145902_i != null && this.field_145902_i.length() > 0;
   }

   public void func_145886_a(String p_145886_1_) {
      this.field_145902_i = p_145886_1_;
   }

   public int func_70297_j_() {
      return 64;
   }

   public boolean func_70300_a(EntityPlayer p_70300_1_) {
      return this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e) != this?false:p_70300_1_.func_70092_e((double)this.field_145851_c + 0.5D, (double)this.field_145848_d + 0.5D, (double)this.field_145849_e + 0.5D) <= 64.0D;
   }

   public void func_70295_k_() {}

   public void func_70305_f() {}

   public boolean func_94041_b(int p_94041_1_, ItemStack p_94041_2_) {
      return true;
   }

   public void func_145845_h() {
      if(this.field_145850_b != null && !this.field_145850_b.field_72995_K) {
         --this.field_145901_j;
         if(!this.func_145888_j()) {
            this.func_145896_c(0);
            this.func_145887_i();
         }

      }
   }

   public boolean func_145887_i() {
      if(this.field_145850_b != null && !this.field_145850_b.field_72995_K) {
         if(!this.func_145888_j() && BlockHopper.func_149917_c(this.func_145832_p())) {
            boolean var1 = false;
            if(!this.func_152104_k()) {
               var1 = this.func_145883_k();
            }

            if(!this.func_152105_l()) {
               var1 = func_145891_a(this) || var1;
            }

            if(var1) {
               this.func_145896_c(8);
               this.func_70296_d();
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private boolean func_152104_k() {
      ItemStack[] var1 = this.field_145900_a;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         ItemStack var4 = var1[var3];
         if(var4 != null) {
            return false;
         }
      }

      return true;
   }

   private boolean func_152105_l() {
      ItemStack[] var1 = this.field_145900_a;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         ItemStack var4 = var1[var3];
         if(var4 == null || var4.field_77994_a != var4.func_77976_d()) {
            return false;
         }
      }

      return true;
   }

   private boolean func_145883_k() {
      IInventory var1 = this.func_145895_l();
      if(var1 == null) {
         return false;
      } else {
         int var2 = Facing.field_71588_a[BlockHopper.func_149918_b(this.func_145832_p())];
         if(this.func_152102_a(var1, var2)) {
            return false;
         } else {
            for(int var3 = 0; var3 < this.func_70302_i_(); ++var3) {
               if(this.func_70301_a(var3) != null) {
                  ItemStack var4 = this.func_70301_a(var3).func_77946_l();
                  ItemStack var5 = func_145889_a(var1, this.func_70298_a(var3, 1), var2);
                  if(var5 == null || var5.field_77994_a == 0) {
                     var1.func_70296_d();
                     return true;
                  }

                  this.func_70299_a(var3, var4);
               }
            }

            return false;
         }
      }
   }

   private boolean func_152102_a(IInventory p_152102_1_, int p_152102_2_) {
      if(p_152102_1_ instanceof ISidedInventory && p_152102_2_ > -1) {
         ISidedInventory var7 = (ISidedInventory)p_152102_1_;
         int[] var8 = var7.func_94128_d(p_152102_2_);

         for(int var9 = 0; var9 < var8.length; ++var9) {
            ItemStack var6 = var7.func_70301_a(var8[var9]);
            if(var6 == null || var6.field_77994_a != var6.func_77976_d()) {
               return false;
            }
         }
      } else {
         int var3 = p_152102_1_.func_70302_i_();

         for(int var4 = 0; var4 < var3; ++var4) {
            ItemStack var5 = p_152102_1_.func_70301_a(var4);
            if(var5 == null || var5.field_77994_a != var5.func_77976_d()) {
               return false;
            }
         }
      }

      return true;
   }

   private static boolean func_152103_b(IInventory p_152103_0_, int p_152103_1_) {
      if(p_152103_0_ instanceof ISidedInventory && p_152103_1_ > -1) {
         ISidedInventory var5 = (ISidedInventory)p_152103_0_;
         int[] var6 = var5.func_94128_d(p_152103_1_);

         for(int var4 = 0; var4 < var6.length; ++var4) {
            if(var5.func_70301_a(var6[var4]) != null) {
               return false;
            }
         }
      } else {
         int var2 = p_152103_0_.func_70302_i_();

         for(int var3 = 0; var3 < var2; ++var3) {
            if(p_152103_0_.func_70301_a(var3) != null) {
               return false;
            }
         }
      }

      return true;
   }

   public static boolean func_145891_a(IHopper p_145891_0_) {
      IInventory var1 = func_145884_b(p_145891_0_);
      if(var1 != null) {
         byte var2 = 0;
         if(func_152103_b(var1, var2)) {
            return false;
         }

         if(var1 instanceof ISidedInventory && var2 > -1) {
            ISidedInventory var7 = (ISidedInventory)var1;
            int[] var8 = var7.func_94128_d(var2);

            for(int var5 = 0; var5 < var8.length; ++var5) {
               if(func_145892_a(p_145891_0_, var1, var8[var5], var2)) {
                  return true;
               }
            }
         } else {
            int var3 = var1.func_70302_i_();

            for(int var4 = 0; var4 < var3; ++var4) {
               if(func_145892_a(p_145891_0_, var1, var4, var2)) {
                  return true;
               }
            }
         }
      } else {
         EntityItem var6 = func_145897_a(p_145891_0_.func_145831_w(), p_145891_0_.func_96107_aA(), p_145891_0_.func_96109_aB() + 1.0D, p_145891_0_.func_96108_aC());
         if(var6 != null) {
            return func_145898_a(p_145891_0_, var6);
         }
      }

      return false;
   }

   private static boolean func_145892_a(IHopper p_145892_0_, IInventory p_145892_1_, int p_145892_2_, int p_145892_3_) {
      ItemStack var4 = p_145892_1_.func_70301_a(p_145892_2_);
      if(var4 != null && func_145890_b(p_145892_1_, var4, p_145892_2_, p_145892_3_)) {
         ItemStack var5 = var4.func_77946_l();
         ItemStack var6 = func_145889_a(p_145892_0_, p_145892_1_.func_70298_a(p_145892_2_, 1), -1);
         if(var6 == null || var6.field_77994_a == 0) {
            p_145892_1_.func_70296_d();
            return true;
         }

         p_145892_1_.func_70299_a(p_145892_2_, var5);
      }

      return false;
   }

   public static boolean func_145898_a(IInventory p_145898_0_, EntityItem p_145898_1_) {
      boolean var2 = false;
      if(p_145898_1_ == null) {
         return false;
      } else {
         ItemStack var3 = p_145898_1_.func_92059_d().func_77946_l();
         ItemStack var4 = func_145889_a(p_145898_0_, var3, -1);
         if(var4 != null && var4.field_77994_a != 0) {
            p_145898_1_.func_92058_a(var4);
         } else {
            var2 = true;
            p_145898_1_.func_70106_y();
         }

         return var2;
      }
   }

   public static ItemStack func_145889_a(IInventory p_145889_0_, ItemStack p_145889_1_, int p_145889_2_) {
      if(p_145889_0_ instanceof ISidedInventory && p_145889_2_ > -1) {
         ISidedInventory var6 = (ISidedInventory)p_145889_0_;
         int[] var7 = var6.func_94128_d(p_145889_2_);

         for(int var5 = 0; var5 < var7.length && p_145889_1_ != null && p_145889_1_.field_77994_a > 0; ++var5) {
            p_145889_1_ = func_145899_c(p_145889_0_, p_145889_1_, var7[var5], p_145889_2_);
         }
      } else {
         int var3 = p_145889_0_.func_70302_i_();

         for(int var4 = 0; var4 < var3 && p_145889_1_ != null && p_145889_1_.field_77994_a > 0; ++var4) {
            p_145889_1_ = func_145899_c(p_145889_0_, p_145889_1_, var4, p_145889_2_);
         }
      }

      if(p_145889_1_ != null && p_145889_1_.field_77994_a == 0) {
         p_145889_1_ = null;
      }

      return p_145889_1_;
   }

   private static boolean func_145885_a(IInventory p_145885_0_, ItemStack p_145885_1_, int p_145885_2_, int p_145885_3_) {
      return !p_145885_0_.func_94041_b(p_145885_2_, p_145885_1_)?false:!(p_145885_0_ instanceof ISidedInventory) || ((ISidedInventory)p_145885_0_).func_102007_a(p_145885_2_, p_145885_1_, p_145885_3_);
   }

   private static boolean func_145890_b(IInventory p_145890_0_, ItemStack p_145890_1_, int p_145890_2_, int p_145890_3_) {
      return !(p_145890_0_ instanceof ISidedInventory) || ((ISidedInventory)p_145890_0_).func_102008_b(p_145890_2_, p_145890_1_, p_145890_3_);
   }

   private static ItemStack func_145899_c(IInventory p_145899_0_, ItemStack p_145899_1_, int p_145899_2_, int p_145899_3_) {
      ItemStack var4 = p_145899_0_.func_70301_a(p_145899_2_);
      if(func_145885_a(p_145899_0_, p_145899_1_, p_145899_2_, p_145899_3_)) {
         boolean var5 = false;
         if(var4 == null) {
            p_145899_0_.func_70299_a(p_145899_2_, p_145899_1_);
            p_145899_1_ = null;
            var5 = true;
         } else if(func_145894_a(var4, p_145899_1_)) {
            int var6 = p_145899_1_.func_77976_d() - var4.field_77994_a;
            int var7 = Math.min(p_145899_1_.field_77994_a, var6);
            p_145899_1_.field_77994_a -= var7;
            var4.field_77994_a += var7;
            var5 = var7 > 0;
         }

         if(var5) {
            if(p_145899_0_ instanceof TileEntityHopper) {
               ((TileEntityHopper)p_145899_0_).func_145896_c(8);
               p_145899_0_.func_70296_d();
            }

            p_145899_0_.func_70296_d();
         }
      }

      return p_145899_1_;
   }

   private IInventory func_145895_l() {
      int var1 = BlockHopper.func_149918_b(this.func_145832_p());
      return func_145893_b(this.func_145831_w(), (double)(this.field_145851_c + Facing.field_71586_b[var1]), (double)(this.field_145848_d + Facing.field_71587_c[var1]), (double)(this.field_145849_e + Facing.field_71585_d[var1]));
   }

   public static IInventory func_145884_b(IHopper p_145884_0_) {
      return func_145893_b(p_145884_0_.func_145831_w(), p_145884_0_.func_96107_aA(), p_145884_0_.func_96109_aB() + 1.0D, p_145884_0_.func_96108_aC());
   }

   public static EntityItem func_145897_a(World p_145897_0_, double p_145897_1_, double p_145897_3_, double p_145897_5_) {
      List var7 = p_145897_0_.func_82733_a(EntityItem.class, AxisAlignedBB.func_72330_a(p_145897_1_, p_145897_3_, p_145897_5_, p_145897_1_ + 1.0D, p_145897_3_ + 1.0D, p_145897_5_ + 1.0D), IEntitySelector.field_94557_a);
      return var7.size() > 0?(EntityItem)var7.get(0):null;
   }

   public static IInventory func_145893_b(World p_145893_0_, double p_145893_1_, double p_145893_3_, double p_145893_5_) {
      IInventory var7 = null;
      int var8 = MathHelper.func_76128_c(p_145893_1_);
      int var9 = MathHelper.func_76128_c(p_145893_3_);
      int var10 = MathHelper.func_76128_c(p_145893_5_);
      TileEntity var11 = p_145893_0_.func_147438_o(var8, var9, var10);
      if(var11 != null && var11 instanceof IInventory) {
         var7 = (IInventory)var11;
         if(var7 instanceof TileEntityChest) {
            Block var12 = p_145893_0_.func_147439_a(var8, var9, var10);
            if(var12 instanceof BlockChest) {
               var7 = ((BlockChest)var12).func_149951_m(p_145893_0_, var8, var9, var10);
            }
         }
      }

      if(var7 == null) {
         List var13 = p_145893_0_.func_94576_a((Entity)null, AxisAlignedBB.func_72330_a(p_145893_1_, p_145893_3_, p_145893_5_, p_145893_1_ + 1.0D, p_145893_3_ + 1.0D, p_145893_5_ + 1.0D), IEntitySelector.field_96566_b);
         if(var13 != null && var13.size() > 0) {
            var7 = (IInventory)var13.get(p_145893_0_.field_73012_v.nextInt(var13.size()));
         }
      }

      return var7;
   }

   private static boolean func_145894_a(ItemStack p_145894_0_, ItemStack p_145894_1_) {
      return p_145894_0_.func_77973_b() != p_145894_1_.func_77973_b()?false:(p_145894_0_.func_77960_j() != p_145894_1_.func_77960_j()?false:(p_145894_0_.field_77994_a > p_145894_0_.func_77976_d()?false:ItemStack.func_77970_a(p_145894_0_, p_145894_1_)));
   }

   public double func_96107_aA() {
      return (double)this.field_145851_c;
   }

   public double func_96109_aB() {
      return (double)this.field_145848_d;
   }

   public double func_96108_aC() {
      return (double)this.field_145849_e;
   }

   public void func_145896_c(int p_145896_1_) {
      this.field_145901_j = p_145896_1_;
   }

   public boolean func_145888_j() {
      return this.field_145901_j > 0;
   }
}
