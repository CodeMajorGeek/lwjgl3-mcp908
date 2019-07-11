package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDoor extends Block {

   private IIcon[] field_150017_a;
   private IIcon[] field_150016_b;
   private static final String __OBFID = "CL_00000230";


   protected BlockDoor(Material p_i45402_1_) {
      super(p_i45402_1_);
      float var2 = 0.5F;
      float var3 = 1.0F;
      this.func_149676_a(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, var3, 0.5F + var2);
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      return this.field_150016_b[0];
   }

   public IIcon func_149673_e(IBlockAccess p_149673_1_, int p_149673_2_, int p_149673_3_, int p_149673_4_, int p_149673_5_) {
      if(p_149673_5_ != 1 && p_149673_5_ != 0) {
         int var6 = this.func_150012_g(p_149673_1_, p_149673_2_, p_149673_3_, p_149673_4_);
         int var7 = var6 & 3;
         boolean var8 = (var6 & 4) != 0;
         boolean var9 = false;
         boolean var10 = (var6 & 8) != 0;
         if(var8) {
            if(var7 == 0 && p_149673_5_ == 2) {
               var9 = !var9;
            } else if(var7 == 1 && p_149673_5_ == 5) {
               var9 = !var9;
            } else if(var7 == 2 && p_149673_5_ == 3) {
               var9 = !var9;
            } else if(var7 == 3 && p_149673_5_ == 4) {
               var9 = !var9;
            }
         } else {
            if(var7 == 0 && p_149673_5_ == 5) {
               var9 = !var9;
            } else if(var7 == 1 && p_149673_5_ == 3) {
               var9 = !var9;
            } else if(var7 == 2 && p_149673_5_ == 4) {
               var9 = !var9;
            } else if(var7 == 3 && p_149673_5_ == 2) {
               var9 = !var9;
            }

            if((var6 & 16) != 0) {
               var9 = !var9;
            }
         }

         return var10?this.field_150017_a[var9?1:0]:this.field_150016_b[var9?1:0];
      } else {
         return this.field_150016_b[0];
      }
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_150017_a = new IIcon[2];
      this.field_150016_b = new IIcon[2];
      this.field_150017_a[0] = p_149651_1_.func_94245_a(this.func_149641_N() + "_upper");
      this.field_150016_b[0] = p_149651_1_.func_94245_a(this.func_149641_N() + "_lower");
      this.field_150017_a[1] = new IconFlipped(this.field_150017_a[0], true, false);
      this.field_150016_b[1] = new IconFlipped(this.field_150016_b[0], true, false);
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149655_b(IBlockAccess p_149655_1_, int p_149655_2_, int p_149655_3_, int p_149655_4_) {
      int var5 = this.func_150012_g(p_149655_1_, p_149655_2_, p_149655_3_, p_149655_4_);
      return (var5 & 4) != 0;
   }

   public boolean func_149686_d() {
      return false;
   }

   public int func_149645_b() {
      return 7;
   }

   public AxisAlignedBB func_149633_g(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_) {
      this.func_149719_a(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
      return super.func_149633_g(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
   }

   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
      this.func_149719_a(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
      return super.func_149668_a(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
   }

   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
      this.func_150011_b(this.func_150012_g(p_149719_1_, p_149719_2_, p_149719_3_, p_149719_4_));
   }

   public int func_150013_e(IBlockAccess p_150013_1_, int p_150013_2_, int p_150013_3_, int p_150013_4_) {
      return this.func_150012_g(p_150013_1_, p_150013_2_, p_150013_3_, p_150013_4_) & 3;
   }

   public boolean func_150015_f(IBlockAccess p_150015_1_, int p_150015_2_, int p_150015_3_, int p_150015_4_) {
      return (this.func_150012_g(p_150015_1_, p_150015_2_, p_150015_3_, p_150015_4_) & 4) != 0;
   }

   private void func_150011_b(int p_150011_1_) {
      float var2 = 0.1875F;
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
      int var3 = p_150011_1_ & 3;
      boolean var4 = (p_150011_1_ & 4) != 0;
      boolean var5 = (p_150011_1_ & 16) != 0;
      if(var3 == 0) {
         if(var4) {
            if(!var5) {
               this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
            } else {
               this.func_149676_a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
            }
         } else {
            this.func_149676_a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
         }
      } else if(var3 == 1) {
         if(var4) {
            if(!var5) {
               this.func_149676_a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            } else {
               this.func_149676_a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
            }
         } else {
            this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
         }
      } else if(var3 == 2) {
         if(var4) {
            if(!var5) {
               this.func_149676_a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
            } else {
               this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
            }
         } else {
            this.func_149676_a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         }
      } else if(var3 == 3) {
         if(var4) {
            if(!var5) {
               this.func_149676_a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
            } else {
               this.func_149676_a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            }
         } else {
            this.func_149676_a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
         }
      }

   }

   public void func_149699_a(World p_149699_1_, int p_149699_2_, int p_149699_3_, int p_149699_4_, EntityPlayer p_149699_5_) {}

   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
      if(this.field_149764_J == Material.field_151573_f) {
         return true;
      } else {
         int var10 = this.func_150012_g(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_);
         int var11 = var10 & 7;
         var11 ^= 4;
         if((var10 & 8) == 0) {
            p_149727_1_.func_72921_c(p_149727_2_, p_149727_3_, p_149727_4_, var11, 2);
            p_149727_1_.func_147458_c(p_149727_2_, p_149727_3_, p_149727_4_, p_149727_2_, p_149727_3_, p_149727_4_);
         } else {
            p_149727_1_.func_72921_c(p_149727_2_, p_149727_3_ - 1, p_149727_4_, var11, 2);
            p_149727_1_.func_147458_c(p_149727_2_, p_149727_3_ - 1, p_149727_4_, p_149727_2_, p_149727_3_, p_149727_4_);
         }

         p_149727_1_.func_72889_a(p_149727_5_, 1003, p_149727_2_, p_149727_3_, p_149727_4_, 0);
         return true;
      }
   }

   public void func_150014_a(World p_150014_1_, int p_150014_2_, int p_150014_3_, int p_150014_4_, boolean p_150014_5_) {
      int var6 = this.func_150012_g(p_150014_1_, p_150014_2_, p_150014_3_, p_150014_4_);
      boolean var7 = (var6 & 4) != 0;
      if(var7 != p_150014_5_) {
         int var8 = var6 & 7;
         var8 ^= 4;
         if((var6 & 8) == 0) {
            p_150014_1_.func_72921_c(p_150014_2_, p_150014_3_, p_150014_4_, var8, 2);
            p_150014_1_.func_147458_c(p_150014_2_, p_150014_3_, p_150014_4_, p_150014_2_, p_150014_3_, p_150014_4_);
         } else {
            p_150014_1_.func_72921_c(p_150014_2_, p_150014_3_ - 1, p_150014_4_, var8, 2);
            p_150014_1_.func_147458_c(p_150014_2_, p_150014_3_ - 1, p_150014_4_, p_150014_2_, p_150014_3_, p_150014_4_);
         }

         p_150014_1_.func_72889_a((EntityPlayer)null, 1003, p_150014_2_, p_150014_3_, p_150014_4_, 0);
      }
   }

   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
      int var6 = p_149695_1_.func_72805_g(p_149695_2_, p_149695_3_, p_149695_4_);
      if((var6 & 8) == 0) {
         boolean var7 = false;
         if(p_149695_1_.func_147439_a(p_149695_2_, p_149695_3_ + 1, p_149695_4_) != this) {
            p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
            var7 = true;
         }

         if(!World.func_147466_a(p_149695_1_, p_149695_2_, p_149695_3_ - 1, p_149695_4_)) {
            p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
            var7 = true;
            if(p_149695_1_.func_147439_a(p_149695_2_, p_149695_3_ + 1, p_149695_4_) == this) {
               p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_ + 1, p_149695_4_);
            }
         }

         if(var7) {
            if(!p_149695_1_.field_72995_K) {
               this.func_149697_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, var6, 0);
            }
         } else {
            boolean var8 = p_149695_1_.func_72864_z(p_149695_2_, p_149695_3_, p_149695_4_) || p_149695_1_.func_72864_z(p_149695_2_, p_149695_3_ + 1, p_149695_4_);
            if((var8 || p_149695_5_.func_149744_f()) && p_149695_5_ != this) {
               this.func_150014_a(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, var8);
            }
         }
      } else {
         if(p_149695_1_.func_147439_a(p_149695_2_, p_149695_3_ - 1, p_149695_4_) != this) {
            p_149695_1_.func_147468_f(p_149695_2_, p_149695_3_, p_149695_4_);
         }

         if(p_149695_5_ != this) {
            this.func_149695_a(p_149695_1_, p_149695_2_, p_149695_3_ - 1, p_149695_4_, p_149695_5_);
         }
      }

   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return (p_149650_1_ & 8) != 0?null:(this.field_149764_J == Material.field_151573_f?Items.field_151139_aw:Items.field_151135_aq);
   }

   public MovingObjectPosition func_149731_a(World p_149731_1_, int p_149731_2_, int p_149731_3_, int p_149731_4_, Vec3 p_149731_5_, Vec3 p_149731_6_) {
      this.func_149719_a(p_149731_1_, p_149731_2_, p_149731_3_, p_149731_4_);
      return super.func_149731_a(p_149731_1_, p_149731_2_, p_149731_3_, p_149731_4_, p_149731_5_, p_149731_6_);
   }

   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
      return p_149742_3_ >= 255?false:World.func_147466_a(p_149742_1_, p_149742_2_, p_149742_3_ - 1, p_149742_4_) && super.func_149742_c(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_) && super.func_149742_c(p_149742_1_, p_149742_2_, p_149742_3_ + 1, p_149742_4_);
   }

   public int func_149656_h() {
      return 1;
   }

   public int func_150012_g(IBlockAccess p_150012_1_, int p_150012_2_, int p_150012_3_, int p_150012_4_) {
      int var5 = p_150012_1_.func_72805_g(p_150012_2_, p_150012_3_, p_150012_4_);
      boolean var6 = (var5 & 8) != 0;
      int var7;
      int var8;
      if(var6) {
         var7 = p_150012_1_.func_72805_g(p_150012_2_, p_150012_3_ - 1, p_150012_4_);
         var8 = var5;
      } else {
         var7 = var5;
         var8 = p_150012_1_.func_72805_g(p_150012_2_, p_150012_3_ + 1, p_150012_4_);
      }

      boolean var9 = (var8 & 1) != 0;
      return var7 & 7 | (var6?8:0) | (var9?16:0);
   }

   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
      return this.field_149764_J == Material.field_151573_f?Items.field_151139_aw:Items.field_151135_aq;
   }

   public void func_149681_a(World p_149681_1_, int p_149681_2_, int p_149681_3_, int p_149681_4_, int p_149681_5_, EntityPlayer p_149681_6_) {
      if(p_149681_6_.field_71075_bZ.field_75098_d && (p_149681_5_ & 8) != 0 && p_149681_1_.func_147439_a(p_149681_2_, p_149681_3_ - 1, p_149681_4_) == this) {
         p_149681_1_.func_147468_f(p_149681_2_, p_149681_3_ - 1, p_149681_4_);
      }

   }
}
