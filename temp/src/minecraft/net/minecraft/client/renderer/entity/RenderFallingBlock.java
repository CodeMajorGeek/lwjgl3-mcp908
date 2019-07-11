package net.minecraft.client.renderer.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class RenderFallingBlock extends Render {

   private final RenderBlocks field_147920_a = new RenderBlocks();
   private static final String __OBFID = "CL_00000994";


   public RenderFallingBlock() {
      this.field_76989_e = 0.5F;
   }

   public void func_76986_a(EntityFallingBlock p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      World var10 = p_76986_1_.func_145807_e();
      Block var11 = p_76986_1_.func_145805_f();
      int var12 = MathHelper.func_76128_c(p_76986_1_.field_70165_t);
      int var13 = MathHelper.func_76128_c(p_76986_1_.field_70163_u);
      int var14 = MathHelper.func_76128_c(p_76986_1_.field_70161_v);
      if(var11 != null && var11 != var10.func_147439_a(var12, var13, var14)) {
         GL11.glPushMatrix();
         GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
         this.func_110777_b(p_76986_1_);
         GL11.glDisable(2896);
         Tessellator var15;
         if(var11 instanceof BlockAnvil) {
            this.field_147920_a.field_147845_a = var10;
            var15 = Tessellator.field_78398_a;
            var15.func_78382_b();
            var15.func_78373_b((double)((float)(-var12) - 0.5F), (double)((float)(-var13) - 0.5F), (double)((float)(-var14) - 0.5F));
            this.field_147920_a.func_147780_a((BlockAnvil)var11, var12, var13, var14, p_76986_1_.field_145814_a);
            var15.func_78373_b(0.0D, 0.0D, 0.0D);
            var15.func_78381_a();
         } else if(var11 instanceof BlockDragonEgg) {
            this.field_147920_a.field_147845_a = var10;
            var15 = Tessellator.field_78398_a;
            var15.func_78382_b();
            var15.func_78373_b((double)((float)(-var12) - 0.5F), (double)((float)(-var13) - 0.5F), (double)((float)(-var14) - 0.5F));
            this.field_147920_a.func_147802_a((BlockDragonEgg)var11, var12, var13, var14);
            var15.func_78373_b(0.0D, 0.0D, 0.0D);
            var15.func_78381_a();
         } else {
            this.field_147920_a.func_147775_a(var11);
            this.field_147920_a.func_147749_a(var11, var10, var12, var13, var14, p_76986_1_.field_145814_a);
         }

         GL11.glEnable(2896);
         GL11.glPopMatrix();
      }

   }

   protected ResourceLocation func_110775_a(EntityFallingBlock p_110775_1_) {
      return TextureMap.field_110575_b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntityFallingBlock)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityFallingBlock)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
