package net.minecraft.client.renderer.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityPiston;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class TileEntityRendererPiston extends TileEntitySpecialRenderer {

   private RenderBlocks field_147516_b;
   private static final String __OBFID = "CL_00000969";


   public void func_147500_a(TileEntityPiston p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_) {
      Block var9 = p_147500_1_.func_145861_a();
      if(var9.func_149688_o() != Material.field_151579_a && p_147500_1_.func_145860_a(p_147500_8_) < 1.0F) {
         Tessellator var10 = Tessellator.field_78398_a;
         this.func_147499_a(TextureMap.field_110575_b);
         RenderHelper.func_74518_a();
         GL11.glBlendFunc(770, 771);
         GL11.glEnable(3042);
         GL11.glDisable(2884);
         if(Minecraft.func_71379_u()) {
            GL11.glShadeModel(7425);
         } else {
            GL11.glShadeModel(7424);
         }

         var10.func_78382_b();
         var10.func_78373_b((double)((float)p_147500_2_ - (float)p_147500_1_.field_145851_c + p_147500_1_.func_145865_b(p_147500_8_)), (double)((float)p_147500_4_ - (float)p_147500_1_.field_145848_d + p_147500_1_.func_145862_c(p_147500_8_)), (double)((float)p_147500_6_ - (float)p_147500_1_.field_145849_e + p_147500_1_.func_145859_d(p_147500_8_)));
         var10.func_78386_a(1.0F, 1.0F, 1.0F);
         if(var9 == Blocks.field_150332_K && p_147500_1_.func_145860_a(p_147500_8_) < 0.5F) {
            this.field_147516_b.func_147750_a(var9, p_147500_1_.field_145851_c, p_147500_1_.field_145848_d, p_147500_1_.field_145849_e, false);
         } else if(p_147500_1_.func_145867_d() && !p_147500_1_.func_145868_b()) {
            Blocks.field_150332_K.func_150086_a(((BlockPistonBase)var9).func_150073_e());
            this.field_147516_b.func_147750_a(Blocks.field_150332_K, p_147500_1_.field_145851_c, p_147500_1_.field_145848_d, p_147500_1_.field_145849_e, p_147500_1_.func_145860_a(p_147500_8_) < 0.5F);
            Blocks.field_150332_K.func_150087_e();
            var10.func_78373_b((double)((float)p_147500_2_ - (float)p_147500_1_.field_145851_c), (double)((float)p_147500_4_ - (float)p_147500_1_.field_145848_d), (double)((float)p_147500_6_ - (float)p_147500_1_.field_145849_e));
            this.field_147516_b.func_147804_d(var9, p_147500_1_.field_145851_c, p_147500_1_.field_145848_d, p_147500_1_.field_145849_e);
         } else {
            this.field_147516_b.func_147769_a(var9, p_147500_1_.field_145851_c, p_147500_1_.field_145848_d, p_147500_1_.field_145849_e);
         }

         var10.func_78373_b(0.0D, 0.0D, 0.0D);
         var10.func_78381_a();
         RenderHelper.func_74519_b();
      }
   }

   public void func_147496_a(World p_147496_1_) {
      this.field_147516_b = new RenderBlocks(p_147496_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_147500_a(TileEntity p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_) {
      this.func_147500_a((TileEntityPiston)p_147500_1_, p_147500_2_, p_147500_4_, p_147500_6_, p_147500_8_);
   }
}
