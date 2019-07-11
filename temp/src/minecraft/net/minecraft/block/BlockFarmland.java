package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockFarmland extends Block {

   private IIcon field_149824_a;
   private IIcon field_149823_b;
   private static final String __OBFID = "CL_00000241";


   protected BlockFarmland() {
      super(Material.field_151578_c);
      this.func_149675_a(true);
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
      this.func_149713_g(255);
   }

   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
      return AxisAlignedBB.func_72330_a((double)(p_149668_2_ + 0), (double)(p_149668_3_ + 0), (double)(p_149668_4_ + 0), (double)(p_149668_2_ + 1), (double)(p_149668_3_ + 1), (double)(p_149668_4_ + 1));
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      return p_149691_1_ == 1?(p_149691_2_ > 0?this.field_149824_a:this.field_149823_b):Blocks.field_150346_d.func_149733_h(p_149691_1_);
   }

   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
      if(!this.func_149821_m(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_) && !p_149674_1_.func_72951_B(p_149674_2_, p_149674_3_ + 1, p_149674_4_)) {
         int var6 = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_);
         if(var6 > 0) {
            p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, var6 - 1, 2);
         } else if(!this.func_149822_e(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_)) {
            p_149674_1_.func_147449_b(p_149674_2_, p_149674_3_, p_149674_4_, Blocks.field_150346_d);
         }
      } else {
         p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, 7, 2);
      }

   }

   public void func_149746_a(World p_149746_1_, int p_149746_2_, int p_149746_3_, int p_149746_4_, Entity p_149746_5_, float p_149746_6_) {
      if(!p_149746_1_.field_72995_K && p_149746_1_.field_73012_v.nextFloat() < p_149746_6_ - 0.5F) {
         if(!(p_149746_5_ instanceof EntityPlayer) && !p_149746_1_.func_82736_K().func_82766_b("mobGriefing")) {
            return;
         }

         p_149746_1_.func_147449_b(p_149746_2_, p_149746_3_, p_149746_4_, Blocks.field_150346_d);
      }

   }

   private boolean func_149822_e(World p_149822_1_, int p_149822_2_, int p_149822_3_, int p_149822_4_) {
      byte var5 = 0;

      for(int var6 = p_149822_2_ - var5; var6 <= p_149822_2_ + var5; ++var6) {
         for(int var7 = p_149822_4_ - var5; var7 <= p_149822_4_ + var5; ++var7) {
            Block var8 = p_149822_1_.func_147439_a(var6, p_149822_3_ + 1, var7);
            if(var8 == Blocks.field_150464_aj || var8 == Blocks.field_150394_bc || var8 == Blocks.field_150393_bb || var8 == Blocks.field_150469_bN || var8 == Blocks.field_150459_bM) {
               return true;
            }
         }
      }

      return false;
   }

   private boolean func_149821_m(World p_149821_1_, int p_149821_2_, int p_149821_3_, int p_149821_4_) {
      for(int var5 = p_149821_2_ - 4; var5 <= p_149821_2_ + 4; ++var5) {
         for(int var6 = p_149821_3_; var6 <= p_149821_3_ + 1; ++var6) {
            for(int var7 = p_149821_4_ - 4; var7 <= p_149821_4_ + 4; ++var7) {
               if(p_149821_1_.func_147439_a(var5, var6, var7).func_149688_o() == Material.field_151586_h) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      super.func_149695_a(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_5_);
      Material var6 = p_149695_1_.func_147439_a(p_149695_2_, p_149695_3_ + 1, p_149695_4_).func_149688_o();
      if(var6.func_76220_a()) {
         p_149695_1_.func_147449_b(p_149695_2_, p_149695_3_, p_149695_4_, Blocks.field_150346_d);
      }

   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Blocks.field_150346_d.func_149650_a(0, p_149650_2_, p_149650_3_);
   }

   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
      return Item.func_150898_a(Blocks.field_150346_d);
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149824_a = p_149651_1_.func_94245_a(this.func_149641_N() + "_wet");
      this.field_149823_b = p_149651_1_.func_94245_a(this.func_149641_N() + "_dry");
   }
}
