package net.minecraft.network.rcon;

import com.google.common.base.Charsets;

public class RConUtils
{
    /** Translation array of decimal to hex digits */
    public static char[] hexDigits = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final String __OBFID = "CL_00001799";

    /**
     * Read a null-terminated string from the given byte array
     */
    public static String getBytesAsString(byte[] p_72661_0_, int p_72661_1_, int p_72661_2_)
    {
        int var3 = p_72661_2_ - 1;
        int var4;

        for (var4 = p_72661_1_ > var3 ? var3 : p_72661_1_; 0 != p_72661_0_[var4] && var4 < var3; ++var4)
        {
            ;
        }

        return new String(p_72661_0_, p_72661_1_, var4 - p_72661_1_, Charsets.UTF_8);
    }

    /**
     * Read 4 bytes from the
     */
    public static int getRemainingBytesAsLEInt(byte[] p_72662_0_, int p_72662_1_)
    {
        return getBytesAsLEInt(p_72662_0_, p_72662_1_, p_72662_0_.length);
    }

    /**
     * Read 4 bytes from the given array in little-endian format and return them as an int
     */
    public static int getBytesAsLEInt(byte[] p_72665_0_, int p_72665_1_, int p_72665_2_)
    {
        return 0 > p_72665_2_ - p_72665_1_ - 4 ? 0 : p_72665_0_[p_72665_1_ + 3] << 24 | (p_72665_0_[p_72665_1_ + 2] & 255) << 16 | (p_72665_0_[p_72665_1_ + 1] & 255) << 8 | p_72665_0_[p_72665_1_] & 255;
    }

    /**
     * Read 4 bytes from the given array in big-endian format and return them as an int
     */
    public static int getBytesAsBEint(byte[] p_72664_0_, int p_72664_1_, int p_72664_2_)
    {
        return 0 > p_72664_2_ - p_72664_1_ - 4 ? 0 : p_72664_0_[p_72664_1_] << 24 | (p_72664_0_[p_72664_1_ + 1] & 255) << 16 | (p_72664_0_[p_72664_1_ + 2] & 255) << 8 | p_72664_0_[p_72664_1_ + 3] & 255;
    }

    /**
     * Returns a String representation of the byte in hexadecimal format
     */
    public static String getByteAsHexString(byte p_72663_0_)
    {
        return "" + hexDigits[(p_72663_0_ & 240) >>> 4] + hexDigits[p_72663_0_ & 15];
    }
}
