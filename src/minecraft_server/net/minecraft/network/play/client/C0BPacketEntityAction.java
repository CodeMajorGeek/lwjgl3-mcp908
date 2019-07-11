package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;

public class C0BPacketEntityAction extends Packet
{
    private int field_149517_a;
    private int field_149515_b;
    private int field_149516_c;
    private static final String __OBFID = "CL_00001366";

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer p_148837_1_) throws IOException
    {
        this.field_149517_a = p_148837_1_.readInt();
        this.field_149515_b = p_148837_1_.readByte();
        this.field_149516_c = p_148837_1_.readInt();
    }

    /**
     * Writes the raw packet data to the data stream.
     */
    public void writePacketData(PacketBuffer p_148840_1_) throws IOException
    {
        p_148840_1_.writeInt(this.field_149517_a);
        p_148840_1_.writeByte(this.field_149515_b);
        p_148840_1_.writeInt(this.field_149516_c);
    }

    public void func_148833_a(INetHandlerPlayServer p_148833_1_)
    {
        p_148833_1_.func_147357_a(this);
    }

    public int func_149513_d()
    {
        return this.field_149515_b;
    }

    public int func_149512_e()
    {
        return this.field_149516_c;
    }

    public void func_148833_a(INetHandler p_148833_1_)
    {
        this.func_148833_a((INetHandlerPlayServer)p_148833_1_);
    }
}
