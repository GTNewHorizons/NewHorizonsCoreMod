package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.BartWorks;
import static gregtech.api.enums.Mods.GalaxySpace;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;

public class FluidCannerRecipes implements Runnable {

    @Override
    public void run() {
        // NAK and Helium Cooling Cells
        GT_Values.RA.addFluidCannerRecipe(
                CustomItemList.TenKCell.get(1L),
                ItemList.Reactor_Coolant_NaK_1.get(1L),
                new FluidStack(FluidRegistry.getFluid("sodiumpotassium"), 1000),
                GT_Values.NF);
        GT_Values.RA.addFluidCannerRecipe(
                CustomItemList.ThirtyKCell.get(1L),
                ItemList.Reactor_Coolant_NaK_3.get(1L),
                new FluidStack(FluidRegistry.getFluid("sodiumpotassium"), 3000),
                GT_Values.NF);
        GT_Values.RA.addFluidCannerRecipe(
                CustomItemList.SixtyKCell.get(1L),
                ItemList.Reactor_Coolant_NaK_6.get(1L),
                new FluidStack(FluidRegistry.getFluid("sodiumpotassium"), 6000),
                GT_Values.NF);

        // Space Cooling Cells
        GT_Values.RA.addFluidCannerRecipe(
                CustomItemList.Empty180SpCell.get(1L),
                ItemList.Reactor_Coolant_Sp_1.get(1L),
                Materials.SuperCoolant.getFluid(1000L),
                GT_Values.NF);
        GT_Values.RA.addFluidCannerRecipe(
                CustomItemList.Empty360SpCell.get(1L),
                ItemList.Reactor_Coolant_Sp_2.get(1L),
                Materials.SuperCoolant.getFluid(2000L),
                GT_Values.NF);
        GT_Values.RA.addFluidCannerRecipe(
                CustomItemList.Empty540SpCell.get(1L),
                ItemList.Reactor_Coolant_Sp_3.get(1L),
                Materials.SuperCoolant.getFluid(3000L),
                GT_Values.NF);
        GT_Values.RA.addFluidCannerRecipe(
                CustomItemList.Empty1080SpCell.get(1L),
                ItemList.Reactor_Coolant_Sp_6.get(1L),
                Materials.SuperCoolant.getFluid(6000L),
                GT_Values.NF);

        if (GalaxySpace.isModLoaded() && BartWorks.isModLoaded()) {
            GT_Values.RA.addFluidCannerRecipe(
                    CustomItemList.TenKCell.get(1L),
                    ItemList.Reactor_Coolant_He_1.get(1L),
                    new FluidStack(FluidRegistry.getFluid("liquid helium"), 1000),
                    GT_Values.NF);
            GT_Values.RA.addFluidCannerRecipe(
                    CustomItemList.ThirtyKCell.get(1L),
                    ItemList.Reactor_Coolant_He_3.get(1L),
                    new FluidStack(FluidRegistry.getFluid("liquid helium"), 3000),
                    GT_Values.NF);
            GT_Values.RA.addFluidCannerRecipe(
                    CustomItemList.SixtyKCell.get(1L),
                    ItemList.Reactor_Coolant_He_6.get(1L),
                    new FluidStack(FluidRegistry.getFluid("liquid helium"), 6000),
                    GT_Values.NF);
        }
    }
}
