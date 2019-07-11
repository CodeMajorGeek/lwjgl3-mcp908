package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class BlockMelon extends Block {

   private IIcon field_150201_a;
   private static final String __OBFID = "CL_00000267";


   protected BlockMelon() {
      super(Material.field_151572_C);
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      return p_149691_1_ != 1 && p_149691_1_ != 0?this.field_149761_L:this.field_150201_a;
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Items.field_151127_ba;
   }

   public int func_149745_a(Random p_149745_1_) {
      return 3 + p_149745_1_.nextInt(5);
   }

   public int func_149679_a(int p_149679_1_, Random p_149679_2_) {
      int var3 = this.func_149745_a(p_149679_2_) + p_149679_2_.nextInt(1 + p_149679_1_);
      if(var3 > 9) {
         var3 = 9;
      }

      return var3;
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149761_L = p_149651_1_.func_94245_a(this.func_149641_N() + "_side");
      this.field_150201_a = p_149651_1_.func_94245_a(this.func_149641_N() + "_top");
   }
}
