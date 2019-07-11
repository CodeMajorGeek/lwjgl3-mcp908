package net.minecraft.client.gui;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.GuiYesNoCallback;
import net.minecraft.client.gui.stream.GuiTwitchUserMode;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.client.C14PacketTabComplete;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import tv.twitch.chat.ChatUserInfo;

public class GuiChat extends GuiScreen implements GuiYesNoCallback {

   private static final Set field_152175_f = Sets.newHashSet(new String[]{"http", "https"});
   private static final Logger field_146408_f = LogManager.getLogger();
   private String field_146410_g = "";
   private int field_146416_h = -1;
   private boolean field_146417_i;
   private boolean field_146414_r;
   private int field_146413_s;
   private List field_146412_t = new ArrayList();
   private URI field_146411_u;
   protected GuiTextField field_146415_a;
   private String field_146409_v = "";
   private static final String __OBFID = "CL_00000682";


   public GuiChat() {}

   public GuiChat(String p_i1024_1_) {
      this.field_146409_v = p_i1024_1_;
   }

   public void func_73866_w_() {
      Keyboard.enableRepeatEvents(true);
      this.field_146416_h = this.field_146297_k.field_71456_v.func_146158_b().func_146238_c().size();
      this.field_146415_a = new GuiTextField(this.field_146289_q, 4, this.field_146295_m - 12, this.field_146294_l - 4, 12);
      this.field_146415_a.func_146203_f(100);
      this.field_146415_a.func_146185_a(false);
      this.field_146415_a.func_146195_b(true);
      this.field_146415_a.func_146180_a(this.field_146409_v);
      this.field_146415_a.func_146205_d(false);
   }

   public void func_146281_b() {
      Keyboard.enableRepeatEvents(false);
      this.field_146297_k.field_71456_v.func_146158_b().func_146240_d();
   }

   public void func_73876_c() {
      this.field_146415_a.func_146178_a();
   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
      this.field_146414_r = false;
      if(p_73869_2_ == 15) {
         this.func_146404_p_();
      } else {
         this.field_146417_i = false;
      }

      if(p_73869_2_ == 1) {
         this.field_146297_k.func_147108_a((GuiScreen)null);
      } else if(p_73869_2_ != 28 && p_73869_2_ != 156) {
         if(p_73869_2_ == 200) {
            this.func_146402_a(-1);
         } else if(p_73869_2_ == 208) {
            this.func_146402_a(1);
         } else if(p_73869_2_ == 201) {
            this.field_146297_k.field_71456_v.func_146158_b().func_146229_b(this.field_146297_k.field_71456_v.func_146158_b().func_146232_i() - 1);
         } else if(p_73869_2_ == 209) {
            this.field_146297_k.field_71456_v.func_146158_b().func_146229_b(-this.field_146297_k.field_71456_v.func_146158_b().func_146232_i() + 1);
         } else {
            this.field_146415_a.func_146201_a(p_73869_1_, p_73869_2_);
         }
      } else {
         String var3 = this.field_146415_a.func_146179_b().trim();
         if(var3.length() > 0) {
            this.func_146403_a(var3);
         }

         this.field_146297_k.func_147108_a((GuiScreen)null);
      }

   }

   public void func_146403_a(String p_146403_1_) {
      this.field_146297_k.field_71456_v.func_146158_b().func_146239_a(p_146403_1_);
      this.field_146297_k.field_71439_g.func_71165_d(p_146403_1_);
   }

