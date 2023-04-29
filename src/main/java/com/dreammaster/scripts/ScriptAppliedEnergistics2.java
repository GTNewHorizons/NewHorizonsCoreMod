package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.EternalSingularity;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.*;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.gthandler.CustomItemList;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class ScriptAppliedEnergistics2 implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "AppliedEnergistics2";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(AppliedEnergistics2.ID, TinkerConstruct.ID, Avaritia.ID, EternalSingularity.ID);
    }

    @Override
    public void loadRecipes() {
        final ItemStack CraftingUnit = getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1);
        final ItemStack CoCraftingUnit4x = getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1, 2);
        final ItemStack CoCraftingUnit16x = getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1, 3);
        final ItemStack SuperSpeedCard = getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 56);
        final ItemStack GLASS_PANE = getModItem(TinkerConstruct.ID, "GlassPane", 1);
        final ItemStack CERTUS_PLATE = GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L);
        final ItemStack AE2_ADVANCED_HOUSING = getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 61);
        final ItemStack AE2_HOUSING = getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 39);
        final ItemStack AE2_BLOCK_CONTAINER = getModItem(
                AppliedEnergistics2.ID,
                "item.ItemExtremeStorageCell.Container",
                1,
                0);
        final ItemStack AE2_ME_CHEST = getModItem(AppliedEnergistics2.ID, "tile.BlockChest", 1, 0);
        final ItemStack AE2_ME_Glass_Cable = getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16);
        final ItemStack AE2_ME_Covered_Cable = getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 36);
        final ItemStack AE2_ME_Dense_Covered_Cable = getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 536);
        final ItemStack AE2_ME_Backbone_Covered_Cable = getModItem(
                AppliedEnergistics2.ID,
                "item.ItemMultiPart",
                1,
                556);
        ItemStack circuit1 = GT_Utility.getIntegratedCircuit(1);
        ItemStack[] FluixCoveredCableColor = new ItemStack[16];
        ItemStack[] FluixDenseCoveredCableColor = new ItemStack[16];
        ItemStack[] FluixBackboneCoveredCableColor = new ItemStack[16];
        ItemStack[] FluixSmartCableColor = new ItemStack[16];
        ItemStack[] FluixDenseSmartCableColor = new ItemStack[16];
        ItemStack[] FluixBackboneSmartCableColor = new ItemStack[16];
        GT_ModHandler.addShapelessCraftingRecipe(
                SuperSpeedCard,
                new Object[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28),
                        CustomItemList.MysteriousCrystal });

        GT_Values.RA.addAssemblerRecipe(
                CraftingUnit,
                OrePrefixes.circuit.get(Materials.Elite),
                2,
                GT_Values.NF,
                CoCraftingUnit4x,
                100,
                480);

        GT_Values.RA.addAssemblerRecipe(
                CraftingUnit,
                OrePrefixes.circuit.get(Materials.Superconductor),
                2,
                GT_Values.NF,
                CoCraftingUnit16x,
                100,
                30720);

        // Advanced Storage Housing
        GT_ModHandler.removeRecipeByOutput(AE2_ADVANCED_HOUSING);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GLASS_PANE, CERTUS_PLATE,
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 3L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2L),
                        GT_Utility.getIntegratedCircuit(3) },
                GT_Values.NF,
                AE2_ADVANCED_HOUSING,
                100,
                16);
        GT_ModHandler.addCraftingRecipe(
                AE2_ADVANCED_HOUSING,
                new Object[] { "hPS", "CGC", "SCd", 'P', CERTUS_PLATE, 'S',
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 1L), 'C',
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1L), 'G', GLASS_PANE });
        GT_ModHandler.addCraftingRecipe(
                AE2_ADVANCED_HOUSING,
                new Object[] { "dPS", "CGC", "SCh", 'P', CERTUS_PLATE, 'S',
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 1L), 'C',
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1L), 'G', GLASS_PANE });

        // Advanced Storage Cells
        final ItemStack[] components = new ItemStack[] {
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 57), // 256k
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 58), // 1024k
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 59), // 4096k
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 60), // 16384k
        };
        final ItemStack[] cells = new ItemStack[] {
                getModItem(AppliedEnergistics2.ID, "item.ItemAdvancedStorageCell.256k", 1), // 256k
                getModItem(AppliedEnergistics2.ID, "item.ItemAdvancedStorageCell.1024k", 1), // 1024k
                getModItem(AppliedEnergistics2.ID, "item.ItemAdvancedStorageCell.4096k", 1), // 4096k
                getModItem(AppliedEnergistics2.ID, "item.ItemAdvancedStorageCell.16384k", 1), // 16384k
        };
        for (int i = 0; i < components.length; i++) {
            GT_ModHandler.removeRecipeByOutput(cells[i]);
            GT_ModHandler.removeRecipeByOutput(components[i]);
        }
        for (int i = 0; i < components.length; i++) {
            GT_ModHandler.addCraftingRecipe(
                    cells[i],
                    new Object[] { "hPS", "CGC", "SCd", 'P', CERTUS_PLATE, 'S',
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 1L), 'C',
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1L), 'G', components[i] });
            GT_ModHandler.addCraftingRecipe(
                    cells[i],
                    new Object[] { "dPS", "CGC", "SCh", 'P', CERTUS_PLATE, 'S',
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 1L), 'C',
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1L), 'G', components[i] });
            GT_ModHandler.addShapelessCraftingRecipe(cells[i], new Object[] { AE2_ADVANCED_HOUSING, components[i] });
        }
        GT_ModHandler.addCraftingRecipe(
                components[0],
                new Object[] { "CPC", "PXP", "CPC", 'C', "circuitData", 'P',
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 38), // 64k
                        'X', CustomItemList.EngineeringProcessorItemEmeraldCore.get(1) });
        GT_ModHandler.addCraftingRecipe(
                components[1],
                new Object[] { "CPC", "PXP", "CPC", 'C', "circuitElite", 'P', components[0], 'X',
                        CustomItemList.EngineeringProcessorItemEmeraldCore.get(1) });
        GT_ModHandler.addCraftingRecipe(
                components[2],
                new Object[] { "CPC", "PXP", "CPC", 'C', "circuitMaster", 'P', components[1], 'X',
                        CustomItemList.EngineeringProcessorItemAdvEmeraldCore.get(1) });
        GT_ModHandler.addCraftingRecipe(
                components[3],
                new Object[] { "CPC", "PXP", "CPC", 'C', "circuitSuperconductor", 'P', components[2], 'X',
                        CustomItemList.EngineeringProcessorItemAdvEmeraldCore.get(1) });
        FluidStack[] solders = new FluidStack[] { Materials.Lead.getMolten(288), Materials.Tin.getMolten(144),
                Materials.SolderingAlloy.getMolten(72), };
        for (FluidStack solder : solders) {
            // 256k
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 16),
                            CustomItemList.EngineeringProcessorItemEmeraldCore.get(1),
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1), GT_Utility.getIntegratedCircuit(1) },
                    solder,
                    components[0],
                    200,
                    1920,
                    true);
            // 1024k
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 16),
                            CustomItemList.EngineeringProcessorItemEmeraldCore.get(1),
                            ItemList.Circuit_Board_Multifiberglass_Elite.get(1), GT_Utility.getIntegratedCircuit(1) },
                    solder,
                    components[1],
                    200,
                    7680,
                    true);
            // 4096k
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 16),
                            CustomItemList.EngineeringProcessorItemAdvEmeraldCore.get(1),
                            ItemList.Circuit_Board_Wetware_Extreme.get(1), GT_Utility.getIntegratedCircuit(1) },
                    solder,
                    components[2],
                    200,
                    30720,
                    true);
            // 16384k
            GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 16),
                            CustomItemList.EngineeringProcessorItemAdvEmeraldCore.get(1),
                            ItemList.Circuit_Board_Bio_Ultra.get(1), GT_Utility.getIntegratedCircuit(1) },
                    solder,
                    components[3],
                    200,
                    500000,
                    true);
        }

        // Advanced Crafting Storage
        ItemStack[] storage = new ItemStack[] {
                getModItem(AppliedEnergistics2.ID, "tile.BlockAdvancedCraftingStorage", 1, 0), // 256k
                getModItem(AppliedEnergistics2.ID, "tile.BlockAdvancedCraftingStorage", 1, 1), // 1024k
                getModItem(AppliedEnergistics2.ID, "tile.BlockAdvancedCraftingStorage", 1, 2), // 4096k
                getModItem(AppliedEnergistics2.ID, "tile.BlockAdvancedCraftingStorage", 1, 3), // 16384k
        };
        for (int i = 0; i < storage.length; i++) {
            GT_ModHandler.removeRecipeByOutput(storage[i]);
            GT_Values.RA.addAssemblerRecipe(
                    new ItemStack[] { components[i], getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1) },
                    null,
                    storage[i],
                    400,
                    1920);
        }

        // ME Block Container
        GT_ModHandler.removeRecipeByOutput(AE2_BLOCK_CONTAINER);
        GT_ModHandler.addCraftingRecipe(
                AE2_BLOCK_CONTAINER,
                new Object[] { " K ", "SMS", "dHw", 'K',
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35), 'S',
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Titanium, 1), 'M', AE2_ME_CHEST, 'H',
                        AE2_HOUSING });
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Titanium, 2), AE2_ME_CHEST, AE2_HOUSING,
                        GT_Utility.getIntegratedCircuit(4) },
                null,
                AE2_BLOCK_CONTAINER,
                40,
                120);
        // --- Fluix Covered Cable
        for (int i = 0; i < 16; i++) {
            FluixCoveredCableColor[i] = getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 20 + i);

            addShapelessCraftingRecipe(
                    getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1L, 36),
                    new Object[] { FluixCoveredCableColor[i] });
        }
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { AE2_ME_Glass_Cable, GT_Utility.getIntegratedCircuit(24) },
                Materials.Rubber.getMolten(144L),
                AE2_ME_Covered_Cable,
                150,
                120);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { AE2_ME_Glass_Cable, GT_Utility.getIntegratedCircuit(24) },
                Materials.StyreneButadieneRubber.getMolten(108L),
                AE2_ME_Covered_Cable,
                150,
                120);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { AE2_ME_Glass_Cable, GT_Utility.getIntegratedCircuit(24) },
                Materials.Silicone.getMolten(72L),
                AE2_ME_Covered_Cable,
                150,
                120);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { AE2_ME_Glass_Cable,
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.PolyvinylChloride, 1) },
                Materials.StyreneButadieneRubber.getMolten(36L),
                AE2_ME_Covered_Cable,
                150,
                120);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { AE2_ME_Glass_Cable,
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.PolyvinylChloride, 1) },
                Materials.Silicone.getMolten(36L),
                AE2_ME_Covered_Cable,
                150,
                120);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { AE2_ME_Glass_Cable,
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Polydimethylsiloxane, 1) },
                Materials.StyreneButadieneRubber.getMolten(36L),
                AE2_ME_Covered_Cable,
                150,
                120);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { AE2_ME_Glass_Cable,
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Polydimethylsiloxane, 1) },
                Materials.Silicone.getMolten(36L),
                AE2_ME_Covered_Cable,
                150,
                120);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 16),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PolyvinylChloride, 1) },
                Materials.StyreneButadieneRubber.getMolten(144L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36),
                500,
                120);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 16),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PolyvinylChloride, 1) },
                Materials.Silicone.getMolten(144L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36),
                500,
                120);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 16),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Polydimethylsiloxane, 1) },
                Materials.StyreneButadieneRubber.getMolten(144L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36),
                500,
                120);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 16),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Polydimethylsiloxane, 1) },
                Materials.Silicone.getMolten(144L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36),
                500,
                120);
        // --- Fluix Dense Covered Cable
        for (int i = 0; i < 16; i++) {
            FluixDenseCoveredCableColor[i] = getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 520 + i);

            addShapelessCraftingRecipe(
                    getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1L, 536),
                    new Object[] { FluixDenseCoveredCableColor[i] });
        }

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36),
                        GT_Utility.getIntegratedCircuit(24) },
                Materials.StyreneButadieneRubber.getMolten(216L),
                AE2_ME_Dense_Covered_Cable,
                200,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36),
                        GT_Utility.getIntegratedCircuit(24) },
                Materials.Silicone.getMolten(144L),
                AE2_ME_Dense_Covered_Cable,
                200,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.PolyvinylChloride, 1) },
                Materials.StyreneButadieneRubber.getMolten(72L),
                AE2_ME_Dense_Covered_Cable,
                200,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.PolyvinylChloride, 1) },
                Materials.Silicone.getMolten(72L),
                AE2_ME_Dense_Covered_Cable,
                200,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Polydimethylsiloxane, 1) },
                Materials.StyreneButadieneRubber.getMolten(72L),
                AE2_ME_Dense_Covered_Cable,
                200,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Polydimethylsiloxane, 1) },
                Materials.Silicone.getMolten(72L),
                AE2_ME_Dense_Covered_Cable,
                200,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 36),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PolyvinylChloride, 1) },
                Materials.StyreneButadieneRubber.getMolten(288L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 536),
                700,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 36),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PolyvinylChloride, 1) },
                Materials.Silicone.getMolten(288L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 536),
                700,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 36),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Polydimethylsiloxane, 1) },
                Materials.StyreneButadieneRubber.getMolten(288L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 536),
                700,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 36),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Polydimethylsiloxane, 1) },
                Materials.Silicone.getMolten(288L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 536),
                700,
                480);
        // --- Fluix Backbone Covered Cable
        for (int i = 0; i < 16; i++) {
            FluixBackboneCoveredCableColor[i] = getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 540 + i);

            addShapelessCraftingRecipe(
                    getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1L, 556),
                    new Object[] { FluixBackboneCoveredCableColor[i] });
        }

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 536),
                        GT_Utility.getIntegratedCircuit(24) },
                Materials.StyreneButadieneRubber.getMolten(432L),
                AE2_ME_Backbone_Covered_Cable,
                250,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 536),
                        GT_Utility.getIntegratedCircuit(24) },
                Materials.Silicone.getMolten(288L),
                AE2_ME_Backbone_Covered_Cable,
                250,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 536),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.PolyvinylChloride, 1) },
                Materials.StyreneButadieneRubber.getMolten(144L),
                AE2_ME_Backbone_Covered_Cable,
                250,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 536),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.PolyvinylChloride, 1) },
                Materials.Silicone.getMolten(144L),
                AE2_ME_Backbone_Covered_Cable,
                250,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 536),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Polydimethylsiloxane, 1) },
                Materials.StyreneButadieneRubber.getMolten(144L),
                AE2_ME_Backbone_Covered_Cable,
                250,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 536),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Polydimethylsiloxane, 1) },
                Materials.Silicone.getMolten(144L),
                AE2_ME_Backbone_Covered_Cable,
                250,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 536),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PolyvinylChloride, 1) },
                Materials.StyreneButadieneRubber.getMolten(576L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 556),
                900,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 536),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PolyvinylChloride, 1) },
                Materials.Silicone.getMolten(576L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 556),
                900,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 536),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Polydimethylsiloxane, 1) },
                Materials.StyreneButadieneRubber.getMolten(576L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 556),
                900,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 536),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Polydimethylsiloxane, 1) },
                Materials.Silicone.getMolten(576L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 556),
                900,
                1920);
        // ME Smart Cable Fluix
        for (int i = 0; i < 16; i++) {
            FluixSmartCableColor[i] = getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 40 + i);

            addShapelessCraftingRecipe(
                    getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1L, 56),
                    new Object[] { FluixSmartCableColor[i] });
        }
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 16),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1), circuit1 },
                Materials.ConductiveIron.getMolten(144L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 56),
                100,
                120);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1), circuit1 },
                Materials.ConductiveIron.getMolten(144L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 56),
                100,
                120);
        // --- ME Smart Dense Cable Fluix
        for (int i = 0; i < 16; i++) {
            FluixDenseSmartCableColor[i] = getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 60 + i);
            addShapelessCraftingRecipe(
                    getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1L, 76),
                    new Object[] { FluixDenseSmartCableColor[i] });
        }
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 56),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1), circuit1 },
                Materials.EnergeticAlloy.getMolten(144L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 76),
                150,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 536),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1), circuit1 },
                Materials.EnergeticAlloy.getMolten(144L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 76),
                150,
                480);
        // --- ME Smart Backbone Cable Fluix
        for (int i = 0; i < 16; i++) {
            FluixBackboneSmartCableColor[i] = getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 560 + i);
            addShapelessCraftingRecipe(
                    getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1L, 576),
                    new Object[] { FluixBackboneSmartCableColor[i] });
        }
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 76),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1), circuit1 },
                Materials.VibrantAlloy.getMolten(144L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 576),
                200,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 556),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1), circuit1 },
                Materials.VibrantAlloy.getMolten(144L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 576),
                200,
                1920);

        // ME Quantum Storage
        GT_ModHandler
                .removeRecipeByOutput(getModItem(AppliedEnergistics2.ID, "item.ItemExtremeStorageCell.Quantum", 1));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemExtremeStorageCell.Quantum", 1),
                "---------",
                "----a----",
                "---bdb---",
                "--bcdcb--",
                "-addedda-",
                "--bcdcb--",
                "---bdb---",
                "----a----",
                "---------",
                'a',
                "blockCosmicNeutronium",
                'b',
                "plateDenseNeutronium",
                'c',
                "circuitInfinite",
                'd',
                components[3],
                'e',
                AE2_ADVANCED_HOUSING);

        // ME Digital Singularity
        GT_ModHandler
                .removeRecipeByOutput(getModItem(AppliedEnergistics2.ID, "item.ItemExtremeStorageCell.Singularity", 1));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemExtremeStorageCell.Singularity", 1),
                "----a----",
                "---aba---",
                "--ecdce--",
                "-acdddca-",
                "abddfddba",
                "-acdddca-",
                "--ecdce--",
                "---aba---",
                "----a----",
                'a',
                "blockCosmicNeutronium",
                'b',
                getModItem(Avaritia.ID, "Resource", 1, 5),
                'c',
                getModItem(GregTech.ID, "gt.blockmachines", 1, 129),
                'd',
                components[3],
                'e',
                "blockInfinity",
                'f',
                getModItem(EternalSingularity.ID, "eternal_singularity", 1));

        // ME Void Storage
        GT_ModHandler.removeRecipeByOutput(getModItem(AppliedEnergistics2.ID, "item.ItemVoidStorageCell", 1));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemVoidStorageCell", 1),
                new Object[] { "craftingToolHardHammer", "plateCertusQuartz", "screwCertusQuartz", "plateTungsten",
                        "gemEnderEye", "plateTungsten", "screwCertusQuartz", "plateTungsten",
                        "craftingToolScrewdriver" });

        // AUTOGENERATED

        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.BlockController", 1, 0, missing),
                new Object[] { "plateTitanium", "circuitAdvanced", "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("appliedenergistics2", "tile.BlockFluix", 1, 0, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing), "plateTitanium",
                        "circuitAdvanced", "plateTitanium" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.BlockEnergyCell", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing), "circuitAdvanced",
                        getModItem("appliedenergistics2", "tile.BlockFluix", 1, 0, missing), "circuitAdvanced",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing), "cableGt08Aluminium",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.BlockDenseEnergyCell", 1, 0, missing),
                new Object[] { getModItem("appliedenergistics2", "tile.BlockEnergyCell", 1, 0, missing),
                        getModItem("appliedenergistics2", "tile.BlockEnergyCell", 1, 0, missing),
                        getModItem("appliedenergistics2", "tile.BlockEnergyCell", 1, 0, missing), "circuitMaster",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing), "circuitMaster",
                        getModItem("appliedenergistics2", "tile.BlockEnergyCell", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 194, missing),
                        getModItem("appliedenergistics2", "tile.BlockEnergyCell", 1, 0, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.BlockChest", 1, 0, missing),
                new Object[] { "plateStainlessSteel", "circuitGood", "plateStainlessSteel",
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 16, missing),
                        getModItem("IronChest", "BlockIronChest", 1, 4, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 16, missing), "plateStainlessSteel",
                        "circuitGood", "plateStainlessSteel" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.BlockDrive", 1, 0, missing),
                new Object[] { "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing), "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 16, missing),
                        getModItem("appliedenergistics2", "tile.BlockChest", 1, 0, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 16, missing), "plateTitanium",
                        "circuitAdvanced", "plateTitanium" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.BlockQuartzGrowthAccelerator", 1, 0, missing),
                new Object[] { "plateTitanium",
                        getModItem("appliedenergistics2", "tile.BlockQuartzGlass", 1, 0, missing), "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 16, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 574, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 16, missing), "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing), "plateTitanium" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.BlockCraftingUnit", 1, 0, missing),
                new Object[] { "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing), "plateTitanium",
                        "circuitBasic", getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        "circuitBasic", "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 23, missing), "plateTitanium" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.BlockMolecularAssembler", 1, 0, missing),
                new Object[] { "plateTitanium", "blockGlass", "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 44, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 214, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 43, missing), "plateTitanium",
                        "blockGlass", "plateTitanium" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.BlockCharger", 1, 0, missing),
                new Object[] { "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 7, missing), "plateTitanium",
                        "cableGt01Copper", getModItem("gregtech", "gt.blockmachines", 1, 374, missing),
                        "cableGt01Copper", "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 7, missing), "plateTitanium" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.BlockQuantumRing", 1, 0, missing),
                new Object[] { "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing), "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("appliedenergistics2", "tile.BlockEnergyCell", 1, 0, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 16, missing), "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing), "plateTitanium" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.BlockQuantumLinkChamber", 1, 0, missing),
                new Object[] { "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 9, missing), "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 9, missing),
                        getModItem("appliedenergistics2", "tile.BlockQuartzGlass", 1, 0, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 9, missing), "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 9, missing), "plateTitanium" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.BlockSpatialPylon", 1, 0, missing),
                new Object[] { "plateTitanium", getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 16, missing),
                        "plateTitanium", getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 8, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 7, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 8, missing), "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 16, missing), "plateTitanium" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.BlockSpatialIOPort", 1, 0, missing),
                new Object[] { "plateTitanium",
                        getModItem("appliedenergistics2", "tile.BlockSpatialPylon", 1, 0, missing), "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 16, missing),
                        getModItem("appliedenergistics2", "tile.BlockIOPort", 1, 0, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 16, missing), "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing), "plateTitanium" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.BlockInterface", 1, 0, missing),
                new Object[] { "plateTitanium", getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 16, missing),
                        "plateTitanium", getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 44, missing),
                        getModItem("gregtech", "gt.blockcasings", 1, 4, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 43, missing), "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 16, missing), "plateTitanium" });
        addShapelessCraftingRecipe(
                getModItem("appliedenergistics2", "tile.BlockInterface", 1, 0, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 440, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.BlockCellWorkbench", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("gregtech", "gt.metaitem.01", 1, 32740, missing),
                        "craftingToolWrench", "screwTitanium", getModItem("minecraft", "crafting_table", 1, 0, missing),
                        "screwTitanium", "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 23, missing), "plateTitanium" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.BlockIOPort", 1, 0, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 16, missing), "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 16, missing),
                        getModItem("appliedenergistics2", "tile.BlockDrive", 1, 0, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 16, missing),
                        getModItem("appliedenergistics2", "tile.BlockDrive", 1, 0, missing), "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing), "plateTitanium" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.BlockCondenser", 1, 0, missing),
                new Object[] { "plateTitanium", getModItem("gregtech", "gt.metaitem.01", 1, 32643, missing),
                        "plateTitanium", getModItem("gregtech", "gt.metaitem.01", 1, 32643, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 14, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32643, missing), "plateTitanium",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32643, missing), "plateTitanium" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.BlockEnergyAcceptor", 1, 0, missing),
                new Object[] { "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 7, missing), "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 7, missing), "plateGlowstone",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 7, missing), "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 7, missing), "plateTitanium" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.BlockVibrationChamber", 1, 0, missing),
                new Object[] { "plateTitanium", "screwTitanium", "plateTitanium", "craftingToolScrewdriver",
                        getModItem("gregtech", "gt.blockmachines", 1, 264, missing), "craftingToolWrench",
                        "plateTitanium", getModItem("appliedenergistics2", "tile.BlockEnergyAcceptor", 1, 0, missing),
                        "plateTitanium" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.BlockSecurity", 1, 0, missing),
                new Object[] { "plateTitanium", getModItem("appliedenergistics2", "tile.BlockChest", 1, 0, missing),
                        "plateTitanium", getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 16, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 37, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 16, missing), "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing), "plateTitanium" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.SkyStoneStairBlock", 4, 0, missing),
                new Object[] { null, null, getModItem("appliedenergistics2", "tile.BlockSkyStone", 1, 0, missing), null,
                        getModItem("appliedenergistics2", "tile.BlockSkyStone", 1, 0, missing),
                        getModItem("appliedenergistics2", "tile.BlockSkyStone", 1, 0, missing),
                        getModItem("appliedenergistics2", "tile.BlockSkyStone", 1, 0, missing),
                        getModItem("appliedenergistics2", "tile.BlockSkyStone", 1, 0, missing),
                        getModItem("appliedenergistics2", "tile.BlockSkyStone", 1, 0, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.SkyStoneBlockStairBlock", 4, 0, missing),
                new Object[] { null, null, getModItem("appliedenergistics2", "tile.BlockSkyStone", 1, 1, missing), null,
                        getModItem("appliedenergistics2", "tile.BlockSkyStone", 1, 1, missing),
                        getModItem("appliedenergistics2", "tile.BlockSkyStone", 1, 1, missing),
                        getModItem("appliedenergistics2", "tile.BlockSkyStone", 1, 1, missing),
                        getModItem("appliedenergistics2", "tile.BlockSkyStone", 1, 1, missing),
                        getModItem("appliedenergistics2", "tile.BlockSkyStone", 1, 1, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.SkyStoneBrickStairBlock", 4, 0, missing),
                new Object[] { null, null, getModItem("appliedenergistics2", "tile.BlockSkyStone", 1, 2, missing), null,
                        getModItem("appliedenergistics2", "tile.BlockSkyStone", 1, 2, missing),
                        getModItem("appliedenergistics2", "tile.BlockSkyStone", 1, 2, missing),
                        getModItem("appliedenergistics2", "tile.BlockSkyStone", 1, 2, missing),
                        getModItem("appliedenergistics2", "tile.BlockSkyStone", 1, 2, missing),
                        getModItem("appliedenergistics2", "tile.BlockSkyStone", 1, 2, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.SkyStoneSmallBrickStairBlock", 4, 0, missing),
                new Object[] { null, null, getModItem("appliedenergistics2", "tile.BlockSkyStone", 1, 3, missing), null,
                        getModItem("appliedenergistics2", "tile.BlockSkyStone", 1, 3, missing),
                        getModItem("appliedenergistics2", "tile.BlockSkyStone", 1, 3, missing),
                        getModItem("appliedenergistics2", "tile.BlockSkyStone", 1, 3, missing),
                        getModItem("appliedenergistics2", "tile.BlockSkyStone", 1, 3, missing),
                        getModItem("appliedenergistics2", "tile.BlockSkyStone", 1, 3, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.FluixStairBlock", 4, 0, missing),
                new Object[] { null, null, getModItem("appliedenergistics2", "tile.BlockFluix", 1, 0, missing), null,
                        getModItem("appliedenergistics2", "tile.BlockFluix", 1, 0, missing),
                        getModItem("appliedenergistics2", "tile.BlockFluix", 1, 0, missing),
                        getModItem("appliedenergistics2", "tile.BlockFluix", 1, 0, missing),
                        getModItem("appliedenergistics2", "tile.BlockFluix", 1, 0, missing),
                        getModItem("appliedenergistics2", "tile.BlockFluix", 1, 0, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.QuartzStairBlock", 4, 0, missing),
                new Object[] { null, null, getModItem("appliedenergistics2", "tile.BlockQuartz", 1, 0, missing), null,
                        getModItem("appliedenergistics2", "tile.BlockQuartz", 1, 0, missing),
                        getModItem("appliedenergistics2", "tile.BlockQuartz", 1, 0, missing),
                        getModItem("appliedenergistics2", "tile.BlockQuartz", 1, 0, missing),
                        getModItem("appliedenergistics2", "tile.BlockQuartz", 1, 0, missing),
                        getModItem("appliedenergistics2", "tile.BlockQuartz", 1, 0, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.ChiseledQuartzStairBlock", 4, 0, missing),
                new Object[] { null, null, getModItem("appliedenergistics2", "tile.BlockQuartzChiseled", 1, 0, missing),
                        null, getModItem("appliedenergistics2", "tile.BlockQuartzChiseled", 1, 0, missing),
                        getModItem("appliedenergistics2", "tile.BlockQuartzChiseled", 1, 0, missing),
                        getModItem("appliedenergistics2", "tile.BlockQuartzChiseled", 1, 0, missing),
                        getModItem("appliedenergistics2", "tile.BlockQuartzChiseled", 1, 0, missing),
                        getModItem("appliedenergistics2", "tile.BlockQuartzChiseled", 1, 0, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.QuartzPillarStairBlock", 4, 0, missing),
                new Object[] { null, null, getModItem("appliedenergistics2", "tile.BlockQuartzPillar", 1, 0, missing),
                        null, getModItem("appliedenergistics2", "tile.BlockQuartzPillar", 1, 0, missing),
                        getModItem("appliedenergistics2", "tile.BlockQuartzPillar", 1, 0, missing),
                        getModItem("appliedenergistics2", "tile.BlockQuartzPillar", 1, 0, missing),
                        getModItem("appliedenergistics2", "tile.BlockQuartzPillar", 1, 0, missing),
                        getModItem("appliedenergistics2", "tile.BlockQuartzPillar", 1, 0, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 2, 16, missing),
                new Object[] { "stickCertusQuartz",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 8, missing), "stickCertusQuartz",
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 140, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 140, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 140, missing), "stickCertusQuartz",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 8, missing),
                        "stickCertusQuartz" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 2, 44, missing),
                new Object[] { "stickNetherQuartz",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                        "stickNetherQuartz",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 12, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                        "stickNetherQuartz",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                        "stickNetherQuartz" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 2, 43, missing),
                new Object[] { "stickCertusQuartz",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                        "stickCertusQuartz",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 12, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                        "stickCertusQuartz",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                        "stickCertusQuartz" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 9, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 12, missing),
                        "plateEnderEye", getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 12, missing),
                        "plateEnderEye", "gemEnderPearl", "plateEnderEye",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 12, missing), "plateEnderEye",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 12, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 9, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 7, missing),
                        "plateEnderEye", getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 7, missing),
                        "plateEnderEye", "gemEnderPearl", "plateEnderEye",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 7, missing), "plateEnderEye",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 7, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 41, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 140, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 9, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 140, missing), null, "stickEnderEye",
                        null, getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing), "circuitAdvanced",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.BlockSkyCompass", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        "screwCertusQuartz", "plateSteel", "stickSteelMagnetic", "plateSteel", "screwCertusQuartz",
                        "plateSteel", "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.BlockSkyCompass", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        "screwCertusQuartz", "plateSteel", "stickSteelMagnetic", "plateSteel", "screwCertusQuartz",
                        "plateSteel", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 180, missing),
                new Object[] { "craftingToolScrewdriver", "plateTitanium", "craftingToolHardHammer",
                        "screwCertusQuartz", getModItem("gregtech", "gt.metaitem.01", 1, 32740, missing),
                        "screwCertusQuartz", "plateGlowstone", "plateRedAlloy", "plateGlowstone" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 380, missing),
                new Object[] { "stickNetherQuartz", "screwQuartzite", "stickNetherQuartz",
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 180, missing), "circuitGood",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing), "stickNetherQuartz",
                        "craftingToolScrewdriver", "stickNetherQuartz" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 380, missing),
                new Object[] { "stickNetherQuartz", "craftingToolScrewdriver", "stickNetherQuartz",
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 180, missing), "circuitGood",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing), "stickNetherQuartz",
                        "screwQuartzite", "stickNetherQuartz" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 360, missing),
                new Object[] { "craftingToolScrewdriver",
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 380, missing),
                        "craftingToolSoftHammer", "screwCertusQuartz",
                        getModItem("TConstruct", "CraftingSlab", 1, 0, missing), "screwCertusQuartz",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 500, missing),
                new Object[] { "craftingToolScrewdriver",
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 360, missing),
                        "craftingToolSoftHammer", getModItem("gregtech", "gt.metaitem.01", 1, 32635, missing),
                        getModItem("dreamcraft", "item.EngineeringProcessorItemAdvEmeraldCore", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32635, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32606, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32655, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32606, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 480, missing),
                new Object[] { "craftingToolScrewdriver",
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 380, missing),
                        "craftingToolSoftHammer", "screwCertusQuartz",
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 440, missing), "screwCertusQuartz",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 420, missing),
                new Object[] { "craftingToolScrewdriver",
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 400, missing),
                        "craftingToolHardHammer", "screwCertusQuartz",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 43, missing),
                        "screwCertusQuartz", getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 340, missing),
                new Object[] { "craftingToolScrewdriver",
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 380, missing),
                        "craftingToolSoftHammer", "screwCertusQuartz",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 52, missing),
                        "screwCertusQuartz", getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ToolWirelessTerminal", 1, 0, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 41, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 380, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 41, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing),
                        getModItem("appliedenergistics2", "tile.BlockDenseEnergyCell", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 28, missing),
                new Object[] { "platePlatinum", "plateTitanium", null, "plateRedAlloy",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 23, missing), "plateTitanium",
                        "platePlatinum", "plateTitanium", null });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 25, missing),
                new Object[] { "plateGold", "plateAluminium", null, "plateRedAlloy",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 23, missing), "plateAluminium",
                        "plateGold", "plateAluminium", null });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 52, missing),
                new Object[] { getModItem("appliedenergistics2", "tile.BlockQuartzGlass", 1, 0, missing),
                        "plateGlowstone", getModItem("appliedenergistics2", "tile.BlockQuartzGlass", 1, 0, missing),
                        "plateGlowstone", "itemCertusQuartz", "plateGlowstone", "plateAluminium", "plateAluminium",
                        "plateAluminium" });
        addShapelessCraftingRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 27, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 25, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 35, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 35, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 53, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 25, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 35, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 35, missing),
                        "craftingWorkBench" });
        addShapelessCraftingRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 26, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 25, missing),
                        "craftingRedstoneTorch", "craftingRedstoneTorch",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 23, missing) });
        addShapelessCraftingRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 29, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 28, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 23, missing) });
        addShapelessCraftingRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 31, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 28, missing),
                        getModItem("IC2", "upgradeModule", 1, 5, missing),
                        getModItem("IC2", "upgradeModule", 1, 5, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 23, missing) });
        addShapelessCraftingRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 30, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 28, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 7, missing) });
        addShapelessCraftingRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 55, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 28, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 9255, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 42, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 8, missing),
                        "gemCertusQuartz", "plateEnderPearl", "plateTitanium", "plateAluminium", "plateTitanium", null,
                        null, null });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 300, missing),
                new Object[] { "craftingToolScrewdriver",
                        getModItem("appliedenergistics2", "item.ToolCertusQuartzPickaxe", 1, 0, missing),
                        "craftingToolHardHammer", "screwCertusQuartz",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 44, missing),
                        "screwCertusQuartz", "gemFluix", "gemFluix", "gemFluix" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 120, missing),
                new Object[] { "boltIron", null, null, "boltIron" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 120, missing),
                new Object[] { "boltCopper", null, null, "boltCopper" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 120, missing),
                new Object[] { "boltBronze", null, null, "boltBronze" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 120, missing),
                new Object[] { "boltTin", null, null, "boltTin" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 2, 120, missing),
                new Object[] { "boltSteel", null, null, "boltSteel" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 2, 120, missing),
                new Object[] { "boltAluminium", null, null, "boltAluminium" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 120, missing),
                new Object[] { "boltLead", null, null, "boltLead" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 120, missing),
                new Object[] { "boltNickel", null, null, "boltNickel" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 120, missing),
                new Object[] { "boltSilver", null, null, "boltSilver" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 120, missing),
                new Object[] { "boltBrass", null, null, "boltBrass" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 120, missing),
                new Object[] { "boltInvar", null, null, "boltInvar" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 3, 120, missing),
                new Object[] { "boltStainlessSteel", null, null, "boltStainlessSteel" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 4, 120, missing),
                new Object[] { "boltTitanium", null, null, "boltTitanium" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 260, missing),
                new Object[] { "craftingToolScrewdriver", "plateTitanium", "craftingToolHardHammer",
                        "screwCertusQuartz",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 43, missing),
                        "screwCertusQuartz", getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 320, missing),
                new Object[] { "craftingToolScrewdriver", "blockHopper", "craftingToolHardHammer", "screwCertusQuartz",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 43, missing),
                        "screwCertusQuartz", getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 7, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 7, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 7, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 240, missing),
                new Object[] { "craftingToolScrewdriver", "plateTitanium", "craftingToolHardHammer",
                        "screwCertusQuartz",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 44, missing),
                        "screwCertusQuartz", getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 460, missing),
                new Object[] { "craftingToolScrewdriver", "plateTitanium", "craftingToolHardHammer",
                        "screwCertusQuartz",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        "screwCertusQuartz", getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 7, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 7, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 7, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ToolCertusQuartzWrench", 1, 0, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 1, missing),
                        "craftingToolWrench",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 1, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 1, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 1, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 1, missing), null,
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 1, missing), null });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ToolNetherQuartzWrench", 1, 0, missing),
                new Object[] { "gemQuartz", "craftingToolWrench", "gemQuartz", "gemQuartz", "gemQuartz", "gemQuartz",
                        null, "gemQuartz", null });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ToolMassCannon", 1, 0, missing),
                new Object[] { "plateTitanium", "plateTitanium",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 43, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 38, missing),
                        getModItem("appliedenergistics2", "tile.BlockDenseEnergyCell", 1, 0, missing), null,
                        "plateTitanium", null, null });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ToolMemoryCard", 1, 0, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 23, missing),
                        "circuitData", "plateTitanium", "plateGold", "plateRedAlloy", "plateGold", null, null, null });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ToolChargedStaff", 1, 0, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 1, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 1, missing), null,
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 1, missing),
                        getModItem("Thaumcraft", "FocusShock", 1, 0, missing), null, null, null, "stickThaumium" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ToolEntropyManipulator", 1, 0, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 7, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing), null,
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("appliedenergistics2", "tile.BlockEnergyCell", 1, 0, missing), null, null, null,
                        "stickThaumium" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ToolColorApplicator", 1, 0, missing),
                new Object[] { "wireGt01Aluminium",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 43, missing),
                        "wireGt01Aluminium",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 36, missing),
                        getModItem("appliedenergistics2", "tile.BlockEnergyCell", 1, 0, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 36, missing), null, "stickSteel",
                        null });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ToolBiometricCard", 1, 0, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32740, missing), "plateTitanium", "plateGold",
                        "plateRedAlloy", "plateGold", null, null, null });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.BlockWireless", 1, 0, missing),
                new Object[] { null, getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 41, missing), null,
                        "screwTitanium", getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 23, missing),
                        "screwTitanium", "craftingToolScrewdriver",
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 16, missing),
                        "craftingToolWrench" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 400, missing),
                new Object[] { "craftingToolScrewdriver", "itemIlluminatedPanel", "craftingToolHardHammer",
                        "screwCertusQuartz", getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 280, missing),
                        "screwCertusQuartz", getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 220, missing),
                new Object[] { "craftingToolScrewdriver", "chestWood", "craftingToolHardHammer", "screwCertusQuartz",
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 440, missing), "screwCertusQuartz",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17522, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemBasicStorageCell.1k", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing),
                        "screwCertusQuartz", "plateStainlessSteel",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 35, missing),
                        "plateStainlessSteel", "screwCertusQuartz", "plateAluminium", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemBasicStorageCell.1k", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing),
                        "screwCertusQuartz", "plateStainlessSteel",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 35, missing),
                        "plateStainlessSteel", "screwCertusQuartz", "plateAluminium", "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemBasicStorageCell.4k", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing),
                        "screwCertusQuartz", "plateStainlessSteel",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 36, missing),
                        "plateStainlessSteel", "screwCertusQuartz", "plateAluminium", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemBasicStorageCell.4k", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing),
                        "screwCertusQuartz", "plateStainlessSteel",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 36, missing),
                        "plateStainlessSteel", "screwCertusQuartz", "plateAluminium", "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemBasicStorageCell.16k", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing),
                        "screwCertusQuartz", "plateStainlessSteel",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 37, missing),
                        "plateStainlessSteel", "screwCertusQuartz", "plateAluminium", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemBasicStorageCell.16k", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing),
                        "screwCertusQuartz", "plateStainlessSteel",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 37, missing),
                        "plateStainlessSteel", "screwCertusQuartz", "plateAluminium", "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemBasicStorageCell.64k", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing),
                        "screwCertusQuartz", "plateStainlessSteel",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 38, missing),
                        "plateStainlessSteel", "screwCertusQuartz", "plateAluminium", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemBasicStorageCell.64k", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing),
                        "screwCertusQuartz", "plateStainlessSteel",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 38, missing),
                        "plateStainlessSteel", "screwCertusQuartz", "plateAluminium", "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemViewCell", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing),
                        "screwCertusQuartz", "plateStainlessSteel", "gemCertusQuartz", "plateStainlessSteel",
                        "screwCertusQuartz", "plateAluminium", "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemViewCell", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing),
                        "screwCertusQuartz", "plateStainlessSteel", "gemCertusQuartz", "plateStainlessSteel",
                        "screwCertusQuartz", "plateAluminium", "craftingToolScrewdriver" });
        addShapelessCraftingRecipe(
                getModItem("appliedenergistics2", "item.ItemViewCell", 1, 0, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 39, missing),
                        "gemCertusQuartz" });
        addShapelessCraftingRecipe(
                getModItem("appliedenergistics2", "item.ItemBasicStorageCell.1k", 1, 0, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 39, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 35, missing) });
        addShapelessCraftingRecipe(
                getModItem("appliedenergistics2", "item.ItemBasicStorageCell.4k", 1, 0, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 39, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 36, missing) });
        addShapelessCraftingRecipe(
                getModItem("appliedenergistics2", "item.ItemBasicStorageCell.16k", 1, 0, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 39, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 37, missing) });
        addShapelessCraftingRecipe(
                getModItem("appliedenergistics2", "item.ItemBasicStorageCell.64k", 1, 0, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 39, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 38, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemSpatialStorageCell.2Cubed", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing),
                        "screwCertusQuartz", "plateStainlessSteel",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 32, missing),
                        "plateStainlessSteel", "screwCertusQuartz", "plateAluminium", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemSpatialStorageCell.2Cubed", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing),
                        "screwCertusQuartz", "plateStainlessSteel",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 32, missing),
                        "plateStainlessSteel", "screwCertusQuartz", "plateAluminium", "craftingToolHardHammer" });
        addShapelessCraftingRecipe(
                getModItem("appliedenergistics2", "item.ItemSpatialStorageCell.2Cubed", 1, 0, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 39, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 32, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemSpatialStorageCell.16Cubed", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing),
                        "screwCertusQuartz", "plateStainlessSteel",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 33, missing),
                        "plateStainlessSteel", "screwCertusQuartz", "plateAluminium", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemSpatialStorageCell.16Cubed", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing),
                        "screwCertusQuartz", "plateStainlessSteel",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 33, missing),
                        "plateStainlessSteel", "screwCertusQuartz", "plateAluminium", "craftingToolHardHammer" });
        addShapelessCraftingRecipe(
                getModItem("appliedenergistics2", "item.ItemSpatialStorageCell.16Cubed", 1, 0, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 39, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 33, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemSpatialStorageCell.128Cubed", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing),
                        "screwCertusQuartz", "plateStainlessSteel",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 34, missing),
                        "plateStainlessSteel", "screwCertusQuartz", "plateAluminium", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemSpatialStorageCell.128Cubed", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing),
                        "screwCertusQuartz", "plateStainlessSteel",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 34, missing),
                        "plateStainlessSteel", "screwCertusQuartz", "plateAluminium", "craftingToolHardHammer" });
        addShapelessCraftingRecipe(
                getModItem("appliedenergistics2", "item.ItemSpatialStorageCell.128Cubed", 1, 0, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 39, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 34, missing) });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 39, missing),
                new Object[] { "craftingToolHardHammer", getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing),
                        "screwCertusQuartz", "plateStainlessSteel",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "plateStainlessSteel",
                        "screwCertusQuartz", "plateAluminium", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 39, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing),
                        "screwCertusQuartz", "plateStainlessSteel",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "plateStainlessSteel",
                        "screwCertusQuartz", "plateAluminium", "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 35, missing),
                new Object[] { "circuitPrimitive",
                        getModItem("dreamcraft", "item.ChargedCertusQuartzDust", 1, 0, missing), "circuitPrimitive",
                        getModItem("dreamcraft", "item.ChargedCertusQuartzDust", 1, 0, missing),
                        getModItem("dreamcraft", "item.LogicProcessorItemGoldCore", 1, 0, missing),
                        getModItem("dreamcraft", "item.ChargedCertusQuartzDust", 1, 0, missing), "circuitPrimitive",
                        getModItem("dreamcraft", "item.ChargedCertusQuartzDust", 1, 0, missing), "circuitPrimitive" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 36, missing),
                new Object[] { "circuitBasic",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 35, missing), "circuitBasic",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 35, missing),
                        getModItem("dreamcraft", "item.LogicProcessorItemGoldCore", 1, 0, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 35, missing), "circuitBasic",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 35, missing), "circuitBasic" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 37, missing),
                new Object[] { "circuitGood",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 36, missing), "circuitGood",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 36, missing),
                        getModItem("dreamcraft", "item.EngineeringProcessorItemDiamondCore", 1, 0, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 36, missing), "circuitGood",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 36, missing), "circuitGood" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 38, missing),
                new Object[] { "circuitAdvanced",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 37, missing), "circuitAdvanced",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 37, missing),
                        getModItem("dreamcraft", "item.EngineeringProcessorItemDiamondCore", 1, 0, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 37, missing), "circuitAdvanced",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 37, missing),
                        "circuitAdvanced" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 32, missing),
                new Object[] { "plateGlowstone",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 9, missing), "plateGlowstone",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 9, missing),
                        getModItem("dreamcraft", "item.EngineeringProcessorSpatialPulsatingCore", 1, 0, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 9, missing), "plateGlowstone",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 9, missing), "plateGlowstone" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 33, missing),
                new Object[] { "plateEnderPearl",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 32, missing), "plateEnderPearl",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 32, missing),
                        getModItem("dreamcraft", "item.EngineeringProcessorSpatialPulsatingCore", 1, 0, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 32, missing), "plateEnderPearl",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 32, missing),
                        "plateEnderPearl" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 34, missing),
                new Object[] { "plateEnderEye",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 33, missing), "plateEnderEye",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 33, missing),
                        getModItem("dreamcraft", "item.EngineeringProcessorSpatialPulsatingCore", 1, 0, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 33, missing), "plateEnderEye",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 33, missing), "plateEnderEye" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ToolPortableCell", 1, 0, missing),
                new Object[] { null, getModItem("appliedenergistics2", "item.ItemBasicStorageCell.1k", 1, 0, missing),
                        null, "screwTitanium", getModItem("appliedenergistics2", "tile.BlockChest", 1, 0, missing),
                        "screwTitanium", "craftingToolScrewdriver",
                        getModItem("appliedenergistics2", "tile.BlockEnergyCell", 1, 0, missing),
                        "craftingToolWrench" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "tile.BlockInscriber", 1, 0, missing),
                new Object[] { "plateTitanium", "gemFluix", "plateTitanium",
                        getModItem("IC2", "itemRecipePart", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 604, missing),
                        getModItem("IC2", "itemRecipePart", 1, 0, missing), "plateTitanium", "gemFluix",
                        "plateTitanium" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ToolCertusQuartzCuttingKnife", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", "screwTitanium", "stickWood", "gemCertusQuartz", "stickWood",
                        "screwTitanium", "plateCertusQuartz", "gemCertusQuartz", "craftingToolFile" });
        addShapedRecipe(
                getModItem("appliedenergistics2", "item.ToolNetherQuartzCuttingKnife", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", "screwTitanium", "stickWood", "gemNetherQuartz", "stickWood",
                        "screwTitanium", "plateNetherQuartz", "gemNetherQuartz", "craftingToolFile" });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glass", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 2516, missing))
                .itemOutputs(getModItem("appliedenergistics2", "tile.BlockQuartzGlass", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "tile.BlockQuartzGlass", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 8, 0, missing))
                .itemOutputs(getModItem("appliedenergistics2", "tile.BlockQuartzLamp", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "decorativeBlock2", 1, 7, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 2, 8, missing))
                .itemOutputs(getModItem("appliedenergistics2", "tile.BlockQuartzLamp", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "tile.BlockSkyStone", 8, 0, missing),
                        getModItem("minecraft", "chest", 1, 0, missing))
                .itemOutputs(getModItem("appliedenergistics2", "tile.BlockSkyChest", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "tile.BlockSkyStone", 8, 1, missing),
                        getModItem("minecraft", "chest", 1, 0, missing))
                .itemOutputs(getModItem("appliedenergistics2", "tile.BlockSkyChest", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "tile.BlockCraftingUnit", 1, 0, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 2, 24, missing))
                .itemOutputs(getModItem("appliedenergistics2", "tile.BlockCraftingUnit", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "tile.BlockCraftingUnit", 1, 0, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 35, missing))
                .itemOutputs(getModItem("appliedenergistics2", "tile.BlockCraftingStorage", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(400).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "tile.BlockCraftingUnit", 1, 0, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 36, missing))
                .itemOutputs(getModItem("appliedenergistics2", "tile.BlockCraftingStorage", 1, 1, missing))
                .noFluidInputs().noFluidOutputs().duration(400).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "tile.BlockCraftingUnit", 1, 0, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 37, missing))
                .itemOutputs(getModItem("appliedenergistics2", "tile.BlockCraftingStorage", 1, 2, missing))
                .noFluidInputs().noFluidOutputs().duration(400).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "tile.BlockCraftingUnit", 1, 0, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 38, missing))
                .itemOutputs(getModItem("appliedenergistics2", "tile.BlockCraftingStorage", 1, 3, missing))
                .noFluidInputs().noFluidOutputs().duration(400).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "tile.BlockCraftingUnit", 1, 0, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 400, missing))
                .itemOutputs(getModItem("appliedenergistics2", "tile.BlockCraftingMonitor", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23019, missing))
                .itemOutputs(getModItem("appliedenergistics2", "tile.BlockQuartzTorch", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 8516, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23019, missing))
                .itemOutputs(getModItem("appliedenergistics2", "tile.BlockLightDetector", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 180, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 200, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 180, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 160, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 200, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 180, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 160, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 180, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "redstone_torch", 1, 0, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 23, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 280, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 280, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 2, 16, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 80, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 100, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 80, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 80, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 100, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 3, 140, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 2, 8, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 3, 16, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "chest", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 27516, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 440, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17522, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 220, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17028, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 27516, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17522, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 240, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17028, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 27516, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 43, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17522, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 260, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 4, 23522, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27523, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 180, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 380, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 4, 23522, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27523, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 180, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 380, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 4, 23522, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27523, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 180, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 380, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 4, 23522, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27523, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 180, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 380, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 4, 23522, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27523, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 180, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17516, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 380, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 380, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 27516, missing),
                        getModItem("TConstruct", "CraftingSlab", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17522, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 360, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 360, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32635, missing),
                        getModItem("dreamcraft", "item.EngineeringProcessorItemAdvEmeraldCore", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32606, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32655, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 500, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 380, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 27516, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 440, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17522, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 480, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 400, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 27516, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 43, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17522, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 44, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 420, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 380, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 27516, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 52, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17522, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 340, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "hopper", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 27516, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 43, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 3, 7, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 320, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ToolCertusQuartzPickaxe", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 27516, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 44, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 3, 7, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 300, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17028, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 27516, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 3, 7, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 460, missing)).noFluidInputs()
                .noFluidOutputs().duration(360).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 180, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 27516, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 280, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 17522, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 400, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 160, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 27516, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 280, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 17522, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 400, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 200, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 27516, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 280, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 17522, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 400, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemBasicStorageCell.1k", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 27028, missing),
                        getModItem("appliedenergistics2", "tile.BlockChest", 1, 0, missing),
                        getModItem("appliedenergistics2", "tile.BlockEnergyCell", 1, 0, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ToolPortableCell", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.ChargedCertusQuartzDust", 1, 0, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 1, missing))
                .outputChances(7000).fluidInputs(FluidRegistry.getFluidStack("water", 200)).noFluidOutputs()
                .duration(2000).eut(24).addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.ChargedCertusQuartzDust", 1, 0, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 1, missing))
                .outputChances(9000).fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 100)).noFluidOutputs()
                .duration(1500).eut(24).addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.ChargedCertusQuartzDust", 1, 0, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 1, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("molten.void", 72)).noFluidOutputs()
                .duration(1000).eut(24).addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glass", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 2516, missing))
                .itemOutputs(getModItem("appliedenergistics2", "tile.BlockQuartzGlass", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).specialValue(1000).addTo(sBlastRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 2516, missing),
                        getModItem("minecraft", "redstone", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.ChargedCertusQuartzDust", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sChemicalRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.ChargedCertusQuartzDust", 3, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2017, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiMaterial", 3, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 1000)).noFluidOutputs().duration(900).eut(30)
                .addTo(sChemicalRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.ChargedCertusQuartzDust", 3, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2017, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiMaterial", 3, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 1000)).noFluidOutputs().duration(700)
                .eut(30).addTo(sChemicalRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("appliedenergistics2", "tile.BlockFluix", 1, 0, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiMaterial", 4, 8, missing))
                .outputChances(10000).noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 2, 23516, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 140, missing)).noFluidInputs()
                .noFluidOutputs().duration(80).eut(120).addTo(sWiremillRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.ChargedCertusQuartzRod", 1, 0, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 140, missing)).noFluidInputs()
                .noFluidOutputs().duration(80).eut(120).addTo(sWiremillRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 8, 23522, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 140, missing)).noFluidInputs()
                .noFluidOutputs().duration(80).eut(120).addTo(sWiremillRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 4, 23523, missing))
                .itemOutputs(getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 140, missing)).noFluidInputs()
                .noFluidOutputs().duration(80).eut(120).addTo(sWiremillRecipes);

    }
}
