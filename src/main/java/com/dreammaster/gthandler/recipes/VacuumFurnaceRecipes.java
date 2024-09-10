package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeConstants.COIL_HEAT;
import static gtPlusPlus.api.recipe.GTPPRecipeMaps.vacuumFurnaceRecipes;
import static gtPlusPlus.core.item.chemistry.MilledOreProcessing.ChalcopyriteFlotationFroth;
import static gtPlusPlus.core.item.chemistry.MilledOreProcessing.SphaleriteFlotationFroth;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gregtech.common.items.CombType;
import gregtech.loaders.misc.GTBees;
import gtPlusPlus.core.item.chemistry.AgriculturalChem;
import gtPlusPlus.core.material.MaterialsElements;
import gtPlusPlus.core.util.minecraft.FluidUtils;

public class VacuumFurnaceRecipes implements Runnable {

    @Override
    public void run() {

        if (Forestry.isModLoaded()) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTUtility.getIntegratedCircuit(12),
                            GTBees.combs.getStackForType(CombType.INDIUM, 64),
                            GTBees.combs.getStackForType(CombType.INDIUM, 64),
                            GTBees.combs.getStackForType(CombType.INDIUM, 64),
                            GTBees.combs.getStackForType(CombType.INDIUM, 64))
                    .itemOutputs(
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Zinc, 64L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Zinc, 64L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Zinc, 52L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 64L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 56L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Indium, 64L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Indium, 64L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Indium, 64L),
                            MaterialsElements.getInstance().GERMANIUM.getDust(15))
                    .fluidInputs(FluidUtils.getFluidStack(SphaleriteFlotationFroth, 4000))
                    .fluidOutputs(FluidUtils.getFluidStack(AgriculturalChem.RedMud, 2000), FluidUtils.getWater(2000))
                    .eut((int) TierEU.RECIPE_LuV).metadata(COIL_HEAT, 5500).duration(2 * MINUTES)
                    .addTo(vacuumFurnaceRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTUtility.getIntegratedCircuit(13), GTBees.combs.getStackForType(CombType.INDIUM, 40))
                    .itemOutputs(
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 64L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 64L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 52L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 64L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 56L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Cadmium, 50L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Indium, 30L))
                    .fluidInputs(FluidUtils.getFluidStack(ChalcopyriteFlotationFroth, 4000))
                    .fluidOutputs(FluidUtils.getFluidStack(AgriculturalChem.RedMud, 2000), FluidUtils.getWater(2000))
                    .eut((int) TierEU.RECIPE_IV).metadata(COIL_HEAT, 4500).duration(2 * MINUTES)
                    .addTo(vacuumFurnaceRecipes);
        }
    }
}
