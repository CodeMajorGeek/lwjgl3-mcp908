package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneDiode;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityComparator;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRedstoneComparator extends BlockRedstoneDiode implements ITileEntityProvider {

   private static final String __OBFID = "CL_00000220";


   public BlockRedstoneComparator(boolean p_i45399_1_) {
      super(p_i45399_1_);
      this.field_149758_A = true;
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Items.field_151132_bS;
   }

   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
      return Items.field_151132_bS;
   }

   protected int func_149901_b(int p_149901_1_) {
      return 2;
   }

   protected BlockRedstoneDiode func_149906_e() {
      return Blocks.field_150455_bV;
   }

   protected BlockRedstoneDiode func_149898_i() {
      return Blocks.field_150441_bU;
   }

   public int func_149645_b() {
      return 37;
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      boolean var3 = this.field_149914_a || (p_149691_2_ & 8) != 0;
      return p_149691_1_ == 0?(var3?Blocks.field_150429_aA.func_149733_h(p_149691_1_):Blocks.field_150437_az.func_149733_h(p_149691_1_)):(p_149691_1_ == 1?(var3?Blocks.field_150455_bV.field_149761_L:this.field_149761_L):Blocks.field_150334_T.func_149733_h(1));
   }

   protected boolean func_149905_c(int p_149905_1_) {
      return this.field_149914_a || (p_149905_1_ & 8) != 0;
   }

   protected int func_149904_f(IBlockAccess p_149904_1_, int p_149904_2_, int p_149904_3_, int p_149904_4_, int p_149904_5_) {
      return this.func_149971_e(p_149904_1_, p_149904_2_, p_149904_3_, p_149904_4_).func_145996_a();
   }

   private int func_149970_j(World p_149970_1_, int p_149970_2_, int p_149970_3_, int p_149970_4_, int p_149970_5_) {
      return !this.func_149969_d(p_149970_5_)?this.func_149903_h(p_149970_1_, p_149970_2_, p_149970_3_, p_149970_4_, p_149970_5_):Math.max(this.func_149903_h(p_149970_1_, p_149970_2_, p_149970_3_, p_149970_4_, p_149970_5_) - this.func_149902_h(p_149970_1_, p_149970_2_, p_149970_3_, p_149970_4_, p_149970_5_), 0);
   }

   public boolean func_149969_d(int p_149969_1_) {
      return (p_149969_1_ & 4) == 4;
   }

   protected boolean func_149900_a(World p_149900_1_, int p_149900_2_, int p_149900_3_, int p_149900_4_, int p_149900_5_) {
      int var6 = this.func_149903_h(p_149900_1_, p_149900_2_, p_149900_3_, p_149900_4_, p_149900_5_);
      if(var6 >= 15) {
         return true;
      } else if(var6 == 0) {
         return false;
      } else {
         int var7 = this.func_149902_h(p_149900_1_, p_149900_2_, p_149900_3_, p_149900_4_, p_149900_5_);
         return var7 == 0?true:var6 >= var7;
      }
   }

   protected int func_149903_h(World p_149903_1_, int p_149903_2_, int p_149903_3_, int p_149903_4_, int p_149903_5_) {
      int var6 = super.func_149903_h(p_149903_1_, p_149903_2_, p_149903_3_, p_149903_4_, p_149903_5_);
      int var7 = func_149895_l(p_149903_5_);
      int var8 = p_149903_2_ + Direction.field_71583_a[var7];
      int var9 = p_149903_4_ + Direction.field_71581_b[var7];
      Block var10 = p_149903_1_.func_147439_a(var8, p_149903_3_, var9);
      if(var10.func_149740_M()) {
         var6 = var10.func_149736_g(p_149903_1_, var8, p_149903_3_, var9, Direction.field_71580_e[var7]);
      } else if(var6 < 15 && var10.func_149721_r()) {
         var8 += Direction.field_71583_a[var7];
         var9 += Direction.field_71581_b[var7];
         var10 = p_149903_1_.func_147439_a(var8, p_149903_3_, var9);
         if(var10.func_149740_M()) {
            var6 = var10.func_149736_g(p_149903_1_, var8, p_149903_3_, var9, Direction.field_71580_e[var7]);
         }
      }

      return var6;
   }

   public TileEntityComparator func_149971_e(IBlockAccess p_149971_1_, int p_149971_2_, int p_149971_3_, int p_149971_4_) {
      return (TileEntityComparator)p_149971_1_.func_147438_o(p_149971_2_, p_149971_3_, p_149971_4_);
   }

   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
      int var10 = p_149727_1_.func_72805_g(p_149727_2_, p_149727_3_, p_149727_4_);
      boolean var11 = this.field_149914_a | (var10 & 8) != 0;
      boolean var12 = !this.func_149969_d(var10);
      int var13 = var12?4:0;
      var13 |= var11?8:0;
      p_149727_1_.func_72908_a((double)p_149727_2_ + 0.5D, (double)p_149727_3_ + 0.5D, (double)p_149727_4_ + 0.5D, "random.click", 0.3F, var12?0.55F:0.5F);
      p_149727_1_.func_72921_c(p_149727_2_, p_149727_3_, p_149727_4_, var13 | var10 & 3, 2);
      this.func_149972_c(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, p_149727_1_.field_73012_v);
      return true;
   }

   protected void func_149897_b(World p_149897_1_, int p_149897_2_, int p_149897_3_, int p_149897_4_, Block p_149897_5_) {
      if(!p_149897_1_.func_147477_a(p_149897_2_, p_149897_3_, p_149897_4_, this)) {
         int var6 = p_149897_1_.func_72805_g(p_149897_2_, p_149897_3_, p_149897_4_);
         int var7 = this.func_149970_j(p_149897_1_, p_149897_2_, p_149897_3_, p_149897_4_, var6);
         int var8 = this.func_149971_e(p_149897_1_, p_149897_2_, p_149897_3_, p_149897_4_).func_145996_a();
         if(var7 != var8 || this.func_149905_c(var6) != this.func_149900_a(p_149897_1_, p_149897_2_, p_149897_3_, p_149897_4_, var6)) {
            if(this.func_149912_i(p_149897_1_, p_149897_2_, p_149897_3_, p_149897_4_, var6)) {
               p_149897_1_.func_147454_a(p_149897_2_, p_149897_3_, p_149897_4_, this, this.func_149901_b(0), -1);
            } else {
               p_149897_1_.func_147454_a(p_149897_2_, p_149897_3_, p_149897_4_, this, this.func_149901_b(0), 0);
            }
         }
      }

   }

   private void func_149972_c(World p_149972_1_, int p_149972_2_, int p_149972_3_, int p_149972_4_, Random p_149972_5_) {
      int var6 = p_149972_1_.func_72805_g(p_149972_2_, p_149972_3_, p_149972_4_);
      int var7 = this.func_149970_j(p_149972_1_, p_149972_2_, p_149972_3_, p_149972_4_, var6);
      int var8 = this.func_149971_e(p_149972_1_, p_149972_2_, p_149972_3_, p_149972_4_).func_145996_a();
      this.func_149971_e(p_149972_1_, p_149972_2_, p_149972_3_, p_149972_4_).func_145995_a(var7);
      if(var8 != var7 || !this.func_149969_d(var6)) {
         boolean var9 = this.func_149900_a(p_149972_1_, p_149972_2_, p_149972_3_, p_149972_4_, var6);
         boolean var10 = this.field_149914_a || (var6 & 8) != 0;
         if(var10 && !var9) {
            p_149972_1_.func_72921_c(p_149972_2_, p_149972_3_, p_149972_4_, var6 & -9, 2);
         } else if(!var10 && var9) {
            p_149972_1_.func_72921_c(p_149972_2_, p_149972_3_, p_149972_4_, var6 | 8, 2);
         }

         this.func_149911_e(p_149972_1_, p_149972_2_, p_149972_3_, p_149972_4_);
      }

   }

   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      if(this.field_149914_a) {
         int var6 = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_);
         p_149674_1_.func_147465_d(p_149674_2_, p_149674_3_, p_149674_4_, this.func_149898_i(), var6 | 8, 4);
      }

      this.func_149972_c(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
   }

   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
      super.func_149726_b(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
      p_149726_1_.func_147455_a(p_149726_2_, p_149726_3_, p_149726_4_, this.func_149915_a(p_149726_1_, 0));
   }

   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
      super.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
      p_149749_1_.func_147475_p(p_149749_2_, p_149749_3_, p_149749_4_);
      this.func_149911_e(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_);
   }

   public boolean func_149696_a(World p_149696_1_, int p_149696_2_, int p_149696_3_, int p_149696_4_, int p_149696_5_, int p_149696_6_) {
      super.func_149696_a(p_149696_1_, p_149696_2_, p_149696_3_, p_149696_4_, p_149696_5_, p_149696_6_);
      TileEntity var7 = p_149696_1_.func_147438_o(p_149696_2_, p_149696_3_, p_149696_4_);
      return var7 != null?var7.func_145842_c(p_149696_5_, p_149696_6_):false;
   }

   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
      return new TileEntityComparator();
   }
}
