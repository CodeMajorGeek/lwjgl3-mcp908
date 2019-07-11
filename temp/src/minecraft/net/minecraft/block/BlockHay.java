package net.minecraft.block;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class BlockHay extends BlockRotatedPillar {

   private static final String __OBFID = "CL_00000256";


   public BlockHay() {
      super(Material.field_151577_b);
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   protected IIcon func_150163_b(int p_150163_1_) {
      return this.field_149761_L;
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_150164_N = p_149651_1_.func_94245_a(this.func_149641_N() + "_top");
      this.field_149761_L = p_149651_1_.func_94245_a(this.func_149641_N() + "_side");
   }
}
