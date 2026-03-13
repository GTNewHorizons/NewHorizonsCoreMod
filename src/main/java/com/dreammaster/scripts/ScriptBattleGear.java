package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.createItemStack;
import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.MineAndBladeBattleGear2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TinkersGregworks;
import static com.dreammaster.scripts.IngredientFactory.getModItem;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.ToolDictNames;
import gregtech.api.util.GTOreDictUnificator;

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
                getModItem(MineAndBladeBattleGear2.ID, "shield.wood", 1, 0),
                "itemFlint",
                "logWood",
                "itemFlint",
                "logWood",
                "stoneCobble",
                "logWood",
                "itemFlint",
                "logWood",
                "itemFlint");
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "shield.hide", 1, 0),
                "itemFlint",
                "itemLeather",
                "itemFlint",
                "itemLeather",
                getModItem(MineAndBladeBattleGear2.ID, "shield.wood", 1, 0),
                "itemLeather",
                "itemFlint",
                "itemLeather",
                "itemFlint");
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "shield.iron", 1, 0),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 2),
                getModItem(TinkerConstruct.ID, "toughBinding", 1, 2),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 2),
                "craftingToolHardHammer",
                getModItem(TinkerConstruct.ID, "toughRod", 1, 2),
                "craftingToolFile",
                null,
                getModItem(TinkerConstruct.ID, "toughRod", 1, 2),
                null);
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "shield.gold", 1, 0),
                createItemStack(TinkersGregworks.ID, "tGregToolPartLargePlate", 1, 1505, "{material:\"Gold\"}"),
                createItemStack(TinkersGregworks.ID, "tGregToolPartToughBind", 1, 1505, "{material:\"Gold\"}"),
                createItemStack(TinkersGregworks.ID, "tGregToolPartLargePlate", 1, 1505, "{material:\"Gold\"}"),
                "craftingToolHardHammer",
                createItemStack(TinkersGregworks.ID, "tGregToolPartToughRod", 1, 1505, "{material:\"Gold\"}"),
                "craftingToolFile",
                null,
                createItemStack(TinkersGregworks.ID, "tGregToolPartToughRod", 1, 1505, "{material:\"Gold\"}"),
                null);
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "shield.diamond", 1, 0),
                createItemStack(TinkersGregworks.ID, "tGregToolPartLargePlate", 1, 1594, "{material:\"Diamond\"}"),
                createItemStack(TinkersGregworks.ID, "tGregToolPartToughBind", 1, 1594, "{material:\"Diamond\"}"),
                createItemStack(TinkersGregworks.ID, "tGregToolPartLargePlate", 1, 1594, "{material:\"Diamond\"}"),
                "craftingToolHardHammer",
                createItemStack(TinkersGregworks.ID, "tGregToolPartToughRod", 1, 1594, "{material:\"Diamond\"}"),
                "craftingToolFile",
                null,
                createItemStack(TinkersGregworks.ID, "tGregToolPartToughRod", 1, 1594, "{material:\"Diamond\"}"),
                null);
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "dagger.wood", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "craftingToolFile",
                null,
                "stickWood",
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "dagger.stone", 1, 0),
                "plateStone",
                "craftingToolFile",
                null,
                "stickWood",
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "dagger.iron", 1, 0),
                "plateAnyIron",
                "craftingToolFile",
                null,
                "stickWood",
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "dagger.diamond", 1, 0),
                "plateDiamond",
                "craftingToolFile",
                null,
                "stickWood",
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "spear.wood", 1, 0),
                null,
                getModItem(Minecraft.ID, "string", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "string", 1, 0),
                "itemLeather",
                getModItem(Minecraft.ID, "string", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "string", 1, 0),
                null);
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "spear.stone", 1, 0),
                "screwAnyIron",
                getModItem(TinkerConstruct.ID, "arrowhead", 1, 1),
                null,
                getModItem(MineAndBladeBattleGear2.ID, "spear.wood", 1, 0),
                "screwAnyIron",
                null,
                "craftingToolSaw",
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "spear.iron", 1, 0),
                "screwSteel",
                getModItem(TinkerConstruct.ID, "arrowhead", 1, 2),
                null,
                getModItem(MineAndBladeBattleGear2.ID, "spear.wood", 1, 0),
                "screwSteel",
                null,
                "craftingToolSaw",
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "spear.gold", 1, 0),
                "screwAluminium",
                createItemStack(TinkersGregworks.ID, "tGregToolPartArrowHead", 1, 1505, "{material:\"Gold\"}"),
                null,
                getModItem(MineAndBladeBattleGear2.ID, "spear.wood", 1, 0),
                "screwAluminium",
                null,
                "craftingToolSaw",
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "spear.diamond", 1, 0),
                "screwStainlessSteel",
                createItemStack(TinkersGregworks.ID, "tGregToolPartArrowHead", 1, 1594, "{material:\"Diamond\"}"),
                null,
                getModItem(MineAndBladeBattleGear2.ID, "spear.wood", 1, 0),
                "screwStainlessSteel",
                null,
                "craftingToolSaw",
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "waraxe.wood", 1, 0),
                getModItem(TinkerConstruct.ID, "hatchetHead", 1, 0),
                ToolDictNames.craftingToolSoftMallet.name(),
                getModItem(TinkerConstruct.ID, "hatchetHead", 1, 0),
                getModItem(TinkerConstruct.ID, "hatchetHead", 1, 0),
                "stickWood",
                getModItem(TinkerConstruct.ID, "hatchetHead", 1, 0),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "waraxe.stone", 1, 0),
                getModItem(TinkerConstruct.ID, "hatchetHead", 1, 1),
                "craftingToolScrewdriver",
                getModItem(TinkerConstruct.ID, "hatchetHead", 1, 1),
                getModItem(TinkerConstruct.ID, "hatchetHead", 1, 1),
                "stickWood",
                getModItem(TinkerConstruct.ID, "hatchetHead", 1, 1),
                "screwAnyIron",
                "stickWood",
                "screwAnyIron");
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "waraxe.iron", 1, 0),
                getModItem(TinkerConstruct.ID, "hatchetHead", 1, 2),
                "craftingToolScrewdriver",
                getModItem(TinkerConstruct.ID, "hatchetHead", 1, 2),
                getModItem(TinkerConstruct.ID, "hatchetHead", 1, 2),
                "stickWood",
                getModItem(TinkerConstruct.ID, "hatchetHead", 1, 2),
                "screwSteel",
                "stickWood",
                "screwSteel");
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "waraxe.gold", 1, 0),
                createItemStack(TinkersGregworks.ID, "tGregToolPartAxeHead", 1, 1505, "{material:\"Gold\"}"),
                "craftingToolScrewdriver",
                createItemStack(TinkersGregworks.ID, "tGregToolPartAxeHead", 1, 1505, "{material:\"Gold\"}"),
                createItemStack(TinkersGregworks.ID, "tGregToolPartAxeHead", 1, 1505, "{material:\"Gold\"}"),
                "stickWood",
                createItemStack(TinkersGregworks.ID, "tGregToolPartAxeHead", 1, 1505, "{material:\"Gold\"}"),
                "screwAluminium",
                "stickWood",
                "screwAluminium");
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "waraxe.diamond", 1, 0),
                createItemStack(TinkersGregworks.ID, "tGregToolPartAxeHead", 1, 1594, "{material:\"Diamond\"}"),
                "craftingToolScrewdriver",
                createItemStack(TinkersGregworks.ID, "tGregToolPartAxeHead", 1, 1594, "{material:\"Diamond\"}"),
                createItemStack(TinkersGregworks.ID, "tGregToolPartAxeHead", 1, 1594, "{material:\"Diamond\"}"),
                "stickWood",
                createItemStack(TinkersGregworks.ID, "tGregToolPartAxeHead", 1, 1594, "{material:\"Diamond\"}"),
                "screwStainlessSteel",
                "stickWood",
                "screwStainlessSteel");
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "mace.wood", 1, 0),
                null,
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 0),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 0),
                null,
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 0),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 0),
                "stickWood",
                ToolDictNames.craftingToolSoftMallet.name(),
                null);
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "mace.stone", 1, 0),
                "screwAnyIron",
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 1),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 1),
                "screwAnyIron",
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 1),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 1),
                "stickWood",
                "craftingToolHardHammer",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "mace.iron", 1, 0),
                "screwSteel",
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 2),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 0),
                "screwSteel",
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 0),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 2),
                "stickWood",
                "craftingToolHardHammer",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "mace.gold", 1, 0),
                "screwAluminium",
                createItemStack(TinkersGregworks.ID, "tGregToolPartLargePlate", 1, 1505, "{material:\"Gold\"}"),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 1),
                "screwAluminium",
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 1),
                createItemStack(TinkersGregworks.ID, "tGregToolPartLargePlate", 1, 1505, "{material:\"Gold\"}"),
                "stickWood",
                "craftingToolHardHammer",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "mace.diamond", 1, 0),
                "screwStainlessSteel",
                createItemStack(TinkersGregworks.ID, "tGregToolPartLargePlate", 1, 1594, "{material:\"Diamond\"}"),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 2),
                "screwStainlessSteel",
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 2),
                createItemStack(TinkersGregworks.ID, "tGregToolPartLargePlate", 1, 1594, "{material:\"Diamond\"}"),
                "stickWood",
                "craftingToolHardHammer",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(MineAndBladeBattleGear2.ID, "quiver", 1, 0),
                "itemLeather",
                "ringAnyIron",
                "itemLeather",
                "itemLeather",
                getModItem(Minecraft.ID, "string", 1, 0),
                "itemLeather",
                getModItem(Backpack.ID, "tannedLeather", 1, 0),
                "itemLeather",
                getModItem(Backpack.ID, "tannedLeather", 1, 0));

    }
}
