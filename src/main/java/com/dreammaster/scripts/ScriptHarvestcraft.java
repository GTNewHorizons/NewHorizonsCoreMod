package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.ExtraTrees;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IguanaTweaksTinkerConstruct;
import static gregtech.api.enums.Mods.MalisisDoors;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCentrifugeRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCompressorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sExtractorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMaceratorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMixerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sPressRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.oredict.OreDictionary;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;
import gregtech.api.util.GT_ModHandler;

public class ScriptHarvestcraft implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Harvestcraft";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                Mods.PamsHarvestCraft.ID,
                Mods.ExtraTrees.ID,
                Backpack.ID,
                BiomesOPlenty.ID,
                Forestry.ID,
                IguanaTweaksTinkerConstruct.ID,
                MalisisDoors.ID,
                Natura.ID);
    }

    @Override
    public void loadRecipes() {
        OreDictionary.registerOre("toolMortarandpestle", getModItem(GregTech.ID, "gt.metatool.01", 1, 24, missing));
        OreDictionary.registerOre("toolCuttingboard", getModItem(GregTech.ID, "gt.metatool.01", 1, 34, missing));
        OreDictionary.registerOre("toolMixingbowl", getModItem(Minecraft.ID, "bowl", 1, 0, missing));
        OreDictionary.registerOre("toolBakeware", getModItem(GregTech.ID, "gt.metatool.01", 1, 46, missing));
        OreDictionary.registerOre("toolJuicer", getModItem(GregTech.ID, "gt.metatool.01", 1, 14, missing));

        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem(Natura.ID, "trapdoor.eucalyptus", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "chestWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem(Natura.ID, "trapdoor.sakura", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "chestWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem(Natura.ID, "trapdoor.ghostwood", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "chestWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem(Natura.ID, "trapdoor.redwood", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "chestWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem(Natura.ID, "trapdoor.bloodwood", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "chestWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem(Natura.ID, "trapdoor.hopseed", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "chestWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem(Natura.ID, "trapdoor.maple", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "chestWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem(Natura.ID, "trapdoor.amaranth", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "chestWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem(Natura.ID, "trapdoor.silverbell", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "chestWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem(Natura.ID, "trapdoor.tiger", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "chestWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem(Natura.ID, "trapdoor.willow", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "chestWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem(Natura.ID, "trapdoor.darkwood", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "chestWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem(Natura.ID, "trapdoor.fusewood", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "chestWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem(MalisisDoors.ID, "trapdoor_acacia", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "chestWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem(MalisisDoors.ID, "trapdoor_birch", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "chestWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem(MalisisDoors.ID, "trapdoor_dark_oak", 1, 0, missing),
                        "stickWood", getModItem(Minecraft.ID, "string", 1, 0, missing), "chestWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem(MalisisDoors.ID, "trapdoor_jungle", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "chestWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem(MalisisDoors.ID, "trapdoor_spruce", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "chestWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "string", 1, 0, missing),
                        getModItem(Natura.ID, "barleyFood", 1, 3, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing),
                        getModItem(Natura.ID, "barleyFood", 1, 3, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing),
                        getModItem(Natura.ID, "barleyFood", 1, 3, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing),
                        getModItem(Natura.ID, "barleyFood", 1, 3, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(PamsHarvestCraft.ID, "watergarden", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "tropicalgarden", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "leafygarden", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "groundgarden", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "herbgarden", 1, 0, missing) });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "potItem", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", "plateAnyIron", "craftingToolFile", "ringIron", "bucketEmpty",
                        "ringIron", "screwIron", "plateAnyIron", "screwIron" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "potItem", 1, 0, missing),
                new Object[] { "craftingToolFile", "plateAnyIron", "craftingToolHardHammer", "ringIron", "bucketEmpty",
                        "ringIron", "screwIron", "plateAnyIron", "screwIron" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "skilletItem", 1, 0, missing),
                new Object[] { "stickWood", "stickIron", "craftingToolHardHammer", "stickIron", "bucketEmpty",
                        "plateAnyIron", "stickWood", "craftingToolFile", "plateAnyIron" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "skilletItem", 1, 0, missing),
                new Object[] { "stickWood", "stickIron", "craftingToolFile", "stickIron", "bucketEmpty", "plateAnyIron",
                        "stickWood", "craftingToolHardHammer", "plateAnyIron" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "saucepanItem", 1, 0, missing),
                new Object[] { "stickWood", "craftingToolFile", "screwIron", "stickIron", "bucketEmpty", "plateAnyIron",
                        "stickWood", "craftingToolHardHammer", "plateAnyIron" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "saucepanItem", 1, 0, missing),
                new Object[] { "stickWood", "craftingToolHardHammer", "screwIron", "stickIron", "bucketEmpty",
                        "plateAnyIron", "stickWood", "craftingToolFile", "plateAnyIron" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "mixingbowlItem", 1, 0, missing),
                new Object[] { "screwIron", "craftingToolHardHammer", "screwIron", "plateAnyIron", "bucketEmpty",
                        "plateAnyIron", "screwIron", "craftingToolFile", "screwIron" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "mixingbowlItem", 1, 0, missing),
                new Object[] { "screwIron", "craftingToolFile", "screwIron", "plateAnyIron", "bucketEmpty",
                        "plateAnyIron", "screwIron", "craftingToolHardHammer", "screwIron" });
        addShapelessCraftingRecipe(
                getModItem(PamsHarvestCraft.ID, "cuttingboardItem", 1, 0, missing),
                new Object[] { createItemStack(
                        GregTech.ID,
                        "gt.metatool.01",
                        1,
                        36,
                        "{ench:[0:{lvl:3s,id:16s},1:{lvl:3s,id:21s}],GT.ToolStats:{PrimaryMaterial:\"StainlessSteel\",MaxDamage:48000L,SecondaryMaterial:\"StainlessSteel\"}}",
                        missing) });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "mortarandpestleItem", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", "stickStainlessSteel", "craftingToolFile", "stoneGraniteBlack",
                        "stickStainlessSteel", "stoneGraniteBlack", "stoneGraniteBlack", "stoneGraniteBlack",
                        "stoneGraniteBlack" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "bakewareItem", 1, 0, missing),
                new Object[] { "plateStainlessSteel", null, "plateStainlessSteel", "plateStainlessSteel",
                        "craftingToolHardHammer", "plateStainlessSteel", "boltStainlessSteel", "plateStainlessSteel",
                        "boltStainlessSteel" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "juicerItem", 1, 0, missing),
                new Object[] { "plateStainlessSteel", "craftingToolHardHammer", "plateStainlessSteel",
                        "plateStainlessSteel", getModItem(GregTech.ID, "gt.metaitem.02", 1, 8306, missing),
                        "plateStainlessSteel", "boltStainlessSteel", "plateStainlessSteel", "boltStainlessSteel" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "pamcandleDeco1", 4, 0, missing),
                new Object[] { null, getModItem(Minecraft.ID, "string", 1, 0, missing), null, null,
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), null, "dyeWhite",
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), "dyeWhite" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "pamcandleDeco2", 4, 0, missing),
                new Object[] { null, getModItem(Minecraft.ID, "string", 1, 0, missing), null, null,
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), null, "dyeOrange",
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), "dyeOrange" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "pamcandleDeco3", 4, 0, missing),
                new Object[] { null, getModItem(Minecraft.ID, "string", 1, 0, missing), null, null,
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), null, "dyeMagenta",
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), "dyeMagenta" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "pamcandleDeco4", 4, 0, missing),
                new Object[] { null, getModItem(Minecraft.ID, "string", 1, 0, missing), null, null,
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), null, "dyeLightBlue",
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), "dyeLightBlue" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "pamcandleDeco5", 4, 0, missing),
                new Object[] { null, getModItem(Minecraft.ID, "string", 1, 0, missing), null, null,
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), null, "dyeYellow",
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), "dyeYellow" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "pamcandleDeco6", 4, 0, missing),
                new Object[] { null, getModItem(Minecraft.ID, "string", 1, 0, missing), null, null,
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), null, "dyeLime",
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), "dyeLime" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "pamcandleDeco7", 4, 0, missing),
                new Object[] { null, getModItem(Minecraft.ID, "string", 1, 0, missing), null, null,
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), null, "dyePink",
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), "dyePink" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "pamcandleDeco8", 4, 0, missing),
                new Object[] { null, getModItem(Minecraft.ID, "string", 1, 0, missing), null, null,
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), null, "dyeGray",
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), "dyeGray" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "pamcandleDeco9", 4, 0, missing),
                new Object[] { null, getModItem(Minecraft.ID, "string", 1, 0, missing), null, null,
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), null, "dyeLightGray",
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), "dyeLightGray" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "pamcandleDeco10", 4, 0, missing),
                new Object[] { null, getModItem(Minecraft.ID, "string", 1, 0, missing), null, null,
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), null, "dyeCyan",
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), "dyeCyan" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "pamcandleDeco11", 4, 0, missing),
                new Object[] { null, getModItem(Minecraft.ID, "string", 1, 0, missing), null, null,
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), null, "dyePurple",
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), "dyePurple" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "pamcandleDeco12", 4, 0, missing),
                new Object[] { null, getModItem(Minecraft.ID, "string", 1, 0, missing), null, null,
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), null, "dyeBlue",
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), "dyeBlue" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "pamcandleDeco13", 4, 0, missing),
                new Object[] { null, getModItem(Minecraft.ID, "string", 1, 0, missing), null, null,
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), null, "dyeBrown",
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), "dyeBrown" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "pamcandleDeco14", 4, 0, missing),
                new Object[] { null, getModItem(Minecraft.ID, "string", 1, 0, missing), null, null,
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), null, "dyeGreen",
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), "dyeGreen" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "pamcandleDeco15", 4, 0, missing),
                new Object[] { null, getModItem(Minecraft.ID, "string", 1, 0, missing), null, null,
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), null, "dyeRed",
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), "dyeRed" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "pamcandleDeco16", 4, 0, missing),
                new Object[] { null, getModItem(Minecraft.ID, "string", 1, 0, missing), null, null,
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), null, "dyeBlack",
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing), "dyeBlack" });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "hardenedleatherhelmItem", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "craftingToolHardHammer",
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), null, null, null });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "hardenedleatherchestItem", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        "craftingToolHardHammer", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing) });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "hardenedleatherleggingsItem", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "craftingToolHardHammer",
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), null,
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing) });
        addShapedRecipe(
                getModItem(PamsHarvestCraft.ID, "hardenedleatherbootsItem", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), null,
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "craftingToolHardHammer",
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), null, null, null });
        addShapelessCraftingRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.EdibleSalt", 1, 0, missing),
                new Object[] { "toolPot", "listAllwater" });
        addShapelessCraftingRecipe(
                getModItem(PamsHarvestCraft.ID, "soymilkItem", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", "cropSoybean" });
        addShapelessCraftingRecipe(
                getModItem(PamsHarvestCraft.ID, "bubblywaterItem", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32107, missing) });
        addShapelessCraftingRecipe(
                getModItem(PamsHarvestCraft.ID, "freshmilkItem", 4, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "milk_bucket", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(PamsHarvestCraft.ID, "freshmilkItem", 2, 0, missing),
                new Object[] { getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketMilk", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(PamsHarvestCraft.ID, "freshwaterItem", 4, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "water_bucket", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(PamsHarvestCraft.ID, "freshwaterItem", 2, 0, missing),
                new Object[] { getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.WetTofu", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "soybeanItem", 1, 0, missing),
                        getModItem(Minecraft.ID, "water_bucket", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.WetTofu", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "soybeanItem", 1, 0, missing),
                        getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.WetTofu", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "soybeanItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "freshwaterItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "freshwaterItem", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(PamsHarvestCraft.ID, "firmtofuItem", 1, 0, missing),
                new Object[] { "craftingToolSoftHammer",
                        getModItem(NewHorizonsCoreMod.ID, "item.WetTofu", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(PamsHarvestCraft.ID, "silkentofuItem", 1, 0, missing),
                new Object[] { "craftingToolRollingPin",
                        getModItem(PamsHarvestCraft.ID, "firmtofuItem", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(PamsHarvestCraft.ID, "boiledeggItem", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "potItem", 1, 0, missing),
                        getModItem(Minecraft.ID, "egg", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(PamsHarvestCraft.ID, "heavycreamItem", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "bowl", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "soymilkItem", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(PamsHarvestCraft.ID, "heavycreamItem", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "bowl", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "freshmilkItem", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(PamsHarvestCraft.ID, "heavycreamItem", 4, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "bowl", 1, 0, missing),
                        getModItem(Minecraft.ID, "bowl", 1, 0, missing),
                        getModItem(Minecraft.ID, "bowl", 1, 0, missing),
                        getModItem(Minecraft.ID, "bowl", 1, 0, missing),
                        getModItem(Minecraft.ID, "milk_bucket", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(PamsHarvestCraft.ID, "heavycreamItem", 4, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "bowl", 1, 0, missing),
                        getModItem(Minecraft.ID, "bowl", 1, 0, missing),
                        getModItem(Minecraft.ID, "bowl", 1, 0, missing),
                        getModItem(Minecraft.ID, "bowl", 1, 0, missing),
                        getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketMilk", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(PamsHarvestCraft.ID, "heavycreamItem", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "mixingbowlItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "soymilkItem", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(PamsHarvestCraft.ID, "heavycreamItem", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "mixingbowlItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "freshmilkItem", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(PamsHarvestCraft.ID, "heavycreamItem", 4, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "mixingbowlItem", 1, 0, missing),
                        getModItem(Minecraft.ID, "milk_bucket", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(PamsHarvestCraft.ID, "heavycreamItem", 4, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "mixingbowlItem", 1, 0, missing),
                        getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketMilk", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(PamsHarvestCraft.ID, "onionsoupItem", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "potItem", 1, 0, missing), "cropOnion",
                        getModItem(PamsHarvestCraft.ID, "stockItem", 1, 0, missing), "foodCheese" });
        addShapelessCraftingRecipe(
                getModItem(PamsHarvestCraft.ID, "rainbowcurryItem", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "skilletItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "curryItem", 1, 0, missing),
                        getModItem(Minecraft.ID, "bowl", 1, 0, missing),
                        getModItem(Minecraft.ID, "red_flower", 1, 1, missing),
                        getModItem(Minecraft.ID, "tallgrass", 1, 1, missing),
                        getModItem(BiomesOPlenty.ID, "flowers2", 1, 2, missing),
                        getModItem(BiomesOPlenty.ID, "flowers2", 1, 3, missing),
                        getModItem(Minecraft.ID, "red_flower", 1, 0, missing),
                        getModItem(Minecraft.ID, "yellow_flower", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(PamsHarvestCraft.ID, "honeycombchocolatebarItem", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "saucepanItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "chocolatebarItem", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "food", 1, 9, missing) });

        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "silkentofuItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "firmtofuItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "beeswaxItem", 4, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Forestry.ID, "beeswax", 4, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "soybeanItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "soymilkItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "food", 1, 9, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "honeyItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "apple", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "applejuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraTrees.ID, "food", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "applejuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "melon", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "melonjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "carrot", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "carrotjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "food", 2, 2, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "carrotjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "strawberryItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "strawberryjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 32554, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "grapejuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "grapeItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "grapejuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraTrees.ID, "food", 1, 45, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "blueberryjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "blueberryItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "blueberryjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "berry", 1, 1, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "blueberryjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraTrees.ID, "food", 1, 5, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "cherryjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "cherryItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "cherryjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Forestry.ID, "fruits", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "cherryjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraTrees.ID, "food", 1, 43, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "blackberryjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "blackberryItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "blackberryjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "berry", 1, 2, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "blackberryjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "raspberryItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "raspberryjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraTrees.ID, "food", 1, 44, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "raspberryjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "berry", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "raspberryjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Forestry.ID, "fruits", 1, 6, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "papayajuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "papayaItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "papayajuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraTrees.ID, "food", 1, 58, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "starfruitjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "starfruitItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "starfruitjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "pomegranateItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "pomegranatejuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraTrees.ID, "food", 1, 57, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "mangojuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "mangoItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "mangojuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "limeItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "limejuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraTrees.ID, "food", 1, 3, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "limejuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraTrees.ID, "food", 1, 17, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "limejuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "orangeItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "orangejuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraTrees.ID, "food", 1, 1, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "orangejuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "food", 1, 3, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "peachjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraTrees.ID, "food", 1, 12, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "peachjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "peachItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "peachjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "kiwiItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "kiwijuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraTrees.ID, "food", 1, 46, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "cranberryjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "cranberryItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "cranberryjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "cactusfruitItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "cactusfruitjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "plumItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "plumjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraTrees.ID, "food", 1, 8, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "plumjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Forestry.ID, "fruits", 1, 4, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "plumjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "pearItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "pearjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "food", 1, 12, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "pearjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraTrees.ID, "food", 1, 22, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "pearjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraTrees.ID, "food", 1, 23, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "pearjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraTrees.ID, "food", 1, 10, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "apricotjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "apricotItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "apricotjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "persimmonItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "persimmonjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "food", 1, 8, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "persimmonjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraTrees.ID, "food", 1, 11, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "grapefruitjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "grapefruitItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "grapefruitjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraTrees.ID, "food", 1, 32, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "figjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "figItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "figjuiceItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraTrees.ID, "food", 1, 35, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "oliveoilItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "oliveItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "oliveoilItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "sunflowerseedsItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "oliveoilItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "walnutItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "oliveoilItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Forestry.ID, "fruits", 1, 1, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "oliveoilItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "waxcombItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "beeswaxItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "candleberryItem", 4, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "beeswaxItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "egg", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "mayoItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "tomatoItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "ketchupItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 32552, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "ketchupItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "peanutItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "peanutbutterItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "mustardseedsItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "mustardItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "almondItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "almondbutterItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraTrees.ID, "food", 1, 9, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "almondbutterItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "cashewItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "cashewbutterItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraTrees.ID, "food", 1, 51, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "cashewbutterItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "chestnutItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "chestnutbutterItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Forestry.ID, "fruits", 1, 2, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "chestnutbutterItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "pistachioItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "pistachiobutterItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);

        GT_ModHandler.addSmeltingRecipe(
                getModItem(PamsHarvestCraft.ID, "venisonrawItem", 1, 0, missing),
                getModItem(PamsHarvestCraft.ID, "venisoncookedItem", 1, 0, missing));
        GT_ModHandler.addSmeltingRecipe(
                getModItem(PamsHarvestCraft.ID, "turkeyrawItem", 1, 0, missing),
                getModItem(PamsHarvestCraft.ID, "turkeycookedItem", 1, 0, missing));
        GT_ModHandler.addSmeltingRecipe(
                getModItem(PamsHarvestCraft.ID, "rabbitrawItem", 1, 0, missing),
                getModItem(PamsHarvestCraft.ID, "rabbitcookedItem", 1, 0, missing));
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.WetTofu", 1, 0, missing))
                .itemOutputs(
                        getModItem(PamsHarvestCraft.ID, "silkentofuItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "silkentofuItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "soymilkItem", 1, 0, missing))
                .outputChances(10000, 5000, 5000).noFluidInputs().noFluidOutputs().duration(200).eut(8)
                .addTo(sCentrifugeRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Backpack.ID, "tannedLeather", 2, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "cornItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "cornmealItem", 1, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "freshmilkItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "heavycreamItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "heavycreamItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 817, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "butterItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "melon", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "melonsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "strawberryItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "strawberrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "lemonItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "lemonsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32551, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "lemonsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "blueberryItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "blueberrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "berry", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "blueberrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "cherryItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "cherrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "food", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "cherrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "food", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "cherrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "food", 1, 6, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "cherrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "starfruitItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "starfruitsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "bananaItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "bananasmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "food", 1, 28, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "bananasmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "food", 1, 29, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "bananasmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "orangeItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "orangesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "food", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "orangesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "food", 1, 18, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "orangesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "food", 1, 13, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "orangesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "food", 1, 21, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "orangesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "papayaItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "papayasmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "fruits", 1, 6, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "papayasmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "peachItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "peachsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "food", 1, 12, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "peachsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "food", 1, 3, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "peachsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "limeItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "limesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "food", 1, 3, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "limesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "food", 1, 17, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "limesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "food", 1, 16, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "limesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "mangoItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "mangosmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "food", 1, 57, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "mangosmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "pomegranateItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "pomegranatesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "blackberryItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "blackberrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "berry", 1, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "blackberrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "food", 1, 43, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "blackberrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "raspberryItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "raspberrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "berry", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "raspberrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "food", 1, 44, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "raspberrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "kiwiItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "kiwismoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "apricotItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "apricotsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "food", 1, 10, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "apricotsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "grapefruitItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "grapefruitsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "food", 1, 11, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "grapefruitsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "persimmonItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "persimmonsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "food", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "persimmonsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "gooseberryItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "gooseberrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "food", 1, 48, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "gooseberrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "apple", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "applesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "food", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "applesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "coconutItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "coconutsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "food", 1, 50, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "coconutsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "cranberryItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "cranberrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "food", 1, 46, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "cranberrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "grapeItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "grapesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32554, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "grapesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "pearItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "pearsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "food", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "pearsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "food", 1, 12, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "pearsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "food", 1, 23, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "pearsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "plumItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "plumsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "fruits", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "plumsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "food", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "plumsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "figItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "figsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "food", 1, 32, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "figsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "oliveoilItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "vinegarItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 817, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "saladdressingItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);

    }
}
