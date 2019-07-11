package net.minecraft.server.dedicated;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.ServerCommand;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.rcon.IServer;
import net.minecraft.network.rcon.RConThreadMain;
import net.minecraft.network.rcon.RConThreadQuery;
import net.minecraft.profiler.PlayerUsageSnooper;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ServerEula;
import net.minecraft.server.dedicated.DedicatedPlayerList;
import net.minecraft.server.dedicated.PropertyManager;
import net.minecraft.server.gui.MinecraftServerGui;
import net.minecraft.server.management.PreYggdrasilConverter;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.CryptManager;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DedicatedServer extends MinecraftServer implements IServer {

   private static final Logger field_155771_h = LogManager.getLogger();
   private final List field_71341_l = Collections.synchronizedList(new ArrayList());
   private RConThreadQuery field_71342_m;
   private RConThreadMain field_71339_n;
   private PropertyManager field_71340_o;
   private ServerEula field_154332_n;
   private boolean field_71338_p;
   private WorldSettings.GameType field_71337_q;
   private boolean field_71335_s;
   private static final String __OBFID = "CL_00001784";


   public DedicatedServer(File p_i1508_1_) {
      super(p_i1508_1_, Proxy.NO_PROXY);
      Thread var10001 = new Thread("Server Infinisleeper") {

         private static final String __OBFID = "CL_00001787";

         {
            this.setDaemon(true);
            this.start();
         }
         public void run() {
            while(true) {
               try {
                  while(true) {
                     Thread.sleep(2147483647L);
                  }
               } catch (InterruptedException var2) {
                  ;
               }
            }
         }
      };
   }

   protected boolean func_71197_b() throws IOException {
      Thread var1 = new Thread("Server console handler") {

         private static final String __OBFID = "CL_00001786";

         public void run() {
            BufferedReader var1 = new BufferedReader(new InputStreamReader(System.in));

            String var2;
            try {
               while(!DedicatedServer.this.func_71241_aa() && DedicatedServer.this.func_71278_l() && (var2 = var1.readLine()) != null) {
                  DedicatedServer.this.func_71331_a(var2, DedicatedServer.this);
               }
            } catch (IOException var4) {
               DedicatedServer.field_155771_h.error("Exception handling console input", var4);
            }

         }
      };
      var1.setDaemon(true);
      var1.start();
      field_155771_h.info("Starting minecraft server version 1.7.10");
      if(Runtime.getRuntime().maxMemory() / 1024L / 1024L < 512L) {
         field_155771_h.warn("To start the server with more ram, launch it as \"java -Xmx1024M -Xms1024M -jar minecraft_server.jar\"");
      }

      field_155771_h.info("Loading properties");
      this.field_71340_o = new PropertyManager(new File("server.properties"));
      this.field_154332_n = new ServerEula(new File("eula.txt"));
      if(!this.field_154332_n.func_154346_a()) {
         field_155771_h.info("You need to agree to the EULA in order to run the server. Go to eula.txt for more info.");
         this.field_154332_n.func_154348_b();
         return false;
      } else {
         if(this.func_71264_H()) {
            this.func_71189_e("127.0.0.1");
         } else {
            this.func_71229_d(this.field_71340_o.func_73670_a("online-mode", true));
            this.func_71189_e(this.field_71340_o.func_73671_a("server-ip", ""));
         }

         this.func_71251_e(this.field_71340_o.func_73670_a("spawn-animals", true));
         this.func_71257_f(this.field_71340_o.func_73670_a("spawn-npcs", true));
         this.func_71188_g(this.field_71340_o.func_73670_a("pvp", true));
         this.func_71245_h(this.field_71340_o.func_73670_a("allow-flight", false));
         this.func_155759_m(this.field_71340_o.func_73671_a("resource-pack", ""));
         this.func_71205_p(this.field_71340_o.func_73671_a("motd", "A Minecraft Server"));
         this.func_104055_i(this.field_71340_o.func_73670_a("force-gamemode", false));
         this.func_143006_e(this.field_71340_o.func_73669_a("player-idle-timeout", 0));
         if(this.field_71340_o.func_73669_a("difficulty", 1) < 0) {
            this.field_71340_o.func_73667_a("difficulty", Integer.valueOf(0));
         } else if(this.field_71340_o.func_73669_a("difficulty", 1) > 3) {
            this.field_71340_o.func_73667_a("difficulty", Integer.valueOf(3));
         }

         this.field_71338_p = this.field_71340_o.func_73670_a("generate-structures", true);
         int var2 = this.field_71340_o.func_73669_a("gamemode", WorldSettings.GameType.SURVIVAL.func_77148_a());
         this.field_71337_q = WorldSettings.func_77161_a(var2);
         field_155771_h.info("Default game type: " + this.field_71337_q);
         InetAddress var3 = null;
         if(this.func_71211_k().length() > 0) {
            var3 = InetAddress.getByName(this.func_71211_k());
         }

         if(this.func_71215_F() < 0) {
            this.func_71208_b(this.field_71340_o.func_73669_a("server-port", 25565));
         }

         field_155771_h.info("Generating keypair");
         this.func_71253_a(CryptManager.func_75891_b());
         field_155771_h.info("Starting Minecraft server on " + (this.func_71211_k().length() == 0?"*":this.func_71211_k()) + ":" + this.func_71215_F());

         try {
            this.func_147137_ag().func_151265_a(var3, this.func_71215_F());
         } catch (IOException var16) {
            field_155771_h.warn("**** FAILED TO BIND TO PORT!");
            field_155771_h.warn("The exception was: {}", new Object[]{var16.toString()});
            field_155771_h.warn("Perhaps a server is already running on that port?");
            return false;
         }

         if(!this.func_71266_T()) {
            field_155771_h.warn("**** SERVER IS RUNNING IN OFFLINE/INSECURE MODE!");
            field_155771_h.warn("The server will make no attempt to authenticate usernames. Beware.");
            field_155771_h.warn("While this makes the game possible to play without internet access, it also opens up the ability for hackers to connect with any username they choose.");
            field_155771_h.warn("To change this, set \"online-mode\" to \"true\" in the server.properties file.");
         }

         if(this.func_152368_aE()) {
            this.func_152358_ax().func_152658_c();
         }

         if(!PreYggdrasilConverter.func_152714_a(this.field_71340_o)) {
            return false;
         } else {
            this.func_152361_a(new DedicatedPlayerList(this));
            long var4 = System.nanoTime();
            if(this.func_71270_I() == null) {
               this.func_71261_m(this.field_71340_o.func_73671_a("level-name", "world"));
            }

            String var6 = this.field_71340_o.func_73671_a("level-seed", "");
            String var7 = this.field_71340_o.func_73671_a("level-type", "DEFAULT");
            String var8 = this.field_71340_o.func_73671_a("generator-settings", "");
            long var9 = (new Random()).nextLong();
            if(var6.length() > 0) {
               try {
                  long var11 = Long.parseLong(var6);
                  if(var11 != 0L) {
                     var9 = var11;
                  }
               } catch (NumberFormatException var15) {
                  var9 = (long)var6.hashCode();
               }
            }

            WorldType var17 = WorldType.func_77130_a(var7);
            if(var17 == null) {
               var17 = WorldType.field_77137_b;
            }

            this.func_147136_ar();
            this.func_82356_Z();
            this.func_110455_j();
            this.func_70002_Q();
            this.func_71191_d(this.field_71340_o.func_73669_a("max-build-height", 256));
            this.func_71191_d((this.func_71207_Z() + 8) / 16 * 16);
            this.func_71191_d(MathHelper.func_76125_a(this.func_71207_Z(), 64, 256));
            this.field_71340_o.func_73667_a("max-build-height", Integer.valueOf(this.func_71207_Z()));
            field_155771_h.info("Preparing level \"" + this.func_71270_I() + "\"");
            this.func_71247_a(this.func_71270_I(), this.func_71270_I(), var9, var17, var8);
            long var12 = System.nanoTime() - var4;
            String var14 = String.format("%.3fs", new Object[]{Double.valueOf((double)var12 / 1.0E9D)});
            field_155771_h.info("Done (" + var14 + ")! For help, type \"help\" or \"?\"");
            if(this.field_71340_o.func_73670_a("enable-query", false)) {
               field_155771_h.info("Starting GS4 status listener");
               this.field_71342_m = new RConThreadQuery(this);
               this.field_71342_m.func_72602_a();
            }

            if(this.field_71340_o.func_73670_a("enable-rcon", false)) {
               field_155771_h.info("Starting remote control listener");
               this.field_71339_n = new RConThreadMain(this);
               this.field_71339_n.func_72602_a();
            }

            return true;
         }
      }
   }

   public boolean func_71225_e() {
      return this.field_71338_p;
   }

   public WorldSettings.GameType func_71265_f() {
      return this.field_71337_q;
   }

   public EnumDifficulty func_147135_j() {
      return EnumDifficulty.func_151523_a(this.field_71340_o.func_73669_a("difficulty", 1));
   }

   public boolean func_71199_h() {
      return this.field_71340_o.func_73670_a("hardcore", false);
   }

   protected void func_71228_a(CrashReport p_71228_1_) {}

   public CrashReport func_71230_b(CrashReport p_71230_1_) {
      p_71230_1_ = super.func_71230_b(p_71230_1_);
      p_71230_1_.func_85056_g().func_71500_a("Is Modded", new Callable() {

         private static final String __OBFID = "CL_00001785";

         public String call() {
            String var1 = DedicatedServer.this.getServerModName();
            return !var1.equals("vanilla")?"Definitely; Server brand changed to \'" + var1 + "\'":"Unknown (can\'t tell)";
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });
      p_71230_1_.func_85056_g().func_71500_a("Type", new Callable() {

         private static final String __OBFID = "CL_00001788";

         public String call() {
            return "Dedicated Server (map_server.txt)";
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });
      return p_71230_1_;
   }

   protected void func_71240_o() {
      System.exit(0);
   }

   public void func_71190_q() {
      super.func_71190_q();
      this.func_71333_ah();
   }

   public boolean func_71255_r() {
      return this.field_71340_o.func_73670_a("allow-nether", true);
   }

   public boolean func_71193_K() {
      return this.field_71340_o.func_73670_a("spawn-monsters", true);
   }

   public void func_70000_a(PlayerUsageSnooper p_70000_1_) {
      p_70000_1_.func_152768_a("whitelist_enabled", Boolean.valueOf(this.func_71203_ab().func_72383_n()));
      p_70000_1_.func_152768_a("whitelist_count", Integer.valueOf(this.func_71203_ab().func_152598_l().length));
      super.func_70000_a(p_70000_1_);
   }

   public boolean func_70002_Q() {
      return this.field_71340_o.func_73670_a("snooper-enabled", true);
   }

   public void func_71331_a(String p_71331_1_, ICommandSender p_71331_2_) {
      this.field_71341_l.add(new ServerCommand(p_71331_1_, p_71331_2_));
   }

   public void func_71333_ah() {
      while(!this.field_71341_l.isEmpty()) {
         ServerCommand var1 = (ServerCommand)this.field_71341_l.remove(0);
         this.func_71187_D().func_71556_a(var1.field_73701_b, var1.field_73702_a);
      }

   }

   public boolean func_71262_S() {
      return true;
   }

   public DedicatedPlayerList func_71203_ab() {
      return (DedicatedPlayerList)super.func_71203_ab();
   }

   public int func_71327_a(String p_71327_1_, int p_71327_2_) {
      return this.field_71340_o.func_73669_a(p_71327_1_, p_71327_2_);
   }

   public String func_71330_a(String p_71330_1_, String p_71330_2_) {
      return this.field_71340_o.func_73671_a(p_71330_1_, p_71330_2_);
   }

   public boolean func_71332_a(String p_71332_1_, boolean p_71332_2_) {
      return this.field_71340_o.func_73670_a(p_71332_1_, p_71332_2_);
   }

   public void func_71328_a(String p_71328_1_, Object p_71328_2_) {
      this.field_71340_o.func_73667_a(p_71328_1_, p_71328_2_);
   }

   public void func_71326_a() {
      this.field_71340_o.func_73668_b();
   }

   public String func_71329_c() {
      File var1 = this.field_71340_o.func_73665_c();
      return var1 != null?var1.getAbsolutePath():"No settings file";
   }

   public void func_120011_ar() {
      MinecraftServerGui.func_120016_a(this);
      this.field_71335_s = true;
   }

   public boolean func_71279_ae() {
      return this.field_71335_s;
   }

   public String func_71206_a(WorldSettings.GameType p_71206_1_, boolean p_71206_2_) {
      return "";
   }

   public boolean func_82356_Z() {
      return this.field_71340_o.func_73670_a("enable-command-block", false);
   }

   public int func_82357_ak() {
      return this.field_71340_o.func_73669_a("spawn-protection", super.func_82357_ak());
   }

   public boolean func_96290_a(World p_96290_1_, int p_96290_2_, int p_96290_3_, int p_96290_4_, EntityPlayer p_96290_5_) {
      if(p_96290_1_.field_73011_w.field_76574_g != 0) {
         return false;
      } else if(this.func_71203_ab().func_152603_m().func_152690_d()) {
         return false;
      } else if(this.func_71203_ab().func_152596_g(p_96290_5_.func_146103_bH())) {
         return false;
      } else if(this.func_82357_ak() <= 0) {
         return false;
      } else {
         ChunkCoordinates var6 = p_96290_1_.func_72861_E();
         int var7 = MathHelper.func_76130_a(p_96290_2_ - var6.field_71574_a);
         int var8 = MathHelper.func_76130_a(p_96290_4_ - var6.field_71573_c);
         int var9 = Math.max(var7, var8);
         return var9 <= this.func_82357_ak();
      }
   }

   public int func_110455_j() {
      return this.field_71340_o.func_73669_a("op-permission-level", 4);
   }

   public void func_143006_e(int p_143006_1_) {
      super.func_143006_e(p_143006_1_);
      this.field_71340_o.func_73667_a("player-idle-timeout", Integer.valueOf(p_143006_1_));
      this.func_71326_a();
   }

   public boolean func_152363_m() {
      return this.field_71340_o.func_73670_a("broadcast-rcon-to-ops", true);
   }

   public boolean func_147136_ar() {
      return this.field_71340_o.func_73670_a("announce-player-achievements", true);
   }

   protected boolean func_152368_aE() throws IOException {
      boolean var2 = false;

      int var1;
      for(var1 = 0; !var2 && var1 <= 2; ++var1) {
         if(var1 > 0) {
            field_155771_h.warn("Encountered a problem while converting the user banlist, retrying in a few seconds");
            this.func_152369_aG();
         }

         var2 = PreYggdrasilConverter.func_152724_a(this);
      }

      boolean var3 = false;

      for(var1 = 0; !var3 && var1 <= 2; ++var1) {
         if(var1 > 0) {
            field_155771_h.warn("Encountered a problem while converting the ip banlist, retrying in a few seconds");
            this.func_152369_aG();
         }

         var3 = PreYggdrasilConverter.func_152722_b(this);
      }

      boolean var4 = false;

      for(var1 = 0; !var4 && var1 <= 2; ++var1) {
         if(var1 > 0) {
            field_155771_h.warn("Encountered a problem while converting the op list, retrying in a few seconds");
            this.func_152369_aG();
         }

         var4 = PreYggdrasilConverter.func_152718_c(this);
      }

      boolean var5 = false;

      for(var1 = 0; !var5 && var1 <= 2; ++var1) {
         if(var1 > 0) {
            field_155771_h.warn("Encountered a problem while converting the whitelist, retrying in a few seconds");
            this.func_152369_aG();
         }

         var5 = PreYggdrasilConverter.func_152710_d(this);
      }

      boolean var6 = false;

      for(var1 = 0; !var6 && var1 <= 2; ++var1) {
         if(var1 > 0) {
            field_155771_h.warn("Encountered a problem while converting the player save files, retrying in a few seconds");
            this.func_152369_aG();
         }

         var6 = PreYggdrasilConverter.func_152723_a(this, this.field_71340_o);
      }

      return var2 || var3 || var4 || var5 || var6;
   }

   private void func_152369_aG() {
      try {
         Thread.sleep(5000L);
      } catch (InterruptedException var2) {
         ;
      }
   }

   // $FF: synthetic method
   public ServerConfigurationManager func_71203_ab() {
      return this.func_71203_ab();
   }

}
