package com.dreammaster.modcustomfuels;

public class CustomFuelsFactory {

    public CustomFuels.FuelItem createCustomFuelItem(String pItemName, int pBurnTime) {
        CustomFuels.FuelItem fi = new CustomFuels.FuelItem();
        fi.mItemName = pItemName;
        fi.mBurnTime = pBurnTime;

        return fi;
    }
}
