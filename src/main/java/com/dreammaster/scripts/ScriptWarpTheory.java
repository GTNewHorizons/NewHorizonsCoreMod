package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.BloodMagic;
import static gregtech.api.enums.Mods.CropsNH;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.OpenBlocks;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicBases;
import static gregtech.api.enums.Mods.ThaumicExploration;
import static gregtech.api.enums.Mods.ThaumicTinkerer;
import static gregtech.api.enums.Mods.WarpTheory;
import static gregtech.api.enums.Mods.Witchery;
import static com.dreammaster.scripts.IngredientFactory.getModItem;

import java.util.Arrays;
import java.util.List;

import com.dreammaster.thaumcraft.TCHelper;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
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
                AppliedEnergistics2.ID,
                BiomesOPlenty.ID,
                BloodMagic.ID,
                OpenBlocks.ID,
                Thaumcraft.ID,
                ThaumicBases.ID,
                ThaumicExploration.ID,
                ThaumicTinkerer.ID,
                WarpTheory.ID,
                Witchery.ID);
    }

    @Override
    public void loadRecipes() {
        TCHelper.removeArcaneRecipe(getModItem(WarpTheory.ID, "item.warptheory.paper", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(WarpTheory.ID, "item.warptheory.cleanserminor", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(WarpTheory.ID, "item.warptheory.cleanser", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(WarpTheory.ID, "item.warptheory.amulet", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(WarpTheory.ID, "item.warptheory.portableshower", 1, 0));
        TCHelper.clearPrereq("warptheory.paper");
        TCHelper.addResearchPrereq("warptheory.paper", "RESEARCHER2", false);
        TCHelper.clearPages("warptheory.paper");
        TCHelper.addResearchPage("warptheory.paper", new ResearchPage("research.warptheory.paper"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "warptheory.paper",
                getModItem(WarpTheory.ID, "item.warptheory.paper", 2, 0),
                new AspectList().add(Aspect.getAspect("aqua"), 8).add(Aspect.getAspect("terra"), 8),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                'e',
                getModItem(Minecraft.ID, "paper", 1, 0),
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14));
        TCHelper.addResearchPage(
                "warptheory.paper",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(WarpTheory.ID, "item.warptheory.paper", 1, 0))));
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
                getModItem(WarpTheory.ID, "item.warptheory.cleanserminor", 1, 0))
                        .setParents("ELDRITCHMINOR", "warptheory.paper")
                        .setPages(new ResearchPage("research.warptheory.warpcleanserminor")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "PURETEARMINOR",
                getModItem(WarpTheory.ID, "item.warptheory.cleanserminor", 1, 0),
                10,
                new AspectList().add(Aspect.getAspect("auram"), 64).add(Aspect.getAspect("desidia"), 16)
                        .add(Aspect.getAspect("fames"), 16).add(Aspect.getAspect("gelum"), 16)
                        .add(Aspect.getAspect("permutatio"), 32).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("venenum"), 32),
                getModItem(BiomesOPlenty.ID, "hardIce", 1, 0),
                getModItem(ThaumicBases.ID, "resource", 1, 5),
                getModItem(CropsNH.ID, "berry", 1, 2),
                getModItem(ThaumicBases.ID, "quicksilverBlock", 1, 0),
                OrePrefixes.cell.get(Materials.LifeEssence),
                getModItem(BloodMagic.ID, "magicales", 1, 0),
                getModItem(Witchery.ID, "ingredient", 1, 36),
                getModItem(ThaumicBases.ID, "resource", 1, 5),
                getModItem(CropsNH.ID, "berry", 1, 2),
                getModItem(ThaumicBases.ID, "quicksilverBlock", 1, 0),
                OrePrefixes.cell.get(Materials.LifeEssence),
                getModItem(BloodMagic.ID, "magicales", 1, 0),
                getModItem(Witchery.ID, "ingredient", 1, 36));
        TCHelper.addResearchPage(
                "PURETEARMINOR",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(WarpTheory.ID, "item.warptheory.cleanserminor", 1, 0))));
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
                getModItem(WarpTheory.ID, "item.warptheory.cleanser", 1, 0))
                        .setParents("ELDRITCHMAJOR", "warptheory.paper", "ICHORIUM")
                        .setPages(new ResearchPage("research.warptheory.warpcleanser")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "PURETEAR",
                getModItem(WarpTheory.ID, "item.warptheory.cleanser", 1, 0),
                10,
                new AspectList().add(Aspect.getAspect("alienis"), 32).add(Aspect.getAspect("permutatio"), 32)
                        .add(Aspect.getAspect("praecantatio"), 16).add(Aspect.getAspect("sano"), 16),
                getModItem(Minecraft.ID, "nether_star", 1, 0),
                OrePrefixes.ingot.get(Materials.Ichorium),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 10),
                OrePrefixes.lens.get(Materials.Diamond),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 11),
                getModItem(Minecraft.ID, "ghast_tear", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Minecraft.ID, "ghast_tear", 1, 0),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 11),
                OrePrefixes.lens.get(Materials.Diamond),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 10));
        TCHelper.addResearchPage(
                "PURETEAR",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(WarpTheory.ID, "item.warptheory.cleanser", 1, 0))));
        TCHelper.orphanResearch("warptheory.amulet");
        TCHelper.clearPrereq("warptheory.amulet");
        TCHelper.addResearchPrereq("warptheory.amulet", "PURETEAR", false);
        TCHelper.addInfusionCraftingRecipe(
                "warptheory.amulet",
                getModItem(WarpTheory.ID, "item.warptheory.amulet", 1, 0),
                16,
                new AspectList().add(Aspect.getAspect("alienis"), 64).add(Aspect.getAspect("auram"), 32)
                        .add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("praecantatio"), 64)
                        .add(Aspect.getAspect("permutatio"), 32),
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 0),
                getModItem(WarpTheory.ID, "item.warptheory.cleanser", 1, 0),
                OrePrefixes.screw.get(Materials.Thaumium),
                OrePrefixes.gemFlawless.get(Materials.Diamond),
                OrePrefixes.ingot.get(Materials.Ichorium),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                OrePrefixes.plate.get(Materials.Gold),
                OrePrefixes.screw.get(Materials.Thaumium),
                getModItem(WarpTheory.ID, "item.warptheory.cleanser", 1, 0),
                OrePrefixes.screw.get(Materials.Thaumium),
                OrePrefixes.gemFlawless.get(Materials.Diamond),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                OrePrefixes.ingot.get(Materials.Ichorium),
                OrePrefixes.plate.get(Materials.Gold),
                OrePrefixes.screw.get(Materials.Thaumium));
        TCHelper.setResearchAspects(
                "warptheory.amulet",
                new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("auram"), 15)
                        .add(Aspect.getAspect("potentia"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("permutatio"), 6).add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("warptheory.amulet", 4);

        TCHelper.orphanResearch("warptheory.portableshower");
        TCHelper.clearPrereq("warptheory.portableshower");
        TCHelper.addResearchPrereq("warptheory.portableshower", "PURETEAR", false);
        TCHelper.addInfusionCraftingRecipe(
                "warptheory.portableshower",
                getModItem(WarpTheory.ID, "item.warptheory.portableshower", 1, 0),
                64,
                new AspectList().add(Aspect.getAspect("custom1"), 16).add(Aspect.getAspect("custom5"), 16)
                        .add(Aspect.getAspect("aer"), 1024).add(Aspect.getAspect("aqua"), 1024)
                        .add(Aspect.getAspect("praecantatio"), 256).add(Aspect.getAspect("tutamen"), 256)
                        .add(Aspect.getAspect("cognitio"), 256).add(Aspect.getAspect("tutamen"), 256)
                        .add(Aspect.getAspect("sano"), 1024),
                getModItem(WarpTheory.ID, "item.warptheory.amulet", 1, 0),
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 12),
                getModItem(ThaumicExploration.ID, "everfullUrn", 1, 0),
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 0),
                getModItem(OpenBlocks.ID, "sprinkler", 1, 0),
                OrePrefixes.pipeTiny.get(Materials.Neutronium),
                getModItem(OpenBlocks.ID, "xpshower", 1, 0),
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 3),
                OrePrefixes.plateSuperdense.get(Materials.Ichorium));
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
