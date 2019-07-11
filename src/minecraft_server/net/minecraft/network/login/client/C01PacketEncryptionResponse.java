package net.minecraft.network.login.client;

import java.io.IOException;
import java.security.PrivateKey;
import javax.crypto.SecretKey;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.login.INetHandlerLoginServer;
import net.minecraft.util.CryptManager;

public class C01PacketEncryptionResponse extends Packet
{
    private byte[] field_149302_a = new byte[0];
    private byte[] field_149301_b = new byte[0];
    private static final String __OBFID = "CL_00001380";

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer p_148837_1_) throws IOException
    {
        this.field_149302_a = readBlob(p_148837_1_);
        this.field_149301_b = readBlob(p_148837_1_);
    }

    /**
     * Writes the raw packet data to the data stream.
     */
    public void writePacketData(PacketBuffer p_148840_1_) throws IOException
    {
        writeBlob(p_148840_1_, this.field_149302_a);
        writeBlob(p_148840_1_, this.field_149301_b);
    }

    public void func_148833_a(INetHandlerLoginServer p_148833_1_)
    {
        p_148833_1_.processEncryptionResponse(this);
    }

    public SecretKey func_149300_a(PrivateKey p_149300_1_)
    {
        return CryptManager.decryptSharedKey(p_149300_1_, this.field_149302_a);
    }

    public byte[] func_149299_b(PrivateKey p_149299_1_)
    {
        return p_149299_1_ == null ? this.field_149301_b : CryptManager.decryptData(p_149299_1_, this.field_149301_b);
    }

    public void func_148833_a(INetHandler p_148833_1_)
    {
        this.func_148833_a((INetHandlerLoginServer)p_148833_1_);
    }
}
