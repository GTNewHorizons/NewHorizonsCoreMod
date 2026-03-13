package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.BuildCraftSilicon;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronChests;
import static gregtech.api.enums.Mods.LogisticsPipes;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.ProjectRedCore;
import static gregtech.api.enums.Mods.ProjectRedExpansion;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.formingPressRecipes;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.item.NHItemList;

import bartworks.common.loaders.ItemRegistry;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.SubTag;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.ToolDictNames;
import gregtech.api.util.GTOreDictUnificator;

public class ScriptLogisticPipes implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Logistic Pipes";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                AppliedEnergistics2.ID,
                BuildCraftSilicon.ID,
                ExtraUtilities.ID,
                Forestry.ID,
                GalacticraftCore.ID,
                IndustrialCraft2.ID,
                IronChests.ID,
                LogisticsPipes.ID,
                OpenComputers.ID,
                ProjectRedExpansion.ID,
                ProjectRedCore.ID,
                Railcraft.ID,
                Thaumcraft.ID);
    }

    // This should ideally be shared somewhere; pending more cleanup/rewrite.
    private static final Materials[] solderingMaterials = new Materials[] { Materials.SolderingAlloy, Materials.Tin,
            Materials.Lead };

    /**
     * Gives a FluidStack of soldering material of appropriate size.
     *
     * @param material   Material to use. Must be one of {@link #solderingMaterials}.
     * @param baseAmount Amount of soldering alloy to use. Tin is 2x, Lead is 4x this amount.
     * @return FluidStack of the appropriate material and amount.
     */
    private static FluidStack getSolderingFluid(Materials material, long baseAmount) {
        if (material.contains(SubTag.SOLDERING_MATERIAL_GOOD)) return material.getMolten(baseAmount);
        if (material.contains(SubTag.SOLDERING_MATERIAL_BAD)) return material.getMolten(baseAmount * 4);
        if (material.contains(SubTag.SOLDERING_MATERIAL)) return material.getMolten(baseAmount * 2);
        return null;
    }

    @Override
    public void loadRecipes() {
        loadModuleRecipes();
        loadUpgradeRecipes();
        loadPipeRecipes();
        loadMiscRecipes();
    }

    private void loadModuleRecipes() {
        for (Materials solderingMaterial : solderingMaterials) {
            // Blank Module
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ULV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Gold, 4L))
                    .circuit(18).fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

            // ItemSink Module
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 2),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ULV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32))
                    .circuit(18).fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 1)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

            // Passive Supplier Module
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 2),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ULV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Steel, 8L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20))
                    .circuit(18).fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 2)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

            // Extractor Module
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(LogisticsPipes.ID, "item.itemModule", 2, 0),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 1L),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ULV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Steel, 8L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30))
                    .circuit(18).fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 3)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

            // Polymorphic ItemSink Module
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(LogisticsPipes.ID, "item.itemModule", 2, 1),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 4L),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ULV, 2L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 2L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20))
                    .circuit(18).fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 4)).duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(LogisticsPipes.ID, "item.itemModule", 4, 1),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.RedstoneAlloy, 1L),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ULV, 2L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 1L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20))
                    .circuit(18).fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 4)).duration(30 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

            // QuickSort Module
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501),
                            ItemList.Robot_Arm_LV.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 2L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 1L),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.BlueAlloy, 8L))
                    .circuit(18).fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5))
                    .duration(120 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

            // Advanced Extractor Module
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(LogisticsPipes.ID, "item.itemModule", 1, 3),
                            getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 5))
                    .circuit(18).fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 7)).duration(45 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

            // Provider Module
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(LogisticsPipes.ID, "item.itemModule", 4, 0),
                            ItemList.Electric_Motor_LV.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ULV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 1L),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 8L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30))
                    .circuit(18).fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 500))
                    .duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

            // Bee Analyzer module
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9),
                            GTOreDictUnificator.get(OrePrefixes.lens, Materials.Glass, 1L),
                            ItemList.Conveyor_Module_MV.get(1L),
                            ItemList.Sensor_MV.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1L))
                    .circuit(18).fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8)).duration(80 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

            // Apiary Refiller Module
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9),
                            ItemList.Robot_Arm_MV.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.StainlessSteel, 4L),
                            ItemList.Sensor_MV.get(1L),
                            ItemList.Emitter_MV.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1L))
                    .circuit(18).fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 10))
                    .duration(40 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

            // Crafting Module
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(LogisticsPipes.ID, "item.itemModule", 5, 0),
                            ItemList.Emitter_MV.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1L),
                            ItemList.Cover_Crafting.get(5L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30))
                    .circuit(18).fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 5, 600))
                    .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

            // Type Filter ItemSink module
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(LogisticsPipes.ID, "item.itemModule", 2, 1),
                            ItemList.Conveyor_Module_LV.get(1L),
                            ItemList.Circuit_Parts_Diode.get(2L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 30))
                    .circuit(18).fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 2, 17))
                    .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        }

        // Terminus Module
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 0),
                        getModItem(ExtraUtilities.ID, "trashcan", 1, 0))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 6)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);

        // Extractor MK2 module
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 3),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 103)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);

        // Advanced Extractor MK2
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 7),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 107)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 103),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 5))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 107)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);

        // Extractor MK3 module
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 3),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 6))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 203)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);

        // Advanced Extractor MK3
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 7),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 6))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 207)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 203),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 5))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 207)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);

        // Provider module MK2
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 500),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 6))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);

        // Electric Manager module
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1),
                        getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 300)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1),
                        getModItem(IndustrialCraft2.ID, "itemBatRE", 1, wildcard))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 300)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);

        // BeeSink module
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1),
                        getModItem(Forestry.ID, "beeswax", 4),
                        ItemList.Circuit_Parts_Diode.get(2L))
                .circuit(18).fluidInputs(FluidRegistry.getFluidStack("for.honey", 1000))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Drone Terminus Module
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9),
                        getModItem(ExtraUtilities.ID, "trashcan", 1, 0))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 11)).duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(formingPressRecipes);

        // Mod Based ItemSink module
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1),
                        GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Gold, 2L))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 12)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);

        // OreDict ItemSink module
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1),
                        getModItem(Minecraft.ID, "writable_book", 1, wildcard))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 13)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);

        // Thaumic AspectSink module
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 5),
                        getModItem(Thaumcraft.ID, "ItemShard", 2, 6))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 30)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);

        // Enchantment Sink module
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1),
                        getModItem(Minecraft.ID, "enchanted_book", 1, wildcard))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 31)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);

        // Enchantment Sink module MK2
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 31),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 131)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);

        // CC Based QuickSort module
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 5),
                        getModItem(OpenComputers.ID, "item", 2, 24))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 14)).duration(120 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(formingPressRecipes);

        // CC Based ItemSink module
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1),
                        getModItem(OpenComputers.ID, "item", 2, 24))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 15)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(formingPressRecipes);

        // Crafting module MK2
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 600),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 601)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(formingPressRecipes);

        // Crafting module MK3
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 601),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 6))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 602)).duration(90 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(formingPressRecipes);

        // Active Supplier Module
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 4, 2),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 2),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 28))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 4, 502)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Creative Tab Based ItemSink module
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 1),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 2))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemModule", 1, 16)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);
    }

    private void loadUpgradeRecipes() {
        // Blank Upgrade
        for (Materials solderingMaterial : solderingMaterials) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ULV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.foil, Materials.Tin, 4L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4L))
                    .circuit(18).fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4))
                    .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ULV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.foil, Materials.Tin, 4L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4L))
                    .circuit(18).fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4))
                    .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        }

        // Sneaky upgrades
        for (int side = 0; side < 6; ++side) {
            // Sides: Up, Down, N, S, E, W
            // Circuits: 5 - 6 - 1 - 2 - 3 - 4
            int meta = side;
            int circuit = side < 2 ? side + 5 : side - 1;

            // Sneaky Upgrade
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 4),
                            ItemList.Electric_Piston_LV.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.foil, Materials.Bronze, 2L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 33))
                    .circuit(circuit).itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, meta))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

            // Modification

            // UP
            addShapedRecipe(
                    getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 0),
                    null,
                    null,
                    "craftingToolScrewdriver",
                    null,
                    getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, meta),
                    null,
                    null,
                    null,
                    null);

            // DOWN
            addShapedRecipe(
                    getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 1),
                    null,
                    null,
                    null,
                    null,
                    getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, meta),
                    null,
                    null,
                    null,
                    "craftingToolScrewdriver");

            // NORTH
            addShapedRecipe(
                    getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 2),
                    null,
                    "craftingToolScrewdriver",
                    null,
                    null,
                    getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, meta),
                    null,
                    null,
                    null,
                    null);

            // SOUTH
            addShapedRecipe(
                    getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 3),
                    null,
                    null,
                    null,
                    null,
                    getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, meta),
                    null,
                    null,
                    "craftingToolScrewdriver",
                    null);

            // EAST
            addShapedRecipe(
                    getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 4),
                    null,
                    null,
                    null,
                    null,
                    getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, meta),
                    "craftingToolScrewdriver",
                    null,
                    null,
                    null);

            // WEST
            addShapedRecipe(
                    getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 5),
                    null,
                    null,
                    null,
                    "craftingToolScrewdriver",
                    getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, meta),
                    null,
                    null,
                    null,
                    null);
        }

        // Disconnection upgrades
        for (int side = 0; side < 6; ++side) {
            // Sides: Up, Down, N, S, E, W
            // Circuits: 5 - 6 - 1 - 2 - 3 - 4
            int meta = side + 10;
            int circuit = side < 2 ? side + 5 : side - 1;

            // Disconnection Upgrade
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L))
                    .circuit(circuit).itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, meta))
                    .duration(8 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

            // Modification

            // UP
            addShapedRecipe(
                    getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 10),
                    null,
                    null,
                    "craftingToolScrewdriver",
                    null,
                    getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, meta),
                    null,
                    null,
                    null,
                    null);

            // DOWN
            addShapedRecipe(
                    getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 11),
                    null,
                    null,
                    null,
                    null,
                    getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, meta),
                    null,
                    null,
                    null,
                    "craftingToolScrewdriver");

            // NORTH
            addShapedRecipe(
                    getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 12),
                    null,
                    "craftingToolScrewdriver",
                    null,
                    null,
                    getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, meta),
                    null,
                    null,
                    null,
                    null);

            // SOUTH
            addShapedRecipe(
                    getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 13),
                    null,
                    null,
                    null,
                    null,
                    getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, meta),
                    null,
                    null,
                    "craftingToolScrewdriver",
                    null);

            // EAST
            addShapedRecipe(
                    getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 14),
                    null,
                    null,
                    null,
                    null,
                    getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, meta),
                    "craftingToolScrewdriver",
                    null,
                    null,
                    null);

            // WEST
            addShapedRecipe(
                    getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 15),
                    null,
                    null,
                    null,
                    "craftingToolScrewdriver",
                    getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, meta),
                    null,
                    null,
                    null,
                    null);
        }

        // Item Speed Upgrade
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 8, 4),
                        ItemList.Electric_Motor_LV.get(1L),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 8, 20))
                .fluidInputs(Materials.Lubricant.getFluid(500)).duration(30 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // Advanced Satellite Upgrade
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4),
                        ItemList.Sensor_LV.get(1L),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 2),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 23))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 21))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        // Fluid Crafting Upgrade
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 600),
                        ItemList.Large_Fluid_Cell_Steel.get(1L))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 22))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        // Crafting Byproduct Extraction Upgrade
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4),
                        ItemList.Conveyor_Module_LV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.RedAlloy, 1L),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 33))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 23))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Placement Rules Upgrade
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4),
                        ItemList.Robot_Arm_LV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.RedAlloy, 1L),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 24))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Fuzzy Upgrade
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4),
                        getModItem(Minecraft.ID, "wool", 1, wildcard),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Steel, 1L),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 26))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 25))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // CC Remote Control Upgrade
        // No recipe.

        // Crafting Monitoring Upgrade
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4),
                        ItemList.Emitter_MV.get(1L),
                        ItemList.Sensor_MV.get(1L),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 24))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 41))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        // Opaque Upgrade
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1L))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 4, 42)).duration(8 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);

        // Crafting Cleanup Upgrade
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 4),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 107),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 2),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 33))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 26))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        // Upgrade Module Upgrade
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 4),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ULV, 1L),
                        getModItem(Minecraft.ID, "chest", 1, 0),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 34))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.itemUpgrade", 2, 44))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
    }

    private void loadPipeRecipes() {
        for (Materials solderingMaterial : solderingMaterials) {
            // Basic Logistics Pipe
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 8, 0),
                            GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Gold, 1L),
                            GTOreDictUnificator.get(OrePrefixes.gem, Materials.Diamond, 1),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 2L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 16))
                    .circuit(18).fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 8, 0))
                    .duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 16, 0),
                            GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Gold, 1L),
                            GTOreDictUnificator.get(OrePrefixes.gem, Materials.Diamond, 1),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 2L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.RedstoneAlloy, 8))
                    .circuit(18).fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 16, 0))
                    .duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        }

        // Request Logistics Pipe
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0),
                        ItemList.Emitter_LV.get(1L),
                        ItemList.Conveyor_Module_LV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 4))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsRequestLogistics", 1, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Request Logistics Pipe Mk2
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsRequestLogistics", 1, 0),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 4, 1))
                .circuit(18)
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsRequestLogisticsMk2", 1, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        // Provider Logistics Pipe
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 3, 0),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 500))
                .circuit(18)
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsProviderLogistics", 3, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Provider Logistics Pipe Mk2
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsProviderLogistics", 2, 0),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 6))
                .circuit(18)
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsProviderLogisticsMk2", 2, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 501))
                .circuit(18)
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsProviderLogisticsMk2", 2, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Crafting Logistics Pipe
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 600))
                .circuit(18)
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsCraftingLogistics", 2, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Crafting Logistics Pipe Mk2
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsCraftingLogistics", 2, 0),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5))
                .circuit(18)
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsCraftingLogisticsMk2", 2, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 601))
                .circuit(18)
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsCraftingLogisticsMk2", 2, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Crafting Logistics Pipe Mk3
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsCraftingLogisticsMk2", 2, 0),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 6))
                .circuit(18)
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsCraftingLogisticsMk3", 2, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 602))
                .circuit(18)
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsCraftingLogisticsMk3", 2, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Satellite Logistics Pipe
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 0),
                        ItemList.Robot_Arm_LV.get(1L),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 5),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 1L))
                .circuit(18)
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsSatelliteLogistics", 2, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Supplier Logistics Pipe
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 3, 0),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 502))
                .circuit(18)
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsSupplierLogistics", 3, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Logistics Chassis Mk1
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 2L),
                        getModItem(Minecraft.ID, "chest", 1, 0))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk1", 2, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Logistics Chassis Mk2
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk1", 2, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2L),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 3),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 5))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk2", 2, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 6, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4L),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 3),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1L))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk2", 6, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Logistics Chassis Mk3
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk2", 2, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Electrum, 2L),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 0),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 2))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk3", 2, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 6, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Electrum, 4L),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 0),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1L))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk3", 6, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Logistics Chassis Mk4
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk3", 2, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Kanthal, 2L),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 4),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk4", 2, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 6, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Kanthal, 8L),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 4),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1L))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk4", 6, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Logistics Chassis Mk5
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk4", 2, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 2L),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 1),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 7))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk5", 2, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 12, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 6L),
                        getModItem(IronChests.ID, "BlockIronChest", 2, 1),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1L),
                        getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 6))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeLogisticsChassiMk5", 12, 0))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Remote Orderer Logistics Pipe
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 0, wildcard),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsRequestLogistics", 1, 0))
                .circuit(18)
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsRemoteOrdererLogistics", 1, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Bee Analyzer Logistics Pipe
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 2, 0),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 8))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsApiaristAnalyser", 2, 0))
                .duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        // BeeSink Logistics Pipe
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 3, 0),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 9))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsApiaristSink", 3, 0))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Logistics Firewall Pipe
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0),
                        getModItem(Minecraft.ID, "web", 1, 0))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsFirewall", 1, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Logistics Fluid Container Supplier
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 5, 0),
                        ItemList.Robot_Arm_LV.get(1L),
                        getModItem(Minecraft.ID, "bucket", 1, 0),
                        ItemList.Large_Fluid_Cell_Steel.get(1L))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsFluidSupplier", 5, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        // Logistics Fluid Basic Pipe
        for (Materials solderingMaterial : solderingMaterials) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 12, 0),
                            ItemList.Electric_Pump_LV.get(1L),
                            ItemList.Large_Fluid_Cell_Steel.get(1L))
                    .circuit(18).fluidInputs(getSolderingFluid(solderingMaterial, 144))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 12, 0))
                    .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        }

        // Logistics Fluid Insertion Pipe
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 6, 0),
                        ItemList.Electric_Pump_MV.get(1L),
                        ItemList.Large_Fluid_Cell_Steel.get(1L))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeFluidInsertion", 6, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Logistics Fluid Provider Pipe
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 3, 0),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 500),
                        ItemList.Large_Fluid_Cell_Steel.get(1L))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeFluidProvider", 3, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        // Logistics Fluid Request Pipe
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 1, 0),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsRequestLogistics", 1, 0),
                        ItemList.Large_Fluid_Cell_Steel.get(1L))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeFluidRequestLogistics", 1, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        // Logistics Fluid Extractor Pipe
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 4, 0),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 3),
                        ItemList.Large_Fluid_Cell_Steel.get(1L))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeFluidExtractor", 4, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        // Logistics Fluid Satellite Pipe
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 1, 0),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 0),
                        ItemList.Robot_Arm_LV.get(1L),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 5),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 1L))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeFluidSatellite", 1, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        // Logistics Fluid Supplier
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "item.PipeFluidBasic", 4, 0),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 502),
                        ItemList.Large_Fluid_Cell_Steel.get(1L))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeFluidSupplierMk2", 4, 0))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        // Unrouted Transport Pipe
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Steel, 2L),
                        new ItemStack(ItemRegistry.PUMPPARTS, 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 2L))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 8, 0))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Steel, 2L),
                        getModItem(Railcraft.ID, "glass", 4, 0),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 8L))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 32, 0))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Steel, 2L),
                        getModItem(ExtraUtilities.ID, "decorativeBlock2", 4, 5),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 8L))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 32, 0))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Aluminium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.ReinforcedGlass, 4L),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 16L))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 64, 0))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Aluminium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.BorosilicateGlass, 2L),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 16L))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeItemsBasicTransport", 64, 0))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
    }

    private void loadMiscRecipes() {

        // Logistics Power Junction
        for (Materials solderingMaterial : solderingMaterials) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Transformer_MV_LV.get(1L),
                            getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 2L),
                            GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.Copper, 4L),
                            GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 8L))
                    .circuit(24).fluidInputs(getSolderingFluid(solderingMaterial, 288))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1))
                    .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Transformer_MV_LV.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 2L),
                            GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.AnnealedCopper, 4L),
                            GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 8L))
                    .circuit(24).fluidInputs(getSolderingFluid(solderingMaterial, 288))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 1))
                    .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        }

        // Logistics Security Station
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_MV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Electrum, 8L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 2L),
                        GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.Copper, 4L),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Steel, 4L))
                .circuit(24).fluidInputs(Materials.Polyethylene.getMolten(576))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 2)).duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        // Logistics Crafting Table
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_LV.get(1L),
                        getModItem(Forestry.ID, "factory2", 1, 2),
                        ItemList.Electric_Piston_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 600),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 2L),
                        GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.Copper, 2L),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.BlueAlloy, 4L))
                .circuit(24).fluidInputs(Materials.Polyethylene.getMolten(576))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 3)).duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_LV.get(1L),
                        getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 10),
                        ItemList.Electric_Piston_LV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 1, 0),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 600),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 2L),
                        GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.Copper, 2L),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.BlueAlloy, 4L))
                .circuit(24).fluidInputs(Materials.Polyethylene.getMolten(576))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 3)).duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Logistics Fuzzy Crafting Table
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 3),
                        getModItem(LogisticsPipes.ID, "item.itemUpgrade", 1, 25))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 4)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);

        // Logistics Statistics Table
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_MV.get(1L),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsBasicLogistics", 4, 0),
                        ItemList.Sensor_MV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 8L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1L),
                        GTOreDictUnificator.get(OrePrefixes.cableGt02, Materials.Copper, 4L))
                .circuit(24).fluidInputs(Materials.Polyethylene.getMolten(576))
                .itemOutputs(getModItem(LogisticsPipes.ID, "logisticsSolidBlock", 1, 5)).duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        // Logistics Request Table
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_MV.get(1L),
                        NHItemList.Display.get(),
                        ItemList.Cover_Crafting.get(1L),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0),
                        getModItem(LogisticsPipes.ID, "item.PipeItemsRequestLogistics", 1, 0),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 3),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 2L))
                .circuit(24).fluidInputs(Materials.Polyethylene.getMolten(576))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.PipeBlockRequestTable", 1, 0))
                .duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        for (Materials solderingMaterial : solderingMaterials) {
            // Gold Upgrade Chip
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(BuildCraftSilicon.ID, "redstoneChipset", 2, 2),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 2L),
                            ItemList.Circuit_Parts_Diode.get(1L),
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Steel, 4L))
                    .circuit(18).fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 5))
                    .duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

            // Diamond Upgrade Chip
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(LogisticsPipes.ID, "item.logisticsParts", 2, 5),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 2L),
                            ItemList.Circuit_Parts_Diode.get(2L),
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 4L))
                    .circuit(18).fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 4, 6))
                    .duration(40 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

            // HV Gold Crafting Chip
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 5),
                            NHItemList.GoldCoreChip.get(1),
                            ItemList.Robot_Arm_MV.get(2L),
                            getModItem(IndustrialCraft2.ID, "upgradeModule", 2, 0),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.RedSteel, 16L))
                    .circuit(18).fluidInputs(getSolderingFluid(solderingMaterial, 72))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 7))
                    .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

            // HV Diamond Crafting Chip
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 7),
                            NHItemList.DiamondCoreChip.get(1),
                            ItemList.Robot_Arm_HV.get(1L),
                            getModItem(IndustrialCraft2.ID, "upgradeModule", 4, 0),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.RedSteel, 32L))
                    .circuit(18).fluidInputs(getSolderingFluid(solderingMaterial, 144))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 8))
                    .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        }

        // Remote Orderer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Emitter_MV.get(1L),
                        ItemList.Sensor_MV.get(1L),
                        NHItemList.Display.get(),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Diamond, 4L))
                .circuit(18).fluidInputs(Materials.Polyethylene.getMolten(144))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0))
                .duration(80 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        // Dyeing of Remote Orderer is in /gthandler/recipes/ChemicalBathRecipes.java

        // Crafting Sign Creator
        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Cover_Screen.get(1), getModItem(Minecraft.ID, "sign", 1, 0)).circuit(18)
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.ItemPipeSignCreator", 1, 0))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Logistics Pipe Controller
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Cover_Screen.get(1),
                        getModItem(LogisticsPipes.ID, "item.itemModule", 1, 0))
                .circuit(18).itemOutputs(getModItem(LogisticsPipes.ID, "item.pipeController", 1, 0))
                .duration(80 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Logistics Disk
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.itemDisk", 1, 0),
                "platePlastic",
                "platePlastic",
                "platePlastic",
                "platePlastic",
                getModItem(OpenComputers.ID, "item", 1, 19),
                "platePlastic",
                "platePlastic",
                "circuitPrimitive",
                "platePlastic");

        // Logistics HUD Glasses
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.logisticsHUDGlasses", 1, 0),
                getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 1),
                getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 2),
                getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 1),
                "screwAluminium",
                "circuitGood",
                "screwAluminium",
                getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 0),
                "craftingToolScrewdriver",
                getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 0));

        // Logistics HUD Bow
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Aluminium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Diamond, 1L))
                .circuit(18).fluidInputs(Materials.Aluminium.getMolten(144))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 0)).duration(80 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        // Logistics HUD Glass
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.lens, Materials.Glass, 1L),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Aluminium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1L))
                .circuit(18).fluidInputs(Materials.Aluminium.getMolten(144))
                .itemOutputs(getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 1)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        // Logistics HUD Nose Bridge
        addShapedRecipe(
                getModItem(LogisticsPipes.ID, "item.logisticsParts", 1, 2),
                getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3),
                "stickDiamond",
                getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3),
                "craftingToolFile",
                "screwAluminium",
                ToolDictNames.craftingToolSoftMallet.name(),
                null,
                "craftingToolScrewdriver",
                null);
    }
}
