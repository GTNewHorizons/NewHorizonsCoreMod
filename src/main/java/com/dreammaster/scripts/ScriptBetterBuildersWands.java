package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.GT_Values;

public class ScriptBetterBuildersWands implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Better Builders Wands";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList("betterbuilderswands");
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("betterbuilderswands", "wandStone", 1, 0, missing),
                new Object[] { "craftingToolSaw", "screwIron", "plateStone", null, "stickWood", "screwIron",
                        "stickWood", null, "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("betterbuilderswands", "wandIron", 1, 0, missing),
                new Object[] { "craftingToolSaw", "screwSteel", getModItem("TConstruct", "heavyPlate", 1, 2, missing),
                        null, getModItem("TConstruct", "toolRod", 1, 2, missing), "screwSteel",
                        getModItem("TConstruct", "toolRod", 1, 2, missing), null, "craftingToolScrewdriver" });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TConstruct", "toolRod", 2, 2, missing),
                        getModItem("TConstruct", "heavyPlate", 1, 2, missing))
                .itemOutputs(getModItem("betterbuilderswands", "wandIron", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(
                createItemStack("TGregworks", "tGregToolPartToughRod", 1, 1594, "{material:\"Diamond\"}", missing),
                createItemStack("TGregworks", "tGregToolPartLargePlate", 1, 1594, "{material:\"Diamond\"}", missing))
                .itemOutputs(getModItem("betterbuilderswands", "wandDiamond", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TConstruct", "toughRod", 1, 314, missing),
                        getModItem("ExtraUtilities", "builderswand", 1, 0, missing))
                .itemOutputs(getModItem("betterbuilderswands", "wandUnbreakable", 1, 4, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("betterbuilderswands", "wandUnbreakable", 1, 4, missing),
                        getModItem("TConstruct", "heavyPlate", 1, 314, missing))
                .itemOutputs(getModItem("betterbuilderswands", "wandUnbreakable", 1, 5, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("betterbuilderswands", "wandUnbreakable", 1, 5, missing),
                        getModItem("TConstruct", "heavyPlate", 2, 314, missing))
                .itemOutputs(getModItem("betterbuilderswands", "wandUnbreakable", 1, 6, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("betterbuilderswands", "wandUnbreakable", 1, 6, missing),
                        getModItem("ExtraUtilities", "creativebuilderswand", 1, 0, missing))
                .itemOutputs(getModItem("betterbuilderswands", "wandUnbreakable", 1, 12, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(1024).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("betterbuilderswands", "wandUnbreakable", 1, 12, missing),
                        getModItem("TConstruct", "heavyPlate", 4, 314, missing))
                .itemOutputs(getModItem("betterbuilderswands", "wandUnbreakable", 1, 13, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("betterbuilderswands", "wandUnbreakable", 1, 13, missing),
                        getModItem("TConstruct", "heavyPlate", 8, 314, missing))
                .itemOutputs(getModItem("betterbuilderswands", "wandUnbreakable", 1, 14, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(4096).addTo(sAssemblerRecipes);

    }
}
