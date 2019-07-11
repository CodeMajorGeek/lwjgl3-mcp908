package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockFurnace extends BlockContainer
{
    private final Random field_149933_a = new Random();
    private final boolean field_149932_b;
    private static boolean field_149934_M;
    private static final String __OBFID = "CL_00000248";

    protected BlockFurnace(boolean p_i45407_1_)
    {
        super(Material.rock);
        this.field_149932_b = p_i45407_1_;
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(Blocks.furnace);
    }

    public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_)
    {
        super.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
        this.func_149930_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
    }

    private void func_149930_e(World p_149930_1_, int p_149930_2_, int p_149930_3_, int p_149930_4_)
    {
        if (!p_149930_1_.isClient)
        {
            Block var5 = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ - 1);
            Block var6 = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ + 1);
            Block var7 = p_149930_1_.getBlock(p_149930_2_ - 1, p_149930_3_, p_149930_4_);
            Block var8 = p_149930_1_.getBlock(p_149930_2_ + 1, p_149930_3_, p_149930_4_);
            byte var9 = 3;

            if (var5.func_149730_j() && !var6.func_149730_j())
            {
                var9 = 3;
            }

            if (var6.func_149730_j() && !var5.func_149730_j())
            {
                var9 = 2;
            }

            if (var7.func_149730_j() && !var8.func_149730_j())
            {
                var9 = 5;
            }

            if (var8.func_149730_j() && !var7.func_149730_j())
            {
                var9 = 4;
            }

            p_149930_1_.setBlockMetadata(p_149930_2_, p_149930_3_, p_149930_4_, var9, 2);
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
            TileEntityFurnace var10 = (TileEntityFurnace)p_149727_1_.getTileEntity(p_149727_2_, p_149727_3_, p_149727_4_);

            if (var10 != null)
            {
                p_149727_5_.func_146101_a(var10);
            }

            return true;
        }
    }

    public static void func_149931_a(boolean p_149931_0_, World p_149931_1_, int p_149931_2_, int p_149931_3_, int p_149931_4_)
    {
        int var5 = p_149931_1_.getBlockMetadata(p_149931_2_, p_149931_3_, p_149931_4_);
        TileEntity var6 = p_149931_1_.getTileEntity(p_149931_2_, p_149931_3_, p_149931_4_);
        field_149934_M = true;

        if (p_149931_0_)
        {
            p_149931_1_.setBlock(p_149931_2_, p_149931_3_, p_149931_4_, Blocks.lit_furnace);
        }
        else
        {
            p_149931_1_.setBlock(p_149931_2_, p_149931_3_, p_149931_4_, Blocks.furnace);
        }

        field_149934_M = false;
        p_149931_1_.setBlockMetadata(p_149931_2_, p_149931_3_, p_149931_4_, var5, 2);

        if (var6 != null)
        {
            var6.validate();
            p_149931_1_.setTileEntity(p_149931_2_, p_149931_3_, p_149931_4_, var6);
        }
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
        return new TileEntityFurnace();
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_)
    {
        int var7 = MathHelper.floor_double((double)(p_149689_5_.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (var7 == 0)
        {
            p_149689_1_.setBlockMetadata(p_149689_2_, p_149689_3_, p_149689_4_, 2, 2);
        }

        if (var7 == 1)
        {
            p_149689_1_.setBlockMetadata(p_149689_2_, p_149689_3_, p_149689_4_, 5, 2);
        }

        if (var7 == 2)
        {
            p_149689_1_.setBlockMetadata(p_149689_2_, p_149689_3_, p_149689_4_, 3, 2);
        }

        if (var7 == 3)
        {
            p_149689_1_.setBlockMetadata(p_149689_2_, p_149689_3_, p_149689_4_, 4, 2);
        }

        if (p_149689_6_.hasDisplayName())
        {
            ((TileEntityFurnace)p_149689_1_.getTileEntity(p_149689_2_, p_149689_3_, p_149689_4_)).func_145951_a(p_149689_6_.getDisplayName());
        }
    }

    public void breakBlock(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_)
    {
        if (!field_149934_M)
        {
            TileEntityFurnace var7 = (TileEntityFurnace)p_149749_1_.getTileEntity(p_149749_2_, p_149749_3_, p_149749_4_);

            if (var7 != null)
            {
                for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
                {
                    ItemStack var9 = var7.getStackInSlot(var8);

                    if (var9 != null)
                    {
                        float var10 = this.field_149933_a.nextFloat() * 0.8F + 0.1F;
                        float var11 = this.field_149933_a.nextFloat() * 0.8F + 0.1F;
                        float var12 = this.field_149933_a.nextFloat() * 0.8F + 0.1F;

                        while (var9.stackSize > 0)
                        {
                            int var13 = this.field_149933_a.nextInt(21) + 10;

                            if (var13 > var9.stackSize)
                            {
                                var13 = var9.stackSize;
                            }

                            var9.stackSize -= var13;
                            EntityItem var14 = new EntityItem(p_149749_1_, (double)((float)p_149749_2_ + var10), (double)((float)p_149749_3_ + var11), (double)((float)p_149749_4_ + var12), new ItemStack(var9.getItem(), var13, var9.getItemDamage()));

                            if (var9.hasTagCompound())
                            {
                                var14.getEntityItem().setTagCompound((NBTTagCompound)var9.getTagCompound().copy());
                            }

                            float var15 = 0.05F;
                            var14.motionX = (double)((float)this.field_149933_a.nextGaussian() * var15);
                            var14.motionY = (double)((float)this.field_149933_a.nextGaussian() * var15 + 0.2F);
                            var14.motionZ = (double)((float)this.field_149933_a.nextGaussian() * var15);
                            p_149749_1_.spawnEntityInWorld(var14);
                        }
                    }
                }

                p_149749_1_.func_147453_f(p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_);
            }
        }

        super.breakBlock(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
    }

    public boolean hasComparatorInputOverride()
    {
        return true;
    }

    public int getComparatorInputOverride(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_)
    {
        return Container.calcRedstoneFromInventory((IInventory)p_149736_1_.getTileEntity(p_149736_2_, p_149736_3_, p_149736_4_));
    }
}
