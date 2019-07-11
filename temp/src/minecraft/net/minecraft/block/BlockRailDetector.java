package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockRailBase;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityMinecartCommandBlock;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRailDetector extends BlockRailBase {

   private IIcon[] field_150055_b;
   private static final String __OBFID = "CL_00000225";


   public BlockRailDetector() {
      super(true);
      this.func_149675_a(true);
   }

   public int func_149738_a(World p_149738_1_) {
      return 20;
   }

   public boolean func_149744_f() {
      return true;
   }

   public void func_149670_a(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_) {
      if(!p_149670_1_.field_72995_K) {
         int var6 = p_149670_1_.func_72805_g(p_149670_2_, p_149670_3_, p_149670_4_);
         if((var6 & 8) == 0) {
            this.func_150054_a(p_149670_1_, p_149670_2_, p_149670_3_, p_149670_4_, var6);
         }
      }
   }

   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      if(!p_149674_1_.field_72995_K) {
         int var6 = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_);
         if((var6 & 8) != 0) {
            this.func_150054_a(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, var6);
         }
      }
   }

   public int func_149709_b(IBlockAccess p_149709_1_, int p_149709_2_, int p_149709_3_, int p_149709_4_, int p_149709_5_) {
      return (p_149709_1_.func_72805_g(p_149709_2_, p_149709_3_, p_149709_4_) & 8) != 0?15:0;
   }

   public int func_149748_c(IBlockAccess p_149748_1_, int p_149748_2_, int p_149748_3_, int p_149748_4_, int p_149748_5_) {
      return (p_149748_1_.func_72805_g(p_149748_2_, p_149748_3_, p_149748_4_) & 8) == 0?0:(p_149748_5_ == 1?15:0);
   }

   private void func_150054_a(World p_150054_1_, int p_150054_2_, int p_150054_3_, int p_150054_4_, int p_150054_5_) {
      boolean var6 = (p_150054_5_ & 8) != 0;
      boolean var7 = false;
      float var8 = 0.125F;
      List var9 = p_150054_1_.func_72872_a(EntityMinecart.class, AxisAlignedBB.func_72330_a((double)((float)p_150054_2_ + var8), (double)p_150054_3_, (double)((float)p_150054_4_ + var8), (double)((float)(p_150054_2_ + 1) - var8), (double)((float)(p_150054_3_ + 1) - var8), (double)((float)(p_150054_4_ + 1) - var8)));
      if(!var9.isEmpty()) {
         var7 = true;
      }

      if(var7 && !var6) {
         p_150054_1_.func_72921_c(p_150054_2_, p_150054_3_, p_150054_4_, p_150054_5_ | 8, 3);
         p_150054_1_.func_147459_d(p_150054_2_, p_150054_3_, p_150054_4_, this);
         p_150054_1_.func_147459_d(p_150054_2_, p_150054_3_ - 1, p_150054_4_, this);
         p_150054_1_.func_147458_c(p_150054_2_, p_150054_3_, p_150054_4_, p_150054_2_, p_150054_3_, p_150054_4_);
      }

      if(!var7 && var6) {
         p_150054_1_.func_72921_c(p_150054_2_, p_150054_3_, p_150054_4_, p_150054_5_ & 7, 3);
         p_150054_1_.func_147459_d(p_150054_2_, p_150054_3_, p_150054_4_, this);
         p_150054_1_.func_147459_d(p_150054_2_, p_150054_3_ - 1, p_150054_4_, this);
         p_150054_1_.func_147458_c(p_150054_2_, p_150054_3_, p_150054_4_, p_150054_2_, p_150054_3_, p_150054_4_);
      }

      if(var7) {
         p_150054_1_.func_147464_a(p_150054_2_, p_150054_3_, p_150054_4_, this, this.func_149738_a(p_150054_1_));
      }

      p_150054_1_.func_147453_f(p_150054_2_, p_150054_3_, p_150054_4_, this);
   }

   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
      super.func_149726_b(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
      this.func_150054_a(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_, p_149726_1_.func_72805_g(p_149726_2_, p_149726_3_, p_149726_4_));
   }

   public boolean func_149740_M() {
      return true;
   }

   public int func_149736_g(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_) {
      if((p_149736_1_.func_72805_g(p_149736_2_, p_149736_3_, p_149736_4_) & 8) > 0) {
         float var6 = 0.125F;
         List var7 = p_149736_1_.func_72872_a(EntityMinecartCommandBlock.class, AxisAlignedBB.func_72330_a((double)((float)p_149736_2_ + var6), (double)p_149736_3_, (double)((float)p_149736_4_ + var6), (double)((float)(p_149736_2_ + 1) - var6), (double)((float)(p_149736_3_ + 1) - var6), (double)((float)(p_149736_4_ + 1) - var6)));
         if(var7.size() > 0) {
            return ((EntityMinecartCommandBlock)var7.get(0)).func_145822_e().func_145760_g();
         }

         List var8 = p_149736_1_.func_82733_a(EntityMinecart.class, AxisAlignedBB.func_72330_a((double)((float)p_149736_2_ + var6), (double)p_149736_3_, (double)((float)p_149736_4_ + var6), (double)((float)(p_149736_2_ + 1) - var6), (double)((float)(p_149736_3_ + 1) - var6), (double)((float)(p_149736_4_ + 1) - var6)), IEntitySelector.field_96566_b);
         if(var8.size() > 0) {
            return Container.func_94526_b((IInventory)var8.get(0));
         }
      }

      return 0;
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_150055_b = new IIcon[2];
      this.field_150055_b[0] = p_149651_1_.func_94245_a(this.func_149641_N());
      this.field_150055_b[1] = p_149651_1_.func_94245_a(this.func_149641_N() + "_powered");
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      return (p_149691_2_ & 8) != 0?this.field_150055_b[1]:this.field_150055_b[0];
   }
}
