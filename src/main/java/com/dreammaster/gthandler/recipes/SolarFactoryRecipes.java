package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.AdvancedSolarPanel;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.SuperSolarPanels;
import static gregtech.api.recipe.RecipeMaps.solarFactoryRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gregtech.common.tileentities.machines.multi.MTESolarFactory.validWafers;

import java.util.ArrayList;
import java.util.Arrays;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import org.apache.commons.lang3.tuple.Pair;

import com.dreammaster.item.NHItemList;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.Circuits;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials.FluidShapes;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;
import gregtech.api.material.MaterialParts;
import gregtech.api.recipe.metadata.SolarFactoryRecipeDataKey;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTRecipeBuilder;
import gregtech.api.util.recipe.SolarFactoryRecipeData;

// Recipe metadata values represent the minimum tier and the amount of wafers respectively.

// If the recipe you are making doesn't use a wafer, just make it without any metadata.
public class SolarFactoryRecipes implements Runnable {

    SolarFactoryRecipeDataKey data = SolarFactoryRecipeDataKey.INSTANCE;

    public GTRecipeBuilder[] SolarFactoryRawRecipes = {
            // Irradiant Reinforced Plates
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            NHItemList.ReinforcedAluminiumIronPlate.get(1),
                            getModItem(EnderIO.ID, "itemMaterial", 1, 6),
                            getModItem(IndustrialCraft2.ID, "itemPartIndustrialDiamond", 1, 0),
                            MaterialLibAPI.getStack(Materials.RedAlloy, Shapes.plate, (int) (2L)),
                            MaterialLibAPI.getStack(Materials.RedAlloy, Shapes.screw, (int) (4L)))
                    .itemOutputs(NHItemList.IrradiantReinforcedAluminiumPlate.get(1))
                    .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 144)).duration(30 * SECONDS)
                    .eut(TierEU.RECIPE_MV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            NHItemList.ReinforcedTitaniumIronPlate.get(1),
                            getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 0),
                            MaterialLibAPI.getStack(Materials.MeteoricSteel, Shapes.plate, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.Lapis, Shapes.plate, (int) (2L)),
                            MaterialLibAPI.getStack(Materials.RedAlloy, Shapes.screw, (int) (4L)))
                    .itemOutputs(NHItemList.IrradiantReinforcedTitaniumPlate.get(1))
                    .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).duration(30 * SECONDS)
                    .eut(TierEU.RECIPE_HV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            NHItemList.ReinforcedTungstenIronPlate.get(1),
                            getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 3),
                            MaterialLibAPI.getStack(Materials.Uranium, Shapes.plate, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.Steeleaf, Shapes.plate, (int) (2L)),
                            MaterialLibAPI.getStack(Materials.RedAlloy, Shapes.screw, (int) (4L)))
                    .itemOutputs(NHItemList.IrradiantReinforcedTungstenPlate.get(1))
                    .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 576)).duration(30 * SECONDS)
                    .eut(TierEU.RECIPE_EV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            NHItemList.ReinforcedTungstenSteelIronPlate.get(1),
                            MaterialLibAPI.getStack(Materials.Sunnarium, Shapes.plateQuadruple, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.Plutonium, Shapes.plate, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.Knightmetal, Shapes.plate, (int) (2L)),
                            MaterialLibAPI.getStack(Materials.RedAlloy, Shapes.screw, (int) (4L)))
                    .itemOutputs(NHItemList.IrradiantReinforcedTungstenSteelPlate.get(1))
                    .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 1152)).duration(30 * SECONDS)
                    .eut(TierEU.RECIPE_IV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            NHItemList.ReinforcedChromeIronPlate.get(1),
                            getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 1),
                            MaterialLibAPI.getStack(Materials.YttriumBariumCuprate, Shapes.plate, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.FierySteel, Shapes.plate, (int) (2L)),
                            MaterialLibAPI.getStack(Materials.RedAlloy, Shapes.screw, (int) (4L)))
                    .itemOutputs(NHItemList.IrradiantReinforcedChromePlate.get(1))
                    .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 2304))
                    .metadata(data, new SolarFactoryRecipeData(0, 0, 2)).duration(30 * SECONDS).eut(TierEU.RECIPE_LuV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 7),
                            getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 4),
                            MaterialLibAPI.getStack(Materials.Osmium, Shapes.plate, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.Iridium, Shapes.plate, (int) (2L)),
                            MaterialLibAPI.getStack(Materials.RedAlloy, Shapes.screw, (int) (4L)))
                    .itemOutputs(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 8))
                    .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 4608))
                    .metadata(data, new SolarFactoryRecipeData(0, 0, 2)).duration(30 * SECONDS).eut(TierEU.RECIPE_ZPM),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            NHItemList.ReinforcedNaquadriaIronPlate.get(1),
                            NHItemList.EnrichedNaquadriaSunnariumAlloy.get(1),
                            MaterialLibAPI.getStack(Materials.Quantium, Shapes.plate, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.Osmiridium, Shapes.plate, (int) (2L)),
                            MaterialLibAPI.getStack(Materials.RedAlloy, Shapes.screw, (int) (4L)))
                    .itemOutputs(NHItemList.IrradiantReinforcedNaquadriaPlate.get(1))
                    .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 9216))
                    .metadata(data, new SolarFactoryRecipeData(0, 0, 2)).duration(30 * SECONDS).eut(TierEU.RECIPE_UV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            NHItemList.ReinforcedNeutroniumIronPlate.get(1),
                            NHItemList.EnrichedNaquadriaNeutroniumSunnariumAlloy.get(1),
                            MaterialLibAPI.getStack(Materials.MysteriousCrystal, Shapes.plate, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.Infinity, Shapes.plate, (int) (2L)),
                            MaterialLibAPI.getStack(Materials.RedAlloy, Shapes.screw, (int) (4L)))
                    .itemOutputs(NHItemList.IrradiantReinforcedNeutroniumPlate.get(1))
                    .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 18432))
                    .metadata(data, new SolarFactoryRecipeData(0, 0, 3)).duration(30 * SECONDS).eut(TierEU.RECIPE_UHV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            NHItemList.ReinforcedBedrockiumIronPlate.get(1),
                            NHItemList.EnrichedXSunnariumAlloy.get(1),
                            MaterialLibAPI.getStack(Materials.DraconiumAwakened, Shapes.plate, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.InfinityCatalyst, Shapes.plate, (int) (2L)),
                            MaterialLibAPI.getStack(Materials.RedAlloy, Shapes.screw, (int) (4L)))
                    .itemOutputs(NHItemList.IrradiantReinforcedBedrockiumPlate.get(1))
                    .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36864))
                    .metadata(data, new SolarFactoryRecipeData(0, 0, 3)).duration(30 * SECONDS).eut(TierEU.RECIPE_UEV),

            // Recursive recipes
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Cover_SolarPanel_8V.get(1),
                            NHItemList.IrradiantReinforcedAluminiumPlate.get(2),
                            ItemList.Circuit_Silicon_Wafer2.get(4),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorMV, 4),
                            GTOreDictUnificator.get(Circuits.HV.getIngredient(), 2))
                    .itemOutputs(ItemList.Cover_SolarPanel_LV.get(1))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials.Polytetrafluoroethylene,
                                    FluidShapes.fluidMolten,
                                    (int) (2 * 144)))
                    .metadata(data, new SolarFactoryRecipeData(2, 4)).duration(10 * SECONDS).eut(TierEU.RECIPE_HV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Cover_SolarPanel_LV.get(1),
                            NHItemList.IrradiantReinforcedTitaniumPlate.get(2),
                            ItemList.Circuit_Silicon_Wafer2.get(4),
                            ItemList.Circuit_Chip_ULPIC.get(2),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorHV, 4),
                            GTOreDictUnificator.get(Circuits.EV.getIngredient(), 2))
                    .itemOutputs(ItemList.Cover_SolarPanel_MV.get(1))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(Materials.Epoxid, FluidShapes.fluidMolten, (int) (2 * 144)))
                    .metadata(data, new SolarFactoryRecipeData(2, 4)).duration(10 * SECONDS).eut(TierEU.RECIPE_EV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Cover_SolarPanel_MV.get(1),
                            NHItemList.IrradiantReinforcedTungstenPlate.get(2),
                            ItemList.Circuit_Silicon_Wafer2.get(4),
                            ItemList.Circuit_Chip_LPIC.get(2),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorEV, 4),
                            GTOreDictUnificator.get(Circuits.IV.getIngredient(), 4))
                    .itemOutputs(ItemList.Cover_SolarPanel_HV.get(1))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials.IndiumGalliumPhosphide,
                                    FluidShapes.fluidMolten,
                                    (int) (2 * 144)))
                    .metadata(data, new SolarFactoryRecipeData(2, 4)).duration(10 * SECONDS).eut(TierEU.RECIPE_IV),

            GTValues.RA.stdBuilder().itemInputs(
                    ItemList.Cover_SolarPanel_HV.get(1),
                    NHItemList.IrradiantReinforcedTungstenSteelPlate.get(2),
                    ItemList.Circuit_Silicon_Wafer3.get(4),
                    ItemList.Circuit_Chip_PIC.get(2),
                    GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorIV, 6),
                    GTOreDictUnificator.get(Circuits.LuV.getIngredient(), 4),
                    GTOreDictUnificator
                            .get(MaterialParts.craftIngredient(OrePrefixes.plate, Materials.SiliconSolarGrade), 12))
                    .itemOutputs(ItemList.Cover_SolarPanel_EV.get(1))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials.Polybenzimidazole,
                                    FluidShapes.fluidMolten,
                                    (int) (2 * 144)))
                    .metadata(data, new SolarFactoryRecipeData(3, 4)).duration(10 * SECONDS).eut(TierEU.RECIPE_LuV),

            GTValues.RA.stdBuilder().itemInputs(
                    ItemList.Cover_SolarPanel_EV.get(1),
                    NHItemList.IrradiantReinforcedChromePlate.get(2),
                    ItemList.Circuit_Silicon_Wafer3.get(8),
                    ItemList.Circuit_Chip_HPIC.get(2),
                    GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 6),
                    GTOreDictUnificator.get(Circuits.ZPM.getIngredient(), 4),
                    GTOreDictUnificator
                            .get(MaterialParts.craftIngredient(OrePrefixes.plate, Materials.SiliconSolarGrade), 16))
                    .itemOutputs(ItemList.Cover_SolarPanel_IV.get(1))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials.Polybenzimidazole,
                                    FluidShapes.fluidMolten,
                                    (int) (4 * 144)))
                    .metadata(data, new SolarFactoryRecipeData(3, 8)).duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM),

            GTValues.RA.stdBuilder().itemInputs(
                    ItemList.Cover_SolarPanel_IV.get(1),
                    getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 2, 8),
                    // Irradiant Reinforced Iridium Plate
                    ItemList.Circuit_Silicon_Wafer4.get(8),
                    ItemList.Circuit_Chip_UHPIC.get(2),
                    GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorZPM, 16),
                    GTOreDictUnificator.get(Circuits.UV.getIngredient(), 2),
                    GTOreDictUnificator.get(Circuits.ZPM.getIngredient(), 4),
                    getModItem(SuperSolarPanels.ID, "solarsplitter", 2),
                    GTOreDictUnificator
                            .get(MaterialParts.craftIngredient(OrePrefixes.plate, Materials.SiliconSolarGrade), 20))
                    .itemOutputs(ItemList.Cover_SolarPanel_LuV.get(1))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials.Polybenzimidazole,
                                    FluidShapes.fluidMolten,
                                    (int) (6 * 144)))
                    .metadata(data, new SolarFactoryRecipeData(4, 8)).duration(10 * SECONDS).eut(TierEU.RECIPE_UV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Cover_SolarPanel_LuV.get(1),
                            NHItemList.IrradiantReinforcedNaquadriaPlate.get(4),
                            ItemList.Circuit_Silicon_Wafer5.get(8),
                            ItemList.Circuit_Wafer_QPIC.get(2),
                            ItemList.Circuit_Chip_NPIC.get(4),
                            ItemList.Circuit_Wafer_SoC2.get(2),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUV, 24),
                            GTOreDictUnificator.get(Circuits.UHV.getIngredient(), 2),
                            GTOreDictUnificator.get(Circuits.UV.getIngredient(), 2))
                    .itemOutputs(ItemList.Cover_SolarPanel_ZPM.get(1))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(Materials.Kevlar, FluidShapes.fluidMolten, (int) (1 * 144)))
                    .metadata(data, new SolarFactoryRecipeData(5, 8)).duration(10 * SECONDS).eut(TierEU.RECIPE_UHV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Cover_SolarPanel_ZPM.get(1),
                            NHItemList.IrradiantReinforcedNaquadriaPlate.get(4),
                            ItemList.Circuit_Silicon_Wafer5.get(4),
                            ItemList.Circuit_Wafer_FPIC.get(12),
                            ItemList.Circuit_Chip_PPIC.get(4),
                            ItemList.Circuit_Chip_CrystalSoC2.get(2),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUHV, 36),
                            GTOreDictUnificator.get(Circuits.UEV.getIngredient(), 2),
                            GTOreDictUnificator.get(Circuits.UHV.getIngredient(), 2))
                    .itemOutputs(ItemList.Cover_SolarPanel_UV.get(1))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(Materials.Kevlar, FluidShapes.fluidMolten, (int) (2 * 144)))
                    .metadata(data, new SolarFactoryRecipeData(5, 4)).duration(10 * SECONDS).eut(TierEU.RECIPE_UEV),

            // Non-recursive / skipping recipes
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            NHItemList.IrradiantReinforcedTungstenPlate.get(4),
                            ItemList.Circuit_Silicon_Wafer2.get(4),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorEV, 8),
                            GTOreDictUnificator.get(Circuits.IV.getIngredient(), 4),
                            GTOreDictUnificator
                                    .get(MaterialParts.craftIngredient(OrePrefixes.plate, Materials.StainlessSteel), 8))
                    .itemOutputs(ItemList.Cover_SolarPanel_LV.get(1))
                    .fluidInputs(
                            MaterialLibAPI
                                    .getFluidStack(Materials.VibrantAlloy, FluidShapes.fluidMolten, (int) (4 * 144)),
                            MaterialLibAPI.getFluidStack(
                                    Materials.IndiumGalliumPhosphide,
                                    FluidShapes.fluidMolten,
                                    (int) (4 * 144)))
                    .metadata(data, new SolarFactoryRecipeData(2, 4, 2)).duration(10 * SECONDS).eut(TierEU.RECIPE_HV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            NHItemList.IrradiantReinforcedTungstenSteelPlate.get(4),
                            ItemList.Circuit_Silicon_Wafer3.get(4),
                            ItemList.Circuit_Wafer_PIC.get(4),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorIV, 8),
                            GTOreDictUnificator.get(Circuits.LuV.getIngredient(), 4),
                            GTOreDictUnificator
                                    .get(MaterialParts.craftIngredient(OrePrefixes.plate, Materials.HSSE), 8))
                    .itemOutputs(ItemList.Cover_SolarPanel_MV.get(1))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(Materials.Barium, FluidShapes.fluidMolten, (int) (2 * 144)),
                            MaterialLibAPI
                                    .getFluidStack(Materials.MeteoricSteel, FluidShapes.fluidMolten, (int) (4 * 144)))
                    .metadata(data, new SolarFactoryRecipeData(3, 4, 2)).duration(10 * SECONDS).eut(TierEU.RECIPE_EV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            NHItemList.IrradiantReinforcedChromePlate.get(4),
                            ItemList.Circuit_Silicon_Wafer3.get(8),
                            ItemList.Circuit_Wafer_HPIC.get(4),
                            GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorLuV, 8),
                            GTOreDictUnificator.get(Circuits.ZPM.getIngredient(), 4),
                            GTOreDictUnificator
                                    .get(MaterialParts.craftIngredient(OrePrefixes.plate, Materials.Naquadah), 8))
                    .itemOutputs(ItemList.Cover_SolarPanel_HV.get(1))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(Materials.Uranium, FluidShapes.fluidMolten, (int) (4 * 144)),
                            MaterialLibAPI.getFluidStack(Materials.Sunnarium, FluidShapes.fluidMolten, (int) (8 * 144)))
                    .metadata(data, new SolarFactoryRecipeData(3, 8, 2)).duration(10 * SECONDS).eut(TierEU.RECIPE_IV),

            GTValues.RA.stdBuilder().itemInputs(
                    getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 2, 8),
                    // Irradiant Reinforced Iridium Plate
                    ItemList.Circuit_Silicon_Wafer4.get(8),
                    ItemList.Circuit_Wafer_UHPIC.get(4),
                    ItemList.Circuit_Chip_NPIC.get(4),
                    GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorZPM, 20),
                    GTOreDictUnificator.get(Circuits.UV.getIngredient(), 4),
                    GTOreDictUnificator
                            .get(MaterialParts.craftIngredient(OrePrefixes.plate, Materials.NaquadahAlloy), 16))
                    .itemOutputs(ItemList.Cover_SolarPanel_EV.get(1))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(Materials.Plutonium, FluidShapes.fluidMolten, (int) (2 * 144)),
                            MaterialLibAPI
                                    .getFluidStack(Materials.Knightmetal, FluidShapes.fluidMolten, (int) (4 * 144)),
                            MaterialLibAPI.getFluidStack(Materials.Ultimet, FluidShapes.fluidMolten, (int) (8 * 144)))
                    .metadata(data, new SolarFactoryRecipeData(4, 8, 2)).duration(10 * SECONDS).eut(TierEU.RECIPE_LuV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            NHItemList.IrradiantReinforcedNaquadriaPlate.get(2),
                            ItemList.Circuit_Silicon_Wafer5.get(8),
                            ItemList.Circuit_Wafer_QPIC.get(4),
                            ItemList.Circuit_Chip_NPIC.get(8),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUV, 16),
                            GTOreDictUnificator.get(Circuits.UHV.getIngredient(), 2),
                            GTOreDictUnificator
                                    .get(MaterialParts.craftIngredient(OrePrefixes.plate, Materials.Tritanium), 8))
                    .itemOutputs(ItemList.Cover_SolarPanel_IV.get(1))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(Materials.Chrome, FluidShapes.fluidMolten, (int) (8 * 144)),
                            MaterialLibAPI
                                    .getFluidStack(Materials.NaquadahAlloy, FluidShapes.fluidMolten, (int) (4 * 144)),
                            MaterialLibAPI
                                    .getFluidStack(Materials.FierySteel, FluidShapes.fluidMolten, (int) (2 * 144)))
                    .metadata(data, new SolarFactoryRecipeData(5, 8, 2)).duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM),

            GTValues.RA.stdBuilder().itemInputs(
                    NHItemList.IrradiantReinforcedNeutroniumPlate.get(4),
                    ItemList.Circuit_Silicon_Wafer5.get(8),
                    ItemList.Circuit_Chip_UHPIC.get(4),
                    ItemList.Circuit_Chip_PPIC.get(2),
                    GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUHV, 32),
                    GTOreDictUnificator.get(Circuits.UEV.getIngredient(), 1),
                    GTOreDictUnificator.get(
                            MaterialParts.craftIngredient(OrePrefixes.plateSuperdense, Materials.SiliconSolarGrade),
                            2),
                    GTOreDictUnificator
                            .get(MaterialParts.craftIngredient(OrePrefixes.plateSuperdense, Materials.Steeleaf), 1),
                    getModItem(SuperSolarPanels.ID, "solarsplitter", 4))
                    .itemOutputs(ItemList.Cover_SolarPanel_LuV.get(1))
                    .fluidInputs(
                            new FluidStack(FluidRegistry.getFluid("molten.indalloy140"), 8 * 144),
                            MaterialLibAPI
                                    .getFluidStack(Materials.FierySteel, FluidShapes.fluidMolten, (int) (4 * 144)),
                            MaterialLibAPI
                                    .getFluidStack(Materials.Knightmetal, FluidShapes.fluidMolten, (int) (4 * 144)))
                    .metadata(data, new SolarFactoryRecipeData(5, 8, 2)).duration(10 * SECONDS).eut(TierEU.RECIPE_UV),

            GTValues.RA.stdBuilder().itemInputs(
                    NHItemList.IrradiantReinforcedNeutroniumPlate.get(6),
                    ItemList.Circuit_Silicon_Wafer5.get(8),
                    ItemList.Circuit_Chip_UHPIC.get(8),
                    ItemList.Circuit_Chip_PPIC.get(4),
                    GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUHV, 32),
                    GTOreDictUnificator.get(Circuits.UEV.getIngredient(), 4),
                    GTOreDictUnificator
                            .get(MaterialParts.craftIngredient(OrePrefixes.plateSuperdense, Materials.Samarium), 1),
                    GTOreDictUnificator
                            .get(MaterialParts.craftIngredient(OrePrefixes.plateSuperdense, Materials.Steeleaf), 1))
                    .itemOutputs(ItemList.Cover_SolarPanel_ZPM.get(1))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(Materials.Infinity, FluidShapes.fluidMolten, (int) (2 * 144)),
                            MaterialLibAPI.getFluidStack(Materials.Kevlar, FluidShapes.fluidMolten, (int) (4 * 144)))
                    .metadata(data, new SolarFactoryRecipeData(5, 8, 3)).duration(10 * SECONDS).eut(TierEU.RECIPE_UHV),

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            NHItemList.ChromaticLens.get(0),
                            getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 64, 5),
                            getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 8, 5))
                    .itemOutputs(getModItem(SuperSolarPanels.ID, "solarsplitter", 8, 0))
                    .fluidInputs(
                            MaterialLibAPI
                                    .getFluidStack(Materials.ChromaticGlass, FluidShapes.fluidMolten, (int) (2304)))
                    .metadata(data, new SolarFactoryRecipeData(0, 0, 3)).duration(20 * TICKS).eut(TierEU.RECIPE_UHV),

            GTValues.RA.stdBuilder().itemInputs(
                    NHItemList.IrradiantReinforcedNeutroniumPlate.get(8),
                    ItemList.Circuit_Silicon_Wafer5.get(8),
                    ItemList.Circuit_Wafer_FPIC.get(24),
                    ItemList.Circuit_Chip_UHPIC.get(16),
                    ItemList.Circuit_Chip_PPIC.get(8),
                    GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorUHV, 32),
                    GTOreDictUnificator.get(Circuits.UEV.getIngredient(), 8),
                    GTOreDictUnificator
                            .get(MaterialParts.craftIngredient(OrePrefixes.plateSuperdense, Materials.ElectrumFlux), 2),
                    GTOreDictUnificator
                            .get(MaterialParts.craftIngredient(OrePrefixes.plateSuperdense, Materials.Steeleaf), 1))
                    .itemOutputs(ItemList.Cover_SolarPanel_UV.get(1))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(Materials.Infinity, FluidShapes.fluidMolten, (int) (4 * 144)),
                            MaterialLibAPI.getFluidStack(Materials.Kevlar, FluidShapes.fluidMolten, (int) (8 * 144)),
                            MaterialLibAPI
                                    .getFluidStack(Materials.Knightmetal, FluidShapes.fluidMolten, (int) (2 * 144)))
                    .metadata(data, new SolarFactoryRecipeData(5, 8, 3)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_UEV) };

    public void run() {
        if (AdvancedSolarPanel.isModLoaded() && SuperSolarPanels.isModLoaded()) {
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
