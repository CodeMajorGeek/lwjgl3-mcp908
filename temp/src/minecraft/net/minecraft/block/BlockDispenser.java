package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockSourceImpl;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.PositionImpl;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IIcon;
import net.minecraft.util.IRegistry;
import net.minecraft.util.RegistryDefaulted;
import net.minecraft.world.World;

public class BlockDispenser extends BlockContainer {

   public static final IRegistry field_149943_a = new RegistryDefaulted(new BehaviorDefaultDispenseItem());
   protected Random field_149942_b = new Random();
   protected IIcon field_149944_M;
   protected IIcon field_149945_N;
   protected IIcon field_149946_O;
   private static final String __OBFID = "CL_00000229";


   protected BlockDispenser() {
      super(Material.field_151576_e);
      this.func_149647_a(CreativeTabs.field_78028_d);
   }

   public int func_149738_a(World p_149738_1_) {
      return 4;
   }

   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
      super.func_149726_b(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
      this.func_149938_m(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
   }

   private void func_149938_m(World p_149938_1_, int p_149938_2_, int p_149938_3_, int p_149938_4_) {
      if(!p_149938_1_.field_72995_K) {
         Block var5 = p_149938_1_.func_147439_a(p_149938_2_, p_149938_3_, p_149938_4_ - 1);
         Block var6 = p_149938_1_.func_147439_a(p_149938_2_, p_149938_3_, p_149938_4_ + 1);
         Block var7 = p_149938_1_.func_147439_a(p_149938_2_ - 1, p_149938_3_, p_149938_4_);
         Block var8 = p_149938_1_.func_147439_a(p_149938_2_ + 1, p_149938_3_, p_149938_4_);
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

         p_149938_1_.func_72921_c(p_149938_2_, p_149938_3_, p_149938_4_, var9, 2);
      }
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      int var3 = p_149691_2_ & 7;
      return p_149691_1_ == var3?(var3 != 1 && var3 != 0?this.field_149945_N:this.field_149946_O):(var3 != 1 && var3 != 0?(p_149691_1_ != 1 && p_149691_1_ != 0?this.field_149761_L:this.field_149944_M):this.field_149944_M);
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149761_L = p_149651_1_.func_94245_a("furnace_side");
      this.field_149944_M = p_149651_1_.func_94245_a("furnace_top");
      this.field_149945_N = p_149651_1_.func_94245_a(this.func_149641_N() + "_front_horizontal");
      this.field_149946_O = p_149651_1_.func_94245_a(this.func_149641_N() + "_front_vertical");
   }

   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
      if(p_149727_1_.field_72995_K) {
         return true;
      } else {
         TileEntityDispenser var10 = (TileEntityDispenser)p_149727_1_.func_147438_o(p_149727_2_, p_149727_3_, p_149727_4_);
         if(var10 != null) {
            p_149727_5_.func_146102_a(var10);
         }

         return true;
      }
   }

   protected void func_149941_e(World p_149941_1_, int p_149941_2_, int p_149941_3_, int p_149941_4_) {
      BlockSourceImpl var5 = new BlockSourceImpl(p_149941_1_, p_149941_2_, p_149941_3_, p_149941_4_);
      TileEntityDispenser var6 = (TileEntityDispenser)var5.func_150835_j();
      if(var6 != null) {
         int var7 = var6.func_146017_i();
         if(var7 < 0) {
            p_149941_1_.func_72926_e(1001, p_149941_2_, p_149941_3_, p_149941_4_, 0);
         } else {
            ItemStack var8 = var6.func_70301_a(var7);
            IBehaviorDispenseItem var9 = this.func_149940_a(var8);
            if(var9 != IBehaviorDispenseItem.field_82483_a) {
               ItemStack var10 = var9.func_82482_a(var5, var8);
               var6.func_70299_a(var7, var10.field_77994_a == 0?null:var10);
            }
         }

      }
   }

