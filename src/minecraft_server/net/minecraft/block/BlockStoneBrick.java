package net.minecraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockStoneBrick extends Block
{
    public static final String[] field_150142_a = new String[] {"default", "mossy", "cracked", "chiseled"};
    public static final String[] field_150141_b = new String[] {null, "mossy", "cracked", "carved"};
    private static final String __OBFID = "CL_00000318";

    public BlockStoneBrick()
    {
        super(Material.rock);
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
