package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static com.gtnewhorizon.gtnhlib.util.ItemUtil.copyAmount;
import static goodgenerator.loader.Loaders.advancedRadiationProtectionPlate;
import static goodgenerator.util.ItemRefer.Field_Restriction_Coil_T1;
import static gregtech.api.enums.Mods.AE2FluidCraft;
import static gregtech.api.enums.Mods.AdvancedSolarPanel;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.BloodMagic;
import static gregtech.api.enums.Mods.Botania;
import static gregtech.api.enums.Mods.BuildCraftCore;
import static gregtech.api.enums.Mods.BuildCraftFactory;
import static gregtech.api.enums.Mods.BuildCraftTransport;
import static gregtech.api.enums.Mods.Chisel;
import static gregtech.api.enums.Mods.Computronics;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.EnhancedLootBags;
import static gregtech.api.enums.Mods.EtFuturumRequiem;
import static gregtech.api.enums.Mods.ExtraBees;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.FloodLights;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.ForgeMicroblocks;
import static gregtech.api.enums.Mods.GTPlusPlusEverglades;
import static gregtech.api.enums.Mods.GalacticraftAmunRa;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.GalacticraftMars;
import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.enums.Mods.Gendustry;
import static gregtech.api.enums.Mods.GraviSuite;
import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronChests;
import static gregtech.api.enums.Mods.IronTanks;
import static gregtech.api.enums.Mods.JABBA;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.NaturesCompass;
import static gregtech.api.enums.Mods.OpenBlocks;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.OpenGlasses;
import static gregtech.api.enums.Mods.OpenModularTurrets;
import static gregtech.api.enums.Mods.OpenPrinters;
import static gregtech.api.enums.Mods.OpenSecurity;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.ProjectRedIllumination;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.StevesCarts2;
import static gregtech.api.enums.Mods.StorageDrawers;
import static gregtech.api.enums.Mods.SuperSolarPanels;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.enums.Mods.VisualProspecting;
import static gregtech.api.enums.Mods.Witchery;
import static gregtech.api.enums.Mods.ZTones;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTRecipeBuilder.HALF_INGOTS;
import static gregtech.api.util.GTRecipeBuilder.INGOTS;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.QUARTER_INGOTS;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gregtech.api.util.GTRecipeBuilder.WILDCARD;
import static tectech.thing.CustomItemList.DATApipe;
import static tectech.thing.CustomItemList.Machine_Multi_Switch;
import static tectech.thing.CustomItemList.Machine_Multi_Switch_Adv;
import static tectech.thing.CustomItemList.Machine_Multi_Transformer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.block.BlockList;
import com.dreammaster.item.NHItemList;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import bartworks.common.loaders.ItemRegistry;
import goodgenerator.loader.Loaders;
import gregtech.GTMod;
import gregtech.api.enums.Circuits;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.TieredItems;
import gregtech.api.enums.materials.CellShapes;
import gregtech.api.enums.materials.FluidShapes;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;
import gregtech.api.material.MaterialParts;
import gregtech.api.material.MaterialUtils;
import gregtech.api.objects.OreDictItemStack;
import gregtech.api.objects.SubstituteFluidStack;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gregtech.common.items.MetaGeneratedTool01;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;
import gtneioreplugin.plugin.block.ModBlocks;
import gtnhlanth.common.register.LanthItemList;
import kekztech.common.TileEntities;

public class AssemblerRecipes implements Runnable {

    ItemStack missing = new ItemStack(Blocks.fire);

