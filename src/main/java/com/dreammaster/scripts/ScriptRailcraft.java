package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.createItemStack;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.BuildCraftFactory;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.ForgeMicroblocks;
import static gregtech.api.enums.Mods.IC2NuclearControl;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.ProjectRedIntegration;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.StevesCarts2;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.recipe.RecipeMaps.alloySmelterRecipes;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.blastFurnaceRecipes;
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
import static gregtech.api.recipe.RecipeMaps.hammerRecipes;
import static gregtech.api.recipe.RecipeMaps.laserEngraverRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.recipe.RecipeMaps.mixerRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeConstants.FUEL_TYPE;
import static gregtech.api.util.GTRecipeConstants.FUEL_VALUE;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.dreammaster.forestry.ForestryHelper;
import com.dreammaster.item.NHItemList;
import com.dreammaster.railcraft.RailcraftHelper;
import com.dreammaster.thaumcraft.TCHelper;

import forestry.api.recipes.RecipeManagers;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.ToolDictNames;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTRecipeConstants;
import gregtech.api.util.GTUtility;
import mods.railcraft.api.crafting.RailcraftCraftingManager;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchPage;

public class ScriptRailcraft implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Railcraft";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                Backpack.ID,
                BiomesOPlenty.ID,
                BuildCraftFactory.ID,
                EnderIO.ID,
                Forestry.ID,
                ForgeMicroblocks.ID,
                IC2NuclearControl.ID,
                IndustrialCraft2.ID,
                PamsHarvestCraft.ID,
                ProjectRedIntegration.ID,
                Railcraft.ID,
                StevesCarts2.ID,
                Thaumcraft.ID);
    }

    @Override
    public void loadRecipes() {

        addShapedRecipe(
                getModItem(Railcraft.ID, "part.rebar", 2, 0),
                null,
                "craftingToolHardHammer",
                null,
                "stickAnyIron",
                "craftingToolFile",
                "stickAnyIron",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.tie", 1, 1),
                null,
                getModItem(Railcraft.ID, "part.rebar", 1, 0),
                null,
                getModItem(Minecraft.ID, "stone_slab", 1, 0),
                getModItem(Minecraft.ID, "stone_slab", 1, 0),
                getModItem(Minecraft.ID, "stone_slab", 1, 0),
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.railbed", 1, 0),
                getModItem(Railcraft.ID, "part.tie", 1, 0),
                getModItem(Railcraft.ID, "part.tie", 1, 0),
                getModItem(Railcraft.ID, "part.tie", 1, 0),
                getModItem(Railcraft.ID, "part.tie", 1, 0),
                null,
                ToolDictNames.craftingToolSoftMallet.name(),
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.railbed", 1, 1),
                getModItem(Railcraft.ID, "part.tie", 1, 1),
                getModItem(Railcraft.ID, "part.tie", 1, 1),
                getModItem(Railcraft.ID, "part.tie", 1, 1),
                getModItem(Railcraft.ID, "part.tie", 1, 1),
                null,
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "frame", 1, 0),
                "plateAnyRubber",
                "plateSteel",
                "plateAnyRubber",
                getModItem(Railcraft.ID, "part.rebar", 1, 0),
                "craftingToolWrench",
                getModItem(Railcraft.ID, "part.rebar", 1, 0),
                getModItem(Railcraft.ID, "part.rebar", 1, 0),
                getModItem(Railcraft.ID, "part.rebar", 1, 0),
                getModItem(Railcraft.ID, "part.rebar", 1, 0));
        addShapedRecipe(
                getModItem(Railcraft.ID, "slab", 2, 2),
                "craftingToolSaw",
                getModItem(Railcraft.ID, "cube", 1, 1));
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.control\"}"),
                "screwSteel",
                "stickRedAlloy",
                "screwSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 1),
                getModItem(Minecraft.ID, "rail", 1, 0),
                getModItem(Railcraft.ID, "part.rail", 1, 1),
                "craftingToolScrewdriver",
                "stickRedAlloy",
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 20176, "{track:\"railcraft:track.locking\"}"),
                "screwSteel",
                getModItem(Railcraft.ID, "detector", 1, 1),
                "screwSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 1),
                getModItem(Railcraft.ID, "part.railbed", 1, 0),
                getModItem(Railcraft.ID, "part.rail", 1, 1),
                "craftingToolScrewdriver",
                "stickRedAlloy",
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 23575, "{track:\"railcraft:track.disembarking\"}"),
                "screwSteel",
                getModItem(Railcraft.ID, "part.railbed", 1, 0),
                "screwSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 1),
                getModItem(Railcraft.ID, "detector", 1, 9),
                getModItem(Railcraft.ID, "part.rail", 1, 1),
                "craftingToolScrewdriver",
                "stickRedAlloy",
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.embarking\"}"),
                "screwSteel",
                "gemEnderEye",
                "screwSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 1),
                getModItem(Railcraft.ID, "part.railbed", 1, 0),
                getModItem(Railcraft.ID, "part.rail", 1, 1),
                "craftingToolScrewdriver",
                "gemEnderEye",
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.coupler\"}"),
                "screwSteel",
                getModItem(Railcraft.ID, "tool.crowbar.reinforced", 1, 0),
                "screwSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 1),
                getModItem(Railcraft.ID, "part.railbed", 1, 0),
                getModItem(Railcraft.ID, "part.rail", 1, 1),
                "craftingToolScrewdriver",
                getModItem(Railcraft.ID, "tool.crowbar.reinforced", 1, 0),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.whistle\"}"),
                "screwAnyIron",
                getModItem(Railcraft.ID, "tool.whistle.tuner", 1, 0),
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                getModItem(Railcraft.ID, "part.railbed", 1, 0),
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                "craftingToolScrewdriver",
                ItemList.Casing_Stripes_A.get(1L),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 30516, "{track:\"railcraft:track.locomotive\"}"),
                "screwAnyIron",
                getModItem(Railcraft.ID, "signal", 1, 11),
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                getModItem(Railcraft.ID, "part.railbed", 1, 0),
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Railcraft.ID, "signal", 1, 3),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 16093, "{track:\"railcraft:track.limiter\"}"),
                "screwAnyIron",
                "plateRedAlloy",
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                getModItem(Railcraft.ID, "part.railbed", 1, 0),
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Railcraft.ID, "detector", 1, 1),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.routing\"}"),
                "screwAnyIron",
                "plateRedAlloy",
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                getModItem(Railcraft.ID, "part.railbed", 1, 0),
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Railcraft.ID, "routing.ticket", 1, 0),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.routing\"}"),
                "screwAnyIron",
                "plateRedAlloy",
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                getModItem(Railcraft.ID, "part.railbed", 1, 0),
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Railcraft.ID, "routing.ticket.gold", 1, 0),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 2, 32363, "{track:\"railcraft:track.buffer.stop\"}"),
                "screwAnyIron",
                "plateSteel",
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                getModItem(Railcraft.ID, "part.railbed", 1, 0),
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                "craftingToolScrewdriver",
                "blockSteel",
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 30946, "{track:\"railcraft:track.oneway\"}"),
                "screwAnyIron",
                getModItem(Railcraft.ID, "detector", 1, 1),
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                getModItem(Railcraft.ID, "part.railbed", 1, 0),
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "piston", 1, 0),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.detector.direction\"}"),
                "screwAnyIron",
                "plateRedAlloy",
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                getModItem(Railcraft.ID, "part.railbed", 1, 0),
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Railcraft.ID, "detector", 1, 9),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.gated.oneway\"}"),
                "screwSteel",
                "plateRedAlloy",
                "screwSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 1),
                createItemStack(Railcraft.ID, "track", 1, 19746, "{track:\"railcraft:track.gated\"}"),
                getModItem(Railcraft.ID, "part.rail", 1, 1),
                "craftingToolScrewdriver",
                "plateRedAlloy",
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 19746, "{track:\"railcraft:track.gated\"}"),
                "screwAnyIron",
                getModItem(Minecraft.ID, "fence_gate", 1, 0),
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                getModItem(Railcraft.ID, "part.railbed", 1, 0),
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "fence_gate", 1, 0),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.suspended\"}"),
                "screwAnyIron",
                getModItem(Railcraft.ID, "post", 1, 2),
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                getModItem(Railcraft.ID, "part.railbed", 1, 0),
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Railcraft.ID, "post", 1, 2),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 2264, "{track:\"railcraft:track.disposal\"}"),
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.tie", 1, 0),
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                "plateSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Railcraft.ID, "part.tie", 1, 0),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 16, 736, "{track:\"railcraft:track.slow\"}"),
                "screwAnyIron",
                null,
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 2),
                getModItem(Railcraft.ID, "part.railbed", 1, 0),
                getModItem(Railcraft.ID, "part.rail", 1, 2),
                "craftingToolScrewdriver",
                null,
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 4, 0, "{track:\"railcraft:track.slow.boost\"}"),
                "screwAnyIron",
                "plateRedAlloy",
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 1),
                getModItem(Railcraft.ID, "part.railbed", 1, 0),
                getModItem(Railcraft.ID, "part.rail", 1, 1),
                "craftingToolScrewdriver",
                "plateRedAlloy",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(Minecraft.ID, "golden_rail", 4, 0),
                "screwSteel",
                "plateRedAlloy",
                "screwSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 1),
                getModItem(Railcraft.ID, "part.railbed", 1, 0),
                getModItem(Railcraft.ID, "part.rail", 1, 1),
                "craftingToolScrewdriver",
                "plateRedAlloy",
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 8, 0, "{track:\"railcraft:track.reinforced\"}"),
                "screwStainlessSteel",
                null,
                "screwStainlessSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 4),
                getModItem(Railcraft.ID, "part.railbed", 1, 1),
                getModItem(Railcraft.ID, "part.rail", 1, 4),
                "craftingToolScrewdriver",
                null,
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 4, 0, "{track:\"railcraft:track.reinforced.boost\"}"),
                "screwStainlessSteel",
                "plateRedAlloy",
                "screwStainlessSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 4),
                getModItem(Railcraft.ID, "part.railbed", 1, 1),
                getModItem(Railcraft.ID, "part.rail", 1, 4),
                "craftingToolScrewdriver",
                "plateRedAlloy",
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 8, 10192, "{track:\"railcraft:track.electric\"}"),
                "screwCopper",
                getModItem(Railcraft.ID, "part.rail", 1, 5),
                "screwCopper",
                getModItem(Railcraft.ID, "part.rail", 1, 5),
                getModItem(Railcraft.ID, "part.railbed", 1, 1),
                getModItem(Railcraft.ID, "part.rail", 1, 5),
                "craftingToolScrewdriver",
                getModItem(Railcraft.ID, "part.rail", 1, 5),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 8, 816, "{track:\"railcraft:track.speed\"}"),
                "screwSteel",
                null,
                "screwSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 3),
                getModItem(Railcraft.ID, "part.railbed", 1, 1),
                getModItem(Railcraft.ID, "part.rail", 1, 3),
                "craftingToolScrewdriver",
                null,
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 4, 0, "{track:\"railcraft:track.speed.boost\"}"),
                "screwSteel",
                "plateRedAlloy",
                "screwSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 3),
                getModItem(Railcraft.ID, "part.railbed", 1, 1),
                getModItem(Railcraft.ID, "part.rail", 1, 3),
                "craftingToolScrewdriver",
                "plateRedAlloy",
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 26865, "{track:\"railcraft:track.speed.transition\"}"),
                "screwSteel",
                createItemStack(Railcraft.ID, "track", 1, 816, "{track:\"railcraft:track.speed\"}"),
                "screwSteel",
                "plateRedAlloy",
                getModItem(Railcraft.ID, "part.railbed", 1, 1),
                "plateRedAlloy",
                "craftingToolScrewdriver",
                createItemStack(Railcraft.ID, "track", 1, 816, "{track:\"railcraft:track.speed\"}"),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 8103, "{track:\"railcraft:track.priming\"}"),
                "screwSteel",
                getModItem(Railcraft.ID, "detector", 1, 1),
                "screwSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 4),
                getModItem(Railcraft.ID, "part.railbed", 1, 1),
                getModItem(Railcraft.ID, "part.rail", 1, 4),
                "craftingToolScrewdriver",
                ItemList.Tool_Lighter_Invar_Full.get(1L),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.launcher\"}"),
                "screwSteel",
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.reinforced\"}"),
                "screwSteel",
                "blockSteel",
                getModItem(Minecraft.ID, "piston", 1, 0),
                "blockSteel",
                "craftingToolScrewdriver",
                "plateRedAlloy",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(Railcraft.ID, "track.elevator", 2, 0),
                "screwSteel",
                getModItem(Railcraft.ID, "detector", 1, 1),
                "screwSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 1),
                getModItem(Minecraft.ID, "rail", 1, 0),
                getModItem(Railcraft.ID, "part.rail", 1, 1),
                "craftingToolScrewdriver",
                "plateRedAlloy",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 4),
                "screwSteel",
                "stickRedAlloy",
                "stickTin",
                getModItem(Minecraft.ID, "lever", 1, 0),
                getModItem(Minecraft.ID, "sticky_piston", 1, 0),
                "screwSteel",
                "plateSteel",
                "plateSteel",
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 2),
                "screwSteel",
                "stickRedAlloy",
                "stickTin",
                ItemList.Electric_Motor_LV.get(1L),
                ItemList.Electric_Piston_LV.get(1L),
                getModItem(Railcraft.ID, "part.circuit", 1, 1),
                "plateSteel",
                "plateSteel",
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 3),
                getModItem(Railcraft.ID, "part.signal.lamp", 1, 0),
                getModItem(Railcraft.ID, "part.circuit", 1, 2),
                "plateSteel",
                null,
                null,
                "plateSteel",
                null,
                null,
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 11),
                getModItem(Railcraft.ID, "part.signal.lamp", 1, 0),
                getModItem(Railcraft.ID, "part.circuit", 1, 1),
                "plateSteel",
                null,
                null,
                "plateSteel",
                null,
                null,
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 1),
                getModItem(Railcraft.ID, "part.signal.lamp", 1, 0),
                getModItem(Railcraft.ID, "part.circuit", 1, 2),
                "plateSteel",
                "plateSteel",
                "plateSteel",
                "plateSteel",
                getModItem(Railcraft.ID, "part.signal.lamp", 1, 0),
                getModItem(Railcraft.ID, "part.circuit", 1, 1),
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 12),
                getModItem(Railcraft.ID, "part.signal.lamp", 1, 0),
                getModItem(Railcraft.ID, "part.circuit", 1, 1),
                "plateSteel",
                "plateSteel",
                "plateSteel",
                "plateSteel",
                getModItem(Railcraft.ID, "part.signal.lamp", 1, 0),
                getModItem(Railcraft.ID, "part.circuit", 1, 1),
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 13),
                "plateSteel",
                getModItem(Railcraft.ID, "part.circuit", 1, 2),
                "plateSteel",
                "plateSteel",
                "plateRedAlloy",
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 9),
                "plateSteel",
                getModItem(Railcraft.ID, "part.circuit", 1, 0),
                "plateSteel",
                "plateSteel",
                "plateRedAlloy",
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 10),
                "plateSteel",
                getModItem(Railcraft.ID, "part.circuit", 1, 0),
                "plateSteel",
                "plateSteel",
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26),
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 8),
                "plateSteel",
                getModItem(Railcraft.ID, "part.circuit", 1, 1),
                "plateSteel",
                "plateSteel",
                "plateRedAlloy",
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 7),
                "plateSteel",
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 10),
                "plateSteel",
                "plateSteel",
                "plateRedAlloy",
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 6),
                "plateSteel",
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26),
                "plateSteel",
                "plateSteel",
                "plateRedAlloy",
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 0),
                "plateSteel",
                getModItem(Railcraft.ID, "part.circuit", 1, 1),
                "plateSteel",
                "plateSteel",
                getModItem(Railcraft.ID, "part.circuit", 1, 0),
                "plateSteel",
                "plateSteel",
                "plateRedAlloy",
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.rail", 12, 2),
                "stickAnyIron",
                getModItem(Railcraft.ID, "part.tie", 1, 0),
                "stickWood",
                "stickAnyIron",
                getModItem(Railcraft.ID, "part.tie", 1, 0),
                "stickWood",
                "stickAnyIron",
                getModItem(Railcraft.ID, "part.tie", 1, 0),
                "stickWood");
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.rail", 8, 2),
                "stickAnyIron",
                getModItem(Railcraft.ID, "part.tie", 1, 0),
                "stickWood",
                "stickAnyIron",
                getModItem(Railcraft.ID, "part.tie", 1, 0),
                "stickWood",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.rail", 4, 2),
                "stickAnyIron",
                getModItem(Railcraft.ID, "part.tie", 1, 0),
                "stickWood",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.rail", 12, 0),
                "stickAnyIron",
                getModItem(Railcraft.ID, "part.tie", 1, 1),
                "stickAnyIron",
                "stickAnyIron",
                getModItem(Railcraft.ID, "part.tie", 1, 1),
                "stickAnyIron",
                "stickAnyIron",
                getModItem(Railcraft.ID, "part.tie", 1, 1),
                "stickAnyIron");
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.rail", 8, 0),
                "stickAnyIron",
                getModItem(Railcraft.ID, "part.tie", 1, 1),
                "stickAnyIron",
                "stickAnyIron",
                getModItem(Railcraft.ID, "part.tie", 1, 1),
                "stickAnyIron",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.rail", 4, 0),
                "stickAnyIron",
                getModItem(Railcraft.ID, "part.tie", 1, 1),
                "stickAnyIron",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.rail", 4, 1),
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                "plateRedstone",
                "stickElectrum",
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                "plateRedstone",
                "stickElectrum",
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                "craftingToolHardHammer",
                "stickElectrum");
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 0),
                "logWood",
                getModItem(Minecraft.ID, "rail", 1, 0),
                "logWood",
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0),
                "plateRedAlloy",
                "logWood",
                "plateRedAlloy",
                "logWood");
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 1),
                getModItem(Minecraft.ID, "stone", 1, 0),
                getModItem(Minecraft.ID, "minecart", 1, 0),
                getModItem(Minecraft.ID, "stone", 1, 0),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "stone", 1, 0),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "stone", 1, 0));
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 2),
                "stoneBricks",
                null,
                "stoneBricks",
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0),
                "plateRedAlloy",
                "stoneBricks",
                "plateRedAlloy",
                "stoneBricks");
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 3),
                "stoneMossy",
                getModItem(Minecraft.ID, "skull", 1, 2),
                "stoneMossy",
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0),
                "plateRedAlloy",
                "stoneMossy",
                "plateRedAlloy",
                "stoneMossy");
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 4),
                "stoneCobble",
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26),
                "stoneCobble",
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0),
                "plateRedAlloy",
                "stoneCobble",
                "plateRedAlloy",
                "stoneCobble");
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 5),
                getModItem(Minecraft.ID, "stone_slab", 1, 0),
                getModItem(Minecraft.ID, "skull", 1, 3),
                getModItem(Minecraft.ID, "stone_slab", 1, 0),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "stone_slab", 1, 0),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "stone_slab", 1, 0));
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 6),
                "slabWood",
                getModItem(Minecraft.ID, "tnt", 1, 0),
                "slabWood",
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0),
                "plateRedAlloy",
                "slabWood",
                "plateRedAlloy",
                "slabWood");
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 7),
                "logWood",
                "itemLeather",
                "logWood",
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0),
                "plateRedAlloy",
                "logWood",
                "plateRedAlloy",
                "logWood");
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 8),
                getModItem(Minecraft.ID, "brick", 1, 0),
                getModItem(Railcraft.ID, "machine.beta", 1, 0),
                getModItem(Minecraft.ID, "brick", 1, 0),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "brick", 1, 0),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "brick", 1, 0));
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 9),
                "plateSteel",
                getModItem(Railcraft.ID, "detector", 1, 1),
                "plateSteel",
                "plateRedAlloy",
                getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0),
                "plateRedAlloy",
                "plateSteel",
                "plateRedAlloy",
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 10),
                "plateTin",
                "cableGt01Tin",
                "plateTin",
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0),
                "plateRedAlloy",
                "plateTin",
                "plateRedAlloy",
                "plateTin");
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 11),
                "logWood",
                "cropWheat",
                "logWood",
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0),
                "plateRedAlloy",
                "logWood",
                "plateRedAlloy",
                "logWood");
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 12),
                "stoneNetherBrick",
                createItemStack(Railcraft.ID, "track", 1, 30516, "{track:\"railcraft:track.locomotive\"}"),
                "stoneNetherBrick",
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0),
                "plateRedAlloy",
                "stoneNetherBrick",
                "plateRedAlloy",
                "stoneNetherBrick");
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 13),
                "blockWool",
                getModItem(Minecraft.ID, "shears", 1, 0),
                "blockWool",
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0),
                "plateRedAlloy",
                "blockWool",
                "plateRedAlloy",
                "blockWool");
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 14),
                "itemLeather",
                "plateEmerald",
                "itemLeather",
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0),
                "plateRedAlloy",
                "itemLeather",
                "plateRedAlloy",
                "itemLeather");
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 15),
                getModItem(Railcraft.ID, "brick.infernal", 1, 0),
                createItemStack(Railcraft.ID, "track", 1, 30516, "{track:\"railcraft:track.locomotive\"}"),
                getModItem(Railcraft.ID, "brick.infernal", 1, 0),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0),
                "plateRedAlloy",
                getModItem(Railcraft.ID, "brick.infernal", 1, 0),
                "plateRedAlloy",
                getModItem(Railcraft.ID, "brick.infernal", 1, 0));
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 16),
                getModItem(Minecraft.ID, "quartz_block", 1, 1),
                getModItem(Railcraft.ID, "signal", 1, 4),
                getModItem(Minecraft.ID, "quartz_block", 1, 1),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "quartz_block", 1, 1),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "quartz_block", 1, 1));
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 2, 0),
                "stoneCobble",
                getModItem(Minecraft.ID, "hopper", 1, 0),
                "stoneCobble",
                "plateRedAlloy",
                getModItem(Railcraft.ID, "detector", 1, 0),
                "plateRedAlloy",
                "stoneCobble",
                getModItem(Minecraft.ID, "chest", 1, 0),
                "stoneCobble");
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 2, 1),
                "stoneCobble",
                getModItem(Minecraft.ID, "chest", 1, 0),
                "stoneCobble",
                "plateRedAlloy",
                getModItem(Railcraft.ID, "detector", 1, 0),
                "plateRedAlloy",
                "stoneCobble",
                getModItem(Minecraft.ID, "hopper", 1, 0),
                "stoneCobble");
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 2, 2),
                "plateSteel",
                getModItem(Minecraft.ID, "hopper", 1, 0),
                "plateSteel",
                "plateRedAlloy",
                getModItem(Railcraft.ID, "detector", 1, 1),
                "plateRedAlloy",
                "plateSteel",
                getModItem(Minecraft.ID, "chest", 1, 0),
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 2, 3),
                "plateSteel",
                getModItem(Minecraft.ID, "chest", 1, 0),
                "plateSteel",
                "plateRedAlloy",
                getModItem(Railcraft.ID, "detector", 1, 1),
                "plateRedAlloy",
                "plateSteel",
                getModItem(Minecraft.ID, "hopper", 1, 0),
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 2, 4),
                "paneGlass",
                GTOreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Steel, 1L),
                "paneGlass",
                ItemList.Electric_Pump_LV.get(1L),
                getModItem(Railcraft.ID, "detector", 1, 8),
                ItemList.Electric_Motor_LV.get(1L),
                "paneGlass",
                getModItem(Railcraft.ID, "machine.beta", 1, 0),
                "paneGlass");
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 2, 5),
                "paneGlass",
                getModItem(Railcraft.ID, "machine.beta", 1, 0),
                "paneGlass",
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(Railcraft.ID, "detector", 1, 8),
                ItemList.Electric_Pump_LV.get(1L),
                "paneGlass",
                GTOreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Steel, 1L),
                "paneGlass");
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 2, 6),
                "plateSteel",
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1L),
                "plateSteel",
                "plateRedAlloy",
                getModItem(Railcraft.ID, "detector", 1, 10),
                "plateRedAlloy",
                "plateSteel",
                getModItem(IndustrialCraft2.ID, "itemAdvBat", 1, wildcard),
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 2, 7),
                "plateSteel",
                getModItem(IndustrialCraft2.ID, "itemAdvBat", 1, wildcard),
                "plateSteel",
                "plateRedAlloy",
                getModItem(Railcraft.ID, "detector", 1, 10),
                "plateRedAlloy",
                "plateSteel",
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1L),
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 1, 8),
                getModItem(Minecraft.ID, "dispenser", 1, 0),
                getModItem(Minecraft.ID, "minecart", 1, 0),
                getModItem(Minecraft.ID, "rail", 1, 0),
                null,
                getModItem(Railcraft.ID, "tool.crowbar", 1, 0),
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 1, 9),
                getModItem(Railcraft.ID, "tool.crowbar", 1, 0),
                "plateRedAlloy",
                getModItem(Railcraft.ID, "tool.crowbar", 1, 0),
                "plateRedAlloy",
                getModItem(Railcraft.ID, "machine.gamma", 1, 8),
                "plateRedAlloy",
                getModItem(Railcraft.ID, "tool.crowbar", 1, 0),
                "plateRedAlloy",
                getModItem(Railcraft.ID, "tool.crowbar", 1, 0));
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.epsilon", 1, 0),
                "plateSteel",
                GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Copper, 1L),
                "plateSteel",
                "plateRedAlloy",
                getModItem(Railcraft.ID, "detector", 1, 10),
                "plateRedAlloy",
                "plateSteel",
                GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Copper, 1L),
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.epsilon", 1, 4),
                "plateBronze",
                GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Gold, 1L),
                "plateBronze",
                "plateRedAlloy",
                getModItem(Railcraft.ID, "detector", 1, 10),
                "plateRedAlloy",
                "plateBronze",
                getModItem(Railcraft.ID, "machine.delta", 1, 0),
                "plateBronze");
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.epsilon", 1, 3),
                "lensDiamond",
                "circuitAdvanced",
                "lensDiamond",
                ItemList.Emitter_HV.get(1L),
                ItemList.Hull_HV.get(1L),
                ItemList.Emitter_HV.get(1L),
                "cableGt01Gold",
                "circuitAdvanced",
                "cableGt01Gold");
        addShapedRecipe(
                getModItem(Railcraft.ID, "cart.work", 1, 0),
                "craftingToolHardHammer",
                getModItem(Minecraft.ID, "crafting_table", 1, 0),
                "craftingToolWrench",
                null,
                getModItem(Minecraft.ID, "minecart", 1, 0),
                null,
                null,
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "cart.tank", 1, 0),
                "craftingToolHardHammer",
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                "craftingToolWrench",
                null,
                getModItem(Minecraft.ID, "minecart", 1, 0),
                null,
                null,
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "tool.steel.shears", 1, 0),
                "plateSteel",
                "screwSteel",
                "plateSteel",
                "craftingToolHardHammer",
                "ringSteel",
                "craftingToolFile",
                "stickWood",
                "craftingToolScrewdriver",
                "stickWood");
        addShapedRecipe(
                getModItem(Railcraft.ID, "stair", 4, 6),
                "blockIron",
                null,
                null,
                "blockIron",
                "blockIron",
                null,
                "blockIron",
                "blockIron",
                "blockIron");
        addShapedRecipe(
                getModItem(Railcraft.ID, "stair", 4, 43),
                "blockSteel",
                null,
                null,
                "blockSteel",
                "blockSteel",
                null,
                "blockSteel",
                "blockSteel",
                "blockSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "stair", 4, 40),
                "blockCopper",
                null,
                null,
                "blockCopper",
                "blockCopper",
                null,
                "blockCopper",
                "blockCopper",
                "blockCopper");
        addShapedRecipe(
                getModItem(Railcraft.ID, "stair", 4, 41),
                "blockTin",
                null,
                null,
                "blockTin",
                "blockTin",
                null,
                "blockTin",
                "blockTin",
                "blockTin");
        addShapedRecipe(
                getModItem(Railcraft.ID, "stair", 4, 42),
                "blockLead",
                null,
                null,
                "blockLead",
                "blockLead",
                null,
                "blockLead",
                "blockLead",
                "blockLead");
        addShapedRecipe(
                getModItem(Railcraft.ID, "stair", 4, 7),
                "blockGold",
                null,
                null,
                "blockGold",
                "blockGold",
                null,
                "blockGold",
                "blockGold",
                "blockGold");
        addShapedRecipe(
                getModItem(Railcraft.ID, "stair", 4, 8),
                "blockDiamond",
                null,
                null,
                "blockDiamond",
                "blockDiamond",
                null,
                "blockDiamond",
                "blockDiamond",
                "blockDiamond");
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 0),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                getModItem(Railcraft.ID, "slab", 1, 28),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                "craftingToolFile",
                getModItem(Minecraft.ID, "torch", 1, 0),
                "craftingToolHardHammer",
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                getModItem(Railcraft.ID, "slab", 1, 28),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0));
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 1),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                getModItem(Railcraft.ID, "slab", 1, 26),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                "craftingToolFile",
                getModItem(Minecraft.ID, "torch", 1, 0),
                "craftingToolHardHammer",
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                getModItem(Railcraft.ID, "slab", 1, 26),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0));
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 2),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                getModItem(Railcraft.ID, "slab", 1, 27),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                "craftingToolFile",
                getModItem(Minecraft.ID, "torch", 1, 0),
                "craftingToolHardHammer",
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                getModItem(Railcraft.ID, "slab", 1, 27),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0));
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 3),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                getModItem(Railcraft.ID, "slab", 1, 24),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                "craftingToolFile",
                getModItem(Minecraft.ID, "torch", 1, 0),
                "craftingToolHardHammer",
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                getModItem(Railcraft.ID, "slab", 1, 24),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0));
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 4),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                getModItem(Railcraft.ID, "slab", 1, 23),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                "craftingToolFile",
                getModItem(Minecraft.ID, "torch", 1, 0),
                "craftingToolHardHammer",
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                getModItem(Railcraft.ID, "slab", 1, 23),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0));
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 5),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                getModItem(Railcraft.ID, "slab", 1, 29),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                "craftingToolFile",
                getModItem(Minecraft.ID, "torch", 1, 0),
                "craftingToolHardHammer",
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                getModItem(Railcraft.ID, "slab", 1, 29),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0));
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 6),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                getModItem(Railcraft.ID, "slab", 1, 25),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                "craftingToolFile",
                getModItem(Minecraft.ID, "torch", 1, 0),
                "craftingToolHardHammer",
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                getModItem(Railcraft.ID, "slab", 1, 25),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0));
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 7),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                getModItem(Railcraft.ID, "slab", 1, 22),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                "craftingToolFile",
                getModItem(Minecraft.ID, "torch", 1, 0),
                "craftingToolHardHammer",
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                getModItem(Railcraft.ID, "slab", 1, 22),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0));
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 8),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                getModItem(Minecraft.ID, "stone_slab", 1, 1),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                "craftingToolFile",
                getModItem(Minecraft.ID, "torch", 1, 0),
                "craftingToolHardHammer",
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                getModItem(Minecraft.ID, "stone_slab", 1, 1),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0));
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 9),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                getModItem(Minecraft.ID, "stone_slab", 1, 0),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                "craftingToolFile",
                getModItem(Minecraft.ID, "torch", 1, 0),
                "craftingToolHardHammer",
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                getModItem(Minecraft.ID, "stone_slab", 1, 0),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0));
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.metal", 1, 0),
                "screwAnyIron",
                "plateAnyIron",
                "screwAnyIron",
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "torch", 1, 0),
                "craftingToolHardHammer",
                "screwAnyIron",
                "plateAnyIron",
                "screwAnyIron");
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.metal", 1, 1),
                "screwGold",
                "plateGold",
                "screwGold",
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "torch", 1, 0),
                "craftingToolHardHammer",
                "screwGold",
                "plateGold",
                "screwGold");
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.metal", 1, 2),
                "screwCopper",
                "plateCopper",
                "screwCopper",
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "torch", 1, 0),
                "craftingToolHardHammer",
                "screwCopper",
                "plateCopper",
                "screwCopper");
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.metal", 1, 3),
                "screwTin",
                "plateTin",
                "screwTin",
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "torch", 1, 0),
                "craftingToolHardHammer",
                "screwTin",
                "plateTin",
                "screwTin");
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.metal", 1, 4),
                "screwLead",
                "plateLead",
                "screwLead",
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "torch", 1, 0),
                "craftingToolHardHammer",
                "screwLead",
                "plateLead",
                "screwLead");
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.metal", 1, 5),
                "screwSteel",
                "plateSteel",
                "screwSteel",
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "torch", 1, 0),
                "craftingToolHardHammer",
                "screwSteel",
                "plateSteel",
                "screwSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.signal.lamp", 8, 0),
                "paneGlass",
                createItemStack(
                        ForgeMicroblocks.ID,
                        "microblock",
                        1,
                        516,
                        "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_29\"}"),
                "plateAnyIron",
                "paneGlass",
                createItemStack(
                        ForgeMicroblocks.ID,
                        "microblock",
                        1,
                        516,
                        "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_20\"}"),
                "plateAnyIron",
                "paneGlass",
                createItemStack(
                        ForgeMicroblocks.ID,
                        "microblock",
                        1,
                        516,
                        "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_30\"}"),
                "plateAnyIron");
        addShapelessRecipe(
                getModItem(Railcraft.ID, "part.turbine.disk", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemSteamTurbineBlade", 1, 0));
        addShapelessRecipe(
                getModItem(Railcraft.ID, "part.turbine.rotor", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemSteamTurbine", 1, 0));
        addShapedRecipe(
                getModItem(Railcraft.ID, "armor.goggles", 1, 0),
                "lensGlass",
                "boltSteel",
                "lensGlass",
                "ringSteel",
                "screwSteel",
                "ringSteel",
                "itemLeather",
                getModItem(Railcraft.ID, "part.circuit", 1, 1),
                "itemLeather");
        addShapedRecipe(
                getModItem(Railcraft.ID, "tool.magnifying.glass", 1, 0),
                null,
                null,
                "lensGlass",
                null,
                "ringSteel",
                null,
                "stickSteel",
                null,
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "brick.sandy", 2, 2),
                "ingotBrick",
                "sand",
                null,
                "sand",
                "ingotBrick",
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "brick.sandy", 1, 2),
                getModItem(Railcraft.ID, "slab", 1, 22),
                null,
                null,
                getModItem(Railcraft.ID, "slab", 1, 22),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "slab", 2, 38),
                "craftingToolSaw",
                getModItem(Railcraft.ID, "cube", 1, 8));
        addShapedRecipe(
                getModItem(Railcraft.ID, "backpack.trackman.t1", 1, 0),
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0),
                getModItem(Minecraft.ID, "rail", 1, 0),
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0),
                "itemLeather",
                getModItem(Minecraft.ID, "rail", 1, 0),
                "itemLeather",
                "itemLeather",
                getModItem(Backpack.ID, "tannedLeather", 1, 0),
                "itemLeather");
        addShapelessRecipe(
                getModItem(Railcraft.ID, "backpack.trackman.t1", 1, 0),
                getModItem(Railcraft.ID, "backpack.trackman.t1", 1, 0));
        addShapedRecipe(
                getModItem(Railcraft.ID, "backpack.iceman.t1", 1, 0),
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0),
                getModItem(BiomesOPlenty.ID, "hardIce", 1, 0),
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0),
                "itemLeather",
                getModItem(BiomesOPlenty.ID, "hardIce", 1, 0),
                "itemLeather",
                "itemLeather",
                getModItem(Backpack.ID, "tannedLeather", 1, 0),
                "itemLeather");
        addShapelessRecipe(
                getModItem(Railcraft.ID, "backpack.iceman.t1", 1, 0),
                getModItem(Railcraft.ID, "backpack.iceman.t1", 1, 0));
        addShapedRecipe(
                getModItem(Railcraft.ID, "backpack.apothecary.t1", 1, 0),
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0),
                getModItem(Minecraft.ID, "potion", 1, 8229),
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0),
                "itemLeather",
                getModItem(Minecraft.ID, "potion", 1, 8229),
                "itemLeather",
                "itemLeather",
                getModItem(Backpack.ID, "tannedLeather", 1, 0),
                "itemLeather");
        addShapelessRecipe(
                getModItem(Railcraft.ID, "backpack.apothecary.t1", 1, 0),
                getModItem(Railcraft.ID, "backpack.apothecary.t1", 1, 0));
        addShapedRecipe(
                getModItem(Railcraft.ID, "brick.infernal", 2, 2),
                "ingotBrickNether",
                getModItem(Minecraft.ID, "soul_sand", 1, 0),
                null,
                getModItem(Minecraft.ID, "soul_sand", 1, 0),
                "ingotBrickNether",
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "upgrade.lapotron", 1, 0),
                "itemCasingAluminium",
                "circuitAdvanced",
                "itemCasingAluminium",
                "cableGt02Platinum",
                getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard),
                "cableGt02Platinum",
                "itemCasingAluminium",
                "circuitAdvanced",
                "itemCasingAluminium");
        addShapedRecipe(
                getModItem(Railcraft.ID, "cart.cargo", 1, 0),
                "craftingToolHardHammer",
                getModItem(Minecraft.ID, "chest", 1, 0),
                "craftingToolWrench",
                "plateSteel",
                getModItem(Minecraft.ID, "minecart", 1, 0),
                "plateSteel",
                null,
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "cart.track.relayer", 1, 0),
                ItemList.Robot_Arm_LV.get(1L),
                getModItem(IC2NuclearControl.ID, "blockNuclearControlLight", 1, 0),
                ItemList.Robot_Arm_LV.get(1L),
                ItemList.Conveyor_Module_LV.get(1L),
                "circuitBasic",
                ItemList.Conveyor_Module_LV.get(1L),
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(Minecraft.ID, "minecart", 1, 0),
                getModItem(StevesCarts2.ID, "CartModule", 1, 8));
        addShapedRecipe(
                getModItem(Railcraft.ID, "cart.undercutter", 1, 0),
                ItemList.Robot_Arm_LV.get(1L),
                getModItem(IC2NuclearControl.ID, "blockNuclearControlLight", 1, 0),
                ItemList.Robot_Arm_LV.get(1L),
                ItemList.Electric_Piston_LV.get(1L),
                "circuitBasic",
                ItemList.Electric_Piston_LV.get(1L),
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(Minecraft.ID, "minecart", 1, 0),
                ItemList.Conveyor_Module_LV.get(1L));
        addShapedRecipe(
                getModItem(Railcraft.ID, "cart.track.layer", 1, 0),
                ItemList.Robot_Arm_LV.get(1L),
                getModItem(IC2NuclearControl.ID, "blockNuclearControlLight", 1, 0),
                ItemList.Robot_Arm_LV.get(1L),
                getModItem(Minecraft.ID, "anvil", 1, 0),
                "circuitBasic",
                getModItem(Minecraft.ID, "anvil", 1, 0),
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(Minecraft.ID, "minecart", 1, 0),
                getModItem(Minecraft.ID, "dispenser", 1, 0));
        addShapedRecipe(
                getModItem(Railcraft.ID, "cart.track.remover", 1, 0),
                ItemList.Robot_Arm_LV.get(1L),
                getModItem(IC2NuclearControl.ID, "blockNuclearControlLight", 1, 0),
                ItemList.Robot_Arm_LV.get(1L),
                getModItem(Railcraft.ID, "tool.crowbar.reinforced", 1, 0),
                "circuitBasic",
                getModItem(Railcraft.ID, "tool.crowbar.reinforced", 1, 0),
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(Minecraft.ID, "minecart", 1, 0),
                ItemList.Electric_Motor_LV.get(1L));
        addShapedRecipe(
                getModItem(Railcraft.ID, "cart.redstone.flux", 1, 0),
                "plateLead",
                "craftingToolScrewdriver",
                "plateLead",
                createItemStack(EnderIO.ID, "blockCapBank", 1, 1, "{type:\"SIMPLE\",storedEnergyRF:0}"),
                "circuitBasic",
                createItemStack(EnderIO.ID, "blockCapBank", 1, 1, "{type:\"SIMPLE\",storedEnergyRF:0}"),
                "screwSteel",
                getModItem(Minecraft.ID, "minecart", 1, 0),
                "screwSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 1, 10),
                "plateLead",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0),
                "plateLead",
                "plateRedstoneAlloy",
                getModItem(Railcraft.ID, "detector", 1, 10),
                "plateRedstoneAlloy",
                "plateLead",
                createItemStack(EnderIO.ID, "blockCapBank", 1, 1, "{type:\"SIMPLE\",storedEnergyRF:0}"),
                "plateLead");
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 1, 11),
                "plateLead",
                createItemStack(EnderIO.ID, "blockCapBank", 1, 1, "{type:\"SIMPLE\",storedEnergyRF:0}"),
                "plateLead",
                "plateRedstoneAlloy",
                getModItem(Railcraft.ID, "detector", 1, 10),
                "plateRedstoneAlloy",
                "plateLead",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0),
                "plateLead");
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.epsilon", 1, 5),
                "screwSteel",
                ItemList.Cover_Crafting.get(1L),
                "screwSteel",
                "plateSteel",
                ItemList.Electric_Motor_LV.get(1L),
                "plateSteel",
                "craftingToolScrewdriver",
                "plateSteel",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(Railcraft.ID, "brick.nether", 4, 5),
                "stoneCobble",
                getModItem(Minecraft.ID, "netherrack", 1, 0),
                null,
                getModItem(Minecraft.ID, "netherrack", 1, 0),
                "stoneCobble",
                null,
                null,
                null,
                null);

        ForestryHelper.removeCarpenterRecipe(
                createItemStack(
                        Railcraft.ID,
                        "backpack.trackman.t2",
                        1,
                        0,
                        "{display:{Lore:[0:\"§7§oDesigned by Railcraft, Inc.\"]}}"));
        ForestryHelper.removeCarpenterRecipe(
                createItemStack(
                        Railcraft.ID,
                        "backpack.iceman.t2",
                        1,
                        0,
                        "{display:{Lore:[0:\"§7§oDesigned by Railcraft, Inc.\"]}}"));
        ForestryHelper.removeCarpenterRecipe(
                createItemStack(
                        Railcraft.ID,
                        "backpack.apothecary.t2",
                        1,
                        0,
                        "{display:{Lore:[0:\"§7§oDesigned by Railcraft, Inc.\"]}}"));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("seedoil", 5000),
                getModItem(Railcraft.ID, "backpack.trackman.t1", 1, 0),
                getModItem(Railcraft.ID, "backpack.trackman.t2", 1, 0),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3),
                'b',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3),
                'c',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3),
                'd',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3),
                'e',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3),
                'f',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3),
                'g',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3),
                'h',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3),
                'i',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("seedoil", 5000),
                getModItem(Railcraft.ID, "backpack.iceman.t1", 1, 0),
                getModItem(Railcraft.ID, "backpack.iceman.t2", 1, 0),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3),
                'b',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3),
                'c',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3),
                'd',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3),
                'e',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3),
                'f',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3),
                'g',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3),
                'h',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3),
                'i',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("seedoil", 5000),
                getModItem(Railcraft.ID, "backpack.apothecary.t1", 1, 0),
                getModItem(Railcraft.ID, "backpack.apothecary.t2", 1, 0),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3),
                'b',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3),
                'c',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3),
                'd',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3),
                'e',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3),
                'f',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3),
                'g',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3),
                'h',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3),
                'i',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3));

        GTValues.RA.stdBuilder().itemInputs(Materials.Creosote.getCells(1)).metadata(FUEL_VALUE, 8)
                .metadata(FUEL_TYPE, 0).duration(0).eut(0).addTo(GTRecipeConstants.Fuel);

        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.plate", 4, 0));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.plate", 4, 1));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.plate", 4, 2));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.plate", 4, 3));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.rail", 8, 0));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.rail", 6, 0));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.rail", 16, 0));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.rail", 8, 1));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.rail", 8, 3));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.rail", 8, 4));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.rail", 6, 5));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "machine.delta", 8, 0));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.rebar", 4, 0));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.rebar", 6, 0));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.rebar", 8, 0));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "post", 16, 2));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "post", 32, 2));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "post", 12, 2));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "post", 20, 2));
        RailcraftCraftingManager.rollingMachine.getRecipeList().add(
                new ShapedOreRecipe(
                        getModItem(Railcraft.ID, "post", 4, 0),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(Railcraft.ID, "part.tie", 1, 0),
                        'c',
                        getModItem(Railcraft.ID, "part.tie", 1, 0),
                        'd',
                        getModItem(Railcraft.ID, "part.tie", 1, 0),
                        'e',
                        getModItem(Railcraft.ID, "part.tie", 1, 0),
                        'f',
                        getModItem(Railcraft.ID, "part.tie", 1, 0),
                        'g',
                        getModItem(Railcraft.ID, "part.tie", 1, 0),
                        'i',
                        getModItem(Railcraft.ID, "part.tie", 1, 0)));
        RailcraftCraftingManager.rollingMachine.getRecipeList().add(
                new ShapedOreRecipe(
                        getModItem(Railcraft.ID, "post", 4, 0),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(Railcraft.ID, "part.tie", 1, 0),
                        'b',
                        getModItem(Railcraft.ID, "part.tie", 1, 0),
                        'c',
                        getModItem(Railcraft.ID, "part.tie", 1, 0),
                        'e',
                        getModItem(Railcraft.ID, "part.tie", 1, 0),
                        'g',
                        getModItem(Railcraft.ID, "part.tie", 1, 0),
                        'h',
                        getModItem(Railcraft.ID, "part.tie", 1, 0),
                        'i',
                        getModItem(Railcraft.ID, "part.tie", 1, 0)));
        RailcraftCraftingManager.rollingMachine.getRecipeList().add(
                new ShapedOreRecipe(
                        getModItem(Railcraft.ID, "post", 4, 1),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(Minecraft.ID, "stone", 1, 0),
                        'c',
                        getModItem(Minecraft.ID, "stone", 1, 0),
                        'd',
                        getModItem(Railcraft.ID, "part.rebar", 1, 0),
                        'e',
                        getModItem(Railcraft.ID, "part.rebar", 1, 0),
                        'f',
                        getModItem(Railcraft.ID, "part.rebar", 1, 0),
                        'g',
                        getModItem(Minecraft.ID, "stone", 1, 0),
                        'i',
                        getModItem(Minecraft.ID, "stone", 1, 0)));
        RailcraftCraftingManager.rollingMachine.getRecipeList().add(
                new ShapedOreRecipe(
                        getModItem(Railcraft.ID, "post", 4, 1),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(Minecraft.ID, "stone", 1, 0),
                        'b',
                        getModItem(Railcraft.ID, "part.rebar", 1, 0),
                        'c',
                        getModItem(Minecraft.ID, "stone", 1, 0),
                        'e',
                        getModItem(Railcraft.ID, "part.rebar", 1, 0),
                        'g',
                        getModItem(Minecraft.ID, "stone", 1, 0),
                        'h',
                        getModItem(Railcraft.ID, "part.rebar", 1, 0),
                        'i',
                        getModItem(Minecraft.ID, "stone", 1, 0)));
        RailcraftCraftingManager.rollingMachine.getRecipeList().add(
                new ShapedOreRecipe(
                        getModItem(Railcraft.ID, "post", 1, 4),
                        "abc",
                        "def",
                        "ghi",
                        'b',
                        getModItem(Railcraft.ID, "slab", 1, 38),
                        'e',
                        getModItem(Railcraft.ID, "post", 1, 0)));
        RailcraftCraftingManager.rollingMachine.getRecipeList().add(
                new ShapedOreRecipe(
                        getModItem(Railcraft.ID, "post", 1, 5),
                        "abc",
                        "def",
                        "ghi",
                        'b',
                        getModItem(Railcraft.ID, "slab", 1, 2),
                        'e',
                        getModItem(Railcraft.ID, "post", 1, 1)));
        RailcraftCraftingManager.rollingMachine.getRecipeList().add(
                new ShapedOreRecipe(
                        getModItem(Railcraft.ID, "post", 1, 6),
                        "abc",
                        "def",
                        "ghi",
                        'b',
                        getModItem(Railcraft.ID, "slab", 1, 6),
                        'e',
                        getModItem(Railcraft.ID, "post", 1, 2)));
        RailcraftCraftingManager.rollingMachine.getRecipeList().add(
                new ShapedOreRecipe(
                        getModItem(Railcraft.ID, "post", 16, 2),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "stickAnyIron",
                        'b',
                        "stickAnyIron",
                        'c',
                        "stickAnyIron",
                        'e',
                        "stickAnyIron",
                        'g',
                        "stickAnyIron",
                        'h',
                        "stickAnyIron",
                        'i',
                        "stickAnyIron"));
        RailcraftCraftingManager.rollingMachine.getRecipeList().add(
                new ShapedOreRecipe(
                        getModItem(Railcraft.ID, "post", 16, 2),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "stickAnyIron",
                        'c',
                        "stickAnyIron",
                        'd',
                        "stickAnyIron",
                        'e',
                        "stickAnyIron",
                        'f',
                        "stickAnyIron",
                        'g',
                        "stickAnyIron",
                        'i',
                        "stickAnyIron"));
        RailcraftCraftingManager.rollingMachine.getRecipeList().add(
                new ShapedOreRecipe(
                        getModItem(Railcraft.ID, "post", 12, 2),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "stickBronze",
                        'b',
                        "stickBronze",
                        'c',
                        "stickBronze",
                        'e',
                        "stickBronze",
                        'g',
                        "stickBronze",
                        'h',
                        "stickBronze",
                        'i',
                        "stickBronze"));
        RailcraftCraftingManager.rollingMachine.getRecipeList().add(
                new ShapedOreRecipe(
                        getModItem(Railcraft.ID, "post", 12, 2),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "stickBronze",
                        'c',
                        "stickBronze",
                        'd',
                        "stickBronze",
                        'e',
                        "stickBronze",
                        'f',
                        "stickBronze",
                        'g',
                        "stickBronze",
                        'i',
                        "stickBronze"));
        RailcraftCraftingManager.rollingMachine.getRecipeList().add(
                new ShapedOreRecipe(
                        getModItem(Railcraft.ID, "post", 32, 2),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "stickSteel",
                        'b',
                        "stickSteel",
                        'c',
                        "stickSteel",
                        'e',
                        "stickSteel",
                        'g',
                        "stickSteel",
                        'h',
                        "stickSteel",
                        'i',
                        "stickSteel"));
        RailcraftCraftingManager.rollingMachine.getRecipeList().add(
                new ShapedOreRecipe(
                        getModItem(Railcraft.ID, "post", 32, 2),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "stickSteel",
                        'c',
                        "stickSteel",
                        'd',
                        "stickSteel",
                        'e',
                        "stickSteel",
                        'f',
                        "stickSteel",
                        'g',
                        "stickSteel",
                        'i',
                        "stickSteel"));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.plate", 4, 4));
        RecipeManagers.fabricatorManager.addRecipe(
                getModItem(Forestry.ID, "waxCast", 1, wildcard),
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem(Railcraft.ID, "glass", 4, 0),
                new Object[] { "abc", "def", "ghi", 'a',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L), 'b',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Saltpeter, 1L), 'c',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L), 'd',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1L), 'e',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L), 'f',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L), 'g',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L), 'h',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Saltpeter, 1L), 'i',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L) });
        RecipeManagers.fabricatorManager.addRecipe(
                getModItem(Forestry.ID, "waxCast", 1, wildcard),
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem(Railcraft.ID, "glass", 4, 0),
                new Object[] { "abc", "def", "ghi", 'a',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L), 'b',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Saltpeter, 1L), 'c',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L), 'd',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1L), 'e',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L), 'f',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L), 'g',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L), 'h',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Saltpeter, 1L), 'i',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L) });
        RecipeManagers.fabricatorManager.addRecipe(
                getModItem(Forestry.ID, "waxCast", 1, wildcard),
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem(Railcraft.ID, "glass", 4, 0),
                new Object[] { "abc", "def", "ghi", 'a',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L), 'b',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Saltpeter, 1L), 'c',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L), 'd',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1L), 'e',
                        NHItemList.ChargedCertusQuartzDust.get(), 'f',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L), 'g',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L), 'h',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Saltpeter, 1L), 'i',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L) });
        RecipeManagers.fabricatorManager.addRecipe(
                getModItem(Forestry.ID, "waxCast", 1, wildcard),
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem(Railcraft.ID, "glass", 4, 0),
                new Object[] { "abc", "def", "ghi", 'a',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L), 'b',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Saltpeter, 1L), 'c',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L), 'd',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1L), 'e',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 1L), 'f',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L), 'g',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L), 'h',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Saltpeter, 1L), 'i',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L) });

        GTValues.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "cube", 1, 7))
                .itemOutputs(Materials.Marble.getDust(1)).duration(8 * SECONDS).eut(4).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "torch", 1, 0), getModItem(Railcraft.ID, "slab", 2, 28))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 0)).duration(10 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "torch", 1, 0), getModItem(Railcraft.ID, "slab", 2, 26))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 1)).duration(10 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "torch", 1, 0), getModItem(Railcraft.ID, "slab", 2, 27))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 2)).duration(10 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "torch", 1, 0), getModItem(Railcraft.ID, "slab", 2, 24))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 3)).duration(10 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "torch", 1, 0), getModItem(Railcraft.ID, "slab", 2, 23))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 4)).duration(10 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "torch", 1, 0), getModItem(Railcraft.ID, "slab", 2, 29))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 5)).duration(10 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "torch", 1, 0), getModItem(Railcraft.ID, "slab", 2, 25))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 6)).duration(10 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "torch", 1, 0), getModItem(Railcraft.ID, "slab", 2, 22))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 7)).duration(10 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "torch", 1, 0), getModItem(Minecraft.ID, "stone_slab", 2, 1))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 8)).duration(10 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "torch", 1, 0), getModItem(Minecraft.ID, "stone_slab", 2, 0))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 9)).duration(10 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "stone", 5, 0), getModItem(Railcraft.ID, "part.rebar", 4, 0))
                .itemOutputs(getModItem(Railcraft.ID, "cube", 5, 1)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 5L),
                        NHItemList.MoldHelmet.get(0))
                .itemOutputs(getModItem(Railcraft.ID, "armor.steel.helmet", 1, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 8L),
                        NHItemList.MoldChestplate.get(0))
                .itemOutputs(getModItem(Railcraft.ID, "armor.steel.plate", 1, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 7L),
                        NHItemList.MoldLeggings.get(0))
                .itemOutputs(getModItem(Railcraft.ID, "armor.steel.legs", 1, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 4L),
                        NHItemList.MoldBoots.get(0))
                .itemOutputs(getModItem(Railcraft.ID, "armor.steel.boots", 1, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "minecart", 1, 0),
                        getModItem(Minecraft.ID, "crafting_table", 1, 0))
                .circuit(1).itemOutputs(getModItem(Railcraft.ID, "cart.work", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "minecart", 1, 0), getModItem(Railcraft.ID, "machine.alpha", 1, 2))
                .circuit(1).itemOutputs(getModItem(Railcraft.ID, "cart.anchor.personal", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "minecart", 1, 0), getModItem(Railcraft.ID, "machine.alpha", 1, 0))
                .circuit(1).itemOutputs(getModItem(Railcraft.ID, "cart.anchor", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "minecart", 1, 0),
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0))
                .circuit(1).itemOutputs(getModItem(Railcraft.ID, "cart.tank", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "minecart", 1, 0),
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 0))
                .circuit(1).itemOutputs(getModItem(Railcraft.ID, "cart.energy.batbox", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "minecart", 1, 0),
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 7))
                .circuit(1).itemOutputs(getModItem(Railcraft.ID, "cart.energy.cesu", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "minecart", 1, 0),
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 1))
                .circuit(1).itemOutputs(getModItem(Railcraft.ID, "cart.energy.mfe", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemToolMEter", 1, 0),
                        getModItem(Railcraft.ID, "part.circuit", 1, 1))
                .circuit(1).itemOutputs(getModItem(Railcraft.ID, "tool.electric.meter", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemFreq", 1, 0),
                        getModItem(Railcraft.ID, "part.circuit", 1, 1))
                .circuit(1).itemOutputs(getModItem(Railcraft.ID, "tool.signal.tuner", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Railcraft.ID, "tool.signal.tuner", 1, 0),
                        getModItem(Minecraft.ID, "compass", 1, 0))
                .circuit(1).itemOutputs(getModItem(Railcraft.ID, "tool.surveyor", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Railcraft.ID, "firestone.cut", 1, 0),
                        getModItem(Minecraft.ID, "redstone_block", 16, 0))
                .circuit(1).itemOutputs(getModItem(Railcraft.ID, "firestone.refined", 1, 5000))
                .fluidInputs(FluidRegistry.getFluidStack("lava", 16000)).duration(10 * MINUTES).eut(TierEU.RECIPE_MV)
                .specialValue(1200).addTo(blastFurnaceRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Railcraft.ID, "firestone.cracked", 1, 0),
                        getModItem(Minecraft.ID, "redstone_block", 16, 0))
                .circuit(1).itemOutputs(getModItem(Railcraft.ID, "firestone.refined", 1, 5000))
                .fluidInputs(FluidRegistry.getFluidStack("lava", 8000)).duration(5 * MINUTES).eut(TierEU.RECIPE_MV)
                .specialValue(1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "cube", 1, 8))
                .itemOutputs(getModItem(Railcraft.ID, "slab", 2, 38))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "cube", 1, 8))
                .itemOutputs(getModItem(Railcraft.ID, "slab", 2, 38))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "cube", 1, 8))
                .itemOutputs(getModItem(Railcraft.ID, "slab", 2, 38))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "cube", 1, 8))
                .itemOutputs(getModItem(Railcraft.ID, "slab", 2, 38))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(2 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "cube", 1, 0))
                .itemOutputs(getModItem(Railcraft.ID, "fuel.coke", 9, 0)).duration(5 * SECONDS).eut(24)
                .addTo(hammerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "clay_ball", 1, 0),
                        getModItem(Minecraft.ID, "dye", 1, 15),
                        getModItem(Minecraft.ID, "dye", 1, 15),
                        getModItem(Minecraft.ID, "dye", 1, 15))
                .itemOutputs(getModItem(Railcraft.ID, "part.bleached.clay", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1L)),
                        getModItem(Railcraft.ID, "firestone.raw", 1, 0))
                .itemOutputs(getModItem(Railcraft.ID, "firestone.cut", 1, 0)).duration(8 * MINUTES)
                .eut(TierEU.RECIPE_LV).addTo(laserEngraverRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Firestone, 1L)),
                        getModItem(Railcraft.ID, "firestone.raw", 1, 0))
                .itemOutputs(getModItem(Railcraft.ID, "firestone.cut", 1, 0)).duration(2 * MINUTES)
                .eut(TierEU.RECIPE_LV).addTo(laserEngraverRecipes);

        TCHelper.removeArcaneRecipe(getModItem(Railcraft.ID, "tool.crowbar.magic", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Railcraft.ID, "tool.crowbar.void", 1, 0));
        TCHelper.moveResearch("RC_Crowbar", "ARTIFICE", 0, -4);
        TCHelper.clearPrereq("RC_Crowbar");
        TCHelper.addResearchPrereq("RC_Crowbar", "THAUMIUM", false);
        TCHelper.clearPages("RC_Crowbar");
        TCHelper.addResearchPage("RC_Crowbar", new ResearchPage("thaumcraft.research.RC_Crowbar.page.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RC_Crowbar",
                getModItem(Railcraft.ID, "tool.crowbar.magic", 1, 0),
                new AspectList().add(Aspect.getAspect("ordo"), 24).add(Aspect.getAspect("ignis"), 24)
                        .add(Aspect.getAspect("aer"), 24),
                "abc",
                "def",
                "ghi",
                'a',
                "craftingToolHardHammer",
                'b',
                "dyeRed",
                'c',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Thaumium, 1L),
                'd',
                "dyeRed",
                'e',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Thaumium, 1L),
                'f',
                "dyeRed",
                'g',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Thaumium, 1L),
                'h',
                "dyeRed",
                'i',
                "craftingToolFile");
        TCHelper.addResearchPage(
                "RC_Crowbar",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Railcraft.ID, "tool.crowbar.magic", 1, 0))));
        TCHelper.refreshResearchPages("RC_Crowbar");
        TCHelper.moveResearch("RC_Crowbar_Void", "ELDRITCH", 2, -4);
        TCHelper.clearPrereq("RC_Crowbar_Void");
        TCHelper.addResearchPrereq("RC_Crowbar_Void", "VOIDMETAL", false);
        TCHelper.addResearchPrereq("RC_Crowbar_Void", "RC_Crowbar", false);
        TCHelper.clearPages("RC_Crowbar_Void");
        TCHelper.addResearchPage("RC_Crowbar_Void", new ResearchPage("thaumcraft.research.RC_Crowbar_Void.page.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RC_Crowbar_Void",
                getModItem(Railcraft.ID, "tool.crowbar.void", 1, 0),
                new AspectList().add(Aspect.getAspect("perditio"), 50).add(Aspect.getAspect("ignis"), 50)
                        .add(Aspect.getAspect("aer"), 50).add(Aspect.getAspect("terra"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                "craftingToolHardHammer",
                'b',
                "dyeRed",
                'c',
                "stickVoid",
                'd',
                "dyeRed",
                'e',
                "stickVoid",
                'f',
                "dyeRed",
                'g',
                "stickVoid",
                'h',
                "dyeRed",
                'i',
                "craftingToolFile");
        TCHelper.addResearchPage(
                "RC_Crowbar_Void",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Railcraft.ID, "tool.crowbar.void", 1, 0))));
        ThaumcraftApi.addWarpToResearch("RC_Crowbar_Void", 2);
        TCHelper.refreshResearchPages("RC_Crowbar_Void");
        ResearchCategories.researchCategories.remove("RAILCRAFT");
    }
}
