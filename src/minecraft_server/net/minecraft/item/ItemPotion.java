package net.minecraft.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemPotion extends Item
{
    /**
     * Contains a map from integers to the list of potion effects that potions with that damage value confer (to prevent
     * recalculating it).
     */
    private HashMap effectCache = new HashMap();
    private static final Map field_77835_b = new LinkedHashMap();
    private static final String __OBFID = "CL_00000055";

    public ItemPotion()
    {
        this.setMaxStackSize(1);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(CreativeTabs.tabBrewing);
    }

    /**
     * Returns a list of potion effects for the specified itemstack.
     */
    public List getEffects(ItemStack p_77832_1_)
    {
        if (p_77832_1_.hasTagCompound() && p_77832_1_.getTagCompound().func_150297_b("CustomPotionEffects", 9))
        {
            ArrayList var7 = new ArrayList();
            NBTTagList var3 = p_77832_1_.getTagCompound().getTagList("CustomPotionEffects", 10);

            for (int var4 = 0; var4 < var3.tagCount(); ++var4)
            {
                NBTTagCompound var5 = var3.getCompoundTagAt(var4);
                PotionEffect var6 = PotionEffect.readCustomPotionEffectFromNBT(var5);

                if (var6 != null)
                {
                    var7.add(var6);
                }
            }

            return var7;
        }
        else
        {
            List var2 = (List)this.effectCache.get(Integer.valueOf(p_77832_1_.getItemDamage()));

            if (var2 == null)
            {
                var2 = PotionHelper.getPotionEffects(p_77832_1_.getItemDamage(), false);
                this.effectCache.put(Integer.valueOf(p_77832_1_.getItemDamage()), var2);
            }

            return var2;
        }
    }

    /**
     * Returns a list of effects for the specified potion damage value.
     */
    public List getEffects(int p_77834_1_)
    {
        List var2 = (List)this.effectCache.get(Integer.valueOf(p_77834_1_));

        if (var2 == null)
        {
            var2 = PotionHelper.getPotionEffects(p_77834_1_, false);
            this.effectCache.put(Integer.valueOf(p_77834_1_), var2);
        }

        return var2;
    }

    public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_)
    {
        if (!p_77654_3_.capabilities.isCreativeMode)
        {
            --p_77654_1_.stackSize;
        }

        if (!p_77654_2_.isClient)
        {
            List var4 = this.getEffects(p_77654_1_);

            if (var4 != null)
            {
                Iterator var5 = var4.iterator();

                while (var5.hasNext())
                {
                    PotionEffect var6 = (PotionEffect)var5.next();
                    p_77654_3_.addPotionEffect(new PotionEffect(var6));
                }
            }
        }

        if (!p_77654_3_.capabilities.isCreativeMode)
        {
            if (p_77654_1_.stackSize <= 0)
            {
                return new ItemStack(Items.glass_bottle);
            }

            p_77654_3_.inventory.addItemStackToInventory(new ItemStack(Items.glass_bottle));
        }

        return p_77654_1_;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 32;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.drink;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        if (isSplash(p_77659_1_.getItemDamage()))
        {
            if (!p_77659_3_.capabilities.isCreativeMode)
            {
                --p_77659_1_.stackSize;
            }

            p_77659_2_.playSoundAtEntity(p_77659_3_, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!p_77659_2_.isClient)
            {
                p_77659_2_.spawnEntityInWorld(new EntityPotion(p_77659_2_, p_77659_3_, p_77659_1_));
            }

            return p_77659_1_;
        }
        else
        {
            p_77659_3_.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
            return p_77659_1_;
        }
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        return false;
    }

    /**
     * returns wether or not a potion is a throwable splash potion based on damage value
     */
    public static boolean isSplash(int p_77831_0_)
    {
        return (p_77831_0_ & 16384) != 0;
    }

    public String getItemStackDisplayName(ItemStack p_77653_1_)
    {
        if (p_77653_1_.getItemDamage() == 0)
        {
            return StatCollector.translateToLocal("item.emptyPotion.name").trim();
        }
        else
        {
            String var2 = "";

            if (isSplash(p_77653_1_.getItemDamage()))
            {
                var2 = StatCollector.translateToLocal("potion.prefix.grenade").trim() + " ";
            }

            List var3 = Items.potionitem.getEffects(p_77653_1_);
            String var4;

            if (var3 != null && !var3.isEmpty())
            {
                var4 = ((PotionEffect)var3.get(0)).getEffectName();
                var4 = var4 + ".postfix";
                return var2 + StatCollector.translateToLocal(var4).trim();
            }
            else
            {
                var4 = PotionHelper.func_77905_c(p_77653_1_.getItemDamage());
                return StatCollector.translateToLocal(var4).trim() + " " + super.getItemStackDisplayName(p_77653_1_);
            }
        }
    }
}
