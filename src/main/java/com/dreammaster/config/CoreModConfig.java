package com.dreammaster.config;

import java.io.File;

import com.dreammaster.modfixes.oilgen.OilGeneratorFix;
import eu.usrv.yamcore.config.ConfigManager;

public class CoreModConfig extends ConfigManager {

    public CoreModConfig(File pConfigBaseDirectory, String pModCollectionDirectory, String pModID) {
        super(pConfigBaseDirectory, pModCollectionDirectory, pModID);
    }

    public boolean OreDictItems_Enabled;
    public static boolean ModLoginMessage_Enabled;
    public static String ModPackVersion;

    public boolean ModHazardousItems_Enabled;
    public boolean ModDebugVersionDisplay_Enabled;
    public boolean ModCustomToolTips_Enabled;
    public boolean ModItemInHandInfo_Enabled;
    public boolean ModCustomFuels_Enabled;
    public boolean ModCustomDrops_Enabled;
    public boolean ModAdminErrorLogs_Enabled;
    public boolean ModBabyChest_Enabled;

    public boolean AvaritiaFixEnabled;
    public boolean MinetweakerFurnaceFixEnabled;
    public String[] SkullFireSwordEntityTargets;
    public String[] BlacklistedTileEntiyClassNames;

    // Deep Dark void miner configs.
    public boolean DebugPrintAllOres;
    public boolean DebugPrintAllWerkstoff;
    public boolean DebugPrintAddedOres;
    public boolean DebugPrintWerkstoff;
    public String[] MaterialWeights;
    public String[] WerkstoffWeights;

    public OilGeneratorFix.OilConfig OilFixConfig;

    // pollution stuff
    public int pollutionThresholdAirFilter = 10000;
    public float globalMultiplicator = 30f;
    public float scalingFactor = 2.5f;
    public float bonusByTierT1 = 1f;
    public float bonusByTierT2 = 1.05f;
    public float bonusByTierT3 = 1.1f;
    public int usagesPerAbsorptionFilter = 30;
    public float boostPerAbsorptionFilter = 2f;

    @Override
    protected void PreInit() {
        ModLoginMessage_Enabled = true;
        ModPackVersion = "2.3.2";
        ModDebugVersionDisplay_Enabled = true;
        ModHazardousItems_Enabled = false;
        ModCustomToolTips_Enabled = false;
        ModItemInHandInfo_Enabled = false;
        ModCustomFuels_Enabled = false;
        ModCustomDrops_Enabled = false;
        ModAdminErrorLogs_Enabled = true;
        ModBabyChest_Enabled = true;
        OreDictItems_Enabled = true;

        AvaritiaFixEnabled = false;
        MinetweakerFurnaceFixEnabled = true;

        BlacklistedTileEntiyClassNames = new String[] {
                "com.rwtema.extrautils.tileentity.enderquarry.TileEntityEnderQuarry" };
        SkullFireSwordEntityTargets = new String[] { "net.minecraft.entity.monster.EntitySkeleton",
                "galaxyspace.SolarSystem.planets.venus.entities.EntityEvolvedFireSkeleton",
                "micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton" };

        DebugPrintAllOres = false;
        DebugPrintAddedOres = false;
        MaterialWeights = new String[] {};
        WerkstoffWeights = new String[] {};

        pollutionThresholdAirFilter = 10000;
    }

