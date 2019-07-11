package net.minecraft.world;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.command.IEntitySelector;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathFinder;
import net.minecraft.profiler.Profiler;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Direction;
import net.minecraft.util.Facing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ReportedException;
import net.minecraft.util.Vec3;
import net.minecraft.village.VillageCollection;
import net.minecraft.village.VillageSiege;
import net.minecraft.world.ChunkCache;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.Explosion;
import net.minecraft.world.GameRules;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.IWorldAccess;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldInfo;

public abstract class World implements IBlockAccess {

   public boolean field_72999_e;
   public List field_72996_f = new ArrayList();
   protected List field_72997_g = new ArrayList();
   public List field_147482_g = new ArrayList();
   private List field_147484_a = new ArrayList();
   private List field_147483_b = new ArrayList();
   public List field_73010_i = new ArrayList();
   public List field_73007_j = new ArrayList();
   private long field_73001_c = 16777215L;
   public int field_73008_k;
   protected int field_73005_l = (new Random()).nextInt();
   protected final int field_73006_m = 1013904223;
   protected float field_73003_n;
   protected float field_73004_o;
   protected float field_73018_p;
   protected float field_73017_q;
   public int field_73016_r;
   public EnumDifficulty field_73013_u;
   public Random field_73012_v = new Random();
   public final WorldProvider field_73011_w;
   protected List field_73021_x = new ArrayList();
   protected IChunkProvider field_73020_y;
   protected final ISaveHandler field_73019_z;
   protected WorldInfo field_72986_A;
   public boolean field_72987_B;
   public MapStorage field_72988_C;
   public final VillageCollection field_72982_D;
   protected final VillageSiege field_72983_E = new VillageSiege(this);
   public final Profiler field_72984_F;
   private final Calendar field_83016_L = Calendar.getInstance();
   protected Scoreboard field_96442_D = new Scoreboard();
   public boolean field_72995_K;
   protected Set field_72993_I = new HashSet();
   private int field_72990_M;
   protected boolean field_72985_G;
   protected boolean field_72992_H;
   private ArrayList field_72998_d;
   private boolean field_147481_N;
   int[] field_72994_J;
   private static final String __OBFID = "CL_00000140";


   public BiomeGenBase func_72807_a(final int p_72807_1_, final int p_72807_2_) {
      if(this.func_72899_e(p_72807_1_, 0, p_72807_2_)) {
         Chunk var3 = this.func_72938_d(p_72807_1_, p_72807_2_);

         try {
            return var3.func_76591_a(p_72807_1_ & 15, p_72807_2_ & 15, this.field_73011_w.field_76578_c);
         } catch (Throwable var7) {
            CrashReport var5 = CrashReport.func_85055_a(var7, "Getting biome");
            CrashReportCategory var6 = var5.func_85058_a("Coordinates of biome request");
            var6.func_71500_a("Location", new Callable() {

               private static final String __OBFID = "CL_00000141";

               public String call() {
                  return CrashReportCategory.func_85071_a(p_72807_1_, 0, p_72807_2_);
               }
               // $FF: synthetic method
               public Object call() {
                  return this.call();
               }
            });
            throw new ReportedException(var5);
         }
      } else {
         return this.field_73011_w.field_76578_c.func_76935_a(p_72807_1_, p_72807_2_);
      }
   }

   public WorldChunkManager func_72959_q() {
      return this.field_73011_w.field_76578_c;
   }

   public World(ISaveHandler p_i45368_1_, String p_i45368_2_, WorldProvider p_i45368_3_, WorldSettings p_i45368_4_, Profiler p_i45368_5_) {
      this.field_72990_M = this.field_73012_v.nextInt(12000);
      this.field_72985_G = true;
      this.field_72992_H = true;
      this.field_72998_d = new ArrayList();
      this.field_72994_J = new int['\u8000'];
      this.field_73019_z = p_i45368_1_;
      this.field_72984_F = p_i45368_5_;
      this.field_72986_A = new WorldInfo(p_i45368_4_, p_i45368_2_);
      this.field_73011_w = p_i45368_3_;
      this.field_72988_C = new MapStorage(p_i45368_1_);
      VillageCollection var6 = (VillageCollection)this.field_72988_C.func_75742_a(VillageCollection.class, "villages");
      if(var6 == null) {
         this.field_72982_D = new VillageCollection(this);
         this.field_72988_C.func_75745_a("villages", this.field_72982_D);
      } else {
         this.field_72982_D = var6;
         this.field_72982_D.func_82566_a(this);
      }

      p_i45368_3_.func_76558_a(this);
      this.field_73020_y = this.func_72970_h();
      this.func_72966_v();
      this.func_72947_a();
   }

   public World(ISaveHandler p_i45369_1_, String p_i45369_2_, WorldSettings p_i45369_3_, WorldProvider p_i45369_4_, Profiler p_i45369_5_) {
      this.field_72990_M = this.field_73012_v.nextInt(12000);
      this.field_72985_G = true;
      this.field_72992_H = true;
      this.field_72998_d = new ArrayList();
      this.field_72994_J = new int['\u8000'];
      this.field_73019_z = p_i45369_1_;
      this.field_72984_F = p_i45369_5_;
      this.field_72988_C = new MapStorage(p_i45369_1_);
      this.field_72986_A = p_i45369_1_.func_75757_d();
      if(p_i45369_4_ != null) {
         this.field_73011_w = p_i45369_4_;
      } else if(this.field_72986_A != null && this.field_72986_A.func_76076_i() != 0) {
         this.field_73011_w = WorldProvider.func_76570_a(this.field_72986_A.func_76076_i());
      } else {
         this.field_73011_w = WorldProvider.func_76570_a(0);
      }

      if(this.field_72986_A == null) {
         this.field_72986_A = new WorldInfo(p_i45369_3_, p_i45369_2_);
      } else {
         this.field_72986_A.func_76062_a(p_i45369_2_);
      }

      this.field_73011_w.func_76558_a(this);
      this.field_73020_y = this.func_72970_h();
      if(!this.field_72986_A.func_76070_v()) {
         try {
            this.func_72963_a(p_i45369_3_);
         } catch (Throwable var10) {
            CrashReport var7 = CrashReport.func_85055_a(var10, "Exception initializing level");

            try {
               this.func_72914_a(var7);
            } catch (Throwable var9) {
               ;
            }

            throw new ReportedException(var7);
         }

         this.field_72986_A.func_76091_d(true);
      }

      VillageCollection var6 = (VillageCollection)this.field_72988_C.func_75742_a(VillageCollection.class, "villages");
      if(var6 == null) {
         this.field_72982_D = new VillageCollection(this);
         this.field_72988_C.func_75745_a("villages", this.field_72982_D);
      } else {
         this.field_72982_D = var6;
         this.field_72982_D.func_82566_a(this);
      }

      this.func_72966_v();
      this.func_72947_a();
   }

   protected abstract IChunkProvider func_72970_h();

   protected void func_72963_a(WorldSettings p_72963_1_) {
      this.field_72986_A.func_76091_d(true);
   }

   public void func_72974_f() {
      this.func_72950_A(8, 64, 8);
   }

   public Block func_147474_b(int p_147474_1_, int p_147474_2_) {
      int var3;
      for(var3 = 63; !this.func_147437_c(p_147474_1_, var3 + 1, p_147474_2_); ++var3) {
         ;
      }

      return this.func_147439_a(p_147474_1_, var3, p_147474_2_);
   }

   public Block func_147439_a(int p_147439_1_, int p_147439_2_, int p_147439_3_) {
      if(p_147439_1_ >= -30000000 && p_147439_3_ >= -30000000 && p_147439_1_ < 30000000 && p_147439_3_ < 30000000 && p_147439_2_ >= 0 && p_147439_2_ < 256) {
         Chunk var4 = null;

         try {
            var4 = this.func_72964_e(p_147439_1_ >> 4, p_147439_3_ >> 4);
            return var4.func_150810_a(p_147439_1_ & 15, p_147439_2_, p_147439_3_ & 15);
         } catch (Throwable var8) {
            CrashReport var6 = CrashReport.func_85055_a(var8, "Exception getting block type in world");
            CrashReportCategory var7 = var6.func_85058_a("Requested block coordinates");
            var7.func_71507_a("Found chunk", Boolean.valueOf(var4 == null));
            var7.func_71507_a("Location", CrashReportCategory.func_85071_a(p_147439_1_, p_147439_2_, p_147439_3_));
            throw new ReportedException(var6);
         }
      } else {
         return Blocks.field_150350_a;
      }
   }

   public boolean func_147437_c(int p_147437_1_, int p_147437_2_, int p_147437_3_) {
      return this.func_147439_a(p_147437_1_, p_147437_2_, p_147437_3_).func_149688_o() == Material.field_151579_a;
   }

   public boolean func_72899_e(int p_72899_1_, int p_72899_2_, int p_72899_3_) {
      return p_72899_2_ >= 0 && p_72899_2_ < 256?this.func_72916_c(p_72899_1_ >> 4, p_72899_3_ >> 4):false;
   }

   public boolean func_72873_a(int p_72873_1_, int p_72873_2_, int p_72873_3_, int p_72873_4_) {
      return this.func_72904_c(p_72873_1_ - p_72873_4_, p_72873_2_ - p_72873_4_, p_72873_3_ - p_72873_4_, p_72873_1_ + p_72873_4_, p_72873_2_ + p_72873_4_, p_72873_3_ + p_72873_4_);
   }

   public boolean func_72904_c(int p_72904_1_, int p_72904_2_, int p_72904_3_, int p_72904_4_, int p_72904_5_, int p_72904_6_) {
      if(p_72904_5_ >= 0 && p_72904_2_ < 256) {
         p_72904_1_ >>= 4;
         p_72904_3_ >>= 4;
         p_72904_4_ >>= 4;
         p_72904_6_ >>= 4;

         for(int var7 = p_72904_1_; var7 <= p_72904_4_; ++var7) {
            for(int var8 = p_72904_3_; var8 <= p_72904_6_; ++var8) {
               if(!this.func_72916_c(var7, var8)) {
                  return false;
               }
            }
         }

         return true;
      } else {
         return false;
      }
   }

   protected boolean func_72916_c(int p_72916_1_, int p_72916_2_) {
      return this.field_73020_y.func_73149_a(p_72916_1_, p_72916_2_);
   }

   public Chunk func_72938_d(int p_72938_1_, int p_72938_2_) {
      return this.func_72964_e(p_72938_1_ >> 4, p_72938_2_ >> 4);
   }

   public Chunk func_72964_e(int p_72964_1_, int p_72964_2_) {
      return this.field_73020_y.func_73154_d(p_72964_1_, p_72964_2_);
   }

   public boolean func_147465_d(int p_147465_1_, int p_147465_2_, int p_147465_3_, Block p_147465_4_, int p_147465_5_, int p_147465_6_) {
      if(p_147465_1_ >= -30000000 && p_147465_3_ >= -30000000 && p_147465_1_ < 30000000 && p_147465_3_ < 30000000) {
         if(p_147465_2_ < 0) {
            return false;
         } else if(p_147465_2_ >= 256) {
            return false;
         } else {
            Chunk var7 = this.func_72964_e(p_147465_1_ >> 4, p_147465_3_ >> 4);
            Block var8 = null;
            if((p_147465_6_ & 1) != 0) {
               var8 = var7.func_150810_a(p_147465_1_ & 15, p_147465_2_, p_147465_3_ & 15);
            }

            boolean var9 = var7.func_150807_a(p_147465_1_ & 15, p_147465_2_, p_147465_3_ & 15, p_147465_4_, p_147465_5_);
            this.field_72984_F.func_76320_a("checkLight");
            this.func_147451_t(p_147465_1_, p_147465_2_, p_147465_3_);
            this.field_72984_F.func_76319_b();
            if(var9) {
               if((p_147465_6_ & 2) != 0 && (!this.field_72995_K || (p_147465_6_ & 4) == 0) && var7.func_150802_k()) {
                  this.func_147471_g(p_147465_1_, p_147465_2_, p_147465_3_);
               }

               if(!this.field_72995_K && (p_147465_6_ & 1) != 0) {
                  this.func_147444_c(p_147465_1_, p_147465_2_, p_147465_3_, var8);
                  if(p_147465_4_.func_149740_M()) {
                     this.func_147453_f(p_147465_1_, p_147465_2_, p_147465_3_, p_147465_4_);
                  }
               }
            }

            return var9;
         }
      } else {
         return false;
      }
   }

   public int func_72805_g(int p_72805_1_, int p_72805_2_, int p_72805_3_) {
      if(p_72805_1_ >= -30000000 && p_72805_3_ >= -30000000 && p_72805_1_ < 30000000 && p_72805_3_ < 30000000) {
         if(p_72805_2_ < 0) {
            return 0;
         } else if(p_72805_2_ >= 256) {
            return 0;
         } else {
            Chunk var4 = this.func_72964_e(p_72805_1_ >> 4, p_72805_3_ >> 4);
            p_72805_1_ &= 15;
            p_72805_3_ &= 15;
            return var4.func_76628_c(p_72805_1_, p_72805_2_, p_72805_3_);
         }
      } else {
         return 0;
      }
   }

   public boolean func_72921_c(int p_72921_1_, int p_72921_2_, int p_72921_3_, int p_72921_4_, int p_72921_5_) {
      if(p_72921_1_ >= -30000000 && p_72921_3_ >= -30000000 && p_72921_1_ < 30000000 && p_72921_3_ < 30000000) {
         if(p_72921_2_ < 0) {
            return false;
         } else if(p_72921_2_ >= 256) {
            return false;
         } else {
            Chunk var6 = this.func_72964_e(p_72921_1_ >> 4, p_72921_3_ >> 4);
            int var7 = p_72921_1_ & 15;
            int var8 = p_72921_3_ & 15;
            boolean var9 = var6.func_76589_b(var7, p_72921_2_, var8, p_72921_4_);
            if(var9) {
               Block var10 = var6.func_150810_a(var7, p_72921_2_, var8);
               if((p_72921_5_ & 2) != 0 && (!this.field_72995_K || (p_72921_5_ & 4) == 0) && var6.func_150802_k()) {
                  this.func_147471_g(p_72921_1_, p_72921_2_, p_72921_3_);
               }

               if(!this.field_72995_K && (p_72921_5_ & 1) != 0) {
                  this.func_147444_c(p_72921_1_, p_72921_2_, p_72921_3_, var10);
                  if(var10.func_149740_M()) {
                     this.func_147453_f(p_72921_1_, p_72921_2_, p_72921_3_, var10);
                  }
               }
            }

            return var9;
         }
      } else {
         return false;
      }
   }

   public boolean func_147468_f(int p_147468_1_, int p_147468_2_, int p_147468_3_) {
      return this.func_147465_d(p_147468_1_, p_147468_2_, p_147468_3_, Blocks.field_150350_a, 0, 3);
   }

   public boolean func_147480_a(int p_147480_1_, int p_147480_2_, int p_147480_3_, boolean p_147480_4_) {
      Block var5 = this.func_147439_a(p_147480_1_, p_147480_2_, p_147480_3_);
      if(var5.func_149688_o() == Material.field_151579_a) {
         return false;
      } else {
         int var6 = this.func_72805_g(p_147480_1_, p_147480_2_, p_147480_3_);
         this.func_72926_e(2001, p_147480_1_, p_147480_2_, p_147480_3_, Block.func_149682_b(var5) + (var6 << 12));
         if(p_147480_4_) {
            var5.func_149697_b(this, p_147480_1_, p_147480_2_, p_147480_3_, var6, 0);
         }

         return this.func_147465_d(p_147480_1_, p_147480_2_, p_147480_3_, Blocks.field_150350_a, 0, 3);
      }
   }

