package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AE2FluidCraft;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.BuildCraftTransport;
import static gregtech.api.enums.Mods.CarpentersBlocks;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.GalacticraftMars;
import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.enums.Mods.GraviSuite;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronChests;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.ProjectRedIllumination;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sArcFurnaceRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sBenderRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sBlastRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCannerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCompressorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sExtruderRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sFluidCannerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMaceratorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sPlasmaArcFurnaceRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.GT_Values;

public class ScriptGalacticraft implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Galacticraft";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                GalacticraftCore.ID,
                GalacticraftMars.ID,
                GalaxySpace.ID,
                AE2FluidCraft.ID,
                AppliedEnergistics2.ID,
                BuildCraftTransport.ID,
                CarpentersBlocks.ID,
                GraviSuite.ID,
                IndustrialCraft2.ID,
                IronChests.ID,
                PamsHarvestCraft.ID,
                ProjectRedIllumination.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.landingPad", 3, 0, missing),
                new Object[] { "compressedIron", "compressedIron", "compressedIron", "plateAlloyAdvanced",
                        "plateAlloyAdvanced", "plateAlloyAdvanced", "blockIron", "blockIron", "blockIron" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.landingPad", 3, 1, missing),
                new Object[] { "compressedSteel", "compressedSteel", "compressedSteel", "plateAlloyAdvanced",
                        "plateAlloyAdvanced", "plateAlloyAdvanced", "blockSteel", "blockSteel", "blockSteel" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.oxygenCollector", 1, 0, missing),
                new Object[] { "compressedAluminium",
                        getModItem(GalacticraftCore.ID, "item.oxygenConcentrator", 1, 0, missing),
                        "compressedAluminium", getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "item.airFan", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing), "compressedSteel",
                        "cableGt02Aluminium", "compressedSteel" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.oxygenCompressor", 1, 0, missing),
                new Object[] { "compressedAluminium",
                        getModItem(GalacticraftCore.ID, "item.oxygenConcentrator", 1, 0, missing),
                        "compressedAluminium", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32642, missing),
                        getModItem(GalacticraftCore.ID, "item.oilCanisterPartial", 1, 1001, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing), "compressedSteel",
                        "compressedBronze", "compressedSteel" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.oxygenCompressor", 1, 4, missing),
                new Object[] { "compressedAluminium",
                        getModItem(GalacticraftCore.ID, "item.oxygenConcentrator", 1, 0, missing),
                        "compressedAluminium", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing),
                        getModItem(GalacticraftCore.ID, "item.oilCanisterPartial", 1, 1001, missing),
                        getModItem(GalacticraftCore.ID, "item.airFan", 1, 0, missing), "compressedSteel",
                        "compressedBronze", "compressedSteel" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.machine2", 1, 8, missing),
                new Object[] { "compressedSteel",
                        getModItem(GalacticraftCore.ID, "item.oxygenTankUltraHeavyFull", 1, 3000, missing),
                        "compressedSteel",
                        getModItem(GalacticraftCore.ID, "item.oxygenTankUltraHeavyFull", 1, 3000, missing),
                        getModItem(GregTech.ID, "gt.blockcasings2", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "item.oxygenTankUltraHeavyFull", 1, 3000, missing),
                        "compressedSteel",
                        getModItem(GalacticraftCore.ID, "item.oxygenTankUltraHeavyFull", 1, 3000, missing),
                        "compressedSteel" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.distributor", 1, 0, missing),
                new Object[] { "compressedAluminium", getModItem(GalacticraftCore.ID, "item.airFan", 1, 0, missing),
                        "compressedAluminium", getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing),
                        getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing), "compressedSteel",
                        getModItem(GalacticraftCore.ID, "item.airFan", 1, 0, missing), "compressedSteel" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.sealer", 1, 0, missing),
                new Object[] { "compressedAluminium", getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing),
                        "compressedAluminium", getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "tile.distributor", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing), "compressedDesh",
                        getModItem(GalacticraftCore.ID, "tile.oxygenDetector", 1, 0, missing), "compressedDesh" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.oxygenDetector", 1, 0, missing),
                new Object[] { "compressedDesh", "compressedSteel", "compressedDesh",
                        getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing), "compressedAluminium",
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 2000, missing), "compressedAluminium" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.fuelLoader", 1, 0, missing),
                new Object[] { "compressedSteel", "waferBasic", "compressedSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32612, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32405, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing), "compressedAluminium",
                        "pipeMediumSteel", "compressedAluminium" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.cargo", 1, 0, missing),
                new Object[] { "compressedAluminium", getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                        "compressedAluminium", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 9233, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing), "compressedDesh",
                        "pipeMediumBrass", "compressedDesh" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.cargo", 1, 4, missing),
                new Object[] { "compressedDesh", "pipeMediumBrass", "compressedDesh",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 9233, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing), "compressedAluminium",
                        getModItem(Minecraft.ID, "hopper", 1, 0, missing), "compressedAluminium" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.gcBlockCore", 1, 4, missing),
                new Object[] { "craftingToolHardHammer", "compressedTin", null, "compressedTin", "stone",
                        "compressedTin", null, "compressedTin", "craftingToolWrench" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.gcBlockCore", 1, 3, missing),
                new Object[] { null, "compressedTin", "craftingToolHardHammer", "compressedTin", "stone",
                        "compressedTin", "craftingToolWrench", "compressedTin", null });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.airLockFrame", 2, 0, missing),
                new Object[] { "compressedDesh", "screwStainlessSteel", "compressedDesh",
                        getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing), "compressedAluminium",
                        "screwStainlessSteel", "compressedAluminium" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.airLockFrame", 1, 1, missing),
                new Object[] { "compressedDesh",
                        getModItem(GalacticraftCore.ID, "item.oxygenConcentrator", 1, 0, missing), "compressedDesh",
                        getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32740, missing),
                        getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing), "waferAdvanced",
                        "wireGt01RedAlloy", "waferAdvanced" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.enclosed", 1, 1, missing),
                new Object[] { "craftingToolHardHammer",
                        getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing), null,
                        getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "tile.gcBlockCore", 1, 4, missing),
                        getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing), null,
                        getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing), "craftingToolFile" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.enclosed", 1, 13, missing),
                new Object[] { "craftingToolHardHammer",
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 11, missing), null,
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 11, missing),
                        getModItem(GalacticraftCore.ID, "tile.gcBlockCore", 1, 4, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 11, missing), null,
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 11, missing), "craftingToolFile" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.enclosed", 1, 14, missing),
                new Object[] { "craftingToolHardHammer",
                        getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 0, missing), null,
                        getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "tile.gcBlockCore", 1, 4, missing),
                        getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 0, missing), null,
                        getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 0, missing), "craftingToolFile" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.enclosed", 1, 15, missing),
                new Object[] { "craftingToolHardHammer",
                        getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 1, missing), null,
                        getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 1, missing),
                        getModItem(GalacticraftCore.ID, "tile.gcBlockCore", 1, 4, missing),
                        getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 1, missing), null,
                        getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 1, missing), "craftingToolFile" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.enclosed", 1, 11, missing),
                new Object[] { "craftingToolHardHammer",
                        getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerstone", 1, 0, missing), null,
                        getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerstone", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "tile.gcBlockCore", 1, 4, missing),
                        getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerstone", 1, 0, missing), null,
                        getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerstone", 1, 0, missing),
                        "craftingToolFile" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.enclosed", 1, 12, missing),
                new Object[] { "craftingToolHardHammer",
                        getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowergold", 1, 0, missing), null,
                        getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowergold", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "tile.gcBlockCore", 1, 4, missing),
                        getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowergold", 1, 0, missing), null,
                        getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowergold", 1, 0, missing),
                        "craftingToolFile" });
        addShapelessCraftingRecipe(
                getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 0, missing),
                new Object[] { "cableGt01Aluminium" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.aluminumWire", 3, 1, missing),
                new Object[] { "compressedAluminium", "compressedAluminium", "compressedAluminium",
                        getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 0, missing), "compressedAluminium",
                        "compressedAluminium", "compressedAluminium" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.solar", 1, 0, missing),
                new Object[] { "compressedAluminium", getModItem(GalacticraftCore.ID, "item.basicItem", 1, 1, missing),
                        "compressedAluminium", getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "item.steelPole", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 0, missing), "compressedSteel",
                        "waferBasic", "compressedSteel" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.solar", 1, 4, missing),
                new Object[] { "compressedAluminium", getModItem(GalacticraftCore.ID, "item.basicItem", 1, 1, missing),
                        "compressedAluminium", getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 1, missing),
                        getModItem(GalacticraftCore.ID, "item.steelPole", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing), "waferAdvanced",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32690, missing) });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 1, missing),
                new Object[] { getModItem(GalacticraftCore.ID, "item.basicItem", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "item.basicItem", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "item.basicItem", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 0, missing), "waferBasic",
                        getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "item.basicItem", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "item.basicItem", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "item.basicItem", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.machineTiered", 1, 0, missing),
                new Object[] { "compressedSteel", getModItem(IndustrialCraft2.ID, "itemBatChargeRE", 1, 32767, missing),
                        "compressedSteel", "cableGt01AnyCopper",
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 12, missing), "cableGt01AnyCopper", "waferBasic",
                        getModItem(IndustrialCraft2.ID, "itemBatChargeRE", 1, 32767, missing), "waferBasic" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.machineTiered", 1, 8, missing),
                new Object[] { "compressedTitanium",
                        getModItem(IndustrialCraft2.ID, "itemBatChargeAdv", 1, 32767, missing), "compressedTitanium",
                        "cableGt02Gold", getModItem(GregTech.ID, "gt.blockmachines", 1, 13, missing), "cableGt02Gold",
                        "waferAdvanced", getModItem(IndustrialCraft2.ID, "itemBatChargeAdv", 1, 32767, missing),
                        "waferAdvanced" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.spinThruster", 1, 0, missing),
                new Object[] { "compressedTitanium", "compressedTitanium", "compressedTitanium",
                        getModItem(GalacticraftCore.ID, "item.fuelCanisterPartial", 1, 1, missing), "waferAdvanced",
                        getModItem(GalacticraftCore.ID, "item.fuelCanisterPartial", 1, 1, missing),
                        getModItem(GalacticraftCore.ID, "item.engine", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "item.heavyPlating", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "item.engine", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.viewScreen", 1, 0, missing),
                new Object[] { "compressedSteel", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32750, missing),
                        "compressedSteel", "waferBasic", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32740, missing),
                        "waferBasic", "compressedSteel", "compressedSteel", "compressedSteel" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.telemetry", 1, 0, missing),
                new Object[] { getModItem(GalacticraftCore.ID, "item.basicItem", 1, 19, missing), "compressedTin",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32682, missing), "waferBasic", "compressedTin",
                        "waferBasic", "compressedTin", "compressedCopper", "compressedTin" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.arclamp", 1, 0, missing),
                new Object[] { getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalaxySpace.ID, "ceresglowstone", 1, 0, missing),
                        getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1, 16, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing) });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.arclamp", 1, 0, missing),
                new Object[] { getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalaxySpace.ID, "ioglowstone", 1, 0, missing),
                        getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1, 16, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing) });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.arclamp", 1, 0, missing),
                new Object[] { getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalaxySpace.ID, "enceladusglowstone", 1, 0, missing),
                        getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1, 16, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing) });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.arclamp", 1, 0, missing),
                new Object[] { getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalaxySpace.ID, "proteusglowstone", 1, 0, missing),
                        getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1, 16, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing) });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.arclamp", 1, 0, missing),
                new Object[] { getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalaxySpace.ID, "plutoglowstone", 1, 0, missing),
                        getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1, 16, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing) });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.oxygenGear", 1, 0, missing),
                new Object[] { getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32612, missing),
                        getModItem(GalacticraftCore.ID, "item.oxygenConcentrator", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32612, missing),
                        getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing),
                        getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.oxygenTankLightFull", 1, 1000, missing),
                new Object[] { "compressedAluminium", getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing),
                        "compressedAluminium", "compressedAluminium", "cellEmpty", "compressedAluminium",
                        "compressedAluminium", "compressedAluminium", "compressedAluminium" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.oxygenTankLightFull", 1, 1000, missing),
                new Object[] { "compressedAluminium", getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing),
                        "compressedAluminium", "compressedAluminium",
                        getModItem(IndustrialCraft2.ID, "itemFluidCell", 1, 0, missing), "compressedAluminium",
                        "compressedAluminium", "compressedAluminium", "compressedAluminium" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.oxygenTankMedFull", 1, 2000, missing),
                new Object[] { getModItem(GalacticraftCore.ID, "item.meteoricIronIngot", 1, 1, missing),
                        getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "item.meteoricIronIngot", 1, 1, missing),
                        getModItem(GalacticraftCore.ID, "item.meteoricIronIngot", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32405, missing),
                        getModItem(GalacticraftCore.ID, "item.meteoricIronIngot", 1, 1, missing),
                        getModItem(GalacticraftCore.ID, "item.meteoricIronIngot", 1, 1, missing),
                        getModItem(GalacticraftCore.ID, "item.meteoricIronIngot", 1, 1, missing),
                        getModItem(GalacticraftCore.ID, "item.meteoricIronIngot", 1, 1, missing) });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.oxygenTankHeavyFull", 1, 3000, missing),
                new Object[] { getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32406, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing) });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.oxygenTankSuperHeavyFull", 1, 4000, missing),
                new Object[] { getModItem(NewHorizonsCoreMod.ID, "item.TitaniumDualCompressedPlates", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.TitaniumDualCompressedPlates", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.TitaniumDualCompressedPlates", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32411, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.TitaniumDualCompressedPlates", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.TitaniumDualCompressedPlates", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.TitaniumDualCompressedPlates", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.TitaniumDualCompressedPlates", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.oxygenTankUltraHeavyFull", 1, 5000, missing),
                new Object[] { "plateTripleTrinium", getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing),
                        "plateTripleTrinium", "plateTripleTrinium",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32412, missing), "plateTripleTrinium",
                        "plateTripleTrinium", "plateTripleTrinium", "plateTripleTrinium" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                new Object[] { "ringRedAlloy", "lensDiamond", "ringRedAlloy", "circuitAdvanced", "lensReinforcedGlass",
                        "circuitAdvanced", "screwStainlessSteel", "craftingToolScrewdriver", "screwStainlessSteel" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.sensorGlasses", 1, 0, missing),
                new Object[] { "circuitData", "screwMeteoricSteel", "circuitData", "ringDesh", "boltDesh", "ringDesh",
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.steel_pickaxe", 1, 0, missing),
                new Object[] { "compressedSteel", "compressedSteel", "compressedSteel", "craftingToolFile", "stickWood",
                        "craftingToolHardHammer", null, "stickWood", null });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.steel_axe", 1, 0, missing),
                new Object[] { "compressedSteel", "compressedSteel", "craftingToolHardHammer", "compressedSteel",
                        "stickWood", null, "craftingToolFile", "stickWood", null });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.steel_hoe", 1, 0, missing),
                new Object[] { "compressedSteel", "compressedSteel", "craftingToolHardHammer", "craftingToolFile",
                        "stickWood", null, null, "stickWood", null });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.steel_shovel", 1, 0, missing),
                new Object[] { "craftingToolFile", "compressedSteel", "craftingToolHardHammer", null, "stickWood", null,
                        null, "stickWood", null });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.steel_sword", 1, 0, missing),
                new Object[] { null, "compressedSteel", null, "craftingToolFile", "compressedSteel",
                        "craftingToolHardHammer", null, "stickWood", null });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.steel_helmet", 1, 0, missing),
                new Object[] { "compressedSteel", "compressedSteel", "compressedSteel", "compressedSteel",
                        "craftingToolHardHammer", "compressedSteel", null, null, null });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.steel_chestplate", 1, 0, missing),
                new Object[] { "compressedSteel", "craftingToolHardHammer", "compressedSteel", "compressedSteel",
                        "compressedSteel", "compressedSteel", "compressedSteel", "compressedSteel",
                        "compressedSteel" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.steel_leggings", 1, 0, missing),
                new Object[] { "compressedSteel", "compressedSteel", "compressedSteel", "compressedSteel",
                        "craftingToolHardHammer", "compressedSteel", "compressedSteel", null, "compressedSteel" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.steel_boots", 1, 0, missing),
                new Object[] { "compressedSteel", null, "compressedSteel", "compressedSteel", "craftingToolHardHammer",
                        "compressedSteel", null, null, null });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.deshHelmet", 1, 0, missing),
                new Object[] { getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing), "craftingToolHardHammer",
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing), null, null, null });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.deshChestplate", 1, 0, missing),
                new Object[] { getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing), "craftingToolHardHammer",
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing) });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.deshLeggings", 1, 0, missing),
                new Object[] { getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing), "craftingToolHardHammer",
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing), null,
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing) });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.deshBoots", 1, 0, missing),
                new Object[] { getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing), null,
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing), "craftingToolHardHammer",
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing), null, null, null });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.titanium_pickaxe", 1, 0, missing),
                new Object[] { "compressedTitanium", "compressedTitanium", "compressedTitanium", "craftingToolFile",
                        "stickWood", "craftingToolHardHammer", null, "stickWood", null });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.titanium_axe", 1, 0, missing),
                new Object[] { "compressedTitanium", "compressedTitanium", "craftingToolHardHammer",
                        "compressedTitanium", "stickWood", null, "craftingToolFile", "stickWood", null });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.titanium_hoe", 1, 0, missing),
                new Object[] { "compressedTitanium", "compressedTitanium", "craftingToolHardHammer", "craftingToolFile",
                        "stickWood", null, null, "stickWood", null });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.titanium_shovel", 1, 0, missing),
                new Object[] { "craftingToolFile", "compressedTitanium", "craftingToolHardHammer", null, "stickWood",
                        null, null, "stickWood", null });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.titanium_sword", 1, 0, missing),
                new Object[] { null, "compressedTitanium", null, "craftingToolFile", "compressedTitanium",
                        "craftingToolHardHammer", null, "stickWood", null });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.deshPick", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 30502, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing), "craftingToolFile", "stickDesh",
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing), null, "stickDesh",
                        "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.deshAxe", 1, 0, missing),
                new Object[] { getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 30502, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing), "stickDesh",
                        "craftingToolHardHammer", "craftingToolFile", "stickDesh", null });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.deshHoe", 1, 0, missing),
                new Object[] { getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 30502, missing), "craftingToolFile", "stickDesh",
                        "craftingToolHardHammer", null, "stickDesh", null });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.deshSpade", 1, 0, missing),
                new Object[] { "craftingToolFile", getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 30502, missing), null, "stickDesh",
                        "craftingToolHardHammer", null, "stickDesh", null });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.deshSword", 1, 0, missing),
                new Object[] { null, getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 30502, missing), "craftingToolFile",
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing), "craftingToolHardHammer", null,
                        "stickDesh", null });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.titanium_helmet", 1, 0, missing),
                new Object[] { "compressedTitanium", "compressedTitanium", "compressedTitanium", "compressedTitanium",
                        "craftingToolHardHammer", "compressedTitanium", null, null, null });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.titanium_chestplate", 1, 0, missing),
                new Object[] { "compressedTitanium", "craftingToolHardHammer", "compressedTitanium",
                        "compressedTitanium", "compressedTitanium", "compressedTitanium", "compressedTitanium",
                        "compressedTitanium", "compressedTitanium" });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.titanium_leggings", 1, 0, missing),
                new Object[] { "compressedTitanium", "compressedTitanium", "compressedTitanium", "compressedTitanium",
                        "craftingToolHardHammer", "compressedTitanium", "compressedTitanium", null,
                        "compressedTitanium" });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.titanium_boots", 1, 0, missing),
                new Object[] { "compressedTitanium", null, "compressedTitanium", "compressedTitanium",
                        "craftingToolHardHammer", "compressedTitanium", null, null, null });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "iron_bars", 1, 0, missing), "compressedTin",
                        getModItem(Minecraft.ID, "iron_bars", 1, 0, missing), "compressedTin", "compressedSteel",
                        "compressedTin", getModItem(Minecraft.ID, "iron_bars", 1, 0, missing), "compressedTin",
                        getModItem(Minecraft.ID, "iron_bars", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.airFan", 1, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 21305, missing), "stickLongStainlessSteel",
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 21305, missing), "screwSteel",
                        "craftingToolWrench", "screwSteel" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.oxygenConcentrator", 1, 0, missing),
                new Object[] { "compressedSteel", getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing),
                        "compressedSteel", "compressedSteel",
                        getModItem(GalacticraftCore.ID, "item.airFan", 1, 0, missing), "compressedSteel",
                        getModItem(GalacticraftCore.ID, "item.canister", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32612, missing),
                        getModItem(GalacticraftCore.ID, "item.canister", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.oilExtractor", 1, 0, missing),
                new Object[] { "pipeTinySteel", "craftingToolScrewdriver", "screwStainlessSteel", "screwStainlessSteel",
                        getModItem(GalacticraftCore.ID, "item.oilCanisterPartial", 1, 1001, missing),
                        "compressedBronze",
                        getModItem(ProjectRedIllumination.ID, "projectred.illumination.lightbutton", 1, 14, missing),
                        "compressedBronze", "compressedBronze" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.buggymat", 1, 0, missing),
                new Object[] { "compressedSteel", "plateAnyRubber", "compressedSteel", "plateAnyRubber",
                        "compressedTitanium", "plateAnyRubber", "compressedSteel", "plateAnyRubber",
                        "compressedSteel" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.buggymat", 1, 1, missing),
                new Object[] { null, getModItem(IndustrialCraft2.ID, "blockRubber", 1, 0, missing), "compressedSteel",
                        getModItem(IndustrialCraft2.ID, "blockRubber", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "blockRubber", 1, 0, missing), "compressedSteel",
                        "compressedSteel", "compressedSteel", "compressedSteel" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.buggymat", 1, 2, missing),
                new Object[] { "compressedSteel", getModItem(IndustrialCraft2.ID, "blockRubber", 1, 0, missing),
                        "compressedSteel", "compressedSteel",
                        getModItem(IronChests.ID, "BlockIronChest", 1, 0, missing), "compressedSteel",
                        "compressedSteel", "compressedSteel", "compressedSteel" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 19, missing),
                new Object[] { "compressedAluminium", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        "compressedAluminium", "waferBasic",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32740, missing), "waferBasic", "compressedTin",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32500, missing), "compressedTin" });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "tile.walkway", 2, 0, missing),
                new Object[] { getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing), null, "blockDesh", null,
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing) });
        addShapelessCraftingRecipe(
                getModItem(GalacticraftMars.ID, "item.null", 1, 1, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 23884, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23884, missing),
                new Object[] { getModItem(GalacticraftMars.ID, "item.null", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem(GalacticraftCore.ID, "item.battery", 1, 32767, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32500, missing) });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.standardWrench", 1, 0, missing),
                new Object[] { "plateSteel", "craftingToolSaw", "plateSteel", "screwSteel", "stickSteel", "screwSteel",
                        "craftingToolScrewdriver", "stickSteel", "craftingToolFile" });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 8, missing),
                new Object[] { "ringRedAlloy", "compressedIron", "ringRedAlloy", "compressedIron", "lensDiamond",
                        "compressedIron", "ringRedAlloy", "compressedIron", "ringRedAlloy" });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.null", 1, 6, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32612, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5135, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32612, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5135, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32405, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5135, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32612, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5135, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32612, missing) });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "tile.beamReflector", 1, 0, missing),
                new Object[] { "ringDesh", getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 8, missing),
                        "ringDesh", "screwDesh", "stickDesh", "screwDesh",
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing), "blockDesh",
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing) });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "tile.beamReceiver", 1, 0, missing),
                new Object[] { "compressedTin", "ringDesh", "compressedTin", "ringDesh",
                        getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 8, missing), "ringDesh",
                        "compressedTin", "ringDesh", "compressedTin" });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "tile.telepadShort", 1, 0, missing),
                new Object[] { "compressedTitanium", getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        "compressedTitanium", getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32672, missing),
                        getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 8, missing), "compressedTitanium",
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing), "compressedTitanium" });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "tile.marsMachine", 1, 4, missing),
                new Object[] { getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 0, missing),
                        getModItem(GraviSuite.ID, "itemSimpleItem", 1, 2, missing),
                        getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 0, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 3, missing),
                        getModItem(CarpentersBlocks.ID, "itemCarpentersBed", 1, 0, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 3, missing),
                        getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 0, missing),
                        getModItem(Minecraft.ID, "clock", 1, 0, missing),
                        getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "tile.marsMachine", 1, 0, missing),
                new Object[] { "compressedTitanium",
                        getModItem(GalacticraftCore.ID, "item.oxygenConcentrator", 1, 0, missing), "compressedTitanium",
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.blockcasings2", 1, 4, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing),
                        getModItem(AE2FluidCraft.ID, "certus_quartz_tank", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32612, missing) });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "tile.marsMachine", 1, 8, missing),
                new Object[] { "waferAdvanced", getModItem(GalacticraftCore.ID, "item.basicItem", 1, 19, missing),
                        "waferAdvanced", getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 13, missing),
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing), "cableGt02Aluminium",
                        getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing), "cableGt02Aluminium" });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.grapple", 1, 0, missing),
                new Object[] { null, null, "toolHeadArrowMeteoricSteel",
                        getModItem(NewHorizonsCoreMod.ID, "item.MeteoricIronString", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.MeteoricIronString", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.MeteoricIronString", 1, 0, missing),
                        "ringMeteoricSteel", null, null });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "tile.minerBase", 4, 0, missing),
                new Object[] { "compressedTitanium", "chestSteel", "compressedTitanium",
                        getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 8, missing), "frameGtTungsten",
                        getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 8, missing), "compressedDesh",
                        getModItem(GalacticraftCore.ID, "tile.machineTiered", 1, 0, missing), "compressedDesh" });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.orionDrive", 1, 0, missing),
                new Object[] { "compressedTitanium",
                        getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 8, missing), "compressedTitanium",
                        "circuitMaster", "oc:hdd3", "circuitMaster", "compressedSteel",
                        getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 8, missing), "compressedSteel" });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.canvas", 1, 0, missing),
                new Object[] { null, getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing), "stickPlastic",
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing), "stickPlastic",
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing), "stickPlastic",
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 20, missing),
                new Object[] { "circuitAdvanced", getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing),
                        "circuitAdvanced", getModItem(GalacticraftCore.ID, "item.basicItem", 1, 10, missing),
                        getModItem(GalacticraftCore.ID, "item.basicItem", 1, 9, missing),
                        getModItem(GalacticraftCore.ID, "item.basicItem", 1, 10, missing),
                        getModItem(GalacticraftCore.ID, "item.basicItem", 1, 8, missing),
                        getModItem(GalacticraftCore.ID, "item.basicItem", 1, 13, missing),
                        getModItem(GalacticraftCore.ID, "item.basicItem", 1, 8, missing) });
        addShapelessCraftingRecipe(
                getModItem(GalacticraftCore.ID, "item.schematic", 1, 0, missing),
                new Object[] { getModItem(GalacticraftCore.ID, "item.schematic", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem(GalacticraftCore.ID, "item.schematic", 1, 1, missing),
                new Object[] { getModItem(GalacticraftCore.ID, "item.schematic", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.schematic", 1, 1, missing),
                new Object[] { getModItem(GalacticraftMars.ID, "item.schematic", 1, 0, missing), null, null, null, null,
                        null, null, null, null });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.schematic", 1, 2, missing),
                new Object[] { null, getModItem(GalacticraftMars.ID, "item.schematic", 1, 0, missing), null, null, null,
                        null, null, null, null });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.schematic", 1, 0, missing),
                new Object[] { getModItem(GalacticraftMars.ID, "item.schematic", 1, 1, missing), null, null, null, null,
                        null, null, null, null });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.schematic", 1, 2, missing),
                new Object[] { null, getModItem(GalacticraftMars.ID, "item.schematic", 1, 1, missing), null, null, null,
                        null, null, null, null });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.schematic", 1, 0, missing),
                new Object[] { getModItem(GalacticraftMars.ID, "item.schematic", 1, 2, missing), null, null, null, null,
                        null, null, null, null });
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.schematic", 1, 1, missing),
                new Object[] { null, getModItem(GalacticraftMars.ID, "item.schematic", 1, 2, missing), null, null, null,
                        null, null, null, null });
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.parachute", 1, 0, missing),
                new Object[] { getModItem(GalacticraftCore.ID, "item.canvas", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "item.canvas", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "item.canvas", 1, 0, missing), "wireFineSteel", null,
                        "wireFineSteel", "wireFineSteel", "wireFineSteel", "wireFineSteel" });
        addShapelessCraftingRecipe(
                getModItem(GalacticraftCore.ID, "item.meteoricIronRaw", 1, 0, missing),
                new Object[] { getModItem(GalacticraftCore.ID, "item.meteoricIronRaw", 1, 32767, missing) });
        addShapelessCraftingRecipe(
                getModItem(GalacticraftCore.ID, "item.spaceship", 1, 0, missing),
                new Object[] { getModItem(GalacticraftCore.ID, "item.spaceship", 1, 32767, missing) });
        addShapelessCraftingRecipe(
                getModItem(GalacticraftCore.ID, "item.buggy", 1, 0, missing),
                new Object[] { getModItem(GalacticraftCore.ID, "item.buggy", 1, 32767, missing) });
        addShapelessCraftingRecipe(
                getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 0, missing),
                new Object[] { getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 0, missing),
                new Object[] { getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 0, missing),
                new Object[] { getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 3, missing) });
        addShapelessCraftingRecipe(
                getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, 0, missing),
                new Object[] { getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, 32767, missing) });
        addShapelessCraftingRecipe(
                getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 11, missing),
                new Object[] { getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 12, missing) });
        addShapelessCraftingRecipe(
                getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 11, missing),
                new Object[] { getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 13, missing) });

        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(GalacticraftCore.ID, "item.infiniteOxygen", 1, 0, missing),
                "--abbba--",
                "-abcccba-",
                "-bcdedcb-",
                "-bcfgfcb-",
                "-bcdhdcb-",
                "-bcfgfcb-",
                "-bcdedcb-",
                "-abcccba-",
                "--abbba--",
                'a',
                "ingotInfinity",
                'b',
                "plateNeutronium",
                'c',
                getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyPlateTier8", 1, 0, missing),
                'd',
                getModItem(GalacticraftCore.ID, "item.oxygenTankUltraHeavyFull", 1, 0, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32616, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 32105, missing),
                'g',
                "pipeSmallInfinity",
                'h',
                getModItem(GregTech.ID, "gt.blockmachines", 1, 122, missing));

        GT_Values.RA.addFuel(
                createItemStack(
                        IndustrialCraft2.ID,
                        "itemFluidCell",
                        1,
                        0,
                        "{Fluid:{FluidName:\"oil\",Amount:1000}}",
                        missing),
                getModItem(IndustrialCraft2.ID, "itemFluidCell", 1, 0, missing),
                16,
                0);
        GT_Values.RA.addFuel(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 30707, missing),
                getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 0, missing),
                16,
                0);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 9, 11340, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "tile.gcBlockCore", 1, 12, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.cheeseCurd", 9, 0, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "tile.moonBlock", 1, 2, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);

        arcFurnaceRecipes();
        assemblerRecipes();
        blastFurnaceRecipes();
        cannerRecipes();
        extruderRecipes();
        fluidCannerRecipes();
        maceratorRecipes();
        plasmaArcFurnaceRecipes();
        benderRecipes();
    }

    private void arcFurnaceRecipes() {
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.spaceship", 1, 0, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 20, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 11305, missing))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 2000))
                .noFluidOutputs().duration(1200).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.spaceship", 1, 1, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 20, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 11305, missing))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 2000))
                .noFluidOutputs().duration(1200).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.spaceship", 1, 2, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 20, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 11305, missing))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 2000))
                .noFluidOutputs().duration(1200).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.spaceship", 1, 3, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 20, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 11305, missing))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 2000))
                .noFluidOutputs().duration(1200).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 0, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 10, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 41, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 11305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 4000))
                .noFluidOutputs().duration(2400).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 1, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 10, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 41, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 11305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 4000))
                .noFluidOutputs().duration(2400).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 2, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 10, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 41, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 11305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 4000))
                .noFluidOutputs().duration(2400).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 3, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 10, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 41, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 11305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 4000))
                .noFluidOutputs().duration(2400).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 37, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 11, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 32, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 12, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 6000))
                .noFluidOutputs().duration(3600).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 37, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 11, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 32, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 12, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 6000))
                .noFluidOutputs().duration(3600).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 37, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 11, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 32, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 12, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 6000))
                .noFluidOutputs().duration(3600).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 37, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 11, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 32, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 12, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 6000))
                .noFluidOutputs().duration(3600).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier4Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 12, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 40, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 52, 32462, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 8000))
                .noFluidOutputs().duration(4800).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier4Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 12, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 40, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 52, 32462, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 8000))
                .noFluidOutputs().duration(4800).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier4Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 12, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 40, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 52, 32462, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 8000))
                .noFluidOutputs().duration(4800).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier4Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 12, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 40, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 52, 32462, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 8000))
                .noFluidOutputs().duration(4800).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier5Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 14, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 10000))
                .noFluidOutputs().duration(6000).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier5Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 14, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 10000))
                .noFluidOutputs().duration(6000).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier5Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 14, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 10000))
                .noFluidOutputs().duration(6000).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier5Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 14, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 10000))
                .noFluidOutputs().duration(6000).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier6Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 12, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 62, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 16, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 12000))
                .noFluidOutputs().duration(7200).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier6Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 12, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 62, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 16, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 12000))
                .noFluidOutputs().duration(7200).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier6Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 12, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 62, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 16, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 12000))
                .noFluidOutputs().duration(7200).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier6Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 12, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 62, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 16, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 12000))
                .noFluidOutputs().duration(7200).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier7Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 18, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 50, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 14000))
                .noFluidOutputs().duration(8400).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier7Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 18, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 50, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 14000))
                .noFluidOutputs().duration(8400).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier7Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 18, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 50, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 14000))
                .noFluidOutputs().duration(8400).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier7Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 18, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 50, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 14000))
                .noFluidOutputs().duration(8400).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier8Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT8", 18, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 53, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 20, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 16000))
                .noFluidOutputs().duration(9600).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier8Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT8", 18, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 53, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 20, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 16000))
                .noFluidOutputs().duration(9600).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier8Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT8", 18, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 53, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 20, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 16000))
                .noFluidOutputs().duration(9600).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier8Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT8", 18, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 53, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 20, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 16000))
                .noFluidOutputs().duration(9600).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 11, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 24, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 40, 11305, missing),
                        getModItem(Minecraft.ID, "diamond", 4, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 4000))
                .noFluidOutputs().duration(2400).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 12, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 24, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 40, 11305, missing),
                        getModItem(Minecraft.ID, "diamond", 4, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 4000))
                .noFluidOutputs().duration(2400).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 13, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 24, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 40, 11305, missing),
                        getModItem(Minecraft.ID, "diamond", 4, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 4000))
                .noFluidOutputs().duration(2400).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemAstroMiner", 1, 0, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 3, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 3, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 10, 11028, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 6000))
                .noFluidOutputs().duration(3600).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.buggy", 1, 0, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 11, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 5, 11340, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 21, 11305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 11306, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 6000))
                .noFluidOutputs().duration(1200).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.buggy", 1, 1, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 11, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 5, 11340, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 28, 11305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 11306, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 6000))
                .noFluidOutputs().duration(1200).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.buggy", 1, 2, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 11, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 5, 11340, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 35, 11305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 11306, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 6000))
                .noFluidOutputs().duration(1200).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.buggy", 1, 3, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 11, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 5, 11340, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 42, 11305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 11306, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 6000))
                .noFluidOutputs().duration(1200).eut(30).addTo(sArcFurnaceRecipes);
    }

    private void assemblerRecipes() {
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 29019, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.MeteoricIronString", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.silicone", 144)).noFluidOutputs().duration(300)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23010, missing),
                        getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "tile.glowstoneTorch", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "item.basicItem", 4, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 28305, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.oilCanisterPartial", 1, 1001, missing))
                .noFluidInputs().noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 28035, missing))
                .itemOutputs(getModItem(GalacticraftMars.ID, "tile.hydrogenPipe", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 5, 7, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.MeteoricIronString", 5, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem(GalacticraftMars.ID, "item.thermalPadding", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.silicone", 720)).noFluidOutputs().duration(750)
                .eut(1024).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftMars.ID, "item.thermalPadding", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 5, 7, missing)).noFluidInputs()
                .noFluidOutputs().duration(180).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 8, 7, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.MeteoricIronString", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem(GalacticraftMars.ID, "item.thermalPadding", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.silicone", 1152)).noFluidOutputs().duration(1200)
                .eut(1024).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftMars.ID, "item.thermalPadding", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 8, 7, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 7, 7, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.MeteoricIronString", 7, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 7, missing))
                .itemOutputs(getModItem(GalacticraftMars.ID, "item.thermalPadding", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.silicone", 1008)).noFluidOutputs().duration(1050)
                .eut(1024).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftMars.ID, "item.thermalPadding", 1, 2, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 7, 7, missing)).noFluidInputs()
                .noFluidOutputs().duration(260).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 4, 7, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.MeteoricIronString", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem(GalacticraftMars.ID, "item.thermalPadding", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.silicone", 576)).noFluidOutputs().duration(600)
                .eut(1024).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftMars.ID, "item.thermalPadding", 1, 3, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 4, 7, missing)).noFluidInputs()
                .noFluidOutputs().duration(150).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemArmorHazmatHelmet", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.ReinforcedGlassPlate", 16, 0, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.oxygenMask", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 144)).noFluidOutputs().duration(400).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemArmorHazmatHelmet", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.ReinforcedGlassPlate", 16, 0, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.oxygenMask", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 144)).noFluidOutputs().duration(400).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemArmorHazmatHelmet", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.ReinforcedGlassPlate", 16, 0, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.oxygenMask", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 72)).noFluidOutputs().duration(400).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32750, missing),
                        getModItem(GalacticraftCore.ID, "item.basicItem", 1, 9, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.basicItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23874, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.canvas", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "item.canvas", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 3, 19305, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.parachute", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(480).addTo(sAssemblerRecipes);
    }

    private void blastFurnaceRecipes() {
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 2, 4, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 11028, missing)).noFluidInputs()
                .noFluidOutputs().duration(1500).eut(120).specialValue(1500).addTo(sBlastRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.meteoricIronRaw", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 11340, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).specialValue(1000).addTo(sBlastRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "tile.fallenMeteor", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 2, 11340, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).specialValue(1000).addTo(sBlastRecipes);
    }

    private void cannerRecipes() {
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "apple", 6, 0, missing),
                        getModItem(GalacticraftCore.ID, "item.canister", 1, 0, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.basicItem", 1, 15, missing)).noFluidInputs()
                .noFluidOutputs().duration(800).eut(1).addTo(sCannerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carrot", 8, 0, missing),
                        getModItem(GalacticraftCore.ID, "item.canister", 1, 0, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.basicItem", 1, 16, missing)).noFluidInputs()
                .noFluidOutputs().duration(800).eut(1).addTo(sCannerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "melon", 8, 0, missing),
                        getModItem(GalacticraftCore.ID, "item.canister", 1, 0, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.basicItem", 1, 17, missing)).noFluidInputs()
                .noFluidOutputs().duration(800).eut(1).addTo(sCannerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "potato", 16, 0, missing),
                        getModItem(GalacticraftCore.ID, "item.canister", 1, 0, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.basicItem", 1, 18, missing)).noFluidInputs()
                .noFluidOutputs().duration(800).eut(1).addTo(sCannerRecipes);
    }

    private void extruderRecipes() {
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockAlloyGlass", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32359, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(120).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "item.basicItem", 1, 7, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32354, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.canister", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(120).eut(30).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "item.basicItem", 1, 6, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32354, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.canister", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(120).eut(30).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "item.basicItem", 2, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32352, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.steelPole", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sExtruderRecipes);
    }

    private void fluidCannerRecipes() {
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(GalacticraftCore.ID, "item.fuelCanisterPartial", 1, 1001, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.fuelCanisterPartial", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("fuel", 1000)).noFluidOutputs().duration(16).eut(1)
                .addTo(sFluidCannerRecipes);
    }

    private void maceratorRecipes() {
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "tile.gcBlockCore", 1, 12, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 9, 2340, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.null", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2884, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "tile.mars", 1, 2, missing))
                .itemOutputs(getModItem(GalacticraftMars.ID, "item.null", 2, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "tile.fallenMeteor", 1, 0, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.meteoricIronRaw", 2, 0, missing))
                .outputChances(10000).noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "tile.asteroidsBlock", 1, 4, missing))
                .itemOutputs(getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 2, 4, missing))
                .outputChances(10000).noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.basicItem", 1, 2, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2020, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
    }

    private void plasmaArcFurnaceRecipes() {
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.spaceship", 1, 0, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 20, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 11305, missing))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 8)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.spaceship", 1, 0, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 20, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 11305, missing))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 3))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 3)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.spaceship", 1, 1, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 20, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 11305, missing))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 8)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.spaceship", 1, 1, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 20, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 11305, missing))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 3))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 3)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.spaceship", 1, 2, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 20, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 11305, missing))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 8)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.spaceship", 1, 2, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 20, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 11305, missing))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 3))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 3)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.spaceship", 1, 3, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 20, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 11305, missing))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 8)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.spaceship", 1, 3, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 20, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 11305, missing))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 3))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 3)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 0, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 10, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 41, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 11305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 17)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 0, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 10, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 41, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 11305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 6))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 6)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 1, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 10, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 41, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 11305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 17)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 1, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 10, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 41, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 11305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 6))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 6)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 2, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 10, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 41, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 11305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 17)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 2, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 10, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 41, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 11305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 6))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 6)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 3, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 10, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 41, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 11305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 17)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 3, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 10, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 41, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 11305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 6))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 6)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 37, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 11, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 32, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 12, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 26))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 26)).duration(200).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 37, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 11, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 32, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 12, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 8)).duration(200).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 37, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 11, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 32, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 12, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 26))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 26)).duration(200).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 37, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 11, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 32, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 12, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 8)).duration(200).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 37, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 11, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 32, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 12, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 26))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 26)).duration(200).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 37, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 11, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 32, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 12, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 8)).duration(200).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 37, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 11, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 32, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 12, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 26))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 26)).duration(200).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 37, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 11, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 32, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 12, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 8)).duration(200).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier4Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 12, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 40, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 52, 32462, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 35))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 35)).duration(266).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier4Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 12, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 40, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 52, 32462, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 11))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 11)).duration(266).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier4Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 12, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 40, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 52, 32462, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 35))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 35)).duration(266).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier4Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 12, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 40, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 52, 32462, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 11))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 11)).duration(266).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier4Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 12, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 40, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 52, 32462, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 35))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 35)).duration(266).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier4Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 12, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 40, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 52, 32462, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 11))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 11)).duration(266).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier4Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 12, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 40, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 52, 32462, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 35))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 35)).duration(266).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier4Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 12, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 40, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 16, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 52, 32462, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 11))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 11)).duration(266).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier5Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 14, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 43))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 43)).duration(333).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier5Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 14, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 14))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 14)).duration(333).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier5Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 14, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 43))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 43)).duration(333).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier5Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 14, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 14))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 14)).duration(333).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier5Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 14, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 43))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 43)).duration(333).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier5Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 14, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 14))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 14)).duration(333).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier5Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 14, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 43))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 43)).duration(333).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier5Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 14, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 14))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 14)).duration(333).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier6Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 12, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 62, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 16, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 52))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 52)).duration(400).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier6Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 12, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 62, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 16, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 17)).duration(400).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier6Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 12, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 62, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 16, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 52))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 52)).duration(400).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier6Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 12, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 62, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 16, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 17)).duration(400).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier6Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 12, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 62, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 16, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 52))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 52)).duration(400).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier6Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 12, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 62, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 16, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 17)).duration(400).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier6Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 12, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 62, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 16, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 52))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 52)).duration(400).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier6Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 12, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 62, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT4", 16, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 64, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 17)).duration(400).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier7Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 18, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 50, 0, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 61))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 61)).duration(466).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier7Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 18, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 50, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 19))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 19)).duration(466).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier7Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 18, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 50, 0, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 61))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 61)).duration(466).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier7Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 18, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 50, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 19))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 19)).duration(466).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier7Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 18, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 50, 0, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 61))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 61)).duration(466).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier7Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 18, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 50, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 19))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 19)).duration(466).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier7Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 18, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 50, 0, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 61))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 61)).duration(466).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier7Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 18, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT5", 50, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 19))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 19)).duration(466).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier8Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT8", 18, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 53, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 20, 0, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 70))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 70)).duration(533).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier8Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT8", 18, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 53, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 20, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 22))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 22)).duration(533).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier8Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT8", 18, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 53, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 20, 0, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 70))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 70)).duration(533).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier8Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT8", 18, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 53, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 20, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 22))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 22)).duration(533).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier8Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT8", 18, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 53, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 20, 0, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 70))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 70)).duration(533).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier8Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT8", 18, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 53, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 20, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 22))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 22)).duration(533).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier8Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT8", 18, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 53, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 20, 0, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 70))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 70)).duration(533).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier8Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT8", 18, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT7", 53, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.HeavyDutyAlloyIngotT6", 20, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 22))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 22)).duration(533).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 11, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 24, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 40, 11305, missing),
                        getModItem(Minecraft.ID, "diamond", 4, 0, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 17)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 11, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 24, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 40, 11305, missing),
                        getModItem(Minecraft.ID, "diamond", 4, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 6))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 6)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 12, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 24, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 40, 11305, missing),
                        getModItem(Minecraft.ID, "diamond", 4, 0, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 17)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 12, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 24, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 40, 11305, missing),
                        getModItem(Minecraft.ID, "diamond", 4, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 6))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 6)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 13, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 24, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 40, 11305, missing),
                        getModItem(Minecraft.ID, "diamond", 4, 0, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 17)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 13, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 24, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 40, 11305, missing),
                        getModItem(Minecraft.ID, "diamond", 4, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 6))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 6)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemAstroMiner", 1, 0, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 3, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 3, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 10, 11028, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 26))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 26)).duration(200).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemAstroMiner", 1, 0, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 3, 32464, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 32463, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 3, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 10, 11028, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 8)).duration(200).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.buggy", 1, 0, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 11, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 5, 11340, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 21, 11305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 11306, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 8)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.buggy", 1, 0, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 11, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 5, 11340, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 21, 11305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 11306, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 3))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 3)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.buggy", 1, 1, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 11, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 5, 11340, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 28, 11305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 11306, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 8)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.buggy", 1, 1, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 11, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 5, 11340, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 28, 11305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 11306, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 3))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 3)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.buggy", 1, 2, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 11, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 5, 11340, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 35, 11305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 11306, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 8)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.buggy", 1, 2, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 11, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 5, 11340, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 35, 11305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 11306, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 3))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 3)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.buggy", 1, 3, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 11, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 5, 11340, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 42, 11305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 11306, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 8)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.buggy", 1, 3, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 11, 32462, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 5, 11340, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 42, 11305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 11306, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 3))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 3)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);

    }

    private void benderRecipes() {
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.basicItem", 2, 7, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.canister", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(8).addTo(sBenderRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.basicItem", 2, 6, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.canister", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(8).addTo(sBenderRecipes);
    }
}
