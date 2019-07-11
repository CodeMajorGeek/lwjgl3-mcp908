package net.minecraft.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HttpUtil
{
    /** The number of download threads that we have started so far. */
    private static final AtomicInteger downloadThreadsStarted = new AtomicInteger(0);
    private static final Logger logger = LogManager.getLogger();
    private static final String __OBFID = "CL_00001485";

    /**
     * Builds an encoded HTTP POST content string from a string map
     */
    public static String buildPostString(Map p_76179_0_)
    {
        StringBuilder var1 = new StringBuilder();
        Iterator var2 = p_76179_0_.entrySet().iterator();

        while (var2.hasNext())
        {
            Entry var3 = (Entry)var2.next();

            if (var1.length() > 0)
            {
                var1.append('&');
            }

            try
            {
                var1.append(URLEncoder.encode((String)var3.getKey(), "UTF-8"));
            }
            catch (UnsupportedEncodingException var6)
            {
                var6.printStackTrace();
            }

            if (var3.getValue() != null)
            {
                var1.append('=');

                try
                {
                    var1.append(URLEncoder.encode(var3.getValue().toString(), "UTF-8"));
                }
                catch (UnsupportedEncodingException var5)
                {
                    var5.printStackTrace();
                }
            }
        }

        return var1.toString();
    }

    public static String func_151226_a(URL p_151226_0_, Map p_151226_1_, boolean p_151226_2_)
    {
        return func_151225_a(p_151226_0_, buildPostString(p_151226_1_), p_151226_2_);
    }

    private static String func_151225_a(URL p_151225_0_, String p_151225_1_, boolean p_151225_2_)
    {
        try
        {
            Proxy var3 = MinecraftServer.getServer() == null ? null : MinecraftServer.getServer().getServerProxy();

            if (var3 == null)
            {
                var3 = Proxy.NO_PROXY;
            }

            HttpURLConnection var4 = (HttpURLConnection)p_151225_0_.openConnection(var3);
            var4.setRequestMethod("POST");
            var4.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            var4.setRequestProperty("Content-Length", "" + p_151225_1_.getBytes().length);
            var4.setRequestProperty("Content-Language", "en-US");
            var4.setUseCaches(false);
            var4.setDoInput(true);
            var4.setDoOutput(true);
            DataOutputStream var5 = new DataOutputStream(var4.getOutputStream());
            var5.writeBytes(p_151225_1_);
            var5.flush();
            var5.close();
            BufferedReader var6 = new BufferedReader(new InputStreamReader(var4.getInputStream()));
            StringBuffer var8 = new StringBuffer();
            String var7;

            while ((var7 = var6.readLine()) != null)
            {
                var8.append(var7);
                var8.append('\r');
            }

            var6.close();
            return var8.toString();
        }
        catch (Exception var9)
        {
            if (!p_151225_2_)
            {
                logger.error("Could not post to " + p_151225_0_, var9);
            }

            return "";
        }
    }
}
