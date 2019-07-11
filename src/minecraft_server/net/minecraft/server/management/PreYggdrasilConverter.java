package net.minecraft.server.management;

import com.google.common.base.Charsets;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import com.mojang.authlib.Agent;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.ProfileLookupCallback;
import com.mojang.authlib.yggdrasil.ProfileNotFoundException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.dedicated.PropertyManager;
import net.minecraft.util.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PreYggdrasilConverter
{
    private static final Logger field_152732_e = LogManager.getLogger();
    public static final File field_152728_a = new File("banned-ips.txt");
    public static final File field_152729_b = new File("banned-players.txt");
    public static final File field_152730_c = new File("ops.txt");
    public static final File field_152731_d = new File("white-list.txt");
    private static final String __OBFID = "CL_00001882";

    static List func_152721_a(File p_152721_0_, Map p_152721_1_) throws IOException
    {
        List var2 = Files.readLines(p_152721_0_, Charsets.UTF_8);
        Iterator var3 = var2.iterator();

        while (var3.hasNext())
        {
            String var4 = (String)var3.next();
            var4 = var4.trim();

            if (!var4.startsWith("#") && var4.length() >= 1)
            {
                String[] var5 = var4.split("\\|");
                p_152721_1_.put(var5[0].toLowerCase(Locale.ROOT), var5);
            }
        }

        return var2;
    }

    private static void func_152717_a(MinecraftServer p_152717_0_, Collection p_152717_1_, ProfileLookupCallback p_152717_2_)
    {
        String[] var3 = (String[])Iterators.toArray(Iterators.filter(p_152717_1_.iterator(), new Predicate()
        {
            private static final String __OBFID = "CL_00001881";
            public boolean func_152733_a(String p_152733_1_)
            {
                return !StringUtils.isNullOrEmpty(p_152733_1_);
            }
            public boolean apply(Object p_apply_1_)
            {
                return this.func_152733_a((String)p_apply_1_);
            }
        }), String.class);

        if (p_152717_0_.isServerInOnlineMode())
        {
            p_152717_0_.func_152359_aw().findProfilesByNames(var3, Agent.MINECRAFT, p_152717_2_);
        }
        else
        {
            String[] var4 = var3;
            int var5 = var3.length;

            for (int var6 = 0; var6 < var5; ++var6)
            {
                String var7 = var4[var6];
                UUID var8 = EntityPlayer.func_146094_a(new GameProfile((UUID)null, var7));
                GameProfile var9 = new GameProfile(var8, var7);
                p_152717_2_.onProfileLookupSucceeded(var9);
            }
        }
    }

    public static boolean func_152724_a(final MinecraftServer p_152724_0_) throws IOException
    {
        final UserListBans var1 = new UserListBans(ServerConfigurationManager.field_152613_a);

        if (field_152729_b.exists() && field_152729_b.isFile())
        {
            if (var1.func_152691_c().exists())
            {
                try
                {
                    var1.func_152679_g();
                }
                catch (FileNotFoundException var6)
                {
                    field_152732_e.warn("Could not load existing file " + var1.func_152691_c().getName(), var6);
                }
            }

            try
            {
                final HashMap var2 = Maps.newHashMap();
                func_152721_a(field_152729_b, var2);
                ProfileLookupCallback var3 = new ProfileLookupCallback()
                {
                    private static final String __OBFID = "CL_00001910";
                    public void onProfileLookupSucceeded(GameProfile p_onProfileLookupSucceeded_1_)
                    {
                        p_152724_0_.func_152358_ax().func_152649_a(p_onProfileLookupSucceeded_1_);
                        String[] var2x = (String[])var2.get(p_onProfileLookupSucceeded_1_.getName().toLowerCase(Locale.ROOT));

                        if (var2x == null)
                        {
                            PreYggdrasilConverter.field_152732_e.warn("Could not convert user banlist entry for " + p_onProfileLookupSucceeded_1_.getName());
                            throw new PreYggdrasilConverter.ConversionError("Profile not in the conversionlist", null);
                        }
                        else
                        {
                            Date var3 = var2x.length > 1 ? PreYggdrasilConverter.func_152713_b(var2x[1], (Date)null) : null;
                            String var4 = var2x.length > 2 ? var2x[2] : null;
                            Date var5 = var2x.length > 3 ? PreYggdrasilConverter.func_152713_b(var2x[3], (Date)null) : null;
                            String var6 = var2x.length > 4 ? var2x[4] : null;
                            var1.func_152687_a(new UserListBansEntry(p_onProfileLookupSucceeded_1_, var3, var4, var5, var6));
                        }
                    }
                    public void onProfileLookupFailed(GameProfile p_onProfileLookupFailed_1_, Exception p_onProfileLookupFailed_2_)
                    {
                        PreYggdrasilConverter.field_152732_e.warn("Could not lookup user banlist entry for " + p_onProfileLookupFailed_1_.getName(), p_onProfileLookupFailed_2_);

                        if (!(p_onProfileLookupFailed_2_ instanceof ProfileNotFoundException))
                        {
                            throw new PreYggdrasilConverter.ConversionError("Could not request user " + p_onProfileLookupFailed_1_.getName() + " from backend systems", p_onProfileLookupFailed_2_, null);
                        }
                    }
                };
                func_152717_a(p_152724_0_, var2.keySet(), var3);
                var1.func_152678_f();
                func_152727_c(field_152729_b);
                return true;
            }
            catch (IOException var4)
            {
                field_152732_e.warn("Could not read old user banlist to convert it!", var4);
                return false;
            }
            catch (PreYggdrasilConverter.ConversionError var5)
            {
                field_152732_e.error("Conversion failed, please try again later", var5);
                return false;
            }
        }
        else
        {
            return true;
        }
    }

    public static boolean func_152722_b(MinecraftServer p_152722_0_) throws IOException
    {
        BanList var1 = new BanList(ServerConfigurationManager.field_152614_b);

        if (field_152728_a.exists() && field_152728_a.isFile())
        {
            if (var1.func_152691_c().exists())
            {
                try
                {
                    var1.func_152679_g();
                }
                catch (FileNotFoundException var11)
                {
                    field_152732_e.warn("Could not load existing file " + var1.func_152691_c().getName(), var11);
                }
            }

            try
            {
                HashMap var2 = Maps.newHashMap();
                func_152721_a(field_152728_a, var2);
                Iterator var3 = var2.keySet().iterator();

                while (var3.hasNext())
                {
                    String var4 = (String)var3.next();
                    String[] var5 = (String[])var2.get(var4);
                    Date var6 = var5.length > 1 ? func_152713_b(var5[1], (Date)null) : null;
                    String var7 = var5.length > 2 ? var5[2] : null;
                    Date var8 = var5.length > 3 ? func_152713_b(var5[3], (Date)null) : null;
                    String var9 = var5.length > 4 ? var5[4] : null;
                    var1.func_152687_a(new IPBanEntry(var4, var6, var7, var8, var9));
                }

                var1.func_152678_f();
                func_152727_c(field_152728_a);
                return true;
            }
            catch (IOException var10)
            {
                field_152732_e.warn("Could not parse old ip banlist to convert it!", var10);
                return false;
            }
        }
        else
        {
            return true;
        }
    }

    public static boolean func_152718_c(final MinecraftServer p_152718_0_) throws IOException
    {
        final UserListOps var1 = new UserListOps(ServerConfigurationManager.field_152615_c);

        if (field_152730_c.exists() && field_152730_c.isFile())
        {
            if (var1.func_152691_c().exists())
            {
                try
                {
                    var1.func_152679_g();
                }
                catch (FileNotFoundException var6)
                {
                    field_152732_e.warn("Could not load existing file " + var1.func_152691_c().getName(), var6);
                }
            }

            try
            {
                List var2 = Files.readLines(field_152730_c, Charsets.UTF_8);
                ProfileLookupCallback var3 = new ProfileLookupCallback()
                {
                    private static final String __OBFID = "CL_00001909";
                    public void onProfileLookupSucceeded(GameProfile p_onProfileLookupSucceeded_1_)
                    {
                        p_152718_0_.func_152358_ax().func_152649_a(p_onProfileLookupSucceeded_1_);
                        var1.func_152687_a(new UserListOpsEntry(p_onProfileLookupSucceeded_1_, p_152718_0_.getOpPermissionLevel()));
                    }
                    public void onProfileLookupFailed(GameProfile p_onProfileLookupFailed_1_, Exception p_onProfileLookupFailed_2_)
                    {
                        PreYggdrasilConverter.field_152732_e.warn("Could not lookup oplist entry for " + p_onProfileLookupFailed_1_.getName(), p_onProfileLookupFailed_2_);

                        if (!(p_onProfileLookupFailed_2_ instanceof ProfileNotFoundException))
                        {
                            throw new PreYggdrasilConverter.ConversionError("Could not request user " + p_onProfileLookupFailed_1_.getName() + " from backend systems", p_onProfileLookupFailed_2_, null);
                        }
                    }
                };
                func_152717_a(p_152718_0_, var2, var3);
                var1.func_152678_f();
                func_152727_c(field_152730_c);
                return true;
            }
            catch (IOException var4)
            {
                field_152732_e.warn("Could not read old oplist to convert it!", var4);
                return false;
            }
            catch (PreYggdrasilConverter.ConversionError var5)
            {
                field_152732_e.error("Conversion failed, please try again later", var5);
                return false;
            }
        }
        else
        {
            return true;
        }
    }

    public static boolean func_152710_d(final MinecraftServer p_152710_0_) throws IOException
    {
        final UserListWhitelist var1 = new UserListWhitelist(ServerConfigurationManager.field_152616_d);

        if (field_152731_d.exists() && field_152731_d.isFile())
        {
            if (var1.func_152691_c().exists())
            {
                try
                {
                    var1.func_152679_g();
                }
                catch (FileNotFoundException var6)
                {
                    field_152732_e.warn("Could not load existing file " + var1.func_152691_c().getName(), var6);
                }
            }

            try
            {
                List var2 = Files.readLines(field_152731_d, Charsets.UTF_8);
                ProfileLookupCallback var3 = new ProfileLookupCallback()
                {
                    private static final String __OBFID = "CL_00001908";
                    public void onProfileLookupSucceeded(GameProfile p_onProfileLookupSucceeded_1_)
                    {
                        p_152710_0_.func_152358_ax().func_152649_a(p_onProfileLookupSucceeded_1_);
                        var1.func_152687_a(new UserListWhitelistEntry(p_onProfileLookupSucceeded_1_));
                    }
                    public void onProfileLookupFailed(GameProfile p_onProfileLookupFailed_1_, Exception p_onProfileLookupFailed_2_)
                    {
                        PreYggdrasilConverter.field_152732_e.warn("Could not lookup user whitelist entry for " + p_onProfileLookupFailed_1_.getName(), p_onProfileLookupFailed_2_);

                        if (!(p_onProfileLookupFailed_2_ instanceof ProfileNotFoundException))
                        {
                            throw new PreYggdrasilConverter.ConversionError("Could not request user " + p_onProfileLookupFailed_1_.getName() + " from backend systems", p_onProfileLookupFailed_2_, null);
                        }
                    }
                };
                func_152717_a(p_152710_0_, var2, var3);
                var1.func_152678_f();
                func_152727_c(field_152731_d);
                return true;
            }
            catch (IOException var4)
            {
                field_152732_e.warn("Could not read old whitelist to convert it!", var4);
                return false;
            }
            catch (PreYggdrasilConverter.ConversionError var5)
            {
                field_152732_e.error("Conversion failed, please try again later", var5);
                return false;
            }
        }
        else
        {
            return true;
        }
    }

    public static String func_152719_a(String p_152719_0_)
    {
        if (!StringUtils.isNullOrEmpty(p_152719_0_) && p_152719_0_.length() <= 16)
        {
            final MinecraftServer var1 = MinecraftServer.getServer();
            GameProfile var2 = var1.func_152358_ax().func_152655_a(p_152719_0_);

            if (var2 != null && var2.getId() != null)
            {
                return var2.getId().toString();
            }
            else if (!var1.isSinglePlayer() && var1.isServerInOnlineMode())
            {
                final ArrayList var3 = Lists.newArrayList();
                ProfileLookupCallback var4 = new ProfileLookupCallback()
                {
                    private static final String __OBFID = "CL_00001880";
                    public void onProfileLookupSucceeded(GameProfile p_onProfileLookupSucceeded_1_)
                    {
                        var1.func_152358_ax().func_152649_a(p_onProfileLookupSucceeded_1_);
                        var3.add(p_onProfileLookupSucceeded_1_);
                    }
                    public void onProfileLookupFailed(GameProfile p_onProfileLookupFailed_1_, Exception p_onProfileLookupFailed_2_)
                    {
                        PreYggdrasilConverter.field_152732_e.warn("Could not lookup user whitelist entry for " + p_onProfileLookupFailed_1_.getName(), p_onProfileLookupFailed_2_);
                    }
                };
                func_152717_a(var1, Lists.newArrayList(new String[] {p_152719_0_}), var4);
                return var3.size() > 0 && ((GameProfile)var3.get(0)).getId() != null ? ((GameProfile)var3.get(0)).getId().toString() : "";
            }
            else
            {
                return EntityPlayer.func_146094_a(new GameProfile((UUID)null, p_152719_0_)).toString();
            }
        }
        else
        {
            return p_152719_0_;
        }
    }

    public static boolean func_152723_a(final DedicatedServer p_152723_0_, PropertyManager p_152723_1_)
    {
        final File var2 = func_152725_d(p_152723_1_);
        final File var3 = new File(var2.getParentFile(), "playerdata");
        final File var4 = new File(var2.getParentFile(), "unknownplayers");

        if (var2.exists() && var2.isDirectory())
        {
            File[] var5 = var2.listFiles();
            ArrayList var6 = Lists.newArrayList();
            File[] var7 = var5;
            int var8 = var5.length;

            for (int var9 = 0; var9 < var8; ++var9)
            {
                File var10 = var7[var9];
                String var11 = var10.getName();

                if (var11.toLowerCase(Locale.ROOT).endsWith(".dat"))
                {
                    String var12 = var11.substring(0, var11.length() - ".dat".length());

                    if (var12.length() > 0)
                    {
                        var6.add(var12);
                    }
                }
            }

            try
            {
                final String[] var14 = (String[])var6.toArray(new String[var6.size()]);
                ProfileLookupCallback var15 = new ProfileLookupCallback()
                {
                    private static final String __OBFID = "CL_00001907";
                    public void onProfileLookupSucceeded(GameProfile p_onProfileLookupSucceeded_1_)
                    {
                        p_152723_0_.func_152358_ax().func_152649_a(p_onProfileLookupSucceeded_1_);
                        UUID var2x = p_onProfileLookupSucceeded_1_.getId();

                        if (var2x == null)
                        {
                            throw new PreYggdrasilConverter.ConversionError("Missing UUID for user profile " + p_onProfileLookupSucceeded_1_.getName(), null);
                        }
                        else
                        {
                            this.func_152743_a(var3, this.func_152744_a(p_onProfileLookupSucceeded_1_), var2x.toString());
                        }
                    }
                    public void onProfileLookupFailed(GameProfile p_onProfileLookupFailed_1_, Exception p_onProfileLookupFailed_2_)
                    {
                        PreYggdrasilConverter.field_152732_e.warn("Could not lookup user uuid for " + p_onProfileLookupFailed_1_.getName(), p_onProfileLookupFailed_2_);

                        if (p_onProfileLookupFailed_2_ instanceof ProfileNotFoundException)
                        {
                            String var3x = this.func_152744_a(p_onProfileLookupFailed_1_);
                            this.func_152743_a(var4, var3x, var3x);
                        }
                        else
                        {
                            throw new PreYggdrasilConverter.ConversionError("Could not request user " + p_onProfileLookupFailed_1_.getName() + " from backend systems", p_onProfileLookupFailed_2_, null);
                        }
                    }
                    private void func_152743_a(File p_152743_1_, String p_152743_2_, String p_152743_3_)
                    {
                        File var4x = new File(var2, p_152743_2_ + ".dat");
                        File var5 = new File(p_152743_1_, p_152743_3_ + ".dat");
                        PreYggdrasilConverter.func_152711_b(p_152743_1_);

                        if (!var4x.renameTo(var5))
                        {
                            throw new PreYggdrasilConverter.ConversionError("Could not convert file for " + p_152743_2_, null);
                        }
                    }
                    private String func_152744_a(GameProfile p_152744_1_)
                    {
                        String var2x = null;

                        for (int var3x = 0; var3x < var14.length; ++var3x)
                        {
                            if (var14[var3x] != null && var14[var3x].equalsIgnoreCase(p_152744_1_.getName()))
                            {
                                var2x = var14[var3x];
                                break;
                            }
                        }

                        if (var2x == null)
                        {
                            throw new PreYggdrasilConverter.ConversionError("Could not find the filename for " + p_152744_1_.getName() + " anymore", null);
                        }
                        else
                        {
                            return var2x;
                        }
                    }
                };
                func_152717_a(p_152723_0_, Lists.newArrayList(var14), var15);
                return true;
            }
            catch (PreYggdrasilConverter.ConversionError var13)
            {
                field_152732_e.error("Conversion failed, please try again later", var13);
                return false;
            }
        }
        else
        {
            return true;
        }
    }

    private static void func_152711_b(File p_152711_0_)
    {
        if (p_152711_0_.exists())
        {
            if (!p_152711_0_.isDirectory())
            {
                throw new PreYggdrasilConverter.ConversionError("Can\'t create directory " + p_152711_0_.getName() + " in world save directory.", null);
            }
        }
        else if (!p_152711_0_.mkdirs())
        {
            throw new PreYggdrasilConverter.ConversionError("Can\'t create directory " + p_152711_0_.getName() + " in world save directory.", null);
        }
    }

    public static boolean func_152714_a(PropertyManager p_152714_0_)
    {
        boolean var1 = func_152712_b(p_152714_0_);
        var1 = var1 && func_152715_c(p_152714_0_);
        return var1;
    }

    private static boolean func_152712_b(PropertyManager p_152712_0_)
    {
        boolean var1 = false;

        if (field_152729_b.exists() && field_152729_b.isFile())
        {
            var1 = true;
        }

        boolean var2 = false;

        if (field_152728_a.exists() && field_152728_a.isFile())
        {
            var2 = true;
        }

        boolean var3 = false;

        if (field_152730_c.exists() && field_152730_c.isFile())
        {
            var3 = true;
        }

        boolean var4 = false;

        if (field_152731_d.exists() && field_152731_d.isFile())
        {
            var4 = true;
        }

        if (!var1 && !var2 && !var3 && !var4)
        {
            return true;
        }
        else
        {
            field_152732_e.warn("**** FAILED TO START THE SERVER AFTER ACCOUNT CONVERSION!");
            field_152732_e.warn("** please remove the following files and restart the server:");

            if (var1)
            {
                field_152732_e.warn("* " + field_152729_b.getName());
            }

            if (var2)
            {
                field_152732_e.warn("* " + field_152728_a.getName());
            }

            if (var3)
            {
                field_152732_e.warn("* " + field_152730_c.getName());
            }

            if (var4)
            {
                field_152732_e.warn("* " + field_152731_d.getName());
            }

            return false;
        }
    }

    private static boolean func_152715_c(PropertyManager p_152715_0_)
    {
        File var1 = func_152725_d(p_152715_0_);

        if (var1.exists() && var1.isDirectory())
        {
            String[] var2 = var1.list(new FilenameFilter()
            {
                private static final String __OBFID = "CL_00001906";
                public boolean accept(File p_accept_1_, String p_accept_2_)
                {
                    return p_accept_2_.endsWith(".dat");
                }
            });

            if (var2.length > 0)
            {
                field_152732_e.warn("**** DETECTED OLD PLAYER FILES IN THE WORLD SAVE");
                field_152732_e.warn("**** THIS USUALLY HAPPENS WHEN THE AUTOMATIC CONVERSION FAILED IN SOME WAY");
                field_152732_e.warn("** please restart the server and if the problem persists, remove the directory \'{}\'", new Object[] {var1.getPath()});
                return false;
            }
        }

        return true;
    }

    private static File func_152725_d(PropertyManager p_152725_0_)
    {
        String var1 = p_152725_0_.getStringProperty("level-name", "world");
        File var2 = new File(var1);
        return new File(var2, "players");
    }

    private static void func_152727_c(File p_152727_0_)
    {
        File var1 = new File(p_152727_0_.getName() + ".converted");
        p_152727_0_.renameTo(var1);
    }

    private static Date func_152713_b(String p_152713_0_, Date p_152713_1_)
    {
        Date var2;

        try
        {
            var2 = BanEntry.dateFormat.parse(p_152713_0_);
        }
        catch (ParseException var4)
        {
            var2 = p_152713_1_;
        }

        return var2;
    }

    static class ConversionError extends RuntimeException
    {
        private static final String __OBFID = "CL_00001905";

        private ConversionError(String p_i1206_1_, Throwable p_i1206_2_)
        {
            super(p_i1206_1_, p_i1206_2_);
        }

        private ConversionError(String p_i1207_1_)
        {
            super(p_i1207_1_);
        }

        ConversionError(String p_i1208_1_, Object p_i1208_2_)
        {
            this(p_i1208_1_);
        }

        ConversionError(String p_i1209_1_, Throwable p_i1209_2_, Object p_i1209_3_)
        {
            this(p_i1209_1_, p_i1209_2_);
        }
    }
}
