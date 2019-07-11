package net.minecraft.client.renderer.texture;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import javax.imageio.ImageIO;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.StitcherException;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.ITickableTextureObject;
import net.minecraft.client.renderer.texture.Stitcher;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureClock;
import net.minecraft.client.renderer.texture.TextureCompass;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.data.AnimationMetadataSection;
import net.minecraft.client.resources.data.TextureMetadataSection;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextureMap extends AbstractTexture implements ITickableTextureObject, IIconRegister {

   private static final Logger field_147635_d = LogManager.getLogger();
   public static final ResourceLocation field_110575_b = new ResourceLocation("textures/atlas/blocks.png");
   public static final ResourceLocation field_110576_c = new ResourceLocation("textures/atlas/items.png");
   private final List field_94258_i = Lists.newArrayList();
   private final Map field_110574_e = Maps.newHashMap();
   private final Map field_94252_e = Maps.newHashMap();
   private final int field_94255_a;
   private final String field_94254_c;
   private int field_147636_j;
   private int field_147637_k = 1;
   private final TextureAtlasSprite field_94249_f = new TextureAtlasSprite("missingno");
   private static final String __OBFID = "CL_00001058";


   public TextureMap(int p_i1281_1_, String p_i1281_2_) {
      this.field_94255_a = p_i1281_1_;
      this.field_94254_c = p_i1281_2_;
      this.func_110573_f();
   }

   private void func_110569_e() {
      int[] var1;
      if((float)this.field_147637_k > 1.0F) {
         boolean var2 = true;
         boolean var3 = true;
         boolean var4 = true;
         this.field_94249_f.func_110966_b(32);
         this.field_94249_f.func_110969_c(32);
         var1 = new int[1024];
         System.arraycopy(TextureUtil.field_110999_b, 0, var1, 0, TextureUtil.field_110999_b.length);
         TextureUtil.func_147948_a(var1, 16, 16, 8);
      } else {
         var1 = TextureUtil.field_110999_b;
         this.field_94249_f.func_110966_b(16);
         this.field_94249_f.func_110969_c(16);
      }

      int[][] var5 = new int[this.field_147636_j + 1][];
      var5[0] = var1;
      this.field_94249_f.func_110968_a(Lists.newArrayList(new int[][][]{var5}));
   }

   public void func_110551_a(IResourceManager p_110551_1_) throws IOException {
      this.func_110569_e();
      this.func_147631_c();
      this.func_110571_b(p_110551_1_);
   }

   public void func_110571_b(IResourceManager p_110571_1_) {
      int var2 = Minecraft.func_71369_N();
      Stitcher var3 = new Stitcher(var2, var2, true, 0, this.field_147636_j);
      this.field_94252_e.clear();
      this.field_94258_i.clear();
      int var4 = Integer.MAX_VALUE;
      Iterator var5 = this.field_110574_e.entrySet().iterator();

      TextureAtlasSprite var8;
      while(var5.hasNext()) {
         Entry var6 = (Entry)var5.next();
         ResourceLocation var7 = new ResourceLocation((String)var6.getKey());
         var8 = (TextureAtlasSprite)var6.getValue();
         ResourceLocation var9 = this.func_147634_a(var7, 0);

         try {
            IResource var10 = p_110571_1_.func_110536_a(var9);
            BufferedImage[] var11 = new BufferedImage[1 + this.field_147636_j];
            var11[0] = ImageIO.read(var10.func_110527_b());
            TextureMetadataSection var12 = (TextureMetadataSection)var10.func_110526_a("texture");
            if(var12 != null) {
               List var13 = var12.func_148535_c();
               int var15;
               if(!var13.isEmpty()) {
                  int var14 = var11[0].getWidth();
                  var15 = var11[0].getHeight();
                  if(MathHelper.func_151236_b(var14) != var14 || MathHelper.func_151236_b(var15) != var15) {
                     throw new RuntimeException("Unable to load extra miplevels, source-texture is not power of two");
                  }
               }

               Iterator var35 = var13.iterator();

               while(var35.hasNext()) {
                  var15 = ((Integer)var35.next()).intValue();
                  if(var15 > 0 && var15 < var11.length - 1 && var11[var15] == null) {
                     ResourceLocation var16 = this.func_147634_a(var7, var15);

                     try {
                        var11[var15] = ImageIO.read(p_110571_1_.func_110536_a(var16).func_110527_b());
                     } catch (IOException var21) {
                        field_147635_d.error("Unable to load miplevel {} from: {}", new Object[]{Integer.valueOf(var15), var16, var21});
                     }
                  }
               }
            }

            AnimationMetadataSection var34 = (AnimationMetadataSection)var10.func_110526_a("animation");
            var8.func_147964_a(var11, var34, (float)this.field_147637_k > 1.0F);
         } catch (RuntimeException var22) {
            field_147635_d.error("Unable to parse metadata from " + var9, var22);
            continue;
         } catch (IOException var23) {
            field_147635_d.error("Using missing texture, unable to load " + var9, var23);
            continue;
         }

         var4 = Math.min(var4, Math.min(var8.func_94211_a(), var8.func_94216_b()));
         var3.func_110934_a(var8);
      }

      int var24 = MathHelper.func_151239_c(var4);
      if(var24 < this.field_147636_j) {
         field_147635_d.debug("{}: dropping miplevel from {} to {}, because of minTexel: {}", new Object[]{this.field_94254_c, Integer.valueOf(this.field_147636_j), Integer.valueOf(var24), Integer.valueOf(var4)});
         this.field_147636_j = var24;
      }

      Iterator var25 = this.field_110574_e.values().iterator();

      while(var25.hasNext()) {
         final TextureAtlasSprite var27 = (TextureAtlasSprite)var25.next();

         try {
            var27.func_147963_d(this.field_147636_j);
         } catch (Throwable var20) {
            CrashReport var29 = CrashReport.func_85055_a(var20, "Applying mipmap");
            CrashReportCategory var31 = var29.func_85058_a("Sprite being mipmapped");
            var31.func_71500_a("Sprite name", new Callable() {

               private static final String __OBFID = "CL_00001059";

               public String call() {
                  return var27.func_94215_i();
               }
               // $FF: synthetic method
               public Object call() {
                  return this.call();
               }
            });
            var31.func_71500_a("Sprite size", new Callable() {

               private static final String __OBFID = "CL_00001060";

               public String call() {
                  return var27.func_94211_a() + " x " + var27.func_94216_b();
               }
               // $FF: synthetic method
               public Object call() {
                  return this.call();
               }
            });
            var31.func_71500_a("Sprite frames", new Callable() {

               private static final String __OBFID = "CL_00001061";

               public String call() {
                  return var27.func_110970_k() + " frames";
               }
               // $FF: synthetic method
               public Object call() {
                  return this.call();
               }
            });
            var31.func_71507_a("Mipmap levels", Integer.valueOf(this.field_147636_j));
            throw new ReportedException(var29);
         }
      }

      this.field_94249_f.func_147963_d(this.field_147636_j);
      var3.func_110934_a(this.field_94249_f);

      try {
         var3.func_94305_f();
      } catch (StitcherException var19) {
         throw var19;
      }

      field_147635_d.info("Created: {}x{} {}-atlas", new Object[]{Integer.valueOf(var3.func_110935_a()), Integer.valueOf(var3.func_110936_b()), this.field_94254_c});
      TextureUtil.func_147946_a(this.func_110552_b(), this.field_147636_j, var3.func_110935_a(), var3.func_110936_b(), (float)this.field_147637_k);
      HashMap var26 = Maps.newHashMap(this.field_110574_e);
      Iterator var28 = var3.func_94309_g().iterator();

      while(var28.hasNext()) {
         var8 = (TextureAtlasSprite)var28.next();
         String var30 = var8.func_94215_i();
         var26.remove(var30);
         this.field_94252_e.put(var30, var8);

         try {
            TextureUtil.func_147955_a(var8.func_147965_a(0), var8.func_94211_a(), var8.func_94216_b(), var8.func_130010_a(), var8.func_110967_i(), false, false);
         } catch (Throwable var18) {
            CrashReport var32 = CrashReport.func_85055_a(var18, "Stitching texture atlas");
            CrashReportCategory var33 = var32.func_85058_a("Texture being stitched together");
            var33.func_71507_a("Atlas path", this.field_94254_c);
            var33.func_71507_a("Sprite", var8);
            throw new ReportedException(var32);
         }

         if(var8.func_130098_m()) {
            this.field_94258_i.add(var8);
         } else {
            var8.func_130103_l();
         }
      }

      var28 = var26.values().iterator();

      while(var28.hasNext()) {
         var8 = (TextureAtlasSprite)var28.next();
         var8.func_94217_a(this.field_94249_f);
      }

   }

   private ResourceLocation func_147634_a(ResourceLocation p_147634_1_, int p_147634_2_) {
      return p_147634_2_ == 0?new ResourceLocation(p_147634_1_.func_110624_b(), String.format("%s/%s%s", new Object[]{this.field_94254_c, p_147634_1_.func_110623_a(), ".png"})):new ResourceLocation(p_147634_1_.func_110624_b(), String.format("%s/mipmaps/%s.%d%s", new Object[]{this.field_94254_c, p_147634_1_.func_110623_a(), Integer.valueOf(p_147634_2_), ".png"}));
   }

   private void func_110573_f() {
      this.field_110574_e.clear();
      Iterator var1;
      if(this.field_94255_a == 0) {
         var1 = Block.field_149771_c.iterator();

         while(var1.hasNext()) {
            Block var2 = (Block)var1.next();
            if(var2.func_149688_o() != Material.field_151579_a) {
               var2.func_149651_a(this);
            }
         }

         Minecraft.func_71410_x().field_71438_f.func_94140_a(this);
         RenderManager.field_78727_a.func_94178_a(this);
      }

      var1 = Item.field_150901_e.iterator();

      while(var1.hasNext()) {
         Item var3 = (Item)var1.next();
         if(var3 != null && var3.func_94901_k() == this.field_94255_a) {
            var3.func_94581_a(this);
         }
      }

   }

   public TextureAtlasSprite func_110572_b(String p_110572_1_) {
      TextureAtlasSprite var2 = (TextureAtlasSprite)this.field_94252_e.get(p_110572_1_);
      if(var2 == null) {
         var2 = this.field_94249_f;
      }

      return var2;
   }

   public void func_94248_c() {
      TextureUtil.func_94277_a(this.func_110552_b());
      Iterator var1 = this.field_94258_i.iterator();

      while(var1.hasNext()) {
         TextureAtlasSprite var2 = (TextureAtlasSprite)var1.next();
         var2.func_94219_l();
      }

   }

   public IIcon func_94245_a(String p_94245_1_) {
      if(p_94245_1_ == null) {
         throw new IllegalArgumentException("Name cannot be null!");
      } else if(p_94245_1_.indexOf(47) == -1 && p_94245_1_.indexOf(92) == -1) {
         Object var2 = (TextureAtlasSprite)this.field_110574_e.get(p_94245_1_);
         if(var2 == null) {
            if(this.field_94255_a == 1) {
               if("clock".equals(p_94245_1_)) {
                  var2 = new TextureClock(p_94245_1_);
               } else if("compass".equals(p_94245_1_)) {
                  var2 = new TextureCompass(p_94245_1_);
               } else {
                  var2 = new TextureAtlasSprite(p_94245_1_);
               }
            } else {
               var2 = new TextureAtlasSprite(p_94245_1_);
            }

            this.field_110574_e.put(p_94245_1_, var2);
         }

         return (IIcon)var2;
      } else {
         throw new IllegalArgumentException("Name cannot contain slashes!");
      }
   }

   public int func_130086_a() {
      return this.field_94255_a;
   }

   public void func_110550_d() {
      this.func_94248_c();
   }

   public void func_147633_a(int p_147633_1_) {
      this.field_147636_j = p_147633_1_;
   }

   public void func_147632_b(int p_147632_1_) {
      this.field_147637_k = p_147632_1_;
   }

}
