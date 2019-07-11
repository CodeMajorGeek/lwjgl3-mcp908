package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenLiquids extends WorldGenerator {

   private Block field_150521_a;
   private static final String __OBFID = "CL_00000434";


   public WorldGenLiquids(Block p_i45465_1_) {
      this.field_150521_a = p_i45465_1_;
   }

   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      if(p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ + 1, p_76484_5_) != Blocks.field_150348_b) {
         return false;
      } else if(p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_) != Blocks.field_150348_b) {
         return false;
      } else if(p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_, p_76484_5_).func_149688_o() != Material.field_151579_a && p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_, p_76484_5_) != Blocks.field_150348_b) {
         return false;
      } else {
         int var6 = 0;
         if(p_76484_1_.func_147439_a(p_76484_3_ - 1, p_76484_4_, p_76484_5_) == Blocks.field_150348_b) {
            ++var6;
         }

         if(p_76484_1_.func_147439_a(p_76484_3_ + 1, p_76484_4_, p_76484_5_) == Blocks.field_150348_b) {
            ++var6;
         }

         if(p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_, p_76484_5_ - 1) == Blocks.field_150348_b) {
            ++var6;
         }

         if(p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_, p_76484_5_ + 1) == Blocks.field_150348_b) {
            ++var6;
         }

         int var7 = 0;
         if(p_76484_1_.func_147437_c(p_76484_3_ - 1, p_76484_4_, p_76484_5_)) {
            ++var7;
         }

         if(p_76484_1_.func_147437_c(p_76484_3_ + 1, p_76484_4_, p_76484_5_)) {
            ++var7;
         }

         if(p_76484_1_.func_147437_c(p_76484_3_, p_76484_4_, p_76484_5_ - 1)) {
            ++var7;
         }

         if(p_76484_1_.func_147437_c(p_76484_3_, p_76484_4_, p_76484_5_ + 1)) {
            ++var7;
         }

         if(var6 == 3 && var7 == 1) {
            p_76484_1_.func_147465_d(p_76484_3_, p_76484_4_, p_76484_5_, this.field_150521_a, 0, 2);
            p_76484_1_.field_72999_e = true;
            this.field_150521_a.func_149674_a(p_76484_1_, p_76484_3_, p_76484_4_, p_76484_5_, p_76484_2_);
            p_76484_1_.field_72999_e = false;
         }

         return true;
      }
   }
}
