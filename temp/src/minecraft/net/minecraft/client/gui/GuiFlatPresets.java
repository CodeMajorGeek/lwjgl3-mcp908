package net.minecraft.client.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiCreateFlatWorld;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.FlatGeneratorInfo;
import net.minecraft.world.gen.FlatLayerInfo;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class GuiFlatPresets extends GuiScreen {

   private static RenderItem field_146437_a = new RenderItem();
   private static final List field_146431_f = new ArrayList();
   private final GuiCreateFlatWorld field_146432_g;
   private String field_146438_h;
   private String field_146439_i;
   private String field_146436_r;
   private GuiFlatPresets.ListSlot field_146435_s;
   private GuiButton field_146434_t;
   private GuiTextField field_146433_u;
   private static final String __OBFID = "CL_00000704";


   public GuiFlatPresets(GuiCreateFlatWorld p_i1049_1_) {
      this.field_146432_g = p_i1049_1_;
   }

   public void func_73866_w_() {
      this.field_146292_n.clear();
      Keyboard.enableRepeatEvents(true);
      this.field_146438_h = I18n.func_135052_a("createWorld.customize.presets.title", new Object[0]);
      this.field_146439_i = I18n.func_135052_a("createWorld.customize.presets.share", new Object[0]);
      this.field_146436_r = I18n.func_135052_a("createWorld.customize.presets.list", new Object[0]);
      this.field_146433_u = new GuiTextField(this.field_146289_q, 50, 40, this.field_146294_l - 100, 20);
      this.field_146435_s = new GuiFlatPresets.ListSlot();
      this.field_146433_u.func_146203_f(1230);
      this.field_146433_u.func_146180_a(this.field_146432_g.func_146384_e());
      this.field_146292_n.add(this.field_146434_t = new GuiButton(0, this.field_146294_l / 2 - 155, this.field_146295_m - 28, 150, 20, I18n.func_135052_a("createWorld.customize.presets.select", new Object[0])));
      this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 + 5, this.field_146295_m - 28, 150, 20, I18n.func_135052_a("gui.cancel", new Object[0])));
      this.func_146426_g();
   }

   public void func_146281_b() {
      Keyboard.enableRepeatEvents(false);
   }

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
      this.field_146433_u.func_146192_a(p_73864_1_, p_73864_2_, p_73864_3_);
      super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
      if(!this.field_146433_u.func_146201_a(p_73869_1_, p_73869_2_)) {
         super.func_73869_a(p_73869_1_, p_73869_2_);
      }

   }

   protected void func_146284_a(GuiButton p_146284_1_) {
      if(p_146284_1_.field_146127_k == 0 && this.func_146430_p()) {
         this.field_146432_g.func_146383_a(this.field_146433_u.func_146179_b());
         this.field_146297_k.func_147108_a(this.field_146432_g);
      } else if(p_146284_1_.field_146127_k == 1) {
         this.field_146297_k.func_147108_a(this.field_146432_g);
      }

   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_146276_q_();
      this.field_146435_s.func_148128_a(p_73863_1_, p_73863_2_, p_73863_3_);
      this.func_73732_a(this.field_146289_q, this.field_146438_h, this.field_146294_l / 2, 8, 16777215);
      this.func_73731_b(this.field_146289_q, this.field_146439_i, 50, 30, 10526880);
      this.func_73731_b(this.field_146289_q, this.field_146436_r, 50, 70, 10526880);
      this.field_146433_u.func_146194_f();
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

   public void func_73876_c() {
      this.field_146433_u.func_146178_a();
      super.func_73876_c();
   }

   public void func_146426_g() {
      boolean var1 = this.func_146430_p();
      this.field_146434_t.field_146124_l = var1;
   }

   private boolean func_146430_p() {
      return this.field_146435_s.field_148175_k > -1 && this.field_146435_s.field_148175_k < field_146431_f.size() || this.field_146433_u.func_146179_b().length() > 1;
   }

   private static void func_146425_a(String p_146425_0_, Item p_146425_1_, BiomeGenBase p_146425_2_, FlatLayerInfo ... p_146425_3_) {
      func_146421_a(p_146425_0_, p_146425_1_, p_146425_2_, (List)null, p_146425_3_);
   }

   private static void func_146421_a(String p_146421_0_, Item p_146421_1_, BiomeGenBase p_146421_2_, List p_146421_3_, FlatLayerInfo ... p_146421_4_) {
      FlatGeneratorInfo var5 = new FlatGeneratorInfo();

      for(int var6 = p_146421_4_.length - 1; var6 >= 0; --var6) {
         var5.func_82650_c().add(p_146421_4_[var6]);
      }

      var5.func_82647_a(p_146421_2_.field_76756_M);
      var5.func_82645_d();
      if(p_146421_3_ != null) {
         Iterator var8 = p_146421_3_.iterator();

         while(var8.hasNext()) {
            String var7 = (String)var8.next();
            var5.func_82644_b().put(var7, new HashMap());
         }
      }

      field_146431_f.add(new GuiFlatPresets.LayerItem(p_146421_1_, p_146421_0_, var5.toString()));
   }

   static {
      func_146421_a("Classic Flat", Item.func_150898_a(Blocks.field_150349_c), BiomeGenBase.field_76772_c, Arrays.asList(new String[]{"village"}), new FlatLayerInfo[]{new FlatLayerInfo(1, Blocks.field_150349_c), new FlatLayerInfo(2, Blocks.field_150346_d), new FlatLayerInfo(1, Blocks.field_150357_h)});
      func_146421_a("Tunnelers\' Dream", Item.func_150898_a(Blocks.field_150348_b), BiomeGenBase.field_76770_e, Arrays.asList(new String[]{"biome_1", "dungeon", "decoration", "stronghold", "mineshaft"}), new FlatLayerInfo[]{new FlatLayerInfo(1, Blocks.field_150349_c), new FlatLayerInfo(5, Blocks.field_150346_d), new FlatLayerInfo(230, Blocks.field_150348_b), new FlatLayerInfo(1, Blocks.field_150357_h)});
      func_146421_a("Water World", Item.func_150898_a(Blocks.field_150358_i), BiomeGenBase.field_76772_c, Arrays.asList(new String[]{"village", "biome_1"}), new FlatLayerInfo[]{new FlatLayerInfo(90, Blocks.field_150355_j), new FlatLayerInfo(5, Blocks.field_150354_m), new FlatLayerInfo(5, Blocks.field_150346_d), new FlatLayerInfo(5, Blocks.field_150348_b), new FlatLayerInfo(1, Blocks.field_150357_h)});
      func_146421_a("Overworld", Item.func_150898_a(Blocks.field_150329_H), BiomeGenBase.field_76772_c, Arrays.asList(new String[]{"village", "biome_1", "decoration", "stronghold", "mineshaft", "dungeon", "lake", "lava_lake"}), new FlatLayerInfo[]{new FlatLayerInfo(1, Blocks.field_150349_c), new FlatLayerInfo(3, Blocks.field_150346_d), new FlatLayerInfo(59, Blocks.field_150348_b), new FlatLayerInfo(1, Blocks.field_150357_h)});
      func_146421_a("Snowy Kingdom", Item.func_150898_a(Blocks.field_150431_aC), BiomeGenBase.field_76774_n, Arrays.asList(new String[]{"village", "biome_1"}), new FlatLayerInfo[]{new FlatLayerInfo(1, Blocks.field_150431_aC), new FlatLayerInfo(1, Blocks.field_150349_c), new FlatLayerInfo(3, Blocks.field_150346_d), new FlatLayerInfo(59, Blocks.field_150348_b), new FlatLayerInfo(1, Blocks.field_150357_h)});
      func_146421_a("Bottomless Pit", Items.field_151008_G, BiomeGenBase.field_76772_c, Arrays.asList(new String[]{"village", "biome_1"}), new FlatLayerInfo[]{new FlatLayerInfo(1, Blocks.field_150349_c), new FlatLayerInfo(3, Blocks.field_150346_d), new FlatLayerInfo(2, Blocks.field_150347_e)});
      func_146421_a("Desert", Item.func_150898_a(Blocks.field_150354_m), BiomeGenBase.field_76769_d, Arrays.asList(new String[]{"village", "biome_1", "decoration", "stronghold", "mineshaft", "dungeon"}), new FlatLayerInfo[]{new FlatLayerInfo(8, Blocks.field_150354_m), new FlatLayerInfo(52, Blocks.field_150322_A), new FlatLayerInfo(3, Blocks.field_150348_b), new FlatLayerInfo(1, Blocks.field_150357_h)});
      func_146425_a("Redstone Ready", Items.field_151137_ax, BiomeGenBase.field_76769_d, new FlatLayerInfo[]{new FlatLayerInfo(52, Blocks.field_150322_A), new FlatLayerInfo(3, Blocks.field_150348_b), new FlatLayerInfo(1, Blocks.field_150357_h)});
   }

   static class LayerItem {

      public Item field_148234_a;
      public String field_148232_b;
      public String field_148233_c;
      private static final String __OBFID = "CL_00000705";


      public LayerItem(Item p_i45022_1_, String p_i45022_2_, String p_i45022_3_) {
         this.field_148234_a = p_i45022_1_;
         this.field_148232_b = p_i45022_2_;
         this.field_148233_c = p_i45022_3_;
      }
   }

   class ListSlot extends GuiSlot {

      public int field_148175_k = -1;
      private static final String __OBFID = "CL_00000706";


      public ListSlot() {
         super(GuiFlatPresets.this.field_146297_k, GuiFlatPresets.this.field_146294_l, GuiFlatPresets.this.field_146295_m, 80, GuiFlatPresets.this.field_146295_m - 37, 24);
      }

      private void func_148172_a(int p_148172_1_, int p_148172_2_, Item p_148172_3_) {
         this.func_148173_e(p_148172_1_ + 1, p_148172_2_ + 1);
         GL11.glEnable('\u803a');
         RenderHelper.func_74520_c();
         GuiFlatPresets.field_146437_a.func_77015_a(GuiFlatPresets.this.field_146289_q, GuiFlatPresets.this.field_146297_k.func_110434_K(), new ItemStack(p_148172_3_, 1, 0), p_148172_1_ + 2, p_148172_2_ + 2);
         RenderHelper.func_74518_a();
         GL11.glDisable('\u803a');
      }

      private void func_148173_e(int p_148173_1_, int p_148173_2_) {
         this.func_148171_c(p_148173_1_, p_148173_2_, 0, 0);
      }

      private void func_148171_c(int p_148171_1_, int p_148171_2_, int p_148171_3_, int p_148171_4_) {
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GuiFlatPresets.this.field_146297_k.func_110434_K().func_110577_a(Gui.field_110323_l);
         float var5 = 0.0078125F;
         float var6 = 0.0078125F;
         boolean var7 = true;
         boolean var8 = true;
         Tessellator var9 = Tessellator.field_78398_a;
         var9.func_78382_b();
         var9.func_78374_a((double)(p_148171_1_ + 0), (double)(p_148171_2_ + 18), (double)GuiFlatPresets.this.field_73735_i, (double)((float)(p_148171_3_ + 0) * 0.0078125F), (double)((float)(p_148171_4_ + 18) * 0.0078125F));
         var9.func_78374_a((double)(p_148171_1_ + 18), (double)(p_148171_2_ + 18), (double)GuiFlatPresets.this.field_73735_i, (double)((float)(p_148171_3_ + 18) * 0.0078125F), (double)((float)(p_148171_4_ + 18) * 0.0078125F));
         var9.func_78374_a((double)(p_148171_1_ + 18), (double)(p_148171_2_ + 0), (double)GuiFlatPresets.this.field_73735_i, (double)((float)(p_148171_3_ + 18) * 0.0078125F), (double)((float)(p_148171_4_ + 0) * 0.0078125F));
         var9.func_78374_a((double)(p_148171_1_ + 0), (double)(p_148171_2_ + 0), (double)GuiFlatPresets.this.field_73735_i, (double)((float)(p_148171_3_ + 0) * 0.0078125F), (double)((float)(p_148171_4_ + 0) * 0.0078125F));
         var9.func_78381_a();
      }

      protected int func_148127_b() {
         return GuiFlatPresets.field_146431_f.size();
      }

      protected void func_148144_a(int p_148144_1_, boolean p_148144_2_, int p_148144_3_, int p_148144_4_) {
         this.field_148175_k = p_148144_1_;
         GuiFlatPresets.this.func_146426_g();
         GuiFlatPresets.this.field_146433_u.func_146180_a(((GuiFlatPresets.LayerItem)GuiFlatPresets.field_146431_f.get(GuiFlatPresets.this.field_146435_s.field_148175_k)).field_148233_c);
      }

      protected boolean func_148131_a(int p_148131_1_) {
         return p_148131_1_ == this.field_148175_k;
      }

      protected void func_148123_a() {}

      protected void func_148126_a(int p_148126_1_, int p_148126_2_, int p_148126_3_, int p_148126_4_, Tessellator p_148126_5_, int p_148126_6_, int p_148126_7_) {
         GuiFlatPresets.LayerItem var8 = (GuiFlatPresets.LayerItem)GuiFlatPresets.field_146431_f.get(p_148126_1_);
         this.func_148172_a(p_148126_2_, p_148126_3_, var8.field_148234_a);
         GuiFlatPresets.this.field_146289_q.func_78276_b(var8.field_148232_b, p_148126_2_ + 18 + 5, p_148126_3_ + 6, 16777215);
      }
   }
}
