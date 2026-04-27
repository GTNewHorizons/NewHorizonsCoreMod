package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.GalacticraftAmunRa;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.recipe.RecipeMaps.arcFurnaceRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gregtech.api.util.GTRecipeConstants.UniversalArcFurnace;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import com.dreammaster.item.NHItemList;

import goodgenerator.util.ItemRefer;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;
import gtPlusPlus.core.material.MaterialsElements;

public class ArcFurnaceRecipes implements Runnable {

    @Override
    public void run() {
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.nugget, Materials.Steel, 2L))
                .duration(2 * SECONDS + 10 * TICKS).eut(90).addTo(UniversalArcFurnace);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.sand, 1, 0))
                .itemOutputs(new ItemStack(Blocks.glass, 2)).duration(1 * SECONDS).eut(TierEU.RECIPE_HV / 2)
                .addTo(UniversalArcFurnace);

        // red sand
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.sand, 1, 1))
                .itemOutputs(
                        new ItemStack(Blocks.glass, 2),
                        GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1))
                .duration(1 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(UniversalArcFurnace);

        // Awful dimensionally transcendent residue recipe for mk5 fusion pre-dtpf (mostly a meme)
        GTValues.RA.stdBuilder().itemInputs(ItemRefer.Radioactive_Waste.get(64))
                .fluidInputs(Materials.ExcitedDTEC.getFluid(1000L)).fluidOutputs(Materials.DTR.getFluid(50L))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_UEV / 2).addTo(arcFurnaceRecipes);

        if (GalacticraftAmunRa.isModLoaded()) {
            // Zero Point Module recycling

            GTValues.RA.stdBuilder().itemInputs(ItemList.ZPM.get(1))
                    .itemOutputs(
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahAlloy, 8L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.DraconiumAwakened, 32L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Firestone, 32L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Dilithium, 32L),
                            GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.Ichorium, 16L),
                            GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Ardite, 64L),
                            getModItem(GalacticraftAmunRa.ID, "item.baseItem", 4, 3),
                            NHItemList.ChaoticDust.get(2),
                            getModItem(GalacticraftAmunRa.ID, "item.baseItem", 1, 26))
                    .outputChances(5000, 5000, 5000, 5000, 5000, 3000, 2000, 500, 250)
                    .fluidInputs(MaterialsElements.STANDALONE.CELESTIAL_TUNGSTEN.getFluidStack(144))
                    .fluidOutputs(Materials.Tungsten.getMolten(144)).duration(50 * SECONDS).eut(TierEU.RECIPE_ZPM)
                    .addTo(arcFurnaceRecipes);
        }
    }
}
