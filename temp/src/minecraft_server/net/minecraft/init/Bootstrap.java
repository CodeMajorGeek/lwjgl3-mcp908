package net.minecraft.init;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockFire;
import net.minecraft.block.material.Material;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class Bootstrap {

   private static boolean field_151355_a = false;
   private static final String __OBFID = "CL_00001397";


   static void func_151353_a() {
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151032_g, new BehaviorProjectileDispense() {

         private static final String __OBFID = "CL_00001398";

         protected IProjectile func_82499_a(World p_82499_1_, IPosition p_82499_2_) {
            EntityArrow var3 = new EntityArrow(p_82499_1_, p_82499_2_.func_82615_a(), p_82499_2_.func_82617_b(), p_82499_2_.func_82616_c());
            var3.field_70251_a = 1;
            return var3;
         }
      });
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151110_aK, new BehaviorProjectileDispense() {

         private static final String __OBFID = "CL_00001404";

         protected IProjectile func_82499_a(World p_82499_1_, IPosition p_82499_2_) {
            return new EntityEgg(p_82499_1_, p_82499_2_.func_82615_a(), p_82499_2_.func_82617_b(), p_82499_2_.func_82616_c());
         }
      });
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151126_ay, new BehaviorProjectileDispense() {

         private static final String __OBFID = "CL_00001405";

         protected IProjectile func_82499_a(World p_82499_1_, IPosition p_82499_2_) {
            return new EntitySnowball(p_82499_1_, p_82499_2_.func_82615_a(), p_82499_2_.func_82617_b(), p_82499_2_.func_82616_c());
         }
      });
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151062_by, new BehaviorProjectileDispense() {

         private static final String __OBFID = "CL_00001406";

         protected IProjectile func_82499_a(World p_82499_1_, IPosition p_82499_2_) {
            return new EntityExpBottle(p_82499_1_, p_82499_2_.func_82615_a(), p_82499_2_.func_82617_b(), p_82499_2_.func_82616_c());
         }
         protected float func_82498_a() {
            return super.func_82498_a() * 0.5F;
         }
         protected float func_82500_b() {
            return super.func_82500_b() * 1.25F;
         }
      });
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151068_bn, new IBehaviorDispenseItem() {

         private final BehaviorDefaultDispenseItem field_150843_b = new BehaviorDefaultDispenseItem();
         private static final String __OBFID = "CL_00001407";

         public ItemStack func_82482_a(IBlockSource p_82482_1_, final ItemStack p_82482_2_) {
            return ItemPotion.func_77831_g(p_82482_2_.func_77960_j())?(new BehaviorProjectileDispense() {

               private static final String __OBFID = "CL_00001408";

               protected IProjectile func_82499_a(World p_82499_1_, IPosition p_82499_2_) {
                  return new EntityPotion(p_82499_1_, p_82499_2_.func_82615_a(), p_82499_2_.func_82617_b(), p_82499_2_.func_82616_c(), p_82482_2_.func_77946_l());
               }
               protected float func_82498_a() {
                  return super.func_82498_a() * 0.5F;
               }
               protected float func_82500_b() {
                  return super.func_82500_b() * 1.25F;
               }
            }).func_82482_a(p_82482_1_, p_82482_2_):this.field_150843_b.func_82482_a(p_82482_1_, p_82482_2_);
         }
      });
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151063_bx, new BehaviorDefaultDispenseItem() {

         private static final String __OBFID = "CL_00001410";

         public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
            EnumFacing var3 = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
            double var4 = p_82487_1_.func_82615_a() + (double)var3.func_82601_c();
            double var6 = (double)((float)p_82487_1_.func_82622_e() + 0.2F);
            double var8 = p_82487_1_.func_82616_c() + (double)var3.func_82599_e();
            Entity var10 = ItemMonsterPlacer.func_77840_a(p_82487_1_.func_82618_k(), p_82487_2_.func_77960_j(), var4, var6, var8);
            if(var10 instanceof EntityLivingBase && p_82487_2_.func_82837_s()) {
               ((EntityLiving)var10).func_94058_c(p_82487_2_.func_82833_r());
            }

            p_82487_2_.func_77979_a(1);
            return p_82487_2_;
         }
      });
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151152_bP, new BehaviorDefaultDispenseItem() {

         private static final String __OBFID = "CL_00001411";

         public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
            EnumFacing var3 = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
            double var4 = p_82487_1_.func_82615_a() + (double)var3.func_82601_c();
            double var6 = (double)((float)p_82487_1_.func_82622_e() + 0.2F);
            double var8 = p_82487_1_.func_82616_c() + (double)var3.func_82599_e();
            EntityFireworkRocket var10 = new EntityFireworkRocket(p_82487_1_.func_82618_k(), var4, var6, var8, p_82487_2_);
            p_82487_1_.func_82618_k().func_72838_d(var10);
            p_82487_2_.func_77979_a(1);
            return p_82487_2_;
         }
         protected void func_82485_a(IBlockSource p_82485_1_) {
            p_82485_1_.func_82618_k().func_72926_e(1002, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
         }
      });
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151059_bz, new BehaviorDefaultDispenseItem() {

         private static final String __OBFID = "CL_00001412";

         public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
            EnumFacing var3 = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
            IPosition var4 = BlockDispenser.func_149939_a(p_82487_1_);
            double var5 = var4.func_82615_a() + (double)((float)var3.func_82601_c() * 0.3F);
            double var7 = var4.func_82617_b() + (double)((float)var3.func_82601_c() * 0.3F);
            double var9 = var4.func_82616_c() + (double)((float)var3.func_82599_e() * 0.3F);
            World var11 = p_82487_1_.func_82618_k();
            Random var12 = var11.field_73012_v;
            double var13 = var12.nextGaussian() * 0.05D + (double)var3.func_82601_c();
            double var15 = var12.nextGaussian() * 0.05D + (double)var3.func_96559_d();
            double var17 = var12.nextGaussian() * 0.05D + (double)var3.func_82599_e();
            var11.func_72838_d(new EntitySmallFireball(var11, var5, var7, var9, var13, var15, var17));
            p_82487_2_.func_77979_a(1);
            return p_82487_2_;
         }
         protected void func_82485_a(IBlockSource p_82485_1_) {
            p_82485_1_.func_82618_k().func_72926_e(1009, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
         }
      });
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151124_az, new BehaviorDefaultDispenseItem() {

         private final BehaviorDefaultDispenseItem field_150842_b = new BehaviorDefaultDispenseItem();
         private static final String __OBFID = "CL_00001413";

         public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
            EnumFacing var3 = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
            World var4 = p_82487_1_.func_82618_k();
            double var5 = p_82487_1_.func_82615_a() + (double)((float)var3.func_82601_c() * 1.125F);
            double var7 = p_82487_1_.func_82617_b() + (double)((float)var3.func_96559_d() * 1.125F);
            double var9 = p_82487_1_.func_82616_c() + (double)((float)var3.func_82599_e() * 1.125F);
            int var11 = p_82487_1_.func_82623_d() + var3.func_82601_c();
            int var12 = p_82487_1_.func_82622_e() + var3.func_96559_d();
            int var13 = p_82487_1_.func_82621_f() + var3.func_82599_e();
            Material var14 = var4.func_147439_a(var11, var12, var13).func_149688_o();
            double var15;
            if(Material.field_151586_h.equals(var14)) {
               var15 = 1.0D;
            } else {
               if(!Material.field_151579_a.equals(var14) || !Material.field_151586_h.equals(var4.func_147439_a(var11, var12 - 1, var13).func_149688_o())) {
                  return this.field_150842_b.func_82482_a(p_82487_1_, p_82487_2_);
               }

               var15 = 0.0D;
            }

            EntityBoat var17 = new EntityBoat(var4, var5, var7 + var15, var9);
            var4.func_72838_d(var17);
            p_82487_2_.func_77979_a(1);
            return p_82487_2_;
         }
         protected void func_82485_a(IBlockSource p_82485_1_) {
            p_82485_1_.func_82618_k().func_72926_e(1000, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
         }
      });
      BehaviorDefaultDispenseItem var0 = new BehaviorDefaultDispenseItem() {

         private final BehaviorDefaultDispenseItem field_150841_b = new BehaviorDefaultDispenseItem();
         private static final String __OBFID = "CL_00001399";

         public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
            ItemBucket var3 = (ItemBucket)p_82487_2_.func_77973_b();
            int var4 = p_82487_1_.func_82623_d();
            int var5 = p_82487_1_.func_82622_e();
            int var6 = p_82487_1_.func_82621_f();
            EnumFacing var7 = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
            if(var3.func_77875_a(p_82487_1_.func_82618_k(), var4 + var7.func_82601_c(), var5 + var7.func_96559_d(), var6 + var7.func_82599_e())) {
               p_82487_2_.func_150996_a(Items.field_151133_ar);
               p_82487_2_.field_77994_a = 1;
               return p_82487_2_;
            } else {
               return this.field_150841_b.func_82482_a(p_82487_1_, p_82487_2_);
            }
         }
      };
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151129_at, var0);
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151131_as, var0);
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151133_ar, new BehaviorDefaultDispenseItem() {

         private final BehaviorDefaultDispenseItem field_150840_b = new BehaviorDefaultDispenseItem();
         private static final String __OBFID = "CL_00001400";

         public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
            EnumFacing var3 = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
            World var4 = p_82487_1_.func_82618_k();
            int var5 = p_82487_1_.func_82623_d() + var3.func_82601_c();
            int var6 = p_82487_1_.func_82622_e() + var3.func_96559_d();
            int var7 = p_82487_1_.func_82621_f() + var3.func_82599_e();
            Material var8 = var4.func_147439_a(var5, var6, var7).func_149688_o();
            int var9 = var4.func_72805_g(var5, var6, var7);
            Item var10;
            if(Material.field_151586_h.equals(var8) && var9 == 0) {
               var10 = Items.field_151131_as;
            } else {
               if(!Material.field_151587_i.equals(var8) || var9 != 0) {
                  return super.func_82487_b(p_82487_1_, p_82487_2_);
               }

               var10 = Items.field_151129_at;
            }

            var4.func_147468_f(var5, var6, var7);
            if(--p_82487_2_.field_77994_a == 0) {
               p_82487_2_.func_150996_a(var10);
               p_82487_2_.field_77994_a = 1;
            } else if(((TileEntityDispenser)p_82487_1_.func_150835_j()).func_146019_a(new ItemStack(var10)) < 0) {
               this.field_150840_b.func_82482_a(p_82487_1_, new ItemStack(var10));
            }

            return p_82487_2_;
         }
      });
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151033_d, new BehaviorDefaultDispenseItem() {

         private boolean field_150839_b = true;
         private static final String __OBFID = "CL_00001401";

         protected ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
            EnumFacing var3 = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
            World var4 = p_82487_1_.func_82618_k();
            int var5 = p_82487_1_.func_82623_d() + var3.func_82601_c();
            int var6 = p_82487_1_.func_82622_e() + var3.func_96559_d();
            int var7 = p_82487_1_.func_82621_f() + var3.func_82599_e();
            if(var4.func_147437_c(var5, var6, var7)) {
               var4.func_147449_b(var5, var6, var7, Blocks.field_150480_ab);
               if(p_82487_2_.func_96631_a(1, var4.field_73012_v)) {
                  p_82487_2_.field_77994_a = 0;
               }
            } else if(var4.func_147439_a(var5, var6, var7) == Blocks.field_150335_W) {
               Blocks.field_150335_W.func_149664_b(var4, var5, var6, var7, 1);
               var4.func_147468_f(var5, var6, var7);
            } else {
               this.field_150839_b = false;
            }

            return p_82487_2_;
         }
         protected void func_82485_a(IBlockSource p_82485_1_) {
            if(this.field_150839_b) {
               p_82485_1_.func_82618_k().func_72926_e(1000, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
            } else {
               p_82485_1_.func_82618_k().func_72926_e(1001, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
            }

         }
      });
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151100_aR, new BehaviorDefaultDispenseItem() {

         private boolean field_150838_b = true;
         private static final String __OBFID = "CL_00001402";

         protected ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
            if(p_82487_2_.func_77960_j() == 15) {
               EnumFacing var3 = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
               World var4 = p_82487_1_.func_82618_k();
               int var5 = p_82487_1_.func_82623_d() + var3.func_82601_c();
               int var6 = p_82487_1_.func_82622_e() + var3.func_96559_d();
               int var7 = p_82487_1_.func_82621_f() + var3.func_82599_e();
               if(ItemDye.func_150919_a(p_82487_2_, var4, var5, var6, var7)) {
                  if(!var4.field_72995_K) {
                     var4.func_72926_e(2005, var5, var6, var7, 0);
                  }
               } else {
                  this.field_150838_b = false;
               }

               return p_82487_2_;
            } else {
               return super.func_82487_b(p_82487_1_, p_82487_2_);
            }
         }
         protected void func_82485_a(IBlockSource p_82485_1_) {
            if(this.field_150838_b) {
               p_82485_1_.func_82618_k().func_72926_e(1000, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
            } else {
               p_82485_1_.func_82618_k().func_72926_e(1001, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
            }

         }
      });
      BlockDispenser.field_149943_a.func_82595_a(Item.func_150898_a(Blocks.field_150335_W), new BehaviorDefaultDispenseItem() {

         private static final String __OBFID = "CL_00001403";

         protected ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
            EnumFacing var3 = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
            World var4 = p_82487_1_.func_82618_k();
            int var5 = p_82487_1_.func_82623_d() + var3.func_82601_c();
            int var6 = p_82487_1_.func_82622_e() + var3.func_96559_d();
            int var7 = p_82487_1_.func_82621_f() + var3.func_82599_e();
            EntityTNTPrimed var8 = new EntityTNTPrimed(var4, (double)((float)var5 + 0.5F), (double)((float)var6 + 0.5F), (double)((float)var7 + 0.5F), (EntityLivingBase)null);
            var4.func_72838_d(var8);
            --p_82487_2_.field_77994_a;
            return p_82487_2_;
         }
      });
   }

   public static void func_151354_b() {
      if(!field_151355_a) {
         field_151355_a = true;
         Block.func_149671_p();
         BlockFire.func_149843_e();
         Item.func_150900_l();
         StatList.func_151178_a();
         func_151353_a();
      }
   }

}
