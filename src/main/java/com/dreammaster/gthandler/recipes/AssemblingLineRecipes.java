package com.dreammaster.gthandler.recipes;

import static bartworks.system.material.WerkstoffLoader.Californium;
import static com.dreammaster.scripts.IScriptLoader.missing;
import static gregtech.api.enums.GTValues.L;
import static gregtech.api.enums.Mods.AE2FluidCraft;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.Computronics;
import static gregtech.api.enums.Mods.EtFuturumRequiem;
import static gregtech.api.enums.Mods.EternalSingularity;
import static gregtech.api.enums.Mods.GalacticraftAmunRa;
import static gregtech.api.enums.Mods.GraviSuite;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.SGCraft;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.HOURS;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.WILDCARD;
import static gregtech.api.util.GTRecipeConstants.AssemblyLine;
import static gregtech.api.util.GTRecipeConstants.RESEARCH_ITEM;
import static gregtech.api.util.GTRecipeConstants.SCANNING;
import static gtPlusPlus.core.material.MaterialsAlloy.HASTELLOY_C276;
import static gtPlusPlus.core.material.MaterialsAlloy.HASTELLOY_X;
import static tectech.thing.CustomItemList.DATApipe;
import static tectech.thing.CustomItemList.Machine_Multi_DataBank;
import static tectech.thing.CustomItemList.Machine_Multi_Switch_Adv;
import static tectech.thing.CustomItemList.dataInAss_Hatch;
import static tectech.thing.CustomItemList.dataInAss_Wireless_Hatch;
import static tectech.thing.CustomItemList.dataIn_Hatch;
import static tectech.thing.CustomItemList.dataIn_Wireless_Hatch;
import static tectech.thing.CustomItemList.dataOutAss_Hatch;
import static tectech.thing.CustomItemList.dataOutAss_Wireless_Hatch;
import static tectech.thing.CustomItemList.dataOut_Hatch;
import static tectech.thing.CustomItemList.dataOut_Wireless_Hatch;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.item.NHItemList;

import appeng.api.AEApi;
import bartworks.common.loaders.ItemRegistry;
import bartworks.system.material.WerkstoffLoader;
import goodgenerator.items.GGMaterial;
import goodgenerator.util.ItemRefer;
import gregtech.api.GregTechAPI;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsKevlar;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gregtech.api.util.recipe.Scanning;
import gtPlusPlus.core.block.ModBlocks;
import gtPlusPlus.core.material.MaterialsAlloy;
import gtPlusPlus.core.material.MaterialsElements;
import gtPlusPlus.core.material.Particle;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;
import gtnhlanth.common.register.WerkstoffMaterialPool;
import tectech.recipe.TTRecipeAdder;

public class AssemblingLineRecipes implements Runnable {

