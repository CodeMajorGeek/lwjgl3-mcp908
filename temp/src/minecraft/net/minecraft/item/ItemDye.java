package net.minecraft.item;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockLog;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemDye extends Item {

   public static final String[] field_150923_a = new String[]{"black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", "lime", "yellow", "lightBlue", "magenta", "orange", "white"};
   public static final String[] field_150921_b = new String[]{"black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", "lime", "yellow", "light_blue", "magenta", "orange", "white"};
   public static final int[] field_150922_c = new int[]{1973019, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 11250603, 4408131, 14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 15790320};
   private IIcon[] field_150920_d;
   private static final String __OBFID = "CL_00000022";


   public ItemDye() {
      this.func_77627_a(true);
      this.func_77656_e(0);
      this.func_77637_a(CreativeTabs.field_78035_l);
   }

   public IIcon func_77617_a(int p_77617_1_) {
      int var2 = MathHelper.func_76125_a(p_77617_1_, 0, 15);
      return this.field_150920_d[var2];
   }

   public String func_77667_c(ItemStack p_77667_1_) {
      int var2 = MathHelper.func_76125_a(p_77667_1_.func_77960_j(), 0, 15);
      return super.func_77658_a() + "." + field_150923_a[var2];
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      if(!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) {
         return false;
      } else {
         if(p_77648_1_.func_77960_j() == 15) {
            if(func_150919_a(p_77648_1_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_)) {
               if(!p_77648_3_.field_72995_K) {
                  p_77648_3_.func_72926_e(2005, p_77648_4_, p_77648_5_, p_77648_6_, 0);
               }

               return true;
            }
         } else if(p_77648_1_.func_77960_j() == 3) {
            Block var11 = p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_);
            int var12 = p_77648_3_.func_72805_g(p_77648_4_, p_77648_5_, p_77648_6_);
            if(var11 == Blocks.field_150364_r && BlockLog.func_150165_c(var12) == 3) {
               if(p_77648_7_ == 0) {
                  return false;
               }

               if(p_77648_7_ == 1) {
                  return false;
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

               if(p_77648_3_.func_147437_c(p_77648_4_, p_77648_5_, p_77648_6_)) {
                  int var13 = Blocks.field_150375_by.func_149660_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_, 0);
                  p_77648_3_.func_147465_d(p_77648_4_, p_77648_5_, p_77648_6_, Blocks.field_150375_by, var13, 2);
                  if(!p_77648_2_.field_71075_bZ.field_75098_d) {
                     --p_77648_1_.field_77994_a;
                  }
               }

               return true;
            }
         }

         return false;
      }
   }

   public static boolean func_150919_a(ItemStack p_150919_0_, World p_150919_1_, int p_150919_2_, int p_150919_3_, int p_150919_4_) {
      Block var5 = p_150919_1_.func_147439_a(p_150919_2_, p_150919_3_, p_150919_4_);
      if(var5 instanceof IGrowable) {
         IGrowable var6 = (IGrowable)var5;
         if(var6.func_149851_a(p_150919_1_, p_150919_2_, p_150919_3_, p_150919_4_, p_150919_1_.field_72995_K)) {
            if(!p_150919_1_.field_72995_K) {
               if(var6.func_149852_a(p_150919_1_, p_150919_1_.field_73012_v, p_150919_2_, p_150919_3_, p_150919_4_)) {
                  var6.func_149853_b(p_150919_1_, p_150919_1_.field_73012_v, p_150919_2_, p_150919_3_, p_150919_4_);
               }

               --p_150919_0_.field_77994_a;
            }

            return true;
         }
      }

      return false;
   }

   public static void func_150918_a(World p_150918_0_, int p_150918_1_, int p_150918_2_, int p_150918_3_, int p_150918_4_) {
      if(p_150918_4_ == 0) {
         p_150918_4_ = 15;
      }

      Block var5 = p_150918_0_.func_147439_a(p_150918_1_, p_150918_2_, p_150918_3_);
      if(var5.func_149688_o() != Material.field_151579_a) {
         var5.func_149719_a(p_150918_0_, p_150918_1_, p_150918_2_, p_150918_3_);

         for(int var6 = 0; var6 < p_150918_4_; ++var6) {
            double var7 = field_77697_d.nextGaussian() * 0.02D;
            double var9 = field_77697_d.nextGaussian() * 0.02D;
            double var11 = field_77697_d.nextGaussian() * 0.02D;
            p_150918_0_.func_72869_a("happyVillager", (double)((float)p_150918_1_ + field_77697_d.nextFloat()), (double)p_150918_2_ + (double)field_77697_d.nextFloat() * var5.func_149669_A(), (double)((float)p_150918_3_ + field_77697_d.nextFloat()), var7, var9, var11);
         }

      }
   }

   public boolean func_111207_a(ItemStack p_111207_1_, EntityPlayer p_111207_2_, EntityLivingBase p_111207_3_) {
      if(p_111207_3_ instanceof EntitySheep) {
         EntitySheep var4 = (EntitySheep)p_111207_3_;
         int var5 = BlockColored.func_150032_b(p_111207_1_.func_77960_j());
         if(!var4.func_70892_o() && var4.func_70896_n() != var5) {
            var4.func_70891_b(var5);
            --p_111207_1_.field_77994_a;
         }

         return true;
      } else {
         return false;
      }
   }

   public void func_150895_a(Item p_150895_1_, CreativeTabs p_150895_2_, List p_150895_3_) {
      for(int var4 = 0; var4 < 16; ++var4) {
         p_150895_3_.add(new ItemStack(p_150895_1_, 1, var4));
      }

   }

   public void func_94581_a(IIconRegister p_94581_1_) {
      this.field_150920_d = new IIcon[field_150921_b.length];

      for(int var2 = 0; var2 < field_150921_b.length; ++var2) {
         this.field_150920_d[var2] = p_94581_1_.func_94245_a(this.func_111208_A() + "_" + field_150921_b[var2]);
      }

   }

}
