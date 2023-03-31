package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.objects.ItemData;

public class ScriptIndustrialApiary implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "IndustrialApiary";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                "Forestry",
                "gregtech",
                "gendustry",
                "ExtraBees",
                "ExtraUtilities",
                "Botany",
                "BiomesOPlenty",
                "Genetics",
                "ProjRed|Illumination",
                "TConstruct");
    }

    @Override
    public void loadRecipes() {

        final ItemStack FrameHousing = getModItem("ExtraBees", "alveary", 1, 1);
        final ItemStack AlvearyLighting = getModItem("ExtraBees", "alveary", 1, 3);
        final ItemStack AlvearySieve = getModItem("Forestry", "alveary", 1, 7);
        final ItemStack EnhancedCircuitBoard = getModItem("Forestry", "chipsets", 1, 1);

        final ItemData SmallSteelGear = (ItemData) OrePrefixes.gearGtSmall.get(Materials.Steel);
        final ItemData SmallStainlessGear = (ItemData) OrePrefixes.gearGtSmall.get(Materials.StainlessSteel);

        final ItemStack UpgradeFrame = ItemList.IndustrialApiary_Upgrade_Frame.get(1);
        final ItemStack IndustrialApiaryUpgrade_PRODUCTION = ItemList.IndustrialApiary_Upgrade_PRODUCTION.get(1);

        final Item Sugar = Items.sugar;
        final ItemStack RoyalJelly = getModItem("Forestry", "royalJelly", 1);
        final ItemStack ClimateControlModule = getModItem("gendustry", "ClimateModule", 1);
        final ItemStack EnvironmentalProcessor = getModItem("gendustry", "EnvProcessor", 1);
        final Block Grass = Blocks.grass;
        final ItemStack GlowstoneGlass = getModItem("ExtraUtilities", "decorativeBlock2", 1, 7);
        final ItemStack ReinforcedDarkGlass = getModItem("ExtraUtilities", "decorativeBlock2", 1, 11);
        final ItemStack BotanyPollen = getModItem("Botany", "pollen", 1, wildcard);
        final ItemStack HardenedIce = getModItem("BiomesOPlenty", "hardIce", 1);
        final ItemStack Sand = new ItemStack(Blocks.sand, 1, wildcard);
        final Item LavaBucket = Items.lava_bucket;
        final ItemStack LVPiston = ItemList.Electric_Piston_LV.get(1);
        final ItemStack IntegratedCPU = getModItem("Genetics", "misc", 1, 10);
        final ItemStack LVRobotArm = ItemList.Robot_Arm_LV.get(1);
        final Block Cactus = Blocks.cactus;
        final Item WaterBucket = Items.water_bucket;
        final ItemStack SteelBars = CustomItemList.SteelBars.get(1);
        final ItemData TitaniumRotor = (ItemData) OrePrefixes.rotor.get(Materials.Titanium);
        final Block Snow = Blocks.snow;
        final Item FermentedSpiderEye = Items.fermented_spider_eye;
        final String RubberPlate = "plateAnyRubber";
        final String BeesWax = "itemBeeswax";
        final ItemStack GeneticsProcessor = getModItem("gendustry", "GeneticsProcessor", 1);
        final String RedAlloyPlate = "plateRedAlloy";
        final Block Vines = Blocks.vine;
        final String IronPlate = "plateIron";
        final String EnderPearlPlate = "plateEnderPearl";
        final ItemStack InvertedBlueLamp = getModItem("ProjRed|Illumination", "projectred.illumination.lamp", 1, 27);
        final ItemStack ClearGlassPane = getModItem("TConstruct", "GlassPane", 1);
        final Block Netherrack = Blocks.netherrack;
        final ItemStack WovenSilk = getModItem("Forestry", "craftingMaterial", 1, 3);

        // Industrial Apiary
        addShapedRecipe(
                ItemList.Machine_IndustrialApiary.get(1),
                new Object[] { FrameHousing, EnhancedCircuitBoard, FrameHousing, ItemList.Robot_Arm_HV.get(1),
                        ItemList.FR_Casing_Sturdy.get(1), ItemList.Robot_Arm_HV.get(1), AlvearyLighting, AlvearySieve,
                        AlvearyLighting });

        // Upgrade Frame
        GT_Values.RA.addAssemblerRecipe(ItemList.Circuit_Board_Plastic.get(1), IntegratedCPU, UpgradeFrame, 200, 24);

        final ItemList[] AccelerationUpgrades = new ItemList[] { ItemList.IndustrialApiary_Upgrade_Acceleration_1,
                ItemList.IndustrialApiary_Upgrade_Acceleration_2, ItemList.IndustrialApiary_Upgrade_Acceleration_3,
                ItemList.IndustrialApiary_Upgrade_Acceleration_4, ItemList.IndustrialApiary_Upgrade_Acceleration_5,
                ItemList.IndustrialApiary_Upgrade_Acceleration_6, ItemList.IndustrialApiary_Upgrade_Acceleration_7,
                ItemList.IndustrialApiary_Upgrade_Acceleration_8 };

        final ItemStack[] Accelerators = new ItemStack[] { CustomItemList.AcceleratorLV.get(1),
                CustomItemList.AcceleratorMV.get(1), CustomItemList.AcceleratorHV.get(1),
                CustomItemList.AcceleratorEV.get(1), CustomItemList.AcceleratorIV.get(1),
                CustomItemList.AcceleratorLuV.get(1), CustomItemList.AcceleratorZPM.get(1),
                CustomItemList.AcceleratorUV.get(1) };

        // Acceleration Upgrade 1-8
        for (int i = 0; i < AccelerationUpgrades.length; i++) {
            addShapedRecipe(
                    AccelerationUpgrades[i].get(6),
                    new Object[] { SmallSteelGear, UpgradeFrame, SmallSteelGear, UpgradeFrame, Accelerators[i],
                            UpgradeFrame, SmallStainlessGear, UpgradeFrame, SmallStainlessGear });
        }

        // Upgraded Acceleration Upgrade
        addShapedRecipe(
                ItemList.IndustrialApiary_Upgrade_Acceleration_8_Upgraded.get(1),
                new Object[] { IndustrialApiaryUpgrade_PRODUCTION, IndustrialApiaryUpgrade_PRODUCTION,
                        IndustrialApiaryUpgrade_PRODUCTION, IndustrialApiaryUpgrade_PRODUCTION,
                        AccelerationUpgrades[7].get(1), IndustrialApiaryUpgrade_PRODUCTION,
                        IndustrialApiaryUpgrade_PRODUCTION, IndustrialApiaryUpgrade_PRODUCTION,
                        IndustrialApiaryUpgrade_PRODUCTION });

        // Production Upgrade
        addShapedRecipe(
                IndustrialApiaryUpgrade_PRODUCTION,
                new Object[] { SmallSteelGear, Sugar, SmallSteelGear, RoyalJelly, UpgradeFrame, RoyalJelly,
                        SmallStainlessGear, Sugar, SmallStainlessGear });

        // Plain Upgrade
        addShapedRecipe(
                ItemList.IndustrialApiary_Upgrade_PLAINS.get(1),
                new Object[] { SmallSteelGear, ClimateControlModule, SmallSteelGear, Grass, UpgradeFrame, Grass,
                        SmallStainlessGear, EnvironmentalProcessor, SmallStainlessGear });

        // Light Upgrade
        addShapedRecipe(
                ItemList.IndustrialApiary_Upgrade_LIGHT.get(1),
                new Object[] { SmallSteelGear, GlowstoneGlass, SmallSteelGear, GlowstoneGlass, UpgradeFrame,
                        GlowstoneGlass, SmallStainlessGear, GlowstoneGlass, SmallStainlessGear });

        // Unlight Upgrade
        addShapedRecipe(
                ItemList.IndustrialApiary_Upgrade_UNLIGHT.get(1),
                new Object[] { SmallSteelGear, ReinforcedDarkGlass, SmallSteelGear, ReinforcedDarkGlass, UpgradeFrame,
                        ReinforcedDarkGlass, SmallStainlessGear, ReinforcedDarkGlass, SmallStainlessGear });

        // Flowering Upgrade
        addShapedRecipe(
                ItemList.IndustrialApiary_Upgrade_FLOWERING.get(1),
                new Object[] { SmallSteelGear, Blocks.red_flower, SmallSteelGear, BotanyPollen, UpgradeFrame,
                        BotanyPollen, SmallStainlessGear, Blocks.yellow_flower, SmallStainlessGear });

        // Winter Upgrade
        addShapedRecipe(
                ItemList.IndustrialApiary_Upgrade_WINTER.get(1),
                new Object[] { SmallSteelGear, ClimateControlModule, SmallSteelGear, HardenedIce, UpgradeFrame,
                        HardenedIce, SmallStainlessGear, EnvironmentalProcessor, SmallStainlessGear });

        // Dryer Upgrade
        addShapedRecipe(
                ItemList.IndustrialApiary_Upgrade_DRYER.get(1),
                new Object[] { SmallSteelGear, ClimateControlModule, SmallSteelGear, Sand, UpgradeFrame, Sand,
                        SmallStainlessGear, LavaBucket, SmallStainlessGear });

        // Automation Upgrade
        addShapedRecipe(
                ItemList.IndustrialApiary_Upgrade_AUTOMATION.get(1),
                new Object[] { LVPiston, IntegratedCPU, LVPiston, IntegratedCPU, UpgradeFrame, IntegratedCPU,
                        LVRobotArm, IntegratedCPU, LVRobotArm });

        // Humidifier Upgrade
        addShapedRecipe(
                ItemList.IndustrialApiary_Upgrade_HUMIDIFIER.get(1),
                new Object[] { SmallSteelGear, ClimateControlModule, SmallSteelGear, Cactus, UpgradeFrame, Cactus,
                        SmallStainlessGear, WaterBucket, SmallStainlessGear });

        // HELL Upgrade
        addShapedRecipe(
                ItemList.IndustrialApiary_Upgrade_HELL.get(1),
                new Object[] { SmallSteelGear, ClimateControlModule, SmallSteelGear, Items.blaze_rod, UpgradeFrame,
                        Items.ghast_tear, SmallStainlessGear, EnvironmentalProcessor, SmallStainlessGear });

        // Pollen Upgrade
        addShapedRecipe(
                ItemList.IndustrialApiary_Upgrade_POLLEN.get(1),
                new Object[] { SmallSteelGear, SteelBars, SmallSteelGear, TitaniumRotor, UpgradeFrame, TitaniumRotor,
                        SmallStainlessGear, SteelBars, SmallStainlessGear });

        // Desert Upgrade
        addShapedRecipe(
                ItemList.IndustrialApiary_Upgrade_DESERT.get(1),
                new Object[] { SmallSteelGear, ClimateControlModule, SmallSteelGear, Sand, UpgradeFrame, Sand,
                        SmallStainlessGear, EnvironmentalProcessor, SmallStainlessGear });

        // Cooler Upgrade
        addShapedRecipe(
                ItemList.IndustrialApiary_Upgrade_COOLER.get(1),
                new Object[] { SmallSteelGear, ClimateControlModule, SmallSteelGear, Snow, UpgradeFrame, Snow,
                        SmallStainlessGear, HardenedIce, SmallStainlessGear });

        // Lifespan Upgrade
        addShapedRecipe(
                ItemList.IndustrialApiary_Upgrade_LIFESPAN.get(1),
                new Object[] { SmallSteelGear, FermentedSpiderEye, SmallSteelGear, Cactus, UpgradeFrame, Cactus,
                        SmallStainlessGear, FermentedSpiderEye, SmallStainlessGear });

        // Seal Upgrade
        addShapedRecipe(
                ItemList.IndustrialApiary_Upgrade_SEAL.get(1),
                new Object[] { SmallSteelGear, RubberPlate, SmallSteelGear, BeesWax, UpgradeFrame, BeesWax,
                        SmallStainlessGear, RubberPlate, SmallStainlessGear });

        // Genetic Stabilizer Upgrade
        addShapedRecipe(
                ItemList.IndustrialApiary_Upgrade_STABILIZER.get(1),
                new Object[] { SmallSteelGear, GeneticsProcessor, SmallSteelGear, RedAlloyPlate, UpgradeFrame,
                        RedAlloyPlate, SmallStainlessGear, GeneticsProcessor, SmallStainlessGear });

        // Jungle Upgrade
        addShapedRecipe(
                ItemList.IndustrialApiary_Upgrade_JUNGLE.get(1),
                new Object[] { SmallSteelGear, ClimateControlModule, SmallSteelGear, Vines, UpgradeFrame, Vines,
                        SmallStainlessGear, EnvironmentalProcessor, SmallStainlessGear });

        // Territory Upgrade
        addShapedRecipe(
                ItemList.IndustrialApiary_Upgrade_TERRITORY.get(1),
                new Object[] { SmallSteelGear, IronPlate, SmallSteelGear, EnderPearlPlate, UpgradeFrame,
                        EnderPearlPlate, SmallStainlessGear, IronPlate, SmallStainlessGear });

        // Ocean Upgrade
        addShapedRecipe(
                ItemList.IndustrialApiary_Upgrade_OCEAN.get(1),
                new Object[] { SmallSteelGear, ClimateControlModule, SmallSteelGear, WaterBucket, UpgradeFrame,
                        WaterBucket, SmallStainlessGear, EnvironmentalProcessor, SmallStainlessGear });

        // Open Sky Upgrade
        addShapedRecipe(
                ItemList.IndustrialApiary_Upgrade_SKY.get(1),
                new Object[] { SmallSteelGear, InvertedBlueLamp, SmallSteelGear, ClearGlassPane, UpgradeFrame,
                        ClearGlassPane, SmallStainlessGear, ClearGlassPane, SmallStainlessGear });

        // Heater Upgrade
        addShapedRecipe(
                ItemList.IndustrialApiary_Upgrade_HEATER.get(1),
                new Object[] { SmallSteelGear, ClimateControlModule, SmallSteelGear, Netherrack, UpgradeFrame,
                        Netherrack, SmallStainlessGear, LavaBucket, SmallStainlessGear });

        // Sieve Upgrade
        addShapedRecipe(
                ItemList.IndustrialApiary_Upgrade_SIEVE.get(1),
                new Object[] { SmallSteelGear, WovenSilk, SmallSteelGear, SteelBars, UpgradeFrame, SteelBars,
                        SmallStainlessGear, WovenSilk, SmallStainlessGear });
    }
}
