package com.dreammaster.gthandler.recipes;

import static com.dreammaster.bartworksHandler.BartWorksMaterials.getBartWorksMaterialByIGNName;
import static com.dreammaster.gthandler.GT_CoreModSupport.Xenoxene;
import static gregtech.api.enums.GT_Values.W;
import static gregtech.api.enums.Mods.*;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.gthandler.GT_CoreModSupport;
import com.github.bartimaeusnek.bartworks.common.loaders.ItemRegistry;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsKevlar;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.SubTag;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import gregtech.common.items.GT_MetaGenerated_Tool_01;

public class AssemblerRecipes implements Runnable {

    // put the soldering Materials in this array
    final Materials[] solderingMaterials = new Materials[] { Materials.Lead, Materials.SolderingAlloy, Materials.Tin };

    ItemStack missing = new ItemStack(Blocks.fire);

    @Override
    public void run() {

        // New organized methods -- Most of these still need RA2 conversions done, but at least they're in more workable
        // chunks.
        makeEnderIORecipes();
        makeAE2Recipes();
        makeTinkersConstructRecipes();
        makeForestryRecipes();
        makeOpenComputersRecipes();
        makeJabbaRecipes();
        makeZTonesRecipes();
        makeGalacticraftRocketRecipes();
        makeIronTanksRecipes();
        makeChiselRecipes();
        makeLootBagRecipes();
        makeCoinRecipes();
        makeCoilRecipes();
        makePistonRecipes();
        makeAirFilterRecipes();
        makeMixedMetalIngotRecipes();
        makeReinforcedIronPlateRecipes();
        makeNEIPlanetRecipes();
        makeSolderingAlloyRecipes();
        makeElectricMachinePartRecipes();
        makeCircuitPartRecipes();

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockAlloyGlass", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 4L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.Empty180SpCell.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.Empty180SpCell.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(CustomItemList.Empty360SpCell.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.Empty180SpCell.get(3L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 6L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(CustomItemList.Empty540SpCell.get(1L)).duration(15 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.Empty180SpCell.get(1L),
                        CustomItemList.Empty360SpCell.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 7L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.Empty540SpCell.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.Empty540SpCell.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 6L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.ElectrumFlux, 1L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(CustomItemList.Empty1080SpCell.get(1L)).duration(10 * SECONDS).eut(1024)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Polybenzimidazole, 1L),
                        GT_ModHandler.getIC2Item("carbonMesh", 1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(ItemList.Duct_Tape.get(2L)).fluidInputs(Materials.AdvancedGlue.getFluid(200))
                .duration(6 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(ItemList.Hull_LV.get(1), ItemList.Duct_Tape.get(2), GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Hatch_Maintenance.get(1)).fluidInputs(Materials.AdvancedGlue.getFluid(200))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        // 10,30 and 60K NAK Cells

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 4L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.TenKCell.get(1L)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.TenKCell.get(3L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 6L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.ThirtyKCell.get(1L)).duration(15 * SECONDS).eut(60).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemCellEmpty", 3L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 6L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.ThirtyKCell.get(1L)).duration(15 * SECONDS).eut(60).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.ThirtyKCell.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 8L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.SixtyKCell.get(1L)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemCellEmpty", 6L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 8L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.SixtyKCell.get(1L)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorLuV, 64L),
                        CustomItemList.MicaInsulatorFoil.get(48L))
                .itemOutputs(ItemList.Casing_Coil_Superconductor.get(1L))
                .fluidInputs(Materials.Trinium.getMolten(1440L)).duration(50 * SECONDS).eut(9001)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorZPM, 32L),
                        CustomItemList.MicaInsulatorFoil.get(32L))
                .itemOutputs(ItemList.Casing_Coil_Superconductor.get(1L)).fluidInputs(Materials.Trinium.getMolten(576L))
                .duration(50 * SECONDS).eut(9001).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUV, 16L),
                        CustomItemList.MicaInsulatorFoil.get(16L))
                .itemOutputs(ItemList.Casing_Coil_Superconductor.get(1L)).fluidInputs(Materials.Trinium.getMolten(288L))
                .duration(50 * SECONDS).eut(9001).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUHV, 8L),
                        CustomItemList.MicaInsulatorFoil.get(8L))
                .itemOutputs(ItemList.Casing_Coil_Superconductor.get(1L)).fluidInputs(Materials.Trinium.getMolten(144L))
                .duration(50 * SECONDS).eut(9001).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUEV, 4L),
                        CustomItemList.MicaInsulatorFoil.get(4L))
                .itemOutputs(ItemList.Casing_Coil_Superconductor.get(1L)).fluidInputs(Materials.Trinium.getMolten(72L))
                .duration(50 * SECONDS).eut(9001).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUIV, 2L),
                        CustomItemList.MicaInsulatorFoil.get(2L))
                .itemOutputs(ItemList.Casing_Coil_Superconductor.get(1L)).fluidInputs(Materials.Trinium.getMolten(36L))
                .duration(50 * SECONDS).eut(9001).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUMV, 1L),
                        CustomItemList.MicaInsulatorFoil.get(1L))
                .itemOutputs(ItemList.Casing_Coil_Superconductor.get(1L)).fluidInputs(Materials.Trinium.getMolten(18L))
                .duration(50 * SECONDS).eut(9001).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 3L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(CustomItemList.SteelBars.get(4L)).duration(20 * SECONDS).eut(48).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 3L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(CustomItemList.AluminiumBars.get(4L)).duration(20 * SECONDS).eut(64)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 3L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(CustomItemList.StainlessSteelBars.get(4L)).duration(20 * SECONDS).eut(96)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 3L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(CustomItemList.TitaniumBars.get(4L)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Tungsten, 3L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(CustomItemList.TungstenBars.get(4L)).duration(20 * SECONDS).eut(192)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 3L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(CustomItemList.TungstenSteelBars.get(4L)).duration(20 * SECONDS).eut(256)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Chrome, 3L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(CustomItemList.ChromeBars.get(4L)).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iridium, 3L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(CustomItemList.IridiumBars.get(4L)).duration(20 * SECONDS).eut(1024)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Osmium, 3L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(CustomItemList.OsmiumBars.get(4L)).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Neutronium, 3L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(CustomItemList.NeutroniumBars.get(4L)).duration(20 * SECONDS).eut(4096)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.RedstoneAlloy, 3L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(CustomItemList.RedstoneAlloyBars.get(4L)).duration(20 * SECONDS).eut(48)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.ElectricalSteel, 3L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(CustomItemList.ElectricalSteelBars.get(4L)).duration(20 * SECONDS).eut(64)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.ConductiveIron, 3L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(CustomItemList.ConductiveIronBars.get(4L)).duration(20 * SECONDS).eut(160)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.EnergeticAlloy, 3L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(CustomItemList.EnergeticAlloyBars.get(4L)).duration(20 * SECONDS).eut(384)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.VibrantAlloy, 3L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(CustomItemList.VibrantAlloyBars.get(4L)).duration(20 * SECONDS).eut(768)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.PulsatingIron, 3L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(CustomItemList.PulsatingIronBars.get(4L)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Soularium, 3L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(CustomItemList.SoulariumBars.get(4L)).duration(20 * SECONDS).eut(64)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.EnderiumBase, 3L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(CustomItemList.EnderiumBaseBars.get(4L)).duration(20 * SECONDS).eut(256)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Enderium, 3L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(CustomItemList.EnderiumBars.get(4L)).duration(20 * SECONDS).eut(1024)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(GT_ModHandler.getIC2Item("carbonPlate", 4L), CustomItemList.MoldBoots.get(0L))
                .itemOutputs(CustomItemList.CarbonPartBoots.get(1L)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(GT_ModHandler.getIC2Item("carbonPlate", 8L), CustomItemList.MoldChestplate.get(0L))
                .itemOutputs(CustomItemList.CarbonPartChestplate.get(1L)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(GT_ModHandler.getIC2Item("carbonPlate", 5L), CustomItemList.MoldHelmet.get(0L))
                .itemOutputs(CustomItemList.CarbonPartHelmet.get(1L)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(GT_ModHandler.getIC2Item("carbonPlate", 7L), CustomItemList.MoldLeggings.get(0L))
                .itemOutputs(CustomItemList.CarbonPartLeggings.get(1L)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemArmorRubBoots", 1L, 0),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemArmorNanoBoots", 1L, W))
                .itemOutputs(CustomItemList.NanoRubberBoots.get(1L)).duration(40 * SECONDS).eut(1024)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemArmorNanoLegs", 1L, W),
                        GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.StainlessSteel, 4L))
                .itemOutputs(CustomItemList.NanoPlatedLeggings.get(1L)).duration(40 * SECONDS).eut(1024)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemArmorNanoHelmet", 1L, W),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemArmorHazmatHelmet", 1L, 0))
                .itemOutputs(CustomItemList.NanoScubaHelmet.get(1L)).duration(40 * SECONDS).eut(1024)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.NanoRubberBoots.get(1L), CustomItemList.IridiumAlloyItemCasing.get(4L))
                .itemOutputs(CustomItemList.QuantumPartBoots.get(1L)).duration(60 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(GraviSuite.ID, "advNanoChestPlate", 1L, W),
                        CustomItemList.IridiumAlloyItemCasing.get(8L))
                .itemOutputs(CustomItemList.QuantumPartChestplate.get(1L)).duration(60 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.NanoScubaHelmet.get(1L), CustomItemList.IridiumAlloyItemCasing.get(5L))
                .itemOutputs(CustomItemList.QuantumPartHelmetEmpty.get(1L)).duration(60 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.QuantumPartHelmetEmpty.get(1L), CustomItemList.ReinforcedGlassLense.get(8L))
                .itemOutputs(CustomItemList.QuantumPartHelmet.get(1L)).duration(60 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.NanoPlatedLeggings.get(1L), CustomItemList.IridiumAlloyItemCasing.get(7L))
                .itemOutputs(CustomItemList.QuantumPartLeggings.get(1L)).duration(60 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.NagaScaleChip.get(4L), GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(CustomItemList.NagaScaleFragment.get(1L)).fluidInputs(Materials.Thaumium.getMolten(72L))
                .duration(10 * SECONDS).eut(48).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.NagaScaleFragment.get(6L), GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(GT_ModHandler.getModItem(TwilightForest.ID, "item.nagaScale", 1L, 0))
                .fluidInputs(Materials.Thaumium.getMolten(216L)).duration(10 * SECONDS).eut(96).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.LichBoneChip.get(4L), GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(CustomItemList.LichBoneFragment.get(1L)).fluidInputs(Materials.Thaumium.getMolten(72L))
                .duration(12 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.LichBoneFragment.get(6L), GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(CustomItemList.LichBone.get(1L)).fluidInputs(Materials.Thaumium.getMolten(216L))
                .duration(12 * SECONDS + 10 * TICKS).eut(256).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Thaumcraft.ID, "ItemResource", 4L, 14),
                        GT_ModHandler.getModItem(TwilightForest.ID, "item.trophy", 0L, 2))
                .itemOutputs(CustomItemList.LichBone.get(1L)).duration(45 * SECONDS).eut(256).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CarminiteChip.get(4L), GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(CustomItemList.CarminiteFragment.get(1L)).fluidInputs(Materials.Thaumium.getMolten(72L))
                .duration(17 * SECONDS + 10 * TICKS).eut(1024).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.CarminiteFragment.get(6L), GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(GT_ModHandler.getModItem(TwilightForest.ID, "item.carminite", 1L, 0))
                .fluidInputs(Materials.Thaumium.getMolten(216L)).duration(17 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.SnowQueenBloodDrop.get(24L), GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(CustomItemList.SnowQueenBlood.get(1L)).fluidInputs(Materials.Thaumium.getMolten(216L))
                .duration(20 * SECONDS).eut(4096).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Thaumcraft.ID, "ItemResource", 10L, 14),
                        GT_ModHandler.getModItem(TwilightForest.ID, "item.trophy", 0L, 4))
                .itemOutputs(CustomItemList.SnowQueenBlood.get(1L)).duration(1 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Thaumcraft.ID, "ItemResource", 16L, 14),
                        GT_ModHandler.getModItem(Witchery.ID, "ingredient", 1L, 130))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.gem, Materials.NetherStar, 1)).duration(45 * SECONDS)
                .eut(256).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.slab, Materials.Wood, 3L))
                .itemOutputs(CustomItemList.WoodenCasing.get(1L)).fluidInputs(Materials.Iron.getMolten(32L))
                .duration(5 * SECONDS).eut(8).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.EngineCore.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L),
                        GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(GT_ModHandler.getModItem(Forestry.ID, "engine", 1L, 0)).duration(10 * SECONDS).eut(16)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.EngineCore.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 10L),
                        GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(GT_ModHandler.getModItem(Forestry.ID, "engine", 1L, 1)).duration(10 * SECONDS).eut(16)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.EngineCore.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 10L),
                        GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(GT_ModHandler.getModItem(Forestry.ID, "engine", 1L, 2)).duration(10 * SECONDS).eut(16)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.EngineCore.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Invar, 10L),
                        GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(GT_ModHandler.getModItem(BuildCraftCore.ID, "engineBlock", 1L, 2)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.EngineCore.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.WroughtIron, 10L),
                        GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(GT_ModHandler.getModItem(Forestry.ID, "engine", 1L, 4)).duration(10 * SECONDS).eut(16)
                .addTo(assemblerRecipes);

        // HEE Ectoplasma and Arcane Shards

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.EctoplasmaChip.get(4L), GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(CustomItemList.EctoplasmaFragment.get(1L))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 100)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.EctoplasmaFragment.get(6L), GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "endoplasm", 1L, 0))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 200)).duration(10 * SECONDS).eut(240)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.ArcaneShardChip.get(4L), GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(CustomItemList.ArcaneShardFragment.get(1L))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 100)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.ArcaneShardFragment.get(6L), GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 1L, 0))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 200)).duration(10 * SECONDS).eut(240)
                .addTo(assemblerRecipes);
        // HEE Runes

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.RuneOfPowerFragment.get(9L), GT_Utility.getIntegratedCircuit(9))
                .itemOutputs(GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "rune", 1L, 0))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 1000)).duration(2 * MINUTES).eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.RuneOfAgilityFragment.get(9L), GT_Utility.getIntegratedCircuit(9))
                .itemOutputs(GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "rune", 1L, 1))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 1000)).duration(2 * MINUTES).eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.RuneOfVigorFragment.get(9L), GT_Utility.getIntegratedCircuit(9))
                .itemOutputs(GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "rune", 1L, 2))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 1000)).duration(2 * MINUTES).eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.RuneOfDefenseFragment.get(9L), GT_Utility.getIntegratedCircuit(9))
                .itemOutputs(GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "rune", 1L, 3))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 1000)).duration(2 * MINUTES).eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.RuneOfMagicFragment.get(9L), GT_Utility.getIntegratedCircuit(9))
                .itemOutputs(GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "rune", 1L, 4))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 1000)).duration(2 * MINUTES).eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.RuneOfVoidFragment.get(9L), GT_Utility.getIntegratedCircuit(9))
                .itemOutputs(GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "rune", 1L, 5))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 1000)).duration(2 * MINUTES).eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);

        // IC2 Charging Batteries
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 4L, W),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatChargeRE", 1L, 0))
                .fluidInputs(Materials.SolderingAlloy.getMolten(144L)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemAdvBat", 1L, W),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemAdvBat", 1L, W),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemAdvBat", 1L, W),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemAdvBat", 1L, W),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitchSpread", 1L, 1),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1L, 1),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Copper, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatChargeAdv", 1L, 0))
                .fluidInputs(Materials.SolderingAlloy.getMolten(288L)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1L, W),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1L, W),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1L, W),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1L, W),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitchSpread", 1L, 1),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitchSpread", 1L, 1),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt04, Materials.Gold, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatChargeCrystal", 1L, 0))
                .fluidInputs(Materials.SolderingAlloy.getMolten(576L)).duration(40 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1L, W),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1L, W),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1L, W),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1L, W),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1L, 1),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1L, 1),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt08, Materials.Aluminium, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatChargeLamaCrystal", 1L, 0))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1440L)).duration(60 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Steel, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 4L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.AdsorptionFilterCasing.get(1L)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_MV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 4L),
                        ItemList.Electric_Motor_MV.get(4L),
                        ItemList.Electric_Pump_MV.get(4L),
                        GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Cobalt, 4L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(ItemList.OilDrill1.get(1L)).fluidInputs(Materials.SolderingAlloy.getMolten(144))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.OilDrill1.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4L),
                        ItemList.Electric_Motor_HV.get(4L),
                        ItemList.Electric_Pump_HV.get(4L),
                        GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.BlueSteel, 8L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(ItemList.OilDrill2.get(1L)).fluidInputs(Materials.SolderingAlloy.getMolten(288))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.OilDrill2.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 12L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4L),
                        ItemList.Electric_Motor_EV.get(4L),
                        ItemList.Electric_Pump_EV.get(4L),
                        GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Titanium, 12L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(ItemList.OilDrill3.get(1L)).fluidInputs(Materials.SolderingAlloy.getMolten(576))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.OilDrill3.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4L),
                        ItemList.Electric_Motor_IV.get(4L),
                        ItemList.Electric_Pump_IV.get(4L),
                        GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.TungstenSteel, 16L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(ItemList.OilDrill4.get(1L)).fluidInputs(Materials.SolderingAlloy.getMolten(1440))
                .duration(20 * SECONDS).eut(7860).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_EV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4L),
                        ItemList.Electric_Motor_EV.get(4L),
                        ItemList.Electric_Pump_EV.get(4L),
                        ItemList.Conveyor_Module_EV.get(4L),
                        GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Tungsten, 4L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(ItemList.OreDrill1.get(1L)).fluidInputs(Materials.SolderingAlloy.getMolten(72))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.OreDrill1.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4L),
                        ItemList.Electric_Motor_IV.get(4L),
                        ItemList.Electric_Pump_IV.get(4L),
                        ItemList.Conveyor_Module_IV.get(4L),
                        GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Iridium, 4L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(ItemList.OreDrill2.get(1L)).fluidInputs(Materials.SolderingAlloy.getMolten(144))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.OreDrill2.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Osmiridium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4L),
                        ItemList.Electric_Motor_LuV.get(4L),
                        ItemList.Electric_Pump_LuV.get(4L),
                        ItemList.Conveyor_Module_LuV.get(4L),
                        GT_OreDictUnificator.get(
                                OrePrefixes.gearGt,
                                BartWorks.isModLoaded() ? getBartWorksMaterialByIGNName("Rhodium-Plated Palladium")
                                        : Materials.Chrome,
                                4L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(ItemList.OreDrill3.get(1L)).fluidInputs(Materials.SolderingAlloy.getMolten(288))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.OreDrill3.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Europium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 4L),
                        ItemList.Electric_Motor_ZPM.get(4L),
                        ItemList.Electric_Pump_ZPM.get(4L),
                        ItemList.Conveyor_Module_ZPM.get(4L),
                        GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.MysteriousCrystal, 4L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(ItemList.OreDrill4.get(1L)).fluidInputs(Materials.SolderingAlloy.getMolten(576))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);

        // LV Turbines

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.turbineBlade, Materials.Iron, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Steel, 1L))
                .itemOutputs(
                        GT_MetaGenerated_Tool_01.INSTANCE
                                .getToolWithStats(170, 1, Materials.Iron, Materials.Steel, null))
                .duration(16 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.turbineBlade, Materials.WroughtIron, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Steel, 1L))
                .itemOutputs(
                        GT_MetaGenerated_Tool_01.INSTANCE
                                .getToolWithStats(170, 1, Materials.WroughtIron, Materials.Steel, null))
                .duration(16 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.turbineBlade, Materials.Bronze, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Steel, 1L))
                .itemOutputs(
                        GT_MetaGenerated_Tool_01.INSTANCE
                                .getToolWithStats(170, 1, Materials.Bronze, Materials.Steel, null))
                .duration(16 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.turbineBlade, Materials.Steel, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Steel, 1L))
                .itemOutputs(
                        GT_MetaGenerated_Tool_01.INSTANCE
                                .getToolWithStats(170, 1, Materials.Steel, Materials.Steel, null))
                .duration(16 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.LedoxCompressedPlate.get(1L),
                        CustomItemList.CallistoIceCompressedPlate.get(1L))
                .itemOutputs(CustomItemList.IceCompressedPlate.get(2L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        // UEV-UXV casings+hulls

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(CustomItemList.BedrockiumPlate.get(8L)),
                        GT_Utility.getIntegratedCircuit(8))
                .itemOutputs(CustomItemList.Casing_UEV.get(1L)).duration(2 * SECONDS + 10 * TICKS).eut(16)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 8L),
                        GT_Utility.getIntegratedCircuit(8))
                .itemOutputs(CustomItemList.Casing_UIV.get(1L)).duration(2 * SECONDS + 10 * TICKS).eut(16)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, MaterialsUEVplus.SpaceTime, 8L),
                        GT_Utility.getIntegratedCircuit(8))
                .itemOutputs(CustomItemList.Casing_UMV.get(1L)).duration(2 * SECONDS + 10 * TICKS).eut(16)
                .addTo(assemblerRecipes);

        if (GoodGenerator.isModLoaded()) {
            GT_Values.RA.stdBuilder().itemInputs(
                    GT_OreDictUnificator
                            .get(OrePrefixes.plate, MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter, 4L),
                    GT_OreDictUnificator.get("plateShirabon", 4),
                    GT_Utility.getIntegratedCircuit(8)).itemOutputs(CustomItemList.Casing_UXV.get(1L))
                    .duration(2 * SECONDS + 10 * TICKS).eut(16).addTo(assemblerRecipes);

        }

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.cableGt08, Materials.Draconium, 2L),
                        CustomItemList.Casing_UEV.get(1L))
                .itemOutputs(CustomItemList.Hull_UEV.get(1L)).fluidInputs(Materials.Polybenzimidazole.getMolten(576L))
                .duration(2 * SECONDS + 10 * TICKS).eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.cableGt08, Materials.NetherStar, 2L),
                        CustomItemList.Casing_UIV.get(1L))
                .itemOutputs(CustomItemList.Hull_UIV.get(1L)).fluidInputs(Materials.Polybenzimidazole.getMolten(576L))
                .duration(2 * SECONDS + 10 * TICKS).eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt12, Materials.Quantium, 2L),
                        CustomItemList.Casing_UMV.get(1L))
                .itemOutputs(CustomItemList.Hull_UMV.get(1L)).fluidInputs(Materials.Polybenzimidazole.getMolten(576L))
                .duration(2 * SECONDS + 10 * TICKS).eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.BlackPlutonium, 2L),
                        CustomItemList.Casing_UXV.get(1L))
                .itemOutputs(CustomItemList.Hull_UXV.get(1L)).fluidInputs(MaterialsKevlar.Kevlar.getMolten(576L))
                .duration(2 * SECONDS + 10 * TICKS).eut(16).addTo(assemblerRecipes);

        // Hermetic casings

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Plastic, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 8L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(ItemList.Casing_Tank_1.get(1L)).duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.PolyvinylChloride, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 8L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(ItemList.Casing_Tank_2.get(1L)).duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Polytetrafluoroethylene, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 8L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(ItemList.Casing_Tank_3.get(1L)).duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.StainlessSteel, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 8L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(ItemList.Casing_Tank_4.get(1L)).duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Titanium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 8L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(ItemList.Casing_Tank_5.get(1L)).duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.TungstenSteel, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 8L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(ItemList.Casing_Tank_6.get(1L)).duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.NiobiumTitanium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 8L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(ItemList.Casing_Tank_7.get(1L)).duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Enderium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmium, 8L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(ItemList.Casing_Tank_8.get(1L)).duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Naquadah, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 8L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(ItemList.Casing_Tank_9.get(1L)).duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.MysteriousCrystal, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bedrockium, 8L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(ItemList.Casing_Tank_10.get(1L)).duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.diamond, 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 4L))
                .itemOutputs(CustomItemList.TwilightCrystal.get(1L)).duration(30 * SECONDS).eut(16)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(IronTanks.ID, "goldDiamondUpgrade", 1L, 0))
                .fluidInputs(Materials.Glass.getMolten(72L)).duration(30 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.RawLapotronCrystal.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L))
                .itemOutputs(GT_ModHandler.getIC2Item("lapotronCrystal", 1L, 26)).duration(16 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Firebrick.get(24),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gypsum, 8L))
                .itemOutputs(ItemList.Casing_Firebricks.get(4L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("concrete"), 4608)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Firebrick.get(24),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gypsum, 8L))
                .itemOutputs(ItemList.Casing_Firebricks.get(4L)).fluidInputs(Materials.Concrete.getMolten(4608L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Blocks.brick_block), Materials.AnyBronze.getPlates(6))
                .itemOutputs(ItemList.Casing_BronzePlatedBricks.get(1L)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Steel.getPlates(4),
                        Materials.Iron.getPlates(2),
                        ItemList.Casing_BronzePlatedBricks.get(1L))
                .itemOutputs(CustomItemList.Casing_Pyrolyse.get(1L)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // Extreme Engine Intake Casing
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_RobustTungstenSteel.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.TungstenSteel, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.TungstenSteel, 4))
                .itemOutputs(ItemList.Casing_ExtremeEngineIntake.get(4)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        // Filter Machine Casing for cleanroom
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 1L),
                        ItemList.Electric_Motor_MV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Aluminium, 1L),
                        ItemList.Component_Filter.get(2L),
                        CustomItemList.SteelBars.get(2L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(ItemList.Casing_Vent.get(1L)).duration(30 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Carbon, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glowstone, 1L),
                        GT_ModHandler.getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1L, 0),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.glowstoneTorch", 32L, 0))
                .duration(20 * SECONDS).eut(192).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.log, Materials.Wood, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.treeSapling, 4L),
                        new ItemStack(Items.compass, 1, 0))
                .itemOutputs(GT_ModHandler.getModItem(NaturesCompass.ID, "NaturesCompass", 1L, 0))
                .fluidInputs(Materials.Glue.getFluid(144L)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Items.string, 3, 0), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(new ItemStack(Blocks.wool, 1, 0)).duration(5 * SECONDS).eut(4).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.CarbonPartHelmet.get(1L),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemNightvisionGoggles", 1L, W),
                        CustomItemList.NanoCrystal.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.EnergeticAlloy, 64L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemArmorNanoHelmet", 1))
                .fluidInputs(Materials.RedstoneAlloy.getMolten(288L)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.CarbonPartChestplate.get(1L),
                        CustomItemList.NanoCrystal.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.EnergeticAlloy, 64L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemArmorNanoChestplate", 1))
                .fluidInputs(Materials.RedstoneAlloy.getMolten(1440L)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.CarbonPartLeggings.get(1L),
                        CustomItemList.NanoCrystal.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.EnergeticAlloy, 64L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemArmorNanoLegs", 1))
                .fluidInputs(Materials.RedstoneAlloy.getMolten(576L)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.CarbonPartBoots.get(1L),
                        CustomItemList.NanoCrystal.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.EnergeticAlloy, 64L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemArmorNanoBoots", 1))
                .fluidInputs(Materials.RedstoneAlloy.getMolten(288L)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_LV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L),
                        GT_ModHandler.getModItem(IronChests.ID, "BlockIronChest", 1L, 0))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockPersonal", 1L, 0))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Covers

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Aluminium.getPlates(4),
                        Materials.Glass.getPlates(1),
                        Materials.Glowstone.getDust(1),
                        new ItemStack(Items.dye, 1, 1),
                        new ItemStack(Items.dye, 1, 10),
                        new ItemStack(Items.dye, 1, 4))
                .itemOutputs(ItemList.Cover_Screen.get(1L)).duration(5 * SECONDS).eut(5).addTo(assemblerRecipes);
        // Nukes

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(21),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lead, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Titanium, 2L),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartAlloy", 2L),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockMachine", 1L, 12))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockReactorChamber", 1L))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(22),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lead, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Titanium, 2L),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockReactorChamber", 3L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt08, Materials.Platinum, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1L))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockGenerator", 1L, 5))
                .duration(60 * SECONDS).eut(960).addTo(assemblerRecipes);

        if (AdvancedSolarPanel.isModLoaded()) {
            // Irradiant Glass Pane
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 4L, 2),
                            GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockAlloyGlass", 4L, 0),
                            Materials.Glowstone.getPlates(1),
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 4L, 5))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

            // Irradiant Uranium
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            Materials.Uranium.getIngots(1),
                            GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 0))
                    .itemOutputs(GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 2))
                    .duration(30 * SECONDS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        }
        // Solar Light Splitter
        if (SuperSolarPanels.isModLoaded()) {

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(SuperSolarPanels.ID, "bluecomponent", 3L, 0),
                            GT_ModHandler.getModItem(SuperSolarPanels.ID, "redcomponent", 3L, 0),
                            GT_ModHandler.getModItem(SuperSolarPanels.ID, "greencomponent", 3L, 0),
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(GT_ModHandler.getModItem(SuperSolarPanels.ID, "solarsplitter", 1L, 0))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        }
        // Heat Exchangers

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(21),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silver, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1L, 1))
                .duration(3 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(21),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silver, 2L),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1L, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitchCore", 1L, 1))
                .duration(3 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(21),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 2L),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1L, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitchSpread", 1L, 1))
                .fluidInputs(Materials.StainlessSteel.getMolten(72)).duration(1 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(21),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1L, 1),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1L, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1L, 1))
                .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Heat Vents

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(21),
                        ItemList.Electric_Motor_LV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2L),
                        new ItemStack(Blocks.iron_bars, 2))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorVent", 1L, 1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(22),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silver, 2L),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorVent", 1L, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorVentCore", 1L, 1))
                .duration(15 * SECONDS).eut(256).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(21),
                        ItemList.IC2_Industrial_Diamond.get(1L),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorVent", 1L, 1),
                        CustomItemList.StainlessSteelBars.get(4L))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1L, 1))
                .duration(15 * SECONDS).eut(256).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(22),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 2L),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1L, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorVentGold", 1L, 1))
                .fluidInputs(Materials.StainlessSteel.getMolten(72)).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(21),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Tin, 2L),
                        CustomItemList.SteelBars.get(2L),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorVent", 1L, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorVentSpread", 1L))
                .duration(15 * SECONDS).eut(256).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(21),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 4L),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitchCore", 2L, 1),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorVentCore", 1L, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorCondensator", 1L, 1))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(21),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lapis, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.RedAlloy, 2L),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorVentGold", 1L, 1),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitchSpread", 1L, 1),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorCondensator", 1L, 1),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorCondensator", 1L, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorCondensatorLap", 1L, 1))
                .duration(45 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Easier chest upgrades

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.chest, Materials.Copper, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.chest, Materials.Iron, 1L)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.chest, Materials.Copper, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 1L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.chest, Materials.Steel, 1L)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.chest, Materials.Iron, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.chest, Materials.Gold, 1L)).duration(25 * SECONDS)
                .eut(64).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.chest, Materials.Steel, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.chest, Materials.Gold, 1L)).duration(25 * SECONDS)
                .eut(64).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.chest, Materials.Gold, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 2L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.chest, Materials.Diamond, 1L)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Reactor Plating

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(22),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lead, 1L),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4L))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorPlating", 1L)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(21),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Copper, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silver, 1L),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorPlating", 1L))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorPlatingHeat", 1L))
                .duration(30 * SECONDS).eut(256).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(23),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lead, 2L),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartAlloy", 2L),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorPlating", 1L))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorPlatingExplosive", 1L))
                .duration(30 * SECONDS).eut(256).addTo(assemblerRecipes);
        // LV and MV Energy Hatches

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(4),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2),
                        ItemList.Electric_Pump_LV.get(1),
                        ItemList.Hull_LV.get(1),
                        ItemList.LV_Coil.get(2),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1))
                .itemOutputs(ItemList.Hatch_Energy_LV.get(1)).fluidInputs(Materials.Lubricant.getFluid(2000))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(4),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1),
                        ItemList.Electric_Pump_MV.get(1),
                        ItemList.Hull_MV.get(1),
                        ItemList.MV_Coil.get(2),
                        ItemList.Circuit_Chip_ULPIC.get(2))
                .itemOutputs(ItemList.Hatch_Energy_MV.get(1)).fluidInputs(Materials.Lubricant.getFluid(2000))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        // Neutron reflector recipes

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 16L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflector", 1L, 1))
                .requiresCleanRoom().duration(60 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Beryllium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 8L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflector", 1L, 1))
                .requiresCleanRoom().duration(45 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TungstenCarbide, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 4L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflector", 1L, 1))
                .requiresCleanRoom().duration(20 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Beryllium, 2L),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflector", 1L, 1),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflector", 1L, 1),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflector", 1L, 1),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflector", 1L, 1),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflectorThick", 1L, 0))
                .requiresCleanRoom().duration(30 * SECONDS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TungstenCarbide, 2L),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflector", 1L, 1),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflector", 1L, 1),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflector", 1L, 1),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflector", 1L, 1),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflectorThick", 1L, 0))
                .requiresCleanRoom().duration(30 * SECONDS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Iridium, 2L),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflectorThick", 1L, 0),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflectorThick", 1L, 0),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflectorThick", 1L, 0),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflectorThick", 1L, 0),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflectorThick", 1L, 0),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflectorThick", 1L, 0),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(ItemList.Neutron_Reflector.get(1L)).requiresCleanRoom().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Iridium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TungstenCarbide, 36L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 32L),
                        GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 48L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 32L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(ItemList.Neutron_Reflector.get(1L)).requiresCleanRoom()
                .duration(2 * MINUTES + 37 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Iridium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Beryllium, 36L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 32L),
                        GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 48L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 64L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(ItemList.Neutron_Reflector.get(1L)).requiresCleanRoom()
                .duration(3 * MINUTES + 7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);

        if (BartWorks.isModLoaded()) {
            // Humongous input hatch
            GT_Values.RA.stdBuilder().itemInputs(CustomItemList.Hatch_Input_UXV.get(1), ItemList.Quantum_Tank_IV.get(1))
                    .itemOutputs(ItemRegistry.humongousInputHatch.copy())
                    .fluidInputs(MaterialsUEVplus.Space.getMolten(5_760L)).duration(5 * SECONDS).eut(TierEU.RECIPE_UMV)
                    .addTo(assemblerRecipes);

        }

        // Wood Plates
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 64),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 64))
                .fluidInputs(Materials.Glue.getFluid(144L)).duration(2 * MINUTES).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        if (OpenBlocks.isModLoaded() && BloodMagic.isModLoaded()) {
            ItemStack[] trophies = { GT_ModHandler.getModItem(OpenBlocks.ID, "trophy", 1L),
                    GT_ModHandler.getModItem(OpenBlocks.ID, "trophy", 1L),
                    GT_ModHandler.getModItem(OpenBlocks.ID, "trophy", 1L),
                    GT_ModHandler.getModItem(OpenBlocks.ID, "trophy", 1L), };

            NBTTagCompound[] tag = { new NBTTagCompound(), new NBTTagCompound(), new NBTTagCompound(),
                    new NBTTagCompound(), };

            tag[0].setString("entity", "Bat");
            tag[1].setString("entity", "Cow");
            tag[2].setString("entity", "Chicken");
            tag[3].setString("entity", "Sheep");

            ItemStack flightpotion = GT_ModHandler.getModItem(BloodMagic.ID, "alchemyFlask", 1L);
            NBTTagCompound flighttag = new NBTTagCompound();
            NBTTagList flighsubtag = new NBTTagList();
            NBTTagCompound temp;

            temp = new NBTTagCompound();
            temp.setInteger("concentration", 0);
            temp.setInteger("durationFactor", 2);
            temp.setInteger("potionID", 104);
            temp.setInteger("tickDuration", 1200);
            flighsubtag.appendTag(temp);

            flighttag.setTag("CustomFlaskEffects", flighsubtag);
            flightpotion.setTagCompound(flighttag);

            for (int i = 0; i < 4; ++i) {
                trophies[i].setTagCompound(tag[i]);
            }

            GT_Values.RA.stdBuilder().itemInputs(trophies[0], new ItemStack(Items.golden_carrot))
                    .itemOutputs(new ItemStack(Items.potionitem, 1, 8262)).duration(6 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(assemblerRecipes);

            GT_Values.RA.stdBuilder().itemInputs(trophies[1], new ItemStack(Items.iron_sword))
                    .itemOutputs(new ItemStack(Items.leather, 64)).duration(6 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(assemblerRecipes);

            GT_Values.RA.stdBuilder().itemInputs(trophies[2], new ItemStack(Items.feather)).itemOutputs(flightpotion)
                    .duration(6 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

            GT_Values.RA.stdBuilder().itemInputs(trophies[3], new ItemStack(Items.shears))
                    .itemOutputs(new ItemStack(Blocks.wool, 64)).duration(6 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(assemblerRecipes);

        }

        if (PamsHarvestCraft.isModLoaded()) {
            for (int i = 0; i < OreDictionary.getOres("cropCotton").size(); ++i) {
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                new ItemStack(Items.string, 4),
                                OreDictionary.getOres("cropCotton").get(i).splitStack(3))
                        .itemOutputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1L, 0))
                        .duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

            }
        }

        if (PamsHarvestCraft.isModLoaded() && Forestry.isModLoaded() && OpenComputers.isModLoaded()) {
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sugar, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Fuel, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.cell, Materials.SulfuricAcid, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Acetone, 1L),
                            GT_ModHandler.getModItem(PamsHarvestCraft.ID, "pepperoniItem", 1L, 0),
                            GT_OreDictUnificator.get(OrePrefixes.dye, Materials.Red, 1L),
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 18))
                    .fluidInputs(FluidRegistry.getFluidStack("mead", 1000)).duration(10 * MINUTES).eut(TierEU.RECIPE_HV)
                    .addTo(assemblerRecipes);
        }

        if (GTPlusPlus.isModLoaded()) { // GT++, remember to remove later
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.WroughtIron, 1L),
                            CustomItemList.SteelBars.get(6L),
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(GT_ModHandler.getModItem(GTPlusPlus.ID, "blockFishTrap", 1L, 0)).duration(10 * SECONDS)
                    .eut(64).addTo(assemblerRecipes);
        }

        if (ExtraBees.isModLoaded()) {
            ItemStack alveary = GT_ModHandler.getModItem(Forestry.ID, "alveary", 1L, 0);

            // Mutator
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            alveary,
                            GT_ModHandler.getModItem(Forestry.ID, "thermionicTubes", 4L, 12),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 2L),
                            GT_ModHandler.getModItem(ExtraBees.ID, "hiveFrame.soul", 1L, 0))
                    .itemOutputs(GT_ModHandler.getModItem(ExtraBees.ID, "alveary", 1L, 0))
                    .fluidInputs(Materials.Honey.getFluid(7500L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(assemblerRecipes);

            // Frame Housing
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            alveary,
                            GT_ModHandler.getModItem(Forestry.ID, "thermionicTubes", 4L, 10),
                            GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.WoodSealed, 1L),
                            GT_ModHandler.getModItem(Forestry.ID, "frameProven", 1L, 0),
                            GT_ModHandler.getModItem(Forestry.ID, "frameProven", 1L, 0),
                            GT_ModHandler.getModItem(Forestry.ID, "frameProven", 1L, 0),
                            GT_ModHandler.getModItem(Forestry.ID, "frameProven", 1L, 0))
                    .itemOutputs(GT_ModHandler.getModItem(ExtraBees.ID, "alveary", 1L, 1))
                    .fluidInputs(Materials.Honey.getFluid(7500L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(assemblerRecipes);

            // Rain Shield
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            alveary,
                            GT_ModHandler.getModItem(Forestry.ID, "thermionicTubes", 4L, 8),
                            GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockRubber", 4L),
                            new ItemStack(Blocks.brick_block, 1, 0))
                    .itemOutputs(GT_ModHandler.getModItem(ExtraBees.ID, "alveary", 1L, 2))
                    .fluidInputs(Materials.Honey.getFluid(7500L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(assemblerRecipes);

            // Alveary Lighting
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            alveary,
                            GT_ModHandler.getModItem(Forestry.ID, "thermionicTubes", 4L, 2),
                            new ItemStack(Blocks.stained_glass, 4, W),
                            new ItemStack(Blocks.redstone_lamp, 1, 0))
                    .itemOutputs(GT_ModHandler.getModItem(ExtraBees.ID, "alveary", 1L, 3))
                    .fluidInputs(Materials.Honey.getFluid(7500L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(assemblerRecipes);

            // Electrical Stimulator
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            alveary,
                            GT_ModHandler.getModItem(Forestry.ID, "thermionicTubes", 4L, 1),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Silver, 2L),
                            GT_ModHandler.getModItem(Forestry.ID, "chipsets", 2L, 2),
                            ItemList.Electric_Motor_HV.get(1L))
                    .itemOutputs(GT_ModHandler.getModItem(ExtraBees.ID, "alveary", 1L, 4))
                    .fluidInputs(Materials.Honey.getFluid(7500L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(assemblerRecipes);

            // Hatchery
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            alveary,
                            GT_ModHandler.getModItem(Forestry.ID, "thermionicTubes", 4L, 3),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Redstone, 2L),
                            ItemList.Conveyor_Module_MV.get(2L),
                            GT_ModHandler.getModItem(Forestry.ID, "apiculture", 1L, 0))
                    .itemOutputs(GT_ModHandler.getModItem(ExtraBees.ID, "alveary", 1L, 5))
                    .fluidInputs(Materials.Honey.getFluid(7500L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(assemblerRecipes);

            // Alveary Transmission
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            alveary,
                            GT_ModHandler.getModItem(Forestry.ID, "thermionicTubes", 4L, 0),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Aluminium, 3L),
                            ItemList.Hull_HV.get(1L))
                    .itemOutputs(GT_ModHandler.getModItem(ExtraBees.ID, "alveary", 1L, 6))
                    .fluidInputs(Materials.Honey.getFluid(7500L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(assemblerRecipes);

            // Alveary Unlighting
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            alveary,
                            GT_ModHandler.getModItem(Forestry.ID, "thermionicTubes", 4L, 8),
                            GT_ModHandler.getModItem(ExtraUtilities.ID, "curtains", 4L, 0),
                            new ItemStack(Blocks.wool, 1, 15))
                    .itemOutputs(GT_ModHandler.getModItem(ExtraBees.ID, "alveary", 1L, 7))
                    .fluidInputs(Materials.Honey.getFluid(7500L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(assemblerRecipes);

        }

        if (Gendustry.isModLoaded()) {
            // pollen collection kit
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(Gendustry.ID, "Labware", 1),
                            GT_ModHandler.getModItem(Minecraft.ID, "string", 1),
                            GT_ModHandler.getModItem(Minecraft.ID, "paper", 1))
                    .itemOutputs(GT_ModHandler.getModItem(Gendustry.ID, "PollenKit", 1)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        }

        if (ExtraUtilities.isModLoaded()) {

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 9L),
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 1L, 0))
                    .duration(1 * TICKS).eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Unstable, 9L),
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 2))
                    .duration(1 * TICKS).eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);

        }

        if (ExtraUtilities.isModLoaded() && IronChests.isModLoaded()) {
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(IronChests.ID, "BlockIronChest", 1L, 0),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4L),
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(GT_ModHandler.getModItem(ExtraUtilities.ID, "filing", 1L, 0))
                    .fluidInputs(Materials.Plastic.getMolten(144L)).duration(15 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(assemblerRecipes);
        }

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeQuadruple, Materials.Infinity, 1L),
                        CustomItemList.Hull_UEV.get(1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(ItemList.Hatch_Input_Multi_2x2_UEV.get(1L))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(2304L)).duration(30 * SECONDS).eut(TierEU.RECIPE_UEV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeQuadruple, MaterialsUEVplus.TranscendentMetal, 1L),
                        CustomItemList.Hull_UIV.get(1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(ItemList.Hatch_Input_Multi_2x2_UIV.get(1L))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(2304L)).duration(30 * SECONDS).eut(TierEU.RECIPE_UIV)
                .addTo(assemblerRecipes);

        // crafting input slave
        GT_Values.RA.stdBuilder()
                .itemInputs(ItemList.Hatch_CraftingInput_Bus_ME_ItemOnly.get(1L), ItemList.Sensor_UV.get(1L))
                .itemOutputs(ItemList.Hatch_CraftingInput_Bus_Slave.get(1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);

        // Gear Box Casings
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Bronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Bronze, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 4),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Casing_Gearbox_Bronze.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Steel, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Casing_Gearbox_Steel.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Titanium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Casing_Gearbox_Titanium.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        // Quantum Armor
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.QuantumPartHelmet.get(1L),
                        CustomItemList.QuantumCrystal.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 4),
                        ItemList.Energy_LapotronicOrb.get(1L),
                        ItemList.Sensor_IV.get(1L),
                        ItemList.Field_Generator_EV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 4),
                        GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(GT_ModHandler.getIC2Item("quantumHelmet", 1L, 26))
                .fluidInputs(Materials.Titanium.getMolten(1728L)).duration(1 * MINUTES + 15 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.QuantumPartChestplate.get(1L),
                        CustomItemList.QuantumCrystal.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 6),
                        ItemList.Energy_LapotronicOrb.get(1L),
                        ItemList.Field_Generator_EV.get(3L),
                        ItemList.Electric_Motor_IV.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 4),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_ModHandler.getIC2Item("quantumBodyarmor", 1L, 26))
                .fluidInputs(Materials.Titanium.getMolten(2880L)).duration(1 * MINUTES + 15 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.QuantumPartLeggings.get(1L),
                        CustomItemList.QuantumCrystal.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 6),
                        ItemList.Energy_LapotronicOrb.get(1L),
                        ItemList.Field_Generator_EV.get(2L),
                        ItemList.Electric_Motor_IV.get(4L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 4),
                        GT_Utility.getIntegratedCircuit(12))
                .itemOutputs(GT_ModHandler.getIC2Item("quantumLeggings", 1L, 26))
                .fluidInputs(Materials.Titanium.getMolten(2304L)).duration(1 * MINUTES + 15 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.QuantumPartBoots.get(1L),
                        CustomItemList.QuantumCrystal.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 4),
                        ItemList.Energy_LapotronicOrb.get(1L),
                        ItemList.Field_Generator_EV.get(1L),
                        ItemList.Electric_Piston_IV.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 4),
                        GT_Utility.getIntegratedCircuit(13))
                .itemOutputs(GT_ModHandler.getIC2Item("quantumBoots", 1L, 26))
                .fluidInputs(Materials.Titanium.getMolten(1440L)).duration(1 * MINUTES + 15 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        // EBF Controller
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getIC2Item("ironFurnace", 3L),
                        ItemList.Casing_HeatProof.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 3),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2))
                .itemOutputs(ItemList.Machine_Multi_BlastFurnace.get(1L)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // Vacuum Freezer Controller
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Pump_HV.get(3L),
                        ItemList.Casing_FrostProof.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 3),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2))
                .itemOutputs(ItemList.Machine_Multi_VacuumFreezer.get(1)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // Large Chemical Reactor
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_HV.get(1L),
                        ItemList.Hull_HV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Polytetrafluoroethylene, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(ItemList.Machine_Multi_LargeChemicalReactor.get(1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        if (GraviSuite.isModLoaded() && GalacticraftMars.isModLoaded()) {
            // Gravitational Engine
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.wireGt12, Materials.SuperconductorLuV, 2),
                            GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockMachine2", 4, 1),
                            ItemList.Transformer_LuV_IV.get(1),
                            GT_ModHandler.getModItem(GraviSuite.ID, "itemSimpleItem", 2, 2))
                    .itemOutputs(GT_ModHandler.getModItem(GraviSuite.ID, "itemSimpleItem", 1, 3)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
            // IV Transformer
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 4),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.VanadiumGallium, 1),
                            ItemList.Circuit_Chip_PIC.get(2),
                            ItemList.Hull_IV.get(1))
                    .itemOutputs(ItemList.Transformer_LuV_IV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(assemblerRecipes);
            // Tesla Coil
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.cableGt04, Materials.Gold, 1),
                            ItemList.Circuit_Nanoprocessor.get(2),
                            GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemRecipePart", 5, 0),
                            ItemList.Transformer_HV_MV.get(1))
                    .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 1))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
            // MV Transformer
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 4),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1),
                            ItemList.Hull_MV.get(1),
                            ItemList.Circuit_Parts_InductorSMD.get(2))
                    .itemOutputs(ItemList.Transformer_HV_MV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(assemblerRecipes);
            // Cooling Core With NaK
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 2, 1),
                            GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 2, 1),
                            Materials.CallistoIce.getPlates(1),
                            ItemList.Reactor_Coolant_NaK_3.get(2),
                            GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorPlatingHeat", 2, 0))
                    .itemOutputs(GT_ModHandler.getModItem(GraviSuite.ID, "itemSimpleItem", 1, 2)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
            // Cooling Core With Helium
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 2, 1),
                            GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 2, 1),
                            Materials.CallistoIce.getPlates(1),
                            ItemList.Reactor_Coolant_He_3.get(2),
                            GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorPlatingHeat", 2, 0))
                    .itemOutputs(GT_ModHandler.getModItem(GraviSuite.ID, "itemSimpleItem", 1, 2)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
            // Fluid Manipulator
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Large_Fluid_Cell_Steel.get(1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeQuadruple, Materials.Steel, 4),
                            ItemList.Electric_Motor_HV.get(4))
                    .itemOutputs(GT_ModHandler.getModItem(GalacticraftMars.ID, "item.null", 1, 6)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        }

        // Super Tank V
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.circuit.get(Materials.Elite), 4),
                        Materials.Titanium.getPlates(2),
                        ItemList.Electric_Pump_EV.get(1),
                        ItemList.Field_Generator_HV.get(1),
                        ItemList.Casing_Tank_5.get(1))
                .itemOutputs(ItemList.Super_Tank_IV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        // Super Chest V
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.circuit.get(Materials.Elite), 4),
                        GT_OreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.Titanium, 3),
                        ItemList.Field_Generator_HV.get(1),
                        ItemList.Automation_ChestBuffer_IV.get(1))
                .itemOutputs(ItemList.Super_Chest_IV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        // Chest Buffer IV
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Conveyor_Module_IV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit.get(Materials.Elite), 1),
                        ItemList.Hull_IV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.chest, Materials.Wood, 1))
                .itemOutputs(ItemList.Automation_ChestBuffer_IV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        // Quantum Tank V
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.circuit.get(Materials.Bio), 4),
                        Materials.Americium.getPlates(2),
                        ItemList.Electric_Pump_UV.get(1),
                        ItemList.Field_Generator_UV.get(1),
                        ItemList.Casing_Tank_10.get(1))
                .itemOutputs(ItemList.Quantum_Tank_IV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        // Quantum Tank IV
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.circuit.get(Materials.Infinite), 4),
                        Materials.Europium.getPlates(2),
                        ItemList.Electric_Pump_ZPM.get(1),
                        ItemList.Field_Generator_ZPM.get(1),
                        ItemList.Casing_Tank_9.get(1))
                .itemOutputs(ItemList.Quantum_Tank_EV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        // Quantum Chest V
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.circuit.get(Materials.Bio), 4),
                        Materials.Americium.getPlates(3),
                        ItemList.Field_Generator_UV.get(1),
                        CustomItemList.Automation_ChestBuffer_UEV.get(1L))
                .itemOutputs(ItemList.Quantum_Chest_IV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        // Ultra High Voltage Chest Buffer
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Conveyor_Module_UEV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit.get(Materials.Bio), 1),
                        CustomItemList.Hull_UEV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.chest, Materials.Wood, 1))
                .itemOutputs(CustomItemList.Automation_ChestBuffer_UEV.get(1L)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // UV Compressor
        GT_Values.RA.stdBuilder().itemInputs(
                ItemList.Hull_UV.get(1),
                // UV circuit, but internal naming is SuperconductorUHV?
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.SuperconductorUHV, 2),
                ItemList.Electric_Piston_UV.get(2),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.ElectrumFlux, 4))
                .itemOutputs(CustomItemList.CompressorUV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_UV)
                .addTo(assemblerRecipes);

        // UV Microwave Transmitter
        GT_Values.RA.stdBuilder().itemInputs(
                ItemList.Hull_UV.get(1),
                // UV circuit, but internal naming is SuperconductorUHV?
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.SuperconductorUHV, 2),
                ItemList.Emitter_UV.get(4),
                ItemList.Field_Generator_UV.get(1),
                ItemList.Energy_Module.get(1)).itemOutputs(ItemList.MicroTransmitter_UV.get(1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(assemblerRecipes);

        if (HardcoreEnderExpansion.isModLoaded()) {
            // Biome Compass
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            Materials.HeeEndium.getPlates(1),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HeeEndium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HeeEndium, 2),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.HeeEndium, 2),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                            GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0))
                    .itemOutputs(GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "biome_compass", 1, 0))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        }
        if (StorageDrawers.isModLoaded()) {
            // Alternate Storage Template Recipe
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Electric_Piston_LV.get(1),
                            GT_OreDictUnificator.get("drawerBasic", 1),
                            GT_Utility.getIntegratedCircuit(2))
                    .itemOutputs(GT_ModHandler.getModItem(StorageDrawers.ID, "upgradeTemplate", 3, 0))
                    .duration(60 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        }
        // Display
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Cover_Screen.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 2),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 2))
                .fluidInputs(Materials.Plastic.getMolten(144)).itemOutputs(CustomItemList.Display.get(1))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Ender-Quantum Component
        if (SuperSolarPanels.isModLoaded() && (AdvancedSolarPanel.isModLoaded())) {
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.InfinityCatalyst, 1),
                            GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 4, 3),
                            Materials.ElectrumFlux.getPlates(4))
                    .itemOutputs(GT_ModHandler.getModItem(SuperSolarPanels.ID, "enderquantumcomponent", 1, 0))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        }
        // 4A Zpm to LuV transformer
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.VanadiumGallium, 4),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Naquadah, 1),
                        ItemList.Circuit_Chip_HPIC.get(2),
                        ItemList.Hull_LuV.get(1))
                .itemOutputs(ItemList.Transformer_ZPM_LuV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);
        if (GTPlusPlus.isModLoaded()) {
            // 16A Zpm to LuV transformer
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.VanadiumGallium, 4),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Naquadah, 1),
                            ItemList.Transformer_ZPM_LuV.get(1),
                            ItemList.Casing_Coil_TungstenSteel.get(1))
                    .itemOutputs(GT_ModHandler.getModItem(GregTech.ID, "gt.blockmachines", 1, 883))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

            // 64A Zpm To LuV transformer
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.cableGt16, Materials.VanadiumGallium, 2),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt08, Materials.Naquadah, 1),
                            GT_OreDictUnificator.get(OrePrefixes.spring, Materials.Naquadah, 1),
                            GT_OreDictUnificator.get(OrePrefixes.springSmall, Materials.VanadiumGallium, 1),
                            GT_ModHandler.getModItem(GregTech.ID, "gt.blockmachines", 1, 883),
                            ItemList.Electric_Pump_LV.get(1))
                    .fluidInputs(Materials.Lubricant.getFluid(2000))
                    .itemOutputs(CustomItemList.WetTransformer_ZPM_LuV.get(1)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

            // Hastelloy-X Structural Block
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Casing_EV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 2),
                            getModItem(GTPlusPlus.ID, "itemGearHastelloyX", 1L),
                            getModItem(GTPlusPlus.ID, "blockFrameGtHastelloyC276", 1L),
                            getModItem(GTPlusPlus.ID, "itemRingInconel792", 2L))
                    .itemOutputs(getModItem(GTPlusPlus.ID, "gtplusplus.blockcasings.2", 1L, 2)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        }
        // Ultimate Time Anomaly
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_UV.get(2),
                        ItemList.Electric_Pump_UV.get(1),
                        ItemList.Conveyor_Module_UV.get(1),
                        ItemList.Robot_Arm_UV.get(2),
                        ItemList.Electric_Piston_UV.get(2),
                        ItemList.Hull_UV.get(1))
                .itemOutputs(CustomItemList.AcceleratorUV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        if (KekzTech.isModLoaded()) {
            // LSC controller
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.battery, Materials.Master, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2),
                            ItemList.Circuit_Chip_PIC.get(2))
                    .itemOutputs(GT_ModHandler.getModItem(GregTech.ID, "gt.blockmachines", 1, 13106))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        }
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeQuadruple, MaterialsUEVplus.SpaceTime, 1),
                        CustomItemList.Hull_UMV.get(1),
                        GT_Utility.getIntegratedCircuit(4))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(2304))
                .itemOutputs(ItemList.Hatch_Input_Multi_2x2_UMV.get(1)).duration(30 * SECONDS).eut(TierEU.RECIPE_UMV)
                .addTo(assemblerRecipes);
        // Spacetime quadruple is temp replacement until Universium Pipes.
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeQuadruple, MaterialsUEVplus.SpaceTime, 4),
                        CustomItemList.Hull_UXV.get(1),
                        GT_Utility.getIntegratedCircuit(4))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(2304))
                .itemOutputs(ItemList.Hatch_Input_Multi_2x2_UXV.get(1)).duration(30 * SECONDS).eut(TierEU.RECIPE_UXV)
                .addTo(assemblerRecipes);
        if (BartWorks.isModLoaded()) {
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemRegistry.humongousInputHatch.copy(),
                            GT_OreDictUnificator.get(OrePrefixes.pipeHuge, MaterialsUEVplus.SpaceTime, 4),
                            GT_Utility.getIntegratedCircuit(4))
                    .fluidInputs(MaterialsUEVplus.Space.getMolten(5760))
                    .itemOutputs(ItemList.Hatch_Input_Multi_2x2_Humongous.get(1)).duration(30 * SECONDS)
                    .eut(TierEU.RECIPE_UXV).addTo(assemblerRecipes);
        }

        // Diamond Gear
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Diamond, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 4L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Diamond, 1L))
                .fluidInputs(Materials.Lubricant.getFluid(250L)).duration(10 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        if (TecTech.isModLoaded() && GTPlusPlus.isModLoaded()) {
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.foil, Materials.CosmicNeutronium, 2),
                            (GT_ModHandler.getModItem(GTPlusPlus.ID, "itemFineWireChromaticGlass", 2)))
                    .itemOutputs(com.github.technus.tectech.thing.CustomItemList.DATApipe.get(64))
                    .fluidInputs(GT_CoreModSupport.RadoxPolymer.getMolten(144L)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_UV).addTo(assemblerRecipes);
        }
        // Fusion Coil Block
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4L),
                        ItemList.Neutron_Reflector.get(2L),
                        ItemList.Field_Generator_MV.get(2L),
                        ItemList.Casing_Coil_Superconductor.get(1L))
                .itemOutputs(ItemList.Casing_Fusion_Coil.get(1L)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
    }

    private void makeElectricMachinePartRecipes() {
        // Motors

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.IronMagnetic, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.AnyIron, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L))
                .itemOutputs(ItemList.Electric_Motor_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L))
                .itemOutputs(ItemList.Electric_Motor_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.IronMagnetic, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.AnyIron, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L))
                .itemOutputs(ItemList.Electric_Motor_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L))
                .itemOutputs(ItemList.Electric_Motor_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Cupronickel, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 2L))
                .itemOutputs(ItemList.Electric_Motor_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Cupronickel, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnnealedCopper, 2L))
                .itemOutputs(ItemList.Electric_Motor_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Silver, 2L))
                .itemOutputs(ItemList.Electric_Motor_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.NeodymiumMagnetic, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.BlackSteel, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Aluminium, 2L))
                .itemOutputs(ItemList.Electric_Motor_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.NeodymiumMagnetic, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Graphene, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Tungsten, 2L))
                .itemOutputs(ItemList.Electric_Motor_IV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Pumps

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_LV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Tin, 1),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Tin, 1),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1),
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Bronze, 1))
                .itemOutputs(ItemList.Electric_Pump_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_LV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Tin, 1),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Tin, 1),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1),
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Bronze, 1))
                .itemOutputs(ItemList.Electric_Pump_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_LV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Tin, 1),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Tin, 1),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1),
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Bronze, 1))
                .itemOutputs(ItemList.Electric_Pump_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_MV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Bronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1),
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1))
                .itemOutputs(ItemList.Electric_Pump_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_MV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Bronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1),
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1))
                .itemOutputs(ItemList.Electric_Pump_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_MV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Bronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1),
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1))
                .itemOutputs(ItemList.Electric_Pump_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_HV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Steel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1),
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1))
                .itemOutputs(ItemList.Electric_Pump_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_HV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Steel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1),
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1))
                .itemOutputs(ItemList.Electric_Pump_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_HV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Steel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1),
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1))
                .itemOutputs(ItemList.Electric_Pump_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_EV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 1))
                .itemOutputs(ItemList.Electric_Pump_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_EV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 1))
                .itemOutputs(ItemList.Electric_Pump_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_EV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 1))
                .itemOutputs(ItemList.Electric_Pump_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_IV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.TungstenSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1),
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.TungstenSteel, 1))
                .itemOutputs(ItemList.Electric_Pump_IV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_IV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.TungstenSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1),
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.TungstenSteel, 1))
                .itemOutputs(ItemList.Electric_Pump_IV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Conveyors

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_LV.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 6),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1))
                .itemOutputs(ItemList.Conveyor_Module_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_LV.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1))
                .itemOutputs(ItemList.Conveyor_Module_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_LV.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1))
                .itemOutputs(ItemList.Conveyor_Module_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_MV.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 6),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 1))
                .itemOutputs(ItemList.Conveyor_Module_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_MV.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 1))
                .itemOutputs(ItemList.Conveyor_Module_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_MV.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 1))
                .itemOutputs(ItemList.Conveyor_Module_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_HV.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 6),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1))
                .itemOutputs(ItemList.Conveyor_Module_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_HV.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1))
                .itemOutputs(ItemList.Conveyor_Module_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_HV.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1))
                .itemOutputs(ItemList.Conveyor_Module_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_EV.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1))
                .itemOutputs(ItemList.Conveyor_Module_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_EV.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1))
                .itemOutputs(ItemList.Conveyor_Module_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_EV.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 6),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1))
                .itemOutputs(ItemList.Conveyor_Module_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_IV.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1))
                .itemOutputs(ItemList.Conveyor_Module_IV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_IV.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1))
                .itemOutputs(ItemList.Conveyor_Module_IV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Pistons

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_LV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 3),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Steel, 1))
                .itemOutputs(ItemList.Electric_Piston_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_MV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 3),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 2),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Aluminium, 1))
                .itemOutputs(ItemList.Electric_Piston_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_HV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 3),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.StainlessSteel, 1))
                .itemOutputs(ItemList.Electric_Piston_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_EV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 3),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Titanium, 1))
                .itemOutputs(ItemList.Electric_Piston_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_IV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 3),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 2),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 2),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.TungstenSteel, 1))
                .itemOutputs(ItemList.Electric_Piston_IV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Robot Arms

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_LV.get(2L),
                        ItemList.Electric_Piston_LV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 3))
                .itemOutputs(ItemList.Robot_Arm_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_MV.get(2L),
                        ItemList.Electric_Piston_MV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 3))
                .itemOutputs(ItemList.Robot_Arm_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_HV.get(2L),
                        ItemList.Electric_Piston_HV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 3))
                .itemOutputs(ItemList.Robot_Arm_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_EV.get(2L),
                        ItemList.Electric_Piston_EV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 3))
                .itemOutputs(ItemList.Robot_Arm_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_IV.get(2L),
                        ItemList.Electric_Piston_IV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 2),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 3))
                .itemOutputs(ItemList.Robot_Arm_IV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Emitter

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.gem, Materials.CertusQuartz, 1),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Brass, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2))
                .itemOutputs(ItemList.Emitter_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderPearl, 1),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Electrum, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 2))
                .itemOutputs(ItemList.Emitter_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderEye, 1),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Chrome, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2))
                .itemOutputs(ItemList.Emitter_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.QuantumEye.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Platinum, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 2))
                .itemOutputs(ItemList.Emitter_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.QuantumStar.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iridium, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 2))
                .itemOutputs(ItemList.Emitter_IV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Sensor

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.gem, Materials.CertusQuartz, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Brass, 1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L))
                .itemOutputs(ItemList.Sensor_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.gemFlawless, Materials.Emerald, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Electrum, 1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L))
                .itemOutputs(ItemList.Sensor_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderEye, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Chrome, 1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L))
                .itemOutputs(ItemList.Sensor_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.QuantumEye.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Platinum, 1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1L))
                .itemOutputs(ItemList.Sensor_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.QuantumStar.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 4),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iridium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L))
                .itemOutputs(ItemList.Sensor_IV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Field Generator

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(ItemList.Field_Generator_LV.get(1)).fluidInputs(Materials.RedSteel.getMolten(288))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(ItemList.Field_Generator_MV.get(1)).fluidInputs(Materials.TungstenSteel.getMolten(288))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.QuantumEye.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(ItemList.Field_Generator_HV.get(1)).fluidInputs(Materials.NiobiumTitanium.getMolten(576))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.gem, Materials.NetherStar, 1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4),
                        GT_Utility.getIntegratedCircuit(13))
                .itemOutputs(ItemList.Field_Generator_EV.get(1)).fluidInputs(Materials.HSSG.getMolten(576))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.QuantumStar.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 4),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(ItemList.Field_Generator_IV.get(1L)).fluidInputs(Materials.HSSS.getMolten(576))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

    }

    private void makeCircuitPartRecipes() {
        // Circuits and Boards

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32),
                        GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(ItemList.Circuit_Board_Coated_Basic.get(8L))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 1152)).duration(1 * MINUTES + 20 * SECONDS).eut(8)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32),
                        GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(ItemList.Circuit_Board_Coated_Basic.get(8L)).fluidInputs(Materials.Glue.getFluid(576L))
                .duration(1 * MINUTES + 20 * SECONDS).eut(8).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32),
                        GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(ItemList.Circuit_Board_Coated_Basic.get(16L))
                .fluidInputs(Materials.Plastic.getMolten(288L)).duration(1 * MINUTES + 20 * SECONDS).eut(8)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32),
                        GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(ItemList.Circuit_Board_Coated_Basic.get(16L))
                .fluidInputs(Materials.Polytetrafluoroethylene.getMolten(144L)).duration(1 * MINUTES + 20 * SECONDS)
                .eut(8).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32),
                        GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(ItemList.Circuit_Board_Coated_Basic.get(24L)).fluidInputs(Materials.Epoxid.getMolten(144L))
                .duration(1 * MINUTES + 20 * SECONDS).eut(8).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32),
                        GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(ItemList.Circuit_Board_Coated_Basic.get(32L))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(72L)).duration(1 * MINUTES + 20 * SECONDS).eut(8)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 8),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(ItemList.Circuit_Board_Phenolic.get(8L))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 576)).duration(2 * MINUTES).eut(16)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 8),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(ItemList.Circuit_Board_Phenolic.get(8L)).fluidInputs(Materials.Glue.getFluid(288))
                .duration(2 * MINUTES).eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 8),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(ItemList.Circuit_Board_Phenolic.get(16L)).fluidInputs(Materials.BisphenolA.getFluid(144))
                .duration(2 * MINUTES).eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 8),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(ItemList.Circuit_Board_Phenolic.get(24L)).fluidInputs(Materials.Epoxid.getMolten(144L))
                .duration(2 * MINUTES).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Parts_Glass_Tube.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 4),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(ItemList.Circuit_Parts_Vacuum_Tube.get(2L)).fluidInputs(Materials.Redstone.getMolten(144L))
                .duration(8 * SECONDS).eut(8).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Parts_Glass_Tube.get(4L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 4),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(ItemList.Circuit_Parts_Vacuum_Tube.get(4L)).fluidInputs(Materials.RedAlloy.getMolten(72L))
                .duration(8 * SECONDS).eut(8).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Parts_Glass_Tube.get(4L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 4),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(ItemList.Circuit_Parts_Vacuum_Tube.get(8L))
                .fluidInputs(Materials.RedstoneAlloy.getMolten(72L)).duration(8 * SECONDS).eut(8)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Parts_Glass_Tube.get(4L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 4),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(ItemList.Circuit_Parts_Vacuum_Tube.get(8L)).fluidInputs(Materials.RedAlloy.getMolten(72L))
                .duration(8 * SECONDS).eut(8).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Parts_Glass_Tube.get(4L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 4),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(ItemList.Circuit_Parts_Vacuum_Tube.get(16L))
                .fluidInputs(Materials.RedstoneAlloy.getMolten(72L)).duration(8 * SECONDS).eut(8)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Circuit_Parts_Resistor.get(4L)).fluidInputs(Materials.Glue.getFluid(288))
                .duration(16 * SECONDS).eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Circuit_Parts_Resistor.get(4L)).fluidInputs(Materials.Glue.getFluid(288))
                .duration(16 * SECONDS).eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Circuit_Parts_Resistor.get(4L)).fluidInputs(Materials.Glue.getFluid(288))
                .duration(16 * SECONDS).eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lignite, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Circuit_Parts_Resistor.get(4L)).fluidInputs(Materials.Glue.getFluid(288))
                .duration(16 * SECONDS).eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(ItemList.Circuit_Parts_Resistor.get(4L))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 576)).duration(16 * SECONDS).eut(16)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(ItemList.Circuit_Parts_Resistor.get(4L))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 576)).duration(16 * SECONDS).eut(16)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(ItemList.Circuit_Parts_Resistor.get(4L))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 576)).duration(16 * SECONDS).eut(16)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lignite, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(ItemList.Circuit_Parts_Resistor.get(4L))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 576)).duration(16 * SECONDS).eut(16)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(ItemList.Circuit_Parts_Resistor.get(8L)).fluidInputs(Materials.Glue.getFluid(288))
                .duration(16 * SECONDS).eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(ItemList.Circuit_Parts_Resistor.get(8L)).fluidInputs(Materials.Glue.getFluid(288))
                .duration(16 * SECONDS).eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(ItemList.Circuit_Parts_Resistor.get(8L)).fluidInputs(Materials.Glue.getFluid(288))
                .duration(16 * SECONDS).eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lignite, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(ItemList.Circuit_Parts_Resistor.get(8L)).fluidInputs(Materials.Glue.getFluid(288))
                .duration(16 * SECONDS).eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(ItemList.Circuit_Parts_Resistor.get(8L))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 576)).duration(16 * SECONDS).eut(16)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(ItemList.Circuit_Parts_Resistor.get(8L))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 576)).duration(16 * SECONDS).eut(16)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(ItemList.Circuit_Parts_Resistor.get(8L))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 576)).duration(16 * SECONDS).eut(16)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lignite, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(ItemList.Circuit_Parts_Resistor.get(8L))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 576)).duration(16 * SECONDS).eut(16)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GalliumArsenide, 1),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(ItemList.Circuit_Parts_Diode.get(4L)).fluidInputs(Materials.Plastic.getMolten(144L))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GalliumArsenide, 1),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(ItemList.Circuit_Parts_Diode.get(2L)).fluidInputs(Materials.Glass.getMolten(288L))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GalliumArsenide, 1),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(ItemList.Circuit_Parts_Diode.get(2L))
                .fluidInputs(FluidRegistry.getFluidStack("glass.molten", 1000)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                        ItemList.Circuit_Silicon_Wafer.get(1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(ItemList.Circuit_Parts_Diode.get(2L)).fluidInputs(Materials.Plastic.getMolten(144L))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                        ItemList.Circuit_Silicon_Wafer.get(1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(ItemList.Circuit_Parts_Diode.get(1L))
                .fluidInputs(FluidRegistry.getFluidStack("glass.molten", 1000)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                        ItemList.Circuit_Silicon_Wafer.get(1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(ItemList.Circuit_Parts_Diode.get(1L)).fluidInputs(Materials.Glass.getMolten(288L))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                        ItemList.Circuit_Silicon_Wafer.get(1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(ItemList.Circuit_Parts_Diode.get(4L)).fluidInputs(Materials.Plastic.getMolten(144L))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tantalum, 4),
                        ItemList.Circuit_Silicon_Wafer.get(1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(ItemList.Circuit_Parts_Diode.get(8L)).fluidInputs(Materials.Plastic.getMolten(144L))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Circuit_Parts_Coil.get(2L)).fluidInputs(Materials.Plastic.getMolten(36L))
                .duration(16 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.NickelZincFerrite, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Circuit_Parts_Coil.get(4L)).fluidInputs(Materials.Plastic.getMolten(36L))
                .duration(16 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 2),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Circuit_Parts_Coil.get(4L)).fluidInputs(Materials.Plastic.getMolten(36L))
                .duration(16 * SECONDS).eut(60).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.NickelZincFerrite, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 2),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Circuit_Parts_Coil.get(8L)).fluidInputs(Materials.Plastic.getMolten(36L))
                .duration(16 * SECONDS).eut(60).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Plastic, 1),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Tantalum, 2),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Circuit_Parts_Capacitor.get(12L)).fluidInputs(Materials.Plastic.getMolten(144L))
                .duration(16 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Plastic, 1),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 2),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Circuit_Parts_Capacitor.get(8L)).fluidInputs(Materials.Plastic.getMolten(144L))
                .duration(16 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.SiliconSG, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tin, 8),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(ItemList.Circuit_Parts_Transistor.get(6L)).fluidInputs(Materials.Plastic.getMolten(144L))
                .duration(16 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // All SMD Component recipes.

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 4),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Circuit_Parts_ResistorSMD.get(16L)).fluidInputs(Materials.Plastic.getMolten(288L))
                .duration(16 * SECONDS).eut(96).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tantalum, 4),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Circuit_Parts_ResistorSMD.get(32L)).fluidInputs(Materials.Plastic.getMolten(288L))
                .duration(16 * SECONDS).eut(96).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GalliumArsenide, 1),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(ItemList.Circuit_Parts_Diode.get(6L)).fluidInputs(Materials.Plastic.getMolten(144L))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tantalum, 4),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GalliumArsenide, 1),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(ItemList.Circuit_Parts_Diode.get(16L)).fluidInputs(Materials.Plastic.getMolten(144L))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GalliumArsenide, 1),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Circuit_Parts_DiodeSMD.get(64L)).fluidInputs(Materials.Plastic.getMolten(576L))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gallium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 8),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Circuit_Parts_TransistorSMD.get(16L))
                .fluidInputs(Materials.Plastic.getMolten(288L)).duration(16 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gallium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tantalum, 8),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Circuit_Parts_TransistorSMD.get(32L))
                .fluidInputs(Materials.Plastic.getMolten(288L)).duration(16 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // Normal SMD

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicone, 2),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 2),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Circuit_Parts_CapacitorSMD.get(16L))
                .fluidInputs(Materials.Plastic.getMolten(144L)).duration(16 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.PolyvinylChloride, 4),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 2),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Circuit_Parts_CapacitorSMD.get(24L))
                .fluidInputs(Materials.Plastic.getMolten(144L)).duration(16 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicone, 2),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Tantalum, 2),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Circuit_Parts_CapacitorSMD.get(32L))
                .fluidInputs(Materials.Plastic.getMolten(144L)).duration(16 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.PolyvinylChloride, 4),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Tantalum, 2),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Circuit_Parts_CapacitorSMD.get(48L))
                .fluidInputs(Materials.Plastic.getMolten(144L)).duration(16 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Neodymium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.ConductiveIron, 8),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Circuit_Parts_InductorSMD.get(24L)).fluidInputs(Materials.Plastic.getMolten(36L))
                .duration(16 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Neodymium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 8),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Circuit_Parts_InductorSMD.get(32L)).fluidInputs(Materials.Plastic.getMolten(36L))
                .duration(16 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Neodymium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tantalum, 8),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Circuit_Parts_InductorSMD.get(48L)).fluidInputs(Materials.Plastic.getMolten(36L))
                .duration(16 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Neodymium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Iridium, 8),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Circuit_Parts_InductorSMD.get(64L)).fluidInputs(Materials.Plastic.getMolten(36L))
                .duration(16 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // ASMD

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphene, 2),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 4),
                        GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(ItemList.Circuit_Parts_ResistorASMD.get(64L))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(576L)).duration(15 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IndiumGalliumPhosphide, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 4),
                        GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(ItemList.Circuit_Parts_DiodeASMD.get(64L))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(576L)).duration(15 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.VanadiumGallium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.HSSG, 16),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 4),
                        GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(ItemList.Circuit_Parts_TransistorASMD.get(64L))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(576L)).duration(15 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Polybenzimidazole, 4),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HSSS, 2),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 4),
                        GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(ItemList.Circuit_Parts_CapacitorASMD.get(64L))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(576L)).duration(15 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Samarium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.HSSE, 32),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 4),
                        GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(ItemList.Circuit_Parts_InductorASMD.get(64L))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(576L)).duration(8 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);
        // xSMD
        // Resistor

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Naquadria, 4L),
                        GT_ModHandler.getModItem(GTPlusPlus.ID, "itemFoilPikyonium64B", 2L),
                        GT_OreDictUnificator
                                .get(OrePrefixes.foil, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 1L),
                        GT_Utility.getIntegratedCircuit(9))
                .itemOutputs(ItemList.Circuit_Parts_ResistorXSMD.get(32L)).fluidInputs(Xenoxene.getFluid(144L))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);
        // Transistor

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.BlackPlutonium, 4L),
                        GT_ModHandler.getModItem(GTPlusPlus.ID, "itemFoilArceusAlloy2B", 2L),
                        GT_OreDictUnificator
                                .get(OrePrefixes.foil, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 1L),
                        GT_Utility.getIntegratedCircuit(9))
                .itemOutputs(ItemList.Circuit_Parts_TransistorXSMD.get(32L)).fluidInputs(Xenoxene.getFluid(144L))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);
        // Capacitor

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Draconium, 4L),
                        GT_ModHandler.getModItem(GTPlusPlus.ID, "itemFoilCinobiteA243", 2L),
                        GT_OreDictUnificator
                                .get(OrePrefixes.foil, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 1L),
                        GT_Utility.getIntegratedCircuit(9))
                .itemOutputs(ItemList.Circuit_Parts_CapacitorXSMD.get(32L)).fluidInputs(Xenoxene.getFluid(144L))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);
        // Diode

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Tritanium, 4L),
                        GT_ModHandler.getModItem(GTPlusPlus.ID, "itemFoilLafiumCompound", 2L),
                        GT_OreDictUnificator
                                .get(OrePrefixes.foil, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 1L),
                        GT_Utility.getIntegratedCircuit(9))
                .itemOutputs(ItemList.Circuit_Parts_DiodeXSMD.get(64L)).fluidInputs(Xenoxene.getFluid(144L))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);
        // Inductor

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedfoil", 4L, 10105),
                        GT_ModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedfoil", 1L, 10102),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 1L),
                        GT_Utility.getIntegratedCircuit(9))
                .itemOutputs(ItemList.Circuit_Parts_InductorXSMD.get(32L)).fluidInputs(Xenoxene.getFluid(144L))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);

    }

    private void makeAirFilterRecipes() {
        // Air Filter stuff

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1L),
                        GT_Utility.getIntegratedCircuit(1),
                        CustomItemList.SteelBars.get(2))
                .itemOutputs(CustomItemList.Casing_AirFilter_Vent_T1.get(1L))
                .fluidInputs(Materials.SolderingAlloy.getMolten(72)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1L),
                        GT_Utility.getIntegratedCircuit(1),
                        CustomItemList.SteelBars.get(2))
                .itemOutputs(CustomItemList.Casing_AirFilter_Vent_T1.get(1L)).fluidInputs(Materials.Tin.getMolten(144))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1L),
                        GT_Utility.getIntegratedCircuit(1),
                        CustomItemList.SteelBars.get(2))
                .itemOutputs(CustomItemList.Casing_AirFilter_Vent_T1.get(1L)).fluidInputs(Materials.Lead.getMolten(288))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.Casing_AirFilter_Vent_T1.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Steel, 2L),
                        ItemList.Electric_Motor_LV.get(2L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.Casing_AirFilter_Turbine_T1.get(1L))
                .fluidInputs(Materials.SolderingAlloy.getMolten(72)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.Casing_AirFilter_Vent_T1.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Steel, 2L),
                        ItemList.Electric_Motor_LV.get(2L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.Casing_AirFilter_Turbine_T1.get(1L))
                .fluidInputs(Materials.Tin.getMolten(144)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.Casing_AirFilter_Vent_T1.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Steel, 2L),
                        ItemList.Electric_Motor_LV.get(2L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.Casing_AirFilter_Turbine_T1.get(1L))
                .fluidInputs(Materials.Lead.getMolten(288)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_LV.get(1L),
                        ItemList.Casing_Turbine.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Steel, 1L),
                        ItemList.Electric_Motor_LV.get(2L),
                        ItemList.Electric_Pump_LV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.Machine_Multi_AirFilterT1.get(1L))
                .fluidInputs(Materials.SolderingAlloy.getMolten(144)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_LV.get(1L),
                        ItemList.Casing_Turbine.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Steel, 1L),
                        ItemList.Electric_Motor_LV.get(2L),
                        ItemList.Electric_Pump_LV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.Machine_Multi_AirFilterT1.get(1L)).fluidInputs(Materials.Tin.getMolten(288))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_LV.get(1L),
                        ItemList.Casing_Turbine.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Steel, 1L),
                        ItemList.Electric_Motor_LV.get(2L),
                        ItemList.Electric_Pump_LV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.Machine_Multi_AirFilterT1.get(1L))
                .fluidInputs(Materials.Lead.getMolten(576)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 1L),
                        GT_Utility.getIntegratedCircuit(1),
                        CustomItemList.TitaniumBars.get(2))
                .itemOutputs(CustomItemList.Casing_AirFilter_Vent_T2.get(1L))
                .fluidInputs(Materials.SolderingAlloy.getMolten(72)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 1L),
                        GT_Utility.getIntegratedCircuit(1),
                        CustomItemList.TitaniumBars.get(2))
                .itemOutputs(CustomItemList.Casing_AirFilter_Vent_T2.get(1L)).fluidInputs(Materials.Tin.getMolten(144))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 1L),
                        GT_Utility.getIntegratedCircuit(1),
                        CustomItemList.TitaniumBars.get(2))
                .itemOutputs(CustomItemList.Casing_AirFilter_Vent_T2.get(1L)).fluidInputs(Materials.Lead.getMolten(288))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.Casing_AirFilter_Vent_T2.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Titanium, 2L),
                        ItemList.Electric_Motor_HV.get(2L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.Casing_AirFilter_Turbine_T2.get(1L))
                .fluidInputs(Materials.SolderingAlloy.getMolten(72)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.Casing_AirFilter_Vent_T2.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Titanium, 2L),
                        ItemList.Electric_Motor_HV.get(2L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.Casing_AirFilter_Turbine_T2.get(1L))
                .fluidInputs(Materials.Tin.getMolten(144)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.Casing_AirFilter_Vent_T2.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Titanium, 2L),
                        ItemList.Electric_Motor_HV.get(2L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.Casing_AirFilter_Turbine_T2.get(1L))
                .fluidInputs(Materials.Lead.getMolten(288)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_HV.get(1L),
                        ItemList.Casing_Turbine2.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Titanium, 1L),
                        ItemList.Electric_Motor_HV.get(2L),
                        ItemList.Electric_Pump_HV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.Machine_Multi_AirFilterT2.get(1L))
                .fluidInputs(Materials.SolderingAlloy.getMolten(144)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_HV.get(1L),
                        ItemList.Casing_Turbine2.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Titanium, 1L),
                        ItemList.Electric_Motor_HV.get(2L),
                        ItemList.Electric_Pump_HV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.Machine_Multi_AirFilterT2.get(1L)).fluidInputs(Materials.Tin.getMolten(288))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_HV.get(1L),
                        ItemList.Casing_Turbine2.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Titanium, 1L),
                        ItemList.Electric_Motor_HV.get(2L),
                        ItemList.Electric_Pump_HV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.Machine_Multi_AirFilterT2.get(1L))
                .fluidInputs(Materials.Lead.getMolten(576)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 1L),
                        GT_Utility.getIntegratedCircuit(1),
                        CustomItemList.TungstenSteelBars.get(2))
                .itemOutputs(CustomItemList.Casing_AirFilter_Vent_T3.get(1L))
                .fluidInputs(Materials.SolderingAlloy.getMolten(72)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 1L),
                        GT_Utility.getIntegratedCircuit(1),
                        CustomItemList.TungstenSteelBars.get(2))
                .itemOutputs(CustomItemList.Casing_AirFilter_Vent_T3.get(1L)).fluidInputs(Materials.Tin.getMolten(144))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 1L),
                        GT_Utility.getIntegratedCircuit(1),
                        CustomItemList.TungstenSteelBars.get(2))
                .itemOutputs(CustomItemList.Casing_AirFilter_Vent_T3.get(1L)).fluidInputs(Materials.Lead.getMolten(288))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.Casing_AirFilter_Vent_T3.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.TungstenSteel, 2L),
                        ItemList.Electric_Motor_IV.get(2L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.Casing_AirFilter_Turbine_T3.get(1L))
                .fluidInputs(Materials.SolderingAlloy.getMolten(72)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.Casing_AirFilter_Vent_T3.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.TungstenSteel, 2L),
                        ItemList.Electric_Motor_IV.get(2L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.Casing_AirFilter_Turbine_T3.get(1L))
                .fluidInputs(Materials.Tin.getMolten(144)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.Casing_AirFilter_Vent_T3.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.TungstenSteel, 2L),
                        ItemList.Electric_Motor_IV.get(2L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.Casing_AirFilter_Turbine_T3.get(1L))
                .fluidInputs(Materials.Lead.getMolten(288)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_IV.get(1L),
                        ItemList.Casing_Turbine3.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.TungstenSteel, 1L),
                        ItemList.Electric_Motor_IV.get(2L),
                        ItemList.Electric_Pump_IV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.Machine_Multi_AirFilterT3.get(1L))
                .fluidInputs(Materials.SolderingAlloy.getMolten(144)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_IV.get(1L),
                        ItemList.Casing_Turbine3.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.TungstenSteel, 1L),
                        ItemList.Electric_Motor_IV.get(2L),
                        ItemList.Electric_Pump_IV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.Machine_Multi_AirFilterT3.get(1L)).fluidInputs(Materials.Tin.getMolten(288))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_IV.get(1L),
                        ItemList.Casing_Turbine3.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.TungstenSteel, 1L),
                        ItemList.Electric_Motor_IV.get(2L),
                        ItemList.Electric_Pump_IV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.Machine_Multi_AirFilterT3.get(1L))
                .fluidInputs(Materials.Lead.getMolten(576)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

    }

    private void makeEnderIORecipes() {
        if (!EnderIO.isModLoaded()) {
            return;
        }

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L),
                        Materials.Glowstone.getDust(4),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 2)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        for (int i = 0; i < OreDictionary.getOres("dyeBlack").size(); i++) {

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L),
                            OreDictionary.getOres("dyeBlack").get(i).splitStack(4))
                    .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 4)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        }

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Manganese, 4),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 7))
                .fluidInputs(Materials.Plastic.getMolten(288)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Aluminium, 4),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Manganese, 4),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(288)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tantalum, 4),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Manganese, 4),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 4),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 1))
                .fluidInputs(Materials.EnergeticAlloy.getMolten(576)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.EnderEye, 4),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Manganese, 4),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 4),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 8))
                .fluidInputs(Materials.EnergeticSilver.getMolten(576)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Chrome, 4),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Manganese, 4),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glowstone, 4),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 2))
                .fluidInputs(Materials.EnergeticAlloy.getMolten(576)).duration(10 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.EnderEye, 4),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Manganese, 4),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glowstone, 4),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 9))
                .fluidInputs(Materials.EnergeticSilver.getMolten(576)).duration(10 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 4),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Manganese, 4),
                        ItemList.QuantumEye.get(1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 3))
                .fluidInputs(Materials.CrystallineAlloy.getMolten(864)).duration(10 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Titanium, 4),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Manganese, 4),
                        ItemList.QuantumEye.get(1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 3))
                .fluidInputs(Materials.CrystallineAlloy.getMolten(864)).duration(10 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 4),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Manganese, 4),
                        GT_OreDictUnificator.get(OrePrefixes.gem, Materials.NetherStar, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EndSteel, 1),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 4))
                .fluidInputs(Materials.MelodicAlloy.getMolten(1152)).duration(10 * SECONDS).eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.VanadiumGallium, 4),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Manganese, 4),
                        ItemList.QuantumStar.get(1L),
                        GT_ModHandler.getModItem(EnderIO.ID, "itemMaterial", 1L, 13),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 5))
                .fluidInputs(Materials.StellarAlloy.getMolten(1440)).duration(10 * SECONDS).eut(TierEU.RECIPE_LuV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedbolt", 4L, 10024),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Manganese, 4),
                        ItemList.Gravistar.get(1L),
                        GT_ModHandler.getModItem(EnderIO.ID, "itemFrankenSkull", 1L, 5),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StellarAlloy, 2),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 6))
                .fluidInputs(Materials.Neutronium.getMolten(1440)).duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 5),
                        ItemList.Gravistar.get(1L),
                        GT_ModHandler.getModItem(EnderIO.ID, "itemFrankenSkull", 1L, 5),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StellarAlloy, 2))
                .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 6))
                .fluidInputs(Materials.Neutronium.getMolten(1152)).duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Minecraft.ID, "skull", 1L, 0),
                        GT_ModHandler.getModItem(Minecraft.ID, "rotten_flesh", 2L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.SiliconSG, 1))
                .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "itemFrankenSkull", 1L, 5))
                .fluidInputs(Materials.Soularium.getMolten(288)).duration(5 * SECONDS).eut(TierEU.RECIPE_ZPM)
                .addTo(assemblerRecipes);

    }

    private void makeAE2Recipes() {
        if (!AppliedEnergistics2.isModLoaded()) {
            return;
        }

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 24),
                        CustomItemList.EssentiaCircuit.get(1L))
                .itemOutputs(CustomItemList.EngineeringProcessorEssentiaPulsatingCore.get(1L)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        // AE2 Illuminated Panel Assembler Recipe

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Cover_Screen.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L))
                .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1L, 180))
                .fluidInputs(Materials.SolderingAlloy.getMolten(144L)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.glass_pane, 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 2L))
                .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 39))
                .duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hatch_Output_Bus_HV.get(1L),
                        GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1L, 440),
                        GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4L, 30),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(ItemList.Hatch_Output_Bus_ME.get(1)).duration(15 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hatch_Output_HV.get(1L),
                        GT_ModHandler.getModItem(AE2FluidCraft.ID, "part_fluid_interface", 1L),
                        GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4L, 30),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(ItemList.Hatch_Output_ME.get(1)).duration(15 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        // Stocking Input Bus (ME)
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hatch_Input_Bus_HV.get(1L),
                        GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1L),
                        // Acceleration Card
                        GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4L, 30),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(ItemList.Hatch_Input_Bus_ME.get(1)).duration(15 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        // Stocking Input Hatch (ME)
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hatch_Input_Multi_2x2_UV.get(4L),
                        GT_ModHandler.getModItem(AE2FluidCraft.ID, "fluid_interface", 1L),
                        ItemList.Circuit_Chip_NeuroCPU.get(1L),
                        ItemList.Electric_Pump_UV.get(1L),
                        // 4096k Me Fluid Storage Component
                        GT_ModHandler.getModItem(AE2FluidCraft.ID, "fluid_part", 4L, 6),
                        // Hyper-Acceleration Card
                        GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 56))
                .itemOutputs(ItemList.Hatch_Input_ME.get(1)).duration(15 * SECONDS).eut(TierEU.RECIPE_UV)
                .addTo(assemblerRecipes);

        // Cell Workbench
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23),
                        ItemList.Cover_Screen.get(1),
                        getModItem(Minecraft.ID, "crafting_table", 1),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockCellWorkbench", 1))
                .fluidInputs(Materials.Titanium.getMolten(36L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        // Controller
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 24),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockFluix", 1, 0),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockController", 1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Energy Cells
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Fluix, 1),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockFluix", 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt08, Materials.Aluminium, 1),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2L),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 5, 0),
                        ItemList.Battery_Buffer_4by4_EV.get(1L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockDenseEnergyCell", 1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Void Cell
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 3L),
                        GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderEye, 1),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemVoidStorageCell", 1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Quantum Link
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 22),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockQuantumRing", 1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4, 9),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzGlass", 1, 0),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockQuantumLinkChamber", 1))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Spatial Pylon
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 16),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Fluix, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Fluix, 1L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockSpatialPylon", 1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Spatial IO
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 16),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockSpatialPylon", 1),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockIOPort", 1),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockSpatialIOPort", 1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // ME IO Port
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 3L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 3, 16),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockDrive", 2, 0),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockIOPort", 1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // ME Chest
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 16),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 4),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockChest", 1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // ME Drive
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 16),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockChest", 1),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockDrive", 1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Interface
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 16),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 44),
                        ItemList.Casing_EV.get(1L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Crafting Unit
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 2L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Formation Core
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.CertusQuartz, 4L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4, 22),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 12),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 43)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Annihilation Core
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.NetherQuartz, 4L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4, 22),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 12),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 44)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Wireless Receiver
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.EnderEye, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 140),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 41)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Molecular Assembler
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Machine_EV_Assembler.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 44),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockMolecularAssembler", 1))
                .fluidInputs(Materials.Glass.getMolten(288L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        // Basic Card
        GT_Values.RA.stdBuilder().itemInputs(
                // Calculation Processor
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 2),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 3),
                GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 25)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // Advanced Card
        GT_Values.RA.stdBuilder().itemInputs(
                // Calculation Processor
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Platinum, 2),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 3),
                GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // Acceleration Card
        GT_Values.RA.stdBuilder().itemInputs(
                // Advanced Card
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28),
                // Logic Processor
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22),
                // Engineering Processor
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                // Fluix Crystal
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7),
                GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 30)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // Hyper-Acceleration Card
        GT_Values.RA.stdBuilder().itemInputs(
                // Advanced Card
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28),
                // Engineering Processor
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                CustomItemList.MysteriousCrystal.get(1L),
                CustomItemList.AcceleratorLuV.get(1L),
                GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 56)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // Advanced Blocking Card
        GT_Values.RA.stdBuilder().itemInputs(
                // Advanced Card
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28),
                // ME Storage Bus
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 220),
                // ME Level Emitter
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 280),
                GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 63)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // Pattern Capacity Card
        GT_Values.RA.stdBuilder().itemInputs(
                // Advanced Card
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28),
                // 16k ME Storage Component
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 37),
                // ME Interface
                getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1, 0),
                GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 54)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // ME interface (flat version)
        GT_Values.RA.stdBuilder().itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4),
                // Fluix Cable
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 16),
                // Formation Core
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43),
                // Annihilation Core
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 44),
                ItemList.Casing_EV.get(1L),
                GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 440)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        if (AE2FluidCraft.isModLoaded()) {
            // Dual Interface
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 2L),
                            getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1),
                            getModItem(NewHorizonsCoreMod.ID, "item.EngineeringProcessorFluidDiamondCore", 2),
                            GT_Utility.getIntegratedCircuit(2))
                    .itemOutputs(getModItem(AE2FluidCraft.ID, "fluid_interface", 1, 0)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
            // Fluid Storage Housing
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2L),
                            GT_Utility.getIntegratedCircuit(3))
                    .itemOutputs(getModItem(AE2FluidCraft.ID, "fluid_storage_housing", 1, 0)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2L),
                            GT_Utility.getIntegratedCircuit(3))
                    .itemOutputs(getModItem(AE2FluidCraft.ID, "fluid_storage_housing", 1, 1)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
            // Multi Fluid Storage Housing
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2L),
                            GT_Utility.getIntegratedCircuit(3))
                    .itemOutputs(getModItem(AE2FluidCraft.ID, "fluid_storage_housing", 1, 2)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Infinity, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2L),
                            GT_Utility.getIntegratedCircuit(3))
                    .itemOutputs(getModItem(AE2FluidCraft.ID, "fluid_storage_housing", 1, 3)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        }
        if (AE2Stuff.isModLoaded()) {
            // Wireless Connector
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 2L),
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4, 12),
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 24),
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 41),
                            GT_Utility.getIntegratedCircuit(2))
                    .itemOutputs(getModItem(AE2Stuff.ID, "Wireless", 1)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(assemblerRecipes);
        }

        if (TinkerConstruct.isModLoaded()) {
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(TinkerConstruct.ID, "GlassPane", 1L, 0),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 2L))
                    .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 39))
                    .duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);

        }
    }

    private void makeTinkersConstructRecipes() {
        if (!TinkerConstruct.isModLoaded()) {
            return;
        }

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Stone, 2L),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "GlassPane", 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Tin, 1L))
                .itemOutputs(
                        GT_ModHandler
                                .getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowercobblestone", 1L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "GlassPane", 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 1L))
                .itemOutputs(GT_ModHandler.getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerwood", 1L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "GlassPane", 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 1L))
                .itemOutputs(GT_ModHandler.getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerwood", 1L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.SandStoneRod.get(2L),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "GlassPane", 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Cupronickel, 1L))
                .itemOutputs(
                        GT_ModHandler.getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowersandstone", 1L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(ForgeMicroblocks.ID, "stoneRod", 2L),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "GlassPane", 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Nickel, 1L))
                .itemOutputs(GT_ModHandler.getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerstone", 1L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.NetherQuartz, 2L),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "GlassPane", 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Silver, 1L))
                .itemOutputs(
                        GT_ModHandler.getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerquartz", 1L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 2L),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "GlassPane", 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Electrum, 1L))
                .itemOutputs(GT_ModHandler.getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepoweriron", 1L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Gold, 2L),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "GlassPane", 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Aluminium, 1L))
                .itemOutputs(GT_ModHandler.getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowergold", 1L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Emerald, 2L),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "GlassPane", 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Nichrome, 1L))
                .itemOutputs(
                        GT_ModHandler.getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepoweremerald", 1L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Diamond, 2L),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "GlassPane", 2L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Platinum, 1L))
                .itemOutputs(
                        GT_ModHandler.getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerdiamond", 1L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Assembler

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "slime.gel", 1L, 1),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockITNT", 1L, 0),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "explosive.slime", 1L, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "slime.gel", 1L, 0),
                        GT_ModHandler.getModItem(TinkerConstruct.ID, "explosive.slime", 1L, 0),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "explosive.slime", 1L, 2))
                .duration(30 * SECONDS).eut(64).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Aluminium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 4L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "heartCanister", 1L, 0)).duration(2 * MINUTES)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

    }

    private void makeForestryRecipes() {
        if (!Forestry.isModLoaded()) {
            return;
        }

        ItemStack alveary = GT_ModHandler.getModItem(Forestry.ID, "alveary", 1L, 0);

        // Impregnated Frame
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Railcraft.ID, "slab", 3L, 38),
                        GT_ModHandler.getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1L),
                        GT_ModHandler.getModItem(Forestry.ID, "oakStick", 5L, 0))
                .itemOutputs(GT_ModHandler.getModItem(Forestry.ID, "frameImpregnated", 1L, 0))
                .fluidInputs(Materials.SeedOil.getFluid(250L)).duration(60 * SECONDS).eut(64).addTo(assemblerRecipes);

        // Apiary
        List<ItemStack> fence = OreDictionary.getOres("fenceWood");
        for (ItemStack stack : fence) {
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(Forestry.ID, "frameImpregnated", 1L, 0),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.slab, Materials.Wood, 2L),
                            GT_ModHandler.getModItem(Forestry.ID, "beeCombs", 1L, W),
                            GT_ModHandler.getModItem(Forestry.ID, "apiculture", 2L, 2),
                            stack.splitStack(2))
                    .itemOutputs(GT_ModHandler.getModItem(Forestry.ID, "apiculture", 1L, 0))
                    .fluidInputs(Materials.SeedOil.getFluid(1000L)).duration(60 * SECONDS).eut(64)
                    .addTo(assemblerRecipes);
        }

        // Scented Paneling

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 2L),
                        GT_ModHandler.getModItem(Forestry.ID, "royalJelly", 1L, 0),
                        GT_ModHandler.getModItem(Forestry.ID, "oakStick", 3L, 0),
                        GT_ModHandler.getModItem(Forestry.ID, "beeswax", 2L, 0),
                        GT_ModHandler.getModItem(Forestry.ID, "pollen", 1L, W))
                .itemOutputs(GT_ModHandler.getModItem(Forestry.ID, "craftingMaterial", 1L, 6))
                .fluidInputs(Materials.Honey.getFluid(1000L)).duration(60 * SECONDS).eut(64).addTo(assemblerRecipes);
        // Swarmer

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        alveary,
                        GT_ModHandler.getModItem(Forestry.ID, "thermionicTubes", 4L, 5),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.RoseGold, 2L),
                        GT_ModHandler.getModItem(Forestry.ID, "royalJelly", 2L, 0),
                        GT_ModHandler.getModItem(Forestry.ID, "frameProven", 1L, 0))
                .itemOutputs(GT_ModHandler.getModItem(Forestry.ID, "alveary", 1L, 2))
                .fluidInputs(Materials.Honey.getFluid(5000L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // Alveary Fan

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        alveary,
                        GT_ModHandler.getModItem(Forestry.ID, "thermionicTubes", 4L, 11),
                        CustomItemList.SteelBars.get(3L),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1L),
                        ItemList.Electric_Motor_MV.get(1L))
                .itemOutputs(GT_ModHandler.getModItem(Forestry.ID, "alveary", 1L, 3))
                .fluidInputs(Materials.Honey.getFluid(5000L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // Alveary Heater

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        alveary,
                        GT_ModHandler.getModItem(Forestry.ID, "thermionicTubes", 4L, 7),
                        CustomItemList.SteelBars.get(1L),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemRecipePart", 3L),
                        ItemList.Electric_Motor_MV.get(1L))
                .itemOutputs(GT_ModHandler.getModItem(Forestry.ID, "alveary", 1L, 4))
                .fluidInputs(Materials.Honey.getFluid(5000L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // Alveary Hygroregulator

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        alveary,
                        GT_ModHandler.getModItem(Forestry.ID, "thermionicTubes", 4L, 6),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L),
                        GT_ModHandler.getModItem(BuildCraftFactory.ID, "tankBlock", 2L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L))
                .itemOutputs(GT_ModHandler.getModItem(Forestry.ID, "alveary", 1L, 5))
                .fluidInputs(Materials.Honey.getFluid(5000L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // Alveary Stabiliser

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        alveary,
                        GT_ModHandler.getModItem(Forestry.ID, "thermionicTubes", 4L, 4),
                        com.dreammaster.item.ItemList.ChargedCertusQuartzPlate.getIS(2),
                        ItemList.Component_Filter.get(2L),
                        GT_ModHandler.getModItem(Forestry.ID, "royalJelly", 1L, 0))
                .itemOutputs(GT_ModHandler.getModItem(Forestry.ID, "alveary", 1L, 6))
                .fluidInputs(Materials.Honey.getFluid(5000L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // Alveary Sieve

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        alveary,
                        GT_ModHandler.getModItem(Forestry.ID, "thermionicTubes", 4L, 9),
                        GT_ModHandler.getModItem(Forestry.ID, "craftingMaterial", 4L, 3),
                        GT_ModHandler.getModItem(Forestry.ID, "pollenFertile", 1L, GT_Values.W))
                .itemOutputs(GT_ModHandler.getModItem(Forestry.ID, "alveary", 1L, 7))
                .fluidInputs(Materials.Honey.getFluid(5000L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

    }

    private void makeOpenComputersRecipes() {
        if (!OpenComputers.isModLoaded()) {
            return;
        }
        // cable

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.RedstoneAlloy, 1),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "cable", 1L, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Emerald, 1),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "cable", 1L, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 9),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 1),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "cable", 9L, 0)).duration(90 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 9),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Emerald, 1),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "cable", 9L, 0)).duration(90 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        // keyboard

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone_button, 64),
                        new ItemStack(Blocks.stone_button, 40),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1),
                        GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "keyboard", 1L, 0)).duration(10 * SECONDS)
                .eut(64).addTo(assemblerRecipes);
        // case 1

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_MV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2),
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 24),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Aluminium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "case1", 1, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // case 2

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_HV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2),
                        ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 25),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Aluminium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "case2", 1, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(10 * SECONDS).eut(256).addTo(assemblerRecipes);
        // case 3

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_EV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 2),
                        ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 26),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Aluminium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "case3", 1, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(10 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        // micro case 1

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_MV.get(1L),
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 25),
                        GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 82))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // mirco case 2

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_HV.get(1L),
                        ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 26),
                        GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 86))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(10 * SECONDS).eut(256).addTo(assemblerRecipes);
        // drone case 1

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 82),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 71),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Aluminium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                        ItemList.Electric_Motor_HV.get(4L))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1, 83))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(15 * SECONDS).eut(256).addTo(assemblerRecipes);
        // drone case 2

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 86),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 72),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 26),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Titanium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 1L),
                        ItemList.Electric_Motor_EV.get(4L))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1, 87))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(15 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        // Card

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 1),
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 1),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 33)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        // floppy

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 19),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Plastic, 4),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 4)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        // HDD 1

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 19),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 24),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 4L, 1),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 5)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // HDD 2

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 4L, 19),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 4L, 2),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 6)).duration(15 * SECONDS).eut(256)
                .addTo(assemblerRecipes);
        // HDD 3

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 8L, 19),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 26),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 4L, 38),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 7)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // disk

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Glass, 1),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 4),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 19))
                .fluidInputs(Materials.Cobalt.getMolten(36L)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // rack

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(OpenComputers.ID, "relay", 1L, 0),
                        GT_ModHandler.getModItem(OpenComputers.ID, "powerDistributor", 1L, 0),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 13),
                        ItemList.Circuit_Board_Plastic_Advanced.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Aluminium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 4L),
                        CustomItemList.SteelBars.get(2L))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "rack", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(10 * SECONDS).eut(256).addTo(assemblerRecipes);
        // adapter block

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_LV.get(1L),
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "cable", 2L, 0),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 24),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "adapter", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // assembler

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_HV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2),
                        ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 25),
                        ItemList.Robot_Arm_LV.get(3L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "assembler", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(10 * SECONDS).eut(256).addTo(assemblerRecipes);
        // disassembler

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_HV.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 0),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 28),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 25),
                        ItemList.Robot_Arm_HV.get(2L))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "disassembler", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(10 * SECONDS).eut(256).addTo(assemblerRecipes);
        // capacitor

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_LV.get(2L),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockElectric", 1L, 7),
                        ItemList.Circuit_Board_Plastic_Advanced.get(2L),
                        ItemList.Circuit_Parts_Transistor.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "cable", 2),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "capacitor", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // charger

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_HV.get(1L),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockChargepad", 2L, 2),
                        ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 26),
                        GT_ModHandler.getModItem(OpenComputers.ID, "cable", 2),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "charger", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(10 * SECONDS).eut(256).addTo(assemblerRecipes);
        // diskDrive

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_LV.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 3L, 25),
                        ItemList.Electric_Motor_MV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.springSmall, Materials.Copper, 1),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.IronMagnetic, 1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Glass, 1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "diskDrive", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // diskDriver

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(OpenComputers.ID, "diskDrive", 1L, 0),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 24),
                        ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                        CustomItemList.SteelBars.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 4),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 109))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(10 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        // geolyzer

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_MV.get(1L),
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 25),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 0),
                        ItemList.Sensor_MV.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 2),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "geolyzer", 1L, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // hologram1

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic_Advanced.get(2L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 2),
                        GT_ModHandler.getModItem(OpenComputers.ID, "cable", 2L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 2),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1),
                        GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "hologram1", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // hologram2

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Epoxy_Advanced.get(2L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 26),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 2),
                        GT_ModHandler.getModItem(OpenComputers.ID, "cable", 2L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 4),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Emerald, 1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Ruby, 1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Sapphire, 1),
                        GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "hologram2", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(10 * SECONDS).eut(256).addTo(assemblerRecipes);
        // motionSensor

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 42),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 2),
                        GT_ModHandler.getModItem(OpenComputers.ID, "cable", 2L, 0),
                        new ItemStack(Blocks.daylight_detector, 2, 0),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "motionSensor", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // netSplitter

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_LV.get(1L),
                        ItemList.Circuit_Board_Plastic_Advanced.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 4),
                        GT_ModHandler.getModItem(OpenComputers.ID, "cable", 3L, 0),
                        ItemList.Electric_Piston_LV.get(1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "netSplitter", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(10 * SECONDS).eut(64).addTo(assemblerRecipes);
        // printer

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Machine_HV_Printer.get(1L),
                        ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 26),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 4),
                        GT_ModHandler.getModItem(OpenComputers.ID, "cable", 2L, 0),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "printer", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(10 * SECONDS).eut(256).addTo(assemblerRecipes);
        // powerConverter

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_HV_MV.get(1L),
                        ItemList.Circuit_Board_Plastic_Advanced.get(2L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2),
                        GT_ModHandler.getModItem(OpenComputers.ID, "cable", 2L, 0),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "powerConverter", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(10 * SECONDS).eut(256).addTo(assemblerRecipes);
        // powerDistributor

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_MV.get(1L),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockElectric", 1L, 7),
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2),
                        GT_ModHandler.getModItem(OpenComputers.ID, "cable", 2L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "powerDistributor", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(10 * SECONDS).eut(256).addTo(assemblerRecipes);
        // raid

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(OpenComputers.ID, "diskDrive", 1L, 0),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 43),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 1),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 25),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 4),
                        GT_ModHandler.getModItem(OpenComputers.ID, "cable", 2L, 0))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "raid", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(10 * SECONDS).eut(256).addTo(assemblerRecipes);
        // redstone

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_MV.get(1L),
                        ItemList.Circuit_Board_Plastic_Advanced.get(2L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Redstone, 2),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 66),
                        ItemList.Cover_ActivityDetector.get(1L))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "redstone", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // relay

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_MV.get(1L),
                        ItemList.Circuit_Board_Plastic_Advanced.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 2),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 13),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 25),
                        GT_ModHandler.getModItem(OpenComputers.ID, "cable", 2L, 0))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "relay", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // transposer

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Automation_ChestBuffer_LV.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 61),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 77),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 2),
                        GT_ModHandler.getModItem(OpenComputers.ID, "cable", 2L, 0),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "transposer", 2L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // waypoint

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_MV.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 48),
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 24),
                        ItemList.Circuit_Parts_Transistor.get(2L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "cable", 2L, 0))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "waypoint", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(10 * SECONDS).eut(64).addTo(assemblerRecipes);
        // cartridge empty

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 24),
                        ItemList.Circuit_Parts_Transistor.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Plastic, 8),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 94))
                .fluidInputs(Materials.Plastic.getMolten(36L)).duration(10 * SECONDS).eut(64).addTo(assemblerRecipes);
        // cartridge full

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 94),
                        ItemList.Color_00.get(1L),
                        ItemList.Color_06.get(1L),
                        ItemList.Color_11.get(1L),
                        ItemList.Color_13.get(1L))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 95))
                .fluidInputs(Materials.Water.getFluid(1000L)).duration(10 * SECONDS).eut(64).addTo(assemblerRecipes);
        // Interweb

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 1),
                        new ItemStack(Items.string, 8, 0),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 48))
                .fluidInputs(Materials.Glue.getFluid(576L)).duration(10 * SECONDS).eut(64).addTo(assemblerRecipes);
        // Linked Card

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 13),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 28),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 48),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 51))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 250)).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        // Manual

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.book, 1, 0),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 24),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 98))
                .fluidInputs(Materials.Glue.getFluid(144L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Nano Machine

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(OpenComputers.ID, "capacitor", 1L, 0),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 2),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 13),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 42),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 18),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 9L, 96))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 107))
                .fluidInputs(Materials.Plastic.getMolten(144L)).duration(20 * SECONDS).eut(256).addTo(assemblerRecipes);
        // Server Tier 1

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "case1", 1L, 0),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 24),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 25),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 3),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 45))
                .fluidInputs(Materials.Plastic.getMolten(144L)).duration(20 * SECONDS).eut(256).addTo(assemblerRecipes);
        // Server Tier 2

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "case2", 1L, 0),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 26),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 38),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 46))
                .fluidInputs(Materials.Plastic.getMolten(144L)).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        // Server Tier 3

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "case3", 1L, 0),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 26),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 39),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 40))
                .fluidInputs(Materials.Plastic.getMolten(144L)).duration(20 * SECONDS).eut(1024)
                .addTo(assemblerRecipes);
        // Tablet Case Tier 1

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(OpenComputers.ID, "screen2", 1L, 0),
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 70),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 24),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 4L))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 74))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // Tablet Case Tier 2

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(OpenComputers.ID, "screen2", 1L, 0),
                        ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 26),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 72),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 4L))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 92))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(20 * SECONDS).eut(256).addTo(assemblerRecipes);
        // remote Monitor

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(OpenComputers.ID, "screen2", 1L, 0),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 34),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 13),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 26),
                        GT_ModHandler.getModItem(OpenComputers.ID, "keyboard", 1L, 0),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 41))
                .fluidInputs(Materials.Plastic.getMolten(144L)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // Terminal Server

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 3L, 13),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 108))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        // Open Printers
        // Printer

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Machine_MV_Printer.get(1L),
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 24),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenPrinters.ID, "openprinter.printer", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(15 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // Shredder

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Machine_MV_Macerator.get(1L),
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 24),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenPrinters.ID, "openprinter.shredder", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(15 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // Paper Roll

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.paper, 64, 0),
                        new ItemStack(Items.paper, 64, 0),
                        new ItemStack(Items.paper, 64, 0),
                        new ItemStack(Items.paper, 64, 0),
                        GT_Utility.getIntegratedCircuit(12))
                .itemOutputs(GT_ModHandler.getModItem(OpenPrinters.ID, "openprinter.printerPaperRoll", 1L, 0))
                .duration(10 * SECONDS).eut(64).addTo(assemblerRecipes);
        // Black Ink Cartridge

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 94),
                        ItemList.Color_00.get(1L),
                        ItemList.Color_00.get(1L),
                        ItemList.Color_00.get(1L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_ModHandler.getModItem(OpenPrinters.ID, "openprinter.printerInkBlack", 1L, W))
                .fluidInputs(Materials.Water.getFluid(1000L)).duration(15 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(OpenPrinters.ID, "openprinter.printerInkBlack", 1L, W),
                        ItemList.Color_00.get(1L),
                        ItemList.Color_00.get(1L),
                        ItemList.Color_00.get(1L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_ModHandler.getModItem(OpenPrinters.ID, "openprinter.printerInkBlack", 1L, W))
                .fluidInputs(Materials.Water.getFluid(1000L)).duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // Color Ink Cartridge

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 94),
                        ItemList.Color_01.get(1L),
                        ItemList.Color_02.get(1L),
                        ItemList.Color_04.get(1L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_ModHandler.getModItem(OpenPrinters.ID, "openprinter.printerInkColor", 1L, W))
                .fluidInputs(Materials.Water.getFluid(1000L)).duration(15 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(OpenPrinters.ID, "openprinter.printerInkColor", 1L, W),
                        ItemList.Color_01.get(1L),
                        ItemList.Color_02.get(1L),
                        ItemList.Color_04.get(1L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_ModHandler.getModItem(OpenPrinters.ID, "openprinter.printerInkColor", 1L, W))
                .fluidInputs(Materials.Water.getFluid(1000L)).duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // Open Security
        // Magnetic Card Reader

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                        GT_ModHandler.getModItem(OpenComputers.ID, "cable", 2L, 0),
                        ItemList.Circuit_Parts_Transistor.get(2L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_ModHandler.getModItem(OpenSecurity.ID, "magreader", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(15 * SECONDS).eut(256).addTo(assemblerRecipes);
        // RFID Reader

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(OpenSecurity.ID, "opensecurity.rfidReaderCard", 1L, 0),
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 25),
                        GT_ModHandler.getModItem(OpenComputers.ID, "cable", 2L, 0),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_ModHandler.getModItem(OpenSecurity.ID, "rfidreader", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(15 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // Card writer

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 1),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 28),
                        GT_ModHandler.getModItem(OpenComputers.ID, "cable", 2L, 0),
                        ItemList.Circuit_Parts_Transistor.get(2L))
                .itemOutputs(GT_ModHandler.getModItem(OpenSecurity.ID, "rfidwriter", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(15 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // Alarm

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.noteblock, 1, 0),
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 25),
                        GT_ModHandler.getModItem(OpenComputers.ID, "cable", 2L, 0),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenSecurity.ID, "alarm", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(15 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // Entity Detector

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 33),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 1),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 28),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenSecurity.ID, "entitydetector", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(15 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // Door Controler

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 28),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                        ItemList.Circuit_Parts_Transistor.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 4L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenSecurity.ID, "doorcontroller", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(15 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // Data Block

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 104),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 25),
                        GT_ModHandler.getModItem(OpenComputers.ID, "cable", 1L, 0),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenSecurity.ID, "opensecurity.DataBlock", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(15 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // swtichable Hub

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(OpenComputers.ID, "relay", 1L, 0),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                        GT_ModHandler.getModItem(OpenComputers.ID, "cable", 4L, 0),
                        ItemList.Circuit_Parts_Transistor.get(2L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenSecurity.ID, "opensecurity.SwitchableHub", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(15 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // kvm Hub

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(OpenComputers.ID, "relay", 1L, 0),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                        GT_ModHandler.getModItem(OpenComputers.ID, "cable", 4L, 0),
                        ItemList.Circuit_Parts_Transistor.get(2L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_ModHandler.getModItem(OpenSecurity.ID, "opensecurity.BlockKVM", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(15 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // energy turret

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(OpenModularTurrets.ID, "laserTurret", 1L, 0),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 4L, 25),
                        GT_ModHandler.getModItem(OpenComputers.ID, "cable", 4L, 0),
                        ItemList.Circuit_Parts_Transistor.get(2L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_ModHandler.getModItem(OpenSecurity.ID, "energyTurretBlock", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(15 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // keypad

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(OpenComputers.ID, "keyboard", 1L, 0),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 24),
                        ItemList.Circuit_Parts_Transistor.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_ModHandler.getModItem(OpenSecurity.ID, "keypadLock", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(15 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // biometric reader

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Glass, 4L),
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 24),
                        ItemList.Circuit_Parts_Transistor.get(2L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenSecurity.ID, "biometricScanner", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(15 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // magnetic stipe card

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Paper, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IronMagnetic, 2L),
                        ItemList.Circuit_Parts_Transistor.get(1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenSecurity.ID, "opensecurity.magCard", 2L, 0))
                .fluidInputs(Materials.Glue.getFluid(144L)).duration(7 * SECONDS + 10 * TICKS).eut(64)
                .addTo(assemblerRecipes);
        // RFID Card

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Paper, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IronMagnetic, 2L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 24),
                        ItemList.Circuit_Parts_Transistor.get(1L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_ModHandler.getModItem(OpenSecurity.ID, "opensecurity.rfidCard", 2L, 0))
                .fluidInputs(Materials.Glue.getFluid(144L)).duration(7 * SECONDS + 10 * TICKS).eut(64)
                .addTo(assemblerRecipes);
        // RFID Reader Card

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 33),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 13),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 1),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 28),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_ModHandler.getModItem(OpenSecurity.ID, "opensecurity.rfidReaderCard", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(15 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // Secure Network Card

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 11),
                        GT_ModHandler.getModItem(OpenComputers.ID, "cable", 2L, 0),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 26),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenSecurity.ID, "opensecurity.secureNetworkCard", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(15 * SECONDS).eut(256).addTo(assemblerRecipes);
        // Secure Door

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.iron_door, 1),
                        GT_ModHandler.getModItem(OpenComputers.ID, "cable", 2L, 0),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 25),
                        ItemList.Circuit_Parts_Transistor.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 4L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenSecurity.ID, "opensecurity.securityDoor", 1L, 0))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Secure Private Door

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.iron_door, 1),
                        GT_ModHandler.getModItem(OpenComputers.ID, "cable", 2L, 0),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 25),
                        ItemList.Circuit_Parts_Transistor.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 4L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_ModHandler.getModItem(OpenSecurity.ID, "opensecurity.securityDoorPrivate", 1L, 0))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Damage Upgrade

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        new ItemStack(Blocks.tnt, 1, 0),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 24),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenSecurity.ID, "opensecurity.damageUpgrade", 1L, 0))
                .fluidInputs(Materials.Redstone.getMolten(72L)).duration(15 * SECONDS).eut(256).addTo(assemblerRecipes);
        // Cooldown upgrade

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        GT_ModHandler.getIC2Item("reactorCoolantSimple", 1L, 1),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 24),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenSecurity.ID, "opensecurity.cooldownUpgrade", 1L, 0))
                .fluidInputs(Materials.Redstone.getMolten(72L)).duration(15 * SECONDS).eut(256).addTo(assemblerRecipes);
        // Energy Upgrade

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 63),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 24),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenSecurity.ID, "opensecurity.energyUpgrade", 1L, 0))
                .fluidInputs(Materials.Redstone.getMolten(72L)).duration(15 * SECONDS).eut(256).addTo(assemblerRecipes);
        // Movement Upgrade

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        ItemList.Electric_Piston_MV.get(1L),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 24),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenSecurity.ID, "opensecurity.movementUpgrade", 1L, 0))
                .fluidInputs(Materials.Redstone.getMolten(72L)).duration(15 * SECONDS).eut(256).addTo(assemblerRecipes);
        // OpenGlasses Terminal

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(OpenComputers.ID, "geolyzer", 1L, 0),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 43),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 38),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenGlasses.ID, "openglassesterminal", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(144L)).duration(15 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        // Open Glasses

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(OpenComputers.ID, "screen3", 2L, 0),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 10),
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 13),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(OpenGlasses.ID, "openglasses", 1L, W))
                .fluidInputs(Materials.Plastic.getMolten(72L)).duration(15 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

    }

    private void makeJabbaRecipes() {
        if (!JABBA.isModLoaded()) {
            return;
        }
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(JABBA.ID, "barrel", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 2),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2),
                        GT_Utility.getIntegratedCircuit(13))
                .itemOutputs(GT_ModHandler.getModItem(JABBA.ID, "upgradeStructural", 1L, 0)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(JABBA.ID, "barrel", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 2),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Copper, 2),
                        GT_Utility.getIntegratedCircuit(13))
                .itemOutputs(GT_ModHandler.getModItem(JABBA.ID, "upgradeStructural", 1L, 1)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(JABBA.ID, "barrel", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 2),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 2),
                        GT_Utility.getIntegratedCircuit(13))
                .itemOutputs(GT_ModHandler.getModItem(JABBA.ID, "upgradeStructural", 1L, 2)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(JABBA.ID, "barrel", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 2),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Bronze, 2),
                        GT_Utility.getIntegratedCircuit(13))
                .itemOutputs(GT_ModHandler.getModItem(JABBA.ID, "upgradeStructural", 1L, 3)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(JABBA.ID, "barrel", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 2),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2),
                        GT_Utility.getIntegratedCircuit(13))
                .itemOutputs(GT_ModHandler.getModItem(JABBA.ID, "upgradeStructural", 1L, 4)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(JABBA.ID, "barrel", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2),
                        GT_Utility.getIntegratedCircuit(13))
                .itemOutputs(GT_ModHandler.getModItem(JABBA.ID, "upgradeStructural", 1L, 5)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(JABBA.ID, "barrel", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 2),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2),
                        GT_Utility.getIntegratedCircuit(13))
                .itemOutputs(GT_ModHandler.getModItem(JABBA.ID, "upgradeStructural", 1L, 6)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(JABBA.ID, "barrel", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 2),
                        GT_Utility.getIntegratedCircuit(13))
                .itemOutputs(GT_ModHandler.getModItem(JABBA.ID, "upgradeStructural", 1L, 7)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(JABBA.ID, "barrel", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 2),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 2),
                        GT_Utility.getIntegratedCircuit(13))
                .itemOutputs(GT_ModHandler.getModItem(JABBA.ID, "upgradeStructural", 1L, 8)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);

        if (BartWorks.isModLoaded()) {

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(JABBA.ID, "barrel", 1L, 0),
                            GT_ModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedplate", 2L, 88),
                            GT_ModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedstick", 2L, 88),
                            GT_Utility.getIntegratedCircuit(13))
                    .itemOutputs(GT_ModHandler.getModItem(JABBA.ID, "upgradeStructural", 1L, 9)).duration(10 * SECONDS)
                    .eut(16).addTo(assemblerRecipes);

        } else {
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(JABBA.ID, "barrel", 1L, 0),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 2),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Chrome, 2),
                            GT_Utility.getIntegratedCircuit(13))
                    .itemOutputs(GT_ModHandler.getModItem(JABBA.ID, "upgradeStructural", 1L, 9)).duration(10 * SECONDS)
                    .eut(16).addTo(assemblerRecipes);
        }

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(JABBA.ID, "barrel", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iridium, 2),
                        GT_Utility.getIntegratedCircuit(13))
                .itemOutputs(GT_ModHandler.getModItem(JABBA.ID, "upgradeStructural", 1L, 10)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(JABBA.ID, "barrel", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Osmium, 2),
                        GT_Utility.getIntegratedCircuit(13))
                .itemOutputs(GT_ModHandler.getModItem(JABBA.ID, "upgradeStructural", 1L, 11)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(JABBA.ID, "barrel", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Neutronium, 2),
                        GT_Utility.getIntegratedCircuit(13))
                .itemOutputs(GT_ModHandler.getModItem(JABBA.ID, "upgradeStructural", 1L, 12)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(JABBA.ID, "barrel", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.BlackPlutonium, 2),
                        GT_Utility.getIntegratedCircuit(13))
                .itemOutputs(GT_ModHandler.getModItem(JABBA.ID, "upgradeStructural", 1L, 13)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);

    }

    private void makeZTonesRecipes() {
        if (!ZTones.isModLoaded()) {
            return;
        }

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone_slab, 4),
                        new ItemStack(Blocks.stone, 1),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(ZTones.ID, "stoneTile", 8L, 0)).duration(8 * SECONDS).eut(4)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.glass, 4),
                        new ItemStack(Items.dye, 1, W),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(ZTones.ID, "auroraBlock", 8L, 0)).duration(8 * SECONDS).eut(4)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.sand, 4, W),
                        new ItemStack(Blocks.dirt, 4, W),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_ModHandler.getModItem(ZTones.ID, "cleanDirt", 8L, 0))
                .fluidInputs(Materials.SeedOil.getFluid(5L)).duration(8 * SECONDS).eut(4).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(new ItemStack(Blocks.stone_pressure_plate, 1), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(ZTones.ID, "booster", 1L, 0))
                .fluidInputs(Materials.Blaze.getMolten(8L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // This replaces the type of block, and the item used to make it for the 0-15 meta, and the 21+12 different
        // versions of ztones blocks (glaxx is separate)
        // Normal crafting recipes are not affected, so they might be crafted differently
        String[] blockName = { "agon", "azur", "bitt", "cray", "fort", "iszm", "jelt", "korp", "kryp", "lair", "lave",
                "mint", "myst", "reds", "reed", "roen", "sols", "sync", "tank", "vect", "vena" };
        String[] zblockName = { "zane", "zech", "zest", "zeta", "zion", "zkul", "zoea", "zome", "zone", "zorg", "ztyl",
                "zyth" };

        Map<String, List<ItemStack>> itemMap = new HashMap<>();
        itemMap.put(blockName[0], OreDictionary.getOres("dyeLightGray")); // agon
        itemMap.put(blockName[1], OreDictionary.getOres("dyeBlue")); // azur
        itemMap.put(blockName[2], new ArrayList<>(Arrays.asList(new ItemStack(Blocks.wool, 1, 0)))); // bitt
        itemMap.put(blockName[3], new ArrayList<>(Arrays.asList(new ItemStack(Blocks.hardened_clay, 1, 0)))); // cray
        itemMap.put(blockName[4], OreDictionary.getOres("dyeBrown")); // fort
        itemMap.put(blockName[5], OreDictionary.getOres("dyeGray")); // iszm
        itemMap.put(blockName[6], new ArrayList<>(Arrays.asList(new ItemStack(Items.gold_ingot, 1, 0))));// jelt
        itemMap.put(blockName[7], new ArrayList<>(Arrays.asList(new ItemStack(Blocks.obsidian, 1, 0)))); // korp
        itemMap.put(blockName[8], new ArrayList<>(Arrays.asList(new ItemStack(Blocks.soul_sand, 1, 0))));// kryp
        itemMap.put(blockName[9], new ArrayList<>(Arrays.asList(new ItemStack(Blocks.netherrack, 1, 0))));// lair
        itemMap.put(blockName[10], new ArrayList<>(Arrays.asList(new ItemStack(Blocks.ice, 1, 0))));// lave
        itemMap.put(blockName[11], new ArrayList<>(Arrays.asList(new ItemStack(Items.slime_ball, 1, 0))));// mint
        itemMap.put(blockName[12], new ArrayList<>(Arrays.asList(new ItemStack(Blocks.brown_mushroom, 1, 0))));// myst
        itemMap.put(blockName[13], new ArrayList<>(Arrays.asList(new ItemStack(Items.redstone, 1, 0))));// reds
        itemMap.put(blockName[14], new ArrayList<>(Arrays.asList(new ItemStack(Items.reeds, 1, 0))));// reed
        itemMap.put(blockName[15], new ArrayList<>(Arrays.asList(new ItemStack(Blocks.sandstone, 1, 0))));// roen
        itemMap.put(blockName[16], new ArrayList<>(Arrays.asList(new ItemStack(Items.blaze_powder, 1, 0))));// sols
        itemMap.put(blockName[17], new ArrayList<>(Arrays.asList(new ItemStack(Items.emerald, 1, 0))));// sync
        itemMap.put(blockName[18], new ArrayList<>(Arrays.asList(new ItemStack(Items.iron_ingot, 1, 0))));// tank
        itemMap.put(blockName[19], new ArrayList<>(Arrays.asList(new ItemStack(Items.ghast_tear, 1, 0))));// vect
        itemMap.put(blockName[20], new ArrayList<>(Arrays.asList(new ItemStack(Items.ender_pearl, 1, 0))));// vena
        Map<String, List<ItemStack>> zitemMap = new HashMap<>();
        zitemMap.put(zblockName[0], OreDictionary.getOres("dyeBlack")); // zane
        zitemMap.put(zblockName[1], OreDictionary.getOres("dyeRed")); // zech
        zitemMap.put(zblockName[2], OreDictionary.getOres("dyeBlack")); // zest
        zitemMap.put(zblockName[3], OreDictionary.getOres("dyePurple")); // zeta
        zitemMap.put(zblockName[4], OreDictionary.getOres("dyeCyan")); // zion
        zitemMap.put(zblockName[5], OreDictionary.getOres("dyePink")); // zkul
        zitemMap.put(zblockName[6], OreDictionary.getOres("dyeLime")); // zoea
        zitemMap.put(zblockName[7], OreDictionary.getOres("dyeYellow")); // zome
        zitemMap.put(zblockName[8], OreDictionary.getOres("dyeLightBlue")); // zone
        zitemMap.put(zblockName[9], OreDictionary.getOres("dyeMagenta")); // zorg
        zitemMap.put(zblockName[10], OreDictionary.getOres("dyeOrange")); // ztyl
        zitemMap.put(zblockName[11], OreDictionary.getOres("dyeWhite")); // zyth

        final int ztoneVariants = 16;

        for (String name : blockName) {
            for (int i = 0; i < ztoneVariants; i++) {
                for (ItemStack ingredient : itemMap.get(name)) {
                    GT_Values.RA.stdBuilder()
                            .itemInputs(
                                    GT_ModHandler.getModItem(ZTones.ID, "stoneTile", 4L, 0),
                                    ingredient,
                                    GT_Utility.getIntegratedCircuit(i == 0 ? 24 : i))
                            .itemOutputs(GT_ModHandler.getModItem(ZTones.ID, "tile." + name + "Block", 8L, i))
                            .duration(10 * SECONDS).eut(16).addTo(assemblerRecipes);
                }
            }
        }
        for (String name : zblockName) {
            for (int i = 0; i < ztoneVariants; i++) {
                for (ItemStack ingredient : zitemMap.get(name)) {
                    GT_Values.RA.stdBuilder()
                            .itemInputs(
                                    GT_ModHandler.getModItem(ZTones.ID, "auroraBlock", 4L, 0),
                                    ingredient,
                                    GT_Utility.getIntegratedCircuit(i == 0 ? 24 : i))
                            .itemOutputs(GT_ModHandler.getModItem(ZTones.ID, "tile." + name + "Block", 8L, i))
                            .duration(10 * SECONDS).eut(16).addTo(assemblerRecipes);
                }
            }
        }
        for (int i = 0; i < ztoneVariants; i++) {
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(ZTones.ID, "auroraBlock", 1L, 0),
                            new ItemStack(Blocks.glass, 4, 0),
                            GT_Utility.getIntegratedCircuit(i == 0 ? 24 : i))
                    .itemOutputs(GT_ModHandler.getModItem(ZTones.ID, "tile.glaxx", 8L, i)).duration(10 * SECONDS)
                    .eut(16).addTo(assemblerRecipes);
        }
    }

    private void makeGalacticraftRocketRecipes() {
        if (!GalaxySpace.isModLoaded()) {
            return;
        }

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUIVBase, 30L),
                        GT_OreDictUnificator.get(OrePrefixes.pipeTiny, MaterialsUEVplus.TranscendentMetal, 20L),
                        ItemList.Electric_Pump_UIV.get(1L),
                        GT_Utility.getIntegratedCircuit(9))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUIV, 30L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("liquid helium"), 34000))
                .duration(2 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_UIV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(GalaxySpace.ID, "item.CompressedPlates", 1L, 7),
                        GT_ModHandler.getModItem(GalaxySpace.ID, "item.CompressedPlates", 1L, 3))
                .itemOutputs(CustomItemList.LeadOriharukonPlate.get(2L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(assemblerRecipes);

        // rocket parts

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(GalaxySpace.ID, "item.CompressedDualBronze", 1L, 0),
                        GT_ModHandler.getModItem(GalaxySpace.ID, "item.CompressedDualAluminium", 1L, 0),
                        GT_ModHandler.getModItem(GalaxySpace.ID, "item.CompressedCoal", 1L, 0),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.RawSDHCAlloy.get(1L)).fluidInputs(Materials.StainlessSteel.getMolten(72L))
                .duration(20 * TICKS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(GalaxySpace.ID, "item.CompressedDualBronze", 1L, 0),
                        GT_ModHandler.getModItem(GalaxySpace.ID, "item.CompressedDualAluminium", 1L, 0),
                        GT_ModHandler.getModItem(GalaxySpace.ID, "item.ModuleSmallCanister", 1L, 0),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_ModHandler.getModItem(GalaxySpace.ID, "item.ModuleSmallFuelCanister", 1L, 0))
                .fluidInputs(Materials.StainlessSteel.getMolten(72L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(GalaxySpace.ID, "item.ModuleSmallFuelCanister", 1L, 0),
                        CustomItemList.TitaniumDualCompressedPlates.get(1),
                        CustomItemList.DeshDualCompressedPlates.get(1),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(CustomItemList.MediumFuelCanister.get(1)).fluidInputs(Materials.Titanium.getMolten(72L))
                .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.MediumFuelCanister.get(1),
                        CustomItemList.QuantinumDualCompressedPlates.get(1),
                        CustomItemList.IceDualCompressedPlates.get(1),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(CustomItemList.LargeFuelCanister.get(1L)).fluidInputs(Materials.Chrome.getMolten(72L))
                .duration(20 * TICKS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.LargeFuelCanister.get(1),
                        CustomItemList.MytrylDualCompressedPlates.get(1),
                        CustomItemList.MysteriousCrystalDualCompressedPlates.get(1),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(CustomItemList.ExtraLargeFuelCanister.get(1L))
                .fluidInputs(Materials.Iridium.getMolten(72L)).duration(20 * TICKS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);
        // Engine

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(GalaxySpace.ID, "item.CompressedSDHD120", 2L, 0),
                        GT_ModHandler.getModItem(GalacticraftCore.ID, "item.heavyPlating", 4L, 0),
                        GT_ModHandler.getModItem(GalacticraftCore.ID, "item.oilCanisterPartial", 1L, 1001),
                        ItemList.Casing_Firebox_Steel.get(1L),
                        ItemList.Cover_ActivityDetector.get(1L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(GT_ModHandler.getModItem(GalacticraftCore.ID, "item.engine", 1L, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(GalacticraftCore.ID, "item.engine", 2L, 1),
                        GT_ModHandler.getModItem(GalacticraftCore.ID, "item.engine", 2L, 0),
                        GT_ModHandler.getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 5L, 0),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(GT_ModHandler.getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1L, 1))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.Tier2Booster.get(2),
                        GT_ModHandler.getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 2L, 1),
                        CustomItemList.HeavyDutyPlateTier5.get(5),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(CustomItemList.HeavyDutyRocketEngineTier3.get(1L)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.Tier3Booster.get(2),
                        CustomItemList.HeavyDutyRocketEngineTier3.get(2L),
                        CustomItemList.HeavyDutyPlateTier7.get(5),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(CustomItemList.HeavyDutyRocketEngineTier4.get(1L)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        // nose cones

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler
                                .getModItem(ProjectRedIllumination.ID, "projectred.illumination.cagelamp2.inv", 1L, 14),
                        GT_ModHandler.getModItem(GalacticraftCore.ID, "item.heavyPlating", 4L, 0),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(GT_ModHandler.getModItem(GalacticraftCore.ID, "item.noseCone", 1L, 0))
                .fluidInputs(Materials.StainlessSteel.getMolten(36L)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(GalacticraftCore.ID, "item.noseCone", 1L, 0),
                        GT_ModHandler.getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 4L, 0),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(GT_ModHandler.getModItem(GalacticraftMars.ID, "item.heavyNoseCone", 1L, 0))
                .fluidInputs(Materials.Titanium.getMolten(36L)).duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(GalacticraftMars.ID, "item.heavyNoseCone", 1L, 0),
                        CustomItemList.HeavyDutyPlateTier5.get(4),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(CustomItemList.HeavyDutyNoseConeTier3.get(1L))
                .fluidInputs(Materials.TungstenSteel.getMolten(36L)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.HeavyDutyNoseConeTier3.get(1L),
                        CustomItemList.HeavyDutyPlateTier7.get(4),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(CustomItemList.HeavyDutyNoseConeTier4.get(1L))
                .fluidInputs(Materials.NaquadahAlloy.getMolten(36L)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        // rocket fins

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(GalacticraftCore.ID, "item.basicItem", 2L, 9),
                        GT_ModHandler.getModItem(GalacticraftCore.ID, "item.heavyPlating", 4L, 0),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(GT_ModHandler.getModItem(GalacticraftCore.ID, "item.rocketFins", 1L, 0))
                .duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(GalacticraftMars.ID, "item.null", 2L, 3),
                        GT_ModHandler.getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 4L, 0),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(GT_ModHandler.getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1L, 2))
                .duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.HeavyDutyPlateTier4.get(2),
                        CustomItemList.HeavyDutyPlateTier5.get(4),
                        GT_ModHandler.getModItem(GalaxySpace.ID, "item.CompressedSDHD120", 1L, 0),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(CustomItemList.HeavyDutyRocketFinsTier3.get(1L)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.HeavyDutyPlateTier6.get(2),
                        CustomItemList.HeavyDutyPlateTier7.get(4),
                        GT_ModHandler.getModItem(GalaxySpace.ID, "item.CompressedSDHD120", 1L, 0),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(CustomItemList.HeavyDutyRocketFinsTier4.get(1L)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        // // booster

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(GalacticraftCore.ID, "item.meteoricIronIngot", 3L, 1),
                        GT_ModHandler.getModItem(GalacticraftCore.ID, "item.heavyPlating", 4L, 0),
                        GT_ModHandler.getModItem(GalacticraftCore.ID, "item.airVent", 1L, 0),
                        GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(GT_ModHandler.getModItem(GalacticraftCore.ID, "item.engine", 1L, 1))
                .fluidInputs(Materials.Fuel.getFluid(1000L)).duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.LedoxCompressedPlate.get(3),
                        GT_ModHandler.getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 4L, 0),
                        GT_ModHandler.getModItem(GalacticraftCore.ID, "item.engine", 1L, 1),
                        GT_ModHandler.getModItem(GalaxySpace.ID, "item.CompressedSDHD120", 1L, 0),
                        GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(CustomItemList.Tier2Booster.get(1L)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.MytrylCompressedPlate.get(3),
                        CustomItemList.HeavyDutyPlateTier5.get(4),
                        CustomItemList.Tier2Booster.get(1L),
                        GT_ModHandler.getModItem(GalaxySpace.ID, "item.CompressedSDHD120", 1L, 0),
                        GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(CustomItemList.Tier3Booster.get(1L)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.BlackPlutoniumCompressedPlate.get(3),
                        CustomItemList.HeavyDutyPlateTier7.get(4),
                        CustomItemList.Tier3Booster.get(1L),
                        GT_ModHandler.getModItem(GalaxySpace.ID, "item.CompressedSDHD120", 1L, 0),
                        GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(CustomItemList.Tier4Booster.get(1L)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

    }

    private void makeIronTanksRecipes() {
        if (!IronTanks.isModLoaded() || !BuildCraftFactory.isModLoaded()) {
            return;
        }
        // Copper Tank

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BuildCraftFactory.ID, "tankBlock", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(GT_ModHandler.getModItem(IronTanks.ID, "copperTank", 1L, 0))
                .fluidInputs(Materials.Glass.getMolten(144L)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Iron Tank

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BuildCraftFactory.ID, "tankBlock", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(GT_ModHandler.getModItem(IronTanks.ID, "ironTank", 1L, 0))
                .fluidInputs(Materials.Glass.getMolten(144L)).duration(20 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Steel Tank

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BuildCraftFactory.ID, "tankBlock", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(GT_ModHandler.getModItem(IronTanks.ID, "silverTank", 1L, 0))
                .fluidInputs(Materials.Glass.getMolten(144L)).duration(25 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Gold Tank

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BuildCraftFactory.ID, "tankBlock", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(GT_ModHandler.getModItem(IronTanks.ID, "goldTank", 1L, 0))
                .fluidInputs(Materials.Glass.getMolten(144L)).duration(30 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Diamond Tank

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BuildCraftFactory.ID, "tankBlock", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(GT_ModHandler.getModItem(IronTanks.ID, "diamondTank", 1L, 0))
                .fluidInputs(Materials.Glass.getMolten(144L)).duration(40 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Obsidian Tank

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BuildCraftFactory.ID, "tankBlock", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Obsidian, 1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(GT_ModHandler.getModItem(IronTanks.ID, "obsidianTank", 1L, 0))
                .fluidInputs(Materials.Glass.getMolten(144L)).duration(45 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Aluminium Tank

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BuildCraftFactory.ID, "tankBlock", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Aluminium, 1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(GT_ModHandler.getModItem(IronTanks.ID, "emeraldTank", 1L, 0))
                .fluidInputs(Materials.Glass.getMolten(144L)).duration(50 * SECONDS).eut(60).addTo(assemblerRecipes);
        // Stainless Steel Tank

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BuildCraftFactory.ID, "tankBlock", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.StainlessSteel, 1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(GT_ModHandler.getModItem(IronTanks.ID, "stainlesssteelTank", 1L, 0))
                .fluidInputs(Materials.Glass.getMolten(144L)).duration(55 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // Titanium Tank

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BuildCraftFactory.ID, "tankBlock", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Titanium, 1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(GT_ModHandler.getModItem(IronTanks.ID, "titaniumTank", 1L, 0))
                .fluidInputs(Materials.Glass.getMolten(144L)).duration(60 * SECONDS).eut(256).addTo(assemblerRecipes);
        // Tungsten Steel Tank

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(BuildCraftFactory.ID, "tankBlock", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TungstenSteel, 1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(GT_ModHandler.getModItem(IronTanks.ID, "tungstensteelTank", 1L, 0))
                .fluidInputs(Materials.Glass.getMolten(144L)).duration(1 * MINUTES + 5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        // --- Upgrade Glass to Copper Tank

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(GT_ModHandler.getModItem(IronTanks.ID, "glassCopperUpgrade", 1L, 0))
                .fluidInputs(Materials.Glass.getMolten(72L)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // --- Upgrade Glass to Iron Tank

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(GT_ModHandler.getModItem(IronTanks.ID, "glassIronUpgrade", 1L, 0))
                .fluidInputs(Materials.Glass.getMolten(72L)).duration(20 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // --- Upgrade Copper to Iron Tank

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(GT_ModHandler.getModItem(IronTanks.ID, "copperIronUpgrade", 1L, 0))
                .fluidInputs(Materials.Glass.getMolten(72L)).duration(25 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // --- Upgrade Copper to Steel Tank

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(GT_ModHandler.getModItem(IronTanks.ID, "copperSilverUpgrade", 1L, 0))
                .fluidInputs(Materials.Glass.getMolten(72L)).duration(30 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // --- Upgrade Iron to Gold Tank

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(GT_ModHandler.getModItem(IronTanks.ID, "ironGoldUpgrade", 1L, 0))
                .fluidInputs(Materials.Glass.getMolten(72L)).duration(35 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // --- Upgrade Steel to Gold Tank

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(GT_ModHandler.getModItem(IronTanks.ID, "silverGoldUpgrade", 1L, 0))
                .fluidInputs(Materials.Glass.getMolten(72L)).duration(35 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // --- Upgrade Steel to Diamond Tank

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 2L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(GT_ModHandler.getModItem(IronTanks.ID, "silverDiamondUpgrade", 1L, 0))
                .fluidInputs(Materials.Glass.getMolten(72L)).duration(40 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // --- Upgrade Diamond to Obsidian

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Obsidian, 1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(GT_ModHandler.getModItem(IronTanks.ID, "diamondObsidianUpgrade", 1L, 0))
                .fluidInputs(Materials.Glass.getMolten(72L)).duration(45 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // --- Upgrade Diamond to Aluminium Tank

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Aluminium, 1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(GT_ModHandler.getModItem(IronTanks.ID, "diamondEmeraldUpgrade", 1L, 0))
                .fluidInputs(Materials.Glass.getMolten(72L)).duration(50 * SECONDS).eut(60).addTo(assemblerRecipes);
        // --- Upgrade Aluminium to Stainless Steel Tank

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.StainlessSteel, 1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(GT_ModHandler.getModItem(IronTanks.ID, "emeraldStainlesssteelUpgrade", 1L, 0))
                .fluidInputs(Materials.Glass.getMolten(72L)).duration(55 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // --- Upgrade Stainless Steel to Titanium Tank

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Titanium, 1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(GT_ModHandler.getModItem(IronTanks.ID, "stainlesssteelTitaniumUpgrade", 1L, 0))
                .fluidInputs(Materials.Glass.getMolten(72L)).duration(60 * SECONDS).eut(256).addTo(assemblerRecipes);
        // --- Upgrade Titanium to Tungsten Steel Tank

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TungstenSteel, 1L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(GT_ModHandler.getModItem(IronTanks.ID, "titaniumTungstensteelUpgrade", 1L, 0))
                .fluidInputs(Materials.Glass.getMolten(72L)).duration(1 * MINUTES + 5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
    }

    private void makeChiselRecipes() {
        if (!Chisel.isModLoaded()) {
            return;
        }
        // --- Items
        // Chisel

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "chisel", 1L, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Obsidian Chisel

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.WroughtIron, 2L))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "obsidianChisel", 1L, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Diamond Chisel

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2L))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "diamondChisel", 1L, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Nether Star Chisel

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Bedrockium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.VanadiumSteel, 2L))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "netherStarChisel", 1L, 0)).duration(20 * MINUTES)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // --- Blocks
        // Factory Block

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone, 4),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "factoryblock", 16L, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Technical Block

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone, 5),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "technical", 16L, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Tyrian

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone, 4),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L),
                        GT_Utility.getIntegratedCircuit(14))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "tyrian", 8L, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Futura

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone, 4),
                        new ItemStack(Items.redstone, 1),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "futura", 8L, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Fantasy Block

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone, 4),
                        new ItemStack(Items.gold_nugget, 1),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "fantasyblock", 8L, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Grimstone

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone, 4),
                        new ItemStack(Items.coal, 1),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "grimstone", 8L, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Hex Plating

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone, 2),
                        new ItemStack(Items.coal, 4),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "hexPlating", 4L, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Holystone

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone, 4),
                        new ItemStack(Items.feather, 1),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "holystone", 8L, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Laboratory Block

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone, 4),
                        new ItemStack(Items.quartz, 1),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "laboratoryblock", 8L, 0)).duration(5 * SECONDS)
                .eut(24).addTo(assemblerRecipes);
        // Lavastone

        GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone, 4), GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "lavastone", 8L, 0))
                .fluidInputs(Materials.Lava.getFluid(1000L)).duration(5 * SECONDS).eut(24).addTo(assemblerRecipes);
        // Paperwall

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.paper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "paperwall", 8L, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Paperwall Block

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.paper, 4),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "paperwall_block", 8L, 0)).duration(5 * SECONDS)
                .eut(24).addTo(assemblerRecipes);
        // Road Lines

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.redstone, 3),
                        GT_OreDictUnificator.get(ItemList.Dye_Bonemeal.get(3L)),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "road_line", 8L, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Temple Block

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone, 4),
                        GT_OreDictUnificator.get(new ItemStack(Items.dye, 1, 4)),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "templeblock", 8L, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Mossy Temple Block

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(Chisel.ID, "templeblock", 8L, 0),
                        GT_ModHandler.getModItem(BiomesOPlenty.ID, "moss", 8L, 0),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "mossy_templeblock", 4L, 0)).duration(5 * SECONDS)
                .eut(24).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone, 4),
                        GT_OreDictUnificator.get(new ItemStack(Items.dye, 1, 9)),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "valentines", 8L, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Voidstone

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone, 2),
                        new ItemStack(Blocks.obsidian, 2),
                        new ItemStack(Items.ender_pearl, 1),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "voidstone", 8L, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Energised Voidstone

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone, 2),
                        new ItemStack(Blocks.obsidian, 2),
                        new ItemStack(Items.ender_pearl, 1),
                        new ItemStack(Items.glowstone_dust, 1),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "voidstone2", 8L, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Warning Sign

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone, 2),
                        new ItemStack(Items.sign, 1),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "warningSign", 4L, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Waterstone

        GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone, 4), GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "waterstone", 8L, 0))
                .fluidInputs(Materials.Water.getFluid(1000L)).duration(5 * SECONDS).eut(24).addTo(assemblerRecipes);

        // Hempcrete Sand
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.gravel, 3, 0),
                        GT_OreDictUnificator.get("sand", 3L),
                        GT_OreDictUnificator.get("itemWheat", 2L),
                        ItemList.IC2_Plantball.get(1L))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "hempcretesand", 12)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Anti Block
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone, 4),
                        new ItemStack(Items.glowstone_dust, 1),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "antiBlock", 8L, 15)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);

        // Carpet
        for (int meta = 0; meta < 16; ++meta) {
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Blocks.wool, 4, meta),
                            new ItemStack(Items.string, 1),
                            GT_Utility.getIntegratedCircuit(24))
                    .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "carpet_block", 8L, meta)).duration(5 * SECONDS)
                    .eut(24).addTo(assemblerRecipes);
        }

        // Cubits
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone, 4),
                        new ItemStack(Blocks.wool, 1, 15),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "cubit", 8L, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);

        // Fantasy Block
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone, 4),
                        new ItemStack(Items.gold_nugget, 1),
                        new ItemStack(Items.dye, 1, 15),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "fantasyblock2", 8L, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);

        // Neonite
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.emerald, 8),
                        new ItemStack(Items.glowstone_dust, 1),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "neonite", 8L, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);

        // GloTek
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.emerald, 8),
                        new ItemStack(Items.glowstone_dust, 2),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "glotek", 8L, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);

        // Rebellious Block
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 2),
                        new ItemStack(Items.gold_nugget, 1),
                        GT_Utility.getIntegratedCircuit(23))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "rebel", 32L, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);

        // Structural Concrete
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.gravel, 5),
                        new ItemStack(Blocks.sand, 2),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "nucrete", 16L, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);

        // Purpur Block
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.end_stone, 4),
                        new ItemStack(Items.dye, 4, 5),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "purpur", 8L, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);

        // Svelstone
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone, 4),
                        GT_ModHandler.getModItem(Chisel.ID, "andesite", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "sveltstone", 8L, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);

        // Woolen Clay
        for (int meta = 0; meta < 16; ++meta) {
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Blocks.wool, 2, meta),
                            new ItemStack(Blocks.stained_hardened_clay, 2, meta),
                            GT_Utility.getIntegratedCircuit(24))
                    .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "woolen_clay", 8L, meta)).duration(5 * SECONDS)
                    .eut(24).addTo(assemblerRecipes);
        }
    }

    private void makeReinforcedIronPlateRecipes() {

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 4),
                        CustomItemList.AluminiumIronPlate.get(1))
                .itemOutputs(CustomItemList.ReinforcedAluminiumIronPlate.get(1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.SiliconSG, 4),
                        CustomItemList.TitaniumIronPlate.get(1))
                .itemOutputs(CustomItemList.ReinforcedTitaniumIronPlate.get(1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 4),
                        CustomItemList.TungstenIronPlate.get(1))
                .itemOutputs(CustomItemList.ReinforcedTungstenIronPlate.get(1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 4),
                        CustomItemList.TungstenSteelIronPlate.get(1))
                .itemOutputs(CustomItemList.ReinforcedTungstenSteelIronPlate.get(1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 4),
                        CustomItemList.ChromeIronPlate.get(1))
                .itemOutputs(CustomItemList.ReinforcedChromeIronPlate.get(1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartIridium", 4),
                        GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 6))
                .itemOutputs(GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 7))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.MysteriousCrystal, 4),
                        CustomItemList.NaquadriaIronPlate.get(1))
                .itemOutputs(CustomItemList.ReinforcedNaquadriaIronPlate.get(1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 4),
                        CustomItemList.NeutroniumIronPlate.get(1))
                .itemOutputs(CustomItemList.ReinforcedNeutroniumIronPlate.get(1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_UHV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.DraconiumAwakened, 4),
                        CustomItemList.BedrockiumIronPlate.get(1))
                .itemOutputs(CustomItemList.ReinforcedBedrockiumIronPlate.get(1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_UEV).addTo(assemblerRecipes);

    }

    private void makeMixedMetalIngotRecipes() {

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyIron, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 1L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyIron, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 1L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyIron, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 1L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyIron, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 1L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyIron, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 1L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyIron, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 1L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Nickel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 1L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Nickel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 1L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Nickel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 1L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Nickel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 1L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Nickel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 1L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Nickel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 1L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Invar, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 2L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Invar, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 2L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Invar, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 2L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Invar, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 2L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 2L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 2L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 2L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 2L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Invar, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Invar, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 4L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 4L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 4L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 4L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 4L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 4L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 5L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 5L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 5L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 5L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 6L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 6L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 8L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 8L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 8L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 10L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 10L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 10L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnnealedCopper, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 12L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 12L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AstralSilver, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 12L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnnealedCopper, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 14L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 14L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AstralSilver, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 14L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSG, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnnealedCopper, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 16L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSG, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 16L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSG, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AstralSilver, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 16L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSE, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnnealedCopper, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 18L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSE, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 18L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSE, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AstralSilver, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 18L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSG, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnnealedCopper, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 20L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSG, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 20L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSG, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AstralSilver, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 20L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSG, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 22L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSE, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 24L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSE, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 26L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmiridium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSG, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 28L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmiridium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSE, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 30L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmiridium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSE, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 32L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 34L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 36L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Draconium, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 38L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 40L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Sunnarium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 42L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Sunnarium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Draconium, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 44L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.DraconiumAwakened, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSS, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 48L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.DraconiumAwakened, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 52L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.DraconiumAwakened, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 56L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.getIntegratedCircuit(3),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.DraconiumAwakened, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 64L, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

    }

    private void makeLootBagRecipes() {
        if (!EnhancedLootBags.isModLoaded()) {
            return;
        }
        // Basic -> Steam Lootbags
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnhancedLootBags.ID, "lootbag", 3, 1, missing))
                .itemOutputs(getModItem(EnhancedLootBags.ID, "lootbag", 1, 2, missing)).duration(SECONDS * 30)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Steam -> LV Lootbags
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnhancedLootBags.ID, "lootbag", 3, 2, missing))
                .itemOutputs(getModItem(EnhancedLootBags.ID, "lootbag", 1, 4, missing)).duration(SECONDS * 30)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // LV -> MV Lootbags
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnhancedLootBags.ID, "lootbag", 3, 4, missing))
                .itemOutputs(getModItem(EnhancedLootBags.ID, "lootbag", 1, 5, missing)).duration(SECONDS * 30)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // MV -> HV Lootbags
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnhancedLootBags.ID, "lootbag", 3, 5, missing))
                .itemOutputs(getModItem(EnhancedLootBags.ID, "lootbag", 1, 6, missing)).duration(SECONDS * 30)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // HV -> EV Lootbags
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnhancedLootBags.ID, "lootbag", 3, 6, missing))
                .itemOutputs(getModItem(EnhancedLootBags.ID, "lootbag", 1, 7, missing)).duration(SECONDS * 30)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        // EV -> IV Lootbags
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnhancedLootBags.ID, "lootbag", 3, 7, missing))
                .itemOutputs(getModItem(EnhancedLootBags.ID, "lootbag", 1, 8, missing)).duration(SECONDS * 30)
                .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);
        // IV -> LuV Lootbags
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnhancedLootBags.ID, "lootbag", 3, 8, missing))
                .itemOutputs(getModItem(EnhancedLootBags.ID, "lootbag", 1, 41, missing)).duration(SECONDS * 30)
                .eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);
        // Forest Ranger Basic -> Forest Ranger Advanced Lootbags
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnhancedLootBags.ID, "lootbag", 3, 19, missing))
                .itemOutputs(getModItem(EnhancedLootBags.ID, "lootbag", 1, 20, missing)).duration(SECONDS * 30)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Forest Ranger Advanced -> Forest Ranger Expert Lootbags
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnhancedLootBags.ID, "lootbag", 3, 20, missing))
                .itemOutputs(getModItem(EnhancedLootBags.ID, "lootbag", 1, 21, missing)).duration(SECONDS * 30)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // BM Novice -> BM Adept Lootbags
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnhancedLootBags.ID, "lootbag", 3, 16, missing))
                .itemOutputs(getModItem(EnhancedLootBags.ID, "lootbag", 1, 17, missing)).duration(SECONDS * 30)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // BM Adept -> BM Master Lootbags
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnhancedLootBags.ID, "lootbag", 3, 17, missing))
                .itemOutputs(getModItem(EnhancedLootBags.ID, "lootbag", 1, 18, missing)).duration(SECONDS * 30)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Bees Basic -> Bees Advanced Lootbags
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnhancedLootBags.ID, "lootbag", 3, 25, missing))
                .itemOutputs(getModItem(EnhancedLootBags.ID, "lootbag", 1, 26, missing)).duration(SECONDS * 30)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Bees Advanced -> Bees Expert Lootbags
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnhancedLootBags.ID, "lootbag", 3, 26, missing))
                .itemOutputs(getModItem(EnhancedLootBags.ID, "lootbag", 1, 27, missing)).duration(SECONDS * 30)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Space Invaders Moon -> Space Invaders Mars Lootbags
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnhancedLootBags.ID, "lootbag", 3, 22, missing))
                .itemOutputs(getModItem(EnhancedLootBags.ID, "lootbag", 1, 23, missing)).duration(SECONDS * 30)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        // Space Invaders Mars -> Space Invaders Asteroids Lootbags
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnhancedLootBags.ID, "lootbag", 3, 23, missing))
                .itemOutputs(getModItem(EnhancedLootBags.ID, "lootbag", 1, 24, missing)).duration(SECONDS * 30)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        // Fast Food -> Slow Food Lootbags
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnhancedLootBags.ID, "lootbag", 3, 28, missing))
                .itemOutputs(getModItem(EnhancedLootBags.ID, "lootbag", 1, 29, missing)).duration(SECONDS * 30)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Slow Food -> Haute Cuisine Lootbags
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnhancedLootBags.ID, "lootbag", 3, 29, missing))
                .itemOutputs(getModItem(EnhancedLootBags.ID, "lootbag", 1, 30, missing)).duration(SECONDS * 30)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Haute Cuisine -> Dessert Lootbags
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnhancedLootBags.ID, "lootbag", 3, 30, missing))
                .itemOutputs(getModItem(EnhancedLootBags.ID, "lootbag", 1, 31, missing)).duration(SECONDS * 30)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Transportation 3 -> 2 Lootbags
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnhancedLootBags.ID, "lootbag", 3, 32, missing))
                .itemOutputs(getModItem(EnhancedLootBags.ID, "lootbag", 1, 33, missing)).duration(SECONDS * 30)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Transportation 2 -> 1 Lootbags
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnhancedLootBags.ID, "lootbag", 3, 33, missing))
                .itemOutputs(getModItem(EnhancedLootBags.ID, "lootbag", 1, 34, missing)).duration(SECONDS * 30)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Magic Novice -> Magic Adept Lootbags
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnhancedLootBags.ID, "lootbag", 3, 9, missing))
                .itemOutputs(getModItem(EnhancedLootBags.ID, "lootbag", 1, 10, missing)).duration(SECONDS * 30)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Magic Adept -> Magic Master Lootbags
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnhancedLootBags.ID, "lootbag", 3, 10, missing))
                .itemOutputs(getModItem(EnhancedLootBags.ID, "lootbag", 1, 11, missing)).duration(SECONDS * 30)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Magic Master -> Magic Grandmaster Lootbags
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnhancedLootBags.ID, "lootbag", 3, 11, missing))
                .itemOutputs(getModItem(EnhancedLootBags.ID, "lootbag", 1, 12, missing)).duration(SECONDS * 30)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Magic Grandmaster -> Magic Grandmaster Unique Lootbags
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnhancedLootBags.ID, "lootbag", 16, 12, missing))
                .itemOutputs(getModItem(EnhancedLootBags.ID, "lootbag", 1, 13, missing)).duration(SECONDS * 30)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
    }

    private void makeCoinRecipes() {
        // Coins

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinAdventure.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinAdventureI.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.CoinAdventureI.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinAdventureII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.CoinAdventureII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinAdventureIII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.CoinAdventureIII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinAdventureIV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinBees.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinBeesI.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinBeesI.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinBeesII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinBeesII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinBeesIII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinBeesIII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinBeesIV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinBlood.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinBloodI.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinBloodI.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinBloodII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinBloodII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinBloodIII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinBloodIII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinBloodIV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinChemist.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinChemistI.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinChemistI.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinChemistII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinChemistII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinChemistIII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.CoinChemistIII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinChemistIV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinCook.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinCookI.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinCookI.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinCookII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinCookII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinCookIII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinCookIII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinCookIV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.CoinDarkWizard.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinDarkWizardI.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.CoinDarkWizardI.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinDarkWizardII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.CoinDarkWizardII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinDarkWizardIII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.CoinDarkWizardIII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinDarkWizardIV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinFarmer.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinFarmerI.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinFarmerI.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinFarmerII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinFarmerII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinFarmerIII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinFarmerIII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinFarmerIV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinForestry.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinForestryI.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinForestryI.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinForestryII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.CoinForestryII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinForestryIII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.CoinForestryIII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinForestryIV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinSpace.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinSpaceI.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinSpaceI.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinSpaceII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinSpaceII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinSpaceIII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinSpaceIII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinSpaceIV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinSurvivor.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinSurvivorI.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinSurvivorI.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinSurvivorII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.CoinSurvivorII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinSurvivorIII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.CoinSurvivorIII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinSurvivorIV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.CoinTechnician.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinTechnicianI.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.CoinTechnicianI.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinTechnicianII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.CoinTechnicianII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinTechnicianIII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.CoinTechnicianIII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinTechnicianIV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinSmith.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinSmithI.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinSmithI.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinSmithII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinSmithII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinSmithIII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinSmithIII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinSmithIV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinWitch.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinWitchI.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinWitchI.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinWitchII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinWitchII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinWitchIII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinWitchIII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinWitchIV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinFlower.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinFlowerI.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinFlowerI.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinFlowerII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinFlowerII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinFlowerIII.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinFlowerIII.get(10L), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(CustomItemList.CoinFlowerIV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinAdventureI.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinAdventure.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinAdventureII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinAdventureI.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.CoinAdventureIII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinAdventureII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinAdventureIV.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinAdventureIII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinBeesI.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinBees.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinBeesII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinBeesI.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinBeesIII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinBeesII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinBeesIV.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinBeesIII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinBloodI.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinBlood.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinBloodII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinBloodI.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinBloodIII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinBloodII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinBloodIV.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinBloodIII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinChemistI.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinChemist.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinChemistII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinChemistI.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinChemistIII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinChemistII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinChemistIV.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinChemistIII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinCookI.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinCook.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinCookII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinCookI.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinCookIII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinCookII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinCookIV.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinCookIII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinDarkWizardI.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinDarkWizard.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.CoinDarkWizardII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinDarkWizardI.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.CoinDarkWizardIII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinDarkWizardII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.CoinDarkWizardIV.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinDarkWizardIII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinFarmerI.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinFarmer.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinFarmerII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinFarmerI.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinFarmerIII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinFarmerII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinFarmerIV.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinFarmerIII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinForestryI.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinForestry.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinForestryII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinForestryI.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinForestryIII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinForestryII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinForestryIV.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinForestryIII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinSpaceI.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinSpace.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinSpaceII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinSpaceI.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinSpaceIII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinSpaceII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinSpaceIV.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinSpaceIII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinSurvivorI.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinSurvivor.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinSurvivorII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinSurvivorI.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinSurvivorIII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinSurvivorII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinSurvivorIV.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinSurvivorIII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinTechnicianI.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinTechnician.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.CoinTechnicianII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinTechnicianI.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.CoinTechnicianIII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinTechnicianII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.CoinTechnicianIV.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinTechnicianIII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinSmithI.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinSmith.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinSmithII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinSmithI.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinSmithIII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinSmithII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinSmithIV.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinSmithIII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinWitchI.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinWitch.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinWitchII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinWitchI.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinWitchIII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinWitchII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinWitchIV.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinWitchIII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinFlowerI.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinFlower.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinFlowerII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinFlowerI.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinFlowerIII.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinFlowerII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CoinFlowerIV.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.CoinFlowerIII.get(10L)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

    }

    private void makePistonRecipes() {
        // Vanilla Piston Assembler recipe
        List<ItemStack> fenceWood = OreDictionary.getOres("fenceWood");
        for (ItemStack oreStack : fenceWood) {

            ItemStack stack = oreStack.splitStack(1);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Blocks.cobblestone, 1, 0),
                            GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                            stack,
                            ItemList.Plank_Oak.get(6L),
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Blocks.cobblestone, 1, 0),
                            GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                            stack,
                            ItemList.Plank_Spruce.get(6L),
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Blocks.cobblestone, 1, 0),
                            GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                            stack,
                            ItemList.Plank_Birch.get(6L),
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Blocks.cobblestone, 1, 0),
                            GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                            stack,
                            ItemList.Plank_Jungle.get(6L),
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Blocks.cobblestone, 1, 0),
                            GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                            stack,
                            ItemList.Plank_Acacia.get(6L),
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Blocks.cobblestone, 1, 0),
                            GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                            stack,
                            ItemList.Plank_DarkOak.get(6L),
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

            if (Forestry.isModLoaded()) {

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                new ItemStack(Blocks.cobblestone, 1, 0),
                                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                                stack,
                                ItemList.Plank_Larch.get(6L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                new ItemStack(Blocks.cobblestone, 1, 0),
                                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                                stack,
                                ItemList.Plank_Teak.get(6L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                new ItemStack(Blocks.cobblestone, 1, 0),
                                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                                stack,
                                ItemList.Plank_Acacia_Green.get(6L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                new ItemStack(Blocks.cobblestone, 1, 0),
                                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                                stack,
                                ItemList.Plank_Lime.get(6L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                new ItemStack(Blocks.cobblestone, 1, 0),
                                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                                stack,
                                ItemList.Plank_Chestnut.get(6L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                new ItemStack(Blocks.cobblestone, 1, 0),
                                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                                stack,
                                ItemList.Plank_Wenge.get(6L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                new ItemStack(Blocks.cobblestone, 1, 0),
                                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                                stack,
                                ItemList.Plank_Baobab.get(6L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                new ItemStack(Blocks.cobblestone, 1, 0),
                                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                                stack,
                                ItemList.Plank_Sequoia.get(6L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                new ItemStack(Blocks.cobblestone, 1, 0),
                                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                                stack,
                                ItemList.Plank_Kapok.get(6L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                new ItemStack(Blocks.cobblestone, 1, 0),
                                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                                stack,
                                ItemList.Plank_Ebony.get(6L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                new ItemStack(Blocks.cobblestone, 1, 0),
                                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                                stack,
                                ItemList.Plank_Mahagony.get(6L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                new ItemStack(Blocks.cobblestone, 1, 0),
                                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                                stack,
                                ItemList.Plank_Balsa.get(6L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                new ItemStack(Blocks.cobblestone, 1, 0),
                                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                                stack,
                                ItemList.Plank_Willow.get(6L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                new ItemStack(Blocks.cobblestone, 1, 0),
                                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                                stack,
                                ItemList.Plank_Walnut.get(6L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                new ItemStack(Blocks.cobblestone, 1, 0),
                                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                                stack,
                                ItemList.Plank_Greenheart.get(6L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                new ItemStack(Blocks.cobblestone, 1, 0),
                                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                                stack,
                                ItemList.Plank_Cherry.get(6L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                new ItemStack(Blocks.cobblestone, 1, 0),
                                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                                stack,
                                ItemList.Plank_Mahoe.get(6L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                new ItemStack(Blocks.cobblestone, 1, 0),
                                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                                stack,
                                ItemList.Plank_Poplar.get(6L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                new ItemStack(Blocks.cobblestone, 1, 0),
                                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                                stack,
                                ItemList.Plank_Palm.get(6L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                new ItemStack(Blocks.cobblestone, 1, 0),
                                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                                stack,
                                ItemList.Plank_Papaya.get(6L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                new ItemStack(Blocks.cobblestone, 1, 0),
                                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                                stack,
                                ItemList.Plank_Pine.get(6L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                new ItemStack(Blocks.cobblestone, 1, 0),
                                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                                stack,
                                ItemList.Plank_Plum.get(6L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                new ItemStack(Blocks.cobblestone, 1, 0),
                                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                                stack,
                                ItemList.Plank_Maple.get(6L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                new ItemStack(Blocks.cobblestone, 1, 0),
                                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                                stack,
                                ItemList.Plank_Citrus.get(6L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

            }
        }
    }

    private void makeCoilRecipes() {

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Cupronickel, 8L),
                        CustomItemList.AluminoSilicateWool.get(12L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Casing_Coil_Cupronickel.get(1L)).fluidInputs(Materials.Tin.getMolten(288L))
                .duration(5 * SECONDS).eut(7).addTo(assemblerRecipes);
        // TODO: Rework other stuff (that depends on certain Heat Levels, mostly LuV+ stuff) so this can be wrapped into
        // a oneliner.

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Cupronickel, 8L),
                        CustomItemList.MicaInsulatorFoil.get(8L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Casing_Coil_Cupronickel.get(1L)).fluidInputs(Materials.Tin.getMolten(144L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Kanthal, 8L),
                        CustomItemList.MicaInsulatorFoil.get(12L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Casing_Coil_Kanthal.get(1L)).fluidInputs(Materials.Cupronickel.getMolten(144L))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Nichrome, 8L),
                        CustomItemList.MicaInsulatorFoil.get(16L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Casing_Coil_Nichrome.get(1L)).fluidInputs(Materials.Kanthal.getMolten(144L))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.TPV, 8L),
                        CustomItemList.MicaInsulatorFoil.get(20L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Casing_Coil_TungstenSteel.get(1L)).fluidInputs(Materials.Nichrome.getMolten(144L))
                .duration(25 * SECONDS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.HSSG, 8L),
                        CustomItemList.MicaInsulatorFoil.get(24L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Casing_Coil_HSSG.get(1L)).fluidInputs(Materials.TPV.getMolten(144L))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.HSSS, 8L),
                        CustomItemList.MicaInsulatorFoil.get(28L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Casing_Coil_HSSS.get(1L)).fluidInputs(Materials.HSSG.getMolten(144L))
                .duration(35 * SECONDS).eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Naquadah, 8L),
                        CustomItemList.MicaInsulatorFoil.get(32L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Casing_Coil_Naquadah.get(1L)).fluidInputs(Materials.HSSS.getMolten(144L))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.NaquadahAlloy, 8L),
                        CustomItemList.MicaInsulatorFoil.get(36L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Casing_Coil_NaquadahAlloy.get(1L)).fluidInputs(Materials.Naquadah.getMolten(144L))
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Trinium, 8L),
                        CustomItemList.MicaInsulatorFoil.get(40L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Casing_Coil_Trinium.get(1L)).fluidInputs(Materials.NaquadahAlloy.getMolten(144L))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.ElectrumFlux, 8L),
                        CustomItemList.MicaInsulatorFoil.get(44L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Casing_Coil_ElectrumFlux.get(1L)).fluidInputs(Materials.Trinium.getMolten(144L))
                .duration(55 * SECONDS).eut(TierEU.RECIPE_UV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.DraconiumAwakened, 8L),
                        CustomItemList.MicaInsulatorFoil.get(48L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(ItemList.Casing_Coil_AwakenedDraconium.get(1L))
                .fluidInputs(Materials.ElectrumFlux.getMolten(144L)).duration(60 * SECONDS).eut(TierEU.RECIPE_UHV)
                .addTo(assemblerRecipes);

    }

    private void makeNEIPlanetRecipes() {
        if (!NEIOrePlugin.isModLoaded() || !Botania.isModLoaded()) {
            return;
        }

        final OrePrefixes[] allOrePrefixes = { OrePrefixes.ore, OrePrefixes.oreNetherrack, OrePrefixes.oreEndstone,
                OrePrefixes.oreBlackgranite, OrePrefixes.oreRedgranite, OrePrefixes.oreMarble, OrePrefixes.oreBasalt };

        // NEI Ore Plugin planets
        // T0 Planets
        // Overworld
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                        getModItem(Minecraft.ID, "stone", 64, 0),
                        getModItem(Minecraft.ID, "grass", 64, 0),
                        getModItem(Minecraft.ID, "sapling", 1, 0),
                        GT_Utility.getIntegratedCircuit(17))
                .fluidInputs(Materials.Water.getFluid(10000))
                .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_Ow", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Twilight Forest
        if (TwilightForest.isModLoaded()) {
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(Minecraft.ID, "stone", 64, 0),
                            getModItem(Minecraft.ID, "grass", 64, 0),
                            getModItem(TwilightForest.ID, "tile.TFSapling", 1, 1),
                            GT_Utility.getIntegratedCircuit(17))
                    .fluidInputs(Materials.Water.getFluid(10000))
                    .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_TF", 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        }
        // Nether
        if (BiomesOPlenty.isModLoaded()) {
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(Minecraft.ID, "netherrack", 64, 0),
                            getModItem(Minecraft.ID, "soul_sand", 64, 0),
                            getModItem(BiomesOPlenty.ID, "ash", 64, 0),
                            GT_Utility.getIntegratedCircuit(17))
                    .fluidInputs(Materials.Lava.getFluid(10000))
                    .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_Ne", 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        }
        // End
        if (Natura.isModLoaded()) {
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(Minecraft.ID, "end_stone", 64, 0),
                            getModItem(Minecraft.ID, "obsidian", 64, 0),
                            getModItem(Natura.ID, "Cloud", 64, 1),
                            GT_Utility.getIntegratedCircuit(17))
                    .fluidInputs(FluidRegistry.getFluidStack("ender", 10000))
                    .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_ED", 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        }
        // Far End Asteroids
        if (HardcoreEnderExpansion.isModLoaded()) {
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(HardcoreEnderExpansion.ID, "end_stone_terrain", 64, 0),
                            getModItem(HardcoreEnderExpansion.ID, "end_stone_terrain", 64, 1),
                            getModItem(HardcoreEnderExpansion.ID, "end_stone_terrain", 64, 2),
                            GT_Utility.getIntegratedCircuit(17))
                    .fluidInputs(FluidRegistry.getFluidStack("endergoo", 10000))
                    .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_EA", 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        }

        if (GalaxySpace.isModLoaded()) {
            // T1 Planets
            // The Moon
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalacticraftCore.ID, "tile.moonBlock", 64, 3),
                            getModItem(GalacticraftCore.ID, "tile.moonBlock", 64, 4),
                            getModItem(GalacticraftCore.ID, "tile.moonBlock", 64, 14),
                            GT_Utility.getIntegratedCircuit(17))
                    .fluidInputs(Materials.SaltWater.getFluid(10000))
                    .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_Mo", 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
            // T2 Planets
            // Deimos
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalaxySpace.ID, "deimosblocks", 64, 0),
                                getModItem(GalaxySpace.ID, "deimosblocks", 64, 1),
                                GT_OreDictUnificator.get(orePrefix, Materials.Uranium, 64),
                                GT_Utility.getIntegratedCircuit(17))
                        .fluidInputs(Materials.SulfuricAcid.getFluid(10000))
                        .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_De", 1, 0))
                        .duration(15 * SECONDS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
            }
            // Phobos
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalaxySpace.ID, "phobosblocks", 64, 0),
                            getModItem(GalaxySpace.ID, "phobosblocks", 64, 1),
                            getModItem(GalaxySpace.ID, "phobosblocks", 64, 2),
                            GT_Utility.getIntegratedCircuit(17))
                    .fluidInputs(Materials.SulfuricAcid.getFluid(10000))
                    .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_Ph", 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
            // Mars
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalacticraftMars.ID, "tile.mars", 64, 5),
                            getModItem(GalacticraftMars.ID, "tile.mars", 64, 6),
                            getModItem(GalacticraftMars.ID, "tile.mars", 64, 7),
                            GT_Utility.getIntegratedCircuit(17))
                    .fluidInputs(Materials.Chlorobenzene.getFluid(10000))
                    .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_Ma", 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
            // T3 Planets
            // Ceres
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalaxySpace.ID, "ceresblocks", 64, 0),
                            getModItem(GalaxySpace.ID, "ceresblocks", 64, 1),
                            getModItem(GalaxySpace.ID, "ceresblocks", 64, 2),
                            GT_Utility.getIntegratedCircuit(17))
                    .fluidInputs(Materials.Oxygen.getGas(10000))
                    .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_Ce", 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);
            // Callisto
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalaxySpace.ID, "callistoblocks", 64, 0),
                                getModItem(GalaxySpace.ID, "callistoblocks", 64, 1),
                                GT_OreDictUnificator.get(orePrefix, Materials.CallistoIce, 64L),
                                GT_Utility.getIntegratedCircuit(17))
                        .fluidInputs(Materials.LiquidAir.getFluid(10000))
                        .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_Ca", 1, 0))
                        .duration(15 * SECONDS).eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);
            }
            // Asteroids
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalacticraftMars.ID, "tile.asteroidsBlock", 64, 0),
                            getModItem(GalacticraftMars.ID, "tile.asteroidsBlock", 64, 1),
                            getModItem(GalacticraftMars.ID, "tile.denseIce", 64, 0),
                            GT_Utility.getIntegratedCircuit(17))
                    .fluidInputs(FluidRegistry.getFluidStack("ice", 10000))
                    .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_As", 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);
            // Ganymede
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalaxySpace.ID, "ganymedeblocks", 64, 0),
                                getModItem(GalaxySpace.ID, "ganymedeblocks", 64, 1),
                                GT_OreDictUnificator.get(orePrefix, Materials.Platinum, 64L),
                                GT_Utility.getIntegratedCircuit(17))
                        .fluidInputs(Materials.Oxygen.getGas(10000))
                        .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_Ga", 1, 0))
                        .duration(15 * SECONDS).eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);
            }
            // Europa
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalaxySpace.ID, "europagrunt", 64, 0),
                                getModItem(GalaxySpace.ID, "europagrunt", 64, 1),
                                GT_OreDictUnificator.get(orePrefix, Materials.Manganese, 64L),
                                GT_Utility.getIntegratedCircuit(17))
                        .fluidInputs(Materials.Water.getFluid(10000))
                        .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_Eu", 1, 0))
                        .duration(15 * SECONDS).eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);
            }
            // Ross 128b
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(Minecraft.ID, "dirt", 64, 2),
                            getModItem(Minecraft.ID, "stone", 64, 0),
                            ItemList.Generator_Naquadah_Mark_I.get(1),
                            GT_Utility.getIntegratedCircuit(17))
                    .fluidInputs(Materials.Lava.getFluid(10000))
                    .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_Rb", 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);
            // T4 Planets
            // Io
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalaxySpace.ID, "ioblocks", 64, 1),
                            getModItem(GalaxySpace.ID, "ioblocks", 64, 2),
                            getModItem(GalaxySpace.ID, "ioblocks", 64, 3),
                            GT_Utility.getIntegratedCircuit(17))
                    .fluidInputs(Materials.Lead.getMolten(10000))
                    .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_Io", 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);
            // Mercury
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalaxySpace.ID, "mercuryblocks", 64, 0),
                            getModItem(GalaxySpace.ID, "mercuryblocks", 64, 1),
                            getModItem(GalaxySpace.ID, "mercuryblocks", 64, 2),
                            GT_Utility.getIntegratedCircuit(17))
                    .fluidInputs(Materials.Iron.getMolten(10000))
                    .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_Me", 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);
            // Venus
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalaxySpace.ID, "venusblocks", 64, 0),
                                getModItem(GalaxySpace.ID, "venusblocks", 64, 1),
                                GT_OreDictUnificator.get(orePrefix, Materials.Quantium, 64),
                                GT_Utility.getIntegratedCircuit(17))
                        .fluidInputs(Materials.CarbonDioxide.getGas(10000))
                        .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_Ve", 1, 0))
                        .duration(15 * SECONDS).eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);
            }
            // T5 Planets
            // Miranda
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalaxySpace.ID, "mirandablocks", 64, 0),
                            getModItem(GalaxySpace.ID, "mirandablocks", 64, 1),
                            getModItem(GalaxySpace.ID, "mirandablocks", 64, 2),
                            GT_Utility.getIntegratedCircuit(17))
                    .fluidInputs(Materials.HydricSulfide.getGas(10000))
                    .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_Mi", 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);
            // Oberon
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalaxySpace.ID, "oberonblocks", 64, 0),
                            getModItem(GalaxySpace.ID, "oberonblocks", 64, 1),
                            getModItem(GalaxySpace.ID, "oberonblocks", 64, 2),
                            GT_Utility.getIntegratedCircuit(17))
                    .fluidInputs(Materials.CarbonMonoxide.getGas(10000))
                    .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_Ob", 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);
            // Enceladus
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalaxySpace.ID, "enceladusblocks", 64, 0),
                            getModItem(GalaxySpace.ID, "enceladusblocks", 64, 1),
                            getModItem(GalaxySpace.ID, "enceladusblocks", 64, 2),
                            GT_Utility.getIntegratedCircuit(17))
                    .fluidInputs(Materials.Oxygen.getGas(10000))
                    .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_En", 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);
            // Titan
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalaxySpace.ID, "titanblocks", 64, 0),
                            getModItem(GalaxySpace.ID, "titanblocks", 64, 1),
                            getModItem(GalaxySpace.ID, "titanblocks", 64, 2),
                            GT_Utility.getIntegratedCircuit(17))
                    .fluidInputs(Materials.Methane.getGas(10000))
                    .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_Ti", 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);
            // Ross 128ba
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalacticraftCore.ID, "tile.moonBlock", 64, 3),
                            getModItem(GalacticraftCore.ID, "tile.moonBlock", 64, 4),
                            getModItem(GalacticraftCore.ID, "tile.moonBlock", 64, 5),
                            GT_Utility.getIntegratedCircuit(17))
                    .fluidInputs(Materials.Helium_3.getGas(10000))
                    .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_Ra", 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);
            // T6 Planets
            // Triton
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalaxySpace.ID, "tritonblocks", 64, 0),
                            getModItem(GalaxySpace.ID, "tritonblocks", 64, 1),
                            getModItem(GalaxySpace.ID, "tritonblocks", 64, 2),
                            GT_Utility.getIntegratedCircuit(17))
                    .fluidInputs(Materials.Ethylene.getGas(10000))
                    .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_Tr", 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_UV).addTo(assemblerRecipes);
            // Proteus
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalaxySpace.ID, "proteusblocks", 64, 0),
                            getModItem(GalaxySpace.ID, "proteusblocks", 64, 2),
                            getModItem(GalaxySpace.ID, "proteusblocks", 64, 3),
                            GT_Utility.getIntegratedCircuit(17))
                    .fluidInputs(Materials.Deuterium.getGas(10000))
                    .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_Pr", 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_UV).addTo(assemblerRecipes);
            // T7 Planets
            // Haumea
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalaxySpace.ID, "haumeablocks", 64, 0),
                                GT_OreDictUnificator.get(orePrefix, Materials.NetherStar, 64),
                                GT_OreDictUnificator.get(orePrefix, Materials.Naquadah, 64),
                                GT_Utility.getIntegratedCircuit(17))
                        .fluidInputs(Materials.InfusedGold.getMolten(10000))
                        .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_Ha", 1, 0))
                        .duration(15 * SECONDS).eut(TierEU.RECIPE_UHV).addTo(assemblerRecipes);
            }
            // Pluto
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalaxySpace.ID, "plutoblocks", 64, 0),
                            getModItem(GalaxySpace.ID, "plutoblocks", 64, 4),
                            getModItem(GalaxySpace.ID, "plutoblocks", 64, 6),
                            GT_Utility.getIntegratedCircuit(17))
                    .fluidInputs(Materials.Fluorine.getGas(10000))
                    .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_Pl", 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_UHV).addTo(assemblerRecipes);
            // Makemake
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalaxySpace.ID, "makemakegrunt", 64, 0),
                                getModItem(GalaxySpace.ID, "makemakegrunt", 64, 1),
                                GT_OreDictUnificator.get(orePrefix, Materials.Chrysotile, 64),
                                GT_Utility.getIntegratedCircuit(17))
                        .fluidInputs(Materials.HydrofluoricAcid.getFluid(10000))
                        .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_MM", 1, 0))
                        .duration(15 * SECONDS).eut(TierEU.RECIPE_UHV).addTo(assemblerRecipes);
            }
            // Kuiper Belt
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalacticraftMars.ID, "tile.asteroidsBlock", 64, 0),
                                getModItem(GalacticraftMars.ID, "tile.denseIce", 64, 0),
                                GT_OreDictUnificator.get(orePrefix, Materials.Neutronium, 64),
                                GT_Utility.getIntegratedCircuit(17))
                        .fluidInputs(Materials.HydrofluoricAcid.getFluid(10000))
                        .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_KB", 1, 0))
                        .duration(15 * SECONDS).eut(TierEU.RECIPE_UHV).addTo(assemblerRecipes);
            }
            // T8 Planets
            // Vega B
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalaxySpace.ID, "vegabgrunt", 64, 0),
                                getModItem(GalaxySpace.ID, "vegabsubgrunt", 64, 0),
                                GT_OreDictUnificator.get(orePrefix, Materials.InfinityCatalyst, 64),
                                GT_Utility.getIntegratedCircuit(17))
                        .fluidInputs(Materials.Neutronium.getMolten(10000))
                        .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_VB", 1, 0))
                        .duration(15 * SECONDS).eut(TierEU.RECIPE_UEV).addTo(assemblerRecipes);
            }
            // Barnard C
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(Minecraft.ID, "stone", 64, 0),
                            getModItem(GalaxySpace.ID, "barnardaCgrass", 64, 0),
                            getModItem(GalaxySpace.ID, "barnardaCsapling", 1, 1),
                            GT_Utility.getIntegratedCircuit(17))
                    .fluidInputs(FluidRegistry.getFluidStack("unknowwater", 10000))
                    .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_BC", 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_UEV).addTo(assemblerRecipes);
            // Barnard E
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalaxySpace.ID, "barnardaEgrunt", 64, 0),
                            getModItem(GalaxySpace.ID, "barnardaEsubgrunt", 64, 0),
                            GT_OreDictUnificator.get(OrePrefixes.block, Materials.Unstable, 64),
                            GT_Utility.getIntegratedCircuit(17))
                    .fluidInputs(Materials.LiquidAir.getFluid(10000))
                    .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_BE", 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_UEV).addTo(assemblerRecipes);
            // Barnard F
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalaxySpace.ID, "barnardaFgrunt", 64, 0),
                                getModItem(GalaxySpace.ID, "barnardaFsubgrunt", 64, 0),
                                GT_OreDictUnificator.get(orePrefix, Materials.Bedrockium, 64),
                                GT_Utility.getIntegratedCircuit(17))
                        .fluidInputs(Materials.Tin.getMolten(10000))
                        .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_BF", 1, 0))
                        .duration(15 * SECONDS).eut(TierEU.RECIPE_UEV).addTo(assemblerRecipes);
            }
            // T Ceti E
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalaxySpace.ID, "tcetieblocks", 64, 0),
                            getModItem(GalaxySpace.ID, "tcetieblocks", 64, 2),
                            getModItem(GalaxySpace.ID, "tcetiedandelions", 64, 4),
                            GT_Utility.getIntegratedCircuit(17))
                    .fluidInputs(GT_ModHandler.getDistilledWater(10000))
                    .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_TE", 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_UEV).addTo(assemblerRecipes);
            // Alpha Centauri Bb
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalaxySpace.ID, "acentauribbgrunt", 64, 0),
                                getModItem(GalaxySpace.ID, "acentauribbsubgrunt", 64, 0),
                                GT_OreDictUnificator.get(orePrefix, Materials.Samarium, 64),
                                GT_Utility.getIntegratedCircuit(17))
                        .fluidInputs(Materials.Copper.getMolten(10000))
                        .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_CB", 1, 0))
                        .duration(15 * SECONDS).eut(TierEU.RECIPE_UEV).addTo(assemblerRecipes);
            }
            // T9 Planets
            // Seth
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(Minecraft.ID, "snow", 64, 0),
                                getModItem(Minecraft.ID, "packed_ice", 64, 0),
                                GT_OreDictUnificator.get(orePrefix, Materials.TengamRaw, 64),
                                GT_Utility.getIntegratedCircuit(17))
                        .fluidInputs(FluidRegistry.getFluidStack("ice", 10000))
                        .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_Se", 1, 0))
                        .duration(15 * SECONDS).eut(TierEU.RECIPE_UIV).addTo(assemblerRecipes);
            }
            // Anubis
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalacticraftAmunRa.ID, "tile.baseBlockGround", 64, 1),
                                getModItem(GalacticraftAmunRa.ID, "tile.baseBlockRock", 64, 1),
                                GT_OreDictUnificator.get(orePrefix, Materials.InfinityCatalyst, 64),
                                GT_Utility.getIntegratedCircuit(17))
                        // This breaks the pattern but the theme of the planet is that it's super dry so
                        // :shrug:, maybe add eventual pumpable fluid
                        .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_An", 1, 0))
                        .duration(15 * SECONDS).eut(TierEU.RECIPE_UIV).addTo(assemblerRecipes);
            }
            // Neper
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(Minecraft.ID, "grass", 64, 0),
                                getModItem(Minecraft.ID, "stone", 64, 0),
                                GT_OreDictUnificator.get(orePrefix, Materials.Dilithium, 64),
                                GT_Utility.getIntegratedCircuit(17))
                        .fluidInputs(Materials.Water.getFluid(10000)) // There isn't actually water on Neper, but it
                                                                      // fits
                        // the grass
                        .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_Np", 1, 0))
                        .duration(15 * SECONDS).eut(TierEU.RECIPE_UIV).addTo(assemblerRecipes);
            }
            // Maahes
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalacticraftAmunRa.ID, "tile.baseGrass", 64, 0),
                                getModItem(GalacticraftAmunRa.ID, "tile.saplings", 1, 0),
                                GT_OreDictUnificator.get(orePrefix, Materials.Naquadria, 64),
                                GT_Utility.getIntegratedCircuit(17))
                        .fluidInputs(Materials.Water.getFluid(10000)) // Same as Neper (but the grass is red)
                        .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_Mh", 1, 0))
                        .duration(15 * SECONDS).eut(TierEU.RECIPE_UIV).addTo(assemblerRecipes);
            }
            // Horus
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalacticraftAmunRa.ID, "tile.baseFalling", 64, 0), // Obsidian Sand
                                getModItem(GalacticraftAmunRa.ID, "tile.baseBlockRock", 64, 9), // Obsidian Brick
                                GT_OreDictUnificator.get(orePrefix, Materials.CosmicNeutronium, 64),
                                GT_Utility.getIntegratedCircuit(17))
                        .fluidInputs(Materials.Lava.getFluid(10000))
                        .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_Ho", 1, 0))
                        .duration(15 * SECONDS).eut(TierEU.RECIPE_UIV).addTo(assemblerRecipes);
            }
            // Technically T10
            // Deep Dark
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(Minecraft.ID, "cobblestone", 64, 0),
                                GT_OreDictUnificator.get(orePrefix, Materials.Rubidium, 64),
                                GT_OreDictUnificator.get(orePrefix, Materials.Pumice, 64),
                                GT_Utility.getIntegratedCircuit(17))
                        .fluidInputs(MaterialsUEVplus.SpaceTime.getMolten(10000))
                        .itemOutputs(getModItem(NEIOrePlugin.ID, "blockDimensionDisplay_DD", 1, 0))
                        .duration(15 * SECONDS).eut(TierEU.RECIPE_UMV).addTo(assemblerRecipes);
            }
        }
    }

    private void makeSolderingAlloyRecipes() {
        for (Materials tMat : solderingMaterials) { // TODO dream things using soldering go in here!

            int tMultiplier = tMat.contains(SubTag.SOLDERING_MATERIAL_GOOD) ? 1
                    : tMat.contains(SubTag.SOLDERING_MATERIAL_BAD) ? 4 : 2;

            if (StevesCarts2.isModLoaded()) {

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Coated_Basic.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 8),
                                GT_Utility.getIntegratedCircuit(2))
                        .itemOutputs(GT_ModHandler.getModItem(StevesCarts2.ID, "ModuleComponents", 1L, 9))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Phenolic_Good.get(1L),
                                GT_ModHandler.getModItem(StevesCarts2.ID, "ModuleComponents", 2L, 9),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16),
                                GT_Utility.getIntegratedCircuit(2))
                        .itemOutputs(GT_ModHandler.getModItem(StevesCarts2.ID, "ModuleComponents", 1L, 16))
                        .fluidInputs(tMat.getMolten(288L * tMultiplier / 2L)).duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

            }

            // --- Advanced Solar Panel
            if (AdvancedSolarPanel.isModLoaded()) {

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Hull_LV.get(1L),
                                ItemList.Cover_SolarPanel_LV.get(1L),
                                ItemList.Robot_Arm_LV.get(1L),
                                ItemList.Battery_RE_LV_Lithium.get(1L),
                                GT_Utility.getIntegratedCircuit(2))
                        .itemOutputs(GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "BlockAdvSolarPanel", 1L, 0))
                        .fluidInputs(tMat.getMolten(288L * tMultiplier / 2L)).duration(40 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Hull_MV.get(1L),
                                ItemList.Cover_SolarPanel_MV.get(1L),
                                ItemList.Robot_Arm_MV.get(1L),
                                ItemList.Battery_RE_MV_Lithium.get(1L),
                                GT_Utility.getIntegratedCircuit(2))
                        .itemOutputs(GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "BlockAdvSolarPanel", 1L, 1))
                        .fluidInputs(tMat.getMolten(576L * tMultiplier / 2L)).duration(50 * SECONDS)
                        .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Hull_HV.get(1L),
                                ItemList.Cover_SolarPanel_HV.get(1L),
                                ItemList.Robot_Arm_HV.get(1L),
                                ItemList.Battery_RE_HV_Lithium.get(1L),
                                GT_Utility.getIntegratedCircuit(2))
                        .itemOutputs(GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "BlockAdvSolarPanel", 1L, 2))
                        .fluidInputs(tMat.getMolten(864L * tMultiplier / 2L)).duration(60 * SECONDS)
                        .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Hull_EV.get(1L),
                                ItemList.Cover_SolarPanel_EV.get(1L),
                                ItemList.Robot_Arm_EV.get(1L),
                                CustomItemList.BatteryHull_EV_Full.get(1L),
                                GT_Utility.getIntegratedCircuit(2))
                        .itemOutputs(GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "BlockAdvSolarPanel", 1L, 3))
                        .fluidInputs(tMat.getMolten(1152L * tMultiplier / 2L)).duration(1 * MINUTES + 10 * SECONDS)
                        .eut(7860).addTo(assemblerRecipes);

            }

            // --- Super Solar Panel
            if (SuperSolarPanels.isModLoaded()) {

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Hull_IV.get(1L),
                                ItemList.Cover_SolarPanel_IV.get(1L),
                                ItemList.Robot_Arm_IV.get(1L),
                                CustomItemList.BatteryHull_IV_Full.get(1L),
                                GT_Utility.getIntegratedCircuit(2))
                        .itemOutputs(GT_ModHandler.getModItem(SuperSolarPanels.ID, "SpectralSolarPanel", 1L, 0))
                        .fluidInputs(tMat.getMolten(1440 * tMultiplier / 2L)).duration(1 * MINUTES + 20 * SECONDS)
                        .eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Hull_LuV.get(1L),
                                ItemList.Cover_SolarPanel_LuV.get(1L),
                                ItemList.Robot_Arm_LuV.get(1L),
                                CustomItemList.BatteryHull_LuV_Full.get(1L),
                                GT_Utility.getIntegratedCircuit(2))
                        .itemOutputs(GT_ModHandler.getModItem(SuperSolarPanels.ID, "SingularSolarPanel", 1L, 0))
                        .fluidInputs(tMat.getMolten(1728 * tMultiplier / 2L)).duration(1 * MINUTES + 30 * SECONDS)
                        .eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Hull_ZPM.get(1L),
                                ItemList.Cover_SolarPanel_ZPM.get(1L),
                                ItemList.Robot_Arm_ZPM.get(1L),
                                CustomItemList.BatteryHull_ZPM_Full.get(1L),
                                GT_Utility.getIntegratedCircuit(2))
                        .itemOutputs(GT_ModHandler.getModItem(SuperSolarPanels.ID, "AdminSolarPanel", 1L, 0))
                        .fluidInputs(tMat.getMolten(2016 * tMultiplier / 2L)).duration(1 * MINUTES + 40 * SECONDS)
                        .eut(TierEU.RECIPE_UV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Hull_UV.get(1L),
                                ItemList.Cover_SolarPanel_UV.get(1L),
                                ItemList.Robot_Arm_UV.get(1L),
                                CustomItemList.BatteryHull_UV_Full.get(1L),
                                GT_Utility.getIntegratedCircuit(2))
                        .itemOutputs(GT_ModHandler.getModItem(SuperSolarPanels.ID, "PhotonicSolarPanel", 1L, 0))
                        .fluidInputs(tMat.getMolten(2304 * tMultiplier / 2L)).duration(1 * MINUTES + 50 * SECONDS)
                        .eut(TierEU.RECIPE_UHV).addTo(assemblerRecipes);

            }

            // solar 1EU

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Silicon_Wafer.get(2),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 2L),
                            GT_ModHandler.getIC2Item("reinforcedGlass", 1L),
                            GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 2L),
                            CustomItemList.AluminiumIronPlate.get(1))
                    .itemOutputs(ItemList.Cover_SolarPanel.get(1L)).fluidInputs(tMat.getMolten(72L * tMultiplier / 2L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
            // solar 8EU

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L),
                            ItemList.Cover_SolarPanel.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Tin, 2L),
                            ItemList.Circuit_Silicon_Wafer.get(1),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.GalliumArsenide, 1L),
                            CustomItemList.ReinforcedAluminiumIronPlate.get(1))
                    .itemOutputs(ItemList.Cover_SolarPanel_8V.get(1L))
                    .fluidInputs(tMat.getMolten(72L * tMultiplier / 2L)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(assemblerRecipes);

            if (OpenComputers.isModLoaded()) {

                // display t1

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Casing_MV.get(1L),
                                ItemList.Cover_Screen.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L),
                                ItemList.Circuit_Parts_Transistor.get(2L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "screen1", 1L, 0))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS).eut(64)
                        .addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Casing_MV.get(1L),
                                ItemList.Cover_Screen.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L),
                                ItemList.Circuit_Parts_TransistorSMD.get(1L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "screen1", 1L, 0))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS).eut(64)
                        .addTo(assemblerRecipes);
                // display t2

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Casing_HV.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "screen1", 1L, 0),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L),
                                ItemList.Circuit_Parts_Transistor.get(4L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "screen2", 1L, 0))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Casing_HV.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "screen1", 1L, 0),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L),
                                ItemList.Circuit_Parts_TransistorSMD.get(2L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "screen2", 1L, 0))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
                // display t3

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Casing_EV.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "screen2", 1L, 0),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L),
                                ItemList.Circuit_Parts_Transistor.get(8L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "screen3", 1L, 0))
                        .fluidInputs(tMat.getMolten(288L * tMultiplier / 2L)).duration(12 * SECONDS).eut(256)
                        .addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Casing_EV.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "screen2", 1L, 0),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L),
                                ItemList.Circuit_Parts_TransistorSMD.get(4L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "screen3", 1L, 0))
                        .fluidInputs(tMat.getMolten(288L * tMultiplier / 2L)).duration(12 * SECONDS).eut(256)
                        .addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Casing_EV.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "screen2", 1L, 0),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L),
                                ItemList.Circuit_Parts_TransistorASMD.get(1L),
                                GT_Utility.getIntegratedCircuit(2))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "screen3", 1L, 0))
                        .fluidInputs(tMat.getMolten(288L * tMultiplier / 2L)).duration(6 * SECONDS).eut(256)
                        .addTo(assemblerRecipes);
                // angel upgrade

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_ModHandler.getModItem(ExtraUtilities.ID, "angelBlock", 1L, 0),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 25),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 49))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(256).addTo(assemblerRecipes);
                // hover upgrade Tier 1

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 4L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                                ItemList.Electric_Motor_MV.get(1L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 99))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(256).addTo(assemblerRecipes);
                // hover upgrade Tier 2

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 4L),
                                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 8L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 26),
                                ItemList.Electric_Motor_HV.get(1L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 100))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
                // battery upgrade 1

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "capacitor", 1L, 0),
                                ItemList.Circuit_Parts_Transistor.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 4L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 63))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "capacitor", 1L, 0),
                                ItemList.Circuit_Parts_TransistorSMD.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 4L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 63))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
                // battery upgrade 2

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "capacitor", 2L, 0),
                                ItemList.Circuit_Parts_Transistor.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 8L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 64))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(256).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "capacitor", 2L, 0),
                                ItemList.Circuit_Parts_TransistorSMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 8L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 64))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(256).addTo(assemblerRecipes);
                // battery upgrade 3

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "capacitor", 4L, 0),
                                ItemList.Circuit_Parts_Transistor.get(8L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 65))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "capacitor", 4L, 0),
                                ItemList.Circuit_Parts_TransistorSMD.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 65))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "capacitor", 4L, 0),
                                ItemList.Circuit_Parts_TransistorASMD.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(2))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 65))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(6 * SECONDS + 5 * TICKS)
                        .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
                // inventory upgrade

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                new ItemStack(Blocks.chest, 1),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 8L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 53))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
                // inventory controller upgrade

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 53),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 61))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
                // tank upgrade

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_ModHandler.getModItem(BuildCraftFactory.ID, "tankBlock", 1L, 0),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 8L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 76))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
                // tank controller upgrade

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 76),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 77))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
                // beekeper upgrade

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 25),
                                GT_ModHandler.getModItem(Forestry.ID, "beealyzer", 1L, 0),
                                ItemList.Sensor_MV.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 2),
                                GT_Utility.getIntegratedCircuit(10))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item.forestry", 1L, 0))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
                // configurator upgrade

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "wrench", 1L, 0),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 115))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
                // riteg upgrade

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getIC2Item("RTGPellets", 1),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 3L, 26),
                                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lead, 4L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 116))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(15 * SECONDS).eut(256)
                        .addTo(assemblerRecipes);
                // card container 1

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 33),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                new ItemStack(Blocks.chest, 1),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 24),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 57))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
                // card container 2

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 33),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L),
                                new ItemStack(Blocks.chest, 1),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 25),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 58))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(256).addTo(assemblerRecipes);
                // card container 3

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 33),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L),
                                new ItemStack(Blocks.chest, 1),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 26),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 59))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
                // upgrade container 1

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                new ItemStack(Blocks.chest, 1),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.StainlessSteel, 8L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 54))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
                // upgrade container 2

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L),
                                new ItemStack(Blocks.chest, 1),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 25),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Titanium, 8L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 55))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(256).addTo(assemblerRecipes);
                // upgrade container 3

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L),
                                new ItemStack(Blocks.chest, 1),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 26),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 8L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 56))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
                // database upgrade 1

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 0),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 5),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 24),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 78))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
                // database upgrade 2

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 0),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 6),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 79))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(256).addTo(assemblerRecipes);
                // database upgrade 3

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 0),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 7),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 26),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 80))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
                // experience upgrade

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 0),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 26),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Emerald, 2L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 52))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
                // crafting component

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Hull_LV.get(1L),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 24),
                                ItemList.Cover_Crafting.get(1L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 14))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
                // generator upgrade

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(EnderIO.ID, "blockStirlingGenerator", 1L, 0),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 15))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
                // leash upgrade

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 28),
                                new ItemStack(Items.lead, 4),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 85))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
                // mfu upgrade

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "adapter", 1L, 0),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 51),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 4L, 96),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 2L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 112))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
                // navigation upgrade

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Hull_MV.get(1L),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 26),
                                new ItemStack(Items.compass, 1),
                                new ItemStack(Items.map, 1),
                                GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Water, 1L))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 36))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(256).addTo(assemblerRecipes);
                // piston upgrade

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Electric_Piston_MV.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 75))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
                // sing IO upgrade

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                ItemList.Dye_SquidInk.get(1L),
                                new ItemStack(Items.sign, 1),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 35))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
                // solar upgrade

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 26),
                                ItemList.Cover_SolarPanel_LV.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 34))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(256).addTo(assemblerRecipes);
                // tractor beam upgrade

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "capacitor", 1L, 0),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 26),
                                ItemList.Electric_Piston_HV.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.IronMagnetic, 4L),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 16L))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 67))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
                // trading upgrade

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 3L, 25),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 3L),
                                ItemList.Electric_Piston_MV.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Emerald, 2L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 110))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(256).addTo(assemblerRecipes);
                // hover Boots

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "capacitor", 1L, 0),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 83),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 100),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 4L),
                                ItemList.Electric_Piston_MV.get(2L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "hoverBoots", 1L, W))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(17 * SECONDS + 10 * TICKS)
                        .eut(256).addTo(assemblerRecipes);

                // ME Upgrade 1

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Chrome, 2L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 13),
                                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 41),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 24),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item.ae", 1L))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(256).addTo(assemblerRecipes);
                // ME Upgrade 2

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 13),
                                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 41),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 25),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item.ae", 1L, 1))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(1024).addTo(assemblerRecipes);
                // ME Upgrade 3

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 13),
                                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 41),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 26),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(OpenComputers.ID, "item.ae", 1L, 2))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(4096).addTo(assemblerRecipes);

            }

            if (Computronics.isModLoaded()) {
                // Camera Upgrade

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(Computronics.ID, "computronics.camera", 1L, 0),
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                                ItemList.Circuit_Parts_TransistorSMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(Computronics.ID, "computronics.ocParts", 1L, 0))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(256).addTo(assemblerRecipes);
                // Chat Upgrade

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(Computronics.ID, "computronics.chatBox", 1L, 0),
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                                ItemList.Circuit_Parts_TransistorSMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(Computronics.ID, "computronics.ocParts", 1L, 1))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(256).addTo(assemblerRecipes);
                // Radar Upgrade

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(Computronics.ID, "computronics.radar", 1L, 0),
                                ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 26),
                                ItemList.Circuit_Parts_TransistorSMD.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 48),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(Computronics.ID, "computronics.ocParts", 1L, 2))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(Computronics.ID, "computronics.radar", 1L, 0),
                                ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 26),
                                ItemList.Circuit_Parts_TransistorASMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 48),
                                GT_Utility.getIntegratedCircuit(2))
                        .itemOutputs(GT_ModHandler.getModItem(Computronics.ID, "computronics.ocParts", 1L, 2))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
                // Particel Card

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 33),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 25),
                                new ItemStack(Items.firework_charge, 1, W),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(Computronics.ID, "computronics.ocParts", 1L, 3))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
                // Spoofing Card

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 11),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 50),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Clay, 2L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(Computronics.ID, "computronics.ocParts", 1L, 4))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
                // Beep Card

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 33),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 28),
                                GT_ModHandler.getModItem(Computronics.ID, "computronics.speaker", 1L, 0),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(Computronics.ID, "computronics.ocParts", 1L, 5))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
                // Self Destruction Card

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 66),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 24),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 28),
                                GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockITNT", 2L, 0),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(Computronics.ID, "computronics.ocParts", 1L, 6))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(256).addTo(assemblerRecipes);
                // Colorful Upgrade

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                                ItemList.Circuit_Parts_TransistorSMD.get(2L),
                                GT_ModHandler.getModItem(Computronics.ID, "computronics.colorfulLamp", 1L, 0),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 4L, 96),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(Computronics.ID, "computronics.ocParts", 1L, 7))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
                // Noise Card

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(Computronics.ID, "computronics.ocParts", 1L, 5),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 1),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 27),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 2L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(Computronics.ID, "computronics.ocParts", 1L, 8))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
                // Sound Card

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(Computronics.ID, "computronics.ocParts", 1L, 8),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 26),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 38),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 29),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(Computronics.ID, "computronics.ocParts", 1L, 9))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(1024).addTo(assemblerRecipes);
                // Light Board

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem(Computronics.ID, "computronics.colorfulLamp", 1L, 0),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 2L),
                                ItemList.Dye_SquidInk.get(4L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(Computronics.ID, "computronics.ocParts", 1L, 10))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(256).addTo(assemblerRecipes);
                // Server Selfdestructor

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem(Computronics.ID, "computronics.ocParts", 2L, 6),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 24),
                                ItemList.Dye_SquidInk.get(4L),
                                GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockITNT", 2L, 0),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(Computronics.ID, "computronics.ocParts", 1L, 11))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(256).addTo(assemblerRecipes);
                // Rack Capacitor

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "capacitor", 1L, 0),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 2L),
                                ItemList.Dye_SquidInk.get(4L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(Computronics.ID, "computronics.ocParts", 1L, 12))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(256).addTo(assemblerRecipes);
                // Switch Board

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 24),
                                new ItemStack(Blocks.stone_button, 64, 30720),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 2L),
                                ItemList.Dye_SquidInk.get(4L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(Computronics.ID, "computronics.ocParts", 1L, 13))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(256).addTo(assemblerRecipes);
                // Speech Upgrade

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(Computronics.ID, "computronics.speechBox", 1L, 0),
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                                ItemList.Circuit_Parts_TransistorSMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(Computronics.ID, "computronics.ocParts", 1L, 14))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(256).addTo(assemblerRecipes);
                // Drone Docking Station

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem(OpenComputers.ID, "cable", 2L, 0),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                                ItemList.Circuit_Parts_TransistorSMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 2L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(Computronics.ID, "computronics.droneStation", 1L, 0))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
                // Drone Docking Station Upgrade

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(Computronics.ID, "computronics.droneStation", 1L, 0),
                                GT_ModHandler.getModItem(OpenComputers.ID, "item", 2L, 26),
                                ItemList.Circuit_Parts_TransistorSMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_Utility.getIntegratedCircuit(1))
                        .itemOutputs(GT_ModHandler.getModItem(Computronics.ID, "computronics.dockingUpgrade", 1L, 0))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

            }
        }
    }
}
