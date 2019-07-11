package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.Tessellator;

public abstract class GuiListExtended extends GuiSlot {

   private static final String __OBFID = "CL_00000674";


   public GuiListExtended(Minecraft p_i45010_1_, int p_i45010_2_, int p_i45010_3_, int p_i45010_4_, int p_i45010_5_, int p_i45010_6_) {
      super(p_i45010_1_, p_i45010_2_, p_i45010_3_, p_i45010_4_, p_i45010_5_, p_i45010_6_);
   }

   protected void func_148144_a(int p_148144_1_, boolean p_148144_2_, int p_148144_3_, int p_148144_4_) {}

   protected boolean func_148131_a(int p_148131_1_) {
      return false;
   }

   protected void func_148123_a() {}

   protected void func_148126_a(int p_148126_1_, int p_148126_2_, int p_148126_3_, int p_148126_4_, Tessellator p_148126_5_, int p_148126_6_, int p_148126_7_) {
      this.func_148180_b(p_148126_1_).func_148279_a(p_148126_1_, p_148126_2_, p_148126_3_, this.func_148139_c(), p_148126_4_, p_148126_5_, p_148126_6_, p_148126_7_, this.func_148124_c(p_148126_6_, p_148126_7_) == p_148126_1_);
   }

   public boolean func_148179_a(int p_148179_1_, int p_148179_2_, int p_148179_3_) {
      if(this.func_148141_e(p_148179_2_)) {
         int var4 = this.func_148124_c(p_148179_1_, p_148179_2_);
         if(var4 >= 0) {
            int var5 = this.field_148152_e + this.field_148155_a / 2 - this.func_148139_c() / 2 + 2;
            int var6 = this.field_148153_b + 4 - this.func_148148_g() + var4 * this.field_148149_f + this.field_148160_j;
            int var7 = p_148179_1_ - var5;
            int var8 = p_148179_2_ - var6;
            if(this.func_148180_b(var4).func_148278_a(var4, p_148179_1_, p_148179_2_, p_148179_3_, var7, var8)) {
               this.func_148143_b(false);
               return true;
            }
         }
      }

      return false;
   }

   public boolean func_148181_b(int p_148181_1_, int p_148181_2_, int p_148181_3_) {
      for(int var4 = 0; var4 < this.func_148127_b(); ++var4) {
         int var5 = this.field_148152_e + this.field_148155_a / 2 - this.func_148139_c() / 2 + 2;
         int var6 = this.field_148153_b + 4 - this.func_148148_g() + var4 * this.field_148149_f + this.field_148160_j;
         int var7 = p_148181_1_ - var5;
         int var8 = p_148181_2_ - var6;
         this.func_148180_b(var4).func_148277_b(var4, p_148181_1_, p_148181_2_, p_148181_3_, var7, var8);
      }

      this.func_148143_b(true);
      return false;
   }

   public abstract GuiListExtended.IGuiListEntry func_148180_b(int var1);

   public interface IGuiListEntry {

      void func_148279_a(int var1, int var2, int var3, int var4, int var5, Tessellator var6, int var7, int var8, boolean var9);

      boolean func_148278_a(int var1, int var2, int var3, int var4, int var5, int var6);

      void func_148277_b(int var1, int var2, int var3, int var4, int var5, int var6);
   }
}
