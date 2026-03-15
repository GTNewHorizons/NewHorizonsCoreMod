package com.dreammaster.config;

import java.io.File;

import com.dreammaster.lib.Refstrings;
import com.dreammaster.modfixes.oilgen.OilGeneratorFix;

import com.gtnewhorizon.gtnhlib.config.Config;
import eu.usrv.yamcore.config.ConfigManager;

@Config(modid = Refstrings.MODID, configSubDirectory = Refstrings.COLLECTIONID)
@Config.RequiresMcRestart
public final class CoreModConfig extends ConfigManager {

    public CoreModConfig(File pConfigBaseDirectory, String pModCollectionDirectory, String pModID) {
        super(pConfigBaseDirectory, pModCollectionDirectory, pModID);
    }

    @Config.Comment("Set to false to prevent the OreDict register for SpaceStones and SpaceDusts")
    @Config.DefaultBoolean(true)
    public static boolean OreDictItems_Enabled = true;

    @Config.Comment("Set to true to show login message with modpack version")
    @Config.DefaultBoolean(true)
    public static boolean ModLoginMessage_Enabled;

    @Config.Comment("Set to true to display GTNH buttons in the pause menu")
    @Config.DefaultBoolean(true)
    public static boolean gtnhPauseMenuButtons;

    @Config.Comment("Version of the Modpack")
    @Config.DefaultString(Refstrings.MODPACKPACK_VERSION)
    public static String ModPackVersion;

    @Config.Comment("Set to true to enable HazardousItems module. This needs a separate config file which is created once you start with this setting enabled")
    @Config.DefaultBoolean(false)
    public static boolean ModHazardousItems_Enabled;

    @Config.Comment("Set to true to display modpack version on debug GUI (F3)")
    @Config.DefaultBoolean(true)
    public static boolean ModDebugVersionDisplay_Enabled;

    @Config.Comment("Set to true to enable CustomToolTips module. This needs a separate config file which is created once you start with this setting enabled")
    @Config.DefaultBoolean(false)
    public static boolean ModCustomToolTips_Enabled;

    @Config.Comment("Set to true to enable CustomFuels module. Allows you to set burn-time values to almost any item")
    @Config.DefaultBoolean(false)
    public static boolean ModCustomFuels_Enabled;

    @Config.Comment("Set to true to enable CustomDrops module. This needs a separate config file which is created once you start with this setting enabled")
    @Config.DefaultBoolean(false)
    public static boolean ModCustomDrops_Enabled;

    @Config.Comment("A complete, full working example for a custom chest, with its own renderer for items and blocks, custom sound and a GUI")
    @Config.DefaultBoolean(true)
    public static boolean ModBabyChest_Enabled;

    @Config.Comment("Enables crafting recipes for Forestry stamps and Chunk Loader Coins. Only works on single player")
    @Config.DefaultBoolean(true)
    public static boolean ForestryStampsAndChunkLoaderCoinsEnabled;

    @Config.Comment("Enables crafting recipes for Forestry stamps and Chunk Loader Coins on server")
    @Config.DefaultBoolean(false)
    public static boolean ForestryStampsAndChunkLoaderCoinsServerEnabled;

    @Config.Comment("Set to true to allow Minetweaker to override the vanilla furnace fuel handler, allowing the burn value of WOOD material items to be changed.")
    @Config.DefaultBoolean(true)
    public static boolean MinetweakerFurnaceFixEnabled;

    public static OilGeneratorFix.OilConfig OilFixConfig;

    @Override
    protected void PreInit() {}

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
        gtnhPauseMenuButtons = _mainConfig.getBoolean(
                "GTNH Pause menu buttons",
                "Modules",
                gtnhPauseMenuButtons,
                "Set to true to display GTNH buttons in the pause menu");
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
        ModBabyChest_Enabled = _mainConfig.getBoolean(
                "BabyChest",
                "Modules",
                ModBabyChest_Enabled,
                "A complete, full working example for a custom chest, with its own renderer for items and blocks, custom sound and a GUI");
        ForestryStampsAndChunkLoaderCoinsEnabled = _mainConfig.getBoolean(
                "ForestryStampsAndChunkLoaderCoinsEnabled",
                "Modules",
                ForestryStampsAndChunkLoaderCoinsEnabled,
                "Enables crafting recipes for Forestry stamps and Chunk Loader Coins. Only works on single player");
        ForestryStampsAndChunkLoaderCoinsServerEnabled = _mainConfig.getBoolean(
                "ForestryStampsAndChunkLoaderCoinsServerEnabled",
                "Modules",
                ForestryStampsAndChunkLoaderCoinsServerEnabled,
                "Enables crafting recipes for Forestry stamps and Chunk Loader Coins on server");

        MinetweakerFurnaceFixEnabled = _mainConfig.getBoolean(
                "MinetweakerFurnaceFixEnabled",
                "ModFixes",
                MinetweakerFurnaceFixEnabled,
                "Set to true to allow Minetweaker to override the vanilla furnace fuel handler, allowing the burn value of WOOD material items to be changed.");

        OilFixConfig = new OilGeneratorFix.OilConfig(_mainConfig);
    }

    @Override
    protected void PostInit() {}
}
