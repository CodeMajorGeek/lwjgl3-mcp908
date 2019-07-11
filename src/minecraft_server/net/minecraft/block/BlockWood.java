package net.minecraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockWood extends Block
{
    public static final String[] field_150096_a = new String[] {"oak", "spruce", "birch", "jungle", "acacia", "big_oak"};
    private static final String __OBFID = "CL_00000335";

    public BlockWood()
    {
        super(Material.wood);
        this.setcreativeTab(CreativeTabs.tabBlock);
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int p_149692_1_)
    {
        return p_149692_1_;
    }
}
