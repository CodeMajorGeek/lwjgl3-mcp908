package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockMycelium extends Block
{
    private static final String __OBFID = "CL_00000273";

    protected BlockMycelium()
    {
        super(Material.field_151577_b);
        this.setTickRandomly(true);
        this.setcreativeTab(CreativeTabs.tabBlock);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
    {
        if (!p_149674_1_.isClient)
        {
            if (p_149674_1_.getBlockLightValue(p_149674_2_, p_149674_3_ + 1, p_149674_4_) < 4 && p_149674_1_.getBlock(p_149674_2_, p_149674_3_ + 1, p_149674_4_).getLightOpacity() > 2)
            {
                p_149674_1_.setBlock(p_149674_2_, p_149674_3_, p_149674_4_, Blocks.dirt);
            }
            else if (p_149674_1_.getBlockLightValue(p_149674_2_, p_149674_3_ + 1, p_149674_4_) >= 9)
            {
                for (int var6 = 0; var6 < 4; ++var6)
                {
                    int var7 = p_149674_2_ + p_149674_5_.nextInt(3) - 1;
                    int var8 = p_149674_3_ + p_149674_5_.nextInt(5) - 3;
                    int var9 = p_149674_4_ + p_149674_5_.nextInt(3) - 1;
                    Block var10 = p_149674_1_.getBlock(var7, var8 + 1, var9);

                    if (p_149674_1_.getBlock(var7, var8, var9) == Blocks.dirt && p_149674_1_.getBlockMetadata(var7, var8, var9) == 0 && p_149674_1_.getBlockLightValue(var7, var8 + 1, var9) >= 4 && var10.getLightOpacity() <= 2)
                    {
                        p_149674_1_.setBlock(var7, var8, var9, this);
                    }
                }
            }
        }
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Blocks.dirt.getItemDropped(0, p_149650_2_, p_149650_3_);
    }
}
