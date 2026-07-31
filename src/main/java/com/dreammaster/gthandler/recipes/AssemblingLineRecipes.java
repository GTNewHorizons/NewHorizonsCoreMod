package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.AE2FluidCraft;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Computronics;
import static gregtech.api.enums.Mods.EtFuturumRequiem;
import static gregtech.api.enums.Mods.EternalSingularity;
import static gregtech.api.enums.Mods.GalacticraftAmunRa;
import static gregtech.api.enums.Mods.GraviSuite;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.SGCraft;
import static gregtech.api.enums.Mods.StevesAddons;
import static gregtech.api.enums.Mods.UniversalSingularities;
import static gregtech.api.util.GTRecipeBuilder.HOURS;
import static gregtech.api.util.GTRecipeBuilder.INGOTS;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.STACKS;
import static gregtech.api.util.GTRecipeBuilder.WILDCARD;
import static gregtech.api.util.GTRecipeConstants.AssemblyLine;
import static gregtech.api.util.GTRecipeConstants.RESEARCH_ITEM;
import static gregtech.api.util.GTRecipeConstants.SCANNING;
import static gtPlusPlus.core.material.MaterialsAlloy.HASTELLOY_C276;
import static gtPlusPlus.core.material.MaterialsAlloy.HASTELLOY_X;
import static gtPlusPlus.core.material.MaterialsElements.STANDALONE.CHRONOMATIC_GLASS;
import static gtPlusPlus.core.material.MaterialsElements.STANDALONE.HYPOGEN;
import static kubatech.api.enums.ItemList.ElectrodeDetectorHatch;
import static tectech.loader.recipe.BaseRecipeLoader.getNHCoreModItem;
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

