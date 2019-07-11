package net.minecraft.server.management;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S21PacketChunkData;
import net.minecraft.network.play.server.S22PacketMultiBlockChange;
import net.minecraft.network.play.server.S23PacketBlockChange;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlayerManager
{
    private static final Logger field_152627_a = LogManager.getLogger();
    private final WorldServer theWorldServer;

    /** players in the current instance */
    private final List players = new ArrayList();

    /** the hash of all playerInstances created */
    private final LongHashMap playerInstances = new LongHashMap();

    /** the playerInstances(chunks) that need to be updated */
    private final List playerInstancesToUpdate = new ArrayList();

    /** This field is using when chunk should be processed (every 8000 ticks) */
    private final List playerInstanceList = new ArrayList();

    /**
     * Number of chunks the server sends to the client. Valid 3<=x<=15. In server.properties.
     */
    private int playerViewRadius;

    /** time what is using to check if InhabitedTime should be calculated */
    private long previousTotalWorldTime;

    /** x, z direction vectors: east, south, west, north */
    private final int[][] xzDirectionsConst = new int[][] {{1, 0}, {0, 1}, { -1, 0}, {0, -1}};
    private static final String __OBFID = "CL_00001434";

    public PlayerManager(WorldServer p_i1176_1_)
    {
        this.theWorldServer = p_i1176_1_;
        this.func_152622_a(p_i1176_1_.func_73046_m().getConfigurationManager().getViewDistance());
    }

    /**
     * Returns the MinecraftServer associated with the PlayerManager.
     */
    public WorldServer getMinecraftServer()
    {
        return this.theWorldServer;
    }

    /**
     * updates all the player instances that need to be updated
     */
    public void updatePlayerInstances()
    {
        long var1 = this.theWorldServer.getTotalWorldTime();
        int var3;
        PlayerManager.PlayerInstance var4;

        if (var1 - this.previousTotalWorldTime > 8000L)
        {
            this.previousTotalWorldTime = var1;

            for (var3 = 0; var3 < this.playerInstanceList.size(); ++var3)
            {
                var4 = (PlayerManager.PlayerInstance)this.playerInstanceList.get(var3);
                var4.onUpdate();
                var4.processChunk();
            }
        }
        else
        {
            for (var3 = 0; var3 < this.playerInstancesToUpdate.size(); ++var3)
            {
                var4 = (PlayerManager.PlayerInstance)this.playerInstancesToUpdate.get(var3);
                var4.onUpdate();
            }
        }

        this.playerInstancesToUpdate.clear();

        if (this.players.isEmpty())
        {
            WorldProvider var5 = this.theWorldServer.provider;

            if (!var5.canRespawnHere())
            {
                this.theWorldServer.theChunkProviderServer.unloadAllChunks();
            }
        }
    }

    public boolean func_152621_a(int p_152621_1_, int p_152621_2_)
    {
        long var3 = (long)p_152621_1_ + 2147483647L | (long)p_152621_2_ + 2147483647L << 32;
        return this.playerInstances.getValueByKey(var3) != null;
    }

    /**
     * passi n the chunk x and y and a flag as to whether or not the instance should be made if it doesnt exist
     */
    private PlayerManager.PlayerInstance getPlayerInstance(int p_72690_1_, int p_72690_2_, boolean p_72690_3_)
    {
        long var4 = (long)p_72690_1_ + 2147483647L | (long)p_72690_2_ + 2147483647L << 32;
        PlayerManager.PlayerInstance var6 = (PlayerManager.PlayerInstance)this.playerInstances.getValueByKey(var4);

        if (var6 == null && p_72690_3_)
        {
            var6 = new PlayerManager.PlayerInstance(p_72690_1_, p_72690_2_);
            this.playerInstances.add(var4, var6);
            this.playerInstanceList.add(var6);
        }

        return var6;
    }

    public void func_151250_a(int p_151250_1_, int p_151250_2_, int p_151250_3_)
    {
        int var4 = p_151250_1_ >> 4;
        int var5 = p_151250_3_ >> 4;
        PlayerManager.PlayerInstance var6 = this.getPlayerInstance(var4, var5, false);

        if (var6 != null)
        {
            var6.func_151253_a(p_151250_1_ & 15, p_151250_2_, p_151250_3_ & 15);
        }
    }

    /**
     * Adds an EntityPlayerMP to the PlayerManager and to all player instances within player visibility
     */
    public void addPlayer(EntityPlayerMP p_72683_1_)
    {
        int var2 = (int)p_72683_1_.posX >> 4;
        int var3 = (int)p_72683_1_.posZ >> 4;
        p_72683_1_.managedPosX = p_72683_1_.posX;
        p_72683_1_.managedPosZ = p_72683_1_.posZ;

        for (int var4 = var2 - this.playerViewRadius; var4 <= var2 + this.playerViewRadius; ++var4)
        {
            for (int var5 = var3 - this.playerViewRadius; var5 <= var3 + this.playerViewRadius; ++var5)
            {
                this.getPlayerInstance(var4, var5, true).addPlayer(p_72683_1_);
            }
        }

        this.players.add(p_72683_1_);
        this.filterChunkLoadQueue(p_72683_1_);
    }

    /**
     * Removes all chunks from the given player's chunk load queue that are not in viewing range of the player.
     */
    public void filterChunkLoadQueue(EntityPlayerMP p_72691_1_)
    {
        ArrayList var2 = new ArrayList(p_72691_1_.loadedChunks);
        int var3 = 0;
        int var4 = this.playerViewRadius;
        int var5 = (int)p_72691_1_.posX >> 4;
        int var6 = (int)p_72691_1_.posZ >> 4;
        int var7 = 0;
        int var8 = 0;
        ChunkCoordIntPair var9 = this.getPlayerInstance(var5, var6, true).currentChunk;
        p_72691_1_.loadedChunks.clear();

        if (var2.contains(var9))
        {
            p_72691_1_.loadedChunks.add(var9);
        }

        int var10;

        for (var10 = 1; var10 <= var4 * 2; ++var10)
        {
            for (int var11 = 0; var11 < 2; ++var11)
            {
                int[] var12 = this.xzDirectionsConst[var3++ % 4];

                for (int var13 = 0; var13 < var10; ++var13)
                {
                    var7 += var12[0];
                    var8 += var12[1];
                    var9 = this.getPlayerInstance(var5 + var7, var6 + var8, true).currentChunk;

                    if (var2.contains(var9))
                    {
                        p_72691_1_.loadedChunks.add(var9);
                    }
                }
            }
        }

        var3 %= 4;

        for (var10 = 0; var10 < var4 * 2; ++var10)
        {
            var7 += this.xzDirectionsConst[var3][0];
            var8 += this.xzDirectionsConst[var3][1];
            var9 = this.getPlayerInstance(var5 + var7, var6 + var8, true).currentChunk;

            if (var2.contains(var9))
            {
                p_72691_1_.loadedChunks.add(var9);
            }
        }
    }

    /**
     * Removes an EntityPlayerMP from the PlayerManager.
     */
    public void removePlayer(EntityPlayerMP p_72695_1_)
    {
        int var2 = (int)p_72695_1_.managedPosX >> 4;
        int var3 = (int)p_72695_1_.managedPosZ >> 4;

        for (int var4 = var2 - this.playerViewRadius; var4 <= var2 + this.playerViewRadius; ++var4)
        {
            for (int var5 = var3 - this.playerViewRadius; var5 <= var3 + this.playerViewRadius; ++var5)
            {
                PlayerManager.PlayerInstance var6 = this.getPlayerInstance(var4, var5, false);

                if (var6 != null)
                {
                    var6.removePlayer(p_72695_1_);
                }
            }
        }

        this.players.remove(p_72695_1_);
    }

    /**
     * Determine if two rectangles centered at the given points overlap for the provided radius. Arguments: x1, z1, x2,
     * z2, radius.
     */
    private boolean overlaps(int p_72684_1_, int p_72684_2_, int p_72684_3_, int p_72684_4_, int p_72684_5_)
    {
        int var6 = p_72684_1_ - p_72684_3_;
        int var7 = p_72684_2_ - p_72684_4_;
        return var6 >= -p_72684_5_ && var6 <= p_72684_5_ ? var7 >= -p_72684_5_ && var7 <= p_72684_5_ : false;
    }

    /**
     * update chunks around a player being moved by server logic (e.g. cart, boat)
     */
    public void updateMountedMovingPlayer(EntityPlayerMP p_72685_1_)
    {
        int var2 = (int)p_72685_1_.posX >> 4;
        int var3 = (int)p_72685_1_.posZ >> 4;
        double var4 = p_72685_1_.managedPosX - p_72685_1_.posX;
        double var6 = p_72685_1_.managedPosZ - p_72685_1_.posZ;
        double var8 = var4 * var4 + var6 * var6;

        if (var8 >= 64.0D)
        {
            int var10 = (int)p_72685_1_.managedPosX >> 4;
            int var11 = (int)p_72685_1_.managedPosZ >> 4;
            int var12 = this.playerViewRadius;
            int var13 = var2 - var10;
            int var14 = var3 - var11;

            if (var13 != 0 || var14 != 0)
            {
                for (int var15 = var2 - var12; var15 <= var2 + var12; ++var15)
                {
                    for (int var16 = var3 - var12; var16 <= var3 + var12; ++var16)
                    {
                        if (!this.overlaps(var15, var16, var10, var11, var12))
                        {
                            this.getPlayerInstance(var15, var16, true).addPlayer(p_72685_1_);
                        }

                        if (!this.overlaps(var15 - var13, var16 - var14, var2, var3, var12))
                        {
                            PlayerManager.PlayerInstance var17 = this.getPlayerInstance(var15 - var13, var16 - var14, false);

                            if (var17 != null)
                            {
                                var17.removePlayer(p_72685_1_);
                            }
                        }
                    }
                }

                this.filterChunkLoadQueue(p_72685_1_);
                p_72685_1_.managedPosX = p_72685_1_.posX;
                p_72685_1_.managedPosZ = p_72685_1_.posZ;
            }
        }
    }

    public boolean isPlayerWatchingChunk(EntityPlayerMP p_72694_1_, int p_72694_2_, int p_72694_3_)
    {
        PlayerManager.PlayerInstance var4 = this.getPlayerInstance(p_72694_2_, p_72694_3_, false);
        return var4 != null && var4.playersWatchingChunk.contains(p_72694_1_) && !p_72694_1_.loadedChunks.contains(var4.currentChunk);
    }

    public void func_152622_a(int p_152622_1_)
    {
        p_152622_1_ = MathHelper.clamp_int(p_152622_1_, 3, 20);

        if (p_152622_1_ != this.playerViewRadius)
        {
            int var2 = p_152622_1_ - this.playerViewRadius;
            Iterator var3 = this.players.iterator();

            while (var3.hasNext())
            {
                EntityPlayerMP var4 = (EntityPlayerMP)var3.next();
                int var5 = (int)var4.posX >> 4;
                int var6 = (int)var4.posZ >> 4;
                int var7;
                int var8;

                if (var2 > 0)
                {
                    for (var7 = var5 - p_152622_1_; var7 <= var5 + p_152622_1_; ++var7)
                    {
                        for (var8 = var6 - p_152622_1_; var8 <= var6 + p_152622_1_; ++var8)
                        {
                            PlayerManager.PlayerInstance var9 = this.getPlayerInstance(var7, var8, true);

                            if (!var9.playersWatchingChunk.contains(var4))
                            {
                                var9.addPlayer(var4);
                            }
                        }
                    }
                }
                else
                {
                    for (var7 = var5 - this.playerViewRadius; var7 <= var5 + this.playerViewRadius; ++var7)
                    {
                        for (var8 = var6 - this.playerViewRadius; var8 <= var6 + this.playerViewRadius; ++var8)
                        {
                            if (!this.overlaps(var7, var8, var5, var6, p_152622_1_))
                            {
                                this.getPlayerInstance(var7, var8, true).removePlayer(var4);
                            }
                        }
                    }
                }
            }

            this.playerViewRadius = p_152622_1_;
        }
    }

    /**
     * Get the furthest viewable block given player's view distance
     */
    public static int getFurthestViewableBlock(int p_72686_0_)
    {
        return p_72686_0_ * 16 - 16;
    }

    class PlayerInstance
    {
        private final List playersWatchingChunk = new ArrayList();
        private final ChunkCoordIntPair currentChunk;
        private short[] field_151254_d = new short[64];
        private int numBlocksToUpdate;
        private int flagsYAreasToUpdate;
        private long previousWorldTime;
        private static final String __OBFID = "CL_00001435";

        public PlayerInstance(int p_i1518_2_, int p_i1518_3_)
        {
            this.currentChunk = new ChunkCoordIntPair(p_i1518_2_, p_i1518_3_);
            PlayerManager.this.getMinecraftServer().theChunkProviderServer.loadChunk(p_i1518_2_, p_i1518_3_);
        }

        public void addPlayer(EntityPlayerMP p_73255_1_)
        {
            if (this.playersWatchingChunk.contains(p_73255_1_))
            {
                PlayerManager.field_152627_a.debug("Failed to add player. {} already is in chunk {}, {}", new Object[] {p_73255_1_, Integer.valueOf(this.currentChunk.chunkXPos), Integer.valueOf(this.currentChunk.chunkZPos)});
            }
            else
            {
                if (this.playersWatchingChunk.isEmpty())
                {
                    this.previousWorldTime = PlayerManager.this.theWorldServer.getTotalWorldTime();
                }

                this.playersWatchingChunk.add(p_73255_1_);
                p_73255_1_.loadedChunks.add(this.currentChunk);
            }
        }

        public void removePlayer(EntityPlayerMP p_73252_1_)
        {
            if (this.playersWatchingChunk.contains(p_73252_1_))
            {
                Chunk var2 = PlayerManager.this.theWorldServer.getChunkFromChunkCoords(this.currentChunk.chunkXPos, this.currentChunk.chunkZPos);

                if (var2.func_150802_k())
                {
                    p_73252_1_.playerNetServerHandler.sendPacket(new S21PacketChunkData(var2, true, 0));
                }

                this.playersWatchingChunk.remove(p_73252_1_);
                p_73252_1_.loadedChunks.remove(this.currentChunk);

                if (this.playersWatchingChunk.isEmpty())
                {
                    long var3 = (long)this.currentChunk.chunkXPos + 2147483647L | (long)this.currentChunk.chunkZPos + 2147483647L << 32;
                    this.increaseInhabitedTime(var2);
                    PlayerManager.this.playerInstances.remove(var3);
                    PlayerManager.this.playerInstanceList.remove(this);

                    if (this.numBlocksToUpdate > 0)
                    {
                        PlayerManager.this.playerInstancesToUpdate.remove(this);
                    }

                    PlayerManager.this.getMinecraftServer().theChunkProviderServer.dropChunk(this.currentChunk.chunkXPos, this.currentChunk.chunkZPos);
                }
            }
        }

        public void processChunk()
        {
            this.increaseInhabitedTime(PlayerManager.this.theWorldServer.getChunkFromChunkCoords(this.currentChunk.chunkXPos, this.currentChunk.chunkZPos));
        }

        private void increaseInhabitedTime(Chunk p_111196_1_)
        {
            p_111196_1_.inhabitedTime += PlayerManager.this.theWorldServer.getTotalWorldTime() - this.previousWorldTime;
            this.previousWorldTime = PlayerManager.this.theWorldServer.getTotalWorldTime();
        }

        public void func_151253_a(int p_151253_1_, int p_151253_2_, int p_151253_3_)
        {
            if (this.numBlocksToUpdate == 0)
            {
                PlayerManager.this.playerInstancesToUpdate.add(this);
            }

            this.flagsYAreasToUpdate |= 1 << (p_151253_2_ >> 4);

            if (this.numBlocksToUpdate < 64)
            {
                short var4 = (short)(p_151253_1_ << 12 | p_151253_3_ << 8 | p_151253_2_);

                for (int var5 = 0; var5 < this.numBlocksToUpdate; ++var5)
                {
                    if (this.field_151254_d[var5] == var4)
                    {
                        return;
                    }
                }

                this.field_151254_d[this.numBlocksToUpdate++] = var4;
            }
        }

        public void func_151251_a(Packet p_151251_1_)
        {
            for (int var2 = 0; var2 < this.playersWatchingChunk.size(); ++var2)
            {
                EntityPlayerMP var3 = (EntityPlayerMP)this.playersWatchingChunk.get(var2);

                if (!var3.loadedChunks.contains(this.currentChunk))
                {
                    var3.playerNetServerHandler.sendPacket(p_151251_1_);
                }
            }
        }

        public void onUpdate()
        {
            if (this.numBlocksToUpdate != 0)
            {
                int var1;
                int var2;
                int var3;

                if (this.numBlocksToUpdate == 1)
                {
                    var1 = this.currentChunk.chunkXPos * 16 + (this.field_151254_d[0] >> 12 & 15);
                    var2 = this.field_151254_d[0] & 255;
                    var3 = this.currentChunk.chunkZPos * 16 + (this.field_151254_d[0] >> 8 & 15);
                    this.func_151251_a(new S23PacketBlockChange(var1, var2, var3, PlayerManager.this.theWorldServer));

                    if (PlayerManager.this.theWorldServer.getBlock(var1, var2, var3).hasTileEntity())
                    {
                        this.func_151252_a(PlayerManager.this.theWorldServer.getTileEntity(var1, var2, var3));
                    }
                }
                else
                {
                    int var4;

                    if (this.numBlocksToUpdate == 64)
                    {
                        var1 = this.currentChunk.chunkXPos * 16;
                        var2 = this.currentChunk.chunkZPos * 16;
                        this.func_151251_a(new S21PacketChunkData(PlayerManager.this.theWorldServer.getChunkFromChunkCoords(this.currentChunk.chunkXPos, this.currentChunk.chunkZPos), false, this.flagsYAreasToUpdate));

                        for (var3 = 0; var3 < 16; ++var3)
                        {
                            if ((this.flagsYAreasToUpdate & 1 << var3) != 0)
                            {
                                var4 = var3 << 4;
                                List var5 = PlayerManager.this.theWorldServer.func_147486_a(var1, var4, var2, var1 + 16, var4 + 16, var2 + 16);

                                for (int var6 = 0; var6 < var5.size(); ++var6)
                                {
                                    this.func_151252_a((TileEntity)var5.get(var6));
                                }
                            }
                        }
                    }
                    else
                    {
                        this.func_151251_a(new S22PacketMultiBlockChange(this.numBlocksToUpdate, this.field_151254_d, PlayerManager.this.theWorldServer.getChunkFromChunkCoords(this.currentChunk.chunkXPos, this.currentChunk.chunkZPos)));

                        for (var1 = 0; var1 < this.numBlocksToUpdate; ++var1)
                        {
                            var2 = this.currentChunk.chunkXPos * 16 + (this.field_151254_d[var1] >> 12 & 15);
                            var3 = this.field_151254_d[var1] & 255;
                            var4 = this.currentChunk.chunkZPos * 16 + (this.field_151254_d[var1] >> 8 & 15);

                            if (PlayerManager.this.theWorldServer.getBlock(var2, var3, var4).hasTileEntity())
                            {
                                this.func_151252_a(PlayerManager.this.theWorldServer.getTileEntity(var2, var3, var4));
                            }
                        }
                    }
                }

                this.numBlocksToUpdate = 0;
                this.flagsYAreasToUpdate = 0;
            }
        }

        private void func_151252_a(TileEntity p_151252_1_)
        {
            if (p_151252_1_ != null)
            {
                Packet var2 = p_151252_1_.getDescriptionPacket();

                if (var2 != null)
                {
                    this.func_151251_a(var2);
                }
            }
        }
    }
}
