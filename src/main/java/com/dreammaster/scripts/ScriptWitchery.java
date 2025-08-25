package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.BloodArsenal;
import static gregtech.api.enums.Mods.Botania;
import static gregtech.api.enums.Mods.EtFuturumRequiem;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.Witchery;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
import static gregtech.api.recipe.RecipeMaps.formingPressRecipes;
import static gregtech.api.recipe.RecipeMaps.mixerRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.thaumcraft.TCHelper;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ScriptWitchery implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Witchery";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                EtFuturumRequiem.ID,
                Witchery.ID,
                Thaumcraft.ID,
                IndustrialCraft2.ID,
                BloodArsenal.ID,
                TinkerConstruct.ID,
                Backpack.ID,
                BiomesOPlenty.ID,
                Railcraft.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(Witchery.ID, "seedswormwood", 1, 0, missing),
                getModItem(Witchery.ID, "mutator", 1, 0, missing),
                getModItem(Witchery.ID, "somniancotton", 1, 0, missing),
                null,
                getModItem(Witchery.ID, "somniancotton", 1, 0, missing),
                getModItem(Minecraft.ID, "wheat", 1, 0, missing),
                getModItem(Witchery.ID, "somniancotton", 1, 0, missing),
                null,
                getModItem(Witchery.ID, "somniancotton", 1, 0, missing),
                null);
        addShapelessRecipe(
                getModItem(Witchery.ID, "ingredient", 2, 130, missing),
                getModItem(Witchery.ID, "ingredient", 1, 130, missing),
                getModItem(Minecraft.ID, "magma_cream", 1, 0, missing),
                getModItem(Minecraft.ID, "blaze_powder", 1, 0, missing),
                "dustTinyNetherStar");

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.magma_cream, 24),
                        new ItemStack(Items.nether_star, 4),
                        new ItemStack(Items.flint, 4),
                        getModItem(Botania.ID, "manaResource", 4, 2, missing),
                        GTUtility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(Witchery.ID, "ingredient", 8, 130, missing)).duration(2 * SECONDS).eut(16)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Witchery.ID, "ingredient", 9, 130, missing),
                        new ItemStack(Items.magma_cream, 9),
                        new ItemStack(Items.blaze_powder, 9),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.NetherStar, 1L),
                        GTUtility.getIntegratedCircuit(4))
                .itemOutputs(getModItem(Witchery.ID, "ingredient", 18, 130, missing)).duration(2 * SECONDS).eut(16)
                .addTo(mixerRecipes);

        addShapedRecipe(
                getModItem(Witchery.ID, "ingredient", 1, 16, missing),
                null,
                null,
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Quicklime, 1L),
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Quicklime, 1L),
                null,
                null,
                getModItem(Witchery.ID, "ingredient", 1, 16, missing),
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Witchery.ID, "ingredient", 1, 140, missing),
                "platePaper",
                "string",
                "platePaper",
                "string",
                getModItem(Witchery.ID, "ingredient", 1, 163, missing),
                "string",
                "platePaper",
                "string",
                "platePaper");
        addShapelessRecipe(
                getModItem(Witchery.ID, "ingredient", 4, 7, missing),
                getModItem(Minecraft.ID, "bone", 1, 0, missing),
                "craftingToolKnife");
        addShapedRecipe(
                getModItem(Witchery.ID, "ingredient", 1, 81, missing),
                getModItem(Witchery.ID, "ingredient", 1, 22, missing),
                getModItem(Witchery.ID, "ingredient", 1, 21, missing),
                getModItem(Witchery.ID, "garlic", 1, 0, missing),
                "dyeBlack",
                "craftingBook",
                "craftingFeather",
                getModItem(Witchery.ID, "ingredient", 1, 69, missing),
                getModItem(Witchery.ID, "ingredient", 1, 156, missing),
                "listAllseed");
        addShapedRecipe(
                getModItem(Witchery.ID, "ingredient", 1, 106, missing),
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "mud", 1, 1, missing),
                getModItem(Minecraft.ID, "mycelium", 1, 0, missing),
                "dyeBlack",
                "craftingBook",
                "craftingFeather",
                getModItem(Minecraft.ID, "netherrack", 1, 0, missing),
                getModItem(Minecraft.ID, "dirt", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 5, missing));
        addShapedRecipe(
                getModItem(Witchery.ID, "ingredient", 1, 127, missing),
                createItemStack(Witchery.ID, "poppet", 1, 0, "{WITCDamage:0}", missing),
                getModItem(Witchery.ID, "ingredient", 1, 7, missing),
                getModItem(Witchery.ID, "ingredient", 1, 14, missing),
                "dyeBlack",
                "craftingBook",
                "craftingFeather",
                getModItem(Witchery.ID, "ingredient", 1, 74, missing),
                getModItem(Witchery.ID, "ingredient", 1, 25, missing),
                "flowerYellow");
        addShapedRecipe(
                getModItem(Witchery.ID, "ingredient", 1, 46, missing),
                getModItem(Witchery.ID, "ingredient", 1, 27, missing),
                getModItem(Witchery.ID, "ingredient", 1, 27, missing),
                getModItem(Witchery.ID, "ingredient", 1, 27, missing),
                "dyeBlack",
                "craftingBook",
                "craftingFeather",
                getModItem(Witchery.ID, "ingredient", 1, 27, missing),
                getModItem(Witchery.ID, "ingredient", 1, 27, missing),
                getModItem(Witchery.ID, "ingredient", 1, 27, missing));
        addShapedRecipe(
                getModItem(Witchery.ID, "cauldronbook", 1, 0, missing),
                getModItem(Witchery.ID, "ingredient", 1, 31, missing),
                getModItem(Witchery.ID, "ingredient", 1, 33, missing),
                getModItem(Witchery.ID, "ingredient", 1, 32, missing),
                "dyeBlack",
                "craftingBook",
                "craftingFeather",
                getModItem(Witchery.ID, "ingredient", 1, 34, missing),
                getModItem(Witchery.ID, "ingredient", 1, 35, missing),
                getModItem(Witchery.ID, "ingredient", 1, 28, missing));
        addShapedRecipe(
                getModItem(Witchery.ID, "ingredient", 1, 107, missing),
                getModItem(Witchery.ID, "chalkritual", 1, 0, missing),
                getModItem(Witchery.ID, "circletalisman", 1, 0, missing),
                getModItem(Witchery.ID, "chalkritual", 1, 0, missing),
                "dyeBlack",
                "craftingBook",
                "craftingFeather",
                getModItem(Witchery.ID, "glintweed", 1, 0, missing),
                getModItem(Witchery.ID, "ingredient", 1, 78, missing),
                getModItem(Witchery.ID, "grassper", 1, 0, missing));
        addShapedRecipe(
                getModItem(Witchery.ID, "ingredient", 1, 47, missing),
                getModItem(Witchery.ID, "ingredient", 1, 27, missing),
                getModItem(Witchery.ID, "ingredient", 1, 10, missing),
                getModItem(Witchery.ID, "ingredient", 1, 27, missing),
                "dyeBlack",
                "craftingBook",
                "craftingFeather",
                getModItem(Witchery.ID, "ingredient", 1, 27, missing),
                getModItem(Minecraft.ID, "cauldron", 1, 0, missing),
                getModItem(Witchery.ID, "ingredient", 1, 27, missing));
        addShapedRecipe(
                getModItem(Witchery.ID, "ingredient", 1, 48, missing),
                getModItem(Witchery.ID, "ingredient", 1, 17, missing),
                getModItem(Witchery.ID, "ingredient", 1, 37, missing),
                getModItem(Witchery.ID, "ingredient", 1, 17, missing),
                "dyeBlack",
                "craftingBook",
                "craftingFeather",
                getModItem(Witchery.ID, "ingredient", 1, 17, missing),
                getModItem(Witchery.ID, "ingredient", 1, 37, missing),
                getModItem(Witchery.ID, "ingredient", 1, 17, missing));
        addShapedRecipe(
                getModItem(Witchery.ID, "ingredient", 1, 49, missing),
                getModItem(Witchery.ID, "ingredient", 1, 34, missing),
                getModItem(Witchery.ID, "ingredient", 1, 34, missing),
                getModItem(Witchery.ID, "ingredient", 1, 34, missing),
                "dyeBlack",
                "craftingBook",
                "craftingFeather",
                getModItem(Witchery.ID, "ingredient", 1, 21, missing),
                getModItem(Minecraft.ID, "cauldron", 1, 0, missing),
                getModItem(Witchery.ID, "ingredient", 1, 21, missing));
        addShapedRecipe(
                getModItem(Witchery.ID, "earmuffs", 1, 0, missing),
                "screwThaumium",
                "springSteel",
                "screwThaumium",
                getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                "craftingToolWrench",
                getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                "ringThaumium",
                "craftingToolScrewdriver",
                "ringThaumium");
        addShapedRecipe(
                getModItem(Witchery.ID, "snowpressureplate", 6, 0, missing),
                "screwWood",
                "craftingToolHardHammer",
                "screwWood",
                getModItem(Railcraft.ID, "slab", 1, 3, missing),
                "springAnyIron",
                getModItem(Railcraft.ID, "slab", 1, 3, missing),
                "screwWood",
                "craftingToolScrewdriver",
                "screwWood");

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Railcraft.ID, "slab", 2, 3, missing),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.Iron, 1L),
                        GTUtility.getIntegratedCircuit(9))
                .itemOutputs(getModItem(Witchery.ID, "snowpressureplate", 2, 0, missing)).duration(5 * SECONDS).eut(8)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Railcraft.ID, "slab", 2, 3, missing),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.WroughtIron, 1),
                        GTUtility.getIntegratedCircuit(9))
                .itemOutputs(getModItem(Witchery.ID, "snowpressureplate", 2, 0, missing)).duration(5 * SECONDS).eut(8)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "bone", 1, 0, missing))
                .itemOutputs(getModItem(Witchery.ID, "ingredient", 8, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 32)).duration(5 * SECONDS).eut(24)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "bone", 1, 0, missing))
                .itemOutputs(getModItem(Witchery.ID, "ingredient", 8, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 16)).duration(5 * SECONDS).eut(24)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "bone", 1, 0, missing))
                .itemOutputs(getModItem(Witchery.ID, "ingredient", 8, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 8)).duration(2 * SECONDS + 10 * TICKS).eut(24)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "clay_ball", 1, 0, missing), ItemList.Shape_Mold_Bottle.get(0L))
                .itemOutputs(getModItem(Witchery.ID, "ingredient", 1, 26, missing)).duration(5 * SECONDS).eut(30)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Witchery.ID, "seedsbelladonna", 1, 0, missing),
                        getModItem(Witchery.ID, "seedsmandrake", 1, 0, missing),
                        getModItem(Witchery.ID, "seedsartichoke", 1, 0, missing),
                        getModItem(Witchery.ID, "seedssnowbell", 1, 0, missing))
                .itemOutputs(getModItem(Witchery.ID, "ingredient", 1, 153, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 1000)).duration(20 * SECONDS).eut(120)
                .addTo(mixerRecipes);

        ResearchCategories.registerCategory(
                "WITCHERY",
                new ResourceLocation("dreamcraft:textures/thaumcraft/icon/icon_Witchery.png"),
                new ResourceLocation("dreamcraft:textures/thaumcraft/tab/tab_Witchery.png"));
        new ResearchItem(
                "ANOINTINGPASTE",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("fabrico"), 12).add(Aspect.getAspect("aqua"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6),
                0,
                -4,
                2,
                getModItem(Witchery.ID, "ingredient", 1, 153, missing))
                        .setPages(new ResearchPage("Witchery.research_page.ANOINTINGPASTE.1")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ANOINTINGPASTE",
                getModItem(Witchery.ID, "cauldron", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 2).add(Aspect.getAspect("ignis"), 2)
                        .add(Aspect.getAspect("terra"), 2),
                "aba",
                "aca",
                "aaa",
                'b',
                getModItem(Witchery.ID, "ingredient", 1, 153, missing),
                'c',
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 0, missing));
        TCHelper.addResearchPage(
                "ANOINTINGPASTE",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findArcaneRecipe(getModItem(Witchery.ID, "cauldron", 1, 0, missing)))));
        new ResearchItem(
                "OVEN",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("machina"), 6),
                -2,
                2,
                3,
                getModItem(Witchery.ID, "witchesovenidle", 1, 0, missing))
                        .setPages(
                                new ResearchPage("Witchery.research_page.OVEN.1"),
                                new ResearchPage("Witchery.research_page.OVEN.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "OVEN",
                getModItem(Witchery.ID, "witchesovenidle", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("ignis"), 20)
                        .add(Aspect.getAspect("terra"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "plateSteel",
                'b',
                "plateThaumium",
                'c',
                "plateSteel",
                'd',
                CustomItemList.SteelBars.get(1L),
                'e',
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 0, missing),
                'f',
                CustomItemList.SteelBars.get(1L),
                'g',
                getModItem(IndustrialCraft2.ID, "blockFenceIron", 1, 0, missing),
                'h',
                getModItem(EtFuturumRequiem.ID, "blast_furnace", 1, 0, missing),
                'i',
                getModItem(IndustrialCraft2.ID, "blockFenceIron", 1, 0, missing));
        TCHelper.addResearchPage(
                "OVEN",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Witchery.ID, "witchesovenidle", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("OVEN", 1);
        new ResearchItem(
                "ATTUNEDSTONE",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("vitreus"), 12)
                        .add(Aspect.getAspect("ordo"), 9).add(Aspect.getAspect("praecantatio"), 6),
                2,
                0,
                3,
                getModItem(Witchery.ID, "ingredient", 1, 10, missing)).setParents("OVEN")
                        .setPages(new ResearchPage("Witchery.research_page.ATTUNEDSTONE")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ATTUNEDSTONE",
                getModItem(Witchery.ID, "ingredient", 1, 10, missing),
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("ignis"), 30)
                        .add(Aspect.getAspect("terra"), 30).add(Aspect.getAspect("ordo"), 30),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(Witchery.ID, "ingredient", 1, 34, missing),
                'e',
                getModItem(Botania.ID, "manaResource", 1, 2, missing),
                'h',
                getModItem(Minecraft.ID, "lava_bucket", 1, 0, missing));
        TCHelper.addResearchPage(
                "ATTUNEDSTONE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Witchery.ID, "ingredient", 1, 10, missing))));
        new ResearchItem(
                "QUARTZSPHERE",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("vitreus"), 15).add(Aspect.getAspect("instrumentum"), 12)
                        .add(Aspect.getAspect("auram"), 9).add(Aspect.getAspect("ordo"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                2,
                -2,
                3,
                getModItem(Witchery.ID, "ingredient", 1, 92, missing)).setParents("ATTUNEDSTONE")
                        .setPages(new ResearchPage("Witchery.research_page.QUARTZSPHERE")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "QUARTZSPHERE",
                getModItem(Witchery.ID, "ingredient", 1, 92, missing),
                new AspectList().add(Aspect.getAspect("aer"), 25).add(Aspect.getAspect("ignis"), 25)
                        .add(Aspect.getAspect("terra"), 25).add(Aspect.getAspect("ordo"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                "plateNetherQuartz",
                'b',
                "plateQuartzite",
                'c',
                "plateNetherQuartz",
                'd',
                "plateCertusQuartz",
                'e',
                "lensGlass",
                'f',
                "plateCertusQuartz",
                'g',
                "plateNetherQuartz",
                'h',
                "plateQuartzite",
                'i',
                "plateNetherQuartz");
        TCHelper.addResearchPage(
                "QUARTZSPHERE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Witchery.ID, "ingredient", 1, 92, missing))));
        new ResearchItem(
                "CANDELABRA",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("lux"), 12)
                        .add(Aspect.getAspect("ordo"), 9).add(Aspect.getAspect("ignis"), 6),
                0,
                -2,
                3,
                getModItem(Witchery.ID, "ingredient", 1, 0, missing)).setParents("ALTAR", "TALLOW", "ATTUNEDSTONE")
                        .setConcealed().setPages(new ResearchPage("Witchery.research_page.CANDELABRA"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CANDELABRA",
                getModItem(Witchery.ID, "ingredient", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 5).add(Aspect.getAspect("ignis"), 10)
                        .add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 0, missing),
                'b',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 0, missing),
                'c',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 0, missing),
                'd',
                "stickIron",
                'e',
                getModItem(Witchery.ID, "ingredient", 1, 10, missing),
                'f',
                "stickIron",
                'g',
                "plateIron",
                'h',
                "stickThaumium",
                'i',
                "plateIron");
        TCHelper.addResearchPage(
                "CANDELABRA",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Witchery.ID, "ingredient", 1, 0, missing))));
        new ResearchItem(
                "KETTLE",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("ignis"), 6),
                4,
                0,
                3,
                getModItem(Witchery.ID, "kettle", 1, 0, missing))
                        .setParents("ATTUNEDSTONE").setConcealed()
                        .setPages(
                                new ResearchPage("Witchery.research_page.KETTLE.1"),
                                new ResearchPage("Witchery.research_page.KETTLE.2"),
                                new ResearchPage("Witchery.research_page.KETTLE.3"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "KETTLE",
                getModItem(Witchery.ID, "kettle", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 40).add(Aspect.getAspect("ignis"), 40)
                        .add(Aspect.getAspect("aqua"), 40).add(Aspect.getAspect("perditio"), 40),
                "abc",
                "def",
                "ghi",
                'a',
                "craftingToolScrewdriver",
                'b',
                CustomItemList.SteelBars.get(1L),
                'c',
                "craftingToolHardHammer",
                'd',
                "plateSteel",
                'e',
                getModItem(Witchery.ID, "ingredient", 1, 10, missing),
                'f',
                "plateSteel",
                'g',
                "screwThaumium",
                'h',
                getModItem(Minecraft.ID, "cauldron", 1, 0, missing),
                'i',
                "screwThaumium");
        TCHelper.addResearchPage(
                "KETTLE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Witchery.ID, "kettle", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("KETTLE", 2);
        new ResearchItem(
                "SPINNINGWHEELW",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("arbor"), 18).add(Aspect.getAspect("motus"), 15)
                        .add(Aspect.getAspect("fabrico"), 12).add(Aspect.getAspect("instrumentum"), 9)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("praecantatio"), 3),
                6,
                0,
                3,
                getModItem(Witchery.ID, "spinningwheel", 1, 0, missing)).setParents("KETTLE").setConcealed()
                        .setPages(new ResearchPage("Witchery.research_page.SPINNINGWHEELW")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SPINNINGWHEELW",
                getModItem(Witchery.ID, "spinningwheel", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 60).add(Aspect.getAspect("ignis"), 60)
                        .add(Aspect.getAspect("ordo"), 60).add(Aspect.getAspect("perditio"), 60),
                "abc",
                "def",
                "ghi",
                'a',
                "stickStainlessSteel",
                'b',
                getModItem(Witchery.ID, "ingredient", 1, 10, missing),
                'c',
                "screwStainlessSteel",
                'd',
                getModItem(Minecraft.ID, "item_frame", 1, 0, missing),
                'e',
                getModItem(Minecraft.ID, "item_frame", 1, 0, missing),
                'f',
                getModItem(Minecraft.ID, "item_frame", 1, 0, missing),
                'g',
                "stickStainlessSteel",
                'h',
                "craftingToolScrewdriver",
                'i',
                "stickStainlessSteel");
        TCHelper.addResearchPage(
                "SPINNINGWHEELW",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Witchery.ID, "spinningwheel", 1, 0, missing))));
        new ResearchItem(
                "RUBYSLIPPERS",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("auram"), 21).add(Aspect.getAspect("aer"), 18)
                        .add(Aspect.getAspect("fames"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("vitreus"), 9).add(Aspect.getAspect("potentia"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                6,
                -2,
                3,
                getModItem(Witchery.ID, "rubyslippers", 1, 0, missing)).setParents("BLOODALTAR", "SPINNINGWHEELW")
                        .setConcealed()
                        .setPages(
                                new ResearchPage("Witchery.research_page.RUBYSLIPPERS.1"),
                                new ResearchPage("Witchery.research_page.RUBYSLIPPERS.2"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "RUBYSLIPPERS",
                getModItem(Witchery.ID, "rubyslippers", 1, 0, missing),
                5,
                new AspectList().add(Aspect.getAspect("auram"), 64).add(Aspect.getAspect("aer"), 64)
                        .add(Aspect.getAspect("lucrum"), 32).add(Aspect.getAspect("potentia"), 16)
                        .add(Aspect.getAspect("praecantatio"), 16).add(Aspect.getAspect("fames"), 32),
                getModItem(Witchery.ID, "seepingshoes", 1, 0, missing),
                getModItem(Witchery.ID, "ingredient", 1, 80, missing),
                CustomItemList.ManyullynCrystal.get(1L),
                getModItem(Witchery.ID, "ingredient", 1, 34, missing),
                getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0, missing),
                CustomItemList.ManyullynCrystal.get(1L),
                getModItem(Witchery.ID, "ingredient", 1, 80, missing),
                CustomItemList.ManyullynCrystal.get(1L),
                getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0, missing),
                getModItem(Witchery.ID, "ingredient", 1, 34, missing),
                CustomItemList.ManyullynCrystal.get(1L));
        TCHelper.addResearchPage(
                "RUBYSLIPPERS",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Witchery.ID, "rubyslippers", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("RUBYSLIPPERS", 5);
        new ResearchItem(
                "DISTILLERY",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("metallum"), 18).add(Aspect.getAspect("motus"), 15)
                        .add(Aspect.getAspect("fabrico"), 12).add(Aspect.getAspect("instrumentum"), 9)
                        .add(Aspect.getAspect("aqua"), 6).add(Aspect.getAspect("praecantatio"), 3),
                8,
                0,
                3,
                getModItem(Witchery.ID, "distilleryidle", 1, 0, missing)).setParents("SPINNINGWHEELW").setConcealed()
                        .setPages(new ResearchPage("Witchery.research_page.DISTILLERY")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DISTILLERY",
                getModItem(Witchery.ID, "distilleryidle", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 80).add(Aspect.getAspect("ignis"), 80)
                        .add(Aspect.getAspect("ordo"), 80).add(Aspect.getAspect("perditio"), 80)
                        .add(Aspect.getAspect("aqua"), 80),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Witchery.ID, "ingredient", 1, 27, missing),
                'b',
                getModItem(Witchery.ID, "ingredient", 1, 10, missing),
                'c',
                getModItem(Witchery.ID, "ingredient", 1, 27, missing),
                'd',
                "pipeSmallStainlessSteel",
                'e',
                getModItem(Witchery.ID, "cauldron", 1, 0, missing),
                'f',
                "pipeSmallStainlessSteel",
                'g',
                "plateDenseThaumium",
                'h',
                "craftingIronFurnace",
                'i',
                "plateDenseThaumium");
        TCHelper.addResearchPage(
                "DISTILLERY",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Witchery.ID, "distilleryidle", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("DISTILLERY", 3);
        new ResearchItem(
                "RITUALCHALK",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("sensus"), 18).add(Aspect.getAspect("motus"), 15)
                        .add(Aspect.getAspect("auram"), 12).add(Aspect.getAspect("potentia"), 9)
                        .add(Aspect.getAspect("iter"), 6).add(Aspect.getAspect("praecantatio"), 3),
                8,
                -2,
                3,
                getModItem(Witchery.ID, "chalkritual", 1, 0, missing))
                        .setParents("DISTILLERY").setConcealed()
                        .setPages(
                                new ResearchPage("Witchery.research_page.RITUALCHALK.1"),
                                new ResearchPage("Witchery.research_page.RITUALCHALK.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RITUALCHALK",
                getModItem(Witchery.ID, "chalkritual", 2, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 50).add(Aspect.getAspect("terra"), 50)
                        .add(Aspect.getAspect("ordo"), 25).add(Aspect.getAspect("ignis"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Witchery.ID, "ingredient", 1, 18, missing),
                'b',
                getModItem(Witchery.ID, "ingredient", 1, 37, missing),
                'c',
                getModItem(Witchery.ID, "ingredient", 1, 18, missing),
                'd',
                getModItem(Witchery.ID, "ingredient", 1, 18, missing),
                'e',
                getModItem(Witchery.ID, "ingredient", 1, 17, missing),
                'f',
                getModItem(Witchery.ID, "ingredient", 1, 18, missing),
                'g',
                getModItem(Witchery.ID, "ingredient", 1, 18, missing),
                'h',
                getModItem(Witchery.ID, "ingredient", 1, 17, missing),
                'i',
                getModItem(Witchery.ID, "ingredient", 1, 18, missing));
        TCHelper.addResearchPage(
                "RITUALCHALK",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Witchery.ID, "chalkritual", 1, 0, missing))));
        new ResearchItem(
                "CIRCLETALISMAN",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("lucrum"), 18).add(Aspect.getAspect("motus"), 15)
                        .add(Aspect.getAspect("auram"), 12).add(Aspect.getAspect("potentia"), 9)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("praecantatio"), 3),
                10,
                -2,
                3,
                getModItem(Witchery.ID, "circletalisman", 1, 0, missing))
                        .setParents("RITUALCHALK").setConcealed()
                        .setPages(
                                new ResearchPage("Witchery.research_page.CIRCLETALISMAN.1"),
                                new ResearchPage("Witchery.research_page.CIRCLETALISMAN.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CIRCLETALISMAN",
                getModItem(Witchery.ID, "circletalisman", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("terra"), 50)
                        .add(Aspect.getAspect("ignis"), 50),
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
                "gemExquisiteDiamond",
                'f',
                "stickGold",
                'g',
                "screwGold",
                'h',
                "stickGold",
                'i',
                "screwGold");
        TCHelper.addResearchPage(
                "CIRCLETALISMAN",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Witchery.ID, "circletalisman", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("CIRCLETALISMAN", 1);
        new ResearchItem(
                "ALTAR",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("arbor"), 9).add(Aspect.getAspect("terra"), 6),
                -2,
                0,
                3,
                getModItem(Witchery.ID, "altar", 1, 0, missing))
                        .setParents("OVEN", "ARCANESTONE").setConcealed()
                        .setPages(
                                new ResearchPage("Witchery.research_page.ALTAR.1"),
                                new ResearchPage("Witchery.research_page.ALTAR.2"),
                                new ResearchPage("Witchery.research_page.ALTAR.3"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ALTAR",
                getModItem(Witchery.ID, "altar", 2, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 20).add(Aspect.getAspect("ignis"), 20)
                        .add(Aspect.getAspect("ordo"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Witchery.ID, "ingredient", 1, 32, missing),
                'b',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6, missing),
                'c',
                getModItem(Witchery.ID, "ingredient", 1, 31, missing),
                'd',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7, missing),
                'e',
                getModItem(Witchery.ID, "witchlog", 1, 0, missing),
                'f',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7, missing),
                'g',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7, missing),
                'h',
                getModItem(Witchery.ID, "witchlog", 1, 0, missing),
                'i',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7, missing));
        TCHelper.addResearchPage(
                "ALTAR",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Witchery.ID, "altar", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("ALTAR", 2);
        new ResearchItem(
                "CHALICE",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("terra"), 6),
                0,
                0,
                3,
                getModItem(Witchery.ID, "ingredient", 1, 1, missing)).setParents("ALTAR", "ATTUNEDSTONE").setConcealed()
                        .setPages(new ResearchPage("Witchery.research_page.CHALICE")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CHALICE",
                getModItem(Witchery.ID, "ingredient", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 15).add(Aspect.getAspect("terra"), 10)
                        .add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "foilGold",
                'b',
                getModItem(Witchery.ID, "ingredient", 1, 10, missing),
                'c',
                "foilGold",
                'd',
                "plateGold",
                'e',
                "plateGold",
                'f',
                "plateGold",
                'g',
                "foilThaumium",
                'h',
                "ingotGold",
                'i',
                "foilThaumium");
        TCHelper.addResearchPage(
                "CHALICE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Witchery.ID, "ingredient", 1, 1, missing))));
        new ResearchItem(
                "ARTHANA",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("mortuus"), 6),
                -4,
                -2,
                3,
                getModItem(Witchery.ID, "arthana", 1, 0, missing))
                        .setParents("ALTAR").setConcealed()
                        .setPages(
                                new ResearchPage("Witchery.research_page.ARTHANA.1"),
                                new ResearchPage("Witchery.research_page.ARTHANA.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ARTHANA",
                getModItem(Witchery.ID, "arthana", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 20).add(Aspect.getAspect("perditio"), 15)
                        .add(Aspect.getAspect("ordo"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TinkerConstruct.ID, "handGuard", 1, 16, missing),
                'b',
                "craftingToolScrewdriver",
                'c',
                getModItem(TinkerConstruct.ID, "knifeBlade", 1, 202, missing),
                'd',
                "screwThaumium",
                'e',
                "gemEmerald",
                'f',
                "craftingToolHardHammer",
                'g',
                getModItem(TinkerConstruct.ID, "toolRod", 1, 6, missing),
                'h',
                "screwThaumium",
                'i',
                getModItem(TinkerConstruct.ID, "handGuard", 1, 16, missing));
        TCHelper.addResearchPage(
                "ARTHANA",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Witchery.ID, "arthana", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("ARTHANA", 2);
        new ResearchItem(
                "WARMBLOOD",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("fames"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("aqua"), 9).add(Aspect.getAspect("exanimis"), 6),
                -2,
                -2,
                3,
                getModItem(Witchery.ID, "ingredient", 1, 163, missing)).setParents("ALTAR").setConcealed()
                        .setPages(new ResearchPage("Witchery.research_page.WARMBLOOD")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "WARMBLOOD",
                getModItem(Witchery.ID, "ingredient", 1, 163, missing),
                getModItem(TinkerConstruct.ID, "jerky", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("exanimis"), 4).add(Aspect.getAspect("fames"), 4)
                        .add(Aspect.getAspect("lucrum"), 4));
        TCHelper.addResearchPage(
                "WARMBLOOD",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(Witchery.ID, "ingredient", 1, 163, missing))));
        ThaumcraftApi.addWarpToResearch("WARMBLOOD", 3);
        new ResearchItem(
                "FUMEFUNNEL",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("ignis"), 12)
                        .add(Aspect.getAspect("lux"), 9).add(Aspect.getAspect("sensus"), 6),
                0,
                2,
                3,
                getModItem(Witchery.ID, "fumefunnel", 1, 0, missing)).setParents("OVEN").setConcealed()
                        .setPages(new ResearchPage("Witchery.research_page.FUMEFUNNEL")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FUMEFUNNEL",
                getModItem(Witchery.ID, "fumefunnel", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("ignis"), 30)
                        .add(Aspect.getAspect("terra"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                "plateThaumium",
                'b',
                CustomItemList.SteelBars.get(1L),
                'c',
                "plateThaumium",
                'd',
                "plateGlowstone",
                'e',
                "bucketLava",
                'f',
                "plateGlowstone",
                'g',
                "blockSteel",
                'h',
                CustomItemList.SteelBars.get(1L),
                'i',
                "blockSteel");
        TCHelper.addResearchPage(
                "FUMEFUNNEL",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Witchery.ID, "fumefunnel", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("FUMEFUNNEL", 1);
        new ResearchItem(
                "FUMEFILTER",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("vitreus"), 9)
                        .add(Aspect.getAspect("lucrum"), 6).add(Aspect.getAspect("praecantatio"), 3),
                2,
                2,
                3,
                getModItem(Witchery.ID, "ingredient", 1, 73, missing))
                        .setParents("DISTILESSENTIA", "FUMEFUNNEL", "ATTUNEDSTONE").setConcealed()
                        .setPages(new ResearchPage("Witchery.research_page.FUMEFILTER")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FUMEFILTER",
                getModItem(Witchery.ID, "ingredient", 1, 73, missing),
                new AspectList().add(Aspect.getAspect("aer"), 16).add(Aspect.getAspect("ordo"), 16)
                        .add(Aspect.getAspect("terra"), 16),
                "abc",
                "def",
                "ghi",
                'a',
                "paneGlass",
                'b',
                "paneGlass",
                'c',
                "paneGlass",
                'd',
                "plateThaumium",
                'e',
                getModItem(Witchery.ID, "ingredient", 1, 10, missing),
                'f',
                "plateThaumium",
                'g',
                "paneGlass",
                'h',
                "paneGlass",
                'i',
                "paneGlass");
        TCHelper.addResearchPage(
                "FUMEFILTER",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Witchery.ID, "ingredient", 1, 73, missing))));
        new ResearchItem(
                "FILTEREDFUMEFUNNEL",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("vitreus"), 12)
                        .add(Aspect.getAspect("lux"), 9).add(Aspect.getAspect("praecantatio"), 6),
                2,
                4,
                3,
                getModItem(Witchery.ID, "filteredfumefunnel", 1, 0, missing)).setParents("FUMEFILTER").setConcealed()
                        .setPages(new ResearchPage("Witchery.research_page.FILTEREDFUMEFUNNEL")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "FILTEREDFUMEFUNNEL",
                getModItem(Witchery.ID, "filteredfumefunnel", 1, 0, missing),
                3,
                new AspectList().add(Aspect.getAspect("metallum"), 32).add(Aspect.getAspect("vitreus"), 8)
                        .add(Aspect.getAspect("praecantatio"), 24).add(Aspect.getAspect("lux"), 16),
                getModItem(Witchery.ID, "fumefunnel", 1, 0, missing),
                CustomItemList.SteelBars.get(1L),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 8, missing),
                CustomItemList.SteelBars.get(1L),
                getModItem(Witchery.ID, "ingredient", 1, 73, missing),
                CustomItemList.SteelBars.get(1L),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 8, missing));
        TCHelper.addResearchPage(
                "FILTEREDFUMEFUNNEL",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(Witchery.ID, "filteredfumefunnel", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("FILTEREDFUMEFUNNEL", 2);
        new ResearchItem(
                "WAYSTONE",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("motus"), 15).add(Aspect.getAspect("iter"), 12)
                        .add(Aspect.getAspect("tenebrae"), 9).add(Aspect.getAspect("praecantatio"), 6),
                8,
                -4,
                3,
                getModItem(Witchery.ID, "ingredient", 1, 12, missing)).setParents("RITUALCHALK").setConcealed()
                        .setPages(new ResearchPage("Witchery.research_page.WAYSTONE")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "WAYSTONE",
                getModItem(Witchery.ID, "ingredient", 1, 12, missing),
                5,
                new AspectList().add(Aspect.getAspect("motus"), 48).add(Aspect.getAspect("iter"), 64)
                        .add(Aspect.getAspect("praecantatio"), 24).add(Aspect.getAspect("tenebrae"), 32)
                        .add(Aspect.getAspect("aer"), 64),
                getModItem(Minecraft.ID, "flint", 1, 0, missing),
                getModItem(Witchery.ID, "chalkritual", 1, 0, missing),
                getModItem(Witchery.ID, "ingredient", 1, 7, missing),
                getModItem(Witchery.ID, "chalkotherwhere", 1, 0, missing),
                getModItem(Witchery.ID, "ingredient", 1, 7, missing),
                getModItem(Witchery.ID, "chalkritual", 1, 0, missing),
                getModItem(Witchery.ID, "ingredient", 1, 7, missing),
                getModItem(Witchery.ID, "chalkotherwhere", 1, 0, missing),
                getModItem(Witchery.ID, "ingredient", 1, 7, missing));
        TCHelper.addResearchPage(
                "WAYSTONE",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Witchery.ID, "ingredient", 1, 12, missing))));
        ThaumcraftApi.addWarpToResearch("WAYSTONE", 5);
    }
}
