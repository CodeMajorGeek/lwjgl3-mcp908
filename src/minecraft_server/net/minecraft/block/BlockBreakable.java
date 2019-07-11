package net.minecraft.block;

import net.minecraft.block.material.Material;

public class BlockBreakable extends Block
{
    private boolean field_149996_a;
    private String field_149995_b;
    private static final String __OBFID = "CL_00000254";

    protected BlockBreakable(String p_i45411_1_, Material p_i45411_2_, boolean p_i45411_3_)
    {
        super(p_i45411_2_);
        this.field_149996_a = p_i45411_3_;
        this.field_149995_b = p_i45411_1_;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }
}
