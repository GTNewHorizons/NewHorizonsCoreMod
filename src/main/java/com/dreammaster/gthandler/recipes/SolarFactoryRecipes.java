package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.AdvancedSolarPanel;
import static gregtech.api.recipe.RecipeMaps.solarFactoryRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
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
import gregtech.api.enums.MaterialsKevlar;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.recipe.metadata.SolarFactoryRecipeDataKey;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTRecipeBuilder;
import gregtech.api.util.recipe.SolarFactoryRecipeData;

// Recipe metadata values represent the minimum tier and the amount of wafers respectively.

// If the recipe you are making doesn't use a wafer, just make it without any metadata.
public class SolarFactoryRecipes implements Runnable {

    SolarFactoryRecipeDataKey data = SolarFactoryRecipeDataKey.INSTANCE;

    public GTRecipeBuilder[] SolarFactoryRawRecipes = {
            // Recursive recipes
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Cover_SolarPanel_8V.get(1),
                            CustomItemList.IrradiantReinforcedAluminiumPlate.get(2),
                            ItemList.Circuit_Silicon_Wafer2.get(4),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorMV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.HV), 2))
                    .itemOutputs(ItemList.Cover_SolarPanel_LV.get(1))
                    .fluidInputs(Materials.Polytetrafluoroethylene.getMolten(2 * 144))
                    .metadata(data, new SolarFactoryRecipeData(2, 4)).duration(10 * SECONDS).eut(TierEU.RECIPE_HV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Cover_SolarPanel_LV.get(1),
                            CustomItemList.IrradiantReinforcedTitaniumPlate.get(2),
                            ItemList.Circuit_Silicon_Wafer2.get(4),
                            ItemList.Circuit_Chip_ULPIC.get(4),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorHV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.EV), 2))
                    .itemOutputs(ItemList.Cover_SolarPanel_MV.get(1)).fluidInputs(Materials.Epoxid.getMolten(4 * 144))
                    .metadata(data, new SolarFactoryRecipeData(2, 4)).duration(10 * SECONDS).eut(TierEU.RECIPE_EV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Cover_SolarPanel_MV.get(1),
                            CustomItemList.IrradiantReinforcedTungstenPlate.get(4),
                            ItemList.Circuit_Silicon_Wafer2.get(4),
                            ItemList.Circuit_Chip_LPIC.get(4),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorEV, 8),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.IV), 4),
                            GTOreDictUnificator.get(OrePrefixes.plate.get(Materials.IndiumGalliumPhosphide), 8))
                    .itemOutputs(ItemList.Cover_SolarPanel_HV.get(1)).fluidInputs(Materials.Epoxid.getMolten(8 * 144))
                    .metadata(data, new SolarFactoryRecipeData(2, 4)).duration(10 * SECONDS).eut(TierEU.RECIPE_IV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Cover_SolarPanel_HV.get(1),
                            CustomItemList.IrradiantReinforcedTungstenSteelPlate.get(4),
                            ItemList.Circuit_Silicon_Wafer3.get(4),
                            ItemList.Circuit_Chip_PIC.get(4),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorIV, 8),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.LuV), 4),
                            GTOreDictUnificator.get(OrePrefixes.plate.get(Materials.SiliconSG), 16))
                    .itemOutputs(ItemList.Cover_SolarPanel_EV.get(1))
                    .fluidInputs(Materials.Polybenzimidazole.getMolten(4 * 144))
                    .metadata(data, new SolarFactoryRecipeData(3, 4)).duration(10 * SECONDS).eut(TierEU.RECIPE_LuV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Cover_SolarPanel_EV.get(1),
                            CustomItemList.IrradiantReinforcedChromePlate.get(4),
                            ItemList.Circuit_Silicon_Wafer3.get(8),
                            ItemList.Circuit_Chip_HPIC.get(4),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 10),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.ZPM), 4),
                            GTOreDictUnificator.get(OrePrefixes.block.get(Materials.SiliconSG), 4))
                    .itemOutputs(ItemList.Cover_SolarPanel_IV.get(1))
                    .fluidInputs(Materials.Polybenzimidazole.getMolten(8 * 144))
                    .metadata(data, new SolarFactoryRecipeData(3, 8)).duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Cover_SolarPanel_IV.get(1),
                            getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 4, 8),
                            // ^ Irradiant Reinforced Iridium Plate
                            ItemList.Circuit_Silicon_Wafer4.get(8),
                            ItemList.Circuit_Chip_UHPIC.get(8),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorZPM, 24),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.UV), 8),
                            GTOreDictUnificator.get(OrePrefixes.block.get(Materials.SiliconSG), 8))
                    .itemOutputs(ItemList.Cover_SolarPanel_LuV.get(1))
                    .fluidInputs(Materials.Polybenzimidazole.getMolten(12 * 144))
                    .metadata(data, new SolarFactoryRecipeData(4, 8)).duration(10 * SECONDS).eut(TierEU.RECIPE_UV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Cover_SolarPanel_LuV.get(1),
                            CustomItemList.IrradiantReinforcedNaquadriaPlate.get(8),
                            ItemList.Circuit_Silicon_Wafer5.get(8),
                            ItemList.Circuit_Wafer_QPIC.get(4),
                            ItemList.Circuit_Chip_NPIC.get(8),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUV, 32),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.UHV), 8))
                    .itemOutputs(ItemList.Cover_SolarPanel_ZPM.get(1))
                    .fluidInputs(Materials.Polybenzimidazole.getMolten(16 * 144))
                    .metadata(data, new SolarFactoryRecipeData(5, 8)).duration(10 * SECONDS).eut(TierEU.RECIPE_UHV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Cover_SolarPanel_ZPM.get(1),
                            CustomItemList.IrradiantReinforcedNaquadriaPlate.get(8),
                            ItemList.Circuit_Silicon_Wafer5.get(8),
                            CustomItemList.PicoWafer.get(8),
                            ItemList.Circuit_Chip_PPIC.get(8),
                            ItemList.Circuit_Chip_CrystalSoC2.get(8),
                            GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorUHV, 12),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.UEV), 8),
                            GTOreDictUnificator.get(OrePrefixes.plateSuperdense.get(Materials.SiliconSG), 4))
                    .itemOutputs(ItemList.Cover_SolarPanel_UV.get(1))
                    .fluidInputs(new FluidStack(FluidRegistry.getFluid("molten.indalloy140"), 8 * 144))
                    .metadata(data, new SolarFactoryRecipeData(5, 8)).duration(10 * SECONDS).eut(TierEU.RECIPE_UEV),

            // Non-recursive / skipping recipes
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            CustomItemList.IrradiantReinforcedNeutroniumPlate.get(2),
                            ItemList.Circuit_Silicon_Wafer5.get(2),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUV, 16),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.UHV), 4),
                            GTOreDictUnificator.get(OrePrefixes.plateSuperdense.get(Materials.SiliconSG), 8))
                    .itemOutputs(ItemList.Cover_SolarPanel_LV.get(1))
                    .fluidInputs(Materials.VibrantAlloy.getMolten(4 * 144))
                    .metadata(data, new SolarFactoryRecipeData(2, 4, 3)).duration(10 * SECONDS).eut(TierEU.RECIPE_HV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            CustomItemList.IrradiantReinforcedNeutroniumPlate.get(4),
                            ItemList.Circuit_Silicon_Wafer5.get(4),
                            ItemList.Circuit_Wafer_QPIC.get(4),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUV, 16),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.UHV), 8),
                            GTOreDictUnificator.get(OrePrefixes.plateSuperdense.get(Materials.SiliconSG), 8))
                    .itemOutputs(ItemList.Cover_SolarPanel_MV.get(1))
                    .fluidInputs(Materials.Barium.getMolten(16 * 144), Materials.MeteoricSteel.getMolten(4 * 144))
                    .metadata(data, new SolarFactoryRecipeData(2, 4, 3)).duration(10 * SECONDS).eut(TierEU.RECIPE_EV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            CustomItemList.IrradiantReinforcedNeutroniumPlate.get(6),
                            ItemList.Circuit_Silicon_Wafer5.get(6),
                            ItemList.Circuit_Wafer_QPIC.get(4),
                            GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorUV, 16),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.UHV), 12),
                            GTOreDictUnificator.get(OrePrefixes.plate.get(Materials.Tritanium), 8),
                            GTOreDictUnificator.get(OrePrefixes.plateSuperdense.get(Materials.SiliconSG), 16))
                    .itemOutputs(ItemList.Cover_SolarPanel_HV.get(1))
                    .fluidInputs(Materials.Uranium.getMolten(4 * 144), Materials.Sunnarium.getMolten(8 * 144))
                    .metadata(data, new SolarFactoryRecipeData(2, 4, 3)).duration(10 * SECONDS).eut(TierEU.RECIPE_IV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            CustomItemList.IrradiantReinforcedNeutroniumPlate.get(8),
                            ItemList.Circuit_Silicon_Wafer5.get(8),
                            ItemList.Circuit_Wafer_QPIC.get(4),
                            ItemList.Circuit_Chip_NPIC.get(4),
                            GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.SuperconductorUV, 16),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.UHV), 16),
                            GTOreDictUnificator.get(OrePrefixes.plateSuperdense.get(Materials.SiliconSG), 16))
                    .itemOutputs(ItemList.Cover_SolarPanel_EV.get(1))
                    .fluidInputs(
                            Materials.Plutonium.getMolten(2 * 144),
                            Materials.Knightmetal.getMolten(4 * 144),
                            Materials.Ultimet.getMolten(8 * 144))
                    .metadata(data, new SolarFactoryRecipeData(3, 4, 3)).duration(10 * SECONDS).eut(TierEU.RECIPE_LuV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            CustomItemList.IrradiantReinforcedBedrockiumPlate.get(2),
                            ItemList.Circuit_Silicon_Wafer5.get(10),
                            ItemList.Circuit_Wafer_QPIC.get(4),
                            ItemList.Circuit_Chip_UHPIC.get(4),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUHV, 16),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.UEV), 4),
                            GTOreDictUnificator.get(OrePrefixes.plateSuperdense.get(Materials.SiliconSG), 32))
                    .itemOutputs(ItemList.Cover_SolarPanel_IV.get(1))
                    .fluidInputs(
                            Materials.Chrome.getMolten(8 * 144),
                            Materials.NaquadahAlloy.getMolten(4 * 144),
                            Materials.FierySteel.getMolten(2 * 144))
                    .metadata(data, new SolarFactoryRecipeData(3, 8, 3)).duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            CustomItemList.IrradiantReinforcedBedrockiumPlate.get(4),
                            ItemList.Circuit_Silicon_Wafer5.get(12),
                            ItemList.Circuit_Chip_UHPIC.get(8),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUHV, 16),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.UEV), 8),
                            GTOreDictUnificator.get(OrePrefixes.plateSuperdense.get(Materials.Steeleaf), 1),
                            GTOreDictUnificator.get(OrePrefixes.plateSuperdense.get(Materials.SiliconSG), 32))
                    .itemOutputs(ItemList.Cover_SolarPanel_LuV.get(1))
                    .fluidInputs(
                            new FluidStack(FluidRegistry.getFluid("molten.indalloy140"), 8 * 144),
                            Materials.FierySteel.getMolten(4 * 144),
                            Materials.Knightmetal.getMolten(4 * 144))
                    .metadata(data, new SolarFactoryRecipeData(4, 8, 3)).duration(10 * SECONDS).eut(TierEU.RECIPE_UV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            CustomItemList.IrradiantReinforcedBedrockiumPlate.get(6),
                            ItemList.Circuit_Silicon_Wafer5.get(14),
                            ItemList.Circuit_Wafer_QPIC.get(4),
                            ItemList.Circuit_Chip_NPIC.get(8),
                            GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorUHV, 16),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.UEV), 12),
                            GTOreDictUnificator.get(OrePrefixes.plateSuperdense.get(Materials.SiliconSG), 64))
                    .itemOutputs(ItemList.Cover_SolarPanel_ZPM.get(1))
                    .fluidInputs(Materials.Infinity.getMolten(2 * 144), MaterialsKevlar.Kevlar.getMolten(4 * 144))
                    .metadata(data, new SolarFactoryRecipeData(5, 8, 3)).duration(10 * SECONDS).eut(TierEU.RECIPE_UHV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            CustomItemList.IrradiantReinforcedBedrockiumPlate.get(8),
                            ItemList.Circuit_Silicon_Wafer5.get(16),
                            CustomItemList.PicoWafer.get(8),
                            ItemList.Circuit_Chip_PPIC.get(8),
                            ItemList.Circuit_Chip_CrystalSoC2.get(8),
                            GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.SuperconductorUHV, 16),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.UEV), 16),
                            GTOreDictUnificator.get(OrePrefixes.plateSuperdense.get(Materials.SiliconSG), 64))
                    .itemOutputs(ItemList.Cover_SolarPanel_UV.get(1))
                    .fluidInputs(Materials.Infinity.getMolten(4 * 144), MaterialsKevlar.Kevlar.getMolten(8 * 144))
                    .metadata(data, new SolarFactoryRecipeData(5, 8, 3)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_UEV) };

    public void run() {
        if (AdvancedSolarPanel.isModLoaded()) {
            // Fake
            for (GTRecipeBuilder recipeBuilder : SolarFactoryRawRecipes) {
                GTRecipeBuilder tempRecipe = recipeBuilder.copy();
                tempRecipe.fake().addTo(solarFactoryRecipes);
            }

            // Hidden
            for (GTRecipeBuilder recipeBuilder : SolarFactoryRawRecipes) {
                GTRecipeBuilder tempRecipe = recipeBuilder.copy();
                ItemStack[] tempRecipeInputs = tempRecipe.getItemInputsBasic();
                ArrayList<ItemStack> inputs = new ArrayList<>(Arrays.asList(tempRecipeInputs));
                nextRecipe: for (int i = 1; i < tempRecipeInputs.length; i++) {
                    for (Pair<ItemStack, Integer> pair : validWafers) {
                        if (i > inputs.size()) break nextRecipe;
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
}
