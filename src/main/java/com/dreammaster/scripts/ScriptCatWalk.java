package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMaceratorRecipes;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.GT_Values;

public class ScriptCatWalk implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Cat Walk";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList("catwalks");
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("catwalks", "catwalk_unlit", 6, 0, missing),
                new Object[] { getModItem("catwalks", "steelgrate", 1, 0, missing), "stickSteel",
                        getModItem("catwalks", "steelgrate", 1, 0, missing), "screwSteel",
                        getModItem("catwalks", "steelgrate", 1, 0, missing), "screwSteel", "craftingToolScrewdriver",
                        "stickSteel", "craftingToolWrench" });
        addShapedRecipe(
                getModItem("catwalks", "cagedLadder_north_unlit", 6, 0, missing),
                new Object[] { getModItem("catwalks", "steelgrate", 1, 0, missing),
                        getModItem("minecraft", "ladder", 1, 0, missing),
                        getModItem("catwalks", "steelgrate", 1, 0, missing), "screwSteel",
                        getModItem("catwalks", "steelgrate", 1, 0, missing), "screwSteel", "craftingToolScrewdriver",
                        "stickSteel", "craftingToolWrench" });
        addShapedRecipe(
                getModItem("catwalks", "scaffold", 1, 0, missing),
                new Object[] { "screwSteel", getModItem("catwalks", "steelgrate", 1, 0, missing), "screwSteel",
                        "craftingToolScrewdriver", "frameGtSteel", "craftingToolWrench" });
        addShapelessCraftingRecipe(
                getModItem("catwalks", "scaffold", 1, 0, missing),
                new Object[] { getModItem("catwalks", "scaffold", 1, 1, missing) });
        addShapedRecipe(
                getModItem("catwalks", "support_column", 3, 0, missing),
                new Object[] { "stickSteel", getModItem("catwalks", "steelgrate", 1, 0, missing), "stickSteel",
                        "stickSteel", getModItem("catwalks", "steelgrate", 1, 0, missing), "stickSteel", "stickSteel",
                        getModItem("catwalks", "steelgrate", 1, 0, missing), "stickSteel" });
        addShapedRecipe(
                getModItem("catwalks", "steelgrate", 5, 0, missing),
                new Object[] { "stickSteel", "screwSteel", "stickSteel", "screwSteel", "stickSteel", "screwSteel",
                        "stickSteel", "craftingToolScrewdriver", "stickSteel" });
        addShapedRecipe(
                getModItem("catwalks", "blowtorch", 1, 0, missing),
                new Object[] { null, "screwSteel", getModItem("minecraft", "flint_and_steel", 1, 0, missing),
                        "craftingToolScrewdriver", "stickSteel", "screwSteel", "stickSteel", "craftingToolWrench",
                        null });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 5, 23305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 27305, missing))
                .itemOutputs(getModItem("catwalks", "steelgrate", 10, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 6, 23305, missing),
                        getModItem("catwalks", "steelgrate", 4, 0, missing))
                .itemOutputs(getModItem("catwalks", "support_column", 4, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("catwalks", "steelgrate", 3, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 27305, missing))
                .itemOutputs(getModItem("catwalks", "catwalk_unlit", 6, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 4401, missing),
                        getModItem("catwalks", "steelgrate", 1, 0, missing))
                .itemOutputs(getModItem("catwalks", "scaffold", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("catwalks", "steelgrate", 4, 0, missing),
                        getModItem("minecraft", "ladder", 1, 0, missing))
                .itemOutputs(getModItem("catwalks", "cagedLadder_north_unlit", 6, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "rail", 1, 0, missing),
                        getModItem("catwalks", "steelgrate", 1, 0, missing))
                .itemOutputs(getModItem("catwalks", "sturdy_rail", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(150).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "activator_rail", 1, 0, missing),
                        getModItem("catwalks", "steelgrate", 1, 0, missing))
                .itemOutputs(getModItem("catwalks", "sturdy_rail_activator", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(150).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "detector_rail", 1, 0, missing),
                        getModItem("catwalks", "steelgrate", 1, 0, missing))
                .itemOutputs(getModItem("catwalks", "sturdy_rail_detector", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(150).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "golden_rail", 1, 0, missing),
                        getModItem("catwalks", "steelgrate", 1, 0, missing))
                .itemOutputs(getModItem("catwalks", "sturdy_rail_powered", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(150).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.02", 2, 19305, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing))
                .itemOutputs(getModItem("catwalks", "ropeLight", 8, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("catwalks", "support_column", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 6, 305, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("catwalks", "scaffold", 1, 0, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 2305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 305, missing))
                .outputChances(10000, 10000).noFluidInputs().noFluidOutputs().duration(300).eut(2)
                .addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("catwalks", "scaffold", 1, 1, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 2305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 305, missing))
                .outputChances(10000, 10000).noFluidInputs().noFluidOutputs().duration(300).eut(2)
                .addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("catwalks", "catwalk_unlit", 1, 0, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 2305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 305, missing))
                .outputChances(10000, 10000).noFluidInputs().noFluidOutputs().duration(300).eut(2)
                .addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("catwalks", "cagedLadder_north_unlit", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 2305, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("catwalks", "steelgrate", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 2, 305, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);

    }
}
