package net.minecraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAnvil extends BlockFalling
{
    public static final String[] field_149834_a = new String[] {"intact", "slightlyDamaged", "veryDamaged"};
    private static final String[] field_149835_N = new String[] {"anvil_top_damaged_0", "anvil_top_damaged_1", "anvil_top_damaged_2"};
    private static final String __OBFID = "CL_00000192";

    protected BlockAnvil()
    {
        super(Material.field_151574_g);
        this.setLightOpacity(0);
        this.setcreativeTab(CreativeTabs.tabDecorations);
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_)
    {
        int var7 = MathHelper.floor_double((double)(p_149689_5_.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        int var8 = p_149689_1_.getBlockMetadata(p_149689_2_, p_149689_3_, p_149689_4_) >> 2;
        ++var7;
        var7 %= 4;

        if (var7 == 0)
        {
            p_149689_1_.setBlockMetadata(p_149689_2_, p_149689_3_, p_149689_4_, 2 | var8 << 2, 2);
        }

        if (var7 == 1)
        {
            p_149689_1_.setBlockMetadata(p_149689_2_, p_149689_3_, p_149689_4_, 3 | var8 << 2, 2);
        }

        if (var7 == 2)
        {
            p_149689_1_.setBlockMetadata(p_149689_2_, p_149689_3_, p_149689_4_, 0 | var8 << 2, 2);
        }

        if (var7 == 3)
        {
            p_149689_1_.setBlockMetadata(p_149689_2_, p_149689_3_, p_149689_4_, 1 | var8 << 2, 2);
        }
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        if (p_149727_1_.isClient)
        {
            return true;
        }
        else
        {
            p_149727_5_.displayGUIAnvil(p_149727_2_, p_149727_3_, p_149727_4_);
            return true;
        }
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 35;
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int p_149692_1_)
    {
        return p_149692_1_ >> 2;
    }

    public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_)
    {
        int var5 = p_149719_1_.getBlockMetadata(p_149719_2_, p_149719_3_, p_149719_4_) & 3;

        if (var5 != 3 && var5 != 1)
        {
            this.setBlockBounds(0.125F, 0.0F, 0.0F, 0.875F, 1.0F, 1.0F);
        }
        else
        {
            this.setBlockBounds(0.0F, 0.0F, 0.125F, 1.0F, 1.0F, 0.875F);
        }
    }

    protected void func_149829_a(EntityFallingBlock p_149829_1_)
    {
        p_149829_1_.func_145806_a(true);
    }

    public void func_149828_a(World p_149828_1_, int p_149828_2_, int p_149828_3_, int p_149828_4_, int p_149828_5_)
    {
        p_149828_1_.playAuxSFX(1022, p_149828_2_, p_149828_3_, p_149828_4_, 0);
    }
}
