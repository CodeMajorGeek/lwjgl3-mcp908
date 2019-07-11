package net.minecraft.block;

import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockPotato extends BlockCrops {

   private IIcon[] field_149869_a;
   private static final String __OBFID = "CL_00000286";


   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      if(p_149691_2_ < 7) {
         if(p_149691_2_ == 6) {
            p_149691_2_ = 5;
         }

         return this.field_149869_a[p_149691_2_ >> 1];
      } else {
         return this.field_149869_a[3];
      }
   }

   protected Item func_149866_i() {
      return Items.field_151174_bG;
   }

   protected Item func_149865_P() {
      return Items.field_151174_bG;
   }

   public void func_149690_a(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
      super.func_149690_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_, p_149690_7_);
      if(!p_149690_1_.field_72995_K) {
         if(p_149690_5_ >= 7 && p_149690_1_.field_73012_v.nextInt(50) == 0) {
            this.func_149642_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, new ItemStack(Items.field_151170_bI));
         }

      }
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149869_a = new IIcon[4];

      for(int var2 = 0; var2 < this.field_149869_a.length; ++var2) {
         this.field_149869_a[var2] = p_149651_1_.func_94245_a(this.func_149641_N() + "_stage_" + var2);
      }

   }
}
