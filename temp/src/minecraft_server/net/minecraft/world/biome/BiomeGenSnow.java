package net.minecraft.world.biome;

import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenIcePath;
import net.minecraft.world.gen.feature.WorldGenIceSpike;
import net.minecraft.world.gen.feature.WorldGenTaiga2;

public class BiomeGenSnow extends BiomeGenBase {

   private boolean field_150615_aC;
   private WorldGenIceSpike field_150616_aD = new WorldGenIceSpike();
   private WorldGenIcePath field_150617_aE = new WorldGenIcePath(4);
   private static final String __OBFID = "CL_00000174";


   public BiomeGenSnow(int p_i45378_1_, boolean p_i45378_2_) {
      super(p_i45378_1_);
      this.field_150615_aC = p_i45378_2_;
      if(p_i45378_2_) {
         this.field_76752_A = Blocks.field_150433_aE;
      }

      this.field_76762_K.clear();
   }

   public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
      if(this.field_150615_aC) {
         int var5;
         int var6;
         int var7;
         for(var5 = 0; var5 < 3; ++var5) {
            var6 = p_76728_3_ + p_76728_2_.nextInt(16) + 8;
            var7 = p_76728_4_ + p_76728_2_.nextInt(16) + 8;
            this.field_150616_aD.func_76484_a(p_76728_1_, p_76728_2_, var6, p_76728_1_.func_72976_f(var6, var7), var7);
         }

         for(var5 = 0; var5 < 2; ++var5) {
            var6 = p_76728_3_ + p_76728_2_.nextInt(16) + 8;
            var7 = p_76728_4_ + p_76728_2_.nextInt(16) + 8;
            this.field_150617_aE.func_76484_a(p_76728_1_, p_76728_2_, var6, p_76728_1_.func_72976_f(var6, var7), var7);
         }
      }

      super.func_76728_a(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
   }

   public WorldGenAbstractTree func_150567_a(Random p_150567_1_) {
      return new WorldGenTaiga2(false);
   }

   protected BiomeGenBase func_150566_k() {
      BiomeGenBase var1 = (new BiomeGenSnow(this.field_76756_M + 128, true)).func_150557_a(13828095, true).func_76735_a(this.field_76791_y + " Spikes").func_76742_b().func_76732_a(0.0F, 0.5F).func_150570_a(new BiomeGenBase.Height(this.field_76748_D + 0.1F, this.field_76749_E + 0.1F));
      var1.field_76748_D = this.field_76748_D + 0.3F;
      var1.field_76749_E = this.field_76749_E + 0.4F;
      return var1;
   }
}
