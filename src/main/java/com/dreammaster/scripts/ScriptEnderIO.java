package com.dreammaster.scripts;

import static bartworks.common.loaders.ItemRegistry.bw_realglas;
import static com.dreammaster.scripts.IngredientFactory.createItemStack;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.Botania;
import static gregtech.api.enums.Mods.BuildCraftFactory;
import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.EtFuturumRequiem;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.FloodLights;
import static gregtech.api.enums.Mods.GraviSuite;
import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.MagicBees;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.OpenBlocks;
import static gregtech.api.enums.Mods.ProjectRedIllumination;
import static gregtech.api.enums.Mods.ProjectRedIntegration;
import static gregtech.api.enums.Mods.RandomThings;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicExploration;
import static gregtech.api.enums.Mods.Witchery;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.autoclaveRecipes;
import static gregtech.api.recipe.RecipeMaps.circuitAssemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidSolidifierRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.recipe.RecipeMaps.mixerRecipes;
import static gregtech.api.recipe.RecipeMaps.multiblockChemicalReactorRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeConstants.UniversalChemical;

import java.util.Arrays;
import java.util.List;

import com.dreammaster.block.BlockList;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.item.NHItemList;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;

public class ScriptEnderIO implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "EnderIO";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                AppliedEnergistics2.ID,
                Avaritia.ID,
                Backpack.ID,
                Botania.ID,
                BuildCraftFactory.ID,
                DraconicEvolution.ID,
                EnderIO.ID,
                ExtraUtilities.ID,
                FloodLights.ID,
                GraviSuite.ID,
                HardcoreEnderExpansion.ID,
                IndustrialCraft2.ID,
                MagicBees.ID,
                OpenBlocks.ID,
                ProjectRedIllumination.ID,
                ProjectRedIntegration.ID,
                Thaumcraft.ID,
                ThaumicExploration.ID);
    }

    @Override
    public void loadRecipes() {
        ItemStack teleportStaff = getModItem(EnderIO.ID, "itemTeleportStaff", 1);
        ItemStack denseEnergyCell = getModItem(AppliedEnergistics2.ID, "tile.BlockDenseEnergyCell", 1);
        ItemStack energyCell = getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1);
        ItemStack staffOfTravelling = getModItem(EnderIO.ID, "itemTravelStaff", 1, wildcard);
        ItemStack endestPearl = getModItem(Avaritia.ID, "Endest_Pearl", 1);
        ItemStack fieldGeneratorZPM = ItemList.Field_Generator_ZPM.get(1);

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
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 16),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1L))
                .circuit(2).itemOutputs(getModItem(EnderIO.ID, "itemMEConduit", 4))
                .fluidInputs(Materials.ConductiveIron.getMolten(144L)).duration(10 * SECONDS).eut(TierEU.RECIPE_HV / 2)
                .addTo(assemblerRecipes);

        // ME Dense Conduit
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemMEConduit", 16),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1L))
                .circuit(2).itemOutputs(getModItem(EnderIO.ID, "itemMEConduit", 4, 1))
                .fluidInputs(Materials.EnergeticAlloy.getMolten(144L)).duration(10 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                createItemStack(EnderIO.ID, "blockCapBank", 1, 0, "{type:\"CREATIVE\",storedEnergyRF:2500000}"),
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
                createItemStack(EnderIO.ID, "blockCapBank", 1, 3, "{type:\"VIBRANT\",storedEnergyRF:25000000}"),
                'b',
                getModItem(EnderIO.ID, "itemMaterial", 1, 6),
                'c',
                "plateVibrantAlloy",
                'd',
                "plateNeutronium",
                'e',
                createItemStack(DraconicEvolution.ID, "draconiumFluxCapacitor", 1, 0, "{Energy:80000000}"),
                'f',
                getModItem(DraconicEvolution.ID, "chaoticCore", 1, 0));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(EnderIO.ID, "blockTelePad", 9, 0),
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
                getModItem(EnderIO.ID, "itemMachinePart", 1, 3),
                'b',
                ItemList.Field_Generator_ZPM.get(1L),
                'c',
                new ItemStack(bw_realglas, 1, 4),
                'd',
                "plateDenseNaquadahEnriched",
                'e',
                "plateDenseStellarAlloy",
                'f',
                getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 11),
                'g',
                ItemList.Electric_Motor_ZPM.get(1L),
                'h',
                getModItem(EnderIO.ID, "itemCoordSelector", 1, wildcard),
                'i',
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 2),
                'j',
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 5),
                'k',
                getModItem(EnderIO.ID, "blockCapBank", 1, 3),
                'l',
                "circuitSuperconductor");

        addShapedRecipe(
                getModItem(EnderIO.ID, "blockStirlingGenerator", 1, 0),
                "itemCasingAnyIron",
                "circuitBasic",
                "itemCasingAnyIron",
                "rotorIron",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                "rotorIron",
                ItemList.Electric_Motor_LV.get(1L),
                "craftingBlastFurnace",
                ItemList.Electric_Motor_LV.get(1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockCombustionGenerator", 1, 0),
                "itemCasingSteel",
                "circuitGood",
                "itemCasingSteel",
                "rotorSteel",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                "rotorSteel",
                ItemList.Electric_Motor_MV.get(1L),
                getModItem(EnderIO.ID, "blockTank", 1, 0),
                ItemList.Electric_Motor_MV.get(1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockZombieGenerator", 1, 0),
                "itemCasingSteel",
                "circuitGood",
                "itemCasingSteel",
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                ItemList.Electric_Motor_MV.get(1L),
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 0),
                ItemList.Electric_Motor_MV.get(1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockFrankenzombieGenerator", 1, 0),
                "itemCasingDarkSteel",
                "circuitAdvanced",
                "itemCasingDarkSteel",
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                getModItem(EnderIO.ID, "itemMachinePart", 1, 2),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                ItemList.Electric_Motor_HV.get(1L),
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1),
                ItemList.Electric_Motor_HV.get(1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockEnderGenerator", 1, 0),
                "itemCasingEndSteel",
                "circuitData",
                "itemCasingEndSteel",
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                getModItem(EnderIO.ID, "itemMachinePart", 1, 3),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                ItemList.Electric_Motor_EV.get(1L),
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 3),
                ItemList.Electric_Motor_EV.get(1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSolarPanel", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L),
                ItemList.Cover_SolarPanel.get(1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSolarPanel", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L),
                ItemList.Cover_SolarPanel.get(1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSolarPanel", 1, 1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.PulsatingIron, 1L),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.PulsatingIron, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L),
                getModItem(EnderIO.ID, "blockSolarPanel", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 1),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 1));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSolarPanel", 1, 1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.PulsatingIron, 1L),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.PulsatingIron, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L),
                getModItem(EnderIO.ID, "blockSolarPanel", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 8),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 8));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSolarPanel", 1, 2),
                "plateEndSteel",
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 2),
                "plateEndSteel",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L),
                getModItem(EnderIO.ID, "blockSolarPanel", 1, 1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 2),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSolarPanel", 1, 2),
                "plateEndSteel",
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 2),
                "plateEndSteel",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L),
                getModItem(EnderIO.ID, "blockSolarPanel", 1, 1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 2),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSagMill", 1, 0),
                "itemCasingSteel",
                ItemList.Electric_Piston_LV.get(1L),
                "itemCasingSteel",
                "circuitBasic",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                "circuitBasic",
                ItemList.Electric_Motor_LV.get(1L),
                ItemList.Component_Sawblade_Diamond.get(1L),
                ItemList.Electric_Motor_LV.get(1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockAlloySmelter", 1, 0),
                "circuitBasic",
                "craftingBlastFurnace",
                "circuitBasic",
                "craftingBlastFurnace",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                "craftingBlastFurnace",
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(Minecraft.ID, "cauldron", 1, 0),
                ItemList.Electric_Motor_LV.get(1L));
        addShapedRecipe(
                createItemStack(EnderIO.ID, "blockCapBank", 1, 1, "{type:\"SIMPLE\",storedEnergyRF:0}"),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0),
                "circuitBasic",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0),
                "plateRedstone",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                "plateRedstone",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0),
                ItemList.Battery_RE_MV_Cadmium.get(1L),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0));
        addShapedRecipe(
                createItemStack(EnderIO.ID, "blockCapBank", 1, 1, "{type:\"SIMPLE\",storedEnergyRF:0}"),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7),
                "circuitBasic",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7),
                "plateRedstone",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                "plateRedstone",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7),
                ItemList.Battery_RE_MV_Cadmium.get(1L),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7));
        addShapedRecipe(
                createItemStack(EnderIO.ID, "blockCapBank", 1, 2, "{type:\"ACTIVATED\",storedEnergyRF:0}"),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 1),
                "circuitGood",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 1),
                ItemList.Battery_RE_HV_Cadmium.get(1L),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 1));
        addShapedRecipe(
                createItemStack(EnderIO.ID, "blockCapBank", 1, 2, "{type:\"ACTIVATED\",storedEnergyRF:0}"),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 8),
                "circuitGood",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 8),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 8),
                ItemList.Battery_RE_HV_Cadmium.get(1L),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 8));
        addShapedRecipe(
                createItemStack(EnderIO.ID, "blockCapBank", 1, 3, "{type:\"VIBRANT\",storedEnergyRF:0}"),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2),
                "circuitAdvanced",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2),
                getModItem(EnderIO.ID, "itemMaterial", 1, 6),
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                getModItem(EnderIO.ID, "itemMaterial", 1, 6),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2),
                ItemList.BatteryHull_EV_Full.get(1),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2));
        addShapedRecipe(
                createItemStack(EnderIO.ID, "blockCapBank", 1, 3, "{type:\"VIBRANT\",storedEnergyRF:0}"),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2),
                "circuitAdvanced",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2),
                getModItem(EnderIO.ID, "itemMaterial", 1, 6),
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                getModItem(EnderIO.ID, "itemMaterial", 1, 6),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2),
                GregtechItemList.Battery_RE_EV_Lithium.get(1),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2));
        addShapedRecipe(
                createItemStack(EnderIO.ID, "blockCapBank", 1, 3, "{type:\"VIBRANT\",storedEnergyRF:0}"),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9),
                "circuitAdvanced",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9),
                getModItem(EnderIO.ID, "itemMaterial", 1, 6),
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                getModItem(EnderIO.ID, "itemMaterial", 1, 6),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9),
                ItemList.BatteryHull_EV_Full.get(1),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9));
        addShapedRecipe(
                createItemStack(EnderIO.ID, "blockCapBank", 1, 3, "{type:\"VIBRANT\",storedEnergyRF:0}"),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9),
                "circuitAdvanced",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9),
                getModItem(EnderIO.ID, "itemMaterial", 1, 6),
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                getModItem(EnderIO.ID, "itemMaterial", 1, 6),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9),
                GregtechItemList.Battery_RE_EV_Lithium.get(1),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockPainter", 1, 0),
                "itemCasingSteel",
                "rotorSteel",
                "itemCasingSteel",
                "circuitBasic",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                "circuitBasic",
                ItemList.Electric_Motor_LV.get(1L),
                "rotorSteel",
                ItemList.Electric_Motor_LV.get(1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockCrafter", 1, 0),
                "itemCasingSteel",
                getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0),
                "itemCasingSteel",
                "circuitBasic",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                "circuitBasic",
                "itemCasingSteel",
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1),
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                "itemCasingSteel",
                "plateElectricalSteel",
                "itemCasingSteel",
                "plateElectricalSteel",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0),
                "plateElectricalSteel",
                "itemCasingSteel",
                "plateElectricalSteel",
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                "itemCasingSteel",
                "plateElectricalSteel",
                "itemCasingSteel",
                "plateElectricalSteel",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7),
                "plateElectricalSteel",
                "itemCasingSteel",
                "plateElectricalSteel",
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemMachinePart", 1, 2),
                "itemCasingSoularium",
                "plateSoularium",
                "itemCasingSoularium",
                "plateSoularium",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 1),
                "plateSoularium",
                "itemCasingSoularium",
                "plateSoularium",
                "itemCasingSoularium");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemMachinePart", 1, 2),
                "itemCasingSoularium",
                "plateSoularium",
                "itemCasingSoularium",
                "plateSoularium",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 8),
                "plateSoularium",
                "itemCasingSoularium",
                "plateSoularium",
                "itemCasingSoularium");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemMachinePart", 1, 3),
                "itemCasingEndSteel",
                "plateEndSteel",
                "itemCasingEndSteel",
                "plateEndSteel",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2),
                "plateEndSteel",
                "itemCasingEndSteel",
                "plateEndSteel",
                "itemCasingEndSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemMachinePart", 1, 3),
                "itemCasingEndSteel",
                "plateEndSteel",
                "itemCasingEndSteel",
                "plateEndSteel",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9),
                "plateEndSteel",
                "itemCasingEndSteel",
                "plateEndSteel",
                "itemCasingEndSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockVat", 1, 0),
                "itemCasingSteel",
                getModItem(Minecraft.ID, "cauldron", 1, 0),
                "itemCasingSteel",
                getModItem(EnderIO.ID, "blockTank", 1, 0),
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                getModItem(EnderIO.ID, "blockTank", 1, 0),
                ItemList.Electric_Motor_LV.get(1L),
                "craftingBlastFurnace",
                ItemList.Electric_Motor_LV.get(1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockPowerMonitor", 1, 0),
                "plateElectricalSteel",
                NHItemList.Display.get(),
                "plateElectricalSteel",
                "circuitBasic",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                "circuitBasic",
                getModItem(EnderIO.ID, "itemPowerConduit", 1, 0),
                getModItem(EnderIO.ID, "itemConduitProbe", 1, 0),
                getModItem(EnderIO.ID, "itemPowerConduit", 1, 0));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockFarmStation", 1, 0),
                ItemList.Robot_Arm_HV.get(1L),
                "plateDensePulsatingIron",
                ItemList.Robot_Arm_HV.get(1L),
                getModItem(EnderIO.ID, "itemMaterial", 1, 5),
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                getModItem(EnderIO.ID, "itemMaterial", 1, 5),
                "gearElectricalSteel",
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1),
                "gearElectricalSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockWirelessCharger", 1, 0),
                "plateElectricalSteel",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2),
                "plateElectricalSteel",
                "circuitAdvanced",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                "circuitAdvanced",
                ItemList.Electric_Motor_HV.get(1L),
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 3),
                ItemList.Electric_Motor_HV.get(1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockWirelessCharger", 1, 0),
                "plateElectricalSteel",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9),
                "plateElectricalSteel",
                "circuitAdvanced",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                "circuitAdvanced",
                ItemList.Electric_Motor_HV.get(1L),
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 3),
                ItemList.Electric_Motor_HV.get(1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockTank", 1, 0),
                "itemCasingSteel",
                BlockList.SteelBars.get(),
                "itemCasingSteel",
                BlockList.SteelBars.get(),
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.ElectricalSteel, 1L),
                BlockList.SteelBars.get(),
                "itemCasingSteel",
                ItemList.Electric_Pump_LV.get(1L),
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockTank", 1, 1),
                "plateDarkSteel",
                getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0),
                "plateDarkSteel",
                getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.DarkSteel, 1L),
                getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0),
                "plateDarkSteel",
                ItemList.Electric_Pump_MV.get(1L),
                "plateDarkSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockReservoir", 2, 0),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                ItemList.Electric_Pump_HV.get(1L),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                getModItem(Minecraft.ID, "cauldron", 1, 0),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                ItemList.Electric_Pump_HV.get(1L),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockTransceiver", 1, 0),
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 3),
                "circuitMaster",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 3),
                getModItem(EnderIO.ID, "itemMaterial", 1, 8),
                "frameGtEnderium",
                getModItem(EnderIO.ID, "itemMaterial", 1, 8),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockBuffer", 1, 0),
                "plateElectricalSteel",
                "chestWood",
                "plateElectricalSteel",
                ItemList.Conveyor_Module_LV.get(1L),
                "frameGtDarkSteel",
                "circuitBasic");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockBuffer", 1, 1),
                "plateElectricalSteel",
                getModItem(EnderIO.ID, "itemPowerConduit", 1, 0),
                "plateElectricalSteel",
                ItemList.Battery_RE_LV_Sodium.get(1L),
                "frameGtDarkSteel",
                "circuitBasic");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockInventoryPanel", 1, 0),
                "plateDarkSteel",
                getModItem(EnderIO.ID, "itemFunctionUpgrade", 1, 0),
                "plateDarkSteel",
                getModItem(EnderIO.ID, "itemMaterial", 1, 5),
                NHItemList.Display.get(),
                getModItem(EnderIO.ID, "itemMaterial", 1, 5),
                "plateDarkSteel",
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1),
                "plateDarkSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBall", 4, 0),
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
                getModItem(EnderIO.ID, "itemGrindingBall", 4, 1),
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
                getModItem(EnderIO.ID, "itemGrindingBall", 4, 2),
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
                getModItem(EnderIO.ID, "itemGrindingBall", 4, 3),
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
                getModItem(EnderIO.ID, "itemGrindingBall", 4, 4),
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
                getModItem(EnderIO.ID, "itemGrindingBall", 4, 5),
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
                getModItem(EnderIO.ID, "itemGrindingBall", 4, 6),
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
                getModItem(EnderIO.ID, "itemGrindingBall", 4, 7),
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
                getModItem(EnderIO.ID, "itemGrindingBall", 4, 8),
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
                getModItem(EnderIO.ID, "itemGrindingBallEndergy", 4, 0),
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
                getModItem(EnderIO.ID, "itemGrindingBallEndergy", 4, 1),
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
                getModItem(EnderIO.ID, "itemGrindingBallEndergy", 4, 2),
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
                getModItem(EnderIO.ID, "itemGrindingBallEndergy", 4, 3),
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
                getModItem(EnderIO.ID, "itemGrindingBallEndergy", 4, 4),
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
                getModItem(EnderIO.ID, "itemGrindingBallEndergy", 4, 5),
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
                getModItem(EnderIO.ID, "itemGrindingBallEndergy", 4, 6),
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
                getModItem(EnderIO.ID, "blockEnderIo", 1, 0),
                "plateElectricalSteel",
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                "plateElectricalSteel",
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                "lensEnderEye",
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                "plateElectricalSteel",
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                "plateElectricalSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockTravelAnchor", 1, 0),
                "plateElectricalSteel",
                getModItem(OpenBlocks.ID, "elevator", 1, 0),
                "plateElectricalSteel",
                getModItem(EnderIO.ID, "itemMaterial", 1, 5),
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                getModItem(EnderIO.ID, "itemMaterial", 1, 5),
                "plateElectricalSteel",
                ItemList.Field_Generator_LV.get(1L),
                "plateElectricalSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSliceAndSplice", 1, 0),
                "plateSoularium",
                getModItem(Minecraft.ID, "shears", 1, 0),
                "plateSoularium",
                "circuitGood",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                "circuitGood",
                ItemList.Electric_Motor_MV.get(1L),
                getModItem(Minecraft.ID, "iron_axe", 1, 0),
                ItemList.Electric_Motor_MV.get(1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSoulBinder", 1, 0),
                "plateSoularium",
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 3),
                "plateSoularium",
                "circuitAdvanced",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                "circuitAdvanced",
                ItemList.Electric_Motor_HV.get(1L),
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1),
                ItemList.Electric_Motor_HV.get(1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockPoweredSpawner", 1, 0),
                "plateDarkSteel",
                "itemSkull",
                "plateDarkSteel",
                "plateSoularium",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                "plateSoularium",
                getModItem(EnderIO.ID, "itemMaterial", 1, 8),
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 2),
                getModItem(EnderIO.ID, "itemMaterial", 1, 8));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockKillerJoe", 1, 0),
                "itemCasingAluminium",
                "circuitGood",
                "itemCasingAluminium",
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                ItemList.Electric_Motor_MV.get(1L),
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 2),
                ItemList.Electric_Motor_MV.get(1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockAttractor", 1, 0),
                null,
                getModItem(EnderIO.ID, "itemMaterial", 1, 9),
                null,
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                "plateSoularium",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                "plateSoularium",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                "plateSoularium");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSpawnGuard", 1, 0),
                null,
                getModItem(EnderIO.ID, "blockEndermanSkull", 1, 2),
                null,
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                "plateSoularium",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                "plateSoularium",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                "plateSoularium");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockExperienceObelisk", 1, 0),
                null,
                getModItem(EnderIO.ID, "itemXpTransfer", 1, 0),
                null,
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                "plateSoularium",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                "plateSoularium",
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                "plateSoularium");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockWeatherObelisk", 1, 0),
                null,
                getModItem(EnderIO.ID, "itemMaterial", 1, 10),
                null,
                "bucketLava",
                "plateSoularium",
                "bucketWater",
                "plateSoularium",
                getModItem(EnderIO.ID, "blockCapBank", 1, 2),
                "plateSoularium");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockEnchanter", 1, 0),
                getModItem(EnderIO.ID, "itemMaterial", 1, 5),
                "craftingBook",
                getModItem(EnderIO.ID, "itemMaterial", 1, 6),
                null,
                "plateDarkSteel",
                null,
                "plateDarkSteel",
                getModItem(Minecraft.ID, "enchanting_table", 1, 0),
                "plateDarkSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockDarkIronBars", 3, 0),
                null,
                "craftingToolHardHammer",
                null,
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.DarkSteel, 1L),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.DarkSteel, 1L),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.DarkSteel, 1L),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.DarkSteel, 1L),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.DarkSteel, 1L),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.DarkSteel, 1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSoulariumBars", 3, 0),
                null,
                "craftingToolHardHammer",
                null,
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Soularium, 1L),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Soularium, 1L),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Soularium, 1L),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Soularium, 1L),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Soularium, 1L),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Soularium, 1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockEndSteelBars", 3, 0),
                null,
                "craftingToolHardHammer",
                null,
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.EndSteel, 1L),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.EndSteel, 1L),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.EndSteel, 1L),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.EndSteel, 1L),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.EndSteel, 1L),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.EndSteel, 1L));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockDarkSteelLadder", 1, 0),
                getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0),
                "craftingToolScrewdriver",
                getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0),
                "wireFineSteel",
                "screwSteel",
                "wireFineSteel",
                getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0),
                "craftingToolWrench",
                getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0));
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockElectricLight", 8, 0),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                "plateSiliconSolarGrade",
                getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0),
                "plateSiliconSolarGrade",
                "circuitBasic",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0),
                "circuitBasic");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockElectricLight", 8, 0),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                "plateSiliconSolarGrade",
                getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0),
                "plateSiliconSolarGrade",
                "circuitBasic",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7),
                "circuitBasic");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockElectricLight", 16, 2),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0),
                "plateSiliconSolarGrade",
                getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1, 0),
                "plateSiliconSolarGrade",
                "plateIron",
                "wireGt01RedAlloy",
                "plateIron");
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockReinforcedObsidian", 1, 0),
                "plateDarkSteel",
                getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0),
                "plateDarkSteel",
                getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0),
                "blockObsidian",
                getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0),
                "plateDarkSteel",
                getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0),
                "plateDarkSteel");
        addShapedRecipe(
                createItemStack(EnderIO.ID, "itemCoordSelector", 1, 0, "{bc:x:0,default:1b,bc:y:0,bc:z:0}"),
                "plateElectricalSteel",
                "gemEnderEye",
                "plateElectricalSteel",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.PulsatingIron, 1L),
                getModItem(Minecraft.ID, "compass", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.PulsatingIron, 1L),
                "plateElectricalSteel",
                "gemEnderEye",
                "plateElectricalSteel");
        addShapelessRecipe(
                getModItem(EnderIO.ID, "itemExtractSpeedUpgrade", 1, 0),
                getModItem(EnderIO.ID, "itemExtractSpeedUpgrade", 1, 1));
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemFunctionUpgrade", 1, 0),
                "plateSiliconSolarGrade",
                getModItem(EnderIO.ID, "itemMaterial", 1, 1),
                "plateSiliconSolarGrade",
                "circuitAdvanced",
                "gemEnderEye",
                "circuitAdvanced",
                "plateSiliconSolarGrade",
                "plateElectricalSteel",
                "plateSiliconSolarGrade");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemYetaWrench", 1, 0),
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
                getModItem(EnderIO.ID, "itemConduitProbe", 1, 0),
                "plateSiliconSolarGrade",
                getModItem(EnderIO.ID, "itemPowerConduit", 1, 0),
                "plateSiliconSolarGrade",
                "circuitBasic",
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26),
                "circuitBasic",
                "plateElectricalSteel",
                getModItem(EnderIO.ID, "itemRedstoneConduit", 1, 2),
                "plateElectricalSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemTravelStaff", 1, 16),
                "craftingToolScrewdriver",
                "circuitAdvanced",
                getModItem(EnderIO.ID, "itemMaterial", 1, 8),
                "screwVibrantAlloy",
                "stickDarkSteel",
                "circuitAdvanced",
                "stickDarkSteel",
                "screwVibrantAlloy",
                "craftingToolWrench");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemXpTransfer", 1, 0),
                "craftingToolScrewdriver",
                "circuitAdvanced",
                getModItem(EnderIO.ID, "itemMaterial", 1, 5),
                "screwEnergeticAlloy",
                "stickSoularium",
                "circuitAdvanced",
                "stickSoularium",
                "screwEnergeticAlloy",
                "craftingToolWrench");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGliderWing", 1, 0),
                "craftingToolHardHammer",
                "stickDarkSteel",
                "itemLeather",
                "stickDarkSteel",
                getModItem(Backpack.ID, "tannedLeather", 1, 0),
                "itemLeather",
                "itemLeather",
                "itemLeather",
                "itemLeather");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGliderWing", 1, 1),
                "screwDarkSteel",
                "stickDarkSteel",
                "screwDarkSteel",
                getModItem(EnderIO.ID, "itemGliderWing", 1, 0),
                "plateDarkSteel",
                getModItem(EnderIO.ID, "itemGliderWing", 1, 0),
                "craftingToolWrench",
                "stickDarkSteel",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemMagnet", 1, 16),
                "plateElectricalSteel",
                "plateConductiveIron",
                "plateConductiveIron",
                "craftingToolWrench",
                "screwSteelMagnetic",
                getModItem(EnderIO.ID, "itemMaterial", 1, 6),
                "plateElectricalSteel",
                "plateConductiveIron",
                "plateConductiveIron");
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.endSteel_helmet", 1, 0),
                "plateEndSteel",
                "plateEndSteel",
                "plateEndSteel",
                "plateEndSteel",
                "craftingToolHardHammer",
                "plateEndSteel",
                null,
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 6),
                null);
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.endSteel_chestplate", 1, 0),
                "plateEndSteel",
                "craftingToolHardHammer",
                "plateEndSteel",
                "plateEndSteel",
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 6),
                "plateEndSteel",
                "plateEndSteel",
                "plateEndSteel",
                "plateEndSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.endSteel_leggings", 1, 0),
                "plateEndSteel",
                "plateEndSteel",
                "plateEndSteel",
                "plateEndSteel",
                "craftingToolHardHammer",
                "plateEndSteel",
                "plateEndSteel",
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 6),
                "plateEndSteel");
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.endSteel_boots", 1, 0),
                "plateEndSteel",
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 6),
                "plateEndSteel",
                "plateEndSteel",
                "craftingToolHardHammer",
                "plateEndSteel",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.stellar_helmet", 1, 0),
                "plateStellarAlloy",
                "plateStellarAlloy",
                "plateStellarAlloy",
                "plateStellarAlloy",
                "craftingToolHardHammer",
                "plateStellarAlloy",
                null,
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4),
                null);
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.stellar_chestplate", 1, 0),
                "plateStellarAlloy",
                "craftingToolHardHammer",
                "plateStellarAlloy",
                "plateStellarAlloy",
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4),
                "plateStellarAlloy",
                "plateStellarAlloy",
                "plateStellarAlloy",
                "plateStellarAlloy");
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.stellar_leggings", 1, 0),
                "plateStellarAlloy",
                "plateStellarAlloy",
                "plateStellarAlloy",
                "plateStellarAlloy",
                "craftingToolHardHammer",
                "plateStellarAlloy",
                "plateStellarAlloy",
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4),
                "plateStellarAlloy");
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.stellar_boots", 1, 0),
                "plateStellarAlloy",
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4),
                "plateStellarAlloy",
                "plateStellarAlloy",
                "craftingToolHardHammer",
                "plateStellarAlloy",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.endSteel_pickaxe", 1, 0),
                "plateEndSteel",
                "ingotEndSteel",
                "ingotEndSteel",
                "craftingToolFile",
                getModItem(EnderIO.ID, "itemMaterial", 1, 12),
                "craftingToolHardHammer",
                null,
                getModItem(EnderIO.ID, "itemMaterial", 1, 12),
                null);
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.endSteel_axe", 1, 0),
                "plateEndSteel",
                "ingotEndSteel",
                "craftingToolHardHammer",
                "plateEndSteel",
                getModItem(EnderIO.ID, "itemMaterial", 1, 12),
                "plateEndSteel",
                "craftingToolFile",
                getModItem(EnderIO.ID, "itemMaterial", 1, 12),
                null);
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.endSteel_sword", 1, 0),
                null,
                "plateEndSteel",
                null,
                "craftingToolFile",
                "plateEndSteel",
                "craftingToolHardHammer",
                null,
                getModItem(EnderIO.ID, "itemMaterial", 1, 12),
                null);
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.stellar_pickaxe", 1, 0),
                "plateStellarAlloy",
                "ingotStellarAlloy",
                "ingotStellarAlloy",
                "craftingToolFile",
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4),
                "craftingToolHardHammer",
                null,
                getModItem(EnderIO.ID, "itemMaterial", 1, 12),
                null);
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.stellar_axe", 1, 0),
                "plateStellarAlloy",
                "ingotStellarAlloy",
                "craftingToolHardHammer",
                "plateStellarAlloy",
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4),
                "plateStellarAlloy",
                "craftingToolFile",
                getModItem(EnderIO.ID, "itemMaterial", 1, 12),
                null);
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.stellar_sword", 1, 0),
                null,
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4),
                null,
                "craftingToolFile",
                "plateStellarAlloy",
                "craftingToolHardHammer",
                null,
                getModItem(EnderIO.ID, "itemMaterial", 1, 12),
                null);
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemMaterial", 1, 12),
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
                getModItem(EnderIO.ID, "item.darkSteel_shears", 1, 0),
                "plateDarkSteel",
                "screwDarkSteel",
                "plateDarkSteel",
                "craftingToolHardHammer",
                "ringDarkSteel",
                "craftingToolFile",
                "stickWood",
                "craftingToolScrewdriver",
                "stickWood");

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Automation_ChestBuffer_LV.get(1L),
                        getModItem(ExtraUtilities.ID, "enderCollector", 1, 0))
                .itemOutputs(getModItem(EnderIO.ID, "blockVacuumChest", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(EnderIO.ID, "blockBuffer", 1, 0), getModItem(EnderIO.ID, "blockBuffer", 1, 1))
                .itemOutputs(getModItem(EnderIO.ID, "blockBuffer", 1, 2)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "diamond", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.nugget, Materials.PulsatingIron, 8L))
                .itemOutputs(getModItem(EnderIO.ID, "itemMaterial", 1, 5)).duration(30 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "emerald", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.nugget, Materials.VibrantAlloy, 8L))
                .itemOutputs(getModItem(EnderIO.ID, "itemMaterial", 1, 6)).duration(30 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.ElectricalSteel, 1L))
                .circuit(5).itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L))
                .circuit(5).itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L))
                .circuit(5).itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 2)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.RedstoneAlloy, 1L))
                .circuit(5).itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 3)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.ConductiveIron, 1L))
                .circuit(5).itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 4)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.PulsatingIron, 1L))
                .circuit(5).itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 5)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.DarkSteel, 1L))
                .circuit(5).itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 6)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.Soularium, 1L))
                .circuit(5).itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 7)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.EndSteel, 1L))
                .circuit(5).itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 8)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.ClayCompound, 1L))
                .circuit(5).itemOutputs(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.CrystallineAlloy, 1L))
                .circuit(5).itemOutputs(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.MelodicAlloy, 1L))
                .circuit(5).itemOutputs(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 2)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.StellarAlloy, 1L))
                .circuit(5).itemOutputs(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 3)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.CrystallinePinkSlime, 1L)).circuit(5)
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 4)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticSilver, 1L))
                .circuit(5).itemOutputs(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 5)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.VividAlloy, 1L))
                .circuit(5).itemOutputs(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 6)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.ManyullynCrystal.get(),
                        GTOreDictUnificator.get(OrePrefixes.nugget, Materials.Enderium, 8L))
                .itemOutputs(getModItem(EnderIO.ID, "itemMaterial", 1, 10)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.DarkSteel, 2L))
                .itemOutputs(getModItem(EnderIO.ID, "blockDarkSteelPressurePlate", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "blockDarkSteelPressurePlate", 1, 0),
                        getModItem(IndustrialCraft2.ID, "blockRubber", 1, 0))
                .itemOutputs(getModItem(EnderIO.ID, "blockDarkSteelPressurePlate", 1, 1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0)).circuit(2)
                .itemOutputs(getModItem(EnderIO.ID, "blockDarkSteelLadder", 2, 0)).duration(5 * SECONDS).eut(96)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.stick, Materials.DarkSteel, 3L))
                .circuit(3).itemOutputs(getModItem(EnderIO.ID, "blockDarkIronBars", 4, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.stick, Materials.EndSteel, 3L))
                .circuit(3).itemOutputs(getModItem(EnderIO.ID, "blockEndSteelBars", 4, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "blockElectricLight", 1, 0),
                        getModItem(Minecraft.ID, "redstone_torch", 1, 0))
                .itemOutputs(getModItem(EnderIO.ID, "blockElectricLight", 1, 1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "blockElectricLight", 1, 2),
                        getModItem(Minecraft.ID, "redstone_torch", 1, 0))
                .itemOutputs(getModItem(EnderIO.ID, "blockElectricLight", 1, 3)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "blockElectricLight", 16, 0),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 3))
                .itemOutputs(getModItem(EnderIO.ID, "blockElectricLight", 16, 4)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "blockElectricLight", 1, 4),
                        getModItem(Minecraft.ID, "redstone_torch", 1, 0))
                .itemOutputs(getModItem(EnderIO.ID, "blockElectricLight", 1, 5)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 1L),
                        getModItem(EnderIO.ID, "itemMaterial", 4, 1))
                .itemOutputs(getModItem(EnderIO.ID, "itemFusedQuartzFrame", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "itemMaterial", 8, 1)).circuit(8)
                .itemOutputs(getModItem(EnderIO.ID, "itemConduitFacade", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemRedstoneConduit", 1, 0),
                        getModItem(EnderIO.ID, "itemMaterial", 2, 1))
                .itemOutputs(getModItem(EnderIO.ID, "itemRedstoneConduit", 1, 2)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemRedstoneConduit", 1, 2),
                        getModItem(Minecraft.ID, "lever", 1, 0))
                .itemOutputs(getModItem(EnderIO.ID, "itemRedstoneConduit", 1, 1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RedstoneAlloy, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemRedstoneConduit", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Gold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.ConductiveIron, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduit", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Aluminium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduit", 1, 1))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Osmium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduit", 1, 2))
                .fluidInputs(FluidRegistry.getFluidStack("molten.epoxid", 144)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.ClayCompound, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Zinc, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 1))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SolderingAlloy, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 2))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Nickel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 3))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 144)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 4))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 144)).duration(5 * SECONDS).eut(96)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Electrum, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Silver, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 5))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).duration(5 * SECONDS).eut(160)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.BlackSteel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Electrum, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 6))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).duration(5 * SECONDS).eut(192)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.TungstenSteel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticSilver, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 7))
                .fluidInputs(FluidRegistry.getFluidStack("molten.epoxid", 144)).duration(5 * SECONDS).eut(320)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.HSSG, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.CrystallineAlloy, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 8))
                .fluidInputs(FluidRegistry.getFluidStack("molten.epoxid", 144)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_EV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.NiobiumTitanium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.CrystallinePinkSlime, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 9))
                .fluidInputs(FluidRegistry.getFluidStack("molten.polytetrafluoroethylene", 144)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Naquadah, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.MelodicAlloy, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 10))
                .fluidInputs(FluidRegistry.getFluidStack("molten.polytetrafluoroethylene", 144)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.BlackPlutonium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.StellarAlloy, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 11))
                .fluidInputs(FluidRegistry.getFluidStack("molten.polybenzimidazole", 144)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Copper, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.ElectricalSteel, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.DarkSteel, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 1))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Polytetrafluoroethylene, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 2))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Polytetrafluoroethylene, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.CrystallineAlloy, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 3))
                .fluidInputs(FluidRegistry.getFluidStack("molten.epoxid", 144)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_EV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Polytetrafluoroethylene, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.CrystallinePinkSlime, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 4))
                .fluidInputs(FluidRegistry.getFluidStack("molten.polytetrafluoroethylene", 144)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Polybenzimidazole, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.MelodicAlloy, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 5))
                .fluidInputs(FluidRegistry.getFluidStack("molten.polytetrafluoroethylene", 144)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Polybenzimidazole, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.StellarAlloy, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 6))
                .fluidInputs(FluidRegistry.getFluidStack("molten.polybenzimidazole", 144)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Electrum, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.PulsatingIron, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemItemConduit", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RedstoneAlloy, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemOCConduit", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Component_Filter.get(1L), getModItem(Minecraft.ID, "iron_bars", 1, 0))
                .itemOutputs(getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 1, 0),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1))
                .itemOutputs(getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 1, 1)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 1, 1),
                        getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26))
                .itemOutputs(getModItem(EnderIO.ID, "itemLimitedItemFilter", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 2, 1),
                        getModItem(EnderIO.ID, "blockEndSteelBars", 2, 0))
                .itemOutputs(getModItem(EnderIO.ID, "itemBigFilterUpgrade", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBigFilterUpgrade", 1, 0),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 2))
                .itemOutputs(getModItem(EnderIO.ID, "itemBigFilterUpgrade", 1, 1)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 1, 1),
                        getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 20))
                .itemOutputs(getModItem(EnderIO.ID, "itemExistingItemFilter", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 1, 0),
                        getModItem(EnderIO.ID, "itemYetaWrench", 1, 0))
                .itemOutputs(getModItem(EnderIO.ID, "itemModItemFilter", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 1, 0),
                        getModItem(EnderIO.ID, "itemConduitProbe", 1, 0))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerItemFilter", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 1, 0), ItemList.Electric_Piston_LV.get(1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemExtractSpeedUpgrade", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "itemExtractSpeedUpgrade", 1, 0)).circuit(1)
                .itemOutputs(getModItem(EnderIO.ID, "itemExtractSpeedUpgrade", 1, 1))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 144)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "itemExtractSpeedUpgrade", 1, 0)).circuit(1)
                .itemOutputs(getModItem(EnderIO.ID, "itemExtractSpeedUpgrade", 1, 1))
                .fluidInputs(Materials.RubberSilicone.getMolten(144)).duration(15 * SECONDS).eut(TierEU.RECIPE_MV / 2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "itemExtractSpeedUpgrade", 1, 0)).circuit(1)
                .itemOutputs(getModItem(EnderIO.ID, "itemExtractSpeedUpgrade", 1, 1))
                .fluidInputs(Materials.StyreneButadieneRubber.getMolten(144)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "blockFusedQuartz", 3, 0),
                        GTOreDictUnificator.get(OrePrefixes.round, Materials.Soularium, 1L))
                .itemOutputs(getModItem(EnderIO.ID, "itemSoulVessel", 1, 0)).duration(10 * SECONDS).eut(48)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1),
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.Steel, 2L))
                .itemOutputs(getModItem(EnderIO.ID, "blockCrafter", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.ElectricalSteel, 2L),
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.Steel, 2L))
                .itemOutputs(getModItem(EnderIO.ID, "itemMachinePart", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.ElectricalSteel, 2L),
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.Steel, 2L))
                .itemOutputs(getModItem(EnderIO.ID, "itemMachinePart", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "obsidian", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.DarkSteel, 2L),
                        getModItem(EnderIO.ID, "blockDarkIronBars", 2, 0))
                .circuit(17).itemOutputs(getModItem(EnderIO.ID, "blockReinforcedObsidian", 1, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Anvil.get(0L))
                .itemOutputs(getModItem(EnderIO.ID, "blockDarkSteelAnvil", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.darksteel", 4464)).duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemPartCFPowder", 1, 0))
                .itemOutputs(getModItem(EnderIO.ID, "itemMaterial", 9, 2)).outputChances(10000).duration(15 * SECONDS)
                .eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "itemMaterial", 1, 5))
                .itemOutputs(getModItem(EnderIO.ID, "itemMaterial", 1, 14)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "itemMaterial", 1, 6))
                .itemOutputs(getModItem(EnderIO.ID, "itemMaterial", 1, 15)).duration(15 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "itemMaterial", 1, 8))
                .itemOutputs(getModItem(EnderIO.ID, "itemMaterial", 1, 16)).duration(15 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "itemMaterial", 1, 13))
                .itemOutputs(getModItem(EnderIO.ID, "itemMaterial", 1, 17)).duration(15 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(maceratorRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(HardcoreEnderExpansion.ID, "enderman_head", 1, 0),
                        getModItem(MagicBees.ID, "wax", 4, 1))
                .itemOutputs(getModItem(EnderIO.ID, "blockEndermanSkull", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 1000)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(UniversalChemical);

        // Vibrant Capacitor Bank
        ItemStack vibrantCapacitor = createItemStack(
                EnderIO.ID,
                "blockCapBank",
                1,
                3,
                "{type:\"VIBRANT\",storedEnergyRF:0}");

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                        getModItem(EnderIO.ID, "itemMaterial", 2, 6),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 4, 2),
                        ItemList.BatteryHull_EV_Full.get(1))
                .itemOutputs(vibrantCapacitor.copy()).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                        getModItem(EnderIO.ID, "itemMaterial", 2, 6),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 4, 9),
                        ItemList.BatteryHull_EV_Full.get(1))
                .itemOutputs(vibrantCapacitor.copy()).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                        getModItem(EnderIO.ID, "itemMaterial", 2, 6),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 4, 2),
                        GregtechItemList.Battery_RE_EV_Lithium.get(1))
                .itemOutputs(vibrantCapacitor.copy()).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0),
                        getModItem(EnderIO.ID, "itemMaterial", 2, 6),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 4, 9),
                        GregtechItemList.Battery_RE_EV_Lithium.get(1))
                .itemOutputs(vibrantCapacitor.copy()).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // Binder Composite

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, 14),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 7),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 7),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 7))
                .circuit(3).itemOutputs(getModItem(EnderIO.ID, "itemMaterial", 63, 2)).duration(7 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(mixerRecipes);
        // Bulk crystals

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.gem, Materials.Diamond, 64))
                .itemOutputs(getModItem(EnderIO.ID, "itemMaterial", 64, 5))
                .fluidInputs(Materials.PulsatingIron.getMolten(8192)).duration(2 * MINUTES).eut(TierEU.RECIPE_IV)
                .addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.gem, Materials.Emerald, 64))
                .itemOutputs(getModItem(EnderIO.ID, "itemMaterial", 64, 6))
                .fluidInputs(Materials.VibrantAlloy.getMolten(8192)).duration(2 * MINUTES).eut(TierEU.RECIPE_IV)
                .addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ManyullynCrystal.get(16))
                .itemOutputs(getModItem(EnderIO.ID, "itemMaterial", 16, 10))
                .fluidInputs(Materials.Enderium.getMolten(2048)).duration(1 * MINUTES).eut(TierEU.RECIPE_IV / 2)
                .addTo(autoclaveRecipes);

        // Soul Infused Medium

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Soularium, 1),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Emerald, 1),
                        getModItem(EnderIO.ID, "blockEndermanSkull", 1, 0),
                        getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0),
                        getModItem(Witchery.ID, "witchhand", 1, 0))
                .itemOutputs(getModItem(BiomesOPlenty.ID, "misc", 4, 3))
                .fluidInputs(
                        FluidRegistry.getFluidStack("xpjuice", 1728),
                        FluidRegistry.getFluidStack("hell_blood", 100),
                        FluidRegistry.getFluidStack("putrescine", 250),
                        FluidRegistry.getFluidStack("binnie.growthmedium", 100),
                        FluidRegistry.getFluidStack("vapor_of_levity", 500),
                        FluidRegistry.getFluidStack("cadaverine", 250))
                .fluidOutputs(Materials.SoulInfusedMedium.getFluid(2880)).duration(30 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(multiblockChemicalReactorRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(GregtechItemList.RawHumanMeat.get(1), getModItem(RandomThings.ID, "ingredient", 1, 0))
                .itemOutputs(getModItem(EnderIO.ID, "itemMaterial", 1, 9))
                .fluidInputs(Materials.SoulInfusedMedium.getFluid(144 * 20)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 1),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 6))
                .itemOutputs(getModItem(EnderIO.ID, "itemMaterial", 1, 8))
                .fluidInputs(Materials.SoulInfusedMedium.getFluid(144 * 20)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 1),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 5))
                .itemOutputs(getModItem(EnderIO.ID, "itemMaterial", 1, 13))
                .fluidInputs(Materials.SoulInfusedMedium.getFluid(144 * 10)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.rotten_flesh, 1), getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1))
                .itemOutputs(getModItem(EnderIO.ID, "itemFrankenSkull", 1, 2))
                .fluidInputs(Materials.SoulInfusedMedium.getFluid(144 * 10)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.fermented_spider_eye, 1),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 3))
                .itemOutputs(getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4))
                .fluidInputs(Materials.SoulInfusedMedium.getFluid(144 * 10)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 1),
                        new ItemStack(Blocks.detector_rail, 1))
                .itemOutputs(getModItem(EnderIO.ID, "blockEnderRail", 1, 0))
                .fluidInputs(Materials.SoulInfusedMedium.getFluid(144 * 15)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 6),
                        getModItem(EnderIO.ID, "itemMaterial", 8, 9),
                        getModItem(EtFuturumRequiem.ID, "totem_of_undying", 1, 0),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 2),
                        new ItemStack(Blocks.dragon_egg, 1),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4))
                .itemOutputs(createItemStack(EnderIO.ID, "itemBasicCapacitor", 1, 6, "{ench:[0:{id:32s,lvl:5s}]}"))
                .fluidInputs(Materials.SoulInfusedMedium.getFluid(144 * 40)).requiresCleanRoom().duration(40 * SECONDS)
                .eut(TierEU.RECIPE_ZPM).addTo(circuitAssemblerRecipes);

    }
}