import com.dreammaster.item.NHItemList;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import appeng.api.AEApi;
import bartworks.common.loaders.ItemRegistry;
import ggfab.GGItemList;
import goodgenerator.items.GGMaterial;
import goodgenerator.util.ItemRefer;
import gregtech.api.GregTechAPI;
import gregtech.api.enums.Circuits;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.Superconductors;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2CellShapes;
import gregtech.api.enums.materials2.Materials2FluidShapes;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;
import gregtech.api.material.MU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gregtech.api.util.recipe.Scanning;
import gtPlusPlus.core.block.ModBlocks;
import gtPlusPlus.core.material.MaterialMisc;
import gtPlusPlus.core.material.MaterialsAlloy;
import gtPlusPlus.core.material.MaterialsElements;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;
import gtnhlanth.common.register.LanthItemList;
import tectech.recipe.TTRecipeAdder;
import tectech.thing.CustomItemList;
import tectech.thing.block.BlockGodforgeGlass;

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
        GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, NHItemList.HeavyDutyPlateTier4.get())
                .metadata(SCANNING, new Scanning(1 * MINUTES + 40 * SECONDS, TierEU.RECIPE_IV))
                .itemInputs(
                        NHItemList.HeavyDutyPlateTier4.get(),
                        NHItemList.QuantinumCompressedPlate.get(4),
                        NHItemList.QuantinumCompressedPlate.get(4),
                        MaterialLibAPI.getStack(Materials2Materials.Europium, Materials2Shapes.bolt, (int) (8)))
                .fluidInputs(new FluidStack(solderIndalloy, 72)).itemOutputs(NHItemList.HeavyDutyAlloyIngotT5.get())
                .eut(TierEU.RECIPE_ZPM).duration(15 * SECONDS).addTo(AssemblyLine);

        // Heavy duty alloy ingot T6
        GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, NHItemList.HeavyDutyPlateTier5.get())
                .metadata(SCANNING, new Scanning(1 * MINUTES + 50 * SECONDS, TierEU.RECIPE_LuV))
                .itemInputs(
                        NHItemList.HeavyDutyPlateTier5.get(),
                        NHItemList.LeadOriharukonPlate.get(5),
                        NHItemList.LeadOriharukonPlate.get(5),
                        MaterialLibAPI.getStack(Materials2Materials.Tritanium, Materials2Shapes.bolt, (int) (8)))
                .fluidInputs(new FluidStack(solderIndalloy, 144)).itemOutputs(NHItemList.HeavyDutyAlloyIngotT6.get())
                .eut(TierEU.RECIPE_UV).duration(15 * SECONDS).addTo(AssemblyLine);

        // Heavy duty alloy ingot T7
        GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, NHItemList.HeavyDutyPlateTier6.get())
                .metadata(SCANNING, new Scanning(2 * MINUTES, TierEU.RECIPE_ZPM))
                .itemInputs(
                        NHItemList.HeavyDutyPlateTier6.get(),
                        NHItemList.MysteriousCrystalCompressedPlate.get(6),
                        NHItemList.MysteriousCrystalCompressedPlate.get(6),
                        MaterialLibAPI.getStack(Materials2Materials.Neutronium, Materials2Shapes.bolt, (int) (10)))
                .fluidInputs(new FluidStack(solderIndalloy, 288)).itemOutputs(NHItemList.HeavyDutyAlloyIngotT7.get())
                .eut(TierEU.RECIPE_UHV).duration(15 * SECONDS).addTo(AssemblyLine);

        // Heavy duty alloy ingot T8
        GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, NHItemList.HeavyDutyPlateTier7.get())
                .metadata(SCANNING, new Scanning(2 * MINUTES + 10 * SECONDS, TierEU.RECIPE_UV))
                .itemInputs(
                        NHItemList.HeavyDutyPlateTier7.get(),
                        NHItemList.BlackPlutoniumCompressedPlate.get(7),
                        NHItemList.BlackPlutoniumCompressedPlate.get(7),
                        MaterialLibAPI.getStack(Materials2Materials.BlackPlutonium, Materials2Shapes.bolt, (int) (12)))
                .fluidInputs(new FluidStack(solderIndalloy, 576)).itemOutputs(NHItemList.HeavyDutyAlloyIngotT8.get())
                .eut(TierEU.RECIPE_UEV).duration(15 * SECONDS).addTo(AssemblyLine);

        // Neuro CPU
        GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Circuit_Chip_Stemcell.get(1L))
                .metadata(SCANNING, new Scanning(1 * MINUTES, TierEU.RECIPE_LuV))
                .itemInputs(
                        ItemList.Circuit_Board_Wetware_Extreme.get(1L),
                        ItemList.Circuit_Chip_Stemcell.get(16L),
                        ItemList.Circuit_Parts_Reinforced_Glass_Tube.get(16L),
                        GTOreDictUnificator
                                .get(OrePrefixes.pipeTiny, MU.materialOf(Materials2Materials.Polybenzimidazole), 8L),
                        MaterialLibAPI.getStack(
                                Materials2Materials.NaquadahEnriched,
                                Materials2Shapes.itemCasing,
                                (int) (4L)),
                        new Object[] { OrePrefixes.foil.get(Materials.AnySyntheticRubber), 64L },
                        MaterialLibAPI.getStack(Materials2Materials.TungstenSteel, Materials2Shapes.bolt, (int) (32L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.GrowthMediumSterilized,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (250L)),
                        MU.materialOf(Materials2Materials.UUMatter).getFluid(250L),
                        FluidRegistry.getFluidStack("ic2coolant", 1000))
                .itemOutputs(ItemList.Circuit_Chip_NeuroCPU.get(1L)).eut(TierEU.RECIPE_ZPM).duration(30 * SECONDS)
                .addTo(AssemblyLine);

        // Bio CPU
        GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Circuit_Chip_NeuroCPU.get(1L))
                .metadata(SCANNING, new Scanning(1 * MINUTES + 30 * SECONDS, TierEU.RECIPE_ZPM))
                .itemInputs(
                        ItemList.Circuit_Board_Bio_Ultra.get(1L),
                        ItemList.Circuit_Chip_Biocell.get(16L),
                        ItemList.Circuit_Parts_Reinforced_Glass_Tube.get(16L),
                        GTOreDictUnificator
                                .get(OrePrefixes.pipeTiny, MU.materialOf(Materials2Materials.Polybenzimidazole), 16),
                        MaterialLibAPI
                                .getStack(Materials2Materials.ElectrumFlux, Materials2Shapes.itemCasing, (int) (16L)),
                        new Object[] { OrePrefixes.foil.get(Materials.AnySyntheticRubber), 64L },
                        MaterialLibAPI.getStack(Materials2Materials.HSSS, Materials2Shapes.bolt, (int) (32L)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.BiohMediumSterilized,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (500L)),
                        MU.materialOf(Materials2Materials.UUMatter).getFluid(500L),
                        FluidRegistry.getFluidStack("ic2coolant", 2000))
                .itemOutputs(ItemList.Circuit_Chip_BioCPU.get(1L)).eut(TierEU.RECIPE_UHV / 2).duration(30 * SECONDS)
                .addTo(AssemblyLine);

        // Lapotronic Energy Orb Cluster
        GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Energy_LapotronicOrb.get(1L))
                .metadata(SCANNING, new Scanning(40 * SECONDS, TierEU.RECIPE_IV))
                .itemInputs(
                        ItemList.Circuit_Board_Multifiberglass.get(1L),
                        MaterialLibAPI.getStack(Materials2Materials.NaquadahAlloy, Materials2Shapes.foil, (int) (64L)),
                        new Object[] { Circuits.LuV.getIngredient(), 4L },
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(36L),
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(36L),
                        ItemList.Circuit_Chip_HPIC.get(64L),
                        ItemList.Circuit_Parts_DiodeASMD.get(8L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(8L),
                        ItemList.Circuit_Parts_ResistorASMD.get(8L),
                        ItemList.Circuit_Parts_TransistorASMD.get(8L),
                        MaterialLibAPI.getStack(Materials2Materials.Platinum, Materials2Shapes.wireFine, (int) (64)))
                .fluidInputs(new FluidStack(solderIndalloy, 720)).itemOutputs(ItemList.Energy_LapotronicOrb2.get(1L))
                .eut(TierEU.RECIPE_ZPM).duration(50 * SECONDS).addTo(AssemblyLine);

        // Advanced Stocking Input Bus (ME)
        GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Hatch_Input_Bus_ME.get(1L))
                .metadata(SCANNING, new Scanning(50 * SECONDS, TierEU.RECIPE_EV))
                .itemInputs(
                        ItemList.Hatch_Input_Bus_LuV.get(1L),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1),
                        ItemList.Conveyor_Module_IV.get(1L),
                        // Acceleration Card
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4, 30))
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
                        getModItem(OpenComputers.ID, "item", 1, 44),
                        // Dense infinity plate
                        MaterialLibAPI.getStack(Materials2Materials.Infinity, Materials2Shapes.plateDense, (int) (64)),
                        // Shirabon foil
                        GTOreDictUnificator.get("foilShirabon", 64),
                        // Quantum circuit
                        new Object[] { Circuits.UXV.getIngredient(), 1L },
                        // Energized tesseract
                        ItemList.EnergisedTesseract.get(1) },
                new FluidStack[] { new FluidStack(solderUEV, 1296),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.ExcitedDTEC,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (500L)) },
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
                        getModItem(OpenComputers.ID, "item", 1, 44),
                        // Dense infinity plate
                        MaterialLibAPI.getStack(Materials2Materials.Infinity, Materials2Shapes.plateDense, (int) (64)),
                        // Shirabon foil
                        GTOreDictUnificator.get("foilShirabon", 64),
                        // Quantum circuit
                        new Object[] { Circuits.UXV.getIngredient(), 1L },
                        // Energized tesseract
                        ItemList.EnergisedTesseract.get(1) },
                new FluidStack[] { new FluidStack(solderUEV, 1296),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.ExcitedDTEC,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (500L)) },
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
                        getModItem(OpenComputers.ID, "item", 1, 44),
                        // Superdense neutronium plate
                        MaterialLibAPI
                                .getStack(Materials2Materials.Neutronium, Materials2Shapes.plateSuperdense, (int) (4)),
                        // infinity foil
                        MaterialLibAPI.getStack(Materials2Materials.Infinity, Materials2Shapes.foil, (int) (64)),
                        // UIV circuit
                        new Object[] { Circuits.UIV.getIngredient(), 2L },
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
                        getModItem(OpenComputers.ID, "item", 1, 44),
                        // Superdense neutronium plate
                        MaterialLibAPI
                                .getStack(Materials2Materials.Neutronium, Materials2Shapes.plateSuperdense, (int) (4)),
                        // infinity foil
                        MaterialLibAPI.getStack(Materials2Materials.Infinity, Materials2Shapes.foil, (int) (64)),
                        // UIV circuit
                        new Object[] { Circuits.UIV.getIngredient(), 2L },
                        // UEV emitter
                        ItemList.Emitter_UEV.get(1) },
                new FluidStack[] { new FluidStack(solderUEV, 1296) },
                // Wireless data bank master connector
                dataOutAss_Wireless_Hatch.get(1),
                30 * SECONDS,
                (int) TierEU.RECIPE_UEV);

        // Dyson Swarm Module
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                ItemList.DroneCase.get(1),
                192_000,
                512,
                (int) TierEU.RECIPE_UEV,
                16,
                new Object[] { ItemList.DroneCase.get(1), ItemList.FuelPellet.get(1), GregtechItemList.RTG.get(1),
                        ItemList.Femtocontroller.get(1), ItemList.Circuit_Chip_FPIC.get(8),
                        ItemList.Cover_SolarPanel_LuV.get(4), ItemList.UHTResistantMesh.get(64) },
                new FluidStack[] { new FluidStack(solderUEV, 18_432),
                        new FluidStack(FluidRegistry.getFluid("silane-nitrogen plasma mixture"), 16000) },
                ItemList.DysonSwarmModule.get(64),
                5 * SECONDS,
                (int) TierEU.RECIPE_UHV);

        // Dyson Swarm Energy Receiver Base Casing
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                ItemList.Circuit_Chip_FPIC.get(1),
                192_000,
                512,
                (int) TierEU.RECIPE_UHV,
                32,
                new ItemStack[] { GTUtility.copyAmount(4, ItemRegistry.energyDistributor[9]),
                        ItemList.Circuit_Chip_FPIC.get(32), Superconductors.UEV.getWireGt16(4),
                        ItemList.UEV_Coil.get(64), },
                new FluidStack[] { new FluidStack(FluidRegistry.getFluid("liquid helium"), 50_000),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SuperCoolant,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (16_000)),
                        new FluidStack(solderUEV, 11_520),
                        MU.materialOf(Materials2Materials.UUMatter).getFluid(8_000) },
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
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, MU.materialOf(Materials2Materials.Infinity), 8),
                        ItemRefer.Field_Restriction_Coil_T2.get(2) },
                new FluidStack[] { MaterialsElements.STANDALONE.RHUGNOR.getFluidStack(40),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SuperCoolant,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (16_000)),
                        new FluidStack(solderUEV, 11_520),
                        MU.materialOf(Materials2Materials.UUMatter).getFluid(8_000) },
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
                new Object[] { ItemList.Hull_UIV.get(4), new Object[] { Circuits.UMV.getIngredient(), 4L },
                        ItemList.Electric_Pump_UIV.get(32), ItemList.Quantum_Tank_IV.get(2),
                        ItemList.Conveyor_Module_UIV.get(32), ItemList.Quantum_Chest_IV.get(2) },
                new FluidStack[] {
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.dimensionallyshiftedsuperfluid,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (50000)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SuperCoolant,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (16_000)),
                        new FluidStack(solderUEV, 11_520),
                        MU.materialOf(Materials2Materials.UUMatter).getFluid(8_000) },
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
                new FluidStack[] {
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.dimensionallyshiftedsuperfluid,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (50_000)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SuperCoolant,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (16_000)),
                        new FluidStack(solderUEV, 11520), MU.materialOf(Materials2Materials.UUMatter).getFluid(8_000) },
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
                new Object[] { ItemList.Hull_UIV.get(4), Superconductors.UEV.getWireGt16(16),
                        ItemList.Circuit_Chip_FPIC.get(32), new Object[] { Circuits.UMV.getIngredient(), 8L } },
                new FluidStack[] { MaterialsElements.STANDALONE.RHUGNOR.getFluidStack(40),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SuperCoolant,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (16_000)),
                        new FluidStack(solderUEV, 11_520),
                        MU.materialOf(Materials2Materials.UUMatter).getFluid(8_000) },
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
                new Object[] { ItemList.Hull_UIV.get(4), getModItem(OpenComputers.ID, "item", 4, 103),
                        new Object[] { Circuits.UMV.getIngredient(), 4L },
                        tectech.thing.CustomItemList.Machine_Multi_Computer.get(4), },
                new FluidStack[] {
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SuperCoolant,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (32_000)),
                        new FluidStack(solderUEV, 11_520),
                        MU.materialOf(Materials2Materials.UUMatter).getFluid(8_000) },
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
                new ItemStack[] { ItemList.Circuit_Chip_FPIC.get(2),
                        ItemList.Naquarite_Universal_Insulator_Foil.get(24),
                        tectech.thing.CustomItemList.eM_Coil.get(4) },
                new FluidStack[] { MaterialLibAPI
                        .getFluidStack(Materials2Materials.RadoxPoly, Materials2FluidShapes.fluidMolten, (int) (3_456)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SuperCoolant,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (16_000)),
                        new FluidStack(solderUEV, 11_520),
                        MU.materialOf(Materials2Materials.UUMatter).getFluid(8_000) },
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
                new ItemStack[] { ItemList.Circuit_Chip_FPIC.get(2),
                        ItemList.Naquarite_Universal_Insulator_Foil.get(24),
                        ItemList.Casing_Coil_AwakenedDraconium.get(4) },
                new FluidStack[] { MaterialLibAPI
                        .getFluidStack(Materials2Materials.RadoxPoly, Materials2FluidShapes.fluidMolten, (int) (3_240)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SuperCoolant,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (16_000)),
                        new FluidStack(solderUEV, 11_520),
                        MU.materialOf(Materials2Materials.UUMatter).getFluid(8_000) },
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
                new ItemStack[] {
                        MaterialLibAPI
                                .getStack(Materials2Materials.CosmicNeutronium, Materials2Shapes.screw, (int) (4)),
                        MaterialLibAPI.getStack(Materials2Materials.Neutronium, Materials2Shapes.foil, (int) (8)),
                        GTOreDictUnificator.get(
                                OrePrefixes.frameGt,
                                MU.materialOf(Materials2Materials.SuperconductorUEVBase),
                                4), },
                new FluidStack[] { MaterialLibAPI
                        .getFluidStack(Materials2Materials.RadoxPoly, Materials2FluidShapes.fluidMolten, (int) (144)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SuperCoolant,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (16_000)),
                        new FluidStack(solderUEV, 11_520),
                        MU.materialOf(Materials2Materials.UUMatter).getFluid(8_000) },
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
                new Object[] { ItemList.Hull_UIV.get(4), NHItemList.IrradiantReinforcedBedrockiumPlate.get(4),
                        new Object[] { Circuits.UMV.getIngredient(), 8L },
                        getModItem(Computronics.ID, "computronics.ocSpecialParts", 4),
                        getModItem(OpenComputers.ID, "item", 8, 103) },
                new FluidStack[] { MaterialsElements.STANDALONE.RHUGNOR.getFluidStack(100),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SuperCoolant,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (16_000)),
                        new FluidStack(solderUEV, 11_520),
                        MU.materialOf(Materials2Materials.UUMatter).getFluid(8_000) },
                ItemList.DysonSwarmController.get(1),
                2 * MINUTES,
                (int) TierEU.RECIPE_UIV);

        if (GalacticraftAmunRa.isModLoaded()) {
            // Nanite Containment Bus
            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    getModItem(GalacticraftAmunRa.ID, "item.baseItem", 1, 28),
                    32_000,
                    64,
                    (int) TierEU.RECIPE_UV,
                    16,
                    new Object[] { ItemList.Hatch_Input_Bus_MAX.get(1), ItemList.Quantum_Chest_EV.get(1),
                            ItemList.Field_Generator_UHV.get(1),
                            getModItem(GalacticraftAmunRa.ID, "item.baseItem", 4, 28),
                            GGMaterial.enrichedNaquadahAlloy.get(OrePrefixes.plateDense, 4),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.CosmicNeutronium,
                                    Materials2Shapes.plateSuperdense,
                                    (int) (4)) },
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
                        MaterialLibAPI.getStack(
                                Materials2Materials.CosmicNeutronium,
                                Materials2Shapes.plateSuperdense,
                                (int) (64)),
                        MaterialLibAPI.getStack(
                                Materials2Materials.InfinityCatalyst,
                                Materials2Shapes.plateSuperdense,
                                (int) (32)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.Infinity, Materials2Shapes.plateSuperdense, (int) (16)) },
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
                    new Object[] {
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Tritanium), 8),
                            ItemList.Circuit_Biomainframe.get(2L), ItemList.Circuit_Parts_CapacitorASMD.get(32L),
                            ItemList.Circuit_Parts_ResistorASMD.get(32L),
                            ItemList.Circuit_Parts_TransistorASMD.get(32L), ItemList.Circuit_Parts_DiodeASMD.get(32L),
                            ItemList.Circuit_Chip_Ram.get(64L), ItemList.Circuit_Chip_NPIC.get(64L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.wireGt01, MU.materialOf(Materials2Materials.Draconium), 64),
                            Superconductors.UHV.getWireGt02(64),
                            new Object[] { OrePrefixes.foil.get(Materials.AnySyntheticRubber), 64L },
                            MaterialLibAPI.getStack(
                                    Materials2Materials.Polybenzimidazole,
                                    Materials2Shapes.foil,
                                    (int) (64)) },
                    new FluidStack[] {
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.SolderingAlloy,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (3_744L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Naquadria,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (4_032L)),
                            new FluidStack(FluidRegistry.getFluid("ic2coolant"), 20_000) },
                    NHItemList.NanoCircuitOrigin.get(1),
                    400 * SECONDS,
                    (int) TierEU.RECIPE_UEV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    MaterialLibAPI.getStack(Materials2Materials.Infinity, Materials2Shapes.foil, (int) (1L)),
                    192_000,
                    512,
                    (int) TierEU.RECIPE_UHV,
                    32,
                    new ItemStack[] { getModItem(EternalSingularity.ID, "eternal_singularity", 1),
                            ItemList.Sensor_UV.get(16L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.Infinity), 16L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.CosmicNeutronium), 16L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.NaquadahAlloy), 64L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.NaquadahAlloy), 64L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.NaquadahAlloy), 64L),
                            NHItemList.NanoCircuitOrigin.get(16) },
                    new FluidStack[] {
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Neutronium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (36_864L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Tritanium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (36_864L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Tetranaquadahdiindiumhexaplatiumosminid,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (36_864L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Silver,
                                    Materials2FluidShapes.fluidPlasma,
                                    (int) (36_864L)) },
                    NHItemList.GatePlateOrigin.get(1),
                    1 * HOURS,
                    (int) TierEU.RECIPE_UHV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Infinity), 1L),
                    192_000,
                    512,
                    (int) TierEU.RECIPE_UHV,
                    32,
                    new ItemStack[] { ItemList.Electric_Piston_UV.get(16L), ItemList.Electric_Motor_UV.get(64L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.Infinity), 16L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.NaquadahAlloy), 64L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.NetherStar), 16L),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Ardite, Materials2Shapes.plateDense, (int) (8L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Ardite, Materials2Shapes.plateDense, (int) (8L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Ardite, Materials2Shapes.plateDense, (int) (8L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Ruby, Materials2Shapes.gemExquisite, (int) (64L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Jasper, Materials2Shapes.gemExquisite, (int) (64L)),
                            NHItemList.NanoCircuitOrigin.get(32) },
                    new FluidStack[] {
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Neutronium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (9_216L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Tritanium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (9_216L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Tetranaquadahdiindiumhexaplatiumosminid,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (9_216L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Silver,
                                    Materials2FluidShapes.fluidPlasma,
                                    (int) (9_216L)) },
                    NHItemList.ChevronOrigin.get(1),
                    1 * HOURS,
                    (int) TierEU.RECIPE_UHV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    MaterialLibAPI.getStack(Materials2Materials.Neutronium, Materials2Shapes.stickLong, (int) (1L)),
                    192_000,
                    512,
                    (int) TierEU.RECIPE_UHV,
                    32,
                    new ItemStack[] {
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Infinity, Materials2Shapes.stickLong, (int) (64L)),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.NaquadahAlloy,
                                    Materials2Shapes.stickLong,
                                    (int) (64L)),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.CosmicNeutronium,
                                    Materials2Shapes.stickLong,
                                    (int) (64L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Neutronium, Materials2Shapes.stickLong, (int) (64L)),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.Osmiridium,
                                    Materials2Shapes.stickLong,
                                    (int) (64L)) },
                    new FluidStack[] {
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Neutronium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (73728L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Tritanium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (73_728L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Concrete,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (73_728L)) },
                    NHItemList.FramePartOrigin.get(1),
                    1 * HOURS,
                    (int) TierEU.RECIPE_UHV);

            // UEV Gate
            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.NanoCircuitOrigin.get(1),
                    192000 * 2,
                    512 * 2,
                    4_000_000,
                    32 * 2,
                    new Object[] { ItemList.Circuit_Board_Bio_Ultra.get(1L), NHItemList.PicoWafer.get(4),
                            NHItemList.NanoCircuitOrigin.get(2), ItemList.Circuit_Parts_TransistorXSMD.get(48L),
                            ItemList.Circuit_Parts_ResistorXSMD.get(48L), ItemList.Circuit_Parts_CapacitorXSMD.get(48L),
                            ItemList.Circuit_Parts_DiodeXSMD.get(48L), ItemList.Circuit_Chip_PPIC.get(64L),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.NiobiumTitanium, Materials2Shapes.foil, (int) (16)),
                            MaterialLibAPI.getStack(Materials2Materials.Osmium, Materials2Shapes.bolt, (int) (32)),
                            MaterialLibAPI.getStack(Materials2Materials.Neutronium, Materials2Shapes.bolt, (int) (16)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Lanthanum, Materials2Shapes.wireFine, (int) (64)) },
                    new FluidStack[] {
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.SolderingAlloy,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (3744L)),
                            MU.materialOf(Materials2Materials.UUMatter).getFluid(8_000L),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Osmium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (1_152L)) },
                    NHItemList.PikoCircuitPolychrome.get(1),
                    500 * SECONDS,
                    (int) TierEU.RECIPE_UEV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.PikoCircuitPolychrome.get(1),
                    192000 * 4,
                    512 * 4,
                    (int) TierEU.RECIPE_UEV,
                    32 * 4,
                    new Object[] {
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Neutronium), 16),
                            NHItemList.PikoCircuitPolychrome.get(2), ItemList.Circuit_Parts_CapacitorXSMD.get(64L),
                            ItemList.Circuit_Parts_DiodeXSMD.get(64L), ItemList.Circuit_Parts_TransistorXSMD.get(64L),
                            ItemList.Circuit_Parts_ResistorXSMD.get(64L), ItemList.Circuit_Chip_QPIC.get(64L),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.NiobiumTitanium, Materials2Shapes.foil, (int) (64)),
                            MaterialLibAPI.getStack(Materials2Materials.Indium, Materials2Shapes.bolt, (int) (64)),
                            GTOreDictUnificator
                                    .get(OrePrefixes.wireGt01, MU.materialOf(Materials2Materials.Bedrockium), 8),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Lanthanum, Materials2Shapes.wireFine, (int) (64)) },
                    new FluidStack[] {
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.SolderingAlloy,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (3744L)),
                            MU.materialOf(Materials2Materials.UUMatter).getFluid(24_000L),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Osmium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (2_304L)) },
                    NHItemList.QuantumCircuitPolychrome.get(1),
                    1000 * SECONDS,
                    (int) TierEU.RECIPE_UIV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.GatePlateOrigin.get(1),
                    32_000_000 * 12,
                    8192,
                    (int) TierEU.RECIPE_UIV,
                    64,
                    new ItemStack[] { getModItem(EternalSingularity.ID, "eternal_singularity", 1),
                            ItemList.Sensor_UEV.get(16L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.Infinity), 16L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.CosmicNeutronium), 16L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.NaquadahAlloy), 64L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.NaquadahAlloy), 64L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.NaquadahAlloy), 64L),
                            NHItemList.QuantumCircuitPolychrome.get(16) },
                    new FluidStack[] {
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Neutronium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (36_864L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Tritanium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (36_864L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Longasssuperconductornameforuhvwire,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (36_864L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Silver,
                                    Materials2FluidShapes.fluidPlasma,
                                    (int) (36_864L)) },
                    NHItemList.GatePlatePolychrome.get(1),
                    1 * HOURS,
                    (int) TierEU.RECIPE_UIV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.ChevronOrigin.get(1),
                    32_000_000 * 12,
                    8192,
                    (int) TierEU.RECIPE_UIV,
                    64,
                    new ItemStack[] { ItemList.Electric_Piston_UEV.get(16L), ItemList.Electric_Motor_UEV.get(64L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.Infinity), 16L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.NaquadahAlloy), 64L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.NetherStar), 16L),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Ardite, Materials2Shapes.plateDense, (int) (8L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Ardite, Materials2Shapes.plateDense, (int) (8L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Ardite, Materials2Shapes.plateDense, (int) (8L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Ruby, Materials2Shapes.gemExquisite, (int) (64L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Jasper, Materials2Shapes.gemExquisite, (int) (64L)),
                            NHItemList.QuantumCircuitPolychrome.get(32) },
                    new FluidStack[] {
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Neutronium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (9_216L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Tritanium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (9_216L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Longasssuperconductornameforuhvwire,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (9_216L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Silver,
                                    Materials2FluidShapes.fluidPlasma,
                                    (int) (9_216L)) },
                    NHItemList.ChevronPolychrome.get(1),
                    1 * HOURS,
                    (int) TierEU.RECIPE_UIV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.FramePartOrigin.get(1),
                    32_000_000 * 12,
                    8192,
                    (int) TierEU.RECIPE_UIV,
                    64,
                    new ItemStack[] {
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Infinity, Materials2Shapes.stickLong, (int) (64L)),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.NaquadahAlloy,
                                    Materials2Shapes.stickLong,
                                    (int) (64L)),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.CosmicNeutronium,
                                    Materials2Shapes.stickLong,
                                    (int) (64L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Neutronium, Materials2Shapes.stickLong, (int) (64L)),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.Osmiridium,
                                    Materials2Shapes.stickLong,
                                    (int) (64L)) },
                    new FluidStack[] {
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Neutronium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (73_728L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Tritanium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (73_728L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Concrete,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (73_728L)) },
                    NHItemList.FramePartPolychrome.get(1),
                    1 * HOURS,
                    (int) TierEU.RECIPE_UIV);

            // UMV Gate
            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    ItemList.Circuit_Wafer_NPIC.get(1L),
                    192_000,
                    512,
                    (int) TierEU.RECIPE_UEV,
                    32,
                    new Object[] {
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Tritanium), 8),
                            ItemList.Circuit_Biomainframe.get(2L), ItemList.Circuit_Parts_CapacitorXSMD.get(32L),
                            ItemList.Circuit_Parts_ResistorXSMD.get(32L),
                            ItemList.Circuit_Parts_TransistorXSMD.get(32L), ItemList.Circuit_Parts_DiodeXSMD.get(32L),
                            ItemList.Circuit_Chip_Ram.get(64L), ItemList.Circuit_Chip_NPIC.get(64L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.wireGt01, MU.materialOf(Materials2Materials.Draconium), 64),
                            Superconductors.UHV.getWireGt02(64),
                            new Object[] { OrePrefixes.foil.get(Materials.AnySyntheticRubber), 64L },
                            MaterialLibAPI.getStack(
                                    Materials2Materials.Polybenzimidazole,
                                    Materials2Shapes.foil,
                                    (int) (64)) },
                    new FluidStack[] { new FluidStack(FluidRegistry.getFluid("molten.mutatedlivingsolder"), 3_744),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Naquadria,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (4_032L)),
                            new FluidStack(FluidRegistry.getFluid("ic2coolant"), 20_000) },
                    NHItemList.NanoCircuit.get(1),
                    400 * SECONDS,
                    (int) TierEU.RECIPE_UIV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.NanoCircuit.get(1),
                    384_000,
                    1_024,
                    4_000_000,
                    64,
                    new Object[] { ItemList.Circuit_Board_Bio_Ultra.get(1L), NHItemList.PicoWafer.get(4),
                            NHItemList.NanoCircuit.get(2), ItemList.Circuit_Parts_TransistorXSMD.get(48L),
                            ItemList.Circuit_Parts_ResistorXSMD.get(48L), ItemList.Circuit_Parts_CapacitorXSMD.get(48L),
                            ItemList.Circuit_Parts_DiodeXSMD.get(48L), ItemList.Circuit_Chip_PPIC.get(64L),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.NiobiumTitanium, Materials2Shapes.foil, (int) (16)),
                            MaterialLibAPI.getStack(Materials2Materials.Osmium, Materials2Shapes.bolt, (int) (32)),
                            MaterialLibAPI.getStack(Materials2Materials.Neutronium, Materials2Shapes.bolt, (int) (16)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Lanthanum, Materials2Shapes.wireFine, (int) (64)) },
                    new FluidStack[] { new FluidStack(FluidRegistry.getFluid("molten.mutatedlivingsolder"), 3_744),
                            MU.materialOf(Materials2Materials.UUMatter).getFluid(8000L),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Osmium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (1152L)) },
                    NHItemList.PikoCircuitDimensional.get(1),
                    500 * SECONDS,
                    (int) TierEU.RECIPE_UMV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.PikoCircuitDimensional.get(1),
                    720_000,
                    2_048,
                    (int) TierEU.RECIPE_UEV,
                    128,
                    new ItemStack[] {
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Neutronium), 16),
                            NHItemList.PikoCircuitDimensional.get(2), ItemList.Circuit_Parts_CapacitorXSMD.get(64L),
                            ItemList.Circuit_Parts_DiodeXSMD.get(64L), ItemList.Circuit_Parts_TransistorXSMD.get(64L),
                            ItemList.Circuit_Parts_ResistorXSMD.get(64L), ItemList.Circuit_Chip_QPIC.get(64L),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.NiobiumTitanium, Materials2Shapes.foil, (int) (64)),
                            MaterialLibAPI.getStack(Materials2Materials.Indium, Materials2Shapes.bolt, (int) (64)),
                            GTOreDictUnificator
                                    .get(OrePrefixes.wireGt01, MU.materialOf(Materials2Materials.SpaceTime), 8),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Lanthanum, Materials2Shapes.wireFine, (int) (64)) },
                    new FluidStack[] { new FluidStack(FluidRegistry.getFluid("molten.mutatedlivingsolder"), 3_744),
                            MU.materialOf(Materials2Materials.UUMatter).getFluid(24_000L),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Osmium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (2_304L)) },
                    NHItemList.QuantumCircuitDimensional.get(1),
                    1000 * SECONDS,
                    (int) TierEU.RECIPE_UXV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.GatePlatePolychrome.get(1),
                    2_000_000_000,
                    32_768,
                    (int) TierEU.RECIPE_UXV,
                    64,
                    new ItemStack[] { ItemList.Casing_Dim_Bridge.get(64),
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.Infinity), 64L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.Infinity), 64L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.Infinity), 64L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.SpaceTime), 16L),
                            NHItemList.QuantumCircuitDimensional.get(16),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.SpaceTime, Materials2Shapes.plateDense, (int) (8L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.SpaceTime, Materials2Shapes.plateDense, (int) (8L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Infinity, Materials2Shapes.plateDense, (int) (8L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Infinity, Materials2Shapes.plateDense, (int) (8L)),
                            ItemList.Sensor_UMV.get(16L), ItemList.Emitter_UMV.get(16L),
                            getModItem(EternalSingularity.ID, "eternal_singularity", 16) },
                    new FluidStack[] {
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Neutronium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (32_768_000L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.SpaceTime,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (4 * 36864L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.SuperconductorUMVBase,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (4 * 36864L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.ExcitedDTEC,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (4 * 36864L)) },
                    NHItemList.GatePlateDimensional.get(1),
                    1 * HOURS,
                    (int) TierEU.RECIPE_UXV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.ChevronPolychrome.get(1),
                    2_000_000_000,
                    32_768,
                    (int) TierEU.RECIPE_UXV,
                    64,
                    new ItemStack[] {
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.Infinity), 64L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.NaquadahAlloy), 64L),
                            ItemList.Casing_Dim_Bridge.get(64), ItemList.Casing_Dim_Bridge.get(64),
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.SpaceTime), 16L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Infinity), 16L),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Ruby, Materials2Shapes.gemExquisite, (int) (16L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Jasper, Materials2Shapes.gemExquisite, (int) (16L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Opal, Materials2Shapes.gemExquisite, (int) (16L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Sapphire, Materials2Shapes.gemExquisite, (int) (16L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Osmiridium, Materials2Shapes.plateDense, (int) (8L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Osmiridium, Materials2Shapes.plateDense, (int) (8L)),
                            ItemList.Electric_Motor_UMV.get(64L), ItemList.Electric_Piston_UMV.get(64L),
                            ItemList.Field_Generator_UMV.get(16L), NHItemList.QuantumCircuitDimensional.get(32), },
                    new FluidStack[] {
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Neutronium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (32_768_000L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.SpaceTime,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (4 * 36864L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.SuperconductorUMVBase,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (4 * 36864L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.ExcitedDTEC,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (4 * 36864L)) },
                    NHItemList.ChevronDimensional.get(1),
                    1 * HOURS,
                    (int) TierEU.RECIPE_UXV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.FramePartPolychrome.get(1),
                    2_000_000_000,
                    32_768,
                    (int) TierEU.RECIPE_UXV,
                    64,
                    new ItemStack[] {
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Infinity, Materials2Shapes.stickLong, (int) (64L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.SpaceTime, Materials2Shapes.stickLong, (int) (64L)),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.NaquadahAlloy,
                                    Materials2Shapes.stickLong,
                                    (int) (64L)),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.CosmicNeutronium,
                                    Materials2Shapes.stickLong,
                                    (int) (64L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Neutronium, Materials2Shapes.stickLong, (int) (64L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Osmiridium, Materials2Shapes.stickLong, (int) (64L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Californium, Materials2Shapes.stickLong, (int) (64)),
                            MaterialsAlloy.QUANTUM.getLongRod(64), MaterialsElements.STANDALONE.HYPOGEN.getLongRod(64),
                            MaterialsElements.STANDALONE.CELESTIAL_TUNGSTEN.getLongRod(64),
                            GGMaterial.tairitsu.get(OrePrefixes.stickLong, 64),
                            MaterialsElements.STANDALONE.ASTRAL_TITANIUM.getLongRod(64),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.SuperconductorUMVBase,
                                    Materials2Shapes.stickLong,
                                    (int) (64L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Sunnarium, Materials2Shapes.stickLong, (int) (64L)),
                            MaterialsAlloy.ABYSSAL.getLongRod(64),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.TranscendentMetal,
                                    Materials2Shapes.stickLong,
                                    (int) (64L)), },
                    new FluidStack[] {
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Neutronium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (32_768_000L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.SpaceTime,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (4 * 36864L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.SuperconductorUMVBase,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (4 * 36864L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.ExcitedDTEC,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (4 * 36864L)) },
                    NHItemList.FramePartDimensional.get(1),
                    1 * HOURS,
                    (int) TierEU.RECIPE_UXV);

            // UXV Gate
            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.GatePlateDimensional.get(1),
                    (int) TierEU.RECIPE_MAX,
                    32768,
                    (int) TierEU.RECIPE_UXV,
                    64,
                    new Object[] { ItemList.Casing_Dim_Bridge.get(64),
                            tectech.thing.CustomItemList.StabilisationFieldGeneratorTier8.get(64),
                            GTOreDictUnificator.get("blockShirabon", 64L),
                            GTOreDictUnificator.get("blockShirabon", 64L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.SpaceTime), 64L),
                            NHItemList.QuantumCircuitHeavenly.get(16),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.SpaceTime, Materials2Shapes.plateDense, (int) (8L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Universium, Materials2Shapes.plateDense, (int) (8L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Infinity, Materials2Shapes.plateDense, (int) (8L)),
                            GTOreDictUnificator.get("plateDenseShirabon", 8L), ItemList.Sensor_UXV.get(16L),
                            ItemList.Emitter_UXV.get(16L), getModItem(EternalSingularity.ID, "eternal_singularity", 16),
                            GTOreDictUnificator
                                    .get(OrePrefixes.nanite, MU.materialOf(Materials2Materials.Universium), 16),
                            GTOreDictUnificator
                                    .get(OrePrefixes.nanite, MU.materialOf(Materials2Materials.BlackDwarfMatter), 16),
                            GTOreDictUnificator
                                    .get(OrePrefixes.nanite, MU.materialOf(Materials2Materials.WhiteDwarfMatter), 16) },
                    new FluidStack[] {
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Neutronium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (32_768_000L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.SpaceTime,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (4 * 36864L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.SuperconductorUMVBase,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (4 * 36864L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.ExcitedDTEC,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (4 * 36864L)) },
                    NHItemList.GatePlateHarmonic.get(1),
                    125_000 * SECONDS,
                    (int) TierEU.RECIPE_UMV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.ChevronDimensional.get(1),
                    (int) TierEU.RECIPE_MAX,
                    32_768,
                    (int) TierEU.RECIPE_UXV,
                    64,
                    new Object[] {
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.TranscendentMetal), 64L),
                            GTOreDictUnificator.get("blockShirabon", 64),
                            tectech.thing.CustomItemList.EOH_Reinforced_Spatial_Casing.get(64),
                            tectech.thing.CustomItemList.EOH_Reinforced_Spatial_Casing.get(64),
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.SpaceTime), 16L),
                            GTOreDictUnificator.get(
                                    OrePrefixes.frameGt,
                                    MU.materialOf(Materials2Materials.MagnetohydrodynamicallyConstrainedStarMatter),
                                    16L),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Ruby, Materials2Shapes.gemExquisite, (int) (16L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Jasper, Materials2Shapes.gemExquisite, (int) (16L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Opal, Materials2Shapes.gemExquisite, (int) (16L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Sapphire, Materials2Shapes.gemExquisite, (int) (16L)),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.MagnetohydrodynamicallyConstrainedStarMatter,
                                    Materials2Shapes.plateDense,
                                    (int) (8L)),
                            GTOreDictUnificator.get("plateDenseShirabon", 8), ItemList.Electric_Motor_UXV.get(64L),
                            ItemList.Electric_Piston_UXV.get(64L), ItemList.Field_Generator_UXV.get(16L),
                            NHItemList.QuantumCircuitHeavenly.get(32) },
                    new FluidStack[] {
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Neutronium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (32_768_000L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.SpaceTime,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (4 * 36864L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.MagnetohydrodynamicallyConstrainedStarMatter,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (36864L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.ExcitedDTEC,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (4 * 36864L)) },
                    NHItemList.ChevronHarmonic.get(1),
                    125_000 * SECONDS,
                    (int) TierEU.RECIPE_UMV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.FramePartDimensional.get(1),
                    (int) TierEU.RECIPE_MAX,
                    32_768,
                    (int) TierEU.RECIPE_UXV,
                    64,
                    new ItemStack[] {
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Infinity, Materials2Shapes.stickLong, (int) (64L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.SpaceTime, Materials2Shapes.stickLong, (int) (64L)),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.MagnetohydrodynamicallyConstrainedStarMatter,
                                    Materials2Shapes.stickLong,
                                    (int) (64L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Neutronium, Materials2Shapes.stickLong, (int) (64L)),

                            MaterialLibAPI
                                    .getStack(Materials2Materials.Osmiridium, Materials2Shapes.stickLong, (int) (64L)),
                            GTOreDictUnificator.get("stickLongShirabon", 64),
                            MaterialLibAPI.getStack(Materials2Materials.Californium, Materials2Shapes.stickLong, 64),
                            MaterialsAlloy.QUANTUM.getLongRod(64), MaterialsElements.STANDALONE.HYPOGEN.getLongRod(64),
                            MaterialsElements.STANDALONE.CELESTIAL_TUNGSTEN.getLongRod(64),
                            MaterialLibAPI.getStack(Materials2Materials.Tairitsu, Materials2Shapes.stickLong, 64),
                            MaterialsElements.STANDALONE.ASTRAL_TITANIUM.getLongRod(64),

                            MaterialLibAPI.getStack(
                                    Materials2Materials.SuperconductorUMVBase,
                                    Materials2Shapes.stickLong,
                                    (int) (64L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Universium, Materials2Shapes.stickLong, (int) (64L)),
                            MaterialsAlloy.ABYSSAL.getLongRod(64),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.TranscendentMetal,
                                    Materials2Shapes.stickLong,
                                    (int) (64L)), },
                    new FluidStack[] {
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Neutronium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (32_768_000L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.SpaceTime,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (4 * 36864L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Universium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (4 * 36864L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.ExcitedDTEC,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (4 * 36864L)) },
                    NHItemList.FramePartHarmonic.get(1),
                    125_000 * SECONDS,
                    (int) TierEU.RECIPE_UMV);
        }

        GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1))
                .metadata(SCANNING, new Scanning(1 * MINUTES + 40 * SECONDS, TierEU.RECIPE_EV))
                .itemInputs(
                        ItemList.Hatch_Input_Bus_ME.get(1L),
                        // 4096k Me Storage Component
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 59),
                        // ME Controller
                        getModItem(AppliedEnergistics2.ID, "tile.BlockController", 1, WILDCARD),
                        // Interface
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 440),
                        // Pattern capacity card
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 3, 54))
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
                            getModItem(GraviSuite.ID, "ultimateLappack", 1, WILDCARD),
                            getModItem(GraviSuite.ID, "itemSimpleItem", 6, 1),
                            getModItem(GraviSuite.ID, "itemSimpleItem", 2, 2),
                            getModItem(GraviSuite.ID, "itemSimpleItem", 2, 3),
                            new Object[] { Circuits.ZPM.getIngredient(), 2L },
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Duranium, Materials2Shapes.plateDense, (int) (2)),
                            ItemList.Energy_LapotronicOrb2.get(1L),
                            ItemList.Field_Generator_IV.get(2L),
                            ItemList.Electric_Motor_ZPM.get(2L),
                            MaterialLibAPI.getStack(Materials2Materials.Duranium, Materials2Shapes.screw, (int) (4)))
                    .fluidInputs(
                            new FluidStack(solderIndalloy, 2304),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Tritanium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (1440L)))
                    .itemOutputs(getModItem(GraviSuite.ID, "graviChestPlate", 1, 26)).eut(TierEU.RECIPE_LuV / 2)
                    .duration(1 * MINUTES + 15 * SECONDS).addTo(AssemblyLine);

            // Relocator
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Casing_Coil_Superconductor.get(1L))
                    .metadata(SCANNING, new Scanning(2 * MINUTES, TierEU.RECIPE_ZPM))
                    .itemInputs(
                            ItemList.Casing_Fusion_Coil.get(16L),
                            Superconductors.UV.getWireGt16(16),
                            new Object[] { Circuits.UV.getIngredient(), 16L },
                            ItemList.Sensor_UV.get(16L),
                            ItemList.Emitter_UV.get(16L),
                            ItemList.Field_Generator_UV.get(8L),
                            ItemList.Circuit_Wafer_QPIC.get(64L),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Americium, Materials2Shapes.wireFine, (int) (64L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Americium, Materials2Shapes.wireFine, (int) (64L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Americium, Materials2Shapes.wireFine, (int) (64L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Americium, Materials2Shapes.wireFine, (int) (64L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Americium, Materials2Shapes.wireFine, (int) (64L)))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Longasssuperconductornameforuvwire,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (2880L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Americium,
                                    Materials2FluidShapes.fluidPlasma,
                                    (int) (2880L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Enderium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (5760L)))
                    .itemOutputs(getModItem(GraviSuite.ID, "relocator", 1, 26)).eut(TierEU.RECIPE_UV)
                    .duration(3 * MINUTES).addTo(AssemblyLine);
        }

        // Electromagnets
        {
            // Steel Electromagnet
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Electromagnet_Iron.get(1))
                    .metadata(SCANNING, new Scanning(40 * SECONDS, TierEU.RECIPE_IV))
                    .itemInputs(
                            MaterialLibAPI.getStack(
                                    Materials2Materials.NickelZincFerrite,
                                    Materials2Shapes.plate,
                                    (int) (32L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.SteelMagnetic, Materials2Shapes.ring, (int) (16L)),
                            ItemList.LuV_Coil.get(16L),
                            Superconductors.LuV.getWireGt02(32),
                            ItemList.Field_Generator_LuV.get(2))
                    .itemOutputs(ItemList.Electromagnet_Steel.get(1))
                    .fluidInputs(
                            new FluidStack(FluidRegistry.getFluid("ic2coolant"), 8000),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Cobalt,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (2304)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.VanadiumGallium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (2304)))
                    .duration(60 * SECONDS).eut((int) TierEU.RECIPE_LuV).addTo(AssemblyLine);

            // Neodymium Electromagnet
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Electromagnet_Steel.get(1))
                    .metadata(SCANNING, new Scanning(50 * SECONDS, TierEU.RECIPE_LuV))
                    .itemInputs(
                            MaterialLibAPI
                                    .getStack(Materials2Materials.NaquadahAlloy, Materials2Shapes.plate, (int) (32L)),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.NeodymiumMagnetic,
                                    Materials2Shapes.ring,
                                    (int) (16L)),
                            ItemList.ZPM_Coil.get(16L),
                            Superconductors.ZPM.getWireGt04(32),
                            ItemList.Field_Generator_ZPM.get(2))
                    .itemOutputs(ItemList.Electromagnet_Neodymium.get(1))
                    .fluidInputs(
                            new FluidStack(FluidRegistry.getFluid("ic2coolant"), 16000),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Cobalt,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (4608)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Osmiridium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (2304)))
                    .duration(60 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(AssemblyLine);

            // Samarium Electromagnet
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Electromagnet_Neodymium.get(1))
                    .metadata(SCANNING, new Scanning(1 * MINUTES, TierEU.RECIPE_ZPM))
                    .itemInputs(
                            MaterialLibAPI.getStack(
                                    Materials2Materials.Neutronium,
                                    Materials2Shapes.plateDouble,
                                    (int) (32L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.SamariumMagnetic, Materials2Shapes.ring, (int) (32L)),
                            ItemList.UV_Coil.get(32L),
                            Superconductors.UV.getWireGt04(64),
                            ItemList.Field_Generator_UV.get(2))
                    .itemOutputs(ItemList.Electromagnet_Samarium.get(1))
                    .fluidInputs(
                            new FluidStack(FluidRegistry.getFluid("supercoolant"), 32000),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Cobalt,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (6912)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.ElectrumFlux,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (2304)))
                    .duration(60 * SECONDS).eut(TierEU.RECIPE_UV).addTo(AssemblyLine);

            // Tengam Electromagnet
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Electromagnet_Samarium.get(1))
                    .metadata(SCANNING, new Scanning(1 * MINUTES + 10 * SECONDS, TierEU.RECIPE_UV))
                    .itemInputs(
                            MaterialLibAPI.getStack(
                                    Materials2Materials.CosmicNeutronium,
                                    Materials2Shapes.plateDouble,
                                    (int) (32L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.TengamAttuned, Materials2Shapes.ring, (int) (32L)),
                            ItemList.UHV_Coil.get(32L),
                            Superconductors.UHV.getWireGt08(64),
                            ItemList.Field_Generator_UHV.get(2))
                    .itemOutputs(ItemList.Electromagnet_Tengam.get(1))
                    .fluidInputs(
                            new FluidStack(FluidRegistry.getFluid("supercoolant"), 64000),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Cobalt,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (9216)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Naquadria,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (2304)))
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
                                getModItem(EtFuturumRequiem.ID, "netherite_block", 4),
                                ItemList.Electric_Piston_ZPM.get(16),
                                ItemList.Robot_Arm_ZPM.get(4),
                                ItemList.Electric_Pump_ZPM.get(4),
                                new Object[] { Circuits.UV.getIngredient(), 4 })
                        .itemOutputs(ItemList.Machine_Multi_HIPCompressor.get(1))
                        .fluidInputs(
                                GGMaterial.incoloy903.getMolten(256 * 144),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.NaquadahEnriched,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (64 * 144)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.LiquidAir,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (16000)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Lubricant,
                                        Materials2FluidShapes.fluidLiquid,
                                        (int) (16000)))
                        .duration(120 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(AssemblyLine);
            }

            if (UniversalSingularities.isModLoaded()) {
                // Steel singularity
                GTValues.RA.stdBuilder()
                        .metadata(
                                RESEARCH_ITEM,
                                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 11))
                        .metadata(SCANNING, new Scanning(3 * MINUTES, TierEU.RECIPE_UEV))
                        .itemInputs(
                                ItemList.Machine_Multi_HIPCompressor.get(1),
                                ItemList.Machine_Multi_NeutroniumCompressor.get(1),
                                ItemList.AdvancedImplosionCompressor.get(16),
                                ItemList.CompressorUIV.get(8L),
                                ItemList.ElectricImplosionCompressor.get(4),
                                ItemList.Field_Generator_UEV.get(4),
                                ItemList.ZPM3.get(2),
                                new Object[] { Circuits.UIV.getIngredient(), 4 },
                                GregtechItemList.Laser_Lens_Special.get(64),
                                MaterialLibAPI.getStack(
                                        Materials2Materials.protohalkonite,
                                        Materials2Shapes.ring,
                                        (int) (32)),
                                MaterialLibAPI.getStack(
                                        Materials2Materials.protohalkonite,
                                        Materials2Shapes.rotor,
                                        (int) (16)),
                                GTOreDictUnificator
                                        .get(OrePrefixes.gear, MU.materialOf(Materials2Materials.protohalkonite), 8),
                                MaterialLibAPI.getStack(
                                        Materials2Materials.Neutronium,
                                        Materials2Shapes.plateSuperdense,
                                        (int) (16)),
                                MaterialLibAPI.getStack(
                                        Materials2Materials.Naquadria,
                                        Materials2Shapes.plateSuperdense,
                                        (int) (16)),
                                MaterialLibAPI.getStack(
                                        Materials2Materials.CosmicNeutronium,
                                        Materials2Shapes.plateSuperdense,
                                        (int) (8)),
                                MaterialLibAPI.getStack(
                                        Materials2Materials.Kevlar,
                                        Materials2Shapes.plateSuperdense,
                                        (int) (4)))
                        .itemOutputs(ItemList.Machine_Multi_BlackHoleCompressor.get(1))
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.SpaceTime,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (1440)),
                                new FluidStack(FluidRegistry.getFluid("oganesson"), 256000),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.SuperconductorUIVBase,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (144 * 300)),
                                MaterialLibAPI.getFluidStack(
                                        Materials2Materials.Infinity,
                                        Materials2FluidShapes.fluidMolten,
                                        (int) (144 * 100)))
                        .duration(120 * SECONDS).eut(TierEU.RECIPE_UIV).addTo(AssemblyLine);
            }
        }

        // Waterline controllers
        {

            // Water Purification Plant
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, new ItemStack(Items.water_bucket, 1))
                    .metadata(SCANNING, new Scanning(30 * SECONDS, TierEU.RECIPE_IV))
                    .itemInputs(
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Tungsten), 4L),
                            ItemList.BlockIndustrialWaterPlantCasing.get(8),
                            ItemList.BlockSterileWaterPlantCasing.get(8),
                            ItemList.Electric_Motor_LuV.get(2),
                            ItemList.Robot_Arm_LuV.get(1),
                            ItemList.Electric_Pump_LuV.get(4),
                            new Object[] { Circuits.LuV.getIngredient(), 4 },
                            new Object[] { Circuits.ZPM.getIngredient(), 2 },
                            GTOreDictUnificator
                                    .get(OrePrefixes.cableGt08, MU.materialOf(Materials2Materials.NiobiumTitanium), 8))
                    .fluidInputs(
                            new FluidStack(solderIndalloy, 8 * 144),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Lubricant,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (16000)))
                    .itemOutputs(ItemList.Machine_Multi_PurificationPlant.get(1)).duration(60 * SECONDS)
                    .eut(TierEU.RECIPE_LuV).addTo(AssemblyLine);

            // Clarifier Purification Unit
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.LargeSifter.get(1))
                    .metadata(SCANNING, new Scanning(40 * SECONDS, TierEU.RECIPE_IV))
                    .itemInputs(
                            ItemList.ActivatedCarbonFilterMesh.get(16),
                            ItemList.BlockSterileWaterPlantCasing.get(8),
                            ItemList.Casing_Vent.get(8),
                            tectech.thing.CustomItemList.eM_energyMulti64_LuV.get(1),
                            ItemList.Electric_Motor_LuV.get(4),
                            ItemList.Electric_Pump_LuV.get(4),
                            new Object[] { Circuits.LuV.getIngredient(), 4 },
                            new Object[] { Circuits.ZPM.getIngredient(), 2 },
                            GTOreDictUnificator
                                    .get(OrePrefixes.pipeMedium, MU.materialOf(Materials2Materials.TungstenSteel), 16))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Osmium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (8 * 144)),
                            new FluidStack(solderIndalloy, 8 * 144),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Lubricant,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (16000)))
                    .itemOutputs(ItemList.Machine_Multi_PurificationUnitClarifier.get(1)).duration(60 * SECONDS)
                    .eut(TierEU.RECIPE_LuV).addTo(AssemblyLine);

            // Ozonation Purification Unit
            GTValues.RA.stdBuilder().metadata(
                    RESEARCH_ITEM,
                    MaterialLibAPI
                            .getStack(Materials2Materials.Grade1PurifiedWater, Materials2CellShapes.cell, (int) (1)))
                    .metadata(SCANNING, new Scanning(40 * SECONDS, TierEU.RECIPE_IV))
                    .itemInputs(
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.TungstenSteel), 8),
                            ItemList.BlockOzoneCasing.get(8),
                            ItemList.Casing_Vent.get(8),
                            tectech.thing.CustomItemList.eM_energyMulti64_LuV.get(1),
                            HASTELLOY_C276.getPlate(8),
                            HASTELLOY_C276.getRotor(4),
                            HASTELLOY_X.getRotor(4),
                            HASTELLOY_X.getPlate(8),
                            ItemList.Electric_Motor_LuV.get(4),
                            ItemList.Electric_Pump_LuV.get(4),
                            new Object[] { Circuits.LuV.getIngredient(), 8 },
                            new Object[] { Circuits.ZPM.getIngredient(), 4 },
                            GTOreDictUnificator
                                    .get(OrePrefixes.pipeMedium, MU.materialOf(Materials2Materials.TungstenSteel), 32))
                    .fluidInputs(
                            HASTELLOY_C276.getFluidStack(8 * 144),
                            HASTELLOY_X.getFluidStack(8 * 144),
                            new FluidStack(solderIndalloy, 8 * 144),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Lubricant,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (16000)))
                    .itemOutputs(ItemList.Machine_Multi_PurificationUnitOzonation.get(1)).duration(60 * SECONDS)
                    .eut(TierEU.RECIPE_LuV).addTo(AssemblyLine);

            // Flocculation Purification Unit
            GTValues.RA.stdBuilder().metadata(
                    RESEARCH_ITEM,
                    MaterialLibAPI
                            .getStack(Materials2Materials.Grade2PurifiedWater, Materials2CellShapes.cell, (int) (1)))
                    .metadata(SCANNING, new Scanning(50 * SECONDS, TierEU.RECIPE_LuV))
                    .itemInputs(
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Adamantium), 8),
                            ItemList.BlockFlocculationCasing.get(8),
                            ItemList.Casing_Vent.get(8),
                            tectech.thing.CustomItemList.eM_energyMulti64_LuV.get(1),
                            MaterialLibAPI.getStack(Materials2Materials.Trinium, Materials2Shapes.plate, (int) (8)),
                            MaterialLibAPI.getStack(Materials2Materials.Trinium, Materials2Shapes.rotor, (int) (4)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.NaquadahAlloy, Materials2Shapes.rotor, (int) (4)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.NaquadahAlloy, Materials2Shapes.plate, (int) (8)),
                            ItemList.Electric_Motor_ZPM.get(4),
                            ItemList.Electric_Pump_ZPM.get(4),
                            new Object[] { Circuits.ZPM.getIngredient(), 4 },
                            // Still UV circuit, for some reason the alias is not working.
                            new Object[] { Circuits.UV.getIngredient(), 2 },
                            GTOreDictUnificator
                                    .get(OrePrefixes.pipeLarge, MU.materialOf(Materials2Materials.Naquadah), 16))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Iridium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (16 * 144)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.NaquadahAlloy,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (16 * 144)),
                            new FluidStack(solderIndalloy, 16 * 144),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Lubricant,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (32000)))
                    .itemOutputs(ItemList.Machine_Multi_PurificationUnitFlocculator.get(1)).duration(60 * SECONDS)
                    .eut(TierEU.RECIPE_ZPM).addTo(AssemblyLine);

            // pH Neutralization Purification Unit
            GTValues.RA.stdBuilder().metadata(
                    RESEARCH_ITEM,
                    MaterialLibAPI
                            .getStack(Materials2Materials.Grade3PurifiedWater, Materials2CellShapes.cell, (int) (1)))
                    .metadata(SCANNING, new Scanning(50 * SECONDS, TierEU.RECIPE_LuV))
                    .itemInputs(
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.NaquadahAlloy), 8),
                            ItemList.BlockNaquadahReinforcedWaterPlantCasing.get(8),
                            ItemList.BlockExtremeCorrosionResistantCasing.get(8),
                            tectech.thing.CustomItemList.eM_energyMulti64_ZPM.get(1),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.NaquadahAlloy, Materials2Shapes.plate, (int) (8)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.NaquadahAlloy, Materials2Shapes.rotor, (int) (4)),
                            HASTELLOY_C276.getRotor(4),
                            HASTELLOY_C276.getPlate(8),
                            ItemList.Electric_Motor_ZPM.get(4),
                            ItemList.Electric_Pump_ZPM.get(4),
                            new Object[] { Circuits.ZPM.getIngredient(), 8 },
                            // Still UV circuit, for some reason the alias is not working.
                            new Object[] { Circuits.UV.getIngredient(), 4 },
                            GTOreDictUnificator
                                    .get(OrePrefixes.pipeLarge, MU.materialOf(Materials2Materials.Naquadah), 32))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.NaquadahAlloy,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (16 * 144)),
                            HASTELLOY_C276.getFluidStack(16 * 144),
                            new FluidStack(solderIndalloy, 16 * 144),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Lubricant,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (32000)))
                    .itemOutputs(ItemList.Machine_Multi_PurificationUnitPhAdjustment.get(1)).duration(60 * SECONDS)
                    .eut(TierEU.RECIPE_ZPM).addTo(AssemblyLine);

            // Extreme Temperature Fluctuation Purification Unit
            GTValues.RA.stdBuilder().metadata(
                    RESEARCH_ITEM,
                    MaterialLibAPI
                            .getStack(Materials2Materials.Grade4PurifiedWater, Materials2CellShapes.cell, (int) (1)))
                    .metadata(SCANNING, new Scanning(1 * MINUTES, TierEU.RECIPE_ZPM))
                    .itemInputs(
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Neutronium), 8),
                            ItemList.BlockPlasmaHeatingCasing.get(8),
                            ItemList.Casing_Coil_Superconductor.get(8),
                            tectech.thing.CustomItemList.eM_energyMulti64_UV.get(1),
                            MaterialLibAPI.getStack(Materials2Materials.Neutronium, Materials2Shapes.plate, (int) (8)),
                            MaterialLibAPI.getStack(Materials2Materials.Neutronium, Materials2Shapes.rotor, (int) (4)),
                            MaterialLibAPI.getStack(Materials2Materials.Netherite, Materials2Shapes.rotor, (int) (4)),
                            MaterialLibAPI.getStack(Materials2Materials.Netherite, Materials2Shapes.plate, (int) (8)),
                            ItemList.Electric_Motor_UV.get(4),
                            ItemList.Electric_Pump_UV.get(4),
                            new Object[] { Circuits.ZPM.getIngredient(), 16 },
                            // Still UV circuit, for some reason the alias is not working.
                            new Object[] { Circuits.UV.getIngredient(), 8 },
                            GTOreDictUnificator
                                    .get(OrePrefixes.pipeLarge, MU.materialOf(Materials2Materials.Neutronium), 32))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Neutronium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (32 * 144)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Naquadria,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (32 * 144)),
                            new FluidStack(solderIndalloy, 32 * 144),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Lubricant,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (64000)))
                    .itemOutputs(ItemList.Machine_Multi_PurificationUnitPlasmaHeater.get(1)).duration(60 * SECONDS)
                    .eut(TierEU.RECIPE_UV).addTo(AssemblyLine);

            // High Energy Laser Purification Unit
            GTValues.RA.stdBuilder().metadata(
                    RESEARCH_ITEM,
                    MaterialLibAPI
                            .getStack(Materials2Materials.Grade5PurifiedWater, Materials2CellShapes.cell, (int) (1)))
                    .metadata(SCANNING, new Scanning(1 * MINUTES, TierEU.RECIPE_ZPM))
                    .itemInputs(
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Naquadria), 8),
                            ItemList.BlockNaquadriaReinforcedWaterPlantCasing.get(8),
                            ItemList.BlockUltraVioletLaserEmitter.get(8),
                            tectech.thing.CustomItemList.eM_energyMulti64_UV.get(1),
                            MaterialLibAPI.getStack(Materials2Materials.Neutronium, Materials2Shapes.plate, (int) (8)),
                            MaterialLibAPI.getStack(Materials2Materials.Neutronium, Materials2Shapes.rotor, (int) (4)),
                            MaterialLibAPI.getStack(Materials2Materials.Draconium, Materials2Shapes.rotor, (int) (4)),
                            MaterialLibAPI.getStack(Materials2Materials.Draconium, Materials2Shapes.plate, (int) (8)),
                            ItemList.Electric_Motor_UV.get(4),
                            ItemList.Electric_Pump_UV.get(4),
                            // Still UV circuit, for some reason the alias is not working.
                            new Object[] { Circuits.UV.getIngredient(), 8 },
                            new Object[] { Circuits.UHV.getIngredient(), 4 },
                            GTOreDictUnificator
                                    .get(OrePrefixes.pipeLarge, MU.materialOf(Materials2Materials.Neutronium), 64))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Neutronium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (32 * 144)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Naquadria,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (32 * 144)),
                            new FluidStack(solderIndalloy, 32 * 144),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Lubricant,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (64000)))
                    .itemOutputs(ItemList.Machine_Multi_PurificationUnitUVTreatment.get(1)).duration(60 * SECONDS)
                    .eut(TierEU.RECIPE_UV).addTo(AssemblyLine);

            // Residual Decontaminant Degasser Purification Unit
            GTValues.RA.stdBuilder().metadata(
                    RESEARCH_ITEM,
                    MaterialLibAPI
                            .getStack(Materials2Materials.Grade6PurifiedWater, Materials2CellShapes.cell, (int) (1)))
                    .metadata(SCANNING, new Scanning(1 * MINUTES + 10 * SECONDS, TierEU.RECIPE_UHV))
                    .itemInputs(
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Infinity), 8),
                            ItemList.BlockPlasmaHeatingCasing.get(8),
                            tectech.thing.CustomItemList.eM_Computer_Casing.get(8),
                            tectech.thing.CustomItemList.eM_energyMulti64_UEV.get(1),
                            MaterialLibAPI.getStack(Materials2Materials.Infinity, Materials2Shapes.plate, (int) (8)),
                            MaterialLibAPI.getStack(Materials2Materials.Infinity, Materials2Shapes.rotor, (int) (4)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.CosmicNeutronium, Materials2Shapes.rotor, (int) (4)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.CosmicNeutronium, Materials2Shapes.plate, (int) (8)),
                            ItemList.Electric_Motor_UEV.get(4),
                            ItemList.Electric_Pump_UEV.get(4),
                            new Object[] { Circuits.UHV.getIngredient(), 8 },
                            new Object[] { Circuits.UEV.getIngredient(), 4 },
                            GTOreDictUnificator
                                    .get(OrePrefixes.pipeMedium, MU.materialOf(Materials2Materials.Infinity), 32))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Quantium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (64 * 144)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Infinity,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (64 * 144)),
                            new FluidStack(solderUEV, 64 * 144),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Lubricant,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (128000)))
                    .itemOutputs(ItemList.Machine_Multi_PurificationUnitDegasifier.get(1)).duration(60 * SECONDS)
                    .eut(TierEU.RECIPE_UEV).addTo(AssemblyLine);

            // Absolute Baryonic Perfection Purification Unit
            GTValues.RA.stdBuilder().metadata(
                    RESEARCH_ITEM,
                    MaterialLibAPI
                            .getStack(Materials2Materials.Grade7PurifiedWater, Materials2CellShapes.cell, (int) (1)))
                    .metadata(SCANNING, new Scanning(1 * MINUTES + 10 * SECONDS, TierEU.RECIPE_UHV))
                    .itemInputs(
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Infinity), 16),
                            ItemList.BlockQuarkContainmentCasing.get(8),
                            ItemList.BlockQuarkReleaseChamber.get(8),
                            tectech.thing.CustomItemList.eM_energyMulti64_UEV.get(1),
                            MaterialLibAPI.getStack(Materials2Materials.Infinity, Materials2Shapes.plate, (int) (16)),
                            MaterialLibAPI.getStack(Materials2Materials.Infinity, Materials2Shapes.rotor, (int) (8)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.CosmicNeutronium, Materials2Shapes.rotor, (int) (8)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.CosmicNeutronium, Materials2Shapes.plate, (int) (16)),
                            ItemList.Electric_Motor_UEV.get(8),
                            ItemList.Electric_Pump_UEV.get(8),
                            new Object[] { Circuits.UHV.getIngredient(), 16 },
                            new Object[] { Circuits.UEV.getIngredient(), 8 },
                            GTOreDictUnificator
                                    .get(OrePrefixes.pipeMedium, MU.materialOf(Materials2Materials.Infinity), 64))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Longasssuperconductornameforuhvwire,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (64 * 144)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Infinity,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (64 * 144)),
                            new FluidStack(solderUEV, 64 * 144),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Lubricant,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (128000)))
                    .itemOutputs(ItemList.Machine_Multi_PurificationUnitParticleExtractor.get(1)).duration(60 * SECONDS)
                    .eut(TierEU.RECIPE_UIV).addTo(AssemblyLine);

            // Quark exclusion casing
            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    ItemList.StableBaryonContainmentUnit.get(1),
                    512 * 40 * SECONDS,
                    512,
                    (int) TierEU.UHV,
                    4,
                    new Object[] {
                            GTOreDictUnificator.get(
                                    OrePrefixes.frameGt,
                                    MU.materialOf(Materials2Materials.Longasssuperconductornameforuhvwire),
                                    32),
                            GTOreDictUnificator.get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Ledox), 32),
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.CallistoIce), 32),
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.EnrichedHolmium), 32),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.Longasssuperconductornameforuhvwire,
                                    Materials2Shapes.plate,
                                    (int) (32)),
                            MaterialLibAPI.getStack(Materials2Materials.Ledox, Materials2Shapes.plate, (int) (32)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.CallistoIce, Materials2Shapes.plate, (int) (32)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.EnrichedHolmium, Materials2Shapes.plate, (int) (32)),
                            ItemList.Field_Generator_UHV.get(1), new Object[] { Circuits.UEV.getIngredient(), 8 },
                            new Object[] { Circuits.UIV.getIngredient(), 4 },
                            GTOreDictUnificator
                                    .get(OrePrefixes.pipeMedium, MU.materialOf(Materials2Materials.Infinity), 32) },
                    new FluidStack[] {
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Longasssuperconductornameforuhvwire,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (64 * 144)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Ledox,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (64 * 144)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.CallistoIce,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (64 * 144)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.ExcitedDTRC,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (8000L)) },
                    ItemList.BlockQuarkContainmentCasing.get(8),
                    60 * SECONDS,
                    (int) TierEU.RECIPE_UIV);

            // Femtometer-calibrated particle beam casing
            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    ItemList.StableLeptonContainmentUnit.get(1),
                    512 * 40 * SECONDS,
                    512,
                    (int) TierEU.UHV,
                    4,
                    new Object[] {
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.CosmicNeutronium), 16),
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Infinity), 16),
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Tritanium), 16),
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Neutronium), 16),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.CosmicNeutronium, Materials2Shapes.plate, (int) (16)),
                            MaterialLibAPI.getStack(Materials2Materials.Infinity, Materials2Shapes.plate, (int) (16)),
                            MaterialLibAPI.getStack(Materials2Materials.Tritanium, Materials2Shapes.plate, (int) (16)),
                            MaterialLibAPI.getStack(Materials2Materials.Neutronium, Materials2Shapes.plate, (int) (16)),
                            ItemList.Field_Generator_UHV.get(1), new Object[] { Circuits.UEV.getIngredient(), 4 },
                            new Object[] { Circuits.UIV.getIngredient(), 2 },
                            GTOreDictUnificator
                                    .get(OrePrefixes.pipeMedium, MU.materialOf(Materials2Materials.Infinity), 16) },
                    new FluidStack[] {
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Infinity,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (32 * 144)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Tritanium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (32 * 144)),
                            new FluidStack(solderUEV, 32 * 144),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.ExcitedDTRC,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (4000L)) },
                    ItemList.BlockQuarkReleaseChamber.get(4),
                    60 * SECONDS,
                    (int) TierEU.RECIPE_UIV);

            // Particle beam guidance pipe casing
            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    ItemList.StableMesonContainmentUnit.get(1),
                    512 * 40 * SECONDS,
                    512,
                    (int) TierEU.UHV,
                    4,
                    new Object[] {
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.CosmicNeutronium), 16),
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Naquadria), 16),
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.NaquadahAlloy), 16),
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Bedrockium), 16),
                            MaterialLibAPI.getStack(Materials2Materials.Infinity, Materials2Shapes.foil, (int) (64)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.CosmicNeutronium, Materials2Shapes.foil, (int) (64)),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.Longasssuperconductornameforuhvwire,
                                    Materials2Shapes.foil,
                                    (int) (64)),
                            MaterialLibAPI.getStack(Materials2Materials.Draconium, Materials2Shapes.foil, (int) (64)),
                            ItemList.Electric_Pump_UEV.get(1), new Object[] { Circuits.UEV.getIngredient(), 4 },
                            new Object[] { Circuits.UIV.getIngredient(), 2 },
                            GTOreDictUnificator
                                    .get(OrePrefixes.pipeQuadruple, MU.materialOf(Materials2Materials.Infinity), 16) },
                    new FluidStack[] {
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Infinity,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (32 * 144)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Tritanium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (32 * 144)),
                            new FluidStack(solderUEV, 32 * 144),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.ExcitedDTRC,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (4000L)) },
                    ItemList.BlockQuarkPipe.get(4),
                    60 * SECONDS,
                    (int) TierEU.RECIPE_UIV);
        }

        // Superconducting Solenoids
        {
            // LuV
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Superconducting_Magnet_Solenoid_IV.get(1))
                    .metadata(SCANNING, new Scanning(40 * SECONDS, TierEU.RECIPE_IV))
                    .itemInputs(
                            Superconductors.LuV.getWireGt02(8),
                            GTOreDictUnificator.get(OrePrefixes.cableGt04, MU.materialOf(Materials2Materials.HSSG), 2L),
                            GTOreDictUnificator.get(
                                    OrePrefixes.pipeMedium,
                                    MU.materialOf(Materials2Materials.NiobiumTitanium),
                                    1L),
                            MaterialLibAPI.getStack(Materials2Materials.Mumetal, Materials2Shapes.stickLong, (int) (8)),
                            MaterialLibAPI.getStack(Materials2Materials.HSSS, Materials2Shapes.plateDouble, (int) (2L)),
                            ItemList.Reactor_Coolant_Sp_3.get(1),
                            ItemList.Reactor_Coolant_Sp_3.get(1),
                            ItemList.Electric_Pump_LuV.get(1))
                    .fluidInputs(new FluidStack(solderIndalloy, INGOTS * 4))
                    .itemOutputs(ItemList.Superconducting_Magnet_Solenoid_LuV.get(1)).duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_LuV).addTo(AssemblyLine);

            // ZPM
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Superconducting_Magnet_Solenoid_LuV.get(1))
                    .metadata(SCANNING, new Scanning(40 * SECONDS, TierEU.RECIPE_LuV))
                    .itemInputs(
                            Superconductors.ZPM.getWireGt02(8),
                            GTOreDictUnificator
                                    .get(OrePrefixes.cableGt04, MU.materialOf(Materials2Materials.Naquadah), 2L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.pipeMedium, MU.materialOf(Materials2Materials.Enderium), 1L),
                            MaterialLibAPI.getStack(Materials2Materials.Mumetal, Materials2Shapes.stickLong, (int) (8)),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.NaquadahAlloy,
                                    Materials2Shapes.plateDouble,
                                    (int) (2L)),
                            ItemList.Reactor_Coolant_Sp_6.get(1),
                            ItemList.Reactor_Coolant_Sp_6.get(1),
                            ItemList.Electric_Pump_ZPM.get(1))
                    .fluidInputs(new FluidStack(solderIndalloy, INGOTS * 4))
                    .itemOutputs(ItemList.Superconducting_Magnet_Solenoid_ZPM.get(1)).duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_ZPM).addTo(AssemblyLine);

            // UV
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Superconducting_Magnet_Solenoid_ZPM.get(1))
                    .metadata(SCANNING, new Scanning(40 * SECONDS, TierEU.RECIPE_ZPM))
                    .itemInputs(
                            Superconductors.UV.getWireGt02(16),
                            GTOreDictUnificator
                                    .get(OrePrefixes.cableGt04, MU.materialOf(Materials2Materials.ElectrumFlux), 2L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.pipeMedium, MU.materialOf(Materials2Materials.Naquadah), 1L),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Naquadria, Materials2Shapes.stickLong, (int) (8L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Neutronium, Materials2Shapes.plateDouble, (int) (2L)),
                            ItemList.Large_Fluid_Cell_Chrome.get(1),
                            ItemList.Electric_Pump_UV.get(1))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.SuperCoolant,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (16000)),
                            new FluidStack(solderIndalloy, INGOTS * 16))
                    .itemOutputs(ItemList.Superconducting_Magnet_Solenoid_UV.get(1)).duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_UV).addTo(AssemblyLine);

            // UHV
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Superconducting_Magnet_Solenoid_UV.get(1))
                    .metadata(SCANNING, new Scanning(40 * SECONDS, TierEU.RECIPE_UV))
                    .itemInputs(
                            Superconductors.UHV.getWireGt02(16),
                            GTOreDictUnificator
                                    .get(OrePrefixes.cableGt04, MU.materialOf(Materials2Materials.Bedrockium), 2L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.pipeMedium, MU.materialOf(Materials2Materials.Neutronium), 1L),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Naquadria, Materials2Shapes.stickLong, (int) (8L)),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.CosmicNeutronium,
                                    Materials2Shapes.plateDouble,
                                    (int) (2L)),
                            ItemList.Large_Fluid_Cell_Iridium.get(1),
                            ItemList.Electric_Pump_UHV.get(1))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.SuperCoolant,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (64000)),
                            new FluidStack(solderIndalloy, INGOTS * 64))
                    .itemOutputs(ItemList.Superconducting_Magnet_Solenoid_UHV.get(1)).duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_UHV).addTo(AssemblyLine);

            // UEV
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Superconducting_Magnet_Solenoid_UHV.get(1))
                    .metadata(SCANNING, new Scanning(40 * SECONDS, TierEU.RECIPE_UHV))
                    .itemInputs(
                            Superconductors.UEV.getWireGt02(16),
                            GTOreDictUnificator
                                    .get(OrePrefixes.cableGt04, MU.materialOf(Materials2Materials.Draconium), 2L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.pipeMedium, MU.materialOf(Materials2Materials.NetherStar), 1L),
                            GGMaterial.metastableOganesson.get(OrePrefixes.stickLong, 8),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Infinity, Materials2Shapes.plateDouble, (int) (2L)),
                            ItemList.Large_Fluid_Cell_Iridium.get(1),
                            ItemList.Electric_Pump_UEV.get(1))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.SuperCoolant,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (256000)),
                            new FluidStack(solderUEV, INGOTS * 8))
                    .itemOutputs(ItemList.Superconducting_Magnet_Solenoid_UEV.get(1)).duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_UEV).addTo(AssemblyLine);

            // UIV
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Superconducting_Magnet_Solenoid_UEV.get(1))
                    .metadata(SCANNING, new Scanning(40 * SECONDS, TierEU.RECIPE_UEV))
                    .itemInputs(
                            Superconductors.UIV.getWireGt02(16),
                            GTOreDictUnificator
                                    .get(OrePrefixes.cableGt04, MU.materialOf(Materials2Materials.NetherStar), 2L),
                            GTOreDictUnificator.get(
                                    OrePrefixes.pipeMedium,
                                    MU.materialOf(Materials2Materials.DraconiumAwakened),
                                    1L),
                            GGMaterial.metastableOganesson.get(OrePrefixes.stickLong, 8),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.TranscendentMetal,
                                    Materials2Shapes.plateDouble,
                                    (int) (2L)),
                            ItemList.Large_Fluid_Cell_Neutronium.get(1),
                            ItemList.Electric_Pump_UIV.get(1))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.TranscendentMetal,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (INGOTS * 32)),
                            new FluidStack(solderUEV, INGOTS * 32))
                    .itemOutputs(ItemList.Superconducting_Magnet_Solenoid_UIV.get(1)).duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_UIV).addTo(AssemblyLine);

            // UMV
            GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Superconducting_Magnet_Solenoid_UIV.get(1))
                    .metadata(SCANNING, new Scanning(40 * SECONDS, TierEU.RECIPE_UIV))
                    .itemInputs(
                            Superconductors.UMV.getWireGt02(16),
                            GTOreDictUnificator
                                    .get(OrePrefixes.cableGt04, MU.materialOf(Materials2Materials.Quantium), 2L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.pipeMedium, MU.materialOf(Materials2Materials.Infinity), 1L),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Infinity, Materials2Shapes.stickLong, (int) (8L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.SpaceTime, Materials2Shapes.plateDouble, (int) (2L)),
                            ItemList.Large_Fluid_Cell_Neutronium.get(1),
                            ItemList.Electric_Pump_UMV.get(1))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.SpaceTime,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (INGOTS * 16)),
                            new FluidStack(solderUEV, INGOTS * 128))
                    .itemOutputs(ItemList.Superconducting_Magnet_Solenoid_UMV.get(1)).duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_UMV).addTo(AssemblyLine);
        }

        // Miniature Wormhole Generator
        GTValues.RA.stdBuilder()
                .metadata(RESEARCH_ITEM, AEApi.instance().definitions().materials().singularity().maybeStack(1).get())
                .metadata(SCANNING, new Scanning(1 * MINUTES, TierEU.RECIPE_IV)).itemInputs(

                        tectech.thing.CustomItemList.Machine_Multi_Transformer.get(1),
                        AEApi.instance().definitions().materials().singularity().maybeStack(4).get(),
                        ItemList.Field_Generator_ZPM.get(4),
                        ItemList.Emitter_ZPM.get(4),
                        ItemList.Casing_Fusion_Coil.get(4),
                        new Object[] { Circuits.UV.getIngredient(), 2L },
                        tectech.thing.CustomItemList.LASERpipe.get(64))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Neutronium,
                                Materials2FluidShapes.fluidMolten,
                                (int) (144 * 12)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Tritanium,
                                Materials2FluidShapes.fluidMolten,
                                (int) (144 * 12)),
                        new FluidStack(solderIndalloy, 144 * 24),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SuperCoolant,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (144 * 48)))
                .itemOutputs(ItemList.WormholeGenerator.get(1L)).eut(TierEU.RECIPE_ZPM).duration(60 * SECONDS)
                .addTo(AssemblyLine);

        // Antimatter Forge - Antimatter Sequencer - SSASS
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                ItemList.NaquadahFuelRefinery.get(1),
                512000,
                2048,
                8000000,
                64,
                new Object[] { ItemRefer.Compact_Fusion_MK5.get(1),
                        GTOreDictUnificator
                                .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.protohalkonite), 16),
                        GregtechItemList.CosmicFabricManipulator.get(16), ItemRefer.Field_Restriction_Coil_T3.get(16),
                        MaterialsElements.STANDALONE.HYPOGEN.getFineWire(64),
                        MaterialLibAPI
                                .getStack(Materials2Materials.protohalkonite, Materials2Shapes.wireFine, (int) (64)),
                        new Object[] { Circuits.UIV.getIngredient(), 16L }, ItemList.Electric_Pump_UIV.get(16),
                        MaterialLibAPI.getStack(
                                Materials2Materials.protohalkonite,
                                Materials2Shapes.plateSuperdense,
                                (int) (4)),
                        MaterialLibAPI.getStack(
                                Materials2Materials.TranscendentMetal,
                                Materials2Shapes.plateDense,
                                (int) (64)) },
                new FluidStack[] {
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Protomatter,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (10000)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SixPhasedCopper,
                                Materials2FluidShapes.fluidMolten,
                                (int) (9216)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.TranscendentMetal,
                                Materials2FluidShapes.fluidMolten,
                                (int) (9216)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.dimensionallyshiftedsuperfluid,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (10000)) },
                ItemRefer.AntimatterForge.get(1),
                6 * MINUTES,
                (int) TierEU.RECIPE_UMV);

        // Antimatter Generator - SLAM
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                ItemList.LargeNaquadahReactor.get(1),
                512000,
                2048,
                8000000,
                64,
                new Object[] { ItemList.WormholeGenerator.get(1),
                        tectech.thing.CustomItemList.eM_dynamoTunnel7_UIV.get(4),
                        ItemRefer.ProtomatterActivationCoil.get(16), new Object[] { Circuits.UIV.getIngredient(), 16L },
                        ItemList.Emitter_UIV.get(32),
                        MaterialLibAPI.getStack(
                                Materials2Materials.protohalkonite,
                                Materials2Shapes.plateSuperdense,
                                (int) (4)),
                        MaterialLibAPI.getStack(Materials2Materials.protohalkonite, Materials2Shapes.rotor, (int) (16)),
                        Superconductors.UIV.getWireGt16(64), MaterialsElements.STANDALONE.HYPOGEN.getFineWire(64),
                        MaterialsElements.STANDALONE.HYPOGEN.getFineWire(64),
                        MaterialsElements.STANDALONE.HYPOGEN.getFineWire(64) },
                new FluidStack[] { MaterialLibAPI
                        .getFluidStack(Materials2Materials.Antimatter, Materials2FluidShapes.fluidLiquid, (int) (1000)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SixPhasedCopper,
                                Materials2FluidShapes.fluidMolten,
                                (int) (9216)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.TranscendentMetal,
                                Materials2FluidShapes.fluidMolten,
                                (int) (9216)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SuperconductorUIVBase,
                                Materials2FluidShapes.fluidMolten,
                                (int) (9216)) },
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
                new Object[] { ItemList.Hatch_Output_UIV.get(1), ItemList.Field_Generator_UEV.get(4), MaterialLibAPI
                        .getStack(Materials2Materials.protohalkonite, Materials2Shapes.plateSuperdense, (int) (1)),
                        ItemList.Electric_Pump_UIV.get(4), ItemList.Electromagnet_Tengam.get(1),
                        MaterialLibAPI
                                .getStack(Materials2Materials.protohalkonite, Materials2Shapes.foil, (int) (32)) },
                new FluidStack[] { MaterialLibAPI
                        .getFluidStack(Materials2Materials.RadoxPoly, Materials2FluidShapes.fluidMolten, (int) (1296)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Protomatter,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (250)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.dimensionallyshiftedsuperfluid,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (1000)) },
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
                        MaterialLibAPI
                                .getStack(Materials2Materials.protohalkonite, Materials2Shapes.stickLong, (int) (4)),
                        MaterialLibAPI.getStack(
                                Materials2Materials.TranscendentMetal,
                                Materials2Shapes.stickLong,
                                (int) (12)),
                        ItemList.Emitter_UIV.get(4), Superconductors.UIV.getWireGt04(16), },
                new FluidStack[] { MaterialLibAPI
                        .getFluidStack(Materials2Materials.RadoxPoly, Materials2FluidShapes.fluidMolten, (int) (16)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.TranscendentMetal,
                                Materials2FluidShapes.fluidMolten,
                                (int) (2304)) },
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
                        MaterialLibAPI.getStack(Materials2Materials.protohalkonite, Materials2Shapes.plate, (int) (4)),
                        MaterialLibAPI.getStack(Materials2Materials.protohalkonite, Materials2Shapes.gearGt, (int) (1)),
                        ItemList.Gravistar.get(4), new Object[] { Circuits.UIV.getIngredient(), 1L },
                        Superconductors.UIV.getWireGt04(16), },
                new FluidStack[] { new FluidStack(FluidRegistry.getFluid("molten.chromaticglass"), 9216),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.dimensionallyshiftedsuperfluid,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (2304)) },
                ItemRefer.GravityStabilizationCasing.get(4),
                60 * SECONDS,
                (int) TierEU.RECIPE_UIV);

        // Magnetic Flux Casing
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                GTOreDictUnificator.get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.protohalkonite), 1),
                128000,
                1024,
                2000000,
                32,
                new Object[] {
                        GTOreDictUnificator
                                .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.protohalkonite), 4),
                        ItemList.Sensor_UIV.get(2), ItemList.Electromagnet_Tengam.get(1),
                        MaterialLibAPI
                                .getStack(Materials2Materials.protohalkonite, Materials2Shapes.plateDense, (int) (1)),
                        new Object[] { Circuits.UIV.getIngredient(), 1L },
                        MaterialLibAPI.getStack(
                                Materials2Materials.TranscendentMetal,
                                Materials2Shapes.itemCasing,
                                (int) (16)),
                        Superconductors.UIV.getWireGt04(16), },
                new FluidStack[] {
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.TengamPurified,
                                Materials2FluidShapes.fluidMolten,
                                (int) (9216)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.TranscendentMetal,
                                Materials2FluidShapes.fluidMolten,
                                (int) (2304)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SuperCoolant,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (10000)) },
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
                        Superconductors.UIV.getWireGt16(8),
                        MaterialLibAPI
                                .getStack(Materials2Materials.Infinity, Materials2Shapes.plateSuperdense, (int) (1)),
                        MaterialLibAPI.getStack(Materials2Materials.protohalkonite, Materials2Shapes.rotor, (int) (4)),
                        new Object[] { Circuits.UIV.getIngredient(), 1L }, ItemList.Field_Generator_UEV.get(4) },
                new FluidStack[] { MaterialLibAPI
                        .getFluidStack(Materials2Materials.Protomatter, Materials2FluidShapes.fluidLiquid, (int) (100)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.TranscendentMetal,
                                Materials2FluidShapes.fluidMolten,
                                (int) (2304)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.dimensionallyshiftedsuperfluid,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (1000)) },
                ItemRefer.ProtomatterActivationCoil.get(4),
                60 * SECONDS,
                (int) TierEU.RECIPE_UIV);

        // Antimatter Annihilation Matrix
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Antimatter, Materials2CellShapes.cell, (int) (1)),
                256000,
                2048,
                8000000,
                32,
                new Object[] { ItemRefer.ProtomatterActivationCoil.get(1),
                        MaterialsElements.STANDALONE.HYPOGEN.getFoil(64), ItemList.Emitter_UIV.get(2),
                        new Object[] { Circuits.UIV.getIngredient(), 1L },
                        GTOreDictUnificator
                                .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.protohalkonite), 4),
                        Superconductors.UIV.getWireGt16(8), ItemList.Sensor_UIV.get(2),
                        MaterialLibAPI
                                .getStack(Materials2Materials.protohalkonite, Materials2Shapes.rotor, (int) (4)), },
                new FluidStack[] { MaterialLibAPI
                        .getFluidStack(Materials2Materials.Antimatter, Materials2FluidShapes.fluidLiquid, (int) (4)),
                        MaterialsElements.STANDALONE.HYPOGEN.getFluidStack(1440),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.dimensionallyshiftedsuperfluid,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (1000)) },
                ItemRefer.AntimatterAnnihilationMatrix.get(4),
                60 * SECONDS,
                (int) TierEU.RECIPE_UIV);

        GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.IndustrialCentrifuge.get(1))
                .metadata(SCANNING, new Scanning(1 * MINUTES, TierEU.RECIPE_EV))
                .itemInputs(
                        ItemList.IndustrialCentrifuge.get(64),
                        ItemList.SCSteamTurbine.get(4),
                        GregtechItemList.Hatch_Turbine_Rotor.get(4),
                        Circuits.UV.get(4),
                        MaterialsAlloy.PIKYONIUM.getRotor(4),
                        MaterialsAlloy.HELICOPTER.getRotor(4),
                        MaterialsAlloy.TRINIUM_REINFORCED_STEEL.getRotor(4),
                        MaterialLibAPI.getStack(Materials2Materials.Netherite, Materials2Shapes.rotor, (int) (4)),
                        ItemList.Electric_Motor_ZPM.get(4),
                        ItemList.Electric_Pump_ZPM.get(4),
                        MaterialsAlloy.PIKYONIUM.getScrew(16),
                        Superconductors.ZPM.getWireGt04(16))
                .fluidInputs(
                        GGMaterial.marCeM200.getMolten(16 * INGOTS),
                        MaterialsAlloy.INDALLOY_140.getFluidStack(10 * INGOTS),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Lubricant,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (4000)))
                .itemOutputs(ItemList.Machine_Multi_Spinmatron.get(1)).eut(TierEU.RECIPE_ZPM).duration(60 * SECONDS)
                .addTo(AssemblyLine);

        // BEC Multi Recipes

        // Nanite Detector Hatch
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                ElectrodeDetectorHatch.get(1),
                24_000_000,
                8_192,
                (int) TierEU.RECIPE_UMV,
                64,
                new Object[] { ItemList.Hull_UIV.get(1), ElectrodeDetectorHatch.get(1), ItemList.Sensor_UIV.get(1),
                        MaterialsElements.STANDALONE.HYPOGEN.getGearSmall(2),
                        GGMaterial.tairitsu.get(OrePrefixes.gearGt, 1),
                        MaterialLibAPI.getStack(Materials2Materials.Churitsu, Materials2Shapes.gearGt, (int) (1)),
                        MaterialLibAPI.getStack(Materials2Materials.Shijima, Materials2Shapes.gearGt, (int) (1)) },
                new FluidStack[] {
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Neutronium,
                                Materials2FluidShapes.fluidMolten,
                                (int) (16 * INGOTS)),
                        MaterialsElements.STANDALONE.CHRONOMATIC_GLASS.getFluidStack(32 * INGOTS),
                        MaterialsElements.STANDALONE.CELESTIAL_TUNGSTEN.getFluidStack(16 * INGOTS),
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(8 * STACKS) },
                CustomItemList.Hatch_BEC_Nanites.get(1),
                30 * SECONDS,
                (int) TierEU.RECIPE_UIV);

        // Bose-Einstein Condensate Hatch
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                LanthItemList.LUV_BEAMLINE_INPUT_HATCH,
                24_000_000,
                8_192,
                (int) TierEU.RECIPE_UMV,
                64,
                new Object[] { ItemList.Hull_UIV.get(1), LanthItemList.LUV_BEAMLINE_INPUT_HATCH,
                        LanthItemList.LUV_BEAMLINE_OUTPUT_HATCH, ItemList.Electric_Pump_UIV.get(2),
                        MaterialsElements.STANDALONE.HYPOGEN.getLongRod(1),
                        GGMaterial.tairitsu.get(OrePrefixes.rotor, 1),
                        MaterialLibAPI.getStack(Materials2Materials.Churitsu, Materials2Shapes.rotor, (int) (1)),
                        MaterialLibAPI.getStack(Materials2Materials.Shijima, Materials2Shapes.rotor, (int) (1)) },
                new FluidStack[] {
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Infinity,
                                Materials2FluidShapes.fluidMolten,
                                (int) (16 * INGOTS)),
                        MaterialsElements.STANDALONE.CHRONOMATIC_GLASS.getFluidStack(32 * INGOTS),
                        MaterialsElements.STANDALONE.CELESTIAL_TUNGSTEN.getFluidStack(16 * INGOTS),
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(8 * STACKS) },
                CustomItemList.Hatch_BEC_Connector.get(1),
                30 * SECONDS,
                (int) TierEU.RECIPE_UIV);

        // Condensate Detector Hatch
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                CustomItemList.Hatch_BEC_Connector.get(1),
                24_000_000,
                8_192,
                (int) TierEU.RECIPE_UMV,
                64,
                new Object[] { ItemList.Hull_UIV.get(1), CustomItemList.Hatch_BEC_Connector.get(1),
                        CustomItemList.Hatch_BEC_Nanites.get(1), GGMaterial.tairitsu.get(OrePrefixes.plate, 3),
                        MaterialLibAPI.getStack(Materials2Materials.Churitsu, Materials2Shapes.plate, (int) (3)),
                        MaterialLibAPI.getStack(Materials2Materials.Shijima, Materials2Shapes.plate, (int) (3)) },
                new FluidStack[] {
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Churitsu,
                                Materials2FluidShapes.fluidMolten,
                                (int) (16 * INGOTS)),
                        MaterialsElements.STANDALONE.CHRONOMATIC_GLASS.getFluidStack(32 * INGOTS),
                        MaterialsElements.STANDALONE.CELESTIAL_TUNGSTEN.getFluidStack(16 * INGOTS),
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(8 * STACKS) },
                CustomItemList.Hatch_BEC_CondensateDetector.get(1),
                30 * SECONDS,
                (int) TierEU.RECIPE_UIV);

        // Teleportation Node Controller Hatch
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                getModItem(Minecraft.ID, "lever", 1, 0),
                24_000_000,
                8_192,
                (int) TierEU.RECIPE_UMV,
                64,
                new Object[] { ItemList.Hull_UIV.get(1),
                        GTModHandler.getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 0),
                        GTModHandler.getModItem(StevesAddons.ID, "cable_rf", 1, 0),
                        GTModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockController", 1, WILDCARD),
                        ItemList.Hatch_DegasifierControl.get(1) },
                new FluidStack[] { MaterialsElements.STANDALONE.CHRONOMATIC_GLASS.getFluidStack(32 * INGOTS),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Infinity,
                                Materials2FluidShapes.fluidMolten,
                                (int) (16 * INGOTS)),
                        MaterialsElements.STANDALONE.CELESTIAL_TUNGSTEN.getFluidStack(16 * INGOTS),
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(8 * STACKS) },
                CustomItemList.Hatch_BEC_IOController.get(1),
                30 * SECONDS,
                (int) TierEU.RECIPE_UIV);

        // Line-of-Sight Connector Hatch
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                getModItem(Minecraft.ID, "beacon", 1, 0),
                24_000_000,
                8_192,
                (int) TierEU.RECIPE_UMV,
                64,
                new Object[] { ItemList.Hull_UIV.get(1), GTModHandler.getModItem(Minecraft.ID, "beacon", 1, 0),
                        ItemList.Casing_Dim_Bridge.get(2), ItemList.Conveyor_Module_UIV.get(1),
                        GGMaterial.tairitsu.get(OrePrefixes.wireFine, 8),
                        MaterialLibAPI.getStack(Materials2Materials.Churitsu, Materials2Shapes.wireFine, (int) (8)),
                        MaterialLibAPI.getStack(Materials2Materials.Shijima, Materials2Shapes.wireFine, (int) (8)) },
                new FluidStack[] { MaterialsElements.STANDALONE.HYPOGEN.getFluidStack(16 * INGOTS),
                        MaterialsElements.STANDALONE.CHRONOMATIC_GLASS.getFluidStack(32 * INGOTS),
                        MaterialsElements.STANDALONE.CELESTIAL_TUNGSTEN.getFluidStack(16 * INGOTS),
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(8 * STACKS) },
                CustomItemList.Hatch_LineOfSight_Connector.get(1),
                30 * SECONDS,
                (int) TierEU.RECIPE_UIV);

        // Condensate Entanglement Apparatus (BEC Generator multi)
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                GregtechItemList.Controller_IndustrialFluidHeater.get(1),
                48_000_000,
                8_192,
                (int) TierEU.RECIPE_UMV,
                64,
                new Object[] { GregtechItemList.Controller_IndustrialFluidHeater.get(1),
                        ItemList.ElectromagneticallyIsolatedCasing.get(4), ItemList.Casing_Coil_Hypogen.get(16),
                        Superconductors.UIV.getWireGt16(16), new Object[] { Circuits.UIV.getIngredient(), 16L },
                        GGMaterial.tairitsu.get(OrePrefixes.plateDense, 8),
                        MaterialLibAPI.getStack(Materials2Materials.Churitsu, Materials2Shapes.plateDense, (int) (8)),
                        MaterialLibAPI.getStack(Materials2Materials.Shijima, Materials2Shapes.plateDense, (int) (8)),
                        ItemList.Emitter_UIV.get(16), ItemList.Electric_Pump_UIV.get(16),
                        GregtechItemList.Laser_Lens_Special.get(16) },
                new FluidStack[] { CHRONOMATIC_GLASS.getFluidStack(1024 * INGOTS),
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(512 * INGOTS),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.ExcitedDTEC,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (1_000_000)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SpaceTime,
                                Materials2FluidShapes.fluidMolten,
                                (int) (32 * INGOTS)) },
                CustomItemList.Machine_Multi_BECGenerator.get(1),
                150 * SECONDS,
                (int) TierEU.RECIPE_UMV);

        // Condensate Containment Field (BEC Storage multi)
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                ItemList.StableEmptyContainmentUnit.get(1),
                48_000_000,
                8_192,
                (int) TierEU.RECIPE_UMV,
                64,
                new Object[] { ItemList.Hull_UIV.get(1), ItemList.FineStructureConstantManipulator.get(4),
                        new ItemStack(kekztech.common.Blocks.tfftStorageField, 8, 9),
                        Superconductors.UIV.getWireGt16(16), new Object[] { Circuits.UIV.getIngredient(), 32L },
                        GGMaterial.tairitsu.get(OrePrefixes.plateDense, 16),
                        MaterialLibAPI.getStack(Materials2Materials.Churitsu, Materials2Shapes.plateDense, (int) (16)),
                        MaterialLibAPI.getStack(Materials2Materials.Shijima, Materials2Shapes.plateDense, (int) (16)),
                        ItemList.StableBaryonContainmentUnit.get(8), ItemList.StableLeptonContainmentUnit.get(8),
                        ItemList.StableMesonContainmentUnit.get(8), ItemList.StableBosonContainmentUnit.get(8) },
                new FluidStack[] { CHRONOMATIC_GLASS.getFluidStack(2048 * INGOTS),
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(1024 * INGOTS),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.ExcitedDTEC,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (2_000_000)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SpaceTime,
                                Materials2FluidShapes.fluidMolten,
                                (int) (64 * INGOTS)) },
                CustomItemList.Machine_Multi_BECStorage.get(1),
                300 * SECONDS,
                (int) TierEU.RECIPE_UMV);

        // Condensate Observation Array (BEC Assembler multi)
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                GGItemList.AdvAssLine.get(1),
                48_000_000,
                8_192,
                (int) TierEU.RECIPE_UMV,
                64,
                new Object[] { GGItemList.AdvAssLine.get(1), ItemList.SuperconductivePlasmaEnergyConduit.get(4),
                        ItemList.Casing_Dim_Bridge.get(16), Superconductors.UIV.getWireGt16(16),
                        new Object[] { Circuits.UIV.getIngredient(), 16L },
                        GGMaterial.tairitsu.get(OrePrefixes.plateDense, 8),
                        MaterialLibAPI.getStack(Materials2Materials.Churitsu, Materials2Shapes.plateDense, (int) (8)),
                        MaterialLibAPI.getStack(Materials2Materials.Shijima, Materials2Shapes.plateDense, (int) (8)),
                        ItemList.Sensor_UIV.get(16), ItemList.Robot_Arm_UIV.get(16),
                        getNHCoreModItem("ChromaticLens", 64),
                        AEApi.instance().definitions().materials().singularity().maybeStack(8).get() },
                new FluidStack[] { CHRONOMATIC_GLASS.getFluidStack(1024 * INGOTS),
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(512 * INGOTS),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.ExcitedDTEC,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (1_000_000)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SpaceTime,
                                Materials2FluidShapes.fluidMolten,
                                (int) (32 * INGOTS)) },
                CustomItemList.Machine_Multi_BECAssembler.get(1),
                150 * SECONDS,
                (int) TierEU.RECIPE_UMV);

        // Observation Array Teleportation Node (BEC IO Node multi)
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                GTModHandler.getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 0),
                48_000_000,
                8_192,
                (int) TierEU.RECIPE_UMV,
                64,
                new Object[] { GTModHandler.getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 0),
                        ItemList.SuperconductivePlasmaEnergyConduit.get(4), ItemList.Casing_Dim_Bridge.get(16),
                        Superconductors.UIV.getWireGt16(16), new Object[] { Circuits.UIV.getIngredient(), 16L },
                        GGMaterial.tairitsu.get(OrePrefixes.plateDense, 8),
                        MaterialLibAPI.getStack(Materials2Materials.Churitsu, Materials2Shapes.plateDense, (int) (8)),
                        MaterialLibAPI.getStack(Materials2Materials.Shijima, Materials2Shapes.plateDense, (int) (8)),
                        ItemList.Emitter_UIV.get(8), ItemList.Conveyor_Module_UIV.get(8),
                        GTModHandler.getModItem(EternalSingularity.ID, "eternal_singularity", 4),
                        AEApi.instance().definitions().materials().singularity().maybeStack(8).get() },
                new FluidStack[] { CHRONOMATIC_GLASS.getFluidStack(1024 * INGOTS),
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(512 * INGOTS),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.ExcitedDTEC,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (1_000_000)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SpaceTime,
                                Materials2FluidShapes.fluidMolten,
                                (int) (32 * INGOTS)) },
                CustomItemList.Machine_Multi_BECIONode.get(1),
                150 * SECONDS,
                (int) TierEU.RECIPE_UMV);

        // Condensate Maxwell Gate (BEC Diode multi)
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 220),
                48_000_000,
                8_192,
                (int) TierEU.RECIPE_UMV,
                64,
                new Object[] { GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 220),
                        ItemList.ElectromagneticallyIsolatedCasing.get(4), ItemList.FluidRegulator_UIV.get(4),
                        Superconductors.UIV.getWireGt16(16), new Object[] { Circuits.UIV.getIngredient(), 8L },
                        GGMaterial.tairitsu.get(OrePrefixes.plateDense, 4),
                        MaterialLibAPI.getStack(Materials2Materials.Churitsu, Materials2Shapes.plateDense, (int) (4)),
                        MaterialLibAPI.getStack(Materials2Materials.Shijima, Materials2Shapes.plateDense, (int) (4)) },
                new FluidStack[] { CHRONOMATIC_GLASS.getFluidStack(512 * INGOTS),
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(256 * INGOTS),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.ExcitedDTEC,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (500_000)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SpaceTime,
                                Materials2FluidShapes.fluidMolten,
                                (int) (16 * INGOTS)) },
                CustomItemList.Machine_Multi_BECDiode.get(1),
                75 * SECONDS,
                (int) TierEU.RECIPE_UMV);

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
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Naquadria,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (1_152L)),
                            MaterialsAlloy.INDALLOY_140.getFluidStack(1152),
                            FluidRegistry.getFluidStack("lubricant", 2000))
                    .itemOutputs(getModItem(AE2FluidCraft.ID, "super_stock_replenisher", 1, 0)).duration(30 * SECONDS)
                    .eut((int) TierEU.RECIPE_UV).addTo(AssemblyLine);
        }
    }

    public void runLate() {

        Fluid solderUEV = FluidRegistry.getFluid("molten.mutatedlivingsolder") != null
                ? FluidRegistry.getFluid("molten.mutatedlivingsolder")
                : FluidRegistry.getFluid("molten.solderingalloy");

        if (EternalSingularity.isModLoaded()) {

            // 2.7.0 gate -- Heavenly Fire
            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    ItemList.Circuit_OpticalMainframe.get(1L),
                    384000,
                    1024,
                    4000000,
                    64,
                    new Object[] { ItemList.Circuit_Board_Optical.get(1L), NHItemList.PicoWafer.get(4),
                            new Object[] { Circuits.UIV.getIngredient(), 2L },
                            ItemList.Circuit_Parts_TransistorXSMD.get(48L),
                            ItemList.Circuit_Parts_ResistorXSMD.get(48L), ItemList.Circuit_Parts_CapacitorXSMD.get(48L),
                            ItemList.Circuit_Parts_DiodeXSMD.get(48L), ItemList.Circuit_Chip_PPIC.get(64L),
                            GTOreDictUnificator.get("foilRadoxPoly", 16L),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.TranscendentMetal, Materials2Shapes.bolt, (int) (32)),
                            MaterialLibAPI.getStack(Materials2Materials.Neutronium, Materials2Shapes.bolt, (int) (16)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Lanthanum, Materials2Shapes.wireFine, (int) (64)) },
                    new FluidStack[] { new FluidStack(solderUEV, 3744),
                            MU.materialOf(Materials2Materials.UUMatter).getFluid(8000L),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Osmium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (1152L)) },
                    NHItemList.PikoCircuitHeavenly.get(1),
                    10000,
                    (int) TierEU.RECIPE_UMV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.PikoCircuitHeavenly.get(),
                    720000,
                    2048,
                    (int) TierEU.RECIPE_UEV,
                    128,
                    new ItemStack[] {
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Neutronium), 16),
                            NHItemList.PikoCircuitHeavenly.get(2), ItemList.Circuit_Parts_CapacitorXSMD.get(64L),
                            ItemList.Circuit_Parts_DiodeXSMD.get(64L), ItemList.Circuit_Parts_TransistorXSMD.get(64L),
                            ItemList.Circuit_Parts_ResistorXSMD.get(64L), ItemList.Circuit_Chip_QPIC.get(64L),
                            GTOreDictUnificator.get("foilShirabon", 64),
                            MaterialLibAPI.getStack(Materials2Materials.Indium, Materials2Shapes.bolt, (int) (64)),
                            GTOreDictUnificator
                                    .get(OrePrefixes.wireGt01, MU.materialOf(Materials2Materials.SpaceTime), 8),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Lanthanum, Materials2Shapes.wireFine, (int) (16)) },
                    new FluidStack[] { new FluidStack(solderUEV, 3744),
                            MU.materialOf(Materials2Materials.UUMatter).getFluid(24000L),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Osmium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (2304L)) },
                    NHItemList.QuantumCircuitHeavenly.get(1),
                    20000,
                    (int) TierEU.RECIPE_UMV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.GatePlateHarmonic.get(),
                    (int) TierEU.RECIPE_MAX,
                    32768,
                    (int) TierEU.RECIPE_UXV,
                    64,
                    new Object[] { CustomItemList.Godforge_MagneticConfinementCasing.get(64),
                            CustomItemList.StabilisationFieldGeneratorTier8.get(64),
                            CustomItemList.Godforge_HarmonicPhononTransmissionConduit.get(32),
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.Magmatter), 64L),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.Magmatter,
                                    Materials2Shapes.plateSuperdense,
                                    (int) (8L)),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.Universium,
                                    Materials2Shapes.plateSuperdense,
                                    (int) (8L)),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.Eternity,
                                    Materials2Shapes.plateSuperdense,
                                    (int) (8L)),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.SpaceTime,
                                    Materials2Shapes.plateSuperdense,
                                    (int) (8L)),
                            NHItemList.QuantumCircuitHeavenly.get(16), ItemList.Sensor_UXV.get(16L),
                            ItemList.Emitter_UXV.get(16L),
                            GTModHandler.getModItem(EternalSingularity.ID, "combined_singularity", 64, 15),
                            GTOreDictUnificator
                                    .get(OrePrefixes.nanite, MU.materialOf(Materials2Materials.Universium), 16),
                            GTOreDictUnificator
                                    .get(OrePrefixes.nanite, MU.materialOf(Materials2Materials.BlackDwarfMatter), 16),
                            GTOreDictUnificator
                                    .get(OrePrefixes.nanite, MU.materialOf(Materials2Materials.WhiteDwarfMatter), 16),
                            GTOreDictUnificator
                                    .get(OrePrefixes.nanite, MU.materialOf(Materials2Materials.SixPhasedCopper), 16) },
                    new FluidStack[] {
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.QuarkGluonPlasma,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (1_024_000)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.PhononMedium,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (256_000)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.SuperconductorUMVBase,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (64 * STACKS)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.ExcitedDTSC,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (512_000)) },
                    NHItemList.GatePlateHeavenly.get(),
                    125_000 * SECONDS,
                    (int) TierEU.RECIPE_UXV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.ChevronHarmonic.get(),
                    (int) TierEU.RECIPE_MAX,
                    32768,
                    (int) TierEU.RECIPE_UXV,
                    64,
                    new Object[] { CustomItemList.EOH_Reinforced_Spatial_Casing.get(64),
                            CustomItemList.EOH_Reinforced_Temporal_Casing.get(64),
                            new ItemStack(BlockGodforgeGlass.INSTANCE, 64),
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.Magmatter), 64L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Magmatter), 16L),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.Magmatter,
                                    Materials2Shapes.plateSuperdense,
                                    (int) (8L)),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.MagnetohydrodynamicallyConstrainedStarMatter,
                                    Materials2Shapes.plateSuperdense,
                                    (int) (8L)),
                            GTOreDictUnificator.get(
                                    OrePrefixes.frameGt,
                                    MU.materialOf(Materials2Materials.MagnetohydrodynamicallyConstrainedStarMatter),
                                    16L),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Ruby, Materials2Shapes.gemExquisite, (int) (64L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Jasper, Materials2Shapes.gemExquisite, (int) (64L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Opal, Materials2Shapes.gemExquisite, (int) (64L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Sapphire, Materials2Shapes.gemExquisite, (int) (64L)),
                            ItemList.Electric_Motor_UXV.get(64L), ItemList.Electric_Piston_UXV.get(64L),
                            ItemList.Field_Generator_UXV.get(16L), NHItemList.QuantumCircuitHeavenly.get(32) },
                    new FluidStack[] {
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.QuarkGluonPlasma,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (1_024_000L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.PhononMedium,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (256_000L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Magmatter,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (128 * STACKS)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.ExcitedDTSC,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (512_000L)) },
                    NHItemList.ChevronHeavenly.get(),
                    125_000 * SECONDS,
                    (int) TierEU.RECIPE_UXV);

            TTRecipeAdder.addResearchableAssemblylineRecipe(
                    NHItemList.FramePartHarmonic.get(),
                    (int) TierEU.RECIPE_MAX,
                    32_768,
                    (int) TierEU.RECIPE_UXV,
                    64,
                    new ItemStack[] {
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Infinity, Materials2Shapes.stickLong, (int) (64L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Mellion, Materials2Shapes.stickLong, (int) (64L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Universium, Materials2Shapes.stickLong, (int) (64L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Eternity, Materials2Shapes.stickLong, (int) (64L)),
                            MaterialLibAPI.getStack(Materials2Materials.Creon, Materials2Shapes.stickLong, (int) (64L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.SpaceTime, Materials2Shapes.stickLong, (int) (64L)),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.SuperconductorUMVBase,
                                    Materials2Shapes.stickLong,
                                    (int) (64L)),
                            GGMaterial.shirabon.get(OrePrefixes.stickLong, 64), HYPOGEN.getLongRod(64),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.SixPhasedCopper,
                                    Materials2Shapes.stickLong,
                                    (int) (64L)),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.MagnetohydrodynamicallyConstrainedStarMatter,
                                    Materials2Shapes.stickLong,
                                    (int) (64L)),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.protohalkonite,
                                    Materials2Shapes.stickLong,
                                    (int) (64L)),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.WhiteDwarfMatter,
                                    Materials2Shapes.stickLong,
                                    (int) (64L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Magmatter, Materials2Shapes.stickLong, (int) (64L)),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.BlackDwarfMatter,
                                    Materials2Shapes.stickLong,
                                    (int) (64L)),
                            MaterialLibAPI.getStack(
                                    Materials2Materials.TranscendentMetal,
                                    Materials2Shapes.stickLong,
                                    (int) (64L)) },
                    new FluidStack[] {
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.QuarkGluonPlasma,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (1_024_000L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.PhononMedium,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (256_000L)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Universium,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (16 * STACKS)),
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.ExcitedDTSC,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (512_000L)) },
                    NHItemList.FramePartHeavenly.get(),
                    125_000 * SECONDS,
                    (int) TierEU.RECIPE_UXV);
        }
    }
}
