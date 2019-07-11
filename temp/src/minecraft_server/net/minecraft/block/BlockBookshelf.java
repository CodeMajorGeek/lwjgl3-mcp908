package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockBookshelf extends Block {

   private static final String __OBFID = "CL_00000206";


   public BlockBookshelf() {
      super(Material.field_151575_d);
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   public int func_149745_a(Random p_149745_1_) {
      return 3;
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Items.field_151122_aG;
   }
}
