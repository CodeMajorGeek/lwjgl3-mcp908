package net.minecraft.block;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockChest extends BlockContainer {

   private final Random field_149955_b = new Random();
   public final int field_149956_a;
   private static final String __OBFID = "CL_00000214";


   protected BlockChest(int p_i45397_1_) {
      super(Material.field_151575_d);
      this.field_149956_a = p_i45397_1_;
      this.func_149647_a(CreativeTabs.field_78031_c);
      this.func_149676_a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public int func_149645_b() {
      return 22;
   }

   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
      if(p_149719_1_.func_147439_a(p_149719_2_, p_149719_3_, p_149719_4_ - 1) == this) {
         this.func_149676_a(0.0625F, 0.0F, 0.0F, 0.9375F, 0.875F, 0.9375F);
      } else if(p_149719_1_.func_147439_a(p_149719_2_, p_149719_3_, p_149719_4_ + 1) == this) {
         this.func_149676_a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 1.0F);
      } else if(p_149719_1_.func_147439_a(p_149719_2_ - 1, p_149719_3_, p_149719_4_) == this) {
         this.func_149676_a(0.0F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
      } else if(p_149719_1_.func_147439_a(p_149719_2_ + 1, p_149719_3_, p_149719_4_) == this) {
         this.func_149676_a(0.0625F, 0.0F, 0.0625F, 1.0F, 0.875F, 0.9375F);
      } else {
         this.func_149676_a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
      }

   }

   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
      super.func_149726_b(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
      this.func_149954_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
      Block var5 = p_149726_1_.func_147439_a(p_149726_2_, p_149726_3_, p_149726_4_ - 1);
      Block var6 = p_149726_1_.func_147439_a(p_149726_2_, p_149726_3_, p_149726_4_ + 1);
      Block var7 = p_149726_1_.func_147439_a(p_149726_2_ - 1, p_149726_3_, p_149726_4_);
      Block var8 = p_149726_1_.func_147439_a(p_149726_2_ + 1, p_149726_3_, p_149726_4_);
      if(var5 == this) {
         this.func_149954_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_ - 1);
      }

      if(var6 == this) {
         this.func_149954_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_ + 1);
      }

      if(var7 == this) {
         this.func_149954_e(p_149726_1_, p_149726_2_ - 1, p_149726_3_, p_149726_4_);
      }

      if(var8 == this) {
         this.func_149954_e(p_149726_1_, p_149726_2_ + 1, p_149726_3_, p_149726_4_);
      }

   }

   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
      Block var7 = p_149689_1_.func_147439_a(p_149689_2_, p_149689_3_, p_149689_4_ - 1);
      Block var8 = p_149689_1_.func_147439_a(p_149689_2_, p_149689_3_, p_149689_4_ + 1);
      Block var9 = p_149689_1_.func_147439_a(p_149689_2_ - 1, p_149689_3_, p_149689_4_);
      Block var10 = p_149689_1_.func_147439_a(p_149689_2_ + 1, p_149689_3_, p_149689_4_);
      byte var11 = 0;
      int var12 = MathHelper.func_76128_c((double)(p_149689_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3;
      if(var12 == 0) {
         var11 = 2;
      }

      if(var12 == 1) {
         var11 = 5;
      }

      if(var12 == 2) {
         var11 = 3;
      }

      if(var12 == 3) {
         var11 = 4;
      }

      if(var7 != this && var8 != this && var9 != this && var10 != this) {
         p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, var11, 3);
      } else {
         if((var7 == this || var8 == this) && (var11 == 4 || var11 == 5)) {
            if(var7 == this) {
               p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_ - 1, var11, 3);
            } else {
               p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_ + 1, var11, 3);
            }

            p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, var11, 3);
         }

         if((var9 == this || var10 == this) && (var11 == 2 || var11 == 3)) {
            if(var9 == this) {
               p_149689_1_.func_72921_c(p_149689_2_ - 1, p_149689_3_, p_149689_4_, var11, 3);
            } else {
               p_149689_1_.func_72921_c(p_149689_2_ + 1, p_149689_3_, p_149689_4_, var11, 3);
            }

            p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, var11, 3);
         }
      }

      if(p_149689_6_.func_82837_s()) {
         ((TileEntityChest)p_149689_1_.func_147438_o(p_149689_2_, p_149689_3_, p_149689_4_)).func_145976_a(p_149689_6_.func_82833_r());
      }

   }

   public void func_149954_e(World p_149954_1_, int p_149954_2_, int p_149954_3_, int p_149954_4_) {
      if(!p_149954_1_.field_72995_K) {
         Block var5 = p_149954_1_.func_147439_a(p_149954_2_, p_149954_3_, p_149954_4_ - 1);
         Block var6 = p_149954_1_.func_147439_a(p_149954_2_, p_149954_3_, p_149954_4_ + 1);
         Block var7 = p_149954_1_.func_147439_a(p_149954_2_ - 1, p_149954_3_, p_149954_4_);
         Block var8 = p_149954_1_.func_147439_a(p_149954_2_ + 1, p_149954_3_, p_149954_4_);
         boolean var9 = true;
         int var10;
         Block var11;
         int var12;
         Block var13;
         boolean var14;
         byte var15;
         int var16;
         if(var5 != this && var6 != this) {
            if(var7 != this && var8 != this) {
               var15 = 3;
               if(var5.func_149730_j() && !var6.func_149730_j()) {
                  var15 = 3;
               }

               if(var6.func_149730_j() && !var5.func_149730_j()) {
                  var15 = 2;
               }

               if(var7.func_149730_j() && !var8.func_149730_j()) {
                  var15 = 5;
               }

               if(var8.func_149730_j() && !var7.func_149730_j()) {
                  var15 = 4;
               }
            } else {
               var10 = var7 == this?p_149954_2_ - 1:p_149954_2_ + 1;
               var11 = p_149954_1_.func_147439_a(var10, p_149954_3_, p_149954_4_ - 1);
               var12 = var7 == this?p_149954_2_ - 1:p_149954_2_ + 1;
               var13 = p_149954_1_.func_147439_a(var12, p_149954_3_, p_149954_4_ + 1);
               var15 = 3;
               var14 = true;
               if(var7 == this) {
                  var16 = p_149954_1_.func_72805_g(p_149954_2_ - 1, p_149954_3_, p_149954_4_);
               } else {
                  var16 = p_149954_1_.func_72805_g(p_149954_2_ + 1, p_149954_3_, p_149954_4_);
               }

               if(var16 == 2) {
                  var15 = 2;
               }

               if((var5.func_149730_j() || var11.func_149730_j()) && !var6.func_149730_j() && !var13.func_149730_j()) {
                  var15 = 3;
               }

               if((var6.func_149730_j() || var13.func_149730_j()) && !var5.func_149730_j() && !var11.func_149730_j()) {
                  var15 = 2;
               }
            }
         } else {
            var10 = var5 == this?p_149954_4_ - 1:p_149954_4_ + 1;
            var11 = p_149954_1_.func_147439_a(p_149954_2_ - 1, p_149954_3_, var10);
            var12 = var5 == this?p_149954_4_ - 1:p_149954_4_ + 1;
            var13 = p_149954_1_.func_147439_a(p_149954_2_ + 1, p_149954_3_, var12);
            var15 = 5;
            var14 = true;
            if(var5 == this) {
               var16 = p_149954_1_.func_72805_g(p_149954_2_, p_149954_3_, p_149954_4_ - 1);
            } else {
               var16 = p_149954_1_.func_72805_g(p_149954_2_, p_149954_3_, p_149954_4_ + 1);
            }

            if(var16 == 4) {
               var15 = 4;
            }

            if((var7.func_149730_j() || var11.func_149730_j()) && !var8.func_149730_j() && !var13.func_149730_j()) {
               var15 = 5;
            }

            if((var8.func_149730_j() || var13.func_149730_j()) && !var7.func_149730_j() && !var11.func_149730_j()) {
               var15 = 4;
            }
         }

         p_149954_1_.func_72921_c(p_149954_2_, p_149954_3_, p_149954_4_, var15, 3);
      }
   }

   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
      int var5 = 0;
      if(p_149742_1_.func_147439_a(p_149742_2_ - 1, p_149742_3_, p_149742_4_) == this) {
         ++var5;
      }

      if(p_149742_1_.func_147439_a(p_149742_2_ + 1, p_149742_3_, p_149742_4_) == this) {
         ++var5;
      }

      if(p_149742_1_.func_147439_a(p_149742_2_, p_149742_3_, p_149742_4_ - 1) == this) {
         ++var5;
      }

      if(p_149742_1_.func_147439_a(p_149742_2_, p_149742_3_, p_149742_4_ + 1) == this) {
         ++var5;
      }

      return var5 > 1?false:(this.func_149952_n(p_149742_1_, p_149742_2_ - 1, p_149742_3_, p_149742_4_)?false:(this.func_149952_n(p_149742_1_, p_149742_2_ + 1, p_149742_3_, p_149742_4_)?false:(this.func_149952_n(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_ - 1)?false:!this.func_149952_n(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_ + 1))));
   }

   private boolean func_149952_n(World p_149952_1_, int p_149952_2_, int p_149952_3_, int p_149952_4_) {
      return p_149952_1_.func_147439_a(p_149952_2_, p_149952_3_, p_149952_4_) != this?false:(p_149952_1_.func_147439_a(p_149952_2_ - 1, p_149952_3_, p_149952_4_) == this?true:(p_149952_1_.func_147439_a(p_149952_2_ + 1, p_149952_3_, p_149952_4_) == this?true:(p_149952_1_.func_147439_a(p_149952_2_, p_149952_3_, p_149952_4_ - 1) == this?true:p_149952_1_.func_147439_a(p_149952_2_, p_149952_3_, p_149952_4_ + 1) == this)));
   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      super.func_149695_a(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_5_);
      TileEntityChest var6 = (TileEntityChest)p_149695_1_.func_147438_o(p_149695_2_, p_149695_3_, p_149695_4_);
      if(var6 != null) {
         var6.func_145836_u();
      }

   }

   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
      TileEntityChest var7 = (TileEntityChest)p_149749_1_.func_147438_o(p_149749_2_, p_149749_3_, p_149749_4_);
      if(var7 != null) {
         for(int var8 = 0; var8 < var7.func_70302_i_(); ++var8) {
            ItemStack var9 = var7.func_70301_a(var8);
            if(var9 != null) {
               float var10 = this.field_149955_b.nextFloat() * 0.8F + 0.1F;
               float var11 = this.field_149955_b.nextFloat() * 0.8F + 0.1F;

               EntityItem var14;
               for(float var12 = this.field_149955_b.nextFloat() * 0.8F + 0.1F; var9.field_77994_a > 0; p_149749_1_.func_72838_d(var14)) {
                  int var13 = this.field_149955_b.nextInt(21) + 10;
                  if(var13 > var9.field_77994_a) {
                     var13 = var9.field_77994_a;
                  }

                  var9.field_77994_a -= var13;
                  var14 = new EntityItem(p_149749_1_, (double)((float)p_149749_2_ + var10), (double)((float)p_149749_3_ + var11), (double)((float)p_149749_4_ + var12), new ItemStack(var9.func_77973_b(), var13, var9.func_77960_j()));
                  float var15 = 0.05F;
                  var14.field_70159_w = (double)((float)this.field_149955_b.nextGaussian() * var15);
                  var14.field_70181_x = (double)((float)this.field_149955_b.nextGaussian() * var15 + 0.2F);
                  var14.field_70179_y = (double)((float)this.field_149955_b.nextGaussian() * var15);
                  if(var9.func_77942_o()) {
                     var14.func_92059_d().func_77982_d((NBTTagCompound)var9.func_77978_p().func_74737_b());
                  }
               }
            }
         }

         p_149749_1_.func_147453_f(p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_);
      }

      super.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
   }

   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
      if(p_149727_1_.field_72995_K) {
         return true;
      } else {
         IInventory var10 = this.func_149951_m(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_);
         if(var10 != null) {
            p_149727_5_.func_71007_a(var10);
         }

         return true;
      }
   }

   public IInventory func_149951_m(World p_149951_1_, int p_149951_2_, int p_149951_3_, int p_149951_4_) {
      Object var5 = (TileEntityChest)p_149951_1_.func_147438_o(p_149951_2_, p_149951_3_, p_149951_4_);
      if(var5 == null) {
         return null;
      } else if(p_149951_1_.func_147439_a(p_149951_2_, p_149951_3_ + 1, p_149951_4_).func_149721_r()) {
         return null;
      } else if(func_149953_o(p_149951_1_, p_149951_2_, p_149951_3_, p_149951_4_)) {
         return null;
      } else if(p_149951_1_.func_147439_a(p_149951_2_ - 1, p_149951_3_, p_149951_4_) == this && (p_149951_1_.func_147439_a(p_149951_2_ - 1, p_149951_3_ + 1, p_149951_4_).func_149721_r() || func_149953_o(p_149951_1_, p_149951_2_ - 1, p_149951_3_, p_149951_4_))) {
         return null;
      } else if(p_149951_1_.func_147439_a(p_149951_2_ + 1, p_149951_3_, p_149951_4_) == this && (p_149951_1_.func_147439_a(p_149951_2_ + 1, p_149951_3_ + 1, p_149951_4_).func_149721_r() || func_149953_o(p_149951_1_, p_149951_2_ + 1, p_149951_3_, p_149951_4_))) {
         return null;
      } else if(p_149951_1_.func_147439_a(p_149951_2_, p_149951_3_, p_149951_4_ - 1) == this && (p_149951_1_.func_147439_a(p_149951_2_, p_149951_3_ + 1, p_149951_4_ - 1).func_149721_r() || func_149953_o(p_149951_1_, p_149951_2_, p_149951_3_, p_149951_4_ - 1))) {
         return null;
      } else if(p_149951_1_.func_147439_a(p_149951_2_, p_149951_3_, p_149951_4_ + 1) == this && (p_149951_1_.func_147439_a(p_149951_2_, p_149951_3_ + 1, p_149951_4_ + 1).func_149721_r() || func_149953_o(p_149951_1_, p_149951_2_, p_149951_3_, p_149951_4_ + 1))) {
         return null;
      } else {
         if(p_149951_1_.func_147439_a(p_149951_2_ - 1, p_149951_3_, p_149951_4_) == this) {
            var5 = new InventoryLargeChest("container.chestDouble", (TileEntityChest)p_149951_1_.func_147438_o(p_149951_2_ - 1, p_149951_3_, p_149951_4_), (IInventory)var5);
         }

         if(p_149951_1_.func_147439_a(p_149951_2_ + 1, p_149951_3_, p_149951_4_) == this) {
            var5 = new InventoryLargeChest("container.chestDouble", (IInventory)var5, (TileEntityChest)p_149951_1_.func_147438_o(p_149951_2_ + 1, p_149951_3_, p_149951_4_));
         }

         if(p_149951_1_.func_147439_a(p_149951_2_, p_149951_3_, p_149951_4_ - 1) == this) {
            var5 = new InventoryLargeChest("container.chestDouble", (TileEntityChest)p_149951_1_.func_147438_o(p_149951_2_, p_149951_3_, p_149951_4_ - 1), (IInventory)var5);
         }

         if(p_149951_1_.func_147439_a(p_149951_2_, p_149951_3_, p_149951_4_ + 1) == this) {
            var5 = new InventoryLargeChest("container.chestDouble", (IInventory)var5, (TileEntityChest)p_149951_1_.func_147438_o(p_149951_2_, p_149951_3_, p_149951_4_ + 1));
         }

         return (IInventory)var5;
      }
   }

   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
      TileEntityChest var3 = new TileEntityChest();
      return var3;
   }

   public boolean func_149744_f() {
      return this.field_149956_a == 1;
   }

   public int func_149709_b(IBlockAccess p_149709_1_, int p_149709_2_, int p_149709_3_, int p_149709_4_, int p_149709_5_) {
      if(!this.func_149744_f()) {
         return 0;
      } else {
         int var6 = ((TileEntityChest)p_149709_1_.func_147438_o(p_149709_2_, p_149709_3_, p_149709_4_)).field_145987_o;
         return MathHelper.func_76125_a(var6, 0, 15);
      }
   }

   public int func_149748_c(IBlockAccess p_149748_1_, int p_149748_2_, int p_149748_3_, int p_149748_4_, int p_149748_5_) {
      return p_149748_5_ == 1?this.func_149709_b(p_149748_1_, p_149748_2_, p_149748_3_, p_149748_4_, p_149748_5_):0;
   }

   private static boolean func_149953_o(World p_149953_0_, int p_149953_1_, int p_149953_2_, int p_149953_3_) {
      Iterator var4 = p_149953_0_.func_72872_a(EntityOcelot.class, AxisAlignedBB.func_72330_a((double)p_149953_1_, (double)(p_149953_2_ + 1), (double)p_149953_3_, (double)(p_149953_1_ + 1), (double)(p_149953_2_ + 2), (double)(p_149953_3_ + 1))).iterator();

      EntityOcelot var6;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         Entity var5 = (Entity)var4.next();
         var6 = (EntityOcelot)var5;
      } while(!var6.func_70906_o());

      return true;
   }

   public boolean func_149740_M() {
      return true;
   }

   public int func_149736_g(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_) {
      return Container.func_94526_b(this.func_149951_m(p_149736_1_, p_149736_2_, p_149736_3_, p_149736_4_));
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149761_L = p_149651_1_.func_94245_a("planks_oak");
   }
}
