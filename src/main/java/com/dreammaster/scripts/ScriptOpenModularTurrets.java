package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.*;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
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
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.block.BlockList;
import com.dreammaster.item.NHItemList;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.Circuits;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Mods;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;
import gregtech.api.material.MU;
import gregtech.api.util.GTOreDictUnificator;

public class ScriptOpenModularTurrets implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Open Modular Turrets";
    }

    @Override
    public List<Mods> getDependencies() {
        return Arrays.asList(
                EnderIO,
                EnderStorage,
                IndustrialCraft2,
                IronChests,
                OpenComputers,
                OpenModularTurrets,
                Thaumcraft);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "baseTierWood", 1, 0),
                "plateIron",
                "stoneCobble",
                "plateIron",
                "plankWood",
                getModItem(OpenModularTurrets.ID, "sensorTierOneItem", 1, 0),
                "plankWood",
                "plateIron",
                "stoneCobble",
                "plateIron");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "baseTierOneBlock", 1, 0),
                "plateSteel",
                ItemList.Battery_Hull_MV.get(1L),
                "plateSteel",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0),
                getModItem(OpenModularTurrets.ID, "sensorTierTwoItem", 1, 0),
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0),
                "plateSteel",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0),
                "plateSteel");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "baseTierTwoBlock", 1, 0),
                "plateDarkSteel",
                createItemStack(EnderIO.ID, "blockCapBank", 1, 1, "{type:\"SIMPLE\",storedEnergyRF:0}"),
                "plateDarkSteel",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0),
                getModItem(OpenModularTurrets.ID, "sensorTierThreeItem", 1, 0),
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0),
                "plateDarkSteel",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0),
                "plateDarkSteel");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "baseTierThreeBlock", 1, 0),
                "plateEnergeticAlloy",
                createItemStack(EnderIO.ID, "blockCapBank", 1, 2, "{type:\"ACTIVATED\",storedEnergyRF:0}"),
                "plateEnergeticAlloy",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0),
                getModItem(OpenModularTurrets.ID, "sensorTierFourItem", 1, 0),
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0),
                "plateEnergeticAlloy",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 1),
                "plateEnergeticAlloy");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "baseTierFourBlock", 1, 0),
                "plateVibrantAlloy",
                createItemStack(EnderIO.ID, "blockCapBank", 1, 3, "{type:\"VIBRANT\",storedEnergyRF:0}"),
                "plateVibrantAlloy",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0),
                getModItem(OpenModularTurrets.ID, "sensorTierFiveItem", 1, 0),
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0),
                "plateVibrantAlloy",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2),
                "plateVibrantAlloy");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "sensorTierOneItem", 1, 0),
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
                getModItem(OpenModularTurrets.ID, "sensorTierTwoItem", 1, 0),
                "plateSteel",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0),
                "plateSteel",
                "circuitBasic",
                getModItem(OpenModularTurrets.ID, "sensorTierOneItem", 1, 0),
                "circuitBasic",
                "plateSteel",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0),
                "plateSteel");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "sensorTierThreeItem", 1, 0),
                "plateDarkSteel",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0),
                "plateDarkSteel",
                "circuitGood",
                getModItem(OpenModularTurrets.ID, "sensorTierTwoItem", 1, 0),
                "circuitGood",
                "plateDarkSteel",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0),
                "plateDarkSteel");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "sensorTierFourItem", 1, 0),
                "plateEnergeticAlloy",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0),
                "plateEnergeticAlloy",
                "circuitAdvanced",
                getModItem(OpenModularTurrets.ID, "sensorTierThreeItem", 1, 0),
                "circuitAdvanced",
                "plateEnergeticAlloy",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0),
                "plateEnergeticAlloy");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "sensorTierFiveItem", 1, 0),
                "plateVibrantAlloy",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0),
                "plateVibrantAlloy",
                "circuitMaster",
                getModItem(OpenModularTurrets.ID, "sensorTierFourItem", 1, 0),
                "circuitMaster",
                "plateVibrantAlloy",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0),
                "plateVibrantAlloy");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "chamberTierOne", 1, 0),
                MaterialLibAPI.getStack(Materials2Materials.Wood, Materials2Shapes.plate, (int) (1L)),
                "craftingToolHardHammer",
                MaterialLibAPI.getStack(Materials2Materials.Wood, Materials2Shapes.plate, (int) (1L)),
                "screwIron",
                "springIron",
                "screwIron",
                MaterialLibAPI.getStack(Materials2Materials.Wood, Materials2Shapes.plate, (int) (1L)),
                "craftingPiston",
                MaterialLibAPI.getStack(Materials2Materials.Wood, Materials2Shapes.plate, (int) (1L)));
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "barrelTierOne", 1, 0),
                MaterialLibAPI.getStack(Materials2Materials.Wood, Materials2Shapes.plate, (int) (1L)),
                MaterialLibAPI.getStack(Materials2Materials.Wood, Materials2Shapes.plate, (int) (1L)),
                MaterialLibAPI.getStack(Materials2Materials.Wood, Materials2Shapes.plate, (int) (1L)),
                "ringIron",
                "craftingToolWrench",
                "ringIron",
                MaterialLibAPI.getStack(Materials2Materials.Wood, Materials2Shapes.plate, (int) (1L)),
                MaterialLibAPI.getStack(Materials2Materials.Wood, Materials2Shapes.plate, (int) (1L)),
                MaterialLibAPI.getStack(Materials2Materials.Wood, Materials2Shapes.plate, (int) (1L)));
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "disposeItemTurret", 1, 0),
                "craftingToolWrench",
                getModItem(OpenModularTurrets.ID, "barrelTierOne", 1, 0),
                "craftingToolHardHammer",
                "plateIron",
                getModItem(OpenModularTurrets.ID, "chamberTierOne", 1, 0),
                "plateIron",
                "stoneCobble",
                "craftingRedstoneTorch",
                "stoneCobble");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "potatoCannonTurret", 1, 0),
                "craftingToolWrench",
                getModItem(OpenModularTurrets.ID, "barrelTierOne", 1, 0),
                "craftingToolHardHammer",
                "plateIron",
                getModItem(OpenModularTurrets.ID, "barrelTierOne", 1, 0),
                "plateIron",
                "craftingRedstoneTorch",
                getModItem(OpenModularTurrets.ID, "chamberTierOne", 1, 0),
                "craftingRedstoneTorch");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "machineGunTurret", 1, 0),
                "craftingToolWrench",
                getModItem(OpenModularTurrets.ID, "barrelTierTwo", 1, 0),
                "craftingToolHardHammer",
                "plateSteel",
                getModItem(OpenModularTurrets.ID, "barrelTierTwo", 1, 0),
                "plateSteel",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0),
                getModItem(OpenModularTurrets.ID, "chamberTierTwo", 1, 0),
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0));
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "incendiaryTurret", 1, 0),
                getModItem(OpenModularTurrets.ID, "barrelTierTwo", 1, 0),
                "craftingToolHardHammer",
                getModItem(OpenModularTurrets.ID, "barrelTierTwo", 1, 0),
                getModItem(OpenModularTurrets.ID, "chamberTierOne", 1, 0),
                "plateSteel",
                getModItem(OpenModularTurrets.ID, "chamberTierOne", 1, 0),
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0),
                "plateSteel",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0));
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "grenadeTurret", 1, 0),
                "craftingToolWrench",
                getModItem(OpenModularTurrets.ID, "barrelTierThree", 1, 0),
                "craftingToolHardHammer",
                "plateDarkSteel",
                getModItem(OpenModularTurrets.ID, "chamberTierThree", 1, 0),
                "plateDarkSteel",
                "plateDarkSteel",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0),
                "plateDarkSteel");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "relativisticTurret", 1, 0),
                "plateDarkSteel",
                getModItem(EnderIO.ID, "itemMaterial", 1, 6),
                "plateDarkSteel",
                getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard),
                getModItem(OpenModularTurrets.ID, "sensorTierThreeItem", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard),
                "plateDarkSteel",
                "plateEnderiumBase",
                "plateDarkSteel");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "grenadeTurret", 1, 0),
                "craftingToolWrench",
                getModItem(OpenModularTurrets.ID, "barrelTierThree", 1, 0),
                "craftingToolHardHammer",
                "plateDarkSteel",
                getModItem(OpenModularTurrets.ID, "chamberTierThree", 1, 0),
                "plateDarkSteel",
                "plateDarkSteel",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0),
                "plateDarkSteel");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "rocketTurret", 1, 0),
                "plateEnergeticAlloy",
                getModItem(OpenModularTurrets.ID, "barrelTierFour", 1, 0),
                "plateEnergeticAlloy",
                getModItem(OpenModularTurrets.ID, "chamberTierFour", 1, 0),
                getModItem(OpenModularTurrets.ID, "barrelTierFour", 1, 0),
                getModItem(OpenModularTurrets.ID, "chamberTierFour", 1, 0),
                "plateEnergeticAlloy",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0),
                "plateEnergeticAlloy");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "teleporterTurret", 1, 0),
                "craftingToolWrench",
                getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 0),
                "craftingToolHardHammer",
                getModItem(EnderIO.ID, "itemMaterial", 1, 8),
                getModItem(OpenModularTurrets.ID, "sensorTierFourItem", 1, 0),
                getModItem(EnderIO.ID, "itemMaterial", 1, 8),
                "plateEnergeticAlloy",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0),
                "plateEnergeticAlloy");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "railGunTurret", 1, 0),
                "craftingToolWrench",
                getModItem(OpenModularTurrets.ID, "barrelTierFive", 1, 0),
                "craftingToolHardHammer",
                "plateVibrantAlloy",
                getModItem(OpenModularTurrets.ID, "barrelTierFive", 1, 0),
                "plateVibrantAlloy",
                "plateVibrantAlloy",
                getModItem(OpenModularTurrets.ID, "chamberTierFive", 1, 0),
                "plateVibrantAlloy");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "laserTurret", 1, 0),
                "craftingToolWrench",
                getModItem(OpenModularTurrets.ID, "barrelTierFive", 1, 0),
                "craftingToolHardHammer",
                "itemVibrantCrystal",
                getModItem(OpenModularTurrets.ID, "chamberTierFive", 1, 0),
                "itemVibrantCrystal",
                "plateEnergeticAlloy",
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0),
                "plateEnergeticAlloy");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "hardWallTierOne", 9, 0),
                "stoneSmooth",
                getModItem(Minecraft.ID, "gravel", 1, 0),
                "stoneSmooth",
                getModItem(Minecraft.ID, "clay", 1, 0),
                "sand",
                getModItem(Minecraft.ID, "clay", 1, 0),
                "stoneSmooth",
                getModItem(Minecraft.ID, "gravel", 1, 0),
                "stoneSmooth");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "fenceTierOne", 5, 0),
                getModItem(Minecraft.ID, "iron_bars", 1, 0),
                "ringSteel",
                getModItem(Minecraft.ID, "iron_bars", 1, 0),
                "screwSteel",
                getModItem(Minecraft.ID, "iron_bars", 1, 0),
                "screwSteel",
                getModItem(Minecraft.ID, "iron_bars", 1, 0),
                "ringSteel",
                getModItem(Minecraft.ID, "iron_bars", 1, 0));
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0),
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
                getModItem(OpenModularTurrets.ID, "expanderPowerTierOne", 1, 0),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                GTOreDictUnificator.get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Wood), 1L),
                ItemList.Battery_Hull_LV.get(1L),
                GTOreDictUnificator.get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Wood), 1L),
                "screwIron",
                "craftingToolFile",
                "screwIron");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "expanderInvTierOne", 1, 0),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                GTOreDictUnificator.get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Wood), 1L),
                "chestWood",
                GTOreDictUnificator.get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Wood), 1L),
                "screwIron",
                "craftingToolFile",
                "screwIron");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "leverBlock", 1, 0),
                "rodStone",
                "rodStone",
                "rodStone",
                null,
                null,
                "rodStone");
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "bulletCraftable", 64, 0),
                "foilSteel",
                "ringIron",
                "foilSteel",
                "plateIron",
                "dustGunpowder",
                "plateIron",
                "foilSteel",
                "boltIron",
                "foilSteel");

        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        getModItem(Minecraft.ID, "iron_bars", 1, 0),
                        MaterialLibAPI.getStack(Materials2Materials.Steel, Materials2Shapes.ring, (int) (1L)))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "fenceTierOne", 4, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        BlockList.SteelBars.get(),
                        MaterialLibAPI.getStack(Materials2Materials.Aluminium, Materials2Shapes.ring, (int) (1L)))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "fenceTierTwo", 4, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0),
                        MaterialLibAPI.getStack(Materials2Materials.StainlessSteel, Materials2Shapes.ring, (int) (1L)))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "fenceTierThree", 4, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        BlockList.TungstenSteelBars.get(),
                        MaterialLibAPI.getStack(Materials2Materials.Titanium, Materials2Shapes.ring, (int) (1L)))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "fenceTierFour", 4, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        BlockList.IridiumBars.get(),
                        MaterialLibAPI.getStack(Materials2Materials.TungstenSteel, Materials2Shapes.ring, (int) (1L)))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "fenceTierFive", 4, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Wood), 1L),
                        ItemList.Battery_Hull_LV.get(1L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderPowerTierOne", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        GTOreDictUnificator
                                .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.ElectricalSteel), 1L),
                        ItemList.Battery_Hull_MV.get(1L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderPowerTierTwo", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.DarkSteel), 1L),
                        ItemList.Battery_Hull_HV.get(1L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderPowerTierThree", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        GTOreDictUnificator
                                .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.EnergeticAlloy), 1L),
                        ItemList.BatteryHull_EV.get(1))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderPowerTierFour", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        GTOreDictUnificator
                                .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.VibrantAlloy), 1L),
                        ItemList.BatteryHull_IV.get(1))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderPowerTierFive", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.Wood), 1L),
                        getModItem(Minecraft.ID, "chest", 1, 0))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderInvTierOne", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        GTOreDictUnificator
                                .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.ElectricalSteel), 1L),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 0))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderInvTierTwo", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.DarkSteel), 1L),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 4))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderInvTierThree", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        GTOreDictUnificator
                                .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.EnergeticAlloy), 1L),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 2))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderInvTierFour", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        GTOreDictUnificator
                                .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.VibrantAlloy), 1L),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 5))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderInvTierFive", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Wood, Materials2Shapes.plate, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Iron, Materials2Shapes.ring, (int) (2L)))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "barrelTierOne", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Iron, Materials2Shapes.plate, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Steel, Materials2Shapes.ring, (int) (2L)))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "barrelTierTwo", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.DarkSteel, Materials2Shapes.plate, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.StainlessSteel, Materials2Shapes.ring, (int) (2L)))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "barrelTierThree", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.EnergeticAlloy, Materials2Shapes.plate, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.TungstenSteel, Materials2Shapes.ring, (int) (2L)))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "barrelTierFour", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.VibrantAlloy, Materials2Shapes.plate, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Iridium, Materials2Shapes.ring, (int) (2L)))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "barrelTierFive", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        getModItem(Minecraft.ID, "piston", 1, 0),
                        MaterialLibAPI.getStack(Materials2Materials.Iron, Materials2Shapes.spring, (int) (1L)))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "chamberTierOne", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        ItemList.Electric_Piston_LV.get(1L),
                        MaterialLibAPI.getStack(Materials2Materials.Steel, Materials2Shapes.spring, (int) (1L)))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "chamberTierTwo", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        ItemList.Electric_Piston_MV.get(1L),
                        MaterialLibAPI
                                .getStack(Materials2Materials.StainlessSteel, Materials2Shapes.spring, (int) (1L)))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "chamberTierThree", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        ItemList.Electric_Piston_HV.get(1L),
                        MaterialLibAPI.getStack(Materials2Materials.TungstenSteel, Materials2Shapes.spring, (int) (1L)))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "chamberTierFour", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        ItemList.Electric_Piston_EV.get(1L),
                        MaterialLibAPI.getStack(Materials2Materials.Iridium, Materials2Shapes.spring, (int) (1L)))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "chamberTierFive", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        Circuits.LV.get(2),
                        MaterialLibAPI.getStack(Materials2Materials.Gold, Materials2Shapes.plate, (int) (1L)))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "ioBus", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 72)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Steel, Materials2Shapes.foil, (int) (4L)),
                        getModItem(Minecraft.ID, "gunpowder", 1, 0))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "bulletCraftable", 64, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 144)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.StainlessSteel, Materials2Shapes.plate, (int) (2L)),
                        getModItem(Minecraft.ID, "tnt", 1, 0))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "grenadeCraftable", 32, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 144)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.ElectricalSteel, Materials2Shapes.plate, (int) (4L)),
                        getModItem(IndustrialCraft2.ID, "blockITNT", 3, 0))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "rocketCraftable", 24, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.stainlesssteel", 144)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.DarkSteel, Materials2Shapes.plate, (int) (2L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.NeodymiumMagnetic, Materials2Shapes.bolt, (int) (1L)))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "ferroSlug", 16, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tungstensteel", 144)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.ElectricalSteel, Materials2Shapes.plate, (int) (1L)),
                        NHItemList.ReinforcedGlassLense.get())
                .itemOutputs(getModItem(OpenModularTurrets.ID, "accuraccyUpgradeItem", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.ElectricalSteel, Materials2Shapes.plate, (int) (1L)),
                        getModItem(Minecraft.ID, "magma_cream", 1, 0))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "fireRateUpgradeItem", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19).itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.ElectricalSteel, Materials2Shapes.plate, (int) (1L)),
                MaterialLibAPI.getStack(Materials2Materials.StainlessSteel, Materials2Shapes.springSmall, (int) (1L)))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "rangeUpgradeItem", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.ElectricalSteel, Materials2Shapes.plate, (int) (1L)),
                        BlockList.StainlessSteelBars.get())
                .itemOutputs(getModItem(OpenModularTurrets.ID, "scattershotUpgradeItem", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.ElectricalSteel, Materials2Shapes.plate, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.pipeTiny, MU.materialOf(Materials2Materials.Steel), 2L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "efficiencyUpgradeItem", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.ElectricalSteel, Materials2Shapes.plate, (int) (1L)),
                        getModItem(Minecraft.ID, "ender_eye", 2, 0))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "damageAmpAddon", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.ElectricalSteel, Materials2Shapes.plate, (int) (1L)),
                        getModItem(EnderIO.ID, "blockSolarPanel", 1, 0))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "solarPanelAddon", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.ElectricalSteel, Materials2Shapes.plate, (int) (1L)),
                        getModItem(OpenComputers.ID, "item", 4, 24))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "serialPortAddon", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.ElectricalSteel, Materials2Shapes.plate, (int) (1L)),
                        ItemList.Electric_Piston_MV.get(1L))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "concealerAddon", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.ElectricalSteel, Materials2Shapes.plate, (int) (1L)),
                        getModItem(EnderStorage.ID, "enderChest", 1, 0))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "recyclerAddon", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.ElectricalSteel, Materials2Shapes.plate, (int) (1L)),
                        getModItem(Thaumcraft.ID, "blockTube", 4, 0))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "potentiaAddon", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().circuit(19)
                .itemInputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.ElectricalSteel, Materials2Shapes.plate, (int) (1L)),
                        getModItem(OpenModularTurrets.ID, "ioBus", 4, 0))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "redstoneReactorAddon", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Clay, Materials2Shapes.dust, (int) (4L)),
                        getModItem(Minecraft.ID, "redstone", 4, 0),
                        getModItem(Minecraft.ID, "blaze_powder", 1, 0))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "blazingClayCraftable", 32, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(mixerRecipes);

    }
}
