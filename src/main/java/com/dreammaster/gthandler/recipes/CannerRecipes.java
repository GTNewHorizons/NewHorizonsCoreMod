package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.recipe.RecipeMaps.cannerRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.item.NHItemList;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2FluidShapes;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;

public class CannerRecipes implements Runnable {

    @Override
    public void run() {
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.AdsorptionFilterCasing.get(),
                        MaterialLibAPI.getStack(Materials2Materials.Carbon, Materials2Shapes.shapeDust, (int) (32)))
                .itemOutputs(NHItemList.AdsorptionFilter.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(cannerRecipes);

        // NAK and Helium Cooling Cells
        GTValues.RA.stdBuilder().itemInputs(NHItemList.TenKCell.get())
                .itemOutputs(ItemList.Reactor_Coolant_NaK_1.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SodiumPotassium,
                                Materials2FluidShapes.shapeFluidLiquid,
                                (int) (1000)))
                .duration(16 * TICKS).eut(1).addTo(cannerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ThirtyKCell.get())
                .itemOutputs(ItemList.Reactor_Coolant_NaK_3.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SodiumPotassium,
                                Materials2FluidShapes.shapeFluidLiquid,
                                (int) (3000)))
                .duration(2 * SECONDS + 8 * TICKS).eut(1).addTo(cannerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.SixtyKCell.get())
                .itemOutputs(ItemList.Reactor_Coolant_NaK_6.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SodiumPotassium,
                                Materials2FluidShapes.shapeFluidLiquid,
                                (int) (6000)))
                .duration(4 * SECONDS + 16 * TICKS).eut(1).addTo(cannerRecipes);

        // Space Cooling Cells
        GTValues.RA.stdBuilder().itemInputs(NHItemList.Empty180SpCell.get())
                .itemOutputs(ItemList.Reactor_Coolant_Sp_1.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SuperCoolant,
                                Materials2FluidShapes.shapeFluidLiquid,
                                (int) (1000L)))
                .duration(16 * TICKS).eut(1).addTo(cannerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.Empty360SpCell.get())
                .itemOutputs(ItemList.Reactor_Coolant_Sp_2.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SuperCoolant,
                                Materials2FluidShapes.shapeFluidLiquid,
                                (int) (2000L)))
                .duration(1 * SECONDS + 12 * TICKS).eut(1).addTo(cannerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.Empty540SpCell.get())
                .itemOutputs(ItemList.Reactor_Coolant_Sp_3.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SuperCoolant,
                                Materials2FluidShapes.shapeFluidLiquid,
                                (int) (3000L)))
                .duration(2 * SECONDS + 8 * TICKS).eut(1).addTo(cannerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.Empty1080SpCell.get())
                .itemOutputs(ItemList.Reactor_Coolant_Sp_6.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SuperCoolant,
                                Materials2FluidShapes.shapeFluidLiquid,
                                (int) (6000L)))
                .duration(4 * SECONDS + 16 * TICKS).eut(1).addTo(cannerRecipes);

        if (GalaxySpace.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(NHItemList.TenKCell.get())
                    .itemOutputs(ItemList.Reactor_Coolant_He_1.get(1L))
                    .fluidInputs(new FluidStack(FluidRegistry.getFluid("liquid helium"), 1000)).duration(16 * TICKS)
                    .eut(1).addTo(cannerRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ThirtyKCell.get())
                    .itemOutputs(ItemList.Reactor_Coolant_He_3.get(1L))
                    .fluidInputs(new FluidStack(FluidRegistry.getFluid("liquid helium"), 3000))
                    .duration(2 * SECONDS + 8 * TICKS).eut(1).addTo(cannerRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.SixtyKCell.get())
                    .itemOutputs(ItemList.Reactor_Coolant_He_6.get(1L))
                    .fluidInputs(new FluidStack(FluidRegistry.getFluid("liquid helium"), 6000))
                    .duration(4 * SECONDS + 16 * TICKS).eut(1).addTo(cannerRecipes);
        }
    }
}
