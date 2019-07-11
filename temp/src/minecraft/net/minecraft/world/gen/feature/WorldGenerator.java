package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public abstract class WorldGenerator {

   private final boolean field_76488_a;
   private static final String __OBFID = "CL_00000409";


   public WorldGenerator() {
      this.field_76488_a = false;
   }

   public WorldGenerator(boolean p_i2013_1_) {
      this.field_76488_a = p_i2013_1_;
   }

   public abstract boolean func_76484_a(World var1, Random var2, int var3, int var4, int var5);

   public void func_76487_a(double p_76487_1_, double p_76487_3_, double p_76487_5_) {}

   protected void func_150515_a(World p_150515_1_, int p_150515_2_, int p_150515_3_, int p_150515_4_, Block p_150515_5_) {
      this.func_150516_a(p_150515_1_, p_150515_2_, p_150515_3_, p_150515_4_, p_150515_5_, 0);
   }

   protected void func_150516_a(World p_150516_1_, int p_150516_2_, int p_150516_3_, int p_150516_4_, Block p_150516_5_, int p_150516_6_) {
      if(this.field_76488_a) {
         p_150516_1_.func_147465_d(p_150516_2_, p_150516_3_, p_150516_4_, p_150516_5_, p_150516_6_, 3);
      } else {
         p_150516_1_.func_147465_d(p_150516_2_, p_150516_3_, p_150516_4_, p_150516_5_, p_150516_6_, 2);
      }

   }
}
