package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.AE2FluidCraft;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.EternalSingularity;
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
import gregtech.api.enums.Superconductors;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2FluidShapes;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;
import gregtech.api.material.MU;
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
                        MaterialLibAPI.getStack(Materials2Materials.protohalkonite, Materials2Shapes.plate, (int) (8)),
                        ItemList.EnergisedTesseract.get(1),
                        ItemList.EnergisedTesseract.get(1),
                        MaterialLibAPI.getStack(Materials2Materials.protohalkonite, Materials2Shapes.plate, (int) (8)),
                        MaterialLibAPI.getStack(Materials2Materials.protohalkonite, Materials2Shapes.plate, (int) (8)),
                        ItemList.EnergisedTesseract.get(1),
                        ItemList.EnergisedTesseract.get(1),
                        MaterialLibAPI.getStack(Materials2Materials.protohalkonite, Materials2Shapes.plate, (int) (8)),
                        ItemList.Emitter_UHV.get(1),
                        getModItem(IndustrialCraft2.ID, "blockGenerator", 16, 5),
                        getModItem(IndustrialCraft2.ID, "blockGenerator", 16, 5),
                        ItemList.Emitter_UHV.get(1))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Plutonium,
                                Materials2FluidShapes.fluidMolten,
                                (int) (64 * 144)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.AtomicSeparationCatalyst,
                                Materials2FluidShapes.fluidMolten,
                                (int) (64 * 144)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Tartarite,
                                Materials2FluidShapes.fluidMolten,
                                (int) (64 * 144)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Longasssuperconductornameforuvwire,
                                Materials2FluidShapes.fluidMolten,
                                (int) (64 * 144)))
                .itemOutputs(ItemList.Black_Hole_Opener.get(1)).metadata(IGRecipeMaps.MODULE_TIER, 1)
                .duration(120 * SECONDS).eut(TierEU.RECIPE_UHV).addTo(IGRecipeMaps.spaceAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Sensor_UHV.get(1),
                        MaterialLibAPI.getStack(Materials2Materials.Naquadria, Materials2Shapes.plateDense, (int) (16)),
                        MaterialLibAPI.getStack(Materials2Materials.Naquadria, Materials2Shapes.plateDense, (int) (16)),
                        ItemList.Sensor_UHV.get(1),
                        MaterialLibAPI.getStack(Materials2Materials.protohalkonite, Materials2Shapes.plate, (int) (8)),
                        ItemList.Tesseract.get(1),
                        ItemList.Tesseract.get(1),
                        MaterialLibAPI.getStack(Materials2Materials.protohalkonite, Materials2Shapes.plate, (int) (8)),
                        MaterialLibAPI.getStack(Materials2Materials.protohalkonite, Materials2Shapes.plate, (int) (8)),
                        ItemList.Tesseract.get(1),
                        ItemList.Tesseract.get(1),
                        MaterialLibAPI.getStack(Materials2Materials.protohalkonite, Materials2Shapes.plate, (int) (8)),
                        ItemList.Sensor_UHV.get(1),
                        MaterialLibAPI.getStack(Materials2Materials.Naquadria, Materials2Shapes.plateDense, (int) (16)),
                        MaterialLibAPI.getStack(Materials2Materials.Naquadria, Materials2Shapes.plateDense, (int) (16)),
                        ItemList.Sensor_UHV.get(1))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Longasssuperconductornameforuhvwire,
                                Materials2FluidShapes.fluidMolten,
                                (int) (64 * 144)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Osmiridium,
                                Materials2FluidShapes.fluidMolten,
                                (int) (64 * 144)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Ledox,
                                Materials2FluidShapes.fluidMolten,
                                (int) (64 * 144)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.CallistoIce,
                                Materials2FluidShapes.fluidMolten,
                                (int) (64 * 144)))
                .itemOutputs(ItemList.Black_Hole_Closer.get(1)).metadata(IGRecipeMaps.MODULE_TIER, 1)
                .duration(120 * SECONDS).eut(TierEU.RECIPE_UHV).addTo(IGRecipeMaps.spaceAssemblerRecipes);

        // Optically Perfected CPU
        GTValues.RA.stdBuilder().itemInputs(
                gregtech.api.enums.ItemList.Circuit_Chip_Optical.get(1L),
                ItemList.Optical_Cpu_Containment_Housing.get(1L),
                MaterialLibAPI.getStack(Materials2Materials.InfinityCatalyst, Materials2Shapes.screw, (int) (4L)),
                MaterialLibAPI.getStack(Materials2Materials.CosmicNeutronium, Materials2Shapes.screw, (int) (4L)),
                MaterialLibAPI.getStack(Materials2Materials.Draconium, Materials2Shapes.wireFine, (int) (4L)),
                CustomItemList.DATApipe.get(1L),
                MaterialLibAPI
                        .getStack(Materials2Materials.AtomicSeparationCatalyst, Materials2Shapes.screw, (int) (4)),
                MaterialLibAPI.getStack(Materials2Materials.PreciousMetalsAlloy, Materials2Shapes.screw, (int) (4)))
                .fluidInputs(new FluidStack(solderUEV, 288)).itemOutputs(ItemList.Optically_Perfected_CPU.get(1L))
                .metadata(IGRecipeMaps.MODULE_TIER, 1).duration(20 * SECONDS).eut(TierEU.RECIPE_UHV)
                .addTo(IGRecipeMaps.spaceAssemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                ItemList.Circuit_Chip_Optical.get(4L),
                ItemList.Optical_Cpu_Containment_Housing.get(4L),
                MaterialLibAPI.getStack(
                        Materials2Materials.Longasssuperconductornameforuhvwire,
                        Materials2Shapes.screw,
                        (int) (8L)),
                MaterialLibAPI.getStack(Materials2Materials.TengamAttuned, Materials2Shapes.screw, (int) (8L)),
                MaterialLibAPI.getStack(Materials2Materials.DraconiumAwakened, Materials2Shapes.wireFine, (int) (8L)),
                CustomItemList.DATApipe.get(4L),
                MaterialLibAPI.getStack(Materials2Materials.PreciousMetalsAlloy, Materials2Shapes.screw, (int) (8)),
                // Enriched Naquadah Alloy screw
                MaterialLibAPI.getStack(Materials2Materials.EnrichedNaquadahAlloy, Materials2Shapes.screw, (int) (8)))
                .fluidInputs(new FluidStack(solderUEV, 576)).itemOutputs(ItemList.Optically_Perfected_CPU.get(4L))
                .metadata(IGRecipeMaps.MODULE_TIER, 2).duration(20 * SECONDS).eut(TierEU.RECIPE_UEV)
                .addTo(IGRecipeMaps.spaceAssemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                ItemList.Circuit_Chip_Optical.get(16L),
                ItemList.Optical_Cpu_Containment_Housing.get(16L),
                MaterialLibAPI.getStack(Materials2Materials.CelestialTungsten, Materials2Shapes.screw, (int) (16)),
                MaterialLibAPI.getStack(Materials2Materials.SpaceTime, Materials2Shapes.screw, (int) (16L)),
                MaterialLibAPI.getStack(Materials2Materials.Tritanium, Materials2Shapes.wireFine, (int) (16L)),
                CustomItemList.DATApipe.get(16L),
                // Enriched Naquadah Alloy screw
                MaterialLibAPI.getStack(Materials2Materials.EnrichedNaquadahAlloy, Materials2Shapes.screw, (int) (16)),
                // Shirabon screw
                MaterialLibAPI.getStack(Materials2Materials.Shirabon, Materials2Shapes.screw, (int) (16)))
                .fluidInputs(new FluidStack(solderUEV, 1152)).itemOutputs(ItemList.Optically_Perfected_CPU.get(16L))
                .metadata(IGRecipeMaps.MODULE_TIER, 2).duration(20 * SECONDS).eut(TierEU.RECIPE_UIV)
                .addTo(IGRecipeMaps.spaceAssemblerRecipes);

        // Alternate Energy Orb Cluster Recipe
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Multifiberglass.get(1L),
                        MaterialLibAPI.getStack(Materials2Materials.NaquadahAlloy, Materials2Shapes.foil, (int) (64L)),
                        GTOreDictUnificator.get(Circuits.LuV.getIngredient(), 4L),
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(8L),
                        ItemList.Circuit_Chip_HPIC.get(64L),
                        ItemList.Circuit_Parts_DiodeASMD.get(8L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(8L),
                        ItemList.Circuit_Parts_ResistorASMD.get(8L),
                        ItemList.Circuit_Parts_TransistorASMD.get(8L),
                        MaterialLibAPI.getStack(Materials2Materials.Platinum, Materials2Shapes.wireFine, (int) (64)))
                .fluidInputs(new FluidStack(solderIndalloy, 720)).itemOutputs(ItemList.Energy_LapotronicOrb2.get(1))
                .metadata(IGRecipeMaps.MODULE_TIER, 1).duration(50 * SECONDS).eut(TierEU.RECIPE_ZPM)
                .addTo(IGRecipeMaps.spaceAssemblerRecipes);

        // Alternate Energy Module Recipe
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Wetware_Extreme.get(1),
                        MaterialLibAPI.getStack(Materials2Materials.Bedrockium, Materials2Shapes.foil, (int) (64L)),
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
                        MaterialLibAPI.getStack(Materials2Materials.Lanthanum, Materials2Shapes.plate, (int) (32L)),
                        MaterialLibAPI.getStack(Materials2Materials.ElectrumFlux, Materials2Shapes.plate, (int) (16L)),
                        MaterialLibAPI.getStack(Materials2Materials.Trinium, Materials2Shapes.plate, (int) (16L)),
                        MaterialLibAPI.getStack(Materials2Materials.NaquadahAlloy, Materials2Shapes.plate, (int) (64L)),
                        MaterialLibAPI.getStack(Materials2Materials.NaquadahAlloy, Materials2Shapes.plate, (int) (16L)),
                        MaterialLibAPI.getStack(Materials2Materials.Osmiridium, Materials2Shapes.plate, (int) (16L)),
                        MaterialLibAPI.getStack(Materials2Materials.VibrantAlloy, Materials2Shapes.plate, (int) (16L)),
                        ItemList.Radiation_Proof_Prismatic_Naquadah_Composite_Sheet.get(16L))
                .fluidInputs(
                        new FluidStack(solderIndalloy, (32 * 144)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Lead,
                                Materials2FluidShapes.fluidMolten,
                                (int) (64 * 144L)))
                .itemOutputs(new ItemStack(Loaders.advancedRadiationProtectionPlate, 4, 0))
                .metadata(IGRecipeMaps.MODULE_TIER, 1).duration(50 * SECONDS).eut(TierEU.RECIPE_ZPM)
                .addTo(IGRecipeMaps.spaceAssemblerRecipes);

        // Alternate Energy Cluster Recipe
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Bio_Ultra.get(1),
                        MaterialLibAPI
                                .getStack(Materials2Materials.CosmicNeutronium, Materials2Shapes.foil, (int) (64L)),
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
                        GTOreDictUnificator
                                .get(OrePrefixes.wireGt01, MU.materialOf(Materials2Materials.SpaceTime), 12L))
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
                        MaterialLibAPI.getStack(Materials2Materials.Hexanite, Materials2Shapes.bolt, (int) (4L)))
                .fluidInputs(
                        new FluidStack(solderUEV, 2880),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.WhiteDwarfMatter,
                                Materials2FluidShapes.fluidMolten,
                                (int) (576)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.BlackDwarfMatter,
                                Materials2FluidShapes.fluidMolten,
                                (int) (576)))
                .itemOutputs(ItemList.ZPM2.get(1)).metadata(IGRecipeMaps.MODULE_TIER, 2).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_UEV).addTo(IGRecipeMaps.spaceAssemblerRecipes);

        // Alternate Really Ultimate Battery Recipe
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Optical.get(8),
                        MaterialLibAPI.getStack(Materials2Materials.Hexanite, Materials2Shapes.foil, (int) (64)),
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
                        MaterialLibAPI.getStack(
                                Materials2Materials.MagnetohydrodynamicallyConstrainedStarMatter,
                                Materials2Shapes.bolt,
                                (int) (2)))
                .fluidInputs(
                        new FluidStack(solderUEV, 2880),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Magmatter,
                                Materials2FluidShapes.fluidMolten,
                                (int) (576)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Eternity,
                                Materials2FluidShapes.fluidMolten,
                                (int) (576)))
                .itemOutputs(ItemList.ZPM3.get(1)).metadata(IGRecipeMaps.MODULE_TIER, 3).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_UXV).addTo(IGRecipeMaps.spaceAssemblerRecipes);

        if (OpenComputers.isModLoaded() && SuperSolarPanels.isModLoaded()) {
            // Optically Compatible Memory
            GTValues.RA.stdBuilder().itemInputs(
                    getModItem(OpenComputers.ID, "item", 1, 39), // Memory tier 3.5
                    ItemList.Circuit_Chip_Optical.get(1L),
                    CustomItemList.DATApipe.get(4L),
                    Superconductors.UEV.getWireGt01(4),
                    MaterialLibAPI.getStack(Materials2Materials.Infinity, Materials2Shapes.screw, (int) (8L)),
                    getModItem(SuperSolarPanels.ID, "solarsplitter", 1, 0)) // Solar Light Splitter
                    .fluidInputs(new FluidStack(solderUEV, 288))
                    .itemOutputs(ItemList.Optically_Compatible_Memory.get(2)).metadata(IGRecipeMaps.MODULE_TIER, 1)
                    .duration(20 * SECONDS).eut(TierEU.RECIPE_UHV).addTo(IGRecipeMaps.spaceAssemblerRecipes);

            GTValues.RA.stdBuilder().itemInputs(
                    getModItem(OpenComputers.ID, "item", 4, 39), // Memory tier 3.5
                    ItemList.Circuit_Chip_Optical.get(1L),
                    CustomItemList.DATApipe.get(16L),
                    Superconductors.UIV.getWireGt01(4),
                    MaterialLibAPI.getStack(Materials2Materials.Infinity, Materials2Shapes.screw, (int) (16L)),
                    getModItem(SuperSolarPanels.ID, "solarsplitter", 4, 0)) // Solar Light Splitter
                    .fluidInputs(new FluidStack(solderUEV, 576))
                    .itemOutputs(ItemList.Optically_Compatible_Memory.get(8)).metadata(IGRecipeMaps.MODULE_TIER, 2)
                    .duration(20 * SECONDS).eut(TierEU.RECIPE_UEV).addTo(IGRecipeMaps.spaceAssemblerRecipes);

            GTValues.RA.stdBuilder().itemInputs(
                    getModItem(OpenComputers.ID, "item", 16, 39), // Memory tier 3.5
                    ItemList.Circuit_Chip_Optical.get(1L),
                    CustomItemList.DATApipe.get(64L),
                    Superconductors.UMV.getWireGt01(4),
                    MaterialLibAPI.getStack(Materials2Materials.Infinity, Materials2Shapes.screw, (int) (32L)),
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
                            MaterialLibAPI
                                    .getStack(Materials2Materials.VanadiumGallium, Materials2Shapes.foil, (int) (64L)))
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
                            MaterialLibAPI.getStack(Materials2Materials.Aluminium, Materials2Shapes.bolt, (int) (4L)),
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
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Grade7PurifiedWater,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (4000)))
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
                                    Materials2Materials.dimensionallyshiftedsuperfluid,
                                    Materials2FluidShapes.fluidLiquid,
                                    (int) (4000)))
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

            GTValues.RA.stdBuilder().itemInputs(
                    getModItem(AppliedEnergistics2.ID, "item.ItemExtremeStorageCell.Singularity", 1),
                    MaterialLibAPI
                            .getStack(Materials2Materials.TranscendentMetal, Materials2Shapes.plateDense, (int) (64L)),
                    ItemList.Field_Generator_UXV.get(1L),
                    filledUMVCell,
                    new ItemStack(TTCasingsContainer.SpacetimeCompressionFieldGenerators, 4, 8),
                    GTOreDictUnificator.get(OrePrefixes.nanite, MU.materialOf(Materials2Materials.Magmatter), 4),
                    GTOreDictUnificator.get(OrePrefixes.nanite, MU.materialOf(Materials2Materials.Eternity), 4))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Eternity,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (36864)))
                    .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemExtremeStorageCell.Universe", 1))
                    .metadata(IGRecipeMaps.MODULE_TIER, 3).nbtSensitive().duration(1 * MINUTES).eut(TierEU.RECIPE_UXV)
                    .addTo(IGRecipeMaps.spaceAssemblerRecipes);

            // Digital Singularity ME Storage Cell
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(EternalSingularity.ID, "eternal_singularity", 1),
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 12, 60),
                            ItemList.Quantum_Chest_IV.get(8L),
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Infinity), 4L),
                            getModItem(Avaritia.ID, "Resource", 4, 5),
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.CosmicNeutronium), 12L))
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
                            GTOreDictUnificator
                                    .get(OrePrefixes.nanite, MU.materialOf(Materials2Materials.Magmatter), 4),
                            GTOreDictUnificator.get(OrePrefixes.nanite, MU.materialOf(Materials2Materials.Eternity), 4))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Eternity,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (36864)))
                    .itemOutputs(getModItem(AE2FluidCraft.ID, "fluid_storage.Universe", 1))
                    .metadata(IGRecipeMaps.MODULE_TIER, 3).duration(1 * MINUTES).eut(TierEU.RECIPE_UXV)
                    .addTo(IGRecipeMaps.spaceAssemblerRecipes);

            // ME Fluid Digital Singularity Storage Cell
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(EternalSingularity.ID, "eternal_singularity", 1),
                            getModItem(AE2FluidCraft.ID, "fluid_part", 12, 7),
                            ItemList.Quantum_Tank_IV.get(8L),
                            GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Infinity), 4L),
                            getModItem(Avaritia.ID, "Resource", 4, 5),
                            GTOreDictUnificator
                                    .get(OrePrefixes.block, MU.materialOf(Materials2Materials.CosmicNeutronium), 12L))
                    .fluidInputs(new FluidStack(solderUEV, 2304))
                    .itemOutputs(getModItem(AE2FluidCraft.ID, "fluid_storage.singularity", 1, 0))
                    .metadata(IGRecipeMaps.MODULE_TIER, 1).duration(10 * SECONDS).eut(TierEU.RECIPE_UHV)
                    .addTo(IGRecipeMaps.spaceAssemblerRecipes);

            // ME Essentia Digital Singularity Storage Cell
            if (ThaumicEnergistics.isModLoaded()) {
                GTValues.RA.stdBuilder().itemInputs(
                        getModItem(EternalSingularity.ID, "eternal_singularity", 1),
                        getModItem(ThaumicEnergistics.ID, "storage.component", 12, 8),
                        getModItem(Thaumcraft.ID, "blockEssentiaReservoir", 8, 0),
                        GTOreDictUnificator.get(OrePrefixes.block, MU.materialOf(Materials2Materials.Infinity), 4L),
                        getModItem(Avaritia.ID, "Resource", 4, 5),
                        GTOreDictUnificator
                                .get(OrePrefixes.block, MU.materialOf(Materials2Materials.CosmicNeutronium), 12L))
                        .fluidInputs(new FluidStack(solderUEV, 2304))
                        .itemOutputs(getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 10))
                        .metadata(IGRecipeMaps.MODULE_TIER, 1).duration(10 * SECONDS).eut(TierEU.RECIPE_UHV)
                        .addTo(IGRecipeMaps.spaceAssemblerRecipes);
            }
        }

        if (Avaritia.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(
                    ItemList.CompressorUV.get(1),
                    GTOreDictUnificator
                            .get(OrePrefixes.block, MU.materialOf(Materials2Materials.CosmicNeutronium), 12L),
                    MaterialLibAPI
                            .getStack(Materials2Materials.Bedrockium, Materials2Shapes.plateSuperdense, (int) (2L)),
                    MaterialLibAPI
                            .getStack(Materials2Materials.BlackPlutonium, Materials2Shapes.plateSuperdense, (int) (2L)),
                    MaterialLibAPI.getStack(
                            Materials2Materials.CosmicNeutronium,
                            Materials2Shapes.plateQuadruple,
                            (int) (8L)),
                    MaterialLibAPI.getStack(Materials2Materials.Neutronium, Materials2Shapes.plate, (int) (4L)),
                    getModItem(Avaritia.ID, "Resource", 20, 1),
                    ItemList.Electric_Motor_UV.get(4),
                    ItemList.Electric_Piston_UV.get(8),
                    ItemList.Conveyor_Module_UV.get(8),
                    Circuits.UHV.get(4)).fluidInputs(new FluidStack(solderIndalloy, 2304))
                    .itemOutputs(ItemList.Machine_Multi_NeutroniumCompressor.get(1))
                    .metadata(IGRecipeMaps.MODULE_TIER, 1).duration(10 * SECONDS).eut(TierEU.RECIPE_UHV)
                    .addTo(IGRecipeMaps.spaceAssemblerRecipes);
        }
    }
}
