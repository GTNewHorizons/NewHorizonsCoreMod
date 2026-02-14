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
import gregtech.api.util.GTModHandler;

public class FluidHeaterRecipes implements Runnable {

    @Override
    public void run() {

        GTValues.RA.stdBuilder().fluidInputs(Materials.Steam.getGas(3840))
                .fluidOutputs(GTModHandler.getSuperHeatedSteam(3840)).duration(5 * SECONDS).eut(TierEU.RECIPE_LuV)
                .addTo(fluidHeaterRecipes);
        if (PamsHarvestCraft.isModLoaded()) {
            GTValues.RA.stdBuilder().circuit(24).fluidInputs(getFluidStack("milk", 250))
                    .itemOutputs(getModItem(PamsHarvestCraft.ID, "freshmilkItem", 1, 0, missing)).duration(2 * SECONDS)
                    .eut(TierEU.RECIPE_ULV).addTo(fluidHeaterRecipes);
            if (Automagy.isModLoaded()) {
                GTValues.RA.stdBuilder().circuit(24).fluidInputs(getFluidStack("fluidmilk", 250))
                        .itemOutputs(getModItem(PamsHarvestCraft.ID, "freshmilkItem", 1, 0, missing))
                        .duration(2 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(fluidHeaterRecipes);
            }
        }
    }
}
