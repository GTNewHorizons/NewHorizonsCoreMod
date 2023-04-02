package com.dreammaster.scripts;

import static gregtech.api.enums.ModIDs.AppliedEnergistics2;
import static gregtech.api.enums.ModIDs.Avaritia;
import static gregtech.api.enums.ModIDs.EternalSingularity;
import static gregtech.api.enums.ModIDs.GregTech;
import static gregtech.api.enums.ModIDs.TinkerConstruct;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
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
        return Arrays
                .asList(AppliedEnergistics2.modID, TinkerConstruct.modID, Avaritia.modID, EternalSingularity.modID);
    }

    @Override
    public void loadRecipes() {
        final ItemStack CraftingUnit = getModItem(AppliedEnergistics2.modID, "tile.BlockCraftingUnit", 1);
        final ItemStack CoCraftingUnit4x = getModItem(AppliedEnergistics2.modID, "tile.BlockCraftingUnit", 1, 2);
        final ItemStack CoCraftingUnit16x = getModItem(AppliedEnergistics2.modID, "tile.BlockCraftingUnit", 1, 3);
        final ItemStack SuperSpeedCard = getModItem(AppliedEnergistics2.modID, "item.ItemMultiMaterial", 1, 56);
        final ItemStack GLASS_PANE = getModItem(TinkerConstruct.modID, "GlassPane", 1);
        final ItemStack CERTUS_PLATE = GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L);
        final ItemStack AE2_ADVANCED_HOUSING = getModItem(AppliedEnergistics2.modID, "item.ItemMultiMaterial", 1, 61);
        final ItemStack AE2_HOUSING = getModItem(AppliedEnergistics2.modID, "item.ItemMultiMaterial", 1, 39);
        final ItemStack AE2_BLOCK_CONTAINER = getModItem(
                AppliedEnergistics2.modID,
                "item.ItemExtremeStorageCell.Container",
                1,
                0);
        final ItemStack AE2_ME_CHEST = getModItem(AppliedEnergistics2.modID, "tile.BlockChest", 1, 0);
        final ItemStack AE2_ME_Glass_Cable = getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 1, 16);
        final ItemStack AE2_ME_Covered_Cable = getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 1, 36);
        final ItemStack AE2_ME_Dense_Covered_Cable = getModItem(
                AppliedEnergistics2.modID,
                "item.ItemMultiPart",
                1,
                536);
        final ItemStack AE2_ME_Backbone_Covered_Cable = getModItem(
                AppliedEnergistics2.modID,
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
                new Object[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiMaterial", 1, 28),
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
                getModItem(AppliedEnergistics2.modID, "item.ItemMultiMaterial", 1, 57), // 256k
                getModItem(AppliedEnergistics2.modID, "item.ItemMultiMaterial", 1, 58), // 1024k
                getModItem(AppliedEnergistics2.modID, "item.ItemMultiMaterial", 1, 59), // 4096k
                getModItem(AppliedEnergistics2.modID, "item.ItemMultiMaterial", 1, 60), // 16384k
        };
        final ItemStack[] cells = new ItemStack[] {
                getModItem(AppliedEnergistics2.modID, "item.ItemAdvancedStorageCell.256k", 1), // 256k
                getModItem(AppliedEnergistics2.modID, "item.ItemAdvancedStorageCell.1024k", 1), // 1024k
                getModItem(AppliedEnergistics2.modID, "item.ItemAdvancedStorageCell.4096k", 1), // 4096k
                getModItem(AppliedEnergistics2.modID, "item.ItemAdvancedStorageCell.16384k", 1), // 16384k
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
                        getModItem(AppliedEnergistics2.modID, "item.ItemMultiMaterial", 1, 38), // 64k
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
                getModItem(AppliedEnergistics2.modID, "tile.BlockAdvancedCraftingStorage", 1, 0), // 256k
                getModItem(AppliedEnergistics2.modID, "tile.BlockAdvancedCraftingStorage", 1, 1), // 1024k
                getModItem(AppliedEnergistics2.modID, "tile.BlockAdvancedCraftingStorage", 1, 2), // 4096k
                getModItem(AppliedEnergistics2.modID, "tile.BlockAdvancedCraftingStorage", 1, 3), // 16384k
        };
        for (int i = 0; i < storage.length; i++) {
            GT_ModHandler.removeRecipeByOutput(storage[i]);
            GT_Values.RA.addAssemblerRecipe(
                    new ItemStack[] { components[i],
                            getModItem(AppliedEnergistics2.modID, "tile.BlockCraftingUnit", 1) },
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
                        getModItem(AppliedEnergistics2.modID, "item.ItemMultiMaterial", 1, 35), 'S',
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Titanium, 1), 'M', AE2_ME_CHEST, 'H',
                        AE2_HOUSING });
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiMaterial", 1, 35),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Titanium, 2), AE2_ME_CHEST, AE2_HOUSING,
                        GT_Utility.getIntegratedCircuit(4) },
                null,
                AE2_BLOCK_CONTAINER,
                40,
                120);
        // --- Fluix Covered Cable
        for (int i = 0; i < 16; i++) {
            FluixCoveredCableColor[i] = getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 1, 20 + i);

            addShapelessCraftingRecipe(
                    getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 1L, 36),
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
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 16),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PolyvinylChloride, 1) },
                Materials.StyreneButadieneRubber.getMolten(144L),
                getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 36),
                500,
                120);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 16),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PolyvinylChloride, 1) },
                Materials.Silicone.getMolten(144L),
                getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 36),
                500,
                120);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 16),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Polydimethylsiloxane, 1) },
                Materials.StyreneButadieneRubber.getMolten(144L),
                getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 36),
                500,
                120);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 16),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Polydimethylsiloxane, 1) },
                Materials.Silicone.getMolten(144L),
                getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 36),
                500,
                120);
        // --- Fluix Dense Covered Cable
        for (int i = 0; i < 16; i++) {
            FluixDenseCoveredCableColor[i] = getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 1, 520 + i);

            addShapelessCraftingRecipe(
                    getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 1L, 536),
                    new Object[] { FluixDenseCoveredCableColor[i] });
        }

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 36),
                        GT_Utility.getIntegratedCircuit(24) },
                Materials.StyreneButadieneRubber.getMolten(216L),
                AE2_ME_Dense_Covered_Cable,
                200,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 36),
                        GT_Utility.getIntegratedCircuit(24) },
                Materials.Silicone.getMolten(144L),
                AE2_ME_Dense_Covered_Cable,
                200,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 36),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.PolyvinylChloride, 1) },
                Materials.StyreneButadieneRubber.getMolten(72L),
                AE2_ME_Dense_Covered_Cable,
                200,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 36),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.PolyvinylChloride, 1) },
                Materials.Silicone.getMolten(72L),
                AE2_ME_Dense_Covered_Cable,
                200,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 36),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Polydimethylsiloxane, 1) },
                Materials.StyreneButadieneRubber.getMolten(72L),
                AE2_ME_Dense_Covered_Cable,
                200,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 36),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Polydimethylsiloxane, 1) },
                Materials.Silicone.getMolten(72L),
                AE2_ME_Dense_Covered_Cable,
                200,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 16, 36),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PolyvinylChloride, 1) },
                Materials.StyreneButadieneRubber.getMolten(288L),
                getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 536),
                700,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 16, 36),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PolyvinylChloride, 1) },
                Materials.Silicone.getMolten(288L),
                getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 536),
                700,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 16, 36),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Polydimethylsiloxane, 1) },
                Materials.StyreneButadieneRubber.getMolten(288L),
                getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 536),
                700,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 16, 36),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Polydimethylsiloxane, 1) },
                Materials.Silicone.getMolten(288L),
                getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 536),
                700,
                480);
        // --- Fluix Backbone Covered Cable
        for (int i = 0; i < 16; i++) {
            FluixBackboneCoveredCableColor[i] = getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 1, 540 + i);

            addShapelessCraftingRecipe(
                    getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 1L, 556),
                    new Object[] { FluixBackboneCoveredCableColor[i] });
        }

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 536),
                        GT_Utility.getIntegratedCircuit(24) },
                Materials.StyreneButadieneRubber.getMolten(432L),
                AE2_ME_Backbone_Covered_Cable,
                250,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 536),
                        GT_Utility.getIntegratedCircuit(24) },
                Materials.Silicone.getMolten(288L),
                AE2_ME_Dense_Covered_Cable,
                250,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 536),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.PolyvinylChloride, 1) },
                Materials.StyreneButadieneRubber.getMolten(144L),
                AE2_ME_Dense_Covered_Cable,
                250,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 536),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.PolyvinylChloride, 1) },
                Materials.Silicone.getMolten(144L),
                AE2_ME_Dense_Covered_Cable,
                250,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 536),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Polydimethylsiloxane, 1) },
                Materials.StyreneButadieneRubber.getMolten(144L),
                AE2_ME_Dense_Covered_Cable,
                250,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 536),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Polydimethylsiloxane, 1) },
                Materials.Silicone.getMolten(144L),
                AE2_ME_Dense_Covered_Cable,
                250,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 16, 536),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PolyvinylChloride, 1) },
                Materials.StyreneButadieneRubber.getMolten(576L),
                getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 556),
                900,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 16, 536),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PolyvinylChloride, 1) },
                Materials.Silicone.getMolten(576L),
                getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 556),
                900,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 16, 536),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Polydimethylsiloxane, 1) },
                Materials.StyreneButadieneRubber.getMolten(576L),
                getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 556),
                900,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 16, 536),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Polydimethylsiloxane, 1) },
                Materials.Silicone.getMolten(576L),
                getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 556),
                900,
                1920);
        // ME Smart Cable Fluix
        for (int i = 0; i < 16; i++) {
            FluixSmartCableColor[i] = getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 1, 40 + i);

            addShapelessCraftingRecipe(
                    getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 1L, 56),
                    new Object[] { FluixSmartCableColor[i] });
        }
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 16),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1), circuit1 },
                Materials.ConductiveIron.getMolten(144L),
                getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 56),
                100,
                120);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 36),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1), circuit1 },
                Materials.ConductiveIron.getMolten(144L),
                getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 56),
                100,
                120);
        // --- ME Smart Dense Cable Fluix
        for (int i = 0; i < 16; i++) {
            FluixDenseSmartCableColor[i] = getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 1, 60 + i);
            addShapelessCraftingRecipe(
                    getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 1L, 76),
                    new Object[] { FluixDenseSmartCableColor[i] });
        }
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 16, 56),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1), circuit1 },
                Materials.EnergeticAlloy.getMolten(144L),
                getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 76),
                150,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 536),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1), circuit1 },
                Materials.EnergeticAlloy.getMolten(144L),
                getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 76),
                150,
                480);
        // --- ME Smart Backbone Cable Fluix
        for (int i = 0; i < 16; i++) {
            FluixBackboneSmartCableColor[i] = getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 1, 560 + i);
            addShapelessCraftingRecipe(
                    getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 1L, 576),
                    new Object[] { FluixBackboneSmartCableColor[i] });
        }
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 16, 76),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1), circuit1 },
                Materials.VibrantAlloy.getMolten(144L),
                getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 576),
                200,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 556),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1), circuit1 },
                Materials.VibrantAlloy.getMolten(144L),
                getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 576),
                200,
                1920);

        // ME Quantum Storage
        GT_ModHandler
                .removeRecipeByOutput(getModItem(AppliedEnergistics2.modID, "item.ItemExtremeStorageCell.Quantum", 1));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(AppliedEnergistics2.modID, "item.ItemExtremeStorageCell.Quantum", 1),
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
        GT_ModHandler.removeRecipeByOutput(
                getModItem(AppliedEnergistics2.modID, "item.ItemExtremeStorageCell.Singularity", 1));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(AppliedEnergistics2.modID, "item.ItemExtremeStorageCell.Singularity", 1),
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
                getModItem(Avaritia.modID, "Resource", 1, 5),
                'c',
                getModItem(GregTech.modID, "gt.blockmachines", 1, 129),
                'd',
                components[3],
                'e',
                "blockInfinity",
                'f',
                getModItem(EternalSingularity.modID, "eternal_singularity", 1));

        // ME Void Storage
        GT_ModHandler.removeRecipeByOutput(getModItem(AppliedEnergistics2.modID, "item.ItemVoidStorageCell", 1));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.modID, "item.ItemVoidStorageCell", 1),
                new Object[] { "craftingToolHardHammer", "plateCertusQuartz", "screwCertusQuartz", "plateTungsten",
                        "gemEnderEye", "plateTungsten", "screwCertusQuartz", "plateTungsten",
                        "craftingToolScrewdriver" });
    }
}
