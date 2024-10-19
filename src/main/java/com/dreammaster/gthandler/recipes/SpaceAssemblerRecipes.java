package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.AE2FluidCraft;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.EternalSingularity;
import static gregtech.api.enums.Mods.GTNHIntergalactic;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.SuperSolarPanels;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicEnergistics;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static kekztech.common.Blocks.tfftStorageField;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.gtnewhorizons.gtnhintergalactic.recipe.IG_RecipeAdder;

import goodgenerator.items.GGMaterial;
import goodgenerator.loader.Loaders;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gtPlusPlus.core.material.MaterialsElements;
import tectech.thing.CustomItemList;
import tectech.thing.casing.TTCasingsContainer;

public class SpaceAssemblerRecipes implements Runnable {

    @Override
    public void run() {
        if (GTNHIntergalactic.isModLoaded()) {

            Fluid solderUEV = FluidRegistry.getFluid("molten.mutatedlivingsolder") != null
                    ? FluidRegistry.getFluid("molten.mutatedlivingsolder")
                    : FluidRegistry.getFluid("molten.solderingalloy");

            Fluid solderIndalloy = FluidRegistry.getFluid("molten.indalloy140") != null
                    ? FluidRegistry.getFluid("molten.indalloy140")
                    : FluidRegistry.getFluid("molten.solderingalloy");

            IG_RecipeAdder.addSpaceAssemblerRecipe(
                    new ItemStack[] { ItemList.Emitter_UHV.get(1),
                            GTModHandler.getModItem(IndustrialCraft2.ID, "blockGenerator", 16, 5),
                            GTModHandler.getModItem(IndustrialCraft2.ID, "blockGenerator", 16, 5),
                            ItemList.Emitter_UHV.get(1),
                            GTOreDictUnificator.get(OrePrefixes.plate, MaterialsUEVplus.ProtoHalkonite, 8),
                            ItemList.EnergisedTesseract.get(1), ItemList.EnergisedTesseract.get(1),
                            GTOreDictUnificator.get(OrePrefixes.plate, MaterialsUEVplus.ProtoHalkonite, 8),
                            GTOreDictUnificator.get(OrePrefixes.plate, MaterialsUEVplus.ProtoHalkonite, 8),
                            ItemList.EnergisedTesseract.get(1), ItemList.EnergisedTesseract.get(1),
                            GTOreDictUnificator.get(OrePrefixes.plate, MaterialsUEVplus.ProtoHalkonite, 8),
                            ItemList.Emitter_UHV.get(1),
                            GTModHandler.getModItem(IndustrialCraft2.ID, "blockGenerator", 16, 5),
                            GTModHandler.getModItem(IndustrialCraft2.ID, "blockGenerator", 16, 5),
                            ItemList.Emitter_UHV.get(1), },
                    new FluidStack[] { Materials.Plutonium.getMolten(64 * 144),
                            GGMaterial.atomicSeparationCatalyst.getMolten(64 * 144),
                            Materials.Tartarite.getMolten(64 * 144),
                            Materials.Longasssuperconductornameforuvwire.getMolten(64 * 144), },
                    ItemList.Black_Hole_Opener.get(1),
                    1,
                    120 * SECONDS,
                    (int) TierEU.RECIPE_UHV,
                    null,
                    null);
            IG_RecipeAdder.addSpaceAssemblerRecipe(
                    new ItemStack[] { ItemList.Sensor_UHV.get(1),
                            GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Naquadria, 16),
                            GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Naquadria, 16),
                            ItemList.Sensor_UHV.get(1),
                            GTOreDictUnificator.get(OrePrefixes.plate, MaterialsUEVplus.ProtoHalkonite, 8),
                            ItemList.Tesseract.get(1), ItemList.Tesseract.get(1),
                            GTOreDictUnificator.get(OrePrefixes.plate, MaterialsUEVplus.ProtoHalkonite, 8),
                            GTOreDictUnificator.get(OrePrefixes.plate, MaterialsUEVplus.ProtoHalkonite, 8),
                            ItemList.Tesseract.get(1), ItemList.Tesseract.get(1),
                            GTOreDictUnificator.get(OrePrefixes.plate, MaterialsUEVplus.ProtoHalkonite, 8),
                            ItemList.Sensor_UHV.get(1),
                            GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Naquadria, 16),
                            GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Naquadria, 16),
                            ItemList.Sensor_UHV.get(1), },
                    new FluidStack[] { Materials.Longasssuperconductornameforuhvwire.getMolten(64 * 144),
                            Materials.Osmiridium.getMolten(64 * 144), Materials.Ledox.getMolten(64 * 144),
                            Materials.CallistoIce.getMolten(64 * 144), },
                    ItemList.Black_Hole_Closer.get(1),
                    1,
                    120 * SECONDS,
                    (int) TierEU.RECIPE_UHV,
                    null,
                    null);

            // Optically Perfected CPU
            IG_RecipeAdder.addSpaceAssemblerRecipe(
                    new ItemStack[] { gregtech.api.enums.ItemList.Circuit_Chip_Optical.get(1L),
                            ItemList.Optical_Cpu_Containment_Housing.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.screw, Materials.InfinityCatalyst, 4L),
                            GTOreDictUnificator.get(OrePrefixes.screw, Materials.CosmicNeutronium, 4L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Draconium, 4L),
                            CustomItemList.DATApipe.get(1L),
                            GGMaterial.atomicSeparationCatalyst.get(OrePrefixes.screw, 4),
                            GGMaterial.preciousMetalAlloy.get(OrePrefixes.screw, 4) },
                    new FluidStack[] { new FluidStack(solderUEV, 288) },
                    ItemList.Optically_Perfected_CPU.get(1L),
                    1,
                    20 * 20,
                    (int) TierEU.RECIPE_UHV,
                    null,
                    null);

            IG_RecipeAdder.addSpaceAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Chip_Optical.get(4L),
                            ItemList.Optical_Cpu_Containment_Housing.get(4L),
                            GTOreDictUnificator
                                    .get(OrePrefixes.screw, Materials.Longasssuperconductornameforuhvwire, 8L),
                            GTOreDictUnificator.get(OrePrefixes.screw, Materials.TengamAttuned, 8L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.DraconiumAwakened, 8L),
                            CustomItemList.DATApipe.get(4L), GGMaterial.preciousMetalAlloy.get(OrePrefixes.screw, 8),
                            // Enriched Naquadah Alloy screw
                            GGMaterial.enrichedNaquadahAlloy.get(OrePrefixes.screw, 8) },
                    new FluidStack[] { new FluidStack(solderUEV, 576) },
                    ItemList.Optically_Perfected_CPU.get(4L),
                    2,
                    20 * 20,
                    (int) TierEU.RECIPE_UEV,
                    null,
                    null);

            IG_RecipeAdder.addSpaceAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Chip_Optical.get(16L),
                            ItemList.Optical_Cpu_Containment_Housing.get(16L),
                            MaterialsElements.STANDALONE.CELESTIAL_TUNGSTEN.getScrew(16),
                            GTOreDictUnificator.get(OrePrefixes.screw, MaterialsUEVplus.SpaceTime, 16L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Tritanium, 16L),
                            CustomItemList.DATApipe.get(16L),
                            // Enriched Naquadah Alloy screw
                            GGMaterial.enrichedNaquadahAlloy.get(OrePrefixes.screw, 16),
                            // Shirabon screw
                            GGMaterial.shirabon.get(OrePrefixes.screw, 16) },
                    new FluidStack[] { new FluidStack(solderUEV, 1152) },
                    ItemList.Optically_Perfected_CPU.get(16L),
                    2,
                    20 * 20,
                    (int) TierEU.RECIPE_UIV,
                    null,
                    null);

            // Alternate Energy Orb Cluster Recipe
            IG_RecipeAdder.addSpaceAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Multifiberglass.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.foil, Materials.NaquadahAlloy, 64L),
                            GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.LuV), 4L),
                            ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                            ItemList.Circuit_Parts_Crystal_Chip_Master.get(8L), ItemList.Circuit_Chip_HPIC.get(64L),
                            ItemList.Circuit_Parts_DiodeASMD.get(8L), ItemList.Circuit_Parts_CapacitorASMD.get(8L),
                            ItemList.Circuit_Parts_ResistorASMD.get(8L), ItemList.Circuit_Parts_TransistorASMD.get(8L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 64) },
                    new FluidStack[] { new FluidStack(solderIndalloy, 720) },
                    ItemList.Energy_LapotronicOrb2.get(1),
                    1,
                    50 * 20,
                    (int) TierEU.RECIPE_ZPM,
                    null,
                    null);

            // Alternate Energy Module Recipe
            IG_RecipeAdder.addSpaceAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Wetware_Extreme.get(1),
                            GTOreDictUnificator.get(OrePrefixes.foil, Materials.Bedrockium, 64L),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ZPM, 4L),
                            ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                            ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L), ItemList.Circuit_Chip_UHPIC.get(64L),
                            ItemList.Circuit_Parts_DiodeXSMD.get(8L), ItemList.Circuit_Parts_CapacitorXSMD.get(8L),
                            ItemList.Circuit_Parts_ResistorXSMD.get(8L), ItemList.Circuit_Parts_TransistorXSMD.get(8L),
                            GTOreDictUnificator.get("wireFineHypogen", 48), },
                    new FluidStack[] { new FluidStack(solderUEV, 720) },
                    ItemList.Energy_Module.get(1),
                    1,
                    50 * 20,
                    (int) TierEU.RECIPE_UV,
                    null,
                    null);

            // Advanced Radiation Proof Plate
            IG_RecipeAdder.addSpaceAssemblerRecipe(
                    new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.plate, Materials.Lanthanum, 32L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.ElectrumFlux, 16L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Trinium, 16L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 64L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 16L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Osmiridium, 16L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 16L) },
                    new FluidStack[] { new FluidStack(solderIndalloy, (32 * 144)),
                            Materials.Lead.getMolten(64 * 144L) },
                    new ItemStack(Loaders.advancedRadiationProtectionPlate, 4, 0),
                    1,
                    50 * 20,
                    (int) TierEU.RECIPE_ZPM,
                    null,
                    null);

            // Alternate Energy Cluster Recipe
            IG_RecipeAdder.addSpaceAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Bio_Ultra.get(1),
                            GTOreDictUnificator.get(OrePrefixes.foil, Materials.CosmicNeutronium, 64L),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UV, 4L),
                            ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                            ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                            ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                            ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L), ItemList.Circuit_Chip_NPIC.get(64L),
                            ItemList.Circuit_Parts_DiodeXSMD.get(32L), ItemList.Circuit_Parts_CapacitorXSMD.get(32L),
                            ItemList.Circuit_Parts_ResistorXSMD.get(32L),
                            ItemList.Circuit_Parts_TransistorXSMD.get(32L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, MaterialsUEVplus.SpaceTime, 12L) },
                    new FluidStack[] { new FluidStack(solderUEV, 1440) },
                    ItemList.Energy_Cluster.get(1),
                    1,
                    50 * 20,
                    (int) TierEU.RECIPE_UHV,
                    null,
                    null);

            // Alternate Ultimate Battery Recipe
            IG_RecipeAdder.addSpaceAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Optical.get(1),
                            GTOreDictUnificator.get("foilShirabon", 64),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UHV, 4L),
                            ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                            ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                            ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                            ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                            ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                            ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                            ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L), ItemList.Circuit_Chip_PPIC.get(64L),
                            ItemList.Circuit_Parts_DiodeXSMD.get(64L), ItemList.Circuit_Parts_CapacitorXSMD.get(64L),
                            ItemList.Circuit_Parts_ResistorXSMD.get(64L),
                            ItemList.Circuit_Parts_TransistorXSMD.get(64L),
                            GTOreDictUnificator.get(
                                    OrePrefixes.bolt,
                                    MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter,
                                    4L) },
                    new FluidStack[] { new FluidStack(solderUEV, 2880),
                            MaterialsUEVplus.WhiteDwarfMatter.getMolten(576),
                            MaterialsUEVplus.BlackDwarfMatter.getMolten(576) },
                    ItemList.ZPM2.get(1),
                    2,
                    50 * 20,
                    (int) TierEU.RECIPE_UEV,
                    null,
                    null);

            if (OpenComputers.isModLoaded() && SuperSolarPanels.isModLoaded()) {
                // Optically Compatible Memory
                IG_RecipeAdder.addSpaceAssemblerRecipe(
                        new ItemStack[] { getModItem(OpenComputers.ID, "item", 1L, 39), // Memory tier 3.5
                                ItemList.Circuit_Chip_Optical.get(1L), CustomItemList.DATApipe.get(4L),
                                GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUEV, 4L),
                                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Infinity, 8L),
                                getModItem(SuperSolarPanels.ID, "solarsplitter", 1L, 0) // Solar Light
                        // Splitter
                        },
                        new FluidStack[] { new FluidStack(solderUEV, 288) },
                        ItemList.Optically_Compatible_Memory.get(2),
                        1,
                        20 * 20,
                        (int) TierEU.RECIPE_UHV,
                        null,
                        null);

                IG_RecipeAdder.addSpaceAssemblerRecipe(
                        new ItemStack[] { getModItem(OpenComputers.ID, "item", 4L, 39), // Memory tier 3.5
                                ItemList.Circuit_Chip_Optical.get(1L), CustomItemList.DATApipe.get(16L),
                                GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUIV, 4L),
                                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Infinity, 16L),
                                getModItem(SuperSolarPanels.ID, "solarsplitter", 4L, 0) // Solar Light
                        // Splitter
                        },
                        new FluidStack[] { new FluidStack(solderUEV, 576) },
                        ItemList.Optically_Compatible_Memory.get(8),
                        2,
                        20 * 20,
                        (int) TierEU.RECIPE_UEV,
                        null,
                        null);

                IG_RecipeAdder.addSpaceAssemblerRecipe(
                        new ItemStack[] { getModItem(OpenComputers.ID, "item", 16L, 39), // Memory tier
                                // 3.5
                                ItemList.Circuit_Chip_Optical.get(1L), CustomItemList.DATApipe.get(64L),
                                GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUMV, 4L),
                                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Infinity, 32L),
                                getModItem(SuperSolarPanels.ID, "solarsplitter", 16L, 0) // Solar Light
                        // Splitter
                        },
                        new FluidStack[] { new FluidStack(solderUEV, 1152) },
                        ItemList.Optically_Compatible_Memory.get(32),
                        2,
                        20 * 20,
                        (int) TierEU.RECIPE_UIV,
                        null,
                        null);

                // Advanced Stocking Input Hatch (ME)
                IG_RecipeAdder.addSpaceAssemblerRecipe(
                        new ItemStack[] { ItemList.Hatch_Input_Multi_2x2_UEV.get(4L),
                                getModItem(AE2FluidCraft.ID, "fluid_interface", 1L),
                                ItemList.Optically_Compatible_Memory.get(2), ItemList.Electric_Pump_UEV.get(1L),
                                // 16384k Me Fluid Storage Component
                                getModItem(AE2FluidCraft.ID, "fluid_part", 4, 7),
                                // Hyper-Acceleration Card
                                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4L, 56) },
                        new FluidStack[] { new FluidStack(solderUEV, 2304) },
                        ItemList.Hatch_Input_ME_Advanced.get(1),
                        1,
                        15 * 20,
                        (int) TierEU.RECIPE_UHV,
                        null,
                        null);
            }
            if (OpenComputers.isModLoaded()) {
                // Memory Tier 3.5
                IG_RecipeAdder.addSpaceAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Multifiberglass_Elite.get(4),
                                ItemList.Circuit_Chip_Ram.get(64), ItemList.Circuit_Chip_SoC.get(64),
                                ItemList.Circuit_Chip_NAND.get(64),
                                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UV, 1L),
                                GTOreDictUnificator.get(OrePrefixes.foil, Materials.VanadiumGallium, 64L) },
                        new FluidStack[] { new FluidStack(solderIndalloy, 1152) },
                        getModItem(OpenComputers.ID, "item", 64L, 39),
                        1,
                        10 * SECONDS,
                        (int) TierEU.RECIPE_UV,
                        null,
                        null);
            }
            if (AppliedEnergistics2.isModLoaded() && AE2FluidCraft.isModLoaded()) {
                // Non-oredicted circuit was intended.
                IG_RecipeAdder.addSpaceAssemblerRecipe(
                        new ItemStack[] { getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1),
                                getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1, 3),
                                getModItem(AppliedEnergistics2.ID, "tile.BlockAdvancedCraftingStorage", 1, 3),
                                ItemList.Robot_Arm_UHV.get(16), ItemList.Circuit_OpticalProcessor.get(16),
                                GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Aluminium, 4L),
                                getModItem(AE2FluidCraft.ID, "part_fluid_pattern_terminal_ex", 1) },
                        new FluidStack[] { new FluidStack(solderUEV, 9216) },
                        getModItem(AppliedEnergistics2.ID, "tile.BlockPatternOptimizationMatrix", 1),
                        1,
                        5 * MINUTES,
                        (int) TierEU.RECIPE_UHV,
                        null,
                        null);
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
                IG_RecipeAdder.addSpaceAssemblerRecipe(
                        new ItemStack[] {
                                getModItem(AppliedEnergistics2.ID, "item.ItemExtremeStorageCell.Singularity", 1),
                                GTOreDictUnificator
                                        .get(OrePrefixes.plateDense, MaterialsUEVplus.TranscendentMetal, 64L),
                                ItemList.Field_Generator_UXV.get(1L), filledUMVCell,
                                new ItemStack(TTCasingsContainer.SpacetimeCompressionFieldGenerators, 4, 8),
                                com.dreammaster.item.ItemList.CircuitUXV.getIS(4),
                                MaterialsUEVplus.Eternity.getNanite(4) },
                        new FluidStack[] { MaterialsUEVplus.Eternity.getMolten(36864) },
                        getModItem(AppliedEnergistics2.ID, "item.ItemExtremeStorageCell.Universe", 1),
                        3,
                        1 * MINUTES,
                        (int) TierEU.RECIPE_UXV,
                        null,
                        null);

                // Digital Singularity ME Storage Cell
                IG_RecipeAdder.addSpaceAssemblerRecipe(
                        new ItemStack[] { getModItem(EternalSingularity.ID, "eternal_singularity", 1),
                                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 12, 60),
                                ItemList.Quantum_Chest_IV.get(8L),
                                GTOreDictUnificator.get(OrePrefixes.block, Materials.Infinity, 4L),
                                getModItem(Avaritia.ID, "Resource", 4, 5),
                                GTOreDictUnificator.get(OrePrefixes.block, Materials.CosmicNeutronium, 12L) },
                        new FluidStack[] { new FluidStack(solderUEV, 2304) },
                        getModItem(AppliedEnergistics2.ID, "item.ItemExtremeStorageCell.Singularity", 1),
                        1,
                        10 * SECONDS,
                        (int) TierEU.RECIPE_UHV,
                        null,
                        null);
            }
            if (AE2FluidCraft.isModLoaded()) {
                // Artificial Fluid Universe Cell
                IG_RecipeAdder.addSpaceAssemblerRecipe(
                        new ItemStack[] { getModItem(AE2FluidCraft.ID, "fluid_storage.singularity", 1),
                                GTOreDictUnificator.get("plateDenseShirabon", 16), ItemList.Field_Generator_UXV.get(1L),
                                new ItemStack(Loaders.yottaFluidTankCell, 2, 9), new ItemStack(tfftStorageField, 2, 10),
                                new ItemStack(TTCasingsContainer.SpacetimeCompressionFieldGenerators, 4, 8),
                                com.dreammaster.item.ItemList.CircuitUXV.getIS(4),
                                MaterialsUEVplus.Eternity.getNanite(4) },
                        new FluidStack[] { MaterialsUEVplus.Eternity.getMolten(36864) },
                        getModItem(AE2FluidCraft.ID, "fluid_storage.Universe", 1),
                        3,
                        1 * MINUTES,
                        (int) TierEU.RECIPE_UXV,
                        null,
                        null);

                // ME Fluid Digital Singularity Storage Cell
                IG_RecipeAdder.addSpaceAssemblerRecipe(
                        new ItemStack[] { getModItem(EternalSingularity.ID, "eternal_singularity", 1),
                                new ItemStack(Loaders.yottaFluidTankCell, 4, 6),
                                getModItem(AE2FluidCraft.ID, "fluid_part", 8, 7), ItemList.Quantum_Tank_IV.get(8L),
                                GTOreDictUnificator.get(OrePrefixes.block, Materials.Infinity, 4L),
                                getModItem(Avaritia.ID, "Resource", 4, 5),
                                GTOreDictUnificator.get(OrePrefixes.block, Materials.CosmicNeutronium, 12L) },
                        new FluidStack[] { new FluidStack(solderUEV, 2304) },
                        getModItem(AE2FluidCraft.ID, "fluid_storage.singularity", 1, 0),
                        1,
                        10 * SECONDS,
                        (int) TierEU.RECIPE_UHV,
                        null,
                        null);

                // ME Essentia Digital Singularity Storage Cell
                if (ThaumicEnergistics.isModLoaded()) {
                    IG_RecipeAdder
                            .addSpaceAssemblerRecipe(
                                    new ItemStack[] { getModItem(EternalSingularity.ID, "eternal_singularity", 1),
                                            getModItem(ThaumicEnergistics.ID, "storage.component", 12, 8),
                                            getModItem(Thaumcraft.ID, "blockEssentiaReservoir", 8, 0),
                                            GTOreDictUnificator.get(OrePrefixes.block, Materials.Infinity, 4L),
                                            getModItem(Avaritia.ID, "Resource", 4, 5),
                                            GTOreDictUnificator
                                                    .get(OrePrefixes.block, Materials.CosmicNeutronium, 12L) },
                                    new FluidStack[] { new FluidStack(solderUEV, 2304) },
                                    getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 10),
                                    1,
                                    10 * SECONDS,
                                    (int) TierEU.RECIPE_UHV,
                                    null,
                                    null);
                }
            }
        }
    }
}
