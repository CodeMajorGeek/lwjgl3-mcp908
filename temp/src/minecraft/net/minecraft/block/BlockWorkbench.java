package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockWorkbench extends Block {

   private IIcon field_150035_a;
   private IIcon field_150034_b;
   private static final String __OBFID = "CL_00000221";


   protected BlockWorkbench() {
      super(Material.field_151575_d);
      this.func_149647_a(CreativeTabs.field_78031_c);
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      return p_149691_1_ == 1?this.field_150035_a:(p_149691_1_ == 0?Blocks.field_150344_f.func_149733_h(p_149691_1_):(p_149691_1_ != 2 && p_149691_1_ != 4?this.field_149761_L:this.field_150034_b));
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149761_L = p_149651_1_.func_94245_a(this.func_149641_N() + "_side");
      this.field_150035_a = p_149651_1_.func_94245_a(this.func_149641_N() + "_top");
      this.field_150034_b = p_149651_1_.func_94245_a(this.func_149641_N() + "_front");
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
