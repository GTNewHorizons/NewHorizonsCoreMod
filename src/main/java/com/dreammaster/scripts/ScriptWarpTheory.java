package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
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

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.dreammaster.thaumcraft.TCHelper;

import fox.spiteful.forbidden.DarkAspects;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TCAspects;
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
        TCHelper.removeArcaneRecipe(getModItem(WarpTheory.ID, "item.warptheory.oblivionpotion", 1, 0));
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
                new AspectList().add(Aspect.WATER, 8).add(Aspect.EARTH, 8),
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
        ThaumcraftApi.addArcaneCraftingRecipe(
                "warptheory.oblivionpotion",
                getModItem(WarpTheory.ID, "item.warptheory.oblivionpotion", 1, 0),
                TCHelper.equalPrimalList(25),
                "eze",
                "pbp",
                "gpg",
                'e',
                getModItem(OpenBlocks.ID, "epicEraser", 1),
                'z',
                getModItem(Thaumcraft.ID, "ItemZombieBrain", 1),
                'b',
                new ItemStack(Items.potionitem), // Water bottle
                'p',
                Materials.InfusedEntropy.getDust(1), // Perditio crystal dust
                'g',
                new ItemStack(Items.ghast_tear));
        TCHelper.addResearchPage(
                "warptheory.paper",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(WarpTheory.ID, "item.warptheory.paper", 1, 0))));
        TCHelper.setResearchAspects(
                "warptheory.paper",
                new AspectList().add(Aspect.ELDRITCH, 6).add(Aspect.MAGIC, 6).add(Aspect.ORDER, 9).add(Aspect.WATER, 3)
                        .add(Aspect.EARTH, 3));
        TCHelper.setResearchComplexity("warptheory.paper", 2);
        TCHelper.orphanResearch("FAKESOAP");
        TCHelper.removeResearch("FAKESOAP");
        TCHelper.orphanResearch("FAKEELDMAJOR");
        TCHelper.removeResearch("FAKEELDMAJOR");
        TCHelper.clearPrereq("warptheory.something");
        TCHelper.addResearchPrereq("warptheory.something", "warptheory.paper", false);
        TCHelper.setResearchAspects(
                "warptheory.something",
                new AspectList().add(Aspect.ELDRITCH, 12).add(Aspect.BEAST, 12).add(Aspect.EXCHANGE, 9)
                        .add(Aspect.LIFE, 6).add(Aspect.FLESH, 3));
        TCHelper.setResearchComplexity("warptheory.something", 2);
        ThaumcraftApi.addWarpToResearch("warptheory.something", 3);
        TCHelper.orphanResearch("warptheory.cleanserminor");
        TCHelper.removeResearch("warptheory.cleanserminor");
        new ResearchItem(
                "PURETEARMINOR",
                "WT_Category",
                new AspectList().add(Aspect.ELDRITCH, 6).add(Aspect.MAGIC, 6).add(Aspect.EXCHANGE, 4)
                        .add(Aspect.HEAL, 3).add(Aspect.EARTH, 2),
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
                new AspectList().add(Aspect.AURA, 64).add(DarkAspects.SLOTH, 16).add(Aspect.HUNGER, 16)
                        .add(Aspect.COLD, 16).add(Aspect.EXCHANGE, 32).add(Aspect.MAGIC, 32).add(Aspect.POISON, 32),
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
                        TCHelper.findInfusionRecipe(getModItem(WarpTheory.ID, "item.warptheory.cleanserminor", 1, 0))));
        TCHelper.orphanResearch("warptheory.cleanser");
        TCHelper.removeResearch("warptheory.cleanser");
        new ResearchItem(
                "PURETEAR",
                "WT_Category",
                new AspectList().add(Aspect.ELDRITCH, 12).add(Aspect.MAGIC, 12).add(Aspect.EXCHANGE, 9)
                        .add(Aspect.HEAL, 6).add(Aspect.EARTH, 3),
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
                new AspectList().add(Aspect.ELDRITCH, 32).add(Aspect.EXCHANGE, 32).add(Aspect.MAGIC, 16)
                        .add(Aspect.HEAL, 16),
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
                        TCHelper.findInfusionRecipe(getModItem(WarpTheory.ID, "item.warptheory.cleanser", 1, 0))));
        TCHelper.orphanResearch("warptheory.amulet");
        TCHelper.clearPrereq("warptheory.amulet");
        TCHelper.addResearchPrereq("warptheory.amulet", "PURETEAR", false);
        TCHelper.addInfusionCraftingRecipe(
                "warptheory.amulet",
                getModItem(WarpTheory.ID, "item.warptheory.amulet", 1, 0),
                16,
                new AspectList().add(Aspect.ELDRITCH, 64).add(Aspect.AURA, 32).add(Aspect.ENERGY, 32)
                        .add(Aspect.MAGIC, 64).add(Aspect.EXCHANGE, 32),
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
                new AspectList().add(Aspect.ELDRITCH, 15).add(Aspect.AURA, 15).add(Aspect.ENERGY, 12)
                        .add(Aspect.MAGIC, 9).add(Aspect.EXCHANGE, 6).add(Aspect.EARTH, 3));
        TCHelper.setResearchComplexity("warptheory.amulet", 4);

        TCHelper.orphanResearch("warptheory.portableshower");
        TCHelper.clearPrereq("warptheory.portableshower");
        TCHelper.addResearchPrereq("warptheory.portableshower", "PURETEAR", false);
        TCHelper.addInfusionCraftingRecipe(
                "warptheory.portableshower",
                getModItem(WarpTheory.ID, "item.warptheory.portableshower", 1, 0),
                64,
                new AspectList().add(TCAspects.AEQUALITAS.getAspect(), 16).add(TCAspects.GLORIA.getAspect(), 16)
                        .add(Aspect.AIR, 1024).add(Aspect.WATER, 1024).add(Aspect.MAGIC, 256).add(Aspect.ARMOR, 512)
                        .add(Aspect.MIND, 256).add(Aspect.HEAL, 1024),
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
                new AspectList().add(TCAspects.AEQUALITAS.getAspect(), 5).add(TCAspects.PRIMORDIUM.getAspect(), 5)
                        .add(Aspect.ENERGY, 32).add(Aspect.MAGIC, 20).add(Aspect.WATER, 32).add(Aspect.AIR, 32));
        TCHelper.setResearchComplexity("warptheory.portableshower", 4);
        TCHelper.refreshResearchPages("warptheory.paper");
        TCHelper.refreshResearchPages("warptheory.something");
        TCHelper.refreshResearchPages("warptheory.amulet");
        TCHelper.refreshResearchPages("warptheory.portableshower");
        TCHelper.refreshResearchPages("warptheory.oblivionpotion");
        ThaumcraftApi.registerObjectTag(
                getModItem(WarpTheory.ID, "item.warptheory.oblivionpotion", 1, 0),
                new AspectList().add(TCAspects.STRONTIO.getAspect(), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem(WarpTheory.ID, "item.warptheory.something", 1, 0),
                new AspectList().add(TCAspects.VESANIA.getAspect(), 2).add(Aspect.HUNGER, 4).add(Aspect.FLESH, 4));
    }
}
