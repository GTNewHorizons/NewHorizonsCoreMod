package com.dreammaster.scripts;

import static bartworks.system.material.WerkstoffLoader.Fluorspar;
import static bartworks.system.material.WerkstoffLoader.RedZircon;
import static com.dreammaster.scripts.IngredientFactory.createItemStack;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.Botania;
import static gregtech.api.enums.Mods.BuildCraftFactory;
import static gregtech.api.enums.Mods.Chisel;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.Fether;
import static gregtech.api.enums.Mods.ForbiddenMagic;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.GalacticraftMars;
import static gregtech.api.enums.Mods.IguanaTweaksTinkerConstruct;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.MagicBees;
import static gregtech.api.enums.Mods.MalisisDoors;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.ProjectRedIntegration;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.RandomThings;
import static gregtech.api.enums.Mods.StevesCarts2;
import static gregtech.api.enums.Mods.TaintedMagic;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicBases;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.enums.Mods.Witchery;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.autoclaveRecipes;
import static gregtech.api.recipe.RecipeMaps.compressorRecipes;
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidExtractionRecipes;
import static gregtech.api.recipe.RecipeMaps.laserEngraverRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.recipe.RecipeMaps.mixerRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gregtech.common.items.IDMetaTool01.BUTCHERYKNIFE;
import static gregtech.common.items.IDMetaTool01.KNIFE;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.chisel.ChiselHelper;
import com.dreammaster.item.NHItemList;
import com.dreammaster.thaumcraft.TCHelper;

