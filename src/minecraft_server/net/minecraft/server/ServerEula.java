package net.minecraft.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServerEula
{
    private static final Logger field_154349_a = LogManager.getLogger();
    private final File field_154350_b;
    private final boolean field_154351_c;
    private static final String __OBFID = "CL_00001911";

    public ServerEula(File p_i1227_1_)
    {
        this.field_154350_b = p_i1227_1_;
        this.field_154351_c = this.func_154347_a(p_i1227_1_);
    }

    private boolean func_154347_a(File p_154347_1_)
    {
        FileInputStream var2 = null;
        boolean var3 = false;

        try
        {
            Properties var4 = new Properties();
            var2 = new FileInputStream(p_154347_1_);
            var4.load(var2);
            var3 = Boolean.parseBoolean(var4.getProperty("eula", "false"));
        }
        catch (Exception var8)
        {
            field_154349_a.warn("Failed to load " + p_154347_1_);
            this.func_154348_b();
        }
        finally
        {
            IOUtils.closeQuietly(var2);
        }

        return var3;
    }

    public boolean func_154346_a()
    {
        return this.field_154351_c;
    }

    public void func_154348_b()
    {
        FileOutputStream var1 = null;

        try
        {
            Properties var2 = new Properties();
            var1 = new FileOutputStream(this.field_154350_b);
            var2.setProperty("eula", "false");
            var2.store(var1, "By changing the setting below to TRUE you are indicating your agreement to our EULA (https://account.mojang.com/documents/minecraft_eula).");
        }
        catch (Exception var6)
        {
            field_154349_a.warn("Failed to save " + this.field_154350_b, var6);
        }
        finally
        {
            IOUtils.closeQuietly(var1);
        }
    }
}
