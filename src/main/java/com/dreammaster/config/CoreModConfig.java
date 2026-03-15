package com.dreammaster.config;

import com.dreammaster.lib.Refstrings;
import com.gtnewhorizon.gtnhlib.config.Config;

public final class CoreModConfig {

    @Config(modid = Refstrings.MODID, configSubDirectory = Refstrings.COLLECTIONID, category = "Modules")
    @Config.RequiresMcRestart
    public static class Modules {

        @Config.Comment("Set to false to prevent the OreDict register for SpaceStones and SpaceDusts")
        @Config.DefaultBoolean(true)
        public static boolean OreDictItems = true;

        @Config.Comment("Set to true to show login message with modpack version")
        @Config.DefaultBoolean(true)
        public static boolean LoginMessage;

        @Config.Comment("Set to true to display GTNH buttons in the pause menu")
        @Config.Name("GTNH Pause menu buttons")
        @Config.DefaultBoolean(true)
        public static boolean gtnhPauseMenuButtons;

        @Config.Comment("Version of the Modpack")
        @Config.DefaultString(Refstrings.MODPACKPACK_VERSION)
        public static String ModPackVersion;

        @Config.Comment("Set to true to enable HazardousItems module. This needs a separate config file which is created once you start with this setting enabled")
        @Config.DefaultBoolean(false)
        public static boolean HazardousItems;

        @Config.Comment("Set to true to display modpack version on debug GUI (F3)")
        @Config.DefaultBoolean(true)
        public static boolean DebugVersionDisplay;

        @Config.Comment("Set to true to enable CustomToolTips module. This needs a separate config file which is created once you start with this setting enabled")
        @Config.DefaultBoolean(false)
        public static boolean CustomToolTips;

        @Config.Comment("Set to true to enable CustomFuels module. Allows you to set burn-time values to almost any item")
        @Config.DefaultBoolean(false)
        public static boolean CustomFuels;

        @Config.Comment("Set to true to enable CustomDrops module. This needs a separate config file which is created once you start with this setting enabled")
        @Config.DefaultBoolean(false)
        public static boolean CustomDrops;

        @Config.Comment("A complete, full working example for a custom chest, with its own renderer for items and blocks, custom sound and a GUI")
        @Config.DefaultBoolean(true)
        public static boolean BabyChest;

        @Config.Comment("Enables crafting recipes for Forestry stamps and Chunk Loader Coins. Only works on single player")
        @Config.DefaultBoolean(true)
        public static boolean ForestryStampsAndChunkLoaderCoinsEnabled;

        @Config.Comment("Enables crafting recipes for Forestry stamps and Chunk Loader Coins on server")
        @Config.DefaultBoolean(false)
        public static boolean ForestryStampsAndChunkLoaderCoinsServerEnabled;
    }

    @Config(modid = Refstrings.MODID, configSubDirectory = Refstrings.COLLECTIONID, category = "ModFixes")
    @Config.RequiresMcRestart
    public static class ModFixes {

        @Config.Comment("Set to true to allow Minetweaker to override the vanilla furnace fuel handler, allowing the burn value of WOOD material items to be changed.")
        @Config.DefaultBoolean(true)
        public static boolean MinetweakerFurnaceFixEnabled;

        @Config.Comment("Set to true to enable OilSpawn from this Mod. Make sure to disable Oil-Spawn in BuildCraft if you do")
        @Config.DefaultBoolean(false)
        public static boolean GenerateOil;
    }
}
