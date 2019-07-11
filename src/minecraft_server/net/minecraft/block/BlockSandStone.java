package net.minecraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockSandStone extends Block
{
    public static final String[] field_150157_a = new String[] {"default", "chiseled", "smooth"};
    private static final String[] field_150156_b = new String[] {"normal", "carved", "smooth"};
    private static final String __OBFID = "CL_00000304";

    public BlockSandStone()
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
