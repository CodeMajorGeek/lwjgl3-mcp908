package net.minecraft.world.gen;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class MapGenBase {

   protected int field_75040_a = 8;
   protected Random field_75038_b = new Random();
   protected World field_75039_c;
   private static final String __OBFID = "CL_00000394";


   public void func_151539_a(IChunkProvider p_151539_1_, World p_151539_2_, int p_151539_3_, int p_151539_4_, Block[] p_151539_5_) {
      int var6 = this.field_75040_a;
      this.field_75039_c = p_151539_2_;
      this.field_75038_b.setSeed(p_151539_2_.func_72905_C());
      long var7 = this.field_75038_b.nextLong();
      long var9 = this.field_75038_b.nextLong();

      for(int var11 = p_151539_3_ - var6; var11 <= p_151539_3_ + var6; ++var11) {
         for(int var12 = p_151539_4_ - var6; var12 <= p_151539_4_ + var6; ++var12) {
            long var13 = (long)var11 * var7;
            long var15 = (long)var12 * var9;
            this.field_75038_b.setSeed(var13 ^ var15 ^ p_151539_2_.func_72905_C());
            this.func_151538_a(p_151539_2_, var11, var12, p_151539_3_, p_151539_4_, p_151539_5_);
         }
      }

   }

   protected void func_151538_a(World p_151538_1_, int p_151538_2_, int p_151538_3_, int p_151538_4_, int p_151538_5_, Block[] p_151538_6_) {}
}
