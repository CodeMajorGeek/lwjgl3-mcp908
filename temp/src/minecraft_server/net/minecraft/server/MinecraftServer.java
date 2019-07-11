package net.minecraft.server;

import com.google.common.base.Charsets;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.base64.Base64;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.Proxy;
import java.security.KeyPair;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import javax.imageio.ImageIO;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Bootstrap;
import net.minecraft.network.NetworkSystem;
import net.minecraft.network.ServerStatusResponse;
import net.minecraft.network.play.server.S03PacketTimeUpdate;
import net.minecraft.network.rcon.RConConsoleSource;
import net.minecraft.profiler.IPlayerUsage;
import net.minecraft.profiler.PlayerUsageSnooper;
import net.minecraft.profiler.Profiler;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.server.management.PlayerProfileCache;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ReportedException;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.World;
import net.minecraft.world.WorldManager;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldServerMulti;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.storage.AnvilSaveConverter;
import net.minecraft.world.demo.DemoWorldServer;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class MinecraftServer implements ICommandSender, Runnable, IPlayerUsage {

   private static final Logger field_147145_h = LogManager.getLogger();
   public static final File field_152367_a = new File("usercache.json");
   private static MinecraftServer field_71309_l;
   private final ISaveFormat field_71310_m;
   private final PlayerUsageSnooper field_71307_n = new PlayerUsageSnooper("server", this, func_130071_aq());
   private final File field_71308_o;
   private final List field_71322_p = new ArrayList();
   private final ICommandManager field_71321_q;
   public final Profiler field_71304_b = new Profiler();
   private final NetworkSystem field_147144_o;
   private final ServerStatusResponse field_147147_p = new ServerStatusResponse();
   private final Random field_147146_q = new Random();
   private String field_71320_r;
   private int field_71319_s = -1;
   public WorldServer[] field_71305_c;
   private ServerConfigurationManager field_71318_t;
   private boolean field_71317_u = true;
   private boolean field_71316_v;
   private int field_71315_w;
   protected final Proxy field_110456_c;
   public String field_71302_d;
   public int field_71303_e;
   private boolean field_71325_x;
   private boolean field_71324_y;
   private boolean field_71323_z;
   private boolean field_71284_A;
   private boolean field_71285_B;
   private String field_71286_C;
   private int field_71280_D;
   private int field_143008_E = 0;
   public final long[] field_71311_j = new long[100];
   public long[][] field_71312_k;
   private KeyPair field_71292_I;
   private String field_71293_J;
   private String field_71294_K;
   private boolean field_71288_M;
   private boolean field_71289_N;
   private boolean field_71290_O;
   private String field_147141_M = "";
   private boolean field_71296_Q;
   private long field_71299_R;
   private String field_71298_S;
   private boolean field_71295_T;
   private boolean field_104057_T;
   private final YggdrasilAuthenticationService field_152364_T;
   private final MinecraftSessionService field_147143_S;
   private long field_147142_T = 0L;
   private final GameProfileRepository field_152365_W;
   private final PlayerProfileCache field_152366_X;
   private static final String __OBFID = "CL_00001462";


   public MinecraftServer(File p_i45281_1_, Proxy p_i45281_2_) {
      this.field_152366_X = new PlayerProfileCache(this, field_152367_a);
      field_71309_l = this;
      this.field_110456_c = p_i45281_2_;
      this.field_71308_o = p_i45281_1_;
      this.field_147144_o = new NetworkSystem(this);
      this.field_71321_q = new ServerCommandManager();
      this.field_71310_m = new AnvilSaveConverter(p_i45281_1_);
      this.field_152364_T = new YggdrasilAuthenticationService(p_i45281_2_, UUID.randomUUID().toString());
      this.field_147143_S = this.field_152364_T.createMinecraftSessionService();
      this.field_152365_W = this.field_152364_T.createProfileRepository();
   }

   protected abstract boolean func_71197_b() throws IOException;

   protected void func_71237_c(String p_71237_1_) {
      if(this.func_71254_M().func_75801_b(p_71237_1_)) {
         field_147145_h.info("Converting map!");
         this.func_71192_d("menu.convertingLevel");
         this.func_71254_M().func_75805_a(p_71237_1_, new IProgressUpdate() {

            private long field_96245_b = System.currentTimeMillis();
            private static final String __OBFID = "CL_00001417";

            public void func_73720_a(String p_73720_1_) {}
            public void func_73718_a(int p_73718_1_) {
               if(System.currentTimeMillis() - this.field_96245_b >= 1000L) {
                  this.field_96245_b = System.currentTimeMillis();
                  MinecraftServer.field_147145_h.info("Converting... " + p_73718_1_ + "%");
               }

            }
            public void func_73719_c(String p_73719_1_) {}
         });
      }

   }

   protected synchronized void func_71192_d(String p_71192_1_) {
      this.field_71298_S = p_71192_1_;
   }

   protected void func_71247_a(String p_71247_1_, String p_71247_2_, long p_71247_3_, WorldType p_71247_5_, String p_71247_6_) {
      this.func_71237_c(p_71247_1_);
      this.func_71192_d("menu.loadingLevel");
      this.field_71305_c = new WorldServer[3];
      this.field_71312_k = new long[this.field_71305_c.length][100];
      ISaveHandler var7 = this.field_71310_m.func_75804_a(p_71247_1_, true);
      WorldInfo var9 = var7.func_75757_d();
      WorldSettings var8;
      if(var9 == null) {
         var8 = new WorldSettings(p_71247_3_, this.func_71265_f(), this.func_71225_e(), this.func_71199_h(), p_71247_5_);
         var8.func_82750_a(p_71247_6_);
      } else {
         var8 = new WorldSettings(var9);
      }

      if(this.field_71289_N) {
         var8.func_77159_a();
      }

      for(int var10 = 0; var10 < this.field_71305_c.length; ++var10) {
         byte var11 = 0;
         if(var10 == 1) {
            var11 = -1;
         }

         if(var10 == 2) {
            var11 = 1;
         }

         if(var10 == 0) {
            if(this.func_71242_L()) {
               this.field_71305_c[var10] = new DemoWorldServer(this, var7, p_71247_2_, var11, this.field_71304_b);
            } else {
               this.field_71305_c[var10] = new WorldServer(this, var7, p_71247_2_, var11, var8, this.field_71304_b);
            }
         } else {
            this.field_71305_c[var10] = new WorldServerMulti(this, var7, p_71247_2_, var11, var8, this.field_71305_c[0], this.field_71304_b);
         }

         this.field_71305_c[var10].func_72954_a(new WorldManager(this, this.field_71305_c[var10]));
         if(!this.func_71264_H()) {
            this.field_71305_c[var10].func_72912_H().func_76060_a(this.func_71265_f());
         }

         this.field_71318_t.func_72364_a(this.field_71305_c);
      }

      this.func_147139_a(this.func_147135_j());
      this.func_71222_d();
   }

   protected void func_71222_d() {
      boolean var1 = true;
      boolean var2 = true;
      boolean var3 = true;
      boolean var4 = true;
      int var5 = 0;
      this.func_71192_d("menu.generatingTerrain");
      byte var6 = 0;
      field_147145_h.info("Preparing start region for level " + var6);
      WorldServer var7 = this.field_71305_c[var6];
      ChunkCoordinates var8 = var7.func_72861_E();
      long var9 = func_130071_aq();

      for(int var11 = -192; var11 <= 192 && this.func_71278_l(); var11 += 16) {
         for(int var12 = -192; var12 <= 192 && this.func_71278_l(); var12 += 16) {
            long var13 = func_130071_aq();
            if(var13 - var9 > 1000L) {
               this.func_71216_a_("Preparing spawn area", var5 * 100 / 625);
               var9 = var13;
            }

            ++var5;
            var7.field_73059_b.func_73158_c(var8.field_71574_a + var11 >> 4, var8.field_71573_c + var12 >> 4);
         }
      }

      this.func_71243_i();
   }

   public abstract boolean func_71225_e();

   public abstract WorldSettings.GameType func_71265_f();

   public abstract EnumDifficulty func_147135_j();

   public abstract boolean func_71199_h();

   public abstract int func_110455_j();

   public abstract boolean func_152363_m();

   protected void func_71216_a_(String p_71216_1_, int p_71216_2_) {
      this.field_71302_d = p_71216_1_;
      this.field_71303_e = p_71216_2_;
      field_147145_h.info(p_71216_1_ + ": " + p_71216_2_ + "%");
   }

   protected void func_71243_i() {
      this.field_71302_d = null;
      this.field_71303_e = 0;
   }

   protected void func_71267_a(boolean p_71267_1_) {
      if(!this.field_71290_O) {
         WorldServer[] var2 = this.field_71305_c;
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            WorldServer var5 = var2[var4];
            if(var5 != null) {
               if(!p_71267_1_) {
                  field_147145_h.info("Saving chunks for level \'" + var5.func_72912_H().func_76065_j() + "\'/" + var5.field_73011_w.func_80007_l());
               }

               try {
                  var5.func_73044_a(true, (IProgressUpdate)null);
               } catch (MinecraftException var7) {
                  field_147145_h.warn(var7.getMessage());
               }
            }
         }

      }
   }

   public void func_71260_j() {
      if(!this.field_71290_O) {
         field_147145_h.info("Stopping server");
         if(this.func_147137_ag() != null) {
            this.func_147137_ag().func_151268_b();
         }

         if(this.field_71318_t != null) {
            field_147145_h.info("Saving players");
            this.field_71318_t.func_72389_g();
            this.field_71318_t.func_72392_r();
         }

         if(this.field_71305_c != null) {
            field_147145_h.info("Saving worlds");
            this.func_71267_a(false);

            for(int var1 = 0; var1 < this.field_71305_c.length; ++var1) {
               WorldServer var2 = this.field_71305_c[var1];
               var2.func_73041_k();
            }
         }

         if(this.field_71307_n.func_76468_d()) {
            this.field_71307_n.func_76470_e();
         }

      }
   }

   public String func_71211_k() {
      return this.field_71320_r;
   }

   public void func_71189_e(String p_71189_1_) {
      this.field_71320_r = p_71189_1_;
   }

   public boolean func_71278_l() {
      return this.field_71317_u;
   }

   public void func_71263_m() {
      this.field_71317_u = false;
   }

   public void run() {
      try {
         if(this.func_71197_b()) {
            long var1 = func_130071_aq();
            long var50 = 0L;
            this.field_147147_p.func_151315_a(new ChatComponentText(this.field_71286_C));
            this.field_147147_p.func_151321_a(new ServerStatusResponse.MinecraftProtocolVersionIdentifier("1.7.10", 5));
            this.func_147138_a(this.field_147147_p);

            while(this.field_71317_u) {
               long var5 = func_130071_aq();
               long var7 = var5 - var1;
               if(var7 > 2000L && var1 - this.field_71299_R >= 15000L) {
                  field_147145_h.warn("Can\'t keep up! Did the system time change, or is the server overloaded? Running {}ms behind, skipping {} tick(s)", new Object[]{Long.valueOf(var7), Long.valueOf(var7 / 50L)});
                  var7 = 2000L;
                  this.field_71299_R = var1;
               }

               if(var7 < 0L) {
                  field_147145_h.warn("Time ran backwards! Did the system time change?");
                  var7 = 0L;
               }

               var50 += var7;
               var1 = var5;
               if(this.field_71305_c[0].func_73056_e()) {
                  this.func_71217_p();
                  var50 = 0L;
               } else {
                  while(var50 > 50L) {
                     var50 -= 50L;
                     this.func_71217_p();
                  }
               }

               Thread.sleep(Math.max(1L, 50L - var50));
               this.field_71296_Q = true;
            }
         } else {
            this.func_71228_a((CrashReport)null);
         }
      } catch (Throwable var48) {
         field_147145_h.error("Encountered an unexpected exception", var48);
         CrashReport var2 = null;
         if(var48 instanceof ReportedException) {
            var2 = this.func_71230_b(((ReportedException)var48).func_71575_a());
         } else {
            var2 = this.func_71230_b(new CrashReport("Exception in server tick loop", var48));
         }

         File var3 = new File(new File(this.func_71238_n(), "crash-reports"), "crash-" + (new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date()) + "-server.txt");
         if(var2.func_147149_a(var3)) {
            field_147145_h.error("This crash report has been saved to: " + var3.getAbsolutePath());
         } else {
            field_147145_h.error("We were unable to save this crash report to disk.");
         }

         this.func_71228_a(var2);
      } finally {
         try {
            this.func_71260_j();
            this.field_71316_v = true;
         } catch (Throwable var46) {
            field_147145_h.error("Exception stopping the server", var46);
         } finally {
            this.func_71240_o();
         }

      }

   }

   private void func_147138_a(ServerStatusResponse p_147138_1_) {
      File var2 = this.func_71209_f("server-icon.png");
      if(var2.isFile()) {
         ByteBuf var3 = Unpooled.buffer();

         try {
            BufferedImage var4 = ImageIO.read(var2);
            Validate.validState(var4.getWidth() == 64, "Must be 64 pixels wide", new Object[0]);
            Validate.validState(var4.getHeight() == 64, "Must be 64 pixels high", new Object[0]);
            ImageIO.write(var4, "PNG", new ByteBufOutputStream(var3));
            ByteBuf var5 = Base64.encode(var3);
            p_147138_1_.func_151320_a("data:image/png;base64," + var5.toString(Charsets.UTF_8));
         } catch (Exception var9) {
            field_147145_h.error("Couldn\'t load server icon", var9);
         } finally {
            var3.release();
         }
      }

   }

   protected File func_71238_n() {
      return new File(".");
   }

   protected void func_71228_a(CrashReport p_71228_1_) {}

   protected void func_71240_o() {}

   protected void func_71217_p() {
      long var1 = System.nanoTime();
      ++this.field_71315_w;
      if(this.field_71295_T) {
         this.field_71295_T = false;
         this.field_71304_b.field_76327_a = true;
         this.field_71304_b.func_76317_a();
      }

      this.field_71304_b.func_76320_a("root");
      this.func_71190_q();
      if(var1 - this.field_147142_T >= 5000000000L) {
         this.field_147142_T = var1;
         this.field_147147_p.func_151319_a(new ServerStatusResponse.PlayerCountData(this.func_71275_y(), this.func_71233_x()));
         GameProfile[] var3 = new GameProfile[Math.min(this.func_71233_x(), 12)];
         int var4 = MathHelper.func_76136_a(this.field_147146_q, 0, this.func_71233_x() - var3.length);

         for(int var5 = 0; var5 < var3.length; ++var5) {
            var3[var5] = ((EntityPlayerMP)this.field_71318_t.field_72404_b.get(var4 + var5)).func_146103_bH();
         }

         Collections.shuffle(Arrays.asList(var3));
         this.field_147147_p.func_151318_b().func_151330_a(var3);
      }

      if(this.field_71315_w % 900 == 0) {
         this.field_71304_b.func_76320_a("save");
         this.field_71318_t.func_72389_g();
         this.func_71267_a(true);
         this.field_71304_b.func_76319_b();
      }

      this.field_71304_b.func_76320_a("tallying");
      this.field_71311_j[this.field_71315_w % 100] = System.nanoTime() - var1;
      this.field_71304_b.func_76319_b();
      this.field_71304_b.func_76320_a("snooper");
      if(!this.field_71307_n.func_76468_d() && this.field_71315_w > 100) {
         this.field_71307_n.func_76463_a();
      }

      if(this.field_71315_w % 6000 == 0) {
         this.field_71307_n.func_76471_b();
      }

      this.field_71304_b.func_76319_b();
      this.field_71304_b.func_76319_b();
   }

   public void func_71190_q() {
      this.field_71304_b.func_76320_a("levels");

      int var1;
      for(var1 = 0; var1 < this.field_71305_c.length; ++var1) {
         long var2 = System.nanoTime();
         if(var1 == 0 || this.func_71255_r()) {
            WorldServer var4 = this.field_71305_c[var1];
            this.field_71304_b.func_76320_a(var4.func_72912_H().func_76065_j());
            this.field_71304_b.func_76320_a("pools");
            this.field_71304_b.func_76319_b();
            if(this.field_71315_w % 20 == 0) {
               this.field_71304_b.func_76320_a("timeSync");
               this.field_71318_t.func_148537_a(new S03PacketTimeUpdate(var4.func_82737_E(), var4.func_72820_D(), var4.func_82736_K().func_82766_b("doDaylightCycle")), var4.field_73011_w.field_76574_g);
               this.field_71304_b.func_76319_b();
            }

            this.field_71304_b.func_76320_a("tick");

            CrashReport var6;
            try {
               var4.func_72835_b();
            } catch (Throwable var8) {
               var6 = CrashReport.func_85055_a(var8, "Exception ticking world");
               var4.func_72914_a(var6);
               throw new ReportedException(var6);
            }

            try {
               var4.func_72939_s();
            } catch (Throwable var7) {
               var6 = CrashReport.func_85055_a(var7, "Exception ticking world entities");
               var4.func_72914_a(var6);
               throw new ReportedException(var6);
            }

            this.field_71304_b.func_76319_b();
            this.field_71304_b.func_76320_a("tracker");
            var4.func_73039_n().func_72788_a();
            this.field_71304_b.func_76319_b();
            this.field_71304_b.func_76319_b();
         }

         this.field_71312_k[var1][this.field_71315_w % 100] = System.nanoTime() - var2;
      }

      this.field_71304_b.func_76318_c("connection");
      this.func_147137_ag().func_151269_c();
      this.field_71304_b.func_76318_c("players");
      this.field_71318_t.func_72374_b();
      this.field_71304_b.func_76318_c("tickables");

      for(var1 = 0; var1 < this.field_71322_p.size(); ++var1) {
         ((IUpdatePlayerListBox)this.field_71322_p.get(var1)).func_73660_a();
      }

      this.field_71304_b.func_76319_b();
   }

   public boolean func_71255_r() {
      return true;
   }

   public void func_82010_a(IUpdatePlayerListBox p_82010_1_) {
      this.field_71322_p.add(p_82010_1_);
   }

   public static void main(String[] p_main_0_) {
      Bootstrap.func_151354_b();

      try {
         boolean var1 = true;
         String var2 = null;
         String var3 = ".";
         String var4 = null;
         boolean var5 = false;
         boolean var6 = false;
         int var7 = -1;

         for(int var8 = 0; var8 < p_main_0_.length; ++var8) {
            String var9 = p_main_0_[var8];
            String var10 = var8 == p_main_0_.length - 1?null:p_main_0_[var8 + 1];
            boolean var11 = false;
            if(!var9.equals("nogui") && !var9.equals("--nogui")) {
               if(var9.equals("--port") && var10 != null) {
                  var11 = true;

                  try {
                     var7 = Integer.parseInt(var10);
                  } catch (NumberFormatException var13) {
                     ;
                  }
               } else if(var9.equals("--singleplayer") && var10 != null) {
                  var11 = true;
                  var2 = var10;
               } else if(var9.equals("--universe") && var10 != null) {
                  var11 = true;
                  var3 = var10;
               } else if(var9.equals("--world") && var10 != null) {
                  var11 = true;
                  var4 = var10;
               } else if(var9.equals("--demo")) {
                  var5 = true;
               } else if(var9.equals("--bonusChest")) {
                  var6 = true;
               }
            } else {
               var1 = false;
            }

            if(var11) {
               ++var8;
            }
         }

         final DedicatedServer var15 = new DedicatedServer(new File(var3));
         if(var2 != null) {
            var15.func_71224_l(var2);
         }

         if(var4 != null) {
            var15.func_71261_m(var4);
         }

         if(var7 >= 0) {
            var15.func_71208_b(var7);
         }

         if(var5) {
            var15.func_71204_b(true);
         }

         if(var6) {
            var15.func_71194_c(true);
         }

         if(var1 && !GraphicsEnvironment.isHeadless()) {
            var15.func_120011_ar();
         }

         var15.func_71256_s();
         Runtime.getRuntime().addShutdownHook(new Thread("Server Shutdown Thread") {

            private static final String __OBFID = "CL_00001806";

            public void run() {
               var15.func_71260_j();
            }
         });
      } catch (Exception var14) {
         field_147145_h.fatal("Failed to start the minecraft server", var14);
      }

   }

   public void func_71256_s() {
      (new Thread("Server thread") {

         private static final String __OBFID = "CL_00001418";

         public void run() {
            MinecraftServer.this.run();
         }
      }).start();
   }

   public File func_71209_f(String p_71209_1_) {
      return new File(this.func_71238_n(), p_71209_1_);
   }

   public void func_71244_g(String p_71244_1_) {
      field_147145_h.info(p_71244_1_);
   }

   public void func_71236_h(String p_71236_1_) {
      field_147145_h.warn(p_71236_1_);
   }

   public WorldServer func_71218_a(int p_71218_1_) {
      return p_71218_1_ == -1?this.field_71305_c[1]:(p_71218_1_ == 1?this.field_71305_c[2]:this.field_71305_c[0]);
   }

   public String func_71277_t() {
      return this.field_71320_r;
   }

   public int func_71234_u() {
      return this.field_71319_s;
   }

   public String func_71274_v() {
      return this.field_71286_C;
   }

   public String func_71249_w() {
      return "1.7.10";
   }

   public int func_71233_x() {
      return this.field_71318_t.func_72394_k();
   }

   public int func_71275_y() {
      return this.field_71318_t.func_72352_l();
   }

   public String[] func_71213_z() {
      return this.field_71318_t.func_72369_d();
   }

   public GameProfile[] func_152357_F() {
      return this.field_71318_t.func_152600_g();
   }

   public String func_71258_A() {
      return "";
   }

   public String func_71252_i(String p_71252_1_) {
      RConConsoleSource.field_70010_a.func_70007_b();
      this.field_71321_q.func_71556_a(RConConsoleSource.field_70010_a, p_71252_1_);
      return RConConsoleSource.field_70010_a.func_70008_c();
   }

   public boolean func_71239_B() {
      return false;
   }

   public void func_71201_j(String p_71201_1_) {
      field_147145_h.error(p_71201_1_);
   }

   public void func_71198_k(String p_71198_1_) {
      if(this.func_71239_B()) {
         field_147145_h.info(p_71198_1_);
      }

   }

   public String getServerModName() {
      return "vanilla";
   }

   public CrashReport func_71230_b(CrashReport p_71230_1_) {
      p_71230_1_.func_85056_g().func_71500_a("Profiler Position", new Callable() {

         private static final String __OBFID = "CL_00001419";

         public String call() {
            return MinecraftServer.this.field_71304_b.field_76327_a?MinecraftServer.this.field_71304_b.func_76322_c():"N/A (disabled)";
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });
      if(this.field_71305_c != null && this.field_71305_c.length > 0 && this.field_71305_c[0] != null) {
         p_71230_1_.func_85056_g().func_71500_a("Vec3 Pool Size", new Callable() {

            private static final String __OBFID = "CL_00001420";

            public String call() {
               byte var1 = 0;
               int var2 = 56 * var1;
               int var3 = var2 / 1024 / 1024;
               byte var4 = 0;
               int var5 = 56 * var4;
               int var6 = var5 / 1024 / 1024;
               return var1 + " (" + var2 + " bytes; " + var3 + " MB) allocated, " + var4 + " (" + var5 + " bytes; " + var6 + " MB) used";
            }
            // $FF: synthetic method
            public Object call() {
               return this.call();
            }
         });
      }

      if(this.field_71318_t != null) {
         p_71230_1_.func_85056_g().func_71500_a("Player Count", new Callable() {

            private static final String __OBFID = "CL_00001780";

            public String call() {
               return MinecraftServer.this.field_71318_t.func_72394_k() + " / " + MinecraftServer.this.field_71318_t.func_72352_l() + "; " + MinecraftServer.this.field_71318_t.field_72404_b;
            }
            // $FF: synthetic method
            public Object call() {
               return this.call();
            }
         });
      }

      return p_71230_1_;
   }

   public List func_71248_a(ICommandSender p_71248_1_, String p_71248_2_) {
      ArrayList var3 = new ArrayList();
      if(p_71248_2_.startsWith("/")) {
         p_71248_2_ = p_71248_2_.substring(1);
         boolean var10 = !p_71248_2_.contains(" ");
         List var11 = this.field_71321_q.func_71558_b(p_71248_1_, p_71248_2_);
         if(var11 != null) {
            Iterator var12 = var11.iterator();

            while(var12.hasNext()) {
               String var13 = (String)var12.next();
               if(var10) {
                  var3.add("/" + var13);
               } else {
                  var3.add(var13);
               }
            }
         }

         return var3;
      } else {
         String[] var4 = p_71248_2_.split(" ", -1);
         String var5 = var4[var4.length - 1];
         String[] var6 = this.field_71318_t.func_72369_d();
         int var7 = var6.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            String var9 = var6[var8];
            if(CommandBase.func_71523_a(var5, var9)) {
               var3.add(var9);
            }
         }

         return var3;
      }
   }

   public static MinecraftServer func_71276_C() {
      return field_71309_l;
   }

   public String func_70005_c_() {
      return "Server";
   }

   public void func_145747_a(IChatComponent p_145747_1_) {
      field_147145_h.info(p_145747_1_.func_150260_c());
   }

   public boolean func_70003_b(int p_70003_1_, String p_70003_2_) {
      return true;
   }

   public ICommandManager func_71187_D() {
      return this.field_71321_q;
   }

   public KeyPair func_71250_E() {
      return this.field_71292_I;
   }

   public int func_71215_F() {
      return this.field_71319_s;
   }

   public void func_71208_b(int p_71208_1_) {
      this.field_71319_s = p_71208_1_;
   }

   public String func_71214_G() {
      return this.field_71293_J;
   }

   public void func_71224_l(String p_71224_1_) {
      this.field_71293_J = p_71224_1_;
   }

   public boolean func_71264_H() {
      return this.field_71293_J != null;
   }

   public String func_71270_I() {
      return this.field_71294_K;
   }

   public void func_71261_m(String p_71261_1_) {
      this.field_71294_K = p_71261_1_;
   }

   public void func_71253_a(KeyPair p_71253_1_) {
      this.field_71292_I = p_71253_1_;
   }

   public void func_147139_a(EnumDifficulty p_147139_1_) {
      for(int var2 = 0; var2 < this.field_71305_c.length; ++var2) {
         WorldServer var3 = this.field_71305_c[var2];
         if(var3 != null) {
            if(var3.func_72912_H().func_76093_s()) {
               var3.field_73013_u = EnumDifficulty.HARD;
               var3.func_72891_a(true, true);
            } else if(this.func_71264_H()) {
               var3.field_73013_u = p_147139_1_;
               var3.func_72891_a(var3.field_73013_u != EnumDifficulty.PEACEFUL, true);
            } else {
               var3.field_73013_u = p_147139_1_;
               var3.func_72891_a(this.func_71193_K(), this.field_71324_y);
            }
         }
      }

   }

   protected boolean func_71193_K() {
      return true;
   }

   public boolean func_71242_L() {
      return this.field_71288_M;
   }

   public void func_71204_b(boolean p_71204_1_) {
      this.field_71288_M = p_71204_1_;
   }

   public void func_71194_c(boolean p_71194_1_) {
      this.field_71289_N = p_71194_1_;
   }

   public ISaveFormat func_71254_M() {
      return this.field_71310_m;
   }

   public void func_71272_O() {
      this.field_71290_O = true;
      this.func_71254_M().func_75800_d();

      for(int var1 = 0; var1 < this.field_71305_c.length; ++var1) {
         WorldServer var2 = this.field_71305_c[var1];
         if(var2 != null) {
            var2.func_73041_k();
         }
      }

      this.func_71254_M().func_75802_e(this.field_71305_c[0].func_72860_G().func_75760_g());
      this.func_71263_m();
   }

   public String func_147133_T() {
      return this.field_147141_M;
   }

   public void func_155759_m(String p_155759_1_) {
      this.field_147141_M = p_155759_1_;
   }

   public void func_70000_a(PlayerUsageSnooper p_70000_1_) {
      p_70000_1_.func_152768_a("whitelist_enabled", Boolean.valueOf(false));
      p_70000_1_.func_152768_a("whitelist_count", Integer.valueOf(0));
      p_70000_1_.func_152768_a("players_current", Integer.valueOf(this.func_71233_x()));
      p_70000_1_.func_152768_a("players_max", Integer.valueOf(this.func_71275_y()));
      p_70000_1_.func_152768_a("players_seen", Integer.valueOf(this.field_71318_t.func_72373_m().length));
      p_70000_1_.func_152768_a("uses_auth", Boolean.valueOf(this.field_71325_x));
      p_70000_1_.func_152768_a("gui_state", this.func_71279_ae()?"enabled":"disabled");
      p_70000_1_.func_152768_a("run_time", Long.valueOf((func_130071_aq() - p_70000_1_.func_130105_g()) / 60L * 1000L));
      p_70000_1_.func_152768_a("avg_tick_ms", Integer.valueOf((int)(MathHelper.func_76127_a(this.field_71311_j) * 1.0E-6D)));
      int var2 = 0;

      for(int var3 = 0; var3 < this.field_71305_c.length; ++var3) {
         if(this.field_71305_c[var3] != null) {
            WorldServer var4 = this.field_71305_c[var3];
            WorldInfo var5 = var4.func_72912_H();
            p_70000_1_.func_152768_a("world[" + var2 + "][dimension]", Integer.valueOf(var4.field_73011_w.field_76574_g));
            p_70000_1_.func_152768_a("world[" + var2 + "][mode]", var5.func_76077_q());
            p_70000_1_.func_152768_a("world[" + var2 + "][difficulty]", var4.field_73013_u);
            p_70000_1_.func_152768_a("world[" + var2 + "][hardcore]", Boolean.valueOf(var5.func_76093_s()));
            p_70000_1_.func_152768_a("world[" + var2 + "][generator_name]", var5.func_76067_t().func_77127_a());
            p_70000_1_.func_152768_a("world[" + var2 + "][generator_version]", Integer.valueOf(var5.func_76067_t().func_77131_c()));
            p_70000_1_.func_152768_a("world[" + var2 + "][height]", Integer.valueOf(this.field_71280_D));
            p_70000_1_.func_152768_a("world[" + var2 + "][chunks_loaded]", Integer.valueOf(var4.func_72863_F().func_73152_e()));
            ++var2;
         }
      }

      p_70000_1_.func_152768_a("worlds", Integer.valueOf(var2));
   }

   public void func_70001_b(PlayerUsageSnooper p_70001_1_) {
      p_70001_1_.func_152767_b("singleplayer", Boolean.valueOf(this.func_71264_H()));
      p_70001_1_.func_152767_b("server_brand", this.getServerModName());
      p_70001_1_.func_152767_b("gui_supported", GraphicsEnvironment.isHeadless()?"headless":"supported");
      p_70001_1_.func_152767_b("dedicated", Boolean.valueOf(this.func_71262_S()));
   }

   public boolean func_70002_Q() {
      return true;
   }

   public abstract boolean func_71262_S();

   public boolean func_71266_T() {
      return this.field_71325_x;
   }

   public void func_71229_d(boolean p_71229_1_) {
      this.field_71325_x = p_71229_1_;
   }

   public boolean func_71268_U() {
      return this.field_71324_y;
   }

   public void func_71251_e(boolean p_71251_1_) {
      this.field_71324_y = p_71251_1_;
   }

   public boolean func_71220_V() {
      return this.field_71323_z;
   }

   public void func_71257_f(boolean p_71257_1_) {
      this.field_71323_z = p_71257_1_;
   }

   public boolean func_71219_W() {
      return this.field_71284_A;
   }

   public void func_71188_g(boolean p_71188_1_) {
      this.field_71284_A = p_71188_1_;
   }

   public boolean func_71231_X() {
      return this.field_71285_B;
   }

   public void func_71245_h(boolean p_71245_1_) {
      this.field_71285_B = p_71245_1_;
   }

   public abstract boolean func_82356_Z();

   public String func_71273_Y() {
      return this.field_71286_C;
   }

   public void func_71205_p(String p_71205_1_) {
      this.field_71286_C = p_71205_1_;
   }

   public int func_71207_Z() {
      return this.field_71280_D;
   }

   public void func_71191_d(int p_71191_1_) {
      this.field_71280_D = p_71191_1_;
   }

   public boolean func_71241_aa() {
      return this.field_71316_v;
   }

   public ServerConfigurationManager func_71203_ab() {
      return this.field_71318_t;
   }

   public void func_152361_a(ServerConfigurationManager p_152361_1_) {
      this.field_71318_t = p_152361_1_;
   }

   public void func_71235_a(WorldSettings.GameType p_71235_1_) {
      for(int var2 = 0; var2 < this.field_71305_c.length; ++var2) {
         func_71276_C().field_71305_c[var2].func_72912_H().func_76060_a(p_71235_1_);
      }

   }

   public NetworkSystem func_147137_ag() {
      return this.field_147144_o;
   }

   public boolean func_71279_ae() {
      return false;
   }

   public abstract String func_71206_a(WorldSettings.GameType var1, boolean var2);

   public int func_71259_af() {
      return this.field_71315_w;
   }

   public void func_71223_ag() {
      this.field_71295_T = true;
   }

   public ChunkCoordinates func_82114_b() {
      return new ChunkCoordinates(0, 0, 0);
   }

   public World func_130014_f_() {
      return this.field_71305_c[0];
   }

   public int func_82357_ak() {
      return 16;
   }

   public boolean func_96290_a(World p_96290_1_, int p_96290_2_, int p_96290_3_, int p_96290_4_, EntityPlayer p_96290_5_) {
      return false;
   }

   public void func_104055_i(boolean p_104055_1_) {
      this.field_104057_T = p_104055_1_;
   }

   public boolean func_104056_am() {
      return this.field_104057_T;
   }

   public Proxy func_110454_ao() {
      return this.field_110456_c;
   }

   public static long func_130071_aq() {
      return System.currentTimeMillis();
   }

   public int func_143007_ar() {
      return this.field_143008_E;
   }

   public void func_143006_e(int p_143006_1_) {
      this.field_143008_E = p_143006_1_;
   }

   public IChatComponent func_145748_c_() {
      return new ChatComponentText(this.func_70005_c_());
   }

   public boolean func_147136_ar() {
      return true;
   }

   public MinecraftSessionService func_147130_as() {
      return this.field_147143_S;
   }

   public GameProfileRepository func_152359_aw() {
      return this.field_152365_W;
   }

   public PlayerProfileCache func_152358_ax() {
      return this.field_152366_X;
   }

   public ServerStatusResponse func_147134_at() {
      return this.field_147147_p;
   }

   public void func_147132_au() {
      this.field_147142_T = 0L;
   }

}
