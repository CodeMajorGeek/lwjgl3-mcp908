package net.minecraft.item;

import net.minecraft.util.EnumChatFormatting;

public enum EnumRarity
{
    common(EnumChatFormatting.WHITE, "Common"),
    uncommon(EnumChatFormatting.YELLOW, "Uncommon"),
    rare(EnumChatFormatting.AQUA, "Rare"),
    epic(EnumChatFormatting.LIGHT_PURPLE, "Epic");
    public final EnumChatFormatting field_77937_e;
    public final String field_77934_f;
    private static final String __OBFID = "CL_00000056";

    private EnumRarity(EnumChatFormatting p_i45349_3_, String p_i45349_4_)
    {
        this.field_77937_e = p_i45349_3_;
        this.field_77934_f = p_i45349_4_;
    }
}