    @Override
    public void run() {

        // New organized methods -- Most of these still need RA2 conversions done, but at least they're in more workable
        // chunks.
        makeEnderIORecipes();
        makeAE2Recipes();
        makeTinkersConstructRecipes();
        makeForestryRecipes();
        makeOpenComputersRecipes();
        makeJabbaRecipes();
        makeZTonesRecipes();
        makeGalacticraftRocketRecipes();
        makeIronTanksRecipes();
        makeChiselRecipes();
        makeLootBagRecipes();
        makeCoinRecipes();
        makeCoilRecipes();
        makeAirFilterRecipes();
        makeMixedMetalIngotRecipes();
        makeReinforcedIronPlateRecipes();
        makeNEIPlanetRecipes();
        makeSolderingAlloyRecipes();
        makeElectricMachinePartRecipes();
        makeCircuitPartRecipes();
        makeMachineRecipes();
        makeStoneToolRecipes();
        makeBeamcraftingRecipes();

        // --- Advanced Solar Panel
        if (AdvancedSolarPanel.isModLoaded()) {
            // Conversion recipes to gt solars
            GTValues.RA.stdBuilder().itemInputs(getModItem(AdvancedSolarPanel.ID, "BlockAdvSolarPanel", 1, 0))
                    .itemOutputs(ItemList.Machine_LV_SolarPanel.get(1L)).duration(1 * SECONDS).eut(TierEU.RECIPE_LV)
                    .addTo(assemblerRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(AdvancedSolarPanel.ID, "BlockAdvSolarPanel", 1, 1))
                    .itemOutputs(ItemList.Machine_MV_SolarPanel.get(1L)).duration(1 * SECONDS).eut(TierEU.RECIPE_LV)
                    .addTo(assemblerRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(AdvancedSolarPanel.ID, "BlockAdvSolarPanel", 1, 2))
                    .itemOutputs(ItemList.Machine_HV_SolarPanel.get(1L)).duration(1 * SECONDS).eut(TierEU.RECIPE_LV)
                    .addTo(assemblerRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(AdvancedSolarPanel.ID, "BlockAdvSolarPanel", 1, 3))
                    .itemOutputs(ItemList.Machine_EV_SolarPanel.get(1L)).duration(1 * SECONDS).eut(TierEU.RECIPE_LV)
                    .addTo(assemblerRecipes);
        }

        // --- Super Solar Panel
        if (SuperSolarPanels.isModLoaded()) {
            // Conversion recipes to gt solars
            GTValues.RA.stdBuilder().itemInputs(getModItem(SuperSolarPanels.ID, "SpectralSolarPanel", 1, 0))
                    .itemOutputs(ItemList.Machine_IV_SolarPanel.get(1L)).duration(1 * SECONDS).eut(TierEU.RECIPE_LV)
                    .addTo(assemblerRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(SuperSolarPanels.ID, "SingularSolarPanel", 1, 0))
                    .itemOutputs(ItemList.Machine_LuV_SolarPanel.get(1L)).duration(1 * SECONDS).eut(TierEU.RECIPE_LV)
                    .addTo(assemblerRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(SuperSolarPanels.ID, "AdminSolarPanel", 1, 0))
                    .itemOutputs(ItemList.Machine_ZPM_SolarPanel.get(1L)).duration(1 * SECONDS).eut(TierEU.RECIPE_LV)
                    .addTo(assemblerRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(SuperSolarPanels.ID, "PhotonicSolarPanel", 1, 0))
                    .itemOutputs(ItemList.Machine_UV_SolarPanel.get(1L)).duration(1 * SECONDS).eut(TierEU.RECIPE_LV)
                    .addTo(assemblerRecipes);
        }

        // Vanilla Piston
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new OreDictItemStack("cobblestone", 1),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.gearGtSmall, (int) (1L)),
                        new OreDictItemStack("fenceWood", 1),
                        new OreDictItemStack("coverPlank", 6))
                .circuit(1).itemOutputs(new ItemStack(Blocks.piston, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Redstone, FluidShapes.fluidMolten, (int) (72L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Vanilla Compass
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.screw, (int) (2L)),
                        new OreDictItemStack("paneGlass", 1),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.bolt, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Zinc, Shapes.ring, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.plate, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.RedAlloy, Shapes.bolt, (int) (1L)))
                .itemOutputs(new ItemStack(Items.compass, 1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Bronze, Shapes.plate, (int) (8)))
                .circuit(8).itemOutputs(ItemList.Hull_Bronze.get(1)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Bronze, Shapes.plate, (int) (5)),
                        new ItemStack(Blocks.brick_block, 3))
                .circuit(6).itemOutputs(ItemList.Hull_Bronze_Bricks.get(1)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, (int) (8)))
                .circuit(7).itemOutputs(ItemList.Hull_HP.get(1)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.CastIron, Shapes.plate, (int) (5)),
                        new ItemStack(Blocks.brick_block, 3))
                .circuit(6).itemOutputs(ItemList.Hull_HP_Bricks.get(1)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.ReinforcedGlass.get(1L),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (4L)))
                .circuit(1).itemOutputs(NHItemList.Empty180SpCell.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.Empty180SpCell.get(2),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (3L)))
                .circuit(2).itemOutputs(NHItemList.Empty360SpCell.get()).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.Empty180SpCell.get(3),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (6L)))
                .circuit(3).itemOutputs(NHItemList.Empty540SpCell.get()).duration(15 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.Empty180SpCell.get(),
                        NHItemList.Empty360SpCell.get(),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (7L)))
                .circuit(1).itemOutputs(NHItemList.Empty540SpCell.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.Empty540SpCell.get(2),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (6L)),
                        MaterialLibAPI.getStack(Materials.ElectrumFlux, Shapes.plateDense, (int) (1L)))
                .circuit(2).itemOutputs(NHItemList.Empty1080SpCell.get()).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_EV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Polybenzimidazole, Shapes.plate, (int) (1L)),
                        GTModHandler.getIC2Item("carbonMesh", 1L))
                .circuit(4).itemOutputs(ItemList.Duct_Tape.get(2L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.AdvancedGlue, FluidShapes.fluidLiquid, (int) (200)))
                .duration(6 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Hull_LV.get(1), ItemList.Duct_Tape.get(2)).circuit(3)
                .itemOutputs(ItemList.Hatch_Maintenance.get(1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.AdvancedGlue, FluidShapes.fluidLiquid, (int) (200)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        // 10,30 and 60K NAK Cells

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 0),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (4L)))
                .circuit(1).itemOutputs(NHItemList.TenKCell.get()).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.TenKCell.get(3),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (6L)))
                .circuit(1).itemOutputs(NHItemList.ThirtyKCell.get()).duration(15 * SECONDS).eut(TierEU.RECIPE_MV / 2)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemCellEmpty", 3, 0),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (6L)))
                .circuit(1).itemOutputs(NHItemList.ThirtyKCell.get()).duration(15 * SECONDS).eut(TierEU.RECIPE_MV / 2)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.ThirtyKCell.get(2),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (8L)))
                .circuit(1).itemOutputs(NHItemList.SixtyKCell.get()).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemCellEmpty", 6, 0),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (8L)))
                .circuit(1).itemOutputs(NHItemList.SixtyKCell.get()).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorLuV, 64),
                        NHItemList.MicaInsulatorFoil.get(48))
                .itemOutputs(ItemList.Casing_Coil_Superconductor.get(1L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Trinium, FluidShapes.fluidMolten, (int) (1440L)))
                .duration(50 * SECONDS).eut(9001).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorZPM, 32),
                        ItemList.Naquarite_Universal_Insulator_Foil.get(4L))
                .itemOutputs(ItemList.Casing_Coil_Superconductor.get(1L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Trinium, FluidShapes.fluidMolten, (int) (576L)))
                .duration(50 * SECONDS).eut(9001).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUV, 16),
                        ItemList.Naquarite_Universal_Insulator_Foil.get(4L))
                .itemOutputs(ItemList.Casing_Coil_Superconductor.get(1L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Trinium, FluidShapes.fluidMolten, (int) (288L)))
                .duration(50 * SECONDS).eut(9001).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUHV, 8),
                        ItemList.Naquarite_Universal_Insulator_Foil.get(2L))
                .itemOutputs(ItemList.Casing_Coil_Superconductor.get(1L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Trinium, FluidShapes.fluidMolten, (int) (144L)))
                .duration(50 * SECONDS).eut(9001).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUEV, 4),
                        ItemList.Naquarite_Universal_Insulator_Foil.get(2L))
                .itemOutputs(ItemList.Casing_Coil_Superconductor.get(1L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Trinium, FluidShapes.fluidMolten, (int) (72L)))
                .duration(50 * SECONDS).eut(9001).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUIV, 2),
                        ItemList.Naquarite_Universal_Insulator_Foil.get(1L))
                .itemOutputs(ItemList.Casing_Coil_Superconductor.get(1L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Trinium, FluidShapes.fluidMolten, (int) (36L)))
                .duration(50 * SECONDS).eut(9001).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUMV, 1),
                        ItemList.Naquarite_Universal_Insulator_Foil.get(1L))
                .itemOutputs(ItemList.Casing_Coil_Superconductor.get(1L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Trinium, FluidShapes.fluidMolten, (int) (18L)))
                .duration(50 * SECONDS).eut(9001).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Steel, Shapes.stick, (int) (3L)))
                .circuit(3).itemOutputs(BlockList.SteelBars.get(4)).duration(20 * SECONDS).eut(48)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Aluminium, Shapes.stick, (int) (3L)))
                .circuit(3).itemOutputs(BlockList.AluminiumBars.get(4)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV / 2)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.stick, (int) (3L)))
                .circuit(3).itemOutputs(BlockList.StainlessSteelBars.get(4)).duration(20 * SECONDS).eut(96)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Titanium, Shapes.stick, (int) (3L)))
                .circuit(3).itemOutputs(BlockList.TitaniumBars.get(4)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.stick, (int) (3L)))
                .circuit(3).itemOutputs(BlockList.TungstenSteelBars.get(4)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Chrome, Shapes.stick, (int) (3L)))
                .circuit(3).itemOutputs(BlockList.ChromeBars.get(4)).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Iridium, Shapes.stick, (int) (3L)))
                .circuit(3).itemOutputs(BlockList.IridiumBars.get(4)).duration(20 * SECONDS).eut(TierEU.RECIPE_EV / 2)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Osmium, Shapes.stick, (int) (3L)))
                .circuit(3).itemOutputs(BlockList.OsmiumBars.get(4)).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Neutronium, Shapes.stick, (int) (3L)))
                .circuit(3).itemOutputs(BlockList.NeutroniumBars.get(4)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_IV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTModHandler.getIC2Item("carbonPlate", 4L), NHItemList.MoldBoots.get(0))
                .itemOutputs(NHItemList.CarbonPartBoots.get()).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(GTModHandler.getIC2Item("carbonPlate", 8L), NHItemList.MoldChestplate.get(0))
                .itemOutputs(NHItemList.CarbonPartChestplate.get()).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTModHandler.getIC2Item("carbonPlate", 5L), NHItemList.MoldHelmet.get(0))
                .itemOutputs(NHItemList.CarbonPartHelmet.get()).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTModHandler.getIC2Item("carbonPlate", 7L), NHItemList.MoldLeggings.get(0))
                .itemOutputs(NHItemList.CarbonPartLeggings.get()).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemArmorRubBoots", 1, 0),
                        getModItem(IndustrialCraft2.ID, "itemArmorNanoBoots", 1, WILDCARD))
                .itemOutputs(NHItemList.NanoRubberBoots.get()).duration(40 * SECONDS).eut(TierEU.RECIPE_EV / 2)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemArmorNanoLegs", 1, WILDCARD),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.itemCasing, (int) (4L)))
                .itemOutputs(NHItemList.NanoPlatedLeggings.get()).duration(40 * SECONDS).eut(TierEU.RECIPE_EV / 2)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemArmorNanoHelmet", 1, WILDCARD),
                        getModItem(IndustrialCraft2.ID, "itemArmorHazmatHelmet", 1, 0))
                .itemOutputs(NHItemList.NanoScubaHelmet.get()).duration(40 * SECONDS).eut(TierEU.RECIPE_EV / 2)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.NanoRubberBoots.get(), NHItemList.IridiumAlloyItemCasing.get(4))
                .itemOutputs(NHItemList.QuantumPartBoots.get()).duration(60 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GraviSuite.ID, "advNanoChestPlate", 1, WILDCARD),
                        NHItemList.IridiumAlloyItemCasing.get(8))
                .itemOutputs(NHItemList.QuantumPartChestplate.get()).duration(60 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.NanoScubaHelmet.get(), NHItemList.IridiumAlloyItemCasing.get(5))
                .itemOutputs(NHItemList.QuantumPartHelmetEmpty.get()).duration(60 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(NHItemList.QuantumPartHelmetEmpty.get(), NHItemList.ReinforcedGlassLense.get(8))
                .itemOutputs(NHItemList.QuantumPartHelmet.get()).duration(60 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(NHItemList.NanoPlatedLeggings.get(), NHItemList.IridiumAlloyItemCasing.get(7))
                .itemOutputs(NHItemList.QuantumPartLeggings.get()).duration(60 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.NagaScaleChip.get(4)).circuit(4)
                .itemOutputs(NHItemList.NagaScaleFragment.get())
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Thaumium, FluidShapes.fluidMolten, (int) (72L)))
                .duration(10 * SECONDS).eut(48).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.NagaScaleFragment.get(6)).circuit(6)
                .itemOutputs(getModItem(TwilightForest.ID, "item.nagaScale", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Thaumium, FluidShapes.fluidMolten, (int) (216L)))
                .duration(10 * SECONDS).eut(96).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.LichBoneChip.get(4)).circuit(4)
                .itemOutputs(NHItemList.LichBoneFragment.get())
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Thaumium, FluidShapes.fluidMolten, (int) (72L)))
                .duration(12 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.LichBoneFragment.get(6)).circuit(6)
                .itemOutputs(NHItemList.LichBone.get())
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Thaumium, FluidShapes.fluidMolten, (int) (216L)))
                .duration(12 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "ItemResource", 4, 14),
                        getModItem(TwilightForest.ID, "item.trophy", 0, 2))
                .itemOutputs(NHItemList.LichBone.get()).duration(45 * SECONDS).eut(TierEU.RECIPE_HV / 2)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CarminiteChip.get(4)).circuit(4)
                .itemOutputs(NHItemList.CarminiteFragment.get())
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Thaumium, FluidShapes.fluidMolten, (int) (72L)))
                .duration(17 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_EV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CarminiteFragment.get(6)).circuit(6)
                .itemOutputs(getModItem(TwilightForest.ID, "item.carminite", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Thaumium, FluidShapes.fluidMolten, (int) (216L)))
                .duration(17 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.SnowQueenBloodDrop.get(24)).circuit(24)
                .itemOutputs(NHItemList.SnowQueenBlood.get())
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Thaumium, FluidShapes.fluidMolten, (int) (216L)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_IV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "ItemResource", 10, 14),
                        getModItem(TwilightForest.ID, "item.trophy", 0, 4))
                .itemOutputs(NHItemList.SnowQueenBlood.get()).duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "ItemResource", 16, 14),
                        getModItem(Witchery.ID, "ingredient", 1, 130))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.gem, Materials.NetherStar, 1)).duration(45 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 1L),
                        GTOreDictUnificator.get(OrePrefixes.slab, Materials.Wood, 3L))
                .itemOutputs(NHItemList.WoodenCasing.get())
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Iron, FluidShapes.fluidMolten, (int) (32L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.EngineCore.get(),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (4L)),
                        Circuits.LV.get(1))
                .circuit(10).itemOutputs(getModItem(Forestry.ID, "engine", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.EngineCore.get(),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.plate, (int) (10L)))
                .circuit(10).itemOutputs(getModItem(Forestry.ID, "engine", 1, 1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.EngineCore.get(),
                        MaterialLibAPI.getStack(Materials.Bronze, Shapes.plate, (int) (10L)))
                .circuit(10).itemOutputs(getModItem(Forestry.ID, "engine", 1, 2)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.EngineCore.get(),
                        MaterialLibAPI.getStack(Materials.Invar, Shapes.plate, (int) (10L)))
                .circuit(10).itemOutputs(getModItem(BuildCraftCore.ID, "engineBlock", 1, 2)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.EngineCore.get(),
                        MaterialLibAPI.getStack(Materials.CastIron, Shapes.plate, (int) (10L)))
                .circuit(10).itemOutputs(getModItem(Forestry.ID, "engine", 1, 4)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        // HEE Ectoplasma and Arcane Shards

        GTValues.RA.stdBuilder().itemInputs(NHItemList.EctoplasmaChip.get(4)).circuit(4)
                .itemOutputs(NHItemList.EctoplasmaFragment.get())
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 100)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.EctoplasmaFragment.get(6)).circuit(6)
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "endoplasm", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 200)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ArcaneShardChip.get(4)).circuit(4)
                .itemOutputs(NHItemList.ArcaneShardFragment.get())
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 100)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ArcaneShardFragment.get(6)).circuit(6)
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 200)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        // HEE Runes

        GTValues.RA.stdBuilder().itemInputs(NHItemList.RuneOfPowerFragment.get(9)).circuit(9)
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "rune", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 1000)).duration(2 * MINUTES).eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.RuneOfAgilityFragment.get(9)).circuit(9)
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "rune", 1, 1))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 1000)).duration(2 * MINUTES).eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.RuneOfVigorFragment.get(9)).circuit(9)
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "rune", 1, 2))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 1000)).duration(2 * MINUTES).eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.RuneOfDefenseFragment.get(9)).circuit(9)
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "rune", 1, 3))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 1000)).duration(2 * MINUTES).eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.RuneOfMagicFragment.get(9)).circuit(9)
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "rune", 1, 4))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 1000)).duration(2 * MINUTES).eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.RuneOfVoidFragment.get(9)).circuit(9)
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "rune", 1, 5))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 1000)).duration(2 * MINUTES).eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);

        // IC2 Charging Batteries
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 4, WILDCARD),
                        Circuits.LV.get(1),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1L))
                .circuit(1).itemOutputs(getModItem(IndustrialCraft2.ID, "itemBatChargeRE", 1, 0))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.SolderingAlloy, FluidShapes.fluidMolten, (int) (144L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemAdvBat", 1, WILDCARD),
                        getModItem(IndustrialCraft2.ID, "itemAdvBat", 1, WILDCARD),
                        getModItem(IndustrialCraft2.ID, "itemAdvBat", 1, WILDCARD),
                        getModItem(IndustrialCraft2.ID, "itemAdvBat", 1, WILDCARD),
                        getModItem(IndustrialCraft2.ID, "reactorHeatSwitchSpread", 1, 1),
                        getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1, 1),
                        GTOreDictUnificator.get(OrePrefixes.cableGt02, Materials.Copper, 1L))
                .circuit(1).itemOutputs(getModItem(IndustrialCraft2.ID, "itemBatChargeAdv", 1, 0))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.SolderingAlloy, FluidShapes.fluidMolten, (int) (288L)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, WILDCARD),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, WILDCARD),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, WILDCARD),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, WILDCARD),
                        getModItem(IndustrialCraft2.ID, "reactorHeatSwitchSpread", 1, 1),
                        getModItem(IndustrialCraft2.ID, "reactorHeatSwitchSpread", 1, 1),
                        GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.Gold, 1L))
                .circuit(1).itemOutputs(getModItem(IndustrialCraft2.ID, "itemBatChargeCrystal", 1, 0))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.SolderingAlloy, FluidShapes.fluidMolten, (int) (576L)))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, WILDCARD),
                        getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, WILDCARD),
                        getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, WILDCARD),
                        getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, WILDCARD),
                        getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1, 1),
                        getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1, 1),
                        GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.Aluminium, 1L))
                .circuit(1).itemOutputs(getModItem(IndustrialCraft2.ID, "itemBatChargeLamaCrystal", 1, 0))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.SolderingAlloy, FluidShapes.fluidMolten, (int) (1440L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.wireFine, (int) (16L)),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.stick, (int) (4L)))
                .circuit(1).itemOutputs(NHItemList.AdsorptionFilterCasing.get()).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_MV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 4L),
                        Circuits.MV.get(4),
                        ItemList.Electric_Motor_MV.get(4L),
                        ItemList.Electric_Pump_MV.get(4L),
                        MaterialLibAPI.getStack(Materials.Cobalt, Shapes.gearGt, (int) (4L)))
                .circuit(2).itemOutputs(ItemList.OilDrill1.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.SolderingAlloy, FluidShapes.fluidMolten, (int) (144)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.OilDrill1.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 8L),
                        Circuits.HV.get(4),
                        ItemList.Electric_Motor_HV.get(4L),
                        ItemList.Electric_Pump_HV.get(4L),
                        MaterialLibAPI.getStack(Materials.BlueSteel, Shapes.gearGt, (int) (8L)))
                .circuit(2).itemOutputs(ItemList.OilDrill2.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.SolderingAlloy, FluidShapes.fluidMolten, (int) (288)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.OilDrill2.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 12L),
                        Circuits.EV.get(4),
                        ItemList.Electric_Motor_EV.get(4L),
                        ItemList.Electric_Pump_EV.get(4L),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.gearGt, (int) (12L)))
                .circuit(2).itemOutputs(ItemList.OilDrill3.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.SolderingAlloy, FluidShapes.fluidMolten, (int) (576)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.OilDrill3.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 16L),
                        Circuits.IV.get(4),
                        ItemList.Electric_Motor_IV.get(4L),
                        ItemList.Electric_Pump_IV.get(4L),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.gearGt, (int) (16L)))
                .circuit(2).itemOutputs(ItemList.OilDrill4.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.SolderingAlloy, FluidShapes.fluidMolten, (int) (1440)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_EV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 4L),
                        Circuits.EV.get(4),
                        ItemList.Electric_Motor_EV.get(4L),
                        ItemList.Electric_Pump_EV.get(4L),
                        ItemList.Conveyor_Module_EV.get(4L),
                        MaterialLibAPI.getStack(Materials.Tungsten, Shapes.gearGt, (int) (4L)))
                .circuit(2).itemOutputs(ItemList.OreDrill1.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.SolderingAlloy, FluidShapes.fluidMolten, (int) (72)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.OreDrill1.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 4L),
                        Circuits.IV.get(4),
                        ItemList.Electric_Motor_IV.get(4L),
                        ItemList.Electric_Pump_IV.get(4L),
                        ItemList.Conveyor_Module_IV.get(4L),
                        MaterialLibAPI.getStack(Materials.Iridium, Shapes.gearGt, (int) (4L)))
                .circuit(2).itemOutputs(ItemList.OreDrill2.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.SolderingAlloy, FluidShapes.fluidMolten, (int) (144)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.OreDrill2.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Osmiridium, 4L),
                        Circuits.LuV.get(4),
                        ItemList.Electric_Motor_LuV.get(4L),
                        ItemList.Electric_Pump_LuV.get(4L),
                        ItemList.Conveyor_Module_LuV.get(4L),
                        MaterialLibAPI.getStack(Materials.RhodiumPlatedPalladium, Shapes.gearGt, 4))
                .circuit(2).itemOutputs(ItemList.OreDrill3.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.SolderingAlloy, FluidShapes.fluidMolten, (int) (288)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.OreDrill3.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Europium, 4L),
                        Circuits.ZPM.get(4),
                        ItemList.Electric_Motor_ZPM.get(4L),
                        ItemList.Electric_Pump_ZPM.get(4L),
                        ItemList.Conveyor_Module_ZPM.get(4L),
                        MaterialLibAPI.getStack(Materials.MysteriousCrystal, Shapes.gearGt, (int) (4L)))
                .circuit(2).itemOutputs(ItemList.OreDrill4.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.SolderingAlloy, FluidShapes.fluidMolten, (int) (576)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);

        // LV Turbines

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.turbineBlade, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.stickLong, (int) (1L)))
                .itemOutputs(
                        MetaGeneratedTool01.INSTANCE.getToolWithStats(170, 1, Materials.Iron, Materials.Steel, null))
                .duration(16 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.CastIron, Shapes.turbineBlade, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.stickLong, (int) (1L)))
                .itemOutputs(
                        MetaGeneratedTool01.INSTANCE
                                .getToolWithStats(170, 1, Materials.CastIron, Materials.Steel, null))
                .duration(16 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.turbineBlade, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.stickLong, (int) (1L)))
                .itemOutputs(
                        MetaGeneratedTool01.INSTANCE.getToolWithStats(170, 1, Materials.Steel, Materials.Steel, null))
                .duration(16 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(NHItemList.LedoxCompressedPlate.get(), NHItemList.CallistoIceCompressedPlate.get())
                .itemOutputs(NHItemList.IceCompressedPlate.get(2))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        // UEV-UXV casings+hulls

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Bedrockium, Shapes.plate, (int) (8)))
                .circuit(8).itemOutputs(ItemList.Casing_UEV.get(1L)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.plate, (int) (8L)))
                .circuit(8).itemOutputs(ItemList.Casing_UIV.get(1L)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.SpaceTime, Shapes.plate, (int) (8L)))
                .circuit(8).itemOutputs(ItemList.Casing_UMV.get(1L)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI
                        .getStack(Materials.MagnetohydrodynamicallyConstrainedStarMatter, Shapes.plate, (int) (4L)),
                MaterialLibAPI.getStack(Materials.Magmatter, Shapes.plate, (int) (4L))).circuit(8)
                .itemOutputs(ItemList.Casing_UXV.get(1L)).duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV / 2)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.Draconium, 2L),
                        ItemList.Casing_UEV.get(1L))
                .itemOutputs(ItemList.Hull_UEV.get(1L))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.Polybenzimidazole, FluidShapes.fluidMolten, (int) (576L)))
                .duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.NetherStar, 2L),
                        ItemList.Casing_UIV.get(1L))
                .itemOutputs(ItemList.Hull_UIV.get(1L))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.Polybenzimidazole, FluidShapes.fluidMolten, (int) (576L)))
                .duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt12, Materials.Quantium, 2L),
                        ItemList.Casing_UMV.get(1L))
                .itemOutputs(ItemList.Hull_UMV.get(1L))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.Polybenzimidazole, FluidShapes.fluidMolten, (int) (576L)))
                .duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.BlackPlutonium, 2L),
                        ItemList.Casing_UXV.get(1L))
                .itemOutputs(ItemList.Hull_UXV.get(1L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Kevlar, FluidShapes.fluidMolten, (int) (576L)))
                .duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        // Hermetic casings

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Plastic, 1L),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, (int) (8L)))
                .circuit(4).itemOutputs(ItemList.Casing_Tank_1.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeLarge, Materials.PolyvinylChloride, 1L),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (8L)))
                .circuit(4).itemOutputs(ItemList.Casing_Tank_2.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Polytetrafluoroethylene, 1L),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (8L)))
                .circuit(4).itemOutputs(ItemList.Casing_Tank_3.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeLarge, Materials.StainlessSteel, 1L),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (8L)))
                .circuit(4).itemOutputs(ItemList.Casing_Tank_4.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Titanium, 1L),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (8L)))
                .circuit(4).itemOutputs(ItemList.Casing_Tank_5.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeLarge, Materials.TungstenSteel, 1L),
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.plate, (int) (8L)))
                .circuit(4).itemOutputs(ItemList.Casing_Tank_6.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeLarge, Materials.NiobiumTitanium, 1L),
                        MaterialLibAPI.getStack(Materials.Iridium, Shapes.plate, (int) (8L)))
                .circuit(4).itemOutputs(ItemList.Casing_Tank_7.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Enderium, 1L),
                        MaterialLibAPI.getStack(Materials.Osmium, Shapes.plate, (int) (8L)))
                .circuit(4).itemOutputs(ItemList.Casing_Tank_8.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Naquadah, 1L),
                        MaterialLibAPI.getStack(Materials.Neutronium, Shapes.plate, (int) (8L)))
                .circuit(4).itemOutputs(ItemList.Casing_Tank_9.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeLarge, Materials.MysteriousCrystal, 1L),
                        MaterialLibAPI.getStack(Materials.Bedrockium, Shapes.plate, (int) (8L)))
                .circuit(4).itemOutputs(ItemList.Casing_Tank_10.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                new OreDictItemStack(MaterialParts.craftIngredient(OrePrefixes.gem, Materials.Diamond).toString(), 1),
                Circuits.LV.get(4)).itemOutputs(NHItemList.TwilightCrystal.get()).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.plate, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.plate, (int) (1L)))
                .circuit(1).itemOutputs(getModItem(IronTanks.ID, "goldDiamondUpgrade", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glass, FluidShapes.fluidMolten, (int) (72L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.RawLapotronCrystal.get(), Circuits.HV.get(2))
                .itemOutputs(GTModHandler.getIC2Item("lapotronCrystal", 1L, 26)).duration(16 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Firebrick.get(24),
                        MaterialLibAPI.getStack(Materials.Gypsum, Shapes.dust, (int) (8L)))
                .itemOutputs(ItemList.Casing_Firebricks.get(4L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("concrete"), 4608)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Firebrick.get(24),
                        MaterialLibAPI.getStack(Materials.Gypsum, Shapes.dust, (int) (8L)))
                .itemOutputs(ItemList.Casing_Firebricks.get(4L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Concrete, FluidShapes.fluidMolten, (int) (4608L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Blocks.brick_block), GTOreDictUnificator.get("plateAnyBronze", 6)).circuit(1)
                .itemOutputs(ItemList.Casing_BronzePlatedBricks.get(1L)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.plate, (int) (2)),
                        ItemList.Casing_BronzePlatedBricks.get(1L))
                .itemOutputs(ItemList.Casing_Pyrolyse.get(1L)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // Engine Intake Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_StableTitanium.get(1),
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 2),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.rotor, (int) (4)))
                .itemOutputs(ItemList.Casing_EngineIntake.get(4)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        // Extreme Engine Intake Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_RobustTungstenSteel.get(1),
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.TungstenSteel, 2),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.rotor, (int) (4)))
                .itemOutputs(ItemList.Casing_ExtremeEngineIntake.get(4)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        // Filter Machine Casing for cleanroom
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 1L),
                        ItemList.Electric_Motor_MV.get(1L),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.rotor, (int) (1L)),
                        ItemList.Component_Filter.get(2L),
                        BlockList.SteelBars.get(2))
                .circuit(1).itemOutputs(ItemList.Casing_Vent.get(1L)).duration(30 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Carbon, Shapes.stick, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Sodium, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Glowstone, Shapes.dust, (int) (1L)),
                        getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0))
                .circuit(1).itemOutputs(getModItem(GalacticraftCore.ID, "tile.glowstoneTorch", 32, 0))
                .duration(20 * SECONDS).eut(192).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new OreDictItemStack("logWood", 4),
                        new OreDictItemStack("treeSapling", 4),
                        new ItemStack(Items.compass, 1, 0))
                .itemOutputs(getModItem(NaturesCompass.ID, "NaturesCompass", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glue, FluidShapes.fluidLiquid, (int) (144L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.string, 3, 0)).circuit(1)
                .itemOutputs(new ItemStack(Blocks.wool, 1, 0)).duration(5 * SECONDS).eut(4).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.CarbonPartHelmet.get(),
                        getModItem(IndustrialCraft2.ID, "itemNightvisionGoggles", 1, WILDCARD),
                        NHItemList.NanoCrystal.get(),
                        MaterialLibAPI.getStack(Materials.EnergeticAlloy, Shapes.wireFine, (int) (64L)))
                .circuit(1).itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorNanoHelmet", 1))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.RedstoneAlloy, FluidShapes.fluidMolten, (int) (288L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.CarbonPartChestplate.get(),
                        NHItemList.NanoCrystal.get(),
                        MaterialLibAPI.getStack(Materials.EnergeticAlloy, Shapes.wireFine, (int) (64L)))
                .circuit(1).itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorNanoChestplate", 1))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.RedstoneAlloy, FluidShapes.fluidMolten, (int) (1440L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.CarbonPartLeggings.get(),
                        NHItemList.NanoCrystal.get(),
                        MaterialLibAPI.getStack(Materials.EnergeticAlloy, Shapes.wireFine, (int) (64L)))
                .circuit(1).itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorNanoLegs", 1))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.RedstoneAlloy, FluidShapes.fluidMolten, (int) (576L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.CarbonPartBoots.get(),
                        NHItemList.NanoCrystal.get(),
                        MaterialLibAPI.getStack(Materials.EnergeticAlloy, Shapes.wireFine, (int) (64L)))
                .circuit(1).itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorNanoBoots", 1))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.RedstoneAlloy, FluidShapes.fluidMolten, (int) (288L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_LV.get(1L),
                        Circuits.LV.get(1),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockPersonal", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Covers

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Glass, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Glowstone, Shapes.dust, (int) (1)),
                        new OreDictItemStack("dyeRed", 1),
                        new OreDictItemStack("dyeLime", 1),
                        new OreDictItemStack("dyeBlue", 1))
                .itemOutputs(ItemList.Cover_Screen.get(1L)).duration(5 * SECONDS).eut(5).addTo(assemblerRecipes);
        // Nukes

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Lead, Shapes.plateDense, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plateDense, (int) (2L)),
                        getModItem(IndustrialCraft2.ID, "itemPartAlloy", 2),
                        getModItem(IndustrialCraft2.ID, "blockMachine", 1, 12))
                .circuit(21).itemOutputs(getModItem(IndustrialCraft2.ID, "blockReactorChamber", 1))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Lead, Shapes.plateDense, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plateDense, (int) (2L)),
                        getModItem(IndustrialCraft2.ID, "blockReactorChamber", 3),
                        GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.Platinum, 1L),
                        Circuits.EV.get(1))
                .circuit(22).itemOutputs(getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 5)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_EV / 2).addTo(assemblerRecipes);

        if (AdvancedSolarPanel.isModLoaded()) {
            // Irradiant Glass Pane
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 4, 2),
                            ItemList.ReinforcedGlass.get(4L),
                            MaterialLibAPI.getStack(Materials.Glowstone, Shapes.plate, (int) (1)))
                    .circuit(1).itemOutputs(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 4, 5))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

            // Irradiant Uranium
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.Uranium, Shapes.ingot, (int) (1)),
                            getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 0))
                    .itemOutputs(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 2)).duration(30 * SECONDS)
                    .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        }
        // Solar Light Splitter
        if (SuperSolarPanels.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(SuperSolarPanels.ID, "bluecomponent", 3, 0),
                            getModItem(SuperSolarPanels.ID, "redcomponent", 3, 0),
                            getModItem(SuperSolarPanels.ID, "greencomponent", 3, 0))
                    .circuit(1).itemOutputs(getModItem(SuperSolarPanels.ID, "solarsplitter", 1, 0))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        }
        // Heat Exchangers

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Silver, Shapes.plate, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.plate, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (2L)),
                        Circuits.HV.get(1))
                .circuit(21).itemOutputs(getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1, 1))
                .duration(3 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.plateDouble, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Silver, Shapes.plate, (int) (2L)),
                        getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1, 1))
                .circuit(21).itemOutputs(getModItem(IndustrialCraft2.ID, "reactorHeatSwitchCore", 1, 1))
                .duration(3 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.plate, (int) (2L)),
                        getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1, 1))
                .circuit(21).itemOutputs(getModItem(IndustrialCraft2.ID, "reactorHeatSwitchSpread", 1, 1))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.StainlessSteel, FluidShapes.fluidMolten, (int) (72)))
                .duration(1 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Lapis, Shapes.plate, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.plate, (int) (1L)),
                        Circuits.EV.get(2),
                        getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1, 1),
                        getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1, 1))
                .circuit(21).itemOutputs(getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1, 1))
                .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Heat Vents

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_LV.get(1L),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (2L)),
                        new ItemStack(Blocks.iron_bars, 2))
                .circuit(21).itemOutputs(getModItem(IndustrialCraft2.ID, "reactorVent", 1, 1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.plateDouble, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Silver, Shapes.plate, (int) (2L)),
                        getModItem(IndustrialCraft2.ID, "reactorVent", 1, 1))
                .circuit(22).itemOutputs(getModItem(IndustrialCraft2.ID, "reactorVentCore", 1, 1))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.IC2_Industrial_Diamond.get(1L),
                        getModItem(IndustrialCraft2.ID, "reactorVent", 1, 1),
                        BlockList.StainlessSteelBars.get(4))
                .circuit(21).itemOutputs(getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1, 1))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.plate, (int) (2L)),
                        getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1, 1))
                .circuit(22).itemOutputs(getModItem(IndustrialCraft2.ID, "reactorVentGold", 1, 1))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.StainlessSteel, FluidShapes.fluidMolten, (int) (72)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plateDense, (int) (2L)),
                        BlockList.SteelBars.get(2),
                        getModItem(IndustrialCraft2.ID, "reactorVent", 1, 1))
                .circuit(21).itemOutputs(getModItem(IndustrialCraft2.ID, "reactorVentSpread", 1)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.RedAlloy, Shapes.plate, (int) (4L)),
                        getModItem(IndustrialCraft2.ID, "reactorHeatSwitchCore", 2, 1),
                        getModItem(IndustrialCraft2.ID, "reactorVentCore", 1, 1))
                .circuit(21).itemOutputs(getModItem(IndustrialCraft2.ID, "reactorCondensator", 1, 1))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Lapis, 1L),
                        MaterialLibAPI.getStack(Materials.RedAlloy, Shapes.plateDense, (int) (2L)),
                        getModItem(IndustrialCraft2.ID, "reactorVentGold", 1, 1),
                        getModItem(IndustrialCraft2.ID, "reactorHeatSwitchSpread", 1, 1),
                        getModItem(IndustrialCraft2.ID, "reactorCondensator", 1, 1),
                        getModItem(IndustrialCraft2.ID, "reactorCondensator", 1, 1))
                .circuit(21).itemOutputs(getModItem(IndustrialCraft2.ID, "reactorCondensatorLap", 1, 1))
                .duration(45 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Easier chest upgrades

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.chest, Materials.Copper, 1L),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.plateDouble, (int) (1L)))
                .circuit(2).itemOutputs(GTOreDictUnificator.get(OrePrefixes.chest, Materials.Iron, 1L))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.chest, Materials.Copper, 1L),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plateDouble, (int) (1L)))
                .circuit(2).itemOutputs(GTOreDictUnificator.get(OrePrefixes.chest, Materials.Steel, 1L))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.chest, Materials.Iron, 1L),
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.plateDouble, (int) (1L)))
                .circuit(2).itemOutputs(GTOreDictUnificator.get(OrePrefixes.chest, Materials.Gold, 1L))
                .duration(25 * SECONDS).eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.chest, Materials.Steel, 1L),
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.plateDouble, (int) (1L)))
                .circuit(2).itemOutputs(GTOreDictUnificator.get(OrePrefixes.chest, Materials.Gold, 1L))
                .duration(25 * SECONDS).eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.chest, Materials.Gold, 1L),
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.plate, (int) (2L)))
                .circuit(2).itemOutputs(GTOreDictUnificator.get(OrePrefixes.chest, Materials.Diamond, 1L))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Reactor Plating

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Lead, Shapes.plateDense, (int) (1L)),
                        getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4))
                .circuit(22).itemOutputs(getModItem(IndustrialCraft2.ID, "reactorPlating", 1)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.plateDense, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.plate, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Silver, Shapes.plate, (int) (1L)),
                        getModItem(IndustrialCraft2.ID, "reactorPlating", 1))
                .circuit(21).itemOutputs(getModItem(IndustrialCraft2.ID, "reactorPlatingHeat", 1))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Lead, Shapes.plateDense, (int) (2L)),
                        getModItem(IndustrialCraft2.ID, "itemPartAlloy", 2),
                        getModItem(IndustrialCraft2.ID, "reactorPlating", 1))
                .circuit(23).itemOutputs(getModItem(IndustrialCraft2.ID, "reactorPlatingExplosive", 1))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        // LV and MV Energy Hatches

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2),
                        ItemList.Electric_Pump_LV.get(1),
                        ItemList.Hull_LV.get(1),
                        ItemList.LV_Coil.get(2),
                        Circuits.LV.get(1))
                .circuit(4).itemOutputs(ItemList.Hatch_Energy_LV.get(1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Lubricant, FluidShapes.fluidLiquid, (int) (2000)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1),
                        ItemList.Electric_Pump_MV.get(1),
                        ItemList.Hull_MV.get(1),
                        ItemList.MV_Coil.get(2),
                        ItemList.Circuit_Chip_ULPIC.get(2))
                .circuit(4).itemOutputs(ItemList.Hatch_Energy_MV.get(1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Lubricant, FluidShapes.fluidLiquid, (int) (2000)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        // Neutron reflector recipes

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.plateDouble, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (4L)),
                        GTOreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 2L),
                        MaterialLibAPI.getStack(Materials.Graphite, Shapes.dust, (int) (16L)))
                .circuit(1).itemOutputs(getModItem(IndustrialCraft2.ID, "reactorReflector", 1, 1)).requiresCleanRoom()
                .duration(60 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Beryllium, Shapes.plateDouble, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (4L)),
                        GTOreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 2L),
                        MaterialLibAPI.getStack(Materials.Graphite, Shapes.dust, (int) (8L)))
                .circuit(1).itemOutputs(getModItem(IndustrialCraft2.ID, "reactorReflector", 1, 1)).requiresCleanRoom()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.TungstenCarbide, Shapes.plateDouble, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (4L)),
                        GTOreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 2L),
                        MaterialLibAPI.getStack(Materials.Graphite, Shapes.dust, (int) (4L)))
                .circuit(1).itemOutputs(getModItem(IndustrialCraft2.ID, "reactorReflector", 1, 1)).requiresCleanRoom()
                .duration(20 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Beryllium, Shapes.plateDouble, (int) (2L)),
                        getModItem(IndustrialCraft2.ID, "reactorReflector", 1, 1),
                        getModItem(IndustrialCraft2.ID, "reactorReflector", 1, 1),
                        getModItem(IndustrialCraft2.ID, "reactorReflector", 1, 1),
                        getModItem(IndustrialCraft2.ID, "reactorReflector", 1, 1))
                .circuit(1).itemOutputs(getModItem(IndustrialCraft2.ID, "reactorReflectorThick", 1, 0))
                .requiresCleanRoom().duration(30 * SECONDS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.TungstenCarbide, Shapes.plateDouble, (int) (2L)),
                        getModItem(IndustrialCraft2.ID, "reactorReflector", 1, 1),
                        getModItem(IndustrialCraft2.ID, "reactorReflector", 1, 1),
                        getModItem(IndustrialCraft2.ID, "reactorReflector", 1, 1),
                        getModItem(IndustrialCraft2.ID, "reactorReflector", 1, 1))
                .circuit(1).itemOutputs(getModItem(IndustrialCraft2.ID, "reactorReflectorThick", 1, 0))
                .requiresCleanRoom().duration(30 * SECONDS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Iridium, 2L),
                        getModItem(IndustrialCraft2.ID, "reactorReflectorThick", 1, 0),
                        getModItem(IndustrialCraft2.ID, "reactorReflectorThick", 1, 0),
                        getModItem(IndustrialCraft2.ID, "reactorReflectorThick", 1, 0),
                        getModItem(IndustrialCraft2.ID, "reactorReflectorThick", 1, 0),
                        getModItem(IndustrialCraft2.ID, "reactorReflectorThick", 1, 0),
                        getModItem(IndustrialCraft2.ID, "reactorReflectorThick", 1, 0))
                .circuit(1).itemOutputs(ItemList.Neutron_Reflector.get(1L)).requiresCleanRoom().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Iridium, 2L),
                        MaterialLibAPI.getStack(Materials.TungstenCarbide, Shapes.plateDouble, (int) (36L)),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (64L)),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (32L)),
                        GTOreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 48L),
                        MaterialLibAPI.getStack(Materials.Graphite, Shapes.dust, (int) (64L)),
                        MaterialLibAPI.getStack(Materials.Graphite, Shapes.dust, (int) (32L)))
                .circuit(2).itemOutputs(ItemList.Neutron_Reflector.get(1L)).requiresCleanRoom()
                .duration(2 * MINUTES + 37 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Iridium, 2L),
                        MaterialLibAPI.getStack(Materials.Beryllium, Shapes.plateDouble, (int) (36L)),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (64L)),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (32L)),
                        GTOreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 48L),
                        MaterialLibAPI.getStack(Materials.Graphite, Shapes.dust, (int) (64L)),
                        MaterialLibAPI.getStack(Materials.Graphite, Shapes.dust, (int) (64L)),
                        MaterialLibAPI.getStack(Materials.Graphite, Shapes.dust, (int) (64L)))
                .circuit(2).itemOutputs(ItemList.Neutron_Reflector.get(1L)).requiresCleanRoom()
                .duration(3 * MINUTES + 7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);

        // Humongous input hatch
        GTValues.RA.stdBuilder().itemInputs(ItemList.Hatch_Input_UXV.get(1), ItemList.Quantum_Tank_IV.get(1))
                .itemOutputs(ItemRegistry.humongousInputHatch.copy())
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.spatialFluid, FluidShapes.fluidMolten, (int) (5_760L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_UMV).addTo(assemblerRecipes);

        // Wood Plates
        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Wood, Shapes.dust, (int) (64))).circuit(2)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Wood, Shapes.plate, (int) (32)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glue, FluidShapes.fluidLiquid, (int) (72L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Wood, Shapes.dust, (int) (64))).circuit(2)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Wood, Shapes.plate, (int) (32)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.AdvancedGlue, FluidShapes.fluidLiquid, (int) (36L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Wood, Shapes.dust, (int) (64))).circuit(2)
                .itemOutputs(MaterialLibAPI.getStack(Materials.Wood, Shapes.plate, (int) (32)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.EthylCyanoacrylateSuperGlue,
                                FluidShapes.fluidMolten,
                                (int) (18)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        if (OpenBlocks.isModLoaded() && BloodMagic.isModLoaded()) {
            ItemStack[] trophies = { getModItem(OpenBlocks.ID, "trophy", 1), getModItem(OpenBlocks.ID, "trophy", 1),
                    getModItem(OpenBlocks.ID, "trophy", 1), getModItem(OpenBlocks.ID, "trophy", 1), };

            NBTTagCompound[] tag = { new NBTTagCompound(), new NBTTagCompound(), new NBTTagCompound(),
                    new NBTTagCompound(), };

            tag[0].setString("entity", "Bat");
            tag[1].setString("entity", "Cow");
            tag[2].setString("entity", "Chicken");
            tag[3].setString("entity", "Sheep");

            ItemStack flightpotion = getModItem(BloodMagic.ID, "alchemyFlask", 1);
            NBTTagCompound flighttag = new NBTTagCompound();
            NBTTagList flighsubtag = new NBTTagList();
            NBTTagCompound temp;

            temp = new NBTTagCompound();
            temp.setInteger("concentration", 0);
            temp.setInteger("durationFactor", 2);
            temp.setInteger("potionID", 104);
            temp.setInteger("tickDuration", 1200);
            flighsubtag.appendTag(temp);

            flighttag.setTag("CustomFlaskEffects", flighsubtag);
            flightpotion.setTagCompound(flighttag);

            for (int i = 0; i < 4; ++i) {
                trophies[i].setTagCompound(tag[i]);
            }

            GTValues.RA.stdBuilder().itemInputs(trophies[0], new ItemStack(Items.golden_carrot))
                    .itemOutputs(new ItemStack(Items.potionitem, 1, 8262)).duration(6 * SECONDS).eut(TierEU.RECIPE_MV)
                    .nbtSensitive().addTo(assemblerRecipes);

            GTValues.RA.stdBuilder().itemInputs(trophies[1], new ItemStack(Items.iron_sword))
                    .itemOutputs(new ItemStack(Items.leather, 64)).duration(6 * SECONDS).eut(TierEU.RECIPE_MV)
                    .nbtSensitive().addTo(assemblerRecipes);

            GTValues.RA.stdBuilder().itemInputs(trophies[2], new ItemStack(Items.feather)).itemOutputs(flightpotion)
                    .duration(6 * SECONDS).eut(TierEU.RECIPE_MV).nbtSensitive().addTo(assemblerRecipes);

            GTValues.RA.stdBuilder().itemInputs(trophies[3], new ItemStack(Items.shears))
                    .itemOutputs(new ItemStack(Blocks.wool, 64)).duration(6 * SECONDS).eut(TierEU.RECIPE_MV)
                    .nbtSensitive().addTo(assemblerRecipes);

        }

        if (PamsHarvestCraft.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.string, 4), new OreDictItemStack("cropCotton", 3))
                    .itemOutputs(getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0)).duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        }

        if (PamsHarvestCraft.isModLoaded() && Forestry.isModLoaded() && OpenComputers.isModLoaded()) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sugar, 1L),
                            MaterialLibAPI.getStack(Materials.Fuel, CellShapes.cell, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.SulfuricAcid, CellShapes.cell, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.Acetone, CellShapes.cell, (int) (1L)),
                            getModItem(PamsHarvestCraft.ID, "pepperoniItem", 1, 0),
                            GTOreDictUnificator.get("dyeRed", 1L))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 18))
                    .fluidInputs(FluidRegistry.getFluidStack("mead", 1000)).duration(10 * MINUTES).eut(TierEU.RECIPE_HV)
                    .addTo(assemblerRecipes);
        }

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.CastIron, 1L),
                        BlockList.SteelBars.get(6))
                .circuit(1).itemOutputs(GregtechItemList.FishTrap.get(1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);

        if (ExtraBees.isModLoaded()) {
            ItemStack alveary = getModItem(Forestry.ID, "alveary", 1, 0);

            // Mutator
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            alveary,
                            getModItem(Forestry.ID, "thermionicTubes", 4, 12),
                            MaterialLibAPI.getStack(Materials.EnderEye, Shapes.plate, (int) (2L)),
                            MaterialLibAPI.getStack(Materials.EnderPearl, Shapes.plate, (int) (2L)),
                            getModItem(ExtraBees.ID, "hiveFrame.soul", 1, 0))
                    .itemOutputs(getModItem(ExtraBees.ID, "alveary", 1, 0))
                    .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Honey, FluidShapes.fluidLiquid, (int) (7500L)))
                    .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

            // Frame Housing
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            alveary,
                            getModItem(Forestry.ID, "thermionicTubes", 4, 10),
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.WoodSealed, 1L),
                            getModItem(Forestry.ID, "frameProven", 1, 0),
                            getModItem(Forestry.ID, "frameProven", 1, 0),
                            getModItem(Forestry.ID, "frameProven", 1, 0),
                            getModItem(Forestry.ID, "frameProven", 1, 0))
                    .itemOutputs(getModItem(ExtraBees.ID, "alveary", 1, 1))
                    .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Honey, FluidShapes.fluidLiquid, (int) (7500L)))
                    .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

            // Rain Shield
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            alveary,
                            getModItem(Forestry.ID, "thermionicTubes", 4, 8),
                            ItemList.PadBouncy.get(4L),
                            new ItemStack(Blocks.brick_block, 1, 0))
                    .itemOutputs(getModItem(ExtraBees.ID, "alveary", 1, 2))
                    .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Honey, FluidShapes.fluidLiquid, (int) (7500L)))
                    .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

            // Alveary Lighting
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            alveary,
                            getModItem(Forestry.ID, "thermionicTubes", 4, 2),
                            new ItemStack(Blocks.stained_glass, 4, WILDCARD),
                            new ItemStack(Blocks.redstone_lamp, 1, 0))
                    .itemOutputs(getModItem(ExtraBees.ID, "alveary", 1, 3))
                    .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Honey, FluidShapes.fluidLiquid, (int) (7500L)))
                    .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

            // Electrical Stimulator
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            alveary,
                            getModItem(Forestry.ID, "thermionicTubes", 4, 1),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Silver, 2L),
                            getModItem(Forestry.ID, "chipsets", 2, 2),
                            ItemList.Electric_Motor_HV.get(1L))
                    .itemOutputs(getModItem(ExtraBees.ID, "alveary", 1, 4))
                    .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Honey, FluidShapes.fluidLiquid, (int) (7500L)))
                    .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

            // Hatchery
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            alveary,
                            getModItem(Forestry.ID, "thermionicTubes", 4, 3),
                            MaterialLibAPI.getStack(Materials.Redstone, Shapes.plate, (int) (2L)),
                            ItemList.Conveyor_Module_MV.get(2L),
                            getModItem(Forestry.ID, "apiculture", 1, 0))
                    .itemOutputs(getModItem(ExtraBees.ID, "alveary", 1, 5))
                    .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Honey, FluidShapes.fluidLiquid, (int) (7500L)))
                    .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

            // Alveary Transmission
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            alveary,
                            getModItem(Forestry.ID, "thermionicTubes", 4, 0),
                            Circuits.HV.get(1),
                            GTOreDictUnificator.get(OrePrefixes.cableGt02, Materials.Aluminium, 3L),
                            ItemList.Hull_HV.get(1L))
                    .itemOutputs(getModItem(ExtraBees.ID, "alveary", 1, 6))
                    .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Honey, FluidShapes.fluidLiquid, (int) (7500L)))
                    .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

            // Alveary Unlighting
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            alveary,
                            getModItem(Forestry.ID, "thermionicTubes", 4, 8),
                            getModItem(ExtraUtilities.ID, "curtains", 4, 0),
                            new ItemStack(Blocks.wool, 1, 15))
                    .itemOutputs(getModItem(ExtraBees.ID, "alveary", 1, 7))
                    .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Honey, FluidShapes.fluidLiquid, (int) (7500L)))
                    .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        }

        if (Gendustry.isModLoaded()) {
            // pollen collection kit
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Gendustry.ID, "Labware", 1),
                            getModItem(Minecraft.ID, "string", 1),
                            getModItem(Minecraft.ID, "paper", 1))
                    .itemOutputs(getModItem(Gendustry.ID, "PollenKit", 1)).duration(10 * SECONDS).eut(TierEU.RECIPE_IV)
                    .addTo(assemblerRecipes);

        }

        if (ExtraUtilities.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Bedrockium, Shapes.dust, (int) (9L)))
                    .circuit(1).itemOutputs(getModItem(ExtraUtilities.ID, "bedrockiumIngot", 1, 0)).duration(1 * TICKS)
                    .eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);

            GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Unstable, Shapes.dust, (int) (9L)))
                    .circuit(1).itemOutputs(getModItem(ExtraUtilities.ID, "unstableingot", 1, 2)).duration(1 * TICKS)
                    .eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);

        }

        if (ExtraUtilities.isModLoaded() && IronChests.isModLoaded()) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(IronChests.ID, "BlockIronChest", 1, 0),
                            MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, (int) (4L)))
                    .circuit(1).itemOutputs(getModItem(ExtraUtilities.ID, "filing", 1, 0))
                    .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (144L)))
                    .duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        }

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeQuadruple, Materials.Infinity, 1L),
                        ItemList.Hull_UEV.get(1L))
                .circuit(4).itemOutputs(ItemList.Hatch_Input_Multi_2x2_UEV.get(1L))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.Polybenzimidazole, FluidShapes.fluidMolten, (int) (2304L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_UEV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeQuadruple, Materials.TranscendentMetal, 1L),
                        ItemList.Hull_UIV.get(1L))
                .circuit(4).itemOutputs(ItemList.Hatch_Input_Multi_2x2_UIV.get(1L))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.Polybenzimidazole, FluidShapes.fluidMolten, (int) (2304L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_UIV).addTo(assemblerRecipes);

        // Gear Box Casings
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Bronze, 1),
                        MaterialLibAPI.getStack(Materials.Bronze, Shapes.gearGt, (int) (2)),
                        MaterialLibAPI.getStack(Materials.Bronze, Shapes.plate, (int) (4)))
                .circuit(3).itemOutputs(ItemList.Casing_Gearbox_Bronze.get(1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.gearGt, (int) (2)),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, (int) (4)))
                .circuit(3).itemOutputs(ItemList.Casing_Gearbox_Steel.get(1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 1),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.gearGt, (int) (2)),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, (int) (4)))
                .circuit(3).itemOutputs(ItemList.Casing_Gearbox_Titanium.get(1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // Quantum Armor
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.QuantumPartHelmet.get(),
                        NHItemList.QuantumCrystal.get(),
                        Circuits.LuV.get(2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 4),
                        ItemList.Energy_LapotronicOrb.get(1L),
                        ItemList.Sensor_IV.get(1L),
                        ItemList.Field_Generator_EV.get(1L),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.screw, (int) (4)))
                .circuit(10).itemOutputs(GTModHandler.getIC2Item("quantumHelmet", 1L, 26))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Titanium, FluidShapes.fluidMolten, (int) (1728L)))
                .duration(1 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.QuantumPartChestplate.get(),
                        NHItemList.QuantumCrystal.get(),
                        Circuits.LuV.get(2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 6),
                        ItemList.Energy_LapotronicOrb.get(1L),
                        ItemList.Field_Generator_EV.get(3L),
                        ItemList.Electric_Motor_IV.get(2L),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.screw, (int) (4)))
                .circuit(11).itemOutputs(GTModHandler.getIC2Item("quantumBodyarmor", 1L, 26))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Titanium, FluidShapes.fluidMolten, (int) (2880L)))
                .duration(1 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.QuantumPartLeggings.get(),
                        NHItemList.QuantumCrystal.get(),
                        Circuits.LuV.get(2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 6),
                        ItemList.Energy_LapotronicOrb.get(1L),
                        ItemList.Field_Generator_EV.get(2L),
                        ItemList.Electric_Motor_IV.get(4L),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.screw, (int) (4)))
                .circuit(12).itemOutputs(GTModHandler.getIC2Item("quantumLeggings", 1L, 26))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Titanium, FluidShapes.fluidMolten, (int) (2304L)))
                .duration(1 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.QuantumPartBoots.get(),
                        NHItemList.QuantumCrystal.get(),
                        Circuits.LuV.get(2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 4),
                        ItemList.Energy_LapotronicOrb.get(1L),
                        ItemList.Field_Generator_EV.get(1L),
                        ItemList.Electric_Piston_IV.get(2L),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.screw, (int) (4)))
                .circuit(13).itemOutputs(GTModHandler.getIC2Item("quantumBoots", 1L, 26))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Titanium, FluidShapes.fluidMolten, (int) (1440L)))
                .duration(1 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        // EBF Controller
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "blast_furnace", 3, 0),
                        ItemList.Casing_HeatProof.get(1L),
                        Circuits.LV.get(3),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2))
                .itemOutputs(ItemList.Machine_Multi_BlastFurnace.get(1L)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // Vacuum Freezer Controller
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Pump_HV.get(3L),
                        ItemList.Casing_FrostProof.get(1L),
                        Circuits.EV.get(3),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2))
                .itemOutputs(ItemList.Machine_Multi_VacuumFreezer.get(1)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // Large Chemical Reactor
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_HV.get(1L),
                        ItemList.Hull_HV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Polytetrafluoroethylene, 2L),
                        Circuits.HV.get(4),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.rotor, (int) (1)))
                .circuit(1).itemOutputs(ItemList.Machine_Multi_LargeChemicalReactor.get(1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // Industrial Autoclave
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.AutoclaveLuV.get(2L),
                        ItemList.Casing_Autoclave.get(4L),
                        Circuits.LuV.get(4),
                        MaterialLibAPI.getStack(Materials.LafiumCompound, Shapes.plate, (int) (8)))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.Polybenzimidazole, FluidShapes.fluidMolten, (int) (8 * 144)))
                .itemOutputs(ItemList.Machine_Multi_Autoclave.get(1L)).duration(30 * SECONDS).eut(TierEU.RECIPE_LuV)
                .addTo(assemblerRecipes);

        // YOTT Casings
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.BlackSteel, Shapes.plate, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Polytetrafluoroethylene, Shapes.plate, (int) (2L)),
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 2L),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.BlackSteel, 1L))
                .itemOutputs(new ItemStack(Loaders.yottaFluidTankCasing, 1, 0)).duration(24 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // Industrial Autoclave
        GTValues.RA.stdBuilder()
                .itemInputs(GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Polytetrafluoroethylene, 1L))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.StainlessSteel, FluidShapes.fluidMolten, (int) (8 * 144)))
                .itemOutputs(ItemList.Casing_Autoclave.get(1L)).duration(20 * SECONDS).eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);

        // Volcanus Controller
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GregtechItemList.Casing_Adv_BlastFurnace.get(1),
                        MaterialLibAPI.getStack(Materials.HastelloyN, Shapes.plateDouble, (int) (2)),
                        MaterialLibAPI.getStack(Materials.HastelloyW, Shapes.gearGt, (int) (2)),
                        ItemList.Robot_Arm_IV.get(2),
                        Circuits.LuV.get(1),
                        GregtechItemList.Gregtech_Computer_Cube.get(1))
                .itemOutputs(GregtechItemList.Machine_Adv_BlastFurnace.get(1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        // Cryogenic Freezer Controller
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GregtechItemList.Casing_AdvancedVacuum.get(1),
                        MaterialLibAPI.getStack(Materials.Grisium, Shapes.plateDouble, (int) (2)),
                        MaterialLibAPI.getStack(Materials.IncoloyMA956, Shapes.gearGt, (int) (2)),
                        ItemList.Electric_Piston_IV.get(2),
                        Circuits.LuV.get(1),
                        GregtechItemList.Gregtech_Computer_Cube.get(1))
                .itemOutputs(ItemList.CryogenicFreezer.get(1)).duration(10 * SECONDS).eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);

        if (GraviSuite.isModLoaded() && GalacticraftMars.isModLoaded()) {
            // Gravitational Engine
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.wireGt12, Materials.SuperconductorLuV, 2),
                            getModItem(IndustrialCraft2.ID, "blockMachine2", 4, 1),
                            ItemList.Transformer_LuV_IV.get(1),
                            getModItem(GraviSuite.ID, "itemSimpleItem", 2, 2))
                    .itemOutputs(getModItem(GraviSuite.ID, "itemSimpleItem", 1, 3)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
            // Fluid Manipulator
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Large_Fluid_Cell_Steel.get(1),
                            GTOreDictUnificator.get(OrePrefixes.pipeQuadruple, Materials.Steel, 4),
                            ItemList.Electric_Pump_HV.get(4))
                    .itemOutputs(getModItem(GalacticraftMars.ID, "item.null", 1, 6)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
            // Cooling Core With NaK
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 2, 1),
                            getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 2, 1),
                            MaterialLibAPI.getStack(Materials.CallistoIce, Shapes.plate, (int) (1)),
                            ItemList.Reactor_Coolant_NaK_3.get(2),
                            getModItem(IndustrialCraft2.ID, "reactorPlatingHeat", 2, 0))
                    .itemOutputs(getModItem(GraviSuite.ID, "itemSimpleItem", 1, 2)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
            // Cooling Core With Helium
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 2, 1),
                            getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 2, 1),
                            MaterialLibAPI.getStack(Materials.CallistoIce, Shapes.plate, (int) (1)),
                            ItemList.Reactor_Coolant_He_3.get(2),
                            getModItem(IndustrialCraft2.ID, "reactorPlatingHeat", 2, 0))
                    .itemOutputs(getModItem(GraviSuite.ID, "itemSimpleItem", 1, 2)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        }
        // ULV Transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Lead, 4),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1),
                        ItemList.Hull_ULV.get(1))
                .itemOutputs(ItemList.Transformer_LV_ULV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // LV Transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 4),
                        new OreDictItemStack("cableGt01AnyCopper", 1),
                        ItemList.Hull_LV.get(1))
                .itemOutputs(ItemList.Transformer_MV_LV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // MV Transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new OreDictItemStack("cableGt01AnyCopper", 4),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1),
                        ItemList.Hull_MV.get(1),
                        ItemList.Circuit_Parts_InductorSMD.get(2))
                .itemOutputs(ItemList.Transformer_HV_MV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // HV Transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 4),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1),
                        ItemList.Hull_HV.get(1),
                        ItemList.Circuit_Chip_ULPIC.get(2))
                .itemOutputs(ItemList.Transformer_EV_HV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // EV Transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 4),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1),
                        ItemList.Hull_EV.get(1),
                        ItemList.Circuit_Chip_LPIC.get(2))
                .itemOutputs(ItemList.Transformer_IV_EV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // IV Transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 4),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.VanadiumGallium, 1),
                        ItemList.Circuit_Chip_PIC.get(2),
                        ItemList.Hull_IV.get(1))
                .itemOutputs(ItemList.Transformer_LuV_IV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // LuV transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.VanadiumGallium, 4),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Naquadah, 1),
                        ItemList.Circuit_Chip_HPIC.get(2),
                        ItemList.Hull_LuV.get(1))
                .itemOutputs(ItemList.Transformer_ZPM_LuV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // ZPM Transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Naquadah, 4),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.NaquadahAlloy, 1),
                        ItemList.Hull_ZPM.get(1),
                        ItemList.Circuit_Chip_UHPIC.get(2))
                .itemOutputs(ItemList.Transformer_UV_ZPM.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // UV Transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.NaquadahAlloy, 4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Bedrockium, 1),
                        ItemList.Hull_UV.get(1),
                        ItemList.Circuit_Chip_NPIC.get(2))
                .itemOutputs(ItemList.Transformer_MAX_UV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // UHV Transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorUHV, 4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Draconium, 1),
                        ItemList.Hull_MAX.get(1),
                        ItemList.Circuit_Chip_PPIC.get(2))
                .itemOutputs(ItemList.Transformer_UEV_UHV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // UEV Transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Draconium, 4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.NetherStar, 1),
                        ItemList.Hull_UEV.get(1),
                        ItemList.Circuit_Chip_QPIC.get(2))
                .itemOutputs(ItemList.Transformer_UIV_UEV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // UIV Transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.NetherStar, 4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Quantium, 1),
                        ItemList.Hull_UIV.get(1),
                        ItemList.Circuit_Chip_FPIC.get(2))
                .itemOutputs(ItemList.Transformer_UMV_UIV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // UMV Transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Quantium, 4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.BlackPlutonium, 1),
                        ItemList.Hull_UMV.get(1),
                        ItemList.Circuit_Chip_APIC.get(2))
                .itemOutputs(ItemList.Transformer_UXV_UMV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // UXV Transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.BlackPlutonium, 4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Infinity, 1),
                        ItemList.Hull_UXV.get(1),
                        ItemList.Circuit_Chip_ZPIC.get(2))
                .itemOutputs(ItemList.Transformer_MAX_UXV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 16A ULV Transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Lead, 4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Tin, 1),
                        ItemList.Transformer_LV_ULV.get(1))
                .itemOutputs(GregtechItemList.Transformer_HA_LV_ULV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 16A LV Transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Tin, 4),
                        new OreDictItemStack("wireGt04AnyCopper", 1),
                        ItemList.Transformer_MV_LV.get(1))
                .itemOutputs(GregtechItemList.Transformer_HA_MV_LV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 16A MV Transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new OreDictItemStack("wireGt04AnyCopper", 4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Gold, 1),
                        ItemList.Transformer_HV_MV.get(1))
                .itemOutputs(GregtechItemList.Transformer_HA_HV_MV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 16A HV Transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Gold, 4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Aluminium, 1),
                        ItemList.Transformer_EV_HV.get(1),
                        ItemList.Casing_Coil_Cupronickel.get(2))
                .itemOutputs(GregtechItemList.Transformer_HA_EV_HV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 16A EV Transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Aluminium, 4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Tungsten, 1),
                        ItemList.Transformer_IV_EV.get(1),
                        ItemList.Casing_Coil_Kanthal.get(2))
                .itemOutputs(GregtechItemList.Transformer_HA_IV_EV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 16A IV Transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Tungsten, 4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.VanadiumGallium, 1),
                        ItemList.Casing_Coil_Nichrome.get(2),
                        ItemList.Transformer_LuV_IV.get(1))
                .itemOutputs(GregtechItemList.Transformer_HA_LuV_IV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 16A LuV transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.VanadiumGallium, 4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Naquadah, 1),
                        ItemList.Transformer_ZPM_LuV.get(1),
                        ItemList.Casing_Coil_TungstenSteel.get(2))
                .itemOutputs(GregtechItemList.Transformer_HA_ZPM_LuV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 16A ZPM Transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Naquadah, 4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.NaquadahAlloy, 1),
                        ItemList.Transformer_UV_ZPM.get(1),
                        ItemList.Casing_Coil_HSSG.get(2))
                .itemOutputs(GregtechItemList.Transformer_HA_UV_ZPM.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 16A UV Transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.NaquadahAlloy, 4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Bedrockium, 1),
                        ItemList.Transformer_MAX_UV.get(1),
                        ItemList.Casing_Coil_HSSS.get(2))
                .itemOutputs(GregtechItemList.Transformer_HA_MAX_UV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 16A UHV Transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Bedrockium, 4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Draconium, 1),
                        ItemList.Transformer_UEV_UHV.get(1),
                        ItemList.Casing_Coil_Superconductor.get(2))
                .itemOutputs(ItemList.Transformer_HA_UEV_UHV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 16A UEV Transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Draconium, 4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.NetherStar, 1),
                        ItemList.Transformer_UIV_UEV.get(1),
                        ItemList.Casing_Fusion_Coil.get(2))
                .itemOutputs(ItemList.Transformer_HA_UIV_UEV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 16A UIV Transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.NetherStar, 4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Quantium, 1),
                        ItemList.Transformer_UMV_UIV.get(1),
                        ItemList.Casing_Fusion_Coil.get(3))
                .itemOutputs(ItemList.Transformer_HA_UMV_UIV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 16A UMV Transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Quantium, 4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.BlackPlutonium, 1),
                        ItemList.Transformer_UXV_UMV.get(1),
                        ItemList.Casing_Fusion_Coil.get(3))
                .itemOutputs(ItemList.Transformer_HA_UXV_UMV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 16A UXV Transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.BlackPlutonium, 4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Infinity, 1),
                        ItemList.Transformer_MAX_UXV.get(1),
                        ItemList.Casing_Coil_Infinity.get(3))
                .itemOutputs(ItemList.Transformer_HA_MAX_UXV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 64A ULV transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.Lead, 2),
                        GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.Tin, 1),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.spring, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Lead, Shapes.springSmall, (int) (1)),
                        GregtechItemList.Transformer_HA_LV_ULV.get(1),
                        ItemList.Electric_Pump_LV.get(1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Lubricant, FluidShapes.fluidLiquid, (int) (2000)))
                .itemOutputs(ItemList.WetTransformer_LV_ULV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 64A LV transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.Tin, 2),
                        new OreDictItemStack("cableGt08AnyCopper", 1),
                        new OreDictItemStack("springAnyCopper", 1),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.springSmall, (int) (1)),
                        GregtechItemList.Transformer_HA_MV_LV.get(1),
                        ItemList.Electric_Pump_LV.get(1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Lubricant, FluidShapes.fluidLiquid, (int) (2000)))
                .itemOutputs(ItemList.WetTransformer_MV_LV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 64A MV transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new OreDictItemStack("cableGt16AnyCopper", 2),
                        GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.Gold, 1),
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.spring, (int) (1)),
                        new OreDictItemStack("springSmallAnyCopper", 1),
                        GregtechItemList.Transformer_HA_HV_MV.get(1),
                        ItemList.Electric_Pump_LV.get(1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Lubricant, FluidShapes.fluidLiquid, (int) (2000)))
                .itemOutputs(ItemList.WetTransformer_HV_MV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 64A HV transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.Gold, 2),
                        GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.Aluminium, 1),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.spring, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.springSmall, (int) (1)),
                        GregtechItemList.Transformer_HA_EV_HV.get(1),
                        ItemList.Electric_Pump_LV.get(1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Lubricant, FluidShapes.fluidLiquid, (int) (2000)))
                .itemOutputs(ItemList.WetTransformer_EV_HV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 64A EV transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.Aluminium, 2),
                        GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.Tungsten, 1),
                        MaterialLibAPI.getStack(Materials.Tungsten, Shapes.spring, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.springSmall, (int) (1)),
                        GregtechItemList.Transformer_HA_IV_EV.get(1),
                        ItemList.Electric_Pump_LV.get(1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Lubricant, FluidShapes.fluidLiquid, (int) (2000)))
                .itemOutputs(ItemList.WetTransformer_IV_EV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 64A IV transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.Tungsten, 2),
                        GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.VanadiumGallium, 1),
                        MaterialLibAPI.getStack(Materials.VanadiumGallium, Shapes.spring, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Tungsten, Shapes.springSmall, (int) (1)),
                        GregtechItemList.Transformer_HA_LuV_IV.get(1),
                        ItemList.Electric_Pump_LV.get(1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Lubricant, FluidShapes.fluidLiquid, (int) (2000)))
                .itemOutputs(ItemList.WetTransformer_LuV_IV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 64A LuV transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.VanadiumGallium, 2),
                        GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.Naquadah, 1),
                        MaterialLibAPI.getStack(Materials.Naquadah, Shapes.spring, (int) (1)),
                        MaterialLibAPI.getStack(Materials.VanadiumGallium, Shapes.springSmall, (int) (1)),
                        GregtechItemList.Transformer_HA_ZPM_LuV.get(1),
                        ItemList.Electric_Pump_LV.get(1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Lubricant, FluidShapes.fluidLiquid, (int) (2000)))
                .itemOutputs(ItemList.WetTransformer_ZPM_LuV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 64A ZPM transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.Naquadah, 2),
                        GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.NaquadahAlloy, 1),
                        MaterialLibAPI.getStack(Materials.NaquadahAlloy, Shapes.spring, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Naquadah, Shapes.springSmall, (int) (1)),
                        GregtechItemList.Transformer_HA_UV_ZPM.get(1),
                        ItemList.Electric_Pump_LV.get(1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Lubricant, FluidShapes.fluidLiquid, (int) (2000)))
                .itemOutputs(ItemList.WetTransformer_UV_ZPM.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 64A UV transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt16, Materials.NaquadahAlloy, 2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.Bedrockium, 1),
                        MaterialLibAPI.getStack(Materials.Neutronium, Shapes.spring, (int) (1)),
                        MaterialLibAPI.getStack(Materials.NaquadahAlloy, Shapes.springSmall, (int) (1)),
                        GregtechItemList.Transformer_HA_MAX_UV.get(1),
                        ItemList.Electric_Pump_LV.get(1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Lubricant, FluidShapes.fluidLiquid, (int) (2000)))
                .itemOutputs(ItemList.WetTransformer_UHV_UV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 64A UHV transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUHV, 2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.Draconium, 1),
                        MaterialLibAPI.getStack(Materials.Draconium, Shapes.spring, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Neutronium, Shapes.springSmall, (int) (1)),
                        ItemList.Transformer_HA_UEV_UHV.get(1),
                        ItemList.Electric_Pump_MV.get(1),
                        ItemList.Reactor_Coolant_He_1.get(2))
                .itemOutputs(ItemList.WetTransformer_UEV_UHV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 64A UEV transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.Draconium, 2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.NetherStar, 1),
                        MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.spring, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Draconium, Shapes.springSmall, (int) (1)),
                        ItemList.Transformer_HA_UIV_UEV.get(1),
                        ItemList.Electric_Pump_HV.get(1),
                        ItemList.Reactor_Coolant_He_3.get(2))
                .itemOutputs(ItemList.WetTransformer_UIV_UEV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 64A UIV transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.NetherStar, 2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.Quantium, 1),
                        MaterialLibAPI.getStack(Materials.Quantium, Shapes.spring, (int) (1)),
                        MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.springSmall, (int) (1)),
                        ItemList.Transformer_HA_UMV_UIV.get(1),
                        ItemList.Electric_Pump_IV.get(1),
                        ItemList.Reactor_Coolant_He_6.get(2))
                .itemOutputs(ItemList.WetTransformer_UMV_UIV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 64A UMV transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.Quantium, 2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.BlackPlutonium, 1),
                        MaterialLibAPI.getStack(Materials.Infinity, Shapes.spring, (int) (1)),
                        MaterialLibAPI.getStack(Materials.SpaceTime, Shapes.springSmall, (int) (1)),
                        ItemList.Transformer_HA_UXV_UMV.get(1),
                        ItemList.Electric_Pump_LuV.get(1),
                        ItemList.Reactor_Coolant_Sp_1.get(2))
                .itemOutputs(ItemList.WetTransformer_UXV_UMV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // 64A UXV transformer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.BlackPlutonium, 2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.Infinity, 1),
                        MaterialLibAPI.getStack(Materials.SpaceTime, Shapes.spring, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Universium, Shapes.springSmall, (int) (1)),
                        ItemList.Transformer_HA_MAX_UXV.get(1),
                        ItemList.Electric_Pump_ZPM.get(1),
                        ItemList.Reactor_Coolant_Sp_2.get(2))
                .itemOutputs(ItemList.WetTransformer_MAX_UXV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // Tesla Coil
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.Gold, 1),
                        Circuits.HV.get(2),
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 5, 0),
                        ItemList.Transformer_HV_MV.get(1))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // Super Tank I
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(Circuits.LV.getIngredient(), 4),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (2)),
                        ItemList.Electric_Pump_MV.get(1),
                        MaterialLibAPI.getStack(Materials.PulsatingIron, Shapes.plate, (int) (1)),
                        ItemList.Casing_Tank_1.get(1))
                .itemOutputs(ItemList.Super_Tank_LV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Super Tank II
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(Circuits.MV.getIngredient(), 4),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (2)),
                        ItemList.Electric_Pump_HV.get(1),
                        MaterialLibAPI.getStack(Materials.EnergeticAlloy, Shapes.plate, (int) (1)),
                        ItemList.Casing_Tank_2.get(1))
                .itemOutputs(ItemList.Super_Tank_MV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Super Tank III
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(Circuits.HV.getIngredient(), 4),
                        MaterialLibAPI.getStack(Materials.VibrantAlloy, Shapes.plate, (int) (2)),
                        ItemList.Electric_Pump_HV.get(1),
                        ItemList.Field_Generator_LV.get(1),
                        ItemList.Casing_Tank_3.get(1))
                .itemOutputs(ItemList.Super_Tank_HV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Super Tank IV
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(Circuits.EV.getIngredient(), 4),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (2)),
                        ItemList.Electric_Pump_EV.get(1),
                        ItemList.Field_Generator_MV.get(1),
                        ItemList.Casing_Tank_4.get(1))
                .itemOutputs(ItemList.Super_Tank_EV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Super Tank V
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(Circuits.IV.getIngredient(), 4),
                        MaterialLibAPI.getStack(Materials.NiobiumTitanium, Shapes.plate, (int) (2)),
                        ItemList.Electric_Pump_EV.get(1),
                        ItemList.Field_Generator_HV.get(1),
                        ItemList.Casing_Tank_5.get(1))
                .itemOutputs(ItemList.Super_Tank_IV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // Quantum Tank I
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(Circuits.LuV.getIngredient(), 4),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (2)),
                        ItemList.Electric_Pump_IV.get(1),
                        ItemList.Field_Generator_EV.get(1),
                        ItemList.Casing_Tank_6.get(1))
                .itemOutputs(ItemList.Quantum_Tank_LV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Quantum Tank II
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(Circuits.ZPM.getIngredient(), 4),
                        MaterialLibAPI.getStack(Materials.HSSG, Shapes.plate, (int) (2)),
                        ItemList.Electric_Pump_IV.get(1),
                        ItemList.Field_Generator_IV.get(1),
                        ItemList.Casing_Tank_7.get(1))
                .itemOutputs(ItemList.Quantum_Tank_MV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Quantum Tank III
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(Circuits.UV.getIngredient(), 4),
                        MaterialLibAPI.getStack(Materials.HSSS, Shapes.plate, (int) (2)),
                        ItemList.Electric_Pump_LuV.get(1),
                        ItemList.Field_Generator_LuV.get(1),
                        ItemList.Casing_Tank_8.get(1))
                .itemOutputs(ItemList.Quantum_Tank_HV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Quantum Tank IV
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(Circuits.UHV.getIngredient(), 4),
                        MaterialLibAPI.getStack(Materials.Europium, Shapes.plate, (int) (2)),
                        ItemList.Electric_Pump_ZPM.get(1),
                        ItemList.Field_Generator_ZPM.get(1),
                        ItemList.Casing_Tank_9.get(1))
                .itemOutputs(ItemList.Quantum_Tank_EV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Quantum Tank V
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(Circuits.UEV.getIngredient(), 4),
                        MaterialLibAPI.getStack(Materials.Americium, Shapes.plate, (int) (2)),
                        ItemList.Electric_Pump_UV.get(1),
                        ItemList.Field_Generator_UV.get(1),
                        ItemList.Casing_Tank_10.get(1))
                .itemOutputs(ItemList.Quantum_Tank_IV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // Super Chest I
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(Circuits.LV.getIngredient(), 4),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (3)),
                        MaterialLibAPI.getStack(Materials.PulsatingIron, Shapes.plate, (int) (1)),
                        ItemList.Automation_ChestBuffer_LV.get(1))
                .itemOutputs(ItemList.Super_Chest_LV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Super Chest II
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(Circuits.MV.getIngredient(), 4),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (3)),
                        MaterialLibAPI.getStack(Materials.EnergeticAlloy, Shapes.plate, (int) (1)),
                        ItemList.Automation_ChestBuffer_MV.get(1))
                .itemOutputs(ItemList.Super_Chest_MV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Super Chest III
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(Circuits.HV.getIngredient(), 4),
                        MaterialLibAPI.getStack(Materials.VibrantAlloy, Shapes.plate, (int) (3)),
                        ItemList.Field_Generator_LV.get(1),
                        ItemList.Automation_ChestBuffer_HV.get(1))
                .itemOutputs(ItemList.Super_Chest_HV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Super Chest IV
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(Circuits.EV.getIngredient(), 4),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (3)),
                        ItemList.Field_Generator_MV.get(1),
                        ItemList.Automation_ChestBuffer_EV.get(1))
                .itemOutputs(ItemList.Super_Chest_EV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Super Chest V
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(Circuits.IV.getIngredient(), 4),
                        MaterialLibAPI.getStack(Materials.NiobiumTitanium, Shapes.plate, (int) (3)),
                        ItemList.Field_Generator_HV.get(1),
                        ItemList.Automation_ChestBuffer_IV.get(1))
                .itemOutputs(ItemList.Super_Chest_IV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // Quantum Chest I
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(Circuits.LuV.getIngredient(), 4),
                        GTOreDictUnificator
                                .get(MaterialParts.craftIngredient(OrePrefixes.plate, Materials.TungstenSteel), 3),
                        ItemList.Field_Generator_EV.get(1),
                        ItemList.Automation_ChestBuffer_LuV.get(1L))
                .itemOutputs(ItemList.Quantum_Chest_LV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Quantum Chest II
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(Circuits.ZPM.getIngredient(), 4),
                        GTOreDictUnificator.get(MaterialParts.craftIngredient(OrePrefixes.plate, Materials.HSSG), 3),
                        ItemList.Field_Generator_IV.get(1),
                        ItemList.Automation_ChestBuffer_ZPM.get(1L))
                .itemOutputs(ItemList.Quantum_Chest_MV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Quantum Chest III
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(Circuits.UV.getIngredient(), 4),
                        GTOreDictUnificator.get(MaterialParts.craftIngredient(OrePrefixes.plate, Materials.HSSS), 3),
                        ItemList.Field_Generator_LuV.get(1),
                        ItemList.Automation_ChestBuffer_UV.get(1L))
                .itemOutputs(ItemList.Quantum_Chest_HV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Quantum Chest IV
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(Circuits.UHV.getIngredient(), 4),
                        GTOreDictUnificator
                                .get(MaterialParts.craftIngredient(OrePrefixes.plate, Materials.Europium), 3),
                        ItemList.Field_Generator_ZPM.get(1),
                        ItemList.Automation_ChestBuffer_UHV.get(1L))
                .itemOutputs(ItemList.Quantum_Chest_EV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Quantum Chest V
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(Circuits.UEV.getIngredient(), 4),
                        GTOreDictUnificator
                                .get(MaterialParts.craftIngredient(OrePrefixes.plate, Materials.Americium), 3),
                        ItemList.Field_Generator_UV.get(1),
                        ItemList.Automation_ChestBuffer_UEV.get(1L))
                .itemOutputs(ItemList.Quantum_Chest_IV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // Chest Buffer IV
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Conveyor_Module_IV.get(1),
                        GTOreDictUnificator.get(Circuits.IV.getIngredient(), 1),
                        ItemList.Hull_IV.get(1),
                        GTOreDictUnificator.get(OrePrefixes.chest, Materials.Wood, 1))
                .itemOutputs(ItemList.Automation_ChestBuffer_IV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        // Ultra High Voltage Chest Buffer
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Conveyor_Module_UEV.get(1),
                        GTOreDictUnificator.get(Circuits.UEV.getIngredient(), 1),
                        ItemList.Hull_UEV.get(1),
                        GTOreDictUnificator.get(OrePrefixes.chest, Materials.Wood, 1))
                .itemOutputs(ItemList.Automation_ChestBuffer_UEV.get(1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        // EV Compressor
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Piston_EV.get(2),
                        Circuits.EV.get(2),
                        ItemList.Hull_EV.get(1),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 4))
                .itemOutputs(ItemList.Machine_EV_Compressor.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        // UV Compressor
        GTValues.RA.stdBuilder().itemInputs(
                ItemList.Hull_UV.get(1),
                // UV circuit, but internal naming is SuperconductorUHV?
                Circuits.UV.get(2),
                ItemList.Electric_Piston_UV.get(2),
                GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.ElectrumFlux, 4))
                .itemOutputs(ItemList.CompressorUV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_UV)
                .addTo(assemblerRecipes);

        // UIV Compressor
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Piston_UIV.get(2),
                        Circuits.UIV.get(2),
                        ItemList.Hull_UIV.get(1),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.NetherStar, 4))
                .itemOutputs(ItemList.CompressorUIV.get(1)).duration(1 * SECONDS).eut(TierEU.RECIPE_UIV)
                .addTo(assemblerRecipes);

        // Industrial Compressor
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Machine_EV_Compressor.get(1),
                        Circuits.IV.get(2),
                        ItemList.Electric_Piston_EV.get(2),
                        MaterialLibAPI.getStack(Materials.Incoloy903, Shapes.plate, (int) (4)))
                .itemOutputs(ItemList.Machine_Multi_IndustrialCompressor.get(1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        // Implosion Compressor
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_SolidSteel.get(1L),
                        ItemList.Block_ReinforcedConcrete.get(3L),
                        Circuits.HV.get(3),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2))
                .itemOutputs(ItemList.Machine_Multi_ImplosionCompressor.get(1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // Advanced Implosion Compressor
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Grisium, Shapes.gearGt, (int) (2)),
                        ItemList.Hull_IV.get(1),
                        GTOreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Iridium, 2L),
                        GregtechItemList.Gregtech_Computer_Cube.get(1),
                        Circuits.IV.get(1),
                        ItemList.Robot_Arm_IV.get(1),
                        ItemList.Field_Generator_IV.get(1))
                .itemOutputs(ItemList.AdvancedImplosionCompressor.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);

        // UV Microwave Transmitter
        GTValues.RA.stdBuilder().itemInputs(
                ItemList.Hull_UV.get(1),
                // UV circuit, but internal naming is SuperconductorUHV?
                Circuits.UV.get(2),
                ItemList.Emitter_UV.get(4),
                ItemList.Field_Generator_UV.get(1),
                ItemList.Energy_Module.get(1)).itemOutputs(ItemList.MicroTransmitter_UV.get(1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(assemblerRecipes);

        // Industrial Tinted Glass
        ItemStack[] dyes = new ItemStack[] { ItemList.Color_15.get(1), // white
                ItemList.Color_07.get(1), // light gray
                ItemList.Color_08.get(1), // gray
                ItemList.Color_00.get(1) // black
        };

        ItemStack[] glasses = new ItemStack[] { ItemList.GlassTintedIndustrialWhite.get(1),
                ItemList.GlassTintedIndustrialLightGray.get(1), ItemList.GlassTintedIndustrialGray.get(1),
                ItemList.GlassTintedIndustrialBlack.get(1), };

        for (int meta = 0; meta < 4; ++meta) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1),
                            new ItemStack(Blocks.glass, 4),
                            dyes[meta])
                    .itemOutputs(glasses[meta]).eut(TierEU.RECIPE_LV).duration(10 * SECONDS).addTo(assemblerRecipes);
        }

        // Chemical grade glass
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1),
                        new ItemStack(Blocks.glass))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.Polytetrafluoroethylene,
                                FluidShapes.fluidMolten,
                                (int) (4 * 144)))
                .itemOutputs(ItemList.GlassPHResistant.get(1)).eut(TierEU.RECIPE_EV).duration(10 * SECONDS)
                .addTo(assemblerRecipes);

        // Ultraviolet emitter casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Neutronium, 1),
                        ItemList.Emitter_UV.get(1),
                        MaterialLibAPI.getStack(Materials.Naquadria, Shapes.plate, (int) (4)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Titanium, FluidShapes.fluidPlasma, (int) (4 * 144)))
                .itemOutputs(ItemList.BlockUltraVioletLaserEmitter.get(1)).eut(TierEU.RECIPE_UV).duration(10 * SECONDS)
                .addTo(assemblerRecipes);

        // Sterile Water Plant Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 1),
                        MaterialLibAPI.getStack(Materials.Ledox, Shapes.plate, (int) (4)),
                        ItemList.Electric_Motor_IV.get(2),
                        MaterialLibAPI.getStack(Materials.PolyvinylChloride, Shapes.foil, (int) (4)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Ledox, FluidShapes.fluidMolten, (int) (4 * 144)))
                .itemOutputs(ItemList.BlockIndustrialWaterPlantCasing.get(1)).eut(TierEU.RECIPE_EV)
                .duration(10 * SECONDS).addTo(assemblerRecipes);

        // Reinforced Sterile Water Plant Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.BlockIndustrialWaterPlantCasing.get(1),
                        MaterialLibAPI.getStack(Materials.Ruridit, Shapes.bolt, (int) (16)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Concrete, FluidShapes.fluidMolten, (int) (8 * 144)))
                .itemOutputs(ItemList.BlockSterileWaterPlantCasing.get(1)).eut(TierEU.RECIPE_IV).duration(10 * SECONDS)
                .addTo(assemblerRecipes);

        // Stabilized Naquadah Water Plant Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.NaquadahAlloy, 1),
                        MaterialLibAPI.getStack(Materials.Naquadah, Shapes.plate, (int) (6)),
                        GTOreDictUnificator.get(OrePrefixes.pipeSmall, Materials.NiobiumTitanium, 4))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.SuperCoolant, FluidShapes.fluidLiquid, (int) (4000)))
                .itemOutputs(ItemList.BlockNaquadahReinforcedWaterPlantCasing.get(1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);

        // Inert Neutralization Water Plant Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.HastelloyC276, 1),
                        MaterialLibAPI.getStack(Materials.HastelloyC276, Shapes.plate, (int) (3)),
                        MaterialLibAPI.getStack(Materials.HastelloyX, Shapes.plate, (int) (3)),
                        ItemList.Electric_Pump_LuV.get(1))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.Polytetrafluoroethylene,
                                FluidShapes.fluidMolten,
                                (int) (4 * 144)))
                .itemOutputs(ItemList.BlockExtremeCorrosionResistantCasing.get(1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);

        // Naquadria Reinforced Water Plant Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.BlockNaquadahReinforcedWaterPlantCasing.get(1),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Naquadria, 1),
                        MaterialLibAPI.getStack(Materials.Naquadria, Shapes.foil, (int) (8)),
                        ItemList.Electric_Pump_ZPM.get(1))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.SuperCoolant, FluidShapes.fluidLiquid, (int) (8000)))
                .itemOutputs(ItemList.BlockNaquadriaReinforcedWaterPlantCasing.get(1)).eut(TierEU.RECIPE_ZPM)
                .duration(10 * SECONDS).addTo(assemblerRecipes);

        // Inert Filtration Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.HastelloyC276, 1),
                        MaterialLibAPI.getStack(Materials.HastelloyX, Shapes.plate, (int) (6)),
                        MaterialLibAPI.getStack(Materials.HastelloyC276, Shapes.rotor, (int) (2)),
                        MaterialLibAPI.getStack(Materials.HastelloyC276, Shapes.gearGt, (int) (2)),
                        ItemList.Electric_Pump_IV.get(1))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.Polytetrafluoroethylene,
                                FluidShapes.fluidMolten,
                                (int) (4 * 144)))
                .itemOutputs(ItemList.BlockOzoneCasing.get(1)).eut(TierEU.RECIPE_IV).duration(10 * SECONDS)
                .addTo(assemblerRecipes);

        // Reactive gas containment casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.HastelloyW, 1),
                        MaterialLibAPI.getStack(Materials.HastelloyW, Shapes.plate, (int) (6)),
                        MaterialLibAPI.getStack(Materials.HastelloyW, Shapes.rotor, (int) (1)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.Polytetrafluoroethylene,
                                FluidShapes.fluidMolten,
                                (int) (4 * 144)))
                .itemOutputs(ItemList.BlockHighPressureResistantCasing.get(1)).eut(TierEU.RECIPE_IV)
                .duration(10 * SECONDS).addTo(assemblerRecipes);

        // slick sterile flocculation casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 1),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plateDouble, (int) (6)),
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.TungstenSteel, 4),
                        ItemList.Electric_Pump_IV.get(1))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.Polytetrafluoroethylene,
                                FluidShapes.fluidMolten,
                                (int) (4 * 144)))
                .itemOutputs(ItemList.BlockFlocculationCasing.get(1)).eut(TierEU.RECIPE_LuV).duration(10 * SECONDS)
                .addTo(assemblerRecipes);

        // Trinium plated heat-resistant casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Neutronium, 1),
                        MaterialLibAPI.getStack(Materials.Trinium, Shapes.plate, (int) (6)),
                        MaterialLibAPI.getStack(Materials.Netherite, Shapes.screw, (int) (16)),
                        ItemList.UV_Coil.get(2))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.Osmiridium, FluidShapes.fluidMolten, (int) (4 * 144)))
                .itemOutputs(ItemList.BlockPlasmaHeatingCasing.get(1)).eut(TierEU.RECIPE_ZPM).duration(10 * SECONDS)
                .addTo(assemblerRecipes);

        // Ph sensor hatch
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_LuV.get(1),
                        ItemList.Cover_ActivityDetector.get(1),
                        ItemList.Cover_Screen.get(1),
                        MaterialLibAPI.getStack(Materials.NaquadahAlloy, Shapes.plate, (int) (4)),
                        Circuits.LuV.get(1),
                        ItemList.Sensor_LuV.get(1),
                        ItemList.Emitter_LuV.get(1))
                .circuit(1)
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.SolderingAlloy, FluidShapes.fluidMolten, (int) (8 * 144)))
                .itemOutputs(ItemList.Hatch_pHSensor.get(1)).eut(TierEU.RECIPE_LuV).duration(10 * SECONDS)
                .addTo(assemblerRecipes);

        // Lens housing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hatch_Input_Bus_UV.get(1),
                        MaterialLibAPI.getStack(Materials.Neutronium, Shapes.ring, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Draconium, Shapes.plate, (int) (4)),
                        Circuits.UV.get(1))
                .circuit(1)
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.SolderingAlloy, FluidShapes.fluidMolten, (int) (8 * 144)))
                .itemOutputs(ItemList.Hatch_LensHousing.get(1)).eut(TierEU.RECIPE_ZPM).duration(10 * SECONDS)
                .addTo(assemblerRecipes);

        // lens indicator hatch
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_UV.get(1),
                        ItemList.Cover_ActivityDetector.get(1),
                        ItemList.Cover_Screen.get(1),
                        MaterialLibAPI.getStack(Materials.Neutronium, Shapes.plate, (int) (4)),
                        Circuits.UV.get(1),
                        ItemList.Sensor_UV.get(1),
                        ItemList.Emitter_UV.get(1))
                .circuit(1)
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.SolderingAlloy, FluidShapes.fluidMolten, (int) (8 * 144)))
                .itemOutputs(ItemList.Hatch_LensIndicator.get(1)).eut(TierEU.RECIPE_ZPM).duration(10 * SECONDS)
                .addTo(assemblerRecipes);

        // degasser control hatch
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_UV.get(1),
                        ItemList.Cover_ActivityDetector.get(1),
                        ItemList.Cover_Screen.get(1),
                        MaterialLibAPI.getStack(Materials.Infinity, Shapes.plate, (int) (4)),
                        Circuits.UHV.get(1),
                        ItemList.Sensor_UHV.get(1),
                        ItemList.Emitter_UHV.get(1))
                .circuit(1)
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.SolderingAlloy, FluidShapes.fluidMolten, (int) (8 * 144)))
                .itemOutputs(ItemList.Hatch_DegasifierControl.get(1)).eut(TierEU.RECIPE_UHV).duration(10 * SECONDS)
                .addTo(assemblerRecipes);

        // Spinmatron Centrifuge Casings
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GregtechItemList.Casing_Centrifuge1.get(1),
                        MaterialLibAPI.getStack(Materials.HighDurabilityCompoundSteel, Shapes.plate, (int) (6)))
                .itemOutputs(ItemList.Spinmatron_Casing.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LuV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GregtechItemList.Casing_SifterGrate.get(1),
                        MaterialLibAPI.getStack(Materials.NaquadahEnriched, Shapes.stick, (int) (6)))
                .itemOutputs(ItemList.Spinmatron_Chamber_Grate.get(1)).duration(10 * SECONDS).eut(TierEU.RECIPE_LuV)
                .addTo(assemblerRecipes);

        // Mixer Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Polytetrafluoroethylene, 1),
                        MaterialLibAPI.getStack(Materials.MaragingSteel300, Shapes.plate, (int) (4)),
                        MaterialLibAPI.getStack(Materials.MaragingSteel250, Shapes.plate, (int) (2)))
                .circuit(1).itemOutputs(ItemList.CasingMixer.get(1)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        if (HardcoreEnderExpansion.isModLoaded()) {
            // Biome Compass
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.HeeEndium, Shapes.plate, (int) (1)),
                            MaterialLibAPI.getStack(Materials.HeeEndium, Shapes.bolt, (int) (1)),
                            MaterialLibAPI.getStack(Materials.HeeEndium, Shapes.screw, (int) (2)),
                            MaterialLibAPI.getStack(Materials.HeeEndium, Shapes.ring, (int) (2)),
                            MaterialLibAPI.getStack(Materials.RedAlloy, Shapes.bolt, (int) (1)),
                            getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0))
                    .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "biome_compass", 1, 0)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        }
        if (StorageDrawers.isModLoaded()) {
            // Alternate Storage Template Recipe
            GTValues.RA.stdBuilder()
                    .itemInputs(ItemList.Electric_Piston_LV.get(1), new OreDictItemStack("drawerBasic", 1)).circuit(2)
                    .itemOutputs(getModItem(StorageDrawers.ID, "upgradeTemplate", 3, 0)).duration(60 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        }
        // Display
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Cover_Screen.get(1),
                        Circuits.LV.get(2),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.screw, (int) (2)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (144)))
                .itemOutputs(NHItemList.Display.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // Ender-Quantum Component
        if (SuperSolarPanels.isModLoaded() && (AdvancedSolarPanel.isModLoaded())) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.InfinityCatalyst, Shapes.plateDense, (int) (1)),
                            getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 4, 3),
                            MaterialLibAPI.getStack(Materials.ElectrumFlux, Shapes.plate, (int) (4)))
                    .itemOutputs(getModItem(SuperSolarPanels.ID, "enderquantumcomponent", 1, 0)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        }

        if (Botania.isModLoaded()) {

            // Hand of Ender

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "enderEyeBlock", 1, 0),
                            getModItem(Witchery.ID, "witchhand", 1, 0),
                            getModItem(Botania.ID, "manaResource", 5, 22),
                            getModItem(Botania.ID, "manaBeacon", 1, 5),
                            new ItemStack(Blocks.ender_chest, 1),
                            MaterialLibAPI.getStack(Materials.Obsidian, Shapes.plate, (int) (2L)))
                    .circuit(1).itemOutputs(getModItem(Botania.ID, "enderHand", 1, 0))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(Materials.Terrasteel, FluidShapes.fluidMolten, (int) (1296)))
                    .duration(12 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

            // Botania seeds grass

            GTValues.RA.stdBuilder()
                    .itemInputs(new ItemStack(Blocks.grass, 16), getModItem(Botania.ID, "grassSeeds", 1, 3)).circuit(1)
                    .itemOutputs(getModItem(Botania.ID, "altGrass", 16, 0)).duration(5 * SECONDS).eut(24)
                    .addTo(assemblerRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(new ItemStack(Blocks.grass, 16), getModItem(Botania.ID, "grassSeeds", 1, 4)).circuit(1)
                    .itemOutputs(getModItem(Botania.ID, "altGrass", 16, 1)).duration(5 * SECONDS).eut(24)
                    .addTo(assemblerRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(new ItemStack(Blocks.grass, 16), getModItem(Botania.ID, "grassSeeds", 1, 5)).circuit(1)
                    .itemOutputs(getModItem(Botania.ID, "altGrass", 16, 2)).duration(5 * SECONDS).eut(24)
                    .addTo(assemblerRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(new ItemStack(Blocks.grass, 16), getModItem(Botania.ID, "grassSeeds", 1, 6)).circuit(1)
                    .itemOutputs(getModItem(Botania.ID, "altGrass", 16, 3)).duration(5 * SECONDS).eut(24)
                    .addTo(assemblerRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(new ItemStack(Blocks.grass, 16), getModItem(Botania.ID, "grassSeeds", 1, 7)).circuit(1)
                    .itemOutputs(getModItem(Botania.ID, "altGrass", 16, 4)).duration(5 * SECONDS).eut(24)
                    .addTo(assemblerRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(new ItemStack(Blocks.grass, 16), getModItem(Botania.ID, "grassSeeds", 1, 8)).circuit(1)
                    .itemOutputs(getModItem(Botania.ID, "altGrass", 16, 5)).duration(5 * SECONDS).eut(24)
                    .addTo(assemblerRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "altGrass", 2, 0),
                            getModItem(Botania.ID, "altGrass", 2, 1),
                            getModItem(Botania.ID, "altGrass", 2, 2),
                            getModItem(Botania.ID, "altGrass", 2, 3),
                            getModItem(Botania.ID, "altGrass", 2, 4),
                            getModItem(Botania.ID, "altGrass", 2, 5),
                            getModItem(Botania.ID, "overgrowthSeed", 1, 0),
                            getModItem(Botania.ID, "worldSeed", 1, 0))
                    .circuit(10).itemOutputs(getModItem(Botania.ID, "enchantedSoil", 12, 0)).duration(50 * SECONDS)
                    .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Items.wheat, 16),
                            new ItemStack(Items.wheat_seeds, 1),
                            getModItem(Botania.ID, "fertilizer", 1, 0))
                    .circuit(10).itemOutputs(new ItemStack(Blocks.tallgrass, 16, 1)).duration(5 * SECONDS).eut(24)
                    .addTo(assemblerRecipes);
        }

        // Hastelloy-X Structural Block
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_EV.get(1L),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, (int) (2)),
                        MaterialLibAPI.getStack(Materials.HastelloyX, Shapes.gearGt, (int) (1)),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.HastelloyC276, 1),
                        MaterialLibAPI.getStack(Materials.Inconel792, Shapes.ring, (int) (2)))
                .itemOutputs(GregtechItemList.Casing_Refinery_Structural.get(2)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        // MagTech Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (6L)),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 1L))
                .itemOutputs(ItemList.Casing_Electromagnetic_Separator.get(1)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        // Neutronium Stabilization Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_MAX.get(1),
                        ItemList.Field_Generator_ZPM.get(1),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.NaquadahAlloy, 4),
                        MaterialLibAPI.getStack(Materials.NaquadahAlloy, Shapes.screw, (int) (24)))
                .circuit(16).itemOutputs(ItemList.Neutronium_Stable_Casing.get(4)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(assemblerRecipes);

        // Background Radiation Absorbent Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_RadiationProof.get(1),
                        new ItemStack(advancedRadiationProtectionPlate, 8),
                        MaterialLibAPI.getStack(Materials.prismaticnaquadah, Shapes.plateSuperdense, (int) (1)))
                .circuit(16).fluidInputs(MaterialUtils.fluid(Materials.UUMatter, 64000L))
                .itemOutputs(ItemList.Background_Radiation_Casing.get(1)).duration(10).eut(TierEU.RECIPE_UIV)
                .addTo(assemblerRecipes);

        // Extreme Density Space-Bending Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        BlockList.NeutroniumPlatedReinforcedStone.get(),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plateSuperdense, (int) (64)),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.plateSuperdense, (int) (64)),
                        MaterialLibAPI.getStack(Materials.Bedrockium, Shapes.plateSuperdense, (int) (64)))
                .circuit(16).fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 16000))
                .itemOutputs(ItemList.Extreme_Density_Casing.get(1)).duration(5).eut(TierEU.RECIPE_UHV)
                .addTo(assemblerRecipes);

        // Laser Containment Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Stellite, Shapes.plate, (int) (6)),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Nitinol60, 1))
                .itemOutputs(ItemList.Casing_Laser.get(1)).duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV / 2)
                .addTo(assemblerRecipes);

        // Solidifier Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Inconel792, Shapes.plate, (int) (4)),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.WatertightSteel, 1),
                        MaterialLibAPI.getStack(Materials.Talonite, Shapes.plate, (int) (2)))
                .itemOutputs(ItemList.Casing_Fluid_Solidifier.get(1)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        // Solidifier Radiator Casing
        GTValues.RA.stdBuilder().itemInputs(ItemList.Casing_Fluid_Solidifier.get(1), ItemList.Electric_Pump_IV.get(1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Grisium, FluidShapes.fluidMolten, (int) (1008)))
                .itemOutputs(ItemList.Radiator_Fluid_Solidifier.get(2)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        // Electric Compressor Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Incoloy903, Shapes.plate, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, (int) (2)),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 1))
                .itemOutputs(ItemList.Compressor_Casing.get(1)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        // Compression Pipe Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Incoloy903, Shapes.plate, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.gearGt, (int) (1)),
                        GTOreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Incoloy903, 4))
                .itemOutputs(ItemList.Compressor_Pipe_Casing.get(1)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        // Heating Duct Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_Pipe_Bronze.get(1),
                        ItemList.Electric_Pump_LuV.get(2),
                        MaterialLibAPI.getStack(Materials.Invar, Shapes.plateDense, (int) (8)),
                        NHItemList.MicaInsulatorFoil.get(64),
                        NHItemList.MicaInsulatorFoil.get(64),
                        NHItemList.MicaInsulatorFoil.get(64),
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.TriniumNaquadahCarbonite, 2),
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.HastelloyX, 2),
                        TieredItems.ZPM.getPipeMedium(2))
                .fluidInputs(FluidRegistry.getFluidStack("pyrotheum", 16000))
                .itemOutputs(ItemList.Heating_Duct_Casing.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LuV)
                .addTo(assemblerRecipes);

        // Coolant Duct Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_Pipe_TungstenSteel.get(1),
                        ItemList.Electric_Pump_LuV.get(2),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plateDense, (int) (8)),
                        ItemList.Reactor_Coolant_Sp_3.get(1),
                        ItemList.Reactor_Coolant_Sp_3.get(1),
                        ItemList.Reactor_Coolant_Sp_3.get(1),
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.TriniumNaquadahCarbonite, 2),
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.HastelloyX, 2),
                        TieredItems.ZPM.getPipeMedium(2))
                .fluidInputs(FluidRegistry.getFluidStack("cryotheum", 16000))
                .itemOutputs(ItemList.Coolant_Duct_Casing.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LuV)
                .addTo(assemblerRecipes);

        // Heat Sensor Hatch
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_ZPM.get(1),
                        ItemList.Compressor_Casing.get(1),
                        ItemList.Sensor_ZPM.get(2),
                        Circuits.UV.get(4))
                .circuit(4)
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.Indalloy140, FluidShapes.fluidMolten, (int) (16000)))
                .itemOutputs(ItemList.Hatch_HeatSensor.get(1)).duration(30 * SECONDS).eut(TierEU.RECIPE_LuV)
                .addTo(assemblerRecipes);

        // Black Hole Utility Hatch
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_UIV.get(1),
                        getModItem(Avaritia.ID, "Singularity", 1, 3),
                        ItemList.Sensor_UIV.get(2),
                        MaterialLibAPI.getStack(Materials.RedstoneAlloy, Shapes.plateSuperdense, (int) (16)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.dimensionallyshiftedsuperfluid,
                                FluidShapes.fluidLiquid,
                                (int) (16000)))
                .itemOutputs(ItemList.Hatch_BlackHoleUtility.get(1)).duration(15 * SECONDS).eut(TierEU.RECIPE_UIV)
                .addTo(assemblerRecipes);

        // Reinforced Wooden Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.WoodSealed, Shapes.plate, (int) (6)),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 1))
                .itemOutputs(ItemList.Casing_Reinforced_Wood.get(1)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        // Iron Electromagnet
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.IronMagnetic, Shapes.ring, (int) (8L)),
                        ItemList.IV_Coil.get(8L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorIV, 16))
                .itemOutputs(ItemList.Electromagnet_Iron.get(1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Cobalt, FluidShapes.fluidMolten, (int) (1152)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        // Ultimate Time Anomaly
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_UV.get(2),
                        ItemList.Electric_Pump_UV.get(1),
                        ItemList.Conveyor_Module_UV.get(1),
                        ItemList.Robot_Arm_UV.get(2),
                        ItemList.Electric_Piston_UV.get(2),
                        ItemList.Hull_UV.get(1))
                .itemOutputs(ItemList.AcceleratorUV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        // LSC controller
        GTValues.RA.stdBuilder()
                .itemInputs(
                        TieredItems.EV.getBattery(4),
                        Circuits.LuV.get(2),
                        ItemList.Circuit_Chip_PIC.get(2),
                        new ItemStack(kekztech.common.Blocks.lscLapotronicEnergyUnit, 1, 0))
                .itemOutputs(TileEntities.lsc.getStackForm(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeQuadruple, Materials.SpaceTime, 1),
                        ItemList.Hull_UMV.get(1))
                .circuit(4)
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.Polybenzimidazole, FluidShapes.fluidMolten, (int) (2304)))
                .itemOutputs(ItemList.Hatch_Input_Multi_2x2_UMV.get(1)).duration(30 * SECONDS).eut(TierEU.RECIPE_UMV)
                .addTo(assemblerRecipes);
        // Spacetime quadruple is temp replacement until Universium Pipes.
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeQuadruple, Materials.SpaceTime, 4),
                        ItemList.Hull_UXV.get(1))
                .circuit(4)
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.Polybenzimidazole, FluidShapes.fluidMolten, (int) (2304)))
                .itemOutputs(ItemList.Hatch_Input_Multi_2x2_UXV.get(1)).duration(30 * SECONDS).eut(TierEU.RECIPE_UXV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemRegistry.humongousInputHatch.copy(),
                        GTOreDictUnificator.get(OrePrefixes.pipeHuge, Materials.SpaceTime, 4))
                .circuit(4)
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.spatialFluid, FluidShapes.fluidMolten, (int) (5760)))
                .itemOutputs(ItemList.Hatch_Input_Multi_2x2_Humongous.get(1)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_UXV).addTo(assemblerRecipes);

        // Diamond Gear
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.stick, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.plate, (int) (4L)))
                .circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.Diamond, Shapes.gearGt, (int) (1L)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Lubricant, FluidShapes.fluidLiquid, (int) (250L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.CosmicNeutronium, Shapes.foil, (int) (2)),
                        MaterialLibAPI.getStack(Materials.ChromaticGlass, Shapes.wireFine, (int) (2)))
                .itemOutputs(tectech.thing.CustomItemList.DATApipe.get(64))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.RadoxPoly, FluidShapes.fluidMolten, (int) (144L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_UV).addTo(assemblerRecipes);

        // Fusion Coil Block
        GTValues.RA.stdBuilder()
                .itemInputs(
                        Circuits.LuV.get(4),
                        ItemList.Neutron_Reflector.get(2L),
                        ItemList.Field_Generator_MV.get(2L),
                        ItemList.Casing_Coil_Superconductor.get(1L))
                .itemOutputs(ItemList.Casing_Fusion_Coil.get(1L)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        if (VisualProspecting.isModLoaded()) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.Wood, Shapes.plate, (int) (2L)),
                            new ItemStack(Items.writable_book, 1, WILDCARD),
                            new ItemStack(Items.gold_nugget, 1, WILDCARD))
                    .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glue, FluidShapes.fluidLiquid, (int) (20L)))
                    .itemOutputs(getModItem(VisualProspecting.ID, "item.visualprospecting.prospectorslog", 1))
                    .duration(6 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        }

        // Superconductor Solenoid MV
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorMV, 6),
                        GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.AnnealedCopper, 2L),
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Aluminium, 1L),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.stickLong, (int) (8L)),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plateDouble, (int) (2L)),
                        ItemList.Reactor_Coolant_He_1.get(1),
                        ItemList.Electric_Pump_MV.get(1))
                .circuit(6)
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.SolderingAlloy, FluidShapes.fluidMolten, (int) (INGOTS * 2)))
                .itemOutputs(ItemList.Superconducting_Magnet_Solenoid_MV.get(1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorMV, 6),
                        GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.AnnealedCopper, 2L),
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Aluminium, 1L),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.stickLong, (int) (8L)),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plateDouble, (int) (2L)),
                        ItemList.Reactor_Coolant_NaK_1.get(1),
                        ItemList.Electric_Pump_MV.get(1))
                .circuit(6)
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.SolderingAlloy, FluidShapes.fluidMolten, (int) (INGOTS * 2)))
                .itemOutputs(ItemList.Superconducting_Magnet_Solenoid_MV.get(1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        // Superconductor Solenoid HV
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorHV, 8),
                        GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.Silver, 2L),
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1L),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.stickLong, (int) (8L)),
                        MaterialLibAPI.getStack(Materials.BlackSteel, Shapes.plateDouble, (int) (2L)),
                        ItemList.Reactor_Coolant_He_3.get(1),
                        ItemList.Electric_Pump_HV.get(1))
                .circuit(6)
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.SolderingAlloy, FluidShapes.fluidMolten, (int) (INGOTS * 2)))
                .itemOutputs(ItemList.Superconducting_Magnet_Solenoid_HV.get(1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorHV, 8),
                        GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.Silver, 2L),
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1L),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.stickLong, (int) (8L)),
                        MaterialLibAPI.getStack(Materials.BlackSteel, Shapes.plateDouble, (int) (2L)),
                        ItemList.Reactor_Coolant_NaK_3.get(1),
                        ItemList.Electric_Pump_HV.get(1))
                .circuit(6)
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.SolderingAlloy, FluidShapes.fluidMolten, (int) (INGOTS * 2)))
                .itemOutputs(ItemList.Superconducting_Magnet_Solenoid_HV.get(1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // Superconductor Solenoid EV
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorEV, 8),
                        GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.Aluminium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 1L),
                        MaterialLibAPI.getStack(Materials.Permalloy, Shapes.stickLong, (int) (8)),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plateDouble, (int) (2L)),
                        ItemList.Reactor_Coolant_He_6.get(1),
                        ItemList.Electric_Pump_EV.get(1))
                .circuit(6)
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.SolderingAlloy, FluidShapes.fluidMolten, (int) (INGOTS * 2)))
                .itemOutputs(ItemList.Superconducting_Magnet_Solenoid_EV.get(1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorEV, 8),
                        GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.Aluminium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 1L),
                        MaterialLibAPI.getStack(Materials.Permalloy, Shapes.stickLong, (int) (8)),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plateDouble, (int) (2L)),
                        ItemList.Reactor_Coolant_NaK_6.get(1),
                        ItemList.Electric_Pump_EV.get(1))
                .circuit(6)
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.SolderingAlloy, FluidShapes.fluidMolten, (int) (INGOTS * 2)))
                .itemOutputs(ItemList.Superconducting_Magnet_Solenoid_EV.get(1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        // Superconductor Solenoid IV
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorIV, 8),
                        GTOreDictUnificator.get(OrePrefixes.cableGt02, Materials.Tungsten, 2L),
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.TungstenSteel, 1L),
                        MaterialLibAPI.getStack(Materials.Permalloy, Shapes.stickLong, (int) (8)),
                        MaterialLibAPI.getStack(Materials.HSSG, Shapes.plateDouble, (int) (2L)),
                        ItemList.Reactor_Coolant_Sp_3.get(1),
                        ItemList.Electric_Pump_IV.get(1))
                .circuit(6)
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.SolderingAlloy, FluidShapes.fluidMolten, (int) (INGOTS * 2)))
                .itemOutputs(ItemList.Superconducting_Magnet_Solenoid_IV.get(1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        // EV Battery Buffer (16 Slots)
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_EV.get(1),
                        GTOreDictUnificator.get(OrePrefixes.wireGt16, Materials.Aluminium, 4),
                        new ItemStack(Blocks.chest))
                .itemOutputs(ItemList.Battery_Buffer_4by4_EV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        // Firebox Casings
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Bronze, 1),
                        MaterialLibAPI.getStack(Materials.Bronze, Shapes.stick, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Bronze, Shapes.plate, (int) (4)))
                .circuit(3).itemOutputs(ItemList.Casing_Firebox_Bronze.get(1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.stick, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, (int) (4)))
                .circuit(13).itemOutputs(ItemList.Casing_Firebox_Steel.get(1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 1),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.stick, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (4)))
                .circuit(13).itemOutputs(ItemList.Casing_Firebox_Titanium.get(1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 1),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.stick, (int) (4)),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (4)))
                .circuit(13).itemOutputs(ItemList.Casing_Firebox_TungstenSteel.get(1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // Alloy Blast Smelter
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Machine_IV_AlloySmelter.get(1),
                        MaterialLibAPI.getStack(Materials.ZirconiumCarbide, Shapes.plate, (int) (2)),
                        GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.Tungsten, 2),
                        Circuits.IV.get(2))
                .itemOutputs(GregtechItemList.Industrial_AlloyBlastSmelter.get(1)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        // IV Alloy Smelter
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_IV.get(1),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.TPVAlloy, 4),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Platinum, 2),
                        Circuits.IV.get(2))
                .itemOutputs(ItemList.Machine_IV_AlloySmelter.get(1)).duration(1 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        // LuV World Accelerator
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_LuV.get(2),
                        ItemList.Electric_Pump_LuV.get(1),
                        ItemList.Conveyor_Module_LuV.get(1),
                        ItemList.Robot_Arm_LuV.get(2),
                        ItemList.Electric_Piston_LuV.get(2),
                        ItemList.Hull_LuV.get(1))
                .itemOutputs(ItemList.AcceleratorLuV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        // Assembler Machine Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 1),
                        ItemList.Electric_Motor_IV.get(1),
                        Circuits.ZPM.get(6),
                        Circuits.LuV.get(1))
                .itemOutputs(ItemList.Casing_Assembler.get(1)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        if (IronChests.isModLoaded()) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Blocks.chest),
                            MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, (int) (1)))
                    .circuit(1).fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS))
                    .itemOutputs(ItemList.Cover_Chest_Basic.get(1)).duration(40 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                    .addTo(assemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(IronChests.ID, "BlockIronChest", 1, 3),
                            MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (1)))
                    .circuit(1).fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS))
                    .itemOutputs(ItemList.Cover_Chest_Good.get(1)).duration(40 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                    .addTo(assemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(IronChests.ID, "BlockIronChest", 1, 0),
                            MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (1)))
                    .circuit(1).fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS))
                    .itemOutputs(ItemList.Cover_Chest_Advanced.get(1)).duration(40 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                    .addTo(assemblerRecipes);
        }
    }

    private void makeStoneToolRecipes() {
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Stone, 2L))
                .circuit(17).itemOutputs(getModItem(Minecraft.ID, "stone_sword", 1, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Stone, 1L))
                .circuit(18).itemOutputs(getModItem(Minecraft.ID, "stone_shovel", 1, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Stone, 3L))
                .circuit(19).itemOutputs(getModItem(Minecraft.ID, "stone_pickaxe", 1, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Stone, 3L))
                .circuit(20).itemOutputs(getModItem(Minecraft.ID, "stone_axe", 1, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Stone, 2L))
                .circuit(21).itemOutputs(getModItem(Minecraft.ID, "stone_hoe", 1, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
    }

    private void makeElectricMachinePartRecipes() {
        // Motors

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.IronMagnetic, Shapes.stick, (int) (1L)),
                        new OreDictItemStack("stickAnyIron", 2),
                        new OreDictItemStack("wireGt01AnyCopper", 4),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L))
                .itemOutputs(ItemList.Electric_Motor_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.SteelMagnetic, Shapes.stick, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.stick, (int) (2L)),
                        new OreDictItemStack("wireGt01AnyCopper", 4),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L))
                .itemOutputs(ItemList.Electric_Motor_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.SteelMagnetic, Shapes.stick, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.stick, (int) (2L)),
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.Cupronickel, 4L),
                        new OreDictItemStack("cableGt01AnyCopper", 2))
                .itemOutputs(ItemList.Electric_Motor_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.SteelMagnetic, Shapes.stick, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.stick, (int) (2L)),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 4L),
                        GTOreDictUnificator.get(OrePrefixes.cableGt02, Materials.Silver, 2L))
                .itemOutputs(ItemList.Electric_Motor_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.NeodymiumMagnetic, Shapes.stick, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.stick, (int) (2L)),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.BlackSteel, 4L),
                        GTOreDictUnificator.get(OrePrefixes.cableGt02, Materials.Aluminium, 2L))
                .itemOutputs(ItemList.Electric_Motor_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.NeodymiumMagnetic, Shapes.stick, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.stick, (int) (2L)),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Graphene, 4L),
                        GTOreDictUnificator.get(OrePrefixes.cableGt02, Materials.Tungsten, 2L))
                .itemOutputs(ItemList.Electric_Motor_IV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Pumps

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_LV.get(1L),
                        new OreDictItemStack("ringAnyRubber", 2),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.rotor, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.screw, (int) (1)),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1),
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Bronze, 1))
                .itemOutputs(ItemList.Electric_Pump_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_MV.get(1L),
                        new OreDictItemStack("ringAnyRubber", 2),
                        MaterialLibAPI.getStack(Materials.Bronze, Shapes.rotor, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Bronze, Shapes.screw, (int) (1)),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1),
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1))
                .itemOutputs(ItemList.Electric_Pump_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_HV.get(1L),
                        new OreDictItemStack("ringAnyRubber", 2),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.rotor, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.screw, (int) (1)),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1),
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1))
                .itemOutputs(ItemList.Electric_Pump_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_EV.get(1L),
                        new OreDictItemStack("ringAnyRubber", 2),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.rotor, (int) (1)),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.screw, (int) (1)),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1),
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 1))
                .itemOutputs(ItemList.Electric_Pump_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_IV.get(1L),
                        new OreDictItemStack("ringAnySyntheticRubber", 2),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.rotor, (int) (1)),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.screw, (int) (1)),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1),
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.TungstenSteel, 1))
                .itemOutputs(ItemList.Electric_Pump_IV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Conveyors

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_LV.get(2L),
                        new OreDictItemStack("plateAnyRubber", 6),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1))
                .itemOutputs(ItemList.Conveyor_Module_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_MV.get(2L),
                        new OreDictItemStack("plateAnyRubber", 6),
                        GTOreDictUnificator.get("cableGt01AnyCopper", 1))
                .itemOutputs(ItemList.Conveyor_Module_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_HV.get(2L),
                        new OreDictItemStack("plateAnyRubber", 6),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1))
                .itemOutputs(ItemList.Conveyor_Module_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_EV.get(2L),
                        new OreDictItemStack("plateAnyRubber", 6),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1))
                .itemOutputs(ItemList.Conveyor_Module_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_IV.get(2L),
                        new OreDictItemStack("plateAnySyntheticRubber", 6),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1))
                .itemOutputs(ItemList.Conveyor_Module_IV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Pistons

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_LV.get(1L),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, (int) (3)),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.stick, (int) (2)),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.gearGtSmall, (int) (1)))
                .itemOutputs(ItemList.Electric_Piston_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_MV.get(1L),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (3)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.stick, (int) (2)),
                        GTOreDictUnificator.get("cableGt01AnyCopper", 2),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.gearGtSmall, (int) (1)))
                .itemOutputs(ItemList.Electric_Piston_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_HV.get(1L),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (3)),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.stick, (int) (2)),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.gearGtSmall, (int) (1)))
                .itemOutputs(ItemList.Electric_Piston_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_EV.get(1L),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (3)),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.stick, (int) (2)),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 2),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.gearGtSmall, (int) (1)))
                .itemOutputs(ItemList.Electric_Piston_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_IV.get(1L),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (3)),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.stick, (int) (2)),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 2),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.gearGtSmall, (int) (1)))
                .itemOutputs(ItemList.Electric_Piston_IV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Robot Arms

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_LV.get(2L),
                        ItemList.Electric_Piston_LV.get(1L),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.stick, (int) (2)),
                        Circuits.LV.get(1),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 3))
                .itemOutputs(ItemList.Robot_Arm_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_MV.get(2L),
                        ItemList.Electric_Piston_MV.get(1L),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.stick, (int) (2)),
                        Circuits.MV.get(1),
                        GTOreDictUnificator.get("cableGt01AnyCopper", 3))
                .itemOutputs(ItemList.Robot_Arm_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_HV.get(2L),
                        ItemList.Electric_Piston_HV.get(1L),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.stick, (int) (2)),
                        Circuits.HV.get(1),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 3))
                .itemOutputs(ItemList.Robot_Arm_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_EV.get(2L),
                        ItemList.Electric_Piston_EV.get(1L),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.stick, (int) (2)),
                        Circuits.EV.get(1),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 3))
                .itemOutputs(ItemList.Robot_Arm_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Electric_Motor_IV.get(2L),
                        ItemList.Electric_Piston_IV.get(1L),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.stick, (int) (2)),
                        Circuits.IV.get(1),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 3))
                .itemOutputs(ItemList.Robot_Arm_IV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Emitter

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.gem, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Brass, Shapes.stick, (int) (4)),
                        Circuits.LV.get(2),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2))
                .itemOutputs(ItemList.Emitter_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.gem, Materials.EnderPearl, 1),
                        MaterialLibAPI.getStack(Materials.Electrum, Shapes.stick, (int) (4)),
                        Circuits.MV.get(2),
                        GTOreDictUnificator.get("cableGt01AnyCopper", 2))
                .itemOutputs(ItemList.Emitter_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.gem, Materials.EnderEye, 1),
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.stick, (int) (4)),
                        Circuits.HV.get(2),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2))
                .itemOutputs(ItemList.Emitter_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.QuantumEye.get(1L),
                        MaterialLibAPI.getStack(Materials.Platinum, Shapes.stick, (int) (4)),
                        Circuits.EV.get(2),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 2))
                .itemOutputs(ItemList.Emitter_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.QuantumStar.get(1L),
                        MaterialLibAPI.getStack(Materials.Iridium, Shapes.stick, (int) (4)),
                        Circuits.IV.get(2),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 2))
                .itemOutputs(ItemList.Emitter_IV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Sensor

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.gem, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Brass, Shapes.stick, (int) (1)),
                        Circuits.LV.get(1))
                .itemOutputs(ItemList.Sensor_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Emerald, Shapes.gemFlawless, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Electrum, Shapes.stick, (int) (1)),
                        Circuits.MV.get(1))
                .itemOutputs(ItemList.Sensor_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.gem, Materials.EnderEye, 1),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.stick, (int) (1)),
                        Circuits.HV.get(1))
                .itemOutputs(ItemList.Sensor_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.QuantumEye.get(1L),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Platinum, Shapes.stick, (int) (1)),
                        Circuits.EV.get(1))
                .itemOutputs(ItemList.Sensor_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.QuantumStar.get(1L),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Iridium, Shapes.stick, (int) (1)),
                        Circuits.IV.get(1))
                .itemOutputs(ItemList.Sensor_IV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        // Field Generator

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.EnderPearl, Shapes.plate, (int) (1)), Circuits.HV.get(4))
                .circuit(1).itemOutputs(ItemList.Field_Generator_LV.get(1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.RedSteel, FluidShapes.fluidMolten, (int) (288)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.EnderEye, Shapes.plate, (int) (1)), Circuits.EV.get(4))
                .circuit(1).itemOutputs(ItemList.Field_Generator_MV.get(1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Titanium, FluidShapes.fluidMolten, (int) (288)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.QuantumEye.get(1), Circuits.IV.get(4)).circuit(1)
                .itemOutputs(ItemList.Field_Generator_HV.get(1))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.NiobiumTitanium, FluidShapes.fluidMolten, (int) (576)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(GTOreDictUnificator.get(OrePrefixes.gem, Materials.NetherStar, 1), Circuits.LuV.get(4))
                .circuit(1).itemOutputs(ItemList.Field_Generator_EV.get(1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.HSSG, FluidShapes.fluidMolten, (int) (576)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.QuantumStar.get(1L), Circuits.ZPM.get(4)).circuit(1)
                .itemOutputs(ItemList.Field_Generator_IV.get(1L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.HSSS, FluidShapes.fluidMolten, (int) (576)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

    }

    private void makeCircuitPartRecipes() {
        // Circuits and Boards

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Wood, Shapes.plate, (int) (8)),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.foil, (int) (32)))
                .circuit(6).itemOutputs(ItemList.Circuit_Board_Coated_Basic.get(8L))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 1152)).duration(1 * MINUTES + 20 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Wood, Shapes.plate, (int) (8)),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.foil, (int) (32)))
                .circuit(6).itemOutputs(ItemList.Circuit_Board_Coated_Basic.get(8L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glue, FluidShapes.fluidLiquid, (int) (576L)))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Wood, Shapes.plate, (int) (8)),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.foil, (int) (32)))
                .circuit(6).itemOutputs(ItemList.Circuit_Board_Coated_Basic.get(16L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (288L)))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Wood, Shapes.plate, (int) (8)),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.foil, (int) (32)))
                .circuit(6).itemOutputs(ItemList.Circuit_Board_Coated_Basic.get(16L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.Polytetrafluoroethylene,
                                FluidShapes.fluidMolten,
                                (int) (144L)))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Wood, Shapes.plate, (int) (8)),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.foil, (int) (32)))
                .circuit(6).itemOutputs(ItemList.Circuit_Board_Coated_Basic.get(24L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Epoxid, FluidShapes.fluidMolten, (int) (144L)))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Wood, Shapes.plate, (int) (8)),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.foil, (int) (32)))
                .circuit(6).itemOutputs(ItemList.Circuit_Board_Coated_Basic.get(32L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.Polybenzimidazole, FluidShapes.fluidMolten, (int) (72L)))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Wood, Shapes.dust, (int) (8))).circuit(1)
                .itemOutputs(ItemList.Circuit_Board_Phenolic.get(8L))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 576)).duration(2 * MINUTES).eut(TierEU.RECIPE_LV / 2)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Wood, Shapes.dust, (int) (8))).circuit(1)
                .itemOutputs(ItemList.Circuit_Board_Phenolic.get(8L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glue, FluidShapes.fluidLiquid, (int) (288)))
                .duration(2 * MINUTES).eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Wood, Shapes.dust, (int) (8))).circuit(1)
                .itemOutputs(ItemList.Circuit_Board_Phenolic.get(16L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.BisphenolA, FluidShapes.fluidLiquid, (int) (144)))
                .duration(2 * MINUTES).eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Wood, Shapes.dust, (int) (8))).circuit(1)
                .itemOutputs(ItemList.Circuit_Board_Phenolic.get(24L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Epoxid, FluidShapes.fluidMolten, (int) (144L)))
                .duration(2 * MINUTES).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Parts_Glass_Tube.get(2L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.stick, (int) (4)))
                .circuit(5).itemOutputs(ItemList.Circuit_Parts_Vacuum_Tube.get(2L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Redstone, FluidShapes.fluidMolten, (int) (144L)))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Parts_Glass_Tube.get(4L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.stick, (int) (4)))
                .circuit(5).itemOutputs(ItemList.Circuit_Parts_Vacuum_Tube.get(4L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.RedAlloy, FluidShapes.fluidMolten, (int) (72L)))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Parts_Glass_Tube.get(4L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.stick, (int) (4)))
                .circuit(5).itemOutputs(ItemList.Circuit_Parts_Vacuum_Tube.get(8L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.RedstoneAlloy, FluidShapes.fluidMolten, (int) (72L)))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Parts_Glass_Tube.get(4L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.stick, (int) (4)))
                .circuit(5).itemOutputs(ItemList.Circuit_Parts_Vacuum_Tube.get(8L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.RedAlloy, FluidShapes.fluidMolten, (int) (72L)))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Parts_Glass_Tube.get(4L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.stick, (int) (4)))
                .circuit(5).itemOutputs(ItemList.Circuit_Parts_Vacuum_Tube.get(16L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.RedstoneAlloy, FluidShapes.fluidMolten, (int) (72L)))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);

        // Resistors
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new OreDictItemStack("dustAnyCarbon", 1),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.wireFine, (int) (4)),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4))
                .circuit(3).itemOutputs(ItemList.Circuit_Parts_Resistor.get(4L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glue, FluidShapes.fluidLiquid, (int) (288)))
                .duration(16 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new OreDictItemStack("dustAnyCarbon", 1),
                        MaterialLibAPI.getStack(Materials.AnnealedCopper, Shapes.wireFine, (int) (4)),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4))
                .circuit(5).itemOutputs(ItemList.Circuit_Parts_Resistor.get(8L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glue, FluidShapes.fluidLiquid, (int) (288)))
                .duration(16 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new OreDictItemStack("dustAnyCarbon", 1),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.wireFine, (int) (4)),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4))
                .circuit(5).itemOutputs(ItemList.Circuit_Parts_Resistor.get(4L))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 576)).duration(16 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new OreDictItemStack("dustAnyCarbon", 1),
                        MaterialLibAPI.getStack(Materials.AnnealedCopper, Shapes.wireFine, (int) (4)),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4))
                .circuit(5).itemOutputs(ItemList.Circuit_Parts_Resistor.get(8L))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 576)).duration(16 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.wireFine, (int) (4)),
                        MaterialLibAPI.getStack(Materials.GalliumArsenide, Shapes.dustSmall, (int) (1)))
                .circuit(4).itemOutputs(ItemList.Circuit_Parts_Diode.get(4L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (144L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.wireFine, (int) (4)),
                        MaterialLibAPI.getStack(Materials.GalliumArsenide, Shapes.dustSmall, (int) (1)))
                .circuit(4).itemOutputs(ItemList.Circuit_Parts_Diode.get(2L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glass, FluidShapes.fluidMolten, (int) (288L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.wireFine, (int) (4)),
                        MaterialLibAPI.getStack(Materials.GalliumArsenide, Shapes.dustSmall, (int) (1)))
                .circuit(4).itemOutputs(ItemList.Circuit_Parts_Diode.get(2L))
                .fluidInputs(FluidRegistry.getFluidStack("glass.molten", 1000)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.wireFine, (int) (4)),
                        ItemList.Circuit_Silicon_Wafer.get(1L))
                .circuit(4).itemOutputs(ItemList.Circuit_Parts_Diode.get(2L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (144L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.wireFine, (int) (4)),
                        ItemList.Circuit_Silicon_Wafer.get(1L))
                .circuit(4).itemOutputs(ItemList.Circuit_Parts_Diode.get(1L))
                .fluidInputs(FluidRegistry.getFluidStack("glass.molten", 1000)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.wireFine, (int) (4)),
                        ItemList.Circuit_Silicon_Wafer.get(1L))
                .circuit(4).itemOutputs(ItemList.Circuit_Parts_Diode.get(1L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glass, FluidShapes.fluidMolten, (int) (288L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.AnnealedCopper, Shapes.wireFine, (int) (4)),
                        ItemList.Circuit_Silicon_Wafer.get(1L))
                .circuit(4).itemOutputs(ItemList.Circuit_Parts_Diode.get(4L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (144L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Tantalum, Shapes.wireFine, (int) (4)),
                        ItemList.Circuit_Silicon_Wafer.get(1L))
                .circuit(4).itemOutputs(ItemList.Circuit_Parts_Diode.get(8L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (144L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.ring, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.wireFine, (int) (2)))
                .circuit(3).itemOutputs(ItemList.Circuit_Parts_Coil.get(2L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (36L)))
                .duration(16 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.NickelZincFerrite, Shapes.ring, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.wireFine, (int) (2)))
                .circuit(3).itemOutputs(ItemList.Circuit_Parts_Coil.get(4L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (36L)))
                .duration(16 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.ring, (int) (1)),
                        MaterialLibAPI.getStack(Materials.AnnealedCopper, Shapes.wireFine, (int) (2)))
                .circuit(3).itemOutputs(ItemList.Circuit_Parts_Coil.get(4L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (36L)))
                .duration(16 * SECONDS).eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.NickelZincFerrite, Shapes.ring, (int) (1)),
                        MaterialLibAPI.getStack(Materials.AnnealedCopper, Shapes.wireFine, (int) (2)))
                .circuit(3).itemOutputs(ItemList.Circuit_Parts_Coil.get(8L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (36L)))
                .duration(16 * SECONDS).eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Plastic, Shapes.foil, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Tantalum, Shapes.foil, (int) (2)))
                .circuit(3).itemOutputs(ItemList.Circuit_Parts_Capacitor.get(12L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (144L)))
                .duration(16 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Plastic, Shapes.foil, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.foil, (int) (2)))
                .circuit(3).itemOutputs(ItemList.Circuit_Parts_Capacitor.get(8L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (144L)))
                .duration(16 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.SiliconSolarGrade, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.wireFine, (int) (8)))
                .circuit(2).itemOutputs(ItemList.Circuit_Parts_Transistor.get(6L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (144L)))
                .duration(16 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.AnnealedCopper, Shapes.wireFine, (int) (4)),
                        MaterialLibAPI.getStack(Materials.GalliumArsenide, Shapes.dustSmall, (int) (1)))
                .circuit(4).itemOutputs(ItemList.Circuit_Parts_Diode.get(6L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (144L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Tantalum, Shapes.wireFine, (int) (4)),
                        MaterialLibAPI.getStack(Materials.GalliumArsenide, Shapes.dustSmall, (int) (1)))
                .circuit(4).itemOutputs(ItemList.Circuit_Parts_Diode.get(16L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (144L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // All SMD Component recipes.
        // Normal SMD
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Carbon, Shapes.dust, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Electrum, Shapes.wireFine, (int) (4)))
                .circuit(3).itemOutputs(ItemList.Circuit_Parts_ResistorSMD.get(16L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (288L)))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Carbon, Shapes.dust, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Tantalum, Shapes.wireFine, (int) (4)))
                .circuit(3).itemOutputs(ItemList.Circuit_Parts_ResistorSMD.get(32L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (288L)))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Platinum, Shapes.wireFine, (int) (16)),
                        MaterialLibAPI.getStack(Materials.GalliumArsenide, Shapes.dust, (int) (1)))
                .circuit(3).itemOutputs(ItemList.Circuit_Parts_DiodeSMD.get(64L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (576L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Gallium, Shapes.foil, (int) (1)),
                        MaterialLibAPI.getStack(Materials.AnnealedCopper, Shapes.wireFine, (int) (8)))
                .circuit(3).itemOutputs(ItemList.Circuit_Parts_TransistorSMD.get(16L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (288L)))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Gallium, Shapes.foil, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Tantalum, Shapes.wireFine, (int) (8)))
                .circuit(3).itemOutputs(ItemList.Circuit_Parts_TransistorSMD.get(32L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (288L)))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Silicone, Shapes.foil, (int) (2)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.foil, (int) (2)))
                .circuit(3).itemOutputs(ItemList.Circuit_Parts_CapacitorSMD.get(16L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (144L)))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.PolyvinylChloride, Shapes.foil, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.foil, (int) (2)))
                .circuit(3).itemOutputs(ItemList.Circuit_Parts_CapacitorSMD.get(24L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (144L)))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Silicone, Shapes.foil, (int) (2)),
                        MaterialLibAPI.getStack(Materials.Tantalum, Shapes.foil, (int) (2)))
                .circuit(3).itemOutputs(ItemList.Circuit_Parts_CapacitorSMD.get(32L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (144L)))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.PolyvinylChloride, Shapes.foil, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Tantalum, Shapes.foil, (int) (2)))
                .circuit(3).itemOutputs(ItemList.Circuit_Parts_CapacitorSMD.get(48L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (144L)))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Neodymium, Shapes.ring, (int) (1)),
                        MaterialLibAPI.getStack(Materials.ConductiveIron, Shapes.wireFine, (int) (8)))
                .circuit(3).itemOutputs(ItemList.Circuit_Parts_InductorSMD.get(24L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (36L)))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Neodymium, Shapes.ring, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Platinum, Shapes.wireFine, (int) (8)))
                .circuit(3).itemOutputs(ItemList.Circuit_Parts_InductorSMD.get(32L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (36L)))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Neodymium, Shapes.ring, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Tantalum, Shapes.wireFine, (int) (8)))
                .circuit(3).itemOutputs(ItemList.Circuit_Parts_InductorSMD.get(48L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (36L)))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Neodymium, Shapes.ring, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Iridium, Shapes.wireFine, (int) (8)))
                .circuit(3).itemOutputs(ItemList.Circuit_Parts_InductorSMD.get(64L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (36L)))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // ASMD
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Graphene, Shapes.dust, (int) (2)),
                        MaterialLibAPI.getStack(Materials.Platinum, Shapes.wireFine, (int) (16)),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.bolt, (int) (4)))
                .circuit(6).itemOutputs(ItemList.Circuit_Parts_ResistorASMD.get(64L))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.Polybenzimidazole, FluidShapes.fluidMolten, (int) (576L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.IndiumGalliumPhosphide, Shapes.dust, (int) (1)),
                        MaterialLibAPI.getStack(Materials.NiobiumTitanium, Shapes.wireFine, (int) (16)),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.bolt, (int) (4)))
                .circuit(6).itemOutputs(ItemList.Circuit_Parts_DiodeASMD.get(64L))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.Polybenzimidazole, FluidShapes.fluidMolten, (int) (576L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.VanadiumGallium, Shapes.foil, (int) (2)),
                        MaterialLibAPI.getStack(Materials.HSSG, Shapes.wireFine, (int) (16)),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.bolt, (int) (4)))
                .circuit(6).itemOutputs(ItemList.Circuit_Parts_TransistorASMD.get(64L))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.Polybenzimidazole, FluidShapes.fluidMolten, (int) (576L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Polybenzimidazole, Shapes.foil, (int) (4)),
                        MaterialLibAPI.getStack(Materials.HSSS, Shapes.foil, (int) (2)),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.bolt, (int) (4)))
                .circuit(6).itemOutputs(ItemList.Circuit_Parts_CapacitorASMD.get(64L))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.Polybenzimidazole, FluidShapes.fluidMolten, (int) (576L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Samarium, Shapes.ring, (int) (1)),
                        MaterialLibAPI.getStack(Materials.HSSE, Shapes.wireFine, (int) (32)),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.bolt, (int) (4)))
                .circuit(6).itemOutputs(ItemList.Circuit_Parts_InductorASMD.get(64L))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.Polybenzimidazole, FluidShapes.fluidMolten, (int) (576L)))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        // xSMD
        // Resistor

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Netherite, Shapes.foil, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Pikyonium64B, Shapes.foil, (int) (4)),
                        MaterialLibAPI
                                .getStack(Materials.Tetranaquadahdiindiumhexaplatiumosminid, Shapes.foil, (int) (2L)),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 2))
                .circuit(9).itemOutputs(ItemList.Circuit_Parts_ResistorXSMD.get(64L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Xenoxene, FluidShapes.fluidLiquid, (int) (288)))
                .duration(16 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);
        // Transistor

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.foil, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.ArceusAlloy2B, Shapes.foil, (int) (2)),
                        MaterialLibAPI
                                .getStack(Materials.Tetranaquadahdiindiumhexaplatiumosminid, Shapes.foil, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 1))
                .circuit(9).itemOutputs(ItemList.Circuit_Parts_TransistorXSMD.get(32L))
                .fluidInputs((MaterialLibAPI.getFluidStack(Materials.Xenoxene, FluidShapes.fluidLiquid, (int) (144L))))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);
        // Capacitor

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Draconium, Shapes.foil, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.CinobiteA243, Shapes.foil, (int) (2)),
                        MaterialLibAPI
                                .getStack(Materials.Tetranaquadahdiindiumhexaplatiumosminid, Shapes.foil, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 1))
                .circuit(9).itemOutputs(ItemList.Circuit_Parts_CapacitorXSMD.get(32L))
                .fluidInputs((MaterialLibAPI.getFluidStack(Materials.Xenoxene, FluidShapes.fluidLiquid, (int) (144L))))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);
        // Diode

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Tritanium, Shapes.foil, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.LafiumCompound, Shapes.foil, (int) (2)),
                        MaterialLibAPI
                                .getStack(Materials.Tetranaquadahdiindiumhexaplatiumosminid, Shapes.foil, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 1))
                .circuit(9).itemOutputs(ItemList.Circuit_Parts_DiodeXSMD.get(64L))
                .fluidInputs((MaterialLibAPI.getFluidStack(Materials.Xenoxene, FluidShapes.fluidLiquid, (int) (144L))))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);
        // Inductor

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Hikarium, Shapes.foil, (int) (4)),
                        MaterialLibAPI.getStack(Materials.ArtheriumSn, Shapes.foil, (int) (1)),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 1))
                .circuit(9).itemOutputs(ItemList.Circuit_Parts_InductorXSMD.get(32L))
                .fluidInputs((MaterialLibAPI.getFluidStack(Materials.Xenoxene, FluidShapes.fluidLiquid, (int) (144L))))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);

    }

    private void makeAirFilterRecipes() {
        // Air Filter stuff

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1L),
                        BlockList.SteelBars.get(6))
                .circuit(1).itemOutputs(ItemList.Casing_AirFilter_Vent_T1.get(1L))
                .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_AirFilter_Vent_T1.get(1L),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.stickLong, (int) (2L)),
                        ItemList.Electric_Motor_LV.get(2L))
                .circuit(1).itemOutputs(ItemList.Casing_AirFilter_Turbine_T1.get(1L))
                .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_LV.get(1L),
                        ItemList.Casing_AirFilter_Turbine_T1.get(1L),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.rotor, (int) (1L)),
                        ItemList.Electric_Motor_LV.get(2L),
                        ItemList.Electric_Pump_LV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1L))
                .circuit(1).itemOutputs(ItemList.Machine_Multi_AirFilterT1.get(1L))
                .fluidInputs(SubstituteFluidStack.soldering(1 * INGOTS)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 1L),
                        BlockList.TitaniumBars.get(6))
                .circuit(1).itemOutputs(ItemList.Casing_AirFilter_Vent_T2.get(1L))
                .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_AirFilter_Vent_T2.get(1L),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.stickLong, (int) (2L)),
                        ItemList.Electric_Motor_HV.get(2L))
                .circuit(1).itemOutputs(ItemList.Casing_AirFilter_Turbine_T2.get(1L))
                .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_HV.get(1L),
                        ItemList.Casing_AirFilter_Turbine_T2.get(1L),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.rotor, (int) (1L)),
                        ItemList.Electric_Motor_HV.get(2L),
                        ItemList.Electric_Pump_HV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1L))
                .circuit(1).itemOutputs(ItemList.Machine_Multi_AirFilterT2.get(1L))
                .fluidInputs(SubstituteFluidStack.soldering(1 * INGOTS)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 1L),
                        BlockList.TungstenSteelBars.get(6))
                .circuit(1).itemOutputs(ItemList.Casing_AirFilter_Vent_T3.get(1L))
                .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_AirFilter_Vent_T3.get(1L),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.stickLong, (int) (2L)),
                        ItemList.Electric_Motor_IV.get(2L))
                .circuit(1).itemOutputs(ItemList.Casing_AirFilter_Turbine_T3.get(1L))
                .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_IV.get(1L),
                        ItemList.Casing_AirFilter_Turbine_T3.get(1L),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.rotor, (int) (1L)),
                        ItemList.Electric_Motor_IV.get(2L),
                        ItemList.Electric_Pump_IV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1L))
                .circuit(1).itemOutputs(ItemList.Machine_Multi_AirFilterT3.get(1L))
                .fluidInputs(SubstituteFluidStack.soldering(1 * INGOTS)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

    }

    private void makeEnderIORecipes() {
        if (!EnderIO.isModLoaded()) {
            return;
        }

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1),
                        MaterialLibAPI.getStack(Materials.Glowstone, Shapes.dust, (int) (4)))
                .circuit(1).itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1, 2)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1), new OreDictItemStack("dyeBlack", 4))
                .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1, 4)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Silver, Shapes.bolt, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Manganese, Shapes.foil, (int) (4)))
                .circuit(1).itemOutputs(getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (288)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.bolt, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Manganese, Shapes.foil, (int) (4)))
                .circuit(1).itemOutputs(getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (288)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Tantalum, Shapes.bolt, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Manganese, Shapes.foil, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Coal, Shapes.dust, (int) (4)))
                .circuit(1).itemOutputs(getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 1))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.EnergeticAlloy, FluidShapes.fluidMolten, (int) (576)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.EnderEye, Shapes.bolt, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Manganese, Shapes.foil, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Coal, Shapes.dust, (int) (4)))
                .circuit(1).itemOutputs(getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 8))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.EnergeticSilver, FluidShapes.fluidMolten, (int) (576)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.bolt, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Manganese, Shapes.foil, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Glowstone, Shapes.dust, (int) (4)))
                .circuit(1).itemOutputs(getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.EnergeticAlloy, FluidShapes.fluidMolten, (int) (576)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.EnderEye, Shapes.bolt, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Manganese, Shapes.foil, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Glowstone, Shapes.dust, (int) (4)))
                .circuit(1).itemOutputs(getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.EnergeticSilver, FluidShapes.fluidMolten, (int) (576)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Platinum, Shapes.bolt, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Manganese, Shapes.foil, (int) (4)),
                        ItemList.QuantumEye.get(1L))
                .circuit(1).itemOutputs(getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 3))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.CrystallineAlloy, FluidShapes.fluidMolten, (int) (864)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.bolt, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Manganese, Shapes.foil, (int) (4)),
                        ItemList.QuantumEye.get(1L))
                .circuit(1).itemOutputs(getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 3))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.CrystallineAlloy, FluidShapes.fluidMolten, (int) (864)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.bolt, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Manganese, Shapes.foil, (int) (4)),
                        GTOreDictUnificator.get(OrePrefixes.gem, Materials.NetherStar, 1),
                        MaterialLibAPI.getStack(Materials.EndSteel, Shapes.plate, (int) (1)))
                .circuit(1).itemOutputs(getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 4))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.MelodicAlloy, FluidShapes.fluidMolten, (int) (1152)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.VanadiumGallium, Shapes.bolt, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Manganese, Shapes.foil, (int) (4)),
                        ItemList.QuantumStar.get(1L),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 13))
                .circuit(1).itemOutputs(getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 5))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.StellarAlloy, FluidShapes.fluidMolten, (int) (1440)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.ExtremelyUnstableNaquadah, Shapes.bolt, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Manganese, Shapes.foil, (int) (4)),
                        ItemList.Gravistar.get(1L),
                        getModItem(EtFuturumRequiem.ID, "totem_of_undying", 1, 0),
                        MaterialLibAPI.getStack(Materials.StellarAlloy, Shapes.plate, (int) (2)))
                .circuit(1).itemOutputs(getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 6))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Neutronium, FluidShapes.fluidMolten, (int) (1440)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 5),
                        ItemList.Gravistar.get(1L),
                        getModItem(EtFuturumRequiem.ID, "totem_of_undying", 1, 0),
                        MaterialLibAPI.getStack(Materials.StellarAlloy, Shapes.plate, (int) (2)))
                .itemOutputs(getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 6))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Neutronium, FluidShapes.fluidMolten, (int) (1152)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "skull", 1, 0),
                        getModItem(Minecraft.ID, "rotten_flesh", 2, 0),
                        MaterialLibAPI.getStack(Materials.SiliconSolarGrade, Shapes.plate, (int) (1)))
                .itemOutputs(getModItem(EnderIO.ID, "itemFrankenSkull", 1, 5))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Soularium, FluidShapes.fluidMolten, (int) (288)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);

    }

    private void makeAE2Recipes() {
        if (!AppliedEnergistics2.isModLoaded()) {
            return;
        }

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                        NHItemList.EssentiaCircuit.get())
                .itemOutputs(NHItemList.EngineeringProcessorEssentiaPulsatingCore.get()).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        // AE2 Illuminated Panel Assembler Recipe

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Cover_Screen.get(1L),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Glowstone, Shapes.plate, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.RedAlloy, Shapes.plate, (int) (1L)))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 180))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.SolderingAlloy, FluidShapes.fluidMolten, (int) (144L)))
                .duration(5 * SECONDS).eut(4).addTo(assemblerRecipes);

        // ME Storage Housing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new OreDictItemStack("paneGlass", 1),
                        MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.plate, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (2L)))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 39)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        // ME Output Bus
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hatch_Output_Bus_EV.get(1L),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4, 30))
                .circuit(1).itemOutputs(ItemList.Hatch_Output_Bus_ME.get(1)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // ME Output Hatch
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hatch_Output_EV.get(1L),
                        getModItem(AE2FluidCraft.ID, "fluid_interface", 1),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4, 30))
                .circuit(1).itemOutputs(ItemList.Hatch_Output_ME.get(1)).duration(15 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        // Stocking Input Bus (ME)
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hatch_Input_Bus_EV.get(1L),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1),
                        // Acceleration Card
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4, 30))
                .circuit(1).itemOutputs(ItemList.Hatch_Input_Bus_ME.get(1)).duration(15 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        // Stocking Input Hatch (ME)
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hatch_Input_Multi_2x2_UV.get(4L),
                        getModItem(AE2FluidCraft.ID, "fluid_interface", 1),
                        ItemList.Circuit_Chip_NeuroCPU.get(1L),
                        ItemList.Electric_Pump_UV.get(1L),
                        // 4096k Me Fluid Storage Component
                        getModItem(AE2FluidCraft.ID, "fluid_part", 4, 6),
                        // Hyper-Acceleration Card
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 56))
                .itemOutputs(ItemList.Hatch_Input_ME.get(1)).duration(15 * SECONDS).eut(TierEU.RECIPE_UV)
                .addTo(assemblerRecipes);

        // Cell Workbench
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (2)),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23),
                        ItemList.Cover_Screen.get(1),
                        getModItem(Minecraft.ID, "crafting_table", 1))
                .circuit(2).itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockCellWorkbench", 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Titanium, FluidShapes.fluidMolten, (int) (36L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // Controller
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (4L)),
                        Circuits.HV.get(2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 24),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockFluix", 1, 0))
                .circuit(2).itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockController", 1))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Energy Cells
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.plate, (int) (4L)),
                        Circuits.HV.get(2),
                        GTOreDictUnificator.get("dustFluix", 1),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockFluix", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.Aluminium, 1))
                .circuit(2).itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        Circuits.LuV.get(2),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 5, 0),
                        ItemList.Battery_Buffer_4by4_EV.get(1L),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24))
                .circuit(2).itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockDenseEnergyCell", 1))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Void Cell
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.screw, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.plate, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Tungsten, Shapes.plate, (int) (3L)),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 47))
                .circuit(2).itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemVoidStorageCell", 1))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Quantum Link
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1, 0),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (4L)),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 22),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16))
                .circuit(2).itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockQuantumRing", 1))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (4L)),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4, 9),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzGlass", 1, 0))
                .circuit(2).itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockQuantumLinkChamber", 1))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Spatial Pylon
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (4L)),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 16),
                        GTOreDictUnificator.get("dustFluix", 2L),
                        GTOreDictUnificator.get("gemFluix", 1L))
                .circuit(2).itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockSpatialPylon", 1))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Spatial IO
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (4L)),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 16),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockSpatialPylon", 1),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockIOPort", 1))
                .circuit(2).itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockSpatialIOPort", 1))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Spatial Link Chamber
        GTValues.RA.stdBuilder().itemInputs(
                getModItem(AppliedEnergistics2.ID, "tile.BlockSpatialPylon", 2), // spatial pylon
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 41), // wireless receiver (component)
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 16), // glass cable
                getModItem(AppliedEnergistics2.ID, "tile.BlockChest", 1, 0), // me chest
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 34)) // 128^3 spatial component
                .circuit(2).itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockSpatialLinkChamber", 1))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Spatial Network Relay
        GTValues.RA.stdBuilder().itemInputs(
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 24), // Engineering processor
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 41), // wireless receiver (component)
                MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (3L)),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 12), // Pure fluix crystal
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 16)) // glass cable
                .circuit(2).itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockSpatialNetworkRelay", 1))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // ME IO Port
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (3L)),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 3, 16),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockDrive", 2, 0))
                .circuit(2).itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockIOPort", 1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // ME Chest
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (4L)),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 16),
                        Circuits.MV.get(2),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 4))
                .circuit(2).itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockChest", 1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // ME Drive
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (4L)),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 16),
                        Circuits.HV.get(1),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockChest", 1),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24))
                .circuit(2).itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockDrive", 1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Interface
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (4L)),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 16),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 44),
                        ItemList.Casing_EV.get(1L))
                .circuit(2).itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Crafting Unit
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (4L)),
                        Circuits.LV.get(2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24))
                .circuit(2).itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Formation Core
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.stick, (int) (4L)),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4, 22),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 12))
                .circuit(3).itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 43))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Annihilation Core
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.NetherQuartz, Shapes.stick, (int) (4L)),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4, 22),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 12))
                .circuit(3).itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 44))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Wireless Receiver
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.EnderEye, Shapes.stick, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.plate, (int) (2L)),
                        Circuits.HV.get(1),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 140),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9))
                .circuit(3).itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 41))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Molecular Assembler
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Machine_EV_Assembler.get(1L),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (4L)),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 44))
                .circuit(3).itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockMolecularAssembler", 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glass, FluidShapes.fluidMolten, (int) (288L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // Basic Card
        GTValues.RA.stdBuilder().itemInputs(
                // Calculation Processor
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23),
                MaterialLibAPI.getStack(Materials.RedAlloy, Shapes.plate, (int) (1)),
                MaterialLibAPI.getStack(Materials.Gold, Shapes.plate, (int) (2)),
                MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (3))).circuit(2)
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 25)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // Advanced Card
        GTValues.RA.stdBuilder().itemInputs(
                // Calculation Processor
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23),
                MaterialLibAPI.getStack(Materials.RedAlloy, Shapes.plate, (int) (1)),
                MaterialLibAPI.getStack(Materials.Platinum, Shapes.plate, (int) (2)),
                MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (3))).circuit(2)
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // Acceleration Card
        GTValues.RA.stdBuilder().itemInputs(
                // Advanced Card
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28),
                // Logic Processor
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22),
                // Engineering Processor
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                // Fluix Crystal
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 7)).circuit(2)
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 30)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // Hyper-Acceleration Card
        GTValues.RA.stdBuilder().itemInputs(
                // Advanced Card
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28),
                // Engineering Processor
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                NHItemList.MysteriousCrystal.get(),
                ItemList.AcceleratorLuV.get(1L)).circuit(2)
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 56)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // Advanced Blocking Card
        GTValues.RA.stdBuilder().itemInputs(
                // Advanced Card
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28),
                // ME Storage Bus
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 220),
                // ME Level Emitter
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 280)).circuit(2)
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 63)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // Pattern Capacity Card
        GTValues.RA.stdBuilder().itemInputs(
                // Advanced Card
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28),
                // 16k ME Storage Component
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 37),
                // ME Interface
                getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1, 0)).circuit(2)
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 54)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // ME interface (flat version)
        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (4)),
                // Fluix Cable
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 16),
                // Formation Core
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43),
                // Annihilation Core
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 44),
                ItemList.Casing_EV.get(1L)).circuit(3)
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 440)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // ME Wireless Access Point
        GTValues.RA.stdBuilder().itemInputs(
                // Calculation Processor
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23),
                // Wireless Receiver
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 41),
                // Fluix Cable
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                // Titanium Screw
                MaterialLibAPI.getStack(Materials.Titanium, Shapes.screw, (int) (2)))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockWireless", 1)).duration(3 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // Pattern Provider (IV) - for Large Molecular Assembler
        GTValues.RA.stdBuilder().itemInputs(
                ItemList.Hatch_Input_Bus_IV.get(1L),
                // interface
                getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1),
                // Pattern capacity card
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 3, 54)).circuit(4)
                .itemOutputs(ItemList.Hatch_PatternProvider_Crafting_IV.get(1L)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);
        // Pattern Provider (LuV) - for Large Molecular Assembler
        GTValues.RA.stdBuilder().itemInputs(
                ItemList.Hatch_Input_Bus_LuV.get(1L),
                // interface
                getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1),
                // Pattern capacity card
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 6, 54)).circuit(4)
                .itemOutputs(ItemList.Hatch_PatternProvider_Crafting_LuV.get(1L)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);
        // Pattern Provider (ZPM) - for Large Molecular Assembler
        GTValues.RA.stdBuilder().itemInputs(
                ItemList.Hatch_Input_Bus_ZPM.get(1L),
                // interface
                getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1),
                // Pattern capacity card
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 9, 54)).circuit(4)
                .itemOutputs(ItemList.Hatch_PatternProvider_Crafting_ZPM.get(1L)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);
        // Pattern Provider (UV) - for Large Molecular Assembler
        GTValues.RA.stdBuilder().itemInputs(
                ItemList.Hatch_Input_Bus_UV.get(1L),
                // interface
                getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1),
                // Pattern capacity card
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 12, 54)).circuit(4)
                .itemOutputs(ItemList.Hatch_PatternProvider_Crafting_UV.get(1L)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(assemblerRecipes);
        // Pattern Provider (UHV) - for Large Molecular Assembler
        GTValues.RA.stdBuilder().itemInputs(
                // why is UHV input bus called MAX??? its several tiers lower >:c
                ItemList.Hatch_Input_Bus_MAX.get(1L),
                // interface
                getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1),
                // Pattern capacity card
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 15, 54)).circuit(4)
                .itemOutputs(ItemList.Hatch_PatternProvider_Crafting_UHV.get(1L)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_UHV).addTo(assemblerRecipes);

        if (AE2FluidCraft.isModLoaded()) {
            // Dual Interface
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.Iron, Shapes.plate, (int) (4L)),
                            MaterialLibAPI.getStack(Materials.Lapis, Shapes.plate, (int) (2L)),
                            getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1),
                            NHItemList.EngineeringProcessorFluidDiamondCore.get(2))
                    .circuit(2).itemOutputs(getModItem(AE2FluidCraft.ID, "fluid_interface", 1, 0)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

            // Dual Interface (flat version)
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.Iron, Shapes.plate, (int) (4L)),
                            MaterialLibAPI.getStack(Materials.Lapis, Shapes.plate, (int) (2L)),
                            getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1),
                            NHItemList.EngineeringProcessorFluidDiamondCore.get(2))
                    .circuit(3).itemOutputs(getModItem(AE2FluidCraft.ID, "part_fluid_interface", 1, 0))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

            // Fluid Storage Housing
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (2L)),
                            MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.plate, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.screw, (int) (2L)))
                    .circuit(3).itemOutputs(getModItem(AE2FluidCraft.ID, "fluid_storage_housing", 1, 0))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.Nitinol60, Shapes.plate, (int) (2)),
                            MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.plate, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.screw, (int) (2L)))
                    .circuit(3).itemOutputs(getModItem(AE2FluidCraft.ID, "fluid_storage_housing", 1, 1))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
            // Multi Fluid Storage Housing
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (2L)),
                            MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.plate, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.screw, (int) (2L)))
                    .circuit(3).itemOutputs(getModItem(AE2FluidCraft.ID, "fluid_storage_housing", 1, 2))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.Zeron100, Shapes.plate, (int) (2)),
                            MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.plate, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.CertusQuartz, Shapes.screw, (int) (2L)))
                    .circuit(3).itemOutputs(getModItem(AE2FluidCraft.ID, "fluid_storage_housing", 1, 3))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        }
        // Wireless Connector
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (2L)),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4, 12),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 24),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 41))
                .circuit(2).itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockWirelessConnector", 1, 0))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        // Wireless Hub
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "tile.BlockWirelessConnector", 8, 0),
                        ItemList.Emitter_LuV.get(1))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockWirelessHub", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);
    }

    private void makeTinkersConstructRecipes() {
        if (!TinkerConstruct.isModLoaded()) {
            return;
        }

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Stone, 2L),
                        getModItem(TinkerConstruct.ID, "GlassPane", 2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Tin, 1L))
                .itemOutputs(getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowercobblestone", 1))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new OreDictItemStack("stickWood", 2),
                        getModItem(TinkerConstruct.ID, "GlassPane", 2),
                        new OreDictItemStack("wireGt01AnyCopper", 1))
                .itemOutputs(getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerwood", 1))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.SandStoneRod.get(2),
                        getModItem(TinkerConstruct.ID, "GlassPane", 2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Cupronickel, 1L))
                .itemOutputs(getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowersandstone", 1))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 2),
                        getModItem(TinkerConstruct.ID, "GlassPane", 2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Nickel, 1L))
                .itemOutputs(getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerstone", 1))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.NetherQuartz, Shapes.stick, (int) (2L)),
                        getModItem(TinkerConstruct.ID, "GlassPane", 2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Silver, 1L))
                .itemOutputs(getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerquartz", 1))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.stick, (int) (2L)),
                        getModItem(TinkerConstruct.ID, "GlassPane", 2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Electrum, 1L))
                .itemOutputs(getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepoweriron", 1))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.stick, (int) (2L)),
                        getModItem(TinkerConstruct.ID, "GlassPane", 2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Aluminium, 1L))
                .itemOutputs(getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowergold", 1))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Emerald, Shapes.stick, (int) (2L)),
                        getModItem(TinkerConstruct.ID, "GlassPane", 2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Nichrome, 1L))
                .itemOutputs(getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepoweremerald", 1))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.stick, (int) (2L)),
                        getModItem(TinkerConstruct.ID, "GlassPane", 2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Platinum, 1L))
                .itemOutputs(getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerdiamond", 1))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Assembler

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "slime.gel", 1, 1),
                        getModItem(IndustrialCraft2.ID, "blockITNT", 1, 0))
                .circuit(1).itemOutputs(getModItem(TinkerConstruct.ID, "explosive.slime", 1, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "slime.gel", 1, 0),
                        getModItem(TinkerConstruct.ID, "explosive.slime", 1, 0))
                .circuit(1).itemOutputs(getModItem(TinkerConstruct.ID, "explosive.slime", 1, 2)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plateDense, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.screw, (int) (4L)))
                .circuit(1).itemOutputs(getModItem(TinkerConstruct.ID, "heartCanister", 1, 0)).duration(2 * MINUTES)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

    }

    private void makeForestryRecipes() {
        if (!Forestry.isModLoaded()) {
            return;
        }

        ItemStack alveary = getModItem(Forestry.ID, "alveary", 1, 0);

        // Impregnated Frame
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Railcraft.ID, "slab", 3, 38),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1),
                        getModItem(Forestry.ID, "oakStick", 5, 0))
                .itemOutputs(getModItem(Forestry.ID, "frameImpregnated", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.SeedOil, FluidShapes.fluidLiquid, (int) (250L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);

        // Apiary
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "frameImpregnated", 1, 0),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.screw, (int) (2L)),
                        GTOreDictUnificator.get(OrePrefixes.slab, Materials.Wood, 2L),
                        getModItem(Forestry.ID, "beeCombs", 1, WILDCARD),
                        getModItem(Forestry.ID, "apiculture", 2, 2),
                        new OreDictItemStack("fenceWood", 2))
                .itemOutputs(getModItem(Forestry.ID, "apiculture", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.SeedOil, FluidShapes.fluidLiquid, (int) (1000L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);

        // Scented Paneling

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.wireFine, (int) (2L)),
                        getModItem(Forestry.ID, "royalJelly", 1, 0),
                        getModItem(Forestry.ID, "oakStick", 3, 0),
                        getModItem(Forestry.ID, "beeswax", 2, 0),
                        getModItem(Forestry.ID, "pollen", 1, WILDCARD))
                .itemOutputs(getModItem(Forestry.ID, "craftingMaterial", 1, 6))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Honey, FluidShapes.fluidLiquid, (int) (1000L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        // Swarmer

        GTValues.RA.stdBuilder()
                .itemInputs(
                        alveary,
                        getModItem(Forestry.ID, "thermionicTubes", 4, 5),
                        MaterialLibAPI.getStack(Materials.RoseGold, Shapes.foil, (int) (2L)),
                        getModItem(Forestry.ID, "royalJelly", 2, 0),
                        getModItem(Forestry.ID, "frameProven", 1, 0))
                .itemOutputs(getModItem(Forestry.ID, "alveary", 1, 2))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Honey, FluidShapes.fluidLiquid, (int) (5000L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Alveary Fan

        GTValues.RA.stdBuilder()
                .itemInputs(
                        alveary,
                        getModItem(Forestry.ID, "thermionicTubes", 4, 11),
                        BlockList.SteelBars.get(3),
                        MaterialLibAPI.getStack(Materials.Bronze, Shapes.rotor, (int) (1L)),
                        ItemList.Electric_Motor_MV.get(1L))
                .itemOutputs(getModItem(Forestry.ID, "alveary", 1, 3))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Honey, FluidShapes.fluidLiquid, (int) (5000L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Alveary Heater

        GTValues.RA.stdBuilder()
                .itemInputs(
                        alveary,
                        getModItem(Forestry.ID, "thermionicTubes", 4, 7),
                        BlockList.SteelBars.get(),
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 3),
                        ItemList.Electric_Motor_MV.get(1L))
                .itemOutputs(getModItem(Forestry.ID, "alveary", 1, 4))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Honey, FluidShapes.fluidLiquid, (int) (5000L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Alveary Hygroregulator

        GTValues.RA.stdBuilder()
                .itemInputs(
                        alveary,
                        getModItem(Forestry.ID, "thermionicTubes", 4, 6),
                        Circuits.MV.get(1),
                        getModItem(BuildCraftFactory.ID, "tankBlock", 2, 0),
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1L),
                        MaterialLibAPI.getStack(Materials.RedAlloy, Shapes.plate, (int) (1L)))
                .itemOutputs(getModItem(Forestry.ID, "alveary", 1, 5))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Honey, FluidShapes.fluidLiquid, (int) (5000L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Alveary Stabiliser

        GTValues.RA.stdBuilder()
                .itemInputs(
                        alveary,
                        getModItem(Forestry.ID, "thermionicTubes", 4, 4),
                        NHItemList.ChargedCertusQuartzPlate.get(2),
                        ItemList.Component_Filter.get(2L),
                        getModItem(Forestry.ID, "royalJelly", 1, 0))
                .itemOutputs(getModItem(Forestry.ID, "alveary", 1, 6))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Honey, FluidShapes.fluidLiquid, (int) (5000L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Alveary Sieve

        GTValues.RA.stdBuilder()
                .itemInputs(
                        alveary,
                        getModItem(Forestry.ID, "thermionicTubes", 4, 9),
                        getModItem(Forestry.ID, "craftingMaterial", 4, 3),
                        getModItem(Forestry.ID, "pollenFertile", 1, WILDCARD))
                .itemOutputs(getModItem(Forestry.ID, "alveary", 1, 7))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Honey, FluidShapes.fluidLiquid, (int) (5000L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

    }

    private void makeOpenComputersRecipes() {
        if (!OpenComputers.isModLoaded()) {
            return;
        }
        // cable

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1),
                        MaterialLibAPI.getStack(Materials.RedstoneAlloy, Shapes.dustTiny, (int) (1)))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "cable", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1),
                        MaterialLibAPI.getStack(Materials.Emerald, Shapes.dustTiny, (int) (1)))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "cable", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 9),
                        MaterialLibAPI.getStack(Materials.RedstoneAlloy, Shapes.dust, (int) (1)))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "cable", 9, 0)).duration(90 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 9),
                        MaterialLibAPI.getStack(Materials.Emerald, Shapes.dust, (int) (1)))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "cable", 9, 0)).duration(90 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        // keyboard

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone_button, 64),
                        new ItemStack(Blocks.stone_button, 40),
                        Circuits.LV.get(1),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.itemCasing, (int) (1L)))
                .itemOutputs(getModItem(OpenComputers.ID, "keyboard", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        // case 1

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_MV.get(1L),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (2)),
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "item", 1, 24),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.rotor, (int) (2)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.itemCasing, (int) (2L)))
                .itemOutputs(getModItem(OpenComputers.ID, "case1", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // case 2

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_HV.get(1L),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (2)),
                        ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "item", 1, 25),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.rotor, (int) (2)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.itemCasing, (int) (2L)))
                .itemOutputs(getModItem(OpenComputers.ID, "case2", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        // case 3

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_EV.get(1L),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (2)),
                        ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "item", 1, 26),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.rotor, (int) (2)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.itemCasing, (int) (2L)))
                .itemOutputs(getModItem(OpenComputers.ID, "case3", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // micro case 1

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_MV.get(1L),
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "item", 1, 25),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.itemCasing, (int) (2L)))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 82))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // mirco case 2

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_HV.get(1L),
                        ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "item", 1, 26),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.itemCasing, (int) (2L)))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 86))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        // drone case 1

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "item", 1, 82),
                        getModItem(OpenComputers.ID, "item", 1, 71),
                        getModItem(OpenComputers.ID, "item", 2, 25),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.rotor, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.itemCasing, (int) (1L)),
                        ItemList.Electric_Motor_HV.get(4L))
                .itemOutputs(getModItem(OpenComputers.ID, "item", 1, 83))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        // drone case 2

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "item", 1, 86),
                        getModItem(OpenComputers.ID, "item", 1, 72),
                        getModItem(OpenComputers.ID, "item", 2, 26),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.rotor, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.itemCasing, (int) (1L)),
                        ItemList.Electric_Motor_EV.get(4L))
                .itemOutputs(getModItem(OpenComputers.ID, "item", 1, 87))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Card

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.stick, (int) (1)),
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.foil, (int) (1)))
                .circuit(2).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 33)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        // floppy

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "item", 1, 19),
                        MaterialLibAPI.getStack(Materials.Plastic, Shapes.foil, (int) (4)))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 4)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        // HDD 1

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.itemCasing, (int) (2L)),
                        getModItem(OpenComputers.ID, "item", 2, 19),
                        getModItem(OpenComputers.ID, "item", 2, 24),
                        getModItem(OpenComputers.ID, "item", 4, 1))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 5)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // HDD 2

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.itemCasing, (int) (2L)),
                        getModItem(OpenComputers.ID, "item", 4, 19),
                        getModItem(OpenComputers.ID, "item", 2, 25),
                        getModItem(OpenComputers.ID, "item", 4, 2))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 6)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        // HDD 3

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.itemCasing, (int) (2L)),
                        getModItem(OpenComputers.ID, "item", 8, 19),
                        getModItem(OpenComputers.ID, "item", 2, 26),
                        getModItem(OpenComputers.ID, "item", 4, 38))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 7)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // disk

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Glass, Shapes.lens, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.foil, (int) (4)))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 19))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Cobalt, FluidShapes.fluidMolten, (int) (36L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // rack

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "relay", 1, 0),
                        getModItem(OpenComputers.ID, "powerDistributor", 1, 0),
                        getModItem(OpenComputers.ID, "item", 1, 13),
                        ItemList.Circuit_Board_Plastic_Advanced.get(2L),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.rotor, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.itemCasing, (int) (4L)),
                        BlockList.SteelBars.get(2))
                .itemOutputs(getModItem(OpenComputers.ID, "rack", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        // adapter block

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_LV.get(1L),
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "cable", 2, 0),
                        getModItem(OpenComputers.ID, "item", 1, 24))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "adapter", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // assembler

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_HV.get(1L),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (2)),
                        ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "item", 1, 25),
                        ItemList.Robot_Arm_LV.get(3L))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "assembler", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        // disassembler

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_HV.get(1L),
                        getModItem(OpenComputers.ID, "item", 1, 0),
                        getModItem(OpenComputers.ID, "item", 1, 28),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (4)),
                        getModItem(OpenComputers.ID, "item", 1, 25),
                        ItemList.Robot_Arm_HV.get(2L))
                .itemOutputs(getModItem(OpenComputers.ID, "disassembler", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        // capacitor

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_LV.get(2L),
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 7),
                        ItemList.Circuit_Board_Plastic_Advanced.get(2L),
                        ItemList.Circuit_Parts_Transistor.get(1L),
                        getModItem(OpenComputers.ID, "cable", 2))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "capacitor", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // charger

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_HV.get(1L),
                        getModItem(IndustrialCraft2.ID, "blockChargepad", 2, 2),
                        ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "item", 1, 26),
                        getModItem(OpenComputers.ID, "cable", 2))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "charger", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        // diskDrive

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_LV.get(1L),
                        getModItem(OpenComputers.ID, "item", 3, 24),
                        ItemList.Electric_Motor_MV.get(1L),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.springSmall, (int) (1)),
                        MaterialLibAPI.getStack(Materials.IronMagnetic, Shapes.stick, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Glass, Shapes.lens, (int) (1)))
                .itemOutputs(getModItem(OpenComputers.ID, "diskDrive", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // diskDriver

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "diskDrive", 1, 0),
                        getModItem(OpenComputers.ID, "item", 1, 24),
                        ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                        BlockList.SteelBars.get(2),
                        MaterialLibAPI.getStack(Materials.Obsidian, Shapes.plate, (int) (4)))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 109))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // geolyzer

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_MV.get(1L),
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "item", 1, 25),
                        getModItem(OpenComputers.ID, "item", 1, 0),
                        ItemList.Sensor_MV.get(2L),
                        MaterialLibAPI.getStack(Materials.EnderEye, Shapes.lens, (int) (2)))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "geolyzer", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // hologram1

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic_Advanced.get(2L),
                        getModItem(OpenComputers.ID, "item", 2, 25),
                        MaterialLibAPI.getStack(Materials.Plastic, Shapes.plate, (int) (2)),
                        getModItem(OpenComputers.ID, "cable", 2, 0),
                        MaterialLibAPI.getStack(Materials.Obsidian, Shapes.plate, (int) (2)),
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.lens, (int) (1)))
                .circuit(10).itemOutputs(getModItem(OpenComputers.ID, "hologram1", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // hologram2

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Epoxy_Advanced.get(2L),
                        getModItem(OpenComputers.ID, "item", 2, 26),
                        MaterialLibAPI.getStack(Materials.Plastic, Shapes.plate, (int) (2)),
                        getModItem(OpenComputers.ID, "cable", 2, 0),
                        MaterialLibAPI.getStack(Materials.Obsidian, Shapes.plate, (int) (4)),
                        MaterialLibAPI.getStack(Materials.Emerald, Shapes.lens, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Ruby, Shapes.lens, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Sapphire, Shapes.lens, (int) (1)))
                .circuit(10).itemOutputs(getModItem(OpenComputers.ID, "hologram2", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        // motionSensor

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "item", 1, 42),
                        MaterialLibAPI.getStack(Materials.Plastic, Shapes.plate, (int) (2)),
                        getModItem(OpenComputers.ID, "cable", 2, 0),
                        new ItemStack(Blocks.daylight_detector, 2, 0))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "motionSensor", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // netSplitter

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_LV.get(1L),
                        ItemList.Circuit_Board_Plastic_Advanced.get(2L),
                        MaterialLibAPI.getStack(Materials.Plastic, Shapes.plate, (int) (4)),
                        getModItem(OpenComputers.ID, "cable", 3, 0),
                        ItemList.Electric_Piston_LV.get(1L))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "netSplitter", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        // printer

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Machine_HV_Printer.get(1L),
                        ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "item", 1, 26),
                        MaterialLibAPI.getStack(Materials.Plastic, Shapes.plate, (int) (4)),
                        getModItem(OpenComputers.ID, "cable", 2, 0))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "printer", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        // powerConverter

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_HV_MV.get(1L),
                        ItemList.Circuit_Board_Plastic_Advanced.get(2L),
                        getModItem(OpenComputers.ID, "item", 2, 24),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (2)),
                        getModItem(OpenComputers.ID, "cable", 2, 0))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "powerConverter", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // powerDistributor

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_MV.get(1L),
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 7),
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (2)),
                        getModItem(OpenComputers.ID, "cable", 2, 0),
                        Circuits.EV.get(2))
                .itemOutputs(getModItem(OpenComputers.ID, "powerDistributor", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        // raid

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "diskDrive", 1, 0),
                        getModItem(OpenComputers.ID, "item", 1, 43),
                        getModItem(OpenComputers.ID, "item", 2, 1),
                        getModItem(OpenComputers.ID, "item", 1, 25),
                        MaterialLibAPI.getStack(Materials.Plastic, Shapes.plate, (int) (4)),
                        getModItem(OpenComputers.ID, "cable", 2, 0))
                .itemOutputs(getModItem(OpenComputers.ID, "raid", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        // redstone

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_MV.get(1L),
                        ItemList.Circuit_Board_Plastic_Advanced.get(2L),
                        getModItem(OpenComputers.ID, "item", 2, 25),
                        MaterialLibAPI.getStack(Materials.Redstone, Shapes.plate, (int) (2)),
                        getModItem(OpenComputers.ID, "item", 1, 66),
                        ItemList.Cover_ActivityDetector.get(1L))
                .itemOutputs(getModItem(OpenComputers.ID, "redstone", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // relay

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_MV.get(1L),
                        ItemList.Circuit_Board_Plastic_Advanced.get(2L),
                        MaterialLibAPI.getStack(Materials.Plastic, Shapes.plate, (int) (2)),
                        getModItem(OpenComputers.ID, "item", 1, 13),
                        getModItem(OpenComputers.ID, "item", 1, 25),
                        getModItem(OpenComputers.ID, "cable", 2, 0))
                .itemOutputs(getModItem(OpenComputers.ID, "relay", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        // waypoint

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_MV.get(1L),
                        getModItem(OpenComputers.ID, "item", 1, 48),
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "item", 1, 24),
                        ItemList.Circuit_Parts_Transistor.get(2L),
                        getModItem(OpenComputers.ID, "cable", 2, 0))
                .itemOutputs(getModItem(OpenComputers.ID, "waypoint", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        // cartridge empty

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "item", 1, 24),
                        ItemList.Circuit_Parts_Transistor.get(2L),
                        GTOreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Plastic, 8),
                        MaterialLibAPI.getStack(Materials.Electrum, Shapes.bolt, (int) (8L)))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 94))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (36L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        // cartridge full

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "item", 1, 94),
                        ItemList.Color_00.get(1L),
                        ItemList.Color_06.get(1L),
                        ItemList.Color_11.get(1L),
                        ItemList.Color_13.get(1L))
                .itemOutputs(getModItem(OpenComputers.ID, "item", 1, 95)).fluidInputs(GTUtility.getWater(1000L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        // Interweb

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Plastic, Shapes.plate, (int) (1)),
                        new ItemStack(Items.string, 8, 0))
                .circuit(2).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 48))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glue, FluidShapes.fluidLiquid, (int) (576L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        // Linked Card

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "item", 2, 13),
                        getModItem(OpenComputers.ID, "item", 2, 28),
                        getModItem(OpenComputers.ID, "item", 1, 48))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 2, 51))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 250)).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        // Manual

        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.book, 1, 0), getModItem(OpenComputers.ID, "item", 1, 24)).circuit(1)
                .itemOutputs(getModItem(OpenComputers.ID, "item", 1, 98))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glue, FluidShapes.fluidLiquid, (int) (144L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Nano Machine

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "capacitor", 1, 0),
                        getModItem(OpenComputers.ID, "item", 2, 2),
                        getModItem(OpenComputers.ID, "item", 1, 13),
                        getModItem(OpenComputers.ID, "item", 2, 42),
                        getModItem(OpenComputers.ID, "item", 1, 18),
                        getModItem(OpenComputers.ID, "item", 9, 96))
                .itemOutputs(getModItem(OpenComputers.ID, "item", 1, 107))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (144L)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        // Server Tier 1

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "case1", 1, 0),
                        getModItem(OpenComputers.ID, "item", 2, 24),
                        getModItem(OpenComputers.ID, "item", 1, 25),
                        getModItem(OpenComputers.ID, "item", 1, 3))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 45))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (144L)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        // Server Tier 2

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "case2", 1, 0),
                        getModItem(OpenComputers.ID, "item", 2, 25),
                        getModItem(OpenComputers.ID, "item", 1, 26),
                        getModItem(OpenComputers.ID, "item", 2, 38))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 46))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (144L)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Server Tier 3

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "case3", 1, 0),
                        getModItem(OpenComputers.ID, "item", 2, 26),
                        Circuits.IV.get(1),
                        getModItem(OpenComputers.ID, "item", 2, 39))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 40))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (144L)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_EV / 2).addTo(assemblerRecipes);
        // Tablet Case Tier 1

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "screen2", 1, 0),
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "item", 2, 25),
                        getModItem(OpenComputers.ID, "item", 1, 70),
                        getModItem(OpenComputers.ID, "item", 2, 24),
                        MaterialLibAPI.getStack(Materials.Electrum, Shapes.foil, (int) (4L)))
                .itemOutputs(getModItem(OpenComputers.ID, "item", 1, 74))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Tablet Case Tier 2

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "screen2", 1, 0),
                        ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "item", 2, 26),
                        getModItem(OpenComputers.ID, "item", 1, 72),
                        getModItem(OpenComputers.ID, "item", 2, 25),
                        MaterialLibAPI.getStack(Materials.Electrum, Shapes.foil, (int) (4L)))
                .itemOutputs(getModItem(OpenComputers.ID, "item", 1, 92))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        // remote Monitor

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "screen2", 1, 0),
                        getModItem(OpenComputers.ID, "item", 1, 34),
                        getModItem(OpenComputers.ID, "item", 1, 13),
                        getModItem(OpenComputers.ID, "item", 2, 26),
                        getModItem(OpenComputers.ID, "keyboard", 1, 0))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 41))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (144L)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Terminal Server

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "item", 3, 13),
                        getModItem(OpenComputers.ID, "item", 2, 25),
                        MaterialLibAPI.getStack(Materials.Obsidian, Shapes.plate, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Electrum, Shapes.bolt, (int) (16L)))
                .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 108))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Open Printers
        // Printer

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Machine_MV_Printer.get(1L),
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "item", 2, 24))
                .circuit(1).itemOutputs(getModItem(OpenPrinters.ID, "openprinter.printer", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Shredder

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Machine_MV_Macerator.get(1L),
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "item", 2, 24))
                .circuit(1).itemOutputs(getModItem(OpenPrinters.ID, "openprinter.shredder", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Paper Roll

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.paper, 64, 0),
                        new ItemStack(Items.paper, 64, 0),
                        new ItemStack(Items.paper, 64, 0),
                        new ItemStack(Items.paper, 64, 0))
                .circuit(12).itemOutputs(getModItem(OpenPrinters.ID, "openprinter.printerPaperRoll", 1, 0))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        // Black Ink Cartridge

        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenComputers.ID, "item", 1, 94), ItemList.Color_00.get(3L))
                .circuit(2).itemOutputs(getModItem(OpenPrinters.ID, "openprinter.printerInkBlack", 1, 0))
                .fluidInputs(GTUtility.getWater(1000L)).duration(15 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenPrinters.ID, "openprinter.printerInkBlack", 1, WILDCARD),
                        ItemList.Color_00.get(3L))
                .circuit(2).itemOutputs(getModItem(OpenPrinters.ID, "openprinter.printerInkBlack", 1, 0))
                .fluidInputs(GTUtility.getWater(1000L)).duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // Color Ink Cartridge

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "item", 1, 94),
                        ItemList.Color_06.get(1L),
                        ItemList.Color_11.get(1L),
                        ItemList.Color_13.get(1L))
                .circuit(2).itemOutputs(getModItem(OpenPrinters.ID, "openprinter.printerInkColor", 1, 0))
                .fluidInputs(GTUtility.getWater(1000L)).duration(15 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenPrinters.ID, "openprinter.printerInkColor", 1, WILDCARD),
                        ItemList.Color_06.get(1L),
                        ItemList.Color_11.get(1L),
                        ItemList.Color_13.get(1L))
                .circuit(2).itemOutputs(getModItem(OpenPrinters.ID, "openprinter.printerInkColor", 1, 0))
                .fluidInputs(GTUtility.getWater(1000L)).duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // Open Security
        // Magnetic Card Reader

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "item", 2, 25),
                        getModItem(OpenComputers.ID, "cable", 2, 0),
                        ItemList.Circuit_Parts_Transistor.get(2L))
                .circuit(2).itemOutputs(getModItem(OpenSecurity.ID, "magreader", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        // RFID Reader

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenSecurity.ID, "opensecurity.rfidReaderCard", 1, 0),
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "item", 1, 25),
                        getModItem(OpenComputers.ID, "cable", 2, 0))
                .circuit(2).itemOutputs(getModItem(OpenSecurity.ID, "rfidreader", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Card writer

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "item", 2, 25),
                        getModItem(OpenComputers.ID, "item", 1, 1),
                        getModItem(OpenComputers.ID, "item", 1, 28),
                        getModItem(OpenComputers.ID, "cable", 2, 0),
                        ItemList.Circuit_Parts_Transistor.get(2L))
                .itemOutputs(getModItem(OpenSecurity.ID, "rfidwriter", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Alarm

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.noteblock, 1, 0),
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "item", 1, 25),
                        getModItem(OpenComputers.ID, "cable", 2, 0))
                .circuit(1).itemOutputs(getModItem(OpenSecurity.ID, "alarm", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Entity Detector

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "item", 1, 33),
                        getModItem(OpenComputers.ID, "item", 2, 25),
                        getModItem(OpenComputers.ID, "item", 1, 1),
                        getModItem(OpenComputers.ID, "item", 1, 28))
                .circuit(1).itemOutputs(getModItem(OpenSecurity.ID, "entitydetector", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Door Controler

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "item", 1, 28),
                        getModItem(OpenComputers.ID, "item", 2, 25),
                        ItemList.Circuit_Parts_Transistor.get(2L),
                        MaterialLibAPI.getStack(Materials.Obsidian, Shapes.plate, (int) (4L)))
                .circuit(1).itemOutputs(getModItem(OpenSecurity.ID, "doorcontroller", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Data Block

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "item", 1, 104),
                        getModItem(OpenComputers.ID, "item", 1, 25),
                        getModItem(OpenComputers.ID, "cable", 1, 0))
                .circuit(1).itemOutputs(getModItem(OpenSecurity.ID, "opensecurity.DataBlock", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // swtichable Hub

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "relay", 1, 0),
                        getModItem(OpenComputers.ID, "item", 2, 25),
                        getModItem(OpenComputers.ID, "cable", 4, 0),
                        ItemList.Circuit_Parts_Transistor.get(2L))
                .circuit(1).itemOutputs(getModItem(OpenSecurity.ID, "opensecurity.SwitchableHub", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // kvm Hub

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "relay", 1, 0),
                        getModItem(OpenComputers.ID, "item", 2, 25),
                        getModItem(OpenComputers.ID, "cable", 4, 0),
                        ItemList.Circuit_Parts_Transistor.get(2L))
                .circuit(2).itemOutputs(getModItem(OpenSecurity.ID, "opensecurity.BlockKVM", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // energy turret

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenModularTurrets.ID, "laserTurret", 1, 0),
                        getModItem(OpenComputers.ID, "item", 4, 25),
                        getModItem(OpenComputers.ID, "cable", 4, 0),
                        ItemList.Circuit_Parts_Transistor.get(2L))
                .circuit(2).itemOutputs(getModItem(OpenSecurity.ID, "energyTurretBlock", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // keypad

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "keyboard", 1, 0),
                        getModItem(OpenComputers.ID, "item", 2, 24),
                        ItemList.Circuit_Parts_Transistor.get(2L),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.plate, (int) (4L)))
                .circuit(2).itemOutputs(getModItem(OpenSecurity.ID, "keypadLock", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // biometric reader

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Glass, Shapes.lens, (int) (4L)),
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "item", 2, 24),
                        ItemList.Circuit_Parts_Transistor.get(2L))
                .circuit(1).itemOutputs(getModItem(OpenSecurity.ID, "biometricScanner", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // magnetic stipe card

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Paper, 4L),
                        MaterialLibAPI.getStack(Materials.IronMagnetic, Shapes.dust, (int) (2L)),
                        ItemList.Circuit_Parts_Transistor.get(1L))
                .circuit(6).itemOutputs(getModItem(OpenSecurity.ID, "opensecurity.magCard", 2, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glue, FluidShapes.fluidLiquid, (int) (144L)))
                .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        // RFID Card

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Paper, 4L),
                        MaterialLibAPI.getStack(Materials.IronMagnetic, Shapes.dust, (int) (2L)),
                        getModItem(OpenComputers.ID, "item", 1, 24),
                        ItemList.Circuit_Parts_Transistor.get(1L))
                .circuit(7).itemOutputs(getModItem(OpenSecurity.ID, "opensecurity.rfidCard", 2, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glue, FluidShapes.fluidLiquid, (int) (144L)))
                .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        // RFID Reader Card

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "item", 1, 33),
                        getModItem(OpenComputers.ID, "item", 1, 13),
                        getModItem(OpenComputers.ID, "item", 2, 25),
                        getModItem(OpenComputers.ID, "item", 1, 1),
                        getModItem(OpenComputers.ID, "item", 1, 28))
                .circuit(2).itemOutputs(getModItem(OpenSecurity.ID, "opensecurity.rfidReaderCard", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Secure Network Card

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "item", 1, 11),
                        getModItem(OpenComputers.ID, "cable", 2, 0),
                        getModItem(OpenComputers.ID, "item", 1, 26))
                .circuit(1).itemOutputs(getModItem(OpenSecurity.ID, "opensecurity.secureNetworkCard", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        // Secure Door

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.iron_door, 1),
                        getModItem(OpenComputers.ID, "cable", 2, 0),
                        getModItem(OpenComputers.ID, "item", 1, 25),
                        ItemList.Circuit_Parts_Transistor.get(1L),
                        MaterialLibAPI.getStack(Materials.Obsidian, Shapes.plate, (int) (4L)))
                .circuit(1).itemOutputs(getModItem(OpenSecurity.ID, "opensecurity.securityDoor", 1, 0))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Secure Private Door

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.iron_door, 1),
                        getModItem(OpenComputers.ID, "cable", 2, 0),
                        getModItem(OpenComputers.ID, "item", 1, 25),
                        ItemList.Circuit_Parts_Transistor.get(1L),
                        MaterialLibAPI.getStack(Materials.Obsidian, Shapes.plate, (int) (4L)))
                .circuit(2).itemOutputs(getModItem(OpenSecurity.ID, "opensecurity.securityDoorPrivate", 1, 0))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Damage Upgrade

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        new ItemStack(Blocks.tnt, 1, 0),
                        getModItem(OpenComputers.ID, "item", 1, 24))
                .circuit(1).itemOutputs(getModItem(OpenSecurity.ID, "opensecurity.damageUpgrade", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Redstone, FluidShapes.fluidMolten, (int) (72L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        // Cooldown upgrade

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        GTModHandler.getIC2Item("reactorCoolantSimple", 1L, 1),
                        getModItem(OpenComputers.ID, "item", 1, 24))
                .circuit(1).itemOutputs(getModItem(OpenSecurity.ID, "opensecurity.cooldownUpgrade", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Redstone, FluidShapes.fluidMolten, (int) (72L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        // Energy Upgrade

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        getModItem(OpenComputers.ID, "item", 1, 63),
                        getModItem(OpenComputers.ID, "item", 1, 24))
                .circuit(1).itemOutputs(getModItem(OpenSecurity.ID, "opensecurity.energyUpgrade", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Redstone, FluidShapes.fluidMolten, (int) (72L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        // Movement Upgrade

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        ItemList.Electric_Piston_MV.get(1L),
                        getModItem(OpenComputers.ID, "item", 1, 24))
                .circuit(1).itemOutputs(getModItem(OpenSecurity.ID, "opensecurity.movementUpgrade", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Redstone, FluidShapes.fluidMolten, (int) (72L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        // OpenGlasses Terminal

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "geolyzer", 1, 0),
                        getModItem(OpenComputers.ID, "item", 1, 43),
                        getModItem(OpenComputers.ID, "item", 1, 38))
                .circuit(1).itemOutputs(getModItem(OpenGlasses.ID, "openglassesterminal", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (144L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // Open Glasses

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenComputers.ID, "screen3", 2, 0),
                        getModItem(OpenComputers.ID, "item", 1, 10),
                        getModItem(OpenComputers.ID, "item", 1, 13))
                .circuit(1).itemOutputs(getModItem(OpenGlasses.ID, "openglasses", 1, WILDCARD))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Plastic, FluidShapes.fluidMolten, (int) (72L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

    }

    private void makeJabbaRecipes() {
        if (!JABBA.isModLoaded()) {
            return;
        }
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "barrel", 1, 0),
                        MaterialLibAPI.getStack(Materials.Wood, Shapes.plate, (int) (2)),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2))
                .circuit(13).itemOutputs(getModItem(JABBA.ID, "upgradeStructural", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "barrel", 1, 0),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.plate, (int) (2)),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.stick, (int) (2)))
                .circuit(13).itemOutputs(getModItem(JABBA.ID, "upgradeStructural", 1, 1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "barrel", 1, 0),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.plate, (int) (2)),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.stick, (int) (2)))
                .circuit(13).itemOutputs(getModItem(JABBA.ID, "upgradeStructural", 1, 2)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "barrel", 1, 0),
                        MaterialLibAPI.getStack(Materials.Bronze, Shapes.plate, (int) (2)),
                        MaterialLibAPI.getStack(Materials.Bronze, Shapes.stick, (int) (2)))
                .circuit(13).itemOutputs(getModItem(JABBA.ID, "upgradeStructural", 1, 3)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "barrel", 1, 0),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, (int) (2)),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.stick, (int) (2)))
                .circuit(13).itemOutputs(getModItem(JABBA.ID, "upgradeStructural", 1, 4)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "barrel", 1, 0),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (2)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.stick, (int) (2)))
                .circuit(13).itemOutputs(getModItem(JABBA.ID, "upgradeStructural", 1, 5)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "barrel", 1, 0),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (2)),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.stick, (int) (2)))
                .circuit(13).itemOutputs(getModItem(JABBA.ID, "upgradeStructural", 1, 6)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "barrel", 1, 0),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (2)),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.stick, (int) (2)))
                .circuit(13).itemOutputs(getModItem(JABBA.ID, "upgradeStructural", 1, 7)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "barrel", 1, 0),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (2)),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.stick, (int) (2)))
                .circuit(13).itemOutputs(getModItem(JABBA.ID, "upgradeStructural", 1, 8)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "barrel", 1, 0),
                        MaterialLibAPI.getStack(Materials.RhodiumPlatedPalladium, Shapes.plate, (int) (2)),
                        MaterialLibAPI.getStack(Materials.RhodiumPlatedPalladium, Shapes.stick, (int) (2)))
                .circuit(13).itemOutputs(getModItem(JABBA.ID, "upgradeStructural", 1, 9)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "barrel", 1, 0),
                        MaterialLibAPI.getStack(Materials.Iridium, Shapes.plate, (int) (2)),
                        MaterialLibAPI.getStack(Materials.Iridium, Shapes.stick, (int) (2)))
                .circuit(13).itemOutputs(getModItem(JABBA.ID, "upgradeStructural", 1, 10)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "barrel", 1, 0),
                        MaterialLibAPI.getStack(Materials.Osmium, Shapes.plate, (int) (2)),
                        MaterialLibAPI.getStack(Materials.Osmium, Shapes.stick, (int) (2)))
                .circuit(13).itemOutputs(getModItem(JABBA.ID, "upgradeStructural", 1, 11)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "barrel", 1, 0),
                        MaterialLibAPI.getStack(Materials.Neutronium, Shapes.plate, (int) (2)),
                        MaterialLibAPI.getStack(Materials.Neutronium, Shapes.stick, (int) (2)))
                .circuit(13).itemOutputs(getModItem(JABBA.ID, "upgradeStructural", 1, 12)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "barrel", 1, 0),
                        MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.plate, (int) (2)),
                        MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.stick, (int) (2)))
                .circuit(13).itemOutputs(getModItem(JABBA.ID, "upgradeStructural", 1, 13)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(JABBA.ID, "upgradeCore", 1, 0), getModItem(JABBA.ID, "upgradeCore", 1, 3))
                .circuit(3).itemOutputs(getModItem(JABBA.ID, "upgradeSide", 1, 1)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(JABBA.ID, "upgradeCore", 1, 0), getModItem(JABBA.ID, "upgradeCore", 1, 2))
                .circuit(3).itemOutputs(getModItem(JABBA.ID, "upgradeSide", 1, 2)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
    }

    private void makeZTonesRecipes() {
        if (!ZTones.isModLoaded()) {
            return;
        }

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone_slab, 4), new ItemStack(Blocks.stone, 1))
                .circuit(1).itemOutputs(getModItem(ZTones.ID, "stoneTile", 8, 0)).duration(8 * SECONDS).eut(4)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.glass, 4), new ItemStack(Items.dye, 1, WILDCARD))
                .circuit(1).itemOutputs(getModItem(ZTones.ID, "auroraBlock", 8, 0)).duration(8 * SECONDS).eut(4)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Blocks.sand, 4, WILDCARD), new ItemStack(Blocks.dirt, 4, WILDCARD)).circuit(2)
                .itemOutputs(getModItem(ZTones.ID, "cleanDirt", 8, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.SeedOil, FluidShapes.fluidLiquid, (int) (5L)))
                .duration(8 * SECONDS).eut(4).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone_pressure_plate, 1)).circuit(1)
                .itemOutputs(getModItem(ZTones.ID, "booster", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Blaze, FluidShapes.fluidMolten, (int) (8L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        // This replaces the type of block, and the item used to make it for the 0-15 meta, and the 21+12 different
        // versions of ztones blocks (glaxx is separate)
        // Normal crafting recipes are not affected, so they might be crafted differently
        String[] blockName = { "agon", "azur", "bitt", "cray", "fort", "iszm", "jelt", "korp", "kryp", "lair", "lave",
                "mint", "myst", "reds", "reed", "roen", "sols", "sync", "tank", "vect", "vena" };
        String[] zblockName = { "zane", "zech", "zest", "zeta", "zion", "zkul", "zoea", "zome", "zone", "zorg", "ztyl",
                "zyth" };

        Map<String, ItemStack> itemMap = new HashMap<>();
        itemMap.put(blockName[0], ItemList.Color_07.get(1)); // agon
        itemMap.put(blockName[1], ItemList.Color_04.get(1)); // azur
        itemMap.put(blockName[2], new ItemStack(Blocks.wool, 1, 0)); // bitt
        itemMap.put(blockName[3], new ItemStack(Blocks.hardened_clay, 1, 0)); // cray
        itemMap.put(blockName[4], ItemList.Color_03.get(1)); // fort
        itemMap.put(blockName[5], ItemList.Color_08.get(1)); // iszm
        itemMap.put(blockName[6], new ItemStack(Items.gold_ingot, 1, 0));// jelt
        itemMap.put(blockName[7], new ItemStack(Blocks.obsidian, 1, 0)); // korp
        itemMap.put(blockName[8], new ItemStack(Blocks.soul_sand, 1, 0));// kryp
        itemMap.put(blockName[9], new ItemStack(Blocks.netherrack, 1, 0));// lair
        itemMap.put(blockName[10], new ItemStack(Blocks.ice, 1, 0));// lave
        itemMap.put(blockName[11], new ItemStack(Items.slime_ball, 1, 0));// mint
        itemMap.put(blockName[12], new ItemStack(Blocks.brown_mushroom, 1, 0));// myst
        itemMap.put(blockName[13], new ItemStack(Items.redstone, 1, 0));// reds
        itemMap.put(blockName[14], new ItemStack(Items.reeds, 1, 0));// reed
        itemMap.put(blockName[15], new ItemStack(Blocks.sandstone, 1, 0));// roen
        itemMap.put(blockName[16], new ItemStack(Items.blaze_powder, 1, 0));// sols
        itemMap.put(blockName[17], new ItemStack(Items.emerald, 1, 0));// sync
        itemMap.put(blockName[18], new ItemStack(Items.iron_ingot, 1, 0));// tank
        itemMap.put(blockName[19], new ItemStack(Items.ghast_tear, 1, 0));// vect
        itemMap.put(blockName[20], new ItemStack(Items.ender_pearl, 1, 0));// vena
        Map<String, ItemStack> zitemMap = new HashMap<>();
        zitemMap.put(zblockName[0], ItemList.Color_00.get(1)); // zane
        zitemMap.put(zblockName[1], ItemList.Color_01.get(1)); // zech
        zitemMap.put(zblockName[2], ItemList.Color_02.get(1)); // zest
        zitemMap.put(zblockName[3], ItemList.Color_05.get(1)); // zeta
        zitemMap.put(zblockName[4], ItemList.Color_06.get(1)); // zion
        zitemMap.put(zblockName[5], ItemList.Color_09.get(1)); // zkul
        zitemMap.put(zblockName[6], ItemList.Color_10.get(1)); // zoea
        zitemMap.put(zblockName[7], ItemList.Color_11.get(1)); // zome
        zitemMap.put(zblockName[8], ItemList.Color_12.get(1)); // zone
        zitemMap.put(zblockName[9], ItemList.Color_13.get(1)); // zorg
        zitemMap.put(zblockName[10], ItemList.Color_14.get(1)); // ztyl
        zitemMap.put(zblockName[11], ItemList.Color_15.get(1)); // zyth

        final int ztoneVariants = 16;

        final ItemStack ztoneStone = getModItem(ZTones.ID, "stoneTile", 4, 0);
        final ItemStack ztoneAurora = getModItem(ZTones.ID, "auroraBlock", 4, 0);

        for (String name : blockName) {
            for (int i = 0; i < ztoneVariants; i++) {
                GTValues.RA.stdBuilder().itemInputs(ztoneStone, itemMap.get(name)).circuit(i == 0 ? 24 : i)
                        .itemOutputs(getModItem(ZTones.ID, "tile." + name + "Block", 8, i)).duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
            }
        }
        for (String name : zblockName) {
            for (int i = 0; i < ztoneVariants; i++) {
                GTValues.RA.stdBuilder().itemInputs(ztoneAurora, zitemMap.get(name)).circuit(i == 0 ? 24 : i)
                        .itemOutputs(getModItem(ZTones.ID, "tile." + name + "Block", 8, i)).duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
            }
        }
        for (int i = 0; i < ztoneVariants; i++) {
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ZTones.ID, "auroraBlock", 1, 0), new ItemStack(Blocks.glass, 4, 0))
                    .circuit(i == 0 ? 24 : i).itemOutputs(getModItem(ZTones.ID, "tile.glaxx", 8, i))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        }
    }

    private void makeGalacticraftRocketRecipes() {
        if (!GalaxySpace.isModLoaded()) {
            return;
        }

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUIVBase, 30L),
                        GTOreDictUnificator.get(OrePrefixes.pipeTiny, Materials.TranscendentMetal, 20L),
                        ItemList.Electric_Pump_UIV.get(1L))
                .circuit(9).itemOutputs(GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUIV, 30))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("liquid helium"), 34000))
                .duration(2 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_UIV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 7),
                        getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 3))
                .itemOutputs(NHItemList.LeadOriharukonPlate.get(2))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(assemblerRecipes);

        // rocket parts

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalaxySpace.ID, "item.CompressedDualBronze", 1, 0),
                        getModItem(GalaxySpace.ID, "item.CompressedDualAluminium", 1, 0),
                        getModItem(GalaxySpace.ID, "item.CompressedCoal", 1, 0))
                .circuit(1).itemOutputs(NHItemList.RawSDHCAlloy.get())
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.StainlessSteel, FluidShapes.fluidMolten, (int) (72L)))
                .duration(20 * TICKS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalaxySpace.ID, "item.CompressedDualBronze", 1, 0),
                        getModItem(GalaxySpace.ID, "item.CompressedDualAluminium", 1, 0),
                        getModItem(GalaxySpace.ID, "item.ModuleSmallCanister", 1, 0))
                .circuit(2).itemOutputs(getModItem(GalaxySpace.ID, "item.ModuleSmallFuelCanister", 1, 0))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.StainlessSteel, FluidShapes.fluidMolten, (int) (72L)))
                .duration(20 * TICKS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalaxySpace.ID, "item.ModuleSmallFuelCanister", 1, 0),
                        NHItemList.TitaniumDualCompressedPlates.get(),
                        NHItemList.DeshDualCompressedPlates.get())
                .circuit(2).itemOutputs(NHItemList.MediumFuelCanister.get())
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Titanium, FluidShapes.fluidMolten, (int) (72L)))
                .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.MediumFuelCanister.get(),
                        NHItemList.QuantinumDualCompressedPlates.get(),
                        NHItemList.IceDualCompressedPlates.get())
                .circuit(2).itemOutputs(NHItemList.LargeFuelCanister.get())
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Chrome, FluidShapes.fluidMolten, (int) (72L)))
                .duration(20 * TICKS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.LargeFuelCanister.get(),
                        NHItemList.MytrylDualCompressedPlates.get(),
                        NHItemList.MysteriousCrystalDualCompressedPlates.get())
                .circuit(2).itemOutputs(NHItemList.ExtraLargeFuelCanister.get())
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Iridium, FluidShapes.fluidMolten, (int) (72L)))
                .duration(20 * TICKS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        // Engine

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalaxySpace.ID, "item.CompressedSDHD120", 2, 0),
                        getModItem(GalacticraftCore.ID, "item.heavyPlating", 4, 0),
                        getModItem(GalacticraftCore.ID, "item.oilCanisterPartial", 1, 1001),
                        ItemList.Casing_Firebox_Steel.get(1L),
                        ItemList.Cover_ActivityDetector.get(1L))
                .circuit(3).itemOutputs(getModItem(GalacticraftCore.ID, "item.engine", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "item.engine", 2, 1),
                        getModItem(GalacticraftCore.ID, "item.engine", 2, 0),
                        getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 5, 0))
                .circuit(3).itemOutputs(getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 1))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.Tier2Booster.get(2),
                        getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 2, 1),
                        NHItemList.HeavyDutyPlateTier5.get(5))
                .circuit(3).itemOutputs(NHItemList.HeavyDutyRocketEngineTier3.get()).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.Tier3Booster.get(2),
                        NHItemList.HeavyDutyRocketEngineTier3.get(2),
                        NHItemList.HeavyDutyPlateTier7.get(5))
                .circuit(3).itemOutputs(NHItemList.HeavyDutyRocketEngineTier4.get()).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        // nose cones

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedIllumination.ID, "projectred.illumination.cagelamp2.inv", 1, 14),
                        getModItem(GalacticraftCore.ID, "item.heavyPlating", 4, 0))
                .circuit(4).itemOutputs(getModItem(GalacticraftCore.ID, "item.noseCone", 1, 0))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.StainlessSteel, FluidShapes.fluidMolten, (int) (36L)))
                .duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "item.noseCone", 1, 0),
                        getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 4, 0))
                .circuit(4).itemOutputs(getModItem(GalacticraftMars.ID, "item.heavyNoseCone", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Titanium, FluidShapes.fluidMolten, (int) (36L)))
                .duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftMars.ID, "item.heavyNoseCone", 1, 0),
                        NHItemList.HeavyDutyPlateTier5.get(4))
                .circuit(4).itemOutputs(NHItemList.HeavyDutyNoseConeTier3.get())
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.TungstenSteel, FluidShapes.fluidMolten, (int) (36L)))
                .duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(NHItemList.HeavyDutyNoseConeTier3.get(), NHItemList.HeavyDutyPlateTier7.get(4)).circuit(4)
                .itemOutputs(NHItemList.HeavyDutyNoseConeTier4.get())
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.NaquadahAlloy, FluidShapes.fluidMolten, (int) (36L)))
                .duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        // rocket fins

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "item.basicItem", 2, 9),
                        getModItem(GalacticraftCore.ID, "item.heavyPlating", 4, 0))
                .circuit(5).itemOutputs(getModItem(GalacticraftCore.ID, "item.rocketFins", 1, 0))
                .duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftMars.ID, "item.null", 2, 3),
                        getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 4, 0))
                .circuit(5).itemOutputs(getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 2))
                .duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.HeavyDutyPlateTier4.get(2),
                        NHItemList.HeavyDutyPlateTier5.get(4),
                        getModItem(GalaxySpace.ID, "item.CompressedSDHD120", 1, 0))
                .circuit(5).itemOutputs(NHItemList.HeavyDutyRocketFinsTier3.get()).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.HeavyDutyPlateTier6.get(2),
                        NHItemList.HeavyDutyPlateTier7.get(4),
                        getModItem(GalaxySpace.ID, "item.CompressedSDHD120", 1, 0))
                .circuit(5).itemOutputs(NHItemList.HeavyDutyRocketFinsTier4.get()).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        // // booster

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftCore.ID, "item.meteoricIronIngot", 3, 1),
                        getModItem(GalacticraftCore.ID, "item.heavyPlating", 4, 0),
                        getModItem(GalacticraftCore.ID, "item.airVent", 1, 0))
                .circuit(6).itemOutputs(getModItem(GalacticraftCore.ID, "item.engine", 1, 1))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Fuel, FluidShapes.fluidLiquid, (int) (1000L)))
                .duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.LedoxCompressedPlate.get(3),
                        getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 4, 0),
                        getModItem(GalacticraftCore.ID, "item.engine", 1, 1),
                        getModItem(GalaxySpace.ID, "item.CompressedSDHD120", 1, 0))
                .circuit(6).itemOutputs(NHItemList.Tier2Booster.get()).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.MytrylCompressedPlate.get(3),
                        NHItemList.HeavyDutyPlateTier5.get(4),
                        NHItemList.Tier2Booster.get(),
                        getModItem(GalaxySpace.ID, "item.CompressedSDHD120", 1, 0))
                .circuit(6).itemOutputs(NHItemList.Tier3Booster.get()).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.BlackPlutoniumCompressedPlate.get(3),
                        NHItemList.HeavyDutyPlateTier7.get(4),
                        NHItemList.Tier3Booster.get(),
                        getModItem(GalaxySpace.ID, "item.CompressedSDHD120", 1, 0))
                .circuit(6).itemOutputs(NHItemList.Tier4Booster.get()).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

    }

    private void makeIronTanksRecipes() {
        if (!IronTanks.isModLoaded() || !BuildCraftFactory.isModLoaded()) {
            return;
        }
        // Copper Tank

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.plateDouble, (int) (1L)))
                .circuit(4).itemOutputs(getModItem(IronTanks.ID, "copperTank", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glass, FluidShapes.fluidMolten, (int) (144L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Iron Tank

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.plateDouble, (int) (1L)))
                .circuit(4).itemOutputs(getModItem(IronTanks.ID, "ironTank", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glass, FluidShapes.fluidMolten, (int) (144L)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Steel Tank

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plateDouble, (int) (1L)))
                .circuit(4).itemOutputs(getModItem(IronTanks.ID, "silverTank", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glass, FluidShapes.fluidMolten, (int) (144L)))
                .duration(25 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Gold Tank

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.plateDouble, (int) (1L)))
                .circuit(4).itemOutputs(getModItem(IronTanks.ID, "goldTank", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glass, FluidShapes.fluidMolten, (int) (144L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Diamond Tank

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.plate, (int) (1L)))
                .circuit(4).itemOutputs(getModItem(IronTanks.ID, "diamondTank", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glass, FluidShapes.fluidMolten, (int) (144L)))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Obsidian Tank

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Obsidian, 1L))
                .circuit(4).itemOutputs(getModItem(IronTanks.ID, "obsidianTank", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glass, FluidShapes.fluidMolten, (int) (144L)))
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Aluminium Tank

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plateDouble, (int) (1L)))
                .circuit(4).itemOutputs(getModItem(IronTanks.ID, "emeraldTank", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glass, FluidShapes.fluidMolten, (int) (144L)))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        // Stainless Steel Tank

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plateDouble, (int) (1L)))
                .circuit(4).itemOutputs(getModItem(IronTanks.ID, "stainlesssteelTank", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glass, FluidShapes.fluidMolten, (int) (144L)))
                .duration(55 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Titanium Tank

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plateDouble, (int) (1L)))
                .circuit(4).itemOutputs(getModItem(IronTanks.ID, "titaniumTank", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glass, FluidShapes.fluidMolten, (int) (144L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        // Tungsten Steel Tank

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plateDouble, (int) (1L)))
                .circuit(4).itemOutputs(getModItem(IronTanks.ID, "tungstensteelTank", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glass, FluidShapes.fluidMolten, (int) (144L)))
                .duration(1 * MINUTES + 5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // --- Upgrade Glass to Copper Tank

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Glass, Shapes.plate, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.plateDouble, (int) (1L)))
                .circuit(4).itemOutputs(getModItem(IronTanks.ID, "glassCopperUpgrade", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glass, FluidShapes.fluidMolten, (int) (72L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // --- Upgrade Glass to Iron Tank

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Glass, Shapes.plate, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.plateDouble, (int) (1L)))
                .circuit(4).itemOutputs(getModItem(IronTanks.ID, "glassIronUpgrade", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glass, FluidShapes.fluidMolten, (int) (72L)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // --- Upgrade Copper to Iron Tank

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.plate, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.plateDouble, (int) (1L)))
                .circuit(4).itemOutputs(getModItem(IronTanks.ID, "copperIronUpgrade", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glass, FluidShapes.fluidMolten, (int) (72L)))
                .duration(25 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // --- Upgrade Copper to Steel Tank

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.plate, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plateDouble, (int) (1L)))
                .circuit(4).itemOutputs(getModItem(IronTanks.ID, "copperSilverUpgrade", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glass, FluidShapes.fluidMolten, (int) (72L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // --- Upgrade Iron to Gold Tank

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.plate, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.plateDouble, (int) (1L)))
                .circuit(4).itemOutputs(getModItem(IronTanks.ID, "ironGoldUpgrade", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glass, FluidShapes.fluidMolten, (int) (72L)))
                .duration(35 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // --- Upgrade Steel to Gold Tank

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.plateDouble, (int) (1L)))
                .circuit(4).itemOutputs(getModItem(IronTanks.ID, "silverGoldUpgrade", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glass, FluidShapes.fluidMolten, (int) (72L)))
                .duration(35 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // --- Upgrade Steel to Diamond Tank

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.plate, (int) (2L)))
                .circuit(4).itemOutputs(getModItem(IronTanks.ID, "silverDiamondUpgrade", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glass, FluidShapes.fluidMolten, (int) (72L)))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // --- Upgrade Diamond to Obsidian

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.plate, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Obsidian, 1L))
                .circuit(4).itemOutputs(getModItem(IronTanks.ID, "diamondObsidianUpgrade", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glass, FluidShapes.fluidMolten, (int) (72L)))
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // --- Upgrade Diamond to Aluminium Tank

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.plate, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plateDouble, (int) (1L)))
                .circuit(4).itemOutputs(getModItem(IronTanks.ID, "diamondEmeraldUpgrade", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glass, FluidShapes.fluidMolten, (int) (72L)))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        // --- Upgrade Aluminium to Stainless Steel Tank

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plateDouble, (int) (1L)))
                .circuit(4).itemOutputs(getModItem(IronTanks.ID, "emeraldStainlesssteelUpgrade", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glass, FluidShapes.fluidMolten, (int) (72L)))
                .duration(55 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // --- Upgrade Stainless Steel to Titanium Tank

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plateDouble, (int) (1L)))
                .circuit(4).itemOutputs(getModItem(IronTanks.ID, "stainlesssteelTitaniumUpgrade", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glass, FluidShapes.fluidMolten, (int) (72L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        // --- Upgrade Titanium to Tungsten Steel Tank

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plateDouble, (int) (1L)))
                .circuit(4).itemOutputs(getModItem(IronTanks.ID, "titaniumTungstensteelUpgrade", 1, 0))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glass, FluidShapes.fluidMolten, (int) (72L)))
                .duration(1 * MINUTES + 5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
    }

    private void makeChiselRecipes() {
        if (!Chisel.isModLoaded()) {
            return;
        }
        // --- Items
        // Chisel

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.plate, (int) (2L)),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L))
                .circuit(1).itemOutputs(getModItem(Chisel.ID, "chisel", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Obsidian Chisel

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Obsidian, Shapes.plate, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.CastIron, Shapes.stick, (int) (2L)))
                .circuit(2).itemOutputs(getModItem(Chisel.ID, "obsidianChisel", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Diamond Chisel

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.plate, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.stick, (int) (2L)))
                .circuit(1).itemOutputs(getModItem(Chisel.ID, "diamondChisel", 1, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Nether Star Chisel

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Bedrockium, Shapes.plateDense, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.VanadiumSteel, Shapes.stickLong, (int) (2L)))
                .circuit(1).itemOutputs(getModItem(Chisel.ID, "netherStarChisel", 1, 0)).duration(20 * MINUTES)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        // --- Blocks
        // Factory Block

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone, 4),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.plate, (int) (4L)))
                .circuit(24).itemOutputs(getModItem(Chisel.ID, "factoryblock", 16, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Technical Block

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone, 5),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.plate, (int) (4L)))
                .circuit(11).itemOutputs(getModItem(Chisel.ID, "technical", 16, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Tyrian

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone, 4),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.plate, (int) (1L)))
                .circuit(14).itemOutputs(getModItem(Chisel.ID, "tyrian", 8, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Futura

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone, 4), new ItemStack(Items.redstone, 1))
                .circuit(24).itemOutputs(getModItem(Chisel.ID, "futura", 8, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Fantasy Block

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone, 4), new ItemStack(Items.gold_nugget, 1))
                .circuit(24).itemOutputs(getModItem(Chisel.ID, "fantasyblock", 8, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Grimstone

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone, 4), new ItemStack(Items.coal, 1)).circuit(24)
                .itemOutputs(getModItem(Chisel.ID, "grimstone", 8, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Hex Plating

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone, 2), new ItemStack(Items.coal, 4)).circuit(11)
                .itemOutputs(getModItem(Chisel.ID, "hexPlating", 4, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Holystone

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone, 4), new ItemStack(Items.feather, 1)).circuit(24)
                .itemOutputs(getModItem(Chisel.ID, "holystone", 8, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Laboratory Block

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone, 4), new ItemStack(Items.quartz, 1)).circuit(24)
                .itemOutputs(getModItem(Chisel.ID, "laboratoryblock", 8, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Lavastone

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone, 4)).circuit(24)
                .itemOutputs(getModItem(Chisel.ID, "lavastone", 8, 0)).fluidInputs(GTUtility.getLava(1000L))
                .duration(5 * SECONDS).eut(24).addTo(assemblerRecipes);
        // Paperwall

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.paper, 4),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L))
                .circuit(24).itemOutputs(getModItem(Chisel.ID, "paperwall", 8, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Paperwall Block

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.paper, 4),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L))
                .circuit(11).itemOutputs(getModItem(Chisel.ID, "paperwall_block", 8, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Road Lines

        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.redstone, 3), GTOreDictUnificator.get(ItemList.Dye_Bonemeal.get(3L)))
                .circuit(24).itemOutputs(getModItem(Chisel.ID, "road_line", 8, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Temple Block

        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Blocks.stone, 4), GTOreDictUnificator.get(new ItemStack(Items.dye, 1, 4)))
                .circuit(24).itemOutputs(getModItem(Chisel.ID, "templeblock", 8, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Mossy Temple Block

        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Chisel.ID, "templeblock", 8, 0), getModItem(BiomesOPlenty.ID, "moss", 8, 0))
                .circuit(24).itemOutputs(getModItem(Chisel.ID, "mossy_templeblock", 4, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Blocks.stone, 4), GTOreDictUnificator.get(new ItemStack(Items.dye, 1, 9)))
                .circuit(24).itemOutputs(getModItem(Chisel.ID, "valentines", 8, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Voidstone

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone, 2),
                        new ItemStack(Blocks.obsidian, 2),
                        new ItemStack(Items.ender_pearl, 1))
                .circuit(24).itemOutputs(getModItem(Chisel.ID, "voidstone", 8, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Energised Voidstone

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone, 2),
                        new ItemStack(Blocks.obsidian, 2),
                        new ItemStack(Items.ender_pearl, 1),
                        new ItemStack(Items.glowstone_dust, 1))
                .circuit(11).itemOutputs(getModItem(Chisel.ID, "voidstone2", 8, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Warning Sign

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone, 2), new ItemStack(Items.sign, 1)).circuit(24)
                .itemOutputs(getModItem(Chisel.ID, "warningSign", 4, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        // Waterstone

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone, 4)).circuit(24)
                .itemOutputs(getModItem(Chisel.ID, "waterstone", 8, 0)).fluidInputs(GTUtility.getWater(1000L))
                .duration(5 * SECONDS).eut(24).addTo(assemblerRecipes);

        // Hempcrete Sand
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.gravel, 3, 0),
                        GTOreDictUnificator.get("sand", 3L),
                        GTOreDictUnificator.get("itemWheat", 2L),
                        ItemList.IC2_Plantball.get(1L))
                .itemOutputs(getModItem(Chisel.ID, "hempcretesand", 12)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // Anti Block
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone, 4), new ItemStack(Items.glowstone_dust, 1))
                .circuit(24).itemOutputs(getModItem(Chisel.ID, "antiBlock", 8, 15)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);

        // Carpet
        for (int meta = 0; meta < 16; ++meta) {
            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.wool, 4, meta), new ItemStack(Items.string, 1))
                    .circuit(24).itemOutputs(getModItem(Chisel.ID, "carpet_block", 8, meta)).duration(5 * SECONDS)
                    .eut(24).addTo(assemblerRecipes);
        }

        // Cubits
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone, 4), new ItemStack(Blocks.wool, 1, 15))
                .circuit(24).itemOutputs(getModItem(Chisel.ID, "cubit", 8, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);

        // Fantasy Block
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone, 4),
                        new ItemStack(Items.gold_nugget, 1),
                        new ItemStack(Items.dye, 1, 15))
                .circuit(11).itemOutputs(getModItem(Chisel.ID, "fantasyblock2", 8, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);

        // Neonite
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.emerald, 8), new ItemStack(Items.glowstone_dust, 1))
                .circuit(24).itemOutputs(getModItem(Chisel.ID, "neonite", 8, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);

        // GloTek
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.emerald, 8), new ItemStack(Items.glowstone_dust, 2))
                .circuit(11).itemOutputs(getModItem(Chisel.ID, "glotek", 8, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);

        // Rebellious Block
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.stone, 2),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.plate, (int) (2)),
                        new ItemStack(Items.gold_nugget, 1))
                .circuit(23).itemOutputs(getModItem(Chisel.ID, "rebel", 32, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);

        // Structural Concrete
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.gravel, 5),
                        new ItemStack(Blocks.sand, 2),
                        MaterialLibAPI.getStack(Materials.Clay, Shapes.dust, (int) (1)))
                .circuit(24).itemOutputs(getModItem(Chisel.ID, "nucrete", 16, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);

        // Purpur Block
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.end_stone, 4), new ItemStack(Items.dye, 4, 5))
                .circuit(24).itemOutputs(getModItem(Chisel.ID, "purpur", 8, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);

        // Svelstone
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone, 4), getModItem(Chisel.ID, "andesite", 1, 0))
                .circuit(24).itemOutputs(getModItem(Chisel.ID, "sveltstone", 8, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);

        // Woolen Clay
        for (int meta = 0; meta < 16; ++meta) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            new ItemStack(Blocks.wool, 2, meta),
                            new ItemStack(Blocks.stained_hardened_clay, 2, meta))
                    .circuit(24).itemOutputs(getModItem(Chisel.ID, "woolen_clay", 8, meta)).duration(5 * SECONDS)
                    .eut(24).addTo(assemblerRecipes);
        }
    }

    private void makeReinforcedIronPlateRecipes() {

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4),
                        getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 4),
                        NHItemList.AluminiumIronPlate.get())
                .circuit(3).itemOutputs(NHItemList.ReinforcedAluminiumIronPlate.get()).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4),
                        MaterialLibAPI.getStack(Materials.SiliconSolarGrade, Shapes.plate, (int) (4)),
                        NHItemList.TitaniumIronPlate.get())
                .circuit(3).itemOutputs(NHItemList.ReinforcedTitaniumIronPlate.get()).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4),
                        MaterialLibAPI.getStack(Materials.Tungsten, Shapes.plate, (int) (4)),
                        NHItemList.TungstenIronPlate.get())
                .circuit(3).itemOutputs(NHItemList.ReinforcedTungstenIronPlate.get()).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (4)),
                        NHItemList.TungstenSteelIronPlate.get())
                .circuit(3).itemOutputs(NHItemList.ReinforcedTungstenSteelIronPlate.get()).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4),
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.plate, (int) (4)),
                        NHItemList.ChromeIronPlate.get())
                .circuit(3).itemOutputs(NHItemList.ReinforcedChromeIronPlate.get()).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 4),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 6))
                .circuit(3).itemOutputs(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 7))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4),
                        MaterialLibAPI.getStack(Materials.MysteriousCrystal, Shapes.plate, (int) (4)),
                        NHItemList.NaquadriaIronPlate.get())
                .circuit(3).itemOutputs(NHItemList.ReinforcedNaquadriaIronPlate.get()).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4),
                        MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.plate, (int) (4)),
                        NHItemList.NeutroniumIronPlate.get())
                .circuit(3).itemOutputs(NHItemList.ReinforcedNeutroniumIronPlate.get()).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_UHV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4),
                        MaterialLibAPI.getStack(Materials.DraconiumAwakened, Shapes.plate, (int) (4)),
                        NHItemList.BedrockiumIronPlate.get())
                .circuit(3).itemOutputs(NHItemList.ReinforcedBedrockiumIronPlate.get()).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_UEV).addTo(assemblerRecipes);

    }

    private void makeMixedMetalIngotRecipes() {

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get("plateAnyIron", 1),
                        GTOreDictUnificator.get("plateAnyBronze", 1),
                        MaterialLibAPI.getStack(Materials.Zinc, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 1, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get("plateAnyIron", 1),
                        GTOreDictUnificator.get("plateAnyBronze", 1),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 1, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get("plateAnyIron", 1),
                        GTOreDictUnificator.get("plateAnyBronze", 1),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 1, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get("plateAnyIron", 1),
                        MaterialLibAPI.getStack(Materials.Brass, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Zinc, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 1, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get("plateAnyIron", 1),
                        MaterialLibAPI.getStack(Materials.Brass, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 1, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get("plateAnyIron", 1),
                        MaterialLibAPI.getStack(Materials.Brass, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 1, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Nickel, Shapes.plate, (int) (1)),
                        GTOreDictUnificator.get("plateAnyBronze", 1),
                        MaterialLibAPI.getStack(Materials.Zinc, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 1, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Nickel, Shapes.plate, (int) (1)),
                        GTOreDictUnificator.get("plateAnyBronze", 1),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 1, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Nickel, Shapes.plate, (int) (1)),
                        GTOreDictUnificator.get("plateAnyBronze", 1),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 1, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Invar, Shapes.plate, (int) (1)),
                        GTOreDictUnificator.get("plateAnyBronze", 1),
                        MaterialLibAPI.getStack(Materials.Zinc, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 2, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Invar, Shapes.plate, (int) (1)),
                        GTOreDictUnificator.get("plateAnyBronze", 1),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 2, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Invar, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Brass, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Zinc, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 2, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Invar, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Brass, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 2, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, (int) (1)),
                        GTOreDictUnificator.get("plateAnyBronze", 1),
                        MaterialLibAPI.getStack(Materials.Zinc, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 2, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, (int) (1)),
                        GTOreDictUnificator.get("plateAnyBronze", 1),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 2, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Brass, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Zinc, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 2, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Brass, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 2, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Invar, Shapes.plate, (int) (1)),
                        GTOreDictUnificator.get("plateAnyBronze", 1),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 3, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Invar, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Brass, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 3, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, (int) (1)),
                        GTOreDictUnificator.get("plateAnyBronze", 1),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 3, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Brass, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 3, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (1)),
                        GTOreDictUnificator.get("plateAnyBronze", 1),
                        MaterialLibAPI.getStack(Materials.Zinc, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 3, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (1)),
                        GTOreDictUnificator.get("plateAnyBronze", 1),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 3, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Brass, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Zinc, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 3, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Brass, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 3, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (1)),
                        GTOreDictUnificator.get("plateAnyBronze", 1),
                        MaterialLibAPI.getStack(Materials.Zinc, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 3, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (1)),
                        GTOreDictUnificator.get("plateAnyBronze", 1),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 3, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Brass, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Zinc, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 3, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Brass, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 3, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Tungsten, Shapes.plate, (int) (1)),
                        GTOreDictUnificator.get("plateAnyBronze", 1),
                        MaterialLibAPI.getStack(Materials.Zinc, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 3, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Tungsten, Shapes.plate, (int) (1)),
                        GTOreDictUnificator.get("plateAnyBronze", 1),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 3, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Tungsten, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Brass, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Zinc, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 3, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Tungsten, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Brass, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 3, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (1)),
                        GTOreDictUnificator.get("plateAnyBronze", 1),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 4, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Brass, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 4, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (1)),
                        GTOreDictUnificator.get("plateAnyBronze", 1),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 4, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Titanium, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Brass, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 4, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Tungsten, Shapes.plate, (int) (1)),
                        GTOreDictUnificator.get("plateAnyBronze", 1),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 4, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Tungsten, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Brass, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 4, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (1)),
                        GTOreDictUnificator.get("plateAnyBronze", 1),
                        MaterialLibAPI.getStack(Materials.Zinc, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 5, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (1)),
                        GTOreDictUnificator.get("plateAnyBronze", 1),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 5, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Brass, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Zinc, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 5, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Brass, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 5, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (1)),
                        GTOreDictUnificator.get("plateAnyBronze", 1),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 6, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Brass, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 6, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Zinc, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 8, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 8, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 8, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Zinc, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 10, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 10, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 10, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Iridium, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.AnnealedCopper, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 12, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Iridium, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.RoseGold, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 12, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Iridium, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.AstralSilver, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 12, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Iridium, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.AnnealedCopper, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 14, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Iridium, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.RoseGold, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 14, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Iridium, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.AstralSilver, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 14, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.HSSG, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.AnnealedCopper, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 16, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.HSSG, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.RoseGold, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 16, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.HSSG, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.AstralSilver, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 16, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.HSSE, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.AnnealedCopper, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 18, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.HSSE, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.RoseGold, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 18, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.HSSE, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.AstralSilver, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 18, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.HSSG, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.AnnealedCopper, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 20, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.HSSG, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.RoseGold, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 20, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.HSSG, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.AstralSilver, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 20, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Naquadah, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Iridium, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.HSSG, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 22, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Naquadah, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Iridium, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.HSSE, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 24, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Naquadah, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Iridium, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.HSSS, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 26, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.NaquadahAlloy, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Osmiridium, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.HSSG, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 28, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.NaquadahAlloy, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Osmiridium, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.HSSE, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 30, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.NaquadahAlloy, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Osmiridium, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.HSSS, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 32, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Neutronium, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.EnergeticAlloy, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Naquadah, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 34, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Neutronium, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.EnergeticAlloy, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.NaquadahAlloy, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 36, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Neutronium, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.EnergeticAlloy, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Draconium, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 38, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.EnergeticAlloy, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Naquadah, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 40, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Sunnarium, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.NaquadahAlloy, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 42, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Sunnarium, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Draconium, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 44, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.DraconiumAwakened, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Neutronium, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.HSSS, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 48, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.DraconiumAwakened, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Neutronium, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Naquadah, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 52, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.DraconiumAwakened, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Neutronium, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.NaquadahAlloy, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 56, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.DraconiumAwakened, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Neutronium, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.plate, (int) (1)))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemIngot", 64, 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

    }

    private void makeLootBagRecipes() {
        if (!EnhancedLootBags.isModLoaded()) return;

        final int DURATION = SECONDS * 10;

        // Regular Tiered
        addLootbagPair(1, 2, 3, 1, TierEU.RECIPE_ULV, DURATION); // Basic -> Steam
        addLootbagPair(2, 4, 3, 1, TierEU.RECIPE_LV, DURATION); // Steam -> LV
        addLootbagPair(4, 5, 3, 1, TierEU.RECIPE_MV, DURATION); // LV -> MV
        addLootbagPair(5, 6, 3, 1, TierEU.RECIPE_HV, DURATION); // MV -> HV
        addLootbagPair(6, 7, 3, 1, TierEU.RECIPE_EV, DURATION); // HV -> EV
        addLootbagPair(7, 8, 3, 1, TierEU.RECIPE_IV, DURATION); // EV -> IV
        addLootbagPair(8, 41, 3, 1, TierEU.RECIPE_LuV, DURATION); // IV -> LuV
        addLootbagPair(41, 42, 3, 1, TierEU.RECIPE_ZPM, DURATION); // LuV -> ZPM
        addLootbagPair(42, 43, 3, 1, TierEU.RECIPE_UV, DURATION); // ZPM -> UV

        // Forest Ranger
        addLootbagPair(19, 20, 3, 1, TierEU.RECIPE_LV, DURATION); // Basic -> Advanced
        addLootbagPair(20, 21, 3, 1, TierEU.RECIPE_MV, DURATION); // Advanced -> Expert

        // Blood Magic
        addLootbagPair(16, 17, 3, 1, TierEU.RECIPE_MV, DURATION); // Novice -> Adept
        addLootbagPair(17, 18, 3, 1, TierEU.RECIPE_MV, DURATION); // Adept -> Master

        // Bees
        addLootbagPair(25, 26, 3, 1, TierEU.RECIPE_LV, DURATION); // Basic -> Advanced
        addLootbagPair(26, 27, 3, 1, TierEU.RECIPE_HV, DURATION); // Advanced -> Expert

        // AE2
        addLootbagPair(37, 38, 3, 1, TierEU.RECIPE_EV, DURATION); // Basic -> Good

        // Space
        addLootbagPair(22, 23, 3, 1, TierEU.RECIPE_EV, DURATION); // Moon -> Mars
        addLootbagPair(23, 24, 3, 1, TierEU.RECIPE_EV, DURATION); // Mars -> Asteroids

        // Food
        addLootbagPair(28, 29, 3, 1, TierEU.RECIPE_LV, DURATION); // Fast Food -> Slow Food
        addLootbagPair(29, 30, 3, 1, TierEU.RECIPE_LV, DURATION); // Slow Food -> Haute Cuisine
        addLootbagPair(30, 31, 3, 1, TierEU.RECIPE_LV, DURATION); // Haute Cuisine -> Dessert

        // Transportation
        addLootbagPair(32, 33, 3, 1, TierEU.RECIPE_LV, DURATION); // Class 3 -> Class 2
        addLootbagPair(33, 34, 3, 1, TierEU.RECIPE_LV, DURATION); // Class 2 -> Class 1

        // Magic
        addLootbagPair(9, 10, 3, 1, TierEU.RECIPE_LV, DURATION); // Novice -> Adept
        addLootbagPair(10, 11, 3, 1, TierEU.RECIPE_MV, DURATION); // Adept -> Master
        addLootbagPair(11, 12, 3, 1, TierEU.RECIPE_MV, DURATION); // Master -> Grandmaster
        addLootbagPair(12, 13, 16, 1, TierEU.RECIPE_MV, DURATION); // Grandmaster -> Unique

        // Witchery
        addLootbagPair(52, 53, 3, 1, TierEU.RECIPE_LV, DURATION); // Novice -> Adept
        addLootbagPair(53, 54, 3, 1, TierEU.RECIPE_MV, DURATION); // Adept -> Master
        addLootbagPair(54, 55, 3, 1, TierEU.RECIPE_HV, DURATION); // Master -> Witch
        addLootbagPair(55, 56, 3, 1, TierEU.RECIPE_HV, DURATION); // Witch -> Daemon

        // HEE
        addLootbagPair(57, 58, 3, 1, TierEU.RECIPE_HV, DURATION); // Basic -> Advanced

    }

    // Assembler recipe registry
    private void addLootbagPair(int inMeta, int outMeta, int inCount, int outCount, long eut, int duration) {
        ItemStack inputBag = getModItem(EnhancedLootBags.ID, "lootbag", inCount, inMeta);
        ItemStack outputBag = getModItem(EnhancedLootBags.ID, "lootbag", outCount, outMeta);
        if (inputBag != null && outputBag != null) {
            GTValues.RA.stdBuilder().itemInputs(inputBag).itemOutputs(outputBag).duration(duration).eut((int) eut)
                    .addTo(assemblerRecipes);
        }
    }

    private void makeCoinRecipes() {
        // Coins

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinAdventure.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinAdventureI.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinAdventureI.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinAdventureII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinAdventureII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinAdventureIII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinAdventureIII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinAdventureIV.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinBees.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinBeesI.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinBeesI.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinBeesII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinBeesII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinBeesIII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinBeesIII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinBeesIV.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinBlood.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinBloodI.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinBloodI.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinBloodII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinBloodII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinBloodIII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinBloodIII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinBloodIV.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinChemist.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinChemistI.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinChemistI.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinChemistII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinChemistII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinChemistIII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinChemistIII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinChemistIV.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinCook.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinCookI.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinCookI.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinCookII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinCookII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinCookIII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinCookIII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinCookIV.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinDarkWizard.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinDarkWizardI.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinDarkWizardI.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinDarkWizardII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinDarkWizardII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinDarkWizardIII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinDarkWizardIII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinDarkWizardIV.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinFarmer.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinFarmerI.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinFarmerI.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinFarmerII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinFarmerII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinFarmerIII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinFarmerIII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinFarmerIV.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinForestry.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinForestryI.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinForestryI.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinForestryII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinForestryII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinForestryIII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinForestryIII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinForestryIV.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinSpace.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinSpaceI.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinSpaceI.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinSpaceII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinSpaceII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinSpaceIII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinSpaceIII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinSpaceIV.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinSurvivor.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinSurvivorI.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinSurvivorI.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinSurvivorII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinSurvivorII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinSurvivorIII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinSurvivorIII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinSurvivorIV.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinTechnician.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinTechnicianI.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinTechnicianI.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinTechnicianII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinTechnicianII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinTechnicianIII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinTechnicianIII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinTechnicianIV.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinSmith.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinSmithI.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinSmithI.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinSmithII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinSmithII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinSmithIII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinSmithIII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinSmithIV.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinWitch.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinWitchI.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinWitchI.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinWitchII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinWitchII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinWitchIII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinWitchIII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinWitchIV.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinFlower.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinFlowerI.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinFlowerI.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinFlowerII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinFlowerII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinFlowerIII.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinFlowerIII.get(10)).circuit(10)
                .itemOutputs(NHItemList.CoinFlowerIV.get()).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinAdventureI.get()).circuit(1)
                .itemOutputs(NHItemList.CoinAdventure.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinAdventureII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinAdventureI.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinAdventureIII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinAdventureII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinAdventureIV.get()).circuit(1)
                .itemOutputs(NHItemList.CoinAdventureIII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinBeesI.get()).circuit(1)
                .itemOutputs(NHItemList.CoinBees.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinBeesII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinBeesI.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinBeesIII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinBeesII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinBeesIV.get()).circuit(1)
                .itemOutputs(NHItemList.CoinBeesIII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinBloodI.get()).circuit(1)
                .itemOutputs(NHItemList.CoinBlood.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinBloodII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinBloodI.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinBloodIII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinBloodII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinBloodIV.get()).circuit(1)
                .itemOutputs(NHItemList.CoinBloodIII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinChemistI.get()).circuit(1)
                .itemOutputs(NHItemList.CoinChemist.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinChemistII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinChemistI.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinChemistIII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinChemistII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinChemistIV.get()).circuit(1)
                .itemOutputs(NHItemList.CoinChemistIII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinCookI.get()).circuit(1)
                .itemOutputs(NHItemList.CoinCook.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinCookII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinCookI.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinCookIII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinCookII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinCookIV.get()).circuit(1)
                .itemOutputs(NHItemList.CoinCookIII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinDarkWizardI.get()).circuit(1)
                .itemOutputs(NHItemList.CoinDarkWizard.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinDarkWizardII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinDarkWizardI.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinDarkWizardIII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinDarkWizardII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinDarkWizardIV.get()).circuit(1)
                .itemOutputs(NHItemList.CoinDarkWizardIII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinFarmerI.get()).circuit(1)
                .itemOutputs(NHItemList.CoinFarmer.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinFarmerII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinFarmerI.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinFarmerIII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinFarmerII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinFarmerIV.get()).circuit(1)
                .itemOutputs(NHItemList.CoinFarmerIII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinForestryI.get()).circuit(1)
                .itemOutputs(NHItemList.CoinForestry.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinForestryII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinForestryI.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinForestryIII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinForestryII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinForestryIV.get()).circuit(1)
                .itemOutputs(NHItemList.CoinForestryIII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinSpaceI.get()).circuit(1)
                .itemOutputs(NHItemList.CoinSpace.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinSpaceII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinSpaceI.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinSpaceIII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinSpaceII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinSpaceIV.get()).circuit(1)
                .itemOutputs(NHItemList.CoinSpaceIII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinSurvivorI.get()).circuit(1)
                .itemOutputs(NHItemList.CoinSurvivor.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinSurvivorII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinSurvivorI.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinSurvivorIII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinSurvivorII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinSurvivorIV.get()).circuit(1)
                .itemOutputs(NHItemList.CoinSurvivorIII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinTechnicianI.get()).circuit(1)
                .itemOutputs(NHItemList.CoinTechnician.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinTechnicianII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinTechnicianI.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinTechnicianIII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinTechnicianII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinTechnicianIV.get()).circuit(1)
                .itemOutputs(NHItemList.CoinTechnicianIII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinSmithI.get()).circuit(1)
                .itemOutputs(NHItemList.CoinSmith.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinSmithII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinSmithI.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinSmithIII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinSmithII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinSmithIV.get()).circuit(1)
                .itemOutputs(NHItemList.CoinSmithIII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinWitchI.get()).circuit(1)
                .itemOutputs(NHItemList.CoinWitch.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinWitchII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinWitchI.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinWitchIII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinWitchII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinWitchIV.get()).circuit(1)
                .itemOutputs(NHItemList.CoinWitchIII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinFlowerI.get()).circuit(1)
                .itemOutputs(NHItemList.CoinFlower.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinFlowerII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinFlowerI.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinFlowerIII.get()).circuit(1)
                .itemOutputs(NHItemList.CoinFlowerII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CoinFlowerIV.get()).circuit(1)
                .itemOutputs(NHItemList.CoinFlowerIII.get(10)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

    }

    private void makeCoilRecipes() {

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.Cupronickel, 8L),
                        NHItemList.AluminoSilicateWool.get(12))
                .circuit(3).itemOutputs(ItemList.Casing_Coil_Cupronickel.get(1L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Tin, FluidShapes.fluidMolten, (int) (288L)))
                .duration(5 * SECONDS).eut(7).addTo(assemblerRecipes);
        // TODO: Rework other stuff (that depends on certain Heat Levels, mostly LuV+ stuff) so this can be wrapped into
        // a oneliner.

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.Cupronickel, 8L),
                        NHItemList.MicaInsulatorFoil.get(8))
                .circuit(3).itemOutputs(ItemList.Casing_Coil_Cupronickel.get(1L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Tin, FluidShapes.fluidMolten, (int) (144L)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.Kanthal, 8L),
                        NHItemList.MicaInsulatorFoil.get(12))
                .circuit(3).itemOutputs(ItemList.Casing_Coil_Kanthal.get(1L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Cupronickel, FluidShapes.fluidMolten, (int) (144L)))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.Nichrome, 8L),
                        NHItemList.MicaInsulatorFoil.get(16))
                .circuit(3).itemOutputs(ItemList.Casing_Coil_Nichrome.get(1L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Kanthal, FluidShapes.fluidMolten, (int) (144L)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.TPVAlloy, 8L),
                        NHItemList.MicaInsulatorFoil.get(20))
                .circuit(3).itemOutputs(ItemList.Casing_Coil_TungstenSteel.get(1L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Nichrome, FluidShapes.fluidMolten, (int) (144L)))
                .duration(25 * SECONDS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.HSSG, 8L),
                        NHItemList.MicaInsulatorFoil.get(24))
                .circuit(3).itemOutputs(ItemList.Casing_Coil_HSSG.get(1L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.TPVAlloy, FluidShapes.fluidMolten, (int) (144L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.HSSS, 8L),
                        NHItemList.MicaInsulatorFoil.get(28))
                .circuit(3).itemOutputs(ItemList.Casing_Coil_HSSS.get(1L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.HSSG, FluidShapes.fluidMolten, (int) (144L)))
                .duration(35 * SECONDS).eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.Naquadah, 8L),
                        NHItemList.MicaInsulatorFoil.get(32))
                .circuit(3).itemOutputs(ItemList.Casing_Coil_Naquadah.get(1L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.HSSS, FluidShapes.fluidMolten, (int) (144L)))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.NaquadahAlloy, 8L),
                        NHItemList.MicaInsulatorFoil.get(36))
                .circuit(3).itemOutputs(ItemList.Casing_Coil_NaquadahAlloy.get(1L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Naquadah, FluidShapes.fluidMolten, (int) (144L)))
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.Trinium, 8L),
                        ItemList.Naquarite_Universal_Insulator_Foil.get(8L))
                .circuit(3).itemOutputs(ItemList.Casing_Coil_Trinium.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.NaquadahAlloy, FluidShapes.fluidMolten, (int) (144L)))
                .duration(50 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.ElectrumFlux, 8L),
                        ItemList.Naquarite_Universal_Insulator_Foil.get(12L))
                .circuit(3).itemOutputs(ItemList.Casing_Coil_ElectrumFlux.get(1L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Trinium, FluidShapes.fluidMolten, (int) (144L)))
                .duration(55 * SECONDS).eut(TierEU.RECIPE_UV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.DraconiumAwakened, 8L),
                        ItemList.Naquarite_Universal_Insulator_Foil.get(16L))
                .circuit(3).itemOutputs(ItemList.Casing_Coil_AwakenedDraconium.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.ElectrumFlux, FluidShapes.fluidMolten, (int) (144L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_UHV).addTo(assemblerRecipes);

    }

    private void makeNEIPlanetRecipes() {
        if (!Botania.isModLoaded()) {
            return;
        }

        List<OrePrefixes> allOrePrefixes = new ArrayList<>();
        allOrePrefixes.add(OrePrefixes.ore);
        allOrePrefixes.add(OrePrefixes.oreNetherrack);
        allOrePrefixes.add(OrePrefixes.oreEndstone);
        if (GTMod.proxy.enableBlackGraniteOres) allOrePrefixes.add(OrePrefixes.oreBlackgranite);
        if (GTMod.proxy.enableRedGraniteOres) allOrePrefixes.add(OrePrefixes.oreRedgranite);
        if (GTMod.proxy.enableMarbleOres) allOrePrefixes.add(OrePrefixes.oreMarble);
        if (GTMod.proxy.enableBasaltOres) allOrePrefixes.add(OrePrefixes.oreBasalt);

        // NEI Ore Plugin planets
        // T0 Planets
        // Toxic Everglades
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                        getModItem(GTPlusPlusEverglades.ID, "blockDarkWorldGround", 64, 0),
                        getModItem(GTPlusPlusEverglades.ID, "blockDarkWorldGround2", 64, 0))
                .circuit(17)
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.StagnantWasteWater, FluidShapes.fluidLiquid, (int) (10000L)))
                .itemOutputs(new ItemStack(ModBlocks.blocks.get("Eg"), 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Overworld
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                        getModItem(Minecraft.ID, "stone", 64, 0),
                        getModItem(Minecraft.ID, "grass", 64, 0),
                        getModItem(Minecraft.ID, "sapling", 1, 0))
                .circuit(17).fluidInputs(GTUtility.getWater(10000))
                .itemOutputs(new ItemStack(ModBlocks.blocks.get("Ow"), 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Twilight Forest
        if (TwilightForest.isModLoaded()) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(Minecraft.ID, "stone", 64, 0),
                            getModItem(Minecraft.ID, "grass", 64, 0),
                            getModItem(TwilightForest.ID, "tile.TFSapling", 1, 1))
                    .circuit(17).fluidInputs(GTUtility.getWater(10000))
                    .itemOutputs(new ItemStack(ModBlocks.blocks.get("TF"), 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        }
        // Nether
        if (BiomesOPlenty.isModLoaded()) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(Minecraft.ID, "netherrack", 64, 0),
                            getModItem(Minecraft.ID, "soul_sand", 64, 0),
                            getModItem(BiomesOPlenty.ID, "ash", 64, 0))
                    .circuit(17).fluidInputs(GTUtility.getLava(10000))
                    .itemOutputs(new ItemStack(ModBlocks.blocks.get("Ne"), 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        }
        // End
        if (Natura.isModLoaded()) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(Minecraft.ID, "end_stone", 64, 0),
                            getModItem(Minecraft.ID, "obsidian", 64, 0),
                            getModItem(Natura.ID, "Cloud", 64, 1))
                    .circuit(17).fluidInputs(FluidRegistry.getFluidStack("ender", 10000))
                    .itemOutputs(new ItemStack(ModBlocks.blocks.get("ED"), 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        }
        // Far End Asteroids
        if (HardcoreEnderExpansion.isModLoaded()) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(HardcoreEnderExpansion.ID, "end_stone_terrain", 64, 0),
                            getModItem(HardcoreEnderExpansion.ID, "end_stone_terrain", 64, 1),
                            getModItem(HardcoreEnderExpansion.ID, "end_stone_terrain", 64, 2))
                    .circuit(17).fluidInputs(FluidRegistry.getFluidStack("endergoo", 10000))
                    .itemOutputs(new ItemStack(ModBlocks.blocks.get("EA"), 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        }

        if (GalaxySpace.isModLoaded()) {
            // T1 Planets
            // The Moon
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalacticraftCore.ID, "tile.moonBlock", 64, 3),
                            getModItem(GalacticraftCore.ID, "tile.moonBlock", 64, 4),
                            getModItem(GalacticraftCore.ID, "tile.moonBlock", 64, 14))
                    .circuit(17)
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(Materials.SaltWater, FluidShapes.fluidLiquid, (int) (10000)))
                    .itemOutputs(new ItemStack(ModBlocks.blocks.get("Mo"), 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
            // T2 Planets
            // Deimos
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GTValues.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalaxySpace.ID, "deimosblocks", 64, 0),
                                getModItem(GalaxySpace.ID, "deimosblocks", 64, 1),
                                GTOreDictUnificator.get(orePrefix, Materials.Uranium, 64))
                        .circuit(17)
                        .fluidInputs(
                                MaterialLibAPI
                                        .getFluidStack(Materials.SulfuricAcid, FluidShapes.fluidLiquid, (int) (10000)))
                        .itemOutputs(new ItemStack(ModBlocks.blocks.get("De"), 1, 0)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
            }
            // Phobos
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalaxySpace.ID, "phobosblocks", 64, 0),
                            getModItem(GalaxySpace.ID, "phobosblocks", 64, 1),
                            getModItem(GalaxySpace.ID, "phobosblocks", 64, 2))
                    .circuit(17)
                    .fluidInputs(
                            MaterialLibAPI
                                    .getFluidStack(Materials.SulfuricAcid, FluidShapes.fluidLiquid, (int) (10000)))
                    .itemOutputs(new ItemStack(ModBlocks.blocks.get("Ph"), 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
            // Mars
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalacticraftMars.ID, "tile.mars", 64, 5),
                            getModItem(GalacticraftMars.ID, "tile.mars", 64, 6),
                            getModItem(GalacticraftMars.ID, "tile.mars", 64, 7))
                    .circuit(17)
                    .fluidInputs(
                            MaterialLibAPI
                                    .getFluidStack(Materials.Chlorobenzene, FluidShapes.fluidLiquid, (int) (10000)))
                    .itemOutputs(new ItemStack(ModBlocks.blocks.get("Ma"), 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
            // T3 Planets
            // Ceres
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalaxySpace.ID, "ceresblocks", 64, 0),
                            getModItem(GalaxySpace.ID, "ceresblocks", 64, 1),
                            getModItem(GalaxySpace.ID, "ceresblocks", 64, 2))
                    .circuit(17)
                    .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (10000)))
                    .itemOutputs(new ItemStack(ModBlocks.blocks.get("Ce"), 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);
            // Callisto
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GTValues.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalaxySpace.ID, "callistoblocks", 64, 0),
                                getModItem(GalaxySpace.ID, "callistoblocks", 64, 1),
                                GTOreDictUnificator.get(orePrefix, Materials.CallistoIce, 64L))
                        .circuit(17)
                        .fluidInputs(
                                MaterialLibAPI
                                        .getFluidStack(Materials.LiquidAir, FluidShapes.fluidLiquid, (int) (10000)))
                        .itemOutputs(new ItemStack(ModBlocks.blocks.get("Ca"), 1, 0)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);
            }
            // Asteroids
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalacticraftMars.ID, "tile.asteroidsBlock", 64, 0),
                            getModItem(GalacticraftMars.ID, "tile.asteroidsBlock", 64, 1),
                            getModItem(GalacticraftMars.ID, "tile.denseIce", 64, 0))
                    .circuit(17).fluidInputs(FluidRegistry.getFluidStack("ice", 10000))
                    .itemOutputs(new ItemStack(ModBlocks.blocks.get("As"), 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);
            // Ganymede
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GTValues.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalaxySpace.ID, "ganymedeblocks", 64, 0),
                                getModItem(GalaxySpace.ID, "ganymedeblocks", 64, 1),
                                GTOreDictUnificator.get(orePrefix, Materials.Platinum, 64L))
                        .circuit(17)
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (10000)))
                        .itemOutputs(new ItemStack(ModBlocks.blocks.get("Ga"), 1, 0)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);
            }
            // Europa
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GTValues.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalaxySpace.ID, "europagrunt", 64, 0),
                                getModItem(GalaxySpace.ID, "europagrunt", 64, 1),
                                GTOreDictUnificator.get(orePrefix, Materials.Manganese, 64L))
                        .circuit(17).fluidInputs(GTUtility.getWater(10000))
                        .itemOutputs(new ItemStack(ModBlocks.blocks.get("Eu"), 1, 0)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);
            }
            // Ross 128b
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(Minecraft.ID, "dirt", 64, 2),
                            getModItem(Minecraft.ID, "stone", 64, 0),
                            ItemList.Generator_Naquadah_Mark_I.get(1))
                    .circuit(17).fluidInputs(GTUtility.getLava(10000))
                    .itemOutputs(new ItemStack(ModBlocks.blocks.get("Rb"), 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);
            // T4 Planets
            // Io
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalaxySpace.ID, "ioblocks", 64, 1),
                            getModItem(GalaxySpace.ID, "ioblocks", 64, 2),
                            getModItem(GalaxySpace.ID, "ioblocks", 64, 3))
                    .circuit(17)
                    .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Lead, FluidShapes.fluidMolten, (int) (10000)))
                    .itemOutputs(new ItemStack(ModBlocks.blocks.get("Io"), 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);
            // Mercury
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalaxySpace.ID, "mercuryblocks", 64, 0),
                            getModItem(GalaxySpace.ID, "mercuryblocks", 64, 1),
                            getModItem(GalaxySpace.ID, "mercuryblocks", 64, 2))
                    .circuit(17)
                    .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Iron, FluidShapes.fluidMolten, (int) (10000)))
                    .itemOutputs(new ItemStack(ModBlocks.blocks.get("Me"), 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);
            // Venus
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GTValues.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalaxySpace.ID, "venusblocks", 64, 0),
                                getModItem(GalaxySpace.ID, "venusblocks", 64, 1),
                                GTOreDictUnificator.get(orePrefix, Materials.Quantium, 64))
                        .circuit(17)
                        .fluidInputs(
                                MaterialLibAPI
                                        .getFluidStack(Materials.CarbonDioxide, FluidShapes.fluidGas, (int) (10000)))
                        .itemOutputs(new ItemStack(ModBlocks.blocks.get("Ve"), 1, 0)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);
            }
            // T5 Planets
            // Miranda
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalaxySpace.ID, "mirandablocks", 64, 0),
                            getModItem(GalaxySpace.ID, "mirandablocks", 64, 1),
                            getModItem(GalaxySpace.ID, "mirandablocks", 64, 2))
                    .circuit(17)
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(Materials.HydricSulfide, FluidShapes.fluidGas, (int) (10000)))
                    .itemOutputs(new ItemStack(ModBlocks.blocks.get("Mi"), 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);
            // Oberon
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalaxySpace.ID, "oberonblocks", 64, 0),
                            getModItem(GalaxySpace.ID, "oberonblocks", 64, 1),
                            getModItem(GalaxySpace.ID, "oberonblocks", 64, 2))
                    .circuit(17)
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(Materials.CarbonMonoxide, FluidShapes.fluidGas, (int) (10000)))
                    .itemOutputs(new ItemStack(ModBlocks.blocks.get("Ob"), 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);
            // Enceladus
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalaxySpace.ID, "enceladusblocks", 64, 0),
                            getModItem(GalaxySpace.ID, "enceladusblocks", 64, 1),
                            getModItem(GalaxySpace.ID, "enceladusblocks", 64, 2))
                    .circuit(17)
                    .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (10000)))
                    .itemOutputs(new ItemStack(ModBlocks.blocks.get("En"), 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);
            // Titan
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalaxySpace.ID, "titanblocks", 64, 0),
                            getModItem(GalaxySpace.ID, "titanblocks", 64, 1),
                            getModItem(GalaxySpace.ID, "titanblocks", 64, 2))
                    .circuit(17)
                    .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Methane, FluidShapes.fluidGas, (int) (10000)))
                    .itemOutputs(new ItemStack(ModBlocks.blocks.get("Ti"), 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);
            // Ross 128ba
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalacticraftCore.ID, "tile.moonBlock", 64, 3),
                            getModItem(GalacticraftCore.ID, "tile.moonBlock", 64, 4),
                            getModItem(GalacticraftCore.ID, "tile.moonBlock", 64, 5))
                    .circuit(17).fluidInputs(MaterialUtils.gas(Materials.Helium3, 10000))
                    .itemOutputs(new ItemStack(ModBlocks.blocks.get("Ra"), 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);
            // T6 Planets
            // Triton
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalaxySpace.ID, "tritonblocks", 64, 0),
                            getModItem(GalaxySpace.ID, "tritonblocks", 64, 1),
                            getModItem(GalaxySpace.ID, "tritonblocks", 64, 2))
                    .circuit(17)
                    .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Ethylene, FluidShapes.fluidGas, (int) (10000)))
                    .itemOutputs(new ItemStack(ModBlocks.blocks.get("Tr"), 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_UV).addTo(assemblerRecipes);
            // Proteus
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalaxySpace.ID, "proteusblocks", 64, 0),
                            getModItem(GalaxySpace.ID, "proteusblocks", 64, 2),
                            getModItem(GalaxySpace.ID, "proteusblocks", 64, 3))
                    .circuit(17)
                    .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Deuterium, FluidShapes.fluidGas, (int) (10000)))
                    .itemOutputs(new ItemStack(ModBlocks.blocks.get("Pr"), 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_UV).addTo(assemblerRecipes);
            // T7 Planets
            // Haumea
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GTValues.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalaxySpace.ID, "haumeablocks", 64, 0),
                                GTOreDictUnificator.get(orePrefix, Materials.NetherStar, 64),
                                GTOreDictUnificator.get(orePrefix, Materials.Naquadah, 64))
                        .circuit(17)
                        .fluidInputs(
                                MaterialLibAPI
                                        .getFluidStack(Materials.InfusedGold, FluidShapes.fluidMolten, (int) (10000)))
                        .itemOutputs(new ItemStack(ModBlocks.blocks.get("Ha"), 1, 0)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_UHV).addTo(assemblerRecipes);
            }
            // Pluto
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalaxySpace.ID, "plutoblocks", 64, 0),
                            getModItem(GalaxySpace.ID, "plutoblocks", 64, 4),
                            getModItem(GalaxySpace.ID, "plutoblocks", 64, 6))
                    .circuit(17)
                    .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Fluorine, FluidShapes.fluidGas, (int) (10000)))
                    .itemOutputs(new ItemStack(ModBlocks.blocks.get("Pl"), 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_UHV).addTo(assemblerRecipes);
            // Makemake
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GTValues.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalaxySpace.ID, "makemakegrunt", 64, 0),
                                getModItem(GalaxySpace.ID, "makemakegrunt", 64, 1),
                                GTOreDictUnificator.get(orePrefix, Materials.Chrysotile, 64))
                        .circuit(17).fluidInputs(MaterialUtils.fluid(Materials.HydrofluoricAcidGT5U, 10000))
                        .itemOutputs(new ItemStack(ModBlocks.blocks.get("MM"), 1, 0)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_UHV).addTo(assemblerRecipes);
            }
            // Kuiper Belt
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GTValues.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalacticraftMars.ID, "tile.asteroidsBlock", 64, 0),
                                getModItem(GalacticraftMars.ID, "tile.denseIce", 64, 0),
                                GTOreDictUnificator.get(orePrefix, Materials.Neutronium, 64))
                        .circuit(17).fluidInputs(MaterialUtils.fluid(Materials.HydrofluoricAcidGT5U, 10000))
                        .itemOutputs(new ItemStack(ModBlocks.blocks.get("KB"), 1, 0)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_UHV).addTo(assemblerRecipes);
            }
            // T8 Planets
            // Vega B
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GTValues.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalaxySpace.ID, "vegabgrunt", 64, 0),
                                getModItem(GalaxySpace.ID, "vegabsubgrunt", 64, 0),
                                GTOreDictUnificator.get(orePrefix, Materials.InfinityCatalyst, 64))
                        .circuit(17)
                        .fluidInputs(
                                MaterialLibAPI
                                        .getFluidStack(Materials.Neutronium, FluidShapes.fluidMolten, (int) (10000)))
                        .itemOutputs(new ItemStack(ModBlocks.blocks.get("VB"), 1, 0)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_UEV).addTo(assemblerRecipes);
            }
            // Barnard C
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(Minecraft.ID, "stone", 64, 0),
                            getModItem(GalaxySpace.ID, "barnardaCgrass", 64, 0),
                            getModItem(GalaxySpace.ID, "barnardaCsapling", 1, 1))
                    .circuit(17).fluidInputs(FluidRegistry.getFluidStack("unknowwater", 10000))
                    .itemOutputs(new ItemStack(ModBlocks.blocks.get("BC"), 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_UEV).addTo(assemblerRecipes);
            // Barnard E
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalaxySpace.ID, "barnardaEgrunt", 64, 0),
                            getModItem(GalaxySpace.ID, "barnardaEsubgrunt", 64, 0),
                            GTOreDictUnificator.get(OrePrefixes.block, Materials.Unstable, 64))
                    .circuit(17)
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(Materials.LiquidAir, FluidShapes.fluidLiquid, (int) (10000)))
                    .itemOutputs(new ItemStack(ModBlocks.blocks.get("BE"), 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_UEV).addTo(assemblerRecipes);
            // Barnard F
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GTValues.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalaxySpace.ID, "barnardaFgrunt", 64, 0),
                                getModItem(GalaxySpace.ID, "barnardaFsubgrunt", 64, 0),
                                GTOreDictUnificator.get(orePrefix, Materials.Bedrockium, 64))
                        .circuit(17)
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(Materials.Tin, FluidShapes.fluidMolten, (int) (10000)))
                        .itemOutputs(new ItemStack(ModBlocks.blocks.get("BF"), 1, 0)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_UEV).addTo(assemblerRecipes);
            }
            // T Ceti E
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            getModItem(GalaxySpace.ID, "tcetieblocks", 64, 0),
                            getModItem(GalaxySpace.ID, "tcetieblocks", 64, 2),
                            getModItem(GalaxySpace.ID, "tcetiedandelions", 64, 4))
                    .circuit(17).fluidInputs(GTModHandler.getDistilledWater(10000))
                    .itemOutputs(new ItemStack(ModBlocks.blocks.get("TE"), 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_UEV).addTo(assemblerRecipes);
            // Alpha Centauri Bb
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GTValues.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalaxySpace.ID, "acentauribbgrunt", 64, 0),
                                getModItem(GalaxySpace.ID, "acentauribbsubgrunt", 64, 0),
                                GTOreDictUnificator.get(orePrefix, Materials.Samarium, 64))
                        .circuit(17)
                        .fluidInputs(
                                MaterialLibAPI.getFluidStack(Materials.Copper, FluidShapes.fluidMolten, (int) (10000)))
                        .itemOutputs(new ItemStack(ModBlocks.blocks.get("CB"), 1, 0)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_UEV).addTo(assemblerRecipes);
            }
            // T9 Planets
            // Seth
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GTValues.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(Minecraft.ID, "snow", 64, 0),
                                getModItem(Minecraft.ID, "packed_ice", 64, 0),
                                GTOreDictUnificator.get(orePrefix, Materials.TengamRaw, 64))
                        .circuit(17).fluidInputs(FluidRegistry.getFluidStack("ice", 10000))
                        .itemOutputs(new ItemStack(ModBlocks.blocks.get("Se"), 1, 0)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_UIV).addTo(assemblerRecipes);
            }
            // Anubis
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GTValues.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalacticraftAmunRa.ID, "tile.baseBlockGround", 64, 1),
                                getModItem(GalacticraftAmunRa.ID, "tile.baseBlockRock", 64, 1),
                                GTOreDictUnificator.get(orePrefix, Materials.InfinityCatalyst, 64))
                        .circuit(17)
                        // This breaks the pattern but the theme of the planet is that it's super dry so
                        // :shrug:, maybe add eventual pumpable fluid
                        .itemOutputs(new ItemStack(ModBlocks.blocks.get("An"), 1, 0)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_UIV).addTo(assemblerRecipes);
            }
            // Neper
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GTValues.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(Minecraft.ID, "grass", 64, 0),
                                getModItem(Minecraft.ID, "stone", 64, 0),
                                GTOreDictUnificator.get(orePrefix, Materials.Dilithium, 64))
                        .circuit(17).fluidInputs(GTUtility.getWater(10000)) // There
                                                                            // isn't
                                                                            // actually
                                                                            // water on
                        // Neper, but it
                        // fits
                        // the grass
                        .itemOutputs(new ItemStack(ModBlocks.blocks.get("Np"), 1, 0)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_UIV).addTo(assemblerRecipes);
            }
            // Maahes
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GTValues.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalacticraftAmunRa.ID, "tile.baseGrass", 64, 0),
                                getModItem(GalacticraftAmunRa.ID, "tile.saplings", 1, 0),
                                GTOreDictUnificator.get(orePrefix, Materials.Naquadria, 64))
                        .circuit(17).fluidInputs(GTUtility.getWater(10000)) // Same as
                                                                            // Neper (but
                                                                            // the grass
                                                                            // is
                        // red)
                        .itemOutputs(new ItemStack(ModBlocks.blocks.get("Mh"), 1, 0)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_UIV).addTo(assemblerRecipes);
            }
            // Horus
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GTValues.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(GalacticraftAmunRa.ID, "tile.baseFalling", 64, 0), // Obsidian Sand
                                getModItem(GalacticraftAmunRa.ID, "tile.baseBlockRock", 64, 9), // Obsidian Brick
                                GTOreDictUnificator.get(orePrefix, Materials.CosmicNeutronium, 64))
                        .circuit(17).fluidInputs(GTUtility.getLava(10000))
                        .itemOutputs(new ItemStack(ModBlocks.blocks.get("Ho"), 1, 0)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_UIV).addTo(assemblerRecipes);
            }
            // Mehen Belt
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                            GTOreDictUnificator.get(OrePrefixes.stone, Materials.GraniteBlack, 64L),
                            getModItem(GalacticraftMars.ID, "tile.denseIce", 64, 0),
                            getModItem(GalacticraftAmunRa.ID, "tile.baseBlockRock", 1, 14))
                    .circuit(17).fluidInputs(FluidRegistry.getFluidStack("ice", 10000))
                    .itemOutputs(new ItemStack(ModBlocks.blocks.get("MB"), 1, 0)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_UIV).addTo(assemblerRecipes);

            // Technically T10
            // Deep Dark
            for (OrePrefixes orePrefix : allOrePrefixes) {
                GTValues.RA.stdBuilder()
                        .itemInputs(
                                getModItem(Botania.ID, "tinyPlanetBlock", 1, 0),
                                getModItem(Minecraft.ID, "cobblestone", 64, 0),
                                GTOreDictUnificator.get(orePrefix, Materials.Rubidium, 64),
                                GTOreDictUnificator.get(orePrefix, Materials.Pumice, 64))
                        .circuit(17)
                        .fluidInputs(
                                MaterialLibAPI
                                        .getFluidStack(Materials.SpaceTime, FluidShapes.fluidMolten, (int) (10000)))
                        .itemOutputs(new ItemStack(ModBlocks.blocks.get("DD"), 1, 0)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_UMV).addTo(assemblerRecipes);
            }
        }
        if (Computronics.isModLoaded()) {
            // Audio Cable
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.Silver, 1),
                            MaterialLibAPI.getStack(Materials.Paper, Shapes.plateDouble, (int) (1)))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(Materials.Bismuth, FluidShapes.fluidMolten, (int) (INGOTS)))
                    .itemOutputs(getModItem(Computronics.ID, "computronics.audioCable", 1))
                    .duration(3 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.Silver, 1),
                            MaterialLibAPI.getStack(Materials.Paper, Shapes.plateDouble, (int) (1)))
                    .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Lead, FluidShapes.fluidMolten, (int) (INGOTS)))
                    .itemOutputs(getModItem(Computronics.ID, "computronics.audioCable", 1))
                    .duration(3 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        }
    }

    private void makeSolderingAlloyRecipes() {

        if (StevesCarts2.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Coated_Basic.get(1L),
                            Circuits.LV.get(1),
                            MaterialLibAPI.getStack(Materials.Gold, Shapes.wireFine, (int) (8)))
                    .circuit(2).itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Phenolic_Good.get(1L),
                            getModItem(StevesCarts2.ID, "ModuleComponents", 2, 9),
                            MaterialLibAPI.getStack(Materials.Electrum, Shapes.wireFine, (int) (16)))
                    .circuit(2).itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * INGOTS)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        }

        // GT solars

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_LV.get(1L),
                        ItemList.Cover_SolarPanel_LV.get(1L),
                        ItemList.Robot_Arm_LV.get(1L),
                        ItemList.Battery_RE_LV_Lithium.get(1L))
                .circuit(2).itemOutputs(ItemList.Machine_LV_SolarPanel.get(1L))
                .fluidInputs(SubstituteFluidStack.soldering(1 * INGOTS)).duration(40 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_MV.get(1L),
                        ItemList.Cover_SolarPanel_MV.get(1L),
                        ItemList.Robot_Arm_MV.get(1L),
                        ItemList.Battery_RE_MV_Lithium.get(1L))
                .circuit(2).itemOutputs(ItemList.Machine_MV_SolarPanel.get(1L))
                .fluidInputs(SubstituteFluidStack.soldering(2 * INGOTS)).duration(50 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_HV.get(1L),
                        ItemList.Cover_SolarPanel_HV.get(1L),
                        ItemList.Robot_Arm_HV.get(1L),
                        ItemList.Battery_RE_HV_Lithium.get(1L))
                .circuit(2).itemOutputs(ItemList.Machine_HV_SolarPanel.get(1L))
                .fluidInputs(SubstituteFluidStack.soldering(3 * INGOTS)).duration(60 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_EV.get(1L),
                        ItemList.Cover_SolarPanel_EV.get(1L),
                        ItemList.Robot_Arm_EV.get(1L),
                        ItemList.BatteryHull_EV_Full.get(1L))
                .circuit(2).itemOutputs(ItemList.Machine_EV_SolarPanel.get(1L))
                .fluidInputs(SubstituteFluidStack.soldering(4 * INGOTS)).duration(1 * MINUTES + 10 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_IV.get(1L),
                        ItemList.Cover_SolarPanel_IV.get(1L),
                        ItemList.Robot_Arm_IV.get(1L),
                        ItemList.BatteryHull_IV_Full.get(1L))
                .circuit(2).itemOutputs(ItemList.Machine_IV_SolarPanel.get(1L))
                .fluidInputs(SubstituteFluidStack.soldering(5 * INGOTS)).duration(1 * MINUTES + 20 * SECONDS)
                .eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_LuV.get(1L),
                        ItemList.Cover_SolarPanel_LuV.get(1L),
                        ItemList.Robot_Arm_LuV.get(1L),
                        ItemList.BatteryHull_LuV_Full.get(1L))
                .circuit(2).itemOutputs(ItemList.Machine_LuV_SolarPanel.get(1L))
                .fluidInputs(SubstituteFluidStack.soldering(6 * INGOTS)).duration(1 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_ZPM.get(1L),
                        ItemList.Cover_SolarPanel_ZPM.get(1L),
                        ItemList.Robot_Arm_ZPM.get(1L),
                        ItemList.BatteryHull_ZPM_Full.get(1L))
                .circuit(2).itemOutputs(ItemList.Machine_ZPM_SolarPanel.get(1L))
                .fluidInputs(SubstituteFluidStack.soldering(7 * INGOTS)).duration(1 * MINUTES + 40 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Hull_UV.get(1L),
                        ItemList.Cover_SolarPanel_UV.get(1L),
                        ItemList.Robot_Arm_UV.get(1L),
                        ItemList.BatteryHull_UV_Full.get(1L))
                .circuit(2).itemOutputs(ItemList.Machine_UV_SolarPanel.get(1L))
                .fluidInputs(SubstituteFluidStack.soldering(8 * INGOTS)).duration(1 * MINUTES + 50 * SECONDS)
                .eut(TierEU.RECIPE_UHV).addTo(assemblerRecipes);

        // solar 1EU

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Silicon_Wafer.get(2),
                        Circuits.LV.get(2),
                        ItemList.ReinforcedGlass.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 1L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 2L),
                        NHItemList.AluminiumIronPlate.get())
                .itemOutputs(ItemList.Cover_SolarPanel.get(1L))
                .fluidInputs(SubstituteFluidStack.soldering(1 * QUARTER_INGOTS)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // solar 8EU

        GTValues.RA.stdBuilder()
                .itemInputs(
                        Circuits.MV.get(2),
                        ItemList.Cover_SolarPanel.get(2L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Tin, 2L),
                        ItemList.Circuit_Silicon_Wafer.get(1),
                        MaterialLibAPI.getStack(Materials.GalliumArsenide, Shapes.plate, (int) (1L)),
                        NHItemList.ReinforcedAluminiumIronPlate.get())
                .itemOutputs(ItemList.Cover_SolarPanel_8V.get(1L))
                .fluidInputs(SubstituteFluidStack.soldering(1 * QUARTER_INGOTS)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        if (OpenComputers.isModLoaded()) {

            // display t1

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Casing_MV.get(1L),
                            ItemList.Cover_Screen.get(1L),
                            Circuits.MV.get(2),
                            ItemList.Circuit_Parts_Transistor.get(2L))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "screen1", 1, 0))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS)
                    .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
            // display t2

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Casing_HV.get(1L),
                            getModItem(OpenComputers.ID, "screen1", 1, 0),
                            Circuits.HV.get(2),
                            ItemList.Circuit_Parts_Transistor.get(4L))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "screen2", 1, 0))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
            // display t3

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Casing_EV.get(1L),
                            getModItem(OpenComputers.ID, "screen2", 1, 0),
                            Circuits.EV.get(2),
                            ItemList.Circuit_Parts_Transistor.get(8L))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "screen3", 1, 0))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * INGOTS)).duration(12 * SECONDS)
                    .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Casing_EV.get(1L),
                            getModItem(OpenComputers.ID, "screen2", 1, 0),
                            Circuits.EV.get(2),
                            ItemList.Circuit_Parts_TransistorASMD.get(1L))
                    .circuit(2).itemOutputs(getModItem(OpenComputers.ID, "screen3", 1, 0))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * INGOTS)).duration(6 * SECONDS)
                    .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
            // angel upgrade

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            MaterialLibAPI.getStack(Materials.Aluminium, Shapes.itemCasing, (int) (2L)),
                            getModItem(ExtraUtilities.ID, "angelBlock", 1, 0),
                            getModItem(OpenComputers.ID, "item", 1, 25))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 49))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
            // hover upgrade Tier 1

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            MaterialLibAPI.getStack(Materials.Aluminium, Shapes.itemCasing, (int) (2L)),
                            MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.rotor, (int) (4L)),
                            getModItem(OpenComputers.ID, "item", 2, 25),
                            ItemList.Electric_Motor_MV.get(1L))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 99))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
            // hover upgrade Tier 2

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            MaterialLibAPI.getStack(Materials.Aluminium, Shapes.itemCasing, (int) (4L)),
                            MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.rotor, (int) (8L)),
                            getModItem(OpenComputers.ID, "item", 2, 26),
                            ItemList.Electric_Motor_HV.get(1L))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 100))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
            // battery upgrade 1

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            MaterialLibAPI.getStack(Materials.Aluminium, Shapes.itemCasing, (int) (2L)),
                            getModItem(OpenComputers.ID, "capacitor", 1, 0),
                            ItemList.Circuit_Parts_Transistor.get(2L),
                            MaterialLibAPI.getStack(Materials.RedAlloy, Shapes.bolt, (int) (4L)))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 63))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
            // battery upgrade 2

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            MaterialLibAPI.getStack(Materials.Titanium, Shapes.itemCasing, (int) (2L)),
                            getModItem(OpenComputers.ID, "capacitor", 2, 0),
                            ItemList.Circuit_Parts_Transistor.get(4L),
                            MaterialLibAPI.getStack(Materials.Silver, Shapes.bolt, (int) (8L)))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 64))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
            // battery upgrade 3

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.itemCasing, (int) (2L)),
                            getModItem(OpenComputers.ID, "capacitor", 4, 0),
                            ItemList.Circuit_Parts_Transistor.get(8L),
                            MaterialLibAPI.getStack(Materials.Electrum, Shapes.bolt, (int) (16L)))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 65))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.itemCasing, (int) (2L)),
                            getModItem(OpenComputers.ID, "capacitor", 4, 0),
                            ItemList.Circuit_Parts_TransistorASMD.get(1L),
                            MaterialLibAPI.getStack(Materials.Electrum, Shapes.bolt, (int) (16L)))
                    .circuit(2).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 65))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(6 * SECONDS + 5 * TICKS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
            // inventory upgrade

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            MaterialLibAPI.getStack(Materials.Aluminium, Shapes.itemCasing, (int) (2L)),
                            new ItemStack(Blocks.chest, 1),
                            getModItem(OpenComputers.ID, "item", 1, 24),
                            MaterialLibAPI.getStack(Materials.Silver, Shapes.bolt, (int) (8L)))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 53))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
            // inventory controller upgrade

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(OpenComputers.ID, "item", 1, 53),
                            MaterialLibAPI.getStack(Materials.Aluminium, Shapes.itemCasing, (int) (2L)),
                            getModItem(OpenComputers.ID, "item", 1, 24),
                            MaterialLibAPI.getStack(Materials.Electrum, Shapes.bolt, (int) (8L)))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 61))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
            // tank upgrade

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            MaterialLibAPI.getStack(Materials.Aluminium, Shapes.itemCasing, (int) (2L)),
                            getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                            MaterialLibAPI.getStack(Materials.Silver, Shapes.bolt, (int) (8L)))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 76))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
            // tank controller upgrade

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(OpenComputers.ID, "item", 1, 76),
                            MaterialLibAPI.getStack(Materials.Aluminium, Shapes.itemCasing, (int) (2L)),
                            getModItem(OpenComputers.ID, "item", 1, 24),
                            MaterialLibAPI.getStack(Materials.Electrum, Shapes.bolt, (int) (8L)))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 77))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
            // beekeper upgrade

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            getModItem(OpenComputers.ID, "item", 1, 25),
                            getModItem(Forestry.ID, "beealyzer", 1, 0),
                            ItemList.Sensor_MV.get(2L),
                            MaterialLibAPI.getStack(Materials.EnderEye, Shapes.lens, (int) (2)))
                    .circuit(10).itemOutputs(getModItem(OpenComputers.ID, "item.forestry", 1, 0))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
            // configurator upgrade

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(OpenComputers.ID, "wrench", 1, 0),
                            getModItem(OpenComputers.ID, "item", 2, 24),
                            MaterialLibAPI.getStack(Materials.Aluminium, Shapes.itemCasing, (int) (2L)))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 115))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
            // riteg upgrade

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTModHandler.getIC2Item("RTGPellets", 1),
                            getModItem(OpenComputers.ID, "item", 3, 26),
                            MaterialLibAPI.getStack(Materials.Lead, Shapes.plateDense, (int) (4L)))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 116))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
            // card container 1

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(OpenComputers.ID, "item", 1, 33),
                            MaterialLibAPI.getStack(Materials.Aluminium, Shapes.itemCasing, (int) (2L)),
                            new ItemStack(Blocks.chest, 1),
                            getModItem(OpenComputers.ID, "item", 1, 24))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 57))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
            // card container 2

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(OpenComputers.ID, "item", 1, 33),
                            MaterialLibAPI.getStack(Materials.Titanium, Shapes.itemCasing, (int) (2L)),
                            new ItemStack(Blocks.chest, 1),
                            getModItem(OpenComputers.ID, "item", 1, 25))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 58))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
            // card container 3

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(OpenComputers.ID, "item", 1, 33),
                            MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.itemCasing, (int) (2L)),
                            new ItemStack(Blocks.chest, 1),
                            getModItem(OpenComputers.ID, "item", 1, 26))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 59))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
            // upgrade container 1

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            MaterialLibAPI.getStack(Materials.Aluminium, Shapes.itemCasing, (int) (2L)),
                            new ItemStack(Blocks.chest, 1),
                            getModItem(OpenComputers.ID, "item", 1, 24),
                            MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.bolt, (int) (8L)))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 54))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
            // upgrade container 2

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            MaterialLibAPI.getStack(Materials.Titanium, Shapes.itemCasing, (int) (2L)),
                            new ItemStack(Blocks.chest, 1),
                            getModItem(OpenComputers.ID, "item", 1, 25),
                            MaterialLibAPI.getStack(Materials.Titanium, Shapes.bolt, (int) (8L)))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 55))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
            // upgrade container 3

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.itemCasing, (int) (2L)),
                            new ItemStack(Blocks.chest, 1),
                            getModItem(OpenComputers.ID, "item", 1, 26),
                            MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.bolt, (int) (8L)))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 56))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
            // database upgrade 1

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            getModItem(OpenComputers.ID, "item", 1, 0),
                            getModItem(OpenComputers.ID, "item", 1, 5),
                            getModItem(OpenComputers.ID, "item", 2, 24))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 78))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
            // database upgrade 2

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            getModItem(OpenComputers.ID, "item", 1, 0),
                            getModItem(OpenComputers.ID, "item", 1, 6),
                            getModItem(OpenComputers.ID, "item", 2, 25))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 79))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
            // database upgrade 3

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            getModItem(OpenComputers.ID, "item", 1, 0),
                            getModItem(OpenComputers.ID, "item", 1, 7),
                            getModItem(OpenComputers.ID, "item", 2, 26))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 80))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
            // experience upgrade

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            getModItem(OpenComputers.ID, "item", 1, 0),
                            getModItem(OpenComputers.ID, "item", 2, 26),
                            MaterialLibAPI.getStack(Materials.Emerald, Shapes.plate, (int) (2L)))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 52))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
            // crafting component

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Hull_LV.get(1L),
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            getModItem(OpenComputers.ID, "item", 2, 24),
                            ItemList.Cover_Crafting.get(1L))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 14))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
            // generator upgrade

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(EnderIO.ID, "blockStirlingGenerator", 1, 0),
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            getModItem(OpenComputers.ID, "item", 2, 24),
                            MaterialLibAPI.getStack(Materials.Aluminium, Shapes.itemCasing, (int) (1L)))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 15))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
            // leash upgrade

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            getModItem(OpenComputers.ID, "item", 1, 28),
                            new ItemStack(Items.lead, 4))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 85))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
            // mfu upgrade

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(OpenComputers.ID, "adapter", 1, 0),
                            getModItem(OpenComputers.ID, "item", 2, 51),
                            getModItem(OpenComputers.ID, "item", 4, 96),
                            MaterialLibAPI.getStack(Materials.Lapis, Shapes.plate, (int) (2L)))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 112))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
            // navigation upgrade

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Hull_MV.get(1L),
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            getModItem(OpenComputers.ID, "item", 2, 26),
                            new ItemStack(Items.compass, 1),
                            new ItemStack(Items.map, 1),
                            GTOreDictUnificator.get(OrePrefixes.cell, Materials.Water, 1L))
                    .itemOutputs(getModItem(OpenComputers.ID, "item", 1, 36))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
            // piston upgrade

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Electric_Piston_MV.get(1L),
                            getModItem(OpenComputers.ID, "item", 2, 24),
                            MaterialLibAPI.getStack(Materials.Aluminium, Shapes.itemCasing, (int) (1L)))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 75))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
            // sing IO upgrade

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            getModItem(OpenComputers.ID, "item", 2, 24),
                            MaterialLibAPI.getStack(Materials.Aluminium, Shapes.itemCasing, (int) (2L)),
                            ItemList.Dye_SquidInk.get(1L),
                            new ItemStack(Items.sign, 1))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 35))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
            // solar upgrade

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            getModItem(OpenComputers.ID, "item", 2, 26),
                            ItemList.Cover_SolarPanel_LV.get(1L),
                            MaterialLibAPI.getStack(Materials.Titanium, Shapes.itemCasing, (int) (2L)))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 34))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
            // tractor beam upgrade

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(OpenComputers.ID, "capacitor", 1, 0),
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            getModItem(OpenComputers.ID, "item", 1, 26),
                            ItemList.Electric_Piston_HV.get(1L),
                            MaterialLibAPI.getStack(Materials.IronMagnetic, Shapes.stick, (int) (4L)),
                            MaterialLibAPI.getStack(Materials.Copper, Shapes.wireFine, (int) (16L)))
                    .itemOutputs(getModItem(OpenComputers.ID, "item", 1, 67))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
            // trading upgrade

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            getModItem(OpenComputers.ID, "item", 3, 25),
                            MaterialLibAPI.getStack(Materials.Aluminium, Shapes.itemCasing, (int) (3L)),
                            ItemList.Electric_Piston_MV.get(1L),
                            MaterialLibAPI.getStack(Materials.Emerald, Shapes.plate, (int) (2L)))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item", 1, 110))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
            // hover Boots

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(OpenComputers.ID, "capacitor", 1, 0),
                            getModItem(OpenComputers.ID, "item", 1, 83),
                            getModItem(OpenComputers.ID, "item", 1, 100),
                            MaterialLibAPI.getStack(Materials.Aluminium, Shapes.itemCasing, (int) (4L)),
                            ItemList.Electric_Piston_MV.get(2L))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "hoverBoots", 1, WILDCARD))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(17 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);

            // ME Upgrade 1

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            MaterialLibAPI.getStack(Materials.Chrome, Shapes.itemCasing, (int) (2L)),
                            getModItem(OpenComputers.ID, "item", 1, 13),
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 41),
                            getModItem(OpenComputers.ID, "item", 1, 24))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item.ae", 1))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
            // ME Upgrade 2

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            MaterialLibAPI.getStack(Materials.Titanium, Shapes.itemCasing, (int) (2L)),
                            getModItem(OpenComputers.ID, "item", 1, 13),
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 41),
                            getModItem(OpenComputers.ID, "item", 1, 25))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item.ae", 1, 1))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_EV / 2).addTo(assemblerRecipes);
            // ME Upgrade 3

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            MaterialLibAPI.getStack(Materials.TungstenSteel, Shapes.itemCasing, (int) (2L)),
                            getModItem(OpenComputers.ID, "item", 1, 13),
                            getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 41),
                            getModItem(OpenComputers.ID, "item", 1, 26))
                    .circuit(1).itemOutputs(getModItem(OpenComputers.ID, "item.ae", 1, 2))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_IV / 2).addTo(assemblerRecipes);

        }

        if (Computronics.isModLoaded()) {
            // Camera Upgrade

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Computronics.ID, "computronics.camera", 1, 0),
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            getModItem(OpenComputers.ID, "item", 2, 25),
                            ItemList.Circuit_Parts_TransistorSMD.get(2L),
                            MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (4L)))
                    .circuit(1).itemOutputs(getModItem(Computronics.ID, "computronics.ocParts", 1, 0))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
            // Chat Upgrade

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Computronics.ID, "computronics.chatBox", 1, 0),
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            getModItem(OpenComputers.ID, "item", 2, 25),
                            ItemList.Circuit_Parts_TransistorSMD.get(2L),
                            MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (4L)))
                    .circuit(1).itemOutputs(getModItem(Computronics.ID, "computronics.ocParts", 1, 1))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
            // Radar Upgrade

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Computronics.ID, "computronics.radar", 1, 0),
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            getModItem(OpenComputers.ID, "item", 2, 26),
                            ItemList.Circuit_Parts_TransistorSMD.get(4L),
                            MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (4L)),
                            getModItem(OpenComputers.ID, "item", 1, 48))
                    .circuit(1).itemOutputs(getModItem(Computronics.ID, "computronics.ocParts", 1, 2))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Computronics.ID, "computronics.radar", 1, 0),
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            getModItem(OpenComputers.ID, "item", 2, 26),
                            ItemList.Circuit_Parts_TransistorASMD.get(2L),
                            MaterialLibAPI.getStack(Materials.StainlessSteel, Shapes.plate, (int) (4L)),
                            getModItem(OpenComputers.ID, "item", 1, 48))
                    .circuit(2).itemOutputs(getModItem(Computronics.ID, "computronics.ocParts", 1, 2))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
            // Particle Card

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(OpenComputers.ID, "item", 1, 33),
                            MaterialLibAPI.getStack(Materials.Aluminium, Shapes.itemCasing, (int) (2L)),
                            getModItem(OpenComputers.ID, "item", 1, 25),
                            new ItemStack(Items.firework_charge, 1, WILDCARD))
                    .circuit(1).itemOutputs(getModItem(Computronics.ID, "computronics.ocParts", 1, 3))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
            // Spoofing Card

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(OpenComputers.ID, "item", 1, 11),
                            getModItem(OpenComputers.ID, "item", 2, 25),
                            getModItem(OpenComputers.ID, "item", 1, 50),
                            MaterialLibAPI.getStack(Materials.Clay, Shapes.plate, (int) (2L)))
                    .circuit(1).itemOutputs(getModItem(Computronics.ID, "computronics.ocParts", 1, 4))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
            // Beep Card

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(OpenComputers.ID, "item", 1, 33),
                            getModItem(OpenComputers.ID, "item", 2, 25),
                            getModItem(OpenComputers.ID, "item", 1, 28),
                            getModItem(Computronics.ID, "computronics.speaker", 1, 0))
                    .circuit(1).itemOutputs(getModItem(Computronics.ID, "computronics.ocParts", 1, 5))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
            // Self Destructing Card

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(OpenComputers.ID, "item", 1, 66),
                            getModItem(OpenComputers.ID, "item", 2, 24),
                            getModItem(OpenComputers.ID, "item", 1, 28),
                            getModItem(IndustrialCraft2.ID, "blockITNT", 2, 0))
                    .circuit(1).itemOutputs(getModItem(Computronics.ID, "computronics.ocParts", 1, 6))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
            // Colorful Upgrade

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            getModItem(OpenComputers.ID, "item", 2, 25),
                            ItemList.Circuit_Parts_TransistorSMD.get(2L),
                            getModItem(Computronics.ID, "computronics.colorfulLamp", 1, 0),
                            getModItem(OpenComputers.ID, "item", 4, 96))
                    .circuit(1).itemOutputs(getModItem(Computronics.ID, "computronics.ocParts", 1, 7))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
            // Noise Card

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Computronics.ID, "computronics.ocParts", 1, 5),
                            getModItem(OpenComputers.ID, "item", 2, 25),
                            getModItem(OpenComputers.ID, "item", 2, 1),
                            getModItem(OpenComputers.ID, "item", 2, 27),
                            MaterialLibAPI.getStack(Materials.NetherQuartz, Shapes.plate, (int) (2L)))
                    .circuit(1).itemOutputs(getModItem(Computronics.ID, "computronics.ocParts", 1, 8))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
            // Sound Card

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Computronics.ID, "computronics.ocParts", 1, 8),
                            getModItem(OpenComputers.ID, "item", 2, 26),
                            getModItem(OpenComputers.ID, "item", 1, 38),
                            getModItem(OpenComputers.ID, "item", 1, 29))
                    .circuit(1).itemOutputs(getModItem(Computronics.ID, "computronics.ocParts", 1, 9))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_EV / 2).addTo(assemblerRecipes);
            // Light Board

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            getModItem(Computronics.ID, "computronics.colorfulLamp", 1, 0),
                            getModItem(OpenComputers.ID, "item", 2, 24),
                            MaterialLibAPI.getStack(Materials.Glass, Shapes.plate, (int) (2L)),
                            ItemList.Dye_SquidInk.get(4L))
                    .circuit(1).itemOutputs(getModItem(Computronics.ID, "computronics.ocParts", 1, 10))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
            // Server Selfdestructor

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            getModItem(Computronics.ID, "computronics.ocParts", 2, 6),
                            getModItem(OpenComputers.ID, "item", 2, 24),
                            ItemList.Dye_SquidInk.get(4L),
                            getModItem(IndustrialCraft2.ID, "blockITNT", 2, 0))
                    .circuit(1).itemOutputs(getModItem(Computronics.ID, "computronics.ocParts", 1, 11))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
            // Rack Capacitor

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            getModItem(OpenComputers.ID, "capacitor", 1, 0),
                            getModItem(OpenComputers.ID, "item", 2, 24),
                            MaterialLibAPI.getStack(Materials.Glass, Shapes.plate, (int) (2L)),
                            ItemList.Dye_SquidInk.get(4L))
                    .circuit(1).itemOutputs(getModItem(Computronics.ID, "computronics.ocParts", 1, 12))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
            // Switch Board

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            getModItem(OpenComputers.ID, "item", 2, 24),
                            new ItemStack(Blocks.stone_button, 64, 30720),
                            MaterialLibAPI.getStack(Materials.Glass, Shapes.plate, (int) (2L)),
                            ItemList.Dye_SquidInk.get(4L))
                    .circuit(1).itemOutputs(getModItem(Computronics.ID, "computronics.ocParts", 1, 13))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
            // Speech Upgrade

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Computronics.ID, "computronics.speechBox", 1, 0),
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            getModItem(OpenComputers.ID, "item", 2, 25),
                            ItemList.Circuit_Parts_TransistorSMD.get(2L),
                            MaterialLibAPI.getStack(Materials.Aluminium, Shapes.plate, (int) (4L)))
                    .circuit(1).itemOutputs(getModItem(Computronics.ID, "computronics.ocParts", 1, 14))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
            // Drone Docking Station

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            getModItem(OpenComputers.ID, "cable", 2, 0),
                            getModItem(OpenComputers.ID, "item", 2, 25),
                            ItemList.Circuit_Parts_TransistorSMD.get(2L),
                            MaterialLibAPI.getStack(Materials.EnderPearl, Shapes.plate, (int) (2L)))
                    .circuit(1).itemOutputs(getModItem(Computronics.ID, "computronics.droneStation", 1, 0))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
            // Drone Docking Station Upgrade

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Computronics.ID, "computronics.droneStation", 1, 0),
                            getModItem(OpenComputers.ID, "item", 2, 26),
                            ItemList.Circuit_Parts_TransistorSMD.get(2L),
                            MaterialLibAPI.getStack(Materials.Aluminium, Shapes.itemCasing, (int) (2L)))
                    .circuit(1).itemOutputs(getModItem(Computronics.ID, "computronics.dockingUpgrade", 1, 0))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
            // Portable Tape Drive

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Computronics.ID, "computronics.tape", 1, 1),
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            getModItem(OpenComputers.ID, "item", 2, 25),
                            ItemList.Circuit_Parts_TransistorSMD.get(2L),
                            MaterialLibAPI.getStack(Materials.Plastic, Shapes.plate, (int) (2L)))
                    .circuit(1).itemOutputs(getModItem(Computronics.ID, "computronics.portableTapeDrive", 1, 0))
                    .fluidInputs(SubstituteFluidStack.soldering(1 * HALF_INGOTS)).duration(12 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        }
    }

    private void makeMachineRecipes() {

        // Advanced Network Switch
        GTValues.RA.stdBuilder()
                .itemInputs(
                        Machine_Multi_Transformer.get(1),
                        Circuits.LuV.get(4),
                        MaterialLibAPI.getStack(Materials.Cobalt, Shapes.wireFine, (int) (64)),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.wireFine, (int) (64)),
                        DATApipe.get(4))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Iridium, FluidShapes.fluidMolten, (int) (1296)))
                .itemOutputs(Machine_Multi_Switch_Adv.get(1)).eut(TierEU.RECIPE_ZPM).duration(40 * SECONDS)
                .addTo(assemblerRecipes);

        // Static Switch <-> Weighted Switch Conversion Recipes
        GTModHandler.addShapelessCraftingRecipe(
                Machine_Multi_Switch_Adv.get(1),
                new Object[] { Machine_Multi_Switch.get(1) });

        GTModHandler.addShapelessCraftingRecipe(
                Machine_Multi_Switch.get(1),
                new Object[] { Machine_Multi_Switch_Adv.get(1) });

        // Decay Warehouse
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Casing_RadiationProof.get(1),
                        Circuits.IV.get(2),
                        ItemList.Conveyor_Module_EV.get(2),
                        ItemList.Robot_Arm_EV.get(2),
                        MaterialLibAPI.getStack(Materials.Lead, Shapes.plateDense, (int) (4)),
                        ItemList.Cover_Screen.get(1))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.SolderingAlloy, FluidShapes.fluidMolten, (int) (144 * 8)))
                .itemOutputs(ItemList.DecayWarehouse.get(1)).duration(30 * SECONDS).eut((int) TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);
    }

    private void makeBeamcraftingRecipes() {

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(LanthItemList.SHIELDED_ACCELERATOR_CASING, 32),
                        new ItemStack(LanthItemList.NIOBIUM_CAVITY_CASING, 32),
                        GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.NiobiumTitanium, 64),
                        ItemList.Sensor_UV.get(1),
                        ItemList.Naquarite_Universal_Insulator_Foil.get(16))
                .itemOutputs(ItemList.ColliderCasing.get(32))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.Pikyonium64B, FluidShapes.fluidMolten, (int) (144 * 64)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(LanthItemList.NIOBIUM_CAVITY_CASING, 8),
                        GTOreDictUnificator.get(Circuits.UHV.getIngredient(), 2),
                        Field_Restriction_Coil_T1.get(1))
                .itemOutputs(ItemList.BeamStabilizer.get(1))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.Grade6PurifiedWater, FluidShapes.fluidLiquid, (int) (1000L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_UHV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(LanthItemList.SHIELDED_ACCELERATOR_GLASS, 4),
                        copyAmount(8, LanthItemList.BEAMLINE_PIPE),
                        MaterialLibAPI.getStack(Materials.ChromaticGlass, Shapes.plateDense, (int) (1)),
                        GTOreDictUnificator.get(Circuits.UHV.getIngredient(), 2))
                .itemOutputs(ItemList.BeamMirror.get(1))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.Grade6PurifiedWater, FluidShapes.fluidLiquid, (int) (1000L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_UHV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(LanthItemList.NIOBIUM_CAVITY_CASING, 8),
                        GTOreDictUnificator.get(Circuits.UHV.getIngredient(), 2),
                        Field_Restriction_Coil_T1.get(1))
                .itemOutputs(ItemList.BeamStabilizer.get(1))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.Grade5PurifiedWater, FluidShapes.fluidLiquid, (int) (2000L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_UHV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(LanthItemList.SHIELDED_ACCELERATOR_GLASS, 4),
                        copyAmount(8, LanthItemList.BEAMLINE_PIPE),
                        MaterialLibAPI.getStack(Materials.ChromaticGlass, Shapes.plateDense, (int) (1)),
                        GTOreDictUnificator.get(Circuits.UHV.getIngredient(), 2))
                .itemOutputs(ItemList.BeamMirror.get(1))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.Grade5PurifiedWater, FluidShapes.fluidLiquid, (int) (2000L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_UHV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(LanthItemList.NIOBIUM_CAVITY_CASING, 1),
                        MaterialLibAPI.getStack(Materials.Lead, Shapes.plateDense, (int) (4L)))
                .itemOutputs(ItemList.StableEmptyContainmentUnit.get(64))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.EthylCyanoacrylateSuperGlue,
                                FluidShapes.fluidMolten,
                                (int) (10)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);
    }
}
