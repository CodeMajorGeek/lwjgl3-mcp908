package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockCauldron extends Block {

   private IIcon field_150029_a;
   private IIcon field_150028_b;
   private IIcon field_150030_M;
   private static final String __OBFID = "CL_00000213";


   public BlockCauldron() {
      super(Material.field_151573_f);
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      return p_149691_1_ == 1?this.field_150028_b:(p_149691_1_ == 0?this.field_150030_M:this.field_149761_L);
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_150029_a = p_149651_1_.func_94245_a(this.func_149641_N() + "_" + "inner");
      this.field_150028_b = p_149651_1_.func_94245_a(this.func_149641_N() + "_top");
      this.field_150030_M = p_149651_1_.func_94245_a(this.func_149641_N() + "_" + "bottom");
      this.field_149761_L = p_149651_1_.func_94245_a(this.func_149641_N() + "_side");
   }

   public static IIcon func_150026_e(String p_150026_0_) {
      return p_150026_0_.equals("inner")?Blocks.field_150383_bp.field_150029_a:(p_150026_0_.equals("bottom")?Blocks.field_150383_bp.field_150030_M:null);
   }

   public void func_149743_a(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
      super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
      float var8 = 0.125F;
      this.func_149676_a(0.0F, 0.0F, 0.0F, var8, 1.0F, 1.0F);
      super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var8);
      super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
      this.func_149676_a(1.0F - var8, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
      this.func_149676_a(0.0F, 0.0F, 1.0F - var8, 1.0F, 1.0F, 1.0F);
      super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
      this.func_149683_g();
   }

   public void func_149683_g() {
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public boolean func_149662_c() {
      return false;
   }

   public int func_149645_b() {
      return 24;
   }

   public boolean func_149686_d() {
      return false;
   }

   public void func_149670_a(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_) {
      int var6 = func_150027_b(p_149670_1_.func_72805_g(p_149670_2_, p_149670_3_, p_149670_4_));
      float var7 = (float)p_149670_3_ + (6.0F + (float)(3 * var6)) / 16.0F;
      if(!p_149670_1_.field_72995_K && p_149670_5_.func_70027_ad() && var6 > 0 && p_149670_5_.field_70121_D.field_72338_b <= (double)var7) {
         p_149670_5_.func_70066_B();
         this.func_150024_a(p_149670_1_, p_149670_2_, p_149670_3_, p_149670_4_, var6 - 1);
      }

   }

   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
      if(p_149727_1_.field_72995_K) {
         return true;
      } else {
         ItemStack var10 = p_149727_5_.field_71071_by.func_70448_g();
         if(var10 == null) {
            return true;
         } else {
            int var11 = p_149727_1_.func_72805_g(p_149727_2_, p_149727_3_, p_149727_4_);
            int var12 = func_150027_b(var11);
            if(var10.func_77973_b() == Items.field_151131_as) {
               if(var12 < 3) {
                  if(!p_149727_5_.field_71075_bZ.field_75098_d) {
                     p_149727_5_.field_71071_by.func_70299_a(p_149727_5_.field_71071_by.field_70461_c, new ItemStack(Items.field_151133_ar));
                  }

                  this.func_150024_a(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, 3);
               }

               return true;
            } else {
               if(var10.func_77973_b() == Items.field_151069_bo) {
                  if(var12 > 0) {
                     if(!p_149727_5_.field_71075_bZ.field_75098_d) {
                        ItemStack var13 = new ItemStack(Items.field_151068_bn, 1, 0);
                        if(!p_149727_5_.field_71071_by.func_70441_a(var13)) {
                           p_149727_1_.func_72838_d(new EntityItem(p_149727_1_, (double)p_149727_2_ + 0.5D, (double)p_149727_3_ + 1.5D, (double)p_149727_4_ + 0.5D, var13));
                        } else if(p_149727_5_ instanceof EntityPlayerMP) {
                           ((EntityPlayerMP)p_149727_5_).func_71120_a(p_149727_5_.field_71069_bz);
                        }

                        --var10.field_77994_a;
                        if(var10.field_77994_a <= 0) {
                           p_149727_5_.field_71071_by.func_70299_a(p_149727_5_.field_71071_by.field_70461_c, (ItemStack)null);
                        }
                     }

                     this.func_150024_a(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, var12 - 1);
                  }
               } else if(var12 > 0 && var10.func_77973_b() instanceof ItemArmor && ((ItemArmor)var10.func_77973_b()).func_82812_d() == ItemArmor.ArmorMaterial.CLOTH) {
                  ItemArmor var14 = (ItemArmor)var10.func_77973_b();
                  var14.func_82815_c(var10);
                  this.func_150024_a(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, var12 - 1);
                  return true;
               }

               return false;
            }
         }
      }
   }

   public void func_150024_a(World p_150024_1_, int p_150024_2_, int p_150024_3_, int p_150024_4_, int p_150024_5_) {
      p_150024_1_.func_72921_c(p_150024_2_, p_150024_3_, p_150024_4_, MathHelper.func_76125_a(p_150024_5_, 0, 3), 2);
      p_150024_1_.func_147453_f(p_150024_2_, p_150024_3_, p_150024_4_, this);
   }

   public void func_149639_l(World p_149639_1_, int p_149639_2_, int p_149639_3_, int p_149639_4_) {
      if(p_149639_1_.field_73012_v.nextInt(20) == 1) {
         int var5 = p_149639_1_.func_72805_g(p_149639_2_, p_149639_3_, p_149639_4_);
         if(var5 < 3) {
            p_149639_1_.func_72921_c(p_149639_2_, p_149639_3_, p_149639_4_, var5 + 1, 2);
         }

      }
   }

   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
      return Items.field_151066_bu;
   }

   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
      return Items.field_151066_bu;
   }

   public boolean func_149740_M() {
      return true;
   }

   public int func_149736_g(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_) {
      int var6 = p_149736_1_.func_72805_g(p_149736_2_, p_149736_3_, p_149736_4_);
      return func_150027_b(var6);
   }

   public static int func_150027_b(int p_150027_0_) {
      return p_150027_0_;
   }

   public static float func_150025_c(int p_150025_0_) {
      int var1 = MathHelper.func_76125_a(p_150025_0_, 0, 3);
      return (float)(6 + 3 * var1) / 16.0F;
   }
}
