package net.minecraft.server.management;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S21PacketChunkData;
import net.minecraft.network.play.server.S22PacketMultiBlockChange;
import net.minecraft.network.play.server.S23PacketBlockChange;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlayerManager {

   private static final Logger field_152627_a = LogManager.getLogger();
   private final WorldServer field_72701_a;
   private final List field_72699_b = new ArrayList();
   private final LongHashMap field_72700_c = new LongHashMap();
   private final List field_72697_d = new ArrayList();
   private final List field_111193_e = new ArrayList();
   private int field_72698_e;
   private long field_111192_g;
   private final int[][] field_72696_f = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
   private static final String __OBFID = "CL_00001434";


   public PlayerManager(WorldServer p_i1176_1_) {
      this.field_72701_a = p_i1176_1_;
      this.func_152622_a(p_i1176_1_.func_73046_m().func_71203_ab().func_72395_o());
   }

   public WorldServer func_72688_a() {
      return this.field_72701_a;
   }

   public void func_72693_b() {
      long var1 = this.field_72701_a.func_82737_E();
      int var3;
      PlayerManager.PlayerInstance var4;
      if(var1 - this.field_111192_g > 8000L) {
         this.field_111192_g = var1;

         for(var3 = 0; var3 < this.field_111193_e.size(); ++var3) {
            var4 = (PlayerManager.PlayerInstance)this.field_111193_e.get(var3);
            var4.func_73254_a();
            var4.func_111194_a();
         }
      } else {
         for(var3 = 0; var3 < this.field_72697_d.size(); ++var3) {
            var4 = (PlayerManager.PlayerInstance)this.field_72697_d.get(var3);
            var4.func_73254_a();
         }
      }

      this.field_72697_d.clear();
      if(this.field_72699_b.isEmpty()) {
         WorldProvider var5 = this.field_72701_a.field_73011_w;
         if(!var5.func_76567_e()) {
            this.field_72701_a.field_73059_b.func_73240_a();
         }
      }

   }

   public boolean func_152621_a(int p_152621_1_, int p_152621_2_) {
      long var3 = (long)p_152621_1_ + 2147483647L | (long)p_152621_2_ + 2147483647L << 32;
      return this.field_72700_c.func_76164_a(var3) != null;
   }

   private PlayerManager.PlayerInstance func_72690_a(int p_72690_1_, int p_72690_2_, boolean p_72690_3_) {
      long var4 = (long)p_72690_1_ + 2147483647L | (long)p_72690_2_ + 2147483647L << 32;
      PlayerManager.PlayerInstance var6 = (PlayerManager.PlayerInstance)this.field_72700_c.func_76164_a(var4);
      if(var6 == null && p_72690_3_) {
         var6 = new PlayerManager.PlayerInstance(p_72690_1_, p_72690_2_);
         this.field_72700_c.func_76163_a(var4, var6);
         this.field_111193_e.add(var6);
      }

      return var6;
   }

   public void func_151250_a(int p_151250_1_, int p_151250_2_, int p_151250_3_) {
      int var4 = p_151250_1_ >> 4;
      int var5 = p_151250_3_ >> 4;
      PlayerManager.PlayerInstance var6 = this.func_72690_a(var4, var5, false);
      if(var6 != null) {
         var6.func_151253_a(p_151250_1_ & 15, p_151250_2_, p_151250_3_ & 15);
      }

   }

   public void func_72683_a(EntityPlayerMP p_72683_1_) {
      int var2 = (int)p_72683_1_.field_70165_t >> 4;
      int var3 = (int)p_72683_1_.field_70161_v >> 4;
      p_72683_1_.field_71131_d = p_72683_1_.field_70165_t;
      p_72683_1_.field_71132_e = p_72683_1_.field_70161_v;

      for(int var4 = var2 - this.field_72698_e; var4 <= var2 + this.field_72698_e; ++var4) {
         for(int var5 = var3 - this.field_72698_e; var5 <= var3 + this.field_72698_e; ++var5) {
            this.func_72690_a(var4, var5, true).func_73255_a(p_72683_1_);
         }
      }

      this.field_72699_b.add(p_72683_1_);
      this.func_72691_b(p_72683_1_);
   }

   public void func_72691_b(EntityPlayerMP p_72691_1_) {
      ArrayList var2 = new ArrayList(p_72691_1_.field_71129_f);
      int var3 = 0;
      int var4 = this.field_72698_e;
      int var5 = (int)p_72691_1_.field_70165_t >> 4;
      int var6 = (int)p_72691_1_.field_70161_v >> 4;
      int var7 = 0;
      int var8 = 0;
      ChunkCoordIntPair var9 = this.func_72690_a(var5, var6, true).field_73264_c;
      p_72691_1_.field_71129_f.clear();
      if(var2.contains(var9)) {
         p_72691_1_.field_71129_f.add(var9);
      }

      int var10;
      for(var10 = 1; var10 <= var4 * 2; ++var10) {
         for(int var11 = 0; var11 < 2; ++var11) {
            int[] var12 = this.field_72696_f[var3++ % 4];

            for(int var13 = 0; var13 < var10; ++var13) {
               var7 += var12[0];
               var8 += var12[1];
               var9 = this.func_72690_a(var5 + var7, var6 + var8, true).field_73264_c;
               if(var2.contains(var9)) {
                  p_72691_1_.field_71129_f.add(var9);
               }
            }
         }
      }

      var3 %= 4;

      for(var10 = 0; var10 < var4 * 2; ++var10) {
         var7 += this.field_72696_f[var3][0];
         var8 += this.field_72696_f[var3][1];
         var9 = this.func_72690_a(var5 + var7, var6 + var8, true).field_73264_c;
         if(var2.contains(var9)) {
            p_72691_1_.field_71129_f.add(var9);
         }
      }

   }

   public void func_72695_c(EntityPlayerMP p_72695_1_) {
      int var2 = (int)p_72695_1_.field_71131_d >> 4;
      int var3 = (int)p_72695_1_.field_71132_e >> 4;

      for(int var4 = var2 - this.field_72698_e; var4 <= var2 + this.field_72698_e; ++var4) {
         for(int var5 = var3 - this.field_72698_e; var5 <= var3 + this.field_72698_e; ++var5) {
            PlayerManager.PlayerInstance var6 = this.func_72690_a(var4, var5, false);
            if(var6 != null) {
               var6.func_73252_b(p_72695_1_);
            }
         }
      }

      this.field_72699_b.remove(p_72695_1_);
   }

   private boolean func_72684_a(int p_72684_1_, int p_72684_2_, int p_72684_3_, int p_72684_4_, int p_72684_5_) {
      int var6 = p_72684_1_ - p_72684_3_;
      int var7 = p_72684_2_ - p_72684_4_;
      return var6 >= -p_72684_5_ && var6 <= p_72684_5_?var7 >= -p_72684_5_ && var7 <= p_72684_5_:false;
   }

   public void func_72685_d(EntityPlayerMP p_72685_1_) {
      int var2 = (int)p_72685_1_.field_70165_t >> 4;
      int var3 = (int)p_72685_1_.field_70161_v >> 4;
      double var4 = p_72685_1_.field_71131_d - p_72685_1_.field_70165_t;
      double var6 = p_72685_1_.field_71132_e - p_72685_1_.field_70161_v;
      double var8 = var4 * var4 + var6 * var6;
      if(var8 >= 64.0D) {
         int var10 = (int)p_72685_1_.field_71131_d >> 4;
         int var11 = (int)p_72685_1_.field_71132_e >> 4;
         int var12 = this.field_72698_e;
         int var13 = var2 - var10;
         int var14 = var3 - var11;
         if(var13 != 0 || var14 != 0) {
            for(int var15 = var2 - var12; var15 <= var2 + var12; ++var15) {
               for(int var16 = var3 - var12; var16 <= var3 + var12; ++var16) {
                  if(!this.func_72684_a(var15, var16, var10, var11, var12)) {
                     this.func_72690_a(var15, var16, true).func_73255_a(p_72685_1_);
                  }

                  if(!this.func_72684_a(var15 - var13, var16 - var14, var2, var3, var12)) {
                     PlayerManager.PlayerInstance var17 = this.func_72690_a(var15 - var13, var16 - var14, false);
                     if(var17 != null) {
                        var17.func_73252_b(p_72685_1_);
                     }
                  }
               }
            }

            this.func_72691_b(p_72685_1_);
            p_72685_1_.field_71131_d = p_72685_1_.field_70165_t;
            p_72685_1_.field_71132_e = p_72685_1_.field_70161_v;
         }
      }
   }

   public boolean func_72694_a(EntityPlayerMP p_72694_1_, int p_72694_2_, int p_72694_3_) {
      PlayerManager.PlayerInstance var4 = this.func_72690_a(p_72694_2_, p_72694_3_, false);
      return var4 != null && var4.field_73263_b.contains(p_72694_1_) && !p_72694_1_.field_71129_f.contains(var4.field_73264_c);
   }

   public void func_152622_a(int p_152622_1_) {
      p_152622_1_ = MathHelper.func_76125_a(p_152622_1_, 3, 20);
      if(p_152622_1_ != this.field_72698_e) {
         int var2 = p_152622_1_ - this.field_72698_e;
         Iterator var3 = this.field_72699_b.iterator();

         while(var3.hasNext()) {
            EntityPlayerMP var4 = (EntityPlayerMP)var3.next();
            int var5 = (int)var4.field_70165_t >> 4;
            int var6 = (int)var4.field_70161_v >> 4;
            int var7;
            int var8;
            if(var2 > 0) {
               for(var7 = var5 - p_152622_1_; var7 <= var5 + p_152622_1_; ++var7) {
                  for(var8 = var6 - p_152622_1_; var8 <= var6 + p_152622_1_; ++var8) {
                     PlayerManager.PlayerInstance var9 = this.func_72690_a(var7, var8, true);
                     if(!var9.field_73263_b.contains(var4)) {
                        var9.func_73255_a(var4);
                     }
                  }
               }
            } else {
               for(var7 = var5 - this.field_72698_e; var7 <= var5 + this.field_72698_e; ++var7) {
                  for(var8 = var6 - this.field_72698_e; var8 <= var6 + this.field_72698_e; ++var8) {
                     if(!this.func_72684_a(var7, var8, var5, var6, p_152622_1_)) {
                        this.func_72690_a(var7, var8, true).func_73252_b(var4);
                     }
                  }
               }
            }
         }

         this.field_72698_e = p_152622_1_;
      }
   }

   public static int func_72686_a(int p_72686_0_) {
      return p_72686_0_ * 16 - 16;
   }


   class PlayerInstance {

      private final List field_73263_b = new ArrayList();
      private final ChunkCoordIntPair field_73264_c;
      private short[] field_151254_d = new short[64];
      private int field_73262_e;
      private int field_73260_f;
      private long field_111198_g;
      private static final String __OBFID = "CL_00001435";


      public PlayerInstance(int p_i1518_2_, int p_i1518_3_) {
         this.field_73264_c = new ChunkCoordIntPair(p_i1518_2_, p_i1518_3_);
         PlayerManager.this.func_72688_a().field_73059_b.func_73158_c(p_i1518_2_, p_i1518_3_);
      }

      public void func_73255_a(EntityPlayerMP p_73255_1_) {
         if(this.field_73263_b.contains(p_73255_1_)) {
            PlayerManager.field_152627_a.debug("Failed to add player. {} already is in chunk {}, {}", new Object[]{p_73255_1_, Integer.valueOf(this.field_73264_c.field_77276_a), Integer.valueOf(this.field_73264_c.field_77275_b)});
         } else {
            if(this.field_73263_b.isEmpty()) {
               this.field_111198_g = PlayerManager.this.field_72701_a.func_82737_E();
            }

            this.field_73263_b.add(p_73255_1_);
            p_73255_1_.field_71129_f.add(this.field_73264_c);
         }
      }

      public void func_73252_b(EntityPlayerMP p_73252_1_) {
         if(this.field_73263_b.contains(p_73252_1_)) {
            Chunk var2 = PlayerManager.this.field_72701_a.func_72964_e(this.field_73264_c.field_77276_a, this.field_73264_c.field_77275_b);
            if(var2.func_150802_k()) {
               p_73252_1_.field_71135_a.func_147359_a(new S21PacketChunkData(var2, true, 0));
            }

            this.field_73263_b.remove(p_73252_1_);
            p_73252_1_.field_71129_f.remove(this.field_73264_c);
            if(this.field_73263_b.isEmpty()) {
               long var3 = (long)this.field_73264_c.field_77276_a + 2147483647L | (long)this.field_73264_c.field_77275_b + 2147483647L << 32;
               this.func_111196_a(var2);
               PlayerManager.this.field_72700_c.func_76159_d(var3);
               PlayerManager.this.field_111193_e.remove(this);
               if(this.field_73262_e > 0) {
                  PlayerManager.this.field_72697_d.remove(this);
               }

               PlayerManager.this.func_72688_a().field_73059_b.func_73241_b(this.field_73264_c.field_77276_a, this.field_73264_c.field_77275_b);
            }

         }
      }

      public void func_111194_a() {
         this.func_111196_a(PlayerManager.this.field_72701_a.func_72964_e(this.field_73264_c.field_77276_a, this.field_73264_c.field_77275_b));
      }

      private void func_111196_a(Chunk p_111196_1_) {
         p_111196_1_.field_111204_q += PlayerManager.this.field_72701_a.func_82737_E() - this.field_111198_g;
         this.field_111198_g = PlayerManager.this.field_72701_a.func_82737_E();
      }

      public void func_151253_a(int p_151253_1_, int p_151253_2_, int p_151253_3_) {
         if(this.field_73262_e == 0) {
            PlayerManager.this.field_72697_d.add(this);
         }

         this.field_73260_f |= 1 << (p_151253_2_ >> 4);
         if(this.field_73262_e < 64) {
            short var4 = (short)(p_151253_1_ << 12 | p_151253_3_ << 8 | p_151253_2_);

            for(int var5 = 0; var5 < this.field_73262_e; ++var5) {
               if(this.field_151254_d[var5] == var4) {
                  return;
               }
            }

            this.field_151254_d[this.field_73262_e++] = var4;
         }

      }

      public void func_151251_a(Packet p_151251_1_) {
         for(int var2 = 0; var2 < this.field_73263_b.size(); ++var2) {
            EntityPlayerMP var3 = (EntityPlayerMP)this.field_73263_b.get(var2);
            if(!var3.field_71129_f.contains(this.field_73264_c)) {
               var3.field_71135_a.func_147359_a(p_151251_1_);
            }
         }

      }

      public void func_73254_a() {
         if(this.field_73262_e != 0) {
            int var1;
            int var2;
            int var3;
            if(this.field_73262_e == 1) {
               var1 = this.field_73264_c.field_77276_a * 16 + (this.field_151254_d[0] >> 12 & 15);
               var2 = this.field_151254_d[0] & 255;
               var3 = this.field_73264_c.field_77275_b * 16 + (this.field_151254_d[0] >> 8 & 15);
               this.func_151251_a(new S23PacketBlockChange(var1, var2, var3, PlayerManager.this.field_72701_a));
               if(PlayerManager.this.field_72701_a.func_147439_a(var1, var2, var3).func_149716_u()) {
                  this.func_151252_a(PlayerManager.this.field_72701_a.func_147438_o(var1, var2, var3));
               }
            } else {
               int var4;
               if(this.field_73262_e == 64) {
                  var1 = this.field_73264_c.field_77276_a * 16;
                  var2 = this.field_73264_c.field_77275_b * 16;
                  this.func_151251_a(new S21PacketChunkData(PlayerManager.this.field_72701_a.func_72964_e(this.field_73264_c.field_77276_a, this.field_73264_c.field_77275_b), false, this.field_73260_f));

                  for(var3 = 0; var3 < 16; ++var3) {
                     if((this.field_73260_f & 1 << var3) != 0) {
                        var4 = var3 << 4;
                        List var5 = PlayerManager.this.field_72701_a.func_147486_a(var1, var4, var2, var1 + 16, var4 + 16, var2 + 16);

                        for(int var6 = 0; var6 < var5.size(); ++var6) {
                           this.func_151252_a((TileEntity)var5.get(var6));
                        }
                     }
                  }
               } else {
                  this.func_151251_a(new S22PacketMultiBlockChange(this.field_73262_e, this.field_151254_d, PlayerManager.this.field_72701_a.func_72964_e(this.field_73264_c.field_77276_a, this.field_73264_c.field_77275_b)));

                  for(var1 = 0; var1 < this.field_73262_e; ++var1) {
                     var2 = this.field_73264_c.field_77276_a * 16 + (this.field_151254_d[var1] >> 12 & 15);
                     var3 = this.field_151254_d[var1] & 255;
                     var4 = this.field_73264_c.field_77275_b * 16 + (this.field_151254_d[var1] >> 8 & 15);
                     if(PlayerManager.this.field_72701_a.func_147439_a(var2, var3, var4).func_149716_u()) {
                        this.func_151252_a(PlayerManager.this.field_72701_a.func_147438_o(var2, var3, var4));
                     }
                  }
               }
            }

            this.field_73262_e = 0;
            this.field_73260_f = 0;
         }
      }

      private void func_151252_a(TileEntity p_151252_1_) {
         if(p_151252_1_ != null) {
            Packet var2 = p_151252_1_.func_145844_m();
            if(var2 != null) {
               this.func_151251_a(var2);
            }
         }

      }
   }
}
