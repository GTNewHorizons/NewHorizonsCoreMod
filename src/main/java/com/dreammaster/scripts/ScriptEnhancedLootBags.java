package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

public class ScriptEnhancedLootBags implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Enhanced Loot Bags";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList("enhancedlootbags");
    }

    @Override
    public void loadRecipes() {
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        1,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 1, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("minecraft", "clay_ball", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        2,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 2, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("IC2", "itemHarz", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        4,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 4, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        5,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 5, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        6,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 6, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        7,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 7, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32603, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        8,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 8, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32604, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        9,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 9, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 1, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        10,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 10, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemBathSalts", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        11,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 11, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("Thaumcraft", "WandCap", 1, 7, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        12,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 12, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemEldritchObject", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        13,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 13, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("ThaumicTinkerer", "warpGate", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        14,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 14, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("DraconicEvolution", "draconicCore", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        15,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 15, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("minecraft", "dragon_egg", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        16,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 16, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("AWWayofTime", "simpleCatalyst", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        17,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 17, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        18,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 18, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("AWWayofTime", "blockTeleposer", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        19,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 19, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("Forestry", "waxCapsule", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        20,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 20, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("Forestry", "craftingMaterial", 1, 6, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        21,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 21, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("Forestry", "hardenedMachine", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        22,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 22, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("GalacticraftCore", "item.airFan", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        23,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 23, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1, 7, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        24,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 24, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("dreamcraft", "item.WaferTier3", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        25,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 25, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("Forestry", "propolis", 1, 3, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        26,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 26, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("Forestry", "royalJelly", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        27,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 27, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("gendustry", "MutagenBucket", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        28,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 28, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("minecraft", "cake", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        29,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 29, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32243, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        30,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 30, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("harvestcraft", "delightedmealItem", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        31,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 31, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("DraconicEvolution", "dezilsMarshmallow", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        32,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 32, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("minecraft", "minecart", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        33,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 33, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        createItemStack("Railcraft", "track", 1, 816, "{track:\"railcraft:track.speed\"}", missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        34,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 34, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        createItemStack(
                                "Railcraft",
                                "cart.loco.electric",
                                1,
                                0,
                                "{model:\"railcraft:default\"}",
                                missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        35,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 35, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("IC2", "itemCropSeed", 1, 32767, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        36,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 36, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("harvestcraft", "beefwellingtonItem", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        37,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 37, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("dreamcraft", "item.LogicProcessorItemGoldCore", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        38,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 38, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("dreamcraft", "item.EngineeringProcessorItemDiamondCore", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        39,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 38, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("dreamcraft", "item.EngineeringProcessorItemEmeraldCore", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        40,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 38, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("dreamcraft", "item.EngineeringProcessorItemAdvEmeraldCore", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        41,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 41, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32606, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        42,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 42, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32607, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        43,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 43, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32608, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        44,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 44, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32609, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        45,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 45, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("OpenComputers", "eeprom", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        46,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 46, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("OpenComputers", "item", 1, 1, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        47,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 47, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("OpenComputers", "item", 1, 2, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        48,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 48, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("OpenComputers", "item", 1, 38, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        49,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 49, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("OpenComputers", "item", 1, 39, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        50,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 50, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("OpenComputers", "item", 1, 69, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        51,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 51, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 341, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        52,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 52, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("witchery", "witchleaves", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        53,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 53, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("witchery", "ingredient", 1, 95, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        54,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 54, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("witchery", "ingredient", 1, 11, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        55,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 55, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("witchery", "ingredient", 1, 96, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        56,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 56, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("witchery", "leonardsurn", 1, 3, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        57,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 57, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "enderman_head", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        "enhancedlootbags",
                        "lootbag",
                        1,
                        58,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem("enhancedlootbags", "lootbag", 1, 58, missing),
                        getModItem("minecraft", "enchanted_book", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "rune", 1, 5, missing) });

    }
}
