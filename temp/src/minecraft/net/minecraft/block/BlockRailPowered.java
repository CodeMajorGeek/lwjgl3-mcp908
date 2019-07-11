package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockRailPowered extends BlockRailBase {

   protected IIcon field_150059_b;
   private static final String __OBFID = "CL_00000288";


   protected BlockRailPowered() {
      super(true);
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      return (p_149691_2_ & 8) == 0?this.field_149761_L:this.field_150059_b;
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      super.func_149651_a(p_149651_1_);
      this.field_150059_b = p_149651_1_.func_94245_a(this.func_149641_N() + "_powered");
   }

   protected boolean func_150058_a(World p_150058_1_, int p_150058_2_, int p_150058_3_, int p_150058_4_, int p_150058_5_, boolean p_150058_6_, int p_150058_7_) {
      if(p_150058_7_ >= 8) {
         return false;
      } else {
         int var8 = p_150058_5_ & 7;
         boolean var9 = true;
         switch(var8) {
         case 0:
            if(p_150058_6_) {
               ++p_150058_4_;
            } else {
               --p_150058_4_;
            }
            break;
         case 1:
            if(p_150058_6_) {
               --p_150058_2_;
            } else {
               ++p_150058_2_;
            }
            break;
         case 2:
            if(p_150058_6_) {
               --p_150058_2_;
            } else {
               ++p_150058_2_;
               ++p_150058_3_;
               var9 = false;
            }

            var8 = 1;
            break;
         case 3:
            if(p_150058_6_) {
               --p_150058_2_;
               ++p_150058_3_;
               var9 = false;
            } else {
               ++p_150058_2_;
            }

            var8 = 1;
            break;
         case 4:
            if(p_150058_6_) {
               ++p_150058_4_;
            } else {
               --p_150058_4_;
               ++p_150058_3_;
               var9 = false;
            }

            var8 = 0;
            break;
         case 5:
            if(p_150058_6_) {
               ++p_150058_4_;
               ++p_150058_3_;
               var9 = false;
            } else {
               --p_150058_4_;
            }

            var8 = 0;
         }

         return this.func_150057_a(p_150058_1_, p_150058_2_, p_150058_3_, p_150058_4_, p_150058_6_, p_150058_7_, var8)?true:var9 && this.func_150057_a(p_150058_1_, p_150058_2_, p_150058_3_ - 1, p_150058_4_, p_150058_6_, p_150058_7_, var8);
      }
   }

   protected boolean func_150057_a(World p_150057_1_, int p_150057_2_, int p_150057_3_, int p_150057_4_, boolean p_150057_5_, int p_150057_6_, int p_150057_7_) {
      Block var8 = p_150057_1_.func_147439_a(p_150057_2_, p_150057_3_, p_150057_4_);
      if(var8 == this) {
         int var9 = p_150057_1_.func_72805_g(p_150057_2_, p_150057_3_, p_150057_4_);
         int var10 = var9 & 7;
         if(p_150057_7_ == 1 && (var10 == 0 || var10 == 4 || var10 == 5)) {
            return false;
         }

         if(p_150057_7_ == 0 && (var10 == 1 || var10 == 2 || var10 == 3)) {
            return false;
         }

         if((var9 & 8) != 0) {
            if(p_150057_1_.func_72864_z(p_150057_2_, p_150057_3_, p_150057_4_)) {
               return true;
            }

            return this.func_150058_a(p_150057_1_, p_150057_2_, p_150057_3_, p_150057_4_, var9, p_150057_5_, p_150057_6_ + 1);
         }
      }

      return false;
   }

   protected void func_150048_a(World p_150048_1_, int p_150048_2_, int p_150048_3_, int p_150048_4_, int p_150048_5_, int p_150048_6_, Block p_150048_7_) {
      boolean var8 = p_150048_1_.func_72864_z(p_150048_2_, p_150048_3_, p_150048_4_);
      var8 = var8 || this.func_150058_a(p_150048_1_, p_150048_2_, p_150048_3_, p_150048_4_, p_150048_5_, true, 0) || this.func_150058_a(p_150048_1_, p_150048_2_, p_150048_3_, p_150048_4_, p_150048_5_, false, 0);
      boolean var9 = false;
      if(var8 && (p_150048_5_ & 8) == 0) {
         p_150048_1_.func_72921_c(p_150048_2_, p_150048_3_, p_150048_4_, p_150048_6_ | 8, 3);
         var9 = true;
      } else if(!var8 && (p_150048_5_ & 8) != 0) {
         p_150048_1_.func_72921_c(p_150048_2_, p_150048_3_, p_150048_4_, p_150048_6_, 3);
         var9 = true;
      }

      if(var9) {
         p_150048_1_.func_147459_d(p_150048_2_, p_150048_3_ - 1, p_150048_4_, this);
         if(p_150048_6_ == 2 || p_150048_6_ == 3 || p_150048_6_ == 4 || p_150048_6_ == 5) {
            p_150048_1_.func_147459_d(p_150048_2_, p_150048_3_ + 1, p_150048_4_, this);
         }
      }

   }
}
