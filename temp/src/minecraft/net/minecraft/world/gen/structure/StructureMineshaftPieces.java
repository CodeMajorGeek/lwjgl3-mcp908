package net.minecraft.world.gen.structure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class StructureMineshaftPieces {

   private static final WeightedRandomChestContent[] field_78818_a = new WeightedRandomChestContent[]{new WeightedRandomChestContent(Items.field_151042_j, 0, 1, 5, 10), new WeightedRandomChestContent(Items.field_151043_k, 0, 1, 3, 5), new WeightedRandomChestContent(Items.field_151137_ax, 0, 4, 9, 5), new WeightedRandomChestContent(Items.field_151100_aR, 4, 4, 9, 5), new WeightedRandomChestContent(Items.field_151045_i, 0, 1, 2, 3), new WeightedRandomChestContent(Items.field_151044_h, 0, 3, 8, 10), new WeightedRandomChestContent(Items.field_151025_P, 0, 1, 3, 15), new WeightedRandomChestContent(Items.field_151035_b, 0, 1, 1, 1), new WeightedRandomChestContent(Item.func_150898_a(Blocks.field_150448_aq), 0, 4, 8, 1), new WeightedRandomChestContent(Items.field_151081_bc, 0, 2, 4, 10), new WeightedRandomChestContent(Items.field_151080_bb, 0, 2, 4, 10), new WeightedRandomChestContent(Items.field_151141_av, 0, 1, 1, 3), new WeightedRandomChestContent(Items.field_151138_bX, 0, 1, 1, 1)};
   private static final String __OBFID = "CL_00000444";


   public static void func_143048_a() {
      MapGenStructureIO.func_143031_a(StructureMineshaftPieces.Corridor.class, "MSCorridor");
      MapGenStructureIO.func_143031_a(StructureMineshaftPieces.Cross.class, "MSCrossing");
      MapGenStructureIO.func_143031_a(StructureMineshaftPieces.Room.class, "MSRoom");
      MapGenStructureIO.func_143031_a(StructureMineshaftPieces.Stairs.class, "MSStairs");
   }

   private static StructureComponent func_78815_a(List p_78815_0_, Random p_78815_1_, int p_78815_2_, int p_78815_3_, int p_78815_4_, int p_78815_5_, int p_78815_6_) {
      int var7 = p_78815_1_.nextInt(100);
      StructureBoundingBox var8;
      if(var7 >= 80) {
         var8 = StructureMineshaftPieces.Cross.func_74951_a(p_78815_0_, p_78815_1_, p_78815_2_, p_78815_3_, p_78815_4_, p_78815_5_);
         if(var8 != null) {
            return new StructureMineshaftPieces.Cross(p_78815_6_, p_78815_1_, var8, p_78815_5_);
         }
      } else if(var7 >= 70) {
         var8 = StructureMineshaftPieces.Stairs.func_74950_a(p_78815_0_, p_78815_1_, p_78815_2_, p_78815_3_, p_78815_4_, p_78815_5_);
         if(var8 != null) {
            return new StructureMineshaftPieces.Stairs(p_78815_6_, p_78815_1_, var8, p_78815_5_);
         }
      } else {
         var8 = StructureMineshaftPieces.Corridor.func_74954_a(p_78815_0_, p_78815_1_, p_78815_2_, p_78815_3_, p_78815_4_, p_78815_5_);
         if(var8 != null) {
            return new StructureMineshaftPieces.Corridor(p_78815_6_, p_78815_1_, var8, p_78815_5_);
         }
      }

      return null;
   }

   private static StructureComponent func_78817_b(StructureComponent p_78817_0_, List p_78817_1_, Random p_78817_2_, int p_78817_3_, int p_78817_4_, int p_78817_5_, int p_78817_6_, int p_78817_7_) {
      if(p_78817_7_ > 8) {
         return null;
      } else if(Math.abs(p_78817_3_ - p_78817_0_.func_74874_b().field_78897_a) <= 80 && Math.abs(p_78817_5_ - p_78817_0_.func_74874_b().field_78896_c) <= 80) {
         StructureComponent var8 = func_78815_a(p_78817_1_, p_78817_2_, p_78817_3_, p_78817_4_, p_78817_5_, p_78817_6_, p_78817_7_ + 1);
         if(var8 != null) {
            p_78817_1_.add(var8);
            var8.func_74861_a(p_78817_0_, p_78817_1_, p_78817_2_);
         }

         return var8;
      } else {
         return null;
      }
   }


   public static class Corridor extends StructureComponent {

      private boolean field_74958_a;
      private boolean field_74956_b;
      private boolean field_74957_c;
      private int field_74955_d;
      private static final String __OBFID = "CL_00000445";


      public Corridor() {}

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         p_143012_1_.func_74757_a("hr", this.field_74958_a);
         p_143012_1_.func_74757_a("sc", this.field_74956_b);
         p_143012_1_.func_74757_a("hps", this.field_74957_c);
         p_143012_1_.func_74768_a("Num", this.field_74955_d);
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         this.field_74958_a = p_143011_1_.func_74767_n("hr");
         this.field_74956_b = p_143011_1_.func_74767_n("sc");
         this.field_74957_c = p_143011_1_.func_74767_n("hps");
         this.field_74955_d = p_143011_1_.func_74762_e("Num");
      }

      public Corridor(int p_i2035_1_, Random p_i2035_2_, StructureBoundingBox p_i2035_3_, int p_i2035_4_) {
         super(p_i2035_1_);
         this.field_74885_f = p_i2035_4_;
         this.field_74887_e = p_i2035_3_;
         this.field_74958_a = p_i2035_2_.nextInt(3) == 0;
         this.field_74956_b = !this.field_74958_a && p_i2035_2_.nextInt(23) == 0;
         if(this.field_74885_f != 2 && this.field_74885_f != 0) {
            this.field_74955_d = p_i2035_3_.func_78883_b() / 5;
         } else {
            this.field_74955_d = p_i2035_3_.func_78880_d() / 5;
         }

      }

      public static StructureBoundingBox func_74954_a(List p_74954_0_, Random p_74954_1_, int p_74954_2_, int p_74954_3_, int p_74954_4_, int p_74954_5_) {
         StructureBoundingBox var6 = new StructureBoundingBox(p_74954_2_, p_74954_3_, p_74954_4_, p_74954_2_, p_74954_3_ + 2, p_74954_4_);

         int var7;
         for(var7 = p_74954_1_.nextInt(3) + 2; var7 > 0; --var7) {
            int var8 = var7 * 5;
            switch(p_74954_5_) {
            case 0:
               var6.field_78893_d = p_74954_2_ + 2;
               var6.field_78892_f = p_74954_4_ + (var8 - 1);
               break;
            case 1:
               var6.field_78897_a = p_74954_2_ - (var8 - 1);
               var6.field_78892_f = p_74954_4_ + 2;
               break;
            case 2:
               var6.field_78893_d = p_74954_2_ + 2;
               var6.field_78896_c = p_74954_4_ - (var8 - 1);
               break;
            case 3:
               var6.field_78893_d = p_74954_2_ + (var8 - 1);
               var6.field_78892_f = p_74954_4_ + 2;
            }

            if(StructureComponent.func_74883_a(p_74954_0_, var6) == null) {
               break;
            }
         }

         return var7 > 0?var6:null;
      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         int var4 = this.func_74877_c();
         int var5 = p_74861_3_.nextInt(4);
         switch(this.field_74885_f) {
         case 0:
            if(var5 <= 1) {
               StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78892_f + 1, this.field_74885_f, var4);
            } else if(var5 == 2) {
               StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78892_f - 3, 1, var4);
            } else {
               StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78892_f - 3, 3, var4);
            }
            break;
         case 1:
            if(var5 <= 1) {
               StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c, this.field_74885_f, var4);
            } else if(var5 == 2) {
               StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c - 1, 2, var4);
            } else {
               StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78892_f + 1, 0, var4);
            }
            break;
         case 2:
            if(var5 <= 1) {
               StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c - 1, this.field_74885_f, var4);
            } else if(var5 == 2) {
               StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c, 1, var4);
            } else {
               StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c, 3, var4);
            }
            break;
         case 3:
            if(var5 <= 1) {
               StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c, this.field_74885_f, var4);
            } else if(var5 == 2) {
               StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d - 3, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c - 1, 2, var4);
            } else {
               StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d - 3, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78892_f + 1, 0, var4);
            }
         }

         if(var4 < 8) {
            int var6;
            int var7;
            if(this.field_74885_f != 2 && this.field_74885_f != 0) {
               for(var6 = this.field_74887_e.field_78897_a + 3; var6 + 3 <= this.field_74887_e.field_78893_d; var6 += 5) {
                  var7 = p_74861_3_.nextInt(5);
                  if(var7 == 0) {
                     StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, var6, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, 2, var4 + 1);
                  } else if(var7 == 1) {
                     StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, var6, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, 0, var4 + 1);
                  }
               }
            } else {
               for(var6 = this.field_74887_e.field_78896_c + 3; var6 + 3 <= this.field_74887_e.field_78892_f; var6 += 5) {
                  var7 = p_74861_3_.nextInt(5);
                  if(var7 == 0) {
                     StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, var6, 1, var4 + 1);
                  } else if(var7 == 1) {
                     StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, var6, 3, var4 + 1);
                  }
               }
            }
         }

      }

      protected boolean func_74879_a(World p_74879_1_, StructureBoundingBox p_74879_2_, Random p_74879_3_, int p_74879_4_, int p_74879_5_, int p_74879_6_, WeightedRandomChestContent[] p_74879_7_, int p_74879_8_) {
         int var9 = this.func_74865_a(p_74879_4_, p_74879_6_);
         int var10 = this.func_74862_a(p_74879_5_);
         int var11 = this.func_74873_b(p_74879_4_, p_74879_6_);
         if(p_74879_2_.func_78890_b(var9, var10, var11) && p_74879_1_.func_147439_a(var9, var10, var11).func_149688_o() == Material.field_151579_a) {
            int var12 = p_74879_3_.nextBoolean()?1:0;
            p_74879_1_.func_147465_d(var9, var10, var11, Blocks.field_150448_aq, this.func_151555_a(Blocks.field_150448_aq, var12), 2);
            EntityMinecartChest var13 = new EntityMinecartChest(p_74879_1_, (double)((float)var9 + 0.5F), (double)((float)var10 + 0.5F), (double)((float)var11 + 0.5F));
            WeightedRandomChestContent.func_76293_a(p_74879_3_, p_74879_7_, var13, p_74879_8_);
            p_74879_1_.func_72838_d(var13);
            return true;
         } else {
            return false;
         }
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            boolean var4 = false;
            boolean var5 = true;
            boolean var6 = false;
            boolean var7 = true;
            int var8 = this.field_74955_d * 5 - 1;
            this.func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 2, 1, var8, Blocks.field_150350_a, Blocks.field_150350_a, false);
            this.func_151551_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.8F, 0, 2, 0, 2, 2, var8, Blocks.field_150350_a, Blocks.field_150350_a, false);
            if(this.field_74956_b) {
               this.func_151551_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.6F, 0, 0, 0, 2, 1, var8, Blocks.field_150321_G, Blocks.field_150350_a, false);
            }

            int var9;
            int var10;
            for(var9 = 0; var9 < this.field_74955_d; ++var9) {
               var10 = 2 + var9 * 5;
               this.func_151549_a(p_74875_1_, p_74875_3_, 0, 0, var10, 0, 1, var10, Blocks.field_150422_aJ, Blocks.field_150350_a, false);
               this.func_151549_a(p_74875_1_, p_74875_3_, 2, 0, var10, 2, 1, var10, Blocks.field_150422_aJ, Blocks.field_150350_a, false);
               if(p_74875_2_.nextInt(4) == 0) {
                  this.func_151549_a(p_74875_1_, p_74875_3_, 0, 2, var10, 0, 2, var10, Blocks.field_150344_f, Blocks.field_150350_a, false);
                  this.func_151549_a(p_74875_1_, p_74875_3_, 2, 2, var10, 2, 2, var10, Blocks.field_150344_f, Blocks.field_150350_a, false);
               } else {
                  this.func_151549_a(p_74875_1_, p_74875_3_, 0, 2, var10, 2, 2, var10, Blocks.field_150344_f, Blocks.field_150350_a, false);
               }

               this.func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 0, 2, var10 - 1, Blocks.field_150321_G, 0);
               this.func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 2, 2, var10 - 1, Blocks.field_150321_G, 0);
               this.func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 0, 2, var10 + 1, Blocks.field_150321_G, 0);
               this.func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 2, 2, var10 + 1, Blocks.field_150321_G, 0);
               this.func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 0, 2, var10 - 2, Blocks.field_150321_G, 0);
               this.func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 2, 2, var10 - 2, Blocks.field_150321_G, 0);
               this.func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 0, 2, var10 + 2, Blocks.field_150321_G, 0);
               this.func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 2, 2, var10 + 2, Blocks.field_150321_G, 0);
               this.func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 1, 2, var10 - 1, Blocks.field_150478_aa, 0);
               this.func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 1, 2, var10 + 1, Blocks.field_150478_aa, 0);
               if(p_74875_2_.nextInt(100) == 0) {
                  this.func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 2, 0, var10 - 1, WeightedRandomChestContent.func_92080_a(StructureMineshaftPieces.field_78818_a, new WeightedRandomChestContent[]{Items.field_151134_bR.func_92114_b(p_74875_2_)}), 3 + p_74875_2_.nextInt(4));
               }

               if(p_74875_2_.nextInt(100) == 0) {
                  this.func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 0, 0, var10 + 1, WeightedRandomChestContent.func_92080_a(StructureMineshaftPieces.field_78818_a, new WeightedRandomChestContent[]{Items.field_151134_bR.func_92114_b(p_74875_2_)}), 3 + p_74875_2_.nextInt(4));
               }

               if(this.field_74956_b && !this.field_74957_c) {
                  int var11 = this.func_74862_a(0);
                  int var12 = var10 - 1 + p_74875_2_.nextInt(3);
                  int var13 = this.func_74865_a(1, var12);
                  var12 = this.func_74873_b(1, var12);
                  if(p_74875_3_.func_78890_b(var13, var11, var12)) {
                     this.field_74957_c = true;
                     p_74875_1_.func_147465_d(var13, var11, var12, Blocks.field_150474_ac, 0, 2);
                     TileEntityMobSpawner var14 = (TileEntityMobSpawner)p_74875_1_.func_147438_o(var13, var11, var12);
                     if(var14 != null) {
                        var14.func_145881_a().func_98272_a("CaveSpider");
                     }
                  }
               }
            }

            for(var9 = 0; var9 <= 2; ++var9) {
               for(var10 = 0; var10 <= var8; ++var10) {
                  byte var16 = -1;
                  Block var17 = this.func_151548_a(p_74875_1_, var9, var16, var10, p_74875_3_);
                  if(var17.func_149688_o() == Material.field_151579_a) {
                     byte var18 = -1;
                     this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, var9, var18, var10, p_74875_3_);
                  }
               }
            }

            if(this.field_74958_a) {
               for(var9 = 0; var9 <= var8; ++var9) {
                  Block var15 = this.func_151548_a(p_74875_1_, 1, -1, var9, p_74875_3_);
                  if(var15.func_149688_o() != Material.field_151579_a && var15.func_149730_j()) {
                     this.func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.7F, 1, 0, var9, Blocks.field_150448_aq, this.func_151555_a(Blocks.field_150448_aq, 0));
                  }
               }
            }

            return true;
         }
      }
   }

   public static class Cross extends StructureComponent {

      private int field_74953_a;
      private boolean field_74952_b;
      private static final String __OBFID = "CL_00000446";


      public Cross() {}

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         p_143012_1_.func_74757_a("tf", this.field_74952_b);
         p_143012_1_.func_74768_a("D", this.field_74953_a);
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         this.field_74952_b = p_143011_1_.func_74767_n("tf");
         this.field_74953_a = p_143011_1_.func_74762_e("D");
      }

      public Cross(int p_i2036_1_, Random p_i2036_2_, StructureBoundingBox p_i2036_3_, int p_i2036_4_) {
         super(p_i2036_1_);
         this.field_74953_a = p_i2036_4_;
         this.field_74887_e = p_i2036_3_;
         this.field_74952_b = p_i2036_3_.func_78882_c() > 3;
      }

      public static StructureBoundingBox func_74951_a(List p_74951_0_, Random p_74951_1_, int p_74951_2_, int p_74951_3_, int p_74951_4_, int p_74951_5_) {
         StructureBoundingBox var6 = new StructureBoundingBox(p_74951_2_, p_74951_3_, p_74951_4_, p_74951_2_, p_74951_3_ + 2, p_74951_4_);
         if(p_74951_1_.nextInt(4) == 0) {
            var6.field_78894_e += 4;
         }

         switch(p_74951_5_) {
         case 0:
            var6.field_78897_a = p_74951_2_ - 1;
            var6.field_78893_d = p_74951_2_ + 3;
            var6.field_78892_f = p_74951_4_ + 4;
            break;
         case 1:
            var6.field_78897_a = p_74951_2_ - 4;
            var6.field_78896_c = p_74951_4_ - 1;
            var6.field_78892_f = p_74951_4_ + 3;
            break;
         case 2:
            var6.field_78897_a = p_74951_2_ - 1;
            var6.field_78893_d = p_74951_2_ + 3;
            var6.field_78896_c = p_74951_4_ - 4;
            break;
         case 3:
            var6.field_78893_d = p_74951_2_ + 4;
            var6.field_78896_c = p_74951_4_ - 1;
            var6.field_78892_f = p_74951_4_ + 3;
         }

         return StructureComponent.func_74883_a(p_74951_0_, var6) != null?null:var6;
      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         int var4 = this.func_74877_c();
         switch(this.field_74953_a) {
         case 0:
            StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, 0, var4);
            StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, 1, var4);
            StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, 3, var4);
            break;
         case 1:
            StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, 2, var4);
            StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, 0, var4);
            StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, 1, var4);
            break;
         case 2:
            StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, 2, var4);
            StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, 1, var4);
            StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, 3, var4);
            break;
         case 3:
            StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, 2, var4);
            StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, 0, var4);
            StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, 3, var4);
         }

         if(this.field_74952_b) {
            if(p_74861_3_.nextBoolean()) {
               StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b + 3 + 1, this.field_74887_e.field_78896_c - 1, 2, var4);
            }

            if(p_74861_3_.nextBoolean()) {
               StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + 3 + 1, this.field_74887_e.field_78896_c + 1, 1, var4);
            }

            if(p_74861_3_.nextBoolean()) {
               StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + 3 + 1, this.field_74887_e.field_78896_c + 1, 3, var4);
            }

            if(p_74861_3_.nextBoolean()) {
               StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b + 3 + 1, this.field_74887_e.field_78892_f + 1, 0, var4);
            }
         }

      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            if(this.field_74952_b) {
               this.func_151549_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78895_b + 3 - 1, this.field_74887_e.field_78892_f, Blocks.field_150350_a, Blocks.field_150350_a, false);
               this.func_151549_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, this.field_74887_e.field_78893_d, this.field_74887_e.field_78895_b + 3 - 1, this.field_74887_e.field_78892_f - 1, Blocks.field_150350_a, Blocks.field_150350_a, false);
               this.func_151549_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78894_e - 2, this.field_74887_e.field_78896_c, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f, Blocks.field_150350_a, Blocks.field_150350_a, false);
               this.func_151549_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78894_e - 2, this.field_74887_e.field_78896_c + 1, this.field_74887_e.field_78893_d, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f - 1, Blocks.field_150350_a, Blocks.field_150350_a, false);
               this.func_151549_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b + 3, this.field_74887_e.field_78896_c + 1, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78895_b + 3, this.field_74887_e.field_78892_f - 1, Blocks.field_150350_a, Blocks.field_150350_a, false);
            } else {
               this.func_151549_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f, Blocks.field_150350_a, Blocks.field_150350_a, false);
               this.func_151549_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, this.field_74887_e.field_78893_d, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f - 1, Blocks.field_150350_a, Blocks.field_150350_a, false);
            }

            this.func_151549_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78894_e, this.field_74887_e.field_78896_c + 1, Blocks.field_150344_f, Blocks.field_150350_a, false);
            this.func_151549_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f - 1, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f - 1, Blocks.field_150344_f, Blocks.field_150350_a, false);
            this.func_151549_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78894_e, this.field_74887_e.field_78896_c + 1, Blocks.field_150344_f, Blocks.field_150350_a, false);
            this.func_151549_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f - 1, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f - 1, Blocks.field_150344_f, Blocks.field_150350_a, false);

            for(int var4 = this.field_74887_e.field_78897_a; var4 <= this.field_74887_e.field_78893_d; ++var4) {
               for(int var5 = this.field_74887_e.field_78896_c; var5 <= this.field_74887_e.field_78892_f; ++var5) {
                  if(this.func_151548_a(p_74875_1_, var4, this.field_74887_e.field_78895_b - 1, var5, p_74875_3_).func_149688_o() == Material.field_151579_a) {
                     this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, var4, this.field_74887_e.field_78895_b - 1, var5, p_74875_3_);
                  }
               }
            }

            return true;
         }
      }
   }

   public static class Room extends StructureComponent {

      private List field_74949_a = new LinkedList();
      private static final String __OBFID = "CL_00000447";


      public Room() {}

      public Room(int p_i2037_1_, Random p_i2037_2_, int p_i2037_3_, int p_i2037_4_) {
         super(p_i2037_1_);
         this.field_74887_e = new StructureBoundingBox(p_i2037_3_, 50, p_i2037_4_, p_i2037_3_ + 7 + p_i2037_2_.nextInt(6), 54 + p_i2037_2_.nextInt(6), p_i2037_4_ + 7 + p_i2037_2_.nextInt(6));
      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         int var4 = this.func_74877_c();
         int var6 = this.field_74887_e.func_78882_c() - 3 - 1;
         if(var6 <= 0) {
            var6 = 1;
         }

         int var5;
         StructureComponent var7;
         StructureBoundingBox var8;
         for(var5 = 0; var5 < this.field_74887_e.func_78883_b(); var5 += 4) {
            var5 += p_74861_3_.nextInt(this.field_74887_e.func_78883_b());
            if(var5 + 3 > this.field_74887_e.func_78883_b()) {
               break;
            }

            var7 = StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + var5, this.field_74887_e.field_78895_b + p_74861_3_.nextInt(var6) + 1, this.field_74887_e.field_78896_c - 1, 2, var4);
            if(var7 != null) {
               var8 = var7.func_74874_b();
               this.field_74949_a.add(new StructureBoundingBox(var8.field_78897_a, var8.field_78895_b, this.field_74887_e.field_78896_c, var8.field_78893_d, var8.field_78894_e, this.field_74887_e.field_78896_c + 1));
            }
         }

         for(var5 = 0; var5 < this.field_74887_e.func_78883_b(); var5 += 4) {
            var5 += p_74861_3_.nextInt(this.field_74887_e.func_78883_b());
            if(var5 + 3 > this.field_74887_e.func_78883_b()) {
               break;
            }

            var7 = StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + var5, this.field_74887_e.field_78895_b + p_74861_3_.nextInt(var6) + 1, this.field_74887_e.field_78892_f + 1, 0, var4);
            if(var7 != null) {
               var8 = var7.func_74874_b();
               this.field_74949_a.add(new StructureBoundingBox(var8.field_78897_a, var8.field_78895_b, this.field_74887_e.field_78892_f - 1, var8.field_78893_d, var8.field_78894_e, this.field_74887_e.field_78892_f));
            }
         }

         for(var5 = 0; var5 < this.field_74887_e.func_78880_d(); var5 += 4) {
            var5 += p_74861_3_.nextInt(this.field_74887_e.func_78880_d());
            if(var5 + 3 > this.field_74887_e.func_78880_d()) {
               break;
            }

            var7 = StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74861_3_.nextInt(var6) + 1, this.field_74887_e.field_78896_c + var5, 1, var4);
            if(var7 != null) {
               var8 = var7.func_74874_b();
               this.field_74949_a.add(new StructureBoundingBox(this.field_74887_e.field_78897_a, var8.field_78895_b, var8.field_78896_c, this.field_74887_e.field_78897_a + 1, var8.field_78894_e, var8.field_78892_f));
            }
         }

         for(var5 = 0; var5 < this.field_74887_e.func_78880_d(); var5 += 4) {
            var5 += p_74861_3_.nextInt(this.field_74887_e.func_78880_d());
            if(var5 + 3 > this.field_74887_e.func_78880_d()) {
               break;
            }

            var7 = StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74861_3_.nextInt(var6) + 1, this.field_74887_e.field_78896_c + var5, 3, var4);
            if(var7 != null) {
               var8 = var7.func_74874_b();
               this.field_74949_a.add(new StructureBoundingBox(this.field_74887_e.field_78893_d - 1, var8.field_78895_b, var8.field_78896_c, this.field_74887_e.field_78893_d, var8.field_78894_e, var8.field_78892_f));
            }
         }

      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            this.func_151549_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, this.field_74887_e.field_78893_d, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f, Blocks.field_150346_d, Blocks.field_150350_a, true);
            this.func_151549_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b + 1, this.field_74887_e.field_78896_c, this.field_74887_e.field_78893_d, Math.min(this.field_74887_e.field_78895_b + 3, this.field_74887_e.field_78894_e), this.field_74887_e.field_78892_f, Blocks.field_150350_a, Blocks.field_150350_a, false);
            Iterator var4 = this.field_74949_a.iterator();

            while(var4.hasNext()) {
               StructureBoundingBox var5 = (StructureBoundingBox)var4.next();
               this.func_151549_a(p_74875_1_, p_74875_3_, var5.field_78897_a, var5.field_78894_e - 2, var5.field_78896_c, var5.field_78893_d, var5.field_78894_e, var5.field_78892_f, Blocks.field_150350_a, Blocks.field_150350_a, false);
            }

            this.func_151547_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b + 4, this.field_74887_e.field_78896_c, this.field_74887_e.field_78893_d, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f, Blocks.field_150350_a, false);
            return true;
         }
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         NBTTagList var2 = new NBTTagList();
         Iterator var3 = this.field_74949_a.iterator();

         while(var3.hasNext()) {
            StructureBoundingBox var4 = (StructureBoundingBox)var3.next();
            var2.func_74742_a(var4.func_151535_h());
         }

         p_143012_1_.func_74782_a("Entrances", var2);
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         NBTTagList var2 = p_143011_1_.func_150295_c("Entrances", 11);

         for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
            this.field_74949_a.add(new StructureBoundingBox(var2.func_150306_c(var3)));
         }

      }
   }

   public static class Stairs extends StructureComponent {

      private static final String __OBFID = "CL_00000449";


      public Stairs() {}

      public Stairs(int p_i2038_1_, Random p_i2038_2_, StructureBoundingBox p_i2038_3_, int p_i2038_4_) {
         super(p_i2038_1_);
         this.field_74885_f = p_i2038_4_;
         this.field_74887_e = p_i2038_3_;
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {}

      protected void func_143011_b(NBTTagCompound p_143011_1_) {}

      public static StructureBoundingBox func_74950_a(List p_74950_0_, Random p_74950_1_, int p_74950_2_, int p_74950_3_, int p_74950_4_, int p_74950_5_) {
         StructureBoundingBox var6 = new StructureBoundingBox(p_74950_2_, p_74950_3_ - 5, p_74950_4_, p_74950_2_, p_74950_3_ + 2, p_74950_4_);
         switch(p_74950_5_) {
         case 0:
            var6.field_78893_d = p_74950_2_ + 2;
            var6.field_78892_f = p_74950_4_ + 8;
            break;
         case 1:
            var6.field_78897_a = p_74950_2_ - 8;
            var6.field_78892_f = p_74950_4_ + 2;
            break;
         case 2:
            var6.field_78893_d = p_74950_2_ + 2;
            var6.field_78896_c = p_74950_4_ - 8;
            break;
         case 3:
            var6.field_78893_d = p_74950_2_ + 8;
            var6.field_78892_f = p_74950_4_ + 2;
         }

         return StructureComponent.func_74883_a(p_74950_0_, var6) != null?null:var6;
      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         int var4 = this.func_74877_c();
         switch(this.field_74885_f) {
         case 0:
            StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, 0, var4);
            break;
         case 1:
            StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, 1, var4);
            break;
         case 2:
            StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, 2, var4);
            break;
         case 3:
            StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, 3, var4);
         }

      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            this.func_151549_a(p_74875_1_, p_74875_3_, 0, 5, 0, 2, 7, 1, Blocks.field_150350_a, Blocks.field_150350_a, false);
            this.func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 7, 2, 2, 8, Blocks.field_150350_a, Blocks.field_150350_a, false);

            for(int var4 = 0; var4 < 5; ++var4) {
               this.func_151549_a(p_74875_1_, p_74875_3_, 0, 5 - var4 - (var4 < 4?1:0), 2 + var4, 2, 7 - var4, 2 + var4, Blocks.field_150350_a, Blocks.field_150350_a, false);
            }

            return true;
         }
      }
   }
}
