package com.dreammaster.bartworksHandler;

import static bartworks.system.material.WerkstoffLoader.Ruridit;
import static gregtech.api.enums.Mods.GalacticraftMars;
import static gregtech.api.enums.OrePrefixes.bolt;
import static gregtech.api.enums.OrePrefixes.dustTiny;
import static gregtech.api.recipe.RecipeMaps.implosionRecipes;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeConstants.AssemblyLine;
import static gregtech.api.util.GT_RecipeConstants.RESEARCH_ITEM;
import static gregtech.api.util.GT_RecipeConstants.RESEARCH_TIME;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_RecipeConstants;

public class BW_Recipe_Loader implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.HeavyDutyAlloyIngotT4.get(1L))
                .itemOutputs(CustomItemList.HeavyDutyPlateTier4.get(1L), Ruridit.get(dustTiny, 4))
                .metadata(GT_RecipeConstants.ADDITIVE_AMOUNT, 32).duration(1 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(implosionRecipes);

        GT_Values.RA.stdBuilder()
                .metadata(
                        RESEARCH_ITEM,
                        GT_ModHandler.getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1L, 0))
                .metadata(RESEARCH_TIME, 2 * MINUTES + 5 * SECONDS)
                .itemInputs(
                        GT_ModHandler.getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1L, 0),
                        CustomItemList.IceCompressedPlate.get(3L),
                        CustomItemList.IceCompressedPlate.get(3L),
                        Ruridit.get(bolt, 4))
                .fluidInputs(FluidRegistry.getFluidStack("molten.indalloy140", 36))
                .itemOutputs(CustomItemList.HeavyDutyAlloyIngotT4.get(1L)).eut(TierEU.RECIPE_LuV).duration(15 * SECONDS)
                .addTo(AssemblyLine);
    }
}
