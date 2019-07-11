package net.minecraft.world.gen.structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class StructureVillagePieces {

   private static final String __OBFID = "CL_00000516";


   public static void func_143016_a() {
      MapGenStructureIO.func_143031_a(StructureVillagePieces.House1.class, "ViBH");
      MapGenStructureIO.func_143031_a(StructureVillagePieces.Field1.class, "ViDF");
      MapGenStructureIO.func_143031_a(StructureVillagePieces.Field2.class, "ViF");
      MapGenStructureIO.func_143031_a(StructureVillagePieces.Torch.class, "ViL");
      MapGenStructureIO.func_143031_a(StructureVillagePieces.Hall.class, "ViPH");
      MapGenStructureIO.func_143031_a(StructureVillagePieces.House4Garden.class, "ViSH");
      MapGenStructureIO.func_143031_a(StructureVillagePieces.WoodHut.class, "ViSmH");
      MapGenStructureIO.func_143031_a(StructureVillagePieces.Church.class, "ViST");
      MapGenStructureIO.func_143031_a(StructureVillagePieces.House2.class, "ViS");
      MapGenStructureIO.func_143031_a(StructureVillagePieces.Start.class, "ViStart");
      MapGenStructureIO.func_143031_a(StructureVillagePieces.Path.class, "ViSR");
      MapGenStructureIO.func_143031_a(StructureVillagePieces.House3.class, "ViTRH");
      MapGenStructureIO.func_143031_a(StructureVillagePieces.Well.class, "ViW");
   }

   public static List func_75084_a(Random p_75084_0_, int p_75084_1_) {
      ArrayList var2 = new ArrayList();
      var2.add(new StructureVillagePieces.PieceWeight(StructureVillagePieces.House4Garden.class, 4, MathHelper.func_76136_a(p_75084_0_, 2 + p_75084_1_, 4 + p_75084_1_ * 2)));
      var2.add(new StructureVillagePieces.PieceWeight(StructureVillagePieces.Church.class, 20, MathHelper.func_76136_a(p_75084_0_, 0 + p_75084_1_, 1 + p_75084_1_)));
      var2.add(new StructureVillagePieces.PieceWeight(StructureVillagePieces.House1.class, 20, MathHelper.func_76136_a(p_75084_0_, 0 + p_75084_1_, 2 + p_75084_1_)));
      var2.add(new StructureVillagePieces.PieceWeight(StructureVillagePieces.WoodHut.class, 3, MathHelper.func_76136_a(p_75084_0_, 2 + p_75084_1_, 5 + p_75084_1_ * 3)));
      var2.add(new StructureVillagePieces.PieceWeight(StructureVillagePieces.Hall.class, 15, MathHelper.func_76136_a(p_75084_0_, 0 + p_75084_1_, 2 + p_75084_1_)));
      var2.add(new StructureVillagePieces.PieceWeight(StructureVillagePieces.Field1.class, 3, MathHelper.func_76136_a(p_75084_0_, 1 + p_75084_1_, 4 + p_75084_1_)));
      var2.add(new StructureVillagePieces.PieceWeight(StructureVillagePieces.Field2.class, 3, MathHelper.func_76136_a(p_75084_0_, 2 + p_75084_1_, 4 + p_75084_1_ * 2)));
      var2.add(new StructureVillagePieces.PieceWeight(StructureVillagePieces.House2.class, 15, MathHelper.func_76136_a(p_75084_0_, 0, 1 + p_75084_1_)));
      var2.add(new StructureVillagePieces.PieceWeight(StructureVillagePieces.House3.class, 8, MathHelper.func_76136_a(p_75084_0_, 0 + p_75084_1_, 3 + p_75084_1_ * 2)));
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         if(((StructureVillagePieces.PieceWeight)var3.next()).field_75087_d == 0) {
            var3.remove();
         }
      }

      return var2;
   }

   private static int func_75079_a(List p_75079_0_) {
      boolean var1 = false;
      int var2 = 0;

      StructureVillagePieces.PieceWeight var4;
      for(Iterator var3 = p_75079_0_.iterator(); var3.hasNext(); var2 += var4.field_75088_b) {
         var4 = (StructureVillagePieces.PieceWeight)var3.next();
         if(var4.field_75087_d > 0 && var4.field_75089_c < var4.field_75087_d) {
            var1 = true;
         }
      }

      return var1?var2:-1;
   }

   private static StructureVillagePieces.Village func_75083_a(StructureVillagePieces.Start p_75083_0_, StructureVillagePieces.PieceWeight p_75083_1_, List p_75083_2_, Random p_75083_3_, int p_75083_4_, int p_75083_5_, int p_75083_6_, int p_75083_7_, int p_75083_8_) {
      Class var9 = p_75083_1_.field_75090_a;
      Object var10 = null;
      if(var9 == StructureVillagePieces.House4Garden.class) {
         var10 = StructureVillagePieces.House4Garden.func_74912_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
      } else if(var9 == StructureVillagePieces.Church.class) {
         var10 = StructureVillagePieces.Church.func_74919_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
      } else if(var9 == StructureVillagePieces.House1.class) {
         var10 = StructureVillagePieces.House1.func_74898_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
      } else if(var9 == StructureVillagePieces.WoodHut.class) {
         var10 = StructureVillagePieces.WoodHut.func_74908_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
      } else if(var9 == StructureVillagePieces.Hall.class) {
         var10 = StructureVillagePieces.Hall.func_74906_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
      } else if(var9 == StructureVillagePieces.Field1.class) {
         var10 = StructureVillagePieces.Field1.func_74900_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
      } else if(var9 == StructureVillagePieces.Field2.class) {
         var10 = StructureVillagePieces.Field2.func_74902_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
      } else if(var9 == StructureVillagePieces.House2.class) {
         var10 = StructureVillagePieces.House2.func_74915_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
      } else if(var9 == StructureVillagePieces.House3.class) {
         var10 = StructureVillagePieces.House3.func_74921_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
      }

      return (StructureVillagePieces.Village)var10;
   }

   private static StructureVillagePieces.Village func_75081_c(StructureVillagePieces.Start p_75081_0_, List p_75081_1_, Random p_75081_2_, int p_75081_3_, int p_75081_4_, int p_75081_5_, int p_75081_6_, int p_75081_7_) {
      int var8 = func_75079_a(p_75081_0_.field_74931_h);
      if(var8 <= 0) {
         return null;
      } else {
         int var9 = 0;

         while(var9 < 5) {
            ++var9;
            int var10 = p_75081_2_.nextInt(var8);
            Iterator var11 = p_75081_0_.field_74931_h.iterator();

            while(var11.hasNext()) {
               StructureVillagePieces.PieceWeight var12 = (StructureVillagePieces.PieceWeight)var11.next();
               var10 -= var12.field_75088_b;
               if(var10 < 0) {
                  if(!var12.func_75085_a(p_75081_7_) || var12 == p_75081_0_.field_74926_d && p_75081_0_.field_74931_h.size() > 1) {
                     break;
                  }

                  StructureVillagePieces.Village var13 = func_75083_a(p_75081_0_, var12, p_75081_1_, p_75081_2_, p_75081_3_, p_75081_4_, p_75081_5_, p_75081_6_, p_75081_7_);
                  if(var13 != null) {
                     ++var12.field_75089_c;
                     p_75081_0_.field_74926_d = var12;
                     if(!var12.func_75086_a()) {
                        p_75081_0_.field_74931_h.remove(var12);
                     }

                     return var13;
                  }
               }
            }
         }

         StructureBoundingBox var14 = StructureVillagePieces.Torch.func_74904_a(p_75081_0_, p_75081_1_, p_75081_2_, p_75081_3_, p_75081_4_, p_75081_5_, p_75081_6_);
         if(var14 != null) {
            return new StructureVillagePieces.Torch(p_75081_0_, p_75081_7_, p_75081_2_, var14, p_75081_6_);
         } else {
            return null;
         }
      }
   }

   private static StructureComponent func_75077_d(StructureVillagePieces.Start p_75077_0_, List p_75077_1_, Random p_75077_2_, int p_75077_3_, int p_75077_4_, int p_75077_5_, int p_75077_6_, int p_75077_7_) {
      if(p_75077_7_ > 50) {
         return null;
      } else if(Math.abs(p_75077_3_ - p_75077_0_.func_74874_b().field_78897_a) <= 112 && Math.abs(p_75077_5_ - p_75077_0_.func_74874_b().field_78896_c) <= 112) {
         StructureVillagePieces.Village var8 = func_75081_c(p_75077_0_, p_75077_1_, p_75077_2_, p_75077_3_, p_75077_4_, p_75077_5_, p_75077_6_, p_75077_7_ + 1);
         if(var8 != null) {
            int var9 = (var8.field_74887_e.field_78897_a + var8.field_74887_e.field_78893_d) / 2;
            int var10 = (var8.field_74887_e.field_78896_c + var8.field_74887_e.field_78892_f) / 2;
            int var11 = var8.field_74887_e.field_78893_d - var8.field_74887_e.field_78897_a;
            int var12 = var8.field_74887_e.field_78892_f - var8.field_74887_e.field_78896_c;
            int var13 = var11 > var12?var11:var12;
            if(p_75077_0_.func_74925_d().func_76940_a(var9, var10, var13 / 2 + 4, MapGenVillage.field_75055_e)) {
               p_75077_1_.add(var8);
               p_75077_0_.field_74932_i.add(var8);
               return var8;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private static StructureComponent func_75080_e(StructureVillagePieces.Start p_75080_0_, List p_75080_1_, Random p_75080_2_, int p_75080_3_, int p_75080_4_, int p_75080_5_, int p_75080_6_, int p_75080_7_) {
      if(p_75080_7_ > 3 + p_75080_0_.field_74928_c) {
         return null;
      } else if(Math.abs(p_75080_3_ - p_75080_0_.func_74874_b().field_78897_a) <= 112 && Math.abs(p_75080_5_ - p_75080_0_.func_74874_b().field_78896_c) <= 112) {
         StructureBoundingBox var8 = StructureVillagePieces.Path.func_74933_a(p_75080_0_, p_75080_1_, p_75080_2_, p_75080_3_, p_75080_4_, p_75080_5_, p_75080_6_);
         if(var8 != null && var8.field_78895_b > 10) {
            StructureVillagePieces.Path var9 = new StructureVillagePieces.Path(p_75080_0_, p_75080_7_, p_75080_2_, var8, p_75080_6_);
            int var10 = (var9.field_74887_e.field_78897_a + var9.field_74887_e.field_78893_d) / 2;
            int var11 = (var9.field_74887_e.field_78896_c + var9.field_74887_e.field_78892_f) / 2;
            int var12 = var9.field_74887_e.field_78893_d - var9.field_74887_e.field_78897_a;
            int var13 = var9.field_74887_e.field_78892_f - var9.field_74887_e.field_78896_c;
            int var14 = var12 > var13?var12:var13;
            if(p_75080_0_.func_74925_d().func_76940_a(var10, var11, var14 / 2 + 4, MapGenVillage.field_75055_e)) {
               p_75080_1_.add(var9);
               p_75080_0_.field_74930_j.add(var9);
               return var9;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   public static class Church extends StructureVillagePieces.Village {

      private static final String __OBFID = "CL_00000525";


      public Church() {}

      public Church(StructureVillagePieces.Start p_i2102_1_, int p_i2102_2_, Random p_i2102_3_, StructureBoundingBox p_i2102_4_, int p_i2102_5_) {
         super(p_i2102_1_, p_i2102_2_);
         this.field_74885_f = p_i2102_5_;
         this.field_74887_e = p_i2102_4_;
      }

      public static StructureVillagePieces.Church func_74919_a(StructureVillagePieces.Start p_74919_0_, List p_74919_1_, Random p_74919_2_, int p_74919_3_, int p_74919_4_, int p_74919_5_, int p_74919_6_, int p_74919_7_) {
         StructureBoundingBox var8 = StructureBoundingBox.func_78889_a(p_74919_3_, p_74919_4_, p_74919_5_, 0, 0, 0, 5, 12, 9, p_74919_6_);
         return func_74895_a(var8) && StructureComponent.func_74883_a(p_74919_1_, var8) == null?new StructureVillagePieces.Church(p_74919_0_, p_74919_7_, p_74919_2_, var8, p_74919_6_):null;
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.field_143015_k < 0) {
            this.field_143015_k = this.func_74889_b(p_74875_1_, p_74875_3_);
            if(this.field_143015_k < 0) {
               return true;
            }

            this.field_74887_e.func_78886_a(0, this.field_143015_k - this.field_74887_e.field_78894_e + 12 - 1, 0);
         }

         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 1, 3, 3, 7, Blocks.field_150350_a, Blocks.field_150350_a, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 5, 1, 3, 9, 3, Blocks.field_150350_a, Blocks.field_150350_a, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 0, 3, 0, 8, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 0, 3, 10, 0, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 10, 3, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 10, 3, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 4, 0, 4, 7, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 4, 0, 4, 4, 4, 7, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 8, 3, 4, 8, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 5, 4, 3, 10, 4, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 5, 5, 3, 5, 7, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 9, 0, 4, 9, 4, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 4, 0, 4, 4, 4, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 0, 11, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 4, 11, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 2, 11, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 2, 11, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 1, 1, 6, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 1, 1, 7, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 2, 1, 7, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 3, 1, 6, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 3, 1, 7, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150446_ar, this.func_151555_a(Blocks.field_150446_ar, 3), 1, 1, 5, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150446_ar, this.func_151555_a(Blocks.field_150446_ar, 3), 2, 1, 6, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150446_ar, this.func_151555_a(Blocks.field_150446_ar, 3), 3, 1, 5, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150446_ar, this.func_151555_a(Blocks.field_150446_ar, 1), 1, 2, 7, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150446_ar, this.func_151555_a(Blocks.field_150446_ar, 0), 3, 2, 7, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 2, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 3, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 4, 2, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 4, 3, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 6, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 7, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 4, 6, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 4, 7, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 2, 6, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 2, 7, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 2, 6, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 2, 7, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 3, 6, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 4, 3, 6, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 2, 3, 8, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 2, 4, 7, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 1, 4, 6, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 3, 4, 6, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 2, 4, 5, p_74875_3_);
         int var4 = this.func_151555_a(Blocks.field_150468_ap, 4);

         int var5;
         for(var5 = 1; var5 <= 9; ++var5) {
            this.func_151550_a(p_74875_1_, Blocks.field_150468_ap, var4, 3, var5, 3, p_74875_3_);
         }

         this.func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 2, 1, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 2, 2, 0, p_74875_3_);
         this.func_74881_a(p_74875_1_, p_74875_3_, p_74875_2_, 2, 1, 0, this.func_151555_a(Blocks.field_150466_ao, 1));
         if(this.func_151548_a(p_74875_1_, 2, 0, -1, p_74875_3_).func_149688_o() == Material.field_151579_a && this.func_151548_a(p_74875_1_, 2, -1, -1, p_74875_3_).func_149688_o() != Material.field_151579_a) {
            this.func_151550_a(p_74875_1_, Blocks.field_150446_ar, this.func_151555_a(Blocks.field_150446_ar, 3), 2, 0, -1, p_74875_3_);
         }

         for(var5 = 0; var5 < 9; ++var5) {
            for(int var6 = 0; var6 < 5; ++var6) {
               this.func_74871_b(p_74875_1_, var6, 12, var5, p_74875_3_);
               this.func_151554_b(p_74875_1_, Blocks.field_150347_e, 0, var6, -1, var5, p_74875_3_);
            }
         }

         this.func_74893_a(p_74875_1_, p_74875_3_, 2, 1, 2, 1);
         return true;
      }

      protected int func_74888_b(int p_74888_1_) {
         return 2;
      }
   }

   public static class Field1 extends StructureVillagePieces.Village {

      private Block field_82679_b;
      private Block field_82680_c;
      private Block field_82678_d;
      private Block field_82681_h;
      private static final String __OBFID = "CL_00000518";


      public Field1() {}

      public Field1(StructureVillagePieces.Start p_i2095_1_, int p_i2095_2_, Random p_i2095_3_, StructureBoundingBox p_i2095_4_, int p_i2095_5_) {
         super(p_i2095_1_, p_i2095_2_);
         this.field_74885_f = p_i2095_5_;
         this.field_74887_e = p_i2095_4_;
         this.field_82679_b = this.func_151559_a(p_i2095_3_);
         this.field_82680_c = this.func_151559_a(p_i2095_3_);
         this.field_82678_d = this.func_151559_a(p_i2095_3_);
         this.field_82681_h = this.func_151559_a(p_i2095_3_);
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         super.func_143012_a(p_143012_1_);
         p_143012_1_.func_74768_a("CA", Block.field_149771_c.func_148757_b(this.field_82679_b));
         p_143012_1_.func_74768_a("CB", Block.field_149771_c.func_148757_b(this.field_82680_c));
         p_143012_1_.func_74768_a("CC", Block.field_149771_c.func_148757_b(this.field_82678_d));
         p_143012_1_.func_74768_a("CD", Block.field_149771_c.func_148757_b(this.field_82681_h));
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         super.func_143011_b(p_143011_1_);
         this.field_82679_b = Block.func_149729_e(p_143011_1_.func_74762_e("CA"));
         this.field_82680_c = Block.func_149729_e(p_143011_1_.func_74762_e("CB"));
         this.field_82678_d = Block.func_149729_e(p_143011_1_.func_74762_e("CC"));
         this.field_82681_h = Block.func_149729_e(p_143011_1_.func_74762_e("CD"));
      }

      private Block func_151559_a(Random p_151559_1_) {
         switch(p_151559_1_.nextInt(5)) {
         case 0:
            return Blocks.field_150459_bM;
         case 1:
            return Blocks.field_150469_bN;
         default:
            return Blocks.field_150464_aj;
         }
      }

      public static StructureVillagePieces.Field1 func_74900_a(StructureVillagePieces.Start p_74900_0_, List p_74900_1_, Random p_74900_2_, int p_74900_3_, int p_74900_4_, int p_74900_5_, int p_74900_6_, int p_74900_7_) {
         StructureBoundingBox var8 = StructureBoundingBox.func_78889_a(p_74900_3_, p_74900_4_, p_74900_5_, 0, 0, 0, 13, 4, 9, p_74900_6_);
         return func_74895_a(var8) && StructureComponent.func_74883_a(p_74900_1_, var8) == null?new StructureVillagePieces.Field1(p_74900_0_, p_74900_7_, p_74900_2_, var8, p_74900_6_):null;
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.field_143015_k < 0) {
            this.field_143015_k = this.func_74889_b(p_74875_1_, p_74875_3_);
            if(this.field_143015_k < 0) {
               return true;
            }

            this.field_74887_e.func_78886_a(0, this.field_143015_k - this.field_74887_e.field_78894_e + 4 - 1, 0);
         }

         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 0, 12, 4, 8, Blocks.field_150350_a, Blocks.field_150350_a, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 1, 2, 0, 7, Blocks.field_150458_ak, Blocks.field_150458_ak, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 4, 0, 1, 5, 0, 7, Blocks.field_150458_ak, Blocks.field_150458_ak, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 7, 0, 1, 8, 0, 7, Blocks.field_150458_ak, Blocks.field_150458_ak, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 10, 0, 1, 11, 0, 7, Blocks.field_150458_ak, Blocks.field_150458_ak, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 0, 0, 8, Blocks.field_150364_r, Blocks.field_150364_r, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 6, 0, 0, 6, 0, 8, Blocks.field_150364_r, Blocks.field_150364_r, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 12, 0, 0, 12, 0, 8, Blocks.field_150364_r, Blocks.field_150364_r, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 0, 11, 0, 0, Blocks.field_150364_r, Blocks.field_150364_r, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 8, 11, 0, 8, Blocks.field_150364_r, Blocks.field_150364_r, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 3, 0, 1, 3, 0, 7, Blocks.field_150355_j, Blocks.field_150355_j, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 9, 0, 1, 9, 0, 7, Blocks.field_150355_j, Blocks.field_150355_j, false);

         int var4;
         for(var4 = 1; var4 <= 7; ++var4) {
            this.func_151550_a(p_74875_1_, this.field_82679_b, MathHelper.func_76136_a(p_74875_2_, 2, 7), 1, 1, var4, p_74875_3_);
            this.func_151550_a(p_74875_1_, this.field_82679_b, MathHelper.func_76136_a(p_74875_2_, 2, 7), 2, 1, var4, p_74875_3_);
            this.func_151550_a(p_74875_1_, this.field_82680_c, MathHelper.func_76136_a(p_74875_2_, 2, 7), 4, 1, var4, p_74875_3_);
            this.func_151550_a(p_74875_1_, this.field_82680_c, MathHelper.func_76136_a(p_74875_2_, 2, 7), 5, 1, var4, p_74875_3_);
            this.func_151550_a(p_74875_1_, this.field_82678_d, MathHelper.func_76136_a(p_74875_2_, 2, 7), 7, 1, var4, p_74875_3_);
            this.func_151550_a(p_74875_1_, this.field_82678_d, MathHelper.func_76136_a(p_74875_2_, 2, 7), 8, 1, var4, p_74875_3_);
            this.func_151550_a(p_74875_1_, this.field_82681_h, MathHelper.func_76136_a(p_74875_2_, 2, 7), 10, 1, var4, p_74875_3_);
            this.func_151550_a(p_74875_1_, this.field_82681_h, MathHelper.func_76136_a(p_74875_2_, 2, 7), 11, 1, var4, p_74875_3_);
         }

         for(var4 = 0; var4 < 9; ++var4) {
            for(int var5 = 0; var5 < 13; ++var5) {
               this.func_74871_b(p_74875_1_, var5, 4, var4, p_74875_3_);
               this.func_151554_b(p_74875_1_, Blocks.field_150346_d, 0, var5, -1, var4, p_74875_3_);
            }
         }

         return true;
      }
   }

   public static class Field2 extends StructureVillagePieces.Village {

      private Block field_82675_b;
      private Block field_82676_c;
      private static final String __OBFID = "CL_00000519";


      public Field2() {}

      public Field2(StructureVillagePieces.Start p_i2096_1_, int p_i2096_2_, Random p_i2096_3_, StructureBoundingBox p_i2096_4_, int p_i2096_5_) {
         super(p_i2096_1_, p_i2096_2_);
         this.field_74885_f = p_i2096_5_;
         this.field_74887_e = p_i2096_4_;
         this.field_82675_b = this.func_151560_a(p_i2096_3_);
         this.field_82676_c = this.func_151560_a(p_i2096_3_);
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         super.func_143012_a(p_143012_1_);
         p_143012_1_.func_74768_a("CA", Block.field_149771_c.func_148757_b(this.field_82675_b));
         p_143012_1_.func_74768_a("CB", Block.field_149771_c.func_148757_b(this.field_82676_c));
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         super.func_143011_b(p_143011_1_);
         this.field_82675_b = Block.func_149729_e(p_143011_1_.func_74762_e("CA"));
         this.field_82676_c = Block.func_149729_e(p_143011_1_.func_74762_e("CB"));
      }

      private Block func_151560_a(Random p_151560_1_) {
         switch(p_151560_1_.nextInt(5)) {
         case 0:
            return Blocks.field_150459_bM;
         case 1:
            return Blocks.field_150469_bN;
         default:
            return Blocks.field_150464_aj;
         }
      }

      public static StructureVillagePieces.Field2 func_74902_a(StructureVillagePieces.Start p_74902_0_, List p_74902_1_, Random p_74902_2_, int p_74902_3_, int p_74902_4_, int p_74902_5_, int p_74902_6_, int p_74902_7_) {
         StructureBoundingBox var8 = StructureBoundingBox.func_78889_a(p_74902_3_, p_74902_4_, p_74902_5_, 0, 0, 0, 7, 4, 9, p_74902_6_);
         return func_74895_a(var8) && StructureComponent.func_74883_a(p_74902_1_, var8) == null?new StructureVillagePieces.Field2(p_74902_0_, p_74902_7_, p_74902_2_, var8, p_74902_6_):null;
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.field_143015_k < 0) {
            this.field_143015_k = this.func_74889_b(p_74875_1_, p_74875_3_);
            if(this.field_143015_k < 0) {
               return true;
            }

            this.field_74887_e.func_78886_a(0, this.field_143015_k - this.field_74887_e.field_78894_e + 4 - 1, 0);
         }

         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 0, 6, 4, 8, Blocks.field_150350_a, Blocks.field_150350_a, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 1, 2, 0, 7, Blocks.field_150458_ak, Blocks.field_150458_ak, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 4, 0, 1, 5, 0, 7, Blocks.field_150458_ak, Blocks.field_150458_ak, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 0, 0, 8, Blocks.field_150364_r, Blocks.field_150364_r, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 6, 0, 0, 6, 0, 8, Blocks.field_150364_r, Blocks.field_150364_r, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 0, 5, 0, 0, Blocks.field_150364_r, Blocks.field_150364_r, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 8, 5, 0, 8, Blocks.field_150364_r, Blocks.field_150364_r, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 3, 0, 1, 3, 0, 7, Blocks.field_150355_j, Blocks.field_150355_j, false);

         int var4;
         for(var4 = 1; var4 <= 7; ++var4) {
            this.func_151550_a(p_74875_1_, this.field_82675_b, MathHelper.func_76136_a(p_74875_2_, 2, 7), 1, 1, var4, p_74875_3_);
            this.func_151550_a(p_74875_1_, this.field_82675_b, MathHelper.func_76136_a(p_74875_2_, 2, 7), 2, 1, var4, p_74875_3_);
            this.func_151550_a(p_74875_1_, this.field_82676_c, MathHelper.func_76136_a(p_74875_2_, 2, 7), 4, 1, var4, p_74875_3_);
            this.func_151550_a(p_74875_1_, this.field_82676_c, MathHelper.func_76136_a(p_74875_2_, 2, 7), 5, 1, var4, p_74875_3_);
         }

         for(var4 = 0; var4 < 9; ++var4) {
            for(int var5 = 0; var5 < 7; ++var5) {
               this.func_74871_b(p_74875_1_, var5, 4, var4, p_74875_3_);
               this.func_151554_b(p_74875_1_, Blocks.field_150346_d, 0, var5, -1, var4, p_74875_3_);
            }
         }

         return true;
      }
   }

   public static class Hall extends StructureVillagePieces.Village {

      private static final String __OBFID = "CL_00000522";


      public Hall() {}

      public Hall(StructureVillagePieces.Start p_i2099_1_, int p_i2099_2_, Random p_i2099_3_, StructureBoundingBox p_i2099_4_, int p_i2099_5_) {
         super(p_i2099_1_, p_i2099_2_);
         this.field_74885_f = p_i2099_5_;
         this.field_74887_e = p_i2099_4_;
      }

      public static StructureVillagePieces.Hall func_74906_a(StructureVillagePieces.Start p_74906_0_, List p_74906_1_, Random p_74906_2_, int p_74906_3_, int p_74906_4_, int p_74906_5_, int p_74906_6_, int p_74906_7_) {
         StructureBoundingBox var8 = StructureBoundingBox.func_78889_a(p_74906_3_, p_74906_4_, p_74906_5_, 0, 0, 0, 9, 7, 11, p_74906_6_);
         return func_74895_a(var8) && StructureComponent.func_74883_a(p_74906_1_, var8) == null?new StructureVillagePieces.Hall(p_74906_0_, p_74906_7_, p_74906_2_, var8, p_74906_6_):null;
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.field_143015_k < 0) {
            this.field_143015_k = this.func_74889_b(p_74875_1_, p_74875_3_);
            if(this.field_143015_k < 0) {
               return true;
            }

            this.field_74887_e.func_78886_a(0, this.field_143015_k - this.field_74887_e.field_78894_e + 7 - 1, 0);
         }

         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 1, 7, 4, 4, Blocks.field_150350_a, Blocks.field_150350_a, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 2, 1, 6, 8, 4, 10, Blocks.field_150350_a, Blocks.field_150350_a, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 2, 0, 6, 8, 0, 10, Blocks.field_150346_d, Blocks.field_150346_d, false);
         this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 6, 0, 6, p_74875_3_);
         this.func_151549_a(p_74875_1_, p_74875_3_, 2, 1, 6, 2, 1, 10, Blocks.field_150422_aJ, Blocks.field_150422_aJ, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 8, 1, 6, 8, 1, 10, Blocks.field_150422_aJ, Blocks.field_150422_aJ, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 3, 1, 10, 7, 1, 10, Blocks.field_150422_aJ, Blocks.field_150422_aJ, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 1, 7, 0, 4, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 0, 3, 5, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 8, 0, 0, 8, 3, 5, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 0, 7, 1, 0, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 5, 7, 1, 5, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 2, 0, 7, 3, 0, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 2, 5, 7, 3, 5, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 4, 1, 8, 4, 1, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 4, 4, 8, 4, 4, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 5, 2, 8, 5, 3, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 0, 4, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 0, 4, 3, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 8, 4, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 8, 4, 3, p_74875_3_);
         int var4 = this.func_151555_a(Blocks.field_150476_ad, 3);
         int var5 = this.func_151555_a(Blocks.field_150476_ad, 2);

         int var6;
         int var7;
         for(var6 = -1; var6 <= 2; ++var6) {
            for(var7 = 0; var7 <= 8; ++var7) {
               this.func_151550_a(p_74875_1_, Blocks.field_150476_ad, var4, var7, 4 + var6, var6, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150476_ad, var5, var7, 4 + var6, 5 - var6, p_74875_3_);
            }
         }

         this.func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 0, 2, 1, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 0, 2, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 8, 2, 1, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 8, 2, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 2, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 2, 3, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 8, 2, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 8, 2, 3, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 2, 2, 5, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 3, 2, 5, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 5, 2, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 6, 2, 5, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 2, 1, 3, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150452_aw, 0, 2, 2, 3, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 1, 1, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150476_ad, this.func_151555_a(Blocks.field_150476_ad, 3), 2, 1, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150476_ad, this.func_151555_a(Blocks.field_150476_ad, 1), 1, 1, 3, p_74875_3_);
         this.func_151549_a(p_74875_1_, p_74875_3_, 5, 0, 1, 7, 0, 3, Blocks.field_150334_T, Blocks.field_150334_T, false);
         this.func_151550_a(p_74875_1_, Blocks.field_150334_T, 0, 6, 1, 1, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150334_T, 0, 6, 1, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 2, 1, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 2, 2, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 2, 3, 1, p_74875_3_);
         this.func_74881_a(p_74875_1_, p_74875_3_, p_74875_2_, 2, 1, 0, this.func_151555_a(Blocks.field_150466_ao, 1));
         if(this.func_151548_a(p_74875_1_, 2, 0, -1, p_74875_3_).func_149688_o() == Material.field_151579_a && this.func_151548_a(p_74875_1_, 2, -1, -1, p_74875_3_).func_149688_o() != Material.field_151579_a) {
            this.func_151550_a(p_74875_1_, Blocks.field_150446_ar, this.func_151555_a(Blocks.field_150446_ar, 3), 2, 0, -1, p_74875_3_);
         }

         this.func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 6, 1, 5, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 6, 2, 5, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 6, 3, 4, p_74875_3_);
         this.func_74881_a(p_74875_1_, p_74875_3_, p_74875_2_, 6, 1, 5, this.func_151555_a(Blocks.field_150466_ao, 1));

         for(var6 = 0; var6 < 5; ++var6) {
            for(var7 = 0; var7 < 9; ++var7) {
               this.func_74871_b(p_74875_1_, var7, 7, var6, p_74875_3_);
               this.func_151554_b(p_74875_1_, Blocks.field_150347_e, 0, var7, -1, var6, p_74875_3_);
            }
         }

         this.func_74893_a(p_74875_1_, p_74875_3_, 4, 1, 2, 2);
         return true;
      }

      protected int func_74888_b(int p_74888_1_) {
         return p_74888_1_ == 0?4:0;
      }
   }

   public static class House1 extends StructureVillagePieces.Village {

      private static final String __OBFID = "CL_00000517";


      public House1() {}

      public House1(StructureVillagePieces.Start p_i2094_1_, int p_i2094_2_, Random p_i2094_3_, StructureBoundingBox p_i2094_4_, int p_i2094_5_) {
         super(p_i2094_1_, p_i2094_2_);
         this.field_74885_f = p_i2094_5_;
         this.field_74887_e = p_i2094_4_;
      }

      public static StructureVillagePieces.House1 func_74898_a(StructureVillagePieces.Start p_74898_0_, List p_74898_1_, Random p_74898_2_, int p_74898_3_, int p_74898_4_, int p_74898_5_, int p_74898_6_, int p_74898_7_) {
         StructureBoundingBox var8 = StructureBoundingBox.func_78889_a(p_74898_3_, p_74898_4_, p_74898_5_, 0, 0, 0, 9, 9, 6, p_74898_6_);
         return func_74895_a(var8) && StructureComponent.func_74883_a(p_74898_1_, var8) == null?new StructureVillagePieces.House1(p_74898_0_, p_74898_7_, p_74898_2_, var8, p_74898_6_):null;
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.field_143015_k < 0) {
            this.field_143015_k = this.func_74889_b(p_74875_1_, p_74875_3_);
            if(this.field_143015_k < 0) {
               return true;
            }

            this.field_74887_e.func_78886_a(0, this.field_143015_k - this.field_74887_e.field_78894_e + 9 - 1, 0);
         }

         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 1, 7, 5, 4, Blocks.field_150350_a, Blocks.field_150350_a, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 8, 0, 5, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 5, 0, 8, 5, 5, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 6, 1, 8, 6, 4, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 7, 2, 8, 7, 3, Blocks.field_150347_e, Blocks.field_150347_e, false);
         int var4 = this.func_151555_a(Blocks.field_150476_ad, 3);
         int var5 = this.func_151555_a(Blocks.field_150476_ad, 2);

         int var6;
         int var7;
         for(var6 = -1; var6 <= 2; ++var6) {
            for(var7 = 0; var7 <= 8; ++var7) {
               this.func_151550_a(p_74875_1_, Blocks.field_150476_ad, var4, var7, 6 + var6, var6, p_74875_3_);
               this.func_151550_a(p_74875_1_, Blocks.field_150476_ad, var5, var7, 6 + var6, 5 - var6, p_74875_3_);
            }
         }

         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 0, 0, 1, 5, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 5, 8, 1, 5, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 8, 1, 0, 8, 1, 4, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 2, 1, 0, 7, 1, 0, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 0, 0, 4, 0, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 5, 0, 4, 5, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 8, 2, 5, 8, 4, 5, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 8, 2, 0, 8, 4, 0, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 1, 0, 4, 4, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 2, 5, 7, 4, 5, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 8, 2, 1, 8, 4, 4, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 2, 0, 7, 4, 0, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 4, 2, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 5, 2, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 6, 2, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 4, 3, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 5, 3, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 6, 3, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 2, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 2, 3, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 3, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 3, 3, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 8, 2, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 8, 2, 3, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 8, 3, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 8, 3, 3, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 2, 2, 5, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 3, 2, 5, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 5, 2, 5, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 6, 2, 5, p_74875_3_);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 4, 1, 7, 4, 1, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 4, 4, 7, 4, 4, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 3, 4, 7, 3, 4, Blocks.field_150342_X, Blocks.field_150342_X, false);
         this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 7, 1, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150476_ad, this.func_151555_a(Blocks.field_150476_ad, 0), 7, 1, 3, p_74875_3_);
         var6 = this.func_151555_a(Blocks.field_150476_ad, 3);
         this.func_151550_a(p_74875_1_, Blocks.field_150476_ad, var6, 6, 1, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150476_ad, var6, 5, 1, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150476_ad, var6, 4, 1, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150476_ad, var6, 3, 1, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 6, 1, 3, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150452_aw, 0, 6, 2, 3, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 4, 1, 3, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150452_aw, 0, 4, 2, 3, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150462_ai, 0, 7, 1, 1, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 1, 1, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 1, 2, 0, p_74875_3_);
         this.func_74881_a(p_74875_1_, p_74875_3_, p_74875_2_, 1, 1, 0, this.func_151555_a(Blocks.field_150466_ao, 1));
         if(this.func_151548_a(p_74875_1_, 1, 0, -1, p_74875_3_).func_149688_o() == Material.field_151579_a && this.func_151548_a(p_74875_1_, 1, -1, -1, p_74875_3_).func_149688_o() != Material.field_151579_a) {
            this.func_151550_a(p_74875_1_, Blocks.field_150446_ar, this.func_151555_a(Blocks.field_150446_ar, 3), 1, 0, -1, p_74875_3_);
         }

         for(var7 = 0; var7 < 6; ++var7) {
            for(int var8 = 0; var8 < 9; ++var8) {
               this.func_74871_b(p_74875_1_, var8, 9, var7, p_74875_3_);
               this.func_151554_b(p_74875_1_, Blocks.field_150347_e, 0, var8, -1, var7, p_74875_3_);
            }
         }

         this.func_74893_a(p_74875_1_, p_74875_3_, 2, 1, 2, 1);
         return true;
      }

      protected int func_74888_b(int p_74888_1_) {
         return 1;
      }
   }

   public static class House2 extends StructureVillagePieces.Village {

      private static final WeightedRandomChestContent[] field_74918_a = new WeightedRandomChestContent[]{new WeightedRandomChestContent(Items.field_151045_i, 0, 1, 3, 3), new WeightedRandomChestContent(Items.field_151042_j, 0, 1, 5, 10), new WeightedRandomChestContent(Items.field_151043_k, 0, 1, 3, 5), new WeightedRandomChestContent(Items.field_151025_P, 0, 1, 3, 15), new WeightedRandomChestContent(Items.field_151034_e, 0, 1, 3, 15), new WeightedRandomChestContent(Items.field_151035_b, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151040_l, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151030_Z, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151028_Y, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151165_aa, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151167_ab, 0, 1, 1, 5), new WeightedRandomChestContent(Item.func_150898_a(Blocks.field_150343_Z), 0, 3, 7, 5), new WeightedRandomChestContent(Item.func_150898_a(Blocks.field_150345_g), 0, 3, 7, 5), new WeightedRandomChestContent(Items.field_151141_av, 0, 1, 1, 3), new WeightedRandomChestContent(Items.field_151138_bX, 0, 1, 1, 1), new WeightedRandomChestContent(Items.field_151136_bY, 0, 1, 1, 1), new WeightedRandomChestContent(Items.field_151125_bZ, 0, 1, 1, 1)};
      private boolean field_74917_c;
      private static final String __OBFID = "CL_00000526";


      public House2() {}

      public House2(StructureVillagePieces.Start p_i2103_1_, int p_i2103_2_, Random p_i2103_3_, StructureBoundingBox p_i2103_4_, int p_i2103_5_) {
         super(p_i2103_1_, p_i2103_2_);
         this.field_74885_f = p_i2103_5_;
         this.field_74887_e = p_i2103_4_;
      }

      public static StructureVillagePieces.House2 func_74915_a(StructureVillagePieces.Start p_74915_0_, List p_74915_1_, Random p_74915_2_, int p_74915_3_, int p_74915_4_, int p_74915_5_, int p_74915_6_, int p_74915_7_) {
         StructureBoundingBox var8 = StructureBoundingBox.func_78889_a(p_74915_3_, p_74915_4_, p_74915_5_, 0, 0, 0, 10, 6, 7, p_74915_6_);
         return func_74895_a(var8) && StructureComponent.func_74883_a(p_74915_1_, var8) == null?new StructureVillagePieces.House2(p_74915_0_, p_74915_7_, p_74915_2_, var8, p_74915_6_):null;
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         super.func_143012_a(p_143012_1_);
         p_143012_1_.func_74757_a("Chest", this.field_74917_c);
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         super.func_143011_b(p_143011_1_);
         this.field_74917_c = p_143011_1_.func_74767_n("Chest");
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.field_143015_k < 0) {
            this.field_143015_k = this.func_74889_b(p_74875_1_, p_74875_3_);
            if(this.field_143015_k < 0) {
               return true;
            }

            this.field_74887_e.func_78886_a(0, this.field_143015_k - this.field_74887_e.field_78894_e + 6 - 1, 0);
         }

         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 0, 9, 4, 6, Blocks.field_150350_a, Blocks.field_150350_a, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 9, 0, 6, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 4, 0, 9, 4, 6, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 5, 0, 9, 5, 6, Blocks.field_150333_U, Blocks.field_150333_U, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 5, 1, 8, 5, 5, Blocks.field_150350_a, Blocks.field_150350_a, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 0, 2, 3, 0, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 0, 0, 4, 0, Blocks.field_150364_r, Blocks.field_150364_r, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 3, 1, 0, 3, 4, 0, Blocks.field_150364_r, Blocks.field_150364_r, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 6, 0, 4, 6, Blocks.field_150364_r, Blocks.field_150364_r, false);
         this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 3, 3, 1, p_74875_3_);
         this.func_151549_a(p_74875_1_, p_74875_3_, 3, 1, 2, 3, 3, 2, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 4, 1, 3, 5, 3, 3, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 3, 5, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 6, 5, 3, 6, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 5, 1, 0, 5, 3, 0, Blocks.field_150422_aJ, Blocks.field_150422_aJ, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 9, 1, 0, 9, 3, 0, Blocks.field_150422_aJ, Blocks.field_150422_aJ, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 6, 1, 4, 9, 4, 6, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151550_a(p_74875_1_, Blocks.field_150356_k, 0, 7, 1, 5, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150356_k, 0, 8, 1, 5, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150411_aY, 0, 9, 2, 5, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150411_aY, 0, 9, 2, 4, p_74875_3_);
         this.func_151549_a(p_74875_1_, p_74875_3_, 7, 2, 4, 8, 2, 5, Blocks.field_150350_a, Blocks.field_150350_a, false);
         this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 6, 1, 3, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150460_al, 0, 6, 2, 3, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150460_al, 0, 6, 3, 3, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150334_T, 0, 8, 1, 1, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 2, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 2, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 2, 2, 6, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 4, 2, 6, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 2, 1, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150452_aw, 0, 2, 2, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 1, 1, 5, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150476_ad, this.func_151555_a(Blocks.field_150476_ad, 3), 2, 1, 5, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150476_ad, this.func_151555_a(Blocks.field_150476_ad, 1), 1, 1, 4, p_74875_3_);
         int var4;
         int var5;
         if(!this.field_74917_c) {
            var4 = this.func_74862_a(1);
            var5 = this.func_74865_a(5, 5);
            int var6 = this.func_74873_b(5, 5);
            if(p_74875_3_.func_78890_b(var5, var4, var6)) {
               this.field_74917_c = true;
               this.func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 5, 1, 5, field_74918_a, 3 + p_74875_2_.nextInt(6));
            }
         }

         for(var4 = 6; var4 <= 8; ++var4) {
            if(this.func_151548_a(p_74875_1_, var4, 0, -1, p_74875_3_).func_149688_o() == Material.field_151579_a && this.func_151548_a(p_74875_1_, var4, -1, -1, p_74875_3_).func_149688_o() != Material.field_151579_a) {
               this.func_151550_a(p_74875_1_, Blocks.field_150446_ar, this.func_151555_a(Blocks.field_150446_ar, 3), var4, 0, -1, p_74875_3_);
            }
         }

         for(var4 = 0; var4 < 7; ++var4) {
            for(var5 = 0; var5 < 10; ++var5) {
               this.func_74871_b(p_74875_1_, var5, 6, var4, p_74875_3_);
               this.func_151554_b(p_74875_1_, Blocks.field_150347_e, 0, var5, -1, var4, p_74875_3_);
            }
         }

         this.func_74893_a(p_74875_1_, p_74875_3_, 7, 1, 1, 1);
         return true;
      }

      protected int func_74888_b(int p_74888_1_) {
         return 3;
      }

   }

   public static class House3 extends StructureVillagePieces.Village {

      private static final String __OBFID = "CL_00000530";


      public House3() {}

      public House3(StructureVillagePieces.Start p_i2106_1_, int p_i2106_2_, Random p_i2106_3_, StructureBoundingBox p_i2106_4_, int p_i2106_5_) {
         super(p_i2106_1_, p_i2106_2_);
         this.field_74885_f = p_i2106_5_;
         this.field_74887_e = p_i2106_4_;
      }

      public static StructureVillagePieces.House3 func_74921_a(StructureVillagePieces.Start p_74921_0_, List p_74921_1_, Random p_74921_2_, int p_74921_3_, int p_74921_4_, int p_74921_5_, int p_74921_6_, int p_74921_7_) {
         StructureBoundingBox var8 = StructureBoundingBox.func_78889_a(p_74921_3_, p_74921_4_, p_74921_5_, 0, 0, 0, 9, 7, 12, p_74921_6_);
         return func_74895_a(var8) && StructureComponent.func_74883_a(p_74921_1_, var8) == null?new StructureVillagePieces.House3(p_74921_0_, p_74921_7_, p_74921_2_, var8, p_74921_6_):null;
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.field_143015_k < 0) {
            this.field_143015_k = this.func_74889_b(p_74875_1_, p_74875_3_);
            if(this.field_143015_k < 0) {
               return true;
            }

            this.field_74887_e.func_78886_a(0, this.field_143015_k - this.field_74887_e.field_78894_e + 7 - 1, 0);
         }

         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 1, 7, 4, 4, Blocks.field_150350_a, Blocks.field_150350_a, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 2, 1, 6, 8, 4, 10, Blocks.field_150350_a, Blocks.field_150350_a, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 2, 0, 5, 8, 0, 10, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 1, 7, 0, 4, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 0, 3, 5, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 8, 0, 0, 8, 3, 10, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 0, 7, 2, 0, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 5, 2, 1, 5, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 2, 0, 6, 2, 3, 10, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 3, 0, 10, 7, 3, 10, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 2, 0, 7, 3, 0, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 2, 5, 2, 3, 5, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 4, 1, 8, 4, 1, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 4, 4, 3, 4, 4, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 5, 2, 8, 5, 3, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 0, 4, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 0, 4, 3, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 8, 4, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 8, 4, 3, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 8, 4, 4, p_74875_3_);
         int var4 = this.func_151555_a(Blocks.field_150476_ad, 3);
         int var5 = this.func_151555_a(Blocks.field_150476_ad, 2);

         int var6;
         int var7;
         for(var6 = -1; var6 <= 2; ++var6) {
            for(var7 = 0; var7 <= 8; ++var7) {
               this.func_151550_a(p_74875_1_, Blocks.field_150476_ad, var4, var7, 4 + var6, var6, p_74875_3_);
               if((var6 > -1 || var7 <= 1) && (var6 > 0 || var7 <= 3) && (var6 > 1 || var7 <= 4 || var7 >= 6)) {
                  this.func_151550_a(p_74875_1_, Blocks.field_150476_ad, var5, var7, 4 + var6, 5 - var6, p_74875_3_);
               }
            }
         }

         this.func_151549_a(p_74875_1_, p_74875_3_, 3, 4, 5, 3, 4, 10, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 7, 4, 2, 7, 4, 10, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 4, 5, 4, 4, 5, 10, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 6, 5, 4, 6, 5, 10, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 5, 6, 3, 5, 6, 10, Blocks.field_150344_f, Blocks.field_150344_f, false);
         var6 = this.func_151555_a(Blocks.field_150476_ad, 0);

         int var8;
         for(var7 = 4; var7 >= 1; --var7) {
            this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, var7, 2 + var7, 7 - var7, p_74875_3_);

            for(var8 = 8 - var7; var8 <= 10; ++var8) {
               this.func_151550_a(p_74875_1_, Blocks.field_150476_ad, var6, var7, 2 + var7, var8, p_74875_3_);
            }
         }

         var7 = this.func_151555_a(Blocks.field_150476_ad, 1);
         this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 6, 6, 3, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 7, 5, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150476_ad, var7, 6, 6, 4, p_74875_3_);

         int var9;
         for(var8 = 6; var8 <= 8; ++var8) {
            for(var9 = 5; var9 <= 10; ++var9) {
               this.func_151550_a(p_74875_1_, Blocks.field_150476_ad, var7, var8, 12 - var8, var9, p_74875_3_);
            }
         }

         this.func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 0, 2, 1, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 0, 2, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 2, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 2, 3, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 4, 2, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 5, 2, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 6, 2, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 8, 2, 1, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 8, 2, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 8, 2, 3, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 8, 2, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 8, 2, 5, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 8, 2, 6, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 8, 2, 7, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 8, 2, 8, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 8, 2, 9, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 2, 2, 6, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 2, 2, 7, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 2, 2, 8, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 2, 2, 9, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 4, 4, 10, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 5, 4, 10, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 6, 4, 10, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 5, 5, 10, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 2, 1, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 2, 2, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 2, 3, 1, p_74875_3_);
         this.func_74881_a(p_74875_1_, p_74875_3_, p_74875_2_, 2, 1, 0, this.func_151555_a(Blocks.field_150466_ao, 1));
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 0, -1, 3, 2, -1, Blocks.field_150350_a, Blocks.field_150350_a, false);
         if(this.func_151548_a(p_74875_1_, 2, 0, -1, p_74875_3_).func_149688_o() == Material.field_151579_a && this.func_151548_a(p_74875_1_, 2, -1, -1, p_74875_3_).func_149688_o() != Material.field_151579_a) {
            this.func_151550_a(p_74875_1_, Blocks.field_150446_ar, this.func_151555_a(Blocks.field_150446_ar, 3), 2, 0, -1, p_74875_3_);
         }

         for(var8 = 0; var8 < 5; ++var8) {
            for(var9 = 0; var9 < 9; ++var9) {
               this.func_74871_b(p_74875_1_, var9, 7, var8, p_74875_3_);
               this.func_151554_b(p_74875_1_, Blocks.field_150347_e, 0, var9, -1, var8, p_74875_3_);
            }
         }

         for(var8 = 5; var8 < 11; ++var8) {
            for(var9 = 2; var9 < 9; ++var9) {
               this.func_74871_b(p_74875_1_, var9, 7, var8, p_74875_3_);
               this.func_151554_b(p_74875_1_, Blocks.field_150347_e, 0, var9, -1, var8, p_74875_3_);
            }
         }

         this.func_74893_a(p_74875_1_, p_74875_3_, 4, 1, 2, 2);
         return true;
      }
   }

   public static class House4Garden extends StructureVillagePieces.Village {

      private boolean field_74913_b;
      private static final String __OBFID = "CL_00000523";


      public House4Garden() {}

      public House4Garden(StructureVillagePieces.Start p_i2100_1_, int p_i2100_2_, Random p_i2100_3_, StructureBoundingBox p_i2100_4_, int p_i2100_5_) {
         super(p_i2100_1_, p_i2100_2_);
         this.field_74885_f = p_i2100_5_;
         this.field_74887_e = p_i2100_4_;
         this.field_74913_b = p_i2100_3_.nextBoolean();
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         super.func_143012_a(p_143012_1_);
         p_143012_1_.func_74757_a("Terrace", this.field_74913_b);
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         super.func_143011_b(p_143011_1_);
         this.field_74913_b = p_143011_1_.func_74767_n("Terrace");
      }

      public static StructureVillagePieces.House4Garden func_74912_a(StructureVillagePieces.Start p_74912_0_, List p_74912_1_, Random p_74912_2_, int p_74912_3_, int p_74912_4_, int p_74912_5_, int p_74912_6_, int p_74912_7_) {
         StructureBoundingBox var8 = StructureBoundingBox.func_78889_a(p_74912_3_, p_74912_4_, p_74912_5_, 0, 0, 0, 5, 6, 5, p_74912_6_);
         return StructureComponent.func_74883_a(p_74912_1_, var8) != null?null:new StructureVillagePieces.House4Garden(p_74912_0_, p_74912_7_, p_74912_2_, var8, p_74912_6_);
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.field_143015_k < 0) {
            this.field_143015_k = this.func_74889_b(p_74875_1_, p_74875_3_);
            if(this.field_143015_k < 0) {
               return true;
            }

            this.field_74887_e.func_78886_a(0, this.field_143015_k - this.field_74887_e.field_78894_e + 6 - 1, 0);
         }

         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 0, 4, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 4, 0, 4, 4, 4, Blocks.field_150364_r, Blocks.field_150364_r, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 4, 1, 3, 4, 3, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 0, 1, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 0, 2, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 0, 3, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 4, 1, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 4, 2, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 4, 3, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 0, 1, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 0, 2, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 0, 3, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 4, 1, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 4, 2, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 4, 3, 4, p_74875_3_);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 3, 3, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 3, 3, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 4, 3, 3, 4, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 2, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 2, 2, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 4, 2, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 1, 1, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 1, 2, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 1, 3, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 2, 3, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 3, 3, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 3, 2, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 3, 1, 0, p_74875_3_);
         if(this.func_151548_a(p_74875_1_, 2, 0, -1, p_74875_3_).func_149688_o() == Material.field_151579_a && this.func_151548_a(p_74875_1_, 2, -1, -1, p_74875_3_).func_149688_o() != Material.field_151579_a) {
            this.func_151550_a(p_74875_1_, Blocks.field_150446_ar, this.func_151555_a(Blocks.field_150446_ar, 3), 2, 0, -1, p_74875_3_);
         }

         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 1, 3, 3, 3, Blocks.field_150350_a, Blocks.field_150350_a, false);
         if(this.field_74913_b) {
            this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 0, 5, 0, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 1, 5, 0, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 2, 5, 0, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 3, 5, 0, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 4, 5, 0, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 0, 5, 4, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 1, 5, 4, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 2, 5, 4, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 3, 5, 4, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 4, 5, 4, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 4, 5, 1, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 4, 5, 2, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 4, 5, 3, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 0, 5, 1, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 0, 5, 2, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 0, 5, 3, p_74875_3_);
         }

         int var4;
         if(this.field_74913_b) {
            var4 = this.func_151555_a(Blocks.field_150468_ap, 3);
            this.func_151550_a(p_74875_1_, Blocks.field_150468_ap, var4, 3, 1, 3, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150468_ap, var4, 3, 2, 3, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150468_ap, var4, 3, 3, 3, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150468_ap, var4, 3, 4, 3, p_74875_3_);
         }

         this.func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 2, 3, 1, p_74875_3_);

         for(var4 = 0; var4 < 5; ++var4) {
            for(int var5 = 0; var5 < 5; ++var5) {
               this.func_74871_b(p_74875_1_, var5, 6, var4, p_74875_3_);
               this.func_151554_b(p_74875_1_, Blocks.field_150347_e, 0, var5, -1, var4, p_74875_3_);
            }
         }

         this.func_74893_a(p_74875_1_, p_74875_3_, 1, 1, 2, 1);
         return true;
      }
   }

   public static class Path extends StructureVillagePieces.Road {

      private int field_74934_a;
      private static final String __OBFID = "CL_00000528";


      public Path() {}

      public Path(StructureVillagePieces.Start p_i2105_1_, int p_i2105_2_, Random p_i2105_3_, StructureBoundingBox p_i2105_4_, int p_i2105_5_) {
         super(p_i2105_1_, p_i2105_2_);
         this.field_74885_f = p_i2105_5_;
         this.field_74887_e = p_i2105_4_;
         this.field_74934_a = Math.max(p_i2105_4_.func_78883_b(), p_i2105_4_.func_78880_d());
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         super.func_143012_a(p_143012_1_);
         p_143012_1_.func_74768_a("Length", this.field_74934_a);
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         super.func_143011_b(p_143011_1_);
         this.field_74934_a = p_143011_1_.func_74762_e("Length");
      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         boolean var4 = false;

         int var5;
         StructureComponent var6;
         for(var5 = p_74861_3_.nextInt(5); var5 < this.field_74934_a - 8; var5 += 2 + p_74861_3_.nextInt(5)) {
            var6 = this.func_74891_a((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, var5);
            if(var6 != null) {
               var5 += Math.max(var6.field_74887_e.func_78883_b(), var6.field_74887_e.func_78880_d());
               var4 = true;
            }
         }

         for(var5 = p_74861_3_.nextInt(5); var5 < this.field_74934_a - 8; var5 += 2 + p_74861_3_.nextInt(5)) {
            var6 = this.func_74894_b((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, var5);
            if(var6 != null) {
               var5 += Math.max(var6.field_74887_e.func_78883_b(), var6.field_74887_e.func_78880_d());
               var4 = true;
            }
         }

         if(var4 && p_74861_3_.nextInt(3) > 0) {
            switch(this.field_74885_f) {
            case 0:
               StructureVillagePieces.func_75080_e((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f - 2, 1, this.func_74877_c());
               break;
            case 1:
               StructureVillagePieces.func_75080_e((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, 2, this.func_74877_c());
               break;
            case 2:
               StructureVillagePieces.func_75080_e((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, 1, this.func_74877_c());
               break;
            case 3:
               StructureVillagePieces.func_75080_e((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d - 2, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, 2, this.func_74877_c());
            }
         }

         if(var4 && p_74861_3_.nextInt(3) > 0) {
            switch(this.field_74885_f) {
            case 0:
               StructureVillagePieces.func_75080_e((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f - 2, 3, this.func_74877_c());
               break;
            case 1:
               StructureVillagePieces.func_75080_e((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, 0, this.func_74877_c());
               break;
            case 2:
               StructureVillagePieces.func_75080_e((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, 3, this.func_74877_c());
               break;
            case 3:
               StructureVillagePieces.func_75080_e((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d - 2, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, 0, this.func_74877_c());
            }
         }

      }

      public static StructureBoundingBox func_74933_a(StructureVillagePieces.Start p_74933_0_, List p_74933_1_, Random p_74933_2_, int p_74933_3_, int p_74933_4_, int p_74933_5_, int p_74933_6_) {
         for(int var7 = 7 * MathHelper.func_76136_a(p_74933_2_, 3, 5); var7 >= 7; var7 -= 7) {
            StructureBoundingBox var8 = StructureBoundingBox.func_78889_a(p_74933_3_, p_74933_4_, p_74933_5_, 0, 0, 0, 3, 3, var7, p_74933_6_);
            if(StructureComponent.func_74883_a(p_74933_1_, var8) == null) {
               return var8;
            }
         }

         return null;
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         Block var4 = this.func_151558_b(Blocks.field_150351_n, 0);

         for(int var5 = this.field_74887_e.field_78897_a; var5 <= this.field_74887_e.field_78893_d; ++var5) {
            for(int var6 = this.field_74887_e.field_78896_c; var6 <= this.field_74887_e.field_78892_f; ++var6) {
               if(p_74875_3_.func_78890_b(var5, 64, var6)) {
                  int var7 = p_74875_1_.func_72825_h(var5, var6) - 1;
                  p_74875_1_.func_147465_d(var5, var7, var6, var4, 0, 2);
               }
            }
         }

         return true;
      }
   }

   public static class PieceWeight {

      public Class field_75090_a;
      public final int field_75088_b;
      public int field_75089_c;
      public int field_75087_d;
      private static final String __OBFID = "CL_00000521";


      public PieceWeight(Class p_i2098_1_, int p_i2098_2_, int p_i2098_3_) {
         this.field_75090_a = p_i2098_1_;
         this.field_75088_b = p_i2098_2_;
         this.field_75087_d = p_i2098_3_;
      }

      public boolean func_75085_a(int p_75085_1_) {
         return this.field_75087_d == 0 || this.field_75089_c < this.field_75087_d;
      }

      public boolean func_75086_a() {
         return this.field_75087_d == 0 || this.field_75089_c < this.field_75087_d;
      }
   }

   public abstract static class Road extends StructureVillagePieces.Village {

      private static final String __OBFID = "CL_00000532";


      public Road() {}

      protected Road(StructureVillagePieces.Start p_i2108_1_, int p_i2108_2_) {
         super(p_i2108_1_, p_i2108_2_);
      }
   }

   public static class Start extends StructureVillagePieces.Well {

      public WorldChunkManager field_74929_a;
      public boolean field_74927_b;
      public int field_74928_c;
      public StructureVillagePieces.PieceWeight field_74926_d;
      public List field_74931_h;
      public List field_74932_i = new ArrayList();
      public List field_74930_j = new ArrayList();
      private static final String __OBFID = "CL_00000527";


      public Start() {}

      public Start(WorldChunkManager p_i2104_1_, int p_i2104_2_, Random p_i2104_3_, int p_i2104_4_, int p_i2104_5_, List p_i2104_6_, int p_i2104_7_) {
         super((StructureVillagePieces.Start)null, 0, p_i2104_3_, p_i2104_4_, p_i2104_5_);
         this.field_74929_a = p_i2104_1_;
         this.field_74931_h = p_i2104_6_;
         this.field_74928_c = p_i2104_7_;
         BiomeGenBase var8 = p_i2104_1_.func_76935_a(p_i2104_4_, p_i2104_5_);
         this.field_74927_b = var8 == BiomeGenBase.field_76769_d || var8 == BiomeGenBase.field_76786_s;
      }

      public WorldChunkManager func_74925_d() {
         return this.field_74929_a;
      }
   }

   public static class Torch extends StructureVillagePieces.Village {

      private static final String __OBFID = "CL_00000520";


      public Torch() {}

      public Torch(StructureVillagePieces.Start p_i2097_1_, int p_i2097_2_, Random p_i2097_3_, StructureBoundingBox p_i2097_4_, int p_i2097_5_) {
         super(p_i2097_1_, p_i2097_2_);
         this.field_74885_f = p_i2097_5_;
         this.field_74887_e = p_i2097_4_;
      }

      public static StructureBoundingBox func_74904_a(StructureVillagePieces.Start p_74904_0_, List p_74904_1_, Random p_74904_2_, int p_74904_3_, int p_74904_4_, int p_74904_5_, int p_74904_6_) {
         StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_74904_3_, p_74904_4_, p_74904_5_, 0, 0, 0, 3, 4, 2, p_74904_6_);
         return StructureComponent.func_74883_a(p_74904_1_, var7) != null?null:var7;
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.field_143015_k < 0) {
            this.field_143015_k = this.func_74889_b(p_74875_1_, p_74875_3_);
            if(this.field_143015_k < 0) {
               return true;
            }

            this.field_74887_e.func_78886_a(0, this.field_143015_k - this.field_74887_e.field_78894_e + 4 - 1, 0);
         }

         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 2, 3, 1, Blocks.field_150350_a, Blocks.field_150350_a, false);
         this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 1, 0, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 1, 1, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 1, 2, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150325_L, 15, 1, 3, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 0, 3, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 1, 3, 1, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 2, 3, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 1, 3, -1, p_74875_3_);
         return true;
      }
   }

   abstract static class Village extends StructureComponent {

      protected int field_143015_k = -1;
      private int field_74896_a;
      private boolean field_143014_b;
      private static final String __OBFID = "CL_00000531";


      public Village() {}

      protected Village(StructureVillagePieces.Start p_i2107_1_, int p_i2107_2_) {
         super(p_i2107_2_);
         if(p_i2107_1_ != null) {
            this.field_143014_b = p_i2107_1_.field_74927_b;
         }

      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         p_143012_1_.func_74768_a("HPos", this.field_143015_k);
         p_143012_1_.func_74768_a("VCount", this.field_74896_a);
         p_143012_1_.func_74757_a("Desert", this.field_143014_b);
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         this.field_143015_k = p_143011_1_.func_74762_e("HPos");
         this.field_74896_a = p_143011_1_.func_74762_e("VCount");
         this.field_143014_b = p_143011_1_.func_74767_n("Desert");
      }

      protected StructureComponent func_74891_a(StructureVillagePieces.Start p_74891_1_, List p_74891_2_, Random p_74891_3_, int p_74891_4_, int p_74891_5_) {
         switch(this.field_74885_f) {
         case 0:
            return StructureVillagePieces.func_75077_d(p_74891_1_, p_74891_2_, p_74891_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74891_4_, this.field_74887_e.field_78896_c + p_74891_5_, 1, this.func_74877_c());
         case 1:
            return StructureVillagePieces.func_75077_d(p_74891_1_, p_74891_2_, p_74891_3_, this.field_74887_e.field_78897_a + p_74891_5_, this.field_74887_e.field_78895_b + p_74891_4_, this.field_74887_e.field_78896_c - 1, 2, this.func_74877_c());
         case 2:
            return StructureVillagePieces.func_75077_d(p_74891_1_, p_74891_2_, p_74891_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74891_4_, this.field_74887_e.field_78896_c + p_74891_5_, 1, this.func_74877_c());
         case 3:
            return StructureVillagePieces.func_75077_d(p_74891_1_, p_74891_2_, p_74891_3_, this.field_74887_e.field_78897_a + p_74891_5_, this.field_74887_e.field_78895_b + p_74891_4_, this.field_74887_e.field_78896_c - 1, 2, this.func_74877_c());
         default:
            return null;
         }
      }

      protected StructureComponent func_74894_b(StructureVillagePieces.Start p_74894_1_, List p_74894_2_, Random p_74894_3_, int p_74894_4_, int p_74894_5_) {
         switch(this.field_74885_f) {
         case 0:
            return StructureVillagePieces.func_75077_d(p_74894_1_, p_74894_2_, p_74894_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74894_4_, this.field_74887_e.field_78896_c + p_74894_5_, 3, this.func_74877_c());
         case 1:
            return StructureVillagePieces.func_75077_d(p_74894_1_, p_74894_2_, p_74894_3_, this.field_74887_e.field_78897_a + p_74894_5_, this.field_74887_e.field_78895_b + p_74894_4_, this.field_74887_e.field_78892_f + 1, 0, this.func_74877_c());
         case 2:
            return StructureVillagePieces.func_75077_d(p_74894_1_, p_74894_2_, p_74894_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74894_4_, this.field_74887_e.field_78896_c + p_74894_5_, 3, this.func_74877_c());
         case 3:
            return StructureVillagePieces.func_75077_d(p_74894_1_, p_74894_2_, p_74894_3_, this.field_74887_e.field_78897_a + p_74894_5_, this.field_74887_e.field_78895_b + p_74894_4_, this.field_74887_e.field_78892_f + 1, 0, this.func_74877_c());
         default:
            return null;
         }
      }

      protected int func_74889_b(World p_74889_1_, StructureBoundingBox p_74889_2_) {
         int var3 = 0;
         int var4 = 0;

         for(int var5 = this.field_74887_e.field_78896_c; var5 <= this.field_74887_e.field_78892_f; ++var5) {
            for(int var6 = this.field_74887_e.field_78897_a; var6 <= this.field_74887_e.field_78893_d; ++var6) {
               if(p_74889_2_.func_78890_b(var6, 64, var5)) {
                  var3 += Math.max(p_74889_1_.func_72825_h(var6, var5), p_74889_1_.field_73011_w.func_76557_i());
                  ++var4;
               }
            }
         }

         if(var4 == 0) {
            return -1;
         } else {
            return var3 / var4;
         }
      }

      protected static boolean func_74895_a(StructureBoundingBox p_74895_0_) {
         return p_74895_0_ != null && p_74895_0_.field_78895_b > 10;
      }

      protected void func_74893_a(World p_74893_1_, StructureBoundingBox p_74893_2_, int p_74893_3_, int p_74893_4_, int p_74893_5_, int p_74893_6_) {
         if(this.field_74896_a < p_74893_6_) {
            for(int var7 = this.field_74896_a; var7 < p_74893_6_; ++var7) {
               int var8 = this.func_74865_a(p_74893_3_ + var7, p_74893_5_);
               int var9 = this.func_74862_a(p_74893_4_);
               int var10 = this.func_74873_b(p_74893_3_ + var7, p_74893_5_);
               if(!p_74893_2_.func_78890_b(var8, var9, var10)) {
                  break;
               }

               ++this.field_74896_a;
               EntityVillager var11 = new EntityVillager(p_74893_1_, this.func_74888_b(var7));
               var11.func_70012_b((double)var8 + 0.5D, (double)var9, (double)var10 + 0.5D, 0.0F, 0.0F);
               p_74893_1_.func_72838_d(var11);
            }

         }
      }

      protected int func_74888_b(int p_74888_1_) {
         return 0;
      }

      protected Block func_151558_b(Block p_151558_1_, int p_151558_2_) {
         if(this.field_143014_b) {
            if(p_151558_1_ == Blocks.field_150364_r || p_151558_1_ == Blocks.field_150363_s) {
               return Blocks.field_150322_A;
            }

            if(p_151558_1_ == Blocks.field_150347_e) {
               return Blocks.field_150322_A;
            }

            if(p_151558_1_ == Blocks.field_150344_f) {
               return Blocks.field_150322_A;
            }

            if(p_151558_1_ == Blocks.field_150476_ad) {
               return Blocks.field_150372_bz;
            }

            if(p_151558_1_ == Blocks.field_150446_ar) {
               return Blocks.field_150372_bz;
            }

            if(p_151558_1_ == Blocks.field_150351_n) {
               return Blocks.field_150322_A;
            }
         }

         return p_151558_1_;
      }

      protected int func_151557_c(Block p_151557_1_, int p_151557_2_) {
         if(this.field_143014_b) {
            if(p_151557_1_ == Blocks.field_150364_r || p_151557_1_ == Blocks.field_150363_s) {
               return 0;
            }

            if(p_151557_1_ == Blocks.field_150347_e) {
               return 0;
            }

            if(p_151557_1_ == Blocks.field_150344_f) {
               return 2;
            }
         }

         return p_151557_2_;
      }

      protected void func_151550_a(World p_151550_1_, Block p_151550_2_, int p_151550_3_, int p_151550_4_, int p_151550_5_, int p_151550_6_, StructureBoundingBox p_151550_7_) {
         Block var8 = this.func_151558_b(p_151550_2_, p_151550_3_);
         int var9 = this.func_151557_c(p_151550_2_, p_151550_3_);
         super.func_151550_a(p_151550_1_, var8, var9, p_151550_4_, p_151550_5_, p_151550_6_, p_151550_7_);
      }

      protected void func_151549_a(World p_151549_1_, StructureBoundingBox p_151549_2_, int p_151549_3_, int p_151549_4_, int p_151549_5_, int p_151549_6_, int p_151549_7_, int p_151549_8_, Block p_151549_9_, Block p_151549_10_, boolean p_151549_11_) {
         Block var12 = this.func_151558_b(p_151549_9_, 0);
         int var13 = this.func_151557_c(p_151549_9_, 0);
         Block var14 = this.func_151558_b(p_151549_10_, 0);
         int var15 = this.func_151557_c(p_151549_10_, 0);
         super.func_151556_a(p_151549_1_, p_151549_2_, p_151549_3_, p_151549_4_, p_151549_5_, p_151549_6_, p_151549_7_, p_151549_8_, var12, var13, var14, var15, p_151549_11_);
      }

      protected void func_151554_b(World p_151554_1_, Block p_151554_2_, int p_151554_3_, int p_151554_4_, int p_151554_5_, int p_151554_6_, StructureBoundingBox p_151554_7_) {
         Block var8 = this.func_151558_b(p_151554_2_, p_151554_3_);
         int var9 = this.func_151557_c(p_151554_2_, p_151554_3_);
         super.func_151554_b(p_151554_1_, var8, var9, p_151554_4_, p_151554_5_, p_151554_6_, p_151554_7_);
      }
   }

   public static class Well extends StructureVillagePieces.Village {

      private static final String __OBFID = "CL_00000533";


      public Well() {}

      public Well(StructureVillagePieces.Start p_i2109_1_, int p_i2109_2_, Random p_i2109_3_, int p_i2109_4_, int p_i2109_5_) {
         super(p_i2109_1_, p_i2109_2_);
         this.field_74885_f = p_i2109_3_.nextInt(4);
         switch(this.field_74885_f) {
         case 0:
         case 2:
            this.field_74887_e = new StructureBoundingBox(p_i2109_4_, 64, p_i2109_5_, p_i2109_4_ + 6 - 1, 78, p_i2109_5_ + 6 - 1);
            break;
         default:
            this.field_74887_e = new StructureBoundingBox(p_i2109_4_, 64, p_i2109_5_, p_i2109_4_ + 6 - 1, 78, p_i2109_5_ + 6 - 1);
         }

      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         StructureVillagePieces.func_75080_e((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78894_e - 4, this.field_74887_e.field_78896_c + 1, 1, this.func_74877_c());
         StructureVillagePieces.func_75080_e((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78894_e - 4, this.field_74887_e.field_78896_c + 1, 3, this.func_74877_c());
         StructureVillagePieces.func_75080_e((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78894_e - 4, this.field_74887_e.field_78896_c - 1, 2, this.func_74877_c());
         StructureVillagePieces.func_75080_e((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78894_e - 4, this.field_74887_e.field_78892_f + 1, 0, this.func_74877_c());
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.field_143015_k < 0) {
            this.field_143015_k = this.func_74889_b(p_74875_1_, p_74875_3_);
            if(this.field_143015_k < 0) {
               return true;
            }

            this.field_74887_e.func_78886_a(0, this.field_143015_k - this.field_74887_e.field_78894_e + 3, 0);
         }

         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 1, 4, 12, 4, Blocks.field_150347_e, Blocks.field_150358_i, false);
         this.func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 2, 12, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 3, 12, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 2, 12, 3, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 3, 12, 3, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 1, 13, 1, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 1, 14, 1, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 4, 13, 1, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 4, 14, 1, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 1, 13, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 1, 14, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 4, 13, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 4, 14, 4, p_74875_3_);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 15, 1, 4, 15, 4, Blocks.field_150347_e, Blocks.field_150347_e, false);

         for(int var4 = 0; var4 <= 5; ++var4) {
            for(int var5 = 0; var5 <= 5; ++var5) {
               if(var5 == 0 || var5 == 5 || var4 == 0 || var4 == 5) {
                  this.func_151550_a(p_74875_1_, Blocks.field_150351_n, 0, var5, 11, var4, p_74875_3_);
                  this.func_74871_b(p_74875_1_, var5, 12, var4, p_74875_3_);
               }
            }
         }

         return true;
      }
   }

   public static class WoodHut extends StructureVillagePieces.Village {

      private boolean field_74909_b;
      private int field_74910_c;
      private static final String __OBFID = "CL_00000524";


      public WoodHut() {}

      public WoodHut(StructureVillagePieces.Start p_i2101_1_, int p_i2101_2_, Random p_i2101_3_, StructureBoundingBox p_i2101_4_, int p_i2101_5_) {
         super(p_i2101_1_, p_i2101_2_);
         this.field_74885_f = p_i2101_5_;
         this.field_74887_e = p_i2101_4_;
         this.field_74909_b = p_i2101_3_.nextBoolean();
         this.field_74910_c = p_i2101_3_.nextInt(3);
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         super.func_143012_a(p_143012_1_);
         p_143012_1_.func_74768_a("T", this.field_74910_c);
         p_143012_1_.func_74757_a("C", this.field_74909_b);
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         super.func_143011_b(p_143011_1_);
         this.field_74910_c = p_143011_1_.func_74762_e("T");
         this.field_74909_b = p_143011_1_.func_74767_n("C");
      }

      public static StructureVillagePieces.WoodHut func_74908_a(StructureVillagePieces.Start p_74908_0_, List p_74908_1_, Random p_74908_2_, int p_74908_3_, int p_74908_4_, int p_74908_5_, int p_74908_6_, int p_74908_7_) {
         StructureBoundingBox var8 = StructureBoundingBox.func_78889_a(p_74908_3_, p_74908_4_, p_74908_5_, 0, 0, 0, 4, 6, 5, p_74908_6_);
         return func_74895_a(var8) && StructureComponent.func_74883_a(p_74908_1_, var8) == null?new StructureVillagePieces.WoodHut(p_74908_0_, p_74908_7_, p_74908_2_, var8, p_74908_6_):null;
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.field_143015_k < 0) {
            this.field_143015_k = this.func_74889_b(p_74875_1_, p_74875_3_);
            if(this.field_143015_k < 0) {
               return true;
            }

            this.field_74887_e.func_78886_a(0, this.field_143015_k - this.field_74887_e.field_78894_e + 6 - 1, 0);
         }

         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 1, 3, 5, 4, Blocks.field_150350_a, Blocks.field_150350_a, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 3, 0, 4, Blocks.field_150347_e, Blocks.field_150347_e, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 1, 2, 0, 3, Blocks.field_150346_d, Blocks.field_150346_d, false);
         if(this.field_74909_b) {
            this.func_151549_a(p_74875_1_, p_74875_3_, 1, 4, 1, 2, 4, 3, Blocks.field_150364_r, Blocks.field_150364_r, false);
         } else {
            this.func_151549_a(p_74875_1_, p_74875_3_, 1, 5, 1, 2, 5, 3, Blocks.field_150364_r, Blocks.field_150364_r, false);
         }

         this.func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 1, 4, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 2, 4, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 1, 4, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 2, 4, 4, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 0, 4, 1, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 0, 4, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 0, 4, 3, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 3, 4, 1, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 3, 4, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 3, 4, 3, p_74875_3_);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 0, 0, 3, 0, Blocks.field_150364_r, Blocks.field_150364_r, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 3, 1, 0, 3, 3, 0, Blocks.field_150364_r, Blocks.field_150364_r, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 4, 0, 3, 4, Blocks.field_150364_r, Blocks.field_150364_r, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 3, 1, 4, 3, 3, 4, Blocks.field_150364_r, Blocks.field_150364_r, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 3, 3, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 3, 1, 1, 3, 3, 3, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 0, 2, 3, 0, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 4, 2, 3, 4, Blocks.field_150344_f, Blocks.field_150344_f, false);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 2, 2, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 3, 2, 2, p_74875_3_);
         if(this.field_74910_c > 0) {
            this.func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, this.field_74910_c, 1, 3, p_74875_3_);
            this.func_151550_a(p_74875_1_, Blocks.field_150452_aw, 0, this.field_74910_c, 2, 3, p_74875_3_);
         }

         this.func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 1, 1, 0, p_74875_3_);
         this.func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 1, 2, 0, p_74875_3_);
         this.func_74881_a(p_74875_1_, p_74875_3_, p_74875_2_, 1, 1, 0, this.func_151555_a(Blocks.field_150466_ao, 1));
         if(this.func_151548_a(p_74875_1_, 1, 0, -1, p_74875_3_).func_149688_o() == Material.field_151579_a && this.func_151548_a(p_74875_1_, 1, -1, -1, p_74875_3_).func_149688_o() != Material.field_151579_a) {
            this.func_151550_a(p_74875_1_, Blocks.field_150446_ar, this.func_151555_a(Blocks.field_150446_ar, 3), 1, 0, -1, p_74875_3_);
         }

         for(int var4 = 0; var4 < 5; ++var4) {
            for(int var5 = 0; var5 < 4; ++var5) {
               this.func_74871_b(p_74875_1_, var5, 6, var4, p_74875_3_);
               this.func_151554_b(p_74875_1_, Blocks.field_150347_e, 0, var5, -1, var4, p_74875_3_);
            }
         }

         this.func_74893_a(p_74875_1_, p_74875_3_, 1, 1, 2, 1);
         return true;
      }
   }
}
