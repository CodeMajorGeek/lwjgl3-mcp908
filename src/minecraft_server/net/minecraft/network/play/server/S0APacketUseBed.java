package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S0APacketUseBed extends Packet
{
    private int field_149097_a;
    private int field_149095_b;
    private int field_149096_c;
    private int field_149094_d;
    private static final String __OBFID = "CL_00001319";

    public S0APacketUseBed() {}

    public S0APacketUseBed(EntityPlayer p_i45210_1_, int p_i45210_2_, int p_i45210_3_, int p_i45210_4_)
    {
        this.field_149095_b = p_i45210_2_;
        this.field_149096_c = p_i45210_3_;
        this.field_149094_d = p_i45210_4_;
        this.field_149097_a = p_i45210_1_.getEntityId();
    }

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer p_148837_1_) throws IOException
    {
        this.field_149097_a = p_148837_1_.readInt();
        this.field_149095_b = p_148837_1_.readInt();
        this.field_149096_c = p_148837_1_.readByte();
        this.field_149094_d = p_148837_1_.readInt();
    }

    /**
     * Writes the raw packet data to the data stream.
     */
    public void writePacketData(PacketBuffer p_148840_1_) throws IOException
    {
        p_148840_1_.writeInt(this.field_149097_a);
        p_148840_1_.writeInt(this.field_149095_b);
        p_148840_1_.writeByte(this.field_149096_c);
        p_148840_1_.writeInt(this.field_149094_d);
    }

    public void func_148833_a(INetHandlerPlayClient p_148833_1_)
    {
        p_148833_1_.handleUseBed(this);
    }

    public void func_148833_a(INetHandler p_148833_1_)
    {
        this.func_148833_a((INetHandlerPlayClient)p_148833_1_);
    }
}
