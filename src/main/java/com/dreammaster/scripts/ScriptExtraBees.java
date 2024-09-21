package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.ExtraBees;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.MagicBees;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.forestry.ForestryHelper;
import com.dreammaster.thaumcraft.TCHelper;

import forestry.api.recipes.RecipeManagers;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ScriptExtraBees implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Extra Bees";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                ExtraBees.ID,
                Thaumcraft.ID,
                MagicBees.ID,
                Forestry.ID,
                PamsHarvestCraft.ID,
                IndustrialCraft2.ID);
    }

    @Override
    public void loadRecipes() {

        addShapelessRecipe(
                getModItem(ExtraBees.ID, "dictionary", 1, 0, missing),
                getModItem(ExtraBees.ID, "dictionary", 1, 0, missing));

        ForestryHelper.removeCarpenterRecipe(getModItem(ExtraBees.ID, "dictionary", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(ExtraBees.ID, "misc", 1, 0, missing));
        ForestryHelper.removeSqueezerRecipe(
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(ExtraBees.ID, "honeyDrop", 1, 8, missing));
        ForestryHelper.removeSqueezerRecipe(
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(ExtraBees.ID, "honeyDrop", 1, 9, missing));
        ForestryHelper.removeSqueezerRecipe(
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(ExtraBees.ID, "honeyDrop", 1, 10, missing));
        ForestryHelper.removeSqueezerRecipe(
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(ExtraBees.ID, "honeyDrop", 1, 11, missing));
        ForestryHelper.removeSqueezerRecipe(
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(ExtraBees.ID, "honeyDrop", 1, 12, missing));
        ForestryHelper.removeSqueezerRecipe(
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(ExtraBees.ID, "honeyDrop", 1, 13, missing));
        ForestryHelper.removeSqueezerRecipe(
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(ExtraBees.ID, "honeyDrop", 1, 14, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 1440),
                getModItem(Forestry.ID, "beealyzer", 1, wildcard, missing),
                getModItem(ExtraBees.ID, "dictionary", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Diamond, 1L),
                'b',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Emerald, 1L),
                'c',
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Diamond, 1L),
                'd',
                "itemCasingGold",
                'e',
                "circuitAdvanced",
                'f',
                "itemCasingGold",
                'g',
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Diamond, 1L),
                'h',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                'i',
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Diamond, 1L));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 7500),
                getModItem(Forestry.ID, "alveary", 1, 0, missing),
                getModItem(ExtraBees.ID, "alveary", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 12, missing),
                'b',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 1L),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 12, missing),
                'd',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 1L),
                'e',
                getModItem(ExtraBees.ID, "hiveFrame.soul", 1, 0, missing),
                'f',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 1L),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 12, missing),
                'h',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 1L),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 12, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 7500),
                getModItem(Forestry.ID, "alveary", 1, 0, missing),
                getModItem(ExtraBees.ID, "alveary", 1, 1, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 10, missing),
                'b',
                getModItem(Forestry.ID, "frameProven", 1, 0, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 10, missing),
                'd',
                getModItem(Forestry.ID, "frameProven", 1, 0, missing),
                'e',
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.WoodSealed, 1L),
                'f',
                getModItem(Forestry.ID, "frameProven", 1, 0, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 10, missing),
                'h',
                getModItem(Forestry.ID, "frameProven", 1, 0, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 10, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 7500),
                getModItem(Forestry.ID, "alveary", 1, 0, missing),
                getModItem(ExtraBees.ID, "alveary", 1, 2, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 8, missing),
                'b',
                getModItem(IndustrialCraft2.ID, "blockRubber", 1, 0, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 8, missing),
                'd',
                getModItem(IndustrialCraft2.ID, "blockRubber", 1, 0, missing),
                'e',
                getModItem(Minecraft.ID, "brick_block", 1, 0, missing),
                'f',
                getModItem(IndustrialCraft2.ID, "blockRubber", 1, 0, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 8, missing),
                'h',
                getModItem(IndustrialCraft2.ID, "blockRubber", 1, 0, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 8, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 7500),
                getModItem(Forestry.ID, "alveary", 1, 0, missing),
                getModItem(ExtraBees.ID, "alveary", 1, 3, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'b',
                getModItem(Minecraft.ID, "stained_glass", 1, wildcard, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'd',
                getModItem(Minecraft.ID, "stained_glass", 1, wildcard, missing),
                'e',
                getModItem(Minecraft.ID, "redstone_lamp", 1, 0, missing),
                'f',
                getModItem(Minecraft.ID, "stained_glass", 1, wildcard, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'h',
                getModItem(Minecraft.ID, "stained_glass", 1, wildcard, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 7500),
                getModItem(Forestry.ID, "alveary", 1, 0, missing),
                getModItem(ExtraBees.ID, "alveary", 1, 4, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'b',
                GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Silver, 1L),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'd',
                getModItem(Forestry.ID, "chipsets", 1, 2, missing),
                'e',
                ItemList.Electric_Motor_HV.get(1L),
                'f',
                getModItem(Forestry.ID, "chipsets", 1, 2, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'h',
                GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Silver, 1L),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 7500),
                getModItem(Forestry.ID, "alveary", 1, 0, missing),
                getModItem(ExtraBees.ID, "alveary", 1, 5, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 3, missing),
                'b',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Redstone, 1L),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 3, missing),
                'd',
                ItemList.Conveyor_Module_MV.get(1L),
                'e',
                getModItem(Forestry.ID, "apiculture", 1, 0, missing),
                'f',
                ItemList.Conveyor_Module_MV.get(1L),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 3, missing),
                'h',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Redstone, 1L),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 3, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 7500),
                getModItem(Forestry.ID, "alveary", 1, 0, missing),
                getModItem(ExtraBees.ID, "alveary", 1, 6, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 0, missing),
                'b',
                "circuitAdvanced",
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 0, missing),
                'd',
                GTOreDictUnificator.get(OrePrefixes.cableGt02, Materials.Aluminium, 1L),
                'e',
                ItemList.Hull_HV.get(1L),
                'f',
                GTOreDictUnificator.get(OrePrefixes.cableGt02, Materials.Aluminium, 1L),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 0, missing),
                'h',
                GTOreDictUnificator.get(OrePrefixes.cableGt02, Materials.Aluminium, 1L),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 7500),
                getModItem(Forestry.ID, "alveary", 1, 0, missing),
                getModItem(ExtraBees.ID, "alveary", 1, 7, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 8, missing),
                'b',
                getModItem(ExtraUtilities.ID, "curtains", 1, 0, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 8, missing),
                'd',
                getModItem(ExtraUtilities.ID, "curtains", 1, 0, missing),
                'e',
                getModItem(Minecraft.ID, "wool", 1, 15, missing),
                'f',
                getModItem(ExtraUtilities.ID, "curtains", 1, 0, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 8, missing),
                'h',
                getModItem(ExtraUtilities.ID, "curtains", 1, 0, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 8, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("for.honey", 1000),
                GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.WoodSealed, 1L),
                getModItem(ExtraBees.ID, "misc", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "beeswax", 1, 0, missing),
                'b',
                getModItem(Forestry.ID, "pollen", 1, 0, missing),
                'c',
                getModItem(Forestry.ID, "beeswax", 1, 2, missing),
                'd',
                getModItem(Forestry.ID, "royalJelly", 1, 0, missing),
                'e',
                getModItem(Forestry.ID, "beeswax", 1, 0, missing),
                'f',
                getModItem(Forestry.ID, "royalJelly", 1, 0, missing),
                'g',
                getModItem(Forestry.ID, "beeswax", 1, 2, missing),
                'h',
                getModItem(Forestry.ID, "pollen", 1, 0, missing),
                'i',
                getModItem(Forestry.ID, "beeswax", 1, 2, missing));
        RecipeManagers.squeezerManager.addRecipe(
                20,
                new ItemStack[] { getModItem(ExtraBees.ID, "honeyDrop", 1, 8, missing), },
                FluidRegistry.getFluidStack("for.honey", 200),
                ItemList.Color_01.get(1L),
                100);
        RecipeManagers.squeezerManager.addRecipe(
                20,
                new ItemStack[] { getModItem(ExtraBees.ID, "honeyDrop", 1, 9, missing), },
                FluidRegistry.getFluidStack("for.honey", 200),
                ItemList.Color_11.get(1L),
                100);
        RecipeManagers.squeezerManager.addRecipe(
                20,
                new ItemStack[] { getModItem(ExtraBees.ID, "honeyDrop", 1, 10, missing), },
                FluidRegistry.getFluidStack("for.honey", 200),
                ItemList.Color_04.get(1L),
                100);
        RecipeManagers.squeezerManager.addRecipe(
                20,
                new ItemStack[] { getModItem(ExtraBees.ID, "honeyDrop", 1, 11, missing), },
                FluidRegistry.getFluidStack("for.honey", 200),
                ItemList.Color_02.get(1L),
                100);
        RecipeManagers.squeezerManager.addRecipe(
                20,
                new ItemStack[] { getModItem(ExtraBees.ID, "honeyDrop", 1, 13, missing), },
                FluidRegistry.getFluidStack("for.honey", 200),
                ItemList.Color_15.get(1L),
                100);
        RecipeManagers.squeezerManager.addRecipe(
                20,
                new ItemStack[] { getModItem(ExtraBees.ID, "honeyDrop", 1, 12, missing), },
                FluidRegistry.getFluidStack("for.honey", 200),
                ItemList.Color_00.get(1L),
                100);
        RecipeManagers.squeezerManager.addRecipe(
                20,
                new ItemStack[] { getModItem(ExtraBees.ID, "honeyDrop", 1, 14, missing), },
                FluidRegistry.getFluidStack("for.honey", 200),
                ItemList.Color_03.get(1L),
                100);

        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraBees.ID, "misc", 1, 1, missing))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Diamond, 1L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

        new ResearchItem(
                "HEALINGFRAME",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("victus"), 6),
                7,
                -2,
                3,
                getModItem(ExtraBees.ID, "hiveFrame.clay", 1, 0, missing)).setParents("MB_EssenceLife").setConcealed()
                        .setPages(new ResearchPage("ExtraBees.research_page.HEALINGFRAME")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "HEALINGFRAME",
                getModItem(ExtraBees.ID, "hiveFrame.clay", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("terra"), 4)
                        .add(Aspect.getAspect("aer"), 4).add(Aspect.getAspect("perditio"), 4)
                        .add(Aspect.getAspect("ignis"), 4).add(Aspect.getAspect("aqua"), 4),
                "abc",
                "def",
                "ghi",
                'a',
                "screwIron",
                'b',
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L),
                'c',
                "screwIron",
                'd',
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L),
                'e',
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                'f',
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L),
                'g',
                "screwIron",
                'h',
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L),
                'i',
                "screwIron");
        TCHelper.addResearchPage(
                "HEALINGFRAME",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ExtraBees.ID, "hiveFrame.clay", 1, 0, missing))));
        new ResearchItem(
                "CHOCOLATEFRAME",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("fames"), 6),
                7,
                2,
                3,
                getModItem(ExtraBees.ID, "hiveFrame.cocoa", 1, 0, missing)).setParents("MB_EssenceUnstable")
                        .setConcealed()
                        .setPages(
                                new ResearchPage("ExtraBees.research_page.CHOCOLATEFRAME_1"),
                                new ResearchPage("ExtraBees.research_page.CHOCOLATEFRAME_2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CHOCOLATEFRAME",
                getModItem(ExtraBees.ID, "hiveFrame.cocoa", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("terra"), 4)
                        .add(Aspect.getAspect("aer"), 4).add(Aspect.getAspect("perditio"), 4)
                        .add(Aspect.getAspect("ignis"), 4).add(Aspect.getAspect("aqua"), 4),
                "abc",
                "def",
                "ghi",
                'a',
                "screwIron",
                'b',
                getModItem(Minecraft.ID, "sugar", 1, 0, missing),
                'c',
                "screwIron",
                'd',
                getModItem(PamsHarvestCraft.ID, "cocoapowderItem", 1, 0, missing),
                'e',
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                'f',
                getModItem(PamsHarvestCraft.ID, "cocoapowderItem", 1, 0, missing),
                'g',
                "screwIron",
                'h',
                getModItem(Minecraft.ID, "sugar", 1, 0, missing),
                'i',
                "screwIron");
        TCHelper.addResearchPage(
                "CHOCOLATEFRAME",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ExtraBees.ID, "hiveFrame.cocoa", 1, 0, missing))));
        new ResearchItem(
                "RESTRAINTFRAME",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("metallum"), 6),
                9,
                0,
                3,
                getModItem(ExtraBees.ID, "hiveFrame.cage", 1, 0, missing))
                        .setParents("PROVENFRAME", "HEALINGFRAME", "CHOCOLATEFRAME").setConcealed()
                        .setPages(new ResearchPage("ExtraBees.research_page.RESTRAINTFRAME")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RESTRAINTFRAME",
                getModItem(ExtraBees.ID, "hiveFrame.cage", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 8).add(Aspect.getAspect("terra"), 8)
                        .add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("perditio"), 8)
                        .add(Aspect.getAspect("ignis"), 8).add(Aspect.getAspect("aqua"), 8),
                "abc",
                "def",
                "ghi",
                'a',
                "screwSteel",
                'b',
                "barsIron",
                'c',
                "screwSteel",
                'd',
                "barsIron",
                'e',
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                'f',
                "barsIron",
                'g',
                "screwSteel",
                'h',
                "barsIron",
                'i',
                "screwSteel");
        TCHelper.addResearchPage(
                "RESTRAINTFRAME",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ExtraBees.ID, "hiveFrame.cage", 1, 0, missing))));
        new ResearchItem(
                "SOULFRAME",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("spiritus"), 6),
                11,
                0,
                3,
                getModItem(ExtraBees.ID, "hiveFrame.soul", 1, 0, missing)).setParents("RESTRAINTFRAME").setConcealed()
                        .setPages(new ResearchPage("ExtraBees.research_page.SOULFRAME")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SOULFRAME",
                getModItem(ExtraBees.ID, "hiveFrame.soul", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 16).add(Aspect.getAspect("terra"), 16)
                        .add(Aspect.getAspect("aer"), 16).add(Aspect.getAspect("perditio"), 16)
                        .add(Aspect.getAspect("ignis"), 16).add(Aspect.getAspect("aqua"), 16),
                "abc",
                "def",
                "ghi",
                'a',
                "screwAluminium",
                'b',
                getModItem(Minecraft.ID, "soul_sand", 1, 0, missing),
                'c',
                "screwAluminium",
                'd',
                getModItem(Minecraft.ID, "soul_sand", 1, 0, missing),
                'e',
                getModItem(ExtraBees.ID, "hiveFrame.cage", 1, 0, missing),
                'f',
                getModItem(Minecraft.ID, "soul_sand", 1, 0, missing),
                'g',
                "screwAluminium",
                'h',
                getModItem(Minecraft.ID, "soul_sand", 1, 0, missing),
                'i',
                "screwAluminium");
        TCHelper.addResearchPage(
                "SOULFRAME",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ExtraBees.ID, "hiveFrame.soul", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("SOULFRAME", 1);
    }
}
