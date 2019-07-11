package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockWorkbench extends Block {

   private static final String __OBFID = "CL_00000221";


   protected BlockWorkbench() {
      super(Material.field_151575_d);
      this.func_149647_a(CreativeTabs.field_78031_c);
   }

   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
      if(p_149727_1_.field_72995_K) {
         return true;
      } else {
         p_149727_5_.func_71058_b(p_149727_2_, p_149727_3_, p_149727_4_);
         return true;
      }
   }
}
