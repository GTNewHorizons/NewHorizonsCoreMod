package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.MineAndBladeBattleGear2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TinkersGregworks;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

public class ScriptBattleGear implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Mine and Blade Battle Gear 2";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(MineAndBladeBattleGear2.ID, Backpack.ID, TinkerConstruct.ID, TinkersGregworks.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "shield.wood", 1, 0, missing),
                new Object[] { "itemFlint", "logWood", "itemFlint", "logWood", "stoneCobble", "logWood", "itemFlint",
                        "logWood", "itemFlint" });
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "shield.hide", 1, 0, missing),
                new Object[] { "itemFlint", "itemLeather", "itemFlint", "itemLeather",
                        getModItem(MineAndBladeBattleGear2.ID, "shield.wood", 1, 0, missing), "itemLeather",
                        "itemFlint", "itemLeather", "itemFlint" });
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "shield.iron", 1, 0, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "heavyPlate", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "toughBinding", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 2, missing), "craftingToolHardHammer",
                        getModItem(TinkerConstruct.ID, "toughRod", 1, 2, missing), "craftingToolFile", null,
                        getModItem(TinkerConstruct.ID, "toughRod", 1, 2, missing), null });
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "shield.gold", 1, 0, missing),
                new Object[] {
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartLargePlate",
                                1,
                                1505,
                                "{material:\"Gold\"}",
                                missing),
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartToughBind",
                                1,
                                1505,
                                "{material:\"Gold\"}",
                                missing),
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartLargePlate",
                                1,
                                1505,
                                "{material:\"Gold\"}",
                                missing),
                        "craftingToolHardHammer",
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartToughRod",
                                1,
                                1505,
                                "{material:\"Gold\"}",
                                missing),
                        "craftingToolFile", null,
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartToughRod",
                                1,
                                1505,
                                "{material:\"Gold\"}",
                                missing),
                        null });
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "shield.diamond", 1, 0, missing),
                new Object[] {
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartLargePlate",
                                1,
                                1594,
                                "{material:\"Diamond\"}",
                                missing),
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartToughBind",
                                1,
                                1594,
                                "{material:\"Diamond\"}",
                                missing),
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartLargePlate",
                                1,
                                1594,
                                "{material:\"Diamond\"}",
                                missing),
                        "craftingToolHardHammer",
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartToughRod",
                                1,
                                1594,
                                "{material:\"Diamond\"}",
                                missing),
                        "craftingToolFile", null,
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartToughRod",
                                1,
                                1594,
                                "{material:\"Diamond\"}",
                                missing),
                        null });
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "dagger.wood", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing), "craftingToolFile", null,
                        "stickWood", "craftingToolHardHammer", null });
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "dagger.stone", 1, 0, missing),
                new Object[] { "plateStone", "craftingToolFile", null, "stickWood", "craftingToolHardHammer", null });
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "dagger.iron", 1, 0, missing),
                new Object[] { "plateAnyIron", "craftingToolFile", null, "stickWood", "craftingToolHardHammer", null });
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "dagger.diamond", 1, 0, missing),
                new Object[] { "plateDiamond", "craftingToolFile", null, "stickWood", "craftingToolHardHammer", null });
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "spear.wood", 1, 0, missing),
                new Object[] { null, getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "itemLeather",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "spear.stone", 1, 0, missing),
                new Object[] { "screwAnyIron", getModItem(TinkerConstruct.ID, "arrowhead", 1, 1, missing), null,
                        getModItem(MineAndBladeBattleGear2.ID, "spear.wood", 1, 0, missing), "screwAnyIron", null,
                        "craftingToolSaw", "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "spear.iron", 1, 0, missing),
                new Object[] { "screwSteel", getModItem(TinkerConstruct.ID, "arrowhead", 1, 2, missing), null,
                        getModItem(MineAndBladeBattleGear2.ID, "spear.wood", 1, 0, missing), "screwSteel", null,
                        "craftingToolSaw", "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "spear.gold", 1, 0, missing),
                new Object[] { "screwAluminium",
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartArrowHead",
                                1,
                                1505,
                                "{material:\"Gold\"}",
                                missing),
                        null, getModItem(MineAndBladeBattleGear2.ID, "spear.wood", 1, 0, missing), "screwAluminium",
                        null, "craftingToolSaw", "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "spear.diamond", 1, 0, missing),
                new Object[] { "screwStainlessSteel",
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartArrowHead",
                                1,
                                1594,
                                "{material:\"Diamond\"}",
                                missing),
                        null, getModItem(MineAndBladeBattleGear2.ID, "spear.wood", 1, 0, missing),
                        "screwStainlessSteel", null, "craftingToolSaw", "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "waraxe.wood", 1, 0, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "hatchetHead", 1, 0, missing), "craftingToolSoftHammer",
                        getModItem(TinkerConstruct.ID, "hatchetHead", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "hatchetHead", 1, 0, missing), "stickWood",
                        getModItem(TinkerConstruct.ID, "hatchetHead", 1, 0, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "waraxe.stone", 1, 0, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "hatchetHead", 1, 1, missing), "craftingToolScrewdriver",
                        getModItem(TinkerConstruct.ID, "hatchetHead", 1, 1, missing),
                        getModItem(TinkerConstruct.ID, "hatchetHead", 1, 1, missing), "stickWood",
                        getModItem(TinkerConstruct.ID, "hatchetHead", 1, 1, missing), "screwAnyIron", "stickWood",
                        "screwAnyIron" });
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "waraxe.iron", 1, 0, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "hatchetHead", 1, 2, missing), "craftingToolScrewdriver",
                        getModItem(TinkerConstruct.ID, "hatchetHead", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "hatchetHead", 1, 2, missing), "stickWood",
                        getModItem(TinkerConstruct.ID, "hatchetHead", 1, 2, missing), "screwSteel", "stickWood",
                        "screwSteel" });
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "waraxe.gold", 1, 0, missing),
                new Object[] {
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartAxeHead",
                                1,
                                1505,
                                "{material:\"Gold\"}",
                                missing),
                        "craftingToolScrewdriver",
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartAxeHead",
                                1,
                                1505,
                                "{material:\"Gold\"}",
                                missing),
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartAxeHead",
                                1,
                                1505,
                                "{material:\"Gold\"}",
                                missing),
                        "stickWood",
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartAxeHead",
                                1,
                                1505,
                                "{material:\"Gold\"}",
                                missing),
                        "screwAluminium", "stickWood", "screwAluminium" });
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "waraxe.diamond", 1, 0, missing),
                new Object[] {
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartAxeHead",
                                1,
                                1594,
                                "{material:\"Diamond\"}",
                                missing),
                        "craftingToolScrewdriver",
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartAxeHead",
                                1,
                                1594,
                                "{material:\"Diamond\"}",
                                missing),
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartAxeHead",
                                1,
                                1594,
                                "{material:\"Diamond\"}",
                                missing),
                        "stickWood",
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartAxeHead",
                                1,
                                1594,
                                "{material:\"Diamond\"}",
                                missing),
                        "screwStainlessSteel", "stickWood", "screwStainlessSteel" });
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "mace.wood", 1, 0, missing),
                new Object[] { null, getModItem(TinkerConstruct.ID, "heavyPlate", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 0, missing), null,
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 0, missing), "stickWood",
                        "craftingToolSoftHammer", null });
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "mace.stone", 1, 0, missing),
                new Object[] { "screwAnyIron", getModItem(TinkerConstruct.ID, "heavyPlate", 1, 1, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 1, missing), "screwAnyIron",
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 1, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 1, missing), "stickWood",
                        "craftingToolHardHammer", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "mace.iron", 1, 0, missing),
                new Object[] { "screwSteel", getModItem(TinkerConstruct.ID, "heavyPlate", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 0, missing), "screwSteel",
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 2, missing), "stickWood",
                        "craftingToolHardHammer", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "mace.gold", 1, 0, missing),
                new Object[] { "screwAluminium",
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartLargePlate",
                                1,
                                1505,
                                "{material:\"Gold\"}",
                                missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 1, missing), "screwAluminium",
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 1, missing),
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartLargePlate",
                                1,
                                1505,
                                "{material:\"Gold\"}",
                                missing),
                        "stickWood", "craftingToolHardHammer", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "mace.diamond", 1, 0, missing),
                new Object[] { "screwStainlessSteel",
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartLargePlate",
                                1,
                                1594,
                                "{material:\"Diamond\"}",
                                missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 2, missing), "screwStainlessSteel",
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 2, missing),
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartLargePlate",
                                1,
                                1594,
                                "{material:\"Diamond\"}",
                                missing),
                        "stickWood", "craftingToolHardHammer", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "quiver", 1, 0, missing),
                new Object[] { "itemLeather", "ringAnyIron", "itemLeather", "itemLeather",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "itemLeather",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "itemLeather",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing) });

    }
}
