package net.minecraft.item;

import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ItemFirework extends Item
{
    private static final String __OBFID = "CL_00000031";

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (!p_77648_3_.isClient)
        {
            EntityFireworkRocket var11 = new EntityFireworkRocket(p_77648_3_, (double)((float)p_77648_4_ + p_77648_8_), (double)((float)p_77648_5_ + p_77648_9_), (double)((float)p_77648_6_ + p_77648_10_), p_77648_1_);
            p_77648_3_.spawnEntityInWorld(var11);

            if (!p_77648_2_.capabilities.isCreativeMode)
            {
                --p_77648_1_.stackSize;
            }

            return true;
        }
        else
        {
            return false;
        }
    }
}
