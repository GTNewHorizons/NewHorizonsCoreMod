package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.BartWorks;
import static gregtech.api.enums.Mods.Computronics;
import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.EternalSingularity;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronChests;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.alloySmelterRecipes;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.blastFurnaceRecipes;
import static gregtech.api.recipe.RecipeMaps.centrifugeRecipes;
import static gregtech.api.recipe.RecipeMaps.circuitAssemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.recipe.RecipeMaps.wiremillRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gregtech.api.util.GTRecipeConstants.UniversalChemical;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.avaritia.AvaritiaHelper;
import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.item.NHItemList;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;

public class ScriptAppliedEnergistics2 implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "AppliedEnergistics2";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                AppliedEnergistics2.ID,
                TinkerConstruct.ID,
                Avaritia.ID,
                EternalSingularity.ID,
                BartWorks.ID,
                ExtraUtilities.ID,
                IndustrialCraft2.ID,
                IronChests.ID,
                Thaumcraft.ID,
                DraconicEvolution.ID);
    }

    @Override
    public void loadRecipes() {
        final ItemStack CraftingUnit = getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1);
        final ItemStack CoCraftingUnit4x = getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1, 2);
        final ItemStack CoCraftingUnit16x = getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1, 3);
        final ItemStack SuperSpeedCard = getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 56);
        final ItemStack GLASS_PANE = getModItem(TinkerConstruct.ID, "GlassPane", 1);
        final ItemStack CERTUS_PLATE = GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L);
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
        ItemStack[] FluixCoveredCableColor = new ItemStack[16];
        ItemStack[] FluixDenseCoveredCableColor = new ItemStack[16];
        ItemStack[] FluixSmartCableColor = new ItemStack[16];
        ItemStack[] FluixDenseSmartCableColor = new ItemStack[16];
        ItemStack[] FluixGlassCableColor = new ItemStack[16];
        final ItemStack storageBus = getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 220, missing);

        // preconfigurated priorities for storage buses
        ItemStack preconfiguredStorageBus = storageBus.copy();
        for (int i = 1; i < 25; i++) {
            NBTTagCompound tag = new NBTTagCompound();
            tag.setInteger("priority", i);
            preconfiguredStorageBus.setTagCompound(tag);
            GTValues.RA.stdBuilder().itemInputs(storageBus, GTUtility.getIntegratedCircuit(i))
                    .itemOutputs(preconfiguredStorageBus).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(circuitAssemblerRecipes);

            addShapelessRecipe(preconfiguredStorageBus, storageBus, GTUtility.getIntegratedCircuit(i));
        }
        // Preconfigured p2ps

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemFluidCell", 1),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 460, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 463, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "cable", 1),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 460, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 468, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemPowerConduit", 1),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 460, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 466, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedstoneAlloy, 1L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 460, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 470, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Redstone, 1L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 460, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 461, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 1L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 460, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 467, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Computronics.ID, "computronics.ironNoteBlock", 1),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 460, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 472, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "chestMini", 1),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 460, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 462, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);

        // Hyper-Acceleration Card
        addShapelessRecipe(
                SuperSpeedCard,
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                CustomItemList.MysteriousCrystal,
                ItemList.AcceleratorLuV);

        // Quad Core
        GTValues.RA.stdBuilder()
                .itemInputs(CraftingUnit, GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.IV), 2))
                .itemOutputs(CoCraftingUnit4x).duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // 16 core
        GTValues.RA.stdBuilder()
                .itemInputs(CraftingUnit, GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.UV), 2))
                .itemOutputs(CoCraftingUnit16x).duration(5 * SECONDS).eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);

        // Advanced Storage Housing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GLASS_PANE,
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 3L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2L),
                        GTUtility.getIntegratedCircuit(3))
                .itemOutputs(AE2_ADVANCED_HOUSING).duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);
        GTModHandler.addCraftingRecipe(
                AE2_ADVANCED_HOUSING,
                new Object[] { "hPS", "CGC", "SCd", 'P', CERTUS_PLATE, 'S',
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 1L), 'C',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1L), 'G', GLASS_PANE });
        GTModHandler.addCraftingRecipe(
                AE2_ADVANCED_HOUSING,
                new Object[] { "dPS", "CGC", "SCh", 'P', CERTUS_PLATE, 'S',
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 1L), 'C',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1L), 'G', GLASS_PANE });

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
            GTModHandler.addCraftingRecipe(
                    cells[i],
                    new Object[] { "hPS", "CGC", "SCd", 'P', CERTUS_PLATE, 'S',
                            GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 1L), 'C',
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1L), 'G', components[i] });
            GTModHandler.addCraftingRecipe(
                    cells[i],
                    new Object[] { "dPS", "CGC", "SCh", 'P', CERTUS_PLATE, 'S',
                            GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 1L), 'C',
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1L), 'G', components[i] });
            addShapelessRecipe(cells[i], AE2_ADVANCED_HOUSING, components[i]);
        }
        GTModHandler.addCraftingRecipe(
                components[0],
                new Object[] { "CPC", "PXP", "CPC", 'C', "circuitData", 'P',
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 38), // 64k
                        'X', CustomItemList.EngineeringProcessorItemEmeraldCore.get(1) });
        GTModHandler.addCraftingRecipe(
                components[1],
                new Object[] { "CPC", "PXP", "CPC", 'C', "circuitElite", 'P', components[0], 'X',
                        CustomItemList.EngineeringProcessorItemEmeraldCore.get(1) });
        GTModHandler.addCraftingRecipe(
                components[2],
                new Object[] { "CPC", "PXP", "CPC", 'C', "circuitMaster", 'P', components[1], 'X',
                        CustomItemList.EngineeringProcessorItemAdvEmeraldCore.get(1) });
        GTModHandler.addCraftingRecipe(
                components[3],
                new Object[] { "CPC", "PXP", "CPC", 'C', "circuitSuperconductor", 'P', components[2], 'X',
                        CustomItemList.EngineeringProcessorItemAdvEmeraldCore.get(1) });
        FluidStack[] solders = new FluidStack[] { Materials.Lead.getMolten(288), Materials.Tin.getMolten(144),
                Materials.SolderingAlloy.getMolten(72), };
        for (FluidStack solder : solders) {
            // 256k
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.EV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 16),
                            CustomItemList.EngineeringProcessorItemEmeraldCore.get(1),
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(components[0]).fluidInputs(solder).duration(10 * SECONDS).eut(TierEU.RECIPE_EV)
                    .requiresCleanRoom().addTo(circuitAssemblerRecipes);
            // 1024k
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.EV, 16),
                            CustomItemList.EngineeringProcessorItemEmeraldCore.get(1),
                            ItemList.Circuit_Board_Multifiberglass_Elite.get(1),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(components[1]).fluidInputs(solder).duration(10 * SECONDS).eut(TierEU.RECIPE_IV)
                    .requiresCleanRoom().addTo(circuitAssemblerRecipes);
            // 4096k
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LuV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 16),
                            CustomItemList.EngineeringProcessorItemAdvEmeraldCore.get(1),
                            ItemList.Circuit_Board_Wetware_Extreme.get(1),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(components[2]).fluidInputs(solder).duration(10 * SECONDS).eut(TierEU.RECIPE_LuV)
                    .requiresCleanRoom().addTo(circuitAssemblerRecipes);
            // 16384k
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LuV, 16),
                            CustomItemList.EngineeringProcessorItemAdvEmeraldCore.get(1),
                            ItemList.Circuit_Board_Bio_Ultra.get(1),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(components[3]).fluidInputs(solder).duration(10 * SECONDS).eut(TierEU.RECIPE_UV)
                    .requiresCleanRoom().addTo(circuitAssemblerRecipes);
        }

        // Advanced Crafting Storage
        ItemStack[] storage = new ItemStack[] {
                getModItem(AppliedEnergistics2.ID, "tile.BlockAdvancedCraftingStorage", 1, 0), // 256k
                getModItem(AppliedEnergistics2.ID, "tile.BlockAdvancedCraftingStorage", 1, 1), // 1024k
                getModItem(AppliedEnergistics2.ID, "tile.BlockAdvancedCraftingStorage", 1, 2), // 4096k
                getModItem(AppliedEnergistics2.ID, "tile.BlockAdvancedCraftingStorage", 1, 3), // 16384k
        };
        for (int i = 0; i < storage.length; i++) {
            GTValues.RA.stdBuilder()
                    .itemInputs(components[i], getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1))
                    .itemOutputs(storage[i]).duration(20 * SECONDS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        }

        // ME Block Container
        GTModHandler.addCraftingRecipe(
                AE2_BLOCK_CONTAINER,
                new Object[] { " K ", "SMS", "dHw", 'K',
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35), 'S',
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Titanium, 1), 'M', AE2_ME_CHEST, 'H',
                        AE2_HOUSING });
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Titanium, 2),
                        AE2_ME_CHEST,
                        AE2_HOUSING,
                        GTUtility.getIntegratedCircuit(4))
                .itemOutputs(AE2_BLOCK_CONTAINER).duration(2 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Fluix Glass Cable
        for (int i = 0; i < 16; i++) {
            FluixGlassCableColor[i] = getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, i);

            addShapelessRecipe(
                    getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1L, 16),
                    FluixGlassCableColor[i]);
        }
        // --- Fluix Covered Cable
        for (int i = 0; i < 16; i++) {
            FluixCoveredCableColor[i] = getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 20 + i);

            addShapelessRecipe(
                    getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1L, 36),
                    FluixCoveredCableColor[i]);
        }
        GTValues.RA.stdBuilder().itemInputs(AE2_ME_Glass_Cable, GTUtility.getIntegratedCircuit(24))
                .itemOutputs(AE2_ME_Covered_Cable).fluidInputs(Materials.Rubber.getMolten(144L))
                .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(AE2_ME_Glass_Cable, GTUtility.getIntegratedCircuit(24))
                .itemOutputs(AE2_ME_Covered_Cable).fluidInputs(Materials.StyreneButadieneRubber.getMolten(108L))
                .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(AE2_ME_Glass_Cable, GTUtility.getIntegratedCircuit(24))
                .itemOutputs(AE2_ME_Covered_Cable).fluidInputs(Materials.Silicone.getMolten(72L))
                .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        AE2_ME_Glass_Cable,
                        GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.PolyvinylChloride, 1))
                .itemOutputs(AE2_ME_Covered_Cable).fluidInputs(Materials.StyreneButadieneRubber.getMolten(36L))
                .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        AE2_ME_Glass_Cable,
                        GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.PolyvinylChloride, 1))
                .itemOutputs(AE2_ME_Covered_Cable).fluidInputs(Materials.Silicone.getMolten(36L))
                .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        AE2_ME_Glass_Cable,
                        GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Polydimethylsiloxane, 1))
                .itemOutputs(AE2_ME_Covered_Cable).fluidInputs(Materials.StyreneButadieneRubber.getMolten(36L))
                .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        AE2_ME_Glass_Cable,
                        GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Polydimethylsiloxane, 1))
                .itemOutputs(AE2_ME_Covered_Cable).fluidInputs(Materials.Silicone.getMolten(36L))
                .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 16),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.PolyvinylChloride, 1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36))
                .fluidInputs(Materials.StyreneButadieneRubber.getMolten(144L)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 16),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.PolyvinylChloride, 1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36))
                .fluidInputs(Materials.Silicone.getMolten(144L)).duration(25 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 16),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Polydimethylsiloxane, 1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36))
                .fluidInputs(Materials.StyreneButadieneRubber.getMolten(144L)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 16),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Polydimethylsiloxane, 1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36))
                .fluidInputs(Materials.Silicone.getMolten(144L)).duration(25 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        // --- Fluix Dense Covered Cable
        for (int i = 0; i < 16; i++) {
            FluixDenseCoveredCableColor[i] = getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 520 + i);

            addShapelessRecipe(
                    getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1L, 536),
                    FluixDenseCoveredCableColor[i]);
        }

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36),
                        GTUtility.getIntegratedCircuit(24))
                .itemOutputs(AE2_ME_Dense_Covered_Cable).fluidInputs(Materials.StyreneButadieneRubber.getMolten(216L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36),
                        GTUtility.getIntegratedCircuit(24))
                .itemOutputs(AE2_ME_Dense_Covered_Cable).fluidInputs(Materials.Silicone.getMolten(144L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36),
                        GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.PolyvinylChloride, 1))
                .itemOutputs(AE2_ME_Dense_Covered_Cable).fluidInputs(Materials.StyreneButadieneRubber.getMolten(72L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36),
                        GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.PolyvinylChloride, 1))
                .itemOutputs(AE2_ME_Dense_Covered_Cable).fluidInputs(Materials.Silicone.getMolten(72L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36),
                        GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Polydimethylsiloxane, 1))
                .itemOutputs(AE2_ME_Dense_Covered_Cable).fluidInputs(Materials.StyreneButadieneRubber.getMolten(72L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36),
                        GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Polydimethylsiloxane, 1))
                .itemOutputs(AE2_ME_Dense_Covered_Cable).fluidInputs(Materials.Silicone.getMolten(72L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 36),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.PolyvinylChloride, 1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 536))
                .fluidInputs(Materials.StyreneButadieneRubber.getMolten(288L)).duration(35 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 36),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.PolyvinylChloride, 1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 536))
                .fluidInputs(Materials.Silicone.getMolten(288L)).duration(35 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 36),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Polydimethylsiloxane, 1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 536))
                .fluidInputs(Materials.StyreneButadieneRubber.getMolten(288L)).duration(35 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 36),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Polydimethylsiloxane, 1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 536))
                .fluidInputs(Materials.Silicone.getMolten(288L)).duration(35 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        // ME Smart Cable Fluix
        for (int i = 0; i < 16; i++) {
            FluixSmartCableColor[i] = getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 40 + i);

            addShapelessRecipe(
                    getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1L, 56),
                    FluixSmartCableColor[i]);
        }
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 16),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 56))
                .fluidInputs(Materials.ConductiveIron.getMolten(144L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 56))
                .fluidInputs(Materials.ConductiveIron.getMolten(144L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        // --- ME Smart Dense Cable Fluix
        for (int i = 0; i < 16; i++) {
            FluixDenseSmartCableColor[i] = getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 60 + i);
            addShapelessRecipe(
                    getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1L, 76),
                    FluixDenseSmartCableColor[i]);
        }
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 56),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 76))
                .fluidInputs(Materials.EnergeticAlloy.getMolten(144L)).duration(7 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 536),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 76))
                .fluidInputs(Materials.EnergeticAlloy.getMolten(144L)).duration(7 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // ME Quantum Storage
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

        // ME Singularity crafting storage
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockSingularityCraftingStorage", 1),
                "abcfhfcba",
                "bcdfhfdcb",
                "cdefhfedc",
                "fffgigfff",
                "hhhijihhh",
                "fffgigfff",
                "cdefhfedc",
                "bcdfhfdcb",
                "abcfhfcba",
                'a',
                getModItem(AppliedEnergistics2.ID, "tile.BlockCreativeEnergyCell", 1),
                'b',
                CustomItemList.PikoCircuit.get(1L),
                'c',
                ItemList.Field_Generator_UIV.get(1L),
                'd',
                getModItem(DraconicEvolution.ID, "reactorStabilizer", 1),
                'e',
                GTOreDictUnificator.get(OrePrefixes.nanite, MaterialsUEVplus.TranscendentMetal, 1L),
                'f',
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Infinity, 1L),
                'g',
                GTOreDictUnificator.get(OrePrefixes.frameGt, MaterialsUEVplus.SpaceTime, 1L),
                'h',
                GTOreDictUnificator.get(OrePrefixes.wireGt01, MaterialsUEVplus.SpaceTime, 1L),
                'i',
                getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1),
                'j',
                getModItem(AppliedEnergistics2.ID, "item.ItemExtremeStorageCell.Singularity", 1));

        // ME Void Storage
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemVoidStorageCell", 1),
                "craftingToolHardHammer",
                "plateCertusQuartz",
                "screwCertusQuartz",
                "plateTungsten",
                "gemEnderEye",
                "plateTungsten",
                "screwCertusQuartz",
                "plateTungsten",
                "craftingToolScrewdriver");

        AvaritiaHelper.removeExtremeCraftingRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockCreativeEnergyCell", 1, 0, missing)); // stays
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockCreativeEnergyCell", 1, 0, missing),
                "aaaaaaaaa",
                "abbbcbbba",
                "abbbcbbba",
                "abbbcbbba",
                "acccdccca",
                "abbbcbbba",
                "abbbcbbba",
                "abbbcbbba",
                "aaaaaaaaa",
                'a',
                "ingotInfinity",
                'b',
                getModItem(AppliedEnergistics2.ID, "tile.BlockDenseEnergyCell", 1, 0, missing),
                'c',
                CustomItemList.EngineeringProcessorItemAdvEmeraldCore.get(1L),
                'd',
                "blockCosmicNeutronium");

        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockController", 1, 0, missing),
                "plateTitanium",
                "circuitAdvanced",
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockFluix", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                "plateTitanium",
                "circuitAdvanced",
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 8, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "circuitAdvanced",
                getModItem(AppliedEnergistics2.ID, "tile.BlockFluix", 1, 0, missing),
                "circuitAdvanced",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "cableGt08Aluminium",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockDenseEnergyCell", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1, 0, missing),
                "circuitMaster",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                "circuitMaster",
                getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1, 0, missing),
                ItemList.Battery_Buffer_4by4_EV.get(1L),
                getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1, 0, missing));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockChest", 1, 0, missing),
                "plateStainlessSteel",
                "circuitGood",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16, missing),
                getModItem(IronChests.ID, "BlockIronChest", 1, 4, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16, missing),
                "plateStainlessSteel",
                "circuitGood",
                "plateStainlessSteel");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockDrive", 1, 0, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockChest", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16, missing),
                "plateTitanium",
                "circuitAdvanced",
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzGrowthAccelerator", 1, 0, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzGlass", 1, 0, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16, missing),
                ItemList.Machine_EV_Autoclave.get(1L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1, 0, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                "plateTitanium",
                "circuitBasic",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                "circuitBasic",
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23, missing),
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockMolecularAssembler", 1, 0, missing),
                "plateTitanium",
                "blockGlass",
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 44, missing),
                ItemList.Machine_EV_Assembler.get(1L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43, missing),
                "plateTitanium",
                "blockGlass",
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockCharger", 1, 0, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7, missing),
                "plateTitanium",
                "cableGt01Copper",
                ItemList.Machine_EV_Electrolyzer.get(1L),
                "cableGt01Copper",
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7, missing),
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuantumRing", 1, 0, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuantumLinkChamber", 1, 0, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzGlass", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9, missing),
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockSpatialPylon", 1, 0, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 8, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 8, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16, missing),
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockSpatialIOPort", 1, 0, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "tile.BlockSpatialPylon", 1, 0, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockIOPort", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1, 0, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 44, missing),
                ItemList.Casing_EV.get(1L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16, missing),
                "plateTitanium");
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 440, missing));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockCellWorkbench", 1, 0, missing),
                "craftingToolScrewdriver",
                ItemList.Cover_Screen.get(1L),
                "craftingToolWrench",
                "screwTitanium",
                getModItem(Minecraft.ID, "crafting_table", 1, 0, missing),
                "screwTitanium",
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23, missing),
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockIOPort", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockDrive", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockDrive", 1, 0, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockCondenser", 1, 0, missing),
                "plateTitanium",
                ItemList.Electric_Piston_EV.get(1L),
                "plateTitanium",
                ItemList.Electric_Piston_EV.get(1L),
                ItemList.Hull_EV.get(1L),
                ItemList.Electric_Piston_EV.get(1L),
                "plateTitanium",
                ItemList.Electric_Piston_EV.get(1L),
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyAcceptor", 1, 0, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7, missing),
                "plateGlowstone",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7, missing),
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockVibrationChamber", 1, 0, missing),
                "plateTitanium",
                "screwTitanium",
                "plateTitanium",
                "craftingToolScrewdriver",
                ItemList.Machine_EV_E_Furnace.get(1L),
                "craftingToolWrench",
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyAcceptor", 1, 0, missing),
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockSecurity", 1, 0, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "tile.BlockChest", 1, 0, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 37, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16, missing),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.SkyStoneStairBlock", 4, 0, missing),
                null,
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 0, missing),
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 0, missing));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.SkyStoneBlockStairBlock", 4, 0, missing),
                null,
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 1, missing),
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 1, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 1, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 1, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 1, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 1, missing));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.SkyStoneBrickStairBlock", 4, 0, missing),
                null,
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 2, missing),
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 2, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 2, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 2, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 2, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 2, missing));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.SkyStoneSmallBrickStairBlock", 4, 0, missing),
                null,
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 3, missing),
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 3, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 3, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 3, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 3, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 3, missing));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.FluixStairBlock", 4, 0, missing),
                null,
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockFluix", 1, 0, missing),
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockFluix", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockFluix", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockFluix", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockFluix", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockFluix", 1, 0, missing));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.QuartzStairBlock", 4, 0, missing),
                null,
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartz", 1, 0, missing),
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartz", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartz", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartz", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartz", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartz", 1, 0, missing));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.ChiseledQuartzStairBlock", 4, 0, missing),
                null,
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzChiseled", 1, 0, missing),
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzChiseled", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzChiseled", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzChiseled", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzChiseled", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzChiseled", 1, 0, missing));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.QuartzPillarStairBlock", 4, 0, missing),
                null,
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzPillar", 1, 0, missing),
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzPillar", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzPillar", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzPillar", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzPillar", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzPillar", 1, 0, missing));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 16, missing),
                "stickCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 8, missing),
                "stickCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 140, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 140, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 140, missing),
                "stickCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 8, missing),
                "stickCertusQuartz");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 44, missing),
                "stickNetherQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                "stickNetherQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 12, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                "stickNetherQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                "stickNetherQuartz");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 43, missing),
                "stickCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                "stickCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 12, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                "stickCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                "stickCertusQuartz");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 12, missing),
                "plateEnderEye",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 12, missing),
                "plateEnderEye",
                "gemEnderPearl",
                "plateEnderEye",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 12, missing),
                "plateEnderEye",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 12, missing));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7, missing),
                "plateEnderEye",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7, missing),
                "plateEnderEye",
                "gemEnderPearl",
                "plateEnderEye",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7, missing),
                "plateEnderEye",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7, missing));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 41, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 140, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 140, missing),
                null,
                "stickEnderEye",
                null,
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "circuitAdvanced",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyCompass", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "screwCertusQuartz",
                "plateSteel",
                "stickSteelMagnetic",
                "plateSteel",
                "screwCertusQuartz",
                "plateSteel",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyCompass", 1, 0, missing),
                "craftingToolHardHammer",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "screwCertusQuartz",
                "plateSteel",
                "stickSteelMagnetic",
                "plateSteel",
                "screwCertusQuartz",
                "plateSteel",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 180, missing),
                "craftingToolScrewdriver",
                "plateTitanium",
                "craftingToolHardHammer",
                "screwCertusQuartz",
                ItemList.Cover_Screen.get(1L),
                "screwCertusQuartz",
                "plateGlowstone",
                "plateRedAlloy",
                "plateGlowstone");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 380, missing),
                "stickNetherQuartz",
                "screwQuartzite",
                "stickNetherQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 180, missing),
                "circuitGood",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "stickNetherQuartz",
                "craftingToolScrewdriver",
                "stickNetherQuartz");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 380, missing),
                "stickNetherQuartz",
                "craftingToolScrewdriver",
                "stickNetherQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 180, missing),
                "circuitGood",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "stickNetherQuartz",
                "screwQuartzite",
                "stickNetherQuartz");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 360, missing),
                "craftingToolScrewdriver",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 380, missing),
                "craftingToolSoftHammer",
                "screwCertusQuartz",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 0, missing),
                "screwCertusQuartz",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 500, missing),
                "craftingToolScrewdriver",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 360, missing),
                "craftingToolSoftHammer",
                ItemList.Conveyor_Module_LuV.get(1L),
                CustomItemList.EngineeringProcessorItemAdvEmeraldCore.get(1L),
                ItemList.Conveyor_Module_LuV.get(1L),
                ItemList.Electric_Motor_LuV.get(1L),
                ItemList.Robot_Arm_LuV.get(1L),
                ItemList.Electric_Motor_LuV.get(1L));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 480, missing),
                "craftingToolScrewdriver",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 380, missing),
                "craftingToolSoftHammer",
                "screwCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 440, missing),
                "screwCertusQuartz",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 420, missing),
                "craftingToolScrewdriver",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 400, missing),
                "craftingToolHardHammer",
                "screwCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43, missing),
                "screwCertusQuartz",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 44, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 340, missing),
                "craftingToolScrewdriver",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 380, missing),
                "craftingToolSoftHammer",
                "screwCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 52, missing),
                "screwCertusQuartz",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ToolWirelessTerminal", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 41, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 380, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 41, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                getModItem(AppliedEnergistics2.ID, "tile.BlockDenseEnergyCell", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28, missing),
                "platePlatinum",
                "plateTitanium",
                null,
                "plateRedAlloy",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23, missing),
                "plateTitanium",
                "platePlatinum",
                "plateTitanium",
                null);
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 25, missing),
                "plateGold",
                "plateAluminium",
                null,
                "plateRedAlloy",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23, missing),
                "plateAluminium",
                "plateGold",
                "plateAluminium",
                null);
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 52, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzGlass", 1, 0, missing),
                "plateGlowstone",
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzGlass", 1, 0, missing),
                "plateGlowstone",
                "itemCertusQuartz",
                "plateGlowstone",
                "plateAluminium",
                "plateAluminium",
                "plateAluminium");
        // capacity card
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 27, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 25, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1, missing));
        // stick
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 64, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 25, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35, missing),
                "slimeball");
        // crafting card
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 53, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 25, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35, missing),
                "craftingWorkBench");
        // redstone card
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 26, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 25, missing),
                "craftingRedstoneTorch",
                "craftingRedstoneTorch",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23, missing));
        // fuzzy card
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 29, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23, missing));
        // inverter card
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 31, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28, missing),
                getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 5, missing),
                getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 5, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23, missing));
        // acceleration card
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 30, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7, missing));
        // oredictionary card
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 55, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                ItemList.Automation_TypeFilter_IV.get(1L));
        // wireless booster
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 42, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 8, missing),
                "gemCertusQuartz",
                "plateEnderPearl",
                "plateTitanium",
                "plateAluminium",
                "plateTitanium",
                null,
                null,
                null);
        // Me Annihilation plane
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 300, missing),
                "craftingToolScrewdriver",
                getModItem(AppliedEnergistics2.ID, "item.ToolCertusQuartzPickaxe", 1, 0, missing),
                "craftingToolHardHammer",
                "screwCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 44, missing),
                "screwCertusQuartz",
                "gemFluix",
                "gemFluix",
                "gemFluix");
        // cable anchor block
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 120, missing),
                "boltIron",
                null,
                null,
                "boltIron");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 120, missing),
                "boltCopper",
                null,
                null,
                "boltCopper");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 120, missing),
                "boltBronze",
                null,
                null,
                "boltBronze");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 120, missing),
                "boltTin",
                null,
                null,
                "boltTin");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 120, missing),
                "boltSteel",
                null,
                null,
                "boltSteel");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 120, missing),
                "boltAluminium",
                null,
                null,
                "boltAluminium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 120, missing),
                "boltLead",
                null,
                null,
                "boltLead");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 120, missing),
                "boltNickel",
                null,
                null,
                "boltNickel");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 120, missing),
                "boltSilver",
                null,
                null,
                "boltSilver");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 120, missing),
                "boltBrass",
                null,
                null,
                "boltBrass");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 120, missing),
                "boltInvar",
                null,
                null,
                "boltInvar");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 3, 120, missing),
                "boltStainlessSteel",
                null,
                null,
                "boltStainlessSteel");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 120, missing),
                "boltTitanium",
                null,
                null,
                "boltTitanium");
        // ME export bus
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 260, missing),
                "craftingToolScrewdriver",
                "plateTitanium",
                "craftingToolHardHammer",
                "screwCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43, missing),
                "screwCertusQuartz",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                ItemList.Electric_Piston_LV.get(1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L));
        // ME formation plane
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 320, missing),
                "craftingToolScrewdriver",
                "blockHopper",
                "craftingToolHardHammer",
                "screwCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43, missing),
                "screwCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7, missing));
        // ME import bus
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 240, missing),
                "craftingToolScrewdriver",
                "plateTitanium",
                "craftingToolHardHammer",
                "screwCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 44, missing),
                "screwCertusQuartz",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                ItemList.Electric_Piston_LV.get(1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L));
        // p2p tunnel - ME
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 460, missing),
                "craftingToolScrewdriver",
                "plateTitanium",
                "craftingToolHardHammer",
                "screwCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                "screwCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7, missing));
        // certuz quartz wrench
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ToolCertusQuartzWrench", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1, missing),
                "craftingToolWrench",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1, missing),
                null,
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1, missing),
                null);
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ToolNetherQuartzWrench", 1, 0, missing),
                "gemQuartz",
                "craftingToolWrench",
                "gemQuartz",
                "gemQuartz",
                "gemQuartz",
                "gemQuartz",
                null,
                "gemQuartz",
                null);
        // mass cannon
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ToolMassCannon", 1, 0, missing),
                "plateTitanium",
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 38, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockDenseEnergyCell", 1, 0, missing),
                null,
                "plateTitanium",
                null,
                null);
        // memory card
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ToolMemoryCard", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23, missing),
                "circuitData",
                "plateTitanium",
                "plateGold",
                "plateRedAlloy",
                "plateGold",
                null,
                null,
                null);
        // priority card
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ToolPriorityCard", 1, 0, missing),
                "plateTungstenSteel",
                "circuitElite",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                "plateDiamond",
                "plateRedAlloy",
                "plateDiamond",
                null,
                null,
                null);
        // charged staff
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ToolChargedStaff", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1, missing),
                null,
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1, missing),
                getModItem(Thaumcraft.ID, "FocusShock", 1, 0, missing),
                null,
                null,
                null,
                "stickThaumium");
        // entropy manipulator
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ToolEntropyManipulator", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                null,
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1, 0, missing),
                null,
                null,
                null,
                "stickThaumium");
        // color applicator
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ToolColorApplicator", 1, 0, missing),
                "wireGt01Aluminium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43, missing),
                "wireGt01Aluminium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 36, missing),
                getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 36, missing),
                null,
                "stickSteel",
                null);
        // biometric card
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ToolBiometricCard", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                ItemList.Cover_Screen.get(1L),
                "plateTitanium",
                "plateGold",
                "plateRedAlloy",
                "plateGold",
                null,
                null,
                null);
        // ME wireless access point
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockWireless", 1, 0, missing),
                null,
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 41, missing),
                null,
                "screwTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23, missing),
                "screwTitanium",
                "craftingToolScrewdriver",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16, missing),
                "craftingToolWrench");
        // ME storage monitor
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 400, missing),
                "craftingToolScrewdriver",
                "itemIlluminatedPanel",
                "craftingToolHardHammer",
                "screwCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 280, missing),
                "screwCertusQuartz",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L));
        // ME storage bus
        addShapedRecipe(
                storageBus,
                "craftingToolScrewdriver",
                "chestWood",
                "craftingToolHardHammer",
                "screwCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 440, missing),
                "screwCertusQuartz",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                ItemList.Electric_Piston_LV.get(1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L));
        // 1k storage cell
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.1k", 1, 0, missing),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35, missing),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.1k", 1, 0, missing),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35, missing),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolHardHammer");
        // 4k storage cell
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.4k", 1, 0, missing),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 36, missing),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.4k", 1, 0, missing),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 36, missing),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolHardHammer");
        // 16k storage cell
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.16k", 1, 0, missing),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 37, missing),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.16k", 1, 0, missing),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 37, missing),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolHardHammer");
        // 64k storage cell
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.64k", 1, 0, missing),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 38, missing),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.64k", 1, 0, missing),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 38, missing),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolHardHammer");
        // viewing cell
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemViewCell", 1, 0, missing),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                "gemCertusQuartz",
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemViewCell", 1, 0, missing),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                "gemCertusQuartz",
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolScrewdriver");
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemViewCell", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 39, missing),
                "gemCertusQuartz");
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.1k", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 39, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35, missing));
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.4k", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 39, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 36, missing));
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.16k", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 39, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 37, missing));
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.64k", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 39, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 38, missing));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemSpatialStorageCell.2Cubed", 1, 0, missing),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 32, missing),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemSpatialStorageCell.2Cubed", 1, 0, missing),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 32, missing),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolHardHammer");
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemSpatialStorageCell.2Cubed", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 39, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 32, missing));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemSpatialStorageCell.16Cubed", 1, 0, missing),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 33, missing),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemSpatialStorageCell.16Cubed", 1, 0, missing),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 33, missing),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolHardHammer");
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemSpatialStorageCell.16Cubed", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 39, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 33, missing));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemSpatialStorageCell.128Cubed", 1, 0, missing),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 34, missing),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemSpatialStorageCell.128Cubed", 1, 0, missing),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 34, missing),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolHardHammer");
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemSpatialStorageCell.128Cubed", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 39, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 34, missing));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 39, missing),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 39, missing),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35, missing),
                "circuitPrimitive",
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartzCharged, 1),
                "circuitPrimitive",
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartzCharged, 1),
                CustomItemList.LogicProcessorItemGoldCore.get(1L),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartzCharged, 1),
                "circuitPrimitive",
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartzCharged, 1),
                "circuitPrimitive");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 36, missing),
                "circuitBasic",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35, missing),
                "circuitBasic",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35, missing),
                CustomItemList.LogicProcessorItemGoldCore.get(1L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35, missing),
                "circuitBasic",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35, missing),
                "circuitBasic");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 37, missing),
                "circuitGood",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 36, missing),
                "circuitGood",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 36, missing),
                CustomItemList.EngineeringProcessorItemDiamondCore.get(1L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 36, missing),
                "circuitGood",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 36, missing),
                "circuitGood");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 38, missing),
                "circuitAdvanced",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 37, missing),
                "circuitAdvanced",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 37, missing),
                CustomItemList.EngineeringProcessorItemDiamondCore.get(1L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 37, missing),
                "circuitAdvanced",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 37, missing),
                "circuitAdvanced");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 32, missing),
                "plateGlowstone",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9, missing),
                "plateGlowstone",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9, missing),
                NHItemList.EngineeringProcessorSpatialPulsatingCore.getIS(1),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9, missing),
                "plateGlowstone",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9, missing),
                "plateGlowstone");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 33, missing),
                "plateEnderPearl",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 32, missing),
                "plateEnderPearl",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 32, missing),
                NHItemList.EngineeringProcessorSpatialPulsatingCore.getIS(1),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 32, missing),
                "plateEnderPearl",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 32, missing),
                "plateEnderPearl");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 34, missing),
                "plateEnderEye",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 33, missing),
                "plateEnderEye",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 33, missing),
                NHItemList.EngineeringProcessorSpatialPulsatingCore.getIS(1),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 33, missing),
                "plateEnderEye",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 33, missing),
                "plateEnderEye");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ToolPortableCell", 1, 0, missing),
                null,
                getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.1k", 1, 0, missing),
                null,
                "screwTitanium",
                getModItem(AppliedEnergistics2.ID, "tile.BlockChest", 1, 0, missing),
                "screwTitanium",
                "craftingToolScrewdriver",
                getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1, 0, missing),
                "craftingToolWrench");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockInscriber", 1, 0, missing),
                "plateTitanium",
                "gemFluix",
                "plateTitanium",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                ItemList.Machine_EV_Press.get(1L),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                "plateTitanium",
                "gemFluix",
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ToolCertusQuartzCuttingKnife", 1, 0, missing),
                "craftingToolHardHammer",
                "screwTitanium",
                "stickWood",
                "gemCertusQuartz",
                "stickWood",
                "screwTitanium",
                "plateCertusQuartz",
                "gemCertusQuartz",
                "craftingToolFile");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ToolNetherQuartzCuttingKnife", 1, 0, missing),
                "craftingToolHardHammer",
                "screwTitanium",
                "stickWood",
                "gemNetherQuartz",
                "stickWood",
                "screwTitanium",
                "plateNetherQuartz",
                "gemNetherQuartz",
                "craftingToolFile");

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzGlass", 1, 0, missing),
                        getModItem(Minecraft.ID, "glowstone_dust", 8, 0, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzLamp", 1, 0, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 7, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 8, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzLamp", 1, 0, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 8, 0, missing),
                        getModItem(Minecraft.ID, "chest", 1, 0, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockSkyChest", 1, 0, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 8, 1, missing),
                        getModItem(Minecraft.ID, "chest", 1, 0, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockSkyChest", 1, 1, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1, 0, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 24, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1, 1, missing))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1, 0, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingStorage", 1, 0, missing))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1, 0, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 36, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingStorage", 1, 1, missing))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1, 0, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 37, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingStorage", 1, 2, missing))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1, 0, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 38, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingStorage", 1, 3, missing))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1, 0, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 400, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingMonitor", 1, 0, missing))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzTorch", 1, 0, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.gem, Materials.CertusQuartz, 1L),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockLightDetector", 1, 0, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 180, missing),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 200, missing))
                .duration(5 * SECONDS).eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 180, missing),
                        GTUtility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 160, missing))
                .duration(5 * SECONDS).eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 200, missing),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 180, missing))
                .duration(5 * SECONDS).eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 160, missing),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 180, missing))
                .duration(5 * SECONDS).eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "redstone_torch", 1, 0, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 280, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 280, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 16, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 80, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 100, missing),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 80, missing))
                .duration(5 * SECONDS).eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 80, missing),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 100, missing))
                .duration(5 * SECONDS).eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 3, 140, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 8, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 3, 16, missing))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "chest", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 440, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 2),
                        ItemList.Electric_Piston_LV.get(1L))
                .itemOutputs(storageBus).duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 44, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 2),
                        ItemList.Electric_Piston_LV.get(1L))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 240, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 2),
                        ItemList.Electric_Piston_LV.get(1L))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 260, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // ME Terminal
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.NetherQuartz, 4),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Quartzite, 1),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 180, missing),
                        GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.MV), 1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 380, missing))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // ME Crafting Terminal
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 380, missing),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 360, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // ME Processing Pattern Terminal
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 360, missing),
                        ItemList.Conveyor_Module_LuV.get(2L),
                        CustomItemList.EngineeringProcessorItemAdvEmeraldCore.get(1L),
                        ItemList.Electric_Motor_LuV.get(2L),
                        ItemList.Robot_Arm_LuV.get(1L))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 500, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // ME Interface Terminal
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 380, missing),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 440, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 480, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // ME Conversion Monitor
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 400, missing),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 44, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 420, missing))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // ME Pattern Terminal
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 380, missing),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 52, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 340, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // ME Formation Plane
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 3, 7, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 320, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // ME Annihilation Plane
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ToolCertusQuartzPickaxe", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 44, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 3, 7, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 300, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // P2P Tunnel - ME
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 3, 7, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 460, missing))
                .duration(18 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // ME Storage Monitor
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 180, missing),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 280, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 3))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 400, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 160, missing),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 280, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 3))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 400, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 200, missing),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 280, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 3))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 400, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Portable Cell
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.1k", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Titanium, 2),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockChest", 1, 0, missing),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1, 0, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ToolPortableCell", 1, 0, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Quartz Glass
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass", 4, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 4))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzGlass", 4, 0, missing))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).specialValue(1000).noOptimize()
                .addTo(blastFurnaceRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass", 4, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 4))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzGlass", 4, 0, missing))
                .duration(20 * SECONDS).eut(16).noOptimize().addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "blockITNT", 1, 0, missing))
                .itemOutputs(
                        getModItem(AppliedEnergistics2.ID, "tile.BlockTinyTNT", 1, 0, missing),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockTinyTNT", 1, 0, missing))
                .duration(30 * SECONDS).eut(5).addTo(centrifugeRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartzCharged, 1))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(UniversalChemical);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartzCharged, 3),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 3, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 1000)).duration(45 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(UniversalChemical);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartzCharged, 3),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 3, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 1000)).duration(35 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(UniversalChemical);
        GTValues.RA.stdBuilder().itemInputs(getModItem(AppliedEnergistics2.ID, "tile.BlockFluix", 1, 0, missing))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4, 8, missing))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        // Quartz Fiber
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.stick, Materials.CertusQuartz, 2))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 140, missing))
                .duration(4 * SECONDS).eut(TierEU.RECIPE_MV).addTo(wiremillRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(GTOreDictUnificator.get(OrePrefixes.stick, Materials.CertusQuartzCharged, 1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 140, missing))
                .duration(4 * SECONDS).eut(TierEU.RECIPE_MV).addTo(wiremillRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.stick, Materials.NetherQuartz, 8))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 140, missing))
                .duration(4 * SECONDS).eut(TierEU.RECIPE_MV).addTo(wiremillRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.stick, Materials.Quartzite, 4))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 140, missing))
                .duration(4 * SECONDS).eut(TierEU.RECIPE_MV).addTo(wiremillRecipes);

    }
}
