package com.dreammaster.modctt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;

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
                if (itt.mMetaStart == null || itt.mMetaEnd == null) {
                    if (itt.mUnlocalizedName.equalsIgnoreCase(tCompareName) && (itt.mNBT == null || itt.mNBT.isEmpty()
                            || JsonToNBT.func_150315_a(itt.mNBT).equals(pItem.stackTagCompound))) {
                        return itt;
                    }
                } else {
                    if (tCompareName.startsWith(itt.mUnlocalizedName)
                            && (pItem.getItemDamage() >= Integer.parseInt(itt.mMetaStart)
                                    && pItem.getItemDamage() <= Integer.parseInt(itt.mMetaEnd))
                            && (itt.mNBT == null || itt.mNBT.isEmpty()
                                    || JsonToNBT.func_150315_a(itt.mNBT).equals(pItem.stackTagCompound))) {
                        return itt;
                    }
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

        @XmlAttribute(name = "NBT")
        protected String mNBT;

        @XmlAttribute(name = "MetaStart")
        protected String mMetaStart;

        @XmlAttribute(name = "MetaEnd")
        protected String mMetaEnd;

        @XmlAttribute(name = "FormatArgs")
        protected String formatArgs;

        public String getUnlocalizedName() {
            return mUnlocalizedName;
        }

        public String getToolTip() {
            return mToolTip;
        }

        public String getNBT() {
            return mNBT;
        }

        public String getMetaStart() {
            return mMetaStart;
        }

        public String getMetaEnd() {
            return mMetaEnd;
        }

        public String[] getFormatArgs() {
            if (formatArgs == null) {
                return null;
            }
            return Arrays.stream(formatArgs.replace("\\,", "\u0000").replace("\\\\", "\u0001").split(","))
                    .map(s -> s.replace('\u0000', ',').replace('\u0001', '\\')).toArray(String[]::new);
        }
    }
}
