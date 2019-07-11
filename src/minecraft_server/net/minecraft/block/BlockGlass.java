package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockGlass extends BlockBreakable
{
    private static final String __OBFID = "CL_00000249";

    public BlockGlass(Material p_i45408_1_, boolean p_i45408_2_)
    {
        super("glass", p_i45408_1_, p_i45408_2_);
        this.setcreativeTab(CreativeTabs.tabBlock);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random p_149745_1_)
    {
        return 0;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    protected boolean canSilkHarvest()
    {
        return true;
    }
}
