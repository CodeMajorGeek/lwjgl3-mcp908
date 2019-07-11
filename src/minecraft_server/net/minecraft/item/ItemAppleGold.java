package net.minecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemAppleGold extends ItemFood
{
    private static final String __OBFID = "CL_00000037";

    public ItemAppleGold(int p_i45341_1_, float p_i45341_2_, boolean p_i45341_3_)
    {
        super(p_i45341_1_, p_i45341_2_, p_i45341_3_);
        this.setHasSubtypes(true);
    }

    public EnumRarity func_77613_e(ItemStack p_77613_1_)
    {
        return p_77613_1_.getItemDamage() == 0 ? EnumRarity.rare : EnumRarity.epic;
    }

    protected void onFoodEaten(ItemStack p_77849_1_, World p_77849_2_, EntityPlayer p_77849_3_)
    {
        if (!p_77849_2_.isClient)
        {
            p_77849_3_.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 2400, 0));
        }

        if (p_77849_1_.getItemDamage() > 0)
        {
            if (!p_77849_2_.isClient)
            {
                p_77849_3_.addPotionEffect(new PotionEffect(Potion.regeneration.id, 600, 4));
                p_77849_3_.addPotionEffect(new PotionEffect(Potion.resistance.id, 6000, 0));
                p_77849_3_.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 6000, 0));
            }
        }
        else
        {
            super.onFoodEaten(p_77849_1_, p_77849_2_, p_77849_3_);
        }
    }
}
