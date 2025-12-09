package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.RandomBoubles;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicExploration;
import static gregtech.api.util.GTModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import com.dreammaster.thaumcraft.TCHelper;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class ScriptRandomBoubles implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Random Boubles";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(RandomBoubles.ID, Thaumcraft.ID, ThaumicExploration.ID);
    }

    @Override
    public void loadRecipes() {
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RBMAGICIANSRINGOFAER",
                getModItem(ThaumicExploration.ID, "discuntRing", 1, 0, missing),
                new AspectList().add(Aspect.AIR, 25).add(Aspect.ORDER, 10),
                "STS",
                "TAT",
                "STS",
                'T',
                "plateThaumium",
                'A',
                getModItem(Thaumcraft.ID, "itemBaubleBlanks", 1, 3, missing),
                'S',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RBMAGICIANSRINGOFTERRA",
                getModItem(ThaumicExploration.ID, "discuntRing", 1, 1, missing),
                new AspectList().add(Aspect.EARTH, 25).add(Aspect.ORDER, 10),
                "STS",
                "TAT",
                "STS",
                'T',
                "plateThaumium",
                'A',
                getModItem(Thaumcraft.ID, "itemBaubleBlanks", 1, 4, missing),
                'S',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RBMAGICIANSRINGOFIGNIS",
                getModItem(ThaumicExploration.ID, "discuntRing", 1, 2, missing),
                new AspectList().add(Aspect.FIRE, 25).add(Aspect.ORDER, 10),
                "STS",
                "TAT",
                "STS",
                'T',
                "plateThaumium",
                'A',
                getModItem(Thaumcraft.ID, "itemBaubleBlanks", 1, 5, missing),
                'S',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RBMAGICIANSRINGOFAQUA",
                getModItem(ThaumicExploration.ID, "discuntRing", 1, 3, missing),
                new AspectList().add(Aspect.WATER, 25).add(Aspect.ORDER, 10),
                "STS",
                "TAT",
                "STS",
                'T',
                "plateThaumium",
                'A',
                getModItem(Thaumcraft.ID, "itemBaubleBlanks", 1, 6, missing),
                'S',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RBMAGICIANSRINGOFORDO",
                getModItem(ThaumicExploration.ID, "discuntRing", 1, 4, missing),
                new AspectList().add(Aspect.ORDER, 35),
                "STS",
                "TAT",
                "STS",
                'T',
                "plateThaumium",
                'A',
                getModItem(Thaumcraft.ID, "itemBaubleBlanks", 1, 7, missing),
                'S',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RBMAGICIANSRINGOFPERDITIO",
                getModItem(ThaumicExploration.ID, "discuntRing", 1, 5, missing),
                new AspectList().add(Aspect.ENTROPY, 25).add(Aspect.ORDER, 10),
                "STS",
                "TAT",
                "STS",
                'T',
                "plateThaumium",
                'A',
                getModItem(Thaumcraft.ID, "itemBaubleBlanks", 1, 8, missing),
                'S',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5, missing));
        TCHelper.refreshResearchPages("RBMAGICIANSRINGOFAER");
        TCHelper.refreshResearchPages("RBMAGICIANSRINGOFTERRA");
        TCHelper.refreshResearchPages("RBMAGICIANSRINGOFIGNIS");
        TCHelper.refreshResearchPages("RBMAGICIANSRINGOFAQUA");
        TCHelper.refreshResearchPages("RBMAGICIANSRINGOFORDO");
        TCHelper.refreshResearchPages("RBMAGICIANSRINGOFPERDITIO");
    }
}
