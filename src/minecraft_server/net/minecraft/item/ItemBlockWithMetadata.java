package net.minecraft.item;

import net.minecraft.block.Block;

public class ItemBlockWithMetadata extends ItemBlock
{
    private Block field_150950_b;
    private static final String __OBFID = "CL_00001769";

    public ItemBlockWithMetadata(Block p_i45326_1_, Block p_i45326_2_)
    {
        super(p_i45326_1_);
        this.field_150950_b = p_i45326_2_;
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    /**
     * Returns the metadata of the block which this Item (ItemBlock) can place
     */
    public int getMetadata(int p_77647_1_)
    {
        return p_77647_1_;
    }
}
