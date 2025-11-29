package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicHorizons;
import static gregtech.api.recipe.RecipeMaps.compressorRecipes;
import static gregtech.api.recipe.RecipeMaps.extractorRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import com.dreammaster.thaumcraft.TCHelper;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class ScriptThaumicHorizons implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Thaumic Horizons";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(BiomesOPlenty.ID, Thaumcraft.ID, ThaumicHorizons.ID);
    }

    @Override
    public void loadRecipes() {
        TCHelper.removeArcaneRecipe(getModItem(ThaumicHorizons.ID, "boatGreatwood", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicHorizons.ID, "boatThaumium", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicHorizons.ID, "Golemancy Bell TH", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicHorizons.ID, "planarConduit", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicHorizons.ID, "transductionAmplifier", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicHorizons.ID, "vortexStabilizer", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicHorizons.ID, "recombinator", 1, 0, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "greatwoodBoat",
                getModItem(ThaumicHorizons.ID, "boatGreatwood", 1, 0, missing),
                (new AspectList()).add(Aspect.ORDER, 10).add(Aspect.EARTH, 10).add(Aspect.WATER, 10),
                "GWG",
                "GGG",
                "SDS",
                'G',
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 0, missing),
                'W',
                "craftingToolSaw",
                'S',
                "screwWood",
                'D',
                "craftingToolScrewdriver");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumiumBoat",
                getModItem(ThaumicHorizons.ID, "boatThaumium", 1, 0, missing),
                (new AspectList()).add(Aspect.FIRE, 20).add(Aspect.WATER, 20).add(Aspect.ORDER, 20)
                        .add(Aspect.EARTH, 20),
                "FTF",
                "TBT",
                "WTW",
                'F', // Fire Cluster
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1, missing),
                'T',
                "plateThaumium",
                'W', // Water Cluster
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2, missing),
                'B',
                getModItem(ThaumicHorizons.ID, "boatGreatwood", 1, 0, missing));
        ThaumcraftApi.addWarpToResearch("thaumiumBoat", 1);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "planarTheory",
                getModItem(ThaumicHorizons.ID, "planarConduit", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("aqua"), 75)
                        .add(Aspect.getAspect("ignis"), 75).add(Aspect.getAspect("terra"), 75)
                        .add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("perditio"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                "plateVoid",
                'b',
                "plateEnderEye",
                'c',
                "plateVoid",
                'd',
                "plateEnderEye",
                'e',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15, missing),
                'f',
                "plateEnderEye",
                'g',
                "plateVoid",
                'h',
                "plateEnderEye",
                'i',
                "plateVoid");
        TCHelper.setResearchAspects(
                "planarTheory",
                new AspectList().add(Aspect.getAspect("vacuos"), 18).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("auram"), 9)
                        .add(Aspect.getAspect("perditio"), 6).add(Aspect.getAspect("tenebrae"), 3));
        TCHelper.setResearchComplexity("planarTheory", 4);
        ThaumcraftApi.addWarpToResearch("planarTheory", 1);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "transductionAmplifier",
                getModItem(ThaumicHorizons.ID, "transductionAmplifier", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("ignis"), 75)
                        .add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("terra"), 75)
                        .add(Aspect.getAspect("aqua"), 75).add(Aspect.getAspect("perditio"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                "screwThaumium",
                'b',
                getModItem(ThaumicHorizons.ID, "planarConduit", 1, 0, missing),
                'c',
                "screwThaumium",
                'd',
                "gemFlawlessAmber",
                'e',
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 11, missing),
                'f',
                "gemFlawlessAmber",
                'g',
                "plateRedstoneAlloy",
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing),
                'i',
                "plateRedstoneAlloy");
        TCHelper.setResearchAspects(
                "transductionAmplifier",
                new AspectList().add(Aspect.getAspect("auram"), 18).add(Aspect.getAspect("potentia"), 15)
                        .add(Aspect.getAspect("vacuos"), 12).add(Aspect.getAspect("alienis"), 9));
        TCHelper.setResearchComplexity("transductionAmplifier", 4);
        ThaumcraftApi.addWarpToResearch("transductionAmplifier", 2);
        TCHelper.addInfusionCraftingRecipe(
                "vortexStabilizer",
                getModItem(ThaumicHorizons.ID, "vortexStabilizer", 1, 0, missing),
                7,
                new AspectList().add(Aspect.getAspect("auram"), 64).add(Aspect.getAspect("fames"), 32)
                        .add(Aspect.getAspect("machina"), 48).add(Aspect.getAspect("ordo"), 32)
                        .add(Aspect.getAspect("potentia"), 48).add(Aspect.getAspect("vinculum"), 32),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 10, missing),
                getModItem(ThaumicHorizons.ID, "planarConduit", 1, 0, missing),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.gemExquisite.get(Materials.Amber),
                OrePrefixes.lens.get(Materials.Olivine),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.lens.get(Materials.Olivine),
                OrePrefixes.gemExquisite.get(Materials.Amber),
                OrePrefixes.plate.get(Materials.Thaumium));
        TCHelper.setResearchAspects(
                "vortexStabilizer",
                new AspectList().add(Aspect.getAspect("auram"), 21).add(Aspect.getAspect("fames"), 18)
                        .add(Aspect.getAspect("machina"), 15).add(Aspect.getAspect("ordo"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("vinculum"), 6));
        TCHelper.setResearchComplexity("vortexStabilizer", 4);
        ThaumcraftApi.addWarpToResearch("vortexStabilizer", 2);
        TCHelper.addInfusionCraftingRecipe(
                "recombinator",
                getModItem(ThaumicHorizons.ID, "recombinator", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("permutatio"), 64).add(Aspect.getAspect("auram"), 48)
                        .add(Aspect.getAspect("fabrico"), 32).add(Aspect.getAspect("potentia"), 32)
                        .add(Aspect.getAspect("sensus"), 16).add(Aspect.getAspect("praecantatio"), 24),
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 3, missing),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 11, missing),
                OrePrefixes.gemExquisite.get(Materials.Amber),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 8, missing),
                getModItem(ThaumicHorizons.ID, "planarConduit", 1, 0, missing),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 8, missing),
                OrePrefixes.gemExquisite.get(Materials.Amber),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 10, missing),
                OrePrefixes.gemExquisite.get(Materials.Amber),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 8, missing),
                getModItem(ThaumicHorizons.ID, "planarConduit", 1, 0, missing),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 8, missing),
                OrePrefixes.gemExquisite.get(Materials.Amber));
        TCHelper.setResearchAspects(
                "recombinator",
                new AspectList().add(Aspect.getAspect("auram"), 21).add(Aspect.getAspect("permutatio"), 18)
                        .add(Aspect.getAspect("fabrico"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("sensus"), 6));
        TCHelper.setResearchComplexity("recombinator", 4);
        ThaumcraftApi.addWarpToResearch("recombinator", 3);
        TCHelper.refreshResearchPages("greatwoodBoat");
        TCHelper.refreshResearchPages("thaumiumBoat");
        TCHelper.refreshResearchPages("planarTheory");
        TCHelper.refreshResearchPages("transductionAmplifier");
        TCHelper.refreshResearchPages("vortexStabilizer");
        TCHelper.refreshResearchPages("recombinator");
        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flesh", 2, missing))
                .itemOutputs(getModItem(ThaumicHorizons.ID, "meatTH", 1, missing)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ThaumicHorizons.ID, "meatCookedTH", 1, missing))
                .itemOutputs(getModItem(ThaumicHorizons.ID, "meatNuggetTH", 4, missing)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
    }
}
