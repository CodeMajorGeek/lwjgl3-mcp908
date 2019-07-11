package net.minecraft.block;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockOldLeaf extends BlockLeaves
{
    public static final String[][] field_150130_N = new String[][] {{"leaves_oak", "leaves_spruce", "leaves_birch", "leaves_jungle"}, {"leaves_oak_opaque", "leaves_spruce_opaque", "leaves_birch_opaque", "leaves_jungle_opaque"}};
    public static final String[] field_150131_O = new String[] {"oak", "spruce", "birch", "jungle"};
    private static final String __OBFID = "CL_00000280";

    protected void func_150124_c(World p_150124_1_, int p_150124_2_, int p_150124_3_, int p_150124_4_, int p_150124_5_, int p_150124_6_)
    {
        if ((p_150124_5_ & 3) == 0 && p_150124_1_.rand.nextInt(p_150124_6_) == 0)
        {
            this.dropBlockAsItem_do(p_150124_1_, p_150124_2_, p_150124_3_, p_150124_4_, new ItemStack(Items.apple, 1, 0));
        }
    }

    protected int func_150123_b(int p_150123_1_)
    {
        int var2 = super.func_150123_b(p_150123_1_);

        if ((p_150123_1_ & 3) == 3)
        {
            var2 = 40;
        }

        return var2;
    }

    public String[] func_150125_e()
    {
        return field_150131_O;
    }
}
