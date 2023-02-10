package com.dreammaster.modhazardousitems;

import java.util.List;

public interface IDamageEffectContainer {

    List<HazardousItems.ItmPotionEffect> getPotionEffects();

    List<HazardousItems.ItmDamageEffect> getDamageEffects();
}
