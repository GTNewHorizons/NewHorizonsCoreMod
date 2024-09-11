package com.dreammaster.scripts;

import static com.dreammaster.main.MainRegistry.Module_CustomFuels;
import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.BiomesOPlenty;
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
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
import static gregtech.api.recipe.RecipeMaps.hammerRecipes;
import static gregtech.api.recipe.RecipeMaps.laserEngraverRecipes;
import static gregtech.api.recipe.RecipeMaps.mixerRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeConstants.FUEL_TYPE;
import static gregtech.api.util.GTRecipeConstants.FUEL_VALUE;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.dreammaster.forestry.ForestryHelper;
import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.railcraft.RailcraftHelper;
import com.dreammaster.thaumcraft.TCHelper;

import forestry.api.recipes.RecipeManagers;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
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
                Railcraft.ID,
                Thaumcraft.ID,
                Backpack.ID,
                BiomesOPlenty.ID,
                EnderIO.ID,
                Forestry.ID,
                ForgeMicroblocks.ID,
                IC2NuclearControl.ID,
                IndustrialCraft2.ID,
                PamsHarvestCraft.ID,
                ProjectRedIntegration.ID,
                StevesCarts2.ID);
    }

    @Override
    public void loadRecipes() {

        addShapedRecipe(
                getModItem(Railcraft.ID, "part.rebar", 2, 0, missing),
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
                getModItem(Railcraft.ID, "part.tie", 1, 1, missing),
                null,
                getModItem(Railcraft.ID, "part.rebar", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "stone_slab", 1, 0, missing),
                getModItem(Minecraft.ID, "stone_slab", 1, 0, missing),
                getModItem(Minecraft.ID, "stone_slab", 1, 0, missing),
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                getModItem(Railcraft.ID, "part.tie", 1, 0, missing),
                getModItem(Railcraft.ID, "part.tie", 1, 0, missing),
                getModItem(Railcraft.ID, "part.tie", 1, 0, missing),
                getModItem(Railcraft.ID, "part.tie", 1, 0, missing),
                null,
                "craftingToolSoftHammer",
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.railbed", 1, 1, missing),
                getModItem(Railcraft.ID, "part.tie", 1, 1, missing),
                getModItem(Railcraft.ID, "part.tie", 1, 1, missing),
                getModItem(Railcraft.ID, "part.tie", 1, 1, missing),
                getModItem(Railcraft.ID, "part.tie", 1, 1, missing),
                null,
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "frame", 1, 0, missing),
                "plateAnyRubber",
                "plateSteel",
                "plateAnyRubber",
                getModItem(Railcraft.ID, "part.rebar", 1, 0, missing),
                "craftingToolWrench",
                getModItem(Railcraft.ID, "part.rebar", 1, 0, missing),
                getModItem(Railcraft.ID, "part.rebar", 1, 0, missing),
                getModItem(Railcraft.ID, "part.rebar", 1, 0, missing),
                getModItem(Railcraft.ID, "part.rebar", 1, 0, missing));
        addShapedRecipe(
                getModItem(Railcraft.ID, "slab", 2, 2, missing),
                "craftingToolSaw",
                getModItem(Railcraft.ID, "cube", 1, 1, missing));
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.control\"}", missing),
                "screwSteel",
                "stickRedAlloy",
                "screwSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 1, missing),
                getModItem(Minecraft.ID, "rail", 1, 0, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 1, missing),
                "craftingToolScrewdriver",
                "stickRedAlloy",
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 20176, "{track:\"railcraft:track.locking\"}", missing),
                "screwSteel",
                getModItem(Railcraft.ID, "detector", 1, 1, missing),
                "screwSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 1, missing),
                getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 1, missing),
                "craftingToolScrewdriver",
                "stickRedAlloy",
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 23575, "{track:\"railcraft:track.disembarking\"}", missing),
                "screwSteel",
                getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                "screwSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 1, missing),
                getModItem(Railcraft.ID, "detector", 1, 9, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 1, missing),
                "craftingToolScrewdriver",
                "stickRedAlloy",
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.embarking\"}", missing),
                "screwSteel",
                "gemEnderEye",
                "screwSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 1, missing),
                getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 1, missing),
                "craftingToolScrewdriver",
                "gemEnderEye",
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.coupler\"}", missing),
                "screwSteel",
                getModItem(Railcraft.ID, "tool.crowbar.reinforced", 1, 0, missing),
                "screwSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 1, missing),
                getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 1, missing),
                "craftingToolScrewdriver",
                getModItem(Railcraft.ID, "tool.crowbar.reinforced", 1, 0, missing),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.whistle\"}", missing),
                "screwAnyIron",
                getModItem(Railcraft.ID, "tool.whistle.tuner", 1, 0, missing),
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                "craftingToolScrewdriver",
                ItemList.Casing_Stripes_A.get(1L),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 30516, "{track:\"railcraft:track.locomotive\"}", missing),
                "screwAnyIron",
                getModItem(Railcraft.ID, "signal", 1, 11, missing),
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(Railcraft.ID, "signal", 1, 3, missing),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 16093, "{track:\"railcraft:track.limiter\"}", missing),
                "screwAnyIron",
                "plateRedAlloy",
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(Railcraft.ID, "detector", 1, 1, missing),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.routing\"}", missing),
                "screwAnyIron",
                "plateRedAlloy",
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(Railcraft.ID, "routing.ticket", 1, 0, missing),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.routing\"}", missing),
                "screwAnyIron",
                "plateRedAlloy",
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(Railcraft.ID, "routing.ticket.gold", 1, 0, missing),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 2, 32363, "{track:\"railcraft:track.buffer.stop\"}", missing),
                "screwAnyIron",
                "plateSteel",
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                "craftingToolScrewdriver",
                "blockSteel",
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 30946, "{track:\"railcraft:track.oneway\"}", missing),
                "screwAnyIron",
                getModItem(Railcraft.ID, "detector", 1, 1, missing),
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "piston", 1, 0, missing),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.detector.direction\"}", missing),
                "screwAnyIron",
                "plateRedAlloy",
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(Railcraft.ID, "detector", 1, 9, missing),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.gated.oneway\"}", missing),
                "screwSteel",
                "plateRedAlloy",
                "screwSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 1, missing),
                createItemStack(Railcraft.ID, "track", 1, 19746, "{track:\"railcraft:track.gated\"}", missing),
                getModItem(Railcraft.ID, "part.rail", 1, 1, missing),
                "craftingToolScrewdriver",
                "plateRedAlloy",
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 19746, "{track:\"railcraft:track.gated\"}", missing),
                "screwAnyIron",
                getModItem(Minecraft.ID, "fence_gate", 1, 0, missing),
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "fence_gate", 1, 0, missing),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.suspended\"}", missing),
                "screwAnyIron",
                getModItem(Railcraft.ID, "post", 1, 2, missing),
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(Railcraft.ID, "post", 1, 2, missing),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 2264, "{track:\"railcraft:track.disposal\"}", missing),
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.tie", 1, 0, missing),
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                "plateSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(Railcraft.ID, "part.tie", 1, 0, missing),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 16, 736, "{track:\"railcraft:track.slow\"}", missing),
                "screwAnyIron",
                null,
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 2, missing),
                getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 2, missing),
                "craftingToolScrewdriver",
                null,
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 4, 0, "{track:\"railcraft:track.slow.boost\"}", missing),
                "screwAnyIron",
                "plateRedAlloy",
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 1, missing),
                getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 1, missing),
                "craftingToolScrewdriver",
                "plateRedAlloy",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(Minecraft.ID, "golden_rail", 4, 0, missing),
                "screwSteel",
                "plateRedAlloy",
                "screwSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 1, missing),
                getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 1, missing),
                "craftingToolScrewdriver",
                "plateRedAlloy",
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 8, 0, "{track:\"railcraft:track.reinforced\"}", missing),
                "screwStainlessSteel",
                null,
                "screwStainlessSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 4, missing),
                getModItem(Railcraft.ID, "part.railbed", 1, 1, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 4, missing),
                "craftingToolScrewdriver",
                null,
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 4, 0, "{track:\"railcraft:track.reinforced.boost\"}", missing),
                "screwStainlessSteel",
                "plateRedAlloy",
                "screwStainlessSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 4, missing),
                getModItem(Railcraft.ID, "part.railbed", 1, 1, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 4, missing),
                "craftingToolScrewdriver",
                "plateRedAlloy",
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 8, 10192, "{track:\"railcraft:track.electric\"}", missing),
                "screwCopper",
                getModItem(Railcraft.ID, "part.rail", 1, 5, missing),
                "screwCopper",
                getModItem(Railcraft.ID, "part.rail", 1, 5, missing),
                getModItem(Railcraft.ID, "part.railbed", 1, 1, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 5, missing),
                "craftingToolScrewdriver",
                getModItem(Railcraft.ID, "part.rail", 1, 5, missing),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 8, 816, "{track:\"railcraft:track.speed\"}", missing),
                "screwSteel",
                null,
                "screwSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 3, missing),
                getModItem(Railcraft.ID, "part.railbed", 1, 1, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 3, missing),
                "craftingToolScrewdriver",
                null,
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 4, 0, "{track:\"railcraft:track.speed.boost\"}", missing),
                "screwSteel",
                "plateRedAlloy",
                "screwSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 3, missing),
                getModItem(Railcraft.ID, "part.railbed", 1, 1, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 3, missing),
                "craftingToolScrewdriver",
                "plateRedAlloy",
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(
                        Railcraft.ID,
                        "track",
                        1,
                        26865,
                        "{track:\"railcraft:track.speed.transition\"}",
                        missing),
                "screwSteel",
                createItemStack(Railcraft.ID, "track", 1, 816, "{track:\"railcraft:track.speed\"}", missing),
                "screwSteel",
                "plateRedAlloy",
                getModItem(Railcraft.ID, "part.railbed", 1, 1, missing),
                "plateRedAlloy",
                "craftingToolScrewdriver",
                createItemStack(Railcraft.ID, "track", 1, 816, "{track:\"railcraft:track.speed\"}", missing),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 8103, "{track:\"railcraft:track.priming\"}", missing),
                "screwSteel",
                getModItem(Railcraft.ID, "detector", 1, 1, missing),
                "screwSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 4, missing),
                getModItem(Railcraft.ID, "part.railbed", 1, 1, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 4, missing),
                "craftingToolScrewdriver",
                ItemList.Tool_Lighter_Invar_Full.get(1L),
                "craftingToolHardHammer");
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.launcher\"}", missing),
                "screwSteel",
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.reinforced\"}", missing),
                "screwSteel",
                "blockSteel",
                getModItem(Minecraft.ID, "piston", 1, 0, missing),
                "blockSteel",
                "craftingToolScrewdriver",
                "plateRedAlloy",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(Railcraft.ID, "track.elevator", 2, 0, missing),
                "screwSteel",
                getModItem(Railcraft.ID, "detector", 1, 1, missing),
                "screwSteel",
                getModItem(Railcraft.ID, "part.rail", 1, 1, missing),
                getModItem(Minecraft.ID, "rail", 1, 0, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 1, missing),
                "craftingToolScrewdriver",
                "plateRedAlloy",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 4, missing),
                "screwSteel",
                "stickRedAlloy",
                "stickTin",
                getModItem(Minecraft.ID, "lever", 1, 0, missing),
                getModItem(Minecraft.ID, "sticky_piston", 1, 0, missing),
                "screwSteel",
                "plateSteel",
                "plateSteel",
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 2, missing),
                "screwSteel",
                "stickRedAlloy",
                "stickTin",
                ItemList.Electric_Motor_LV.get(1L),
                ItemList.Electric_Piston_LV.get(1L),
                getModItem(Railcraft.ID, "part.circuit", 1, 1, missing),
                "plateSteel",
                "plateSteel",
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 3, missing),
                getModItem(Railcraft.ID, "part.signal.lamp", 1, 0, missing),
                getModItem(Railcraft.ID, "part.circuit", 1, 2, missing),
                "plateSteel",
                null,
                null,
                "plateSteel",
                null,
                null,
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 11, missing),
                getModItem(Railcraft.ID, "part.signal.lamp", 1, 0, missing),
                getModItem(Railcraft.ID, "part.circuit", 1, 1, missing),
                "plateSteel",
                null,
                null,
                "plateSteel",
                null,
                null,
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 1, missing),
                getModItem(Railcraft.ID, "part.signal.lamp", 1, 0, missing),
                getModItem(Railcraft.ID, "part.circuit", 1, 2, missing),
                "plateSteel",
                "plateSteel",
                "plateSteel",
                "plateSteel",
                getModItem(Railcraft.ID, "part.signal.lamp", 1, 0, missing),
                getModItem(Railcraft.ID, "part.circuit", 1, 1, missing),
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 12, missing),
                getModItem(Railcraft.ID, "part.signal.lamp", 1, 0, missing),
                getModItem(Railcraft.ID, "part.circuit", 1, 1, missing),
                "plateSteel",
                "plateSteel",
                "plateSteel",
                "plateSteel",
                getModItem(Railcraft.ID, "part.signal.lamp", 1, 0, missing),
                getModItem(Railcraft.ID, "part.circuit", 1, 1, missing),
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 13, missing),
                "plateSteel",
                getModItem(Railcraft.ID, "part.circuit", 1, 2, missing),
                "plateSteel",
                "plateSteel",
                "plateRedAlloy",
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 9, missing),
                "plateSteel",
                getModItem(Railcraft.ID, "part.circuit", 1, 0, missing),
                "plateSteel",
                "plateSteel",
                "plateRedAlloy",
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 10, missing),
                "plateSteel",
                getModItem(Railcraft.ID, "part.circuit", 1, 0, missing),
                "plateSteel",
                "plateSteel",
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26, missing),
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 8, missing),
                "plateSteel",
                getModItem(Railcraft.ID, "part.circuit", 1, 1, missing),
                "plateSteel",
                "plateSteel",
                "plateRedAlloy",
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 7, missing),
                "plateSteel",
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 10, missing),
                "plateSteel",
                "plateSteel",
                "plateRedAlloy",
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 6, missing),
                "plateSteel",
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26, missing),
                "plateSteel",
                "plateSteel",
                "plateRedAlloy",
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 0, missing),
                "plateSteel",
                getModItem(Railcraft.ID, "part.circuit", 1, 1, missing),
                "plateSteel",
                "plateSteel",
                getModItem(Railcraft.ID, "part.circuit", 1, 0, missing),
                "plateSteel",
                "plateSteel",
                "plateRedAlloy",
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.rail", 12, 2, missing),
                "stickAnyIron",
                getModItem(Railcraft.ID, "part.tie", 1, 0, missing),
                "stickWood",
                "stickAnyIron",
                getModItem(Railcraft.ID, "part.tie", 1, 0, missing),
                "stickWood",
                "stickAnyIron",
                getModItem(Railcraft.ID, "part.tie", 1, 0, missing),
                "stickWood");
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.rail", 8, 2, missing),
                "stickAnyIron",
                getModItem(Railcraft.ID, "part.tie", 1, 0, missing),
                "stickWood",
                "stickAnyIron",
                getModItem(Railcraft.ID, "part.tie", 1, 0, missing),
                "stickWood",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.rail", 4, 2, missing),
                "stickAnyIron",
                getModItem(Railcraft.ID, "part.tie", 1, 0, missing),
                "stickWood",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.rail", 12, 0, missing),
                "stickAnyIron",
                getModItem(Railcraft.ID, "part.tie", 1, 1, missing),
                "stickAnyIron",
                "stickAnyIron",
                getModItem(Railcraft.ID, "part.tie", 1, 1, missing),
                "stickAnyIron",
                "stickAnyIron",
                getModItem(Railcraft.ID, "part.tie", 1, 1, missing),
                "stickAnyIron");
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.rail", 8, 0, missing),
                "stickAnyIron",
                getModItem(Railcraft.ID, "part.tie", 1, 1, missing),
                "stickAnyIron",
                "stickAnyIron",
                getModItem(Railcraft.ID, "part.tie", 1, 1, missing),
                "stickAnyIron",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.rail", 4, 0, missing),
                "stickAnyIron",
                getModItem(Railcraft.ID, "part.tie", 1, 1, missing),
                "stickAnyIron",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.rail", 4, 1, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                "plateRedstone",
                "stickElectrum",
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                "plateRedstone",
                "stickElectrum",
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                "craftingToolHardHammer",
                "stickElectrum");
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 0, missing),
                "logWood",
                getModItem(Minecraft.ID, "rail", 1, 0, missing),
                "logWood",
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing),
                "plateRedAlloy",
                "logWood",
                "plateRedAlloy",
                "logWood");
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 1, missing),
                getModItem(Minecraft.ID, "stone", 1, 0, missing),
                getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                getModItem(Minecraft.ID, "stone", 1, 0, missing),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "stone", 1, 0, missing),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "stone", 1, 0, missing));
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 2, missing),
                "stoneBricks",
                null,
                "stoneBricks",
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing),
                "plateRedAlloy",
                "stoneBricks",
                "plateRedAlloy",
                "stoneBricks");
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 3, missing),
                "stoneMossy",
                getModItem(Minecraft.ID, "skull", 1, 2, missing),
                "stoneMossy",
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing),
                "plateRedAlloy",
                "stoneMossy",
                "plateRedAlloy",
                "stoneMossy");
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 4, missing),
                "stoneCobble",
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26, missing),
                "stoneCobble",
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing),
                "plateRedAlloy",
                "stoneCobble",
                "plateRedAlloy",
                "stoneCobble");
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 5, missing),
                getModItem(Minecraft.ID, "stone_slab", 1, 0, missing),
                getModItem(Minecraft.ID, "skull", 1, 3, missing),
                getModItem(Minecraft.ID, "stone_slab", 1, 0, missing),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "stone_slab", 1, 0, missing),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "stone_slab", 1, 0, missing));
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 6, missing),
                "slabWood",
                getModItem(Minecraft.ID, "tnt", 1, 0, missing),
                "slabWood",
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing),
                "plateRedAlloy",
                "slabWood",
                "plateRedAlloy",
                "slabWood");
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 7, missing),
                "logWood",
                "itemLeather",
                "logWood",
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing),
                "plateRedAlloy",
                "logWood",
                "plateRedAlloy",
                "logWood");
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 8, missing),
                getModItem(Minecraft.ID, "brick", 1, 0, missing),
                getModItem(Railcraft.ID, "machine.beta", 1, 0, missing),
                getModItem(Minecraft.ID, "brick", 1, 0, missing),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "brick", 1, 0, missing),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "brick", 1, 0, missing));
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 9, missing),
                "plateSteel",
                getModItem(Railcraft.ID, "detector", 1, 1, missing),
                "plateSteel",
                "plateRedAlloy",
                getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0, missing),
                "plateRedAlloy",
                "plateSteel",
                "plateRedAlloy",
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 10, missing),
                "plateTin",
                "cableGt01Tin",
                "plateTin",
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing),
                "plateRedAlloy",
                "plateTin",
                "plateRedAlloy",
                "plateTin");
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 11, missing),
                "logWood",
                "cropWheat",
                "logWood",
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing),
                "plateRedAlloy",
                "logWood",
                "plateRedAlloy",
                "logWood");
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 12, missing),
                "stoneNetherBrick",
                createItemStack(Railcraft.ID, "track", 1, 30516, "{track:\"railcraft:track.locomotive\"}", missing),
                "stoneNetherBrick",
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing),
                "plateRedAlloy",
                "stoneNetherBrick",
                "plateRedAlloy",
                "stoneNetherBrick");
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 13, missing),
                "blockWool",
                getModItem(Minecraft.ID, "shears", 1, 0, missing),
                "blockWool",
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing),
                "plateRedAlloy",
                "blockWool",
                "plateRedAlloy",
                "blockWool");
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 14, missing),
                "itemLeather",
                "plateEmerald",
                "itemLeather",
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing),
                "plateRedAlloy",
                "itemLeather",
                "plateRedAlloy",
                "itemLeather");
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 15, missing),
                getModItem(Railcraft.ID, "brick.infernal", 1, 0, missing),
                createItemStack(Railcraft.ID, "track", 1, 30516, "{track:\"railcraft:track.locomotive\"}", missing),
                getModItem(Railcraft.ID, "brick.infernal", 1, 0, missing),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing),
                "plateRedAlloy",
                getModItem(Railcraft.ID, "brick.infernal", 1, 0, missing),
                "plateRedAlloy",
                getModItem(Railcraft.ID, "brick.infernal", 1, 0, missing));
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 16, missing),
                getModItem(Minecraft.ID, "quartz_block", 1, 1, missing),
                getModItem(Railcraft.ID, "signal", 1, 4, missing),
                getModItem(Minecraft.ID, "quartz_block", 1, 1, missing),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "quartz_block", 1, 1, missing),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "quartz_block", 1, 1, missing));
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 2, 0, missing),
                "stoneCobble",
                getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                "stoneCobble",
                "plateRedAlloy",
                getModItem(Railcraft.ID, "detector", 1, 0, missing),
                "plateRedAlloy",
                "stoneCobble",
                getModItem(Minecraft.ID, "chest", 1, 0, missing),
                "stoneCobble");
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 2, 1, missing),
                "stoneCobble",
                getModItem(Minecraft.ID, "chest", 1, 0, missing),
                "stoneCobble",
                "plateRedAlloy",
                getModItem(Railcraft.ID, "detector", 1, 0, missing),
                "plateRedAlloy",
                "stoneCobble",
                getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                "stoneCobble");
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 2, 2, missing),
                "plateSteel",
                getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                "plateSteel",
                "plateRedAlloy",
                getModItem(Railcraft.ID, "detector", 1, 1, missing),
                "plateRedAlloy",
                "plateSteel",
                getModItem(Minecraft.ID, "chest", 1, 0, missing),
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 2, 3, missing),
                "plateSteel",
                getModItem(Minecraft.ID, "chest", 1, 0, missing),
                "plateSteel",
                "plateRedAlloy",
                getModItem(Railcraft.ID, "detector", 1, 1, missing),
                "plateRedAlloy",
                "plateSteel",
                getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 2, 4, missing),
                "paneGlass",
                GTOreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Steel, 1L),
                "paneGlass",
                ItemList.Electric_Pump_LV.get(1L),
                getModItem(Railcraft.ID, "detector", 1, 8, missing),
                ItemList.Electric_Motor_LV.get(1L),
                "paneGlass",
                getModItem(Railcraft.ID, "machine.beta", 1, 0, missing),
                "paneGlass");
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 2, 5, missing),
                "paneGlass",
                getModItem(Railcraft.ID, "machine.beta", 1, 0, missing),
                "paneGlass",
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(Railcraft.ID, "detector", 1, 8, missing),
                ItemList.Electric_Pump_LV.get(1L),
                "paneGlass",
                GTOreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Steel, 1L),
                "paneGlass");
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 2, 6, missing),
                "plateSteel",
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1L),
                "plateSteel",
                "plateRedAlloy",
                getModItem(Railcraft.ID, "detector", 1, 10, missing),
                "plateRedAlloy",
                "plateSteel",
                getModItem(IndustrialCraft2.ID, "itemAdvBat", 1, wildcard, missing),
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 2, 7, missing),
                "plateSteel",
                getModItem(IndustrialCraft2.ID, "itemAdvBat", 1, wildcard, missing),
                "plateSteel",
                "plateRedAlloy",
                getModItem(Railcraft.ID, "detector", 1, 10, missing),
                "plateRedAlloy",
                "plateSteel",
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1L),
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 1, 8, missing),
                getModItem(Minecraft.ID, "dispenser", 1, 0, missing),
                getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                getModItem(Minecraft.ID, "rail", 1, 0, missing),
                null,
                getModItem(Railcraft.ID, "tool.crowbar", 1, 0, missing),
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 1, 9, missing),
                getModItem(Railcraft.ID, "tool.crowbar", 1, 0, missing),
                "plateRedAlloy",
                getModItem(Railcraft.ID, "tool.crowbar", 1, 0, missing),
                "plateRedAlloy",
                getModItem(Railcraft.ID, "machine.gamma", 1, 8, missing),
                "plateRedAlloy",
                getModItem(Railcraft.ID, "tool.crowbar", 1, 0, missing),
                "plateRedAlloy",
                getModItem(Railcraft.ID, "tool.crowbar", 1, 0, missing));
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.epsilon", 1, 0, missing),
                "plateSteel",
                GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Copper, 1L),
                "plateSteel",
                "plateRedAlloy",
                getModItem(Railcraft.ID, "detector", 1, 10, missing),
                "plateRedAlloy",
                "plateSteel",
                GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Copper, 1L),
                "plateSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.epsilon", 1, 4, missing),
                "plateBronze",
                GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Gold, 1L),
                "plateBronze",
                "plateRedAlloy",
                getModItem(Railcraft.ID, "detector", 1, 10, missing),
                "plateRedAlloy",
                "plateBronze",
                getModItem(Railcraft.ID, "machine.delta", 1, 0, missing),
                "plateBronze");
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.epsilon", 1, 3, missing),
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
                getModItem(Railcraft.ID, "cart.work", 1, 0, missing),
                "craftingToolHardHammer",
                getModItem(Minecraft.ID, "crafting_table", 1, 0, missing),
                "craftingToolWrench",
                null,
                getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                null,
                null,
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "cart.tank", 1, 0, missing),
                "craftingToolHardHammer",
                getModItem(Railcraft.ID, "machine.beta", 1, 1, missing),
                "craftingToolWrench",
                null,
                getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                null,
                null,
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "tool.steel.shears", 1, 0, missing),
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
                getModItem(Railcraft.ID, "stair", 4, 6, missing),
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
                getModItem(Railcraft.ID, "stair", 4, 43, missing),
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
                getModItem(Railcraft.ID, "stair", 4, 40, missing),
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
                getModItem(Railcraft.ID, "stair", 4, 41, missing),
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
                getModItem(Railcraft.ID, "stair", 4, 42, missing),
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
                getModItem(Railcraft.ID, "stair", 4, 7, missing),
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
                getModItem(Railcraft.ID, "stair", 4, 8, missing),
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
                getModItem(Railcraft.ID, "lantern.stone", 1, 0, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(Railcraft.ID, "slab", 1, 28, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                "craftingToolFile",
                getModItem(Minecraft.ID, "torch", 1, 0, missing),
                "craftingToolHardHammer",
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(Railcraft.ID, "slab", 1, 28, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing));
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 1, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(Railcraft.ID, "slab", 1, 26, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                "craftingToolFile",
                getModItem(Minecraft.ID, "torch", 1, 0, missing),
                "craftingToolHardHammer",
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(Railcraft.ID, "slab", 1, 26, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing));
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 2, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(Railcraft.ID, "slab", 1, 27, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                "craftingToolFile",
                getModItem(Minecraft.ID, "torch", 1, 0, missing),
                "craftingToolHardHammer",
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(Railcraft.ID, "slab", 1, 27, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing));
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 3, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(Railcraft.ID, "slab", 1, 24, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                "craftingToolFile",
                getModItem(Minecraft.ID, "torch", 1, 0, missing),
                "craftingToolHardHammer",
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(Railcraft.ID, "slab", 1, 24, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing));
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 4, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(Railcraft.ID, "slab", 1, 23, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                "craftingToolFile",
                getModItem(Minecraft.ID, "torch", 1, 0, missing),
                "craftingToolHardHammer",
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(Railcraft.ID, "slab", 1, 23, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing));
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 5, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(Railcraft.ID, "slab", 1, 29, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                "craftingToolFile",
                getModItem(Minecraft.ID, "torch", 1, 0, missing),
                "craftingToolHardHammer",
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(Railcraft.ID, "slab", 1, 29, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing));
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 6, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(Railcraft.ID, "slab", 1, 25, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                "craftingToolFile",
                getModItem(Minecraft.ID, "torch", 1, 0, missing),
                "craftingToolHardHammer",
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(Railcraft.ID, "slab", 1, 25, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing));
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 7, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(Railcraft.ID, "slab", 1, 22, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                "craftingToolFile",
                getModItem(Minecraft.ID, "torch", 1, 0, missing),
                "craftingToolHardHammer",
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(Railcraft.ID, "slab", 1, 22, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing));
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 8, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(Minecraft.ID, "stone_slab", 1, 1, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                "craftingToolFile",
                getModItem(Minecraft.ID, "torch", 1, 0, missing),
                "craftingToolHardHammer",
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(Minecraft.ID, "stone_slab", 1, 1, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing));
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 9, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(Minecraft.ID, "stone_slab", 1, 0, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                "craftingToolFile",
                getModItem(Minecraft.ID, "torch", 1, 0, missing),
                "craftingToolHardHammer",
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(Minecraft.ID, "stone_slab", 1, 0, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing));
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.metal", 1, 0, missing),
                "screwAnyIron",
                "plateAnyIron",
                "screwAnyIron",
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "torch", 1, 0, missing),
                "craftingToolHardHammer",
                "screwAnyIron",
                "plateAnyIron",
                "screwAnyIron");
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.metal", 1, 1, missing),
                "screwGold",
                "plateGold",
                "screwGold",
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "torch", 1, 0, missing),
                "craftingToolHardHammer",
                "screwGold",
                "plateGold",
                "screwGold");
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.metal", 1, 2, missing),
                "screwCopper",
                "plateCopper",
                "screwCopper",
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "torch", 1, 0, missing),
                "craftingToolHardHammer",
                "screwCopper",
                "plateCopper",
                "screwCopper");
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.metal", 1, 3, missing),
                "screwTin",
                "plateTin",
                "screwTin",
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "torch", 1, 0, missing),
                "craftingToolHardHammer",
                "screwTin",
                "plateTin",
                "screwTin");
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.metal", 1, 4, missing),
                "screwLead",
                "plateLead",
                "screwLead",
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "torch", 1, 0, missing),
                "craftingToolHardHammer",
                "screwLead",
                "plateLead",
                "screwLead");
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.metal", 1, 5, missing),
                "screwSteel",
                "plateSteel",
                "screwSteel",
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "torch", 1, 0, missing),
                "craftingToolHardHammer",
                "screwSteel",
                "plateSteel",
                "screwSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.signal.lamp", 8, 0, missing),
                "paneGlass",
                createItemStack(
                        ForgeMicroblocks.ID,
                        "microblock",
                        1,
                        516,
                        "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_29\"}",
                        missing),
                "plateAnyIron",
                "paneGlass",
                createItemStack(
                        ForgeMicroblocks.ID,
                        "microblock",
                        1,
                        516,
                        "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_20\"}",
                        missing),
                "plateAnyIron",
                "paneGlass",
                createItemStack(
                        ForgeMicroblocks.ID,
                        "microblock",
                        1,
                        516,
                        "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_30\"}",
                        missing),
                "plateAnyIron");
        addShapelessRecipe(
                getModItem(Railcraft.ID, "part.turbine.disk", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemSteamTurbineBlade", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Railcraft.ID, "part.turbine.rotor", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemSteamTurbine", 1, 0, missing));
        addShapedRecipe(
                getModItem(Railcraft.ID, "armor.goggles", 1, 0, missing),
                "lensGlass",
                "boltSteel",
                "lensGlass",
                "ringSteel",
                "screwSteel",
                "ringSteel",
                "itemLeather",
                getModItem(Railcraft.ID, "part.circuit", 1, 1, missing),
                "itemLeather");
        addShapedRecipe(
                getModItem(Railcraft.ID, "tool.magnifying.glass", 1, 0, missing),
                null,
                null,
                "lensGlass",
                null,
                "ringSteel",
                null,
                "stickSteel",
                null,
                null);
        addShapelessRecipe(
                getModItem(Railcraft.ID, "machine.alpha", 1, 7, missing),
                CustomItemList.CokeOvenBrick.get(1L),
                CustomItemList.CokeOvenBrick.get(1L),
                CustomItemList.CokeOvenBrick.get(1L),
                CustomItemList.CokeOvenBrick.get(1L));
        addShapedRecipe(
                getModItem(Railcraft.ID, "brick.sandy", 2, 2, missing),
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
                getModItem(Railcraft.ID, "brick.sandy", 1, 2, missing),
                getModItem(Railcraft.ID, "slab", 1, 21, missing),
                null,
                null,
                getModItem(Railcraft.ID, "slab", 1, 21, missing),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "slab", 2, 38, missing),
                "craftingToolSaw",
                getModItem(Railcraft.ID, "cube", 1, 8, missing));
        addShapedRecipe(
                getModItem(Railcraft.ID, "backpack.trackman.t1", 1, 0, missing),
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                getModItem(Minecraft.ID, "rail", 1, 0, missing),
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                "itemLeather",
                getModItem(Minecraft.ID, "rail", 1, 0, missing),
                "itemLeather",
                "itemLeather",
                getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                "itemLeather");
        addShapelessRecipe(
                getModItem(Railcraft.ID, "backpack.trackman.t1", 1, 0, missing),
                getModItem(Railcraft.ID, "backpack.trackman.t1", 1, 0, missing));
        addShapedRecipe(
                getModItem(Railcraft.ID, "backpack.iceman.t1", 1, 0, missing),
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "hardIce", 1, 0, missing),
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                "itemLeather",
                getModItem(BiomesOPlenty.ID, "hardIce", 1, 0, missing),
                "itemLeather",
                "itemLeather",
                getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                "itemLeather");
        addShapelessRecipe(
                getModItem(Railcraft.ID, "backpack.iceman.t1", 1, 0, missing),
                getModItem(Railcraft.ID, "backpack.iceman.t1", 1, 0, missing));
        addShapedRecipe(
                getModItem(Railcraft.ID, "backpack.apothecary.t1", 1, 0, missing),
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                getModItem(Minecraft.ID, "potion", 1, 8229, missing),
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                "itemLeather",
                getModItem(Minecraft.ID, "potion", 1, 8229, missing),
                "itemLeather",
                "itemLeather",
                getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                "itemLeather");
        addShapelessRecipe(
                getModItem(Railcraft.ID, "backpack.apothecary.t1", 1, 0, missing),
                getModItem(Railcraft.ID, "backpack.apothecary.t1", 1, 0, missing));
        addShapedRecipe(
                getModItem(Railcraft.ID, "brick.infernal", 2, 2, missing),
                "ingotBrickNether",
                getModItem(Minecraft.ID, "soul_sand", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "soul_sand", 1, 0, missing),
                "ingotBrickNether",
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "upgrade.lapotron", 1, 0, missing),
                "itemCasingAluminium",
                "circuitAdvanced",
                "itemCasingAluminium",
                "cableGt02Platinum",
                getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard, missing),
                "cableGt02Platinum",
                "itemCasingAluminium",
                "circuitAdvanced",
                "itemCasingAluminium");
        addShapedRecipe(
                getModItem(Railcraft.ID, "cart.cargo", 1, 0, missing),
                "craftingToolHardHammer",
                getModItem(Minecraft.ID, "chest", 1, 0, missing),
                "craftingToolWrench",
                "plateSteel",
                getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                "plateSteel",
                null,
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(Railcraft.ID, "cart.track.relayer", 1, 0, missing),
                ItemList.Robot_Arm_LV.get(1L),
                getModItem(IC2NuclearControl.ID, "blockNuclearControlLight", 1, 0, missing),
                ItemList.Robot_Arm_LV.get(1L),
                ItemList.Conveyor_Module_LV.get(1L),
                "circuitBasic",
                ItemList.Conveyor_Module_LV.get(1L),
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                getModItem(StevesCarts2.ID, "CartModule", 1, 8, missing));
        addShapedRecipe(
                getModItem(Railcraft.ID, "cart.undercutter", 1, 0, missing),
                ItemList.Robot_Arm_LV.get(1L),
                getModItem(IC2NuclearControl.ID, "blockNuclearControlLight", 1, 0, missing),
                ItemList.Robot_Arm_LV.get(1L),
                ItemList.Electric_Piston_LV.get(1L),
                "circuitBasic",
                ItemList.Electric_Piston_LV.get(1L),
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                ItemList.Conveyor_Module_LV.get(1L));
        addShapedRecipe(
                getModItem(Railcraft.ID, "cart.track.layer", 1, 0, missing),
                ItemList.Robot_Arm_LV.get(1L),
                getModItem(IC2NuclearControl.ID, "blockNuclearControlLight", 1, 0, missing),
                ItemList.Robot_Arm_LV.get(1L),
                getModItem(Minecraft.ID, "anvil", 1, 0, missing),
                "circuitBasic",
                getModItem(Minecraft.ID, "anvil", 1, 0, missing),
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                getModItem(Minecraft.ID, "dispenser", 1, 0, missing));
        addShapedRecipe(
                getModItem(Railcraft.ID, "cart.track.remover", 1, 0, missing),
                ItemList.Robot_Arm_LV.get(1L),
                getModItem(IC2NuclearControl.ID, "blockNuclearControlLight", 1, 0, missing),
                ItemList.Robot_Arm_LV.get(1L),
                getModItem(Railcraft.ID, "tool.crowbar.reinforced", 1, 0, missing),
                "circuitBasic",
                getModItem(Railcraft.ID, "tool.crowbar.reinforced", 1, 0, missing),
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                ItemList.Electric_Motor_LV.get(1L));
        addShapedRecipe(
                getModItem(Railcraft.ID, "cart.redstone.flux", 1, 0, missing),
                "plateLead",
                "craftingToolScrewdriver",
                "plateLead",
                createItemStack(EnderIO.ID, "blockCapBank", 1, 1, "{type:\"SIMPLE\",storedEnergyRF:0}", missing),
                "circuitBasic",
                createItemStack(EnderIO.ID, "blockCapBank", 1, 1, "{type:\"SIMPLE\",storedEnergyRF:0}", missing),
                "screwSteel",
                getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                "screwSteel");
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 1, 10, missing),
                "plateLead",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing),
                "plateLead",
                "plateRedstoneAlloy",
                getModItem(Railcraft.ID, "detector", 1, 10, missing),
                "plateRedstoneAlloy",
                "plateLead",
                createItemStack(EnderIO.ID, "blockCapBank", 1, 1, "{type:\"SIMPLE\",storedEnergyRF:0}", missing),
                "plateLead");
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 1, 11, missing),
                "plateLead",
                createItemStack(EnderIO.ID, "blockCapBank", 1, 1, "{type:\"SIMPLE\",storedEnergyRF:0}", missing),
                "plateLead",
                "plateRedstoneAlloy",
                getModItem(Railcraft.ID, "detector", 1, 10, missing),
                "plateRedstoneAlloy",
                "plateLead",
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing),
                "plateLead");
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.epsilon", 1, 5, missing),
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
                getModItem(Railcraft.ID, "brick.nether", 4, 5, missing),
                "stoneCobble",
                getModItem(Minecraft.ID, "netherrack", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "netherrack", 1, 0, missing),
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
                        "{display:{Lore:[0:\"§7§oDesigned by Railcraft, Inc.\"]}}",
                        missing));
        ForestryHelper.removeCarpenterRecipe(
                createItemStack(
                        Railcraft.ID,
                        "backpack.iceman.t2",
                        1,
                        0,
                        "{display:{Lore:[0:\"§7§oDesigned by Railcraft, Inc.\"]}}",
                        missing));
        ForestryHelper.removeCarpenterRecipe(
                createItemStack(
                        Railcraft.ID,
                        "backpack.apothecary.t2",
                        1,
                        0,
                        "{display:{Lore:[0:\"§7§oDesigned by Railcraft, Inc.\"]}}",
                        missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("seedoil", 5000),
                getModItem(Railcraft.ID, "backpack.trackman.t1", 1, 0, missing),
                getModItem(Railcraft.ID, "backpack.trackman.t2", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'b',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'c',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'd',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'e',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'f',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'g',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'h',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'i',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("seedoil", 5000),
                getModItem(Railcraft.ID, "backpack.iceman.t1", 1, 0, missing),
                getModItem(Railcraft.ID, "backpack.iceman.t2", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'b',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'c',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'd',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'e',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'f',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'g',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'h',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'i',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("seedoil", 5000),
                getModItem(Railcraft.ID, "backpack.apothecary.t1", 1, 0, missing),
                getModItem(Railcraft.ID, "backpack.apothecary.t2", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'b',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'c',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'd',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'e',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'f',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'g',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'h',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'i',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing));

        GTValues.RA.stdBuilder().itemInputs(Materials.Creosote.getCells(1)).metadata(FUEL_VALUE, 8)
                .metadata(FUEL_TYPE, 0).duration(0).eut(0).addTo(GTRecipeConstants.Fuel);

        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.plate", 4, 0, missing));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.plate", 4, 1, missing));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.plate", 4, 2, missing));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.plate", 4, 3, missing));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.rail", 8, 0, missing));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.rail", 6, 0, missing));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.rail", 16, 0, missing));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.rail", 8, 1, missing));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.rail", 8, 3, missing));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.rail", 8, 4, missing));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.rail", 6, 5, missing));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "machine.delta", 8, 0, missing));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.rebar", 4, 0, missing));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.rebar", 6, 0, missing));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.rebar", 8, 0, missing));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "post", 16, 2, missing));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "post", 32, 2, missing));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "post", 12, 2, missing));
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "post", 20, 2, missing));
        RailcraftCraftingManager.rollingMachine.getRecipeList().add(
                new ShapedOreRecipe(
                        getModItem(Railcraft.ID, "post", 4, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(Railcraft.ID, "part.tie", 1, 0, missing),
                        'c',
                        getModItem(Railcraft.ID, "part.tie", 1, 0, missing),
                        'd',
                        getModItem(Railcraft.ID, "part.tie", 1, 0, missing),
                        'e',
                        getModItem(Railcraft.ID, "part.tie", 1, 0, missing),
                        'f',
                        getModItem(Railcraft.ID, "part.tie", 1, 0, missing),
                        'g',
                        getModItem(Railcraft.ID, "part.tie", 1, 0, missing),
                        'i',
                        getModItem(Railcraft.ID, "part.tie", 1, 0, missing)));
        RailcraftCraftingManager.rollingMachine.getRecipeList().add(
                new ShapedOreRecipe(
                        getModItem(Railcraft.ID, "post", 4, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(Railcraft.ID, "part.tie", 1, 0, missing),
                        'b',
                        getModItem(Railcraft.ID, "part.tie", 1, 0, missing),
                        'c',
                        getModItem(Railcraft.ID, "part.tie", 1, 0, missing),
                        'e',
                        getModItem(Railcraft.ID, "part.tie", 1, 0, missing),
                        'g',
                        getModItem(Railcraft.ID, "part.tie", 1, 0, missing),
                        'h',
                        getModItem(Railcraft.ID, "part.tie", 1, 0, missing),
                        'i',
                        getModItem(Railcraft.ID, "part.tie", 1, 0, missing)));
        RailcraftCraftingManager.rollingMachine.getRecipeList().add(
                new ShapedOreRecipe(
                        getModItem(Railcraft.ID, "post", 4, 1, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(Minecraft.ID, "stone", 1, 0, missing),
                        'c',
                        getModItem(Minecraft.ID, "stone", 1, 0, missing),
                        'd',
                        getModItem(Railcraft.ID, "part.rebar", 1, 0, missing),
                        'e',
                        getModItem(Railcraft.ID, "part.rebar", 1, 0, missing),
                        'f',
                        getModItem(Railcraft.ID, "part.rebar", 1, 0, missing),
                        'g',
                        getModItem(Minecraft.ID, "stone", 1, 0, missing),
                        'i',
                        getModItem(Minecraft.ID, "stone", 1, 0, missing)));
        RailcraftCraftingManager.rollingMachine.getRecipeList().add(
                new ShapedOreRecipe(
                        getModItem(Railcraft.ID, "post", 4, 1, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(Minecraft.ID, "stone", 1, 0, missing),
                        'b',
                        getModItem(Railcraft.ID, "part.rebar", 1, 0, missing),
                        'c',
                        getModItem(Minecraft.ID, "stone", 1, 0, missing),
                        'e',
                        getModItem(Railcraft.ID, "part.rebar", 1, 0, missing),
                        'g',
                        getModItem(Minecraft.ID, "stone", 1, 0, missing),
                        'h',
                        getModItem(Railcraft.ID, "part.rebar", 1, 0, missing),
                        'i',
                        getModItem(Minecraft.ID, "stone", 1, 0, missing)));
        RailcraftCraftingManager.rollingMachine.getRecipeList().add(
                new ShapedOreRecipe(
                        getModItem(Railcraft.ID, "post", 1, 4, missing),
                        "abc",
                        "def",
                        "ghi",
                        'b',
                        getModItem(Railcraft.ID, "slab", 1, 38, missing),
                        'e',
                        getModItem(Railcraft.ID, "post", 1, 0, missing)));
        RailcraftCraftingManager.rollingMachine.getRecipeList().add(
                new ShapedOreRecipe(
                        getModItem(Railcraft.ID, "post", 1, 5, missing),
                        "abc",
                        "def",
                        "ghi",
                        'b',
                        getModItem(Railcraft.ID, "slab", 1, 2, missing),
                        'e',
                        getModItem(Railcraft.ID, "post", 1, 1, missing)));
        RailcraftCraftingManager.rollingMachine.getRecipeList().add(
                new ShapedOreRecipe(
                        getModItem(Railcraft.ID, "post", 1, 6, missing),
                        "abc",
                        "def",
                        "ghi",
                        'b',
                        getModItem(Railcraft.ID, "slab", 1, 6, missing),
                        'e',
                        getModItem(Railcraft.ID, "post", 1, 2, missing)));
        RailcraftCraftingManager.rollingMachine.getRecipeList().add(
                new ShapedOreRecipe(
                        getModItem(Railcraft.ID, "post", 16, 2, missing),
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
                        getModItem(Railcraft.ID, "post", 16, 2, missing),
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
                        getModItem(Railcraft.ID, "post", 12, 2, missing),
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
                        getModItem(Railcraft.ID, "post", 12, 2, missing),
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
                        getModItem(Railcraft.ID, "post", 32, 2, missing),
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
                        getModItem(Railcraft.ID, "post", 32, 2, missing),
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
        RailcraftHelper.removeRollingRecipe(getModItem(Railcraft.ID, "part.plate", 4, 4, missing));
        RecipeManagers.fabricatorManager.addRecipe(
                getModItem(Forestry.ID, "waxCast", 1, wildcard, missing),
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem(Railcraft.ID, "glass", 4, 0, missing),
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
                getModItem(Forestry.ID, "waxCast", 1, wildcard, missing),
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem(Railcraft.ID, "glass", 4, 0, missing),
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
                getModItem(Forestry.ID, "waxCast", 1, wildcard, missing),
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem(Railcraft.ID, "glass", 4, 0, missing),
                new Object[] { "abc", "def", "ghi", 'a',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L), 'b',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Saltpeter, 1L), 'c',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L), 'd',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1L), 'e',
                        CustomItemList.ChargedCertusQuartzDust.get(1L), 'f',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L), 'g',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L), 'h',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Saltpeter, 1L), 'i',
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L) });
        RecipeManagers.fabricatorManager.addRecipe(
                getModItem(Forestry.ID, "waxCast", 1, wildcard, missing),
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem(Railcraft.ID, "glass", 4, 0, missing),
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

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "torch", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 2, 28, missing))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 0, missing)).duration(10 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "torch", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 2, 26, missing))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 1, missing)).duration(10 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "torch", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 2, 27, missing))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 2, missing)).duration(10 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "torch", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 2, 24, missing))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 3, missing)).duration(10 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "torch", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 2, 23, missing))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 4, missing)).duration(10 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "torch", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 2, 29, missing))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 5, missing)).duration(10 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "torch", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 2, 25, missing))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 6, missing)).duration(10 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "torch", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 2, 22, missing))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 7, missing)).duration(10 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "torch", 1, 0, missing),
                        getModItem(Minecraft.ID, "stone_slab", 2, 1, missing))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 8, missing)).duration(10 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "torch", 1, 0, missing),
                        getModItem(Minecraft.ID, "stone_slab", 2, 0, missing))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 9, missing)).duration(10 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        Module_CustomFuels.registerCustomFuelValue(
                getModItem(Railcraft.ID, "fluid.creosote.bucket", 1, 0, missing),
                (short) 6400);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stone", 5, 0, missing),
                        getModItem(Railcraft.ID, "part.rebar", 4, 0, missing))
                .itemOutputs(getModItem(Railcraft.ID, "cube", 5, 1, missing)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 5L),
                        CustomItemList.MoldHelmet.get(0L))
                .itemOutputs(getModItem(Railcraft.ID, "armor.steel.helmet", 1, 0, missing)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 8L),
                        CustomItemList.MoldChestplate.get(0L))
                .itemOutputs(getModItem(Railcraft.ID, "armor.steel.plate", 1, 0, missing)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 7L),
                        CustomItemList.MoldLeggings.get(0L))
                .itemOutputs(getModItem(Railcraft.ID, "armor.steel.legs", 1, 0, missing)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 4L),
                        CustomItemList.MoldBoots.get(0L))
                .itemOutputs(getModItem(Railcraft.ID, "armor.steel.boots", 1, 0, missing)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Railcraft.ID, "firestone.cut", 1, 0, missing),
                        getModItem(Minecraft.ID, "redstone_block", 2, 0, missing),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Railcraft.ID, "firestone.refined", 1, 5000, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lava", 576)).duration(10 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Railcraft.ID, "firestone.cracked", 1, wildcard, missing),
                        getModItem(Minecraft.ID, "redstone_block", 2, 0, missing),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Railcraft.ID, "firestone.refined", 1, 5000, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lava", 576)).duration(10 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                        getModItem(Minecraft.ID, "crafting_table", 1, 0, missing),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Railcraft.ID, "cart.work", 1, 0, missing)).duration(5 * SECONDS).eut(16)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                        getModItem(Railcraft.ID, "machine.alpha", 1, 2, missing),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Railcraft.ID, "cart.anchor.personal", 1, 0, missing)).duration(5 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                        getModItem(Railcraft.ID, "machine.alpha", 1, 0, missing),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Railcraft.ID, "cart.anchor", 1, 0, missing)).duration(5 * SECONDS).eut(16)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                        getModItem(Railcraft.ID, "machine.beta", 1, 1, missing),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Railcraft.ID, "cart.tank", 1, 0, missing)).duration(5 * SECONDS).eut(16)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 0, missing),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Railcraft.ID, "cart.energy.batbox", 1, 0, missing)).duration(5 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 7, missing),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Railcraft.ID, "cart.energy.cesu", 1, 0, missing)).duration(5 * SECONDS).eut(16)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 1, missing),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Railcraft.ID, "cart.energy.mfe", 1, 0, missing)).duration(5 * SECONDS).eut(16)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemToolMEter", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.circuit", 1, 1, missing),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Railcraft.ID, "tool.electric.meter", 1, 0, missing)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemFreq", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.circuit", 1, 1, missing),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Railcraft.ID, "tool.signal.tuner", 1, 0, missing)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Railcraft.ID, "tool.signal.tuner", 1, 0, missing),
                        getModItem(Minecraft.ID, "compass", 1, 0, missing),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Railcraft.ID, "tool.surveyor", 1, 0, missing)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "cube", 1, 8, missing))
                .itemOutputs(getModItem(Railcraft.ID, "slab", 4, 38, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "cube", 1, 8, missing))
                .itemOutputs(getModItem(Railcraft.ID, "slab", 4, 38, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "cube", 1, 8, missing))
                .itemOutputs(getModItem(Railcraft.ID, "slab", 4, 38, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "cube", 1, 0, missing))
                .itemOutputs(getModItem(Railcraft.ID, "fuel.coke", 9, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(hammerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "clay_ball", 1, 0, missing),
                        getModItem(Minecraft.ID, "dye", 1, 15, missing),
                        getModItem(Minecraft.ID, "dye", 1, 15, missing),
                        getModItem(Minecraft.ID, "dye", 1, 15, missing))
                .itemOutputs(getModItem(Railcraft.ID, "part.bleached.clay", 2, 0, missing)).duration(5 * SECONDS).eut(8)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0L, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1L)),
                        getModItem(Railcraft.ID, "firestone.raw", 1, 0, missing))
                .itemOutputs(getModItem(Railcraft.ID, "firestone.cut", 1, 0, missing)).duration(2 * MINUTES)
                .eut(TierEU.RECIPE_HV).addTo(laserEngraverRecipes);

        TCHelper.removeArcaneRecipe(getModItem(Railcraft.ID, "tool.crowbar.magic", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(Railcraft.ID, "tool.crowbar.void", 1, 0, missing));
        TCHelper.moveResearch("RC_Crowbar", "ARTIFICE", 0, -4);
        TCHelper.clearPrereq("RC_Crowbar");
        TCHelper.addResearchPrereq("RC_Crowbar", "THAUMIUM", false);
        TCHelper.clearPages("RC_Crowbar");
        TCHelper.addResearchPage("RC_Crowbar", new ResearchPage("thaumcraft.research.RC_Crowbar.page.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RC_Crowbar",
                getModItem(Railcraft.ID, "tool.crowbar.magic", 1, 0, missing),
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
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(Railcraft.ID, "tool.crowbar.magic", 1, 0, missing))));
        TCHelper.refreshResearchPages("RC_Crowbar");
        TCHelper.moveResearch("RC_Crowbar_Void", "ELDRITCH", 2, -4);
        TCHelper.clearPrereq("RC_Crowbar_Void");
        TCHelper.addResearchPrereq("RC_Crowbar_Void", "VOIDMETAL", false);
        TCHelper.addResearchPrereq("RC_Crowbar_Void", "RC_Crowbar", false);
        TCHelper.clearPages("RC_Crowbar_Void");
        TCHelper.addResearchPage("RC_Crowbar_Void", new ResearchPage("thaumcraft.research.RC_Crowbar_Void.page.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RC_Crowbar_Void",
                getModItem(Railcraft.ID, "tool.crowbar.void", 1, 0, missing),
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
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(Railcraft.ID, "tool.crowbar.void", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("RC_Crowbar_Void", 2);
        TCHelper.refreshResearchPages("RC_Crowbar_Void");
        ResearchCategories.researchCategories.remove("RAILCRAFT");
    }
}
