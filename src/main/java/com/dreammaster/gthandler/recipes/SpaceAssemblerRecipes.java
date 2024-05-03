package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.AE2FluidCraft;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.BartWorks;
import static gregtech.api.enums.Mods.GTNHIntergalactic;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.enums.Mods.GoodGenerator;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.SuperSolarPanels;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.github.technus.tectech.thing.CustomItemList;
import com.gtnewhorizons.gtnhintergalactic.recipe.IG_RecipeAdder;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gtPlusPlus.core.material.ELEMENT;

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

            if (BartWorks.isModLoaded()) {
                // Optically Perfected CPU
                IG_RecipeAdder.addSpaceAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Chip_Optical.get(1L),
                                ItemList.Optical_Cpu_Containment_Housing.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.InfinityCatalyst, 4L),
                                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.CosmicNeutronium, 4L),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Draconium, 4L),
                                CustomItemList.DATApipe.get(1L),
                                // Atomic Separation Catalyst screw
                                GT_ModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedscrew", 4L, 10022),
                                // Precious Metals Alloy screw
                                GT_ModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedscrew", 4L, 10109) },
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
                                GT_OreDictUnificator
                                        .get(OrePrefixes.screw, Materials.Longasssuperconductornameforuhvwire, 8L),
                                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TengamAttuned, 8L),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.DraconiumAwakened, 8L),
                                CustomItemList.DATApipe.get(4L),
                                // Precious Metals Alloy screw
                                GT_ModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedscrew", 8L, 10109),
                                // Enriched Naquadah Alloy screw
                                GT_ModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedscrew", 8L, 10110) },
                        new FluidStack[] { new FluidStack(solderUEV, 576) },
                        ItemList.Optically_Perfected_CPU.get(4L),
                        2,
                        20 * 20,
                        (int) TierEU.RECIPE_UEV,
                        null,
                        null);

                if (GTPlusPlus.isModLoaded()) {
                    IG_RecipeAdder
                            .addSpaceAssemblerRecipe(
                                    new ItemStack[] { ItemList.Circuit_Chip_Optical.get(16L),
                                            ItemList.Optical_Cpu_Containment_Housing.get(16L),
                                            ELEMENT.STANDALONE.CELESTIAL_TUNGSTEN.getScrew(16),
                                            GT_OreDictUnificator
                                                    .get(OrePrefixes.screw, MaterialsUEVplus.SpaceTime, 16L),
                                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tritanium, 16L),
                                            CustomItemList.DATApipe.get(16L),
                                            // Enriched Naquadah Alloy screw
                                            GT_ModHandler
                                                    .getModItem(BartWorks.ID, "gt.bwMetaGeneratedscrew", 16L, 10110),
                                            // Shirabon screw
                                            GT_ModHandler
                                                    .getModItem(BartWorks.ID, "gt.bwMetaGeneratedscrew", 16L, 10112) },
                                    new FluidStack[] { new FluidStack(solderUEV, 1152) },
                                    ItemList.Optically_Perfected_CPU.get(16L),
                                    2,
                                    20 * 20,
                                    (int) TierEU.RECIPE_UIV,
                                    null,
                                    null);
                }
            }
            if (GTPlusPlus.isModLoaded()) {

                // Alternate Energy Orb Cluster Recipe
                IG_RecipeAdder.addSpaceAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Multifiberglass.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NaquadahAlloy, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit.get(Materials.Master), 4L),
                                ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                                ItemList.Circuit_Parts_Crystal_Chip_Master.get(8L), ItemList.Circuit_Chip_HPIC.get(64L),
                                ItemList.Circuit_Parts_DiodeASMD.get(8L), ItemList.Circuit_Parts_CapacitorASMD.get(8L),
                                ItemList.Circuit_Parts_ResistorASMD.get(8L),
                                ItemList.Circuit_Parts_TransistorASMD.get(8L),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 64) },
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
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Bedrockium, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 4L),
                                ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                                ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                                ItemList.Circuit_Chip_UHPIC.get(64L), ItemList.Circuit_Parts_DiodeXSMD.get(8L),
                                ItemList.Circuit_Parts_CapacitorXSMD.get(8L),
                                ItemList.Circuit_Parts_ResistorXSMD.get(8L),
                                ItemList.Circuit_Parts_TransistorXSMD.get(8L),
                                GT_OreDictUnificator.get("wireFineHypogen", 48), },
                        new FluidStack[] { new FluidStack(solderUEV, 720) },
                        ItemList.Energy_Module.get(1),
                        1,
                        50 * 20,
                        (int) TierEU.RECIPE_UV,
                        null,
                        null);
            }

            if (GoodGenerator.isModLoaded()) {
                // Advanced Radiation Proof Plate
                IG_RecipeAdder.addSpaceAssemblerRecipe(
                        new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lanthanum, 32L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.ElectrumFlux, 16L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Trinium, 16L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 64L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 16L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmiridium, 16L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 16L) },
                        new FluidStack[] { new FluidStack(solderIndalloy, (32 * 144)),
                                Materials.Lead.getMolten(64 * 144L) },
                        GT_ModHandler.getModItem(GoodGenerator.ID, "advancedRadiationProtectionPlate", 4L, 0),
                        1,
                        50 * 20,
                        (int) TierEU.ZPM,
                        null,
                        null);
            }

            // Alternate Energy Cluster Recipe
            IG_RecipeAdder.addSpaceAssemblerRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Bio_Ultra.get(1),
                            GT_OreDictUnificator.get(OrePrefixes.foil, Materials.CosmicNeutronium, 64L),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.SuperconductorUHV, 4L),
                            ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                            ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                            ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                            ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L), ItemList.Circuit_Chip_NPIC.get(64L),
                            ItemList.Circuit_Parts_DiodeXSMD.get(32L), ItemList.Circuit_Parts_CapacitorXSMD.get(32L),
                            ItemList.Circuit_Parts_ResistorXSMD.get(32L),
                            ItemList.Circuit_Parts_TransistorXSMD.get(32L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, MaterialsUEVplus.SpaceTime, 12L) },
                    new FluidStack[] { new FluidStack(solderUEV, 1440) },
                    ItemList.Energy_Cluster.get(1),
                    1,
                    50 * 20,
                    (int) TierEU.RECIPE_UHV,
                    null,
                    null);

            if (GoodGenerator.isModLoaded()) {
                // Alternate Ultimate Battery Recipe
                IG_RecipeAdder.addSpaceAssemblerRecipe(
                        new ItemStack[] { ItemList.Circuit_Board_Optical.get(1),
                                GT_OreDictUnificator.get("foilShirabon", 64),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Infinite, 4L),
                                ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                                ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                                ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                                ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                                ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                                ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                                ItemList.Circuit_Parts_Crystal_Chip_Master.get(64L),
                                ItemList.Circuit_Chip_PPIC.get(64L), ItemList.Circuit_Parts_DiodeXSMD.get(64L),
                                ItemList.Circuit_Parts_CapacitorXSMD.get(64L),
                                ItemList.Circuit_Parts_ResistorXSMD.get(64L),
                                ItemList.Circuit_Parts_TransistorXSMD.get(64L),
                                GT_OreDictUnificator.get(
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
            }

            if (OpenComputers.isModLoaded() && SuperSolarPanels.isModLoaded()) {
                // Optically Compatible Memory
                IG_RecipeAdder.addSpaceAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem(OpenComputers.ID, "item", 1L, 39), // Memory tier 3.5
                                ItemList.Circuit_Chip_Optical.get(1L), CustomItemList.DATApipe.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUEV, 4L),
                                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Infinity, 8L),
                                GT_ModHandler.getModItem(SuperSolarPanels.ID, "solarsplitter", 1L, 0) // Solar Light
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
                        new ItemStack[] { GT_ModHandler.getModItem(OpenComputers.ID, "item", 4L, 39), // Memory tier 3.5
                                ItemList.Circuit_Chip_Optical.get(1L), CustomItemList.DATApipe.get(16L),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUIV, 4L),
                                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Infinity, 16L),
                                GT_ModHandler.getModItem(SuperSolarPanels.ID, "solarsplitter", 4L, 0) // Solar Light
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
                        new ItemStack[] { GT_ModHandler.getModItem(OpenComputers.ID, "item", 16L, 39), // Memory tier
                                // 3.5
                                ItemList.Circuit_Chip_Optical.get(1L), CustomItemList.DATApipe.get(64L),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUMV, 4L),
                                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Infinity, 32L),
                                GT_ModHandler.getModItem(SuperSolarPanels.ID, "solarsplitter", 16L, 0) // Solar Light
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
                IG_RecipeAdder
                        .addSpaceAssemblerRecipe(
                                new ItemStack[] { ItemList.Hatch_Input_Multi_2x2_UEV.get(4L),
                                        GT_ModHandler.getModItem(AE2FluidCraft.ID, "fluid_interface", 1L),
                                        ItemList.Optically_Compatible_Memory.get(2), ItemList.Electric_Pump_UEV.get(1L),
                                        // 16384k Me Fluid Storage Component
                                        GT_ModHandler.getModItem(AE2FluidCraft.ID, "fluid_part", 4, 7),
                                        // Hyper-Acceleration Card
                                        GT_ModHandler
                                                .getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4L, 56) },
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
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.SuperconductorUHV, 1L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.VanadiumGallium, 64L) },
                        new FluidStack[] { new FluidStack(solderIndalloy, 1152) },
                        GT_ModHandler.getModItem(OpenComputers.ID, "item", 64L, 39),
                        1,
                        10 * SECONDS,
                        (int) TierEU.RECIPE_UV,
                        null,
                        null);
            }
            if (AppliedEnergistics2.isModLoaded() && AE2FluidCraft.isModLoaded()) {
                IG_RecipeAdder.addSpaceAssemblerRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1),
                                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1, 3),
                                GT_ModHandler
                                        .getModItem(AppliedEnergistics2.ID, "tile.BlockAdvancedCraftingStorage", 1, 3),
                                ItemList.Robot_Arm_UHV.get(16), ItemList.Circuit_OpticalProcessor.get(16),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Aluminium, 4L),
                                GT_ModHandler.getModItem(AE2FluidCraft.ID, "part_fluid_pattern_terminal_ex", 1) },
                        new FluidStack[] { new FluidStack(solderUEV, 9216) },
                        GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockPatternOptimizationMatrix", 1),
                        1,
                        5 * MINUTES,
                        (int) TierEU.RECIPE_UHV,
                        null,
                        null);
            }
        }
    }
}
