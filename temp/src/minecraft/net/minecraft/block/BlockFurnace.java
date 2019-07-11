package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockFurnace extends BlockContainer {

   private final Random field_149933_a = new Random();
   private final boolean field_149932_b;
   private static boolean field_149934_M;
   private IIcon field_149935_N;
   private IIcon field_149936_O;
   private static final String __OBFID = "CL_00000248";


   protected BlockFurnace(boolean p_i45407_1_) {
      super(Material.field_151576_e);
      this.field_149932_b = p_i45407_1_;
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Item.func_150898_a(Blocks.field_150460_al);
   }

   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
      super.func_149726_b(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
      this.func_149930_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
   }

   private void func_149930_e(World p_149930_1_, int p_149930_2_, int p_149930_3_, int p_149930_4_) {
      if(!p_149930_1_.field_72995_K) {
         Block var5 = p_149930_1_.func_147439_a(p_149930_2_, p_149930_3_, p_149930_4_ - 1);
         Block var6 = p_149930_1_.func_147439_a(p_149930_2_, p_149930_3_, p_149930_4_ + 1);
         Block var7 = p_149930_1_.func_147439_a(p_149930_2_ - 1, p_149930_3_, p_149930_4_);
         Block var8 = p_149930_1_.func_147439_a(p_149930_2_ + 1, p_149930_3_, p_149930_4_);
         byte var9 = 3;
         if(var5.func_149730_j() && !var6.func_149730_j()) {
            var9 = 3;
         }

         if(var6.func_149730_j() && !var5.func_149730_j()) {
            var9 = 2;
         }

         if(var7.func_149730_j() && !var8.func_149730_j()) {
            var9 = 5;
         }

         if(var8.func_149730_j() && !var7.func_149730_j()) {
            var9 = 4;
         }

         p_149930_1_.func_72921_c(p_149930_2_, p_149930_3_, p_149930_4_, var9, 2);
      }
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      return p_149691_1_ == 1?this.field_149935_N:(p_149691_1_ == 0?this.field_149935_N:(p_149691_1_ != p_149691_2_?this.field_149761_L:this.field_149936_O));
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149761_L = p_149651_1_.func_94245_a("furnace_side");
      this.field_149936_O = p_149651_1_.func_94245_a(this.field_149932_b?"furnace_front_on":"furnace_front_off");
      this.field_149935_N = p_149651_1_.func_94245_a("furnace_top");
   }

   public void func_149734_b(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
      if(this.field_149932_b) {
         int var6 = p_149734_1_.func_72805_g(p_149734_2_, p_149734_3_, p_149734_4_);
         float var7 = (float)p_149734_2_ + 0.5F;
         float var8 = (float)p_149734_3_ + 0.0F + p_149734_5_.nextFloat() * 6.0F / 16.0F;
         float var9 = (float)p_149734_4_ + 0.5F;
         float var10 = 0.52F;
         float var11 = p_149734_5_.nextFloat() * 0.6F - 0.3F;
         if(var6 == 4) {
            p_149734_1_.func_72869_a("smoke", (double)(var7 - var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
            p_149734_1_.func_72869_a("flame", (double)(var7 - var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
         } else if(var6 == 5) {
            p_149734_1_.func_72869_a("smoke", (double)(var7 + var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
            p_149734_1_.func_72869_a("flame", (double)(var7 + var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
         } else if(var6 == 2) {
            p_149734_1_.func_72869_a("smoke", (double)(var7 + var11), (double)var8, (double)(var9 - var10), 0.0D, 0.0D, 0.0D);
            p_149734_1_.func_72869_a("flame", (double)(var7 + var11), (double)var8, (double)(var9 - var10), 0.0D, 0.0D, 0.0D);
         } else if(var6 == 3) {
            p_149734_1_.func_72869_a("smoke", (double)(var7 + var11), (double)var8, (double)(var9 + var10), 0.0D, 0.0D, 0.0D);
            p_149734_1_.func_72869_a("flame", (double)(var7 + var11), (double)var8, (double)(var9 + var10), 0.0D, 0.0D, 0.0D);
         }

      }
   }

   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
      if(p_149727_1_.field_72995_K) {
         return true;
      } else {
         TileEntityFurnace var10 = (TileEntityFurnace)p_149727_1_.func_147438_o(p_149727_2_, p_149727_3_, p_149727_4_);
         if(var10 != null) {
            p_149727_5_.func_146101_a(var10);
         }

         return true;
      }
   }

   public static void func_149931_a(boolean p_149931_0_, World p_149931_1_, int p_149931_2_, int p_149931_3_, int p_149931_4_) {
      int var5 = p_149931_1_.func_72805_g(p_149931_2_, p_149931_3_, p_149931_4_);
      TileEntity var6 = p_149931_1_.func_147438_o(p_149931_2_, p_149931_3_, p_149931_4_);
      field_149934_M = true;
      if(p_149931_0_) {
         p_149931_1_.func_147449_b(p_149931_2_, p_149931_3_, p_149931_4_, Blocks.field_150470_am);
      } else {
         p_149931_1_.func_147449_b(p_149931_2_, p_149931_3_, p_149931_4_, Blocks.field_150460_al);
      }

      field_149934_M = false;
      p_149931_1_.func_72921_c(p_149931_2_, p_149931_3_, p_149931_4_, var5, 2);
      if(var6 != null) {
         var6.func_145829_t();
         p_149931_1_.func_147455_a(p_149931_2_, p_149931_3_, p_149931_4_, var6);
      }

   }

   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
      return new TileEntityFurnace();
   }

   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
      int var7 = MathHelper.func_76128_c((double)(p_149689_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3;
      if(var7 == 0) {
         p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 2, 2);
      }

      if(var7 == 1) {
         p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 5, 2);
      }

      if(var7 == 2) {
         p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 3, 2);
      }

      if(var7 == 3) {
         p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 4, 2);
      }

      if(p_149689_6_.func_82837_s()) {
         ((TileEntityFurnace)p_149689_1_.func_147438_o(p_149689_2_, p_149689_3_, p_149689_4_)).func_145951_a(p_149689_6_.func_82833_r());
      }

   }

   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
      if(!field_149934_M) {
         TileEntityFurnace var7 = (TileEntityFurnace)p_149749_1_.func_147438_o(p_149749_2_, p_149749_3_, p_149749_4_);
         if(var7 != null) {
            for(int var8 = 0; var8 < var7.func_70302_i_(); ++var8) {
               ItemStack var9 = var7.func_70301_a(var8);
               if(var9 != null) {
                  float var10 = this.field_149933_a.nextFloat() * 0.8F + 0.1F;
                  float var11 = this.field_149933_a.nextFloat() * 0.8F + 0.1F;
                  float var12 = this.field_149933_a.nextFloat() * 0.8F + 0.1F;

                  while(var9.field_77994_a > 0) {
                     int var13 = this.field_149933_a.nextInt(21) + 10;
                     if(var13 > var9.field_77994_a) {
                        var13 = var9.field_77994_a;
                     }

                     var9.field_77994_a -= var13;
                     EntityItem var14 = new EntityItem(p_149749_1_, (double)((float)p_149749_2_ + var10), (double)((float)p_149749_3_ + var11), (double)((float)p_149749_4_ + var12), new ItemStack(var9.func_77973_b(), var13, var9.func_77960_j()));
                     if(var9.func_77942_o()) {
                        var14.func_92059_d().func_77982_d((NBTTagCompound)var9.func_77978_p().func_74737_b());
                     }

                     float var15 = 0.05F;
                     var14.field_70159_w = (double)((float)this.field_149933_a.nextGaussian() * var15);
                     var14.field_70181_x = (double)((float)this.field_149933_a.nextGaussian() * var15 + 0.2F);
                     var14.field_70179_y = (double)((float)this.field_149933_a.nextGaussian() * var15);
                     p_149749_1_.func_72838_d(var14);
                  }
               }
            }

            p_149749_1_.func_147453_f(p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_);
         }
      }

      super.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
   }

   public boolean func_149740_M() {
      return true;
   }

   public int func_149736_g(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_) {
      return Container.func_94526_b((IInventory)p_149736_1_.func_147438_o(p_149736_2_, p_149736_3_, p_149736_4_));
   }

   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
      return Item.func_150898_a(Blocks.field_150460_al);
   }
}
