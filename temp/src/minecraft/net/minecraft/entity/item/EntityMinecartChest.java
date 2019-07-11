package net.minecraft.entity.item;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityMinecartContainer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityMinecartChest extends EntityMinecartContainer {

   private static final String __OBFID = "CL_00001671";


   public EntityMinecartChest(World p_i1714_1_) {
      super(p_i1714_1_);
   }

   public EntityMinecartChest(World p_i1715_1_, double p_i1715_2_, double p_i1715_4_, double p_i1715_6_) {
      super(p_i1715_1_, p_i1715_2_, p_i1715_4_, p_i1715_6_);
   }

   public void func_94095_a(DamageSource p_94095_1_) {
      super.func_94095_a(p_94095_1_);
      this.func_145778_a(Item.func_150898_a(Blocks.field_150486_ae), 1, 0.0F);
   }

   public int func_70302_i_() {
      return 27;
   }

   public int func_94087_l() {
      return 1;
   }

   public Block func_145817_o() {
      return Blocks.field_150486_ae;
   }

   public int func_94085_r() {
      return 8;
   }
}
