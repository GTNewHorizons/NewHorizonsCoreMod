package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.BloodMagic;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.OpenBlocks;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicBases;
import static gregtech.api.enums.Mods.ThaumicExploration;
import static gregtech.api.enums.Mods.ThaumicTinkerer;
import static gregtech.api.enums.Mods.WarpTheory;
import static gregtech.api.enums.Mods.Witchery;
import static gregtech.api.util.GTModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

import com.dreammaster.thaumcraft.TCHelper;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ScriptWarpTheory implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Warp Theory";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                WarpTheory.ID,
                Thaumcraft.ID,
                BiomesOPlenty.ID,
                ThaumicBases.ID,
                BloodMagic.ID,
                Witchery.ID,
                AppliedEnergistics2.ID);
    }

    @Override
    public void loadRecipes() {
        TCHelper.removeArcaneRecipe(getModItem(WarpTheory.ID, "item.warptheory.paper", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(WarpTheory.ID, "item.warptheory.cleanserminor", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(WarpTheory.ID, "item.warptheory.cleanser", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(WarpTheory.ID, "item.warptheory.amulet", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(WarpTheory.ID, "item.warptheory.portableshower", 1, 0, missing));
        TCHelper.clearPrereq("warptheory.paper");
        TCHelper.addResearchPrereq("warptheory.paper", "RESEARCHER2", false);
        TCHelper.clearPages("warptheory.paper");
        TCHelper.addResearchPage("warptheory.paper", new ResearchPage("research.warptheory.paper"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "warptheory.paper",
                getModItem(WarpTheory.ID, "item.warptheory.paper", 2, 0, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 8).add(Aspect.getAspect("terra"), 8),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                'e',
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing));
        TCHelper.addResearchPage(
                "warptheory.paper",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(WarpTheory.ID, "item.warptheory.paper", 1, 0, missing))));
        TCHelper.setResearchAspects(
                "warptheory.paper",
                new AspectList().add(Aspect.getAspect("alienis"), 6).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("ordo"), 9).add(Aspect.getAspect("aqua"), 3)
                        .add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("warptheory.paper", 2);
        TCHelper.orphanResearch("FAKESOAP");
        TCHelper.removeResearch("FAKESOAP");
        TCHelper.orphanResearch("FAKEELDMAJOR");
        TCHelper.removeResearch("FAKEELDMAJOR");
        TCHelper.clearPrereq("warptheory.something");
        TCHelper.addResearchPrereq("warptheory.something", "warptheory.paper", false);
        TCHelper.setResearchAspects(
                "warptheory.something",
                new AspectList().add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("bestia"), 12)
                        .add(Aspect.getAspect("permutatio"), 9).add(Aspect.getAspect("victus"), 6)
                        .add(Aspect.getAspect("corpus"), 3));
        TCHelper.setResearchComplexity("warptheory.something", 2);
        ThaumcraftApi.addWarpToResearch("warptheory.something", 3);
        TCHelper.orphanResearch("warptheory.cleanserminor");
        TCHelper.removeResearch("warptheory.cleanserminor");
        new ResearchItem(
                "PURETEARMINOR",
                "WT_Category",
                new AspectList().add(Aspect.getAspect("alienis"), 6).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("permutatio"), 4).add(Aspect.getAspect("sano"), 3)
                        .add(Aspect.getAspect("terra"), 2),
                -1,
                -2,
                2,
                getModItem(WarpTheory.ID, "item.warptheory.cleanserminor", 1, 0, missing))
                        .setParents("ELDRITCHMINOR", "warptheory.paper")
                        .setPages(new ResearchPage("research.warptheory.warpcleanserminor")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "PURETEARMINOR",
                getModItem(WarpTheory.ID, "item.warptheory.cleanserminor", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("auram"), 64).add(Aspect.getAspect("desidia"), 16)
                        .add(Aspect.getAspect("fames"), 16).add(Aspect.getAspect("gelum"), 16)
                        .add(Aspect.getAspect("permutatio"), 32).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("venenum"), 32),
                getModItem(BiomesOPlenty.ID, "hardIce", 1, 0, missing),
                new ItemStack[] { getModItem(ThaumicBases.ID, "resource", 1, 5, missing),
                        ItemList.Crop_Drop_MTomato.get(1L),
                        getModItem(ThaumicBases.ID, "quicksilverBlock", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.cell, Materials.LifeEssence, 1L),
                        getModItem(BloodMagic.ID, "magicales", 1, 0, missing),
                        getModItem(Witchery.ID, "ingredient", 1, 36, missing),
                        getModItem(ThaumicBases.ID, "resource", 1, 5, missing), ItemList.Crop_Drop_MTomato.get(1L),
                        getModItem(ThaumicBases.ID, "quicksilverBlock", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.cell, Materials.LifeEssence, 1L),
                        getModItem(BloodMagic.ID, "magicales", 1, 0, missing),
                        getModItem(Witchery.ID, "ingredient", 1, 36, missing), });
        TCHelper.addResearchPage(
                "PURETEARMINOR",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(WarpTheory.ID, "item.warptheory.cleanserminor", 1, 0, missing))));
        TCHelper.orphanResearch("warptheory.cleanser");
        TCHelper.removeResearch("warptheory.cleanser");
        new ResearchItem(
                "PURETEAR",
                "WT_Category",
                new AspectList().add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("permutatio"), 9).add(Aspect.getAspect("sano"), 6)
                        .add(Aspect.getAspect("terra"), 3),
                -4,
                -1,
                3,
                getModItem(WarpTheory.ID, "item.warptheory.cleanser", 1, 0, missing))
                        .setParents("ELDRITCHMAJOR", "warptheory.paper", "ICHORIUM")
                        .setPages(new ResearchPage("research.warptheory.warpcleanser")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "PURETEAR",
                getModItem(WarpTheory.ID, "item.warptheory.cleanser", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("alienis"), 32).add(Aspect.getAspect("permutatio"), 32)
                        .add(Aspect.getAspect("praecantatio"), 16).add(Aspect.getAspect("sano"), 16),
                getModItem(Minecraft.ID, "nether_star", 1, 0, missing),
                new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Ichorium, 1L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 10, missing),
                        GTOreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 11, missing),
                        getModItem(Minecraft.ID, "ghast_tear", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                        getModItem(Minecraft.ID, "ghast_tear", 1, 0, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 11, missing),
                        GTOreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 10, missing), });
        TCHelper.addResearchPage(
                "PURETEAR",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(WarpTheory.ID, "item.warptheory.cleanser", 1, 0, missing))));
        TCHelper.orphanResearch("warptheory.amulet");
        TCHelper.clearPrereq("warptheory.amulet");
        TCHelper.addResearchPrereq("warptheory.amulet", "PURETEAR", false);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "warptheory.amulet",
                getModItem(WarpTheory.ID, "item.warptheory.amulet", 1, 0, missing),
                16,
                new AspectList().add(Aspect.getAspect("alienis"), 64).add(Aspect.getAspect("auram"), 32)
                        .add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("praecantatio"), 64)
                        .add(Aspect.getAspect("permutatio"), 32),
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 0, missing),
                new ItemStack[] { getModItem(WarpTheory.ID, "item.warptheory.cleanser", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Thaumium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.gemFlawless, Materials.Diamond, 1L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Ichorium, 1L),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Thaumium, 1L),
                        getModItem(WarpTheory.ID, "item.warptheory.cleanser", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Thaumium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.gemFlawless, Materials.Diamond, 1L),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Ichorium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Thaumium, 1L), });
        TCHelper.setResearchAspects(
                "warptheory.amulet",
                new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("auram"), 15)
                        .add(Aspect.getAspect("potentia"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("permutatio"), 6).add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("warptheory.amulet", 4);

        TCHelper.orphanResearch("warptheory.portableshower");
        TCHelper.clearPrereq("warptheory.portableshower");
        TCHelper.addResearchPrereq("warptheory.portableshower", "PURETEAR", false);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "warptheory.portableshower",
                getModItem(WarpTheory.ID, "item.warptheory.portableshower", 1, 0, missing),
                64,
                new AspectList().add(Aspect.getAspect("custom1"), 16).add(Aspect.getAspect("custom5"), 16)
                        .add(Aspect.getAspect("aer"), 1024).add(Aspect.getAspect("aqua"), 1024)
                        .add(Aspect.getAspect("praecantatio"), 256).add(Aspect.getAspect("tutamen"), 256)
                        .add(Aspect.getAspect("cognitio"), 256).add(Aspect.getAspect("tutamen"), 256)
                        .add(Aspect.getAspect("sano"), 1024),
                getModItem(WarpTheory.ID, "item.warptheory.amulet", 1, 0, missing),
                new ItemStack[] { getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                        getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 12, missing),
                        getModItem(ThaumicExploration.ID, "everfullUrn", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 0, missing),
                        getModItem(OpenBlocks.ID, "sprinkler", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Neutronium, 1L),
                        getModItem(OpenBlocks.ID, "xpshower", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemEldritchObject", 1L, 3),
                        GTOreDictUnificator.get(OrePrefixes.plateSuperdense, Materials.Ichorium, 1L) });
        TCHelper.setResearchAspects(
                "warptheory.portableshower",
                new AspectList().add(Aspect.getAspect("custom1"), 5).add(Aspect.getAspect("custom3"), 5)
                        .add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("praecantatio"), 20)
                        .add(Aspect.getAspect("aqua"), 32).add(Aspect.getAspect("aer"), 32));
        TCHelper.setResearchComplexity("warptheory.portableshower", 4);
        TCHelper.refreshResearchPages("warptheory.paper");
        TCHelper.refreshResearchPages("warptheory.something");
        TCHelper.refreshResearchPages("warptheory.amulet");
        TCHelper.refreshResearchPages("warptheory.portableshower");
    }
}
