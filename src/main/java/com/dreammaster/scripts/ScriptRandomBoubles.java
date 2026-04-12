package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.RandomBoubles;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicExploration;

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
                getModItem(ThaumicExploration.ID, "discountRing", 1, 0),
                new AspectList().add(Aspect.AIR, 25).add(Aspect.ORDER, 10),
                "STS",
                "TAT",
                "STS",
                'T',
                "plateThaumium",
                'A',
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 3),
                'S',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RBMAGICIANSRINGOFTERRA",
                getModItem(ThaumicExploration.ID, "discountRing", 1, 1),
                new AspectList().add(Aspect.EARTH, 25).add(Aspect.ORDER, 10),
                "STS",
                "TAT",
                "STS",
                'T',
                "plateThaumium",
                'A',
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 4),
                'S',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RBMAGICIANSRINGOFIGNIS",
                getModItem(ThaumicExploration.ID, "discountRing", 1, 2),
                new AspectList().add(Aspect.FIRE, 25).add(Aspect.ORDER, 10),
                "STS",
                "TAT",
                "STS",
                'T',
                "plateThaumium",
                'A',
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 5),
                'S',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RBMAGICIANSRINGOFAQUA",
                getModItem(ThaumicExploration.ID, "discountRing", 1, 3),
                new AspectList().add(Aspect.WATER, 25).add(Aspect.ORDER, 10),
                "STS",
                "TAT",
                "STS",
                'T',
                "plateThaumium",
                'A',
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 6),
                'S',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RBMAGICIANSRINGOFORDO",
                getModItem(ThaumicExploration.ID, "discountRing", 1, 4),
                new AspectList().add(Aspect.ORDER, 35),
                "STS",
                "TAT",
                "STS",
                'T',
                "plateThaumium",
                'A',
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 7),
                'S',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RBMAGICIANSRINGOFPERDITIO",
                getModItem(ThaumicExploration.ID, "discountRing", 1, 5),
                new AspectList().add(Aspect.ENTROPY, 25).add(Aspect.ORDER, 10),
                "STS",
                "TAT",
                "STS",
                'T',
                "plateThaumium",
                'A',
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 8),
                'S',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5));
        TCHelper.refreshResearchPages("RBMAGICIANSRINGOFAER");
        TCHelper.refreshResearchPages("RBMAGICIANSRINGOFTERRA");
        TCHelper.refreshResearchPages("RBMAGICIANSRINGOFIGNIS");
        TCHelper.refreshResearchPages("RBMAGICIANSRINGOFAQUA");
        TCHelper.refreshResearchPages("RBMAGICIANSRINGOFORDO");
        TCHelper.refreshResearchPages("RBMAGICIANSRINGOFPERDITIO");
    }
}
