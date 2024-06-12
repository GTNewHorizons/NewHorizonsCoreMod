package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.BartWorks;
import static gregtech.api.enums.Mods.BuildCraftFactory;
import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.FloodLights;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.enums.Mods.GraviSuite;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.OpenBlocks;
import static gregtech.api.enums.Mods.ProjectRedIllumination;
import static gregtech.api.enums.Mods.ProjectRedIntegration;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidSolidifierRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.gthandler.CustomItemList;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class ScriptEnderIO implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "EnderIO";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                EnderIO.ID,
                AppliedEnergistics2.ID,
                Avaritia.ID,
                Backpack.ID,
                BartWorks.ID,
                BuildCraftFactory.ID,
                DraconicEvolution.ID,
                ExtraUtilities.ID,
                FloodLights.ID,
                GTPlusPlus.ID,
                GraviSuite.ID,
                IndustrialCraft2.ID,
                OpenBlocks.ID,
                ProjectRedIllumination.ID,
                ProjectRedIntegration.ID);
    }

    @Override
    public void loadRecipes() {
        ItemStack teleportStaff = getModItem(EnderIO.ID, "itemTeleportStaff", 1);
        ItemStack denseEnergyCell = getModItem(AppliedEnergistics2.ID, "tile.BlockDenseEnergyCell", 1);
        ItemStack energyCell = getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1);
        ItemStack staffOfTravelling = getModItem(EnderIO.ID, "itemTravelStaff", 1, wildcard);
        ItemStack endestPearl = getModItem(Avaritia.ID, "Endest_Pearl", 1);
        ItemStack fieldGeneratorZPM = ItemList.Field_Generator_ZPM.get(1);
        ItemStack circuit2 = GT_Utility.getIntegratedCircuit(2);

        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                teleportStaff,
                "      aaa",
                "     abca",
                "    abcba",
                "   abcba ",
                "   daba  ",
                "  deda   ",
                " dfd     ",
                "dfd      ",
                " d       ",
                'a',
                "plateDenseObsidian",
                'b',
                denseEnergyCell,
                'c',
                energyCell,
                'd',
                staffOfTravelling,
                'e',
                endestPearl,
                'f',
                fieldGeneratorZPM);

        // ME Conduit
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 16),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L),
                        circuit2)
                .itemOutputs(getModItem(EnderIO.ID, "itemMEConduit", 4))
                .fluidInputs(Materials.ConductiveIron.getMolten(144L)).duration(10 * SECONDS).eut(256)
                .addTo(assemblerRecipes);

        // ME Dense Conduit
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemMEConduit", 16),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L),
                        circuit2)
                .itemOutputs(getModItem(EnderIO.ID, "itemMEConduit", 4, 1))
                .fluidInputs(Materials.EnergeticAlloy.getMolten(144L)).duration(10 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        // ME Ultra Dense Conduit
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemMEConduit", 16, 1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1L),
                        circuit2)
                .itemOutputs(getModItem(EnderIO.ID, "itemMEConduit", 4, 2))
                .fluidInputs(Materials.VibrantAlloy.getMolten(144L)).duration(10 * SECONDS).eut(960)
                .addTo(assemblerRecipes);

        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                createItemStack(
                        EnderIO.ID,
                        "blockCapBank",
                        1,
                        0,
                        "{type:\"CREATIVE\",storedEnergyRF:2500000}",
                        missing),
                "aaaaaaaaa",
                "aabbcbbaa",
                "abadddaba",
                "abdaeadba",
                "acdefedca",
                "abdaeadba",
                "abadddaba",
                "aabbcbbaa",
                "aaaaaaaaa",
                'a',
                createItemStack(
                        EnderIO.ID,
                        "blockCapBank",
                        1,
                        3,
                        "{type:\"VIBRANT\",storedEnergyRF:25000000}",
                        missing),
                'b',
                getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing),
                'c',
                "plateVibrantAlloy",
                'd',
                "plateNeutronium",
                'e',
                createItemStack(DraconicEvolution.ID, "draconiumFluxCapacitor", 1, 0, "{Energy:80000000}", missing),
                'f',
                getModItem(DraconicEvolution.ID, "chaoticCore", 1, 0, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(EnderIO.ID, "blockTelePad", 9, 0, missing),
                "aaaaaaaaa",
                "abcdddcba",
                "aefcdcfea",
                "acgfhfgca",
                "aijfkfjia",
                "acgflfgca",
                "aefcdcfea",
                "abcdddcba",
                "aaaaaaaaa",
                'a',
                getModItem(EnderIO.ID, "itemMachinePart", 1, 3, missing),
                'b',
                ItemList.Field_Generator_ZPM.get(1L),
                'c',
                getModItem(BartWorks.ID, "BW_GlasBlocks", 1, 4, missing),
                'd',
                "plateDenseNaquadahEnriched",
                'e',
                "plateDenseStellarAlloy",
                'f',
                getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 11, missing),
                'g',
                ItemList.Electric_Motor_ZPM.get(1L),
                'h',
                getModItem(EnderIO.ID, "itemCoordSelector", 1, wildcard, missing),
                'i',
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 2, missing),
                'j',
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 5, missing),
                'k',
                getModItem(EnderIO.ID, "blockCapBank", 1, 3, missing),
                'l',
                "circuitSuperconductor");

        addShapedRecipe(
                getModItem(EnderIO.ID, "blockStirlingGenerator", 1, 0, missing),
                "itemCasingAnyIron",
                "circuitBasic",
                "itemCasingAnyIron",
                "rotorIron",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                "rotorIron",
                ItemList.Electric_Motor_LV.get(1L),
                "craftingIronFurnace",
                ItemList.Electric_Motor_LV.get(1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockCombustionGenerator", 1, 0, missing),
                "itemCasingSteel",
                "circuitGood",
                "itemCasingSteel",
                "rotorSteel",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                "rotorSteel",
                ItemList.Electric_Motor_MV.get(1L),
                getModItem(EnderIO.ID, "blockTank", 1, 0, missing),
                ItemList.Electric_Motor_MV.get(1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockZombieGenerator", 1, 0, missing),
                "itemCasingSteel",
                "circuitGood",
                "itemCasingSteel",
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                ItemList.Electric_Motor_MV.get(1L),
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 0, missing),
                ItemList.Electric_Motor_MV.get(1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockFrankenzombieGenerator", 1, 0, missing),
                "itemCasingDarkSteel",
                "circuitAdvanced",
                "itemCasingDarkSteel",
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                getModItem(EnderIO.ID, "itemMachinePart", 1, 2, missing),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                ItemList.Electric_Motor_HV.get(1L),
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing),
                ItemList.Electric_Motor_HV.get(1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockEnderGenerator", 1, 0, missing),
                "itemCasingEndSteel",
                "circuitData",
                "itemCasingEndSteel",
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                getModItem(EnderIO.ID, "itemMachinePart", 1, 3, missing),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                ItemList.Electric_Motor_EV.get(1L),
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 3, missing),
                ItemList.Electric_Motor_EV.get(1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSolarPanel", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L),
                ItemList.Cover_SolarPanel.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSolarPanel", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L),
                ItemList.Cover_SolarPanel.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7, missing),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7, missing));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSolarPanel", 1, 1, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.PulsatingIron, 1L),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.PulsatingIron, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L),
                getModItem(EnderIO.ID, "blockSolarPanel", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 1, missing),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 1, missing));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSolarPanel", 1, 1, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.PulsatingIron, 1L),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.PulsatingIron, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L),
                getModItem(EnderIO.ID, "blockSolarPanel", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 8, missing),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 8, missing));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSolarPanel", 1, 2, missing),
                "plateEndSteel",
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 2, missing),
                "plateEndSteel",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L),
                getModItem(EnderIO.ID, "blockSolarPanel", 1, 1, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2, missing),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 2, missing),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2, missing));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSolarPanel", 1, 2, missing),
                "plateEndSteel",
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 2, missing),
                "plateEndSteel",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L),
                getModItem(EnderIO.ID, "blockSolarPanel", 1, 1, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9, missing),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 2, missing),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9, missing));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSagMill", 1, 0, missing),
                "itemCasingSteel",
                ItemList.Electric_Piston_LV.get(1L),
                "itemCasingSteel",
                "circuitBasic",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                "circuitBasic",
                ItemList.Electric_Motor_LV.get(1L),
                ItemList.Component_Sawblade_Diamond.get(1L),
                ItemList.Electric_Motor_LV.get(1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockAlloySmelter", 1, 0, missing),
                "circuitBasic",
                "craftingIronFurnace",
                "circuitBasic",
                "craftingIronFurnace",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                "craftingIronFurnace",
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(Minecraft.ID, "cauldron", 1, 0, missing),
                ItemList.Electric_Motor_LV.get(1L));
        addShapedRecipe(
                createItemStack(EnderIO.ID, "blockCapBank", 1, 1, "{type:\"SIMPLE\",storedEnergyRF:0}", missing),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing),
                "circuitBasic",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing),
                "plateRedstone",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                "plateRedstone",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing),
                ItemList.Battery_RE_MV_Cadmium.get(1L),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing));
        addShapedRecipe(
                createItemStack(EnderIO.ID, "blockCapBank", 1, 1, "{type:\"SIMPLE\",storedEnergyRF:0}", missing),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7, missing),
                "circuitBasic",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7, missing),
                "plateRedstone",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                "plateRedstone",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7, missing),
                ItemList.Battery_RE_MV_Cadmium.get(1L),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7, missing));
        addShapedRecipe(
                createItemStack(EnderIO.ID, "blockCapBank", 1, 2, "{type:\"ACTIVATED\",storedEnergyRF:0}", missing),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 1, missing),
                "circuitGood",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 1, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 1, missing),
                ItemList.Battery_RE_HV_Cadmium.get(1L),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 1, missing));
        addShapedRecipe(
                createItemStack(EnderIO.ID, "blockCapBank", 1, 2, "{type:\"ACTIVATED\",storedEnergyRF:0}", missing),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 8, missing),
                "circuitGood",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 8, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 8, missing),
                ItemList.Battery_RE_HV_Cadmium.get(1L),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 8, missing));
        addShapedRecipe(
                createItemStack(EnderIO.ID, "blockCapBank", 1, 3, "{type:\"VIBRANT\",storedEnergyRF:0}", missing),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2, missing),
                "circuitAdvanced",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2, missing),
                getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing),
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2, missing),
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32540, missing),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2, missing));
        addShapedRecipe(
                createItemStack(EnderIO.ID, "blockCapBank", 1, 3, "{type:\"VIBRANT\",storedEnergyRF:0}", missing),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2, missing),
                "circuitAdvanced",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2, missing),
                getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing),
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2, missing),
                getModItem(GTPlusPlus.ID, "MU-metaitem.01", 1, 32054, missing),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2, missing));
        addShapedRecipe(
                createItemStack(EnderIO.ID, "blockCapBank", 1, 3, "{type:\"VIBRANT\",storedEnergyRF:0}", missing),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9, missing),
                "circuitAdvanced",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9, missing),
                getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing),
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9, missing),
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32540, missing),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9, missing));
        addShapedRecipe(
                createItemStack(EnderIO.ID, "blockCapBank", 1, 3, "{type:\"VIBRANT\",storedEnergyRF:0}", missing),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9, missing),
                "circuitAdvanced",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9, missing),
                getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing),
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9, missing),
                getModItem(GTPlusPlus.ID, "MU-metaitem.01", 1, 32054, missing),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9, missing));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockPainter", 1, 0, missing),
                "itemCasingSteel",
                "rotorSteel",
                "itemCasingSteel",
                "circuitBasic",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                "circuitBasic",
                ItemList.Electric_Motor_LV.get(1L),
                "rotorSteel",
                ItemList.Electric_Motor_LV.get(1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockCrafter", 1, 0, missing),
                "itemCasingSteel",
                getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing),
                "itemCasingSteel",
                "circuitBasic",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                "circuitBasic",
                "itemCasingSteel",
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing),
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                "itemCasingSteel",
                "plateElectricalSteel",
                "itemCasingSteel",
                "plateElectricalSteel",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing),
                "plateElectricalSteel",
                "itemCasingSteel",
                "plateElectricalSteel",
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                "itemCasingSteel",
                "plateElectricalSteel",
                "itemCasingSteel",
                "plateElectricalSteel",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7, missing),
                "plateElectricalSteel",
                "itemCasingSteel",
                "plateElectricalSteel",
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemMachinePart", 1, 2, missing),
                "itemCasingSoularium",
                "plateSoularium",
                "itemCasingSoularium",
                "plateSoularium",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 1, missing),
                "plateSoularium",
                "itemCasingSoularium",
                "plateSoularium",
                "itemCasingSoularium");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemMachinePart", 1, 2, missing),
                "itemCasingSoularium",
                "plateSoularium",
                "itemCasingSoularium",
                "plateSoularium",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 8, missing),
                "plateSoularium",
                "itemCasingSoularium",
                "plateSoularium",
                "itemCasingSoularium");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemMachinePart", 1, 3, missing),
                "itemCasingEndSteel",
                "plateEndSteel",
                "itemCasingEndSteel",
                "plateEndSteel",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2, missing),
                "plateEndSteel",
                "itemCasingEndSteel",
                "plateEndSteel",
                "itemCasingEndSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemMachinePart", 1, 3, missing),
                "itemCasingEndSteel",
                "plateEndSteel",
                "itemCasingEndSteel",
                "plateEndSteel",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9, missing),
                "plateEndSteel",
                "itemCasingEndSteel",
                "plateEndSteel",
                "itemCasingEndSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockVat", 1, 0, missing),
                "itemCasingSteel",
                getModItem(Minecraft.ID, "cauldron", 1, 0, missing),
                "itemCasingSteel",
                getModItem(EnderIO.ID, "blockTank", 1, 0, missing),
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                getModItem(EnderIO.ID, "blockTank", 1, 0, missing),
                ItemList.Electric_Motor_LV.get(1L),
                "craftingIronFurnace",
                ItemList.Electric_Motor_LV.get(1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockPowerMonitor", 1, 0, missing),
                "plateElectricalSteel",
                CustomItemList.Display.get(1L),
                "plateElectricalSteel",
                "circuitBasic",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                "circuitBasic",
                getModItem(EnderIO.ID, "itemPowerConduit", 1, 0, missing),
                getModItem(EnderIO.ID, "itemConduitProbe", 1, 0, missing),
                getModItem(EnderIO.ID, "itemPowerConduit", 1, 0, missing));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockFarmStation", 1, 0, missing),
                ItemList.Robot_Arm_HV.get(1L),
                "plateDensePulsatingIron",
                ItemList.Robot_Arm_HV.get(1L),
                getModItem(EnderIO.ID, "itemMaterial", 1, 5, missing),
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                getModItem(EnderIO.ID, "itemMaterial", 1, 5, missing),
                "gearElectricalSteel",
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing),
                "gearElectricalSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockWirelessCharger", 1, 0, missing),
                "plateElectricalSteel",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2, missing),
                "plateElectricalSteel",
                "circuitAdvanced",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                "circuitAdvanced",
                ItemList.Electric_Motor_HV.get(1L),
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 3, missing),
                ItemList.Electric_Motor_HV.get(1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockWirelessCharger", 1, 0, missing),
                "plateElectricalSteel",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9, missing),
                "plateElectricalSteel",
                "circuitAdvanced",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                "circuitAdvanced",
                ItemList.Electric_Motor_HV.get(1L),
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 3, missing),
                ItemList.Electric_Motor_HV.get(1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockTank", 1, 0, missing),
                "itemCasingSteel",
                CustomItemList.SteelBars.get(1L),
                "itemCasingSteel",
                CustomItemList.SteelBars.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.ElectricalSteel, 1L),
                CustomItemList.SteelBars.get(1L),
                "itemCasingSteel",
                ItemList.Electric_Pump_LV.get(1L),
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockTank", 1, 1, missing),
                "plateDarkSteel",
                getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0, missing),
                "plateDarkSteel",
                getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.DarkSteel, 1L),
                getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0, missing),
                "plateDarkSteel",
                ItemList.Electric_Pump_MV.get(1L),
                "plateDarkSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockReservoir", 2, 0, missing),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                ItemList.Electric_Pump_HV.get(1L),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                getModItem(Minecraft.ID, "cauldron", 1, 0, missing),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                ItemList.Electric_Pump_HV.get(1L),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockTransceiver", 1, 0, missing),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 3, missing),
                "circuitMaster",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 3, missing),
                getModItem(EnderIO.ID, "itemMaterial", 1, 8, missing),
                "frameGtEnderium",
                getModItem(EnderIO.ID, "itemMaterial", 1, 8, missing),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4, missing),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockBuffer", 1, 0, missing),
                "plateElectricalSteel",
                "chestWood",
                "plateElectricalSteel",
                ItemList.Conveyor_Module_LV.get(1L),
                "frameGtDarkSteel",
                "circuitBasic");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockBuffer", 1, 1, missing),
                "plateElectricalSteel",
                getModItem(EnderIO.ID, "itemPowerConduit", 1, 0, missing),
                "plateElectricalSteel",
                ItemList.Battery_RE_LV_Sodium.get(1L),
                "frameGtDarkSteel",
                "circuitBasic");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockInventoryPanel", 1, 0, missing),
                "plateDarkSteel",
                getModItem(EnderIO.ID, "itemFunctionUpgrade", 1, 0, missing),
                "plateDarkSteel",
                getModItem(EnderIO.ID, "itemMaterial", 1, 5, missing),
                CustomItemList.Display.get(1L),
                getModItem(EnderIO.ID, "itemMaterial", 1, 5, missing),
                "plateDarkSteel",
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing),
                "plateDarkSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBall", 4, 0, missing),
                "screwElectricalSteel",
                "plateElectricalSteel",
                "screwElectricalSteel",
                "plateElectricalSteel",
                "ringElectricalSteel",
                "plateElectricalSteel",
                "screwElectricalSteel",
                "plateElectricalSteel",
                "screwElectricalSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBall", 4, 1, missing),
                "screwEnergeticAlloy",
                "plateEnergeticAlloy",
                "screwEnergeticAlloy",
                "plateEnergeticAlloy",
                "ringEnergeticAlloy",
                "plateEnergeticAlloy",
                "screwEnergeticAlloy",
                "plateEnergeticAlloy",
                "screwEnergeticAlloy");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBall", 4, 2, missing),
                "screwVibrantAlloy",
                "plateVibrantAlloy",
                "screwVibrantAlloy",
                "plateVibrantAlloy",
                "ringVibrantAlloy",
                "plateVibrantAlloy",
                "screwVibrantAlloy",
                "plateVibrantAlloy",
                "screwVibrantAlloy");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBall", 4, 3, missing),
                "screwRedstoneAlloy",
                "plateRedstoneAlloy",
                "screwRedstoneAlloy",
                "plateRedstoneAlloy",
                "ringRedstoneAlloy",
                "plateRedstoneAlloy",
                "screwRedstoneAlloy",
                "plateRedstoneAlloy",
                "screwRedstoneAlloy");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBall", 4, 4, missing),
                "screwConductiveIron",
                "plateConductiveIron",
                "screwConductiveIron",
                "plateConductiveIron",
                "ringConductiveIron",
                "plateConductiveIron",
                "screwConductiveIron",
                "plateConductiveIron",
                "screwConductiveIron");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBall", 4, 5, missing),
                "screwPulsatingIron",
                "platePulsatingIron",
                "screwPulsatingIron",
                "platePulsatingIron",
                "ringPulsatingIron",
                "platePulsatingIron",
                "screwPulsatingIron",
                "platePulsatingIron",
                "screwPulsatingIron");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBall", 4, 6, missing),
                "screwDarkSteel",
                "plateDarkSteel",
                "screwDarkSteel",
                "plateDarkSteel",
                "ringDarkSteel",
                "plateDarkSteel",
                "screwDarkSteel",
                "plateDarkSteel",
                "screwDarkSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBall", 4, 7, missing),
                "screwSoularium",
                "plateSoularium",
                "screwSoularium",
                "plateSoularium",
                "ringSoularium",
                "plateSoularium",
                "screwSoularium",
                "plateSoularium",
                "screwSoularium");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBall", 4, 8, missing),
                "screwEndSteel",
                "plateEndSteel",
                "screwEndSteel",
                "plateEndSteel",
                "ringEndSteel",
                "plateEndSteel",
                "screwEndSteel",
                "plateEndSteel",
                "screwEndSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBallEndergy", 4, 0, missing),
                "screwCrudeSteel",
                "plateCrudeSteel",
                "screwCrudeSteel",
                "plateCrudeSteel",
                "ringCrudeSteel",
                "plateCrudeSteel",
                "screwCrudeSteel",
                "plateCrudeSteel",
                "screwCrudeSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBallEndergy", 4, 1, missing),
                "screwCrystallineAlloy",
                "plateCrystallineAlloy",
                "screwCrystallineAlloy",
                "plateCrystallineAlloy",
                "ringCrystallineAlloy",
                "plateCrystallineAlloy",
                "screwCrystallineAlloy",
                "plateCrystallineAlloy",
                "screwCrystallineAlloy");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBallEndergy", 4, 2, missing),
                "screwMelodicAlloy",
                "plateMelodicAlloy",
                "screwMelodicAlloy",
                "plateMelodicAlloy",
                "ringMelodicAlloy",
                "plateMelodicAlloy",
                "screwMelodicAlloy",
                "plateMelodicAlloy",
                "screwMelodicAlloy");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBallEndergy", 4, 3, missing),
                "screwStellarAlloy",
                "plateStellarAlloy",
                "screwStellarAlloy",
                "plateStellarAlloy",
                "ringStellarAlloy",
                "plateStellarAlloy",
                "screwStellarAlloy",
                "plateStellarAlloy",
                "screwStellarAlloy");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBallEndergy", 4, 4, missing),
                "screwCrystallinePinkSlime",
                "plateCrystallinePinkSlime",
                "screwCrystallinePinkSlime",
                "plateCrystallinePinkSlime",
                "ringCrystallinePinkSlime",
                "plateCrystallinePinkSlime",
                "screwCrystallinePinkSlime",
                "plateCrystallinePinkSlime",
                "screwCrystallinePinkSlime");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBallEndergy", 4, 5, missing),
                "screwEnergeticSilver",
                "plateEnergeticSilver",
                "screwEnergeticSilver",
                "plateEnergeticSilver",
                "ringEnergeticSilver",
                "plateEnergeticSilver",
                "screwEnergeticSilver",
                "plateEnergeticSilver",
                "screwEnergeticSilver");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBallEndergy", 4, 6, missing),
                "screwVividAlloy",
                "plateVividAlloy",
                "screwVividAlloy",
                "plateVividAlloy",
                "ringVividAlloy",
                "plateVividAlloy",
                "screwVividAlloy",
                "plateVividAlloy",
                "screwVividAlloy");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockEnderIo", 1, 0, missing),
                "plateElectricalSteel",
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                "plateElectricalSteel",
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                "lensEnderEye",
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                "plateElectricalSteel",
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                "plateElectricalSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockTravelAnchor", 1, 0, missing),
                "plateElectricalSteel",
                getModItem(OpenBlocks.ID, "elevator", 1, 0, missing),
                "plateElectricalSteel",
                getModItem(EnderIO.ID, "itemMaterial", 1, 5, missing),
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                getModItem(EnderIO.ID, "itemMaterial", 1, 5, missing),
                "plateElectricalSteel",
                ItemList.Field_Generator_LV.get(1L),
                "plateElectricalSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSliceAndSplice", 1, 0, missing),
                "plateSoularium",
                getModItem(Minecraft.ID, "shears", 1, 0, missing),
                "plateSoularium",
                "circuitGood",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                "circuitGood",
                ItemList.Electric_Motor_MV.get(1L),
                getModItem(Minecraft.ID, "iron_axe", 1, 0, missing),
                ItemList.Electric_Motor_MV.get(1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSoulBinder", 1, 0, missing),
                "plateSoularium",
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 3, missing),
                "plateSoularium",
                "circuitAdvanced",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                "circuitAdvanced",
                ItemList.Electric_Motor_HV.get(1L),
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing),
                ItemList.Electric_Motor_HV.get(1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockPoweredSpawner", 1, 0, missing),
                "plateDarkSteel",
                "itemSkull",
                "plateDarkSteel",
                "plateSoularium",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                "plateSoularium",
                getModItem(EnderIO.ID, "itemMaterial", 1, 8, missing),
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 2, missing),
                getModItem(EnderIO.ID, "itemMaterial", 1, 8, missing));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockKillerJoe", 1, 0, missing),
                "itemCasingAluminium",
                "circuitGood",
                "itemCasingAluminium",
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                ItemList.Electric_Motor_MV.get(1L),
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 2, missing),
                ItemList.Electric_Motor_MV.get(1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockAttractor", 1, 0, missing),
                null,
                getModItem(EnderIO.ID, "itemMaterial", 1, 9, missing),
                null,
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                "plateSoularium",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                "plateSoularium",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                "plateSoularium");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSpawnGuard", 1, 0, missing),
                null,
                getModItem(EnderIO.ID, "blockEndermanSkull", 1, 2, missing),
                null,
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                "plateSoularium",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                "plateSoularium",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                "plateSoularium");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockExperienceObelisk", 1, 0, missing),
                null,
                getModItem(EnderIO.ID, "itemXpTransfer", 1, 0, missing),
                null,
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                "plateSoularium",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                "plateSoularium",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                "plateSoularium");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockWeatherObelisk", 1, 0, missing),
                null,
                getModItem(EnderIO.ID, "itemMaterial", 1, 10, missing),
                null,
                "bucketLava",
                "plateSoularium",
                "bucketWater",
                "plateSoularium",
                getModItem(EnderIO.ID, "blockCapBank", 1, 2, missing),
                "plateSoularium");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockEnchanter", 1, 0, missing),
                getModItem(EnderIO.ID, "itemMaterial", 1, 5, missing),
                "craftingBook",
                getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing),
                null,
                "plateDarkSteel",
                null,
                "plateDarkSteel",
                getModItem(Minecraft.ID, "enchanting_table", 1, 0, missing),
                "plateDarkSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockDarkIronBars", 3, 0, missing),
                null,
                "craftingToolHardHammer",
                null,
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.DarkSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.DarkSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.DarkSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.DarkSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.DarkSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.DarkSteel, 1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSoulariumBars", 3, 0, missing),
                null,
                "craftingToolHardHammer",
                null,
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Soularium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Soularium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Soularium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Soularium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Soularium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Soularium, 1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockEndSteelBars", 3, 0, missing),
                null,
                "craftingToolHardHammer",
                null,
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.EndSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.EndSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.EndSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.EndSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.EndSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.EndSteel, 1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockDarkSteelLadder", 1, 0, missing),
                getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0, missing),
                "wireFineSteel",
                "screwSteel",
                "wireFineSteel",
                getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0, missing),
                "craftingToolWrench",
                getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0, missing));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockElectricLight", 8, 0, missing),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                "plateSiliconSolarGrade",
                getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0, missing),
                "plateSiliconSolarGrade",
                "circuitBasic",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing),
                "circuitBasic");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockElectricLight", 8, 0, missing),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                "plateSiliconSolarGrade",
                getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0, missing),
                "plateSiliconSolarGrade",
                "circuitBasic",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7, missing),
                "circuitBasic");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockElectricLight", 16, 2, missing),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                "plateSiliconSolarGrade",
                getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1, 0, missing),
                "plateSiliconSolarGrade",
                "plateIron",
                "wireGt01RedAlloy",
                "plateIron");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockReinforcedObsidian", 1, 0, missing),
                "plateDarkSteel",
                getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0, missing),
                "plateDarkSteel",
                getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0, missing),
                "blockObsidian",
                getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0, missing),
                "plateDarkSteel",
                getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0, missing),
                "plateDarkSteel");
        addShapedRecipe(
                createItemStack(EnderIO.ID, "itemCoordSelector", 1, 0, "{bc:x:0,default:1b,bc:y:0,bc:z:0}", missing),
                "plateElectricalSteel",
                "gemEnderEye",
                "plateElectricalSteel",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.PulsatingIron, 1L),
                getModItem(Minecraft.ID, "compass", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.PulsatingIron, 1L),
                "plateElectricalSteel",
                "gemEnderEye",
                "plateElectricalSteel");
        addShapelessRecipe(
                getModItem(EnderIO.ID, "itemExtractSpeedUpgrade", 1, 0, missing),
                getModItem(EnderIO.ID, "itemExtractSpeedUpgrade", 1, 1, missing));
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemFunctionUpgrade", 1, 0, missing),
                "plateSiliconSolarGrade",
                getModItem(EnderIO.ID, "itemMaterial", 1, 1, missing),
                "plateSiliconSolarGrade",
                "circuitAdvanced",
                "gemEnderEye",
                "circuitAdvanced",
                "plateSiliconSolarGrade",
                "plateElectricalSteel",
                "plateSiliconSolarGrade");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemYetaWrench", 1, 0, missing),
                "ingotElectricalSteel",
                "craftingToolHardHammer",
                "ingotElectricalSteel",
                "ingotElectricalSteel",
                "gearElectricalSteel",
                "ingotElectricalSteel",
                null,
                "ingotElectricalSteel",
                null);
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemConduitProbe", 1, 0, missing),
                "plateSiliconSolarGrade",
                getModItem(EnderIO.ID, "itemPowerConduit", 1, 0, missing),
                "plateSiliconSolarGrade",
                "circuitBasic",
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26, missing),
                "circuitBasic",
                "plateElectricalSteel",
                getModItem(EnderIO.ID, "itemRedstoneConduit", 1, 2, missing),
                "plateElectricalSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemTravelStaff", 1, 16, missing),
                "craftingToolScrewdriver",
                "circuitAdvanced",
                getModItem(EnderIO.ID, "itemMaterial", 1, 8, missing),
                "screwVibrantAlloy",
                "stickDarkSteel",
                "circuitAdvanced",
                "stickDarkSteel",
                "screwVibrantAlloy",
                "craftingToolWrench");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemXpTransfer", 1, 0, missing),
                "craftingToolScrewdriver",
                "circuitAdvanced",
                getModItem(EnderIO.ID, "itemMaterial", 1, 5, missing),
                "screwEnergeticAlloy",
                "stickSoularium",
                "circuitAdvanced",
                "stickSoularium",
                "screwEnergeticAlloy",
                "craftingToolWrench");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGliderWing", 1, 0, missing),
                "craftingToolHardHammer",
                "stickDarkSteel",
                "itemLeather",
                "stickDarkSteel",
                getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                "itemLeather",
                "itemLeather",
                "itemLeather",
                "itemLeather");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGliderWing", 1, 1, missing),
                "screwDarkSteel",
                "stickDarkSteel",
                "screwDarkSteel",
                getModItem(EnderIO.ID, "itemGliderWing", 1, 0, missing),
                "plateDarkSteel",
                getModItem(EnderIO.ID, "itemGliderWing", 1, 0, missing),
                "craftingToolWrench",
                "stickDarkSteel",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemMagnet", 1, 16, missing),
                "plateElectricalSteel",
                "plateConductiveIron",
                "plateConductiveIron",
                "craftingToolWrench",
                "screwSteelMagnetic",
                getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing),
                "plateElectricalSteel",
                "plateConductiveIron",
                "plateConductiveIron");
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.endSteel_helmet", 1, 0, missing),
                "plateEndSteel",
                "plateEndSteel",
                "plateEndSteel",
                "plateEndSteel",
                "craftingToolHardHammer",
                "plateEndSteel",
                null,
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 6, missing),
                null);
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.endSteel_chestplate", 1, 0, missing),
                "plateEndSteel",
                "craftingToolHardHammer",
                "plateEndSteel",
                "plateEndSteel",
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 6, missing),
                "plateEndSteel",
                "plateEndSteel",
                "plateEndSteel",
                "plateEndSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.endSteel_leggings", 1, 0, missing),
                "plateEndSteel",
                "plateEndSteel",
                "plateEndSteel",
                "plateEndSteel",
                "craftingToolHardHammer",
                "plateEndSteel",
                "plateEndSteel",
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 6, missing),
                "plateEndSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.endSteel_boots", 1, 0, missing),
                "plateEndSteel",
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 6, missing),
                "plateEndSteel",
                "plateEndSteel",
                "craftingToolHardHammer",
                "plateEndSteel",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.stellar_helmet", 1, 0, missing),
                "plateStellarAlloy",
                "plateStellarAlloy",
                "plateStellarAlloy",
                "plateStellarAlloy",
                "craftingToolHardHammer",
                "plateStellarAlloy",
                null,
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4, missing),
                null);
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.stellar_chestplate", 1, 0, missing),
                "plateStellarAlloy",
                "craftingToolHardHammer",
                "plateStellarAlloy",
                "plateStellarAlloy",
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4, missing),
                "plateStellarAlloy",
                "plateStellarAlloy",
                "plateStellarAlloy",
                "plateStellarAlloy");
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.stellar_leggings", 1, 0, missing),
                "plateStellarAlloy",
                "plateStellarAlloy",
                "plateStellarAlloy",
                "plateStellarAlloy",
                "craftingToolHardHammer",
                "plateStellarAlloy",
                "plateStellarAlloy",
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4, missing),
                "plateStellarAlloy");
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.stellar_boots", 1, 0, missing),
                "plateStellarAlloy",
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4, missing),
                "plateStellarAlloy",
                "plateStellarAlloy",
                "craftingToolHardHammer",
                "plateStellarAlloy",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.endSteel_pickaxe", 1, 0, missing),
                "plateEndSteel",
                "ingotEndSteel",
                "ingotEndSteel",
                "craftingToolFile",
                getModItem(EnderIO.ID, "itemMaterial", 1, 12, missing),
                "craftingToolHardHammer",
                null,
                getModItem(EnderIO.ID, "itemMaterial", 1, 12, missing),
                null);
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.endSteel_axe", 1, 0, missing),
                "plateEndSteel",
                "ingotEndSteel",
                "craftingToolHardHammer",
                "plateEndSteel",
                getModItem(EnderIO.ID, "itemMaterial", 1, 12, missing),
                "plateEndSteel",
                "craftingToolFile",
                getModItem(EnderIO.ID, "itemMaterial", 1, 12, missing),
                null);
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.endSteel_sword", 1, 0, missing),
                null,
                "plateEndSteel",
                null,
                "craftingToolFile",
                "plateEndSteel",
                "craftingToolHardHammer",
                null,
                getModItem(EnderIO.ID, "itemMaterial", 1, 12, missing),
                null);
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.stellar_pickaxe", 1, 0, missing),
                "plateStellarAlloy",
                "ingotStellarAlloy",
                "ingotStellarAlloy",
                "craftingToolFile",
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4, missing),
                "craftingToolHardHammer",
                null,
                getModItem(EnderIO.ID, "itemMaterial", 1, 12, missing),
                null);
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.stellar_axe", 1, 0, missing),
                "plateStellarAlloy",
                "ingotStellarAlloy",
                "craftingToolHardHammer",
                "plateStellarAlloy",
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4, missing),
                "plateStellarAlloy",
                "craftingToolFile",
                getModItem(EnderIO.ID, "itemMaterial", 1, 12, missing),
                null);
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.stellar_sword", 1, 0, missing),
                null,
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4, missing),
                null,
                "craftingToolFile",
                "plateStellarAlloy",
                "craftingToolHardHammer",
                null,
                getModItem(EnderIO.ID, "itemMaterial", 1, 12, missing),
                null);
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemMaterial", 1, 12, missing),
                "craftingToolScrewdriver",
                "screwEndSteel",
                "stickDarkSteel",
                "screwEndSteel",
                "stickDarkSteel",
                "screwEndSteel",
                "stickDarkSteel",
                "screwEndSteel",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.darkSteel_shears", 1, 0, missing),
                "plateDarkSteel",
                "screwDarkSteel",
                "plateDarkSteel",
                "craftingToolHardHammer",
                "ringDarkSteel",
                "craftingToolFile",
                "stickWood",
                "craftingToolScrewdriver",
                "stickWood");

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Automation_ChestBuffer_LV.get(1L),
                        getModItem(ExtraUtilities.ID, "enderCollector", 1, 0, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockVacuumChest", 1, 0, missing)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "blockBuffer", 1, 0, missing),
                        getModItem(EnderIO.ID, "blockBuffer", 1, 1, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockBuffer", 1, 2, missing)).duration(20 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "diamond", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.PulsatingIron, 8L))
                .itemOutputs(getModItem(EnderIO.ID, "itemMaterial", 1, 5, missing)).duration(30 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "emerald", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.VibrantAlloy, 8L))
                .itemOutputs(getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing)).duration(30 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.ElectricalSteel, 1L),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 0, missing)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 1, missing)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 2, missing)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedstoneAlloy, 1L),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 3, missing)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.ConductiveIron, 1L),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 4, missing)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.PulsatingIron, 1L),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 5, missing)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.DarkSteel, 1L),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 6, missing)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Soularium, 1L),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 7, missing)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EndSteel, 1L),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 8, missing)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EndSteel, 1L),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 9, missing)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CrudeSteel, 1L),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 0, missing)).duration(10 * SECONDS)
                .eut(64).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CrystallineAlloy, 1L),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 1, missing)).duration(10 * SECONDS)
                .eut(64).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.MelodicAlloy, 1L),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 2, missing)).duration(10 * SECONDS)
                .eut(64).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StellarAlloy, 1L),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 3, missing)).duration(10 * SECONDS)
                .eut(64).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CrystallinePinkSlime, 1L),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 4, missing)).duration(10 * SECONDS)
                .eut(64).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticSilver, 1L),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 5, missing)).duration(10 * SECONDS)
                .eut(64).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.VividAlloy, 1L),
                        GT_Utility.getIntegratedCircuit(5))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 6, missing)).duration(10 * SECONDS)
                .eut(64).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.ManyullynCrystal.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Enderium, 8L))
                .itemOutputs(getModItem(EnderIO.ID, "itemMaterial", 1, 10, missing)).duration(10 * SECONDS).eut(256)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.DarkSteel, 2L))
                .itemOutputs(getModItem(EnderIO.ID, "blockDarkSteelPressurePlate", 1, 0, missing))
                .duration(10 * SECONDS).eut(64).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "blockDarkSteelPressurePlate", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "blockRubber", 1, 0, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockDarkSteelPressurePlate", 1, 1, missing))
                .duration(10 * SECONDS).eut(64).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(EnderIO.ID, "blockDarkSteelLadder", 2, 0, missing)).duration(5 * SECONDS)
                .eut(96).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.DarkSteel, 3L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(EnderIO.ID, "blockDarkIronBars", 4, 0, missing)).duration(30 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Soularium, 3L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(EnderIO.ID, "blockSoulariumBars", 4, 0, missing)).duration(30 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.EndSteel, 3L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(EnderIO.ID, "blockEndSteelBars", 4, 0, missing)).duration(30 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "blockElectricLight", 1, 0, missing),
                        getModItem(Minecraft.ID, "redstone_torch", 1, 0, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockElectricLight", 1, 1, missing)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "blockElectricLight", 1, 2, missing),
                        getModItem(Minecraft.ID, "redstone_torch", 1, 0, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockElectricLight", 1, 3, missing)).duration(5 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "blockElectricLight", 16, 0, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 3, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockElectricLight", 16, 4, missing)).duration(10 * SECONDS)
                .eut(256).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "blockElectricLight", 1, 4, missing),
                        getModItem(Minecraft.ID, "redstone_torch", 1, 0, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockElectricLight", 1, 5, missing)).duration(10 * SECONDS)
                .eut(256).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 1L),
                        getModItem(EnderIO.ID, "itemMaterial", 4, 1, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemFusedQuartzFrame", 1, 0, missing)).duration(5 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(EnderIO.ID, "itemMaterial", 8, 1, missing), GT_Utility.getIntegratedCircuit(8))
                .itemOutputs(getModItem(EnderIO.ID, "itemConduitFacade", 1, 0, missing)).duration(5 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemRedstoneConduit", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 2, 1, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemRedstoneConduit", 1, 2, missing)).duration(5 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemRedstoneConduit", 1, 2, missing),
                        getModItem(Minecraft.ID, "lever", 1, 0, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemRedstoneConduit", 1, 1, missing)).duration(5 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedstoneAlloy, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemRedstoneConduit", 1, 0, missing)).duration(5 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedstoneAlloy, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemRedstoneConduit", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).duration(5 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Gold, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.ConductiveIron, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduit", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).duration(5 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Aluminium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduit", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).duration(5 * SECONDS).eut(256)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Osmium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduit", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.epoxid", 144)).duration(5 * SECONDS).eut(480)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CrudeSteel, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144)).duration(5 * SECONDS).eut(8)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Zinc, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144)).duration(5 * SECONDS).eut(16)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SolderingAlloy, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144)).duration(5 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Nickel, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 144)).duration(5 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 1380, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 144)).duration(5 * SECONDS).eut(96)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Electrum, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silver, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).duration(5 * SECONDS).eut(160)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.BlackSteel, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Electrum, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).duration(5 * SECONDS).eut(192)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.TungstenSteel, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticSilver, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.epoxid", 144)).duration(5 * SECONDS).eut(320)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.HSSG, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CrystallineAlloy, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.epoxid", 144)).duration(5 * SECONDS).eut(960)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.NiobiumTitanium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CrystallinePinkSlime, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.polytetrafluoroethylene", 144)).duration(5 * SECONDS)
                .eut(1920).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Naquadah, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.MelodicAlloy, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.polytetrafluoroethylene", 144)).duration(5 * SECONDS)
                .eut(7680).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.BlackPlutonium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StellarAlloy, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 11, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.polybenzimidazole", 144)).duration(5 * SECONDS)
                .eut(30720).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Copper, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.ElectricalSteel, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).duration(5 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.DarkSteel, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).duration(5 * SECONDS).eut(256)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Polytetrafluoroethylene, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).duration(5 * SECONDS).eut(480)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Polytetrafluoroethylene, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CrystallineAlloy, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.epoxid", 144)).duration(5 * SECONDS).eut(960)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Polytetrafluoroethylene, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CrystallinePinkSlime, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.polytetrafluoroethylene", 144)).duration(5 * SECONDS)
                .eut(1920).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Polybenzimidazole, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.MelodicAlloy, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.polytetrafluoroethylene", 144)).duration(5 * SECONDS)
                .eut(7680).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Polybenzimidazole, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StellarAlloy, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.polybenzimidazole", 144)).duration(5 * SECONDS)
                .eut(30720).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Electrum, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.PulsatingIron, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemItemConduit", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).duration(5 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedstoneAlloy, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemOCConduit", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).duration(5 * SECONDS).eut(480)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(ItemList.Component_Filter.get(1L), getModItem(Minecraft.ID, "iron_bars", 1, 0, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 1, 0, missing)).duration(15 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 1, 1, missing)).duration(15 * SECONDS)
                .eut(64).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 1, 1, missing),
                        getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemLimitedItemFilter", 1, 0, missing)).duration(15 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 2, 1, missing),
                        getModItem(EnderIO.ID, "blockEndSteelBars", 2, 0, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemBigFilterUpgrade", 1, 0, missing)).duration(15 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBigFilterUpgrade", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 2, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemBigFilterUpgrade", 1, 1, missing)).duration(15 * SECONDS)
                .eut(256).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 1, 1, missing),
                        getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 20, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemExistingItemFilter", 1, 0, missing)).duration(15 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemYetaWrench", 1, 0, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemModItemFilter", 1, 0, missing)).duration(15 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemConduitProbe", 1, 0, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerItemFilter", 1, 0, missing)).duration(15 * SECONDS)
                .eut(64).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 1, 0, missing),
                        ItemList.Electric_Piston_LV.get(1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemExtractSpeedUpgrade", 1, 0, missing)).duration(15 * SECONDS)
                .eut(64).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemExtractSpeedUpgrade", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(EnderIO.ID, "itemExtractSpeedUpgrade", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 144)).duration(15 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "blockFusedQuartz", 3, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.round, Materials.Soularium, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemSoulVessel", 1, 0, missing)).duration(10 * SECONDS).eut(48)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemCasing", 2, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockCrafter", 1, 0, missing)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing),
                        ItemList.Circuit_Basic.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemCasing", 2, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockCrafter", 1, 0, missing)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing),
                        ItemList.Circuit_Microprocessor.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemCasing", 2, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockCrafter", 1, 0, missing)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "itemCasing", 2, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockCrafter", 1, 0, missing)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        ItemList.IC2_Item_Casing_Steel.get(2L))
                .itemOutputs(getModItem(EnderIO.ID, "blockCrafter", 1, 0, missing)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing),
                        ItemList.Circuit_Basic.get(1L),
                        ItemList.IC2_Item_Casing_Steel.get(2L))
                .itemOutputs(getModItem(EnderIO.ID, "blockCrafter", 1, 0, missing)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing),
                        ItemList.Circuit_Microprocessor.get(1L),
                        ItemList.IC2_Item_Casing_Steel.get(2L))
                .itemOutputs(getModItem(EnderIO.ID, "blockCrafter", 1, 0, missing)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        ItemList.IC2_Item_Casing_Steel.get(2L))
                .itemOutputs(getModItem(EnderIO.ID, "blockCrafter", 1, 0, missing)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.ElectricalSteel, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Steel, 2L))
                .itemOutputs(getModItem(EnderIO.ID, "itemMachinePart", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.ElectricalSteel, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Steel, 2L))
                .itemOutputs(getModItem(EnderIO.ID, "itemMachinePart", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "obsidian", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.DarkSteel, 2L),
                        getModItem(EnderIO.ID, "blockDarkIronBars", 2, 0, missing),
                        GT_Utility.getIntegratedCircuit(17))
                .itemOutputs(getModItem(EnderIO.ID, "blockReinforcedObsidian", 1, 0, missing)).duration(30 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Anvil.get(0L))
                .itemOutputs(getModItem(EnderIO.ID, "blockDarkSteelAnvil", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.darksteel", 4464)).duration(45 * SECONDS).eut(120)
                .addTo(fluidSolidifierRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemPartCFPowder", 1, 0, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemMaterial", 9, 2, missing)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "itemMaterial", 1, 5, missing))
                .itemOutputs(
                        getModItem(EnderIO.ID, "itemMaterial", 1, 14, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 14, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 14, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 14, missing))
                .outputChances(10000, 1000, 100, 10).duration(5 * SECONDS).eut(480).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing))
                .itemOutputs(
                        getModItem(EnderIO.ID, "itemMaterial", 1, 15, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 15, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 15, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 15, missing))
                .outputChances(10000, 1000, 100, 10).duration(15 * SECONDS).eut(480).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "itemMaterial", 1, 8, missing))
                .itemOutputs(
                        getModItem(EnderIO.ID, "itemMaterial", 1, 16, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 16, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 16, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 16, missing))
                .outputChances(10000, 1000, 100, 10).duration(15 * SECONDS).eut(480).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "itemMaterial", 1, 13, missing))
                .itemOutputs(
                        getModItem(EnderIO.ID, "itemMaterial", 1, 17, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 17, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 17, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 17, missing))
                .outputChances(10000, 1000, 100, 10).duration(15 * SECONDS).eut(480).addTo(maceratorRecipes);

    }
}
