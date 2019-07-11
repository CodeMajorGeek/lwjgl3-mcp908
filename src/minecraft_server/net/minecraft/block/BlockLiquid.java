package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockLiquid extends Block
{
    private static final String __OBFID = "CL_00000265";

    protected BlockLiquid(Material p_i45413_1_)
    {
        super(p_i45413_1_);
        float var2 = 0.0F;
        float var3 = 0.0F;
        this.setBlockBounds(0.0F + var3, 0.0F + var2, 0.0F + var3, 1.0F + var3, 1.0F + var2, 1.0F + var3);
        this.setTickRandomly(true);
    }

    public boolean getBlocksMovement(IBlockAccess p_149655_1_, int p_149655_2_, int p_149655_3_, int p_149655_4_)
    {
        return this.blockMaterial != Material.field_151587_i;
    }

    public static float func_149801_b(int p_149801_0_)
    {
        if (p_149801_0_ >= 8)
        {
            p_149801_0_ = 0;
        }

        return (float)(p_149801_0_ + 1) / 9.0F;
    }

    protected int func_149804_e(World p_149804_1_, int p_149804_2_, int p_149804_3_, int p_149804_4_)
    {
        return p_149804_1_.getBlock(p_149804_2_, p_149804_3_, p_149804_4_).getMaterial() == this.blockMaterial ? p_149804_1_.getBlockMetadata(p_149804_2_, p_149804_3_, p_149804_4_) : -1;
    }

    protected int func_149798_e(IBlockAccess p_149798_1_, int p_149798_2_, int p_149798_3_, int p_149798_4_)
    {
        if (p_149798_1_.getBlock(p_149798_2_, p_149798_3_, p_149798_4_).getMaterial() != this.blockMaterial)
        {
            return -1;
        }
        else
        {
            int var5 = p_149798_1_.getBlockMetadata(p_149798_2_, p_149798_3_, p_149798_4_);

            if (var5 >= 8)
            {
                var5 = 0;
            }

            return var5;
        }
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
     * Returns whether this block is collideable based on the arguments passed in \n@param par1 block metaData \n@param
     * par2 whether the player right-clicked while holding a boat
     */
    public boolean canCollideCheck(int p_149678_1_, boolean p_149678_2_)
    {
        return p_149678_2_ && p_149678_1_ == 0;
    }

    public boolean isBlockSolid(IBlockAccess p_149747_1_, int p_149747_2_, int p_149747_3_, int p_149747_4_, int p_149747_5_)
    {
        Material var6 = p_149747_1_.getBlock(p_149747_2_, p_149747_3_, p_149747_4_).getMaterial();
        return var6 == this.blockMaterial ? false : (p_149747_5_ == 1 ? true : (var6 == Material.field_151588_w ? false : super.isBlockSolid(p_149747_1_, p_149747_2_, p_149747_3_, p_149747_4_, p_149747_5_)));
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 4;
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

    private Vec3 func_149800_f(IBlockAccess p_149800_1_, int p_149800_2_, int p_149800_3_, int p_149800_4_)
    {
        Vec3 var5 = Vec3.createVectorHelper(0.0D, 0.0D, 0.0D);
        int var6 = this.func_149798_e(p_149800_1_, p_149800_2_, p_149800_3_, p_149800_4_);

        for (int var7 = 0; var7 < 4; ++var7)
        {
            int var8 = p_149800_2_;
            int var10 = p_149800_4_;

            if (var7 == 0)
            {
                var8 = p_149800_2_ - 1;
            }

            if (var7 == 1)
            {
                var10 = p_149800_4_ - 1;
            }

            if (var7 == 2)
            {
                ++var8;
            }

            if (var7 == 3)
            {
                ++var10;
            }

            int var11 = this.func_149798_e(p_149800_1_, var8, p_149800_3_, var10);
            int var12;

            if (var11 < 0)
            {
                if (!p_149800_1_.getBlock(var8, p_149800_3_, var10).getMaterial().blocksMovement())
                {
                    var11 = this.func_149798_e(p_149800_1_, var8, p_149800_3_ - 1, var10);

                    if (var11 >= 0)
                    {
                        var12 = var11 - (var6 - 8);
                        var5 = var5.addVector((double)((var8 - p_149800_2_) * var12), (double)((p_149800_3_ - p_149800_3_) * var12), (double)((var10 - p_149800_4_) * var12));
                    }
                }
            }
            else if (var11 >= 0)
            {
                var12 = var11 - var6;
                var5 = var5.addVector((double)((var8 - p_149800_2_) * var12), (double)((p_149800_3_ - p_149800_3_) * var12), (double)((var10 - p_149800_4_) * var12));
            }
        }

        if (p_149800_1_.getBlockMetadata(p_149800_2_, p_149800_3_, p_149800_4_) >= 8)
        {
            boolean var13 = false;

            if (var13 || this.isBlockSolid(p_149800_1_, p_149800_2_, p_149800_3_, p_149800_4_ - 1, 2))
            {
                var13 = true;
            }

            if (var13 || this.isBlockSolid(p_149800_1_, p_149800_2_, p_149800_3_, p_149800_4_ + 1, 3))
            {
                var13 = true;
            }

            if (var13 || this.isBlockSolid(p_149800_1_, p_149800_2_ - 1, p_149800_3_, p_149800_4_, 4))
            {
                var13 = true;
            }

            if (var13 || this.isBlockSolid(p_149800_1_, p_149800_2_ + 1, p_149800_3_, p_149800_4_, 5))
            {
                var13 = true;
            }

            if (var13 || this.isBlockSolid(p_149800_1_, p_149800_2_, p_149800_3_ + 1, p_149800_4_ - 1, 2))
            {
                var13 = true;
            }

            if (var13 || this.isBlockSolid(p_149800_1_, p_149800_2_, p_149800_3_ + 1, p_149800_4_ + 1, 3))
            {
                var13 = true;
            }

            if (var13 || this.isBlockSolid(p_149800_1_, p_149800_2_ - 1, p_149800_3_ + 1, p_149800_4_, 4))
            {
                var13 = true;
            }

            if (var13 || this.isBlockSolid(p_149800_1_, p_149800_2_ + 1, p_149800_3_ + 1, p_149800_4_, 5))
            {
                var13 = true;
            }

            if (var13)
            {
                var5 = var5.normalize().addVector(0.0D, -6.0D, 0.0D);
            }
        }

        var5 = var5.normalize();
        return var5;
    }

    public void velocityToAddToEntity(World p_149640_1_, int p_149640_2_, int p_149640_3_, int p_149640_4_, Entity p_149640_5_, Vec3 p_149640_6_)
    {
        Vec3 var7 = this.func_149800_f(p_149640_1_, p_149640_2_, p_149640_3_, p_149640_4_);
        p_149640_6_.xCoord += var7.xCoord;
        p_149640_6_.yCoord += var7.yCoord;
        p_149640_6_.zCoord += var7.zCoord;
    }

    public int func_149738_a(World p_149738_1_)
    {
        return this.blockMaterial == Material.field_151586_h ? 5 : (this.blockMaterial == Material.field_151587_i ? (p_149738_1_.provider.hasNoSky ? 10 : 30) : 0);
    }

    public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_)
    {
        this.func_149805_n(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
    }

    public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_)
    {
        this.func_149805_n(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
    }

    private void func_149805_n(World p_149805_1_, int p_149805_2_, int p_149805_3_, int p_149805_4_)
    {
        if (p_149805_1_.getBlock(p_149805_2_, p_149805_3_, p_149805_4_) == this)
        {
            if (this.blockMaterial == Material.field_151587_i)
            {
                boolean var5 = false;

                if (var5 || p_149805_1_.getBlock(p_149805_2_, p_149805_3_, p_149805_4_ - 1).getMaterial() == Material.field_151586_h)
                {
                    var5 = true;
                }

                if (var5 || p_149805_1_.getBlock(p_149805_2_, p_149805_3_, p_149805_4_ + 1).getMaterial() == Material.field_151586_h)
                {
                    var5 = true;
                }

                if (var5 || p_149805_1_.getBlock(p_149805_2_ - 1, p_149805_3_, p_149805_4_).getMaterial() == Material.field_151586_h)
                {
                    var5 = true;
                }

                if (var5 || p_149805_1_.getBlock(p_149805_2_ + 1, p_149805_3_, p_149805_4_).getMaterial() == Material.field_151586_h)
                {
                    var5 = true;
                }

                if (var5 || p_149805_1_.getBlock(p_149805_2_, p_149805_3_ + 1, p_149805_4_).getMaterial() == Material.field_151586_h)
                {
                    var5 = true;
                }

                if (var5)
                {
                    int var6 = p_149805_1_.getBlockMetadata(p_149805_2_, p_149805_3_, p_149805_4_);

                    if (var6 == 0)
                    {
                        p_149805_1_.setBlock(p_149805_2_, p_149805_3_, p_149805_4_, Blocks.obsidian);
                    }
                    else if (var6 <= 4)
                    {
                        p_149805_1_.setBlock(p_149805_2_, p_149805_3_, p_149805_4_, Blocks.cobblestone);
                    }

                    this.func_149799_m(p_149805_1_, p_149805_2_, p_149805_3_, p_149805_4_);
                }
            }
        }
    }

    protected void func_149799_m(World p_149799_1_, int p_149799_2_, int p_149799_3_, int p_149799_4_)
    {
        p_149799_1_.playSoundEffect((double)((float)p_149799_2_ + 0.5F), (double)((float)p_149799_3_ + 0.5F), (double)((float)p_149799_4_ + 0.5F), "random.fizz", 0.5F, 2.6F + (p_149799_1_.rand.nextFloat() - p_149799_1_.rand.nextFloat()) * 0.8F);

        for (int var5 = 0; var5 < 8; ++var5)
        {
            p_149799_1_.spawnParticle("largesmoke", (double)p_149799_2_ + Math.random(), (double)p_149799_3_ + 1.2D, (double)p_149799_4_ + Math.random(), 0.0D, 0.0D, 0.0D);
        }
    }
}
