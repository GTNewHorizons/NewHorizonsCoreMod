package com.dreammaster.modcustomdrops;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;
import net.minecraft.entity.EntityLivingBase;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CustomDrops")
public class CustomDrops {
    @XmlElement(name = "CustomDrop")
    protected List<CustomDrop> mCustomDrops;

    public List<CustomDrop> getCustomDrops() {
        Init();
        return mCustomDrops;
    }

    public CustomDrop FindDropEntry(EntityLivingBase pEntity) {
        try {
            Init();
            if (pEntity == null) {
                return null;
            }

            String tEntityClassName = pEntity.getClass().getName();
            for (CustomDrop drop : mCustomDrops) {
                if (drop.mEntityClassName.equalsIgnoreCase(tEntityClassName)) {
                    return drop;
                }
            }

            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private void Init() {
        if (mCustomDrops == null) {
            mCustomDrops = new ArrayList<>();
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType
    public static class CustomDrop {
        @XmlAttribute(name = "EntityClassName")
        protected String mEntityClassName;

        @XmlElement(name = "Drop")
        protected List<Drop> mDrops;

        public List<Drop> getDrops() {
            Init();
            return mDrops;
        }

        private void Init() {
            if (mDrops == null) {
                mDrops = new ArrayList<>();
            }
        }

        public String getEntityName() {
            return mEntityClassName;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType
        public static class Drop {
            @XmlAttribute(name = "Identifier")
            protected String mDropID;

            @XmlAttribute(name = "ItemName")
            protected String mItemName;

            @XmlAttribute(name = "Amount")
            protected int mAmount;

            @XmlAttribute(name = "NBTTag")
            protected String mTag;

            @XmlAttribute(name = "Chance")
            protected int mChance;

            @XmlAttribute(name = "LimitedDropCount")
            protected int mLimitedDropCount;

            @XmlAttribute(name = "RandomAmount")
            protected boolean mIsRandomAmount;

            public String getIdentifier() {
                return mDropID;
            }

            public String getItemName() {
                return mItemName;
            }

            public int getAmount() {
                return mAmount;
            }

            public int getChance() {
                return mChance;
            }

            public int getLimitedDropCount() {
                return mLimitedDropCount;
            }

            public boolean getIsRandomAmount() {
                return mIsRandomAmount;
            }
        }
    }
}
