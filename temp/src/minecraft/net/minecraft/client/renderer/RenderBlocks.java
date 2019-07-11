package net.minecraft.client.renderer;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockBeacon;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockBrewingStand;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.BlockCocoa;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.block.BlockEndPortalFrame;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockFlowerPot;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockPane;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockPistonExtension;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.BlockRedstoneComparator;
import net.minecraft.block.BlockRedstoneDiode;
import net.minecraft.block.BlockRedstoneRepeater;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.block.BlockStainedGlassPane;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockStem;
import net.minecraft.block.BlockTripWire;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntityRendererChestHelper;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class RenderBlocks {

   public IBlockAccess field_147845_a;
   private IIcon field_147840_d;
   private boolean field_147842_e;
   private boolean field_152631_f;
   private boolean field_147837_f;
   public static boolean field_147843_b = true;
   public boolean field_147844_c = true;
   private boolean field_147838_g = false;
   private double field_147859_h;
   private double field_147861_i;
   private double field_147855_j;
   private double field_147857_k;
   private double field_147851_l;
   private double field_147853_m;
   private boolean field_147847_n;
   private boolean field_147849_o;
   private final Minecraft field_147877_p;
   private int field_147875_q;
   private int field_147873_r;
   private int field_147871_s;
   private int field_147869_t;
   private int field_147867_u;
   private int field_147865_v;
   private boolean field_147863_w;
   private float field_147888_x;
   private float field_147886_y;
   private float field_147884_z;
   private float field_147814_A;
   private float field_147815_B;
   private float field_147816_C;
   private float field_147810_D;
   private float field_147811_E;
   private float field_147812_F;
   private float field_147813_G;
   private float field_147821_H;
   private float field_147822_I;
   private float field_147823_J;
   private float field_147824_K;
   private float field_147817_L;
   private float field_147818_M;
   private float field_147819_N;
   private float field_147820_O;
   private float field_147830_P;
   private float field_147829_Q;
   private int field_147832_R;
   private int field_147831_S;
   private int field_147826_T;
   private int field_147825_U;
   private int field_147828_V;
   private int field_147827_W;
   private int field_147835_X;
   private int field_147834_Y;
   private int field_147836_Z;
   private int field_147880_aa;
   private int field_147881_ab;
   private int field_147878_ac;
   private int field_147879_ad;
   private int field_147885_ae;
   private int field_147887_af;
   private int field_147882_ag;
   private int field_147883_ah;
   private int field_147866_ai;
   private int field_147868_aj;
   private int field_147862_ak;
   private int field_147864_al;
   private int field_147874_am;
   private int field_147876_an;
   private int field_147870_ao;
   private float field_147872_ap;
   private float field_147852_aq;
   private float field_147850_ar;
   private float field_147848_as;
   private float field_147846_at;
   private float field_147860_au;
   private float field_147858_av;
   private float field_147856_aw;
   private float field_147854_ax;
   private float field_147841_ay;
   private float field_147839_az;
   private float field_147833_aA;
   private static final String __OBFID = "CL_00000940";


   public RenderBlocks(IBlockAccess p_i1251_1_) {
      this.field_147845_a = p_i1251_1_;
      this.field_152631_f = false;
      this.field_147842_e = false;
      this.field_147877_p = Minecraft.func_71410_x();
   }

   public RenderBlocks() {
      this.field_147877_p = Minecraft.func_71410_x();
   }

   public void func_147757_a(IIcon p_147757_1_) {
      this.field_147840_d = p_147757_1_;
   }

   public void func_147771_a() {
      this.field_147840_d = null;
   }

   public boolean func_147744_b() {
      return this.field_147840_d != null;
   }

   public void func_147786_a(boolean p_147786_1_) {
      this.field_147838_g = p_147786_1_;
   }

   public void func_147753_b(boolean p_147753_1_) {
      this.field_147837_f = p_147753_1_;
   }

   public void func_147782_a(double p_147782_1_, double p_147782_3_, double p_147782_5_, double p_147782_7_, double p_147782_9_, double p_147782_11_) {
      if(!this.field_147847_n) {
         this.field_147859_h = p_147782_1_;
         this.field_147861_i = p_147782_7_;
         this.field_147855_j = p_147782_3_;
         this.field_147857_k = p_147782_9_;
         this.field_147851_l = p_147782_5_;
         this.field_147853_m = p_147782_11_;
         this.field_147849_o = this.field_147877_p.field_71474_y.field_74348_k >= 2 && (this.field_147859_h > 0.0D || this.field_147861_i < 1.0D || this.field_147855_j > 0.0D || this.field_147857_k < 1.0D || this.field_147851_l > 0.0D || this.field_147853_m < 1.0D);
      }

   }

   public void func_147775_a(Block p_147775_1_) {
      if(!this.field_147847_n) {
         this.field_147859_h = p_147775_1_.func_149704_x();
         this.field_147861_i = p_147775_1_.func_149753_y();
         this.field_147855_j = p_147775_1_.func_149665_z();
         this.field_147857_k = p_147775_1_.func_149669_A();
         this.field_147851_l = p_147775_1_.func_149706_B();
         this.field_147853_m = p_147775_1_.func_149693_C();
         this.field_147849_o = this.field_147877_p.field_71474_y.field_74348_k >= 2 && (this.field_147859_h > 0.0D || this.field_147861_i < 1.0D || this.field_147855_j > 0.0D || this.field_147857_k < 1.0D || this.field_147851_l > 0.0D || this.field_147853_m < 1.0D);
      }

   }

   public void func_147770_b(double p_147770_1_, double p_147770_3_, double p_147770_5_, double p_147770_7_, double p_147770_9_, double p_147770_11_) {
      this.field_147859_h = p_147770_1_;
      this.field_147861_i = p_147770_7_;
      this.field_147855_j = p_147770_3_;
      this.field_147857_k = p_147770_9_;
      this.field_147851_l = p_147770_5_;
      this.field_147853_m = p_147770_11_;
      this.field_147847_n = true;
      this.field_147849_o = this.field_147877_p.field_71474_y.field_74348_k >= 2 && (this.field_147859_h > 0.0D || this.field_147861_i < 1.0D || this.field_147855_j > 0.0D || this.field_147857_k < 1.0D || this.field_147851_l > 0.0D || this.field_147853_m < 1.0D);
   }

   public void func_147762_c() {
      this.field_147847_n = false;
   }

   public void func_147792_a(Block p_147792_1_, int p_147792_2_, int p_147792_3_, int p_147792_4_, IIcon p_147792_5_) {
      this.func_147757_a(p_147792_5_);
      this.func_147805_b(p_147792_1_, p_147792_2_, p_147792_3_, p_147792_4_);
      this.func_147771_a();
   }

   public void func_147769_a(Block p_147769_1_, int p_147769_2_, int p_147769_3_, int p_147769_4_) {
      this.field_147837_f = true;
      this.func_147805_b(p_147769_1_, p_147769_2_, p_147769_3_, p_147769_4_);
      this.field_147837_f = false;
   }

   public boolean func_147805_b(Block p_147805_1_, int p_147805_2_, int p_147805_3_, int p_147805_4_) {
      int var5 = p_147805_1_.func_149645_b();
      if(var5 == -1) {
         return false;
      } else {
         p_147805_1_.func_149719_a(this.field_147845_a, p_147805_2_, p_147805_3_, p_147805_4_);
         this.func_147775_a(p_147805_1_);
         return var5 == 0?this.func_147784_q(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 4?this.func_147721_p(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 31?this.func_147742_r(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 1?this.func_147746_l(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 40?this.func_147774_a((BlockDoublePlant)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 2?this.func_147791_c(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 20?this.func_147726_j(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 11?this.func_147735_a((BlockFence)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 39?this.func_147779_s(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 5?this.func_147788_h(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 13?this.func_147755_t(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 9?this.func_147766_a((BlockRailBase)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 19?this.func_147724_m(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 23?this.func_147783_o(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 6?this.func_147796_n(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 3?this.func_147801_a((BlockFire)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 8?this.func_147794_i(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 7?this.func_147760_u(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 10?this.func_147722_a((BlockStairs)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 27?this.func_147802_a((BlockDragonEgg)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 32?this.func_147807_a((BlockWall)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 12?this.func_147790_e(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 29?this.func_147723_f(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 30?this.func_147756_g(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 14?this.func_147773_v(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 15?this.func_147759_a((BlockRedstoneRepeater)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 36?this.func_147748_a((BlockRedstoneDiode)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 37?this.func_147781_a((BlockRedstoneComparator)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 16?this.func_147731_b(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_, false):(var5 == 17?this.func_147809_c(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_, true):(var5 == 18?this.func_147767_a((BlockPane)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 41?this.func_147733_k(p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 21?this.func_147776_a((BlockFenceGate)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 24?this.func_147785_a((BlockCauldron)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 33?this.func_147752_a((BlockFlowerPot)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 35?this.func_147725_a((BlockAnvil)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 25?this.func_147741_a((BlockBrewingStand)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 26?this.func_147743_a((BlockEndPortalFrame)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 28?this.func_147772_a((BlockCocoa)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 34?this.func_147797_a((BlockBeacon)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):(var5 == 38?this.func_147803_a((BlockHopper)p_147805_1_, p_147805_2_, p_147805_3_, p_147805_4_):false))))))))))))))))))))))))))))))))))))))));
      }
   }

   private boolean func_147743_a(BlockEndPortalFrame p_147743_1_, int p_147743_2_, int p_147743_3_, int p_147743_4_) {
      int var5 = this.field_147845_a.func_72805_g(p_147743_2_, p_147743_3_, p_147743_4_);
      int var6 = var5 & 3;
      if(var6 == 0) {
         this.field_147867_u = 3;
      } else if(var6 == 3) {
         this.field_147867_u = 1;
      } else if(var6 == 1) {
         this.field_147867_u = 2;
      }

      if(!BlockEndPortalFrame.func_150020_b(var5)) {
         this.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 0.8125D, 1.0D);
         this.func_147784_q(p_147743_1_, p_147743_2_, p_147743_3_, p_147743_4_);
         this.field_147867_u = 0;
         return true;
      } else {
         this.field_147837_f = true;
         this.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 0.8125D, 1.0D);
         this.func_147784_q(p_147743_1_, p_147743_2_, p_147743_3_, p_147743_4_);
         this.func_147757_a(p_147743_1_.func_150021_e());
         this.func_147782_a(0.25D, 0.8125D, 0.25D, 0.75D, 1.0D, 0.75D);
         this.func_147784_q(p_147743_1_, p_147743_2_, p_147743_3_, p_147743_4_);
         this.field_147837_f = false;
         this.func_147771_a();
         this.field_147867_u = 0;
         return true;
      }
   }

   private boolean func_147773_v(Block p_147773_1_, int p_147773_2_, int p_147773_3_, int p_147773_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      int var6 = this.field_147845_a.func_72805_g(p_147773_2_, p_147773_3_, p_147773_4_);
      int var7 = BlockBed.func_149895_l(var6);
      boolean var8 = BlockBed.func_149975_b(var6);
      float var9 = 0.5F;
      float var10 = 1.0F;
      float var11 = 0.8F;
      float var12 = 0.6F;
      int var25 = p_147773_1_.func_149677_c(this.field_147845_a, p_147773_2_, p_147773_3_, p_147773_4_);
      var5.func_78380_c(var25);
      var5.func_78386_a(var9, var9, var9);
      IIcon var26 = this.func_147793_a(p_147773_1_, this.field_147845_a, p_147773_2_, p_147773_3_, p_147773_4_, 0);
      double var27 = (double)var26.func_94209_e();
      double var29 = (double)var26.func_94212_f();
      double var31 = (double)var26.func_94206_g();
      double var33 = (double)var26.func_94210_h();
      double var35 = (double)p_147773_2_ + this.field_147859_h;
      double var37 = (double)p_147773_2_ + this.field_147861_i;
      double var39 = (double)p_147773_3_ + this.field_147855_j + 0.1875D;
      double var41 = (double)p_147773_4_ + this.field_147851_l;
      double var43 = (double)p_147773_4_ + this.field_147853_m;
      var5.func_78374_a(var35, var39, var43, var27, var33);
      var5.func_78374_a(var35, var39, var41, var27, var31);
      var5.func_78374_a(var37, var39, var41, var29, var31);
      var5.func_78374_a(var37, var39, var43, var29, var33);
      var5.func_78380_c(p_147773_1_.func_149677_c(this.field_147845_a, p_147773_2_, p_147773_3_ + 1, p_147773_4_));
      var5.func_78386_a(var10, var10, var10);
      var26 = this.func_147793_a(p_147773_1_, this.field_147845_a, p_147773_2_, p_147773_3_, p_147773_4_, 1);
      var27 = (double)var26.func_94209_e();
      var29 = (double)var26.func_94212_f();
      var31 = (double)var26.func_94206_g();
      var33 = (double)var26.func_94210_h();
      var35 = var27;
      var37 = var29;
      var39 = var31;
      var41 = var31;
      var43 = var27;
      double var45 = var29;
      double var47 = var33;
      double var49 = var33;
      if(var7 == 0) {
         var37 = var27;
         var39 = var33;
         var43 = var29;
         var49 = var31;
      } else if(var7 == 2) {
         var35 = var29;
         var41 = var33;
         var45 = var27;
         var47 = var31;
      } else if(var7 == 3) {
         var35 = var29;
         var41 = var33;
         var45 = var27;
         var47 = var31;
         var37 = var27;
         var39 = var33;
         var43 = var29;
         var49 = var31;
      }

      double var51 = (double)p_147773_2_ + this.field_147859_h;
      double var53 = (double)p_147773_2_ + this.field_147861_i;
      double var55 = (double)p_147773_3_ + this.field_147857_k;
      double var57 = (double)p_147773_4_ + this.field_147851_l;
      double var59 = (double)p_147773_4_ + this.field_147853_m;
      var5.func_78374_a(var53, var55, var59, var43, var47);
      var5.func_78374_a(var53, var55, var57, var35, var39);
      var5.func_78374_a(var51, var55, var57, var37, var41);
      var5.func_78374_a(var51, var55, var59, var45, var49);
      int var61 = Direction.field_71582_c[var7];
      if(var8) {
         var61 = Direction.field_71582_c[Direction.field_71580_e[var7]];
      }

      byte var62 = 4;
      switch(var7) {
      case 0:
         var62 = 5;
         break;
      case 1:
         var62 = 3;
      case 2:
      default:
         break;
      case 3:
         var62 = 2;
      }

      if(var61 != 2 && (this.field_147837_f || p_147773_1_.func_149646_a(this.field_147845_a, p_147773_2_, p_147773_3_, p_147773_4_ - 1, 2))) {
         var5.func_78380_c(this.field_147851_l > 0.0D?var25:p_147773_1_.func_149677_c(this.field_147845_a, p_147773_2_, p_147773_3_, p_147773_4_ - 1));
         var5.func_78386_a(var11, var11, var11);
         this.field_147842_e = var62 == 2;
         this.func_147761_c(p_147773_1_, (double)p_147773_2_, (double)p_147773_3_, (double)p_147773_4_, this.func_147793_a(p_147773_1_, this.field_147845_a, p_147773_2_, p_147773_3_, p_147773_4_, 2));
      }

      if(var61 != 3 && (this.field_147837_f || p_147773_1_.func_149646_a(this.field_147845_a, p_147773_2_, p_147773_3_, p_147773_4_ + 1, 3))) {
         var5.func_78380_c(this.field_147853_m < 1.0D?var25:p_147773_1_.func_149677_c(this.field_147845_a, p_147773_2_, p_147773_3_, p_147773_4_ + 1));
         var5.func_78386_a(var11, var11, var11);
         this.field_147842_e = var62 == 3;
         this.func_147734_d(p_147773_1_, (double)p_147773_2_, (double)p_147773_3_, (double)p_147773_4_, this.func_147793_a(p_147773_1_, this.field_147845_a, p_147773_2_, p_147773_3_, p_147773_4_, 3));
      }

      if(var61 != 4 && (this.field_147837_f || p_147773_1_.func_149646_a(this.field_147845_a, p_147773_2_ - 1, p_147773_3_, p_147773_4_, 4))) {
         var5.func_78380_c(this.field_147851_l > 0.0D?var25:p_147773_1_.func_149677_c(this.field_147845_a, p_147773_2_ - 1, p_147773_3_, p_147773_4_));
         var5.func_78386_a(var12, var12, var12);
         this.field_147842_e = var62 == 4;
         this.func_147798_e(p_147773_1_, (double)p_147773_2_, (double)p_147773_3_, (double)p_147773_4_, this.func_147793_a(p_147773_1_, this.field_147845_a, p_147773_2_, p_147773_3_, p_147773_4_, 4));
      }

      if(var61 != 5 && (this.field_147837_f || p_147773_1_.func_149646_a(this.field_147845_a, p_147773_2_ + 1, p_147773_3_, p_147773_4_, 5))) {
         var5.func_78380_c(this.field_147853_m < 1.0D?var25:p_147773_1_.func_149677_c(this.field_147845_a, p_147773_2_ + 1, p_147773_3_, p_147773_4_));
         var5.func_78386_a(var12, var12, var12);
         this.field_147842_e = var62 == 5;
         this.func_147764_f(p_147773_1_, (double)p_147773_2_, (double)p_147773_3_, (double)p_147773_4_, this.func_147793_a(p_147773_1_, this.field_147845_a, p_147773_2_, p_147773_3_, p_147773_4_, 5));
      }

      this.field_147842_e = false;
      return true;
   }

   private boolean func_147741_a(BlockBrewingStand p_147741_1_, int p_147741_2_, int p_147741_3_, int p_147741_4_) {
      this.func_147782_a(0.4375D, 0.0D, 0.4375D, 0.5625D, 0.875D, 0.5625D);
      this.func_147784_q(p_147741_1_, p_147741_2_, p_147741_3_, p_147741_4_);
      this.func_147757_a(p_147741_1_.func_149959_e());
      this.field_147837_f = true;
      this.func_147782_a(0.5625D, 0.0D, 0.3125D, 0.9375D, 0.125D, 0.6875D);
      this.func_147784_q(p_147741_1_, p_147741_2_, p_147741_3_, p_147741_4_);
      this.func_147782_a(0.125D, 0.0D, 0.0625D, 0.5D, 0.125D, 0.4375D);
      this.func_147784_q(p_147741_1_, p_147741_2_, p_147741_3_, p_147741_4_);
      this.func_147782_a(0.125D, 0.0D, 0.5625D, 0.5D, 0.125D, 0.9375D);
      this.func_147784_q(p_147741_1_, p_147741_2_, p_147741_3_, p_147741_4_);
      this.field_147837_f = false;
      this.func_147771_a();
      Tessellator var5 = Tessellator.field_78398_a;
      var5.func_78380_c(p_147741_1_.func_149677_c(this.field_147845_a, p_147741_2_, p_147741_3_, p_147741_4_));
      int var6 = p_147741_1_.func_149720_d(this.field_147845_a, p_147741_2_, p_147741_3_, p_147741_4_);
      float var7 = (float)(var6 >> 16 & 255) / 255.0F;
      float var8 = (float)(var6 >> 8 & 255) / 255.0F;
      float var9 = (float)(var6 & 255) / 255.0F;
      if(EntityRenderer.field_78517_a) {
         float var10 = (var7 * 30.0F + var8 * 59.0F + var9 * 11.0F) / 100.0F;
         float var11 = (var7 * 30.0F + var8 * 70.0F) / 100.0F;
         float var12 = (var7 * 30.0F + var9 * 70.0F) / 100.0F;
         var7 = var10;
         var8 = var11;
         var9 = var12;
      }

      var5.func_78386_a(var7, var8, var9);
      IIcon var31 = this.func_147787_a(p_147741_1_, 0, 0);
      if(this.func_147744_b()) {
         var31 = this.field_147840_d;
      }

      double var32 = (double)var31.func_94206_g();
      double var13 = (double)var31.func_94210_h();
      int var15 = this.field_147845_a.func_72805_g(p_147741_2_, p_147741_3_, p_147741_4_);

      for(int var16 = 0; var16 < 3; ++var16) {
         double var17 = (double)var16 * 3.141592653589793D * 2.0D / 3.0D + 1.5707963267948966D;
         double var19 = (double)var31.func_94214_a(8.0D);
         double var21 = (double)var31.func_94212_f();
         if((var15 & 1 << var16) != 0) {
            var21 = (double)var31.func_94209_e();
         }

         double var23 = (double)p_147741_2_ + 0.5D;
         double var25 = (double)p_147741_2_ + 0.5D + Math.sin(var17) * 8.0D / 16.0D;
         double var27 = (double)p_147741_4_ + 0.5D;
         double var29 = (double)p_147741_4_ + 0.5D + Math.cos(var17) * 8.0D / 16.0D;
         var5.func_78374_a(var23, (double)(p_147741_3_ + 1), var27, var19, var32);
         var5.func_78374_a(var23, (double)(p_147741_3_ + 0), var27, var19, var13);
         var5.func_78374_a(var25, (double)(p_147741_3_ + 0), var29, var21, var13);
         var5.func_78374_a(var25, (double)(p_147741_3_ + 1), var29, var21, var32);
         var5.func_78374_a(var25, (double)(p_147741_3_ + 1), var29, var21, var32);
         var5.func_78374_a(var25, (double)(p_147741_3_ + 0), var29, var21, var13);
         var5.func_78374_a(var23, (double)(p_147741_3_ + 0), var27, var19, var13);
         var5.func_78374_a(var23, (double)(p_147741_3_ + 1), var27, var19, var32);
      }

      p_147741_1_.func_149683_g();
      return true;
   }

   private boolean func_147785_a(BlockCauldron p_147785_1_, int p_147785_2_, int p_147785_3_, int p_147785_4_) {
      this.func_147784_q(p_147785_1_, p_147785_2_, p_147785_3_, p_147785_4_);
      Tessellator var5 = Tessellator.field_78398_a;
      var5.func_78380_c(p_147785_1_.func_149677_c(this.field_147845_a, p_147785_2_, p_147785_3_, p_147785_4_));
      int var6 = p_147785_1_.func_149720_d(this.field_147845_a, p_147785_2_, p_147785_3_, p_147785_4_);
      float var7 = (float)(var6 >> 16 & 255) / 255.0F;
      float var8 = (float)(var6 >> 8 & 255) / 255.0F;
      float var9 = (float)(var6 & 255) / 255.0F;
      float var11;
      if(EntityRenderer.field_78517_a) {
         float var10 = (var7 * 30.0F + var8 * 59.0F + var9 * 11.0F) / 100.0F;
         var11 = (var7 * 30.0F + var8 * 70.0F) / 100.0F;
         float var12 = (var7 * 30.0F + var9 * 70.0F) / 100.0F;
         var7 = var10;
         var8 = var11;
         var9 = var12;
      }

      var5.func_78386_a(var7, var8, var9);
      IIcon var15 = p_147785_1_.func_149733_h(2);
      var11 = 0.125F;
      this.func_147764_f(p_147785_1_, (double)((float)p_147785_2_ - 1.0F + var11), (double)p_147785_3_, (double)p_147785_4_, var15);
      this.func_147798_e(p_147785_1_, (double)((float)p_147785_2_ + 1.0F - var11), (double)p_147785_3_, (double)p_147785_4_, var15);
      this.func_147734_d(p_147785_1_, (double)p_147785_2_, (double)p_147785_3_, (double)((float)p_147785_4_ - 1.0F + var11), var15);
      this.func_147761_c(p_147785_1_, (double)p_147785_2_, (double)p_147785_3_, (double)((float)p_147785_4_ + 1.0F - var11), var15);
      IIcon var16 = BlockCauldron.func_150026_e("inner");
      this.func_147806_b(p_147785_1_, (double)p_147785_2_, (double)((float)p_147785_3_ - 1.0F + 0.25F), (double)p_147785_4_, var16);
      this.func_147768_a(p_147785_1_, (double)p_147785_2_, (double)((float)p_147785_3_ + 1.0F - 0.75F), (double)p_147785_4_, var16);
      int var13 = this.field_147845_a.func_72805_g(p_147785_2_, p_147785_3_, p_147785_4_);
      if(var13 > 0) {
         IIcon var14 = BlockLiquid.func_149803_e("water_still");
         this.func_147806_b(p_147785_1_, (double)p_147785_2_, (double)((float)p_147785_3_ - 1.0F + BlockCauldron.func_150025_c(var13)), (double)p_147785_4_, var14);
      }

      return true;
   }

   private boolean func_147752_a(BlockFlowerPot p_147752_1_, int p_147752_2_, int p_147752_3_, int p_147752_4_) {
      this.func_147784_q(p_147752_1_, p_147752_2_, p_147752_3_, p_147752_4_);
      Tessellator var5 = Tessellator.field_78398_a;
      var5.func_78380_c(p_147752_1_.func_149677_c(this.field_147845_a, p_147752_2_, p_147752_3_, p_147752_4_));
      int var6 = p_147752_1_.func_149720_d(this.field_147845_a, p_147752_2_, p_147752_3_, p_147752_4_);
      IIcon var7 = this.func_147777_a(p_147752_1_, 0);
      float var8 = (float)(var6 >> 16 & 255) / 255.0F;
      float var9 = (float)(var6 >> 8 & 255) / 255.0F;
      float var10 = (float)(var6 & 255) / 255.0F;
      float var11;
      if(EntityRenderer.field_78517_a) {
         var11 = (var8 * 30.0F + var9 * 59.0F + var10 * 11.0F) / 100.0F;
         float var12 = (var8 * 30.0F + var9 * 70.0F) / 100.0F;
         float var13 = (var8 * 30.0F + var10 * 70.0F) / 100.0F;
         var8 = var11;
         var9 = var12;
         var10 = var13;
      }

      var5.func_78386_a(var8, var9, var10);
      var11 = 0.1865F;
      this.func_147764_f(p_147752_1_, (double)((float)p_147752_2_ - 0.5F + var11), (double)p_147752_3_, (double)p_147752_4_, var7);
      this.func_147798_e(p_147752_1_, (double)((float)p_147752_2_ + 0.5F - var11), (double)p_147752_3_, (double)p_147752_4_, var7);
      this.func_147734_d(p_147752_1_, (double)p_147752_2_, (double)p_147752_3_, (double)((float)p_147752_4_ - 0.5F + var11), var7);
      this.func_147761_c(p_147752_1_, (double)p_147752_2_, (double)p_147752_3_, (double)((float)p_147752_4_ + 0.5F - var11), var7);
      this.func_147806_b(p_147752_1_, (double)p_147752_2_, (double)((float)p_147752_3_ - 0.5F + var11 + 0.1875F), (double)p_147752_4_, this.func_147745_b(Blocks.field_150346_d));
      TileEntity var21 = this.field_147845_a.func_147438_o(p_147752_2_, p_147752_3_, p_147752_4_);
      if(var21 != null && var21 instanceof TileEntityFlowerPot) {
         Item var22 = ((TileEntityFlowerPot)var21).func_145965_a();
         int var14 = ((TileEntityFlowerPot)var21).func_145966_b();
         if(var22 instanceof ItemBlock) {
            Block var15 = Block.func_149634_a(var22);
            int var16 = var15.func_149645_b();
            float var17 = 0.0F;
            float var18 = 4.0F;
            float var19 = 0.0F;
            var5.func_78372_c(var17 / 16.0F, var18 / 16.0F, var19 / 16.0F);
            var6 = var15.func_149720_d(this.field_147845_a, p_147752_2_, p_147752_3_, p_147752_4_);
            if(var6 != 16777215) {
               var8 = (float)(var6 >> 16 & 255) / 255.0F;
               var9 = (float)(var6 >> 8 & 255) / 255.0F;
               var10 = (float)(var6 & 255) / 255.0F;
               var5.func_78386_a(var8, var9, var10);
            }

            if(var16 == 1) {
               this.func_147765_a(this.func_147787_a(var15, 0, var14), (double)p_147752_2_, (double)p_147752_3_, (double)p_147752_4_, 0.75F);
            } else if(var16 == 13) {
               this.field_147837_f = true;
               float var20 = 0.125F;
               this.func_147782_a((double)(0.5F - var20), 0.0D, (double)(0.5F - var20), (double)(0.5F + var20), 0.25D, (double)(0.5F + var20));
               this.func_147784_q(var15, p_147752_2_, p_147752_3_, p_147752_4_);
               this.func_147782_a((double)(0.5F - var20), 0.25D, (double)(0.5F - var20), (double)(0.5F + var20), 0.5D, (double)(0.5F + var20));
               this.func_147784_q(var15, p_147752_2_, p_147752_3_, p_147752_4_);
               this.func_147782_a((double)(0.5F - var20), 0.5D, (double)(0.5F - var20), (double)(0.5F + var20), 0.75D, (double)(0.5F + var20));
               this.func_147784_q(var15, p_147752_2_, p_147752_3_, p_147752_4_);
               this.field_147837_f = false;
               this.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
            }

            var5.func_78372_c(-var17 / 16.0F, -var18 / 16.0F, -var19 / 16.0F);
         }
      }

      return true;
   }

   private boolean func_147725_a(BlockAnvil p_147725_1_, int p_147725_2_, int p_147725_3_, int p_147725_4_) {
      return this.func_147780_a(p_147725_1_, p_147725_2_, p_147725_3_, p_147725_4_, this.field_147845_a.func_72805_g(p_147725_2_, p_147725_3_, p_147725_4_));
   }

   public boolean func_147780_a(BlockAnvil p_147780_1_, int p_147780_2_, int p_147780_3_, int p_147780_4_, int p_147780_5_) {
      Tessellator var6 = Tessellator.field_78398_a;
      var6.func_78380_c(p_147780_1_.func_149677_c(this.field_147845_a, p_147780_2_, p_147780_3_, p_147780_4_));
      int var7 = p_147780_1_.func_149720_d(this.field_147845_a, p_147780_2_, p_147780_3_, p_147780_4_);
      float var8 = (float)(var7 >> 16 & 255) / 255.0F;
      float var9 = (float)(var7 >> 8 & 255) / 255.0F;
      float var10 = (float)(var7 & 255) / 255.0F;
      if(EntityRenderer.field_78517_a) {
         float var11 = (var8 * 30.0F + var9 * 59.0F + var10 * 11.0F) / 100.0F;
         float var12 = (var8 * 30.0F + var9 * 70.0F) / 100.0F;
         float var13 = (var8 * 30.0F + var10 * 70.0F) / 100.0F;
         var8 = var11;
         var9 = var12;
         var10 = var13;
      }

      var6.func_78386_a(var8, var9, var10);
      return this.func_147728_a(p_147780_1_, p_147780_2_, p_147780_3_, p_147780_4_, p_147780_5_, false);
   }

   private boolean func_147728_a(BlockAnvil p_147728_1_, int p_147728_2_, int p_147728_3_, int p_147728_4_, int p_147728_5_, boolean p_147728_6_) {
      int var7 = p_147728_6_?0:p_147728_5_ & 3;
      boolean var8 = false;
      float var9 = 0.0F;
      switch(var7) {
      case 0:
         this.field_147871_s = 2;
         this.field_147869_t = 1;
         this.field_147867_u = 3;
         this.field_147865_v = 3;
         break;
      case 1:
         this.field_147875_q = 1;
         this.field_147873_r = 2;
         this.field_147867_u = 2;
         this.field_147865_v = 1;
         var8 = true;
         break;
      case 2:
         this.field_147871_s = 1;
         this.field_147869_t = 2;
         break;
      case 3:
         this.field_147875_q = 2;
         this.field_147873_r = 1;
         this.field_147867_u = 1;
         this.field_147865_v = 2;
         var8 = true;
      }

      var9 = this.func_147737_a(p_147728_1_, p_147728_2_, p_147728_3_, p_147728_4_, 0, var9, 0.75F, 0.25F, 0.75F, var8, p_147728_6_, p_147728_5_);
      var9 = this.func_147737_a(p_147728_1_, p_147728_2_, p_147728_3_, p_147728_4_, 1, var9, 0.5F, 0.0625F, 0.625F, var8, p_147728_6_, p_147728_5_);
      var9 = this.func_147737_a(p_147728_1_, p_147728_2_, p_147728_3_, p_147728_4_, 2, var9, 0.25F, 0.3125F, 0.5F, var8, p_147728_6_, p_147728_5_);
      this.func_147737_a(p_147728_1_, p_147728_2_, p_147728_3_, p_147728_4_, 3, var9, 0.625F, 0.375F, 1.0F, var8, p_147728_6_, p_147728_5_);
      this.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
      this.field_147875_q = 0;
      this.field_147873_r = 0;
      this.field_147871_s = 0;
      this.field_147869_t = 0;
      this.field_147867_u = 0;
      this.field_147865_v = 0;
      return true;
   }

   private float func_147737_a(BlockAnvil p_147737_1_, int p_147737_2_, int p_147737_3_, int p_147737_4_, int p_147737_5_, float p_147737_6_, float p_147737_7_, float p_147737_8_, float p_147737_9_, boolean p_147737_10_, boolean p_147737_11_, int p_147737_12_) {
      if(p_147737_10_) {
         float var13 = p_147737_7_;
         p_147737_7_ = p_147737_9_;
         p_147737_9_ = var13;
      }

      p_147737_7_ /= 2.0F;
      p_147737_9_ /= 2.0F;
      p_147737_1_.field_149833_b = p_147737_5_;
      this.func_147782_a((double)(0.5F - p_147737_7_), (double)p_147737_6_, (double)(0.5F - p_147737_9_), (double)(0.5F + p_147737_7_), (double)(p_147737_6_ + p_147737_8_), (double)(0.5F + p_147737_9_));
      if(p_147737_11_) {
         Tessellator var14 = Tessellator.field_78398_a;
         var14.func_78382_b();
         var14.func_78375_b(0.0F, -1.0F, 0.0F);
         this.func_147768_a(p_147737_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147737_1_, 0, p_147737_12_));
         var14.func_78381_a();
         var14.func_78382_b();
         var14.func_78375_b(0.0F, 1.0F, 0.0F);
         this.func_147806_b(p_147737_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147737_1_, 1, p_147737_12_));
         var14.func_78381_a();
         var14.func_78382_b();
         var14.func_78375_b(0.0F, 0.0F, -1.0F);
         this.func_147761_c(p_147737_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147737_1_, 2, p_147737_12_));
         var14.func_78381_a();
         var14.func_78382_b();
         var14.func_78375_b(0.0F, 0.0F, 1.0F);
         this.func_147734_d(p_147737_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147737_1_, 3, p_147737_12_));
         var14.func_78381_a();
         var14.func_78382_b();
         var14.func_78375_b(-1.0F, 0.0F, 0.0F);
         this.func_147798_e(p_147737_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147737_1_, 4, p_147737_12_));
         var14.func_78381_a();
         var14.func_78382_b();
         var14.func_78375_b(1.0F, 0.0F, 0.0F);
         this.func_147764_f(p_147737_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147737_1_, 5, p_147737_12_));
         var14.func_78381_a();
      } else {
         this.func_147784_q(p_147737_1_, p_147737_2_, p_147737_3_, p_147737_4_);
      }

      return p_147737_6_ + p_147737_8_;
   }

   public boolean func_147791_c(Block p_147791_1_, int p_147791_2_, int p_147791_3_, int p_147791_4_) {
      int var5 = this.field_147845_a.func_72805_g(p_147791_2_, p_147791_3_, p_147791_4_);
      Tessellator var6 = Tessellator.field_78398_a;
      var6.func_78380_c(p_147791_1_.func_149677_c(this.field_147845_a, p_147791_2_, p_147791_3_, p_147791_4_));
      var6.func_78386_a(1.0F, 1.0F, 1.0F);
      double var7 = 0.4000000059604645D;
      double var9 = 0.5D - var7;
      double var11 = 0.20000000298023224D;
      if(var5 == 1) {
         this.func_147747_a(p_147791_1_, (double)p_147791_2_ - var9, (double)p_147791_3_ + var11, (double)p_147791_4_, -var7, 0.0D, 0);
      } else if(var5 == 2) {
         this.func_147747_a(p_147791_1_, (double)p_147791_2_ + var9, (double)p_147791_3_ + var11, (double)p_147791_4_, var7, 0.0D, 0);
      } else if(var5 == 3) {
         this.func_147747_a(p_147791_1_, (double)p_147791_2_, (double)p_147791_3_ + var11, (double)p_147791_4_ - var9, 0.0D, -var7, 0);
      } else if(var5 == 4) {
         this.func_147747_a(p_147791_1_, (double)p_147791_2_, (double)p_147791_3_ + var11, (double)p_147791_4_ + var9, 0.0D, var7, 0);
      } else {
         this.func_147747_a(p_147791_1_, (double)p_147791_2_, (double)p_147791_3_, (double)p_147791_4_, 0.0D, 0.0D, 0);
      }

      return true;
   }

   private boolean func_147759_a(BlockRedstoneRepeater p_147759_1_, int p_147759_2_, int p_147759_3_, int p_147759_4_) {
      int var5 = this.field_147845_a.func_72805_g(p_147759_2_, p_147759_3_, p_147759_4_);
      int var6 = var5 & 3;
      int var7 = (var5 & 12) >> 2;
      Tessellator var8 = Tessellator.field_78398_a;
      var8.func_78380_c(p_147759_1_.func_149677_c(this.field_147845_a, p_147759_2_, p_147759_3_, p_147759_4_));
      var8.func_78386_a(1.0F, 1.0F, 1.0F);
      double var9 = -0.1875D;
      boolean var11 = p_147759_1_.func_149910_g(this.field_147845_a, p_147759_2_, p_147759_3_, p_147759_4_, var5);
      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = 0.0D;
      double var18 = 0.0D;
      switch(var6) {
      case 0:
         var18 = -0.3125D;
         var14 = BlockRedstoneRepeater.field_149973_b[var7];
         break;
      case 1:
         var16 = 0.3125D;
         var12 = -BlockRedstoneRepeater.field_149973_b[var7];
         break;
      case 2:
         var18 = 0.3125D;
         var14 = -BlockRedstoneRepeater.field_149973_b[var7];
         break;
      case 3:
         var16 = -0.3125D;
         var12 = BlockRedstoneRepeater.field_149973_b[var7];
      }

      if(!var11) {
         this.func_147747_a(p_147759_1_, (double)p_147759_2_ + var12, (double)p_147759_3_ + var9, (double)p_147759_4_ + var14, 0.0D, 0.0D, 0);
      } else {
         IIcon var20 = this.func_147745_b(Blocks.field_150357_h);
         this.func_147757_a(var20);
         float var21 = 2.0F;
         float var22 = 14.0F;
         float var23 = 7.0F;
         float var24 = 9.0F;
         switch(var6) {
         case 1:
         case 3:
            var21 = 7.0F;
            var22 = 9.0F;
            var23 = 2.0F;
            var24 = 14.0F;
         case 0:
         case 2:
         default:
            this.func_147782_a((double)(var21 / 16.0F + (float)var12), 0.125D, (double)(var23 / 16.0F + (float)var14), (double)(var22 / 16.0F + (float)var12), 0.25D, (double)(var24 / 16.0F + (float)var14));
            double var25 = (double)var20.func_94214_a((double)var21);
            double var27 = (double)var20.func_94207_b((double)var23);
            double var29 = (double)var20.func_94214_a((double)var22);
            double var31 = (double)var20.func_94207_b((double)var24);
            var8.func_78374_a((double)((float)p_147759_2_ + var21 / 16.0F) + var12, (double)((float)p_147759_3_ + 0.25F), (double)((float)p_147759_4_ + var23 / 16.0F) + var14, var25, var27);
            var8.func_78374_a((double)((float)p_147759_2_ + var21 / 16.0F) + var12, (double)((float)p_147759_3_ + 0.25F), (double)((float)p_147759_4_ + var24 / 16.0F) + var14, var25, var31);
            var8.func_78374_a((double)((float)p_147759_2_ + var22 / 16.0F) + var12, (double)((float)p_147759_3_ + 0.25F), (double)((float)p_147759_4_ + var24 / 16.0F) + var14, var29, var31);
            var8.func_78374_a((double)((float)p_147759_2_ + var22 / 16.0F) + var12, (double)((float)p_147759_3_ + 0.25F), (double)((float)p_147759_4_ + var23 / 16.0F) + var14, var29, var27);
            this.func_147784_q(p_147759_1_, p_147759_2_, p_147759_3_, p_147759_4_);
            this.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D);
            this.func_147771_a();
         }
      }

      var8.func_78380_c(p_147759_1_.func_149677_c(this.field_147845_a, p_147759_2_, p_147759_3_, p_147759_4_));
      var8.func_78386_a(1.0F, 1.0F, 1.0F);
      this.func_147747_a(p_147759_1_, (double)p_147759_2_ + var16, (double)p_147759_3_ + var9, (double)p_147759_4_ + var18, 0.0D, 0.0D, 0);
      this.func_147748_a(p_147759_1_, p_147759_2_, p_147759_3_, p_147759_4_);
      return true;
   }

   private boolean func_147781_a(BlockRedstoneComparator p_147781_1_, int p_147781_2_, int p_147781_3_, int p_147781_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      var5.func_78380_c(p_147781_1_.func_149677_c(this.field_147845_a, p_147781_2_, p_147781_3_, p_147781_4_));
      var5.func_78386_a(1.0F, 1.0F, 1.0F);
      int var6 = this.field_147845_a.func_72805_g(p_147781_2_, p_147781_3_, p_147781_4_);
      int var7 = var6 & 3;
      double var8 = 0.0D;
      double var10 = -0.1875D;
      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = 0.0D;
      IIcon var18;
      if(p_147781_1_.func_149969_d(var6)) {
         var18 = Blocks.field_150429_aA.func_149733_h(0);
      } else {
         var10 -= 0.1875D;
         var18 = Blocks.field_150437_az.func_149733_h(0);
      }

      switch(var7) {
      case 0:
         var12 = -0.3125D;
         var16 = 1.0D;
         break;
      case 1:
         var8 = 0.3125D;
         var14 = -1.0D;
         break;
      case 2:
         var12 = 0.3125D;
         var16 = -1.0D;
         break;
      case 3:
         var8 = -0.3125D;
         var14 = 1.0D;
      }

      this.func_147747_a(p_147781_1_, (double)p_147781_2_ + 0.25D * var14 + 0.1875D * var16, (double)((float)p_147781_3_ - 0.1875F), (double)p_147781_4_ + 0.25D * var16 + 0.1875D * var14, 0.0D, 0.0D, var6);
      this.func_147747_a(p_147781_1_, (double)p_147781_2_ + 0.25D * var14 + -0.1875D * var16, (double)((float)p_147781_3_ - 0.1875F), (double)p_147781_4_ + 0.25D * var16 + -0.1875D * var14, 0.0D, 0.0D, var6);
      this.func_147757_a(var18);
      this.func_147747_a(p_147781_1_, (double)p_147781_2_ + var8, (double)p_147781_3_ + var10, (double)p_147781_4_ + var12, 0.0D, 0.0D, var6);
      this.func_147771_a();
      this.func_147732_a(p_147781_1_, p_147781_2_, p_147781_3_, p_147781_4_, var7);
      return true;
   }

   private boolean func_147748_a(BlockRedstoneDiode p_147748_1_, int p_147748_2_, int p_147748_3_, int p_147748_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      this.func_147732_a(p_147748_1_, p_147748_2_, p_147748_3_, p_147748_4_, this.field_147845_a.func_72805_g(p_147748_2_, p_147748_3_, p_147748_4_) & 3);
      return true;
   }

   private void func_147732_a(BlockRedstoneDiode p_147732_1_, int p_147732_2_, int p_147732_3_, int p_147732_4_, int p_147732_5_) {
      this.func_147784_q(p_147732_1_, p_147732_2_, p_147732_3_, p_147732_4_);
      Tessellator var6 = Tessellator.field_78398_a;
      var6.func_78380_c(p_147732_1_.func_149677_c(this.field_147845_a, p_147732_2_, p_147732_3_, p_147732_4_));
      var6.func_78386_a(1.0F, 1.0F, 1.0F);
      int var7 = this.field_147845_a.func_72805_g(p_147732_2_, p_147732_3_, p_147732_4_);
      IIcon var8 = this.func_147787_a(p_147732_1_, 1, var7);
      double var9 = (double)var8.func_94209_e();
      double var11 = (double)var8.func_94212_f();
      double var13 = (double)var8.func_94206_g();
      double var15 = (double)var8.func_94210_h();
      double var17 = 0.125D;
      double var19 = (double)(p_147732_2_ + 1);
      double var21 = (double)(p_147732_2_ + 1);
      double var23 = (double)(p_147732_2_ + 0);
      double var25 = (double)(p_147732_2_ + 0);
      double var27 = (double)(p_147732_4_ + 0);
      double var29 = (double)(p_147732_4_ + 1);
      double var31 = (double)(p_147732_4_ + 1);
      double var33 = (double)(p_147732_4_ + 0);
      double var35 = (double)p_147732_3_ + var17;
      if(p_147732_5_ == 2) {
         var19 = var21 = (double)(p_147732_2_ + 0);
         var23 = var25 = (double)(p_147732_2_ + 1);
         var27 = var33 = (double)(p_147732_4_ + 1);
         var29 = var31 = (double)(p_147732_4_ + 0);
      } else if(p_147732_5_ == 3) {
         var19 = var25 = (double)(p_147732_2_ + 0);
         var21 = var23 = (double)(p_147732_2_ + 1);
         var27 = var29 = (double)(p_147732_4_ + 0);
         var31 = var33 = (double)(p_147732_4_ + 1);
      } else if(p_147732_5_ == 1) {
         var19 = var25 = (double)(p_147732_2_ + 1);
         var21 = var23 = (double)(p_147732_2_ + 0);
         var27 = var29 = (double)(p_147732_4_ + 1);
         var31 = var33 = (double)(p_147732_4_ + 0);
      }

      var6.func_78374_a(var25, var35, var33, var9, var13);
      var6.func_78374_a(var23, var35, var31, var9, var15);
      var6.func_78374_a(var21, var35, var29, var11, var15);
      var6.func_78374_a(var19, var35, var27, var11, var13);
   }

   public void func_147804_d(Block p_147804_1_, int p_147804_2_, int p_147804_3_, int p_147804_4_) {
      this.field_147837_f = true;
      this.func_147731_b(p_147804_1_, p_147804_2_, p_147804_3_, p_147804_4_, true);
      this.field_147837_f = false;
   }

   private boolean func_147731_b(Block p_147731_1_, int p_147731_2_, int p_147731_3_, int p_147731_4_, boolean p_147731_5_) {
      int var6 = this.field_147845_a.func_72805_g(p_147731_2_, p_147731_3_, p_147731_4_);
      boolean var7 = p_147731_5_ || (var6 & 8) != 0;
      int var8 = BlockPistonBase.func_150076_b(var6);
      float var9 = 0.25F;
      if(var7) {
         switch(var8) {
         case 0:
            this.field_147875_q = 3;
            this.field_147873_r = 3;
            this.field_147871_s = 3;
            this.field_147869_t = 3;
            this.func_147782_a(0.0D, 0.25D, 0.0D, 1.0D, 1.0D, 1.0D);
            break;
         case 1:
            this.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D);
            break;
         case 2:
            this.field_147871_s = 1;
            this.field_147869_t = 2;
            this.func_147782_a(0.0D, 0.0D, 0.25D, 1.0D, 1.0D, 1.0D);
            break;
         case 3:
            this.field_147871_s = 2;
            this.field_147869_t = 1;
            this.field_147867_u = 3;
            this.field_147865_v = 3;
            this.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.75D);
            break;
         case 4:
            this.field_147875_q = 1;
            this.field_147873_r = 2;
            this.field_147867_u = 2;
            this.field_147865_v = 1;
            this.func_147782_a(0.25D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
            break;
         case 5:
            this.field_147875_q = 2;
            this.field_147873_r = 1;
            this.field_147867_u = 1;
            this.field_147865_v = 2;
            this.func_147782_a(0.0D, 0.0D, 0.0D, 0.75D, 1.0D, 1.0D);
         }

         ((BlockPistonBase)p_147731_1_).func_150070_b((float)this.field_147859_h, (float)this.field_147855_j, (float)this.field_147851_l, (float)this.field_147861_i, (float)this.field_147857_k, (float)this.field_147853_m);
         this.func_147784_q(p_147731_1_, p_147731_2_, p_147731_3_, p_147731_4_);
         this.field_147875_q = 0;
         this.field_147873_r = 0;
         this.field_147871_s = 0;
         this.field_147869_t = 0;
         this.field_147867_u = 0;
         this.field_147865_v = 0;
         this.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
         ((BlockPistonBase)p_147731_1_).func_150070_b((float)this.field_147859_h, (float)this.field_147855_j, (float)this.field_147851_l, (float)this.field_147861_i, (float)this.field_147857_k, (float)this.field_147853_m);
      } else {
         switch(var8) {
         case 0:
            this.field_147875_q = 3;
            this.field_147873_r = 3;
            this.field_147871_s = 3;
            this.field_147869_t = 3;
         case 1:
         default:
            break;
         case 2:
            this.field_147871_s = 1;
            this.field_147869_t = 2;
            break;
         case 3:
            this.field_147871_s = 2;
            this.field_147869_t = 1;
            this.field_147867_u = 3;
            this.field_147865_v = 3;
            break;
         case 4:
            this.field_147875_q = 1;
            this.field_147873_r = 2;
            this.field_147867_u = 2;
            this.field_147865_v = 1;
            break;
         case 5:
            this.field_147875_q = 2;
            this.field_147873_r = 1;
            this.field_147867_u = 1;
            this.field_147865_v = 2;
         }

         this.func_147784_q(p_147731_1_, p_147731_2_, p_147731_3_, p_147731_4_);
         this.field_147875_q = 0;
         this.field_147873_r = 0;
         this.field_147871_s = 0;
         this.field_147869_t = 0;
         this.field_147867_u = 0;
         this.field_147865_v = 0;
      }

      return true;
   }

   private void func_147763_a(double p_147763_1_, double p_147763_3_, double p_147763_5_, double p_147763_7_, double p_147763_9_, double p_147763_11_, float p_147763_13_, double p_147763_14_) {
      IIcon var16 = BlockPistonBase.func_150074_e("piston_side");
      if(this.func_147744_b()) {
         var16 = this.field_147840_d;
      }

      Tessellator var17 = Tessellator.field_78398_a;
      double var18 = (double)var16.func_94209_e();
      double var20 = (double)var16.func_94206_g();
      double var22 = (double)var16.func_94214_a(p_147763_14_);
      double var24 = (double)var16.func_94207_b(4.0D);
      var17.func_78386_a(p_147763_13_, p_147763_13_, p_147763_13_);
      var17.func_78374_a(p_147763_1_, p_147763_7_, p_147763_9_, var22, var20);
      var17.func_78374_a(p_147763_1_, p_147763_5_, p_147763_9_, var18, var20);
      var17.func_78374_a(p_147763_3_, p_147763_5_, p_147763_11_, var18, var24);
      var17.func_78374_a(p_147763_3_, p_147763_7_, p_147763_11_, var22, var24);
   }

   private void func_147789_b(double p_147789_1_, double p_147789_3_, double p_147789_5_, double p_147789_7_, double p_147789_9_, double p_147789_11_, float p_147789_13_, double p_147789_14_) {
      IIcon var16 = BlockPistonBase.func_150074_e("piston_side");
      if(this.func_147744_b()) {
         var16 = this.field_147840_d;
      }

      Tessellator var17 = Tessellator.field_78398_a;
      double var18 = (double)var16.func_94209_e();
      double var20 = (double)var16.func_94206_g();
      double var22 = (double)var16.func_94214_a(p_147789_14_);
      double var24 = (double)var16.func_94207_b(4.0D);
      var17.func_78386_a(p_147789_13_, p_147789_13_, p_147789_13_);
      var17.func_78374_a(p_147789_1_, p_147789_5_, p_147789_11_, var22, var20);
      var17.func_78374_a(p_147789_1_, p_147789_5_, p_147789_9_, var18, var20);
      var17.func_78374_a(p_147789_3_, p_147789_7_, p_147789_9_, var18, var24);
      var17.func_78374_a(p_147789_3_, p_147789_7_, p_147789_11_, var22, var24);
   }

   private void func_147738_c(double p_147738_1_, double p_147738_3_, double p_147738_5_, double p_147738_7_, double p_147738_9_, double p_147738_11_, float p_147738_13_, double p_147738_14_) {
      IIcon var16 = BlockPistonBase.func_150074_e("piston_side");
      if(this.func_147744_b()) {
         var16 = this.field_147840_d;
      }

      Tessellator var17 = Tessellator.field_78398_a;
      double var18 = (double)var16.func_94209_e();
      double var20 = (double)var16.func_94206_g();
      double var22 = (double)var16.func_94214_a(p_147738_14_);
      double var24 = (double)var16.func_94207_b(4.0D);
      var17.func_78386_a(p_147738_13_, p_147738_13_, p_147738_13_);
      var17.func_78374_a(p_147738_3_, p_147738_5_, p_147738_9_, var22, var20);
      var17.func_78374_a(p_147738_1_, p_147738_5_, p_147738_9_, var18, var20);
      var17.func_78374_a(p_147738_1_, p_147738_7_, p_147738_11_, var18, var24);
      var17.func_78374_a(p_147738_3_, p_147738_7_, p_147738_11_, var22, var24);
   }

   public void func_147750_a(Block p_147750_1_, int p_147750_2_, int p_147750_3_, int p_147750_4_, boolean p_147750_5_) {
      this.field_147837_f = true;
      this.func_147809_c(p_147750_1_, p_147750_2_, p_147750_3_, p_147750_4_, p_147750_5_);
      this.field_147837_f = false;
   }

   private boolean func_147809_c(Block p_147809_1_, int p_147809_2_, int p_147809_3_, int p_147809_4_, boolean p_147809_5_) {
      int var6 = this.field_147845_a.func_72805_g(p_147809_2_, p_147809_3_, p_147809_4_);
      int var7 = BlockPistonExtension.func_150085_b(var6);
      float var8 = 0.25F;
      float var9 = 0.375F;
      float var10 = 0.625F;
      float var11 = p_147809_5_?1.0F:0.5F;
      double var12 = p_147809_5_?16.0D:8.0D;
      switch(var7) {
      case 0:
         this.field_147875_q = 3;
         this.field_147873_r = 3;
         this.field_147871_s = 3;
         this.field_147869_t = 3;
         this.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D);
         this.func_147784_q(p_147809_1_, p_147809_2_, p_147809_3_, p_147809_4_);
         this.func_147763_a((double)((float)p_147809_2_ + 0.375F), (double)((float)p_147809_2_ + 0.625F), (double)((float)p_147809_3_ + 0.25F), (double)((float)p_147809_3_ + 0.25F + var11), (double)((float)p_147809_4_ + 0.625F), (double)((float)p_147809_4_ + 0.625F), 0.8F, var12);
         this.func_147763_a((double)((float)p_147809_2_ + 0.625F), (double)((float)p_147809_2_ + 0.375F), (double)((float)p_147809_3_ + 0.25F), (double)((float)p_147809_3_ + 0.25F + var11), (double)((float)p_147809_4_ + 0.375F), (double)((float)p_147809_4_ + 0.375F), 0.8F, var12);
         this.func_147763_a((double)((float)p_147809_2_ + 0.375F), (double)((float)p_147809_2_ + 0.375F), (double)((float)p_147809_3_ + 0.25F), (double)((float)p_147809_3_ + 0.25F + var11), (double)((float)p_147809_4_ + 0.375F), (double)((float)p_147809_4_ + 0.625F), 0.6F, var12);
         this.func_147763_a((double)((float)p_147809_2_ + 0.625F), (double)((float)p_147809_2_ + 0.625F), (double)((float)p_147809_3_ + 0.25F), (double)((float)p_147809_3_ + 0.25F + var11), (double)((float)p_147809_4_ + 0.625F), (double)((float)p_147809_4_ + 0.375F), 0.6F, var12);
         break;
      case 1:
         this.func_147782_a(0.0D, 0.75D, 0.0D, 1.0D, 1.0D, 1.0D);
         this.func_147784_q(p_147809_1_, p_147809_2_, p_147809_3_, p_147809_4_);
         this.func_147763_a((double)((float)p_147809_2_ + 0.375F), (double)((float)p_147809_2_ + 0.625F), (double)((float)p_147809_3_ - 0.25F + 1.0F - var11), (double)((float)p_147809_3_ - 0.25F + 1.0F), (double)((float)p_147809_4_ + 0.625F), (double)((float)p_147809_4_ + 0.625F), 0.8F, var12);
         this.func_147763_a((double)((float)p_147809_2_ + 0.625F), (double)((float)p_147809_2_ + 0.375F), (double)((float)p_147809_3_ - 0.25F + 1.0F - var11), (double)((float)p_147809_3_ - 0.25F + 1.0F), (double)((float)p_147809_4_ + 0.375F), (double)((float)p_147809_4_ + 0.375F), 0.8F, var12);
         this.func_147763_a((double)((float)p_147809_2_ + 0.375F), (double)((float)p_147809_2_ + 0.375F), (double)((float)p_147809_3_ - 0.25F + 1.0F - var11), (double)((float)p_147809_3_ - 0.25F + 1.0F), (double)((float)p_147809_4_ + 0.375F), (double)((float)p_147809_4_ + 0.625F), 0.6F, var12);
         this.func_147763_a((double)((float)p_147809_2_ + 0.625F), (double)((float)p_147809_2_ + 0.625F), (double)((float)p_147809_3_ - 0.25F + 1.0F - var11), (double)((float)p_147809_3_ - 0.25F + 1.0F), (double)((float)p_147809_4_ + 0.625F), (double)((float)p_147809_4_ + 0.375F), 0.6F, var12);
         break;
      case 2:
         this.field_147871_s = 1;
         this.field_147869_t = 2;
         this.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.25D);
         this.func_147784_q(p_147809_1_, p_147809_2_, p_147809_3_, p_147809_4_);
         this.func_147789_b((double)((float)p_147809_2_ + 0.375F), (double)((float)p_147809_2_ + 0.375F), (double)((float)p_147809_3_ + 0.625F), (double)((float)p_147809_3_ + 0.375F), (double)((float)p_147809_4_ + 0.25F), (double)((float)p_147809_4_ + 0.25F + var11), 0.6F, var12);
         this.func_147789_b((double)((float)p_147809_2_ + 0.625F), (double)((float)p_147809_2_ + 0.625F), (double)((float)p_147809_3_ + 0.375F), (double)((float)p_147809_3_ + 0.625F), (double)((float)p_147809_4_ + 0.25F), (double)((float)p_147809_4_ + 0.25F + var11), 0.6F, var12);
         this.func_147789_b((double)((float)p_147809_2_ + 0.375F), (double)((float)p_147809_2_ + 0.625F), (double)((float)p_147809_3_ + 0.375F), (double)((float)p_147809_3_ + 0.375F), (double)((float)p_147809_4_ + 0.25F), (double)((float)p_147809_4_ + 0.25F + var11), 0.5F, var12);
         this.func_147789_b((double)((float)p_147809_2_ + 0.625F), (double)((float)p_147809_2_ + 0.375F), (double)((float)p_147809_3_ + 0.625F), (double)((float)p_147809_3_ + 0.625F), (double)((float)p_147809_4_ + 0.25F), (double)((float)p_147809_4_ + 0.25F + var11), 1.0F, var12);
         break;
      case 3:
         this.field_147871_s = 2;
         this.field_147869_t = 1;
         this.field_147867_u = 3;
         this.field_147865_v = 3;
         this.func_147782_a(0.0D, 0.0D, 0.75D, 1.0D, 1.0D, 1.0D);
         this.func_147784_q(p_147809_1_, p_147809_2_, p_147809_3_, p_147809_4_);
         this.func_147789_b((double)((float)p_147809_2_ + 0.375F), (double)((float)p_147809_2_ + 0.375F), (double)((float)p_147809_3_ + 0.625F), (double)((float)p_147809_3_ + 0.375F), (double)((float)p_147809_4_ - 0.25F + 1.0F - var11), (double)((float)p_147809_4_ - 0.25F + 1.0F), 0.6F, var12);
         this.func_147789_b((double)((float)p_147809_2_ + 0.625F), (double)((float)p_147809_2_ + 0.625F), (double)((float)p_147809_3_ + 0.375F), (double)((float)p_147809_3_ + 0.625F), (double)((float)p_147809_4_ - 0.25F + 1.0F - var11), (double)((float)p_147809_4_ - 0.25F + 1.0F), 0.6F, var12);
         this.func_147789_b((double)((float)p_147809_2_ + 0.375F), (double)((float)p_147809_2_ + 0.625F), (double)((float)p_147809_3_ + 0.375F), (double)((float)p_147809_3_ + 0.375F), (double)((float)p_147809_4_ - 0.25F + 1.0F - var11), (double)((float)p_147809_4_ - 0.25F + 1.0F), 0.5F, var12);
         this.func_147789_b((double)((float)p_147809_2_ + 0.625F), (double)((float)p_147809_2_ + 0.375F), (double)((float)p_147809_3_ + 0.625F), (double)((float)p_147809_3_ + 0.625F), (double)((float)p_147809_4_ - 0.25F + 1.0F - var11), (double)((float)p_147809_4_ - 0.25F + 1.0F), 1.0F, var12);
         break;
      case 4:
         this.field_147875_q = 1;
         this.field_147873_r = 2;
         this.field_147867_u = 2;
         this.field_147865_v = 1;
         this.func_147782_a(0.0D, 0.0D, 0.0D, 0.25D, 1.0D, 1.0D);
         this.func_147784_q(p_147809_1_, p_147809_2_, p_147809_3_, p_147809_4_);
         this.func_147738_c((double)((float)p_147809_2_ + 0.25F), (double)((float)p_147809_2_ + 0.25F + var11), (double)((float)p_147809_3_ + 0.375F), (double)((float)p_147809_3_ + 0.375F), (double)((float)p_147809_4_ + 0.625F), (double)((float)p_147809_4_ + 0.375F), 0.5F, var12);
         this.func_147738_c((double)((float)p_147809_2_ + 0.25F), (double)((float)p_147809_2_ + 0.25F + var11), (double)((float)p_147809_3_ + 0.625F), (double)((float)p_147809_3_ + 0.625F), (double)((float)p_147809_4_ + 0.375F), (double)((float)p_147809_4_ + 0.625F), 1.0F, var12);
         this.func_147738_c((double)((float)p_147809_2_ + 0.25F), (double)((float)p_147809_2_ + 0.25F + var11), (double)((float)p_147809_3_ + 0.375F), (double)((float)p_147809_3_ + 0.625F), (double)((float)p_147809_4_ + 0.375F), (double)((float)p_147809_4_ + 0.375F), 0.6F, var12);
         this.func_147738_c((double)((float)p_147809_2_ + 0.25F), (double)((float)p_147809_2_ + 0.25F + var11), (double)((float)p_147809_3_ + 0.625F), (double)((float)p_147809_3_ + 0.375F), (double)((float)p_147809_4_ + 0.625F), (double)((float)p_147809_4_ + 0.625F), 0.6F, var12);
         break;
      case 5:
         this.field_147875_q = 2;
         this.field_147873_r = 1;
         this.field_147867_u = 1;
         this.field_147865_v = 2;
         this.func_147782_a(0.75D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
         this.func_147784_q(p_147809_1_, p_147809_2_, p_147809_3_, p_147809_4_);
         this.func_147738_c((double)((float)p_147809_2_ - 0.25F + 1.0F - var11), (double)((float)p_147809_2_ - 0.25F + 1.0F), (double)((float)p_147809_3_ + 0.375F), (double)((float)p_147809_3_ + 0.375F), (double)((float)p_147809_4_ + 0.625F), (double)((float)p_147809_4_ + 0.375F), 0.5F, var12);
         this.func_147738_c((double)((float)p_147809_2_ - 0.25F + 1.0F - var11), (double)((float)p_147809_2_ - 0.25F + 1.0F), (double)((float)p_147809_3_ + 0.625F), (double)((float)p_147809_3_ + 0.625F), (double)((float)p_147809_4_ + 0.375F), (double)((float)p_147809_4_ + 0.625F), 1.0F, var12);
         this.func_147738_c((double)((float)p_147809_2_ - 0.25F + 1.0F - var11), (double)((float)p_147809_2_ - 0.25F + 1.0F), (double)((float)p_147809_3_ + 0.375F), (double)((float)p_147809_3_ + 0.625F), (double)((float)p_147809_4_ + 0.375F), (double)((float)p_147809_4_ + 0.375F), 0.6F, var12);
         this.func_147738_c((double)((float)p_147809_2_ - 0.25F + 1.0F - var11), (double)((float)p_147809_2_ - 0.25F + 1.0F), (double)((float)p_147809_3_ + 0.625F), (double)((float)p_147809_3_ + 0.375F), (double)((float)p_147809_4_ + 0.625F), (double)((float)p_147809_4_ + 0.625F), 0.6F, var12);
      }

      this.field_147875_q = 0;
      this.field_147873_r = 0;
      this.field_147871_s = 0;
      this.field_147869_t = 0;
      this.field_147867_u = 0;
      this.field_147865_v = 0;
      this.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
      return true;
   }

   public boolean func_147790_e(Block p_147790_1_, int p_147790_2_, int p_147790_3_, int p_147790_4_) {
      int var5 = this.field_147845_a.func_72805_g(p_147790_2_, p_147790_3_, p_147790_4_);
      int var6 = var5 & 7;
      boolean var7 = (var5 & 8) > 0;
      Tessellator var8 = Tessellator.field_78398_a;
      boolean var9 = this.func_147744_b();
      if(!var9) {
         this.func_147757_a(this.func_147745_b(Blocks.field_150347_e));
      }

      float var10 = 0.25F;
      float var11 = 0.1875F;
      float var12 = 0.1875F;
      if(var6 == 5) {
         this.func_147782_a((double)(0.5F - var11), 0.0D, (double)(0.5F - var10), (double)(0.5F + var11), (double)var12, (double)(0.5F + var10));
      } else if(var6 == 6) {
         this.func_147782_a((double)(0.5F - var10), 0.0D, (double)(0.5F - var11), (double)(0.5F + var10), (double)var12, (double)(0.5F + var11));
      } else if(var6 == 4) {
         this.func_147782_a((double)(0.5F - var11), (double)(0.5F - var10), (double)(1.0F - var12), (double)(0.5F + var11), (double)(0.5F + var10), 1.0D);
      } else if(var6 == 3) {
         this.func_147782_a((double)(0.5F - var11), (double)(0.5F - var10), 0.0D, (double)(0.5F + var11), (double)(0.5F + var10), (double)var12);
      } else if(var6 == 2) {
         this.func_147782_a((double)(1.0F - var12), (double)(0.5F - var10), (double)(0.5F - var11), 1.0D, (double)(0.5F + var10), (double)(0.5F + var11));
      } else if(var6 == 1) {
         this.func_147782_a(0.0D, (double)(0.5F - var10), (double)(0.5F - var11), (double)var12, (double)(0.5F + var10), (double)(0.5F + var11));
      } else if(var6 == 0) {
         this.func_147782_a((double)(0.5F - var10), (double)(1.0F - var12), (double)(0.5F - var11), (double)(0.5F + var10), 1.0D, (double)(0.5F + var11));
      } else if(var6 == 7) {
         this.func_147782_a((double)(0.5F - var11), (double)(1.0F - var12), (double)(0.5F - var10), (double)(0.5F + var11), 1.0D, (double)(0.5F + var10));
      }

      this.func_147784_q(p_147790_1_, p_147790_2_, p_147790_3_, p_147790_4_);
      if(!var9) {
         this.func_147771_a();
      }

      var8.func_78380_c(p_147790_1_.func_149677_c(this.field_147845_a, p_147790_2_, p_147790_3_, p_147790_4_));
      var8.func_78386_a(1.0F, 1.0F, 1.0F);
      IIcon var13 = this.func_147777_a(p_147790_1_, 0);
      if(this.func_147744_b()) {
         var13 = this.field_147840_d;
      }

      double var14 = (double)var13.func_94209_e();
      double var16 = (double)var13.func_94206_g();
      double var18 = (double)var13.func_94212_f();
      double var20 = (double)var13.func_94210_h();
      Vec3[] var22 = new Vec3[8];
      float var23 = 0.0625F;
      float var24 = 0.0625F;
      float var25 = 0.625F;
      var22[0] = Vec3.func_72443_a((double)(-var23), 0.0D, (double)(-var24));
      var22[1] = Vec3.func_72443_a((double)var23, 0.0D, (double)(-var24));
      var22[2] = Vec3.func_72443_a((double)var23, 0.0D, (double)var24);
      var22[3] = Vec3.func_72443_a((double)(-var23), 0.0D, (double)var24);
      var22[4] = Vec3.func_72443_a((double)(-var23), (double)var25, (double)(-var24));
      var22[5] = Vec3.func_72443_a((double)var23, (double)var25, (double)(-var24));
      var22[6] = Vec3.func_72443_a((double)var23, (double)var25, (double)var24);
      var22[7] = Vec3.func_72443_a((double)(-var23), (double)var25, (double)var24);

      for(int var26 = 0; var26 < 8; ++var26) {
         if(var7) {
            var22[var26].field_72449_c -= 0.0625D;
            var22[var26].func_72440_a(0.69813174F);
         } else {
            var22[var26].field_72449_c += 0.0625D;
            var22[var26].func_72440_a(-0.69813174F);
         }

         if(var6 == 0 || var6 == 7) {
            var22[var26].func_72446_c(3.1415927F);
         }

         if(var6 == 6 || var6 == 0) {
            var22[var26].func_72442_b(1.5707964F);
         }

         if(var6 > 0 && var6 < 5) {
            var22[var26].field_72448_b -= 0.375D;
            var22[var26].func_72440_a(1.5707964F);
            if(var6 == 4) {
               var22[var26].func_72442_b(0.0F);
            }

            if(var6 == 3) {
               var22[var26].func_72442_b(3.1415927F);
            }

            if(var6 == 2) {
               var22[var26].func_72442_b(1.5707964F);
            }

            if(var6 == 1) {
               var22[var26].func_72442_b(-1.5707964F);
            }

            var22[var26].field_72450_a += (double)p_147790_2_ + 0.5D;
            var22[var26].field_72448_b += (double)((float)p_147790_3_ + 0.5F);
            var22[var26].field_72449_c += (double)p_147790_4_ + 0.5D;
         } else if(var6 != 0 && var6 != 7) {
            var22[var26].field_72450_a += (double)p_147790_2_ + 0.5D;
            var22[var26].field_72448_b += (double)((float)p_147790_3_ + 0.125F);
            var22[var26].field_72449_c += (double)p_147790_4_ + 0.5D;
         } else {
            var22[var26].field_72450_a += (double)p_147790_2_ + 0.5D;
            var22[var26].field_72448_b += (double)((float)p_147790_3_ + 0.875F);
            var22[var26].field_72449_c += (double)p_147790_4_ + 0.5D;
         }
      }

      Vec3 var31 = null;
      Vec3 var27 = null;
      Vec3 var28 = null;
      Vec3 var29 = null;

      for(int var30 = 0; var30 < 6; ++var30) {
         if(var30 == 0) {
            var14 = (double)var13.func_94214_a(7.0D);
            var16 = (double)var13.func_94207_b(6.0D);
            var18 = (double)var13.func_94214_a(9.0D);
            var20 = (double)var13.func_94207_b(8.0D);
         } else if(var30 == 2) {
            var14 = (double)var13.func_94214_a(7.0D);
            var16 = (double)var13.func_94207_b(6.0D);
            var18 = (double)var13.func_94214_a(9.0D);
            var20 = (double)var13.func_94210_h();
         }

         if(var30 == 0) {
            var31 = var22[0];
            var27 = var22[1];
            var28 = var22[2];
            var29 = var22[3];
         } else if(var30 == 1) {
            var31 = var22[7];
            var27 = var22[6];
            var28 = var22[5];
            var29 = var22[4];
         } else if(var30 == 2) {
            var31 = var22[1];
            var27 = var22[0];
            var28 = var22[4];
            var29 = var22[5];
         } else if(var30 == 3) {
            var31 = var22[2];
            var27 = var22[1];
            var28 = var22[5];
            var29 = var22[6];
         } else if(var30 == 4) {
            var31 = var22[3];
            var27 = var22[2];
            var28 = var22[6];
            var29 = var22[7];
         } else if(var30 == 5) {
            var31 = var22[0];
            var27 = var22[3];
            var28 = var22[7];
            var29 = var22[4];
         }

         var8.func_78374_a(var31.field_72450_a, var31.field_72448_b, var31.field_72449_c, var14, var20);
         var8.func_78374_a(var27.field_72450_a, var27.field_72448_b, var27.field_72449_c, var18, var20);
         var8.func_78374_a(var28.field_72450_a, var28.field_72448_b, var28.field_72449_c, var18, var16);
         var8.func_78374_a(var29.field_72450_a, var29.field_72448_b, var29.field_72449_c, var14, var16);
      }

      return true;
   }

   public boolean func_147723_f(Block p_147723_1_, int p_147723_2_, int p_147723_3_, int p_147723_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      int var6 = this.field_147845_a.func_72805_g(p_147723_2_, p_147723_3_, p_147723_4_);
      int var7 = var6 & 3;
      boolean var8 = (var6 & 4) == 4;
      boolean var9 = (var6 & 8) == 8;
      boolean var10 = !World.func_147466_a(this.field_147845_a, p_147723_2_, p_147723_3_ - 1, p_147723_4_);
      boolean var11 = this.func_147744_b();
      if(!var11) {
         this.func_147757_a(this.func_147745_b(Blocks.field_150344_f));
      }

      float var12 = 0.25F;
      float var13 = 0.125F;
      float var14 = 0.125F;
      float var15 = 0.3F - var12;
      float var16 = 0.3F + var12;
      if(var7 == 2) {
         this.func_147782_a((double)(0.5F - var13), (double)var15, (double)(1.0F - var14), (double)(0.5F + var13), (double)var16, 1.0D);
      } else if(var7 == 0) {
         this.func_147782_a((double)(0.5F - var13), (double)var15, 0.0D, (double)(0.5F + var13), (double)var16, (double)var14);
      } else if(var7 == 1) {
         this.func_147782_a((double)(1.0F - var14), (double)var15, (double)(0.5F - var13), 1.0D, (double)var16, (double)(0.5F + var13));
      } else if(var7 == 3) {
         this.func_147782_a(0.0D, (double)var15, (double)(0.5F - var13), (double)var14, (double)var16, (double)(0.5F + var13));
      }

      this.func_147784_q(p_147723_1_, p_147723_2_, p_147723_3_, p_147723_4_);
      if(!var11) {
         this.func_147771_a();
      }

      var5.func_78380_c(p_147723_1_.func_149677_c(this.field_147845_a, p_147723_2_, p_147723_3_, p_147723_4_));
      var5.func_78386_a(1.0F, 1.0F, 1.0F);
      IIcon var17 = this.func_147777_a(p_147723_1_, 0);
      if(this.func_147744_b()) {
         var17 = this.field_147840_d;
      }

      double var18 = (double)var17.func_94209_e();
      double var20 = (double)var17.func_94206_g();
      double var22 = (double)var17.func_94212_f();
      double var24 = (double)var17.func_94210_h();
      Vec3[] var26 = new Vec3[8];
      float var27 = 0.046875F;
      float var28 = 0.046875F;
      float var29 = 0.3125F;
      var26[0] = Vec3.func_72443_a((double)(-var27), 0.0D, (double)(-var28));
      var26[1] = Vec3.func_72443_a((double)var27, 0.0D, (double)(-var28));
      var26[2] = Vec3.func_72443_a((double)var27, 0.0D, (double)var28);
      var26[3] = Vec3.func_72443_a((double)(-var27), 0.0D, (double)var28);
      var26[4] = Vec3.func_72443_a((double)(-var27), (double)var29, (double)(-var28));
      var26[5] = Vec3.func_72443_a((double)var27, (double)var29, (double)(-var28));
      var26[6] = Vec3.func_72443_a((double)var27, (double)var29, (double)var28);
      var26[7] = Vec3.func_72443_a((double)(-var27), (double)var29, (double)var28);

      for(int var30 = 0; var30 < 8; ++var30) {
         var26[var30].field_72449_c += 0.0625D;
         if(var9) {
            var26[var30].func_72440_a(0.5235988F);
            var26[var30].field_72448_b -= 0.4375D;
         } else if(var8) {
            var26[var30].func_72440_a(0.08726647F);
            var26[var30].field_72448_b -= 0.4375D;
         } else {
            var26[var30].func_72440_a(-0.69813174F);
            var26[var30].field_72448_b -= 0.375D;
         }

         var26[var30].func_72440_a(1.5707964F);
         if(var7 == 2) {
            var26[var30].func_72442_b(0.0F);
         }

         if(var7 == 0) {
            var26[var30].func_72442_b(3.1415927F);
         }

         if(var7 == 1) {
            var26[var30].func_72442_b(1.5707964F);
         }

         if(var7 == 3) {
            var26[var30].func_72442_b(-1.5707964F);
         }

         var26[var30].field_72450_a += (double)p_147723_2_ + 0.5D;
         var26[var30].field_72448_b += (double)((float)p_147723_3_ + 0.3125F);
         var26[var30].field_72449_c += (double)p_147723_4_ + 0.5D;
      }

      Vec3 var60 = null;
      Vec3 var31 = null;
      Vec3 var32 = null;
      Vec3 var33 = null;
      byte var34 = 7;
      byte var35 = 9;
      byte var36 = 9;
      byte var37 = 16;

      for(int var38 = 0; var38 < 6; ++var38) {
         if(var38 == 0) {
            var60 = var26[0];
            var31 = var26[1];
            var32 = var26[2];
            var33 = var26[3];
            var18 = (double)var17.func_94214_a((double)var34);
            var20 = (double)var17.func_94207_b((double)var36);
            var22 = (double)var17.func_94214_a((double)var35);
            var24 = (double)var17.func_94207_b((double)(var36 + 2));
         } else if(var38 == 1) {
            var60 = var26[7];
            var31 = var26[6];
            var32 = var26[5];
            var33 = var26[4];
         } else if(var38 == 2) {
            var60 = var26[1];
            var31 = var26[0];
            var32 = var26[4];
            var33 = var26[5];
            var18 = (double)var17.func_94214_a((double)var34);
            var20 = (double)var17.func_94207_b((double)var36);
            var22 = (double)var17.func_94214_a((double)var35);
            var24 = (double)var17.func_94207_b((double)var37);
         } else if(var38 == 3) {
            var60 = var26[2];
            var31 = var26[1];
            var32 = var26[5];
            var33 = var26[6];
         } else if(var38 == 4) {
            var60 = var26[3];
            var31 = var26[2];
            var32 = var26[6];
            var33 = var26[7];
         } else if(var38 == 5) {
            var60 = var26[0];
            var31 = var26[3];
            var32 = var26[7];
            var33 = var26[4];
         }

         var5.func_78374_a(var60.field_72450_a, var60.field_72448_b, var60.field_72449_c, var18, var24);
         var5.func_78374_a(var31.field_72450_a, var31.field_72448_b, var31.field_72449_c, var22, var24);
         var5.func_78374_a(var32.field_72450_a, var32.field_72448_b, var32.field_72449_c, var22, var20);
         var5.func_78374_a(var33.field_72450_a, var33.field_72448_b, var33.field_72449_c, var18, var20);
      }

      float var61 = 0.09375F;
      float var39 = 0.09375F;
      float var40 = 0.03125F;
      var26[0] = Vec3.func_72443_a((double)(-var61), 0.0D, (double)(-var39));
      var26[1] = Vec3.func_72443_a((double)var61, 0.0D, (double)(-var39));
      var26[2] = Vec3.func_72443_a((double)var61, 0.0D, (double)var39);
      var26[3] = Vec3.func_72443_a((double)(-var61), 0.0D, (double)var39);
      var26[4] = Vec3.func_72443_a((double)(-var61), (double)var40, (double)(-var39));
      var26[5] = Vec3.func_72443_a((double)var61, (double)var40, (double)(-var39));
      var26[6] = Vec3.func_72443_a((double)var61, (double)var40, (double)var39);
      var26[7] = Vec3.func_72443_a((double)(-var61), (double)var40, (double)var39);

      for(int var41 = 0; var41 < 8; ++var41) {
         var26[var41].field_72449_c += 0.21875D;
         if(var9) {
            var26[var41].field_72448_b -= 0.09375D;
            var26[var41].field_72449_c -= 0.1625D;
            var26[var41].func_72440_a(0.0F);
         } else if(var8) {
            var26[var41].field_72448_b += 0.015625D;
            var26[var41].field_72449_c -= 0.171875D;
            var26[var41].func_72440_a(0.17453294F);
         } else {
            var26[var41].func_72440_a(0.87266463F);
         }

         if(var7 == 2) {
            var26[var41].func_72442_b(0.0F);
         }

         if(var7 == 0) {
            var26[var41].func_72442_b(3.1415927F);
         }

         if(var7 == 1) {
            var26[var41].func_72442_b(1.5707964F);
         }

         if(var7 == 3) {
            var26[var41].func_72442_b(-1.5707964F);
         }

         var26[var41].field_72450_a += (double)p_147723_2_ + 0.5D;
         var26[var41].field_72448_b += (double)((float)p_147723_3_ + 0.3125F);
         var26[var41].field_72449_c += (double)p_147723_4_ + 0.5D;
      }

      byte var62 = 5;
      byte var42 = 11;
      byte var43 = 3;
      byte var44 = 9;

      for(int var45 = 0; var45 < 6; ++var45) {
         if(var45 == 0) {
            var60 = var26[0];
            var31 = var26[1];
            var32 = var26[2];
            var33 = var26[3];
            var18 = (double)var17.func_94214_a((double)var62);
            var20 = (double)var17.func_94207_b((double)var43);
            var22 = (double)var17.func_94214_a((double)var42);
            var24 = (double)var17.func_94207_b((double)var44);
         } else if(var45 == 1) {
            var60 = var26[7];
            var31 = var26[6];
            var32 = var26[5];
            var33 = var26[4];
         } else if(var45 == 2) {
            var60 = var26[1];
            var31 = var26[0];
            var32 = var26[4];
            var33 = var26[5];
            var18 = (double)var17.func_94214_a((double)var62);
            var20 = (double)var17.func_94207_b((double)var43);
            var22 = (double)var17.func_94214_a((double)var42);
            var24 = (double)var17.func_94207_b((double)(var43 + 2));
         } else if(var45 == 3) {
            var60 = var26[2];
            var31 = var26[1];
            var32 = var26[5];
            var33 = var26[6];
         } else if(var45 == 4) {
            var60 = var26[3];
            var31 = var26[2];
            var32 = var26[6];
            var33 = var26[7];
         } else if(var45 == 5) {
            var60 = var26[0];
            var31 = var26[3];
            var32 = var26[7];
            var33 = var26[4];
         }

         var5.func_78374_a(var60.field_72450_a, var60.field_72448_b, var60.field_72449_c, var18, var24);
         var5.func_78374_a(var31.field_72450_a, var31.field_72448_b, var31.field_72449_c, var22, var24);
         var5.func_78374_a(var32.field_72450_a, var32.field_72448_b, var32.field_72449_c, var22, var20);
         var5.func_78374_a(var33.field_72450_a, var33.field_72448_b, var33.field_72449_c, var18, var20);
      }

      if(var8) {
         double var63 = var26[0].field_72448_b;
         float var47 = 0.03125F;
         float var48 = 0.5F - var47 / 2.0F;
         float var49 = var48 + var47;
         double var50 = (double)var17.func_94209_e();
         double var52 = (double)var17.func_94207_b(var8?2.0D:0.0D);
         double var54 = (double)var17.func_94212_f();
         double var56 = (double)var17.func_94207_b(var8?4.0D:2.0D);
         double var58 = (double)(var10?3.5F:1.5F) / 16.0D;
         var5.func_78386_a(0.75F, 0.75F, 0.75F);
         if(var7 == 2) {
            var5.func_78374_a((double)((float)p_147723_2_ + var48), (double)p_147723_3_ + var58, (double)p_147723_4_ + 0.25D, var50, var52);
            var5.func_78374_a((double)((float)p_147723_2_ + var49), (double)p_147723_3_ + var58, (double)p_147723_4_ + 0.25D, var50, var56);
            var5.func_78374_a((double)((float)p_147723_2_ + var49), (double)p_147723_3_ + var58, (double)p_147723_4_, var54, var56);
            var5.func_78374_a((double)((float)p_147723_2_ + var48), (double)p_147723_3_ + var58, (double)p_147723_4_, var54, var52);
            var5.func_78374_a((double)((float)p_147723_2_ + var48), var63, (double)p_147723_4_ + 0.5D, var50, var52);
            var5.func_78374_a((double)((float)p_147723_2_ + var49), var63, (double)p_147723_4_ + 0.5D, var50, var56);
            var5.func_78374_a((double)((float)p_147723_2_ + var49), (double)p_147723_3_ + var58, (double)p_147723_4_ + 0.25D, var54, var56);
            var5.func_78374_a((double)((float)p_147723_2_ + var48), (double)p_147723_3_ + var58, (double)p_147723_4_ + 0.25D, var54, var52);
         } else if(var7 == 0) {
            var5.func_78374_a((double)((float)p_147723_2_ + var48), (double)p_147723_3_ + var58, (double)p_147723_4_ + 0.75D, var50, var52);
            var5.func_78374_a((double)((float)p_147723_2_ + var49), (double)p_147723_3_ + var58, (double)p_147723_4_ + 0.75D, var50, var56);
            var5.func_78374_a((double)((float)p_147723_2_ + var49), var63, (double)p_147723_4_ + 0.5D, var54, var56);
            var5.func_78374_a((double)((float)p_147723_2_ + var48), var63, (double)p_147723_4_ + 0.5D, var54, var52);
            var5.func_78374_a((double)((float)p_147723_2_ + var48), (double)p_147723_3_ + var58, (double)(p_147723_4_ + 1), var50, var52);
            var5.func_78374_a((double)((float)p_147723_2_ + var49), (double)p_147723_3_ + var58, (double)(p_147723_4_ + 1), var50, var56);
            var5.func_78374_a((double)((float)p_147723_2_ + var49), (double)p_147723_3_ + var58, (double)p_147723_4_ + 0.75D, var54, var56);
            var5.func_78374_a((double)((float)p_147723_2_ + var48), (double)p_147723_3_ + var58, (double)p_147723_4_ + 0.75D, var54, var52);
         } else if(var7 == 1) {
            var5.func_78374_a((double)p_147723_2_, (double)p_147723_3_ + var58, (double)((float)p_147723_4_ + var49), var50, var56);
            var5.func_78374_a((double)p_147723_2_ + 0.25D, (double)p_147723_3_ + var58, (double)((float)p_147723_4_ + var49), var54, var56);
            var5.func_78374_a((double)p_147723_2_ + 0.25D, (double)p_147723_3_ + var58, (double)((float)p_147723_4_ + var48), var54, var52);
            var5.func_78374_a((double)p_147723_2_, (double)p_147723_3_ + var58, (double)((float)p_147723_4_ + var48), var50, var52);
            var5.func_78374_a((double)p_147723_2_ + 0.25D, (double)p_147723_3_ + var58, (double)((float)p_147723_4_ + var49), var50, var56);
            var5.func_78374_a((double)p_147723_2_ + 0.5D, var63, (double)((float)p_147723_4_ + var49), var54, var56);
            var5.func_78374_a((double)p_147723_2_ + 0.5D, var63, (double)((float)p_147723_4_ + var48), var54, var52);
            var5.func_78374_a((double)p_147723_2_ + 0.25D, (double)p_147723_3_ + var58, (double)((float)p_147723_4_ + var48), var50, var52);
         } else {
            var5.func_78374_a((double)p_147723_2_ + 0.5D, var63, (double)((float)p_147723_4_ + var49), var50, var56);
            var5.func_78374_a((double)p_147723_2_ + 0.75D, (double)p_147723_3_ + var58, (double)((float)p_147723_4_ + var49), var54, var56);
            var5.func_78374_a((double)p_147723_2_ + 0.75D, (double)p_147723_3_ + var58, (double)((float)p_147723_4_ + var48), var54, var52);
            var5.func_78374_a((double)p_147723_2_ + 0.5D, var63, (double)((float)p_147723_4_ + var48), var50, var52);
            var5.func_78374_a((double)p_147723_2_ + 0.75D, (double)p_147723_3_ + var58, (double)((float)p_147723_4_ + var49), var50, var56);
            var5.func_78374_a((double)(p_147723_2_ + 1), (double)p_147723_3_ + var58, (double)((float)p_147723_4_ + var49), var54, var56);
            var5.func_78374_a((double)(p_147723_2_ + 1), (double)p_147723_3_ + var58, (double)((float)p_147723_4_ + var48), var54, var52);
            var5.func_78374_a((double)p_147723_2_ + 0.75D, (double)p_147723_3_ + var58, (double)((float)p_147723_4_ + var48), var50, var52);
         }
      }

      return true;
   }

   public boolean func_147756_g(Block p_147756_1_, int p_147756_2_, int p_147756_3_, int p_147756_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      IIcon var6 = this.func_147777_a(p_147756_1_, 0);
      int var7 = this.field_147845_a.func_72805_g(p_147756_2_, p_147756_3_, p_147756_4_);
      boolean var8 = (var7 & 4) == 4;
      boolean var9 = (var7 & 2) == 2;
      if(this.func_147744_b()) {
         var6 = this.field_147840_d;
      }

      var5.func_78380_c(p_147756_1_.func_149677_c(this.field_147845_a, p_147756_2_, p_147756_3_, p_147756_4_));
      var5.func_78386_a(1.0F, 1.0F, 1.0F);
      double var10 = (double)var6.func_94209_e();
      double var12 = (double)var6.func_94207_b(var8?2.0D:0.0D);
      double var14 = (double)var6.func_94212_f();
      double var16 = (double)var6.func_94207_b(var8?4.0D:2.0D);
      double var18 = (double)(var9?3.5F:1.5F) / 16.0D;
      boolean var20 = BlockTripWire.func_150139_a(this.field_147845_a, p_147756_2_, p_147756_3_, p_147756_4_, var7, 1);
      boolean var21 = BlockTripWire.func_150139_a(this.field_147845_a, p_147756_2_, p_147756_3_, p_147756_4_, var7, 3);
      boolean var22 = BlockTripWire.func_150139_a(this.field_147845_a, p_147756_2_, p_147756_3_, p_147756_4_, var7, 2);
      boolean var23 = BlockTripWire.func_150139_a(this.field_147845_a, p_147756_2_, p_147756_3_, p_147756_4_, var7, 0);
      float var24 = 0.03125F;
      float var25 = 0.5F - var24 / 2.0F;
      float var26 = var25 + var24;
      if(!var22 && !var21 && !var23 && !var20) {
         var22 = true;
         var23 = true;
      }

      if(var22) {
         var5.func_78374_a((double)((float)p_147756_2_ + var25), (double)p_147756_3_ + var18, (double)p_147756_4_ + 0.25D, var10, var12);
         var5.func_78374_a((double)((float)p_147756_2_ + var26), (double)p_147756_3_ + var18, (double)p_147756_4_ + 0.25D, var10, var16);
         var5.func_78374_a((double)((float)p_147756_2_ + var26), (double)p_147756_3_ + var18, (double)p_147756_4_, var14, var16);
         var5.func_78374_a((double)((float)p_147756_2_ + var25), (double)p_147756_3_ + var18, (double)p_147756_4_, var14, var12);
         var5.func_78374_a((double)((float)p_147756_2_ + var25), (double)p_147756_3_ + var18, (double)p_147756_4_, var14, var12);
         var5.func_78374_a((double)((float)p_147756_2_ + var26), (double)p_147756_3_ + var18, (double)p_147756_4_, var14, var16);
         var5.func_78374_a((double)((float)p_147756_2_ + var26), (double)p_147756_3_ + var18, (double)p_147756_4_ + 0.25D, var10, var16);
         var5.func_78374_a((double)((float)p_147756_2_ + var25), (double)p_147756_3_ + var18, (double)p_147756_4_ + 0.25D, var10, var12);
      }

      if(var22 || var23 && !var21 && !var20) {
         var5.func_78374_a((double)((float)p_147756_2_ + var25), (double)p_147756_3_ + var18, (double)p_147756_4_ + 0.5D, var10, var12);
         var5.func_78374_a((double)((float)p_147756_2_ + var26), (double)p_147756_3_ + var18, (double)p_147756_4_ + 0.5D, var10, var16);
         var5.func_78374_a((double)((float)p_147756_2_ + var26), (double)p_147756_3_ + var18, (double)p_147756_4_ + 0.25D, var14, var16);
         var5.func_78374_a((double)((float)p_147756_2_ + var25), (double)p_147756_3_ + var18, (double)p_147756_4_ + 0.25D, var14, var12);
         var5.func_78374_a((double)((float)p_147756_2_ + var25), (double)p_147756_3_ + var18, (double)p_147756_4_ + 0.25D, var14, var12);
         var5.func_78374_a((double)((float)p_147756_2_ + var26), (double)p_147756_3_ + var18, (double)p_147756_4_ + 0.25D, var14, var16);
         var5.func_78374_a((double)((float)p_147756_2_ + var26), (double)p_147756_3_ + var18, (double)p_147756_4_ + 0.5D, var10, var16);
         var5.func_78374_a((double)((float)p_147756_2_ + var25), (double)p_147756_3_ + var18, (double)p_147756_4_ + 0.5D, var10, var12);
      }

      if(var23 || var22 && !var21 && !var20) {
         var5.func_78374_a((double)((float)p_147756_2_ + var25), (double)p_147756_3_ + var18, (double)p_147756_4_ + 0.75D, var10, var12);
         var5.func_78374_a((double)((float)p_147756_2_ + var26), (double)p_147756_3_ + var18, (double)p_147756_4_ + 0.75D, var10, var16);
         var5.func_78374_a((double)((float)p_147756_2_ + var26), (double)p_147756_3_ + var18, (double)p_147756_4_ + 0.5D, var14, var16);
         var5.func_78374_a((double)((float)p_147756_2_ + var25), (double)p_147756_3_ + var18, (double)p_147756_4_ + 0.5D, var14, var12);
         var5.func_78374_a((double)((float)p_147756_2_ + var25), (double)p_147756_3_ + var18, (double)p_147756_4_ + 0.5D, var14, var12);
         var5.func_78374_a((double)((float)p_147756_2_ + var26), (double)p_147756_3_ + var18, (double)p_147756_4_ + 0.5D, var14, var16);
         var5.func_78374_a((double)((float)p_147756_2_ + var26), (double)p_147756_3_ + var18, (double)p_147756_4_ + 0.75D, var10, var16);
         var5.func_78374_a((double)((float)p_147756_2_ + var25), (double)p_147756_3_ + var18, (double)p_147756_4_ + 0.75D, var10, var12);
      }

      if(var23) {
         var5.func_78374_a((double)((float)p_147756_2_ + var25), (double)p_147756_3_ + var18, (double)(p_147756_4_ + 1), var10, var12);
         var5.func_78374_a((double)((float)p_147756_2_ + var26), (double)p_147756_3_ + var18, (double)(p_147756_4_ + 1), var10, var16);
         var5.func_78374_a((double)((float)p_147756_2_ + var26), (double)p_147756_3_ + var18, (double)p_147756_4_ + 0.75D, var14, var16);
         var5.func_78374_a((double)((float)p_147756_2_ + var25), (double)p_147756_3_ + var18, (double)p_147756_4_ + 0.75D, var14, var12);
         var5.func_78374_a((double)((float)p_147756_2_ + var25), (double)p_147756_3_ + var18, (double)p_147756_4_ + 0.75D, var14, var12);
         var5.func_78374_a((double)((float)p_147756_2_ + var26), (double)p_147756_3_ + var18, (double)p_147756_4_ + 0.75D, var14, var16);
         var5.func_78374_a((double)((float)p_147756_2_ + var26), (double)p_147756_3_ + var18, (double)(p_147756_4_ + 1), var10, var16);
         var5.func_78374_a((double)((float)p_147756_2_ + var25), (double)p_147756_3_ + var18, (double)(p_147756_4_ + 1), var10, var12);
      }

      if(var20) {
         var5.func_78374_a((double)p_147756_2_, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var26), var10, var16);
         var5.func_78374_a((double)p_147756_2_ + 0.25D, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var26), var14, var16);
         var5.func_78374_a((double)p_147756_2_ + 0.25D, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var25), var14, var12);
         var5.func_78374_a((double)p_147756_2_, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var25), var10, var12);
         var5.func_78374_a((double)p_147756_2_, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var25), var10, var12);
         var5.func_78374_a((double)p_147756_2_ + 0.25D, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var25), var14, var12);
         var5.func_78374_a((double)p_147756_2_ + 0.25D, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var26), var14, var16);
         var5.func_78374_a((double)p_147756_2_, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var26), var10, var16);
      }

      if(var20 || var21 && !var22 && !var23) {
         var5.func_78374_a((double)p_147756_2_ + 0.25D, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var26), var10, var16);
         var5.func_78374_a((double)p_147756_2_ + 0.5D, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var26), var14, var16);
         var5.func_78374_a((double)p_147756_2_ + 0.5D, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var25), var14, var12);
         var5.func_78374_a((double)p_147756_2_ + 0.25D, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var25), var10, var12);
         var5.func_78374_a((double)p_147756_2_ + 0.25D, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var25), var10, var12);
         var5.func_78374_a((double)p_147756_2_ + 0.5D, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var25), var14, var12);
         var5.func_78374_a((double)p_147756_2_ + 0.5D, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var26), var14, var16);
         var5.func_78374_a((double)p_147756_2_ + 0.25D, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var26), var10, var16);
      }

      if(var21 || var20 && !var22 && !var23) {
         var5.func_78374_a((double)p_147756_2_ + 0.5D, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var26), var10, var16);
         var5.func_78374_a((double)p_147756_2_ + 0.75D, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var26), var14, var16);
         var5.func_78374_a((double)p_147756_2_ + 0.75D, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var25), var14, var12);
         var5.func_78374_a((double)p_147756_2_ + 0.5D, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var25), var10, var12);
         var5.func_78374_a((double)p_147756_2_ + 0.5D, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var25), var10, var12);
         var5.func_78374_a((double)p_147756_2_ + 0.75D, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var25), var14, var12);
         var5.func_78374_a((double)p_147756_2_ + 0.75D, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var26), var14, var16);
         var5.func_78374_a((double)p_147756_2_ + 0.5D, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var26), var10, var16);
      }

      if(var21) {
         var5.func_78374_a((double)p_147756_2_ + 0.75D, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var26), var10, var16);
         var5.func_78374_a((double)(p_147756_2_ + 1), (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var26), var14, var16);
         var5.func_78374_a((double)(p_147756_2_ + 1), (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var25), var14, var12);
         var5.func_78374_a((double)p_147756_2_ + 0.75D, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var25), var10, var12);
         var5.func_78374_a((double)p_147756_2_ + 0.75D, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var25), var10, var12);
         var5.func_78374_a((double)(p_147756_2_ + 1), (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var25), var14, var12);
         var5.func_78374_a((double)(p_147756_2_ + 1), (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var26), var14, var16);
         var5.func_78374_a((double)p_147756_2_ + 0.75D, (double)p_147756_3_ + var18, (double)((float)p_147756_4_ + var26), var10, var16);
      }

      return true;
   }

   public boolean func_147801_a(BlockFire p_147801_1_, int p_147801_2_, int p_147801_3_, int p_147801_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      IIcon var6 = p_147801_1_.func_149840_c(0);
      IIcon var7 = p_147801_1_.func_149840_c(1);
      IIcon var8 = var6;
      if(this.func_147744_b()) {
         var8 = this.field_147840_d;
      }

      var5.func_78386_a(1.0F, 1.0F, 1.0F);
      var5.func_78380_c(p_147801_1_.func_149677_c(this.field_147845_a, p_147801_2_, p_147801_3_, p_147801_4_));
      double var9 = (double)var8.func_94209_e();
      double var11 = (double)var8.func_94206_g();
      double var13 = (double)var8.func_94212_f();
      double var15 = (double)var8.func_94210_h();
      float var17 = 1.4F;
      double var20;
      double var22;
      double var24;
      double var26;
      double var28;
      double var30;
      double var32;
      if(!World.func_147466_a(this.field_147845_a, p_147801_2_, p_147801_3_ - 1, p_147801_4_) && !Blocks.field_150480_ab.func_149844_e(this.field_147845_a, p_147801_2_, p_147801_3_ - 1, p_147801_4_)) {
         float var36 = 0.2F;
         float var19 = 0.0625F;
         if((p_147801_2_ + p_147801_3_ + p_147801_4_ & 1) == 1) {
            var9 = (double)var7.func_94209_e();
            var11 = (double)var7.func_94206_g();
            var13 = (double)var7.func_94212_f();
            var15 = (double)var7.func_94210_h();
         }

         if((p_147801_2_ / 2 + p_147801_3_ / 2 + p_147801_4_ / 2 & 1) == 1) {
            var20 = var13;
            var13 = var9;
            var9 = var20;
         }

         if(Blocks.field_150480_ab.func_149844_e(this.field_147845_a, p_147801_2_ - 1, p_147801_3_, p_147801_4_)) {
            var5.func_78374_a((double)((float)p_147801_2_ + var36), (double)((float)p_147801_3_ + var17 + var19), (double)(p_147801_4_ + 1), var13, var11);
            var5.func_78374_a((double)(p_147801_2_ + 0), (double)((float)(p_147801_3_ + 0) + var19), (double)(p_147801_4_ + 1), var13, var15);
            var5.func_78374_a((double)(p_147801_2_ + 0), (double)((float)(p_147801_3_ + 0) + var19), (double)(p_147801_4_ + 0), var9, var15);
            var5.func_78374_a((double)((float)p_147801_2_ + var36), (double)((float)p_147801_3_ + var17 + var19), (double)(p_147801_4_ + 0), var9, var11);
            var5.func_78374_a((double)((float)p_147801_2_ + var36), (double)((float)p_147801_3_ + var17 + var19), (double)(p_147801_4_ + 0), var9, var11);
            var5.func_78374_a((double)(p_147801_2_ + 0), (double)((float)(p_147801_3_ + 0) + var19), (double)(p_147801_4_ + 0), var9, var15);
            var5.func_78374_a((double)(p_147801_2_ + 0), (double)((float)(p_147801_3_ + 0) + var19), (double)(p_147801_4_ + 1), var13, var15);
            var5.func_78374_a((double)((float)p_147801_2_ + var36), (double)((float)p_147801_3_ + var17 + var19), (double)(p_147801_4_ + 1), var13, var11);
         }

         if(Blocks.field_150480_ab.func_149844_e(this.field_147845_a, p_147801_2_ + 1, p_147801_3_, p_147801_4_)) {
            var5.func_78374_a((double)((float)(p_147801_2_ + 1) - var36), (double)((float)p_147801_3_ + var17 + var19), (double)(p_147801_4_ + 0), var9, var11);
            var5.func_78374_a((double)(p_147801_2_ + 1 - 0), (double)((float)(p_147801_3_ + 0) + var19), (double)(p_147801_4_ + 0), var9, var15);
            var5.func_78374_a((double)(p_147801_2_ + 1 - 0), (double)((float)(p_147801_3_ + 0) + var19), (double)(p_147801_4_ + 1), var13, var15);
            var5.func_78374_a((double)((float)(p_147801_2_ + 1) - var36), (double)((float)p_147801_3_ + var17 + var19), (double)(p_147801_4_ + 1), var13, var11);
            var5.func_78374_a((double)((float)(p_147801_2_ + 1) - var36), (double)((float)p_147801_3_ + var17 + var19), (double)(p_147801_4_ + 1), var13, var11);
            var5.func_78374_a((double)(p_147801_2_ + 1 - 0), (double)((float)(p_147801_3_ + 0) + var19), (double)(p_147801_4_ + 1), var13, var15);
            var5.func_78374_a((double)(p_147801_2_ + 1 - 0), (double)((float)(p_147801_3_ + 0) + var19), (double)(p_147801_4_ + 0), var9, var15);
            var5.func_78374_a((double)((float)(p_147801_2_ + 1) - var36), (double)((float)p_147801_3_ + var17 + var19), (double)(p_147801_4_ + 0), var9, var11);
         }

         if(Blocks.field_150480_ab.func_149844_e(this.field_147845_a, p_147801_2_, p_147801_3_, p_147801_4_ - 1)) {
            var5.func_78374_a((double)(p_147801_2_ + 0), (double)((float)p_147801_3_ + var17 + var19), (double)((float)p_147801_4_ + var36), var13, var11);
            var5.func_78374_a((double)(p_147801_2_ + 0), (double)((float)(p_147801_3_ + 0) + var19), (double)(p_147801_4_ + 0), var13, var15);
            var5.func_78374_a((double)(p_147801_2_ + 1), (double)((float)(p_147801_3_ + 0) + var19), (double)(p_147801_4_ + 0), var9, var15);
            var5.func_78374_a((double)(p_147801_2_ + 1), (double)((float)p_147801_3_ + var17 + var19), (double)((float)p_147801_4_ + var36), var9, var11);
            var5.func_78374_a((double)(p_147801_2_ + 1), (double)((float)p_147801_3_ + var17 + var19), (double)((float)p_147801_4_ + var36), var9, var11);
            var5.func_78374_a((double)(p_147801_2_ + 1), (double)((float)(p_147801_3_ + 0) + var19), (double)(p_147801_4_ + 0), var9, var15);
            var5.func_78374_a((double)(p_147801_2_ + 0), (double)((float)(p_147801_3_ + 0) + var19), (double)(p_147801_4_ + 0), var13, var15);
            var5.func_78374_a((double)(p_147801_2_ + 0), (double)((float)p_147801_3_ + var17 + var19), (double)((float)p_147801_4_ + var36), var13, var11);
         }

         if(Blocks.field_150480_ab.func_149844_e(this.field_147845_a, p_147801_2_, p_147801_3_, p_147801_4_ + 1)) {
            var5.func_78374_a((double)(p_147801_2_ + 1), (double)((float)p_147801_3_ + var17 + var19), (double)((float)(p_147801_4_ + 1) - var36), var9, var11);
            var5.func_78374_a((double)(p_147801_2_ + 1), (double)((float)(p_147801_3_ + 0) + var19), (double)(p_147801_4_ + 1 - 0), var9, var15);
            var5.func_78374_a((double)(p_147801_2_ + 0), (double)((float)(p_147801_3_ + 0) + var19), (double)(p_147801_4_ + 1 - 0), var13, var15);
            var5.func_78374_a((double)(p_147801_2_ + 0), (double)((float)p_147801_3_ + var17 + var19), (double)((float)(p_147801_4_ + 1) - var36), var13, var11);
            var5.func_78374_a((double)(p_147801_2_ + 0), (double)((float)p_147801_3_ + var17 + var19), (double)((float)(p_147801_4_ + 1) - var36), var13, var11);
            var5.func_78374_a((double)(p_147801_2_ + 0), (double)((float)(p_147801_3_ + 0) + var19), (double)(p_147801_4_ + 1 - 0), var13, var15);
            var5.func_78374_a((double)(p_147801_2_ + 1), (double)((float)(p_147801_3_ + 0) + var19), (double)(p_147801_4_ + 1 - 0), var9, var15);
            var5.func_78374_a((double)(p_147801_2_ + 1), (double)((float)p_147801_3_ + var17 + var19), (double)((float)(p_147801_4_ + 1) - var36), var9, var11);
         }

         if(Blocks.field_150480_ab.func_149844_e(this.field_147845_a, p_147801_2_, p_147801_3_ + 1, p_147801_4_)) {
            var20 = (double)p_147801_2_ + 0.5D + 0.5D;
            var22 = (double)p_147801_2_ + 0.5D - 0.5D;
            var24 = (double)p_147801_4_ + 0.5D + 0.5D;
            var26 = (double)p_147801_4_ + 0.5D - 0.5D;
            var28 = (double)p_147801_2_ + 0.5D - 0.5D;
            var30 = (double)p_147801_2_ + 0.5D + 0.5D;
            var32 = (double)p_147801_4_ + 0.5D - 0.5D;
            double var34 = (double)p_147801_4_ + 0.5D + 0.5D;
            var9 = (double)var6.func_94209_e();
            var11 = (double)var6.func_94206_g();
            var13 = (double)var6.func_94212_f();
            var15 = (double)var6.func_94210_h();
            ++p_147801_3_;
            var17 = -0.2F;
            if((p_147801_2_ + p_147801_3_ + p_147801_4_ & 1) == 0) {
               var5.func_78374_a(var28, (double)((float)p_147801_3_ + var17), (double)(p_147801_4_ + 0), var13, var11);
               var5.func_78374_a(var20, (double)(p_147801_3_ + 0), (double)(p_147801_4_ + 0), var13, var15);
               var5.func_78374_a(var20, (double)(p_147801_3_ + 0), (double)(p_147801_4_ + 1), var9, var15);
               var5.func_78374_a(var28, (double)((float)p_147801_3_ + var17), (double)(p_147801_4_ + 1), var9, var11);
               var9 = (double)var7.func_94209_e();
               var11 = (double)var7.func_94206_g();
               var13 = (double)var7.func_94212_f();
               var15 = (double)var7.func_94210_h();
               var5.func_78374_a(var30, (double)((float)p_147801_3_ + var17), (double)(p_147801_4_ + 1), var13, var11);
               var5.func_78374_a(var22, (double)(p_147801_3_ + 0), (double)(p_147801_4_ + 1), var13, var15);
               var5.func_78374_a(var22, (double)(p_147801_3_ + 0), (double)(p_147801_4_ + 0), var9, var15);
               var5.func_78374_a(var30, (double)((float)p_147801_3_ + var17), (double)(p_147801_4_ + 0), var9, var11);
            } else {
               var5.func_78374_a((double)(p_147801_2_ + 0), (double)((float)p_147801_3_ + var17), var34, var13, var11);
               var5.func_78374_a((double)(p_147801_2_ + 0), (double)(p_147801_3_ + 0), var26, var13, var15);
               var5.func_78374_a((double)(p_147801_2_ + 1), (double)(p_147801_3_ + 0), var26, var9, var15);
               var5.func_78374_a((double)(p_147801_2_ + 1), (double)((float)p_147801_3_ + var17), var34, var9, var11);
               var9 = (double)var7.func_94209_e();
               var11 = (double)var7.func_94206_g();
               var13 = (double)var7.func_94212_f();
               var15 = (double)var7.func_94210_h();
               var5.func_78374_a((double)(p_147801_2_ + 1), (double)((float)p_147801_3_ + var17), var32, var13, var11);
               var5.func_78374_a((double)(p_147801_2_ + 1), (double)(p_147801_3_ + 0), var24, var13, var15);
               var5.func_78374_a((double)(p_147801_2_ + 0), (double)(p_147801_3_ + 0), var24, var9, var15);
               var5.func_78374_a((double)(p_147801_2_ + 0), (double)((float)p_147801_3_ + var17), var32, var9, var11);
            }
         }
      } else {
         double var18 = (double)p_147801_2_ + 0.5D + 0.2D;
         var20 = (double)p_147801_2_ + 0.5D - 0.2D;
         var22 = (double)p_147801_4_ + 0.5D + 0.2D;
         var24 = (double)p_147801_4_ + 0.5D - 0.2D;
         var26 = (double)p_147801_2_ + 0.5D - 0.3D;
         var28 = (double)p_147801_2_ + 0.5D + 0.3D;
         var30 = (double)p_147801_4_ + 0.5D - 0.3D;
         var32 = (double)p_147801_4_ + 0.5D + 0.3D;
         var5.func_78374_a(var26, (double)((float)p_147801_3_ + var17), (double)(p_147801_4_ + 1), var13, var11);
         var5.func_78374_a(var18, (double)(p_147801_3_ + 0), (double)(p_147801_4_ + 1), var13, var15);
         var5.func_78374_a(var18, (double)(p_147801_3_ + 0), (double)(p_147801_4_ + 0), var9, var15);
         var5.func_78374_a(var26, (double)((float)p_147801_3_ + var17), (double)(p_147801_4_ + 0), var9, var11);
         var5.func_78374_a(var28, (double)((float)p_147801_3_ + var17), (double)(p_147801_4_ + 0), var13, var11);
         var5.func_78374_a(var20, (double)(p_147801_3_ + 0), (double)(p_147801_4_ + 0), var13, var15);
         var5.func_78374_a(var20, (double)(p_147801_3_ + 0), (double)(p_147801_4_ + 1), var9, var15);
         var5.func_78374_a(var28, (double)((float)p_147801_3_ + var17), (double)(p_147801_4_ + 1), var9, var11);
         var9 = (double)var7.func_94209_e();
         var11 = (double)var7.func_94206_g();
         var13 = (double)var7.func_94212_f();
         var15 = (double)var7.func_94210_h();
         var5.func_78374_a((double)(p_147801_2_ + 1), (double)((float)p_147801_3_ + var17), var32, var13, var11);
         var5.func_78374_a((double)(p_147801_2_ + 1), (double)(p_147801_3_ + 0), var24, var13, var15);
         var5.func_78374_a((double)(p_147801_2_ + 0), (double)(p_147801_3_ + 0), var24, var9, var15);
         var5.func_78374_a((double)(p_147801_2_ + 0), (double)((float)p_147801_3_ + var17), var32, var9, var11);
         var5.func_78374_a((double)(p_147801_2_ + 0), (double)((float)p_147801_3_ + var17), var30, var13, var11);
         var5.func_78374_a((double)(p_147801_2_ + 0), (double)(p_147801_3_ + 0), var22, var13, var15);
         var5.func_78374_a((double)(p_147801_2_ + 1), (double)(p_147801_3_ + 0), var22, var9, var15);
         var5.func_78374_a((double)(p_147801_2_ + 1), (double)((float)p_147801_3_ + var17), var30, var9, var11);
         var18 = (double)p_147801_2_ + 0.5D - 0.5D;
         var20 = (double)p_147801_2_ + 0.5D + 0.5D;
         var22 = (double)p_147801_4_ + 0.5D - 0.5D;
         var24 = (double)p_147801_4_ + 0.5D + 0.5D;
         var26 = (double)p_147801_2_ + 0.5D - 0.4D;
         var28 = (double)p_147801_2_ + 0.5D + 0.4D;
         var30 = (double)p_147801_4_ + 0.5D - 0.4D;
         var32 = (double)p_147801_4_ + 0.5D + 0.4D;
         var5.func_78374_a(var26, (double)((float)p_147801_3_ + var17), (double)(p_147801_4_ + 0), var9, var11);
         var5.func_78374_a(var18, (double)(p_147801_3_ + 0), (double)(p_147801_4_ + 0), var9, var15);
         var5.func_78374_a(var18, (double)(p_147801_3_ + 0), (double)(p_147801_4_ + 1), var13, var15);
         var5.func_78374_a(var26, (double)((float)p_147801_3_ + var17), (double)(p_147801_4_ + 1), var13, var11);
         var5.func_78374_a(var28, (double)((float)p_147801_3_ + var17), (double)(p_147801_4_ + 1), var9, var11);
         var5.func_78374_a(var20, (double)(p_147801_3_ + 0), (double)(p_147801_4_ + 1), var9, var15);
         var5.func_78374_a(var20, (double)(p_147801_3_ + 0), (double)(p_147801_4_ + 0), var13, var15);
         var5.func_78374_a(var28, (double)((float)p_147801_3_ + var17), (double)(p_147801_4_ + 0), var13, var11);
         var9 = (double)var6.func_94209_e();
         var11 = (double)var6.func_94206_g();
         var13 = (double)var6.func_94212_f();
         var15 = (double)var6.func_94210_h();
         var5.func_78374_a((double)(p_147801_2_ + 0), (double)((float)p_147801_3_ + var17), var32, var9, var11);
         var5.func_78374_a((double)(p_147801_2_ + 0), (double)(p_147801_3_ + 0), var24, var9, var15);
         var5.func_78374_a((double)(p_147801_2_ + 1), (double)(p_147801_3_ + 0), var24, var13, var15);
         var5.func_78374_a((double)(p_147801_2_ + 1), (double)((float)p_147801_3_ + var17), var32, var13, var11);
         var5.func_78374_a((double)(p_147801_2_ + 1), (double)((float)p_147801_3_ + var17), var30, var9, var11);
         var5.func_78374_a((double)(p_147801_2_ + 1), (double)(p_147801_3_ + 0), var22, var9, var15);
         var5.func_78374_a((double)(p_147801_2_ + 0), (double)(p_147801_3_ + 0), var22, var13, var15);
         var5.func_78374_a((double)(p_147801_2_ + 0), (double)((float)p_147801_3_ + var17), var30, var13, var11);
      }

      return true;
   }

   public boolean func_147788_h(Block p_147788_1_, int p_147788_2_, int p_147788_3_, int p_147788_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      int var6 = this.field_147845_a.func_72805_g(p_147788_2_, p_147788_3_, p_147788_4_);
      IIcon var7 = BlockRedstoneWire.func_150173_e("cross");
      IIcon var8 = BlockRedstoneWire.func_150173_e("line");
      IIcon var9 = BlockRedstoneWire.func_150173_e("cross_overlay");
      IIcon var10 = BlockRedstoneWire.func_150173_e("line_overlay");
      var5.func_78380_c(p_147788_1_.func_149677_c(this.field_147845_a, p_147788_2_, p_147788_3_, p_147788_4_));
      float var11 = (float)var6 / 15.0F;
      float var12 = var11 * 0.6F + 0.4F;
      if(var6 == 0) {
         var12 = 0.3F;
      }

      float var13 = var11 * var11 * 0.7F - 0.5F;
      float var14 = var11 * var11 * 0.6F - 0.7F;
      if(var13 < 0.0F) {
         var13 = 0.0F;
      }

      if(var14 < 0.0F) {
         var14 = 0.0F;
      }

      var5.func_78386_a(var12, var13, var14);
      double var15 = 0.015625D;
      double var17 = 0.015625D;
      boolean var19 = BlockRedstoneWire.func_150174_f(this.field_147845_a, p_147788_2_ - 1, p_147788_3_, p_147788_4_, 1) || !this.field_147845_a.func_147439_a(p_147788_2_ - 1, p_147788_3_, p_147788_4_).func_149637_q() && BlockRedstoneWire.func_150174_f(this.field_147845_a, p_147788_2_ - 1, p_147788_3_ - 1, p_147788_4_, -1);
      boolean var20 = BlockRedstoneWire.func_150174_f(this.field_147845_a, p_147788_2_ + 1, p_147788_3_, p_147788_4_, 3) || !this.field_147845_a.func_147439_a(p_147788_2_ + 1, p_147788_3_, p_147788_4_).func_149637_q() && BlockRedstoneWire.func_150174_f(this.field_147845_a, p_147788_2_ + 1, p_147788_3_ - 1, p_147788_4_, -1);
      boolean var21 = BlockRedstoneWire.func_150174_f(this.field_147845_a, p_147788_2_, p_147788_3_, p_147788_4_ - 1, 2) || !this.field_147845_a.func_147439_a(p_147788_2_, p_147788_3_, p_147788_4_ - 1).func_149637_q() && BlockRedstoneWire.func_150174_f(this.field_147845_a, p_147788_2_, p_147788_3_ - 1, p_147788_4_ - 1, -1);
      boolean var22 = BlockRedstoneWire.func_150174_f(this.field_147845_a, p_147788_2_, p_147788_3_, p_147788_4_ + 1, 0) || !this.field_147845_a.func_147439_a(p_147788_2_, p_147788_3_, p_147788_4_ + 1).func_149637_q() && BlockRedstoneWire.func_150174_f(this.field_147845_a, p_147788_2_, p_147788_3_ - 1, p_147788_4_ + 1, -1);
      if(!this.field_147845_a.func_147439_a(p_147788_2_, p_147788_3_ + 1, p_147788_4_).func_149637_q()) {
         if(this.field_147845_a.func_147439_a(p_147788_2_ - 1, p_147788_3_, p_147788_4_).func_149637_q() && BlockRedstoneWire.func_150174_f(this.field_147845_a, p_147788_2_ - 1, p_147788_3_ + 1, p_147788_4_, -1)) {
            var19 = true;
         }

         if(this.field_147845_a.func_147439_a(p_147788_2_ + 1, p_147788_3_, p_147788_4_).func_149637_q() && BlockRedstoneWire.func_150174_f(this.field_147845_a, p_147788_2_ + 1, p_147788_3_ + 1, p_147788_4_, -1)) {
            var20 = true;
         }

         if(this.field_147845_a.func_147439_a(p_147788_2_, p_147788_3_, p_147788_4_ - 1).func_149637_q() && BlockRedstoneWire.func_150174_f(this.field_147845_a, p_147788_2_, p_147788_3_ + 1, p_147788_4_ - 1, -1)) {
            var21 = true;
         }

         if(this.field_147845_a.func_147439_a(p_147788_2_, p_147788_3_, p_147788_4_ + 1).func_149637_q() && BlockRedstoneWire.func_150174_f(this.field_147845_a, p_147788_2_, p_147788_3_ + 1, p_147788_4_ + 1, -1)) {
            var22 = true;
         }
      }

      float var23 = (float)(p_147788_2_ + 0);
      float var24 = (float)(p_147788_2_ + 1);
      float var25 = (float)(p_147788_4_ + 0);
      float var26 = (float)(p_147788_4_ + 1);
      boolean var27 = false;
      if((var19 || var20) && !var21 && !var22) {
         var27 = true;
      }

      if((var21 || var22) && !var20 && !var19) {
         var27 = true;
      }

      if(!var27) {
         int var28 = 0;
         int var29 = 0;
         int var30 = 16;
         int var31 = 16;
         boolean var32 = true;
         if(!var19) {
            var23 += 0.3125F;
         }

         if(!var19) {
            var28 += 5;
         }

         if(!var20) {
            var24 -= 0.3125F;
         }

         if(!var20) {
            var30 -= 5;
         }

         if(!var21) {
            var25 += 0.3125F;
         }

         if(!var21) {
            var29 += 5;
         }

         if(!var22) {
            var26 -= 0.3125F;
         }

         if(!var22) {
            var31 -= 5;
         }

         var5.func_78374_a((double)var24, (double)p_147788_3_ + 0.015625D, (double)var26, (double)var7.func_94214_a((double)var30), (double)var7.func_94207_b((double)var31));
         var5.func_78374_a((double)var24, (double)p_147788_3_ + 0.015625D, (double)var25, (double)var7.func_94214_a((double)var30), (double)var7.func_94207_b((double)var29));
         var5.func_78374_a((double)var23, (double)p_147788_3_ + 0.015625D, (double)var25, (double)var7.func_94214_a((double)var28), (double)var7.func_94207_b((double)var29));
         var5.func_78374_a((double)var23, (double)p_147788_3_ + 0.015625D, (double)var26, (double)var7.func_94214_a((double)var28), (double)var7.func_94207_b((double)var31));
         var5.func_78386_a(1.0F, 1.0F, 1.0F);
         var5.func_78374_a((double)var24, (double)p_147788_3_ + 0.015625D, (double)var26, (double)var9.func_94214_a((double)var30), (double)var9.func_94207_b((double)var31));
         var5.func_78374_a((double)var24, (double)p_147788_3_ + 0.015625D, (double)var25, (double)var9.func_94214_a((double)var30), (double)var9.func_94207_b((double)var29));
         var5.func_78374_a((double)var23, (double)p_147788_3_ + 0.015625D, (double)var25, (double)var9.func_94214_a((double)var28), (double)var9.func_94207_b((double)var29));
         var5.func_78374_a((double)var23, (double)p_147788_3_ + 0.015625D, (double)var26, (double)var9.func_94214_a((double)var28), (double)var9.func_94207_b((double)var31));
      } else if(var27) {
         var5.func_78374_a((double)var24, (double)p_147788_3_ + 0.015625D, (double)var26, (double)var8.func_94212_f(), (double)var8.func_94210_h());
         var5.func_78374_a((double)var24, (double)p_147788_3_ + 0.015625D, (double)var25, (double)var8.func_94212_f(), (double)var8.func_94206_g());
         var5.func_78374_a((double)var23, (double)p_147788_3_ + 0.015625D, (double)var25, (double)var8.func_94209_e(), (double)var8.func_94206_g());
         var5.func_78374_a((double)var23, (double)p_147788_3_ + 0.015625D, (double)var26, (double)var8.func_94209_e(), (double)var8.func_94210_h());
         var5.func_78386_a(1.0F, 1.0F, 1.0F);
         var5.func_78374_a((double)var24, (double)p_147788_3_ + 0.015625D, (double)var26, (double)var10.func_94212_f(), (double)var10.func_94210_h());
         var5.func_78374_a((double)var24, (double)p_147788_3_ + 0.015625D, (double)var25, (double)var10.func_94212_f(), (double)var10.func_94206_g());
         var5.func_78374_a((double)var23, (double)p_147788_3_ + 0.015625D, (double)var25, (double)var10.func_94209_e(), (double)var10.func_94206_g());
         var5.func_78374_a((double)var23, (double)p_147788_3_ + 0.015625D, (double)var26, (double)var10.func_94209_e(), (double)var10.func_94210_h());
      } else {
         var5.func_78374_a((double)var24, (double)p_147788_3_ + 0.015625D, (double)var26, (double)var8.func_94212_f(), (double)var8.func_94210_h());
         var5.func_78374_a((double)var24, (double)p_147788_3_ + 0.015625D, (double)var25, (double)var8.func_94209_e(), (double)var8.func_94210_h());
         var5.func_78374_a((double)var23, (double)p_147788_3_ + 0.015625D, (double)var25, (double)var8.func_94209_e(), (double)var8.func_94206_g());
         var5.func_78374_a((double)var23, (double)p_147788_3_ + 0.015625D, (double)var26, (double)var8.func_94212_f(), (double)var8.func_94206_g());
         var5.func_78386_a(1.0F, 1.0F, 1.0F);
         var5.func_78374_a((double)var24, (double)p_147788_3_ + 0.015625D, (double)var26, (double)var10.func_94212_f(), (double)var10.func_94210_h());
         var5.func_78374_a((double)var24, (double)p_147788_3_ + 0.015625D, (double)var25, (double)var10.func_94209_e(), (double)var10.func_94210_h());
         var5.func_78374_a((double)var23, (double)p_147788_3_ + 0.015625D, (double)var25, (double)var10.func_94209_e(), (double)var10.func_94206_g());
         var5.func_78374_a((double)var23, (double)p_147788_3_ + 0.015625D, (double)var26, (double)var10.func_94212_f(), (double)var10.func_94206_g());
      }

      if(!this.field_147845_a.func_147439_a(p_147788_2_, p_147788_3_ + 1, p_147788_4_).func_149637_q()) {
         float var33 = 0.021875F;
         if(this.field_147845_a.func_147439_a(p_147788_2_ - 1, p_147788_3_, p_147788_4_).func_149637_q() && this.field_147845_a.func_147439_a(p_147788_2_ - 1, p_147788_3_ + 1, p_147788_4_) == Blocks.field_150488_af) {
            var5.func_78386_a(var12, var13, var14);
            var5.func_78374_a((double)p_147788_2_ + 0.015625D, (double)((float)(p_147788_3_ + 1) + 0.021875F), (double)(p_147788_4_ + 1), (double)var8.func_94212_f(), (double)var8.func_94206_g());
            var5.func_78374_a((double)p_147788_2_ + 0.015625D, (double)(p_147788_3_ + 0), (double)(p_147788_4_ + 1), (double)var8.func_94209_e(), (double)var8.func_94206_g());
            var5.func_78374_a((double)p_147788_2_ + 0.015625D, (double)(p_147788_3_ + 0), (double)(p_147788_4_ + 0), (double)var8.func_94209_e(), (double)var8.func_94210_h());
            var5.func_78374_a((double)p_147788_2_ + 0.015625D, (double)((float)(p_147788_3_ + 1) + 0.021875F), (double)(p_147788_4_ + 0), (double)var8.func_94212_f(), (double)var8.func_94210_h());
            var5.func_78386_a(1.0F, 1.0F, 1.0F);
            var5.func_78374_a((double)p_147788_2_ + 0.015625D, (double)((float)(p_147788_3_ + 1) + 0.021875F), (double)(p_147788_4_ + 1), (double)var10.func_94212_f(), (double)var10.func_94206_g());
            var5.func_78374_a((double)p_147788_2_ + 0.015625D, (double)(p_147788_3_ + 0), (double)(p_147788_4_ + 1), (double)var10.func_94209_e(), (double)var10.func_94206_g());
            var5.func_78374_a((double)p_147788_2_ + 0.015625D, (double)(p_147788_3_ + 0), (double)(p_147788_4_ + 0), (double)var10.func_94209_e(), (double)var10.func_94210_h());
            var5.func_78374_a((double)p_147788_2_ + 0.015625D, (double)((float)(p_147788_3_ + 1) + 0.021875F), (double)(p_147788_4_ + 0), (double)var10.func_94212_f(), (double)var10.func_94210_h());
         }

         if(this.field_147845_a.func_147439_a(p_147788_2_ + 1, p_147788_3_, p_147788_4_).func_149637_q() && this.field_147845_a.func_147439_a(p_147788_2_ + 1, p_147788_3_ + 1, p_147788_4_) == Blocks.field_150488_af) {
            var5.func_78386_a(var12, var13, var14);
            var5.func_78374_a((double)(p_147788_2_ + 1) - 0.015625D, (double)(p_147788_3_ + 0), (double)(p_147788_4_ + 1), (double)var8.func_94209_e(), (double)var8.func_94210_h());
            var5.func_78374_a((double)(p_147788_2_ + 1) - 0.015625D, (double)((float)(p_147788_3_ + 1) + 0.021875F), (double)(p_147788_4_ + 1), (double)var8.func_94212_f(), (double)var8.func_94210_h());
            var5.func_78374_a((double)(p_147788_2_ + 1) - 0.015625D, (double)((float)(p_147788_3_ + 1) + 0.021875F), (double)(p_147788_4_ + 0), (double)var8.func_94212_f(), (double)var8.func_94206_g());
            var5.func_78374_a((double)(p_147788_2_ + 1) - 0.015625D, (double)(p_147788_3_ + 0), (double)(p_147788_4_ + 0), (double)var8.func_94209_e(), (double)var8.func_94206_g());
            var5.func_78386_a(1.0F, 1.0F, 1.0F);
            var5.func_78374_a((double)(p_147788_2_ + 1) - 0.015625D, (double)(p_147788_3_ + 0), (double)(p_147788_4_ + 1), (double)var10.func_94209_e(), (double)var10.func_94210_h());
            var5.func_78374_a((double)(p_147788_2_ + 1) - 0.015625D, (double)((float)(p_147788_3_ + 1) + 0.021875F), (double)(p_147788_4_ + 1), (double)var10.func_94212_f(), (double)var10.func_94210_h());
            var5.func_78374_a((double)(p_147788_2_ + 1) - 0.015625D, (double)((float)(p_147788_3_ + 1) + 0.021875F), (double)(p_147788_4_ + 0), (double)var10.func_94212_f(), (double)var10.func_94206_g());
            var5.func_78374_a((double)(p_147788_2_ + 1) - 0.015625D, (double)(p_147788_3_ + 0), (double)(p_147788_4_ + 0), (double)var10.func_94209_e(), (double)var10.func_94206_g());
         }

         if(this.field_147845_a.func_147439_a(p_147788_2_, p_147788_3_, p_147788_4_ - 1).func_149637_q() && this.field_147845_a.func_147439_a(p_147788_2_, p_147788_3_ + 1, p_147788_4_ - 1) == Blocks.field_150488_af) {
            var5.func_78386_a(var12, var13, var14);
            var5.func_78374_a((double)(p_147788_2_ + 1), (double)(p_147788_3_ + 0), (double)p_147788_4_ + 0.015625D, (double)var8.func_94209_e(), (double)var8.func_94210_h());
            var5.func_78374_a((double)(p_147788_2_ + 1), (double)((float)(p_147788_3_ + 1) + 0.021875F), (double)p_147788_4_ + 0.015625D, (double)var8.func_94212_f(), (double)var8.func_94210_h());
            var5.func_78374_a((double)(p_147788_2_ + 0), (double)((float)(p_147788_3_ + 1) + 0.021875F), (double)p_147788_4_ + 0.015625D, (double)var8.func_94212_f(), (double)var8.func_94206_g());
            var5.func_78374_a((double)(p_147788_2_ + 0), (double)(p_147788_3_ + 0), (double)p_147788_4_ + 0.015625D, (double)var8.func_94209_e(), (double)var8.func_94206_g());
            var5.func_78386_a(1.0F, 1.0F, 1.0F);
            var5.func_78374_a((double)(p_147788_2_ + 1), (double)(p_147788_3_ + 0), (double)p_147788_4_ + 0.015625D, (double)var10.func_94209_e(), (double)var10.func_94210_h());
            var5.func_78374_a((double)(p_147788_2_ + 1), (double)((float)(p_147788_3_ + 1) + 0.021875F), (double)p_147788_4_ + 0.015625D, (double)var10.func_94212_f(), (double)var10.func_94210_h());
            var5.func_78374_a((double)(p_147788_2_ + 0), (double)((float)(p_147788_3_ + 1) + 0.021875F), (double)p_147788_4_ + 0.015625D, (double)var10.func_94212_f(), (double)var10.func_94206_g());
            var5.func_78374_a((double)(p_147788_2_ + 0), (double)(p_147788_3_ + 0), (double)p_147788_4_ + 0.015625D, (double)var10.func_94209_e(), (double)var10.func_94206_g());
         }

         if(this.field_147845_a.func_147439_a(p_147788_2_, p_147788_3_, p_147788_4_ + 1).func_149637_q() && this.field_147845_a.func_147439_a(p_147788_2_, p_147788_3_ + 1, p_147788_4_ + 1) == Blocks.field_150488_af) {
            var5.func_78386_a(var12, var13, var14);
            var5.func_78374_a((double)(p_147788_2_ + 1), (double)((float)(p_147788_3_ + 1) + 0.021875F), (double)(p_147788_4_ + 1) - 0.015625D, (double)var8.func_94212_f(), (double)var8.func_94206_g());
            var5.func_78374_a((double)(p_147788_2_ + 1), (double)(p_147788_3_ + 0), (double)(p_147788_4_ + 1) - 0.015625D, (double)var8.func_94209_e(), (double)var8.func_94206_g());
            var5.func_78374_a((double)(p_147788_2_ + 0), (double)(p_147788_3_ + 0), (double)(p_147788_4_ + 1) - 0.015625D, (double)var8.func_94209_e(), (double)var8.func_94210_h());
            var5.func_78374_a((double)(p_147788_2_ + 0), (double)((float)(p_147788_3_ + 1) + 0.021875F), (double)(p_147788_4_ + 1) - 0.015625D, (double)var8.func_94212_f(), (double)var8.func_94210_h());
            var5.func_78386_a(1.0F, 1.0F, 1.0F);
            var5.func_78374_a((double)(p_147788_2_ + 1), (double)((float)(p_147788_3_ + 1) + 0.021875F), (double)(p_147788_4_ + 1) - 0.015625D, (double)var10.func_94212_f(), (double)var10.func_94206_g());
            var5.func_78374_a((double)(p_147788_2_ + 1), (double)(p_147788_3_ + 0), (double)(p_147788_4_ + 1) - 0.015625D, (double)var10.func_94209_e(), (double)var10.func_94206_g());
            var5.func_78374_a((double)(p_147788_2_ + 0), (double)(p_147788_3_ + 0), (double)(p_147788_4_ + 1) - 0.015625D, (double)var10.func_94209_e(), (double)var10.func_94210_h());
            var5.func_78374_a((double)(p_147788_2_ + 0), (double)((float)(p_147788_3_ + 1) + 0.021875F), (double)(p_147788_4_ + 1) - 0.015625D, (double)var10.func_94212_f(), (double)var10.func_94210_h());
         }
      }

      return true;
   }

   public boolean func_147766_a(BlockRailBase p_147766_1_, int p_147766_2_, int p_147766_3_, int p_147766_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      int var6 = this.field_147845_a.func_72805_g(p_147766_2_, p_147766_3_, p_147766_4_);
      IIcon var7 = this.func_147787_a(p_147766_1_, 0, var6);
      if(this.func_147744_b()) {
         var7 = this.field_147840_d;
      }

      if(p_147766_1_.func_150050_e()) {
         var6 &= 7;
      }

      var5.func_78380_c(p_147766_1_.func_149677_c(this.field_147845_a, p_147766_2_, p_147766_3_, p_147766_4_));
      var5.func_78386_a(1.0F, 1.0F, 1.0F);
      double var8 = (double)var7.func_94209_e();
      double var10 = (double)var7.func_94206_g();
      double var12 = (double)var7.func_94212_f();
      double var14 = (double)var7.func_94210_h();
      double var16 = 0.0625D;
      double var18 = (double)(p_147766_2_ + 1);
      double var20 = (double)(p_147766_2_ + 1);
      double var22 = (double)(p_147766_2_ + 0);
      double var24 = (double)(p_147766_2_ + 0);
      double var26 = (double)(p_147766_4_ + 0);
      double var28 = (double)(p_147766_4_ + 1);
      double var30 = (double)(p_147766_4_ + 1);
      double var32 = (double)(p_147766_4_ + 0);
      double var34 = (double)p_147766_3_ + var16;
      double var36 = (double)p_147766_3_ + var16;
      double var38 = (double)p_147766_3_ + var16;
      double var40 = (double)p_147766_3_ + var16;
      if(var6 != 1 && var6 != 2 && var6 != 3 && var6 != 7) {
         if(var6 == 8) {
            var18 = var20 = (double)(p_147766_2_ + 0);
            var22 = var24 = (double)(p_147766_2_ + 1);
            var26 = var32 = (double)(p_147766_4_ + 1);
            var28 = var30 = (double)(p_147766_4_ + 0);
         } else if(var6 == 9) {
            var18 = var24 = (double)(p_147766_2_ + 0);
            var20 = var22 = (double)(p_147766_2_ + 1);
            var26 = var28 = (double)(p_147766_4_ + 0);
            var30 = var32 = (double)(p_147766_4_ + 1);
         }
      } else {
         var18 = var24 = (double)(p_147766_2_ + 1);
         var20 = var22 = (double)(p_147766_2_ + 0);
         var26 = var28 = (double)(p_147766_4_ + 1);
         var30 = var32 = (double)(p_147766_4_ + 0);
      }

      if(var6 != 2 && var6 != 4) {
         if(var6 == 3 || var6 == 5) {
            ++var36;
            ++var38;
         }
      } else {
         ++var34;
         ++var40;
      }

      var5.func_78374_a(var18, var34, var26, var12, var10);
      var5.func_78374_a(var20, var36, var28, var12, var14);
      var5.func_78374_a(var22, var38, var30, var8, var14);
      var5.func_78374_a(var24, var40, var32, var8, var10);
      var5.func_78374_a(var24, var40, var32, var8, var10);
      var5.func_78374_a(var22, var38, var30, var8, var14);
      var5.func_78374_a(var20, var36, var28, var12, var14);
      var5.func_78374_a(var18, var34, var26, var12, var10);
      return true;
   }

   public boolean func_147794_i(Block p_147794_1_, int p_147794_2_, int p_147794_3_, int p_147794_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      IIcon var6 = this.func_147777_a(p_147794_1_, 0);
      if(this.func_147744_b()) {
         var6 = this.field_147840_d;
      }

      var5.func_78380_c(p_147794_1_.func_149677_c(this.field_147845_a, p_147794_2_, p_147794_3_, p_147794_4_));
      var5.func_78386_a(1.0F, 1.0F, 1.0F);
      double var7 = (double)var6.func_94209_e();
      double var9 = (double)var6.func_94206_g();
      double var11 = (double)var6.func_94212_f();
      double var13 = (double)var6.func_94210_h();
      int var15 = this.field_147845_a.func_72805_g(p_147794_2_, p_147794_3_, p_147794_4_);
      double var16 = 0.0D;
      double var18 = 0.05000000074505806D;
      if(var15 == 5) {
         var5.func_78374_a((double)p_147794_2_ + var18, (double)(p_147794_3_ + 1) + var16, (double)(p_147794_4_ + 1) + var16, var7, var9);
         var5.func_78374_a((double)p_147794_2_ + var18, (double)(p_147794_3_ + 0) - var16, (double)(p_147794_4_ + 1) + var16, var7, var13);
         var5.func_78374_a((double)p_147794_2_ + var18, (double)(p_147794_3_ + 0) - var16, (double)(p_147794_4_ + 0) - var16, var11, var13);
         var5.func_78374_a((double)p_147794_2_ + var18, (double)(p_147794_3_ + 1) + var16, (double)(p_147794_4_ + 0) - var16, var11, var9);
      }

      if(var15 == 4) {
         var5.func_78374_a((double)(p_147794_2_ + 1) - var18, (double)(p_147794_3_ + 0) - var16, (double)(p_147794_4_ + 1) + var16, var11, var13);
         var5.func_78374_a((double)(p_147794_2_ + 1) - var18, (double)(p_147794_3_ + 1) + var16, (double)(p_147794_4_ + 1) + var16, var11, var9);
         var5.func_78374_a((double)(p_147794_2_ + 1) - var18, (double)(p_147794_3_ + 1) + var16, (double)(p_147794_4_ + 0) - var16, var7, var9);
         var5.func_78374_a((double)(p_147794_2_ + 1) - var18, (double)(p_147794_3_ + 0) - var16, (double)(p_147794_4_ + 0) - var16, var7, var13);
      }

      if(var15 == 3) {
         var5.func_78374_a((double)(p_147794_2_ + 1) + var16, (double)(p_147794_3_ + 0) - var16, (double)p_147794_4_ + var18, var11, var13);
         var5.func_78374_a((double)(p_147794_2_ + 1) + var16, (double)(p_147794_3_ + 1) + var16, (double)p_147794_4_ + var18, var11, var9);
         var5.func_78374_a((double)(p_147794_2_ + 0) - var16, (double)(p_147794_3_ + 1) + var16, (double)p_147794_4_ + var18, var7, var9);
         var5.func_78374_a((double)(p_147794_2_ + 0) - var16, (double)(p_147794_3_ + 0) - var16, (double)p_147794_4_ + var18, var7, var13);
      }

      if(var15 == 2) {
         var5.func_78374_a((double)(p_147794_2_ + 1) + var16, (double)(p_147794_3_ + 1) + var16, (double)(p_147794_4_ + 1) - var18, var7, var9);
         var5.func_78374_a((double)(p_147794_2_ + 1) + var16, (double)(p_147794_3_ + 0) - var16, (double)(p_147794_4_ + 1) - var18, var7, var13);
         var5.func_78374_a((double)(p_147794_2_ + 0) - var16, (double)(p_147794_3_ + 0) - var16, (double)(p_147794_4_ + 1) - var18, var11, var13);
         var5.func_78374_a((double)(p_147794_2_ + 0) - var16, (double)(p_147794_3_ + 1) + var16, (double)(p_147794_4_ + 1) - var18, var11, var9);
      }

      return true;
   }

   public boolean func_147726_j(Block p_147726_1_, int p_147726_2_, int p_147726_3_, int p_147726_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      IIcon var6 = this.func_147777_a(p_147726_1_, 0);
      if(this.func_147744_b()) {
         var6 = this.field_147840_d;
      }

      var5.func_78380_c(p_147726_1_.func_149677_c(this.field_147845_a, p_147726_2_, p_147726_3_, p_147726_4_));
      int var7 = p_147726_1_.func_149720_d(this.field_147845_a, p_147726_2_, p_147726_3_, p_147726_4_);
      float var8 = (float)(var7 >> 16 & 255) / 255.0F;
      float var9 = (float)(var7 >> 8 & 255) / 255.0F;
      float var10 = (float)(var7 & 255) / 255.0F;
      var5.func_78386_a(var8, var9, var10);
      double var18 = (double)var6.func_94209_e();
      double var19 = (double)var6.func_94206_g();
      double var11 = (double)var6.func_94212_f();
      double var13 = (double)var6.func_94210_h();
      double var15 = 0.05000000074505806D;
      int var17 = this.field_147845_a.func_72805_g(p_147726_2_, p_147726_3_, p_147726_4_);
      if((var17 & 2) != 0) {
         var5.func_78374_a((double)p_147726_2_ + var15, (double)(p_147726_3_ + 1), (double)(p_147726_4_ + 1), var18, var19);
         var5.func_78374_a((double)p_147726_2_ + var15, (double)(p_147726_3_ + 0), (double)(p_147726_4_ + 1), var18, var13);
         var5.func_78374_a((double)p_147726_2_ + var15, (double)(p_147726_3_ + 0), (double)(p_147726_4_ + 0), var11, var13);
         var5.func_78374_a((double)p_147726_2_ + var15, (double)(p_147726_3_ + 1), (double)(p_147726_4_ + 0), var11, var19);
         var5.func_78374_a((double)p_147726_2_ + var15, (double)(p_147726_3_ + 1), (double)(p_147726_4_ + 0), var11, var19);
         var5.func_78374_a((double)p_147726_2_ + var15, (double)(p_147726_3_ + 0), (double)(p_147726_4_ + 0), var11, var13);
         var5.func_78374_a((double)p_147726_2_ + var15, (double)(p_147726_3_ + 0), (double)(p_147726_4_ + 1), var18, var13);
         var5.func_78374_a((double)p_147726_2_ + var15, (double)(p_147726_3_ + 1), (double)(p_147726_4_ + 1), var18, var19);
      }

      if((var17 & 8) != 0) {
         var5.func_78374_a((double)(p_147726_2_ + 1) - var15, (double)(p_147726_3_ + 0), (double)(p_147726_4_ + 1), var11, var13);
         var5.func_78374_a((double)(p_147726_2_ + 1) - var15, (double)(p_147726_3_ + 1), (double)(p_147726_4_ + 1), var11, var19);
         var5.func_78374_a((double)(p_147726_2_ + 1) - var15, (double)(p_147726_3_ + 1), (double)(p_147726_4_ + 0), var18, var19);
         var5.func_78374_a((double)(p_147726_2_ + 1) - var15, (double)(p_147726_3_ + 0), (double)(p_147726_4_ + 0), var18, var13);
         var5.func_78374_a((double)(p_147726_2_ + 1) - var15, (double)(p_147726_3_ + 0), (double)(p_147726_4_ + 0), var18, var13);
         var5.func_78374_a((double)(p_147726_2_ + 1) - var15, (double)(p_147726_3_ + 1), (double)(p_147726_4_ + 0), var18, var19);
         var5.func_78374_a((double)(p_147726_2_ + 1) - var15, (double)(p_147726_3_ + 1), (double)(p_147726_4_ + 1), var11, var19);
         var5.func_78374_a((double)(p_147726_2_ + 1) - var15, (double)(p_147726_3_ + 0), (double)(p_147726_4_ + 1), var11, var13);
      }

      if((var17 & 4) != 0) {
         var5.func_78374_a((double)(p_147726_2_ + 1), (double)(p_147726_3_ + 0), (double)p_147726_4_ + var15, var11, var13);
         var5.func_78374_a((double)(p_147726_2_ + 1), (double)(p_147726_3_ + 1), (double)p_147726_4_ + var15, var11, var19);
         var5.func_78374_a((double)(p_147726_2_ + 0), (double)(p_147726_3_ + 1), (double)p_147726_4_ + var15, var18, var19);
         var5.func_78374_a((double)(p_147726_2_ + 0), (double)(p_147726_3_ + 0), (double)p_147726_4_ + var15, var18, var13);
         var5.func_78374_a((double)(p_147726_2_ + 0), (double)(p_147726_3_ + 0), (double)p_147726_4_ + var15, var18, var13);
         var5.func_78374_a((double)(p_147726_2_ + 0), (double)(p_147726_3_ + 1), (double)p_147726_4_ + var15, var18, var19);
         var5.func_78374_a((double)(p_147726_2_ + 1), (double)(p_147726_3_ + 1), (double)p_147726_4_ + var15, var11, var19);
         var5.func_78374_a((double)(p_147726_2_ + 1), (double)(p_147726_3_ + 0), (double)p_147726_4_ + var15, var11, var13);
      }

      if((var17 & 1) != 0) {
         var5.func_78374_a((double)(p_147726_2_ + 1), (double)(p_147726_3_ + 1), (double)(p_147726_4_ + 1) - var15, var18, var19);
         var5.func_78374_a((double)(p_147726_2_ + 1), (double)(p_147726_3_ + 0), (double)(p_147726_4_ + 1) - var15, var18, var13);
         var5.func_78374_a((double)(p_147726_2_ + 0), (double)(p_147726_3_ + 0), (double)(p_147726_4_ + 1) - var15, var11, var13);
         var5.func_78374_a((double)(p_147726_2_ + 0), (double)(p_147726_3_ + 1), (double)(p_147726_4_ + 1) - var15, var11, var19);
         var5.func_78374_a((double)(p_147726_2_ + 0), (double)(p_147726_3_ + 1), (double)(p_147726_4_ + 1) - var15, var11, var19);
         var5.func_78374_a((double)(p_147726_2_ + 0), (double)(p_147726_3_ + 0), (double)(p_147726_4_ + 1) - var15, var11, var13);
         var5.func_78374_a((double)(p_147726_2_ + 1), (double)(p_147726_3_ + 0), (double)(p_147726_4_ + 1) - var15, var18, var13);
         var5.func_78374_a((double)(p_147726_2_ + 1), (double)(p_147726_3_ + 1), (double)(p_147726_4_ + 1) - var15, var18, var19);
      }

      if(this.field_147845_a.func_147439_a(p_147726_2_, p_147726_3_ + 1, p_147726_4_).func_149637_q()) {
         var5.func_78374_a((double)(p_147726_2_ + 1), (double)(p_147726_3_ + 1) - var15, (double)(p_147726_4_ + 0), var18, var19);
         var5.func_78374_a((double)(p_147726_2_ + 1), (double)(p_147726_3_ + 1) - var15, (double)(p_147726_4_ + 1), var18, var13);
         var5.func_78374_a((double)(p_147726_2_ + 0), (double)(p_147726_3_ + 1) - var15, (double)(p_147726_4_ + 1), var11, var13);
         var5.func_78374_a((double)(p_147726_2_ + 0), (double)(p_147726_3_ + 1) - var15, (double)(p_147726_4_ + 0), var11, var19);
      }

      return true;
   }

   public boolean func_147733_k(Block p_147733_1_, int p_147733_2_, int p_147733_3_, int p_147733_4_) {
      int var5 = this.field_147845_a.func_72800_K();
      Tessellator var6 = Tessellator.field_78398_a;
      var6.func_78380_c(p_147733_1_.func_149677_c(this.field_147845_a, p_147733_2_, p_147733_3_, p_147733_4_));
      int var7 = p_147733_1_.func_149720_d(this.field_147845_a, p_147733_2_, p_147733_3_, p_147733_4_);
      float var8 = (float)(var7 >> 16 & 255) / 255.0F;
      float var9 = (float)(var7 >> 8 & 255) / 255.0F;
      float var10 = (float)(var7 & 255) / 255.0F;
      if(EntityRenderer.field_78517_a) {
         float var11 = (var8 * 30.0F + var9 * 59.0F + var10 * 11.0F) / 100.0F;
         float var12 = (var8 * 30.0F + var9 * 70.0F) / 100.0F;
         float var13 = (var8 * 30.0F + var10 * 70.0F) / 100.0F;
         var8 = var11;
         var9 = var12;
         var10 = var13;
      }

      var6.func_78386_a(var8, var9, var10);
      boolean var67 = p_147733_1_ instanceof BlockStainedGlassPane;
      IIcon var65;
      IIcon var66;
      if(this.func_147744_b()) {
         var65 = this.field_147840_d;
         var66 = this.field_147840_d;
      } else {
         int var14 = this.field_147845_a.func_72805_g(p_147733_2_, p_147733_3_, p_147733_4_);
         var65 = this.func_147787_a(p_147733_1_, 0, var14);
         var66 = var67?((BlockStainedGlassPane)p_147733_1_).func_150104_b(var14):((BlockPane)p_147733_1_).func_150097_e();
      }

      double var68 = (double)var65.func_94209_e();
      double var16 = (double)var65.func_94214_a(7.0D);
      double var18 = (double)var65.func_94214_a(9.0D);
      double var20 = (double)var65.func_94212_f();
      double var22 = (double)var65.func_94206_g();
      double var24 = (double)var65.func_94210_h();
      double var26 = (double)var66.func_94214_a(7.0D);
      double var28 = (double)var66.func_94214_a(9.0D);
      double var30 = (double)var66.func_94206_g();
      double var32 = (double)var66.func_94210_h();
      double var34 = (double)var66.func_94207_b(7.0D);
      double var36 = (double)var66.func_94207_b(9.0D);
      double var38 = (double)p_147733_2_;
      double var40 = (double)(p_147733_2_ + 1);
      double var42 = (double)p_147733_4_;
      double var44 = (double)(p_147733_4_ + 1);
      double var46 = (double)p_147733_2_ + 0.5D - 0.0625D;
      double var48 = (double)p_147733_2_ + 0.5D + 0.0625D;
      double var50 = (double)p_147733_4_ + 0.5D - 0.0625D;
      double var52 = (double)p_147733_4_ + 0.5D + 0.0625D;
      boolean var54 = var67?((BlockStainedGlassPane)p_147733_1_).func_150098_a(this.field_147845_a.func_147439_a(p_147733_2_, p_147733_3_, p_147733_4_ - 1)):((BlockPane)p_147733_1_).func_150098_a(this.field_147845_a.func_147439_a(p_147733_2_, p_147733_3_, p_147733_4_ - 1));
      boolean var55 = var67?((BlockStainedGlassPane)p_147733_1_).func_150098_a(this.field_147845_a.func_147439_a(p_147733_2_, p_147733_3_, p_147733_4_ + 1)):((BlockPane)p_147733_1_).func_150098_a(this.field_147845_a.func_147439_a(p_147733_2_, p_147733_3_, p_147733_4_ + 1));
      boolean var56 = var67?((BlockStainedGlassPane)p_147733_1_).func_150098_a(this.field_147845_a.func_147439_a(p_147733_2_ - 1, p_147733_3_, p_147733_4_)):((BlockPane)p_147733_1_).func_150098_a(this.field_147845_a.func_147439_a(p_147733_2_ - 1, p_147733_3_, p_147733_4_));
      boolean var57 = var67?((BlockStainedGlassPane)p_147733_1_).func_150098_a(this.field_147845_a.func_147439_a(p_147733_2_ + 1, p_147733_3_, p_147733_4_)):((BlockPane)p_147733_1_).func_150098_a(this.field_147845_a.func_147439_a(p_147733_2_ + 1, p_147733_3_, p_147733_4_));
      double var58 = 0.001D;
      double var60 = 0.999D;
      double var62 = 0.001D;
      boolean var64 = !var54 && !var55 && !var56 && !var57;
      if(!var56 && !var64) {
         if(!var54 && !var55) {
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var50, var16, var22);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var50, var16, var24);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var52, var18, var24);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var52, var18, var22);
         }
      } else if(var56 && var57) {
         if(!var54) {
            var6.func_78374_a(var40, (double)p_147733_3_ + 0.999D, var50, var20, var22);
            var6.func_78374_a(var40, (double)p_147733_3_ + 0.001D, var50, var20, var24);
            var6.func_78374_a(var38, (double)p_147733_3_ + 0.001D, var50, var68, var24);
            var6.func_78374_a(var38, (double)p_147733_3_ + 0.999D, var50, var68, var22);
         } else {
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var50, var16, var22);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var50, var16, var24);
            var6.func_78374_a(var38, (double)p_147733_3_ + 0.001D, var50, var68, var24);
            var6.func_78374_a(var38, (double)p_147733_3_ + 0.999D, var50, var68, var22);
            var6.func_78374_a(var40, (double)p_147733_3_ + 0.999D, var50, var20, var22);
            var6.func_78374_a(var40, (double)p_147733_3_ + 0.001D, var50, var20, var24);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var50, var18, var24);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var50, var18, var22);
         }

         if(!var55) {
            var6.func_78374_a(var38, (double)p_147733_3_ + 0.999D, var52, var68, var22);
            var6.func_78374_a(var38, (double)p_147733_3_ + 0.001D, var52, var68, var24);
            var6.func_78374_a(var40, (double)p_147733_3_ + 0.001D, var52, var20, var24);
            var6.func_78374_a(var40, (double)p_147733_3_ + 0.999D, var52, var20, var22);
         } else {
            var6.func_78374_a(var38, (double)p_147733_3_ + 0.999D, var52, var68, var22);
            var6.func_78374_a(var38, (double)p_147733_3_ + 0.001D, var52, var68, var24);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var52, var16, var24);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var52, var16, var22);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var52, var18, var22);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var52, var18, var24);
            var6.func_78374_a(var40, (double)p_147733_3_ + 0.001D, var52, var20, var24);
            var6.func_78374_a(var40, (double)p_147733_3_ + 0.999D, var52, var20, var22);
         }

         var6.func_78374_a(var38, (double)p_147733_3_ + 0.999D, var52, var28, var30);
         var6.func_78374_a(var40, (double)p_147733_3_ + 0.999D, var52, var28, var32);
         var6.func_78374_a(var40, (double)p_147733_3_ + 0.999D, var50, var26, var32);
         var6.func_78374_a(var38, (double)p_147733_3_ + 0.999D, var50, var26, var30);
         var6.func_78374_a(var40, (double)p_147733_3_ + 0.001D, var52, var26, var32);
         var6.func_78374_a(var38, (double)p_147733_3_ + 0.001D, var52, var26, var30);
         var6.func_78374_a(var38, (double)p_147733_3_ + 0.001D, var50, var28, var30);
         var6.func_78374_a(var40, (double)p_147733_3_ + 0.001D, var50, var28, var32);
      } else {
         if(!var54 && !var64) {
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var50, var18, var22);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var50, var18, var24);
            var6.func_78374_a(var38, (double)p_147733_3_ + 0.001D, var50, var68, var24);
            var6.func_78374_a(var38, (double)p_147733_3_ + 0.999D, var50, var68, var22);
         } else {
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var50, var16, var22);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var50, var16, var24);
            var6.func_78374_a(var38, (double)p_147733_3_ + 0.001D, var50, var68, var24);
            var6.func_78374_a(var38, (double)p_147733_3_ + 0.999D, var50, var68, var22);
         }

         if(!var55 && !var64) {
            var6.func_78374_a(var38, (double)p_147733_3_ + 0.999D, var52, var68, var22);
            var6.func_78374_a(var38, (double)p_147733_3_ + 0.001D, var52, var68, var24);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var52, var18, var24);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var52, var18, var22);
         } else {
            var6.func_78374_a(var38, (double)p_147733_3_ + 0.999D, var52, var68, var22);
            var6.func_78374_a(var38, (double)p_147733_3_ + 0.001D, var52, var68, var24);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var52, var16, var24);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var52, var16, var22);
         }

         var6.func_78374_a(var38, (double)p_147733_3_ + 0.999D, var52, var28, var30);
         var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var52, var28, var34);
         var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var50, var26, var34);
         var6.func_78374_a(var38, (double)p_147733_3_ + 0.999D, var50, var26, var30);
         var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var52, var26, var34);
         var6.func_78374_a(var38, (double)p_147733_3_ + 0.001D, var52, var26, var30);
         var6.func_78374_a(var38, (double)p_147733_3_ + 0.001D, var50, var28, var30);
         var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var50, var28, var34);
      }

      if((var57 || var64) && !var56) {
         if(!var55 && !var64) {
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var52, var16, var22);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var52, var16, var24);
            var6.func_78374_a(var40, (double)p_147733_3_ + 0.001D, var52, var20, var24);
            var6.func_78374_a(var40, (double)p_147733_3_ + 0.999D, var52, var20, var22);
         } else {
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var52, var18, var22);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var52, var18, var24);
            var6.func_78374_a(var40, (double)p_147733_3_ + 0.001D, var52, var20, var24);
            var6.func_78374_a(var40, (double)p_147733_3_ + 0.999D, var52, var20, var22);
         }

         if(!var54 && !var64) {
            var6.func_78374_a(var40, (double)p_147733_3_ + 0.999D, var50, var20, var22);
            var6.func_78374_a(var40, (double)p_147733_3_ + 0.001D, var50, var20, var24);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var50, var16, var24);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var50, var16, var22);
         } else {
            var6.func_78374_a(var40, (double)p_147733_3_ + 0.999D, var50, var20, var22);
            var6.func_78374_a(var40, (double)p_147733_3_ + 0.001D, var50, var20, var24);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var50, var18, var24);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var50, var18, var22);
         }

         var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var52, var28, var36);
         var6.func_78374_a(var40, (double)p_147733_3_ + 0.999D, var52, var28, var30);
         var6.func_78374_a(var40, (double)p_147733_3_ + 0.999D, var50, var26, var30);
         var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var50, var26, var36);
         var6.func_78374_a(var40, (double)p_147733_3_ + 0.001D, var52, var26, var32);
         var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var52, var26, var36);
         var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var50, var28, var36);
         var6.func_78374_a(var40, (double)p_147733_3_ + 0.001D, var50, var28, var32);
      } else if(!var57 && !var54 && !var55) {
         var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var52, var16, var22);
         var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var52, var16, var24);
         var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var50, var18, var24);
         var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var50, var18, var22);
      }

      if(!var54 && !var64) {
         if(!var57 && !var56) {
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var50, var18, var22);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var50, var18, var24);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var50, var16, var24);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var50, var16, var22);
         }
      } else if(var54 && var55) {
         if(!var56) {
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var42, var68, var22);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var42, var68, var24);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var44, var20, var24);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var44, var20, var22);
         } else {
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var42, var68, var22);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var42, var68, var24);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var50, var16, var24);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var50, var16, var22);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var52, var18, var22);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var52, var18, var24);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var44, var20, var24);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var44, var20, var22);
         }

         if(!var57) {
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var44, var20, var22);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var44, var20, var24);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var42, var68, var24);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var42, var68, var22);
         } else {
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var50, var16, var22);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var50, var16, var24);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var42, var68, var24);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var42, var68, var22);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var44, var20, var22);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var44, var20, var24);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var52, var18, var24);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var52, var18, var22);
         }

         var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var42, var28, var30);
         var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var42, var26, var30);
         var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var44, var26, var32);
         var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var44, var28, var32);
         var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var42, var26, var30);
         var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var42, var28, var30);
         var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var44, var28, var32);
         var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var44, var26, var32);
      } else {
         if(!var56 && !var64) {
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var42, var68, var22);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var42, var68, var24);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var52, var18, var24);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var52, var18, var22);
         } else {
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var42, var68, var22);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var42, var68, var24);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var50, var16, var24);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var50, var16, var22);
         }

         if(!var57 && !var64) {
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var52, var18, var22);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var52, var18, var24);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var42, var68, var24);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var42, var68, var22);
         } else {
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var50, var16, var22);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var50, var16, var24);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var42, var68, var24);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var42, var68, var22);
         }

         var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var42, var28, var30);
         var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var42, var26, var30);
         var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var50, var26, var34);
         var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var50, var28, var34);
         var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var42, var26, var30);
         var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var42, var28, var30);
         var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var50, var28, var34);
         var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var50, var26, var34);
      }

      if((var55 || var64) && !var54) {
         if(!var56 && !var64) {
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var50, var16, var22);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var50, var16, var24);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var44, var20, var24);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var44, var20, var22);
         } else {
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var52, var18, var22);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var52, var18, var24);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var44, var20, var24);
            var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var44, var20, var22);
         }

         if(!var57 && !var64) {
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var44, var20, var22);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var44, var20, var24);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var50, var16, var24);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var50, var16, var22);
         } else {
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var44, var20, var22);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var44, var20, var24);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var52, var18, var24);
            var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var52, var18, var22);
         }

         var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var52, var28, var36);
         var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var52, var26, var36);
         var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var44, var26, var32);
         var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var44, var28, var32);
         var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var52, var26, var36);
         var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var52, var28, var36);
         var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var44, var28, var32);
         var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var44, var26, var32);
      } else if(!var55 && !var57 && !var56) {
         var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var52, var16, var22);
         var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var52, var16, var24);
         var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var52, var18, var24);
         var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var52, var18, var22);
      }

      var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var50, var28, var34);
      var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var50, var26, var34);
      var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var52, var26, var36);
      var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var52, var28, var36);
      var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var50, var26, var34);
      var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var50, var28, var34);
      var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var52, var28, var36);
      var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var52, var26, var36);
      if(var64) {
         var6.func_78374_a(var38, (double)p_147733_3_ + 0.999D, var50, var16, var22);
         var6.func_78374_a(var38, (double)p_147733_3_ + 0.001D, var50, var16, var24);
         var6.func_78374_a(var38, (double)p_147733_3_ + 0.001D, var52, var18, var24);
         var6.func_78374_a(var38, (double)p_147733_3_ + 0.999D, var52, var18, var22);
         var6.func_78374_a(var40, (double)p_147733_3_ + 0.999D, var52, var16, var22);
         var6.func_78374_a(var40, (double)p_147733_3_ + 0.001D, var52, var16, var24);
         var6.func_78374_a(var40, (double)p_147733_3_ + 0.001D, var50, var18, var24);
         var6.func_78374_a(var40, (double)p_147733_3_ + 0.999D, var50, var18, var22);
         var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var42, var18, var22);
         var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var42, var18, var24);
         var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var42, var16, var24);
         var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var42, var16, var22);
         var6.func_78374_a(var46, (double)p_147733_3_ + 0.999D, var44, var16, var22);
         var6.func_78374_a(var46, (double)p_147733_3_ + 0.001D, var44, var16, var24);
         var6.func_78374_a(var48, (double)p_147733_3_ + 0.001D, var44, var18, var24);
         var6.func_78374_a(var48, (double)p_147733_3_ + 0.999D, var44, var18, var22);
      }

      return true;
   }

   public boolean func_147767_a(BlockPane p_147767_1_, int p_147767_2_, int p_147767_3_, int p_147767_4_) {
      int var5 = this.field_147845_a.func_72800_K();
      Tessellator var6 = Tessellator.field_78398_a;
      var6.func_78380_c(p_147767_1_.func_149677_c(this.field_147845_a, p_147767_2_, p_147767_3_, p_147767_4_));
      int var7 = p_147767_1_.func_149720_d(this.field_147845_a, p_147767_2_, p_147767_3_, p_147767_4_);
      float var8 = (float)(var7 >> 16 & 255) / 255.0F;
      float var9 = (float)(var7 >> 8 & 255) / 255.0F;
      float var10 = (float)(var7 & 255) / 255.0F;
      if(EntityRenderer.field_78517_a) {
         float var11 = (var8 * 30.0F + var9 * 59.0F + var10 * 11.0F) / 100.0F;
         float var12 = (var8 * 30.0F + var9 * 70.0F) / 100.0F;
         float var13 = (var8 * 30.0F + var10 * 70.0F) / 100.0F;
         var8 = var11;
         var9 = var12;
         var10 = var13;
      }

      var6.func_78386_a(var8, var9, var10);
      IIcon var63;
      IIcon var64;
      if(this.func_147744_b()) {
         var63 = this.field_147840_d;
         var64 = this.field_147840_d;
      } else {
         int var65 = this.field_147845_a.func_72805_g(p_147767_2_, p_147767_3_, p_147767_4_);
         var63 = this.func_147787_a(p_147767_1_, 0, var65);
         var64 = p_147767_1_.func_150097_e();
      }

      double var66 = (double)var63.func_94209_e();
      double var15 = (double)var63.func_94214_a(8.0D);
      double var17 = (double)var63.func_94212_f();
      double var19 = (double)var63.func_94206_g();
      double var21 = (double)var63.func_94210_h();
      double var23 = (double)var64.func_94214_a(7.0D);
      double var25 = (double)var64.func_94214_a(9.0D);
      double var27 = (double)var64.func_94206_g();
      double var29 = (double)var64.func_94207_b(8.0D);
      double var31 = (double)var64.func_94210_h();
      double var33 = (double)p_147767_2_;
      double var35 = (double)p_147767_2_ + 0.5D;
      double var37 = (double)(p_147767_2_ + 1);
      double var39 = (double)p_147767_4_;
      double var41 = (double)p_147767_4_ + 0.5D;
      double var43 = (double)(p_147767_4_ + 1);
      double var45 = (double)p_147767_2_ + 0.5D - 0.0625D;
      double var47 = (double)p_147767_2_ + 0.5D + 0.0625D;
      double var49 = (double)p_147767_4_ + 0.5D - 0.0625D;
      double var51 = (double)p_147767_4_ + 0.5D + 0.0625D;
      boolean var53 = p_147767_1_.func_150098_a(this.field_147845_a.func_147439_a(p_147767_2_, p_147767_3_, p_147767_4_ - 1));
      boolean var54 = p_147767_1_.func_150098_a(this.field_147845_a.func_147439_a(p_147767_2_, p_147767_3_, p_147767_4_ + 1));
      boolean var55 = p_147767_1_.func_150098_a(this.field_147845_a.func_147439_a(p_147767_2_ - 1, p_147767_3_, p_147767_4_));
      boolean var56 = p_147767_1_.func_150098_a(this.field_147845_a.func_147439_a(p_147767_2_ + 1, p_147767_3_, p_147767_4_));
      boolean var57 = p_147767_1_.func_149646_a(this.field_147845_a, p_147767_2_, p_147767_3_ + 1, p_147767_4_, 1);
      boolean var58 = p_147767_1_.func_149646_a(this.field_147845_a, p_147767_2_, p_147767_3_ - 1, p_147767_4_, 0);
      double var59 = 0.01D;
      double var61 = 0.005D;
      if((!var55 || !var56) && (var55 || var56 || var53 || var54)) {
         if(var55 && !var56) {
            var6.func_78374_a(var33, (double)(p_147767_3_ + 1), var41, var66, var19);
            var6.func_78374_a(var33, (double)(p_147767_3_ + 0), var41, var66, var21);
            var6.func_78374_a(var35, (double)(p_147767_3_ + 0), var41, var15, var21);
            var6.func_78374_a(var35, (double)(p_147767_3_ + 1), var41, var15, var19);
            var6.func_78374_a(var35, (double)(p_147767_3_ + 1), var41, var66, var19);
            var6.func_78374_a(var35, (double)(p_147767_3_ + 0), var41, var66, var21);
            var6.func_78374_a(var33, (double)(p_147767_3_ + 0), var41, var15, var21);
            var6.func_78374_a(var33, (double)(p_147767_3_ + 1), var41, var15, var19);
            if(!var54 && !var53) {
               var6.func_78374_a(var35, (double)(p_147767_3_ + 1), var51, var23, var27);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 0), var51, var23, var31);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 0), var49, var25, var31);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 1), var49, var25, var27);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 1), var49, var23, var27);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 0), var49, var23, var31);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 0), var51, var25, var31);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 1), var51, var25, var27);
            }

            if(var57 || p_147767_3_ < var5 - 1 && this.field_147845_a.func_147437_c(p_147767_2_ - 1, p_147767_3_ + 1, p_147767_4_)) {
               var6.func_78374_a(var33, (double)(p_147767_3_ + 1) + 0.01D, var51, var25, var29);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 1) + 0.01D, var51, var25, var31);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 1) + 0.01D, var49, var23, var31);
               var6.func_78374_a(var33, (double)(p_147767_3_ + 1) + 0.01D, var49, var23, var29);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 1) + 0.01D, var51, var25, var29);
               var6.func_78374_a(var33, (double)(p_147767_3_ + 1) + 0.01D, var51, var25, var31);
               var6.func_78374_a(var33, (double)(p_147767_3_ + 1) + 0.01D, var49, var23, var31);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 1) + 0.01D, var49, var23, var29);
            }

            if(var58 || p_147767_3_ > 1 && this.field_147845_a.func_147437_c(p_147767_2_ - 1, p_147767_3_ - 1, p_147767_4_)) {
               var6.func_78374_a(var33, (double)p_147767_3_ - 0.01D, var51, var25, var29);
               var6.func_78374_a(var35, (double)p_147767_3_ - 0.01D, var51, var25, var31);
               var6.func_78374_a(var35, (double)p_147767_3_ - 0.01D, var49, var23, var31);
               var6.func_78374_a(var33, (double)p_147767_3_ - 0.01D, var49, var23, var29);
               var6.func_78374_a(var35, (double)p_147767_3_ - 0.01D, var51, var25, var29);
               var6.func_78374_a(var33, (double)p_147767_3_ - 0.01D, var51, var25, var31);
               var6.func_78374_a(var33, (double)p_147767_3_ - 0.01D, var49, var23, var31);
               var6.func_78374_a(var35, (double)p_147767_3_ - 0.01D, var49, var23, var29);
            }
         } else if(!var55 && var56) {
            var6.func_78374_a(var35, (double)(p_147767_3_ + 1), var41, var15, var19);
            var6.func_78374_a(var35, (double)(p_147767_3_ + 0), var41, var15, var21);
            var6.func_78374_a(var37, (double)(p_147767_3_ + 0), var41, var17, var21);
            var6.func_78374_a(var37, (double)(p_147767_3_ + 1), var41, var17, var19);
            var6.func_78374_a(var37, (double)(p_147767_3_ + 1), var41, var15, var19);
            var6.func_78374_a(var37, (double)(p_147767_3_ + 0), var41, var15, var21);
            var6.func_78374_a(var35, (double)(p_147767_3_ + 0), var41, var17, var21);
            var6.func_78374_a(var35, (double)(p_147767_3_ + 1), var41, var17, var19);
            if(!var54 && !var53) {
               var6.func_78374_a(var35, (double)(p_147767_3_ + 1), var49, var23, var27);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 0), var49, var23, var31);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 0), var51, var25, var31);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 1), var51, var25, var27);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 1), var51, var23, var27);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 0), var51, var23, var31);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 0), var49, var25, var31);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 1), var49, var25, var27);
            }

            if(var57 || p_147767_3_ < var5 - 1 && this.field_147845_a.func_147437_c(p_147767_2_ + 1, p_147767_3_ + 1, p_147767_4_)) {
               var6.func_78374_a(var35, (double)(p_147767_3_ + 1) + 0.01D, var51, var25, var27);
               var6.func_78374_a(var37, (double)(p_147767_3_ + 1) + 0.01D, var51, var25, var29);
               var6.func_78374_a(var37, (double)(p_147767_3_ + 1) + 0.01D, var49, var23, var29);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 1) + 0.01D, var49, var23, var27);
               var6.func_78374_a(var37, (double)(p_147767_3_ + 1) + 0.01D, var51, var25, var27);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 1) + 0.01D, var51, var25, var29);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 1) + 0.01D, var49, var23, var29);
               var6.func_78374_a(var37, (double)(p_147767_3_ + 1) + 0.01D, var49, var23, var27);
            }

            if(var58 || p_147767_3_ > 1 && this.field_147845_a.func_147437_c(p_147767_2_ + 1, p_147767_3_ - 1, p_147767_4_)) {
               var6.func_78374_a(var35, (double)p_147767_3_ - 0.01D, var51, var25, var27);
               var6.func_78374_a(var37, (double)p_147767_3_ - 0.01D, var51, var25, var29);
               var6.func_78374_a(var37, (double)p_147767_3_ - 0.01D, var49, var23, var29);
               var6.func_78374_a(var35, (double)p_147767_3_ - 0.01D, var49, var23, var27);
               var6.func_78374_a(var37, (double)p_147767_3_ - 0.01D, var51, var25, var27);
               var6.func_78374_a(var35, (double)p_147767_3_ - 0.01D, var51, var25, var29);
               var6.func_78374_a(var35, (double)p_147767_3_ - 0.01D, var49, var23, var29);
               var6.func_78374_a(var37, (double)p_147767_3_ - 0.01D, var49, var23, var27);
            }
         }
      } else {
         var6.func_78374_a(var33, (double)(p_147767_3_ + 1), var41, var66, var19);
         var6.func_78374_a(var33, (double)(p_147767_3_ + 0), var41, var66, var21);
         var6.func_78374_a(var37, (double)(p_147767_3_ + 0), var41, var17, var21);
         var6.func_78374_a(var37, (double)(p_147767_3_ + 1), var41, var17, var19);
         var6.func_78374_a(var37, (double)(p_147767_3_ + 1), var41, var66, var19);
         var6.func_78374_a(var37, (double)(p_147767_3_ + 0), var41, var66, var21);
         var6.func_78374_a(var33, (double)(p_147767_3_ + 0), var41, var17, var21);
         var6.func_78374_a(var33, (double)(p_147767_3_ + 1), var41, var17, var19);
         if(var57) {
            var6.func_78374_a(var33, (double)(p_147767_3_ + 1) + 0.01D, var51, var25, var31);
            var6.func_78374_a(var37, (double)(p_147767_3_ + 1) + 0.01D, var51, var25, var27);
            var6.func_78374_a(var37, (double)(p_147767_3_ + 1) + 0.01D, var49, var23, var27);
            var6.func_78374_a(var33, (double)(p_147767_3_ + 1) + 0.01D, var49, var23, var31);
            var6.func_78374_a(var37, (double)(p_147767_3_ + 1) + 0.01D, var51, var25, var31);
            var6.func_78374_a(var33, (double)(p_147767_3_ + 1) + 0.01D, var51, var25, var27);
            var6.func_78374_a(var33, (double)(p_147767_3_ + 1) + 0.01D, var49, var23, var27);
            var6.func_78374_a(var37, (double)(p_147767_3_ + 1) + 0.01D, var49, var23, var31);
         } else {
            if(p_147767_3_ < var5 - 1 && this.field_147845_a.func_147437_c(p_147767_2_ - 1, p_147767_3_ + 1, p_147767_4_)) {
               var6.func_78374_a(var33, (double)(p_147767_3_ + 1) + 0.01D, var51, var25, var29);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 1) + 0.01D, var51, var25, var31);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 1) + 0.01D, var49, var23, var31);
               var6.func_78374_a(var33, (double)(p_147767_3_ + 1) + 0.01D, var49, var23, var29);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 1) + 0.01D, var51, var25, var29);
               var6.func_78374_a(var33, (double)(p_147767_3_ + 1) + 0.01D, var51, var25, var31);
               var6.func_78374_a(var33, (double)(p_147767_3_ + 1) + 0.01D, var49, var23, var31);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 1) + 0.01D, var49, var23, var29);
            }

            if(p_147767_3_ < var5 - 1 && this.field_147845_a.func_147437_c(p_147767_2_ + 1, p_147767_3_ + 1, p_147767_4_)) {
               var6.func_78374_a(var35, (double)(p_147767_3_ + 1) + 0.01D, var51, var25, var27);
               var6.func_78374_a(var37, (double)(p_147767_3_ + 1) + 0.01D, var51, var25, var29);
               var6.func_78374_a(var37, (double)(p_147767_3_ + 1) + 0.01D, var49, var23, var29);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 1) + 0.01D, var49, var23, var27);
               var6.func_78374_a(var37, (double)(p_147767_3_ + 1) + 0.01D, var51, var25, var27);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 1) + 0.01D, var51, var25, var29);
               var6.func_78374_a(var35, (double)(p_147767_3_ + 1) + 0.01D, var49, var23, var29);
               var6.func_78374_a(var37, (double)(p_147767_3_ + 1) + 0.01D, var49, var23, var27);
            }
         }

         if(var58) {
            var6.func_78374_a(var33, (double)p_147767_3_ - 0.01D, var51, var25, var31);
            var6.func_78374_a(var37, (double)p_147767_3_ - 0.01D, var51, var25, var27);
            var6.func_78374_a(var37, (double)p_147767_3_ - 0.01D, var49, var23, var27);
            var6.func_78374_a(var33, (double)p_147767_3_ - 0.01D, var49, var23, var31);
            var6.func_78374_a(var37, (double)p_147767_3_ - 0.01D, var51, var25, var31);
            var6.func_78374_a(var33, (double)p_147767_3_ - 0.01D, var51, var25, var27);
            var6.func_78374_a(var33, (double)p_147767_3_ - 0.01D, var49, var23, var27);
            var6.func_78374_a(var37, (double)p_147767_3_ - 0.01D, var49, var23, var31);
         } else {
            if(p_147767_3_ > 1 && this.field_147845_a.func_147437_c(p_147767_2_ - 1, p_147767_3_ - 1, p_147767_4_)) {
               var6.func_78374_a(var33, (double)p_147767_3_ - 0.01D, var51, var25, var29);
               var6.func_78374_a(var35, (double)p_147767_3_ - 0.01D, var51, var25, var31);
               var6.func_78374_a(var35, (double)p_147767_3_ - 0.01D, var49, var23, var31);
               var6.func_78374_a(var33, (double)p_147767_3_ - 0.01D, var49, var23, var29);
               var6.func_78374_a(var35, (double)p_147767_3_ - 0.01D, var51, var25, var29);
               var6.func_78374_a(var33, (double)p_147767_3_ - 0.01D, var51, var25, var31);
               var6.func_78374_a(var33, (double)p_147767_3_ - 0.01D, var49, var23, var31);
               var6.func_78374_a(var35, (double)p_147767_3_ - 0.01D, var49, var23, var29);
            }

            if(p_147767_3_ > 1 && this.field_147845_a.func_147437_c(p_147767_2_ + 1, p_147767_3_ - 1, p_147767_4_)) {
               var6.func_78374_a(var35, (double)p_147767_3_ - 0.01D, var51, var25, var27);
               var6.func_78374_a(var37, (double)p_147767_3_ - 0.01D, var51, var25, var29);
               var6.func_78374_a(var37, (double)p_147767_3_ - 0.01D, var49, var23, var29);
               var6.func_78374_a(var35, (double)p_147767_3_ - 0.01D, var49, var23, var27);
               var6.func_78374_a(var37, (double)p_147767_3_ - 0.01D, var51, var25, var27);
               var6.func_78374_a(var35, (double)p_147767_3_ - 0.01D, var51, var25, var29);
               var6.func_78374_a(var35, (double)p_147767_3_ - 0.01D, var49, var23, var29);
               var6.func_78374_a(var37, (double)p_147767_3_ - 0.01D, var49, var23, var27);
            }
         }
      }

      if((!var53 || !var54) && (var55 || var56 || var53 || var54)) {
         if(var53 && !var54) {
            var6.func_78374_a(var35, (double)(p_147767_3_ + 1), var39, var66, var19);
            var6.func_78374_a(var35, (double)(p_147767_3_ + 0), var39, var66, var21);
            var6.func_78374_a(var35, (double)(p_147767_3_ + 0), var41, var15, var21);
            var6.func_78374_a(var35, (double)(p_147767_3_ + 1), var41, var15, var19);
            var6.func_78374_a(var35, (double)(p_147767_3_ + 1), var41, var66, var19);
            var6.func_78374_a(var35, (double)(p_147767_3_ + 0), var41, var66, var21);
            var6.func_78374_a(var35, (double)(p_147767_3_ + 0), var39, var15, var21);
            var6.func_78374_a(var35, (double)(p_147767_3_ + 1), var39, var15, var19);
            if(!var56 && !var55) {
               var6.func_78374_a(var45, (double)(p_147767_3_ + 1), var41, var23, var27);
               var6.func_78374_a(var45, (double)(p_147767_3_ + 0), var41, var23, var31);
               var6.func_78374_a(var47, (double)(p_147767_3_ + 0), var41, var25, var31);
               var6.func_78374_a(var47, (double)(p_147767_3_ + 1), var41, var25, var27);
               var6.func_78374_a(var47, (double)(p_147767_3_ + 1), var41, var23, var27);
               var6.func_78374_a(var47, (double)(p_147767_3_ + 0), var41, var23, var31);
               var6.func_78374_a(var45, (double)(p_147767_3_ + 0), var41, var25, var31);
               var6.func_78374_a(var45, (double)(p_147767_3_ + 1), var41, var25, var27);
            }

            if(var57 || p_147767_3_ < var5 - 1 && this.field_147845_a.func_147437_c(p_147767_2_, p_147767_3_ + 1, p_147767_4_ - 1)) {
               var6.func_78374_a(var45, (double)(p_147767_3_ + 1) + 0.005D, var39, var25, var27);
               var6.func_78374_a(var45, (double)(p_147767_3_ + 1) + 0.005D, var41, var25, var29);
               var6.func_78374_a(var47, (double)(p_147767_3_ + 1) + 0.005D, var41, var23, var29);
               var6.func_78374_a(var47, (double)(p_147767_3_ + 1) + 0.005D, var39, var23, var27);
               var6.func_78374_a(var45, (double)(p_147767_3_ + 1) + 0.005D, var41, var25, var27);
               var6.func_78374_a(var45, (double)(p_147767_3_ + 1) + 0.005D, var39, var25, var29);
               var6.func_78374_a(var47, (double)(p_147767_3_ + 1) + 0.005D, var39, var23, var29);
               var6.func_78374_a(var47, (double)(p_147767_3_ + 1) + 0.005D, var41, var23, var27);
            }

            if(var58 || p_147767_3_ > 1 && this.field_147845_a.func_147437_c(p_147767_2_, p_147767_3_ - 1, p_147767_4_ - 1)) {
               var6.func_78374_a(var45, (double)p_147767_3_ - 0.005D, var39, var25, var27);
               var6.func_78374_a(var45, (double)p_147767_3_ - 0.005D, var41, var25, var29);
               var6.func_78374_a(var47, (double)p_147767_3_ - 0.005D, var41, var23, var29);
               var6.func_78374_a(var47, (double)p_147767_3_ - 0.005D, var39, var23, var27);
               var6.func_78374_a(var45, (double)p_147767_3_ - 0.005D, var41, var25, var27);
               var6.func_78374_a(var45, (double)p_147767_3_ - 0.005D, var39, var25, var29);
               var6.func_78374_a(var47, (double)p_147767_3_ - 0.005D, var39, var23, var29);
               var6.func_78374_a(var47, (double)p_147767_3_ - 0.005D, var41, var23, var27);
            }
         } else if(!var53 && var54) {
            var6.func_78374_a(var35, (double)(p_147767_3_ + 1), var41, var15, var19);
            var6.func_78374_a(var35, (double)(p_147767_3_ + 0), var41, var15, var21);
            var6.func_78374_a(var35, (double)(p_147767_3_ + 0), var43, var17, var21);
            var6.func_78374_a(var35, (double)(p_147767_3_ + 1), var43, var17, var19);
            var6.func_78374_a(var35, (double)(p_147767_3_ + 1), var43, var15, var19);
            var6.func_78374_a(var35, (double)(p_147767_3_ + 0), var43, var15, var21);
            var6.func_78374_a(var35, (double)(p_147767_3_ + 0), var41, var17, var21);
            var6.func_78374_a(var35, (double)(p_147767_3_ + 1), var41, var17, var19);
            if(!var56 && !var55) {
               var6.func_78374_a(var47, (double)(p_147767_3_ + 1), var41, var23, var27);
               var6.func_78374_a(var47, (double)(p_147767_3_ + 0), var41, var23, var31);
               var6.func_78374_a(var45, (double)(p_147767_3_ + 0), var41, var25, var31);
               var6.func_78374_a(var45, (double)(p_147767_3_ + 1), var41, var25, var27);
               var6.func_78374_a(var45, (double)(p_147767_3_ + 1), var41, var23, var27);
               var6.func_78374_a(var45, (double)(p_147767_3_ + 0), var41, var23, var31);
               var6.func_78374_a(var47, (double)(p_147767_3_ + 0), var41, var25, var31);
               var6.func_78374_a(var47, (double)(p_147767_3_ + 1), var41, var25, var27);
            }

            if(var57 || p_147767_3_ < var5 - 1 && this.field_147845_a.func_147437_c(p_147767_2_, p_147767_3_ + 1, p_147767_4_ + 1)) {
               var6.func_78374_a(var45, (double)(p_147767_3_ + 1) + 0.005D, var41, var23, var29);
               var6.func_78374_a(var45, (double)(p_147767_3_ + 1) + 0.005D, var43, var23, var31);
               var6.func_78374_a(var47, (double)(p_147767_3_ + 1) + 0.005D, var43, var25, var31);
               var6.func_78374_a(var47, (double)(p_147767_3_ + 1) + 0.005D, var41, var25, var29);
               var6.func_78374_a(var45, (double)(p_147767_3_ + 1) + 0.005D, var43, var23, var29);
               var6.func_78374_a(var45, (double)(p_147767_3_ + 1) + 0.005D, var41, var23, var31);
               var6.func_78374_a(var47, (double)(p_147767_3_ + 1) + 0.005D, var41, var25, var31);
               var6.func_78374_a(var47, (double)(p_147767_3_ + 1) + 0.005D, var43, var25, var29);
            }

            if(var58 || p_147767_3_ > 1 && this.field_147845_a.func_147437_c(p_147767_2_, p_147767_3_ - 1, p_147767_4_ + 1)) {
               var6.func_78374_a(var45, (double)p_147767_3_ - 0.005D, var41, var23, var29);
               var6.func_78374_a(var45, (double)p_147767_3_ - 0.005D, var43, var23, var31);
               var6.func_78374_a(var47, (double)p_147767_3_ - 0.005D, var43, var25, var31);
               var6.func_78374_a(var47, (double)p_147767_3_ - 0.005D, var41, var25, var29);
               var6.func_78374_a(var45, (double)p_147767_3_ - 0.005D, var43, var23, var29);
               var6.func_78374_a(var45, (double)p_147767_3_ - 0.005D, var41, var23, var31);
               var6.func_78374_a(var47, (double)p_147767_3_ - 0.005D, var41, var25, var31);
               var6.func_78374_a(var47, (double)p_147767_3_ - 0.005D, var43, var25, var29);
            }
         }
      } else {
         var6.func_78374_a(var35, (double)(p_147767_3_ + 1), var43, var66, var19);
         var6.func_78374_a(var35, (double)(p_147767_3_ + 0), var43, var66, var21);
         var6.func_78374_a(var35, (double)(p_147767_3_ + 0), var39, var17, var21);
         var6.func_78374_a(var35, (double)(p_147767_3_ + 1), var39, var17, var19);
         var6.func_78374_a(var35, (double)(p_147767_3_ + 1), var39, var66, var19);
         var6.func_78374_a(var35, (double)(p_147767_3_ + 0), var39, var66, var21);
         var6.func_78374_a(var35, (double)(p_147767_3_ + 0), var43, var17, var21);
         var6.func_78374_a(var35, (double)(p_147767_3_ + 1), var43, var17, var19);
         if(var57) {
            var6.func_78374_a(var47, (double)(p_147767_3_ + 1) + 0.005D, var43, var25, var31);
            var6.func_78374_a(var47, (double)(p_147767_3_ + 1) + 0.005D, var39, var25, var27);
            var6.func_78374_a(var45, (double)(p_147767_3_ + 1) + 0.005D, var39, var23, var27);
            var6.func_78374_a(var45, (double)(p_147767_3_ + 1) + 0.005D, var43, var23, var31);
            var6.func_78374_a(var47, (double)(p_147767_3_ + 1) + 0.005D, var39, var25, var31);
            var6.func_78374_a(var47, (double)(p_147767_3_ + 1) + 0.005D, var43, var25, var27);
            var6.func_78374_a(var45, (double)(p_147767_3_ + 1) + 0.005D, var43, var23, var27);
            var6.func_78374_a(var45, (double)(p_147767_3_ + 1) + 0.005D, var39, var23, var31);
         } else {
            if(p_147767_3_ < var5 - 1 && this.field_147845_a.func_147437_c(p_147767_2_, p_147767_3_ + 1, p_147767_4_ - 1)) {
               var6.func_78374_a(var45, (double)(p_147767_3_ + 1) + 0.005D, var39, var25, var27);
               var6.func_78374_a(var45, (double)(p_147767_3_ + 1) + 0.005D, var41, var25, var29);
               var6.func_78374_a(var47, (double)(p_147767_3_ + 1) + 0.005D, var41, var23, var29);
               var6.func_78374_a(var47, (double)(p_147767_3_ + 1) + 0.005D, var39, var23, var27);
               var6.func_78374_a(var45, (double)(p_147767_3_ + 1) + 0.005D, var41, var25, var27);
               var6.func_78374_a(var45, (double)(p_147767_3_ + 1) + 0.005D, var39, var25, var29);
               var6.func_78374_a(var47, (double)(p_147767_3_ + 1) + 0.005D, var39, var23, var29);
               var6.func_78374_a(var47, (double)(p_147767_3_ + 1) + 0.005D, var41, var23, var27);
            }

            if(p_147767_3_ < var5 - 1 && this.field_147845_a.func_147437_c(p_147767_2_, p_147767_3_ + 1, p_147767_4_ + 1)) {
               var6.func_78374_a(var45, (double)(p_147767_3_ + 1) + 0.005D, var41, var23, var29);
               var6.func_78374_a(var45, (double)(p_147767_3_ + 1) + 0.005D, var43, var23, var31);
               var6.func_78374_a(var47, (double)(p_147767_3_ + 1) + 0.005D, var43, var25, var31);
               var6.func_78374_a(var47, (double)(p_147767_3_ + 1) + 0.005D, var41, var25, var29);
               var6.func_78374_a(var45, (double)(p_147767_3_ + 1) + 0.005D, var43, var23, var29);
               var6.func_78374_a(var45, (double)(p_147767_3_ + 1) + 0.005D, var41, var23, var31);
               var6.func_78374_a(var47, (double)(p_147767_3_ + 1) + 0.005D, var41, var25, var31);
               var6.func_78374_a(var47, (double)(p_147767_3_ + 1) + 0.005D, var43, var25, var29);
            }
         }

         if(var58) {
            var6.func_78374_a(var47, (double)p_147767_3_ - 0.005D, var43, var25, var31);
            var6.func_78374_a(var47, (double)p_147767_3_ - 0.005D, var39, var25, var27);
            var6.func_78374_a(var45, (double)p_147767_3_ - 0.005D, var39, var23, var27);
            var6.func_78374_a(var45, (double)p_147767_3_ - 0.005D, var43, var23, var31);
            var6.func_78374_a(var47, (double)p_147767_3_ - 0.005D, var39, var25, var31);
            var6.func_78374_a(var47, (double)p_147767_3_ - 0.005D, var43, var25, var27);
            var6.func_78374_a(var45, (double)p_147767_3_ - 0.005D, var43, var23, var27);
            var6.func_78374_a(var45, (double)p_147767_3_ - 0.005D, var39, var23, var31);
         } else {
            if(p_147767_3_ > 1 && this.field_147845_a.func_147437_c(p_147767_2_, p_147767_3_ - 1, p_147767_4_ - 1)) {
               var6.func_78374_a(var45, (double)p_147767_3_ - 0.005D, var39, var25, var27);
               var6.func_78374_a(var45, (double)p_147767_3_ - 0.005D, var41, var25, var29);
               var6.func_78374_a(var47, (double)p_147767_3_ - 0.005D, var41, var23, var29);
               var6.func_78374_a(var47, (double)p_147767_3_ - 0.005D, var39, var23, var27);
               var6.func_78374_a(var45, (double)p_147767_3_ - 0.005D, var41, var25, var27);
               var6.func_78374_a(var45, (double)p_147767_3_ - 0.005D, var39, var25, var29);
               var6.func_78374_a(var47, (double)p_147767_3_ - 0.005D, var39, var23, var29);
               var6.func_78374_a(var47, (double)p_147767_3_ - 0.005D, var41, var23, var27);
            }

            if(p_147767_3_ > 1 && this.field_147845_a.func_147437_c(p_147767_2_, p_147767_3_ - 1, p_147767_4_ + 1)) {
               var6.func_78374_a(var45, (double)p_147767_3_ - 0.005D, var41, var23, var29);
               var6.func_78374_a(var45, (double)p_147767_3_ - 0.005D, var43, var23, var31);
               var6.func_78374_a(var47, (double)p_147767_3_ - 0.005D, var43, var25, var31);
               var6.func_78374_a(var47, (double)p_147767_3_ - 0.005D, var41, var25, var29);
               var6.func_78374_a(var45, (double)p_147767_3_ - 0.005D, var43, var23, var29);
               var6.func_78374_a(var45, (double)p_147767_3_ - 0.005D, var41, var23, var31);
               var6.func_78374_a(var47, (double)p_147767_3_ - 0.005D, var41, var25, var31);
               var6.func_78374_a(var47, (double)p_147767_3_ - 0.005D, var43, var25, var29);
            }
         }
      }

      return true;
   }

   public boolean func_147746_l(Block p_147746_1_, int p_147746_2_, int p_147746_3_, int p_147746_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      var5.func_78380_c(p_147746_1_.func_149677_c(this.field_147845_a, p_147746_2_, p_147746_3_, p_147746_4_));
      int var6 = p_147746_1_.func_149720_d(this.field_147845_a, p_147746_2_, p_147746_3_, p_147746_4_);
      float var7 = (float)(var6 >> 16 & 255) / 255.0F;
      float var8 = (float)(var6 >> 8 & 255) / 255.0F;
      float var9 = (float)(var6 & 255) / 255.0F;
      if(EntityRenderer.field_78517_a) {
         float var10 = (var7 * 30.0F + var8 * 59.0F + var9 * 11.0F) / 100.0F;
         float var11 = (var7 * 30.0F + var8 * 70.0F) / 100.0F;
         float var12 = (var7 * 30.0F + var9 * 70.0F) / 100.0F;
         var7 = var10;
         var8 = var11;
         var9 = var12;
      }

      var5.func_78386_a(var7, var8, var9);
      double var18 = (double)p_147746_2_;
      double var19 = (double)p_147746_3_;
      double var14 = (double)p_147746_4_;
      long var16;
      if(p_147746_1_ == Blocks.field_150329_H) {
         var16 = (long)(p_147746_2_ * 3129871) ^ (long)p_147746_4_ * 116129781L ^ (long)p_147746_3_;
         var16 = var16 * var16 * 42317861L + var16 * 11L;
         var18 += ((double)((float)(var16 >> 16 & 15L) / 15.0F) - 0.5D) * 0.5D;
         var19 += ((double)((float)(var16 >> 20 & 15L) / 15.0F) - 1.0D) * 0.2D;
         var14 += ((double)((float)(var16 >> 24 & 15L) / 15.0F) - 0.5D) * 0.5D;
      } else if(p_147746_1_ == Blocks.field_150328_O || p_147746_1_ == Blocks.field_150327_N) {
         var16 = (long)(p_147746_2_ * 3129871) ^ (long)p_147746_4_ * 116129781L ^ (long)p_147746_3_;
         var16 = var16 * var16 * 42317861L + var16 * 11L;
         var18 += ((double)((float)(var16 >> 16 & 15L) / 15.0F) - 0.5D) * 0.3D;
         var14 += ((double)((float)(var16 >> 24 & 15L) / 15.0F) - 0.5D) * 0.3D;
      }

      IIcon var20 = this.func_147787_a(p_147746_1_, 0, this.field_147845_a.func_72805_g(p_147746_2_, p_147746_3_, p_147746_4_));
      this.func_147765_a(var20, var18, var19, var14, 1.0F);
      return true;
   }

   public boolean func_147774_a(BlockDoublePlant p_147774_1_, int p_147774_2_, int p_147774_3_, int p_147774_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      var5.func_78380_c(p_147774_1_.func_149677_c(this.field_147845_a, p_147774_2_, p_147774_3_, p_147774_4_));
      int var6 = p_147774_1_.func_149720_d(this.field_147845_a, p_147774_2_, p_147774_3_, p_147774_4_);
      float var7 = (float)(var6 >> 16 & 255) / 255.0F;
      float var8 = (float)(var6 >> 8 & 255) / 255.0F;
      float var9 = (float)(var6 & 255) / 255.0F;
      if(EntityRenderer.field_78517_a) {
         float var10 = (var7 * 30.0F + var8 * 59.0F + var9 * 11.0F) / 100.0F;
         float var11 = (var7 * 30.0F + var8 * 70.0F) / 100.0F;
         float var12 = (var7 * 30.0F + var9 * 70.0F) / 100.0F;
         var7 = var10;
         var8 = var11;
         var9 = var12;
      }

      var5.func_78386_a(var7, var8, var9);
      long var58 = (long)(p_147774_2_ * 3129871) ^ (long)p_147774_4_ * 116129781L;
      var58 = var58 * var58 * 42317861L + var58 * 11L;
      double var59 = (double)p_147774_2_;
      double var14 = (double)p_147774_3_;
      double var16 = (double)p_147774_4_;
      var59 += ((double)((float)(var58 >> 16 & 15L) / 15.0F) - 0.5D) * 0.3D;
      var16 += ((double)((float)(var58 >> 24 & 15L) / 15.0F) - 0.5D) * 0.3D;
      int var18 = this.field_147845_a.func_72805_g(p_147774_2_, p_147774_3_, p_147774_4_);
      boolean var19 = false;
      boolean var20 = BlockDoublePlant.func_149887_c(var18);
      int var60;
      if(var20) {
         if(this.field_147845_a.func_147439_a(p_147774_2_, p_147774_3_ - 1, p_147774_4_) != p_147774_1_) {
            return false;
         }

         var60 = BlockDoublePlant.func_149890_d(this.field_147845_a.func_72805_g(p_147774_2_, p_147774_3_ - 1, p_147774_4_));
      } else {
         var60 = BlockDoublePlant.func_149890_d(var18);
      }

      IIcon var21 = p_147774_1_.func_149888_a(var20, var60);
      this.func_147765_a(var21, var59, var14, var16, 1.0F);
      if(var20 && var60 == 0) {
         IIcon var22 = p_147774_1_.field_149891_b[0];
         double var23 = Math.cos((double)var58 * 0.8D) * 3.141592653589793D * 0.1D;
         double var25 = Math.cos(var23);
         double var27 = Math.sin(var23);
         double var29 = (double)var22.func_94209_e();
         double var31 = (double)var22.func_94206_g();
         double var33 = (double)var22.func_94212_f();
         double var35 = (double)var22.func_94210_h();
         double var37 = 0.3D;
         double var39 = -0.05D;
         double var41 = 0.5D + 0.3D * var25 - 0.5D * var27;
         double var43 = 0.5D + 0.5D * var25 + 0.3D * var27;
         double var45 = 0.5D + 0.3D * var25 + 0.5D * var27;
         double var47 = 0.5D + -0.5D * var25 + 0.3D * var27;
         double var49 = 0.5D + -0.05D * var25 + 0.5D * var27;
         double var51 = 0.5D + -0.5D * var25 + -0.05D * var27;
         double var53 = 0.5D + -0.05D * var25 - 0.5D * var27;
         double var55 = 0.5D + 0.5D * var25 + -0.05D * var27;
         var5.func_78374_a(var59 + var49, var14 + 1.0D, var16 + var51, var29, var35);
         var5.func_78374_a(var59 + var53, var14 + 1.0D, var16 + var55, var33, var35);
         var5.func_78374_a(var59 + var41, var14 + 0.0D, var16 + var43, var33, var31);
         var5.func_78374_a(var59 + var45, var14 + 0.0D, var16 + var47, var29, var31);
         IIcon var57 = p_147774_1_.field_149891_b[1];
         var29 = (double)var57.func_94209_e();
         var31 = (double)var57.func_94206_g();
         var33 = (double)var57.func_94212_f();
         var35 = (double)var57.func_94210_h();
         var5.func_78374_a(var59 + var53, var14 + 1.0D, var16 + var55, var29, var35);
         var5.func_78374_a(var59 + var49, var14 + 1.0D, var16 + var51, var33, var35);
         var5.func_78374_a(var59 + var45, var14 + 0.0D, var16 + var47, var33, var31);
         var5.func_78374_a(var59 + var41, var14 + 0.0D, var16 + var43, var29, var31);
      }

      return true;
   }

   public boolean func_147724_m(Block p_147724_1_, int p_147724_2_, int p_147724_3_, int p_147724_4_) {
      BlockStem var5 = (BlockStem)p_147724_1_;
      Tessellator var6 = Tessellator.field_78398_a;
      var6.func_78380_c(var5.func_149677_c(this.field_147845_a, p_147724_2_, p_147724_3_, p_147724_4_));
      int var7 = var5.func_149720_d(this.field_147845_a, p_147724_2_, p_147724_3_, p_147724_4_);
      float var8 = (float)(var7 >> 16 & 255) / 255.0F;
      float var9 = (float)(var7 >> 8 & 255) / 255.0F;
      float var10 = (float)(var7 & 255) / 255.0F;
      if(EntityRenderer.field_78517_a) {
         float var11 = (var8 * 30.0F + var9 * 59.0F + var10 * 11.0F) / 100.0F;
         float var12 = (var8 * 30.0F + var9 * 70.0F) / 100.0F;
         float var13 = (var8 * 30.0F + var10 * 70.0F) / 100.0F;
         var8 = var11;
         var9 = var12;
         var10 = var13;
      }

      var6.func_78386_a(var8, var9, var10);
      var5.func_149719_a(this.field_147845_a, p_147724_2_, p_147724_3_, p_147724_4_);
      int var14 = var5.func_149873_e(this.field_147845_a, p_147724_2_, p_147724_3_, p_147724_4_);
      if(var14 < 0) {
         this.func_147730_a(var5, this.field_147845_a.func_72805_g(p_147724_2_, p_147724_3_, p_147724_4_), this.field_147857_k, (double)p_147724_2_, (double)((float)p_147724_3_ - 0.0625F), (double)p_147724_4_);
      } else {
         this.func_147730_a(var5, this.field_147845_a.func_72805_g(p_147724_2_, p_147724_3_, p_147724_4_), 0.5D, (double)p_147724_2_, (double)((float)p_147724_3_ - 0.0625F), (double)p_147724_4_);
         this.func_147740_a(var5, this.field_147845_a.func_72805_g(p_147724_2_, p_147724_3_, p_147724_4_), var14, this.field_147857_k, (double)p_147724_2_, (double)((float)p_147724_3_ - 0.0625F), (double)p_147724_4_);
      }

      return true;
   }

   public boolean func_147796_n(Block p_147796_1_, int p_147796_2_, int p_147796_3_, int p_147796_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      var5.func_78380_c(p_147796_1_.func_149677_c(this.field_147845_a, p_147796_2_, p_147796_3_, p_147796_4_));
      var5.func_78386_a(1.0F, 1.0F, 1.0F);
      this.func_147795_a(p_147796_1_, this.field_147845_a.func_72805_g(p_147796_2_, p_147796_3_, p_147796_4_), (double)p_147796_2_, (double)((float)p_147796_3_ - 0.0625F), (double)p_147796_4_);
      return true;
   }

   public void func_147747_a(Block p_147747_1_, double p_147747_2_, double p_147747_4_, double p_147747_6_, double p_147747_8_, double p_147747_10_, int p_147747_12_) {
      Tessellator var13 = Tessellator.field_78398_a;
      IIcon var14 = this.func_147787_a(p_147747_1_, 0, p_147747_12_);
      if(this.func_147744_b()) {
         var14 = this.field_147840_d;
      }

      double var15 = (double)var14.func_94209_e();
      double var17 = (double)var14.func_94206_g();
      double var19 = (double)var14.func_94212_f();
      double var21 = (double)var14.func_94210_h();
      double var23 = (double)var14.func_94214_a(7.0D);
      double var25 = (double)var14.func_94207_b(6.0D);
      double var27 = (double)var14.func_94214_a(9.0D);
      double var29 = (double)var14.func_94207_b(8.0D);
      double var31 = (double)var14.func_94214_a(7.0D);
      double var33 = (double)var14.func_94207_b(13.0D);
      double var35 = (double)var14.func_94214_a(9.0D);
      double var37 = (double)var14.func_94207_b(15.0D);
      p_147747_2_ += 0.5D;
      p_147747_6_ += 0.5D;
      double var39 = p_147747_2_ - 0.5D;
      double var41 = p_147747_2_ + 0.5D;
      double var43 = p_147747_6_ - 0.5D;
      double var45 = p_147747_6_ + 0.5D;
      double var47 = 0.0625D;
      double var49 = 0.625D;
      var13.func_78374_a(p_147747_2_ + p_147747_8_ * (1.0D - var49) - var47, p_147747_4_ + var49, p_147747_6_ + p_147747_10_ * (1.0D - var49) - var47, var23, var25);
      var13.func_78374_a(p_147747_2_ + p_147747_8_ * (1.0D - var49) - var47, p_147747_4_ + var49, p_147747_6_ + p_147747_10_ * (1.0D - var49) + var47, var23, var29);
      var13.func_78374_a(p_147747_2_ + p_147747_8_ * (1.0D - var49) + var47, p_147747_4_ + var49, p_147747_6_ + p_147747_10_ * (1.0D - var49) + var47, var27, var29);
      var13.func_78374_a(p_147747_2_ + p_147747_8_ * (1.0D - var49) + var47, p_147747_4_ + var49, p_147747_6_ + p_147747_10_ * (1.0D - var49) - var47, var27, var25);
      var13.func_78374_a(p_147747_2_ + var47 + p_147747_8_, p_147747_4_, p_147747_6_ - var47 + p_147747_10_, var35, var33);
      var13.func_78374_a(p_147747_2_ + var47 + p_147747_8_, p_147747_4_, p_147747_6_ + var47 + p_147747_10_, var35, var37);
      var13.func_78374_a(p_147747_2_ - var47 + p_147747_8_, p_147747_4_, p_147747_6_ + var47 + p_147747_10_, var31, var37);
      var13.func_78374_a(p_147747_2_ - var47 + p_147747_8_, p_147747_4_, p_147747_6_ - var47 + p_147747_10_, var31, var33);
      var13.func_78374_a(p_147747_2_ - var47, p_147747_4_ + 1.0D, var43, var15, var17);
      var13.func_78374_a(p_147747_2_ - var47 + p_147747_8_, p_147747_4_ + 0.0D, var43 + p_147747_10_, var15, var21);
      var13.func_78374_a(p_147747_2_ - var47 + p_147747_8_, p_147747_4_ + 0.0D, var45 + p_147747_10_, var19, var21);
      var13.func_78374_a(p_147747_2_ - var47, p_147747_4_ + 1.0D, var45, var19, var17);
      var13.func_78374_a(p_147747_2_ + var47, p_147747_4_ + 1.0D, var45, var15, var17);
      var13.func_78374_a(p_147747_2_ + p_147747_8_ + var47, p_147747_4_ + 0.0D, var45 + p_147747_10_, var15, var21);
      var13.func_78374_a(p_147747_2_ + p_147747_8_ + var47, p_147747_4_ + 0.0D, var43 + p_147747_10_, var19, var21);
      var13.func_78374_a(p_147747_2_ + var47, p_147747_4_ + 1.0D, var43, var19, var17);
      var13.func_78374_a(var39, p_147747_4_ + 1.0D, p_147747_6_ + var47, var15, var17);
      var13.func_78374_a(var39 + p_147747_8_, p_147747_4_ + 0.0D, p_147747_6_ + var47 + p_147747_10_, var15, var21);
      var13.func_78374_a(var41 + p_147747_8_, p_147747_4_ + 0.0D, p_147747_6_ + var47 + p_147747_10_, var19, var21);
      var13.func_78374_a(var41, p_147747_4_ + 1.0D, p_147747_6_ + var47, var19, var17);
      var13.func_78374_a(var41, p_147747_4_ + 1.0D, p_147747_6_ - var47, var15, var17);
      var13.func_78374_a(var41 + p_147747_8_, p_147747_4_ + 0.0D, p_147747_6_ - var47 + p_147747_10_, var15, var21);
      var13.func_78374_a(var39 + p_147747_8_, p_147747_4_ + 0.0D, p_147747_6_ - var47 + p_147747_10_, var19, var21);
      var13.func_78374_a(var39, p_147747_4_ + 1.0D, p_147747_6_ - var47, var19, var17);
   }

   public void func_147765_a(IIcon p_147765_1_, double p_147765_2_, double p_147765_4_, double p_147765_6_, float p_147765_8_) {
      Tessellator var9 = Tessellator.field_78398_a;
      if(this.func_147744_b()) {
         p_147765_1_ = this.field_147840_d;
      }

      double var10 = (double)p_147765_1_.func_94209_e();
      double var12 = (double)p_147765_1_.func_94206_g();
      double var14 = (double)p_147765_1_.func_94212_f();
      double var16 = (double)p_147765_1_.func_94210_h();
      double var18 = 0.45D * (double)p_147765_8_;
      double var20 = p_147765_2_ + 0.5D - var18;
      double var22 = p_147765_2_ + 0.5D + var18;
      double var24 = p_147765_6_ + 0.5D - var18;
      double var26 = p_147765_6_ + 0.5D + var18;
      var9.func_78374_a(var20, p_147765_4_ + (double)p_147765_8_, var24, var10, var12);
      var9.func_78374_a(var20, p_147765_4_ + 0.0D, var24, var10, var16);
      var9.func_78374_a(var22, p_147765_4_ + 0.0D, var26, var14, var16);
      var9.func_78374_a(var22, p_147765_4_ + (double)p_147765_8_, var26, var14, var12);
      var9.func_78374_a(var22, p_147765_4_ + (double)p_147765_8_, var26, var10, var12);
      var9.func_78374_a(var22, p_147765_4_ + 0.0D, var26, var10, var16);
      var9.func_78374_a(var20, p_147765_4_ + 0.0D, var24, var14, var16);
      var9.func_78374_a(var20, p_147765_4_ + (double)p_147765_8_, var24, var14, var12);
      var9.func_78374_a(var20, p_147765_4_ + (double)p_147765_8_, var26, var10, var12);
      var9.func_78374_a(var20, p_147765_4_ + 0.0D, var26, var10, var16);
      var9.func_78374_a(var22, p_147765_4_ + 0.0D, var24, var14, var16);
      var9.func_78374_a(var22, p_147765_4_ + (double)p_147765_8_, var24, var14, var12);
      var9.func_78374_a(var22, p_147765_4_ + (double)p_147765_8_, var24, var10, var12);
      var9.func_78374_a(var22, p_147765_4_ + 0.0D, var24, var10, var16);
      var9.func_78374_a(var20, p_147765_4_ + 0.0D, var26, var14, var16);
      var9.func_78374_a(var20, p_147765_4_ + (double)p_147765_8_, var26, var14, var12);
   }

   public void func_147730_a(Block p_147730_1_, int p_147730_2_, double p_147730_3_, double p_147730_5_, double p_147730_7_, double p_147730_9_) {
      Tessellator var11 = Tessellator.field_78398_a;
      IIcon var12 = this.func_147787_a(p_147730_1_, 0, p_147730_2_);
      if(this.func_147744_b()) {
         var12 = this.field_147840_d;
      }

      double var13 = (double)var12.func_94209_e();
      double var15 = (double)var12.func_94206_g();
      double var17 = (double)var12.func_94212_f();
      double var19 = (double)var12.func_94207_b(p_147730_3_ * 16.0D);
      double var21 = p_147730_5_ + 0.5D - 0.44999998807907104D;
      double var23 = p_147730_5_ + 0.5D + 0.44999998807907104D;
      double var25 = p_147730_9_ + 0.5D - 0.44999998807907104D;
      double var27 = p_147730_9_ + 0.5D + 0.44999998807907104D;
      var11.func_78374_a(var21, p_147730_7_ + p_147730_3_, var25, var13, var15);
      var11.func_78374_a(var21, p_147730_7_ + 0.0D, var25, var13, var19);
      var11.func_78374_a(var23, p_147730_7_ + 0.0D, var27, var17, var19);
      var11.func_78374_a(var23, p_147730_7_ + p_147730_3_, var27, var17, var15);
      var11.func_78374_a(var23, p_147730_7_ + p_147730_3_, var27, var17, var15);
      var11.func_78374_a(var23, p_147730_7_ + 0.0D, var27, var17, var19);
      var11.func_78374_a(var21, p_147730_7_ + 0.0D, var25, var13, var19);
      var11.func_78374_a(var21, p_147730_7_ + p_147730_3_, var25, var13, var15);
      var11.func_78374_a(var21, p_147730_7_ + p_147730_3_, var27, var13, var15);
      var11.func_78374_a(var21, p_147730_7_ + 0.0D, var27, var13, var19);
      var11.func_78374_a(var23, p_147730_7_ + 0.0D, var25, var17, var19);
      var11.func_78374_a(var23, p_147730_7_ + p_147730_3_, var25, var17, var15);
      var11.func_78374_a(var23, p_147730_7_ + p_147730_3_, var25, var17, var15);
      var11.func_78374_a(var23, p_147730_7_ + 0.0D, var25, var17, var19);
      var11.func_78374_a(var21, p_147730_7_ + 0.0D, var27, var13, var19);
      var11.func_78374_a(var21, p_147730_7_ + p_147730_3_, var27, var13, var15);
   }

   public boolean func_147783_o(Block p_147783_1_, int p_147783_2_, int p_147783_3_, int p_147783_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      IIcon var6 = this.func_147777_a(p_147783_1_, 1);
      if(this.func_147744_b()) {
         var6 = this.field_147840_d;
      }

      float var7 = 0.015625F;
      double var8 = (double)var6.func_94209_e();
      double var10 = (double)var6.func_94206_g();
      double var12 = (double)var6.func_94212_f();
      double var14 = (double)var6.func_94210_h();
      long var16 = (long)(p_147783_2_ * 3129871) ^ (long)p_147783_4_ * 116129781L ^ (long)p_147783_3_;
      var16 = var16 * var16 * 42317861L + var16 * 11L;
      int var18 = (int)(var16 >> 16 & 3L);
      var5.func_78380_c(p_147783_1_.func_149677_c(this.field_147845_a, p_147783_2_, p_147783_3_, p_147783_4_));
      float var19 = (float)p_147783_2_ + 0.5F;
      float var20 = (float)p_147783_4_ + 0.5F;
      float var21 = (float)(var18 & 1) * 0.5F * (float)(1 - var18 / 2 % 2 * 2);
      float var22 = (float)(var18 + 1 & 1) * 0.5F * (float)(1 - (var18 + 1) / 2 % 2 * 2);
      var5.func_78378_d(p_147783_1_.func_149635_D());
      var5.func_78374_a((double)(var19 + var21 - var22), (double)((float)p_147783_3_ + var7), (double)(var20 + var21 + var22), var8, var10);
      var5.func_78374_a((double)(var19 + var21 + var22), (double)((float)p_147783_3_ + var7), (double)(var20 - var21 + var22), var12, var10);
      var5.func_78374_a((double)(var19 - var21 + var22), (double)((float)p_147783_3_ + var7), (double)(var20 - var21 - var22), var12, var14);
      var5.func_78374_a((double)(var19 - var21 - var22), (double)((float)p_147783_3_ + var7), (double)(var20 + var21 - var22), var8, var14);
      var5.func_78378_d((p_147783_1_.func_149635_D() & 16711422) >> 1);
      var5.func_78374_a((double)(var19 - var21 - var22), (double)((float)p_147783_3_ + var7), (double)(var20 + var21 - var22), var8, var14);
      var5.func_78374_a((double)(var19 - var21 + var22), (double)((float)p_147783_3_ + var7), (double)(var20 - var21 - var22), var12, var14);
      var5.func_78374_a((double)(var19 + var21 + var22), (double)((float)p_147783_3_ + var7), (double)(var20 - var21 + var22), var12, var10);
      var5.func_78374_a((double)(var19 + var21 - var22), (double)((float)p_147783_3_ + var7), (double)(var20 + var21 + var22), var8, var10);
      return true;
   }

   public void func_147740_a(BlockStem p_147740_1_, int p_147740_2_, int p_147740_3_, double p_147740_4_, double p_147740_6_, double p_147740_8_, double p_147740_10_) {
      Tessellator var12 = Tessellator.field_78398_a;
      IIcon var13 = p_147740_1_.func_149872_i();
      if(this.func_147744_b()) {
         var13 = this.field_147840_d;
      }

      double var14 = (double)var13.func_94209_e();
      double var16 = (double)var13.func_94206_g();
      double var18 = (double)var13.func_94212_f();
      double var20 = (double)var13.func_94210_h();
      double var22 = p_147740_6_ + 0.5D - 0.5D;
      double var24 = p_147740_6_ + 0.5D + 0.5D;
      double var26 = p_147740_10_ + 0.5D - 0.5D;
      double var28 = p_147740_10_ + 0.5D + 0.5D;
      double var30 = p_147740_6_ + 0.5D;
      double var32 = p_147740_10_ + 0.5D;
      if((p_147740_3_ + 1) / 2 % 2 == 1) {
         double var34 = var18;
         var18 = var14;
         var14 = var34;
      }

      if(p_147740_3_ < 2) {
         var12.func_78374_a(var22, p_147740_8_ + p_147740_4_, var32, var14, var16);
         var12.func_78374_a(var22, p_147740_8_ + 0.0D, var32, var14, var20);
         var12.func_78374_a(var24, p_147740_8_ + 0.0D, var32, var18, var20);
         var12.func_78374_a(var24, p_147740_8_ + p_147740_4_, var32, var18, var16);
         var12.func_78374_a(var24, p_147740_8_ + p_147740_4_, var32, var18, var16);
         var12.func_78374_a(var24, p_147740_8_ + 0.0D, var32, var18, var20);
         var12.func_78374_a(var22, p_147740_8_ + 0.0D, var32, var14, var20);
         var12.func_78374_a(var22, p_147740_8_ + p_147740_4_, var32, var14, var16);
      } else {
         var12.func_78374_a(var30, p_147740_8_ + p_147740_4_, var28, var14, var16);
         var12.func_78374_a(var30, p_147740_8_ + 0.0D, var28, var14, var20);
         var12.func_78374_a(var30, p_147740_8_ + 0.0D, var26, var18, var20);
         var12.func_78374_a(var30, p_147740_8_ + p_147740_4_, var26, var18, var16);
         var12.func_78374_a(var30, p_147740_8_ + p_147740_4_, var26, var18, var16);
         var12.func_78374_a(var30, p_147740_8_ + 0.0D, var26, var18, var20);
         var12.func_78374_a(var30, p_147740_8_ + 0.0D, var28, var14, var20);
         var12.func_78374_a(var30, p_147740_8_ + p_147740_4_, var28, var14, var16);
      }

   }

   public void func_147795_a(Block p_147795_1_, int p_147795_2_, double p_147795_3_, double p_147795_5_, double p_147795_7_) {
      Tessellator var9 = Tessellator.field_78398_a;
      IIcon var10 = this.func_147787_a(p_147795_1_, 0, p_147795_2_);
      if(this.func_147744_b()) {
         var10 = this.field_147840_d;
      }

      double var11 = (double)var10.func_94209_e();
      double var13 = (double)var10.func_94206_g();
      double var15 = (double)var10.func_94212_f();
      double var17 = (double)var10.func_94210_h();
      double var19 = p_147795_3_ + 0.5D - 0.25D;
      double var21 = p_147795_3_ + 0.5D + 0.25D;
      double var23 = p_147795_7_ + 0.5D - 0.5D;
      double var25 = p_147795_7_ + 0.5D + 0.5D;
      var9.func_78374_a(var19, p_147795_5_ + 1.0D, var23, var11, var13);
      var9.func_78374_a(var19, p_147795_5_ + 0.0D, var23, var11, var17);
      var9.func_78374_a(var19, p_147795_5_ + 0.0D, var25, var15, var17);
      var9.func_78374_a(var19, p_147795_5_ + 1.0D, var25, var15, var13);
      var9.func_78374_a(var19, p_147795_5_ + 1.0D, var25, var11, var13);
      var9.func_78374_a(var19, p_147795_5_ + 0.0D, var25, var11, var17);
      var9.func_78374_a(var19, p_147795_5_ + 0.0D, var23, var15, var17);
      var9.func_78374_a(var19, p_147795_5_ + 1.0D, var23, var15, var13);
      var9.func_78374_a(var21, p_147795_5_ + 1.0D, var25, var11, var13);
      var9.func_78374_a(var21, p_147795_5_ + 0.0D, var25, var11, var17);
      var9.func_78374_a(var21, p_147795_5_ + 0.0D, var23, var15, var17);
      var9.func_78374_a(var21, p_147795_5_ + 1.0D, var23, var15, var13);
      var9.func_78374_a(var21, p_147795_5_ + 1.0D, var23, var11, var13);
      var9.func_78374_a(var21, p_147795_5_ + 0.0D, var23, var11, var17);
      var9.func_78374_a(var21, p_147795_5_ + 0.0D, var25, var15, var17);
      var9.func_78374_a(var21, p_147795_5_ + 1.0D, var25, var15, var13);
      var19 = p_147795_3_ + 0.5D - 0.5D;
      var21 = p_147795_3_ + 0.5D + 0.5D;
      var23 = p_147795_7_ + 0.5D - 0.25D;
      var25 = p_147795_7_ + 0.5D + 0.25D;
      var9.func_78374_a(var19, p_147795_5_ + 1.0D, var23, var11, var13);
      var9.func_78374_a(var19, p_147795_5_ + 0.0D, var23, var11, var17);
      var9.func_78374_a(var21, p_147795_5_ + 0.0D, var23, var15, var17);
      var9.func_78374_a(var21, p_147795_5_ + 1.0D, var23, var15, var13);
      var9.func_78374_a(var21, p_147795_5_ + 1.0D, var23, var11, var13);
      var9.func_78374_a(var21, p_147795_5_ + 0.0D, var23, var11, var17);
      var9.func_78374_a(var19, p_147795_5_ + 0.0D, var23, var15, var17);
      var9.func_78374_a(var19, p_147795_5_ + 1.0D, var23, var15, var13);
      var9.func_78374_a(var21, p_147795_5_ + 1.0D, var25, var11, var13);
      var9.func_78374_a(var21, p_147795_5_ + 0.0D, var25, var11, var17);
      var9.func_78374_a(var19, p_147795_5_ + 0.0D, var25, var15, var17);
      var9.func_78374_a(var19, p_147795_5_ + 1.0D, var25, var15, var13);
      var9.func_78374_a(var19, p_147795_5_ + 1.0D, var25, var11, var13);
      var9.func_78374_a(var19, p_147795_5_ + 0.0D, var25, var11, var17);
      var9.func_78374_a(var21, p_147795_5_ + 0.0D, var25, var15, var17);
      var9.func_78374_a(var21, p_147795_5_ + 1.0D, var25, var15, var13);
   }

   public boolean func_147721_p(Block p_147721_1_, int p_147721_2_, int p_147721_3_, int p_147721_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      int var6 = p_147721_1_.func_149720_d(this.field_147845_a, p_147721_2_, p_147721_3_, p_147721_4_);
      float var7 = (float)(var6 >> 16 & 255) / 255.0F;
      float var8 = (float)(var6 >> 8 & 255) / 255.0F;
      float var9 = (float)(var6 & 255) / 255.0F;
      boolean var10 = p_147721_1_.func_149646_a(this.field_147845_a, p_147721_2_, p_147721_3_ + 1, p_147721_4_, 1);
      boolean var11 = p_147721_1_.func_149646_a(this.field_147845_a, p_147721_2_, p_147721_3_ - 1, p_147721_4_, 0);
      boolean[] var12 = new boolean[]{p_147721_1_.func_149646_a(this.field_147845_a, p_147721_2_, p_147721_3_, p_147721_4_ - 1, 2), p_147721_1_.func_149646_a(this.field_147845_a, p_147721_2_, p_147721_3_, p_147721_4_ + 1, 3), p_147721_1_.func_149646_a(this.field_147845_a, p_147721_2_ - 1, p_147721_3_, p_147721_4_, 4), p_147721_1_.func_149646_a(this.field_147845_a, p_147721_2_ + 1, p_147721_3_, p_147721_4_, 5)};
      if(!var10 && !var11 && !var12[0] && !var12[1] && !var12[2] && !var12[3]) {
         return false;
      } else {
         boolean var13 = false;
         float var14 = 0.5F;
         float var15 = 1.0F;
         float var16 = 0.8F;
         float var17 = 0.6F;
         double var18 = 0.0D;
         double var20 = 1.0D;
         Material var22 = p_147721_1_.func_149688_o();
         int var23 = this.field_147845_a.func_72805_g(p_147721_2_, p_147721_3_, p_147721_4_);
         double var24 = (double)this.func_147729_a(p_147721_2_, p_147721_3_, p_147721_4_, var22);
         double var26 = (double)this.func_147729_a(p_147721_2_, p_147721_3_, p_147721_4_ + 1, var22);
         double var28 = (double)this.func_147729_a(p_147721_2_ + 1, p_147721_3_, p_147721_4_ + 1, var22);
         double var30 = (double)this.func_147729_a(p_147721_2_ + 1, p_147721_3_, p_147721_4_, var22);
         double var32 = 0.0010000000474974513D;
         float var52;
         float var53;
         float var54;
         if(this.field_147837_f || var10) {
            var13 = true;
            IIcon var34 = this.func_147787_a(p_147721_1_, 1, var23);
            float var35 = (float)BlockLiquid.func_149802_a(this.field_147845_a, p_147721_2_, p_147721_3_, p_147721_4_, var22);
            if(var35 > -999.0F) {
               var34 = this.func_147787_a(p_147721_1_, 2, var23);
            }

            var24 -= var32;
            var26 -= var32;
            var28 -= var32;
            var30 -= var32;
            double var36;
            double var38;
            double var40;
            double var42;
            double var44;
            double var46;
            double var48;
            double var50;
            if(var35 < -999.0F) {
               var36 = (double)var34.func_94214_a(0.0D);
               var44 = (double)var34.func_94207_b(0.0D);
               var38 = var36;
               var46 = (double)var34.func_94207_b(16.0D);
               var40 = (double)var34.func_94214_a(16.0D);
               var48 = var46;
               var42 = var40;
               var50 = var44;
            } else {
               var52 = MathHelper.func_76126_a(var35) * 0.25F;
               var53 = MathHelper.func_76134_b(var35) * 0.25F;
               var54 = 8.0F;
               var36 = (double)var34.func_94214_a((double)(8.0F + (-var53 - var52) * 16.0F));
               var44 = (double)var34.func_94207_b((double)(8.0F + (-var53 + var52) * 16.0F));
               var38 = (double)var34.func_94214_a((double)(8.0F + (-var53 + var52) * 16.0F));
               var46 = (double)var34.func_94207_b((double)(8.0F + (var53 + var52) * 16.0F));
               var40 = (double)var34.func_94214_a((double)(8.0F + (var53 + var52) * 16.0F));
               var48 = (double)var34.func_94207_b((double)(8.0F + (var53 - var52) * 16.0F));
               var42 = (double)var34.func_94214_a((double)(8.0F + (var53 - var52) * 16.0F));
               var50 = (double)var34.func_94207_b((double)(8.0F + (-var53 - var52) * 16.0F));
            }

            var5.func_78380_c(p_147721_1_.func_149677_c(this.field_147845_a, p_147721_2_, p_147721_3_, p_147721_4_));
            var5.func_78386_a(var15 * var7, var15 * var8, var15 * var9);
            var5.func_78374_a((double)(p_147721_2_ + 0), (double)p_147721_3_ + var24, (double)(p_147721_4_ + 0), var36, var44);
            var5.func_78374_a((double)(p_147721_2_ + 0), (double)p_147721_3_ + var26, (double)(p_147721_4_ + 1), var38, var46);
            var5.func_78374_a((double)(p_147721_2_ + 1), (double)p_147721_3_ + var28, (double)(p_147721_4_ + 1), var40, var48);
            var5.func_78374_a((double)(p_147721_2_ + 1), (double)p_147721_3_ + var30, (double)(p_147721_4_ + 0), var42, var50);
            var5.func_78374_a((double)(p_147721_2_ + 0), (double)p_147721_3_ + var24, (double)(p_147721_4_ + 0), var36, var44);
            var5.func_78374_a((double)(p_147721_2_ + 1), (double)p_147721_3_ + var30, (double)(p_147721_4_ + 0), var42, var50);
            var5.func_78374_a((double)(p_147721_2_ + 1), (double)p_147721_3_ + var28, (double)(p_147721_4_ + 1), var40, var48);
            var5.func_78374_a((double)(p_147721_2_ + 0), (double)p_147721_3_ + var26, (double)(p_147721_4_ + 1), var38, var46);
         }

         if(this.field_147837_f || var11) {
            var5.func_78380_c(p_147721_1_.func_149677_c(this.field_147845_a, p_147721_2_, p_147721_3_ - 1, p_147721_4_));
            var5.func_78386_a(var14, var14, var14);
            this.func_147768_a(p_147721_1_, (double)p_147721_2_, (double)p_147721_3_ + var32, (double)p_147721_4_, this.func_147777_a(p_147721_1_, 0));
            var13 = true;
         }

         for(int var57 = 0; var57 < 4; ++var57) {
            int var58 = p_147721_2_;
            int var37 = p_147721_4_;
            if(var57 == 0) {
               var37 = p_147721_4_ - 1;
            }

            if(var57 == 1) {
               ++var37;
            }

            if(var57 == 2) {
               var58 = p_147721_2_ - 1;
            }

            if(var57 == 3) {
               ++var58;
            }

            IIcon var59 = this.func_147787_a(p_147721_1_, var57 + 2, var23);
            if(this.field_147837_f || var12[var57]) {
               double var39;
               double var41;
               double var43;
               double var45;
               double var47;
               double var49;
               if(var57 == 0) {
                  var39 = var24;
                  var41 = var30;
                  var43 = (double)p_147721_2_;
                  var47 = (double)(p_147721_2_ + 1);
                  var45 = (double)p_147721_4_ + var32;
                  var49 = (double)p_147721_4_ + var32;
               } else if(var57 == 1) {
                  var39 = var28;
                  var41 = var26;
                  var43 = (double)(p_147721_2_ + 1);
                  var47 = (double)p_147721_2_;
                  var45 = (double)(p_147721_4_ + 1) - var32;
                  var49 = (double)(p_147721_4_ + 1) - var32;
               } else if(var57 == 2) {
                  var39 = var26;
                  var41 = var24;
                  var43 = (double)p_147721_2_ + var32;
                  var47 = (double)p_147721_2_ + var32;
                  var45 = (double)(p_147721_4_ + 1);
                  var49 = (double)p_147721_4_;
               } else {
                  var39 = var30;
                  var41 = var28;
                  var43 = (double)(p_147721_2_ + 1) - var32;
                  var47 = (double)(p_147721_2_ + 1) - var32;
                  var45 = (double)p_147721_4_;
                  var49 = (double)(p_147721_4_ + 1);
               }

               var13 = true;
               float var51 = var59.func_94214_a(0.0D);
               var52 = var59.func_94214_a(8.0D);
               var53 = var59.func_94207_b((1.0D - var39) * 16.0D * 0.5D);
               var54 = var59.func_94207_b((1.0D - var41) * 16.0D * 0.5D);
               float var55 = var59.func_94207_b(8.0D);
               var5.func_78380_c(p_147721_1_.func_149677_c(this.field_147845_a, var58, p_147721_3_, var37));
               float var56 = 1.0F;
               var56 *= var57 < 2?var16:var17;
               var5.func_78386_a(var15 * var56 * var7, var15 * var56 * var8, var15 * var56 * var9);
               var5.func_78374_a(var43, (double)p_147721_3_ + var39, var45, (double)var51, (double)var53);
               var5.func_78374_a(var47, (double)p_147721_3_ + var41, var49, (double)var52, (double)var54);
               var5.func_78374_a(var47, (double)(p_147721_3_ + 0), var49, (double)var52, (double)var55);
               var5.func_78374_a(var43, (double)(p_147721_3_ + 0), var45, (double)var51, (double)var55);
               var5.func_78374_a(var43, (double)(p_147721_3_ + 0), var45, (double)var51, (double)var55);
               var5.func_78374_a(var47, (double)(p_147721_3_ + 0), var49, (double)var52, (double)var55);
               var5.func_78374_a(var47, (double)p_147721_3_ + var41, var49, (double)var52, (double)var54);
               var5.func_78374_a(var43, (double)p_147721_3_ + var39, var45, (double)var51, (double)var53);
            }
         }

         this.field_147855_j = var18;
         this.field_147857_k = var20;
         return var13;
      }
   }

   private float func_147729_a(int p_147729_1_, int p_147729_2_, int p_147729_3_, Material p_147729_4_) {
      int var5 = 0;
      float var6 = 0.0F;

      for(int var7 = 0; var7 < 4; ++var7) {
         int var8 = p_147729_1_ - (var7 & 1);
         int var10 = p_147729_3_ - (var7 >> 1 & 1);
         if(this.field_147845_a.func_147439_a(var8, p_147729_2_ + 1, var10).func_149688_o() == p_147729_4_) {
            return 1.0F;
         }

         Material var11 = this.field_147845_a.func_147439_a(var8, p_147729_2_, var10).func_149688_o();
         if(var11 == p_147729_4_) {
            int var12 = this.field_147845_a.func_72805_g(var8, p_147729_2_, var10);
            if(var12 >= 8 || var12 == 0) {
               var6 += BlockLiquid.func_149801_b(var12) * 10.0F;
               var5 += 10;
            }

            var6 += BlockLiquid.func_149801_b(var12);
            ++var5;
         } else if(!var11.func_76220_a()) {
            ++var6;
            ++var5;
         }
      }

      return 1.0F - var6 / (float)var5;
   }

   public void func_147749_a(Block p_147749_1_, World p_147749_2_, int p_147749_3_, int p_147749_4_, int p_147749_5_, int p_147749_6_) {
      float var7 = 0.5F;
      float var8 = 1.0F;
      float var9 = 0.8F;
      float var10 = 0.6F;
      Tessellator var11 = Tessellator.field_78398_a;
      var11.func_78382_b();
      var11.func_78380_c(p_147749_1_.func_149677_c(p_147749_2_, p_147749_3_, p_147749_4_, p_147749_5_));
      var11.func_78386_a(var7, var7, var7);
      this.func_147768_a(p_147749_1_, -0.5D, -0.5D, -0.5D, this.func_147787_a(p_147749_1_, 0, p_147749_6_));
      var11.func_78386_a(var8, var8, var8);
      this.func_147806_b(p_147749_1_, -0.5D, -0.5D, -0.5D, this.func_147787_a(p_147749_1_, 1, p_147749_6_));
      var11.func_78386_a(var9, var9, var9);
      this.func_147761_c(p_147749_1_, -0.5D, -0.5D, -0.5D, this.func_147787_a(p_147749_1_, 2, p_147749_6_));
      var11.func_78386_a(var9, var9, var9);
      this.func_147734_d(p_147749_1_, -0.5D, -0.5D, -0.5D, this.func_147787_a(p_147749_1_, 3, p_147749_6_));
      var11.func_78386_a(var10, var10, var10);
      this.func_147798_e(p_147749_1_, -0.5D, -0.5D, -0.5D, this.func_147787_a(p_147749_1_, 4, p_147749_6_));
      var11.func_78386_a(var10, var10, var10);
      this.func_147764_f(p_147749_1_, -0.5D, -0.5D, -0.5D, this.func_147787_a(p_147749_1_, 5, p_147749_6_));
      var11.func_78381_a();
   }

   public boolean func_147784_q(Block p_147784_1_, int p_147784_2_, int p_147784_3_, int p_147784_4_) {
      int var5 = p_147784_1_.func_149720_d(this.field_147845_a, p_147784_2_, p_147784_3_, p_147784_4_);
      float var6 = (float)(var5 >> 16 & 255) / 255.0F;
      float var7 = (float)(var5 >> 8 & 255) / 255.0F;
      float var8 = (float)(var5 & 255) / 255.0F;
      if(EntityRenderer.field_78517_a) {
         float var9 = (var6 * 30.0F + var7 * 59.0F + var8 * 11.0F) / 100.0F;
         float var10 = (var6 * 30.0F + var7 * 70.0F) / 100.0F;
         float var11 = (var6 * 30.0F + var8 * 70.0F) / 100.0F;
         var6 = var9;
         var7 = var10;
         var8 = var11;
      }

      return Minecraft.func_71379_u() && p_147784_1_.func_149750_m() == 0?(this.field_147849_o?this.func_147808_b(p_147784_1_, p_147784_2_, p_147784_3_, p_147784_4_, var6, var7, var8):this.func_147751_a(p_147784_1_, p_147784_2_, p_147784_3_, p_147784_4_, var6, var7, var8)):this.func_147736_d(p_147784_1_, p_147784_2_, p_147784_3_, p_147784_4_, var6, var7, var8);
   }

   public boolean func_147742_r(Block p_147742_1_, int p_147742_2_, int p_147742_3_, int p_147742_4_) {
      int var5 = this.field_147845_a.func_72805_g(p_147742_2_, p_147742_3_, p_147742_4_);
      int var6 = var5 & 12;
      if(var6 == 4) {
         this.field_147875_q = 1;
         this.field_147873_r = 1;
         this.field_147867_u = 1;
         this.field_147865_v = 1;
      } else if(var6 == 8) {
         this.field_147871_s = 1;
         this.field_147869_t = 1;
      }

      boolean var7 = this.func_147784_q(p_147742_1_, p_147742_2_, p_147742_3_, p_147742_4_);
      this.field_147871_s = 0;
      this.field_147875_q = 0;
      this.field_147873_r = 0;
      this.field_147869_t = 0;
      this.field_147867_u = 0;
      this.field_147865_v = 0;
      return var7;
   }

   public boolean func_147779_s(Block p_147779_1_, int p_147779_2_, int p_147779_3_, int p_147779_4_) {
      int var5 = this.field_147845_a.func_72805_g(p_147779_2_, p_147779_3_, p_147779_4_);
      if(var5 == 3) {
         this.field_147875_q = 1;
         this.field_147873_r = 1;
         this.field_147867_u = 1;
         this.field_147865_v = 1;
      } else if(var5 == 4) {
         this.field_147871_s = 1;
         this.field_147869_t = 1;
      }

      boolean var6 = this.func_147784_q(p_147779_1_, p_147779_2_, p_147779_3_, p_147779_4_);
      this.field_147871_s = 0;
      this.field_147875_q = 0;
      this.field_147873_r = 0;
      this.field_147869_t = 0;
      this.field_147867_u = 0;
      this.field_147865_v = 0;
      return var6;
   }

   public boolean func_147751_a(Block p_147751_1_, int p_147751_2_, int p_147751_3_, int p_147751_4_, float p_147751_5_, float p_147751_6_, float p_147751_7_) {
      this.field_147863_w = true;
      boolean var8 = false;
      float var9 = 0.0F;
      float var10 = 0.0F;
      float var11 = 0.0F;
      float var12 = 0.0F;
      boolean var13 = true;
      int var14 = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_);
      Tessellator var15 = Tessellator.field_78398_a;
      var15.func_78380_c(983055);
      if(this.func_147745_b(p_147751_1_).func_94215_i().equals("grass_top")) {
         var13 = false;
      } else if(this.func_147744_b()) {
         var13 = false;
      }

      boolean var16;
      boolean var17;
      boolean var18;
      boolean var19;
      int var20;
      float var21;
      if(this.field_147837_f || p_147751_1_.func_149646_a(this.field_147845_a, p_147751_2_, p_147751_3_ - 1, p_147751_4_, 0)) {
         if(this.field_147855_j <= 0.0D) {
            --p_147751_3_;
         }

         this.field_147831_S = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ - 1, p_147751_3_, p_147751_4_);
         this.field_147825_U = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_ - 1);
         this.field_147828_V = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_ + 1);
         this.field_147835_X = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ + 1, p_147751_3_, p_147751_4_);
         this.field_147886_y = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_).func_149685_I();
         this.field_147814_A = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_, p_147751_4_ - 1).func_149685_I();
         this.field_147815_B = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_, p_147751_4_ + 1).func_149685_I();
         this.field_147810_D = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_).func_149685_I();
         var16 = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_ - 1, p_147751_4_).func_149751_l();
         var17 = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_ - 1, p_147751_4_).func_149751_l();
         var18 = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_ + 1).func_149751_l();
         var19 = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_ - 1).func_149751_l();
         if(!var19 && !var17) {
            this.field_147888_x = this.field_147886_y;
            this.field_147832_R = this.field_147831_S;
         } else {
            this.field_147888_x = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_ - 1).func_149685_I();
            this.field_147832_R = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ - 1, p_147751_3_, p_147751_4_ - 1);
         }

         if(!var18 && !var17) {
            this.field_147884_z = this.field_147886_y;
            this.field_147826_T = this.field_147831_S;
         } else {
            this.field_147884_z = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_ + 1).func_149685_I();
            this.field_147826_T = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ - 1, p_147751_3_, p_147751_4_ + 1);
         }

         if(!var19 && !var16) {
            this.field_147816_C = this.field_147810_D;
            this.field_147827_W = this.field_147835_X;
         } else {
            this.field_147816_C = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_ - 1).func_149685_I();
            this.field_147827_W = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ + 1, p_147751_3_, p_147751_4_ - 1);
         }

         if(!var18 && !var16) {
            this.field_147811_E = this.field_147810_D;
            this.field_147834_Y = this.field_147835_X;
         } else {
            this.field_147811_E = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_ + 1).func_149685_I();
            this.field_147834_Y = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ + 1, p_147751_3_, p_147751_4_ + 1);
         }

         if(this.field_147855_j <= 0.0D) {
            ++p_147751_3_;
         }

         var20 = var14;
         if(this.field_147855_j <= 0.0D || !this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_).func_149662_c()) {
            var20 = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ - 1, p_147751_4_);
         }

         var21 = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_).func_149685_I();
         var9 = (this.field_147884_z + this.field_147886_y + this.field_147815_B + var21) / 4.0F;
         var12 = (this.field_147815_B + var21 + this.field_147811_E + this.field_147810_D) / 4.0F;
         var11 = (var21 + this.field_147814_A + this.field_147810_D + this.field_147816_C) / 4.0F;
         var10 = (this.field_147886_y + this.field_147888_x + var21 + this.field_147814_A) / 4.0F;
         this.field_147864_al = this.func_147778_a(this.field_147826_T, this.field_147831_S, this.field_147828_V, var20);
         this.field_147870_ao = this.func_147778_a(this.field_147828_V, this.field_147834_Y, this.field_147835_X, var20);
         this.field_147876_an = this.func_147778_a(this.field_147825_U, this.field_147835_X, this.field_147827_W, var20);
         this.field_147874_am = this.func_147778_a(this.field_147831_S, this.field_147832_R, this.field_147825_U, var20);
         if(var13) {
            this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = p_147751_5_ * 0.5F;
            this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = p_147751_6_ * 0.5F;
            this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = p_147751_7_ * 0.5F;
         } else {
            this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = 0.5F;
            this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = 0.5F;
            this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = 0.5F;
         }

         this.field_147872_ap *= var9;
         this.field_147846_at *= var9;
         this.field_147854_ax *= var9;
         this.field_147852_aq *= var10;
         this.field_147860_au *= var10;
         this.field_147841_ay *= var10;
         this.field_147850_ar *= var11;
         this.field_147858_av *= var11;
         this.field_147839_az *= var11;
         this.field_147848_as *= var12;
         this.field_147856_aw *= var12;
         this.field_147833_aA *= var12;
         this.func_147768_a(p_147751_1_, (double)p_147751_2_, (double)p_147751_3_, (double)p_147751_4_, this.func_147793_a(p_147751_1_, this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_, 0));
         var8 = true;
      }

      if(this.field_147837_f || p_147751_1_.func_149646_a(this.field_147845_a, p_147751_2_, p_147751_3_ + 1, p_147751_4_, 1)) {
         if(this.field_147857_k >= 1.0D) {
            ++p_147751_3_;
         }

         this.field_147880_aa = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ - 1, p_147751_3_, p_147751_4_);
         this.field_147885_ae = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ + 1, p_147751_3_, p_147751_4_);
         this.field_147878_ac = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_ - 1);
         this.field_147887_af = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_ + 1);
         this.field_147813_G = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_).func_149685_I();
         this.field_147824_K = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_).func_149685_I();
         this.field_147822_I = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_, p_147751_4_ - 1).func_149685_I();
         this.field_147817_L = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_, p_147751_4_ + 1).func_149685_I();
         var16 = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_ + 1, p_147751_4_).func_149751_l();
         var17 = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_ + 1, p_147751_4_).func_149751_l();
         var18 = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_ + 1).func_149751_l();
         var19 = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_ - 1).func_149751_l();
         if(!var19 && !var17) {
            this.field_147812_F = this.field_147813_G;
            this.field_147836_Z = this.field_147880_aa;
         } else {
            this.field_147812_F = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_ - 1).func_149685_I();
            this.field_147836_Z = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ - 1, p_147751_3_, p_147751_4_ - 1);
         }

         if(!var19 && !var16) {
            this.field_147823_J = this.field_147824_K;
            this.field_147879_ad = this.field_147885_ae;
         } else {
            this.field_147823_J = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_ - 1).func_149685_I();
            this.field_147879_ad = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ + 1, p_147751_3_, p_147751_4_ - 1);
         }

         if(!var18 && !var17) {
            this.field_147821_H = this.field_147813_G;
            this.field_147881_ab = this.field_147880_aa;
         } else {
            this.field_147821_H = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_ + 1).func_149685_I();
            this.field_147881_ab = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ - 1, p_147751_3_, p_147751_4_ + 1);
         }

         if(!var18 && !var16) {
            this.field_147818_M = this.field_147824_K;
            this.field_147882_ag = this.field_147885_ae;
         } else {
            this.field_147818_M = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_ + 1).func_149685_I();
            this.field_147882_ag = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ + 1, p_147751_3_, p_147751_4_ + 1);
         }

         if(this.field_147857_k >= 1.0D) {
            --p_147751_3_;
         }

         var20 = var14;
         if(this.field_147857_k >= 1.0D || !this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_).func_149662_c()) {
            var20 = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ + 1, p_147751_4_);
         }

         var21 = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_).func_149685_I();
         var12 = (this.field_147821_H + this.field_147813_G + this.field_147817_L + var21) / 4.0F;
         var9 = (this.field_147817_L + var21 + this.field_147818_M + this.field_147824_K) / 4.0F;
         var10 = (var21 + this.field_147822_I + this.field_147824_K + this.field_147823_J) / 4.0F;
         var11 = (this.field_147813_G + this.field_147812_F + var21 + this.field_147822_I) / 4.0F;
         this.field_147870_ao = this.func_147778_a(this.field_147881_ab, this.field_147880_aa, this.field_147887_af, var20);
         this.field_147864_al = this.func_147778_a(this.field_147887_af, this.field_147882_ag, this.field_147885_ae, var20);
         this.field_147874_am = this.func_147778_a(this.field_147878_ac, this.field_147885_ae, this.field_147879_ad, var20);
         this.field_147876_an = this.func_147778_a(this.field_147880_aa, this.field_147836_Z, this.field_147878_ac, var20);
         this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = p_147751_5_;
         this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = p_147751_6_;
         this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = p_147751_7_;
         this.field_147872_ap *= var9;
         this.field_147846_at *= var9;
         this.field_147854_ax *= var9;
         this.field_147852_aq *= var10;
         this.field_147860_au *= var10;
         this.field_147841_ay *= var10;
         this.field_147850_ar *= var11;
         this.field_147858_av *= var11;
         this.field_147839_az *= var11;
         this.field_147848_as *= var12;
         this.field_147856_aw *= var12;
         this.field_147833_aA *= var12;
         this.func_147806_b(p_147751_1_, (double)p_147751_2_, (double)p_147751_3_, (double)p_147751_4_, this.func_147793_a(p_147751_1_, this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_, 1));
         var8 = true;
      }

      IIcon var22;
      if(this.field_147837_f || p_147751_1_.func_149646_a(this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_ - 1, 2)) {
         if(this.field_147851_l <= 0.0D) {
            --p_147751_4_;
         }

         this.field_147819_N = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_).func_149685_I();
         this.field_147814_A = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_).func_149685_I();
         this.field_147822_I = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_).func_149685_I();
         this.field_147820_O = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_).func_149685_I();
         this.field_147883_ah = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ - 1, p_147751_3_, p_147751_4_);
         this.field_147825_U = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ - 1, p_147751_4_);
         this.field_147878_ac = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ + 1, p_147751_4_);
         this.field_147866_ai = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ + 1, p_147751_3_, p_147751_4_);
         var16 = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_ - 1).func_149751_l();
         var17 = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_ - 1).func_149751_l();
         var18 = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_ - 1).func_149751_l();
         var19 = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_ - 1).func_149751_l();
         if(!var17 && !var19) {
            this.field_147888_x = this.field_147819_N;
            this.field_147832_R = this.field_147883_ah;
         } else {
            this.field_147888_x = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_ - 1, p_147751_4_).func_149685_I();
            this.field_147832_R = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ - 1, p_147751_3_ - 1, p_147751_4_);
         }

         if(!var17 && !var18) {
            this.field_147812_F = this.field_147819_N;
            this.field_147836_Z = this.field_147883_ah;
         } else {
            this.field_147812_F = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_ + 1, p_147751_4_).func_149685_I();
            this.field_147836_Z = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ - 1, p_147751_3_ + 1, p_147751_4_);
         }

         if(!var16 && !var19) {
            this.field_147816_C = this.field_147820_O;
            this.field_147827_W = this.field_147866_ai;
         } else {
            this.field_147816_C = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_ - 1, p_147751_4_).func_149685_I();
            this.field_147827_W = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ + 1, p_147751_3_ - 1, p_147751_4_);
         }

         if(!var16 && !var18) {
            this.field_147823_J = this.field_147820_O;
            this.field_147879_ad = this.field_147866_ai;
         } else {
            this.field_147823_J = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_ + 1, p_147751_4_).func_149685_I();
            this.field_147879_ad = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ + 1, p_147751_3_ + 1, p_147751_4_);
         }

         if(this.field_147851_l <= 0.0D) {
            ++p_147751_4_;
         }

         var20 = var14;
         if(this.field_147851_l <= 0.0D || !this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_, p_147751_4_ - 1).func_149662_c()) {
            var20 = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_ - 1);
         }

         var21 = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_, p_147751_4_ - 1).func_149685_I();
         var9 = (this.field_147819_N + this.field_147812_F + var21 + this.field_147822_I) / 4.0F;
         var10 = (var21 + this.field_147822_I + this.field_147820_O + this.field_147823_J) / 4.0F;
         var11 = (this.field_147814_A + var21 + this.field_147816_C + this.field_147820_O) / 4.0F;
         var12 = (this.field_147888_x + this.field_147819_N + this.field_147814_A + var21) / 4.0F;
         this.field_147864_al = this.func_147778_a(this.field_147883_ah, this.field_147836_Z, this.field_147878_ac, var20);
         this.field_147874_am = this.func_147778_a(this.field_147878_ac, this.field_147866_ai, this.field_147879_ad, var20);
         this.field_147876_an = this.func_147778_a(this.field_147825_U, this.field_147827_W, this.field_147866_ai, var20);
         this.field_147870_ao = this.func_147778_a(this.field_147832_R, this.field_147883_ah, this.field_147825_U, var20);
         if(var13) {
            this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = p_147751_5_ * 0.8F;
            this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = p_147751_6_ * 0.8F;
            this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = p_147751_7_ * 0.8F;
         } else {
            this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = 0.8F;
            this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = 0.8F;
            this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = 0.8F;
         }

         this.field_147872_ap *= var9;
         this.field_147846_at *= var9;
         this.field_147854_ax *= var9;
         this.field_147852_aq *= var10;
         this.field_147860_au *= var10;
         this.field_147841_ay *= var10;
         this.field_147850_ar *= var11;
         this.field_147858_av *= var11;
         this.field_147839_az *= var11;
         this.field_147848_as *= var12;
         this.field_147856_aw *= var12;
         this.field_147833_aA *= var12;
         var22 = this.func_147793_a(p_147751_1_, this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_, 2);
         this.func_147761_c(p_147751_1_, (double)p_147751_2_, (double)p_147751_3_, (double)p_147751_4_, var22);
         if(field_147843_b && var22.func_94215_i().equals("grass_side") && !this.func_147744_b()) {
            this.field_147872_ap *= p_147751_5_;
            this.field_147852_aq *= p_147751_5_;
            this.field_147850_ar *= p_147751_5_;
            this.field_147848_as *= p_147751_5_;
            this.field_147846_at *= p_147751_6_;
            this.field_147860_au *= p_147751_6_;
            this.field_147858_av *= p_147751_6_;
            this.field_147856_aw *= p_147751_6_;
            this.field_147854_ax *= p_147751_7_;
            this.field_147841_ay *= p_147751_7_;
            this.field_147839_az *= p_147751_7_;
            this.field_147833_aA *= p_147751_7_;
            this.func_147761_c(p_147751_1_, (double)p_147751_2_, (double)p_147751_3_, (double)p_147751_4_, BlockGrass.func_149990_e());
         }

         var8 = true;
      }

      if(this.field_147837_f || p_147751_1_.func_149646_a(this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_ + 1, 3)) {
         if(this.field_147853_m >= 1.0D) {
            ++p_147751_4_;
         }

         this.field_147830_P = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_).func_149685_I();
         this.field_147829_Q = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_).func_149685_I();
         this.field_147815_B = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_).func_149685_I();
         this.field_147817_L = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_).func_149685_I();
         this.field_147868_aj = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ - 1, p_147751_3_, p_147751_4_);
         this.field_147862_ak = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ + 1, p_147751_3_, p_147751_4_);
         this.field_147828_V = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ - 1, p_147751_4_);
         this.field_147887_af = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ + 1, p_147751_4_);
         var16 = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_ + 1).func_149751_l();
         var17 = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_ + 1).func_149751_l();
         var18 = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_ + 1).func_149751_l();
         var19 = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_ + 1).func_149751_l();
         if(!var17 && !var19) {
            this.field_147884_z = this.field_147830_P;
            this.field_147826_T = this.field_147868_aj;
         } else {
            this.field_147884_z = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_ - 1, p_147751_4_).func_149685_I();
            this.field_147826_T = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ - 1, p_147751_3_ - 1, p_147751_4_);
         }

         if(!var17 && !var18) {
            this.field_147821_H = this.field_147830_P;
            this.field_147881_ab = this.field_147868_aj;
         } else {
            this.field_147821_H = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_ + 1, p_147751_4_).func_149685_I();
            this.field_147881_ab = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ - 1, p_147751_3_ + 1, p_147751_4_);
         }

         if(!var16 && !var19) {
            this.field_147811_E = this.field_147829_Q;
            this.field_147834_Y = this.field_147862_ak;
         } else {
            this.field_147811_E = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_ - 1, p_147751_4_).func_149685_I();
            this.field_147834_Y = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ + 1, p_147751_3_ - 1, p_147751_4_);
         }

         if(!var16 && !var18) {
            this.field_147818_M = this.field_147829_Q;
            this.field_147882_ag = this.field_147862_ak;
         } else {
            this.field_147818_M = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_ + 1, p_147751_4_).func_149685_I();
            this.field_147882_ag = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ + 1, p_147751_3_ + 1, p_147751_4_);
         }

         if(this.field_147853_m >= 1.0D) {
            --p_147751_4_;
         }

         var20 = var14;
         if(this.field_147853_m >= 1.0D || !this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_, p_147751_4_ + 1).func_149662_c()) {
            var20 = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_ + 1);
         }

         var21 = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_, p_147751_4_ + 1).func_149685_I();
         var9 = (this.field_147830_P + this.field_147821_H + var21 + this.field_147817_L) / 4.0F;
         var12 = (var21 + this.field_147817_L + this.field_147829_Q + this.field_147818_M) / 4.0F;
         var11 = (this.field_147815_B + var21 + this.field_147811_E + this.field_147829_Q) / 4.0F;
         var10 = (this.field_147884_z + this.field_147830_P + this.field_147815_B + var21) / 4.0F;
         this.field_147864_al = this.func_147778_a(this.field_147868_aj, this.field_147881_ab, this.field_147887_af, var20);
         this.field_147870_ao = this.func_147778_a(this.field_147887_af, this.field_147862_ak, this.field_147882_ag, var20);
         this.field_147876_an = this.func_147778_a(this.field_147828_V, this.field_147834_Y, this.field_147862_ak, var20);
         this.field_147874_am = this.func_147778_a(this.field_147826_T, this.field_147868_aj, this.field_147828_V, var20);
         if(var13) {
            this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = p_147751_5_ * 0.8F;
            this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = p_147751_6_ * 0.8F;
            this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = p_147751_7_ * 0.8F;
         } else {
            this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = 0.8F;
            this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = 0.8F;
            this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = 0.8F;
         }

         this.field_147872_ap *= var9;
         this.field_147846_at *= var9;
         this.field_147854_ax *= var9;
         this.field_147852_aq *= var10;
         this.field_147860_au *= var10;
         this.field_147841_ay *= var10;
         this.field_147850_ar *= var11;
         this.field_147858_av *= var11;
         this.field_147839_az *= var11;
         this.field_147848_as *= var12;
         this.field_147856_aw *= var12;
         this.field_147833_aA *= var12;
         var22 = this.func_147793_a(p_147751_1_, this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_, 3);
         this.func_147734_d(p_147751_1_, (double)p_147751_2_, (double)p_147751_3_, (double)p_147751_4_, this.func_147793_a(p_147751_1_, this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_, 3));
         if(field_147843_b && var22.func_94215_i().equals("grass_side") && !this.func_147744_b()) {
            this.field_147872_ap *= p_147751_5_;
            this.field_147852_aq *= p_147751_5_;
            this.field_147850_ar *= p_147751_5_;
            this.field_147848_as *= p_147751_5_;
            this.field_147846_at *= p_147751_6_;
            this.field_147860_au *= p_147751_6_;
            this.field_147858_av *= p_147751_6_;
            this.field_147856_aw *= p_147751_6_;
            this.field_147854_ax *= p_147751_7_;
            this.field_147841_ay *= p_147751_7_;
            this.field_147839_az *= p_147751_7_;
            this.field_147833_aA *= p_147751_7_;
            this.func_147734_d(p_147751_1_, (double)p_147751_2_, (double)p_147751_3_, (double)p_147751_4_, BlockGrass.func_149990_e());
         }

         var8 = true;
      }

      if(this.field_147837_f || p_147751_1_.func_149646_a(this.field_147845_a, p_147751_2_ - 1, p_147751_3_, p_147751_4_, 4)) {
         if(this.field_147859_h <= 0.0D) {
            --p_147751_2_;
         }

         this.field_147886_y = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_).func_149685_I();
         this.field_147819_N = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_, p_147751_4_ - 1).func_149685_I();
         this.field_147830_P = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_, p_147751_4_ + 1).func_149685_I();
         this.field_147813_G = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_).func_149685_I();
         this.field_147831_S = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ - 1, p_147751_4_);
         this.field_147883_ah = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_ - 1);
         this.field_147868_aj = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_ + 1);
         this.field_147880_aa = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ + 1, p_147751_4_);
         var16 = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_ + 1, p_147751_4_).func_149751_l();
         var17 = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_ - 1, p_147751_4_).func_149751_l();
         var18 = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_ - 1).func_149751_l();
         var19 = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_ + 1).func_149751_l();
         if(!var18 && !var17) {
            this.field_147888_x = this.field_147819_N;
            this.field_147832_R = this.field_147883_ah;
         } else {
            this.field_147888_x = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_ - 1).func_149685_I();
            this.field_147832_R = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ - 1, p_147751_4_ - 1);
         }

         if(!var19 && !var17) {
            this.field_147884_z = this.field_147830_P;
            this.field_147826_T = this.field_147868_aj;
         } else {
            this.field_147884_z = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_ + 1).func_149685_I();
            this.field_147826_T = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ - 1, p_147751_4_ + 1);
         }

         if(!var18 && !var16) {
            this.field_147812_F = this.field_147819_N;
            this.field_147836_Z = this.field_147883_ah;
         } else {
            this.field_147812_F = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_ - 1).func_149685_I();
            this.field_147836_Z = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ + 1, p_147751_4_ - 1);
         }

         if(!var19 && !var16) {
            this.field_147821_H = this.field_147830_P;
            this.field_147881_ab = this.field_147868_aj;
         } else {
            this.field_147821_H = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_ + 1).func_149685_I();
            this.field_147881_ab = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ + 1, p_147751_4_ + 1);
         }

         if(this.field_147859_h <= 0.0D) {
            ++p_147751_2_;
         }

         var20 = var14;
         if(this.field_147859_h <= 0.0D || !this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_).func_149662_c()) {
            var20 = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ - 1, p_147751_3_, p_147751_4_);
         }

         var21 = this.field_147845_a.func_147439_a(p_147751_2_ - 1, p_147751_3_, p_147751_4_).func_149685_I();
         var12 = (this.field_147886_y + this.field_147884_z + var21 + this.field_147830_P) / 4.0F;
         var9 = (var21 + this.field_147830_P + this.field_147813_G + this.field_147821_H) / 4.0F;
         var10 = (this.field_147819_N + var21 + this.field_147812_F + this.field_147813_G) / 4.0F;
         var11 = (this.field_147888_x + this.field_147886_y + this.field_147819_N + var21) / 4.0F;
         this.field_147870_ao = this.func_147778_a(this.field_147831_S, this.field_147826_T, this.field_147868_aj, var20);
         this.field_147864_al = this.func_147778_a(this.field_147868_aj, this.field_147880_aa, this.field_147881_ab, var20);
         this.field_147874_am = this.func_147778_a(this.field_147883_ah, this.field_147836_Z, this.field_147880_aa, var20);
         this.field_147876_an = this.func_147778_a(this.field_147832_R, this.field_147831_S, this.field_147883_ah, var20);
         if(var13) {
            this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = p_147751_5_ * 0.6F;
            this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = p_147751_6_ * 0.6F;
            this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = p_147751_7_ * 0.6F;
         } else {
            this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = 0.6F;
            this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = 0.6F;
            this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = 0.6F;
         }

         this.field_147872_ap *= var9;
         this.field_147846_at *= var9;
         this.field_147854_ax *= var9;
         this.field_147852_aq *= var10;
         this.field_147860_au *= var10;
         this.field_147841_ay *= var10;
         this.field_147850_ar *= var11;
         this.field_147858_av *= var11;
         this.field_147839_az *= var11;
         this.field_147848_as *= var12;
         this.field_147856_aw *= var12;
         this.field_147833_aA *= var12;
         var22 = this.func_147793_a(p_147751_1_, this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_, 4);
         this.func_147798_e(p_147751_1_, (double)p_147751_2_, (double)p_147751_3_, (double)p_147751_4_, var22);
         if(field_147843_b && var22.func_94215_i().equals("grass_side") && !this.func_147744_b()) {
            this.field_147872_ap *= p_147751_5_;
            this.field_147852_aq *= p_147751_5_;
            this.field_147850_ar *= p_147751_5_;
            this.field_147848_as *= p_147751_5_;
            this.field_147846_at *= p_147751_6_;
            this.field_147860_au *= p_147751_6_;
            this.field_147858_av *= p_147751_6_;
            this.field_147856_aw *= p_147751_6_;
            this.field_147854_ax *= p_147751_7_;
            this.field_147841_ay *= p_147751_7_;
            this.field_147839_az *= p_147751_7_;
            this.field_147833_aA *= p_147751_7_;
            this.func_147798_e(p_147751_1_, (double)p_147751_2_, (double)p_147751_3_, (double)p_147751_4_, BlockGrass.func_149990_e());
         }

         var8 = true;
      }

      if(this.field_147837_f || p_147751_1_.func_149646_a(this.field_147845_a, p_147751_2_ + 1, p_147751_3_, p_147751_4_, 5)) {
         if(this.field_147861_i >= 1.0D) {
            ++p_147751_2_;
         }

         this.field_147810_D = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_).func_149685_I();
         this.field_147820_O = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_, p_147751_4_ - 1).func_149685_I();
         this.field_147829_Q = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_, p_147751_4_ + 1).func_149685_I();
         this.field_147824_K = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_).func_149685_I();
         this.field_147835_X = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ - 1, p_147751_4_);
         this.field_147866_ai = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_ - 1);
         this.field_147862_ak = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_ + 1);
         this.field_147885_ae = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ + 1, p_147751_4_);
         var16 = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_ + 1, p_147751_4_).func_149751_l();
         var17 = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_ - 1, p_147751_4_).func_149751_l();
         var18 = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_ + 1).func_149751_l();
         var19 = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_ - 1).func_149751_l();
         if(!var17 && !var19) {
            this.field_147816_C = this.field_147820_O;
            this.field_147827_W = this.field_147866_ai;
         } else {
            this.field_147816_C = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_ - 1).func_149685_I();
            this.field_147827_W = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ - 1, p_147751_4_ - 1);
         }

         if(!var17 && !var18) {
            this.field_147811_E = this.field_147829_Q;
            this.field_147834_Y = this.field_147862_ak;
         } else {
            this.field_147811_E = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ - 1, p_147751_4_ + 1).func_149685_I();
            this.field_147834_Y = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ - 1, p_147751_4_ + 1);
         }

         if(!var16 && !var19) {
            this.field_147823_J = this.field_147820_O;
            this.field_147879_ad = this.field_147866_ai;
         } else {
            this.field_147823_J = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_ - 1).func_149685_I();
            this.field_147879_ad = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ + 1, p_147751_4_ - 1);
         }

         if(!var16 && !var18) {
            this.field_147818_M = this.field_147829_Q;
            this.field_147882_ag = this.field_147862_ak;
         } else {
            this.field_147818_M = this.field_147845_a.func_147439_a(p_147751_2_, p_147751_3_ + 1, p_147751_4_ + 1).func_149685_I();
            this.field_147882_ag = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_, p_147751_3_ + 1, p_147751_4_ + 1);
         }

         if(this.field_147861_i >= 1.0D) {
            --p_147751_2_;
         }

         var20 = var14;
         if(this.field_147861_i >= 1.0D || !this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_).func_149662_c()) {
            var20 = p_147751_1_.func_149677_c(this.field_147845_a, p_147751_2_ + 1, p_147751_3_, p_147751_4_);
         }

         var21 = this.field_147845_a.func_147439_a(p_147751_2_ + 1, p_147751_3_, p_147751_4_).func_149685_I();
         var9 = (this.field_147810_D + this.field_147811_E + var21 + this.field_147829_Q) / 4.0F;
         var10 = (this.field_147816_C + this.field_147810_D + this.field_147820_O + var21) / 4.0F;
         var11 = (this.field_147820_O + var21 + this.field_147823_J + this.field_147824_K) / 4.0F;
         var12 = (var21 + this.field_147829_Q + this.field_147824_K + this.field_147818_M) / 4.0F;
         this.field_147864_al = this.func_147778_a(this.field_147835_X, this.field_147834_Y, this.field_147862_ak, var20);
         this.field_147870_ao = this.func_147778_a(this.field_147862_ak, this.field_147885_ae, this.field_147882_ag, var20);
         this.field_147876_an = this.func_147778_a(this.field_147866_ai, this.field_147879_ad, this.field_147885_ae, var20);
         this.field_147874_am = this.func_147778_a(this.field_147827_W, this.field_147835_X, this.field_147866_ai, var20);
         if(var13) {
            this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = p_147751_5_ * 0.6F;
            this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = p_147751_6_ * 0.6F;
            this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = p_147751_7_ * 0.6F;
         } else {
            this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = 0.6F;
            this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = 0.6F;
            this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = 0.6F;
         }

         this.field_147872_ap *= var9;
         this.field_147846_at *= var9;
         this.field_147854_ax *= var9;
         this.field_147852_aq *= var10;
         this.field_147860_au *= var10;
         this.field_147841_ay *= var10;
         this.field_147850_ar *= var11;
         this.field_147858_av *= var11;
         this.field_147839_az *= var11;
         this.field_147848_as *= var12;
         this.field_147856_aw *= var12;
         this.field_147833_aA *= var12;
         var22 = this.func_147793_a(p_147751_1_, this.field_147845_a, p_147751_2_, p_147751_3_, p_147751_4_, 5);
         this.func_147764_f(p_147751_1_, (double)p_147751_2_, (double)p_147751_3_, (double)p_147751_4_, var22);
         if(field_147843_b && var22.func_94215_i().equals("grass_side") && !this.func_147744_b()) {
            this.field_147872_ap *= p_147751_5_;
            this.field_147852_aq *= p_147751_5_;
            this.field_147850_ar *= p_147751_5_;
            this.field_147848_as *= p_147751_5_;
            this.field_147846_at *= p_147751_6_;
            this.field_147860_au *= p_147751_6_;
            this.field_147858_av *= p_147751_6_;
            this.field_147856_aw *= p_147751_6_;
            this.field_147854_ax *= p_147751_7_;
            this.field_147841_ay *= p_147751_7_;
            this.field_147839_az *= p_147751_7_;
            this.field_147833_aA *= p_147751_7_;
            this.func_147764_f(p_147751_1_, (double)p_147751_2_, (double)p_147751_3_, (double)p_147751_4_, BlockGrass.func_149990_e());
         }

         var8 = true;
      }

      this.field_147863_w = false;
      return var8;
   }

   public boolean func_147808_b(Block p_147808_1_, int p_147808_2_, int p_147808_3_, int p_147808_4_, float p_147808_5_, float p_147808_6_, float p_147808_7_) {
      this.field_147863_w = true;
      boolean var8 = false;
      float var9 = 0.0F;
      float var10 = 0.0F;
      float var11 = 0.0F;
      float var12 = 0.0F;
      boolean var13 = true;
      int var14 = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_);
      Tessellator var15 = Tessellator.field_78398_a;
      var15.func_78380_c(983055);
      if(this.func_147745_b(p_147808_1_).func_94215_i().equals("grass_top")) {
         var13 = false;
      } else if(this.func_147744_b()) {
         var13 = false;
      }

      boolean var16;
      boolean var17;
      boolean var18;
      boolean var19;
      int var20;
      float var21;
      if(this.field_147837_f || p_147808_1_.func_149646_a(this.field_147845_a, p_147808_2_, p_147808_3_ - 1, p_147808_4_, 0)) {
         if(this.field_147855_j <= 0.0D) {
            --p_147808_3_;
         }

         this.field_147831_S = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ - 1, p_147808_3_, p_147808_4_);
         this.field_147825_U = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_ - 1);
         this.field_147828_V = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_ + 1);
         this.field_147835_X = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ + 1, p_147808_3_, p_147808_4_);
         this.field_147886_y = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_).func_149685_I();
         this.field_147814_A = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_, p_147808_4_ - 1).func_149685_I();
         this.field_147815_B = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_, p_147808_4_ + 1).func_149685_I();
         this.field_147810_D = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_).func_149685_I();
         var16 = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_ - 1, p_147808_4_).func_149751_l();
         var17 = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_ - 1, p_147808_4_).func_149751_l();
         var18 = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_ + 1).func_149751_l();
         var19 = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_ - 1).func_149751_l();
         if(!var19 && !var17) {
            this.field_147888_x = this.field_147886_y;
            this.field_147832_R = this.field_147831_S;
         } else {
            this.field_147888_x = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_ - 1).func_149685_I();
            this.field_147832_R = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ - 1, p_147808_3_, p_147808_4_ - 1);
         }

         if(!var18 && !var17) {
            this.field_147884_z = this.field_147886_y;
            this.field_147826_T = this.field_147831_S;
         } else {
            this.field_147884_z = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_ + 1).func_149685_I();
            this.field_147826_T = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ - 1, p_147808_3_, p_147808_4_ + 1);
         }

         if(!var19 && !var16) {
            this.field_147816_C = this.field_147810_D;
            this.field_147827_W = this.field_147835_X;
         } else {
            this.field_147816_C = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_ - 1).func_149685_I();
            this.field_147827_W = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ + 1, p_147808_3_, p_147808_4_ - 1);
         }

         if(!var18 && !var16) {
            this.field_147811_E = this.field_147810_D;
            this.field_147834_Y = this.field_147835_X;
         } else {
            this.field_147811_E = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_ + 1).func_149685_I();
            this.field_147834_Y = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ + 1, p_147808_3_, p_147808_4_ + 1);
         }

         if(this.field_147855_j <= 0.0D) {
            ++p_147808_3_;
         }

         var20 = var14;
         if(this.field_147855_j <= 0.0D || !this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_).func_149662_c()) {
            var20 = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ - 1, p_147808_4_);
         }

         var21 = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_).func_149685_I();
         var9 = (this.field_147884_z + this.field_147886_y + this.field_147815_B + var21) / 4.0F;
         var12 = (this.field_147815_B + var21 + this.field_147811_E + this.field_147810_D) / 4.0F;
         var11 = (var21 + this.field_147814_A + this.field_147810_D + this.field_147816_C) / 4.0F;
         var10 = (this.field_147886_y + this.field_147888_x + var21 + this.field_147814_A) / 4.0F;
         this.field_147864_al = this.func_147778_a(this.field_147826_T, this.field_147831_S, this.field_147828_V, var20);
         this.field_147870_ao = this.func_147778_a(this.field_147828_V, this.field_147834_Y, this.field_147835_X, var20);
         this.field_147876_an = this.func_147778_a(this.field_147825_U, this.field_147835_X, this.field_147827_W, var20);
         this.field_147874_am = this.func_147778_a(this.field_147831_S, this.field_147832_R, this.field_147825_U, var20);
         if(var13) {
            this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = p_147808_5_ * 0.5F;
            this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = p_147808_6_ * 0.5F;
            this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = p_147808_7_ * 0.5F;
         } else {
            this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = 0.5F;
            this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = 0.5F;
            this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = 0.5F;
         }

         this.field_147872_ap *= var9;
         this.field_147846_at *= var9;
         this.field_147854_ax *= var9;
         this.field_147852_aq *= var10;
         this.field_147860_au *= var10;
         this.field_147841_ay *= var10;
         this.field_147850_ar *= var11;
         this.field_147858_av *= var11;
         this.field_147839_az *= var11;
         this.field_147848_as *= var12;
         this.field_147856_aw *= var12;
         this.field_147833_aA *= var12;
         this.func_147768_a(p_147808_1_, (double)p_147808_2_, (double)p_147808_3_, (double)p_147808_4_, this.func_147793_a(p_147808_1_, this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_, 0));
         var8 = true;
      }

      if(this.field_147837_f || p_147808_1_.func_149646_a(this.field_147845_a, p_147808_2_, p_147808_3_ + 1, p_147808_4_, 1)) {
         if(this.field_147857_k >= 1.0D) {
            ++p_147808_3_;
         }

         this.field_147880_aa = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ - 1, p_147808_3_, p_147808_4_);
         this.field_147885_ae = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ + 1, p_147808_3_, p_147808_4_);
         this.field_147878_ac = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_ - 1);
         this.field_147887_af = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_ + 1);
         this.field_147813_G = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_).func_149685_I();
         this.field_147824_K = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_).func_149685_I();
         this.field_147822_I = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_, p_147808_4_ - 1).func_149685_I();
         this.field_147817_L = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_, p_147808_4_ + 1).func_149685_I();
         var16 = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_ + 1, p_147808_4_).func_149751_l();
         var17 = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_ + 1, p_147808_4_).func_149751_l();
         var18 = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_ + 1).func_149751_l();
         var19 = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_ - 1).func_149751_l();
         if(!var19 && !var17) {
            this.field_147812_F = this.field_147813_G;
            this.field_147836_Z = this.field_147880_aa;
         } else {
            this.field_147812_F = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_ - 1).func_149685_I();
            this.field_147836_Z = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ - 1, p_147808_3_, p_147808_4_ - 1);
         }

         if(!var19 && !var16) {
            this.field_147823_J = this.field_147824_K;
            this.field_147879_ad = this.field_147885_ae;
         } else {
            this.field_147823_J = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_ - 1).func_149685_I();
            this.field_147879_ad = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ + 1, p_147808_3_, p_147808_4_ - 1);
         }

         if(!var18 && !var17) {
            this.field_147821_H = this.field_147813_G;
            this.field_147881_ab = this.field_147880_aa;
         } else {
            this.field_147821_H = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_ + 1).func_149685_I();
            this.field_147881_ab = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ - 1, p_147808_3_, p_147808_4_ + 1);
         }

         if(!var18 && !var16) {
            this.field_147818_M = this.field_147824_K;
            this.field_147882_ag = this.field_147885_ae;
         } else {
            this.field_147818_M = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_ + 1).func_149685_I();
            this.field_147882_ag = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ + 1, p_147808_3_, p_147808_4_ + 1);
         }

         if(this.field_147857_k >= 1.0D) {
            --p_147808_3_;
         }

         var20 = var14;
         if(this.field_147857_k >= 1.0D || !this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_).func_149662_c()) {
            var20 = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ + 1, p_147808_4_);
         }

         var21 = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_).func_149685_I();
         var12 = (this.field_147821_H + this.field_147813_G + this.field_147817_L + var21) / 4.0F;
         var9 = (this.field_147817_L + var21 + this.field_147818_M + this.field_147824_K) / 4.0F;
         var10 = (var21 + this.field_147822_I + this.field_147824_K + this.field_147823_J) / 4.0F;
         var11 = (this.field_147813_G + this.field_147812_F + var21 + this.field_147822_I) / 4.0F;
         this.field_147870_ao = this.func_147778_a(this.field_147881_ab, this.field_147880_aa, this.field_147887_af, var20);
         this.field_147864_al = this.func_147778_a(this.field_147887_af, this.field_147882_ag, this.field_147885_ae, var20);
         this.field_147874_am = this.func_147778_a(this.field_147878_ac, this.field_147885_ae, this.field_147879_ad, var20);
         this.field_147876_an = this.func_147778_a(this.field_147880_aa, this.field_147836_Z, this.field_147878_ac, var20);
         this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = p_147808_5_;
         this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = p_147808_6_;
         this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = p_147808_7_;
         this.field_147872_ap *= var9;
         this.field_147846_at *= var9;
         this.field_147854_ax *= var9;
         this.field_147852_aq *= var10;
         this.field_147860_au *= var10;
         this.field_147841_ay *= var10;
         this.field_147850_ar *= var11;
         this.field_147858_av *= var11;
         this.field_147839_az *= var11;
         this.field_147848_as *= var12;
         this.field_147856_aw *= var12;
         this.field_147833_aA *= var12;
         this.func_147806_b(p_147808_1_, (double)p_147808_2_, (double)p_147808_3_, (double)p_147808_4_, this.func_147793_a(p_147808_1_, this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_, 1));
         var8 = true;
      }

      float var22;
      float var23;
      float var24;
      float var25;
      int var26;
      int var27;
      int var28;
      int var29;
      IIcon var30;
      if(this.field_147837_f || p_147808_1_.func_149646_a(this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_ - 1, 2)) {
         if(this.field_147851_l <= 0.0D) {
            --p_147808_4_;
         }

         this.field_147819_N = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_).func_149685_I();
         this.field_147814_A = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_).func_149685_I();
         this.field_147822_I = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_).func_149685_I();
         this.field_147820_O = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_).func_149685_I();
         this.field_147883_ah = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ - 1, p_147808_3_, p_147808_4_);
         this.field_147825_U = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ - 1, p_147808_4_);
         this.field_147878_ac = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ + 1, p_147808_4_);
         this.field_147866_ai = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ + 1, p_147808_3_, p_147808_4_);
         var16 = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_ - 1).func_149751_l();
         var17 = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_ - 1).func_149751_l();
         var18 = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_ - 1).func_149751_l();
         var19 = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_ - 1).func_149751_l();
         if(!var17 && !var19) {
            this.field_147888_x = this.field_147819_N;
            this.field_147832_R = this.field_147883_ah;
         } else {
            this.field_147888_x = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_ - 1, p_147808_4_).func_149685_I();
            this.field_147832_R = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ - 1, p_147808_3_ - 1, p_147808_4_);
         }

         if(!var17 && !var18) {
            this.field_147812_F = this.field_147819_N;
            this.field_147836_Z = this.field_147883_ah;
         } else {
            this.field_147812_F = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_ + 1, p_147808_4_).func_149685_I();
            this.field_147836_Z = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ - 1, p_147808_3_ + 1, p_147808_4_);
         }

         if(!var16 && !var19) {
            this.field_147816_C = this.field_147820_O;
            this.field_147827_W = this.field_147866_ai;
         } else {
            this.field_147816_C = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_ - 1, p_147808_4_).func_149685_I();
            this.field_147827_W = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ + 1, p_147808_3_ - 1, p_147808_4_);
         }

         if(!var16 && !var18) {
            this.field_147823_J = this.field_147820_O;
            this.field_147879_ad = this.field_147866_ai;
         } else {
            this.field_147823_J = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_ + 1, p_147808_4_).func_149685_I();
            this.field_147879_ad = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ + 1, p_147808_3_ + 1, p_147808_4_);
         }

         if(this.field_147851_l <= 0.0D) {
            ++p_147808_4_;
         }

         var20 = var14;
         if(this.field_147851_l <= 0.0D || !this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_, p_147808_4_ - 1).func_149662_c()) {
            var20 = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_ - 1);
         }

         var21 = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_, p_147808_4_ - 1).func_149685_I();
         var22 = (this.field_147819_N + this.field_147812_F + var21 + this.field_147822_I) / 4.0F;
         var23 = (var21 + this.field_147822_I + this.field_147820_O + this.field_147823_J) / 4.0F;
         var24 = (this.field_147814_A + var21 + this.field_147816_C + this.field_147820_O) / 4.0F;
         var25 = (this.field_147888_x + this.field_147819_N + this.field_147814_A + var21) / 4.0F;
         var9 = (float)((double)var22 * this.field_147857_k * (1.0D - this.field_147859_h) + (double)var23 * this.field_147857_k * this.field_147859_h + (double)var24 * (1.0D - this.field_147857_k) * this.field_147859_h + (double)var25 * (1.0D - this.field_147857_k) * (1.0D - this.field_147859_h));
         var10 = (float)((double)var22 * this.field_147857_k * (1.0D - this.field_147861_i) + (double)var23 * this.field_147857_k * this.field_147861_i + (double)var24 * (1.0D - this.field_147857_k) * this.field_147861_i + (double)var25 * (1.0D - this.field_147857_k) * (1.0D - this.field_147861_i));
         var11 = (float)((double)var22 * this.field_147855_j * (1.0D - this.field_147861_i) + (double)var23 * this.field_147855_j * this.field_147861_i + (double)var24 * (1.0D - this.field_147855_j) * this.field_147861_i + (double)var25 * (1.0D - this.field_147855_j) * (1.0D - this.field_147861_i));
         var12 = (float)((double)var22 * this.field_147855_j * (1.0D - this.field_147859_h) + (double)var23 * this.field_147855_j * this.field_147859_h + (double)var24 * (1.0D - this.field_147855_j) * this.field_147859_h + (double)var25 * (1.0D - this.field_147855_j) * (1.0D - this.field_147859_h));
         var26 = this.func_147778_a(this.field_147883_ah, this.field_147836_Z, this.field_147878_ac, var20);
         var27 = this.func_147778_a(this.field_147878_ac, this.field_147866_ai, this.field_147879_ad, var20);
         var28 = this.func_147778_a(this.field_147825_U, this.field_147827_W, this.field_147866_ai, var20);
         var29 = this.func_147778_a(this.field_147832_R, this.field_147883_ah, this.field_147825_U, var20);
         this.field_147864_al = this.func_147727_a(var26, var27, var28, var29, this.field_147857_k * (1.0D - this.field_147859_h), this.field_147857_k * this.field_147859_h, (1.0D - this.field_147857_k) * this.field_147859_h, (1.0D - this.field_147857_k) * (1.0D - this.field_147859_h));
         this.field_147874_am = this.func_147727_a(var26, var27, var28, var29, this.field_147857_k * (1.0D - this.field_147861_i), this.field_147857_k * this.field_147861_i, (1.0D - this.field_147857_k) * this.field_147861_i, (1.0D - this.field_147857_k) * (1.0D - this.field_147861_i));
         this.field_147876_an = this.func_147727_a(var26, var27, var28, var29, this.field_147855_j * (1.0D - this.field_147861_i), this.field_147855_j * this.field_147861_i, (1.0D - this.field_147855_j) * this.field_147861_i, (1.0D - this.field_147855_j) * (1.0D - this.field_147861_i));
         this.field_147870_ao = this.func_147727_a(var26, var27, var28, var29, this.field_147855_j * (1.0D - this.field_147859_h), this.field_147855_j * this.field_147859_h, (1.0D - this.field_147855_j) * this.field_147859_h, (1.0D - this.field_147855_j) * (1.0D - this.field_147859_h));
         if(var13) {
            this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = p_147808_5_ * 0.8F;
            this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = p_147808_6_ * 0.8F;
            this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = p_147808_7_ * 0.8F;
         } else {
            this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = 0.8F;
            this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = 0.8F;
            this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = 0.8F;
         }

         this.field_147872_ap *= var9;
         this.field_147846_at *= var9;
         this.field_147854_ax *= var9;
         this.field_147852_aq *= var10;
         this.field_147860_au *= var10;
         this.field_147841_ay *= var10;
         this.field_147850_ar *= var11;
         this.field_147858_av *= var11;
         this.field_147839_az *= var11;
         this.field_147848_as *= var12;
         this.field_147856_aw *= var12;
         this.field_147833_aA *= var12;
         var30 = this.func_147793_a(p_147808_1_, this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_, 2);
         this.func_147761_c(p_147808_1_, (double)p_147808_2_, (double)p_147808_3_, (double)p_147808_4_, var30);
         if(field_147843_b && var30.func_94215_i().equals("grass_side") && !this.func_147744_b()) {
            this.field_147872_ap *= p_147808_5_;
            this.field_147852_aq *= p_147808_5_;
            this.field_147850_ar *= p_147808_5_;
            this.field_147848_as *= p_147808_5_;
            this.field_147846_at *= p_147808_6_;
            this.field_147860_au *= p_147808_6_;
            this.field_147858_av *= p_147808_6_;
            this.field_147856_aw *= p_147808_6_;
            this.field_147854_ax *= p_147808_7_;
            this.field_147841_ay *= p_147808_7_;
            this.field_147839_az *= p_147808_7_;
            this.field_147833_aA *= p_147808_7_;
            this.func_147761_c(p_147808_1_, (double)p_147808_2_, (double)p_147808_3_, (double)p_147808_4_, BlockGrass.func_149990_e());
         }

         var8 = true;
      }

      if(this.field_147837_f || p_147808_1_.func_149646_a(this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_ + 1, 3)) {
         if(this.field_147853_m >= 1.0D) {
            ++p_147808_4_;
         }

         this.field_147830_P = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_).func_149685_I();
         this.field_147829_Q = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_).func_149685_I();
         this.field_147815_B = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_).func_149685_I();
         this.field_147817_L = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_).func_149685_I();
         this.field_147868_aj = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ - 1, p_147808_3_, p_147808_4_);
         this.field_147862_ak = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ + 1, p_147808_3_, p_147808_4_);
         this.field_147828_V = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ - 1, p_147808_4_);
         this.field_147887_af = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ + 1, p_147808_4_);
         var16 = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_ + 1).func_149751_l();
         var17 = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_ + 1).func_149751_l();
         var18 = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_ + 1).func_149751_l();
         var19 = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_ + 1).func_149751_l();
         if(!var17 && !var19) {
            this.field_147884_z = this.field_147830_P;
            this.field_147826_T = this.field_147868_aj;
         } else {
            this.field_147884_z = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_ - 1, p_147808_4_).func_149685_I();
            this.field_147826_T = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ - 1, p_147808_3_ - 1, p_147808_4_);
         }

         if(!var17 && !var18) {
            this.field_147821_H = this.field_147830_P;
            this.field_147881_ab = this.field_147868_aj;
         } else {
            this.field_147821_H = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_ + 1, p_147808_4_).func_149685_I();
            this.field_147881_ab = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ - 1, p_147808_3_ + 1, p_147808_4_);
         }

         if(!var16 && !var19) {
            this.field_147811_E = this.field_147829_Q;
            this.field_147834_Y = this.field_147862_ak;
         } else {
            this.field_147811_E = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_ - 1, p_147808_4_).func_149685_I();
            this.field_147834_Y = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ + 1, p_147808_3_ - 1, p_147808_4_);
         }

         if(!var16 && !var18) {
            this.field_147818_M = this.field_147829_Q;
            this.field_147882_ag = this.field_147862_ak;
         } else {
            this.field_147818_M = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_ + 1, p_147808_4_).func_149685_I();
            this.field_147882_ag = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ + 1, p_147808_3_ + 1, p_147808_4_);
         }

         if(this.field_147853_m >= 1.0D) {
            --p_147808_4_;
         }

         var20 = var14;
         if(this.field_147853_m >= 1.0D || !this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_, p_147808_4_ + 1).func_149662_c()) {
            var20 = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_ + 1);
         }

         var21 = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_, p_147808_4_ + 1).func_149685_I();
         var22 = (this.field_147830_P + this.field_147821_H + var21 + this.field_147817_L) / 4.0F;
         var23 = (var21 + this.field_147817_L + this.field_147829_Q + this.field_147818_M) / 4.0F;
         var24 = (this.field_147815_B + var21 + this.field_147811_E + this.field_147829_Q) / 4.0F;
         var25 = (this.field_147884_z + this.field_147830_P + this.field_147815_B + var21) / 4.0F;
         var9 = (float)((double)var22 * this.field_147857_k * (1.0D - this.field_147859_h) + (double)var23 * this.field_147857_k * this.field_147859_h + (double)var24 * (1.0D - this.field_147857_k) * this.field_147859_h + (double)var25 * (1.0D - this.field_147857_k) * (1.0D - this.field_147859_h));
         var10 = (float)((double)var22 * this.field_147855_j * (1.0D - this.field_147859_h) + (double)var23 * this.field_147855_j * this.field_147859_h + (double)var24 * (1.0D - this.field_147855_j) * this.field_147859_h + (double)var25 * (1.0D - this.field_147855_j) * (1.0D - this.field_147859_h));
         var11 = (float)((double)var22 * this.field_147855_j * (1.0D - this.field_147861_i) + (double)var23 * this.field_147855_j * this.field_147861_i + (double)var24 * (1.0D - this.field_147855_j) * this.field_147861_i + (double)var25 * (1.0D - this.field_147855_j) * (1.0D - this.field_147861_i));
         var12 = (float)((double)var22 * this.field_147857_k * (1.0D - this.field_147861_i) + (double)var23 * this.field_147857_k * this.field_147861_i + (double)var24 * (1.0D - this.field_147857_k) * this.field_147861_i + (double)var25 * (1.0D - this.field_147857_k) * (1.0D - this.field_147861_i));
         var26 = this.func_147778_a(this.field_147868_aj, this.field_147881_ab, this.field_147887_af, var20);
         var27 = this.func_147778_a(this.field_147887_af, this.field_147862_ak, this.field_147882_ag, var20);
         var28 = this.func_147778_a(this.field_147828_V, this.field_147834_Y, this.field_147862_ak, var20);
         var29 = this.func_147778_a(this.field_147826_T, this.field_147868_aj, this.field_147828_V, var20);
         this.field_147864_al = this.func_147727_a(var26, var29, var28, var27, this.field_147857_k * (1.0D - this.field_147859_h), (1.0D - this.field_147857_k) * (1.0D - this.field_147859_h), (1.0D - this.field_147857_k) * this.field_147859_h, this.field_147857_k * this.field_147859_h);
         this.field_147874_am = this.func_147727_a(var26, var29, var28, var27, this.field_147855_j * (1.0D - this.field_147859_h), (1.0D - this.field_147855_j) * (1.0D - this.field_147859_h), (1.0D - this.field_147855_j) * this.field_147859_h, this.field_147855_j * this.field_147859_h);
         this.field_147876_an = this.func_147727_a(var26, var29, var28, var27, this.field_147855_j * (1.0D - this.field_147861_i), (1.0D - this.field_147855_j) * (1.0D - this.field_147861_i), (1.0D - this.field_147855_j) * this.field_147861_i, this.field_147855_j * this.field_147861_i);
         this.field_147870_ao = this.func_147727_a(var26, var29, var28, var27, this.field_147857_k * (1.0D - this.field_147861_i), (1.0D - this.field_147857_k) * (1.0D - this.field_147861_i), (1.0D - this.field_147857_k) * this.field_147861_i, this.field_147857_k * this.field_147861_i);
         if(var13) {
            this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = p_147808_5_ * 0.8F;
            this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = p_147808_6_ * 0.8F;
            this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = p_147808_7_ * 0.8F;
         } else {
            this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = 0.8F;
            this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = 0.8F;
            this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = 0.8F;
         }

         this.field_147872_ap *= var9;
         this.field_147846_at *= var9;
         this.field_147854_ax *= var9;
         this.field_147852_aq *= var10;
         this.field_147860_au *= var10;
         this.field_147841_ay *= var10;
         this.field_147850_ar *= var11;
         this.field_147858_av *= var11;
         this.field_147839_az *= var11;
         this.field_147848_as *= var12;
         this.field_147856_aw *= var12;
         this.field_147833_aA *= var12;
         var30 = this.func_147793_a(p_147808_1_, this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_, 3);
         this.func_147734_d(p_147808_1_, (double)p_147808_2_, (double)p_147808_3_, (double)p_147808_4_, var30);
         if(field_147843_b && var30.func_94215_i().equals("grass_side") && !this.func_147744_b()) {
            this.field_147872_ap *= p_147808_5_;
            this.field_147852_aq *= p_147808_5_;
            this.field_147850_ar *= p_147808_5_;
            this.field_147848_as *= p_147808_5_;
            this.field_147846_at *= p_147808_6_;
            this.field_147860_au *= p_147808_6_;
            this.field_147858_av *= p_147808_6_;
            this.field_147856_aw *= p_147808_6_;
            this.field_147854_ax *= p_147808_7_;
            this.field_147841_ay *= p_147808_7_;
            this.field_147839_az *= p_147808_7_;
            this.field_147833_aA *= p_147808_7_;
            this.func_147734_d(p_147808_1_, (double)p_147808_2_, (double)p_147808_3_, (double)p_147808_4_, BlockGrass.func_149990_e());
         }

         var8 = true;
      }

      if(this.field_147837_f || p_147808_1_.func_149646_a(this.field_147845_a, p_147808_2_ - 1, p_147808_3_, p_147808_4_, 4)) {
         if(this.field_147859_h <= 0.0D) {
            --p_147808_2_;
         }

         this.field_147886_y = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_).func_149685_I();
         this.field_147819_N = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_, p_147808_4_ - 1).func_149685_I();
         this.field_147830_P = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_, p_147808_4_ + 1).func_149685_I();
         this.field_147813_G = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_).func_149685_I();
         this.field_147831_S = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ - 1, p_147808_4_);
         this.field_147883_ah = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_ - 1);
         this.field_147868_aj = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_ + 1);
         this.field_147880_aa = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ + 1, p_147808_4_);
         var16 = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_ + 1, p_147808_4_).func_149751_l();
         var17 = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_ - 1, p_147808_4_).func_149751_l();
         var18 = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_ - 1).func_149751_l();
         var19 = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_ + 1).func_149751_l();
         if(!var18 && !var17) {
            this.field_147888_x = this.field_147819_N;
            this.field_147832_R = this.field_147883_ah;
         } else {
            this.field_147888_x = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_ - 1).func_149685_I();
            this.field_147832_R = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ - 1, p_147808_4_ - 1);
         }

         if(!var19 && !var17) {
            this.field_147884_z = this.field_147830_P;
            this.field_147826_T = this.field_147868_aj;
         } else {
            this.field_147884_z = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_ + 1).func_149685_I();
            this.field_147826_T = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ - 1, p_147808_4_ + 1);
         }

         if(!var18 && !var16) {
            this.field_147812_F = this.field_147819_N;
            this.field_147836_Z = this.field_147883_ah;
         } else {
            this.field_147812_F = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_ - 1).func_149685_I();
            this.field_147836_Z = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ + 1, p_147808_4_ - 1);
         }

         if(!var19 && !var16) {
            this.field_147821_H = this.field_147830_P;
            this.field_147881_ab = this.field_147868_aj;
         } else {
            this.field_147821_H = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_ + 1).func_149685_I();
            this.field_147881_ab = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ + 1, p_147808_4_ + 1);
         }

         if(this.field_147859_h <= 0.0D) {
            ++p_147808_2_;
         }

         var20 = var14;
         if(this.field_147859_h <= 0.0D || !this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_).func_149662_c()) {
            var20 = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ - 1, p_147808_3_, p_147808_4_);
         }

         var21 = this.field_147845_a.func_147439_a(p_147808_2_ - 1, p_147808_3_, p_147808_4_).func_149685_I();
         var22 = (this.field_147886_y + this.field_147884_z + var21 + this.field_147830_P) / 4.0F;
         var23 = (var21 + this.field_147830_P + this.field_147813_G + this.field_147821_H) / 4.0F;
         var24 = (this.field_147819_N + var21 + this.field_147812_F + this.field_147813_G) / 4.0F;
         var25 = (this.field_147888_x + this.field_147886_y + this.field_147819_N + var21) / 4.0F;
         var9 = (float)((double)var23 * this.field_147857_k * this.field_147853_m + (double)var24 * this.field_147857_k * (1.0D - this.field_147853_m) + (double)var25 * (1.0D - this.field_147857_k) * (1.0D - this.field_147853_m) + (double)var22 * (1.0D - this.field_147857_k) * this.field_147853_m);
         var10 = (float)((double)var23 * this.field_147857_k * this.field_147851_l + (double)var24 * this.field_147857_k * (1.0D - this.field_147851_l) + (double)var25 * (1.0D - this.field_147857_k) * (1.0D - this.field_147851_l) + (double)var22 * (1.0D - this.field_147857_k) * this.field_147851_l);
         var11 = (float)((double)var23 * this.field_147855_j * this.field_147851_l + (double)var24 * this.field_147855_j * (1.0D - this.field_147851_l) + (double)var25 * (1.0D - this.field_147855_j) * (1.0D - this.field_147851_l) + (double)var22 * (1.0D - this.field_147855_j) * this.field_147851_l);
         var12 = (float)((double)var23 * this.field_147855_j * this.field_147853_m + (double)var24 * this.field_147855_j * (1.0D - this.field_147853_m) + (double)var25 * (1.0D - this.field_147855_j) * (1.0D - this.field_147853_m) + (double)var22 * (1.0D - this.field_147855_j) * this.field_147853_m);
         var26 = this.func_147778_a(this.field_147831_S, this.field_147826_T, this.field_147868_aj, var20);
         var27 = this.func_147778_a(this.field_147868_aj, this.field_147880_aa, this.field_147881_ab, var20);
         var28 = this.func_147778_a(this.field_147883_ah, this.field_147836_Z, this.field_147880_aa, var20);
         var29 = this.func_147778_a(this.field_147832_R, this.field_147831_S, this.field_147883_ah, var20);
         this.field_147864_al = this.func_147727_a(var27, var28, var29, var26, this.field_147857_k * this.field_147853_m, this.field_147857_k * (1.0D - this.field_147853_m), (1.0D - this.field_147857_k) * (1.0D - this.field_147853_m), (1.0D - this.field_147857_k) * this.field_147853_m);
         this.field_147874_am = this.func_147727_a(var27, var28, var29, var26, this.field_147857_k * this.field_147851_l, this.field_147857_k * (1.0D - this.field_147851_l), (1.0D - this.field_147857_k) * (1.0D - this.field_147851_l), (1.0D - this.field_147857_k) * this.field_147851_l);
         this.field_147876_an = this.func_147727_a(var27, var28, var29, var26, this.field_147855_j * this.field_147851_l, this.field_147855_j * (1.0D - this.field_147851_l), (1.0D - this.field_147855_j) * (1.0D - this.field_147851_l), (1.0D - this.field_147855_j) * this.field_147851_l);
         this.field_147870_ao = this.func_147727_a(var27, var28, var29, var26, this.field_147855_j * this.field_147853_m, this.field_147855_j * (1.0D - this.field_147853_m), (1.0D - this.field_147855_j) * (1.0D - this.field_147853_m), (1.0D - this.field_147855_j) * this.field_147853_m);
         if(var13) {
            this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = p_147808_5_ * 0.6F;
            this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = p_147808_6_ * 0.6F;
            this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = p_147808_7_ * 0.6F;
         } else {
            this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = 0.6F;
            this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = 0.6F;
            this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = 0.6F;
         }

         this.field_147872_ap *= var9;
         this.field_147846_at *= var9;
         this.field_147854_ax *= var9;
         this.field_147852_aq *= var10;
         this.field_147860_au *= var10;
         this.field_147841_ay *= var10;
         this.field_147850_ar *= var11;
         this.field_147858_av *= var11;
         this.field_147839_az *= var11;
         this.field_147848_as *= var12;
         this.field_147856_aw *= var12;
         this.field_147833_aA *= var12;
         var30 = this.func_147793_a(p_147808_1_, this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_, 4);
         this.func_147798_e(p_147808_1_, (double)p_147808_2_, (double)p_147808_3_, (double)p_147808_4_, var30);
         if(field_147843_b && var30.func_94215_i().equals("grass_side") && !this.func_147744_b()) {
            this.field_147872_ap *= p_147808_5_;
            this.field_147852_aq *= p_147808_5_;
            this.field_147850_ar *= p_147808_5_;
            this.field_147848_as *= p_147808_5_;
            this.field_147846_at *= p_147808_6_;
            this.field_147860_au *= p_147808_6_;
            this.field_147858_av *= p_147808_6_;
            this.field_147856_aw *= p_147808_6_;
            this.field_147854_ax *= p_147808_7_;
            this.field_147841_ay *= p_147808_7_;
            this.field_147839_az *= p_147808_7_;
            this.field_147833_aA *= p_147808_7_;
            this.func_147798_e(p_147808_1_, (double)p_147808_2_, (double)p_147808_3_, (double)p_147808_4_, BlockGrass.func_149990_e());
         }

         var8 = true;
      }

      if(this.field_147837_f || p_147808_1_.func_149646_a(this.field_147845_a, p_147808_2_ + 1, p_147808_3_, p_147808_4_, 5)) {
         if(this.field_147861_i >= 1.0D) {
            ++p_147808_2_;
         }

         this.field_147810_D = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_).func_149685_I();
         this.field_147820_O = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_, p_147808_4_ - 1).func_149685_I();
         this.field_147829_Q = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_, p_147808_4_ + 1).func_149685_I();
         this.field_147824_K = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_).func_149685_I();
         this.field_147835_X = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ - 1, p_147808_4_);
         this.field_147866_ai = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_ - 1);
         this.field_147862_ak = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_ + 1);
         this.field_147885_ae = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ + 1, p_147808_4_);
         var16 = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_ + 1, p_147808_4_).func_149751_l();
         var17 = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_ - 1, p_147808_4_).func_149751_l();
         var18 = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_ + 1).func_149751_l();
         var19 = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_ - 1).func_149751_l();
         if(!var17 && !var19) {
            this.field_147816_C = this.field_147820_O;
            this.field_147827_W = this.field_147866_ai;
         } else {
            this.field_147816_C = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_ - 1).func_149685_I();
            this.field_147827_W = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ - 1, p_147808_4_ - 1);
         }

         if(!var17 && !var18) {
            this.field_147811_E = this.field_147829_Q;
            this.field_147834_Y = this.field_147862_ak;
         } else {
            this.field_147811_E = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ - 1, p_147808_4_ + 1).func_149685_I();
            this.field_147834_Y = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ - 1, p_147808_4_ + 1);
         }

         if(!var16 && !var19) {
            this.field_147823_J = this.field_147820_O;
            this.field_147879_ad = this.field_147866_ai;
         } else {
            this.field_147823_J = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_ - 1).func_149685_I();
            this.field_147879_ad = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ + 1, p_147808_4_ - 1);
         }

         if(!var16 && !var18) {
            this.field_147818_M = this.field_147829_Q;
            this.field_147882_ag = this.field_147862_ak;
         } else {
            this.field_147818_M = this.field_147845_a.func_147439_a(p_147808_2_, p_147808_3_ + 1, p_147808_4_ + 1).func_149685_I();
            this.field_147882_ag = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_, p_147808_3_ + 1, p_147808_4_ + 1);
         }

         if(this.field_147861_i >= 1.0D) {
            --p_147808_2_;
         }

         var20 = var14;
         if(this.field_147861_i >= 1.0D || !this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_).func_149662_c()) {
            var20 = p_147808_1_.func_149677_c(this.field_147845_a, p_147808_2_ + 1, p_147808_3_, p_147808_4_);
         }

         var21 = this.field_147845_a.func_147439_a(p_147808_2_ + 1, p_147808_3_, p_147808_4_).func_149685_I();
         var22 = (this.field_147810_D + this.field_147811_E + var21 + this.field_147829_Q) / 4.0F;
         var23 = (this.field_147816_C + this.field_147810_D + this.field_147820_O + var21) / 4.0F;
         var24 = (this.field_147820_O + var21 + this.field_147823_J + this.field_147824_K) / 4.0F;
         var25 = (var21 + this.field_147829_Q + this.field_147824_K + this.field_147818_M) / 4.0F;
         var9 = (float)((double)var22 * (1.0D - this.field_147855_j) * this.field_147853_m + (double)var23 * (1.0D - this.field_147855_j) * (1.0D - this.field_147853_m) + (double)var24 * this.field_147855_j * (1.0D - this.field_147853_m) + (double)var25 * this.field_147855_j * this.field_147853_m);
         var10 = (float)((double)var22 * (1.0D - this.field_147855_j) * this.field_147851_l + (double)var23 * (1.0D - this.field_147855_j) * (1.0D - this.field_147851_l) + (double)var24 * this.field_147855_j * (1.0D - this.field_147851_l) + (double)var25 * this.field_147855_j * this.field_147851_l);
         var11 = (float)((double)var22 * (1.0D - this.field_147857_k) * this.field_147851_l + (double)var23 * (1.0D - this.field_147857_k) * (1.0D - this.field_147851_l) + (double)var24 * this.field_147857_k * (1.0D - this.field_147851_l) + (double)var25 * this.field_147857_k * this.field_147851_l);
         var12 = (float)((double)var22 * (1.0D - this.field_147857_k) * this.field_147853_m + (double)var23 * (1.0D - this.field_147857_k) * (1.0D - this.field_147853_m) + (double)var24 * this.field_147857_k * (1.0D - this.field_147853_m) + (double)var25 * this.field_147857_k * this.field_147853_m);
         var26 = this.func_147778_a(this.field_147835_X, this.field_147834_Y, this.field_147862_ak, var20);
         var27 = this.func_147778_a(this.field_147862_ak, this.field_147885_ae, this.field_147882_ag, var20);
         var28 = this.func_147778_a(this.field_147866_ai, this.field_147879_ad, this.field_147885_ae, var20);
         var29 = this.func_147778_a(this.field_147827_W, this.field_147835_X, this.field_147866_ai, var20);
         this.field_147864_al = this.func_147727_a(var26, var29, var28, var27, (1.0D - this.field_147855_j) * this.field_147853_m, (1.0D - this.field_147855_j) * (1.0D - this.field_147853_m), this.field_147855_j * (1.0D - this.field_147853_m), this.field_147855_j * this.field_147853_m);
         this.field_147874_am = this.func_147727_a(var26, var29, var28, var27, (1.0D - this.field_147855_j) * this.field_147851_l, (1.0D - this.field_147855_j) * (1.0D - this.field_147851_l), this.field_147855_j * (1.0D - this.field_147851_l), this.field_147855_j * this.field_147851_l);
         this.field_147876_an = this.func_147727_a(var26, var29, var28, var27, (1.0D - this.field_147857_k) * this.field_147851_l, (1.0D - this.field_147857_k) * (1.0D - this.field_147851_l), this.field_147857_k * (1.0D - this.field_147851_l), this.field_147857_k * this.field_147851_l);
         this.field_147870_ao = this.func_147727_a(var26, var29, var28, var27, (1.0D - this.field_147857_k) * this.field_147853_m, (1.0D - this.field_147857_k) * (1.0D - this.field_147853_m), this.field_147857_k * (1.0D - this.field_147853_m), this.field_147857_k * this.field_147853_m);
         if(var13) {
            this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = p_147808_5_ * 0.6F;
            this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = p_147808_6_ * 0.6F;
            this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = p_147808_7_ * 0.6F;
         } else {
            this.field_147872_ap = this.field_147852_aq = this.field_147850_ar = this.field_147848_as = 0.6F;
            this.field_147846_at = this.field_147860_au = this.field_147858_av = this.field_147856_aw = 0.6F;
            this.field_147854_ax = this.field_147841_ay = this.field_147839_az = this.field_147833_aA = 0.6F;
         }

         this.field_147872_ap *= var9;
         this.field_147846_at *= var9;
         this.field_147854_ax *= var9;
         this.field_147852_aq *= var10;
         this.field_147860_au *= var10;
         this.field_147841_ay *= var10;
         this.field_147850_ar *= var11;
         this.field_147858_av *= var11;
         this.field_147839_az *= var11;
         this.field_147848_as *= var12;
         this.field_147856_aw *= var12;
         this.field_147833_aA *= var12;
         var30 = this.func_147793_a(p_147808_1_, this.field_147845_a, p_147808_2_, p_147808_3_, p_147808_4_, 5);
         this.func_147764_f(p_147808_1_, (double)p_147808_2_, (double)p_147808_3_, (double)p_147808_4_, var30);
         if(field_147843_b && var30.func_94215_i().equals("grass_side") && !this.func_147744_b()) {
            this.field_147872_ap *= p_147808_5_;
            this.field_147852_aq *= p_147808_5_;
            this.field_147850_ar *= p_147808_5_;
            this.field_147848_as *= p_147808_5_;
            this.field_147846_at *= p_147808_6_;
            this.field_147860_au *= p_147808_6_;
            this.field_147858_av *= p_147808_6_;
            this.field_147856_aw *= p_147808_6_;
            this.field_147854_ax *= p_147808_7_;
            this.field_147841_ay *= p_147808_7_;
            this.field_147839_az *= p_147808_7_;
            this.field_147833_aA *= p_147808_7_;
            this.func_147764_f(p_147808_1_, (double)p_147808_2_, (double)p_147808_3_, (double)p_147808_4_, BlockGrass.func_149990_e());
         }

         var8 = true;
      }

      this.field_147863_w = false;
      return var8;
   }

   private int func_147778_a(int p_147778_1_, int p_147778_2_, int p_147778_3_, int p_147778_4_) {
      if(p_147778_1_ == 0) {
         p_147778_1_ = p_147778_4_;
      }

      if(p_147778_2_ == 0) {
         p_147778_2_ = p_147778_4_;
      }

      if(p_147778_3_ == 0) {
         p_147778_3_ = p_147778_4_;
      }

      return p_147778_1_ + p_147778_2_ + p_147778_3_ + p_147778_4_ >> 2 & 16711935;
   }

   private int func_147727_a(int p_147727_1_, int p_147727_2_, int p_147727_3_, int p_147727_4_, double p_147727_5_, double p_147727_7_, double p_147727_9_, double p_147727_11_) {
      int var13 = (int)((double)(p_147727_1_ >> 16 & 255) * p_147727_5_ + (double)(p_147727_2_ >> 16 & 255) * p_147727_7_ + (double)(p_147727_3_ >> 16 & 255) * p_147727_9_ + (double)(p_147727_4_ >> 16 & 255) * p_147727_11_) & 255;
      int var14 = (int)((double)(p_147727_1_ & 255) * p_147727_5_ + (double)(p_147727_2_ & 255) * p_147727_7_ + (double)(p_147727_3_ & 255) * p_147727_9_ + (double)(p_147727_4_ & 255) * p_147727_11_) & 255;
      return var13 << 16 | var14;
   }

   public boolean func_147736_d(Block p_147736_1_, int p_147736_2_, int p_147736_3_, int p_147736_4_, float p_147736_5_, float p_147736_6_, float p_147736_7_) {
      this.field_147863_w = false;
      Tessellator var8 = Tessellator.field_78398_a;
      boolean var9 = false;
      float var10 = 0.5F;
      float var11 = 1.0F;
      float var12 = 0.8F;
      float var13 = 0.6F;
      float var14 = var11 * p_147736_5_;
      float var15 = var11 * p_147736_6_;
      float var16 = var11 * p_147736_7_;
      float var17 = var10;
      float var18 = var12;
      float var19 = var13;
      float var20 = var10;
      float var21 = var12;
      float var22 = var13;
      float var23 = var10;
      float var24 = var12;
      float var25 = var13;
      if(p_147736_1_ != Blocks.field_150349_c) {
         var17 = var10 * p_147736_5_;
         var18 = var12 * p_147736_5_;
         var19 = var13 * p_147736_5_;
         var20 = var10 * p_147736_6_;
         var21 = var12 * p_147736_6_;
         var22 = var13 * p_147736_6_;
         var23 = var10 * p_147736_7_;
         var24 = var12 * p_147736_7_;
         var25 = var13 * p_147736_7_;
      }

      int var26 = p_147736_1_.func_149677_c(this.field_147845_a, p_147736_2_, p_147736_3_, p_147736_4_);
      if(this.field_147837_f || p_147736_1_.func_149646_a(this.field_147845_a, p_147736_2_, p_147736_3_ - 1, p_147736_4_, 0)) {
         var8.func_78380_c(this.field_147855_j > 0.0D?var26:p_147736_1_.func_149677_c(this.field_147845_a, p_147736_2_, p_147736_3_ - 1, p_147736_4_));
         var8.func_78386_a(var17, var20, var23);
         this.func_147768_a(p_147736_1_, (double)p_147736_2_, (double)p_147736_3_, (double)p_147736_4_, this.func_147793_a(p_147736_1_, this.field_147845_a, p_147736_2_, p_147736_3_, p_147736_4_, 0));
         var9 = true;
      }

      if(this.field_147837_f || p_147736_1_.func_149646_a(this.field_147845_a, p_147736_2_, p_147736_3_ + 1, p_147736_4_, 1)) {
         var8.func_78380_c(this.field_147857_k < 1.0D?var26:p_147736_1_.func_149677_c(this.field_147845_a, p_147736_2_, p_147736_3_ + 1, p_147736_4_));
         var8.func_78386_a(var14, var15, var16);
         this.func_147806_b(p_147736_1_, (double)p_147736_2_, (double)p_147736_3_, (double)p_147736_4_, this.func_147793_a(p_147736_1_, this.field_147845_a, p_147736_2_, p_147736_3_, p_147736_4_, 1));
         var9 = true;
      }

      IIcon var27;
      if(this.field_147837_f || p_147736_1_.func_149646_a(this.field_147845_a, p_147736_2_, p_147736_3_, p_147736_4_ - 1, 2)) {
         var8.func_78380_c(this.field_147851_l > 0.0D?var26:p_147736_1_.func_149677_c(this.field_147845_a, p_147736_2_, p_147736_3_, p_147736_4_ - 1));
         var8.func_78386_a(var18, var21, var24);
         var27 = this.func_147793_a(p_147736_1_, this.field_147845_a, p_147736_2_, p_147736_3_, p_147736_4_, 2);
         this.func_147761_c(p_147736_1_, (double)p_147736_2_, (double)p_147736_3_, (double)p_147736_4_, var27);
         if(field_147843_b && var27.func_94215_i().equals("grass_side") && !this.func_147744_b()) {
            var8.func_78386_a(var18 * p_147736_5_, var21 * p_147736_6_, var24 * p_147736_7_);
            this.func_147761_c(p_147736_1_, (double)p_147736_2_, (double)p_147736_3_, (double)p_147736_4_, BlockGrass.func_149990_e());
         }

         var9 = true;
      }

      if(this.field_147837_f || p_147736_1_.func_149646_a(this.field_147845_a, p_147736_2_, p_147736_3_, p_147736_4_ + 1, 3)) {
         var8.func_78380_c(this.field_147853_m < 1.0D?var26:p_147736_1_.func_149677_c(this.field_147845_a, p_147736_2_, p_147736_3_, p_147736_4_ + 1));
         var8.func_78386_a(var18, var21, var24);
         var27 = this.func_147793_a(p_147736_1_, this.field_147845_a, p_147736_2_, p_147736_3_, p_147736_4_, 3);
         this.func_147734_d(p_147736_1_, (double)p_147736_2_, (double)p_147736_3_, (double)p_147736_4_, var27);
         if(field_147843_b && var27.func_94215_i().equals("grass_side") && !this.func_147744_b()) {
            var8.func_78386_a(var18 * p_147736_5_, var21 * p_147736_6_, var24 * p_147736_7_);
            this.func_147734_d(p_147736_1_, (double)p_147736_2_, (double)p_147736_3_, (double)p_147736_4_, BlockGrass.func_149990_e());
         }

         var9 = true;
      }

      if(this.field_147837_f || p_147736_1_.func_149646_a(this.field_147845_a, p_147736_2_ - 1, p_147736_3_, p_147736_4_, 4)) {
         var8.func_78380_c(this.field_147859_h > 0.0D?var26:p_147736_1_.func_149677_c(this.field_147845_a, p_147736_2_ - 1, p_147736_3_, p_147736_4_));
         var8.func_78386_a(var19, var22, var25);
         var27 = this.func_147793_a(p_147736_1_, this.field_147845_a, p_147736_2_, p_147736_3_, p_147736_4_, 4);
         this.func_147798_e(p_147736_1_, (double)p_147736_2_, (double)p_147736_3_, (double)p_147736_4_, var27);
         if(field_147843_b && var27.func_94215_i().equals("grass_side") && !this.func_147744_b()) {
            var8.func_78386_a(var19 * p_147736_5_, var22 * p_147736_6_, var25 * p_147736_7_);
            this.func_147798_e(p_147736_1_, (double)p_147736_2_, (double)p_147736_3_, (double)p_147736_4_, BlockGrass.func_149990_e());
         }

         var9 = true;
      }

      if(this.field_147837_f || p_147736_1_.func_149646_a(this.field_147845_a, p_147736_2_ + 1, p_147736_3_, p_147736_4_, 5)) {
         var8.func_78380_c(this.field_147861_i < 1.0D?var26:p_147736_1_.func_149677_c(this.field_147845_a, p_147736_2_ + 1, p_147736_3_, p_147736_4_));
         var8.func_78386_a(var19, var22, var25);
         var27 = this.func_147793_a(p_147736_1_, this.field_147845_a, p_147736_2_, p_147736_3_, p_147736_4_, 5);
         this.func_147764_f(p_147736_1_, (double)p_147736_2_, (double)p_147736_3_, (double)p_147736_4_, var27);
         if(field_147843_b && var27.func_94215_i().equals("grass_side") && !this.func_147744_b()) {
            var8.func_78386_a(var19 * p_147736_5_, var22 * p_147736_6_, var25 * p_147736_7_);
            this.func_147764_f(p_147736_1_, (double)p_147736_2_, (double)p_147736_3_, (double)p_147736_4_, BlockGrass.func_149990_e());
         }

         var9 = true;
      }

      return var9;
   }

   private boolean func_147772_a(BlockCocoa p_147772_1_, int p_147772_2_, int p_147772_3_, int p_147772_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      var5.func_78380_c(p_147772_1_.func_149677_c(this.field_147845_a, p_147772_2_, p_147772_3_, p_147772_4_));
      var5.func_78386_a(1.0F, 1.0F, 1.0F);
      int var6 = this.field_147845_a.func_72805_g(p_147772_2_, p_147772_3_, p_147772_4_);
      int var7 = BlockDirectional.func_149895_l(var6);
      int var8 = BlockCocoa.func_149987_c(var6);
      IIcon var9 = p_147772_1_.func_149988_b(var8);
      int var10 = 4 + var8 * 2;
      int var11 = 5 + var8 * 2;
      double var12 = 15.0D - (double)var10;
      double var14 = 15.0D;
      double var16 = 4.0D;
      double var18 = 4.0D + (double)var11;
      double var20 = (double)var9.func_94214_a(var12);
      double var22 = (double)var9.func_94214_a(var14);
      double var24 = (double)var9.func_94207_b(var16);
      double var26 = (double)var9.func_94207_b(var18);
      double var28 = 0.0D;
      double var30 = 0.0D;
      switch(var7) {
      case 0:
         var28 = 8.0D - (double)(var10 / 2);
         var30 = 15.0D - (double)var10;
         break;
      case 1:
         var28 = 1.0D;
         var30 = 8.0D - (double)(var10 / 2);
         break;
      case 2:
         var28 = 8.0D - (double)(var10 / 2);
         var30 = 1.0D;
         break;
      case 3:
         var28 = 15.0D - (double)var10;
         var30 = 8.0D - (double)(var10 / 2);
      }

      double var32 = (double)p_147772_2_ + var28 / 16.0D;
      double var34 = (double)p_147772_2_ + (var28 + (double)var10) / 16.0D;
      double var36 = (double)p_147772_3_ + (12.0D - (double)var11) / 16.0D;
      double var38 = (double)p_147772_3_ + 0.75D;
      double var40 = (double)p_147772_4_ + var30 / 16.0D;
      double var42 = (double)p_147772_4_ + (var30 + (double)var10) / 16.0D;
      var5.func_78374_a(var32, var36, var40, var20, var26);
      var5.func_78374_a(var32, var36, var42, var22, var26);
      var5.func_78374_a(var32, var38, var42, var22, var24);
      var5.func_78374_a(var32, var38, var40, var20, var24);
      var5.func_78374_a(var34, var36, var42, var20, var26);
      var5.func_78374_a(var34, var36, var40, var22, var26);
      var5.func_78374_a(var34, var38, var40, var22, var24);
      var5.func_78374_a(var34, var38, var42, var20, var24);
      var5.func_78374_a(var34, var36, var40, var20, var26);
      var5.func_78374_a(var32, var36, var40, var22, var26);
      var5.func_78374_a(var32, var38, var40, var22, var24);
      var5.func_78374_a(var34, var38, var40, var20, var24);
      var5.func_78374_a(var32, var36, var42, var20, var26);
      var5.func_78374_a(var34, var36, var42, var22, var26);
      var5.func_78374_a(var34, var38, var42, var22, var24);
      var5.func_78374_a(var32, var38, var42, var20, var24);
      int var44 = var10;
      if(var8 >= 2) {
         var44 = var10 - 1;
      }

      var20 = (double)var9.func_94209_e();
      var22 = (double)var9.func_94214_a((double)var44);
      var24 = (double)var9.func_94206_g();
      var26 = (double)var9.func_94207_b((double)var44);
      var5.func_78374_a(var32, var38, var42, var20, var26);
      var5.func_78374_a(var34, var38, var42, var22, var26);
      var5.func_78374_a(var34, var38, var40, var22, var24);
      var5.func_78374_a(var32, var38, var40, var20, var24);
      var5.func_78374_a(var32, var36, var40, var20, var24);
      var5.func_78374_a(var34, var36, var40, var22, var24);
      var5.func_78374_a(var34, var36, var42, var22, var26);
      var5.func_78374_a(var32, var36, var42, var20, var26);
      var20 = (double)var9.func_94214_a(12.0D);
      var22 = (double)var9.func_94212_f();
      var24 = (double)var9.func_94206_g();
      var26 = (double)var9.func_94207_b(4.0D);
      var28 = 8.0D;
      var30 = 0.0D;
      double var45;
      switch(var7) {
      case 0:
         var28 = 8.0D;
         var30 = 12.0D;
         var45 = var20;
         var20 = var22;
         var22 = var45;
         break;
      case 1:
         var28 = 0.0D;
         var30 = 8.0D;
         break;
      case 2:
         var28 = 8.0D;
         var30 = 0.0D;
         break;
      case 3:
         var28 = 12.0D;
         var30 = 8.0D;
         var45 = var20;
         var20 = var22;
         var22 = var45;
      }

      var32 = (double)p_147772_2_ + var28 / 16.0D;
      var34 = (double)p_147772_2_ + (var28 + 4.0D) / 16.0D;
      var36 = (double)p_147772_3_ + 0.75D;
      var38 = (double)p_147772_3_ + 1.0D;
      var40 = (double)p_147772_4_ + var30 / 16.0D;
      var42 = (double)p_147772_4_ + (var30 + 4.0D) / 16.0D;
      if(var7 != 2 && var7 != 0) {
         if(var7 == 1 || var7 == 3) {
            var5.func_78374_a(var34, var36, var40, var20, var26);
            var5.func_78374_a(var32, var36, var40, var22, var26);
            var5.func_78374_a(var32, var38, var40, var22, var24);
            var5.func_78374_a(var34, var38, var40, var20, var24);
            var5.func_78374_a(var32, var36, var40, var22, var26);
            var5.func_78374_a(var34, var36, var40, var20, var26);
            var5.func_78374_a(var34, var38, var40, var20, var24);
            var5.func_78374_a(var32, var38, var40, var22, var24);
         }
      } else {
         var5.func_78374_a(var32, var36, var40, var22, var26);
         var5.func_78374_a(var32, var36, var42, var20, var26);
         var5.func_78374_a(var32, var38, var42, var20, var24);
         var5.func_78374_a(var32, var38, var40, var22, var24);
         var5.func_78374_a(var32, var36, var42, var20, var26);
         var5.func_78374_a(var32, var36, var40, var22, var26);
         var5.func_78374_a(var32, var38, var40, var22, var24);
         var5.func_78374_a(var32, var38, var42, var20, var24);
      }

      return true;
   }

   private boolean func_147797_a(BlockBeacon p_147797_1_, int p_147797_2_, int p_147797_3_, int p_147797_4_) {
      float var5 = 0.1875F;
      this.func_147757_a(this.func_147745_b(Blocks.field_150359_w));
      this.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
      this.func_147784_q(p_147797_1_, p_147797_2_, p_147797_3_, p_147797_4_);
      this.field_147837_f = true;
      this.func_147757_a(this.func_147745_b(Blocks.field_150343_Z));
      this.func_147782_a(0.125D, 0.0062500000931322575D, 0.125D, 0.875D, (double)var5, 0.875D);
      this.func_147784_q(p_147797_1_, p_147797_2_, p_147797_3_, p_147797_4_);
      this.func_147757_a(this.func_147745_b(Blocks.field_150461_bJ));
      this.func_147782_a(0.1875D, (double)var5, 0.1875D, 0.8125D, 0.875D, 0.8125D);
      this.func_147784_q(p_147797_1_, p_147797_2_, p_147797_3_, p_147797_4_);
      this.field_147837_f = false;
      this.func_147771_a();
      return true;
   }

   public boolean func_147755_t(Block p_147755_1_, int p_147755_2_, int p_147755_3_, int p_147755_4_) {
      int var5 = p_147755_1_.func_149720_d(this.field_147845_a, p_147755_2_, p_147755_3_, p_147755_4_);
      float var6 = (float)(var5 >> 16 & 255) / 255.0F;
      float var7 = (float)(var5 >> 8 & 255) / 255.0F;
      float var8 = (float)(var5 & 255) / 255.0F;
      if(EntityRenderer.field_78517_a) {
         float var9 = (var6 * 30.0F + var7 * 59.0F + var8 * 11.0F) / 100.0F;
         float var10 = (var6 * 30.0F + var7 * 70.0F) / 100.0F;
         float var11 = (var6 * 30.0F + var8 * 70.0F) / 100.0F;
         var6 = var9;
         var7 = var10;
         var8 = var11;
      }

      return this.func_147754_e(p_147755_1_, p_147755_2_, p_147755_3_, p_147755_4_, var6, var7, var8);
   }

   public boolean func_147754_e(Block p_147754_1_, int p_147754_2_, int p_147754_3_, int p_147754_4_, float p_147754_5_, float p_147754_6_, float p_147754_7_) {
      Tessellator var8 = Tessellator.field_78398_a;
      boolean var9 = false;
      float var10 = 0.5F;
      float var11 = 1.0F;
      float var12 = 0.8F;
      float var13 = 0.6F;
      float var14 = var10 * p_147754_5_;
      float var15 = var11 * p_147754_5_;
      float var16 = var12 * p_147754_5_;
      float var17 = var13 * p_147754_5_;
      float var18 = var10 * p_147754_6_;
      float var19 = var11 * p_147754_6_;
      float var20 = var12 * p_147754_6_;
      float var21 = var13 * p_147754_6_;
      float var22 = var10 * p_147754_7_;
      float var23 = var11 * p_147754_7_;
      float var24 = var12 * p_147754_7_;
      float var25 = var13 * p_147754_7_;
      float var26 = 0.0625F;
      int var27 = p_147754_1_.func_149677_c(this.field_147845_a, p_147754_2_, p_147754_3_, p_147754_4_);
      if(this.field_147837_f || p_147754_1_.func_149646_a(this.field_147845_a, p_147754_2_, p_147754_3_ - 1, p_147754_4_, 0)) {
         var8.func_78380_c(this.field_147855_j > 0.0D?var27:p_147754_1_.func_149677_c(this.field_147845_a, p_147754_2_, p_147754_3_ - 1, p_147754_4_));
         var8.func_78386_a(var14, var18, var22);
         this.func_147768_a(p_147754_1_, (double)p_147754_2_, (double)p_147754_3_, (double)p_147754_4_, this.func_147793_a(p_147754_1_, this.field_147845_a, p_147754_2_, p_147754_3_, p_147754_4_, 0));
      }

      if(this.field_147837_f || p_147754_1_.func_149646_a(this.field_147845_a, p_147754_2_, p_147754_3_ + 1, p_147754_4_, 1)) {
         var8.func_78380_c(this.field_147857_k < 1.0D?var27:p_147754_1_.func_149677_c(this.field_147845_a, p_147754_2_, p_147754_3_ + 1, p_147754_4_));
         var8.func_78386_a(var15, var19, var23);
         this.func_147806_b(p_147754_1_, (double)p_147754_2_, (double)p_147754_3_, (double)p_147754_4_, this.func_147793_a(p_147754_1_, this.field_147845_a, p_147754_2_, p_147754_3_, p_147754_4_, 1));
      }

      var8.func_78380_c(var27);
      var8.func_78386_a(var16, var20, var24);
      var8.func_78372_c(0.0F, 0.0F, var26);
      this.func_147761_c(p_147754_1_, (double)p_147754_2_, (double)p_147754_3_, (double)p_147754_4_, this.func_147793_a(p_147754_1_, this.field_147845_a, p_147754_2_, p_147754_3_, p_147754_4_, 2));
      var8.func_78372_c(0.0F, 0.0F, -var26);
      var8.func_78372_c(0.0F, 0.0F, -var26);
      this.func_147734_d(p_147754_1_, (double)p_147754_2_, (double)p_147754_3_, (double)p_147754_4_, this.func_147793_a(p_147754_1_, this.field_147845_a, p_147754_2_, p_147754_3_, p_147754_4_, 3));
      var8.func_78372_c(0.0F, 0.0F, var26);
      var8.func_78386_a(var17, var21, var25);
      var8.func_78372_c(var26, 0.0F, 0.0F);
      this.func_147798_e(p_147754_1_, (double)p_147754_2_, (double)p_147754_3_, (double)p_147754_4_, this.func_147793_a(p_147754_1_, this.field_147845_a, p_147754_2_, p_147754_3_, p_147754_4_, 4));
      var8.func_78372_c(-var26, 0.0F, 0.0F);
      var8.func_78372_c(-var26, 0.0F, 0.0F);
      this.func_147764_f(p_147754_1_, (double)p_147754_2_, (double)p_147754_3_, (double)p_147754_4_, this.func_147793_a(p_147754_1_, this.field_147845_a, p_147754_2_, p_147754_3_, p_147754_4_, 5));
      var8.func_78372_c(var26, 0.0F, 0.0F);
      return true;
   }

   public boolean func_147735_a(BlockFence p_147735_1_, int p_147735_2_, int p_147735_3_, int p_147735_4_) {
      boolean var5 = false;
      float var6 = 0.375F;
      float var7 = 0.625F;
      this.func_147782_a((double)var6, 0.0D, (double)var6, (double)var7, 1.0D, (double)var7);
      this.func_147784_q(p_147735_1_, p_147735_2_, p_147735_3_, p_147735_4_);
      var5 = true;
      boolean var8 = false;
      boolean var9 = false;
      if(p_147735_1_.func_149826_e(this.field_147845_a, p_147735_2_ - 1, p_147735_3_, p_147735_4_) || p_147735_1_.func_149826_e(this.field_147845_a, p_147735_2_ + 1, p_147735_3_, p_147735_4_)) {
         var8 = true;
      }

      if(p_147735_1_.func_149826_e(this.field_147845_a, p_147735_2_, p_147735_3_, p_147735_4_ - 1) || p_147735_1_.func_149826_e(this.field_147845_a, p_147735_2_, p_147735_3_, p_147735_4_ + 1)) {
         var9 = true;
      }

      boolean var10 = p_147735_1_.func_149826_e(this.field_147845_a, p_147735_2_ - 1, p_147735_3_, p_147735_4_);
      boolean var11 = p_147735_1_.func_149826_e(this.field_147845_a, p_147735_2_ + 1, p_147735_3_, p_147735_4_);
      boolean var12 = p_147735_1_.func_149826_e(this.field_147845_a, p_147735_2_, p_147735_3_, p_147735_4_ - 1);
      boolean var13 = p_147735_1_.func_149826_e(this.field_147845_a, p_147735_2_, p_147735_3_, p_147735_4_ + 1);
      if(!var8 && !var9) {
         var8 = true;
      }

      var6 = 0.4375F;
      var7 = 0.5625F;
      float var14 = 0.75F;
      float var15 = 0.9375F;
      float var16 = var10?0.0F:var6;
      float var17 = var11?1.0F:var7;
      float var18 = var12?0.0F:var6;
      float var19 = var13?1.0F:var7;
      this.field_152631_f = true;
      if(var8) {
         this.func_147782_a((double)var16, (double)var14, (double)var6, (double)var17, (double)var15, (double)var7);
         this.func_147784_q(p_147735_1_, p_147735_2_, p_147735_3_, p_147735_4_);
         var5 = true;
      }

      if(var9) {
         this.func_147782_a((double)var6, (double)var14, (double)var18, (double)var7, (double)var15, (double)var19);
         this.func_147784_q(p_147735_1_, p_147735_2_, p_147735_3_, p_147735_4_);
         var5 = true;
      }

      var14 = 0.375F;
      var15 = 0.5625F;
      if(var8) {
         this.func_147782_a((double)var16, (double)var14, (double)var6, (double)var17, (double)var15, (double)var7);
         this.func_147784_q(p_147735_1_, p_147735_2_, p_147735_3_, p_147735_4_);
         var5 = true;
      }

      if(var9) {
         this.func_147782_a((double)var6, (double)var14, (double)var18, (double)var7, (double)var15, (double)var19);
         this.func_147784_q(p_147735_1_, p_147735_2_, p_147735_3_, p_147735_4_);
         var5 = true;
      }

      this.field_152631_f = false;
      p_147735_1_.func_149719_a(this.field_147845_a, p_147735_2_, p_147735_3_, p_147735_4_);
      return var5;
   }

   public boolean func_147807_a(BlockWall p_147807_1_, int p_147807_2_, int p_147807_3_, int p_147807_4_) {
      boolean var5 = p_147807_1_.func_150091_e(this.field_147845_a, p_147807_2_ - 1, p_147807_3_, p_147807_4_);
      boolean var6 = p_147807_1_.func_150091_e(this.field_147845_a, p_147807_2_ + 1, p_147807_3_, p_147807_4_);
      boolean var7 = p_147807_1_.func_150091_e(this.field_147845_a, p_147807_2_, p_147807_3_, p_147807_4_ - 1);
      boolean var8 = p_147807_1_.func_150091_e(this.field_147845_a, p_147807_2_, p_147807_3_, p_147807_4_ + 1);
      boolean var9 = var7 && var8 && !var5 && !var6;
      boolean var10 = !var7 && !var8 && var5 && var6;
      boolean var11 = this.field_147845_a.func_147437_c(p_147807_2_, p_147807_3_ + 1, p_147807_4_);
      if((var9 || var10) && var11) {
         if(var9) {
            this.func_147782_a(0.3125D, 0.0D, 0.0D, 0.6875D, 0.8125D, 1.0D);
            this.func_147784_q(p_147807_1_, p_147807_2_, p_147807_3_, p_147807_4_);
         } else {
            this.func_147782_a(0.0D, 0.0D, 0.3125D, 1.0D, 0.8125D, 0.6875D);
            this.func_147784_q(p_147807_1_, p_147807_2_, p_147807_3_, p_147807_4_);
         }
      } else {
         this.func_147782_a(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D);
         this.func_147784_q(p_147807_1_, p_147807_2_, p_147807_3_, p_147807_4_);
         if(var5) {
            this.func_147782_a(0.0D, 0.0D, 0.3125D, 0.25D, 0.8125D, 0.6875D);
            this.func_147784_q(p_147807_1_, p_147807_2_, p_147807_3_, p_147807_4_);
         }

         if(var6) {
            this.func_147782_a(0.75D, 0.0D, 0.3125D, 1.0D, 0.8125D, 0.6875D);
            this.func_147784_q(p_147807_1_, p_147807_2_, p_147807_3_, p_147807_4_);
         }

         if(var7) {
            this.func_147782_a(0.3125D, 0.0D, 0.0D, 0.6875D, 0.8125D, 0.25D);
            this.func_147784_q(p_147807_1_, p_147807_2_, p_147807_3_, p_147807_4_);
         }

         if(var8) {
            this.func_147782_a(0.3125D, 0.0D, 0.75D, 0.6875D, 0.8125D, 1.0D);
            this.func_147784_q(p_147807_1_, p_147807_2_, p_147807_3_, p_147807_4_);
         }
      }

      p_147807_1_.func_149719_a(this.field_147845_a, p_147807_2_, p_147807_3_, p_147807_4_);
      return true;
   }

   public boolean func_147802_a(BlockDragonEgg p_147802_1_, int p_147802_2_, int p_147802_3_, int p_147802_4_) {
      boolean var5 = false;
      int var6 = 0;

      for(int var7 = 0; var7 < 8; ++var7) {
         byte var8 = 0;
         byte var9 = 1;
         if(var7 == 0) {
            var8 = 2;
         }

         if(var7 == 1) {
            var8 = 3;
         }

         if(var7 == 2) {
            var8 = 4;
         }

         if(var7 == 3) {
            var8 = 5;
            var9 = 2;
         }

         if(var7 == 4) {
            var8 = 6;
            var9 = 3;
         }

         if(var7 == 5) {
            var8 = 7;
            var9 = 5;
         }

         if(var7 == 6) {
            var8 = 6;
            var9 = 2;
         }

         if(var7 == 7) {
            var8 = 3;
         }

         float var10 = (float)var8 / 16.0F;
         float var11 = 1.0F - (float)var6 / 16.0F;
         float var12 = 1.0F - (float)(var6 + var9) / 16.0F;
         var6 += var9;
         this.func_147782_a((double)(0.5F - var10), (double)var12, (double)(0.5F - var10), (double)(0.5F + var10), (double)var11, (double)(0.5F + var10));
         this.func_147784_q(p_147802_1_, p_147802_2_, p_147802_3_, p_147802_4_);
      }

      var5 = true;
      this.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
      return var5;
   }

   public boolean func_147776_a(BlockFenceGate p_147776_1_, int p_147776_2_, int p_147776_3_, int p_147776_4_) {
      boolean var5 = true;
      int var6 = this.field_147845_a.func_72805_g(p_147776_2_, p_147776_3_, p_147776_4_);
      boolean var7 = BlockFenceGate.func_149896_b(var6);
      int var8 = BlockDirectional.func_149895_l(var6);
      float var9 = 0.375F;
      float var10 = 0.5625F;
      float var11 = 0.75F;
      float var12 = 0.9375F;
      float var13 = 0.3125F;
      float var14 = 1.0F;
      if((var8 == 2 || var8 == 0) && this.field_147845_a.func_147439_a(p_147776_2_ - 1, p_147776_3_, p_147776_4_) == Blocks.field_150463_bK && this.field_147845_a.func_147439_a(p_147776_2_ + 1, p_147776_3_, p_147776_4_) == Blocks.field_150463_bK || (var8 == 3 || var8 == 1) && this.field_147845_a.func_147439_a(p_147776_2_, p_147776_3_, p_147776_4_ - 1) == Blocks.field_150463_bK && this.field_147845_a.func_147439_a(p_147776_2_, p_147776_3_, p_147776_4_ + 1) == Blocks.field_150463_bK) {
         var9 -= 0.1875F;
         var10 -= 0.1875F;
         var11 -= 0.1875F;
         var12 -= 0.1875F;
         var13 -= 0.1875F;
         var14 -= 0.1875F;
      }

      this.field_147837_f = true;
      float var15;
      float var16;
      float var17;
      float var18;
      if(var8 != 3 && var8 != 1) {
         var15 = 0.0F;
         var16 = 0.125F;
         var17 = 0.4375F;
         var18 = 0.5625F;
         this.func_147782_a((double)var15, (double)var13, (double)var17, (double)var16, (double)var14, (double)var18);
         this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
         var15 = 0.875F;
         var16 = 1.0F;
         this.func_147782_a((double)var15, (double)var13, (double)var17, (double)var16, (double)var14, (double)var18);
         this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
      } else {
         this.field_147867_u = 1;
         var15 = 0.4375F;
         var16 = 0.5625F;
         var17 = 0.0F;
         var18 = 0.125F;
         this.func_147782_a((double)var15, (double)var13, (double)var17, (double)var16, (double)var14, (double)var18);
         this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
         var17 = 0.875F;
         var18 = 1.0F;
         this.func_147782_a((double)var15, (double)var13, (double)var17, (double)var16, (double)var14, (double)var18);
         this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
         this.field_147867_u = 0;
      }

      if(var7) {
         if(var8 == 2 || var8 == 0) {
            this.field_147867_u = 1;
         }

         float var19;
         float var20;
         float var21;
         if(var8 == 3) {
            var15 = 0.0F;
            var16 = 0.125F;
            var17 = 0.875F;
            var18 = 1.0F;
            var19 = 0.5625F;
            var20 = 0.8125F;
            var21 = 0.9375F;
            this.func_147782_a(0.8125D, (double)var9, 0.0D, 0.9375D, (double)var12, 0.125D);
            this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
            this.func_147782_a(0.8125D, (double)var9, 0.875D, 0.9375D, (double)var12, 1.0D);
            this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
            this.func_147782_a(0.5625D, (double)var9, 0.0D, 0.8125D, (double)var10, 0.125D);
            this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
            this.func_147782_a(0.5625D, (double)var9, 0.875D, 0.8125D, (double)var10, 1.0D);
            this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
            this.func_147782_a(0.5625D, (double)var11, 0.0D, 0.8125D, (double)var12, 0.125D);
            this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
            this.func_147782_a(0.5625D, (double)var11, 0.875D, 0.8125D, (double)var12, 1.0D);
            this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
         } else if(var8 == 1) {
            var15 = 0.0F;
            var16 = 0.125F;
            var17 = 0.875F;
            var18 = 1.0F;
            var19 = 0.0625F;
            var20 = 0.1875F;
            var21 = 0.4375F;
            this.func_147782_a(0.0625D, (double)var9, 0.0D, 0.1875D, (double)var12, 0.125D);
            this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
            this.func_147782_a(0.0625D, (double)var9, 0.875D, 0.1875D, (double)var12, 1.0D);
            this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
            this.func_147782_a(0.1875D, (double)var9, 0.0D, 0.4375D, (double)var10, 0.125D);
            this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
            this.func_147782_a(0.1875D, (double)var9, 0.875D, 0.4375D, (double)var10, 1.0D);
            this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
            this.func_147782_a(0.1875D, (double)var11, 0.0D, 0.4375D, (double)var12, 0.125D);
            this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
            this.func_147782_a(0.1875D, (double)var11, 0.875D, 0.4375D, (double)var12, 1.0D);
            this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
         } else if(var8 == 0) {
            var15 = 0.0F;
            var16 = 0.125F;
            var17 = 0.875F;
            var18 = 1.0F;
            var19 = 0.5625F;
            var20 = 0.8125F;
            var21 = 0.9375F;
            this.func_147782_a(0.0D, (double)var9, 0.8125D, 0.125D, (double)var12, 0.9375D);
            this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
            this.func_147782_a(0.875D, (double)var9, 0.8125D, 1.0D, (double)var12, 0.9375D);
            this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
            this.func_147782_a(0.0D, (double)var9, 0.5625D, 0.125D, (double)var10, 0.8125D);
            this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
            this.func_147782_a(0.875D, (double)var9, 0.5625D, 1.0D, (double)var10, 0.8125D);
            this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
            this.func_147782_a(0.0D, (double)var11, 0.5625D, 0.125D, (double)var12, 0.8125D);
            this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
            this.func_147782_a(0.875D, (double)var11, 0.5625D, 1.0D, (double)var12, 0.8125D);
            this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
         } else if(var8 == 2) {
            var15 = 0.0F;
            var16 = 0.125F;
            var17 = 0.875F;
            var18 = 1.0F;
            var19 = 0.0625F;
            var20 = 0.1875F;
            var21 = 0.4375F;
            this.func_147782_a(0.0D, (double)var9, 0.0625D, 0.125D, (double)var12, 0.1875D);
            this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
            this.func_147782_a(0.875D, (double)var9, 0.0625D, 1.0D, (double)var12, 0.1875D);
            this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
            this.func_147782_a(0.0D, (double)var9, 0.1875D, 0.125D, (double)var10, 0.4375D);
            this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
            this.func_147782_a(0.875D, (double)var9, 0.1875D, 1.0D, (double)var10, 0.4375D);
            this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
            this.func_147782_a(0.0D, (double)var11, 0.1875D, 0.125D, (double)var12, 0.4375D);
            this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
            this.func_147782_a(0.875D, (double)var11, 0.1875D, 1.0D, (double)var12, 0.4375D);
            this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
         }
      } else if(var8 != 3 && var8 != 1) {
         var15 = 0.375F;
         var16 = 0.5F;
         var17 = 0.4375F;
         var18 = 0.5625F;
         this.func_147782_a((double)var15, (double)var9, (double)var17, (double)var16, (double)var12, (double)var18);
         this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
         var15 = 0.5F;
         var16 = 0.625F;
         this.func_147782_a((double)var15, (double)var9, (double)var17, (double)var16, (double)var12, (double)var18);
         this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
         var15 = 0.625F;
         var16 = 0.875F;
         this.func_147782_a((double)var15, (double)var9, (double)var17, (double)var16, (double)var10, (double)var18);
         this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
         this.func_147782_a((double)var15, (double)var11, (double)var17, (double)var16, (double)var12, (double)var18);
         this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
         var15 = 0.125F;
         var16 = 0.375F;
         this.func_147782_a((double)var15, (double)var9, (double)var17, (double)var16, (double)var10, (double)var18);
         this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
         this.func_147782_a((double)var15, (double)var11, (double)var17, (double)var16, (double)var12, (double)var18);
         this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
      } else {
         this.field_147867_u = 1;
         var15 = 0.4375F;
         var16 = 0.5625F;
         var17 = 0.375F;
         var18 = 0.5F;
         this.func_147782_a((double)var15, (double)var9, (double)var17, (double)var16, (double)var12, (double)var18);
         this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
         var17 = 0.5F;
         var18 = 0.625F;
         this.func_147782_a((double)var15, (double)var9, (double)var17, (double)var16, (double)var12, (double)var18);
         this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
         var17 = 0.625F;
         var18 = 0.875F;
         this.func_147782_a((double)var15, (double)var9, (double)var17, (double)var16, (double)var10, (double)var18);
         this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
         this.func_147782_a((double)var15, (double)var11, (double)var17, (double)var16, (double)var12, (double)var18);
         this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
         var17 = 0.125F;
         var18 = 0.375F;
         this.func_147782_a((double)var15, (double)var9, (double)var17, (double)var16, (double)var10, (double)var18);
         this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
         this.func_147782_a((double)var15, (double)var11, (double)var17, (double)var16, (double)var12, (double)var18);
         this.func_147784_q(p_147776_1_, p_147776_2_, p_147776_3_, p_147776_4_);
      }

      this.field_147837_f = false;
      this.field_147867_u = 0;
      this.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
      return var5;
   }

   private boolean func_147803_a(BlockHopper p_147803_1_, int p_147803_2_, int p_147803_3_, int p_147803_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      var5.func_78380_c(p_147803_1_.func_149677_c(this.field_147845_a, p_147803_2_, p_147803_3_, p_147803_4_));
      int var6 = p_147803_1_.func_149720_d(this.field_147845_a, p_147803_2_, p_147803_3_, p_147803_4_);
      float var7 = (float)(var6 >> 16 & 255) / 255.0F;
      float var8 = (float)(var6 >> 8 & 255) / 255.0F;
      float var9 = (float)(var6 & 255) / 255.0F;
      if(EntityRenderer.field_78517_a) {
         float var10 = (var7 * 30.0F + var8 * 59.0F + var9 * 11.0F) / 100.0F;
         float var11 = (var7 * 30.0F + var8 * 70.0F) / 100.0F;
         float var12 = (var7 * 30.0F + var9 * 70.0F) / 100.0F;
         var7 = var10;
         var8 = var11;
         var9 = var12;
      }

      var5.func_78386_a(var7, var8, var9);
      return this.func_147799_a(p_147803_1_, p_147803_2_, p_147803_3_, p_147803_4_, this.field_147845_a.func_72805_g(p_147803_2_, p_147803_3_, p_147803_4_), false);
   }

   private boolean func_147799_a(BlockHopper p_147799_1_, int p_147799_2_, int p_147799_3_, int p_147799_4_, int p_147799_5_, boolean p_147799_6_) {
      Tessellator var7 = Tessellator.field_78398_a;
      int var8 = BlockHopper.func_149918_b(p_147799_5_);
      double var9 = 0.625D;
      this.func_147782_a(0.0D, var9, 0.0D, 1.0D, 1.0D, 1.0D);
      if(p_147799_6_) {
         var7.func_78382_b();
         var7.func_78375_b(0.0F, -1.0F, 0.0F);
         this.func_147768_a(p_147799_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147799_1_, 0, p_147799_5_));
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(0.0F, 1.0F, 0.0F);
         this.func_147806_b(p_147799_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147799_1_, 1, p_147799_5_));
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(0.0F, 0.0F, -1.0F);
         this.func_147761_c(p_147799_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147799_1_, 2, p_147799_5_));
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(0.0F, 0.0F, 1.0F);
         this.func_147734_d(p_147799_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147799_1_, 3, p_147799_5_));
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(-1.0F, 0.0F, 0.0F);
         this.func_147798_e(p_147799_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147799_1_, 4, p_147799_5_));
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(1.0F, 0.0F, 0.0F);
         this.func_147764_f(p_147799_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147799_1_, 5, p_147799_5_));
         var7.func_78381_a();
      } else {
         this.func_147784_q(p_147799_1_, p_147799_2_, p_147799_3_, p_147799_4_);
      }

      float var13;
      if(!p_147799_6_) {
         var7.func_78380_c(p_147799_1_.func_149677_c(this.field_147845_a, p_147799_2_, p_147799_3_, p_147799_4_));
         int var11 = p_147799_1_.func_149720_d(this.field_147845_a, p_147799_2_, p_147799_3_, p_147799_4_);
         float var12 = (float)(var11 >> 16 & 255) / 255.0F;
         var13 = (float)(var11 >> 8 & 255) / 255.0F;
         float var14 = (float)(var11 & 255) / 255.0F;
         if(EntityRenderer.field_78517_a) {
            float var15 = (var12 * 30.0F + var13 * 59.0F + var14 * 11.0F) / 100.0F;
            float var16 = (var12 * 30.0F + var13 * 70.0F) / 100.0F;
            float var17 = (var12 * 30.0F + var14 * 70.0F) / 100.0F;
            var12 = var15;
            var13 = var16;
            var14 = var17;
         }

         var7.func_78386_a(var12, var13, var14);
      }

      IIcon var24 = BlockHopper.func_149916_e("hopper_outside");
      IIcon var25 = BlockHopper.func_149916_e("hopper_inside");
      var13 = 0.125F;
      if(p_147799_6_) {
         var7.func_78382_b();
         var7.func_78375_b(1.0F, 0.0F, 0.0F);
         this.func_147764_f(p_147799_1_, (double)(-1.0F + var13), 0.0D, 0.0D, var24);
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(-1.0F, 0.0F, 0.0F);
         this.func_147798_e(p_147799_1_, (double)(1.0F - var13), 0.0D, 0.0D, var24);
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(0.0F, 0.0F, 1.0F);
         this.func_147734_d(p_147799_1_, 0.0D, 0.0D, (double)(-1.0F + var13), var24);
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(0.0F, 0.0F, -1.0F);
         this.func_147761_c(p_147799_1_, 0.0D, 0.0D, (double)(1.0F - var13), var24);
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(0.0F, 1.0F, 0.0F);
         this.func_147806_b(p_147799_1_, 0.0D, -1.0D + var9, 0.0D, var25);
         var7.func_78381_a();
      } else {
         this.func_147764_f(p_147799_1_, (double)((float)p_147799_2_ - 1.0F + var13), (double)p_147799_3_, (double)p_147799_4_, var24);
         this.func_147798_e(p_147799_1_, (double)((float)p_147799_2_ + 1.0F - var13), (double)p_147799_3_, (double)p_147799_4_, var24);
         this.func_147734_d(p_147799_1_, (double)p_147799_2_, (double)p_147799_3_, (double)((float)p_147799_4_ - 1.0F + var13), var24);
         this.func_147761_c(p_147799_1_, (double)p_147799_2_, (double)p_147799_3_, (double)((float)p_147799_4_ + 1.0F - var13), var24);
         this.func_147806_b(p_147799_1_, (double)p_147799_2_, (double)((float)p_147799_3_ - 1.0F) + var9, (double)p_147799_4_, var25);
      }

      this.func_147757_a(var24);
      double var26 = 0.25D;
      double var27 = 0.25D;
      this.func_147782_a(var26, var27, var26, 1.0D - var26, var9 - 0.002D, 1.0D - var26);
      if(p_147799_6_) {
         var7.func_78382_b();
         var7.func_78375_b(1.0F, 0.0F, 0.0F);
         this.func_147764_f(p_147799_1_, 0.0D, 0.0D, 0.0D, var24);
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(-1.0F, 0.0F, 0.0F);
         this.func_147798_e(p_147799_1_, 0.0D, 0.0D, 0.0D, var24);
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(0.0F, 0.0F, 1.0F);
         this.func_147734_d(p_147799_1_, 0.0D, 0.0D, 0.0D, var24);
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(0.0F, 0.0F, -1.0F);
         this.func_147761_c(p_147799_1_, 0.0D, 0.0D, 0.0D, var24);
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(0.0F, 1.0F, 0.0F);
         this.func_147806_b(p_147799_1_, 0.0D, 0.0D, 0.0D, var24);
         var7.func_78381_a();
         var7.func_78382_b();
         var7.func_78375_b(0.0F, -1.0F, 0.0F);
         this.func_147768_a(p_147799_1_, 0.0D, 0.0D, 0.0D, var24);
         var7.func_78381_a();
      } else {
         this.func_147784_q(p_147799_1_, p_147799_2_, p_147799_3_, p_147799_4_);
      }

      if(!p_147799_6_) {
         double var20 = 0.375D;
         double var22 = 0.25D;
         this.func_147757_a(var24);
         if(var8 == 0) {
            this.func_147782_a(var20, 0.0D, var20, 1.0D - var20, 0.25D, 1.0D - var20);
            this.func_147784_q(p_147799_1_, p_147799_2_, p_147799_3_, p_147799_4_);
         }

         if(var8 == 2) {
            this.func_147782_a(var20, var27, 0.0D, 1.0D - var20, var27 + var22, var26);
            this.func_147784_q(p_147799_1_, p_147799_2_, p_147799_3_, p_147799_4_);
         }

         if(var8 == 3) {
            this.func_147782_a(var20, var27, 1.0D - var26, 1.0D - var20, var27 + var22, 1.0D);
            this.func_147784_q(p_147799_1_, p_147799_2_, p_147799_3_, p_147799_4_);
         }

         if(var8 == 4) {
            this.func_147782_a(0.0D, var27, var20, var26, var27 + var22, 1.0D - var20);
            this.func_147784_q(p_147799_1_, p_147799_2_, p_147799_3_, p_147799_4_);
         }

         if(var8 == 5) {
            this.func_147782_a(1.0D - var26, var27, var20, 1.0D, var27 + var22, 1.0D - var20);
            this.func_147784_q(p_147799_1_, p_147799_2_, p_147799_3_, p_147799_4_);
         }
      }

      this.func_147771_a();
      return true;
   }

   public boolean func_147722_a(BlockStairs p_147722_1_, int p_147722_2_, int p_147722_3_, int p_147722_4_) {
      p_147722_1_.func_150147_e(this.field_147845_a, p_147722_2_, p_147722_3_, p_147722_4_);
      this.func_147775_a(p_147722_1_);
      this.func_147784_q(p_147722_1_, p_147722_2_, p_147722_3_, p_147722_4_);
      this.field_152631_f = true;
      boolean var5 = p_147722_1_.func_150145_f(this.field_147845_a, p_147722_2_, p_147722_3_, p_147722_4_);
      this.func_147775_a(p_147722_1_);
      this.func_147784_q(p_147722_1_, p_147722_2_, p_147722_3_, p_147722_4_);
      if(var5 && p_147722_1_.func_150144_g(this.field_147845_a, p_147722_2_, p_147722_3_, p_147722_4_)) {
         this.func_147775_a(p_147722_1_);
         this.func_147784_q(p_147722_1_, p_147722_2_, p_147722_3_, p_147722_4_);
      }

      this.field_152631_f = false;
      return true;
   }

   public boolean func_147760_u(Block p_147760_1_, int p_147760_2_, int p_147760_3_, int p_147760_4_) {
      Tessellator var5 = Tessellator.field_78398_a;
      int var6 = this.field_147845_a.func_72805_g(p_147760_2_, p_147760_3_, p_147760_4_);
      if((var6 & 8) != 0) {
         if(this.field_147845_a.func_147439_a(p_147760_2_, p_147760_3_ - 1, p_147760_4_) != p_147760_1_) {
            return false;
         }
      } else if(this.field_147845_a.func_147439_a(p_147760_2_, p_147760_3_ + 1, p_147760_4_) != p_147760_1_) {
         return false;
      }

      boolean var7 = false;
      float var8 = 0.5F;
      float var9 = 1.0F;
      float var10 = 0.8F;
      float var11 = 0.6F;
      int var12 = p_147760_1_.func_149677_c(this.field_147845_a, p_147760_2_, p_147760_3_, p_147760_4_);
      var5.func_78380_c(this.field_147855_j > 0.0D?var12:p_147760_1_.func_149677_c(this.field_147845_a, p_147760_2_, p_147760_3_ - 1, p_147760_4_));
      var5.func_78386_a(var8, var8, var8);
      this.func_147768_a(p_147760_1_, (double)p_147760_2_, (double)p_147760_3_, (double)p_147760_4_, this.func_147793_a(p_147760_1_, this.field_147845_a, p_147760_2_, p_147760_3_, p_147760_4_, 0));
      var7 = true;
      var5.func_78380_c(this.field_147857_k < 1.0D?var12:p_147760_1_.func_149677_c(this.field_147845_a, p_147760_2_, p_147760_3_ + 1, p_147760_4_));
      var5.func_78386_a(var9, var9, var9);
      this.func_147806_b(p_147760_1_, (double)p_147760_2_, (double)p_147760_3_, (double)p_147760_4_, this.func_147793_a(p_147760_1_, this.field_147845_a, p_147760_2_, p_147760_3_, p_147760_4_, 1));
      var7 = true;
      var5.func_78380_c(this.field_147851_l > 0.0D?var12:p_147760_1_.func_149677_c(this.field_147845_a, p_147760_2_, p_147760_3_, p_147760_4_ - 1));
      var5.func_78386_a(var10, var10, var10);
      IIcon var13 = this.func_147793_a(p_147760_1_, this.field_147845_a, p_147760_2_, p_147760_3_, p_147760_4_, 2);
      this.func_147761_c(p_147760_1_, (double)p_147760_2_, (double)p_147760_3_, (double)p_147760_4_, var13);
      var7 = true;
      this.field_147842_e = false;
      var5.func_78380_c(this.field_147853_m < 1.0D?var12:p_147760_1_.func_149677_c(this.field_147845_a, p_147760_2_, p_147760_3_, p_147760_4_ + 1));
      var5.func_78386_a(var10, var10, var10);
      var13 = this.func_147793_a(p_147760_1_, this.field_147845_a, p_147760_2_, p_147760_3_, p_147760_4_, 3);
      this.func_147734_d(p_147760_1_, (double)p_147760_2_, (double)p_147760_3_, (double)p_147760_4_, var13);
      var7 = true;
      this.field_147842_e = false;
      var5.func_78380_c(this.field_147859_h > 0.0D?var12:p_147760_1_.func_149677_c(this.field_147845_a, p_147760_2_ - 1, p_147760_3_, p_147760_4_));
      var5.func_78386_a(var11, var11, var11);
      var13 = this.func_147793_a(p_147760_1_, this.field_147845_a, p_147760_2_, p_147760_3_, p_147760_4_, 4);
      this.func_147798_e(p_147760_1_, (double)p_147760_2_, (double)p_147760_3_, (double)p_147760_4_, var13);
      var7 = true;
      this.field_147842_e = false;
      var5.func_78380_c(this.field_147861_i < 1.0D?var12:p_147760_1_.func_149677_c(this.field_147845_a, p_147760_2_ + 1, p_147760_3_, p_147760_4_));
      var5.func_78386_a(var11, var11, var11);
      var13 = this.func_147793_a(p_147760_1_, this.field_147845_a, p_147760_2_, p_147760_3_, p_147760_4_, 5);
      this.func_147764_f(p_147760_1_, (double)p_147760_2_, (double)p_147760_3_, (double)p_147760_4_, var13);
      var7 = true;
      this.field_147842_e = false;
      return var7;
   }

   public void func_147768_a(Block p_147768_1_, double p_147768_2_, double p_147768_4_, double p_147768_6_, IIcon p_147768_8_) {
      Tessellator var9 = Tessellator.field_78398_a;
      if(this.func_147744_b()) {
         p_147768_8_ = this.field_147840_d;
      }

      double var10 = (double)p_147768_8_.func_94214_a(this.field_147859_h * 16.0D);
      double var12 = (double)p_147768_8_.func_94214_a(this.field_147861_i * 16.0D);
      double var14 = (double)p_147768_8_.func_94207_b(this.field_147851_l * 16.0D);
      double var16 = (double)p_147768_8_.func_94207_b(this.field_147853_m * 16.0D);
      if(this.field_147859_h < 0.0D || this.field_147861_i > 1.0D) {
         var10 = (double)p_147768_8_.func_94209_e();
         var12 = (double)p_147768_8_.func_94212_f();
      }

      if(this.field_147851_l < 0.0D || this.field_147853_m > 1.0D) {
         var14 = (double)p_147768_8_.func_94206_g();
         var16 = (double)p_147768_8_.func_94210_h();
      }

      double var18 = var12;
      double var20 = var10;
      double var22 = var14;
      double var24 = var16;
      if(this.field_147865_v == 2) {
         var10 = (double)p_147768_8_.func_94214_a(this.field_147851_l * 16.0D);
         var14 = (double)p_147768_8_.func_94207_b(16.0D - this.field_147861_i * 16.0D);
         var12 = (double)p_147768_8_.func_94214_a(this.field_147853_m * 16.0D);
         var16 = (double)p_147768_8_.func_94207_b(16.0D - this.field_147859_h * 16.0D);
         var22 = var14;
         var24 = var16;
         var18 = var10;
         var20 = var12;
         var14 = var16;
         var16 = var22;
      } else if(this.field_147865_v == 1) {
         var10 = (double)p_147768_8_.func_94214_a(16.0D - this.field_147853_m * 16.0D);
         var14 = (double)p_147768_8_.func_94207_b(this.field_147859_h * 16.0D);
         var12 = (double)p_147768_8_.func_94214_a(16.0D - this.field_147851_l * 16.0D);
         var16 = (double)p_147768_8_.func_94207_b(this.field_147861_i * 16.0D);
         var18 = var12;
         var20 = var10;
         var10 = var12;
         var12 = var20;
         var22 = var16;
         var24 = var14;
      } else if(this.field_147865_v == 3) {
         var10 = (double)p_147768_8_.func_94214_a(16.0D - this.field_147859_h * 16.0D);
         var12 = (double)p_147768_8_.func_94214_a(16.0D - this.field_147861_i * 16.0D);
         var14 = (double)p_147768_8_.func_94207_b(16.0D - this.field_147851_l * 16.0D);
         var16 = (double)p_147768_8_.func_94207_b(16.0D - this.field_147853_m * 16.0D);
         var18 = var12;
         var20 = var10;
         var22 = var14;
         var24 = var16;
      }

      double var26 = p_147768_2_ + this.field_147859_h;
      double var28 = p_147768_2_ + this.field_147861_i;
      double var30 = p_147768_4_ + this.field_147855_j;
      double var32 = p_147768_6_ + this.field_147851_l;
      double var34 = p_147768_6_ + this.field_147853_m;
      if(this.field_147838_g) {
         var26 = p_147768_2_ + this.field_147861_i;
         var28 = p_147768_2_ + this.field_147859_h;
      }

      if(this.field_147863_w) {
         var9.func_78386_a(this.field_147872_ap, this.field_147846_at, this.field_147854_ax);
         var9.func_78380_c(this.field_147864_al);
         var9.func_78374_a(var26, var30, var34, var20, var24);
         var9.func_78386_a(this.field_147852_aq, this.field_147860_au, this.field_147841_ay);
         var9.func_78380_c(this.field_147874_am);
         var9.func_78374_a(var26, var30, var32, var10, var14);
         var9.func_78386_a(this.field_147850_ar, this.field_147858_av, this.field_147839_az);
         var9.func_78380_c(this.field_147876_an);
         var9.func_78374_a(var28, var30, var32, var18, var22);
         var9.func_78386_a(this.field_147848_as, this.field_147856_aw, this.field_147833_aA);
         var9.func_78380_c(this.field_147870_ao);
         var9.func_78374_a(var28, var30, var34, var12, var16);
      } else {
         var9.func_78374_a(var26, var30, var34, var20, var24);
         var9.func_78374_a(var26, var30, var32, var10, var14);
         var9.func_78374_a(var28, var30, var32, var18, var22);
         var9.func_78374_a(var28, var30, var34, var12, var16);
      }

   }

   public void func_147806_b(Block p_147806_1_, double p_147806_2_, double p_147806_4_, double p_147806_6_, IIcon p_147806_8_) {
      Tessellator var9 = Tessellator.field_78398_a;
      if(this.func_147744_b()) {
         p_147806_8_ = this.field_147840_d;
      }

      double var10 = (double)p_147806_8_.func_94214_a(this.field_147859_h * 16.0D);
      double var12 = (double)p_147806_8_.func_94214_a(this.field_147861_i * 16.0D);
      double var14 = (double)p_147806_8_.func_94207_b(this.field_147851_l * 16.0D);
      double var16 = (double)p_147806_8_.func_94207_b(this.field_147853_m * 16.0D);
      if(this.field_147859_h < 0.0D || this.field_147861_i > 1.0D) {
         var10 = (double)p_147806_8_.func_94209_e();
         var12 = (double)p_147806_8_.func_94212_f();
      }

      if(this.field_147851_l < 0.0D || this.field_147853_m > 1.0D) {
         var14 = (double)p_147806_8_.func_94206_g();
         var16 = (double)p_147806_8_.func_94210_h();
      }

      double var18 = var12;
      double var20 = var10;
      double var22 = var14;
      double var24 = var16;
      if(this.field_147867_u == 1) {
         var10 = (double)p_147806_8_.func_94214_a(this.field_147851_l * 16.0D);
         var14 = (double)p_147806_8_.func_94207_b(16.0D - this.field_147861_i * 16.0D);
         var12 = (double)p_147806_8_.func_94214_a(this.field_147853_m * 16.0D);
         var16 = (double)p_147806_8_.func_94207_b(16.0D - this.field_147859_h * 16.0D);
         var22 = var14;
         var24 = var16;
         var18 = var10;
         var20 = var12;
         var14 = var16;
         var16 = var22;
      } else if(this.field_147867_u == 2) {
         var10 = (double)p_147806_8_.func_94214_a(16.0D - this.field_147853_m * 16.0D);
         var14 = (double)p_147806_8_.func_94207_b(this.field_147859_h * 16.0D);
         var12 = (double)p_147806_8_.func_94214_a(16.0D - this.field_147851_l * 16.0D);
         var16 = (double)p_147806_8_.func_94207_b(this.field_147861_i * 16.0D);
         var18 = var12;
         var20 = var10;
         var10 = var12;
         var12 = var20;
         var22 = var16;
         var24 = var14;
      } else if(this.field_147867_u == 3) {
         var10 = (double)p_147806_8_.func_94214_a(16.0D - this.field_147859_h * 16.0D);
         var12 = (double)p_147806_8_.func_94214_a(16.0D - this.field_147861_i * 16.0D);
         var14 = (double)p_147806_8_.func_94207_b(16.0D - this.field_147851_l * 16.0D);
         var16 = (double)p_147806_8_.func_94207_b(16.0D - this.field_147853_m * 16.0D);
         var18 = var12;
         var20 = var10;
         var22 = var14;
         var24 = var16;
      }

      double var26 = p_147806_2_ + this.field_147859_h;
      double var28 = p_147806_2_ + this.field_147861_i;
      double var30 = p_147806_4_ + this.field_147857_k;
      double var32 = p_147806_6_ + this.field_147851_l;
      double var34 = p_147806_6_ + this.field_147853_m;
      if(this.field_147838_g) {
         var26 = p_147806_2_ + this.field_147861_i;
         var28 = p_147806_2_ + this.field_147859_h;
      }

      if(this.field_147863_w) {
         var9.func_78386_a(this.field_147872_ap, this.field_147846_at, this.field_147854_ax);
         var9.func_78380_c(this.field_147864_al);
         var9.func_78374_a(var28, var30, var34, var12, var16);
         var9.func_78386_a(this.field_147852_aq, this.field_147860_au, this.field_147841_ay);
         var9.func_78380_c(this.field_147874_am);
         var9.func_78374_a(var28, var30, var32, var18, var22);
         var9.func_78386_a(this.field_147850_ar, this.field_147858_av, this.field_147839_az);
         var9.func_78380_c(this.field_147876_an);
         var9.func_78374_a(var26, var30, var32, var10, var14);
         var9.func_78386_a(this.field_147848_as, this.field_147856_aw, this.field_147833_aA);
         var9.func_78380_c(this.field_147870_ao);
         var9.func_78374_a(var26, var30, var34, var20, var24);
      } else {
         var9.func_78374_a(var28, var30, var34, var12, var16);
         var9.func_78374_a(var28, var30, var32, var18, var22);
         var9.func_78374_a(var26, var30, var32, var10, var14);
         var9.func_78374_a(var26, var30, var34, var20, var24);
      }

   }

   public void func_147761_c(Block p_147761_1_, double p_147761_2_, double p_147761_4_, double p_147761_6_, IIcon p_147761_8_) {
      Tessellator var9 = Tessellator.field_78398_a;
      if(this.func_147744_b()) {
         p_147761_8_ = this.field_147840_d;
      }

      double var10 = (double)p_147761_8_.func_94214_a(this.field_147859_h * 16.0D);
      double var12 = (double)p_147761_8_.func_94214_a(this.field_147861_i * 16.0D);
      if(this.field_152631_f) {
         var12 = (double)p_147761_8_.func_94214_a((1.0D - this.field_147859_h) * 16.0D);
         var10 = (double)p_147761_8_.func_94214_a((1.0D - this.field_147861_i) * 16.0D);
      }

      double var14 = (double)p_147761_8_.func_94207_b(16.0D - this.field_147857_k * 16.0D);
      double var16 = (double)p_147761_8_.func_94207_b(16.0D - this.field_147855_j * 16.0D);
      double var18;
      if(this.field_147842_e) {
         var18 = var10;
         var10 = var12;
         var12 = var18;
      }

      if(this.field_147859_h < 0.0D || this.field_147861_i > 1.0D) {
         var10 = (double)p_147761_8_.func_94209_e();
         var12 = (double)p_147761_8_.func_94212_f();
      }

      if(this.field_147855_j < 0.0D || this.field_147857_k > 1.0D) {
         var14 = (double)p_147761_8_.func_94206_g();
         var16 = (double)p_147761_8_.func_94210_h();
      }

      var18 = var12;
      double var20 = var10;
      double var22 = var14;
      double var24 = var16;
      if(this.field_147875_q == 2) {
         var10 = (double)p_147761_8_.func_94214_a(this.field_147855_j * 16.0D);
         var12 = (double)p_147761_8_.func_94214_a(this.field_147857_k * 16.0D);
         var14 = (double)p_147761_8_.func_94207_b(16.0D - this.field_147859_h * 16.0D);
         var16 = (double)p_147761_8_.func_94207_b(16.0D - this.field_147861_i * 16.0D);
         var22 = var14;
         var24 = var16;
         var18 = var10;
         var20 = var12;
         var14 = var16;
         var16 = var22;
      } else if(this.field_147875_q == 1) {
         var10 = (double)p_147761_8_.func_94214_a(16.0D - this.field_147857_k * 16.0D);
         var12 = (double)p_147761_8_.func_94214_a(16.0D - this.field_147855_j * 16.0D);
         var14 = (double)p_147761_8_.func_94207_b(this.field_147861_i * 16.0D);
         var16 = (double)p_147761_8_.func_94207_b(this.field_147859_h * 16.0D);
         var18 = var12;
         var20 = var10;
         var10 = var12;
         var12 = var20;
         var22 = var16;
         var24 = var14;
      } else if(this.field_147875_q == 3) {
         var10 = (double)p_147761_8_.func_94214_a(16.0D - this.field_147859_h * 16.0D);
         var12 = (double)p_147761_8_.func_94214_a(16.0D - this.field_147861_i * 16.0D);
         var14 = (double)p_147761_8_.func_94207_b(this.field_147857_k * 16.0D);
         var16 = (double)p_147761_8_.func_94207_b(this.field_147855_j * 16.0D);
         var18 = var12;
         var20 = var10;
         var22 = var14;
         var24 = var16;
      }

      double var26 = p_147761_2_ + this.field_147859_h;
      double var28 = p_147761_2_ + this.field_147861_i;
      double var30 = p_147761_4_ + this.field_147855_j;
      double var32 = p_147761_4_ + this.field_147857_k;
      double var34 = p_147761_6_ + this.field_147851_l;
      if(this.field_147838_g) {
         var26 = p_147761_2_ + this.field_147861_i;
         var28 = p_147761_2_ + this.field_147859_h;
      }

      if(this.field_147863_w) {
         var9.func_78386_a(this.field_147872_ap, this.field_147846_at, this.field_147854_ax);
         var9.func_78380_c(this.field_147864_al);
         var9.func_78374_a(var26, var32, var34, var18, var22);
         var9.func_78386_a(this.field_147852_aq, this.field_147860_au, this.field_147841_ay);
         var9.func_78380_c(this.field_147874_am);
         var9.func_78374_a(var28, var32, var34, var10, var14);
         var9.func_78386_a(this.field_147850_ar, this.field_147858_av, this.field_147839_az);
         var9.func_78380_c(this.field_147876_an);
         var9.func_78374_a(var28, var30, var34, var20, var24);
         var9.func_78386_a(this.field_147848_as, this.field_147856_aw, this.field_147833_aA);
         var9.func_78380_c(this.field_147870_ao);
         var9.func_78374_a(var26, var30, var34, var12, var16);
      } else {
         var9.func_78374_a(var26, var32, var34, var18, var22);
         var9.func_78374_a(var28, var32, var34, var10, var14);
         var9.func_78374_a(var28, var30, var34, var20, var24);
         var9.func_78374_a(var26, var30, var34, var12, var16);
      }

   }

   public void func_147734_d(Block p_147734_1_, double p_147734_2_, double p_147734_4_, double p_147734_6_, IIcon p_147734_8_) {
      Tessellator var9 = Tessellator.field_78398_a;
      if(this.func_147744_b()) {
         p_147734_8_ = this.field_147840_d;
      }

      double var10 = (double)p_147734_8_.func_94214_a(this.field_147859_h * 16.0D);
      double var12 = (double)p_147734_8_.func_94214_a(this.field_147861_i * 16.0D);
      double var14 = (double)p_147734_8_.func_94207_b(16.0D - this.field_147857_k * 16.0D);
      double var16 = (double)p_147734_8_.func_94207_b(16.0D - this.field_147855_j * 16.0D);
      double var18;
      if(this.field_147842_e) {
         var18 = var10;
         var10 = var12;
         var12 = var18;
      }

      if(this.field_147859_h < 0.0D || this.field_147861_i > 1.0D) {
         var10 = (double)p_147734_8_.func_94209_e();
         var12 = (double)p_147734_8_.func_94212_f();
      }

      if(this.field_147855_j < 0.0D || this.field_147857_k > 1.0D) {
         var14 = (double)p_147734_8_.func_94206_g();
         var16 = (double)p_147734_8_.func_94210_h();
      }

      var18 = var12;
      double var20 = var10;
      double var22 = var14;
      double var24 = var16;
      if(this.field_147873_r == 1) {
         var10 = (double)p_147734_8_.func_94214_a(this.field_147855_j * 16.0D);
         var16 = (double)p_147734_8_.func_94207_b(16.0D - this.field_147859_h * 16.0D);
         var12 = (double)p_147734_8_.func_94214_a(this.field_147857_k * 16.0D);
         var14 = (double)p_147734_8_.func_94207_b(16.0D - this.field_147861_i * 16.0D);
         var22 = var14;
         var24 = var16;
         var18 = var10;
         var20 = var12;
         var14 = var16;
         var16 = var22;
      } else if(this.field_147873_r == 2) {
         var10 = (double)p_147734_8_.func_94214_a(16.0D - this.field_147857_k * 16.0D);
         var14 = (double)p_147734_8_.func_94207_b(this.field_147859_h * 16.0D);
         var12 = (double)p_147734_8_.func_94214_a(16.0D - this.field_147855_j * 16.0D);
         var16 = (double)p_147734_8_.func_94207_b(this.field_147861_i * 16.0D);
         var18 = var12;
         var20 = var10;
         var10 = var12;
         var12 = var20;
         var22 = var16;
         var24 = var14;
      } else if(this.field_147873_r == 3) {
         var10 = (double)p_147734_8_.func_94214_a(16.0D - this.field_147859_h * 16.0D);
         var12 = (double)p_147734_8_.func_94214_a(16.0D - this.field_147861_i * 16.0D);
         var14 = (double)p_147734_8_.func_94207_b(this.field_147857_k * 16.0D);
         var16 = (double)p_147734_8_.func_94207_b(this.field_147855_j * 16.0D);
         var18 = var12;
         var20 = var10;
         var22 = var14;
         var24 = var16;
      }

      double var26 = p_147734_2_ + this.field_147859_h;
      double var28 = p_147734_2_ + this.field_147861_i;
      double var30 = p_147734_4_ + this.field_147855_j;
      double var32 = p_147734_4_ + this.field_147857_k;
      double var34 = p_147734_6_ + this.field_147853_m;
      if(this.field_147838_g) {
         var26 = p_147734_2_ + this.field_147861_i;
         var28 = p_147734_2_ + this.field_147859_h;
      }

      if(this.field_147863_w) {
         var9.func_78386_a(this.field_147872_ap, this.field_147846_at, this.field_147854_ax);
         var9.func_78380_c(this.field_147864_al);
         var9.func_78374_a(var26, var32, var34, var10, var14);
         var9.func_78386_a(this.field_147852_aq, this.field_147860_au, this.field_147841_ay);
         var9.func_78380_c(this.field_147874_am);
         var9.func_78374_a(var26, var30, var34, var20, var24);
         var9.func_78386_a(this.field_147850_ar, this.field_147858_av, this.field_147839_az);
         var9.func_78380_c(this.field_147876_an);
         var9.func_78374_a(var28, var30, var34, var12, var16);
         var9.func_78386_a(this.field_147848_as, this.field_147856_aw, this.field_147833_aA);
         var9.func_78380_c(this.field_147870_ao);
         var9.func_78374_a(var28, var32, var34, var18, var22);
      } else {
         var9.func_78374_a(var26, var32, var34, var10, var14);
         var9.func_78374_a(var26, var30, var34, var20, var24);
         var9.func_78374_a(var28, var30, var34, var12, var16);
         var9.func_78374_a(var28, var32, var34, var18, var22);
      }

   }

   public void func_147798_e(Block p_147798_1_, double p_147798_2_, double p_147798_4_, double p_147798_6_, IIcon p_147798_8_) {
      Tessellator var9 = Tessellator.field_78398_a;
      if(this.func_147744_b()) {
         p_147798_8_ = this.field_147840_d;
      }

      double var10 = (double)p_147798_8_.func_94214_a(this.field_147851_l * 16.0D);
      double var12 = (double)p_147798_8_.func_94214_a(this.field_147853_m * 16.0D);
      double var14 = (double)p_147798_8_.func_94207_b(16.0D - this.field_147857_k * 16.0D);
      double var16 = (double)p_147798_8_.func_94207_b(16.0D - this.field_147855_j * 16.0D);
      double var18;
      if(this.field_147842_e) {
         var18 = var10;
         var10 = var12;
         var12 = var18;
      }

      if(this.field_147851_l < 0.0D || this.field_147853_m > 1.0D) {
         var10 = (double)p_147798_8_.func_94209_e();
         var12 = (double)p_147798_8_.func_94212_f();
      }

      if(this.field_147855_j < 0.0D || this.field_147857_k > 1.0D) {
         var14 = (double)p_147798_8_.func_94206_g();
         var16 = (double)p_147798_8_.func_94210_h();
      }

      var18 = var12;
      double var20 = var10;
      double var22 = var14;
      double var24 = var16;
      if(this.field_147869_t == 1) {
         var10 = (double)p_147798_8_.func_94214_a(this.field_147855_j * 16.0D);
         var14 = (double)p_147798_8_.func_94207_b(16.0D - this.field_147853_m * 16.0D);
         var12 = (double)p_147798_8_.func_94214_a(this.field_147857_k * 16.0D);
         var16 = (double)p_147798_8_.func_94207_b(16.0D - this.field_147851_l * 16.0D);
         var22 = var14;
         var24 = var16;
         var18 = var10;
         var20 = var12;
         var14 = var16;
         var16 = var22;
      } else if(this.field_147869_t == 2) {
         var10 = (double)p_147798_8_.func_94214_a(16.0D - this.field_147857_k * 16.0D);
         var14 = (double)p_147798_8_.func_94207_b(this.field_147851_l * 16.0D);
         var12 = (double)p_147798_8_.func_94214_a(16.0D - this.field_147855_j * 16.0D);
         var16 = (double)p_147798_8_.func_94207_b(this.field_147853_m * 16.0D);
         var18 = var12;
         var20 = var10;
         var10 = var12;
         var12 = var20;
         var22 = var16;
         var24 = var14;
      } else if(this.field_147869_t == 3) {
         var10 = (double)p_147798_8_.func_94214_a(16.0D - this.field_147851_l * 16.0D);
         var12 = (double)p_147798_8_.func_94214_a(16.0D - this.field_147853_m * 16.0D);
         var14 = (double)p_147798_8_.func_94207_b(this.field_147857_k * 16.0D);
         var16 = (double)p_147798_8_.func_94207_b(this.field_147855_j * 16.0D);
         var18 = var12;
         var20 = var10;
         var22 = var14;
         var24 = var16;
      }

      double var26 = p_147798_2_ + this.field_147859_h;
      double var28 = p_147798_4_ + this.field_147855_j;
      double var30 = p_147798_4_ + this.field_147857_k;
      double var32 = p_147798_6_ + this.field_147851_l;
      double var34 = p_147798_6_ + this.field_147853_m;
      if(this.field_147838_g) {
         var32 = p_147798_6_ + this.field_147853_m;
         var34 = p_147798_6_ + this.field_147851_l;
      }

      if(this.field_147863_w) {
         var9.func_78386_a(this.field_147872_ap, this.field_147846_at, this.field_147854_ax);
         var9.func_78380_c(this.field_147864_al);
         var9.func_78374_a(var26, var30, var34, var18, var22);
         var9.func_78386_a(this.field_147852_aq, this.field_147860_au, this.field_147841_ay);
         var9.func_78380_c(this.field_147874_am);
         var9.func_78374_a(var26, var30, var32, var10, var14);
         var9.func_78386_a(this.field_147850_ar, this.field_147858_av, this.field_147839_az);
         var9.func_78380_c(this.field_147876_an);
         var9.func_78374_a(var26, var28, var32, var20, var24);
         var9.func_78386_a(this.field_147848_as, this.field_147856_aw, this.field_147833_aA);
         var9.func_78380_c(this.field_147870_ao);
         var9.func_78374_a(var26, var28, var34, var12, var16);
      } else {
         var9.func_78374_a(var26, var30, var34, var18, var22);
         var9.func_78374_a(var26, var30, var32, var10, var14);
         var9.func_78374_a(var26, var28, var32, var20, var24);
         var9.func_78374_a(var26, var28, var34, var12, var16);
      }

   }

   public void func_147764_f(Block p_147764_1_, double p_147764_2_, double p_147764_4_, double p_147764_6_, IIcon p_147764_8_) {
      Tessellator var9 = Tessellator.field_78398_a;
      if(this.func_147744_b()) {
         p_147764_8_ = this.field_147840_d;
      }

      double var10 = (double)p_147764_8_.func_94214_a(this.field_147851_l * 16.0D);
      double var12 = (double)p_147764_8_.func_94214_a(this.field_147853_m * 16.0D);
      if(this.field_152631_f) {
         var12 = (double)p_147764_8_.func_94214_a((1.0D - this.field_147851_l) * 16.0D);
         var10 = (double)p_147764_8_.func_94214_a((1.0D - this.field_147853_m) * 16.0D);
      }

      double var14 = (double)p_147764_8_.func_94207_b(16.0D - this.field_147857_k * 16.0D);
      double var16 = (double)p_147764_8_.func_94207_b(16.0D - this.field_147855_j * 16.0D);
      double var18;
      if(this.field_147842_e) {
         var18 = var10;
         var10 = var12;
         var12 = var18;
      }

      if(this.field_147851_l < 0.0D || this.field_147853_m > 1.0D) {
         var10 = (double)p_147764_8_.func_94209_e();
         var12 = (double)p_147764_8_.func_94212_f();
      }

      if(this.field_147855_j < 0.0D || this.field_147857_k > 1.0D) {
         var14 = (double)p_147764_8_.func_94206_g();
         var16 = (double)p_147764_8_.func_94210_h();
      }

      var18 = var12;
      double var20 = var10;
      double var22 = var14;
      double var24 = var16;
      if(this.field_147871_s == 2) {
         var10 = (double)p_147764_8_.func_94214_a(this.field_147855_j * 16.0D);
         var14 = (double)p_147764_8_.func_94207_b(16.0D - this.field_147851_l * 16.0D);
         var12 = (double)p_147764_8_.func_94214_a(this.field_147857_k * 16.0D);
         var16 = (double)p_147764_8_.func_94207_b(16.0D - this.field_147853_m * 16.0D);
         var22 = var14;
         var24 = var16;
         var18 = var10;
         var20 = var12;
         var14 = var16;
         var16 = var22;
      } else if(this.field_147871_s == 1) {
         var10 = (double)p_147764_8_.func_94214_a(16.0D - this.field_147857_k * 16.0D);
         var14 = (double)p_147764_8_.func_94207_b(this.field_147853_m * 16.0D);
         var12 = (double)p_147764_8_.func_94214_a(16.0D - this.field_147855_j * 16.0D);
         var16 = (double)p_147764_8_.func_94207_b(this.field_147851_l * 16.0D);
         var18 = var12;
         var20 = var10;
         var10 = var12;
         var12 = var20;
         var22 = var16;
         var24 = var14;
      } else if(this.field_147871_s == 3) {
         var10 = (double)p_147764_8_.func_94214_a(16.0D - this.field_147851_l * 16.0D);
         var12 = (double)p_147764_8_.func_94214_a(16.0D - this.field_147853_m * 16.0D);
         var14 = (double)p_147764_8_.func_94207_b(this.field_147857_k * 16.0D);
         var16 = (double)p_147764_8_.func_94207_b(this.field_147855_j * 16.0D);
         var18 = var12;
         var20 = var10;
         var22 = var14;
         var24 = var16;
      }

      double var26 = p_147764_2_ + this.field_147861_i;
      double var28 = p_147764_4_ + this.field_147855_j;
      double var30 = p_147764_4_ + this.field_147857_k;
      double var32 = p_147764_6_ + this.field_147851_l;
      double var34 = p_147764_6_ + this.field_147853_m;
      if(this.field_147838_g) {
         var32 = p_147764_6_ + this.field_147853_m;
         var34 = p_147764_6_ + this.field_147851_l;
      }

      if(this.field_147863_w) {
         var9.func_78386_a(this.field_147872_ap, this.field_147846_at, this.field_147854_ax);
         var9.func_78380_c(this.field_147864_al);
         var9.func_78374_a(var26, var28, var34, var20, var24);
         var9.func_78386_a(this.field_147852_aq, this.field_147860_au, this.field_147841_ay);
         var9.func_78380_c(this.field_147874_am);
         var9.func_78374_a(var26, var28, var32, var12, var16);
         var9.func_78386_a(this.field_147850_ar, this.field_147858_av, this.field_147839_az);
         var9.func_78380_c(this.field_147876_an);
         var9.func_78374_a(var26, var30, var32, var18, var22);
         var9.func_78386_a(this.field_147848_as, this.field_147856_aw, this.field_147833_aA);
         var9.func_78380_c(this.field_147870_ao);
         var9.func_78374_a(var26, var30, var34, var10, var14);
      } else {
         var9.func_78374_a(var26, var28, var34, var20, var24);
         var9.func_78374_a(var26, var28, var32, var12, var16);
         var9.func_78374_a(var26, var30, var32, var18, var22);
         var9.func_78374_a(var26, var30, var34, var10, var14);
      }

   }

   public void func_147800_a(Block p_147800_1_, int p_147800_2_, float p_147800_3_) {
      Tessellator var4 = Tessellator.field_78398_a;
      boolean var5 = p_147800_1_ == Blocks.field_150349_c;
      if(p_147800_1_ == Blocks.field_150367_z || p_147800_1_ == Blocks.field_150409_cd || p_147800_1_ == Blocks.field_150460_al) {
         p_147800_2_ = 3;
      }

      int var6;
      float var7;
      float var8;
      float var9;
      if(this.field_147844_c) {
         var6 = p_147800_1_.func_149741_i(p_147800_2_);
         if(var5) {
            var6 = 16777215;
         }

         var7 = (float)(var6 >> 16 & 255) / 255.0F;
         var8 = (float)(var6 >> 8 & 255) / 255.0F;
         var9 = (float)(var6 & 255) / 255.0F;
         GL11.glColor4f(var7 * p_147800_3_, var8 * p_147800_3_, var9 * p_147800_3_, 1.0F);
      }

      var6 = p_147800_1_.func_149645_b();
      this.func_147775_a(p_147800_1_);
      int var14;
      if(var6 != 0 && var6 != 31 && var6 != 39 && var6 != 16 && var6 != 26) {
         if(var6 == 1) {
            var4.func_78382_b();
            var4.func_78375_b(0.0F, -1.0F, 0.0F);
            IIcon var15 = this.func_147787_a(p_147800_1_, 0, p_147800_2_);
            this.func_147765_a(var15, -0.5D, -0.5D, -0.5D, 1.0F);
            var4.func_78381_a();
         } else if(var6 == 19) {
            var4.func_78382_b();
            var4.func_78375_b(0.0F, -1.0F, 0.0F);
            p_147800_1_.func_149683_g();
            this.func_147730_a(p_147800_1_, p_147800_2_, this.field_147857_k, -0.5D, -0.5D, -0.5D);
            var4.func_78381_a();
         } else if(var6 == 23) {
            var4.func_78382_b();
            var4.func_78375_b(0.0F, -1.0F, 0.0F);
            p_147800_1_.func_149683_g();
            var4.func_78381_a();
         } else if(var6 == 13) {
            p_147800_1_.func_149683_g();
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            var7 = 0.0625F;
            var4.func_78382_b();
            var4.func_78375_b(0.0F, -1.0F, 0.0F);
            this.func_147768_a(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 0));
            var4.func_78381_a();
            var4.func_78382_b();
            var4.func_78375_b(0.0F, 1.0F, 0.0F);
            this.func_147806_b(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 1));
            var4.func_78381_a();
            var4.func_78382_b();
            var4.func_78375_b(0.0F, 0.0F, -1.0F);
            var4.func_78372_c(0.0F, 0.0F, var7);
            this.func_147761_c(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 2));
            var4.func_78372_c(0.0F, 0.0F, -var7);
            var4.func_78381_a();
            var4.func_78382_b();
            var4.func_78375_b(0.0F, 0.0F, 1.0F);
            var4.func_78372_c(0.0F, 0.0F, -var7);
            this.func_147734_d(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 3));
            var4.func_78372_c(0.0F, 0.0F, var7);
            var4.func_78381_a();
            var4.func_78382_b();
            var4.func_78375_b(-1.0F, 0.0F, 0.0F);
            var4.func_78372_c(var7, 0.0F, 0.0F);
            this.func_147798_e(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 4));
            var4.func_78372_c(-var7, 0.0F, 0.0F);
            var4.func_78381_a();
            var4.func_78382_b();
            var4.func_78375_b(1.0F, 0.0F, 0.0F);
            var4.func_78372_c(-var7, 0.0F, 0.0F);
            this.func_147764_f(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 5));
            var4.func_78372_c(var7, 0.0F, 0.0F);
            var4.func_78381_a();
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
         } else if(var6 == 22) {
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            TileEntityRendererChestHelper.field_147719_a.func_147715_a(p_147800_1_, p_147800_2_, p_147800_3_);
            GL11.glEnable('\u803a');
         } else if(var6 == 6) {
            var4.func_78382_b();
            var4.func_78375_b(0.0F, -1.0F, 0.0F);
            this.func_147795_a(p_147800_1_, p_147800_2_, -0.5D, -0.5D, -0.5D);
            var4.func_78381_a();
         } else if(var6 == 2) {
            var4.func_78382_b();
            var4.func_78375_b(0.0F, -1.0F, 0.0F);
            this.func_147747_a(p_147800_1_, -0.5D, -0.5D, -0.5D, 0.0D, 0.0D, 0);
            var4.func_78381_a();
         } else if(var6 == 10) {
            for(var14 = 0; var14 < 2; ++var14) {
               if(var14 == 0) {
                  this.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.5D);
               }

               if(var14 == 1) {
                  this.func_147782_a(0.0D, 0.0D, 0.5D, 1.0D, 0.5D, 1.0D);
               }

               GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
               var4.func_78382_b();
               var4.func_78375_b(0.0F, -1.0F, 0.0F);
               this.func_147768_a(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 0));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 1.0F, 0.0F);
               this.func_147806_b(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 1));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 0.0F, -1.0F);
               this.func_147761_c(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 2));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 0.0F, 1.0F);
               this.func_147734_d(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 3));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(-1.0F, 0.0F, 0.0F);
               this.func_147798_e(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 4));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(1.0F, 0.0F, 0.0F);
               this.func_147764_f(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 5));
               var4.func_78381_a();
               GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }
         } else if(var6 == 27) {
            var14 = 0;
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            var4.func_78382_b();

            for(int var16 = 0; var16 < 8; ++var16) {
               byte var17 = 0;
               byte var18 = 1;
               if(var16 == 0) {
                  var17 = 2;
               }

               if(var16 == 1) {
                  var17 = 3;
               }

               if(var16 == 2) {
                  var17 = 4;
               }

               if(var16 == 3) {
                  var17 = 5;
                  var18 = 2;
               }

               if(var16 == 4) {
                  var17 = 6;
                  var18 = 3;
               }

               if(var16 == 5) {
                  var17 = 7;
                  var18 = 5;
               }

               if(var16 == 6) {
                  var17 = 6;
                  var18 = 2;
               }

               if(var16 == 7) {
                  var17 = 3;
               }

               float var11 = (float)var17 / 16.0F;
               float var12 = 1.0F - (float)var14 / 16.0F;
               float var13 = 1.0F - (float)(var14 + var18) / 16.0F;
               var14 += var18;
               this.func_147782_a((double)(0.5F - var11), (double)var13, (double)(0.5F - var11), (double)(0.5F + var11), (double)var12, (double)(0.5F + var11));
               var4.func_78375_b(0.0F, -1.0F, 0.0F);
               this.func_147768_a(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 0));
               var4.func_78375_b(0.0F, 1.0F, 0.0F);
               this.func_147806_b(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 1));
               var4.func_78375_b(0.0F, 0.0F, -1.0F);
               this.func_147761_c(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 2));
               var4.func_78375_b(0.0F, 0.0F, 1.0F);
               this.func_147734_d(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 3));
               var4.func_78375_b(-1.0F, 0.0F, 0.0F);
               this.func_147798_e(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 4));
               var4.func_78375_b(1.0F, 0.0F, 0.0F);
               this.func_147764_f(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 5));
            }

            var4.func_78381_a();
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            this.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
         } else if(var6 == 11) {
            for(var14 = 0; var14 < 4; ++var14) {
               var8 = 0.125F;
               if(var14 == 0) {
                  this.func_147782_a((double)(0.5F - var8), 0.0D, 0.0D, (double)(0.5F + var8), 1.0D, (double)(var8 * 2.0F));
               }

               if(var14 == 1) {
                  this.func_147782_a((double)(0.5F - var8), 0.0D, (double)(1.0F - var8 * 2.0F), (double)(0.5F + var8), 1.0D, 1.0D);
               }

               var8 = 0.0625F;
               if(var14 == 2) {
                  this.func_147782_a((double)(0.5F - var8), (double)(1.0F - var8 * 3.0F), (double)(-var8 * 2.0F), (double)(0.5F + var8), (double)(1.0F - var8), (double)(1.0F + var8 * 2.0F));
               }

               if(var14 == 3) {
                  this.func_147782_a((double)(0.5F - var8), (double)(0.5F - var8 * 3.0F), (double)(-var8 * 2.0F), (double)(0.5F + var8), (double)(0.5F - var8), (double)(1.0F + var8 * 2.0F));
               }

               GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
               var4.func_78382_b();
               var4.func_78375_b(0.0F, -1.0F, 0.0F);
               this.func_147768_a(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 0));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 1.0F, 0.0F);
               this.func_147806_b(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 1));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 0.0F, -1.0F);
               this.func_147761_c(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 2));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 0.0F, 1.0F);
               this.func_147734_d(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 3));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(-1.0F, 0.0F, 0.0F);
               this.func_147798_e(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 4));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(1.0F, 0.0F, 0.0F);
               this.func_147764_f(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 5));
               var4.func_78381_a();
               GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }

            this.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
         } else if(var6 == 21) {
            for(var14 = 0; var14 < 3; ++var14) {
               var8 = 0.0625F;
               if(var14 == 0) {
                  this.func_147782_a((double)(0.5F - var8), 0.30000001192092896D, 0.0D, (double)(0.5F + var8), 1.0D, (double)(var8 * 2.0F));
               }

               if(var14 == 1) {
                  this.func_147782_a((double)(0.5F - var8), 0.30000001192092896D, (double)(1.0F - var8 * 2.0F), (double)(0.5F + var8), 1.0D, 1.0D);
               }

               var8 = 0.0625F;
               if(var14 == 2) {
                  this.func_147782_a((double)(0.5F - var8), 0.5D, 0.0D, (double)(0.5F + var8), (double)(1.0F - var8), 1.0D);
               }

               GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
               var4.func_78382_b();
               var4.func_78375_b(0.0F, -1.0F, 0.0F);
               this.func_147768_a(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 0));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 1.0F, 0.0F);
               this.func_147806_b(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 1));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 0.0F, -1.0F);
               this.func_147761_c(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 2));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 0.0F, 1.0F);
               this.func_147734_d(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 3));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(-1.0F, 0.0F, 0.0F);
               this.func_147798_e(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 4));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(1.0F, 0.0F, 0.0F);
               this.func_147764_f(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147777_a(p_147800_1_, 5));
               var4.func_78381_a();
               GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }
         } else if(var6 == 32) {
            for(var14 = 0; var14 < 2; ++var14) {
               if(var14 == 0) {
                  this.func_147782_a(0.0D, 0.0D, 0.3125D, 1.0D, 0.8125D, 0.6875D);
               }

               if(var14 == 1) {
                  this.func_147782_a(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D);
               }

               GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
               var4.func_78382_b();
               var4.func_78375_b(0.0F, -1.0F, 0.0F);
               this.func_147768_a(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147800_1_, 0, p_147800_2_));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 1.0F, 0.0F);
               this.func_147806_b(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147800_1_, 1, p_147800_2_));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 0.0F, -1.0F);
               this.func_147761_c(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147800_1_, 2, p_147800_2_));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 0.0F, 1.0F);
               this.func_147734_d(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147800_1_, 3, p_147800_2_));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(-1.0F, 0.0F, 0.0F);
               this.func_147798_e(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147800_1_, 4, p_147800_2_));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(1.0F, 0.0F, 0.0F);
               this.func_147764_f(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147800_1_, 5, p_147800_2_));
               var4.func_78381_a();
               GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }

            this.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
         } else if(var6 == 35) {
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            this.func_147728_a((BlockAnvil)p_147800_1_, 0, 0, 0, p_147800_2_ << 2, true);
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
         } else if(var6 == 34) {
            for(var14 = 0; var14 < 3; ++var14) {
               if(var14 == 0) {
                  this.func_147782_a(0.125D, 0.0D, 0.125D, 0.875D, 0.1875D, 0.875D);
                  this.func_147757_a(this.func_147745_b(Blocks.field_150343_Z));
               } else if(var14 == 1) {
                  this.func_147782_a(0.1875D, 0.1875D, 0.1875D, 0.8125D, 0.875D, 0.8125D);
                  this.func_147757_a(this.func_147745_b(Blocks.field_150461_bJ));
               } else if(var14 == 2) {
                  this.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
                  this.func_147757_a(this.func_147745_b(Blocks.field_150359_w));
               }

               GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
               var4.func_78382_b();
               var4.func_78375_b(0.0F, -1.0F, 0.0F);
               this.func_147768_a(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147800_1_, 0, p_147800_2_));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 1.0F, 0.0F);
               this.func_147806_b(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147800_1_, 1, p_147800_2_));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 0.0F, -1.0F);
               this.func_147761_c(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147800_1_, 2, p_147800_2_));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(0.0F, 0.0F, 1.0F);
               this.func_147734_d(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147800_1_, 3, p_147800_2_));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(-1.0F, 0.0F, 0.0F);
               this.func_147798_e(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147800_1_, 4, p_147800_2_));
               var4.func_78381_a();
               var4.func_78382_b();
               var4.func_78375_b(1.0F, 0.0F, 0.0F);
               this.func_147764_f(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147800_1_, 5, p_147800_2_));
               var4.func_78381_a();
               GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }

            this.func_147782_a(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
            this.func_147771_a();
         } else if(var6 == 38) {
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            this.func_147799_a((BlockHopper)p_147800_1_, 0, 0, 0, 0, true);
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
         }
      } else {
         if(var6 == 16) {
            p_147800_2_ = 1;
         }

         p_147800_1_.func_149683_g();
         this.func_147775_a(p_147800_1_);
         GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
         GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
         var4.func_78382_b();
         var4.func_78375_b(0.0F, -1.0F, 0.0F);
         this.func_147768_a(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147800_1_, 0, p_147800_2_));
         var4.func_78381_a();
         if(var5 && this.field_147844_c) {
            var14 = p_147800_1_.func_149741_i(p_147800_2_);
            var8 = (float)(var14 >> 16 & 255) / 255.0F;
            var9 = (float)(var14 >> 8 & 255) / 255.0F;
            float var10 = (float)(var14 & 255) / 255.0F;
            GL11.glColor4f(var8 * p_147800_3_, var9 * p_147800_3_, var10 * p_147800_3_, 1.0F);
         }

         var4.func_78382_b();
         var4.func_78375_b(0.0F, 1.0F, 0.0F);
         this.func_147806_b(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147800_1_, 1, p_147800_2_));
         var4.func_78381_a();
         if(var5 && this.field_147844_c) {
            GL11.glColor4f(p_147800_3_, p_147800_3_, p_147800_3_, 1.0F);
         }

         var4.func_78382_b();
         var4.func_78375_b(0.0F, 0.0F, -1.0F);
         this.func_147761_c(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147800_1_, 2, p_147800_2_));
         var4.func_78381_a();
         var4.func_78382_b();
         var4.func_78375_b(0.0F, 0.0F, 1.0F);
         this.func_147734_d(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147800_1_, 3, p_147800_2_));
         var4.func_78381_a();
         var4.func_78382_b();
         var4.func_78375_b(-1.0F, 0.0F, 0.0F);
         this.func_147798_e(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147800_1_, 4, p_147800_2_));
         var4.func_78381_a();
         var4.func_78382_b();
         var4.func_78375_b(1.0F, 0.0F, 0.0F);
         this.func_147764_f(p_147800_1_, 0.0D, 0.0D, 0.0D, this.func_147787_a(p_147800_1_, 5, p_147800_2_));
         var4.func_78381_a();
         GL11.glTranslatef(0.5F, 0.5F, 0.5F);
      }

   }

   public static boolean func_147739_a(int p_147739_0_) {
      return p_147739_0_ == 0?true:(p_147739_0_ == 31?true:(p_147739_0_ == 39?true:(p_147739_0_ == 13?true:(p_147739_0_ == 10?true:(p_147739_0_ == 11?true:(p_147739_0_ == 27?true:(p_147739_0_ == 22?true:(p_147739_0_ == 21?true:(p_147739_0_ == 16?true:(p_147739_0_ == 26?true:(p_147739_0_ == 32?true:(p_147739_0_ == 34?true:(p_147739_0_ == 35?true:(p_147739_0_ == -1?false:false))))))))))))));
   }

   public IIcon func_147793_a(Block p_147793_1_, IBlockAccess p_147793_2_, int p_147793_3_, int p_147793_4_, int p_147793_5_, int p_147793_6_) {
      return this.func_147758_b(p_147793_1_.func_149673_e(p_147793_2_, p_147793_3_, p_147793_4_, p_147793_5_, p_147793_6_));
   }

   public IIcon func_147787_a(Block p_147787_1_, int p_147787_2_, int p_147787_3_) {
      return this.func_147758_b(p_147787_1_.func_149691_a(p_147787_2_, p_147787_3_));
   }

   public IIcon func_147777_a(Block p_147777_1_, int p_147777_2_) {
      return this.func_147758_b(p_147777_1_.func_149733_h(p_147777_2_));
   }

   public IIcon func_147745_b(Block p_147745_1_) {
      return this.func_147758_b(p_147745_1_.func_149733_h(1));
   }

   public IIcon func_147758_b(IIcon p_147758_1_) {
      if(p_147758_1_ == null) {
         p_147758_1_ = ((TextureMap)Minecraft.func_71410_x().func_110434_K().func_110581_b(TextureMap.field_110575_b)).func_110572_b("missingno");
      }

      return (IIcon)p_147758_1_;
   }

}
