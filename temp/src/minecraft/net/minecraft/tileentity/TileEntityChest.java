package net.minecraft.tileentity;

import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityChest extends TileEntity implements IInventory {

   private ItemStack[] field_145985_p = new ItemStack[36];
   public boolean field_145984_a;
   public TileEntityChest field_145992_i;
   public TileEntityChest field_145990_j;
   public TileEntityChest field_145991_k;
   public TileEntityChest field_145988_l;
   public float field_145989_m;
   public float field_145986_n;
   public int field_145987_o;
   private int field_145983_q;
   private int field_145982_r;
   private String field_145981_s;
   private static final String __OBFID = "CL_00000346";


   public TileEntityChest() {
      this.field_145982_r = -1;
   }

   public TileEntityChest(int p_i2350_1_) {
      this.field_145982_r = p_i2350_1_;
   }

   public int func_70302_i_() {
      return 27;
   }

   public ItemStack func_70301_a(int p_70301_1_) {
      return this.field_145985_p[p_70301_1_];
   }

   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
      if(this.field_145985_p[p_70298_1_] != null) {
         ItemStack var3;
         if(this.field_145985_p[p_70298_1_].field_77994_a <= p_70298_2_) {
            var3 = this.field_145985_p[p_70298_1_];
            this.field_145985_p[p_70298_1_] = null;
            this.func_70296_d();
            return var3;
         } else {
            var3 = this.field_145985_p[p_70298_1_].func_77979_a(p_70298_2_);
            if(this.field_145985_p[p_70298_1_].field_77994_a == 0) {
               this.field_145985_p[p_70298_1_] = null;
            }

            this.func_70296_d();
            return var3;
         }
      } else {
         return null;
      }
   }

   public ItemStack func_70304_b(int p_70304_1_) {
      if(this.field_145985_p[p_70304_1_] != null) {
         ItemStack var2 = this.field_145985_p[p_70304_1_];
         this.field_145985_p[p_70304_1_] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
      this.field_145985_p[p_70299_1_] = p_70299_2_;
      if(p_70299_2_ != null && p_70299_2_.field_77994_a > this.func_70297_j_()) {
         p_70299_2_.field_77994_a = this.func_70297_j_();
      }

      this.func_70296_d();
   }

   public String func_145825_b() {
      return this.func_145818_k_()?this.field_145981_s:"container.chest";
   }

   public boolean func_145818_k_() {
      return this.field_145981_s != null && this.field_145981_s.length() > 0;
   }

   public void func_145976_a(String p_145976_1_) {
      this.field_145981_s = p_145976_1_;
   }

   public void func_145839_a(NBTTagCompound p_145839_1_) {
      super.func_145839_a(p_145839_1_);
      NBTTagList var2 = p_145839_1_.func_150295_c("Items", 10);
      this.field_145985_p = new ItemStack[this.func_70302_i_()];
      if(p_145839_1_.func_150297_b("CustomName", 8)) {
         this.field_145981_s = p_145839_1_.func_74779_i("CustomName");
      }

      for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
         NBTTagCompound var4 = var2.func_150305_b(var3);
         int var5 = var4.func_74771_c("Slot") & 255;
         if(var5 >= 0 && var5 < this.field_145985_p.length) {
            this.field_145985_p[var5] = ItemStack.func_77949_a(var4);
         }
      }

   }

   public void func_145841_b(NBTTagCompound p_145841_1_) {
      super.func_145841_b(p_145841_1_);
      NBTTagList var2 = new NBTTagList();

      for(int var3 = 0; var3 < this.field_145985_p.length; ++var3) {
         if(this.field_145985_p[var3] != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.func_74774_a("Slot", (byte)var3);
            this.field_145985_p[var3].func_77955_b(var4);
            var2.func_74742_a(var4);
         }
      }

      p_145841_1_.func_74782_a("Items", var2);
      if(this.func_145818_k_()) {
         p_145841_1_.func_74778_a("CustomName", this.field_145981_s);
      }

   }

   public int func_70297_j_() {
      return 64;
   }

   public boolean func_70300_a(EntityPlayer p_70300_1_) {
      return this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e) != this?false:p_70300_1_.func_70092_e((double)this.field_145851_c + 0.5D, (double)this.field_145848_d + 0.5D, (double)this.field_145849_e + 0.5D) <= 64.0D;
   }

   public void func_145836_u() {
      super.func_145836_u();
      this.field_145984_a = false;
   }

   private void func_145978_a(TileEntityChest p_145978_1_, int p_145978_2_) {
      if(p_145978_1_.func_145837_r()) {
         this.field_145984_a = false;
      } else if(this.field_145984_a) {
         switch(p_145978_2_) {
         case 0:
            if(this.field_145988_l != p_145978_1_) {
               this.field_145984_a = false;
            }
            break;
         case 1:
            if(this.field_145991_k != p_145978_1_) {
               this.field_145984_a = false;
            }
            break;
         case 2:
            if(this.field_145992_i != p_145978_1_) {
               this.field_145984_a = false;
            }
            break;
         case 3:
            if(this.field_145990_j != p_145978_1_) {
               this.field_145984_a = false;
            }
         }
      }

   }

   public void func_145979_i() {
      if(!this.field_145984_a) {
         this.field_145984_a = true;
         this.field_145992_i = null;
         this.field_145990_j = null;
         this.field_145991_k = null;
         this.field_145988_l = null;
         if(this.func_145977_a(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e)) {
            this.field_145991_k = (TileEntityChest)this.field_145850_b.func_147438_o(this.field_145851_c - 1, this.field_145848_d, this.field_145849_e);
         }

         if(this.func_145977_a(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e)) {
            this.field_145990_j = (TileEntityChest)this.field_145850_b.func_147438_o(this.field_145851_c + 1, this.field_145848_d, this.field_145849_e);
         }

         if(this.func_145977_a(this.field_145851_c, this.field_145848_d, this.field_145849_e - 1)) {
            this.field_145992_i = (TileEntityChest)this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e - 1);
         }

         if(this.func_145977_a(this.field_145851_c, this.field_145848_d, this.field_145849_e + 1)) {
            this.field_145988_l = (TileEntityChest)this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e + 1);
         }

         if(this.field_145992_i != null) {
            this.field_145992_i.func_145978_a(this, 0);
         }

         if(this.field_145988_l != null) {
            this.field_145988_l.func_145978_a(this, 2);
         }

         if(this.field_145990_j != null) {
            this.field_145990_j.func_145978_a(this, 1);
         }

         if(this.field_145991_k != null) {
            this.field_145991_k.func_145978_a(this, 3);
         }

      }
   }

   private boolean func_145977_a(int p_145977_1_, int p_145977_2_, int p_145977_3_) {
      if(this.field_145850_b == null) {
         return false;
      } else {
         Block var4 = this.field_145850_b.func_147439_a(p_145977_1_, p_145977_2_, p_145977_3_);
         return var4 instanceof BlockChest && ((BlockChest)var4).field_149956_a == this.func_145980_j();
      }
   }

   public void func_145845_h() {
      super.func_145845_h();
      this.func_145979_i();
      ++this.field_145983_q;
      float var1;
      if(!this.field_145850_b.field_72995_K && this.field_145987_o != 0 && (this.field_145983_q + this.field_145851_c + this.field_145848_d + this.field_145849_e) % 200 == 0) {
         this.field_145987_o = 0;
         var1 = 5.0F;
         List var2 = this.field_145850_b.func_72872_a(EntityPlayer.class, AxisAlignedBB.func_72330_a((double)((float)this.field_145851_c - var1), (double)((float)this.field_145848_d - var1), (double)((float)this.field_145849_e - var1), (double)((float)(this.field_145851_c + 1) + var1), (double)((float)(this.field_145848_d + 1) + var1), (double)((float)(this.field_145849_e + 1) + var1)));
         Iterator var3 = var2.iterator();

         while(var3.hasNext()) {
            EntityPlayer var4 = (EntityPlayer)var3.next();
            if(var4.field_71070_bA instanceof ContainerChest) {
               IInventory var5 = ((ContainerChest)var4.field_71070_bA).func_85151_d();
               if(var5 == this || var5 instanceof InventoryLargeChest && ((InventoryLargeChest)var5).func_90010_a(this)) {
                  ++this.field_145987_o;
               }
            }
         }
      }

      this.field_145986_n = this.field_145989_m;
      var1 = 0.1F;
      double var11;
      if(this.field_145987_o > 0 && this.field_145989_m == 0.0F && this.field_145992_i == null && this.field_145991_k == null) {
         double var8 = (double)this.field_145851_c + 0.5D;
         var11 = (double)this.field_145849_e + 0.5D;
         if(this.field_145988_l != null) {
            var11 += 0.5D;
         }

         if(this.field_145990_j != null) {
            var8 += 0.5D;
         }

         this.field_145850_b.func_72908_a(var8, (double)this.field_145848_d + 0.5D, var11, "random.chestopen", 0.5F, this.field_145850_b.field_73012_v.nextFloat() * 0.1F + 0.9F);
      }

      if(this.field_145987_o == 0 && this.field_145989_m > 0.0F || this.field_145987_o > 0 && this.field_145989_m < 1.0F) {
         float var9 = this.field_145989_m;
         if(this.field_145987_o > 0) {
            this.field_145989_m += var1;
         } else {
            this.field_145989_m -= var1;
         }

         if(this.field_145989_m > 1.0F) {
            this.field_145989_m = 1.0F;
         }

         float var10 = 0.5F;
         if(this.field_145989_m < var10 && var9 >= var10 && this.field_145992_i == null && this.field_145991_k == null) {
            var11 = (double)this.field_145851_c + 0.5D;
            double var6 = (double)this.field_145849_e + 0.5D;
            if(this.field_145988_l != null) {
               var6 += 0.5D;
            }

            if(this.field_145990_j != null) {
               var11 += 0.5D;
            }

            this.field_145850_b.func_72908_a(var11, (double)this.field_145848_d + 0.5D, var6, "random.chestclosed", 0.5F, this.field_145850_b.field_73012_v.nextFloat() * 0.1F + 0.9F);
         }

         if(this.field_145989_m < 0.0F) {
            this.field_145989_m = 0.0F;
         }
      }

   }

   public boolean func_145842_c(int p_145842_1_, int p_145842_2_) {
      if(p_145842_1_ == 1) {
         this.field_145987_o = p_145842_2_;
         return true;
      } else {
         return super.func_145842_c(p_145842_1_, p_145842_2_);
      }
   }

   public void func_70295_k_() {
      if(this.field_145987_o < 0) {
         this.field_145987_o = 0;
      }

      ++this.field_145987_o;
      this.field_145850_b.func_147452_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, this.func_145838_q(), 1, this.field_145987_o);
      this.field_145850_b.func_147459_d(this.field_145851_c, this.field_145848_d, this.field_145849_e, this.func_145838_q());
      this.field_145850_b.func_147459_d(this.field_145851_c, this.field_145848_d - 1, this.field_145849_e, this.func_145838_q());
   }

   public void func_70305_f() {
      if(this.func_145838_q() instanceof BlockChest) {
         --this.field_145987_o;
         this.field_145850_b.func_147452_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, this.func_145838_q(), 1, this.field_145987_o);
         this.field_145850_b.func_147459_d(this.field_145851_c, this.field_145848_d, this.field_145849_e, this.func_145838_q());
         this.field_145850_b.func_147459_d(this.field_145851_c, this.field_145848_d - 1, this.field_145849_e, this.func_145838_q());
      }

   }

   public boolean func_94041_b(int p_94041_1_, ItemStack p_94041_2_) {
      return true;
   }

   public void func_145843_s() {
      super.func_145843_s();
      this.func_145836_u();
      this.func_145979_i();
   }

   public int func_145980_j() {
      if(this.field_145982_r == -1) {
         if(this.field_145850_b == null || !(this.func_145838_q() instanceof BlockChest)) {
            return 0;
         }

         this.field_145982_r = ((BlockChest)this.func_145838_q()).field_149956_a;
      }

      return this.field_145982_r;
   }
}