   public boolean func_147449_b(int p_147449_1_, int p_147449_2_, int p_147449_3_, Block p_147449_4_) {
      return this.func_147465_d(p_147449_1_, p_147449_2_, p_147449_3_, p_147449_4_, 0, 3);
   }

   public void func_147471_g(int p_147471_1_, int p_147471_2_, int p_147471_3_) {
      for(int var4 = 0; var4 < this.field_73021_x.size(); ++var4) {
         ((IWorldAccess)this.field_73021_x.get(var4)).func_147586_a(p_147471_1_, p_147471_2_, p_147471_3_);
      }

   }

   public void func_147444_c(int p_147444_1_, int p_147444_2_, int p_147444_3_, Block p_147444_4_) {
      this.func_147459_d(p_147444_1_, p_147444_2_, p_147444_3_, p_147444_4_);
   }

   public void func_72975_g(int p_72975_1_, int p_72975_2_, int p_72975_3_, int p_72975_4_) {
      int var5;
      if(p_72975_3_ > p_72975_4_) {
         var5 = p_72975_4_;
         p_72975_4_ = p_72975_3_;
         p_72975_3_ = var5;
      }

      if(!this.field_73011_w.field_76576_e) {
         for(var5 = p_72975_3_; var5 <= p_72975_4_; ++var5) {
            this.func_147463_c(EnumSkyBlock.Sky, p_72975_1_, var5, p_72975_2_);
         }
      }

      this.func_147458_c(p_72975_1_, p_72975_3_, p_72975_2_, p_72975_1_, p_72975_4_, p_72975_2_);
   }

   public void func_147458_c(int p_147458_1_, int p_147458_2_, int p_147458_3_, int p_147458_4_, int p_147458_5_, int p_147458_6_) {
      for(int var7 = 0; var7 < this.field_73021_x.size(); ++var7) {
         ((IWorldAccess)this.field_73021_x.get(var7)).func_147585_a(p_147458_1_, p_147458_2_, p_147458_3_, p_147458_4_, p_147458_5_, p_147458_6_);
      }

   }

   public void func_147459_d(int p_147459_1_, int p_147459_2_, int p_147459_3_, Block p_147459_4_) {
      this.func_147460_e(p_147459_1_ - 1, p_147459_2_, p_147459_3_, p_147459_4_);
      this.func_147460_e(p_147459_1_ + 1, p_147459_2_, p_147459_3_, p_147459_4_);
      this.func_147460_e(p_147459_1_, p_147459_2_ - 1, p_147459_3_, p_147459_4_);
      this.func_147460_e(p_147459_1_, p_147459_2_ + 1, p_147459_3_, p_147459_4_);
      this.func_147460_e(p_147459_1_, p_147459_2_, p_147459_3_ - 1, p_147459_4_);
      this.func_147460_e(p_147459_1_, p_147459_2_, p_147459_3_ + 1, p_147459_4_);
   }

   public void func_147441_b(int p_147441_1_, int p_147441_2_, int p_147441_3_, Block p_147441_4_, int p_147441_5_) {
      if(p_147441_5_ != 4) {
         this.func_147460_e(p_147441_1_ - 1, p_147441_2_, p_147441_3_, p_147441_4_);
      }

      if(p_147441_5_ != 5) {
         this.func_147460_e(p_147441_1_ + 1, p_147441_2_, p_147441_3_, p_147441_4_);
      }

      if(p_147441_5_ != 0) {
         this.func_147460_e(p_147441_1_, p_147441_2_ - 1, p_147441_3_, p_147441_4_);
      }

      if(p_147441_5_ != 1) {
         this.func_147460_e(p_147441_1_, p_147441_2_ + 1, p_147441_3_, p_147441_4_);
      }

      if(p_147441_5_ != 2) {
         this.func_147460_e(p_147441_1_, p_147441_2_, p_147441_3_ - 1, p_147441_4_);
      }

      if(p_147441_5_ != 3) {
         this.func_147460_e(p_147441_1_, p_147441_2_, p_147441_3_ + 1, p_147441_4_);
      }

   }

   public void func_147460_e(int p_147460_1_, int p_147460_2_, int p_147460_3_, final Block p_147460_4_) {
      if(!this.field_72995_K) {
         Block var5 = this.func_147439_a(p_147460_1_, p_147460_2_, p_147460_3_);

         try {
            var5.func_149695_a(this, p_147460_1_, p_147460_2_, p_147460_3_, p_147460_4_);
         } catch (Throwable var12) {
            CrashReport var7 = CrashReport.func_85055_a(var12, "Exception while updating neighbours");
            CrashReportCategory var8 = var7.func_85058_a("Block being updated");

            int var9;
            try {
               var9 = this.func_72805_g(p_147460_1_, p_147460_2_, p_147460_3_);
            } catch (Throwable var11) {
               var9 = -1;
            }

            var8.func_71500_a("Source block type", new Callable() {

               private static final String __OBFID = "CL_00000142";

               public String call() {
                  try {
                     return String.format("ID #%d (%s // %s)", new Object[]{Integer.valueOf(Block.func_149682_b(p_147460_4_)), p_147460_4_.func_149739_a(), p_147460_4_.getClass().getCanonicalName()});
                  } catch (Throwable var2) {
                     return "ID #" + Block.func_149682_b(p_147460_4_);
                  }
               }
               // $FF: synthetic method
               public Object call() {
                  return this.call();
               }
            });
            CrashReportCategory.func_147153_a(var8, p_147460_1_, p_147460_2_, p_147460_3_, var5, var9);
            throw new ReportedException(var7);
         }
      }
   }

   public boolean func_147477_a(int p_147477_1_, int p_147477_2_, int p_147477_3_, Block p_147477_4_) {
      return false;
   }

   public boolean func_72937_j(int p_72937_1_, int p_72937_2_, int p_72937_3_) {
      return this.func_72964_e(p_72937_1_ >> 4, p_72937_3_ >> 4).func_76619_d(p_72937_1_ & 15, p_72937_2_, p_72937_3_ & 15);
   }

   public int func_72883_k(int p_72883_1_, int p_72883_2_, int p_72883_3_) {
      if(p_72883_2_ < 0) {
         return 0;
      } else {
         if(p_72883_2_ >= 256) {
            p_72883_2_ = 255;
         }

         return this.func_72964_e(p_72883_1_ >> 4, p_72883_3_ >> 4).func_76629_c(p_72883_1_ & 15, p_72883_2_, p_72883_3_ & 15, 0);
      }
   }

   public int func_72957_l(int p_72957_1_, int p_72957_2_, int p_72957_3_) {
      return this.func_72849_a(p_72957_1_, p_72957_2_, p_72957_3_, true);
   }

   public int func_72849_a(int p_72849_1_, int p_72849_2_, int p_72849_3_, boolean p_72849_4_) {
      if(p_72849_1_ >= -30000000 && p_72849_3_ >= -30000000 && p_72849_1_ < 30000000 && p_72849_3_ < 30000000) {
         if(p_72849_4_ && this.func_147439_a(p_72849_1_, p_72849_2_, p_72849_3_).func_149710_n()) {
            int var10 = this.func_72849_a(p_72849_1_, p_72849_2_ + 1, p_72849_3_, false);
            int var6 = this.func_72849_a(p_72849_1_ + 1, p_72849_2_, p_72849_3_, false);
            int var7 = this.func_72849_a(p_72849_1_ - 1, p_72849_2_, p_72849_3_, false);
            int var8 = this.func_72849_a(p_72849_1_, p_72849_2_, p_72849_3_ + 1, false);
            int var9 = this.func_72849_a(p_72849_1_, p_72849_2_, p_72849_3_ - 1, false);
            if(var6 > var10) {
               var10 = var6;
            }

            if(var7 > var10) {
               var10 = var7;
            }

            if(var8 > var10) {
               var10 = var8;
            }

            if(var9 > var10) {
               var10 = var9;
            }

            return var10;
         } else if(p_72849_2_ < 0) {
            return 0;
         } else {
            if(p_72849_2_ >= 256) {
               p_72849_2_ = 255;
            }

            Chunk var5 = this.func_72964_e(p_72849_1_ >> 4, p_72849_3_ >> 4);
            p_72849_1_ &= 15;
            p_72849_3_ &= 15;
            return var5.func_76629_c(p_72849_1_, p_72849_2_, p_72849_3_, this.field_73008_k);
         }
      } else {
         return 15;
      }
   }

   public int func_72976_f(int p_72976_1_, int p_72976_2_) {
      if(p_72976_1_ >= -30000000 && p_72976_2_ >= -30000000 && p_72976_1_ < 30000000 && p_72976_2_ < 30000000) {
         if(!this.func_72916_c(p_72976_1_ >> 4, p_72976_2_ >> 4)) {
            return 0;
         } else {
            Chunk var3 = this.func_72964_e(p_72976_1_ >> 4, p_72976_2_ >> 4);
            return var3.func_76611_b(p_72976_1_ & 15, p_72976_2_ & 15);
         }
      } else {
         return 64;
      }
   }

   public int func_82734_g(int p_82734_1_, int p_82734_2_) {
      if(p_82734_1_ >= -30000000 && p_82734_2_ >= -30000000 && p_82734_1_ < 30000000 && p_82734_2_ < 30000000) {
         if(!this.func_72916_c(p_82734_1_ >> 4, p_82734_2_ >> 4)) {
            return 0;
         } else {
            Chunk var3 = this.func_72964_e(p_82734_1_ >> 4, p_82734_2_ >> 4);
            return var3.field_82912_p;
         }
      } else {
         return 64;
      }
   }

   public int func_72925_a(EnumSkyBlock p_72925_1_, int p_72925_2_, int p_72925_3_, int p_72925_4_) {
      if(this.field_73011_w.field_76576_e && p_72925_1_ == EnumSkyBlock.Sky) {
         return 0;
      } else {
         if(p_72925_3_ < 0) {
            p_72925_3_ = 0;
         }

         if(p_72925_3_ >= 256) {
            return p_72925_1_.field_77198_c;
         } else if(p_72925_2_ >= -30000000 && p_72925_4_ >= -30000000 && p_72925_2_ < 30000000 && p_72925_4_ < 30000000) {
            int var5 = p_72925_2_ >> 4;
            int var6 = p_72925_4_ >> 4;
            if(!this.func_72916_c(var5, var6)) {
               return p_72925_1_.field_77198_c;
            } else if(this.func_147439_a(p_72925_2_, p_72925_3_, p_72925_4_).func_149710_n()) {
               int var12 = this.func_72972_b(p_72925_1_, p_72925_2_, p_72925_3_ + 1, p_72925_4_);
               int var8 = this.func_72972_b(p_72925_1_, p_72925_2_ + 1, p_72925_3_, p_72925_4_);
               int var9 = this.func_72972_b(p_72925_1_, p_72925_2_ - 1, p_72925_3_, p_72925_4_);
               int var10 = this.func_72972_b(p_72925_1_, p_72925_2_, p_72925_3_, p_72925_4_ + 1);
               int var11 = this.func_72972_b(p_72925_1_, p_72925_2_, p_72925_3_, p_72925_4_ - 1);
               if(var8 > var12) {
                  var12 = var8;
               }

               if(var9 > var12) {
                  var12 = var9;
               }

               if(var10 > var12) {
                  var12 = var10;
               }

               if(var11 > var12) {
                  var12 = var11;
               }

               return var12;
            } else {
               Chunk var7 = this.func_72964_e(var5, var6);
               return var7.func_76614_a(p_72925_1_, p_72925_2_ & 15, p_72925_3_, p_72925_4_ & 15);
            }
         } else {
            return p_72925_1_.field_77198_c;
         }
      }
   }

   public int func_72972_b(EnumSkyBlock p_72972_1_, int p_72972_2_, int p_72972_3_, int p_72972_4_) {
      if(p_72972_3_ < 0) {
         p_72972_3_ = 0;
      }

      if(p_72972_3_ >= 256) {
         p_72972_3_ = 255;
      }

      if(p_72972_2_ >= -30000000 && p_72972_4_ >= -30000000 && p_72972_2_ < 30000000 && p_72972_4_ < 30000000) {
         int var5 = p_72972_2_ >> 4;
         int var6 = p_72972_4_ >> 4;
         if(!this.func_72916_c(var5, var6)) {
            return p_72972_1_.field_77198_c;
         } else {
            Chunk var7 = this.func_72964_e(var5, var6);
            return var7.func_76614_a(p_72972_1_, p_72972_2_ & 15, p_72972_3_, p_72972_4_ & 15);
         }
      } else {
         return p_72972_1_.field_77198_c;
      }
   }

   public void func_72915_b(EnumSkyBlock p_72915_1_, int p_72915_2_, int p_72915_3_, int p_72915_4_, int p_72915_5_) {
      if(p_72915_2_ >= -30000000 && p_72915_4_ >= -30000000 && p_72915_2_ < 30000000 && p_72915_4_ < 30000000) {
         if(p_72915_3_ >= 0) {
            if(p_72915_3_ < 256) {
               if(this.func_72916_c(p_72915_2_ >> 4, p_72915_4_ >> 4)) {
                  Chunk var6 = this.func_72964_e(p_72915_2_ >> 4, p_72915_4_ >> 4);
                  var6.func_76633_a(p_72915_1_, p_72915_2_ & 15, p_72915_3_, p_72915_4_ & 15, p_72915_5_);

                  for(int var7 = 0; var7 < this.field_73021_x.size(); ++var7) {
                     ((IWorldAccess)this.field_73021_x.get(var7)).func_147588_b(p_72915_2_, p_72915_3_, p_72915_4_);
                  }

               }
            }
         }
      }
   }

   public void func_147479_m(int p_147479_1_, int p_147479_2_, int p_147479_3_) {
      for(int var4 = 0; var4 < this.field_73021_x.size(); ++var4) {
         ((IWorldAccess)this.field_73021_x.get(var4)).func_147588_b(p_147479_1_, p_147479_2_, p_147479_3_);
      }

   }

   public int func_72802_i(int p_72802_1_, int p_72802_2_, int p_72802_3_, int p_72802_4_) {
      int var5 = this.func_72925_a(EnumSkyBlock.Sky, p_72802_1_, p_72802_2_, p_72802_3_);
      int var6 = this.func_72925_a(EnumSkyBlock.Block, p_72802_1_, p_72802_2_, p_72802_3_);
      if(var6 < p_72802_4_) {
         var6 = p_72802_4_;
      }

      return var5 << 20 | var6 << 4;
   }

   public float func_72801_o(int p_72801_1_, int p_72801_2_, int p_72801_3_) {
      return this.field_73011_w.field_76573_f[this.func_72957_l(p_72801_1_, p_72801_2_, p_72801_3_)];
   }

   public boolean func_72935_r() {
      return this.field_73008_k < 4;
   }

   public MovingObjectPosition func_72933_a(Vec3 p_72933_1_, Vec3 p_72933_2_) {
      return this.func_147447_a(p_72933_1_, p_72933_2_, false, false, false);
   }

   public MovingObjectPosition func_72901_a(Vec3 p_72901_1_, Vec3 p_72901_2_, boolean p_72901_3_) {
      return this.func_147447_a(p_72901_1_, p_72901_2_, p_72901_3_, false, false);
   }

