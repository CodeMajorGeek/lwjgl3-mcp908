package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.command.server.CommandBlockLogic;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.world.World;

public class BlockCommandBlock extends BlockContainer {

   private static final String __OBFID = "CL_00000219";


   public BlockCommandBlock() {
      super(Material.field_151573_f);
   }

   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
      return new TileEntityCommandBlock();
   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      if(!p_149695_1_.field_72995_K) {
         boolean var6 = p_149695_1_.func_72864_z(p_149695_2_, p_149695_3_, p_149695_4_);
         int var7 = p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_);
         boolean var8 = (var7 & 1) != 0;
         if(var6 && !var8) {
            p_149695_1_.func_72921_c(p_149695_2_, p_149695_3_, p_149695_4_, var7 | 1, 4);
            p_149695_1_.func_147464_a(p_149695_2_, p_149695_3_, p_149695_4_, this, this.func_149738_a(p_149695_1_));
         } else if(!var6 && var8) {
            p_149695_1_.func_72921_c(p_149695_2_, p_149695_3_, p_149695_4_, var7 & -2, 4);
         }
      }

   }

   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      TileEntity var6 = p_149674_1_.func_147438_o(p_149674_2_, p_149674_3_, p_149674_4_);
      if(var6 != null && var6 instanceof TileEntityCommandBlock) {
         CommandBlockLogic var7 = ((TileEntityCommandBlock)var6).func_145993_a();
         var7.func_145755_a(p_149674_1_);
         p_149674_1_.func_147453_f(p_149674_2_, p_149674_3_, p_149674_4_, this);
      }

   }

   public int func_149738_a(World p_149738_1_) {
      return 1;
   }

   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
      TileEntityCommandBlock var10 = (TileEntityCommandBlock)p_149727_1_.func_147438_o(p_149727_2_, p_149727_3_, p_149727_4_);
      if(var10 != null) {
         p_149727_5_.func_146100_a(var10);
      }

      return true;
   }

   public boolean func_149740_M() {
      return true;
   }

   public int func_149736_g(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_) {
      TileEntity var6 = p_149736_1_.func_147438_o(p_149736_2_, p_149736_3_, p_149736_4_);
      return var6 != null && var6 instanceof TileEntityCommandBlock?((TileEntityCommandBlock)var6).func_145993_a().func_145760_g():0;
   }

   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
      TileEntityCommandBlock var7 = (TileEntityCommandBlock)p_149689_1_.func_147438_o(p_149689_2_, p_149689_3_, p_149689_4_);
      if(p_149689_6_.func_82837_s()) {
         var7.func_145993_a().func_145754_b(p_149689_6_.func_82833_r());
      }

   }

   public int func_149745_a(Random p_149745_1_) {
      return 0;
   }
}
