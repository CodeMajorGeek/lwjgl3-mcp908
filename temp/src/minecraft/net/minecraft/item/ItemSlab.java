package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemSlab extends ItemBlock {

   private final boolean field_150948_b;
   private final BlockSlab field_150949_c;
   private final BlockSlab field_150947_d;
   private static final String __OBFID = "CL_00000071";


   public ItemSlab(Block p_i45355_1_, BlockSlab p_i45355_2_, BlockSlab p_i45355_3_, boolean p_i45355_4_) {
      super(p_i45355_1_);
      this.field_150949_c = p_i45355_2_;
      this.field_150947_d = p_i45355_3_;
      this.field_150948_b = p_i45355_4_;
      this.func_77656_e(0);
      this.func_77627_a(true);
   }

   public IIcon func_77617_a(int p_77617_1_) {
      return Block.func_149634_a(this).func_149691_a(2, p_77617_1_);
   }

   public int func_77647_b(int p_77647_1_) {
      return p_77647_1_;
   }

   public String func_77667_c(ItemStack p_77667_1_) {
      return this.field_150949_c.func_150002_b(p_77667_1_.func_77960_j());
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      if(this.field_150948_b) {
         return super.func_77648_a(p_77648_1_, p_77648_2_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_);
      } else if(p_77648_1_.field_77994_a == 0) {
         return false;
      } else if(!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) {
         return false;
      } else {
         Block var11 = p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_);
         int var12 = p_77648_3_.func_72805_g(p_77648_4_, p_77648_5_, p_77648_6_);
         int var13 = var12 & 7;
         boolean var14 = (var12 & 8) != 0;
         if((p_77648_7_ == 1 && !var14 || p_77648_7_ == 0 && var14) && var11 == this.field_150949_c && var13 == p_77648_1_.func_77960_j()) {
            if(p_77648_3_.func_72855_b(this.field_150947_d.func_149668_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_)) && p_77648_3_.func_147465_d(p_77648_4_, p_77648_5_, p_77648_6_, this.field_150947_d, var13, 3)) {
               p_77648_3_.func_72908_a((double)((float)p_77648_4_ + 0.5F), (double)((float)p_77648_5_ + 0.5F), (double)((float)p_77648_6_ + 0.5F), this.field_150947_d.field_149762_H.func_150496_b(), (this.field_150947_d.field_149762_H.func_150497_c() + 1.0F) / 2.0F, this.field_150947_d.field_149762_H.func_150494_d() * 0.8F);
               --p_77648_1_.field_77994_a;
            }

            return true;
         } else {
            return this.func_150946_a(p_77648_1_, p_77648_2_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_)?true:super.func_77648_a(p_77648_1_, p_77648_2_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_);
         }
      }
   }

   public boolean func_150936_a(World p_150936_1_, int p_150936_2_, int p_150936_3_, int p_150936_4_, int p_150936_5_, EntityPlayer p_150936_6_, ItemStack p_150936_7_) {
      int var8 = p_150936_2_;
      int var9 = p_150936_3_;
      int var10 = p_150936_4_;
      Block var11 = p_150936_1_.func_147439_a(p_150936_2_, p_150936_3_, p_150936_4_);
      int var12 = p_150936_1_.func_72805_g(p_150936_2_, p_150936_3_, p_150936_4_);
      int var13 = var12 & 7;
      boolean var14 = (var12 & 8) != 0;
      if((p_150936_5_ == 1 && !var14 || p_150936_5_ == 0 && var14) && var11 == this.field_150949_c && var13 == p_150936_7_.func_77960_j()) {
         return true;
      } else {
         if(p_150936_5_ == 0) {
            --p_150936_3_;
         }

         if(p_150936_5_ == 1) {
            ++p_150936_3_;
         }

         if(p_150936_5_ == 2) {
            --p_150936_4_;
         }

         if(p_150936_5_ == 3) {
            ++p_150936_4_;
         }

         if(p_150936_5_ == 4) {
            --p_150936_2_;
         }

         if(p_150936_5_ == 5) {
            ++p_150936_2_;
         }

         Block var15 = p_150936_1_.func_147439_a(p_150936_2_, p_150936_3_, p_150936_4_);
         int var16 = p_150936_1_.func_72805_g(p_150936_2_, p_150936_3_, p_150936_4_);
         var13 = var16 & 7;
         return var15 == this.field_150949_c && var13 == p_150936_7_.func_77960_j()?true:super.func_150936_a(p_150936_1_, var8, var9, var10, p_150936_5_, p_150936_6_, p_150936_7_);
      }
   }

   private boolean func_150946_a(ItemStack p_150946_1_, EntityPlayer p_150946_2_, World p_150946_3_, int p_150946_4_, int p_150946_5_, int p_150946_6_, int p_150946_7_) {
      if(p_150946_7_ == 0) {
         --p_150946_5_;
      }

      if(p_150946_7_ == 1) {
         ++p_150946_5_;
      }

      if(p_150946_7_ == 2) {
         --p_150946_6_;
      }

      if(p_150946_7_ == 3) {
         ++p_150946_6_;
      }

      if(p_150946_7_ == 4) {
         --p_150946_4_;
      }

      if(p_150946_7_ == 5) {
         ++p_150946_4_;
      }

      Block var8 = p_150946_3_.func_147439_a(p_150946_4_, p_150946_5_, p_150946_6_);
      int var9 = p_150946_3_.func_72805_g(p_150946_4_, p_150946_5_, p_150946_6_);
      int var10 = var9 & 7;
      if(var8 == this.field_150949_c && var10 == p_150946_1_.func_77960_j()) {
         if(p_150946_3_.func_72855_b(this.field_150947_d.func_149668_a(p_150946_3_, p_150946_4_, p_150946_5_, p_150946_6_)) && p_150946_3_.func_147465_d(p_150946_4_, p_150946_5_, p_150946_6_, this.field_150947_d, var10, 3)) {
            p_150946_3_.func_72908_a((double)((float)p_150946_4_ + 0.5F), (double)((float)p_150946_5_ + 0.5F), (double)((float)p_150946_6_ + 0.5F), this.field_150947_d.field_149762_H.func_150496_b(), (this.field_150947_d.field_149762_H.func_150497_c() + 1.0F) / 2.0F, this.field_150947_d.field_149762_H.func_150494_d() * 0.8F);
            --p_150946_1_.field_77994_a;
         }

         return true;
      } else {
         return false;
      }
   }
}
