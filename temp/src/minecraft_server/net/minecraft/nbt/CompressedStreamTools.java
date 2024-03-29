package net.minecraft.nbt;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTSizeTracker;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagEnd;
import net.minecraft.util.ReportedException;

public class CompressedStreamTools {

   private static final String __OBFID = "CL_00001226";


   public static NBTTagCompound func_74796_a(InputStream p_74796_0_) throws IOException {
      DataInputStream var1 = new DataInputStream(new BufferedInputStream(new GZIPInputStream(p_74796_0_)));

      NBTTagCompound var2;
      try {
         var2 = func_152456_a(var1, NBTSizeTracker.field_152451_a);
      } finally {
         var1.close();
      }

      return var2;
   }

   public static void func_74799_a(NBTTagCompound p_74799_0_, OutputStream p_74799_1_) throws IOException {
      DataOutputStream var2 = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(p_74799_1_)));

      try {
         func_74800_a(p_74799_0_, var2);
      } finally {
         var2.close();
      }

   }

   public static NBTTagCompound func_152457_a(byte[] p_152457_0_, NBTSizeTracker p_152457_1_) throws IOException {
      DataInputStream var2 = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(p_152457_0_))));

      NBTTagCompound var3;
      try {
         var3 = func_152456_a(var2, p_152457_1_);
      } finally {
         var2.close();
      }

      return var3;
   }

   public static byte[] func_74798_a(NBTTagCompound p_74798_0_) throws IOException {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      DataOutputStream var2 = new DataOutputStream(new GZIPOutputStream(var1));

      try {
         func_74800_a(p_74798_0_, var2);
      } finally {
         var2.close();
      }

      return var1.toByteArray();
   }

   public static NBTTagCompound func_74794_a(DataInputStream p_74794_0_) throws IOException {
      return func_152456_a(p_74794_0_, NBTSizeTracker.field_152451_a);
   }

   public static NBTTagCompound func_152456_a(DataInput p_152456_0_, NBTSizeTracker p_152456_1_) throws IOException {
      NBTBase var2 = func_152455_a(p_152456_0_, 0, p_152456_1_);
      if(var2 instanceof NBTTagCompound) {
         return (NBTTagCompound)var2;
      } else {
         throw new IOException("Root tag must be a named compound tag");
      }
   }

   public static void func_74800_a(NBTTagCompound p_74800_0_, DataOutput p_74800_1_) throws IOException {
      func_150663_a(p_74800_0_, p_74800_1_);
   }

   private static void func_150663_a(NBTBase p_150663_0_, DataOutput p_150663_1_) throws IOException {
      p_150663_1_.writeByte(p_150663_0_.func_74732_a());
      if(p_150663_0_.func_74732_a() != 0) {
         p_150663_1_.writeUTF("");
         p_150663_0_.func_74734_a(p_150663_1_);
      }
   }

   private static NBTBase func_152455_a(DataInput p_152455_0_, int p_152455_1_, NBTSizeTracker p_152455_2_) throws IOException {
      byte var3 = p_152455_0_.readByte();
      if(var3 == 0) {
         return new NBTTagEnd();
      } else {
         p_152455_0_.readUTF();
         NBTBase var4 = NBTBase.func_150284_a(var3);

         try {
            var4.func_152446_a(p_152455_0_, p_152455_1_, p_152455_2_);
            return var4;
         } catch (IOException var8) {
            CrashReport var6 = CrashReport.func_85055_a(var8, "Loading NBT data");
            CrashReportCategory var7 = var6.func_85058_a("NBT Tag");
            var7.func_71507_a("Tag name", "[UNNAMED TAG]");
            var7.func_71507_a("Tag type", Byte.valueOf(var3));
            throw new ReportedException(var6);
         }
      }
   }
}
