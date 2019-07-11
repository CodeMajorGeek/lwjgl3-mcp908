package net.minecraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockDirt extends Block
{
    public static final String[] field_150009_a = new String[] {"default", "default", "podzol"};
    private static final String __OBFID = "CL_00000228";

    protected BlockDirt()
    {
        super(Material.ground);
        this.setcreativeTab(CreativeTabs.tabBlock);
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int p_149692_1_)
    {
        return 0;
    }

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int p_149644_1_)
    {
        if (p_149644_1_ == 1)
        {
            p_149644_1_ = 0;
        }

        return super.createStackedBlock(p_149644_1_);
    }

    /**
     * Get the block's damage value (for use with pick block).
     */
    public int getDamageValue(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_)
    {
        int var5 = p_149643_1_.getBlockMetadata(p_149643_2_, p_149643_3_, p_149643_4_);

        if (var5 == 1)
        {
            var5 = 0;
        }

        return var5;
    }
}
