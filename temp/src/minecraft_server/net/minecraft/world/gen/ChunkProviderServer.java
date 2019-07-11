package net.minecraft.world.gen;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.ReportedException;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.EmptyChunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.storage.IChunkLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChunkProviderServer implements IChunkProvider {

   private static final Logger field_147417_b = LogManager.getLogger();
   private Set field_73248_b = Collections.newSetFromMap(new ConcurrentHashMap());
   private Chunk field_73249_c;
   private IChunkProvider field_73246_d;
   private IChunkLoader field_73247_e;
   public boolean field_73250_a = true;
   private LongHashMap field_73244_f = new LongHashMap();
   private List field_73245_g = new ArrayList();
   private WorldServer field_73251_h;
   private static final String __OBFID = "CL_00001436";


   public ChunkProviderServer(WorldServer p_i1520_1_, IChunkLoader p_i1520_2_, IChunkProvider p_i1520_3_) {
      this.field_73249_c = new EmptyChunk(p_i1520_1_, 0, 0);
      this.field_73251_h = p_i1520_1_;
      this.field_73247_e = p_i1520_2_;
      this.field_73246_d = p_i1520_3_;
   }

   public boolean func_73149_a(int p_73149_1_, int p_73149_2_) {
      return this.field_73244_f.func_76161_b(ChunkCoordIntPair.func_77272_a(p_73149_1_, p_73149_2_));
   }

   public List func_152380_a() {
      return this.field_73245_g;
   }

   public void func_73241_b(int p_73241_1_, int p_73241_2_) {
      if(this.field_73251_h.field_73011_w.func_76567_e()) {
         ChunkCoordinates var3 = this.field_73251_h.func_72861_E();
         int var4 = p_73241_1_ * 16 + 8 - var3.field_71574_a;
         int var5 = p_73241_2_ * 16 + 8 - var3.field_71573_c;
         short var6 = 128;
         if(var4 < -var6 || var4 > var6 || var5 < -var6 || var5 > var6) {
            this.field_73248_b.add(Long.valueOf(ChunkCoordIntPair.func_77272_a(p_73241_1_, p_73241_2_)));
         }
      } else {
         this.field_73248_b.add(Long.valueOf(ChunkCoordIntPair.func_77272_a(p_73241_1_, p_73241_2_)));
      }

   }

   public void func_73240_a() {
      Iterator var1 = this.field_73245_g.iterator();

      while(var1.hasNext()) {
         Chunk var2 = (Chunk)var1.next();
         this.func_73241_b(var2.field_76635_g, var2.field_76647_h);
      }

   }

   public Chunk func_73158_c(int p_73158_1_, int p_73158_2_) {
      long var3 = ChunkCoordIntPair.func_77272_a(p_73158_1_, p_73158_2_);
      this.field_73248_b.remove(Long.valueOf(var3));
      Chunk var5 = (Chunk)this.field_73244_f.func_76164_a(var3);
      if(var5 == null) {
         var5 = this.func_73239_e(p_73158_1_, p_73158_2_);
         if(var5 == null) {
            if(this.field_73246_d == null) {
               var5 = this.field_73249_c;
            } else {
               try {
                  var5 = this.field_73246_d.func_73154_d(p_73158_1_, p_73158_2_);
               } catch (Throwable var9) {
                  CrashReport var7 = CrashReport.func_85055_a(var9, "Exception generating new chunk");
                  CrashReportCategory var8 = var7.func_85058_a("Chunk to be generated");
                  var8.func_71507_a("Location", String.format("%d,%d", new Object[]{Integer.valueOf(p_73158_1_), Integer.valueOf(p_73158_2_)}));
                  var8.func_71507_a("Position hash", Long.valueOf(var3));
                  var8.func_71507_a("Generator", this.field_73246_d.func_73148_d());
                  throw new ReportedException(var7);
               }
            }
         }

         this.field_73244_f.func_76163_a(var3, var5);
         this.field_73245_g.add(var5);
         var5.func_76631_c();
         var5.func_76624_a(this, this, p_73158_1_, p_73158_2_);
      }

      return var5;
   }

   public Chunk func_73154_d(int p_73154_1_, int p_73154_2_) {
      Chunk var3 = (Chunk)this.field_73244_f.func_76164_a(ChunkCoordIntPair.func_77272_a(p_73154_1_, p_73154_2_));
      return var3 == null?(!this.field_73251_h.field_72987_B && !this.field_73250_a?this.field_73249_c:this.func_73158_c(p_73154_1_, p_73154_2_)):var3;
   }

   private Chunk func_73239_e(int p_73239_1_, int p_73239_2_) {
      if(this.field_73247_e == null) {
         return null;
      } else {
         try {
            Chunk var3 = this.field_73247_e.func_75815_a(this.field_73251_h, p_73239_1_, p_73239_2_);
            if(var3 != null) {
               var3.field_76641_n = this.field_73251_h.func_82737_E();
               if(this.field_73246_d != null) {
                  this.field_73246_d.func_82695_e(p_73239_1_, p_73239_2_);
               }
            }

            return var3;
         } catch (Exception var4) {
            field_147417_b.error("Couldn\'t load chunk", var4);
            return null;
         }
      }
   }

   private void func_73243_a(Chunk p_73243_1_) {
      if(this.field_73247_e != null) {
         try {
            this.field_73247_e.func_75819_b(this.field_73251_h, p_73243_1_);
         } catch (Exception var3) {
            field_147417_b.error("Couldn\'t save entities", var3);
         }

      }
   }

   private void func_73242_b(Chunk p_73242_1_) {
      if(this.field_73247_e != null) {
         try {
            p_73242_1_.field_76641_n = this.field_73251_h.func_82737_E();
            this.field_73247_e.func_75816_a(this.field_73251_h, p_73242_1_);
         } catch (IOException var3) {
            field_147417_b.error("Couldn\'t save chunk", var3);
         } catch (MinecraftException var4) {
            field_147417_b.error("Couldn\'t save chunk; already in use by another instance of Minecraft?", var4);
         }

      }
   }

   public void func_73153_a(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) {
      Chunk var4 = this.func_73154_d(p_73153_2_, p_73153_3_);
      if(!var4.field_76646_k) {
         var4.func_150809_p();
         if(this.field_73246_d != null) {
            this.field_73246_d.func_73153_a(p_73153_1_, p_73153_2_, p_73153_3_);
            var4.func_76630_e();
         }
      }

   }

   public boolean func_73151_a(boolean p_73151_1_, IProgressUpdate p_73151_2_) {
      int var3 = 0;
      ArrayList var4 = Lists.newArrayList(this.field_73245_g);

      for(int var5 = 0; var5 < var4.size(); ++var5) {
         Chunk var6 = (Chunk)var4.get(var5);
         if(p_73151_1_) {
            this.func_73243_a(var6);
         }

         if(var6.func_76601_a(p_73151_1_)) {
            this.func_73242_b(var6);
            var6.field_76643_l = false;
            ++var3;
            if(var3 == 24 && !p_73151_1_) {
               return false;
            }
         }
      }

      return true;
   }

   public void func_104112_b() {
      if(this.field_73247_e != null) {
         this.field_73247_e.func_75818_b();
      }

   }

   public boolean func_73156_b() {
      if(!this.field_73251_h.field_73058_d) {
         for(int var1 = 0; var1 < 100; ++var1) {
            if(!this.field_73248_b.isEmpty()) {
               Long var2 = (Long)this.field_73248_b.iterator().next();
               Chunk var3 = (Chunk)this.field_73244_f.func_76164_a(var2.longValue());
               if(var3 != null) {
                  var3.func_76623_d();
                  this.func_73242_b(var3);
                  this.func_73243_a(var3);
                  this.field_73245_g.remove(var3);
               }

               this.field_73248_b.remove(var2);
               this.field_73244_f.func_76159_d(var2.longValue());
            }
         }

         if(this.field_73247_e != null) {
            this.field_73247_e.func_75817_a();
         }
      }

      return this.field_73246_d.func_73156_b();
   }

   public boolean func_73157_c() {
      return !this.field_73251_h.field_73058_d;
   }

   public String func_73148_d() {
      return "ServerChunkCache: " + this.field_73244_f.func_76162_a() + " Drop: " + this.field_73248_b.size();
   }

   public List func_73155_a(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_) {
      return this.field_73246_d.func_73155_a(p_73155_1_, p_73155_2_, p_73155_3_, p_73155_4_);
   }

   public ChunkPosition func_147416_a(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_, int p_147416_5_) {
      return this.field_73246_d.func_147416_a(p_147416_1_, p_147416_2_, p_147416_3_, p_147416_4_, p_147416_5_);
   }

   public int func_73152_e() {
      return this.field_73244_f.func_76162_a();
   }

   public void func_82695_e(int p_82695_1_, int p_82695_2_) {}

}
