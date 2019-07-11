package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S08PacketPlayerPosLook extends Packet
{
    private double field_148940_a;
    private double field_148938_b;
    private double field_148939_c;
    private float field_148936_d;
    private float field_148937_e;
    private boolean field_148935_f;
    private static final String __OBFID = "CL_00001273";

    public S08PacketPlayerPosLook() {}

    public S08PacketPlayerPosLook(double p_i45164_1_, double p_i45164_3_, double p_i45164_5_, float p_i45164_7_, float p_i45164_8_, boolean p_i45164_9_)
    {
        this.field_148940_a = p_i45164_1_;
        this.field_148938_b = p_i45164_3_;
        this.field_148939_c = p_i45164_5_;
        this.field_148936_d = p_i45164_7_;
        this.field_148937_e = p_i45164_8_;
        this.field_148935_f = p_i45164_9_;
    }

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer p_148837_1_) throws IOException
    {
        this.field_148940_a = p_148837_1_.readDouble();
        this.field_148938_b = p_148837_1_.readDouble();
        this.field_148939_c = p_148837_1_.readDouble();
        this.field_148936_d = p_148837_1_.readFloat();
        this.field_148937_e = p_148837_1_.readFloat();
        this.field_148935_f = p_148837_1_.readBoolean();
    }

    /**
     * Writes the raw packet data to the data stream.
     */
    public void writePacketData(PacketBuffer p_148840_1_) throws IOException
    {
        p_148840_1_.writeDouble(this.field_148940_a);
        p_148840_1_.writeDouble(this.field_148938_b);
        p_148840_1_.writeDouble(this.field_148939_c);
        p_148840_1_.writeFloat(this.field_148936_d);
        p_148840_1_.writeFloat(this.field_148937_e);
        p_148840_1_.writeBoolean(this.field_148935_f);
    }

    public void func_148833_a(INetHandlerPlayClient p_148833_1_)
    {
        p_148833_1_.handlePlayerPosLook(this);
    }

    public void func_148833_a(INetHandler p_148833_1_)
    {
        this.func_148833_a((INetHandlerPlayClient)p_148833_1_);
    }
}
