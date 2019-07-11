package net.minecraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

public class BlockFlower extends BlockBush
{
    private static final String[][] field_149860_M = new String[][] {{"flower_dandelion"}, {"flower_rose", "flower_blue_orchid", "flower_allium", "flower_houstonia", "flower_tulip_red", "flower_tulip_orange", "flower_tulip_white", "flower_tulip_pink", "flower_oxeye_daisy"}};
    public static final String[] field_149859_a = new String[] {"poppy", "blueOrchid", "allium", "houstonia", "tulipRed", "tulipOrange", "tulipWhite", "tulipPink", "oxeyeDaisy"};
    public static final String[] field_149858_b = new String[] {"dandelion"};
    private int field_149862_O;
    private static final String __OBFID = "CL_00000246";

    protected BlockFlower(int p_i2173_1_)
    {
        super(Material.plants);
        this.field_149862_O = p_i2173_1_;
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int p_149692_1_)
    {
        return p_149692_1_;
    }

    public static BlockFlower func_149857_e(String p_149857_0_)
    {
        String[] var1 = field_149858_b;
        int var2 = var1.length;
        int var3;
        String var4;

        for (var3 = 0; var3 < var2; ++var3)
        {
            var4 = var1[var3];

            if (var4.equals(p_149857_0_))
            {
                return Blocks.yellow_flower;
            }
        }

        var1 = field_149859_a;
        var2 = var1.length;

        for (var3 = 0; var3 < var2; ++var3)
        {
            var4 = var1[var3];

            if (var4.equals(p_149857_0_))
            {
                return Blocks.red_flower;
            }
        }

        return null;
    }

    public static int func_149856_f(String p_149856_0_)
    {
        int var1;

        for (var1 = 0; var1 < field_149858_b.length; ++var1)
        {
            if (field_149858_b[var1].equals(p_149856_0_))
            {
                return var1;
            }
        }

        for (var1 = 0; var1 < field_149859_a.length; ++var1)
        {
            if (field_149859_a[var1].equals(p_149856_0_))
            {
                return var1;
            }
        }

        return 0;
    }
}
