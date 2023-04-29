package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.*;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;

public class ScriptOpenModularTurrets implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Open Modular Turrets";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.OpenModularTurrets.ID, Mods.EnderIO.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("openmodularturrets", "baseTierWood", 1, 0, missing),
                new Object[] { "plateIron", "stoneCobble", "plateIron", "plankWood",
                        getModItem("openmodularturrets", "sensorTierOneItem", 1, 0, missing), "plankWood", "plateIron",
                        "stoneCobble", "plateIron" });
        addShapedRecipe(
                getModItem("openmodularturrets", "baseTierOneBlock", 1, 0, missing),
                new Object[] { "plateSteel", getModItem("gregtech", "gt.metaitem.01", 1, 32501, missing), "plateSteel",
                        getModItem("openmodularturrets", "ioBus", 1, 0, missing),
                        getModItem("openmodularturrets", "sensorTierTwoItem", 1, 0, missing),
                        getModItem("openmodularturrets", "ioBus", 1, 0, missing), "plateSteel",
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 0, missing), "plateSteel" });
        addShapedRecipe(
                getModItem("openmodularturrets", "baseTierTwoBlock", 1, 0, missing),
                new Object[] { "plateDarkSteel",
                        createItemStack("EnderIO", "blockCapBank", 1, 1, "{type:\"SIMPLE\",storedEnergyRF:0}", missing),
                        "plateDarkSteel", getModItem("openmodularturrets", "ioBus", 1, 0, missing),
                        getModItem("openmodularturrets", "sensorTierThreeItem", 1, 0, missing),
                        getModItem("openmodularturrets", "ioBus", 1, 0, missing), "plateDarkSteel",
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 0, missing), "plateDarkSteel" });
        addShapedRecipe(
                getModItem("openmodularturrets", "baseTierThreeBlock", 1, 0, missing),
                new Object[] { "plateEnergeticAlloy",
                        createItemStack(
                                "EnderIO",
                                "blockCapBank",
                                1,
                                2,
                                "{type:\"ACTIVATED\",storedEnergyRF:0}",
                                missing),
                        "plateEnergeticAlloy", getModItem("openmodularturrets", "ioBus", 1, 0, missing),
                        getModItem("openmodularturrets", "sensorTierFourItem", 1, 0, missing),
                        getModItem("openmodularturrets", "ioBus", 1, 0, missing), "plateEnergeticAlloy",
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 1, missing), "plateEnergeticAlloy" });
        addShapedRecipe(
                getModItem("openmodularturrets", "baseTierFourBlock", 1, 0, missing),
                new Object[] { "plateVibrantAlloy",
                        createItemStack(
                                "EnderIO",
                                "blockCapBank",
                                1,
                                3,
                                "{type:\"VIBRANT\",storedEnergyRF:0}",
                                missing),
                        "plateVibrantAlloy", getModItem("openmodularturrets", "ioBus", 1, 0, missing),
                        getModItem("openmodularturrets", "sensorTierFiveItem", 1, 0, missing),
                        getModItem("openmodularturrets", "ioBus", 1, 0, missing), "plateVibrantAlloy",
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 2, missing), "plateVibrantAlloy" });
        addShapedRecipe(
                getModItem("openmodularturrets", "sensorTierOneItem", 1, 0, missing),
                new Object[] { "plateBronze", "dustRedstone", "plateBronze", "craftingRedstoneTorch", "plateIron",
                        "craftingRedstoneTorch", "plateBronze", "dustRedstone", "plateBronze" });
        addShapedRecipe(
                getModItem("openmodularturrets", "sensorTierTwoItem", 1, 0, missing),
                new Object[] { "plateSteel", getModItem("openmodularturrets", "ioBus", 1, 0, missing), "plateSteel",
                        "circuitBasic", getModItem("openmodularturrets", "sensorTierOneItem", 1, 0, missing),
                        "circuitBasic", "plateSteel", getModItem("openmodularturrets", "ioBus", 1, 0, missing),
                        "plateSteel" });
        addShapedRecipe(
                getModItem("openmodularturrets", "sensorTierThreeItem", 1, 0, missing),
                new Object[] { "plateDarkSteel", getModItem("openmodularturrets", "ioBus", 1, 0, missing),
                        "plateDarkSteel", "circuitGood",
                        getModItem("openmodularturrets", "sensorTierTwoItem", 1, 0, missing), "circuitGood",
                        "plateDarkSteel", getModItem("openmodularturrets", "ioBus", 1, 0, missing), "plateDarkSteel" });
        addShapedRecipe(
                getModItem("openmodularturrets", "sensorTierFourItem", 1, 0, missing),
                new Object[] { "plateEnergeticAlloy", getModItem("openmodularturrets", "ioBus", 1, 0, missing),
                        "plateEnergeticAlloy", "circuitAdvanced",
                        getModItem("openmodularturrets", "sensorTierThreeItem", 1, 0, missing), "circuitAdvanced",
                        "plateEnergeticAlloy", getModItem("openmodularturrets", "ioBus", 1, 0, missing),
                        "plateEnergeticAlloy" });
        addShapedRecipe(
                getModItem("openmodularturrets", "sensorTierFiveItem", 1, 0, missing),
                new Object[] { "plateVibrantAlloy", getModItem("openmodularturrets", "ioBus", 1, 0, missing),
                        "plateVibrantAlloy", "circuitMaster",
                        getModItem("openmodularturrets", "sensorTierFourItem", 1, 0, missing), "circuitMaster",
                        "plateVibrantAlloy", getModItem("openmodularturrets", "ioBus", 1, 0, missing),
                        "plateVibrantAlloy" });
        addShapedRecipe(
                getModItem("openmodularturrets", "chamberTierOne", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing), "craftingToolHardHammer",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing), "screwIron", "springIron",
                        "screwIron", getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing), "craftingPiston",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing) });
        addShapedRecipe(
                getModItem("openmodularturrets", "barrelTierOne", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing), "ringIron", "craftingToolWrench",
                        "ringIron", getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing) });
        addShapedRecipe(
                getModItem("openmodularturrets", "disposeItemTurret", 1, 0, missing),
                new Object[] { "craftingToolWrench", getModItem("openmodularturrets", "barrelTierOne", 1, 0, missing),
                        "craftingToolHardHammer", "plateIron",
                        getModItem("openmodularturrets", "chamberTierOne", 1, 0, missing), "plateIron", "stoneCobble",
                        "craftingRedstoneTorch", "stoneCobble" });
        addShapedRecipe(
                getModItem("openmodularturrets", "potatoCannonTurret", 1, 0, missing),
                new Object[] { "craftingToolWrench", getModItem("openmodularturrets", "barrelTierOne", 1, 0, missing),
                        "craftingToolHardHammer", "plateIron",
                        getModItem("openmodularturrets", "barrelTierOne", 1, 0, missing), "plateIron",
                        "craftingRedstoneTorch", getModItem("openmodularturrets", "chamberTierOne", 1, 0, missing),
                        "craftingRedstoneTorch" });
        addShapedRecipe(
                getModItem("openmodularturrets", "machineGunTurret", 1, 0, missing),
                new Object[] { "craftingToolWrench", getModItem("openmodularturrets", "barrelTierTwo", 1, 0, missing),
                        "craftingToolHardHammer", "plateSteel",
                        getModItem("openmodularturrets", "barrelTierTwo", 1, 0, missing), "plateSteel",
                        getModItem("openmodularturrets", "ioBus", 1, 0, missing),
                        getModItem("openmodularturrets", "chamberTierTwo", 1, 0, missing),
                        getModItem("openmodularturrets", "ioBus", 1, 0, missing) });
        addShapedRecipe(
                getModItem("openmodularturrets", "incendiaryTurret", 1, 0, missing),
                new Object[] { getModItem("openmodularturrets", "barrelTierTwo", 1, 0, missing),
                        "craftingToolHardHammer", getModItem("openmodularturrets", "barrelTierTwo", 1, 0, missing),
                        getModItem("openmodularturrets", "chamberTierOne", 1, 0, missing), "plateSteel",
                        getModItem("openmodularturrets", "chamberTierOne", 1, 0, missing),
                        getModItem("openmodularturrets", "ioBus", 1, 0, missing), "plateSteel",
                        getModItem("openmodularturrets", "ioBus", 1, 0, missing) });
        addShapedRecipe(
                getModItem("openmodularturrets", "grenadeTurret", 1, 0, missing),
                new Object[] { "craftingToolWrench", getModItem("openmodularturrets", "barrelTierThree", 1, 0, missing),
                        "craftingToolHardHammer", "plateDarkSteel",
                        getModItem("openmodularturrets", "chamberTierThree", 1, 0, missing), "plateDarkSteel",
                        "plateDarkSteel", getModItem("openmodularturrets", "ioBus", 1, 0, missing), "plateDarkSteel" });
        addShapedRecipe(
                getModItem("openmodularturrets", "relativisticTurret", 1, 0, missing),
                new Object[] { "plateDarkSteel", getModItem("EnderIO", "itemMaterial", 1, 6, missing), "plateDarkSteel",
                        getModItem("IC2", "itemBatCrystal", 1, 32767, missing),
                        getModItem("openmodularturrets", "sensorTierThreeItem", 1, 0, missing),
                        getModItem("IC2", "itemBatCrystal", 1, 32767, missing), "plateDarkSteel", "plateEnderiumBase",
                        "plateDarkSteel" });
        addShapedRecipe(
                getModItem("openmodularturrets", "grenadeTurret", 1, 0, missing),
                new Object[] { "craftingToolWrench", getModItem("openmodularturrets", "barrelTierThree", 1, 0, missing),
                        "craftingToolHardHammer", "plateDarkSteel",
                        getModItem("openmodularturrets", "chamberTierThree", 1, 0, missing), "plateDarkSteel",
                        "plateDarkSteel", getModItem("openmodularturrets", "ioBus", 1, 0, missing), "plateDarkSteel" });
        addShapedRecipe(
                getModItem("openmodularturrets", "rocketTurret", 1, 0, missing),
                new Object[] { "plateEnergeticAlloy", getModItem("openmodularturrets", "barrelTierFour", 1, 0, missing),
                        "plateEnergeticAlloy", getModItem("openmodularturrets", "chamberTierFour", 1, 0, missing),
                        getModItem("openmodularturrets", "barrelTierFour", 1, 0, missing),
                        getModItem("openmodularturrets", "chamberTierFour", 1, 0, missing), "plateEnergeticAlloy",
                        getModItem("openmodularturrets", "ioBus", 1, 0, missing), "plateEnergeticAlloy" });
        addShapedRecipe(
                getModItem("openmodularturrets", "teleporterTurret", 1, 0, missing),
                new Object[] { "craftingToolWrench", getModItem("IC2", "blockMachine2", 1, 0, missing),
                        "craftingToolHardHammer", getModItem("EnderIO", "itemMaterial", 1, 8, missing),
                        getModItem("openmodularturrets", "sensorTierFourItem", 1, 0, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 8, missing), "plateEnergeticAlloy",
                        getModItem("openmodularturrets", "ioBus", 1, 0, missing), "plateEnergeticAlloy" });
        addShapedRecipe(
                getModItem("openmodularturrets", "railGunTurret", 1, 0, missing),
                new Object[] { "craftingToolWrench", getModItem("openmodularturrets", "barrelTierFive", 1, 0, missing),
                        "craftingToolHardHammer", "plateVibrantAlloy",
                        getModItem("openmodularturrets", "barrelTierFive", 1, 0, missing), "plateVibrantAlloy",
                        "plateVibrantAlloy", getModItem("openmodularturrets", "chamberTierFive", 1, 0, missing),
                        "plateVibrantAlloy" });
        addShapedRecipe(
                getModItem("openmodularturrets", "laserTurret", 1, 0, missing),
                new Object[] { "craftingToolWrench", getModItem("openmodularturrets", "barrelTierFive", 1, 0, missing),
                        "craftingToolHardHammer", "itemVibrantCrystal",
                        getModItem("openmodularturrets", "chamberTierFive", 1, 0, missing), "itemVibrantCrystal",
                        "plateEnergeticAlloy", getModItem("openmodularturrets", "ioBus", 1, 0, missing),
                        "plateEnergeticAlloy" });
        addShapedRecipe(
                getModItem("openmodularturrets", "hardWallTierOne", 9, 0, missing),
                new Object[] { "stoneSmooth", getModItem("minecraft", "gravel", 1, 0, missing), "stoneSmooth",
                        getModItem("minecraft", "clay", 1, 0, missing), "sand",
                        getModItem("minecraft", "clay", 1, 0, missing), "stoneSmooth",
                        getModItem("minecraft", "gravel", 1, 0, missing), "stoneSmooth" });
        addShapedRecipe(
                getModItem("openmodularturrets", "fenceTierOne", 5, 0, missing),
                new Object[] { getModItem("minecraft", "iron_bars", 1, 0, missing), "ringSteel",
                        getModItem("minecraft", "iron_bars", 1, 0, missing), "screwSteel",
                        getModItem("minecraft", "iron_bars", 1, 0, missing), "screwSteel",
                        getModItem("minecraft", "iron_bars", 1, 0, missing), "ringSteel",
                        getModItem("minecraft", "iron_bars", 1, 0, missing) });
        addShapedRecipe(
                getModItem("openmodularturrets", "ioBus", 1, 0, missing),
                new Object[] { "screwIron", "plateGold", "craftingToolWrench", "circuitBasic", "dustRedstone",
                        "circuitBasic", "craftingToolScrewdriver", "plateIron", "screwIron" });
        addShapedRecipe(
                getModItem("openmodularturrets", "expanderPowerTierOne", 1, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("gregtech", "gt.blockmachines", 1, 4905, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32500, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 4905, missing), "screwIron", "craftingToolFile",
                        "screwIron" });
        addShapedRecipe(
                getModItem("openmodularturrets", "expanderInvTierOne", 1, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("gregtech", "gt.blockmachines", 1, 4905, missing), "chestWood",
                        getModItem("gregtech", "gt.blockmachines", 1, 4905, missing), "screwIron", "craftingToolFile",
                        "screwIron" });
        addShapedRecipe(
                getModItem("openmodularturrets", "leverBlock", 1, 0, missing),
                new Object[] { "rodStone", "rodStone", "rodStone", null, null, "rodStone" });
        addShapedRecipe(
                getModItem("openmodularturrets", "bulletCraftable", 64, 0, missing),
                new Object[] { "foilSteel", "ringIron", "foilSteel", "plateIron", "dustGunpowder", "plateIron",
                        "foilSteel", "boltIron", "foilSteel" });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "iron_bars", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 28305, missing))
                .itemOutputs(getModItem("openmodularturrets", "fenceTierOne", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.SteelBars", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 28019, missing))
                .itemOutputs(getModItem("openmodularturrets", "fenceTierTwo", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "blockDarkIronBars", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 28306, missing))
                .itemOutputs(getModItem("openmodularturrets", "fenceTierThree", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.TungstenSteelBars", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 28028, missing))
                .itemOutputs(getModItem("openmodularturrets", "fenceTierFour", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.IridiumBars", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 28316, missing))
                .itemOutputs(getModItem("openmodularturrets", "fenceTierFive", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 4905, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32500, missing))
                .itemOutputs(getModItem("openmodularturrets", "expanderPowerTierOne", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 4461, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32501, missing))
                .itemOutputs(getModItem("openmodularturrets", "expanderPowerTierTwo", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 4460, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32502, missing))
                .itemOutputs(getModItem("openmodularturrets", "expanderPowerTierThree", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 4462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32503, missing))
                .itemOutputs(getModItem("openmodularturrets", "expanderPowerTierFour", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 4463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32504, missing))
                .itemOutputs(getModItem("openmodularturrets", "expanderPowerTierFive", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 4905, missing),
                        getModItem("minecraft", "chest", 1, 0, missing))
                .itemOutputs(getModItem("openmodularturrets", "expanderInvTierOne", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 4461, missing),
                        getModItem("IronChest", "BlockIronChest", 1, 0, missing))
                .itemOutputs(getModItem("openmodularturrets", "expanderInvTierTwo", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 4460, missing),
                        getModItem("IronChest", "BlockIronChest", 1, 4, missing))
                .itemOutputs(getModItem("openmodularturrets", "expanderInvTierThree", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 4462, missing),
                        getModItem("IronChest", "BlockIronChest", 1, 2, missing))
                .itemOutputs(getModItem("openmodularturrets", "expanderInvTierFour", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 4463, missing),
                        getModItem("IronChest", "BlockIronChest", 1, 5, missing))
                .itemOutputs(getModItem("openmodularturrets", "expanderInvTierFive", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 4, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 28032, missing))
                .itemOutputs(getModItem("openmodularturrets", "barrelTierOne", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 4, 17032, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 28305, missing))
                .itemOutputs(getModItem("openmodularturrets", "barrelTierTwo", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 4, 17364, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 28306, missing))
                .itemOutputs(getModItem("openmodularturrets", "barrelTierThree", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 4, 17366, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 28316, missing))
                .itemOutputs(getModItem("openmodularturrets", "barrelTierFour", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 4, 17367, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 28084, missing))
                .itemOutputs(getModItem("openmodularturrets", "barrelTierFive", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "piston", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem("openmodularturrets", "chamberTierOne", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24305, missing))
                .itemOutputs(getModItem("openmodularturrets", "chamberTierTwo", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32641, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24306, missing))
                .itemOutputs(getModItem("openmodularturrets", "chamberTierThree", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32642, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24316, missing))
                .itemOutputs(getModItem("openmodularturrets", "chamberTierFour", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32643, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24084, missing))
                .itemOutputs(getModItem("openmodularturrets", "chamberTierFive", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "itemPartCircuit", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing))
                .itemOutputs(getModItem("openmodularturrets", "ioBus", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 72)).noFluidOutputs().duration(100).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 4, 29305, missing),
                        getModItem("minecraft", "gunpowder", 1, 0, missing))
                .itemOutputs(getModItem("openmodularturrets", "bulletCraftable", 64, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 144)).noFluidOutputs().duration(200).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17306, missing),
                        getModItem("minecraft", "tnt", 1, 0, missing))
                .itemOutputs(getModItem("openmodularturrets", "grenadeCraftable", 32, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 144)).noFluidOutputs().duration(200).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 4, 17365, missing),
                        getModItem("IC2", "blockITNT", 3, 0, missing))
                .itemOutputs(getModItem("openmodularturrets", "rocketCraftable", 24, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.stainlesssteel", 144)).noFluidOutputs().duration(200)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17364, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 26356, missing))
                .itemOutputs(getModItem("openmodularturrets", "ferroSlug", 16, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tungstensteel", 144)).noFluidOutputs().duration(200)
                .eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17365, missing),
                        getModItem("dreamcraft", "item.ReinforcedGlassLense", 1, 0, missing))
                .itemOutputs(getModItem("openmodularturrets", "accuraccyUpgradeItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17365, missing),
                        getModItem("minecraft", "magma_cream", 1, 0, missing))
                .itemOutputs(getModItem("openmodularturrets", "fireRateUpgradeItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17365, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 23306, missing))
                .itemOutputs(getModItem("openmodularturrets", "rangeUpgradeItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17365, missing),
                        getModItem("dreamcraft", "item.StainlessSteelBars", 1, 0, missing))
                .itemOutputs(getModItem("openmodularturrets", "scattershotUpgradeItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17365, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 5130, missing))
                .itemOutputs(getModItem("openmodularturrets", "efficiencyUpgradeItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17365, missing),
                        getModItem("minecraft", "ender_eye", 2, 0, missing))
                .itemOutputs(getModItem("openmodularturrets", "damageAmpAddon", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17365, missing),
                        getModItem("EnderIO", "blockSolarPanel", 1, 0, missing))
                .itemOutputs(getModItem("openmodularturrets", "solarPanelAddon", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17365, missing),
                        getModItem("OpenComputers", "item", 4, 24, missing))
                .itemOutputs(getModItem("openmodularturrets", "serialPortAddon", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17365, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32641, missing))
                .itemOutputs(getModItem("openmodularturrets", "concealerAddon", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17365, missing),
                        getModItem("EnderStorage", "enderChest", 1, 0, missing))
                .itemOutputs(getModItem("openmodularturrets", "recyclerAddon", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17365, missing),
                        getModItem("Thaumcraft", "blockTube", 4, 0, missing))
                .itemOutputs(getModItem("openmodularturrets", "potentiaAddon", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17365, missing),
                        getModItem("openmodularturrets", "ioBus", 4, 0, missing))
                .itemOutputs(getModItem("openmodularturrets", "redstoneReactorAddon", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.blockmachines", 1, 4985, missing))
                .itemOutputs(getModItem("openmodularturrets", "hardWallTierOne", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 144)).noFluidOutputs().duration(200).eut(16)
                .addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.blockmachines", 1, 4461, missing))
                .itemOutputs(getModItem("openmodularturrets", "hardWallTierTwo", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 144)).noFluidOutputs().duration(200).eut(30)
                .addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.blockmachines", 1, 4460, missing))
                .itemOutputs(getModItem("openmodularturrets", "hardWallTierThree", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 144)).noFluidOutputs().duration(200).eut(64)
                .addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.blockmachines", 1, 4462, missing))
                .itemOutputs(getModItem("openmodularturrets", "hardWallTierFour", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 144)).noFluidOutputs().duration(200).eut(120)
                .addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.blockmachines", 1, 4463, missing))
                .itemOutputs(getModItem("openmodularturrets", "hardWallTierFive", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 144)).noFluidOutputs().duration(200).eut(256)
                .addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 4, 2805, missing),
                        getModItem("minecraft", "redstone", 4, 0, missing),
                        getModItem("minecraft", "blaze_powder", 1, 0, missing))
                .itemOutputs(getModItem("openmodularturrets", "blazingClayCraftable", 32, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sMixerRecipes);

    }
}
