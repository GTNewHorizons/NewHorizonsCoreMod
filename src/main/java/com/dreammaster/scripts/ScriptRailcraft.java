package com.dreammaster.scripts;

import static com.dreammaster.main.MainRegistry.Module_CustomFuels;
import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.ForgeMicroblocks;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IC2NuclearControl;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.ProjectRedIntegration;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.StevesCarts2;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAlloySmelterRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCentrifugeRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCompressorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCutterRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sFluidSolidficationRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sHammerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sLaserEngraverRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMixerRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.dreammaster.forestry.ForestryHelper;
import com.dreammaster.railcraft.RailcraftHelper;
import com.dreammaster.thaumcraft.TCHelper;

import forestry.api.recipes.RecipeManagers;
import gregtech.api.enums.GT_Values;
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
                new Object[] { null, "craftingToolHardHammer", null, "stickAnyIron", "craftingToolFile", "stickAnyIron",
                        null, null, null });
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.tie", 1, 1, missing),
                new Object[] { null, getModItem(Railcraft.ID, "part.rebar", 1, 0, missing), null,
                        getModItem(Minecraft.ID, "stone_slab", 1, 0, missing),
                        getModItem(Minecraft.ID, "stone_slab", 1, 0, missing),
                        getModItem(Minecraft.ID, "stone_slab", 1, 0, missing), null, null, null });
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                new Object[] { getModItem(Railcraft.ID, "part.tie", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.tie", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.tie", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.tie", 1, 0, missing), null, "craftingToolSoftHammer", null });
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.railbed", 1, 1, missing),
                new Object[] { getModItem(Railcraft.ID, "part.tie", 1, 1, missing),
                        getModItem(Railcraft.ID, "part.tie", 1, 1, missing),
                        getModItem(Railcraft.ID, "part.tie", 1, 1, missing),
                        getModItem(Railcraft.ID, "part.tie", 1, 1, missing), null, "craftingToolHardHammer", null });
        addShapedRecipe(
                getModItem(Railcraft.ID, "frame", 1, 0, missing),
                new Object[] { "plateAnyRubber", "plateSteel", "plateAnyRubber",
                        getModItem(Railcraft.ID, "part.rebar", 1, 0, missing), "craftingToolWrench",
                        getModItem(Railcraft.ID, "part.rebar", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.rebar", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.rebar", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.rebar", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Railcraft.ID, "slab", 2, 2, missing),
                new Object[] { "craftingToolSaw", getModItem(Railcraft.ID, "cube", 1, 1, missing) });
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.control\"}", missing),
                new Object[] { "screwSteel", "stickRedAlloy", "screwSteel",
                        getModItem(Railcraft.ID, "part.rail", 1, 1, missing),
                        getModItem(Minecraft.ID, "rail", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 1, missing), "craftingToolScrewdriver",
                        "stickRedAlloy", "craftingToolHardHammer" });
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 20176, "{track:\"railcraft:track.locking\"}", missing),
                new Object[] { "screwSteel", getModItem(Railcraft.ID, "detector", 1, 1, missing), "screwSteel",
                        getModItem(Railcraft.ID, "part.rail", 1, 1, missing),
                        getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 1, missing), "craftingToolScrewdriver",
                        "stickRedAlloy", "craftingToolHardHammer" });
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 23575, "{track:\"railcraft:track.disembarking\"}", missing),
                new Object[] { "screwSteel", getModItem(Railcraft.ID, "part.railbed", 1, 0, missing), "screwSteel",
                        getModItem(Railcraft.ID, "part.rail", 1, 1, missing),
                        getModItem(Railcraft.ID, "detector", 1, 9, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 1, missing), "craftingToolScrewdriver",
                        "stickRedAlloy", "craftingToolHardHammer" });
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.embarking\"}", missing),
                new Object[] { "screwSteel", "gemEnderEye", "screwSteel",
                        getModItem(Railcraft.ID, "part.rail", 1, 1, missing),
                        getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 1, missing), "craftingToolScrewdriver", "gemEnderEye",
                        "craftingToolHardHammer" });
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.coupler\"}", missing),
                new Object[] { "screwSteel", getModItem(Railcraft.ID, "tool.crowbar.reinforced", 1, 0, missing),
                        "screwSteel", getModItem(Railcraft.ID, "part.rail", 1, 1, missing),
                        getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 1, missing), "craftingToolScrewdriver",
                        getModItem(Railcraft.ID, "tool.crowbar.reinforced", 1, 0, missing), "craftingToolHardHammer" });
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.whistle\"}", missing),
                new Object[] { "screwAnyIron", getModItem(Railcraft.ID, "tool.whistle.tuner", 1, 0, missing),
                        "screwAnyIron", getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(GregTech.ID, "gt.blockcasings3", 1, 0, missing), "craftingToolHardHammer" });
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 30516, "{track:\"railcraft:track.locomotive\"}", missing),
                new Object[] { "screwAnyIron", getModItem(Railcraft.ID, "signal", 1, 11, missing), "screwAnyIron",
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Railcraft.ID, "signal", 1, 3, missing), "craftingToolHardHammer" });
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 16093, "{track:\"railcraft:track.limiter\"}", missing),
                new Object[] { "screwAnyIron", "plateRedAlloy", "screwAnyIron",
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Railcraft.ID, "detector", 1, 1, missing), "craftingToolHardHammer" });
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.routing\"}", missing),
                new Object[] { "screwAnyIron", "plateRedAlloy", "screwAnyIron",
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Railcraft.ID, "routing.ticket", 1, 0, missing), "craftingToolHardHammer" });
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.routing\"}", missing),
                new Object[] { "screwAnyIron", "plateRedAlloy", "screwAnyIron",
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Railcraft.ID, "routing.ticket.gold", 1, 0, missing), "craftingToolHardHammer" });
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 2, 32363, "{track:\"railcraft:track.buffer.stop\"}", missing),
                new Object[] { "screwAnyIron", "plateSteel", "screwAnyIron",
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing), "craftingToolScrewdriver", "blockSteel",
                        "craftingToolHardHammer" });
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 30946, "{track:\"railcraft:track.oneway\"}", missing),
                new Object[] { "screwAnyIron", getModItem(Railcraft.ID, "detector", 1, 1, missing), "screwAnyIron",
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Minecraft.ID, "piston", 1, 0, missing), "craftingToolHardHammer" });
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.detector.direction\"}", missing),
                new Object[] { "screwAnyIron", "plateRedAlloy", "screwAnyIron",
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Railcraft.ID, "detector", 1, 9, missing), "craftingToolHardHammer" });
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.gated.oneway\"}", missing),
                new Object[] { "screwSteel", "plateRedAlloy", "screwSteel",
                        getModItem(Railcraft.ID, "part.rail", 1, 1, missing),
                        createItemStack(Railcraft.ID, "track", 1, 19746, "{track:\"railcraft:track.gated\"}", missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 1, missing), "craftingToolScrewdriver",
                        "plateRedAlloy", "craftingToolHardHammer" });
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 19746, "{track:\"railcraft:track.gated\"}", missing),
                new Object[] { "screwAnyIron", getModItem(Minecraft.ID, "fence_gate", 1, 0, missing), "screwAnyIron",
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Minecraft.ID, "fence_gate", 1, 0, missing), "craftingToolHardHammer" });
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.suspended\"}", missing),
                new Object[] { "screwAnyIron", getModItem(Railcraft.ID, "post", 1, 2, missing), "screwAnyIron",
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Railcraft.ID, "post", 1, 2, missing), "craftingToolHardHammer" });
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 2264, "{track:\"railcraft:track.disposal\"}", missing),
                new Object[] { "screwAnyIron", getModItem(Railcraft.ID, "part.tie", 1, 0, missing), "screwAnyIron",
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing), "plateSteel",
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Railcraft.ID, "part.tie", 1, 0, missing), "craftingToolHardHammer" });
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 16, 736, "{track:\"railcraft:track.slow\"}", missing),
                new Object[] { "screwAnyIron", null, "screwAnyIron",
                        getModItem(Railcraft.ID, "part.rail", 1, 2, missing),
                        getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 2, missing), "craftingToolScrewdriver", null,
                        "craftingToolHardHammer" });
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 4, 0, "{track:\"railcraft:track.slow.boost\"}", missing),
                new Object[] { "screwAnyIron", "plateRedAlloy", "screwAnyIron",
                        getModItem(Railcraft.ID, "part.rail", 1, 1, missing),
                        getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 1, missing), "craftingToolScrewdriver",
                        "plateRedAlloy", "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "golden_rail", 4, 0, missing),
                new Object[] { "screwSteel", "plateRedAlloy", "screwSteel",
                        getModItem(Railcraft.ID, "part.rail", 1, 1, missing),
                        getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 1, missing), "craftingToolScrewdriver",
                        "plateRedAlloy", "craftingToolHardHammer" });
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 8, 0, "{track:\"railcraft:track.reinforced\"}", missing),
                new Object[] { "screwStainlessSteel", null, "screwStainlessSteel",
                        getModItem(Railcraft.ID, "part.rail", 1, 4, missing),
                        getModItem(Railcraft.ID, "part.railbed", 1, 1, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 4, missing), "craftingToolScrewdriver", null,
                        "craftingToolHardHammer" });
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 4, 0, "{track:\"railcraft:track.reinforced.boost\"}", missing),
                new Object[] { "screwStainlessSteel", "plateRedAlloy", "screwStainlessSteel",
                        getModItem(Railcraft.ID, "part.rail", 1, 4, missing),
                        getModItem(Railcraft.ID, "part.railbed", 1, 1, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 4, missing), "craftingToolScrewdriver",
                        "plateRedAlloy", "craftingToolHardHammer" });
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 8, 10192, "{track:\"railcraft:track.electric\"}", missing),
                new Object[] { "screwCopper", getModItem(Railcraft.ID, "part.rail", 1, 5, missing), "screwCopper",
                        getModItem(Railcraft.ID, "part.rail", 1, 5, missing),
                        getModItem(Railcraft.ID, "part.railbed", 1, 1, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 5, missing), "craftingToolScrewdriver",
                        getModItem(Railcraft.ID, "part.rail", 1, 5, missing), "craftingToolHardHammer" });
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 8, 816, "{track:\"railcraft:track.speed\"}", missing),
                new Object[] { "screwSteel", null, "screwSteel", getModItem(Railcraft.ID, "part.rail", 1, 3, missing),
                        getModItem(Railcraft.ID, "part.railbed", 1, 1, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 3, missing), "craftingToolScrewdriver", null,
                        "craftingToolHardHammer" });
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 4, 0, "{track:\"railcraft:track.speed.boost\"}", missing),
                new Object[] { "screwSteel", "plateRedAlloy", "screwSteel",
                        getModItem(Railcraft.ID, "part.rail", 1, 3, missing),
                        getModItem(Railcraft.ID, "part.railbed", 1, 1, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 3, missing), "craftingToolScrewdriver",
                        "plateRedAlloy", "craftingToolHardHammer" });
        addShapedRecipe(
                createItemStack(
                        Railcraft.ID,
                        "track",
                        1,
                        26865,
                        "{track:\"railcraft:track.speed.transition\"}",
                        missing),
                new Object[] { "screwSteel",
                        createItemStack(Railcraft.ID, "track", 1, 816, "{track:\"railcraft:track.speed\"}", missing),
                        "screwSteel", "plateRedAlloy", getModItem(Railcraft.ID, "part.railbed", 1, 1, missing),
                        "plateRedAlloy", "craftingToolScrewdriver",
                        createItemStack(Railcraft.ID, "track", 1, 816, "{track:\"railcraft:track.speed\"}", missing),
                        "craftingToolHardHammer" });
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 8103, "{track:\"railcraft:track.priming\"}", missing),
                new Object[] { "screwSteel", getModItem(Railcraft.ID, "detector", 1, 1, missing), "screwSteel",
                        getModItem(Railcraft.ID, "part.rail", 1, 4, missing),
                        getModItem(Railcraft.ID, "part.railbed", 1, 1, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 4, missing), "craftingToolScrewdriver",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32476, missing), "craftingToolHardHammer" });
        addShapedRecipe(
                createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.launcher\"}", missing),
                new Object[] { "screwSteel",
                        createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.reinforced\"}", missing),
                        "screwSteel", "blockSteel", getModItem(Minecraft.ID, "piston", 1, 0, missing), "blockSteel",
                        "craftingToolScrewdriver", "plateRedAlloy", "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "track.elevator", 2, 0, missing),
                new Object[] { "screwSteel", getModItem(Railcraft.ID, "detector", 1, 1, missing), "screwSteel",
                        getModItem(Railcraft.ID, "part.rail", 1, 1, missing),
                        getModItem(Minecraft.ID, "rail", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 1, missing), "craftingToolScrewdriver",
                        "plateRedAlloy", "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 4, missing),
                new Object[] { "screwSteel", "stickRedAlloy", "stickTin",
                        getModItem(Minecraft.ID, "lever", 1, 0, missing),
                        getModItem(Minecraft.ID, "sticky_piston", 1, 0, missing), "screwSteel", "plateSteel",
                        "plateSteel", "plateSteel" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 2, missing),
                new Object[] { "screwSteel", "stickRedAlloy", "stickTin",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(Railcraft.ID, "part.circuit", 1, 1, missing), "plateSteel", "plateSteel",
                        "plateSteel" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 3, missing),
                new Object[] { getModItem(Railcraft.ID, "part.signal.lamp", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.circuit", 1, 2, missing), "plateSteel", null, null, "plateSteel",
                        null, null, "plateSteel" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 11, missing),
                new Object[] { getModItem(Railcraft.ID, "part.signal.lamp", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.circuit", 1, 1, missing), "plateSteel", null, null, "plateSteel",
                        null, null, "plateSteel" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 1, missing),
                new Object[] { getModItem(Railcraft.ID, "part.signal.lamp", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.circuit", 1, 2, missing), "plateSteel", "plateSteel",
                        "plateSteel", "plateSteel", getModItem(Railcraft.ID, "part.signal.lamp", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.circuit", 1, 1, missing), "plateSteel" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 12, missing),
                new Object[] { getModItem(Railcraft.ID, "part.signal.lamp", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.circuit", 1, 1, missing), "plateSteel", "plateSteel",
                        "plateSteel", "plateSteel", getModItem(Railcraft.ID, "part.signal.lamp", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.circuit", 1, 1, missing), "plateSteel" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 13, missing),
                new Object[] { "plateSteel", getModItem(Railcraft.ID, "part.circuit", 1, 2, missing), "plateSteel",
                        "plateSteel", "plateRedAlloy", "plateSteel" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 9, missing),
                new Object[] { "plateSteel", getModItem(Railcraft.ID, "part.circuit", 1, 0, missing), "plateSteel",
                        "plateSteel", "plateRedAlloy", "plateSteel" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 10, missing),
                new Object[] { "plateSteel", getModItem(Railcraft.ID, "part.circuit", 1, 0, missing), "plateSteel",
                        "plateSteel",
                        getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26, missing),
                        "plateSteel" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 8, missing),
                new Object[] { "plateSteel", getModItem(Railcraft.ID, "part.circuit", 1, 1, missing), "plateSteel",
                        "plateSteel", "plateRedAlloy", "plateSteel" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 7, missing),
                new Object[] { "plateSteel",
                        getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 10, missing),
                        "plateSteel", "plateSteel", "plateRedAlloy", "plateSteel" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 6, missing),
                new Object[] { "plateSteel",
                        getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26, missing),
                        "plateSteel", "plateSteel", "plateRedAlloy", "plateSteel" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "signal", 4, 0, missing),
                new Object[] { "plateSteel", getModItem(Railcraft.ID, "part.circuit", 1, 1, missing), "plateSteel",
                        "plateSteel", getModItem(Railcraft.ID, "part.circuit", 1, 0, missing), "plateSteel",
                        "plateSteel", "plateRedAlloy", "plateSteel" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.rail", 12, 2, missing),
                new Object[] { "stickAnyIron", getModItem(Railcraft.ID, "part.tie", 1, 0, missing), "stickWood",
                        "stickAnyIron", getModItem(Railcraft.ID, "part.tie", 1, 0, missing), "stickWood",
                        "stickAnyIron", getModItem(Railcraft.ID, "part.tie", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.rail", 8, 2, missing),
                new Object[] { "stickAnyIron", getModItem(Railcraft.ID, "part.tie", 1, 0, missing), "stickWood",
                        "stickAnyIron", getModItem(Railcraft.ID, "part.tie", 1, 0, missing), "stickWood", null, null,
                        null });
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.rail", 4, 2, missing),
                new Object[] { "stickAnyIron", getModItem(Railcraft.ID, "part.tie", 1, 0, missing), "stickWood", null,
                        null, null, null, null, null });
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.rail", 12, 0, missing),
                new Object[] { "stickAnyIron", getModItem(Railcraft.ID, "part.tie", 1, 1, missing), "stickAnyIron",
                        "stickAnyIron", getModItem(Railcraft.ID, "part.tie", 1, 1, missing), "stickAnyIron",
                        "stickAnyIron", getModItem(Railcraft.ID, "part.tie", 1, 1, missing), "stickAnyIron" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.rail", 8, 0, missing),
                new Object[] { "stickAnyIron", getModItem(Railcraft.ID, "part.tie", 1, 1, missing), "stickAnyIron",
                        "stickAnyIron", getModItem(Railcraft.ID, "part.tie", 1, 1, missing), "stickAnyIron", null, null,
                        null });
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.rail", 4, 0, missing),
                new Object[] { "stickAnyIron", getModItem(Railcraft.ID, "part.tie", 1, 1, missing), "stickAnyIron",
                        null, null, null, null, null, null });
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.rail", 4, 1, missing),
                new Object[] { getModItem(Railcraft.ID, "part.rail", 1, 0, missing), "plateRedstone", "stickElectrum",
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing), "plateRedstone", "stickElectrum",
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing), "craftingToolHardHammer",
                        "stickElectrum" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 0, missing),
                new Object[] { "logWood", getModItem(Minecraft.ID, "rail", 1, 0, missing), "logWood", "plateRedAlloy",
                        getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing), "plateRedAlloy",
                        "logWood", "plateRedAlloy", "logWood" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 1, missing),
                new Object[] { getModItem(Minecraft.ID, "stone", 1, 0, missing),
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                        getModItem(Minecraft.ID, "stone", 1, 0, missing), "plateRedAlloy",
                        getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing), "plateRedAlloy",
                        getModItem(Minecraft.ID, "stone", 1, 0, missing), "plateRedAlloy",
                        getModItem(Minecraft.ID, "stone", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 2, missing),
                new Object[] { "stoneBricks", null, "stoneBricks", "plateRedAlloy",
                        getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing), "plateRedAlloy",
                        "stoneBricks", "plateRedAlloy", "stoneBricks" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 3, missing),
                new Object[] { "stoneMossy", getModItem(Minecraft.ID, "skull", 1, 2, missing), "stoneMossy",
                        "plateRedAlloy", getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing),
                        "plateRedAlloy", "stoneMossy", "plateRedAlloy", "stoneMossy" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 4, missing),
                new Object[] { "stoneCobble",
                        getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26, missing),
                        "stoneCobble", "plateRedAlloy",
                        getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing), "plateRedAlloy",
                        "stoneCobble", "plateRedAlloy", "stoneCobble" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 5, missing),
                new Object[] { getModItem(Minecraft.ID, "stone_slab", 1, 0, missing),
                        getModItem(Minecraft.ID, "skull", 1, 3, missing),
                        getModItem(Minecraft.ID, "stone_slab", 1, 0, missing), "plateRedAlloy",
                        getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing), "plateRedAlloy",
                        getModItem(Minecraft.ID, "stone_slab", 1, 0, missing), "plateRedAlloy",
                        getModItem(Minecraft.ID, "stone_slab", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 6, missing),
                new Object[] { "slabWood", getModItem(Minecraft.ID, "tnt", 1, 0, missing), "slabWood", "plateRedAlloy",
                        getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing), "plateRedAlloy",
                        "slabWood", "plateRedAlloy", "slabWood" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 7, missing),
                new Object[] { "logWood", "itemLeather", "logWood", "plateRedAlloy",
                        getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing), "plateRedAlloy",
                        "logWood", "plateRedAlloy", "logWood" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 8, missing),
                new Object[] { getModItem(Minecraft.ID, "brick", 1, 0, missing),
                        getModItem(Railcraft.ID, "machine.beta", 1, 0, missing),
                        getModItem(Minecraft.ID, "brick", 1, 0, missing), "plateRedAlloy",
                        getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing), "plateRedAlloy",
                        getModItem(Minecraft.ID, "brick", 1, 0, missing), "plateRedAlloy",
                        getModItem(Minecraft.ID, "brick", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 9, missing),
                new Object[] { "plateSteel", getModItem(Railcraft.ID, "detector", 1, 1, missing), "plateSteel",
                        "plateRedAlloy", getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0, missing),
                        "plateRedAlloy", "plateSteel", "plateRedAlloy", "plateSteel" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 10, missing),
                new Object[] { "plateTin", "cableGt01Tin", "plateTin", "plateRedAlloy",
                        getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing), "plateRedAlloy",
                        "plateTin", "plateRedAlloy", "plateTin" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 11, missing),
                new Object[] { "logWood", "cropWheat", "logWood", "plateRedAlloy",
                        getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing), "plateRedAlloy",
                        "logWood", "plateRedAlloy", "logWood" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 12, missing),
                new Object[] { "stoneNetherBrick",
                        createItemStack(
                                Railcraft.ID,
                                "track",
                                1,
                                30516,
                                "{track:\"railcraft:track.locomotive\"}",
                                missing),
                        "stoneNetherBrick", "plateRedAlloy",
                        getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing), "plateRedAlloy",
                        "stoneNetherBrick", "plateRedAlloy", "stoneNetherBrick" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 13, missing),
                new Object[] { "blockWool", getModItem(Minecraft.ID, "shears", 1, 0, missing), "blockWool",
                        "plateRedAlloy", getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing),
                        "plateRedAlloy", "blockWool", "plateRedAlloy", "blockWool" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 14, missing),
                new Object[] { "itemLeather", "plateEmerald", "itemLeather", "plateRedAlloy",
                        getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing), "plateRedAlloy",
                        "itemLeather", "plateRedAlloy", "itemLeather" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 15, missing),
                new Object[] { getModItem(Railcraft.ID, "brick.infernal", 1, 0, missing),
                        createItemStack(
                                Railcraft.ID,
                                "track",
                                1,
                                30516,
                                "{track:\"railcraft:track.locomotive\"}",
                                missing),
                        getModItem(Railcraft.ID, "brick.infernal", 1, 0, missing), "plateRedAlloy",
                        getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing), "plateRedAlloy",
                        getModItem(Railcraft.ID, "brick.infernal", 1, 0, missing), "plateRedAlloy",
                        getModItem(Railcraft.ID, "brick.infernal", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Railcraft.ID, "detector", 4, 16, missing),
                new Object[] { getModItem(Minecraft.ID, "quartz_block", 1, 1, missing),
                        getModItem(Railcraft.ID, "signal", 1, 4, missing),
                        getModItem(Minecraft.ID, "quartz_block", 1, 1, missing), "plateRedAlloy",
                        getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing), "plateRedAlloy",
                        getModItem(Minecraft.ID, "quartz_block", 1, 1, missing), "plateRedAlloy",
                        getModItem(Minecraft.ID, "quartz_block", 1, 1, missing) });
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 2, 0, missing),
                new Object[] { "stoneCobble", getModItem(Minecraft.ID, "hopper", 1, 0, missing), "stoneCobble",
                        "plateRedAlloy", getModItem(Railcraft.ID, "detector", 1, 0, missing), "plateRedAlloy",
                        "stoneCobble", getModItem(Minecraft.ID, "chest", 1, 0, missing), "stoneCobble" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 2, 1, missing),
                new Object[] { "stoneCobble", getModItem(Minecraft.ID, "chest", 1, 0, missing), "stoneCobble",
                        "plateRedAlloy", getModItem(Railcraft.ID, "detector", 1, 0, missing), "plateRedAlloy",
                        "stoneCobble", getModItem(Minecraft.ID, "hopper", 1, 0, missing), "stoneCobble" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 2, 2, missing),
                new Object[] { "plateSteel", getModItem(Minecraft.ID, "hopper", 1, 0, missing), "plateSteel",
                        "plateRedAlloy", getModItem(Railcraft.ID, "detector", 1, 1, missing), "plateRedAlloy",
                        "plateSteel", getModItem(Minecraft.ID, "chest", 1, 0, missing), "plateSteel" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 2, 3, missing),
                new Object[] { "plateSteel", getModItem(Minecraft.ID, "chest", 1, 0, missing), "plateSteel",
                        "plateRedAlloy", getModItem(Railcraft.ID, "detector", 1, 1, missing), "plateRedAlloy",
                        "plateSteel", getModItem(Minecraft.ID, "hopper", 1, 0, missing), "plateSteel" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 2, 4, missing),
                new Object[] { "paneGlass", getModItem(GregTech.ID, "gt.blockmachines", 1, 5133, missing), "paneGlass",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                        getModItem(Railcraft.ID, "detector", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing), "paneGlass",
                        getModItem(Railcraft.ID, "machine.beta", 1, 0, missing), "paneGlass" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 2, 5, missing),
                new Object[] { "paneGlass", getModItem(Railcraft.ID, "machine.beta", 1, 0, missing), "paneGlass",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                        getModItem(Railcraft.ID, "detector", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing), "paneGlass",
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5133, missing), "paneGlass" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 2, 6, missing),
                new Object[] { "plateSteel", getModItem(GregTech.ID, "gt.blockmachines", 1, 1426, missing),
                        "plateSteel", "plateRedAlloy", getModItem(Railcraft.ID, "detector", 1, 10, missing),
                        "plateRedAlloy", "plateSteel", getModItem(IndustrialCraft2.ID, "itemAdvBat", 1, 32767, missing),
                        "plateSteel" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 2, 7, missing),
                new Object[] { "plateSteel", getModItem(IndustrialCraft2.ID, "itemAdvBat", 1, 32767, missing),
                        "plateSteel", "plateRedAlloy", getModItem(Railcraft.ID, "detector", 1, 10, missing),
                        "plateRedAlloy", "plateSteel", getModItem(GregTech.ID, "gt.blockmachines", 1, 1426, missing),
                        "plateSteel" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 1, 8, missing),
                new Object[] { getModItem(Minecraft.ID, "dispenser", 1, 0, missing),
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                        getModItem(Minecraft.ID, "rail", 1, 0, missing), null,
                        getModItem(Railcraft.ID, "tool.crowbar", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 1, 9, missing),
                new Object[] { getModItem(Railcraft.ID, "tool.crowbar", 1, 0, missing), "plateRedAlloy",
                        getModItem(Railcraft.ID, "tool.crowbar", 1, 0, missing), "plateRedAlloy",
                        getModItem(Railcraft.ID, "machine.gamma", 1, 8, missing), "plateRedAlloy",
                        getModItem(Railcraft.ID, "tool.crowbar", 1, 0, missing), "plateRedAlloy",
                        getModItem(Railcraft.ID, "tool.crowbar", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.epsilon", 1, 0, missing),
                new Object[] { "plateSteel", getModItem(GregTech.ID, "gt.blockmachines", 1, 1362, missing),
                        "plateSteel", "plateRedAlloy", getModItem(Railcraft.ID, "detector", 1, 10, missing),
                        "plateRedAlloy", "plateSteel", getModItem(GregTech.ID, "gt.blockmachines", 1, 1362, missing),
                        "plateSteel" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.epsilon", 1, 4, missing),
                new Object[] { "plateBronze", getModItem(GregTech.ID, "gt.blockmachines", 1, 1422, missing),
                        "plateBronze", "plateRedAlloy", getModItem(Railcraft.ID, "detector", 1, 10, missing),
                        "plateRedAlloy", "plateBronze", getModItem(Railcraft.ID, "machine.delta", 1, 0, missing),
                        "plateBronze" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.epsilon", 1, 3, missing),
                new Object[] { "lensDiamond", "circuitAdvanced", "lensDiamond",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32682, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 13, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32682, missing), "cableGt01Gold",
                        "circuitAdvanced", "cableGt01Gold" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "cart.work", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", getModItem(Minecraft.ID, "crafting_table", 1, 0, missing),
                        "craftingToolWrench", null, getModItem(Minecraft.ID, "minecart", 1, 0, missing), null, null,
                        "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem(Railcraft.ID, "cart.tank", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", getModItem(Railcraft.ID, "machine.beta", 1, 1, missing),
                        "craftingToolWrench", null, getModItem(Minecraft.ID, "minecart", 1, 0, missing), null, null,
                        "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem(Railcraft.ID, "tool.steel.shears", 1, 0, missing),
                new Object[] { "plateSteel", "screwSteel", "plateSteel", "craftingToolHardHammer", "ringSteel",
                        "craftingToolFile", "stickWood", "craftingToolScrewdriver", "stickWood" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "stair", 4, 6, missing),
                new Object[] { "blockIron", null, null, "blockIron", "blockIron", null, "blockIron", "blockIron",
                        "blockIron" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "stair", 4, 43, missing),
                new Object[] { "blockSteel", null, null, "blockSteel", "blockSteel", null, "blockSteel", "blockSteel",
                        "blockSteel" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "stair", 4, 40, missing),
                new Object[] { "blockCopper", null, null, "blockCopper", "blockCopper", null, "blockCopper",
                        "blockCopper", "blockCopper" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "stair", 4, 41, missing),
                new Object[] { "blockTin", null, null, "blockTin", "blockTin", null, "blockTin", "blockTin",
                        "blockTin" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "stair", 4, 42, missing),
                new Object[] { "blockLead", null, null, "blockLead", "blockLead", null, "blockLead", "blockLead",
                        "blockLead" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "stair", 4, 7, missing),
                new Object[] { "blockGold", null, null, "blockGold", "blockGold", null, "blockGold", "blockGold",
                        "blockGold" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "stair", 4, 8, missing),
                new Object[] { "blockDiamond", null, null, "blockDiamond", "blockDiamond", null, "blockDiamond",
                        "blockDiamond", "blockDiamond" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 0, missing),
                new Object[] { getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 1, 28, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing), "craftingToolFile",
                        getModItem(Minecraft.ID, "torch", 1, 0, missing), "craftingToolHardHammer",
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 1, 28, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 1, missing),
                new Object[] { getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 1, 26, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing), "craftingToolFile",
                        getModItem(Minecraft.ID, "torch", 1, 0, missing), "craftingToolHardHammer",
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 1, 26, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 2, missing),
                new Object[] { getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 1, 27, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing), "craftingToolFile",
                        getModItem(Minecraft.ID, "torch", 1, 0, missing), "craftingToolHardHammer",
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 1, 27, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 3, missing),
                new Object[] { getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 1, 24, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing), "craftingToolFile",
                        getModItem(Minecraft.ID, "torch", 1, 0, missing), "craftingToolHardHammer",
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 1, 24, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 4, missing),
                new Object[] { getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 1, 23, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing), "craftingToolFile",
                        getModItem(Minecraft.ID, "torch", 1, 0, missing), "craftingToolHardHammer",
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 1, 23, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 5, missing),
                new Object[] { getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 1, 29, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing), "craftingToolFile",
                        getModItem(Minecraft.ID, "torch", 1, 0, missing), "craftingToolHardHammer",
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 1, 29, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 6, missing),
                new Object[] { getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 1, 25, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing), "craftingToolFile",
                        getModItem(Minecraft.ID, "torch", 1, 0, missing), "craftingToolHardHammer",
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 1, 25, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 7, missing),
                new Object[] { getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 1, 22, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing), "craftingToolFile",
                        getModItem(Minecraft.ID, "torch", 1, 0, missing), "craftingToolHardHammer",
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 1, 22, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 8, missing),
                new Object[] { getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(Minecraft.ID, "stone_slab", 1, 1, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing), "craftingToolFile",
                        getModItem(Minecraft.ID, "torch", 1, 0, missing), "craftingToolHardHammer",
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(Minecraft.ID, "stone_slab", 1, 1, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.stone", 1, 9, missing),
                new Object[] { getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(Minecraft.ID, "stone_slab", 1, 0, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing), "craftingToolFile",
                        getModItem(Minecraft.ID, "torch", 1, 0, missing), "craftingToolHardHammer",
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(Minecraft.ID, "stone_slab", 1, 0, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.metal", 1, 0, missing),
                new Object[] { "screwAnyIron", "plateAnyIron", "screwAnyIron", "craftingToolScrewdriver",
                        getModItem(Minecraft.ID, "torch", 1, 0, missing), "craftingToolHardHammer", "screwAnyIron",
                        "plateAnyIron", "screwAnyIron" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.metal", 1, 1, missing),
                new Object[] { "screwGold", "plateGold", "screwGold", "craftingToolScrewdriver",
                        getModItem(Minecraft.ID, "torch", 1, 0, missing), "craftingToolHardHammer", "screwGold",
                        "plateGold", "screwGold" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.metal", 1, 2, missing),
                new Object[] { "screwCopper", "plateCopper", "screwCopper", "craftingToolScrewdriver",
                        getModItem(Minecraft.ID, "torch", 1, 0, missing), "craftingToolHardHammer", "screwCopper",
                        "plateCopper", "screwCopper" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.metal", 1, 3, missing),
                new Object[] { "screwTin", "plateTin", "screwTin", "craftingToolScrewdriver",
                        getModItem(Minecraft.ID, "torch", 1, 0, missing), "craftingToolHardHammer", "screwTin",
                        "plateTin", "screwTin" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.metal", 1, 4, missing),
                new Object[] { "screwLead", "plateLead", "screwLead", "craftingToolScrewdriver",
                        getModItem(Minecraft.ID, "torch", 1, 0, missing), "craftingToolHardHammer", "screwLead",
                        "plateLead", "screwLead" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "lantern.metal", 1, 5, missing),
                new Object[] { "screwSteel", "plateSteel", "screwSteel", "craftingToolScrewdriver",
                        getModItem(Minecraft.ID, "torch", 1, 0, missing), "craftingToolHardHammer", "screwSteel",
                        "plateSteel", "screwSteel" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "part.signal.lamp", 8, 0, missing),
                new Object[] { "paneGlass",
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_29\"}",
                                missing),
                        "plateAnyIron", "paneGlass",
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_20\"}",
                                missing),
                        "plateAnyIron", "paneGlass",
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_30\"}",
                                missing),
                        "plateAnyIron" });
        addShapelessCraftingRecipe(
                getModItem(Railcraft.ID, "part.turbine.disk", 1, 0, missing),
                new Object[] { getModItem(IndustrialCraft2.ID, "itemSteamTurbineBlade", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Railcraft.ID, "part.turbine.rotor", 1, 0, missing),
                new Object[] { getModItem(IndustrialCraft2.ID, "itemSteamTurbine", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Railcraft.ID, "armor.goggles", 1, 0, missing),
                new Object[] { "lensGlass", "boltSteel", "lensGlass", "ringSteel", "screwSteel", "ringSteel",
                        "itemLeather", getModItem(Railcraft.ID, "part.circuit", 1, 1, missing), "itemLeather" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "tool.magnifying.glass", 1, 0, missing),
                new Object[] { null, null, "lensGlass", null, "ringSteel", null, "stickSteel", null, null });
        addShapelessCraftingRecipe(
                getModItem(Railcraft.ID, "machine.alpha", 1, 7, missing),
                new Object[] { getModItem(NewHorizonsCoreMod.ID, "item.CokeOvenBrick", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CokeOvenBrick", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CokeOvenBrick", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.CokeOvenBrick", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Railcraft.ID, "brick.sandy", 2, 2, missing),
                new Object[] { "ingotBrick", "sand", null, "sand", "ingotBrick", null, null, null, null });
        addShapedRecipe(
                getModItem(Railcraft.ID, "brick.sandy", 1, 2, missing),
                new Object[] { getModItem(Railcraft.ID, "slab", 1, 21, missing), null, null,
                        getModItem(Railcraft.ID, "slab", 1, 21, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem(Railcraft.ID, "slab", 2, 38, missing),
                new Object[] { "craftingToolSaw", getModItem(Railcraft.ID, "cube", 1, 8, missing) });
        addShapedRecipe(
                getModItem(Railcraft.ID, "backpack.trackman.t1", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                        getModItem(Minecraft.ID, "rail", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing), "itemLeather",
                        getModItem(Minecraft.ID, "rail", 1, 0, missing), "itemLeather", "itemLeather",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "itemLeather" });
        addShapelessCraftingRecipe(
                getModItem(Railcraft.ID, "backpack.trackman.t1", 1, 0, missing),
                new Object[] { getModItem(Railcraft.ID, "backpack.trackman.t1", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Railcraft.ID, "backpack.iceman.t1", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "hardIce", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing), "itemLeather",
                        getModItem(BiomesOPlenty.ID, "hardIce", 1, 0, missing), "itemLeather", "itemLeather",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "itemLeather" });
        addShapelessCraftingRecipe(
                getModItem(Railcraft.ID, "backpack.iceman.t1", 1, 0, missing),
                new Object[] { getModItem(Railcraft.ID, "backpack.iceman.t1", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Railcraft.ID, "backpack.apothecary.t1", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                        getModItem(Minecraft.ID, "potion", 1, 8229, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing), "itemLeather",
                        getModItem(Minecraft.ID, "potion", 1, 8229, missing), "itemLeather", "itemLeather",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "itemLeather" });
        addShapelessCraftingRecipe(
                getModItem(Railcraft.ID, "backpack.apothecary.t1", 1, 0, missing),
                new Object[] { getModItem(Railcraft.ID, "backpack.apothecary.t1", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Railcraft.ID, "brick.infernal", 2, 2, missing),
                new Object[] { "ingotBrickNether", getModItem(Minecraft.ID, "soul_sand", 1, 0, missing), null,
                        getModItem(Minecraft.ID, "soul_sand", 1, 0, missing), "ingotBrickNether", null, null, null,
                        null });
        addShapedRecipe(
                getModItem(Railcraft.ID, "upgrade.lapotron", 1, 0, missing),
                new Object[] { "itemCasingAluminium", "circuitAdvanced", "itemCasingAluminium", "cableGt02Platinum",
                        getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, 32767, missing), "cableGt02Platinum",
                        "itemCasingAluminium", "circuitAdvanced", "itemCasingAluminium" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "cart.cargo", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", getModItem(Minecraft.ID, "chest", 1, 0, missing),
                        "craftingToolWrench", "plateSteel", getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                        "plateSteel", null, "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem(Railcraft.ID, "cart.track.relayer", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32650, missing),
                        getModItem(IC2NuclearControl.ID, "blockNuclearControlLight", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32650, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing), "circuitBasic",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "CartModule", 1, 8, missing) });
        addShapedRecipe(
                getModItem(Railcraft.ID, "cart.undercutter", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32650, missing),
                        getModItem(IC2NuclearControl.ID, "blockNuclearControlLight", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32650, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing), "circuitBasic",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing) });
        addShapedRecipe(
                getModItem(Railcraft.ID, "cart.track.layer", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32650, missing),
                        getModItem(IC2NuclearControl.ID, "blockNuclearControlLight", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32650, missing),
                        getModItem(Minecraft.ID, "anvil", 1, 0, missing), "circuitBasic",
                        getModItem(Minecraft.ID, "anvil", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                        getModItem(Minecraft.ID, "dispenser", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Railcraft.ID, "cart.track.remover", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32650, missing),
                        getModItem(IC2NuclearControl.ID, "blockNuclearControlLight", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32650, missing),
                        getModItem(Railcraft.ID, "tool.crowbar.reinforced", 1, 0, missing), "circuitBasic",
                        getModItem(Railcraft.ID, "tool.crowbar.reinforced", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing) });
        addShapedRecipe(
                getModItem(Railcraft.ID, "cart.redstone.flux", 1, 0, missing),
                new Object[] { "plateLead", "craftingToolScrewdriver", "plateLead",
                        createItemStack(
                                EnderIO.ID,
                                "blockCapBank",
                                1,
                                1,
                                "{type:\"SIMPLE\",storedEnergyRF:0}",
                                missing),
                        "circuitBasic",
                        createItemStack(
                                EnderIO.ID,
                                "blockCapBank",
                                1,
                                1,
                                "{type:\"SIMPLE\",storedEnergyRF:0}",
                                missing),
                        "screwSteel", getModItem(Minecraft.ID, "minecart", 1, 0, missing), "screwSteel" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 1, 10, missing),
                new Object[] { "plateLead", getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing), "plateLead",
                        "plateRedstoneAlloy", getModItem(Railcraft.ID, "detector", 1, 10, missing),
                        "plateRedstoneAlloy", "plateLead",
                        createItemStack(
                                EnderIO.ID,
                                "blockCapBank",
                                1,
                                1,
                                "{type:\"SIMPLE\",storedEnergyRF:0}",
                                missing),
                        "plateLead" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.gamma", 1, 11, missing),
                new Object[] { "plateLead",
                        createItemStack(
                                EnderIO.ID,
                                "blockCapBank",
                                1,
                                1,
                                "{type:\"SIMPLE\",storedEnergyRF:0}",
                                missing),
                        "plateLead", "plateRedstoneAlloy", getModItem(Railcraft.ID, "detector", 1, 10, missing),
                        "plateRedstoneAlloy", "plateLead", getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing),
                        "plateLead" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "machine.epsilon", 1, 5, missing),
                new Object[] { "screwSteel", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744, missing), "screwSteel",
                        "plateSteel", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing), "plateSteel",
                        "craftingToolScrewdriver", "plateSteel", "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem(Railcraft.ID, "brick.nether", 4, 5, missing),
                new Object[] { "stoneCobble", getModItem(Minecraft.ID, "netherrack", 1, 0, missing), null,
                        getModItem(Minecraft.ID, "netherrack", 1, 0, missing), "stoneCobble", null, null, null, null });

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
        GT_Values.RA.addFuel(
                createItemStack(
                        IndustrialCraft2.ID,
                        "itemFluidCell",
                        1,
                        0,
                        "{Fluid:{FluidName:\"creosote\",Amount:1000}}",
                        missing),
                getModItem(IndustrialCraft2.ID, "itemFluidCell", 1, 0, missing),
                8,
                0);
        GT_Values.RA.addFuel(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 30712, missing),
                getModItem(IndustrialCraft2.ID, "itemFluidCell", 1, 0, missing),
                8,
                0);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "fuel.coke", 9, 0, missing))
                .itemOutputs(getModItem(Railcraft.ID, "cube", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "slab", 2, 2, missing))
                .itemOutputs(getModItem(Railcraft.ID, "cube", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "slab", 4, 38, missing))
                .itemOutputs(getModItem(Railcraft.ID, "cube", 1, 8, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.AdvancedCokeOvenBrick", 4, 0, missing))
                .itemOutputs(getModItem(Railcraft.ID, "machine.alpha", 1, 12, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.CokeOvenBrick", 4, 0, missing))
                .itemOutputs(getModItem(Railcraft.ID, "machine.alpha", 1, 7, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "cube", 1, 0, missing))
                .itemOutputs(getModItem(Railcraft.ID, "fuel.coke", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(400).eut(5).addTo(sCentrifugeRecipes);
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
                getModItem(Forestry.ID, "waxCast", 1, 32767, missing),
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem(Railcraft.ID, "glass", 4, 0, missing),
                new Object[] { "abc", "def", "ghi", 'a', getModItem(GregTech.ID, "gt.metaitem.01", 1, 2804, missing),
                        'b', getModItem(GregTech.ID, "gt.metaitem.01", 1, 2836, missing), 'c',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2804, missing), 'd',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2057, missing), 'e',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2522, missing), 'f',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2032, missing), 'g',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2804, missing), 'h',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2836, missing), 'i',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2804, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                getModItem(Forestry.ID, "waxCast", 1, 32767, missing),
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem(Railcraft.ID, "glass", 4, 0, missing),
                new Object[] { "abc", "def", "ghi", 'a', getModItem(GregTech.ID, "gt.metaitem.01", 1, 2804, missing),
                        'b', getModItem(GregTech.ID, "gt.metaitem.01", 1, 2836, missing), 'c',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2804, missing), 'd',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2057, missing), 'e',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2516, missing), 'f',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2032, missing), 'g',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2804, missing), 'h',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2836, missing), 'i',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2804, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                getModItem(Forestry.ID, "waxCast", 1, 32767, missing),
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem(Railcraft.ID, "glass", 4, 0, missing),
                new Object[] { "abc", "def", "ghi", 'a', getModItem(GregTech.ID, "gt.metaitem.01", 1, 2804, missing),
                        'b', getModItem(GregTech.ID, "gt.metaitem.01", 1, 2836, missing), 'c',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2804, missing), 'd',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2057, missing), 'e',
                        getModItem(NewHorizonsCoreMod.ID, "item.ChargedCertusQuartzDust", 1, 0, missing), 'f',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2032, missing), 'g',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2804, missing), 'h',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2836, missing), 'i',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2804, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                getModItem(Forestry.ID, "waxCast", 1, 32767, missing),
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem(Railcraft.ID, "glass", 4, 0, missing),
                new Object[] { "abc", "def", "ghi", 'a', getModItem(GregTech.ID, "gt.metaitem.01", 1, 2804, missing),
                        'b', getModItem(GregTech.ID, "gt.metaitem.01", 1, 2836, missing), 'c',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2804, missing), 'd',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2057, missing), 'e',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2523, missing), 'f',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2032, missing), 'g',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2804, missing), 'h',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2836, missing), 'i',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2804, missing) });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "torch", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 2, 28, missing))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "torch", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 2, 26, missing))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "torch", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 2, 27, missing))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 2, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "torch", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 2, 24, missing))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 3, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "torch", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 2, 23, missing))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 4, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "torch", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 2, 29, missing))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 5, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "torch", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 2, 25, missing))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 6, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "torch", 1, 0, missing),
                        getModItem(Railcraft.ID, "slab", 2, 22, missing))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 7, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "torch", 1, 0, missing),
                        getModItem(Minecraft.ID, "stone_slab", 2, 1, missing))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 8, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "torch", 1, 0, missing),
                        getModItem(Minecraft.ID, "stone_slab", 2, 0, missing))
                .itemOutputs(getModItem(Railcraft.ID, "lantern.stone", 1, 9, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(2).addTo(sAssemblerRecipes);
        Module_CustomFuels.registerCustomFuelValue(
                getModItem(Railcraft.ID, "fluid.creosote.bucket", 1, 0, missing),
                (short) 6400);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stone", 5, 0, missing),
                        getModItem(Railcraft.ID, "part.rebar", 4, 0, missing))
                .itemOutputs(getModItem(Railcraft.ID, "cube", 5, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(0).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 5, 11305, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.MoldHelmet", 0, 0, missing))
                .itemOutputs(getModItem(Railcraft.ID, "armor.steel.helmet", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 11305, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.MoldChestplate", 0, 0, missing))
                .itemOutputs(getModItem(Railcraft.ID, "armor.steel.plate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 7, 11305, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.MoldLeggings", 0, 0, missing))
                .itemOutputs(getModItem(Railcraft.ID, "armor.steel.legs", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 11305, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.MoldBoots", 0, 0, missing))
                .itemOutputs(getModItem(Railcraft.ID, "armor.steel.boots", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass_pane", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 4, missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_29\"}",
                                missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_20\"}",
                                missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_30\"}",
                                missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 16, missing))
                .itemOutputs(getModItem(Railcraft.ID, "part.signal.lamp", 16, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stained_glass_pane", 1, 32767, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 4, missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_29\"}",
                                missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_20\"}",
                                missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_30\"}",
                                missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 16, missing))
                .itemOutputs(getModItem(Railcraft.ID, "part.signal.lamp", 16, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass_pane", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17032, missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_29\"}",
                                missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_20\"}",
                                missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_30\"}",
                                missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 16, missing))
                .itemOutputs(getModItem(Railcraft.ID, "part.signal.lamp", 16, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stained_glass_pane", 1, 32767, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17032, missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_29\"}",
                                missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_20\"}",
                                missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_30\"}",
                                missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 16, missing))
                .itemOutputs(getModItem(Railcraft.ID, "part.signal.lamp", 16, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass_pane", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17304, missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_29\"}",
                                missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_20\"}",
                                missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_30\"}",
                                missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 16, missing))
                .itemOutputs(getModItem(Railcraft.ID, "part.signal.lamp", 16, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stained_glass_pane", 1, 32767, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17304, missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_29\"}",
                                missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_20\"}",
                                missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_30\"}",
                                missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 16, missing))
                .itemOutputs(getModItem(Railcraft.ID, "part.signal.lamp", 16, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass_pane", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17307, missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_29\"}",
                                missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_20\"}",
                                missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_30\"}",
                                missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 16, missing))
                .itemOutputs(getModItem(Railcraft.ID, "part.signal.lamp", 16, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stained_glass_pane", 1, 32767, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17307, missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_29\"}",
                                missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_20\"}",
                                missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_30\"}",
                                missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 16, missing))
                .itemOutputs(getModItem(Railcraft.ID, "part.signal.lamp", 16, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass_pane", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.plate", 1, 0, missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_29\"}",
                                missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_20\"}",
                                missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_30\"}",
                                missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 16, missing))
                .itemOutputs(getModItem(Railcraft.ID, "part.signal.lamp", 16, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stained_glass_pane", 1, 32767, missing),
                        getModItem(Railcraft.ID, "part.plate", 1, 0, missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_29\"}",
                                missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_20\"}",
                                missing),
                        createItemStack(
                                ForgeMicroblocks.ID,
                                "microblock",
                                1,
                                516,
                                "{mat:\"ProjRed|Illumination:projectred.illumination.lamp_30\"}",
                                missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 16, missing))
                .itemOutputs(getModItem(Railcraft.ID, "part.signal.lamp", 16, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Railcraft.ID, "firestone.cut", 1, 0, missing),
                        getModItem(Minecraft.ID, "redstone_block", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Railcraft.ID, "firestone.refined", 1, 5000, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lava", 576)).noFluidOutputs().duration(200).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Railcraft.ID, "firestone.cracked", 1, 32767, missing),
                        getModItem(Minecraft.ID, "redstone_block", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Railcraft.ID, "firestone.refined", 1, 5000, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lava", 576)).noFluidOutputs().duration(200).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                        getModItem(Minecraft.ID, "crafting_table", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Railcraft.ID, "cart.work", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                        getModItem(Railcraft.ID, "machine.alpha", 1, 2, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Railcraft.ID, "cart.anchor.personal", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                        getModItem(Railcraft.ID, "machine.alpha", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Railcraft.ID, "cart.anchor", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                        getModItem(Railcraft.ID, "machine.beta", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Railcraft.ID, "cart.tank", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Railcraft.ID, "cart.energy.batbox", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 7, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Railcraft.ID, "cart.energy.cesu", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Railcraft.ID, "cart.energy.mfe", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemToolMEter", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.circuit", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Railcraft.ID, "tool.electric.meter", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemFreq", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.circuit", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Railcraft.ID, "tool.signal.tuner", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Railcraft.ID, "tool.signal.tuner", 1, 0, missing),
                        getModItem(Minecraft.ID, "compass", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Railcraft.ID, "tool.surveyor", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "cube", 1, 8, missing))
                .itemOutputs(getModItem(Railcraft.ID, "slab", 4, 38, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "cube", 1, 8, missing))
                .itemOutputs(getModItem(Railcraft.ID, "slab", 4, 38, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "cube", 1, 8, missing))
                .itemOutputs(getModItem(Railcraft.ID, "slab", 4, 38, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(100).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "cube", 1, 0, missing))
                .itemOutputs(getModItem(Railcraft.ID, "fuel.coke", 9, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 0, 32314, missing))
                .itemOutputs(getModItem(Railcraft.ID, "anvil", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 4464)).noFluidOutputs().duration(480).eut(64)
                .addTo(sFluidSolidficationRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "clay_ball", 1, 0, missing),
                        getModItem(Minecraft.ID, "dye", 1, 15, missing),
                        getModItem(Minecraft.ID, "dye", 1, 15, missing),
                        getModItem(Minecraft.ID, "dye", 1, 15, missing))
                .itemOutputs(getModItem(Railcraft.ID, "part.bleached.clay", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 24500, missing),
                        getModItem(Railcraft.ID, "firestone.raw", 1, 0, missing))
                .itemOutputs(getModItem(Railcraft.ID, "firestone.cut", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(2400).eut(480).addTo(sLaserEngraverRecipes);

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
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23330, missing),
                'd',
                "dyeRed",
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23330, missing),
                'f',
                "dyeRed",
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23330, missing),
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
