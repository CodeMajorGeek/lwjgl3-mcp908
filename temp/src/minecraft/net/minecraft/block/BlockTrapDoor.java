package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTrapDoor extends Block {

   private static final String __OBFID = "CL_00000327";


   protected BlockTrapDoor(Material p_i45434_1_) {
      super(p_i45434_1_);
      float var2 = 0.5F;
      float var3 = 1.0F;
      this.func_149676_a(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, var3, 0.5F + var2);
      this.func_149647_a(CreativeTabs.field_78028_d);
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149655_b(IBlockAccess p_149655_1_, int p_149655_2_, int p_149655_3_, int p_149655_4_) {
      return !func_150118_d(p_149655_1_.func_72805_g(p_149655_2_, p_149655_3_, p_149655_4_));
   }

   public int func_149645_b() {
      return 0;
   }

   public AxisAlignedBB func_149633_g(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_) {
      this.func_149719_a(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
      return super.func_149633_g(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
   }

   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
      this.func_149719_a(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
      return super.func_149668_a(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
   }

   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
      this.func_150117_b(p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_));
   }

   public void func_149683_g() {
      float var1 = 0.1875F;
      this.func_149676_a(0.0F, 0.5F - var1 / 2.0F, 0.0F, 1.0F, 0.5F + var1 / 2.0F, 1.0F);
   }

   public void func_150117_b(int p_150117_1_) {
      float var2 = 0.1875F;
      if((p_150117_1_ & 8) != 0) {
         this.func_149676_a(0.0F, 1.0F - var2, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
         this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, var2, 1.0F);
      }

      if(func_150118_d(p_150117_1_)) {
         if((p_150117_1_ & 3) == 0) {
            this.func_149676_a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
         }

         if((p_150117_1_ & 3) == 1) {
            this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
         }

         if((p_150117_1_ & 3) == 2) {
            this.func_149676_a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         }

         if((p_150117_1_ & 3) == 3) {
            this.func_149676_a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
         }
      }

   }

   public void func_149699_a(World p_149699_1_, int p_149699_2_, int p_149699_3_, int p_149699_4_, EntityPlayer p_149699_5_) {}

   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
      if(this.field_149764_J == Material.field_151573_f) {
         return true;
      } else {
         int var10 = p_149727_1_.func_72805_g(p_149727_2_, p_149727_3_, p_149727_4_);
         p_149727_1_.func_72921_c(p_149727_2_, p_149727_3_, p_149727_4_, var10 ^ 4, 2);
         p_149727_1_.func_72889_a(p_149727_5_, 1003, p_149727_2_, p_149727_3_, p_149727_4_, 0);
         return true;
      }
   }

   public void func_150120_a(World p_150120_1_, int p_150120_2_, int p_150120_3_, int p_150120_4_, boolean p_150120_5_) {
      int var6 = p_150120_1_.func_72805_g(p_150120_2_, p_150120_3_, p_150120_4_);
      boolean var7 = (var6 & 4) > 0;
      if(var7 != p_150120_5_) {
         p_150120_1_.func_72921_c(p_150120_2_, p_150120_3_, p_150120_4_, var6 ^ 4, 2);
         p_150120_1_.func_72889_a((EntityPlayer)null, 1003, p_150120_2_, p_150120_3_, p_150120_4_, 0);
      }
   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      if(!p_149695_1_.field_72995_K) {
         int var6 = p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_);
         int var7 = p_149695_2_;
         int var8 = p_149695_4_;
         if((var6 & 3) == 0) {
            var8 = p_149695_4_ + 1;
         }

         if((var6 & 3) == 1) {
            --var8;
         }

         if((var6 & 3) == 2) {
            var7 = p_149695_2_ + 1;
         }

         if((var6 & 3) == 3) {
            --var7;
         }

         if(!func_150119_a(p_149695_1_.func_147439_a(var7, p_149695_3_, var8))) {
            p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
            this.func_149697_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, var6, 0);
         }

         boolean var9 = p_149695_1_.func_72864_z(p_149695_2_, p_149695_3_, p_149695_4_);
         if(var9 || p_149695_5_.func_149744_f()) {
            this.func_150120_a(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, var9);
         }

      }
   }

   public MovingObjectPosition func_149731_a(World p_149731_1_, int p_149731_2_, int p_149731_3_, int p_149731_4_, Vec3 p_149731_5_, Vec3 p_149731_6_) {
      this.func_149719_a(p_149731_1_, p_149731_2_, p_149731_3_, p_149731_4_);
      return super.func_149731_a(p_149731_1_, p_149731_2_, p_149731_3_, p_149731_4_, p_149731_5_, p_149731_6_);
   }

   public int func_149660_a(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_) {
      int var10 = 0;
      if(p_149660_5_ == 2) {
         var10 = 0;
      }

      if(p_149660_5_ == 3) {
         var10 = 1;
      }

      if(p_149660_5_ == 4) {
         var10 = 2;
      }

      if(p_149660_5_ == 5) {
         var10 = 3;
      }

      if(p_149660_5_ != 1 && p_149660_5_ != 0 && p_149660_7_ > 0.5F) {
         var10 |= 8;
      }

      return var10;
   }

   public boolean func_149707_d(World p_149707_1_, int p_149707_2_, int p_149707_3_, int p_149707_4_, int p_149707_5_) {
      if(p_149707_5_ == 0) {
         return false;
      } else if(p_149707_5_ == 1) {
         return false;
      } else {
         if(p_149707_5_ == 2) {
            ++p_149707_4_;
         }

         if(p_149707_5_ == 3) {
            --p_149707_4_;
         }

         if(p_149707_5_ == 4) {
            ++p_149707_2_;
         }

         if(p_149707_5_ == 5) {
            --p_149707_2_;
         }

         return func_150119_a(p_149707_1_.func_147439_a(p_149707_2_, p_149707_3_, p_149707_4_));
      }
   }

   public static boolean func_150118_d(int p_150118_0_) {
      return (p_150118_0_ & 4) != 0;
   }

   private static boolean func_150119_a(Block p_150119_0_) {
      return p_150119_0_.field_149764_J.func_76218_k() && p_150119_0_.func_149686_d() || p_150119_0_ == Blocks.field_150426_aN || p_150119_0_ instanceof BlockSlab || p_150119_0_ instanceof BlockStairs;
   }
}