import goodgenerator.items.GGMaterial;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gregtech.common.items.MetaGeneratedItem98;
import gregtech.common.items.MetaGeneratedTool01;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ScriptThaumcraft implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Thaumcraft";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                Backpack.ID,
                BiomesOPlenty.ID,
                Botania.ID,
                BuildCraftFactory.ID,
                Chisel.ID,
                ExtraUtilities.ID,
                Fether.ID,
                ForbiddenMagic.ID,
                Forestry.ID,
                GalacticraftCore.ID,
                GalacticraftMars.ID,
                IguanaTweaksTinkerConstruct.ID,
                IndustrialCraft2.ID,
                MagicBees.ID,
                MalisisDoors.ID,
                Natura.ID,
                PamsHarvestCraft.ID,
                ProjectRedIntegration.ID,
                Railcraft.ID,
                RandomThings.ID,
                StevesCarts2.ID,
                TaintedMagic.ID,
                Thaumcraft.ID,
                ThaumicBases.ID,
                TinkerConstruct.ID,
                TwilightForest.ID,
                Witchery.ID);
    }

    @Override
    public void loadRecipes() {

        basics();
        thaumaturgy();
        alchemy();
        artifice();
        golemancy();
        eldritch();
        aspectAdds();

    }

    private void basics() {
        // BASICS

        ChiselHelper
                .addVariationFromStack("thaumium", GTOreDictUnificator.get(OrePrefixes.block, Materials.Thaumium, 1L));

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Amber, 1L))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemResource", 1, 6)).outputChances(7000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).duration(1 * MINUTES + 40 * SECONDS).eut(24)
                .addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Amber, 1L))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemResource", 1, 6)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 100)).duration(1 * MINUTES + 15 * SECONDS)
                .eut(24).addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Amber, 1L))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemResource", 1, 6)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 36)).duration(50 * SECONDS).eut(24)
                .addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Fether.ID, "glow_flower_seeds", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Blaze, 8L))
                .itemOutputs(getModItem(Thaumcraft.ID, "blockCustomPlant", 1, 3)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Fether.ID, "glow_flower_seeds", 1, 0),
                        getModItem(Thaumcraft.ID, "ItemNugget", 8, 5))
                .itemOutputs(getModItem(Thaumcraft.ID, "blockCustomPlant", 1, 2)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Glass Phial
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glass_bottle),
                        GTOreDictUnificator.get(OrePrefixes.round, Materials.Rubber, 1))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemEssence", 1, 0)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glass_bottle),
                        GTOreDictUnificator.get(OrePrefixes.round, Materials.RubberSilicone, 1))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemEssence", 1, 0)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glass_bottle),
                        GTOreDictUnificator.get(OrePrefixes.round, Materials.StyreneButadieneRubber, 1))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemEssence", 1, 0)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);

        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockTable", 1, 14));
        TCHelper.clearPages("PLANTS");
        TCHelper.addResearchPage("PLANTS", new ResearchPage("tc.research_page.PLANTS.1"));
        TCHelper.addResearchPage(
                "PLANTS",
                new ResearchPage(TCHelper.findCraftingRecipe(getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6))));
        TCHelper.addResearchPage("PLANTS", new ResearchPage("tc.research_page.PLANTS.2"));
        TCHelper.addResearchPage(
                "PLANTS",
                new ResearchPage(TCHelper.findCraftingRecipe(getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 7))));
        TCHelper.addResearchPage("PLANTS", new ResearchPage("tc.research_page.PLANTS.3"));
        TCHelper.addResearchPage("PLANTS", new ResearchPage("tc.research_page.PLANTS.4"));
        TCHelper.addResearchPage("PLANTS", new ResearchPage("tc.research_page.PLANTS.5"));
        TCHelper.addResearchPage("PLANTS", new ResearchPage("tc.research_page.PLANTS.6"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ASPECTS",
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("terra"), 5)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ordo"), 5).add(Aspect.getAspect("perditio"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 0),
                'b',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 0),
                'c',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 0),
                'e',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 0),
                'g',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 0),
                'h',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 0),
                'i',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 0));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ASPECTS",
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("terra"), 5)
                        .add(Aspect.getAspect("ignis"), 10).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ordo"), 5).add(Aspect.getAspect("perditio"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 1),
                'b',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 1),
                'c',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 1),
                'e',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 1),
                'g',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 1),
                'h',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 1),
                'i',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 1));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ASPECTS",
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("terra"), 5)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("aqua"), 10)
                        .add(Aspect.getAspect("ordo"), 5).add(Aspect.getAspect("perditio"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 2),
                'b',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 2),
                'c',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 2),
                'e',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 2),
                'g',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 2),
                'h',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 2),
                'i',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 2));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ASPECTS",
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("terra"), 10)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ordo"), 5).add(Aspect.getAspect("perditio"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 3),
                'b',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 3),
                'c',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 3),
                'e',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 3),
                'g',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 3),
                'h',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 3),
                'i',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 3));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ASPECTS",
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("terra"), 5)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("perditio"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 4),
                'b',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 4),
                'c',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 4),
                'e',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 4),
                'g',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 4),
                'h',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 4),
                'i',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 4));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ASPECTS",
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("terra"), 5)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ordo"), 5).add(Aspect.getAspect("perditio"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 5),
                'b',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 5),
                'c',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 5),
                'e',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 5),
                'g',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 5),
                'h',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 5),
                'i',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 5));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ASPECTS",
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("terra"), 10)
                        .add(Aspect.getAspect("ignis"), 10).add(Aspect.getAspect("aqua"), 10)
                        .add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("perditio"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 0),
                'b',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 1),
                'c',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 2),
                'd',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 6),
                'e',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 6),
                'f',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 6),
                'g',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 3),
                'h',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 4),
                'i',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 5));
        TCHelper.clearPages("ORE");
        TCHelper.addResearchPage("ORE", new ResearchPage("tc.research_page.ORE.1"));
        TCHelper.addResearchPage("ORE", new ResearchPage("tc.research_page.ORE.2"));
        TCHelper.addResearchPage(
                "ORE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "blockCrystal", 1, 0))));
        TCHelper.addResearchPage(
                "ORE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "blockCrystal", 1, 1))));
        TCHelper.addResearchPage(
                "ORE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "blockCrystal", 1, 2))));
        TCHelper.addResearchPage(
                "ORE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "blockCrystal", 1, 3))));
        TCHelper.addResearchPage(
                "ORE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "blockCrystal", 1, 4))));
        TCHelper.addResearchPage(
                "ORE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "blockCrystal", 1, 5))));
        TCHelper.addResearchPage(
                "ORE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "blockCrystal", 1, 6))));
        TCHelper.addResearchPage("ORE", new ResearchPage("tc.research_page.ORE.3"));
        TCHelper.addResearchPage("ORE", new ResearchPage("tc.research_page.ORE.4"));
        TCHelper.setResearchAspects(
                "RESEARCHER1",
                new AspectList().add(Aspect.getAspect("cognitio"), 6).add(Aspect.getAspect("sensus"), 6)
                        .add(Aspect.getAspect("ordo"), 6).add(Aspect.getAspect("lux"), 3));
        TCHelper.setResearchComplexity("RESEARCHER1", 1);
        TCHelper.setResearchAspects(
                "RESEARCHER2",
                new AspectList().add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("sensus"), 9)
                        .add(Aspect.getAspect("ordo"), 6).add(Aspect.getAspect("lux"), 6)
                        .add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("RESEARCHER2", 2);
        TCHelper.setResearchAspects(
                "NODETAPPER1",
                new AspectList().add(Aspect.getAspect("permutatio"), 9).add(Aspect.getAspect("auram"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("motus"), 3));
        TCHelper.setResearchComplexity("NODETAPPER1", 2);
        TCHelper.setResearchAspects(
                "NODETAPPER2",
                new AspectList().add(Aspect.getAspect("permutatio"), 12).add(Aspect.getAspect("auram"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("motus"), 6)
                        .add(Aspect.getAspect("potentia"), 3));
        TCHelper.setResearchComplexity("NODETAPPER2", 3);
        TCHelper.setResearchAspects(
                "NODEPRESERVE",
                new AspectList().add(Aspect.getAspect("perditio"), 9).add(Aspect.getAspect("cognitio"), 9)
                        .add(Aspect.getAspect("fabrico"), 6).add(Aspect.getAspect("instrumentum"), 3));
        TCHelper.setResearchComplexity("NODEPRESERVE", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DECONSTRUCTOR",
                getModItem(Thaumcraft.ID, "blockTable", 1, 14),
                new AspectList().add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("perditio"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "screwThaumium",
                'b',
                getModItem(Thaumcraft.ID, "ItemThaumometer", 1, 0),
                'c',
                "screwThaumium",
                'd',
                getModItem(Thaumcraft.ID, "ItemPickThaumium", 1, 0),
                'e',
                getModItem(Thaumcraft.ID, "blockTable", 1, 0),
                'f',
                getModItem(Thaumcraft.ID, "ItemAxeThaumium", 1, 0),
                'g',
                "plateThaumium",
                'h',
                "craftingToolScrewdriver",
                'i',
                "plateThaumium");
        TCHelper.setResearchAspects(
                "DECONSTRUCTOR",
                new AspectList().add(Aspect.getAspect("sensus"), 9).add(Aspect.getAspect("auram"), 9)
                        .add(Aspect.getAspect("lucrum"), 6).add(Aspect.getAspect("fames"), 3));
        TCHelper.setResearchComplexity("DECONSTRUCTOR", 2);
        TCHelper.setResearchAspects(
                "NODEJAR",
                new AspectList().add(Aspect.getAspect("auram"), 12).add(Aspect.getAspect("motus"), 12)
                        .add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("permutatio"), 6)
                        .add(Aspect.getAspect("vitreus"), 3));
        TCHelper.setResearchComplexity("NODEJAR", 3);
        TCHelper.setResearchAspects(
                "RESEARCHDUPE",
                new AspectList().add(Aspect.getAspect("sensus"), 12).add(Aspect.getAspect("cognitio"), 12)
                        .add(Aspect.getAspect("fabrico"), 12).add(Aspect.getAspect("lucrum"), 9)
                        .add(Aspect.getAspect("perditio"), 6).add(Aspect.getAspect("potentia"), 3));
        TCHelper.setResearchComplexity("RESEARCHDUPE", 3);
        TCHelper.refreshResearchPages("DECONSTRUCTOR");
        new ResearchItem("WARPWARNING", "BASICS", new AspectList(), 1, 1, 1, getModItem(Minecraft.ID, "skull", 1, 1))
                .registerResearchItem();
        TCHelper.addResearchSibling("WARP", "WARPWARNING");
        TCHelper.addResearchSibling("RESEARCH", "WARPWARNING");
        ResearchCategories.getResearch("WARPWARNING").setAutoUnlock();
        ResearchCategories.getResearch("WARPWARNING").setSpecial();
        TCHelper.addResearchPage("WARPWARNING", new ResearchPage("WARPTHEORY.research_page.WARPWARNING.1"));
        TCHelper.addResearchPage("WARPWARNING", new ResearchPage("WARPTHEORY.research_page.WARPWARNING.2"));
        TCHelper.addResearchPage("WARPWARNING", new ResearchPage("WARPTHEORY.research_page.WARPWARNING.3"));
        TCHelper.addResearchPage("WARPWARNING", new ResearchPage("WARPTHEORY.research_page.WARPWARNING.4"));
        TCHelper.addResearchPage("WARPWARNING", new ResearchPage("WARPTHEORY.research_page.WARPWARNING.5"));
        TCHelper.addResearchPage("WARPWARNING", new ResearchPage("WARPTHEORY.research_page.WARPWARNING.6"));

    }

    private void thaumaturgy() {
        // THAUMATURGY

        addShapedRecipe(
                getModItem(Thaumcraft.ID, "WandCap", 1, 0),
                "screwIron",
                "foilIron",
                "screwIron",
                "foilIron",
                "ringIron",
                "foilIron",
                "screwIron",
                "foilIron",
                "screwIron");

        addShapedRecipe(
                createItemStack(Thaumcraft.ID, "WandCasting", 1, 0, "{aqua:0,terra:0,ignis:0,ordo:0,perditio:0,aer:0}"),
                getModItem(TwilightForest.ID, "item.nagaScale", 1, 0),
                "screwAluminium",
                getModItem(Thaumcraft.ID, "WandCap", 1, 0),
                "screwAluminium",
                getModItem(Forestry.ID, "oakStick", 1, 0),
                "screwAluminium",
                getModItem(Thaumcraft.ID, "WandCap", 1, 0),
                "screwAluminium",
                getModItem(TwilightForest.ID, "item.nagaScale", 1, 0));

        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "resource", 1, 2));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "WandCap", 1, 1));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "WandCap", 1, 3));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "WandCap", 1, 5));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "WandCap", 1, 6));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "WandCap", 1, 8));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "WandCap", 1, 4));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "WandCap", 1, 2));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "WandCap", 1, 7));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "WandRod", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "WandRod", 1, 1));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "WandRod", 1, 3));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "WandRod", 1, 4));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "WandRod", 1, 5));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "WandRod", 1, 6));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "WandRod", 1, 7));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "WandRod", 1, 2));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "WandRod", 1, 50));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "WandRod", 1, 51));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "WandRod", 1, 52));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "WandRod", 1, 53));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "WandRod", 1, 54));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "WandRod", 1, 55));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "WandRod", 1, 56));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "WandRod", 1, 57));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "FocusFire", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "FocusExcavation", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "FocusFrost", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "FocusShock", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "FocusTrade", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "FocusPouch", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 9));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 10));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 11));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockMetalDevice", 2, 14));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 5));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "FocusWarding", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "FocusPortableHole", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "FocusHellbat", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemAmuletVis", 1, 1));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 8));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 2));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 13));
        TCHelper.clearPages("BASICTHAUMATURGY");
        TCHelper.addResearchPage("BASICTHAUMATURGY", new ResearchPage("tc.research_page.BASICTHAUMATURGY.1"));
        TCHelper.addResearchPage("BASICTHAUMATURGY", new ResearchPage("tc.research_page.BASICTHAUMATURGY.2"));
        TCHelper.addResearchPage(
                "BASICTHAUMATURGY",
                new ResearchPage(TCHelper.findCraftingRecipe(getModItem(Thaumcraft.ID, "WandCap", 1, 0))));
        TCHelper.addResearchPage(
                "BASICTHAUMATURGY",
                new ResearchPage(TCHelper.findCraftingRecipe(getModItem(Thaumcraft.ID, "WandCasting", 1, 0))));
        TCHelper.clearPages("CAP_copper");
        TCHelper.addResearchPage("CAP_copper", new ResearchPage("tc.research_page.CAP_copper.1fixed"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CAP_copper",
                getModItem(Thaumcraft.ID, "WandCap", 1, 3),
                new AspectList().add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("aer"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                "screwSteel",
                'b',
                "foilCopper",
                'c',
                "screwSteel",
                'd',
                "foilCopper",
                'e',
                "ringCopper",
                'f',
                "foilCopper",
                'g',
                "screwSteel",
                'h',
                "foilCopper",
                'i',
                "screwSteel");
        TCHelper.addResearchPage(
                "CAP_copper",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "WandCap", 1, 3))));
        TCHelper.setResearchAspects(
                "CAP_copper",
                new AspectList().add(Aspect.getAspect("instrumentum"), 3).add(Aspect.getAspect("metallum"), 6)
                        .add(Aspect.getAspect("permutatio"), 6));
        TCHelper.setResearchComplexity("CAP_copper", 1);
        TCHelper.addResearchPage("SCEPTRE", new ResearchPage("tc.research_page.RESEARCH.1"));
        TCHelper.clearPages("CAP_gold");
        TCHelper.addResearchPage("CAP_gold", new ResearchPage("tc.research_page.CAP_gold.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CAP_gold",
                getModItem(Thaumcraft.ID, "WandCap", 1, 1),
                new AspectList().add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("ignis"), 20)
                        .add(Aspect.getAspect("aer"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "screwAluminium",
                'b',
                "foilGold",
                'c',
                "screwAluminium",
                'd',
                "foilGold",
                'e',
                "ringGold",
                'f',
                "foilGold",
                'g',
                "screwAluminium",
                'h',
                "foilGold",
                'i',
                "screwAluminium");
        TCHelper.addResearchPage(
                "CAP_gold",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "WandCap", 1, 1))));
        TCHelper.setResearchAspects(
                "CAP_gold",
                new AspectList().add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("metallum"), 6)
                        .add(Aspect.getAspect("lucrum"), 3));
        TCHelper.setResearchComplexity("CAP_gold", 2);
        TCHelper.clearPages("CAP_silver");
        TCHelper.addResearchPage("CAP_silver", new ResearchPage("tc.research_page.CAP_silver.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CAP_silver",
                getModItem(Thaumcraft.ID, "WandCap", 1, 5),
                new AspectList().add(Aspect.getAspect("ordo"), 25).add(Aspect.getAspect("ignis"), 25)
                        .add(Aspect.getAspect("aer"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                "screwStainlessSteel",
                'b',
                "foilSilver",
                'c',
                "screwStainlessSteel",
                'd',
                "foilSilver",
                'e',
                "ringSilver",
                'f',
                "foilSilver",
                'g',
                "screwStainlessSteel",
                'h',
                "foilSilver",
                'i',
                "screwStainlessSteel");
        TCHelper.addResearchPage(
                "CAP_silver",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "WandCap", 1, 5))));
        TCHelper.addInfusionCraftingRecipe(
                "CAP_silver",
                getModItem(Thaumcraft.ID, "WandCap", 1, 4),
                5,
                new AspectList().add(Aspect.getAspect("auram"), 18).add(Aspect.getAspect("potentia"), 30)
                        .add(Aspect.getAspect("praecantatio"), 18),
                getModItem(Thaumcraft.ID, "WandCap", 1, 5),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                OrePrefixes.dust.get(Materials.Silver),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                OrePrefixes.dust.get(Materials.Silver),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                OrePrefixes.dust.get(Materials.Silver));
        TCHelper.addResearchPage(
                "CAP_silver",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Thaumcraft.ID, "WandCap", 1, 4))));
        TCHelper.clearPages("CAP_thaumium");
        TCHelper.addResearchPage("CAP_thaumium", new ResearchPage("tc.research_page.CAP_thaumium.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CAP_thaumium",
                getModItem(Thaumcraft.ID, "WandCap", 1, 6),
                new AspectList().add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("ignis"), 30)
                        .add(Aspect.getAspect("aer"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                "screwKnightmetal",
                'b',
                "foilThaumium",
                'c',
                "screwKnightmetal",
                'd',
                "foilThaumium",
                'e',
                "ringThaumium",
                'f',
                "foilThaumium",
                'g',
                "screwKnightmetal",
                'h',
                "foilThaumium",
                'i',
                "screwKnightmetal");
        TCHelper.addResearchPage(
                "CAP_thaumium",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "WandCap", 1, 6))));
        TCHelper.addInfusionCraftingRecipe(
                "CAP_thaumium",
                getModItem(Thaumcraft.ID, "WandCap", 1, 2),
                5,
                new AspectList().add(Aspect.getAspect("auram"), 25).add(Aspect.getAspect("potentia"), 40)
                        .add(Aspect.getAspect("praecantatio"), 25),
                getModItem(Thaumcraft.ID, "WandCap", 1, 6),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                OrePrefixes.dust.get(Materials.Thaumium),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                OrePrefixes.dust.get(Materials.Thaumium),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                OrePrefixes.dust.get(Materials.Thaumium));
        TCHelper.addResearchPage(
                "CAP_thaumium",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Thaumcraft.ID, "WandCap", 1, 2))));
        TCHelper.setResearchAspects(
                "CAP_thaumium",
                new AspectList().add(Aspect.getAspect("instrumentum"), 6).add(Aspect.getAspect("auram"), 9)
                        .add(Aspect.getAspect("metallum"), 12).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("CAP_thaumium", 3);
        TCHelper.clearPages("SCEPTRE");
        TCHelper.addResearchPage("SCEPTRE", new ResearchPage("tc.research_page.SCEPTRE.1"));
        TCHelper.setResearchAspects(
                "SCEPTRE",
                new AspectList().add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("arbor"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("cognitio"), 3));
        TCHelper.setResearchComplexity("SCEPTRE", 3);
        TCHelper.clearPages("ROD_greatwood");
        TCHelper.addResearchPage("ROD_greatwood", new ResearchPage("tc.research_page.ROD_greatwood.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_greatwood",
                getModItem(Thaumcraft.ID, "WandRod", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("terra"), 20)
                        .add(Aspect.getAspect("ignis"), 20).add(Aspect.getAspect("aqua"), 20)
                        .add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("perditio"), 20),
                "abc",
                "def",
                "ghi",
                'c',
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 0),
                'e',
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 0),
                'g',
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 0));
        TCHelper.addResearchPage(
                "ROD_greatwood",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "WandRod", 1, 0))));
        TCHelper.setResearchAspects(
                "ROD_greatwood",
                new AspectList().add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("arbor"), 3));
        TCHelper.setResearchComplexity("ROD_greatwood", 2);
        TCHelper.addInfusionCraftingRecipe(
                "ROD_reed",
                getModItem(Thaumcraft.ID, "WandRod", 1, 5),
                2,
                new AspectList().add(Aspect.getAspect("aer"), 24).add(Aspect.getAspect("motus"), 12)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("vitreus"), 6),
                getModItem(TinkerConstruct.ID, "trap.punji", 1, 0),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 6),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 6),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0));
        TCHelper.setResearchAspects(
                "ROD_reed",
                new AspectList().add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("herba"), 6)
                        .add(Aspect.getAspect("arbor"), 3));
        TCHelper.setResearchComplexity("ROD_reed", 2);
        TCHelper.addResearchPage(
                "SCEPTRE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                createItemStack(
                                        Thaumcraft.ID,
                                        "WandCasting",
                                        1,
                                        45,
                                        "{cap:\"thaumium\",rod:\"reed\",sceptre:1b}"))));
        TCHelper.addInfusionCraftingRecipe(
                "ROD_blaze",
                getModItem(Thaumcraft.ID, "WandRod", 1, 6),
                2,
                new AspectList().add(Aspect.getAspect("bestia"), 12).add(Aspect.getAspect("ignis"), 24)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("vitreus"), 6),
                getModItem(Minecraft.ID, "blaze_rod", 1, 0),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 6),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 6),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1));
        TCHelper.setResearchAspects(
                "ROD_blaze",
                new AspectList().add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("herba"), 6)
                        .add(Aspect.getAspect("arbor"), 3));
        TCHelper.setResearchComplexity("ROD_blaze", 2);
        TCHelper.addInfusionCraftingRecipe(
                "ROD_obsidian",
                getModItem(Thaumcraft.ID, "WandRod", 1, 1),
                2,
                new AspectList().add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("tenebrae"), 12)
                        .add(Aspect.getAspect("terra"), 24).add(Aspect.getAspect("vitreus"), 6),
                getModItem(RandomThings.ID, "ingredient", 1, 1),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 6),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 6),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3));
        TCHelper.setResearchAspects(
                "ROD_obsidian",
                new AspectList().add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("ignis"), 6).add(Aspect.getAspect("potentia"), 6)
                        .add(Aspect.getAspect("arbor"), 3));
        TCHelper.setResearchComplexity("ROD_obsidian", 2);
        TCHelper.addInfusionCraftingRecipe(
                "ROD_ice",
                getModItem(Thaumcraft.ID, "WandRod", 1, 3),
                2,
                new AspectList().add(Aspect.getAspect("aqua"), 24).add(Aspect.getAspect("gelum"), 12)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("vitreus"), 6),
                getModItem(BiomesOPlenty.ID, "hardIce", 1, 0),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 6),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 6),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2));
        TCHelper.setResearchAspects(
                "ROD_ice",
                new AspectList().add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("aqua"), 6).add(Aspect.getAspect("gelum"), 6)
                        .add(Aspect.getAspect("arbor"), 3));
        TCHelper.setResearchComplexity("ROD_ice", 2);
        TCHelper.addInfusionCraftingRecipe(
                "ROD_quartz",
                getModItem(Thaumcraft.ID, "WandRod", 1, 4),
                2,
                new AspectList().add(Aspect.getAspect("ordo"), 24).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("potentia"), 12).add(Aspect.getAspect("vitreus"), 6),
                NHItemList.ChargedCertusQuartzRod.get(1),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 6),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 6),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4));
        TCHelper.setResearchAspects(
                "ROD_quartz",
                new AspectList().add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("ordo"), 6)
                        .add(Aspect.getAspect("arbor"), 3));
        TCHelper.setResearchComplexity("ROD_quartz", 2);
        TCHelper.addInfusionCraftingRecipe(
                "ROD_bone",
                getModItem(Thaumcraft.ID, "WandRod", 1, 7),
                3,
                new AspectList().add(Aspect.getAspect("exanimis"), 12).add(Aspect.getAspect("perditio"), 24)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("vitreus"), 6),
                getModItem(TinkerConstruct.ID, "toolRod", 1, 5),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 6),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 6),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5));
        TCHelper.setResearchAspects(
                "ROD_bone",
                new AspectList().add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("exanimis"), 6).add(Aspect.getAspect("perditio"), 6)
                        .add(Aspect.getAspect("arbor"), 3));
        TCHelper.setResearchComplexity("ROD_bone", 2);
        ThaumcraftApi.addWarpToResearch("ROD_bone", 1);
        TCHelper.addInfusionCraftingRecipe(
                "ROD_silverwood",
                getModItem(Thaumcraft.ID, "WandRod", 1, 2),
                5,
                new AspectList().add(Aspect.getAspect("aer"), 48).add(Aspect.getAspect("aqua"), 48)
                        .add(Aspect.getAspect("ignis"), 48).add(Aspect.getAspect("ordo"), 48)
                        .add(Aspect.getAspect("perditio"), 48).add(Aspect.getAspect("praecantatio"), 48)
                        .add(Aspect.getAspect("terra"), 48),
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 1),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6));
        TCHelper.setResearchAspects(
                "ROD_silverwood",
                new AspectList().add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("herba"), 6)
                        .add(Aspect.getAspect("arbor"), 3));
        TCHelper.setResearchComplexity("ROD_silverwood", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_greatwood_staff",
                getModItem(Thaumcraft.ID, "WandRod", 1, 50),
                new AspectList().add(Aspect.getAspect("aer"), 50).add(Aspect.getAspect("terra"), 50)
                        .add(Aspect.getAspect("ignis"), 50).add(Aspect.getAspect("aqua"), 50)
                        .add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("perditio"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                'b',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                'c',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                'd',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                'e',
                getModItem(Thaumcraft.ID, "WandRod", 1, 0),
                'f',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                'g',
                getModItem(Thaumcraft.ID, "WandRod", 1, 0),
                'h',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                'i',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5));
        TCHelper.setResearchAspects(
                "ROD_greatwood_staff",
                new AspectList().add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("arbor"), 9).add(Aspect.getAspect("ignis"), 6)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("ROD_greatwood_staff", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_reed_staff",
                getModItem(Thaumcraft.ID, "WandRod", 1, 55),
                new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("terra"), 75)
                        .add(Aspect.getAspect("ignis"), 75).add(Aspect.getAspect("aqua"), 75)
                        .add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("perditio"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                'b',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                'c',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                'd',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                'e',
                getModItem(Thaumcraft.ID, "WandRod", 1, 5),
                'f',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                'g',
                getModItem(Thaumcraft.ID, "WandRod", 1, 5),
                'h',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                'i',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5));
        TCHelper.setResearchAspects(
                "ROD_reed_staff",
                new AspectList().add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("herba"), 9).add(Aspect.getAspect("aer"), 6)
                        .add(Aspect.getAspect("ignis"), 6).add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("ROD_reed_staff", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_blaze_staff",
                getModItem(Thaumcraft.ID, "WandRod", 1, 56),
                new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("terra"), 75)
                        .add(Aspect.getAspect("ignis"), 75).add(Aspect.getAspect("aqua"), 75)
                        .add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("perditio"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                'b',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                'c',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                'd',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                'e',
                getModItem(Thaumcraft.ID, "WandRod", 1, 6),
                'f',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                'g',
                getModItem(Thaumcraft.ID, "WandRod", 1, 6),
                'h',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                'i',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5));
        TCHelper.setResearchAspects(
                "ROD_blaze_staff",
                new AspectList().add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("ignis"), 9).add(Aspect.getAspect("potentia"), 6)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("ROD_blaze_staff", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_obsidian_staff",
                getModItem(Thaumcraft.ID, "WandRod", 1, 51),
                new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("terra"), 75)
                        .add(Aspect.getAspect("ignis"), 75).add(Aspect.getAspect("aqua"), 75)
                        .add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("perditio"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                'b',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                'c',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                'd',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                'e',
                getModItem(Thaumcraft.ID, "WandRod", 1, 1),
                'f',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                'g',
                getModItem(Thaumcraft.ID, "WandRod", 1, 1),
                'h',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                'i',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5));
        TCHelper.setResearchAspects(
                "ROD_obsidian_staff",
                new AspectList().add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("terra"), 9).add(Aspect.getAspect("ignis"), 6)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("potentia"), 3));
        TCHelper.setResearchComplexity("ROD_obsidian_staff", 3);
        TCHelper.addResearchPage(
                "ROD_obsidian_staff",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                createItemStack(
                                        Thaumcraft.ID,
                                        "WandCasting",
                                        1,
                                        84,
                                        "{cap:\"thaumium\",rod:\"obsidian_staff\"}"))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_ice_staff",
                getModItem(Thaumcraft.ID, "WandRod", 1, 53),
                new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("terra"), 75)
                        .add(Aspect.getAspect("ignis"), 75).add(Aspect.getAspect("aqua"), 75)
                        .add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("perditio"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                'b',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                'c',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                'd',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                'e',
                getModItem(Thaumcraft.ID, "WandRod", 1, 3),
                'f',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                'g',
                getModItem(Thaumcraft.ID, "WandRod", 1, 3),
                'h',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                'i',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5));
        TCHelper.setResearchAspects(
                "ROD_ice_staff",
                new AspectList().add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("gelum"), 9).add(Aspect.getAspect("aqua"), 6)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("ROD_ice_staff", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_quartz_staff",
                getModItem(Thaumcraft.ID, "WandRod", 1, 54),
                new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("terra"), 75)
                        .add(Aspect.getAspect("ignis"), 75).add(Aspect.getAspect("aqua"), 75)
                        .add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("perditio"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                'b',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                'c',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                'd',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                'e',
                getModItem(Thaumcraft.ID, "WandRod", 1, 4),
                'f',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                'g',
                getModItem(Thaumcraft.ID, "WandRod", 1, 4),
                'h',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                'i',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5));
        TCHelper.setResearchAspects(
                "ROD_quartz_staff",
                new AspectList().add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("vitreus"), 9).add(Aspect.getAspect("ordo"), 6)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("ROD_quartz_staff", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_bone_staff",
                getModItem(Thaumcraft.ID, "WandRod", 1, 57),
                new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("terra"), 75)
                        .add(Aspect.getAspect("ignis"), 75).add(Aspect.getAspect("aqua"), 75)
                        .add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("perditio"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                'b',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                'c',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                'd',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                'e',
                getModItem(Thaumcraft.ID, "WandRod", 1, 7),
                'f',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                'g',
                getModItem(Thaumcraft.ID, "WandRod", 1, 7),
                'h',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                'i',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5));
        TCHelper.setResearchAspects(
                "ROD_bone_staff",
                new AspectList().add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("exanimis"), 9).add(Aspect.getAspect("perditio"), 6)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("ROD_bone_staff", 3);
        ThaumcraftApi.addWarpToResearch("ROD_bone_staff", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_silverwood_staff",
                getModItem(Thaumcraft.ID, "WandRod", 1, 52),
                new AspectList().add(Aspect.getAspect("aer"), 125).add(Aspect.getAspect("terra"), 125)
                        .add(Aspect.getAspect("ignis"), 125).add(Aspect.getAspect("aqua"), 125)
                        .add(Aspect.getAspect("ordo"), 125).add(Aspect.getAspect("perditio"), 125),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                'b',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                'c',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                'd',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                'e',
                getModItem(Thaumcraft.ID, "WandRod", 1, 2),
                'f',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                'g',
                getModItem(Thaumcraft.ID, "WandRod", 1, 2),
                'h',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                'i',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5));
        TCHelper.setResearchAspects(
                "ROD_silverwood_staff",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("arbor"), 12).add(Aspect.getAspect("ordo"), 9)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("ROD_silverwood_staff", 4);
        TCHelper.addResearchPage(
                "SCEPTRE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                createItemStack(
                                        Thaumcraft.ID,
                                        "WandCasting",
                                        1,
                                        216,
                                        "{cap:\"thaumium\",rod:\"silverwood_staff\",sceptre:1b}"))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FOCUSFIRE",
                getModItem(Thaumcraft.ID, "FocusFire", 1, 0),
                new AspectList().add(Aspect.getAspect("ignis"), 20).add(Aspect.getAspect("perditio"), 20)
                        .add(Aspect.getAspect("ordo"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                'b',
                getModItem(Botania.ID, "quartz", 1, 2),
                'c',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                'd',
                getModItem(Botania.ID, "quartz", 1, 2),
                'e',
                "lensRuby",
                'f',
                getModItem(Botania.ID, "quartz", 1, 2),
                'g',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                'h',
                getModItem(Botania.ID, "quartz", 1, 2),
                'i',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1));
        TCHelper.setResearchAspects(
                "FOCUSFIRE",
                new AspectList().add(Aspect.getAspect("ignis"), 6).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("motus"), 3));
        TCHelper.setResearchComplexity("FOCUSFIRE", 1);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FOCUSEXCAVATION",
                getModItem(Thaumcraft.ID, "FocusExcavation", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 30).add(Aspect.getAspect("perditio"), 20)
                        .add(Aspect.getAspect("ordo"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                'b',
                getModItem(Botania.ID, "quartz", 1, 6),
                'c',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                'd',
                getModItem(Botania.ID, "quartz", 1, 6),
                'e',
                "lensEmerald",
                'f',
                getModItem(Botania.ID, "quartz", 1, 6),
                'g',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                'h',
                getModItem(Botania.ID, "quartz", 1, 6),
                'i',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3));
        TCHelper.setResearchAspects(
                "FOCUSEXCAVATION",
                new AspectList().add(Aspect.getAspect("terra"), 9).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("perditio"), 6).add(Aspect.getAspect("motus"), 3));
        TCHelper.setResearchComplexity("FOCUSEXCAVATION", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FOCUSFROST",
                getModItem(Thaumcraft.ID, "FocusFrost", 1, 0),
                new AspectList().add(Aspect.getAspect("aqua"), 30).add(Aspect.getAspect("perditio"), 20)
                        .add(Aspect.getAspect("ordo"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                'b',
                getModItem(Botania.ID, "quartz", 1, 1),
                'c',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                'd',
                getModItem(Botania.ID, "quartz", 1, 1),
                'e',
                "lensDiamond",
                'f',
                getModItem(Botania.ID, "quartz", 1, 1),
                'g',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                'h',
                getModItem(Botania.ID, "quartz", 1, 1),
                'i',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2));
        TCHelper.setResearchAspects(
                "FOCUSFROST",
                new AspectList().add(Aspect.getAspect("aqua"), 9).add(Aspect.getAspect("gelum"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("motus"), 3));
        TCHelper.setResearchComplexity("FOCUSFROST", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FOCUSSHOCK",
                getModItem(Thaumcraft.ID, "FocusShock", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("perditio"), 20)
                        .add(Aspect.getAspect("ordo"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                'b',
                getModItem(Botania.ID, "quartz", 1, 6),
                'c',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                'd',
                getModItem(Botania.ID, "quartz", 1, 6),
                'e',
                "lensGarnetYellow",
                'f',
                getModItem(Botania.ID, "quartz", 1, 6),
                'g',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                'h',
                getModItem(Botania.ID, "quartz", 1, 6),
                'i',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0));
        TCHelper.setResearchAspects(
                "FOCUSSHOCK",
                new AspectList().add(Aspect.getAspect("aer"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("motus"), 3));
        TCHelper.setResearchComplexity("FOCUSSHOCK", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FOCUSTRADE",
                getModItem(Thaumcraft.ID, "FocusTrade", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("terra"), 20)
                        .add(Aspect.getAspect("perditio"), 30).add(Aspect.getAspect("ordo"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                'b',
                getModItem(Botania.ID, "quartz", 1, 3),
                'c',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                'd',
                getModItem(Botania.ID, "quartz", 1, 3),
                'e',
                NHItemList.ReinforcedGlassLense.get(),
                'f',
                getModItem(Botania.ID, "quartz", 1, 3),
                'g',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                'h',
                getModItem(Botania.ID, "quartz", 1, 3),
                'i',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6));
        TCHelper.setResearchAspects(
                "FOCUSTRADE",
                new AspectList().add(Aspect.getAspect("permutatio"), 9).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("motus"), 3));
        TCHelper.setResearchComplexity("FOCUSTRADE", 2);
        TCHelper.addInfusionCraftingRecipe(
                "FOCUSWARDING",
                getModItem(Thaumcraft.ID, "FocusWarding", 1, 0),
                5,
                new AspectList().add(Aspect.getAspect("cognitio"), 15).add(Aspect.getAspect("ordo"), 25)
                        .add(Aspect.getAspect("terra"), 30).add(Aspect.getAspect("tutamen"), 25)
                        .add(Aspect.getAspect("praecantatio"), 10),
                OrePrefixes.lens.get(Materials.NetherStar),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                getModItem(Botania.ID, "quartz", 1, 1),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                getModItem(Botania.ID, "quartz", 1, 1),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4));
        TCHelper.setResearchAspects(
                "FOCUSWARDING",
                new AspectList().add(Aspect.getAspect("terra"), 12).add(Aspect.getAspect("cognitio"), 12)
                        .add(Aspect.getAspect("ordo"), 9).add(Aspect.getAspect("tutamen"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("FOCUSWARDING", 3);
        TCHelper.addInfusionCraftingRecipe(
                "FOCUSPORTABLEHOLE",
                getModItem(Thaumcraft.ID, "FocusPortableHole", 1, 0),
                6,
                new AspectList().add(Aspect.getAspect("alienis"), 40).add(Aspect.getAspect("iter"), 30)
                        .add(Aspect.getAspect("perditio"), 20).add(Aspect.getAspect("permutatio"), 10)
                        .add(Aspect.getAspect("praecantatio"), 5),
                OrePrefixes.lens.get(Materials.EnderPearl),
                getModItem(Botania.ID, "quartz", 1, 1),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                getModItem(Botania.ID, "quartz", 1, 1),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3));
        TCHelper.setResearchAspects(
                "FOCUSPORTABLEHOLE",
                new AspectList().add(Aspect.getAspect("aer"), 12).add(Aspect.getAspect("iter"), 12)
                        .add(Aspect.getAspect("alienis"), 9).add(Aspect.getAspect("perditio"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("FOCUSPORTABLEHOLE", 3);
        ThaumcraftApi.addWarpToResearch("NODESTABILIZERADV", 1);
        TCHelper.addInfusionCraftingRecipe(
                "FOCUSHELLBAT",
                getModItem(Thaumcraft.ID, "FocusHellbat", 1, 0),
                7,
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("ignis"), 40)
                        .add(Aspect.getAspect("bestia"), 20).add(Aspect.getAspect("perditio"), 10)
                        .add(Aspect.getAspect("praecantatio"), 5),
                OrePrefixes.lens.get(Materials.Firestone),
                getModItem(Botania.ID, "quartz", 1, 4),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                getModItem(Botania.ID, "quartz", 1, 4),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0));
        TCHelper.setResearchAspects(
                "FOCUSHELLBAT",
                new AspectList().add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("iter"), 9)
                        .add(Aspect.getAspect("ignis"), 9).add(Aspect.getAspect("bestia"), 6)
                        .add(Aspect.getAspect("motus"), 3));
        TCHelper.setResearchComplexity("FOCUSHELLBAT", 3);
        ThaumcraftApi.addWarpToResearch("NODESTABILIZERADV", 2);
        ThaumcraftApi.addWarpToItem(getModItem(Thaumcraft.ID, "FocusHellbat", 1, 0), 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FOCUSPOUCH",
                getModItem(Thaumcraft.ID, "FocusPouch", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 20).add(Aspect.getAspect("perditio"), 20)
                        .add(Aspect.getAspect("ordo"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "boltGold",
                'b',
                "ringGold",
                'c',
                "boltGold",
                'd',
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                'e',
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 2),
                'f',
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                'g',
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                'h',
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                'i',
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0));
        TCHelper.setResearchAspects(
                "FOCUSPOUCH",
                new AspectList().add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("vacuos"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("pannus"), 3));
        TCHelper.setResearchComplexity("FOCUSPOUCH", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "NODESTABILIZER",
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 9),
                new AspectList().add(Aspect.getAspect("aqua"), 35).add(Aspect.getAspect("terra"), 35)
                        .add(Aspect.getAspect("ordo"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                "plateThaumium",
                'b',
                "springGold",
                'c',
                "plateThaumium",
                'd',
                getModItem(Botania.ID, "quartzTypeLavender", 1, 0),
                'e',
                ItemList.Electric_Piston_LV.get(1L),
                'f',
                getModItem(Botania.ID, "quartzTypeLavender", 1, 0),
                'g',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1),
                'i',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7));
        TCHelper.setResearchAspects(
                "NODESTABILIZER",
                new AspectList().add(Aspect.getAspect("auram"), 9).add(Aspect.getAspect("potentia"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("ordo"), 3));
        TCHelper.setResearchComplexity("NODESTABILIZER", 2);
        TCHelper.addInfusionCraftingRecipe(
                "NODESTABILIZERADV",
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 10),
                10,
                new AspectList().add(Aspect.getAspect("auram"), 32).add(Aspect.getAspect("ordo"), 32)
                        .add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("praecantatio"), 32),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 9),
                getModItem(Minecraft.ID, "redstone_block", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1),
                getModItem(Minecraft.ID, "redstone_block", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 0),
                getModItem(Minecraft.ID, "glowstone", 1, 0),
                getModItem(Minecraft.ID, "redstone_block", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1),
                getModItem(Minecraft.ID, "redstone_block", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 0),
                getModItem(Minecraft.ID, "glowstone", 1, 0));
        TCHelper.setResearchAspects(
                "NODESTABILIZERADV",
                new AspectList().add(Aspect.getAspect("auram"), 12).add(Aspect.getAspect("potentia"), 9)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("ordo"), 6)
                        .add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("NODESTABILIZERADV", 3);
        ThaumcraftApi.addWarpToResearch("NODESTABILIZERADV", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VISPOWER",
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 11),
                new AspectList().add(Aspect.getAspect("ignis"), 32).add(Aspect.getAspect("aer"), 32)
                        .add(Aspect.getAspect("perditio"), 32).add(Aspect.getAspect("ordo"), 32),
                "abc",
                "def",
                "ghi",
                'a',
                "blockRedstone",
                'b',
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26),
                'c',
                "blockRedstone",
                'd',
                "plateThaumium",
                'e',
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 9),
                'f',
                "plateThaumium",
                'g',
                "blockRedstone",
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1),
                'i',
                "blockRedstone");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VISPOWER",
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 14),
                new AspectList().add(Aspect.getAspect("ignis"), 10).add(Aspect.getAspect("ordo"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "screwSteel",
                'b',
                "lensDiamond",
                'c',
                "screwSteel",
                'd',
                "ringThaumium",
                'e',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                'f',
                "ringThaumium",
                'g',
                "screwSteel",
                'h',
                "lensDiamond",
                'i',
                "screwSteel");
        TCHelper.setResearchAspects(
                "VISPOWER",
                new AspectList().add(Aspect.getAspect("auram"), 12).add(Aspect.getAspect("potentia"), 9)
                        .add(Aspect.getAspect("praecantatio"), 3).add(Aspect.getAspect("machina"), 6));
        TCHelper.setResearchComplexity("VISPOWER", 3);
        TCHelper.addInfusionCraftingRecipe(
                "WANDPED",
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 5),
                2,
                new AspectList().add(Aspect.getAspect("auram"), 10).add(Aspect.getAspect("permutatio"), 15)
                        .add(Aspect.getAspect("praecantatio"), 20).add(Aspect.getAspect("ordo"), 5),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 1),
                OrePrefixes.plate.get(Materials.Gold),
                OrePrefixes.gemFlawless.get(Materials.Diamond),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                OrePrefixes.gemFlawless.get(Materials.Diamond));
        TCHelper.setResearchAspects(
                "WANDPED",
                new AspectList().add(Aspect.getAspect("auram"), 12).add(Aspect.getAspect("potentia"), 9)
                        .add(Aspect.getAspect("praecantatio"), 3).add(Aspect.getAspect("permutatio"), 6));
        TCHelper.setResearchComplexity("WANDPED", 3);
        TCHelper.addInfusionCraftingRecipe(
                "VISAMULET",
                getModItem(Thaumcraft.ID, "ItemAmuletVis", 1, 1),
                7,
                new AspectList().add(Aspect.getAspect("vacuos"), 48).add(Aspect.getAspect("auram"), 48)
                        .add(Aspect.getAspect("potentia"), 88).add(Aspect.getAspect("praecantatio"), 88)
                        .add(Aspect.getAspect("vitreus"), 24),
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                OrePrefixes.gemExquisite.get(Materials.Diamond),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                OrePrefixes.gemExquisite.get(Materials.Diamond),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6));
        TCHelper.setResearchAspects(
                "VISAMULET",
                new AspectList().add(Aspect.getAspect("vacuos"), 15).add(Aspect.getAspect("auram"), 15)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("vitreus"), 6).add(Aspect.getAspect("tempus"), 3));
        TCHelper.setResearchComplexity("VISAMULET", 4);
        TCHelper.addInfusionCraftingRecipe(
                "WANDPEDFOC",
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 8),
                5,
                new AspectList().add(Aspect.getAspect("ordo"), 25).add(Aspect.getAspect("permutatio"), 25)
                        .add(Aspect.getAspect("praecantatio"), 30).add(Aspect.getAspect("potentia"), 15)
                        .add(Aspect.getAspect("cognitio"), 15),
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 8),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 8),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 8),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 8));
        TCHelper.setResearchAspects(
                "WANDPEDFOC",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("auram"), 15)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("permutatio"), 9).add(Aspect.getAspect("cognitio"), 6)
                        .add(Aspect.getAspect("lucrum"), 3));
        TCHelper.setResearchComplexity("WANDPEDFOC", 4);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VISCHARGERELAY",
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 2),
                new AspectList().add(Aspect.getAspect("ignis"), 20).add(Aspect.getAspect("ordo"), 20)
                        .add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("terra"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "screwThaumium",
                'b',
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 14),
                'c',
                "screwThaumium",
                'd',
                getModItem(Thaumcraft.ID, "WandRod", 1, 2),
                'e',
                "plateThaumium",
                'f',
                getModItem(Thaumcraft.ID, "WandRod", 1, 2),
                'g',
                getModItem(Thaumcraft.ID, "WandRod", 1, 0),
                'h',
                "craftingToolScrewdriver",
                'i',
                getModItem(Thaumcraft.ID, "WandRod", 1, 0));
        TCHelper.setResearchAspects(
                "VISCHARGERELAY",
                new AspectList().add(Aspect.getAspect("potentia"), 12).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("machina"), 9).add(Aspect.getAspect("auram"), 9)
                        .add(Aspect.getAspect("ignis"), 6).add(Aspect.getAspect("aer"), 3));
        TCHelper.setResearchComplexity("VISCHARGERELAY", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FOCALMANIPULATION",
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 13),
                new AspectList().add(Aspect.getAspect("ignis"), 64).add(Aspect.getAspect("ordo"), 64)
                        .add(Aspect.getAspect("aer"), 64).add(Aspect.getAspect("terra"), 64)
                        .add(Aspect.getAspect("aqua"), 64).add(Aspect.getAspect("perditio"), 64),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                'b',
                getModItem(Thaumcraft.ID, "blockCosmeticSlabStone", 1, 0),
                'c',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                'd',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                'e',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                'f',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                'g',
                "plateThaumium",
                'h',
                getModItem(Thaumcraft.ID, "blockTable", 1, 0),
                'i',
                "plateThaumium");
        TCHelper.setResearchAspects(
                "FOCALMANIPULATION",
                new AspectList().add(Aspect.getAspect("potentia"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("vitreus"), 9)
                        .add(Aspect.getAspect("fabrico"), 9).add(Aspect.getAspect("alienis"), 3)
                        .add(Aspect.getAspect("cognitio"), 5));
        TCHelper.setResearchComplexity("FOCALMANIPULATION", 4);
        TCHelper.setResearchAspects(
                "VAMPBAT",
                new AspectList().add(Aspect.getAspect("fames"), 15).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("victus"), 12).add(Aspect.getAspect("exanimis"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("ira"), 3)
                        .add(Aspect.getAspect("alienis"), 6));
        TCHelper.setResearchComplexity("VAMPBAT", 4);
        ThaumcraftApi.addWarpToResearch("VAMPBAT", 4);
        TCHelper.refreshResearchPages("CAP_copper");
        TCHelper.refreshResearchPages("CAP_gold");
        TCHelper.refreshResearchPages("CAP_silver");
        TCHelper.refreshResearchPages("CAP_thaumium");
        TCHelper.refreshResearchPages("ROD_silverwood");
        TCHelper.refreshResearchPages("ROD_greatwood_staff");
        TCHelper.refreshResearchPages("FOCUSFIRE");
        TCHelper.refreshResearchPages("FOCUSEXCAVATION");
        TCHelper.refreshResearchPages("FOCUSFROST");
        TCHelper.refreshResearchPages("FOCUSSHOCK");
        TCHelper.refreshResearchPages("FOCUSTRADE");
        TCHelper.refreshResearchPages("FOCUSWARDING");
        TCHelper.refreshResearchPages("FOCUSPORTABLEHOLE");
        TCHelper.refreshResearchPages("FOCUSHELLBAT");
        TCHelper.refreshResearchPages("FOCUSPOUCH");
        TCHelper.refreshResearchPages("NODESTABILIZER");
        TCHelper.refreshResearchPages("NODESTABILIZERADV");
        TCHelper.refreshResearchPages("VISPOWER");
        TCHelper.refreshResearchPages("WANDPED");
        TCHelper.refreshResearchPages("VISAMULET");
        TCHelper.refreshResearchPages("WANDPEDFOC");
        TCHelper.refreshResearchPages("VISCHARGERELAY");
        TCHelper.refreshResearchPages("FOCALMANIPULATION");
        TCHelper.refreshResearchPages("VAMPBAT");

    }

    private void alchemy() {
        // ALCHEMY

        addShapelessRecipe(
                getModItem(Thaumcraft.ID, "ItemEssence", 1),
                new ItemStack(Items.glass_bottle),
                "roundAnyRubber");

        addShapelessRecipe(
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                "craftingToolMortar",
                getModItem(Thaumcraft.ID, "ItemShard", 1, 6));

        GTValues.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 6))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemResource", 1, 14)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 5))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemResource", 9, 4)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7))
                .itemOutputs(getModItem(Thaumcraft.ID, "blockCosmeticSlabStone", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("water", 32)).duration(20 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);

        // Quicksilver Drop Fixes
        GTValues.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "ItemNugget", 1, 5))
                .fluidOutputs(Materials.Mercury.getFluid(100)).duration(13 * TICKS).eut(4)
                .addTo(fluidExtractionRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "ItemNugget", 9, 5))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemResource", 1, 3)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);

        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemResource", 1, 4));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemResource", 1, 0));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemResource", 1, 1));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemResource", 1, 2));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemResource", 1, 16));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemResource", 1, 17));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemResource", 1, 6));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemResource", 3, 3));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemResource", 2, 14));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemResource", 1, 7));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemResource", 1, 9));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemResource", 1, 6));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemResource", 2, 8));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 1));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 9));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockTube", 8, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockTube", 1, 1));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockTube", 1, 3));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockTube", 1, 5));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockTube", 1, 6));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockTube", 1, 2));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockTube", 1, 4));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemResonator", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockTube", 1, 7));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 12));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockJar", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockJar", 1, 3));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemBathSalts", 1, 0));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemSanitySoap", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 12));
        TCHelper.clearPages("PHIAL");
        TCHelper.addResearchPage("PHIAL", new ResearchPage("tc.research_page.PHIAL.1"));
        TCHelper.addResearchPage(
                "PHIAL",
                new ResearchPage(TCHelper.findCraftingRecipe(getModItem(Thaumcraft.ID, "ItemEssence", 1, 0))));
        ThaumcraftApi.addCrucibleRecipe(
                "TALLOW",
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Soapstone, 1L),
                new AspectList().add(Aspect.getAspect("praecantatio"), 2).add(Aspect.getAspect("corpus"), 4)
                        .add(Aspect.getAspect("mortuus"), 2));
        TCHelper.setResearchAspects(
                "TALLOW",
                new AspectList().add(Aspect.getAspect("corpus"), 6).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("motus"), 3));
        TCHelper.setResearchComplexity("TALLOW", 1);
        TCHelper.clearPages("TALLOW");
        TCHelper.addResearchPage("TALLOW", new ResearchPage("tc.research_page.TALLOW.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TALLOW",
                getModItem(Thaumcraft.ID, "blockCandle", 1, 0),
                new AspectList().add(Aspect.getAspect("ignis"), 3).add(Aspect.getAspect("ordo"), 1)
                        .add(Aspect.getAspect("perditio"), 1).add(Aspect.getAspect("aer"), 3),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(Minecraft.ID, "string", 1, 0),
                'e',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4));
        TCHelper.addResearchPage(
                "TALLOW",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemResource", 1, 4))));
        TCHelper.addResearchPage(
                "TALLOW",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "blockCandle", 1, 0))));
        ThaumcraftApi.addCrucibleRecipe(
                "NITOR",
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                new AspectList().add(Aspect.getAspect("ignis"), 4).add(Aspect.getAspect("lux"), 4)
                        .add(Aspect.getAspect("potentia"), 4));
        TCHelper.setResearchAspects(
                "NITOR",
                new AspectList().add(Aspect.getAspect("lux"), 6).add(Aspect.getAspect("ignis"), 3)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("NITOR", 1);
        ThaumcraftApi.addCrucibleRecipe(
                "ALUMENTUM",
                getModItem(Thaumcraft.ID, "ItemResource", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                new AspectList().add(Aspect.getAspect("ignis"), 6).add(Aspect.getAspect("perditio"), 3)
                        .add(Aspect.getAspect("potentia"), 6));
        ThaumcraftApi.addCrucibleRecipe(
                "ALUMENTUM",
                getModItem(Thaumcraft.ID, "ItemResource", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 1L),
                new AspectList().add(Aspect.getAspect("ignis"), 6).add(Aspect.getAspect("perditio"), 3)
                        .add(Aspect.getAspect("potentia"), 6));
        ThaumcraftApi.addCrucibleRecipe(
                "ALUMENTUM",
                getModItem(Thaumcraft.ID, "ItemResource", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lignite, 1L),
                new AspectList().add(Aspect.getAspect("ignis"), 6).add(Aspect.getAspect("perditio"), 3)
                        .add(Aspect.getAspect("potentia"), 6));
        TCHelper.setResearchAspects(
                "ALUMENTUM",
                new AspectList().add(Aspect.getAspect("ignis"), 3).add(Aspect.getAspect("praecantatio"), 3)
                        .add(Aspect.getAspect("perditio"), 6));
        TCHelper.setResearchComplexity("ALUMENTUM", 1);
        TCHelper.addResearchPage("ALUMENTUM", new ResearchPage("tc.research_page.ALUMENTUM.2"));
        TCHelper.setResearchAspects(
                "ALCHEMICALDUPLICATION",
                new AspectList().add(Aspect.getAspect("fabrico"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("ALCHEMICALDUPLICATION", 2);
        TCHelper.setResearchAspects(
                "ALCHEMICALMANUFACTURE",
                new AspectList().add(Aspect.getAspect("fabrico"), 9).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("lucrum"), 6).add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("ALCHEMICALMANUFACTURE", 2);
        TCHelper.setResearchAspects(
                "ENTROPICPROCESSING",
                new AspectList().add(Aspect.getAspect("fabrico"), 9).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("lucrum"), 6).add(Aspect.getAspect("perditio"), 3));
        TCHelper.setResearchComplexity("ENTROPICPROCESSING", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DISTILESSENTIA",
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 0),
                new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("aer"), 10)
                        .add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                'b',
                getModItem(Railcraft.ID, "machine.beta", 1, 3),
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                'd',
                "plateThaumium",
                'e',
                "craftingBlastFurnace",
                'f',
                "plateThaumium",
                'g',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                'h',
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 0),
                'i',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7));
        TCHelper.setResearchAspects(
                "DISTILESSENTIA",
                new AspectList().add(Aspect.getAspect("limus"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("ignis"), 3).add(Aspect.getAspect("aqua"), 9));
        TCHelper.setResearchComplexity("DISTILESSENTIA", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DISTILESSENTIA",
                getModItem(Thaumcraft.ID, "ItemResource", 3, 8),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("aqua"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "springSmallGold",
                'b',
                "plateGold",
                'c',
                "springSmallGold",
                'd',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 7),
                'e',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 7),
                'f',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 7),
                'g',
                "springSmallGold",
                'h',
                "plateGold",
                'i',
                "springSmallGold");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DISTILESSENTIA",
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 1),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("aqua"), 10)
                        .add(Aspect.getAspect("ignis"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "plateThaumium",
                'b',
                "pipeMediumSteel",
                'c',
                "plateThaumium",
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 8),
                'e',
                getModItem(Railcraft.ID, "machine.beta", 1, 3),
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 8),
                'g',
                "plateThaumium",
                'h',
                "pipeMediumSteel",
                'i',
                "plateThaumium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DISTILESSENTIA",
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 9),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ignis"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockTube", 1, 0),
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 8),
                'c',
                getModItem(Thaumcraft.ID, "blockTube", 1, 0),
                'd',
                getModItem(Thaumcraft.ID, "blockTube", 1, 1),
                'e',
                "blockThaumium",
                'f',
                getModItem(Thaumcraft.ID, "blockTube", 1, 1),
                'g',
                getModItem(Thaumcraft.ID, "blockTube", 1, 0),
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 8),
                'i',
                getModItem(Thaumcraft.ID, "blockTube", 1, 0));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TUBES",
                getModItem(Thaumcraft.ID, "blockTube", 4, 0),
                new AspectList().add(Aspect.getAspect("ordo"), 8).add(Aspect.getAspect("aqua"), 8),
                "abc",
                "def",
                "ghi",
                'a',
                "screwThaumium",
                'b',
                "nuggetGold",
                'c',
                "screwThaumium",
                'd',
                getModItem(Thaumcraft.ID, "ItemNugget", 1, 5),
                'e',
                "pipeSmallSteel",
                'f',
                getModItem(Thaumcraft.ID, "ItemNugget", 1, 5),
                'g',
                "screwThaumium",
                'h',
                "nuggetGold",
                'i',
                "screwThaumium");
        TCHelper.setResearchAspects(
                "TUBES",
                new AspectList().add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("permutatio"), 6)
                        .add(Aspect.getAspect("aqua"), 9).add(Aspect.getAspect("ordo"), 3));
        TCHelper.setResearchComplexity("TUBES", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TUBES",
                getModItem(Thaumcraft.ID, "blockTube", 1, 1),
                new AspectList().add(Aspect.getAspect("ordo"), 8).add(Aspect.getAspect("aqua"), 8),
                "abc",
                "def",
                "ghi",
                'a',
                "screwThaumium",
                'b',
                getModItem(Minecraft.ID, "lever", 1, 0),
                'c',
                "screwThaumium",
                'd',
                "plateAnyRubber",
                'e',
                getModItem(Thaumcraft.ID, "blockTube", 1, 0),
                'f',
                "gearGtSmallThaumium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TUBES",
                getModItem(Thaumcraft.ID, "ItemResonator", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("aqua"), 8),
                "abc",
                "def",
                "ghi",
                'a',
                "craftingToolScrewdriver",
                'b',
                "stickThaumium",
                'd',
                "screwThaumium",
                'e',
                getModItem(Thaumcraft.ID, "ItemNugget", 1, 5),
                'f',
                "stickThaumium",
                'g',
                "stickWood",
                'h',
                "screwThaumium",
                'i',
                "craftingToolFile");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TUBEFILTER",
                getModItem(Thaumcraft.ID, "blockTube", 1, 3),
                new AspectList().add(Aspect.getAspect("ordo"), 16).add(Aspect.getAspect("aqua"), 16),
                "abc",
                "def",
                "ghi",
                'a',
                "craftingToolScrewdriver",
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 8),
                'c',
                "craftingToolFile",
                'd',
                "screwThaumium",
                'e',
                getModItem(Thaumcraft.ID, "blockTube", 1, 0),
                'f',
                "screwThaumium",
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 8));
        TCHelper.setResearchAspects(
                "TUBEFILTER",
                new AspectList().add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("permutatio"), 9)
                        .add(Aspect.getAspect("aqua"), 12).add(Aspect.getAspect("ordo"), 6)
                        .add(Aspect.getAspect("limus"), 3));
        TCHelper.setResearchComplexity("TUBEFILTER", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TUBEFILTER",
                getModItem(Thaumcraft.ID, "blockTube", 1, 5),
                new AspectList().add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("aqua"), 16),
                "abc",
                "def",
                "ghi",
                'd',
                "ringAnyRubber",
                'e',
                getModItem(Thaumcraft.ID, "blockTube", 1, 0),
                'f',
                "ringAnyRubber");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TUBEFILTER",
                getModItem(Thaumcraft.ID, "blockTube", 1, 6),
                new AspectList().add(Aspect.getAspect("ordo"), 16).add(Aspect.getAspect("perditio"), 8)
                        .add(Aspect.getAspect("aqua"), 8),
                "abc",
                "def",
                "ghi",
                'd',
                "dyeBlue",
                'e',
                getModItem(Thaumcraft.ID, "blockTube", 1, 0),
                'f',
                "screwThaumium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CENTRIFUGE",
                getModItem(Thaumcraft.ID, "blockTube", 1, 2),
                new AspectList().add(Aspect.getAspect("ordo"), 32).add(Aspect.getAspect("perditio"), 16)
                        .add(Aspect.getAspect("aqua"), 16),
                "abc",
                "def",
                "ghi",
                'a',
                "screwThaumium",
                'b',
                getModItem(Thaumcraft.ID, "blockTube", 1, 0),
                'c',
                "screwThaumium",
                'd',
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 1),
                'e',
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 9),
                'f',
                ItemList.Electric_Piston_MV.get(1L),
                'g',
                "screwThaumium",
                'h',
                getModItem(Thaumcraft.ID, "blockTube", 1, 0),
                'i',
                "screwThaumium");
        TCHelper.setResearchAspects(
                "CENTRIFUGE",
                new AspectList().add(Aspect.getAspect("fabrico"), 12).add(Aspect.getAspect("perditio"), 9)
                        .add(Aspect.getAspect("permutatio"), 12).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("machina"), 3));
        TCHelper.setResearchComplexity("CENTRIFUGE", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CENTRIFUGE",
                getModItem(Thaumcraft.ID, "blockTube", 4, 4),
                new AspectList().add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("aqua"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "ItemEssence", 1, 0),
                'b',
                getModItem(Thaumcraft.ID, "blockTube", 1, 1),
                'c',
                getModItem(Thaumcraft.ID, "ItemEssence", 1, 0),
                'd',
                getModItem(Thaumcraft.ID, "blockTube", 1, 0),
                'e',
                "screwThaumium",
                'f',
                getModItem(Thaumcraft.ID, "blockTube", 1, 0),
                'g',
                getModItem(Thaumcraft.ID, "ItemEssence", 1, 0),
                'h',
                getModItem(Thaumcraft.ID, "blockTube", 1, 5),
                'i',
                getModItem(Thaumcraft.ID, "ItemEssence", 1, 0));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ESSENTIACRYSTAL",
                getModItem(Thaumcraft.ID, "blockTube", 1, 7),
                new AspectList().add(Aspect.getAspect("terra"), 20).add(Aspect.getAspect("ordo"), 15)
                        .add(Aspect.getAspect("aqua"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "plateThaumium",
                'b',
                getModItem(Minecraft.ID, "dispenser", 1, 0),
                'c',
                "plateThaumium",
                'd',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                'e',
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 9),
                'f',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                'g',
                "screwThaumium",
                'h',
                getModItem(Thaumcraft.ID, "blockTube", 1, 0),
                'i',
                "screwThaumium");
        TCHelper.setResearchAspects(
                "ESSENTIACRYSTAL",
                new AspectList().add(Aspect.getAspect("aqua"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("permutatio"), 12).add(Aspect.getAspect("vitreus"), 6)
                        .add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("ESSENTIACRYSTAL", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "THAUMATORIUM",
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 12),
                new AspectList().add(Aspect.getAspect("ignis"), 10).add(Aspect.getAspect("ordo"), 10)
                        .add(Aspect.getAspect("aqua"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "plateThaumium",
                'b',
                "gemFlawlessAmber",
                'c',
                "plateThaumium",
                'd',
                "gemFlawlessAmber",
                'e',
                getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0),
                'f',
                "gemFlawlessAmber",
                'g',
                "plateThaumium",
                'h',
                "gemFlawlessAmber",
                'i',
                "plateThaumium");
        TCHelper.setResearchAspects(
                "THAUMATORIUM",
                new AspectList().add(Aspect.getAspect("fabrico"), 12).add(Aspect.getAspect("aqua"), 9)
                        .add(Aspect.getAspect("permutatio"), 12).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("cognitio"), 3));
        TCHelper.setResearchComplexity("THAUMATORIUM", 3);
        TCHelper.setResearchAspects(
                "TRANSIRON",
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("ordo"), 3)
                        .add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("TRANSIRON", 1);
        TCHelper.setResearchAspects(
                "TRANSGOLD",
                new AspectList().add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("lucrum"), 6)
                        .add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("TRANSGOLD", 2);
        TCHelper.setResearchAspects(
                "TRANSCOPPER",
                new AspectList().add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("ordo"), 6)
                        .add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("TRANSCOPPER", 2);
        TCHelper.setResearchAspects(
                "TRANSTIN",
                new AspectList().add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("vitreus"), 6)
                        .add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("TRANSTIN", 2);
        TCHelper.setResearchAspects(
                "TRANSLEAD",
                new AspectList().add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("ordo"), 6)
                        .add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("TRANSLEAD", 2);
        TCHelper.setResearchAspects(
                "TRANSSILVER",
                new AspectList().add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("lucrum"), 6)
                        .add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("TRANSSILVER", 2);
        TCHelper.setResearchAspects(
                "PUREIRON",
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("ordo"), 6)
                        .add(Aspect.getAspect("vitreus"), 3));
        TCHelper.setResearchComplexity("PUREIRON", 1);
        TCHelper.setResearchAspects(
                "PUREGOLD",
                new AspectList().add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("lucrum"), 9)
                        .add(Aspect.getAspect("ordo"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("PUREGOLD", 2);
        TCHelper.setResearchAspects(
                "PURECOPPER",
                new AspectList().add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("ordo"), 15)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("PURECOPPER", 2);
        TCHelper.setResearchAspects(
                "PURETIN",
                new AspectList().add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("vitreus"), 9)
                        .add(Aspect.getAspect("ordo"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("PURETIN", 2);
        TCHelper.setResearchAspects(
                "PURELEAD",
                new AspectList().add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("permutatio"), 9)
                        .add(Aspect.getAspect("ordo"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("PURELEAD", 2);
        TCHelper.setResearchAspects(
                "PURESILVER",
                new AspectList().add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("lucrum"), 9)
                        .add(Aspect.getAspect("ordo"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("PURESILVER", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "JARLABEL",
                getModItem(Thaumcraft.ID, "blockJar", 1, 0),
                new AspectList().add(Aspect.getAspect("aqua"), 2),
                "abc",
                "def",
                "ghi",
                'a',
                "paneGlassColorless",
                'b',
                "plateAnyRubber",
                'c',
                "paneGlassColorless",
                'd',
                "paneGlassColorless",
                'f',
                "paneGlassColorless",
                'g',
                "paneGlassColorless",
                'h',
                "paneGlassColorless",
                'i',
                "paneGlassColorless");
        TCHelper.clearPages("JARVOID");
        TCHelper.addResearchPage("JARVOID", new ResearchPage("tc.research_page.JARVOID.1"));
        TCHelper.addInfusionCraftingRecipe(
                "JARVOID",
                getModItem(Thaumcraft.ID, "blockJar", 1, 3),
                2,
                new AspectList().add(Aspect.getAspect("vacuos"), 7).add(Aspect.getAspect("praecantatio"), 7)
                        .add(Aspect.getAspect("perditio"), 7).add(Aspect.getAspect("aqua"), 7),
                getModItem(Thaumcraft.ID, "blockJar", 1, 0),
                OrePrefixes.plate.get(Materials.Obsidian),
                getModItem(Minecraft.ID, "blaze_powder", 1, 0),
                OrePrefixes.plate.get(Materials.EnderEye),
                getModItem(Thaumcraft.ID, "ItemNugget", 1, 5));
        TCHelper.addResearchPage(
                "JARVOID",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Thaumcraft.ID, "blockJar", 1, 3))));
        TCHelper.setResearchAspects(
                "JARVOID",
                new AspectList().add(Aspect.getAspect("vacuos"), 6).add(Aspect.getAspect("perditio"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6));
        TCHelper.setResearchComplexity("JARVOID", 1);
        ThaumcraftApi.addCrucibleRecipe(
                "BATHSALTS",
                getModItem(Thaumcraft.ID, "ItemBathSalts", 2, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                new AspectList().add(Aspect.getAspect("sano"), 10).add(Aspect.getAspect("cognitio"), 10)
                        .add(Aspect.getAspect("auram"), 10).add(Aspect.getAspect("ordo"), 10));
        TCHelper.setResearchAspects(
                "BATHSALTS",
                new AspectList().add(Aspect.getAspect("sano"), 9).add(Aspect.getAspect("cognitio"), 6)
                        .add(Aspect.getAspect("auram"), 9).add(Aspect.getAspect("ordo"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("BATHSALTS", 2);
        ThaumcraftApi.addCrucibleRecipe(
                "SANESOAP",
                getModItem(Thaumcraft.ID, "ItemSanitySoap", 2, 0),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 5),
                new AspectList().add(Aspect.getAspect("alienis"), 20).add(Aspect.getAspect("cognitio"), 20)
                        .add(Aspect.getAspect("sano"), 20).add(Aspect.getAspect("ordo"), 20));
        TCHelper.setResearchAspects(
                "SANESOAP",
                new AspectList().add(Aspect.getAspect("sano"), 12).add(Aspect.getAspect("alienis"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("ordo"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("SANESOAP", 3);
        TCHelper.clearPages("ARCANESPA");
        TCHelper.addResearchPage("ARCANESPA", new ResearchPage("tc.research_page.ARCANESPA.1"));
        TCHelper.addInfusionCraftingRecipe(
                "ARCANESPA",
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 12),
                4,
                new AspectList().add(Aspect.getAspect("ordo"), 24).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("sano"), 16).add(Aspect.getAspect("aqua"), 32)
                        .add(Aspect.getAspect("machina"), 8),
                getModItem(Thaumcraft.ID, "blockJar", 1, 0),
                NHItemList.StainlessSteelBars.get(),
                getModItem(Minecraft.ID, "quartz_block", 1, 0),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                getModItem(Thaumcraft.ID, "ItemBathSalts", 1, 0),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                getModItem(Minecraft.ID, "quartz_block", 1, 0));
        TCHelper.addResearchPage(
                "ARCANESPA",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 12))));
        TCHelper.setResearchAspects(
                "ARCANESPA",
                new AspectList().add(Aspect.getAspect("ordo"), 9).add(Aspect.getAspect("aqua"), 9)
                        .add(Aspect.getAspect("machina"), 6).add(Aspect.getAspect("sano"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("ARCANESPA", 3);
        TCHelper.setResearchAspects(
                "LIQUIDDEATH",
                new AspectList().add(Aspect.getAspect("aqua"), 9).add(Aspect.getAspect("mortuus"), 9)
                        .add(Aspect.getAspect("perditio"), 6).add(Aspect.getAspect("venenum"), 6)
                        .add(Aspect.getAspect("tenebrae"), 3));
        TCHelper.setResearchComplexity("LIQUIDDEATH", 3);
        TCHelper.setResearchAspects(
                "ETHEREALBLOOM",
                new AspectList().add(Aspect.getAspect("vitium"), 9).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("sano"), 6).add(Aspect.getAspect("herba"), 6)
                        .add(Aspect.getAspect("lux"), 3).add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("ETHEREALBLOOM", 3);
        TCHelper.setResearchAspects(
                "BOTTLETAINT",
                new AspectList().add(Aspect.getAspect("vitium"), 12).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("aqua"), 12).add(Aspect.getAspect("perditio"), 9)
                        .add(Aspect.getAspect("tenebrae"), 9).add(Aspect.getAspect("venenum"), 6)
                        .add(Aspect.getAspect("strontio"), 3));
        TCHelper.setResearchComplexity("BOTTLETAINT", 3);
        ThaumcraftApi.addWarpToResearch("BOTTLETAINT", 5);
        ThaumcraftApi.addWarpToItem(getModItem(Thaumcraft.ID, "ItemBottleTaint", 1, 0), 1);
        ThaumcraftApi.addCrucibleRecipe(
                "THAUMIUM",
                getModItem(Thaumcraft.ID, "ItemResource", 1, 2),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0),
                new AspectList().add(Aspect.getAspect("praecantatio"), 4));
        ThaumcraftApi.addCrucibleRecipe(
                "GT_CRYSTALLISATION",
                getModItem(Thaumcraft.ID, "ItemResource", 1, 6),
                "dustAmber",
                new AspectList().add(Aspect.getAspect("vitreus"), 4));
        TCHelper.refreshResearchPages("CRUCIBLE");
        TCHelper.refreshResearchPages("TALLOW");
        TCHelper.refreshResearchPages("NITOR");
        TCHelper.refreshResearchPages("ALUMENTUM");
        TCHelper.refreshResearchPages("THAUMIUM");
        TCHelper.refreshResearchPages("DISTILESSENTIA");
        TCHelper.refreshResearchPages("JARLABEL");
        TCHelper.refreshResearchPages("JARVOID");
        TCHelper.refreshResearchPages("ALCHEMICALDUPLICATION");
        TCHelper.refreshResearchPages("ALCHEMICALMANUFACTURE");
        TCHelper.refreshResearchPages("THAUMATORIUM");
        TCHelper.refreshResearchPages("ENTROPICPROCESSING");
        TCHelper.refreshResearchPages("BATHSALTS");
        TCHelper.refreshResearchPages("SANESOAP");
        TCHelper.refreshResearchPages("ARCANESPA");
        TCHelper.refreshResearchPages("TUBES");
        TCHelper.refreshResearchPages("TUBEFILTER");
        TCHelper.refreshResearchPages("CENTRIFUGE");
        TCHelper.refreshResearchPages("ESSENTIACRYSTAL");
        TCHelper.refreshResearchPages("TRANSIRON");
        TCHelper.refreshResearchPages("TRANSGOLD");
        TCHelper.refreshResearchPages("TRANSCOPPER");
        TCHelper.refreshResearchPages("TRANSTIN");
        TCHelper.refreshResearchPages("TRANSLEAD");
        TCHelper.refreshResearchPages("TRANSSILVER");
        TCHelper.refreshResearchPages("PUREIRON");
        TCHelper.refreshResearchPages("PUREGOLD");
        TCHelper.refreshResearchPages("PURECOPPER");
        TCHelper.refreshResearchPages("PURETIN");
        TCHelper.refreshResearchPages("PURELEAD");
        TCHelper.refreshResearchPages("PURESILVER");
        TCHelper.refreshResearchPages("LIQUIDDEATH");
    }

    private void artifice() {
        // ARTIFICE

        addShapelessRecipe(
                getModItem(Thaumcraft.ID, "ItemInkwell", 1, 0),
                getModItem(Thaumcraft.ID, "ItemEssence", 1, 0),
                getModItem(Minecraft.ID, "feather", 1, 0),
                "dyeBlack");
        addShapedRecipe(
                getModItem(Thaumcraft.ID, "ItemThaumometer", 1, 0),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 0),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 1),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 2),
                "itemCasingGold",
                "lensDiamond",
                "itemCasingGold",
                getModItem(Thaumcraft.ID, "ItemShard", 1, 3),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 4),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 5));
        addShapedRecipe(
                getModItem(Thaumcraft.ID, "blockTable", 1, 0),
                "slabWood",
                "slabWood",
                "slabWood",
                "stickWood",
                "screwAnyIron",
                "stickWood",
                "slabWood",
                "craftingToolScrewdriver",
                "slabWood");
        addShapelessRecipe(
                getModItem(Thaumcraft.ID, "blockCosmeticSlabStone", 2, 0),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                "craftingToolSaw");

        GTValues.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7))
                .itemOutputs(getModItem(Thaumcraft.ID, "blockCosmeticSlabStone", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 20)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7))
                .itemOutputs(getModItem(Thaumcraft.ID, "blockCosmeticSlabStone", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 8)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7))
                .itemOutputs(getModItem(Thaumcraft.ID, "blockCosmeticSlabStone", 4, 0))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(2)).duration(4 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Ruby, 1L)))
                .itemOutputs(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Jasper, 1L)))
                .itemOutputs(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Spinel, 1L)))
                .itemOutputs(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.GarnetRed, 1L)))
                .itemOutputs(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.InfusedFire, 1L)))
                .itemOutputs(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6), RedZircon.get(OrePrefixes.lens, 0))
                .itemOutputs(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6), Fluorspar.get(OrePrefixes.lens, 0))
                .itemOutputs(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                        GGMaterial.orundum.get(OrePrefixes.lens, 0))
                .itemOutputs(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "blockStoneDevice", 0, 12),
                        getModItem(Thaumcraft.ID, "ItemBathSalts", 1, 0),
                        getModItem(MagicBees.ID, "wax", 1, 0))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("potion.mineralwater"), 4000))
                .fluidOutputs(new FluidStack(FluidRegistry.getFluid("fluidpure"), 4000)).duration(50 * SECONDS).eut(48)
                .addTo(mixerRecipes);

        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemGoggles", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemResource", 1, 15));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemResource", 1, 10));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 3, 6));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 9, 6));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 2));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 4, 2));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 3));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 4, 3));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 2));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockStoneDevice", 2, 1));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemResource", 1, 7));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemChestplateRobe", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemLeggingsRobe", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemBootsRobe", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 7));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 8));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 13));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockLifter", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemArcaneDoor", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 2));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 8, 2));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ArcaneDoorKey", 2, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ArcaneDoorKey", 2, 1));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 1));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemCompassStone", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 14));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "BootsTraveller", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemAmuletRunic", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemAmuletRunic", 1, 1));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemRingRunic", 1, 1));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemRingRunic", 1, 2));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemRingRunic", 1, 3));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemGirdleRunic", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemGirdleRunic", 1, 1));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemGirdleRunic", 1, 1));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 4));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 5));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemPickaxeElemental", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemAxeElemental", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemSwordElemental", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemShovelElemental", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemHoeElemental", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "HoverHarness", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemGirdleHover", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "blockMirror", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "HandMirror", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "blockMirror", 1, 6));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "blockJar", 1, 1));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemHelmetFortress", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemChestplateFortress", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemLeggingsFortress", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemBowBone", 1, 0));
        TCHelper.clearPages("RESEARCH");
        TCHelper.addResearchPage("RESEARCH", new ResearchPage("tc.research_page.RESEARCH.1"));
        TCHelper.addResearchPage("RESEARCH", new ResearchPage("tc.research_page.RESEARCH.2"));
        TCHelper.addResearchPage(
                "RESEARCH",
                new ResearchPage(TCHelper.findCraftingRecipe(getModItem(Thaumcraft.ID, "ItemThaumometer", 1, 0))));
        TCHelper.addResearchPage("RESEARCH", new ResearchPage("tc.research_page.RESEARCH.3"));
        TCHelper.addResearchPage("RESEARCH", new ResearchPage("tc.research_page.RESEARCH.4"));
        TCHelper.addResearchPage(
                "RESEARCH",
                new ResearchPage(TCHelper.findCraftingRecipe(getModItem(Thaumcraft.ID, "ItemInkwell", 1, 0))));
        TCHelper.addResearchPage("RESEARCH", new ResearchPage("tc.research_page.RESEARCH.5"));
        TCHelper.addResearchPage("RESEARCH", new ResearchPage("tc.research_page.RESEARCH.6"));
        TCHelper.addResearchPage("RESEARCH", new ResearchPage("tc.research_page.RESEARCH.7"));
        TCHelper.addResearchPage("RESEARCH", new ResearchPage("tc.research_page.RESEARCH.8"));
        TCHelper.addResearchPage("RESEARCH", new ResearchPage("tc.research_page.RESEARCH.9"));
        TCHelper.addResearchPage("RESEARCH", new ResearchPage("tc.research_page.RESEARCH.10"));
        TCHelper.addResearchPage("RESEARCH", new ResearchPage("tc.research_page.RESEARCH.11"));
        TCHelper.addResearchPage("RESEARCH", new ResearchPage("tc.research_page.RESEARCH.12"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GOGGLES",
                getModItem(Thaumcraft.ID, "ItemGoggles", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("terra"), 30)
                        .add(Aspect.getAspect("ignis"), 30).add(Aspect.getAspect("aqua"), 30)
                        .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("perditio"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                'b',
                "screwGold",
                'c',
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                'd',
                "ringGold",
                'e',
                "craftingToolScrewdriver",
                'f',
                "ringGold",
                'g',
                getModItem(Thaumcraft.ID, "ItemThaumometer", 1, 0),
                'h',
                "stickGold",
                'i',
                getModItem(Thaumcraft.ID, "ItemThaumometer", 1, 0));
        TCHelper.setResearchAspects(
                "GOGGLES",
                new AspectList().add(Aspect.getAspect("auram"), 3).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("sensus"), 9).add(Aspect.getAspect("instrumentum"), 6));
        TCHelper.setResearchComplexity("GOGGLES", 2);
        TCHelper.clearPages("BASICARTIFACE");
        TCHelper.addResearchPage("BASICARTIFACE", new ResearchPage("tc.research_page.BASICARTIFACE.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "BASICARTIFACE",
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                new AspectList().add(Aspect.getAspect("aer"), 50).add(Aspect.getAspect("terra"), 50)
                        .add(Aspect.getAspect("ignis"), 50).add(Aspect.getAspect("aqua"), 50)
                        .add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("perditio"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                'b',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                'c',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                'd',
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.RoseGold, 1L),
                'e',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                'f',
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.RoseGold, 1L),
                'g',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                'h',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                'i',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5));
        TCHelper.addResearchPage(
                "BASICARTIFACE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemResource", 1, 15))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "BASICARTIFACE",
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 5).add(Aspect.getAspect("ignis"), 10)
                        .add(Aspect.getAspect("ordo"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "wireFineGold",
                'b',
                "wireFineGold",
                'c',
                "wireFineGold",
                'd',
                "wireFineGold",
                'e',
                "craftingToolScrewdriver",
                'f',
                "wireFineGold",
                'g',
                "screwGold",
                'h',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                'i',
                "screwGold");
        TCHelper.addResearchPage(
                "BASICARTIFACE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "BASICARTIFACE",
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 1),
                new AspectList().add(Aspect.getAspect("terra"), 10).add(Aspect.getAspect("ignis"), 10)
                        .add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "screwGold",
                'b',
                "stickGold",
                'c',
                "screwGold",
                'd',
                "stickGold",
                'e',
                "craftingToolScrewdriver",
                'f',
                "stickGold",
                'g',
                "screwGold",
                'h',
                "stickGold",
                'i',
                "screwGold");
        TCHelper.addResearchPage(
                "BASICARTIFACE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 1))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "BASICARTIFACE",
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 2),
                new AspectList().add(Aspect.getAspect("terra"), 10).add(Aspect.getAspect("ignis"), 5)
                        .add(Aspect.getAspect("ordo"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "screwGold",
                'b',
                "materialHardenedleather",
                'c',
                "screwGold",
                'd',
                "materialHardenedleather",
                'e',
                "craftingToolScrewdriver",
                'f',
                "materialHardenedleather",
                'g',
                "screwGold",
                'h',
                "ringGold",
                'i',
                "screwGold");
        TCHelper.addResearchPage(
                "BASICARTIFACE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 2))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "BASICARTIFACE",
                getModItem(Thaumcraft.ID, "ItemResource", 1, 10),
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("terra"), 30)
                        .add(Aspect.getAspect("ignis"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                MetaGeneratedItem98.FluidCell.LIQUID_ENDER.get(),
                'b',
                "gemMercury",
                'c',
                MetaGeneratedItem98.FluidCell.LIQUID_ENDER.get(),
                'd',
                "gemMercury",
                'e',
                getModItem(Minecraft.ID, "glass_pane", 1, 0),
                'f',
                "gemMercury",
                'g',
                MetaGeneratedItem98.FluidCell.LIQUID_ENDER.get(),
                'h',
                "gemMercury",
                'i',
                MetaGeneratedItem98.FluidCell.LIQUID_ENDER.get());
        TCHelper.addResearchPage(
                "BASICARTIFACE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemResource", 1, 10))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ARCANESTONE",
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 8, 6),
                new AspectList().add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("terra"), 8)
                        .add(Aspect.getAspect("ignis"), 8).add(Aspect.getAspect("aqua"), 8)
                        .add(Aspect.getAspect("ordo"), 8).add(Aspect.getAspect("perditio"), 8),
                "abc",
                "def",
                "ghi",
                'a',
                "stone",
                'b',
                "stone",
                'c',
                "stone",
                'd',
                "stone",
                'e',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, wildcard),
                'f',
                "stone",
                'g',
                "stone",
                'h',
                "stone",
                'i',
                "stone");
        TCHelper.clearPages("ARCANESTONE");
        TCHelper.addResearchPage("ARCANESTONE", new ResearchPage("tc.research_page.ARCANESTONE.1"));
        TCHelper.addResearchPage(
                "ARCANESTONE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6))));
        TCHelper.addResearchPage(
                "ARCANESTONE",
                new ResearchPage(
                        TCHelper.findCraftingRecipe(getModItem(Thaumcraft.ID, "blockStairsArcaneStone", 1, 0))));
        TCHelper.addResearchPage(
                "ARCANESTONE",
                new ResearchPage(
                        TCHelper.findCraftingRecipe(getModItem(Thaumcraft.ID, "blockCosmeticSlabStone", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "INFUSION",
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 2),
                new AspectList().add(Aspect.getAspect("aer"), 40).add(Aspect.getAspect("terra"), 40)
                        .add(Aspect.getAspect("ignis"), 40).add(Aspect.getAspect("aqua"), 40)
                        .add(Aspect.getAspect("ordo"), 40).add(Aspect.getAspect("perditio"), 40),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                'b',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                'd',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                'e',
                getModItem(Minecraft.ID, "ender_eye", 1, 0),
                'f',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                'g',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                'h',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                'i',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "INFUSION",
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 1),
                new AspectList().add(Aspect.getAspect("aer"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                'b',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                'e',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                'g',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                'h',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                'i',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6));
        TCHelper.setResearchAspects(
                "INFUSION",
                new AspectList().add(Aspect.getAspect("fabrico"), 9).add(Aspect.getAspect("machina"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("cognitio"), 6)
                        .add(Aspect.getAspect("motus"), 3));
        TCHelper.setResearchComplexity("INFUSION", 2);
        TCHelper.clearPages("PAVETRAVEL");
        TCHelper.addResearchPage("PAVETRAVEL", new ResearchPage("tc.research_page.PAVETRAVEL.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "PAVETRAVEL",
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 4, 2),
                new AspectList().add(Aspect.getAspect("aer"), 12).add(Aspect.getAspect("ordo"), 12)
                        .add(Aspect.getAspect("terra"), 12),
                "abc",
                "def",
                "ghi",
                'a',
                "plateInfusedAir",
                'b',
                "plateInfusedEarth",
                'c',
                "plateInfusedAir",
                'd',
                "plateInfusedEarth",
                'e',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                'f',
                "plateInfusedEarth",
                'g',
                "plateInfusedAir",
                'h',
                "plateInfusedEarth",
                'i',
                "plateInfusedAir");
        TCHelper.addResearchPage(
                "PAVETRAVEL",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 2))));
        TCHelper.setResearchAspects(
                "PAVETRAVEL",
                new AspectList().add(Aspect.getAspect("iter"), 9).add(Aspect.getAspect("volatus"), 6)
                        .add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("motus"), 3));
        TCHelper.setResearchComplexity("PAVETRAVEL", 2);
        TCHelper.clearPages("PAVEWARD");
        TCHelper.addResearchPage("PAVEWARD", new ResearchPage("tc.research_page.PAVEWARD.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "PAVEWARD",
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 4, 3),
                new AspectList().add(Aspect.getAspect("ignis"), 12).add(Aspect.getAspect("ordo"), 12)
                        .add(Aspect.getAspect("terra"), 12),
                "abc",
                "def",
                "ghi",
                'a',
                "plateInfusedOrder",
                'b',
                "plateInfusedFire",
                'c',
                "plateInfusedOrder",
                'd',
                "plateInfusedFire",
                'e',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                'f',
                "plateInfusedFire",
                'g',
                "plateInfusedOrder",
                'h',
                "plateInfusedFire",
                'i',
                "plateInfusedOrder");
        TCHelper.addResearchPage(
                "PAVEWARD",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 3))));
        TCHelper.addResearchPage("PAVEWARD", new ResearchPage("tc.research_page.PAVEWARD.2"));
        TCHelper.setResearchAspects(
                "PAVEWARD",
                new AspectList().add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("bestia"), 9)
                        .add(Aspect.getAspect("vinculum"), 3).add(Aspect.getAspect("telum"), 6));
        TCHelper.setResearchComplexity("PAVEWARD", 2);
        TCHelper.clearPages("GRATE");
        TCHelper.addResearchPage("GRATE", new ResearchPage("tc.research_page.GRATE.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GRATE",
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 5),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("ignis"), 5)
                        .add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "screwSteel",
                'b',
                NHItemList.SteelBars.get(),
                'c',
                "screwSteel",
                'd',
                "wireGt01RedAlloy",
                'e',
                NHItemList.AluminiumBars.get(),
                'f',
                "craftingToolScrewdriver",
                'g',
                "screwSteel",
                'h',
                NHItemList.SteelBars.get(),
                'i',
                "screwSteel");
        TCHelper.addResearchPage(
                "GRATE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 5))));
        TCHelper.clearPages("ENCHFABRIC");
        TCHelper.addResearchPage("ENCHFABRIC", new ResearchPage("tc.research_page.ENCHFABRIC.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ENCHFABRIC",
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("terra"), 5)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ordo"), 5).add(Aspect.getAspect("perditio"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Minecraft.ID, "string", 1, 0),
                'b',
                getModItem(Minecraft.ID, "string", 1, 0),
                'c',
                getModItem(Minecraft.ID, "string", 1, 0),
                'd',
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0),
                'e',
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0),
                'f',
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0),
                'g',
                getModItem(Minecraft.ID, "string", 1, 0),
                'h',
                getModItem(Minecraft.ID, "string", 1, 0),
                'i',
                getModItem(Minecraft.ID, "string", 1, 0));
        TCHelper.setResearchAspects(
                "ENCHFABRIC",
                new AspectList().add(Aspect.getAspect("pannus"), 6).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("tutamen"), 3));
        TCHelper.setResearchComplexity("ENCHFABRIC", 1);
        TCHelper.addResearchPage(
                "ENCHFABRIC",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemResource", 1, 7))));
        TCHelper.addResearchPage("ENCHFABRIC", new ResearchPage("tc.research_page.ENCHFABRIC.2"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ENCHFABRIC",
                getModItem(Thaumcraft.ID, "ItemChestplateRobe", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("aqua"), 15).add(Aspect.getAspect("ordo"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'b',
                "plateThaumium",
                'c',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'e',
                "plateThaumium",
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'g',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'i',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7));
        TCHelper.addResearchPage(
                "ENCHFABRIC",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemChestplateRobe", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ENCHFABRIC",
                getModItem(Thaumcraft.ID, "ItemLeggingsRobe", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("aqua"), 15).add(Aspect.getAspect("perditio"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'c',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'e',
                "plateThaumium",
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'g',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'h',
                "plateThaumium",
                'i',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7));
        TCHelper.addResearchPage(
                "ENCHFABRIC",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemLeggingsRobe", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ENCHFABRIC",
                getModItem(Thaumcraft.ID, "ItemBootsRobe", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("terra"), 15)
                        .add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("aqua"), 15),
                "abc",
                "def",
                "ghi",
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'e',
                "plateThaumium",
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'g',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'h',
                "plateThaumium",
                'i',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7));
        TCHelper.addResearchPage(
                "ENCHFABRIC",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemBootsRobe", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ARCANELAMP",
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 7),
                new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("perditio"), 5)
                        .add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("aqua"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "paneGlassColorless",
                'b',
                getModItem(Minecraft.ID, "daylight_detector", 1, 0),
                'c',
                "paneGlassColorless",
                'd',
                "plateSteel",
                'e',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 0),
                'f',
                "plateSteel",
                'g',
                "paneGlassColorless",
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1),
                'i',
                "paneGlassColorless");
        TCHelper.setResearchAspects(
                "ARCANELAMP",
                new AspectList().add(Aspect.getAspect("lux"), 6).add(Aspect.getAspect("tenebrae"), 3)
                        .add(Aspect.getAspect("sensus"), 6));
        TCHelper.setResearchComplexity("ARCANELAMP", 1);
        TCHelper.addInfusionCraftingRecipe(
                "LAMPGROWTH",
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 8),
                5,
                new AspectList().add(Aspect.getAspect("herba"), 20).add(Aspect.getAspect("lux"), 10)
                        .add(Aspect.getAspect("victus"), 20).add(Aspect.getAspect("messis"), 10),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 7),
                OrePrefixes.plate.get(Materials.Gold),
                getModItem(Minecraft.ID, "dye", 1, 15),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                OrePrefixes.plate.get(Materials.Gold),
                getModItem(Minecraft.ID, "dye", 1, 15),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3));
        TCHelper.setResearchAspects(
                "LAMPGROWTH",
                new AspectList().add(Aspect.getAspect("messis"), 9).add(Aspect.getAspect("lux"), 3)
                        .add(Aspect.getAspect("herba"), 6).add(Aspect.getAspect("victus"), 9));
        TCHelper.setResearchComplexity("LAMPGROWTH", 2);
        TCHelper.addInfusionCraftingRecipe(
                "LAMPFERTILITY",
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 13),
                5,
                new AspectList().add(Aspect.getAspect("bestia"), 20).add(Aspect.getAspect("lux"), 10)
                        .add(Aspect.getAspect("victus"), 20).add(Aspect.getAspect("sano"), 10),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 7),
                OrePrefixes.plate.get(Materials.Gold),
                getModItem(Minecraft.ID, "wheat", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                OrePrefixes.plate.get(Materials.Gold),
                getModItem(Minecraft.ID, "golden_carrot", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1));
        TCHelper.setResearchAspects(
                "LAMPFERTILITY",
                new AspectList().add(Aspect.getAspect("bestia"), 9).add(Aspect.getAspect("lux"), 3)
                        .add(Aspect.getAspect("victus"), 9).add(Aspect.getAspect("sano"), 6));
        TCHelper.setResearchComplexity("LAMPFERTILITY", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "LEVITATOR",
                getModItem(Thaumcraft.ID, "blockLifter", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("terra"), 10)
                        .add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6),
                'b',
                "plateInfusedAir",
                'c',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6),
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1),
                'e',
                "rotorThaumium",
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 0),
                'g',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6),
                'h',
                "plateInfusedEarth",
                'i',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6));
        TCHelper.setResearchAspects(
                "LEVITATOR",
                new AspectList().add(Aspect.getAspect("aer"), 3).add(Aspect.getAspect("volatus"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3).add(Aspect.getAspect("motus"), 6));
        TCHelper.setResearchComplexity("LEVITATOR", 1);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "WARDEDARCANA",
                getModItem(Thaumcraft.ID, "ItemArcaneDoor", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("ignis"), 5)
                        .add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("perditio"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6),
                'b',
                getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0),
                'c',
                "craftingToolScrewdriver",
                'd',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6),
                'e',
                "ringThaumium",
                'f',
                "screwThaumium",
                'g',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6),
                'h',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6),
                'i',
                "craftingToolSaw");
        TCHelper.setResearchAspects(
                "WARDEDARCANA",
                new AspectList().add(Aspect.getAspect("tutamen"), 6).add(Aspect.getAspect("instrumentum"), 6)
                        .add(Aspect.getAspect("machina"), 6).add(Aspect.getAspect("motus"), 3));
        TCHelper.setResearchComplexity("WARDEDARCANA", 1);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "WARDEDARCANA",
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 2),
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("ignis"), 5)
                        .add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("perditio"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "screwThaumium",
                'b',
                "craftingToolScrewdriver",
                'c',
                "screwThaumium",
                'd',
                getModItem(Thaumcraft.ID, "blockCosmeticSlabWood", 1, 0),
                'e',
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0),
                'f',
                getModItem(Thaumcraft.ID, "blockCosmeticSlabWood", 1, 0),
                'g',
                "plateThaumium",
                'h',
                getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0),
                'i',
                "plateThaumium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "WARDEDARCANA",
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 4, 2),
                new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("aqua"), 10)
                        .add(Aspect.getAspect("ignis"), 10).add(Aspect.getAspect("ordo"), 10)
                        .add(Aspect.getAspect("perditio"), 10).add(Aspect.getAspect("terra"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "blockGlass",
                'b',
                "plateThaumium",
                'c',
                "blockGlass",
                'd',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6),
                'e',
                getModItem(Thaumcraft.ID, "FocusWarding", 1, 0),
                'f',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6),
                'g',
                "blockGlass",
                'h',
                "plateThaumium",
                'i',
                "blockGlass");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "WARDEDARCANA",
                getModItem(Thaumcraft.ID, "ArcaneDoorKey", 2, 0),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("ignis"), 5)
                        .add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "stickIron",
                'b',
                "stickIron",
                'c',
                "ringIron",
                'd',
                "boltIron",
                'e',
                "boltIron",
                'f',
                "plateSteel",
                'g',
                "boltIron",
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "WARDEDARCANA",
                getModItem(Thaumcraft.ID, "ArcaneDoorKey", 2, 1),
                new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("ignis"), 10)
                        .add(Aspect.getAspect("ordo"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "stickGold",
                'b',
                "stickGold",
                'c',
                "ringGold",
                'd',
                "boltGold",
                'e',
                "boltGold",
                'f',
                "craftingToolScrewdriver",
                'g',
                "boltGold",
                'h',
                "craftingToolHardHammer");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ARCANEEAR",
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 1),
                new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("terra"), 10)
                        .add(Aspect.getAspect("ordo"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "plateThaumium",
                'b',
                ItemList.Sensor_LV.get(1L),
                'c',
                "plateThaumium",
                'd',
                "plateGold",
                'e',
                getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0),
                'f',
                "plateGold",
                'g',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6),
                'h',
                "wireGt01RedAlloy",
                'i',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6));
        TCHelper.setResearchAspects(
                "ARCANEEAR",
                new AspectList().add(Aspect.getAspect("aer"), 9).add(Aspect.getAspect("sensus"), 9)
                        .add(Aspect.getAspect("praecantatio"), 3).add(Aspect.getAspect("potentia"), 6));
        TCHelper.setResearchComplexity("ARCANEEAR", 2);
        TCHelper.addInfusionCraftingRecipe(
                "SINSTONE",
                getModItem(Thaumcraft.ID, "ItemCompassStone", 1, 0),
                4,
                new AspectList().add(Aspect.getAspect("alienis"), 10).add(Aspect.getAspect("auram"), 10)
                        .add(Aspect.getAspect("sensus"), 10).add(Aspect.getAspect("tenebrae"), 10)
                        .add(Aspect.getAspect("ordo"), 10),
                getModItem(Minecraft.ID, "flint", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 4),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 9),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 5),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 0),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 6));
        TCHelper.setResearchAspects(
                "SINSTONE",
                new AspectList().add(Aspect.getAspect("auram"), 6).add(Aspect.getAspect("sensus"), 3)
                        .add(Aspect.getAspect("tenebrae"), 6).add(Aspect.getAspect("alienis"), 6));
        TCHelper.setResearchComplexity("SINSTONE", 2);
        ThaumcraftApi.addWarpToResearch("SINSTONE", 1);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "BELLOWS",
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("ordo"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticSlabWood", 1, 0),
                'b',
                "shardAir",
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticSlabWood", 1, 0),
                'd',
                getModItem(Backpack.ID, "tannedLeather", 1, 0),
                'e',
                ItemList.Electric_Piston_LV.get(1L),
                'f',
                getModItem(Backpack.ID, "tannedLeather", 1, 0),
                'g',
                getModItem(Thaumcraft.ID, "blockCosmeticSlabWood", 1, 0),
                'h',
                "shardAir",
                'i',
                getModItem(Thaumcraft.ID, "blockCosmeticSlabWood", 1, 0));
        TCHelper.setResearchAspects(
                "BELLOWS",
                new AspectList().add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("aer"), 12)
                        .add(Aspect.getAspect("praecantatio"), 3).add(Aspect.getAspect("machina"), 9));
        TCHelper.setResearchComplexity("BELLOWS", 2);
        TCHelper.clearPages("FLUXSCRUB");
        TCHelper.addResearchPage("FLUXSCRUB", new ResearchPage("tc.research_page.FLUXSCRUB.1"));
        TCHelper.addInfusionCraftingRecipe(
                "FLUXSCRUB",
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 14),
                4,
                new AspectList().add(Aspect.getAspect("aqua"), 25).add(Aspect.getAspect("aer"), 20)
                        .add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("vinculum"), 10)
                        .add(Aspect.getAspect("vitium"), 5),
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 0),
                getModItem(Thaumcraft.ID, "blockTube", 1, 0),
                NHItemList.SteelBars.get(),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 8),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                getModItem(Thaumcraft.ID, "blockTube", 1, 1),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 8),
                NHItemList.SteelBars.get());
        TCHelper.addResearchPage(
                "FLUXSCRUB",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 14))));
        TCHelper.setResearchAspects(
                "FLUXSCRUB",
                new AspectList().add(Aspect.getAspect("aqua"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("aer"), 9).add(Aspect.getAspect("vinculum"), 6)
                        .add(Aspect.getAspect("vitium"), 3));
        TCHelper.setResearchComplexity("FLUXSCRUB", 3);
        TCHelper.addInfusionCraftingRecipe(
                "BOOTSTRAVELLER",
                getModItem(Thaumcraft.ID, "BootsTraveller", 1, 0),
                2,
                new AspectList().add(Aspect.getAspect("volatus"), 25).add(Aspect.getAspect("aer"), 25)
                        .add(Aspect.getAspect("iter"), 25).add(Aspect.getAspect("aqua"), 5),
                getModItem(Minecraft.ID, "leather_boots", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                getModItem(Minecraft.ID, "feather", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                getModItem(Minecraft.ID, "fish", 1, wildcard),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7));
        TCHelper.setResearchAspects(
                "BOOTSTRAVELLER",
                new AspectList().add(Aspect.getAspect("aqua"), 9).add(Aspect.getAspect("iter"), 15)
                        .add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("volatus"), 12)
                        .add(Aspect.getAspect("aer"), 3));
        TCHelper.setResearchComplexity("BOOTSTRAVELLER", 3);
        TCHelper.addInfusionCraftingRecipe(
                "RUNICARMOR",
                getModItem(Thaumcraft.ID, "ItemRingRunic", 1, 1),
                2,
                new AspectList().add(Aspect.getAspect("potentia"), 25).add(Aspect.getAspect("tutamen"), 25)
                        .add(Aspect.getAspect("praecantatio"), 25).add(Aspect.getAspect("alienis"), 5),
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 1),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                OrePrefixes.gemFlawless.get(Materials.Amber),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                getModItem(Thaumcraft.ID, "ItemInkwell", 1, 0),
                getModItem(Minecraft.ID, "blaze_powder", 1, 0),
                OrePrefixes.gemFlawless.get(Materials.Amber));
        TCHelper.setResearchAspects(
                "RUNICARMOR",
                new AspectList().add(Aspect.getAspect("cognitio"), 15).add(Aspect.getAspect("tutamen"), 12)
                        .add(Aspect.getAspect("aer"), 9).add(Aspect.getAspect("potentia"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("RUNICARMOR", 3);
        TCHelper.addInfusionCraftingRecipe(
                "RUNICCHARGED",
                getModItem(Thaumcraft.ID, "ItemRingRunic", 1, 2),
                6,
                new AspectList().add(Aspect.getAspect("potentia"), 64).add(Aspect.getAspect("tutamen"), 32)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("alienis"), 16)
                        .add(Aspect.getAspect("aer"), 8),
                getModItem(Thaumcraft.ID, "ItemRingRunic", 1, 1),
                getModItem(Minecraft.ID, "potion", 1, 8226),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                getModItem(Minecraft.ID, "potion", 1, 8226),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1));
        TCHelper.setResearchAspects(
                "RUNICCHARGED",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("tutamen"), 9).add(Aspect.getAspect("alienis"), 12)
                        .add(Aspect.getAspect("aer"), 9).add(Aspect.getAspect("cognitio"), 6)
                        .add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("RUNICCHARGED", 3);
        TCHelper.addInfusionCraftingRecipe(
                "RUNICHEALING",
                getModItem(Thaumcraft.ID, "ItemRingRunic", 1, 3),
                6,
                new AspectList().add(Aspect.getAspect("aqua"), 64).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("sano"), 32).add(Aspect.getAspect("tutamen"), 32)
                        .add(Aspect.getAspect("aer"), 8),
                getModItem(Thaumcraft.ID, "ItemRingRunic", 1, 1),
                getModItem(Minecraft.ID, "potion", 1, 8225),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                getModItem(Minecraft.ID, "potion", 1, 8225),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2));
        TCHelper.setResearchAspects(
                "RUNICHEALING",
                new AspectList().add(Aspect.getAspect("praecantatio"), 18).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("sano"), 12).add(Aspect.getAspect("tutamen"), 9)
                        .add(Aspect.getAspect("alienis"), 9).add(Aspect.getAspect("aer"), 6)
                        .add(Aspect.getAspect("cognitio"), 3));
        TCHelper.setResearchComplexity("RUNICHEALING", 3);
        TCHelper.addInfusionCraftingRecipe(
                "RUNICARMOR",
                getModItem(Thaumcraft.ID, "ItemAmuletRunic", 1, 0),
                4,
                new AspectList().add(Aspect.getAspect("potentia"), 40).add(Aspect.getAspect("tutamen"), 40)
                        .add(Aspect.getAspect("praecantatio"), 40).add(Aspect.getAspect("alienis"), 20),
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                OrePrefixes.gemFlawless.get(Materials.Amber),
                getModItem(Minecraft.ID, "blaze_powder", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                getModItem(Thaumcraft.ID, "ItemInkwell", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                getModItem(Minecraft.ID, "blaze_powder", 1, 0),
                OrePrefixes.gemFlawless.get(Materials.Amber));
        TCHelper.addInfusionCraftingRecipe(
                "RUNICEMERGENCY",
                getModItem(Thaumcraft.ID, "ItemAmuletRunic", 1, 1),
                8,
                new AspectList().add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("terra"), 64)
                        .add(Aspect.getAspect("tutamen"), 64).add(Aspect.getAspect("vacuos"), 32)
                        .add(Aspect.getAspect("sano"), 8),
                getModItem(Thaumcraft.ID, "ItemAmuletRunic", 1, 0),
                getModItem(Minecraft.ID, "potion", 1, 8233),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                getModItem(Minecraft.ID, "potion", 1, 8233),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3));
        TCHelper.setResearchAspects(
                "RUNICEMERGENCY",
                new AspectList().add(Aspect.getAspect("vacuos"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("terra"), 9).add(Aspect.getAspect("tutamen"), 9)
                        .add(Aspect.getAspect("alienis"), 6).add(Aspect.getAspect("sano"), 6)
                        .add(Aspect.getAspect("cognitio"), 3));
        TCHelper.setResearchComplexity("RUNICEMERGENCY", 3);
        TCHelper.addInfusionCraftingRecipe(
                "RUNICARMOR",
                getModItem(Thaumcraft.ID, "ItemGirdleRunic", 1, 0),
                4,
                new AspectList().add(Aspect.getAspect("potentia"), 55).add(Aspect.getAspect("tutamen"), 55)
                        .add(Aspect.getAspect("praecantatio"), 55).add(Aspect.getAspect("alienis"), 35),
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 2),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                OrePrefixes.gemFlawless.get(Materials.Amber),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                getModItem(Minecraft.ID, "blaze_powder", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                getModItem(Thaumcraft.ID, "ItemInkwell", 1, 0),
                getModItem(Minecraft.ID, "blaze_powder", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                getModItem(Minecraft.ID, "blaze_powder", 1, 0),
                OrePrefixes.gemFlawless.get(Materials.Amber));
        TCHelper.addInfusionCraftingRecipe(
                "RUNICKINETIC",
                getModItem(Thaumcraft.ID, "ItemGirdleRunic", 1, 1),
                8,
                new AspectList().add(Aspect.getAspect("aer"), 64).add(Aspect.getAspect("praecantatio"), 64)
                        .add(Aspect.getAspect("tutamen"), 64).add(Aspect.getAspect("bestia"), 32)
                        .add(Aspect.getAspect("telum"), 8),
                getModItem(Thaumcraft.ID, "ItemGirdleRunic", 1, 0),
                getModItem(Minecraft.ID, "potion", 1, 16428),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                getModItem(Minecraft.ID, "potion", 1, 16428),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0));
        TCHelper.setResearchAspects(
                "RUNICKINETIC",
                new AspectList().add(Aspect.getAspect("aer"), 18).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("tutamen"), 12).add(Aspect.getAspect("telum"), 9)
                        .add(Aspect.getAspect("alienis"), 9).add(Aspect.getAspect("bestia"), 6)
                        .add(Aspect.getAspect("cognitio"), 3));
        TCHelper.setResearchComplexity("RUNICKINETIC", 3);
        TCHelper.addInfusionCraftingRecipe(
                "ARCANEBORE",
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 5),
                6,
                new AspectList().add(Aspect.getAspect("machina"), 64).add(Aspect.getAspect("motus"), 32)
                        .add(Aspect.getAspect("perditio"), 64).add(Aspect.getAspect("potentia"), 32)
                        .add(Aspect.getAspect("vacuos"), 32),
                ItemList.Electric_Piston_MV.get(1L),
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6),
                OrePrefixes.plate.get(Materials.Gold),
                OrePrefixes.lens.get(Materials.Diamond),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                getModItem(Thaumcraft.ID, "ItemShovelThaumium", 1, 0),
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6),
                OrePrefixes.plate.get(Materials.Gold),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                OrePrefixes.lens.get(Materials.Diamond),
                getModItem(Thaumcraft.ID, "ItemPickThaumium", 1, 0));
        TCHelper.setResearchAspects(
                "ARCANEBORE",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("perfodio"), 12)
                        .add(Aspect.getAspect("machina"), 9).add(Aspect.getAspect("motus"), 9)
                        .add(Aspect.getAspect("vacuos"), 3).add(Aspect.getAspect("cognitio"), 6));
        TCHelper.setResearchComplexity("ARCANEBORE", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ARCANEBORE",
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 4),
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("ordo"), 30)
                        .add(Aspect.getAspect("terra"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticSlabWood", 1, 0),
                'b',
                "pipeSmallSteel",
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticSlabWood", 1, 0),
                'd',
                "plateSteel",
                'e',
                getModItem(Minecraft.ID, "dispenser", 1, 0),
                'f',
                "plateSteel",
                'g',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6),
                'h',
                "wireFineSteel",
                'i',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6));
        TCHelper.addInfusionCraftingRecipe(
                "ELEMENTALPICK",
                getModItem(Thaumcraft.ID, "ItemPickaxeElemental", 1, 0),
                3,
                new AspectList().add(Aspect.getAspect("ignis"), 20).add(Aspect.getAspect("perfodio"), 20)
                        .add(Aspect.getAspect("sensus"), 20).add(Aspect.getAspect("lucrum"), 20),
                getModItem(Thaumcraft.ID, "ItemPickThaumium", 1, 0),
                OrePrefixes.gemFlawless.get(Materials.Ruby),
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 1),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                OrePrefixes.gemFlawless.get(Materials.Diamond),
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1));
        TCHelper.setResearchAspects(
                "ELEMENTALPICK",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("ignis"), 12)
                        .add(Aspect.getAspect("perfodio"), 9).add(Aspect.getAspect("lucrum"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("ELEMENTALPICK", 3);
        TCHelper.addInfusionCraftingRecipe(
                "ELEMENTALAXE",
                getModItem(Thaumcraft.ID, "ItemAxeElemental", 1, 0),
                3,
                new AspectList().add(Aspect.getAspect("aqua"), 10).add(Aspect.getAspect("arbor"), 20)
                        .add(Aspect.getAspect("fabrico"), 20).add(Aspect.getAspect("motus"), 20),
                getModItem(Thaumcraft.ID, "ItemAxeThaumium", 1, 0),
                OrePrefixes.gemFlawless.get(Materials.Sapphire),
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 1),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                OrePrefixes.gemFlawless.get(Materials.Diamond),
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2));
        TCHelper.setResearchAspects(
                "ELEMENTALAXE",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("motus"), 12)
                        .add(Aspect.getAspect("fabrico"), 9).add(Aspect.getAspect("aqua"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("ELEMENTALAXE", 3);
        TCHelper.addInfusionCraftingRecipe(
                "ELEMENTALSWORD",
                getModItem(Thaumcraft.ID, "ItemSwordElemental", 1, 0),
                3,
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("motus"), 20)
                        .add(Aspect.getAspect("potentia"), 20).add(Aspect.getAspect("telum"), 20),
                getModItem(Thaumcraft.ID, "ItemSwordThaumium", 1, 0),
                OrePrefixes.gemFlawless.get(Materials.GarnetYellow),
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 1),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                OrePrefixes.gemFlawless.get(Materials.Diamond),
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0));
        TCHelper.setResearchAspects(
                "ELEMENTALSWORD",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("telum"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("aer"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("ELEMENTALSWORD", 3);
        TCHelper.addInfusionCraftingRecipe(
                "ELEMENTALSHOVEL",
                getModItem(Thaumcraft.ID, "ItemShovelElemental", 1, 0),
                3,
                new AspectList().add(Aspect.getAspect("fabrico"), 20).add(Aspect.getAspect("terra"), 20)
                        .add(Aspect.getAspect("perfodio"), 10).add(Aspect.getAspect("praecantatio"), 20),
                getModItem(Thaumcraft.ID, "ItemShovelThaumium", 1, 0),
                OrePrefixes.gemFlawless.get(Materials.Emerald),
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 1),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                OrePrefixes.gemFlawless.get(Materials.Diamond),
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3));
        TCHelper.setResearchAspects(
                "ELEMENTALSHOVEL",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("terra"), 12)
                        .add(Aspect.getAspect("perfodio"), 9).add(Aspect.getAspect("fabrico"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("ELEMENTALSHOVEL", 3);
        TCHelper.addInfusionCraftingRecipe(
                "ELEMENTALHOE",
                getModItem(Thaumcraft.ID, "ItemHoeElemental", 1, 0),
                3,
                new AspectList().add(Aspect.getAspect("meto"), 10).add(Aspect.getAspect("herba"), 20)
                        .add(Aspect.getAspect("terra"), 20).add(Aspect.getAspect("messis"), 20),
                getModItem(Thaumcraft.ID, "ItemHoeThaumium", 1, 0),
                OrePrefixes.gemFlawless.get(Materials.Amber),
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 1),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                OrePrefixes.gemFlawless.get(Materials.Diamond),
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4));
        TCHelper.setResearchAspects(
                "ELEMENTALHOE",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("victus"), 12)
                        .add(Aspect.getAspect("meto"), 9).add(Aspect.getAspect("messis"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("ELEMENTALHOE", 3);
        TCHelper.addInfusionCraftingRecipe(
                "HOVERHARNESS",
                getModItem(Thaumcraft.ID, "HoverHarness", 1, 0),
                6,
                new AspectList().add(Aspect.getAspect("iter"), 32).add(Aspect.getAspect("machina"), 64)
                        .add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("volatus"), 32)
                        .add(Aspect.getAspect("tutamen"), 16),
                getModItem(Minecraft.ID, "leather_chestplate", 1, 0),
                OrePrefixes.plate.get(Materials.Thaumium),
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                OrePrefixes.plate.get(Materials.Aluminium),
                OrePrefixes.plate.get(Materials.Gold),
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26),
                OrePrefixes.plate.get(Materials.Gold),
                OrePrefixes.plate.get(Materials.Aluminium),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6));
        TCHelper.setResearchAspects(
                "HOVERHARNESS",
                new AspectList().add(Aspect.getAspect("volatus"), 15).add(Aspect.getAspect("machina"), 12)
                        .add(Aspect.getAspect("iter"), 9).add(Aspect.getAspect("aer"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("tutamen"), 3));
        TCHelper.setResearchComplexity("HOVERHARNESS", 3);
        TCHelper.addInfusionCraftingRecipe(
                "HOVERGIRDLE",
                getModItem(Thaumcraft.ID, "ItemGirdleHover", 1, 0),
                8,
                new AspectList().add(Aspect.getAspect("aer"), 64).add(Aspect.getAspect("iter"), 32)
                        .add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("volatus"), 32)
                        .add(Aspect.getAspect("tutamen"), 16),
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 2),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                getModItem(Minecraft.ID, "feather", 1, 0),
                OrePrefixes.plate.get(Materials.Gold),
                OrePrefixes.plate.get(Materials.Aluminium),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.Aluminium),
                OrePrefixes.plate.get(Materials.Gold),
                getModItem(TwilightForest.ID, "item.tfFeather", 1, 0));
        TCHelper.setResearchAspects(
                "HOVERGIRDLE",
                new AspectList().add(Aspect.getAspect("volatus"), 15).add(Aspect.getAspect("motus"), 12)
                        .add(Aspect.getAspect("iter"), 9).add(Aspect.getAspect("aer"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("tutamen"), 3));
        TCHelper.setResearchComplexity("HOVERGIRDLE", 3);
        TCHelper.setResearchAspects(
                "RUNICARMOR",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("permutatio"), 9).add(Aspect.getAspect("tutamen"), 9)
                        .add(Aspect.getAspect("cognitio"), 6).add(Aspect.getAspect("alienis"), 6)
                        .add(Aspect.getAspect("potentia"), 3));
        TCHelper.setResearchComplexity("RUNICARMOR", 3);

        TCHelper.clearPages("MIRROR");
        TCHelper.addResearchPage("MIRROR", new ResearchPage("tc.research_page.MIRROR.1"));
        TCHelper.addResearchPage("MIRROR", new ResearchPage("tc.research_page.MIRROR.2"));
        TCHelper.addInfusionCraftingRecipe(
                "MIRROR",
                getModItem(Thaumcraft.ID, "blockMirror", 1, 0),
                6,
                new AspectList().add(Aspect.getAspect("iter"), 32).add(Aspect.getAspect("permutatio"), 24)
                        .add(Aspect.getAspect("tenebrae"), 16).add(Aspect.getAspect("alienis"), 8),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 10),
                OrePrefixes.plate.get(Materials.VibrantAlloy),
                OrePrefixes.screw.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.Gold),
                OrePrefixes.screw.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.VibrantAlloy),
                OrePrefixes.screw.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.Gold),
                OrePrefixes.screw.get(Materials.Thaumium));
        TCHelper.addResearchPage(
                "MIRROR",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findInfusionRecipe(getModItem(Thaumcraft.ID, "blockMirror", 1, 0)))));
        TCHelper.addResearchPage("MIRROR", new ResearchPage("tc.research_page.MIRROR.3fixed"));
        TCHelper.setResearchAspects(
                "MIRROR",
                new AspectList().add(Aspect.getAspect("vitreus"), 15).add(Aspect.getAspect("iter"), 12)
                        .add(Aspect.getAspect("tenebrae"), 9).add(Aspect.getAspect("alienis"), 9)
                        .add(Aspect.getAspect("cognitio"), 6).add(Aspect.getAspect("potentia"), 3));
        TCHelper.setResearchComplexity("MIRROR", 3);
        ThaumcraftApi.addWarpToResearch("MIRROR", 2);
        TCHelper.addInfusionCraftingRecipe(
                "MIRRORHAND",
                getModItem(Thaumcraft.ID, "HandMirror", 1, 0),
                9,
                new AspectList().add(Aspect.getAspect("instrumentum"), 64).add(Aspect.getAspect("iter"), 32)
                        .add(Aspect.getAspect("motus"), 24).add(Aspect.getAspect("alienis"), 16)
                        .add(Aspect.getAspect("potentia"), 8),
                getModItem(Thaumcraft.ID, "blockMirror", 1, 0),
                getModItem(Minecraft.ID, "compass", 1, 0),
                OrePrefixes.screw.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.screw.get(Materials.Thaumium),
                getModItem(Minecraft.ID, "map", 1, 0),
                OrePrefixes.screw.get(Materials.Thaumium),
                getModItem(Thaumcraft.ID, "WandRod", 1, 0),
                OrePrefixes.screw.get(Materials.Thaumium));
        TCHelper.setResearchAspects(
                "MIRRORHAND",
                new AspectList().add(Aspect.getAspect("iter"), 18).add(Aspect.getAspect("instrumentum"), 15)
                        .add(Aspect.getAspect("vitreus"), 12).add(Aspect.getAspect("alienis"), 9)
                        .add(Aspect.getAspect("cognitio"), 6).add(Aspect.getAspect("potentia"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("MIRRORHAND", 3);
        ThaumcraftApi.addWarpToResearch("MIRRORHAND", 3);
        TCHelper.addInfusionCraftingRecipe(
                "MIRRORESSENTIA",
                getModItem(Thaumcraft.ID, "blockMirror", 1, 6),
                2,
                new AspectList().add(Aspect.getAspect("aqua"), 24).add(Aspect.getAspect("iter"), 32)
                        .add(Aspect.getAspect("permutatio"), 16).add(Aspect.getAspect("vitreus"), 8),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 10),
                OrePrefixes.plate.get(Materials.Tantalum),
                OrePrefixes.screw.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.Steel),
                OrePrefixes.screw.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.Tantalum),
                OrePrefixes.screw.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.Steel),
                OrePrefixes.screw.get(Materials.Thaumium));
        TCHelper.setResearchAspects(
                "MIRRORESSENTIA",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("iter"), 12)
                        .add(Aspect.getAspect("vitreus"), 9).add(Aspect.getAspect("alienis"), 9)
                        .add(Aspect.getAspect("cognitio"), 6).add(Aspect.getAspect("potentia"), 6)
                        .add(Aspect.getAspect("aqua"), 3));
        TCHelper.setResearchComplexity("MIRRORESSENTIA", 3);
        ThaumcraftApi.addWarpToResearch("MIRRORESSENTIA", 3);
        TCHelper.addInfusionCraftingRecipe(
                "JARBRAIN",
                getModItem(Thaumcraft.ID, "blockJar", 1, 1),
                5,
                new AspectList().add(Aspect.getAspect("cognitio"), 15).add(Aspect.getAspect("exanimis"), 30)
                        .add(Aspect.getAspect("sensus"), 15).add(Aspect.getAspect("alienis"), 10),
                getModItem(Thaumcraft.ID, "blockJar", 1, 0),
                getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0),
                getModItem(Minecraft.ID, "poisonous_potato", 1, 0),
                getModItem(Minecraft.ID, "spider_eye", 1, 0),
                getModItem(Minecraft.ID, "water_bucket", 1, 0),
                getModItem(Minecraft.ID, "spider_eye", 1, 0),
                getModItem(Minecraft.ID, "poisonous_potato", 1, 0));
        TCHelper.setResearchAspects(
                "JARBRAIN",
                new AspectList().add(Aspect.getAspect("lucrum"), 15).add(Aspect.getAspect("fames"), 12)
                        .add(Aspect.getAspect("exanimis"), 9).add(Aspect.getAspect("cognitio"), 9)
                        .add(Aspect.getAspect("alienis"), 6).add(Aspect.getAspect("potentia"), 3));
        TCHelper.setResearchComplexity("JARBRAIN", 3);
        TCHelper.setResearchAspects(
                "INFUSIONENCHANTMENT",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("tutamen"), 12).add(Aspect.getAspect("cognitio"), 12)
                        .add(Aspect.getAspect("telum"), 9).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("alienis"), 6));
        TCHelper.setResearchComplexity("INFUSIONENCHANTMENT", 4);
        TCHelper.addInfusionCraftingRecipe(
                "ARMORFORTRESS",
                getModItem(Thaumcraft.ID, "ItemHelmetFortress", 1, 0),
                4,
                new AspectList().add(Aspect.getAspect("metallum"), 32).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("tutamen"), 32).add(Aspect.getAspect("victus"), 16),
                getModItem(Thaumcraft.ID, "ItemHelmetThaumium", 1, 0),
                OrePrefixes.gemFlawless.get(Materials.Emerald),
                OrePrefixes.plate.get(Materials.Gold),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.Thaumium),
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.Gold));
        TCHelper.setResearchAspects(
                "ARMORFORTRESS",
                new AspectList().add(Aspect.getAspect("fabrico"), 15).add(Aspect.getAspect("metallum"), 12)
                        .add(Aspect.getAspect("tutamen"), 9).add(Aspect.getAspect("alienis"), 9)
                        .add(Aspect.getAspect("cognitio"), 6).add(Aspect.getAspect("potentia"), 3));
        TCHelper.setResearchComplexity("ARMORFORTRESS", 3);
        TCHelper.addInfusionCraftingRecipe(
                "ARMORFORTRESS",
                getModItem(Thaumcraft.ID, "ItemChestplateFortress", 1, 0),
                4,
                new AspectList().add(Aspect.getAspect("metallum"), 32).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("tutamen"), 40).add(Aspect.getAspect("cognitio"), 16),
                getModItem(Thaumcraft.ID, "ItemChestplateThaumium", 1, 0),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.Thaumium),
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                OrePrefixes.plate.get(Materials.Gold),
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.Thaumium));
        TCHelper.addInfusionCraftingRecipe(
                "ARMORFORTRESS",
                getModItem(Thaumcraft.ID, "ItemLeggingsFortress", 1, 0),
                4,
                new AspectList().add(Aspect.getAspect("metallum"), 32).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("tutamen"), 24).add(Aspect.getAspect("terra"), 16),
                getModItem(Thaumcraft.ID, "ItemLeggingsThaumium", 1, 0),
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 2),
                OrePrefixes.plate.get(Materials.Gold),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.Thaumium),
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.Gold));
        TCHelper.setResearchAspects(
                "HELMGOGGLES",
                new AspectList().add(Aspect.getAspect("tutamen"), 15).add(Aspect.getAspect("sensus"), 12)
                        .add(Aspect.getAspect("auram"), 9).add(Aspect.getAspect("alienis"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("fabrico"), 3));
        TCHelper.setResearchComplexity("HELMGOGGLES", 3);
        TCHelper.setResearchAspects(
                "MASKGRINNINGDEVIL",
                new AspectList().add(Aspect.getAspect("tutamen"), 15).add(Aspect.getAspect("sano"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("alienis"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("fabrico"), 3));
        TCHelper.setResearchComplexity("MASKGRINNINGDEVIL", 3);
        ThaumcraftApi.addWarpToResearch("MASKGRINNINGDEVIL", 1);
        TCHelper.setResearchAspects(
                "MASKANGRYGHOST",
                new AspectList().add(Aspect.getAspect("tutamen"), 15).add(Aspect.getAspect("perditio"), 12)
                        .add(Aspect.getAspect("mortuus"), 9).add(Aspect.getAspect("alienis"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("fabrico"), 3));
        TCHelper.setResearchComplexity("MASKANGRYGHOST", 3);
        ThaumcraftApi.addWarpToResearch("MASKANGRYGHOST", 1);
        TCHelper.setResearchAspects(
                "MASKSIPPINGFIEND",
                new AspectList().add(Aspect.getAspect("tutamen"), 15).add(Aspect.getAspect("exanimis"), 12)
                        .add(Aspect.getAspect("victus"), 9).add(Aspect.getAspect("alienis"), 9)
                        .add(Aspect.getAspect("cognitio"), 6).add(Aspect.getAspect("potentia"), 3));
        TCHelper.setResearchComplexity("MASKSIPPINGFIEND", 3);
        ThaumcraftApi.addWarpToResearch("MASKSIPPINGFIEND", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "BONEBOW",
                getModItem(Thaumcraft.ID, "ItemBowBone", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 32).add(Aspect.getAspect("perditio"), 32)
                        .add(Aspect.getAspect("terra"), 32),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Natura.ID, "barleyFood", 1, 7),
                'b',
                getModItem(Minecraft.ID, "bone", 1, 0),
                'c',
                "screwThaumium",
                'd',
                getModItem(Natura.ID, "barleyFood", 1, 7),
                'e',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                'f',
                NHItemList.LichBone.get(),
                'g',
                getModItem(Natura.ID, "barleyFood", 1, 7),
                'h',
                getModItem(Minecraft.ID, "bone", 1, 0),
                'i',
                "screwThaumium");

        ThaumcraftApi.addShapelessArcaneCraftingRecipe(
                "THAUMONOMICON",
                getModItem(Thaumcraft.ID, "ItemThaumonomicon", 1, 0),
                new AspectList().add(Aspect.getAspect("ordo"), 2).add(Aspect.getAspect("perditio"), 2)
                        .add(Aspect.getAspect("terra"), 2),
                new ItemStack(Items.book),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14));
        TCHelper.addResearchPage(
                "THAUMONOMICON",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemThaumonomicon", 1, 0)))));

        ThaumcraftApi.addShapelessArcaneCraftingRecipe(
                "BASICARTIFACE",
                getModItem(Thaumcraft.ID, "blockTable", 1, 15),
                new AspectList().add(Aspect.getAspect("ordo"), 2).add(Aspect.getAspect("perditio"), 2)
                        .add(Aspect.getAspect("terra"), 2),
                getModItem(Thaumcraft.ID, "blockTable", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14));
        TCHelper.addResearchPage(
                "BASICARTIFACE",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "blockTable", 1, 15)))));

        ThaumcraftApi.addShapelessArcaneCraftingRecipe(
                "BASICARTIFACE",
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 0),
                new AspectList().add(Aspect.getAspect("ordo"), 2).add(Aspect.getAspect("perditio"), 2)
                        .add(Aspect.getAspect("ignis"), 2),
                new ItemStack(Items.cauldron),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14));
        TCHelper.addResearchPage(
                "BASICARTIFACE",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 0)))));

        TCHelper.setResearchAspects(
                "BONEBOW",
                new AspectList().add(Aspect.getAspect("telum"), 12).add(Aspect.getAspect("motus"), 9)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("exanimis"), 3));
        TCHelper.setResearchComplexity("BONEBOW", 2);
        TCHelper.refreshResearchPages("THAUMOMETER");
        TCHelper.refreshResearchPages("GOGGLES");
        TCHelper.refreshResearchPages("TABLE");
        TCHelper.refreshResearchPages("ARCANESTONE");
        TCHelper.refreshResearchPages("INFUSION");
        TCHelper.refreshResearchPages("ARCANELAMP");
        TCHelper.refreshResearchPages("LAMPGROWTH");
        TCHelper.refreshResearchPages("LAMPFERTILITY");
        TCHelper.refreshResearchPages("PAVETRAVEL");
        TCHelper.refreshResearchPages("PAVEWARD");
        TCHelper.refreshResearchPages("LEVITATOR");
        TCHelper.refreshResearchPages("WARDEDARCANA");
        TCHelper.refreshResearchPages("ARCANEEAR");
        TCHelper.refreshResearchPages("SINSTONE");
        TCHelper.refreshResearchPages("BELLOWS");
        TCHelper.refreshResearchPages("FLUXSCRUB");
        TCHelper.refreshResearchPages("BOOTSTRAVELLER");
        TCHelper.refreshResearchPages("RUNICARMOR");
        TCHelper.refreshResearchPages("RUNICKINETIC");
        TCHelper.refreshResearchPages("RUNICEMERGENCY");
        TCHelper.refreshResearchPages("RUNICCHARGED");
        TCHelper.refreshResearchPages("RUNICHEALING");
        TCHelper.refreshResearchPages("ARCANEBORE");
        TCHelper.refreshResearchPages("ELEMENTALPICK");
        TCHelper.refreshResearchPages("ELEMENTALAXE");
        TCHelper.refreshResearchPages("ELEMENTALSWORD");
        TCHelper.refreshResearchPages("ELEMENTALSHOVEL");
        TCHelper.refreshResearchPages("ELEMENTALHOE");
        TCHelper.refreshResearchPages("HOVERHARNESS");
        TCHelper.refreshResearchPages("HOVERGIRDLE");
        TCHelper.refreshResearchPages("RUNICARMOR");
        TCHelper.refreshResearchPages("MIRROR");
        TCHelper.refreshResearchPages("MIRRORHAND");
        TCHelper.refreshResearchPages("MIRRORESSENTIA");
        TCHelper.refreshResearchPages("JARBRAIN");
        TCHelper.refreshResearchPages("INFUSIONENCHANTMENT");
        TCHelper.refreshResearchPages("ARMORFORTRESS");
        TCHelper.refreshResearchPages("HELMGOGGLES");
        TCHelper.refreshResearchPages("MASKGRINNINGDEVIL");
        TCHelper.refreshResearchPages("MASKANGRYGHOST");
        TCHelper.refreshResearchPages("MASKSIPPINGFIEND");
        TCHelper.refreshResearchPages("BONEBOW");
    }

    private void golemancy() {
        // GOLEMANCY

        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockChestHungry", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "TrunkSpawner", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 9));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemGolemPlacer", 1, 0));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemGolemPlacer", 1, 1));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemGolemPlacer", 1, 2));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemGolemPlacer", 1, 3));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemGolemPlacer", 1, 4));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemGolemPlacer", 1, 5));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemGolemPlacer", 1, 6));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemGolemPlacer", 1, 7));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 100));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 2));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 1));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 0));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 3));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 4));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 8));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 10));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 5));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 6));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 9));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 11));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 7));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemGolemUpgrade", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemGolemUpgrade", 1, 1));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemGolemUpgrade", 1, 2));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemGolemUpgrade", 1, 3));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemGolemUpgrade", 1, 4));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemGolemUpgrade", 1, 5));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemGolemDecoration", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemGolemDecoration", 1, 1));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemGolemDecoration", 1, 2));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemGolemDecoration", 1, 3));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemGolemDecoration", 1, 4));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemGolemDecoration", 1, 5));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemGolemDecoration", 1, 6));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemGolemDecoration", 1, 7));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "HUNGRYCHEST",
                getModItem(Thaumcraft.ID, "blockChestHungry", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("terra"), 10)
                        .add(Aspect.getAspect("ordo"), 5).add(Aspect.getAspect("perditio"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "screwThaumium",
                'b',
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 5),
                'c',
                "screwThaumium",
                'd',
                getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0),
                'e',
                "chestWood",
                'f',
                getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0),
                'g',
                "screwThaumium",
                'h',
                "craftingToolScrewdriver",
                'i',
                "screwThaumium");
        TCHelper.setResearchAspects(
                "HUNGRYCHEST",
                new AspectList().add(Aspect.getAspect("fames"), 9).add(Aspect.getAspect("vacuos"), 6)
                        .add(Aspect.getAspect("iter"), 3));
        TCHelper.setResearchComplexity("HUNGRYCHEST", 1);
        TCHelper.addInfusionCraftingRecipe(
                "TRAVELTRUNK",
                getModItem(Thaumcraft.ID, "TrunkSpawner", 1, 0),
                4,
                new AspectList().add(Aspect.getAspect("iter"), 16).add(Aspect.getAspect("motus"), 16)
                        .add(Aspect.getAspect("spiritus"), 16).add(Aspect.getAspect("vacuos"), 32),
                getModItem(Thaumcraft.ID, "blockChestHungry", 1, 0),
                OrePrefixes.plate.get(Materials.StainlessSteel),
                OrePrefixes.ring.get(Materials.StainlessSteel),
                OrePrefixes.screw.get(Materials.StainlessSteel),
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6),
                getModItem(Thaumcraft.ID, "ItemGolemPlacer", 1, 1),
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6),
                OrePrefixes.screw.get(Materials.StainlessSteel),
                OrePrefixes.ring.get(Materials.StainlessSteel));
        TCHelper.setResearchAspects(
                "TRAVELTRUNK",
                new AspectList().add(Aspect.getAspect("spiritus"), 12).add(Aspect.getAspect("vacuos"), 12)
                        .add(Aspect.getAspect("arbor"), 9).add(Aspect.getAspect("iter"), 6)
                        .add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("TRAVELTRUNK", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GOLEMFETTER",
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 9),
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("ordo"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                'b',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                'd',
                "plateThaumium",
                'e',
                "blockRedstone",
                'f',
                "plateThaumium",
                'g',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                'h',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                'i',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6));
        TCHelper.setResearchAspects(
                "GOLEMFETTER",
                new AspectList().add(Aspect.getAspect("vinculum"), 9).add(Aspect.getAspect("machina"), 9)
                        .add(Aspect.getAspect("cognitio"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("GOLEMFETTER", 2);
        ThaumcraftApi.addCrucibleRecipe(
                "GOLEMSTRAW",
                getModItem(Thaumcraft.ID, "ItemGolemPlacer", 1, 0),
                getModItem(Minecraft.ID, "hay_block", 1, 0),
                new AspectList().add(Aspect.getAspect("humanus"), 10).add(Aspect.getAspect("motus"), 10)
                        .add(Aspect.getAspect("spiritus"), 10));
        TCHelper.setResearchAspects(
                "GOLEMSTRAW",
                new AspectList().add(Aspect.getAspect("messis"), 9).add(Aspect.getAspect("permutatio"), 9)
                        .add(Aspect.getAspect("spiritus"), 9).add(Aspect.getAspect("motus"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("GOLEMSTRAW", 2);
        ThaumcraftApi.addCrucibleRecipe(
                "GOLEMWOOD",
                getModItem(Thaumcraft.ID, "ItemGolemPlacer", 1, 1),
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 0),
                new AspectList().add(Aspect.getAspect("humanus"), 14).add(Aspect.getAspect("motus"), 14)
                        .add(Aspect.getAspect("spiritus"), 14));
        TCHelper.setResearchAspects(
                "GOLEMWOOD",
                new AspectList().add(Aspect.getAspect("arbor"), 12).add(Aspect.getAspect("permutatio"), 12)
                        .add(Aspect.getAspect("spiritus"), 9).add(Aspect.getAspect("motus"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("GOLEMWOOD", 3);
        TCHelper.clearPages("GOLEMTALLOW");
        TCHelper.addResearchPage("GOLEMTALLOW", new ResearchPage("tc.research_page.GOLEMTALLOW.1"));
        ThaumcraftApi.addCrucibleRecipe(
                "GOLEMTALLOW",
                getModItem(Thaumcraft.ID, "ItemGolemPlacer", 1, 2),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 5),
                new AspectList().add(Aspect.getAspect("humanus"), 26).add(Aspect.getAspect("mortuus"), 26)
                        .add(Aspect.getAspect("spiritus"), 26));
        TCHelper.addResearchPage(
                "GOLEMTALLOW",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemGolemPlacer", 1, 2))));
        TCHelper.setResearchAspects(
                "GOLEMTALLOW",
                new AspectList().add(Aspect.getAspect("spiritus"), 12).add(Aspect.getAspect("permutatio"), 12)
                        .add(Aspect.getAspect("corpus"), 15).add(Aspect.getAspect("motus"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6));
        TCHelper.setResearchComplexity("GOLEMTALLOW", 3);
        ThaumcraftApi.addCrucibleRecipe(
                "GOLEMCLAY",
                getModItem(Thaumcraft.ID, "ItemGolemPlacer", 1, 3),
                getModItem(Minecraft.ID, "clay", 1, 0),
                new AspectList().add(Aspect.getAspect("humanus"), 20).add(Aspect.getAspect("motus"), 20)
                        .add(Aspect.getAspect("spiritus"), 20));
        TCHelper.setResearchAspects(
                "GOLEMCLAY",
                new AspectList().add(Aspect.getAspect("spiritus"), 12).add(Aspect.getAspect("permutatio"), 12)
                        .add(Aspect.getAspect("motus"), 12).add(Aspect.getAspect("terra"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("aqua"), 3));
        TCHelper.setResearchComplexity("GOLEMCLAY", 3);
        TCHelper.clearPages("GOLEMFLESH");
        TCHelper.addResearchPage("GOLEMFLESH", new ResearchPage("tc.research_page.GOLEMFLESH.1"));
        ThaumcraftApi.addCrucibleRecipe(
                "GOLEMFLESH",
                getModItem(Thaumcraft.ID, "ItemGolemPlacer", 1, 4),
                getModItem(Thaumcraft.ID, "blockTaint", 1, 2),
                new AspectList().add(Aspect.getAspect("humanus"), 20).add(Aspect.getAspect("motus"), 20)
                        .add(Aspect.getAspect("spiritus"), 20));
        TCHelper.addResearchPage(
                "GOLEMFLESH",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemGolemPlacer", 1, 4))));
        TCHelper.setResearchAspects(
                "GOLEMFLESH",
                new AspectList().add(Aspect.getAspect("corpus"), 12).add(Aspect.getAspect("permutatio"), 12)
                        .add(Aspect.getAspect("spiritus"), 12).add(Aspect.getAspect("motus"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("mortuus"), 3));
        TCHelper.setResearchComplexity("GOLEMFLESH", 3);
        ThaumcraftApi.addCrucibleRecipe(
                "GOLEMSTONE",
                getModItem(Thaumcraft.ID, "ItemGolemPlacer", 1, 5),
                getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 0),
                new AspectList().add(Aspect.getAspect("humanus"), 26).add(Aspect.getAspect("mortuus"), 26)
                        .add(Aspect.getAspect("spiritus"), 26));
        TCHelper.setResearchAspects(
                "GOLEMSTONE",
                new AspectList().add(Aspect.getAspect("spiritus"), 12).add(Aspect.getAspect("permutatio"), 12)
                        .add(Aspect.getAspect("motus"), 12).add(Aspect.getAspect("terra"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("perditio"), 3));
        TCHelper.setResearchComplexity("GOLEMSTONE", 3);
        ThaumcraftApi.addCrucibleRecipe(
                "GOLEMIRON",
                getModItem(Thaumcraft.ID, "ItemGolemPlacer", 1, 6),
                getModItem(Minecraft.ID, "iron_block", 1, 0),
                new AspectList().add(Aspect.getAspect("humanus"), 32).add(Aspect.getAspect("mortuus"), 32)
                        .add(Aspect.getAspect("spiritus"), 32));
        TCHelper.setResearchAspects(
                "GOLEMIRON",
                new AspectList().add(Aspect.getAspect("permutatio"), 12).add(Aspect.getAspect("spiritus"), 12)
                        .add(Aspect.getAspect("motus"), 12).add(Aspect.getAspect("metallum"), 9)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("terra"), 6)
                        .add(Aspect.getAspect("humanus"), 3));
        TCHelper.setResearchComplexity("GOLEMIRON", 3);
        TCHelper.clearPages("GOLEMTHAUMIUM");
        TCHelper.addResearchPage("GOLEMTHAUMIUM", new ResearchPage("tc.research_page.GOLEMTHAUMIUM.1"));
        ThaumcraftApi.addCrucibleRecipe(
                "GOLEMTHAUMIUM",
                getModItem(Thaumcraft.ID, "ItemGolemPlacer", 1, 7),
                "blockThaumium",
                new AspectList().add(Aspect.getAspect("humanus"), 40).add(Aspect.getAspect("mortuus"), 40)
                        .add(Aspect.getAspect("spiritus"), 40));
        TCHelper.addResearchPage(
                "GOLEMTHAUMIUM",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemGolemPlacer", 1, 7))));
        TCHelper.setResearchAspects(
                "GOLEMTHAUMIUM",
                new AspectList().add(Aspect.getAspect("permutatio"), 12).add(Aspect.getAspect("spiritus"), 12)
                        .add(Aspect.getAspect("metallum"), 12).add(Aspect.getAspect("motus"), 9)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("terra"), 9)
                        .add(Aspect.getAspect("humanus"), 6).add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("GOLEMTHAUMIUM", 3);
        TCHelper.setResearchAspects(
                "ADVANCEDGOLEM",
                new AspectList().add(Aspect.getAspect("sensus"), 15).add(Aspect.getAspect("victus"), 15)
                        .add(Aspect.getAspect("cognitio"), 12).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("alienis"), 9)
                        .add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("ADVANCEDGOLEM", 4);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "COREGATHER",
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 100),
                new AspectList().add(Aspect.getAspect("ordo"), 5).add(Aspect.getAspect("ignis"), 5)
                        .add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "plateThaumium",
                'b',
                "ingotBrickNether",
                'c',
                "plateThaumium",
                'd',
                "ingotBrick",
                'e',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1),
                'f',
                "ingotBrick",
                'g',
                "plateNetherQuartz",
                'h',
                "ingotBrickNether",
                'i',
                "plateNetherQuartz");
        ThaumcraftApi.addCrucibleRecipe(
                "COREGATHER",
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 2),
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 100),
                new AspectList().add(Aspect.getAspect("lucrum"), 10).add(Aspect.getAspect("terra"), 10));
        ThaumcraftApi.addCrucibleRecipe(
                "COREEMPTY",
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 1),
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 100),
                new AspectList().add(Aspect.getAspect("lucrum"), 10).add(Aspect.getAspect("vacuos"), 10));
        TCHelper.setResearchAspects(
                "COREEMPTY",
                new AspectList().add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("vacuos"), 9)
                        .add(Aspect.getAspect("permutatio"), 6).add(Aspect.getAspect("motus"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("COREEMPTY", 2);
        ThaumcraftApi.addCrucibleRecipe(
                "COREFILL",
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 0),
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 100),
                new AspectList().add(Aspect.getAspect("fames"), 10).add(Aspect.getAspect("vacuos"), 10));
        TCHelper.setResearchAspects(
                "COREFILL",
                new AspectList().add(Aspect.getAspect("fames"), 9).add(Aspect.getAspect("vacuos"), 9)
                        .add(Aspect.getAspect("permutatio"), 9).add(Aspect.getAspect("motus"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("COREFILL", 2);
        TCHelper.clearPages("COREHARVEST");
        TCHelper.addResearchPage("COREHARVEST", new ResearchPage("tc.research_page.COREHARVEST.1"));
        TCHelper.addInfusionCraftingRecipe(
                "COREHARVEST",
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 3),
                4,
                new AspectList().add(Aspect.getAspect("messis"), 10).add(Aspect.getAspect("meto"), 10)
                        .add(Aspect.getAspect("herba"), 20),
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 100),
                getModItem(Minecraft.ID, "nether_star", 1, 0),
                getModItem(Minecraft.ID, "wheat_seeds", 1, 0),
                getModItem(Thaumcraft.ID, "ItemHoeThaumium", 1, 0),
                OrePrefixes.plate.get(Materials.Gold));
        TCHelper.addResearchPage(
                "COREHARVEST",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 3))));
        TCHelper.addResearchPage("COREHARVEST", new ResearchPage("tc.research_page.COREHARVEST.2"));
        TCHelper.setResearchAspects(
                "COREHARVEST",
                new AspectList().add(Aspect.getAspect("meto"), 12).add(Aspect.getAspect("messis"), 12)
                        .add(Aspect.getAspect("iter"), 9).add(Aspect.getAspect("permutatio"), 9)
                        .add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("COREHARVEST", 3);
        TCHelper.clearPages("COREGUARD");
        TCHelper.addResearchPage("COREGUARD", new ResearchPage("tc.research_page.COREGUARD.1"));
        TCHelper.addInfusionCraftingRecipe(
                "COREGUARD",
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 4),
                4,
                new AspectList().add(Aspect.getAspect("telum"), 20).add(Aspect.getAspect("vinculum"), 20)
                        .add(Aspect.getAspect("tutamen"), 20),
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 100),
                getModItem(Minecraft.ID, "nether_star", 1, 0),
                OrePrefixes.plate.get(Materials.Obsidian),
                getModItem(Thaumcraft.ID, "ItemSwordThaumium", 1, 0),
                OrePrefixes.plate.get(Materials.Gold));
        TCHelper.addResearchPage(
                "COREGUARD",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 4))));
        TCHelper.addResearchPage("COREGUARD", new ResearchPage("tc.research_page.COREGUARD.2"));
        TCHelper.setResearchAspects(
                "COREGUARD",
                new AspectList().add(Aspect.getAspect("sensus"), 12).add(Aspect.getAspect("telum"), 12)
                        .add(Aspect.getAspect("vinculum"), 12).add(Aspect.getAspect("permutatio"), 9)
                        .add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("COREGUARD", 3);
        TCHelper.addInfusionCraftingRecipe(
                "COREUSE",
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 8),
                4,
                new AspectList().add(Aspect.getAspect("humanus"), 20).add(Aspect.getAspect("instrumentum"), 20)
                        .add(Aspect.getAspect("machina"), 20).add(Aspect.getAspect("lucrum"), 20),
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 1),
                getModItem(Minecraft.ID, "nether_star", 1, 0),
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26),
                getModItem(Minecraft.ID, "lever", 1, 0),
                getModItem(Minecraft.ID, "flint_and_steel", 1, wildcard),
                getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0),
                getModItem(Minecraft.ID, "shears", 1, 0));
        TCHelper.setResearchAspects(
                "COREUSE",
                new AspectList().add(Aspect.getAspect("humanus"), 12).add(Aspect.getAspect("instrumentum"), 12)
                        .add(Aspect.getAspect("machina"), 9).add(Aspect.getAspect("permutatio"), 9)
                        .add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("COREUSE", 3);
        TCHelper.addInfusionCraftingRecipe(
                "CORESORTING",
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 10),
                4,
                new AspectList().add(Aspect.getAspect("lucrum"), 20).add(Aspect.getAspect("fames"), 20)
                        .add(Aspect.getAspect("permutatio"), 20).add(Aspect.getAspect("vacuos"), 20),
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 100),
                getModItem(Minecraft.ID, "nether_star", 1, 0),
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 1),
                getModItem(Minecraft.ID, "paper", 1, 0),
                getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0),
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 0),
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26));
        TCHelper.setResearchAspects(
                "CORESORTING",
                new AspectList().add(Aspect.getAspect("fames"), 12).add(Aspect.getAspect("vacuos"), 12)
                        .add(Aspect.getAspect("lucrum"), 12).add(Aspect.getAspect("permutatio"), 9)
                        .add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("CORESORTING", 3);
        TCHelper.clearPages("CORELIQUID");
        TCHelper.addResearchPage("CORELIQUID", new ResearchPage("tc.research_page.CORELIQUID.1"));
        TCHelper.addInfusionCraftingRecipe(
                "CORELIQUID",
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 5),
                4,
                new AspectList().add(Aspect.getAspect("aqua"), 20).add(Aspect.getAspect("vacuos"), 20)
                        .add(Aspect.getAspect("metallum"), 20).add(Aspect.getAspect("iter"), 20),
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 0),
                getModItem(Minecraft.ID, "nether_star", 1, 0),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketFired", 1, 0),
                getModItem(Minecraft.ID, "bucket", 1, 0),
                getModItem(Forestry.ID, "canEmpty", 1, 0),
                Materials.Empty.getCells(1));
        TCHelper.addResearchPage(
                "CORELIQUID",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 5))));
        TCHelper.addResearchPage("CORELIQUID", new ResearchPage("tc.research_page.CORELIQUID.2"));
        TCHelper.setResearchAspects(
                "CORELIQUID",
                new AspectList().add(Aspect.getAspect("iter"), 12).add(Aspect.getAspect("aqua"), 12)
                        .add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("permutatio"), 9)
                        .add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("CORELIQUID", 3);
        TCHelper.addInfusionCraftingRecipe(
                "COREALCHEMY",
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 6),
                7,
                new AspectList().add(Aspect.getAspect("aqua"), 32).add(Aspect.getAspect("motus"), 32)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("permutatio"), 32),
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 5),
                getModItem(Minecraft.ID, "nether_star", 1, 0),
                getModItem(Minecraft.ID, "potion", 1, 0),
                getModItem(Thaumcraft.ID, "blockJar", 1, 0),
                getModItem(Thaumcraft.ID, "ItemEssence", 1, 0),
                getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0),
                getModItem(Minecraft.ID, "potion", 1, 0),
                getModItem(Thaumcraft.ID, "ItemEssence", 1, 0),
                getModItem(Thaumcraft.ID, "blockJar", 1, 0));
        TCHelper.setResearchAspects(
                "COREALCHEMY",
                new AspectList().add(Aspect.getAspect("potentia"), 12).add(Aspect.getAspect("aqua"), 12)
                        .add(Aspect.getAspect("iter"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("COREALCHEMY", 3);
        TCHelper.clearPages("COREBUTCHER");
        TCHelper.addResearchPage("COREBUTCHER", new ResearchPage("tc.research_page.COREBUTCHER.1"));
        TCHelper.addInfusionCraftingRecipe(
                "COREBUTCHER",
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 9),
                7,
                new AspectList().add(Aspect.getAspect("bestia"), 32).add(Aspect.getAspect("corpus"), 32)
                        .add(Aspect.getAspect("mortuus"), 32).add(Aspect.getAspect("telum"), 32),
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 3),
                getModItem(Minecraft.ID, "nether_star", 1, 0),
                MetaGeneratedTool01.INSTANCE.getToolWithStats(BUTCHERYKNIFE.ID, 1, null, null, null),
                getModItem(Minecraft.ID, "iron_sword", 1, 0),
                getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0),
                getModItem(Minecraft.ID, "bow", 1, 0),
                getModItem(Minecraft.ID, "arrow", 1, 0));
        TCHelper.addResearchPage(
                "COREBUTCHER",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 9))));
        TCHelper.setResearchAspects(
                "COREBUTCHER",
                new AspectList().add(Aspect.getAspect("meto"), 12).add(Aspect.getAspect("telum"), 12)
                        .add(Aspect.getAspect("bestia"), 9).add(Aspect.getAspect("sensus"), 12)
                        .add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("COREBUTCHER", 3);
        ThaumcraftApi.addWarpToResearch("COREBUTCHER", 2);
        TCHelper.addInfusionCraftingRecipe(
                "COREFISHING",
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 11),
                7,
                new AspectList().add(Aspect.getAspect("aqua"), 32).add(Aspect.getAspect("meto"), 20)
                        .add(Aspect.getAspect("bestia"), 32).add(Aspect.getAspect("fames"), 32),
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 3),
                getModItem(Minecraft.ID, "nether_star", 1, 0),
                getModItem(Minecraft.ID, "fish", 1, 0),
                getModItem(Minecraft.ID, "fish", 1, 2),
                getModItem(Minecraft.ID, "fish", 1, 3),
                getModItem(Minecraft.ID, "fishing_rod", 1, 0),
                MetaGeneratedTool01.INSTANCE.getToolWithStats(KNIFE.ID, 1, null, null, null));
        TCHelper.setResearchAspects(
                "COREFISHING",
                new AspectList().add(Aspect.getAspect("fames"), 12).add(Aspect.getAspect("aqua"), 12)
                        .add(Aspect.getAspect("bestia"), 12).add(Aspect.getAspect("meto"), 9)
                        .add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("COREFISHING", 3);
        TCHelper.addInfusionCraftingRecipe(
                "CORELUMBER",
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 7),
                7,
                new AspectList().add(Aspect.getAspect("arbor"), 32).add(Aspect.getAspect("instrumentum"), 32)
                        .add(Aspect.getAspect("meto"), 20).add(Aspect.getAspect("potentia"), 32),
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 3),
                getModItem(Minecraft.ID, "nether_star", 1, 0),
                getModItem(Thaumcraft.ID, "ItemAxeThaumium", 1, 0),
                getModItem(Thaumcraft.ID, "ItemAxeElemental", 1, 0),
                getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0),
                getModItem(Thaumcraft.ID, "ItemAxeThaumium", 1, 0));
        TCHelper.setResearchAspects(
                "CORELUMBER",
                new AspectList().add(Aspect.getAspect("potentia"), 12).add(Aspect.getAspect("arbor"), 12)
                        .add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("meto"), 12)
                        .add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("CORELUMBER", 3);

        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "GolemBell", 1, 0));
        TCHelper.clearPages("GOLEMBELL");
        TCHelper.addResearchPage("GOLEMBELL", new ResearchPage("tc.research_page.GOLEMBELL.1"));
        TCHelper.addResearchPage("GOLEMBELL", new ResearchPage("tc.research_page.GOLEMBELL.2"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GOLEMBELL",
                getModItem(Thaumcraft.ID, "GolemBell", 1, 0),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("aer"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "craftingToolScrewdriver",
                'b',
                "plateNetherQuartz",
                'c',
                "boltNetherQuartz",
                'd',
                "screwIron",
                'e',
                "plateNetherQuartz",
                'f',
                "plateNetherQuartz",
                'g',
                "stickWoodSealed",
                'h',
                "screwIron",
                'i',
                "craftingToolFile");
        TCHelper.addResearchPage(
                "GOLEMBELL",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "GolemBell", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "UPGRADEAIR",
                getModItem(Thaumcraft.ID, "ItemGolemUpgrade", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "nuggetGold",
                'b',
                getModItem(Thaumcraft.ID, "ItemNugget", 1, 5),
                'c',
                "nuggetGold",
                'd',
                "nuggetThaumium",
                'e',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                'f',
                "nuggetThaumium",
                'g',
                "nuggetGold",
                'h',
                getModItem(Thaumcraft.ID, "ItemNugget", 1, 5),
                'i',
                "nuggetGold");
        TCHelper.setResearchAspects(
                "UPGRADEAIR",
                new AspectList().add(Aspect.getAspect("motus"), 9).add(Aspect.getAspect("aer"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("UPGRADEAIR", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "UPGRADEEARTH",
                getModItem(Thaumcraft.ID, "ItemGolemUpgrade", 1, 1),
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "nuggetGold",
                'b',
                getModItem(Thaumcraft.ID, "ItemNugget", 1, 5),
                'c',
                "nuggetGold",
                'd',
                "nuggetThaumium",
                'e',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                'f',
                "nuggetThaumium",
                'g',
                "nuggetGold",
                'h',
                getModItem(Thaumcraft.ID, "ItemNugget", 1, 5),
                'i',
                "nuggetGold");
        TCHelper.setResearchAspects(
                "UPGRADEEARTH",
                new AspectList().add(Aspect.getAspect("victus"), 9).add(Aspect.getAspect("terra"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("UPGRADEEARTH", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "UPGRADEFIRE",
                getModItem(Thaumcraft.ID, "ItemGolemUpgrade", 1, 2),
                new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "nuggetGold",
                'b',
                getModItem(Thaumcraft.ID, "ItemNugget", 1, 5),
                'c',
                "nuggetGold",
                'd',
                "nuggetThaumium",
                'e',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                'f',
                "nuggetThaumium",
                'g',
                "nuggetGold",
                'h',
                getModItem(Thaumcraft.ID, "ItemNugget", 1, 5),
                'i',
                "nuggetGold");
        TCHelper.setResearchAspects(
                "UPGRADEFIRE",
                new AspectList().add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("ignis"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("UPGRADEFIRE", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "UPGRADEWATER",
                getModItem(Thaumcraft.ID, "ItemGolemUpgrade", 1, 3),
                new AspectList().add(Aspect.getAspect("aqua"), 15).add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "nuggetGold",
                'b',
                getModItem(Thaumcraft.ID, "ItemNugget", 1, 5),
                'c',
                "nuggetGold",
                'd',
                "nuggetThaumium",
                'e',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                'f',
                "nuggetThaumium",
                'g',
                "nuggetGold",
                'h',
                getModItem(Thaumcraft.ID, "ItemNugget", 1, 5),
                'i',
                "nuggetGold");
        TCHelper.setResearchAspects(
                "UPGRADEWATER",
                new AspectList().add(Aspect.getAspect("sensus"), 9).add(Aspect.getAspect("aqua"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("UPGRADEWATER", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "UPGRADEORDER",
                getModItem(Thaumcraft.ID, "ItemGolemUpgrade", 1, 4),
                new AspectList().add(Aspect.getAspect("ordo"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "nuggetGold",
                'b',
                getModItem(Thaumcraft.ID, "ItemNugget", 1, 5),
                'c',
                "nuggetGold",
                'd',
                "nuggetThaumium",
                'e',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                'f',
                "nuggetThaumium",
                'g',
                "nuggetGold",
                'h',
                getModItem(Thaumcraft.ID, "ItemNugget", 1, 5),
                'i',
                "nuggetGold");
        TCHelper.setResearchAspects(
                "UPGRADEORDER",
                new AspectList().add(Aspect.getAspect("cognitio"), 6).add(Aspect.getAspect("ordo"), 9)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("UPGRADEORDER", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "UPGRADEENTROPY",
                getModItem(Thaumcraft.ID, "ItemGolemUpgrade", 1, 5),
                new AspectList().add(Aspect.getAspect("perditio"), 15).add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "nuggetGold",
                'b',
                getModItem(Thaumcraft.ID, "ItemNugget", 1, 5),
                'c',
                "nuggetGold",
                'd',
                "nuggetThaumium",
                'e',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                'f',
                "nuggetThaumium",
                'g',
                "nuggetGold",
                'h',
                getModItem(Thaumcraft.ID, "ItemNugget", 1, 5),
                'i',
                "nuggetGold");
        TCHelper.setResearchAspects(
                "UPGRADEENTROPY",
                new AspectList().add(Aspect.getAspect("cognitio"), 6).add(Aspect.getAspect("perditio"), 9)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("UPGRADEENTROPY", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TINYHAT",
                getModItem(Thaumcraft.ID, "ItemGolemDecoration", 1, 0),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("ignis"), 10)
                        .add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                "blockWoolBlack",
                'd',
                "foilGold",
                'e',
                "foilGold",
                'f',
                "foilGold",
                'g',
                "blockWoolBlack",
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'i',
                "blockWoolBlack");
        TCHelper.setResearchAspects(
                "TINYHAT",
                new AspectList().add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("pannus"), 9)
                        .add(Aspect.getAspect("victus"), 6).add(Aspect.getAspect("sano"), 3));
        TCHelper.setResearchComplexity("TINYHAT", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TINYGLASSES",
                getModItem(Thaumcraft.ID, "ItemGolemDecoration", 1, 1),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "stickIron",
                'c',
                "stickIron",
                'd',
                "screwIron",
                'e',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'f',
                "screwIron",
                'g',
                "lensGlass",
                'h',
                "boltIron",
                'i',
                "lensGlass");
        TCHelper.setResearchAspects(
                "TINYGLASSES",
                new AspectList().add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("pannus"), 6)
                        .add(Aspect.getAspect("sensus"), 6).add(Aspect.getAspect("ordo"), 3));
        TCHelper.setResearchComplexity("TINYGLASSES", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TINYBOWTIE",
                getModItem(Thaumcraft.ID, "ItemGolemDecoration", 1, 2),
                new AspectList().add(Aspect.getAspect("ordo"), 5).add(Aspect.getAspect("aer"), 5)
                        .add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'd',
                "blockWoolBlack",
                'e',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'f',
                "blockWoolBlack",
                'g',
                "blockWoolBlack",
                'i',
                "blockWoolBlack");
        TCHelper.setResearchAspects(
                "TINYBOWTIE",
                new AspectList().add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("pannus"), 9)
                        .add(Aspect.getAspect("iter"), 6).add(Aspect.getAspect("potentia"), 3));
        TCHelper.setResearchComplexity("TINYBOWTIE", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TINYFEZ",
                getModItem(Thaumcraft.ID, "ItemGolemDecoration", 1, 3),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "blockWoolRed",
                'b',
                "blockWoolRed",
                'c',
                getModItem(Minecraft.ID, "string", 1, 0),
                'd',
                "blockWoolRed",
                'e',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'f',
                getModItem(Minecraft.ID, "string", 1, 0),
                'g',
                "blockWoolRed",
                'h',
                "blockWoolRed",
                'i',
                getModItem(Minecraft.ID, "string", 1, 0));
        TCHelper.setResearchAspects(
                "TINYFEZ",
                new AspectList().add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("pannus"), 9)
                        .add(Aspect.getAspect("potentia"), 6).add(Aspect.getAspect("sano"), 3));
        TCHelper.setResearchComplexity("TINYFEZ", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TINYDART",
                getModItem(Thaumcraft.ID, "ItemGolemDecoration", 1, 4),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("ignis"), 5)
                        .add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Minecraft.ID, "arrow", 1, 0),
                'b',
                "springSmallSteel",
                'c',
                getModItem(Minecraft.ID, "arrow", 1, 0),
                'd',
                getModItem(Minecraft.ID, "arrow", 1, 0),
                'e',
                getModItem(Minecraft.ID, "dropper", 1, 0),
                'f',
                getModItem(Minecraft.ID, "arrow", 1, 0),
                'g',
                getModItem(Minecraft.ID, "arrow", 1, 0),
                'h',
                "springSmallSteel",
                'i',
                getModItem(Minecraft.ID, "arrow", 1, 0));
        TCHelper.setResearchAspects(
                "TINYDART",
                new AspectList().add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("volatus"), 9)
                        .add(Aspect.getAspect("telum"), 6).add(Aspect.getAspect("potentia"), 3));
        TCHelper.setResearchComplexity("TINYDART", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TINYVISOR",
                getModItem(Thaumcraft.ID, "ItemGolemDecoration", 1, 5),
                new AspectList().add(Aspect.getAspect("aqua"), 5).add(Aspect.getAspect("ignis"), 5)
                        .add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                NHItemList.SteelBars.get(),
                'b',
                getModItem(Minecraft.ID, "iron_helmet", 1, 0),
                'c',
                NHItemList.SteelBars.get(),
                'd',
                "plateSteel",
                'e',
                "plateSteel",
                'f',
                "plateSteel");
        TCHelper.setResearchAspects(
                "TINYVISOR",
                new AspectList().add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("sensus"), 9)
                        .add(Aspect.getAspect("tutamen"), 6).add(Aspect.getAspect("cognitio"), 3));
        TCHelper.setResearchComplexity("TINYVISOR", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TINYARMOR",
                getModItem(Thaumcraft.ID, "ItemGolemDecoration", 1, 6),
                new AspectList().add(Aspect.getAspect("ordo"), 5).add(Aspect.getAspect("ignis"), 5)
                        .add(Aspect.getAspect("terra"), 10),
                "abc",
                "def",
                "ghi",
                'd',
                "plateSteel",
                'e',
                getModItem(Minecraft.ID, "iron_chestplate", 1, 0),
                'f',
                "plateSteel",
                'g',
                "plateSteel",
                'h',
                "plateSteel",
                'i',
                "plateSteel");
        TCHelper.setResearchAspects(
                "TINYARMOR",
                new AspectList().add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("metallum"), 9)
                        .add(Aspect.getAspect("tutamen"), 6).add(Aspect.getAspect("cognitio"), 3));
        TCHelper.setResearchComplexity("TINYARMOR", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TINYHAMMER",
                getModItem(Thaumcraft.ID, "ItemGolemDecoration", 1, 7),
                new AspectList().add(Aspect.getAspect("ordo"), 5).add(Aspect.getAspect("ignis"), 5)
                        .add(Aspect.getAspect("terra"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "plateSteel",
                'b',
                "plateSteel",
                'c',
                "plateSteel",
                'd',
                "plateSteel",
                'e',
                "plateSteel",
                'f',
                "plateSteel",
                'h',
                "stickWood");
        TCHelper.setResearchAspects(
                "TINYHAMMER",
                new AspectList().add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("metallum"), 9)
                        .add(Aspect.getAspect("telum"), 6).add(Aspect.getAspect("vinculum"), 3));
        TCHelper.setResearchComplexity("TINYHAMMER", 2);
        TCHelper.refreshResearchPages("HUNGRYCHEST");
        TCHelper.refreshResearchPages("TRAVELTRUNK");
        TCHelper.refreshResearchPages("GOLEMFETTER");
        TCHelper.refreshResearchPages("GOLEMSTRAW");
        TCHelper.refreshResearchPages("GOLEMWOOD");
        TCHelper.refreshResearchPages("GOLEMTALLOW");
        TCHelper.refreshResearchPages("GOLEMCLAY");
        TCHelper.refreshResearchPages("GOLEMFLESH");
        TCHelper.refreshResearchPages("GOLEMSTONE");
        TCHelper.refreshResearchPages("GOLEMIRON");
        TCHelper.refreshResearchPages("GOLEMTHAUMIUM");
        TCHelper.refreshResearchPages("ADVANCEDGOLEM");
        TCHelper.refreshResearchPages("COREGATHER");
        TCHelper.refreshResearchPages("COREEMPTY");
        TCHelper.refreshResearchPages("COREFILL");
        TCHelper.refreshResearchPages("COREHARVEST");
        TCHelper.refreshResearchPages("COREGUARD");
        TCHelper.refreshResearchPages("COREUSE");
        TCHelper.refreshResearchPages("CORESORTING");
        TCHelper.refreshResearchPages("CORELIQUID");
        TCHelper.refreshResearchPages("COREALCHEMY");
        TCHelper.refreshResearchPages("COREBUTCHER");
        TCHelper.refreshResearchPages("COREFISHING");
        TCHelper.refreshResearchPages("CORELUMBER");
        TCHelper.refreshResearchPages("GOLEMBELL");
        TCHelper.refreshResearchPages("UPGRADEAIR");
        TCHelper.refreshResearchPages("UPGRADEEARTH");
        TCHelper.refreshResearchPages("UPGRADEFIRE");
        TCHelper.refreshResearchPages("UPGRADEWATER");
        TCHelper.refreshResearchPages("UPGRADEORDER");
        TCHelper.refreshResearchPages("UPGRADEENTROPY");
        TCHelper.refreshResearchPages("TINYHAT");
        TCHelper.refreshResearchPages("TINYGLASSES");
        TCHelper.refreshResearchPages("TINYBOWTIE");
        TCHelper.refreshResearchPages("TINYFEZ");
        TCHelper.refreshResearchPages("TINYDART");
        TCHelper.refreshResearchPages("TINYVISOR");
        TCHelper.refreshResearchPages("TINYARMOR");
        TCHelper.refreshResearchPages("TINYHAMMER");
    }

    private void eldritch() {
        // ELDRITCH

        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "WandRod", 1, 100));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "blockEssentiaReservoir", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "FocusPrimal", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemHelmetVoidFortress", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemChestplateVoidFortress", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemLeggingsVoidFortress", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemSanityChecker", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemPrimalCrusher", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockMetalDevice", 4, 3));
        TCHelper.clearPages("ELDRITCHMINOR");
        TCHelper.addResearchPage("ELDRITCHMINOR", new ResearchPage("tc.research_page.ELDRITCHMINOR.1"));
        ThaumcraftApi.addCrucibleRecipe(
                "ELDRITCHMINOR",
                getModItem(Thaumcraft.ID, "ItemResource", 1, 17),
                "listAllseed",
                new AspectList().add(Aspect.getAspect("alienis"), 8).add(Aspect.getAspect("tenebrae"), 8)
                        .add(Aspect.getAspect("vacuos"), 8));
        TCHelper.addResearchPage(
                "ELDRITCHMINOR",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemResource", 1, 17))));
        TCHelper.clearPages("VOIDMETAL");
        TCHelper.addResearchPage("VOIDMETAL", new ResearchPage("tc.research_page.VOIDMETAL.1"));
        ThaumcraftApi.addCrucibleRecipe(
                "VOIDMETAL",
                getModItem(Thaumcraft.ID, "ItemResource", 1, 16),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 17),
                new AspectList().add(Aspect.getAspect("metallum"), 16));
        TCHelper.addResearchPage(
                "VOIDMETAL",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(Thaumcraft.ID, "ItemResource", 1, 16))));
        TCHelper.addResearchPage("VOIDMETAL", new ResearchPage("tc.research_page.VOIDMETAL.2"));
        TCHelper.setResearchAspects(
                "VOIDMETAL",
                new AspectList().add(Aspect.getAspect("vacuos"), 12).add(Aspect.getAspect("metallum"), 12)
                        .add(Aspect.getAspect("tenebrae"), 9).add(Aspect.getAspect("alienis"), 9)
                        .add(Aspect.getAspect("gelum"), 6).add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("VOIDMETAL", 3);
        ThaumcraftApi.addWarpToResearch("VOIDMETAL", 1);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VOIDMETAL",
                getModItem(Thaumcraft.ID, "ItemAxeVoid", 1, 0),
                new AspectList().add(Aspect.getAspect("perditio"), 30).add(Aspect.getAspect("terra"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                "plateVoid",
                'b',
                "ingotVoid",
                'c',
                "craftingToolHardHammer",
                'd',
                "plateVoid",
                'e',
                "stickWood",
                'g',
                "craftingToolFile",
                'h',
                "stickVoid");
        TCHelper.addResearchPage(
                "VOIDMETAL",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemAxeVoid", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VOIDMETAL",
                getModItem(Thaumcraft.ID, "ItemSwordVoid", 1, 0),
                new AspectList().add(Aspect.getAspect("perditio"), 30).add(Aspect.getAspect("terra"), 15),
                "abc",
                "def",
                "ghi",
                'b',
                "plateVoid",
                'd',
                "craftingToolFile",
                'e',
                "plateVoid",
                'f',
                "craftingToolHardHammer",
                'h',
                "stickVoid");
        TCHelper.addResearchPage(
                "VOIDMETAL",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemSwordVoid", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VOIDMETAL",
                getModItem(Thaumcraft.ID, "ItemPickVoid", 1, 0),
                new AspectList().add(Aspect.getAspect("perditio"), 30).add(Aspect.getAspect("terra"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                "plateVoid",
                'b',
                "ingotVoid",
                'c',
                "ingotVoid",
                'd',
                "craftingToolFile",
                'e',
                "stickWood",
                'f',
                "craftingToolHardHammer",
                'h',
                "stickVoid");
        TCHelper.addResearchPage(
                "VOIDMETAL",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemPickVoid", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VOIDMETAL",
                getModItem(Thaumcraft.ID, "ItemShovelVoid", 1, 0),
                new AspectList().add(Aspect.getAspect("perditio"), 30).add(Aspect.getAspect("terra"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                "craftingToolFile",
                'b',
                "ingotVoid",
                'c',
                "craftingToolHardHammer",
                'e',
                "stickWood",
                'h',
                "stickVoid");
        TCHelper.addResearchPage(
                "VOIDMETAL",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemShovelVoid", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VOIDMETAL",
                getModItem(Thaumcraft.ID, "ItemHoeVoid", 1, 0),
                new AspectList().add(Aspect.getAspect("perditio"), 30).add(Aspect.getAspect("terra"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                "plateVoid",
                'b',
                "ingotVoid",
                'c',
                "craftingToolHardHammer",
                'd',
                "craftingToolFile",
                'e',
                "stickWood",
                'h',
                "stickVoid");
        TCHelper.addResearchPage(
                "VOIDMETAL",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemHoeVoid", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VOIDMETAL",
                getModItem(Thaumcraft.ID, "ItemHelmetVoid", 1, 0),
                new AspectList().add(Aspect.getAspect("perditio"), 40).add(Aspect.getAspect("terra"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "plateVoid",
                'b',
                "plateVoid",
                'c',
                "plateVoid",
                'd',
                "plateVoid",
                'e',
                "craftingToolHardHammer",
                'f',
                "plateVoid");
        TCHelper.addResearchPage(
                "VOIDMETAL",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemHelmetVoid", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VOIDMETAL",
                getModItem(Thaumcraft.ID, "ItemChestplateVoid", 1, 0),
                new AspectList().add(Aspect.getAspect("perditio"), 40).add(Aspect.getAspect("terra"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "plateVoid",
                'b',
                "craftingToolHardHammer",
                'c',
                "plateVoid",
                'd',
                "plateVoid",
                'e',
                "plateVoid",
                'f',
                "plateVoid",
                'g',
                "plateVoid",
                'h',
                "plateVoid",
                'i',
                "plateVoid");
        TCHelper.addResearchPage(
                "VOIDMETAL",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemChestplateVoid", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VOIDMETAL",
                getModItem(Thaumcraft.ID, "ItemLeggingsVoid", 1, 0),
                new AspectList().add(Aspect.getAspect("perditio"), 40).add(Aspect.getAspect("terra"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "plateVoid",
                'b',
                "plateVoid",
                'c',
                "plateVoid",
                'd',
                "plateVoid",
                'e',
                "craftingToolHardHammer",
                'f',
                "plateVoid",
                'g',
                "plateVoid",
                'i',
                "plateVoid");
        TCHelper.addResearchPage(
                "VOIDMETAL",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemLeggingsVoid", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VOIDMETAL",
                getModItem(Thaumcraft.ID, "ItemBootsVoid", 1, 0),
                new AspectList().add(Aspect.getAspect("perditio"), 40).add(Aspect.getAspect("terra"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "plateVoid",
                'c',
                "plateVoid",
                'd',
                "plateVoid",
                'e',
                "craftingToolHardHammer",
                'f',
                "plateVoid");
        TCHelper.addResearchPage(
                "VOIDMETAL",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemBootsVoid", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VOIDMETAL",
                getModItem(ThaumicBases.ID, "voidFAS", 1, 0),
                new AspectList().add(Aspect.getAspect("perditio"), 40).add(Aspect.getAspect("terra"), 20),
                "abc",
                "def",
                "ghi",
                'b',
                "plateVoid",
                'e',
                getModItem(Minecraft.ID, "flint_and_steel", 1, 0),
                'h',
                "plateVoid");
        TCHelper.addResearchPage(
                "VOIDMETAL",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicBases.ID, "voidFAS", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VOIDMETAL",
                getModItem(ThaumicBases.ID, "voidShears", 1, 0),
                new AspectList().add(Aspect.getAspect("perditio"), 40).add(Aspect.getAspect("terra"), 20),
                "abc",
                "def",
                "ghi",
                'b',
                "plateVoid",
                'd',
                "plateVoid",
                'e',
                getModItem(Minecraft.ID, "shears", 1, 0),
                'f',
                "plateVoid",
                'h',
                "plateVoid");
        TCHelper.addResearchPage(
                "VOIDMETAL",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicBases.ID, "voidShears", 1, 0))));
        TCHelper.clearPages("CAP_void");
        TCHelper.addResearchPage("CAP_void", new ResearchPage("tc.research_page.CAP_void.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CAP_void",
                getModItem(Thaumcraft.ID, "WandCap", 1, 8),
                new AspectList().add(Aspect.getAspect("ordo"), 40).add(Aspect.getAspect("ignis"), 40)
                        .add(Aspect.getAspect("aer"), 40).add(Aspect.getAspect("perditio"), 40),
                "abc",
                "def",
                "ghi",
                'a',
                "screwTungstenSteel",
                'b',
                "foilVoid",
                'c',
                "screwTungstenSteel",
                'd',
                "foilVoid",
                'e',
                "ringVoid",
                'f',
                "foilVoid",
                'g',
                "screwTungstenSteel",
                'h',
                "foilVoid",
                'i',
                "screwTungstenSteel");
        TCHelper.addResearchPage(
                "CAP_void",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "WandCap", 1, 8))));
        TCHelper.addInfusionCraftingRecipe(
                "CAP_void",
                getModItem(Thaumcraft.ID, "WandCap", 1, 7),
                8,
                new AspectList().add(Aspect.getAspect("alienis"), 32).add(Aspect.getAspect("auram"), 32)
                        .add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("vacuos"), 32),
                getModItem(Thaumcraft.ID, "WandCap", 1, 8),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 17),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 17),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 17));
        TCHelper.addResearchPage(
                "CAP_void",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Thaumcraft.ID, "WandCap", 1, 7))));
        TCHelper.setResearchAspects(
                "CAP_void",
                new AspectList().add(Aspect.getAspect("auram"), 12).add(Aspect.getAspect("vacuos"), 12)
                        .add(Aspect.getAspect("alienis"), 9).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("instrumentum"), 6).add(Aspect.getAspect("terra"), 6)
                        .add(Aspect.getAspect("tenebrae"), 3));
        TCHelper.setResearchComplexity("CAP_void", 3);
        TCHelper.addInfusionCraftingRecipe(
                "ESSENTIARESERVOIR",
                getModItem(Thaumcraft.ID, "blockEssentiaReservoir", 1, 0),
                8,
                new AspectList().add(Aspect.getAspect("aqua"), 16).add(Aspect.getAspect("permutatio"), 16)
                        .add(Aspect.getAspect("praecantatio"), 16).add(Aspect.getAspect("vacuos"), 16),
                getModItem(Thaumcraft.ID, "blockTube", 1, 4),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(Thaumcraft.ID, "blockJar", 1, 0),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(Thaumcraft.ID, "blockJar", 1, 0),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(Thaumcraft.ID, "blockJar", 1, 0),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(Thaumcraft.ID, "blockJar", 1, 0));
        TCHelper.setResearchAspects(
                "ESSENTIARESERVOIR",
                new AspectList().add(Aspect.getAspect("aqua"), 12).add(Aspect.getAspect("permutatio"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("vacuos"), 9)
                        .add(Aspect.getAspect("alienis"), 6).add(Aspect.getAspect("tenebrae"), 3));
        TCHelper.setResearchComplexity("ESSENTIARESERVOIR", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FOCUSPRIMAL",
                getModItem(Thaumcraft.ID, "FocusPrimal", 1, 0),
                new AspectList().add(Aspect.getAspect("aqua"), 75).add(Aspect.getAspect("terra"), 75)
                        .add(Aspect.getAspect("ignis"), 75).add(Aspect.getAspect("aer"), 75)
                        .add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("perditio"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                "gemExquisiteDiamond",
                'b',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                'c',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                'd',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                'e',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                'f',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                'g',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                'h',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                'i',
                "gemExquisiteDiamond");
        TCHelper.setResearchAspects(
                "FOCUSPRIMAL",
                new AspectList().add(Aspect.getAspect("aqua"), 12).add(Aspect.getAspect("ignis"), 12)
                        .add(Aspect.getAspect("aer"), 12).add(Aspect.getAspect("terra"), 9)
                        .add(Aspect.getAspect("ordo"), 9).add(Aspect.getAspect("perditio"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("FOCUSPRIMAL", 4);
        TCHelper.addInfusionCraftingRecipe(
                "ROD_primal_staff",
                getModItem(Thaumcraft.ID, "WandRod", 1, 100),
                10,
                new AspectList().add(Aspect.getAspect("aer"), 64).add(Aspect.getAspect("aqua"), 64)
                        .add(Aspect.getAspect("terra"), 64).add(Aspect.getAspect("ignis"), 64)
                        .add(Aspect.getAspect("ordo"), 64).add(Aspect.getAspect("perditio"), 64)
                        .add(Aspect.getAspect("praecantatio"), 128),
                getModItem(Thaumcraft.ID, "WandRod", 1, 2),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                getModItem(Thaumcraft.ID, "WandRod", 1, 1),
                getModItem(Thaumcraft.ID, "WandRod", 1, 3),
                getModItem(Thaumcraft.ID, "WandRod", 1, 4),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                getModItem(Thaumcraft.ID, "WandRod", 1, 5),
                getModItem(Thaumcraft.ID, "WandRod", 1, 6),
                getModItem(Thaumcraft.ID, "WandRod", 1, 7));
        TCHelper.setResearchAspects(
                "ROD_primal_staff",
                new AspectList().add(Aspect.getAspect("aqua"), 15).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("aer"), 12).add(Aspect.getAspect("terra"), 12)
                        .add(Aspect.getAspect("ordo"), 12).add(Aspect.getAspect("perditio"), 9)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("instrumentum"), 6)
                        .add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("ROD_primal_staff", 4);
        TCHelper.addInfusionCraftingRecipe(
                "ARMORVOIDFORTRESS",
                getModItem(Thaumcraft.ID, "ItemHelmetVoidFortress", 1, 0),
                8,
                new AspectList().add(Aspect.getAspect("alienis"), 24).add(Aspect.getAspect("metallum"), 24)
                        .add(Aspect.getAspect("pannus"), 24).add(Aspect.getAspect("sensus"), 24)
                        .add(Aspect.getAspect("tutamen"), 24).add(Aspect.getAspect("vacuos"), 24)
                        .add(Aspect.getAspect("praecantatio"), 24),
                getModItem(Thaumcraft.ID, "ItemHelmetVoid", 1, 0),
                getModItem(Thaumcraft.ID, "ItemGoggles", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                OrePrefixes.plate.get(Materials.Thaumium),
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7));
        TCHelper.setResearchAspects(
                "ARMORVOIDFORTRESS",
                new AspectList().add(Aspect.getAspect("vacuos"), 15).add(Aspect.getAspect("tenebrae"), 15)
                        .add(Aspect.getAspect("tutamen"), 12).add(Aspect.getAspect("pannus"), 12)
                        .add(Aspect.getAspect("alienis"), 9).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("sensus"), 6).add(Aspect.getAspect("metallum"), 3));
        TCHelper.setResearchComplexity("ARMORVOIDFORTRESS", 4);
        TCHelper.addInfusionCraftingRecipe(
                "ARMORVOIDFORTRESS",
                getModItem(Thaumcraft.ID, "ItemChestplateVoidFortress", 1, 0),
                8,
                new AspectList().add(Aspect.getAspect("alienis"), 32).add(Aspect.getAspect("metallum"), 32)
                        .add(Aspect.getAspect("pannus"), 32).add(Aspect.getAspect("sensus"), 32)
                        .add(Aspect.getAspect("tutamen"), 32).add(Aspect.getAspect("vacuos"), 32)
                        .add(Aspect.getAspect("praecantatio"), 32),
                getModItem(Thaumcraft.ID, "ItemChestplateVoid", 1, 0),
                getModItem(Thaumcraft.ID, "ItemChestplateRobe", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                OrePrefixes.plate.get(Materials.Thaumium),
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7));
        TCHelper.addInfusionCraftingRecipe(
                "ARMORVOIDFORTRESS",
                getModItem(Thaumcraft.ID, "ItemLeggingsVoidFortress", 1, 0),
                8,
                new AspectList().add(Aspect.getAspect("alienis"), 28).add(Aspect.getAspect("metallum"), 28)
                        .add(Aspect.getAspect("pannus"), 28).add(Aspect.getAspect("sensus"), 28)
                        .add(Aspect.getAspect("tutamen"), 28).add(Aspect.getAspect("vacuos"), 28)
                        .add(Aspect.getAspect("praecantatio"), 28),
                getModItem(Thaumcraft.ID, "ItemLeggingsVoid", 1, 0),
                getModItem(Thaumcraft.ID, "ItemLeggingsRobe", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                OrePrefixes.plate.get(Materials.Thaumium),
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7));
        TCHelper.addInfusionCraftingRecipe(
                "SANITYCHECK",
                getModItem(Thaumcraft.ID, "ItemSanityChecker", 1, 0),
                5,
                new AspectList().add(Aspect.getAspect("alienis"), 16).add(Aspect.getAspect("cognitio"), 32)
                        .add(Aspect.getAspect("sensus"), 24).add(Aspect.getAspect("sano"), 16),
                getModItem(Thaumcraft.ID, "ItemThaumometer", 1, 0),
                getModItem(Thaumcraft.ID, "blockMirror", 1, 0),
                OrePrefixes.screw.get(Materials.Thaumium),
                getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0),
                OrePrefixes.screw.get(Materials.Thaumium),
                OrePrefixes.gemFlawless.get(Materials.Diamond),
                OrePrefixes.screw.get(Materials.Thaumium),
                getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0),
                OrePrefixes.screw.get(Materials.Thaumium));
        TCHelper.setResearchAspects(
                "SANITYCHECK",
                new AspectList().add(Aspect.getAspect("sensus"), 12).add(Aspect.getAspect("cognitio"), 12)
                        .add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("sano"), 6).add(Aspect.getAspect("victus"), 3));
        TCHelper.setResearchComplexity("SANITYCHECK", 3);
        TCHelper.addInfusionCraftingRecipe(
                "OCULUS",
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0),
                7,
                new AspectList().add(Aspect.getAspect("alienis"), 64).add(Aspect.getAspect("iter"), 32)
                        .add(Aspect.getAspect("tenebrae"), 32).add(Aspect.getAspect("vacuos"), 32),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 45),
                getModItem(Minecraft.ID, "ender_eye", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 17),
                OrePrefixes.plate.get(Materials.Gold),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 17),
                getModItem(Minecraft.ID, "ender_eye", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 17),
                OrePrefixes.plate.get(Materials.Gold),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 17));
        TCHelper.setResearchAspects(
                "OCULUS",
                new AspectList().add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("cognitio"), 12)
                        .add(Aspect.getAspect("tenebrae"), 9).add(Aspect.getAspect("iter"), 9)
                        .add(Aspect.getAspect("permutatio"), 9).add(Aspect.getAspect("vitium"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("OCULUS", 3);
        TCHelper.addInfusionCraftingRecipe(
                "PRIMALCRUSHER",
                getModItem(Thaumcraft.ID, "ItemPrimalCrusher", 1, 0),
                10,
                new AspectList().add(Aspect.getAspect("alienis"), 24).add(Aspect.getAspect("instrumentum"), 24)
                        .add(Aspect.getAspect("lucrum"), 24).add(Aspect.getAspect("perditio"), 24)
                        .add(Aspect.getAspect("perfodio"), 24).add(Aspect.getAspect("telum"), 24)
                        .add(Aspect.getAspect("vacuos"), 24),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 3),
                getModItem(Thaumcraft.ID, "ItemPickVoid", 1, 0),
                getModItem(Thaumcraft.ID, "ItemShovelVoid", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                getModItem(Thaumcraft.ID, "ItemPickaxeElemental", 1, 0),
                getModItem(Thaumcraft.ID, "ItemShovelElemental", 1, 0));
        TCHelper.setResearchAspects(
                "PRIMALCRUSHER",
                new AspectList().add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("alienis"), 12)
                        .add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("lucrum"), 9)
                        .add(Aspect.getAspect("perditio"), 9).add(Aspect.getAspect("perfodio"), 9)
                        .add(Aspect.getAspect("telum"), 6).add(Aspect.getAspect("vacuos"), 3));
        TCHelper.setResearchComplexity("PRIMALCRUSHER", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ADVALCHEMYFURNACE",
                getModItem(Thaumcraft.ID, "blockMetalDevice", 4, 3),
                new AspectList().add(Aspect.getAspect("aqua"), 32).add(Aspect.getAspect("terra"), 32)
                        .add(Aspect.getAspect("aer"), 32).add(Aspect.getAspect("ordo"), 32),
                "abc",
                "def",
                "ghi",
                'a',
                "plateVoid",
                'b',
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 9),
                'c',
                "plateVoid",
                'd',
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 9),
                'e',
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 3),
                'f',
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 9),
                'g',
                "plateVoid",
                'h',
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 9),
                'i',
                "plateVoid");
        TCHelper.setResearchAspects(
                "ADVALCHEMYFURNACE",
                new AspectList().add(Aspect.getAspect("perditio"), 12).add(Aspect.getAspect("auram"), 12)
                        .add(Aspect.getAspect("aer"), 9).add(Aspect.getAspect("ordo"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("ADVALCHEMYFURNACE", 3);
        new ResearchItem(
                "CRIMSONRITES",
                "ELDRITCH",
                new AspectList().add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("cognitio"), 3).add(Aspect.getAspect("spiritus"), 12)
                        .add(Aspect.getAspect("vacuos"), 9).add(Aspect.getAspect("infernus"), 2)
                        .add(Aspect.getAspect("vitium"), 5),
                -3,
                -3,
                5,
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 1)).setParents("ELDRITCHMAJOR").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.CRIMSONRITES")).registerResearchItem();
        ThaumcraftApi.addWarpToResearch("CRIMSONRITES", 10);
        TCHelper.addInfusionCraftingRecipe(
                "CRIMSONRITES",
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 1),
                10,
                new AspectList().add(Aspect.getAspect("alienis"), 32).add(Aspect.getAspect("praecantatio"), 64)
                        .add(Aspect.getAspect("infernus"), 16),
                getModItem(Thaumcraft.ID, "ItemThaumonomicon", 1, 0),
                getModItem(TaintedMagic.ID, "ItemCrystalDagger", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                getModItem(ThaumicBases.ID, "knoseFragment", 1, 6),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 17),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 17),
                getModItem(ThaumicBases.ID, "knoseFragment", 1, 6),
                getModItem(Minecraft.ID, "ender_eye", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 16),
                getModItem(Minecraft.ID, "ender_eye", 1, 0),
                getModItem(ThaumicBases.ID, "knoseFragment", 1, 6),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 17),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 17),
                getModItem(ThaumicBases.ID, "knoseFragment", 1, 6),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15));
        TCHelper.addResearchPage(
                "CRIMSONRITES",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 1))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CRIMSONRITES",
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 8),
                new AspectList().add(Aspect.getAspect("aqua"), 5).add(Aspect.getAspect("terra"), 5)
                        .add(Aspect.getAspect("perditio"), 5),
                "aba",
                "bcb",
                "ada",
                'a',
                getModItem(Witchery.ID, "ingredient", 1, 102),
                'b',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                'c',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                'd',
                getModItem(Thaumcraft.ID, "WandRod", 1, 0));
        TCHelper.addResearchPage(
                "CRIMSONRITES",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 8), false)));
        TCHelper.refreshResearchPages("CRIMSONRITES");
        TCHelper.refreshResearchPages("ELDRITCHMINOR");
        TCHelper.refreshResearchPages("VOIDMETAL");
        TCHelper.refreshResearchPages("CAP_void");
        TCHelper.refreshResearchPages("ESSENTIARESERVOIR");
        TCHelper.refreshResearchPages("FOCUSPRIMAL");
        TCHelper.refreshResearchPages("ROD_primal_staff");
        TCHelper.refreshResearchPages("ARMORVOIDFORTRESS");
        TCHelper.refreshResearchPages("SANITYCHECK");
        TCHelper.refreshResearchPages("OCULUS");
        TCHelper.refreshResearchPages("PRIMALCRUSHER");
        TCHelper.refreshResearchPages("ADVALCHEMYFURNACE");
        TCHelper.refreshResearchPages("ROD_silverwood");
        TCHelper.refreshResearchPages("ROD_greatwood_staff");
        TCHelper.refreshResearchPages("ROD_reed_staff");
        TCHelper.refreshResearchPages("ROD_blaze_staff");
        TCHelper.refreshResearchPages("ROD_obsidian_staff");
        TCHelper.refreshResearchPages("ROD_ice_staff");
        TCHelper.refreshResearchPages("ROD_quartz_staff");
        TCHelper.refreshResearchPages("ROD_bone_staff");
        TCHelper.refreshResearchPages("ROD_silverwood_staff");
        TCHelper.refreshResearchPages("SCEPTRE");
        TCHelper.refreshResearchPages("ROD_greatwood");
        TCHelper.refreshResearchPages("ROD_reed");
        TCHelper.refreshResearchPages("ROD_blaze");
        TCHelper.refreshResearchPages("ROD_obsidian");
        TCHelper.refreshResearchPages("ROD_ice");
        TCHelper.refreshResearchPages("ROD_quartz");
        TCHelper.refreshResearchPages("ROD_bone");

        // Alternative infusion
        ThaumcraftApi.addArcaneCraftingRecipe(
                "INFUSION",
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 2),
                new AspectList().add(Aspect.getAspect("aer"), 45).add(Aspect.getAspect("ignis"), 45)
                        .add(Aspect.getAspect("terra"), 45).add(Aspect.getAspect("aqua"), 45)
                        .add(Aspect.getAspect("ordo"), 45).add(Aspect.getAspect("perditio"), 45),
                "aba",
                "bcb",
                "aba",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                'c',
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0));
        TCHelper.addResearchPage(
                "INFUSION",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 2)))));
    }

    private void aspectAdds() {
        // ASPECT ADDS

        ThaumcraftApi.registerObjectTag(
                getModItem(BiomesOPlenty.ID, "bones", 1, 0),
                new AspectList().add(Aspect.getAspect("corpus"), 1).add(Aspect.getAspect("exanimis"), 3)
                        .add(Aspect.getAspect("mortuus"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(BiomesOPlenty.ID, "bones", 1, 1),
                new AspectList().add(Aspect.getAspect("corpus"), 2).add(Aspect.getAspect("exanimis"), 6)
                        .add(Aspect.getAspect("mortuus"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(BiomesOPlenty.ID, "bones", 1, 2),
                new AspectList().add(Aspect.getAspect("corpus"), 3).add(Aspect.getAspect("exanimis"), 9)
                        .add(Aspect.getAspect("mortuus"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 5),
                new AspectList().add(Aspect.getAspect("terra"), 32).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("vitreus"), 16).add(Aspect.getAspect("infernus"), 8)
                        .add(Aspect.getAspect("tenebrae"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "tile.moonBlock", 1, 3),
                new AspectList().add(Aspect.getAspect("alienis"), 2).add(Aspect.getAspect("vacuos"), 2)
                        .add(Aspect.getAspect("tenebrae"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "tile.moonBlock", 1, 4),
                new AspectList().add(Aspect.getAspect("alienis"), 2).add(Aspect.getAspect("vacuos"), 3)
                        .add(Aspect.getAspect("tenebrae"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "tile.moonBlock", 1, 5),
                new AspectList().add(Aspect.getAspect("alienis"), 1).add(Aspect.getAspect("vacuos"), 1)
                        .add(Aspect.getAspect("tenebrae"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "tile.moonBlock", 1, 14),
                new AspectList().add(Aspect.getAspect("alienis"), 4).add(Aspect.getAspect("ira"), 1)
                        .add(Aspect.getAspect("superbia"), 1));
        ThaumcraftApi.registerObjectTag(
                NHItemList.MoonStoneDust.get(),
                new AspectList().add(Aspect.getAspect("alienis"), 1).add(Aspect.getAspect("perditio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftMars.ID, "tile.mars", 1, 4),
                new AspectList().add(Aspect.getAspect("alienis"), 1).add(Aspect.getAspect("perditio"), 1)
                        .add(Aspect.getAspect("ignis"), 1).add(Aspect.getAspect("terra"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftMars.ID, "tile.mars", 1, 5),
                new AspectList().add(Aspect.getAspect("alienis"), 1).add(Aspect.getAspect("metallum"), 1)
                        .add(Aspect.getAspect("ignis"), 2).add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftMars.ID, "tile.mars", 1, 6),
                new AspectList().add(Aspect.getAspect("alienis"), 2).add(Aspect.getAspect("metallum"), 2)
                        .add(Aspect.getAspect("ignis"), 2).add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftMars.ID, "tile.mars", 1, 7),
                new AspectList().add(Aspect.getAspect("alienis"), 1).add(Aspect.getAspect("metallum"), 1)
                        .add(Aspect.getAspect("ira"), 2).add(Aspect.getAspect("superbia"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftMars.ID, "tile.mars", 1, 9),
                new AspectList().add(Aspect.getAspect("alienis"), 2).add(Aspect.getAspect("metallum"), 3)
                        .add(Aspect.getAspect("ignis"), 3).add(Aspect.getAspect("terra"), 3));
        ThaumcraftApi.registerObjectTag(
                NHItemList.MarsStoneDust.get(),
                new AspectList().add(Aspect.getAspect("alienis"), 1).add(Aspect.getAspect("perditio"), 1)
                        .add(Aspect.getAspect("terra"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftMars.ID, "tile.asteroidsBlock", 1, 0),
                new AspectList().add(Aspect.getAspect("alienis"), 1).add(Aspect.getAspect("tenebrae"), 1)
                        .add(Aspect.getAspect("vacuos"), 1).add(Aspect.getAspect("gelum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftMars.ID, "tile.asteroidsBlock", 1, 1),
                new AspectList().add(Aspect.getAspect("alienis"), 2).add(Aspect.getAspect("tenebrae"), 2)
                        .add(Aspect.getAspect("vacuos"), 2).add(Aspect.getAspect("gelum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftMars.ID, "tile.asteroidsBlock", 1, 2),
                new AspectList().add(Aspect.getAspect("alienis"), 3).add(Aspect.getAspect("tenebrae"), 3)
                        .add(Aspect.getAspect("vacuos"), 3).add(Aspect.getAspect("gelum"), 3));
        ThaumcraftApi.registerObjectTag(
                NHItemList.AsteroidsStoneDust.get(),
                new AspectList().add(Aspect.getAspect("alienis"), 1).add(Aspect.getAspect("perditio"), 1)
                        .add(Aspect.getAspect("gelum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "tile.landingPad", 1, 1),
                new AspectList().add(Aspect.getAspect("metallum"), 5).add(Aspect.getAspect("ordo"), 5));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 6),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("fabrico"), 2)
                        .add(Aspect.getAspect("permutatio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 7),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("fabrico"), 2)
                        .add(Aspect.getAspect("vitreus"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 8),
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("volatus"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 9),
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("ordo"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 10),
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 11),
                new AspectList().add(Aspect.getAspect("metallum"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "item.meteoricIronIngot", 1, 1),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("magneto"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftMars.ID, "item.null", 1, 5),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("vacuos"), 2)
                        .add(Aspect.getAspect("tenebrae"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 6),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("tutamen"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 13),
                new AspectList().add(Aspect.getAspect("fabrico"), 6).add(Aspect.getAspect("ordo"), 5)
                        .add(Aspect.getAspect("machina"), 4).add(Aspect.getAspect("instrumentum"), 3)
                        .add(Aspect.getAspect("metallum"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 14),
                new AspectList().add(Aspect.getAspect("fabrico"), 9).add(Aspect.getAspect("ordo"), 7)
                        .add(Aspect.getAspect("machina"), 6).add(Aspect.getAspect("instrumentum"), 5)
                        .add(Aspect.getAspect("metallum"), 5).add(Aspect.getAspect("lux"), 4));
        ThaumcraftApi.registerObjectTag(
                NHItemList.WaferTier3.get(),
                new AspectList().add(Aspect.getAspect("fabrico"), 12).add(Aspect.getAspect("ordo"), 10)
                        .add(Aspect.getAspect("machina"), 9).add(Aspect.getAspect("instrumentum"), 8)
                        .add(Aspect.getAspect("metallum"), 7).add(Aspect.getAspect("lux"), 6)
                        .add(Aspect.getAspect("alienis"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("volatus"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 1).add(Aspect.getAspect("gelum"), 1)
                        .add(Aspect.getAspect("vitreus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "tile.glowstoneTorch", 1, 0),
                new AspectList().add(Aspect.getAspect("potentia"), 1).add(Aspect.getAspect("machina"), 1)
                        .add(Aspect.getAspect("lux"), 1).add(Aspect.getAspect("sensus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "tile.arclamp", 1, 0),
                new AspectList().add(Aspect.getAspect("potentia"), 5).add(Aspect.getAspect("machina"), 2)
                        .add(Aspect.getAspect("lux"), 5).add(Aspect.getAspect("tenebrae"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 0),
                new AspectList().add(Aspect.getAspect("potentia"), 2).add(Aspect.getAspect("electrum"), 2)
                        .add(Aspect.getAspect("tenebrae"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "item.canister", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 1).add(Aspect.getAspect("vitreus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "item.canister", 1, 1),
                new AspectList().add(Aspect.getAspect("metallum"), 1).add(Aspect.getAspect("permutatio"), 1)
                        .add(Aspect.getAspect("fabrico"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "item.steelPole", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 5).add(Aspect.getAspect("ordo"), 5));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "item.heavyPlating", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("ordo"), 2)
                        .add(Aspect.getAspect("volatus"), 2).add(Aspect.getAspect("instrumentum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftMars.ID, "item.null", 1, 3),
                new AspectList().add(Aspect.getAspect("metallum"), 8).add(Aspect.getAspect("ordo"), 2)
                        .add(Aspect.getAspect("volatus"), 2).add(Aspect.getAspect("instrumentum"), 1)
                        .add(Aspect.getAspect("magneto"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 10).add(Aspect.getAspect("ordo"), 2)
                        .add(Aspect.getAspect("volatus"), 2).add(Aspect.getAspect("instrumentum"), 1)
                        .add(Aspect.getAspect("magneto"), 2).add(Aspect.getAspect("vacuos"), 2)
                        .add(Aspect.getAspect("tenebrae"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "item.oxygenMask", 1, 0),
                new AspectList().add(Aspect.getAspect("tutamen"), 2).add(Aspect.getAspect("gelum"), 1)
                        .add(Aspect.getAspect("vitreus"), 1).add(Aspect.getAspect("metallum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "item.battery", 1, 0),
                new AspectList().add(Aspect.getAspect("electrum"), 6).add(Aspect.getAspect("metallum"), 2)
                        .add(Aspect.getAspect("vacuos"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 15),
                new AspectList().add(Aspect.getAspect("metallum"), 1).add(Aspect.getAspect("vitreus"), 1)
                        .add(Aspect.getAspect("messis"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 16),
                new AspectList().add(Aspect.getAspect("metallum"), 1).add(Aspect.getAspect("vitreus"), 1)
                        .add(Aspect.getAspect("messis"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 17),
                new AspectList().add(Aspect.getAspect("metallum"), 1).add(Aspect.getAspect("vitreus"), 1)
                        .add(Aspect.getAspect("messis"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 18),
                new AspectList().add(Aspect.getAspect("metallum"), 1).add(Aspect.getAspect("vitreus"), 1)
                        .add(Aspect.getAspect("messis"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "item.meteoricIronRaw", 1, 0),
                new AspectList().add(Aspect.getAspect("magneto"), 2).add(Aspect.getAspect("metallum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftMars.ID, "item.thermalPadding", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 12).add(Aspect.getAspect("bestia"), 6)
                        .add(Aspect.getAspect("fabrico"), 3).add(Aspect.getAspect("aqua"), 2)
                        .add(Aspect.getAspect("ordo"), 2).add(Aspect.getAspect("perditio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftMars.ID, "item.thermalPadding", 1, 1),
                new AspectList().add(Aspect.getAspect("pannus"), 18).add(Aspect.getAspect("bestia"), 9)
                        .add(Aspect.getAspect("fabrico"), 5).add(Aspect.getAspect("aqua"), 3)
                        .add(Aspect.getAspect("ordo"), 3).add(Aspect.getAspect("perditio"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftMars.ID, "item.thermalPadding", 1, 2),
                new AspectList().add(Aspect.getAspect("pannus"), 15).add(Aspect.getAspect("bestia"), 7)
                        .add(Aspect.getAspect("fabrico"), 4).add(Aspect.getAspect("aqua"), 3)
                        .add(Aspect.getAspect("ordo"), 3).add(Aspect.getAspect("perditio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftMars.ID, "item.thermalPadding", 1, 3),
                new AspectList().add(Aspect.getAspect("pannus"), 9).add(Aspect.getAspect("bestia"), 5)
                        .add(Aspect.getAspect("fabrico"), 2).add(Aspect.getAspect("aqua"), 1)
                        .add(Aspect.getAspect("ordo"), 1).add(Aspect.getAspect("perditio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftMars.ID, "item.null", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 1).add(Aspect.getAspect("tenebrae"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftMars.ID, "tile.hydrogenPipe", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 1).add(Aspect.getAspect("gelum"), 1)
                        .add(Aspect.getAspect("vitreus"), 1).add(Aspect.getAspect("permutatio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftMars.ID, "item.bucketSludge", 1, 0),
                new AspectList().add(Aspect.getAspect("venenum"), 4).add(Aspect.getAspect("aqua"), 2)
                        .add(Aspect.getAspect("alienis"), 2).add(Aspect.getAspect("metallum"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "item.oilCanisterPartial", 1, 1001),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("ordo"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftMars.ID, "item.methaneCanisterPartial", 1, 1),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("ordo"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftMars.ID, "item.canisterPartialLOX", 1, 1),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("ordo"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftMars.ID, "item.canisterPartialLN2", 1, 1),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("ordo"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftCore.ID, "item.fuelCanisterPartial", 1, 1),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("ordo"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftMars.ID, "tile.creeperEgg", 1, 0),
                new AspectList().add(Aspect.getAspect("alienis"), 10).add(Aspect.getAspect("perditio"), 5));
        ThaumcraftApi.registerObjectTag(
                getModItem(GalacticraftMars.ID, "tile.denseIce", 1, 0),
                new AspectList().add(Aspect.getAspect("alienis"), 5).add(Aspect.getAspect("gelum"), 5));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "blockMetal", 1, 5),
                new AspectList().add(Aspect.getAspect("metallum"), 18).add(Aspect.getAspect("ordo"), 5));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 1, 0),
                new AspectList().add(Aspect.getAspect("fabrico"), 9).add(Aspect.getAspect("ordo"), 7)
                        .add(Aspect.getAspect("machina"), 6).add(Aspect.getAspect("instrumentum"), 5)
                        .add(Aspect.getAspect("metallum"), 5).add(Aspect.getAspect("lux"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("vacuos"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemIngot", 1, 4),
                new AspectList().add(Aspect.getAspect("metallum"), 3));
        ThaumcraftApi.registerObjectTag(
                NHItemList.ReinforcedGlassPlate.get(),
                new AspectList().add(Aspect.getAspect("metallum"), 1).add(Aspect.getAspect("gelum"), 1));
        ThaumcraftApi.registerObjectTag(
                NHItemList.ReinforcedGlassPlate.get(),
                new AspectList().add(Aspect.getAspect("metallum"), 1).add(Aspect.getAspect("gelum"), 1)
                        .add(Aspect.getAspect("vitreus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "blockAlloy", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("ordo"), 3)
                        .add(Aspect.getAspect("terra"), 2).add(Aspect.getAspect("fabrico"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "blockMetal", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("permutatio"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "blockMetal", 1, 1),
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("vitreus"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "blockMetal", 1, 2),
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("instrumentum"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "blockMetal", 1, 4),
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("ordo"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "blockMetal", 1, 3),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("venenum"), 2)
                        .add(Aspect.getAspect("potentia"), 2).add(Aspect.getAspect("radio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 6),
                new AspectList().add(Aspect.getAspect("metallum"), 40).add(Aspect.getAspect("fabrico"), 30)
                        .add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("tutamen"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "blockHeatGenerator", 1, 2),
                new AspectList().add(Aspect.getAspect("metallum"), 30).add(Aspect.getAspect("fabrico"), 18)
                        .add(Aspect.getAspect("ordo"), 8).add(Aspect.getAspect("permutatio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "blockreactorvessel", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 5).add(Aspect.getAspect("fabrico"), 3)
                        .add(Aspect.getAspect("ordo"), 3).add(Aspect.getAspect("terra"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "blockReactorFluidPort", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 5).add(Aspect.getAspect("fabrico"), 3)
                        .add(Aspect.getAspect("iter"), 3).add(Aspect.getAspect("aqua"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "blockReactorAccessHatch", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 5).add(Aspect.getAspect("fabrico"), 3)
                        .add(Aspect.getAspect("iter"), 3).add(Aspect.getAspect("machina"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "blockReactorRedstonePort", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 5).add(Aspect.getAspect("fabrico"), 3)
                        .add(Aspect.getAspect("sensus"), 2).add(Aspect.getAspect("machina"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 3),
                new AspectList().add(Aspect.getAspect("metallum"), 11).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("motus"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 4),
                new AspectList().add(Aspect.getAspect("metallum"), 11).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("volatus"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 5),
                new AspectList().add(Aspect.getAspect("fabrico"), 5).add(Aspect.getAspect("machina"), 4)
                        .add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("ignis"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 6),
                new AspectList().add(Aspect.getAspect("metallum"), 7).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("tutamen"), 3).add(Aspect.getAspect("motus"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "blockMachine", 1, 6),
                new AspectList().add(Aspect.getAspect("metallum"), 64).add(Aspect.getAspect("fabrico"), 64)
                        .add(Aspect.getAspect("ordo"), 64).add(Aspect.getAspect("instrumentum"), 50));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("ignis"), 4)
                        .add(Aspect.getAspect("vitreus"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "blockMachine", 1, 12),
                new AspectList().add(Aspect.getAspect("metallum"), 32).add(Aspect.getAspect("fabrico"), 8)
                        .add(Aspect.getAspect("vacuos"), 4).add(Aspect.getAspect("ignis"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemHarz", 1, 0),
                new AspectList().add(Aspect.getAspect("limus"), 2).add(Aspect.getAspect("motus"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "blockMiningPipe", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "blockLuminatorDark", 1, 0),
                new AspectList().add(Aspect.getAspect("lux"), 4).add(Aspect.getAspect("ignis"), 2)
                        .add(Aspect.getAspect("tenebrae"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "blockITNT", 1, 0),
                new AspectList().add(Aspect.getAspect("ignis"), 4).add(Aspect.getAspect("perditio"), 8)
                        .add(Aspect.getAspect("potentia"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 11),
                new AspectList().add(Aspect.getAspect("metallum"), 27));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12),
                new AspectList().add(Aspect.getAspect("metallum"), 18).add(Aspect.getAspect("ordo"), 5));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 17).add(Aspect.getAspect("fabrico"), 3)
                        .add(Aspect.getAspect("instrumentum"), 2).add(Aspect.getAspect("magneto"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 1),
                new AspectList().add(Aspect.getAspect("machina"), 1).add(Aspect.getAspect("electrum"), 1)
                        .add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 1),
                new AspectList().add(Aspect.getAspect("sensus"), 1).add(Aspect.getAspect("fabrico"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 1),
                new AspectList().add(Aspect.getAspect("fabrico"), 2).add(Aspect.getAspect("metallum"), 1)
                        .add(Aspect.getAspect("sano"), 1).add(Aspect.getAspect("tenebrae"), 1));
        ThaumcraftApi.registerObjectTag(
                ItemList.IC2_Uranium_Fuel.get(1),
                new AspectList().add(Aspect.getAspect("vitreus"), 14).add(Aspect.getAspect("gelum"), 6)
                        .add(Aspect.getAspect("radio"), 3).add(Aspect.getAspect("permutatio"), 6));
        ThaumcraftApi.registerObjectTag(
                ItemList.IC2_MOX_Fuel.get(1),
                new AspectList().add(Aspect.getAspect("radio"), 3).add(Aspect.getAspect("metallum"), 3)
                        .add(Aspect.getAspect("permutatio"), 6).add(Aspect.getAspect("vitreus"), 10));
        ThaumcraftApi.registerObjectTag(
                ItemList.IC2_Plutonium.get(1),
                new AspectList().add(Aspect.getAspect("radio"), 3).add(Aspect.getAspect("metallum"), 3));
        ThaumcraftApi.registerObjectTag(
                ItemList.IC2_Plutonium_Small.get(1),
                new AspectList().add(Aspect.getAspect("metallum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemDust2", 1, 2),
                new AspectList().add(Aspect.getAspect("lucrum"), 4).add(Aspect.getAspect("potentia"), 3)
                        .add(Aspect.getAspect("machina"), 2).add(Aspect.getAspect("vitreus"), 3));
        ThaumcraftApi.registerObjectTag(
                ItemList.IC2_Uranium_235_Small.get(1),
                new AspectList().add(Aspect.getAspect("metallum"), 3).add(Aspect.getAspect("radio"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemContainmentbox", 1, 0),
                new AspectList().add(Aspect.getAspect("fabrico"), 3).add(Aspect.getAspect("instrumentum"), 3)
                        .add(Aspect.getAspect("ordo"), 3).add(Aspect.getAspect("metallum"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemRTGPellet", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("fabrico"), 6)
                        .add(Aspect.getAspect("radio"), 15));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemFuelRod", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("instrumentum"), 2).add(Aspect.getAspect("ordo"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemPartCarbonFibre", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 3).add(Aspect.getAspect("ignis"), 3)
                        .add(Aspect.getAspect("vitreus"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemPartCarbonMesh", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 2).add(Aspect.getAspect("ignis"), 2)
                        .add(Aspect.getAspect("vitreus"), 2));
        ThaumcraftApi.registerObjectTag(
                ItemList.ToolBox.get(1L),
                new AspectList().add(Aspect.getAspect("fabrico"), 3).add(Aspect.getAspect("metallum"), 3)
                        .add(Aspect.getAspect("instrumentum"), 2).add(Aspect.getAspect("ordo"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemShardIridium", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 8).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("machina"), 4).add(Aspect.getAspect("vitreus"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemToolMEter", 1, 0),
                new AspectList().add(Aspect.getAspect("fabrico"), 15).add(Aspect.getAspect("instrumentum"), 6)
                        .add(Aspect.getAspect("cognitio"), 2).add(Aspect.getAspect("lux"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemScanner", 1, 0),
                new AspectList().add(Aspect.getAspect("fabrico"), 18).add(Aspect.getAspect("instrumentum"), 8)
                        .add(Aspect.getAspect("cognitio"), 4).add(Aspect.getAspect("lux"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemScannerAdv", 1, 0),
                new AspectList().add(Aspect.getAspect("fabrico"), 10).add(Aspect.getAspect("instrumentum"), 10)
                        .add(Aspect.getAspect("cognitio"), 6).add(Aspect.getAspect("lux"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "obscurator", 1, 0),
                new AspectList().add(Aspect.getAspect("instrumentum"), 6).add(Aspect.getAspect("lux"), 4)
                        .add(Aspect.getAspect("machina"), 4).add(Aspect.getAspect("tenebrae"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemFreq", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("instrumentum"), 4)
                        .add(Aspect.getAspect("sensus"), 4).add(Aspect.getAspect("electrum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 1).add(Aspect.getAspect("electrum"), 1)
                        .add(Aspect.getAspect("vacuos"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, 0),
                new AspectList().add(Aspect.getAspect("lucrum"), 6).add(Aspect.getAspect("potentia"), 9)
                        .add(Aspect.getAspect("vitreus"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, 0),
                new AspectList().add(Aspect.getAspect("lucrum"), 8).add(Aspect.getAspect("potentia"), 11)
                        .add(Aspect.getAspect("sensus"), 5));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemAdvBat", 1, 0),
                new AspectList().add(Aspect.getAspect("electrum"), 2).add(Aspect.getAspect("metallum"), 2)
                        .add(Aspect.getAspect("vacuos"), 2).add(Aspect.getAspect("potentia"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemBatChargeRE", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 2).add(Aspect.getAspect("electrum"), 2)
                        .add(Aspect.getAspect("vacuos"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemBatChargeAdv", 1, 0),
                new AspectList().add(Aspect.getAspect("electrum"), 3).add(Aspect.getAspect("metallum"), 3)
                        .add(Aspect.getAspect("vacuos"), 3).add(Aspect.getAspect("potentia"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemBatChargeCrystal", 1, 0),
                new AspectList().add(Aspect.getAspect("lucrum"), 10).add(Aspect.getAspect("potentia"), 14)
                        .add(Aspect.getAspect("sensus"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemBatChargeLamaCrystal", 1, 0),
                new AspectList().add(Aspect.getAspect("lucrum"), 12).add(Aspect.getAspect("potentia"), 16)
                        .add(Aspect.getAspect("sensus"), 7));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemGrinPowder", 1, 0),
                new AspectList().add(Aspect.getAspect("venenum"), 3).add(Aspect.getAspect("messis"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 1, 0),
                new AspectList().add(Aspect.getAspect("herba"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemBiochaff", 1, 0),
                new AspectList().add(Aspect.getAspect("herba"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemPartCoalBall", 1, 0),
                new AspectList().add(Aspect.getAspect("potentia"), 2).add(Aspect.getAspect("ignis"), 2)
                        .add(Aspect.getAspect("terra"), 1).add(Aspect.getAspect("instrumentum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemPartCoalBlock", 1, 0),
                new AspectList().add(Aspect.getAspect("potentia"), 4).add(Aspect.getAspect("ignis"), 4)
                        .add(Aspect.getAspect("terra"), 2).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemPartCoalBlock", 1, 0),
                new AspectList().add(Aspect.getAspect("perditio"), 2).add(Aspect.getAspect("terra"), 2)
                        .add(Aspect.getAspect("tenebrae"), 1).add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemScrap", 1, 0),
                new AspectList().add(Aspect.getAspect("strontio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemScrapbox", 1, 0),
                new AspectList().add(Aspect.getAspect("strontio"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemToolPainterBlack", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemToolPainterCloud", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemToolPainterMagenta", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemToolPainterOrange", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemToolPainterWhite", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemToolPainterRed", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemToolPainterGreen", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemToolPainterBrown", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemToolPainterBlue", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemToolPainterLime", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemToolPainterYellow", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemToolPainterPink", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemToolPainterDarkGrey", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemToolPainterLightGrey", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemToolPainterCyan", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemToolPainterPurple", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "reactorVent", 1, 1),
                new AspectList().add(Aspect.getAspect("metallum"), 12).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("volatus"), 4).add(Aspect.getAspect("gelum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "reactorVentCore", 1, 1),
                new AspectList().add(Aspect.getAspect("metallum"), 20).add(Aspect.getAspect("fabrico"), 8)
                        .add(Aspect.getAspect("lucrum"), 4).add(Aspect.getAspect("gelum"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "reactorVentGold", 1, 1),
                new AspectList().add(Aspect.getAspect("metallum"), 24).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("gelum"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1, 1),
                new AspectList().add(Aspect.getAspect("metallum"), 26).add(Aspect.getAspect("fabrico"), 14)
                        .add(Aspect.getAspect("lucrum"), 10).add(Aspect.getAspect("gelum"), 7));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1, 1),
                new AspectList().add(Aspect.getAspect("metallum"), 12).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("permutatio"), 4).add(Aspect.getAspect("gelum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchCore", 1, 1),
                new AspectList().add(Aspect.getAspect("metallum"), 20).add(Aspect.getAspect("fabrico"), 8)
                        .add(Aspect.getAspect("permutatio"), 4).add(Aspect.getAspect("gelum"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchSpread", 1, 1),
                new AspectList().add(Aspect.getAspect("metallum"), 24).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("permutatio"), 9).add(Aspect.getAspect("gelum"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1, 1),
                new AspectList().add(Aspect.getAspect("metallum"), 26).add(Aspect.getAspect("fabrico"), 14)
                        .add(Aspect.getAspect("permutatio"), 10).add(Aspect.getAspect("gelum"), 7));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemwoodrotor", 1, 1),
                new AspectList().add(Aspect.getAspect("tempestas"), 2).add(Aspect.getAspect("arbor"), 4)
                        .add(Aspect.getAspect("metallum"), 2).add(Aspect.getAspect("permutatio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemironrotor", 1, 1),
                new AspectList().add(Aspect.getAspect("tempestas"), 4).add(Aspect.getAspect("metallum"), 4)
                        .add(Aspect.getAspect("instrumentum"), 2).add(Aspect.getAspect("permutatio"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemsteelrotor", 1, 1),
                new AspectList().add(Aspect.getAspect("tempestas"), 6).add(Aspect.getAspect("metallum"), 6)
                        .add(Aspect.getAspect("instrumentum"), 4).add(Aspect.getAspect("permutatio"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemwcarbonrotor", 1, 1),
                new AspectList().add(Aspect.getAspect("tempestas"), 8).add(Aspect.getAspect("metallum"), 8)
                        .add(Aspect.getAspect("instrumentum"), 6).add(Aspect.getAspect("permutatio"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "reactorReflector", 1, 1),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("ignis"), 4)
                        .add(Aspect.getAspect("vitreus"), 2).add(Aspect.getAspect("fabrico"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "reactorReflectorThick", 1, 1),
                new AspectList().add(Aspect.getAspect("metallum"), 8).add(Aspect.getAspect("ignis"), 4)
                        .add(Aspect.getAspect("lucrum"), 4).add(Aspect.getAspect("fabrico"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "reactorCondensator", 1, 1),
                new AspectList().add(Aspect.getAspect("metallum"), 24).add(Aspect.getAspect("fabrico"), 16)
                        .add(Aspect.getAspect("permutatio"), 8).add(Aspect.getAspect("gelum"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "reactorCondensatorLap", 1, 1),
                new AspectList().add(Aspect.getAspect("metallum"), 24).add(Aspect.getAspect("fabrico"), 16)
                        .add(Aspect.getAspect("permutatio"), 16).add(Aspect.getAspect("gelum"), 16));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0),
                new AspectList().add(Aspect.getAspect("instrumentum"), 4).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("motus"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 1),
                new AspectList().add(Aspect.getAspect("instrumentum"), 4).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("electrum"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 2),
                new AspectList().add(Aspect.getAspect("instrumentum"), 4).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("lucrum"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 3),
                new AspectList().add(Aspect.getAspect("instrumentum"), 4).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("permutatio"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 4),
                new AspectList().add(Aspect.getAspect("instrumentum"), 4).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("aqua"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 5),
                new AspectList().add(Aspect.getAspect("instrumentum"), 4).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("cognitio"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 6),
                new AspectList().add(Aspect.getAspect("instrumentum"), 4).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("ignis"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemBoat", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 8).add(Aspect.getAspect("ignis"), 8)
                        .add(Aspect.getAspect("vitreus"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemBoat", 1, 2),
                new AspectList().add(Aspect.getAspect("fabrico"), 1).add(Aspect.getAspect("limus"), 1)
                        .add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemDynamite", 1, 0),
                new AspectList().add(Aspect.getAspect("perditio"), 8).add(Aspect.getAspect("strontio"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemDynamiteSticky", 1, 0),
                new AspectList().add(Aspect.getAspect("perditio"), 8).add(Aspect.getAspect("limus"), 2)
                        .add(Aspect.getAspect("strontio"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemRemote", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("instrumentum"), 4)
                        .add(Aspect.getAspect("sensus"), 4).add(Aspect.getAspect("perditio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 0),
                new AspectList().add(Aspect.getAspect("fabrico"), 2).add(Aspect.getAspect("metallum"), 2)
                        .add(Aspect.getAspect("vitreus"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemTinCan", 1, 0),
                new AspectList().add(Aspect.getAspect("fabrico"), 1).add(Aspect.getAspect("metallum"), 1)
                        .add(Aspect.getAspect("vitreus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemTinCanFilled", 1, 0),
                new AspectList().add(Aspect.getAspect("fabrico"), 2).add(Aspect.getAspect("metallum"), 2)
                        .add(Aspect.getAspect("vitreus"), 2).add(Aspect.getAspect("victus"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "itemCellHydrant", 1, 1),
                new AspectList().add(Aspect.getAspect("aqua"), 8).add(Aspect.getAspect("metallum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "reactorCoolantSimple", 1, 1),
                new AspectList().add(Aspect.getAspect("gelum"), 4).add(Aspect.getAspect("metallum"), 2)
                        .add(Aspect.getAspect("vitreus"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "reactorCoolantTriple", 1, 1),
                new AspectList().add(Aspect.getAspect("gelum"), 8).add(Aspect.getAspect("metallum"), 4)
                        .add(Aspect.getAspect("vitreus"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(IndustrialCraft2.ID, "reactorCoolantSix", 1, 1),
                new AspectList().add(Aspect.getAspect("gelum"), 16).add(Aspect.getAspect("metallum"), 8)
                        .add(Aspect.getAspect("vitreus"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem(MalisisDoors.ID, "trapdoor_acacia", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(MalisisDoors.ID, "trapdoor_birch", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(MalisisDoors.ID, "trapdoor_dark_oak", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(MalisisDoors.ID, "trapdoor_jungle", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(MalisisDoors.ID, "trapdoor_spruce", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(Minecraft.ID, "blaze_powder", 1, 0),
                new AspectList().add(Aspect.getAspect("ignis"), 6).add(Aspect.getAspect("praecantatio"), 4)
                        .add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(Minecraft.ID, "blaze_rod", 1, 0),
                new AspectList().add(Aspect.getAspect("ignis"), 10).add(Aspect.getAspect("praecantatio"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(Minecraft.ID, "paper", 1, 0),
                new AspectList().add(Aspect.getAspect("cognitio"), 4).add(Aspect.getAspect("aqua"), 2)
                        .add(Aspect.getAspect("arbor"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(Minecraft.ID, "book", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 1).add(Aspect.getAspect("cognitio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(Minecraft.ID, "enchanted_book", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 1).add(Aspect.getAspect("cognitio"), 1)
                        .add(Aspect.getAspect("metallum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(Minecraft.ID, "hopper", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("arbor"), 4)
                        .add(Aspect.getAspect("vacuos"), 3).add(Aspect.getAspect("machina"), 1)
                        .add(Aspect.getAspect("permutatio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(Minecraft.ID, "furnace", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("perditio"), 6)
                        .add(Aspect.getAspect("ignis"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("machina"), 1)
                        .add(Aspect.getAspect("sensus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(Minecraft.ID, "redstone_torch", 1, 0),
                new AspectList().add(Aspect.getAspect("potentia"), 1).add(Aspect.getAspect("machina"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(Natura.ID, "trapdoor.eucalyptus", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(Natura.ID, "trapdoor.sakura", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(Natura.ID, "trapdoor.ghostwood", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(Natura.ID, "trapdoor.redwood", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(Natura.ID, "trapdoor.bloodwood", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(Natura.ID, "trapdoor.hopseed", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(Natura.ID, "trapdoor.maple", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(Natura.ID, "trapdoor.amaranth", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(Natura.ID, "trapdoor.silverbell", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(Natura.ID, "trapdoor.willow", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(Natura.ID, "trapdoor.darkwood", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(Natura.ID, "trapdoor.fusewood", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                new AspectList().add(Aspect.getAspect("corpus"), 4).add(Aspect.getAspect("praecantatio"), 2)
                        .add(Aspect.getAspect("mortuus"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(Thaumcraft.ID, "blockCandle", 1, 0),
                new AspectList().add(Aspect.getAspect("lux"), 5).add(Aspect.getAspect("praecantatio"), 2)
                        .add(Aspect.getAspect("pannus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFRoots", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFRoots", 1, 1),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("praecantatio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.liveRoot", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("praecantatio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFFirefly", 1, 0),
                new AspectList().add(Aspect.getAspect("victus"), 1).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFCicada", 1, 0),
                new AspectList().add(Aspect.getAspect("victus"), 1).add(Aspect.getAspect("volatus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFPortal", 1, 0),
                new AspectList().add(Aspect.getAspect("tempus"), 4).add(Aspect.getAspect("praecantatio"), 4)
                        .add(Aspect.getAspect("iter"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMazestone", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMazestone", 1, 1),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMazestone", 1, 2),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMazestone", 1, 3),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMazestone", 1, 4),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMazestone", 1, 5),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMazestone", 1, 6),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMazestone", 1, 7),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFHedge", 1, 0),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFFireflyJar", 1, 0),
                new AspectList().add(Aspect.getAspect("vitreus"), 2).add(Aspect.getAspect("arbor"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 3),
                new AspectList().add(Aspect.getAspect("herba"), 2).add(Aspect.getAspect("victus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 4),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 8),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 9),
                new AspectList().add(Aspect.getAspect("herba"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 10),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 11),
                new AspectList().add(Aspect.getAspect("herba"), 1).add(Aspect.getAspect("perditio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 13),
                new AspectList().add(Aspect.getAspect("herba"), 1).add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 14),
                new AspectList().add(Aspect.getAspect("arbor"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFFireJet", 1, 0),
                new AspectList().add(Aspect.getAspect("ignis"), 2).add(Aspect.getAspect("aer"), 2)
                        .add(Aspect.getAspect("machina"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFFireJet", 1, 8),
                new AspectList().add(Aspect.getAspect("ignis"), 6).add(Aspect.getAspect("motus"), 2)
                        .add(Aspect.getAspect("machina"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFNagastone", 1, 1),
                new AspectList().add(Aspect.getAspect("terra"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFNagastone", 1, 13),
                new AspectList().add(Aspect.getAspect("terra"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFSapling", 1, 5),
                new AspectList().add(Aspect.getAspect("herba"), 4).add(Aspect.getAspect("arbor"), 2)
                        .add(Aspect.getAspect("tempus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFSapling", 1, 6),
                new AspectList().add(Aspect.getAspect("herba"), 4).add(Aspect.getAspect("arbor"), 2)
                        .add(Aspect.getAspect("praecantatio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFSapling", 1, 7),
                new AspectList().add(Aspect.getAspect("herba"), 4).add(Aspect.getAspect("arbor"), 2)
                        .add(Aspect.getAspect("perfodio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFSapling", 1, 9),
                new AspectList().add(Aspect.getAspect("herba"), 4).add(Aspect.getAspect("arbor"), 2)
                        .add(Aspect.getAspect("sensus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMoonworm", 1, 0),
                new AspectList().add(Aspect.getAspect("victus"), 1).add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMagicLogSpecial", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 4).add(Aspect.getAspect("praecantatio"), 2)
                        .add(Aspect.getAspect("tempus"), 2).add(Aspect.getAspect("herba"), 2)
                        .add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMagicLogSpecial", 1, 1),
                new AspectList().add(Aspect.getAspect("arbor"), 4).add(Aspect.getAspect("praecantatio"), 2)
                        .add(Aspect.getAspect("aer"), 2).add(Aspect.getAspect("herba"), 2)
                        .add(Aspect.getAspect("invidia"), 1).add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMagicLogSpecial", 1, 2),
                new AspectList().add(Aspect.getAspect("arbor"), 4).add(Aspect.getAspect("praecantatio"), 2)
                        .add(Aspect.getAspect("perfodio"), 2).add(Aspect.getAspect("herba"), 2)
                        .add(Aspect.getAspect("lucrum"), 1).add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMagicLogSpecial", 1, 3),
                new AspectList().add(Aspect.getAspect("arbor"), 4).add(Aspect.getAspect("praecantatio"), 2)
                        .add(Aspect.getAspect("motus"), 2).add(Aspect.getAspect("herba"), 2)
                        .add(Aspect.getAspect("cognitio"), 1).add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFTowerDevice", 1, 2),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("machina"), 1)
                        .add(Aspect.getAspect("potentia"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFTowerDevice", 1, 4),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("machina"), 1)
                        .add(Aspect.getAspect("potentia"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFTowerDevice", 1, 5),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("machina"), 1)
                        .add(Aspect.getAspect("potentia"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFTowerDevice", 1, 6),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("machina"), 1)
                        .add(Aspect.getAspect("potentia"), 2).add(Aspect.getAspect("iter"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFTowerDevice", 1, 9),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("machina"), 2)
                        .add(Aspect.getAspect("potentia"), 4).add(Aspect.getAspect("perditio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFTowerDevice", 1, 10),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("machina"), 2)
                        .add(Aspect.getAspect("potentia"), 4).add(Aspect.getAspect("vinculum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFShield", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("machina"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFTrophyPedestal", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 7).add(Aspect.getAspect("ordo"), 4)
                        .add(Aspect.getAspect("lucrum"), 4).add(Aspect.getAspect("instrumentum"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFTrophyPedestal", 1, 15),
                new AspectList().add(Aspect.getAspect("terra"), 7).add(Aspect.getAspect("ordo"), 12)
                        .add(Aspect.getAspect("lucrum"), 12).add(Aspect.getAspect("instrumentum"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFAuroraBrick", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("sensus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFUnderBrick", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFUnderBrick", 1, 1),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFUnderBrick", 1, 2),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3)
                        .add(Aspect.getAspect("perditio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFThorns", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("fabrico"), 1)
                        .add(Aspect.getAspect("telum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFThorns", 1, 1),
                new AspectList().add(Aspect.getAspect("herba"), 3).add(Aspect.getAspect("fabrico"), 1)
                        .add(Aspect.getAspect("telum"), 1).add(Aspect.getAspect("aqua"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFBurntThorns", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("perditio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFThornRose", 1, 0),
                new AspectList().add(Aspect.getAspect("herba"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFLeaves3", 1, 0),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFLeaves3", 1, 1),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFDeadrock", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 8).add(Aspect.getAspect("ignis"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFDeadrock", 1, 1),
                new AspectList().add(Aspect.getAspect("terra"), 8).add(Aspect.getAspect("ignis"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFDeadrock", 1, 2),
                new AspectList().add(Aspect.getAspect("terra"), 8).add(Aspect.getAspect("ignis"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.DarkLeaves", 1, 0),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.AuroraPillar", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("sensus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.AuroraSlab", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 2).add(Aspect.getAspect("sensus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.AuroraDoubleSlab", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("sensus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TrollSteinn", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("potentia"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.WispyCloud", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 1).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("aqua"), 1).add(Aspect.getAspect("tempestas"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.FluffyCloud", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 1).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("pannus"), 1).add(Aspect.getAspect("tempestas"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.HugeStalk", 1, 0),
                new AspectList().add(Aspect.getAspect("herba"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.GiantCobble", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("perditio"), 16));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.GiantLog", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 16));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.GiantLeaves", 1, 0),
                new AspectList().add(Aspect.getAspect("herba"), 16));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.GiantObsidian", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("ignis"), 16)
                        .add(Aspect.getAspect("tenebrae"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.UberousSoil", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("aqua"), 4)
                        .add(Aspect.getAspect("herba"), 4).add(Aspect.getAspect("victus"), 10));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.HugeGloomBlock", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("tenebrae"), 2)
                        .add(Aspect.getAspect("herba"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.KnightmetalBlock", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 18).add(Aspect.getAspect("lucrum"), 9));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.UnripeTrollBer", 1, 0),
                new AspectList().add(Aspect.getAspect("herba"), 1).add(Aspect.getAspect("terra"), 1)
                        .add(Aspect.getAspect("perditio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TrollBer", 1, 0),
                new AspectList().add(Aspect.getAspect("herba"), 1).add(Aspect.getAspect("terra"), 1)
                        .add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.HugeLilyPad", 1, 0),
                new AspectList().add(Aspect.getAspect("herba"), 8).add(Aspect.getAspect("aqua"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.HugeWaterLily", 1, 0),
                new AspectList().add(Aspect.getAspect("herba"), 3));
        ThaumcraftApi.registerObjectTag(getModItem(TwilightForest.ID, "tile.Slider", 1, 0), new AspectList());
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.CastleBrick", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.CastleBrick", 1, 1),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3)
                        .add(Aspect.getAspect("perditio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.CastleBrick", 1, 2),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3)
                        .add(Aspect.getAspect("perditio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.CastleBrick", 1, 3),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3)
                        .add(Aspect.getAspect("tenebrae"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.CastleMagic", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3)
                        .add(Aspect.getAspect("praecantatio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.CastleMagic", 1, 1),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3)
                        .add(Aspect.getAspect("praecantatio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.CastleMagic", 1, 2),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3)
                        .add(Aspect.getAspect("praecantatio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.CastleMagic", 1, 3),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3)
                        .add(Aspect.getAspect("praecantatio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.nagaScale", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 3).add(Aspect.getAspect("tutamen"), 2)
                        .add(Aspect.getAspect("bestia"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.plateNaga", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 24).add(Aspect.getAspect("tutamen"), 16)
                        .add(Aspect.getAspect("bestia"), 16).add(Aspect.getAspect("superbia"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.legsNaga", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 21).add(Aspect.getAspect("tutamen"), 14)
                        .add(Aspect.getAspect("bestia"), 14).add(Aspect.getAspect("superbia"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.scepterTwilight", 1, 0),
                new AspectList().add(Aspect.getAspect("alienis"), 40).add(Aspect.getAspect("iter"), 35)
                        .add(Aspect.getAspect("praecantatio"), 25).add(Aspect.getAspect("mortuus"), 20)
                        .add(Aspect.getAspect("corpus"), 10));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.scepterLifeDrain", 1, 0),
                new AspectList().add(Aspect.getAspect("alienis"), 40).add(Aspect.getAspect("victus"), 15)
                        .add(Aspect.getAspect("gula"), 20).add(Aspect.getAspect("praecantatio"), 25)
                        .add(Aspect.getAspect("mortuus"), 20).add(Aspect.getAspect("corpus"), 10));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.scepterZombie", 1, 0),
                new AspectList().add(Aspect.getAspect("alienis"), 40).add(Aspect.getAspect("exanimis"), 35)
                        .add(Aspect.getAspect("praecantatio"), 25).add(Aspect.getAspect("mortuus"), 20)
                        .add(Aspect.getAspect("corpus"), 10));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.scepterTwilight", 1, wildcard),
                new AspectList().add(Aspect.getAspect("alienis"), 40).add(Aspect.getAspect("iter"), 35)
                        .add(Aspect.getAspect("praecantatio"), 25).add(Aspect.getAspect("mortuus"), 20)
                        .add(Aspect.getAspect("corpus"), 10));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.scepterLifeDrain", 1, wildcard),
                new AspectList().add(Aspect.getAspect("alienis"), 40).add(Aspect.getAspect("victus"), 15)
                        .add(Aspect.getAspect("gula"), 20).add(Aspect.getAspect("praecantatio"), 25)
                        .add(Aspect.getAspect("mortuus"), 20).add(Aspect.getAspect("corpus"), 10));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.scepterZombie", 1, wildcard),
                new AspectList().add(Aspect.getAspect("alienis"), 40).add(Aspect.getAspect("exanimis"), 35)
                        .add(Aspect.getAspect("praecantatio"), 25).add(Aspect.getAspect("mortuus"), 20)
                        .add(Aspect.getAspect("corpus"), 10));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.tfFeather", 1, 0),
                new AspectList().add(Aspect.getAspect("volatus"), 2).add(Aspect.getAspect("aer"), 1)
                        .add(Aspect.getAspect("tenebrae"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.magicMapFocus", 1, 0),
                new AspectList().add(Aspect.getAspect("volatus"), 2).add(Aspect.getAspect("aer"), 1)
                        .add(Aspect.getAspect("tenebrae"), 1).add(Aspect.getAspect("lux"), 1)
                        .add(Aspect.getAspect("praecantatio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.venisonRaw", 1, 0),
                new AspectList().add(Aspect.getAspect("mortuus"), 3).add(Aspect.getAspect("victus"), 2)
                        .add(Aspect.getAspect("bestia"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.venisonCooked", 1, 0),
                new AspectList().add(Aspect.getAspect("mortuus"), 4).add(Aspect.getAspect("fames"), 3)
                        .add(Aspect.getAspect("fabrico"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.hydraChop", 1, 0),
                new AspectList().add(Aspect.getAspect("mortuus"), 9).add(Aspect.getAspect("victus"), 6)
                        .add(Aspect.getAspect("bestia"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.fieryBlood", 1, 0),
                new AspectList().add(Aspect.getAspect("vacuos"), 1).add(Aspect.getAspect("victus"), 4)
                        .add(Aspect.getAspect("aqua"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.trophy", 1, 0),
                new AspectList().add(Aspect.getAspect("lucrum"), 10).add(Aspect.getAspect("luxuria"), 1)
                        .add(Aspect.getAspect("superbia"), 2).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ignis"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.trophy", 1, 1),
                new AspectList().add(Aspect.getAspect("lucrum"), 10).add(Aspect.getAspect("luxuria"), 1)
                        .add(Aspect.getAspect("superbia"), 2).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("terra"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.trophy", 1, 2),
                new AspectList().add(Aspect.getAspect("lucrum"), 10).add(Aspect.getAspect("luxuria"), 1)
                        .add(Aspect.getAspect("superbia"), 2).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("exanimis"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.trophy", 1, 3),
                new AspectList().add(Aspect.getAspect("lucrum"), 10).add(Aspect.getAspect("luxuria"), 1)
                        .add(Aspect.getAspect("superbia"), 2).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("infernus"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.trophy", 1, 4),
                new AspectList().add(Aspect.getAspect("lucrum"), 10).add(Aspect.getAspect("luxuria"), 1)
                        .add(Aspect.getAspect("superbia"), 2).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("gelum"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.minotaurAxe", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("telum"), 8).add(Aspect.getAspect("instrumentum"), 8)
                        .add(Aspect.getAspect("superbia"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.transformPowder", 1, 0),
                new AspectList().add(Aspect.getAspect("mortuus"), 4).add(Aspect.getAspect("fames"), 3)
                        .add(Aspect.getAspect("fabrico"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.meefRaw", 1, 0),
                new AspectList().add(Aspect.getAspect("mortuus"), 3).add(Aspect.getAspect("victus"), 2)
                        .add(Aspect.getAspect("bestia"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.meefSteak", 1, 0),
                new AspectList().add(Aspect.getAspect("mortuus"), 4).add(Aspect.getAspect("fames"), 3)
                        .add(Aspect.getAspect("fabrico"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.meefStroganoff", 1, 0),
                new AspectList().add(Aspect.getAspect("mortuus"), 4).add(Aspect.getAspect("fames"), 4)
                        .add(Aspect.getAspect("fabrico"), 2).add(Aspect.getAspect("arbor"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.mazeWafer", 1, 0),
                new AspectList().add(Aspect.getAspect("messis"), 4).add(Aspect.getAspect("fames"), 3)
                        .add(Aspect.getAspect("fabrico"), 1).add(Aspect.getAspect("sano"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.oreMagnet", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("magneto"), 4)
                        .add(Aspect.getAspect("perfodio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.oreMagnet", 1, wildcard),
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("magneto"), 4)
                        .add(Aspect.getAspect("perfodio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.crumbleHorn", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 18).add(Aspect.getAspect("praecantatio"), 14)
                        .add(Aspect.getAspect("ordo"), 12).add(Aspect.getAspect("auram"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.crumbleHorn", 1, wildcard),
                new AspectList().add(Aspect.getAspect("arbor"), 18).add(Aspect.getAspect("praecantatio"), 14)
                        .add(Aspect.getAspect("ordo"), 12).add(Aspect.getAspect("auram"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.peacockFan", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 18).add(Aspect.getAspect("volatus"), 10)
                        .add(Aspect.getAspect("motus"), 10).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("arbor"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.peacockFan", 1, wildcard),
                new AspectList().add(Aspect.getAspect("aer"), 18).add(Aspect.getAspect("volatus"), 10)
                        .add(Aspect.getAspect("motus"), 10).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("arbor"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.moonwormQueen", 1, 0),
                new AspectList().add(Aspect.getAspect("victus"), 10).add(Aspect.getAspect("lux"), 10)
                        .add(Aspect.getAspect("motus"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.moonwormQueen", 1, wildcard),
                new AspectList().add(Aspect.getAspect("victus"), 10).add(Aspect.getAspect("lux"), 10)
                        .add(Aspect.getAspect("motus"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.charmOfLife1", 1, 0),
                new AspectList().add(Aspect.getAspect("sano"), 16).add(Aspect.getAspect("ordo"), 16)
                        .add(Aspect.getAspect("praecantatio"), 8).add(Aspect.getAspect("victus"), 8)
                        .add(Aspect.getAspect("lucrum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.charmOfLife2", 1, 0),
                new AspectList().add(Aspect.getAspect("sano"), 64).add(Aspect.getAspect("ordo"), 64)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("victus"), 32)
                        .add(Aspect.getAspect("lucrum"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.charmOfKeeping1", 1, 0),
                new AspectList().add(Aspect.getAspect("instrumentum"), 4).add(Aspect.getAspect("ordo"), 4)
                        .add(Aspect.getAspect("praecantatio"), 3).add(Aspect.getAspect("tutamen"), 3)
                        .add(Aspect.getAspect("lucrum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.charmOfKeeping2", 1, 0),
                new AspectList().add(Aspect.getAspect("instrumentum"), 16).add(Aspect.getAspect("ordo"), 16)
                        .add(Aspect.getAspect("praecantatio"), 8).add(Aspect.getAspect("tutamen"), 8)
                        .add(Aspect.getAspect("lucrum"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.charmOfKeeping3", 1, 0),
                new AspectList().add(Aspect.getAspect("instrumentum"), 64).add(Aspect.getAspect("ordo"), 64)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("tutamen"), 32)
                        .add(Aspect.getAspect("lucrum"), 16));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.towerKey", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 2).add(Aspect.getAspect("lucrum"), 2)
                        .add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.borerEssence", 1, 0),
                new AspectList().add(Aspect.getAspect("praecantatio"), 2).add(Aspect.getAspect("lucrum"), 2)
                        .add(Aspect.getAspect("ordo"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.experiment115", 1, 0),
                new AspectList().add(Aspect.getAspect("messis"), 5).add(Aspect.getAspect("fames"), 4)
                        .add(Aspect.getAspect("fabrico"), 2).add(Aspect.getAspect("alienis"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.phantomHelm", 1, 0),
                new AspectList().add(Aspect.getAspect("tutamen"), 5).add(Aspect.getAspect("fabrico"), 3)
                        .add(Aspect.getAspect("metallum"), 7).add(Aspect.getAspect("spiritus"), 5)
                        .add(Aspect.getAspect("instrumentum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.phantomPlate", 1, 0),
                new AspectList().add(Aspect.getAspect("tutamen"), 8).add(Aspect.getAspect("fabrico"), 5)
                        .add(Aspect.getAspect("metallum"), 11).add(Aspect.getAspect("spiritus"), 8)
                        .add(Aspect.getAspect("instrumentum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.lampOfCinders", 1, 0),
                new AspectList().add(Aspect.getAspect("lucrum"), 16).add(Aspect.getAspect("ignis"), 10)
                        .add(Aspect.getAspect("fabrico"), 6).add(Aspect.getAspect("praecantatio"), 8)
                        .add(Aspect.getAspect("instrumentum"), 4).add(Aspect.getAspect("luxuria"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.fieryTears", 1, 0),
                new AspectList().add(Aspect.getAspect("vacuos"), 1).add(Aspect.getAspect("ira"), 4)
                        .add(Aspect.getAspect("exanimis"), 4).add(Aspect.getAspect("spiritus"), 4)
                        .add(Aspect.getAspect("praecantatio"), 2).add(Aspect.getAspect("aqua"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.alphaFur", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 6).add(Aspect.getAspect("gelum"), 3)
                        .add(Aspect.getAspect("bestia"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.arcticFur", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 2).add(Aspect.getAspect("gelum"), 1)
                        .add(Aspect.getAspect("bestia"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.iceBomb", 1, 0),
                new AspectList().add(Aspect.getAspect("gelum"), 8).add(Aspect.getAspect("motus"), 8)
                        .add(Aspect.getAspect("fabrico"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.arcticHelm", 1, 0),
                new AspectList().add(Aspect.getAspect("tutamen"), 3).add(Aspect.getAspect("fabrico"), 2)
                        .add(Aspect.getAspect("pannus"), 6).add(Aspect.getAspect("gelum"), 2)
                        .add(Aspect.getAspect("instrumentum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.arcticPlate", 1, 0),
                new AspectList().add(Aspect.getAspect("tutamen"), 7).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("pannus"), 14).add(Aspect.getAspect("gelum"), 4)
                        .add(Aspect.getAspect("instrumentum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.arcticLegs", 1, 0),
                new AspectList().add(Aspect.getAspect("tutamen"), 5).add(Aspect.getAspect("fabrico"), 3)
                        .add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("gelum"), 3)
                        .add(Aspect.getAspect("instrumentum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.arcticBoots", 1, 0),
                new AspectList().add(Aspect.getAspect("tutamen"), 2).add(Aspect.getAspect("fabrico"), 2)
                        .add(Aspect.getAspect("pannus"), 4).add(Aspect.getAspect("gelum"), 2)
                        .add(Aspect.getAspect("instrumentum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.yetiHelm", 1, 0),
                new AspectList().add(Aspect.getAspect("tutamen"), 4).add(Aspect.getAspect("fabrico"), 2)
                        .add(Aspect.getAspect("pannus"), 12).add(Aspect.getAspect("gelum"), 4)
                        .add(Aspect.getAspect("instrumentum"), 1).add(Aspect.getAspect("praecantatio"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.yetiPlate", 1, 0),
                new AspectList().add(Aspect.getAspect("tutamen"), 8).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("pannus"), 24).add(Aspect.getAspect("gelum"), 8)
                        .add(Aspect.getAspect("instrumentum"), 1).add(Aspect.getAspect("praecantatio"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.yetiLegs", 1, 0),
                new AspectList().add(Aspect.getAspect("tutamen"), 6).add(Aspect.getAspect("fabrico"), 3)
                        .add(Aspect.getAspect("pannus"), 18).add(Aspect.getAspect("gelum"), 6)
                        .add(Aspect.getAspect("instrumentum"), 1).add(Aspect.getAspect("praecantatio"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.yetiBoots", 1, 0),
                new AspectList().add(Aspect.getAspect("tutamen"), 3).add(Aspect.getAspect("fabrico"), 2)
                        .add(Aspect.getAspect("pannus"), 9).add(Aspect.getAspect("gelum"), 3)
                        .add(Aspect.getAspect("instrumentum"), 1).add(Aspect.getAspect("praecantatio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.magicBeans", 1, 0),
                new AspectList().add(Aspect.getAspect("herba"), 16).add(Aspect.getAspect("praecantatio"), 8)
                        .add(Aspect.getAspect("sensus"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.giantPick", 1, 0),
                new AspectList().add(Aspect.getAspect("perfodio"), 32).add(Aspect.getAspect("terra"), 16)
                        .add(Aspect.getAspect("perditio"), 16).add(Aspect.getAspect("arbor"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.giantSword", 1, 0),
                new AspectList().add(Aspect.getAspect("telum"), 32).add(Aspect.getAspect("terra"), 16)
                        .add(Aspect.getAspect("perditio"), 16).add(Aspect.getAspect("arbor"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.enderBow", 1, 0),
                new AspectList().add(Aspect.getAspect("telum"), 3).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("pannus"), 2).add(Aspect.getAspect("bestia"), 2)
                        .add(Aspect.getAspect("alienis"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.iceBow", 1, 0),
                new AspectList().add(Aspect.getAspect("telum"), 3).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("pannus"), 2).add(Aspect.getAspect("bestia"), 2)
                        .add(Aspect.getAspect("gelum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.tripleBow", 1, 0),
                new AspectList().add(Aspect.getAspect("telum"), 6).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("pannus"), 2).add(Aspect.getAspect("bestia"), 2)
                        .add(Aspect.getAspect("arbor"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.seekerBow", 1, 0),
                new AspectList().add(Aspect.getAspect("telum"), 3).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("pannus"), 2).add(Aspect.getAspect("bestia"), 2)
                        .add(Aspect.getAspect("iter"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.iceSword", 1, 0),
                new AspectList().add(Aspect.getAspect("telum"), 4).add(Aspect.getAspect("lucrum"), 2)
                        .add(Aspect.getAspect("praecantatio"), 2).add(Aspect.getAspect("gelum"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.glassSword", 1, 0),
                new AspectList().add(Aspect.getAspect("telum"), 14).add(Aspect.getAspect("vitreus"), 20)
                        .add(Aspect.getAspect("lucrum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.giantPick", 1, wildcard),
                new AspectList().add(Aspect.getAspect("perfodio"), 32).add(Aspect.getAspect("terra"), 16)
                        .add(Aspect.getAspect("perditio"), 16).add(Aspect.getAspect("arbor"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.giantSword", 1, wildcard),
                new AspectList().add(Aspect.getAspect("telum"), 32).add(Aspect.getAspect("terra"), 16)
                        .add(Aspect.getAspect("perditio"), 16).add(Aspect.getAspect("arbor"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.enderBow", 1, wildcard),
                new AspectList().add(Aspect.getAspect("telum"), 3).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("pannus"), 2).add(Aspect.getAspect("bestia"), 2)
                        .add(Aspect.getAspect("alienis"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.iceBow", 1, wildcard),
                new AspectList().add(Aspect.getAspect("telum"), 3).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("pannus"), 2).add(Aspect.getAspect("bestia"), 2)
                        .add(Aspect.getAspect("gelum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.tripleBow", 1, wildcard),
                new AspectList().add(Aspect.getAspect("telum"), 6).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("pannus"), 2).add(Aspect.getAspect("bestia"), 2)
                        .add(Aspect.getAspect("arbor"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.seekerBow", 1, wildcard),
                new AspectList().add(Aspect.getAspect("telum"), 3).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("pannus"), 2).add(Aspect.getAspect("bestia"), 2)
                        .add(Aspect.getAspect("iter"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.iceSword", 1, wildcard),
                new AspectList().add(Aspect.getAspect("telum"), 4).add(Aspect.getAspect("lucrum"), 2)
                        .add(Aspect.getAspect("praecantatio"), 2).add(Aspect.getAspect("gelum"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.glassSword", 1, wildcard),
                new AspectList().add(Aspect.getAspect("telum"), 14).add(Aspect.getAspect("vitreus"), 20)
                        .add(Aspect.getAspect("lucrum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.knightmetalRing", 1, 0),
                new AspectList().add(Aspect.getAspect("instrumentum"), 3).add(Aspect.getAspect("ordo"), 3)
                        .add(Aspect.getAspect("fabrico"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.chainBlock", 1, 0),
                new AspectList().add(Aspect.getAspect("telum"), 10).add(Aspect.getAspect("metallum"), 20)
                        .add(Aspect.getAspect("motus"), 4).add(Aspect.getAspect("lucrum"), 8)
                        .add(Aspect.getAspect("instrumentum"), 10));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.chainBlock", 1, wildcard),
                new AspectList().add(Aspect.getAspect("telum"), 10).add(Aspect.getAspect("metallum"), 20)
                        .add(Aspect.getAspect("motus"), 4).add(Aspect.getAspect("lucrum"), 8)
                        .add(Aspect.getAspect("instrumentum"), 10));
        ThaumcraftApi.registerObjectTag(
                getModItem(Forestry.ID, "grafter", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 2).add(Aspect.getAspect("arbor"), 1)
                        .add(Aspect.getAspect("instrumentum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(Forestry.ID, "scoop", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 4).add(Aspect.getAspect("pannus"), 3)
                        .add(Aspect.getAspect("instrumentum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(ThaumicBases.ID, "tobaccoPowder", 1, 0),
                new AspectList().add(Aspect.getAspect("herba"), 1).add(Aspect.getAspect("humanus"), 1)
                        .add(Aspect.getAspect("perditio"), 1));
        ThaumcraftApi.registerObjectTag(
                NHItemList.NANCertificate.get(1),
                new AspectList().add(Aspect.METAL, 64).add(Aspect.CRAFT, 64).add(Aspect.CRYSTAL, 64));

    }

}