   public void func_146274_d() {
      super.func_146274_d();
      int var1 = Mouse.getEventDWheel();
      if(var1 != 0) {
         if(var1 > 1) {
            var1 = 1;
         }

         if(var1 < -1) {
            var1 = -1;
         }

         if(!func_146272_n()) {
            var1 *= 7;
         }

         this.field_146297_k.field_71456_v.func_146158_b().func_146229_b(var1);
      }

   }

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
      if(p_73864_3_ == 0 && this.field_146297_k.field_71474_y.field_74359_p) {
         IChatComponent var4 = this.field_146297_k.field_71456_v.func_146158_b().func_146236_a(Mouse.getX(), Mouse.getY());
         if(var4 != null) {
            ClickEvent var5 = var4.func_150256_b().func_150235_h();
            if(var5 != null) {
               if(func_146272_n()) {
                  this.field_146415_a.func_146191_b(var4.func_150261_e());
               } else {
                  URI var6;
                  if(var5.func_150669_a() == ClickEvent.Action.OPEN_URL) {
                     try {
                        var6 = new URI(var5.func_150668_b());
                        if(!field_152175_f.contains(var6.getScheme().toLowerCase())) {
                           throw new URISyntaxException(var5.func_150668_b(), "Unsupported protocol: " + var6.getScheme().toLowerCase());
                        }

                        if(this.field_146297_k.field_71474_y.field_74358_q) {
                           this.field_146411_u = var6;
                           this.field_146297_k.func_147108_a(new GuiConfirmOpenLink(this, var5.func_150668_b(), 0, false));
                        } else {
                           this.func_146407_a(var6);
                        }
                     } catch (URISyntaxException var7) {
                        field_146408_f.error("Can\'t open url for " + var5, var7);
                     }
                  } else if(var5.func_150669_a() == ClickEvent.Action.OPEN_FILE) {
                     var6 = (new File(var5.func_150668_b())).toURI();
                     this.func_146407_a(var6);
                  } else if(var5.func_150669_a() == ClickEvent.Action.SUGGEST_COMMAND) {
                     this.field_146415_a.func_146180_a(var5.func_150668_b());
                  } else if(var5.func_150669_a() == ClickEvent.Action.RUN_COMMAND) {
                     this.func_146403_a(var5.func_150668_b());
                  } else if(var5.func_150669_a() == ClickEvent.Action.TWITCH_USER_INFO) {
                     ChatUserInfo var8 = this.field_146297_k.func_152346_Z().func_152926_a(var5.func_150668_b());
                     if(var8 != null) {
                        this.field_146297_k.func_147108_a(new GuiTwitchUserMode(this.field_146297_k.func_152346_Z(), var8));
                     } else {
                        field_146408_f.error("Tried to handle twitch user but couldn\'t find them!");
                     }
                  } else {
                     field_146408_f.error("Don\'t know how to handle " + var5);
                  }
               }

               return;
            }
         }
      }

