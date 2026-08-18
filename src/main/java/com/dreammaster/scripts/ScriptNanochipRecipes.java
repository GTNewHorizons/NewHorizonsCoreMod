package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static goodgenerator.api.recipe.GoodGeneratorRecipeMaps.preciseAssemblerRecipes;
import static gregtech.api.enums.Mods.AE2FluidCraft;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.UniversalSingularities;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.formingPressRecipes;
import static gregtech.api.recipe.RecipeMaps.laserEngraverRecipes;
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
import com.ruling_0.materiallib.api.MaterialLibAPI;

import bartworks.common.loaders.ItemRegistry;
import ggfab.GGItemList;
import goodgenerator.util.ItemRefer;
import gregtech.api.enums.Circuits;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Mods;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.VoltageIndex;
import gregtech.api.enums.materials.FluidShapes;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;
import gregtech.api.material.MaterialUtils;
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
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;
import gtnhintergalactic.recipe.IGRecipeMaps;
import gtnhlanth.common.register.LanthItemList;
import tectech.recipe.TTRecipeAdder;
import tectech.thing.CustomItemList;

public class ScriptNanochipRecipes implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Nanochip Assembly Complex";
    }

    @Override
    public List<Mods> getDependencies() {
        return Arrays.asList(AE2FluidCraft, AppliedEnergistics2, OpenComputers, UniversalSingularities);
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
                new Object[] { ItemList.ReinforcementNanochipCasing.get(1), ItemList.MobRep_UV.get(4), MaterialLibAPI
                        .getStack(Materials.Longasssuperconductornameforuhvwire, Shapes.plateSuperdense, (int) (2)),
                        MaterialLibAPI.getStack(Materials.TengamAttuned, Shapes.plateSuperdense, (int) (8)),
                        ItemList.Emitter_UEV.get(2), ItemList.Sensor_UEV.get(2),
                        getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 24), // Nether Star
                                                                                                       // Singularity
                        ItemList.Field_Generator_UHV.get(1) },
                new FluidStack[] { MaterialLibAPI
                        .getFluidStack(Materials.MutatedLivingSolder, FluidShapes.fluidMolten, (int) (128 * INGOTS)),
                        MaterialLibAPI.getFluidStack(Materials.Oganesson, FluidShapes.fluidLiquid, (int) (16000)),
                        MaterialLibAPI.getFluidStack(
                                Materials.SuperconductorUEVBase,
                                FluidShapes.fluidMolten,
                                (int) (16 * INGOTS)),
                        MaterialLibAPI
                                .getFluidStack(Materials.RadoxPoly, FluidShapes.fluidMolten, (int) (4 * INGOTS)) },
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
                new FluidStack[] { MaterialLibAPI
                        .getFluidStack(Materials.MutatedLivingSolder, FluidShapes.fluidMolten, (int) (16 * INGOTS)),
                        MaterialLibAPI.getFluidStack(Materials.Xenoxene, FluidShapes.fluidLiquid, (int) (16 * INGOTS)),
                        MaterialLibAPI.getFluidStack(
                                Materials.TengamPurified,
                                FluidShapes.fluidMolten,
                                (int) (16 * INGOTS)), },
                ItemList.ComputationalMatrixNanochipCasing.get(4),
                60 * SECONDS,
                (int) TierEU.RECIPE_UHV);

        // Nanochip Complex Glass
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(ItemRegistry.bw_realglas, 8, 6),
                        MaterialLibAPI.getStack(Materials.RoseGold, Shapes.wireFine, (int) (64)),
                        GregtechItemList.Laser_Lens_Special.get(0))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.ReactiveIonEtchingMixture,
                                FluidShapes.fluidLiquid,
                                (int) (2000)))
                .itemOutputs(ItemList.ComplexNanochipGlass.get(8)).duration(15 * SECONDS).eut(TierEU.RECIPE_UHV)
                .addTo(laserEngraverRecipes);

        // Nanochip Reinforcement Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Bedrockium, 8),
                        MaterialLibAPI.getStack(Materials.CelestialTungsten, Shapes.foil, (int) (48)),
                        MaterialLibAPI.getStack(Materials.Naquadah, Shapes.plateSuperdense, (int) (4)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.Neutronium, FluidShapes.fluidMolten, (int) (8 * INGOTS)))
                .itemOutputs(ItemList.ReinforcementNanochipCasing.get(8)).duration(7 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_UHV).addTo(formingPressRecipes);

        // Nanochip Mesh Interface Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Iridium, 8),
                        MaterialLibAPI.getStack(Materials.RhodiumPlatedPalladium, Shapes.foil, (int) (48)),
                        MaterialLibAPI.getStack(Materials.Adamantium, Shapes.plateSuperdense, (int) (4)),
                        ItemList.VacuumConveyorPipe.get(8))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.BlackPlutonium, FluidShapes.fluidMolten, (int) (8 * INGOTS)),
                        MaterialLibAPI.getFluidStack(
                                Materials.MutatedLivingSolder,
                                FluidShapes.fluidMolten,
                                (int) (8 * INGOTS)))
                .itemOutputs(ItemList.MeshInterfaceNanochipCasing.get(8)).duration(7 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_UHV).metadata(PRECISE_ASSEMBLER_CASING_TIER, 3).addTo(preciseAssemblerRecipes);

        // Vacuum Conveyor Input
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.MeshInterfaceNanochipCasing.get(1),
                        ItemList.Hatch_Input_Bus_MAX.get(1),
                        ItemList.Conveyor_Module_UEV.get(1),
                        ItemList.VacuumConveyorPipe.get(8))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.MutatedLivingSolder,
                                FluidShapes.fluidMolten,
                                (int) (4 * INGOTS)))
                .itemOutputs(ItemList.Hatch_VacuumConveyor_Input.get(1)).duration(15 * SECONDS).eut(TierEU.RECIPE_UEV)
                .addTo(assemblerRecipes);

        // Vacuum Conveyor Output
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.MeshInterfaceNanochipCasing.get(1),
                        ItemList.Hatch_Output_Bus_MAX.get(1),
                        ItemList.Conveyor_Module_UEV.get(1),
                        ItemList.VacuumConveyorPipe.get(8))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.MutatedLivingSolder,
                                FluidShapes.fluidMolten,
                                (int) (4 * INGOTS)))
                .itemOutputs(ItemList.Hatch_VacuumConveyor_Output.get(1)).duration(15 * SECONDS).eut(TierEU.RECIPE_UEV)
                .addTo(assemblerRecipes);

        // Vacuum Conveyor Pipe
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeSmall, Materials.BlackPlutonium, 1),
                        MaterialLibAPI.getStack(Materials.ChromaticGlass, Shapes.foil, (int) (4)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.Kevlar, FluidShapes.fluidMolten, (int) (1 * INGOTS)))
                .itemOutputs(ItemList.VacuumConveyorPipe.get(1)).duration(10 * SECONDS).eut(TierEU.RECIPE_UHV)
                .addTo(assemblerRecipes);

        // Splitter Redstone Hatch
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_UEV.get(1),
                        ItemList.Cover_AdvancedRedstoneReceiver.get(1),
                        ItemList.Sensor_UHV.get(1),
                        MaterialLibAPI.getStack(Materials.RedstoneAlloy, Shapes.plateSuperdense, (int) (4)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.Redstone, FluidShapes.fluidMolten, (int) (64 * INGOTS)))
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
                        new Object[] { Circuits.UEV.getIngredient(), 8 },
                        new Object[] { Circuits.UHV.getIngredient(), 16 },
                        new Object[] { Circuits.UV.getIngredient(), 32 }, ItemList.ZPM2.get(1),
                        ItemList.Sensor_UEV.get(4), ItemList.Emitter_UEV.get(4),
                        getModItem(OpenComputers.ID, "screen3", 1, 0), getModItem(OpenComputers.ID, "keyboard", 1, 0) },
                new FluidStack[] { MaterialLibAPI
                        .getFluidStack(Materials.MutatedLivingSolder, FluidShapes.fluidMolten, (int) (256 * INGOTS)),
                        MaterialLibAPI.getFluidStack(
                                Materials.CelestialTungsten,
                                FluidShapes.fluidPlasma,
                                (int) (64 * INGOTS)),
                        MaterialLibAPI.getFluidStack(Materials.Americium, FluidShapes.fluidPlasma, (int) (64 * INGOTS)),
                        MaterialLibAPI.getFluidStack(
                                Materials.AstralTitanium,
                                FluidShapes.fluidPlasma,
                                (int) (64 * INGOTS)) },
                ItemList.Machine_Multi_NanochipAssemblyComplex.get(1),
                120 * SECONDS,
                (int) TierEU.RECIPE_UIV);

        // Assembly Matrix
        GTValues.RA.stdBuilder().itemInputs(
                ItemList.MeshInterfaceNanochipCasing.get(1),
                new Object[] { Circuits.UEV.getIngredient(), 4 },
                ItemList.VacuumConveyorPipe.get(16),
                ItemList.Robot_Arm_UEV.get(1),
                ItemList.SpaceElevatorModuleAssemblerT1.get(1),
                ItemRefer.Precise_Assembler.get(1),
                GGItemList.AdvAssLine.get(1),
                GTUtility.copyAmount(1, ItemRegistry.cal),
                ItemRefer.Compassline_Casing_UEV.get(4),
                MaterialLibAPI
                        .getStack(Materials.Longasssuperconductornameforuhvwire, Shapes.plateSuperdense, (int) (32)),
                MaterialLibAPI.getStack(Materials.Infinity, Shapes.plateSuperdense, (int) (4)),
                GTOreDictUnificator.get(OrePrefixes.nanite, Materials.Silver, 1))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.MutatedLivingSolder,
                                FluidShapes.fluidMolten,
                                (int) (32 * INGOTS)),
                        MaterialLibAPI
                                .getFluidStack(Materials.NaquadahAlloy, FluidShapes.fluidMolten, (int) (32 * INGOTS)),
                        MaterialLibAPI.getFluidStack(Materials.Infinity, FluidShapes.fluidMolten, (int) (32 * INGOTS)))
                .itemOutputs(ItemList.NanoChipModule_AssemblyMatrix.get(1)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_UHV).metadata(IGRecipeMaps.MODULE_TIER, 1).addTo(spaceAssemblerRecipes);

        // Etching Array
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.MeshInterfaceNanochipCasing.get(1),
                        new Object[] { Circuits.UEV.getIngredient(), 4 },
                        ItemList.VacuumConveyorPipe.get(16),
                        ItemList.Sensor_UEV.get(1),
                        GTUtility.copyAmount(1, LanthItemList.TARGET_CHAMBER),
                        ItemList.Machine_Multi_Autoclave.get(1),
                        ItemList.Circuit_Parts_Crystal_Chip_Wetware.get(16),
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(16))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.MutatedLivingSolder,
                                FluidShapes.fluidMolten,
                                (int) (32 * INGOTS)),
                        MaterialLibAPI
                                .getFluidStack(Materials.EnrichedHolmium, FluidShapes.fluidMolten, (int) (32 * INGOTS)))
                .itemOutputs(ItemList.NanoChipModule_EtchingArray.get(1)).duration(60 * SECONDS).eut(TierEU.RECIPE_UHV)
                .metadata(IGRecipeMaps.MODULE_TIER, 1).addTo(spaceAssemblerRecipes);

        // SMD Processor
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.MeshInterfaceNanochipCasing.get(1),
                        new Object[] { Circuits.UEV.getIngredient(), 4 },
                        ItemList.VacuumConveyorPipe.get(16),
                        ItemList.Conveyor_Module_UEV.get(1),
                        ItemRefer.Precise_Assembler.get(1),
                        GregtechItemList.GT4_Multi_Crafter.get(1),
                        MaterialLibAPI.getStack(Materials.Plastic, Shapes.foil, (int) (64)),
                        ItemList.Circuit_Parts_InductorXSMD.get(64))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.MutatedLivingSolder,
                                FluidShapes.fluidMolten,
                                (int) (32 * INGOTS)),
                        MaterialLibAPI.getFluidStack(Materials.RadoxPoly, FluidShapes.fluidMolten, (int) (32 * INGOTS)))
                .itemOutputs(ItemList.NanoChipModule_SMDProcessor.get(1)).duration(60 * SECONDS).eut(TierEU.RECIPE_UHV)
                .metadata(IGRecipeMaps.MODULE_TIER, 1).addTo(spaceAssemblerRecipes);

        // Board Processor
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.MeshInterfaceNanochipCasing.get(1),
                        new Object[] { Circuits.UEV.getIngredient(), 4 },
                        ItemList.VacuumConveyorPipe.get(16),
                        ItemList.FluidRegulator_UEV.get(1),
                        ItemList.PCBFactory.get(1),
                        ItemList.IndustrialChemicalBath.get(1),
                        ItemList.Circuit_Board_Bio_Ultra.get(16),
                        ItemList.Circuit_Board_Wetware_Extreme.get(16))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.MutatedLivingSolder,
                                FluidShapes.fluidMolten,
                                (int) (32 * INGOTS)),
                        MaterialLibAPI.getFluidStack(Materials.Octiron, FluidShapes.fluidMolten, (int) (32 * INGOTS)))
                .itemOutputs(ItemList.NanoChipModule_BoardProcessor.get(1)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_UHV).metadata(IGRecipeMaps.MODULE_TIER, 1).addTo(spaceAssemblerRecipes);

        // Biological Coordinator
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.MeshInterfaceNanochipCasing.get(1),
                        new Object[] { Circuits.UEV.getIngredient(), 4 },
                        ItemList.VacuumConveyorPipe.get(16),
                        ItemList.Electric_Pump_UEV.get(1),
                        ItemList.PCBBioChamber.get(1),
                        GTUtility.copyAmount(1, ItemRegistry.vat),
                        ItemList.Circuit_Chip_BioCPU.get(16),
                        ItemList.Circuit_Chip_NeuroCPU.get(16))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.MutatedLivingSolder,
                                FluidShapes.fluidMolten,
                                (int) (32 * INGOTS)),
                        MaterialLibAPI.getFluidStack(Materials.Tritanium, FluidShapes.fluidMolten, (int) (32 * INGOTS)))
                .itemOutputs(ItemList.NanoChipModule_BiologicalCoordinator.get(1)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_UHV).metadata(IGRecipeMaps.MODULE_TIER, 1).addTo(spaceAssemblerRecipes);

        // Cutting Chamber
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.MeshInterfaceNanochipCasing.get(1),
                        new Object[] { Circuits.UEV.getIngredient(), 4 },
                        ItemList.VacuumConveyorPipe.get(16),
                        ItemList.Robot_Arm_UEV.get(1),
                        ItemList.Machine_Multi_IndustrialLaserEngraver.get(1),
                        ItemList.IndustrialCuttingMachine.get(1),
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.lens, (int) (1)),
                        NHItemList.ChromaticLens.get(1))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.MutatedLivingSolder,
                                FluidShapes.fluidMolten,
                                (int) (32 * INGOTS)),
                        MaterialLibAPI
                                .getFluidStack(Materials.Neutronium, FluidShapes.fluidMolten, (int) (32 * INGOTS)))
                .itemOutputs(ItemList.NanoChipModule_CuttingChamber.get(1)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_UHV).metadata(IGRecipeMaps.MODULE_TIER, 1).addTo(spaceAssemblerRecipes);

        // Wire Tracer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.MeshInterfaceNanochipCasing.get(1),
                        new Object[] { Circuits.UEV.getIngredient(), 4 },
                        ItemList.VacuumConveyorPipe.get(16),
                        ItemList.Electric_Motor_UEV.get(1),
                        ItemList.IndustrialWireFactory.get(1),
                        ItemList.IndustrialFormingPress.get(1), // forming press specifically
                        GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.Draconium, 16),
                        GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.BlackPlutonium, 16))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.MutatedLivingSolder,
                                FluidShapes.fluidMolten,
                                (int) (32 * INGOTS)),
                        MaterialLibAPI.getFluidStack(
                                Materials.Longasssuperconductornameforuhvwire,
                                FluidShapes.fluidMolten,
                                (int) (32 * INGOTS)))
                .itemOutputs(ItemList.NanoChipModule_WireTracer.get(1)).duration(60 * SECONDS).eut(TierEU.RECIPE_UHV)
                .metadata(IGRecipeMaps.MODULE_TIER, 1).addTo(spaceAssemblerRecipes);

        // Splitter
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.MeshInterfaceNanochipCasing.get(1),
                        new Object[] { Circuits.UEV.getIngredient(), 4 },
                        ItemList.VacuumConveyorPipe.get(16),
                        ItemList.Robot_Arm_UEV.get(1),
                        ItemList.Hatch_VacuumConveyor_Input.get(1),
                        ItemList.Hatch_VacuumConveyor_Output.get(1),
                        ItemList.Automation_ItemDistributor_MAX.get(1),
                        ItemList.Sensor_UEV.get(1))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.MutatedLivingSolder,
                                FluidShapes.fluidMolten,
                                (int) (32 * INGOTS)),
                        MaterialLibAPI.getFluidStack(Materials.Kevlar, FluidShapes.fluidMolten, (int) (32 * INGOTS)))
                .itemOutputs(ItemList.NanoChipModule_Splitter.get(1)).duration(60 * SECONDS).eut(TierEU.RECIPE_UHV)
                .metadata(IGRecipeMaps.MODULE_TIER, 1).addTo(spaceAssemblerRecipes);

        // Superconductor Splitter
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.MeshInterfaceNanochipCasing.get(1),
                        new Object[] { Circuits.UEV.getIngredient(), 4 },
                        ItemList.VacuumConveyorPipe.get(16),
                        ItemList.Emitter_UEV.get(1),
                        ItemList.Machine_Multi_IndustrialElectromagneticSeparator.get(1),
                        ItemList.CryogenicFreezer.get(1),
                        ItemList.Electromagnet_Tengam.get(1),
                        ItemList.Reactor_Coolant_Sp_6.get(1))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.MutatedLivingSolder,
                                FluidShapes.fluidMolten,
                                (int) (32 * INGOTS)),
                        MaterialLibAPI.getFluidStack(Materials.Naquadria, FluidShapes.fluidMolten, (int) (32 * INGOTS)))
                .itemOutputs(ItemList.NanoChipModule_SuperconductorSplitter.get(1)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_UHV).metadata(IGRecipeMaps.MODULE_TIER, 1).addTo(spaceAssemblerRecipes);

        // Optical Organizer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.MeshInterfaceNanochipCasing.get(1),
                        new Object[] { Circuits.UEV.getIngredient(), 4 },
                        ItemList.VacuumConveyorPipe.get(16),
                        ItemList.Electric_Pump_UEV.get(1),
                        ItemList.SpaceElevatorModuleAssemblerT1.get(1),
                        ItemList.Machine_Multi_PurificationPlant.get(1),
                        ItemList.Optically_Perfected_CPU.get(16),
                        ItemList.Optically_Compatible_Memory.get(16))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.MutatedLivingSolder,
                                FluidShapes.fluidMolten,
                                (int) (32 * INGOTS)),
                        MaterialLibAPI.getFluidStack(
                                Materials.DraconiumAwakened,
                                FluidShapes.fluidMolten,
                                (int) (32 * INGOTS)))
                .itemOutputs(ItemList.NanoChipModule_OpticalOrganizer.get(1)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_UHV).metadata(IGRecipeMaps.MODULE_TIER, 1).addTo(spaceAssemblerRecipes);

        // Encasement Wrapper
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.MeshInterfaceNanochipCasing.get(1),
                        new Object[] { Circuits.UEV.getIngredient(), 4 },
                        ItemList.VacuumConveyorPipe.get(16),
                        ItemList.Electric_Piston_UEV.get(1),
                        ItemList.IndustrialPackager.get(1),
                        ItemList.LATEX.get(1),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Tritanium, 16),
                        MaterialLibAPI.getStack(Materials.Polybenzimidazole, Shapes.foil, (int) (64)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.MutatedLivingSolder,
                                FluidShapes.fluidMolten,
                                (int) (32 * INGOTS)),
                        MaterialLibAPI.getFluidStack(Materials.Quantium, FluidShapes.fluidMolten, (int) (32 * INGOTS)))
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
                MaterialLibAPI.getFluidStack(Materials.GrowthMediumSterilized, FluidShapes.fluidLiquid, (int) (50)),
                CircuitComponent.ProcessedNeuroProcessingUnit,
                ModuleRecipeInfo.HighTier,
                20 * SECONDS,
                RecipeMaps.nanochipBiologicalCoordinator);

        // Living Crystal Chip
        addSimpleProcessingRecipe(
                CircuitComponent.ChipLivingCrystal,
                MaterialLibAPI.getFluidStack(Materials.BiohMediumSterilized, FluidShapes.fluidLiquid, (int) (5)),
                CircuitComponent.ProcessedChipLivingCrystal,
                ModuleRecipeInfo.ExtremeTier,
                20 * SECONDS,
                RecipeMaps.nanochipBiologicalCoordinator);

        // Bio Processing Unit
        addSimpleProcessingRecipe(
                CircuitComponent.BioProcessingUnit,
                MaterialLibAPI.getFluidStack(Materials.BiohMediumSterilized, FluidShapes.fluidLiquid, (int) (50)),
                CircuitComponent.ProcessedBioProcessingUnit,
                ModuleRecipeInfo.HighTier,
                30 * SECONDS,
                RecipeMaps.nanochipBiologicalCoordinator);

        // Living Bio Chip
        addSimpleProcessingRecipe(
                CircuitComponent.LivingBioChip,
                MaterialLibAPI.getFluidStack(Materials.BiohMediumSterilized, FluidShapes.fluidLiquid, (int) (50)),
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
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.IronIIIChloride, FluidShapes.fluidLiquid, (int) (0)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(Materials.IronIIIChloride, FluidShapes.fluidLiquid, (int) (0)))
                .itemOutputs(CircuitComponent.ProcessedBoardMultifiberglassElite.getFakeStack(1)).duration(5 * SECONDS)
                .eut(ModuleRecipeInfo.HighTier.recipeEUt).addTo(RecipeMaps.nanochipBoardProcessorRecipes);

        // Wetware Board
        GTValues.RA.stdBuilder().hidden().metadata(BoardProcessingModuleFluidKey.INSTANCE, 2)
                .itemInputs(CircuitComponent.BoardWetwareLifesupport.getFakeStack(1))
                .itemOutputs(CircuitComponent.ProcessedBoardWetwareLifesupport.getFakeStack(1)).duration(10 * SECONDS)
                .eut(ModuleRecipeInfo.HighTier.recipeEUt).addTo(RecipeMaps.nanochipBoardProcessorRecipes);

        // Wetware Board fake recipe
        GTValues.RA.stdBuilder().fake().itemInputs(CircuitComponent.BoardWetwareLifesupport.getFakeStack(1))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.GrowthMediumSterilized, FluidShapes.fluidLiquid, (int) (0)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(Materials.GrowthMediumRaw, FluidShapes.fluidLiquid, (int) (0)))
                .itemOutputs(CircuitComponent.ProcessedBoardWetwareLifesupport.getFakeStack(1)).duration(10 * SECONDS)
                .eut(ModuleRecipeInfo.HighTier.recipeEUt).addTo(RecipeMaps.nanochipBoardProcessorRecipes);

        // Bio Board
        GTValues.RA.stdBuilder().hidden().metadata(BoardProcessingModuleFluidKey.INSTANCE, 3)
                .itemInputs(CircuitComponent.BoardBioMutated.getFakeStack(1))
                .itemOutputs(CircuitComponent.ProcessedBoardBioMutated.getFakeStack(1)).duration(10 * SECONDS)
                .eut(ModuleRecipeInfo.ExtremeTier.recipeEUt).addTo(RecipeMaps.nanochipBoardProcessorRecipes);

        // Bio Board fake recipe
        GTValues.RA.stdBuilder().fake().itemInputs(CircuitComponent.BoardBioMutated.getFakeStack(1)).fluidInputs(
                MaterialLibAPI.getFluidStack(Materials.BiohMediumSterilized, FluidShapes.fluidLiquid, (int) (0)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.BioMediumRaw, FluidShapes.fluidLiquid, (int) (0)))
                .itemOutputs(CircuitComponent.ProcessedBoardBioMutated.getFakeStack(1)).duration(10 * SECONDS)
                .eut(ModuleRecipeInfo.ExtremeTier.recipeEUt).addTo(RecipeMaps.nanochipBoardProcessorRecipes);

        // Optical Board
        GTValues.RA.stdBuilder().hidden().metadata(BoardProcessingModuleFluidKey.INSTANCE, 4)
                .itemInputs(CircuitComponent.BoardOptical.getFakeStack(1))
                .itemOutputs(CircuitComponent.ProcessedBoardOptical.getFakeStack(1)).duration(20 * SECONDS)
                .eut(ModuleRecipeInfo.ExtremeTier.recipeEUt).addTo(RecipeMaps.nanochipBoardProcessorRecipes);

        // Optical Board fake recipe
        GTValues.RA.stdBuilder().fake().itemInputs(CircuitComponent.BoardOptical.getFakeStack(1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.prismaticacid, FluidShapes.fluidLiquid, (int) (0)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.prismaticgas, FluidShapes.fluidLiquid, (int) (0)))
                .itemOutputs(CircuitComponent.ProcessedBoardOptical.getFakeStack(1)).duration(20 * SECONDS)
                .eut(ModuleRecipeInfo.ExtremeTier.recipeEUt).addTo(RecipeMaps.nanochipBoardProcessorRecipes);
    }

    private static void registerCuttingChamberRecipes() {
        // Wafers
        // CPU
        addSimpleProcessingRecipe(
                CircuitComponent.ChipNanoCPU,
                MaterialLibAPI.getFluidStack(Materials.Lubricant, FluidShapes.fluidLiquid, (int) (50)),
                CircuitComponent.ProcessedChipNanoCPU,
                ModuleRecipeInfo.MediumTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // RAM
        addSimpleProcessingRecipe(
                CircuitComponent.ChipRAM,
                MaterialLibAPI.getFluidStack(Materials.Lubricant, FluidShapes.fluidLiquid, (int) (50)),
                CircuitComponent.ProcessedChipRAM,
                ModuleRecipeInfo.MediumTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // NOR
        addSimpleProcessingRecipe(
                CircuitComponent.ChipNOR,
                MaterialLibAPI.getFluidStack(Materials.Lubricant, FluidShapes.fluidLiquid, (int) (50)),
                CircuitComponent.ProcessedChipNOR,
                ModuleRecipeInfo.MediumTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // NAND
        addSimpleProcessingRecipe(
                CircuitComponent.ChipNAND,
                MaterialLibAPI.getFluidStack(Materials.Lubricant, FluidShapes.fluidLiquid, (int) (50)),
                CircuitComponent.ProcessedChipNAND,
                ModuleRecipeInfo.MediumTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // ASoC
        addSimpleProcessingRecipe(
                CircuitComponent.ChipASOC,
                MaterialLibAPI.getFluidStack(Materials.Lubricant, FluidShapes.fluidLiquid, (int) (50)),
                CircuitComponent.ProcessedChipASOC,
                ModuleRecipeInfo.HighTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // PPIC
        addSimpleProcessingRecipe(
                CircuitComponent.ChipPikoPIC,
                MaterialLibAPI.getFluidStack(Materials.Lubricant, FluidShapes.fluidLiquid, (int) (50)),
                CircuitComponent.ProcessedChipPikoPIC,
                ModuleRecipeInfo.HighTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // QPIC
        addSimpleProcessingRecipe(
                CircuitComponent.ChipQuantumPIC,
                MaterialLibAPI.getFluidStack(Materials.Lubricant, FluidShapes.fluidLiquid, (int) (50)),
                CircuitComponent.ProcessedChipQuantumPIC,
                ModuleRecipeInfo.HighTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // APIC
        addSimpleProcessingRecipe(
                CircuitComponent.ChipAttoPIC,
                MaterialLibAPI
                        .getFluidStack(Materials.dimensionallyshiftedsuperfluid, FluidShapes.fluidLiquid, (int) (10)),
                CircuitComponent.ProcessedChipAttoPIC,
                ModuleRecipeInfo.ExtremeTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // ZPIC
        addSimpleProcessingRecipe(
                CircuitComponent.ChipZeptoPIC,
                MaterialLibAPI
                        .getFluidStack(Materials.dimensionallyshiftedsuperfluid, FluidShapes.fluidLiquid, (int) (10)),
                CircuitComponent.ProcessedChipZeptoPIC,
                ModuleRecipeInfo.ExtremeTier,
                10 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // YPIC
        addSimpleProcessingRecipe(
                CircuitComponent.ChipYoctoPIC,
                MaterialLibAPI
                        .getFluidStack(Materials.dimensionallyshiftedsuperfluid, FluidShapes.fluidLiquid, (int) (10)),
                CircuitComponent.ProcessedChipYoctoPIC,
                ModuleRecipeInfo.ExtremeTier,
                20 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // Bolts
        // Enriched Holmium
        addSimpleProcessingRecipe(
                CircuitComponent.BoltEnrichedHolmium,
                MaterialLibAPI.getFluidStack(Materials.Lubricant, FluidShapes.fluidLiquid, (int) (20)),
                CircuitComponent.ProcessedBoltEnrichedHolmium,
                ModuleRecipeInfo.LowTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // Transcendent Metal
        addSimpleProcessingRecipe(
                CircuitComponent.BoltTranscendentMetal,
                MaterialLibAPI.getFluidStack(Materials.Lubricant, FluidShapes.fluidLiquid, (int) (20)),
                CircuitComponent.ProcessedBoltTranscendentMetal,
                ModuleRecipeInfo.LowTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // Yttrium Barium Cuprate
        addSimpleProcessingRecipe(
                CircuitComponent.BoltYttriumBariumCuprate,
                MaterialLibAPI.getFluidStack(Materials.Lubricant, FluidShapes.fluidLiquid, (int) (20)),
                CircuitComponent.ProcessedBoltYttriumBariumCuprate,
                ModuleRecipeInfo.LowTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // Cosmic Neutronium
        addSimpleProcessingRecipe(
                CircuitComponent.BoltCosmicNeutronium,
                MaterialLibAPI.getFluidStack(Materials.Lubricant, FluidShapes.fluidLiquid, (int) (20)),
                CircuitComponent.ProcessedBoltCosmicNeutronium,
                ModuleRecipeInfo.LowTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // Chromatic Glass
        addSimpleProcessingRecipe(
                CircuitComponent.BoltChromaticGlass,
                MaterialLibAPI.getFluidStack(Materials.Lubricant, FluidShapes.fluidLiquid, (int) (20)),
                CircuitComponent.ProcessedBoltChromaticGlass,
                ModuleRecipeInfo.LowTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // SC Base UMV
        addSimpleProcessingRecipe(
                CircuitComponent.BoltUMVSuperconductor,
                MaterialLibAPI.getFluidStack(Materials.Lubricant, FluidShapes.fluidLiquid, (int) (20)),
                CircuitComponent.ProcessedBoltUMVSuperconductor,
                ModuleRecipeInfo.LowTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // White Dwarf Matter
        addSimpleProcessingRecipe(
                CircuitComponent.BoltWhiteDwarfMatter,
                MaterialLibAPI.getFluidStack(Materials.Lubricant, FluidShapes.fluidLiquid, (int) (20)),
                CircuitComponent.ProcessedBoltWhiteDwarfMatter,
                ModuleRecipeInfo.LowTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // Frame box recipes

        // Aluminium
        addSimpleProcessingRecipe(
                CircuitComponent.FrameboxAluminium,
                MaterialLibAPI.getFluidStack(Materials.Grade1PurifiedWater, FluidShapes.fluidLiquid, (int) (500)),
                CircuitComponent.ProcessedFrameboxAluminium,
                ModuleRecipeInfo.HighTier,
                10 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        addSimpleProcessingRecipe(
                CircuitComponent.FrameboxAluminium,
                MaterialLibAPI.getFluidStack(Materials.Grade2PurifiedWater, FluidShapes.fluidLiquid, (int) (250)),
                CircuitComponent.ProcessedFrameboxAluminium,
                ModuleRecipeInfo.HighTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // Tritanium
        addSimpleProcessingRecipe(
                CircuitComponent.FrameboxTritanium,
                MaterialLibAPI.getFluidStack(Materials.Grade3PurifiedWater, FluidShapes.fluidLiquid, (int) (500)),
                CircuitComponent.ProcessedFrameboxTritanium,
                ModuleRecipeInfo.HighTier,
                20 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        addSimpleProcessingRecipe(
                CircuitComponent.FrameboxTritanium,
                MaterialLibAPI.getFluidStack(Materials.Grade4PurifiedWater, FluidShapes.fluidLiquid, (int) (250)),
                CircuitComponent.ProcessedFrameboxTritanium,
                ModuleRecipeInfo.HighTier,
                10 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // Celestial Tungsten
        addSimpleProcessingRecipe(
                CircuitComponent.FrameboxCelestialTungsten,
                MaterialLibAPI.getFluidStack(Materials.Grade5PurifiedWater, FluidShapes.fluidLiquid, (int) (500)),
                CircuitComponent.ProcessedFrameboxCelestialTungsten,
                ModuleRecipeInfo.ExtremeTier,
                20 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        addSimpleProcessingRecipe(
                CircuitComponent.FrameboxCelestialTungsten,
                MaterialLibAPI.getFluidStack(Materials.Grade6PurifiedWater, FluidShapes.fluidLiquid, (int) (250)),
                CircuitComponent.ProcessedFrameboxCelestialTungsten,
                ModuleRecipeInfo.ExtremeTier,
                10 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // Hypogen
        addSimpleProcessingRecipe(
                CircuitComponent.FrameboxHypogen,
                MaterialLibAPI.getFluidStack(Materials.Grade7PurifiedWater, FluidShapes.fluidLiquid, (int) (500)),
                CircuitComponent.ProcessedFrameboxHypogen,
                ModuleRecipeInfo.ExtremeTier,
                40 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        addSimpleProcessingRecipe(
                CircuitComponent.FrameboxHypogen,
                MaterialLibAPI.getFluidStack(Materials.Grade8PurifiedWater, FluidShapes.fluidLiquid, (int) (250)),
                CircuitComponent.ProcessedFrameboxHypogen,
                ModuleRecipeInfo.ExtremeTier,
                20 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // Magmatter
        addSimpleProcessingRecipe(
                CircuitComponent.FrameboxMagMatter,
                MaterialLibAPI.getFluidStack(Materials.Grade8PurifiedWater, FluidShapes.fluidLiquid, (int) (500)),
                CircuitComponent.ProcessedFrameboxMagMatter,
                ModuleRecipeInfo.ExtremeTier,
                40 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        addSimpleProcessingRecipe(
                CircuitComponent.FrameboxMagMatter,
                MaterialLibAPI
                        .getFluidStack(Materials.dimensionallyshiftedsuperfluid, FluidShapes.fluidLiquid, (int) (100)),
                CircuitComponent.ProcessedFrameboxMagMatter,
                ModuleRecipeInfo.ExtremeTier,
                20 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        // Plate recipes
        addSimpleProcessingRecipe(
                CircuitComponent.PlateRhugnor,
                MaterialLibAPI
                        .getFluidStack(Materials.dimensionallyshiftedsuperfluid, FluidShapes.fluidLiquid, (int) (50)),
                CircuitComponent.ProcessedPlateRhugnor,
                ModuleRecipeInfo.HighTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        addSimpleProcessingRecipe(
                CircuitComponent.PlateMetastableOganesson,
                MaterialLibAPI
                        .getFluidStack(Materials.dimensionallyshiftedsuperfluid, FluidShapes.fluidLiquid, (int) (50)),
                CircuitComponent.ProcessedPlateMetastableOganesson,
                ModuleRecipeInfo.ExtremeTier,
                5 * SECONDS,
                RecipeMaps.nanochipCuttingChamber);

        addSimpleProcessingRecipe(
                CircuitComponent.PlateHexanite,
                MaterialLibAPI
                        .getFluidStack(Materials.dimensionallyshiftedsuperfluid, FluidShapes.fluidLiquid, (int) (50)),
                CircuitComponent.ProcessedPlateHexanite,
                ModuleRecipeInfo.ExtremeTier,
                10 * SECONDS,
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
                        CircuitComponent.ProcessedFoilShirabon.getFakeStack(32),
                        CircuitComponent.ProcessedFrameboxHypogen.getFakeStack(2),
                        CircuitComponent.ScrewSixPhasedCopper.getFakeStack(4),
                        CircuitComponent.CasingCreon.getFakeStack(1))
                .itemOutputs(CircuitComponent.ProcessedQuantumCircuitCasing.getFakeStack(1)).duration(20 * SECONDS)
                .eut(ModuleRecipeInfo.ExtremeTier.recipeEUt).addTo(RecipeMaps.nanochipEncasementWrapper);

        // Thermal SC
        GTValues.RA.stdBuilder()
                .itemInputs(
                        CircuitComponent.ThermalSuperconductor.getFakeStack(1),
                        CircuitComponent.ProcessedSuperconductorUMV.getFakeStack(8))
                .itemOutputs(CircuitComponent.ProcessedCoiledThermalSuperconductor.getFakeStack(1))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_UMV).addTo(RecipeMaps.nanochipEncasementWrapper);

        // Planck
        GTValues.RA.stdBuilder()
                .itemInputs(
                        CircuitComponent.ProcessedFoilEternity.getFakeStack(64),
                        CircuitComponent.ProcessedFrameboxMagMatter.getFakeStack(2),
                        CircuitComponent.ScrewUniversium.getFakeStack(2),
                        CircuitComponent.CasingBlackDwarfMatter.getFakeStack(2))
                .itemOutputs(CircuitComponent.ProcessedPlanckCircuitCasing.getFakeStack(1)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_UMV).addTo(RecipeMaps.nanochipEncasementWrapper);

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

        addSimpleProcessingRecipe(
                CircuitComponent.FoilEternity,
                CircuitComponent.ProcessedFoilEternity,
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

        // Hypogen
        addSimpleProcessingRecipe(
                CircuitComponent.WireHypogen,
                CircuitComponent.ProcessedWireHypogen,
                ModuleRecipeInfo.ExtremeTier,
                5 * SECONDS,
                RecipeMaps.nanochipWireTracer);

        // Magmatter
        addSimpleProcessingRecipe(
                CircuitComponent.WireMagMatter,
                CircuitComponent.ProcessedWireMagMatter,
                ModuleRecipeInfo.ExtremeTier,
                10 * SECONDS,
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
                Arrays.asList(MaterialLibAPI.getFluidStack(Materials.Indalloy140, FluidShapes.fluidMolten, (int) (4))),
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
                Arrays.asList(MaterialLibAPI.getFluidStack(Materials.Indalloy140, FluidShapes.fluidMolten, (int) (4))),
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
                Arrays.asList(MaterialLibAPI.getFluidStack(Materials.Indalloy140, FluidShapes.fluidMolten, (int) (9))),
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
                Arrays.asList(MaterialLibAPI.getFluidStack(Materials.Indalloy140, FluidShapes.fluidMolten, (int) (9))),
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
                Arrays.asList(MaterialLibAPI.getFluidStack(Materials.Indalloy140, FluidShapes.fluidMolten, (int) (18))),
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
                Arrays.asList(MaterialLibAPI.getFluidStack(Materials.Indalloy140, FluidShapes.fluidMolten, (int) (4))),
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
                Arrays.asList(MaterialLibAPI.getFluidStack(Materials.Indalloy140, FluidShapes.fluidMolten, (int) (4))),
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
                Arrays.asList(MaterialLibAPI.getFluidStack(Materials.Indalloy140, FluidShapes.fluidMolten, (int) (9))),
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
                Arrays.asList(MaterialLibAPI.getFluidStack(Materials.Indalloy140, FluidShapes.fluidMolten, (int) (9))),
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
                        MaterialLibAPI.getFluidStack(Materials.Indalloy140, FluidShapes.fluidMolten, (int) (2 * INGOTS)),
                        FluidRegistry.getFluidStack("ic2coolant", 10000),
                        MaterialLibAPI.getFluidStack(Materials.Radon, FluidShapes.fluidGas, (int) (2500))),
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
                Arrays.asList(MaterialLibAPI.getFluidStack(Materials.Indalloy140, FluidShapes.fluidMolten, (int) (4))),
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
                Arrays.asList(MaterialLibAPI.getFluidStack(Materials.MutatedLivingSolder, FluidShapes.fluidMolten, (int) (9))),
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
                Arrays.asList(MaterialLibAPI.getFluidStack(Materials.Indalloy140, FluidShapes.fluidMolten, (int) (9))),
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
                        MaterialLibAPI.getFluidStack(Materials.MutatedLivingSolder, FluidShapes.fluidMolten, (int) (10 * INGOTS)),
                        MaterialLibAPI.getFluidStack(Materials.BiohMediumSterilized, FluidShapes.fluidLiquid, (int) (5 * INGOTS)),
                        MaterialLibAPI.getFluidStack(Materials.SuperCoolant, FluidShapes.fluidLiquid, (int) (10000))),
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
                        MaterialLibAPI.getFluidStack(Materials.MutatedLivingSolder, FluidShapes.fluidMolten, (int) (20 * INGOTS)),
                        MaterialLibAPI.getFluidStack(Materials.BiohMediumSterilized, FluidShapes.fluidLiquid, (int) (10 * INGOTS)),
                        MaterialLibAPI.getFluidStack(Materials.SuperCoolant, FluidShapes.fluidLiquid, (int) (20000))),
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
                Arrays.asList(MaterialLibAPI.getFluidStack(Materials.MutatedLivingSolder, FluidShapes.fluidMolten, (int) (18))),
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
                        MaterialLibAPI.getFluidStack(Materials.MutatedLivingSolder, FluidShapes.fluidMolten, (int) (10 * INGOTS)),
                        MaterialLibAPI.getFluidStack(Materials.Radon, FluidShapes.fluidPlasma, (int) (10 * INGOTS)),
                        MaterialLibAPI.getFluidStack(Materials.SuperCoolant, FluidShapes.fluidLiquid, (int) (10000)),
                        MaterialLibAPI.getFluidStack(Materials.Oganesson, FluidShapes.fluidLiquid, (int) (500))),
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
                        MaterialLibAPI.getFluidStack(Materials.MutatedLivingSolder, FluidShapes.fluidMolten, (int) (20 * INGOTS)),
                        MaterialLibAPI.getFluidStack(Materials.Radon, FluidShapes.fluidPlasma, (int) (20 * INGOTS)),
                        MaterialLibAPI.getFluidStack(Materials.SuperCoolant, FluidShapes.fluidLiquid, (int) (20000)),
                        MaterialLibAPI.getFluidStack(Materials.Oganesson, FluidShapes.fluidLiquid, (int) (1000))),
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
                        MaterialLibAPI.getFluidStack(Materials.MutatedLivingSolder, FluidShapes.fluidMolten, (int) (40 * INGOTS)),
                        MaterialLibAPI.getFluidStack(Materials.Radon, FluidShapes.fluidPlasma, (int) (40 * INGOTS)),
                        MaterialLibAPI.getFluidStack(Materials.SuperCoolant, FluidShapes.fluidLiquid, (int) (40000)),
                        MaterialLibAPI.getFluidStack(Materials.Oganesson, FluidShapes.fluidLiquid, (int) (2000))),
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
                        new CircuitComponentStack(CircuitComponent.ProcessedPlateRhugnor, 2),
                        new CircuitComponentStack(CircuitComponent.OpticalMainframe, 2),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipAttoPIC, 8),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDInductor, 48),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDCapacitor, 48),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDResistor, 48),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDTransistor, 48),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDDiode, 48),
                        new CircuitComponentStack(CircuitComponent.ProcessedWireProtoHalkonite, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedBoltTranscendentMetal, 32),
                        new CircuitComponentStack(CircuitComponent.ProcessedWireInfinity, 8)),
                Arrays.asList(
                        MaterialLibAPI.getFluidStack(Materials.MutatedLivingSolder, FluidShapes.fluidMolten, (int) (16 * INGOTS)),
                        MaterialUtils.fluid(Materials.UUMatter, 8000),
                        MaterialLibAPI.getFluidStack(Materials.PreciousMetalsAlloy, FluidShapes.fluidMolten, (int) (8 * INGOTS))),
                CircuitComponent.PicoCircuit,
                250 * SECONDS,
                TierEU.RECIPE_MAX,
                VoltageIndex.UEV);

        addAssemblyMatrixRecipe(
                Arrays.asList(
                        new CircuitComponentStack(CircuitComponent.ProcessedQuantumCircuitCasing, 1),
                        new CircuitComponentStack(CircuitComponent.ProcessedPlateMetastableOganesson, 2),
                        new CircuitComponentStack(CircuitComponent.PicoCircuit, 2),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipZeptoPIC, 8),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDInductor, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDCapacitor, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDResistor, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDTransistor, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDDiode, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedWireProtoHalkonite, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedBoltUMVSuperconductor, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedWireSpacetime, 8)),
                Arrays.asList(
                        MaterialLibAPI.getFluidStack(Materials.MutatedLivingSolder, FluidShapes.fluidMolten, (int) (32 * INGOTS)),
                        MaterialUtils.fluid(Materials.UUMatter, 24000),
                        MaterialLibAPI.getFluidStack(Materials.PreciousMetalsAlloy, FluidShapes.fluidMolten, (int) (16 * INGOTS))),
                CircuitComponent.QuantumCircuit,
                500 * SECONDS,
                TierEU.RECIPE_MAX,
                VoltageIndex.UIV);

        addAssemblyMatrixRecipe(
                Arrays.asList(
                        new CircuitComponentStack(CircuitComponent.ProcessedFrameboxHypogen, 2),
                        new CircuitComponentStack(CircuitComponent.ProcessedBoardOptical, 16),
                        new CircuitComponentStack(CircuitComponent.ProcessedWireMagMatter, 8),
                        new CircuitComponentStack(CircuitComponent.ProcessedPlateHexanite, 8),
                        new CircuitComponentStack(CircuitComponent.CasingEternity, 4),
                        new CircuitComponentStack(CircuitComponent.ProcessedFoilShirabon, 64)),
                Arrays.asList(
                        MaterialLibAPI.getFluidStack(Materials.BoundlessCosmicSolder, FluidShapes.fluidLiquid, (int) (1000)),
                        MaterialLibAPI.getFluidStack(Materials.RadoxPoly, FluidShapes.fluidMolten, (int) (16 * INGOTS)),
                        MaterialLibAPI.getFluidStack(Materials.PrimordialMatter, FluidShapes.fluidLiquid, (int) (1000)),
                        MaterialLibAPI.getFluidStack(Materials.ExcitedDTSC, FluidShapes.fluidLiquid, (int) (4000))),
                CircuitComponent.PlanckManifold,
                50 * SECONDS,
                TierEU.RECIPE_MAX,
                VoltageIndex.UMV);

        addAssemblyMatrixRecipe(
                Arrays.asList(
                        new CircuitComponentStack(CircuitComponent.ProcessedPlanckCircuitCasing, 1),
                        new CircuitComponentStack(CircuitComponent.PlanckManifold, 1),
                        new CircuitComponentStack(CircuitComponent.QuantumCircuit, 2),
                        new CircuitComponentStack(CircuitComponent.ProcessedChipYoctoPIC, 8),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDInductor, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDCapacitor, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDResistor, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDTransistor, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedOpticalSMDDiode, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedWireHypogen, 64),
                        new CircuitComponentStack(CircuitComponent.ProcessedBoltWhiteDwarfMatter, 32),
                        new CircuitComponentStack(CircuitComponent.ProcessedCoiledThermalSuperconductor, 8)),
                Arrays.asList(
                        MaterialLibAPI.getFluidStack(Materials.BoundlessCosmicSolder, FluidShapes.fluidLiquid, (int) (4000)),
                        MaterialLibAPI.getFluidStack(Materials.PrimordialMatter, FluidShapes.fluidLiquid, (int) (4000)),
                        MaterialLibAPI.getFluidStack(Materials.spatialFluid, FluidShapes.fluidMolten, (int) (4000)),
                        MaterialLibAPI.getFluidStack(Materials.PhononMedium, FluidShapes.fluidLiquid, (int) (1000))),
                CircuitComponent.PlanckCircuit,
                1000 * SECONDS,
                TierEU.RECIPE_MAX,
                VoltageIndex.UMV);
    }
    // spotless:on
}
