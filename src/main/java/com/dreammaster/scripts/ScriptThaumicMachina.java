package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicMachina;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import com.dreammaster.thaumcraft.TCHelper;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchPage;

public class ScriptThaumicMachina implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Thaumic Machina";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(ThaumicMachina.ID, Thaumcraft.ID);
    }

    @Override
    public void loadRecipes() {
        TCHelper.orphanResearch("@TMTHAUMATURGY");
        TCHelper.removeResearch("@TMTHAUMATURGY");
        TCHelper.removeArcaneRecipe(getModItem(ThaumicMachina.ID, "wandAugmentationCore", 1, 0, missing));
        TCHelper.orphanResearch("@WAND_AUGMENTATION_TAINTED_CORE");
        TCHelper.removeResearch("@WAND_AUGMENTATION_TAINTED_CORE");
        TCHelper.orphanResearch("@WAND_AUGMENTATION_TAINT_CAPPING");
        TCHelper.removeResearch("@WAND_AUGMENTATION_TAINT_CAPPING");
        TCHelper.setResearchAspects(
                "@WAND_STABILITY",
                new AspectList().add(Aspect.getAspect("perditio"), 3).add(Aspect.getAspect("ordo"), 12)
                        .add(Aspect.getAspect("instrumentum"), 6).add(Aspect.getAspect("praecantatio"), 9));
        TCHelper.setResearchComplexity("@WAND_STABILITY", 3);
        TCHelper.setResearchAspects(
                "@WAND_STUDIES",
                new AspectList().add(Aspect.getAspect("perditio"), 3).add(Aspect.getAspect("auram"), 9)
                        .add(Aspect.getAspect("cognitio"), 15).add(Aspect.getAspect("ordo"), 12)
                        .add(Aspect.getAspect("instrumentum"), 6));
        TCHelper.setResearchComplexity("@WAND_STUDIES", 3);
        TCHelper.clearPages("@WAND_AUGMENTATION");
        TCHelper.addResearchPrereq("@WAND_AUGMENTATION", "MIRROR", false);
        ResearchCategories.getResearch("@WAND_AUGMENTATION").setConcealed();
        TCHelper.addResearchPage("@WAND_AUGMENTATION", new ResearchPage("tm.research.page.WAND_AUGMENTATION.1"));
        TCHelper.addResearchPage("@WAND_AUGMENTATION", new ResearchPage("tm.research.page.WAND_AUGMENTATION.2"));
        TCHelper.addResearchPage("@WAND_AUGMENTATION", new ResearchPage("tm.research.page.WAND_AUGMENTATION.3"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "@WAND_AUGMENTATION",
                getModItem(ThaumicMachina.ID, "wandAugmentationCore", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 35).add(Aspect.getAspect("perditio"), 35),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                'b',
                "plateEnergeticAlloy",
                'c',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                'd',
                "plateEnergeticAlloy",
                'e',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 10, missing),
                'f',
                "plateEnergeticAlloy",
                'g',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                'h',
                "plateEnergeticAlloy",
                'i',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing));
        TCHelper.addResearchPage(
                "@WAND_AUGMENTATION",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem(ThaumicMachina.ID, "wandAugmentationCore", 1, 0, missing))));
        TCHelper.setResearchAspects(
                "@WAND_AUGMENTATION",
                new AspectList().add(Aspect.getAspect("instrumentum"), 3).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("ordo"), 9).add(Aspect.getAspect("machina"), 12)
                        .add(Aspect.getAspect("perditio"), 15));
        TCHelper.setResearchComplexity("@WAND_AUGMENTATION", 3);
        TCHelper.setResearchAspects(
                "@VIS",
                new AspectList().add(Aspect.getAspect("alienis"), 3).add(Aspect.getAspect("auram"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6));
        TCHelper.setResearchComplexity("@VIS", 2);
        TCHelper.setResearchAspects(
                "@VIS_STUDIES",
                new AspectList().add(Aspect.getAspect("alienis"), 3).add(Aspect.getAspect("auram"), 12)
                        .add(Aspect.getAspect("cognitio"), 6).add(Aspect.getAspect("potentia"), 9)
                        .add(Aspect.getAspect("praecantatio"), 15));
        TCHelper.setResearchComplexity("@VIS_STUDIES", 3);
        TCHelper.setResearchAspects(
                "@VIS_CHARGE",
                new AspectList().add(Aspect.getAspect("alienis"), 3).add(Aspect.getAspect("auram"), 12)
                        .add(Aspect.getAspect("potentia"), 6).add(Aspect.getAspect("perditio"), 9)
                        .add(Aspect.getAspect("praecantatio"), 15));
        TCHelper.setResearchComplexity("@VIS_CHARGE", 3);
        TCHelper.setResearchAspects(
                "@NODAL_STUDIES",
                new AspectList().add(Aspect.getAspect("alienis"), 3).add(Aspect.getAspect("auram"), 12)
                        .add(Aspect.getAspect("cognitio"), 15).add(Aspect.getAspect("praecantatio"), 15));
        TCHelper.setResearchComplexity("@NODAL_STUDIES", 3);
        TCHelper.setResearchAspects(
                "@AURA_FIELD",
                new AspectList().add(Aspect.getAspect("alienis"), 3).add(Aspect.getAspect("auram"), 12)
                        .add(Aspect.getAspect("potentia"), 6).add(Aspect.getAspect("vacuos"), 9)
                        .add(Aspect.getAspect("praecantatio"), 15));
        TCHelper.setResearchComplexity("@AURA_FIELD", 3);
        TCHelper.setResearchAspects(
                "@CRIMSON_ASTRONOMY",
                new AspectList().add(Aspect.getAspect("alienis"), 3).add(Aspect.getAspect("auram"), 12)
                        .add(Aspect.getAspect("tenebrae"), 6).add(Aspect.getAspect("vacuos"), 9)
                        .add(Aspect.getAspect("praecantatio"), 15));
        TCHelper.setResearchComplexity("@CRIMSON_ASTRONOMY", 3);
        TCHelper.setResearchAspects(
                "@CRIMSON_REALISATION",
                new AspectList().add(Aspect.getAspect("alienis"), 3).add(Aspect.getAspect("auram"), 12)
                        .add(Aspect.getAspect("tenebrae"), 6).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("potentia"), 15));
        TCHelper.setResearchComplexity("@CRIMSON_REALISATION", 3);
        TCHelper.setResearchAspects(
                "@CRIMSON_CELESTIAL_FIELD",
                new AspectList().add(Aspect.getAspect("alienis"), 3).add(Aspect.getAspect("auram"), 12)
                        .add(Aspect.getAspect("tenebrae"), 6).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("vacuos"), 18));
        TCHelper.setResearchComplexity("@CRIMSON_CELESTIAL_FIELD", 3);
        TCHelper.setResearchAspects(
                "@CRIMSON_THAUMATURGY",
                new AspectList().add(Aspect.getAspect("alienis"), 3).add(Aspect.getAspect("instrumentum"), 12)
                        .add(Aspect.getAspect("tenebrae"), 6).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("ordo"), 15));
        TCHelper.setResearchComplexity("@CRIMSON_THAUMATURGY", 3);
        TCHelper.setResearchAspects(
                "@CRIMSON_WAND_AUGMENTATION",
                new AspectList().add(Aspect.getAspect("alienis"), 3).add(Aspect.getAspect("tenebrae"), 6)
                        .add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("machina"), 18)
                        .add(Aspect.getAspect("cognitio"), 21));
        TCHelper.setResearchComplexity("@CRIMSON_WAND_AUGMENTATION", 3);
        TCHelper.setResearchAspects(
                "@WAND_AUGMENTATION_CHARGE_BUFFER",
                new AspectList().add(Aspect.getAspect("instrumentum"), 3).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("potentia"), 12).add(Aspect.getAspect("vacuos"), 9)
                        .add(Aspect.getAspect("tenebrae"), 15).add(Aspect.getAspect("alienis"), 18));
        TCHelper.setResearchComplexity("@WAND_AUGMENTATION_CHARGE_BUFFER", 3);
        TCHelper.setResearchAspects(
                "@WAND_AUGMENTATION_VIS_CHANNEL",
                new AspectList().add(Aspect.getAspect("instrumentum"), 3).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("aqua"), 9).add(Aspect.getAspect("tenebrae"), 12)
                        .add(Aspect.getAspect("alienis"), 15));
        TCHelper.setResearchComplexity("@WAND_AUGMENTATION_VIS_CHANNEL", 3);
        TCHelper.setResearchAspects(
                "@WAND_AUGMENTATION_CONTACT_DISCHARGE",
                new AspectList().add(Aspect.getAspect("instrumentum"), 3).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("potentia"), 12).add(Aspect.getAspect("tenebrae"), 15)
                        .add(Aspect.getAspect("alienis"), 18).add(Aspect.getAspect("telum"), 21));
        TCHelper.setResearchComplexity("@WAND_AUGMENTATION_CONTACT_DISCHARGE", 3);
        ThaumcraftApi.addWarpToResearch("@WAND_AUGMENTATION_CONTACT_DISCHARGE", 5);
    }
}
