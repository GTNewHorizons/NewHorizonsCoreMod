package com.dreammaster.modhazardousitems;

public class HazardousObjectFactory {
    public HazardousItems.HazardousFluid createHazardousFluid(
            String pFluidName, boolean pExactMatch, boolean pOnContact, boolean pOnInventory) {
        HazardousItems.HazardousFluid hi = new HazardousItems.HazardousFluid();
        hi.setFluidName(pFluidName);
        hi.setExactMatch(pExactMatch);
        hi.setCheckInventory(pOnInventory);
        hi.setCheckContact(pOnContact);
        return hi;
    }

    public HazardousItems.HazardousItem createHazardousItemsHazardousItem(
            String pItemName, boolean pExactMatch, boolean pOnContact, boolean pOnInventory) {
        HazardousItems.HazardousItem hi = new HazardousItems.HazardousItem();
        hi.setItemName(pItemName);
        hi.setExactMatch(pExactMatch);
        hi.setCheckInventory(pOnInventory);
        hi.setCheckContact(pOnContact);
        return hi;
    }

    public HazardousItems.ItmDamageEffect createDamageEffect(Float pAmount, String pSource) {
        HazardousItems.ItmDamageEffect dEf = new HazardousItems.ItmDamageEffect();

        dEf.setAmount(pAmount);
        dEf.setDamageSource(pSource);

        return dEf;
    }

    public HazardousItems.ItmPotionEffect createPotionEffect(int pDuration, int pPotionID, int pLevel) {
        HazardousItems.ItmPotionEffect pEf = new HazardousItems.ItmPotionEffect();

        pEf.setDuration(pDuration);
        pEf.setId(pPotionID);
        pEf.setLevel(pLevel);

        return pEf;
    }
}
