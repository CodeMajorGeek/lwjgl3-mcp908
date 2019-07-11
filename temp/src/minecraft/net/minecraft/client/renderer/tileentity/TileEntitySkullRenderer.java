package net.minecraft.client.renderer.tileentity;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelSkeletonHead;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TileEntitySkullRenderer extends TileEntitySpecialRenderer {

   private static final ResourceLocation field_147537_c = new ResourceLocation("textures/entity/skeleton/skeleton.png");
   private static final ResourceLocation field_147534_d = new ResourceLocation("textures/entity/skeleton/wither_skeleton.png");
   private static final ResourceLocation field_147535_e = new ResourceLocation("textures/entity/zombie/zombie.png");
   private static final ResourceLocation field_147532_f = new ResourceLocation("textures/entity/creeper/creeper.png");
   public static TileEntitySkullRenderer field_147536_b;
   private ModelSkeletonHead field_147533_g = new ModelSkeletonHead(0, 0, 64, 32);
   private ModelSkeletonHead field_147538_h = new ModelSkeletonHead(0, 0, 64, 64);
   private static final String __OBFID = "CL_00000971";


   public void func_147500_a(TileEntitySkull p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_) {
      this.func_152674_a((float)p_147500_2_, (float)p_147500_4_, (float)p_147500_6_, p_147500_1_.func_145832_p() & 7, (float)(p_147500_1_.func_145906_b() * 360) / 16.0F, p_147500_1_.func_145904_a(), p_147500_1_.func_152108_a());
   }

   public void func_147497_a(TileEntityRendererDispatcher p_147497_1_) {
      super.func_147497_a(p_147497_1_);
      field_147536_b = this;
   }

   public void func_152674_a(float p_152674_1_, float p_152674_2_, float p_152674_3_, int p_152674_4_, float p_152674_5_, int p_152674_6_, GameProfile p_152674_7_) {
      ModelSkeletonHead var8 = this.field_147533_g;
      switch(p_152674_6_) {
      case 0:
      default:
         this.func_147499_a(field_147537_c);
         break;
      case 1:
         this.func_147499_a(field_147534_d);
         break;
      case 2:
         this.func_147499_a(field_147535_e);
         var8 = this.field_147538_h;
         break;
      case 3:
         ResourceLocation var9 = AbstractClientPlayer.field_110314_b;
         if(p_152674_7_ != null) {
            Minecraft var10 = Minecraft.func_71410_x();
            Map var11 = var10.func_152342_ad().func_152788_a(p_152674_7_);
            if(var11.containsKey(Type.SKIN)) {
               var9 = var10.func_152342_ad().func_152792_a((MinecraftProfileTexture)var11.get(Type.SKIN), Type.SKIN);
            }
         }

         this.func_147499_a(var9);
         break;
      case 4:
         this.func_147499_a(field_147532_f);
      }

      GL11.glPushMatrix();
      GL11.glDisable(2884);
      if(p_152674_4_ != 1) {
         switch(p_152674_4_) {
         case 2:
            GL11.glTranslatef(p_152674_1_ + 0.5F, p_152674_2_ + 0.25F, p_152674_3_ + 0.74F);
            break;
         case 3:
            GL11.glTranslatef(p_152674_1_ + 0.5F, p_152674_2_ + 0.25F, p_152674_3_ + 0.26F);
            p_152674_5_ = 180.0F;
            break;
         case 4:
            GL11.glTranslatef(p_152674_1_ + 0.74F, p_152674_2_ + 0.25F, p_152674_3_ + 0.5F);
            p_152674_5_ = 270.0F;
            break;
         case 5:
         default:
            GL11.glTranslatef(p_152674_1_ + 0.26F, p_152674_2_ + 0.25F, p_152674_3_ + 0.5F);
            p_152674_5_ = 90.0F;
         }
      } else {
         GL11.glTranslatef(p_152674_1_ + 0.5F, p_152674_2_, p_152674_3_ + 0.5F);
      }

      float var12 = 0.0625F;
      GL11.glEnable('\u803a');
      GL11.glScalef(-1.0F, -1.0F, 1.0F);
      GL11.glEnable(3008);
      var8.func_78088_a((Entity)null, 0.0F, 0.0F, 0.0F, p_152674_5_, 0.0F, var12);
      GL11.glPopMatrix();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_147500_a(TileEntity p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_) {
      this.func_147500_a((TileEntitySkull)p_147500_1_, p_147500_2_, p_147500_4_, p_147500_6_, p_147500_8_);
   }

}
