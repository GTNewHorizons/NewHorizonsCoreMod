package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.EnderStorage;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronChests;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.OpenModularTurrets;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sChemicalBathRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMixerRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;

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
                new Object[] { "plateIron", "stoneCobble", "plateIron", "plankWood",
                        getModItem(OpenModularTurrets.ID, "sensorTierOneItem", 1, 0, missing), "plankWood", "plateIron",
                        "stoneCobble", "plateIron" });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "baseTierOneBlock", 1, 0, missing),
                new Object[] { "plateSteel", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32501, missing), "plateSteel",
                        getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                        getModItem(OpenModularTurrets.ID, "sensorTierTwoItem", 1, 0, missing),
                        getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing), "plateSteel",
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing), "plateSteel" });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "baseTierTwoBlock", 1, 0, missing),
                new Object[] { "plateDarkSteel",
                        createItemStack(
                                EnderIO.ID,
                                "blockCapBank",
                                1,
                                1,
                                "{type:\"SIMPLE\",storedEnergyRF:0}",
                                missing),
                        "plateDarkSteel", getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                        getModItem(OpenModularTurrets.ID, "sensorTierThreeItem", 1, 0, missing),
                        getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing), "plateDarkSteel",
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing), "plateDarkSteel" });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "baseTierThreeBlock", 1, 0, missing),
                new Object[] { "plateEnergeticAlloy",
                        createItemStack(
                                EnderIO.ID,
                                "blockCapBank",
                                1,
                                2,
                                "{type:\"ACTIVATED\",storedEnergyRF:0}",
                                missing),
                        "plateEnergeticAlloy", getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                        getModItem(OpenModularTurrets.ID, "sensorTierFourItem", 1, 0, missing),
                        getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing), "plateEnergeticAlloy",
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 1, missing), "plateEnergeticAlloy" });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "baseTierFourBlock", 1, 0, missing),
                new Object[] { "plateVibrantAlloy",
                        createItemStack(
                                EnderIO.ID,
                                "blockCapBank",
                                1,
                                3,
                                "{type:\"VIBRANT\",storedEnergyRF:0}",
                                missing),
                        "plateVibrantAlloy", getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                        getModItem(OpenModularTurrets.ID, "sensorTierFiveItem", 1, 0, missing),
                        getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing), "plateVibrantAlloy",
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2, missing), "plateVibrantAlloy" });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "sensorTierOneItem", 1, 0, missing),
                new Object[] { "plateBronze", "dustRedstone", "plateBronze", "craftingRedstoneTorch", "plateIron",
                        "craftingRedstoneTorch", "plateBronze", "dustRedstone", "plateBronze" });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "sensorTierTwoItem", 1, 0, missing),
                new Object[] { "plateSteel", getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing), "plateSteel",
                        "circuitBasic", getModItem(OpenModularTurrets.ID, "sensorTierOneItem", 1, 0, missing),
                        "circuitBasic", "plateSteel", getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                        "plateSteel" });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "sensorTierThreeItem", 1, 0, missing),
                new Object[] { "plateDarkSteel", getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                        "plateDarkSteel", "circuitGood",
                        getModItem(OpenModularTurrets.ID, "sensorTierTwoItem", 1, 0, missing), "circuitGood",
                        "plateDarkSteel", getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                        "plateDarkSteel" });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "sensorTierFourItem", 1, 0, missing),
                new Object[] { "plateEnergeticAlloy", getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                        "plateEnergeticAlloy", "circuitAdvanced",
                        getModItem(OpenModularTurrets.ID, "sensorTierThreeItem", 1, 0, missing), "circuitAdvanced",
                        "plateEnergeticAlloy", getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                        "plateEnergeticAlloy" });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "sensorTierFiveItem", 1, 0, missing),
                new Object[] { "plateVibrantAlloy", getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                        "plateVibrantAlloy", "circuitMaster",
                        getModItem(OpenModularTurrets.ID, "sensorTierFourItem", 1, 0, missing), "circuitMaster",
                        "plateVibrantAlloy", getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                        "plateVibrantAlloy" });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "chamberTierOne", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing), "craftingToolHardHammer",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing), "screwIron", "springIron",
                        "screwIron", getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing), "craftingPiston",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing) });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "barrelTierOne", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing), "ringIron", "craftingToolWrench",
                        "ringIron", getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing) });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "disposeItemTurret", 1, 0, missing),
                new Object[] { "craftingToolWrench", getModItem(OpenModularTurrets.ID, "barrelTierOne", 1, 0, missing),
                        "craftingToolHardHammer", "plateIron",
                        getModItem(OpenModularTurrets.ID, "chamberTierOne", 1, 0, missing), "plateIron", "stoneCobble",
                        "craftingRedstoneTorch", "stoneCobble" });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "potatoCannonTurret", 1, 0, missing),
                new Object[] { "craftingToolWrench", getModItem(OpenModularTurrets.ID, "barrelTierOne", 1, 0, missing),
                        "craftingToolHardHammer", "plateIron",
                        getModItem(OpenModularTurrets.ID, "barrelTierOne", 1, 0, missing), "plateIron",
                        "craftingRedstoneTorch", getModItem(OpenModularTurrets.ID, "chamberTierOne", 1, 0, missing),
                        "craftingRedstoneTorch" });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "machineGunTurret", 1, 0, missing),
                new Object[] { "craftingToolWrench", getModItem(OpenModularTurrets.ID, "barrelTierTwo", 1, 0, missing),
                        "craftingToolHardHammer", "plateSteel",
                        getModItem(OpenModularTurrets.ID, "barrelTierTwo", 1, 0, missing), "plateSteel",
                        getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                        getModItem(OpenModularTurrets.ID, "chamberTierTwo", 1, 0, missing),
                        getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing) });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "incendiaryTurret", 1, 0, missing),
                new Object[] { getModItem(OpenModularTurrets.ID, "barrelTierTwo", 1, 0, missing),
                        "craftingToolHardHammer", getModItem(OpenModularTurrets.ID, "barrelTierTwo", 1, 0, missing),
                        getModItem(OpenModularTurrets.ID, "chamberTierOne", 1, 0, missing), "plateSteel",
                        getModItem(OpenModularTurrets.ID, "chamberTierOne", 1, 0, missing),
                        getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing), "plateSteel",
                        getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing) });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "grenadeTurret", 1, 0, missing),
                new Object[] { "craftingToolWrench",
                        getModItem(OpenModularTurrets.ID, "barrelTierThree", 1, 0, missing), "craftingToolHardHammer",
                        "plateDarkSteel", getModItem(OpenModularTurrets.ID, "chamberTierThree", 1, 0, missing),
                        "plateDarkSteel", "plateDarkSteel", getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                        "plateDarkSteel" });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "relativisticTurret", 1, 0, missing),
                new Object[] { "plateDarkSteel", getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing),
                        "plateDarkSteel", getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, 32767, missing),
                        getModItem(OpenModularTurrets.ID, "sensorTierThreeItem", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, 32767, missing), "plateDarkSteel",
                        "plateEnderiumBase", "plateDarkSteel" });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "grenadeTurret", 1, 0, missing),
                new Object[] { "craftingToolWrench",
                        getModItem(OpenModularTurrets.ID, "barrelTierThree", 1, 0, missing), "craftingToolHardHammer",
                        "plateDarkSteel", getModItem(OpenModularTurrets.ID, "chamberTierThree", 1, 0, missing),
                        "plateDarkSteel", "plateDarkSteel", getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                        "plateDarkSteel" });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "rocketTurret", 1, 0, missing),
                new Object[] { "plateEnergeticAlloy",
                        getModItem(OpenModularTurrets.ID, "barrelTierFour", 1, 0, missing), "plateEnergeticAlloy",
                        getModItem(OpenModularTurrets.ID, "chamberTierFour", 1, 0, missing),
                        getModItem(OpenModularTurrets.ID, "barrelTierFour", 1, 0, missing),
                        getModItem(OpenModularTurrets.ID, "chamberTierFour", 1, 0, missing), "plateEnergeticAlloy",
                        getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing), "plateEnergeticAlloy" });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "teleporterTurret", 1, 0, missing),
                new Object[] { "craftingToolWrench", getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 0, missing),
                        "craftingToolHardHammer", getModItem(EnderIO.ID, "itemMaterial", 1, 8, missing),
                        getModItem(OpenModularTurrets.ID, "sensorTierFourItem", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 8, missing), "plateEnergeticAlloy",
                        getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing), "plateEnergeticAlloy" });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "railGunTurret", 1, 0, missing),
                new Object[] { "craftingToolWrench", getModItem(OpenModularTurrets.ID, "barrelTierFive", 1, 0, missing),
                        "craftingToolHardHammer", "plateVibrantAlloy",
                        getModItem(OpenModularTurrets.ID, "barrelTierFive", 1, 0, missing), "plateVibrantAlloy",
                        "plateVibrantAlloy", getModItem(OpenModularTurrets.ID, "chamberTierFive", 1, 0, missing),
                        "plateVibrantAlloy" });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "laserTurret", 1, 0, missing),
                new Object[] { "craftingToolWrench", getModItem(OpenModularTurrets.ID, "barrelTierFive", 1, 0, missing),
                        "craftingToolHardHammer", "itemVibrantCrystal",
                        getModItem(OpenModularTurrets.ID, "chamberTierFive", 1, 0, missing), "itemVibrantCrystal",
                        "plateEnergeticAlloy", getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                        "plateEnergeticAlloy" });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "hardWallTierOne", 9, 0, missing),
                new Object[] { "stoneSmooth", getModItem(Minecraft.ID, "gravel", 1, 0, missing), "stoneSmooth",
                        getModItem(Minecraft.ID, "clay", 1, 0, missing), "sand",
                        getModItem(Minecraft.ID, "clay", 1, 0, missing), "stoneSmooth",
                        getModItem(Minecraft.ID, "gravel", 1, 0, missing), "stoneSmooth" });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "fenceTierOne", 5, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "iron_bars", 1, 0, missing), "ringSteel",
                        getModItem(Minecraft.ID, "iron_bars", 1, 0, missing), "screwSteel",
                        getModItem(Minecraft.ID, "iron_bars", 1, 0, missing), "screwSteel",
                        getModItem(Minecraft.ID, "iron_bars", 1, 0, missing), "ringSteel",
                        getModItem(Minecraft.ID, "iron_bars", 1, 0, missing) });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing),
                new Object[] { "screwIron", "plateGold", "craftingToolWrench", "circuitBasic", "dustRedstone",
                        "circuitBasic", "craftingToolScrewdriver", "plateIron", "screwIron" });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "expanderPowerTierOne", 1, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 4905, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32500, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 4905, missing), "screwIron", "craftingToolFile",
                        "screwIron" });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "expanderInvTierOne", 1, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 4905, missing), "chestWood",
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 4905, missing), "screwIron", "craftingToolFile",
                        "screwIron" });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "leverBlock", 1, 0, missing),
                new Object[] { "rodStone", "rodStone", "rodStone", null, null, "rodStone" });
        addShapedRecipe(
                getModItem(OpenModularTurrets.ID, "bulletCraftable", 64, 0, missing),
                new Object[] { "foilSteel", "ringIron", "foilSteel", "plateIron", "dustGunpowder", "plateIron",
                        "foilSteel", "boltIron", "foilSteel" });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 28305, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "fenceTierOne", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 28019, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "fenceTierTwo", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 28306, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "fenceTierThree", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.TungstenSteelBars", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 28028, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "fenceTierFour", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.IridiumBars", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 28316, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "fenceTierFive", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 4905, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32500, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderPowerTierOne", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 4461, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32501, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderPowerTierTwo", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 4460, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32502, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderPowerTierThree", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 4462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32503, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderPowerTierFour", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 4463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32504, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderPowerTierFive", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 4905, missing),
                        getModItem(Minecraft.ID, "chest", 1, 0, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderInvTierOne", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 4461, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 0, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderInvTierTwo", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 4460, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 4, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderInvTierThree", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 4462, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 2, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderInvTierFour", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 4463, missing),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 5, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "expanderInvTierFive", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17809, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 28032, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "barrelTierOne", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17032, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 28305, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "barrelTierTwo", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17364, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 28306, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "barrelTierThree", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17366, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 28316, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "barrelTierFour", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17367, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 28084, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "barrelTierFive", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "piston", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "chamberTierOne", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24305, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "chamberTierTwo", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32641, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24306, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "chamberTierThree", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32642, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24316, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "chamberTierFour", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32643, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24084, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "chamberTierFive", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17086, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 72)).noFluidOutputs().duration(100).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 29305, missing),
                        getModItem(Minecraft.ID, "gunpowder", 1, 0, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "bulletCraftable", 64, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 144)).noFluidOutputs().duration(200).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17306, missing),
                        getModItem(Minecraft.ID, "tnt", 1, 0, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "grenadeCraftable", 32, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 144)).noFluidOutputs().duration(200).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17365, missing),
                        getModItem(IndustrialCraft2.ID, "blockITNT", 3, 0, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "rocketCraftable", 24, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.stainlesssteel", 144)).noFluidOutputs().duration(200)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17364, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26356, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "ferroSlug", 16, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tungstensteel", 144)).noFluidOutputs().duration(200)
                .eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17365, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.ReinforcedGlassLense", 1, 0, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "accuraccyUpgradeItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17365, missing),
                        getModItem(Minecraft.ID, "magma_cream", 1, 0, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "fireRateUpgradeItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17365, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 23306, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "rangeUpgradeItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17365, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.StainlessSteelBars", 1, 0, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "scattershotUpgradeItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17365, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 5130, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "efficiencyUpgradeItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17365, missing),
                        getModItem(Minecraft.ID, "ender_eye", 2, 0, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "damageAmpAddon", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17365, missing),
                        getModItem(EnderIO.ID, "blockSolarPanel", 1, 0, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "solarPanelAddon", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17365, missing),
                        getModItem(OpenComputers.ID, "item", 4, 24, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "serialPortAddon", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17365, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32641, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "concealerAddon", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17365, missing),
                        getModItem(EnderStorage.ID, "enderChest", 1, 0, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "recyclerAddon", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17365, missing),
                        getModItem(Thaumcraft.ID, "blockTube", 4, 0, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "potentiaAddon", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17365, missing),
                        getModItem(OpenModularTurrets.ID, "ioBus", 4, 0, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "redstoneReactorAddon", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.blockmachines", 1, 4985, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "hardWallTierOne", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 144)).noFluidOutputs().duration(200).eut(16)
                .addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.blockmachines", 1, 4461, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "hardWallTierTwo", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 144)).noFluidOutputs().duration(200).eut(30)
                .addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.blockmachines", 1, 4460, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "hardWallTierThree", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 144)).noFluidOutputs().duration(200).eut(64)
                .addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.blockmachines", 1, 4462, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "hardWallTierFour", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 144)).noFluidOutputs().duration(200).eut(120)
                .addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.blockmachines", 1, 4463, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "hardWallTierFive", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 144)).noFluidOutputs().duration(200).eut(256)
                .addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 2805, missing),
                        getModItem(Minecraft.ID, "redstone", 4, 0, missing),
                        getModItem(Minecraft.ID, "blaze_powder", 1, 0, missing))
                .itemOutputs(getModItem(OpenModularTurrets.ID, "blazingClayCraftable", 32, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sMixerRecipes);

    }
}
