package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityPiston;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Facing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPistonMoving extends BlockContainer {

   private static final String __OBFID = "CL_00000368";


   public BlockPistonMoving() {
      super(Material.field_76233_E);
      this.func_149711_c(-1.0F);
   }

   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
      return null;
   }

   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {}

   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
      TileEntity var7 = p_149749_1_.func_147438_o(p_149749_2_, p_149749_3_, p_149749_4_);
      if(var7 instanceof TileEntityPiston) {
         ((TileEntityPiston)var7).func_145866_f();
      } else {
         super.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
      }

   }

   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
      return false;
   }

   public boolean func_149707_d(World p_149707_1_, int p_149707_2_, int p_149707_3_, int p_149707_4_, int p_149707_5_) {
      return false;
   }

   public int func_149645_b() {
      return -1;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
      if(!p_149727_1_.field_72995_K && p_149727_1_.func_147438_o(p_149727_2_, p_149727_3_, p_149727_4_) == null) {
         p_149727_1_.func_147468_f(p_149727_2_, p_149727_3_, p_149727_4_);
         return true;
      } else {
         return false;
      }
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return null;
   }

   public void func_149690_a(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
      if(!p_149690_1_.field_72995_K) {
         TileEntityPiston var8 = this.func_149963_e(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_);
         if(var8 != null) {
            var8.func_145861_a().func_149697_b(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, var8.func_145832_p(), 0);
         }
      }
   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      if(!p_149695_1_.field_72995_K) {
         p_149695_1_.func_147438_o(p_149695_2_, p_149695_3_, p_149695_4_);
      }

   }

   public static TileEntity func_149962_a(Block p_149962_0_, int p_149962_1_, int p_149962_2_, boolean p_149962_3_, boolean p_149962_4_) {
      return new TileEntityPiston(p_149962_0_, p_149962_1_, p_149962_2_, p_149962_3_, p_149962_4_);
   }

   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
      TileEntityPiston var5 = this.func_149963_e(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
      if(var5 == null) {
         return null;
      } else {
         float var6 = var5.func_145860_a(0.0F);
         if(var5.func_145868_b()) {
            var6 = 1.0F - var6;
         }

         return this.func_149964_a(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_, var5.func_145861_a(), var6, var5.func_145864_c());
      }
   }

   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
      TileEntityPiston var5 = this.func_149963_e(p_149719_1_, p_149719_2_, p_149719_3_, p_149719_4_);
      if(var5 != null) {
         Block var6 = var5.func_145861_a();
         if(var6 == this || var6.func_149688_o() == Material.field_151579_a) {
            return;
         }

         var6.func_149719_a(p_149719_1_, p_149719_2_, p_149719_3_, p_149719_4_);
         float var7 = var5.func_145860_a(0.0F);
         if(var5.func_145868_b()) {
            var7 = 1.0F - var7;
         }

         int var8 = var5.func_145864_c();
         this.field_149759_B = var6.func_149704_x() - (double)((float)Facing.field_71586_b[var8] * var7);
         this.field_149760_C = var6.func_149665_z() - (double)((float)Facing.field_71587_c[var8] * var7);
         this.field_149754_D = var6.func_149706_B() - (double)((float)Facing.field_71585_d[var8] * var7);
         this.field_149755_E = var6.func_149753_y() - (double)((float)Facing.field_71586_b[var8] * var7);
         this.field_149756_F = var6.func_149669_A() - (double)((float)Facing.field_71587_c[var8] * var7);
         this.field_149757_G = var6.func_149693_C() - (double)((float)Facing.field_71585_d[var8] * var7);
      }

   }

   public AxisAlignedBB func_149964_a(World p_149964_1_, int p_149964_2_, int p_149964_3_, int p_149964_4_, Block p_149964_5_, float p_149964_6_, int p_149964_7_) {
      if(p_149964_5_ != this && p_149964_5_.func_149688_o() != Material.field_151579_a) {
         AxisAlignedBB var8 = p_149964_5_.func_149668_a(p_149964_1_, p_149964_2_, p_149964_3_, p_149964_4_);
         if(var8 == null) {
            return null;
         } else {
            if(Facing.field_71586_b[p_149964_7_] < 0) {
               var8.field_72340_a -= (double)((float)Facing.field_71586_b[p_149964_7_] * p_149964_6_);
            } else {
               var8.field_72336_d -= (double)((float)Facing.field_71586_b[p_149964_7_] * p_149964_6_);
            }

            if(Facing.field_71587_c[p_149964_7_] < 0) {
               var8.field_72338_b -= (double)((float)Facing.field_71587_c[p_149964_7_] * p_149964_6_);
            } else {
               var8.field_72337_e -= (double)((float)Facing.field_71587_c[p_149964_7_] * p_149964_6_);
            }

            if(Facing.field_71585_d[p_149964_7_] < 0) {
               var8.field_72339_c -= (double)((float)Facing.field_71585_d[p_149964_7_] * p_149964_6_);
            } else {
               var8.field_72334_f -= (double)((float)Facing.field_71585_d[p_149964_7_] * p_149964_6_);
            }

            return var8;
         }
      } else {
         return null;
      }
   }

   private TileEntityPiston func_149963_e(IBlockAccess p_149963_1_, int p_149963_2_, int p_149963_3_, int p_149963_4_) {
      TileEntity var5 = p_149963_1_.func_147438_o(p_149963_2_, p_149963_3_, p_149963_4_);
      return var5 instanceof TileEntityPiston?(TileEntityPiston)var5:null;
   }

   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
      return Item.func_150899_d(0);
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149761_L = p_149651_1_.func_94245_a("piston_top_normal");
   }
}
