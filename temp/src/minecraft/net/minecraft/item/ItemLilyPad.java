package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemColored;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemLilyPad extends ItemColored {

   private static final String __OBFID = "CL_00000074";


   public ItemLilyPad(Block p_i45357_1_) {
      super(p_i45357_1_, false);
   }

   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      MovingObjectPosition var4 = this.func_77621_a(p_77659_2_, p_77659_3_, true);
      if(var4 == null) {
         return p_77659_1_;
      } else {
         if(var4.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
            int var5 = var4.field_72311_b;
            int var6 = var4.field_72312_c;
            int var7 = var4.field_72309_d;
            if(!p_77659_2_.func_72962_a(p_77659_3_, var5, var6, var7)) {
               return p_77659_1_;
            }

            if(!p_77659_3_.func_82247_a(var5, var6, var7, var4.field_72310_e, p_77659_1_)) {
               return p_77659_1_;
            }

            if(p_77659_2_.func_147439_a(var5, var6, var7).func_149688_o() == Material.field_151586_h && p_77659_2_.func_72805_g(var5, var6, var7) == 0 && p_77659_2_.func_147437_c(var5, var6 + 1, var7)) {
               p_77659_2_.func_147449_b(var5, var6 + 1, var7, Blocks.field_150392_bi);
               if(!p_77659_3_.field_71075_bZ.field_75098_d) {
                  --p_77659_1_.field_77994_a;
               }
            }
         }

         return p_77659_1_;
      }
   }

   public int func_82790_a(ItemStack p_82790_1_, int p_82790_2_) {
      return Blocks.field_150392_bi.func_149741_i(p_82790_1_.func_77960_j());
   }
}