    @Override
    protected void Init() {
        OreDictItems_Enabled = _mainConfig.getBoolean(
                "OreDictItems",
                "Modules",
                OreDictItems_Enabled,
                "Set to false to prevent the OreDict register for SpaceStones and SpaceDusts");
        ModLoginMessage_Enabled = _mainConfig.getBoolean(
                "LoginMessage",
                "Modules",
                ModLoginMessage_Enabled,
                "Set to true to show login message with modpack version");
        ModPackVersion = _mainConfig.getString("ModPackVersion", "Modules", ModPackVersion, "Version of the Modpack");
        ModDebugVersionDisplay_Enabled = _mainConfig.getBoolean(
                "DebugVersionDisplay",
                "Modules",
                ModDebugVersionDisplay_Enabled,
                "Set to true to display modpack version on debug GUI (F3)");
        ModHazardousItems_Enabled = _mainConfig.getBoolean(
                "HazardousItems",
                "Modules",
                ModHazardousItems_Enabled,
                "Set to true to enable HazardousItems module. This needs a separate config file which is created once you start with this setting enabled");
        ModCustomToolTips_Enabled = _mainConfig.getBoolean(
                "CustomToolTips",
                "Modules",
                ModCustomToolTips_Enabled,
                "Set to true to enable CustomToolTips module. This needs a separate config file which is created once you start with this setting enabled");
        ModItemInHandInfo_Enabled = _mainConfig.getBoolean(
                "ItemInHandInfo",
                "Modules",
                ModItemInHandInfo_Enabled,
                "Set to true to enable ItemInHandInfo module. If enabled, type /iih to display the item's name-info");
        ModCustomDrops_Enabled = _mainConfig.getBoolean(
                "CustomDrops",
                "Modules",
                ModCustomDrops_Enabled,
                "Set to true to enable CustomDrops module. This needs a separate config file which is created once you start with this setting enabled");
        ModCustomFuels_Enabled = _mainConfig.getBoolean(
                "CustomFuels",
                "Modules",
                ModCustomFuels_Enabled,
                "Set to true to enable CustomFuels module. Allows you to set burn-time values to almost any item");
        ModAdminErrorLogs_Enabled = _mainConfig.getBoolean(
                "AdminErrorLog",
                "Modules",
                ModAdminErrorLogs_Enabled,
                "If set to true, every op/admin will receive all errors occoured during the startup phase as ingame message on join");
        ModBabyChest_Enabled = _mainConfig.getBoolean(
                "BabyChest",
                "Modules",
                ModBabyChest_Enabled,
                "A complete, full working example for a custom chest, with its own renderer for items and blocks, custom sound and a GUI");

        AvaritiaFixEnabled = _mainConfig.getBoolean(
                "AvaritiaFixEnabled",
                "ModFixes",
                AvaritiaFixEnabled,
                "Set to true to enable the modfix for Avaritia SkullFireSword");
        MinetweakerFurnaceFixEnabled = _mainConfig.getBoolean(
                "MinetweakerFurnaceFixEnabled",
                "ModFixes",
                MinetweakerFurnaceFixEnabled,
                "Set to true to allow Minetweaker to override the vanilla furnace fuel handler, allowing the burn value of WOOD material items to be changed.");
        SkullFireSwordEntityTargets = _mainConfig.getStringList(
                "Avaritia_SkullFireSwordEntityTargets",
                "ModFixes.Avaritia",
                SkullFireSwordEntityTargets,
                "The Canonical Class-Name of the Entity");
        BlacklistedTileEntiyClassNames = _mainConfig.getStringList(
                "BlacklistedTileEntiyClassNames",
                "Modules.Worldaccelerator",
                BlacklistedTileEntiyClassNames,
                "The Canonical Class-Names of TileEntities that should be ignored by the WorldAccelerator");

        DebugPrintAllOres = _mainConfig.getBoolean(
                "DebugPrintAllOres",
                "DeepDarkVoidMiner",
                DebugPrintAllOres,
                "Set to true to enable logging of all valid ores. This is useful for debugging, or finding names to add to the weight config.");
        DebugPrintAddedOres = _mainConfig.getBoolean(
                "DebugPrintAddedOres",
                "DeepDarkVoidMiner",
                DebugPrintAddedOres,
                "Set to true to enable logging of ores added to the Deep Dark void miner, with weights and metadata IDs. This is useful for debugging.");
        MaterialWeights = _mainConfig.getStringList(
                "MaterialWeights",
                "DeepDarkVoidMiner",
                MaterialWeights,
                "List of GregTech material names to adjust weight. Example line: \"Aluminium : 0.3\". Intervening whitespace will be ignored. Use the debug options to get valid names. Use weight <= 0 to disable an ore entirely. Anything not specified in the list will have weight 1. See: gregtech.api.enums.Materials");
        WerkstoffWeights = _mainConfig.getStringList(
                "WerkstoffWeights",
                "DeepDarkVoidMiner",
                WerkstoffWeights,
                "List of BartWorks material names to adjust weight. Example line: \"Bismutite : 0.3\". Intervening whitespace will be ignored. Use the debug options to get valid names. Use weight <= 0 to disable an ore entirely. Anything not specified in the list will have weight 1. See: com.github.bartimaeusnek.bartworks.system.material.Werkstoff");

        OilFixConfig = new OilGeneratorFix.OilConfig(_mainConfig);

        pollutionThresholdAirFilter = _mainConfig.getInt(
                "PollutionThresholdAirFilter",
                "Pollution",
                pollutionThresholdAirFilter,
                0,
                Integer.MAX_VALUE,
                "the threshold of pollution above which the electric air filters will start to work");
        globalMultiplicator = _mainConfig.getFloat(
                "globalMultiplicator",
                "Pollution",
                globalMultiplicator,
                0,
                100,
                "global multiplicator in this formula: globalMultiplicator * bonusByTier * mufflerAmount * turbineEfficiency * maintenanceEff * Floor(scalingFactor^effectiveTier). This gives the pollution cleaned by the electric air filter per second");
        scalingFactor = _mainConfig.getFloat(
                "scalingFactor",
                "Pollution",
                scalingFactor,
                0,
                100,
                "scaling factor in this formula: globalMultiplicator * bonusByTier * mufflerAmount * turbineEfficiency * maintenanceEff * Floor(scalingFactor^effectiveTier). This gives the pollution cleaned by the electric air filter per second");
        bonusByTierT1 = _mainConfig.getFloat(
                "bonusByTierT1",
                "Pollution",
                bonusByTierT1,
                0,
                100,
                "T1 bonus tier in this formula: globalMultiplicator * bonusByTier * mufflerAmount * turbineEfficiency * maintenanceEff * Floor(scalingFactor^effectiveTier). This gives the pollution cleaned by the electric air filter per second");
        bonusByTierT2 = _mainConfig.getFloat(
                "bonusByTierT2",
                "Pollution",
                bonusByTierT2,
                0,
                100,
                "T2 bonus tier in this formula: globalMultiplicator * bonusByTier * mufflerAmount * turbineEfficiency * maintenanceEff * Floor(scalingFactor^effectiveTier). This gives the pollution cleaned by the electric air filter per second");
        bonusByTierT3 = _mainConfig.getFloat(
                "bonusByTierT3",
                "Pollution",
                bonusByTierT3,
                0,
                100,
                "T3 bonus tier in this formula: globalMultiplicator * bonusByTier * mufflerAmount * turbineEfficiency * maintenanceEff * Floor(scalingFactor^effectiveTier). This gives the pollution cleaned by the electric air filter per second");
        boostPerAbsorptionFilter = _mainConfig.getFloat(
                "boostPerAbsorptionFilter",
                "Pollution",
                boostPerAbsorptionFilter,
                1,
                100,
                "boost applied when a filter has been set in the electric air filter.");
        usagesPerAbsorptionFilter = _mainConfig.getInt(
                "usagesPerAbsorptionFilter",
                "Pollution",
                usagesPerAbsorptionFilter,
                1,
                100,
                "Number of usage per absorption filter.");
    }

    @Override
    protected void PostInit() {}
}
