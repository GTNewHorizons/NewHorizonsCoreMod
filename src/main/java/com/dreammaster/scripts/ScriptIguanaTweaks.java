package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.IguanaTweaksTinkerConstruct;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import com.dreammaster.item.ItemList;
import gregtech.api.util.GT_OreDictUnificator;

public class ScriptIguanaTweaks implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Iguana Tweaks Tinker Construct";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(IguanaTweaksTinkerConstruct.ID, Natura.ID);
    }

    @Override
    public void loadRecipes() {
        // --- Unfired Clay Bucket
        // If you change this recipe, be sure to update gregtech.api.enums.OrePrefixes!
        // bucketClay.mSecondaryMaterial controls what the clay bucket pulverizes into.
        addShapedRecipe(
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketUnfired", 1),
                new Object[] { null, null, null, "dustClay", null, "dustClay", "dustClay", "dustClay", "dustClay" });

        addShapedRecipe(
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1),
                new Object[] { getModItem(Natura.ID, "waterdrop", 1), getModItem(Natura.ID, "waterdrop", 1),
                        getModItem(Natura.ID, "waterdrop", 1), getModItem(Natura.ID, "waterdrop", 1),
                        getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketFired", 1),
                        getModItem(Natura.ID, "waterdrop", 1), getModItem(Natura.ID, "waterdrop", 1),
                        getModItem(Natura.ID, "waterdrop", 1), getModItem(Natura.ID, "waterdrop", 1) });

        /*
         * oredict so the recipes modified in iguanatweaks will work those are exceptionnally in iguanatweaks because
         * the items in the recipes are registered at PostInit=
         */ GT_OreDictUnificator.registerOre("toolHeadSawArdite", ItemList.SawBladeArdite.getIS());
        GT_OreDictUnificator.registerOre("toolHeadSawManyullyn", ItemList.SawBladeManyullyn.getIS());
    }
}
