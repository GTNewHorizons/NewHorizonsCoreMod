package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AE2FluidCraft;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.BuildCraftTransport;
import static gregtech.api.enums.Mods.CarpentersBlocks;
import static gregtech.api.enums.Mods.GalacticraftAmunRa;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.GalacticraftMars;
import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.enums.Mods.GraviSuite;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronChests;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.ProjectRedIllumination;
import static gregtech.api.enums.Mods.TinkersGregworks;
import static gregtech.api.recipe.RecipeMaps.arcFurnaceRecipes;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.blastFurnaceRecipes;
import static gregtech.api.recipe.RecipeMaps.cannerRecipes;
import static gregtech.api.recipe.RecipeMaps.extruderRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidCannerRecipes;
import static gregtech.api.recipe.RecipeMaps.laserEngraverRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.recipe.RecipeMaps.mixerRecipes;
import static gregtech.api.recipe.RecipeMaps.plasmaArcFurnaceRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gregtech.api.util.GTRecipeBuilder.WILDCARD;
import static gregtech.api.util.GTRecipeConstants.FUEL_TYPE;
import static gregtech.api.util.GTRecipeConstants.FUEL_VALUE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.item.NHItemList;

import codechicken.nei.PositionedStack;
import cpw.mods.fml.common.Optional;
import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.Mods;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.recipe.RecipeCategories;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTRecipeConstants;
import gregtech.api.util.GTUtility;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.SpaceStationRecipe;
import micdoodle8.mods.galacticraft.api.world.SpaceStationType;
import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import micdoodle8.mods.galacticraft.core.nei.BuggyRecipeHandler;
import micdoodle8.mods.galacticraft.core.nei.NEIGalacticraftConfig;
import micdoodle8.mods.galacticraft.core.recipe.NasaWorkbenchRecipe;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import micdoodle8.mods.galacticraft.planets.asteroids.blocks.AsteroidBlocks;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import micdoodle8.mods.galacticraft.planets.asteroids.nei.AstroMinerRecipeHandler;
import micdoodle8.mods.galacticraft.planets.asteroids.nei.NEIGalacticraftAsteroidsConfig;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import micdoodle8.mods.galacticraft.planets.mars.nei.CargoRocketRecipeHandler;
import micdoodle8.mods.galacticraft.planets.mars.nei.NEIGalacticraftMarsConfig;
import micdoodle8.mods.galacticraft.planets.mars.util.MarsUtil;

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
                "compressedIron",
                "compressedIron",
                "compressedIron",
                "plateAlloyAdvanced",
                "plateAlloyAdvanced",
                "plateAlloyAdvanced",
                "blockIron",
                "blockIron",
                "blockIron");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.landingPad", 3, 1, missing),
                "compressedSteel",
                "compressedSteel",
                "compressedSteel",
                "plateAlloyAdvanced",
                "plateAlloyAdvanced",
                "plateAlloyAdvanced",
                "blockSteel",
                "blockSteel",
                "blockSteel");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.oxygenCollector", 1, 0, missing),
                "compressedAluminium",
                getModItem(GalacticraftCore.ID, "item.oxygenConcentrator", 1, 0, missing),
                "compressedAluminium",
                getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "item.airFan", 1, 0, missing),
                ItemList.Electric_Motor_HV.get(1L),
                "compressedSteel",
                "cableGt02Aluminium",
                "compressedSteel");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.oxygenCompressor", 1, 0, missing),
                "compressedAluminium",
                getModItem(GalacticraftCore.ID, "item.oxygenConcentrator", 1, 0, missing),
                "compressedAluminium",
                ItemList.Electric_Piston_HV.get(1L),
                getModItem(GalacticraftCore.ID, "item.oilCanisterPartial", 1, 1001, missing),
                ItemList.Electric_Motor_HV.get(1L),
                "compressedSteel",
                "compressedBronze",
                "compressedSteel");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.oxygenCompressor", 1, 4, missing),
                "compressedAluminium",
                getModItem(GalacticraftCore.ID, "item.oxygenConcentrator", 1, 0, missing),
                "compressedAluminium",
                ItemList.Electric_Motor_HV.get(1L),
                getModItem(GalacticraftCore.ID, "item.oilCanisterPartial", 1, 1001, missing),
                getModItem(GalacticraftCore.ID, "item.airFan", 1, 0, missing),
                "compressedSteel",
                "compressedBronze",
                "compressedSteel");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.machine2", 1, 8, missing),
                "compressedSteel",
                getModItem(GalacticraftCore.ID, "item.oxygenTankUltraHeavyFull", 1, 3000, missing),
                "compressedSteel",
                getModItem(GalacticraftCore.ID, "item.oxygenTankUltraHeavyFull", 1, 3000, missing),
                ItemList.Casing_SolidSteel.get(1L),
                getModItem(GalacticraftCore.ID, "item.oxygenTankUltraHeavyFull", 1, 3000, missing),
                "compressedSteel",
                getModItem(GalacticraftCore.ID, "item.oxygenTankUltraHeavyFull", 1, 3000, missing),
                "compressedSteel");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.distributor", 1, 0, missing),
                "compressedAluminium",
                getModItem(GalacticraftCore.ID, "item.airFan", 1, 0, missing),
                "compressedAluminium",
                getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing),
                ItemList.Electric_Motor_HV.get(1L),
                getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing),
                "compressedSteel",
                getModItem(GalacticraftCore.ID, "item.airFan", 1, 0, missing),
                "compressedSteel");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.sealer", 1, 0, missing),
                "compressedAluminium",
                getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing),
                "compressedAluminium",
                getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "tile.distributor", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing),
                "compressedDesh",
                getModItem(GalacticraftCore.ID, "tile.oxygenDetector", 1, 0, missing),
                "compressedDesh");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.oxygenDetector", 1, 0, missing),
                "compressedDesh",
                "compressedSteel",
                "compressedDesh",
                getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing),
                ItemList.Sensor_HV.get(1L),
                getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing),
                "compressedAluminium",
                GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 1L),
                "compressedAluminium");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.fuelLoader", 1, 0, missing),
                "compressedSteel",
                "waferBasic",
                "compressedSteel",
                ItemList.Electric_Pump_HV.get(1L),
                ItemList.Large_Fluid_Cell_Steel.get(1L),
                ItemList.Electric_Motor_HV.get(1L),
                "compressedAluminium",
                "pipeMediumSteel",
                "compressedAluminium");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.cargo", 1, 0, missing),
                "compressedAluminium",
                getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                "compressedAluminium",
                ItemList.Conveyor_Module_HV.get(1L),
                ItemList.Automation_ChestBuffer_HV.get(1L),
                ItemList.Conveyor_Module_HV.get(1L),
                "compressedDesh",
                "pipeMediumBrass",
                "compressedDesh");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.cargo", 1, 4, missing),
                "compressedDesh",
                "pipeMediumBrass",
                "compressedDesh",
                ItemList.Conveyor_Module_HV.get(1L),
                ItemList.Automation_ChestBuffer_HV.get(1L),
                ItemList.Conveyor_Module_HV.get(1L),
                "compressedAluminium",
                getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                "compressedAluminium");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.gcBlockCore", 1, 4, missing),
                "craftingToolHardHammer",
                "compressedTin",
                null,
                "compressedTin",
                "stone",
                "compressedTin",
                null,
                "compressedTin",
                "craftingToolWrench");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.gcBlockCore", 1, 3, missing),
                null,
                "compressedTin",
                "craftingToolHardHammer",
                "compressedTin",
                "stone",
                "compressedTin",
                "craftingToolWrench",
                "compressedTin",
                null);
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.airLockFrame", 2, 0, missing),
                "compressedDesh",
                "screwStainlessSteel",
                "compressedDesh",
                getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing),
                "compressedAluminium",
                "screwStainlessSteel",
                "compressedAluminium");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.airLockFrame", 1, 1, missing),
                "compressedDesh",
                getModItem(GalacticraftCore.ID, "item.oxygenConcentrator", 1, 0, missing),
                "compressedDesh",
                getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing),
                ItemList.Cover_Screen.get(1L),
                getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing),
                "waferAdvanced",
                "wireGt01RedAlloy",
                "waferAdvanced");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.enclosed", 1, 1, missing),
                "craftingToolHardHammer",
                getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing),
                null,
                getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "tile.gcBlockCore", 1, 4, missing),
                getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing),
                null,
                getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing),
                "craftingToolFile");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.enclosed", 1, 13, missing),
                "craftingToolHardHammer",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 11, missing),
                null,
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 11, missing),
                getModItem(GalacticraftCore.ID, "tile.gcBlockCore", 1, 4, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 11, missing),
                null,
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 11, missing),
                "craftingToolFile");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.enclosed", 1, 14, missing),
                "craftingToolHardHammer",
                getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 0, missing),
                null,
                getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "tile.gcBlockCore", 1, 4, missing),
                getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 0, missing),
                null,
                getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 0, missing),
                "craftingToolFile");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.enclosed", 1, 15, missing),
                "craftingToolHardHammer",
                getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 1, missing),
                null,
                getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 1, missing),
                getModItem(GalacticraftCore.ID, "tile.gcBlockCore", 1, 4, missing),
                getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 1, missing),
                null,
                getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 1, missing),
                "craftingToolFile");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.enclosed", 1, 11, missing),
                "craftingToolHardHammer",
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerstone", 1, 0, missing),
                null,
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerstone", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "tile.gcBlockCore", 1, 4, missing),
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerstone", 1, 0, missing),
                null,
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerstone", 1, 0, missing),
                "craftingToolFile");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.enclosed", 1, 12, missing),
                "craftingToolHardHammer",
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowergold", 1, 0, missing),
                null,
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowergold", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "tile.gcBlockCore", 1, 4, missing),
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowergold", 1, 0, missing),
                null,
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowergold", 1, 0, missing),
                "craftingToolFile");
        addShapelessRecipe(getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 0, missing), "cableGt01Aluminium");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.aluminumWire", 3, 1, missing),
                "compressedAluminium",
                "compressedAluminium",
                "compressedAluminium",
                getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 0, missing),
                "compressedAluminium",
                "compressedAluminium",
                "compressedAluminium");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.solar", 1, 0, missing),
                "compressedAluminium",
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 1, missing),
                "compressedAluminium",
                getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "item.steelPole", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 0, missing),
                "compressedSteel",
                "waferBasic",
                "compressedSteel");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.solar", 1, 4, missing),
                "compressedAluminium",
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 1, missing),
                "compressedAluminium",
                getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 1, missing),
                getModItem(GalacticraftCore.ID, "item.steelPole", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 1, missing),
                ItemList.Electric_Motor_LV.get(1L),
                "waferAdvanced",
                ItemList.Sensor_LV.get(1L));
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 1, missing),
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 0, missing),
                "waferBasic",
                getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 0, missing));
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.machineTiered", 1, 0, missing),
                "compressedSteel",
                getModItem(IndustrialCraft2.ID, "itemBatChargeRE", 1, wildcard, missing),
                "compressedSteel",
                "cableGt01AnyCopper",
                ItemList.Hull_MV.get(1L),
                "cableGt01AnyCopper",
                "waferBasic",
                getModItem(IndustrialCraft2.ID, "itemBatChargeRE", 1, wildcard, missing),
                "waferBasic");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.machineTiered", 1, 8, missing),
                "compressedTitanium",
                getModItem(IndustrialCraft2.ID, "itemBatChargeAdv", 1, wildcard, missing),
                "compressedTitanium",
                "cableGt02Gold",
                ItemList.Hull_HV.get(1L),
                "cableGt02Gold",
                "waferAdvanced",
                getModItem(IndustrialCraft2.ID, "itemBatChargeAdv", 1, wildcard, missing),
                "waferAdvanced");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.spinThruster", 1, 0, missing),
                "compressedTitanium",
                "compressedTitanium",
                "compressedTitanium",
                getModItem(GalacticraftCore.ID, "item.fuelCanisterPartial", 1, 1, missing),
                "waferAdvanced",
                getModItem(GalacticraftCore.ID, "item.fuelCanisterPartial", 1, 1, missing),
                getModItem(GalacticraftCore.ID, "item.engine", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "item.heavyPlating", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "item.engine", 1, 0, missing));
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.viewScreen", 1, 0, missing),
                "compressedSteel",
                ItemList.Cover_SolarPanel.get(1L),
                "compressedSteel",
                "waferBasic",
                ItemList.Cover_Screen.get(1L),
                "waferBasic",
                "compressedSteel",
                "compressedSteel",
                "compressedSteel");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.telemetry", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 19, missing),
                "compressedTin",
                ItemList.Emitter_HV.get(1L),
                "waferBasic",
                "compressedTin",
                "waferBasic",
                "compressedTin",
                "compressedCopper",
                "compressedTin");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.arclamp", 1, 0, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalaxySpace.ID, "ceresglowstone", 1, 0, missing),
                getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1, 16, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing));
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.arclamp", 1, 0, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalaxySpace.ID, "ioglowstone", 1, 0, missing),
                getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1, 16, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing));
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.arclamp", 1, 0, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalaxySpace.ID, "enceladusglowstone", 1, 0, missing),
                getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1, 16, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing));
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.arclamp", 1, 0, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalaxySpace.ID, "proteusglowstone", 1, 0, missing),
                getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1, 16, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing));
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "tile.arclamp", 1, 0, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalaxySpace.ID, "plutoglowstone", 1, 0, missing),
                getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1, 16, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing));
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.oxygenGear", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing),
                ItemList.Electric_Pump_HV.get(1L),
                getModItem(GalacticraftCore.ID, "item.oxygenConcentrator", 1, 0, missing),
                ItemList.Electric_Pump_HV.get(1L),
                getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing),
                ItemList.Electric_Motor_HV.get(1L),
                getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing));
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.oxygenTankLightFull", 1, 1000, missing),
                "compressedAluminium",
                getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing),
                "compressedAluminium",
                "compressedAluminium",
                "cellEmpty",
                "compressedAluminium",
                "compressedAluminium",
                "compressedAluminium",
                "compressedAluminium");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.oxygenTankMedFull", 1, 2000, missing),
                getModItem(GalacticraftCore.ID, "item.meteoricIronIngot", 1, 1, missing),
                getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "item.meteoricIronIngot", 1, 1, missing),
                getModItem(GalacticraftCore.ID, "item.meteoricIronIngot", 1, 1, missing),
                ItemList.Large_Fluid_Cell_Steel.get(1L),
                getModItem(GalacticraftCore.ID, "item.meteoricIronIngot", 1, 1, missing),
                getModItem(GalacticraftCore.ID, "item.meteoricIronIngot", 1, 1, missing),
                getModItem(GalacticraftCore.ID, "item.meteoricIronIngot", 1, 1, missing),
                getModItem(GalacticraftCore.ID, "item.meteoricIronIngot", 1, 1, missing));
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.oxygenTankHeavyFull", 1, 4000, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                ItemList.Large_Fluid_Cell_TungstenSteel.get(1L),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing));
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.oxygenTankSuperHeavyFull", 1, 8000, missing),
                CustomItemList.TitaniumDualCompressedPlates.get(1L),
                getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing),
                CustomItemList.TitaniumDualCompressedPlates.get(1L),
                CustomItemList.TitaniumDualCompressedPlates.get(1L),
                ItemList.Large_Fluid_Cell_Iridium.get(1L),
                CustomItemList.TitaniumDualCompressedPlates.get(1L),
                CustomItemList.TitaniumDualCompressedPlates.get(1L),
                CustomItemList.TitaniumDualCompressedPlates.get(1L),
                CustomItemList.TitaniumDualCompressedPlates.get(1L));
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.oxygenTankUltraHeavyFull", 1, 16000, missing),
                "plateTripleTrinium",
                getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing),
                "plateTripleTrinium",
                "plateTripleTrinium",
                ItemList.Large_Fluid_Cell_Osmium.get(1L),
                "plateTripleTrinium",
                "plateTripleTrinium",
                "plateTripleTrinium",
                "plateTripleTrinium");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                "ringRedAlloy",
                "lensDiamond",
                "ringRedAlloy",
                "circuitAdvanced",
                "lensReinforcedGlass",
                "circuitAdvanced",
                "screwStainlessSteel",
                "craftingToolScrewdriver",
                "screwStainlessSteel");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.sensorGlasses", 1, 0, missing),
                "circuitData",
                "screwMeteoricSteel",
                "circuitData",
                "ringDesh",
                "boltDesh",
                "ringDesh",
                getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(GalacticraftCore.ID, "item.sensorLens", 1, 0, missing));
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.steel_pickaxe", 1, 0, missing),
                "compressedSteel",
                "compressedSteel",
                "compressedSteel",
                "craftingToolFile",
                "stickWood",
                "craftingToolHardHammer",
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.steel_axe", 1, 0, missing),
                "compressedSteel",
                "compressedSteel",
                "craftingToolHardHammer",
                "compressedSteel",
                "stickWood",
                null,
                "craftingToolFile",
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.steel_hoe", 1, 0, missing),
                "compressedSteel",
                "compressedSteel",
                "craftingToolHardHammer",
                "craftingToolFile",
                "stickWood",
                null,
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.steel_shovel", 1, 0, missing),
                "craftingToolFile",
                "compressedSteel",
                "craftingToolHardHammer",
                null,
                "stickWood",
                null,
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.steel_sword", 1, 0, missing),
                null,
                "compressedSteel",
                null,
                "craftingToolFile",
                "compressedSteel",
                "craftingToolHardHammer",
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.steel_helmet", 1, 0, missing),
                "compressedSteel",
                "compressedSteel",
                "compressedSteel",
                "compressedSteel",
                "craftingToolHardHammer",
                "compressedSteel",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.steel_chestplate", 1, 0, missing),
                "compressedSteel",
                "craftingToolHardHammer",
                "compressedSteel",
                "compressedSteel",
                "compressedSteel",
                "compressedSteel",
                "compressedSteel",
                "compressedSteel",
                "compressedSteel");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.steel_leggings", 1, 0, missing),
                "compressedSteel",
                "compressedSteel",
                "compressedSteel",
                "compressedSteel",
                "craftingToolHardHammer",
                "compressedSteel",
                "compressedSteel",
                null,
                "compressedSteel");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.steel_boots", 1, 0, missing),
                "compressedSteel",
                null,
                "compressedSteel",
                "compressedSteel",
                "craftingToolHardHammer",
                "compressedSteel",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.deshHelmet", 1, 0, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                "craftingToolHardHammer",
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.deshChestplate", 1, 0, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                "craftingToolHardHammer",
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing));
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.deshLeggings", 1, 0, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                "craftingToolHardHammer",
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                null,
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing));
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.deshBoots", 1, 0, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                null,
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                "craftingToolHardHammer",
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.titanium_pickaxe", 1, 0, missing),
                "compressedTitanium",
                "compressedTitanium",
                "compressedTitanium",
                "craftingToolFile",
                "stickWood",
                "craftingToolHardHammer",
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.titanium_axe", 1, 0, missing),
                "compressedTitanium",
                "compressedTitanium",
                "craftingToolHardHammer",
                "compressedTitanium",
                "stickWood",
                null,
                "craftingToolFile",
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.titanium_hoe", 1, 0, missing),
                "compressedTitanium",
                "compressedTitanium",
                "craftingToolHardHammer",
                "craftingToolFile",
                "stickWood",
                null,
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.titanium_shovel", 1, 0, missing),
                "craftingToolFile",
                "compressedTitanium",
                "craftingToolHardHammer",
                null,
                "stickWood",
                null,
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.titanium_sword", 1, 0, missing),
                null,
                "compressedTitanium",
                null,
                "craftingToolFile",
                "compressedTitanium",
                "craftingToolHardHammer",
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.deshPick", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Ruby, 1L),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                "craftingToolFile",
                "stickDesh",
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                null,
                "stickDesh",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.deshAxe", 1, 0, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Ruby, 1L),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                "stickDesh",
                "craftingToolHardHammer",
                "craftingToolFile",
                "stickDesh",
                null);
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.deshHoe", 1, 0, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Ruby, 1L),
                "craftingToolFile",
                "stickDesh",
                "craftingToolHardHammer",
                null,
                "stickDesh",
                null);
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.deshSpade", 1, 0, missing),
                "craftingToolFile",
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Ruby, 1L),
                null,
                "stickDesh",
                "craftingToolHardHammer",
                null,
                "stickDesh",
                null);
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.deshSword", 1, 0, missing),
                null,
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Ruby, 1L),
                "craftingToolFile",
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                "craftingToolHardHammer",
                null,
                "stickDesh",
                null);
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.titanium_helmet", 1, 0, missing),
                "compressedTitanium",
                "compressedTitanium",
                "compressedTitanium",
                "compressedTitanium",
                "craftingToolHardHammer",
                "compressedTitanium",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.titanium_chestplate", 1, 0, missing),
                "compressedTitanium",
                "craftingToolHardHammer",
                "compressedTitanium",
                "compressedTitanium",
                "compressedTitanium",
                "compressedTitanium",
                "compressedTitanium",
                "compressedTitanium",
                "compressedTitanium");
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.titanium_leggings", 1, 0, missing),
                "compressedTitanium",
                "compressedTitanium",
                "compressedTitanium",
                "compressedTitanium",
                "craftingToolHardHammer",
                "compressedTitanium",
                "compressedTitanium",
                null,
                "compressedTitanium");
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.titanium_boots", 1, 0, missing),
                "compressedTitanium",
                null,
                "compressedTitanium",
                "compressedTitanium",
                "craftingToolHardHammer",
                "compressedTitanium",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing),
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                "compressedTin",
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                "compressedTin",
                "compressedSteel",
                "compressedTin",
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                "compressedTin",
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing));
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.airFan", 1, 0, missing),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                ItemList.Rotor_HV.get(1L),
                "stickLongStainlessSteel",
                ItemList.Rotor_HV.get(1L),
                "screwSteel",
                "craftingToolWrench",
                "screwSteel");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.oxygenConcentrator", 1, 0, missing),
                "compressedSteel",
                getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing),
                "compressedSteel",
                "compressedSteel",
                getModItem(GalacticraftCore.ID, "item.airFan", 1, 0, missing),
                "compressedSteel",
                getModItem(GalacticraftCore.ID, "item.canister", 1, 0, missing),
                ItemList.Electric_Pump_HV.get(1L),
                getModItem(GalacticraftCore.ID, "item.canister", 1, 0, missing));
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.oilExtractor", 1, 0, missing),
                "pipeTinySteel",
                "craftingToolScrewdriver",
                "screwStainlessSteel",
                "screwStainlessSteel",
                getModItem(GalacticraftCore.ID, "item.oilCanisterPartial", 1, 1001, missing),
                "compressedBronze",
                getModItem(ProjectRedIllumination.ID, "projectred.illumination.lightbutton", 1, 14, missing),
                "compressedBronze",
                "compressedBronze");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.buggymat", 1, 0, missing),
                "compressedSteel",
                "plateAnyRubber",
                "compressedSteel",
                "plateAnyRubber",
                "compressedTitanium",
                "plateAnyRubber",
                "compressedSteel",
                "plateAnyRubber",
                "compressedSteel");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.buggymat", 1, 1, missing),
                null,
                getModItem(IndustrialCraft2.ID, "blockRubber", 1, 0, missing),
                "compressedSteel",
                getModItem(IndustrialCraft2.ID, "blockRubber", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "blockRubber", 1, 0, missing),
                "compressedSteel",
                "compressedSteel",
                "compressedSteel",
                "compressedSteel");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.buggymat", 1, 2, missing),
                "compressedSteel",
                getModItem(IndustrialCraft2.ID, "blockRubber", 1, 0, missing),
                "compressedSteel",
                "compressedSteel",
                getModItem(IronChests.ID, "BlockIronChest", 1, 0, missing),
                "compressedSteel",
                "compressedSteel",
                "compressedSteel",
                "compressedSteel");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 19, missing),
                "compressedAluminium",
                ItemList.Sensor_HV.get(1L),
                "compressedAluminium",
                "waferBasic",
                ItemList.Cover_Screen.get(1L),
                "waferBasic",
                "compressedTin",
                ItemList.Battery_Hull_LV.get(1L),
                "compressedTin");
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "tile.walkway", 2, 0, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                null,
                "blockDesh",
                null,
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing));
        addShapelessRecipe(
                getModItem(GalacticraftMars.ID, "item.null", 1, 1, missing),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Desh, 1L));
        addShapelessRecipe(
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Desh, 1L),
                getModItem(GalacticraftMars.ID, "item.null", 1, 1, missing));
        addShapelessRecipe(
                getModItem(GalacticraftCore.ID, "item.battery", 1, wildcard, missing),
                ItemList.Battery_Hull_LV.get(1L));
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.standardWrench", 1, 0, missing),
                "plateSteel",
                "craftingToolSaw",
                "plateSteel",
                "screwSteel",
                "stickSteel",
                "screwSteel",
                "craftingToolScrewdriver",
                "stickSteel",
                "craftingToolFile");
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 8, missing),
                "ringRedAlloy",
                "compressedIron",
                "ringRedAlloy",
                "compressedIron",
                "lensDiamond",
                "compressedIron",
                "ringRedAlloy",
                "compressedIron",
                "ringRedAlloy");
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.null", 1, 6, missing),
                ItemList.Electric_Pump_HV.get(1L),
                GTOreDictUnificator.get(OrePrefixes.pipeQuadruple, Materials.Steel, 1L),
                ItemList.Electric_Pump_HV.get(1L),
                GTOreDictUnificator.get(OrePrefixes.pipeQuadruple, Materials.Steel, 1L),
                ItemList.Large_Fluid_Cell_Steel.get(1L),
                GTOreDictUnificator.get(OrePrefixes.pipeQuadruple, Materials.Steel, 1L),
                ItemList.Electric_Pump_HV.get(1L),
                GTOreDictUnificator.get(OrePrefixes.pipeQuadruple, Materials.Steel, 1L),
                ItemList.Electric_Pump_HV.get(1L));
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "tile.beamReflector", 1, 0, missing),
                "ringDesh",
                getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 8, missing),
                "ringDesh",
                "screwDesh",
                "stickDesh",
                "screwDesh",
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                "blockDesh",
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing));
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "tile.beamReceiver", 1, 0, missing),
                "compressedTin",
                "ringDesh",
                "compressedTin",
                "ringDesh",
                getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 8, missing),
                "ringDesh",
                "compressedTin",
                "ringDesh",
                "compressedTin");
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "tile.telepadShort", 1, 0, missing),
                "compressedTitanium",
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                "compressedTitanium",
                getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 8, missing),
                ItemList.Field_Generator_HV.get(1L),
                getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 8, missing),
                "compressedTitanium",
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                "compressedTitanium");
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "tile.marsMachine", 1, 4, missing),
                getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 0, missing),
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 2, missing),
                getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 0, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 3, missing),
                getModItem(CarpentersBlocks.ID, "itemCarpentersBed", 1, 0, missing),
                getModItem(GalacticraftMars.ID, "item.null", 1, 3, missing),
                getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 0, missing),
                getModItem(Minecraft.ID, "clock", 1, 0, missing),
                getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 0, missing));
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "tile.marsMachine", 1, 0, missing),
                "compressedTitanium",
                getModItem(GalacticraftCore.ID, "item.oxygenConcentrator", 1, 0, missing),
                "compressedTitanium",
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                ItemList.Casing_Gearbox_Titanium.get(1L),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                ItemList.Electric_Motor_HV.get(1L),
                getModItem(AE2FluidCraft.ID, "certus_quartz_tank", 1, 0, missing),
                ItemList.Electric_Pump_HV.get(1L));
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "tile.marsMachine", 1, 8, missing),
                "waferAdvanced",
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 19, missing),
                "waferAdvanced",
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                ItemList.Hull_HV.get(1L),
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                "cableGt02Aluminium",
                getModItem(GalacticraftMars.ID, "item.null", 1, 5, missing),
                "cableGt02Aluminium");
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.grapple", 1, 0, missing),
                null,
                null,
                createItemStack(
                        TinkersGregworks.ID,
                        "tGregToolPartArrowHead",
                        1,
                        1573,
                        "{material:\"MeteoricSteel\"}",
                        missing),
                CustomItemList.MeteoricIronString.get(1L),
                CustomItemList.MeteoricIronString.get(1L),
                CustomItemList.MeteoricIronString.get(1L),
                "springMeteoricSteel",
                null,
                null);
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "tile.minerBase", 4, 0, missing),
                "compressedTitanium",
                "chestSteel",
                "compressedTitanium",
                getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 8, missing),
                "frameGtTungsten",
                getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 8, missing),
                "compressedDesh",
                getModItem(GalacticraftCore.ID, "tile.machineTiered", 1, 0, missing),
                "compressedDesh");
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.orionDrive", 1, 0, missing),
                "compressedTitanium",
                getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 8, missing),
                "compressedTitanium",
                "circuitMaster",
                "oc:hdd3",
                "circuitMaster",
                "compressedSteel",
                getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 8, missing),
                "compressedSteel");
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.canvas", 1, 0, missing),
                null,
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                "stickPlastic",
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                "stickPlastic",
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                "stickPlastic",
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                null);
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 20, missing),
                "circuitAdvanced",
                getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing),
                "circuitAdvanced",
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 10, missing),
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 9, missing),
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 10, missing),
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 8, missing),
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 13, missing),
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 8, missing));
        addShapelessRecipe(
                getModItem(GalacticraftCore.ID, "item.schematic", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "item.schematic", 1, 1, missing));
        addShapelessRecipe(
                getModItem(GalacticraftCore.ID, "item.schematic", 1, 1, missing),
                getModItem(GalacticraftCore.ID, "item.schematic", 1, 0, missing));
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.schematic", 1, 1, missing),
                getModItem(GalacticraftMars.ID, "item.schematic", 1, 0, missing),
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.schematic", 1, 2, missing),
                null,
                getModItem(GalacticraftMars.ID, "item.schematic", 1, 0, missing),
                null,
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.schematic", 1, 0, missing),
                getModItem(GalacticraftMars.ID, "item.schematic", 1, 1, missing),
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.schematic", 1, 2, missing),
                null,
                getModItem(GalacticraftMars.ID, "item.schematic", 1, 1, missing),
                null,
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.schematic", 1, 0, missing),
                getModItem(GalacticraftMars.ID, "item.schematic", 1, 2, missing),
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(GalacticraftMars.ID, "item.schematic", 1, 1, missing),
                null,
                getModItem(GalacticraftMars.ID, "item.schematic", 1, 2, missing),
                null,
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(GalacticraftCore.ID, "item.parachute", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "item.canvas", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "item.canvas", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "item.canvas", 1, 0, missing),
                "wireFineSteel",
                null,
                "wireFineSteel",
                "wireFineSteel",
                "wireFineSteel",
                "wireFineSteel");
        addShapelessRecipe(
                getModItem(GalacticraftCore.ID, "item.meteoricIronRaw", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "item.meteoricIronRaw", 1, wildcard, missing));
        addShapelessRecipe(
                getModItem(GalacticraftCore.ID, "item.spaceship", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "item.spaceship", 1, wildcard, missing));
        addShapelessRecipe(
                getModItem(GalacticraftCore.ID, "item.buggy", 1, 0, missing),
                getModItem(GalacticraftCore.ID, "item.buggy", 1, wildcard, missing));
        addShapelessRecipe(
                getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 0, missing),
                getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 1, missing));
        addShapelessRecipe(
                getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 0, missing),
                getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 2, missing));
        addShapelessRecipe(
                getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 0, missing),
                getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 3, missing));
        addShapelessRecipe(
                getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, 0, missing),
                getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, wildcard, missing));
        addShapelessRecipe(
                getModItem(GalaxySpace.ID, "item.itemTier4Rocket", 1, 0, missing),
                getModItem(GalaxySpace.ID, "item.itemTier4Rocket", 1, wildcard, missing));
        addShapelessRecipe(
                getModItem(GalaxySpace.ID, "item.itemTier5Rocket", 1, 0, missing),
                getModItem(GalaxySpace.ID, "item.itemTier5Rocket", 1, wildcard, missing));
        addShapelessRecipe(
                getModItem(GalaxySpace.ID, "item.itemTier6Rocket", 1, 0, missing),
                getModItem(GalaxySpace.ID, "item.itemTier6Rocket", 1, wildcard, missing));
        addShapelessRecipe(
                getModItem(GalaxySpace.ID, "item.itemTier7Rocket", 1, 0, missing),
                getModItem(GalaxySpace.ID, "item.itemTier7Rocket", 1, wildcard, missing));
        addShapelessRecipe(
                getModItem(GalaxySpace.ID, "item.itemTier8Rocket", 1, 0, missing),
                getModItem(GalaxySpace.ID, "item.itemTier8Rocket", 1, wildcard, missing));
        addShapelessRecipe(
                getModItem(GalacticraftAmunRa.ID, "item.itemShuttle", 1, 0, missing),
                getModItem(GalacticraftAmunRa.ID, "item.itemShuttle", 1, wildcard, missing));
        addShapelessRecipe(
                getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 11, missing),
                getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 12, missing));
        addShapelessRecipe(
                getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 11, missing),
                getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 13, missing));

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
                CustomItemList.HeavyDutyPlateTier8.get(1L),
                'd',
                getModItem(GalacticraftCore.ID, "item.oxygenTankUltraHeavyFull", 1, WILDCARD, missing),
                'e',
                ItemList.Electric_Pump_ZPM.get(1L),
                'f',
                ItemList.Circuit_Board_Wetware_Extreme.get(1L),
                'g',
                "pipeSmallInfinity",
                'h',
                ItemList.Quantum_Tank_HV.get(1L));

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.cell, Materials.Oil, 1))
                .itemOutputs(ItemList.Cell_Empty.get(1)).metadata(FUEL_VALUE, 16).metadata(FUEL_TYPE, 0).duration(0)
                .eut(0).addTo(GTRecipeConstants.Fuel);

        arcFurnaceRecipes();
        assemblerRecipes();
        blastFurnaceRecipes();
        cannerRecipes();
        extruderRecipes();
        fluidCannerRecipes();
        maceratorRecipes();
        plasmaArcFurnaceRecipes();
        dungeonBlockRecipes();
        spaceStationRecipes();
        buggyRecipes();
        cargoRecipes();
        astroMinerRecipes();
    }

    private void arcFurnaceRecipes() {
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.spaceship", 1, 0, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy1.get(20L),
                        ItemList.Ingot_Heavy1.get(16L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 64L))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 2000))
                .duration(1 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.spaceship", 1, 1, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy1.get(20L),
                        ItemList.Ingot_Heavy1.get(16L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 64L))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 2000))
                .duration(1 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.spaceship", 1, 2, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy1.get(20L),
                        ItemList.Ingot_Heavy1.get(16L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 64L))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 2000))
                .duration(1 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.spaceship", 1, 3, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy1.get(20L),
                        ItemList.Ingot_Heavy1.get(16L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 64L))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 2000))
                .duration(1 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 0, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy2.get(10L),
                        ItemList.Ingot_Heavy1.get(41L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 64L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 6L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 4000))
                .duration(2 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 1, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy2.get(10L),
                        ItemList.Ingot_Heavy1.get(41L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 64L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 6L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 4000))
                .duration(2 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 2, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy2.get(10L),
                        ItemList.Ingot_Heavy1.get(41L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 64L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 6L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 4000))
                .duration(2 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 3, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy2.get(10L),
                        ItemList.Ingot_Heavy1.get(41L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 64L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 6L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 4000))
                .duration(2 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, 0, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy3.get(37L),
                        ItemList.Ingot_Heavy2.get(11L),
                        ItemList.Ingot_Heavy1.get(32L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 12L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 6000))
                .duration(3 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, 1, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy3.get(37L),
                        ItemList.Ingot_Heavy2.get(11L),
                        ItemList.Ingot_Heavy1.get(32L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 12L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 6000))
                .duration(3 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, 2, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy3.get(37L),
                        ItemList.Ingot_Heavy2.get(11L),
                        ItemList.Ingot_Heavy1.get(32L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 12L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 6000))
                .duration(3 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, 3, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy3.get(37L),
                        ItemList.Ingot_Heavy2.get(11L),
                        ItemList.Ingot_Heavy1.get(32L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 12L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 6000))
                .duration(3 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier4Rocket", 1, 0, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT4.get(12L),
                        ItemList.Ingot_Heavy3.get(40L),
                        ItemList.Ingot_Heavy2.get(16L),
                        ItemList.Ingot_Heavy1.get(52L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 8000))
                .duration(4 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier4Rocket", 1, 1, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT4.get(12L),
                        ItemList.Ingot_Heavy3.get(40L),
                        ItemList.Ingot_Heavy2.get(16L),
                        ItemList.Ingot_Heavy1.get(52L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 8000))
                .duration(4 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier4Rocket", 1, 2, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT4.get(12L),
                        ItemList.Ingot_Heavy3.get(40L),
                        ItemList.Ingot_Heavy2.get(16L),
                        ItemList.Ingot_Heavy1.get(52L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 8000))
                .duration(4 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier4Rocket", 1, 3, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT4.get(12L),
                        ItemList.Ingot_Heavy3.get(40L),
                        ItemList.Ingot_Heavy2.get(16L),
                        ItemList.Ingot_Heavy1.get(52L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 8000))
                .duration(4 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier5Rocket", 1, 0, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT5.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT4.get(14L),
                        ItemList.Ingot_Heavy3.get(64L),
                        ItemList.Ingot_Heavy3.get(8L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 10000))
                .duration(5 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier5Rocket", 1, 1, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT5.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT4.get(14L),
                        ItemList.Ingot_Heavy3.get(64L),
                        ItemList.Ingot_Heavy3.get(8L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 10000))
                .duration(5 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier5Rocket", 1, 2, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT5.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT4.get(14L),
                        ItemList.Ingot_Heavy3.get(64L),
                        ItemList.Ingot_Heavy3.get(8L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 10000))
                .duration(5 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier5Rocket", 1, 3, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT5.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT4.get(14L),
                        ItemList.Ingot_Heavy3.get(64L),
                        ItemList.Ingot_Heavy3.get(8L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 10000))
                .duration(5 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier6Rocket", 1, 0, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT6.get(12L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(62L),
                        CustomItemList.HeavyDutyAlloyIngotT4.get(16L),
                        ItemList.Ingot_Heavy3.get(64L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 12000))
                .duration(6 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier6Rocket", 1, 1, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT6.get(12L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(62L),
                        CustomItemList.HeavyDutyAlloyIngotT4.get(16L),
                        ItemList.Ingot_Heavy3.get(64L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 12000))
                .duration(6 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier6Rocket", 1, 2, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT6.get(12L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(62L),
                        CustomItemList.HeavyDutyAlloyIngotT4.get(16L),
                        ItemList.Ingot_Heavy3.get(64L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 12000))
                .duration(6 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier6Rocket", 1, 3, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT6.get(12L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(62L),
                        CustomItemList.HeavyDutyAlloyIngotT4.get(16L),
                        ItemList.Ingot_Heavy3.get(64L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 12000))
                .duration(6 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier7Rocket", 1, 0, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT7.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT6.get(18L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(50L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 14000))
                .duration(7 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier7Rocket", 1, 1, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT7.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT6.get(18L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(50L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 14000))
                .duration(7 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier7Rocket", 1, 2, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT7.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT6.get(18L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(50L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 14000))
                .duration(7 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier7Rocket", 1, 3, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT7.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT6.get(18L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(50L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 14000))
                .duration(7 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier8Rocket", 1, 0, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT8.get(18L),
                        CustomItemList.HeavyDutyAlloyIngotT7.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT7.get(53L),
                        CustomItemList.HeavyDutyAlloyIngotT6.get(20L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 16000))
                .duration(8 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier8Rocket", 1, 1, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT8.get(18L),
                        CustomItemList.HeavyDutyAlloyIngotT7.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT7.get(53L),
                        CustomItemList.HeavyDutyAlloyIngotT6.get(20L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 16000))
                .duration(8 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier8Rocket", 1, 2, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT8.get(18L),
                        CustomItemList.HeavyDutyAlloyIngotT7.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT7.get(53L),
                        CustomItemList.HeavyDutyAlloyIngotT6.get(20L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 16000))
                .duration(8 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier8Rocket", 1, 3, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT8.get(18L),
                        CustomItemList.HeavyDutyAlloyIngotT7.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT7.get(53L),
                        CustomItemList.HeavyDutyAlloyIngotT6.get(20L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 16000))
                .duration(8 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 11, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy2.get(6L),
                        ItemList.Ingot_Heavy1.get(24L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 40L),
                        getModItem(Minecraft.ID, "diamond", 4, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 4000))
                .duration(2 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 12, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy2.get(6L),
                        ItemList.Ingot_Heavy1.get(24L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 40L),
                        getModItem(Minecraft.ID, "diamond", 4, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 4000))
                .duration(2 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 13, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy2.get(6L),
                        ItemList.Ingot_Heavy1.get(24L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 40L),
                        getModItem(Minecraft.ID, "diamond", 4, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 4000))
                .duration(2 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemAstroMiner", 1, 0, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy3.get(3L),
                        ItemList.Ingot_Heavy2.get(8L),
                        ItemList.Ingot_Heavy1.get(3L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Titanium, 10L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 6000))
                .duration(3 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.buggy", 1, 0, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy1.get(11L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 5L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 21L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 4L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 6000))
                .duration(1 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.buggy", 1, 1, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy1.get(11L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 5L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 28L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 4L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 6000))
                .duration(1 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.buggy", 1, 2, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy1.get(11L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 5L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 35L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 4L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 6000))
                .duration(1 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.buggy", 1, 3, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy1.get(11L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 5L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 42L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 4L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("oxygen", 6000))
                .duration(1 * MINUTES).eut(30).recipeCategory(RecipeCategories.arcFurnaceRecycling)
                .addTo(arcFurnaceRecipes);
    }

    private void assemblerRecipes() {
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 8, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 8L),
                        CustomItemList.MeteoricIronString.get(8L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.silicone", 144)).duration(15 * SECONDS).eut(480)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Carbon, 1L),
                        getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(GalacticraftCore.ID, "tile.glowstoneTorch", 1, 0, missing))
                .duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "item.basicItem", 4, 9, missing),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 4L))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.oilCanisterPartial", 1, 1001, missing))
                .duration(10 * SECONDS).eut(64).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Copper, 4L))
                .itemOutputs(getModItem(GalacticraftMars.ID, "tile.hydrogenPipe", 1, 0, missing)).duration(20 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 5, 7, missing),
                        CustomItemList.MeteoricIronString.get(5L),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(getModItem(GalacticraftMars.ID, "item.thermalPadding", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.silicone", 720)).duration(37 * SECONDS + 10 * TICKS)
                .eut(1024).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftMars.ID, "item.thermalPadding", 1, 0, missing),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 5, 7, missing))
                .duration(9 * SECONDS).eut(256).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 8, 7, missing),
                        CustomItemList.MeteoricIronString.get(8L),
                        GTUtility.getIntegratedCircuit(8))
                .itemOutputs(getModItem(GalacticraftMars.ID, "item.thermalPadding", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.silicone", 1152)).duration(1 * MINUTES).eut(1024)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftMars.ID, "item.thermalPadding", 1, 1, missing),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 8, 7, missing))
                .duration(15 * SECONDS).eut(256).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 7, 7, missing),
                        CustomItemList.MeteoricIronString.get(7L),
                        GTUtility.getIntegratedCircuit(7))
                .itemOutputs(getModItem(GalacticraftMars.ID, "item.thermalPadding", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.silicone", 1008)).duration(52 * SECONDS + 10 * TICKS)
                .eut(1024).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftMars.ID, "item.thermalPadding", 1, 2, missing),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 7, 7, missing))
                .duration(13 * SECONDS).eut(256).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 4, 7, missing),
                        CustomItemList.MeteoricIronString.get(4L),
                        GTUtility.getIntegratedCircuit(4))
                .itemOutputs(getModItem(GalacticraftMars.ID, "item.thermalPadding", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.silicone", 576)).duration(30 * SECONDS).eut(1024)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftMars.ID, "item.thermalPadding", 1, 3, missing),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 4, 7, missing))
                .duration(7 * SECONDS + 10 * TICKS).eut(256).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemArmorHazmatHelmet", 1, 0, missing),
                        CustomItemList.ReinforcedGlassPLate.get(16L))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.oxygenMask", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 144)).duration(20 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemArmorHazmatHelmet", 1, 0, missing),
                        CustomItemList.ReinforcedGlassPLate.get(16L))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.oxygenMask", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 144)).duration(20 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemArmorHazmatHelmet", 1, 0, missing),
                        CustomItemList.ReinforcedGlassPLate.get(16L))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.oxygenMask", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 72)).duration(20 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Cover_SolarPanel.get(1L),
                        getModItem(GalacticraftCore.ID, "item.basicItem", 1, 9, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.basicItem", 1, 0, missing)).duration(10 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Plastic, 2L))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.canvas", 1, 0, missing)).duration(15 * SECONDS)
                .eut(480).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "item.canvas", 2, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Steel, 3L))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.parachute", 1, 0, missing)).duration(15 * SECONDS)
                .eut(480).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1, 0, missing),
                        getModItem(GalacticraftMars.ID, "tile.walkway", 1, 0, missing))
                .itemOutputs(getModItem(GalacticraftMars.ID, "tile.walkwayOxygenPipe", 1, 0, missing))
                .duration(1 * SECONDS).eut(120).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1, 0, missing),
                        getModItem(GalacticraftMars.ID, "tile.walkway", 1, 0, missing))
                .itemOutputs(getModItem(GalacticraftMars.ID, "tile.walkwayWire", 1, 0, missing)).duration(1 * SECONDS)
                .eut(120).addTo(assemblerRecipes);

        // Oxygen Vent
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "item.basicItem", 4, 7, missing),
                        getModItem(GalacticraftCore.ID, "item.basicItem", 1, 9, missing),
                        new ItemStack(Blocks.iron_bars, 4))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.airVent", 1, 0, missing)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
    }

    private void blastFurnaceRecipes() {
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 2, 4, missing))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Titanium, 1L))
                .duration(1 * MINUTES + 15 * SECONDS).eut(120).specialValue(1500).addTo(blastFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.meteoricIronRaw", 1, 0, missing))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 1L))
                .duration(1 * MINUTES).eut(120).specialValue(1000).addTo(blastFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "tile.fallenMeteor", 1, 0, missing))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 2L))
                .duration(1 * MINUTES).eut(120).specialValue(1000).addTo(blastFurnaceRecipes);
    }

    private void cannerRecipes() {
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "apple", 6, 0, missing),
                        getModItem(GalacticraftCore.ID, "item.canister", 1, 0, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.basicItem", 1, 15, missing)).duration(40 * SECONDS)
                .eut(1).addTo(cannerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carrot", 8, 0, missing),
                        getModItem(GalacticraftCore.ID, "item.canister", 1, 0, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.basicItem", 1, 16, missing)).duration(40 * SECONDS)
                .eut(1).addTo(cannerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "melon", 8, 0, missing),
                        getModItem(GalacticraftCore.ID, "item.canister", 1, 0, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.basicItem", 1, 17, missing)).duration(40 * SECONDS)
                .eut(1).addTo(cannerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "potato", 16, 0, missing),
                        getModItem(GalacticraftCore.ID, "item.canister", 1, 0, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.basicItem", 1, 18, missing)).duration(40 * SECONDS)
                .eut(1).addTo(cannerRecipes);
    }

    private void extruderRecipes() {
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockAlloyGlass", 1, 0, missing),
                        ItemList.Shape_Extruder_Pipe_Small.get(0L))
                .itemOutputs(getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 2, 0, missing)).duration(6 * SECONDS)
                .eut(120).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "item.basicItem", 1, 7, missing),
                        ItemList.Shape_Extruder_Cell.get(0L))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.canister", 1, 0, missing)).duration(6 * SECONDS)
                .eut(30).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "item.basicItem", 1, 6, missing),
                        ItemList.Shape_Extruder_Cell.get(0L))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.canister", 1, 1, missing)).duration(6 * SECONDS)
                .eut(30).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "item.basicItem", 2, 9, missing),
                        ItemList.Shape_Extruder_Bolt.get(0L))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.steelPole", 1, 0, missing)).duration(30 * SECONDS)
                .eut(30).addTo(extruderRecipes);
    }

    private void fluidCannerRecipes() {
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(GalacticraftCore.ID, "item.fuelCanisterPartial", 1, 1001, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.fuelCanisterPartial", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("fuel", 1000)).duration(16).eut(1).addTo(fluidCannerRecipes);
    }

    private void maceratorRecipes() {
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.null", 1, 0, missing))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Desh, 1L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "tile.fallenMeteor", 1, 0, missing))
                .itemOutputs(getModItem(GalacticraftCore.ID, "item.meteoricIronRaw", 2, 0, missing))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
    }

    private void plasmaArcFurnaceRecipes() {
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.spaceship", 1, 0, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy1.get(20L),
                        ItemList.Ingot_Heavy1.get(16L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 64L))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 8)).duration(3 * SECONDS + 5 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.spaceship", 1, 0, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy1.get(20L),
                        ItemList.Ingot_Heavy1.get(16L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 64L))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 3))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 3)).duration(3 * SECONDS + 5 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.spaceship", 1, 1, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy1.get(20L),
                        ItemList.Ingot_Heavy1.get(16L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 64L))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 8)).duration(3 * SECONDS + 5 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.spaceship", 1, 1, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy1.get(20L),
                        ItemList.Ingot_Heavy1.get(16L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 64L))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 3))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 3)).duration(3 * SECONDS + 5 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.spaceship", 1, 2, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy1.get(20L),
                        ItemList.Ingot_Heavy1.get(16L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 64L))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 8)).duration(3 * SECONDS + 5 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.spaceship", 1, 2, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy1.get(20L),
                        ItemList.Ingot_Heavy1.get(16L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 64L))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 3))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 3)).duration(3 * SECONDS + 5 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.spaceship", 1, 3, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy1.get(20L),
                        ItemList.Ingot_Heavy1.get(16L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 64L))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 8)).duration(3 * SECONDS + 5 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.spaceship", 1, 3, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy1.get(20L),
                        ItemList.Ingot_Heavy1.get(16L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 64L))
                .outputChances(10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 3))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 3)).duration(3 * SECONDS + 5 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 0, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy2.get(10L),
                        ItemList.Ingot_Heavy1.get(41L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 64L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 6L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 17)).duration(6 * SECONDS + 10 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 0, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy2.get(10L),
                        ItemList.Ingot_Heavy1.get(41L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 64L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 6L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 6))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 6)).duration(6 * SECONDS + 10 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 1, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy2.get(10L),
                        ItemList.Ingot_Heavy1.get(41L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 64L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 6L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 17)).duration(6 * SECONDS + 10 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 1, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy2.get(10L),
                        ItemList.Ingot_Heavy1.get(41L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 64L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 6L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 6))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 6)).duration(6 * SECONDS + 10 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 2, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy2.get(10L),
                        ItemList.Ingot_Heavy1.get(41L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 64L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 6L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 17)).duration(6 * SECONDS + 10 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 2, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy2.get(10L),
                        ItemList.Ingot_Heavy1.get(41L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 64L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 6L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 6))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 6)).duration(6 * SECONDS + 10 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 3, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy2.get(10L),
                        ItemList.Ingot_Heavy1.get(41L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 64L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 6L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 17)).duration(6 * SECONDS + 10 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 3, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy2.get(10L),
                        ItemList.Ingot_Heavy1.get(41L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 64L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 6L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 6))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 6)).duration(6 * SECONDS + 10 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, 0, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy3.get(37L),
                        ItemList.Ingot_Heavy2.get(11L),
                        ItemList.Ingot_Heavy1.get(32L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 12L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 26))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 26)).duration(10 * SECONDS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, 0, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy3.get(37L),
                        ItemList.Ingot_Heavy2.get(11L),
                        ItemList.Ingot_Heavy1.get(32L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 12L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 8)).duration(10 * SECONDS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, 1, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy3.get(37L),
                        ItemList.Ingot_Heavy2.get(11L),
                        ItemList.Ingot_Heavy1.get(32L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 12L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 26))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 26)).duration(10 * SECONDS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, 1, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy3.get(37L),
                        ItemList.Ingot_Heavy2.get(11L),
                        ItemList.Ingot_Heavy1.get(32L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 12L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 8)).duration(10 * SECONDS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, 2, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy3.get(37L),
                        ItemList.Ingot_Heavy2.get(11L),
                        ItemList.Ingot_Heavy1.get(32L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 12L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 26))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 26)).duration(10 * SECONDS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, 2, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy3.get(37L),
                        ItemList.Ingot_Heavy2.get(11L),
                        ItemList.Ingot_Heavy1.get(32L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 12L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 8)).duration(10 * SECONDS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, 3, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy3.get(37L),
                        ItemList.Ingot_Heavy2.get(11L),
                        ItemList.Ingot_Heavy1.get(32L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 12L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 26))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 26)).duration(10 * SECONDS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemTier3Rocket", 1, 3, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy3.get(37L),
                        ItemList.Ingot_Heavy2.get(11L),
                        ItemList.Ingot_Heavy1.get(32L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 12L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 8)).duration(10 * SECONDS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier4Rocket", 1, 0, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT4.get(12L),
                        ItemList.Ingot_Heavy3.get(40L),
                        ItemList.Ingot_Heavy2.get(16L),
                        ItemList.Ingot_Heavy1.get(52L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 35))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 35)).duration(13 * SECONDS + 6 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier4Rocket", 1, 0, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT4.get(12L),
                        ItemList.Ingot_Heavy3.get(40L),
                        ItemList.Ingot_Heavy2.get(16L),
                        ItemList.Ingot_Heavy1.get(52L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 11))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 11)).duration(13 * SECONDS + 6 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier4Rocket", 1, 1, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT4.get(12L),
                        ItemList.Ingot_Heavy3.get(40L),
                        ItemList.Ingot_Heavy2.get(16L),
                        ItemList.Ingot_Heavy1.get(52L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 35))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 35)).duration(13 * SECONDS + 6 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier4Rocket", 1, 1, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT4.get(12L),
                        ItemList.Ingot_Heavy3.get(40L),
                        ItemList.Ingot_Heavy2.get(16L),
                        ItemList.Ingot_Heavy1.get(52L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 11))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 11)).duration(13 * SECONDS + 6 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier4Rocket", 1, 2, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT4.get(12L),
                        ItemList.Ingot_Heavy3.get(40L),
                        ItemList.Ingot_Heavy2.get(16L),
                        ItemList.Ingot_Heavy1.get(52L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 35))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 35)).duration(13 * SECONDS + 6 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier4Rocket", 1, 2, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT4.get(12L),
                        ItemList.Ingot_Heavy3.get(40L),
                        ItemList.Ingot_Heavy2.get(16L),
                        ItemList.Ingot_Heavy1.get(52L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 11))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 11)).duration(13 * SECONDS + 6 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier4Rocket", 1, 3, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT4.get(12L),
                        ItemList.Ingot_Heavy3.get(40L),
                        ItemList.Ingot_Heavy2.get(16L),
                        ItemList.Ingot_Heavy1.get(52L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 35))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 35)).duration(13 * SECONDS + 6 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier4Rocket", 1, 3, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT4.get(12L),
                        ItemList.Ingot_Heavy3.get(40L),
                        ItemList.Ingot_Heavy2.get(16L),
                        ItemList.Ingot_Heavy1.get(52L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 11))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 11)).duration(13 * SECONDS + 6 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier5Rocket", 1, 0, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT5.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT4.get(14L),
                        ItemList.Ingot_Heavy3.get(64L),
                        ItemList.Ingot_Heavy3.get(8L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 43))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 43)).duration(16 * SECONDS + 13 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier5Rocket", 1, 0, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT5.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT4.get(14L),
                        ItemList.Ingot_Heavy3.get(64L),
                        ItemList.Ingot_Heavy3.get(8L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 14))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 14)).duration(16 * SECONDS + 13 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier5Rocket", 1, 1, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT5.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT4.get(14L),
                        ItemList.Ingot_Heavy3.get(64L),
                        ItemList.Ingot_Heavy3.get(8L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 43))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 43)).duration(16 * SECONDS + 13 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier5Rocket", 1, 1, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT5.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT4.get(14L),
                        ItemList.Ingot_Heavy3.get(64L),
                        ItemList.Ingot_Heavy3.get(8L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 14))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 14)).duration(16 * SECONDS + 13 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier5Rocket", 1, 2, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT5.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT4.get(14L),
                        ItemList.Ingot_Heavy3.get(64L),
                        ItemList.Ingot_Heavy3.get(8L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 43))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 43)).duration(16 * SECONDS + 13 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier5Rocket", 1, 2, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT5.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT4.get(14L),
                        ItemList.Ingot_Heavy3.get(64L),
                        ItemList.Ingot_Heavy3.get(8L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 14))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 14)).duration(16 * SECONDS + 13 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier5Rocket", 1, 3, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT5.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT4.get(14L),
                        ItemList.Ingot_Heavy3.get(64L),
                        ItemList.Ingot_Heavy3.get(8L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 43))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 43)).duration(16 * SECONDS + 13 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier5Rocket", 1, 3, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT5.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT4.get(14L),
                        ItemList.Ingot_Heavy3.get(64L),
                        ItemList.Ingot_Heavy3.get(8L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 14))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 14)).duration(16 * SECONDS + 13 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier6Rocket", 1, 0, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT6.get(12L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(62L),
                        CustomItemList.HeavyDutyAlloyIngotT4.get(16L),
                        ItemList.Ingot_Heavy3.get(64L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 52))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 52)).duration(20 * SECONDS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier6Rocket", 1, 0, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT6.get(12L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(62L),
                        CustomItemList.HeavyDutyAlloyIngotT4.get(16L),
                        ItemList.Ingot_Heavy3.get(64L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 17)).duration(20 * SECONDS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier6Rocket", 1, 1, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT6.get(12L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(62L),
                        CustomItemList.HeavyDutyAlloyIngotT4.get(16L),
                        ItemList.Ingot_Heavy3.get(64L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 52))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 52)).duration(20 * SECONDS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier6Rocket", 1, 1, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT6.get(12L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(62L),
                        CustomItemList.HeavyDutyAlloyIngotT4.get(16L),
                        ItemList.Ingot_Heavy3.get(64L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 17)).duration(20 * SECONDS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier6Rocket", 1, 2, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT6.get(12L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(62L),
                        CustomItemList.HeavyDutyAlloyIngotT4.get(16L),
                        ItemList.Ingot_Heavy3.get(64L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 52))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 52)).duration(20 * SECONDS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier6Rocket", 1, 2, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT6.get(12L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(62L),
                        CustomItemList.HeavyDutyAlloyIngotT4.get(16L),
                        ItemList.Ingot_Heavy3.get(64L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 17)).duration(20 * SECONDS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier6Rocket", 1, 3, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT6.get(12L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(62L),
                        CustomItemList.HeavyDutyAlloyIngotT4.get(16L),
                        ItemList.Ingot_Heavy3.get(64L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 52))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 52)).duration(20 * SECONDS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier6Rocket", 1, 3, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT6.get(12L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(62L),
                        CustomItemList.HeavyDutyAlloyIngotT4.get(16L),
                        ItemList.Ingot_Heavy3.get(64L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 17)).duration(20 * SECONDS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier7Rocket", 1, 0, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT7.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT6.get(18L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(50L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 61))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 61)).duration(23 * SECONDS + 6 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier7Rocket", 1, 0, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT7.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT6.get(18L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(50L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 19))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 19)).duration(23 * SECONDS + 6 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier7Rocket", 1, 1, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT7.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT6.get(18L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(50L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 61))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 61)).duration(23 * SECONDS + 6 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier7Rocket", 1, 1, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT7.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT6.get(18L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(50L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 19))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 19)).duration(23 * SECONDS + 6 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier7Rocket", 1, 2, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT7.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT6.get(18L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(50L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 61))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 61)).duration(23 * SECONDS + 6 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier7Rocket", 1, 2, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT7.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT6.get(18L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(50L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 19))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 19)).duration(23 * SECONDS + 6 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier7Rocket", 1, 3, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT7.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT6.get(18L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(50L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 61))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 61)).duration(23 * SECONDS + 6 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier7Rocket", 1, 3, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT7.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT6.get(18L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT5.get(50L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 19))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 19)).duration(23 * SECONDS + 6 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier8Rocket", 1, 0, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT8.get(18L),
                        CustomItemList.HeavyDutyAlloyIngotT7.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT7.get(53L),
                        CustomItemList.HeavyDutyAlloyIngotT6.get(20L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 70))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 70)).duration(26 * SECONDS + 13 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier8Rocket", 1, 0, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT8.get(18L),
                        CustomItemList.HeavyDutyAlloyIngotT7.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT7.get(53L),
                        CustomItemList.HeavyDutyAlloyIngotT6.get(20L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 22))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 22)).duration(26 * SECONDS + 13 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier8Rocket", 1, 1, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT8.get(18L),
                        CustomItemList.HeavyDutyAlloyIngotT7.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT7.get(53L),
                        CustomItemList.HeavyDutyAlloyIngotT6.get(20L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 70))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 70)).duration(26 * SECONDS + 13 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier8Rocket", 1, 1, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT8.get(18L),
                        CustomItemList.HeavyDutyAlloyIngotT7.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT7.get(53L),
                        CustomItemList.HeavyDutyAlloyIngotT6.get(20L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 22))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 22)).duration(26 * SECONDS + 13 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier8Rocket", 1, 2, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT8.get(18L),
                        CustomItemList.HeavyDutyAlloyIngotT7.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT7.get(53L),
                        CustomItemList.HeavyDutyAlloyIngotT6.get(20L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 70))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 70)).duration(26 * SECONDS + 13 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier8Rocket", 1, 2, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT8.get(18L),
                        CustomItemList.HeavyDutyAlloyIngotT7.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT7.get(53L),
                        CustomItemList.HeavyDutyAlloyIngotT6.get(20L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 22))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 22)).duration(26 * SECONDS + 13 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier8Rocket", 1, 3, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT8.get(18L),
                        CustomItemList.HeavyDutyAlloyIngotT7.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT7.get(53L),
                        CustomItemList.HeavyDutyAlloyIngotT6.get(20L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 70))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 70)).duration(26 * SECONDS + 13 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.Tier8Rocket", 1, 3, missing))
                .itemOutputs(
                        CustomItemList.HeavyDutyAlloyIngotT8.get(18L),
                        CustomItemList.HeavyDutyAlloyIngotT7.get(64L),
                        CustomItemList.HeavyDutyAlloyIngotT7.get(53L),
                        CustomItemList.HeavyDutyAlloyIngotT6.get(20L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 22))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 22)).duration(26 * SECONDS + 13 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 11, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy2.get(6L),
                        ItemList.Ingot_Heavy1.get(24L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 40L),
                        getModItem(Minecraft.ID, "diamond", 4, 0, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 17)).duration(6 * SECONDS + 10 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 11, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy2.get(6L),
                        ItemList.Ingot_Heavy1.get(24L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 40L),
                        getModItem(Minecraft.ID, "diamond", 4, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 6))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 6)).duration(6 * SECONDS + 10 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 12, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy2.get(6L),
                        ItemList.Ingot_Heavy1.get(24L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 40L),
                        getModItem(Minecraft.ID, "diamond", 4, 0, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 17)).duration(6 * SECONDS + 10 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 12, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy2.get(6L),
                        ItemList.Ingot_Heavy1.get(24L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 40L),
                        getModItem(Minecraft.ID, "diamond", 4, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 6))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 6)).duration(6 * SECONDS + 10 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 13, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy2.get(6L),
                        ItemList.Ingot_Heavy1.get(24L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 40L),
                        getModItem(Minecraft.ID, "diamond", 4, 0, missing))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 17))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 17)).duration(6 * SECONDS + 10 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.spaceshipTier2", 1, 13, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy2.get(6L),
                        ItemList.Ingot_Heavy1.get(24L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 40L),
                        getModItem(Minecraft.ID, "diamond", 4, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 6))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 6)).duration(6 * SECONDS + 10 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemAstroMiner", 1, 0, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy3.get(3L),
                        ItemList.Ingot_Heavy2.get(8L),
                        ItemList.Ingot_Heavy1.get(3L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Titanium, 10L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 26))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 26)).duration(10 * SECONDS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "item.itemAstroMiner", 1, 0, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy3.get(3L),
                        ItemList.Ingot_Heavy2.get(8L),
                        ItemList.Ingot_Heavy1.get(3L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Titanium, 10L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 8)).duration(10 * SECONDS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.buggy", 1, 0, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy1.get(11L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 5L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 21L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 4L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 8)).duration(3 * SECONDS + 5 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.buggy", 1, 0, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy1.get(11L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 5L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 21L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 4L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 3))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 3)).duration(3 * SECONDS + 5 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.buggy", 1, 1, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy1.get(11L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 5L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 28L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 4L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 8)).duration(3 * SECONDS + 5 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.buggy", 1, 1, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy1.get(11L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 5L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 28L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 4L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 3))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 3)).duration(3 * SECONDS + 5 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.buggy", 1, 2, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy1.get(11L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 5L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 35L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 4L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 8)).duration(3 * SECONDS + 5 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.buggy", 1, 2, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy1.get(11L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 5L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 35L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 4L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 3))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 3)).duration(3 * SECONDS + 5 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.buggy", 1, 3, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy1.get(11L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 5L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 42L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 4L))
                .outputChances(10000, 10000, 10000, 10000)
                .fluidInputs(FluidRegistry.getFluidStack("plasma.nitrogen", 8))
                .fluidOutputs(FluidRegistry.getFluidStack("nitrogen", 8)).duration(3 * SECONDS + 5 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.buggy", 1, 3, missing))
                .itemOutputs(
                        ItemList.Ingot_Heavy1.get(11L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 5L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 42L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 4L))
                .outputChances(10000, 10000, 10000, 10000).fluidInputs(FluidRegistry.getFluidStack("plasma.argon", 3))
                .fluidOutputs(FluidRegistry.getFluidStack("argon", 3)).duration(3 * SECONDS + 5 * TICKS).eut(30)
                .addTo(plasmaArcFurnaceRecipes);

    }

    private void dungeonBlockRecipes() {
        // Dungeon blocks
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTModHandler.getModItem(GalacticraftCore.ID, "tile.moonBlock", 4, 4),
                        CustomItemList.ReinforcedGlassLense.get(0))
                .itemOutputs(GTModHandler.getModItem(GalacticraftCore.ID, "tile.moonBlock", 1, 14))
                .duration(4 * SECONDS).eut(TierEU.RECIPE_HV).addTo(laserEngraverRecipes);

        for (ItemStack lens : GTOreDictUnificator.getOres("craftingLensRed")) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTModHandler.getModItem(GalacticraftMars.ID, "tile.mars", 4, 9),
                            GTUtility.copyAmount(0, lens))
                    .itemOutputs(GTModHandler.getModItem(GalacticraftMars.ID, "tile.mars", 1, 7)).duration(4 * SECONDS)
                    .eut(TierEU.RECIPE_EV).addTo(laserEngraverRecipes);
        }
        for (ItemStack lens : GTOreDictUnificator.getOres("craftingLensCyan")) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTModHandler.getModItem(GalaxySpace.ID, "ceresblocks", 4, 1),
                            GTUtility.copyAmount(0, lens))
                    .itemOutputs(GTModHandler.getModItem(GalaxySpace.ID, "ceresblocks", 1, 2)).duration(4 * SECONDS)
                    .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);
        }
        for (ItemStack lens : GTOreDictUnificator.getOres("craftingLensYellow")) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTModHandler.getModItem(GalaxySpace.ID, "ioblocks", 4, 2),
                            GTUtility.copyAmount(0, lens))
                    .itemOutputs(GTModHandler.getModItem(GalaxySpace.ID, "ioblocks", 1, 3)).duration(4 * SECONDS)
                    .eut(TierEU.RECIPE_LuV).addTo(laserEngraverRecipes);
        }
        for (ItemStack lens : GTOreDictUnificator.getOres("craftingLensWhite")) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTModHandler.getModItem(GalaxySpace.ID, "enceladusblocks", 4, 1),
                            GTUtility.copyAmount(0, lens))
                    .itemOutputs(GTModHandler.getModItem(GalaxySpace.ID, "enceladusblocks", 1, 2)).duration(4 * SECONDS)
                    .eut(TierEU.RECIPE_ZPM).addTo(laserEngraverRecipes);
        }
        for (ItemStack lens : GTOreDictUnificator.getOres("craftingLensLightGray")) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTModHandler.getModItem(GalaxySpace.ID, "proteusblocks", 4, 2),
                            GTUtility.copyAmount(0, lens))
                    .itemOutputs(GTModHandler.getModItem(GalaxySpace.ID, "proteusblocks", 1, 3)).duration(4 * SECONDS)
                    .eut(TierEU.RECIPE_UV).addTo(laserEngraverRecipes);
        }
        for (ItemStack lens : GTOreDictUnificator.getOres("craftingLensBrown")) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTModHandler.getModItem(GalaxySpace.ID, "plutoblocks", 4, 5),
                            GTUtility.copyAmount(0, lens))
                    .itemOutputs(GTModHandler.getModItem(GalaxySpace.ID, "plutoblocks", 1, 6)).duration(4 * SECONDS)
                    .eut(TierEU.RECIPE_UHV).addTo(laserEngraverRecipes);
        }

        // Special dungeon blocks
        addShapedRecipe(
                GTModHandler.getModItem(GalaxySpace.ID, "ceresblocks", 4, 4),
                GTModHandler.getModItem(GalaxySpace.ID, "ceresblocks", 1, 2),
                GTModHandler.getModItem(GalaxySpace.ID, "ceresblocks", 1, 2),
                null,
                GTModHandler.getModItem(GalaxySpace.ID, "ceresblocks", 1, 2),
                GTModHandler.getModItem(GalaxySpace.ID, "ceresblocks", 1, 2),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                GTModHandler.getModItem(GalaxySpace.ID, "ceresblocks", 4, 5),
                GTModHandler.getModItem(GalaxySpace.ID, "ceresblocks", 1, 4),
                GTModHandler.getModItem(GalaxySpace.ID, "ceresblocks", 1, 4),
                null,
                GTModHandler.getModItem(GalaxySpace.ID, "ceresblocks", 1, 4),
                GTModHandler.getModItem(GalaxySpace.ID, "ceresblocks", 1, 4),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                GTModHandler.getModItem(GalaxySpace.ID, "ceresblocks", 4, 2),
                GTModHandler.getModItem(GalaxySpace.ID, "ceresblocks", 1, 5),
                GTModHandler.getModItem(GalaxySpace.ID, "ceresblocks", 1, 5),
                null,
                GTModHandler.getModItem(GalaxySpace.ID, "ceresblocks", 1, 5),
                GTModHandler.getModItem(GalaxySpace.ID, "ceresblocks", 1, 5),
                null,
                null,
                null,
                null);

        addShapedRecipe(
                GTModHandler.getModItem(GalaxySpace.ID, "ioblocks", 4, 8),
                GTModHandler.getModItem(GalaxySpace.ID, "ioblocks", 1, 3),
                GTModHandler.getModItem(GalaxySpace.ID, "ioblocks", 1, 3),
                null,
                GTModHandler.getModItem(GalaxySpace.ID, "ioblocks", 1, 3),
                GTModHandler.getModItem(GalaxySpace.ID, "ioblocks", 1, 3),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                GTModHandler.getModItem(GalaxySpace.ID, "ioblocks", 4, 7),
                GTModHandler.getModItem(GalaxySpace.ID, "ioblocks", 1, 8),
                GTModHandler.getModItem(GalaxySpace.ID, "ioblocks", 1, 8),
                null,
                GTModHandler.getModItem(GalaxySpace.ID, "ioblocks", 1, 8),
                GTModHandler.getModItem(GalaxySpace.ID, "ioblocks", 1, 8),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                GTModHandler.getModItem(GalaxySpace.ID, "ioblocks", 4, 3),
                GTModHandler.getModItem(GalaxySpace.ID, "ioblocks", 1, 7),
                GTModHandler.getModItem(GalaxySpace.ID, "ioblocks", 1, 7),
                null,
                GTModHandler.getModItem(GalaxySpace.ID, "ioblocks", 1, 7),
                GTModHandler.getModItem(GalaxySpace.ID, "ioblocks", 1, 7),
                null,
                null,
                null,
                null);

        // Glowstone dusts
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 2),
                        NHItemList.CeresStoneDust.getIS(2),
                        GTUtility.getIntegratedCircuit(8))
                .itemOutputs(GTModHandler.getModItem(GalaxySpace.ID, "item.GlowstoneDusts", 1, 0)).duration(4 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 2),
                        NHItemList.IoStoneDust.getIS(2),
                        GTUtility.getIntegratedCircuit(8))
                .itemOutputs(GTModHandler.getModItem(GalaxySpace.ID, "item.GlowstoneDusts", 1, 1)).duration(4 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 2),
                        NHItemList.EnceladusStoneDust.getIS(2),
                        GTUtility.getIntegratedCircuit(8))
                .itemOutputs(GTModHandler.getModItem(GalaxySpace.ID, "item.GlowstoneDusts", 1, 2)).duration(4 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 2),
                        NHItemList.ProteusStoneDust.getIS(2),
                        GTUtility.getIntegratedCircuit(8))
                .itemOutputs(GTModHandler.getModItem(GalaxySpace.ID, "item.GlowstoneDusts", 1, 3)).duration(4 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 2),
                        NHItemList.PlutoStoneDust.getIS(2),
                        GTUtility.getIntegratedCircuit(8))
                .itemOutputs(GTModHandler.getModItem(GalaxySpace.ID, "item.GlowstoneDusts", 1, 4)).duration(4 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(mixerRecipes);
    }

    @Optional.Method(modid = Mods.ModIDs.GALACTICRAFT_CORE)
    private static void spaceStationRecipes() {
        final HashMap<Object, Integer> inputMap = new HashMap<>();
        inputMap.put(new ItemStack(GCBlocks.basicBlock, 1, 4), 231);
        inputMap.put(new ItemStack(Blocks.glass_pane), 6);
        inputMap.put("circuitAdvanced", 4);
        inputMap.put(ItemList.Hull_HV.get(1), 1);
        GalacticraftRegistry.registerSpaceStation(
                new SpaceStationType(ConfigManagerCore.idDimensionOverworldOrbit, 0, new SpaceStationRecipe(inputMap)));
    }

    @Optional.Method(modid = Mods.ModIDs.GALACTICRAFT_CORE)
    private static void buggyRecipes() {
        HashMap<Integer, ItemStack> input = new HashMap<>();
        HashMap<Integer, ItemStack> input2;
        input.put(1, new ItemStack(GCItems.basicItem, 1, 19));
        input.put(2, new ItemStack(GCItems.partBuggy, 1, 1));
        if (GalaxySpace.isModLoaded()) {
            input.put(3, getModItem(GalaxySpace.ID, "item.RocketControlComputer", 1, 100));
        }
        for (int i = 4; i <= 7; i++) {
            input.put(i, new ItemStack(GCItems.partBuggy));
        }
        for (int i = 8; i <= 11; i++) {
            input.put(i, GTOreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 1));
        }
        for (int i = 12; i <= 16; i++) {
            input.put(i, new ItemStack(GCItems.meteoricIronIngot, 1, 1));
        }
        for (int i = 17; i <= 24; i++) {
            input.put(i, GTOreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1));
        }
        for (int i = 25; i <= 34; i++) {
            input.put(i, new ItemStack(GCItems.heavyPlatingTier1));
        }

        input2 = new HashMap<>(input);
        input2.put(35, null);
        RecipeUtil.addBuggyBenchRecipe(new ItemStack(GCItems.buggy, 1, 0), input2);

        input2 = new HashMap<>(input);
        input2.put(35, RecipeUtil.getChestItemStack(1, 3));
        RecipeUtil.addBuggyBenchRecipe(new ItemStack(GCItems.buggy, 1, 1), input2);

        input2 = new HashMap<>(input);
        input2.put(35, RecipeUtil.getChestItemStack(1, 0));
        RecipeUtil.addBuggyBenchRecipe(new ItemStack(GCItems.buggy, 1, 2), input2);

        input2 = new HashMap<>(input);
        input2.put(35, RecipeUtil.getChestItemStack(1, 1));
        RecipeUtil.addBuggyBenchRecipe(new ItemStack(GCItems.buggy, 1, 3), input2);

        // NEI Integration
        NEIGalacticraftConfig instance = new NEIGalacticraftConfig();
        final int x = BuggyRecipeHandler.tX - BuggyRecipeHandler.x;
        final int y = BuggyRecipeHandler.tY - BuggyRecipeHandler.y;
        final HashMap<Integer, PositionedStack> input3 = new HashMap<>();
        input3.put(1, new PositionedStack(new ItemStack(GCItems.basicItem, 1, 19), 62 - x, 19 - y));
        input3.put(2, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 1), 62 - x, 55 - y));
        if (GalaxySpace.isModLoaded()) {
            input3.put(
                    3,
                    new PositionedStack(
                            getModItem(GalaxySpace.ID, "item.RocketControlComputer", 1, 100),
                            62 - x,
                            73 - y));
        }
        input3.put(4, new PositionedStack(new ItemStack(GCItems.partBuggy), 8 - x, 19 - y));
        input3.put(5, new PositionedStack(new ItemStack(GCItems.partBuggy), 116 - x, 19 - y));
        input3.put(6, new PositionedStack(new ItemStack(GCItems.partBuggy), 8 - x, 109 - y));
        input3.put(7, new PositionedStack(new ItemStack(GCItems.partBuggy), 116 - x, 109 - y));
        input3.put(
                8,
                new PositionedStack(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 1),
                        26 - x,
                        19 - y));
        input3.put(
                9,
                new PositionedStack(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 1),
                        98 - x,
                        19 - y));
        input3.put(
                10,
                new PositionedStack(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 1),
                        26 - x,
                        109 - y));
        input3.put(
                11,
                new PositionedStack(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 1),
                        98 - x,
                        109 - y));
        input3.put(12, new PositionedStack(new ItemStack(GCItems.meteoricIronIngot, 1, 1), 44 - x, 19 - y));
        input3.put(13, new PositionedStack(new ItemStack(GCItems.meteoricIronIngot, 1, 1), 80 - x, 19 - y));
        input3.put(14, new PositionedStack(new ItemStack(GCItems.meteoricIronIngot, 1, 1), 44 - x, 109 - y));
        input3.put(15, new PositionedStack(new ItemStack(GCItems.meteoricIronIngot, 1, 1), 62 - x, 109 - y));
        input3.put(16, new PositionedStack(new ItemStack(GCItems.meteoricIronIngot, 1, 1), 80 - x, 109 - y));
        input3.put(
                17,
                new PositionedStack(
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                        8 - x,
                        37 - y));
        input3.put(
                18,
                new PositionedStack(
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                        26 - x,
                        37 - y));
        input3.put(
                19,
                new PositionedStack(
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                        98 - x,
                        37 - y));
        input3.put(
                20,
                new PositionedStack(
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                        116 - x,
                        37 - y));
        input3.put(
                21,
                new PositionedStack(
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                        8 - x,
                        91 - y));
        input3.put(
                22,
                new PositionedStack(
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                        26 - x,
                        91 - y));
        input3.put(
                23,
                new PositionedStack(
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                        98 - x,
                        91 - y));
        input3.put(
                24,
                new PositionedStack(
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                        116 - x,
                        91 - y));
        input3.put(25, new PositionedStack(new ItemStack(GCItems.heavyPlatingTier1), 44 - x, 37 - y));
        input3.put(26, new PositionedStack(new ItemStack(GCItems.heavyPlatingTier1), 62 - x, 37 - y));
        input3.put(27, new PositionedStack(new ItemStack(GCItems.heavyPlatingTier1), 80 - x, 37 - y));
        input3.put(28, new PositionedStack(new ItemStack(GCItems.heavyPlatingTier1), 44 - x, 55 - y));
        input3.put(29, new PositionedStack(new ItemStack(GCItems.heavyPlatingTier1), 80 - x, 55 - y));
        input3.put(30, new PositionedStack(new ItemStack(GCItems.heavyPlatingTier1), 44 - x, 73 - y));
        input3.put(31, new PositionedStack(new ItemStack(GCItems.heavyPlatingTier1), 80 - x, 73 - y));
        input3.put(32, new PositionedStack(new ItemStack(GCItems.heavyPlatingTier1), 44 - x, 91 - y));
        input3.put(33, new PositionedStack(new ItemStack(GCItems.heavyPlatingTier1), 62 - x, 91 - y));
        input3.put(34, new PositionedStack(new ItemStack(GCItems.heavyPlatingTier1), 80 - x, 91 - y));
        instance.registerBuggyBenchRecipe(input3, new PositionedStack(new ItemStack(GCItems.buggy), 143 - x, 64 - y));
        HashMap<Integer, PositionedStack> input4 = new HashMap<>(input3);
        input4.put(35, new PositionedStack(RecipeUtil.getChestItemStack(1, 3), 107 - x, 64 - y));
        instance.registerBuggyBenchRecipe(
                input4,
                new PositionedStack(new ItemStack(GCItems.buggy, 1, 1), 143 - x, 64 - y));
        input4 = new HashMap<>(input3);
        input4.put(35, new PositionedStack(RecipeUtil.getChestItemStack(1, 0), 107 - x, 64 - y));
        instance.registerBuggyBenchRecipe(
                input4,
                new PositionedStack(new ItemStack(GCItems.buggy, 1, 2), 143 - x, 64 - y));
        input4 = new HashMap<>(input3);
        input4.put(35, new PositionedStack(RecipeUtil.getChestItemStack(1, 1), 107 - x, 64 - y));
        instance.registerBuggyBenchRecipe(
                input4,
                new PositionedStack(new ItemStack(GCItems.buggy, 1, 3), 143 - x, 64 - y));
    }

    @Optional.Method(modid = Mods.ModIDs.GALACTICRAFT_CORE)
    private static void cargoRecipes() {
        HashMap<Integer, ItemStack> input = new HashMap<>();
        HashMap<Integer, ItemStack> input2;
        input.put(1, new ItemStack(GCItems.basicItem, 1, 14));
        if (GalaxySpace.isModLoaded()) {
            input.put(2, getModItem(GalaxySpace.ID, "item.RocketControlComputer", 1, 101));
            for (int i = 3; i <= 5; i++) {
                input.put(i, getModItem(GalaxySpace.ID, "item.ModuleSmallFuelCanister", 1));
            }
        }
        input.put(7, new ItemStack(GCItems.partNoseCone));
        for (int i = 8; i <= 15; i++) {
            input.put(i, new ItemStack(MarsItems.marsItemBasic, 1, 3));
        }
        input.put(16, new ItemStack(GCItems.rocketEngine));
        for (int i = 17; i <= 20; i++) {
            input.put(i, new ItemStack(GCItems.partFins));
        }

        input2 = new HashMap<>(input);
        input2.put(21, RecipeUtil.getChestItemStack(1, 3));
        MarsUtil.adCargoRocketRecipe(new ItemStack(MarsItems.spaceship, 1, 11), input2);
        input2 = new HashMap<>(input);
        input2.put(21, RecipeUtil.getChestItemStack(1, 0));
        MarsUtil.adCargoRocketRecipe(new ItemStack(MarsItems.spaceship, 1, 12), input2);
        input2 = new HashMap<>(input);
        input2.put(21, RecipeUtil.getChestItemStack(1, 1));
        MarsUtil.adCargoRocketRecipe(new ItemStack(MarsItems.spaceship, 1, 13), input2);

        // NEI integration
        NEIGalacticraftMarsConfig instance = new NEIGalacticraftMarsConfig();
        final ArrayList<PositionedStack> input3 = new ArrayList<>();
        ArrayList<PositionedStack> input4 = new ArrayList<>();
        final int x = CargoRocketRecipeHandler.tX - CargoRocketRecipeHandler.x;
        final int y = CargoRocketRecipeHandler.tY - CargoRocketRecipeHandler.y;
        input3.add(new PositionedStack(new ItemStack(GCItems.basicItem, 1, 14), 134 - x, 10 - y));
        if (GalaxySpace.isModLoaded()) {
            input3.add(
                    new PositionedStack(
                            getModItem(GalaxySpace.ID, "item.RocketControlComputer", 1, 101),
                            134 - x,
                            28 - y));
            input3.add(
                    new PositionedStack(
                            getModItem(GalaxySpace.ID, "item.ModuleSmallFuelCanister", 1),
                            116 - x,
                            19 - y));
            input3.add(
                    new PositionedStack(
                            getModItem(GalaxySpace.ID, "item.ModuleSmallFuelCanister", 1),
                            152 - x,
                            19 - y));
            input3.add(
                    new PositionedStack(
                            getModItem(GalaxySpace.ID, "item.ModuleSmallFuelCanister", 1),
                            116 - x,
                            37 - y));
        }
        input3.add(new PositionedStack(new ItemStack(GCItems.partNoseCone), 53 - x, 19 - y));
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                input3.add(
                        new PositionedStack(
                                new ItemStack(MarsItems.marsItemBasic, 1, 3),
                                44 + j * 18 - x,
                                37 + i * 18 - y));
            }
        }
        input3.add(new PositionedStack(new ItemStack(GCItems.rocketEngine), 53 - x, 109 - y));
        input3.add(new PositionedStack(new ItemStack(GCItems.partFins), 26 - x, 91 - y));
        input3.add(new PositionedStack(new ItemStack(GCItems.partFins), 80 - x, 91 - y));
        input3.add(new PositionedStack(new ItemStack(GCItems.partFins), 26 - x, 109 - y));
        input3.add(new PositionedStack(new ItemStack(GCItems.partFins), 80 - x, 109 - y));
        input4 = new ArrayList<>(input3);
        input4.add(new PositionedStack(RecipeUtil.getChestItemStack(1, 3), 134 - x, 46 - y));
        instance.registerCargoBenchRecipe(
                input4,
                new PositionedStack(new ItemStack(MarsItems.spaceship, 1, 11), 134 - x, 73 - y));
        input4 = new ArrayList<>(input3);
        input4.add(new PositionedStack(RecipeUtil.getChestItemStack(1, 0), 134 - x, 46 - y));
        instance.registerCargoBenchRecipe(
                input4,
                new PositionedStack(new ItemStack(MarsItems.spaceship, 1, 12), 134 - x, 73 - y));
        input4 = new ArrayList<>(input3);
        input4.add(new PositionedStack(RecipeUtil.getChestItemStack(1, 1), 134 - x, 46 - y));
        instance.registerCargoBenchRecipe(
                input4,
                new PositionedStack(new ItemStack(MarsItems.spaceship, 1, 13), 134 - x, 73 - y));
    }

    @Optional.Method(modid = Mods.ModIDs.GALACTICRAFT_CORE)
    private static void astroMinerRecipes() {
        final HashMap<Integer, ItemStack> input = new HashMap<>();
        for (int i = 1; i <= 8; i++) {
            input.put(i, new ItemStack(MarsItems.marsItemBasic, 1, 3));
        }
        input.put(9, new ItemStack(GCItems.flagPole));
        input.put(10, new ItemStack(GCItems.flagPole));
        for (int i = 11; i <= 13; i++) {
            input.put(i, new ItemStack(AsteroidsItems.basicItem));
        }
        for (int i = 14; i <= 17; i++) {
            input.put(i, new ItemStack(AsteroidsItems.orionDrive));
        }
        if (GalaxySpace.isModLoaded()) {
            input.put(18, getModItem(GalaxySpace.ID, "item.RocketControlComputer", 1, 102));
        }
        input.put(19, new ItemStack(GCItems.basicItem, 1, 14));
        input.put(20, new ItemStack(GCItems.basicItem, 1, 14));
        for (int i = 21; i <= 23; i++) {
            input.put(i, new ItemStack(GCItems.heavyPlatingTier1));
        }
        input.put(24, RecipeUtil.getChestItemStack(1, 1));
        input.put(25, RecipeUtil.getChestItemStack(1, 1));
        input.put(26, new ItemStack(AsteroidsItems.basicItem, 1, 8));
        input.put(27, new ItemStack(AsteroidBlocks.beamReceiver));
        input.put(28, ItemList.Electric_Motor_EV.get(1));
        input.put(29, ItemList.Electric_Motor_EV.get(1));
        GalacticraftRegistry
                .addAstroMinerRecipe(new NasaWorkbenchRecipe(new ItemStack(AsteroidsItems.astroMiner, 1, 0), input));

        // NEI integration
        NEIGalacticraftAsteroidsConfig instance = new NEIGalacticraftAsteroidsConfig();
        ArrayList<PositionedStack> input3 = new ArrayList<>();
        final int x = AstroMinerRecipeHandler.tX - AstroMinerRecipeHandler.x;
        final int y = AstroMinerRecipeHandler.tY - AstroMinerRecipeHandler.y;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                input3.add(
                        new PositionedStack(
                                new ItemStack(MarsItems.marsItemBasic, 1, 3),
                                44 + j * 18 - x,
                                19 + i * 72 - y));
            }
        }
        input3.add(new PositionedStack(new ItemStack(GCItems.flagPole), 116 - x, 19 - y));
        input3.add(new PositionedStack(new ItemStack(GCItems.flagPole), 116 - x, 91 - y));
        input3.add(new PositionedStack(new ItemStack(AsteroidsItems.basicItem), 26 - x, 37 - y));
        input3.add(new PositionedStack(new ItemStack(AsteroidsItems.basicItem), 8 - x, 55 - y));
        input3.add(new PositionedStack(new ItemStack(AsteroidsItems.basicItem), 26 - x, 73 - y));
        input3.add(new PositionedStack(new ItemStack(AsteroidsItems.orionDrive), 44 - x, 37 - y));
        input3.add(new PositionedStack(new ItemStack(AsteroidsItems.orionDrive), 26 - x, 55 - y));
        input3.add(new PositionedStack(new ItemStack(AsteroidsItems.orionDrive), 44 - x, 55 - y));
        input3.add(new PositionedStack(new ItemStack(AsteroidsItems.orionDrive), 62 - x, 55 - y));
        if (GalaxySpace.isModLoaded()) {
            input3.add(
                    new PositionedStack(
                            getModItem(GalaxySpace.ID, "item.RocketControlComputer", 1, 102),
                            62 - x,
                            37 - y));
        }
        input3.add(new PositionedStack(new ItemStack(GCItems.basicItem, 1, 14), 80 - x, 37 - y));
        input3.add(new PositionedStack(new ItemStack(GCItems.basicItem, 1, 14), 98 - x, 37 - y));
        input3.add(new PositionedStack(new ItemStack(GCItems.heavyPlatingTier1), 116 - x, 37 - y));
        input3.add(new PositionedStack(new ItemStack(GCItems.heavyPlatingTier1), 116 - x, 55 - y));
        input3.add(new PositionedStack(new ItemStack(GCItems.heavyPlatingTier1), 116 - x, 73 - y));
        input3.add(new PositionedStack(RecipeUtil.getChestItemStack(1, 1), 80 - x, 55 - y));
        input3.add(new PositionedStack(RecipeUtil.getChestItemStack(1, 1), 98 - x, 55 - y));
        input3.add(new PositionedStack(new ItemStack(AsteroidsItems.basicItem, 1, 8), 44 - x, 73 - y));
        input3.add(new PositionedStack(new ItemStack(AsteroidBlocks.beamReceiver), 62 - x, 73 - y));
        input3.add(new PositionedStack(ItemList.Electric_Motor_EV.get(1), 80 - x, 73 - y));
        input3.add(new PositionedStack(ItemList.Electric_Motor_EV.get(1), 98 - x, 73 - y));
        instance.registerAstroMinerRecipe(
                input3,
                new PositionedStack(new ItemStack(AsteroidsItems.astroMiner), 143 - x, 55 - y));
    }
}
