package com.dreammaster.modctt;

public class CustomToolTipsObjectFactory {
    public CustomToolTips.ItemToolTip createCustomItemToolTip(String pUnlocalizedName, String pToolTip) {
        CustomToolTips.ItemToolTip itt = new CustomToolTips.ItemToolTip();
        itt.mToolTip = pToolTip;
        itt.mUnlocalizedName = pUnlocalizedName;

        return itt;
    }
}
