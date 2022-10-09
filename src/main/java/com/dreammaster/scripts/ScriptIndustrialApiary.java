package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import com.dreammaster.gthandler.CustomItemList;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.objects.ItemData;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ScriptIndustrialApiary implements IScriptLoader {

    public ScriptIndustrialApiary() {}

    @Override
    public void initScriptData() {
        scriptName.setLength(0);
        scriptName.append("IndustrialApiary");
        dependencies.clear();
        dependencies.addAll(java.util.Arrays.asList(
                "Forestry",
                "gregtech",
                "gendustry",
                "ExtraBees",
                "ExtraUtilities",
                "Botany",
                "BiomesOPlenty",
                "Genetics",
                "ProjRed|Illumination",
                "TConstruct"));
    }

    @Override
    public void loadRecipes() {

        final ItemStack FrameHousing = getModItem("ExtraBees", "alveary", 1, 1);
        final ItemStack AlvearyLighting = getModItem("ExtraBees", "alveary", 1, 3);
        final ItemStack AlvearySieve = getModItem("Forestry", "alveary", 1, 7);
        final ItemStack EnhancedCircuitBoard = getModItem("Forestry", "chipsets", 1, 1);

        final ItemData SmallPalladiumGear = (ItemData) OrePrefixes.gearGtSmall.get(Materials.Palladium);
        final ItemData SmallOsmiumGear = (ItemData) OrePrefixes.gearGtSmall.get(Materials.Osmium);

        final ItemStack UpgradeFrame = ItemList.IndustrialApiary_Upgrade_Frame.get(1);
        final ItemStack IndustrialApiaryUpgrade_PRODUCTION = ItemList.IndustrialApiary_Upgrade_PRODUCTION.get(1);

        final Item Sugar = Items.sugar;
        final ItemStack RoyalJelly = getModItem("Forestry", "royalJelly", 1);
        final ItemStack ClimateControlModule = getModItem("gendustry", "ClimateModule", 1);
        final ItemStack EnvironmentalProcessor = getModItem("gendustry", "EnvProcessor", 1);
        final Block Grass = Blocks.grass;
        final ItemStack GlowstoneGlass = getModItem("ExtraUtilities", "decorativeBlock2", 1, 7);
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
        final ItemStack PoisonExtractJar = getModItem("BiomesOPlenty", "jarFilled", 1, 1);
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
        addShapedRecipe(ItemList.Machine_IndustrialApiary.get(1), new Object[] {
            FrameHousing,
            EnhancedCircuitBoard,
            FrameHousing,
            ItemList.Robot_Arm_HV.get(1),
            ItemList.FR_Casing_Sturdy.get(1),
            ItemList.Robot_Arm_HV.get(1),
            AlvearyLighting,
            AlvearySieve,
            AlvearyLighting
        });

        // Upgrade Frame
        GT_Values.RA.addAssemblerRecipe(ItemList.Circuit_Board_Plastic.get(1), IntegratedCPU, UpgradeFrame, 200, 24);

        final ItemList[] AccelerationUpgrades = new ItemList[] {
            ItemList.IndustrialApiary_Upgrade_Acceleration_1,
            ItemList.IndustrialApiary_Upgrade_Acceleration_2,
            ItemList.IndustrialApiary_Upgrade_Acceleration_3,
            ItemList.IndustrialApiary_Upgrade_Acceleration_4,
            ItemList.IndustrialApiary_Upgrade_Acceleration_5,
            ItemList.IndustrialApiary_Upgrade_Acceleration_6,
            ItemList.IndustrialApiary_Upgrade_Acceleration_7,
            ItemList.IndustrialApiary_Upgrade_Acceleration_8
        };

        final ItemStack[] Accelerators = new ItemStack[] {
            CustomItemList.AcceleratorLV.get(1),
            CustomItemList.AcceleratorMV.get(1),
            CustomItemList.AcceleratorHV.get(1),
            CustomItemList.AcceleratorEV.get(1),
            CustomItemList.AcceleratorIV.get(1),
            CustomItemList.AcceleratorLuV.get(1),
            CustomItemList.AcceleratorZPM.get(1),
            CustomItemList.AcceleratorUV.get(1)
        };

        // Acceleration Upgrade 1-8
        for (int i = 0; i < AccelerationUpgrades.length; i++) {
            addShapedRecipe(AccelerationUpgrades[i].get(6), new Object[] {
                SmallPalladiumGear,
                UpgradeFrame,
                SmallPalladiumGear,
                UpgradeFrame,
                Accelerators[i],
                UpgradeFrame,
                SmallOsmiumGear,
                UpgradeFrame,
                SmallOsmiumGear
            });
        }

        // Upgraded Acceleration Upgrade
        addShapedRecipe(ItemList.IndustrialApiary_Upgrade_Acceleration_8_Upgraded.get(1), new Object[] {
            IndustrialApiaryUpgrade_PRODUCTION,
            IndustrialApiaryUpgrade_PRODUCTION,
            IndustrialApiaryUpgrade_PRODUCTION,
            IndustrialApiaryUpgrade_PRODUCTION,
            AccelerationUpgrades[7].get(1),
            IndustrialApiaryUpgrade_PRODUCTION,
            IndustrialApiaryUpgrade_PRODUCTION,
            IndustrialApiaryUpgrade_PRODUCTION,
            IndustrialApiaryUpgrade_PRODUCTION
        });

        // Production Upgrade
        addShapedRecipe(IndustrialApiaryUpgrade_PRODUCTION, new Object[] {
            SmallPalladiumGear,
            Sugar,
            SmallPalladiumGear,
            RoyalJelly,
            UpgradeFrame,
            RoyalJelly,
            SmallOsmiumGear,
            Sugar,
            SmallOsmiumGear
        });

        // Plain Upgrade
        addShapedRecipe(ItemList.IndustrialApiary_Upgrade_PLAINS.get(1), new Object[] {
            SmallPalladiumGear,
            ClimateControlModule,
            SmallPalladiumGear,
            Grass,
            UpgradeFrame,
            Grass,
            SmallOsmiumGear,
            EnvironmentalProcessor,
            SmallOsmiumGear
        });

        // Light Upgrade
        addShapedRecipe(ItemList.IndustrialApiary_Upgrade_LIGHT.get(1), new Object[] {
            SmallPalladiumGear,
            GlowstoneGlass,
            SmallPalladiumGear,
            GlowstoneGlass,
            UpgradeFrame,
            GlowstoneGlass,
            SmallOsmiumGear,
            GlowstoneGlass,
            SmallOsmiumGear
        });

        // Flowering Upgrade
        addShapedRecipe(ItemList.IndustrialApiary_Upgrade_FLOWERING.get(1), new Object[] {
            SmallPalladiumGear,
            Blocks.red_flower,
            SmallPalladiumGear,
            BotanyPollen,
            UpgradeFrame,
            BotanyPollen,
            SmallOsmiumGear,
            Blocks.yellow_flower,
            SmallOsmiumGear
        });

        // Winter Upgrade
        addShapedRecipe(ItemList.IndustrialApiary_Upgrade_WINTER.get(1), new Object[] {
            SmallPalladiumGear,
            ClimateControlModule,
            SmallPalladiumGear,
            HardenedIce,
            UpgradeFrame,
            HardenedIce,
            SmallOsmiumGear,
            EnvironmentalProcessor,
            SmallOsmiumGear
        });

        // Dryer Upgrade
        addShapedRecipe(ItemList.IndustrialApiary_Upgrade_DRYER.get(1), new Object[] {
            SmallPalladiumGear,
            ClimateControlModule,
            SmallPalladiumGear,
            Sand,
            UpgradeFrame,
            Sand,
            SmallOsmiumGear,
            LavaBucket,
            SmallOsmiumGear
        });

        // Automation Upgrade
        addShapedRecipe(ItemList.IndustrialApiary_Upgrade_AUTOMATION.get(1), new Object[] {
            LVPiston,
            IntegratedCPU,
            LVPiston,
            IntegratedCPU,
            UpgradeFrame,
            IntegratedCPU,
            LVRobotArm,
            IntegratedCPU,
            LVRobotArm
        });

        // Humidifier Upgrade
        addShapedRecipe(ItemList.IndustrialApiary_Upgrade_HUMIDIFIER.get(1), new Object[] {
            SmallPalladiumGear,
            ClimateControlModule,
            SmallPalladiumGear,
            Cactus,
            UpgradeFrame,
            Cactus,
            SmallOsmiumGear,
            WaterBucket,
            SmallOsmiumGear
        });

        // HELL Upgrade
        addShapedRecipe(ItemList.IndustrialApiary_Upgrade_HELL.get(1), new Object[] {
            SmallPalladiumGear,
            ClimateControlModule,
            SmallPalladiumGear,
            Items.blaze_rod,
            UpgradeFrame,
            Items.ghast_tear,
            SmallOsmiumGear,
            EnvironmentalProcessor,
            SmallOsmiumGear
        });

        // Pollen Upgrade
        addShapedRecipe(ItemList.IndustrialApiary_Upgrade_POLLEN.get(1), new Object[] {
            SmallPalladiumGear,
            SteelBars,
            SmallPalladiumGear,
            TitaniumRotor,
            UpgradeFrame,
            TitaniumRotor,
            SmallOsmiumGear,
            SteelBars,
            SmallOsmiumGear
        });

        // Desert Upgrade
        addShapedRecipe(ItemList.IndustrialApiary_Upgrade_DESERT.get(1), new Object[] {
            SmallPalladiumGear,
            ClimateControlModule,
            SmallPalladiumGear,
            Sand,
            UpgradeFrame,
            Sand,
            SmallOsmiumGear,
            EnvironmentalProcessor,
            SmallOsmiumGear
        });

        // Cooler Upgrade
        addShapedRecipe(ItemList.IndustrialApiary_Upgrade_COOLER.get(1), new Object[] {
            SmallPalladiumGear,
            ClimateControlModule,
            SmallPalladiumGear,
            Snow,
            UpgradeFrame,
            Snow,
            SmallOsmiumGear,
            HardenedIce,
            SmallOsmiumGear
        });

        // Lifespan Upgrade
        addShapedRecipe(ItemList.IndustrialApiary_Upgrade_LIFESPAN.get(1), new Object[] {
            SmallPalladiumGear,
            FermentedSpiderEye,
            SmallPalladiumGear,
            PoisonExtractJar,
            UpgradeFrame,
            PoisonExtractJar,
            SmallOsmiumGear,
            FermentedSpiderEye,
            SmallOsmiumGear
        });

        // Seal Upgrade
        addShapedRecipe(ItemList.IndustrialApiary_Upgrade_SEAL.get(1), new Object[] {
            SmallPalladiumGear,
            RubberPlate,
            SmallPalladiumGear,
            BeesWax,
            UpgradeFrame,
            BeesWax,
            SmallOsmiumGear,
            RubberPlate,
            SmallOsmiumGear
        });

        // Genetic Stabilizer Upgrade
        addShapedRecipe(ItemList.IndustrialApiary_Upgrade_STABILIZER.get(1), new Object[] {
            SmallPalladiumGear,
            GeneticsProcessor,
            SmallPalladiumGear,
            RedAlloyPlate,
            UpgradeFrame,
            RedAlloyPlate,
            SmallOsmiumGear,
            GeneticsProcessor,
            SmallOsmiumGear
        });

        // Jungle Upgrade
        addShapedRecipe(ItemList.IndustrialApiary_Upgrade_JUNGLE.get(1), new Object[] {
            SmallPalladiumGear,
            ClimateControlModule,
            SmallPalladiumGear,
            Vines,
            UpgradeFrame,
            Vines,
            SmallOsmiumGear,
            EnvironmentalProcessor,
            SmallOsmiumGear
        });

        // Territory Upgrade
        addShapedRecipe(ItemList.IndustrialApiary_Upgrade_TERRITORY.get(1), new Object[] {
            SmallPalladiumGear,
            IronPlate,
            SmallPalladiumGear,
            EnderPearlPlate,
            UpgradeFrame,
            EnderPearlPlate,
            SmallOsmiumGear,
            IronPlate,
            SmallOsmiumGear
        });

        // Ocean Upgrade
        addShapedRecipe(ItemList.IndustrialApiary_Upgrade_OCEAN.get(1), new Object[] {
            SmallPalladiumGear,
            ClimateControlModule,
            SmallPalladiumGear,
            WaterBucket,
            UpgradeFrame,
            WaterBucket,
            SmallOsmiumGear,
            EnvironmentalProcessor,
            SmallOsmiumGear
        });

        // Open Sky Upgrade
        addShapedRecipe(ItemList.IndustrialApiary_Upgrade_SKY.get(1), new Object[] {
            SmallPalladiumGear,
            InvertedBlueLamp,
            SmallPalladiumGear,
            ClearGlassPane,
            UpgradeFrame,
            ClearGlassPane,
            SmallOsmiumGear,
            ClearGlassPane,
            SmallOsmiumGear
        });

        // Heater Upgrade
        addShapedRecipe(ItemList.IndustrialApiary_Upgrade_HEATER.get(1), new Object[] {
            SmallPalladiumGear,
            ClimateControlModule,
            SmallPalladiumGear,
            Netherrack,
            UpgradeFrame,
            Netherrack,
            SmallOsmiumGear,
            LavaBucket,
            SmallOsmiumGear
        });

        // Sieve Upgrade
        addShapedRecipe(ItemList.IndustrialApiary_Upgrade_SIEVE.get(1), new Object[] {
            SmallPalladiumGear,
            WovenSilk,
            SmallPalladiumGear,
            SteelBars,
            UpgradeFrame,
            SteelBars,
            SmallOsmiumGear,
            WovenSilk,
            SmallOsmiumGear
        });
    }
}
