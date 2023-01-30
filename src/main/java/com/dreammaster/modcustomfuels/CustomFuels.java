package com.dreammaster.modcustomfuels;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.registry.GameRegistry;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CustomFuels")
public class CustomFuels {

    @XmlElement(name = "FuelItem")
    protected List<FuelItem> mFuelItems;

    public List<FuelItem> getFuelItems() {
        Init();

        return mFuelItems;
    }

    public FuelItem FindFuelValue(ItemStack pItem) {
        try {
            Init();
            if (pItem == null) {
                return null;
            }

            GameRegistry.UniqueIdentifier UID = GameRegistry.findUniqueIdentifierFor(pItem.getItem());
            String tCompareName = UID.toString();
            if (pItem.getItemDamage() > 0) {
                tCompareName = String.format("%s:%d", tCompareName, pItem.getItemDamage());
            }

            for (FuelItem ifi : mFuelItems) {
                if (ifi.mItemName.equalsIgnoreCase(tCompareName)) {
                    return ifi;
                }
            }

            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private void Init() {
        if (mFuelItems == null) {
            mFuelItems = new ArrayList<>();
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType
    public static class FuelItem {

        @XmlAttribute(name = "ItemName")
        protected String mItemName;

        @XmlAttribute(name = "BurnTime")
        protected int mBurnTime;

        public String getName() {
            return mItemName;
        }

        public int getBurnTime() {
            return mBurnTime;
        }
    }
}
