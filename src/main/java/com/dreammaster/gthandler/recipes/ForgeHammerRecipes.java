package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.ZTones;
import static gregtech.api.recipe.RecipeMaps.hammerRecipes;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_ModHandler;

public class ForgeHammerRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Parts_RawCrystalChip.get(1L))
                .itemOutputs(ItemList.Circuit_Parts_RawCrystalParts.get(9)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(hammerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(ItemList.GalliumArsenideCrystal.get(1L))
                .itemOutputs(ItemList.GalliumArsenideCrystalSmallPart.get(4L)).duration(2 * SECONDS + 10 * TICKS).eut(4)
                .addTo(hammerRecipes);

        if (TinkerConstruct.isModLoaded()) {
            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "Smeltery", 1L, 2))
                    .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "materials", 3L, 2)).duration(1 * SECONDS)
                    .eut(16).addTo(hammerRecipes);
        }

        if (ZTones.isModLoaded()) {
            GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Items.coal, 1, 0))
                    .itemOutputs(GT_ModHandler.getModItem(ZTones.ID, "minicoal", 9L, 0))
                    .duration(2 * SECONDS + 10 * TICKS).eut(8).addTo(hammerRecipes);

            GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Items.coal, 1, 1))
                    .itemOutputs(GT_ModHandler.getModItem(ZTones.ID, "minicharcoal", 9L, 0))
                    .duration(2 * SECONDS + 10 * TICKS).eut(8).addTo(hammerRecipes);
        }
        // Raw optical chip
        int chip_duration_ticks = 10 * SECONDS;
        long chip_eu_per_tick = TierEU.RECIPE_UEV;
        FluidStack[] purified_water = { Materials.Grade7PurifiedWater.getFluid(100L), Materials.Grade8PurifiedWater.getFluid(100L) };

        GT_Values.RA.stdBuilder()
                .itemInputs(ItemList.Circuit_Silicon_Wafer7.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_Optical.get(8))
                .fluidInputs(Materials.Grade7PurifiedWater.getFluid(100L))
                .duration(chip_duration_ticks)
                .eut(chip_eu_per_tick)
                .addTo(hammerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(ItemList.Circuit_Silicon_Wafer7.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_Optical.get(12))
                .fluidInputs(Materials.Grade8PurifiedWater.getFluid(100L))
                .duration(chip_duration_ticks / 2)
                .eut(chip_eu_per_tick)
                .addTo(hammerRecipes);
    }
}
