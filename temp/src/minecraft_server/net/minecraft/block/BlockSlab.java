package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockSlab extends Block {

   protected final boolean field_150004_a;
   private static final String __OBFID = "CL_00000253";


   public BlockSlab(boolean p_i45410_1_, Material p_i45410_2_) {
      super(p_i45410_2_);
      this.field_150004_a = p_i45410_1_;
      if(p_i45410_1_) {
         this.field_149787_q = true;
      } else {
         this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      }

      this.func_149713_g(255);
   }

   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
      if(this.field_150004_a) {
         this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
         boolean var5 = (p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_) & 8) != 0;
         if(var5) {
            this.func_149676_a(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
         } else {
            this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
         }
      }

   }

   public void func_149683_g() {
      if(this.field_150004_a) {
         this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
         this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      }

   }

   public void func_149743_a(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {
      this.func_149719_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_);
      super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
   }

   public boolean func_149662_c() {
      return this.field_150004_a;
   }

   public int func_149660_a(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_) {
      return this.field_150004_a?p_149660_9_:(p_149660_5_ != 0 && (p_149660_5_ == 1 || (double)p_149660_7_ <= 0.5D)?p_149660_9_:p_149660_9_ | 8);
   }

   public int func_149745_a(Random p_149745_1_) {
      return this.field_150004_a?2:1;
   }

   public int func_149692_a(int p_149692_1_) {
      return p_149692_1_ & 7;
   }

   public boolean func_149686_d() {
      return this.field_150004_a;
   }

   public abstract String func_150002_b(int var1);

   public int func_149643_k(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_) {
      return super.func_149643_k(p_149643_1_, p_149643_2_, p_149643_3_, p_149643_4_) & 7;
   }
}
