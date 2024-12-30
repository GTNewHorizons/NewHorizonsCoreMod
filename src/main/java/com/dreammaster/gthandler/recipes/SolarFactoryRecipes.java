package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.SuperSolarPanels;
import static gregtech.api.recipe.RecipeMaps.solarFactoryRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeConstants.SOLAR_FACTORY_RECIPE_DATA;
import static gregtech.common.tileentities.machines.multi.MTESolarFactory.validWafers;

import java.util.ArrayList;
import java.util.Arrays;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import org.apache.commons.lang3.tuple.Pair;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTRecipeBuilder;
import gregtech.api.util.recipe.SolarFactoryRecipeData;

// Recipe metadata values represent the minimum tier and the amount of wafers respectively.

// If the recipe you are making doesn't use a wafer, just make it without any metadata.
public class SolarFactoryRecipes implements Runnable {

    public GTRecipeBuilder[] SolarFactoryRawRecipes = {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            CustomItemList.IrradiantReinforcedAluminiumPlate.get(2),
                            ItemList.Circuit_Silicon_Wafer2.get(4),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorMV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.HV), 2))
                    .itemOutputs(ItemList.Cover_SolarPanel_LV.get(1))
                    .fluidInputs(Materials.Polytetrafluoroethylene.getMolten(288))
                    .metadata(SOLAR_FACTORY_RECIPE_DATA, new SolarFactoryRecipeData(2, 4)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_HV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            CustomItemList.IrradiantReinforcedTitaniumPlate.get(2),
                            ItemList.Circuit_Silicon_Wafer2.get(4),
                            ItemList.Circuit_Chip_ULPIC.get(4),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorHV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.EV), 2))
                    .itemOutputs(ItemList.Cover_SolarPanel_MV.get(1)).fluidInputs(Materials.Epoxid.getMolten(576))
                    .metadata(SOLAR_FACTORY_RECIPE_DATA, new SolarFactoryRecipeData(2, 4)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_EV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            CustomItemList.IrradiantReinforcedTungstenPlate.get(4),
                            ItemList.Circuit_Silicon_Wafer2.get(4),
                            ItemList.Circuit_Chip_LPIC.get(4),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorEV, 8),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.IV), 4),
                            GTOreDictUnificator.get(OrePrefixes.plate.get(Materials.IndiumGalliumPhosphide), 8))
                    .itemOutputs(ItemList.Cover_SolarPanel_HV.get(1)).fluidInputs(Materials.Epoxid.getMolten(1152))
                    .metadata(SOLAR_FACTORY_RECIPE_DATA, new SolarFactoryRecipeData(2, 4)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_IV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            CustomItemList.IrradiantReinforcedTungstenSteelPlate.get(4),
                            ItemList.Circuit_Silicon_Wafer3.get(4),
                            ItemList.Circuit_Chip_PIC.get(4),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorIV, 8),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.LuV), 4),
                            GTOreDictUnificator.get(OrePrefixes.plate.get(Materials.SiliconSG), 16))
                    .itemOutputs(ItemList.Cover_SolarPanel_EV.get(1))
                    .fluidInputs(Materials.Polybenzimidazole.getMolten(576))
                    .metadata(SOLAR_FACTORY_RECIPE_DATA, new SolarFactoryRecipeData(3, 4)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_LuV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            CustomItemList.IrradiantReinforcedChromePlate.get(4),
                            ItemList.Circuit_Silicon_Wafer3.get(8),
                            ItemList.Circuit_Chip_HPIC.get(4),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 10),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.ZPM), 4),
                            GTOreDictUnificator.get(OrePrefixes.block.get(Materials.SiliconSG), 4))
                    .itemOutputs(ItemList.Cover_SolarPanel_IV.get(1))
                    .fluidInputs(Materials.Polybenzimidazole.getMolten(1152))
                    .metadata(SOLAR_FACTORY_RECIPE_DATA, new SolarFactoryRecipeData(3, 8)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_ZPM),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            CustomItemList.IrradiantReinforcedChromePlate.get(4),
                            ItemList.Circuit_Silicon_Wafer4.get(8),
                            ItemList.Circuit_Chip_UHPIC.get(8),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorZPM, 24),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.UV), 2),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.ZPM), 6),
                            GTOreDictUnificator.get(OrePrefixes.block.get(Materials.SiliconSG), 8),
                            getModItem(SuperSolarPanels.ID, "solarsplitter", 4, 0))
                    .itemOutputs(ItemList.Cover_SolarPanel_LuV.get(1))
                    .fluidInputs(Materials.Polybenzimidazole.getMolten(1728))
                    .metadata(SOLAR_FACTORY_RECIPE_DATA, new SolarFactoryRecipeData(4, 8)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_UV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            CustomItemList.IrradiantReinforcedNaquadriaPlate.get(8),
                            ItemList.Circuit_Silicon_Wafer5.get(8),
                            ItemList.Circuit_Wafer_QPIC.get(4),
                            ItemList.Circuit_Chip_NPIC.get(8),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUV, 32),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.UHV), 2),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.UV), 4))
                    .itemOutputs(ItemList.Cover_SolarPanel_ZPM.get(1))
                    .fluidInputs(Materials.Polybenzimidazole.getMolten(2304))
                    .metadata(SOLAR_FACTORY_RECIPE_DATA, new SolarFactoryRecipeData(5, 8)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_UHV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            CustomItemList.IrradiantReinforcedNaquadriaPlate.get(8),
                            ItemList.Circuit_Silicon_Wafer5.get(8),
                            getModItem(NewHorizonsCoreMod.ID, "item.PicoWafer", 8),
                            ItemList.Circuit_Chip_PPIC.get(8),
                            ItemList.Circuit_Chip_CrystalSoC2.get(8),
                            GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorUHV, 12),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.UEV), 2),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.UHV), 4),
                            GTOreDictUnificator.get(OrePrefixes.plateSuperdense.get(Materials.SiliconSG), 4))
                    .itemOutputs(ItemList.Cover_SolarPanel_UV.get(1))
                    .fluidInputs(new FluidStack(FluidRegistry.getFluid("molten.indalloy140"), 1152))
                    .metadata(SOLAR_FACTORY_RECIPE_DATA, new SolarFactoryRecipeData(5, 8)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_UEV) };

    public void run() {
        // Fake
        for (GTRecipeBuilder recipeBuilder : SolarFactoryRawRecipes) {
            GTRecipeBuilder tempRecipe = recipeBuilder.copyNoMetadata();
            tempRecipe.fake().addTo(solarFactoryRecipes);
        }

        // Hidden
        for (GTRecipeBuilder recipeBuilder : SolarFactoryRawRecipes) {
            GTRecipeBuilder tempRecipe = recipeBuilder.copy();
            ItemStack[] tempRecipeInputs = tempRecipe.getItemInputsBasic();
            ArrayList<ItemStack> inputs = new ArrayList<>(Arrays.asList(tempRecipeInputs));
            nextRecipe: for (int i = 0; i < tempRecipeInputs.length; i++) {
                for (Pair<ItemStack, Integer> pair : validWafers) {
                    if (i >= inputs.size()) break nextRecipe;
                    if (inputs.get(i).isItemEqual(pair.getLeft())) {
                        inputs.remove(i);
                        break nextRecipe;
                    }
                }
            }
            tempRecipe.itemInputs(inputs.toArray()).hidden().addTo(solarFactoryRecipes);
        }
    }
}
