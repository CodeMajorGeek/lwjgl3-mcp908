package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class BlockStainedGlass extends BlockBreakable
{
    private static final IIcon[] field_149998_a = new IIcon[16];
    private static final String __OBFID = "CL_00000312";

    public BlockStainedGlass(Material p_i45427_1_)
    {
        super("glass", p_i45427_1_, false);
        this.setcreativeTab(CreativeTabs.tabBlock);
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int p_149692_1_)
    {
        return p_149692_1_;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random p_149745_1_)
    {
        return 0;
    }

    protected boolean canSilkHarvest()
    {
        return true;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }
}
