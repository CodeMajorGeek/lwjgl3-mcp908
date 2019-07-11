package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockCactus extends Block {

   private IIcon field_150041_a;
   private IIcon field_150040_b;
   private static final String __OBFID = "CL_00000210";


   protected BlockCactus() {
      super(Material.field_151570_A);
      this.func_149675_a(true);
      this.func_149647_a(CreativeTabs.field_78031_c);
   }

   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      if(p_149674_1_.func_147437_c(p_149674_2_, p_149674_3_ + 1, p_149674_4_)) {
         int var6;
         for(var6 = 1; p_149674_1_.func_147439_a(p_149674_2_, p_149674_3_ - var6, p_149674_4_) == this; ++var6) {
            ;
         }

         if(var6 < 3) {
            int var7 = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_);
            if(var7 == 15) {
               p_149674_1_.func_147449_b(p_149674_2_, p_149674_3_ + 1, p_149674_4_, this);
               p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, 0, 4);
               this.func_149695_a(p_149674_1_, p_149674_2_, p_149674_3_ + 1, p_149674_4_, this);
            } else {
               p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, var7 + 1, 4);
            }
         }
      }

   }

   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
      float var5 = 0.0625F;
      return AxisAlignedBB.func_72330_a((double)((float)p_149668_2_ + var5), (double)p_149668_3_, (double)((float)p_149668_4_ + var5), (double)((float)(p_149668_2_ + 1) - var5), (double)((float)(p_149668_3_ + 1) - var5), (double)((float)(p_149668_4_ + 1) - var5));
   }

   public AxisAlignedBB func_149633_g(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_) {
      float var5 = 0.0625F;
      return AxisAlignedBB.func_72330_a((double)((float)p_149633_2_ + var5), (double)p_149633_3_, (double)((float)p_149633_4_ + var5), (double)((float)(p_149633_2_ + 1) - var5), (double)(p_149633_3_ + 1), (double)((float)(p_149633_4_ + 1) - var5));
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      return p_149691_1_ == 1?this.field_150041_a:(p_149691_1_ == 0?this.field_150040_b:this.field_149761_L);
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149662_c() {
      return false;
   }

   public int func_149645_b() {
      return 13;
   }

   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
      return !super.func_149742_c(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_)?false:this.func_149718_j(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_);
   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      if(!this.func_149718_j(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_)) {
         p_149695_1_.func_147480_a(p_149695_2_, p_149695_3_, p_149695_4_, true);
      }

   }

   public boolean func_149718_j(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
      if(p_149718_1_.func_147439_a(p_149718_2_ - 1, p_149718_3_, p_149718_4_).func_149688_o().func_76220_a()) {
         return false;
      } else if(p_149718_1_.func_147439_a(p_149718_2_ + 1, p_149718_3_, p_149718_4_).func_149688_o().func_76220_a()) {
         return false;
      } else if(p_149718_1_.func_147439_a(p_149718_2_, p_149718_3_, p_149718_4_ - 1).func_149688_o().func_76220_a()) {
         return false;
      } else if(p_149718_1_.func_147439_a(p_149718_2_, p_149718_3_, p_149718_4_ + 1).func_149688_o().func_76220_a()) {
         return false;
      } else {
         Block var5 = p_149718_1_.func_147439_a(p_149718_2_, p_149718_3_ - 1, p_149718_4_);
         return var5 == Blocks.field_150434_aF || var5 == Blocks.field_150354_m;
      }
   }

   public void func_149670_a(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_) {
      p_149670_5_.func_70097_a(DamageSource.field_76367_g, 1.0F);
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149761_L = p_149651_1_.func_94245_a(this.func_149641_N() + "_side");
      this.field_150041_a = p_149651_1_.func_94245_a(this.func_149641_N() + "_top");
      this.field_150040_b = p_149651_1_.func_94245_a(this.func_149641_N() + "_bottom");
   }
}
