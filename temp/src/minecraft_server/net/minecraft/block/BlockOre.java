package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockOre extends Block {

   private static final String __OBFID = "CL_00000282";


   public BlockOre() {
      super(Material.field_151576_e);
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return this == Blocks.field_150365_q?Items.field_151044_h:(this == Blocks.field_150482_ag?Items.field_151045_i:(this == Blocks.field_150369_x?Items.field_151100_aR:(this == Blocks.field_150412_bA?Items.field_151166_bC:(this == Blocks.field_150449_bY?Items.field_151128_bU:Item.func_150898_a(this)))));
   }

   public int func_149745_a(Random p_149745_1_) {
      return this == Blocks.field_150369_x?4 + p_149745_1_.nextInt(5):1;
   }

   public int func_149679_a(int p_149679_1_, Random p_149679_2_) {
      if(p_149679_1_ > 0 && Item.func_150898_a(this) != this.func_149650_a(0, p_149679_2_, p_149679_1_)) {
         int var3 = p_149679_2_.nextInt(p_149679_1_ + 2) - 1;
         if(var3 < 0) {
            var3 = 0;
         }

         return this.func_149745_a(p_149679_2_) * (var3 + 1);
      } else {
         return this.func_149745_a(p_149679_2_);
      }
   }

   public void func_149690_a(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
      super.func_149690_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_, p_149690_7_);
      if(this.func_149650_a(p_149690_5_, p_149690_1_.field_73012_v, p_149690_7_) != Item.func_150898_a(this)) {
         int var8 = 0;
         if(this == Blocks.field_150365_q) {
            var8 = MathHelper.func_76136_a(p_149690_1_.field_73012_v, 0, 2);
         } else if(this == Blocks.field_150482_ag) {
            var8 = MathHelper.func_76136_a(p_149690_1_.field_73012_v, 3, 7);
         } else if(this == Blocks.field_150412_bA) {
            var8 = MathHelper.func_76136_a(p_149690_1_.field_73012_v, 3, 7);
         } else if(this == Blocks.field_150369_x) {
            var8 = MathHelper.func_76136_a(p_149690_1_.field_73012_v, 2, 5);
         } else if(this == Blocks.field_150449_bY) {
            var8 = MathHelper.func_76136_a(p_149690_1_.field_73012_v, 2, 5);
         }

         this.func_149657_c(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, var8);
      }

   }

   public int func_149692_a(int p_149692_1_) {
      return this == Blocks.field_150369_x?4:0;
   }
}
