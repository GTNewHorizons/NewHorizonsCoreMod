package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.*;

import java.util.Arrays;
import java.util.List;

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
        return Arrays.asList(Mods.PamsHarvestCraft.ID, Mods.ExtraTrees.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("harvestcraft", "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem("Natura", "trapdoor.eucalyptus", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "chestWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("harvestcraft", "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem("Natura", "trapdoor.sakura", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "chestWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("harvestcraft", "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem("Natura", "trapdoor.ghostwood", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "chestWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("harvestcraft", "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem("Natura", "trapdoor.redwood", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "chestWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("harvestcraft", "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem("Natura", "trapdoor.bloodwood", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "chestWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("harvestcraft", "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem("Natura", "trapdoor.hopseed", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "chestWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("harvestcraft", "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem("Natura", "trapdoor.maple", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "chestWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("harvestcraft", "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem("Natura", "trapdoor.amaranth", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "chestWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("harvestcraft", "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem("Natura", "trapdoor.silverbell", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "chestWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("harvestcraft", "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem("Natura", "trapdoor.tiger", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "chestWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("harvestcraft", "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem("Natura", "trapdoor.willow", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "chestWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("harvestcraft", "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem("Natura", "trapdoor.darkwood", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "chestWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("harvestcraft", "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem("Natura", "trapdoor.fusewood", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "chestWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("harvestcraft", "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem("malisisdoors", "trapdoor_acacia", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "chestWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("harvestcraft", "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem("malisisdoors", "trapdoor_birch", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "chestWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("harvestcraft", "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem("malisisdoors", "trapdoor_dark_oak", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "chestWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("harvestcraft", "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem("malisisdoors", "trapdoor_jungle", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "chestWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("harvestcraft", "animaltrap", 1, 0, missing),
                new Object[] { "stickWood", getModItem("malisisdoors", "trapdoor_spruce", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "chestWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("harvestcraft", "wovencottonItem", 1, 0, missing),
                new Object[] { getModItem("minecraft", "string", 1, 0, missing),
                        getModItem("Natura", "barleyFood", 1, 3, missing),
                        getModItem("minecraft", "string", 1, 0, missing),
                        getModItem("Natura", "barleyFood", 1, 3, missing),
                        getModItem("minecraft", "string", 1, 0, missing),
                        getModItem("Natura", "barleyFood", 1, 3, missing),
                        getModItem("minecraft", "string", 1, 0, missing),
                        getModItem("Natura", "barleyFood", 1, 3, missing),
                        getModItem("minecraft", "string", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("harvestcraft", "watergarden", 1, 0, missing),
                new Object[] { getModItem("harvestcraft", "tropicalgarden", 1, 0, missing),
                        getModItem("harvestcraft", "leafygarden", 1, 0, missing),
                        getModItem("harvestcraft", "groundgarden", 1, 0, missing),
                        getModItem("harvestcraft", "herbgarden", 1, 0, missing) });
        addShapedRecipe(
                getModItem("harvestcraft", "potItem", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", "plateAnyIron", "craftingToolFile", "ringIron", "bucketEmpty",
                        "ringIron", "screwIron", "plateAnyIron", "screwIron" });
        addShapedRecipe(
                getModItem("harvestcraft", "potItem", 1, 0, missing),
                new Object[] { "craftingToolFile", "plateAnyIron", "craftingToolHardHammer", "ringIron", "bucketEmpty",
                        "ringIron", "screwIron", "plateAnyIron", "screwIron" });
        addShapedRecipe(
                getModItem("harvestcraft", "skilletItem", 1, 0, missing),
                new Object[] { "stickWood", "stickIron", "craftingToolHardHammer", "stickIron", "bucketEmpty",
                        "plateAnyIron", "stickWood", "craftingToolFile", "plateAnyIron" });
        addShapedRecipe(
                getModItem("harvestcraft", "skilletItem", 1, 0, missing),
                new Object[] { "stickWood", "stickIron", "craftingToolFile", "stickIron", "bucketEmpty", "plateAnyIron",
                        "stickWood", "craftingToolHardHammer", "plateAnyIron" });
        addShapedRecipe(
                getModItem("harvestcraft", "saucepanItem", 1, 0, missing),
                new Object[] { "stickWood", "craftingToolFile", "screwIron", "stickIron", "bucketEmpty", "plateAnyIron",
                        "stickWood", "craftingToolHardHammer", "plateAnyIron" });
        addShapedRecipe(
                getModItem("harvestcraft", "saucepanItem", 1, 0, missing),
                new Object[] { "stickWood", "craftingToolHardHammer", "screwIron", "stickIron", "bucketEmpty",
                        "plateAnyIron", "stickWood", "craftingToolFile", "plateAnyIron" });
        addShapedRecipe(
                getModItem("harvestcraft", "mixingbowlItem", 1, 0, missing),
                new Object[] { "screwIron", "craftingToolHardHammer", "screwIron", "plateAnyIron", "bucketEmpty",
                        "plateAnyIron", "screwIron", "craftingToolFile", "screwIron" });
        addShapedRecipe(
                getModItem("harvestcraft", "mixingbowlItem", 1, 0, missing),
                new Object[] { "screwIron", "craftingToolFile", "screwIron", "plateAnyIron", "bucketEmpty",
                        "plateAnyIron", "screwIron", "craftingToolHardHammer", "screwIron" });
        addShapelessCraftingRecipe(
                getModItem("harvestcraft", "cuttingboardItem", 1, 0, missing),
                new Object[] { createItemStack(
                        "gregtech",
                        "gt.metatool.01",
                        1,
                        36,
                        "{ench:[0:{lvl:3s,id:16s},1:{lvl:3s,id:21s}],GT.ToolStats:{PrimaryMaterial:\"StainlessSteel\",MaxDamage:48000L,SecondaryMaterial:\"StainlessSteel\"}}",
                        missing) });
        addShapedRecipe(
                getModItem("harvestcraft", "mortarandpestleItem", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", "stickStainlessSteel", "craftingToolFile", "stoneGraniteBlack",
                        "stickStainlessSteel", "stoneGraniteBlack", "stoneGraniteBlack", "stoneGraniteBlack",
                        "stoneGraniteBlack" });
        addShapedRecipe(
                getModItem("harvestcraft", "bakewareItem", 1, 0, missing),
                new Object[] { "plateStainlessSteel", null, "plateStainlessSteel", "plateStainlessSteel",
                        "craftingToolHardHammer", "plateStainlessSteel", "boltStainlessSteel", "plateStainlessSteel",
                        "boltStainlessSteel" });
        addShapedRecipe(
                getModItem("harvestcraft", "juicerItem", 1, 0, missing),
                new Object[] { "plateStainlessSteel", "craftingToolHardHammer", "plateStainlessSteel",
                        "plateStainlessSteel", getModItem("gregtech", "gt.metaitem.02", 1, 8306, missing),
                        "plateStainlessSteel", "boltStainlessSteel", "plateStainlessSteel", "boltStainlessSteel" });
        addShapedRecipe(
                getModItem("harvestcraft", "pamcandleDeco1", 4, 0, missing),
                new Object[] { null, getModItem("minecraft", "string", 1, 0, missing), null, null,
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), null, "dyeWhite",
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), "dyeWhite" });
        addShapedRecipe(
                getModItem("harvestcraft", "pamcandleDeco2", 4, 0, missing),
                new Object[] { null, getModItem("minecraft", "string", 1, 0, missing), null, null,
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), null, "dyeOrange",
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), "dyeOrange" });
        addShapedRecipe(
                getModItem("harvestcraft", "pamcandleDeco3", 4, 0, missing),
                new Object[] { null, getModItem("minecraft", "string", 1, 0, missing), null, null,
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), null, "dyeMagenta",
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), "dyeMagenta" });
        addShapedRecipe(
                getModItem("harvestcraft", "pamcandleDeco4", 4, 0, missing),
                new Object[] { null, getModItem("minecraft", "string", 1, 0, missing), null, null,
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), null, "dyeLightBlue",
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), "dyeLightBlue" });
        addShapedRecipe(
                getModItem("harvestcraft", "pamcandleDeco5", 4, 0, missing),
                new Object[] { null, getModItem("minecraft", "string", 1, 0, missing), null, null,
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), null, "dyeYellow",
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), "dyeYellow" });
        addShapedRecipe(
                getModItem("harvestcraft", "pamcandleDeco6", 4, 0, missing),
                new Object[] { null, getModItem("minecraft", "string", 1, 0, missing), null, null,
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), null, "dyeLime",
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), "dyeLime" });
        addShapedRecipe(
                getModItem("harvestcraft", "pamcandleDeco7", 4, 0, missing),
                new Object[] { null, getModItem("minecraft", "string", 1, 0, missing), null, null,
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), null, "dyePink",
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), "dyePink" });
        addShapedRecipe(
                getModItem("harvestcraft", "pamcandleDeco8", 4, 0, missing),
                new Object[] { null, getModItem("minecraft", "string", 1, 0, missing), null, null,
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), null, "dyeGray",
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), "dyeGray" });
        addShapedRecipe(
                getModItem("harvestcraft", "pamcandleDeco9", 4, 0, missing),
                new Object[] { null, getModItem("minecraft", "string", 1, 0, missing), null, null,
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), null, "dyeLightGray",
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), "dyeLightGray" });
        addShapedRecipe(
                getModItem("harvestcraft", "pamcandleDeco10", 4, 0, missing),
                new Object[] { null, getModItem("minecraft", "string", 1, 0, missing), null, null,
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), null, "dyeCyan",
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), "dyeCyan" });
        addShapedRecipe(
                getModItem("harvestcraft", "pamcandleDeco11", 4, 0, missing),
                new Object[] { null, getModItem("minecraft", "string", 1, 0, missing), null, null,
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), null, "dyePurple",
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), "dyePurple" });
        addShapedRecipe(
                getModItem("harvestcraft", "pamcandleDeco12", 4, 0, missing),
                new Object[] { null, getModItem("minecraft", "string", 1, 0, missing), null, null,
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), null, "dyeBlue",
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), "dyeBlue" });
        addShapedRecipe(
                getModItem("harvestcraft", "pamcandleDeco13", 4, 0, missing),
                new Object[] { null, getModItem("minecraft", "string", 1, 0, missing), null, null,
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), null, "dyeBrown",
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), "dyeBrown" });
        addShapedRecipe(
                getModItem("harvestcraft", "pamcandleDeco14", 4, 0, missing),
                new Object[] { null, getModItem("minecraft", "string", 1, 0, missing), null, null,
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), null, "dyeGreen",
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), "dyeGreen" });
        addShapedRecipe(
                getModItem("harvestcraft", "pamcandleDeco15", 4, 0, missing),
                new Object[] { null, getModItem("minecraft", "string", 1, 0, missing), null, null,
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), null, "dyeRed",
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), "dyeRed" });
        addShapedRecipe(
                getModItem("harvestcraft", "pamcandleDeco16", 4, 0, missing),
                new Object[] { null, getModItem("minecraft", "string", 1, 0, missing), null, null,
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), null, "dyeBlack",
                        getModItem("harvestcraft", "waxItem", 1, 0, missing), "dyeBlack" });
        addShapedRecipe(
                getModItem("harvestcraft", "hardenedleatherhelmItem", 1, 0, missing),
                new Object[] { getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "craftingToolHardHammer",
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), null, null, null });
        addShapedRecipe(
                getModItem("harvestcraft", "hardenedleatherchestItem", 1, 0, missing),
                new Object[] { getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        "craftingToolHardHammer", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing) });
        addShapedRecipe(
                getModItem("harvestcraft", "hardenedleatherleggingsItem", 1, 0, missing),
                new Object[] { getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "craftingToolHardHammer",
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), null,
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing) });
        addShapedRecipe(
                getModItem("harvestcraft", "hardenedleatherbootsItem", 1, 0, missing),
                new Object[] { getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), null,
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "craftingToolHardHammer",
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), null, null, null });
        addShapelessCraftingRecipe(
                getModItem("dreamcraft", "item.EdibleSalt", 1, 0, missing),
                new Object[] { "toolPot", "listAllwater" });
        addShapelessCraftingRecipe(
                getModItem("harvestcraft", "soymilkItem", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", "cropSoybean" });
        addShapelessCraftingRecipe(
                getModItem("harvestcraft", "bubblywaterItem", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32107, missing) });
        addShapelessCraftingRecipe(
                getModItem("harvestcraft", "freshmilkItem", 4, 0, missing),
                new Object[] { getModItem("minecraft", "milk_bucket", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("harvestcraft", "freshmilkItem", 2, 0, missing),
                new Object[] { getModItem("IguanaTweaksTConstruct", "clayBucketMilk", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("harvestcraft", "freshwaterItem", 4, 0, missing),
                new Object[] { getModItem("minecraft", "water_bucket", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("harvestcraft", "freshwaterItem", 2, 0, missing),
                new Object[] { getModItem("IguanaTweaksTConstruct", "clayBucketWater", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("dreamcraft", "item.WetTofu", 1, 0, missing),
                new Object[] { getModItem("harvestcraft", "soybeanItem", 1, 0, missing),
                        getModItem("minecraft", "water_bucket", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("dreamcraft", "item.WetTofu", 1, 0, missing),
                new Object[] { getModItem("harvestcraft", "soybeanItem", 1, 0, missing),
                        getModItem("IguanaTweaksTConstruct", "clayBucketWater", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("dreamcraft", "item.WetTofu", 1, 0, missing),
                new Object[] { getModItem("harvestcraft", "soybeanItem", 1, 0, missing),
                        getModItem("harvestcraft", "freshwaterItem", 1, 0, missing),
                        getModItem("harvestcraft", "freshwaterItem", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("harvestcraft", "firmtofuItem", 1, 0, missing),
                new Object[] { "craftingToolSoftHammer", getModItem("dreamcraft", "item.WetTofu", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("harvestcraft", "silkentofuItem", 1, 0, missing),
                new Object[] { "craftingToolRollingPin", getModItem("harvestcraft", "firmtofuItem", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("harvestcraft", "boiledeggItem", 1, 0, missing),
                new Object[] { getModItem("harvestcraft", "potItem", 1, 0, missing),
                        getModItem("minecraft", "egg", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("harvestcraft", "heavycreamItem", 1, 0, missing),
                new Object[] { getModItem("minecraft", "bowl", 1, 0, missing),
                        getModItem("harvestcraft", "soymilkItem", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("harvestcraft", "heavycreamItem", 1, 0, missing),
                new Object[] { getModItem("minecraft", "bowl", 1, 0, missing),
                        getModItem("harvestcraft", "freshmilkItem", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("harvestcraft", "heavycreamItem", 4, 0, missing),
                new Object[] { getModItem("minecraft", "bowl", 1, 0, missing),
                        getModItem("minecraft", "bowl", 1, 0, missing), getModItem("minecraft", "bowl", 1, 0, missing),
                        getModItem("minecraft", "bowl", 1, 0, missing),
                        getModItem("minecraft", "milk_bucket", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("harvestcraft", "heavycreamItem", 4, 0, missing),
                new Object[] { getModItem("minecraft", "bowl", 1, 0, missing),
                        getModItem("minecraft", "bowl", 1, 0, missing), getModItem("minecraft", "bowl", 1, 0, missing),
                        getModItem("minecraft", "bowl", 1, 0, missing),
                        getModItem("IguanaTweaksTConstruct", "clayBucketMilk", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("harvestcraft", "heavycreamItem", 1, 0, missing),
                new Object[] { getModItem("harvestcraft", "mixingbowlItem", 1, 0, missing),
                        getModItem("harvestcraft", "soymilkItem", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("harvestcraft", "heavycreamItem", 1, 0, missing),
                new Object[] { getModItem("harvestcraft", "mixingbowlItem", 1, 0, missing),
                        getModItem("harvestcraft", "freshmilkItem", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("harvestcraft", "heavycreamItem", 4, 0, missing),
                new Object[] { getModItem("harvestcraft", "mixingbowlItem", 1, 0, missing),
                        getModItem("minecraft", "milk_bucket", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("harvestcraft", "heavycreamItem", 4, 0, missing),
                new Object[] { getModItem("harvestcraft", "mixingbowlItem", 1, 0, missing),
                        getModItem("IguanaTweaksTConstruct", "clayBucketMilk", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("harvestcraft", "onionsoupItem", 1, 0, missing),
                new Object[] { getModItem("harvestcraft", "potItem", 1, 0, missing), "cropOnion",
                        getModItem("harvestcraft", "stockItem", 1, 0, missing), "foodCheese" });
        addShapelessCraftingRecipe(
                getModItem("harvestcraft", "rainbowcurryItem", 1, 0, missing),
                new Object[] { getModItem("harvestcraft", "skilletItem", 1, 0, missing),
                        getModItem("harvestcraft", "curryItem", 1, 0, missing),
                        getModItem("minecraft", "bowl", 1, 0, missing),
                        getModItem("minecraft", "red_flower", 1, 1, missing),
                        getModItem("minecraft", "tallgrass", 1, 1, missing),
                        getModItem("BiomesOPlenty", "flowers2", 1, 2, missing),
                        getModItem("BiomesOPlenty", "flowers2", 1, 3, missing),
                        getModItem("minecraft", "red_flower", 1, 0, missing),
                        getModItem("minecraft", "yellow_flower", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("harvestcraft", "honeycombchocolatebarItem", 1, 0, missing),
                new Object[] { getModItem("harvestcraft", "saucepanItem", 1, 0, missing),
                        getModItem("harvestcraft", "chocolatebarItem", 1, 0, missing),
                        getModItem("BiomesOPlenty", "food", 1, 9, missing) });

        GT_ModHandler.addSmeltingRecipe(
                getModItem("harvestcraft", "venisonrawItem", 1, 0, missing),
                getModItem("harvestcraft", "venisoncookedItem", 1, 0, missing));
        GT_ModHandler.addSmeltingRecipe(
                getModItem("harvestcraft", "turkeyrawItem", 1, 0, missing),
                getModItem("harvestcraft", "turkeycookedItem", 1, 0, missing));
        GT_ModHandler.addSmeltingRecipe(
                getModItem("harvestcraft", "rabbitrawItem", 1, 0, missing),
                getModItem("harvestcraft", "rabbitcookedItem", 1, 0, missing));
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.WetTofu", 1, 0, missing))
                .itemOutputs(
                        getModItem("harvestcraft", "silkentofuItem", 1, 0, missing),
                        getModItem("harvestcraft", "silkentofuItem", 1, 0, missing),
                        getModItem("harvestcraft", "soymilkItem", 1, 0, missing))
                .outputChances(10000, 5000, 5000).noFluidInputs().noFluidOutputs().duration(200).eut(8)
                .addTo(sCentrifugeRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Backpack", "tannedLeather", 2, 0, missing),
                        getModItem("harvestcraft", "waxItem", 1, 0, missing))
                .itemOutputs(getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("harvestcraft", "cornItem", 1, 0, missing))
                .itemOutputs(getModItem("harvestcraft", "cornmealItem", 1, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("harvestcraft", "freshmilkItem", 1, 0, missing))
                .itemOutputs(getModItem("harvestcraft", "heavycreamItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "heavycreamItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 817, missing))
                .itemOutputs(getModItem("harvestcraft", "butterItem", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "melon", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "melonsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "strawberryItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "strawberrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "lemonItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "lemonsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.02", 1, 32551, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "lemonsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "blueberryItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "blueberrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "berry", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "blueberrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "cherryItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "cherrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "food", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "cherrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "food", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "cherrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "food", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "cherrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "starfruitItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "starfruitsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "bananaItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "bananasmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "food", 1, 28, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "bananasmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "food", 1, 29, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "bananasmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "orangeItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "orangesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "food", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "orangesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "food", 1, 18, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "orangesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "food", 1, 13, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "orangesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "food", 1, 21, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "orangesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "papayaItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "papayasmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "fruits", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "papayasmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "peachItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "peachsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "food", 1, 12, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "peachsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "food", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "peachsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "limeItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "limesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "food", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "limesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "food", 1, 17, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "limesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "food", 1, 16, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "limesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "mangoItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "mangosmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "food", 1, 57, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "mangosmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "pomegranateItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "pomegranatesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "blackberryItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "blackberrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "berry", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "blackberrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "food", 1, 43, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "blackberrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "raspberryItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "raspberrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "berry", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "raspberrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "food", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "raspberrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "kiwiItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "kiwismoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "apricotItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "apricotsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "food", 1, 10, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "apricotsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "grapefruitItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "grapefruitsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "food", 1, 11, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "grapefruitsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "persimmonItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "persimmonsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "food", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "persimmonsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "gooseberryItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "gooseberrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "food", 1, 48, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "gooseberrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "apple", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "applesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "food", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "applesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "coconutItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "coconutsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "food", 1, 50, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "coconutsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "cranberryItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "cranberrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "food", 1, 46, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "cranberrysmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "grapeItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "grapesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.02", 1, 32554, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "grapesmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "pearItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "pearsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "food", 1, 22, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "pearsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "food", 1, 12, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "pearsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "food", 1, 23, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "pearsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "plumItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "plumsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "fruits", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "plumsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "food", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "plumsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "figItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "figsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "food", 1, 32, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing))
                .itemOutputs(getModItem("harvestcraft", "figsmoothieItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "oliveoilItem", 1, 0, missing),
                        getModItem("harvestcraft", "vinegarItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 817, missing))
                .itemOutputs(getModItem("harvestcraft", "saladdressingItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(2).addTo(sMixerRecipes);

    }
}
