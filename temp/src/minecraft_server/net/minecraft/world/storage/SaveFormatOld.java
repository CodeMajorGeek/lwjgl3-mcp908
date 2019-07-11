package net.minecraft.world.storage;

import java.io.File;
import java.io.FileInputStream;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.SaveHandler;
import net.minecraft.world.storage.WorldInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SaveFormatOld implements ISaveFormat {

   private static final Logger field_151479_b = LogManager.getLogger();
   protected final File field_75808_a;
   private static final String __OBFID = "CL_00000586";


   public SaveFormatOld(File p_i2147_1_) {
      if(!p_i2147_1_.exists()) {
         p_i2147_1_.mkdirs();
      }

      this.field_75808_a = p_i2147_1_;
   }

   public void func_75800_d() {}

   public WorldInfo func_75803_c(String p_75803_1_) {
      File var2 = new File(this.field_75808_a, p_75803_1_);
      if(!var2.exists()) {
         return null;
      } else {
         File var3 = new File(var2, "level.dat");
         NBTTagCompound var4;
         NBTTagCompound var5;
         if(var3.exists()) {
            try {
               var4 = CompressedStreamTools.func_74796_a(new FileInputStream(var3));
               var5 = var4.func_74775_l("Data");
               return new WorldInfo(var5);
            } catch (Exception var7) {
               field_151479_b.error("Exception reading " + var3, var7);
            }
         }

         var3 = new File(var2, "level.dat_old");
         if(var3.exists()) {
            try {
               var4 = CompressedStreamTools.func_74796_a(new FileInputStream(var3));
               var5 = var4.func_74775_l("Data");
               return new WorldInfo(var5);
            } catch (Exception var6) {
               field_151479_b.error("Exception reading " + var3, var6);
            }
         }

         return null;
      }
   }

   public boolean func_75802_e(String p_75802_1_) {
      File var2 = new File(this.field_75808_a, p_75802_1_);
      if(!var2.exists()) {
         return true;
      } else {
         field_151479_b.info("Deleting level " + p_75802_1_);

         for(int var3 = 1; var3 <= 5; ++var3) {
            field_151479_b.info("Attempt " + var3 + "...");
            if(func_75807_a(var2.listFiles())) {
               break;
            }

            field_151479_b.warn("Unsuccessful in deleting contents.");
            if(var3 < 5) {
               try {
                  Thread.sleep(500L);
               } catch (InterruptedException var5) {
                  ;
               }
            }
         }

         return var2.delete();
      }
   }

   protected static boolean func_75807_a(File[] p_75807_0_) {
      for(int var1 = 0; var1 < p_75807_0_.length; ++var1) {
         File var2 = p_75807_0_[var1];
         field_151479_b.debug("Deleting " + var2);
         if(var2.isDirectory() && !func_75807_a(var2.listFiles())) {
            field_151479_b.warn("Couldn\'t delete directory " + var2);
            return false;
         }

         if(!var2.delete()) {
            field_151479_b.warn("Couldn\'t delete file " + var2);
            return false;
         }
      }

      return true;
   }

   public ISaveHandler func_75804_a(String p_75804_1_, boolean p_75804_2_) {
      return new SaveHandler(this.field_75808_a, p_75804_1_, p_75804_2_);
   }

   public boolean func_75801_b(String p_75801_1_) {
      return false;
   }

   public boolean func_75805_a(String p_75805_1_, IProgressUpdate p_75805_2_) {
      return false;
   }

}