   public MovingObjectPosition func_147447_a(Vec3 p_147447_1_, Vec3 p_147447_2_, boolean p_147447_3_, boolean p_147447_4_, boolean p_147447_5_) {
      if(!Double.isNaN(p_147447_1_.field_72450_a) && !Double.isNaN(p_147447_1_.field_72448_b) && !Double.isNaN(p_147447_1_.field_72449_c)) {
         if(!Double.isNaN(p_147447_2_.field_72450_a) && !Double.isNaN(p_147447_2_.field_72448_b) && !Double.isNaN(p_147447_2_.field_72449_c)) {
            int var6 = MathHelper.func_76128_c(p_147447_2_.field_72450_a);
            int var7 = MathHelper.func_76128_c(p_147447_2_.field_72448_b);
            int var8 = MathHelper.func_76128_c(p_147447_2_.field_72449_c);
            int var9 = MathHelper.func_76128_c(p_147447_1_.field_72450_a);
            int var10 = MathHelper.func_76128_c(p_147447_1_.field_72448_b);
            int var11 = MathHelper.func_76128_c(p_147447_1_.field_72449_c);
            Block var12 = this.func_147439_a(var9, var10, var11);
            int var13 = this.func_72805_g(var9, var10, var11);
            if((!p_147447_4_ || var12.func_149668_a(this, var9, var10, var11) != null) && var12.func_149678_a(var13, p_147447_3_)) {
               MovingObjectPosition var14 = var12.func_149731_a(this, var9, var10, var11, p_147447_1_, p_147447_2_);
               if(var14 != null) {
                  return var14;
               }
            }

            MovingObjectPosition var40 = null;
            var13 = 200;

            while(var13-- >= 0) {
               if(Double.isNaN(p_147447_1_.field_72450_a) || Double.isNaN(p_147447_1_.field_72448_b) || Double.isNaN(p_147447_1_.field_72449_c)) {
                  return null;
               }

               if(var9 == var6 && var10 == var7 && var11 == var8) {
                  return p_147447_5_?var40:null;
               }

               boolean var41 = true;
               boolean var15 = true;
               boolean var16 = true;
               double var17 = 999.0D;
               double var19 = 999.0D;
               double var21 = 999.0D;
               if(var6 > var9) {
                  var17 = (double)var9 + 1.0D;
               } else if(var6 < var9) {
                  var17 = (double)var9 + 0.0D;
               } else {
                  var41 = false;
               }

               if(var7 > var10) {
                  var19 = (double)var10 + 1.0D;
               } else if(var7 < var10) {
                  var19 = (double)var10 + 0.0D;
               } else {
                  var15 = false;
               }

               if(var8 > var11) {
                  var21 = (double)var11 + 1.0D;
               } else if(var8 < var11) {
                  var21 = (double)var11 + 0.0D;
               } else {
                  var16 = false;
               }

               double var23 = 999.0D;
               double var25 = 999.0D;
               double var27 = 999.0D;
               double var29 = p_147447_2_.field_72450_a - p_147447_1_.field_72450_a;
               double var31 = p_147447_2_.field_72448_b - p_147447_1_.field_72448_b;
               double var33 = p_147447_2_.field_72449_c - p_147447_1_.field_72449_c;
               if(var41) {
                  var23 = (var17 - p_147447_1_.field_72450_a) / var29;
               }

               if(var15) {
                  var25 = (var19 - p_147447_1_.field_72448_b) / var31;
               }

               if(var16) {
                  var27 = (var21 - p_147447_1_.field_72449_c) / var33;
               }

               boolean var35 = false;
               byte var42;
               if(var23 < var25 && var23 < var27) {
                  if(var6 > var9) {
                     var42 = 4;
                  } else {
                     var42 = 5;
                  }

                  p_147447_1_.field_72450_a = var17;
                  p_147447_1_.field_72448_b += var31 * var23;
                  p_147447_1_.field_72449_c += var33 * var23;
               } else if(var25 < var27) {
                  if(var7 > var10) {
                     var42 = 0;
                  } else {
                     var42 = 1;
                  }

                  p_147447_1_.field_72450_a += var29 * var25;
                  p_147447_1_.field_72448_b = var19;
                  p_147447_1_.field_72449_c += var33 * var25;
               } else {
                  if(var8 > var11) {
                     var42 = 2;
                  } else {
                     var42 = 3;
                  }

                  p_147447_1_.field_72450_a += var29 * var27;
                  p_147447_1_.field_72448_b += var31 * var27;
                  p_147447_1_.field_72449_c = var21;
               }

               Vec3 var36 = Vec3.func_72443_a(p_147447_1_.field_72450_a, p_147447_1_.field_72448_b, p_147447_1_.field_72449_c);
               var9 = (int)(var36.field_72450_a = (double)MathHelper.func_76128_c(p_147447_1_.field_72450_a));
               if(var42 == 5) {
                  --var9;
                  ++var36.field_72450_a;
               }

               var10 = (int)(var36.field_72448_b = (double)MathHelper.func_76128_c(p_147447_1_.field_72448_b));
               if(var42 == 1) {
                  --var10;
                  ++var36.field_72448_b;
               }

               var11 = (int)(var36.field_72449_c = (double)MathHelper.func_76128_c(p_147447_1_.field_72449_c));
               if(var42 == 3) {
                  --var11;
                  ++var36.field_72449_c;
               }

               Block var37 = this.func_147439_a(var9, var10, var11);
               int var38 = this.func_72805_g(var9, var10, var11);
               if(!p_147447_4_ || var37.func_149668_a(this, var9, var10, var11) != null) {
                  if(var37.func_149678_a(var38, p_147447_3_)) {
                     MovingObjectPosition var39 = var37.func_149731_a(this, var9, var10, var11, p_147447_1_, p_147447_2_);
                     if(var39 != null) {
                        return var39;
                     }
                  } else {
                     var40 = new MovingObjectPosition(var9, var10, var11, var42, p_147447_1_, false);
                  }
               }
            }

            return p_147447_5_?var40:null;
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   public void func_72956_a(Entity p_72956_1_, String p_72956_2_, float p_72956_3_, float p_72956_4_) {
      for(int var5 = 0; var5 < this.field_73021_x.size(); ++var5) {
         ((IWorldAccess)this.field_73021_x.get(var5)).func_72704_a(p_72956_2_, p_72956_1_.field_70165_t, p_72956_1_.field_70163_u - (double)p_72956_1_.field_70129_M, p_72956_1_.field_70161_v, p_72956_3_, p_72956_4_);
      }

   }

   public void func_85173_a(EntityPlayer p_85173_1_, String p_85173_2_, float p_85173_3_, float p_85173_4_) {
      for(int var5 = 0; var5 < this.field_73021_x.size(); ++var5) {
         ((IWorldAccess)this.field_73021_x.get(var5)).func_85102_a(p_85173_1_, p_85173_2_, p_85173_1_.field_70165_t, p_85173_1_.field_70163_u - (double)p_85173_1_.field_70129_M, p_85173_1_.field_70161_v, p_85173_3_, p_85173_4_);
      }

   }

   public void func_72908_a(double p_72908_1_, double p_72908_3_, double p_72908_5_, String p_72908_7_, float p_72908_8_, float p_72908_9_) {
      for(int var10 = 0; var10 < this.field_73021_x.size(); ++var10) {
         ((IWorldAccess)this.field_73021_x.get(var10)).func_72704_a(p_72908_7_, p_72908_1_, p_72908_3_, p_72908_5_, p_72908_8_, p_72908_9_);
      }

   }

   public void func_72980_b(double p_72980_1_, double p_72980_3_, double p_72980_5_, String p_72980_7_, float p_72980_8_, float p_72980_9_, boolean p_72980_10_) {}

   public void func_72934_a(String p_72934_1_, int p_72934_2_, int p_72934_3_, int p_72934_4_) {
      for(int var5 = 0; var5 < this.field_73021_x.size(); ++var5) {
         ((IWorldAccess)this.field_73021_x.get(var5)).func_72702_a(p_72934_1_, p_72934_2_, p_72934_3_, p_72934_4_);
      }

   }

   public void func_72869_a(String p_72869_1_, double p_72869_2_, double p_72869_4_, double p_72869_6_, double p_72869_8_, double p_72869_10_, double p_72869_12_) {
      for(int var14 = 0; var14 < this.field_73021_x.size(); ++var14) {
         ((IWorldAccess)this.field_73021_x.get(var14)).func_72708_a(p_72869_1_, p_72869_2_, p_72869_4_, p_72869_6_, p_72869_8_, p_72869_10_, p_72869_12_);
      }

   }

   public boolean func_72942_c(Entity p_72942_1_) {
      this.field_73007_j.add(p_72942_1_);
      return true;
   }

   public boolean func_72838_d(Entity p_72838_1_) {
      int var2 = MathHelper.func_76128_c(p_72838_1_.field_70165_t / 16.0D);
      int var3 = MathHelper.func_76128_c(p_72838_1_.field_70161_v / 16.0D);
      boolean var4 = p_72838_1_.field_98038_p;
      if(p_72838_1_ instanceof EntityPlayer) {
         var4 = true;
      }

      if(!var4 && !this.func_72916_c(var2, var3)) {
         return false;
      } else {
         if(p_72838_1_ instanceof EntityPlayer) {
            EntityPlayer var5 = (EntityPlayer)p_72838_1_;
            this.field_73010_i.add(var5);
            this.func_72854_c();
         }

         this.func_72964_e(var2, var3).func_76612_a(p_72838_1_);
         this.field_72996_f.add(p_72838_1_);
         this.func_72923_a(p_72838_1_);
         return true;
      }
   }

   protected void func_72923_a(Entity p_72923_1_) {
      for(int var2 = 0; var2 < this.field_73021_x.size(); ++var2) {
         ((IWorldAccess)this.field_73021_x.get(var2)).func_72703_a(p_72923_1_);
      }

   }

   protected void func_72847_b(Entity p_72847_1_) {
      for(int var2 = 0; var2 < this.field_73021_x.size(); ++var2) {
         ((IWorldAccess)this.field_73021_x.get(var2)).func_72709_b(p_72847_1_);
      }

   }

   public void func_72900_e(Entity p_72900_1_) {
      if(p_72900_1_.field_70153_n != null) {
         p_72900_1_.field_70153_n.func_70078_a((Entity)null);
      }

      if(p_72900_1_.field_70154_o != null) {
         p_72900_1_.func_70078_a((Entity)null);
      }

      p_72900_1_.func_70106_y();
      if(p_72900_1_ instanceof EntityPlayer) {
         this.field_73010_i.remove(p_72900_1_);
         this.func_72854_c();
         this.func_72847_b(p_72900_1_);
      }

   }

   public void func_72973_f(Entity p_72973_1_) {
      p_72973_1_.func_70106_y();
      if(p_72973_1_ instanceof EntityPlayer) {
         this.field_73010_i.remove(p_72973_1_);
         this.func_72854_c();
      }

      int var2 = p_72973_1_.field_70176_ah;
      int var3 = p_72973_1_.field_70164_aj;
      if(p_72973_1_.field_70175_ag && this.func_72916_c(var2, var3)) {
         this.func_72964_e(var2, var3).func_76622_b(p_72973_1_);
      }

      this.field_72996_f.remove(p_72973_1_);
      this.func_72847_b(p_72973_1_);
   }

   public void func_72954_a(IWorldAccess p_72954_1_) {
      this.field_73021_x.add(p_72954_1_);
   }

   public void func_72848_b(IWorldAccess p_72848_1_) {
      this.field_73021_x.remove(p_72848_1_);
   }

   public List func_72945_a(Entity p_72945_1_, AxisAlignedBB p_72945_2_) {
      this.field_72998_d.clear();
      int var3 = MathHelper.func_76128_c(p_72945_2_.field_72340_a);
      int var4 = MathHelper.func_76128_c(p_72945_2_.field_72336_d + 1.0D);
      int var5 = MathHelper.func_76128_c(p_72945_2_.field_72338_b);
      int var6 = MathHelper.func_76128_c(p_72945_2_.field_72337_e + 1.0D);
      int var7 = MathHelper.func_76128_c(p_72945_2_.field_72339_c);
      int var8 = MathHelper.func_76128_c(p_72945_2_.field_72334_f + 1.0D);

      for(int var9 = var3; var9 < var4; ++var9) {
         for(int var10 = var7; var10 < var8; ++var10) {
            if(this.func_72899_e(var9, 64, var10)) {
               for(int var11 = var5 - 1; var11 < var6; ++var11) {
                  Block var12;
                  if(var9 >= -30000000 && var9 < 30000000 && var10 >= -30000000 && var10 < 30000000) {
                     var12 = this.func_147439_a(var9, var11, var10);
                  } else {
                     var12 = Blocks.field_150348_b;
                  }

                  var12.func_149743_a(this, var9, var11, var10, p_72945_2_, this.field_72998_d, p_72945_1_);
               }
            }
         }
      }

      double var14 = 0.25D;
      List var15 = this.func_72839_b(p_72945_1_, p_72945_2_.func_72314_b(var14, var14, var14));

      for(int var16 = 0; var16 < var15.size(); ++var16) {
         AxisAlignedBB var13 = ((Entity)var15.get(var16)).func_70046_E();
         if(var13 != null && var13.func_72326_a(p_72945_2_)) {
            this.field_72998_d.add(var13);
         }

         var13 = p_72945_1_.func_70114_g((Entity)var15.get(var16));
         if(var13 != null && var13.func_72326_a(p_72945_2_)) {
            this.field_72998_d.add(var13);
         }
      }

      return this.field_72998_d;
   }

   public List func_147461_a(AxisAlignedBB p_147461_1_) {
      this.field_72998_d.clear();
      int var2 = MathHelper.func_76128_c(p_147461_1_.field_72340_a);
      int var3 = MathHelper.func_76128_c(p_147461_1_.field_72336_d + 1.0D);
      int var4 = MathHelper.func_76128_c(p_147461_1_.field_72338_b);
      int var5 = MathHelper.func_76128_c(p_147461_1_.field_72337_e + 1.0D);
      int var6 = MathHelper.func_76128_c(p_147461_1_.field_72339_c);
      int var7 = MathHelper.func_76128_c(p_147461_1_.field_72334_f + 1.0D);

      for(int var8 = var2; var8 < var3; ++var8) {
         for(int var9 = var6; var9 < var7; ++var9) {
            if(this.func_72899_e(var8, 64, var9)) {
               for(int var10 = var4 - 1; var10 < var5; ++var10) {
                  Block var11;
                  if(var8 >= -30000000 && var8 < 30000000 && var9 >= -30000000 && var9 < 30000000) {
                     var11 = this.func_147439_a(var8, var10, var9);
                  } else {
                     var11 = Blocks.field_150357_h;
                  }

                  var11.func_149743_a(this, var8, var10, var9, p_147461_1_, this.field_72998_d, (Entity)null);
               }
            }
         }
      }

      return this.field_72998_d;
   }

   public int func_72967_a(float p_72967_1_) {
      float var2 = this.func_72826_c(p_72967_1_);
      float var3 = 1.0F - (MathHelper.func_76134_b(var2 * 3.1415927F * 2.0F) * 2.0F + 0.5F);
      if(var3 < 0.0F) {
         var3 = 0.0F;
      }

      if(var3 > 1.0F) {
         var3 = 1.0F;
      }

      var3 = 1.0F - var3;
      var3 = (float)((double)var3 * (1.0D - (double)(this.func_72867_j(p_72967_1_) * 5.0F) / 16.0D));
      var3 = (float)((double)var3 * (1.0D - (double)(this.func_72819_i(p_72967_1_) * 5.0F) / 16.0D));
      var3 = 1.0F - var3;
      return (int)(var3 * 11.0F);
   }

   public float func_72971_b(float p_72971_1_) {
      float var2 = this.func_72826_c(p_72971_1_);
      float var3 = 1.0F - (MathHelper.func_76134_b(var2 * 3.1415927F * 2.0F) * 2.0F + 0.2F);
      if(var3 < 0.0F) {
         var3 = 0.0F;
      }

      if(var3 > 1.0F) {
         var3 = 1.0F;
      }

      var3 = 1.0F - var3;
      var3 = (float)((double)var3 * (1.0D - (double)(this.func_72867_j(p_72971_1_) * 5.0F) / 16.0D));
      var3 = (float)((double)var3 * (1.0D - (double)(this.func_72819_i(p_72971_1_) * 5.0F) / 16.0D));
      return var3 * 0.8F + 0.2F;
   }

   public Vec3 func_72833_a(Entity p_72833_1_, float p_72833_2_) {
      float var3 = this.func_72826_c(p_72833_2_);
      float var4 = MathHelper.func_76134_b(var3 * 3.1415927F * 2.0F) * 2.0F + 0.5F;
      if(var4 < 0.0F) {
         var4 = 0.0F;
      }

      if(var4 > 1.0F) {
         var4 = 1.0F;
      }

      int var5 = MathHelper.func_76128_c(p_72833_1_.field_70165_t);
      int var6 = MathHelper.func_76128_c(p_72833_1_.field_70163_u);
      int var7 = MathHelper.func_76128_c(p_72833_1_.field_70161_v);
      BiomeGenBase var8 = this.func_72807_a(var5, var7);
      float var9 = var8.func_150564_a(var5, var6, var7);
      int var10 = var8.func_76731_a(var9);
      float var11 = (float)(var10 >> 16 & 255) / 255.0F;
      float var12 = (float)(var10 >> 8 & 255) / 255.0F;
      float var13 = (float)(var10 & 255) / 255.0F;
      var11 *= var4;
      var12 *= var4;
      var13 *= var4;
      float var14 = this.func_72867_j(p_72833_2_);
      float var15;
      float var16;
      if(var14 > 0.0F) {
         var15 = (var11 * 0.3F + var12 * 0.59F + var13 * 0.11F) * 0.6F;
         var16 = 1.0F - var14 * 0.75F;
         var11 = var11 * var16 + var15 * (1.0F - var16);
         var12 = var12 * var16 + var15 * (1.0F - var16);
         var13 = var13 * var16 + var15 * (1.0F - var16);
      }

      var15 = this.func_72819_i(p_72833_2_);
      if(var15 > 0.0F) {
         var16 = (var11 * 0.3F + var12 * 0.59F + var13 * 0.11F) * 0.2F;
         float var17 = 1.0F - var15 * 0.75F;
         var11 = var11 * var17 + var16 * (1.0F - var17);
         var12 = var12 * var17 + var16 * (1.0F - var17);
         var13 = var13 * var17 + var16 * (1.0F - var17);
      }

      if(this.field_73016_r > 0) {
         var16 = (float)this.field_73016_r - p_72833_2_;
         if(var16 > 1.0F) {
            var16 = 1.0F;
         }

         var16 *= 0.45F;
         var11 = var11 * (1.0F - var16) + 0.8F * var16;
         var12 = var12 * (1.0F - var16) + 0.8F * var16;
         var13 = var13 * (1.0F - var16) + 1.0F * var16;
      }

      return Vec3.func_72443_a((double)var11, (double)var12, (double)var13);
   }

   public float func_72826_c(float p_72826_1_) {
      return this.field_73011_w.func_76563_a(this.field_72986_A.func_76073_f(), p_72826_1_);
   }

   public int func_72853_d() {
      return this.field_73011_w.func_76559_b(this.field_72986_A.func_76073_f());
   }

   public float func_130001_d() {
      return WorldProvider.field_111203_a[this.field_73011_w.func_76559_b(this.field_72986_A.func_76073_f())];
   }

   public float func_72929_e(float p_72929_1_) {
      float var2 = this.func_72826_c(p_72929_1_);
      return var2 * 3.1415927F * 2.0F;
   }

   public Vec3 func_72824_f(float p_72824_1_) {
      float var2 = this.func_72826_c(p_72824_1_);
      float var3 = MathHelper.func_76134_b(var2 * 3.1415927F * 2.0F) * 2.0F + 0.5F;
      if(var3 < 0.0F) {
         var3 = 0.0F;
      }

      if(var3 > 1.0F) {
         var3 = 1.0F;
      }

      float var4 = (float)(this.field_73001_c >> 16 & 255L) / 255.0F;
      float var5 = (float)(this.field_73001_c >> 8 & 255L) / 255.0F;
      float var6 = (float)(this.field_73001_c & 255L) / 255.0F;
      float var7 = this.func_72867_j(p_72824_1_);
      float var8;
      float var9;
      if(var7 > 0.0F) {
         var8 = (var4 * 0.3F + var5 * 0.59F + var6 * 0.11F) * 0.6F;
         var9 = 1.0F - var7 * 0.95F;
         var4 = var4 * var9 + var8 * (1.0F - var9);
         var5 = var5 * var9 + var8 * (1.0F - var9);
         var6 = var6 * var9 + var8 * (1.0F - var9);
      }

      var4 *= var3 * 0.9F + 0.1F;
      var5 *= var3 * 0.9F + 0.1F;
      var6 *= var3 * 0.85F + 0.15F;
      var8 = this.func_72819_i(p_72824_1_);
      if(var8 > 0.0F) {
         var9 = (var4 * 0.3F + var5 * 0.59F + var6 * 0.11F) * 0.2F;
         float var10 = 1.0F - var8 * 0.95F;
         var4 = var4 * var10 + var9 * (1.0F - var10);
         var5 = var5 * var10 + var9 * (1.0F - var10);
         var6 = var6 * var10 + var9 * (1.0F - var10);
      }

      return Vec3.func_72443_a((double)var4, (double)var5, (double)var6);
   }

   public Vec3 func_72948_g(float p_72948_1_) {
      float var2 = this.func_72826_c(p_72948_1_);
      return this.field_73011_w.func_76562_b(var2, p_72948_1_);
   }

   public int func_72874_g(int p_72874_1_, int p_72874_2_) {
      return this.func_72938_d(p_72874_1_, p_72874_2_).func_76626_d(p_72874_1_ & 15, p_72874_2_ & 15);
   }

   public int func_72825_h(int p_72825_1_, int p_72825_2_) {
      Chunk var3 = this.func_72938_d(p_72825_1_, p_72825_2_);
      int var4 = var3.func_76625_h() + 15;
      p_72825_1_ &= 15;

      for(p_72825_2_ &= 15; var4 > 0; --var4) {
         Block var5 = var3.func_150810_a(p_72825_1_, var4, p_72825_2_);
         if(var5.func_149688_o().func_76230_c() && var5.func_149688_o() != Material.field_151584_j) {
            return var4 + 1;
         }
      }

      return -1;
   }

   public float func_72880_h(float p_72880_1_) {
      float var2 = this.func_72826_c(p_72880_1_);
      float var3 = 1.0F - (MathHelper.func_76134_b(var2 * 3.1415927F * 2.0F) * 2.0F + 0.25F);
      if(var3 < 0.0F) {
         var3 = 0.0F;
      }

      if(var3 > 1.0F) {
         var3 = 1.0F;
      }

      return var3 * var3 * 0.5F;
   }

   public void func_147464_a(int p_147464_1_, int p_147464_2_, int p_147464_3_, Block p_147464_4_, int p_147464_5_) {}

   public void func_147454_a(int p_147454_1_, int p_147454_2_, int p_147454_3_, Block p_147454_4_, int p_147454_5_, int p_147454_6_) {}

   public void func_147446_b(int p_147446_1_, int p_147446_2_, int p_147446_3_, Block p_147446_4_, int p_147446_5_, int p_147446_6_) {}

   public void func_72939_s() {
      this.field_72984_F.func_76320_a("entities");
      this.field_72984_F.func_76320_a("global");

      int var1;
      Entity var2;
      CrashReport var4;
      CrashReportCategory var5;
      for(var1 = 0; var1 < this.field_73007_j.size(); ++var1) {
         var2 = (Entity)this.field_73007_j.get(var1);

         try {
            ++var2.field_70173_aa;
            var2.func_70071_h_();
         } catch (Throwable var8) {
            var4 = CrashReport.func_85055_a(var8, "Ticking entity");
            var5 = var4.func_85058_a("Entity being ticked");
            if(var2 == null) {
               var5.func_71507_a("Entity", "~~NULL~~");
            } else {
               var2.func_85029_a(var5);
            }

            throw new ReportedException(var4);
         }

         if(var2.field_70128_L) {
            this.field_73007_j.remove(var1--);
         }
      }

      this.field_72984_F.func_76318_c("remove");
      this.field_72996_f.removeAll(this.field_72997_g);

      int var3;
      int var14;
      for(var1 = 0; var1 < this.field_72997_g.size(); ++var1) {
         var2 = (Entity)this.field_72997_g.get(var1);
         var3 = var2.field_70176_ah;
         var14 = var2.field_70164_aj;
         if(var2.field_70175_ag && this.func_72916_c(var3, var14)) {
            this.func_72964_e(var3, var14).func_76622_b(var2);
         }
      }

      for(var1 = 0; var1 < this.field_72997_g.size(); ++var1) {
         this.func_72847_b((Entity)this.field_72997_g.get(var1));
      }

      this.field_72997_g.clear();
      this.field_72984_F.func_76318_c("regular");

      for(var1 = 0; var1 < this.field_72996_f.size(); ++var1) {
         var2 = (Entity)this.field_72996_f.get(var1);
         if(var2.field_70154_o != null) {
            if(!var2.field_70154_o.field_70128_L && var2.field_70154_o.field_70153_n == var2) {
               continue;
            }

            var2.field_70154_o.field_70153_n = null;
            var2.field_70154_o = null;
         }

         this.field_72984_F.func_76320_a("tick");
         if(!var2.field_70128_L) {
            try {
               this.func_72870_g(var2);
            } catch (Throwable var7) {
               var4 = CrashReport.func_85055_a(var7, "Ticking entity");
               var5 = var4.func_85058_a("Entity being ticked");
               var2.func_85029_a(var5);
               throw new ReportedException(var4);
            }
         }

         this.field_72984_F.func_76319_b();
         this.field_72984_F.func_76320_a("remove");
         if(var2.field_70128_L) {
            var3 = var2.field_70176_ah;
            var14 = var2.field_70164_aj;
            if(var2.field_70175_ag && this.func_72916_c(var3, var14)) {
               this.func_72964_e(var3, var14).func_76622_b(var2);
            }

            this.field_72996_f.remove(var1--);
            this.func_72847_b(var2);
         }

         this.field_72984_F.func_76319_b();
      }

      this.field_72984_F.func_76318_c("blockEntities");
      this.field_147481_N = true;
      Iterator var9 = this.field_147482_g.iterator();

      while(var9.hasNext()) {
         TileEntity var10 = (TileEntity)var9.next();
         if(!var10.func_145837_r() && var10.func_145830_o() && this.func_72899_e(var10.field_145851_c, var10.field_145848_d, var10.field_145849_e)) {
            try {
               var10.func_145845_h();
            } catch (Throwable var6) {
               var4 = CrashReport.func_85055_a(var6, "Ticking block entity");
               var5 = var4.func_85058_a("Block entity being ticked");
               var10.func_145828_a(var5);
               throw new ReportedException(var4);
            }
         }

         if(var10.func_145837_r()) {
            var9.remove();
            if(this.func_72916_c(var10.field_145851_c >> 4, var10.field_145849_e >> 4)) {
               Chunk var12 = this.func_72964_e(var10.field_145851_c >> 4, var10.field_145849_e >> 4);
               if(var12 != null) {
                  var12.func_150805_f(var10.field_145851_c & 15, var10.field_145848_d, var10.field_145849_e & 15);
               }
            }
         }
      }

      this.field_147481_N = false;
      if(!this.field_147483_b.isEmpty()) {
         this.field_147482_g.removeAll(this.field_147483_b);
         this.field_147483_b.clear();
      }

      this.field_72984_F.func_76318_c("pendingBlockEntities");
      if(!this.field_147484_a.isEmpty()) {
         for(int var11 = 0; var11 < this.field_147484_a.size(); ++var11) {
            TileEntity var13 = (TileEntity)this.field_147484_a.get(var11);
            if(!var13.func_145837_r()) {
               if(!this.field_147482_g.contains(var13)) {
                  this.field_147482_g.add(var13);
               }

               if(this.func_72916_c(var13.field_145851_c >> 4, var13.field_145849_e >> 4)) {
                  Chunk var15 = this.func_72964_e(var13.field_145851_c >> 4, var13.field_145849_e >> 4);
                  if(var15 != null) {
                     var15.func_150812_a(var13.field_145851_c & 15, var13.field_145848_d, var13.field_145849_e & 15, var13);
                  }
               }

               this.func_147471_g(var13.field_145851_c, var13.field_145848_d, var13.field_145849_e);
            }
         }

         this.field_147484_a.clear();
      }

      this.field_72984_F.func_76319_b();
      this.field_72984_F.func_76319_b();
   }

   public void func_147448_a(Collection p_147448_1_) {
      if(this.field_147481_N) {
         this.field_147484_a.addAll(p_147448_1_);
      } else {
         this.field_147482_g.addAll(p_147448_1_);
      }

   }

   public void func_72870_g(Entity p_72870_1_) {
      this.func_72866_a(p_72870_1_, true);
   }

   public void func_72866_a(Entity p_72866_1_, boolean p_72866_2_) {
      int var3 = MathHelper.func_76128_c(p_72866_1_.field_70165_t);
      int var4 = MathHelper.func_76128_c(p_72866_1_.field_70161_v);
      byte var5 = 32;
      if(!p_72866_2_ || this.func_72904_c(var3 - var5, 0, var4 - var5, var3 + var5, 0, var4 + var5)) {
         p_72866_1_.field_70142_S = p_72866_1_.field_70165_t;
         p_72866_1_.field_70137_T = p_72866_1_.field_70163_u;
         p_72866_1_.field_70136_U = p_72866_1_.field_70161_v;
         p_72866_1_.field_70126_B = p_72866_1_.field_70177_z;
         p_72866_1_.field_70127_C = p_72866_1_.field_70125_A;
         if(p_72866_2_ && p_72866_1_.field_70175_ag) {
            ++p_72866_1_.field_70173_aa;
            if(p_72866_1_.field_70154_o != null) {
               p_72866_1_.func_70098_U();
            } else {
               p_72866_1_.func_70071_h_();
            }
         }

         this.field_72984_F.func_76320_a("chunkCheck");
         if(Double.isNaN(p_72866_1_.field_70165_t) || Double.isInfinite(p_72866_1_.field_70165_t)) {
            p_72866_1_.field_70165_t = p_72866_1_.field_70142_S;
         }

         if(Double.isNaN(p_72866_1_.field_70163_u) || Double.isInfinite(p_72866_1_.field_70163_u)) {
            p_72866_1_.field_70163_u = p_72866_1_.field_70137_T;
         }

         if(Double.isNaN(p_72866_1_.field_70161_v) || Double.isInfinite(p_72866_1_.field_70161_v)) {
            p_72866_1_.field_70161_v = p_72866_1_.field_70136_U;
         }

         if(Double.isNaN((double)p_72866_1_.field_70125_A) || Double.isInfinite((double)p_72866_1_.field_70125_A)) {
            p_72866_1_.field_70125_A = p_72866_1_.field_70127_C;
         }

         if(Double.isNaN((double)p_72866_1_.field_70177_z) || Double.isInfinite((double)p_72866_1_.field_70177_z)) {
            p_72866_1_.field_70177_z = p_72866_1_.field_70126_B;
         }

         int var6 = MathHelper.func_76128_c(p_72866_1_.field_70165_t / 16.0D);
         int var7 = MathHelper.func_76128_c(p_72866_1_.field_70163_u / 16.0D);
         int var8 = MathHelper.func_76128_c(p_72866_1_.field_70161_v / 16.0D);
         if(!p_72866_1_.field_70175_ag || p_72866_1_.field_70176_ah != var6 || p_72866_1_.field_70162_ai != var7 || p_72866_1_.field_70164_aj != var8) {
            if(p_72866_1_.field_70175_ag && this.func_72916_c(p_72866_1_.field_70176_ah, p_72866_1_.field_70164_aj)) {
               this.func_72964_e(p_72866_1_.field_70176_ah, p_72866_1_.field_70164_aj).func_76608_a(p_72866_1_, p_72866_1_.field_70162_ai);
            }

            if(this.func_72916_c(var6, var8)) {
               p_72866_1_.field_70175_ag = true;
               this.func_72964_e(var6, var8).func_76612_a(p_72866_1_);
            } else {
               p_72866_1_.field_70175_ag = false;
            }
         }

         this.field_72984_F.func_76319_b();
         if(p_72866_2_ && p_72866_1_.field_70175_ag && p_72866_1_.field_70153_n != null) {
            if(!p_72866_1_.field_70153_n.field_70128_L && p_72866_1_.field_70153_n.field_70154_o == p_72866_1_) {
               this.func_72870_g(p_72866_1_.field_70153_n);
            } else {
               p_72866_1_.field_70153_n.field_70154_o = null;
               p_72866_1_.field_70153_n = null;
            }
         }

      }
   }

   public boolean func_72855_b(AxisAlignedBB p_72855_1_) {
      return this.func_72917_a(p_72855_1_, (Entity)null);
   }

   public boolean func_72917_a(AxisAlignedBB p_72917_1_, Entity p_72917_2_) {
      List var3 = this.func_72839_b((Entity)null, p_72917_1_);

      for(int var4 = 0; var4 < var3.size(); ++var4) {
         Entity var5 = (Entity)var3.get(var4);
         if(!var5.field_70128_L && var5.field_70156_m && var5 != p_72917_2_) {
            return false;
         }
      }

      return true;
   }

   public boolean func_72829_c(AxisAlignedBB p_72829_1_) {
      int var2 = MathHelper.func_76128_c(p_72829_1_.field_72340_a);
      int var3 = MathHelper.func_76128_c(p_72829_1_.field_72336_d + 1.0D);
      int var4 = MathHelper.func_76128_c(p_72829_1_.field_72338_b);
      int var5 = MathHelper.func_76128_c(p_72829_1_.field_72337_e + 1.0D);
      int var6 = MathHelper.func_76128_c(p_72829_1_.field_72339_c);
      int var7 = MathHelper.func_76128_c(p_72829_1_.field_72334_f + 1.0D);
      if(p_72829_1_.field_72340_a < 0.0D) {
         --var2;
      }

      if(p_72829_1_.field_72338_b < 0.0D) {
         --var4;
      }

      if(p_72829_1_.field_72339_c < 0.0D) {
         --var6;
      }

      for(int var8 = var2; var8 < var3; ++var8) {
         for(int var9 = var4; var9 < var5; ++var9) {
            for(int var10 = var6; var10 < var7; ++var10) {
               Block var11 = this.func_147439_a(var8, var9, var10);
               if(var11.func_149688_o() != Material.field_151579_a) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public boolean func_72953_d(AxisAlignedBB p_72953_1_) {
      int var2 = MathHelper.func_76128_c(p_72953_1_.field_72340_a);
      int var3 = MathHelper.func_76128_c(p_72953_1_.field_72336_d + 1.0D);
      int var4 = MathHelper.func_76128_c(p_72953_1_.field_72338_b);
      int var5 = MathHelper.func_76128_c(p_72953_1_.field_72337_e + 1.0D);
      int var6 = MathHelper.func_76128_c(p_72953_1_.field_72339_c);
      int var7 = MathHelper.func_76128_c(p_72953_1_.field_72334_f + 1.0D);
      if(p_72953_1_.field_72340_a < 0.0D) {
         --var2;
      }

      if(p_72953_1_.field_72338_b < 0.0D) {
         --var4;
      }

      if(p_72953_1_.field_72339_c < 0.0D) {
         --var6;
      }

      for(int var8 = var2; var8 < var3; ++var8) {
         for(int var9 = var4; var9 < var5; ++var9) {
            for(int var10 = var6; var10 < var7; ++var10) {
               Block var11 = this.func_147439_a(var8, var9, var10);
               if(var11.func_149688_o().func_76224_d()) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public boolean func_147470_e(AxisAlignedBB p_147470_1_) {
      int var2 = MathHelper.func_76128_c(p_147470_1_.field_72340_a);
      int var3 = MathHelper.func_76128_c(p_147470_1_.field_72336_d + 1.0D);
      int var4 = MathHelper.func_76128_c(p_147470_1_.field_72338_b);
      int var5 = MathHelper.func_76128_c(p_147470_1_.field_72337_e + 1.0D);
      int var6 = MathHelper.func_76128_c(p_147470_1_.field_72339_c);
      int var7 = MathHelper.func_76128_c(p_147470_1_.field_72334_f + 1.0D);
      if(this.func_72904_c(var2, var4, var6, var3, var5, var7)) {
         for(int var8 = var2; var8 < var3; ++var8) {
            for(int var9 = var4; var9 < var5; ++var9) {
               for(int var10 = var6; var10 < var7; ++var10) {
                  Block var11 = this.func_147439_a(var8, var9, var10);
                  if(var11 == Blocks.field_150480_ab || var11 == Blocks.field_150356_k || var11 == Blocks.field_150353_l) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   public boolean func_72918_a(AxisAlignedBB p_72918_1_, Material p_72918_2_, Entity p_72918_3_) {
      int var4 = MathHelper.func_76128_c(p_72918_1_.field_72340_a);
      int var5 = MathHelper.func_76128_c(p_72918_1_.field_72336_d + 1.0D);
      int var6 = MathHelper.func_76128_c(p_72918_1_.field_72338_b);
      int var7 = MathHelper.func_76128_c(p_72918_1_.field_72337_e + 1.0D);
      int var8 = MathHelper.func_76128_c(p_72918_1_.field_72339_c);
      int var9 = MathHelper.func_76128_c(p_72918_1_.field_72334_f + 1.0D);
      if(!this.func_72904_c(var4, var6, var8, var5, var7, var9)) {
         return false;
      } else {
         boolean var10 = false;
         Vec3 var11 = Vec3.func_72443_a(0.0D, 0.0D, 0.0D);

         for(int var12 = var4; var12 < var5; ++var12) {
            for(int var13 = var6; var13 < var7; ++var13) {
               for(int var14 = var8; var14 < var9; ++var14) {
                  Block var15 = this.func_147439_a(var12, var13, var14);
                  if(var15.func_149688_o() == p_72918_2_) {
                     double var16 = (double)((float)(var13 + 1) - BlockLiquid.func_149801_b(this.func_72805_g(var12, var13, var14)));
                     if((double)var7 >= var16) {
                        var10 = true;
                        var15.func_149640_a(this, var12, var13, var14, p_72918_3_, var11);
                     }
                  }
               }
            }
         }

         if(var11.func_72433_c() > 0.0D && p_72918_3_.func_96092_aw()) {
            var11 = var11.func_72432_b();
            double var18 = 0.014D;
            p_72918_3_.field_70159_w += var11.field_72450_a * var18;
            p_72918_3_.field_70181_x += var11.field_72448_b * var18;
            p_72918_3_.field_70179_y += var11.field_72449_c * var18;
         }

         return var10;
      }
   }

   public boolean func_72875_a(AxisAlignedBB p_72875_1_, Material p_72875_2_) {
      int var3 = MathHelper.func_76128_c(p_72875_1_.field_72340_a);
      int var4 = MathHelper.func_76128_c(p_72875_1_.field_72336_d + 1.0D);
      int var5 = MathHelper.func_76128_c(p_72875_1_.field_72338_b);
      int var6 = MathHelper.func_76128_c(p_72875_1_.field_72337_e + 1.0D);
      int var7 = MathHelper.func_76128_c(p_72875_1_.field_72339_c);
      int var8 = MathHelper.func_76128_c(p_72875_1_.field_72334_f + 1.0D);

      for(int var9 = var3; var9 < var4; ++var9) {
         for(int var10 = var5; var10 < var6; ++var10) {
            for(int var11 = var7; var11 < var8; ++var11) {
               if(this.func_147439_a(var9, var10, var11).func_149688_o() == p_72875_2_) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public boolean func_72830_b(AxisAlignedBB p_72830_1_, Material p_72830_2_) {
      int var3 = MathHelper.func_76128_c(p_72830_1_.field_72340_a);
      int var4 = MathHelper.func_76128_c(p_72830_1_.field_72336_d + 1.0D);
      int var5 = MathHelper.func_76128_c(p_72830_1_.field_72338_b);
      int var6 = MathHelper.func_76128_c(p_72830_1_.field_72337_e + 1.0D);
      int var7 = MathHelper.func_76128_c(p_72830_1_.field_72339_c);
      int var8 = MathHelper.func_76128_c(p_72830_1_.field_72334_f + 1.0D);

      for(int var9 = var3; var9 < var4; ++var9) {
         for(int var10 = var5; var10 < var6; ++var10) {
            for(int var11 = var7; var11 < var8; ++var11) {
               Block var12 = this.func_147439_a(var9, var10, var11);
               if(var12.func_149688_o() == p_72830_2_) {
                  int var13 = this.func_72805_g(var9, var10, var11);
                  double var14 = (double)(var10 + 1);
                  if(var13 < 8) {
                     var14 = (double)(var10 + 1) - (double)var13 / 8.0D;
                  }

                  if(var14 >= p_72830_1_.field_72338_b) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   public Explosion func_72876_a(Entity p_72876_1_, double p_72876_2_, double p_72876_4_, double p_72876_6_, float p_72876_8_, boolean p_72876_9_) {
      return this.func_72885_a(p_72876_1_, p_72876_2_, p_72876_4_, p_72876_6_, p_72876_8_, false, p_72876_9_);
   }

   public Explosion func_72885_a(Entity p_72885_1_, double p_72885_2_, double p_72885_4_, double p_72885_6_, float p_72885_8_, boolean p_72885_9_, boolean p_72885_10_) {
      Explosion var11 = new Explosion(this, p_72885_1_, p_72885_2_, p_72885_4_, p_72885_6_, p_72885_8_);
      var11.field_77286_a = p_72885_9_;
      var11.field_82755_b = p_72885_10_;
      var11.func_77278_a();
      var11.func_77279_a(true);
      return var11;
   }

   public float func_72842_a(Vec3 p_72842_1_, AxisAlignedBB p_72842_2_) {
      double var3 = 1.0D / ((p_72842_2_.field_72336_d - p_72842_2_.field_72340_a) * 2.0D + 1.0D);
      double var5 = 1.0D / ((p_72842_2_.field_72337_e - p_72842_2_.field_72338_b) * 2.0D + 1.0D);
      double var7 = 1.0D / ((p_72842_2_.field_72334_f - p_72842_2_.field_72339_c) * 2.0D + 1.0D);
      if(var3 >= 0.0D && var5 >= 0.0D && var7 >= 0.0D) {
         int var9 = 0;
         int var10 = 0;

         for(float var11 = 0.0F; var11 <= 1.0F; var11 = (float)((double)var11 + var3)) {
            for(float var12 = 0.0F; var12 <= 1.0F; var12 = (float)((double)var12 + var5)) {
               for(float var13 = 0.0F; var13 <= 1.0F; var13 = (float)((double)var13 + var7)) {
                  double var14 = p_72842_2_.field_72340_a + (p_72842_2_.field_72336_d - p_72842_2_.field_72340_a) * (double)var11;
                  double var16 = p_72842_2_.field_72338_b + (p_72842_2_.field_72337_e - p_72842_2_.field_72338_b) * (double)var12;
                  double var18 = p_72842_2_.field_72339_c + (p_72842_2_.field_72334_f - p_72842_2_.field_72339_c) * (double)var13;
                  if(this.func_72933_a(Vec3.func_72443_a(var14, var16, var18), p_72842_1_) == null) {
                     ++var9;
                  }

                  ++var10;
               }
            }
         }

         return (float)var9 / (float)var10;
      } else {
         return 0.0F;
      }
   }

   public boolean func_72886_a(EntityPlayer p_72886_1_, int p_72886_2_, int p_72886_3_, int p_72886_4_, int p_72886_5_) {
      if(p_72886_5_ == 0) {
         --p_72886_3_;
      }

      if(p_72886_5_ == 1) {
         ++p_72886_3_;
      }

      if(p_72886_5_ == 2) {
         --p_72886_4_;
      }

      if(p_72886_5_ == 3) {
         ++p_72886_4_;
      }

      if(p_72886_5_ == 4) {
         --p_72886_2_;
      }

      if(p_72886_5_ == 5) {
         ++p_72886_2_;
      }

      if(this.func_147439_a(p_72886_2_, p_72886_3_, p_72886_4_) == Blocks.field_150480_ab) {
         this.func_72889_a(p_72886_1_, 1004, p_72886_2_, p_72886_3_, p_72886_4_, 0);
         this.func_147468_f(p_72886_2_, p_72886_3_, p_72886_4_);
         return true;
      } else {
         return false;
      }
   }

   public String func_72981_t() {
      return "All: " + this.field_72996_f.size();
   }

   public String func_72827_u() {
      return this.field_73020_y.func_73148_d();
   }

   public TileEntity func_147438_o(int p_147438_1_, int p_147438_2_, int p_147438_3_) {
      if(p_147438_2_ >= 0 && p_147438_2_ < 256) {
         TileEntity var4 = null;
         int var5;
         TileEntity var6;
         if(this.field_147481_N) {
            for(var5 = 0; var5 < this.field_147484_a.size(); ++var5) {
               var6 = (TileEntity)this.field_147484_a.get(var5);
               if(!var6.func_145837_r() && var6.field_145851_c == p_147438_1_ && var6.field_145848_d == p_147438_2_ && var6.field_145849_e == p_147438_3_) {
                  var4 = var6;
                  break;
               }
            }
         }

         if(var4 == null) {
            Chunk var7 = this.func_72964_e(p_147438_1_ >> 4, p_147438_3_ >> 4);
            if(var7 != null) {
               var4 = var7.func_150806_e(p_147438_1_ & 15, p_147438_2_, p_147438_3_ & 15);
            }
         }

         if(var4 == null) {
            for(var5 = 0; var5 < this.field_147484_a.size(); ++var5) {
               var6 = (TileEntity)this.field_147484_a.get(var5);
               if(!var6.func_145837_r() && var6.field_145851_c == p_147438_1_ && var6.field_145848_d == p_147438_2_ && var6.field_145849_e == p_147438_3_) {
                  var4 = var6;
                  break;
               }
            }
         }

         return var4;
      } else {
         return null;
      }
   }

   public void func_147455_a(int p_147455_1_, int p_147455_2_, int p_147455_3_, TileEntity p_147455_4_) {
      if(p_147455_4_ != null && !p_147455_4_.func_145837_r()) {
         if(this.field_147481_N) {
            p_147455_4_.field_145851_c = p_147455_1_;
            p_147455_4_.field_145848_d = p_147455_2_;
            p_147455_4_.field_145849_e = p_147455_3_;
            Iterator var5 = this.field_147484_a.iterator();

            while(var5.hasNext()) {
               TileEntity var6 = (TileEntity)var5.next();
               if(var6.field_145851_c == p_147455_1_ && var6.field_145848_d == p_147455_2_ && var6.field_145849_e == p_147455_3_) {
                  var6.func_145843_s();
                  var5.remove();
               }
            }

            this.field_147484_a.add(p_147455_4_);
         } else {
            this.field_147482_g.add(p_147455_4_);
            Chunk var7 = this.func_72964_e(p_147455_1_ >> 4, p_147455_3_ >> 4);
            if(var7 != null) {
               var7.func_150812_a(p_147455_1_ & 15, p_147455_2_, p_147455_3_ & 15, p_147455_4_);
            }
         }
      }

   }

   public void func_147475_p(int p_147475_1_, int p_147475_2_, int p_147475_3_) {
      TileEntity var4 = this.func_147438_o(p_147475_1_, p_147475_2_, p_147475_3_);
      if(var4 != null && this.field_147481_N) {
         var4.func_145843_s();
         this.field_147484_a.remove(var4);
      } else {
         if(var4 != null) {
            this.field_147484_a.remove(var4);
            this.field_147482_g.remove(var4);
         }

         Chunk var5 = this.func_72964_e(p_147475_1_ >> 4, p_147475_3_ >> 4);
         if(var5 != null) {
            var5.func_150805_f(p_147475_1_ & 15, p_147475_2_, p_147475_3_ & 15);
         }
      }

   }

   public void func_147457_a(TileEntity p_147457_1_) {
      this.field_147483_b.add(p_147457_1_);
   }

   public boolean func_147469_q(int p_147469_1_, int p_147469_2_, int p_147469_3_) {
      AxisAlignedBB var4 = this.func_147439_a(p_147469_1_, p_147469_2_, p_147469_3_).func_149668_a(this, p_147469_1_, p_147469_2_, p_147469_3_);
      return var4 != null && var4.func_72320_b() >= 1.0D;
   }

   public static boolean func_147466_a(IBlockAccess p_147466_0_, int p_147466_1_, int p_147466_2_, int p_147466_3_) {
      Block var4 = p_147466_0_.func_147439_a(p_147466_1_, p_147466_2_, p_147466_3_);
      int var5 = p_147466_0_.func_72805_g(p_147466_1_, p_147466_2_, p_147466_3_);
      return var4.func_149688_o().func_76218_k() && var4.func_149686_d()?true:(var4 instanceof BlockStairs?(var5 & 4) == 4:(var4 instanceof BlockSlab?(var5 & 8) == 8:(var4 instanceof BlockHopper?true:(var4 instanceof BlockSnow?(var5 & 7) == 7:false))));
   }

   public boolean func_147445_c(int p_147445_1_, int p_147445_2_, int p_147445_3_, boolean p_147445_4_) {
      if(p_147445_1_ >= -30000000 && p_147445_3_ >= -30000000 && p_147445_1_ < 30000000 && p_147445_3_ < 30000000) {
         Chunk var5 = this.field_73020_y.func_73154_d(p_147445_1_ >> 4, p_147445_3_ >> 4);
         if(var5 != null && !var5.func_76621_g()) {
            Block var6 = this.func_147439_a(p_147445_1_, p_147445_2_, p_147445_3_);
            return var6.func_149688_o().func_76218_k() && var6.func_149686_d();
         } else {
            return p_147445_4_;
         }
      } else {
         return p_147445_4_;
      }
   }

   public void func_72966_v() {
      int var1 = this.func_72967_a(1.0F);
      if(var1 != this.field_73008_k) {
         this.field_73008_k = var1;
      }

   }

   public void func_72891_a(boolean p_72891_1_, boolean p_72891_2_) {
      this.field_72985_G = p_72891_1_;
      this.field_72992_H = p_72891_2_;
   }

   public void func_72835_b() {
      this.func_72979_l();
   }

   private void func_72947_a() {
      if(this.field_72986_A.func_76059_o()) {
         this.field_73004_o = 1.0F;
         if(this.field_72986_A.func_76061_m()) {
            this.field_73017_q = 1.0F;
         }
      }

   }

   protected void func_72979_l() {
      if(!this.field_73011_w.field_76576_e) {
         if(!this.field_72995_K) {
            int var1 = this.field_72986_A.func_76071_n();
            if(var1 <= 0) {
               if(this.field_72986_A.func_76061_m()) {
                  this.field_72986_A.func_76090_f(this.field_73012_v.nextInt(12000) + 3600);
               } else {
                  this.field_72986_A.func_76090_f(this.field_73012_v.nextInt(168000) + 12000);
               }
            } else {
               --var1;
               this.field_72986_A.func_76090_f(var1);
               if(var1 <= 0) {
                  this.field_72986_A.func_76069_a(!this.field_72986_A.func_76061_m());
               }
            }

            this.field_73018_p = this.field_73017_q;
            if(this.field_72986_A.func_76061_m()) {
               this.field_73017_q = (float)((double)this.field_73017_q + 0.01D);
            } else {
               this.field_73017_q = (float)((double)this.field_73017_q - 0.01D);
            }

            this.field_73017_q = MathHelper.func_76131_a(this.field_73017_q, 0.0F, 1.0F);
            int var2 = this.field_72986_A.func_76083_p();
            if(var2 <= 0) {
               if(this.field_72986_A.func_76059_o()) {
                  this.field_72986_A.func_76080_g(this.field_73012_v.nextInt(12000) + 12000);
               } else {
                  this.field_72986_A.func_76080_g(this.field_73012_v.nextInt(168000) + 12000);
               }
            } else {
               --var2;
               this.field_72986_A.func_76080_g(var2);
               if(var2 <= 0) {
                  this.field_72986_A.func_76084_b(!this.field_72986_A.func_76059_o());
               }
            }

            this.field_73003_n = this.field_73004_o;
            if(this.field_72986_A.func_76059_o()) {
               this.field_73004_o = (float)((double)this.field_73004_o + 0.01D);
            } else {
               this.field_73004_o = (float)((double)this.field_73004_o - 0.01D);
            }

            this.field_73004_o = MathHelper.func_76131_a(this.field_73004_o, 0.0F, 1.0F);
         }
      }
   }

   protected void func_72903_x() {
      this.field_72993_I.clear();
      this.field_72984_F.func_76320_a("buildList");

      int var1;
      EntityPlayer var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < this.field_73010_i.size(); ++var1) {
         var2 = (EntityPlayer)this.field_73010_i.get(var1);
         var3 = MathHelper.func_76128_c(var2.field_70165_t / 16.0D);
         var4 = MathHelper.func_76128_c(var2.field_70161_v / 16.0D);
         var5 = this.func_152379_p();

         for(int var6 = -var5; var6 <= var5; ++var6) {
            for(int var7 = -var5; var7 <= var5; ++var7) {
               this.field_72993_I.add(new ChunkCoordIntPair(var6 + var3, var7 + var4));
            }
         }
      }

      this.field_72984_F.func_76319_b();
      if(this.field_72990_M > 0) {
         --this.field_72990_M;
      }

      this.field_72984_F.func_76320_a("playerCheckLight");
      if(!this.field_73010_i.isEmpty()) {
         var1 = this.field_73012_v.nextInt(this.field_73010_i.size());
         var2 = (EntityPlayer)this.field_73010_i.get(var1);
         var3 = MathHelper.func_76128_c(var2.field_70165_t) + this.field_73012_v.nextInt(11) - 5;
         var4 = MathHelper.func_76128_c(var2.field_70163_u) + this.field_73012_v.nextInt(11) - 5;
         var5 = MathHelper.func_76128_c(var2.field_70161_v) + this.field_73012_v.nextInt(11) - 5;
         this.func_147451_t(var3, var4, var5);
      }

      this.field_72984_F.func_76319_b();
   }

   protected abstract int func_152379_p();

   protected void func_147467_a(int p_147467_1_, int p_147467_2_, Chunk p_147467_3_) {
      this.field_72984_F.func_76318_c("moodSound");
      if(this.field_72990_M == 0 && !this.field_72995_K) {
         this.field_73005_l = this.field_73005_l * 3 + 1013904223;
         int var4 = this.field_73005_l >> 2;
         int var5 = var4 & 15;
         int var6 = var4 >> 8 & 15;
         int var7 = var4 >> 16 & 255;
         Block var8 = p_147467_3_.func_150810_a(var5, var7, var6);
         var5 += p_147467_1_;
         var6 += p_147467_2_;
         if(var8.func_149688_o() == Material.field_151579_a && this.func_72883_k(var5, var7, var6) <= this.field_73012_v.nextInt(8) && this.func_72972_b(EnumSkyBlock.Sky, var5, var7, var6) <= 0) {
            EntityPlayer var9 = this.func_72977_a((double)var5 + 0.5D, (double)var7 + 0.5D, (double)var6 + 0.5D, 8.0D);
            if(var9 != null && var9.func_70092_e((double)var5 + 0.5D, (double)var7 + 0.5D, (double)var6 + 0.5D) > 4.0D) {
               this.func_72908_a((double)var5 + 0.5D, (double)var7 + 0.5D, (double)var6 + 0.5D, "ambient.cave.cave", 0.7F, 0.8F + this.field_73012_v.nextFloat() * 0.2F);
               this.field_72990_M = this.field_73012_v.nextInt(12000) + 6000;
            }
         }
      }

      this.field_72984_F.func_76318_c("checkLight");
      p_147467_3_.func_76594_o();
   }

   protected void func_147456_g() {
      this.func_72903_x();
   }

   public boolean func_72884_u(int p_72884_1_, int p_72884_2_, int p_72884_3_) {
      return this.func_72834_c(p_72884_1_, p_72884_2_, p_72884_3_, false);
   }

   public boolean func_72850_v(int p_72850_1_, int p_72850_2_, int p_72850_3_) {
      return this.func_72834_c(p_72850_1_, p_72850_2_, p_72850_3_, true);
   }

   public boolean func_72834_c(int p_72834_1_, int p_72834_2_, int p_72834_3_, boolean p_72834_4_) {
      BiomeGenBase var5 = this.func_72807_a(p_72834_1_, p_72834_3_);
      float var6 = var5.func_150564_a(p_72834_1_, p_72834_2_, p_72834_3_);
      if(var6 > 0.15F) {
         return false;
      } else {
         if(p_72834_2_ >= 0 && p_72834_2_ < 256 && this.func_72972_b(EnumSkyBlock.Block, p_72834_1_, p_72834_2_, p_72834_3_) < 10) {
            Block var7 = this.func_147439_a(p_72834_1_, p_72834_2_, p_72834_3_);
            if((var7 == Blocks.field_150355_j || var7 == Blocks.field_150358_i) && this.func_72805_g(p_72834_1_, p_72834_2_, p_72834_3_) == 0) {
               if(!p_72834_4_) {
                  return true;
               }

               boolean var8 = true;
               if(var8 && this.func_147439_a(p_72834_1_ - 1, p_72834_2_, p_72834_3_).func_149688_o() != Material.field_151586_h) {
                  var8 = false;
               }

               if(var8 && this.func_147439_a(p_72834_1_ + 1, p_72834_2_, p_72834_3_).func_149688_o() != Material.field_151586_h) {
                  var8 = false;
               }

               if(var8 && this.func_147439_a(p_72834_1_, p_72834_2_, p_72834_3_ - 1).func_149688_o() != Material.field_151586_h) {
                  var8 = false;
               }

               if(var8 && this.func_147439_a(p_72834_1_, p_72834_2_, p_72834_3_ + 1).func_149688_o() != Material.field_151586_h) {
                  var8 = false;
               }

               if(!var8) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   public boolean func_147478_e(int p_147478_1_, int p_147478_2_, int p_147478_3_, boolean p_147478_4_) {
      BiomeGenBase var5 = this.func_72807_a(p_147478_1_, p_147478_3_);
      float var6 = var5.func_150564_a(p_147478_1_, p_147478_2_, p_147478_3_);
      if(var6 > 0.15F) {
         return false;
      } else if(!p_147478_4_) {
         return true;
      } else {
         if(p_147478_2_ >= 0 && p_147478_2_ < 256 && this.func_72972_b(EnumSkyBlock.Block, p_147478_1_, p_147478_2_, p_147478_3_) < 10) {
            Block var7 = this.func_147439_a(p_147478_1_, p_147478_2_, p_147478_3_);
            if(var7.func_149688_o() == Material.field_151579_a && Blocks.field_150431_aC.func_149742_c(this, p_147478_1_, p_147478_2_, p_147478_3_)) {
               return true;
            }
         }

         return false;
      }
   }

   public boolean func_147451_t(int p_147451_1_, int p_147451_2_, int p_147451_3_) {
      boolean var4 = false;
      if(!this.field_73011_w.field_76576_e) {
         var4 |= this.func_147463_c(EnumSkyBlock.Sky, p_147451_1_, p_147451_2_, p_147451_3_);
      }

      var4 |= this.func_147463_c(EnumSkyBlock.Block, p_147451_1_, p_147451_2_, p_147451_3_);
      return var4;
   }

   private int func_98179_a(int p_98179_1_, int p_98179_2_, int p_98179_3_, EnumSkyBlock p_98179_4_) {
      if(p_98179_4_ == EnumSkyBlock.Sky && this.func_72937_j(p_98179_1_, p_98179_2_, p_98179_3_)) {
         return 15;
      } else {
         Block var5 = this.func_147439_a(p_98179_1_, p_98179_2_, p_98179_3_);
         int var6 = p_98179_4_ == EnumSkyBlock.Sky?0:var5.func_149750_m();
         int var7 = var5.func_149717_k();
         if(var7 >= 15 && var5.func_149750_m() > 0) {
            var7 = 1;
         }

         if(var7 < 1) {
            var7 = 1;
         }

         if(var7 >= 15) {
            return 0;
         } else if(var6 >= 14) {
            return var6;
         } else {
            for(int var8 = 0; var8 < 6; ++var8) {
               int var9 = p_98179_1_ + Facing.field_71586_b[var8];
               int var10 = p_98179_2_ + Facing.field_71587_c[var8];
               int var11 = p_98179_3_ + Facing.field_71585_d[var8];
               int var12 = this.func_72972_b(p_98179_4_, var9, var10, var11) - var7;
               if(var12 > var6) {
                  var6 = var12;
               }

               if(var6 >= 14) {
                  return var6;
               }
            }

            return var6;
         }
      }
   }

   public boolean func_147463_c(EnumSkyBlock p_147463_1_, int p_147463_2_, int p_147463_3_, int p_147463_4_) {
      if(!this.func_72873_a(p_147463_2_, p_147463_3_, p_147463_4_, 17)) {
         return false;
      } else {
         int var5 = 0;
         int var6 = 0;
         this.field_72984_F.func_76320_a("getBrightness");
         int var7 = this.func_72972_b(p_147463_1_, p_147463_2_, p_147463_3_, p_147463_4_);
         int var8 = this.func_98179_a(p_147463_2_, p_147463_3_, p_147463_4_, p_147463_1_);
         int var9;
         int var10;
         int var11;
         int var12;
         int var13;
         int var14;
         int var15;
         int var16;
         int var17;
         if(var8 > var7) {
            this.field_72994_J[var6++] = 133152;
         } else if(var8 < var7) {
            this.field_72994_J[var6++] = 133152 | var7 << 18;

            while(var5 < var6) {
               var9 = this.field_72994_J[var5++];
               var10 = (var9 & 63) - 32 + p_147463_2_;
               var11 = (var9 >> 6 & 63) - 32 + p_147463_3_;
               var12 = (var9 >> 12 & 63) - 32 + p_147463_4_;
               var13 = var9 >> 18 & 15;
               var14 = this.func_72972_b(p_147463_1_, var10, var11, var12);
               if(var14 == var13) {
                  this.func_72915_b(p_147463_1_, var10, var11, var12, 0);
                  if(var13 > 0) {
                     var15 = MathHelper.func_76130_a(var10 - p_147463_2_);
                     var16 = MathHelper.func_76130_a(var11 - p_147463_3_);
                     var17 = MathHelper.func_76130_a(var12 - p_147463_4_);
                     if(var15 + var16 + var17 < 17) {
                        for(int var18 = 0; var18 < 6; ++var18) {
                           int var19 = var10 + Facing.field_71586_b[var18];
                           int var20 = var11 + Facing.field_71587_c[var18];
                           int var21 = var12 + Facing.field_71585_d[var18];
                           int var22 = Math.max(1, this.func_147439_a(var19, var20, var21).func_149717_k());
                           var14 = this.func_72972_b(p_147463_1_, var19, var20, var21);
                           if(var14 == var13 - var22 && var6 < this.field_72994_J.length) {
                              this.field_72994_J[var6++] = var19 - p_147463_2_ + 32 | var20 - p_147463_3_ + 32 << 6 | var21 - p_147463_4_ + 32 << 12 | var13 - var22 << 18;
                           }
                        }
                     }
                  }
               }
            }

            var5 = 0;
         }

         this.field_72984_F.func_76319_b();
         this.field_72984_F.func_76320_a("checkedPosition < toCheckCount");

         while(var5 < var6) {
            var9 = this.field_72994_J[var5++];
            var10 = (var9 & 63) - 32 + p_147463_2_;
            var11 = (var9 >> 6 & 63) - 32 + p_147463_3_;
            var12 = (var9 >> 12 & 63) - 32 + p_147463_4_;
            var13 = this.func_72972_b(p_147463_1_, var10, var11, var12);
            var14 = this.func_98179_a(var10, var11, var12, p_147463_1_);
            if(var14 != var13) {
               this.func_72915_b(p_147463_1_, var10, var11, var12, var14);
               if(var14 > var13) {
                  var15 = Math.abs(var10 - p_147463_2_);
                  var16 = Math.abs(var11 - p_147463_3_);
                  var17 = Math.abs(var12 - p_147463_4_);
                  boolean var23 = var6 < this.field_72994_J.length - 6;
                  if(var15 + var16 + var17 < 17 && var23) {
                     if(this.func_72972_b(p_147463_1_, var10 - 1, var11, var12) < var14) {
                        this.field_72994_J[var6++] = var10 - 1 - p_147463_2_ + 32 + (var11 - p_147463_3_ + 32 << 6) + (var12 - p_147463_4_ + 32 << 12);
                     }

                     if(this.func_72972_b(p_147463_1_, var10 + 1, var11, var12) < var14) {
                        this.field_72994_J[var6++] = var10 + 1 - p_147463_2_ + 32 + (var11 - p_147463_3_ + 32 << 6) + (var12 - p_147463_4_ + 32 << 12);
                     }

                     if(this.func_72972_b(p_147463_1_, var10, var11 - 1, var12) < var14) {
                        this.field_72994_J[var6++] = var10 - p_147463_2_ + 32 + (var11 - 1 - p_147463_3_ + 32 << 6) + (var12 - p_147463_4_ + 32 << 12);
                     }

                     if(this.func_72972_b(p_147463_1_, var10, var11 + 1, var12) < var14) {
                        this.field_72994_J[var6++] = var10 - p_147463_2_ + 32 + (var11 + 1 - p_147463_3_ + 32 << 6) + (var12 - p_147463_4_ + 32 << 12);
                     }

                     if(this.func_72972_b(p_147463_1_, var10, var11, var12 - 1) < var14) {
                        this.field_72994_J[var6++] = var10 - p_147463_2_ + 32 + (var11 - p_147463_3_ + 32 << 6) + (var12 - 1 - p_147463_4_ + 32 << 12);
                     }

                     if(this.func_72972_b(p_147463_1_, var10, var11, var12 + 1) < var14) {
                        this.field_72994_J[var6++] = var10 - p_147463_2_ + 32 + (var11 - p_147463_3_ + 32 << 6) + (var12 + 1 - p_147463_4_ + 32 << 12);
                     }
                  }
               }
            }
         }

         this.field_72984_F.func_76319_b();
         return true;
      }
   }

   public boolean func_72955_a(boolean p_72955_1_) {
      return false;
   }

   public List func_72920_a(Chunk p_72920_1_, boolean p_72920_2_) {
      return null;
   }

   public List func_72839_b(Entity p_72839_1_, AxisAlignedBB p_72839_2_) {
      return this.func_94576_a(p_72839_1_, p_72839_2_, (IEntitySelector)null);
   }

   public List func_94576_a(Entity p_94576_1_, AxisAlignedBB p_94576_2_, IEntitySelector p_94576_3_) {
      ArrayList var4 = new ArrayList();
      int var5 = MathHelper.func_76128_c((p_94576_2_.field_72340_a - 2.0D) / 16.0D);
      int var6 = MathHelper.func_76128_c((p_94576_2_.field_72336_d + 2.0D) / 16.0D);
      int var7 = MathHelper.func_76128_c((p_94576_2_.field_72339_c - 2.0D) / 16.0D);
      int var8 = MathHelper.func_76128_c((p_94576_2_.field_72334_f + 2.0D) / 16.0D);

      for(int var9 = var5; var9 <= var6; ++var9) {
         for(int var10 = var7; var10 <= var8; ++var10) {
            if(this.func_72916_c(var9, var10)) {
               this.func_72964_e(var9, var10).func_76588_a(p_94576_1_, p_94576_2_, var4, p_94576_3_);
            }
         }
      }

      return var4;
   }

   public List func_72872_a(Class p_72872_1_, AxisAlignedBB p_72872_2_) {
      return this.func_82733_a(p_72872_1_, p_72872_2_, (IEntitySelector)null);
   }

   public List func_82733_a(Class p_82733_1_, AxisAlignedBB p_82733_2_, IEntitySelector p_82733_3_) {
      int var4 = MathHelper.func_76128_c((p_82733_2_.field_72340_a - 2.0D) / 16.0D);
      int var5 = MathHelper.func_76128_c((p_82733_2_.field_72336_d + 2.0D) / 16.0D);
      int var6 = MathHelper.func_76128_c((p_82733_2_.field_72339_c - 2.0D) / 16.0D);
      int var7 = MathHelper.func_76128_c((p_82733_2_.field_72334_f + 2.0D) / 16.0D);
      ArrayList var8 = new ArrayList();

      for(int var9 = var4; var9 <= var5; ++var9) {
         for(int var10 = var6; var10 <= var7; ++var10) {
            if(this.func_72916_c(var9, var10)) {
               this.func_72964_e(var9, var10).func_76618_a(p_82733_1_, p_82733_2_, var8, p_82733_3_);
            }
         }
      }

      return var8;
   }

   public Entity func_72857_a(Class p_72857_1_, AxisAlignedBB p_72857_2_, Entity p_72857_3_) {
      List var4 = this.func_72872_a(p_72857_1_, p_72857_2_);
      Entity var5 = null;
      double var6 = Double.MAX_VALUE;

      for(int var8 = 0; var8 < var4.size(); ++var8) {
         Entity var9 = (Entity)var4.get(var8);
         if(var9 != p_72857_3_) {
            double var10 = p_72857_3_.func_70068_e(var9);
            if(var10 <= var6) {
               var5 = var9;
               var6 = var10;
            }
         }
      }

      return var5;
   }

   public abstract Entity func_73045_a(int var1);

   public List func_72910_y() {
      return this.field_72996_f;
   }

   public void func_147476_b(int p_147476_1_, int p_147476_2_, int p_147476_3_, TileEntity p_147476_4_) {
      if(this.func_72899_e(p_147476_1_, p_147476_2_, p_147476_3_)) {
         this.func_72938_d(p_147476_1_, p_147476_3_).func_76630_e();
      }

   }

   public int func_72907_a(Class p_72907_1_) {
      int var2 = 0;

      for(int var3 = 0; var3 < this.field_72996_f.size(); ++var3) {
         Entity var4 = (Entity)this.field_72996_f.get(var3);
         if((!(var4 instanceof EntityLiving) || !((EntityLiving)var4).func_104002_bU()) && p_72907_1_.isAssignableFrom(var4.getClass())) {
            ++var2;
         }
      }

      return var2;
   }

   public void func_72868_a(List p_72868_1_) {
      this.field_72996_f.addAll(p_72868_1_);

      for(int var2 = 0; var2 < p_72868_1_.size(); ++var2) {
         this.func_72923_a((Entity)p_72868_1_.get(var2));
      }

   }

   public void func_72828_b(List p_72828_1_) {
      this.field_72997_g.addAll(p_72828_1_);
   }

   public boolean func_147472_a(Block p_147472_1_, int p_147472_2_, int p_147472_3_, int p_147472_4_, boolean p_147472_5_, int p_147472_6_, Entity p_147472_7_, ItemStack p_147472_8_) {
      Block var9 = this.func_147439_a(p_147472_2_, p_147472_3_, p_147472_4_);
      AxisAlignedBB var10 = p_147472_5_?null:p_147472_1_.func_149668_a(this, p_147472_2_, p_147472_3_, p_147472_4_);
      return var10 != null && !this.func_72917_a(var10, p_147472_7_)?false:(var9.func_149688_o() == Material.field_151594_q && p_147472_1_ == Blocks.field_150467_bQ?true:var9.func_149688_o().func_76222_j() && p_147472_1_.func_149705_a(this, p_147472_2_, p_147472_3_, p_147472_4_, p_147472_6_, p_147472_8_));
   }

   public PathEntity func_72865_a(Entity p_72865_1_, Entity p_72865_2_, float p_72865_3_, boolean p_72865_4_, boolean p_72865_5_, boolean p_72865_6_, boolean p_72865_7_) {
      this.field_72984_F.func_76320_a("pathfind");
      int var8 = MathHelper.func_76128_c(p_72865_1_.field_70165_t);
      int var9 = MathHelper.func_76128_c(p_72865_1_.field_70163_u + 1.0D);
      int var10 = MathHelper.func_76128_c(p_72865_1_.field_70161_v);
      int var11 = (int)(p_72865_3_ + 16.0F);
      int var12 = var8 - var11;
      int var13 = var9 - var11;
      int var14 = var10 - var11;
      int var15 = var8 + var11;
      int var16 = var9 + var11;
      int var17 = var10 + var11;
      ChunkCache var18 = new ChunkCache(this, var12, var13, var14, var15, var16, var17, 0);
      PathEntity var19 = (new PathFinder(var18, p_72865_4_, p_72865_5_, p_72865_6_, p_72865_7_)).func_75856_a(p_72865_1_, p_72865_2_, p_72865_3_);
      this.field_72984_F.func_76319_b();
      return var19;
   }

   public PathEntity func_72844_a(Entity p_72844_1_, int p_72844_2_, int p_72844_3_, int p_72844_4_, float p_72844_5_, boolean p_72844_6_, boolean p_72844_7_, boolean p_72844_8_, boolean p_72844_9_) {
      this.field_72984_F.func_76320_a("pathfind");
      int var10 = MathHelper.func_76128_c(p_72844_1_.field_70165_t);
      int var11 = MathHelper.func_76128_c(p_72844_1_.field_70163_u);
      int var12 = MathHelper.func_76128_c(p_72844_1_.field_70161_v);
      int var13 = (int)(p_72844_5_ + 8.0F);
      int var14 = var10 - var13;
      int var15 = var11 - var13;
      int var16 = var12 - var13;
      int var17 = var10 + var13;
      int var18 = var11 + var13;
      int var19 = var12 + var13;
      ChunkCache var20 = new ChunkCache(this, var14, var15, var16, var17, var18, var19, 0);
      PathEntity var21 = (new PathFinder(var20, p_72844_6_, p_72844_7_, p_72844_8_, p_72844_9_)).func_75859_a(p_72844_1_, p_72844_2_, p_72844_3_, p_72844_4_, p_72844_5_);
      this.field_72984_F.func_76319_b();
      return var21;
   }

   public int func_72879_k(int p_72879_1_, int p_72879_2_, int p_72879_3_, int p_72879_4_) {
      return this.func_147439_a(p_72879_1_, p_72879_2_, p_72879_3_).func_149748_c(this, p_72879_1_, p_72879_2_, p_72879_3_, p_72879_4_);
   }

   public int func_94577_B(int p_94577_1_, int p_94577_2_, int p_94577_3_) {
      byte var4 = 0;
      int var5 = Math.max(var4, this.func_72879_k(p_94577_1_, p_94577_2_ - 1, p_94577_3_, 0));
      if(var5 >= 15) {
         return var5;
      } else {
         var5 = Math.max(var5, this.func_72879_k(p_94577_1_, p_94577_2_ + 1, p_94577_3_, 1));
         if(var5 >= 15) {
            return var5;
         } else {
            var5 = Math.max(var5, this.func_72879_k(p_94577_1_, p_94577_2_, p_94577_3_ - 1, 2));
            if(var5 >= 15) {
               return var5;
            } else {
               var5 = Math.max(var5, this.func_72879_k(p_94577_1_, p_94577_2_, p_94577_3_ + 1, 3));
               if(var5 >= 15) {
                  return var5;
               } else {
                  var5 = Math.max(var5, this.func_72879_k(p_94577_1_ - 1, p_94577_2_, p_94577_3_, 4));
                  if(var5 >= 15) {
                     return var5;
                  } else {
                     var5 = Math.max(var5, this.func_72879_k(p_94577_1_ + 1, p_94577_2_, p_94577_3_, 5));
                     return var5 >= 15?var5:var5;
                  }
               }
            }
         }
      }
   }

   public boolean func_94574_k(int p_94574_1_, int p_94574_2_, int p_94574_3_, int p_94574_4_) {
      return this.func_72878_l(p_94574_1_, p_94574_2_, p_94574_3_, p_94574_4_) > 0;
   }

   public int func_72878_l(int p_72878_1_, int p_72878_2_, int p_72878_3_, int p_72878_4_) {
      return this.func_147439_a(p_72878_1_, p_72878_2_, p_72878_3_).func_149721_r()?this.func_94577_B(p_72878_1_, p_72878_2_, p_72878_3_):this.func_147439_a(p_72878_1_, p_72878_2_, p_72878_3_).func_149709_b(this, p_72878_1_, p_72878_2_, p_72878_3_, p_72878_4_);
   }

   public boolean func_72864_z(int p_72864_1_, int p_72864_2_, int p_72864_3_) {
      return this.func_72878_l(p_72864_1_, p_72864_2_ - 1, p_72864_3_, 0) > 0?true:(this.func_72878_l(p_72864_1_, p_72864_2_ + 1, p_72864_3_, 1) > 0?true:(this.func_72878_l(p_72864_1_, p_72864_2_, p_72864_3_ - 1, 2) > 0?true:(this.func_72878_l(p_72864_1_, p_72864_2_, p_72864_3_ + 1, 3) > 0?true:(this.func_72878_l(p_72864_1_ - 1, p_72864_2_, p_72864_3_, 4) > 0?true:this.func_72878_l(p_72864_1_ + 1, p_72864_2_, p_72864_3_, 5) > 0))));
   }

   public int func_94572_D(int p_94572_1_, int p_94572_2_, int p_94572_3_) {
      int var4 = 0;

      for(int var5 = 0; var5 < 6; ++var5) {
         int var6 = this.func_72878_l(p_94572_1_ + Facing.field_71586_b[var5], p_94572_2_ + Facing.field_71587_c[var5], p_94572_3_ + Facing.field_71585_d[var5], var5);
         if(var6 >= 15) {
            return 15;
         }

         if(var6 > var4) {
            var4 = var6;
         }
      }

      return var4;
   }

   public EntityPlayer func_72890_a(Entity p_72890_1_, double p_72890_2_) {
      return this.func_72977_a(p_72890_1_.field_70165_t, p_72890_1_.field_70163_u, p_72890_1_.field_70161_v, p_72890_2_);
   }

   public EntityPlayer func_72977_a(double p_72977_1_, double p_72977_3_, double p_72977_5_, double p_72977_7_) {
      double var9 = -1.0D;
      EntityPlayer var11 = null;

      for(int var12 = 0; var12 < this.field_73010_i.size(); ++var12) {
         EntityPlayer var13 = (EntityPlayer)this.field_73010_i.get(var12);
         double var14 = var13.func_70092_e(p_72977_1_, p_72977_3_, p_72977_5_);
         if((p_72977_7_ < 0.0D || var14 < p_72977_7_ * p_72977_7_) && (var9 == -1.0D || var14 < var9)) {
            var9 = var14;
            var11 = var13;
         }
      }

      return var11;
   }

   public EntityPlayer func_72856_b(Entity p_72856_1_, double p_72856_2_) {
      return this.func_72846_b(p_72856_1_.field_70165_t, p_72856_1_.field_70163_u, p_72856_1_.field_70161_v, p_72856_2_);
   }

   public EntityPlayer func_72846_b(double p_72846_1_, double p_72846_3_, double p_72846_5_, double p_72846_7_) {
      double var9 = -1.0D;
      EntityPlayer var11 = null;

      for(int var12 = 0; var12 < this.field_73010_i.size(); ++var12) {
         EntityPlayer var13 = (EntityPlayer)this.field_73010_i.get(var12);
         if(!var13.field_71075_bZ.field_75102_a && var13.func_70089_S()) {
            double var14 = var13.func_70092_e(p_72846_1_, p_72846_3_, p_72846_5_);
            double var16 = p_72846_7_;
            if(var13.func_70093_af()) {
               var16 = p_72846_7_ * 0.800000011920929D;
            }

            if(var13.func_82150_aj()) {
               float var18 = var13.func_82243_bO();
               if(var18 < 0.1F) {
                  var18 = 0.1F;
               }

               var16 *= (double)(0.7F * var18);
            }

            if((p_72846_7_ < 0.0D || var14 < var16 * var16) && (var9 == -1.0D || var14 < var9)) {
               var9 = var14;
               var11 = var13;
            }
         }
      }

      return var11;
   }

   public EntityPlayer func_72924_a(String p_72924_1_) {
      for(int var2 = 0; var2 < this.field_73010_i.size(); ++var2) {
         EntityPlayer var3 = (EntityPlayer)this.field_73010_i.get(var2);
         if(p_72924_1_.equals(var3.func_70005_c_())) {
            return var3;
         }
      }

      return null;
   }

   public EntityPlayer func_152378_a(UUID p_152378_1_) {
      for(int var2 = 0; var2 < this.field_73010_i.size(); ++var2) {
         EntityPlayer var3 = (EntityPlayer)this.field_73010_i.get(var2);
         if(p_152378_1_.equals(var3.func_110124_au())) {
            return var3;
         }
      }

      return null;
   }

   public void func_72882_A() {}

   public void func_72906_B() throws MinecraftException {
      this.field_73019_z.func_75762_c();
   }

   public void func_82738_a(long p_82738_1_) {
      this.field_72986_A.func_82572_b(p_82738_1_);
   }

   public long func_72905_C() {
      return this.field_72986_A.func_76063_b();
   }

   public long func_82737_E() {
      return this.field_72986_A.func_82573_f();
   }

   public long func_72820_D() {
      return this.field_72986_A.func_76073_f();
   }

   public void func_72877_b(long p_72877_1_) {
      this.field_72986_A.func_76068_b(p_72877_1_);
   }

   public ChunkCoordinates func_72861_E() {
      return new ChunkCoordinates(this.field_72986_A.func_76079_c(), this.field_72986_A.func_76075_d(), this.field_72986_A.func_76074_e());
   }

   public void func_72950_A(int p_72950_1_, int p_72950_2_, int p_72950_3_) {
      this.field_72986_A.func_76081_a(p_72950_1_, p_72950_2_, p_72950_3_);
   }

   public void func_72897_h(Entity p_72897_1_) {
      int var2 = MathHelper.func_76128_c(p_72897_1_.field_70165_t / 16.0D);
      int var3 = MathHelper.func_76128_c(p_72897_1_.field_70161_v / 16.0D);
      byte var4 = 2;

      for(int var5 = var2 - var4; var5 <= var2 + var4; ++var5) {
         for(int var6 = var3 - var4; var6 <= var3 + var4; ++var6) {
            this.func_72964_e(var5, var6);
         }
      }

      if(!this.field_72996_f.contains(p_72897_1_)) {
         this.field_72996_f.add(p_72897_1_);
      }

   }

   public boolean func_72962_a(EntityPlayer p_72962_1_, int p_72962_2_, int p_72962_3_, int p_72962_4_) {
      return true;
   }

   public void func_72960_a(Entity p_72960_1_, byte p_72960_2_) {}

   public IChunkProvider func_72863_F() {
      return this.field_73020_y;
   }

   public void func_147452_c(int p_147452_1_, int p_147452_2_, int p_147452_3_, Block p_147452_4_, int p_147452_5_, int p_147452_6_) {
      p_147452_4_.func_149696_a(this, p_147452_1_, p_147452_2_, p_147452_3_, p_147452_5_, p_147452_6_);
   }

   public ISaveHandler func_72860_G() {
      return this.field_73019_z;
   }

   public WorldInfo func_72912_H() {
      return this.field_72986_A;
   }

   public GameRules func_82736_K() {
      return this.field_72986_A.func_82574_x();
   }

   public void func_72854_c() {}

   public float func_72819_i(float p_72819_1_) {
      return (this.field_73018_p + (this.field_73017_q - this.field_73018_p) * p_72819_1_) * this.func_72867_j(p_72819_1_);
   }

   public void func_147442_i(float p_147442_1_) {
      this.field_73018_p = p_147442_1_;
      this.field_73017_q = p_147442_1_;
   }

   public float func_72867_j(float p_72867_1_) {
      return this.field_73003_n + (this.field_73004_o - this.field_73003_n) * p_72867_1_;
   }

   public void func_72894_k(float p_72894_1_) {
      this.field_73003_n = p_72894_1_;
      this.field_73004_o = p_72894_1_;
   }

   public boolean func_72911_I() {
      return (double)this.func_72819_i(1.0F) > 0.9D;
   }

   public boolean func_72896_J() {
      return (double)this.func_72867_j(1.0F) > 0.2D;
   }

   public boolean func_72951_B(int p_72951_1_, int p_72951_2_, int p_72951_3_) {
      if(!this.func_72896_J()) {
         return false;
      } else if(!this.func_72937_j(p_72951_1_, p_72951_2_, p_72951_3_)) {
         return false;
      } else if(this.func_72874_g(p_72951_1_, p_72951_3_) > p_72951_2_) {
         return false;
      } else {
         BiomeGenBase var4 = this.func_72807_a(p_72951_1_, p_72951_3_);
         return var4.func_76746_c()?false:(this.func_147478_e(p_72951_1_, p_72951_2_, p_72951_3_, false)?false:var4.func_76738_d());
      }
   }

   public boolean func_72958_C(int p_72958_1_, int p_72958_2_, int p_72958_3_) {
      BiomeGenBase var4 = this.func_72807_a(p_72958_1_, p_72958_3_);
      return var4.func_76736_e();
   }

   public void func_72823_a(String p_72823_1_, WorldSavedData p_72823_2_) {
      this.field_72988_C.func_75745_a(p_72823_1_, p_72823_2_);
   }

   public WorldSavedData func_72943_a(Class p_72943_1_, String p_72943_2_) {
      return this.field_72988_C.func_75742_a(p_72943_1_, p_72943_2_);
   }

   public int func_72841_b(String p_72841_1_) {
      return this.field_72988_C.func_75743_a(p_72841_1_);
   }

   public void func_82739_e(int p_82739_1_, int p_82739_2_, int p_82739_3_, int p_82739_4_, int p_82739_5_) {
      for(int var6 = 0; var6 < this.field_73021_x.size(); ++var6) {
         ((IWorldAccess)this.field_73021_x.get(var6)).func_82746_a(p_82739_1_, p_82739_2_, p_82739_3_, p_82739_4_, p_82739_5_);
      }

   }

   public void func_72926_e(int p_72926_1_, int p_72926_2_, int p_72926_3_, int p_72926_4_, int p_72926_5_) {
      this.func_72889_a((EntityPlayer)null, p_72926_1_, p_72926_2_, p_72926_3_, p_72926_4_, p_72926_5_);
   }

   public void func_72889_a(EntityPlayer p_72889_1_, int p_72889_2_, int p_72889_3_, int p_72889_4_, int p_72889_5_, int p_72889_6_) {
      try {
         for(int var7 = 0; var7 < this.field_73021_x.size(); ++var7) {
            ((IWorldAccess)this.field_73021_x.get(var7)).func_72706_a(p_72889_1_, p_72889_2_, p_72889_3_, p_72889_4_, p_72889_5_, p_72889_6_);
         }

      } catch (Throwable var10) {
         CrashReport var8 = CrashReport.func_85055_a(var10, "Playing level event");
         CrashReportCategory var9 = var8.func_85058_a("Level event being played");
         var9.func_71507_a("Block coordinates", CrashReportCategory.func_85071_a(p_72889_3_, p_72889_4_, p_72889_5_));
         var9.func_71507_a("Event source", p_72889_1_);
         var9.func_71507_a("Event type", Integer.valueOf(p_72889_2_));
         var9.func_71507_a("Event data", Integer.valueOf(p_72889_6_));
         throw new ReportedException(var8);
      }
   }

   public int func_72800_K() {
      return 256;
   }

   public int func_72940_L() {
      return this.field_73011_w.field_76576_e?128:256;
   }

   public Random func_72843_D(int p_72843_1_, int p_72843_2_, int p_72843_3_) {
      long var4 = (long)p_72843_1_ * 341873128712L + (long)p_72843_2_ * 132897987541L + this.func_72912_H().func_76063_b() + (long)p_72843_3_;
      this.field_73012_v.setSeed(var4);
      return this.field_73012_v;
   }

   public ChunkPosition func_147440_b(String p_147440_1_, int p_147440_2_, int p_147440_3_, int p_147440_4_) {
      return this.func_72863_F().func_147416_a(this, p_147440_1_, p_147440_2_, p_147440_3_, p_147440_4_);
   }

   public boolean func_72806_N() {
      return false;
   }

   public double func_72919_O() {
      return this.field_72986_A.func_76067_t() == WorldType.field_77138_c?0.0D:63.0D;
   }

   public CrashReportCategory func_72914_a(CrashReport p_72914_1_) {
      CrashReportCategory var2 = p_72914_1_.func_85057_a("Affected level", 1);
      var2.func_71507_a("Level name", this.field_72986_A == null?"????":this.field_72986_A.func_76065_j());
      var2.func_71500_a("All players", new Callable() {

         private static final String __OBFID = "CL_00000143";

         public String call() {
            return World.this.field_73010_i.size() + " total; " + World.this.field_73010_i.toString();
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });
      var2.func_71500_a("Chunk stats", new Callable() {

         private static final String __OBFID = "CL_00000144";

         public String call() {
            return World.this.field_73020_y.func_73148_d();
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });

      try {
         this.field_72986_A.func_85118_a(var2);
      } catch (Throwable var4) {
         var2.func_71499_a("Level Data Unobtainable", var4);
      }

      return var2;
   }

   public void func_147443_d(int p_147443_1_, int p_147443_2_, int p_147443_3_, int p_147443_4_, int p_147443_5_) {
      for(int var6 = 0; var6 < this.field_73021_x.size(); ++var6) {
         IWorldAccess var7 = (IWorldAccess)this.field_73021_x.get(var6);
         var7.func_147587_b(p_147443_1_, p_147443_2_, p_147443_3_, p_147443_4_, p_147443_5_);
      }

   }

   public Calendar func_83015_S() {
      if(this.func_82737_E() % 600L == 0L) {
         this.field_83016_L.setTimeInMillis(MinecraftServer.func_130071_aq());
      }

      return this.field_83016_L;
   }

   public void func_92088_a(double p_92088_1_, double p_92088_3_, double p_92088_5_, double p_92088_7_, double p_92088_9_, double p_92088_11_, NBTTagCompound p_92088_13_) {}

   public Scoreboard func_96441_U() {
      return this.field_96442_D;
   }

   public void func_147453_f(int p_147453_1_, int p_147453_2_, int p_147453_3_, Block p_147453_4_) {
      for(int var5 = 0; var5 < 4; ++var5) {
         int var6 = p_147453_1_ + Direction.field_71583_a[var5];
         int var7 = p_147453_3_ + Direction.field_71581_b[var5];
         Block var8 = this.func_147439_a(var6, p_147453_2_, var7);
         if(Blocks.field_150441_bU.func_149907_e(var8)) {
            var8.func_149695_a(this, var6, p_147453_2_, var7, p_147453_4_);
         } else if(var8.func_149721_r()) {
            var6 += Direction.field_71583_a[var5];
            var7 += Direction.field_71581_b[var5];
            Block var9 = this.func_147439_a(var6, p_147453_2_, var7);
            if(Blocks.field_150441_bU.func_149907_e(var9)) {
               var9.func_149695_a(this, var6, p_147453_2_, var7, p_147453_4_);
            }
         }
      }

   }

   public float func_147462_b(double p_147462_1_, double p_147462_3_, double p_147462_5_) {
      return this.func_147473_B(MathHelper.func_76128_c(p_147462_1_), MathHelper.func_76128_c(p_147462_3_), MathHelper.func_76128_c(p_147462_5_));
   }

   public float func_147473_B(int p_147473_1_, int p_147473_2_, int p_147473_3_) {
      float var4 = 0.0F;
      boolean var5 = this.field_73013_u == EnumDifficulty.HARD;
      if(this.func_72899_e(p_147473_1_, p_147473_2_, p_147473_3_)) {
         float var6 = this.func_130001_d();
         var4 += MathHelper.func_76131_a((float)this.func_72938_d(p_147473_1_, p_147473_3_).field_111204_q / 3600000.0F, 0.0F, 1.0F) * (var5?1.0F:0.75F);
         var4 += var6 * 0.25F;
      }

      if(this.field_73013_u == EnumDifficulty.EASY || this.field_73013_u == EnumDifficulty.PEACEFUL) {
         var4 *= (float)this.field_73013_u.func_151525_a() / 2.0F;
      }

      return MathHelper.func_76131_a(var4, 0.0F, var5?1.5F:1.0F);
   }

   public void func_147450_X() {
      Iterator var1 = this.field_73021_x.iterator();

      while(var1.hasNext()) {
         IWorldAccess var2 = (IWorldAccess)var1.next();
         var2.func_147584_b();
      }

   }
}
