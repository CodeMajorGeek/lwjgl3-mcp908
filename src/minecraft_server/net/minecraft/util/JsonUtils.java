package net.minecraft.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;

public class JsonUtils
{
    private static final String __OBFID = "CL_00001484";

    /**
     * Does the given JsonObject contain an array field with the given name?
     */
    public static boolean jsonObjectFieldTypeIsArray(JsonObject p_151202_0_, String p_151202_1_)
    {
        return !jsonObjectHasNamedField(p_151202_0_, p_151202_1_) ? false : p_151202_0_.get(p_151202_1_).isJsonArray();
    }

    /**
     * Does the given JsonObject contain a field with the given name?
     */
    public static boolean jsonObjectHasNamedField(JsonObject p_151204_0_, String p_151204_1_)
    {
        return p_151204_0_ == null ? false : p_151204_0_.get(p_151204_1_) != null;
    }

    /**
     * Gets the string value of the given JsonElement.  Expects the second parameter to be the name of the element's
     * field if an error message needs to be thrown.
     */
    public static String getJsonElementStringValue(JsonElement p_151206_0_, String p_151206_1_)
    {
        if (p_151206_0_.isJsonPrimitive())
        {
            return p_151206_0_.getAsString();
        }
        else
        {
            throw new JsonSyntaxException("Expected " + p_151206_1_ + " to be a string, was " + getJsonElementTypeDescription(p_151206_0_));
        }
    }

    /**
     * Gets the string value of the field on the JsonObject with the given name.
     */
    public static String getJsonObjectStringFieldValue(JsonObject p_151200_0_, String p_151200_1_)
    {
        if (p_151200_0_.has(p_151200_1_))
        {
            return getJsonElementStringValue(p_151200_0_.get(p_151200_1_), p_151200_1_);
        }
        else
        {
            throw new JsonSyntaxException("Missing " + p_151200_1_ + ", expected to find a string");
        }
    }

    /**
     * Gets the integer value of the given JsonElement.  Expects the second parameter to be the name of the element's
     * field if an error message needs to be thrown.
     */
    public static int getJsonElementIntegerValue(JsonElement p_151215_0_, String p_151215_1_)
    {
        if (p_151215_0_.isJsonPrimitive() && p_151215_0_.getAsJsonPrimitive().isNumber())
        {
            return p_151215_0_.getAsInt();
        }
        else
        {
            throw new JsonSyntaxException("Expected " + p_151215_1_ + " to be a Int, was " + getJsonElementTypeDescription(p_151215_0_));
        }
    }

    /**
     * Gets the integer value of the field on the JsonObject with the given name.
     */
    public static int getJsonObjectIntegerFieldValue(JsonObject p_151203_0_, String p_151203_1_)
    {
        if (p_151203_0_.has(p_151203_1_))
        {
            return getJsonElementIntegerValue(p_151203_0_.get(p_151203_1_), p_151203_1_);
        }
        else
        {
            throw new JsonSyntaxException("Missing " + p_151203_1_ + ", expected to find a Int");
        }
    }

    /**
     * Gets the given JsonElement as a JsonObject.  Expects the second parameter to be the name of the element's field
     * if an error message needs to be thrown.
     */
    public static JsonObject getElementAsJsonObject(JsonElement p_151210_0_, String p_151210_1_)
    {
        if (p_151210_0_.isJsonObject())
        {
            return p_151210_0_.getAsJsonObject();
        }
        else
        {
            throw new JsonSyntaxException("Expected " + p_151210_1_ + " to be a JsonObject, was " + getJsonElementTypeDescription(p_151210_0_));
        }
    }

    /**
     * Gets the given JsonElement as a JsonArray.  Expects the second parameter to be the name of the element's field if
     * an error message needs to be thrown.
     */
    public static JsonArray getJsonElementAsJsonArray(JsonElement p_151207_0_, String p_151207_1_)
    {
        if (p_151207_0_.isJsonArray())
        {
            return p_151207_0_.getAsJsonArray();
        }
        else
        {
            throw new JsonSyntaxException("Expected " + p_151207_1_ + " to be a JsonArray, was " + getJsonElementTypeDescription(p_151207_0_));
        }
    }

    /**
     * Gets the JsonArray field on the JsonObject with the given name.
     */
    public static JsonArray getJsonObjectJsonArrayField(JsonObject p_151214_0_, String p_151214_1_)
    {
        if (p_151214_0_.has(p_151214_1_))
        {
            return getJsonElementAsJsonArray(p_151214_0_.get(p_151214_1_), p_151214_1_);
        }
        else
        {
            throw new JsonSyntaxException("Missing " + p_151214_1_ + ", expected to find a JsonArray");
        }
    }

    /**
     * Gets a human-readable description of the given JsonElement's type.  For example: "a number (4)"
     */
    public static String getJsonElementTypeDescription(JsonElement p_151222_0_)
    {
        String var1 = org.apache.commons.lang3.StringUtils.abbreviateMiddle(String.valueOf(p_151222_0_), "...", 10);

        if (p_151222_0_ == null)
        {
            return "null (missing)";
        }
        else if (p_151222_0_.isJsonNull())
        {
            return "null (json)";
        }
        else if (p_151222_0_.isJsonArray())
        {
            return "an array (" + var1 + ")";
        }
        else if (p_151222_0_.isJsonObject())
        {
            return "an object (" + var1 + ")";
        }
        else
        {
            if (p_151222_0_.isJsonPrimitive())
            {
                JsonPrimitive var2 = p_151222_0_.getAsJsonPrimitive();

                if (var2.isNumber())
                {
                    return "a number (" + var1 + ")";
                }

                if (var2.isBoolean())
                {
                    return "a boolean (" + var1 + ")";
                }
            }

            return var1;
        }
    }
}
