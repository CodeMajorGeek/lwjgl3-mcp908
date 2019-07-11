package net.minecraft.block;

import java.util.Random;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockNetherWart extends BlockBush
{
    private static final String __OBFID = "CL_00000274";

    protected BlockNetherWart()
    {
        this.setTickRandomly(true);
        float var1 = 0.5F;
        this.setBlockBounds(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.25F, 0.5F + var1);
        this.setcreativeTab((CreativeTabs)null);
    }

    protected boolean func_149854_a(Block p_149854_1_)
    {
        return p_149854_1_ == Blocks.soul_sand;
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean canBlockStay(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_)
    {
        return this.func_149854_a(p_149718_1_.getBlock(p_149718_2_, p_149718_3_ - 1, p_149718_4_));
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
    {
        int var6 = p_149674_1_.getBlockMetadata(p_149674_2_, p_149674_3_, p_149674_4_);

        if (var6 < 3 && p_149674_5_.nextInt(10) == 0)
        {
            ++var6;
            p_149674_1_.setBlockMetadata(p_149674_2_, p_149674_3_, p_149674_4_, var6, 2);
        }

        super.updateTick(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 6;
    }

    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropBlockAsItemWithChance(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_)
    {
        if (!p_149690_1_.isClient)
        {
            int var8 = 1;

            if (p_149690_5_ >= 3)
            {
                var8 = 2 + p_149690_1_.rand.nextInt(3);

                if (p_149690_7_ > 0)
                {
                    var8 += p_149690_1_.rand.nextInt(p_149690_7_ + 1);
                }
            }

            for (int var9 = 0; var9 < var8; ++var9)
            {
                this.dropBlockAsItem_do(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, new ItemStack(Items.nether_wart));
            }
        }
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return null;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random p_149745_1_)
    {
        return 0;
    }
}
