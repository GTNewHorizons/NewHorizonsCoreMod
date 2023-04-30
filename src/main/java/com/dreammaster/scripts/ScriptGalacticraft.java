package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.*;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;

public class ScriptGalacticraft implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Galacticraft";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.GalacticraftCore.ID, Mods.GalacticraftMars.ID, Mods.GalaxySpace.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.landingPad", 3, 0, missing),
                new Object[] { "compressedIron", "compressedIron", "compressedIron", "plateAlloyAdvanced",
                        "plateAlloyAdvanced", "plateAlloyAdvanced", "blockIron", "blockIron", "blockIron" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.landingPad", 3, 1, missing),
                new Object[] { "compressedSteel", "compressedSteel", "compressedSteel", "plateAlloyAdvanced",
                        "plateAlloyAdvanced", "plateAlloyAdvanced", "blockSteel", "blockSteel", "blockSteel" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.oxygenCollector", 1, 0, missing),
                new Object[] { "compressedAluminium",
                        getModItem("GalacticraftCore", "item.oxygenConcentrator", 1, 0, missing), "compressedAluminium",
                        getModItem("GalacticraftCore", "item.airVent", 1, 0, missing),
                        getModItem("GalacticraftCore", "item.airFan", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing), "compressedSteel",
                        "cableGt02Aluminium", "compressedSteel" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.oxygenCompressor", 1, 0, missing),
                new Object[] { "compressedAluminium",
                        getModItem("GalacticraftCore", "item.oxygenConcentrator", 1, 0, missing), "compressedAluminium",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32642, missing),
                        getModItem("GalacticraftCore", "item.oilCanisterPartial", 1, 1001, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing), "compressedSteel",
                        "compressedBronze", "compressedSteel" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.oxygenCompressor", 1, 4, missing),
                new Object[] { "compressedAluminium",
                        getModItem("GalacticraftCore", "item.oxygenConcentrator", 1, 0, missing), "compressedAluminium",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing),
                        getModItem("GalacticraftCore", "item.oilCanisterPartial", 1, 1001, missing),
                        getModItem("GalacticraftCore", "item.airFan", 1, 0, missing), "compressedSteel",
                        "compressedBronze", "compressedSteel" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.machine2", 1, 8, missing),
                new Object[] { "compressedSteel",
                        getModItem("GalacticraftCore", "item.oxygenTankUltraHeavyFull", 1, 3000, missing),
                        "compressedSteel",
                        getModItem("GalacticraftCore", "item.oxygenTankUltraHeavyFull", 1, 3000, missing),
                        getModItem("gregtech", "gt.blockcasings2", 1, 0, missing),
                        getModItem("GalacticraftCore", "item.oxygenTankUltraHeavyFull", 1, 3000, missing),
                        "compressedSteel",
                        getModItem("GalacticraftCore", "item.oxygenTankUltraHeavyFull", 1, 3000, missing),
                        "compressedSteel" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.distributor", 1, 0, missing),
                new Object[] { "compressedAluminium", getModItem("GalacticraftCore", "item.airFan", 1, 0, missing),
                        "compressedAluminium", getModItem("GalacticraftCore", "item.airVent", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing),
                        getModItem("GalacticraftCore", "item.airVent", 1, 0, missing), "compressedSteel",
                        getModItem("GalacticraftCore", "item.airFan", 1, 0, missing), "compressedSteel" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.sealer", 1, 0, missing),
                new Object[] { "compressedAluminium", getModItem("GalacticraftCore", "item.airVent", 1, 0, missing),
                        "compressedAluminium", getModItem("GalacticraftCore", "item.airVent", 1, 0, missing),
                        getModItem("GalacticraftCore", "tile.distributor", 1, 0, missing),
                        getModItem("GalacticraftCore", "item.airVent", 1, 0, missing), "compressedDesh",
                        getModItem("GalacticraftCore", "tile.oxygenDetector", 1, 0, missing), "compressedDesh" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.oxygenDetector", 1, 0, missing),
                new Object[] { "compressedDesh", "compressedSteel", "compressedDesh",
                        getModItem("GalacticraftCore", "item.airVent", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("GalacticraftCore", "item.airVent", 1, 0, missing), "compressedAluminium",
                        getModItem("gregtech", "gt.blockmachines", 1, 2000, missing), "compressedAluminium" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.fuelLoader", 1, 0, missing),
                new Object[] { "compressedSteel", "waferBasic", "compressedSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32612, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32405, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing), "compressedAluminium",
                        "pipeMediumSteel", "compressedAluminium" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.cargo", 1, 0, missing),
                new Object[] { "compressedAluminium", getModItem("minecraft", "hopper", 1, 0, missing),
                        "compressedAluminium", getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 9233, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing), "compressedDesh",
                        "pipeMediumBrass", "compressedDesh" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.cargo", 1, 4, missing),
                new Object[] { "compressedDesh", "pipeMediumBrass", "compressedDesh",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 9233, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing), "compressedAluminium",
                        getModItem("minecraft", "hopper", 1, 0, missing), "compressedAluminium" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.gcBlockCore", 1, 4, missing),
                new Object[] { "craftingToolHardHammer", "compressedTin", null, "compressedTin", "stone",
                        "compressedTin", null, "compressedTin", "craftingToolWrench" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.gcBlockCore", 1, 3, missing),
                new Object[] { null, "compressedTin", "craftingToolHardHammer", "compressedTin", "stone",
                        "compressedTin", "craftingToolWrench", "compressedTin", null });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.airLockFrame", 2, 0, missing),
                new Object[] { "compressedDesh", "screwStainlessSteel", "compressedDesh",
                        getModItem("GalacticraftCore", "item.airVent", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem("GalacticraftCore", "item.airVent", 1, 0, missing), "compressedAluminium",
                        "screwStainlessSteel", "compressedAluminium" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.airLockFrame", 1, 1, missing),
                new Object[] { "compressedDesh",
                        getModItem("GalacticraftCore", "item.oxygenConcentrator", 1, 0, missing), "compressedDesh",
                        getModItem("GalacticraftCore", "item.airVent", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32740, missing),
                        getModItem("GalacticraftCore", "item.airVent", 1, 0, missing), "waferAdvanced",
                        "wireGt01RedAlloy", "waferAdvanced" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.enclosed", 1, 1, missing),
                new Object[] { "craftingToolHardHammer",
                        getModItem("GalacticraftCore", "tile.oxygenPipe", 1, 0, missing), null,
                        getModItem("GalacticraftCore", "tile.oxygenPipe", 1, 0, missing),
                        getModItem("GalacticraftCore", "tile.gcBlockCore", 1, 4, missing),
                        getModItem("GalacticraftCore", "tile.oxygenPipe", 1, 0, missing), null,
                        getModItem("GalacticraftCore", "tile.oxygenPipe", 1, 0, missing), "craftingToolFile" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.enclosed", 1, 13, missing),
                new Object[] { "craftingToolHardHammer",
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 11, missing), null,
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 11, missing),
                        getModItem("GalacticraftCore", "tile.gcBlockCore", 1, 4, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 11, missing), null,
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 11, missing), "craftingToolFile" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.enclosed", 1, 14, missing),
                new Object[] { "craftingToolHardHammer",
                        getModItem("GalacticraftCore", "tile.aluminumWire", 1, 0, missing), null,
                        getModItem("GalacticraftCore", "tile.aluminumWire", 1, 0, missing),
                        getModItem("GalacticraftCore", "tile.gcBlockCore", 1, 4, missing),
                        getModItem("GalacticraftCore", "tile.aluminumWire", 1, 0, missing), null,
                        getModItem("GalacticraftCore", "tile.aluminumWire", 1, 0, missing), "craftingToolFile" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.enclosed", 1, 15, missing),
                new Object[] { "craftingToolHardHammer",
                        getModItem("GalacticraftCore", "tile.aluminumWire", 1, 1, missing), null,
                        getModItem("GalacticraftCore", "tile.aluminumWire", 1, 1, missing),
                        getModItem("GalacticraftCore", "tile.gcBlockCore", 1, 4, missing),
                        getModItem("GalacticraftCore", "tile.aluminumWire", 1, 1, missing), null,
                        getModItem("GalacticraftCore", "tile.aluminumWire", 1, 1, missing), "craftingToolFile" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.enclosed", 1, 11, missing),
                new Object[] { "craftingToolHardHammer",
                        getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepowerstone", 1, 0, missing), null,
                        getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepowerstone", 1, 0, missing),
                        getModItem("GalacticraftCore", "tile.gcBlockCore", 1, 4, missing),
                        getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepowerstone", 1, 0, missing), null,
                        getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepowerstone", 1, 0, missing),
                        "craftingToolFile" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.enclosed", 1, 12, missing),
                new Object[] { "craftingToolHardHammer",
                        getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepowergold", 1, 0, missing), null,
                        getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepowergold", 1, 0, missing),
                        getModItem("GalacticraftCore", "tile.gcBlockCore", 1, 4, missing),
                        getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepowergold", 1, 0, missing), null,
                        getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepowergold", 1, 0, missing),
                        "craftingToolFile" });
        addShapelessCraftingRecipe(
                getModItem("GalacticraftCore", "tile.aluminumWire", 1, 0, missing),
                new Object[] { "cableGt01Aluminium" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.aluminumWire", 3, 1, missing),
                new Object[] { "compressedAluminium", "compressedAluminium", "compressedAluminium",
                        getModItem("GalacticraftCore", "tile.aluminumWire", 1, 0, missing),
                        getModItem("GalacticraftCore", "tile.aluminumWire", 1, 0, missing),
                        getModItem("GalacticraftCore", "tile.aluminumWire", 1, 0, missing), "compressedAluminium",
                        "compressedAluminium", "compressedAluminium" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.solar", 1, 0, missing),
                new Object[] { "compressedAluminium", getModItem("GalacticraftCore", "item.basicItem", 1, 1, missing),
                        "compressedAluminium", getModItem("GalacticraftCore", "tile.aluminumWire", 1, 0, missing),
                        getModItem("GalacticraftCore", "item.steelPole", 1, 0, missing),
                        getModItem("GalacticraftCore", "tile.aluminumWire", 1, 0, missing), "compressedSteel",
                        "waferBasic", "compressedSteel" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.solar", 1, 4, missing),
                new Object[] { "compressedAluminium", getModItem("GalacticraftCore", "item.basicItem", 1, 1, missing),
                        "compressedAluminium", getModItem("GalacticraftCore", "tile.aluminumWire", 1, 1, missing),
                        getModItem("GalacticraftCore", "item.steelPole", 1, 0, missing),
                        getModItem("GalacticraftCore", "tile.aluminumWire", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing), "waferAdvanced",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32690, missing) });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.basicItem", 1, 1, missing),
                new Object[] { getModItem("GalacticraftCore", "item.basicItem", 1, 0, missing),
                        getModItem("GalacticraftCore", "item.basicItem", 1, 0, missing),
                        getModItem("GalacticraftCore", "item.basicItem", 1, 0, missing),
                        getModItem("GalacticraftCore", "tile.aluminumWire", 1, 0, missing), "waferBasic",
                        getModItem("GalacticraftCore", "tile.aluminumWire", 1, 0, missing),
                        getModItem("GalacticraftCore", "item.basicItem", 1, 0, missing),
                        getModItem("GalacticraftCore", "item.basicItem", 1, 0, missing),
                        getModItem("GalacticraftCore", "item.basicItem", 1, 0, missing) });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.machineTiered", 1, 0, missing),
                new Object[] { "compressedSteel", getModItem("IC2", "itemBatChargeRE", 1, 32767, missing),
                        "compressedSteel", "cableGt01AnyCopper",
                        getModItem("gregtech", "gt.blockmachines", 1, 12, missing), "cableGt01AnyCopper", "waferBasic",
                        getModItem("IC2", "itemBatChargeRE", 1, 32767, missing), "waferBasic" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.machineTiered", 1, 8, missing),
                new Object[] { "compressedTitanium", getModItem("IC2", "itemBatChargeAdv", 1, 32767, missing),
                        "compressedTitanium", "cableGt02Gold",
                        getModItem("gregtech", "gt.blockmachines", 1, 13, missing), "cableGt02Gold", "waferAdvanced",
                        getModItem("IC2", "itemBatChargeAdv", 1, 32767, missing), "waferAdvanced" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.spinThruster", 1, 0, missing),
                new Object[] { "compressedTitanium", "compressedTitanium", "compressedTitanium",
                        getModItem("GalacticraftCore", "item.fuelCanisterPartial", 1, 1, missing), "waferAdvanced",
                        getModItem("GalacticraftCore", "item.fuelCanisterPartial", 1, 1, missing),
                        getModItem("GalacticraftCore", "item.engine", 1, 0, missing),
                        getModItem("GalacticraftCore", "item.heavyPlating", 1, 0, missing),
                        getModItem("GalacticraftCore", "item.engine", 1, 0, missing) });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.viewScreen", 1, 0, missing),
                new Object[] { "compressedSteel", getModItem("gregtech", "gt.metaitem.01", 1, 32750, missing),
                        "compressedSteel", "waferBasic", getModItem("gregtech", "gt.metaitem.01", 1, 32740, missing),
                        "waferBasic", "compressedSteel", "compressedSteel", "compressedSteel" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.telemetry", 1, 0, missing),
                new Object[] { getModItem("GalacticraftCore", "item.basicItem", 1, 19, missing), "compressedTin",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32682, missing), "waferBasic", "compressedTin",
                        "waferBasic", "compressedTin", "compressedCopper", "compressedTin" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.arclamp", 1, 0, missing),
                new Object[] { getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalaxySpace", "ceresglowstone", 1, 0, missing),
                        getModItem("ProjRed|Illumination", "projectred.illumination.lamp", 1, 16, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing) });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.arclamp", 1, 0, missing),
                new Object[] { getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalaxySpace", "ioglowstone", 1, 0, missing),
                        getModItem("ProjRed|Illumination", "projectred.illumination.lamp", 1, 16, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing) });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.arclamp", 1, 0, missing),
                new Object[] { getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalaxySpace", "enceladusglowstone", 1, 0, missing),
                        getModItem("ProjRed|Illumination", "projectred.illumination.lamp", 1, 16, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing) });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.arclamp", 1, 0, missing),
                new Object[] { getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalaxySpace", "proteusglowstone", 1, 0, missing),
                        getModItem("ProjRed|Illumination", "projectred.illumination.lamp", 1, 16, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing) });
        addShapedRecipe(
                getModItem("GalacticraftCore", "tile.arclamp", 1, 0, missing),
                new Object[] { getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalaxySpace", "plutoglowstone", 1, 0, missing),
                        getModItem("ProjRed|Illumination", "projectred.illumination.lamp", 1, 16, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing) });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.oxygenGear", 1, 0, missing),
                new Object[] { getModItem("GalacticraftCore", "tile.oxygenPipe", 1, 0, missing),
                        getModItem("GalacticraftCore", "tile.oxygenPipe", 1, 0, missing),
                        getModItem("GalacticraftCore", "tile.oxygenPipe", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32612, missing),
                        getModItem("GalacticraftCore", "item.oxygenConcentrator", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32612, missing),
                        getModItem("GalacticraftCore", "tile.oxygenPipe", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing),
                        getModItem("GalacticraftCore", "tile.oxygenPipe", 1, 0, missing) });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.oxygenTankLightFull", 1, 1000, missing),
                new Object[] { "compressedAluminium", getModItem("GalacticraftCore", "tile.oxygenPipe", 1, 0, missing),
                        "compressedAluminium", "compressedAluminium", "cellEmpty", "compressedAluminium",
                        "compressedAluminium", "compressedAluminium", "compressedAluminium" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.oxygenTankLightFull", 1, 1000, missing),
                new Object[] { "compressedAluminium", getModItem("GalacticraftCore", "tile.oxygenPipe", 1, 0, missing),
                        "compressedAluminium", "compressedAluminium", getModItem("IC2", "itemFluidCell", 1, 0, missing),
                        "compressedAluminium", "compressedAluminium", "compressedAluminium", "compressedAluminium" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.oxygenTankMedFull", 1, 2000, missing),
                new Object[] { getModItem("GalacticraftCore", "item.meteoricIronIngot", 1, 1, missing),
                        getModItem("GalacticraftCore", "tile.oxygenPipe", 1, 0, missing),
                        getModItem("GalacticraftCore", "item.meteoricIronIngot", 1, 1, missing),
                        getModItem("GalacticraftCore", "item.meteoricIronIngot", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32405, missing),
                        getModItem("GalacticraftCore", "item.meteoricIronIngot", 1, 1, missing),
                        getModItem("GalacticraftCore", "item.meteoricIronIngot", 1, 1, missing),
                        getModItem("GalacticraftCore", "item.meteoricIronIngot", 1, 1, missing),
                        getModItem("GalacticraftCore", "item.meteoricIronIngot", 1, 1, missing) });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.oxygenTankHeavyFull", 1, 3000, missing),
                new Object[] { getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftCore", "tile.oxygenPipe", 1, 0, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32406, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing) });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.oxygenTankSuperHeavyFull", 1, 4000, missing),
                new Object[] { getModItem("dreamcraft", "item.TitaniumDualCompressedPlates", 1, 0, missing),
                        getModItem("GalacticraftCore", "tile.oxygenPipe", 1, 0, missing),
                        getModItem("dreamcraft", "item.TitaniumDualCompressedPlates", 1, 0, missing),
                        getModItem("dreamcraft", "item.TitaniumDualCompressedPlates", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32411, missing),
                        getModItem("dreamcraft", "item.TitaniumDualCompressedPlates", 1, 0, missing),
                        getModItem("dreamcraft", "item.TitaniumDualCompressedPlates", 1, 0, missing),
                        getModItem("dreamcraft", "item.TitaniumDualCompressedPlates", 1, 0, missing),
                        getModItem("dreamcraft", "item.TitaniumDualCompressedPlates", 1, 0, missing) });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.oxygenTankUltraHeavyFull", 1, 5000, missing),
                new Object[] { "plateTripleTrinium", getModItem("GalacticraftCore", "tile.oxygenPipe", 1, 0, missing),
                        "plateTripleTrinium", "plateTripleTrinium",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32412, missing), "plateTripleTrinium",
                        "plateTripleTrinium", "plateTripleTrinium", "plateTripleTrinium" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.sensorLens", 1, 0, missing),
                new Object[] { "ringRedAlloy", "lensDiamond", "ringRedAlloy", "circuitAdvanced", "lensReinforcedGlass",
                        "circuitAdvanced", "screwStainlessSteel", "craftingToolScrewdriver", "screwStainlessSteel" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.sensorGlasses", 1, 0, missing),
                new Object[] { "circuitData", "screwMeteoricSteel", "circuitData", "ringDesh", "boltDesh", "ringDesh",
                        getModItem("GalacticraftCore", "item.sensorLens", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem("GalacticraftCore", "item.sensorLens", 1, 0, missing) });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.steel_pickaxe", 1, 0, missing),
                new Object[] { "compressedSteel", "compressedSteel", "compressedSteel", "craftingToolFile", "stickWood",
                        "craftingToolHardHammer", null, "stickWood", null });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.steel_axe", 1, 0, missing),
                new Object[] { "compressedSteel", "compressedSteel", "craftingToolHardHammer", "compressedSteel",
                        "stickWood", null, "craftingToolFile", "stickWood", null });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.steel_hoe", 1, 0, missing),
                new Object[] { "compressedSteel", "compressedSteel", "craftingToolHardHammer", "craftingToolFile",
                        "stickWood", null, null, "stickWood", null });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.steel_shovel", 1, 0, missing),
                new Object[] { "craftingToolFile", "compressedSteel", "craftingToolHardHammer", null, "stickWood", null,
                        null, "stickWood", null });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.steel_sword", 1, 0, missing),
                new Object[] { null, "compressedSteel", null, "craftingToolFile", "compressedSteel",
                        "craftingToolHardHammer", null, "stickWood", null });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.steel_helmet", 1, 0, missing),
                new Object[] { "compressedSteel", "compressedSteel", "compressedSteel", "compressedSteel",
                        "craftingToolHardHammer", "compressedSteel", null, null, null });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.steel_chestplate", 1, 0, missing),
                new Object[] { "compressedSteel", "craftingToolHardHammer", "compressedSteel", "compressedSteel",
                        "compressedSteel", "compressedSteel", "compressedSteel", "compressedSteel",
                        "compressedSteel" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.steel_leggings", 1, 0, missing),
                new Object[] { "compressedSteel", "compressedSteel", "compressedSteel", "compressedSteel",
                        "craftingToolHardHammer", "compressedSteel", "compressedSteel", null, "compressedSteel" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.steel_boots", 1, 0, missing),
                new Object[] { "compressedSteel", null, "compressedSteel", "compressedSteel", "craftingToolHardHammer",
                        "compressedSteel", null, null, null });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.deshHelmet", 1, 0, missing),
                new Object[] { getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing), "craftingToolHardHammer",
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing), null, null, null });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.deshChestplate", 1, 0, missing),
                new Object[] { getModItem("GalacticraftMars", "item.null", 1, 5, missing), "craftingToolHardHammer",
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing) });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.deshLeggings", 1, 0, missing),
                new Object[] { getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing), "craftingToolHardHammer",
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing), null,
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing) });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.deshBoots", 1, 0, missing),
                new Object[] { getModItem("GalacticraftMars", "item.null", 1, 5, missing), null,
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing), "craftingToolHardHammer",
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing), null, null, null });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.titanium_pickaxe", 1, 0, missing),
                new Object[] { "compressedTitanium", "compressedTitanium", "compressedTitanium", "craftingToolFile",
                        "stickWood", "craftingToolHardHammer", null, "stickWood", null });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.titanium_axe", 1, 0, missing),
                new Object[] { "compressedTitanium", "compressedTitanium", "craftingToolHardHammer",
                        "compressedTitanium", "stickWood", null, "craftingToolFile", "stickWood", null });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.titanium_hoe", 1, 0, missing),
                new Object[] { "compressedTitanium", "compressedTitanium", "craftingToolHardHammer", "craftingToolFile",
                        "stickWood", null, null, "stickWood", null });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.titanium_shovel", 1, 0, missing),
                new Object[] { "craftingToolFile", "compressedTitanium", "craftingToolHardHammer", null, "stickWood",
                        null, null, "stickWood", null });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.titanium_sword", 1, 0, missing),
                new Object[] { null, "compressedTitanium", null, "craftingToolFile", "compressedTitanium",
                        "craftingToolHardHammer", null, "stickWood", null });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.deshPick", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 30502, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing), "craftingToolFile", "stickDesh",
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing), null, "stickDesh",
                        "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.deshAxe", 1, 0, missing),
                new Object[] { getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30502, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing), "stickDesh",
                        "craftingToolHardHammer", "craftingToolFile", "stickDesh", null });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.deshHoe", 1, 0, missing),
                new Object[] { getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30502, missing), "craftingToolFile", "stickDesh",
                        "craftingToolHardHammer", null, "stickDesh", null });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.deshSpade", 1, 0, missing),
                new Object[] { "craftingToolFile", getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30502, missing), null, "stickDesh",
                        "craftingToolHardHammer", null, "stickDesh", null });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.deshSword", 1, 0, missing),
                new Object[] { null, getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30502, missing), "craftingToolFile",
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing), "craftingToolHardHammer", null,
                        "stickDesh", null });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.titanium_helmet", 1, 0, missing),
                new Object[] { "compressedTitanium", "compressedTitanium", "compressedTitanium", "compressedTitanium",
                        "craftingToolHardHammer", "compressedTitanium", null, null, null });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.titanium_chestplate", 1, 0, missing),
                new Object[] { "compressedTitanium", "craftingToolHardHammer", "compressedTitanium",
                        "compressedTitanium", "compressedTitanium", "compressedTitanium", "compressedTitanium",
                        "compressedTitanium", "compressedTitanium" });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.titanium_leggings", 1, 0, missing),
                new Object[] { "compressedTitanium", "compressedTitanium", "compressedTitanium", "compressedTitanium",
                        "craftingToolHardHammer", "compressedTitanium", "compressedTitanium", null,
                        "compressedTitanium" });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.titanium_boots", 1, 0, missing),
                new Object[] { "compressedTitanium", null, "compressedTitanium", "compressedTitanium",
                        "craftingToolHardHammer", "compressedTitanium", null, null, null });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.airVent", 1, 0, missing),
                new Object[] { getModItem("minecraft", "iron_bars", 1, 0, missing), "compressedTin",
                        getModItem("minecraft", "iron_bars", 1, 0, missing), "compressedTin", "compressedSteel",
                        "compressedTin", getModItem("minecraft", "iron_bars", 1, 0, missing), "compressedTin",
                        getModItem("minecraft", "iron_bars", 1, 0, missing) });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.airFan", 1, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("gregtech", "gt.metaitem.02", 1, 21305, missing), "stickLongStainlessSteel",
                        getModItem("gregtech", "gt.metaitem.02", 1, 21305, missing), "screwSteel", "craftingToolWrench",
                        "screwSteel" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.oxygenConcentrator", 1, 0, missing),
                new Object[] { "compressedSteel", getModItem("GalacticraftCore", "item.airVent", 1, 0, missing),
                        "compressedSteel", "compressedSteel",
                        getModItem("GalacticraftCore", "item.airFan", 1, 0, missing), "compressedSteel",
                        getModItem("GalacticraftCore", "item.canister", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32612, missing),
                        getModItem("GalacticraftCore", "item.canister", 1, 0, missing) });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.oilExtractor", 1, 0, missing),
                new Object[] { "pipeTinySteel", "craftingToolScrewdriver", "screwStainlessSteel", "screwStainlessSteel",
                        getModItem("GalacticraftCore", "item.oilCanisterPartial", 1, 1001, missing), "compressedBronze",
                        getModItem("ProjRed|Illumination", "projectred.illumination.lightbutton", 1, 14, missing),
                        "compressedBronze", "compressedBronze" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.buggymat", 1, 0, missing),
                new Object[] { "compressedSteel", "plateAnyRubber", "compressedSteel", "plateAnyRubber",
                        "compressedTitanium", "plateAnyRubber", "compressedSteel", "plateAnyRubber",
                        "compressedSteel" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.buggymat", 1, 1, missing),
                new Object[] { null, getModItem("IC2", "blockRubber", 1, 0, missing), "compressedSteel",
                        getModItem("IC2", "blockRubber", 1, 0, missing),
                        getModItem("IC2", "blockRubber", 1, 0, missing), "compressedSteel", "compressedSteel",
                        "compressedSteel", "compressedSteel" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.buggymat", 1, 2, missing),
                new Object[] { "compressedSteel", getModItem("IC2", "blockRubber", 1, 0, missing), "compressedSteel",
                        "compressedSteel", getModItem("IronChest", "BlockIronChest", 1, 0, missing), "compressedSteel",
                        "compressedSteel", "compressedSteel", "compressedSteel" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.basicItem", 1, 19, missing),
                new Object[] { "compressedAluminium", getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        "compressedAluminium", "waferBasic",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32740, missing), "waferBasic", "compressedTin",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32500, missing), "compressedTin" });
        addShapedRecipe(
                getModItem("GalacticraftMars", "tile.walkway", 2, 0, missing),
                new Object[] { getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing), null, "blockDesh", null,
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing) });
        addShapelessCraftingRecipe(
                getModItem("GalacticraftMars", "item.null", 1, 1, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 23884, missing) });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 23884, missing),
                new Object[] { getModItem("GalacticraftMars", "item.null", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem("GalacticraftCore", "item.battery", 1, 32767, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 32500, missing) });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.standardWrench", 1, 0, missing),
                new Object[] { "plateSteel", "craftingToolSaw", "plateSteel", "screwSteel", "stickSteel", "screwSteel",
                        "craftingToolScrewdriver", "stickSteel", "craftingToolFile" });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1, 8, missing),
                new Object[] { "ringRedAlloy", "compressedIron", "ringRedAlloy", "compressedIron", "lensDiamond",
                        "compressedIron", "ringRedAlloy", "compressedIron", "ringRedAlloy" });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.null", 1, 6, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 32612, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 5135, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32612, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 5135, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32405, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 5135, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32612, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 5135, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32612, missing) });
        addShapedRecipe(
                getModItem("GalacticraftMars", "tile.beamReflector", 1, 0, missing),
                new Object[] { "ringDesh", getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1, 8, missing),
                        "ringDesh", "screwDesh", "stickDesh", "screwDesh",
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing), "blockDesh",
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing) });
        addShapedRecipe(
                getModItem("GalacticraftMars", "tile.beamReceiver", 1, 0, missing),
                new Object[] { "compressedTin", "ringDesh", "compressedTin", "ringDesh",
                        getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1, 8, missing), "ringDesh",
                        "compressedTin", "ringDesh", "compressedTin" });
        addShapedRecipe(
                getModItem("GalacticraftMars", "tile.telepadShort", 1, 0, missing),
                new Object[] { "compressedTitanium", getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        "compressedTitanium", getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32672, missing),
                        getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1, 8, missing), "compressedTitanium",
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing), "compressedTitanium" });
        addShapedRecipe(
                getModItem("GalacticraftMars", "tile.marsMachine", 1, 4, missing),
                new Object[] { getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1, 0, missing),
                        getModItem("GraviSuite", "itemSimpleItem", 1, 2, missing),
                        getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1, 0, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 3, missing),
                        getModItem("CarpentersBlocks", "itemCarpentersBed", 1, 0, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 3, missing),
                        getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1, 0, missing),
                        getModItem("minecraft", "clock", 1, 0, missing),
                        getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1, 0, missing) });
        addShapedRecipe(
                getModItem("GalacticraftMars", "tile.marsMachine", 1, 0, missing),
                new Object[] { "compressedTitanium",
                        getModItem("GalacticraftCore", "item.oxygenConcentrator", 1, 0, missing), "compressedTitanium",
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("gregtech", "gt.blockcasings2", 1, 4, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing),
                        getModItem("ae2fc", "certus_quartz_tank", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32612, missing) });
        addShapedRecipe(
                getModItem("GalacticraftMars", "tile.marsMachine", 1, 8, missing),
                new Object[] { "waferAdvanced", getModItem("GalacticraftCore", "item.basicItem", 1, 19, missing),
                        "waferAdvanced", getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 13, missing),
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing), "cableGt02Aluminium",
                        getModItem("GalacticraftMars", "item.null", 1, 5, missing), "cableGt02Aluminium" });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.grapple", 1, 0, missing),
                new Object[] { null, null, "toolHeadArrowMeteoricSteel",
                        getModItem("dreamcraft", "item.MeteoricIronString", 1, 0, missing),
                        getModItem("dreamcraft", "item.MeteoricIronString", 1, 0, missing),
                        getModItem("dreamcraft", "item.MeteoricIronString", 1, 0, missing), "ringMeteoricSteel", null,
                        null });
        addShapedRecipe(
                getModItem("GalacticraftMars", "tile.minerBase", 4, 0, missing),
                new Object[] { "compressedTitanium", "chestSteel", "compressedTitanium",
                        getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1, 8, missing), "frameGtTungsten",
                        getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1, 8, missing), "compressedDesh",
                        getModItem("GalacticraftCore", "tile.machineTiered", 1, 0, missing), "compressedDesh" });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.orionDrive", 1, 0, missing),
                new Object[] { "compressedTitanium",
                        getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1, 8, missing), "compressedTitanium",
                        "circuitMaster", "oc:hdd3", "circuitMaster", "compressedSteel",
                        getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1, 8, missing), "compressedSteel" });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.canvas", 1, 0, missing),
                new Object[] { null, getModItem("harvestcraft", "wovencottonItem", 1, 0, missing), "stickPlastic",
                        getModItem("harvestcraft", "wovencottonItem", 1, 0, missing), "stickPlastic",
                        getModItem("harvestcraft", "wovencottonItem", 1, 0, missing), "stickPlastic",
                        getModItem("harvestcraft", "wovencottonItem", 1, 0, missing), null });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.basicItem", 1, 20, missing),
                new Object[] { "circuitAdvanced", getModItem("GalacticraftCore", "item.airVent", 1, 0, missing),
                        "circuitAdvanced", getModItem("GalacticraftCore", "item.basicItem", 1, 10, missing),
                        getModItem("GalacticraftCore", "item.basicItem", 1, 9, missing),
                        getModItem("GalacticraftCore", "item.basicItem", 1, 10, missing),
                        getModItem("GalacticraftCore", "item.basicItem", 1, 8, missing),
                        getModItem("GalacticraftCore", "item.basicItem", 1, 13, missing),
                        getModItem("GalacticraftCore", "item.basicItem", 1, 8, missing) });
        addShapelessCraftingRecipe(
                getModItem("GalacticraftCore", "item.schematic", 1, 0, missing),
                new Object[] { getModItem("GalacticraftCore", "item.schematic", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem("GalacticraftCore", "item.schematic", 1, 1, missing),
                new Object[] { getModItem("GalacticraftCore", "item.schematic", 1, 0, missing) });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.schematic", 1, 1, missing),
                new Object[] { getModItem("GalacticraftMars", "item.schematic", 1, 0, missing), null, null, null, null,
                        null, null, null, null });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.schematic", 1, 2, missing),
                new Object[] { null, getModItem("GalacticraftMars", "item.schematic", 1, 0, missing), null, null, null,
                        null, null, null, null });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.schematic", 1, 0, missing),
                new Object[] { getModItem("GalacticraftMars", "item.schematic", 1, 1, missing), null, null, null, null,
                        null, null, null, null });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.schematic", 1, 2, missing),
                new Object[] { null, getModItem("GalacticraftMars", "item.schematic", 1, 1, missing), null, null, null,
                        null, null, null, null });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.schematic", 1, 0, missing),
                new Object[] { getModItem("GalacticraftMars", "item.schematic", 1, 2, missing), null, null, null, null,
                        null, null, null, null });
        addShapedRecipe(
                getModItem("GalacticraftMars", "item.schematic", 1, 1, missing),
                new Object[] { null, getModItem("GalacticraftMars", "item.schematic", 1, 2, missing), null, null, null,
                        null, null, null, null });
        addShapedRecipe(
                getModItem("GalacticraftCore", "item.parachute", 1, 0, missing),
                new Object[] { getModItem("GalacticraftCore", "item.canvas", 1, 0, missing),
                        getModItem("GalacticraftCore", "item.canvas", 1, 0, missing),
                        getModItem("GalacticraftCore", "item.canvas", 1, 0, missing), "wireFineSteel", null,
                        "wireFineSteel", "wireFineSteel", "wireFineSteel", "wireFineSteel" });
        addShapelessCraftingRecipe(
                getModItem("GalacticraftCore", "item.meteoricIronRaw", 1, 0, missing),
                new Object[] { getModItem("GalacticraftCore", "item.meteoricIronRaw", 1, 32767, missing) });
        addShapelessCraftingRecipe(
                getModItem("GalacticraftCore", "item.spaceship", 1, 0, missing),
                new Object[] { getModItem("GalacticraftCore", "item.spaceship", 1, 32767, missing) });
        addShapelessCraftingRecipe(
                getModItem("GalacticraftCore", "item.buggy", 1, 0, missing),
                new Object[] { getModItem("GalacticraftCore", "item.buggy", 1, 32767, missing) });
        addShapelessCraftingRecipe(
                getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 0, missing),
                new Object[] { getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 0, missing),
                new Object[] { getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 0, missing),
                new Object[] { getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 3, missing) });
        addShapelessCraftingRecipe(
                getModItem("GalacticraftMars", "item.itemTier3Rocket", 1, 0, missing),
                new Object[] { getModItem("GalacticraftMars", "item.itemTier3Rocket", 1, 32767, missing) });
        addShapelessCraftingRecipe(
                getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 11, missing),
                new Object[] { getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 12, missing) });
        addShapelessCraftingRecipe(
                getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 11, missing),
                new Object[] { getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 13, missing) });

        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem("GalacticraftCore", "item.infiniteOxygen", 1, 0, missing),
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
                getModItem("dreamcraft", "item.HeavyDutyPlateTier8", 1, 0, missing),
                'd',
                getModItem("GalacticraftCore", "item.oxygenTankUltraHeavyFull", 1, 0, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32616, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.03", 1, 32105, missing),
                'g',
                "pipeSmallInfinity",
                'h',
                getModItem("gregtech", "gt.blockmachines", 1, 122, missing));

        GT_Values.RA.addFuel(
                createItemStack("IC2", "itemFluidCell", 1, 0, "{Fluid:{FluidName:\"oil\",Amount:1000}}", missing),
                getModItem("IC2", "itemFluidCell", 1, 0, missing),
                16,
                0);
        GT_Values.RA.addFuel(
                getModItem("gregtech", "gt.metaitem.01", 1, 30707, missing),
                getModItem("IC2", "itemCellEmpty", 1, 0, missing),
                16,
                0);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 9, 11340, missing))
                .itemOutputs(getModItem("GalacticraftCore", "tile.gcBlockCore", 1, 12, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.cheeseCurd", 9, 0, missing))
                .itemOutputs(getModItem("GalacticraftCore", "tile.moonBlock", 1, 2, missing)).noFluidInputs()
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
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.spaceship", 1, 0, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 20, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 16, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 11305, missing))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 2000))
                .noFluidOutputs().duration(1200).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.spaceship", 1, 1, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 20, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 16, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 11305, missing))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 2000))
                .noFluidOutputs().duration(1200).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.spaceship", 1, 2, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 20, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 16, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 11305, missing))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 2000))
                .noFluidOutputs().duration(1200).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.spaceship", 1, 3, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 20, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 16, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 11305, missing))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 2000))
                .noFluidOutputs().duration(1200).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 0, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 10, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 41, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 11305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 6, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 4000))
                .noFluidOutputs().duration(2400).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 1, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 10, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 41, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 11305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 6, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 4000))
                .noFluidOutputs().duration(2400).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 2, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 10, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 41, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 11305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 6, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 4000))
                .noFluidOutputs().duration(2400).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 3, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 10, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 41, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 11305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 6, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 4000))
                .noFluidOutputs().duration(2400).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.itemTier3Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 37, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 11, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 32, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 12, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 6000))
                .noFluidOutputs().duration(3600).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.itemTier3Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 37, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 11, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 32, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 12, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 6000))
                .noFluidOutputs().duration(3600).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.itemTier3Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 37, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 11, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 32, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 12, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 6000))
                .noFluidOutputs().duration(3600).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.itemTier3Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 37, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 11, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 32, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 12, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 6000))
                .noFluidOutputs().duration(3600).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier4Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 12, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 40, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 16, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 52, 32462, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 8000))
                .noFluidOutputs().duration(4800).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier4Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 12, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 40, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 16, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 52, 32462, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 8000))
                .noFluidOutputs().duration(4800).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier4Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 12, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 40, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 16, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 52, 32462, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 8000))
                .noFluidOutputs().duration(4800).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier4Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 12, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 40, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 16, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 52, 32462, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 8000))
                .noFluidOutputs().duration(4800).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier5Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 14, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 10000))
                .noFluidOutputs().duration(6000).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier5Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 14, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 10000))
                .noFluidOutputs().duration(6000).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier5Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 14, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 10000))
                .noFluidOutputs().duration(6000).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier5Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 14, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 10000))
                .noFluidOutputs().duration(6000).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier6Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 12, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 62, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 16, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 12000))
                .noFluidOutputs().duration(7200).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier6Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 12, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 62, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 16, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 12000))
                .noFluidOutputs().duration(7200).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier6Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 12, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 62, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 16, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 12000))
                .noFluidOutputs().duration(7200).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier6Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 12, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 62, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 16, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 12000))
                .noFluidOutputs().duration(7200).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier7Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 18, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 50, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 14000))
                .noFluidOutputs().duration(8400).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier7Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 18, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 50, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 14000))
                .noFluidOutputs().duration(8400).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier7Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 18, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 50, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 14000))
                .noFluidOutputs().duration(8400).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier7Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 18, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 50, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 14000))
                .noFluidOutputs().duration(8400).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier8Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT8", 18, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 53, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 20, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 16000))
                .noFluidOutputs().duration(9600).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier8Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT8", 18, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 53, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 20, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 16000))
                .noFluidOutputs().duration(9600).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier8Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT8", 18, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 53, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 20, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 16000))
                .noFluidOutputs().duration(9600).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier8Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT8", 18, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 53, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 20, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 16000))
                .noFluidOutputs().duration(9600).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 11, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 6, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 24, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 40, 11305, missing),
                        getModItem("minecraft", "diamond", 4, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 4000))
                .noFluidOutputs().duration(2400).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 12, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 6, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 24, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 40, 11305, missing),
                        getModItem("minecraft", "diamond", 4, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 4000))
                .noFluidOutputs().duration(2400).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 13, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 6, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 24, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 40, 11305, missing),
                        getModItem("minecraft", "diamond", 4, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 4000))
                .noFluidOutputs().duration(2400).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.itemAstroMiner", 1, 0, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 3, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 10, 11028, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 6000))
                .noFluidOutputs().duration(3600).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.buggy", 1, 0, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 11, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 5, 11340, missing),
                        getModItem("gregtech", "gt.metaitem.01", 21, 11305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 11306, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 6000))
                .noFluidOutputs().duration(1200).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.buggy", 1, 1, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 11, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 5, 11340, missing),
                        getModItem("gregtech", "gt.metaitem.01", 28, 11305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 11306, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 6000))
                .noFluidOutputs().duration(1200).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.buggy", 1, 2, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 11, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 5, 11340, missing),
                        getModItem("gregtech", "gt.metaitem.01", 35, 11305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 11306, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 6000))
                .noFluidOutputs().duration(1200).eut(30).addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.buggy", 1, 3, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 11, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 5, 11340, missing),
                        getModItem("gregtech", "gt.metaitem.01", 42, 11305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 11306, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 6000))
                .noFluidOutputs().duration(1200).eut(30).addTo(sArcFurnaceRecipes);
    }

    private void assemblerRecipes() {
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "wovencottonItem", 8, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 29019, missing),
                        getModItem("dreamcraft", "item.MeteoricIronString", 8, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.silicone", 144)).noFluidOutputs().duration(300)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 23010, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("GalacticraftCore", "tile.glowstoneTorch", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalacticraftCore", "item.basicItem", 4, 9, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 28305, missing))
                .itemOutputs(getModItem("GalacticraftCore", "item.oilCanisterPartial", 1, 1001, missing))
                .noFluidInputs().noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalacticraftCore", "tile.oxygenPipe", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 28035, missing))
                .itemOutputs(getModItem("GalacticraftMars", "tile.hydrogenPipe", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalacticraftMars", "item.itemBasicAsteroids", 5, 7, missing),
                        getModItem("dreamcraft", "item.MeteoricIronString", 5, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem("GalacticraftMars", "item.thermalPadding", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.silicone", 720)).noFluidOutputs().duration(750)
                .eut(1024).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalacticraftMars", "item.thermalPadding", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("GalacticraftMars", "item.itemBasicAsteroids", 5, 7, missing)).noFluidInputs()
                .noFluidOutputs().duration(180).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalacticraftMars", "item.itemBasicAsteroids", 8, 7, missing),
                        getModItem("dreamcraft", "item.MeteoricIronString", 8, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("GalacticraftMars", "item.thermalPadding", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.silicone", 1152)).noFluidOutputs().duration(1200)
                .eut(1024).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalacticraftMars", "item.thermalPadding", 1, 1, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("GalacticraftMars", "item.itemBasicAsteroids", 8, 7, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalacticraftMars", "item.itemBasicAsteroids", 7, 7, missing),
                        getModItem("dreamcraft", "item.MeteoricIronString", 7, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 7, missing))
                .itemOutputs(getModItem("GalacticraftMars", "item.thermalPadding", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.silicone", 1008)).noFluidOutputs().duration(1050)
                .eut(1024).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalacticraftMars", "item.thermalPadding", 1, 2, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("GalacticraftMars", "item.itemBasicAsteroids", 7, 7, missing)).noFluidInputs()
                .noFluidOutputs().duration(260).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalacticraftMars", "item.itemBasicAsteroids", 4, 7, missing),
                        getModItem("dreamcraft", "item.MeteoricIronString", 4, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem("GalacticraftMars", "item.thermalPadding", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.silicone", 576)).noFluidOutputs().duration(600)
                .eut(1024).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalacticraftMars", "item.thermalPadding", 1, 3, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("GalacticraftMars", "item.itemBasicAsteroids", 4, 7, missing)).noFluidInputs()
                .noFluidOutputs().duration(150).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "itemArmorHazmatHelmet", 1, 0, missing),
                        getModItem("dreamcraft", "item.ReinforcedGlassPlate", 16, 0, missing))
                .itemOutputs(getModItem("GalacticraftCore", "item.oxygenMask", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 144)).noFluidOutputs().duration(400).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "itemArmorHazmatHelmet", 1, 0, missing),
                        getModItem("dreamcraft", "item.ReinforcedGlassPlate", 16, 0, missing))
                .itemOutputs(getModItem("GalacticraftCore", "item.oxygenMask", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 144)).noFluidOutputs().duration(400).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "itemArmorHazmatHelmet", 1, 0, missing),
                        getModItem("dreamcraft", "item.ReinforcedGlassPlate", 16, 0, missing))
                .itemOutputs(getModItem("GalacticraftCore", "item.oxygenMask", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 72)).noFluidOutputs().duration(400).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32750, missing),
                        getModItem("GalacticraftCore", "item.basicItem", 1, 9, missing))
                .itemOutputs(getModItem("GalacticraftCore", "item.basicItem", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 23874, missing))
                .itemOutputs(getModItem("GalacticraftCore", "item.canvas", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalacticraftCore", "item.canvas", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 3, 19305, missing))
                .itemOutputs(getModItem("GalacticraftCore", "item.parachute", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(480).addTo(sAssemblerRecipes);
    }

    private void blastFurnaceRecipes() {
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.itemBasicAsteroids", 2, 4, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 11028, missing)).noFluidInputs()
                .noFluidOutputs().duration(1500).eut(120).specialValue(1500).addTo(sBlastRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.meteoricIronRaw", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 11340, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).specialValue(1000).addTo(sBlastRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "tile.fallenMeteor", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 2, 11340, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).specialValue(1000).addTo(sBlastRecipes);
    }

    private void cannerRecipes() {
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "apple", 6, 0, missing),
                        getModItem("GalacticraftCore", "item.canister", 1, 0, missing))
                .itemOutputs(getModItem("GalacticraftCore", "item.basicItem", 1, 15, missing)).noFluidInputs()
                .noFluidOutputs().duration(800).eut(1).addTo(sCannerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carrot", 8, 0, missing),
                        getModItem("GalacticraftCore", "item.canister", 1, 0, missing))
                .itemOutputs(getModItem("GalacticraftCore", "item.basicItem", 1, 16, missing)).noFluidInputs()
                .noFluidOutputs().duration(800).eut(1).addTo(sCannerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "melon", 8, 0, missing),
                        getModItem("GalacticraftCore", "item.canister", 1, 0, missing))
                .itemOutputs(getModItem("GalacticraftCore", "item.basicItem", 1, 17, missing)).noFluidInputs()
                .noFluidOutputs().duration(800).eut(1).addTo(sCannerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "potato", 16, 0, missing),
                        getModItem("GalacticraftCore", "item.canister", 1, 0, missing))
                .itemOutputs(getModItem("GalacticraftCore", "item.basicItem", 1, 18, missing)).noFluidInputs()
                .noFluidOutputs().duration(800).eut(1).addTo(sCannerRecipes);
    }

    private void extruderRecipes() {
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "blockAlloyGlass", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32359, missing))
                .itemOutputs(getModItem("GalacticraftCore", "tile.oxygenPipe", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(120).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalacticraftCore", "item.basicItem", 1, 7, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32354, missing))
                .itemOutputs(getModItem("GalacticraftCore", "item.canister", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(120).eut(30).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalacticraftCore", "item.basicItem", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32354, missing))
                .itemOutputs(getModItem("GalacticraftCore", "item.canister", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(120).eut(30).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalacticraftCore", "item.basicItem", 2, 9, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32352, missing))
                .itemOutputs(getModItem("GalacticraftCore", "item.steelPole", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sExtruderRecipes);
    }

    private void fluidCannerRecipes() {
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("GalacticraftCore", "item.fuelCanisterPartial", 1, 1001, missing))
                .itemOutputs(getModItem("GalacticraftCore", "item.fuelCanisterPartial", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("fuel", 1000)).noFluidOutputs().duration(16).eut(1)
                .addTo(sFluidCannerRecipes);
    }

    private void maceratorRecipes() {
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "tile.gcBlockCore", 1, 12, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 9, 2340, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.null", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 2884, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "tile.mars", 1, 2, missing))
                .itemOutputs(getModItem("GalacticraftMars", "item.null", 2, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "tile.fallenMeteor", 1, 0, missing))
                .itemOutputs(getModItem("GalacticraftCore", "item.meteoricIronRaw", 2, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "tile.asteroidsBlock", 1, 4, missing))
                .itemOutputs(getModItem("GalacticraftMars", "item.itemBasicAsteroids", 2, 4, missing))
                .outputChances(10000).noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.basicItem", 1, 2, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 2020, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
    }

    private void plasmaArcFurnaceRecipes() {
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.spaceship", 1, 0, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 20, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 16, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 11305, missing))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 8)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.spaceship", 1, 0, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 20, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 16, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 11305, missing))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 3))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 3)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.spaceship", 1, 1, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 20, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 16, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 11305, missing))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 8)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.spaceship", 1, 1, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 20, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 16, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 11305, missing))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 3))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 3)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.spaceship", 1, 2, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 20, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 16, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 11305, missing))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 8)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.spaceship", 1, 2, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 20, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 16, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 11305, missing))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 3))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 3)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.spaceship", 1, 3, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 20, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 16, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 11305, missing))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 8)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.spaceship", 1, 3, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 20, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 16, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 11305, missing))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 3))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 3)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 0, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 10, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 41, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 11305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 6, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 17)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 0, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 10, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 41, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 11305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 6, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 6))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 6)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 1, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 10, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 41, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 11305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 6, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 17)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 1, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 10, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 41, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 11305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 6, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 6))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 6)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 2, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 10, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 41, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 11305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 6, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 17)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 2, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 10, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 41, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 11305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 6, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 6))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 6)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 3, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 10, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 41, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 11305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 6, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 17)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 3, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 10, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 41, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 11305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 6, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 6))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 6)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.itemTier3Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 37, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 11, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 32, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 12, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 26))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 26)).duration(200).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.itemTier3Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 37, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 11, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 32, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 12, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 8)).duration(200).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.itemTier3Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 37, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 11, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 32, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 12, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 26))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 26)).duration(200).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.itemTier3Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 37, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 11, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 32, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 12, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 8)).duration(200).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.itemTier3Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 37, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 11, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 32, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 12, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 26))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 26)).duration(200).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.itemTier3Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 37, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 11, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 32, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 12, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 8)).duration(200).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.itemTier3Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 37, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 11, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 32, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 12, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 26))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 26)).duration(200).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.itemTier3Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 37, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 11, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 32, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 12, 11340, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 8)).duration(200).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier4Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 12, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 40, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 16, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 52, 32462, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 35))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 35)).duration(266).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier4Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 12, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 40, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 16, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 52, 32462, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 11))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 11)).duration(266).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier4Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 12, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 40, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 16, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 52, 32462, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 35))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 35)).duration(266).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier4Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 12, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 40, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 16, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 52, 32462, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 11))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 11)).duration(266).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier4Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 12, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 40, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 16, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 52, 32462, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 35))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 35)).duration(266).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier4Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 12, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 40, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 16, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 52, 32462, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 11))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 11)).duration(266).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier4Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 12, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 40, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 16, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 52, 32462, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 35))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 35)).duration(266).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier4Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 12, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 40, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 16, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 52, 32462, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 11))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 11)).duration(266).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier5Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 14, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 43))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 43)).duration(333).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier5Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 14, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 14))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 14)).duration(333).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier5Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 14, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 43))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 43)).duration(333).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier5Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 14, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 14))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 14)).duration(333).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier5Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 14, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 43))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 43)).duration(333).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier5Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 14, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 14))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 14)).duration(333).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier5Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 14, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 43))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 43)).duration(333).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier5Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 14, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 14))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 14)).duration(333).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier6Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 12, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 62, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 16, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 52))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 52)).duration(400).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier6Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 12, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 62, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 16, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 17)).duration(400).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier6Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 12, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 62, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 16, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 52))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 52)).duration(400).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier6Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 12, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 62, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 16, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 17)).duration(400).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier6Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 12, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 62, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 16, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 52))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 52)).duration(400).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier6Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 12, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 62, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 16, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 17)).duration(400).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier6Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 12, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 62, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 16, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 52))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 52)).duration(400).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier6Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 12, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 62, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT4", 16, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 64, 32464, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 17)).duration(400).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier7Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 18, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 50, 0, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 61))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 61)).duration(466).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier7Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 18, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 50, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 19))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 19)).duration(466).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier7Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 18, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 50, 0, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 61))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 61)).duration(466).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier7Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 18, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 50, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 19))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 19)).duration(466).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier7Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 18, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 50, 0, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 61))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 61)).duration(466).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier7Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 18, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 50, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 19))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 19)).duration(466).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier7Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 18, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 50, 0, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 61))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 61)).duration(466).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier7Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 18, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT5", 50, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 19))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 19)).duration(466).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier8Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT8", 18, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 53, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 20, 0, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 70))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 70)).duration(533).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier8Rocket", 1, 0, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT8", 18, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 53, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 20, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 22))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 22)).duration(533).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier8Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT8", 18, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 53, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 20, 0, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 70))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 70)).duration(533).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier8Rocket", 1, 1, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT8", 18, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 53, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 20, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 22))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 22)).duration(533).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier8Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT8", 18, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 53, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 20, 0, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 70))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 70)).duration(533).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier8Rocket", 1, 2, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT8", 18, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 53, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 20, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 22))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 22)).duration(533).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier8Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT8", 18, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 53, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 20, 0, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 70))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 70)).duration(533).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.Tier8Rocket", 1, 3, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT8", 18, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 64, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT7", 53, 0, missing),
                        getModItem("dreamcraft", "item.HeavyDutyAlloyIngotT6", 20, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 22))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 22)).duration(533).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 11, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 6, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 24, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 40, 11305, missing),
                        getModItem("minecraft", "diamond", 4, 0, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 17)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 11, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 6, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 24, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 40, 11305, missing),
                        getModItem("minecraft", "diamond", 4, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 6))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 6)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 12, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 6, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 24, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 40, 11305, missing),
                        getModItem("minecraft", "diamond", 4, 0, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 17)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 12, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 6, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 24, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 40, 11305, missing),
                        getModItem("minecraft", "diamond", 4, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 6))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 6)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 13, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 6, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 24, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 40, 11305, missing),
                        getModItem("minecraft", "diamond", 4, 0, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 17)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.spaceshipTier2", 1, 13, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 6, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 24, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 40, 11305, missing),
                        getModItem("minecraft", "diamond", 4, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 6))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 6)).duration(130).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.itemAstroMiner", 1, 0, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 3, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 10, 11028, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 26))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 26)).duration(200).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftMars", "item.itemAstroMiner", 1, 0, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 3, 32464, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 32463, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 10, 11028, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 8)).duration(200).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.buggy", 1, 0, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 11, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 5, 11340, missing),
                        getModItem("gregtech", "gt.metaitem.01", 21, 11305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 11306, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 8)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.buggy", 1, 0, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 11, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 5, 11340, missing),
                        getModItem("gregtech", "gt.metaitem.01", 21, 11305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 11306, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 3))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 3)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.buggy", 1, 1, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 11, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 5, 11340, missing),
                        getModItem("gregtech", "gt.metaitem.01", 28, 11305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 11306, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 8)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.buggy", 1, 1, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 11, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 5, 11340, missing),
                        getModItem("gregtech", "gt.metaitem.01", 28, 11305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 11306, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 3))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 3)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.buggy", 1, 2, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 11, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 5, 11340, missing),
                        getModItem("gregtech", "gt.metaitem.01", 35, 11305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 11306, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 8)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.buggy", 1, 2, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 11, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 5, 11340, missing),
                        getModItem("gregtech", "gt.metaitem.01", 35, 11305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 11306, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 3))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 3)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.buggy", 1, 3, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 11, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 5, 11340, missing),
                        getModItem("gregtech", "gt.metaitem.01", 42, 11305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 11306, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 8)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.buggy", 1, 3, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 11, 32462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 5, 11340, missing),
                        getModItem("gregtech", "gt.metaitem.01", 42, 11305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 11306, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 3))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 3)).duration(65).eut(30)
                .addTo(sPlasmaArcFurnaceRecipes);

    }

    private void benderRecipes() {
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.basicItem", 2, 7, missing))
                .itemOutputs(getModItem("GalacticraftCore", "item.canister", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(8).addTo(sBenderRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalacticraftCore", "item.basicItem", 2, 6, missing))
                .itemOutputs(getModItem("GalacticraftCore", "item.canister", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(8).addTo(sBenderRecipes);
    }
}
