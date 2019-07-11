package net.minecraft.world.gen.structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class StructureStrongholdPieces {

   private static final StructureStrongholdPieces.PieceWeight[] field_75205_b = new StructureStrongholdPieces.PieceWeight[]{new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.Straight.class, 40, 0), new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.Prison.class, 5, 5), new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.LeftTurn.class, 20, 0), new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.RightTurn.class, 20, 0), new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.RoomCrossing.class, 10, 6), new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.StairsStraight.class, 5, 5), new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.Stairs.class, 5, 5), new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.Crossing.class, 5, 4), new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.ChestCorridor.class, 5, 4), new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.Library.class, 10, 2) {

      private static final String __OBFID = "CL_00000484";

      public boolean func_75189_a(int p_75189_1_) {
         return super.func_75189_a(p_75189_1_) && p_75189_1_ > 4;
      }
   }, new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.PortalRoom.class, 20, 1) {

      private static final String __OBFID = "CL_00000485";

      public boolean func_75189_a(int p_75189_1_) {
         return super.func_75189_a(p_75189_1_) && p_75189_1_ > 5;
      }
   }};
   private static List field_75206_c;
   private static Class field_75203_d;
   static int field_75207_a;
   private static final StructureStrongholdPieces.Stones field_75204_e = new StructureStrongholdPieces.Stones(null);
   private static final String __OBFID = "CL_00000483";


   public static void func_143046_a() {
      MapGenStructureIO.func_143031_a(StructureStrongholdPieces.ChestCorridor.class, "SHCC");
      MapGenStructureIO.func_143031_a(StructureStrongholdPieces.Corridor.class, "SHFC");
      MapGenStructureIO.func_143031_a(StructureStrongholdPieces.Crossing.class, "SH5C");
      MapGenStructureIO.func_143031_a(StructureStrongholdPieces.LeftTurn.class, "SHLT");
      MapGenStructureIO.func_143031_a(StructureStrongholdPieces.Library.class, "SHLi");
      MapGenStructureIO.func_143031_a(StructureStrongholdPieces.PortalRoom.class, "SHPR");
      MapGenStructureIO.func_143031_a(StructureStrongholdPieces.Prison.class, "SHPH");
      MapGenStructureIO.func_143031_a(StructureStrongholdPieces.RightTurn.class, "SHRT");
      MapGenStructureIO.func_143031_a(StructureStrongholdPieces.RoomCrossing.class, "SHRC");
      MapGenStructureIO.func_143031_a(StructureStrongholdPieces.Stairs.class, "SHSD");
      MapGenStructureIO.func_143031_a(StructureStrongholdPieces.Stairs2.class, "SHStart");
      MapGenStructureIO.func_143031_a(StructureStrongholdPieces.Straight.class, "SHS");
      MapGenStructureIO.func_143031_a(StructureStrongholdPieces.StairsStraight.class, "SHSSD");
   }

   public static void func_75198_a() {
      field_75206_c = new ArrayList();
      StructureStrongholdPieces.PieceWeight[] var0 = field_75205_b;
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         StructureStrongholdPieces.PieceWeight var3 = var0[var2];
         var3.field_75193_c = 0;
         field_75206_c.add(var3);
      }

      field_75203_d = null;
   }

   private static boolean func_75202_c() {
      boolean var0 = false;
      field_75207_a = 0;

      StructureStrongholdPieces.PieceWeight var2;
      for(Iterator var1 = field_75206_c.iterator(); var1.hasNext(); field_75207_a += var2.field_75192_b) {
         var2 = (StructureStrongholdPieces.PieceWeight)var1.next();
         if(var2.field_75191_d > 0 && var2.field_75193_c < var2.field_75191_d) {
            var0 = true;
         }
      }

      return var0;
   }

   private static StructureStrongholdPieces.Stronghold func_75200_a(Class p_75200_0_, List p_75200_1_, Random p_75200_2_, int p_75200_3_, int p_75200_4_, int p_75200_5_, int p_75200_6_, int p_75200_7_) {
      Object var8 = null;
      if(p_75200_0_ == StructureStrongholdPieces.Straight.class) {
         var8 = StructureStrongholdPieces.Straight.func_75018_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
      } else if(p_75200_0_ == StructureStrongholdPieces.Prison.class) {
         var8 = StructureStrongholdPieces.Prison.func_75016_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
      } else if(p_75200_0_ == StructureStrongholdPieces.LeftTurn.class) {
         var8 = StructureStrongholdPieces.LeftTurn.func_75010_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
      } else if(p_75200_0_ == StructureStrongholdPieces.RightTurn.class) {
         var8 = StructureStrongholdPieces.RightTurn.func_75010_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
      } else if(p_75200_0_ == StructureStrongholdPieces.RoomCrossing.class) {
         var8 = StructureStrongholdPieces.RoomCrossing.func_75012_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
      } else if(p_75200_0_ == StructureStrongholdPieces.StairsStraight.class) {
         var8 = StructureStrongholdPieces.StairsStraight.func_75028_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
      } else if(p_75200_0_ == StructureStrongholdPieces.Stairs.class) {
         var8 = StructureStrongholdPieces.Stairs.func_75022_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
      } else if(p_75200_0_ == StructureStrongholdPieces.Crossing.class) {
         var8 = StructureStrongholdPieces.Crossing.func_74994_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
      } else if(p_75200_0_ == StructureStrongholdPieces.ChestCorridor.class) {
         var8 = StructureStrongholdPieces.ChestCorridor.func_75000_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
      } else if(p_75200_0_ == StructureStrongholdPieces.Library.class) {
         var8 = StructureStrongholdPieces.Library.func_75006_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
      } else if(p_75200_0_ == StructureStrongholdPieces.PortalRoom.class) {
         var8 = StructureStrongholdPieces.PortalRoom.func_75004_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
      }

      return (StructureStrongholdPieces.Stronghold)var8;
   }

   private static StructureStrongholdPieces.Stronghold func_75201_b(StructureStrongholdPieces.Stairs2 p_75201_0_, List p_75201_1_, Random p_75201_2_, int p_75201_3_, int p_75201_4_, int p_75201_5_, int p_75201_6_, int p_75201_7_) {
      if(!func_75202_c()) {
         return null;
      } else {
         if(field_75203_d != null) {
            StructureStrongholdPieces.Stronghold var8 = func_75200_a(field_75203_d, p_75201_1_, p_75201_2_, p_75201_3_, p_75201_4_, p_75201_5_, p_75201_6_, p_75201_7_);
            field_75203_d = null;
            if(var8 != null) {
               return var8;
            }
         }

         int var13 = 0;

         while(var13 < 5) {
            ++var13;
            int var9 = p_75201_2_.nextInt(field_75207_a);
            Iterator var10 = field_75206_c.iterator();

            while(var10.hasNext()) {
               StructureStrongholdPieces.PieceWeight var11 = (StructureStrongholdPieces.PieceWeight)var10.next();
               var9 -= var11.field_75192_b;
               if(var9 < 0) {
                  if(!var11.func_75189_a(p_75201_7_) || var11 == p_75201_0_.field_75027_a) {
                     break;
                  }

                  StructureStrongholdPieces.Stronghold var12 = func_75200_a(var11.field_75194_a, p_75201_1_, p_75201_2_, p_75201_3_, p_75201_4_, p_75201_5_, p_75201_6_, p_75201_7_);
                  if(var12 != null) {
                     ++var11.field_75193_c;
                     p_75201_0_.field_75027_a = var11;
                     if(!var11.func_75190_a()) {
                        field_75206_c.remove(var11);
                     }

                     return var12;
                  }
               }
            }
         }

         StructureBoundingBox var14 = StructureStrongholdPieces.Corridor.func_74992_a(p_75201_1_, p_75201_2_, p_75201_3_, p_75201_4_, p_75201_5_, p_75201_6_);
         if(var14 != null && var14.field_78895_b > 1) {
            return new StructureStrongholdPieces.Corridor(p_75201_7_, p_75201_2_, var14, p_75201_6_);
         } else {
            return null;
         }
      }
   }

   private static StructureComponent func_75196_c(StructureStrongholdPieces.Stairs2 p_75196_0_, List p_75196_1_, Random p_75196_2_, int p_75196_3_, int p_75196_4_, int p_75196_5_, int p_75196_6_, int p_75196_7_) {
      if(p_75196_7_ > 50) {
         return null;
      } else if(Math.abs(p_75196_3_ - p_75196_0_.func_74874_b().field_78897_a) <= 112 && Math.abs(p_75196_5_ - p_75196_0_.func_74874_b().field_78896_c) <= 112) {
         StructureStrongholdPieces.Stronghold var8 = func_75201_b(p_75196_0_, p_75196_1_, p_75196_2_, p_75196_3_, p_75196_4_, p_75196_5_, p_75196_6_, p_75196_7_ + 1);
         if(var8 != null) {
            p_75196_1_.add(var8);
            p_75196_0_.field_75026_c.add(var8);
         }

         return var8;
      } else {
         return null;
      }
   }


   public static class ChestCorridor extends StructureStrongholdPieces.Stronghold {

      private static final WeightedRandomChestContent[] field_75003_a = new WeightedRandomChestContent[]{new WeightedRandomChestContent(Items.field_151079_bi, 0, 1, 1, 10), new WeightedRandomChestContent(Items.field_151045_i, 0, 1, 3, 3), new WeightedRandomChestContent(Items.field_151042_j, 0, 1, 5, 10), new WeightedRandomChestContent(Items.field_151043_k, 0, 1, 3, 5), new WeightedRandomChestContent(Items.field_151137_ax, 0, 4, 9, 5), new WeightedRandomChestContent(Items.field_151025_P, 0, 1, 3, 15), new WeightedRandomChestContent(Items.field_151034_e, 0, 1, 3, 15), new WeightedRandomChestContent(Items.field_151035_b, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151040_l, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151030_Z, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151028_Y, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151165_aa, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151167_ab, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151153_ao, 0, 1, 1, 1), new WeightedRandomChestContent(Items.field_151141_av, 0, 1, 1, 1), new WeightedRandomChestContent(Items.field_151138_bX, 0, 1, 1, 1), new WeightedRandomChestContent(Items.field_151136_bY, 0, 1, 1, 1), new WeightedRandomChestContent(Items.field_151125_bZ, 0, 1, 1, 1)};
      private boolean field_75002_c;
      private static final String __OBFID = "CL_00000487";


      public ChestCorridor() {}

      public ChestCorridor(int p_i2071_1_, Random p_i2071_2_, StructureBoundingBox p_i2071_3_, int p_i2071_4_) {
         super(p_i2071_1_);
         this.field_74885_f = p_i2071_4_;
         this.field_143013_d = this.func_74988_a(p_i2071_2_);
         this.field_74887_e = p_i2071_3_;
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         super.func_143012_a(p_143012_1_);
         p_143012_1_.func_74757_a("Chest", this.field_75002_c);
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         super.func_143011_b(p_143011_1_);
         this.field_75002_c = p_143011_1_.func_74767_n("Chest");
      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         this.func_74986_a((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
      }

      public static StructureStrongholdPieces.ChestCorridor func_75000_a(List p_75000_0_, Random p_75000_1_, int p_75000_2_, int p_75000_3_, int p_75000_4_, int p_75000_5_, int p_75000_6_) {
         StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_75000_2_, p_75000_3_, p_75000_4_, -1, -1, 0, 5, 5, 7, p_75000_5_);
         return func_74991_a(var7) && StructureComponent.func_74883_a(p_75000_0_, var7) == null?new StructureStrongholdPieces.ChestCorridor(p_75000_6_, p_75000_1_, var7, p_75000_5_):null;
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 4, 6, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 1, 0);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, StructureStrongholdPieces.Stronghold.Door.OPENING, 1, 1, 6);
            this.func_151549_a(p_74875_1_, p_74875_3_, 3, 1, 2, 3, 1, 4, Blocks.field_150417_aV, Blocks.field_150417_aV, false);
            this.func_151550_a(p_74875_1_, Blocks.field_150333_U, 5, 3, 1, 1, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150333_U, 5, 3, 1, 5, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150333_U, 5, 3, 2, 2, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150333_U, 5, 3, 2, 4, p_74875_3_);

            int var4;
            for(var4 = 2; var4 <= 4; ++var4) {
               this.func_151550_a(p_74875_1_, Blocks.field_150333_U, 5, 2, 1, var4, p_74875_3_);
            }

            if(!this.field_75002_c) {
               var4 = this.func_74862_a(2);
               int var5 = this.func_74865_a(3, 3);
               int var6 = this.func_74873_b(3, 3);
               if(p_74875_3_.func_78890_b(var5, var4, var6)) {
                  this.field_75002_c = true;
                  this.func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 3, 2, 3, WeightedRandomChestContent.func_92080_a(field_75003_a, new WeightedRandomChestContent[]{Items.field_151134_bR.func_92114_b(p_74875_2_)}), 2 + p_74875_2_.nextInt(2));
               }
            }

            return true;
         }
      }

   }

   public static class Corridor extends StructureStrongholdPieces.Stronghold {

      private int field_74993_a;
      private static final String __OBFID = "CL_00000488";


      public Corridor() {}

      public Corridor(int p_i2072_1_, Random p_i2072_2_, StructureBoundingBox p_i2072_3_, int p_i2072_4_) {
         super(p_i2072_1_);
         this.field_74885_f = p_i2072_4_;
         this.field_74887_e = p_i2072_3_;
         this.field_74993_a = p_i2072_4_ != 2 && p_i2072_4_ != 0?p_i2072_3_.func_78883_b():p_i2072_3_.func_78880_d();
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         super.func_143012_a(p_143012_1_);
         p_143012_1_.func_74768_a("Steps", this.field_74993_a);
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         super.func_143011_b(p_143011_1_);
         this.field_74993_a = p_143011_1_.func_74762_e("Steps");
      }

      public static StructureBoundingBox func_74992_a(List p_74992_0_, Random p_74992_1_, int p_74992_2_, int p_74992_3_, int p_74992_4_, int p_74992_5_) {
         boolean var6 = true;
         StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_74992_2_, p_74992_3_, p_74992_4_, -1, -1, 0, 5, 5, 4, p_74992_5_);
         StructureComponent var8 = StructureComponent.func_74883_a(p_74992_0_, var7);
         if(var8 == null) {
            return null;
         } else {
            if(var8.func_74874_b().field_78895_b == var7.field_78895_b) {
               for(int var9 = 3; var9 >= 1; --var9) {
                  var7 = StructureBoundingBox.func_78889_a(p_74992_2_, p_74992_3_, p_74992_4_, -1, -1, 0, 5, 5, var9 - 1, p_74992_5_);
                  if(!var8.func_74874_b().func_78884_a(var7)) {
                     return StructureBoundingBox.func_78889_a(p_74992_2_, p_74992_3_, p_74992_4_, -1, -1, 0, 5, 5, var9, p_74992_5_);
                  }
               }
            }

            return null;
         }
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            for(int var4 = 0; var4 < this.field_74993_a; ++var4) {
               this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 0, 0, var4, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 1, 0, var4, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 2, 0, var4, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 3, 0, var4, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 4, 0, var4, p_74875_3_);

               for(int var5 = 1; var5 <= 3; ++var5) {
                  this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 0, var5, var4, p_74875_3_);
                  this.func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 1, var5, var4, p_74875_3_);
                  this.func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 2, var5, var4, p_74875_3_);
                  this.func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 3, var5, var4, p_74875_3_);
                  this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 4, var5, var4, p_74875_3_);
               }

               this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 0, 4, var4, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 1, 4, var4, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 2, 4, var4, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 3, 4, var4, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 4, 4, var4, p_74875_3_);
            }

            return true;
         }
      }
   }

   public static class Crossing extends StructureStrongholdPieces.Stronghold {

      private boolean field_74996_b;
      private boolean field_74997_c;
      private boolean field_74995_d;
      private boolean field_74999_h;
      private static final String __OBFID = "CL_00000489";


      public Crossing() {}

      public Crossing(int p_i2073_1_, Random p_i2073_2_, StructureBoundingBox p_i2073_3_, int p_i2073_4_) {
         super(p_i2073_1_);
         this.field_74885_f = p_i2073_4_;
         this.field_143013_d = this.func_74988_a(p_i2073_2_);
         this.field_74887_e = p_i2073_3_;
         this.field_74996_b = p_i2073_2_.nextBoolean();
         this.field_74997_c = p_i2073_2_.nextBoolean();
         this.field_74995_d = p_i2073_2_.nextBoolean();
         this.field_74999_h = p_i2073_2_.nextInt(3) > 0;
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         super.func_143012_a(p_143012_1_);
         p_143012_1_.func_74757_a("leftLow", this.field_74996_b);
         p_143012_1_.func_74757_a("leftHigh", this.field_74997_c);
         p_143012_1_.func_74757_a("rightLow", this.field_74995_d);
         p_143012_1_.func_74757_a("rightHigh", this.field_74999_h);
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         super.func_143011_b(p_143011_1_);
         this.field_74996_b = p_143011_1_.func_74767_n("leftLow");
         this.field_74997_c = p_143011_1_.func_74767_n("leftHigh");
         this.field_74995_d = p_143011_1_.func_74767_n("rightLow");
         this.field_74999_h = p_143011_1_.func_74767_n("rightHigh");
      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         int var4 = 3;
         int var5 = 5;
         if(this.field_74885_f == 1 || this.field_74885_f == 2) {
            var4 = 8 - var4;
            var5 = 8 - var5;
         }

         this.func_74986_a((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 5, 1);
         if(this.field_74996_b) {
            this.func_74989_b((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, var4, 1);
         }

         if(this.field_74997_c) {
            this.func_74989_b((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, var5, 7);
         }

         if(this.field_74995_d) {
            this.func_74987_c((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, var4, 1);
         }

         if(this.field_74999_h) {
            this.func_74987_c((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, var5, 7);
         }

      }

      public static StructureStrongholdPieces.Crossing func_74994_a(List p_74994_0_, Random p_74994_1_, int p_74994_2_, int p_74994_3_, int p_74994_4_, int p_74994_5_, int p_74994_6_) {
         StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_74994_2_, p_74994_3_, p_74994_4_, -4, -3, 0, 10, 9, 11, p_74994_5_);
         return func_74991_a(var7) && StructureComponent.func_74883_a(p_74994_0_, var7) == null?new StructureStrongholdPieces.Crossing(p_74994_6_, p_74994_1_, var7, p_74994_5_):null;
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 9, 8, 10, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 4, 3, 0);
            if(this.field_74996_b) {
               this.func_151549_a(p_74875_1_, p_74875_3_, 0, 3, 1, 0, 5, 3, Blocks.field_150350_a, Blocks.field_150350_a, false);
            }

            if(this.field_74995_d) {
               this.func_151549_a(p_74875_1_, p_74875_3_, 9, 3, 1, 9, 5, 3, Blocks.field_150350_a, Blocks.field_150350_a, false);
            }

            if(this.field_74997_c) {
               this.func_151549_a(p_74875_1_, p_74875_3_, 0, 5, 7, 0, 7, 9, Blocks.field_150350_a, Blocks.field_150350_a, false);
            }

            if(this.field_74999_h) {
               this.func_151549_a(p_74875_1_, p_74875_3_, 9, 5, 7, 9, 7, 9, Blocks.field_150350_a, Blocks.field_150350_a, false);
            }

            this.func_151549_a(p_74875_1_, p_74875_3_, 5, 1, 10, 7, 3, 10, Blocks.field_150350_a, Blocks.field_150350_a, false);
            this.func_74882_a(p_74875_1_, p_74875_3_, 1, 2, 1, 8, 2, 6, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 5, 4, 4, 9, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74882_a(p_74875_1_, p_74875_3_, 8, 1, 5, 8, 4, 9, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74882_a(p_74875_1_, p_74875_3_, 1, 4, 7, 3, 4, 9, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74882_a(p_74875_1_, p_74875_3_, 1, 3, 5, 3, 3, 6, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_151549_a(p_74875_1_, p_74875_3_, 1, 3, 4, 3, 3, 4, Blocks.field_150333_U, Blocks.field_150333_U, false);
            this.func_151549_a(p_74875_1_, p_74875_3_, 1, 4, 6, 3, 4, 6, Blocks.field_150333_U, Blocks.field_150333_U, false);
            this.func_74882_a(p_74875_1_, p_74875_3_, 5, 1, 7, 7, 1, 8, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_151549_a(p_74875_1_, p_74875_3_, 5, 1, 9, 7, 1, 9, Blocks.field_150333_U, Blocks.field_150333_U, false);
            this.func_151549_a(p_74875_1_, p_74875_3_, 5, 2, 7, 7, 2, 7, Blocks.field_150333_U, Blocks.field_150333_U, false);
            this.func_151549_a(p_74875_1_, p_74875_3_, 4, 5, 7, 4, 5, 9, Blocks.field_150333_U, Blocks.field_150333_U, false);
            this.func_151549_a(p_74875_1_, p_74875_3_, 8, 5, 7, 8, 5, 9, Blocks.field_150333_U, Blocks.field_150333_U, false);
            this.func_151549_a(p_74875_1_, p_74875_3_, 5, 5, 7, 7, 5, 9, Blocks.field_150334_T, Blocks.field_150334_T, false);
            this.func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 6, 5, 6, p_74875_3_);
            return true;
         }
      }
   }

   public static class LeftTurn extends StructureStrongholdPieces.Stronghold {

      private static final String __OBFID = "CL_00000490";


      public LeftTurn() {}

      public LeftTurn(int p_i2074_1_, Random p_i2074_2_, StructureBoundingBox p_i2074_3_, int p_i2074_4_) {
         super(p_i2074_1_);
         this.field_74885_f = p_i2074_4_;
         this.field_143013_d = this.func_74988_a(p_i2074_2_);
         this.field_74887_e = p_i2074_3_;
      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         if(this.field_74885_f != 2 && this.field_74885_f != 3) {
            this.func_74987_c((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
         } else {
            this.func_74989_b((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
         }

      }

      public static StructureStrongholdPieces.LeftTurn func_75010_a(List p_75010_0_, Random p_75010_1_, int p_75010_2_, int p_75010_3_, int p_75010_4_, int p_75010_5_, int p_75010_6_) {
         StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_75010_2_, p_75010_3_, p_75010_4_, -1, -1, 0, 5, 5, 5, p_75010_5_);
         return func_74991_a(var7) && StructureComponent.func_74883_a(p_75010_0_, var7) == null?new StructureStrongholdPieces.LeftTurn(p_75010_6_, p_75010_1_, var7, p_75010_5_):null;
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 4, 4, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 1, 0);
            if(this.field_74885_f != 2 && this.field_74885_f != 3) {
               this.func_151549_a(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 3, 3, Blocks.field_150350_a, Blocks.field_150350_a, false);
            } else {
               this.func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 3, 3, Blocks.field_150350_a, Blocks.field_150350_a, false);
            }

            return true;
         }
      }
   }

   public static class Library extends StructureStrongholdPieces.Stronghold {

      private static final WeightedRandomChestContent[] field_75007_b = new WeightedRandomChestContent[]{new WeightedRandomChestContent(Items.field_151122_aG, 0, 1, 3, 20), new WeightedRandomChestContent(Items.field_151121_aF, 0, 2, 7, 20), new WeightedRandomChestContent(Items.field_151148_bJ, 0, 1, 1, 1), new WeightedRandomChestContent(Items.field_151111_aL, 0, 1, 1, 1)};
      private boolean field_75008_c;
      private static final String __OBFID = "CL_00000491";


      public Library() {}

      public Library(int p_i2075_1_, Random p_i2075_2_, StructureBoundingBox p_i2075_3_, int p_i2075_4_) {
         super(p_i2075_1_);
         this.field_74885_f = p_i2075_4_;
         this.field_143013_d = this.func_74988_a(p_i2075_2_);
         this.field_74887_e = p_i2075_3_;
         this.field_75008_c = p_i2075_3_.func_78882_c() > 6;
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         super.func_143012_a(p_143012_1_);
         p_143012_1_.func_74757_a("Tall", this.field_75008_c);
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         super.func_143011_b(p_143011_1_);
         this.field_75008_c = p_143011_1_.func_74767_n("Tall");
      }

      public static StructureStrongholdPieces.Library func_75006_a(List p_75006_0_, Random p_75006_1_, int p_75006_2_, int p_75006_3_, int p_75006_4_, int p_75006_5_, int p_75006_6_) {
         StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_75006_2_, p_75006_3_, p_75006_4_, -4, -1, 0, 14, 11, 15, p_75006_5_);
         if(!func_74991_a(var7) || StructureComponent.func_74883_a(p_75006_0_, var7) != null) {
            var7 = StructureBoundingBox.func_78889_a(p_75006_2_, p_75006_3_, p_75006_4_, -4, -1, 0, 14, 6, 15, p_75006_5_);
            if(!func_74991_a(var7) || StructureComponent.func_74883_a(p_75006_0_, var7) != null) {
               return null;
            }
         }

         return new StructureStrongholdPieces.Library(p_75006_6_, p_75006_1_, var7, p_75006_5_);
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            byte var4 = 11;
            if(!this.field_75008_c) {
               var4 = 6;
            }

            this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 13, var4 - 1, 14, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 4, 1, 0);
            this.func_151551_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.07F, 2, 1, 1, 11, 4, 13, Blocks.field_150321_G, Blocks.field_150321_G, false);
            boolean var5 = true;
            boolean var6 = true;

            int var7;
            for(var7 = 1; var7 <= 13; ++var7) {
               if((var7 - 1) % 4 == 0) {
                  this.func_151549_a(p_74875_1_, p_74875_3_, 1, 1, var7, 1, 4, var7, Blocks.field_150344_f, Blocks.field_150344_f, false);
                  this.func_151549_a(p_74875_1_, p_74875_3_, 12, 1, var7, 12, 4, var7, Blocks.field_150344_f, Blocks.field_150344_f, false);
                  this.func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 2, 3, var7, p_74875_3_);
                  this.func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 11, 3, var7, p_74875_3_);
                  if(this.field_75008_c) {
                     this.func_151549_a(p_74875_1_, p_74875_3_, 1, 6, var7, 1, 9, var7, Blocks.field_150344_f, Blocks.field_150344_f, false);
                     this.func_151549_a(p_74875_1_, p_74875_3_, 12, 6, var7, 12, 9, var7, Blocks.field_150344_f, Blocks.field_150344_f, false);
                  }
               } else {
                  this.func_151549_a(p_74875_1_, p_74875_3_, 1, 1, var7, 1, 4, var7, Blocks.field_150342_X, Blocks.field_150342_X, false);
                  this.func_151549_a(p_74875_1_, p_74875_3_, 12, 1, var7, 12, 4, var7, Blocks.field_150342_X, Blocks.field_150342_X, false);
                  if(this.field_75008_c) {
                     this.func_151549_a(p_74875_1_, p_74875_3_, 1, 6, var7, 1, 9, var7, Blocks.field_150342_X, Blocks.field_150342_X, false);
                     this.func_151549_a(p_74875_1_, p_74875_3_, 12, 6, var7, 12, 9, var7, Blocks.field_150342_X, Blocks.field_150342_X, false);
                  }
               }
            }

            for(var7 = 3; var7 < 12; var7 += 2) {
               this.func_151549_a(p_74875_1_, p_74875_3_, 3, 1, var7, 4, 3, var7, Blocks.field_150342_X, Blocks.field_150342_X, false);
               this.func_151549_a(p_74875_1_, p_74875_3_, 6, 1, var7, 7, 3, var7, Blocks.field_150342_X, Blocks.field_150342_X, false);
               this.func_151549_a(p_74875_1_, p_74875_3_, 9, 1, var7, 10, 3, var7, Blocks.field_150342_X, Blocks.field_150342_X, false);
            }

            if(this.field_75008_c) {
               this.func_151549_a(p_74875_1_, p_74875_3_, 1, 5, 1, 3, 5, 13, Blocks.field_150344_f, Blocks.field_150344_f, false);
               this.func_151549_a(p_74875_1_, p_74875_3_, 10, 5, 1, 12, 5, 13, Blocks.field_150344_f, Blocks.field_150344_f, false);
               this.func_151549_a(p_74875_1_, p_74875_3_, 4, 5, 1, 9, 5, 2, Blocks.field_150344_f, Blocks.field_150344_f, false);
               this.func_151549_a(p_74875_1_, p_74875_3_, 4, 5, 12, 9, 5, 13, Blocks.field_150344_f, Blocks.field_150344_f, false);
               this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 9, 5, 11, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 8, 5, 11, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 9, 5, 10, p_74875_3_);
               this.func_151549_a(p_74875_1_, p_74875_3_, 3, 6, 2, 3, 6, 12, Blocks.field_150422_aJ, Blocks.field_150422_aJ, false);
               this.func_151549_a(p_74875_1_, p_74875_3_, 10, 6, 2, 10, 6, 10, Blocks.field_150422_aJ, Blocks.field_150422_aJ, false);
               this.func_151549_a(p_74875_1_, p_74875_3_, 4, 6, 2, 9, 6, 2, Blocks.field_150422_aJ, Blocks.field_150422_aJ, false);
               this.func_151549_a(p_74875_1_, p_74875_3_, 4, 6, 12, 8, 6, 12, Blocks.field_150422_aJ, Blocks.field_150422_aJ, false);
               this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 9, 6, 11, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 8, 6, 11, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 9, 6, 10, p_74875_3_);
               var7 = this.func_151555_a(Blocks.field_150468_ap, 3);
               this.func_151550_a(p_74875_1_, Blocks.field_150468_ap, var7, 10, 1, 13, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150468_ap, var7, 10, 2, 13, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150468_ap, var7, 10, 3, 13, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150468_ap, var7, 10, 4, 13, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150468_ap, var7, 10, 5, 13, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150468_ap, var7, 10, 6, 13, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150468_ap, var7, 10, 7, 13, p_74875_3_);
               byte var8 = 7;
               byte var9 = 7;
               this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, var8 - 1, 9, var9, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, var8, 9, var9, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, var8 - 1, 8, var9, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, var8, 8, var9, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, var8 - 1, 7, var9, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, var8, 7, var9, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, var8 - 2, 7, var9, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, var8 + 1, 7, var9, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, var8 - 1, 7, var9 - 1, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, var8 - 1, 7, var9 + 1, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, var8, 7, var9 - 1, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, var8, 7, var9 + 1, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, var8 - 2, 8, var9, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, var8 + 1, 8, var9, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, var8 - 1, 8, var9 - 1, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, var8 - 1, 8, var9 + 1, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, var8, 8, var9 - 1, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, var8, 8, var9 + 1, p_74875_3_);
            }

            this.func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 3, 3, 5, WeightedRandomChestContent.func_92080_a(field_75007_b, new WeightedRandomChestContent[]{Items.field_151134_bR.func_92112_a(p_74875_2_, 1, 5, 2)}), 1 + p_74875_2_.nextInt(4));
            if(this.field_75008_c) {
               this.func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 12, 9, 1, p_74875_3_);
               this.func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 12, 8, 1, WeightedRandomChestContent.func_92080_a(field_75007_b, new WeightedRandomChestContent[]{Items.field_151134_bR.func_92112_a(p_74875_2_, 1, 5, 2)}), 1 + p_74875_2_.nextInt(4));
            }

            return true;
         }
      }

   }

   static class PieceWeight {

      public Class field_75194_a;
      public final int field_75192_b;
      public int field_75193_c;
      public int field_75191_d;
      private static final String __OBFID = "CL_00000492";


      public PieceWeight(Class p_i2076_1_, int p_i2076_2_, int p_i2076_3_) {
         this.field_75194_a = p_i2076_1_;
         this.field_75192_b = p_i2076_2_;
         this.field_75191_d = p_i2076_3_;
      }

      public boolean func_75189_a(int p_75189_1_) {
         return this.field_75191_d == 0 || this.field_75193_c < this.field_75191_d;
      }

      public boolean func_75190_a() {
         return this.field_75191_d == 0 || this.field_75193_c < this.field_75191_d;
      }
   }

   public static class PortalRoom extends StructureStrongholdPieces.Stronghold {

      private boolean field_75005_a;
      private static final String __OBFID = "CL_00000493";


      public PortalRoom() {}

      public PortalRoom(int p_i2077_1_, Random p_i2077_2_, StructureBoundingBox p_i2077_3_, int p_i2077_4_) {
         super(p_i2077_1_);
         this.field_74885_f = p_i2077_4_;
         this.field_74887_e = p_i2077_3_;
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         super.func_143012_a(p_143012_1_);
         p_143012_1_.func_74757_a("Mob", this.field_75005_a);
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         super.func_143011_b(p_143011_1_);
         this.field_75005_a = p_143011_1_.func_74767_n("Mob");
      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         if(p_74861_1_ != null) {
            ((StructureStrongholdPieces.Stairs2)p_74861_1_).field_75025_b = this;
         }

      }

      public static StructureStrongholdPieces.PortalRoom func_75004_a(List p_75004_0_, Random p_75004_1_, int p_75004_2_, int p_75004_3_, int p_75004_4_, int p_75004_5_, int p_75004_6_) {
         StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_75004_2_, p_75004_3_, p_75004_4_, -4, -1, 0, 11, 8, 16, p_75004_5_);
         return func_74991_a(var7) && StructureComponent.func_74883_a(p_75004_0_, var7) == null?new StructureStrongholdPieces.PortalRoom(p_75004_6_, p_75004_1_, var7, p_75004_5_):null;
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 10, 7, 15, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
         this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, StructureStrongholdPieces.Stronghold.Door.GRATES, 4, 1, 0);
         byte var4 = 6;
         this.func_74882_a(p_74875_1_, p_74875_3_, 1, var4, 1, 1, var4, 14, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
         this.func_74882_a(p_74875_1_, p_74875_3_, 9, var4, 1, 9, var4, 14, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
         this.func_74882_a(p_74875_1_, p_74875_3_, 2, var4, 1, 8, var4, 2, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
         this.func_74882_a(p_74875_1_, p_74875_3_, 2, var4, 14, 8, var4, 14, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
         this.func_74882_a(p_74875_1_, p_74875_3_, 1, 1, 1, 2, 1, 4, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
         this.func_74882_a(p_74875_1_, p_74875_3_, 8, 1, 1, 9, 1, 4, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 1, 1, 1, 3, Blocks.field_150356_k, Blocks.field_150356_k, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 9, 1, 1, 9, 1, 3, Blocks.field_150356_k, Blocks.field_150356_k, false);
         this.func_74882_a(p_74875_1_, p_74875_3_, 3, 1, 8, 7, 1, 12, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
         this.func_151549_a(p_74875_1_, p_74875_3_, 4, 1, 9, 6, 1, 11, Blocks.field_150356_k, Blocks.field_150356_k, false);

         int var5;
         for(var5 = 3; var5 < 14; var5 += 2) {
            this.func_151549_a(p_74875_1_, p_74875_3_, 0, 3, var5, 0, 4, var5, Blocks.field_150411_aY, Blocks.field_150411_aY, false);
            this.func_151549_a(p_74875_1_, p_74875_3_, 10, 3, var5, 10, 4, var5, Blocks.field_150411_aY, Blocks.field_150411_aY, false);
         }

         for(var5 = 2; var5 < 9; var5 += 2) {
            this.func_151549_a(p_74875_1_, p_74875_3_, var5, 3, 15, var5, 4, 15, Blocks.field_150411_aY, Blocks.field_150411_aY, false);
         }

         var5 = this.func_151555_a(Blocks.field_150390_bg, 3);
         this.func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 5, 6, 1, 7, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
         this.func_74882_a(p_74875_1_, p_74875_3_, 4, 2, 6, 6, 2, 7, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
         this.func_74882_a(p_74875_1_, p_74875_3_, 4, 3, 7, 6, 3, 7, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);

         for(int var6 = 4; var6 <= 6; ++var6) {
            this.func_151550_a(p_74875_1_, Blocks.field_150390_bg, var5, var6, 1, 4, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150390_bg, var5, var6, 2, 5, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150390_bg, var5, var6, 3, 6, p_74875_3_);
         }

         byte var14 = 2;
         byte var7 = 0;
         byte var8 = 3;
         byte var9 = 1;
         switch(this.field_74885_f) {
         case 0:
            var14 = 0;
            var7 = 2;
            break;
         case 1:
            var14 = 1;
            var7 = 3;
            var8 = 0;
            var9 = 2;
         case 2:
         default:
            break;
         case 3:
            var14 = 3;
            var7 = 1;
            var8 = 0;
            var9 = 2;
         }

         this.func_151550_a(p_74875_1_, Blocks.field_150378_br, var14 + (p_74875_2_.nextFloat() > 0.9F?4:0), 4, 3, 8, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150378_br, var14 + (p_74875_2_.nextFloat() > 0.9F?4:0), 5, 3, 8, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150378_br, var14 + (p_74875_2_.nextFloat() > 0.9F?4:0), 6, 3, 8, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150378_br, var7 + (p_74875_2_.nextFloat() > 0.9F?4:0), 4, 3, 12, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150378_br, var7 + (p_74875_2_.nextFloat() > 0.9F?4:0), 5, 3, 12, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150378_br, var7 + (p_74875_2_.nextFloat() > 0.9F?4:0), 6, 3, 12, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150378_br, var8 + (p_74875_2_.nextFloat() > 0.9F?4:0), 3, 3, 9, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150378_br, var8 + (p_74875_2_.nextFloat() > 0.9F?4:0), 3, 3, 10, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150378_br, var8 + (p_74875_2_.nextFloat() > 0.9F?4:0), 3, 3, 11, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150378_br, var9 + (p_74875_2_.nextFloat() > 0.9F?4:0), 7, 3, 9, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150378_br, var9 + (p_74875_2_.nextFloat() > 0.9F?4:0), 7, 3, 10, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150378_br, var9 + (p_74875_2_.nextFloat() > 0.9F?4:0), 7, 3, 11, p_74875_3_);
         if(!this.field_75005_a) {
            int var13 = this.func_74862_a(3);
            int var10 = this.func_74865_a(5, 6);
            int var11 = this.func_74873_b(5, 6);
            if(p_74875_3_.func_78890_b(var10, var13, var11)) {
               this.field_75005_a = true;
               p_74875_1_.func_147465_d(var10, var13, var11, Blocks.field_150474_ac, 0, 2);
               TileEntityMobSpawner var12 = (TileEntityMobSpawner)p_74875_1_.func_147438_o(var10, var13, var11);
               if(var12 != null) {
                  var12.func_145881_a().func_98272_a("Silverfish");
               }
            }
         }

         return true;
      }
   }

   public static class Prison extends StructureStrongholdPieces.Stronghold {

      private static final String __OBFID = "CL_00000494";


      public Prison() {}

      public Prison(int p_i2078_1_, Random p_i2078_2_, StructureBoundingBox p_i2078_3_, int p_i2078_4_) {
         super(p_i2078_1_);
         this.field_74885_f = p_i2078_4_;
         this.field_143013_d = this.func_74988_a(p_i2078_2_);
         this.field_74887_e = p_i2078_3_;
      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         this.func_74986_a((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
      }

      public static StructureStrongholdPieces.Prison func_75016_a(List p_75016_0_, Random p_75016_1_, int p_75016_2_, int p_75016_3_, int p_75016_4_, int p_75016_5_, int p_75016_6_) {
         StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_75016_2_, p_75016_3_, p_75016_4_, -1, -1, 0, 9, 5, 11, p_75016_5_);
         return func_74991_a(var7) && StructureComponent.func_74883_a(p_75016_0_, var7) == null?new StructureStrongholdPieces.Prison(p_75016_6_, p_75016_1_, var7, p_75016_5_):null;
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 8, 4, 10, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 1, 0);
            this.func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 10, 3, 3, 10, Blocks.field_150350_a, Blocks.field_150350_a, false);
            this.func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 3, 1, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 3, 4, 3, 3, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 7, 4, 3, 7, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 9, 4, 3, 9, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_151549_a(p_74875_1_, p_74875_3_, 4, 1, 4, 4, 3, 6, Blocks.field_150411_aY, Blocks.field_150411_aY, false);
            this.func_151549_a(p_74875_1_, p_74875_3_, 5, 1, 5, 7, 3, 5, Blocks.field_150411_aY, Blocks.field_150411_aY, false);
            this.func_151550_a(p_74875_1_, Blocks.field_150411_aY, 0, 4, 3, 2, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150411_aY, 0, 4, 3, 8, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150454_av, this.func_151555_a(Blocks.field_150454_av, 3), 4, 1, 2, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150454_av, this.func_151555_a(Blocks.field_150454_av, 3) + 8, 4, 2, 2, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150454_av, this.func_151555_a(Blocks.field_150454_av, 3), 4, 1, 8, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150454_av, this.func_151555_a(Blocks.field_150454_av, 3) + 8, 4, 2, 8, p_74875_3_);
            return true;
         }
      }
   }

   public static class RightTurn extends StructureStrongholdPieces.LeftTurn {

      private static final String __OBFID = "CL_00000495";


      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         if(this.field_74885_f != 2 && this.field_74885_f != 3) {
            this.func_74989_b((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
         } else {
            this.func_74987_c((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
         }

      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 4, 4, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 1, 0);
            if(this.field_74885_f != 2 && this.field_74885_f != 3) {
               this.func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 3, 3, Blocks.field_150350_a, Blocks.field_150350_a, false);
            } else {
               this.func_151549_a(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 3, 3, Blocks.field_150350_a, Blocks.field_150350_a, false);
            }

            return true;
         }
      }
   }

   public static class RoomCrossing extends StructureStrongholdPieces.Stronghold {

      private static final WeightedRandomChestContent[] field_75014_c = new WeightedRandomChestContent[]{new WeightedRandomChestContent(Items.field_151042_j, 0, 1, 5, 10), new WeightedRandomChestContent(Items.field_151043_k, 0, 1, 3, 5), new WeightedRandomChestContent(Items.field_151137_ax, 0, 4, 9, 5), new WeightedRandomChestContent(Items.field_151044_h, 0, 3, 8, 10), new WeightedRandomChestContent(Items.field_151025_P, 0, 1, 3, 15), new WeightedRandomChestContent(Items.field_151034_e, 0, 1, 3, 15), new WeightedRandomChestContent(Items.field_151035_b, 0, 1, 1, 1)};
      protected int field_75013_b;
      private static final String __OBFID = "CL_00000496";


      public RoomCrossing() {}

      public RoomCrossing(int p_i2079_1_, Random p_i2079_2_, StructureBoundingBox p_i2079_3_, int p_i2079_4_) {
         super(p_i2079_1_);
         this.field_74885_f = p_i2079_4_;
         this.field_143013_d = this.func_74988_a(p_i2079_2_);
         this.field_74887_e = p_i2079_3_;
         this.field_75013_b = p_i2079_2_.nextInt(5);
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         super.func_143012_a(p_143012_1_);
         p_143012_1_.func_74768_a("Type", this.field_75013_b);
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         super.func_143011_b(p_143011_1_);
         this.field_75013_b = p_143011_1_.func_74762_e("Type");
      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         this.func_74986_a((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 4, 1);
         this.func_74989_b((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 4);
         this.func_74987_c((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 4);
      }

      public static StructureStrongholdPieces.RoomCrossing func_75012_a(List p_75012_0_, Random p_75012_1_, int p_75012_2_, int p_75012_3_, int p_75012_4_, int p_75012_5_, int p_75012_6_) {
         StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_75012_2_, p_75012_3_, p_75012_4_, -4, -1, 0, 11, 7, 11, p_75012_5_);
         return func_74991_a(var7) && StructureComponent.func_74883_a(p_75012_0_, var7) == null?new StructureStrongholdPieces.RoomCrossing(p_75012_6_, p_75012_1_, var7, p_75012_5_):null;
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 10, 6, 10, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 4, 1, 0);
            this.func_151549_a(p_74875_1_, p_74875_3_, 4, 1, 10, 6, 3, 10, Blocks.field_150350_a, Blocks.field_150350_a, false);
            this.func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 4, 0, 3, 6, Blocks.field_150350_a, Blocks.field_150350_a, false);
            this.func_151549_a(p_74875_1_, p_74875_3_, 10, 1, 4, 10, 3, 6, Blocks.field_150350_a, Blocks.field_150350_a, false);
            int var4;
            switch(this.field_75013_b) {
            case 0:
               this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 5, 1, 5, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 5, 2, 5, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 5, 3, 5, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 4, 3, 5, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 6, 3, 5, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 5, 3, 4, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 5, 3, 6, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150333_U, 0, 4, 1, 4, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150333_U, 0, 4, 1, 5, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150333_U, 0, 4, 1, 6, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150333_U, 0, 6, 1, 4, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150333_U, 0, 6, 1, 5, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150333_U, 0, 6, 1, 6, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150333_U, 0, 5, 1, 4, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150333_U, 0, 5, 1, 6, p_74875_3_);
               break;
            case 1:
               for(var4 = 0; var4 < 5; ++var4) {
                  this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 3, 1, 3 + var4, p_74875_3_);
                  this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 7, 1, 3 + var4, p_74875_3_);
                  this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 3 + var4, 1, 3, p_74875_3_);
                  this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 3 + var4, 1, 7, p_74875_3_);
               }

               this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 5, 1, 5, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 5, 2, 5, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 5, 3, 5, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150358_i, 0, 5, 4, 5, p_74875_3_);
               break;
            case 2:
               for(var4 = 1; var4 <= 9; ++var4) {
                  this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 1, 3, var4, p_74875_3_);
                  this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 9, 3, var4, p_74875_3_);
               }

               for(var4 = 1; var4 <= 9; ++var4) {
                  this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, var4, 3, 1, p_74875_3_);
                  this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, var4, 3, 9, p_74875_3_);
               }

               this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 5, 1, 4, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 5, 1, 6, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 5, 3, 4, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 5, 3, 6, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 4, 1, 5, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 6, 1, 5, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 4, 3, 5, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 6, 3, 5, p_74875_3_);

               for(var4 = 1; var4 <= 3; ++var4) {
                  this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 4, var4, 4, p_74875_3_);
                  this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 6, var4, 4, p_74875_3_);
                  this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 4, var4, 6, p_74875_3_);
                  this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 6, var4, 6, p_74875_3_);
               }

               this.func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 5, 3, 5, p_74875_3_);

               for(var4 = 2; var4 <= 8; ++var4) {
                  this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 2, 3, var4, p_74875_3_);
                  this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 3, 3, var4, p_74875_3_);
                  if(var4 <= 3 || var4 >= 7) {
                     this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 4, 3, var4, p_74875_3_);
                     this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 5, 3, var4, p_74875_3_);
                     this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 6, 3, var4, p_74875_3_);
                  }

                  this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 7, 3, var4, p_74875_3_);
                  this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 8, 3, var4, p_74875_3_);
               }

               this.func_151550_a(p_74875_1_, Blocks.field_150468_ap, this.func_151555_a(Blocks.field_150468_ap, 4), 9, 1, 3, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150468_ap, this.func_151555_a(Blocks.field_150468_ap, 4), 9, 2, 3, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150468_ap, this.func_151555_a(Blocks.field_150468_ap, 4), 9, 3, 3, p_74875_3_);
               this.func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 3, 4, 8, WeightedRandomChestContent.func_92080_a(field_75014_c, new WeightedRandomChestContent[]{Items.field_151134_bR.func_92114_b(p_74875_2_)}), 1 + p_74875_2_.nextInt(4));
            }

            return true;
         }
      }

   }

   public static class Stairs extends StructureStrongholdPieces.Stronghold {

      private boolean field_75024_a;
      private static final String __OBFID = "CL_00000498";


      public Stairs() {}

      public Stairs(int p_i2081_1_, Random p_i2081_2_, int p_i2081_3_, int p_i2081_4_) {
         super(p_i2081_1_);
         this.field_75024_a = true;
         this.field_74885_f = p_i2081_2_.nextInt(4);
         this.field_143013_d = StructureStrongholdPieces.Stronghold.Door.OPENING;
         switch(this.field_74885_f) {
         case 0:
         case 2:
            this.field_74887_e = new StructureBoundingBox(p_i2081_3_, 64, p_i2081_4_, p_i2081_3_ + 5 - 1, 74, p_i2081_4_ + 5 - 1);
            break;
         default:
            this.field_74887_e = new StructureBoundingBox(p_i2081_3_, 64, p_i2081_4_, p_i2081_3_ + 5 - 1, 74, p_i2081_4_ + 5 - 1);
         }

      }

      public Stairs(int p_i2082_1_, Random p_i2082_2_, StructureBoundingBox p_i2082_3_, int p_i2082_4_) {
         super(p_i2082_1_);
         this.field_75024_a = false;
         this.field_74885_f = p_i2082_4_;
         this.field_143013_d = this.func_74988_a(p_i2082_2_);
         this.field_74887_e = p_i2082_3_;
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         super.func_143012_a(p_143012_1_);
         p_143012_1_.func_74757_a("Source", this.field_75024_a);
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         super.func_143011_b(p_143011_1_);
         this.field_75024_a = p_143011_1_.func_74767_n("Source");
      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         if(this.field_75024_a) {
            StructureStrongholdPieces.field_75203_d = StructureStrongholdPieces.Crossing.class;
         }

         this.func_74986_a((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
      }

      public static StructureStrongholdPieces.Stairs func_75022_a(List p_75022_0_, Random p_75022_1_, int p_75022_2_, int p_75022_3_, int p_75022_4_, int p_75022_5_, int p_75022_6_) {
         StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_75022_2_, p_75022_3_, p_75022_4_, -1, -7, 0, 5, 11, 5, p_75022_5_);
         return func_74991_a(var7) && StructureComponent.func_74883_a(p_75022_0_, var7) == null?new StructureStrongholdPieces.Stairs(p_75022_6_, p_75022_1_, var7, p_75022_5_):null;
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 10, 4, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 7, 0);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, StructureStrongholdPieces.Stronghold.Door.OPENING, 1, 1, 4);
            this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 2, 6, 1, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 1, 5, 1, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150333_U, 0, 1, 6, 1, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 1, 5, 2, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 1, 4, 3, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150333_U, 0, 1, 5, 3, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 2, 4, 3, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 3, 3, 3, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150333_U, 0, 3, 4, 3, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 3, 3, 2, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 3, 2, 1, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150333_U, 0, 3, 3, 1, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 2, 2, 1, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 1, 1, 1, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150333_U, 0, 1, 2, 1, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 1, 1, 2, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150333_U, 0, 1, 1, 3, p_74875_3_);
            return true;
         }
      }
   }

   public static class Stairs2 extends StructureStrongholdPieces.Stairs {

      public StructureStrongholdPieces.PieceWeight field_75027_a;
      public StructureStrongholdPieces.PortalRoom field_75025_b;
      public List field_75026_c = new ArrayList();
      private static final String __OBFID = "CL_00000499";


      public Stairs2() {}

      public Stairs2(int p_i2083_1_, Random p_i2083_2_, int p_i2083_3_, int p_i2083_4_) {
         super(0, p_i2083_2_, p_i2083_3_, p_i2083_4_);
      }

      public ChunkPosition func_151553_a() {
         return this.field_75025_b != null?this.field_75025_b.func_151553_a():super.func_151553_a();
      }
   }

   public static class StairsStraight extends StructureStrongholdPieces.Stronghold {

      private static final String __OBFID = "CL_00000501";


      public StairsStraight() {}

      public StairsStraight(int p_i2085_1_, Random p_i2085_2_, StructureBoundingBox p_i2085_3_, int p_i2085_4_) {
         super(p_i2085_1_);
         this.field_74885_f = p_i2085_4_;
         this.field_143013_d = this.func_74988_a(p_i2085_2_);
         this.field_74887_e = p_i2085_3_;
      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         this.func_74986_a((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
      }

      public static StructureStrongholdPieces.StairsStraight func_75028_a(List p_75028_0_, Random p_75028_1_, int p_75028_2_, int p_75028_3_, int p_75028_4_, int p_75028_5_, int p_75028_6_) {
         StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_75028_2_, p_75028_3_, p_75028_4_, -1, -7, 0, 5, 11, 8, p_75028_5_);
         return func_74991_a(var7) && StructureComponent.func_74883_a(p_75028_0_, var7) == null?new StructureStrongholdPieces.StairsStraight(p_75028_6_, p_75028_1_, var7, p_75028_5_):null;
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 10, 7, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 7, 0);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, StructureStrongholdPieces.Stronghold.Door.OPENING, 1, 1, 7);
            int var4 = this.func_151555_a(Blocks.field_150446_ar, 2);

            for(int var5 = 0; var5 < 6; ++var5) {
               this.func_151550_a(p_74875_1_, Blocks.field_150446_ar, var4, 1, 6 - var5, 1 + var5, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150446_ar, var4, 2, 6 - var5, 1 + var5, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150446_ar, var4, 3, 6 - var5, 1 + var5, p_74875_3_);
               if(var5 < 5) {
                  this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 1, 5 - var5, 1 + var5, p_74875_3_);
                  this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 2, 5 - var5, 1 + var5, p_74875_3_);
                  this.func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 3, 5 - var5, 1 + var5, p_74875_3_);
               }
            }

            return true;
         }
      }
   }

   static class Stones extends StructureComponent.BlockSelector {

      private static final String __OBFID = "CL_00000497";


      private Stones() {}

      public void func_75062_a(Random p_75062_1_, int p_75062_2_, int p_75062_3_, int p_75062_4_, boolean p_75062_5_) {
         if(p_75062_5_) {
            this.field_151562_a = Blocks.field_150417_aV;
            float var6 = p_75062_1_.nextFloat();
            if(var6 < 0.2F) {
               this.field_75065_b = 2;
            } else if(var6 < 0.5F) {
               this.field_75065_b = 1;
            } else if(var6 < 0.55F) {
               this.field_151562_a = Blocks.field_150418_aU;
               this.field_75065_b = 2;
            } else {
               this.field_75065_b = 0;
            }
         } else {
            this.field_151562_a = Blocks.field_150350_a;
            this.field_75065_b = 0;
         }

      }

      // $FF: synthetic method
      Stones(Object p_i2080_1_) {
         this();
      }
   }

   public static class Straight extends StructureStrongholdPieces.Stronghold {

      private boolean field_75019_b;
      private boolean field_75020_c;
      private static final String __OBFID = "CL_00000500";


      public Straight() {}

      public Straight(int p_i2084_1_, Random p_i2084_2_, StructureBoundingBox p_i2084_3_, int p_i2084_4_) {
         super(p_i2084_1_);
         this.field_74885_f = p_i2084_4_;
         this.field_143013_d = this.func_74988_a(p_i2084_2_);
         this.field_74887_e = p_i2084_3_;
         this.field_75019_b = p_i2084_2_.nextInt(2) == 0;
         this.field_75020_c = p_i2084_2_.nextInt(2) == 0;
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         super.func_143012_a(p_143012_1_);
         p_143012_1_.func_74757_a("Left", this.field_75019_b);
         p_143012_1_.func_74757_a("Right", this.field_75020_c);
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         super.func_143011_b(p_143011_1_);
         this.field_75019_b = p_143011_1_.func_74767_n("Left");
         this.field_75020_c = p_143011_1_.func_74767_n("Right");
      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         this.func_74986_a((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
         if(this.field_75019_b) {
            this.func_74989_b((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 2);
         }

         if(this.field_75020_c) {
            this.func_74987_c((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 2);
         }

      }

      public static StructureStrongholdPieces.Straight func_75018_a(List p_75018_0_, Random p_75018_1_, int p_75018_2_, int p_75018_3_, int p_75018_4_, int p_75018_5_, int p_75018_6_) {
         StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_75018_2_, p_75018_3_, p_75018_4_, -1, -1, 0, 5, 5, 7, p_75018_5_);
         return func_74991_a(var7) && StructureComponent.func_74883_a(p_75018_0_, var7) == null?new StructureStrongholdPieces.Straight(p_75018_6_, p_75018_1_, var7, p_75018_5_):null;
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 4, 6, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 1, 0);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, StructureStrongholdPieces.Stronghold.Door.OPENING, 1, 1, 6);
            this.func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 1, 2, 1, Blocks.field_150478_aa, 0);
            this.func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 3, 2, 1, Blocks.field_150478_aa, 0);
            this.func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 1, 2, 5, Blocks.field_150478_aa, 0);
            this.func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 3, 2, 5, Blocks.field_150478_aa, 0);
            if(this.field_75019_b) {
               this.func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 2, 0, 3, 4, Blocks.field_150350_a, Blocks.field_150350_a, false);
            }

            if(this.field_75020_c) {
               this.func_151549_a(p_74875_1_, p_74875_3_, 4, 1, 2, 4, 3, 4, Blocks.field_150350_a, Blocks.field_150350_a, false);
            }

            return true;
         }
      }
   }

   abstract static class Stronghold extends StructureComponent {

      protected StructureStrongholdPieces.Stronghold.Door field_143013_d;
      private static final String __OBFID = "CL_00000503";


      public Stronghold() {
         this.field_143013_d = StructureStrongholdPieces.Stronghold.Door.OPENING;
      }

      protected Stronghold(int p_i2087_1_) {
         super(p_i2087_1_);
         this.field_143013_d = StructureStrongholdPieces.Stronghold.Door.OPENING;
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         p_143012_1_.func_74778_a("EntryDoor", this.field_143013_d.name());
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         this.field_143013_d = StructureStrongholdPieces.Stronghold.Door.valueOf(p_143011_1_.func_74779_i("EntryDoor"));
      }

      protected void func_74990_a(World p_74990_1_, Random p_74990_2_, StructureBoundingBox p_74990_3_, StructureStrongholdPieces.Stronghold.Door p_74990_4_, int p_74990_5_, int p_74990_6_, int p_74990_7_) {
         switch(StructureStrongholdPieces.SwitchDoor.field_75245_a[p_74990_4_.ordinal()]) {
         case 1:
         default:
            this.func_151549_a(p_74990_1_, p_74990_3_, p_74990_5_, p_74990_6_, p_74990_7_, p_74990_5_ + 3 - 1, p_74990_6_ + 3 - 1, p_74990_7_, Blocks.field_150350_a, Blocks.field_150350_a, false);
            break;
         case 2:
            this.func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_, p_74990_6_, p_74990_7_, p_74990_3_);
            this.func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
            this.func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
            this.func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_ + 1, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
            this.func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_ + 2, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
            this.func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
            this.func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_ + 2, p_74990_6_, p_74990_7_, p_74990_3_);
            this.func_151550_a(p_74990_1_, Blocks.field_150466_ao, 0, p_74990_5_ + 1, p_74990_6_, p_74990_7_, p_74990_3_);
            this.func_151550_a(p_74990_1_, Blocks.field_150466_ao, 8, p_74990_5_ + 1, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
            break;
         case 3:
            this.func_151550_a(p_74990_1_, Blocks.field_150350_a, 0, p_74990_5_ + 1, p_74990_6_, p_74990_7_, p_74990_3_);
            this.func_151550_a(p_74990_1_, Blocks.field_150350_a, 0, p_74990_5_ + 1, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
            this.func_151550_a(p_74990_1_, Blocks.field_150411_aY, 0, p_74990_5_, p_74990_6_, p_74990_7_, p_74990_3_);
            this.func_151550_a(p_74990_1_, Blocks.field_150411_aY, 0, p_74990_5_, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
            this.func_151550_a(p_74990_1_, Blocks.field_150411_aY, 0, p_74990_5_, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
            this.func_151550_a(p_74990_1_, Blocks.field_150411_aY, 0, p_74990_5_ + 1, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
            this.func_151550_a(p_74990_1_, Blocks.field_150411_aY, 0, p_74990_5_ + 2, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
            this.func_151550_a(p_74990_1_, Blocks.field_150411_aY, 0, p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
            this.func_151550_a(p_74990_1_, Blocks.field_150411_aY, 0, p_74990_5_ + 2, p_74990_6_, p_74990_7_, p_74990_3_);
            break;
         case 4:
            this.func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_, p_74990_6_, p_74990_7_, p_74990_3_);
            this.func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
            this.func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
            this.func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_ + 1, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
            this.func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_ + 2, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
            this.func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
            this.func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_ + 2, p_74990_6_, p_74990_7_, p_74990_3_);
            this.func_151550_a(p_74990_1_, Blocks.field_150454_av, 0, p_74990_5_ + 1, p_74990_6_, p_74990_7_, p_74990_3_);
            this.func_151550_a(p_74990_1_, Blocks.field_150454_av, 8, p_74990_5_ + 1, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
            this.func_151550_a(p_74990_1_, Blocks.field_150430_aB, this.func_151555_a(Blocks.field_150430_aB, 4), p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_ + 1, p_74990_3_);
            this.func_151550_a(p_74990_1_, Blocks.field_150430_aB, this.func_151555_a(Blocks.field_150430_aB, 3), p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_ - 1, p_74990_3_);
         }

      }

      protected StructureStrongholdPieces.Stronghold.Door func_74988_a(Random p_74988_1_) {
         int var2 = p_74988_1_.nextInt(5);
         switch(var2) {
         case 0:
         case 1:
         default:
            return StructureStrongholdPieces.Stronghold.Door.OPENING;
         case 2:
            return StructureStrongholdPieces.Stronghold.Door.WOOD_DOOR;
         case 3:
            return StructureStrongholdPieces.Stronghold.Door.GRATES;
         case 4:
            return StructureStrongholdPieces.Stronghold.Door.IRON_DOOR;
         }
      }

      protected StructureComponent func_74986_a(StructureStrongholdPieces.Stairs2 p_74986_1_, List p_74986_2_, Random p_74986_3_, int p_74986_4_, int p_74986_5_) {
         switch(this.field_74885_f) {
         case 0:
            return StructureStrongholdPieces.func_75196_c(p_74986_1_, p_74986_2_, p_74986_3_, this.field_74887_e.field_78897_a + p_74986_4_, this.field_74887_e.field_78895_b + p_74986_5_, this.field_74887_e.field_78892_f + 1, this.field_74885_f, this.func_74877_c());
         case 1:
            return StructureStrongholdPieces.func_75196_c(p_74986_1_, p_74986_2_, p_74986_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74986_5_, this.field_74887_e.field_78896_c + p_74986_4_, this.field_74885_f, this.func_74877_c());
         case 2:
            return StructureStrongholdPieces.func_75196_c(p_74986_1_, p_74986_2_, p_74986_3_, this.field_74887_e.field_78897_a + p_74986_4_, this.field_74887_e.field_78895_b + p_74986_5_, this.field_74887_e.field_78896_c - 1, this.field_74885_f, this.func_74877_c());
         case 3:
            return StructureStrongholdPieces.func_75196_c(p_74986_1_, p_74986_2_, p_74986_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74986_5_, this.field_74887_e.field_78896_c + p_74986_4_, this.field_74885_f, this.func_74877_c());
         default:
            return null;
         }
      }

      protected StructureComponent func_74989_b(StructureStrongholdPieces.Stairs2 p_74989_1_, List p_74989_2_, Random p_74989_3_, int p_74989_4_, int p_74989_5_) {
         switch(this.field_74885_f) {
         case 0:
            return StructureStrongholdPieces.func_75196_c(p_74989_1_, p_74989_2_, p_74989_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74989_4_, this.field_74887_e.field_78896_c + p_74989_5_, 1, this.func_74877_c());
         case 1:
            return StructureStrongholdPieces.func_75196_c(p_74989_1_, p_74989_2_, p_74989_3_, this.field_74887_e.field_78897_a + p_74989_5_, this.field_74887_e.field_78895_b + p_74989_4_, this.field_74887_e.field_78896_c - 1, 2, this.func_74877_c());
         case 2:
            return StructureStrongholdPieces.func_75196_c(p_74989_1_, p_74989_2_, p_74989_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74989_4_, this.field_74887_e.field_78896_c + p_74989_5_, 1, this.func_74877_c());
         case 3:
            return StructureStrongholdPieces.func_75196_c(p_74989_1_, p_74989_2_, p_74989_3_, this.field_74887_e.field_78897_a + p_74989_5_, this.field_74887_e.field_78895_b + p_74989_4_, this.field_74887_e.field_78896_c - 1, 2, this.func_74877_c());
         default:
            return null;
         }
      }

      protected StructureComponent func_74987_c(StructureStrongholdPieces.Stairs2 p_74987_1_, List p_74987_2_, Random p_74987_3_, int p_74987_4_, int p_74987_5_) {
         switch(this.field_74885_f) {
         case 0:
            return StructureStrongholdPieces.func_75196_c(p_74987_1_, p_74987_2_, p_74987_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74987_4_, this.field_74887_e.field_78896_c + p_74987_5_, 3, this.func_74877_c());
         case 1:
            return StructureStrongholdPieces.func_75196_c(p_74987_1_, p_74987_2_, p_74987_3_, this.field_74887_e.field_78897_a + p_74987_5_, this.field_74887_e.field_78895_b + p_74987_4_, this.field_74887_e.field_78892_f + 1, 0, this.func_74877_c());
         case 2:
            return StructureStrongholdPieces.func_75196_c(p_74987_1_, p_74987_2_, p_74987_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74987_4_, this.field_74887_e.field_78896_c + p_74987_5_, 3, this.func_74877_c());
         case 3:
            return StructureStrongholdPieces.func_75196_c(p_74987_1_, p_74987_2_, p_74987_3_, this.field_74887_e.field_78897_a + p_74987_5_, this.field_74887_e.field_78895_b + p_74987_4_, this.field_74887_e.field_78892_f + 1, 0, this.func_74877_c());
         default:
            return null;
         }
      }

      protected static boolean func_74991_a(StructureBoundingBox p_74991_0_) {
         return p_74991_0_ != null && p_74991_0_.field_78895_b > 10;
      }

      public static enum Door {

         OPENING("OPENING", 0),
         WOOD_DOOR("WOOD_DOOR", 1),
         GRATES("GRATES", 2),
         IRON_DOOR("IRON_DOOR", 3);
         // $FF: synthetic field
         private static final StructureStrongholdPieces.Stronghold.Door[] $VALUES = new StructureStrongholdPieces.Stronghold.Door[]{OPENING, WOOD_DOOR, GRATES, IRON_DOOR};
         private static final String __OBFID = "CL_00000504";


         private Door(String p_i2086_1_, int p_i2086_2_) {}

      }
   }

   // $FF: synthetic class
   static final class SwitchDoor {

      // $FF: synthetic field
      static final int[] field_75245_a = new int[StructureStrongholdPieces.Stronghold.Door.values().length];
      private static final String __OBFID = "CL_00000486";


      static {
         try {
            field_75245_a[StructureStrongholdPieces.Stronghold.Door.OPENING.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_75245_a[StructureStrongholdPieces.Stronghold.Door.WOOD_DOOR.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_75245_a[StructureStrongholdPieces.Stronghold.Door.GRATES.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_75245_a[StructureStrongholdPieces.Stronghold.Door.IRON_DOOR.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
