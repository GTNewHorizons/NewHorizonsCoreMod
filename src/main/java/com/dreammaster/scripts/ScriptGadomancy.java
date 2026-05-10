package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.createItemStack;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.ForbiddenMagic;
import static gregtech.api.enums.Mods.Gadomancy;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicTinkerer;
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.thaumcraft.TCHelper;

import fox.spiteful.forbidden.DarkAspects;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TCAspects;
import gregtech.api.enums.TierEU;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchPage;

public class ScriptGadomancy implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Gadomancy";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(ForbiddenMagic.ID, Gadomancy.ID, Thaumcraft.ID, ThaumicTinkerer.ID);
    }

    @Override
    public void loadRecipes() {

        addShapelessRecipe(
                getModItem(Thaumcraft.ID, "blockCosmeticSlabStone", 2, 1),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 11),
                "craftingToolSaw");
        addShapedRecipe(
                getModItem(Thaumcraft.ID, "blockStairsEldritch", 4, 0),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 11),
                null,
                null,
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 11),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 11),
                null,
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 11),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 11),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 11));

        GTValues.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 11))
                .itemOutputs(getModItem(Thaumcraft.ID, "blockCosmeticSlabStone", 4, 1))
                .fluidInputs(FluidRegistry.getFluidStack("water", 32)).duration(20 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 11))
                .itemOutputs(getModItem(Thaumcraft.ID, "blockCosmeticSlabStone", 4, 1))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 20)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 11))
                .itemOutputs(getModItem(Thaumcraft.ID, "blockCosmeticSlabStone", 4, 1))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 8)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 11))
                .itemOutputs(getModItem(Thaumcraft.ID, "blockCosmeticSlabStone", 4, 1))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(4 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);

        TCHelper.removeInfusionRecipe(getModItem(Gadomancy.ID, "itemSilverwoodGolemPlacer", 1, 8));
        TCHelper.removeInfusionRecipe(
                createItemStack(
                        Gadomancy.ID,
                        "itemSilverwoodGolemPlacer",
                        1,
                        8,
                        "{gadomancy:{upgrades:{runicShield:1b}}}"));
        TCHelper.removeInfusionRecipe(getModItem(Gadomancy.ID, "ItemGolemCoreBreak", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Gadomancy.ID, "ItemGolemCoreBreak", 1, 1));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 4, 11));
        TCHelper.removeCrucibleRecipe(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 15));
        TCHelper.removeInfusionRecipe(getModItem(Gadomancy.ID, "BlockNodeManipulator", 1, 5));
        TCHelper.removeInfusionRecipe(getModItem(Gadomancy.ID, "BlockStoneMachine", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Gadomancy.ID, "BlockInfusionClaw", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Gadomancy.ID, "BlockRemoteJar", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Gadomancy.ID, "BlockArcaneDropper", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Gadomancy.ID, "BlockStoneMachine", 1, 2));
        TCHelper.removeArcaneRecipe(getModItem(Gadomancy.ID, "BlockStoneMachine", 1, 2));
        TCHelper.removeArcaneRecipe(getModItem(Gadomancy.ID, "BlockStoneMachine", 1, 2));
        TCHelper.removeArcaneRecipe(getModItem(Gadomancy.ID, "BlockStoneMachine", 1, 2));
        TCHelper.removeArcaneRecipe(getModItem(Gadomancy.ID, "BlockStoneMachine", 1, 1));
        TCHelper.removeInfusionRecipe(getModItem(Gadomancy.ID, "BlockStoneMachine", 1, 3));
        TCHelper.removeArcaneRecipe(getModItem(Gadomancy.ID, "BlockStoneMachine", 1, 4));
        TCHelper.removeArcaneRecipe(getModItem(Gadomancy.ID, "BlockAuraPylon", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Gadomancy.ID, "BlockAuraPylon", 1, 1));
        TCHelper.removeArcaneRecipe(getModItem(Gadomancy.ID, "BlockKnowledgeBook", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Gadomancy.ID, "BlockEssentiaCompressor", 3, 0));
        TCHelper.addInfusionCraftingRecipe(
                "GADOMANCY.GOLEMSILVERWOOD",
                getModItem(Gadomancy.ID, "itemSilverwoodGolemPlacer", 1, 8),
                8,
                new AspectList().add(Aspect.MAN, 16).add(Aspect.MOTION, 16).add(Aspect.MAGIC, 32).add(Aspect.SENSES, 16)
                        .add(Aspect.MIND, 8).add(Aspect.ORDER, 32),
                getModItem(Thaumcraft.ID, "ItemGolemPlacer", 1, 1),
                getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0),
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 1),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 9),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 9),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 1));
        TCHelper.setResearchAspects(
                "GADOMANCY.GOLEMSILVERWOOD",
                new AspectList().add(Aspect.MIND, 21).add(Aspect.MOTION, 18).add(Aspect.TREE, 15).add(Aspect.MAGIC, 12)
                        .add(Aspect.ORDER, 9).add(Aspect.FLESH, 6).add(Aspect.EXCHANGE, 3));
        TCHelper.setResearchComplexity("GADOMANCY.GOLEMSILVERWOOD", 3);
        TCHelper.addInfusionCraftingRecipe(
                "GADOMANCY.GOLEMCOREBREAK",
                getModItem(Gadomancy.ID, "ItemGolemCoreBreak", 1, 0),
                6,
                new AspectList().add(Aspect.TOOL, 32).add(Aspect.ENTROPY, 16).add(Aspect.MECHANISM, 24)
                        .add(Aspect.MAGIC, 8).add(Aspect.MINE, 8),
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 3),
                getModItem(Thaumcraft.ID, "ItemPickaxeElemental", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                getModItem(Thaumcraft.ID, "ItemAxeElemental", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                getModItem(Thaumcraft.ID, "ItemShovelElemental", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5));
        TCHelper.setResearchAspects(
                "GADOMANCY.GOLEMCOREBREAK",
                new AspectList().add(Aspect.TOOL, 15).add(Aspect.ENTROPY, 12).add(Aspect.MECHANISM, 9)
                        .add(Aspect.MAGIC, 6).add(Aspect.MINE, 3));
        TCHelper.setResearchComplexity("GADOMANCY.GOLEMCOREBREAK", 3);
        TCHelper.addInfusionCraftingRecipe(
                "GADOMANCY.GOLEMCOREBODYGUARD",
                getModItem(Gadomancy.ID, "ItemGolemCoreBreak", 1, 1),
                9,
                new AspectList().add(Aspect.TOOL, 32).add(Aspect.MECHANISM, 24).add(Aspect.WEAPON, 16)
                        .add(Aspect.ARMOR, 24).add(Aspect.ORDER, 8).add(Aspect.AURA, 8),
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 4),
                getModItem(Thaumcraft.ID, "ItemSwordElemental", 1, 0),
                getModItem(Thaumcraft.ID, "ItemHelmetThaumium", 1, 0),
                ItemList.QuantumEye.get(1L),
                getModItem(Thaumcraft.ID, "ItemChestplateThaumium", 1, 0),
                getModItem(Thaumcraft.ID, "BootsTraveller", 1, 0),
                getModItem(Thaumcraft.ID, "ItemLeggingsThaumium", 1, 0),
                ItemList.QuantumEye.get(1L),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6));
        TCHelper.setResearchAspects(
                "GADOMANCY.GOLEMCOREBODYGUARD",
                new AspectList().add(Aspect.TOOL, 18).add(Aspect.ORDER, 15).add(Aspect.MECHANISM, 12)
                        .add(Aspect.WEAPON, 9).add(Aspect.ARMOR, 6).add(Aspect.AURA, 3));
        TCHelper.setResearchComplexity("GADOMANCY.GOLEMCOREBODYGUARD", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.GOLEMRUNICSHIELD",
                new AspectList().add(Aspect.AURA, 15).add(Aspect.MOTION, 12).add(Aspect.ARMOR, 9).add(Aspect.MAGIC, 6)
                        .add(Aspect.ORDER, 3));
        TCHelper.setResearchComplexity("GADOMANCY.GOLEMRUNICSHIELD", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GADOMANCY.ANCIENT_STONES",
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 6, 11),
                new AspectList().add(Aspect.EARTH, 6).add(Aspect.ENTROPY, 12).add(Aspect.FIRE, 6),
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
                getModItem(Thaumcraft.ID, "blockEldritch", 1, 4),
                'e',
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0),
                'f',
                getModItem(Thaumcraft.ID, "blockEldritch", 1, 4),
                'g',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                'h',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                'i',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6));
        TCHelper.setResearchAspects(
                "GADOMANCY.ANCIENT_STONES",
                new AspectList().add(Aspect.FIRE, 15).add(Aspect.ELDRITCH, 12).add(Aspect.ENTROPY, 9)
                        .add(Aspect.EARTH, 6).add(Aspect.EXCHANGE, 3));
        TCHelper.setResearchComplexity("GADOMANCY.ANCIENT_STONES", 3);
        ThaumcraftApi.addCrucibleRecipe(
                "GADOMANCY.ANCIENT_STONES",
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 15),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 11),
                new AspectList().add(Aspect.EXCHANGE, 8).add(Aspect.ENTROPY, 12).add(Aspect.ELDRITCH, 12)
                        .add(Aspect.EARTH, 8));
        TCHelper.addInfusionCraftingRecipe(
                "GADOMANCY.NODE_MANIPULATOR",
                getModItem(Gadomancy.ID, "BlockNodeManipulator", 1, 5),
                10,
                new AspectList().add(Aspect.ELDRITCH, 48).add(Aspect.AURA, 64).add(Aspect.MECHANISM, 48)
                        .add(Aspect.MAGIC, 32).add(Aspect.DARKNESS, 16).add(Aspect.EXCHANGE, 24).add(Aspect.MOTION, 8),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 5),
                OrePrefixes.plateDense.get(Materials.Void),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 11),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 3),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 10),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 3),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 11),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1));
        TCHelper.addInfusionCraftingRecipe(
                "GADOMANCY.NODE_MANIPULATOR",
                getModItem(Gadomancy.ID, "BlockStoneMachine", 1, 0),
                10,
                new AspectList().add(Aspect.ELDRITCH, 24).add(Aspect.MECHANISM, 48).add(Aspect.ORDER, 64)
                        .add(Aspect.MAGIC, 16).add(Aspect.DARKNESS, 32).add(TCAspects.NEBRISUM.getAspect(), 8)
                        .add(Aspect.GREED, 16),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 8),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                OrePrefixes.ring.get(Materials.Void),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.ring.get(Materials.Void),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6));
        TCHelper.setResearchAspects(
                "GADOMANCY.NODE_MANIPULATOR",
                new AspectList().add(TCAspects.NEBRISUM.getAspect(), 27).add(Aspect.ELDRITCH, 24).add(Aspect.VOID, 21)
                        .add(Aspect.MAGIC, 18).add(Aspect.AURA, 15).add(Aspect.GREED, 12).add(Aspect.MECHANISM, 9)
                        .add(Aspect.DARKNESS, 6).add(Aspect.EXCHANGE, 3));
        TCHelper.setResearchComplexity("GADOMANCY.NODE_MANIPULATOR", 4);
        TCHelper.addInfusionCraftingRecipe(
                "GADOMANCY.INFUSIONCLAW",
                getModItem(Gadomancy.ID, "BlockInfusionClaw", 1, 0),
                15,
                new AspectList().add(Aspect.ELDRITCH, 64).add(Aspect.MECHANISM, 48).add(Aspect.ORDER, 48)
                        .add(Aspect.DARKNESS, 32).add(Aspect.MAGIC, 32).add(Aspect.MOTION, 16).add(Aspect.MIND, 8),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 5),
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 8),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                OrePrefixes.stick.get(Materials.Void),
                getModItem(Thaumcraft.ID, "FocusPrimal", 1, 0),
                OrePrefixes.stick.get(Materials.Void),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                OrePrefixes.stick.get(Materials.Void),
                getModItem(Thaumcraft.ID, "FocusPrimal", 1, 0),
                OrePrefixes.stick.get(Materials.Void),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6));
        TCHelper.setResearchAspects(
                "GADOMANCY.INFUSIONCLAW",
                new AspectList().add(Aspect.ELDRITCH, 21).add(Aspect.MECHANISM, 18).add(Aspect.MAGIC, 15)
                        .add(Aspect.ORDER, 12).add(Aspect.DARKNESS, 9).add(Aspect.MOTION, 6).add(Aspect.MIND, 3));
        TCHelper.setResearchComplexity("GADOMANCY.INFUSIONCLAW", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.STICKYJAR",
                new AspectList().add(Aspect.SLIME, 12).add(Aspect.EARTH, 9).add(Aspect.AIR, 6).add(Aspect.MAGIC, 3));
        TCHelper.setResearchComplexity("GADOMANCY.STICKYJAR", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GADOMANCY.REMOTEJAR",
                getModItem(Gadomancy.ID, "BlockRemoteJar", 1, 0),
                new AspectList().add(Aspect.WATER, 15).add(Aspect.EARTH, 15).add(Aspect.ORDER, 15).add(Aspect.AIR, 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2),
                'b',
                getModItem(Thaumcraft.ID, "blockJar", 1, 0),
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2),
                'd',
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 0),
                'e',
                getModItem(Thaumcraft.ID, "blockMirror", 1, 6),
                'f',
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 0),
                'g',
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 0),
                'h',
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 0),
                'i',
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 0));
        TCHelper.setResearchAspects(
                "GADOMANCY.REMOTEJAR",
                new AspectList().add(Aspect.MECHANISM, 15).add(Aspect.ORDER, 12).add(Aspect.WATER, 9)
                        .add(Aspect.EARTH, 6).add(Aspect.ELDRITCH, 3));
        TCHelper.setResearchComplexity("GADOMANCY.REMOTEJAR", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GADOMANCY.ARCANEDROPPER",
                getModItem(Gadomancy.ID, "BlockArcaneDropper", 1, 0),
                new AspectList().add(Aspect.ORDER, 20).add(Aspect.AIR, 20).add(Aspect.EARTH, 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                'b',
                getModItem(Minecraft.ID, "dropper", 1, 0),
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                'd',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 0),
                'e',
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 9),
                'f',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 0),
                'g',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                'h',
                ItemList.Electric_Motor_MV.get(1L),
                'i',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6));
        TCHelper.setResearchAspects(
                "GADOMANCY.ARCANEDROPPER",
                new AspectList().add(Aspect.MECHANISM, 21).add(Aspect.AIR, 18).add(Aspect.EARTH, 15)
                        .add(Aspect.ORDER, 12).add(Aspect.SENSES, 9).add(Aspect.MOTION, 6).add(Aspect.MAGIC, 3));
        TCHelper.setResearchComplexity("GADOMANCY.ARCANEDROPPER", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.ARMORDISGUISE",
                new AspectList().add(Aspect.SLIME, 15).add(Aspect.MAGIC, 12).add(Aspect.ARMOR, 9).add(Aspect.MIND, 6)
                        .add(TCAspects.NEBRISUM.getAspect(), 3));
        TCHelper.setResearchComplexity("GADOMANCY.ARMORDISGUISE", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.REVEALER",
                new AspectList().add(Aspect.AIR, 15).add(Aspect.SENSES, 12).add(Aspect.MAGIC, 9).add(Aspect.ELDRITCH, 6)
                        .add(Aspect.MIND, 3));
        TCHelper.setResearchComplexity("GADOMANCY.REVEALER", 3);
        TCHelper.clearPages("GADOMANCY.BLOCK_PROTECTOR");
        TCHelper.addResearchPage(
                "GADOMANCY.BLOCK_PROTECTOR",
                new ResearchPage("gadomancy.research_page.BLOCK_PROTECTOR.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GADOMANCY.BLOCK_PROTECTOR",
                getModItem(Gadomancy.ID, "BlockStoneMachine", 1, 2),
                new AspectList().add(Aspect.EARTH, 150).add(Aspect.ORDER, 150),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Minecraft.ID, "potion", 1, 8264),
                'b',
                getModItem(ThaumicTinkerer.ID, "brightNitor", 1, 0),
                'c',
                getModItem(Minecraft.ID, "potion", 1, 8264),
                'd',
                getModItem(Thaumcraft.ID, "blockTube", 1, 0),
                'e',
                getModItem(Thaumcraft.ID, "blockJar", 1, 0),
                'f',
                getModItem(Thaumcraft.ID, "blockTube", 1, 0),
                'g',
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 0),
                'h',
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 0),
                'i',
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 0));
        TCHelper.addResearchPage(
                "GADOMANCY.BLOCK_PROTECTOR",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Gadomancy.ID, "BlockStoneMachine", 1, 2))));
        TCHelper.addResearchPage(
                "GADOMANCY.BLOCK_PROTECTOR",
                new ResearchPage("gadomancy.research_page.BLOCK_PROTECTOR.3"));
        TCHelper.addResearchPage(
                "GADOMANCY.BLOCK_PROTECTOR",
                new ResearchPage("gadomancy.research_page.BLOCK_PROTECTOR.4"));
        TCHelper.setResearchAspects(
                "GADOMANCY.BLOCK_PROTECTOR",
                new AspectList().add(Aspect.MIND, 21).add(Aspect.BEAST, 18).add(Aspect.EARTH, 15).add(Aspect.ORDER, 12)
                        .add(Aspect.AURA, 9).add(Aspect.LIGHT, 6).add(Aspect.ARMOR, 3));
        TCHelper.setResearchComplexity("GADOMANCY.BLOCK_PROTECTOR", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GADOMANCY.E_PORTAL_CREATOR",
                getModItem(Gadomancy.ID, "BlockStoneMachine", 1, 1),
                new AspectList().add(Aspect.ENTROPY, 30).add(Aspect.ORDER, 30).add(Aspect.EARTH, 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 11),
                'b',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 15),
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 11),
                'd',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                'e',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 11),
                'f',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                'g',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 11),
                'h',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 15),
                'i',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 11));
        TCHelper.addInfusionCraftingRecipe(
                "GADOMANCY.E_PORTAL_CREATOR",
                getModItem(Gadomancy.ID, "BlockStoneMachine", 1, 3),
                10,
                new AspectList().add(Aspect.ELDRITCH, 48).add(Aspect.MECHANISM, 48).add(Aspect.EXCHANGE, 64)
                        .add(Aspect.DARKNESS, 32).add(Aspect.VOID, 32).add(Aspect.AURA, 16).add(Aspect.MAGIC, 8),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 8),
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                OrePrefixes.ring.get(Materials.Void),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.ring.get(Materials.Void),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5));
        TCHelper.setResearchAspects(
                "GADOMANCY.E_PORTAL_CREATOR",
                new AspectList().add(Aspect.DARKNESS, 21).add(Aspect.AURA, 18).add(Aspect.TRAVEL, 15)
                        .add(Aspect.ELDRITCH, 12).add(Aspect.VOID, 9).add(Aspect.MECHANISM, 6).add(Aspect.MAGIC, 3));
        TCHelper.setResearchComplexity("GADOMANCY.E_PORTAL_CREATOR", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.ETHEREAL_FAMILIAR",
                new AspectList().add(Aspect.EARTH, 18).add(Aspect.MAGIC, 15).add(Aspect.FIRE, 12).add(Aspect.AURA, 9)
                        .add(Aspect.AIR, 6).add(Aspect.ORDER, 3));
        TCHelper.setResearchComplexity("GADOMANCY.ETHEREAL_FAMILIAR", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.AURA_CORE",
                new AspectList().add(Aspect.DARKNESS, 27).add(Aspect.MAGIC, 24).add(Aspect.AURA, 21)
                        .add(Aspect.ENTROPY, 18).add(Aspect.ORDER, 15).add(Aspect.WATER, 12).add(Aspect.AIR, 9)
                        .add(Aspect.FIRE, 6).add(Aspect.EARTH, 3));
        TCHelper.setResearchComplexity("GADOMANCY.AURA_CORE", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.CLEAN_AURA_CORE",
                new AspectList().add(Aspect.WATER, 27).add(Aspect.HEAL, 24).add(Aspect.MAGIC, 21).add(Aspect.AURA, 18)
                        .add(Aspect.EARTH, 15).add(Aspect.FIRE, 12).add(Aspect.ENTROPY, 9).add(Aspect.ORDER, 6)
                        .add(Aspect.AIR, 3));
        TCHelper.setResearchComplexity("GADOMANCY.CLEAN_AURA_CORE", 4);
        TCHelper.setResearchAspects(
                "GADOMANCY.FAMILIAR_POISON",
                new AspectList().add(Aspect.POISON, 15).add(Aspect.WEAPON, 12).add(Aspect.ENTROPY, 9)
                        .add(Aspect.DARKNESS, 6).add(Aspect.MAGIC, 3));
        TCHelper.setResearchComplexity("GADOMANCY.FAMILIAR_POISON", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.FAMILIAR_WEAKNESS",
                new AspectList().add(Aspect.TRAP, 15).add(Aspect.TAINT, 12).add(Aspect.WEAPON, 9).add(Aspect.MAGIC, 6)
                        .add(Aspect.DARKNESS, 3));
        TCHelper.setResearchComplexity("GADOMANCY.FAMILIAR_WEAKNESS", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.FAMILIAR_SHOCK",
                new AspectList().add(Aspect.AIR, 15).add(Aspect.WEATHER, 12).add(Aspect.WEAPON, 9).add(Aspect.MAGIC, 6)
                        .add(Aspect.DARKNESS, 3));
        TCHelper.setResearchComplexity("GADOMANCY.FAMILIAR_SHOCK", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.FAMILIAR_FIRE",
                new AspectList().add(Aspect.FIRE, 15).add(DarkAspects.NETHER, 12).add(Aspect.WEAPON, 9)
                        .add(Aspect.MAGIC, 6).add(Aspect.DARKNESS, 3));
        TCHelper.setResearchComplexity("GADOMANCY.FAMILIAR_FIRE", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.FAMILIAR_DAMAGE",
                new AspectList().add(Aspect.ENERGY, 15).add(Aspect.FIRE, 12).add(Aspect.WEAPON, 9).add(Aspect.MAGIC, 6)
                        .add(Aspect.DARKNESS, 3));
        TCHelper.setResearchComplexity("GADOMANCY.FAMILIAR_DAMAGE", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.FAMILIAR_RANGE",
                new AspectList().add(Aspect.ELDRITCH, 15).add(Aspect.ORDER, 12).add(Aspect.WEAPON, 9)
                        .add(Aspect.MAGIC, 6).add(Aspect.DARKNESS, 3));
        TCHelper.setResearchComplexity("GADOMANCY.FAMILIAR_RANGE", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.FAMILIAR_SPEED",
                new AspectList().add(Aspect.MOTION, 15).add(Aspect.AURA, 12).add(Aspect.WEAPON, 9).add(Aspect.MAGIC, 6)
                        .add(Aspect.DARKNESS, 3));
        TCHelper.setResearchComplexity("GADOMANCY.FAMILIAR_SPEED", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GADOMANCY.ARCANE_PACKAGER",
                getModItem(Gadomancy.ID, "BlockStoneMachine", 1, 4),
                new AspectList().add(Aspect.ORDER, 100).add(Aspect.ENTROPY, 100).add(Aspect.AIR, 100),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6),
                'b',
                ItemList.Electric_Piston_HV.get(1L),
                'c',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6),
                'd',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2),
                'e',
                getModItem(Gadomancy.ID, "ItemAuraCore", 1, 1),
                'f',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2),
                'g',
                getModItem(Thaumcraft.ID, "blockJar", 1, 0),
                'h',
                getModItem(Thaumcraft.ID, "blockTable", 1, 15),
                'i',
                getModItem(Thaumcraft.ID, "blockJar", 1, 0));
        TCHelper.setResearchAspects(
                "GADOMANCY.ARCANE_PACKAGER",
                new AspectList().add(Aspect.MECHANISM, 18).add(Aspect.AIR, 15).add(Aspect.VOID, 12).add(Aspect.MAGIC, 9)
                        .add(Aspect.ENERGY, 6).add(Aspect.TREE, 3));
        TCHelper.setResearchComplexity("GADOMANCY.ARCANE_PACKAGER", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GADOMANCY.AURA_PYLON",
                getModItem(Gadomancy.ID, "BlockAuraPylon", 1, 0),
                new AspectList().add(Aspect.ORDER, 100).add(Aspect.WATER, 100).add(Aspect.AIR, 100)
                        .add(Aspect.FIRE, 100),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockTube", 1, 6),
                'b',
                "stickIridium",
                'c',
                getModItem(Thaumcraft.ID, "blockTube", 1, 6),
                'd',
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 1),
                'e',
                getModItem(Thaumcraft.ID, "blockJar", 1, 0),
                'f',
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 1),
                'g',
                getModItem(Thaumcraft.ID, "blockTube", 1, 6),
                'h',
                "stickIridium",
                'i',
                getModItem(Thaumcraft.ID, "blockTube", 1, 6));
        TCHelper.setResearchAspects(
                "GADOMANCY.AURA_PYLON",
                new AspectList().add(Aspect.AURA, 18).add(Aspect.ORDER, 15).add(Aspect.MAGIC, 12)
                        .add(Aspect.MECHANISM, 9).add(Aspect.AIR, 6).add(Aspect.FIRE, 3));
        TCHelper.setResearchComplexity("GADOMANCY.AURA_PYLON", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GADOMANCY.AURA_PYLON",
                getModItem(Gadomancy.ID, "BlockAuraPylon", 1, 1),
                new AspectList().add(Aspect.ORDER, 125).add(Aspect.AIR, 125).add(Aspect.FIRE, 125),
                "abc",
                "def",
                "ghi",
                'a',
                "screwOsmiridium",
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1),
                'c',
                "screwOsmiridium",
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 0),
                'e',
                getModItem(Gadomancy.ID, "ItemAuraCore", 1, 2),
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 0),
                'g',
                "stickIridium",
                'h',
                getModItem(Gadomancy.ID, "BlockAuraPylon", 1, 0),
                'i',
                "stickIridium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GADOMANCY.KNOWLEDGE_BOOK",
                getModItem(Gadomancy.ID, "BlockKnowledgeBook", 1, 0),
                new AspectList().add(Aspect.ORDER, 75).add(Aspect.FIRE, 50).add(Aspect.ENTROPY, 35).add(Aspect.AIR, 35),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "ItemInkwell", 1, 0),
                'b',
                getModItem(Thaumcraft.ID, "ItemThaumonomicon", 1, 0),
                'c',
                getModItem(Thaumcraft.ID, "ItemInkwell", 1, 0),
                'd',
                getModItem(Minecraft.ID, "bookshelf", 1, 0),
                'e',
                getModItem(Gadomancy.ID, "ItemAuraCore", 1, 5),
                'f',
                getModItem(Minecraft.ID, "bookshelf", 1, 0),
                'g',
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 12),
                'h',
                getModItem(Thaumcraft.ID, "ItemGoggles", 1, 0),
                'i',
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 12));
        TCHelper.setResearchAspects(
                "GADOMANCY.KNOWLEDGE_BOOK",
                new AspectList().add(Aspect.MIND, 24).add(Aspect.ORDER, 21).add(Aspect.MAGIC, 18)
                        .add(Aspect.MECHANISM, 15).add(Aspect.CRAFT, 12).add(Aspect.MOTION, 9).add(Aspect.AIR, 6)
                        .add(Aspect.GREED, 3));
        TCHelper.setResearchComplexity("GADOMANCY.KNOWLEDGE_BOOK", 3);
        ThaumcraftApi.addWarpToResearch("GADOMANCY.KNOWLEDGE_BOOK", 4);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GADOMANCY.ESSENTIA_COMPRESSOR",
                getModItem(Gadomancy.ID, "BlockEssentiaCompressor", 1, 0),
                new AspectList().add(Aspect.AIR, 180).add(Aspect.WATER, 200).add(Aspect.FIRE, 120)
                        .add(Aspect.EARTH, 100).add(Aspect.ENTROPY, 140).add(Aspect.ORDER, 160),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockTube", 1, 6),
                'b',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                'c',
                getModItem(Thaumcraft.ID, "blockTube", 1, 6),
                'd',
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 0),
                'e',
                getModItem(Gadomancy.ID, "ItemElement", 1, 0),
                'f',
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 0),
                'g',
                getModItem(Thaumcraft.ID, "blockTube", 1, 6),
                'h',
                getModItem(Gadomancy.ID, "ItemAuraCore", 1, 3),
                'i',
                getModItem(Thaumcraft.ID, "blockTube", 1, 6));
        TCHelper.setResearchAspects(
                "GADOMANCY.ESSENTIA_COMPRESSOR",
                new AspectList().add(Aspect.VOID, 21).add(Aspect.ENTROPY, 18).add(Aspect.MECHANISM, 15)
                        .add(Aspect.WATER, 18).add(Aspect.MAGIC, 9).add(Aspect.ENERGY, 3));
        TCHelper.setResearchComplexity("GADOMANCY.ESSENTIA_COMPRESSOR", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.AURA_EFFECTS",
                new AspectList().add(Aspect.MIND, 27).add(Aspect.AURA, 24).add(Aspect.MAGIC, 21).add(Aspect.ORDER, 18)
                        .add(Aspect.FIRE, 15).add(Aspect.AIR, 12).add(Aspect.WATER, 9).add(Aspect.EARTH, 6)
                        .add(Aspect.ENTROPY, 3));
        TCHelper.setResearchComplexity("GADOMANCY.AURA_EFFECTS", 4);
        TCHelper.refreshResearchPages("GADOMANCY.GOLEMSILVERWOOD");
        TCHelper.refreshResearchPages("GADOMANCY.GOLEMCOREBREAK");
        TCHelper.refreshResearchPages("GADOMANCY.GOLEMCOREBODYGUARD");
        TCHelper.refreshResearchPages("GADOMANCY.GOLEMRUNICSHIELD");
        TCHelper.refreshResearchPages("GADOMANCY.ANCIENT_STONES");
        TCHelper.refreshResearchPages("GADOMANCY.NODE_MANIPULATOR");
        TCHelper.refreshResearchPages("GADOMANCY.INFUSIONCLAW");
        TCHelper.refreshResearchPages("GADOMANCY.REMOTEJAR");
        TCHelper.refreshResearchPages("GADOMANCY.ARCANEDROPPER");
        TCHelper.refreshResearchPages("GADOMANCY.BLOCK_PROTECTOR");
        TCHelper.refreshResearchPages("GADOMANCY.E_PORTAL_CREATOR");
        TCHelper.refreshResearchPages("GADOMANCY.ARCANE_PACKAGER");
        TCHelper.refreshResearchPages("GADOMANCY.AURA_PYLON");
        TCHelper.refreshResearchPages("GADOMANCY.KNOWLEDGE_BOOK");
        TCHelper.refreshResearchPages("GADOMANCY.ESSENTIA_COMPRESSOR");
        TCHelper.refreshResearchPages("GADOMANCY.STICKYJAR");
    }
}
