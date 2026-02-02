package com.dreammaster.bartworksHandler;

import static bartworks.system.material.WerkstoffLoader.Ruridit;
import static gregtech.api.enums.Mods.GalacticraftMars;
import static gregtech.api.enums.OrePrefixes.bolt;
import static gregtech.api.enums.OrePrefixes.dustTiny;
import static gregtech.api.recipe.RecipeMaps.implosionRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeConstants.AssemblyLine;
import static gregtech.api.util.GTRecipeConstants.RESEARCH_ITEM;
import static gregtech.api.util.GTRecipeConstants.SCANNING;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.item.NHItemList;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTRecipeConstants;
import gregtech.api.util.recipe.Scanning;

public class BW_Recipe_Loader implements Runnable {

    @Override
    public void run() {
        GTValues.RA.stdBuilder().itemInputs(NHItemList.HeavyDutyAlloyIngotT4.get())
                .itemOutputs(NHItemList.HeavyDutyPlateTier4.get(), Ruridit.get(dustTiny, 4))
                .metadata(GTRecipeConstants.ADDITIVE_AMOUNT, 32).duration(1 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(implosionRecipes);

        // Heavy Duty Alloy Ingot T4
        GTValues.RA.stdBuilder()
                .metadata(RESEARCH_ITEM, GTModHandler.getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1L, 0))
                .metadata(SCANNING, new Scanning(1 * MINUTES + 30 * SECONDS, TierEU.RECIPE_EV))
                .itemInputs(
                        GTModHandler.getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1L, 0),
                        NHItemList.IceCompressedPlate.get(3),
                        NHItemList.IceCompressedPlate.get(3),
                        Ruridit.get(bolt, 4))
                .fluidInputs(FluidRegistry.getFluidStack("molten.indalloy140", 36))
                .itemOutputs(NHItemList.HeavyDutyAlloyIngotT4.get()).eut(TierEU.RECIPE_LuV).duration(15 * SECONDS)
                .addTo(AssemblyLine);
    }
}
