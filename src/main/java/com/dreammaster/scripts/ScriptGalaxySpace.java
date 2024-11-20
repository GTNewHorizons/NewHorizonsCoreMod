package com.dreammaster.scripts;

import bartworks.system.material.WerkstoffLoader;
import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.GregTechAPI;
import gregtech.api.enums.*;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gregtech.common.items.MetaGeneratedItem01;
import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import static gregtech.api.enums.GTValues.RA;
import static gregtech.api.enums.Mods.*;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.recipe.RecipeMaps.*;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.*;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeConstants.UniversalChemical;
import static net.minecraftforge.oredict.OreDictionary.WILDCARD_VALUE;

import java.util.Arrays;
import java.util.List;

public class ScriptGalaxySpace implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "GalaxySpace";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                GalacticraftCore.ID,
                GalacticraftMars.ID,
                GalaxySpace.ID,
                OpenComputers.ID,
                BuildCraftBuilders.ID);
    }

    @Override
    public void loadRecipes() {
        Item case1 = GameRegistry.findItem("OpenComputers", "case1");
        Item case2 = GameRegistry.findItem("OpenComputers", "case2");
        Item case3 = GameRegistry.findItem("OpenComputers", "case3");
        Item keyboard = GameRegistry.findItem("OpenComputers", "keyboard");
        Item blueprint = GameRegistry.findItem("BuildCraft|Builders", "blueprintItem");
        Item tungstenString = GameRegistry.findItem("dreamcraft", "item.TungstenString");
        Item display = GameRegistry.findItem("dreamcraft", "item.Display");
        Item waferT3 = GameRegistry.findItem("dreamcraft", "item.WaferTier3");

        // Assembler
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Blocks.glass), GTOreDictUnificator.get(OrePrefixes.stick, Materials.Desh, 8))
                .itemOutputs(new ItemStack(GSBlocks.FutureGlass, 1, 0))
                .duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(GCItems.battery, 1, WILDCARD_VALUE), GTUtility.getIntegratedCircuit(1))
                .itemOutputs(new ItemStack(GSItems.LeadBattery, 1, 100))
                .fluidInputs(Materials.Lead.getMolten(6000))
                .duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(GSItems.ThermalPaddingTier2), GTUtility.getIntegratedCircuit(1))
                .itemOutputs(new ItemStack(GSItems.ThermalClothTier2, 5))
                .duration(18 * SECONDS)
                .eut(1024)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(GSItems.ThermalPaddingTier2, 1, 1), GTUtility.getIntegratedCircuit(1))
                .itemOutputs(new ItemStack(GSItems.ThermalClothTier2, 8))
                .duration(30 * SECONDS)
                .eut(1024)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(GSItems.ThermalPaddingTier2, 1, 2), GTUtility.getIntegratedCircuit(1))
                .itemOutputs(new ItemStack(GSItems.ThermalClothTier2, 7))
                .duration(26 * SECONDS)
                .eut(1024)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(GSItems.ThermalPaddingTier2, 1, 3), GTUtility.getIntegratedCircuit(1))
                .itemOutputs(new ItemStack(GSItems.ThermalClothTier2, 4))
                .duration(15 * SECONDS)
                .eut(1024)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(AsteroidsItems.basicItem, 1, 7),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Titanium, 8),
                        new ItemStack(tungstenString, 8),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(new ItemStack(GSItems.ThermalClothTier2))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(576))
                .duration(30 * SECONDS)
                .eut(1024)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(GSItems.ThermalClothTier2, 5),
                        new ItemStack(tungstenString, 5),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(new ItemStack(GSItems.ThermalPaddingTier2))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(1440))
                .duration(1 * MINUTES + 15 * SECONDS)
                .eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(GSItems.ThermalClothTier2, 8),
                        new ItemStack(tungstenString, 8),
                        GTUtility.getIntegratedCircuit(8))
                .itemOutputs(new ItemStack(GSItems.ThermalPaddingTier2, 1, 1))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(2304))
                .duration(2 * MINUTES)
                .eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(GSItems.ThermalClothTier2, 7),
                        new ItemStack(tungstenString, 7),
                        GTUtility.getIntegratedCircuit(7))
                .itemOutputs(new ItemStack(GSItems.ThermalPaddingTier2, 1, 2))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(2016))
                .duration(1 * MINUTES + 45 * SECONDS)
                .eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(GSItems.ThermalClothTier2, 4),
                        new ItemStack(tungstenString, 4),
                        GTUtility.getIntegratedCircuit(4))
                .itemOutputs(new ItemStack(GSItems.ThermalPaddingTier2, 1, 3))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(1152))
                .duration(60 * SECONDS)
                .eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(GSItems.SpacesuitHelmet), new ItemStack(GCItems.sensorGlasses))
                .itemOutputs(new ItemStack(GSItems.SpacesuitHelmetGlasses))
                .fluidInputs(Materials.Duralumin.getMolten(1440))
                .duration(30 * SECONDS)
                .eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(GSItems.SpacesuitPlate),
                        getModItem("IC2", "itemArmorJetpackElectric", 1, WILDCARD_VALUE))
                .itemOutputs(new ItemStack(GSItems.SpacesuitJetPlate))
                .fluidInputs(Materials.Duralumin.getMolten(1440))
                .duration(30 * SECONDS)
                .eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(GSItems.SpacesuitBoots), new ItemStack(GSItems.CompressedPlates, 2, 4))
                .itemOutputs(new ItemStack(GSItems.SpacesuitGravityBoots))
                .fluidInputs(Materials.Duralumin.getMolten(1440))
                .duration(30 * SECONDS)
                .eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(case1),
                        new ItemStack(keyboard),
                        new ItemStack(display),
                        ItemList.Emitter_HV.get(1),
                        ItemList.Sensor_HV.get(1),
                        new ItemStack(GCItems.heavyPlatingTier1))
                .itemOutputs(new ItemStack(GSItems.ControlComputer, 1, 1))
                .fluidInputs(Materials.SolderingAlloy.getMolten(576))
                .requiresCleanRoom()
                .duration(30 * SECONDS)
                .eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(case1),
                        new ItemStack(keyboard),
                        new ItemStack(display),
                        ItemList.Field_Generator_EV.get(2),
                        new ItemStack(MarsItems.marsItemBasic, 1, 3))
                .itemOutputs(new ItemStack(GSItems.ControlComputer, 1, 2))
                .fluidInputs(Materials.SolderingAlloy.getMolten(864))
                .requiresCleanRoom()
                .duration(30 * SECONDS)
                .eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(case1),
                        new ItemStack(keyboard),
                        new ItemStack(display),
                        ItemList.Emitter_IV.get(1),
                        ItemList.Sensor_IV.get(1),
                        new ItemStack(AsteroidsItems.basicItem))
                .itemOutputs(new ItemStack(GSItems.ControlComputer, 1, 3))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1152))
                .requiresCleanRoom()
                .duration(30 * SECONDS)
                .eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(case2),
                        new ItemStack(keyboard),
                        new ItemStack(display),
                        ItemList.Emitter_IV.get(1),
                        ItemList.Sensor_IV.get(1),
                        new ItemStack(GSItems.heavyDutyPlateT4))
                .itemOutputs(new ItemStack(GSItems.ControlComputer, 1, 4))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1728))
                .requiresCleanRoom()
                .duration(30 * SECONDS)
                .eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(case2),
                        new ItemStack(keyboard),
                        new ItemStack(display),
                        ItemList.Emitter_LuV.get(1),
                        ItemList.Sensor_LuV.get(1),
                        new ItemStack(GSItems.heavyDutyPlateT5))
                .itemOutputs(new ItemStack(GSItems.ControlComputer, 1, 5))
                .fluidInputs(Materials.SolderingAlloy.getMolten(2304))
                .requiresCleanRoom()
                .duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LuV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(case3),
                        new ItemStack(keyboard),
                        new ItemStack(display),
                        ItemList.Emitter_ZPM.get(1),
                        ItemList.Sensor_ZPM.get(1),
                        new ItemStack(GSItems.heavyDutyPlateT6))
                .itemOutputs(new ItemStack(GSItems.ControlComputer, 1, 6))
                .fluidInputs(Materials.SolderingAlloy.getMolten(3456))
                .requiresCleanRoom()
                .duration(30 * SECONDS)
                .eut(TierEU.RECIPE_ZPM)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(case3),
                        new ItemStack(keyboard),
                        new ItemStack(display),
                        ItemList.Emitter_UV.get(1),
                        ItemList.Sensor_UV.get(1),
                        new ItemStack(GSItems.heavyDutyPlateT7))
                .itemOutputs(new ItemStack(GSItems.ControlComputer, 1, 7))
                .fluidInputs(Materials.SolderingAlloy.getMolten(4608))
                .requiresCleanRoom()
                .duration(30 * SECONDS)
                .eut(TierEU.RECIPE_UV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(case3),
                        new ItemStack(keyboard),
                        new ItemStack(display),
                        ItemList.Emitter_UV.get(1),
                        ItemList.Sensor_UV.get(1),
                        new ItemStack(GSItems.heavyDutyPlateT8))
                .itemOutputs(new ItemStack(GSItems.ControlComputer, 1, 8))
                .fluidInputs(Materials.SolderingAlloy.getMolten(6912))
                .requiresCleanRoom()
                .duration(30 * SECONDS)
                .eut(TierEU.RECIPE_UV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(case1),
                        new ItemStack(GCItems.basicItem, 1, 14),
                        GTOreDictUnificator.get("circuitData", 1),
                        ItemList.Emitter_HV.get(1),
                        ItemList.Sensor_HV.get(1),
                        new ItemStack(GCItems.heavyPlatingTier1))
                .itemOutputs(new ItemStack(GSItems.ControlComputer, 1, 100))
                .fluidInputs(Materials.SolderingAlloy.getMolten(576))
                .requiresCleanRoom()
                .duration(30 * SECONDS)
                .eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(case1),
                        new ItemStack(GCItems.basicItem, 1, 14),
                        GTOreDictUnificator.get("circuitElite", 1),
                        ItemList.Emitter_EV.get(1),
                        ItemList.Sensor_EV.get(1),
                        new ItemStack(MarsItems.marsItemBasic, 1, 3))
                .itemOutputs(new ItemStack(GSItems.ControlComputer, 1, 101))
                .fluidInputs(Materials.SolderingAlloy.getMolten(864))
                .requiresCleanRoom()
                .duration(30 * SECONDS)
                .eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(case1),
                        new ItemStack(GCItems.basicItem, 1, 14),
                        GTOreDictUnificator.get("circuitMaster", 1),
                        ItemList.Emitter_IV.get(1),
                        ItemList.Sensor_IV.get(1),
                        new ItemStack(AsteroidsItems.basicItem))
                .itemOutputs(new ItemStack(GSItems.ControlComputer, 1, 102))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1152))
                .requiresCleanRoom()
                .duration(30 * SECONDS)
                .eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "tile.NeutroniumPlatedReinforcedStone", 1),
                        WerkstoffLoader.HDCS.get(OrePrefixes.plate, 8))
                .itemOutputs(new ItemStack(GSBlocks.DysonSwarmBlocks, 1, 9))
                .fluidInputs(FluidRegistry.getFluidStack("molten.adamantium alloy", 144))
                .duration(25 * SECONDS)
                .eut(TierEU.RECIPE_LuV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(GSItems.DysonSwarmItems, 4, 1), new ItemStack(GSItems.DysonSwarmItems, 4, 2))
                .itemOutputs(new ItemStack(GSItems.DysonSwarmItems, 1, 3))
                .duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LuV)
                .addTo(assemblerRecipes);

        // Chemical Reactor
        RA.stdBuilder()
                .itemInputs(Materials.Carbon.getDust(1), GTOreDictUnificator.get("dustHafnia", 1))
                .itemOutputs(GSMaterials.hafniumCarbide.get(OrePrefixes.dust))
                .fluidOutputs(Materials.Oxygen.getGas(2000))
                .duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV)
                .addTo(UniversalChemical);

        // Mixer
        RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get("dustTantalumCarbide", 4),
                        GSMaterials.hafniumCarbide.get(OrePrefixes.dust),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GSMaterials.tantalumCarbideHafniumCarbideMixture.get(OrePrefixes.dust, 5))
                .duration(10 * SECONDS)
                .eut(TierEU.RECIPE_EV)
                .addTo(mixerRecipes);

        // Plasma Arc Furnace
        GTValues.RA.stdBuilder()
                .itemInputs(GSMaterials.tantalumCarbideHafniumCarbideMixture.get(OrePrefixes.dust))
                .itemOutputs(GSMaterials.tantalumHafniumCarbide.get(OrePrefixes.ingot, 1))
                .fluidInputs(Materials.Nitrogen.getPlasma(2))
                .fluidOutputs(Materials.Nitrogen.getGas(1))
                .duration(5 * TICKS)
                .eut(TierEU.RECIPE_IV)
                .addTo(plasmaArcFurnaceRecipes);

        // Vacuum Freezer
        GTValues.RA.stdBuilder()
                .fluidInputs(Materials.Helium.getGas(1000))
                .fluidOutputs(GSMaterials.liquidHelium.getFluidOrGas(1000))
                .duration(1 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_MV)
                .addTo(vacuumFreezerRecipes);

        // Autoclave
        GTValues.RA.stdBuilder()
                .itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1))
                .itemOutputs(new ItemStack(GSItems.UnknowCrystal))
                .outputChances(90_00)
                .fluidInputs(Materials.Water.getFluid(1000))
                .duration(3 * MINUTES)
                .eut(TierEU.RECIPE_HV)
                .addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1))
                .itemOutputs(new ItemStack(GSItems.UnknowCrystal))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 1000))
                .duration(2 * MINUTES)
                .eut(TierEU.RECIPE_HV)
                .addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(GSItems.DysonSwarmItems, 1, 4))
                .itemOutputs(new ItemStack(GSItems.DysonSwarmItems, 5, 1))
                .fluidInputs(GSMaterials.tantalumHafniumCarbide.getMolten(576))
                .duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV)
                .addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(GSItems.DysonSwarmItems, 1, 5))
                .itemOutputs(new ItemStack(GSItems.DysonSwarmItems, 5, 2))
                .fluidInputs(Materials.Neutronium.getMolten(576))
                .duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV)
                .addTo(autoclaveRecipes);

        // Compressor
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(GSItems.GlowstoneDusts, 4))
                .itemOutputs(new ItemStack(GSBlocks.CeresGlowStone))
                .duration(15 * SECONDS)
                .eut(2)
                .addTo(compressorRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(GSItems.GlowstoneDusts, 4, 1))
                .itemOutputs(new ItemStack(GSBlocks.IoGlowStone))
                .duration(15 * SECONDS)
                .eut(2)
                .addTo(compressorRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(GSItems.GlowstoneDusts, 4, 2))
                .itemOutputs(new ItemStack(GSBlocks.EnceladusGlowStone))
                .duration(15 * SECONDS)
                .eut(2)
                .addTo(compressorRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(GSItems.GlowstoneDusts, 4, 3))
                .itemOutputs(new ItemStack(GSBlocks.ProteusGlowStone))
                .duration(15 * SECONDS)
                .eut(2)
                .addTo(compressorRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(GSItems.GlowstoneDusts, 4, 4))
                .itemOutputs(new ItemStack(GSBlocks.PlutoGlowStone))
                .duration(15 * SECONDS)
                .eut(2)
                .addTo(compressorRecipes);

        // Laser Engraver
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(blueprint), getGTNHItem("SchematicsMoonBuggy", 0))
                .itemOutputs(new ItemStack(GCItems.schematic))
                .requiresCleanRoom()
                .duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(blueprint), getGTNHItem("SchematicsTier2", 0))
                .itemOutputs(new ItemStack(GCItems.schematic, 1, 1))
                .requiresCleanRoom()
                .duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(blueprint), getGTNHItem("SchematicsTier3", 0))
                .itemOutputs(new ItemStack(MarsItems.schematic))
                .requiresCleanRoom()
                .duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(blueprint), getGTNHItem("SchematicsCargoRocket", 0))
                .itemOutputs(new ItemStack(MarsItems.schematic, 1, 1))
                .requiresCleanRoom()
                .duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(blueprint), getGTNHItem("SchematicsAstroMiner", 0))
                .itemOutputs(new ItemStack(MarsItems.schematic, 1, 2))
                .requiresCleanRoom()
                .duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(blueprint), getGTNHItem("SchematicsTier4", 0))
                .itemOutputs(new ItemStack(GSItems.Tier4Schematic))
                .requiresCleanRoom()
                .duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(blueprint), getGTNHItem("SchematicsTier5", 0))
                .itemOutputs(new ItemStack(GSItems.Tier5Schematic))
                .requiresCleanRoom()
                .duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(blueprint), getGTNHItem("SchematicsTier6", 0))
                .itemOutputs(new ItemStack(GSItems.Tier6Schematic))
                .requiresCleanRoom()
                .duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(blueprint), getGTNHItem("SchematicsTier7", 0))
                .itemOutputs(new ItemStack(GSItems.Tier7Schematic))
                .requiresCleanRoom()
                .duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(blueprint), getGTNHItem("SchematicsTier8", 0))
                .itemOutputs(new ItemStack(GSItems.Tier8Schematic))
                .requiresCleanRoom()
                .duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV)
                .addTo(laserEngraverRecipes);

        // Pulverization
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(GSBlocks.CeresGlowStone))
                .itemOutputs(new ItemStack(GSItems.GlowstoneDusts, 4))
                .duration(15 * SECONDS)
                .eut(2)
                .addTo(maceratorRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(GSBlocks.IoGlowStone))
                .itemOutputs(new ItemStack(GSItems.GlowstoneDusts, 4, 1))
                .duration(15 * SECONDS)
                .eut(2)
                .addTo(maceratorRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(GSBlocks.EnceladusGlowStone))
                .itemOutputs(new ItemStack(GSItems.GlowstoneDusts, 4, 2))
                .duration(15 * SECONDS)
                .eut(2)
                .addTo(maceratorRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(GSBlocks.ProteusGlowStone))
                .itemOutputs(new ItemStack(GSItems.GlowstoneDusts, 4, 3))
                .duration(15 * SECONDS)
                .eut(2)
                .addTo(maceratorRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(GSBlocks.PlutoGlowStone))
                .itemOutputs(new ItemStack(GSItems.GlowstoneDusts, 4, 4))
                .duration(15 * SECONDS)
                .eut(2)
                .addTo(maceratorRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(GSMaterials.tantalumHafniumCarbide.get(OrePrefixes.dust))
                .itemOutputs(new ItemStack(GSItems.DysonSwarmItems, 1, 4))
                .duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV)
                .addTo(maceratorRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(Materials.Neutronium.getDust(1))
                .itemOutputs(new ItemStack(GSItems.DysonSwarmItems, 1, 5))
                .duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV)
                .addTo(maceratorRecipes);

        // Shaped Crafting
        addDyedFutureGlassRecipe(0, "Black");
        addDyedFutureGlassRecipe(1, "Red");
        addDyedFutureGlassRecipe(2, "Green");
        addDyedFutureGlassRecipe(3, "Brown");
        addDyedFutureGlassRecipe(4, "Blue");
        addDyedFutureGlassRecipe(5, "Purple");
        addDyedFutureGlassRecipe(6, "Cyan");
        addDyedFutureGlassRecipe(7, "LightGray");
        addDyedFutureGlassRecipe(8, "Gray");
        addDyedFutureGlassRecipe(9, "Pink");
        addDyedFutureGlassRecipe(10, "Lime");
        addDyedFutureGlassRecipe(11, "Yellow");
        addDyedFutureGlassRecipe(12, "LightBlue");
        addDyedFutureGlassRecipe(13, "Magenta");
        addDyedFutureGlassRecipe(14, "Orange");
        addDyedFutureGlassRecipe(15, "White");
        addDecorativeMetalBlockRecipe(0, getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 3, missing));
        addDecorativeMetalBlockRecipe(1, getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 0, missing));
        addDecorativeMetalBlockRecipe(2, getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 1, missing));
        addDecorativeMetalBlockRecipe(3, getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 4, missing));
        addDecorativeMetalBlockRecipe(4, getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 5, missing));
        addDecorativeMetalBlockRecipe(5, getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 6, missing));
        addDecorativeMetalBlockRecipe(6, getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 7, missing));
        addDecorativeMetalBlockRecipe(7, getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 8, missing));
        addDecorativeMetalBlockRecipe(8, getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 9, missing));
        addDecorativeMetalBlockRecipe(9, new ItemStack(GCItems.basicItem, 1, 6));

        RecipeUtil.addRecipe(
                new ItemStack(GSBlocks.MachineFrames),
                new Object[] { "MWM", "CTC", "MWM", 'M', new ItemStack(GSItems.CompressedPlates, 1, 5), 'W', waferT3,
                        'C', new ItemStack(GCBlocks.aluminumWire, 1, 1), 'T', new ItemStack(GregTechAPI.sBlockCasings4) });
        RecipeUtil.addRecipe(
                new ItemStack(GSBlocks.StorageModuleT3),
                new Object[] { "CEC", "WFW", "CEC", 'C', new ItemStack(GSItems.CompressedPlates, 1, 9), 'E',
                        new ItemStack(GCBlocks.machineTiered, 1, 8), 'W', waferT3, 'F',
                        new ItemStack(GSBlocks.MachineFrames) });
        RecipeUtil.addRecipe(
                new ItemStack(GSBlocks.OxStorageModuleT2),
                new Object[] { "SCS", "PFP", "SWS", 'S', new ItemStack(GCBlocks.machineBase2, 1, 8), 'C',
                        new ItemStack(GCItems.oxygenConcentrator), 'P', new ItemStack(GCBlocks.oxygenPipe), 'F',
                        new ItemStack(GSBlocks.MachineFrames), 'W', waferT3 });
        RecipeUtil.addRecipe(
                new ItemStack(GSBlocks.SolarWindPanel),
                new Object[] { "TFT", "APA", "MWS", 'T', new ItemStack(AsteroidsItems.basicItem, 1, 6), 'F',
                        new ItemStack(GSItems.SolarFlares, 1, 1), 'A', new ItemStack(GCBlocks.aluminumWire, 1, 1), 'P',
                        new ItemStack(GCItems.flagPole), 'M', ItemList.Electric_Motor_LV.get(1), 'W',
                        new ItemStack(GCItems.basicItem, 1, 14), 'S', ItemList.Sensor_LV.get(1) });
        RecipeUtil.addRecipe(
                new ItemStack(GSBlocks.SolarPanel),
                new Object[] { "DSD", "AFA", "MWs", 'D', new ItemStack(GSItems.CompressedPlates, 1, 2), 'S',
                        new ItemStack(GCItems.basicItem, 1, 1), 'A', new ItemStack(GCBlocks.aluminumWire, 1, 1), 'F',
                        new ItemStack(GSBlocks.MachineFrames), 'M', ItemList.Electric_Motor_MV.get(1), 'W', waferT3, 's',
                        ItemList.Sensor_MV.get(1) });

        RecipeUtil.addRecipe(
                new ItemStack(BRBlocks.BarnardaCPlanks, 4),
                new Object[] { "L", 'L', new ItemStack(BRBlocks.BarnardaCLog) }); // GT replaces this recipe
        // automatically
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.SpacesuitBoots),
                new Object[] { "ABA", "ADA", "CDC", 'A', new ItemStack(GSItems.CompressedSDHD120), 'B',
                        new ItemStack(GSItems.LeadBoots), 'D', new ItemStack(MarsItems.marsItemBasic, 1, 5), 'C',
                        new ItemStack(GSItems.CompressedPlates, 1, 2) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.QuantBow),
                new Object[] { "LMS", "m S", "LMS", 'L',
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Lead, 1), 'M',
                        getGTNHItem("MytrylCrystal"), 'S', GTModHandler.getModItem("TConstruct", "bowstring", 1, 2), 'm',
                        getGTNHItem("MysteriousCrystal") });

        RecipeUtil.addRecipe(
                new ItemStack(GSItems.LeadHelmet),
                new Object[] { "LLL", "LHL", "D D", 'L', new ItemStack(GSItems.CompressedPlates, 1, 3), 'H',
                        "craftingToolHardHammer", 'D', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.LeadPlate),
                new Object[] { "LHL", "LDL", "L L", 'L', new ItemStack(GSItems.CompressedPlates, 1, 3), 'H',
                        "craftingToolHardHammer", 'D', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.LeadLeg),
                new Object[] { "LLL", "LDL", "LHL", 'L', new ItemStack(GSItems.CompressedPlates, 1, 3), 'H',
                        "craftingToolHardHammer", 'D', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.LeadBoots),
                new Object[] { "D D", "LHL", "L L", 'L', new ItemStack(GSItems.CompressedPlates, 1, 3), 'H',
                        "craftingToolHardHammer", 'D', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.CobaltumHelmet),
                new Object[] { "CCC", "CHC", "D D", 'C', new ItemStack(GSItems.CompressedPlates, 1, 1), 'H',
                        "craftingToolHardHammer", 'D', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.CobaltumPlate),
                new Object[] { "CHC", "CDC", "C C", 'C', new ItemStack(GSItems.CompressedPlates, 1, 1), 'H',
                        "craftingToolHardHammer", 'D', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.CobaltumLeg),
                new Object[] { "CCC", "CDC", "CHC", 'C', new ItemStack(GSItems.CompressedPlates, 1, 1), 'H',
                        "craftingToolHardHammer", 'D', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.CobaltumBoots),
                new Object[] { "D D", "CHC", "C C", 'C', new ItemStack(GSItems.CompressedPlates, 1, 1), 'H',
                        "craftingToolHardHammer", 'D', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.SpacesuitHelmet),
                new Object[] { "AHA", "AMA", "DCD", 'A', new ItemStack(GSItems.CompressedSDHD120), 'H',
                        new ItemStack(GSItems.LeadHelmet), 'M', new ItemStack(GCItems.oxMask), 'D',
                        new ItemStack(MarsItems.marsItemBasic, 1, 5), 'C', new ItemStack(GCItems.oxygenConcentrator) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.SpacesuitPlate),
                new Object[] { "APA", "ACA", "ADA", 'A', new ItemStack(GSItems.CompressedSDHD120), 'P',
                        new ItemStack(GSItems.LeadPlate), 'C', new ItemStack(GSItems.CompressedPlates, 1, 2), 'D',
                        new ItemStack(MarsItems.marsItemBasic, 1, 5) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.SpacesuitLeg),
                new Object[] { "ALA", "CAC", "CDC", 'A', new ItemStack(GSItems.CompressedSDHD120), 'L',
                        new ItemStack(GSItems.LeadLeg), 'C', new ItemStack(GSItems.CompressedPlates, 1, 2), 'D',
                        new ItemStack(MarsItems.marsItemBasic, 1, 5) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.ModuleLander),
                new Object[] { "FSS", "SBC", "PEP", 'F', new ItemStack(GCItems.basicItem, 1, 19), 'S',
                        new ItemStack(GCItems.basicItem, 1, 9), 'B', new ItemStack(GCItems.partBuggy, 1, 1), 'C',
                        new ItemStack(GCItems.basicItem, 1, 6), 'P', new ItemStack(GCItems.flagPole), 'E',
                        new ItemStack(GCItems.rocketEngine) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.ModuleLanderT2),
                new Object[] { "FPF", "CLC", "FCF", 'F', GTOreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 1), 'P',
                        new ItemStack(GCItems.parachute, 1, WILDCARD_VALUE), 'C', new ItemStack(GCItems.canvas), 'L',
                        new ItemStack(GSItems.ModuleLander) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.ModuleLanderT3),
                new Object[] { "DDD", "PLP", "DDD", 'D', new ItemStack(MarsItems.marsItemBasic, 1, 5), 'P',
                        new ItemStack(GCItems.flagPole), 'L', new ItemStack(GSItems.ModuleLanderT2) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.PlasmaSword, 1, 100),
                new Object[] { "DCD", "FCH", "DBW", 'D', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1), 'C',
                        new ItemStack(GSItems.CompressedPlates, 1, 1), 'F', "craftingToolFile", 'H', "craftingToolHardHammer",
                        'B', new ItemStack(GCItems.battery, 1, WILDCARD_VALUE), 'W',
                        new ItemStack(GCBlocks.aluminumWire, 1, 1) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.PlasmaPickaxe, 1, 100),
                new Object[] { "CCC", "FPH", "DBW", 'C', new ItemStack(GSItems.CompressedPlates, 1, 1), 'F',
                        "craftingToolFile", 'P', new ItemStack(GCItems.flagPole), 'H', "craftingToolHardHammer", 'D',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1), 'B',
                        new ItemStack(GCItems.battery, 1, WILDCARD_VALUE), 'W', new ItemStack(GCBlocks.aluminumWire, 1, 1) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.PlasmaAxe, 1, 100),
                new Object[] { "CCH", "CPD", "FBW", 'C', new ItemStack(GSItems.CompressedPlates, 1, 1), 'H',
                        "craftingToolHardHammer", 'P', new ItemStack(GCItems.flagPole), 'D',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1), 'F', "craftingToolFile", 'B',
                        new ItemStack(GCItems.battery, 1, WILDCARD_VALUE), 'W', new ItemStack(GCBlocks.aluminumWire, 1, 1) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.PlasmaShovel, 1, 100),
                new Object[] { "FCH", "DPD", "WBW", 'F', "craftingToolFile", 'C',
                        new ItemStack(GSItems.CompressedPlates, 1, 1), 'H', "craftingToolHardHammer", 'D',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1), 'P', new ItemStack(GCItems.flagPole),
                        'W', new ItemStack(GCBlocks.aluminumWire, 1, 1), 'B',
                        new ItemStack(GCItems.battery, 1, WILDCARD_VALUE) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.PlasmaHoe, 1, 100),
                new Object[] { "CCH", "FPD", "WBD", 'C', new ItemStack(GSItems.CompressedPlates, 1, 1), 'H',
                        "craftingToolHardHammer", 'F', "craftingToolFile", 'P', new ItemStack(GCItems.flagPole), 'D',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1), 'W',
                        new ItemStack(GCBlocks.aluminumWire, 1, 1), 'B', new ItemStack(GCItems.battery, 1, WILDCARD_VALUE) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.SolarFlares),
                new Object[] { "IPI", "PSP", "PsP", 'I', new ItemStack(GCItems.basicItem, 1, 11), 'P',
                        new ItemStack(GCItems.flagPole), 'S', new ItemStack(GCItems.basicItem, 1, 1), 's',
                        new ItemStack(GCItems.basicItem, 1, 9) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.SolarFlares, 1, 1),
                new Object[] { "DFD", "FTF", "DFD", 'D', new ItemStack(MarsItems.marsItemBasic, 1, 5), 'F',
                        new ItemStack(GSItems.SolarFlares), 'T', new ItemStack(AsteroidsItems.basicItem, 1, 6) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.RobotArm),
                new Object[] { "NNL", "MRA", "PCR", 'N',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherStar, 1), 'L',
                        new ItemStack(GCItems.sensorLens), 'M', new ItemStack(MetaGeneratedItem01.INSTANCE, 1, 32602), 'R',
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.StainlessSteel, 1), 'A',
                        ItemList.Robot_Arm_HV.get(1), 'P', ItemList.Electric_Piston_HV.get(1), 'C', "circuitData" });
        if (OpenModularTurrets.isModLoaded()) {
            RecipeUtil.addRecipe(
                    new ItemStack(GCBlocks.nasaWorkbench),
                    new Object[] { "RRR", "CDC", "WAW", 'R', new ItemStack(GSItems.RobotArm), 'C', "circuitElite", 'D',
                            display, 'W', GTModHandler.getModItem("openmodularturrets", "hardWallTierFour", 1), 'A',
                            new ItemStack(GregTechAPI.sBlockMachines, 1, 213) });
        }
        RecipeUtil.addRecipe(
                getGTNHItem("RawSDHCAlloy"),
                new Object[] { "SDS", "BCA", "SHS", 'S',
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1), 'D',
                        "craftingToolScrewDriver", 'B', new ItemStack(GSItems.CompressedDualBronze), 'C',
                        new ItemStack(GSItems.CompressedCoal), 'A', new ItemStack(GSItems.CompressedDualAluminium), 'H',
                        "craftingToolHardHammer" });
    }

    private void addDyedFutureGlassRecipe(int meta, String color) {
        ItemStack futureGlasses = getModItem(GalaxySpace.ID, "futureglasses", 8, meta, missing);
        ItemStack futureGlass = getModItem(GalaxySpace.ID, "futureglass", 1, 0, missing);
        addShapedRecipe(futureGlasses, "GGG", "GDG", "GGG", 'G', futureGlass, 'D', "dye" + color);
    }

    private void addDecorativeMetalBlockRecipe(int meta, ItemStack plate) {
        ItemStack metalBlock = getModItem(GalaxySpace.ID, "metalsblock", 1, meta, missing);
        addShapedRecipe(metalBlock, "HP ", "PSP", " PW", 'H', "craftingToolHardHammer", 'P', plate, 'S', "stone", 'W', "craftingToolWrench");
    }
}
