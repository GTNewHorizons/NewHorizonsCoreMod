package com.dreammaster.scripts;

import static gregtech.api.enums.GTValues.W;
import static gregtech.api.enums.Mods.BuildCraftBuilders;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.GalacticraftMars;
import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.autoclaveRecipes;
import static gregtech.api.recipe.RecipeMaps.compressorRecipes;
import static gregtech.api.recipe.RecipeMaps.laserEngraverRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.recipe.RecipeMaps.mixerRecipes;
import static gregtech.api.recipe.RecipeMaps.plasmaArcFurnaceRecipes;
import static gregtech.api.recipe.RecipeMaps.vacuumFreezerRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gregtech.api.util.GTRecipeConstants.UniversalChemical;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.gthandler.CustomItemList;

import bartworks.system.material.WerkstoffLoader;
import gregtech.api.GregTechAPI;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gregtech.common.items.MetaGeneratedItem01;
import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;

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
                BuildCraftBuilders.ID,
                IndustrialCraft2.ID);
    }

    @Override
    public void loadRecipes() {
        // Assembler
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Blocks.glass), GTOreDictUnificator.get(OrePrefixes.stick, Materials.Desh, 8))
                .itemOutputs(getGSItem("futureglass", 1, 0)).duration(10 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(GCItems.battery, 1, W), GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getGSItem("item.LeadBattery", 1, 100)).fluidInputs(Materials.Lead.getMolten(6000))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getGSItem("item.ThermalPaddingT2", 1, 0), GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getGSItem("item.ThermalClothT2", 5, 0)).duration(18 * SECONDS).eut(1024)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getGSItem("item.ThermalPaddingT2", 1, 1), GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getGSItem("item.ThermalClothT2", 8, 0)).duration(30 * SECONDS).eut(1024)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getGSItem("item.ThermalPaddingT2", 1, 2), GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getGSItem("item.ThermalClothT2", 7, 0)).duration(26 * SECONDS).eut(1024)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getGSItem("item.ThermalPaddingT2", 1, 3), GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getGSItem("item.ThermalClothT2", 4, 0)).duration(15 * SECONDS).eut(1024)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(AsteroidsItems.basicItem, 1, 7),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Titanium, 8),
                        CustomItemList.TungstenString.get(8),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getGSItem("item.ThermalClothT2", 1, 0))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(576)).duration(30 * SECONDS).eut(1024)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getGSItem("item.ThermalClothT2", 5, 0),
                        CustomItemList.TungstenString.get(5),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(getGSItem("item.ThermalPaddingT2", 1, 0))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(1440)).duration(1 * MINUTES + 15 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getGSItem("item.ThermalClothT2", 8, 0),
                        CustomItemList.TungstenString.get(8),
                        GTUtility.getIntegratedCircuit(8))
                .itemOutputs(getGSItem("item.ThermalPaddingT2", 1, 1))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(2304)).duration(2 * MINUTES).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getGSItem("item.ThermalClothT2", 7, 0),
                        CustomItemList.TungstenString.get(7),
                        GTUtility.getIntegratedCircuit(7))
                .itemOutputs(getGSItem("item.ThermalPaddingT2", 1, 2))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(2016)).duration(1 * MINUTES + 45 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getGSItem("item.ThermalClothT2", 4, 0),
                        CustomItemList.TungstenString.get(4),
                        GTUtility.getIntegratedCircuit(4))
                .itemOutputs(getGSItem("item.ThermalPaddingT2", 1, 3))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(1152)).duration(60 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getGSItem("item.spacesuit_helmet", 1, 0), new ItemStack(GCItems.sensorGlasses))
                .itemOutputs(getGSItem("item.spacesuit_helmetglasses", 1, 0))
                .fluidInputs(Materials.Duralumin.getMolten(1440)).duration(30 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getGSItem("item.spacesuit_plate", 1, 0),
                        getModItem(IndustrialCraft2.ID, "itemArmorJetpackElectric", 1, W, missing))
                .itemOutputs(getGSItem("item.spacesuit_jetplate", 1, 0))
                .fluidInputs(Materials.Duralumin.getMolten(1440)).duration(30 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(
                getGSItem("item.spacesuit_boots", 1, 0),
                // Compressed Magnesium
                getGSItem("item.CompressedPlates", 2, 4)).itemOutputs(getGSItem("item.spacesuit_gravityboots", 1, 0))
                .fluidInputs(Materials.Duralumin.getMolten(1440)).duration(30 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "case1", 1, 0, missing),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0, missing),
                        CustomItemList.Display.get(1),
                        ItemList.Emitter_HV.get(1),
                        ItemList.Sensor_HV.get(1),
                        new ItemStack(GCItems.heavyPlatingTier1))
                .itemOutputs(getGSItem("item.RocketControlComputer", 1, 1))
                .fluidInputs(Materials.SolderingAlloy.getMolten(576)).requiresCleanRoom().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "case1", 1, 0, missing),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0, missing),
                        CustomItemList.Display.get(1),
                        ItemList.Field_Generator_EV.get(2),
                        new ItemStack(MarsItems.marsItemBasic, 1, 3))
                .itemOutputs(getGSItem("item.RocketControlComputer", 1, 2))
                .fluidInputs(Materials.SolderingAlloy.getMolten(864)).requiresCleanRoom().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "case1", 1, 0, missing),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0, missing),
                        CustomItemList.Display.get(1),
                        ItemList.Emitter_IV.get(1),
                        ItemList.Sensor_IV.get(1),
                        new ItemStack(AsteroidsItems.basicItem))
                .itemOutputs(getGSItem("item.RocketControlComputer", 1, 3))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1152)).requiresCleanRoom().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "case2", 1, 0, missing),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0, missing),
                        CustomItemList.Display.get(1),
                        ItemList.Emitter_IV.get(1),
                        ItemList.Sensor_IV.get(1),
                        getGSItem("item.HeavyDutyPlateTier4", 1, 0))
                .itemOutputs(getGSItem("item.RocketControlComputer", 1, 4))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1728)).requiresCleanRoom().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "case2", 1, 0, missing),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0, missing),
                        CustomItemList.Display.get(1),
                        ItemList.Emitter_LuV.get(1),
                        ItemList.Sensor_LuV.get(1),
                        getGSItem("item.HeavyDutyPlateTier5", 1, 0))
                .itemOutputs(getGSItem("item.RocketControlComputer", 1, 5))
                .fluidInputs(Materials.SolderingAlloy.getMolten(2304)).requiresCleanRoom().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "case3", 1, 0, missing),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0, missing),
                        CustomItemList.Display.get(1),
                        ItemList.Emitter_ZPM.get(1),
                        ItemList.Sensor_ZPM.get(1),
                        getGSItem("item.HeavyDutyPlateTier6", 1, 0))
                .itemOutputs(getGSItem("item.RocketControlComputer", 1, 6))
                .fluidInputs(Materials.SolderingAlloy.getMolten(3456)).requiresCleanRoom().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "case3", 1, 0, missing),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0, missing),
                        CustomItemList.Display.get(1),
                        ItemList.Emitter_UV.get(1),
                        ItemList.Sensor_UV.get(1),
                        getGSItem("item.HeavyDutyPlateTier7", 1, 0))
                .itemOutputs(getGSItem("item.RocketControlComputer", 1, 7))
                .fluidInputs(Materials.SolderingAlloy.getMolten(4608)).requiresCleanRoom().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "case3", 1, 0, missing),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0, missing),
                        CustomItemList.Display.get(1),
                        ItemList.Emitter_UV.get(1),
                        ItemList.Sensor_UV.get(1),
                        getGSItem("item.HeavyDutyPlateTier8", 1, 0))
                .itemOutputs(getGSItem("item.RocketControlComputer", 1, 8))
                .fluidInputs(Materials.SolderingAlloy.getMolten(6912)).requiresCleanRoom().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "case1", 1, 0, missing),
                        new ItemStack(GCItems.basicItem, 1, 14),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.EV, 1),
                        ItemList.Emitter_HV.get(1),
                        ItemList.Sensor_HV.get(1),
                        new ItemStack(GCItems.heavyPlatingTier1))
                .itemOutputs(getGSItem("item.RocketControlComputer", 1, 100))
                .fluidInputs(Materials.SolderingAlloy.getMolten(576)).requiresCleanRoom().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "case1", 1, 0, missing),
                        new ItemStack(GCItems.basicItem, 1, 14),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 1),
                        ItemList.Emitter_EV.get(1),
                        ItemList.Sensor_EV.get(1),
                        new ItemStack(MarsItems.marsItemBasic, 1, 3))
                .itemOutputs(getGSItem("item.RocketControlComputer", 1, 101))
                .fluidInputs(Materials.SolderingAlloy.getMolten(864)).requiresCleanRoom().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "case1", 1, 0, missing),
                        new ItemStack(GCItems.basicItem, 1, 14),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LuV, 1),
                        ItemList.Emitter_IV.get(1),
                        ItemList.Sensor_IV.get(1),
                        new ItemStack(AsteroidsItems.basicItem))
                .itemOutputs(getGSItem("item.RocketControlComputer", 1, 102))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1152)).requiresCleanRoom().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "tile.NeutroniumPlatedReinforcedStone", 1),
                        WerkstoffLoader.HDCS.get(OrePrefixes.plate, 8))
                .itemOutputs(new ItemStack(GSBlocks.DysonSwarmBlocks, 1, 9))
                .fluidInputs(FluidRegistry.getFluidStack("molten.adamantium alloy", 144)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(GSItems.DysonSwarmItems, 4, 1), new ItemStack(GSItems.DysonSwarmItems, 4, 2))
                .itemOutputs(new ItemStack(GSItems.DysonSwarmItems, 1, 3)).duration(10 * SECONDS).eut(TierEU.RECIPE_LuV)
                .addTo(assemblerRecipes);

        // Chemical Reactor
        GTValues.RA.stdBuilder().itemInputs(Materials.Carbon.getDust(1), GTOreDictUnificator.get("dustHafnia", 1))
                .itemOutputs(GSMaterials.hafniumCarbide.get(OrePrefixes.dust))
                .fluidOutputs(Materials.Oxygen.getGas(2000)).duration(20 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(UniversalChemical);

        // Mixer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get("dustTantalumCarbide", 4),
                        GSMaterials.hafniumCarbide.get(OrePrefixes.dust),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GSMaterials.tantalumCarbideHafniumCarbideMixture.get(OrePrefixes.dust, 5))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_EV).addTo(mixerRecipes);

        // Plasma Arc Furnace
        GTValues.RA.stdBuilder().itemInputs(GSMaterials.tantalumCarbideHafniumCarbideMixture.get(OrePrefixes.dust))
                .itemOutputs(GSMaterials.tantalumHafniumCarbide.get(OrePrefixes.ingot, 1))
                .fluidInputs(Materials.Nitrogen.getPlasma(2)).fluidOutputs(Materials.Nitrogen.getGas(1))
                .duration(5 * TICKS).eut(TierEU.RECIPE_IV).addTo(plasmaArcFurnaceRecipes);

        // Vacuum Freezer
        GTValues.RA.stdBuilder().fluidInputs(Materials.Helium.getGas(1000))
                .fluidOutputs(GSMaterials.liquidHelium.getFluidOrGas(1000)).duration(1 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(vacuumFreezerRecipes);

        // Autoclave
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1))
                .itemOutputs(getGSItem("item.UnknowCrystal", 1, 0)).outputChances(90_00)
                .fluidInputs(Materials.Water.getFluid(1000)).duration(3 * MINUTES).eut(TierEU.RECIPE_HV)
                .addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1))
                .itemOutputs(getGSItem("item.UnknowCrystal", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 1000)).duration(2 * MINUTES)
                .eut(TierEU.RECIPE_HV).addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(GSItems.DysonSwarmItems, 1, 4))
                .itemOutputs(new ItemStack(GSItems.DysonSwarmItems, 5, 1))
                .fluidInputs(GSMaterials.tantalumHafniumCarbide.getMolten(576)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(GSItems.DysonSwarmItems, 1, 5))
                .itemOutputs(new ItemStack(GSItems.DysonSwarmItems, 5, 2))
                .fluidInputs(Materials.Neutronium.getMolten(576)).duration(50 * SECONDS).eut(TierEU.RECIPE_IV)
                .addTo(autoclaveRecipes);

        // Compressor
        GTValues.RA.stdBuilder().itemInputs(getGSItem("item.GlowstoneDusts", 4, 0))
                .itemOutputs(getGSItem("ceresglowstone", 1, 0)).duration(15 * SECONDS).eut(2).addTo(compressorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getGSItem("item.GlowstoneDusts", 4, 1))
                .itemOutputs(getGSItem("ioglowstone", 1, 0)).duration(15 * SECONDS).eut(2).addTo(compressorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getGSItem("item.GlowstoneDusts", 4, 2))
                .itemOutputs(getGSItem("enceladusglowstone", 1, 0)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getGSItem("item.GlowstoneDusts", 4, 3))
                .itemOutputs(getGSItem("proteusglowstone", 1, 0)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getGSItem("item.GlowstoneDusts", 4, 4))
                .itemOutputs(getGSItem("plutoglowstone", 1, 0)).duration(15 * SECONDS).eut(2).addTo(compressorRecipes);

        // Laser Engraver
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftBuilders.ID, "blueprintItem", 1, 0, missing),
                        CustomItemList.SchematicsMoonBuggy.get(1))
                .itemOutputs(new ItemStack(GCItems.schematic)).requiresCleanRoom().duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftBuilders.ID, "blueprintItem", 1, 0, missing),
                        CustomItemList.SchematicsTier2.get(1))
                .itemOutputs(new ItemStack(GCItems.schematic, 1, 1)).requiresCleanRoom().duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftBuilders.ID, "blueprintItem", 1, 0, missing),
                        CustomItemList.SchematicsTier3.get(1))
                .itemOutputs(new ItemStack(MarsItems.schematic)).requiresCleanRoom().duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftBuilders.ID, "blueprintItem", 1, 0, missing),
                        CustomItemList.SchematicsCargoRocket.get(1))
                .itemOutputs(new ItemStack(MarsItems.schematic, 1, 1)).requiresCleanRoom().duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftBuilders.ID, "blueprintItem", 1, 0, missing),
                        CustomItemList.SchematicsAstroMiner.get(1))
                .itemOutputs(new ItemStack(MarsItems.schematic, 1, 2)).requiresCleanRoom().duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftBuilders.ID, "blueprintItem", 1, 0, missing),
                        CustomItemList.SchematicsTier4.get(1))
                .itemOutputs(getGSItem("item.SchematicTier4", 1, 0)).requiresCleanRoom().duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftBuilders.ID, "blueprintItem", 1, 0, missing),
                        CustomItemList.SchematicsTier5.get(1))
                .itemOutputs(getGSItem("item.SchematicTier5", 1, 0)).requiresCleanRoom().duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftBuilders.ID, "blueprintItem", 1, 0, missing),
                        CustomItemList.SchematicsTier6.get(1))
                .itemOutputs(getGSItem("item.SchematicTier6", 1, 0)).requiresCleanRoom().duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftBuilders.ID, "blueprintItem", 1, 0, missing),
                        CustomItemList.SchematicsTier7.get(1))
                .itemOutputs(getGSItem("item.SchematicTier7", 1, 0)).requiresCleanRoom().duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftBuilders.ID, "blueprintItem", 1, 0, missing),
                        CustomItemList.SchematicsTier8.get(1))
                .itemOutputs(getGSItem("item.SchematicTier8", 1, 0)).requiresCleanRoom().duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(laserEngraverRecipes);

        // Pulverization
        GTValues.RA.stdBuilder().itemInputs(getGSItem("ceresglowstone", 1, 0))
                .itemOutputs(getGSItem("item.GlowstoneDusts", 4, 0)).duration(15 * SECONDS).eut(2)
                .addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getGSItem("ioglowstone", 1, 0))
                .itemOutputs(getGSItem("item.GlowstoneDusts", 4, 1)).duration(15 * SECONDS).eut(2)
                .addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getGSItem("enceladusglowstone", 1, 0))
                .itemOutputs(getGSItem("item.GlowstoneDusts", 4, 2)).duration(15 * SECONDS).eut(2)
                .addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getGSItem("proteusglowstone", 1, 0))
                .itemOutputs(getGSItem("item.GlowstoneDusts", 4, 3)).duration(15 * SECONDS).eut(2)
                .addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getGSItem("plutoglowstone", 1, 0))
                .itemOutputs(getGSItem("item.GlowstoneDusts", 4, 4)).duration(15 * SECONDS).eut(2)
                .addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(GSMaterials.tantalumHafniumCarbide.get(OrePrefixes.dust))
                .itemOutputs(new ItemStack(GSItems.DysonSwarmItems, 1, 4)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(Materials.Neutronium.getDust(1))
                .itemOutputs(new ItemStack(GSItems.DysonSwarmItems, 1, 5)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
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
        addDecorativeMetalBlockRecipe(0, getGSItem("item.CompressedPlates", 1, 3));
        addDecorativeMetalBlockRecipe(1, getGSItem("item.CompressedPlates", 1, 0));
        addDecorativeMetalBlockRecipe(2, getGSItem("item.CompressedPlates", 1, 1));
        addDecorativeMetalBlockRecipe(3, getGSItem("item.CompressedPlates", 1, 4));
        addDecorativeMetalBlockRecipe(4, getGSItem("item.CompressedPlates", 1, 5));
        addDecorativeMetalBlockRecipe(5, getGSItem("item.CompressedPlates", 1, 6));
        addDecorativeMetalBlockRecipe(6, getGSItem("item.CompressedPlates", 1, 7));
        addDecorativeMetalBlockRecipe(7, getGSItem("item.CompressedPlates", 1, 8));
        addDecorativeMetalBlockRecipe(8, getGSItem("item.CompressedPlates", 1, 9));
        addDecorativeMetalBlockRecipe(9, new ItemStack(GCItems.basicItem, 1, 6));

        RecipeUtil.addRecipe(
                new ItemStack(GSBlocks.MachineFrames),
                new Object[] { "MWM", "CTC", "MWM", 'M', new ItemStack(GSItems.CompressedPlates, 1, 5), 'W',
                        CustomItemList.WaferTier3.get(1), 'C', new ItemStack(GCBlocks.aluminumWire, 1, 1), 'T',
                        new ItemStack(GregTechAPI.sBlockCasings4) });
        RecipeUtil.addRecipe(
                new ItemStack(GSBlocks.StorageModuleT3),
                new Object[] { "CEC", "WFW", "CEC", 'C', new ItemStack(GSItems.CompressedPlates, 1, 9), 'E',
                        new ItemStack(GCBlocks.machineTiered, 1, 8), 'W', CustomItemList.WaferTier3.get(1), 'F',
                        new ItemStack(GSBlocks.MachineFrames) });
        RecipeUtil.addRecipe(
                new ItemStack(GSBlocks.OxStorageModuleT2),
                new Object[] { "SCS", "PFP", "SWS", 'S', new ItemStack(GCBlocks.machineBase2, 1, 8), 'C',
                        new ItemStack(GCItems.oxygenConcentrator), 'P', new ItemStack(GCBlocks.oxygenPipe), 'F',
                        new ItemStack(GSBlocks.MachineFrames), 'W', CustomItemList.WaferTier3.get(1) });
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
                        new ItemStack(GSBlocks.MachineFrames), 'M', ItemList.Electric_Motor_MV.get(1), 'W',
                        CustomItemList.WaferTier3.get(1), 's', ItemList.Sensor_MV.get(1) });

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
                        getGTNHItem("MytrylCrystal"), 'S', getModItem("TConstruct", "bowstring", 1, 2),
                        'm', getGTNHItem("MysteriousCrystal") });

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
                new Object[] { "FPF", "CLC", "FCF", 'F', GTOreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 1),
                        'P', new ItemStack(GCItems.parachute, 1, W), 'C', new ItemStack(GCItems.canvas),
                        'L', new ItemStack(GSItems.ModuleLander) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.ModuleLanderT3),
                new Object[] { "DDD", "PLP", "DDD", 'D', new ItemStack(MarsItems.marsItemBasic, 1, 5), 'P',
                        new ItemStack(GCItems.flagPole), 'L', new ItemStack(GSItems.ModuleLanderT2) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.PlasmaSword, 1, 100),
                new Object[] { "DCD", "FCH", "DBW", 'D', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1),
                        'C', new ItemStack(GSItems.CompressedPlates, 1, 1), 'F', "craftingToolFile", 'H',
                        "craftingToolHardHammer", 'B', new ItemStack(GCItems.battery, 1, W), 'W',
                        new ItemStack(GCBlocks.aluminumWire, 1, 1) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.PlasmaPickaxe, 1, 100),
                new Object[] { "CCC", "FPH", "DBW", 'C', new ItemStack(GSItems.CompressedPlates, 1, 1), 'F',
                        "craftingToolFile", 'P', new ItemStack(GCItems.flagPole), 'H', "craftingToolHardHammer", 'D',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1), 'B',
                        new ItemStack(GCItems.battery, 1, W), 'W',
                        new ItemStack(GCBlocks.aluminumWire, 1, 1) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.PlasmaAxe, 1, 100),
                new Object[] { "CCH", "CPD", "FBW", 'C', new ItemStack(GSItems.CompressedPlates, 1, 1), 'H',
                        "craftingToolHardHammer", 'P', new ItemStack(GCItems.flagPole), 'D',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1), 'F', "craftingToolFile", 'B',
                        new ItemStack(GCItems.battery, 1, W), 'W',
                        new ItemStack(GCBlocks.aluminumWire, 1, 1) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.PlasmaShovel, 1, 100),
                new Object[] { "FCH", "DPD", "WBW", 'F', "craftingToolFile", 'C',
                        new ItemStack(GSItems.CompressedPlates, 1, 1), 'H', "craftingToolHardHammer", 'D',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1), 'P',
                        new ItemStack(GCItems.flagPole), 'W', new ItemStack(GCBlocks.aluminumWire, 1, 1), 'B',
                        new ItemStack(GCItems.battery, 1, W) });
        RecipeUtil.addRecipe(
                new ItemStack(GSItems.PlasmaHoe, 1, 100),
                new Object[] { "CCH", "FPD", "WBD", 'C', new ItemStack(GSItems.CompressedPlates, 1, 1), 'H',
                        "craftingToolHardHammer", 'F', "craftingToolFile", 'P', new ItemStack(GCItems.flagPole), 'D',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1), 'W',
                        new ItemStack(GCBlocks.aluminumWire, 1, 1), 'B',
                        new ItemStack(GCItems.battery, 1, W) });
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
                        new ItemStack(GCItems.sensorLens), 'M', new ItemStack(MetaGeneratedItem01.INSTANCE, 1, 32602),
                        'R', GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.StainlessSteel, 1), 'A',
                        ItemList.Robot_Arm_HV.get(1), 'P', ItemList.Electric_Piston_HV.get(1), 'C', "circuitData" });
        if (OpenModularTurrets.isModLoaded()) {
            RecipeUtil.addRecipe(
                    new ItemStack(GCBlocks.nasaWorkbench),
                    new Object[] { "RRR", "CDC", "WAW", 'R', new ItemStack(GSItems.RobotArm), 'C', "circuitElite", 'D',
                            CustomItemList.Display.get(1), 'W', getModItem("openmodularturrets", "hardWallTierFour", 1),
                            'A', new ItemStack(GregTechAPI.sBlockMachines, 1, 213) });
        }
        RecipeUtil.addRecipe(
                CustomItemList.RawSDHCAlloy.get(1),
                new Object[] { "SDS", "BCA", "SHS", 'S',
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1), 'D',
                        "craftingToolScrewDriver", 'B', new ItemStack(GSItems.CompressedDualBronze), 'C',
                        new ItemStack(GSItems.CompressedCoal), 'A', new ItemStack(GSItems.CompressedDualAluminium), 'H',
                        "craftingToolHardHammer" });
    }

    private void addDyedFutureGlassRecipe(int meta, String color) {
        addShapedRecipe(
                getGSItem("futureglasses", 8, meta),
                "GGG",
                "GDG",
                "GGG",
                'G',
                getGSItem("futureglass", 1, 0),
                'D',
                "dye" + color);
    }

    private void addDecorativeMetalBlockRecipe(int meta, ItemStack plate) {
        addShapedRecipe(
                getGSItem("metalsblock", 1, meta),
                "HP ",
                "PSP",
                " PW",
                'H',
                "craftingToolHardHammer",
                'P',
                plate,
                'S',
                "stone",
                'W',
                "craftingToolWrench");
    }

    private static ItemStack getGSItem(String name, int amount, int meta) {
        return getModItem(GalaxySpace.ID, name, amount, meta, missing);
    }
}
