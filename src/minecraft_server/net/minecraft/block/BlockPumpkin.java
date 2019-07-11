package net.minecraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockPumpkin extends BlockDirectional
{
    private boolean field_149985_a;
    private static final String __OBFID = "CL_00000291";

    protected BlockPumpkin(boolean p_i45419_1_)
    {
        super(Material.field_151572_C);
        this.setTickRandomly(true);
        this.field_149985_a = p_i45419_1_;
        this.setcreativeTab(CreativeTabs.tabBlock);
    }

    public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_)
    {
        super.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);

        if (p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_) == Blocks.snow && p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 2, p_149726_4_) == Blocks.snow)
        {
            if (!p_149726_1_.isClient)
            {
                p_149726_1_.setBlock(p_149726_2_, p_149726_3_, p_149726_4_, getBlockById(0), 0, 2);
                p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_, getBlockById(0), 0, 2);
                p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 2, p_149726_4_, getBlockById(0), 0, 2);
                EntitySnowman var9 = new EntitySnowman(p_149726_1_);
                var9.setLocationAndAngles((double)p_149726_2_ + 0.5D, (double)p_149726_3_ - 1.95D, (double)p_149726_4_ + 0.5D, 0.0F, 0.0F);
                p_149726_1_.spawnEntityInWorld(var9);
                p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_, p_149726_4_, getBlockById(0));
                p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1, p_149726_4_, getBlockById(0));
                p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 2, p_149726_4_, getBlockById(0));
            }

            for (int var10 = 0; var10 < 120; ++var10)
            {
                p_149726_1_.spawnParticle("snowshovel", (double)p_149726_2_ + p_149726_1_.rand.nextDouble(), (double)(p_149726_3_ - 2) + p_149726_1_.rand.nextDouble() * 2.5D, (double)p_149726_4_ + p_149726_1_.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
            }
        }
        else if (p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_) == Blocks.iron_block && p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 2, p_149726_4_) == Blocks.iron_block)
        {
            boolean var5 = p_149726_1_.getBlock(p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_) == Blocks.iron_block && p_149726_1_.getBlock(p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_) == Blocks.iron_block;
            boolean var6 = p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1) == Blocks.iron_block && p_149726_1_.getBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1) == Blocks.iron_block;

            if (var5 || var6)
            {
                p_149726_1_.setBlock(p_149726_2_, p_149726_3_, p_149726_4_, getBlockById(0), 0, 2);
                p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_, getBlockById(0), 0, 2);
                p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 2, p_149726_4_, getBlockById(0), 0, 2);

                if (var5)
                {
                    p_149726_1_.setBlock(p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_, getBlockById(0), 0, 2);
                    p_149726_1_.setBlock(p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_, getBlockById(0), 0, 2);
                }
                else
                {
                    p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1, getBlockById(0), 0, 2);
                    p_149726_1_.setBlock(p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1, getBlockById(0), 0, 2);
                }

                EntityIronGolem var7 = new EntityIronGolem(p_149726_1_);
                var7.setPlayerCreated(true);
                var7.setLocationAndAngles((double)p_149726_2_ + 0.5D, (double)p_149726_3_ - 1.95D, (double)p_149726_4_ + 0.5D, 0.0F, 0.0F);
                p_149726_1_.spawnEntityInWorld(var7);

                for (int var8 = 0; var8 < 120; ++var8)
                {
                    p_149726_1_.spawnParticle("snowballpoof", (double)p_149726_2_ + p_149726_1_.rand.nextDouble(), (double)(p_149726_3_ - 2) + p_149726_1_.rand.nextDouble() * 3.9D, (double)p_149726_4_ + p_149726_1_.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
                }

                p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_, p_149726_4_, getBlockById(0));
                p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1, p_149726_4_, getBlockById(0));
                p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 2, p_149726_4_, getBlockById(0));

                if (var5)
                {
                    p_149726_1_.notifyBlockChange(p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_, getBlockById(0));
                    p_149726_1_.notifyBlockChange(p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_, getBlockById(0));
                }
                else
                {
                    p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1, getBlockById(0));
                    p_149726_1_.notifyBlockChange(p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1, getBlockById(0));
                }
            }
        }
    }

    public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_)
    {
        return p_149742_1_.getBlock(p_149742_2_, p_149742_3_, p_149742_4_).blockMaterial.isReplaceable() && World.doesBlockHaveSolidTopSurface(p_149742_1_, p_149742_2_, p_149742_3_ - 1, p_149742_4_);
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_)
    {
        int var7 = MathHelper.floor_double((double)(p_149689_5_.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        p_149689_1_.setBlockMetadata(p_149689_2_, p_149689_3_, p_149689_4_, var7, 2);
    }
}
