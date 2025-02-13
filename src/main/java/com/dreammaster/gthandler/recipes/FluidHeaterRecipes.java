package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IScriptLoader.missing;
import static gregtech.api.enums.Mods.Automagy;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.recipe.RecipeMaps.fluidHeaterRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static net.minecraftforge.fluids.FluidRegistry.getFluidStack;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTUtility;
import gtPlusPlus.core.util.minecraft.FluidUtils;

public class FluidHeaterRecipes implements Runnable {

    @Override
    public void run() {

        GTValues.RA.stdBuilder().fluidInputs(FluidUtils.getSteam(3840))
                .fluidOutputs(FluidUtils.getSuperHeatedSteam(3840)).duration(5 * SECONDS).eut(TierEU.RECIPE_LuV)
                .noOptimize().addTo(fluidHeaterRecipes);
        if (PamsHarvestCraft.isModLoaded()) {
            GTValues.RA.stdBuilder().fluidInputs(getFluidStack("milk", 250))
                    .itemInputs(GTUtility.getIntegratedCircuit(24))
                    .itemOutputs(getModItem(PamsHarvestCraft.ID, "freshmilkItem", 1, 0, missing)).duration(2 * SECONDS)
                    .eut(TierEU.RECIPE_ULV).noOptimize().addTo(fluidHeaterRecipes);
            if (Automagy.isModLoaded()) {
                GTValues.RA.stdBuilder().fluidInputs(getFluidStack("fluidmilk", 250))
                        .itemInputs(GTUtility.getIntegratedCircuit(24))
                        .itemOutputs(getModItem(PamsHarvestCraft.ID, "freshmilkItem", 1, 0, missing))
                        .duration(2 * SECONDS).eut(TierEU.RECIPE_ULV).noOptimize().addTo(fluidHeaterRecipes);
            }
        }

    }
}
