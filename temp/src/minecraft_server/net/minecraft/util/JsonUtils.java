package net.minecraft.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;

public class JsonUtils {

   private static final String __OBFID = "CL_00001484";


   public static boolean func_151202_d(JsonObject p_151202_0_, String p_151202_1_) {
      return !func_151204_g(p_151202_0_, p_151202_1_)?false:p_151202_0_.get(p_151202_1_).isJsonArray();
   }

   public static boolean func_151204_g(JsonObject p_151204_0_, String p_151204_1_) {
      return p_151204_0_ == null?false:p_151204_0_.get(p_151204_1_) != null;
   }

   public static String func_151206_a(JsonElement p_151206_0_, String p_151206_1_) {
      if(p_151206_0_.isJsonPrimitive()) {
         return p_151206_0_.getAsString();
      } else {
         throw new JsonSyntaxException("Expected " + p_151206_1_ + " to be a string, was " + func_151222_d(p_151206_0_));
      }
   }

   public static String func_151200_h(JsonObject p_151200_0_, String p_151200_1_) {
      if(p_151200_0_.has(p_151200_1_)) {
         return func_151206_a(p_151200_0_.get(p_151200_1_), p_151200_1_);
      } else {
         throw new JsonSyntaxException("Missing " + p_151200_1_ + ", expected to find a string");
      }
   }

   public static int func_151215_f(JsonElement p_151215_0_, String p_151215_1_) {
      if(p_151215_0_.isJsonPrimitive() && p_151215_0_.getAsJsonPrimitive().isNumber()) {
         return p_151215_0_.getAsInt();
      } else {
         throw new JsonSyntaxException("Expected " + p_151215_1_ + " to be a Int, was " + func_151222_d(p_151215_0_));
      }
   }

   public static int func_151203_m(JsonObject p_151203_0_, String p_151203_1_) {
      if(p_151203_0_.has(p_151203_1_)) {
         return func_151215_f(p_151203_0_.get(p_151203_1_), p_151203_1_);
      } else {
         throw new JsonSyntaxException("Missing " + p_151203_1_ + ", expected to find a Int");
      }
   }

   public static JsonObject func_151210_l(JsonElement p_151210_0_, String p_151210_1_) {
      if(p_151210_0_.isJsonObject()) {
         return p_151210_0_.getAsJsonObject();
      } else {
         throw new JsonSyntaxException("Expected " + p_151210_1_ + " to be a JsonObject, was " + func_151222_d(p_151210_0_));
      }
   }

   public static JsonArray func_151207_m(JsonElement p_151207_0_, String p_151207_1_) {
      if(p_151207_0_.isJsonArray()) {
         return p_151207_0_.getAsJsonArray();
      } else {
         throw new JsonSyntaxException("Expected " + p_151207_1_ + " to be a JsonArray, was " + func_151222_d(p_151207_0_));
      }
   }

   public static JsonArray func_151214_t(JsonObject p_151214_0_, String p_151214_1_) {
      if(p_151214_0_.has(p_151214_1_)) {
         return func_151207_m(p_151214_0_.get(p_151214_1_), p_151214_1_);
      } else {
         throw new JsonSyntaxException("Missing " + p_151214_1_ + ", expected to find a JsonArray");
      }
   }

   public static String func_151222_d(JsonElement p_151222_0_) {
      String var1 = org.apache.commons.lang3.StringUtils.abbreviateMiddle(String.valueOf(p_151222_0_), "...", 10);
      if(p_151222_0_ == null) {
         return "null (missing)";
      } else if(p_151222_0_.isJsonNull()) {
         return "null (json)";
      } else if(p_151222_0_.isJsonArray()) {
         return "an array (" + var1 + ")";
      } else if(p_151222_0_.isJsonObject()) {
         return "an object (" + var1 + ")";
      } else {
         if(p_151222_0_.isJsonPrimitive()) {
            JsonPrimitive var2 = p_151222_0_.getAsJsonPrimitive();
            if(var2.isNumber()) {
               return "a number (" + var1 + ")";
            }

            if(var2.isBoolean()) {
               return "a boolean (" + var1 + ")";
            }
         }

         return var1;
      }
   }
}
