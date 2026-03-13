package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.CarpentersBlocks;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronTanks;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicBases;
import static gregtech.api.enums.Mods.ThaumicTinkerer;
import static gregtech.api.enums.Mods.TinkersGregworks;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.util.GTModHandler.getModItem;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.dreammaster.thaumcraft.TCHelper;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.research.ResearchPage;

public class ScriptZThaumicBases implements IScriptLoader {

    // Needs to load after ScriptThaumicExploration because the removeCrucibleRecipe calls there yeet these

    @Override
    public String getScriptName() {
        return "Thaumic Bases part 2";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                CarpentersBlocks.ID,
                ExtraUtilities.ID,
                IndustrialCraft2.ID,
                IronTanks.ID,
                Railcraft.ID,
                Thaumcraft.ID,
                ThaumicBases.ID,
                ThaumicTinkerer.ID,
                TinkersGregworks.ID,
                TwilightForest.ID);
    }

    @Override
    public void loadRecipes() {
        CrucibleRecipe leatherHelmetBP = ThaumcraftApi.addCrucibleRecipe(
                "TB.Backprocessing",
                getModItem(Minecraft.ID, "leather", 5),
                getModItem(Minecraft.ID, "leather_helmet", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 2).add(Aspect.getAspect("bestia"), 1)
                        .add(Aspect.getAspect("tutamen"), 1).add(Aspect.getAspect("perditio"), 2));
        CrucibleRecipe leatherChestplateBP = ThaumcraftApi.addCrucibleRecipe(
                "TB.Backprocessing",
                getModItem(Minecraft.ID, "leather", 8),
                getModItem(Minecraft.ID, "leather_chestplate", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 2).add(Aspect.getAspect("bestia"), 1)
                        .add(Aspect.getAspect("tutamen"), 1).add(Aspect.getAspect("perditio"), 2));
        CrucibleRecipe leatherLeggingsBP = ThaumcraftApi.addCrucibleRecipe(
                "TB.Backprocessing",
                getModItem(Minecraft.ID, "leather", 7),
                getModItem(Minecraft.ID, "leather_leggings", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 2).add(Aspect.getAspect("bestia"), 1)
                        .add(Aspect.getAspect("tutamen"), 1).add(Aspect.getAspect("perditio"), 2));
        CrucibleRecipe leatherBootsBP = ThaumcraftApi.addCrucibleRecipe(
                "TB.Backprocessing",
                getModItem(Minecraft.ID, "leather", 4),
                getModItem(Minecraft.ID, "leather_boots", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 2).add(Aspect.getAspect("bestia"), 1)
                        .add(Aspect.getAspect("tutamen"), 1).add(Aspect.getAspect("perditio"), 2));

        TCHelper.addResearchPage("TB.Backprocessing", new ResearchPage(Objects.requireNonNull(leatherHelmetBP)));
        TCHelper.addResearchPage("TB.Backprocessing", new ResearchPage(Objects.requireNonNull(leatherChestplateBP)));
        TCHelper.addResearchPage("TB.Backprocessing", new ResearchPage(Objects.requireNonNull(leatherLeggingsBP)));
        TCHelper.addResearchPage("TB.Backprocessing", new ResearchPage(Objects.requireNonNull(leatherBootsBP)));
    }
}
