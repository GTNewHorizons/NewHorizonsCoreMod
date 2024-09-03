package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.recipe.RecipeMaps.wiremillRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTRecipeRegistrator;
import gregtech.api.util.GTUtility;

public class WiremillRecipes implements Runnable {

    @Override
    public void run() {
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.MeteoricIron, 1L))
                .itemOutputs(CustomItemList.MeteoricIronString.get(4L)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(wiremillRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Tungsten, 1L))
                .itemOutputs(CustomItemList.TungstenString.get(4L)).duration(60 * SECONDS).eut(1024)
                .addTo(wiremillRecipes);

        GTValues.RA.stdBuilder().itemInputs(Materials.BorosilicateGlass.getIngots(1), GTUtility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Circuit_Parts_GlassFiber.get(8L)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(wiremillRecipes);

        GTRecipeRegistrator.registerWiremillRecipes(Materials.NetherStar, 200, 4);

        if (Natura.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(Natura.ID, "barleyFood", 2L, 3))
                    .itemOutputs(new ItemStack(Items.string, 1, 0)).duration(10 * SECONDS).eut(8)
                    .addTo(wiremillRecipes);
        }
    }
}
