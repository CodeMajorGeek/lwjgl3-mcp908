package net.minecraft.server.dedicated;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertyManager
{
    private static final Logger field_164440_a = LogManager.getLogger();

    /** The server properties object. */
    private final Properties serverProperties = new Properties();

    /** The server properties file. */
    private final File serverPropertiesFile;
    private static final String __OBFID = "CL_00001782";

    public PropertyManager(File p_i45278_1_)
    {
        this.serverPropertiesFile = p_i45278_1_;

        if (p_i45278_1_.exists())
        {
            FileInputStream var2 = null;

            try
            {
                var2 = new FileInputStream(p_i45278_1_);
                this.serverProperties.load(var2);
            }
            catch (Exception var12)
            {
                field_164440_a.warn("Failed to load " + p_i45278_1_, var12);
                this.generateNewProperties();
            }
            finally
            {
                if (var2 != null)
                {
                    try
                    {
                        var2.close();
                    }
                    catch (IOException var11)
                    {
                        ;
                    }
                }
            }
        }
        else
        {
            field_164440_a.warn(p_i45278_1_ + " does not exist");
            this.generateNewProperties();
        }
    }

    /**
     * Generates a new properties file.
     */
    public void generateNewProperties()
    {
        field_164440_a.info("Generating new properties file");
        this.saveProperties();
    }

    /**
     * Writes the properties to the properties file.
     */
    public void saveProperties()
    {
        FileOutputStream var1 = null;

        try
        {
            var1 = new FileOutputStream(this.serverPropertiesFile);
            this.serverProperties.store(var1, "Minecraft server properties");
        }
        catch (Exception var11)
        {
            field_164440_a.warn("Failed to save " + this.serverPropertiesFile, var11);
            this.generateNewProperties();
        }
        finally
        {
            if (var1 != null)
            {
                try
                {
                    var1.close();
                }
                catch (IOException var10)
                {
                    ;
                }
            }
        }
    }

    /**
     * Returns this PropertyManager's file object used for property saving.
     */
    public File getPropertiesFile()
    {
        return this.serverPropertiesFile;
    }

    /**
     * Returns a string property. If the property doesn't exist the default is returned.
     */
    public String getStringProperty(String p_73671_1_, String p_73671_2_)
    {
        if (!this.serverProperties.containsKey(p_73671_1_))
        {
            this.serverProperties.setProperty(p_73671_1_, p_73671_2_);
            this.saveProperties();
            this.saveProperties();
        }

        return this.serverProperties.getProperty(p_73671_1_, p_73671_2_);
    }

    /**
     * Gets an integer property. If it does not exist, set it to the specified value.
     */
    public int getIntProperty(String p_73669_1_, int p_73669_2_)
    {
        try
        {
            return Integer.parseInt(this.getStringProperty(p_73669_1_, "" + p_73669_2_));
        }
        catch (Exception var4)
        {
            this.serverProperties.setProperty(p_73669_1_, "" + p_73669_2_);
            this.saveProperties();
            return p_73669_2_;
        }
    }

    /**
     * Gets a boolean property. If it does not exist, set it to the specified value.
     */
    public boolean getBooleanProperty(String p_73670_1_, boolean p_73670_2_)
    {
        try
        {
            return Boolean.parseBoolean(this.getStringProperty(p_73670_1_, "" + p_73670_2_));
        }
        catch (Exception var4)
        {
            this.serverProperties.setProperty(p_73670_1_, "" + p_73670_2_);
            this.saveProperties();
            return p_73670_2_;
        }
    }

    /**
     * Saves an Object with the given property name.
     */
    public void setProperty(String p_73667_1_, Object p_73667_2_)
    {
        this.serverProperties.setProperty(p_73667_1_, "" + p_73667_2_);
    }
}
