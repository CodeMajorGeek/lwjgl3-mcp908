package net.minecraft.tileentity;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityNote extends TileEntity {

   public byte field_145879_a;
   public boolean field_145880_i;
   private static final String __OBFID = "CL_00000362";


   public void func_145841_b(NBTTagCompound p_145841_1_) {
      super.func_145841_b(p_145841_1_);
      p_145841_1_.func_74774_a("note", this.field_145879_a);
   }

   public void func_145839_a(NBTTagCompound p_145839_1_) {
      super.func_145839_a(p_145839_1_);
      this.field_145879_a = p_145839_1_.func_74771_c("note");
      if(this.field_145879_a < 0) {
         this.field_145879_a = 0;
      }

      if(this.field_145879_a > 24) {
         this.field_145879_a = 24;
      }

   }

   public void func_145877_a() {
      this.field_145879_a = (byte)((this.field_145879_a + 1) % 25);
      this.func_70296_d();
   }

   public void func_145878_a(World p_145878_1_, int p_145878_2_, int p_145878_3_, int p_145878_4_) {
      if(p_145878_1_.func_147439_a(p_145878_2_, p_145878_3_ + 1, p_145878_4_).func_149688_o() == Material.field_151579_a) {
         Material var5 = p_145878_1_.func_147439_a(p_145878_2_, p_145878_3_ - 1, p_145878_4_).func_149688_o();
         byte var6 = 0;
         if(var5 == Material.field_151576_e) {
            var6 = 1;
         }

         if(var5 == Material.field_151595_p) {
            var6 = 2;
         }

         if(var5 == Material.field_151592_s) {
            var6 = 3;
         }

         if(var5 == Material.field_151575_d) {
            var6 = 4;
         }

         p_145878_1_.func_147452_c(p_145878_2_, p_145878_3_, p_145878_4_, Blocks.field_150323_B, var6, this.field_145879_a);
      }
   }
}
