package com.dreammaster.item;

import eu.usrv.yamcore.iface.IExtendedItemProperties;

import net.minecraft.item.Item;

public class WoodenBrickFormProperties implements IExtendedItemProperties
{

    @Override
    public String getItemName() { return "WoodenBrickForm";
        }

    @Override
    public String getCustomTextureName() { return "";
    }

    @Override
    public String getUnlocalizedName() { return "WoodenBrickForm";
    }

    @Override
    public boolean getDontConsumeInRecipes() { return true; }
    
    @Override
    public Item getCustomItem() { return new CraftingItem(); }
}