package net.minecraft.block;

import java.util.List;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAnvil extends BlockFalling {

   public static final String[] field_149834_a = new String[]{"intact", "slightlyDamaged", "veryDamaged"};
   private static final String[] field_149835_N = new String[]{"anvil_top_damaged_0", "anvil_top_damaged_1", "anvil_top_damaged_2"};
   public int field_149833_b;
   private IIcon[] field_149836_O;
   private static final String __OBFID = "CL_00000192";


   protected BlockAnvil() {
      super(Material.field_151574_g);
      this.func_149713_g(0);
      this.func_149647_a(CreativeTabs.field_78031_c);
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149662_c() {
      return false;
   }

   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
      if(this.field_149833_b == 3 && p_149691_1_ == 1) {
         int var3 = (p_149691_2_ >> 2) % this.field_149836_O.length;
         return this.field_149836_O[var3];
      } else {
         return this.field_149761_L;
      }
   }

   public void func_149651_a(IIconRegister p_149651_1_) {
      this.field_149761_L = p_149651_1_.func_94245_a("anvil_base");
      this.field_149836_O = new IIcon[field_149835_N.length];

      for(int var2 = 0; var2 < this.field_149836_O.length; ++var2) {
         this.field_149836_O[var2] = p_149651_1_.func_94245_a(field_149835_N[var2]);
      }

   }

   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
      int var7 = MathHelper.func_76128_c((double)(p_149689_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3;
      int var8 = p_149689_1_.func_72805_g(p_149689_2_, p_149689_3_, p_149689_4_) >> 2;
      ++var7;
      var7 %= 4;
      if(var7 == 0) {
         p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 2 | var8 << 2, 2);
      }

      if(var7 == 1) {
         p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 3 | var8 << 2, 2);
      }

      if(var7 == 2) {
         p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 0 | var8 << 2, 2);
      }

      if(var7 == 3) {
         p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 1 | var8 << 2, 2);
      }

   }

   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
      if(p_149727_1_.field_72995_K) {
         return true;
      } else {
         p_149727_5_.func_82244_d(p_149727_2_, p_149727_3_, p_149727_4_);
         return true;
      }
   }

   public int func_149645_b() {
      return 35;
   }

   public int func_149692_a(int p_149692_1_) {
      return p_149692_1_ >> 2;
   }

   public void func_149719_a(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
      int var5 = p_149719_1_.func_72805_g(p_149719_2_, p_149719_3_, p_149719_4_) & 3;
      if(var5 != 3 && var5 != 1) {
         this.func_149676_a(0.125F, 0.0F, 0.0F, 0.875F, 1.0F, 1.0F);
      } else {
         this.func_149676_a(0.0F, 0.0F, 0.125F, 1.0F, 1.0F, 0.875F);
      }

   }

   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
      p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
      p_149666_3_.add(new ItemStack(p_149666_1_, 1, 1));
      p_149666_3_.add(new ItemStack(p_149666_1_, 1, 2));
   }

   protected void func_149829_a(EntityFallingBlock p_149829_1_) {
      p_149829_1_.func_145806_a(true);
   }

   public void func_149828_a(World p_149828_1_, int p_149828_2_, int p_149828_3_, int p_149828_4_, int p_149828_5_) {
      p_149828_1_.func_72926_e(1022, p_149828_2_, p_149828_3_, p_149828_4_, 0);
   }

   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
      return true;
   }

}
