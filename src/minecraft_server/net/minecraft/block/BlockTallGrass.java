package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class BlockTallGrass extends BlockBush implements IGrowable
{
    private static final String[] field_149871_a = new String[] {"deadbush", "tallgrass", "fern"};
    private static final String __OBFID = "CL_00000321";

    protected BlockTallGrass()
    {
        super(Material.field_151582_l);
        float var1 = 0.4F;
        this.setBlockBounds(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.8F, 0.5F + var1);
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean canBlockStay(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_)
    {
        return this.func_149854_a(p_149718_1_.getBlock(p_149718_2_, p_149718_3_ - 1, p_149718_4_));
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return p_149650_2_.nextInt(8) == 0 ? Items.wheat_seeds : null;
    }

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
    public int quantityDroppedWithBonus(int p_149679_1_, Random p_149679_2_)
    {
        return 1 + p_149679_2_.nextInt(p_149679_1_ * 2 + 1);
    }

    public void harvestBlock(World p_149636_1_, EntityPlayer p_149636_2_, int p_149636_3_, int p_149636_4_, int p_149636_5_, int p_149636_6_)
    {
        if (!p_149636_1_.isClient && p_149636_2_.getCurrentEquippedItem() != null && p_149636_2_.getCurrentEquippedItem().getItem() == Items.shears)
        {
            p_149636_2_.addStat(StatList.mineBlockStatArray[Block.getIdFromBlock(this)], 1);
            this.dropBlockAsItem_do(p_149636_1_, p_149636_3_, p_149636_4_, p_149636_5_, new ItemStack(Blocks.tallgrass, 1, p_149636_6_));
        }
        else
        {
            super.harvestBlock(p_149636_1_, p_149636_2_, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_);
        }
    }

    /**
     * Get the block's damage value (for use with pick block).
     */
    public int getDamageValue(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_)
    {
        return p_149643_1_.getBlockMetadata(p_149643_2_, p_149643_3_, p_149643_4_);
    }

    public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_)
    {
        int var6 = p_149851_1_.getBlockMetadata(p_149851_2_, p_149851_3_, p_149851_4_);
        return var6 != 0;
    }

    public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_)
    {
        return true;
    }

    public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_)
    {
        int var6 = p_149853_1_.getBlockMetadata(p_149853_3_, p_149853_4_, p_149853_5_);
        byte var7 = 2;

        if (var6 == 2)
        {
            var7 = 3;
        }

        if (Blocks.double_plant.canPlaceBlockAt(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_))
        {
            Blocks.double_plant.func_149889_c(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_, var7, 2);
        }
    }
}
