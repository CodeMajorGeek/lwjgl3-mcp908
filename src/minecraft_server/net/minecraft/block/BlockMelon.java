package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockMelon extends Block
{
    private static final String __OBFID = "CL_00000267";

    protected BlockMelon()
    {
        super(Material.field_151572_C);
        this.setcreativeTab(CreativeTabs.tabBlock);
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Items.melon;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random p_149745_1_)
    {
        return 3 + p_149745_1_.nextInt(5);
    }

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
    public int quantityDroppedWithBonus(int p_149679_1_, Random p_149679_2_)
    {
        int var3 = this.quantityDropped(p_149679_2_) + p_149679_2_.nextInt(1 + p_149679_1_);

        if (var3 > 9)
        {
            var3 = 9;
        }

        return var3;
    }
}
