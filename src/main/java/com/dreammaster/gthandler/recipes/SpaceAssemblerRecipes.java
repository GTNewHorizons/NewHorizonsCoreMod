package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.AE2FluidCraft;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.EternalSingularity;
import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.SuperSolarPanels;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicEnergistics;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.WILDCARD;
import static kekztech.common.Blocks.tfftStorageField;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.ruling_0.materiallib.api.MaterialLibAPI;

import goodgenerator.loader.Loaders;
import gregtech.api.enums.Circuits;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials.FluidShapes;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;
import gregtech.api.util.GTOreDictUnificator;
import gtnhintergalactic.recipe.IGRecipeMaps;
import tectech.thing.CustomItemList;
import tectech.thing.casing.TTCasingsContainer;

public class SpaceAssemblerRecipes implements Runnable {

    @Override
    public void run() {

        Fluid solderUEV = FluidRegistry.getFluid("molten.mutatedlivingsolder") != null
                ? FluidRegistry.getFluid("molten.mutatedlivingsolder")
                : FluidRegistry.getFluid("molten.solderingalloy");

        Fluid solderIndalloy = FluidRegistry.getFluid("molten.indalloy140") != null
                ? FluidRegistry.getFluid("molten.indalloy140")
                : FluidRegistry.getFluid("molten.solderingalloy");

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Emitter_UHV.get(1),
                        getModItem(IndustrialCraft2.ID, "blockGenerator", 16, 5),
                        getModItem(IndustrialCraft2.ID, "blockGenerator", 16, 5),
                        ItemList.Emitter_UHV.get(1),
                        MaterialLibAPI.getStack(Materials.protohalkonite, Shapes.plate, 8),
                        ItemList.EnergisedTesseract.get(1),
                        ItemList.EnergisedTesseract.get(1),
                        MaterialLibAPI.getStack(Materials.protohalkonite, Shapes.plate, 8),
                        MaterialLibAPI.getStack(Materials.protohalkonite, Shapes.plate, 8),
                        ItemList.EnergisedTesseract.get(1),
                        ItemList.EnergisedTesseract.get(1),
                        MaterialLibAPI.getStack(Materials.protohalkonite, Shapes.plate, 8),
                        ItemList.Emitter_UHV.get(1),
                        getModItem(IndustrialCraft2.ID, "blockGenerator", 16, 5),
                        getModItem(IndustrialCraft2.ID, "blockGenerator", 16, 5),
                        ItemList.Emitter_UHV.get(1))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.Plutonium, FluidShapes.fluidMolten, 64 * 144),
                        MaterialLibAPI
                                .getFluidStack(Materials.AtomicSeparationCatalyst, FluidShapes.fluidMolten, 64 * 144),
                        MaterialLibAPI.getFluidStack(Materials.Tartarite, FluidShapes.fluidMolten, 64 * 144),
                        MaterialLibAPI.getFluidStack(
                                Materials.Longasssuperconductornameforuvwire,
                                FluidShapes.fluidMolten,
                                64 * 144))
                .itemOutputs(ItemList.Black_Hole_Opener.get(1)).metadata(IGRecipeMaps.MODULE_TIER, 1)
                .duration(120 * SECONDS).eut(TierEU.RECIPE_UHV).addTo(IGRecipeMaps.spaceAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Sensor_UHV.get(1),
                        MaterialLibAPI.getStack(Materials.Naquadria, Shapes.plateDense, 16),
                        MaterialLibAPI.getStack(Materials.Naquadria, Shapes.plateDense, 16),
                        ItemList.Sensor_UHV.get(1),
                        MaterialLibAPI.getStack(Materials.protohalkonite, Shapes.plate, 8),
                        ItemList.Tesseract.get(1),
                        ItemList.Tesseract.get(1),
                        MaterialLibAPI.getStack(Materials.protohalkonite, Shapes.plate, 8),
                        MaterialLibAPI.getStack(Materials.protohalkonite, Shapes.plate, 8),
                        ItemList.Tesseract.get(1),
                        ItemList.Tesseract.get(1),
                        MaterialLibAPI.getStack(Materials.protohalkonite, Shapes.plate, 8),
                        ItemList.Sensor_UHV.get(1),
                        MaterialLibAPI.getStack(Materials.Naquadria, Shapes.plateDense, 16),
                        MaterialLibAPI.getStack(Materials.Naquadria, Shapes.plateDense, 16),
                        ItemList.Sensor_UHV.get(1))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.Longasssuperconductornameforuhvwire,
                                FluidShapes.fluidMolten,
                                64 * 144),
                        MaterialLibAPI.getFluidStack(Materials.Osmiridium, FluidShapes.fluidMolten, 64 * 144),
                        MaterialLibAPI.getFluidStack(Materials.Ledox, FluidShapes.fluidMolten, 64 * 144),
                        MaterialLibAPI.getFluidStack(Materials.CallistoIce, FluidShapes.fluidMolten, 64 * 144))
                .itemOutputs(ItemList.Black_Hole_Closer.get(1)).metadata(IGRecipeMaps.MODULE_TIER, 1)
                .duration(120 * SECONDS).eut(TierEU.RECIPE_UHV).addTo(IGRecipeMaps.spaceAssemblerRecipes);

        // Optically Perfected CPU
        GTValues.RA.stdBuilder()
                .itemInputs(
                        gregtech.api.enums.ItemList.Circuit_Chip_Optical.get(1L),
                        ItemList.Optical_Cpu_Containment_Housing.get(1L),
                        MaterialLibAPI.getStack(Materials.InfinityCatalyst, Shapes.screw, 4),
                        MaterialLibAPI.getStack(Materials.CosmicNeutronium, Shapes.screw, 4),
                        MaterialLibAPI.getStack(Materials.Draconium, Shapes.wireFine, 4),
                        CustomItemList.DATApipe.get(1L),
                        MaterialLibAPI.getStack(Materials.AtomicSeparationCatalyst, Shapes.screw, 4),
                        MaterialLibAPI.getStack(Materials.PreciousMetalsAlloy, Shapes.screw, 4))
                .fluidInputs(new FluidStack(solderUEV, 288)).itemOutputs(ItemList.Optically_Perfected_CPU.get(1L))
                .metadata(IGRecipeMaps.MODULE_TIER, 1).duration(20 * SECONDS).eut(TierEU.RECIPE_UHV)
                .addTo(IGRecipeMaps.spaceAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Chip_Optical.get(4L),
                        ItemList.Optical_Cpu_Containment_Housing.get(4L),
                        MaterialLibAPI.getStack(Materials.Longasssuperconductornameforuhvwire, Shapes.screw, 8),
                        MaterialLibAPI.getStack(Materials.TengamAttuned, Shapes.screw, 8),
                        MaterialLibAPI.getStack(Materials.DraconiumAwakened, Shapes.wireFine, 8),
                        CustomItemList.DATApipe.get(4L),
                        MaterialLibAPI.getStack(Materials.PreciousMetalsAlloy, Shapes.screw, 8),
                        // Enriched Naquadah Alloy screw
                        MaterialLibAPI.getStack(Materials.EnrichedNaquadahAlloy, Shapes.screw, 8))
                .fluidInputs(new FluidStack(solderUEV, 576)).itemOutputs(ItemList.Optically_Perfected_CPU.get(4L))
                .metadata(IGRecipeMaps.MODULE_TIER, 2).duration(20 * SECONDS).eut(TierEU.RECIPE_UEV)
                .addTo(IGRecipeMaps.spaceAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Chip_Optical.get(16L),
                        ItemList.Optical_Cpu_Containment_Housing.get(16L),
                        MaterialLibAPI.getStack(Materials.CelestialTungsten, Shapes.screw, 16),
                        MaterialLibAPI.getStack(Materials.SpaceTime, Shapes.screw, 16),
                        MaterialLibAPI.getStack(Materials.Tritanium, Shapes.wireFine, 16),
                        CustomItemList.DATApipe.get(16L),
                        // Enriched Naquadah Alloy screw
                        MaterialLibAPI.getStack(Materials.EnrichedNaquadahAlloy, Shapes.screw, 16),
                        // Shirabon screw
                        MaterialLibAPI.getStack(Materials.Shirabon, Shapes.screw, 16))
                .fluidInputs(new FluidStack(solderUEV, 1152)).itemOutputs(ItemList.Optically_Perfected_CPU.get(16L))
                .metadata(IGRecipeMaps.MODULE_TIER, 2).duration(20 * SECONDS).eut(TierEU.RECIPE_UIV)
                .addTo(IGRecipeMaps.spaceAssemblerRecipes);

        // Alternate Energy Orb Cluster Recipe
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Multifiberglass.get(1L),
                        MaterialLibAPI.getStack(Materials.NaquadahAlloy, Shapes.foil, 64),
                        Circuits.LuV.get(4),
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(8L),
                        ItemList.Circuit_Chip_HPIC.get(64L),
                        ItemList.Circuit_Parts_DiodeASMD.get(8L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(8L),
                        ItemList.Circuit_Parts_ResistorASMD.get(8L),
                        ItemList.Circuit_Parts_TransistorASMD.get(8L),
                        MaterialLibAPI.getStack(Materials.Platinum, Shapes.wireFine, 64))
                .fluidInputs(new FluidStack(solderIndalloy, 720)).itemOutputs(ItemList.Energy_LapotronicOrb2.get(1))
                .metadata(IGRecipeMaps.MODULE_TIER, 1).duration(50 * SECONDS).eut(TierEU.RECIPE_ZPM)
                .addTo(IGRecipeMaps.spaceAssemblerRecipes);

        // Alternate Energy Module Recipe
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Wetware_Extreme.get(1),
                        MaterialLibAPI.getStack(Materials.Bedrockium, Shapes.foil, 64),
                        Circuits.ZPM.get(4),
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                        ItemList.Circuit_Chip_UHPIC.get(64L),
                        ItemList.Circuit_Parts_DiodeXSMD.get(8L),
                        ItemList.Circuit_Parts_CapacitorXSMD.get(8L),
                        ItemList.Circuit_Parts_ResistorXSMD.get(8L),
                        ItemList.Circuit_Parts_TransistorXSMD.get(8L),
                        GTOreDictUnificator.get("wireFineHypogen", 48))
                .fluidInputs(new FluidStack(solderUEV, 720)).itemOutputs(ItemList.Energy_Module.get(1))
                .metadata(IGRecipeMaps.MODULE_TIER, 1).duration(50 * SECONDS).eut(TierEU.RECIPE_UV)
                .addTo(IGRecipeMaps.spaceAssemblerRecipes);

        // Advanced Radiation Proof Plate
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Lanthanum, Shapes.plate, 32),
                        MaterialLibAPI.getStack(Materials.ElectrumFlux, Shapes.plate, 16),
                        MaterialLibAPI.getStack(Materials.Trinium, Shapes.plate, 16),
                        MaterialLibAPI.getStack(Materials.NaquadahAlloy, Shapes.plate, 64),
                        MaterialLibAPI.getStack(Materials.NaquadahAlloy, Shapes.plate, 16),
                        MaterialLibAPI.getStack(Materials.Osmiridium, Shapes.plate, 16),
                        MaterialLibAPI.getStack(Materials.VibrantAlloy, Shapes.plate, 16),
                        ItemList.Radiation_Proof_Prismatic_Naquadah_Composite_Sheet.get(16L))
                .fluidInputs(
                        new FluidStack(solderIndalloy, (32 * 144)),
                        MaterialLibAPI.getFluidStack(Materials.Lead, FluidShapes.fluidMolten, (int) (64 * 144L)))
                .itemOutputs(new ItemStack(Loaders.advancedRadiationProtectionPlate, 4, 0))
                .metadata(IGRecipeMaps.MODULE_TIER, 1).duration(50 * SECONDS).eut(TierEU.RECIPE_ZPM)
                .addTo(IGRecipeMaps.spaceAssemblerRecipes);

        // Alternate Energy Cluster Recipe
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Bio_Ultra.get(1),
                        MaterialLibAPI.getStack(Materials.CosmicNeutronium, Shapes.foil, 64),
                        Circuits.UV.get(4),
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                        ItemList.Circuit_Chip_NPIC.get(64L),
                        ItemList.Circuit_Parts_DiodeXSMD.get(32L),
                        ItemList.Circuit_Parts_CapacitorXSMD.get(32L),
                        ItemList.Circuit_Parts_ResistorXSMD.get(32L),
                        ItemList.Circuit_Parts_TransistorXSMD.get(32L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SpaceTime, 12L))
                .fluidInputs(new FluidStack(solderUEV, 1440)).itemOutputs(ItemList.Energy_Cluster.get(1))
                .metadata(IGRecipeMaps.MODULE_TIER, 1).duration(50 * SECONDS).eut(TierEU.RECIPE_UHV)
                .addTo(IGRecipeMaps.spaceAssemblerRecipes);

        // Alternate Ultimate Battery Recipe
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Optical.get(1),
                        GTOreDictUnificator.get("foilShirabon", 64),
                        Circuits.UHV.get(4),
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                        ItemList.Circuit_Chip_PPIC.get(64L),
                        ItemList.Circuit_Parts_DiodeXSMD.get(64L),
                        ItemList.Circuit_Parts_CapacitorXSMD.get(64L),
                        ItemList.Circuit_Parts_ResistorXSMD.get(64L),
                        ItemList.Circuit_Parts_TransistorXSMD.get(64L),
                        MaterialLibAPI.getStack(Materials.Hexanite, Shapes.bolt, 4))
                .fluidInputs(
                        new FluidStack(solderUEV, 2880),
                        MaterialLibAPI.getFluidStack(Materials.WhiteDwarfMatter, FluidShapes.fluidMolten, 144),
                        MaterialLibAPI.getFluidStack(Materials.RawStarMatter, FluidShapes.fluidLiquid, 500))
                .itemOutputs(ItemList.ZPM2.get(1)).metadata(IGRecipeMaps.MODULE_TIER, 2).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_UEV).addTo(IGRecipeMaps.spaceAssemblerRecipes);

        // Alternate Really Ultimate Battery Recipe
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Optical.get(8),
                        MaterialLibAPI.getStack(Materials.Hexanite, Shapes.foil, 64),
                        Circuits.UEV.get(4),
                        ItemList.Wrap_EngravedLapotrionChips.get(8),
                        ItemList.Wrap_EngravedLapotrionChips.get(8),
                        ItemList.Wrap_EngravedLapotrionChips.get(8),
                        ItemList.Wrap_EngravedLapotrionChips.get(8),
                        ItemList.Wrap_EngravedLapotrionChips.get(8),
                        ItemList.Wrap_EngravedLapotrionChips.get(8),
                        ItemList.Wrap_EngravedLapotrionChips.get(8),
                        ItemList.Circuit_Chip_QPIC.get(64L),
                        ItemList.Wrap_OpticalSMDDiodes.get(8),
                        ItemList.Wrap_OpticalSMDCapacitors.get(8),
                        ItemList.Wrap_OpticalSMDResistors.get(8),
                        ItemList.Wrap_OpticalSMDTransistors.get(8),
                        MaterialLibAPI.getStack(Materials.MagnetohydrodynamicallyConstrainedStarMatter, Shapes.bolt, 2))
                .fluidInputs(
                        new FluidStack(solderUEV, 2880),
                        MaterialLibAPI.getFluidStack(Materials.Magmatter, FluidShapes.fluidMolten, 576),
                        MaterialLibAPI.getFluidStack(Materials.Eternity, FluidShapes.fluidMolten, 576))
                .itemOutputs(ItemList.ZPM3.get(1)).metadata(IGRecipeMaps.MODULE_TIER, 3).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_UXV).addTo(IGRecipeMaps.spaceAssemblerRecipes);

        if (OpenComputers.isModLoaded() && SuperSolarPanels.isModLoaded()) {
            // Optically Compatible Memory
            GTValues.RA.stdBuilder().itemInputs(
                    getModItem(OpenComputers.ID, "item", 1, 39), // Memory tier 3.5
                    ItemList.Circuit_Chip_Optical.get(1L),
                    CustomItemList.DATApipe.get(4L),
                    GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUEV, 4),
                    MaterialLibAPI.getStack(Materials.Infinity, Shapes.screw, 8),
                    getModItem(SuperSolarPanels.ID, "solarsplitter", 1, 0)) // Solar Light Splitter
                    .fluidInputs(new FluidStack(solderUEV, 288))
                    .itemOutputs(ItemList.Optically_Compatible_Memory.get(2)).metadata(IGRecipeMaps.MODULE_TIER, 1)
                    .duration(20 * SECONDS).eut(TierEU.RECIPE_UHV).addTo(IGRecipeMaps.spaceAssemblerRecipes);

            GTValues.RA.stdBuilder().itemInputs(
                    getModItem(OpenComputers.ID, "item", 4, 39), // Memory tier 3.5
                    ItemList.Circuit_Chip_Optical.get(1L),
                    CustomItemList.DATApipe.get(16L),
                    GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUIV, 4),
                    MaterialLibAPI.getStack(Materials.Infinity, Shapes.screw, 16),
                    getModItem(SuperSolarPanels.ID, "solarsplitter", 4, 0)) // Solar Light Splitter
                    .fluidInputs(new FluidStack(solderUEV, 576))
                    .itemOutputs(ItemList.Optically_Compatible_Memory.get(8)).metadata(IGRecipeMaps.MODULE_TIER, 2)
                    .duration(20 * SECONDS).eut(TierEU.RECIPE_UEV).addTo(IGRecipeMaps.spaceAssemblerRecipes);

            GTValues.RA.stdBuilder().itemInputs(
                    getModItem(OpenComputers.ID, "item", 16, 39), // Memory tier 3.5
                    ItemList.Circuit_Chip_Optical.get(1L),
                    CustomItemList.DATApipe.get(64L),
                    GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUMV, 4),
                    MaterialLibAPI.getStack(Materials.Infinity, Shapes.screw, 32),
                    getModItem(SuperSolarPanels.ID, "solarsplitter", 16, 0)) // Solar Light Splitter
                    .fluidInputs(new FluidStack(solderUEV, 1152))
                    .itemOutputs(ItemList.Optically_Compatible_Memory.get(32)).metadata(IGRecipeMaps.MODULE_TIER, 2)
                    .duration(20 * SECONDS).eut(TierEU.RECIPE_UIV).addTo(IGRecipeMaps.spaceAssemblerRecipes);
        }

        if (OpenComputers.isModLoaded()) {
            // Memory Tier 3.5
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Multifiberglass_Elite.get(4),
                            ItemList.Circuit_Chip_Ram.get(64),
                            ItemList.Circuit_Chip_SoC.get(64),
                            ItemList.Circuit_Chip_NAND.get(64),
                            Circuits.ZPM.get(2),
                            MaterialLibAPI.getStack(Materials.VanadiumGallium, Shapes.foil, 64))
                    .fluidInputs(new FluidStack(solderIndalloy, 1152))
                    .itemOutputs(getModItem(OpenComputers.ID, "item", 64, 39)).metadata(IGRecipeMaps.MODULE_TIER, 1)
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_UV).addTo(IGRecipeMaps.spaceAssemblerRecipes);
        }

        if (AppliedEnergistics2.isModLoaded() && AE2FluidCraft.isModLoaded()) {
            // Non-oredicted circuit was intended.
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1),
                            getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1, 3),
                            getModItem(AppliedEnergistics2.ID, "tile.BlockAdvancedCraftingStorage", 1, 3),
                            ItemList.Robot_Arm_UHV.get(16),
                            ItemList.Circuit_OpticalProcessor.get(16),
                            MaterialLibAPI.getStack(Materials.Aluminium, Shapes.bolt, 4),
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 500))
                    .fluidInputs(new FluidStack(solderUEV, 9216))
                    .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockPatternOptimizationMatrix", 1))
                    .metadata(IGRecipeMaps.MODULE_TIER, 1).duration(5 * MINUTES).eut(TierEU.RECIPE_UHV)
                    .addTo(IGRecipeMaps.spaceAssemblerRecipes);

            // Advanced Stocking Input Hatch (ME)
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Hatch_Input_Multi_2x2_UHV.get(4L),
                            getModItem(AE2FluidCraft.ID, "fluid_interface", 1),
                            ItemList.Circuit_Chip_BioCPU.get(1),
                            ItemList.Electric_Pump_UHV.get(1L),
                            // 16384k Me Fluid Storage Component
                            getModItem(AE2FluidCraft.ID, "fluid_part", 4, 7),
                            // Hyper-Acceleration Card
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4, 56))
                    .fluidInputs(new FluidStack(solderUEV, 2304)).itemOutputs(ItemList.Hatch_Input_ME_Advanced.get(1))
                    .metadata(IGRecipeMaps.MODULE_TIER, 1).duration(15 * SECONDS).eut(TierEU.RECIPE_UHV)
                    .addTo(IGRecipeMaps.spaceAssemblerRecipes);

            // Crafting Input Buffer (ME)
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Hatch_CraftingInput_Bus_ME_ItemOnly.get(1),
                            ItemList.Hatch_Input_Multi_2x2_UEV.get(1),
                            // 16384k storage component
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 8, 60),
                            // 16384k Me Fluid Storage Component
                            getModItem(AE2FluidCraft.ID, "fluid_part", 8, 7),
                            // ME Controller
                            getModItem(AppliedEnergistics2.ID, "tile.BlockController", 1, WILDCARD),
                            // Dual Interface
                            getModItem(AE2FluidCraft.ID, "part_fluid_interface", 1, WILDCARD),
                            // Pattern capacity card
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 3, 54))
                    .fluidInputs(
                            new FluidStack(solderUEV, 2304),
                            MaterialLibAPI.getFluidStack(Materials.Grade7PurifiedWater, FluidShapes.fluidLiquid, 4000))
                    .itemOutputs(ItemList.Hatch_CraftingInput_Bus_ME.get(1)).metadata(IGRecipeMaps.MODULE_TIER, 1)
                    .duration(15 * SECONDS).eut(TierEU.RECIPE_UHV).addTo(IGRecipeMaps.spaceAssemblerRecipes);

            // Crafting Input Proxy
            GTValues.RA.stdBuilder().itemInputs(
                    ItemList.Hatch_CraftingInput_Bus_ME.get(1),
                    // 64 Core Co-Processing Unit
                    getModItem(AppliedEnergistics2.ID, "tile.BlockAdvancedCraftingUnit", 1, 0),
                    // 16384k storage component
                    getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 8, 60),
                    // 16384k Me Fluid Storage Component
                    getModItem(AE2FluidCraft.ID, "fluid_part", 8, 7),
                    // Wireless Connector
                    getModItem(AppliedEnergistics2.ID, "tile.BlockWirelessConnector", 2, 0),
                    ItemList.Sensor_UEV.get(1),
                    ItemList.EnergisedTesseract.get(1))
                    .fluidInputs(
                            new FluidStack(solderUEV, 2304),
                            MaterialLibAPI.getFluidStack(
                                    Materials.dimensionallyshiftedsuperfluid,
                                    FluidShapes.fluidLiquid,
                                    4000))
                    .itemOutputs(ItemList.Hatch_CraftingInput_Bus_Slave.get(1)).metadata(IGRecipeMaps.MODULE_TIER, 2)
                    .duration(15 * SECONDS).eut(TierEU.RECIPE_UIV).addTo(IGRecipeMaps.spaceAssemblerRecipes);
        }

        if (AppliedEnergistics2.isModLoaded()) {
            // Artificial Universe Cell
            ItemStack filledUMVCell = ItemList.ZPM6.get(1L);
            NBTTagCompound euNBT = filledUMVCell.getTagCompound();
            if (euNBT != null) {
                euNBT.setLong("GT.ItemCharge", 9223372036854775807L);
            } else {
                euNBT = new NBTTagCompound();
                euNBT.setLong("GT.ItemCharge", 9223372036854775807L);
                filledUMVCell.setTagCompound(euNBT);
            }

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(AppliedEnergistics2.ID, "item.ItemExtremeStorageCell.Singularity", 1),
                            MaterialLibAPI.getStack(Materials.TranscendentMetal, Shapes.plateDense, 64),
                            ItemList.Field_Generator_UXV.get(1L),
                            filledUMVCell,
                            new ItemStack(TTCasingsContainer.SpacetimeCompressionFieldGenerators, 4, 8),
                            GTOreDictUnificator.get(OrePrefixes.nanite, Materials.Magmatter, 1),
                            GTOreDictUnificator.get(OrePrefixes.nanite, Materials.Eternity, 1))
                    .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Eternity, FluidShapes.fluidMolten, 36864))
                    .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemExtremeStorageCell.Universe", 1))
                    .metadata(IGRecipeMaps.MODULE_TIER, 3).nbtSensitive().duration(1 * MINUTES).eut(TierEU.RECIPE_UXV)
                    .addTo(IGRecipeMaps.spaceAssemblerRecipes);

            // Digital Singularity ME Storage Cell
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(EternalSingularity.ID, "eternal_singularity", 1),
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 12, 60),
                            ItemList.Quantum_Chest_IV.get(8L),
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.Infinity, 4L),
                            getModItem(Avaritia.ID, "Resource", 4, 5),
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.CosmicNeutronium, 12L))
                    .fluidInputs(new FluidStack(solderUEV, 2304))
                    .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemExtremeStorageCell.Singularity", 1))
                    .metadata(IGRecipeMaps.MODULE_TIER, 1).duration(10 * SECONDS).eut(TierEU.RECIPE_UHV)
                    .addTo(IGRecipeMaps.spaceAssemblerRecipes);
        }

        if (AE2FluidCraft.isModLoaded()) {
            // Artificial Fluid Universe Cell
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(AE2FluidCraft.ID, "fluid_storage.singularity", 1),
                            GTOreDictUnificator.get("plateDenseShirabon", 16),
                            ItemList.Field_Generator_UXV.get(1L),
                            new ItemStack(Loaders.yottaFluidTankCell, 2, 9),
                            new ItemStack(tfftStorageField, 2, 10),
                            new ItemStack(TTCasingsContainer.SpacetimeCompressionFieldGenerators, 4, 8),
                            GTOreDictUnificator.get(OrePrefixes.nanite, Materials.Magmatter, 1),
                            GTOreDictUnificator.get(OrePrefixes.nanite, Materials.Eternity, 1))
                    .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Eternity, FluidShapes.fluidMolten, 36864))
                    .itemOutputs(getModItem(AE2FluidCraft.ID, "fluid_storage.Universe", 1))
                    .metadata(IGRecipeMaps.MODULE_TIER, 3).duration(1 * MINUTES).eut(TierEU.RECIPE_UXV)
                    .addTo(IGRecipeMaps.spaceAssemblerRecipes);

            // ME Fluid Digital Singularity Storage Cell
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(EternalSingularity.ID, "eternal_singularity", 1),
                            getModItem(AE2FluidCraft.ID, "fluid_part", 12, 7),
                            ItemList.Quantum_Tank_IV.get(8L),
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.Infinity, 4L),
                            getModItem(Avaritia.ID, "Resource", 4, 5),
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.CosmicNeutronium, 12L))
                    .fluidInputs(new FluidStack(solderUEV, 2304))
                    .itemOutputs(getModItem(AE2FluidCraft.ID, "fluid_storage.singularity", 1, 0))
                    .metadata(IGRecipeMaps.MODULE_TIER, 1).duration(10 * SECONDS).eut(TierEU.RECIPE_UHV)
                    .addTo(IGRecipeMaps.spaceAssemblerRecipes);

            // ME Essentia Digital Singularity Storage Cell
            if (ThaumicEnergistics.isModLoaded()) {
                GTValues.RA.stdBuilder()
                        .itemInputs(
                                getModItem(EternalSingularity.ID, "eternal_singularity", 1),
                                getModItem(ThaumicEnergistics.ID, "storage.component", 12, 8),
                                getModItem(Thaumcraft.ID, "blockEssentiaReservoir", 8, 0),
                                GTOreDictUnificator.get(OrePrefixes.block, Materials.Infinity, 4L),
                                getModItem(Avaritia.ID, "Resource", 4, 5),
                                GTOreDictUnificator.get(OrePrefixes.block, Materials.CosmicNeutronium, 12L))
                        .fluidInputs(new FluidStack(solderUEV, 2304))
                        .itemOutputs(getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 10))
                        .metadata(IGRecipeMaps.MODULE_TIER, 1).duration(10 * SECONDS).eut(TierEU.RECIPE_UHV)
                        .addTo(IGRecipeMaps.spaceAssemblerRecipes);
            }
        }

        if (Avaritia.isModLoaded()) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.CompressorUV.get(1),
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.CosmicNeutronium, 12L),
                            MaterialLibAPI.getStack(Materials.Bedrockium, Shapes.plateSuperdense, 2),
                            MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.plateSuperdense, 2),
                            MaterialLibAPI.getStack(Materials.CosmicNeutronium, Shapes.plateQuadruple, 8),
                            MaterialLibAPI.getStack(Materials.Neutronium, Shapes.plate, 4),
                            getModItem(Avaritia.ID, "Resource", 20, 1),
                            ItemList.Electric_Motor_UV.get(4),
                            ItemList.Electric_Piston_UV.get(8),
                            ItemList.Conveyor_Module_UV.get(8),
                            Circuits.UHV.get(4))
                    .fluidInputs(new FluidStack(solderIndalloy, 2304))
                    .itemOutputs(ItemList.Machine_Multi_NeutroniumCompressor.get(1))
                    .metadata(IGRecipeMaps.MODULE_TIER, 1).duration(10 * SECONDS).eut(TierEU.RECIPE_UHV)
                    .addTo(IGRecipeMaps.spaceAssemblerRecipes);
        }
        if (OpenComputers.isModLoaded()) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(OpenComputers.ID, "case3", 1, 0),
                            getModItem(OpenComputers.ID, "item", 2, 103),
                            Circuits.UV.get(2),
                            Circuits.LuV.get(16),
                            Circuits.IV.get(4))
                    .fluidInputs(new FluidStack(solderIndalloy, 2304))
                    .itemOutputs(getModItem(OpenComputers.ID, "item", 1, 69)).metadata(IGRecipeMaps.MODULE_TIER, 1)
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_UV).addTo(IGRecipeMaps.spaceAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(OpenComputers.ID, "item", 1, 90),
                            ItemList.Electric_Motor_LuV.get(4L),
                            MaterialLibAPI.getStack(Materials.RhodiumPlatedPalladium, Shapes.turbineBlade, 6),
                            getModItem(HardcoreEnderExpansion.ID, "biome_compass", 2, 0),
                            Circuits.UV.get(2),
                            Circuits.LuV.get(6),
                            Circuits.IV.get(4))
                    .fluidInputs(new FluidStack(solderIndalloy, 2304))
                    .itemOutputs(getModItem(OpenComputers.ID, "item", 1, 91)).metadata(IGRecipeMaps.MODULE_TIER, 1)
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_UV).addTo(IGRecipeMaps.spaceAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 6),
                            getModItem(IndustrialCraft2.ID, "itemRTGPellet", 2, 0),
                            GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Obsidian, 12L),
                            Circuits.UV.get(2),
                            Circuits.LuV.get(2),
                            Circuits.IV.get(4),
                            GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.Electrum, 2L))
                    .fluidInputs(new FluidStack(solderIndalloy, 2304))
                    .itemOutputs(getModItem(OpenComputers.ID, "item", 1, 90)).metadata(IGRecipeMaps.MODULE_TIER, 1)
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_UV).addTo(IGRecipeMaps.spaceAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(OpenComputers.ID, "item", 1, 43),
                            getModItem(OpenComputers.ID, "item", 1, 102),
                            getModItem(OpenComputers.ID, "item", 1, 10),
                            Circuits.UV.get(2),
                            Circuits.LuV.get(4),
                            Circuits.IV.get(16))
                    .fluidInputs(new FluidStack(solderIndalloy, 2304))
                    .itemOutputs(getModItem(OpenComputers.ID, "item", 1, 103)).metadata(IGRecipeMaps.MODULE_TIER, 1)
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_UV).addTo(IGRecipeMaps.spaceAssemblerRecipes);
        }
    }
}
