package net.minecraft.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerDispenser;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiDispenser extends GuiContainer {

   private static final ResourceLocation field_147088_v = new ResourceLocation("textures/gui/container/dispenser.png");
   public TileEntityDispenser field_147089_u;
   private static final String __OBFID = "CL_00000765";


   public GuiDispenser(InventoryPlayer p_i1098_1_, TileEntityDispenser p_i1098_2_) {
      super(new ContainerDispenser(p_i1098_1_, p_i1098_2_));
      this.field_147089_u = p_i1098_2_;
   }

   protected void func_146979_b(int p_146979_1_, int p_146979_2_) {
      String var3 = this.field_147089_u.func_145818_k_()?this.field_147089_u.func_145825_b():I18n.func_135052_a(this.field_147089_u.func_145825_b(), new Object[0]);
      this.field_146289_q.func_78276_b(var3, this.field_146999_f / 2 - this.field_146289_q.func_78256_a(var3) / 2, 6, 4210752);
      this.field_146289_q.func_78276_b(I18n.func_135052_a("container.inventory", new Object[0]), 8, this.field_147000_g - 96 + 2, 4210752);
   }

   protected void func_146976_a(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_146297_k.func_110434_K().func_110577_a(field_147088_v);
      int var4 = (this.field_146294_l - this.field_146999_f) / 2;
      int var5 = (this.field_146295_m - this.field_147000_g) / 2;
      this.func_73729_b(var4, var5, 0, 0, this.field_146999_f, this.field_147000_g);
   }

}
