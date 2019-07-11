package net.minecraft.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockColored extends Block
{
    private static final String __OBFID = "CL_00000217";

    public BlockColored(Material p_i45398_1_)
    {
        super(p_i45398_1_);
        this.setcreativeTab(CreativeTabs.tabBlock);
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int p_149692_1_)
    {
        return p_149692_1_;
    }

    public static int func_150032_b(int p_150032_0_)
    {
        return func_150031_c(p_150032_0_);
    }

    public static int func_150031_c(int p_150031_0_)
    {
        return ~p_150031_0_ & 15;
    }

    public MapColor getMapColor(int p_149728_1_)
    {
        return MapColor.func_151644_a(p_149728_1_);
    }
}
