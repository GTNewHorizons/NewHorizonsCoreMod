package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.CatWalks;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMaceratorRecipes;

import java.util.Collections;
import java.util.List;

import gregtech.api.enums.GT_Values;

public class ScriptCatWalk implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Cat Walk";
    }

    @Override
    public List<String> getDependencies() {
        return Collections.singletonList(CatWalks.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(CatWalks.ID, "catwalk_unlit", 6, 0, missing),
                new Object[] { getModItem(CatWalks.ID, "steelgrate", 1, 0, missing), "stickSteel",
                        getModItem(CatWalks.ID, "steelgrate", 1, 0, missing), "screwSteel",
                        getModItem(CatWalks.ID, "steelgrate", 1, 0, missing), "screwSteel", "craftingToolScrewdriver",
                        "stickSteel", "craftingToolWrench" });
        addShapedRecipe(
                getModItem(CatWalks.ID, "cagedLadder_north_unlit", 6, 0, missing),
                new Object[] { getModItem(CatWalks.ID, "steelgrate", 1, 0, missing),
                        getModItem(Minecraft.ID, "ladder", 1, 0, missing),
                        getModItem(CatWalks.ID, "steelgrate", 1, 0, missing), "screwSteel",
                        getModItem(CatWalks.ID, "steelgrate", 1, 0, missing), "screwSteel", "craftingToolScrewdriver",
                        "stickSteel", "craftingToolWrench" });
        addShapedRecipe(
                getModItem(CatWalks.ID, "scaffold", 1, 0, missing),
                new Object[] { "screwSteel", getModItem(CatWalks.ID, "steelgrate", 1, 0, missing), "screwSteel",
                        "craftingToolScrewdriver", "frameGtSteel", "craftingToolWrench" });
        addShapelessCraftingRecipe(
                getModItem(CatWalks.ID, "scaffold", 1, 0, missing),
                new Object[] { getModItem(CatWalks.ID, "scaffold", 1, 1, missing) });
        addShapedRecipe(
                getModItem(CatWalks.ID, "support_column", 3, 0, missing),
                new Object[] { "stickSteel", getModItem(CatWalks.ID, "steelgrate", 1, 0, missing), "stickSteel",
                        "stickSteel", getModItem(CatWalks.ID, "steelgrate", 1, 0, missing), "stickSteel", "stickSteel",
                        getModItem(CatWalks.ID, "steelgrate", 1, 0, missing), "stickSteel" });
        addShapedRecipe(
                getModItem(CatWalks.ID, "steelgrate", 5, 0, missing),
                new Object[] { "stickSteel", "screwSteel", "stickSteel", "screwSteel", "stickSteel", "screwSteel",
                        "stickSteel", "craftingToolScrewdriver", "stickSteel" });
        addShapedRecipe(
                getModItem(CatWalks.ID, "blowtorch", 1, 0, missing),
                new Object[] { null, "screwSteel", getModItem(Minecraft.ID, "flint_and_steel", 1, 0, missing),
                        "craftingToolScrewdriver", "stickSteel", "screwSteel", "stickSteel", "craftingToolWrench",
                        null });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 5, 23305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 3, 27305, missing))
                .itemOutputs(getModItem(CatWalks.ID, "steelgrate", 10, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 23305, missing),
                        getModItem(CatWalks.ID, "steelgrate", 4, 0, missing))
                .itemOutputs(getModItem(CatWalks.ID, "support_column", 4, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(CatWalks.ID, "steelgrate", 3, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 27305, missing))
                .itemOutputs(getModItem(CatWalks.ID, "catwalk_unlit", 6, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 4401, missing),
                        getModItem(CatWalks.ID, "steelgrate", 1, 0, missing))
                .itemOutputs(getModItem(CatWalks.ID, "scaffold", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(CatWalks.ID, "steelgrate", 4, 0, missing),
                        getModItem(Minecraft.ID, "ladder", 1, 0, missing))
                .itemOutputs(getModItem(CatWalks.ID, "cagedLadder_north_unlit", 6, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "rail", 1, 0, missing),
                        getModItem(CatWalks.ID, "steelgrate", 1, 0, missing))
                .itemOutputs(getModItem(CatWalks.ID, "sturdy_rail", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(150).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "activator_rail", 1, 0, missing),
                        getModItem(CatWalks.ID, "steelgrate", 1, 0, missing))
                .itemOutputs(getModItem(CatWalks.ID, "sturdy_rail_activator", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(150).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "detector_rail", 1, 0, missing),
                        getModItem(CatWalks.ID, "steelgrate", 1, 0, missing))
                .itemOutputs(getModItem(CatWalks.ID, "sturdy_rail_detector", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(150).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "golden_rail", 1, 0, missing),
                        getModItem(CatWalks.ID, "steelgrate", 1, 0, missing))
                .itemOutputs(getModItem(CatWalks.ID, "sturdy_rail_powered", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(150).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 19305, missing),
                        getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing))
                .itemOutputs(getModItem(CatWalks.ID, "ropeLight", 8, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(CatWalks.ID, "support_column", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 6, 305, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(CatWalks.ID, "scaffold", 1, 0, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 305, missing))
                .outputChances(10000, 10000).noFluidInputs().noFluidOutputs().duration(300).eut(2)
                .addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(CatWalks.ID, "scaffold", 1, 1, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 305, missing))
                .outputChances(10000, 10000).noFluidInputs().noFluidOutputs().duration(300).eut(2)
                .addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(CatWalks.ID, "catwalk_unlit", 1, 0, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 305, missing))
                .outputChances(10000, 10000).noFluidInputs().noFluidOutputs().duration(300).eut(2)
                .addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(CatWalks.ID, "cagedLadder_north_unlit", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2305, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(CatWalks.ID, "steelgrate", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 2, 305, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);

    }
}
