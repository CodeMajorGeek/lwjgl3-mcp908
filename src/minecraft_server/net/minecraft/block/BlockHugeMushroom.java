package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class BlockHugeMushroom extends Block
{
    private static final String[] field_149793_a = new String[] {"skin_brown", "skin_red"};
    private final int field_149792_b;
    private static final String __OBFID = "CL_00000258";

    public BlockHugeMushroom(Material p_i45412_1_, int p_i45412_2_)
    {
        super(p_i45412_1_);
        this.field_149792_b = p_i45412_2_;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random p_149745_1_)
    {
        int var2 = p_149745_1_.nextInt(10) - 7;

        if (var2 < 0)
        {
            var2 = 0;
        }

        return var2;
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemById(Block.getIdFromBlock(Blocks.brown_mushroom) + this.field_149792_b);
    }
}
