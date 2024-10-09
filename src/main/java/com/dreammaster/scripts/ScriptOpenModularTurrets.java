package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.EnderStorage;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronChests;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.OpenModularTurrets;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.mixerRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;

public class ScriptOpenModularTurrets implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Open Modular Turrets";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                OpenModularTurrets.ID,
                EnderIO.ID,
                EnderStorage.ID,
                IndustrialCraft2.ID,
                IronChests.ID,
                OpenComputers.ID,
                Thaumcraft.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "baseTierWood", 1, 0, missing),
                "plateIron",
                "stoneCobble",
                "plateIron",
                "plankWood",
                getModItem(OpenModularTurrets.ID, "sensorTierOneItem", 1, 0, missing),
                "plankWood",
                "plateIron",
                "stoneCobble",
                "plateIron");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "baseTierOneBlock", 1, 0, missing),
                "plateSteel",
                ItemList.Battery_Hull_MV.get(1L),
                "plateSteel",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                getModItem(OpenModularTurrets.ID, "sensorTierTwoItem", 1, 0, missing),
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                "plateSteel",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing),
                "plateSteel");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "baseTierTwoBlock", 1, 0, missing),
                "plateDarkSteel",
                createItemStack(EnderIO.ID, "blockCapBank", 1, 1, "{type:\"SIMPLE\",storedEnergyRF:0}", missing),
                "plateDarkSteel",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                getModItem(OpenModularTurrets.ID, "sensorTierThreeItem", 1, 0, missing),
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                "plateDarkSteel",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing),
                "plateDarkSteel");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "baseTierThreeBlock", 1, 0, missing),
                "plateEnergeticAlloy",
                createItemStack(EnderIO.ID, "blockCapBank", 1, 2, "{type:\"ACTIVATED\",storedEnergyRF:0}", missing),
                "plateEnergeticAlloy",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                getModItem(OpenModularTurrets.ID, "sensorTierFourItem", 1, 0, missing),
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                "plateEnergeticAlloy",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 1, missing),
                "plateEnergeticAlloy");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "baseTierFourBlock", 1, 0, missing),
                "plateVibrantAlloy",
                createItemStack(EnderIO.ID, "blockCapBank", 1, 3, "{type:\"VIBRANT\",storedEnergyRF:0}", missing),
                "plateVibrantAlloy",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                getModItem(OpenModularTurrets.ID, "sensorTierFiveItem", 1, 0, missing),
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                "plateVibrantAlloy",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2, missing),
                "plateVibrantAlloy");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "sensorTierOneItem", 1, 0, missing),
                "plateBronze",
                "dustRedstone",
                "plateBronze",
                "craftingRedstoneTorch",
                "plateIron",
                "craftingRedstoneTorch",
                "plateBronze",
                "dustRedstone",
                "plateBronze");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "sensorTierTwoItem", 1, 0, missing),
                "plateSteel",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                "plateSteel",
                "circuitBasic",
                getModItem(OpenModularTurrets.ID, "sensorTierOneItem", 1, 0, missing),
                "circuitBasic",
                "plateSteel",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                "plateSteel");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "sensorTierThreeItem", 1, 0, missing),
                "plateDarkSteel",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                "plateDarkSteel",
                "circuitGood",
                getModItem(OpenModularTurrets.ID, "sensorTierTwoItem", 1, 0, missing),
                "circuitGood",
                "plateDarkSteel",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                "plateDarkSteel");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "sensorTierFourItem", 1, 0, missing),
                "plateEnergeticAlloy",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                "plateEnergeticAlloy",
                "circuitAdvanced",
                getModItem(OpenModularTurrets.ID, "sensorTierThreeItem", 1, 0, missing),
                "circuitAdvanced",
                "plateEnergeticAlloy",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                "plateEnergeticAlloy");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "sensorTierFiveItem", 1, 0, missing),
                "plateVibrantAlloy",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                "plateVibrantAlloy",
                "circuitMaster",
                getModItem(OpenModularTurrets.ID, "sensorTierFourItem", 1, 0, missing),
                "circuitMaster",
                "plateVibrantAlloy",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                "plateVibrantAlloy");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "chamberTierOne", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "screwIron",
                "springIron",
                "screwIron",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "craftingPiston",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L));
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "barrelTierOne", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "ringIron",
                "craftingToolWrench",
                "ringIron",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L));
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "disposeItemTurret", 1, 0, missing),
                "craftingToolWrench",
                getModItem(OpenModularTurrets.ID, "barrelTierOne", 1, 0, missing),
                "craftingToolHardHammer",
                "plateIron",
                getModItem(OpenModularTurrets.ID, "chamberTierOne", 1, 0, missing),
                "plateIron",
                "stoneCobble",
                "craftingRedstoneTorch",
                "stoneCobble");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "potatoCannonTurret", 1, 0, missing),
                "craftingToolWrench",
                getModItem(OpenModularTurrets.ID, "barrelTierOne", 1, 0, missing),
                "craftingToolHardHammer",
                "plateIron",
                getModItem(OpenModularTurrets.ID, "barrelTierOne", 1, 0, missing),
                "plateIron",
                "craftingRedstoneTorch",
                getModItem(OpenModularTurrets.ID, "chamberTierOne", 1, 0, missing),
                "craftingRedstoneTorch");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "machineGunTurret", 1, 0, missing),
                "craftingToolWrench",
                getModItem(OpenModularTurrets.ID, "barrelTierTwo", 1, 0, missing),
                "craftingToolHardHammer",
                "plateSteel",
                getModItem(OpenModularTurrets.ID, "barrelTierTwo", 1, 0, missing),
                "plateSteel",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                getModItem(OpenModularTurrets.ID, "chamberTierTwo", 1, 0, missing),
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing));
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "incendiaryTurret", 1, 0, missing),
                getModItem(OpenModularTurrets.ID, "barrelTierTwo", 1, 0, missing),
                "craftingToolHardHammer",
                getModItem(OpenModularTurrets.ID, "barrelTierTwo", 1, 0, missing),
                getModItem(OpenModularTurrets.ID, "chamberTierOne", 1, 0, missing),
                "plateSteel",
                getModItem(OpenModularTurrets.ID, "chamberTierOne", 1, 0, missing),
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                "plateSteel",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing));
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "grenadeTurret", 1, 0, missing),
                "craftingToolWrench",
                getModItem(OpenModularTurrets.ID, "barrelTierThree", 1, 0, missing),
                "craftingToolHardHammer",
                "plateDarkSteel",
                getModItem(OpenModularTurrets.ID, "chamberTierThree", 1, 0, missing),
                "plateDarkSteel",
                "plateDarkSteel",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                "plateDarkSteel");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "relativisticTurret", 1, 0, missing),
                "plateDarkSteel",
                getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing),
                "plateDarkSteel",
                getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing),
                getModItem(OpenModularTurrets.ID, "sensorTierThreeItem", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing),
                "plateDarkSteel",
                "plateEnderiumBase",
                "plateDarkSteel");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "grenadeTurret", 1, 0, missing),
                "craftingToolWrench",
                getModItem(OpenModularTurrets.ID, "barrelTierThree", 1, 0, missing),
                "craftingToolHardHammer",
                "plateDarkSteel",
                getModItem(OpenModularTurrets.ID, "chamberTierThree", 1, 0, missing),
                "plateDarkSteel",
                "plateDarkSteel",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                "plateDarkSteel");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "rocketTurret", 1, 0, missing),
                "plateEnergeticAlloy",
                getModItem(OpenModularTurrets.ID, "barrelTierFour", 1, 0, missing),
                "plateEnergeticAlloy",
                getModItem(OpenModularTurrets.ID, "chamberTierFour", 1, 0, missing),
                getModItem(OpenModularTurrets.ID, "barrelTierFour", 1, 0, missing),
                getModItem(OpenModularTurrets.ID, "chamberTierFour", 1, 0, missing),
                "plateEnergeticAlloy",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                "plateEnergeticAlloy");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "teleporterTurret", 1, 0, missing),
                "craftingToolWrench",
                getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 0, missing),
                "craftingToolHardHammer",
                getModItem(EnderIO.ID, "itemMaterial", 1, 8, missing),
                getModItem(OpenModularTurrets.ID, "sensorTierFourItem", 1, 0, missing),
                getModItem(EnderIO.ID, "itemMaterial", 1, 8, missing),
                "plateEnergeticAlloy",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                "plateEnergeticAlloy");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "railGunTurret", 1, 0, missing),
                "craftingToolWrench",
                getModItem(OpenModularTurrets.ID, "barrelTierFive", 1, 0, missing),
                "craftingToolHardHammer",
                "plateVibrantAlloy",
                getModItem(OpenModularTurrets.ID, "barrelTierFive", 1, 0, missing),
                "plateVibrantAlloy",
                "plateVibrantAlloy",
                getModItem(OpenModularTurrets.ID, "chamberTierFive", 1, 0, missing),
                "plateVibrantAlloy");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "laserTurret", 1, 0, missing),
                "craftingToolWrench",
                getModItem(OpenModularTurrets.ID, "barrelTierFive", 1, 0, missing),
                "craftingToolHardHammer",
                "itemVibrantCrystal",
                getModItem(OpenModularTurrets.ID, "chamberTierFive", 1, 0, missing),
                "itemVibrantCrystal",
                "plateEnergeticAlloy",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                "plateEnergeticAlloy");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "hardWallTierOne", 9, 0, missing),
                "stoneSmooth",
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                "stoneSmooth",
                getModItem(Minecraft.ID, "clay", 1, 0, missing),
                "sand",
                getModItem(Minecraft.ID, "clay", 1, 0, missing),
                "stoneSmooth",
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                "stoneSmooth");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "fenceTierOne", 5, 0, missing),
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                "ringSteel",
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                "screwSteel",
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                "screwSteel",
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                "ringSteel",
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing));
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                "screwIron",
                "plateGold",
                "craftingToolWrench",
                "circuitBasic",
                "dustRedstone",
                "circuitBasic",
                "craftingToolScrewdriver",
                "plateIron",
                "screwIron");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "expanderPowerTierOne", 1, 0, missing),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 1L),
                ItemList.Battery_Hull_LV.get(1L),
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 1L),
                "screwIron",
                "craftingToolFile",
                "screwIron");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "expanderInvTierOne", 1, 0, missing),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 1L),
                "chestWood",
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 1L),
                "screwIron",
                "craftingToolFile",
                "screwIron");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "leverBlock", 1, 0, missing),
                "rodStone",
                "rodStone",
                "rodStone",
                null,
                null,
                "rodStone");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "bulletCraftable", 64, 0, missing),
                "foilSteel",
                "ringIron",
                "foilSteel",
                "plateIron",
                "dustGunpowder",
                "plateIron",
                "foilSteel",
                "boltIron",
                "foilSteel");

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "fenceTierOne", 4, 0, missing)).duration(5 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.SteelBars.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Aluminium, 1L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "fenceTierTwo", 4, 0, missing)).duration(5 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.StainlessSteel, 1L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "fenceTierThree", 4, 0, missing)).duration(5 * SECONDS)
                .eut(64).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.TungstenSteelBars.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Titanium, 1L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "fenceTierFour", 4, 0, missing)).duration(5 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.IridiumBars.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.TungstenSteel, 1L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "fenceTierFive", 4, 0, missing)).duration(5 * SECONDS)
                .eut(256).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 1L),
                        ItemList.Battery_Hull_LV.get(1L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderPowerTierOne", 1, 0, missing))
                .duration(20 * SECONDS).eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.ElectricalSteel, 1L),
                        ItemList.Battery_Hull_MV.get(1L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderPowerTierTwo", 1, 0, missing))
                .duration(20 * SECONDS).eut(30).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.DarkSteel, 1L),
                        ItemList.Battery_Hull_HV.get(1L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderPowerTierThree", 1, 0, missing))
                .duration(20 * SECONDS).eut(64).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.EnergeticAlloy, 1L),
                        ItemList.BatteryHull_EV.get(1))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderPowerTierFour", 1, 0, missing))
                .duration(20 * SECONDS).eut(120).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.VibrantAlloy, 1L),
                        ItemList.BatteryHull_IV.get(1))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderPowerTierFive", 1, 0, missing))
                .duration(20 * SECONDS).eut(256).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 1L),
                        getModItem(Minecraft.ID, "chest", 1, 0, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderInvTierOne", 1, 0, missing))
                .duration(20 * SECONDS).eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.ElectricalSteel, 1L),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 0, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderInvTierTwo", 1, 0, missing))
                .duration(20 * SECONDS).eut(30).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.DarkSteel, 1L),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 4, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderInvTierThree", 1, 0, missing))
                .duration(20 * SECONDS).eut(64).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.EnergeticAlloy, 1L),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 2, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderInvTierFour", 1, 0, missing))
                .duration(20 * SECONDS).eut(120).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.VibrantAlloy, 1L),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 5, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderInvTierFive", 1, 0, missing))
                .duration(20 * SECONDS).eut(256).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 4L),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 2L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "barrelTierOne", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 2L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "barrelTierTwo", 1, 0, missing)).duration(10 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.DarkSteel, 4L),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.StainlessSteel, 2L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "barrelTierThree", 1, 0, missing)).duration(10 * SECONDS)
                .eut(64).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 4L),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.TungstenSteel, 2L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "barrelTierFour", 1, 0, missing)).duration(10 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 4L),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iridium, 2L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "barrelTierFive", 1, 0, missing)).duration(10 * SECONDS)
                .eut(256).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "piston", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.Iron, 1L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "chamberTierOne", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Piston_LV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.Steel, 1L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "chamberTierTwo", 1, 0, missing)).duration(10 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Piston_MV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.StainlessSteel, 1L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "chamberTierThree", 1, 0, missing))
                .duration(10 * SECONDS).eut(64).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Piston_HV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.TungstenSteel, 1L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "chamberTierFour", 1, 0, missing)).duration(10 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Piston_EV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.Iridium, 1L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "chamberTierFive", 1, 0, missing)).duration(10 * SECONDS)
                .eut(256).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 2),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 72)).duration(5 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Steel, 4L),
                        getModItem(Minecraft.ID, "gunpowder", 1, 0, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "bulletCraftable", 64, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 144)).duration(10 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 2L),
                        getModItem(Minecraft.ID, "tnt", 1, 0, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "grenadeCraftable", 32, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 144)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.ElectricalSteel, 4L),
                        getModItem(IndustrialCraft2.ID, "blockITNT", 3, 0, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "rocketCraftable", 24, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.stainlesssteel", 144)).duration(10 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.DarkSteel, 2L),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.NeodymiumMagnetic, 1L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "ferroSlug", 16, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tungstensteel", 144)).duration(10 * SECONDS).eut(256)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.ElectricalSteel, 1L),
                        CustomItemList.ReinforcedGlassLense.get(1L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "accuraccyUpgradeItem", 1, 0, missing))
                .duration(5 * SECONDS).eut(120).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.ElectricalSteel, 1L),
                        getModItem(Minecraft.ID, "magma_cream", 1, 0, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "fireRateUpgradeItem", 1, 0, missing))
                .duration(5 * SECONDS).eut(120).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.ElectricalSteel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.springSmall, Materials.StainlessSteel, 1L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "rangeUpgradeItem", 1, 0, missing)).duration(5 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.ElectricalSteel, 1L),
                        CustomItemList.StainlessSteelBars.get(1L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "scattershotUpgradeItem", 1, 0, missing))
                .duration(5 * SECONDS).eut(120).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.ElectricalSteel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Steel, 2L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "efficiencyUpgradeItem", 1, 0, missing))
                .duration(5 * SECONDS).eut(120).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.ElectricalSteel, 1L),
                        getModItem(Minecraft.ID, "ender_eye", 2, 0, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "damageAmpAddon", 1, 0, missing)).duration(5 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.ElectricalSteel, 1L),
                        getModItem(EnderIO.ID, "blockSolarPanel", 1, 0, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "solarPanelAddon", 1, 0, missing)).duration(5 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.ElectricalSteel, 1L),
                        getModItem(OpenComputers.ID, "item", 4, 24, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "serialPortAddon", 1, 0, missing)).duration(5 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.ElectricalSteel, 1L),
                        ItemList.Electric_Piston_MV.get(1L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "concealerAddon", 1, 0, missing)).duration(5 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.ElectricalSteel, 1L),
                        getModItem(EnderStorage.ID, "enderChest", 1, 0, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "recyclerAddon", 1, 0, missing)).duration(5 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.ElectricalSteel, 1L),
                        getModItem(Thaumcraft.ID, "blockTube", 4, 0, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "potentiaAddon", 1, 0, missing)).duration(5 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.ElectricalSteel, 1L),
                        getModItem(OpenModularTurrets.ID, "ioBus", 4, 0, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "redstoneReactorAddon", 1, 0, missing))
                .duration(5 * SECONDS).eut(120).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 4L),
                        getModItem(Minecraft.ID, "redstone", 4, 0, missing),
                        getModItem(Minecraft.ID, "blaze_powder", 1, 0, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "blazingClayCraftable", 32, 0, missing))
                .duration(10 * SECONDS).eut(30).addTo(mixerRecipes);

    }
}
