package net.minecraft.util;

import java.util.regex.Pattern;

public class StringUtils
{
    private static final Pattern patternControlCode = Pattern.compile("(?i)\\u00A7[0-9A-FK-OR]");
    private static final String __OBFID = "CL_00001501";

    /**
     * Returns a value indicating whether the given string is null or empty.
     */
    public static boolean isNullOrEmpty(String p_151246_0_)
    {
        return p_151246_0_ == null || "".equals(p_151246_0_);
    }
}
