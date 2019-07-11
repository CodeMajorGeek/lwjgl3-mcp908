package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemBucket extends Item {

   private Block field_77876_a;
   private static final String __OBFID = "CL_00000000";


   public ItemBucket(Block p_i45331_1_) {
      this.field_77777_bU = 1;
      this.field_77876_a = p_i45331_1_;
      this.func_77637_a(CreativeTabs.field_78026_f);
   }

   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      boolean var4 = this.field_77876_a == Blocks.field_150350_a;
      MovingObjectPosition var5 = this.func_77621_a(p_77659_2_, p_77659_3_, var4);
      if(var5 == null) {
         return p_77659_1_;
      } else {
         if(var5.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
            int var6 = var5.field_72311_b;
            int var7 = var5.field_72312_c;
            int var8 = var5.field_72309_d;
            if(!p_77659_2_.func_72962_a(p_77659_3_, var6, var7, var8)) {
               return p_77659_1_;
            }

            if(var4) {
               if(!p_77659_3_.func_82247_a(var6, var7, var8, var5.field_72310_e, p_77659_1_)) {
                  return p_77659_1_;
               }

               Material var9 = p_77659_2_.func_147439_a(var6, var7, var8).func_149688_o();
               int var10 = p_77659_2_.func_72805_g(var6, var7, var8);
               if(var9 == Material.field_151586_h && var10 == 0) {
                  p_77659_2_.func_147468_f(var6, var7, var8);
                  return this.func_150910_a(p_77659_1_, p_77659_3_, Items.field_151131_as);
               }

               if(var9 == Material.field_151587_i && var10 == 0) {
                  p_77659_2_.func_147468_f(var6, var7, var8);
                  return this.func_150910_a(p_77659_1_, p_77659_3_, Items.field_151129_at);
               }
            } else {
               if(this.field_77876_a == Blocks.field_150350_a) {
                  return new ItemStack(Items.field_151133_ar);
               }

               if(var5.field_72310_e == 0) {
                  --var7;
               }

               if(var5.field_72310_e == 1) {
                  ++var7;
               }

               if(var5.field_72310_e == 2) {
                  --var8;
               }

               if(var5.field_72310_e == 3) {
                  ++var8;
               }

               if(var5.field_72310_e == 4) {
                  --var6;
               }

               if(var5.field_72310_e == 5) {
                  ++var6;
               }

               if(!p_77659_3_.func_82247_a(var6, var7, var8, var5.field_72310_e, p_77659_1_)) {
                  return p_77659_1_;
               }

               if(this.func_77875_a(p_77659_2_, var6, var7, var8) && !p_77659_3_.field_71075_bZ.field_75098_d) {
                  return new ItemStack(Items.field_151133_ar);
               }
            }
         }

         return p_77659_1_;
      }
   }

   private ItemStack func_150910_a(ItemStack p_150910_1_, EntityPlayer p_150910_2_, Item p_150910_3_) {
      if(p_150910_2_.field_71075_bZ.field_75098_d) {
         return p_150910_1_;
      } else if(--p_150910_1_.field_77994_a <= 0) {
         return new ItemStack(p_150910_3_);
      } else {
         if(!p_150910_2_.field_71071_by.func_70441_a(new ItemStack(p_150910_3_))) {
            p_150910_2_.func_71019_a(new ItemStack(p_150910_3_, 1, 0), false);
         }

         return p_150910_1_;
      }
   }

   public boolean func_77875_a(World p_77875_1_, int p_77875_2_, int p_77875_3_, int p_77875_4_) {
      if(this.field_77876_a == Blocks.field_150350_a) {
         return false;
      } else {
         Material var5 = p_77875_1_.func_147439_a(p_77875_2_, p_77875_3_, p_77875_4_).func_149688_o();
         boolean var6 = !var5.func_76220_a();
         if(!p_77875_1_.func_147437_c(p_77875_2_, p_77875_3_, p_77875_4_) && !var6) {
            return false;
         } else {
            if(p_77875_1_.field_73011_w.field_76575_d && this.field_77876_a == Blocks.field_150358_i) {
               p_77875_1_.func_72908_a((double)((float)p_77875_2_ + 0.5F), (double)((float)p_77875_3_ + 0.5F), (double)((float)p_77875_4_ + 0.5F), "random.fizz", 0.5F, 2.6F + (p_77875_1_.field_73012_v.nextFloat() - p_77875_1_.field_73012_v.nextFloat()) * 0.8F);

               for(int var7 = 0; var7 < 8; ++var7) {
                  p_77875_1_.func_72869_a("largesmoke", (double)p_77875_2_ + Math.random(), (double)p_77875_3_ + Math.random(), (double)p_77875_4_ + Math.random(), 0.0D, 0.0D, 0.0D);
               }
            } else {
               if(!p_77875_1_.field_72995_K && var6 && !var5.func_76224_d()) {
                  p_77875_1_.func_147480_a(p_77875_2_, p_77875_3_, p_77875_4_, true);
               }

               p_77875_1_.func_147465_d(p_77875_2_, p_77875_3_, p_77875_4_, this.field_77876_a, 0, 3);
            }

            return true;
         }
      }
   }
}
