package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBlock extends Item {

   protected final Block field_150939_a;
   private static final String __OBFID = "CL_00001772";


   public ItemBlock(Block p_i45328_1_) {
      this.field_150939_a = p_i45328_1_;
   }

   public ItemBlock func_77655_b(String p_77655_1_) {
      super.func_77655_b(p_77655_1_);
      return this;
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      Block var11 = p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_);
      if(var11 == Blocks.field_150431_aC && (p_77648_3_.func_72805_g(p_77648_4_, p_77648_5_, p_77648_6_) & 7) < 1) {
         p_77648_7_ = 1;
      } else if(var11 != Blocks.field_150395_bd && var11 != Blocks.field_150329_H && var11 != Blocks.field_150330_I) {
         if(p_77648_7_ == 0) {
            --p_77648_5_;
         }

         if(p_77648_7_ == 1) {
            ++p_77648_5_;
         }

         if(p_77648_7_ == 2) {
            --p_77648_6_;
         }

         if(p_77648_7_ == 3) {
            ++p_77648_6_;
         }

         if(p_77648_7_ == 4) {
            --p_77648_4_;
         }

         if(p_77648_7_ == 5) {
            ++p_77648_4_;
         }
      }

      if(p_77648_1_.field_77994_a == 0) {
         return false;
      } else if(!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) {
         return false;
      } else if(p_77648_5_ == 255 && this.field_150939_a.func_149688_o().func_76220_a()) {
         return false;
      } else if(p_77648_3_.func_147472_a(this.field_150939_a, p_77648_4_, p_77648_5_, p_77648_6_, false, p_77648_7_, p_77648_2_, p_77648_1_)) {
         int var12 = this.func_77647_b(p_77648_1_.func_77960_j());
         int var13 = this.field_150939_a.func_149660_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_, var12);
         if(p_77648_3_.func_147465_d(p_77648_4_, p_77648_5_, p_77648_6_, this.field_150939_a, var13, 3)) {
            if(p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_) == this.field_150939_a) {
               this.field_150939_a.func_149689_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_2_, p_77648_1_);
               this.field_150939_a.func_149714_e(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, var13);
            }

            p_77648_3_.func_72908_a((double)((float)p_77648_4_ + 0.5F), (double)((float)p_77648_5_ + 0.5F), (double)((float)p_77648_6_ + 0.5F), this.field_150939_a.field_149762_H.func_150496_b(), (this.field_150939_a.field_149762_H.func_150497_c() + 1.0F) / 2.0F, this.field_150939_a.field_149762_H.func_150494_d() * 0.8F);
            --p_77648_1_.field_77994_a;
         }

         return true;
      } else {
         return false;
      }
   }

   public String func_77667_c(ItemStack p_77667_1_) {
      return this.field_150939_a.func_149739_a();
   }

   public String func_77658_a() {
      return this.field_150939_a.func_149739_a();
   }

   // $FF: synthetic method
   public Item func_77655_b(String p_77655_1_) {
      return this.func_77655_b(p_77655_1_);
   }
}
