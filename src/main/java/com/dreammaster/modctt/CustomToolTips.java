package com.dreammaster.modctt;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.registry.GameRegistry;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CustomToolTips")
public class CustomToolTips {

    @XmlElement(name = "ToolTip")
    protected List<ItemToolTip> mToolTips;

    public List<ItemToolTip> getToolTips() {
        Init();

        return mToolTips;
    }

    public ItemToolTip FindItemToolTip(ItemStack pItem) {
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

            for (ItemToolTip itt : mToolTips) {
                if (itt.mUnlocalizedName.equalsIgnoreCase(tCompareName)) {
                    return itt;
                }
            }

            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private void Init() {
        if (mToolTips == null) {
            mToolTips = new ArrayList<>();
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType
    public static class ItemToolTip {

        @XmlAttribute(name = "ItemName")
        protected String mUnlocalizedName;

        @XmlAttribute(name = "ToolTip")
        protected String mToolTip;

        public String getUnlocalizedName() {
            return mUnlocalizedName;
        }

        public String getToolTip() {
            return mToolTip;
        }
    }
}
