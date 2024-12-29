package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AdvancedSolarPanel;
import static gregtech.api.enums.Mods.GTNHIntergalactic;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.enums.Mods.GalacticraftAmunRa;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.GalacticraftMars;
import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.enums.Mods.GoodGenerator;
import static gregtech.api.enums.Mods.GraviSuite;
import static gregtech.api.enums.Mods.IronChests;
import static gregtech.api.enums.Mods.RandomThings;
import static gregtech.api.enums.Mods.TecTech;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
import static gregtech.api.recipe.RecipeMaps.implosionRecipes;
import static gregtech.api.recipe.RecipeMaps.mixerRecipes;
import static gregtech.api.util.GTRecipeBuilder.BUCKETS;
import static gregtech.api.util.GTRecipeBuilder.INGOTS;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.QUARTER_INGOT;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gregtech.api.util.GTUtility.getIntegratedCircuit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.gtnewhorizons.gtnhintergalactic.item.IGItems;

import cpw.mods.fml.common.Optional;
import cpw.mods.fml.common.registry.GameRegistry;
import de.katzenpapst.amunra.block.ARBlocks;
import de.katzenpapst.amunra.crafting.RecipeHelper;
import gregtech.api.GregTechAPI;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsKevlar;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTRecipeConstants;
import gregtech.api.util.GTUtility;
import micdoodle8.mods.galacticraft.api.recipe.SpaceStationRecipe;
import tectech.recipe.TTRecipeAdder;

