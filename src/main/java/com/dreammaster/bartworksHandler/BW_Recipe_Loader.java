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
import static gregtech.api.util.GTRecipeConstants.RESEARCH_TIME;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTRecipeConstants;

public class BW_Recipe_Loader implements Runnable {

    @Override
    public void run() {
        GTValues.RA.stdBuilder().itemInputs(CustomItemList.HeavyDutyAlloyIngotT4.get(1L))
                .itemOutputs(CustomItemList.HeavyDutyPlateTier4.get(1L), Ruridit.get(dustTiny, 4))
                .metadata(GTRecipeConstants.ADDITIVE_AMOUNT, 32).duration(1 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(implosionRecipes);

        GTValues.RA.stdBuilder()
                .metadata(RESEARCH_ITEM, GTModHandler.getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1L, 0))
                .metadata(RESEARCH_TIME, 2 * MINUTES + 5 * SECONDS)
                .itemInputs(
                        GTModHandler.getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1L, 0),
                        CustomItemList.IceCompressedPlate.get(3L),
                        CustomItemList.IceCompressedPlate.get(3L),
                        Ruridit.get(bolt, 4))
                .fluidInputs(FluidRegistry.getFluidStack("molten.indalloy140", 36))
                .itemOutputs(CustomItemList.HeavyDutyAlloyIngotT4.get(1L)).eut(TierEU.RECIPE_LuV).duration(15 * SECONDS)
                .addTo(AssemblyLine);
    }
}
