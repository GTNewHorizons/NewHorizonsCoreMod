package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.recipe.RecipeMaps.fluidCannerRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;

public class FluidCannerRecipes implements Runnable {

    @Override
    public void run() {
        // NAK and Helium Cooling Cells
        GTValues.RA.stdBuilder().itemInputs(CustomItemList.TenKCell.get(1L))
                .itemOutputs(ItemList.Reactor_Coolant_NaK_1.get(1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("sodiumpotassium"), 1000)).duration(16 * TICKS)
                .eut(1).addTo(fluidCannerRecipes);

        GTValues.RA.stdBuilder().itemInputs(CustomItemList.ThirtyKCell.get(1L))
                .itemOutputs(ItemList.Reactor_Coolant_NaK_3.get(1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("sodiumpotassium"), 3000))
                .duration(2 * SECONDS + 8 * TICKS).eut(1).addTo(fluidCannerRecipes);

        GTValues.RA.stdBuilder().itemInputs(CustomItemList.SixtyKCell.get(1L))
                .itemOutputs(ItemList.Reactor_Coolant_NaK_6.get(1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("sodiumpotassium"), 6000))
                .duration(4 * SECONDS + 16 * TICKS).eut(1).addTo(fluidCannerRecipes);

        // Space Cooling Cells
        GTValues.RA.stdBuilder().itemInputs(CustomItemList.Empty180SpCell.get(1L))
                .itemOutputs(ItemList.Reactor_Coolant_Sp_1.get(1L)).fluidInputs(Materials.SuperCoolant.getFluid(1000L))
                .duration(16 * TICKS).eut(1).addTo(fluidCannerRecipes);

        GTValues.RA.stdBuilder().itemInputs(CustomItemList.Empty360SpCell.get(1L))
                .itemOutputs(ItemList.Reactor_Coolant_Sp_2.get(1L)).fluidInputs(Materials.SuperCoolant.getFluid(2000L))
                .duration(1 * SECONDS + 12 * TICKS).eut(1).addTo(fluidCannerRecipes);

        GTValues.RA.stdBuilder().itemInputs(CustomItemList.Empty540SpCell.get(1L))
                .itemOutputs(ItemList.Reactor_Coolant_Sp_3.get(1L)).fluidInputs(Materials.SuperCoolant.getFluid(3000L))
                .duration(2 * SECONDS + 8 * TICKS).eut(1).addTo(fluidCannerRecipes);

        GTValues.RA.stdBuilder().itemInputs(CustomItemList.Empty1080SpCell.get(1L))
                .itemOutputs(ItemList.Reactor_Coolant_Sp_6.get(1L)).fluidInputs(Materials.SuperCoolant.getFluid(6000L))
                .duration(4 * SECONDS + 16 * TICKS).eut(1).addTo(fluidCannerRecipes);

        if (GalaxySpace.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(CustomItemList.TenKCell.get(1L))
                    .itemOutputs(ItemList.Reactor_Coolant_He_1.get(1L))
                    .fluidInputs(new FluidStack(FluidRegistry.getFluid("liquid helium"), 1000)).duration(16 * TICKS)
                    .eut(1).addTo(fluidCannerRecipes);

            GTValues.RA.stdBuilder().itemInputs(CustomItemList.ThirtyKCell.get(1L))
                    .itemOutputs(ItemList.Reactor_Coolant_He_3.get(1L))
                    .fluidInputs(new FluidStack(FluidRegistry.getFluid("liquid helium"), 3000))
                    .duration(2 * SECONDS + 8 * TICKS).eut(1).addTo(fluidCannerRecipes);

            GTValues.RA.stdBuilder().itemInputs(CustomItemList.SixtyKCell.get(1L))
                    .itemOutputs(ItemList.Reactor_Coolant_He_6.get(1L))
                    .fluidInputs(new FluidStack(FluidRegistry.getFluid("liquid helium"), 6000))
                    .duration(4 * SECONDS + 16 * TICKS).eut(1).addTo(fluidCannerRecipes);
        }
    }
}
