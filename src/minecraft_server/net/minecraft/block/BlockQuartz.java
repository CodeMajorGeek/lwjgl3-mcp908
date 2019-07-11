package net.minecraft.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockQuartz extends Block
{
    public static final String[] field_150191_a = new String[] {"default", "chiseled", "lines"};
    private static final String[] field_150189_b = new String[] {"side", "chiseled", "lines", null, null};
    private static final String __OBFID = "CL_00000292";

    public BlockQuartz()
    {
        super(Material.rock);
        this.setcreativeTab(CreativeTabs.tabBlock);
    }

    public int onBlockPlaced(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_)
    {
        if (p_149660_9_ == 2)
        {
            switch (p_149660_5_)
            {
                case 0:
                case 1:
                    p_149660_9_ = 2;
                    break;

                case 2:
                case 3:
                    p_149660_9_ = 4;
                    break;

                case 4:
                case 5:
                    p_149660_9_ = 3;
            }
        }

        return p_149660_9_;
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int p_149692_1_)
    {
        return p_149692_1_ != 3 && p_149692_1_ != 4 ? p_149692_1_ : 2;
    }

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int p_149644_1_)
    {
        return p_149644_1_ != 3 && p_149644_1_ != 4 ? super.createStackedBlock(p_149644_1_) : new ItemStack(Item.getItemFromBlock(this), 1, 2);
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 39;
    }

    public MapColor getMapColor(int p_149728_1_)
    {
        return MapColor.field_151677_p;
    }
}
