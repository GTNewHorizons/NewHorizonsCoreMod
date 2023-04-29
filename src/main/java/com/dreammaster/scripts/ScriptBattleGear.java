package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.Mods;

public class ScriptBattleGear implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Mine and Blade Battle Gear 2";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.MineAndBladeBattleGear2.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("battlegear2", "shield.wood", 1, 0, missing),
                new Object[] { "itemFlint", "logWood", "itemFlint", "logWood", "stoneCobble", "logWood", "itemFlint",
                        "logWood", "itemFlint" });
        addShapedRecipe(
                getModItem("battlegear2", "shield.hide", 1, 0, missing),
                new Object[] { "itemFlint", "itemLeather", "itemFlint", "itemLeather",
                        getModItem("battlegear2", "shield.wood", 1, 0, missing), "itemLeather", "itemFlint",
                        "itemLeather", "itemFlint" });
        addShapedRecipe(
                getModItem("battlegear2", "shield.iron", 1, 0, missing),
                new Object[] { getModItem("TConstruct", "heavyPlate", 1, 2, missing),
                        getModItem("TConstruct", "toughBinding", 1, 2, missing),
                        getModItem("TConstruct", "heavyPlate", 1, 2, missing), "craftingToolHardHammer",
                        getModItem("TConstruct", "toughRod", 1, 2, missing), "craftingToolFile", null,
                        getModItem("TConstruct", "toughRod", 1, 2, missing), null });
        addShapedRecipe(
                getModItem("battlegear2", "shield.gold", 1, 0, missing),
                new Object[] {
                        createItemStack(
                                "TGregworks",
                                "tGregToolPartLargePlate",
                                1,
                                1505,
                                "{material:\"Gold\"}",
                                missing),
                        createItemStack(
                                "TGregworks",
                                "tGregToolPartToughBind",
                                1,
                                1505,
                                "{material:\"Gold\"}",
                                missing),
                        createItemStack(
                                "TGregworks",
                                "tGregToolPartLargePlate",
                                1,
                                1505,
                                "{material:\"Gold\"}",
                                missing),
                        "craftingToolHardHammer",
                        createItemStack("TGregworks", "tGregToolPartToughRod", 1, 1505, "{material:\"Gold\"}", missing),
                        "craftingToolFile", null,
                        createItemStack("TGregworks", "tGregToolPartToughRod", 1, 1505, "{material:\"Gold\"}", missing),
                        null });
        addShapedRecipe(
                getModItem("battlegear2", "shield.diamond", 1, 0, missing),
                new Object[] {
                        createItemStack(
                                "TGregworks",
                                "tGregToolPartLargePlate",
                                1,
                                1594,
                                "{material:\"Diamond\"}",
                                missing),
                        createItemStack(
                                "TGregworks",
                                "tGregToolPartToughBind",
                                1,
                                1594,
                                "{material:\"Diamond\"}",
                                missing),
                        createItemStack(
                                "TGregworks",
                                "tGregToolPartLargePlate",
                                1,
                                1594,
                                "{material:\"Diamond\"}",
                                missing),
                        "craftingToolHardHammer",
                        createItemStack(
                                "TGregworks",
                                "tGregToolPartToughRod",
                                1,
                                1594,
                                "{material:\"Diamond\"}",
                                missing),
                        "craftingToolFile", null,
                        createItemStack(
                                "TGregworks",
                                "tGregToolPartToughRod",
                                1,
                                1594,
                                "{material:\"Diamond\"}",
                                missing),
                        null });
        addShapedRecipe(
                getModItem("battlegear2", "dagger.wood", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing), "craftingToolFile", null,
                        "stickWood", "craftingToolHardHammer", null });
        addShapedRecipe(
                getModItem("battlegear2", "dagger.stone", 1, 0, missing),
                new Object[] { "plateStone", "craftingToolFile", null, "stickWood", "craftingToolHardHammer", null });
        addShapedRecipe(
                getModItem("battlegear2", "dagger.iron", 1, 0, missing),
                new Object[] { "plateAnyIron", "craftingToolFile", null, "stickWood", "craftingToolHardHammer", null });
        addShapedRecipe(
                getModItem("battlegear2", "dagger.diamond", 1, 0, missing),
                new Object[] { "plateDiamond", "craftingToolFile", null, "stickWood", "craftingToolHardHammer", null });
        addShapedRecipe(
                getModItem("battlegear2", "spear.wood", 1, 0, missing),
                new Object[] { null, getModItem("minecraft", "string", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "itemLeather",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), null });
        addShapedRecipe(
                getModItem("battlegear2", "spear.stone", 1, 0, missing),
                new Object[] { "screwAnyIron", getModItem("TConstruct", "arrowhead", 1, 1, missing), null,
                        getModItem("battlegear2", "spear.wood", 1, 0, missing), "screwAnyIron", null, "craftingToolSaw",
                        "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem("battlegear2", "spear.iron", 1, 0, missing),
                new Object[] { "screwSteel", getModItem("TConstruct", "arrowhead", 1, 2, missing), null,
                        getModItem("battlegear2", "spear.wood", 1, 0, missing), "screwSteel", null, "craftingToolSaw",
                        "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem("battlegear2", "spear.gold", 1, 0, missing),
                new Object[] { "screwAluminium",
                        createItemStack(
                                "TGregworks",
                                "tGregToolPartArrowHead",
                                1,
                                1505,
                                "{material:\"Gold\"}",
                                missing),
                        null, getModItem("battlegear2", "spear.wood", 1, 0, missing), "screwAluminium", null,
                        "craftingToolSaw", "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem("battlegear2", "spear.diamond", 1, 0, missing),
                new Object[] { "screwStainlessSteel",
                        createItemStack(
                                "TGregworks",
                                "tGregToolPartArrowHead",
                                1,
                                1594,
                                "{material:\"Diamond\"}",
                                missing),
                        null, getModItem("battlegear2", "spear.wood", 1, 0, missing), "screwStainlessSteel", null,
                        "craftingToolSaw", "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem("battlegear2", "waraxe.wood", 1, 0, missing),
                new Object[] { getModItem("TConstruct", "hatchetHead", 1, 0, missing), "craftingToolSoftHammer",
                        getModItem("TConstruct", "hatchetHead", 1, 0, missing),
                        getModItem("TConstruct", "hatchetHead", 1, 0, missing), "stickWood",
                        getModItem("TConstruct", "hatchetHead", 1, 0, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("battlegear2", "waraxe.stone", 1, 0, missing),
                new Object[] { getModItem("TConstruct", "hatchetHead", 1, 1, missing), "craftingToolScrewdriver",
                        getModItem("TConstruct", "hatchetHead", 1, 1, missing),
                        getModItem("TConstruct", "hatchetHead", 1, 1, missing), "stickWood",
                        getModItem("TConstruct", "hatchetHead", 1, 1, missing), "screwAnyIron", "stickWood",
                        "screwAnyIron" });
        addShapedRecipe(
                getModItem("battlegear2", "waraxe.iron", 1, 0, missing),
                new Object[] { getModItem("TConstruct", "hatchetHead", 1, 2, missing), "craftingToolScrewdriver",
                        getModItem("TConstruct", "hatchetHead", 1, 2, missing),
                        getModItem("TConstruct", "hatchetHead", 1, 2, missing), "stickWood",
                        getModItem("TConstruct", "hatchetHead", 1, 2, missing), "screwSteel", "stickWood",
                        "screwSteel" });
        addShapedRecipe(
                getModItem("battlegear2", "waraxe.gold", 1, 0, missing),
                new Object[] {
                        createItemStack("TGregworks", "tGregToolPartAxeHead", 1, 1505, "{material:\"Gold\"}", missing),
                        "craftingToolScrewdriver",
                        createItemStack("TGregworks", "tGregToolPartAxeHead", 1, 1505, "{material:\"Gold\"}", missing),
                        createItemStack("TGregworks", "tGregToolPartAxeHead", 1, 1505, "{material:\"Gold\"}", missing),
                        "stickWood",
                        createItemStack("TGregworks", "tGregToolPartAxeHead", 1, 1505, "{material:\"Gold\"}", missing),
                        "screwAluminium", "stickWood", "screwAluminium" });
        addShapedRecipe(
                getModItem("battlegear2", "waraxe.diamond", 1, 0, missing),
                new Object[] {
                        createItemStack(
                                "TGregworks",
                                "tGregToolPartAxeHead",
                                1,
                                1594,
                                "{material:\"Diamond\"}",
                                missing),
                        "craftingToolScrewdriver",
                        createItemStack(
                                "TGregworks",
                                "tGregToolPartAxeHead",
                                1,
                                1594,
                                "{material:\"Diamond\"}",
                                missing),
                        createItemStack(
                                "TGregworks",
                                "tGregToolPartAxeHead",
                                1,
                                1594,
                                "{material:\"Diamond\"}",
                                missing),
                        "stickWood",
                        createItemStack(
                                "TGregworks",
                                "tGregToolPartAxeHead",
                                1,
                                1594,
                                "{material:\"Diamond\"}",
                                missing),
                        "screwStainlessSteel", "stickWood", "screwStainlessSteel" });
        addShapedRecipe(
                getModItem("battlegear2", "mace.wood", 1, 0, missing),
                new Object[] { null, getModItem("TConstruct", "heavyPlate", 1, 0, missing),
                        getModItem("TConstruct", "heavyPlate", 1, 0, missing), null,
                        getModItem("TConstruct", "heavyPlate", 1, 0, missing),
                        getModItem("TConstruct", "heavyPlate", 1, 0, missing), "stickWood", "craftingToolSoftHammer",
                        null });
        addShapedRecipe(
                getModItem("battlegear2", "mace.stone", 1, 0, missing),
                new Object[] { "screwAnyIron", getModItem("TConstruct", "heavyPlate", 1, 1, missing),
                        getModItem("TConstruct", "heavyPlate", 1, 1, missing), "screwAnyIron",
                        getModItem("TConstruct", "heavyPlate", 1, 1, missing),
                        getModItem("TConstruct", "heavyPlate", 1, 1, missing), "stickWood", "craftingToolHardHammer",
                        "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("battlegear2", "mace.iron", 1, 0, missing),
                new Object[] { "screwSteel", getModItem("TConstruct", "heavyPlate", 1, 2, missing),
                        getModItem("TConstruct", "heavyPlate", 1, 0, missing), "screwSteel",
                        getModItem("TConstruct", "heavyPlate", 1, 0, missing),
                        getModItem("TConstruct", "heavyPlate", 1, 2, missing), "stickWood", "craftingToolHardHammer",
                        "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("battlegear2", "mace.gold", 1, 0, missing),
                new Object[] { "screwAluminium",
                        createItemStack(
                                "TGregworks",
                                "tGregToolPartLargePlate",
                                1,
                                1505,
                                "{material:\"Gold\"}",
                                missing),
                        getModItem("TConstruct", "heavyPlate", 1, 1, missing), "screwAluminium",
                        getModItem("TConstruct", "heavyPlate", 1, 1, missing),
                        createItemStack(
                                "TGregworks",
                                "tGregToolPartLargePlate",
                                1,
                                1505,
                                "{material:\"Gold\"}",
                                missing),
                        "stickWood", "craftingToolHardHammer", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("battlegear2", "mace.diamond", 1, 0, missing),
                new Object[] { "screwStainlessSteel",
                        createItemStack(
                                "TGregworks",
                                "tGregToolPartLargePlate",
                                1,
                                1594,
                                "{material:\"Diamond\"}",
                                missing),
                        getModItem("TConstruct", "heavyPlate", 1, 2, missing), "screwStainlessSteel",
                        getModItem("TConstruct", "heavyPlate", 1, 2, missing),
                        createItemStack(
                                "TGregworks",
                                "tGregToolPartLargePlate",
                                1,
                                1594,
                                "{material:\"Diamond\"}",
                                missing),
                        "stickWood", "craftingToolHardHammer", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("battlegear2", "quiver", 1, 0, missing),
                new Object[] { "itemLeather", "ringAnyIron", "itemLeather", "itemLeather",
                        getModItem("minecraft", "string", 1, 0, missing), "itemLeather",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "itemLeather",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing) });

    }
}
