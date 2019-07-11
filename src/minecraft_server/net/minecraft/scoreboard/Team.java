package net.minecraft.scoreboard;

public abstract class Team
{
    private static final String __OBFID = "CL_00000621";

    /**
     * Same as ==
     */
    public boolean isSameTeam(Team p_142054_1_)
    {
        return p_142054_1_ == null ? false : this == p_142054_1_;
    }

    /**
     * Retrieve the name by which this team is registered in the scoreboard
     */
    public abstract String getRegisteredName();

    public abstract String formatString(String p_142053_1_);

    public abstract boolean getAllowFriendlyFire();
}
