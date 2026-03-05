package com.dreammaster.scripts;

import static goodgenerator.api.recipe.GoodGeneratorRecipeMaps.preciseAssemblerRecipes;
import static gregtech.api.enums.Mods.AE2FluidCraft;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.UniversalSingularities;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.formingPressRecipes;
import static gregtech.api.recipe.RecipeMaps.laserEngraverRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.INGOTS;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gregtech.api.util.GTRecipeConstants.PRECISE_ASSEMBLER_CASING_TIER;
import static gtnhintergalactic.recipe.IGRecipeMaps.spaceAssemblerRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.item.NHItemList;

import bartworks.common.loaders.ItemRegistry;
import bartworks.system.material.WerkstoffLoader;
import ggfab.GGItemList;
import goodgenerator.items.GGMaterial;
import goodgenerator.util.ItemRefer;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.VoltageIndex;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMaps;
import gregtech.api.recipe.metadata.BoardProcessingModuleFluidKey;
import gregtech.api.recipe.metadata.NanochipAssemblyMatrixTierKey;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTRecipeConstants;
import gregtech.api.util.GTUtility;
import gregtech.common.tileentities.machines.multi.nanochip.util.CircuitComponent;
import gregtech.common.tileentities.machines.multi.nanochip.util.CircuitComponent.CircuitComponentStack;
import gregtech.common.tileentities.machines.multi.nanochip.util.ModuleRecipeInfo;
import gtPlusPlus.core.material.MaterialMisc;
import gtPlusPlus.core.material.MaterialsAlloy;
import gtPlusPlus.core.material.MaterialsElements;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;
import gtnhintergalactic.recipe.IGRecipeMaps;
import gtnhlanth.common.register.LanthItemList;
import gtnhlanth.common.register.WerkstoffMaterialPool;
import tectech.recipe.TTRecipeAdder;
import tectech.thing.CustomItemList;

