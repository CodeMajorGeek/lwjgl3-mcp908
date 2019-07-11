package net.minecraft.world.gen.structure;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemDoor;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.Direction;
import net.minecraft.util.Facing;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public abstract class StructureComponent {

   protected StructureBoundingBox field_74887_e;
   protected int field_74885_f;
   protected int field_74886_g;
   private static final String __OBFID = "CL_00000511";


   public StructureComponent() {}

   protected StructureComponent(int p_i2091_1_) {
      this.field_74886_g = p_i2091_1_;
      this.field_74885_f = -1;
   }

   public NBTTagCompound func_143010_b() {
      NBTTagCompound var1 = new NBTTagCompound();
      var1.func_74778_a("id", MapGenStructureIO.func_143036_a(this));
      var1.func_74782_a("BB", this.field_74887_e.func_151535_h());
      var1.func_74768_a("O", this.field_74885_f);
      var1.func_74768_a("GD", this.field_74886_g);
      this.func_143012_a(var1);
      return var1;
   }

   protected abstract void func_143012_a(NBTTagCompound var1);

   public void func_143009_a(World p_143009_1_, NBTTagCompound p_143009_2_) {
      if(p_143009_2_.func_74764_b("BB")) {
         this.field_74887_e = new StructureBoundingBox(p_143009_2_.func_74759_k("BB"));
      }

      this.field_74885_f = p_143009_2_.func_74762_e("O");
      this.field_74886_g = p_143009_2_.func_74762_e("GD");
      this.func_143011_b(p_143009_2_);
   }

   protected abstract void func_143011_b(NBTTagCompound var1);

   public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {}

   public abstract boolean func_74875_a(World var1, Random var2, StructureBoundingBox var3);

   public StructureBoundingBox func_74874_b() {
      return this.field_74887_e;
   }

   public int func_74877_c() {
      return this.field_74886_g;
   }

   public static StructureComponent func_74883_a(List p_74883_0_, StructureBoundingBox p_74883_1_) {
      Iterator var2 = p_74883_0_.iterator();

      StructureComponent var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (StructureComponent)var2.next();
      } while(var3.func_74874_b() == null || !var3.func_74874_b().func_78884_a(p_74883_1_));

      return var3;
   }

   public ChunkPosition func_151553_a() {
      return new ChunkPosition(this.field_74887_e.func_78881_e(), this.field_74887_e.func_78879_f(), this.field_74887_e.func_78891_g());
   }

   protected boolean func_74860_a(World p_74860_1_, StructureBoundingBox p_74860_2_) {
      int var3 = Math.max(this.field_74887_e.field_78897_a - 1, p_74860_2_.field_78897_a);
      int var4 = Math.max(this.field_74887_e.field_78895_b - 1, p_74860_2_.field_78895_b);
      int var5 = Math.max(this.field_74887_e.field_78896_c - 1, p_74860_2_.field_78896_c);
      int var6 = Math.min(this.field_74887_e.field_78893_d + 1, p_74860_2_.field_78893_d);
      int var7 = Math.min(this.field_74887_e.field_78894_e + 1, p_74860_2_.field_78894_e);
      int var8 = Math.min(this.field_74887_e.field_78892_f + 1, p_74860_2_.field_78892_f);

      int var9;
      int var10;
      for(var9 = var3; var9 <= var6; ++var9) {
         for(var10 = var5; var10 <= var8; ++var10) {
            if(p_74860_1_.func_147439_a(var9, var4, var10).func_149688_o().func_76224_d()) {
               return true;
            }

            if(p_74860_1_.func_147439_a(var9, var7, var10).func_149688_o().func_76224_d()) {
               return true;
            }
         }
      }

      for(var9 = var3; var9 <= var6; ++var9) {
         for(var10 = var4; var10 <= var7; ++var10) {
            if(p_74860_1_.func_147439_a(var9, var10, var5).func_149688_o().func_76224_d()) {
               return true;
            }

            if(p_74860_1_.func_147439_a(var9, var10, var8).func_149688_o().func_76224_d()) {
               return true;
            }
         }
      }

      for(var9 = var5; var9 <= var8; ++var9) {
         for(var10 = var4; var10 <= var7; ++var10) {
            if(p_74860_1_.func_147439_a(var3, var10, var9).func_149688_o().func_76224_d()) {
               return true;
            }

            if(p_74860_1_.func_147439_a(var6, var10, var9).func_149688_o().func_76224_d()) {
               return true;
            }
         }
      }

      return false;
   }

   protected int func_74865_a(int p_74865_1_, int p_74865_2_) {
      switch(this.field_74885_f) {
      case 0:
      case 2:
         return this.field_74887_e.field_78897_a + p_74865_1_;
      case 1:
         return this.field_74887_e.field_78893_d - p_74865_2_;
      case 3:
         return this.field_74887_e.field_78897_a + p_74865_2_;
      default:
         return p_74865_1_;
      }
   }

   protected int func_74862_a(int p_74862_1_) {
      return this.field_74885_f == -1?p_74862_1_:p_74862_1_ + this.field_74887_e.field_78895_b;
   }

   protected int func_74873_b(int p_74873_1_, int p_74873_2_) {
      switch(this.field_74885_f) {
      case 0:
         return this.field_74887_e.field_78896_c + p_74873_2_;
      case 1:
      case 3:
         return this.field_74887_e.field_78896_c + p_74873_1_;
      case 2:
         return this.field_74887_e.field_78892_f - p_74873_2_;
      default:
         return p_74873_2_;
      }
   }

   protected int func_151555_a(Block p_151555_1_, int p_151555_2_) {
      if(p_151555_1_ == Blocks.field_150448_aq) {
         if(this.field_74885_f == 1 || this.field_74885_f == 3) {
            if(p_151555_2_ == 1) {
               return 0;
            }

            return 1;
         }
      } else if(p_151555_1_ != Blocks.field_150466_ao && p_151555_1_ != Blocks.field_150454_av) {
         if(p_151555_1_ != Blocks.field_150446_ar && p_151555_1_ != Blocks.field_150476_ad && p_151555_1_ != Blocks.field_150387_bl && p_151555_1_ != Blocks.field_150390_bg && p_151555_1_ != Blocks.field_150372_bz) {
            if(p_151555_1_ == Blocks.field_150468_ap) {
               if(this.field_74885_f == 0) {
                  if(p_151555_2_ == 2) {
                     return 3;
                  }

                  if(p_151555_2_ == 3) {
                     return 2;
                  }
               } else if(this.field_74885_f == 1) {
                  if(p_151555_2_ == 2) {
                     return 4;
                  }

                  if(p_151555_2_ == 3) {
                     return 5;
                  }

                  if(p_151555_2_ == 4) {
                     return 2;
                  }

                  if(p_151555_2_ == 5) {
                     return 3;
                  }
               } else if(this.field_74885_f == 3) {
                  if(p_151555_2_ == 2) {
                     return 5;
                  }

                  if(p_151555_2_ == 3) {
                     return 4;
                  }

                  if(p_151555_2_ == 4) {
                     return 2;
                  }

                  if(p_151555_2_ == 5) {
                     return 3;
                  }
               }
            } else if(p_151555_1_ == Blocks.field_150430_aB) {
               if(this.field_74885_f == 0) {
                  if(p_151555_2_ == 3) {
                     return 4;
                  }

                  if(p_151555_2_ == 4) {
                     return 3;
                  }
               } else if(this.field_74885_f == 1) {
                  if(p_151555_2_ == 3) {
                     return 1;
                  }

                  if(p_151555_2_ == 4) {
                     return 2;
                  }

                  if(p_151555_2_ == 2) {
                     return 3;
                  }

                  if(p_151555_2_ == 1) {
                     return 4;
                  }
               } else if(this.field_74885_f == 3) {
                  if(p_151555_2_ == 3) {
                     return 2;
                  }

                  if(p_151555_2_ == 4) {
                     return 1;
                  }

                  if(p_151555_2_ == 2) {
                     return 3;
                  }

                  if(p_151555_2_ == 1) {
                     return 4;
                  }
               }
            } else if(p_151555_1_ != Blocks.field_150479_bC && !(p_151555_1_ instanceof BlockDirectional)) {
               if(p_151555_1_ == Blocks.field_150331_J || p_151555_1_ == Blocks.field_150320_F || p_151555_1_ == Blocks.field_150442_at || p_151555_1_ == Blocks.field_150367_z) {
                  if(this.field_74885_f == 0) {
                     if(p_151555_2_ == 2 || p_151555_2_ == 3) {
                        return Facing.field_71588_a[p_151555_2_];
                     }
                  } else if(this.field_74885_f == 1) {
                     if(p_151555_2_ == 2) {
                        return 4;
                     }

                     if(p_151555_2_ == 3) {
                        return 5;
                     }

                     if(p_151555_2_ == 4) {
                        return 2;
                     }

                     if(p_151555_2_ == 5) {
                        return 3;
                     }
                  } else if(this.field_74885_f == 3) {
                     if(p_151555_2_ == 2) {
                        return 5;
                     }

                     if(p_151555_2_ == 3) {
                        return 4;
                     }

                     if(p_151555_2_ == 4) {
                        return 2;
                     }

                     if(p_151555_2_ == 5) {
                        return 3;
                     }
                  }
               }
            } else if(this.field_74885_f == 0) {
               if(p_151555_2_ == 0 || p_151555_2_ == 2) {
                  return Direction.field_71580_e[p_151555_2_];
               }
            } else if(this.field_74885_f == 1) {
               if(p_151555_2_ == 2) {
                  return 1;
               }

               if(p_151555_2_ == 0) {
                  return 3;
               }

               if(p_151555_2_ == 1) {
                  return 2;
               }

               if(p_151555_2_ == 3) {
                  return 0;
               }
            } else if(this.field_74885_f == 3) {
               if(p_151555_2_ == 2) {
                  return 3;
               }

               if(p_151555_2_ == 0) {
                  return 1;
               }

               if(p_151555_2_ == 1) {
                  return 2;
               }

               if(p_151555_2_ == 3) {
                  return 0;
               }
            }
         } else if(this.field_74885_f == 0) {
            if(p_151555_2_ == 2) {
               return 3;
            }

            if(p_151555_2_ == 3) {
               return 2;
            }
         } else if(this.field_74885_f == 1) {
            if(p_151555_2_ == 0) {
               return 2;
            }

            if(p_151555_2_ == 1) {
               return 3;
            }

            if(p_151555_2_ == 2) {
               return 0;
            }

            if(p_151555_2_ == 3) {
               return 1;
            }
         } else if(this.field_74885_f == 3) {
            if(p_151555_2_ == 0) {
               return 2;
            }

            if(p_151555_2_ == 1) {
               return 3;
            }

            if(p_151555_2_ == 2) {
               return 1;
            }

            if(p_151555_2_ == 3) {
               return 0;
            }
         }
      } else if(this.field_74885_f == 0) {
         if(p_151555_2_ == 0) {
            return 2;
         }

         if(p_151555_2_ == 2) {
            return 0;
         }
      } else {
         if(this.field_74885_f == 1) {
            return p_151555_2_ + 1 & 3;
         }

         if(this.field_74885_f == 3) {
            return p_151555_2_ + 3 & 3;
         }
      }

      return p_151555_2_;
   }

   protected void func_151550_a(World p_151550_1_, Block p_151550_2_, int p_151550_3_, int p_151550_4_, int p_151550_5_, int p_151550_6_, StructureBoundingBox p_151550_7_) {
      int var8 = this.func_74865_a(p_151550_4_, p_151550_6_);
      int var9 = this.func_74862_a(p_151550_5_);
      int var10 = this.func_74873_b(p_151550_4_, p_151550_6_);
      if(p_151550_7_.func_78890_b(var8, var9, var10)) {
         p_151550_1_.func_147465_d(var8, var9, var10, p_151550_2_, p_151550_3_, 2);
      }
   }

   protected Block func_151548_a(World p_151548_1_, int p_151548_2_, int p_151548_3_, int p_151548_4_, StructureBoundingBox p_151548_5_) {
      int var6 = this.func_74865_a(p_151548_2_, p_151548_4_);
      int var7 = this.func_74862_a(p_151548_3_);
      int var8 = this.func_74873_b(p_151548_2_, p_151548_4_);
      return !p_151548_5_.func_78890_b(var6, var7, var8)?Blocks.field_150350_a:p_151548_1_.func_147439_a(var6, var7, var8);
   }

   protected void func_74878_a(World p_74878_1_, StructureBoundingBox p_74878_2_, int p_74878_3_, int p_74878_4_, int p_74878_5_, int p_74878_6_, int p_74878_7_, int p_74878_8_) {
      for(int var9 = p_74878_4_; var9 <= p_74878_7_; ++var9) {
         for(int var10 = p_74878_3_; var10 <= p_74878_6_; ++var10) {
            for(int var11 = p_74878_5_; var11 <= p_74878_8_; ++var11) {
               this.func_151550_a(p_74878_1_, Blocks.field_150350_a, 0, var10, var9, var11, p_74878_2_);
            }
         }
      }

   }

   protected void func_151549_a(World p_151549_1_, StructureBoundingBox p_151549_2_, int p_151549_3_, int p_151549_4_, int p_151549_5_, int p_151549_6_, int p_151549_7_, int p_151549_8_, Block p_151549_9_, Block p_151549_10_, boolean p_151549_11_) {
      for(int var12 = p_151549_4_; var12 <= p_151549_7_; ++var12) {
         for(int var13 = p_151549_3_; var13 <= p_151549_6_; ++var13) {
            for(int var14 = p_151549_5_; var14 <= p_151549_8_; ++var14) {
               if(!p_151549_11_ || this.func_151548_a(p_151549_1_, var13, var12, var14, p_151549_2_).func_149688_o() != Material.field_151579_a) {
                  if(var12 != p_151549_4_ && var12 != p_151549_7_ && var13 != p_151549_3_ && var13 != p_151549_6_ && var14 != p_151549_5_ && var14 != p_151549_8_) {
                     this.func_151550_a(p_151549_1_, p_151549_10_, 0, var13, var12, var14, p_151549_2_);
                  } else {
                     this.func_151550_a(p_151549_1_, p_151549_9_, 0, var13, var12, var14, p_151549_2_);
                  }
               }
            }
         }
      }

   }

   protected void func_151556_a(World p_151556_1_, StructureBoundingBox p_151556_2_, int p_151556_3_, int p_151556_4_, int p_151556_5_, int p_151556_6_, int p_151556_7_, int p_151556_8_, Block p_151556_9_, int p_151556_10_, Block p_151556_11_, int p_151556_12_, boolean p_151556_13_) {
      for(int var14 = p_151556_4_; var14 <= p_151556_7_; ++var14) {
         for(int var15 = p_151556_3_; var15 <= p_151556_6_; ++var15) {
            for(int var16 = p_151556_5_; var16 <= p_151556_8_; ++var16) {
               if(!p_151556_13_ || this.func_151548_a(p_151556_1_, var15, var14, var16, p_151556_2_).func_149688_o() != Material.field_151579_a) {
                  if(var14 != p_151556_4_ && var14 != p_151556_7_ && var15 != p_151556_3_ && var15 != p_151556_6_ && var16 != p_151556_5_ && var16 != p_151556_8_) {
                     this.func_151550_a(p_151556_1_, p_151556_11_, p_151556_12_, var15, var14, var16, p_151556_2_);
                  } else {
                     this.func_151550_a(p_151556_1_, p_151556_9_, p_151556_10_, var15, var14, var16, p_151556_2_);
                  }
               }
            }
         }
      }

   }

   protected void func_74882_a(World p_74882_1_, StructureBoundingBox p_74882_2_, int p_74882_3_, int p_74882_4_, int p_74882_5_, int p_74882_6_, int p_74882_7_, int p_74882_8_, boolean p_74882_9_, Random p_74882_10_, StructureComponent.BlockSelector p_74882_11_) {
      for(int var12 = p_74882_4_; var12 <= p_74882_7_; ++var12) {
         for(int var13 = p_74882_3_; var13 <= p_74882_6_; ++var13) {
            for(int var14 = p_74882_5_; var14 <= p_74882_8_; ++var14) {
               if(!p_74882_9_ || this.func_151548_a(p_74882_1_, var13, var12, var14, p_74882_2_).func_149688_o() != Material.field_151579_a) {
                  p_74882_11_.func_75062_a(p_74882_10_, var13, var12, var14, var12 == p_74882_4_ || var12 == p_74882_7_ || var13 == p_74882_3_ || var13 == p_74882_6_ || var14 == p_74882_5_ || var14 == p_74882_8_);
                  this.func_151550_a(p_74882_1_, p_74882_11_.func_151561_a(), p_74882_11_.func_75064_b(), var13, var12, var14, p_74882_2_);
               }
            }
         }
      }

   }

   protected void func_151551_a(World p_151551_1_, StructureBoundingBox p_151551_2_, Random p_151551_3_, float p_151551_4_, int p_151551_5_, int p_151551_6_, int p_151551_7_, int p_151551_8_, int p_151551_9_, int p_151551_10_, Block p_151551_11_, Block p_151551_12_, boolean p_151551_13_) {
      for(int var14 = p_151551_6_; var14 <= p_151551_9_; ++var14) {
         for(int var15 = p_151551_5_; var15 <= p_151551_8_; ++var15) {
            for(int var16 = p_151551_7_; var16 <= p_151551_10_; ++var16) {
               if(p_151551_3_.nextFloat() <= p_151551_4_ && (!p_151551_13_ || this.func_151548_a(p_151551_1_, var15, var14, var16, p_151551_2_).func_149688_o() != Material.field_151579_a)) {
                  if(var14 != p_151551_6_ && var14 != p_151551_9_ && var15 != p_151551_5_ && var15 != p_151551_8_ && var16 != p_151551_7_ && var16 != p_151551_10_) {
                     this.func_151550_a(p_151551_1_, p_151551_12_, 0, var15, var14, var16, p_151551_2_);
                  } else {
                     this.func_151550_a(p_151551_1_, p_151551_11_, 0, var15, var14, var16, p_151551_2_);
                  }
               }
            }
         }
      }

   }

   protected void func_151552_a(World p_151552_1_, StructureBoundingBox p_151552_2_, Random p_151552_3_, float p_151552_4_, int p_151552_5_, int p_151552_6_, int p_151552_7_, Block p_151552_8_, int p_151552_9_) {
      if(p_151552_3_.nextFloat() < p_151552_4_) {
         this.func_151550_a(p_151552_1_, p_151552_8_, p_151552_9_, p_151552_5_, p_151552_6_, p_151552_7_, p_151552_2_);
      }

   }

   protected void func_151547_a(World p_151547_1_, StructureBoundingBox p_151547_2_, int p_151547_3_, int p_151547_4_, int p_151547_5_, int p_151547_6_, int p_151547_7_, int p_151547_8_, Block p_151547_9_, boolean p_151547_10_) {
      float var11 = (float)(p_151547_6_ - p_151547_3_ + 1);
      float var12 = (float)(p_151547_7_ - p_151547_4_ + 1);
      float var13 = (float)(p_151547_8_ - p_151547_5_ + 1);
      float var14 = (float)p_151547_3_ + var11 / 2.0F;
      float var15 = (float)p_151547_5_ + var13 / 2.0F;

      for(int var16 = p_151547_4_; var16 <= p_151547_7_; ++var16) {
         float var17 = (float)(var16 - p_151547_4_) / var12;

         for(int var18 = p_151547_3_; var18 <= p_151547_6_; ++var18) {
            float var19 = ((float)var18 - var14) / (var11 * 0.5F);

            for(int var20 = p_151547_5_; var20 <= p_151547_8_; ++var20) {
               float var21 = ((float)var20 - var15) / (var13 * 0.5F);
               if(!p_151547_10_ || this.func_151548_a(p_151547_1_, var18, var16, var20, p_151547_2_).func_149688_o() != Material.field_151579_a) {
                  float var22 = var19 * var19 + var17 * var17 + var21 * var21;
                  if(var22 <= 1.05F) {
                     this.func_151550_a(p_151547_1_, p_151547_9_, 0, var18, var16, var20, p_151547_2_);
                  }
               }
            }
         }
      }

   }

   protected void func_74871_b(World p_74871_1_, int p_74871_2_, int p_74871_3_, int p_74871_4_, StructureBoundingBox p_74871_5_) {
      int var6 = this.func_74865_a(p_74871_2_, p_74871_4_);
      int var7 = this.func_74862_a(p_74871_3_);
      int var8 = this.func_74873_b(p_74871_2_, p_74871_4_);
      if(p_74871_5_.func_78890_b(var6, var7, var8)) {
         while(!p_74871_1_.func_147437_c(var6, var7, var8) && var7 < 255) {
            p_74871_1_.func_147465_d(var6, var7, var8, Blocks.field_150350_a, 0, 2);
            ++var7;
         }

      }
   }

   protected void func_151554_b(World p_151554_1_, Block p_151554_2_, int p_151554_3_, int p_151554_4_, int p_151554_5_, int p_151554_6_, StructureBoundingBox p_151554_7_) {
      int var8 = this.func_74865_a(p_151554_4_, p_151554_6_);
      int var9 = this.func_74862_a(p_151554_5_);
      int var10 = this.func_74873_b(p_151554_4_, p_151554_6_);
      if(p_151554_7_.func_78890_b(var8, var9, var10)) {
         while((p_151554_1_.func_147437_c(var8, var9, var10) || p_151554_1_.func_147439_a(var8, var9, var10).func_149688_o().func_76224_d()) && var9 > 1) {
            p_151554_1_.func_147465_d(var8, var9, var10, p_151554_2_, p_151554_3_, 2);
            --var9;
         }

      }
   }

   protected boolean func_74879_a(World p_74879_1_, StructureBoundingBox p_74879_2_, Random p_74879_3_, int p_74879_4_, int p_74879_5_, int p_74879_6_, WeightedRandomChestContent[] p_74879_7_, int p_74879_8_) {
      int var9 = this.func_74865_a(p_74879_4_, p_74879_6_);
      int var10 = this.func_74862_a(p_74879_5_);
      int var11 = this.func_74873_b(p_74879_4_, p_74879_6_);
      if(p_74879_2_.func_78890_b(var9, var10, var11) && p_74879_1_.func_147439_a(var9, var10, var11) != Blocks.field_150486_ae) {
         p_74879_1_.func_147465_d(var9, var10, var11, Blocks.field_150486_ae, 0, 2);
         TileEntityChest var12 = (TileEntityChest)p_74879_1_.func_147438_o(var9, var10, var11);
         if(var12 != null) {
            WeightedRandomChestContent.func_76293_a(p_74879_3_, p_74879_7_, var12, p_74879_8_);
         }

         return true;
      } else {
         return false;
      }
   }

   protected boolean func_74869_a(World p_74869_1_, StructureBoundingBox p_74869_2_, Random p_74869_3_, int p_74869_4_, int p_74869_5_, int p_74869_6_, int p_74869_7_, WeightedRandomChestContent[] p_74869_8_, int p_74869_9_) {
      int var10 = this.func_74865_a(p_74869_4_, p_74869_6_);
      int var11 = this.func_74862_a(p_74869_5_);
      int var12 = this.func_74873_b(p_74869_4_, p_74869_6_);
      if(p_74869_2_.func_78890_b(var10, var11, var12) && p_74869_1_.func_147439_a(var10, var11, var12) != Blocks.field_150367_z) {
         p_74869_1_.func_147465_d(var10, var11, var12, Blocks.field_150367_z, this.func_151555_a(Blocks.field_150367_z, p_74869_7_), 2);
         TileEntityDispenser var13 = (TileEntityDispenser)p_74869_1_.func_147438_o(var10, var11, var12);
         if(var13 != null) {
            WeightedRandomChestContent.func_150706_a(p_74869_3_, p_74869_8_, var13, p_74869_9_);
         }

         return true;
      } else {
         return false;
      }
   }

   protected void func_74881_a(World p_74881_1_, StructureBoundingBox p_74881_2_, Random p_74881_3_, int p_74881_4_, int p_74881_5_, int p_74881_6_, int p_74881_7_) {
      int var8 = this.func_74865_a(p_74881_4_, p_74881_6_);
      int var9 = this.func_74862_a(p_74881_5_);
      int var10 = this.func_74873_b(p_74881_4_, p_74881_6_);
      if(p_74881_2_.func_78890_b(var8, var9, var10)) {
         ItemDoor.func_150924_a(p_74881_1_, var8, var9, var10, p_74881_7_, Blocks.field_150466_ao);
      }

   }

   public abstract static class BlockSelector {

      protected Block field_151562_a;
      protected int field_75065_b;
      private static final String __OBFID = "CL_00000512";


      protected BlockSelector() {
         this.field_151562_a = Blocks.field_150350_a;
      }

      public abstract void func_75062_a(Random var1, int var2, int var3, int var4, boolean var5);

      public Block func_151561_a() {
         return this.field_151562_a;
      }

      public int func_75064_b() {
         return this.field_75065_b;
      }
   }
}
