package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.CatWalks;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import java.util.Collections;
import java.util.List;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.objects.ItemData;
import gregtech.api.util.GTOreDictUnificator;

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
                getModItem(CatWalks.ID, "steelgrate", 1, 0, missing),
                "stickSteel",
                getModItem(CatWalks.ID, "steelgrate", 1, 0, missing),
                "screwSteel",
                getModItem(CatWalks.ID, "steelgrate", 1, 0, missing),
                "screwSteel",
                "craftingToolScrewdriver",
                "stickSteel",
                "craftingToolWrench");
        addShapedRecipe(
                getModItem(CatWalks.ID, "cagedLadder_north_unlit", 6, 0, missing),
                getModItem(CatWalks.ID, "steelgrate", 1, 0, missing),
                getModItem(Minecraft.ID, "ladder", 1, 0, missing),
                getModItem(CatWalks.ID, "steelgrate", 1, 0, missing),
                "screwSteel",
                getModItem(CatWalks.ID, "steelgrate", 1, 0, missing),
                "screwSteel",
                "craftingToolScrewdriver",
                "stickSteel",
                "craftingToolWrench");
        addShapedRecipe(
                getModItem(CatWalks.ID, "scaffold", 1, 0, missing),
                "screwSteel",
                getModItem(CatWalks.ID, "steelgrate", 1, 0, missing),
                "screwSteel",
                "craftingToolScrewdriver",
                "frameGtSteel",
                "craftingToolWrench");
        addShapelessRecipe(
                getModItem(CatWalks.ID, "scaffold", 1, 0, missing),
                getModItem(CatWalks.ID, "scaffold", 1, 1, missing));
        addShapedRecipe(
                getModItem(CatWalks.ID, "support_column", 3, 0, missing),
                "stickSteel",
                getModItem(CatWalks.ID, "steelgrate", 1, 0, missing),
                "stickSteel",
                "stickSteel",
                getModItem(CatWalks.ID, "steelgrate", 1, 0, missing),
                "stickSteel",
                "stickSteel",
                getModItem(CatWalks.ID, "steelgrate", 1, 0, missing),
                "stickSteel");
        addShapedRecipe(
                getModItem(CatWalks.ID, "steelgrate", 5, 0, missing),
                "stickSteel",
                "screwSteel",
                "stickSteel",
                "screwSteel",
                "stickSteel",
                "screwSteel",
                "stickSteel",
                "craftingToolScrewdriver",
                "stickSteel");
        addShapedRecipe(
                getModItem(CatWalks.ID, "blowtorch", 1, 0, missing),
                null,
                "screwSteel",
                getModItem(Minecraft.ID, "flint_and_steel", 1, 0, missing),
                "craftingToolScrewdriver",
                "stickSteel",
                "screwSteel",
                "stickSteel",
                "craftingToolWrench",
                null);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 5L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 3L))
                .itemOutputs(getModItem(CatWalks.ID, "steelgrate", 10, 0, missing)).duration(5 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 6L),
                        getModItem(CatWalks.ID, "steelgrate", 4, 0, missing))
                .itemOutputs(getModItem(CatWalks.ID, "support_column", 4, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CatWalks.ID, "steelgrate", 3, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 2L))
                .itemOutputs(getModItem(CatWalks.ID, "catwalk_unlit", 6, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1L),
                        getModItem(CatWalks.ID, "steelgrate", 1, 0, missing))
                .itemOutputs(getModItem(CatWalks.ID, "scaffold", 1, 0, missing)).duration(5 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(CatWalks.ID, "steelgrate", 4, 0, missing),
                        getModItem(Minecraft.ID, "ladder", 1, 0, missing))
                .itemOutputs(getModItem(CatWalks.ID, "cagedLadder_north_unlit", 6, 0, missing)).duration(15 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "rail", 1, 0, missing),
                        getModItem(CatWalks.ID, "steelgrate", 1, 0, missing))
                .itemOutputs(getModItem(CatWalks.ID, "sturdy_rail", 1, 0, missing)).duration(7 * SECONDS + 10 * TICKS)
                .eut(30).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "activator_rail", 1, 0, missing),
                        getModItem(CatWalks.ID, "steelgrate", 1, 0, missing))
                .itemOutputs(getModItem(CatWalks.ID, "sturdy_rail_activator", 1, 0, missing))
                .duration(7 * SECONDS + 10 * TICKS).eut(30).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "detector_rail", 1, 0, missing),
                        getModItem(CatWalks.ID, "steelgrate", 1, 0, missing))
                .itemOutputs(getModItem(CatWalks.ID, "sturdy_rail_detector", 1, 0, missing))
                .duration(7 * SECONDS + 10 * TICKS).eut(30).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "golden_rail", 1, 0, missing),
                        getModItem(CatWalks.ID, "steelgrate", 1, 0, missing))
                .itemOutputs(getModItem(CatWalks.ID, "sturdy_rail_powered", 1, 0, missing))
                .duration(7 * SECONDS + 10 * TICKS).eut(30).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Steel, 2L),
                        getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing))
                .itemOutputs(getModItem(CatWalks.ID, "ropeLight", 8, 0, missing)).duration(5 * SECONDS).eut(16)
                .addTo(assemblerRecipes);
        GTOreDictUnificator.addItemData(
                getModItem(CatWalks.ID, "steelgrate", 1, 0),
                new ItemData(Materials.Steel, 2 * GTValues.M / 9)); // GTValues.M equals one dust or ingot
        GTOreDictUnificator.addItemData(
                getModItem(CatWalks.ID, "support_column", 1, 0),
                new ItemData(Materials.Steel, 6 * GTValues.M / 9));
        GTOreDictUnificator.addItemData(
                getModItem(CatWalks.ID, "scaffold", 1, 0),
                new ItemData(Materials.Steel, 20 * GTValues.M / 9));
        GTOreDictUnificator.addItemData(
                getModItem(CatWalks.ID, "scaffold", 1, 1),
                new ItemData(Materials.Steel, 20 * GTValues.M / 9));
        GTOreDictUnificator.addItemData(
                getModItem(CatWalks.ID, "catwalk_unlit", 1, 0),
                new ItemData(Materials.Steel, GTValues.M / 9));
        GTOreDictUnificator.addItemData(
                getModItem(CatWalks.ID, "cagedLadder_north_unlit", 1, 0),
                new ItemData(Materials.Steel, GTValues.M / 9));
    }
}
