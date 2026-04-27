package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.AE2FluidCraft;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Avaritia;
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
import static gregtech.api.recipe.RecipeMaps.cableRecipes;
import static gregtech.api.recipe.RecipeMaps.centrifugeRecipes;
import static gregtech.api.recipe.RecipeMaps.circuitAssemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.hammerRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.recipe.RecipeMaps.neutroniumCompressorRecipes;
import static gregtech.api.recipe.RecipeMaps.wiremillRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gregtech.api.util.GTRecipeConstants.UniversalChemical;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.avaritia.AvaritiaHelper;
import com.dreammaster.item.NHItemList;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.ToolDictNames;
import gregtech.api.recipe.RecipeMap;
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
                Avaritia.ID,
                Computronics.ID,
                DraconicEvolution.ID,
                EnderIO.ID,
                EternalSingularity.ID,
                ExtraUtilities.ID,
                IndustrialCraft2.ID,
                IronChests.ID,
                OpenComputers.ID,
                Thaumcraft.ID,
                TinkerConstruct.ID);
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
        final ItemStack storageBus = getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 220);

        // preconfigurated priorities for storage buses

        for (int i = 1; i < 25; i++) {
            ItemStack preconfiguredStorageBus = storageBus.copy();
            NBTTagCompound tag = new NBTTagCompound();
            tag.setInteger("priority", i);
            preconfiguredStorageBus.setTagCompound(tag);
            GTValues.RA.stdBuilder().itemInputs(storageBus).circuit(i).itemOutputs(preconfiguredStorageBus)
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(circuitAssemblerRecipes);

            addShapelessRecipe(preconfiguredStorageBus, storageBus, GTUtility.getIntegratedCircuit(i));
        }
        // Preconfigured p2ps

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemFluidCell", 1),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 460))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 463)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "cable", 1),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 460))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 468)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemPowerConduit", 1),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 460))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 466)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedstoneAlloy, 1L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 460))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 470)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Redstone, 1L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 460))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 461)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 1L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 460))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 467)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Computronics.ID, "computronics.ironNoteBlock", 1),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 460))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 472)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "chestMini", 1),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 460))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 462)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);

        // Hyper-Acceleration Card
        addShapelessRecipe(
                SuperSpeedCard,
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                NHItemList.MysteriousCrystal.get(),
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
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2L))
                .circuit(3).itemOutputs(AE2_ADVANCED_HOUSING).duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(assemblerRecipes);
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
                        'X', NHItemList.EngineeringProcessorItemEmeraldCore.get() });
        GTModHandler.addCraftingRecipe(
                components[1],
                new Object[] { "CPC", "PXP", "CPC", 'C', "circuitElite", 'P', components[0], 'X',
                        NHItemList.EngineeringProcessorItemEmeraldCore.get() });
        GTModHandler.addCraftingRecipe(
                components[2],
                new Object[] { "CPC", "PXP", "CPC", 'C', "circuitMaster", 'P', components[1], 'X',
                        NHItemList.EngineeringProcessorItemAdvEmeraldCore.get() });
        GTModHandler.addCraftingRecipe(
                components[3],
                new Object[] { "CPC", "PXP", "CPC", 'C', "circuitSuperconductor", 'P', components[2], 'X',
                        NHItemList.EngineeringProcessorItemAdvEmeraldCore.get() });
        FluidStack[] solders = new FluidStack[] { Materials.Lead.getMolten(288), Materials.Tin.getMolten(144),
                Materials.SolderingAlloy.getMolten(72), };
        for (FluidStack solder : solders) {
            // 256k
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.EV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 16),
                            NHItemList.EngineeringProcessorItemEmeraldCore.get(),
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1))
                    .circuit(1).itemOutputs(components[0]).fluidInputs(solder).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_EV).requiresCleanRoom().addTo(circuitAssemblerRecipes);
            // 1024k
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.EV, 16),
                            NHItemList.EngineeringProcessorItemEmeraldCore.get(),
                            ItemList.Circuit_Board_Multifiberglass_Elite.get(1))
                    .circuit(1).itemOutputs(components[1]).fluidInputs(solder).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_IV).requiresCleanRoom().addTo(circuitAssemblerRecipes);
            // 4096k
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LuV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 16),
                            NHItemList.EngineeringProcessorItemAdvEmeraldCore.get(),
                            ItemList.Circuit_Board_Wetware_Extreme.get(1))
                    .circuit(1).itemOutputs(components[2]).fluidInputs(solder).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_LuV).requiresCleanRoom().addTo(circuitAssemblerRecipes);
            // 16384k
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LuV, 16),
                            NHItemList.EngineeringProcessorItemAdvEmeraldCore.get(),
                            ItemList.Circuit_Board_Bio_Ultra.get(1))
                    .circuit(1).itemOutputs(components[3]).fluidInputs(solder).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_UV).requiresCleanRoom().addTo(circuitAssemblerRecipes);
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
                        AE2_HOUSING)
                .circuit(4).itemOutputs(AE2_BLOCK_CONTAINER).duration(2 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // Fluix Glass Cable
        for (int i = 0; i < 16; i++) {
            FluixGlassCableColor[i] = getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, i);

            addShapelessRecipe(
                    getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                    FluixGlassCableColor[i]);
        }
        // --- Fluix Covered Cable
        for (int i = 0; i < 16; i++) {
            FluixCoveredCableColor[i] = getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 20 + i);

            addShapelessRecipe(
                    getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 36),
                    FluixCoveredCableColor[i]);
        }
        for (RecipeMap<?> aeCables : new RecipeMap<?>[] { assemblerRecipes, cableRecipes }) {
            // Covered Cable
            GTValues.RA.stdBuilder().itemInputs(AE2_ME_Glass_Cable).circuit(24).itemOutputs(AE2_ME_Covered_Cable)
                    .fluidInputs(Materials.Rubber.getMolten(144L)).duration(7 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_MV).addTo(aeCables);
            GTValues.RA.stdBuilder().itemInputs(AE2_ME_Glass_Cable).circuit(24).itemOutputs(AE2_ME_Covered_Cable)
                    .fluidInputs(Materials.StyreneButadieneRubber.getMolten(108L)).duration(7 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_MV).addTo(aeCables);
            GTValues.RA.stdBuilder().itemInputs(AE2_ME_Glass_Cable).circuit(24).itemOutputs(AE2_ME_Covered_Cable)
                    .fluidInputs(Materials.RubberSilicone.getMolten(72L)).duration(7 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_MV).addTo(aeCables);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            AE2_ME_Glass_Cable,
                            GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.PolyvinylChloride, 1))
                    .itemOutputs(AE2_ME_Covered_Cable).fluidInputs(Materials.StyreneButadieneRubber.getMolten(36L))
                    .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(aeCables);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            AE2_ME_Glass_Cable,
                            GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.PolyvinylChloride, 1))
                    .itemOutputs(AE2_ME_Covered_Cable).fluidInputs(Materials.RubberSilicone.getMolten(36L))
                    .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(aeCables);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            AE2_ME_Glass_Cable,
                            GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Polydimethylsiloxane, 1))
                    .itemOutputs(AE2_ME_Covered_Cable).fluidInputs(Materials.StyreneButadieneRubber.getMolten(36L))
                    .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(aeCables);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            AE2_ME_Glass_Cable,
                            GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Polydimethylsiloxane, 1))
                    .itemOutputs(AE2_ME_Covered_Cable).fluidInputs(Materials.RubberSilicone.getMolten(36L))
                    .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(aeCables);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 16),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.PolyvinylChloride, 1))
                    .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36))
                    .fluidInputs(Materials.StyreneButadieneRubber.getMolten(144L)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(aeCables);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 16),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.PolyvinylChloride, 1))
                    .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36))
                    .fluidInputs(Materials.RubberSilicone.getMolten(144L)).duration(25 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(aeCables);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 16),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Polydimethylsiloxane, 1))
                    .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36))
                    .fluidInputs(Materials.StyreneButadieneRubber.getMolten(144L)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(aeCables);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 16),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Polydimethylsiloxane, 1))
                    .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36))
                    .fluidInputs(Materials.RubberSilicone.getMolten(144L)).duration(25 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(aeCables);

            // Dense Covered Cable
            GTValues.RA.stdBuilder().itemInputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36))
                    .circuit(24).itemOutputs(AE2_ME_Dense_Covered_Cable)
                    .fluidInputs(Materials.StyreneButadieneRubber.getMolten(216L)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(aeCables);
            GTValues.RA.stdBuilder().itemInputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36))
                    .circuit(24).itemOutputs(AE2_ME_Dense_Covered_Cable)
                    .fluidInputs(Materials.RubberSilicone.getMolten(144L)).duration(10 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(aeCables);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36),
                            GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.PolyvinylChloride, 1))
                    .itemOutputs(AE2_ME_Dense_Covered_Cable)
                    .fluidInputs(Materials.StyreneButadieneRubber.getMolten(72L)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(aeCables);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36),
                            GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.PolyvinylChloride, 1))
                    .itemOutputs(AE2_ME_Dense_Covered_Cable).fluidInputs(Materials.RubberSilicone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_HV).addTo(aeCables);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36),
                            GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Polydimethylsiloxane, 1))
                    .itemOutputs(AE2_ME_Dense_Covered_Cable)
                    .fluidInputs(Materials.StyreneButadieneRubber.getMolten(72L)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(aeCables);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36),
                            GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Polydimethylsiloxane, 1))
                    .itemOutputs(AE2_ME_Dense_Covered_Cable).fluidInputs(Materials.RubberSilicone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_HV).addTo(aeCables);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 36),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.PolyvinylChloride, 1))
                    .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 536))
                    .fluidInputs(Materials.StyreneButadieneRubber.getMolten(288L)).duration(35 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(aeCables);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 36),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.PolyvinylChloride, 1))
                    .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 536))
                    .fluidInputs(Materials.RubberSilicone.getMolten(288L)).duration(35 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(aeCables);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 36),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Polydimethylsiloxane, 1))
                    .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 536))
                    .fluidInputs(Materials.StyreneButadieneRubber.getMolten(288L)).duration(35 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(aeCables);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 36),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Polydimethylsiloxane, 1))
                    .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 536))
                    .fluidInputs(Materials.RubberSilicone.getMolten(288L)).duration(35 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(aeCables);
        }

        // --- Fluix Dense Covered Cable
        for (int i = 0; i < 16; i++) {
            FluixDenseCoveredCableColor[i] = getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 520 + i);

            addShapelessRecipe(
                    getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 536),
                    FluixDenseCoveredCableColor[i]);
        }

        // ME Smart Cable Fluix
        for (int i = 0; i < 16; i++) {
            FluixSmartCableColor[i] = getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 40 + i);

            addShapelessRecipe(
                    getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 56),
                    FluixSmartCableColor[i]);
        }
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 16),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1))
                .circuit(1).itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 56))
                .fluidInputs(Materials.ConductiveIron.getMolten(144L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 36),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1))
                .circuit(1).itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 56))
                .fluidInputs(Materials.ConductiveIron.getMolten(144L)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        // --- ME Smart Dense Cable Fluix
        for (int i = 0; i < 16; i++) {
            FluixDenseSmartCableColor[i] = getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 60 + i);
            addShapelessRecipe(
                    getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 76),
                    FluixDenseSmartCableColor[i]);
        }
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 16, 56),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1))
                .circuit(1).itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 76))
                .fluidInputs(Materials.EnergeticAlloy.getMolten(144L)).duration(7 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 536),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1))
                .circuit(1).itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 76))
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
                NHItemList.PikoCircuit.get(),
                'c',
                ItemList.Field_Generator_UIV.get(1L),
                'd',
                getModItem(DraconicEvolution.ID, "reactorStabilizer", 1),
                'e',
                GTOreDictUnificator.get(OrePrefixes.nanite, Materials.TranscendentMetal, 1L),
                'f',
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Infinity, 1L),
                'g',
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.SpaceTime, 1L),
                'h',
                GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SpaceTime, 1L),
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
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 47),
                "plateTungsten",
                "screwCertusQuartz",
                "plateTungsten",
                "craftingToolScrewdriver");

        AvaritiaHelper
                .removeExtremeCraftingRecipe(getModItem(AppliedEnergistics2.ID, "tile.BlockCreativeEnergyCell", 1, 0)); // stays
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockCreativeEnergyCell", 1, 0),
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
                getModItem(AppliedEnergistics2.ID, "tile.BlockDenseEnergyCell", 1, 0),
                'c',
                NHItemList.EngineeringProcessorItemAdvEmeraldCore.get(),
                'd',
                "blockCosmicNeutronium");

        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockController", 1, 0),
                "plateTitanium",
                "circuitAdvanced",
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                getModItem(AppliedEnergistics2.ID, "tile.BlockFluix", 1, 0),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                "plateTitanium",
                "circuitAdvanced",
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 8),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "circuitAdvanced",
                getModItem(AppliedEnergistics2.ID, "tile.BlockFluix", 1, 0),
                "circuitAdvanced",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "cableGt08Aluminium",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockDenseEnergyCell", 1, 0),
                getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1, 0),
                getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1, 0),
                getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1, 0),
                "circuitMaster",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                "circuitMaster",
                getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1, 0),
                ItemList.Battery_Buffer_4by4_EV.get(1L),
                getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1, 0));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockChest", 1, 0),
                "plateStainlessSteel",
                "circuitGood",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                getModItem(IronChests.ID, "BlockIronChest", 1, 4),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                "plateStainlessSteel",
                "circuitGood",
                "plateStainlessSteel");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockDrive", 1, 0),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                getModItem(AppliedEnergistics2.ID, "tile.BlockChest", 1, 0),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                "plateTitanium",
                "circuitAdvanced",
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzGrowthAccelerator", 1, 0),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzGlass", 1, 0),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                ItemList.Machine_EV_Autoclave.get(1L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1, 0),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22),
                "plateTitanium",
                "circuitBasic",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                "circuitBasic",
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23),
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockMolecularAssembler", 1, 0),
                "plateTitanium",
                "blockGlass",
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 44),
                ItemList.Machine_EV_Assembler.get(1L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43),
                "plateTitanium",
                "blockGlass",
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockCharger", 1, 0),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7),
                "plateTitanium",
                "cableGt01Copper",
                ItemList.Machine_EV_Electrolyzer.get(1L),
                "cableGt01Copper",
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7),
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuantumRing", 1, 0),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1, 0),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22),
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuantumLinkChamber", 1, 0),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzGlass", 1, 0),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9),
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockSpatialPylon", 1, 0),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 8),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 8),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockSpatialIOPort", 1, 0),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "tile.BlockSpatialPylon", 1, 0),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                getModItem(AppliedEnergistics2.ID, "tile.BlockIOPort", 1, 0),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                "plateTitanium");
        // Spatial Link Chamber
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockSpatialLinkChamber", 1, 0),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSpatialPylon", 1, 0), // spatial pylon
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 41), // wireless receiver
                                                                                     // (component)
                getModItem(AppliedEnergistics2.ID, "tile.BlockSpatialPylon", 1, 0), // spatial pylon
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16), // glass cable
                getModItem(AppliedEnergistics2.ID, "tile.BlockChest", 1, 0), // me chest
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16), // glass cable
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16), // glass cable
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 34), // 128^3 spatial component
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16)); // glass cable
        // Spatial Network Relay
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockSpatialNetworkRelay", 1, 0),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24), // Engineering processor
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 41), // wireless receiver
                                                                                     // (component)
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24), // Engineering processor
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 12), // Pure fluix crystal
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16), // glass cable
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16)); // glass cable
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1, 0),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 44),
                ItemList.Casing_EV.get(1L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                "plateTitanium");
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1, 0),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 440));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockCellWorkbench", 1, 0),
                "craftingToolScrewdriver",
                ItemList.Cover_Screen.get(1L),
                "craftingToolWrench",
                "screwTitanium",
                getModItem(Minecraft.ID, "crafting_table", 1, 0),
                "screwTitanium",
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23),
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockIOPort", 1, 0),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                getModItem(AppliedEnergistics2.ID, "tile.BlockDrive", 1, 0),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                getModItem(AppliedEnergistics2.ID, "tile.BlockDrive", 1, 0),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22),
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockCondenser", 1, 0),
                "plateTitanium",
                ItemList.Electric_Piston_EV.get(1L),
                "plateTitanium",
                ItemList.Electric_Piston_EV.get(1L),
                ItemList.Hull_EV.get(1L),
                ItemList.Electric_Piston_EV.get(1L),
                "plateTitanium",
                ItemList.Electric_Piston_EV.get(1L),
                "plateTitanium");

        GTValues.RA.stdBuilder()
                .itemInputsUnsafe(GTUtility.copyAmountUnsafe(512000, new ItemStack(Blocks.cobblestone, 1)))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 47)).duration(3 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(neutroniumCompressorRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 47))
                .itemOutputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 64, 6),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 36, 6))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_IV).addTo(hammerRecipes);

        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyAcceptor", 1, 0),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7),
                "plateGlowstone",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7),
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockVibrationChamber", 1, 0),
                "plateTitanium",
                "screwTitanium",
                "plateTitanium",
                "craftingToolScrewdriver",
                ItemList.Machine_EV_E_Furnace.get(1L),
                "craftingToolWrench",
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyAcceptor", 1, 0),
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockSecurity", 1, 0),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "tile.BlockChest", 1, 0),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 37),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.SkyStoneStairBlock", 4, 0),
                null,
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 0),
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 0),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 0),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 0),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 0),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 0));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.SkyStoneBlockStairBlock", 4, 0),
                null,
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 1),
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 1),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 1),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 1),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 1),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 1));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.SkyStoneBrickStairBlock", 4, 0),
                null,
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 2),
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 2),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 2),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 2),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 2),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 2));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.SkyStoneSmallBrickStairBlock", 4, 0),
                null,
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 3),
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 3),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 3),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 3),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 3),
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1, 3));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.FluixStairBlock", 4, 0),
                null,
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockFluix", 1, 0),
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockFluix", 1, 0),
                getModItem(AppliedEnergistics2.ID, "tile.BlockFluix", 1, 0),
                getModItem(AppliedEnergistics2.ID, "tile.BlockFluix", 1, 0),
                getModItem(AppliedEnergistics2.ID, "tile.BlockFluix", 1, 0),
                getModItem(AppliedEnergistics2.ID, "tile.BlockFluix", 1, 0));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.QuartzStairBlock", 4, 0),
                null,
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartz", 1, 0),
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartz", 1, 0),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartz", 1, 0),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartz", 1, 0),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartz", 1, 0),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartz", 1, 0));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.ChiseledQuartzStairBlock", 4, 0),
                null,
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzChiseled", 1, 0),
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzChiseled", 1, 0),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzChiseled", 1, 0),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzChiseled", 1, 0),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzChiseled", 1, 0),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzChiseled", 1, 0));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.QuartzPillarStairBlock", 4, 0),
                null,
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzPillar", 1, 0),
                null,
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzPillar", 1, 0),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzPillar", 1, 0),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzPillar", 1, 0),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzPillar", 1, 0),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzPillar", 1, 0));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 16),
                "stickCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 8),
                "stickCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 140),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 140),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 140),
                "stickCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 8),
                "stickCertusQuartz");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 44),
                "stickNetherQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22),
                "stickNetherQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 12),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22),
                "stickNetherQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22),
                "stickNetherQuartz");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 43),
                "stickCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22),
                "stickCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 12),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22),
                "stickCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22),
                "stickCertusQuartz");

        // Fluix Pearls
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 12),
                "plateEnderEye",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 12),
                "plateEnderEye",
                "gemEnderPearl",
                "plateEnderEye",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 12),
                "plateEnderEye",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 12));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7),
                "plateEnderEye",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7),
                "plateEnderEye",
                "gemEnderPearl",
                "plateEnderEye",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7),
                "plateEnderEye",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7));
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4, 12),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 4L),
                        getModItem(Minecraft.ID, "ender_pearl", 1, 0))
                .circuit(3).itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4, 7),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 4L),
                        getModItem(Minecraft.ID, "ender_pearl", 1, 0))
                .circuit(3).itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 41),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 140),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 140),
                null,
                "stickEnderEye",
                null,
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "circuitAdvanced",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyCompass", 1, 0),
                "craftingToolScrewdriver",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                "screwCertusQuartz",
                "plateSteel",
                "stickSteelMagnetic",
                "plateSteel",
                "screwCertusQuartz",
                "plateSteel",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockSkyCompass", 1, 0),
                "craftingToolHardHammer",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                "screwCertusQuartz",
                "plateSteel",
                "stickSteelMagnetic",
                "plateSteel",
                "screwCertusQuartz",
                "plateSteel",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 180),
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
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 380),
                "stickNetherQuartz",
                "screwQuartzite",
                "stickNetherQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 180),
                "circuitGood",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "stickNetherQuartz",
                "craftingToolScrewdriver",
                "stickNetherQuartz");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 380),
                "stickNetherQuartz",
                "craftingToolScrewdriver",
                "stickNetherQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 180),
                "circuitGood",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "stickNetherQuartz",
                "screwQuartzite",
                "stickNetherQuartz");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 360),
                "craftingToolScrewdriver",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 380),
                ToolDictNames.craftingToolSoftMallet.name(),
                "screwCertusQuartz",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 0),
                "screwCertusQuartz",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 500),
                "craftingToolScrewdriver",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 360),
                ToolDictNames.craftingToolSoftMallet.name(),
                ItemList.Conveyor_Module_LuV.get(1L),
                NHItemList.EngineeringProcessorItemAdvEmeraldCore.get(),
                ItemList.Conveyor_Module_LuV.get(1L),
                ItemList.Electric_Motor_LuV.get(1L),
                ItemList.Robot_Arm_LuV.get(1L),
                ItemList.Electric_Motor_LuV.get(1L));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 480),
                "craftingToolScrewdriver",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 380),
                ToolDictNames.craftingToolSoftMallet.name(),
                "screwCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 440),
                "screwCertusQuartz",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 420),
                "craftingToolScrewdriver",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 400),
                "craftingToolHardHammer",
                "screwCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43),
                "screwCertusQuartz",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 44),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 340),
                "craftingToolScrewdriver",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 380),
                ToolDictNames.craftingToolSoftMallet.name(),
                "screwCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 52),
                "screwCertusQuartz",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ToolWirelessTerminal", 1, 0),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 41),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 380),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 41),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                getModItem(AppliedEnergistics2.ID, "tile.BlockDenseEnergyCell", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28),
                "platePlatinum",
                "plateTitanium",
                null,
                "plateRedAlloy",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23),
                "plateTitanium",
                "platePlatinum",
                "plateTitanium",
                null);
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 25),
                "plateGold",
                "plateAluminium",
                null,
                "plateRedAlloy",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23),
                "plateAluminium",
                "plateGold",
                "plateAluminium",
                null);
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 52),
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzGlass", 1, 0),
                "plateGlowstone",
                getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzGlass", 1, 0),
                "plateGlowstone",
                "itemCertusQuartz",
                "plateGlowstone",
                "plateAluminium",
                "plateAluminium",
                "plateAluminium");
        // capacity card
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 27),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 25),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1));
        // stick
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 64),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 25),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35),
                "slimeball");
        // crafting card
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 53),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 25),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35),
                "craftingWorkBench");
        // redstone card
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 26),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 25),
                "craftingRedstoneTorch",
                "craftingRedstoneTorch",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23));
        // fuzzy card
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 29),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23));
        // inverter card
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 31),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28),
                getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 5),
                getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 5),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23));
        // acceleration card
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 30),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7));
        // oredictionary card
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 55),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                ItemList.Automation_TypeFilter_IV.get(1L));
        // wireless booster
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 42),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 8),
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
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 300),
                "craftingToolScrewdriver",
                getModItem(AppliedEnergistics2.ID, "item.ToolCertusQuartzPickaxe", 1, 0),
                "craftingToolHardHammer",
                "screwCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 44),
                "screwCertusQuartz",
                "gemFluix",
                "gemFluix",
                "gemFluix");
        // cable anchor block
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 120),
                "boltIron",
                null,
                null,
                "boltIron");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 120),
                "boltCopper",
                null,
                null,
                "boltCopper");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 120),
                "boltBronze",
                null,
                null,
                "boltBronze");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 120),
                "boltTin",
                null,
                null,
                "boltTin");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 120),
                "boltSteel",
                null,
                null,
                "boltSteel");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 120),
                "boltAluminium",
                null,
                null,
                "boltAluminium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 120),
                "boltLead",
                null,
                null,
                "boltLead");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 120),
                "boltNickel",
                null,
                null,
                "boltNickel");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 120),
                "boltSilver",
                null,
                null,
                "boltSilver");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 120),
                "boltBrass",
                null,
                null,
                "boltBrass");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 120),
                "boltInvar",
                null,
                null,
                "boltInvar");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 3, 120),
                "boltStainlessSteel",
                null,
                null,
                "boltStainlessSteel");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 120),
                "boltTitanium",
                null,
                null,
                "boltTitanium");
        // ME export bus
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 260),
                "craftingToolScrewdriver",
                "plateTitanium",
                "craftingToolHardHammer",
                "screwCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43),
                "screwCertusQuartz",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                ItemList.Electric_Piston_LV.get(1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L));
        // ME formation plane
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 320),
                "craftingToolScrewdriver",
                "blockHopper",
                "craftingToolHardHammer",
                "screwCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43),
                "screwCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7));
        // ME import bus
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 240),
                "craftingToolScrewdriver",
                "plateTitanium",
                "craftingToolHardHammer",
                "screwCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 44),
                "screwCertusQuartz",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                ItemList.Electric_Piston_LV.get(1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L));
        // p2p tunnel - ME
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 460),
                "craftingToolScrewdriver",
                "plateTitanium",
                "craftingToolHardHammer",
                "screwCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                "screwCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7));
        // certuz quartz wrench
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ToolCertusQuartzWrench", 1, 0),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1),
                "craftingToolWrench",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1),
                null,
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1),
                null);
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ToolNetherQuartzWrench", 1, 0),
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
                getModItem(AppliedEnergistics2.ID, "item.ToolMassCannon", 1, 0),
                "plateTitanium",
                "plateTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 38),
                getModItem(AppliedEnergistics2.ID, "tile.BlockDenseEnergyCell", 1, 0),
                null,
                "plateTitanium",
                null,
                null);
        // memory card
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ToolMemoryCard", 1, 0),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23),
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
                getModItem(AppliedEnergistics2.ID, "item.ToolPriorityCard", 1, 0),
                "plateTungstenSteel",
                "circuitElite",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                "plateDiamond",
                "plateRedAlloy",
                "plateDiamond",
                null,
                null,
                null);
        // charged staff
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ToolChargedStaff", 1, 0),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1),
                null,
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1),
                getModItem(Thaumcraft.ID, "FocusShock", 1, 0),
                null,
                null,
                null,
                "stickThaumium");
        // entropy manipulator
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ToolEntropyManipulator", 1, 0),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22),
                null,
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1, 0),
                null,
                null,
                null,
                "stickThaumium");
        // color applicator
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ToolColorApplicator", 1, 0),
                "wireGt01Aluminium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43),
                "wireGt01Aluminium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 36),
                getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1, 0),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 36),
                null,
                "stickSteel",
                null);
        // biometric card
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ToolBiometricCard", 1, 0),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
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
                getModItem(AppliedEnergistics2.ID, "tile.BlockWireless", 1, 0),
                null,
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 41),
                null,
                "screwTitanium",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23),
                "screwTitanium",
                "craftingToolScrewdriver",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                "craftingToolWrench");
        // ME storage monitor
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 400),
                "craftingToolScrewdriver",
                "itemIlluminatedPanel",
                "craftingToolHardHammer",
                "screwCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 280),
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
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 440),
                "screwCertusQuartz",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                ItemList.Electric_Piston_LV.get(1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L));
        // Clear storage bus NBT
        addShapelessRecipe(storageBus, storageBus);
        // 1k storage cell
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.1k", 1, 0),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.1k", 1, 0),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolHardHammer");
        // 4k storage cell
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.4k", 1, 0),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 36),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.4k", 1, 0),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 36),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolHardHammer");
        // 16k storage cell
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.16k", 1, 0),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 37),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.16k", 1, 0),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 37),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolHardHammer");
        // 64k storage cell
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.64k", 1, 0),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 38),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.64k", 1, 0),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 38),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolHardHammer");
        // viewing cell
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemViewCell", 1, 0),
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
                getModItem(AppliedEnergistics2.ID, "item.ItemViewCell", 1, 0),
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
                getModItem(AppliedEnergistics2.ID, "item.ItemViewCell", 1, 0),
                AE2_HOUSING,
                "gemCertusQuartz");
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.1k", 1, 0),
                AE2_HOUSING,
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35));
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.4k", 1, 0),
                AE2_HOUSING,
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 36));
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.16k", 1, 0),
                AE2_HOUSING,
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 37));
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.64k", 1, 0),
                AE2_HOUSING,
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 38));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemSpatialStorageCell.2Cubed", 1, 0),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 32),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemSpatialStorageCell.2Cubed", 1, 0),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 32),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolHardHammer");
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemSpatialStorageCell.2Cubed", 1, 0),
                AE2_HOUSING,
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 32));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemSpatialStorageCell.16Cubed", 1, 0),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 33),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemSpatialStorageCell.16Cubed", 1, 0),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 33),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolHardHammer");
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemSpatialStorageCell.16Cubed", 1, 0),
                AE2_HOUSING,
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 33));
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemSpatialStorageCell.128Cubed", 1, 0),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 34),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemSpatialStorageCell.128Cubed", 1, 0),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 34),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolHardHammer");
        addShapelessRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemSpatialStorageCell.128Cubed", 1, 0),
                AE2_HOUSING,
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 34));
        addShapedRecipe(
                AE2_HOUSING,
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolScrewdriver");
        addShapedRecipe(
                AE2_HOUSING,
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                "screwCertusQuartz",
                "plateStainlessSteel",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                "plateStainlessSteel",
                "screwCertusQuartz",
                "plateAluminium",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35),
                "circuitPrimitive",
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartzCharged, 1),
                "circuitPrimitive",
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartzCharged, 1),
                NHItemList.LogicProcessorItemGoldCore.get(),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartzCharged, 1),
                "circuitPrimitive",
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartzCharged, 1),
                "circuitPrimitive");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 36),
                "circuitBasic",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35),
                "circuitBasic",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35),
                NHItemList.LogicProcessorItemGoldCore.get(),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35),
                "circuitBasic",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35),
                "circuitBasic");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 37),
                "circuitGood",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 36),
                "circuitGood",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 36),
                NHItemList.EngineeringProcessorItemDiamondCore.get(),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 36),
                "circuitGood",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 36),
                "circuitGood");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 38),
                "circuitAdvanced",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 37),
                "circuitAdvanced",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 37),
                NHItemList.EngineeringProcessorItemDiamondCore.get(),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 37),
                "circuitAdvanced",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 37),
                "circuitAdvanced");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 32),
                "plateGlowstone",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9),
                "plateGlowstone",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9),
                NHItemList.EngineeringProcessorSpatialPulsatingCore.get(1),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9),
                "plateGlowstone",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9),
                "plateGlowstone");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 33),
                "plateEnderPearl",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 32),
                "plateEnderPearl",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 32),
                NHItemList.EngineeringProcessorSpatialPulsatingCore.get(1),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 32),
                "plateEnderPearl",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 32),
                "plateEnderPearl");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 34),
                "plateEnderEye",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 33),
                "plateEnderEye",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 33),
                NHItemList.EngineeringProcessorSpatialPulsatingCore.get(1),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 33),
                "plateEnderEye",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 33),
                "plateEnderEye");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ToolPortableCell", 1, 0),
                null,
                getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.1k", 1, 0),
                null,
                "screwTitanium",
                getModItem(AppliedEnergistics2.ID, "tile.BlockChest", 1, 0),
                "screwTitanium",
                "craftingToolScrewdriver",
                getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1, 0),
                "craftingToolWrench");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockInscriber", 1, 0),
                "plateTitanium",
                "gemFluix",
                "plateTitanium",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0),
                ItemList.Machine_EV_Press.get(1L),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0),
                "plateTitanium",
                "gemFluix",
                "plateTitanium");
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ToolCertusQuartzCuttingKnife", 1, 0),
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
                getModItem(AppliedEnergistics2.ID, "item.ToolNetherQuartzCuttingKnife", 1, 0),
                "craftingToolHardHammer",
                "screwTitanium",
                "stickWood",
                "gemNetherQuartz",
                "stickWood",
                "screwTitanium",
                "plateNetherQuartz",
                "gemNetherQuartz",
                "craftingToolFile");
        // Throughput monitor
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 410),
                "craftingToolScrewdriver",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 400), // ME Storage Monitor
                "craftingToolHardHammer",
                "screwCertusQuartz",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 280), // ME Level Emitter
                "screwCertusQuartz",
                "plateNetherQuartz",
                "plateNetherQuartz",
                "plateNetherQuartz");
        // Creative Energy Anchor
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 690),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 120), // Cable Anchor
                getModItem(AppliedEnergistics2.ID, "tile.BlockCreativeEnergyCell", 1, 0),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 140)); // Quartz Fiber
        // Creative Controller
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "tile.BlockCreativeEnergyController", 1, 0),
                getModItem(AppliedEnergistics2.ID, "tile.BlockController", 1, 0),
                getModItem(AppliedEnergistics2.ID, "tile.BlockCreativeEnergyCell", 1, 0));
        // Fake Crafting Card
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 66),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28), // Advanced Card
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24), // Engineering Proc.
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22), // Logic Proc.
                ItemList.Cover_Crafting.get(1));
        // Superliminal Acceleration Card
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 67),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28), // Advanced Card
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24), // Engineering Proc.
                GTOreDictUnificator.get(OrePrefixes.gem, Materials.Dilithium, 1),
                ItemList.AcceleratorUV.get(1));
        // Overflow Void Card
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 68),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 25), // Basic Card
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23), // Calculation Proc.
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23), // Calculation Proc.
                getModItem(AppliedEnergistics2.ID, "item.ItemVoidStorageCell", 1, 0));
        // Equal Distribution Card
        addShapedRecipe(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 69),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28), // Advanced Card
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24), // Engineering Proc.
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22), // Logic Proc.
                ItemList.Automation_ItemDistributor_EV.get(1));

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzGlass", 1, 0),
                        getModItem(Minecraft.ID, "glowstone_dust", 8, 0))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzLamp", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 7),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 8))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzLamp", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 8, 0),
                        getModItem(Minecraft.ID, "chest", 1, 0))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockSkyChest", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 8, 1),
                        getModItem(Minecraft.ID, "chest", 1, 0))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockSkyChest", 1, 1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1, 0),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 24))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1, 1)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1, 0),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 35))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingStorage", 1, 0))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1, 0),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 36))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingStorage", 1, 1))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1, 0),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 37))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingStorage", 1, 2))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1, 0),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 38))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingStorage", 1, 3))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1, 0),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 400))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingMonitor", 1, 0))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzTorch", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.gem, Materials.CertusQuartz, 1L),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockLightDetector", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 180)).circuit(2)
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 200)).duration(5 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 180)).circuit(3)
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 160)).duration(5 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 200)).circuit(1)
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 180)).duration(5 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 160)).circuit(1)
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 180)).duration(5 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "redstone_torch", 1, 0),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 280)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 280),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 16))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 80)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 100)).circuit(1)
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 80)).duration(5 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 80)).circuit(2)
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 100)).duration(5 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 3, 140),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 8))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 3, 16)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "chest", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 440),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 2),
                        ItemList.Electric_Piston_LV.get(1L))
                .itemOutputs(storageBus).duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 44),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 2),
                        ItemList.Electric_Piston_LV.get(1L))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 240)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 2),
                        ItemList.Electric_Piston_LV.get(1L))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 260)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // ME Terminal
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.NetherQuartz, 4),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Quartzite, 1),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 180),
                        GTOreDictUnificator.get(OrePrefixes.circuit.get(Materials.MV), 1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 380)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // ME Crafting Terminal
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 380),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 360)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // ME Processing Pattern Terminal
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 360),
                        ItemList.Conveyor_Module_LuV.get(2L),
                        NHItemList.EngineeringProcessorItemAdvEmeraldCore.get(),
                        ItemList.Electric_Motor_LuV.get(2L),
                        ItemList.Robot_Arm_LuV.get(1L))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 500)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // ME Interface Terminal
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 380),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 440),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 480)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // ME Conversion Monitor
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 400),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 44))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 420)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // ME Pattern Terminal
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 380),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 52),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 340)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // ME Formation Plane
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "hopper", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 3, 7))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 320)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // ME Annihilation Plane
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ToolCertusQuartzPickaxe", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 44),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 3, 7))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 300)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // P2P Tunnel - ME
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 3, 7))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 460)).duration(18 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // ME Storage Monitor
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 180),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 280),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 3))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 400)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // ME Throughput Monitor
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 400),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 280),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 3))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 410)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 160),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 280),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 3))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 400)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 200),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 280),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 3))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 400)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Portable Cell
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemBasicStorageCell.1k", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Titanium, 2),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockChest", 1, 0),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1, 0))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ToolPortableCell", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Pattern repeater
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AE2FluidCraft.ID, "part_fluid_interface", 1, 0),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 220),
                        getModItem(AE2FluidCraft.ID, "part_fluid_storage_bus", 1, 0),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1, 1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 473)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Quartz Glass
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass", 4, 0),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 4))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzGlass", 4, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).specialValue(1000).addTo(blastFurnaceRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass", 4, 0),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 4))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzGlass", 4, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "blockITNT", 1, 0))
                .itemOutputs(
                        getModItem(AppliedEnergistics2.ID, "tile.BlockTinyTNT", 1, 0),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockTinyTNT", 1, 0))
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
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 3, 1))
                .fluidInputs(FluidRegistry.getFluidStack("water", 1000)).duration(45 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(UniversalChemical);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartzCharged, 3),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 3, 1))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 1000)).duration(35 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(UniversalChemical);
        GTValues.RA.stdBuilder().itemInputs(getModItem(AppliedEnergistics2.ID, "tile.BlockFluix", 1, 0))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4, 8)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        // Quartz Fiber
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.stick, Materials.CertusQuartz, 2))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 140)).duration(4 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(wiremillRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(GTOreDictUnificator.get(OrePrefixes.stick, Materials.CertusQuartzCharged, 1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 140)).duration(4 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(wiremillRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.stick, Materials.NetherQuartz, 8))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 140)).duration(4 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(wiremillRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.stick, Materials.Quartzite, 4))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 140)).duration(4 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(wiremillRecipes);

        // Certus Pickaxe
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 2),
                        GTOreDictUnificator.get(OrePrefixes.gem, Materials.CertusQuartz, 3))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ToolCertusQuartzPickaxe", 1, 0))
                .duration(4 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

    }
}
