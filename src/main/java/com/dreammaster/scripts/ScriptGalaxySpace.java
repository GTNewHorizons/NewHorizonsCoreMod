package com.dreammaster.scripts;

import static gregtech.api.enums.GTValues.W;
import static gregtech.api.enums.Mods.BuildCraftBuilders;
import static gregtech.api.enums.Mods.GTNHIntergalactic;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.GalacticraftMars;
import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.OpenModularTurrets;
import static gregtech.api.enums.Mods.TinkerConstruct;
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

import com.dreammaster.block.BlockList;
import com.dreammaster.gthandler.CustomItemList;
import com.gtnewhorizons.gtnhintergalactic.item.IGItems;

import bartworks.system.material.WerkstoffLoader;
import gregtech.api.GregTechAPI;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.ToolDictNames;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import micdoodle8.mods.galacticraft.core.items.GCItems;
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
                GTNHIntergalactic.ID,
                OpenComputers.ID,
                BuildCraftBuilders.ID,
                IndustrialCraft2.ID,
                OpenModularTurrets.ID);
    }

    @Override
    public void loadRecipes() {
        // Assembler
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Blocks.glass), GTOreDictUnificator.get(OrePrefixes.stick, Materials.Desh, 8))
                .itemOutputs(getGSItem("futureglass", 1, 0)).duration(10 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(GCItems.battery, 1, W), GTUtility.getIntegratedCircuit(1))
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
                        CustomItemList.HeavyDutyPlateTier4.get(1))
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
                        CustomItemList.HeavyDutyPlateTier5.get(1))
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
                        CustomItemList.HeavyDutyPlateTier6.get(1))
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
                        CustomItemList.HeavyDutyPlateTier7.get(1))
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
                        CustomItemList.HeavyDutyPlateTier8.get(1))
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
                        BlockList.NeutroniumPlatedReinforcedStone.getIS(),
                        WerkstoffLoader.HDCS.get(OrePrefixes.plate, 8))
                .itemOutputs(getIGItem("dysonswarmparts", 1, 9))
                .fluidInputs(FluidRegistry.getFluidStack("molten.adamantium alloy", 144)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(IGItems.DysonSwarmItems, 4, 1), new ItemStack(IGItems.DysonSwarmItems, 4, 2))
                .itemOutputs(new ItemStack(IGItems.DysonSwarmItems, 1, 3)).duration(10 * SECONDS).eut(TierEU.RECIPE_LuV)
                .addTo(assemblerRecipes);

        // Chemical Reactor
        GTValues.RA.stdBuilder().itemInputs(Materials.Carbon.getDust(1), GTOreDictUnificator.get("dustHafnia", 1))
                .itemOutputs(WerkstoffLoader.HafniumCarbide.get(OrePrefixes.dust))
                .fluidOutputs(Materials.Oxygen.getGas(2000)).duration(20 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(UniversalChemical);

        // Mixer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get("dustTantalumCarbide", 4),
                        WerkstoffLoader.HafniumCarbide.get(OrePrefixes.dust),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(WerkstoffLoader.TantalumCarbideHafniumCarbideMixture.get(OrePrefixes.dust, 5))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_EV).addTo(mixerRecipes);

        // Plasma Arc Furnace
        GTValues.RA.stdBuilder().itemInputs(WerkstoffLoader.TantalumCarbideHafniumCarbideMixture.get(OrePrefixes.dust))
                .itemOutputs(WerkstoffLoader.TantalumHafniumCarbide.get(OrePrefixes.ingot, 1))
                .fluidInputs(Materials.Nitrogen.getPlasma(2)).fluidOutputs(Materials.Nitrogen.getGas(1))
                .duration(5 * TICKS).eut(TierEU.RECIPE_IV).addTo(plasmaArcFurnaceRecipes);

        // Vacuum Freezer
        GTValues.RA.stdBuilder().fluidInputs(Materials.Helium.getGas(1000))
                .fluidOutputs(WerkstoffLoader.LiquidHelium.getFluidOrGas(1000)).duration(1 * MINUTES + 30 * SECONDS)
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
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(IGItems.DysonSwarmItems, 1, 4))
                .itemOutputs(new ItemStack(IGItems.DysonSwarmItems, 5, 1))
                .fluidInputs(WerkstoffLoader.TantalumHafniumCarbide.getMolten(576)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(IGItems.DysonSwarmItems, 1, 5))
                .itemOutputs(new ItemStack(IGItems.DysonSwarmItems, 5, 2))
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
        GTValues.RA.stdBuilder().itemInputs(WerkstoffLoader.TantalumHafniumCarbide.get(OrePrefixes.dust))
                .itemOutputs(new ItemStack(IGItems.DysonSwarmItems, 1, 4)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(Materials.Neutronium.getDust(1))
                .itemOutputs(new ItemStack(IGItems.DysonSwarmItems, 1, 5)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
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

        addShapedRecipe(
                getIGItem("gassiphoncasing", 1, 0),
                "MWM",
                "CTC",
                "MWM",
                'M',
                getGSItem("item.CompressedPlates", 1, 5), // Compressed Mithril
                'W',
                CustomItemList.WaferTier3.get(1),
                'C',
                new ItemStack(GCBlocks.aluminumWire, 1, 1),
                'T',
                new ItemStack(GregTechAPI.sBlockCasings4)); // Robust Tungstensteel Machine Casing

        addShapedRecipe(
                getGSItem("storagemoduleT3", 1, 0),
                "CEC",
                "WFW",
                "CEC",
                'C',
                getGSItem("item.CompressedPlates", 1, 9), // Compressed Tungsten
                'E',
                new ItemStack(GCBlocks.machineTiered, 1, 8), // Energy Storage Cluster
                'W',
                CustomItemList.WaferTier3.get(1),
                'F',
                getIGItem("gassiphoncasing", 1, 0));

        addShapedRecipe(
                getGSItem("oxstoragemoduleT2", 1, 0),
                "SCS",
                "PFP",
                "SWS",
                'S',
                new ItemStack(GCBlocks.machineBase2, 1, 8), // Oxygen Storage Module
                'C',
                new ItemStack(GCItems.oxygenConcentrator),
                'P',
                new ItemStack(GCBlocks.oxygenPipe),
                'F',
                getIGItem("gassiphoncasing", 1, 0),
                'W',
                CustomItemList.WaferTier3.get(1));

        addShapedRecipe(
                getGSItem("solarwindpanel", 1, 0),
                "TFT",
                "APA",
                "MWS",
                'T',
                new ItemStack(AsteroidsItems.basicItem, 1, 6), // Compressed Titanium Plate
                'F',
                getGSItem("item.SolarFlares", 1, 1), // Solar Flares
                'A',
                new ItemStack(GCBlocks.aluminumWire, 1, 1),
                'P',
                new ItemStack(GCItems.flagPole),
                'M',
                ItemList.Electric_Motor_LV.get(1),
                'W',
                new ItemStack(GCItems.basicItem, 1, 14), // Advanced Wafer
                'S',
                ItemList.Sensor_LV.get(1));

        addShapedRecipe(
                getGSItem("solarPanel", 1, 0),
                "DSD",
                "AFA",
                "MWs",
                'D',
                getGSItem("item.CompressedPlates", 1, 2), // Compressed Duralumin
                'S',
                new ItemStack(GCItems.basicItem, 1, 1), // Full Solar Panel
                'A',
                new ItemStack(GCBlocks.aluminumWire, 1, 1),
                'F',
                getIGItem("gassiphoncasing", 1, 0),
                'M',
                ItemList.Electric_Motor_MV.get(1),
                'W',
                CustomItemList.WaferTier3.get(1),
                's',
                ItemList.Sensor_MV.get(1));

        // todo move somewhere else not in a script
        // GT replaces this recipe automatically
        addShapelessRecipe(getGSItem("barnardaClog", 1, 0), getGSItem("barnardaCplanks", 4, 0));

        addShapedRecipe(
                getGSItem("item.spacesuit_boots", 1, 0),
                "ABA",
                "ADA",
                "CDC",
                'A',
                getGSItem("item.CompressedSDHD120", 1, 0),
                'B',
                getGSItem("item.lead_boots", 1, 0),
                'D',
                new ItemStack(MarsItems.marsItemBasic, 1, 5), // Compressed Desh
                'C',
                getGSItem("item.CompressedPlates", 1, 2)); // Compressed Duralumin

        addShapedRecipe(
                getGSItem("item.QuantBow", 1, 0),
                "LMS",
                "m S",
                "LMS",
                'L',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Lead, 1),
                'M',
                CustomItemList.MytrylCrystal.get(1),
                'S',
                getModItem(TinkerConstruct.ID, "bowstring", 1, 2), // Fiery Bowstring
                'm',
                CustomItemList.MysteriousCrystal.get(1));

        addShapedRecipe(
                getGSItem("item.lead_helmet", 1, 0),
                "LLL",
                "LHL",
                "D D",
                'L',
                getGSItem("item.CompressedPlates", 1, 3), // Compressed Lead
                'H',
                ToolDictNames.craftingToolHardHammer,
                'D',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1));

        addShapedRecipe(
                getGSItem("item.lead_plate", 1, 0),
                "LHL",
                "LDL",
                "L L",
                'L',
                getGSItem("item.CompressedPlates", 1, 3), // Compressed Lead
                'H',
                ToolDictNames.craftingToolHardHammer,
                'D',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1));

        addShapedRecipe(
                getGSItem("item.lead_leg", 1, 0),
                "LLL",
                "LDL",
                "LHL",
                'L',
                getGSItem("item.CompressedPlates", 1, 3), // Compressed Lead
                'H',
                ToolDictNames.craftingToolHardHammer,
                'D',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1));

        addShapedRecipe(
                getGSItem("item.lead_boots", 1, 0),
                "D D",
                "LHL",
                "L L",
                'L',
                getGSItem("item.CompressedPlates", 1, 3), // Compressed Lead
                'H',
                ToolDictNames.craftingToolHardHammer,
                'D',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1));

        addShapedRecipe(
                getGSItem("item.cobaltum_helmet", 1, 0),
                "CCC",
                "CHC",
                "D D",
                'C',
                getGSItem("item.CompressedPlates", 1, 1), // Compressed Cobalt
                'H',
                ToolDictNames.craftingToolHardHammer,
                'D',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1));

        addShapedRecipe(
                getGSItem("item.cobaltum_plate", 1, 0),
                "CHC",
                "CDC",
                "C C",
                'C',
                getGSItem("item.CompressedPlates", 1, 1), // Compressed Cobalt
                'H',
                "craftingToolHardHammer",
                'D',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1));

        addShapedRecipe(
                getGSItem("item.cobaltum_leg", 1, 0),
                "CCC",
                "CDC",
                "CHC",
                'C',
                getGSItem("item.CompressedPlates", 1, 1), // Compressed Cobalt
                'H',
                ToolDictNames.craftingToolHardHammer,
                'D',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1));

        addShapedRecipe(
                getGSItem("item.cobaltum_boots", 1, 0),
                "D D",
                "CHC",
                "C C",
                'C',
                getGSItem("item.CompressedPlates", 1, 1), // Compressed Cobalt
                'H',
                ToolDictNames.craftingToolHardHammer,
                'D',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1));

        addShapedRecipe(
                getGSItem("item.spacesuit_helmet", 1, 0),
                "AHA",
                "AMA",
                "DCD",
                'A',
                getGSItem("item.CompressedSDHD120", 1, 0),
                'H',
                getGSItem("item.lead_helmet", 1, 0),
                'M',
                new ItemStack(GCItems.oxMask),
                'D',
                new ItemStack(MarsItems.marsItemBasic, 1, 5), // Compressed Desh
                'C',
                new ItemStack(GCItems.oxygenConcentrator));

        addShapedRecipe(
                getGSItem("item.spacesuit_plate", 1, 0),
                "APA",
                "ACA",
                "ADA",
                'A',
                getGSItem("item.CompressedSDHD120", 1, 0),
                'P',
                getGSItem("item.lead_plate", 1, 0),
                'C',
                getGSItem("item.CompressedPlates", 1, 2), // Compressed Duralumin
                'D',
                new ItemStack(MarsItems.marsItemBasic, 1, 5)); // Compressed Desh

        addShapedRecipe(
                getGSItem("item.spacesuit_leg", 1, 0),
                "ALA",
                "CAC",
                "CDC",
                'A',
                getGSItem("item.CompressedSDHD120", 1, 0),
                'L',
                getGSItem("item.lead_leg", 1, 0),
                'C',
                getGSItem("item.CompressedPlates", 1, 2), // Compressed Duralumin
                'D',
                new ItemStack(MarsItems.marsItemBasic, 1, 5)); // Compressed Desh

        addShapedRecipe(
                getGSItem("item.ModuleLander", 1, 0),
                "FSS",
                "SBC",
                "PEP",
                'F',
                new ItemStack(GCItems.basicItem, 1, 19), // Frequency Module
                'S',
                new ItemStack(GCItems.basicItem, 1, 9), // Compressed Steel
                'B',
                new ItemStack(GCItems.partBuggy, 1, 1), // Buggy Seat
                'C',
                new ItemStack(GCItems.basicItem, 1, 6), // Compressed Copper
                'P',
                new ItemStack(GCItems.flagPole),
                'E',
                new ItemStack(GCItems.rocketEngine));

        addShapedRecipe(
                getGSItem("item.ModuleLander2", 1, 0),
                "FPF",
                "CLC",
                "FCF",
                'F',
                GTOreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 1),
                'P',
                new ItemStack(GCItems.parachute, 1, W),
                'C',
                new ItemStack(GCItems.canvas),
                'L',
                getGSItem("item.ModuleLander", 1, 0));

        addShapedRecipe(
                getGSItem("item.ModuleLander3", 1, 0),
                "DDD",
                "PLP",
                "DDD",
                'D',
                new ItemStack(MarsItems.marsItemBasic, 1, 5), // Compressed Desh
                'P',
                new ItemStack(GCItems.flagPole),
                'L',
                getGSItem("item.ModuleLander2", 1, 0));

        addShapedRecipe(
                getGSItem("item.plasmasword", 1, 100),
                "DCD",
                "FCH",
                "DBW",
                'D',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1),
                'C',
                getGSItem("item.CompressedPlates", 1, 1), // Compressed Cobalt
                'F',
                ToolDictNames.craftingToolFile,
                'H',
                ToolDictNames.craftingToolHardHammer,
                'B',
                new ItemStack(GCItems.battery, 1, W),
                'W',
                new ItemStack(GCBlocks.aluminumWire, 1, 1));

        addShapedRecipe(
                getGSItem("item.plasmapickaxe", 1, 100),
                "CCC",
                "FPH",
                "DBW",
                'C',
                getGSItem("item.CompressedPlates", 1, 1), // Compressed Cobalt
                'F',
                ToolDictNames.craftingToolFile,
                'P',
                new ItemStack(GCItems.flagPole),
                'H',
                ToolDictNames.craftingToolHardHammer,
                'D',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1),
                'B',
                new ItemStack(GCItems.battery, 1, W),
                'W',
                new ItemStack(GCBlocks.aluminumWire, 1, 1));

        addShapedRecipe(
                getGSItem("item.plasmaaxe", 1, 100),
                "CCH",
                "CPD",
                "FBW",
                'C',
                getGSItem("item.CompressedPlates", 1, 1), // Compressed Cobalt
                'H',
                ToolDictNames.craftingToolHardHammer,
                'P',
                new ItemStack(GCItems.flagPole),
                'D',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1),
                'F',
                ToolDictNames.craftingToolFile,
                'B',
                new ItemStack(GCItems.battery, 1, W),
                'W',
                new ItemStack(GCBlocks.aluminumWire, 1, 1));

        addShapedRecipe(
                getGSItem("item.plasmashovel", 1, 100),
                "FCH",
                "DPD",
                "WBW",
                'F',
                ToolDictNames.craftingToolFile,
                'C',
                getGSItem("item.CompressedPlates", 1, 1), // Compressed Cobalt
                'H',
                ToolDictNames.craftingToolHardHammer,
                'D',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1),
                'P',
                new ItemStack(GCItems.flagPole),
                'W',
                new ItemStack(GCBlocks.aluminumWire, 1, 1),
                'B',
                new ItemStack(GCItems.battery, 1, W));

        addShapedRecipe(
                getGSItem("item.plasmahoe", 1, 100),
                "CCH",
                "FPD",
                "WBD",
                'C',
                getGSItem("item.CompressedPlates", 1, 1), // Compressed Cobalt
                'H',
                ToolDictNames.craftingToolHardHammer,
                'F',
                ToolDictNames.craftingToolFile,
                'P',
                new ItemStack(GCItems.flagPole),
                'D',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1),
                'W',
                new ItemStack(GCBlocks.aluminumWire, 1, 1),
                'B',
                new ItemStack(GCItems.battery, 1, W));

        addShapedRecipe(
                getGSItem("item.SolarFlares", 1, 0), // Solar Flares Part
                "IPI",
                "PSP",
                "PsP",
                'I',
                new ItemStack(GCItems.basicItem, 1, 11), // Compressed Iron
                'P',
                new ItemStack(GCItems.flagPole),
                'S',
                new ItemStack(GCItems.basicItem, 1, 1), // Full Solar Panel
                's',
                new ItemStack(GCItems.basicItem, 1, 9)); // Compressed Steel

        addShapedRecipe(
                getGSItem("item.SolarFlares", 1, 1), // Solar Flares
                "DFD",
                "FTF",
                "DFD",
                'D',
                new ItemStack(MarsItems.marsItemBasic, 1, 5), // Compressed Desh
                'F',
                getGSItem("item.SolarFlares", 1, 0), // Solar Flares Part
                'T',
                new ItemStack(AsteroidsItems.basicItem, 1, 6)); // Compressed Titanium

        addShapedRecipe(
                getGSItem("item.RobotArm", 1, 0),
                "NNL",
                "MRA",
                "PCR",
                'N',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherStar, 1),
                'L',
                new ItemStack(GCItems.sensorLens),
                'M',
                ItemList.Electric_Motor_HV.get(1),
                'R',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.StainlessSteel, 1),
                'A',
                ItemList.Robot_Arm_HV.get(1),
                'P',
                ItemList.Electric_Piston_HV.get(1),
                'C',
                OrePrefixes.circuit.get(Materials.EV));

        if (OpenModularTurrets.isModLoaded()) {
            addShapedRecipe(
                    new ItemStack(GCBlocks.nasaWorkbench),
                    "RRR",
                    "CDC",
                    "WAW",
                    'R',
                    getGSItem("item.RobotArm", 1, 0),
                    'C',
                    OrePrefixes.circuit.get(Materials.IV),
                    'D',
                    CustomItemList.Display.get(1),
                    'W',
                    getModItem(OpenModularTurrets.ID, "hardWallTierFour", 1),
                    'A',
                    ItemList.Machine_HV_Assembler.get(1));
        }
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
                ToolDictNames.craftingToolHardHammer,
                'P',
                plate,
                'S',
                "stone",
                'W',
                ToolDictNames.craftingToolWrench);
    }

    private static ItemStack getGSItem(String name, int amount, int meta) {
        return getModItem(GalaxySpace.ID, name, amount, meta, missing);
    }

    private static ItemStack getIGItem(String name, int amount, int meta) {
        return getModItem(GTNHIntergalactic.ID, name, amount, meta, missing);
    }
}