public class ScriptAmunRa implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Amun-Ra";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                AdvancedSolarPanel.ID,
                GalacticraftAmunRa.ID,
                GalaxySpace.ID,
                GoodGenerator.ID,
                GraviSuite.ID,
                GTNHIntergalactic.ID,
                GTPlusPlus.ID,
                IronChests.ID,
                RandomThings.ID,
                TecTech.ID);
    }

    @Override
    public void loadRecipes() {
        setMothershipRecipe();

        final Block baseBlockRock = GameRegistry.findBlock(GalacticraftAmunRa.ID, "tile.baseBlockRock");
        final Block rockSlab = GameRegistry.findBlock(GalacticraftAmunRa.ID, "tile.rockSlab");
        final Block woodSlab = GameRegistry.findBlock(GalacticraftAmunRa.ID, "tile.woodSlab");
        final Block wood1 = GameRegistry.findBlock(GalacticraftAmunRa.ID, "tile.wood1");
        final Block machines1 = GameRegistry.findBlock(GalacticraftAmunRa.ID, "tile.machines1");
        final Block machines2 = GameRegistry.findBlock(GalacticraftAmunRa.ID, "tile.machines2");
        final Block machines3 = GameRegistry.findBlock(GalacticraftAmunRa.ID, "tile.machines3");
        final Block machines4 = GameRegistry.findBlock(GalacticraftAmunRa.ID, "tile.machines4");
        final Block msBoosters1 = GameRegistry.findBlock(GalacticraftAmunRa.ID, "tile.msBoosters1");
        final Block airLockFrame = GameRegistry.findBlock(GalacticraftCore.ID, "tile.airLockFrame");
        final Block machineFrames = GameRegistry.findBlock(GTNHIntergalactic.ID, "machineframes");

        final Item baseItem = GameRegistry.findItem(GalacticraftAmunRa.ID, "item.baseItem");
        final Item basicItem = GameRegistry.findItem(GalacticraftCore.ID, "item.basicItem");
        final Item dysonSwarmParts = IGItems.DysonSwarmItems;
        final Item advancedRadiationProtectionPlate = GameRegistry
                .findItem(GoodGenerator.ID, "advancedRadiationProtectionPlate");
        final Item simpleItem = GameRegistry.findItem(GraviSuite.ID, "itemSimpleItem");

        final Fluid mutatedLivingSolder = FluidRegistry.getFluid("molten.mutatedlivingsolder");

        addSlabAndStairRecipes(
                new ItemStack(baseBlockRock, 1, 1),
                new ItemStack(rockSlab, 2, 0),
                GameRegistry.findItemStack(GalacticraftAmunRa.ID, "tile.basalt.stairs", 4),
                true);
        addSlabAndStairRecipes(
                new ItemStack(baseBlockRock, 1, 7),
                new ItemStack(rockSlab, 2, 1),
                GameRegistry.findItemStack(GalacticraftAmunRa.ID, "tile.basaltbrick.stairs", 4),
                true);
        addSlabAndStairRecipes(
                new ItemStack(baseBlockRock, 1, 8),
                new ItemStack(rockSlab, 2, 2),
                GameRegistry.findItemStack(GalacticraftAmunRa.ID, "tile.smoothbasalt.stairs", 4),
                true);
        addSlabAndStairRecipes(
                new ItemStack(baseBlockRock, 1, 9),
                new ItemStack(rockSlab, 2, 3),
                GameRegistry.findItemStack(GalacticraftAmunRa.ID, "tile.obsidianbrick.stairs", 4),
                true);
        addSlabAndStairRecipes(
                new ItemStack(baseBlockRock, 1, 6),
                new ItemStack(rockSlab, 2, 4),
                GameRegistry.findItemStack(GalacticraftAmunRa.ID, "tile.alucrate.stairs", 4),
                true);

        /******************
         * Shape Crafting *
         ******************/

        addShapedOredictRecipe(
                new ItemStack(baseBlockRock, 1, 6),
                "HP ",
                "PSP",
                " PW",
                'H',
                "craftingToolHardHammer",
                'P',
                "compressedAluminium",
                'S',
                "stone",
                'W',
                "craftingToolWrench");
        addShapedOredictRecipe(
                new ItemStack(baseBlockRock, 1, 13),
                "SPS",
                "PWP",
                "SPS",
                'S',
                "screwAnyIron",
                'P',
                "plateAnyIron",
                'W',
                "craftingTableWood");
        addShapedOredictRecipe(
                new ItemStack(machines1, 1, 3),
                "PDP",
                "CFC",
                "PKP",
                'P',
                "plateCosmicNeutronium",
                'D',
                com.dreammaster.item.ItemList.Display.getIS(),
                'C',
                "circuitInfinite",
                'F',
                new ItemStack(machineFrames),
                'K',
                "oc:keyboard");
        addShapedOredictRecipe(
                new ItemStack(machines3),
                "SPS",
                "FWD",
                "TPC",
                'S',
                "screwOsmiridium",
                'P',
                "compressedAluminium",
                'F',
                new ItemStack(machineFrames),
                'W',
                "springTungstenSteel",
                'D',
                com.dreammaster.item.ItemList.Display.getIS(),
                'T',
                "craftingToolScrewdriver",
                'P',
                ItemList.Electric_Piston_IV.get(1),
                'C',
                "circuitElite");
        addShapedOredictRecipe(
                new ItemStack(machines4),
                "FCF",
                "DEG",
                "FCF",
                'F',
                new ItemStack(airLockFrame),
                'C',
                new ItemStack(airLockFrame, 1, 1),
                'D',
                new ItemStack(baseItem, 1, 25),
                'E',
                "circuitSuperconductor",
                'G',
                new ItemStack(baseItem, 1, 24));
        addShapedOredictRecipe(
                new ItemStack(machines4, 1, 1),
                "GGG",
                "ODO",
                "CFP",
                'G',
                new ItemStack(GameRegistry.findItem(AdvancedSolarPanel.ID, "asp_crafting_items"), 1, 5),
                'O',
                GameRegistry.findItemStack(GalacticraftCore.ID, "tile.oxygenCollector", 1),
                'D',
                GameRegistry.findItemStack(RandomThings.ID, "fertilizedDirt", 1),
                'C',
                "circuitData",
                'F',
                new ItemStack(machineFrames),
                'P',
                ItemList.Pump_HV.get(1));
        addShapedOredictRecipe(
                new ItemStack(baseItem, 1, 14),
                "H8F",
                "L8L",
                "L4L",
                'H',
                "craftingToolHardHammer",
                '8',
                com.dreammaster.item.ItemList.HeavyDutyPlateTier8.getIS(),
                'F',
                "craftingToolFile",
                'L',
                new ItemStack(baseItem, 1, 15),
                '4',
                com.dreammaster.item.ItemList.HeavyDutyRocketFinsTier4.getIS());
        addShapedOredictRecipe(
                new ItemStack(baseItem, 1, 16),
                "DCH",
                "SPS",
                "PPP",
                'D',
                "craftingToolScrewdriver",
                'C',
                com.dreammaster.item.ItemList.HeavyDutyNoseConeTier4.getIS(),
                'H',
                "craftingToolHardHammer",
                'S',
                "screwNeutronium",
                'P',
                new ItemStack(baseItem, 1, 15));
        addShapedOredictRecipe(
                new ItemStack(baseItem, 1, 24),
                "SPS",
                "RRR",
                "SPS",
                'S',
                "plateAnySyntheticRubber",
                'P',
                ItemList.Electric_Piston_UV.get(1),
                'R',
                "stickLongAstralTitanium");
        addShapedOredictRecipe(
                new ItemStack(baseItem, 1, 25),
                "RPR",
                "MPM",
                "RPR",
                'R',
                "ringAnySyntheticRubber",
                'P',
                "plateBlackPlutonium",
                'M',
                ItemList.Electric_Motor_UV.get(1));

        /************
         * Smelting *
         ************/

        GameRegistry.addSmelting(new ItemStack(baseBlockRock, 1, 0), new ItemStack(baseBlockRock, 1, 1), 1.0f);
        GameRegistry.addSmelting(new ItemStack(baseBlockRock, 1, 2), new ItemStack(baseBlockRock, 1, 3), 1.0f);
        GameRegistry.addSmelting(new ItemStack(baseBlockRock, 1, 4), new ItemStack(baseBlockRock, 1, 5), 1.0f);

        /*************
         * Assembler *
         *************/

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(baseBlockRock, 1, 1), getIntegratedCircuit(4))
                .itemOutputs(new ItemStack(baseBlockRock, 1, 7)).duration(2 * SECONDS + 10 * TICKS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(baseBlockRock, 1, 0), getIntegratedCircuit(23))
                .itemOutputs(new ItemStack(baseBlockRock, 1, 8)).duration(2 * SECONDS + 10 * TICKS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.obsidian, 1, 0), getIntegratedCircuit(23))
                .itemOutputs(new ItemStack(baseBlockRock, 1, 9)).duration(2 * SECONDS + 10 * TICKS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_UV.get(1),
                        new ItemStack(simpleItem, 32, 3),
                        ItemList.Field_Generator_UV.get(4),
                        new Object[] { OrePrefixes.circuit.get(Materials.UV), 2 },
                        new Object[] { OrePrefixes.gearGt.get("EnrichedNaquadahAlloy"), 1 },
                        new ItemStack(baseItem, 1, 26))
                .itemOutputs(new ItemStack(machines3, 1, 1)).duration(20 * SECONDS).eut(TierEU.RECIPE_UV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        com.dreammaster.item.ItemList.HeavyDutyPlateTier8.getIS(2),
                        new ItemStack(baseItem, 4, 15),
                        com.dreammaster.item.ItemList.HeavyDutyRocketFinsTier4.getIS(),
                        getIntegratedCircuit(5))
                .itemOutputs(new ItemStack(baseItem, 1, 14)).duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        com.dreammaster.item.ItemList.HeavyDutyNoseConeTier4.getIS(),
                        new ItemStack(baseItem, 4, 15),
                        getIntegratedCircuit(4))
                .fluidInputs(Materials.Neutronium.getMolten(QUARTER_INGOT)).itemOutputs(new ItemStack(baseItem, 1, 16))
                .duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new Object[] { "compressedTin", 4 },
                        new ItemStack(basicItem, 1, 19),
                        new ItemStack(basicItem, 1, 14),
                        Materials.Glass.getPlates(1),
                        ItemList.Battery_SU_LV_SulfuricAcid.get(1))
                .itemOutputs(new ItemStack(baseItem, 1, 18)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        Materials.Neutronium.getPlates(16),
                        new Object[] { OrePrefixes.gearGt.get("EnrichedNaquadahAlloy"), 4 },
                        new ItemStack(baseItem, 4, 27),
                        new Object[] { OrePrefixes.circuit.get(Materials.UHV), 2 },
                        ItemList.Sensor_UHV.get(1),
                        ItemList.Emitter_UHV.get(1))
                .fluidInputs(new FluidStack(mutatedLivingSolder, 4 * INGOTS))
                .itemOutputs(new ItemStack(baseItem, 1, 28)).duration(2 * MINUTES).eut(TierEU.RECIPE_UHV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(simpleItem, 16, 3),
                        GameRegistry.findItemStack(GoodGenerator.ID, "radiationProtectionPlate", 4),
                        new Object[] { OrePrefixes.circuit.get(Materials.UV), 1 },
                        new Object[] { OrePrefixes.gearGtSmall.get("EnrichedNaquadahAlloy"), 1 },
                        new ItemStack(baseItem, 1, 26))
                .itemOutputs(new ItemStack(baseItem, 1, 30)).duration(20 * SECONDS).eut(TierEU.RECIPE_UV)
                .addTo(assemblerRecipes);

        /************************
         * Implosion Compressor *
         ************************/

        GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.HeavyDutyAlloyIngotT9.getIS())
                .itemOutputs(new ItemStack(baseItem, 1, 15), Materials.Neutronium.getDustTiny(8))
                .metadata(GTRecipeConstants.ADDITIVE_AMOUNT, 64).duration(1 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(implosionRecipes);

        /*********
         * Mixer *
         *********/

        GTValues.RA.stdBuilder().itemInputs(Materials.Carbon.getNanite(4), Materials.Neutronium.getNanite(1))
                .fluidInputs(Materials.Infinity.getMolten(INGOTS)).itemOutputs(new ItemStack(baseItem, 5, 27))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_UHV).addTo(mixerRecipes);

        /*****************
         * Assembly Line *
         *****************/

        TTRecipeAdder.addResearchableAssemblylineRecipe(
                new ItemStack(GameRegistry.findBlock(GalacticraftMars.ID, "tile.marsMachine"), 1, 8),
                64000,
                64,
                (int) TierEU.RECIPE_UHV,
                8,
                new Object[] { ItemList.Hull_MAX.get(1), new ItemStack(baseItem, 32, 28),
                        com.dreammaster.item.ItemList.IrradiantReinforcedNeutroniumPlate.getIS(64),
                        new ItemStack(GameRegistry.findItem(GalaxySpace.ID, "item.RocketControlComputer"), 4, 8),
                        new Object[] { OrePrefixes.circuit.get(Materials.UHV), 16 }, ItemList.Sensor_UHV.get(8),
                        ItemList.Emitter_UHV.get(8) },
                new FluidStack[] { Materials.Infinity.getMolten(100 * INGOTS),
                        FluidRegistry.getFluidStack("molten.enriched naquadah alloy", 256 * INGOTS),
                        new FluidStack(mutatedLivingSolder, 64 * INGOTS) },
                new ItemStack(machines1, 1, 2),
                15 * MINUTES,
                (int) TierEU.RECIPE_UHV);
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                com.dreammaster.item.ItemList.HeavyDutyRocketEngineTier4.getIS(),
                64000,
                64,
                (int) TierEU.RECIPE_UHV,
                8,
                new Object[] { new ItemStack(dysonSwarmParts, 64, 3), new ItemStack(dysonSwarmParts, 64, 3),
                        new ItemStack(dysonSwarmParts, 64, 3), new ItemStack(dysonSwarmParts, 64, 3),
                        com.dreammaster.item.ItemList.HeavyDutyRocketEngineTier4.getIS(64),
                        new Object[] { OrePrefixes.pipeHuge.get(Materials.Infinity), 8 },
                        ItemList.Electric_Pump_UHV.get(16), new Object[] { OrePrefixes.circuit.get(Materials.UHV), 8 },
                        new ItemStack(baseItem, 4, 27) },
                new FluidStack[] { Materials.Infinity.getMolten(50 * INGOTS),
                        Materials.SuperCoolant.getFluid(64 * BUCKETS),
                        new FluidStack(mutatedLivingSolder, 64 * INGOTS) },
                new ItemStack(machines2),
                5 * MINUTES,
                (int) TierEU.RECIPE_UHV);
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                new ItemStack(machines2),
                80000,
                64,
                2500000,
                10,
                new Object[] { new ItemStack(advancedRadiationProtectionPlate, 16),
                        new ItemStack(advancedRadiationProtectionPlate, 16),
                        new ItemStack(advancedRadiationProtectionPlate, 16),
                        new ItemStack(advancedRadiationProtectionPlate, 16),
                        GameRegistry.findItemStack(GoodGenerator.ID, "FRF_Coil_2", 8),
                        new Object[] { OrePrefixes.wireGt16.get(Materials.SuperconductorUHV), 8 },
                        ItemList.Emitter_UHV.get(16), ItemList.Field_Generator_UHV.get(8),
                        new ItemStack(baseItem, 4, 27) },
                new FluidStack[] { Materials.Infinity.getMolten(50 * INGOTS),
                        Materials.SuperCoolant.getFluid(64 * BUCKETS),
                        new FluidStack(mutatedLivingSolder, 64 * INGOTS) },
                new ItemStack(machines2, 1, 1),
                10 * MINUTES,
                2500000);
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                com.dreammaster.item.ItemList.Tier4Booster.getIS(),
                64000,
                64,
                (int) TierEU.RECIPE_UHV,
                8,
                new Object[] { new ItemStack(dysonSwarmParts, 16, 3), new ItemStack(dysonSwarmParts, 16, 3),
                        new ItemStack(dysonSwarmParts, 16, 3), new ItemStack(dysonSwarmParts, 16, 3),
                        ItemList.Quantum_Tank_EV.get(2), ItemList.Electric_Pump_UHV.get(4),
                        new Object[] { OrePrefixes.circuit.get(Materials.UHV), 2 }, new ItemStack(baseItem, 1, 27) },
                new FluidStack[] { Materials.Infinity.getMolten(50 * INGOTS),
                        Materials.SuperCoolant.getFluid(64 * BUCKETS),
                        new FluidStack(mutatedLivingSolder, 64 * INGOTS) },
                new ItemStack(msBoosters1),
                5 * MINUTES,
                (int) TierEU.RECIPE_UHV);
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                new ItemStack(msBoosters1),
                80000,
                64,
                2500000,
                10,
                new Object[] { new ItemStack(advancedRadiationProtectionPlate, 4),
                        new ItemStack(advancedRadiationProtectionPlate, 4),
                        new ItemStack(advancedRadiationProtectionPlate, 4),
                        new ItemStack(advancedRadiationProtectionPlate, 4), ItemList.Battery_Buffer_4by4_UHV.get(2),
                        ItemList.Emitter_UHV.get(4), ItemList.Field_Generator_UHV.get(2),
                        new ItemStack(baseItem, 1, 27) },
                new FluidStack[] { Materials.Infinity.getMolten(50 * INGOTS),
                        Materials.SuperCoolant.getFluid(64 * BUCKETS),
                        new FluidStack(mutatedLivingSolder, 64 * INGOTS) },
                new ItemStack(msBoosters1, 1, 1),
                10 * MINUTES,
                2500000);
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                GameRegistry.findItemStack(GalaxySpace.ID, "item.SchematicTier8", 1),
                64000,
                64,
                (int) TierEU.RECIPE_UHV,
                8,
                new Object[] { new Object[] { OrePrefixes.ore.get(Materials.Samarium), 64 },
                        new Object[] { OrePrefixes.ore.get(Materials.Tartarite), 64 },
                        new Object[] { OrePrefixes.ore.get(Materials.Cadmium), 64 },
                        new Object[] { OrePrefixes.ore.get(Materials.Caesium), 64 },
                        new Object[] { OrePrefixes.ore.get(Materials.Lanthanum), 64 },
                        new Object[] { OrePrefixes.ore.get(Materials.Cerium), 64 },
                        new Object[] { OrePrefixes.ingot.get(Materials.Bedrockium), 64 },
                        new Object[] { OrePrefixes.ingot.get(Materials.DraconiumAwakened), 64 },
                        new Object[] { OrePrefixes.ingot.get(Materials.CosmicNeutronium), 64 },
                        new Object[] { OrePrefixes.ingot.get(Materials.InfinityCatalyst), 64 },
                        new Object[] { OrePrefixes.ingot.get(Materials.Infinity), 64 },
                        ItemList.Electric_Pump_UHV.get(8), ItemList.Conveyor_Module_UHV.get(8),
                        ItemList.Robot_Arm_UHV.get(8), ItemList.Field_Generator_UHV.get(8),
                        ItemList.Sensor_UHV.get(8) },
                new FluidStack[] { FluidRegistry.getFluidStack("molten.abyssalalloy", 64 * INGOTS),
                        FluidRegistry.getFluidStack("molten.octiron", 64 * INGOTS),
                        FluidRegistry.getFluidStack("molten.astraltitanium", 64 * INGOTS) },
                GameRegistry.findItemStack(GalacticraftAmunRa.ID, "item.schematic", 1),
                15 * MINUTES,
                (int) TierEU.RECIPE_UHV);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        com.dreammaster.item.ItemList.HeavyDutyPlateTier8.getIS(),
                        MaterialsKevlar.Kevlar.getPlates(7),
                        MaterialsKevlar.Kevlar.getPlates(7),
                        new Object[] { OrePrefixes.screw.get(Materials.Neutronium), 12 })
                .fluidInputs(Materials.RadoxPolymer.getMolten(4 * INGOTS))
                .itemOutputs(com.dreammaster.item.ItemList.HeavyDutyAlloyIngotT9.getIS())
                .metadata(GTRecipeConstants.RESEARCH_ITEM, com.dreammaster.item.ItemList.HeavyDutyPlateTier8.getIS())
                .metadata(GTRecipeConstants.RESEARCH_TIME, 750 * SECONDS).duration(15 * SECONDS).eut(TierEU.RECIPE_UEV)
                .addTo(GTRecipeConstants.AssemblyLine);
    }

    @Optional.Method(modid = "GalacticraftAmunRa")
    private static void setMothershipRecipe() {
        final HashMap<Object, Integer> recipe = new HashMap<>();

        recipe.put(
                new ItemStack(
                        ARBlocks.blockMothershipController.getBlock(),
                        1,
                        ARBlocks.blockMothershipController.getMetadata()),
                1);
        recipe.put(new ItemStack(GregTechAPI.sBlockCasings8, 1, 5), 256);
        recipe.put(new ItemStack(GameRegistry.findItem(GalaxySpace.ID, "item.DysonSwarmParts"), 1, 3), 64);
        recipe.put(ItemList.Field_Generator_UHV.get(1), 8);
        recipe.put("circuitInfinite", 32);

        RecipeHelper.mothershipRecipe = new SpaceStationRecipe(recipe);
    }

    private static void addShapedOredictRecipe(ItemStack result, Object... recipe) {
        GameRegistry.addRecipe(new ShapedOreRecipe(result, recipe));
    }

    private static void addShapelessOredictRecipe(ItemStack result, Object... recipe) {
        GameRegistry.addRecipe(new ShapelessOreRecipe(result, recipe));
    }

    private static void addWoodRecipes(ItemStack log, ItemStack plank, ItemStack slab, ItemStack stair) {
        // Log -> Planks
        GameRegistry.addShapelessRecipe(GTUtility.copyAmount(2, plank), log);
        addShapedOredictRecipe(GTUtility.copyAmount(4, plank), "S", "L", 'S', "craftingToolSaw", 'L', log);
        GTValues.RA.stdBuilder().itemInputs(log).fluidInputs(Materials.Lubricant.getFluid(1))
                .itemOutputs(GTUtility.copyAmount(6, plank), Materials.Wood.getDust(1)).duration(10 * SECONDS).eut(7)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(log).fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3))
                .itemOutputs(GTUtility.copyAmount(4, plank), Materials.Wood.getDust(2)).duration(20 * SECONDS).eut(7)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(log).fluidInputs(Materials.Water.getFluid(5))
                .itemOutputs(GTUtility.copyAmount(4, plank), Materials.Wood.getDust(2)).duration(20 * SECONDS).eut(7)
                .addTo(cutterRecipes);

        // Slabs -> Planks
        GameRegistry.addShapedRecipe(plank, "S", "S", 'S', slab);

        // Slabs and Staits
        addSlabAndStairRecipes(plank, GTUtility.copyAmount(2, slab), stair, false);
    }

    private static void addSlabAndStairRecipes(ItemStack input, ItemStack slab, ItemStack stair, boolean isRock) {
        // Stair
        addShapedOredictRecipe(stair, "X  ", "XX ", "XXX", 'X', input);

        // Slab (inefficient)
        addShapelessOredictRecipe(GTUtility.copyAmount(1, slab), "craftingToolSaw", input);

        // Slab (efficient)
        final int eut = isRock ? 7 : 4;

        GTValues.RA.stdBuilder().itemInputs(input).fluidInputs(Materials.Lubricant.getFluid(1)).itemOutputs(slab)
                .duration(1 * SECONDS + 5 * TICKS).eut(eut).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(input).fluidInputs(Materials.Water.getFluid(4)).itemOutputs(slab)
                .duration(2 * SECONDS + 10 * TICKS).eut(eut).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(input).fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3))
                .itemOutputs(slab).duration(2 * SECONDS + 10 * TICKS).eut(eut).addTo(cutterRecipes);
    }

}
