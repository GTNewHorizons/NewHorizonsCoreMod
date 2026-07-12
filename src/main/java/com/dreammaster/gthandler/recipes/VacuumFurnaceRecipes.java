package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.recipe.RecipeMaps.vacuumFurnaceRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeConstants.COIL_HEAT;

import net.minecraftforge.fluids.FluidStack;

import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;
import gregtech.common.items.CombType;
import gregtech.loaders.misc.GTBees;
import gtPlusPlus.core.fluids.GTPPFluids;
import gtPlusPlus.core.material.MaterialsElements;

public class VacuumFurnaceRecipes implements Runnable {

    @Override
    public void run() {

        if (Forestry.isModLoaded()) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTBees.combs.getStackForType(CombType.INDIUM, 64),
                            GTBees.combs.getStackForType(CombType.INDIUM, 64),
                            GTBees.combs.getStackForType(CombType.INDIUM, 64),
                            GTBees.combs.getStackForType(CombType.INDIUM, 64))
                    .circuit(2)
                    .itemOutputs(
                            MaterialLibAPI.getStack(Materials2Materials.Zinc, Materials2Shapes.dust, (int) (64L)),
                            MaterialLibAPI.getStack(Materials2Materials.Zinc, Materials2Shapes.dust, (int) (64L)),
                            MaterialLibAPI.getStack(Materials2Materials.Zinc, Materials2Shapes.dust, (int) (52L)),
                            MaterialLibAPI.getStack(Materials2Materials.Iron, Materials2Shapes.dust, (int) (64L)),
                            MaterialLibAPI.getStack(Materials2Materials.Iron, Materials2Shapes.dust, (int) (56L)),
                            MaterialLibAPI.getStack(Materials2Materials.Indium, Materials2Shapes.dust, (int) (64L)),
                            MaterialLibAPI.getStack(Materials2Materials.Indium, Materials2Shapes.dust, (int) (64L)),
                            MaterialLibAPI.getStack(Materials2Materials.Indium, Materials2Shapes.dust, (int) (64L)),
                            MaterialsElements.getInstance().GERMANIUM.getDust(15))
                    .fluidInputs(new FluidStack(GTPPFluids.SphaleriteFlotationFroth, 4000))
                    .fluidOutputs(new FluidStack(GTPPFluids.RedMud, 2000), Materials.Water.getFluid(2000))
                    .eut((int) TierEU.RECIPE_LuV).metadata(COIL_HEAT, 5500).duration(2 * MINUTES)
                    .addTo(vacuumFurnaceRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTBees.combs.getStackForType(CombType.INDIUM, 40)).circuit(2)
                    .itemOutputs(
                            MaterialLibAPI.getStack(Materials2Materials.Copper, Materials2Shapes.dust, (int) (64L)),
                            MaterialLibAPI.getStack(Materials2Materials.Copper, Materials2Shapes.dust, (int) (64L)),
                            MaterialLibAPI.getStack(Materials2Materials.Copper, Materials2Shapes.dust, (int) (52L)),
                            MaterialLibAPI.getStack(Materials2Materials.Iron, Materials2Shapes.dust, (int) (64L)),
                            MaterialLibAPI.getStack(Materials2Materials.Iron, Materials2Shapes.dust, (int) (56L)),
                            MaterialLibAPI.getStack(Materials2Materials.Cadmium, Materials2Shapes.dust, (int) (50L)),
                            MaterialLibAPI.getStack(Materials2Materials.Indium, Materials2Shapes.dust, (int) (30L)))
                    .fluidInputs(new FluidStack(GTPPFluids.ChalcopyriteFlotationFroth, 4000))
                    .fluidOutputs(new FluidStack(GTPPFluids.RedMud, 2000), Materials.Water.getFluid(2000))
                    .eut((int) TierEU.RECIPE_IV).metadata(COIL_HEAT, 4500).duration(2 * MINUTES)
                    .addTo(vacuumFurnaceRecipes);
        }
    }
}