      this.field_146415_a.func_146192_a(p_73864_1_, p_73864_2_, p_73864_3_);
      super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
   }

   public void func_73878_a(boolean p_73878_1_, int p_73878_2_) {
      if(p_73878_2_ == 0) {
         if(p_73878_1_) {
            this.func_146407_a(this.field_146411_u);
         }

         this.field_146411_u = null;
         this.field_146297_k.func_147108_a(this);
      }

   }

   private void func_146407_a(URI p_146407_1_) {
      try {
         Class var2 = Class.forName("java.awt.Desktop");
         Object var3 = var2.getMethod("getDesktop", new Class[0]).invoke((Object)null, new Object[0]);
         var2.getMethod("browse", new Class[]{URI.class}).invoke(var3, new Object[]{p_146407_1_});
      } catch (Throwable var4) {
         field_146408_f.error("Couldn\'t open link", var4);
      }

   }

   public void func_146404_p_() {
      String var3;
      if(this.field_146417_i) {
         this.field_146415_a.func_146175_b(this.field_146415_a.func_146197_a(-1, this.field_146415_a.func_146198_h(), false) - this.field_146415_a.func_146198_h());
         if(this.field_146413_s >= this.field_146412_t.size()) {
            this.field_146413_s = 0;
         }
      } else {
         int var1 = this.field_146415_a.func_146197_a(-1, this.field_146415_a.func_146198_h(), false);
         this.field_146412_t.clear();
         this.field_146413_s = 0;
         String var2 = this.field_146415_a.func_146179_b().substring(var1).toLowerCase();
         var3 = this.field_146415_a.func_146179_b().substring(0, this.field_146415_a.func_146198_h());
         this.func_146405_a(var3, var2);
         if(this.field_146412_t.isEmpty()) {
            return;
         }

         this.field_146417_i = true;
         this.field_146415_a.func_146175_b(var1 - this.field_146415_a.func_146198_h());
      }

      if(this.field_146412_t.size() > 1) {
         StringBuilder var4 = new StringBuilder();

         for(Iterator var5 = this.field_146412_t.iterator(); var5.hasNext(); var4.append(var3)) {
            var3 = (String)var5.next();
            if(var4.length() > 0) {
               var4.append(", ");
            }
         }

         this.field_146297_k.field_71456_v.func_146158_b().func_146234_a(new ChatComponentText(var4.toString()), 1);
      }

      this.field_146415_a.func_146191_b((String)this.field_146412_t.get(this.field_146413_s++));
   }

   private void func_146405_a(String p_146405_1_, String p_146405_2_) {
      if(p_146405_1_.length() >= 1) {
         this.field_146297_k.field_71439_g.field_71174_a.func_147297_a(new C14PacketTabComplete(p_146405_1_));
         this.field_146414_r = true;
      }
   }

   public void func_146402_a(int p_146402_1_) {
      int var2 = this.field_146416_h + p_146402_1_;
      int var3 = this.field_146297_k.field_71456_v.func_146158_b().func_146238_c().size();
      if(var2 < 0) {
         var2 = 0;
      }

      if(var2 > var3) {
         var2 = var3;
      }

      if(var2 != this.field_146416_h) {
         if(var2 == var3) {
            this.field_146416_h = var3;
            this.field_146415_a.func_146180_a(this.field_146410_g);
         } else {
            if(this.field_146416_h == var3) {
               this.field_146410_g = this.field_146415_a.func_146179_b();
            }

            this.field_146415_a.func_146180_a((String)this.field_146297_k.field_71456_v.func_146158_b().func_146238_c().get(var2));
            this.field_146416_h = var2;
         }
      }
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      func_73734_a(2, this.field_146295_m - 14, this.field_146294_l - 2, this.field_146295_m - 2, Integer.MIN_VALUE);
      this.field_146415_a.func_146194_f();
      IChatComponent var4 = this.field_146297_k.field_71456_v.func_146158_b().func_146236_a(Mouse.getX(), Mouse.getY());
      if(var4 != null && var4.func_150256_b().func_150210_i() != null) {
         HoverEvent var5 = var4.func_150256_b().func_150210_i();
         if(var5.func_150701_a() == HoverEvent.Action.SHOW_ITEM) {
            ItemStack var6 = null;

            try {
               NBTBase var7 = JsonToNBT.func_150315_a(var5.func_150702_b().func_150260_c());
               if(var7 != null && var7 instanceof NBTTagCompound) {
                  var6 = ItemStack.func_77949_a((NBTTagCompound)var7);
               }
            } catch (NBTException var11) {
               ;
            }

            if(var6 != null) {
               this.func_146285_a(var6, p_73863_1_, p_73863_2_);
            } else {
               this.func_146279_a(EnumChatFormatting.RED + "Invalid Item!", p_73863_1_, p_73863_2_);
            }
         } else if(var5.func_150701_a() == HoverEvent.Action.SHOW_TEXT) {
            this.func_146283_a(Splitter.on("\n").splitToList(var5.func_150702_b().func_150254_d()), p_73863_1_, p_73863_2_);
         } else if(var5.func_150701_a() == HoverEvent.Action.SHOW_ACHIEVEMENT) {
            StatBase var12 = StatList.func_151177_a(var5.func_150702_b().func_150260_c());
            if(var12 != null) {
               IChatComponent var13 = var12.func_150951_e();
               ChatComponentTranslation var8 = new ChatComponentTranslation("stats.tooltip.type." + (var12.func_75967_d()?"achievement":"statistic"), new Object[0]);
               var8.func_150256_b().func_150217_b(Boolean.valueOf(true));
               String var9 = var12 instanceof Achievement?((Achievement)var12).func_75989_e():null;
               ArrayList var10 = Lists.newArrayList(new String[]{var13.func_150254_d(), var8.func_150254_d()});
               if(var9 != null) {
                  var10.addAll(this.field_146289_q.func_78271_c(var9, 150));
               }

               this.func_146283_a(var10, p_73863_1_, p_73863_2_);
            } else {
               this.func_146279_a(EnumChatFormatting.RED + "Invalid statistic/achievement!", p_73863_1_, p_73863_2_);
            }
         }

         GL11.glDisable(2896);
      }

      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

   public void func_146406_a(String[] p_146406_1_) {
      if(this.field_146414_r) {
         this.field_146417_i = false;
         this.field_146412_t.clear();
         String[] var2 = p_146406_1_;
         int var3 = p_146406_1_.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            String var5 = var2[var4];
            if(var5.length() > 0) {
               this.field_146412_t.add(var5);
            }
         }

         String var6 = this.field_146415_a.func_146179_b().substring(this.field_146415_a.func_146197_a(-1, this.field_146415_a.func_146198_h(), false));
         String var7 = StringUtils.getCommonPrefix(p_146406_1_);
         if(var7.length() > 0 && !var6.equalsIgnoreCase(var7)) {
            this.field_146415_a.func_146175_b(this.field_146415_a.func_146197_a(-1, this.field_146415_a.func_146198_h(), false) - this.field_146415_a.func_146198_h());
            this.field_146415_a.func_146191_b(var7);
         } else if(this.field_146412_t.size() > 0) {
            this.field_146417_i = true;
            this.func_146404_p_();
         }
      }

   }

   public boolean func_73868_f() {
      return false;
   }

}
