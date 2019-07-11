package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBook;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderEnchantmentTable extends TileEntitySpecialRenderer {

   private static final ResourceLocation field_147540_b = new ResourceLocation("textures/entity/enchanting_table_book.png");
   private ModelBook field_147541_c = new ModelBook();
   private static final String __OBFID = "CL_00000966";


   public void func_147500_a(TileEntityEnchantmentTable p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)p_147500_2_ + 0.5F, (float)p_147500_4_ + 0.75F, (float)p_147500_6_ + 0.5F);
      float var9 = (float)p_147500_1_.field_145926_a + p_147500_8_;
      GL11.glTranslatef(0.0F, 0.1F + MathHelper.func_76126_a(var9 * 0.1F) * 0.01F, 0.0F);

      float var10;
      for(var10 = p_147500_1_.field_145928_o - p_147500_1_.field_145925_p; var10 >= 3.1415927F; var10 -= 6.2831855F) {
         ;
      }

      while(var10 < -3.1415927F) {
         var10 += 6.2831855F;
      }

      float var11 = p_147500_1_.field_145925_p + var10 * p_147500_8_;
      GL11.glRotatef(-var11 * 180.0F / 3.1415927F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(80.0F, 0.0F, 0.0F, 1.0F);
      this.func_147499_a(field_147540_b);
      float var12 = p_147500_1_.field_145931_j + (p_147500_1_.field_145933_i - p_147500_1_.field_145931_j) * p_147500_8_ + 0.25F;
      float var13 = p_147500_1_.field_145931_j + (p_147500_1_.field_145933_i - p_147500_1_.field_145931_j) * p_147500_8_ + 0.75F;
      var12 = (var12 - (float)MathHelper.func_76140_b((double)var12)) * 1.6F - 0.3F;
      var13 = (var13 - (float)MathHelper.func_76140_b((double)var13)) * 1.6F - 0.3F;
      if(var12 < 0.0F) {
         var12 = 0.0F;
      }

      if(var13 < 0.0F) {
         var13 = 0.0F;
      }

      if(var12 > 1.0F) {
         var12 = 1.0F;
      }

      if(var13 > 1.0F) {
         var13 = 1.0F;
      }

      float var14 = p_147500_1_.field_145927_n + (p_147500_1_.field_145930_m - p_147500_1_.field_145927_n) * p_147500_8_;
      GL11.glEnable(2884);
      this.field_147541_c.func_78088_a((Entity)null, var9, var12, var13, var14, 0.0F, 0.0625F);
      GL11.glPopMatrix();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_147500_a(TileEntity p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_) {
      this.func_147500_a((TileEntityEnchantmentTable)p_147500_1_, p_147500_2_, p_147500_4_, p_147500_6_, p_147500_8_);
   }

}
