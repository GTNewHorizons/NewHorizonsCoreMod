package com.dreammaster.modcustomdrops;

public class CustomDropsFactory {
    public CustomDrops.CustomDrop createCustomDropEntry(String pMobClassName) {
        CustomDrops.CustomDrop cdr = new CustomDrops.CustomDrop();
        cdr.mEntityClassName = pMobClassName;
        return cdr;
    }

    public CustomDrops.CustomDrop.Drop createDrop(
            String pItemName, String pIdentifier, int pAmount, boolean pDropRnd, int pChance, int pLimitedDropCount) {
        return createDrop(pItemName, pIdentifier, "", pAmount, pDropRnd, pChance, pLimitedDropCount);
    }

    public CustomDrops.CustomDrop.Drop createDrop(
            String pItemName,
            String pIdentifier,
            String pNBTTag,
            int pAmount,
            boolean pDropRnd,
            int pChance,
            int pLimitedDropCount) {
        CustomDrops.CustomDrop.Drop drop = new CustomDrops.CustomDrop.Drop();
        drop.mAmount = pAmount;
        drop.mChance = pChance;
        drop.mDropID = pIdentifier;
        drop.mIsRandomAmount = pDropRnd;
        drop.mItemName = pItemName;
        drop.mLimitedDropCount = pLimitedDropCount;
        drop.mTag = pNBTTag;

        return drop;
    }
}
