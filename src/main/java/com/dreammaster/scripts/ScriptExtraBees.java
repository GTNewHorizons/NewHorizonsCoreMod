package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.ExtraBees;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.MagicBees;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.forestry.ForestryHelper;
import com.dreammaster.thaumcraft.TCHelper;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import forestry.api.recipes.RecipeManagers;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.Mods;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;
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
    public List<Mods> getDependencies() {
        return Arrays
                .asList(ExtraBees, ExtraUtilities, Forestry, IndustrialCraft2, MagicBees, PamsHarvestCraft, Thaumcraft);
    }

    @Override
    public void loadRecipes() {

        addShapelessRecipe(getModItem(ExtraBees.ID, "dictionary", 1, 0), getModItem(ExtraBees.ID, "dictionary", 1, 0));

        ForestryHelper.removeCarpenterRecipe(getModItem(ExtraBees.ID, "dictionary", 1, 0));
        ForestryHelper.removeCarpenterRecipe(getModItem(ExtraBees.ID, "misc", 1, 0));
        ForestryHelper.removeSqueezerRecipe(
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(ExtraBees.ID, "honeyDrop", 1, 8));
        ForestryHelper.removeSqueezerRecipe(
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(ExtraBees.ID, "honeyDrop", 1, 9));
        ForestryHelper.removeSqueezerRecipe(
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(ExtraBees.ID, "honeyDrop", 1, 10));
        ForestryHelper.removeSqueezerRecipe(
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(ExtraBees.ID, "honeyDrop", 1, 11));
        ForestryHelper.removeSqueezerRecipe(
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(ExtraBees.ID, "honeyDrop", 1, 12));
        ForestryHelper.removeSqueezerRecipe(
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(ExtraBees.ID, "honeyDrop", 1, 13));
        ForestryHelper.removeSqueezerRecipe(
                FluidRegistry.getFluidStack("for.honey", 200),
                getModItem(ExtraBees.ID, "honeyDrop", 1, 14));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 1440),
                getModItem(Forestry.ID, "beealyzer", 1, wildcard),
                getModItem(ExtraBees.ID, "dictionary", 1, 0),
                "abc",
                "def",
                "ghi",
                'a',
                MaterialLibAPI.getStack(Materials2Materials.Diamond, Materials2Shapes.shapeScrew, (int) (1L)),
                'b',
                MaterialLibAPI.getStack(Materials2Materials.Emerald, Materials2Shapes.shapePlate, (int) (1L)),
                'c',
                MaterialLibAPI.getStack(Materials2Materials.Diamond, Materials2Shapes.shapeScrew, (int) (1L)),
                'd',
                "itemCasingGold",
                'e',
                "circuitAdvanced",
                'f',
                "itemCasingGold",
                'g',
                MaterialLibAPI.getStack(Materials2Materials.Diamond, Materials2Shapes.shapeScrew, (int) (1L)),
                'h',
                MaterialLibAPI.getStack(Materials2Materials.Diamond, Materials2Shapes.shapePlate, (int) (1L)),
                'i',
                MaterialLibAPI.getStack(Materials2Materials.Diamond, Materials2Shapes.shapeScrew, (int) (1L)));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 7500),
                getModItem(Forestry.ID, "alveary", 1, 0),
                getModItem(ExtraBees.ID, "alveary", 1, 0),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 12),
                'b',
                MaterialLibAPI.getStack(Materials2Materials.EnderEye, Materials2Shapes.shapePlate, (int) (1L)),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 12),
                'd',
                MaterialLibAPI.getStack(Materials2Materials.EnderPearl, Materials2Shapes.shapePlate, (int) (1L)),
                'e',
                getModItem(ExtraBees.ID, "hiveFrame.soul", 1, 0),
                'f',
                MaterialLibAPI.getStack(Materials2Materials.EnderPearl, Materials2Shapes.shapePlate, (int) (1L)),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 12),
                'h',
                MaterialLibAPI.getStack(Materials2Materials.EnderEye, Materials2Shapes.shapePlate, (int) (1L)),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 12));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 7500),
                getModItem(Forestry.ID, "alveary", 1, 0),
                getModItem(ExtraBees.ID, "alveary", 1, 1),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 10),
                'b',
                getModItem(Forestry.ID, "frameProven", 1, 0),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 10),
                'd',
                getModItem(Forestry.ID, "frameProven", 1, 0),
                'e',
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.WoodSealed, 1L),
                'f',
                getModItem(Forestry.ID, "frameProven", 1, 0),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 10),
                'h',
                getModItem(Forestry.ID, "frameProven", 1, 0),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 10));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 7500),
                getModItem(Forestry.ID, "alveary", 1, 0),
                getModItem(ExtraBees.ID, "alveary", 1, 2),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 8),
                'b',
                ItemList.PadBouncy.get(1L),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 8),
                'd',
                ItemList.PadBouncy.get(1L),
                'e',
                getModItem(Minecraft.ID, "brick_block", 1, 0),
                'f',
                ItemList.PadBouncy.get(1L),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 8),
                'h',
                ItemList.PadBouncy.get(1L),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 8));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 7500),
                getModItem(Forestry.ID, "alveary", 1, 0),
                getModItem(ExtraBees.ID, "alveary", 1, 3),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2),
                'b',
                getModItem(Minecraft.ID, "stained_glass", 1, wildcard),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2),
                'd',
                getModItem(Minecraft.ID, "stained_glass", 1, wildcard),
                'e',
                getModItem(Minecraft.ID, "redstone_lamp", 1, 0),
                'f',
                getModItem(Minecraft.ID, "stained_glass", 1, wildcard),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2),
                'h',
                getModItem(Minecraft.ID, "stained_glass", 1, wildcard),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 7500),
                getModItem(Forestry.ID, "alveary", 1, 0),
                getModItem(ExtraBees.ID, "alveary", 1, 4),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1),
                'b',
                GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Silver, 1L),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1),
                'd',
                getModItem(Forestry.ID, "chipsets", 1, 2),
                'e',
                ItemList.Electric_Motor_HV.get(1L),
                'f',
                getModItem(Forestry.ID, "chipsets", 1, 2),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1),
                'h',
                GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Silver, 1L),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 7500),
                getModItem(Forestry.ID, "alveary", 1, 0),
                getModItem(ExtraBees.ID, "alveary", 1, 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 3),
                'b',
                MaterialLibAPI.getStack(Materials2Materials.Redstone, Materials2Shapes.shapePlate, (int) (1L)),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 3),
                'd',
                ItemList.Conveyor_Module_MV.get(1L),
                'e',
                getModItem(Forestry.ID, "apiculture", 1, 0),
                'f',
                ItemList.Conveyor_Module_MV.get(1L),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 3),
                'h',
                MaterialLibAPI.getStack(Materials2Materials.Redstone, Materials2Shapes.shapePlate, (int) (1L)),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 3));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 7500),
                getModItem(Forestry.ID, "alveary", 1, 0),
                getModItem(ExtraBees.ID, "alveary", 1, 6),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 0),
                'b',
                "circuitAdvanced",
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 0),
                'd',
                GTOreDictUnificator.get(OrePrefixes.cableGt02, Materials.Aluminium, 1L),
                'e',
                ItemList.Hull_HV.get(1L),
                'f',
                GTOreDictUnificator.get(OrePrefixes.cableGt02, Materials.Aluminium, 1L),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 0),
                'h',
                GTOreDictUnificator.get(OrePrefixes.cableGt02, Materials.Aluminium, 1L),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 0));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 7500),
                getModItem(Forestry.ID, "alveary", 1, 0),
                getModItem(ExtraBees.ID, "alveary", 1, 7),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 8),
                'b',
                getModItem(ExtraUtilities.ID, "curtains", 1, 0),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 8),
                'd',
                getModItem(ExtraUtilities.ID, "curtains", 1, 0),
                'e',
                getModItem(Minecraft.ID, "wool", 1, 15),
                'f',
                getModItem(ExtraUtilities.ID, "curtains", 1, 0),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 8),
                'h',
                getModItem(ExtraUtilities.ID, "curtains", 1, 0),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 8));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("for.honey", 1000),
                MaterialLibAPI.getStack(Materials2Materials.WoodSealed, Materials2Shapes.shapeGearGt, (int) (1L)),
                getModItem(ExtraBees.ID, "misc", 1, 0),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "beeswax", 1, 0),
                'b',
                getModItem(Forestry.ID, "pollen", 1, 0),
                'c',
                getModItem(Forestry.ID, "beeswax", 1, 2),
                'd',
                getModItem(Forestry.ID, "royalJelly", 1, 0),
                'e',
                getModItem(Forestry.ID, "beeswax", 1, 0),
                'f',
                getModItem(Forestry.ID, "royalJelly", 1, 0),
                'g',
                getModItem(Forestry.ID, "beeswax", 1, 2),
                'h',
                getModItem(Forestry.ID, "pollen", 1, 0),
                'i',
                getModItem(Forestry.ID, "beeswax", 1, 2));
        RecipeManagers.squeezerManager.addRecipe(
                20,
                new ItemStack[] { getModItem(ExtraBees.ID, "honeyDrop", 1, 8), },
                FluidRegistry.getFluidStack("for.honey", 200),
                ItemList.Color_01.get(1L),
                100);
        RecipeManagers.squeezerManager.addRecipe(
                20,
                new ItemStack[] { getModItem(ExtraBees.ID, "honeyDrop", 1, 9), },
                FluidRegistry.getFluidStack("for.honey", 200),
                ItemList.Color_11.get(1L),
                100);
        RecipeManagers.squeezerManager.addRecipe(
                20,
                new ItemStack[] { getModItem(ExtraBees.ID, "honeyDrop", 1, 10), },
                FluidRegistry.getFluidStack("for.honey", 200),
                ItemList.Color_04.get(1L),
                100);
        RecipeManagers.squeezerManager.addRecipe(
                20,
                new ItemStack[] { getModItem(ExtraBees.ID, "honeyDrop", 1, 11), },
                FluidRegistry.getFluidStack("for.honey", 200),
                ItemList.Color_02.get(1L),
                100);
        RecipeManagers.squeezerManager.addRecipe(
                20,
                new ItemStack[] { getModItem(ExtraBees.ID, "honeyDrop", 1, 13), },
                FluidRegistry.getFluidStack("for.honey", 200),
                ItemList.Color_15.get(1L),
                100);
        RecipeManagers.squeezerManager.addRecipe(
                20,
                new ItemStack[] { getModItem(ExtraBees.ID, "honeyDrop", 1, 12), },
                FluidRegistry.getFluidStack("for.honey", 200),
                ItemList.Color_00.get(1L),
                100);
        RecipeManagers.squeezerManager.addRecipe(
                20,
                new ItemStack[] { getModItem(ExtraBees.ID, "honeyDrop", 1, 14), },
                FluidRegistry.getFluidStack("for.honey", 200),
                ItemList.Color_03.get(1L),
                100);

        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraBees.ID, "misc", 1, 1)).itemOutputs(
                MaterialLibAPI.getStack(Materials2Materials.Diamond, Materials2Shapes.shapeDustTiny, (int) (1L)))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

        new ResearchItem(
                "HEALINGFRAME",
                "MAGICBEES",
                new AspectList().add(Aspect.MAGIC, 15).add(Aspect.CRAFT, 12).add(Aspect.MIND, 9).add(Aspect.LIFE, 6),
                7,
                -2,
                3,
                getModItem(ExtraBees.ID, "hiveFrame.clay", 1, 0)).setParents("MB_EssenceLife").setConcealed()
                        .setPages(new ResearchPage("ExtraBees.research_page.HEALINGFRAME")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "HEALINGFRAME",
                getModItem(ExtraBees.ID, "hiveFrame.clay", 1, 0),
                new AspectList().add(Aspect.ORDER, 4).add(Aspect.EARTH, 4).add(Aspect.AIR, 4).add(Aspect.ENTROPY, 4)
                        .add(Aspect.FIRE, 4).add(Aspect.WATER, 4),
                "abc",
                "def",
                "ghi",
                'a',
                "screwIron",
                'b',
                MaterialLibAPI.getStack(Materials2Materials.Clay, Materials2Shapes.shapeDust, (int) (1L)),
                'c',
                "screwIron",
                'd',
                MaterialLibAPI.getStack(Materials2Materials.Clay, Materials2Shapes.shapeDust, (int) (1L)),
                'e',
                getModItem(Forestry.ID, "frameImpregnated", 1, 0),
                'f',
                MaterialLibAPI.getStack(Materials2Materials.Clay, Materials2Shapes.shapeDust, (int) (1L)),
                'g',
                "screwIron",
                'h',
                MaterialLibAPI.getStack(Materials2Materials.Clay, Materials2Shapes.shapeDust, (int) (1L)),
                'i',
                "screwIron");
        TCHelper.addResearchPage(
                "HEALINGFRAME",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ExtraBees.ID, "hiveFrame.clay", 1, 0))));
        new ResearchItem(
                "CHOCOLATEFRAME",
                "MAGICBEES",
                new AspectList().add(Aspect.MAGIC, 15).add(Aspect.CRAFT, 12).add(Aspect.MIND, 9).add(Aspect.HUNGER, 6),
                7,
                2,
                3,
                getModItem(ExtraBees.ID, "hiveFrame.cocoa", 1, 0))
                        .setParents("MB_EssenceUnstable").setConcealed()
                        .setPages(
                                new ResearchPage("ExtraBees.research_page.CHOCOLATEFRAME_1"),
                                new ResearchPage("ExtraBees.research_page.CHOCOLATEFRAME_2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CHOCOLATEFRAME",
                getModItem(ExtraBees.ID, "hiveFrame.cocoa", 1, 0),
                new AspectList().add(Aspect.ORDER, 4).add(Aspect.EARTH, 4).add(Aspect.AIR, 4).add(Aspect.ENTROPY, 4)
                        .add(Aspect.FIRE, 4).add(Aspect.WATER, 4),
                "abc",
                "def",
                "ghi",
                'a',
                "screwIron",
                'b',
                getModItem(Minecraft.ID, "sugar", 1, 0),
                'c',
                "screwIron",
                'd',
                getModItem(PamsHarvestCraft.ID, "cocoapowderItem", 1, 0),
                'e',
                getModItem(Forestry.ID, "frameImpregnated", 1, 0),
                'f',
                getModItem(PamsHarvestCraft.ID, "cocoapowderItem", 1, 0),
                'g',
                "screwIron",
                'h',
                getModItem(Minecraft.ID, "sugar", 1, 0),
                'i',
                "screwIron");
        TCHelper.addResearchPage(
                "CHOCOLATEFRAME",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ExtraBees.ID, "hiveFrame.cocoa", 1, 0))));
        new ResearchItem(
                "RESTRAINTFRAME",
                "MAGICBEES",
                new AspectList().add(Aspect.MAGIC, 15).add(Aspect.CRAFT, 12).add(Aspect.MIND, 9).add(Aspect.METAL, 6),
                9,
                0,
                3,
                getModItem(ExtraBees.ID, "hiveFrame.cage", 1, 0))
                        .setParents("PROVENFRAME", "HEALINGFRAME", "CHOCOLATEFRAME").setConcealed()
                        .setPages(new ResearchPage("ExtraBees.research_page.RESTRAINTFRAME")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RESTRAINTFRAME",
                getModItem(ExtraBees.ID, "hiveFrame.cage", 1, 0),
                new AspectList().add(Aspect.ORDER, 8).add(Aspect.EARTH, 8).add(Aspect.AIR, 8).add(Aspect.ENTROPY, 8)
                        .add(Aspect.FIRE, 8).add(Aspect.WATER, 8),
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
                getModItem(Forestry.ID, "frameImpregnated", 1, 0),
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
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ExtraBees.ID, "hiveFrame.cage", 1, 0))));
        new ResearchItem(
                "SOULFRAME",
                "MAGICBEES",
                new AspectList().add(Aspect.MAGIC, 15).add(Aspect.CRAFT, 12).add(Aspect.MIND, 9).add(Aspect.SOUL, 6),
                11,
                0,
                3,
                getModItem(ExtraBees.ID, "hiveFrame.soul", 1, 0)).setParents("RESTRAINTFRAME").setConcealed()
                        .setPages(new ResearchPage("ExtraBees.research_page.SOULFRAME")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SOULFRAME",
                getModItem(ExtraBees.ID, "hiveFrame.soul", 1, 0),
                new AspectList().add(Aspect.ORDER, 16).add(Aspect.EARTH, 16).add(Aspect.AIR, 16).add(Aspect.ENTROPY, 16)
                        .add(Aspect.FIRE, 16).add(Aspect.WATER, 16),
                "abc",
                "def",
                "ghi",
                'a',
                "screwAluminium",
                'b',
                getModItem(Minecraft.ID, "soul_sand", 1, 0),
                'c',
                "screwAluminium",
                'd',
                getModItem(Minecraft.ID, "soul_sand", 1, 0),
                'e',
                getModItem(ExtraBees.ID, "hiveFrame.cage", 1, 0),
                'f',
                getModItem(Minecraft.ID, "soul_sand", 1, 0),
                'g',
                "screwAluminium",
                'h',
                getModItem(Minecraft.ID, "soul_sand", 1, 0),
                'i',
                "screwAluminium");
        TCHelper.addResearchPage(
                "SOULFRAME",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ExtraBees.ID, "hiveFrame.soul", 1, 0))));
        ThaumcraftApi.addWarpToResearch("SOULFRAME", 1);
    }
}
