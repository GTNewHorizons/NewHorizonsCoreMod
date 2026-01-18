package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.BuildCraftBuilders;
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
import static gregtech.api.util.GTRecipeBuilder.WILDCARD;
import static gregtech.api.util.GTRecipeConstants.UniversalChemical;

import java.util.Arrays;
import java.util.List;

import com.dreammaster.item.NHItemList;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.block.BlockList;

import bartworks.system.material.WerkstoffLoader;
import gregtech.api.GregTechAPI;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
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
                BuildCraftBuilders.ID,
                GalacticraftCore.ID,
                GalacticraftMars.ID,
                GalaxySpace.ID,
                IndustrialCraft2.ID,
                OpenComputers.ID,
                TinkerConstruct.ID);
    }

    @Override
    public void loadRecipes() {
        // Assembler
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Blocks.glass), GTOreDictUnificator.get(OrePrefixes.stick, Materials.Desh, 8))
                .itemOutputs(getGSItem("futureglass", 1, 0)).duration(10 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(GCItems.battery, 1, WILDCARD)).circuit(1)
                .itemOutputs(getGSItem("item.LeadBattery", 1, 100)).fluidInputs(Materials.Lead.getMolten(6 * 144))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getGSItem("item.ThermalPaddingT2", 1, 0)).circuit(1)
                .itemOutputs(getGSItem("item.ThermalClothT2", 5, 0)).duration(18 * SECONDS).eut(1024)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getGSItem("item.ThermalPaddingT2", 1, 1)).circuit(1)
                .itemOutputs(getGSItem("item.ThermalClothT2", 8, 0)).duration(30 * SECONDS).eut(1024)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getGSItem("item.ThermalPaddingT2", 1, 2)).circuit(1)
                .itemOutputs(getGSItem("item.ThermalClothT2", 7, 0)).duration(26 * SECONDS).eut(1024)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getGSItem("item.ThermalPaddingT2", 1, 3)).circuit(1)
                .itemOutputs(getGSItem("item.ThermalClothT2", 4, 0)).duration(15 * SECONDS).eut(1024)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(AsteroidsItems.basicItem, 1, 7),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Titanium, 8),
                        NHItemList.TungstenString.get(8))
                .circuit(1).itemOutputs(getGSItem("item.ThermalClothT2", 1, 0))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(576)).duration(30 * SECONDS).eut(1024)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getGSItem("item.ThermalClothT2", 5, 0), NHItemList.TungstenString.get(5)).circuit(5)
                .itemOutputs(getGSItem("item.ThermalPaddingT2", 1, 0))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(1440)).duration(1 * MINUTES + 15 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getGSItem("item.ThermalClothT2", 8, 0), NHItemList.TungstenString.get(8)).circuit(8)
                .itemOutputs(getGSItem("item.ThermalPaddingT2", 1, 1))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(2304)).duration(2 * MINUTES).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getGSItem("item.ThermalClothT2", 7, 0), NHItemList.TungstenString.get(7)).circuit(7)
                .itemOutputs(getGSItem("item.ThermalPaddingT2", 1, 2))
                .fluidInputs(Materials.Polybenzimidazole.getMolten(2016)).duration(1 * MINUTES + 45 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getGSItem("item.ThermalClothT2", 4, 0), NHItemList.TungstenString.get(4)).circuit(4)
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
                        getModItem(IndustrialCraft2.ID, "itemArmorJetpackElectric", 1, WILDCARD, missing))
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
                        NHItemList.Display.get(),
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
                        NHItemList.Display.get(),
                        ItemList.Field_Generator_EV.get(2),
                        new ItemStack(MarsItems.marsItemBasic, 1, 3))
                .itemOutputs(getGSItem("item.RocketControlComputer", 1, 2))
                .fluidInputs(Materials.SolderingAlloy.getMolten(864)).requiresCleanRoom().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "case1", 1, 0, missing),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0, missing),
                        NHItemList.Display.get(),
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
                        NHItemList.Display.get(),
                        ItemList.Emitter_IV.get(1),
                        ItemList.Sensor_IV.get(1),
                        NHItemList.HeavyDutyPlateTier4.get())
                .itemOutputs(getGSItem("item.RocketControlComputer", 1, 4))
                .fluidInputs(Materials.SolderingAlloy.getMolten(1728)).requiresCleanRoom().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "case2", 1, 0, missing),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0, missing),
                        NHItemList.Display.get(),
                        ItemList.Emitter_LuV.get(1),
                        ItemList.Sensor_LuV.get(1),
                        NHItemList.HeavyDutyPlateTier5.get())
                .itemOutputs(getGSItem("item.RocketControlComputer", 1, 5))
                .fluidInputs(Materials.SolderingAlloy.getMolten(2304)).requiresCleanRoom().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "case3", 1, 0, missing),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0, missing),
                        NHItemList.Display.get(),
                        ItemList.Emitter_ZPM.get(1),
                        ItemList.Sensor_ZPM.get(1),
                        NHItemList.HeavyDutyPlateTier6.get())
                .itemOutputs(getGSItem("item.RocketControlComputer", 1, 6))
                .fluidInputs(Materials.SolderingAlloy.getMolten(3456)).requiresCleanRoom().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "case3", 1, 0, missing),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0, missing),
                        NHItemList.Display.get(),
                        ItemList.Emitter_UV.get(1),
                        ItemList.Sensor_UV.get(1),
                        NHItemList.HeavyDutyPlateTier7.get())
                .itemOutputs(getGSItem("item.RocketControlComputer", 1, 7))
                .fluidInputs(Materials.SolderingAlloy.getMolten(4608)).requiresCleanRoom().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "case3", 1, 0, missing),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0, missing),
                        NHItemList.Display.get(),
                        ItemList.Emitter_UV.get(1),
                        ItemList.Sensor_UV.get(1),
                        NHItemList.HeavyDutyPlateTier8.get())
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
                .itemOutputs(ItemList.UltraHighStrengthConcrete.get(1))
                .fluidInputs(FluidRegistry.getFluidStack("molten.adamantium alloy", 144)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(ItemList.TaHfCNanofibers.get(4), ItemList.NtNanofibers.get(4))
                .itemOutputs(ItemList.UHTResistantMesh.get(1)).duration(10 * SECONDS).eut(TierEU.RECIPE_LuV)
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
                        WerkstoffLoader.HafniumCarbide.get(OrePrefixes.dust))
                .circuit(1).itemOutputs(WerkstoffLoader.TantalumCarbideHafniumCarbideMixture.get(OrePrefixes.dust, 5))
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
        GTValues.RA.stdBuilder().itemInputs(ItemList.TaHfNanoparticles.get(1))
                .itemOutputs(ItemList.TaHfCNanofibers.get(5))
                .fluidInputs(WerkstoffLoader.TantalumHafniumCarbide.getMolten(576)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder().itemInputs(ItemList.NtNanoparticles.get(1)).itemOutputs(ItemList.NtNanofibers.get(5))
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
                        NHItemList.SchematicsMoonBuggy.get())
                .itemOutputs(new ItemStack(GCItems.schematic)).requiresCleanRoom().duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftBuilders.ID, "blueprintItem", 1, 0, missing),
                        NHItemList.SchematicsTier2.get())
                .itemOutputs(new ItemStack(GCItems.schematic, 1, 1)).requiresCleanRoom().duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftBuilders.ID, "blueprintItem", 1, 0, missing),
                        NHItemList.SchematicsTier3.get())
                .itemOutputs(new ItemStack(MarsItems.schematic)).requiresCleanRoom().duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftBuilders.ID, "blueprintItem", 1, 0, missing),
                        NHItemList.SchematicsCargoRocket.get())
                .itemOutputs(new ItemStack(MarsItems.schematic, 1, 1)).requiresCleanRoom().duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftBuilders.ID, "blueprintItem", 1, 0, missing),
                        NHItemList.SchematicsAstroMiner.get())
                .itemOutputs(new ItemStack(MarsItems.schematic, 1, 2)).requiresCleanRoom().duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftBuilders.ID, "blueprintItem", 1, 0, missing),
                        NHItemList.SchematicsTier4.get())
                .itemOutputs(getGSItem("item.SchematicTier4", 1, 0)).requiresCleanRoom().duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftBuilders.ID, "blueprintItem", 1, 0, missing),
                        NHItemList.SchematicsTier5.get())
                .itemOutputs(getGSItem("item.SchematicTier5", 1, 0)).requiresCleanRoom().duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftBuilders.ID, "blueprintItem", 1, 0, missing),
                        NHItemList.SchematicsTier6.get())
                .itemOutputs(getGSItem("item.SchematicTier6", 1, 0)).requiresCleanRoom().duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftBuilders.ID, "blueprintItem", 1, 0, missing),
                        NHItemList.SchematicsTier7.get())
                .itemOutputs(getGSItem("item.SchematicTier7", 1, 0)).requiresCleanRoom().duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftBuilders.ID, "blueprintItem", 1, 0, missing),
                        NHItemList.SchematicsTier8.get())
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
                .itemOutputs(ItemList.TaHfNanoparticles.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(Materials.Neutronium.getDust(1))
                .itemOutputs(ItemList.NtNanoparticles.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
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
        addDecorativeMetalBlockRecipe(1, getGSItem("item.CompressedPlates", 1, 0));
        addDecorativeMetalBlockRecipe(2, getGSItem("item.CompressedPlates", 1, 1));
        addDecorativeMetalBlockRecipe(3, getGSItem("item.CompressedPlates", 1, 4));
        addDecorativeMetalBlockRecipe(4, getGSItem("item.CompressedPlates", 1, 5));
        addDecorativeMetalBlockRecipe(5, getGSItem("item.CompressedPlates", 1, 6));
        addDecorativeMetalBlockRecipe(6, getGSItem("item.CompressedPlates", 1, 7));
        addDecorativeMetalBlockRecipe(7, getGSItem("item.CompressedPlates", 1, 8));
        addDecorativeMetalBlockRecipe(8, getGSItem("item.CompressedPlates", 1, 9));

        addShapedRecipe(
                ItemList.PlanetaryGasSiphonCasing.get(1),
                "MWM",
                "CTC",
                "MWM",
                'M',
                getGSItem("item.CompressedPlates", 1, 5), // Compressed Mithril
                'W',
                NHItemList.WaferTier3.get(),
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
                NHItemList.WaferTier3.get(),
                'F',
                ItemList.PlanetaryGasSiphonCasing.get(1));

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
                ItemList.PlanetaryGasSiphonCasing.get(1),
                'W',
                NHItemList.WaferTier3.get());

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
                ItemList.PlanetaryGasSiphonCasing.get(1),
                'M',
                ItemList.Electric_Motor_MV.get(1),
                'W',
                NHItemList.WaferTier3.get(),
                's',
                ItemList.Sensor_MV.get(1));

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
                NHItemList.MytrylCrystal.get(),
                'S',
                getModItem(TinkerConstruct.ID, "bowstring", 1, 2), // Fiery Bowstring
                'm',
                NHItemList.MysteriousCrystal.get());

        GTModHandler.addCraftingRecipe(
                getGSItem("item.lead_helmet", 1, 0),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { "LLL", "LhL", "D D", 'L', getGSItem("item.CompressedPlates", 1, 3), // Compressed Lead
                        'D', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1) });

        GTModHandler.addCraftingRecipe(
                getGSItem("item.lead_plate", 1, 0),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { "LhL", "LDL", "L L", 'L', getGSItem("item.CompressedPlates", 1, 3), // Compressed Lead
                        'D', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1) });

        GTModHandler.addCraftingRecipe(
                getGSItem("item.lead_leg", 1, 0),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { "LLL", "LDL", "LhL", 'L', getGSItem("item.CompressedPlates", 1, 3), // Compressed Lead
                        'D', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1) });

        GTModHandler.addCraftingRecipe(
                getGSItem("item.lead_boots", 1, 0),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { "D D", "LhL", "L L", 'L', getGSItem("item.CompressedPlates", 1, 3), // Compressed Lead
                        'D', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1) });

        GTModHandler.addCraftingRecipe(
                getGSItem("item.cobaltum_helmet", 1, 0),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { "CCC", "ChC", "D D", 'C', getGSItem("item.CompressedPlates", 1, 1), // Compressed Cobalt
                        'D', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1) });

        GTModHandler.addCraftingRecipe(
                getGSItem("item.cobaltum_plate", 1, 0),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { "ChC", "CDC", "C C", 'C', getGSItem("item.CompressedPlates", 1, 1), // Compressed Cobalt
                        'D', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1) });

        GTModHandler.addCraftingRecipe(
                getGSItem("item.cobaltum_leg", 1, 0),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { "CCC", "CDC", "ChC", 'C', getGSItem("item.CompressedPlates", 1, 1), // Compressed Cobalt
                        'D', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1) });

        GTModHandler.addCraftingRecipe(
                getGSItem("item.cobaltum_boots", 1, 0),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { "D D", "ChC", "C C", 'C', getGSItem("item.CompressedPlates", 1, 1), // Compressed Cobalt
                        'D', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1) });

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
                new ItemStack(GCItems.parachute, 1, WILDCARD),
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

        GTModHandler.addCraftingRecipe(
                getGSItem("item.plasmasword", 1, 100),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { "DCD", "fCh", "DBW", 'D', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1),
                        'C', getGSItem("item.CompressedPlates", 1, 1), // Compressed Cobalt
                        'B', new ItemStack(GCItems.battery, 1, WILDCARD), 'W',
                        new ItemStack(GCBlocks.aluminumWire, 1, 1) });

        GTModHandler.addCraftingRecipe(
                getGSItem("item.plasmapickaxe", 1, 100),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { "CCC", "fPh", "DBW", 'C', getGSItem("item.CompressedPlates", 1, 1), // Compressed Cobalt
                        'P', new ItemStack(GCItems.flagPole), 'D',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1), 'B',
                        new ItemStack(GCItems.battery, 1, WILDCARD), 'W', new ItemStack(GCBlocks.aluminumWire, 1, 1) });

        GTModHandler.addCraftingRecipe(
                getGSItem("item.plasmaaxe", 1, 100),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { "CCh", "CPD", "fBW", 'C', getGSItem("item.CompressedPlates", 1, 1), // Compressed Cobalt
                        'P', new ItemStack(GCItems.flagPole), 'D',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1), 'B',
                        new ItemStack(GCItems.battery, 1, WILDCARD), 'W', new ItemStack(GCBlocks.aluminumWire, 1, 1) });

        GTModHandler.addCraftingRecipe(
                getGSItem("item.plasmashovel", 1, 100),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { "fCh", "DPD", "WBW", 'C', getGSItem("item.CompressedPlates", 1, 1), // Compressed Cobalt
                        'D', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1), 'P',
                        new ItemStack(GCItems.flagPole), 'W', new ItemStack(GCBlocks.aluminumWire, 1, 1), 'B',
                        new ItemStack(GCItems.battery, 1, WILDCARD) });

        GTModHandler.addCraftingRecipe(
                getGSItem("item.plasmahoe", 1, 100),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { "CCh", "fPD", "WBD", 'C', getGSItem("item.CompressedPlates", 1, 1), // Compressed Cobalt
                        'P', new ItemStack(GCItems.flagPole), 'D',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Desh, 1), 'W',
                        new ItemStack(GCBlocks.aluminumWire, 1, 1), 'B', new ItemStack(GCItems.battery, 1, WILDCARD) });

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
                    NHItemList.Display.get(),
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
        GTModHandler.addCraftingRecipe(
                getGSItem("metalsblock", 1, meta),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { "hP ", "PSP", " Pw", 'P', plate, 'S', "stone" });
    }

    private static ItemStack getGSItem(String name, int amount, int meta) {
        return getModItem(GalaxySpace.ID, name, amount, meta, missing);
    }

    @Override
    public boolean addShapedRecipe(ItemStack aOutput, Object... inputs) {
        return GTModHandler.addCraftingRecipe(aOutput, GTModHandler.RecipeBits.NOT_REMOVABLE, inputs);
    }
}