    @Override
    public void run() {

        Fluid solderUEV = FluidRegistry.getFluid("molten.mutatedlivingsolder") != null
                ? FluidRegistry.getFluid("molten.mutatedlivingsolder")
                : FluidRegistry.getFluid("molten.solderingalloy");

        Fluid solderIndalloy = FluidRegistry.getFluid("molten.indalloy140") != null
                ? FluidRegistry.getFluid("molten.indalloy140")
                : FluidRegistry.getFluid("molten.solderingalloy");

        // Heavy duty alloy ingot T5
        GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, CustomItemList.HeavyDutyPlateTier4.get(1L))
                .metadata(SCANNING, new Scanning(1 * MINUTES + 40 * SECONDS, TierEU.RECIPE_IV))
                .itemInputs(
                        CustomItemList.HeavyDutyPlateTier4.get(1L),
                        CustomItemList.QuantinumCompressedPlate.get(4L),
                        CustomItemList.QuantinumCompressedPlate.get(4L),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Europium, 8))
                .fluidInputs(new FluidStack(solderIndalloy, 72))
                .itemOutputs(CustomItemList.HeavyDutyAlloyIngotT5.get(1L)).eut(TierEU.RECIPE_ZPM).duration(15 * SECONDS)
                .addTo(AssemblyLine);

        // Heavy duty alloy ingot T6
        GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, CustomItemList.HeavyDutyPlateTier5.get(1L))
                .metadata(SCANNING, new Scanning(1 * MINUTES + 50 * SECONDS, TierEU.RECIPE_LuV))
                .itemInputs(
                        CustomItemList.HeavyDutyPlateTier5.get(1L),
                        CustomItemList.LeadOriharukonPlate.get(5L),
                        CustomItemList.LeadOriharukonPlate.get(5L),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Tritanium, 8))
                .fluidInputs(new FluidStack(solderIndalloy, 144))
                .itemOutputs(CustomItemList.HeavyDutyAlloyIngotT6.get(1L)).eut(TierEU.RECIPE_UV).duration(15 * SECONDS)
                .addTo(AssemblyLine);

        // Heavy duty alloy ingot T7
        GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, CustomItemList.HeavyDutyPlateTier6.get(1L))
                .metadata(SCANNING, new Scanning(2 * MINUTES, TierEU.RECIPE_ZPM))
                .itemInputs(
                        CustomItemList.HeavyDutyPlateTier6.get(1L),
                        CustomItemList.MysteriousCrystalCompressedPlate.get(6L),
                        CustomItemList.MysteriousCrystalCompressedPlate.get(6L),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Neutronium, 10))
                .fluidInputs(new FluidStack(solderIndalloy, 288))
                .itemOutputs(CustomItemList.HeavyDutyAlloyIngotT7.get(1L)).eut(TierEU.RECIPE_UHV).duration(15 * SECONDS)
                .addTo(AssemblyLine);

        // Heavy duty alloy ingot T8
        GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, CustomItemList.HeavyDutyPlateTier7.get(1L))
                .metadata(SCANNING, new Scanning(2 * MINUTES + 10 * SECONDS, TierEU.RECIPE_UV))
                .itemInputs(
                        CustomItemList.HeavyDutyPlateTier7.get(1L),
                        CustomItemList.BlackPlutoniumCompressedPlate.get(7L),
                        CustomItemList.BlackPlutoniumCompressedPlate.get(7L),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.BlackPlutonium, 12))
                .fluidInputs(new FluidStack(solderIndalloy, 576))
                .itemOutputs(CustomItemList.HeavyDutyAlloyIngotT8.get(1L)).eut(TierEU.RECIPE_UEV).duration(15 * SECONDS)
                .addTo(AssemblyLine);

        // Neuro CPU
        GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Circuit_Chip_Stemcell.get(1L))
                .metadata(SCANNING, new Scanning(1 * MINUTES, TierEU.RECIPE_LuV))
                .itemInputs(
                        ItemList.Circuit_Board_Wetware_Extreme.get(1L),
                        ItemList.Circuit_Chip_Stemcell.get(16L),
                        ItemList.Circuit_Parts_Reinforced_Glass_Tube.get(16L),
                        GTOreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Polybenzimidazole, 8L),
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.NaquadahEnriched, 4L),
                        new Object[] { OrePrefixes.foil.get(Materials.AnySyntheticRubber), 64L },
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 32L))
                .fluidInputs(
                        Materials.GrowthMediumSterilized.getFluid(250L),
                        Materials.UUMatter.getFluid(250L),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000))
                .itemOutputs(ItemList.Circuit_Chip_NeuroCPU.get(1L)).eut(TierEU.RECIPE_ZPM).duration(30 * SECONDS)
                .addTo(AssemblyLine);

        // Bio CPU
        GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Circuit_Chip_NeuroCPU.get(1L))
                .metadata(SCANNING, new Scanning(1 * MINUTES + 30 * SECONDS, TierEU.RECIPE_ZPM))
                .itemInputs(
                        ItemList.Circuit_Board_Bio_Ultra.get(1L),
                        ItemList.Circuit_Chip_Biocell.get(16L),
                        ItemList.Circuit_Parts_Reinforced_Glass_Tube.get(16L),
                        GTOreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Polybenzimidazole, 16),
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.ElectrumFlux, 16L),
                        new Object[] { OrePrefixes.foil.get(Materials.AnySyntheticRubber), 64L },
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.HSSS, 32L))
                .fluidInputs(
                        Materials.BioMediumSterilized.getFluid(500L),
                        Materials.UUMatter.getFluid(500L),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000))
                .itemOutputs(ItemList.Circuit_Chip_BioCPU.get(1L)).eut(TierEU.RECIPE_UHV / 2).duration(30 * SECONDS)
                .addTo(AssemblyLine);

        // Lapotronic Energy Orb Cluster
        GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Energy_LapotronicOrb.get(1L))
                .metadata(SCANNING, new Scanning(40 * SECONDS, TierEU.RECIPE_IV))
                .itemInputs(
                        ItemList.Circuit_Board_Multifiberglass.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.NaquadahAlloy, 64L),
                        new Object[] { OrePrefixes.circuit.get(Materials.LuV), 4L },
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(36L),
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(36L),
                        ItemList.Circuit_Chip_HPIC.get(64L),
                        ItemList.Circuit_Parts_DiodeASMD.get(8L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(8L),
                        ItemList.Circuit_Parts_ResistorASMD.get(8L),
                        ItemList.Circuit_Parts_TransistorASMD.get(8L),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 64))
                .fluidInputs(new FluidStack(solderIndalloy, 720)).itemOutputs(ItemList.Energy_LapotronicOrb2.get(1L))
                .eut(TierEU.RECIPE_ZPM).duration(50 * SECONDS).addTo(AssemblyLine);

        // Advanced Stocking Input Bus (ME)
        GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Hatch_Input_Bus_ME.get(1L))
                .metadata(SCANNING, new Scanning(50 * SECONDS, TierEU.RECIPE_EV))
                .itemInputs(
                        ItemList.Hatch_Input_Bus_LuV.get(1L),
                        GTModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1L),
                        ItemList.Conveyor_Module_IV.get(1L),
                        // Acceleration Card
                        GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4L, 30))
                .fluidInputs(new FluidStack(solderIndalloy, 288), FluidRegistry.getFluidStack("lubricant", 500))
                .itemOutputs(ItemList.Hatch_Input_Bus_ME_Advanced.get(1L)).eut(TierEU.RECIPE_LuV).duration(15 * SECONDS)
                .addTo(AssemblyLine);

        // Cloud Computation Client Hatch
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                dataIn_Hatch.get(1),
                512000,
                2000,
                100_000_000,
                2,
                new Object[] {
                        // Regular slave connector
                        dataIn_Hatch.get(1),
                        // Network Switch With QoS
                        Machine_Multi_Switch_Adv.get(1),
                        // Data pipe
                        DATApipe.get(64),
                        // Internet card
                        GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 44),
                        // Dense infinity plate
                        GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Infinity, 64),
                        // Shirabon foil
                        GTOreDictUnificator.get("foilShirabon", 64),
                        // Quantum circuit
                        new Object[] { OrePrefixes.circuit.get(Materials.UXV), 1L },
                        // Energized tesseract
                        ItemList.EnergisedTesseract.get(1) },
                new FluidStack[] { new FluidStack(solderUEV, 1296), MaterialsUEVplus.ExcitedDTEC.getFluid(500L) },
                // Cloud Computation Client Hatch
                dataIn_Wireless_Hatch.get(1),
                30 * SECONDS,
                (int) TierEU.RECIPE_UMV);

        // Cloud computation server hatch
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                // Optical Master Connector
                dataOut_Hatch.get(1),
                512000,
                2000,
                100_000_000,
                2,
                new Object[] {
                        // Regular master connector
                        dataOut_Hatch.get(1),
                        // Network Switch With QoS
                        Machine_Multi_Switch_Adv.get(1),
                        // Data pipe
                        DATApipe.get(64),
                        // Internet card
                        GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 44),
                        // Dense infinity plate
                        GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Infinity, 64),
                        // Shirabon foil
                        GTOreDictUnificator.get("foilShirabon", 64),
                        // Quantum circuit
                        new Object[] { OrePrefixes.circuit.get(Materials.UXV), 1L },
                        // Energized tesseract
                        ItemList.EnergisedTesseract.get(1) },
                new FluidStack[] { new FluidStack(solderUEV, 1296), MaterialsUEVplus.ExcitedDTEC.getFluid(500L) },
                // Cloud Computation Server Hatch
                dataOut_Wireless_Hatch.get(1),
                30 * SECONDS,
                (int) TierEU.RECIPE_UMV);

        // Wireless assembly line slave connector
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                // Assembly line slave connector
                dataInAss_Hatch.get(1),
                512000,
                2000,
                100_000_000,
                2,
                new Object[] {
                        // Assembly line slave connector
                        dataInAss_Hatch.get(1),
                        // Data bank
                        Machine_Multi_DataBank.get(1),
                        // Data pipe
                        DATApipe.get(64),
                        // Internet card
                        GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 44),
                        // Superdense neutronium plate
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Neutronium, 4),
                        // infinity foil
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Infinity, 64),
                        // UIV circuit
                        new Object[] { OrePrefixes.circuit.get(Materials.UIV), 2L },
                        // UEV emitter
                        ItemList.Sensor_UEV.get(1) },
                new FluidStack[] { new FluidStack(solderUEV, 1296) },
                // Wireless assembly line slave connector
                dataInAss_Wireless_Hatch.get(1),
                30 * SECONDS,
                (int) TierEU.RECIPE_UEV);

        // Wireless data bank master connector
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                // Data bank master connector
                dataOutAss_Hatch.get(1),
                512000,
                2000,
                100_000_000,
                2,
                new Object[] {
                        // Data bank master connector
                        dataOutAss_Hatch.get(1),
                        // Data bank
                        Machine_Multi_DataBank.get(1),
                        // Data pipe
                        DATApipe.get(64),
                        // Internet card
                        GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 44),
                        // Superdense neutronium plate
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Neutronium, 4),
                        // infinity foil
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Infinity, 64),
                        // UIV circuit
                        new Object[] { OrePrefixes.circuit.get(Materials.UIV), 2L },
                        // UEV emitter
                        ItemList.Emitter_UEV.get(1) },
                new FluidStack[] { new FluidStack(solderUEV, 1296) },
                // Wireless data bank master connector
                dataOutAss_Wireless_Hatch.get(1),
                30 * SECONDS,
                (int) TierEU.RECIPE_UEV);

        // Dyson Swarm Module
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                GTModHandler.getModItem(OpenComputers.ID, "item", 1, 91),
                192_000,
                512,
                (int) TierEU.RECIPE_UEV,
                16,
                new Object[] { ItemList.Cover_SolarPanel_LuV.get(4), ItemList.UHTResistantMesh.get(8),
                        new Object[] { OrePrefixes.circuit.get(Materials.UHV), 2L }, ItemList.Circuit_Chip_QPIC.get(2),
                        ItemList.Emitter_UEV.get(1), ItemList.Sensor_UEV.get(1),
                        GTModHandler.getModItem(OpenComputers.ID, "item", 4, 91) },
                new FluidStack[] { new FluidStack(solderUEV, 18_432) },
                ItemList.DysonSwarmModule.get(64),
                5 * SECONDS,
                (int) TierEU.RECIPE_UHV);

        // Dyson Swarm Energy Receiver Base Casing
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                ItemList.Circuit_Chip_QPIC.get(1),
                192_000,
                512,
                (int) TierEU.RECIPE_UHV,
                32,
                new ItemStack[] { GTUtility.copyAmount(4, ItemRegistry.energyDistributor[9]),
                        ItemList.Circuit_Chip_QPIC.get(64),
                        GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUEV, 4),
                        ItemList.UHV_Coil.get(64), ItemList.UHV_Coil.get(64), },
                new FluidStack[] { new FluidStack(FluidRegistry.getFluid("liquid helium"), 50_000),
                        Materials.SuperCoolant.getFluid(16_000), new FluidStack(solderUEV, 11_520),
                        Materials.UUMatter.getFluid(8_000) },
                ItemList.DysonSwarmReceiverCasing.get(4),
                40 * SECONDS,
                (int) TierEU.RECIPE_UEV);

        // Dyson Swarm Energy Receiver Dish Block
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                ItemList.UHTResistantMesh.get(1),
                192000,
                512,
                (int) TierEU.RECIPE_UHV,
                32,
                new ItemStack[] { ItemList.UHTResistantMesh.get(64),
                        ItemRefer.Advanced_Radiation_Protection_Plate.get(64), ItemList.Reactor_Coolant_Sp_6.get(1),
                        ItemList.Reactor_Coolant_Sp_6.get(1), ItemList.Reactor_Coolant_Sp_6.get(1),
                        ItemList.Reactor_Coolant_Sp_6.get(1),
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Infinity, 8),
                        ItemRefer.Field_Restriction_Coil_T2.get(2) },
                new FluidStack[] { MaterialsElements.STANDALONE.RHUGNOR.getFluidStack(40),
                        Materials.SuperCoolant.getFluid(16_000), new FluidStack(solderUEV, 11_520),
                        Materials.UUMatter.getFluid(8_000) },
                ItemList.DysonSwarmReceiverDish.get(3),
                30 * SECONDS,
                (int) TierEU.RECIPE_UEV);

        // Dyson Swarm Module Deployment Unit Base Casing
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                ItemList.Quantum_Chest_IV.get(1),
                192_000,
                512,
                (int) TierEU.RECIPE_UHV,
                32,
                new Object[] { ItemList.Hull_UIV.get(4), new Object[] { OrePrefixes.circuit.get(Materials.UMV), 4L },
                        ItemList.Electric_Pump_UIV.get(32), ItemList.Quantum_Tank_IV.get(2),
                        ItemList.Conveyor_Module_UIV.get(32), ItemList.Quantum_Chest_IV.get(2) },
                new FluidStack[] { MaterialsUEVplus.DimensionallyShiftedSuperfluid.getFluid(50000),
                        Materials.SuperCoolant.getFluid(16_000), new FluidStack(solderUEV, 11_520),
                        Materials.UUMatter.getFluid(8_000) },
                ItemList.DysonSwarmDeploymentUnitCasing.get(4),
                40 * SECONDS,
                (int) TierEU.RECIPE_UEV);

        // Dyson Swarm Module Deployment Unit Core
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                new ItemStack(Blocks.dropper),
                192_000,
                512,
                (int) TierEU.RECIPE_UHV,
                32,
                new ItemStack[] { ItemList.Hull_UIV.get(4), ItemList.Conveyor_Module_UIV.get(32),
                        ItemList.Robot_Arm_UIV.get(32), ItemList.Electric_Piston_UIV.get(32),
                        new ItemStack(Blocks.dropper, 64), new ItemStack(Blocks.dropper, 64),
                        new ItemStack(Blocks.dropper, 64), new ItemStack(Blocks.dropper, 64), },
                new FluidStack[] { MaterialsUEVplus.DimensionallyShiftedSuperfluid.getFluid(50_000),
                        Materials.SuperCoolant.getFluid(16_000), new FluidStack(solderUEV, 11520),
                        Materials.UUMatter.getFluid(8_000) },
                ItemList.DysonSwarmDeploymentUnitCore.get(1),
                10 * SECONDS,
                (int) TierEU.RECIPE_UEV);

        // Dyson Swarm Module Deployment Unit Superconducting Magnet
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                ItemList.PolarizerUEV.get(1),
                192_000,
                512,
                (int) TierEU.RECIPE_UHV,
                32,
                new Object[] { ItemList.Hull_UIV.get(4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUEV, 16),
                        ItemList.Circuit_Chip_QPIC.get(64),
                        new Object[] { OrePrefixes.circuit.get(Materials.UMV), 8L } },
                new FluidStack[] { MaterialsElements.STANDALONE.RHUGNOR.getFluidStack(40),
                        Materials.SuperCoolant.getFluid(16_000), new FluidStack(solderUEV, 11_520),
                        Materials.UUMatter.getFluid(8_000) },
                ItemList.DysonSwarmDeploymentUnitMagnet.get(4),
                40 * SECONDS,
                (int) TierEU.RECIPE_UEV);

        // Dyson Swarm Control Center Base Casing
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                tectech.thing.CustomItemList.Machine_Multi_Computer.get(1),
                192_000,
                512,
                (int) TierEU.RECIPE_UHV,
                32,
                new Object[] { ItemList.Hull_UIV.get(4), GTModHandler.getModItem(OpenComputers.ID, "item", 4, 103),
                        new Object[] { OrePrefixes.circuit.get(Materials.UMV), 4L },
                        tectech.thing.CustomItemList.Machine_Multi_Computer.get(4), },
                new FluidStack[] { Materials.SuperCoolant.getFluid(32_000), new FluidStack(solderUEV, 11_520),
                        Materials.UUMatter.getFluid(8_000) },
                ItemList.DysonSwarmControlCasing.get(8),
                80 * SECONDS,
                (int) TierEU.RECIPE_UEV);

        // Dyson Swarm Control Center Primary Windings
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                tectech.thing.CustomItemList.tM_TeslaPrimary_6.get(1),
                192_000,
                512,
                (int) TierEU.RECIPE_UHV,
                32,
                new ItemStack[] { ItemList.Circuit_Chip_QPIC.get(4),
                        ItemList.Naquarite_Universal_Insulator_Foil.get(24),
                        tectech.thing.CustomItemList.eM_Coil.get(4) },
                new FluidStack[] { Materials.RadoxPolymer.getMolten(3_456), Materials.SuperCoolant.getFluid(16_000),
                        new FluidStack(solderUEV, 11_520), Materials.UUMatter.getFluid(8_000) },
                ItemList.DysonSwarmControlPrimary.get(4),
                40 * SECONDS,
                (int) TierEU.RECIPE_UEV);

        // Dyson Swarm Control Center Secondary Windings
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                tectech.thing.CustomItemList.tM_TeslaSecondary.get(1),
                192_000,
                512,
                (int) TierEU.RECIPE_UHV,
                32,
                new ItemStack[] { ItemList.Circuit_Chip_QPIC.get(4),
                        ItemList.Naquarite_Universal_Insulator_Foil.get(24),
                        ItemList.Casing_Coil_AwakenedDraconium.get(4) },
                new FluidStack[] { Materials.RadoxPolymer.getMolten(3_240), Materials.SuperCoolant.getFluid(16_000),
                        new FluidStack(solderUEV, 11_520), Materials.UUMatter.getFluid(8_000) },
                ItemList.DysonSwarmControlSecondary.get(4),
                40 * SECONDS,
                (int) TierEU.RECIPE_UEV);

        // Dyson Swarm Control Center Toroid Casing
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                tectech.thing.CustomItemList.tM_TeslaToroid.get(1),
                192_000,
                512,
                (int) TierEU.RECIPE_UHV,
                32,
                new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.screw, Materials.CosmicNeutronium, 4),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Neutronium, 8),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.SuperconductorUEVBase, 4), },
                new FluidStack[] { Materials.RadoxPolymer.getMolten(144), Materials.SuperCoolant.getFluid(16_000),
                        new FluidStack(solderUEV, 11_520), Materials.UUMatter.getFluid(8_000) },
                ItemList.DysonSwarmControlToroid.get(1),
                10 * SECONDS,
                (int) TierEU.RECIPE_UEV);

        // Dyson Swarm Controller
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                ItemList.Machine_UV_SolarPanel.get(1),
                192_000,
                512,
                (int) TierEU.RECIPE_UEV,
                16,
                new Object[] { ItemList.Hull_UIV.get(4), CustomItemList.IrradiantReinforcedBedrockiumPlate.get(4),
                        new Object[] { OrePrefixes.circuit.get(Materials.UMV), 8L },
                        GTModHandler.getModItem(Computronics.ID, "computronics.ocSpecialParts", 4),
                        GTModHandler.getModItem(OpenComputers.ID, "item", 8, 103) },
                new FluidStack[] { MaterialsElements.STANDALONE.RHUGNOR.getFluidStack(100),
                        Materials.SuperCoolant.getFluid(16_000), new FluidStack(solderUEV, 11_520),
                        Materials.UUMatter.getFluid(8_000) },
                ItemList.DysonSwarmController.get(1),
                2 * MINUTES,
                (int) TierEU.RECIPE_UIV);

        if (GalacticraftAmunRa.isModLoaded()) {
            // Nanite Containment Bus
            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    GTModHandler.getModItem(GalacticraftAmunRa.ID, "item.baseItem", 1, 28),
                    32_000,
                    64,
                    (int) TierEU.RECIPE_UV,
                    16,
                    new Object[] { ItemList.Hatch_Input_Bus_MAX.get(1), ItemList.Quantum_Chest_EV.get(1),
                            ItemList.Field_Generator_UHV.get(1),
                            GTModHandler.getModItem(GalacticraftAmunRa.ID, "item.baseItem", 4, 28),
                            GGMaterial.enrichedNaquadahAlloy.get(OrePrefixes.plateDense, 4),
                            GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.CosmicNeutronium, 4) },
                    new FluidStack[] { new FluidStack(solderUEV, 2_304) },
                    ItemList.Hatch_Nanite.get(1),
                    30 * SECONDS,
                    (int) TierEU.RECIPE_UHV);
        }

        // Bulk Catalyst Housing
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                GregtechItemList.Bus_Catalysts.get(1),
                2_048_000,
                64,
                (int) TierEU.RECIPE_UEV,
                16,
                new Object[] { ItemList.Hull_UEV.get(1), ItemList.Quantum_Chest_IV.get(1),
                        MaterialsAlloy.QUANTUM.getFrameBox(16), ItemList.Field_Generator_UEV.get(1),
                        GregtechItemList.Laser_Lens_Special.get(4),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.CosmicNeutronium, 64),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.InfinityCatalyst, 32),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Infinity, 16) },
                new FluidStack[] { new FluidStack(solderUEV, 9_216), MaterialsAlloy.ABYSSAL.getFluidStack(144 * 128),
                        MaterialsAlloy.OCTIRON.getFluidStack(144 * 256) },
                ItemList.Hatch_Catalyst_Bulk.get(1),
                30 * SECONDS,
                (int) TierEU.RECIPE_UEV);

        if (SGCraft.isModLoaded() && EternalSingularity.isModLoaded()) {

            // The first crafted gate
            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    ItemList.Circuit_Biomainframe.get(1L),
                    192_000,
                    512,
                    (int) TierEU.RECIPE_UHV,
                    32,
                    new Object[] { GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Tritanium, 8),
                            ItemList.Circuit_Biomainframe.get(2L), ItemList.Circuit_Parts_CapacitorASMD.get(32L),
                            ItemList.Circuit_Parts_ResistorASMD.get(32L),
                            ItemList.Circuit_Parts_TransistorASMD.get(32L), ItemList.Circuit_Parts_DiodeASMD.get(32L),
                            ItemList.Circuit_Chip_Ram.get(64L), ItemList.Circuit_Chip_NPIC.get(64L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Draconium, 64),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUHV, 64),
                            new Object[] { OrePrefixes.foil.get(Materials.AnySyntheticRubber), 64L },
                            GTOreDictUnificator.get(OrePrefixes.foil, Materials.Polybenzimidazole, 64) },
                    new FluidStack[] { Materials.SolderingAlloy.getMolten(3_744L),
                            Materials.Naquadria.getMolten(4_032L),
                            new FluidStack(FluidRegistry.getFluid("ic2coolant"), 20_000) },
                    NHItemList.NanoCircuitOrigin.getIS(1),
                    400 * SECONDS,
                    (int) TierEU.RECIPE_UEV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    GTOreDictUnificator.get(OrePrefixes.foil, Materials.Infinity, 1L),
                    192_000,
                    512,
                    (int) TierEU.RECIPE_UHV,
                    32,
                    new ItemStack[] { GTModHandler.getModItem(EternalSingularity.ID, "eternal_singularity", 1L),
                            ItemList.Sensor_UV.get(16L),
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.Infinity, 16L),
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.CosmicNeutronium, 16L),
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 64L),
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 64L),
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 64L),
                            NHItemList.NanoCircuitOrigin.getIS(16) },
                    new FluidStack[] { Materials.Neutronium.getMolten(36_864L), Materials.Tritanium.getMolten(36_864L),
                            Materials.Tetranaquadahdiindiumhexaplatiumosminid.getMolten(36_864L),
                            Materials.Silver.getPlasma(36_864L) },
                    NHItemList.GatePlateOrigin.getIS(1),
                    1 * HOURS,
                    (int) TierEU.RECIPE_UHV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    GTOreDictUnificator.get(OrePrefixes.block, Materials.Infinity, 1L),
                    192_000,
                    512,
                    (int) TierEU.RECIPE_UHV,
                    32,
                    new ItemStack[] { ItemList.Electric_Piston_UV.get(16L), ItemList.Electric_Motor_UV.get(64L),
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.Infinity, 16L),
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 64L),
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.NetherStar, 16L),
                            GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Ardite, 8L),
                            GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Ardite, 8L),
                            GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Ardite, 8L),
                            GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Ruby, 64L),
                            GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Jasper, 64L),
                            NHItemList.NanoCircuitOrigin.getIS(32) },
                    new FluidStack[] { Materials.Neutronium.getMolten(9_216L), Materials.Tritanium.getMolten(9_216L),
                            Materials.Tetranaquadahdiindiumhexaplatiumosminid.getMolten(9_216L),
                            Materials.Silver.getPlasma(9_216L) },
                    NHItemList.ChevronOrigin.getIS(1),
                    1 * HOURS,
                    (int) TierEU.RECIPE_UHV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Neutronium, 1L),
                    192_000,
                    512,
                    (int) TierEU.RECIPE_UHV,
                    32,
                    new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Infinity, 64L),
                            GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.NaquadahAlloy, 64L),
                            GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.CosmicNeutronium, 64L),
                            GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Neutronium, 64L),
                            GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Osmiridium, 64L) },
                    new FluidStack[] { Materials.Neutronium.getMolten(73728L), Materials.Tritanium.getMolten(73_728L),
                            Materials.Concrete.getMolten(73_728L) },
                    NHItemList.FramePartOrigin.getIS(1),
                    1 * HOURS,
                    (int) TierEU.RECIPE_UHV);

            // UEV Gate
            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.NanoCircuitOrigin.getIS(1),
                    192000 * 2,
                    512 * 2,
                    4_000_000,
                    32 * 2,
                    new Object[] { ItemList.Circuit_Board_Bio_Ultra.get(1L), NHItemList.PicoWafer.getIS(4),
                            NHItemList.NanoCircuitOrigin.getIS(2), ItemList.Circuit_Parts_TransistorXSMD.get(48L),
                            ItemList.Circuit_Parts_ResistorXSMD.get(48L), ItemList.Circuit_Parts_CapacitorXSMD.get(48L),
                            ItemList.Circuit_Parts_DiodeXSMD.get(48L), ItemList.Circuit_Chip_PPIC.get(64L),
                            GTOreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 16),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Osmium, 32),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Neutronium, 16),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Lanthanum, 64) },
                    new FluidStack[] { Materials.SolderingAlloy.getMolten(3744L), Materials.UUMatter.getFluid(8_000L),
                            Materials.Osmium.getMolten(1_152L) },
                    NHItemList.PikoCircuitPolychrome.getIS(1),
                    500 * SECONDS,
                    (int) TierEU.RECIPE_UEV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.PikoCircuitPolychrome.getIS(1),
                    192000 * 4,
                    512 * 4,
                    (int) TierEU.RECIPE_UEV,
                    32 * 4,
                    new Object[] { GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Neutronium, 16),
                            NHItemList.PikoCircuitPolychrome.getIS(2), ItemList.Circuit_Parts_CapacitorXSMD.get(64L),
                            ItemList.Circuit_Parts_DiodeXSMD.get(64L), ItemList.Circuit_Parts_TransistorXSMD.get(64L),
                            ItemList.Circuit_Parts_ResistorXSMD.get(64L), ItemList.Circuit_Chip_QPIC.get(64L),
                            GTOreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 64),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Indium, 64),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Bedrockium, 8),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Lanthanum, 64) },
                    new FluidStack[] { Materials.SolderingAlloy.getMolten(3744L), Materials.UUMatter.getFluid(24_000L),
                            Materials.Osmium.getMolten(2_304L) },
                    NHItemList.QuantumCircuitPolychrome.getIS(1),
                    1000 * SECONDS,
                    (int) TierEU.RECIPE_UIV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.GatePlateOrigin.getIS(1),
                    32_000_000 * 12,
                    8192,
                    (int) TierEU.RECIPE_UIV,
                    64,
                    new ItemStack[] { GTModHandler.getModItem(EternalSingularity.ID, "eternal_singularity", 1L),
                            ItemList.Sensor_UEV.get(16L),
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.Infinity, 16L),
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.CosmicNeutronium, 16L),
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 64L),
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 64L),
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 64L),
                            NHItemList.QuantumCircuitPolychrome.getIS(16) },
                    new FluidStack[] { Materials.Neutronium.getMolten(36_864L), Materials.Tritanium.getMolten(36_864L),
                            Materials.Longasssuperconductornameforuhvwire.getMolten(36_864L),
                            Materials.Silver.getPlasma(36_864L) },
                    NHItemList.GatePlatePolychrome.getIS(1),
                    1 * HOURS,
                    (int) TierEU.RECIPE_UIV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.ChevronOrigin.getIS(1),
                    32_000_000 * 12,
                    8192,
                    (int) TierEU.RECIPE_UIV,
                    64,
                    new ItemStack[] { ItemList.Electric_Piston_UEV.get(16L), ItemList.Electric_Motor_UEV.get(64L),
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.Infinity, 16L),
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 64L),
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.NetherStar, 16L),
                            GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Ardite, 8L),
                            GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Ardite, 8L),
                            GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Ardite, 8L),
                            GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Ruby, 64L),
                            GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Jasper, 64L),
                            NHItemList.QuantumCircuitPolychrome.getIS(32) },
                    new FluidStack[] { Materials.Neutronium.getMolten(9_216L), Materials.Tritanium.getMolten(9_216L),
                            Materials.Longasssuperconductornameforuhvwire.getMolten(9_216L),
                            Materials.Silver.getPlasma(9_216L) },
                    NHItemList.ChevronPolychrome.getIS(1),
                    1 * HOURS,
                    (int) TierEU.RECIPE_UIV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.FramePartOrigin.getIS(1),
                    32_000_000 * 12,
                    8192,
                    (int) TierEU.RECIPE_UIV,
                    64,
                    new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Infinity, 64L),
                            GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.NaquadahAlloy, 64L),
                            GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.CosmicNeutronium, 64L),
                            GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Neutronium, 64L),
                            GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Osmiridium, 64L) },
                    new FluidStack[] { Materials.Neutronium.getMolten(73_728L), Materials.Tritanium.getMolten(73_728L),
                            Materials.Concrete.getMolten(73_728L) },
                    NHItemList.FramePartPolychrome.getIS(1),
                    1 * HOURS,
                    (int) TierEU.RECIPE_UIV);

            // UMV Gate
            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    ItemList.Circuit_Wafer_NPIC.get(1L),
                    192_000,
                    512,
                    (int) TierEU.RECIPE_UEV,
                    32,
                    new Object[] { GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Tritanium, 8),
                            ItemList.Circuit_Biomainframe.get(2L), ItemList.Circuit_Parts_CapacitorXSMD.get(32L),
                            ItemList.Circuit_Parts_ResistorXSMD.get(32L),
                            ItemList.Circuit_Parts_TransistorXSMD.get(32L), ItemList.Circuit_Parts_DiodeXSMD.get(32L),
                            ItemList.Circuit_Chip_Ram.get(64L), ItemList.Circuit_Chip_NPIC.get(64L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Draconium, 64),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUHV, 64),
                            new Object[] { OrePrefixes.foil.get(Materials.AnySyntheticRubber), 64L },
                            GTOreDictUnificator.get(OrePrefixes.foil, Materials.Polybenzimidazole, 64) },
                    new FluidStack[] { new FluidStack(FluidRegistry.getFluid("molten.mutatedlivingsolder"), 3_744),
                            Materials.Naquadria.getMolten(4_032L),
                            new FluidStack(FluidRegistry.getFluid("ic2coolant"), 20_000) },
                    NHItemList.NanoCircuit.getIS(1),
                    400 * SECONDS,
                    (int) TierEU.RECIPE_UIV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.NanoCircuit.getIS(1),
                    384_000,
                    1_024,
                    4_000_000,
                    64,
                    new Object[] { ItemList.Circuit_Board_Bio_Ultra.get(1L), NHItemList.PicoWafer.getIS(4),
                            NHItemList.NanoCircuit.getIS(2), ItemList.Circuit_Parts_TransistorXSMD.get(48L),
                            ItemList.Circuit_Parts_ResistorXSMD.get(48L), ItemList.Circuit_Parts_CapacitorXSMD.get(48L),
                            ItemList.Circuit_Parts_DiodeXSMD.get(48L), ItemList.Circuit_Chip_PPIC.get(64L),
                            GTOreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 16),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Osmium, 32),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Neutronium, 16),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Lanthanum, 64) },
                    new FluidStack[] { new FluidStack(FluidRegistry.getFluid("molten.mutatedlivingsolder"), 3_744),
                            Materials.UUMatter.getFluid(8000L), Materials.Osmium.getMolten(1152L) },
                    NHItemList.PikoCircuitDimensional.getIS(1),
                    500 * SECONDS,
                    (int) TierEU.RECIPE_UMV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.PikoCircuitDimensional.getIS(1),
                    720_000,
                    2_048,
                    (int) TierEU.RECIPE_UEV,
                    128,
                    new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Neutronium, 16),
                            NHItemList.PikoCircuitDimensional.getIS(2), ItemList.Circuit_Parts_CapacitorXSMD.get(64L),
                            ItemList.Circuit_Parts_DiodeXSMD.get(64L), ItemList.Circuit_Parts_TransistorXSMD.get(64L),
                            ItemList.Circuit_Parts_ResistorXSMD.get(64L), ItemList.Circuit_Chip_QPIC.get(64L),
                            GTOreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 64),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Indium, 64),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, MaterialsUEVplus.SpaceTime, 8),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Lanthanum, 64) },
                    new FluidStack[] { new FluidStack(FluidRegistry.getFluid("molten.mutatedlivingsolder"), 3_744),
                            Materials.UUMatter.getFluid(24_000L), Materials.Osmium.getMolten(2_304L) },
                    NHItemList.QuantumCircuitDimensional.getIS(1),
                    1000 * SECONDS,
                    (int) TierEU.RECIPE_UXV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.GatePlatePolychrome.getIS(1),
                    2_000_000_000,
                    32_768,
                    (int) TierEU.RECIPE_UXV,
                    64,
                    new ItemStack[] { ItemList.Casing_Dim_Bridge.get(64),
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.Infinity, 64L),
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.Infinity, 64L),
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.Infinity, 64L),
                            GTOreDictUnificator.get(OrePrefixes.block, MaterialsUEVplus.SpaceTime, 16L),
                            NHItemList.QuantumCircuitDimensional.getIS(16),
                            GTOreDictUnificator.get(OrePrefixes.plateDense, MaterialsUEVplus.SpaceTime, 8L),
                            GTOreDictUnificator.get(OrePrefixes.plateDense, MaterialsUEVplus.SpaceTime, 8L),
                            GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Infinity, 8L),
                            GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Infinity, 8L),
                            ItemList.Sensor_UMV.get(16L), ItemList.Emitter_UMV.get(16L),
                            GTModHandler.getModItem(EternalSingularity.ID, "eternal_singularity", 16L) },
                    new FluidStack[] { Materials.Neutronium.getMolten(32_768_000L),
                            MaterialsUEVplus.SpaceTime.getMolten(4 * 36864L),
                            Materials.SuperconductorUMVBase.getMolten(4 * 36864L),
                            MaterialsUEVplus.ExcitedDTEC.getFluid(4 * 36864L) },
                    NHItemList.GatePlateDimensional.getIS(1),
                    1 * HOURS,
                    (int) TierEU.RECIPE_UXV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.ChevronPolychrome.getIS(1),
                    2_000_000_000,
                    32_768,
                    (int) TierEU.RECIPE_UXV,
                    64,
                    new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.block, Materials.Infinity, 64L),
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 64L),
                            ItemList.Casing_Dim_Bridge.get(64), ItemList.Casing_Dim_Bridge.get(64),
                            GTOreDictUnificator.get(OrePrefixes.frameGt, MaterialsUEVplus.SpaceTime, 16L),
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Infinity, 16L),
                            GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Ruby, 16L),
                            GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Jasper, 16L),
                            GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Opal, 16L),
                            GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Sapphire, 16L),
                            GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Osmiridium, 8L),
                            GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Osmiridium, 8L),
                            ItemList.Electric_Motor_UMV.get(64L), ItemList.Electric_Piston_UMV.get(64L),
                            ItemList.Field_Generator_UMV.get(16L), NHItemList.QuantumCircuitDimensional.getIS(32), },
                    new FluidStack[] { Materials.Neutronium.getMolten(32_768_000L),
                            MaterialsUEVplus.SpaceTime.getMolten(4 * 36864L),
                            Materials.SuperconductorUMVBase.getMolten(4 * 36864L),
                            MaterialsUEVplus.ExcitedDTEC.getFluid(4 * 36864L) },
                    NHItemList.ChevronDimensional.getIS(1),
                    1 * HOURS,
                    (int) TierEU.RECIPE_UXV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.FramePartPolychrome.getIS(1),
                    2_000_000_000,
                    32_768,
                    (int) TierEU.RECIPE_UXV,
                    64,
                    new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Infinity, 64L),
                            GTOreDictUnificator.get(OrePrefixes.stickLong, MaterialsUEVplus.SpaceTime, 64L),
                            GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.NaquadahAlloy, 64L),
                            GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.CosmicNeutronium, 64L),
                            GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Neutronium, 64L),
                            GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Osmiridium, 64L),
                            Californium.get(OrePrefixes.stickLong, 64), MaterialsAlloy.QUANTUM.getLongRod(64),
                            MaterialsElements.STANDALONE.HYPOGEN.getLongRod(64),
                            MaterialsElements.STANDALONE.CELESTIAL_TUNGSTEN.getLongRod(64),
                            GGMaterial.tairitsu.get(OrePrefixes.stickLong, 64),
                            MaterialsElements.STANDALONE.ASTRAL_TITANIUM.getLongRod(64),
                            GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.SuperconductorUMVBase, 64L),
                            GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Sunnarium, 64L),
                            MaterialsAlloy.ABYSSAL.getLongRod(64),
                            GTOreDictUnificator.get(OrePrefixes.stickLong, MaterialsUEVplus.TranscendentMetal, 64L), },
                    new FluidStack[] { Materials.Neutronium.getMolten(32_768_000L),
                            MaterialsUEVplus.SpaceTime.getMolten(4 * 36864L),
                            Materials.SuperconductorUMVBase.getMolten(4 * 36864L),
                            MaterialsUEVplus.ExcitedDTEC.getFluid(4 * 36864L) },
                    NHItemList.FramePartDimensional.getIS(1),
                    1 * HOURS,
                    (int) TierEU.RECIPE_UXV);

            // EOH Gate
            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.GatePlateDimensional.getIS(1),
                    (int) TierEU.RECIPE_MAX,
                    32768,
                    (int) TierEU.RECIPE_UXV,
                    64,
                    new Object[] { ItemList.Casing_Dim_Bridge.get(64),
                            tectech.thing.CustomItemList.StabilisationFieldGeneratorTier8.get(64),
                            GTOreDictUnificator.get("blockShirabon", 64L),
                            GTOreDictUnificator.get("blockShirabon", 64L),
                            GTOreDictUnificator.get(OrePrefixes.block, MaterialsUEVplus.SpaceTime, 64L),
                            new Object[] { OrePrefixes.circuit.get(Materials.UXV), 16L },
                            GTOreDictUnificator.get(OrePrefixes.plateDense, MaterialsUEVplus.SpaceTime, 8L),
                            GTOreDictUnificator.get(OrePrefixes.plateDense, MaterialsUEVplus.Universium, 8L),
                            GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Infinity, 8L),
                            GTOreDictUnificator.get("plateDenseShirabon", 8L), ItemList.Sensor_UXV.get(16L),
                            ItemList.Emitter_UXV.get(16L),
                            getModItem(EternalSingularity.ID, "eternal_singularity", 16L),
                            MaterialsUEVplus.Universium.getNanite(16), MaterialsUEVplus.BlackDwarfMatter.getNanite(16),
                            MaterialsUEVplus.WhiteDwarfMatter.getNanite(16) },
                    new FluidStack[] { Materials.Neutronium.getMolten(32_768_000L),
                            MaterialsUEVplus.SpaceTime.getMolten(4 * 36864L),
                            Materials.SuperconductorUMVBase.getMolten(4 * 36864L),
                            MaterialsUEVplus.ExcitedDTEC.getFluid(4 * 36864L) },
                    NHItemList.GatePlateHarmonic.getIS(1),
                    125_000 * SECONDS,
                    (int) TierEU.RECIPE_UMV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.ChevronDimensional.getIS(1),
                    (int) TierEU.RECIPE_MAX,
                    32_768,
                    (int) TierEU.RECIPE_UXV,
                    64,
                    new Object[] { GTOreDictUnificator.get(OrePrefixes.block, MaterialsUEVplus.TranscendentMetal, 64L),
                            GTOreDictUnificator.get("blockShirabon", 64),
                            tectech.thing.CustomItemList.EOH_Reinforced_Spatial_Casing.get(64),
                            tectech.thing.CustomItemList.EOH_Reinforced_Spatial_Casing.get(64),
                            GTOreDictUnificator.get(OrePrefixes.frameGt, MaterialsUEVplus.SpaceTime, 16L),
                            GTOreDictUnificator.get(
                                    OrePrefixes.frameGt,
                                    MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter,
                                    16L),
                            GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Ruby, 16L),
                            GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Jasper, 16L),
                            GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Opal, 16L),
                            GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Sapphire, 16L),
                            GTOreDictUnificator.get(
                                    OrePrefixes.plateDense,
                                    MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter,
                                    8L),
                            GTOreDictUnificator.get("plateDenseShirabon", 8), ItemList.Electric_Motor_UXV.get(64L),
                            ItemList.Electric_Piston_UXV.get(64L), ItemList.Field_Generator_UXV.get(16L),
                            new Object[] { OrePrefixes.circuit.get(Materials.UXV), 32L } },
                    new FluidStack[] { Materials.Neutronium.getMolten(32_768_000L),
                            MaterialsUEVplus.SpaceTime.getMolten(4 * 36864L),
                            MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter.getMolten(36864L),
                            MaterialsUEVplus.ExcitedDTEC.getFluid(4 * 36864L) },
                    NHItemList.ChevronHarmonic.getIS(1),
                    125_000 * SECONDS,
                    (int) TierEU.RECIPE_UMV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.FramePartDimensional.getIS(1),
                    (int) TierEU.RECIPE_MAX,
                    32_768,
                    (int) TierEU.RECIPE_UXV,
                    64,
                    new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Infinity, 64L),
                            GTOreDictUnificator.get(OrePrefixes.stickLong, MaterialsUEVplus.SpaceTime, 64L),
                            GTOreDictUnificator.get(
                                    OrePrefixes.stickLong,
                                    MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter,
                                    64L),
                            GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Neutronium, 64L),

                            GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Osmiridium, 64L),
                            GTOreDictUnificator.get("stickLongShirabon", 64),
                            new ItemStack(WerkstoffLoader.items.get(OrePrefixes.stickLong), 64, 39),
                            MaterialsAlloy.QUANTUM.getLongRod(64), MaterialsElements.STANDALONE.HYPOGEN.getLongRod(64),
                            MaterialsElements.STANDALONE.CELESTIAL_TUNGSTEN.getLongRod(64),
                            new ItemStack(WerkstoffLoader.items.get(OrePrefixes.stickLong), 64, 10106),
                            MaterialsElements.STANDALONE.ASTRAL_TITANIUM.getLongRod(64),

                            GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.SuperconductorUMVBase, 64L),
                            GTOreDictUnificator.get(OrePrefixes.stickLong, MaterialsUEVplus.Universium, 64L),
                            MaterialsAlloy.ABYSSAL.getLongRod(64),
                            GTOreDictUnificator.get(OrePrefixes.stickLong, MaterialsUEVplus.TranscendentMetal, 64L), },
                    new FluidStack[] { Materials.Neutronium.getMolten(32_768_000L),
                            MaterialsUEVplus.SpaceTime.getMolten(4 * 36864L),
                            MaterialsUEVplus.Universium.getMolten(4 * 36864L),
                            MaterialsUEVplus.ExcitedDTEC.getFluid(4 * 36864L) },
                    NHItemList.FramePartHarmonic.getIS(1),
                    125_000 * SECONDS,
                    (int) TierEU.RECIPE_UMV);
        }

        GTValues.RA.stdBuilder()
                .metadata(RESEARCH_ITEM, GTModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1L))
                .metadata(SCANNING, new Scanning(1 * MINUTES + 40 * SECONDS, TierEU.RECIPE_EV))
                .itemInputs(
                        ItemList.Hatch_Input_Bus_ME.get(1L),
                        // 4096k Me Storage Component
                        GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 59),
                        // ME Controller
                        GTModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockController", 1, WILDCARD),
                        // Interface
                        GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 440),
                        // Pattern capacity card
                        GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 3, 54))
                .fluidInputs(new FluidStack(solderIndalloy, 1152))
                .itemOutputs(ItemList.Hatch_CraftingInput_Bus_ME_ItemOnly.get(1L)).eut(TierEU.RECIPE_LuV)
                .duration(30 * SECONDS).addTo(AssemblyLine);

        if (GraviSuite.isModLoaded()) {
            // GraviChestPlate
            GTValues.RA.stdBuilder()
                    .metadata(RESEARCH_ITEM, GTModHandler.getIC2Item("quantumBodyarmor", 1L, GTValues.W))
                    .metadata(SCANNING, new Scanning(2 * MINUTES + 20 * SECONDS, TierEU.RECIPE_LuV))
                    .itemInputs(
                            GTModHandler.getIC2Item("quantumBodyarmor", 1L, WILDCARD),
                            ItemList.Transformer_ZPM_LuV.get(1L),
                            GTModHandler.getModItem(GraviSuite.ID, "ultimateLappack", 1, WILDCARD),
                            GTModHandler.getModItem(GraviSuite.ID, "itemSimpleItem", 6, 1),
                            GTModHandler.getModItem(GraviSuite.ID, "itemSimpleItem", 2, 2),
                            GTModHandler.getModItem(GraviSuite.ID, "itemSimpleItem", 2, 3),
                            new Object[] { OrePrefixes.circuit.get(Materials.ZPM), 2L },
                            GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Duranium, 2),
                            ItemList.Energy_LapotronicOrb2.get(1L),
                            ItemList.Field_Generator_IV.get(2L),
                            ItemList.Electric_Motor_ZPM.get(2L),
                            GTOreDictUnificator.get(OrePrefixes.screw, Materials.Duranium, 4))
                    .fluidInputs(new FluidStack(solderIndalloy, 2304), Materials.Tritanium.getMolten(1440L))
                    .itemOutputs(GTModHandler.getModItem(GraviSuite.ID, "graviChestPlate", 1, 26))
                    .eut(TierEU.RECIPE_LuV / 2).duration(1 * MINUTES + 15 * SECONDS).addTo(AssemblyLine);

            // Relocator
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Casing_Coil_Superconductor.get(1L))
                    .metadata(SCANNING, new Scanning(2 * MINUTES, TierEU.RECIPE_ZPM))
                    .itemInputs(
                            ItemList.Casing_Fusion_Coil.get(16L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUV, 16L),
                            new Object[] { OrePrefixes.circuit.get(Materials.UV), 16L },
                            ItemList.Sensor_UV.get(16L),
                            ItemList.Emitter_UV.get(16L),
                            ItemList.Field_Generator_UV.get(8L),
                            ItemList.Circuit_Wafer_QPIC.get(64L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L))
                    .fluidInputs(
                            Materials.Longasssuperconductornameforuvwire.getMolten(2880L),
                            Materials.Americium.getPlasma(2880L),
                            Materials.Enderium.getMolten(5760L))
                    .itemOutputs(GTModHandler.getModItem(GraviSuite.ID, "relocator", 1, 26)).eut(TierEU.RECIPE_UV)
                    .duration(3 * MINUTES).addTo(AssemblyLine);
        }

        // Electromagnets
        {
            // Steel Electromagnet
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Electromagnet_Iron.get(1))
                    .metadata(SCANNING, new Scanning(40 * SECONDS, TierEU.RECIPE_IV))
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.NickelZincFerrite, 32L),
                            GTOreDictUnificator.get(OrePrefixes.ring, Materials.SteelMagnetic, 16L),
                            ItemList.LuV_Coil.get(16L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorLuV, 32L),
                            ItemList.Field_Generator_LuV.get(2))
                    .itemOutputs(ItemList.Electromagnet_Steel.get(1))
                    .fluidInputs(
                            new FluidStack(FluidRegistry.getFluid("ic2coolant"), 8000),
                            Materials.Cobalt.getMolten(2304),
                            Materials.VanadiumGallium.getMolten(2304))
                    .duration(60 * SECONDS).eut((int) TierEU.RECIPE_LuV).addTo(AssemblyLine);

            // Neodymium Electromagnet
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Electromagnet_Steel.get(1))
                    .metadata(SCANNING, new Scanning(50 * SECONDS, TierEU.RECIPE_LuV))
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 32L),
                            GTOreDictUnificator.get(OrePrefixes.ring, Materials.NeodymiumMagnetic, 16L),
                            ItemList.ZPM_Coil.get(16L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorZPM, 32L),
                            ItemList.Field_Generator_ZPM.get(2))
                    .itemOutputs(ItemList.Electromagnet_Neodymium.get(1))
                    .fluidInputs(
                            new FluidStack(FluidRegistry.getFluid("ic2coolant"), 16000),
                            Materials.Cobalt.getMolten(4608),
                            Materials.Osmiridium.getMolten(2304))
                    .duration(60 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(AssemblyLine);

            // Samarium Electromagnet
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Electromagnet_Neodymium.get(1))
                    .metadata(SCANNING, new Scanning(1 * MINUTES, TierEU.RECIPE_ZPM))
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Neutronium, 32L),
                            GTOreDictUnificator.get(OrePrefixes.ring, Materials.SamariumMagnetic, 32L),
                            ItemList.UV_Coil.get(32L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorUV, 64L),
                            ItemList.Field_Generator_UV.get(2))
                    .itemOutputs(ItemList.Electromagnet_Samarium.get(1))
                    .fluidInputs(
                            new FluidStack(FluidRegistry.getFluid("supercoolant"), 32000),
                            Materials.Cobalt.getMolten(6912),
                            Materials.ElectrumFlux.getMolten(2304))
                    .duration(60 * SECONDS).eut(TierEU.RECIPE_UV).addTo(AssemblyLine);

            // Tengam Electromagnet
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Electromagnet_Samarium.get(1))
                    .metadata(SCANNING, new Scanning(1 * MINUTES + 10 * SECONDS, TierEU.RECIPE_UV))
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.CosmicNeutronium, 32L),
                            GTOreDictUnificator.get(OrePrefixes.ring, Materials.TengamAttuned, 32L),
                            ItemList.UHV_Coil.get(32L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.SuperconductorUHV, 64L),
                            ItemList.Field_Generator_UHV.get(2))
                    .itemOutputs(ItemList.Electromagnet_Tengam.get(1))
                    .fluidInputs(
                            new FluidStack(FluidRegistry.getFluid("supercoolant"), 64000),
                            Materials.Cobalt.getMolten(9216),
                            Materials.Naquadria.getMolten(2304))
                    .duration(60 * SECONDS).eut(TierEU.RECIPE_UHV).addTo(AssemblyLine);
        }

        // Compressor controllers
        {
            if (EtFuturumRequiem.isModLoaded()) {
                GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Machine_Multi_IndustrialCompressor.get(1))
                        .metadata(SCANNING, new Scanning(1 * MINUTES + 20 * SECONDS, TierEU.RECIPE_LuV))
                        .itemInputs(
                                ItemList.Machine_Multi_IndustrialCompressor.get(4),
                                ItemList.Heating_Duct_Casing.get(4L),
                                ItemList.Coolant_Duct_Casing.get(4L),
                                getModItem(EtFuturumRequiem.ID, "netherite_block", 4, missing),
                                ItemList.Electric_Piston_ZPM.get(16),
                                ItemList.Robot_Arm_ZPM.get(4),
                                ItemList.Electric_Pump_ZPM.get(4),
                                new Object[] { OrePrefixes.circuit.get(Materials.UV), 4 })
                        .itemOutputs(ItemList.Machine_Multi_HIPCompressor.get(1))
                        .fluidInputs(
                                GGMaterial.incoloy903.getMolten(256 * 144),
                                Materials.NaquadahEnriched.getMolten(64 * 144),
                                Materials.LiquidAir.getFluid(16000),
                                Materials.Lubricant.getFluid(16000))
                        .duration(120 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(AssemblyLine);
            }

            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, getModItem(Avaritia.ID, "Singularity", 1L, 0))
                    .metadata(SCANNING, new Scanning(3 * MINUTES, TierEU.RECIPE_UEV))
                    .itemInputs(
                            ItemList.Machine_Multi_HIPCompressor.get(1),
                            ItemList.Machine_Multi_NeutroniumCompressor.get(1),
                            GregtechItemList.Machine_Adv_ImplosionCompressor.get(16),
                            ItemList.CompressorUIV.get(8L),
                            GTUtility.copyAmount(4, ItemRegistry.eic.copy()),
                            ItemList.Field_Generator_UEV.get(4),
                            ItemList.ZPM3.get(2),
                            new Object[] { OrePrefixes.circuit.get(Materials.UIV), 4 },
                            GregtechItemList.Laser_Lens_Special.get(64),
                            GTOreDictUnificator.get(OrePrefixes.ring, MaterialsUEVplus.ProtoHalkonite, 32),
                            GTOreDictUnificator.get(OrePrefixes.rotor, MaterialsUEVplus.ProtoHalkonite, 16),
                            GTOreDictUnificator.get(OrePrefixes.gear, MaterialsUEVplus.ProtoHalkonite, 8),
                            GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Neutronium, 16),
                            GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Naquadria, 16),
                            GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.CosmicNeutronium, 8),
                            GTOreDictUnificator.get(OrePrefixes.plateSuperdense, MaterialsKevlar.Kevlar, 4))
                    .itemOutputs(ItemList.Machine_Multi_BlackHoleCompressor.get(1))
                    .fluidInputs(
                            MaterialsUEVplus.SpaceTime.getMolten(1440),
                            new FluidStack(FluidRegistry.getFluid("oganesson"), 256000),
                            Materials.SuperconductorUIVBase.getMolten(144 * 300),
                            Materials.Infinity.getMolten(144 * 100))
                    .duration(120 * SECONDS).eut(TierEU.RECIPE_UIV).addTo(AssemblyLine);
        }

        // Waterline controllers
        {

            // Water Purification Plant
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, new ItemStack(Items.water_bucket, 1))
                    .metadata(SCANNING, new Scanning(30 * SECONDS, TierEU.RECIPE_IV))
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Tungsten, 4L),
                            ItemList.BlockIndustrialWaterPlantCasing.get(8),
                            ItemList.BlockSterileWaterPlantCasing.get(8),
                            ItemList.Electric_Motor_LuV.get(2),
                            ItemList.Robot_Arm_LuV.get(1),
                            ItemList.Electric_Pump_LuV.get(4),
                            new Object[] { OrePrefixes.circuit.get(Materials.LuV), 4 },
                            new Object[] { OrePrefixes.circuit.get(Materials.ZPM), 2 },
                            GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.NiobiumTitanium, 8))
                    .fluidInputs(new FluidStack(solderIndalloy, 8 * 144), Materials.Lubricant.getFluid(16000))
                    .itemOutputs(ItemList.Machine_Multi_PurificationPlant.get(1)).duration(60 * SECONDS)
                    .eut(TierEU.RECIPE_LuV).addTo(AssemblyLine);

            // Clarifier Purification Unit
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, GregtechItemList.Industrial_Sifter.get(1))
                    .metadata(SCANNING, new Scanning(40 * SECONDS, TierEU.RECIPE_IV))
                    .itemInputs(
                            ItemList.ActivatedCarbonFilterMesh.get(16),
                            ItemList.BlockSterileWaterPlantCasing.get(8),
                            ItemList.Casing_Vent.get(8),
                            tectech.thing.CustomItemList.eM_energyMulti64_LuV.get(1),
                            ItemList.Electric_Motor_LuV.get(4),
                            ItemList.Electric_Pump_LuV.get(4),
                            new Object[] { OrePrefixes.circuit.get(Materials.LuV), 4 },
                            new Object[] { OrePrefixes.circuit.get(Materials.ZPM), 2 },
                            GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.TungstenSteel, 16))
                    .fluidInputs(
                            Materials.Osmium.getMolten(8 * 144),
                            new FluidStack(solderIndalloy, 8 * 144),
                            Materials.Lubricant.getFluid(16000))
                    .itemOutputs(ItemList.Machine_Multi_PurificationUnitClarifier.get(1)).duration(60 * SECONDS)
                    .eut(TierEU.RECIPE_LuV).addTo(AssemblyLine);

            // Ozonation Purification Unit
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, Materials.Grade1PurifiedWater.getCells(1))
                    .metadata(SCANNING, new Scanning(40 * SECONDS, TierEU.RECIPE_IV))
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 8),
                            ItemList.BlockOzoneCasing.get(8),
                            ItemList.Casing_Vent.get(8),
                            tectech.thing.CustomItemList.eM_energyMulti64_LuV.get(1),
                            HASTELLOY_C276.getPlate(8),
                            HASTELLOY_C276.getRotor(4),
                            HASTELLOY_X.getRotor(4),
                            HASTELLOY_X.getPlate(8),
                            ItemList.Electric_Motor_LuV.get(4),
                            ItemList.Electric_Pump_LuV.get(4),
                            new Object[] { OrePrefixes.circuit.get(Materials.LuV), 8 },
                            new Object[] { OrePrefixes.circuit.get(Materials.ZPM), 4 },
                            GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.TungstenSteel, 32))
                    .fluidInputs(
                            HASTELLOY_C276.getFluidStack(8 * 144),
                            HASTELLOY_X.getFluidStack(8 * 144),
                            new FluidStack(solderIndalloy, 8 * 144),
                            Materials.Lubricant.getFluid(16000))
                    .itemOutputs(ItemList.Machine_Multi_PurificationUnitOzonation.get(1)).duration(60 * SECONDS)
                    .eut(TierEU.RECIPE_LuV).addTo(AssemblyLine);

            // Flocculation Purification Unit
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, Materials.Grade2PurifiedWater.getCells(1))
                    .metadata(SCANNING, new Scanning(50 * SECONDS, TierEU.RECIPE_LuV))
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Adamantium, 8),
                            ItemList.BlockFlocculationCasing.get(8),
                            ItemList.Casing_Vent.get(8),
                            tectech.thing.CustomItemList.eM_energyMulti64_LuV.get(1),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Trinium, 8),
                            GTOreDictUnificator.get(OrePrefixes.rotor, Materials.Trinium, 4),
                            GTOreDictUnificator.get(OrePrefixes.rotor, Materials.NaquadahAlloy, 4),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 8),
                            ItemList.Electric_Motor_ZPM.get(4),
                            ItemList.Electric_Pump_ZPM.get(4),
                            new Object[] { OrePrefixes.circuit.get(Materials.ZPM), 4 },
                            // Still UV circuit, for some reason the alias is not working.
                            new Object[] { OrePrefixes.circuit.get(Materials.SuperconductorUHV), 2 },
                            GTOreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Naquadah, 16))
                    .fluidInputs(
                            Materials.Iridium.getMolten(16 * 144),
                            Materials.NaquadahAlloy.getMolten(16 * 144),
                            new FluidStack(solderIndalloy, 16 * 144),
                            Materials.Lubricant.getFluid(32000))
                    .itemOutputs(ItemList.Machine_Multi_PurificationUnitFlocculator.get(1)).duration(60 * SECONDS)
                    .eut(TierEU.RECIPE_ZPM).addTo(AssemblyLine);

            // pH Neutralization Purification Unit
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, Materials.Grade3PurifiedWater.getCells(1))
                    .metadata(SCANNING, new Scanning(50 * SECONDS, TierEU.RECIPE_LuV))
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.NaquadahAlloy, 8),
                            ItemList.BlockNaquadahReinforcedWaterPlantCasing.get(8),
                            ItemList.BlockExtremeCorrosionResistantCasing.get(8),
                            tectech.thing.CustomItemList.eM_energyMulti64_ZPM.get(1),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 8),
                            GTOreDictUnificator.get(OrePrefixes.rotor, Materials.NaquadahAlloy, 4),
                            HASTELLOY_C276.getRotor(4),
                            HASTELLOY_C276.getPlate(8),
                            ItemList.Electric_Motor_ZPM.get(4),
                            ItemList.Electric_Pump_ZPM.get(4),
                            new Object[] { OrePrefixes.circuit.get(Materials.ZPM), 8 },
                            // Still UV circuit, for some reason the alias is not working.
                            new Object[] { OrePrefixes.circuit.get(Materials.SuperconductorUHV), 4 },
                            GTOreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Naquadah, 32))
                    .fluidInputs(
                            Materials.NaquadahAlloy.getMolten(16 * 144),
                            HASTELLOY_C276.getFluidStack(16 * 144),
                            new FluidStack(solderIndalloy, 16 * 144),
                            Materials.Lubricant.getFluid(32000))
                    .itemOutputs(ItemList.Machine_Multi_PurificationUnitPhAdjustment.get(1)).duration(60 * SECONDS)
                    .eut(TierEU.RECIPE_ZPM).addTo(AssemblyLine);

            // Extreme Temperature Fluctuation Purification Unit
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, Materials.Grade4PurifiedWater.getCells(1))
                    .metadata(SCANNING, new Scanning(1 * MINUTES, TierEU.RECIPE_ZPM))
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Neutronium, 8),
                            ItemList.BlockPlasmaHeatingCasing.get(8),
                            ItemList.Casing_Coil_Superconductor.get(8),
                            tectech.thing.CustomItemList.eM_energyMulti64_UV.get(1),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 8),
                            GTOreDictUnificator.get(OrePrefixes.rotor, Materials.Neutronium, 4),
                            GTOreDictUnificator.get(OrePrefixes.rotor, Materials.Netherite, 4),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Netherite, 8),
                            ItemList.Electric_Motor_UV.get(4),
                            ItemList.Electric_Pump_UV.get(4),
                            new Object[] { OrePrefixes.circuit.get(Materials.ZPM), 16 },
                            // Still UV circuit, for some reason the alias is not working.
                            new Object[] { OrePrefixes.circuit.get(Materials.SuperconductorUHV), 8 },
                            GTOreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Neutronium, 32))
                    .fluidInputs(
                            Materials.Neutronium.getMolten(32 * 144),
                            Materials.Naquadria.getMolten(32 * 144),
                            new FluidStack(solderIndalloy, 32 * 144),
                            Materials.Lubricant.getFluid(64000))
                    .itemOutputs(ItemList.Machine_Multi_PurificationUnitPlasmaHeater.get(1)).duration(60 * SECONDS)
                    .eut(TierEU.RECIPE_UV).addTo(AssemblyLine);

            // High Energy Laser Purification Unit
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, Materials.Grade5PurifiedWater.getCells(1))
                    .metadata(SCANNING, new Scanning(1 * MINUTES, TierEU.RECIPE_ZPM))
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Naquadria, 8),
                            ItemList.BlockNaquadriaReinforcedWaterPlantCasing.get(8),
                            ItemList.BlockUltraVioletLaserEmitter.get(8),
                            tectech.thing.CustomItemList.eM_energyMulti64_UV.get(1),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 8),
                            GTOreDictUnificator.get(OrePrefixes.rotor, Materials.Neutronium, 4),
                            GTOreDictUnificator.get(OrePrefixes.rotor, Materials.Draconium, 4),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Draconium, 8),
                            ItemList.Electric_Motor_UV.get(4),
                            ItemList.Electric_Pump_UV.get(4),
                            // Still UV circuit, for some reason the alias is not working.
                            new Object[] { OrePrefixes.circuit.get(Materials.SuperconductorUHV), 8 },
                            new Object[] { OrePrefixes.circuit.get(Materials.UHV), 4 },
                            GTOreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Neutronium, 64))
                    .fluidInputs(
                            Materials.Neutronium.getMolten(32 * 144),
                            Materials.Naquadria.getMolten(32 * 144),
                            new FluidStack(solderIndalloy, 32 * 144),
                            Materials.Lubricant.getFluid(64000))
                    .itemOutputs(ItemList.Machine_Multi_PurificationUnitUVTreatment.get(1)).duration(60 * SECONDS)
                    .eut(TierEU.RECIPE_UV).addTo(AssemblyLine);

            // Residual Decontaminant Degasser Purification Unit
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, Materials.Grade6PurifiedWater.getCells(1))
                    .metadata(SCANNING, new Scanning(1 * MINUTES + 10 * SECONDS, TierEU.RECIPE_UHV))
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Infinity, 8),
                            ItemList.BlockPlasmaHeatingCasing.get(8),
                            tectech.thing.CustomItemList.eM_Computer_Casing.get(8),
                            tectech.thing.CustomItemList.eM_energyMulti64_UEV.get(1),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Infinity, 8),
                            GTOreDictUnificator.get(OrePrefixes.rotor, Materials.Infinity, 4),
                            GTOreDictUnificator.get(OrePrefixes.rotor, Materials.CosmicNeutronium, 4),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.CosmicNeutronium, 8),
                            ItemList.Electric_Motor_UEV.get(4),
                            ItemList.Electric_Pump_UEV.get(4),
                            new Object[] { OrePrefixes.circuit.get(Materials.UHV), 8 },
                            new Object[] { OrePrefixes.circuit.get(Materials.UEV), 4 },
                            GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Infinity, 32))
                    .fluidInputs(
                            Materials.Quantium.getMolten(64 * 144),
                            Materials.Infinity.getMolten(64 * 144),
                            new FluidStack(solderUEV, 64 * 144),
                            Materials.Lubricant.getFluid(128000))
                    .itemOutputs(ItemList.Machine_Multi_PurificationUnitDegasifier.get(1)).duration(60 * SECONDS)
                    .eut(TierEU.RECIPE_UEV).addTo(AssemblyLine);

            // Absolute Baryonic Perfection Purification Unit
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, Materials.Grade7PurifiedWater.getCells(1))
                    .metadata(SCANNING, new Scanning(1 * MINUTES + 10 * SECONDS, TierEU.RECIPE_UHV))
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Infinity, 16),
                            ItemList.BlockQuarkContainmentCasing.get(8),
                            ItemList.BlockQuarkReleaseChamber.get(8),
                            tectech.thing.CustomItemList.eM_energyMulti64_UEV.get(1),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Infinity, 16),
                            GTOreDictUnificator.get(OrePrefixes.rotor, Materials.Infinity, 8),
                            GTOreDictUnificator.get(OrePrefixes.rotor, Materials.CosmicNeutronium, 8),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.CosmicNeutronium, 16),
                            ItemList.Electric_Motor_UEV.get(8),
                            ItemList.Electric_Pump_UEV.get(8),
                            new Object[] { OrePrefixes.circuit.get(Materials.UHV), 16 },
                            new Object[] { OrePrefixes.circuit.get(Materials.UEV), 8 },
                            GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Infinity, 64))
                    .fluidInputs(
                            Materials.Longasssuperconductornameforuhvwire.getMolten(64 * 144),
                            Materials.Infinity.getMolten(64 * 144),
                            new FluidStack(solderUEV, 64 * 144),
                            Materials.Lubricant.getFluid(128000))
                    .itemOutputs(ItemList.Machine_Multi_PurificationUnitParticleExtractor.get(1)).duration(60 * SECONDS)
                    .eut(TierEU.RECIPE_UIV).addTo(AssemblyLine);

            // Quark exclusion casing
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, Particle.getBaseParticle(Particle.STRANGE))
                    .metadata(SCANNING, new Scanning(40 * SECONDS, TierEU.RECIPE_UHV))
                    .itemInputs(
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, Materials.Longasssuperconductornameforuhvwire, 32),
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Ledox, 32),
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.CallistoIce, 32),
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.EnrichedHolmium, 32),
                            GTOreDictUnificator
                                    .get(OrePrefixes.plate, Materials.Longasssuperconductornameforuhvwire, 32),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Ledox, 32),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.CallistoIce, 32),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnrichedHolmium, 32),
                            ItemList.Field_Generator_UHV.get(1),
                            new Object[] { OrePrefixes.circuit.get(Materials.UEV), 8 },
                            new Object[] { OrePrefixes.circuit.get(Materials.UIV), 4 },
                            GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Infinity, 32))
                    .fluidInputs(
                            Materials.Longasssuperconductornameforuhvwire.getMolten(64 * 144),
                            Materials.Ledox.getMolten(64 * 144),
                            Materials.CallistoIce.getMolten(64 * 144),
                            MaterialsUEVplus.ExcitedDTRC.getFluid(8000L))
                    .itemOutputs(ItemList.BlockQuarkContainmentCasing.get(8)).duration(60 * SECONDS)
                    .eut(TierEU.RECIPE_UIV).addTo(AssemblyLine);

            // Femtometer-calibrated particle beam casing
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, Particle.getBaseParticle(Particle.TOP))
                    .metadata(SCANNING, new Scanning(40 * SECONDS, TierEU.RECIPE_UHV))
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.CosmicNeutronium, 16),
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Infinity, 16),
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Tritanium, 16),
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Neutronium, 16),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.CosmicNeutronium, 16),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Infinity, 16),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Tritanium, 16),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 16),
                            ItemList.Field_Generator_UHV.get(1),
                            new Object[] { OrePrefixes.circuit.get(Materials.UEV), 4 },
                            new Object[] { OrePrefixes.circuit.get(Materials.UIV), 2 },
                            GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Infinity, 16))
                    .fluidInputs(
                            Materials.Infinity.getMolten(32 * 144),
                            Materials.Tritanium.getMolten(32 * 144),
                            new FluidStack(solderUEV, 32 * 144),
                            MaterialsUEVplus.ExcitedDTRC.getFluid(4000L))
                    .itemOutputs(ItemList.BlockQuarkReleaseChamber.get(4)).duration(60 * SECONDS).eut(TierEU.RECIPE_UIV)
                    .addTo(AssemblyLine);

            // Particle beam guidance pipe casing
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, Particle.getBaseParticle(Particle.BOTTOM))
                    .metadata(SCANNING, new Scanning(40 * SECONDS, TierEU.RECIPE_UHV))
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.CosmicNeutronium, 16),
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Naquadria, 16),
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.NaquadahAlloy, 16),
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Bedrockium, 16),
                            GTOreDictUnificator.get(OrePrefixes.foil, Materials.Infinity, 64),
                            GTOreDictUnificator.get(OrePrefixes.foil, Materials.CosmicNeutronium, 64),
                            GTOreDictUnificator
                                    .get(OrePrefixes.foil, Materials.Longasssuperconductornameforuhvwire, 64),
                            GTOreDictUnificator.get(OrePrefixes.foil, Materials.Draconium, 64),
                            ItemList.Electric_Pump_UEV.get(1),
                            new Object[] { OrePrefixes.circuit.get(Materials.UEV), 4 },
                            new Object[] { OrePrefixes.circuit.get(Materials.UIV), 2 },
                            GTOreDictUnificator.get(OrePrefixes.pipeQuadruple, Materials.Infinity, 16))
                    .fluidInputs(
                            Materials.Infinity.getMolten(32 * 144),
                            Materials.Tritanium.getMolten(32 * 144),
                            new FluidStack(solderUEV, 32 * 144),
                            MaterialsUEVplus.ExcitedDTRC.getFluid(4000L))
                    .itemOutputs(ItemList.BlockQuarkPipe.get(4)).duration(60 * SECONDS).eut(TierEU.RECIPE_UIV)
                    .addTo(AssemblyLine);
        }

        // Superconducting Solenoids
        {
            // LuV
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Superconducting_Magnet_Solenoid_IV.get(1))
                    .metadata(SCANNING, new Scanning(40 * SECONDS, TierEU.RECIPE_IV))
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorLuV, 8L),
                            GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.HSSG, 2L),
                            GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.NiobiumTitanium, 1L),
                            WerkstoffMaterialPool.MuMetal.get(OrePrefixes.stickLong, 8),
                            GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.HSSS, 2L),
                            ItemList.Reactor_Coolant_Sp_3.get(1),
                            ItemList.Reactor_Coolant_Sp_3.get(1),
                            ItemList.Electric_Pump_LuV.get(1))
                    .fluidInputs(new FluidStack(solderIndalloy, (int) (L * 4)))
                    .itemOutputs(ItemList.Superconducting_Magnet_Solenoid_LuV.get(1)).duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_LuV).addTo(AssemblyLine);

            // ZPM
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Superconducting_Magnet_Solenoid_LuV.get(1))
                    .metadata(SCANNING, new Scanning(40 * SECONDS, TierEU.RECIPE_LuV))
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorZPM, 8L),
                            GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.Naquadah, 2L),
                            GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Enderium, 1L),
                            WerkstoffMaterialPool.MuMetal.get(OrePrefixes.stickLong, 8),
                            GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.NaquadahAlloy, 2L),
                            ItemList.Reactor_Coolant_Sp_6.get(1),
                            ItemList.Reactor_Coolant_Sp_6.get(1),
                            ItemList.Electric_Pump_ZPM.get(1))
                    .fluidInputs(new FluidStack(solderIndalloy, (int) (L * 4)))
                    .itemOutputs(ItemList.Superconducting_Magnet_Solenoid_ZPM.get(1)).duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_ZPM).addTo(AssemblyLine);

            // UV
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Superconducting_Magnet_Solenoid_ZPM.get(1))
                    .metadata(SCANNING, new Scanning(40 * SECONDS, TierEU.RECIPE_ZPM))
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUV, 16L),
                            GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.ElectrumFlux, 2L),
                            GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Naquadah, 1L),
                            GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Naquadria, 8L),
                            GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Neutronium, 2L),
                            ItemList.Large_Fluid_Cell_Chrome.get(1),
                            ItemList.Electric_Pump_UV.get(1))
                    .fluidInputs(
                            new FluidStack(Materials.SuperCoolant.mFluid, 16000),
                            new FluidStack(solderIndalloy, (int) (L * 16)))
                    .itemOutputs(ItemList.Superconducting_Magnet_Solenoid_UV.get(1)).duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_UV).addTo(AssemblyLine);

            // UHV
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Superconducting_Magnet_Solenoid_UV.get(1))
                    .metadata(SCANNING, new Scanning(40 * SECONDS, TierEU.RECIPE_UV))
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUHV, 16L),
                            GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.Bedrockium, 2L),
                            GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Neutronium, 1L),
                            GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Naquadria, 8L),
                            GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.CosmicNeutronium, 2L),
                            ItemList.Large_Fluid_Cell_Iridium.get(1),
                            ItemList.Electric_Pump_UHV.get(1))
                    .fluidInputs(
                            new FluidStack(Materials.SuperCoolant.mFluid, 64000),
                            new FluidStack(solderIndalloy, (int) (L * 64)))
                    .itemOutputs(ItemList.Superconducting_Magnet_Solenoid_UHV.get(1)).duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_UHV).addTo(AssemblyLine);

            // UEV
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Superconducting_Magnet_Solenoid_UHV.get(1))
                    .metadata(SCANNING, new Scanning(40 * SECONDS, TierEU.RECIPE_UHV))
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUEV, 16L),
                            GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.Draconium, 2L),
                            GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.NetherStar, 1L),
                            GGMaterial.metastableOganesson.get(OrePrefixes.stickLong, 8),
                            GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Infinity, 2L),
                            ItemList.Large_Fluid_Cell_Iridium.get(1),
                            ItemList.Electric_Pump_UEV.get(1))
                    .fluidInputs(
                            new FluidStack(Materials.SuperCoolant.mFluid, 256000),
                            new FluidStack(solderUEV, (int) (L * 8)))
                    .itemOutputs(ItemList.Superconducting_Magnet_Solenoid_UEV.get(1)).duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_UEV).addTo(AssemblyLine);

            // UIV
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Superconducting_Magnet_Solenoid_UEV.get(1))
                    .metadata(SCANNING, new Scanning(40 * SECONDS, TierEU.RECIPE_UEV))
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUIV, 16L),
                            GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.NetherStar, 2L),
                            GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.DraconiumAwakened, 1L),
                            GGMaterial.metastableOganesson.get(OrePrefixes.stickLong, 8),
                            GTOreDictUnificator.get(OrePrefixes.plateDouble, MaterialsUEVplus.TranscendentMetal, 2L),
                            ItemList.Large_Fluid_Cell_Neutronium.get(1),
                            ItemList.Electric_Pump_UIV.get(1))
                    .fluidInputs(
                            new FluidStack(MaterialsUEVplus.TranscendentMetal.mStandardMoltenFluid, (int) (L * 32)),
                            new FluidStack(solderUEV, (int) (L * 32)))
                    .itemOutputs(ItemList.Superconducting_Magnet_Solenoid_UIV.get(1)).duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_UIV).addTo(AssemblyLine);

            // UMV
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Superconducting_Magnet_Solenoid_UIV.get(1))
                    .metadata(SCANNING, new Scanning(40 * SECONDS, TierEU.RECIPE_UIV))
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUMV, 16L),
                            GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.Quantium, 2L),
                            GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Infinity, 1L),
                            GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Infinity, 8L),
                            GTOreDictUnificator.get(OrePrefixes.plateDouble, MaterialsUEVplus.SpaceTime, 2L),
                            ItemList.Large_Fluid_Cell_Neutronium.get(1),
                            ItemList.Electric_Pump_UMV.get(1))
                    .fluidInputs(
                            new FluidStack(MaterialsUEVplus.SpaceTime.mStandardMoltenFluid, (int) (L * 16)),
                            new FluidStack(solderUEV, (int) (L * 128)))
                    .itemOutputs(ItemList.Superconducting_Magnet_Solenoid_UMV.get(1)).duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_UMV).addTo(AssemblyLine);
        }

        // Piko Circuit
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                ItemList.Circuit_OpticalMainframe.get(1L),
                384000,
                1024,
                4000000,
                64,
                new Object[] { ItemList.Circuit_Board_Optical.get(1L), CustomItemList.PicoWafer.get(4L),
                        new Object[] { OrePrefixes.circuit.get(Materials.UIV), 2L },
                        ItemList.Circuit_Parts_TransistorXSMD.get(48L), ItemList.Circuit_Parts_ResistorXSMD.get(48L),
                        ItemList.Circuit_Parts_CapacitorXSMD.get(48L), ItemList.Circuit_Parts_DiodeXSMD.get(48L),
                        ItemList.Circuit_Chip_PPIC.get(64L), GTOreDictUnificator.get("foilRadoxPoly", 16L),
                        GTOreDictUnificator.get(OrePrefixes.bolt, MaterialsUEVplus.TranscendentMetal, 32),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Neutronium, 16),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Lanthanum, 64) },
                new FluidStack[] { new FluidStack(solderUEV, 3744), Materials.UUMatter.getFluid(8000L),
                        Materials.Osmium.getMolten(1152L) },
                NHItemList.PikoCircuit.getIS(1),
                10000,
                (int) TierEU.RECIPE_UMV);

        // Quantum Circuit
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                CustomItemList.PikoCircuit.get(1L),
                720000,
                2048,
                (int) TierEU.RECIPE_UEV,
                128,
                new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Neutronium, 16),
                        CustomItemList.PikoCircuit.get(2L), ItemList.Circuit_Parts_CapacitorXSMD.get(64L),
                        ItemList.Circuit_Parts_DiodeXSMD.get(64L), ItemList.Circuit_Parts_TransistorXSMD.get(64L),
                        ItemList.Circuit_Parts_ResistorXSMD.get(64L), ItemList.Circuit_Chip_QPIC.get(64L),
                        GTOreDictUnificator.get("foilShirabon", 64),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Indium, 64),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, MaterialsUEVplus.SpaceTime, 8),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Lanthanum, 16) },
                new FluidStack[] { new FluidStack(solderUEV, 3744), Materials.UUMatter.getFluid(24000L),
                        Materials.Osmium.getMolten(2304L) },
                NHItemList.QuantumCircuit.getIS(1),
                20000,
                (int) TierEU.RECIPE_UMV);

        // Miniature Wormhole Generator
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                AEApi.instance().definitions().materials().singularity().maybeStack(1).get(),
                64000,
                64,
                200000,
                4,
                new Object[] { tectech.thing.CustomItemList.Machine_Multi_Transformer.get(1),
                        AEApi.instance().definitions().materials().singularity().maybeStack(4).get(),
                        ItemList.Field_Generator_UHV.get(4), ItemList.Emitter_UHV.get(4),
                        ItemList.Casing_Fusion_Coil.get(4), new Object[] { OrePrefixes.circuit.get(Materials.UHV), 2L },
                        tectech.thing.CustomItemList.LASERpipe.get(64), },
                new FluidStack[] { new FluidStack(Materials.Neutronium.mStandardMoltenFluid, 144 * 12),
                        new FluidStack(Materials.Tritanium.mStandardMoltenFluid, 144 * 12),
                        new FluidStack(solderIndalloy, 144 * 24),
                        new FluidStack(Materials.SuperCoolant.mFluid, 144 * 48), },
                ItemList.WormholeGenerator.get(1L),
                60 * SECONDS,
                (int) TierEU.RECIPE_UEV);

        // Antimatter Forge - Antimatter Sequencer - SSASS
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                ItemRefer.Naquadah_Fuel_Refinery.get(1),
                512000,
                2048,
                8000000,
                64,
                new Object[] { ItemRefer.Compact_Fusion_MK5.get(1),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, MaterialsUEVplus.ProtoHalkonite, 16),
                        GregtechItemList.CosmicFabricManipulator.get(16), ItemRefer.Field_Restriction_Coil_T3.get(16),
                        MaterialsElements.STANDALONE.HYPOGEN.getFineWire(64),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, MaterialsUEVplus.ProtoHalkonite, 64),
                        new Object[] { OrePrefixes.circuit.get(Materials.UIV), 16L },
                        ItemList.Electric_Pump_UIV.get(16),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, MaterialsUEVplus.ProtoHalkonite, 4),
                        GTOreDictUnificator.get(OrePrefixes.plateDense, MaterialsUEVplus.TranscendentMetal, 64) },
                new FluidStack[] { MaterialsUEVplus.Protomatter.getFluid(10000),
                        MaterialsUEVplus.SixPhasedCopper.getMolten(9216),
                        MaterialsUEVplus.TranscendentMetal.getMolten(9216),
                        MaterialsUEVplus.DimensionallyShiftedSuperfluid.getFluid(10000) },
                ItemRefer.AntimatterForge.get(1),
                6 * MINUTES,
                (int) TierEU.RECIPE_UMV);

        // Antimatter Generator - SLAM
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                ItemRefer.Large_Naquadah_Reactor.get(1),
                512000,
                2048,
                8000000,
                64,
                new Object[] { ItemList.WormholeGenerator.get(1),
                        tectech.thing.CustomItemList.eM_dynamoTunnel7_UIV.get(4),
                        ItemRefer.ProtomatterActivationCoil.get(16),
                        new Object[] { OrePrefixes.circuit.get(Materials.UIV), 16L }, ItemList.Emitter_UIV.get(32),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, MaterialsUEVplus.ProtoHalkonite, 4),
                        GTOreDictUnificator.get(OrePrefixes.rotor, MaterialsUEVplus.ProtoHalkonite, 16),
                        GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUIV, 64),
                        MaterialsElements.STANDALONE.HYPOGEN.getFineWire(64),
                        MaterialsElements.STANDALONE.HYPOGEN.getFineWire(64),
                        MaterialsElements.STANDALONE.HYPOGEN.getFineWire(64) },
                new FluidStack[] { MaterialsUEVplus.Antimatter.getFluid(1000),
                        MaterialsUEVplus.SixPhasedCopper.getMolten(9216),
                        MaterialsUEVplus.TranscendentMetal.getMolten(9216),
                        Materials.SuperconductorUMVBase.getMolten(9216) },
                ItemRefer.AntimatterGenerator.get(1),
                6 * MINUTES,
                (int) TierEU.RECIPE_UMV);

        // Antimatter Hatch
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                ItemList.Hatch_Output_UIV.get(1),
                256000,
                1024,
                4000000,
                64,
                new Object[] { ItemList.Hatch_Output_UIV.get(1), ItemList.Field_Generator_UEV.get(4),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, MaterialsUEVplus.ProtoHalkonite, 1),
                        ItemList.Electric_Pump_UIV.get(4), ItemList.Electromagnet_Tengam.get(1),
                        GTOreDictUnificator.get(OrePrefixes.foil, MaterialsUEVplus.ProtoHalkonite, 32) },
                new FluidStack[] { Materials.RadoxPolymer.getMolten(1296), MaterialsUEVplus.Protomatter.getFluid(250),
                        MaterialsUEVplus.DimensionallyShiftedSuperfluid.getFluid(1000) },
                goodgenerator.loader.Loaders.AMHatch,
                300 * SECONDS,
                (int) TierEU.RECIPE_UIV);

        // Antimatter Containment Casing
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                new ItemStack(GregTechAPI.sBlockGlass1, 1, 3),
                128000,
                1024,
                2000000,
                32,
                new Object[] { new ItemStack(GregTechAPI.sBlockGlass1, 4, 3),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, MaterialsUEVplus.ProtoHalkonite, 4),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, MaterialsUEVplus.TranscendentMetal, 12),
                        ItemList.Emitter_UIV.get(4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorUIV, 16), },
                new FluidStack[] { Materials.RadoxPolymer.getMolten(16),
                        MaterialsUEVplus.TranscendentMetal.getMolten(2304) },
                ItemRefer.AntimatterContainmentCasing.get(4),
                60 * SECONDS,
                (int) TierEU.RECIPE_UIV);

        // Gravity Stabilization Casing
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                new ItemStack(GregTechAPI.sBlockCasings10, 1, 8),
                128000,
                1024,
                2000000,
                32,
                new Object[] { new ItemStack(GregTechAPI.sBlockCasings10, 4, 8), ItemList.Emitter_UIV.get(2),
                        GregtechItemList.Battery_Gem_4.get(1), // Graviton Anomaly
                        GTOreDictUnificator.get(OrePrefixes.plate, MaterialsUEVplus.ProtoHalkonite, 4),
                        GTOreDictUnificator.get(OrePrefixes.gearGt, MaterialsUEVplus.ProtoHalkonite, 1),
                        ItemList.Gravistar.get(4), new Object[] { OrePrefixes.circuit.get(Materials.UIV), 1L },
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorUIV, 16), },
                new FluidStack[] { new FluidStack(FluidRegistry.getFluid("molten.chromaticglass"), 9216),
                        MaterialsUEVplus.DimensionallyShiftedSuperfluid.getFluid(2304) },
                ItemRefer.GravityStabilizationCasing.get(4),
                60 * SECONDS,
                (int) TierEU.RECIPE_UIV);

        // Magnetic Flux Casing
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                GTOreDictUnificator.get(OrePrefixes.frameGt, MaterialsUEVplus.ProtoHalkonite, 1),
                128000,
                1024,
                2000000,
                32,
                new Object[] { GTOreDictUnificator.get(OrePrefixes.frameGt, MaterialsUEVplus.ProtoHalkonite, 4),
                        ItemList.Sensor_UIV.get(2), ItemList.Electromagnet_Tengam.get(1),
                        GTOreDictUnificator.get(OrePrefixes.plateDense, MaterialsUEVplus.ProtoHalkonite, 1),
                        new Object[] { OrePrefixes.circuit.get(Materials.UIV), 1L },
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, MaterialsUEVplus.TranscendentMetal, 16),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorUIV, 16), },
                new FluidStack[] { Materials.TengamPurified.getMolten(9216),
                        MaterialsUEVplus.TranscendentMetal.getMolten(2304), Materials.SuperCoolant.getFluid(10000) },
                ItemRefer.MagneticFluxCasing.get(4),
                60 * SECONDS,
                (int) TierEU.RECIPE_UIV);

        // Protomatter Activation Coil
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                new ItemStack(ModBlocks.blockCasingsMisc, 1, 8),
                128000,
                1024,
                2000000,
                32,
                new Object[] { ItemRefer.Field_Restriction_Coil_T3.get(1), ItemList.Electric_Pump_UIV.get(2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUIV, 8),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Infinity, 1),
                        GTOreDictUnificator.get(OrePrefixes.rotor, MaterialsUEVplus.ProtoHalkonite, 4),
                        new Object[] { OrePrefixes.circuit.get(Materials.UIV), 1L },
                        ItemList.Field_Generator_UEV.get(4) },
                new FluidStack[] { MaterialsUEVplus.Protomatter.getFluid(100),
                        MaterialsUEVplus.TranscendentMetal.getMolten(2304),
                        MaterialsUEVplus.DimensionallyShiftedSuperfluid.getFluid(1000) },
                ItemRefer.ProtomatterActivationCoil.get(4),
                60 * SECONDS,
                (int) TierEU.RECIPE_UIV);

        // Antimatter Annihilation Matrix
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                MaterialsUEVplus.Antimatter.getCells(1),
                256000,
                2048,
                8000000,
                32,
                new Object[] { ItemRefer.ProtomatterActivationCoil.get(1),
                        MaterialsElements.STANDALONE.HYPOGEN.getFoil(64), ItemList.Emitter_UIV.get(2),
                        new Object[] { OrePrefixes.circuit.get(Materials.UIV), 1L },
                        GTOreDictUnificator.get(OrePrefixes.frameGt, MaterialsUEVplus.ProtoHalkonite, 4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUIV, 8),
                        ItemList.Sensor_UIV.get(2),
                        GTOreDictUnificator.get(OrePrefixes.rotor, MaterialsUEVplus.ProtoHalkonite, 4), },
                new FluidStack[] { MaterialsUEVplus.Antimatter.getFluid(4),
                        MaterialsElements.STANDALONE.HYPOGEN.getFluidStack(1440),
                        MaterialsUEVplus.DimensionallyShiftedSuperfluid.getFluid(1000) },
                ItemRefer.AntimatterAnnihilationMatrix.get(4),
                60 * SECONDS,
                (int) TierEU.RECIPE_UIV);

        if (AE2FluidCraft.isModLoaded()) {
            // Super Stock Replenisher
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Hatch_Input_ME.get(1))
                    .metadata(SCANNING, new Scanning(2 * MINUTES, TierEU.RECIPE_UV))
                    .itemInputs(
                            ItemList.Hatch_Input_Bus_ME.get(1L),
                            ItemList.Hatch_Input_ME.get(1),
                            getModItem(AppliedEnergistics2.ID, "tile.BlockController", 1, 0),
                            getModItem(AppliedEnergistics2.ID, "tile.BlockChest", 1, 0),
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4, 27),
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4, 56))
                    .fluidInputs(
                            Materials.Naquadria.getMolten(1_152L),
                            MaterialsAlloy.INDALLOY_140.getFluidStack(1152),
                            FluidRegistry.getFluidStack("lubricant", 2000))
                    .itemOutputs(getModItem(AE2FluidCraft.ID, "super_stock_replenisher", 1, 0)).duration(30 * SECONDS)
                    .eut((int) TierEU.RECIPE_UV).addTo(AssemblyLine);
        }

    }
}