   protected IBehaviorDispenseItem func_149940_a(ItemStack p_149940_1_) {
      return (IBehaviorDispenseItem)field_149943_a.func_82594_a(p_149940_1_.func_77973_b());
   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      boolean var6 = p_149695_1_.func_72864_z(p_149695_2_, p_149695_3_, p_149695_4_) || p_149695_1_.func_72864_z(p_149695_2_, p_149695_3_ + 1, p_149695_4_);
      int var7 = p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_);
      boolean var8 = (var7 & 8) != 0;
      if(var6 && !var8) {
         p_149695_1_.func_147464_a(p_149695_2_, p_149695_3_, p_149695_4_, this, this.func_149738_a(p_149695_1_));
         p_149695_1_.func_72921_c(p_149695_2_, p_149695_3_, p_149695_4_, var7 | 8, 4);
      } else if(!var6 && var8) {
         p_149695_1_.func_72921_c(p_149695_2_, p_149695_3_, p_149695_4_, var7 & -9, 4);
      }

   }

   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      if(!p_149674_1_.field_72995_K) {
         this.func_149941_e(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);
      }

   }

   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
      return new TileEntityDispenser();
   }

   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
      int var7 = BlockPistonBase.func_150071_a(p_149689_1_, p_149689_2_, p_149689_3_, p_149689_4_, p_149689_5_);
      p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, var7, 2);
      if(p_149689_6_.func_82837_s()) {
         ((TileEntityDispenser)p_149689_1_.func_147438_o(p_149689_2_, p_149689_3_, p_149689_4_)).func_146018_a(p_149689_6_.func_82833_r());
      }

   }

   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
      TileEntityDispenser var7 = (TileEntityDispenser)p_149749_1_.func_147438_o(p_149749_2_, p_149749_3_, p_149749_4_);
      if(var7 != null) {
         for(int var8 = 0; var8 < var7.func_70302_i_(); ++var8) {
            ItemStack var9 = var7.func_70301_a(var8);
            if(var9 != null) {
               float var10 = this.field_149942_b.nextFloat() * 0.8F + 0.1F;
               float var11 = this.field_149942_b.nextFloat() * 0.8F + 0.1F;
               float var12 = this.field_149942_b.nextFloat() * 0.8F + 0.1F;

               while(var9.field_77994_a > 0) {
                  int var13 = this.field_149942_b.nextInt(21) + 10;
                  if(var13 > var9.field_77994_a) {
                     var13 = var9.field_77994_a;
                  }

                  var9.field_77994_a -= var13;
                  EntityItem var14 = new EntityItem(p_149749_1_, (double)((float)p_149749_2_ + var10), (double)((float)p_149749_3_ + var11), (double)((float)p_149749_4_ + var12), new ItemStack(var9.func_77973_b(), var13, var9.func_77960_j()));
                  if(var9.func_77942_o()) {
                     var14.func_92059_d().func_77982_d((NBTTagCompound)var9.func_77978_p().func_74737_b());
                  }

                  float var15 = 0.05F;
                  var14.field_70159_w = (double)((float)this.field_149942_b.nextGaussian() * var15);
                  var14.field_70181_x = (double)((float)this.field_149942_b.nextGaussian() * var15 + 0.2F);
                  var14.field_70179_y = (double)((float)this.field_149942_b.nextGaussian() * var15);
                  p_149749_1_.func_72838_d(var14);
               }
            }
         }

         p_149749_1_.func_147453_f(p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_);
      }

      super.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
   }

   public static IPosition func_149939_a(IBlockSource p_149939_0_) {
      EnumFacing var1 = func_149937_b(p_149939_0_.func_82620_h());
      double var2 = p_149939_0_.func_82615_a() + 0.7D * (double)var1.func_82601_c();
      double var4 = p_149939_0_.func_82617_b() + 0.7D * (double)var1.func_96559_d();
      double var6 = p_149939_0_.func_82616_c() + 0.7D * (double)var1.func_82599_e();
      return new PositionImpl(var2, var4, var6);
   }

   public static EnumFacing func_149937_b(int p_149937_0_) {
      return EnumFacing.func_82600_a(p_149937_0_ & 7);
   }

   public boolean func_149740_M() {
      return true;
   }

   public int func_149736_g(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_) {
      return Container.func_94526_b((IInventory)p_149736_1_.func_147438_o(p_149736_2_, p_149736_3_, p_149736_4_));
   }

}
