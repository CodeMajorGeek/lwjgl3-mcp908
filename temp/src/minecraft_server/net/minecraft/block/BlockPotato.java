package net.minecraft.block;

import net.minecraft.block.BlockCrops;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockPotato extends BlockCrops {

   private static final String __OBFID = "CL_00000286";


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
}
