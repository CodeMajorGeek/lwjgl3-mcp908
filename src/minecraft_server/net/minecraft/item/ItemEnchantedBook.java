package net.minecraft.item;

import java.util.Random;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.WeightedRandomChestContent;

public class ItemEnchantedBook extends Item
{
    private static final String __OBFID = "CL_00000025";

    /**
     * Checks isDamagable and if it cannot be stacked
     */
    public boolean isItemTool(ItemStack p_77616_1_)
    {
        return false;
    }

    public EnumRarity func_77613_e(ItemStack p_77613_1_)
    {
        return this.func_92110_g(p_77613_1_).tagCount() > 0 ? EnumRarity.uncommon : super.func_77613_e(p_77613_1_);
    }

    public NBTTagList func_92110_g(ItemStack p_92110_1_)
    {
        return p_92110_1_.stackTagCompound != null && p_92110_1_.stackTagCompound.func_150297_b("StoredEnchantments", 9) ? (NBTTagList)p_92110_1_.stackTagCompound.getTag("StoredEnchantments") : new NBTTagList();
    }

    /**
     * Adds an stored enchantment to an enchanted book ItemStack
     */
    public void addEnchantment(ItemStack p_92115_1_, EnchantmentData p_92115_2_)
    {
        NBTTagList var3 = this.func_92110_g(p_92115_1_);
        boolean var4 = true;

        for (int var5 = 0; var5 < var3.tagCount(); ++var5)
        {
            NBTTagCompound var6 = var3.getCompoundTagAt(var5);

            if (var6.getShort("id") == p_92115_2_.enchantmentobj.effectId)
            {
                if (var6.getShort("lvl") < p_92115_2_.enchantmentLevel)
                {
                    var6.setShort("lvl", (short)p_92115_2_.enchantmentLevel);
                }

                var4 = false;
                break;
            }
        }

        if (var4)
        {
            NBTTagCompound var7 = new NBTTagCompound();
            var7.setShort("id", (short)p_92115_2_.enchantmentobj.effectId);
            var7.setShort("lvl", (short)p_92115_2_.enchantmentLevel);
            var3.appendTag(var7);
        }

        if (!p_92115_1_.hasTagCompound())
        {
            p_92115_1_.setTagCompound(new NBTTagCompound());
        }

        p_92115_1_.getTagCompound().setTag("StoredEnchantments", var3);
    }

    /**
     * Returns the ItemStack of an enchanted version of this item.
     */
    public ItemStack getEnchantedItemStack(EnchantmentData p_92111_1_)
    {
        ItemStack var2 = new ItemStack(this);
        this.addEnchantment(var2, p_92111_1_);
        return var2;
    }

    public WeightedRandomChestContent func_92114_b(Random p_92114_1_)
    {
        return this.func_92112_a(p_92114_1_, 1, 1, 1);
    }

    public WeightedRandomChestContent func_92112_a(Random p_92112_1_, int p_92112_2_, int p_92112_3_, int p_92112_4_)
    {
        ItemStack var5 = new ItemStack(Items.book, 1, 0);
        EnchantmentHelper.addRandomEnchantment(p_92112_1_, var5, 30);
        return new WeightedRandomChestContent(var5, p_92112_2_, p_92112_3_, p_92112_4_);
    }
}
