package com.dreammaster.bartworksHandler;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.GalacticraftMars;
import static gregtech.api.recipe.RecipeMaps.implosionRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeConstants.AssemblyLine;
import static gregtech.api.util.GTRecipeConstants.RESEARCH_ITEM;
import static gregtech.api.util.GTRecipeConstants.SCANNING;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.item.NHItemList;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;
import gregtech.api.util.GTRecipeConstants;
import gregtech.api.util.recipe.Scanning;

public class BW_Recipe_Loader implements Runnable {

    @Override
    public void run() {
        GTValues.RA.stdBuilder().itemInputs(NHItemList.HeavyDutyAlloyIngotT4.get())
                .itemOutputs(
                        NHItemList.HeavyDutyPlateTier4.get(),
                        MaterialLibAPI.getStack(Materials2Materials.Ruridit, Materials2Shapes.dustTiny, (int) (4)))
                .metadata(GTRecipeConstants.ADDITIVE_AMOUNT, 32).duration(1 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(implosionRecipes);

        // Heavy Duty Alloy Ingot T4
        GTValues.RA.stdBuilder()
                .metadata(RESEARCH_ITEM, getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 0))
                .metadata(SCANNING, new Scanning(1 * MINUTES + 30 * SECONDS, TierEU.RECIPE_EV))
                .itemInputs(
                        getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 0),
                        NHItemList.IceCompressedPlate.get(3),
                        NHItemList.IceCompressedPlate.get(3),
                        MaterialLibAPI.getStack(Materials2Materials.Ruridit, Materials2Shapes.bolt, (int) (4)))
                .fluidInputs(FluidRegistry.getFluidStack("molten.indalloy140", 36))
                .itemOutputs(NHItemList.HeavyDutyAlloyIngotT4.get()).eut(TierEU.RECIPE_LuV).duration(15 * SECONDS)
                .addTo(AssemblyLine);
    }
}
