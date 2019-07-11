package net.minecraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.minecraft.world.World;

public class BlockEnchantmentTable extends BlockContainer
{
    private static final String __OBFID = "CL_00000235";

    protected BlockEnchantmentTable()
    {
        super(Material.rock);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
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
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
        return new TileEntityEnchantmentTable();
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
            TileEntityEnchantmentTable var10 = (TileEntityEnchantmentTable)p_149727_1_.getTileEntity(p_149727_2_, p_149727_3_, p_149727_4_);
            p_149727_5_.displayGUIEnchantment(p_149727_2_, p_149727_3_, p_149727_4_, var10.func_145921_b() ? var10.func_145919_a() : null);
            return true;
        }
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_)
    {
        super.onBlockPlacedBy(p_149689_1_, p_149689_2_, p_149689_3_, p_149689_4_, p_149689_5_, p_149689_6_);

        if (p_149689_6_.hasDisplayName())
        {
            ((TileEntityEnchantmentTable)p_149689_1_.getTileEntity(p_149689_2_, p_149689_3_, p_149689_4_)).func_145920_a(p_149689_6_.getDisplayName());
        }
    }
}
