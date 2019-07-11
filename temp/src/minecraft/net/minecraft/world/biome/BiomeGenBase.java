package net.minecraft.world.biome;

import com.google.common.collect.Sets;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBeach;
import net.minecraft.world.biome.BiomeGenDesert;
import net.minecraft.world.biome.BiomeGenEnd;
import net.minecraft.world.biome.BiomeGenForest;
import net.minecraft.world.biome.BiomeGenHell;
import net.minecraft.world.biome.BiomeGenHills;
import net.minecraft.world.biome.BiomeGenJungle;
import net.minecraft.world.biome.BiomeGenMesa;
import net.minecraft.world.biome.BiomeGenMushroomIsland;
import net.minecraft.world.biome.BiomeGenMutated;
import net.minecraft.world.biome.BiomeGenOcean;
import net.minecraft.world.biome.BiomeGenPlains;
import net.minecraft.world.biome.BiomeGenRiver;
import net.minecraft.world.biome.BiomeGenSavanna;
import net.minecraft.world.biome.BiomeGenSnow;
import net.minecraft.world.biome.BiomeGenStoneBeach;
import net.minecraft.world.biome.BiomeGenSwamp;
import net.minecraft.world.biome.BiomeGenTaiga;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenDoublePlant;
import net.minecraft.world.gen.feature.WorldGenSwamp;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BiomeGenBase {

   private static final Logger field_150586_aC = LogManager.getLogger();
   protected static final BiomeGenBase.Height field_150596_a = new BiomeGenBase.Height(0.1F, 0.2F);
   protected static final BiomeGenBase.Height field_150594_b = new BiomeGenBase.Height(-0.5F, 0.0F);
   protected static final BiomeGenBase.Height field_150595_c = new BiomeGenBase.Height(-1.0F, 0.1F);
   protected static final BiomeGenBase.Height field_150592_d = new BiomeGenBase.Height(-1.8F, 0.1F);
   protected static final BiomeGenBase.Height field_150593_e = new BiomeGenBase.Height(0.125F, 0.05F);
   protected static final BiomeGenBase.Height field_150590_f = new BiomeGenBase.Height(0.2F, 0.2F);
   protected static final BiomeGenBase.Height field_150591_g = new BiomeGenBase.Height(0.45F, 0.3F);
   protected static final BiomeGenBase.Height field_150602_h = new BiomeGenBase.Height(1.5F, 0.025F);
   protected static final BiomeGenBase.Height field_150603_i = new BiomeGenBase.Height(1.0F, 0.5F);
   protected static final BiomeGenBase.Height field_150600_j = new BiomeGenBase.Height(0.0F, 0.025F);
   protected static final BiomeGenBase.Height field_150601_k = new BiomeGenBase.Height(0.1F, 0.8F);
   protected static final BiomeGenBase.Height field_150598_l = new BiomeGenBase.Height(0.2F, 0.3F);
   protected static final BiomeGenBase.Height field_150599_m = new BiomeGenBase.Height(-0.2F, 0.1F);
   private static final BiomeGenBase[] field_76773_a = new BiomeGenBase[256];
   public static final Set field_150597_n = Sets.newHashSet();
   public static final BiomeGenBase field_76771_b = (new BiomeGenOcean(0)).func_76739_b(112).func_76735_a("Ocean").func_150570_a(field_150595_c);
   public static final BiomeGenBase field_76772_c = (new BiomeGenPlains(1)).func_76739_b(9286496).func_76735_a("Plains");
   public static final BiomeGenBase field_76769_d = (new BiomeGenDesert(2)).func_76739_b(16421912).func_76735_a("Desert").func_76745_m().func_76732_a(2.0F, 0.0F).func_150570_a(field_150593_e);
   public static final BiomeGenBase field_76770_e = (new BiomeGenHills(3, false)).func_76739_b(6316128).func_76735_a("Extreme Hills").func_150570_a(field_150603_i).func_76732_a(0.2F, 0.3F);
   public static final BiomeGenBase field_76767_f = (new BiomeGenForest(4, 0)).func_76739_b(353825).func_76735_a("Forest");
   public static final BiomeGenBase field_76768_g = (new BiomeGenTaiga(5, 0)).func_76739_b(747097).func_76735_a("Taiga").func_76733_a(5159473).func_76732_a(0.25F, 0.8F).func_150570_a(field_150590_f);
   public static final BiomeGenBase field_76780_h = (new BiomeGenSwamp(6)).func_76739_b(522674).func_76735_a("Swampland").func_76733_a(9154376).func_150570_a(field_150599_m).func_76732_a(0.8F, 0.9F);
   public static final BiomeGenBase field_76781_i = (new BiomeGenRiver(7)).func_76739_b(255).func_76735_a("River").func_150570_a(field_150594_b);
   public static final BiomeGenBase field_76778_j = (new BiomeGenHell(8)).func_76739_b(16711680).func_76735_a("Hell").func_76745_m().func_76732_a(2.0F, 0.0F);
   public static final BiomeGenBase field_76779_k = (new BiomeGenEnd(9)).func_76739_b(8421631).func_76735_a("Sky").func_76745_m();
   public static final BiomeGenBase field_76776_l = (new BiomeGenOcean(10)).func_76739_b(9474208).func_76735_a("FrozenOcean").func_76742_b().func_150570_a(field_150595_c).func_76732_a(0.0F, 0.5F);
   public static final BiomeGenBase field_76777_m = (new BiomeGenRiver(11)).func_76739_b(10526975).func_76735_a("FrozenRiver").func_76742_b().func_150570_a(field_150594_b).func_76732_a(0.0F, 0.5F);
   public static final BiomeGenBase field_76774_n = (new BiomeGenSnow(12, false)).func_76739_b(16777215).func_76735_a("Ice Plains").func_76742_b().func_76732_a(0.0F, 0.5F).func_150570_a(field_150593_e);
   public static final BiomeGenBase field_76775_o = (new BiomeGenSnow(13, false)).func_76739_b(10526880).func_76735_a("Ice Mountains").func_76742_b().func_150570_a(field_150591_g).func_76732_a(0.0F, 0.5F);
   public static final BiomeGenBase field_76789_p = (new BiomeGenMushroomIsland(14)).func_76739_b(16711935).func_76735_a("MushroomIsland").func_76732_a(0.9F, 1.0F).func_150570_a(field_150598_l);
   public static final BiomeGenBase field_76788_q = (new BiomeGenMushroomIsland(15)).func_76739_b(10486015).func_76735_a("MushroomIslandShore").func_76732_a(0.9F, 1.0F).func_150570_a(field_150600_j);
   public static final BiomeGenBase field_76787_r = (new BiomeGenBeach(16)).func_76739_b(16440917).func_76735_a("Beach").func_76732_a(0.8F, 0.4F).func_150570_a(field_150600_j);
   public static final BiomeGenBase field_76786_s = (new BiomeGenDesert(17)).func_76739_b(13786898).func_76735_a("DesertHills").func_76745_m().func_76732_a(2.0F, 0.0F).func_150570_a(field_150591_g);
   public static final BiomeGenBase field_76785_t = (new BiomeGenForest(18, 0)).func_76739_b(2250012).func_76735_a("ForestHills").func_150570_a(field_150591_g);
   public static final BiomeGenBase field_76784_u = (new BiomeGenTaiga(19, 0)).func_76739_b(1456435).func_76735_a("TaigaHills").func_76733_a(5159473).func_76732_a(0.25F, 0.8F).func_150570_a(field_150591_g);
   public static final BiomeGenBase field_76783_v = (new BiomeGenHills(20, true)).func_76739_b(7501978).func_76735_a("Extreme Hills Edge").func_150570_a(field_150603_i.func_150775_a()).func_76732_a(0.2F, 0.3F);
   public static final BiomeGenBase field_76782_w = (new BiomeGenJungle(21, false)).func_76739_b(5470985).func_76735_a("Jungle").func_76733_a(5470985).func_76732_a(0.95F, 0.9F);
   public static final BiomeGenBase field_76792_x = (new BiomeGenJungle(22, false)).func_76739_b(2900485).func_76735_a("JungleHills").func_76733_a(5470985).func_76732_a(0.95F, 0.9F).func_150570_a(field_150591_g);
   public static final BiomeGenBase field_150574_L = (new BiomeGenJungle(23, true)).func_76739_b(6458135).func_76735_a("JungleEdge").func_76733_a(5470985).func_76732_a(0.95F, 0.8F);
   public static final BiomeGenBase field_150575_M = (new BiomeGenOcean(24)).func_76739_b(48).func_76735_a("Deep Ocean").func_150570_a(field_150592_d);
   public static final BiomeGenBase field_150576_N = (new BiomeGenStoneBeach(25)).func_76739_b(10658436).func_76735_a("Stone Beach").func_76732_a(0.2F, 0.3F).func_150570_a(field_150601_k);
   public static final BiomeGenBase field_150577_O = (new BiomeGenBeach(26)).func_76739_b(16445632).func_76735_a("Cold Beach").func_76732_a(0.05F, 0.3F).func_150570_a(field_150600_j).func_76742_b();
   public static final BiomeGenBase field_150583_P = (new BiomeGenForest(27, 2)).func_76735_a("Birch Forest").func_76739_b(3175492);
   public static final BiomeGenBase field_150582_Q = (new BiomeGenForest(28, 2)).func_76735_a("Birch Forest Hills").func_76739_b(2055986).func_150570_a(field_150591_g);
   public static final BiomeGenBase field_150585_R = (new BiomeGenForest(29, 3)).func_76739_b(4215066).func_76735_a("Roofed Forest");
   public static final BiomeGenBase field_150584_S = (new BiomeGenTaiga(30, 0)).func_76739_b(3233098).func_76735_a("Cold Taiga").func_76733_a(5159473).func_76742_b().func_76732_a(-0.5F, 0.4F).func_150570_a(field_150590_f).func_150563_c(16777215);
   public static final BiomeGenBase field_150579_T = (new BiomeGenTaiga(31, 0)).func_76739_b(2375478).func_76735_a("Cold Taiga Hills").func_76733_a(5159473).func_76742_b().func_76732_a(-0.5F, 0.4F).func_150570_a(field_150591_g).func_150563_c(16777215);
   public static final BiomeGenBase field_150578_U = (new BiomeGenTaiga(32, 1)).func_76739_b(5858897).func_76735_a("Mega Taiga").func_76733_a(5159473).func_76732_a(0.3F, 0.8F).func_150570_a(field_150590_f);
   public static final BiomeGenBase field_150581_V = (new BiomeGenTaiga(33, 1)).func_76739_b(4542270).func_76735_a("Mega Taiga Hills").func_76733_a(5159473).func_76732_a(0.3F, 0.8F).func_150570_a(field_150591_g);
   public static final BiomeGenBase field_150580_W = (new BiomeGenHills(34, true)).func_76739_b(5271632).func_76735_a("Extreme Hills+").func_150570_a(field_150603_i).func_76732_a(0.2F, 0.3F);
   public static final BiomeGenBase field_150588_X = (new BiomeGenSavanna(35)).func_76739_b(12431967).func_76735_a("Savanna").func_76732_a(1.2F, 0.0F).func_76745_m().func_150570_a(field_150593_e);
   public static final BiomeGenBase field_150587_Y = (new BiomeGenSavanna(36)).func_76739_b(10984804).func_76735_a("Savanna Plateau").func_76732_a(1.0F, 0.0F).func_76745_m().func_150570_a(field_150602_h);
   public static final BiomeGenBase field_150589_Z = (new BiomeGenMesa(37, false, false)).func_76739_b(14238997).func_76735_a("Mesa");
   public static final BiomeGenBase field_150607_aa = (new BiomeGenMesa(38, false, true)).func_76739_b(11573093).func_76735_a("Mesa Plateau F").func_150570_a(field_150602_h);
   public static final BiomeGenBase field_150608_ab = (new BiomeGenMesa(39, false, false)).func_76739_b(13274213).func_76735_a("Mesa Plateau").func_150570_a(field_150602_h);
   protected static final NoiseGeneratorPerlin field_150605_ac;
   protected static final NoiseGeneratorPerlin field_150606_ad;
   protected static final WorldGenDoublePlant field_150610_ae;
   public String field_76791_y;
   public int field_76790_z;
   public int field_150609_ah;
   public Block field_76752_A;
   public int field_150604_aj;
   public Block field_76753_B;
   public int field_76754_C;
   public float field_76748_D;
   public float field_76749_E;
   public float field_76750_F;
   public float field_76751_G;
   public int field_76759_H;
   public BiomeDecorator field_76760_I;
   protected List field_76761_J;
   protected List field_76762_K;
   protected List field_76755_L;
   protected List field_82914_M;
   protected boolean field_76766_R;
   protected boolean field_76765_S;
   public final int field_76756_M;
   protected WorldGenTrees field_76757_N;
   protected WorldGenBigTree field_76758_O;
   protected WorldGenSwamp field_76763_Q;
   private static final String __OBFID = "CL_00000158";


   protected BiomeGenBase(int p_i1971_1_) {
      this.field_76752_A = Blocks.field_150349_c;
      this.field_150604_aj = 0;
      this.field_76753_B = Blocks.field_150346_d;
      this.field_76754_C = 5169201;
      this.field_76748_D = field_150596_a.field_150777_a;
      this.field_76749_E = field_150596_a.field_150776_b;
      this.field_76750_F = 0.5F;
      this.field_76751_G = 0.5F;
      this.field_76759_H = 16777215;
      this.field_76761_J = new ArrayList();
      this.field_76762_K = new ArrayList();
      this.field_76755_L = new ArrayList();
      this.field_82914_M = new ArrayList();
      this.field_76765_S = true;
      this.field_76757_N = new WorldGenTrees(false);
      this.field_76758_O = new WorldGenBigTree(false);
      this.field_76763_Q = new WorldGenSwamp();
      this.field_76756_M = p_i1971_1_;
      field_76773_a[p_i1971_1_] = this;
      this.field_76760_I = this.func_76729_a();
      this.field_76762_K.add(new BiomeGenBase.SpawnListEntry(EntitySheep.class, 12, 4, 4));
      this.field_76762_K.add(new BiomeGenBase.SpawnListEntry(EntityPig.class, 10, 4, 4));
      this.field_76762_K.add(new BiomeGenBase.SpawnListEntry(EntityChicken.class, 10, 4, 4));
      this.field_76762_K.add(new BiomeGenBase.SpawnListEntry(EntityCow.class, 8, 4, 4));
      this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntitySpider.class, 100, 4, 4));
      this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityZombie.class, 100, 4, 4));
      this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntitySkeleton.class, 100, 4, 4));
      this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityCreeper.class, 100, 4, 4));
      this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntitySlime.class, 100, 4, 4));
      this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityEnderman.class, 10, 1, 4));
      this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityWitch.class, 5, 1, 1));
      this.field_76755_L.add(new BiomeGenBase.SpawnListEntry(EntitySquid.class, 10, 4, 4));
      this.field_82914_M.add(new BiomeGenBase.SpawnListEntry(EntityBat.class, 10, 8, 8));
   }

   protected BiomeDecorator func_76729_a() {
      return new BiomeDecorator();
   }

   protected BiomeGenBase func_76732_a(float p_76732_1_, float p_76732_2_) {
      if(p_76732_1_ > 0.1F && p_76732_1_ < 0.2F) {
         throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
      } else {
         this.field_76750_F = p_76732_1_;
         this.field_76751_G = p_76732_2_;
         return this;
      }
   }

   protected final BiomeGenBase func_150570_a(BiomeGenBase.Height p_150570_1_) {
      this.field_76748_D = p_150570_1_.field_150777_a;
      this.field_76749_E = p_150570_1_.field_150776_b;
      return this;
   }

   protected BiomeGenBase func_76745_m() {
      this.field_76765_S = false;
      return this;
   }

   public WorldGenAbstractTree func_150567_a(Random p_150567_1_) {
      return (WorldGenAbstractTree)(p_150567_1_.nextInt(10) == 0?this.field_76758_O:this.field_76757_N);
   }

   public WorldGenerator func_76730_b(Random p_76730_1_) {
      return new WorldGenTallGrass(Blocks.field_150329_H, 1);
   }

   public String func_150572_a(Random p_150572_1_, int p_150572_2_, int p_150572_3_, int p_150572_4_) {
      return p_150572_1_.nextInt(3) > 0?BlockFlower.field_149858_b[0]:BlockFlower.field_149859_a[0];
   }

   protected BiomeGenBase func_76742_b() {
      this.field_76766_R = true;
      return this;
   }

   protected BiomeGenBase func_76735_a(String p_76735_1_) {
      this.field_76791_y = p_76735_1_;
      return this;
   }

   protected BiomeGenBase func_76733_a(int p_76733_1_) {
      this.field_76754_C = p_76733_1_;
      return this;
   }

   protected BiomeGenBase func_76739_b(int p_76739_1_) {
      this.func_150557_a(p_76739_1_, false);
      return this;
   }

   protected BiomeGenBase func_150563_c(int p_150563_1_) {
      this.field_150609_ah = p_150563_1_;
      return this;
   }

   protected BiomeGenBase func_150557_a(int p_150557_1_, boolean p_150557_2_) {
      this.field_76790_z = p_150557_1_;
      if(p_150557_2_) {
         this.field_150609_ah = (p_150557_1_ & 16711422) >> 1;
      } else {
         this.field_150609_ah = p_150557_1_;
      }

      return this;
   }

   public int func_76731_a(float p_76731_1_) {
      p_76731_1_ /= 3.0F;
      if(p_76731_1_ < -1.0F) {
         p_76731_1_ = -1.0F;
      }

      if(p_76731_1_ > 1.0F) {
         p_76731_1_ = 1.0F;
      }

      return Color.getHSBColor(0.62222224F - p_76731_1_ * 0.05F, 0.5F + p_76731_1_ * 0.1F, 1.0F).getRGB();
   }

   public List func_76747_a(EnumCreatureType p_76747_1_) {
      return p_76747_1_ == EnumCreatureType.monster?this.field_76761_J:(p_76747_1_ == EnumCreatureType.creature?this.field_76762_K:(p_76747_1_ == EnumCreatureType.waterCreature?this.field_76755_L:(p_76747_1_ == EnumCreatureType.ambient?this.field_82914_M:null)));
   }

   public boolean func_76746_c() {
      return this.func_150559_j();
   }

   public boolean func_76738_d() {
      return this.func_150559_j()?false:this.field_76765_S;
   }

   public boolean func_76736_e() {
      return this.field_76751_G > 0.85F;
   }

   public float func_76741_f() {
      return 0.1F;
   }

   public final int func_76744_g() {
      return (int)(this.field_76751_G * 65536.0F);
   }

   public final float func_76727_i() {
      return this.field_76751_G;
   }

   public final float func_150564_a(int p_150564_1_, int p_150564_2_, int p_150564_3_) {
      if(p_150564_2_ > 64) {
         float var4 = (float)field_150605_ac.func_151601_a((double)p_150564_1_ * 1.0D / 8.0D, (double)p_150564_3_ * 1.0D / 8.0D) * 4.0F;
         return this.field_76750_F - (var4 + (float)p_150564_2_ - 64.0F) * 0.05F / 30.0F;
      } else {
         return this.field_76750_F;
      }
   }

   public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
      this.field_76760_I.func_150512_a(p_76728_1_, p_76728_2_, this, p_76728_3_, p_76728_4_);
   }

   public int func_150558_b(int p_150558_1_, int p_150558_2_, int p_150558_3_) {
      double var4 = (double)MathHelper.func_76131_a(this.func_150564_a(p_150558_1_, p_150558_2_, p_150558_3_), 0.0F, 1.0F);
      double var6 = (double)MathHelper.func_76131_a(this.func_76727_i(), 0.0F, 1.0F);
      return ColorizerGrass.func_77480_a(var4, var6);
   }

   public int func_150571_c(int p_150571_1_, int p_150571_2_, int p_150571_3_) {
      double var4 = (double)MathHelper.func_76131_a(this.func_150564_a(p_150571_1_, p_150571_2_, p_150571_3_), 0.0F, 1.0F);
      double var6 = (double)MathHelper.func_76131_a(this.func_76727_i(), 0.0F, 1.0F);
      return ColorizerFoliage.func_77470_a(var4, var6);
   }

   public boolean func_150559_j() {
      return this.field_76766_R;
   }

   public void func_150573_a(World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_) {
      this.func_150560_b(p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
   }

   public final void func_150560_b(World p_150560_1_, Random p_150560_2_, Block[] p_150560_3_, byte[] p_150560_4_, int p_150560_5_, int p_150560_6_, double p_150560_7_) {
      boolean var9 = true;
      Block var10 = this.field_76752_A;
      byte var11 = (byte)(this.field_150604_aj & 255);
      Block var12 = this.field_76753_B;
      int var13 = -1;
      int var14 = (int)(p_150560_7_ / 3.0D + 3.0D + p_150560_2_.nextDouble() * 0.25D);
      int var15 = p_150560_5_ & 15;
      int var16 = p_150560_6_ & 15;
      int var17 = p_150560_3_.length / 256;

      for(int var18 = 255; var18 >= 0; --var18) {
         int var19 = (var16 * 16 + var15) * var17 + var18;
         if(var18 <= 0 + p_150560_2_.nextInt(5)) {
            p_150560_3_[var19] = Blocks.field_150357_h;
         } else {
            Block var20 = p_150560_3_[var19];
            if(var20 != null && var20.func_149688_o() != Material.field_151579_a) {
               if(var20 == Blocks.field_150348_b) {
                  if(var13 == -1) {
                     if(var14 <= 0) {
                        var10 = null;
                        var11 = 0;
                        var12 = Blocks.field_150348_b;
                     } else if(var18 >= 59 && var18 <= 64) {
                        var10 = this.field_76752_A;
                        var11 = (byte)(this.field_150604_aj & 255);
                        var12 = this.field_76753_B;
                     }

                     if(var18 < 63 && (var10 == null || var10.func_149688_o() == Material.field_151579_a)) {
                        if(this.func_150564_a(p_150560_5_, var18, p_150560_6_) < 0.15F) {
                           var10 = Blocks.field_150432_aD;
                           var11 = 0;
                        } else {
                           var10 = Blocks.field_150355_j;
                           var11 = 0;
                        }
                     }

                     var13 = var14;
                     if(var18 >= 62) {
                        p_150560_3_[var19] = var10;
                        p_150560_4_[var19] = var11;
                     } else if(var18 < 56 - var14) {
                        var10 = null;
                        var12 = Blocks.field_150348_b;
                        p_150560_3_[var19] = Blocks.field_150351_n;
                     } else {
                        p_150560_3_[var19] = var12;
                     }
                  } else if(var13 > 0) {
                     --var13;
                     p_150560_3_[var19] = var12;
                     if(var13 == 0 && var12 == Blocks.field_150354_m) {
                        var13 = p_150560_2_.nextInt(4) + Math.max(0, var18 - 63);
                        var12 = Blocks.field_150322_A;
                     }
                  }
               }
            } else {
               var13 = -1;
            }
         }
      }

   }

   protected BiomeGenBase func_150566_k() {
      return new BiomeGenMutated(this.field_76756_M + 128, this);
   }

   public Class func_150562_l() {
      return this.getClass();
   }

   public boolean func_150569_a(BiomeGenBase p_150569_1_) {
      return p_150569_1_ == this?true:(p_150569_1_ == null?false:this.func_150562_l() == p_150569_1_.func_150562_l());
   }

   public BiomeGenBase.TempCategory func_150561_m() {
      return (double)this.field_76750_F < 0.2D?BiomeGenBase.TempCategory.COLD:((double)this.field_76750_F < 1.0D?BiomeGenBase.TempCategory.MEDIUM:BiomeGenBase.TempCategory.WARM);
   }

   public static BiomeGenBase[] func_150565_n() {
      return field_76773_a;
   }

   public static BiomeGenBase func_150568_d(int p_150568_0_) {
      if(p_150568_0_ >= 0 && p_150568_0_ <= field_76773_a.length) {
         return field_76773_a[p_150568_0_];
      } else {
         field_150586_aC.warn("Biome ID is out of bounds: " + p_150568_0_ + ", defaulting to 0 (Ocean)");
         return field_76771_b;
      }
   }

   static {
      field_76772_c.func_150566_k();
      field_76769_d.func_150566_k();
      field_76767_f.func_150566_k();
      field_76768_g.func_150566_k();
      field_76780_h.func_150566_k();
      field_76774_n.func_150566_k();
      field_76782_w.func_150566_k();
      field_150574_L.func_150566_k();
      field_150584_S.func_150566_k();
      field_150588_X.func_150566_k();
      field_150587_Y.func_150566_k();
      field_150589_Z.func_150566_k();
      field_150607_aa.func_150566_k();
      field_150608_ab.func_150566_k();
      field_150583_P.func_150566_k();
      field_150582_Q.func_150566_k();
      field_150585_R.func_150566_k();
      field_150578_U.func_150566_k();
      field_76770_e.func_150566_k();
      field_150580_W.func_150566_k();
      field_76773_a[field_150581_V.field_76756_M + 128] = field_76773_a[field_150578_U.field_76756_M + 128];
      BiomeGenBase[] var0 = field_76773_a;
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         BiomeGenBase var3 = var0[var2];
         if(var3 != null && var3.field_76756_M < 128) {
            field_150597_n.add(var3);
         }
      }

      field_150597_n.remove(field_76778_j);
      field_150597_n.remove(field_76779_k);
      field_150597_n.remove(field_76776_l);
      field_150597_n.remove(field_76783_v);
      field_150605_ac = new NoiseGeneratorPerlin(new Random(1234L), 1);
      field_150606_ad = new NoiseGeneratorPerlin(new Random(2345L), 1);
      field_150610_ae = new WorldGenDoublePlant();
   }

   public static class Height {

      public float field_150777_a;
      public float field_150776_b;
      private static final String __OBFID = "CL_00000159";


      public Height(float p_i45371_1_, float p_i45371_2_) {
         this.field_150777_a = p_i45371_1_;
         this.field_150776_b = p_i45371_2_;
      }

      public BiomeGenBase.Height func_150775_a() {
         return new BiomeGenBase.Height(this.field_150777_a * 0.8F, this.field_150776_b * 0.6F);
      }
   }

   public static class SpawnListEntry extends WeightedRandom.Item {

      public Class field_76300_b;
      public int field_76301_c;
      public int field_76299_d;
      private static final String __OBFID = "CL_00000161";


      public SpawnListEntry(Class p_i1970_1_, int p_i1970_2_, int p_i1970_3_, int p_i1970_4_) {
         super(p_i1970_2_);
         this.field_76300_b = p_i1970_1_;
         this.field_76301_c = p_i1970_3_;
         this.field_76299_d = p_i1970_4_;
      }

      public String toString() {
         return this.field_76300_b.getSimpleName() + "*(" + this.field_76301_c + "-" + this.field_76299_d + "):" + this.field_76292_a;
      }
   }

   public static enum TempCategory {

      OCEAN("OCEAN", 0),
      COLD("COLD", 1),
      MEDIUM("MEDIUM", 2),
      WARM("WARM", 3);
      // $FF: synthetic field
      private static final BiomeGenBase.TempCategory[] $VALUES = new BiomeGenBase.TempCategory[]{OCEAN, COLD, MEDIUM, WARM};
      private static final String __OBFID = "CL_00000160";


      private TempCategory(String p_i45372_1_, int p_i45372_2_) {}

   }
}
