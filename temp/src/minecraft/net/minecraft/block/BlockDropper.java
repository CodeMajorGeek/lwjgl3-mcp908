package net.minecraft.block;

import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockSourceImpl;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityDropper;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.Facing;
import net.minecraft.world.World;

public class BlockDropper extends BlockDispenser {

   private final IBehaviorDispenseItem field_149947_P = new BehaviorDefaultDispenseItem();
   private static final String __OBFID = "CL_00000233";


   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149761_L = p_149651_1_.func_94245_a("furnace_side");
      this.field_149944_M = p_149651_1_.func_94245_a("furnace_top");
      this.field_149945_N = p_149651_1_.func_94245_a(this.func_149641_N() + "_front_horizontal");
      this.field_149946_O = p_149651_1_.func_94245_a(this.func_149641_N() + "_front_vertical");
   }

   protected IBehaviorDispenseItem func_149940_a(ItemStack p_149940_1_) {
      return this.field_149947_P;
   }

   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
      return new TileEntityDropper();
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
            int var9 = p_149941_1_.func_72805_g(p_149941_2_, p_149941_3_, p_149941_4_) & 7;
            IInventory var10 = TileEntityHopper.func_145893_b(p_149941_1_, (double)(p_149941_2_ + Facing.field_71586_b[var9]), (double)(p_149941_3_ + Facing.field_71587_c[var9]), (double)(p_149941_4_ + Facing.field_71585_d[var9]));
            ItemStack var11;
            if(var10 != null) {
               var11 = TileEntityHopper.func_145889_a(var10, var8.func_77946_l().func_77979_a(1), Facing.field_71588_a[var9]);
               if(var11 == null) {
                  var11 = var8.func_77946_l();
                  if(--var11.field_77994_a == 0) {
                     var11 = null;
                  }
               } else {
                  var11 = var8.func_77946_l();
               }
            } else {
               var11 = this.field_149947_P.func_82482_a(var5, var8);
               if(var11 != null && var11.field_77994_a == 0) {
                  var11 = null;
               }
            }

            var6.func_70299_a(var7, var11);
         }

      }
   }
}
