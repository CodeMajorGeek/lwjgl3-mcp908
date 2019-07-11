package net.minecraft.world;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.chunk.Chunk;

public class ChunkCache implements IBlockAccess
{
    private int chunkX;
    private int chunkZ;
    private Chunk[][] chunkArray;

    /** set by !chunk.getAreLevelsEmpty */
    private boolean hasExtendedLevels;

    /** Reference to the World object. */
    private World worldObj;
    private static final String __OBFID = "CL_00000155";

    public ChunkCache(World p_i1964_1_, int p_i1964_2_, int p_i1964_3_, int p_i1964_4_, int p_i1964_5_, int p_i1964_6_, int p_i1964_7_, int p_i1964_8_)
    {
        this.worldObj = p_i1964_1_;
        this.chunkX = p_i1964_2_ - p_i1964_8_ >> 4;
        this.chunkZ = p_i1964_4_ - p_i1964_8_ >> 4;
        int var9 = p_i1964_5_ + p_i1964_8_ >> 4;
        int var10 = p_i1964_7_ + p_i1964_8_ >> 4;
        this.chunkArray = new Chunk[var9 - this.chunkX + 1][var10 - this.chunkZ + 1];
        this.hasExtendedLevels = true;
        int var11;
        int var12;
        Chunk var13;

        for (var11 = this.chunkX; var11 <= var9; ++var11)
        {
            for (var12 = this.chunkZ; var12 <= var10; ++var12)
            {
                var13 = p_i1964_1_.getChunkFromChunkCoords(var11, var12);

                if (var13 != null)
                {
                    this.chunkArray[var11 - this.chunkX][var12 - this.chunkZ] = var13;
                }
            }
        }

        for (var11 = p_i1964_2_ >> 4; var11 <= p_i1964_5_ >> 4; ++var11)
        {
            for (var12 = p_i1964_4_ >> 4; var12 <= p_i1964_7_ >> 4; ++var12)
            {
                var13 = this.chunkArray[var11 - this.chunkX][var12 - this.chunkZ];

                if (var13 != null && !var13.getAreLevelsEmpty(p_i1964_3_, p_i1964_6_))
                {
                    this.hasExtendedLevels = false;
                }
            }
        }
    }

    public Block getBlock(int p_147439_1_, int p_147439_2_, int p_147439_3_)
    {
        Block var4 = Blocks.air;

        if (p_147439_2_ >= 0 && p_147439_2_ < 256)
        {
            int var5 = (p_147439_1_ >> 4) - this.chunkX;
            int var6 = (p_147439_3_ >> 4) - this.chunkZ;

            if (var5 >= 0 && var5 < this.chunkArray.length && var6 >= 0 && var6 < this.chunkArray[var5].length)
            {
                Chunk var7 = this.chunkArray[var5][var6];

                if (var7 != null)
                {
                    var4 = var7.func_150810_a(p_147439_1_ & 15, p_147439_2_, p_147439_3_ & 15);
                }
            }
        }

        return var4;
    }

    public TileEntity getTileEntity(int p_147438_1_, int p_147438_2_, int p_147438_3_)
    {
        int var4 = (p_147438_1_ >> 4) - this.chunkX;
        int var5 = (p_147438_3_ >> 4) - this.chunkZ;
        return this.chunkArray[var4][var5].func_150806_e(p_147438_1_ & 15, p_147438_2_, p_147438_3_ & 15);
    }

    /**
     * Returns the block metadata at coords x,y,z
     */
    public int getBlockMetadata(int p_72805_1_, int p_72805_2_, int p_72805_3_)
    {
        if (p_72805_2_ < 0)
        {
            return 0;
        }
        else if (p_72805_2_ >= 256)
        {
            return 0;
        }
        else
        {
            int var4 = (p_72805_1_ >> 4) - this.chunkX;
            int var5 = (p_72805_3_ >> 4) - this.chunkZ;
            return this.chunkArray[var4][var5].getBlockMetadata(p_72805_1_ & 15, p_72805_2_, p_72805_3_ & 15);
        }
    }

    /**
     * Is this block powering in the specified direction Args: x, y, z, direction
     */
    public int isBlockProvidingPowerTo(int p_72879_1_, int p_72879_2_, int p_72879_3_, int p_72879_4_)
    {
        return this.getBlock(p_72879_1_, p_72879_2_, p_72879_3_).isProvidingStrongPower(this, p_72879_1_, p_72879_2_, p_72879_3_, p_72879_4_);
    }
}
