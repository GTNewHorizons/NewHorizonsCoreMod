package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeConstants.COIL_HEAT;
import static gtPlusPlus.api.recipe.GTPPRecipeMaps.vacuumFurnaceRecipes;

import net.minecraftforge.fluids.FluidStack;

import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;
import gregtech.api.material.MaterialUtils;
import gregtech.common.items.CombType;
import gregtech.loaders.misc.GTBees;
import gtPlusPlus.core.fluids.GTPPFluids;

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
                            MaterialLibAPI.getStack(Materials.Zinc, Shapes.dust, (int) (64L)),
                            MaterialLibAPI.getStack(Materials.Zinc, Shapes.dust, (int) (64L)),
                            MaterialLibAPI.getStack(Materials.Zinc, Shapes.dust, (int) (52L)),
                            MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, (int) (64L)),
                            MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, (int) (56L)),
                            MaterialLibAPI.getStack(Materials.Indium, Shapes.dust, (int) (64L)),
                            MaterialLibAPI.getStack(Materials.Indium, Shapes.dust, (int) (64L)),
                            MaterialLibAPI.getStack(Materials.Indium, Shapes.dust, (int) (64L)),
                            MaterialLibAPI.getStack(Materials.Germanium, Shapes.dust, (int) (15)))
                    .fluidInputs(new FluidStack(GTPPFluids.SphaleriteFlotationFroth, 4000))
                    .fluidOutputs(new FluidStack(GTPPFluids.RedMud, 2000), MaterialUtils.fluid(Materials.Water, 2000))
                    .eut((int) TierEU.RECIPE_LuV).metadata(COIL_HEAT, 5500).duration(2 * MINUTES)
                    .addTo(vacuumFurnaceRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTBees.combs.getStackForType(CombType.INDIUM, 40)).circuit(2)
                    .itemOutputs(
                            MaterialLibAPI.getStack(Materials.Copper, Shapes.dust, (int) (64L)),
                            MaterialLibAPI.getStack(Materials.Copper, Shapes.dust, (int) (64L)),
                            MaterialLibAPI.getStack(Materials.Copper, Shapes.dust, (int) (52L)),
                            MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, (int) (64L)),
                            MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, (int) (56L)),
                            MaterialLibAPI.getStack(Materials.Cadmium, Shapes.dust, (int) (50L)),
                            MaterialLibAPI.getStack(Materials.Indium, Shapes.dust, (int) (30L)))
                    .fluidInputs(new FluidStack(GTPPFluids.ChalcopyriteFlotationFroth, 4000))
                    .fluidOutputs(new FluidStack(GTPPFluids.RedMud, 2000), MaterialUtils.fluid(Materials.Water, 2000))
                    .eut((int) TierEU.RECIPE_IV).metadata(COIL_HEAT, 4500).duration(2 * MINUTES)
                    .addTo(vacuumFurnaceRecipes);
        }
    }
}
