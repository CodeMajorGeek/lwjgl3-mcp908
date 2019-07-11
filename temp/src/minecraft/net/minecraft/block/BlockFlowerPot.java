package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraft.world.World;

public class BlockFlowerPot extends BlockContainer {

   private static final String __OBFID = "CL_00000247";


   public BlockFlowerPot() {
      super(Material.field_151594_q);
      this.func_149683_g();
   }

   public void func_149683_g() {
      float var1 = 0.375F;
      float var2 = var1 / 2.0F;
      this.func_149676_a(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, var1, 0.5F + var2);
   }

   public boolean func_149662_c() {
      return false;
   }

   public int func_149645_b() {
      return 33;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
      ItemStack var10 = p_149727_5_.field_71071_by.func_70448_g();
      if(var10 != null && var10.func_77973_b() instanceof ItemBlock) {
         TileEntityFlowerPot var11 = this.func_149929_e(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_);
         if(var11 != null) {
            if(var11.func_145965_a() != null) {
               return false;
            } else {
               Block var12 = Block.func_149634_a(var10.func_77973_b());
               if(!this.func_149928_a(var12, var10.func_77960_j())) {
                  return false;
               } else {
                  var11.func_145964_a(var10.func_77973_b(), var10.func_77960_j());
                  var11.func_70296_d();
                  if(!p_149727_1_.func_72921_c(p_149727_2_, p_149727_3_, p_149727_4_, var10.func_77960_j(), 2)) {
                     p_149727_1_.func_147471_g(p_149727_2_, p_149727_3_, p_149727_4_);
                  }

                  if(!p_149727_5_.field_71075_bZ.field_75098_d && --var10.field_77994_a <= 0) {
                     p_149727_5_.field_71071_by.func_70299_a(p_149727_5_.field_71071_by.field_70461_c, (ItemStack)null);
                  }

                  return true;
               }
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private boolean func_149928_a(Block p_149928_1_, int p_149928_2_) {
      return p_149928_1_ != Blocks.field_150327_N && p_149928_1_ != Blocks.field_150328_O && p_149928_1_ != Blocks.field_150434_aF && p_149928_1_ != Blocks.field_150338_P && p_149928_1_ != Blocks.field_150337_Q && p_149928_1_ != Blocks.field_150345_g && p_149928_1_ != Blocks.field_150330_I?p_149928_1_ == Blocks.field_150329_H && p_149928_2_ == 2:true;
   }

   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
      TileEntityFlowerPot var5 = this.func_149929_e(p_149694_1_, p_149694_2_, p_149694_3_, p_149694_4_);
      return var5 != null && var5.func_145965_a() != null?var5.func_145965_a():Items.field_151162_bE;
   }

   public int func_149643_k(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_) {
      TileEntityFlowerPot var5 = this.func_149929_e(p_149643_1_, p_149643_2_, p_149643_3_, p_149643_4_);
      return var5 != null && var5.func_145965_a() != null?var5.func_145966_b():0;
   }

   public boolean func_149648_K() {
      return true;
   }

   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
      return super.func_149742_c(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_) && World.func_147466_a(p_149742_1_, p_149742_2_, p_149742_3_ - 1, p_149742_4_);
   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      if(!World.func_147466_a(p_149695_1_, p_149695_2_, p_149695_3_ - 1, p_149695_4_)) {
         this.func_149697_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_), 0);
         p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
      }

   }

   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
      TileEntityFlowerPot var7 = this.func_149929_e(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_);
      if(var7 != null && var7.func_145965_a() != null) {
         this.func_149642_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, new ItemStack(var7.func_145965_a(), 1, var7.func_145966_b()));
      }

      super.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
   }

   public void func_149681_a(World p_149681_1_, int p_149681_2_, int p_149681_3_, int p_149681_4_, int p_149681_5_, EntityPlayer p_149681_6_) {
      super.func_149681_a(p_149681_1_, p_149681_2_, p_149681_3_, p_149681_4_, p_149681_5_, p_149681_6_);
      if(p_149681_6_.field_71075_bZ.field_75098_d) {
         TileEntityFlowerPot var7 = this.func_149929_e(p_149681_1_, p_149681_2_, p_149681_3_, p_149681_4_);
         if(var7 != null) {
            var7.func_145964_a(Item.func_150899_d(0), 0);
         }
      }

   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Items.field_151162_bE;
   }

   private TileEntityFlowerPot func_149929_e(World p_149929_1_, int p_149929_2_, int p_149929_3_, int p_149929_4_) {
      TileEntity var5 = p_149929_1_.func_147438_o(p_149929_2_, p_149929_3_, p_149929_4_);
      return var5 != null && var5 instanceof TileEntityFlowerPot?(TileEntityFlowerPot)var5:null;
   }

   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
      Object var3 = null;
      byte var4 = 0;
      switch(p_149915_2_) {
      case 1:
         var3 = Blocks.field_150328_O;
         var4 = 0;
         break;
      case 2:
         var3 = Blocks.field_150327_N;
         break;
      case 3:
         var3 = Blocks.field_150345_g;
         var4 = 0;
         break;
      case 4:
         var3 = Blocks.field_150345_g;
         var4 = 1;
         break;
      case 5:
         var3 = Blocks.field_150345_g;
         var4 = 2;
         break;
      case 6:
         var3 = Blocks.field_150345_g;
         var4 = 3;
         break;
      case 7:
         var3 = Blocks.field_150337_Q;
         break;
      case 8:
         var3 = Blocks.field_150338_P;
         break;
      case 9:
         var3 = Blocks.field_150434_aF;
         break;
      case 10:
         var3 = Blocks.field_150330_I;
         break;
      case 11:
         var3 = Blocks.field_150329_H;
         var4 = 2;
         break;
      case 12:
         var3 = Blocks.field_150345_g;
         var4 = 4;
         break;
      case 13:
         var3 = Blocks.field_150345_g;
         var4 = 5;
      }

      return new TileEntityFlowerPot(Item.func_150898_a((Block)var3), var4);
   }
}