public class ScriptNanochipRecipes implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Nanochip Assembly Complex";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(AE2FluidCraft.ID, AppliedEnergistics2.ID, OpenComputers.ID, UniversalSingularities.ID);
    }

    @Override
    public void loadRecipes() {
        registerConversionRecipes();

        registerBiologicalCoordinatorRecipes();
        registerBoardProcessorRecipes();
        registerCuttingChamberRecipes();
        registerEncasementWrapperRecipes();
        registerEtchingArrayRecipes();
        registerOpticalOrganizerRecipes();
        registerSMDProcessorRecipes();
        registerSuperconductorSplitterRecipes();
        registerWireTracerRecipes();

        registerAssemblyMatrixRecipes();

        // Nanochip Firewall Projection Casing
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                ItemList.ReinforcementNanochipCasing.get(1),
                16777216,
                4096,
                (int) TierEU.RECIPE_UHV,
                4,
                new Object[] { ItemList.ReinforcementNanochipCasing.get(1), ItemList.MobRep_UV.get(4),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.SuperconductorUHVBase, 2),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.TengamAttuned, 8),
                        ItemList.Emitter_UEV.get(2), ItemList.Sensor_UEV.get(2),
                        getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 24), // Nether Star
                                                                                                       // Singularity
                        ItemList.Field_Generator_UHV.get(1) },
                new FluidStack[] { MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(128 * INGOTS),
                        WerkstoffLoader.Oganesson.getFluidOrGas(16000),
                        Materials.SuperconductorUEVBase.getMolten(16 * INGOTS),
                        Materials.RadoxPolymer.getMolten(4 * INGOTS) },
                ItemList.FirewallProjectionNanochipCasing.get(1),
                120 * SECONDS,
                (int) TierEU.RECIPE_UEV);

        // Nanochip Computational Matrix Casing
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                ItemList.MeshInterfaceNanochipCasing.get(1),
                16777216,
                4096,
                (int) TierEU.RECIPE_UHV,
                4,
                new Object[] { ItemList.MeshInterfaceNanochipCasing.get(4), CustomItemList.rack_Hatch.get(1),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 60), // 16384k Item Component
                        getModItem(AE2FluidCraft.ID, "fluid_part", 1, 7), // 16384k Fluid Component
                        getModItem(OpenComputers.ID, "item", 1, 69), // Server Tier 4
                        ItemList.Optically_Perfected_CPU.get(2), ItemList.Optically_Compatible_Memory.get(2),
                        CustomItemList.DATApipe.get(16) },
                new FluidStack[] { MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(16 * INGOTS),
                        Materials.Xenoxene.getFluid(16 * INGOTS), Materials.TengamPurified.getMolten(16 * INGOTS), },
                ItemList.ComputationalMatrixNanochipCasing.get(4),
                60 * SECONDS,
                (int) TierEU.RECIPE_UHV);

        // Nanochip Complex Glass
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(ItemRegistry.bw_realglas, 8, 14),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.RoseGold, 64),
                        GregtechItemList.Laser_Lens_Special.get(0))
                .fluidInputs(WerkstoffMaterialPool.FluoroformOxygenMix.getFluidOrGas(2000))
                .itemOutputs(ItemList.ComplexNanochipGlass.get(8)).duration(15 * SECONDS).eut(TierEU.RECIPE_UHV)
                .addTo(laserEngraverRecipes);

        // Nanochip Reinforcement Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Bedrockium, 8),
                        MaterialsElements.STANDALONE.CELESTIAL_TUNGSTEN.getFoil(48),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Naquadah, 4))
                .fluidInputs(Materials.Neutronium.getMolten(8 * INGOTS))
                .itemOutputs(ItemList.ReinforcementNanochipCasing.get(8)).duration(7 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_UHV).addTo(formingPressRecipes);

        // Nanochip Mesh Interface Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Iridium, 8),
                        WerkstoffLoader.LuVTierMaterial.get(OrePrefixes.foil, 48),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Adamantium, 4),
                        ItemList.VacuumConveyorPipe.get(8))
                .fluidInputs(
                        Materials.BlackPlutonium.getMolten(8 * INGOTS),
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(8 * INGOTS))
                .itemOutputs(ItemList.MeshInterfaceNanochipCasing.get(8)).duration(7 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_UHV).metadata(PRECISE_ASSEMBLER_CASING_TIER, 3).addTo(preciseAssemblerRecipes);

        // Vacuum Conveyor Input
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.MeshInterfaceNanochipCasing.get(1),
                        ItemList.Hatch_Input_Bus_MAX.get(1),
                        ItemList.Conveyor_Module_UEV.get(1),
                        ItemList.VacuumConveyorPipe.get(8))
                .fluidInputs(MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(4 * INGOTS))
                .itemOutputs(ItemList.Hatch_VacuumConveyor_Input.get(1)).duration(15 * SECONDS).eut(TierEU.RECIPE_UEV)
                .addTo(assemblerRecipes);

        // Vacuum Conveyor Output
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.MeshInterfaceNanochipCasing.get(1),
                        ItemList.Hatch_Output_Bus_MAX.get(1),
                        ItemList.Conveyor_Module_UEV.get(1),
                        ItemList.VacuumConveyorPipe.get(8))
                .fluidInputs(MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(4 * INGOTS))
                .itemOutputs(ItemList.Hatch_VacuumConveyor_Output.get(1)).duration(15 * SECONDS).eut(TierEU.RECIPE_UEV)
                .addTo(assemblerRecipes);

        // Vacuum Conveyor Pipe
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeSmall, Materials.BlackPlutonium, 1),
                        MaterialsElements.STANDALONE.CHRONOMATIC_GLASS.getFoil(4))
                .fluidInputs(Materials.Kevlar.getMolten(1 * INGOTS)).itemOutputs(ItemList.VacuumConveyorPipe.get(1))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_UHV).addTo(assemblerRecipes);

        // Splitter Redstone Hatch
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_UEV.get(1),
                        ItemList.Cover_AdvancedRedstoneReceiver.get(1),
                        ItemList.Sensor_UHV.get(1),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.RedstoneAlloy, 4))
                .fluidInputs(Materials.Redstone.getMolten(64 * INGOTS))
                .itemOutputs(ItemList.Hatch_Splitter_Level.get(1)).duration(15 * SECONDS).eut(TierEU.RECIPE_UHV)
                .addTo(assemblerRecipes);

        // Nanochip Assembly Complex
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                ItemList.Optically_Perfected_CPU.get(1),
                16777216,
                4096,
                (int) TierEU.RECIPE_UHV,
                4,
                new Object[] { GTUtility.copyAmount(64, ItemRegistry.cal), CustomItemList.Machine_Multi_Computer.get(8),
                        CustomItemList.Machine_Multi_Research.get(8), CustomItemList.Machine_Multi_DataBank.get(8),
                        ItemList.MeshInterfaceNanochipCasing.get(16), ItemList.ReinforcementNanochipCasing.get(16),
                        ItemList.ComputationalMatrixNanochipCasing.get(8),
                        ItemList.FirewallProjectionNanochipCasing.get(4),
                        new Object[] { OrePrefixes.circuit.get(Materials.UEV), 8 },
                        new Object[] { OrePrefixes.circuit.get(Materials.UHV), 16 },
                        new Object[] { OrePrefixes.circuit.get(Materials.UV), 32 }, ItemList.ZPM2.get(1),
                        ItemList.Sensor_UEV.get(4), ItemList.Emitter_UEV.get(4),
                        getModItem(OpenComputers.ID, "screen3", 1, 0), getModItem(OpenComputers.ID, "keyboard", 1, 0) },
                new FluidStack[] { MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(256 * INGOTS),
                        new FluidStack(MaterialsElements.STANDALONE.CELESTIAL_TUNGSTEN.getPlasma(), 64 * INGOTS),
                        Materials.Americium.getPlasma(64 * INGOTS),
                        new FluidStack(MaterialsElements.STANDALONE.ASTRAL_TITANIUM.getPlasma(), 64 * INGOTS) },
                ItemList.Machine_Multi_NanochipAssemblyComplex.get(1),
                120 * SECONDS,
                (int) TierEU.RECIPE_UIV);

        // Assembly Matrix
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.MeshInterfaceNanochipCasing.get(1),
                        new Object[] { OrePrefixes.circuit.get(Materials.UEV), 4 },
                        ItemList.VacuumConveyorPipe.get(16),
                        ItemList.Robot_Arm_UEV.get(1),
                        ItemList.SpaceElevatorModuleAssemblerT1.get(1),
                        ItemRefer.Precise_Assembler.get(1),
                        GGItemList.AdvAssLine.get(1),
                        GTUtility.copyAmount(1, ItemRegistry.cal),
                        ItemRefer.Compassline_Casing_UEV.get(4),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.SuperconductorUHVBase, 32),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Infinity, 4),
                        GTOreDictUnificator.get(OrePrefixes.nanite, Materials.Silver, 1))
                .fluidInputs(
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(32 * INGOTS),
                        Materials.NaquadahAlloy.getMolten(32 * INGOTS),
                        Materials.Infinity.getMolten(32 * INGOTS))
                .itemOutputs(ItemList.NanoChipModule_AssemblyMatrix.get(1)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_UHV).metadata(IGRecipeMaps.MODULE_TIER, 1).addTo(spaceAssemblerRecipes);

        // Etching Array
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.MeshInterfaceNanochipCasing.get(1),
                        new Object[] { OrePrefixes.circuit.get(Materials.UEV), 4 },
                        ItemList.VacuumConveyorPipe.get(16),
                        ItemList.Sensor_UEV.get(1),
                        GTUtility.copyAmount(1, LanthItemList.TARGET_CHAMBER),
                        ItemList.Machine_Multi_Autoclave.get(1),
                        ItemList.Circuit_Parts_Crystal_Chip_Wetware.get(16),
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(16))
                .fluidInputs(
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(32 * INGOTS),
                        Materials.EnrichedHolmium.getMolten(32 * INGOTS))
                .itemOutputs(ItemList.NanoChipModule_EtchingArray.get(1)).duration(60 * SECONDS).eut(TierEU.RECIPE_UHV)
                .metadata(IGRecipeMaps.MODULE_TIER, 1).addTo(spaceAssemblerRecipes);

        // SMD Processor
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.MeshInterfaceNanochipCasing.get(1),
                        new Object[] { OrePrefixes.circuit.get(Materials.UEV), 4 },
                        ItemList.VacuumConveyorPipe.get(16),
                        ItemList.Conveyor_Module_UEV.get(1),
                        ItemRefer.Precise_Assembler.get(1),
                        GregtechItemList.GT4_Multi_Crafter.get(1),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Polyethylene, 64),
                        ItemList.Circuit_Parts_InductorXSMD.get(64))
                .fluidInputs(
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(32 * INGOTS),
                        Materials.RadoxPolymer.getMolten(32 * INGOTS))
                .itemOutputs(ItemList.NanoChipModule_SMDProcessor.get(1)).duration(60 * SECONDS).eut(TierEU.RECIPE_UHV)
                .metadata(IGRecipeMaps.MODULE_TIER, 1).addTo(spaceAssemblerRecipes);

        // Board Processor
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.MeshInterfaceNanochipCasing.get(1),
                        new Object[] { OrePrefixes.circuit.get(Materials.UEV), 4 },
                        ItemList.VacuumConveyorPipe.get(16),
                        ItemList.FluidRegulator_UEV.get(1),
                        ItemList.PCBFactory.get(1),
                        GregtechItemList.Industrial_WashPlant.get(1),
                        ItemList.Circuit_Board_Bio_Ultra.get(16),
                        ItemList.Circuit_Board_Wetware_Extreme.get(16))
                .fluidInputs(
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(32 * INGOTS),
                        MaterialsAlloy.OCTIRON.getFluidStack(32 * INGOTS))
                .itemOutputs(ItemList.NanoChipModule_BoardProcessor.get(1)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_UHV).metadata(IGRecipeMaps.MODULE_TIER, 1).addTo(spaceAssemblerRecipes);

        // Biological Coordinator
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.MeshInterfaceNanochipCasing.get(1),
                        new Object[] { OrePrefixes.circuit.get(Materials.UEV), 4 },
                        ItemList.VacuumConveyorPipe.get(16),
                        ItemList.Electric_Pump_UEV.get(1),
                        ItemList.PCBBioChamber.get(1),
                        GTUtility.copyAmount(1, ItemRegistry.vat),
                        ItemList.Circuit_Chip_BioCPU.get(16),
                        ItemList.Circuit_Chip_NeuroCPU.get(16))
                .fluidInputs(
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(32 * INGOTS),
                        Materials.Tritanium.getMolten(32 * INGOTS))
                .itemOutputs(ItemList.NanoChipModule_BiologicalCoordinator.get(1)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_UHV).metadata(IGRecipeMaps.MODULE_TIER, 1).addTo(spaceAssemblerRecipes);

        // Cutting Chamber
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.MeshInterfaceNanochipCasing.get(1),
                        new Object[] { OrePrefixes.circuit.get(Materials.UEV), 4 },
                        ItemList.VacuumConveyorPipe.get(16),
                        ItemList.Robot_Arm_UEV.get(1),
                        ItemList.Machine_Multi_IndustrialLaserEngraver.get(1),
                        GregtechItemList.Industrial_CuttingFactoryController.get(1),
                        GTOreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1),
                        NHItemList.ChromaticLens.get(1))
                .fluidInputs(
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(32 * INGOTS),
                        Materials.Neutronium.getMolten(32 * INGOTS))
                .itemOutputs(ItemList.NanoChipModule_CuttingChamber.get(1)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_UHV).metadata(IGRecipeMaps.MODULE_TIER, 1).addTo(spaceAssemblerRecipes);

        // Wire Tracer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.MeshInterfaceNanochipCasing.get(1),
                        new Object[] { OrePrefixes.circuit.get(Materials.UEV), 4 },
                        ItemList.VacuumConveyorPipe.get(16),
                        ItemList.Electric_Motor_UEV.get(1),
                        ItemList.IndustrialWireFactory.get(1),
                        GregtechItemList.Industrial_PlatePress.get(1), // forming press specifically
                        GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.Draconium, 16),
                        GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.BlackPlutonium, 16))
                .fluidInputs(
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(32 * INGOTS),
                        Materials.SuperconductorUHVBase.getMolten(32 * INGOTS))
                .itemOutputs(ItemList.NanoChipModule_WireTracer.get(1)).duration(60 * SECONDS).eut(TierEU.RECIPE_UHV)
                .metadata(IGRecipeMaps.MODULE_TIER, 1).addTo(spaceAssemblerRecipes);

        // Splitter
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.MeshInterfaceNanochipCasing.get(1),
                        new Object[] { OrePrefixes.circuit.get(Materials.UEV), 4 },
                        ItemList.VacuumConveyorPipe.get(16),
                        ItemList.Robot_Arm_UEV.get(1),
                        ItemList.Hatch_VacuumConveyor_Input.get(1),
                        ItemList.Hatch_VacuumConveyor_Output.get(1),
                        ItemList.Automation_ItemDistributor_MAX.get(1),
                        ItemList.Sensor_UEV.get(1))
                .fluidInputs(
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(32 * INGOTS),
                        Materials.Kevlar.getMolten(32 * INGOTS))
                .itemOutputs(ItemList.NanoChipModule_Splitter.get(1)).duration(60 * SECONDS).eut(TierEU.RECIPE_UHV)
                .metadata(IGRecipeMaps.MODULE_TIER, 1).addTo(spaceAssemblerRecipes);

        // Superconductor Splitter
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.MeshInterfaceNanochipCasing.get(1),
                        new Object[] { OrePrefixes.circuit.get(Materials.UEV), 4 },
                        ItemList.VacuumConveyorPipe.get(16),
                        ItemList.Emitter_UEV.get(1),
                        ItemList.Machine_Multi_IndustrialElectromagneticSeparator.get(1),
                        GregtechItemList.Industrial_Cryogenic_Freezer.get(1),
                        ItemList.Electromagnet_Tengam.get(1),
                        ItemList.Reactor_Coolant_Sp_6.get(1))
                .fluidInputs(
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(32 * INGOTS),
                        Materials.Naquadria.getMolten(32 * INGOTS))
                .itemOutputs(ItemList.NanoChipModule_SuperconductorSplitter.get(1)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_UHV).metadata(IGRecipeMaps.MODULE_TIER, 1).addTo(spaceAssemblerRecipes);

        // Optical Organizer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.MeshInterfaceNanochipCasing.get(1),
                        new Object[] { OrePrefixes.circuit.get(Materials.UEV), 4 },
                        ItemList.VacuumConveyorPipe.get(16),
                        ItemList.Electric_Pump_UEV.get(1),
                        ItemList.SpaceElevatorModuleAssemblerT1.get(1),
                        ItemList.Machine_Multi_PurificationPlant.get(1),
                        ItemList.Optically_Perfected_CPU.get(16),
                        ItemList.Optically_Compatible_Memory.get(16))
                .fluidInputs(
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(32 * INGOTS),
                        Materials.DraconiumAwakened.getMolten(32 * INGOTS))
                .itemOutputs(ItemList.NanoChipModule_OpticalOrganizer.get(1)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_UHV).metadata(IGRecipeMaps.MODULE_TIER, 1).addTo(spaceAssemblerRecipes);

        // Encasement Wrapper
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.MeshInterfaceNanochipCasing.get(1),
                        new Object[] { OrePrefixes.circuit.get(Materials.UEV), 4 },
                        ItemList.VacuumConveyorPipe.get(16),
                        ItemList.Electric_Piston_UEV.get(1),
                        ItemList.IndustrialPackager.get(1),
                        ItemList.LATEX.get(1),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Tritanium, 16),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Polybenzimidazole, 64))
                .fluidInputs(
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(32 * INGOTS),
                        Materials.Quantium.getMolten(32 * INGOTS))
                .itemOutputs(ItemList.NanoChipModule_EncasementWrapper.get(1)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_UHV).metadata(IGRecipeMaps.MODULE_TIER, 1).addTo(spaceAssemblerRecipes);
    }

    // Adds a simple processing recipe for circuit components in a module
    private static void addSimpleProcessingRecipe(CircuitComponent input, CircuitComponent output,
            ModuleRecipeInfo info, int duration, RecipeMap<?> recipeMap) {
        GTValues.RA.stdBuilder().itemInputs(input.getFakeStack(1)).itemOutputs(output.getFakeStack(1))
                .duration(duration).eut(info.recipeEUt).addTo(recipeMap);
    }

    // Adds a simple processing recipe with a fluid for circuit components in a module
    private static void addSimpleProcessingRecipe(CircuitComponent input, FluidStack inputStack,
            CircuitComponent output, ModuleRecipeInfo info, long duration, RecipeMap<?> recipeMap) {
        GTValues.RA.stdBuilder().itemInputs(input.getFakeStack(1)).fluidInputs(inputStack)
                .itemOutputs(output.getFakeStack(1)).duration(duration).eut(info.recipeEUt).addTo(recipeMap);
    }

    private static void addAssemblyMatrixRecipe(List<Object> input, List<FluidStack> fluidInputs,
            CircuitComponent output, int duration, long eut, int recipeTier) {
        if (output.realComponent == null) {
            throw new IllegalArgumentException("No real circuit was defined for given output!");
        }

        ItemStack realOutput = output.realComponent.get();
        realOutput.stackSize = 1;

        Object[] inputs = new Object[input.size()];
        for (int i = 0; i < input.size(); i++) {
            Object inputThing = input.get(i);
            if (inputThing instanceof CircuitComponentStack ccStack) {
                inputs[i] = ccStack.getCircuitComponent().getFakeStack(ccStack.getSize());
            } else if (inputThing instanceof Object[]alts) {
                inputs[i] = Arrays.stream(alts).map(c -> {
                    if (c instanceof CircuitComponentStack ccStack) {
                        return ccStack.getCircuitComponent().getFakeStack(ccStack.getSize());
                    } else if (c instanceof ItemStack stack) {
                        return stack;
                    }
                    throw new IllegalArgumentException("Must pass a CircuitComponentStack or ItemStack array!");
                }).toArray(ItemStack[]::new);
            }
        }

        GTValues.RA.stdBuilder().metadata(NanochipAssemblyMatrixTierKey.INSTANCE, recipeTier)
                .metadata(GTRecipeConstants.CIRCUIT_CALIBRATION_TYPE, output.circuitType).itemInputs(inputs)
                .fluidInputs(fluidInputs.toArray(new FluidStack[0])).itemOutputs(output.getFakeStack(1))
                .duration(duration).eut(eut).addTo(RecipeMaps.nanochipAssemblyMatrixRecipes);
    }

    private static void registerConversionRecipes() {
        for (CircuitComponent cc : CircuitComponent.VALUES) {
            if (cc.isProcessed) continue;
            if (cc.realComponent == null) throw new IllegalStateException("CC must define its representative item!");

            GTValues.RA.stdBuilder().itemInputs(cc.realComponent.get()).itemOutputs(cc.getFakeStack(1))
                    .duration(5 * SECONDS).eut(0).addTo(RecipeMaps.nanochipConversionRecipes);
        }
    }

    private static void registerBiologicalCoordinatorRecipes() {
        // Neuro Processing Unit
        addSimpleProcessingRecipe(
                CircuitComponent.NeuroProcessingUnit,
                Materials.GrowthMediumSterilized.getFluid(50),
                CircuitComponent.ProcessedNeuroProcessingUnit,
                ModuleRecipeInfo.HighTier,
                20 * SECONDS,
                RecipeMaps.nanochipBiologicalCoordinator);

        // Living Crystal Chip
        addSimpleProcessingRecipe(
                CircuitComponent.ChipLivingCrystal,
                Materials.BioMediumSterilized.getFluid(5),
                CircuitComponent.ProcessedChipLivingCrystal,
                ModuleRecipeInfo.ExtremeTier,
                20 * SECONDS,
                RecipeMaps.nanochipBiologicalCoordinator);

        // Bio Processing Unit
        addSimpleProcessingRecipe(
                CircuitComponent.BioProcessingUnit,
                Materials.BioMediumSterilized.getFluid(50),
                CircuitComponent.ProcessedBioProcessingUnit,
                ModuleRecipeInfo.HighTier,
                30 * SECONDS,
                RecipeMaps.nanochipBiologicalCoordinator);

        // Living Bio Chip
        addSimpleProcessingRecipe(
                CircuitComponent.LivingBioChip,
                Materials.BioMediumSterilized.getFluid(50),
                CircuitComponent.ProcessedLivingBioChip,
                ModuleRecipeInfo.ExtremeTier,
                30 * SECONDS,
                RecipeMaps.nanochipBiologicalCoordinator);
    }

    private static void registerBoardProcessorRecipes() {
        // Elite Board
        GTValues.RA.stdBuilder().hidden().metadata(BoardProcessingModuleFluidKey.INSTANCE, 1)
                .itemInputs(CircuitComponent.BoardMultifiberglassElite.getFakeStack(1))
                .itemOutputs(CircuitComponent.ProcessedBoardMultifiberglassElite.getFakeStack(1)).duration(5 * SECONDS)
                .eut(ModuleRecipeInfo.HighTier.recipeEUt).addTo(RecipeMaps.nanochipBoardProcessorRecipes);

        // Elite Board fake recipe
        GTValues.RA.stdBuilder().fake().itemInputs(CircuitComponent.BoardMultifiberglassElite.getFakeStack(1))
                .fluidInputs(Materials.IronIIIChloride.getFluid(0)).fluidOutputs(Materials.IronIIIChloride.getFluid(0))
                .itemOutputs(CircuitComponent.ProcessedBoardMultifiberglassElite.getFakeStack(1)).duration(5 * SECONDS)
                .eut(ModuleRecipeInfo.HighTier.recipeEUt).addTo(RecipeMaps.nanochipBoardProcessorRecipes);

        // Wetware Board
        GTValues.RA.stdBuilder().hidden().metadata(BoardProcessingModuleFluidKey.INSTANCE, 2)
                .itemInputs(CircuitComponent.BoardWetwareLifesupport.getFakeStack(1))
                .itemOutputs(CircuitComponent.ProcessedBoardWetwareLifesupport.getFakeStack(1)).duration(10 * SECONDS)
                .eut(ModuleRecipeInfo.HighTier.recipeEUt).addTo(RecipeMaps.nanochipBoardProcessorRecipes);

        // Wetware Board fake recipe
        GTValues.RA.stdBuilder().fake().itemInputs(CircuitComponent.BoardWetwareLifesupport.getFakeStack(1))
                .fluidInputs(Materials.GrowthMediumSterilized.getFluid(0))
                .fluidOutputs(Materials.GrowthMediumRaw.getFluid(0))
                .itemOutputs(CircuitComponent.ProcessedBoardWetwareLifesupport.getFakeStack(1)).duration(10 * SECONDS)
                .eut(ModuleRecipeInfo.HighTier.recipeEUt).addTo(RecipeMaps.nanochipBoardProcessorRecipes);

        // Bio Board
        GTValues.RA.stdBuilder().hidden().metadata(BoardProcessingModuleFluidKey.INSTANCE, 3)
                .itemInputs(CircuitComponent.BoardBioMutated.getFakeStack(1))
                .itemOutputs(CircuitComponent.ProcessedBoardBioMutated.getFakeStack(1)).duration(10 * SECONDS)
                .eut(ModuleRecipeInfo.ExtremeTier.recipeEUt).addTo(RecipeMaps.nanochipBoardProcessorRecipes);

        // Bio Board fake recipe
        GTValues.RA.stdBuilder().fake().itemInputs(CircuitComponent.BoardBioMutated.getFakeStack(1))
                .fluidInputs(Materials.BioMediumSterilized.getFluid(0)).fluidOutputs(Materials.BioMediumRaw.getFluid(0))
                .itemOutputs(CircuitComponent.ProcessedBoardBioMutated.getFakeStack(1)).duration(10 * SECONDS)
                .eut(ModuleRecipeInfo.ExtremeTier.recipeEUt).addTo(RecipeMaps.nanochipBoardProcessorRecipes);

        // Optical Board
        GTValues.RA.stdBuilder().hidden().metadata(BoardProcessingModuleFluidKey.INSTANCE, 4)
                .itemInputs(CircuitComponent.BoardOptical.getFakeStack(1))
                .itemOutputs(CircuitComponent.ProcessedBoardOptical.getFakeStack(1)).duration(20 * SECONDS)
                .eut(ModuleRecipeInfo.ExtremeTier.recipeEUt).addTo(RecipeMaps.nanochipBoardProcessorRecipes);

        // Optical Board fake recipe
        GTValues.RA.stdBuilder().fake().itemInputs(CircuitComponent.BoardOptical.getFakeStack(1))
                .fluidInputs(Materials.PrismaticAcid.getFluid(0)).fluidOutputs(Materials.PrismaticGas.getFluid(0))
                .itemOutputs(CircuitComponent.ProcessedBoardOptical.getFakeStack(1)).duration(20 * SECONDS)
                .eut(ModuleRecipeInfo.ExtremeTier.recipeEUt).addTo(RecipeMaps.nanochipBoardProcessorRecipes);
    }

    private static void registerCuttingChamberRecipes() {
        // Wafers
        // CPU
        addSimpleProcessingRecipe(
                CircuitComponent.ChipNanoCPU,
                Materials.Lubricant.getFluid(50),
                CircuitComponent.ProcessedChipNanoCPU,
                ModuleRecipeInfo.MediumTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // RAM
        addSimpleProcessingRecipe(
                CircuitComponent.ChipRAM,
                Materials.Lubricant.getFluid(50),
                CircuitComponent.ProcessedChipRAM,
                ModuleRecipeInfo.MediumTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // NOR
        addSimpleProcessingRecipe(
                CircuitComponent.ChipNOR,
                Materials.Lubricant.getFluid(50),
                CircuitComponent.ProcessedChipNOR,
                ModuleRecipeInfo.MediumTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // NAND
        addSimpleProcessingRecipe(
                CircuitComponent.ChipNAND,
                Materials.Lubricant.getFluid(50),
                CircuitComponent.ProcessedChipNAND,
                ModuleRecipeInfo.MediumTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // ASoC
        addSimpleProcessingRecipe(
                CircuitComponent.ChipASOC,
                Materials.Lubricant.getFluid(50),
                CircuitComponent.ProcessedChipASOC,
                ModuleRecipeInfo.HighTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // PPIC
        addSimpleProcessingRecipe(
                CircuitComponent.ChipPikoPIC,
                Materials.Lubricant.getFluid(50),
                CircuitComponent.ProcessedChipPikoPIC,
                ModuleRecipeInfo.HighTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // QPIC
        addSimpleProcessingRecipe(
                CircuitComponent.ChipQuantumPIC,
                Materials.Lubricant.getFluid(50),
                CircuitComponent.ProcessedChipQuantumPIC,
                ModuleRecipeInfo.HighTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // Pico
        addSimpleProcessingRecipe(
                CircuitComponent.WaferPico,
                Materials.DimensionallyShiftedSuperfluid.getFluid(10),
                CircuitComponent.ProcessedChipPico,
                ModuleRecipeInfo.ExtremeTier,
                20 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // Bolts
        // Enriched Holmium
        addSimpleProcessingRecipe(
                CircuitComponent.BoltEnrichedHolmium,
                Materials.Lubricant.getFluid(20),
                CircuitComponent.ProcessedBoltEnrichedHolmium,
                ModuleRecipeInfo.LowTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // Transcendent Metal
        addSimpleProcessingRecipe(
                CircuitComponent.BoltTranscendentMetal,
                Materials.Lubricant.getFluid(20),
                CircuitComponent.ProcessedBoltTranscendentMetal,
                ModuleRecipeInfo.LowTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // Yttrium Barium Cuprate
        addSimpleProcessingRecipe(
                CircuitComponent.BoltYttriumBariumCuprate,
                Materials.Lubricant.getFluid(20),
                CircuitComponent.ProcessedBoltYttriumBariumCuprate,
                ModuleRecipeInfo.LowTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // Cosmic Neutronium
        addSimpleProcessingRecipe(
                CircuitComponent.BoltCosmicNeutronium,
                Materials.Lubricant.getFluid(20),
                CircuitComponent.ProcessedBoltCosmicNeutronium,
                ModuleRecipeInfo.LowTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // Chromatic Glass
        addSimpleProcessingRecipe(
                CircuitComponent.BoltChromaticGlass,
                Materials.Lubricant.getFluid(20),
                CircuitComponent.ProcessedBoltChromaticGlass,
                ModuleRecipeInfo.LowTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // Chromatic Glass
        addSimpleProcessingRecipe(
                CircuitComponent.BoltUMVSuperconductor,
                Materials.Lubricant.getFluid(20),
                CircuitComponent.ProcessedBoltUMVSuperconductor,
                ModuleRecipeInfo.LowTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // Frame box recipes

        // Aluminium
        addSimpleProcessingRecipe(
                CircuitComponent.FrameboxAluminium,
                Materials.Grade1PurifiedWater.getFluid(500),
                CircuitComponent.ProcessedFrameboxAluminium,
                ModuleRecipeInfo.HighTier,
                10 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        addSimpleProcessingRecipe(
                CircuitComponent.FrameboxAluminium,
                Materials.Grade2PurifiedWater.getFluid(250),
                CircuitComponent.ProcessedFrameboxAluminium,
                ModuleRecipeInfo.HighTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // Tritanium
        addSimpleProcessingRecipe(
                CircuitComponent.FrameboxTritanium,
                Materials.Grade3PurifiedWater.getFluid(500),
                CircuitComponent.ProcessedFrameboxTritanium,
                ModuleRecipeInfo.HighTier,
                20 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        addSimpleProcessingRecipe(
                CircuitComponent.FrameboxTritanium,
                Materials.Grade4PurifiedWater.getFluid(250),
                CircuitComponent.ProcessedFrameboxTritanium,
                ModuleRecipeInfo.HighTier,
                10 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // Celestial Tungsten
        addSimpleProcessingRecipe(
                CircuitComponent.FrameboxCelestialTungsten,
                Materials.Grade5PurifiedWater.getFluid(500),
                CircuitComponent.ProcessedFrameboxCelestialTungsten,
                ModuleRecipeInfo.ExtremeTier,
                20 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        addSimpleProcessingRecipe(
                CircuitComponent.FrameboxCelestialTungsten,
                Materials.Grade6PurifiedWater.getFluid(250),
                CircuitComponent.ProcessedFrameboxCelestialTungsten,
                ModuleRecipeInfo.ExtremeTier,
                10 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // Hypogen
        addSimpleProcessingRecipe(
                CircuitComponent.FrameboxHypogen,
                Materials.Grade7PurifiedWater.getFluid(500),
                CircuitComponent.ProcessedFrameboxHypogen,
                ModuleRecipeInfo.ExtremeTier,
                40 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        addSimpleProcessingRecipe(
                CircuitComponent.FrameboxHypogen,
                Materials.Grade8PurifiedWater.getFluid(250),
                CircuitComponent.ProcessedFrameboxHypogen,
                ModuleRecipeInfo.ExtremeTier,
                20 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // Plate recipes
        addSimpleProcessingRecipe(
                CircuitComponent.PlateMetastableOganesson,
                Materials.DimensionallyShiftedSuperfluid.getFluid(50),
                CircuitComponent.ProcessedPlateMetastableOganesson,
                ModuleRecipeInfo.ExtremeTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);
    }

    private static void registerEncasementWrapperRecipes() {
        // Crystal
        GTValues.RA.stdBuilder().itemInputs(CircuitComponent.ProcessedFrameboxAluminium.getFakeStack(2))
                .itemOutputs(CircuitComponent.ProcessedBasicMainframeCasing.getFakeStack(1)).duration(10 * SECONDS)
                .eut(ModuleRecipeInfo.MediumTier.recipeEUt).addTo(RecipeMaps.nanochipEncasementWrapper);

        // Wetware, Bioware, Optical
        GTValues.RA.stdBuilder()
                .itemInputs(
                        CircuitComponent.ProcessedFoilSiliconeRubber.getFakeStack(16),
                        CircuitComponent.ProcessedFrameboxTritanium.getFakeStack(1),
                        CircuitComponent.ProcessedFoilPolybenzimidazole.getFakeStack(16))
                .itemOutputs(CircuitComponent.ProcessedAdvancedMainframeCasing.getFakeStack(1)).duration(10 * SECONDS)
                .eut(ModuleRecipeInfo.HighTier.recipeEUt).addTo(RecipeMaps.nanochipEncasementWrapper);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        CircuitComponent.ProcessedFoilStyreneRubber.getFakeStack(16),
                        CircuitComponent.ProcessedFrameboxTritanium.getFakeStack(1),
                        CircuitComponent.ProcessedFoilPolybenzimidazole.getFakeStack(16))
                .itemOutputs(CircuitComponent.ProcessedAdvancedMainframeCasing.getFakeStack(1)).duration(10 * SECONDS)
                .eut(ModuleRecipeInfo.HighTier.recipeEUt).addTo(RecipeMaps.nanochipEncasementWrapper);

        // Pico
        GTValues.RA.stdBuilder()
                .itemInputs(
                        CircuitComponent.ProcessedFoilRadoxPolymer.getFakeStack(16),
                        CircuitComponent.ProcessedFrameboxCelestialTungsten.getFakeStack(2),
                        CircuitComponent.ScrewAstralTitanium.getFakeStack(4),
                        CircuitComponent.CasingUEVSuperconductor.getFakeStack(1))
                .itemOutputs(CircuitComponent.ProcessedPicoCircuitCasing.getFakeStack(1)).duration(10 * SECONDS)
                .eut(ModuleRecipeInfo.ExtremeTier.recipeEUt).addTo(RecipeMaps.nanochipEncasementWrapper);

        // Quantum
        GTValues.RA.stdBuilder()
                .itemInputs(
                        CircuitComponent.ProcessedFoilShirabon.getFakeStack(48),
                        CircuitComponent.ProcessedFrameboxHypogen.getFakeStack(2),
                        CircuitComponent.ScrewSixPhasedCopper.getFakeStack(4),
                        CircuitComponent.CasingCreon.getFakeStack(1))
                .itemOutputs(CircuitComponent.ProcessedQuantumCircuitCasing.getFakeStack(1)).duration(20 * SECONDS)
                .eut(ModuleRecipeInfo.ExtremeTier.recipeEUt).addTo(RecipeMaps.nanochipEncasementWrapper);

        // Foil processing recipes
        addSimpleProcessingRecipe(
                CircuitComponent.FoilPolybenzimidazole,
                CircuitComponent.ProcessedFoilPolybenzimidazole,
                ModuleRecipeInfo.LowTier,
                5 * SECONDS,
                RecipeMaps.nanochipEncasementWrapper);

        addSimpleProcessingRecipe(
                CircuitComponent.FoilSiliconeRubber,
                CircuitComponent.ProcessedFoilSiliconeRubber,
                ModuleRecipeInfo.LowTier,
                5 * SECONDS,
                RecipeMaps.nanochipEncasementWrapper);

        addSimpleProcessingRecipe(
                CircuitComponent.FoilStyreneRubber,
                CircuitComponent.ProcessedFoilStyreneRubber,
                ModuleRecipeInfo.LowTier,
                5 * SECONDS,
                RecipeMaps.nanochipEncasementWrapper);

        addSimpleProcessingRecipe(
                CircuitComponent.FoilRadoxPolymer,
                CircuitComponent.ProcessedFoilRadoxPolymer,
                ModuleRecipeInfo.HighTier,
                5 * SECONDS,
                RecipeMaps.nanochipEncasementWrapper);

        addSimpleProcessingRecipe(
                CircuitComponent.FoilShirabon,
                CircuitComponent.ProcessedFoilShirabon,
                ModuleRecipeInfo.ExtremeTier,
                5 * SECONDS,
                RecipeMaps.nanochipEncasementWrapper);
    }

    private static void registerEtchingArrayRecipes() {
        // Crystal CPU
        addSimpleProcessingRecipe(
                CircuitComponent.ChipCrystalCPU,
                CircuitComponent.ProcessedChipCrystalCPU,
                ModuleRecipeInfo.MediumTier,
                10 * SECONDS,
                RecipeMaps.nanochipEtchingArray);

        // Raw Advanced Crystal Chip
        addSimpleProcessingRecipe(
                CircuitComponent.ChipRawAdvancedCrystal,
                CircuitComponent.ProcessedChipRawAdvancedCrystal,
                ModuleRecipeInfo.HighTier,
                10 * SECONDS,
                RecipeMaps.nanochipEtchingArray);

        // Crystal SoC
        addSimpleProcessingRecipe(
                CircuitComponent.ChipCrystalSoC,
                CircuitComponent.ProcessedChipCrystalSoC,
                ModuleRecipeInfo.HighTier,
                20 * SECONDS,
                RecipeMaps.nanochipEtchingArray);
    }

    private static void registerOpticalOrganizerRecipes() {
        // Optical CPU
        addSimpleProcessingRecipe(
                CircuitComponent.ChipOpticalCPU,
                CircuitComponent.ProcessedChipOpticalCPU,
                ModuleRecipeInfo.ExtremeTier,
                10 * SECONDS,
                RecipeMaps.nanochipOpticalOrganizer);

        // Optical Memory
        addSimpleProcessingRecipe(
                CircuitComponent.OpticalRAM,
                CircuitComponent.ProcessedOpticalRAM,
                ModuleRecipeInfo.ExtremeTier,
                5 * SECONDS,
                RecipeMaps.nanochipOpticalOrganizer);
    }

    private static void registerSMDProcessorRecipes() {
        // ASMDs
        addSimpleProcessingRecipe(
                CircuitComponent.AdvSMDResistor,
                CircuitComponent.ProcessedAdvSMDResistor,
                ModuleRecipeInfo.LowTier,
                5 * SECONDS,
                RecipeMaps.nanochipSMDProcessorRecipes);

        addSimpleProcessingRecipe(
                CircuitComponent.AdvSMDTransistor,
                CircuitComponent.ProcessedAdvSMDTransistor,
                ModuleRecipeInfo.LowTier,
                5 * SECONDS,
                RecipeMaps.nanochipSMDProcessorRecipes);

        addSimpleProcessingRecipe(
                CircuitComponent.AdvSMDInductor,
                CircuitComponent.ProcessedAdvSMDInductor,
                ModuleRecipeInfo.LowTier,
                5 * SECONDS,
                RecipeMaps.nanochipSMDProcessorRecipes);

        addSimpleProcessingRecipe(
                CircuitComponent.AdvSMDCapacitor,
                CircuitComponent.ProcessedAdvSMDCapacitor,
                ModuleRecipeInfo.LowTier,
                5 * SECONDS,
                RecipeMaps.nanochipSMDProcessorRecipes);

        addSimpleProcessingRecipe(
                CircuitComponent.AdvSMDDiode,
                CircuitComponent.ProcessedAdvSMDDiode,
                ModuleRecipeInfo.LowTier,
                5 * SECONDS,
                RecipeMaps.nanochipSMDProcessorRecipes);

        // Optical SMDs
        addSimpleProcessingRecipe(
                CircuitComponent.OpticalSMDResistor,
                CircuitComponent.ProcessedOpticalSMDResistor,
                ModuleRecipeInfo.MediumTier,
                5 * SECONDS,
                RecipeMaps.nanochipSMDProcessorRecipes);

        addSimpleProcessingRecipe(
                CircuitComponent.OpticalSMDTransistor,
                CircuitComponent.ProcessedOpticalSMDTransistor,
                ModuleRecipeInfo.MediumTier,
                5 * SECONDS,
                RecipeMaps.nanochipSMDProcessorRecipes);

        addSimpleProcessingRecipe(
                CircuitComponent.OpticalSMDInductor,
                CircuitComponent.ProcessedOpticalSMDInductor,
                ModuleRecipeInfo.MediumTier,
                5 * SECONDS,
                RecipeMaps.nanochipSMDProcessorRecipes);

        addSimpleProcessingRecipe(
                CircuitComponent.OpticalSMDCapacitor,
                CircuitComponent.ProcessedOpticalSMDCapacitor,
                ModuleRecipeInfo.MediumTier,
                5 * SECONDS,
                RecipeMaps.nanochipSMDProcessorRecipes);

        addSimpleProcessingRecipe(
                CircuitComponent.OpticalSMDDiode,
                CircuitComponent.ProcessedOpticalSMDDiode,
                ModuleRecipeInfo.MediumTier,
                5 * SECONDS,
                RecipeMaps.nanochipSMDProcessorRecipes);
    }

    private static void registerSuperconductorSplitterRecipes() {
        // LuV
        addSimpleProcessingRecipe(
                CircuitComponent.SuperconductorLuV,
                CircuitComponent.ProcessedSuperconductorLuV,
                ModuleRecipeInfo.MediumTier,
                5 * SECONDS,
                RecipeMaps.nanochipSuperconductorSplitter);

        // ZPM
        addSimpleProcessingRecipe(
                CircuitComponent.SuperconductorZPM,
                CircuitComponent.ProcessedSuperconductorZPM,
                ModuleRecipeInfo.MediumTier,
                10 * SECONDS,
                RecipeMaps.nanochipSuperconductorSplitter);

        // UV
        addSimpleProcessingRecipe(
                CircuitComponent.SuperconductorUV,
                CircuitComponent.ProcessedSuperconductorUV,
                ModuleRecipeInfo.HighTier,
                5 * SECONDS,
                RecipeMaps.nanochipSuperconductorSplitter);

        // UHV
        addSimpleProcessingRecipe(
                CircuitComponent.SuperconductorUHV,
                CircuitComponent.ProcessedSuperconductorUHV,
                ModuleRecipeInfo.HighTier,
                10 * SECONDS,
                RecipeMaps.nanochipSuperconductorSplitter);

        // UEV
        addSimpleProcessingRecipe(
                CircuitComponent.SuperconductorUEV,
                CircuitComponent.ProcessedSuperconductorUEV,
                ModuleRecipeInfo.HighTier,
                20 * SECONDS,
                RecipeMaps.nanochipSuperconductorSplitter);

        // UIV
        addSimpleProcessingRecipe(
                CircuitComponent.SuperconductorUIV,
                CircuitComponent.ProcessedSuperconductorUIV,
                ModuleRecipeInfo.ExtremeTier,
                5 * SECONDS,
                RecipeMaps.nanochipSuperconductorSplitter);

        // UMV
        addSimpleProcessingRecipe(
                CircuitComponent.SuperconductorUMV,
                CircuitComponent.ProcessedSuperconductorUMV,
                ModuleRecipeInfo.ExtremeTier,
                10 * SECONDS,
                RecipeMaps.nanochipSuperconductorSplitter);
    }

    private static void registerWireTracerRecipes() {
        // NbTi
        addSimpleProcessingRecipe(
                CircuitComponent.WireNiobiumTitanium,
                CircuitComponent.ProcessedWireNiobiumTitanium,
                ModuleRecipeInfo.MediumTier,
                5 * SECONDS,
                RecipeMaps.nanochipWireTracer);

        // YBCO
        addSimpleProcessingRecipe(
                CircuitComponent.WireYttriumBariumCuprate,
                CircuitComponent.ProcessedWireYttriumBariumCuprate,
                ModuleRecipeInfo.MediumTier,
                5 * SECONDS,
                RecipeMaps.nanochipWireTracer);

        // Lumiium
        addSimpleProcessingRecipe(
                CircuitComponent.WireLumiium,
                CircuitComponent.ProcessedWireLumiium,
                ModuleRecipeInfo.MediumTier,
                5 * SECONDS,
                RecipeMaps.nanochipWireTracer);

        // Proto Halkonite
        addSimpleProcessingRecipe(
                CircuitComponent.WireProtoHalkonite,
                CircuitComponent.ProcessedWireProtoHalkonite,
                ModuleRecipeInfo.HighTier,
                5 * SECONDS,
                RecipeMaps.nanochipWireTracer);

        // Infinity
        addSimpleProcessingRecipe(
                CircuitComponent.WireInfinity,
                CircuitComponent.ProcessedWireInfinity,
                ModuleRecipeInfo.HighTier,
                5 * SECONDS,
                RecipeMaps.nanochipWireTracer);

        // Spacetime
        addSimpleProcessingRecipe(
                CircuitComponent.WireSpacetime,
                CircuitComponent.ProcessedWireSpacetime,
                ModuleRecipeInfo.HighTier,
                10 * SECONDS,
                RecipeMaps.nanochipWireTracer);

        // Optical Cable
        addSimpleProcessingRecipe(
                CircuitComponent.CableOpticalFiber,
                CircuitComponent.ProcessedCableOpticalFiber,
                ModuleRecipeInfo.MediumTier,
                5 * SECONDS,
                RecipeMaps.nanochipWireTracer);
    }

    // spotless:off
    private static void registerAssemblyMatrixRecipes() {
        // ======= //
        // Crystal //
        // ======= //
        addAssemblyMatrixRecipe(
                Arrays.asList(
                        new CircuitComponentStack(CircuitComponent.ProcessedBoardMultifiberglassElite, 1),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipCrystalCPU, 1),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipNanoCPU, 2),
                        new CircuitComponentStack(CircuitComponent.ProcessedAdvSMDCapacitor, 6),
                        new CircuitComponentStack(CircuitComponent.ProcessedAdvSMDTransistor, 6),
                        new CircuitComponentStack(CircuitComponent.ProcessedWireNiobiumTitanium, 8)),
                Arrays.asList(MaterialsAlloy.INDALLOY_140.getFluidStack(4)),
                CircuitComponent.CrystalProcessor,
                4 * SECONDS,
                9_600, // LuV
                VoltageIndex.LuV);

        // SoC
        addAssemblyMatrixRecipe(
                Arrays.asList(
                        new CircuitComponentStack(CircuitComponent.ProcessedBoardMultifiberglassElite, 1),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipCrystalSoC, 1),
                        new CircuitComponentStack(CircuitComponent.ProcessedWireNiobiumTitanium, 8),
                        new CircuitComponentStack(CircuitComponent.ProcessedBoltYttriumBariumCuprate, 4)),
                Arrays.asList(MaterialsAlloy.INDALLOY_140.getFluidStack(4)),
                CircuitComponent.CrystalProcessor,
                2 * SECONDS,
                153_600, // UV
                VoltageIndex.LuV);

        addAssemblyMatrixRecipe(
                Arrays.asList(
                        new CircuitComponentStack(CircuitComponent.ProcessedBoardMultifiberglassElite, 1),
                        new CircuitComponentStack(CircuitComponent.CrystalProcessor, 2),
                        new CircuitComponentStack(CircuitComponent.ProcessedAdvSMDInductor, 6),
                        new CircuitComponentStack(CircuitComponent.ProcessedAdvSMDCapacitor, 8),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipRAM, 24),
                        new CircuitComponentStack(CircuitComponent.ProcessedWireNiobiumTitanium, 16)),
                Arrays.asList(MaterialsAlloy.INDALLOY_140.getFluidStack(9)),
                CircuitComponent.CrystalAssembly,
                8 * SECONDS,
                9_600, // LuV
                VoltageIndex.LuV);

        addAssemblyMatrixRecipe(
                Arrays.asList(
                        new CircuitComponentStack(CircuitComponent.ProcessedBoardMultifiberglassElite, 1),
                        new CircuitComponentStack(CircuitComponent.CrystalAssembly, 2),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipRAM, 6),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipNOR, 32),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipNAND, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedWireNiobiumTitanium, 32)),
                Arrays.asList(MaterialsAlloy.INDALLOY_140.getFluidStack(9)),
                CircuitComponent.CrystalComputer,
                16 * SECONDS,
                9_600, // LuV
                VoltageIndex.LuV);

        addAssemblyMatrixRecipe(
                Arrays.asList(
                        new CircuitComponentStack(CircuitComponent.ProcessedBasicMainframeCasing, 1),
                        new CircuitComponentStack(CircuitComponent.CrystalComputer, 2),
                        new CircuitComponentStack(CircuitComponent.ProcessedAdvSMDInductor, 8),
                        new CircuitComponentStack(CircuitComponent.ProcessedAdvSMDCapacitor, 16),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipRAM, 32),
                        new CircuitComponentStack(CircuitComponent.ProcessedSuperconductorLuV, 16)),
                Arrays.asList(MaterialsAlloy.INDALLOY_140.getFluidStack(18)),
                CircuitComponent.CrystalMainframe,
                32 * SECONDS,
                TierEU.RECIPE_LuV,
                VoltageIndex.LuV);

        // ======= //
        // Wetware //
        // ======= //

        addAssemblyMatrixRecipe(
                Arrays.asList(
                        new CircuitComponentStack(CircuitComponent.ProcessedNeuroProcessingUnit, 1),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipCrystalCPU, 1),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipNanoCPU, 1),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDCapacitor, 2),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDTransistor, 2),
                        new CircuitComponentStack(CircuitComponent.ProcessedWireYttriumBariumCuprate, 8)),
                Arrays.asList(MaterialsAlloy.INDALLOY_140.getFluidStack(4)),
                CircuitComponent.WetwareProcessor,
                1 * SECONDS,
                153_600, // UV
                VoltageIndex.ZPM);

        // SoC
        addAssemblyMatrixRecipe(
                Arrays.asList(
                        new CircuitComponentStack(CircuitComponent.ProcessedBoardWetwareLifesupport, 1),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipLivingCrystal, 1),
                        new CircuitComponentStack(CircuitComponent.ProcessedWireYttriumBariumCuprate, 8),
                        new CircuitComponentStack(CircuitComponent.ProcessedBoltCosmicNeutronium, 4)),
                Arrays.asList(MaterialsAlloy.INDALLOY_140.getFluidStack(4)),
                CircuitComponent.WetwareProcessor,
                2 * SECONDS,
                614_400, // UHV
                VoltageIndex.ZPM);

        addAssemblyMatrixRecipe(
                Arrays.asList(
                        new CircuitComponentStack(CircuitComponent.ProcessedBoardWetwareLifesupport, 1),
                        new CircuitComponentStack(CircuitComponent.WetwareProcessor, 2),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDInductor, 2),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDCapacitor, 3),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipRAM, 24),
                        new CircuitComponentStack(CircuitComponent.ProcessedWireYttriumBariumCuprate, 16)),
                Arrays.asList(MaterialsAlloy.INDALLOY_140.getFluidStack(9)),
                CircuitComponent.WetwareAssembly,
                1 * SECONDS + 10 * TICKS,
                153_600, // UV
                VoltageIndex.ZPM);

        addAssemblyMatrixRecipe(
                Arrays.asList(
                        new CircuitComponentStack(CircuitComponent.ProcessedBoardWetwareLifesupport, 2),
                        new CircuitComponentStack(CircuitComponent.WetwareAssembly, 2),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDDiode, 2),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipNOR, 16),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipRAM, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedWireYttriumBariumCuprate, 24)),
                Arrays.asList(MaterialsAlloy.INDALLOY_140.getFluidStack(9)),
                CircuitComponent.WetwareComputer,
                3 * SECONDS,
                153_600, // UV
                VoltageIndex.ZPM);

        addAssemblyMatrixRecipe(
                Arrays.asList(
                        new CircuitComponentStack(CircuitComponent.ProcessedAdvancedMainframeCasing, 2),
                        new CircuitComponentStack(CircuitComponent.WetwareComputer, 2),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDInductor, 4),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDCapacitor, 4),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDResistor, 4),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDTransistor, 4),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDDiode, 4),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipRAM, 48),
                        new Object[] {
                            new CircuitComponentStack(CircuitComponent.ProcessedSuperconductorZPM, 64),
                            new CircuitComponentStack(CircuitComponent.ProcessedSuperconductorUV, 32),
                            new CircuitComponentStack(CircuitComponent.ProcessedSuperconductorUHV, 16),
                            new CircuitComponentStack(CircuitComponent.ProcessedSuperconductorUEV, 8),
                            new CircuitComponentStack(CircuitComponent.ProcessedSuperconductorUIV, 4),
                            new CircuitComponentStack(CircuitComponent.ProcessedSuperconductorUMV, 2),
                        }),
                Arrays.asList(
                        MaterialsAlloy.INDALLOY_140.getFluidStack(2 * INGOTS),
                        FluidRegistry.getFluidStack("ic2coolant", 10000),
                        Materials.Radon.getGas(2500)),
                CircuitComponent.WetwareMainframe,
                100 * SECONDS,
                4_800_000, // UEV
                VoltageIndex.ZPM);

        // ======= //
        // Bioware //
        // ======= //

        addAssemblyMatrixRecipe(
                Arrays.asList(
                        new CircuitComponentStack(CircuitComponent.ProcessedBioProcessingUnit, 1),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipRawAdvancedCrystal, 1),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipNanoCPU, 2),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDCapacitor, 3),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDTransistor, 3),
                        new CircuitComponentStack(CircuitComponent.ProcessedWireNiobiumTitanium, 16)),
                Arrays.asList(MaterialsAlloy.INDALLOY_140.getFluidStack(4)),
                CircuitComponent.BiowareProcessor,
                2 * SECONDS + 10 * TICKS,
                614_400, // UHV
                VoltageIndex.UV);

        // SoC
        addAssemblyMatrixRecipe(
                Arrays.asList(
                        new CircuitComponentStack(CircuitComponent.ProcessedBoardBioMutated, 1),
                        new CircuitComponentStack(CircuitComponent.ProcessedLivingBioChip, 1),
                        new CircuitComponentStack(CircuitComponent.ProcessedWireNiobiumTitanium, 16),
                        new CircuitComponentStack(CircuitComponent.ProcessedBoltChromaticGlass, 4)),
                Arrays.asList(MaterialsAlloy.INDALLOY_140.getFluidStack(9)),
                CircuitComponent.BiowareProcessor,
                3 * SECONDS,
                2_457_600, // UEV
                VoltageIndex.UV);

        addAssemblyMatrixRecipe(
                Arrays.asList(
                        new CircuitComponentStack(CircuitComponent.ProcessedBoardBioMutated, 1),
                        new CircuitComponentStack(CircuitComponent.BiowareProcessor, 2),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDInductor, 3),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDCapacitor, 4),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipRAM, 32),
                        new CircuitComponentStack(CircuitComponent.ProcessedWireYttriumBariumCuprate, 24)),
                Arrays.asList(MaterialsAlloy.INDALLOY_140.getFluidStack(9)),
                CircuitComponent.BiowareAssembly,
                2 * SECONDS,
                614_400, // UHV
                VoltageIndex.UV);

        addAssemblyMatrixRecipe(
                Arrays.asList(
                        new CircuitComponentStack(CircuitComponent.ProcessedBoardBioMutated, 2),
                        new CircuitComponentStack(CircuitComponent.BiowareAssembly, 2),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDTransistor, 4),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDResistor, 4),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDCapacitor, 4),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDDiode, 4),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipNOR, 32),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipRAM, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedWireNiobiumTitanium, 32),
                        new Object[] {
                            new CircuitComponentStack(CircuitComponent.ProcessedFoilSiliconeRubber, 64),
                            new CircuitComponentStack(CircuitComponent.ProcessedFoilStyreneRubber,64)
                        }),
                Arrays.asList(
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(10 * INGOTS),
                        Materials.BioMediumSterilized.getFluid(5 * INGOTS),
                        Materials.SuperCoolant.getFluid(10000)),
                CircuitComponent.BiowareComputer,
                200 * SECONDS,
                TierEU.RECIPE_UEV,
                VoltageIndex.UV);

        addAssemblyMatrixRecipe(
                Arrays.asList(
                        new CircuitComponentStack(CircuitComponent.ProcessedAdvancedMainframeCasing, 4),
                        new CircuitComponentStack(CircuitComponent.BiowareComputer, 2),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDInductor, 6),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDCapacitor, 6),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDResistor, 6),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDTransistor, 6),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDDiode, 6),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipRAM, 64),
                        new Object[] {
                            new CircuitComponentStack(CircuitComponent.ProcessedSuperconductorUHV, 64),
                            new CircuitComponentStack(CircuitComponent.ProcessedSuperconductorUEV, 32),
                            new CircuitComponentStack(CircuitComponent.ProcessedSuperconductorUIV, 16),
                            new CircuitComponentStack(CircuitComponent.ProcessedSuperconductorUMV, 8),
                        }),
                Arrays.asList(
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(20 * INGOTS),
                        Materials.BioMediumSterilized.getFluid(10 * INGOTS),
                        Materials.SuperCoolant.getFluid(20000)),
                CircuitComponent.BiowareMainframe,
                300 * SECONDS,
                TierEU.RECIPE_UIV,
                VoltageIndex.UV);

        // ======= //
        // Optical //
        // ======= //

        addAssemblyMatrixRecipe(
                Arrays.asList(
                        new CircuitComponentStack(CircuitComponent.ProcessedChipOpticalCPU, 1),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalRAM, 2),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDCapacitor, 16),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDDiode, 16),
                        new CircuitComponentStack(CircuitComponent.ProcessedCableOpticalFiber, 4),
                        new CircuitComponentStack(CircuitComponent.ProcessedBoltEnrichedHolmium, 4)),
                Arrays.asList(MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(18)),
                CircuitComponent.OpticalProcessor,
                15 * SECONDS,
                614_400, // UHV
                VoltageIndex.UHV);

        addAssemblyMatrixRecipe(
                Arrays.asList(
                        new CircuitComponentStack(CircuitComponent.ProcessedBoardOptical, 1),
                        new CircuitComponentStack(CircuitComponent.OpticalProcessor, 2),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDInductor, 16),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDCapacitor, 20),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDResistor, 20),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipNOR, 32),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipRAM, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedWireLumiium, 24),
                        new Object[] {
                            new CircuitComponentStack(CircuitComponent.ProcessedFoilSiliconeRubber, 64),
                            new CircuitComponentStack(CircuitComponent.ProcessedFoilStyreneRubber,64)
                        }),
                Arrays.asList(
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(10 * INGOTS),
                        Materials.Radon.getGas(10 * INGOTS),
                        Materials.SuperCoolant.getFluid(10000),
                        WerkstoffLoader.Oganesson.getFluidOrGas(500)),
                CircuitComponent.OpticalAssembly,
                20 * SECONDS,
                TierEU.RECIPE_UIV,
                VoltageIndex.UHV);

        addAssemblyMatrixRecipe(
                Arrays.asList(
                        new CircuitComponentStack(CircuitComponent.ProcessedBoardOptical, 2),
                        new CircuitComponentStack(CircuitComponent.OpticalAssembly, 2),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDTransistor, 24),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDResistor, 24),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDCapacitor, 24),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDDiode, 24),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipNOR, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipASOC, 32),
                        new CircuitComponentStack(CircuitComponent.ProcessedWireLumiium, 32),
                        new Object[] {
                            new CircuitComponentStack(CircuitComponent.ProcessedFoilSiliconeRubber, 64),
                            new CircuitComponentStack(CircuitComponent.ProcessedFoilStyreneRubber,64)
                        },
                        new CircuitComponentStack(CircuitComponent.ProcessedFoilPolybenzimidazole, 64)),
                Arrays.asList(
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(20 * INGOTS),
                        Materials.Radon.getGas(20 * INGOTS),
                        Materials.SuperCoolant.getFluid(20000),
                        WerkstoffLoader.Oganesson.getFluidOrGas(1000)),
                CircuitComponent.OpticalComputer,
                200 * SECONDS,
                TierEU.RECIPE_UIV,
                VoltageIndex.UHV);

        addAssemblyMatrixRecipe(
                Arrays.asList(
                        new CircuitComponentStack(CircuitComponent.ProcessedAdvancedMainframeCasing, 8),
                        new CircuitComponentStack(CircuitComponent.OpticalComputer, 2),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDInductor, 32),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDCapacitor, 32),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDResistor, 32),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDTransistor, 32),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDDiode, 32),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipASOC, 64),
                        new Object[] {
                            new CircuitComponentStack(CircuitComponent.ProcessedSuperconductorUEV, 64),
                            new CircuitComponentStack(CircuitComponent.ProcessedSuperconductorUIV, 32),
                            new CircuitComponentStack(CircuitComponent.ProcessedSuperconductorUMV, 16),
                        }),
                Arrays.asList(
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(40 * INGOTS),
                        Materials.Radon.getGas(40 * INGOTS),
                        Materials.SuperCoolant.getFluid(40000),
                        WerkstoffLoader.Oganesson.getFluidOrGas(2000)),
                CircuitComponent.OpticalMainframe,
                300 * SECONDS,
                TierEU.RECIPE_UMV,
                VoltageIndex.UHV);

        // ======= //
        // Special //
        // ======= //

        addAssemblyMatrixRecipe(
                Arrays.asList(
                        new CircuitComponentStack(CircuitComponent.ProcessedPicoCircuitCasing, 1),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipPico, 4),
                        new CircuitComponentStack(CircuitComponent.OpticalMainframe, 2),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipPikoPIC, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDInductor, 48),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDCapacitor, 48),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDResistor, 48),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDTransistor, 48),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDDiode, 48),
                        new CircuitComponentStack(CircuitComponent.ProcessedWireProtoHalkonite, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedBoltTranscendentMetal, 32),
                        new CircuitComponentStack(CircuitComponent.ProcessedWireInfinity, 8)),
                Arrays.asList(
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(16 * INGOTS),
                        Materials.UUMatter.getFluid(8000),
                        GGMaterial.preciousMetalAlloy.getMolten(8 * INGOTS)),
                CircuitComponent.PicoCircuit,
                250 * SECONDS,
                TierEU.RECIPE_MAX,
                VoltageIndex.UIV);

        addAssemblyMatrixRecipe(
                Arrays.asList(
                        new CircuitComponentStack(CircuitComponent.ProcessedQuantumCircuitCasing, 1),
                        new CircuitComponentStack(CircuitComponent.ProcessedPlateMetastableOganesson, 2),
                        new CircuitComponentStack(CircuitComponent.PicoCircuit, 2),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipQuantumPIC, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDInductor, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDCapacitor, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDResistor, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDTransistor, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDDiode, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedWireProtoHalkonite, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedBoltUMVSuperconductor, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedWireSpacetime, 8)),
                Arrays.asList(
                        MaterialMisc.MUTATED_LIVING_SOLDER.getFluidStack(32 * INGOTS),
                        Materials.UUMatter.getFluid(24000),
                        GGMaterial.preciousMetalAlloy.getMolten(16 * INGOTS)),
                CircuitComponent.QuantumCircuit,
                500 * SECONDS,
                TierEU.RECIPE_MAX,
                VoltageIndex.UIV);
    }
    // spotless:on
}
