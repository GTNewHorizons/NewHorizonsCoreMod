package com.dreammaster.gthandler;

import com.dreammaster.gtppHandler.GTPPRecipeLoader;
import cpw.mods.fml.common.Loader;
import forestry.api.recipes.IFermenterRecipe;
import gregtech.api.GregTech_API;
import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_Utility;
import ic2.core.Ic2Items;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

import java.lang.reflect.Field;

import static com.dreammaster.bartworksHandler.BartWorksMaterials.getBartWorksMaterialByIGNName;
import static gregtech.api.enums.GT_Values.*;

public class GT_MachineRecipeLoader implements Runnable {
    @Override
    public void run() {
        GT_Values.RA.addBenderRecipe(CustomItemList.MicaInsulatorSheet.get(1L), CustomItemList.MicaInsulatorFoil.get(4L), 100, 30);

        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("IC2", "blockAlloyGlass", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 4L), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, CustomItemList.Empty180SpCell.get(1L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{CustomItemList.Empty180SpCell.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 3L), GT_Utility.getIntegratedCircuit(2)}, GT_Values.NF, CustomItemList.Empty360SpCell.get(1L), 200, 256);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{CustomItemList.Empty180SpCell.get(3L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 6L), GT_Utility.getIntegratedCircuit(3)}, GT_Values.NF, CustomItemList.Empty540SpCell.get(1L), 300, 480);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{CustomItemList.Empty180SpCell.get(1L), CustomItemList.Empty360SpCell.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 7L), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, CustomItemList.Empty540SpCell.get(1L), 100, 480);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{CustomItemList.Empty540SpCell.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 6L), GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.ElectrumFlux, 1L), GT_Utility.getIntegratedCircuit(2)}, GT_Values.NF, CustomItemList.Empty1080SpCell.get(1L), 200, 1024);

        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CallistoIce, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ledox, 1L), GT_Values.NI, GT_Values.NI, new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000), Materials.SuperCoolant.getFluid(2000), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ice, 2L), 200, 480);
        GT_Values.RA.addFluidCannerRecipe(CustomItemList.Empty180SpCell.get(1L), ItemList.Reactor_Coolant_Sp_1.get(1L), Materials.SuperCoolant.getFluid(1000L), GT_Values.NF);
        GT_Values.RA.addFluidCannerRecipe(CustomItemList.Empty360SpCell.get(1L), ItemList.Reactor_Coolant_Sp_2.get(1L), Materials.SuperCoolant.getFluid(2000L), GT_Values.NF);
        GT_Values.RA.addFluidCannerRecipe(CustomItemList.Empty540SpCell.get(1L), ItemList.Reactor_Coolant_Sp_3.get(1L), Materials.SuperCoolant.getFluid(3000L), GT_Values.NF);
        GT_Values.RA.addFluidCannerRecipe(CustomItemList.Empty1080SpCell.get(1L), ItemList.Reactor_Coolant_Sp_6.get(1L), Materials.SuperCoolant.getFluid(6000L), GT_Values.NF);

        GT_Values.RA.addAlloySmelterRecipe(CustomItemList.MicaBasedSheet.get(4L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L), CustomItemList.MicaInsulatorSheet.get(4L), 400, 30);
        GT_Values.RA.addAlloySmelterRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L), CustomItemList.AluminoSilicateWool.get(2L), 1200, 30);
        GT_Values.RA.addAlloySmelterRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sapphire, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L), CustomItemList.AluminoSilicateWool.get(2L), 1200, 30);
        GT_Values.RA.addAlloySmelterRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GreenSapphire, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L), CustomItemList.AluminoSilicateWool.get(2L), 1200, 30);

        GT_Values.RA.addAlloySmelterRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 3L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L), GT_ModHandler.getModItem("TConstruct", "materials", 4L, 14), 100, 120);

        makeCoilRecipes();

        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorLuV, 64L), CustomItemList.MicaInsulatorFoil.get(48L), Materials.Trinium.getMolten(1440L), ItemList.Casing_Coil_Superconductor.get(1L), 1000, 9001);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorZPM, 32L), CustomItemList.MicaInsulatorFoil.get(32L), Materials.Trinium.getMolten(576L), ItemList.Casing_Coil_Superconductor.get(1L), 1000, 9001);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUV, 16L), CustomItemList.MicaInsulatorFoil.get(16L), Materials.Trinium.getMolten(288L), ItemList.Casing_Coil_Superconductor.get(1L), 1000, 9001);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUHV, 8L), CustomItemList.MicaInsulatorFoil.get(8L), Materials.Trinium.getMolten(144L), ItemList.Casing_Coil_Superconductor.get(1L), 1000, 9001);

        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 3L), GT_Utility.getIntegratedCircuit(3), CustomItemList.SteelBars.get(4L), 400, 48);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 3L), GT_Utility.getIntegratedCircuit(3), CustomItemList.AluminiumBars.get(4L), 400, 64);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 3L), GT_Utility.getIntegratedCircuit(3), CustomItemList.StainlessSteelBars.get(4L), 400, 96);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 3L), GT_Utility.getIntegratedCircuit(3), CustomItemList.TitaniumBars.get(4L), 400, 120);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Tungsten, 3L), GT_Utility.getIntegratedCircuit(3), CustomItemList.TungstenBars.get(4L), 400, 192);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 3L), GT_Utility.getIntegratedCircuit(3), CustomItemList.TungstenSteelBars.get(4L), 400, 256);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Chrome, 3L), GT_Utility.getIntegratedCircuit(3), CustomItemList.ChromeBars.get(4L), 400, 480);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iridium, 3L), GT_Utility.getIntegratedCircuit(3), CustomItemList.IridiumBars.get(4L), 400, 1024);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Osmium, 3L), GT_Utility.getIntegratedCircuit(3), CustomItemList.OsmiumBars.get(4L), 400, 1920);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Neutronium, 3L), GT_Utility.getIntegratedCircuit(3), CustomItemList.NeutroniumBars.get(4L), 400, 4096);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.RedstoneAlloy, 3L), GT_Utility.getIntegratedCircuit(3), CustomItemList.RedstoneAlloyBars.get(4L), 400, 48);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.ElectricalSteel, 3L), GT_Utility.getIntegratedCircuit(3), CustomItemList.ElectricalSteelBars.get(4L), 400, 64);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.ConductiveIron, 3L), GT_Utility.getIntegratedCircuit(3), CustomItemList.ConductiveIronBars.get(4L), 400, 160);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.EnergeticAlloy, 3L), GT_Utility.getIntegratedCircuit(3), CustomItemList.EnergeticAlloyBars.get(4L), 400, 384);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.VibrantAlloy, 3L), GT_Utility.getIntegratedCircuit(3), CustomItemList.VibrantAlloyBars.get(4L), 400, 768);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.PulsatingIron, 3L), GT_Utility.getIntegratedCircuit(3), CustomItemList.PulsatingIronBars.get(4L), 400, 120);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Soularium, 3L), GT_Utility.getIntegratedCircuit(3), CustomItemList.SoulariumBars.get(4L), 400, 64);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.EnderiumBase, 3L), GT_Utility.getIntegratedCircuit(3), CustomItemList.EnderiumBaseBars.get(4L), 400, 256);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Enderium, 3L), GT_Utility.getIntegratedCircuit(3), CustomItemList.EnderiumBars.get(4L), 400, 1024);
        GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getIC2Item("carbonPlate", 4L), GT_Utility.getIntegratedCircuit(4), CustomItemList.CarbonPartBoots.get(1L), 400, 120);
        GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getIC2Item("carbonPlate", 8L), GT_Utility.getIntegratedCircuit(8), CustomItemList.CarbonPartChestplate.get(1L), 400, 120);
        GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getIC2Item("carbonPlate", 5L), GT_Utility.getIntegratedCircuit(5), CustomItemList.CarbonPartHelmet.get(1L), 400, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CarbonPartHelmet.get(1L), GT_ModHandler.getModItem("IC2", "itemNightvisionGoggles", 1L, GT_Values.W), CustomItemList.CarbonPartHelmetNightVision.get(1L), 600, 256);
        GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getIC2Item("carbonPlate", 7L), GT_Utility.getIntegratedCircuit(7), CustomItemList.CarbonPartLeggings.get(1L), 400, 120);
        GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem("IC2", "itemArmorRubBoots", 1L, 0), GT_ModHandler.getModItem("IC2", "itemArmorNanoBoots", 1L, GT_Values.W), CustomItemList.NanoRubberBoots.get(1L), 800, 1024);
        //GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem("IC2", "itemArmorNanoChestplate", 1L, GT_Values.W), GT_ModHandler.getModItem("IC2", "itemArmorJetpackElectric", 1L, GT_Values.W), CustomItemList.NanoChestJetPack.get(1L), 800, 1024);
        GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem("IC2", "itemArmorNanoLegs", 1L, GT_Values.W), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.StainlessSteel, 4L), CustomItemList.NanoPlatedLeggings.get(1L), 800, 1024);
        GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem("IC2", "itemArmorNanoHelmet", 1L, GT_Values.W), GT_ModHandler.getModItem("IC2", "itemArmorHazmatHelmet", 1L, 0), CustomItemList.NanoScubaHelmet.get(1L), 800, 1024);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.NanoRubberBoots.get(1L), CustomItemList.IridiumAlloyItemCasing.get(4L), CustomItemList.QuantumPartBoots.get(1L), 1200, 1920);
        GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem("GraviSuite", "advNanoChestPlate", 1L, GT_Values.W), CustomItemList.IridiumAlloyItemCasing.get(8L), CustomItemList.QuantumPartChestplate.get(1L), 1200, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.NanoScubaHelmet.get(1L), CustomItemList.IridiumAlloyItemCasing.get(5L), CustomItemList.QuantumPartHelmetEmpty.get(1L), 1200, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.QuantumPartHelmetEmpty.get(1L), CustomItemList.ReinforcedGlassLense.get(8L), CustomItemList.QuantumPartHelmet.get(1L), 1200, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.NanoPlatedLeggings.get(1L), CustomItemList.IridiumAlloyItemCasing.get(7L), CustomItemList.QuantumPartLeggings.get(1L), 1200, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.NagaScaleChip.get(4L), GT_Utility.getIntegratedCircuit(4), Materials.Thaumium.getMolten(72L), CustomItemList.NagaScaleFragment.get(1L), 200, 48);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.NagaScaleFragment.get(6L), GT_Utility.getIntegratedCircuit(6), Materials.Thaumium.getMolten(216L), GT_ModHandler.getModItem("TwilightForest", "item.nagaScale", 1L, 0), 200, 96);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.LichBoneChip.get(4L), GT_Utility.getIntegratedCircuit(4), Materials.Thaumium.getMolten(72L), CustomItemList.LichBoneFragment.get(1L), 250, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.LichBoneFragment.get(6L), GT_Utility.getIntegratedCircuit(6), Materials.Thaumium.getMolten(216L), CustomItemList.LichBone.get(1L), 250, 256);
        GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 4L, 14), GT_ModHandler.getModItem("TwilightForest", "item.trophy", 0L, 2), CustomItemList.LichBone.get(1L), 900, 256);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CarminiteChip.get(4L), GT_Utility.getIntegratedCircuit(4), Materials.Thaumium.getMolten(72L), CustomItemList.CarminiteFragment.get(1L), 350, 1024);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CarminiteFragment.get(6L), GT_Utility.getIntegratedCircuit(6), Materials.Thaumium.getMolten(216L), GT_ModHandler.getModItem("TwilightForest", "item.carminite", 1L, 0), 350, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.SnowQueenBloodDrop.get(24L), GT_Utility.getIntegratedCircuit(24), Materials.Thaumium.getMolten(216L), CustomItemList.SnowQueenBlood.get(1L), 400, 4096);
        GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 10L, 14), GT_ModHandler.getModItem("TwilightForest", "item.trophy", 0L, 4), CustomItemList.SnowQueenBlood.get(1L), 1800, 7680);
        GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 16L, 14), GT_ModHandler.getModItem("witchery", "ingredient", 1L, 130), GT_OreDictUnificator.get(OrePrefixes.gem, Materials.NetherStar, 1), 900, 256);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 1L), GT_OreDictUnificator.get(OrePrefixes.slab, Materials.Wood, 3L), Materials.Iron.getMolten(32L), CustomItemList.WoodenCasing.get(1L), 100, 8);

        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{CustomItemList.EngineCore.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4L),  GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L), GT_Utility.getIntegratedCircuit(10)},  GT_Values.NF, GT_ModHandler.getModItem(MOD_ID_FR, "engine", 1L, 0), 200, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{CustomItemList.EngineCore.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 10L),  GT_Utility.getIntegratedCircuit(10)}, GT_Values.NF, GT_ModHandler.getModItem(MOD_ID_FR, "engine", 1L, 1), 200, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{CustomItemList.EngineCore.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 10L),  GT_Utility.getIntegratedCircuit(10)}, GT_Values.NF, GT_ModHandler.getModItem(MOD_ID_FR, "engine", 1L, 2), 200, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{CustomItemList.EngineCore.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Invar, 10L),  GT_Utility.getIntegratedCircuit(10)}, GT_Values.NF, GT_ModHandler.getModItem(MOD_ID_BC_CORE, "engineBlock", 1L, 2), 200, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{CustomItemList.EngineCore.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.WroughtIron, 10L), GT_Utility.getIntegratedCircuit(10)}, GT_Values.NF, GT_ModHandler.getModItem(MOD_ID_FR, "engine", 1L, 4), 200, 16);
        //HEE Ectoplasma and Arcane Shards
        GT_Values.RA.addAssemblerRecipe(CustomItemList.EctoplasmaChip.get(4L), GT_Utility.getIntegratedCircuit(4), FluidRegistry.getFluidStack("endergoo", 100), CustomItemList.EctoplasmaFragment.get(1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.EctoplasmaFragment.get(6L), GT_Utility.getIntegratedCircuit(6), FluidRegistry.getFluidStack("endergoo", 200), GT_ModHandler.getModItem("HardcoreEnderExpansion", "endoplasm", 1L, 0), 200, 240);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.ArcaneShardChip.get(4L), GT_Utility.getIntegratedCircuit(4), FluidRegistry.getFluidStack("endergoo", 100), CustomItemList.ArcaneShardFragment.get(1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.ArcaneShardFragment.get(6L), GT_Utility.getIntegratedCircuit(6), FluidRegistry.getFluidStack("endergoo", 200), GT_ModHandler.getModItem("HardcoreEnderExpansion", "arcane_shard", 1L, 0), 200, 240);
        //HEE Runes
        GT_Values.RA.addAssemblerRecipe(CustomItemList.RuneOfPowerFragment.get(9L), GT_Utility.getIntegratedCircuit(9), FluidRegistry.getFluidStack("endergoo", 1000), GT_ModHandler.getModItem("HardcoreEnderExpansion", "rune", 1L, 0), 2400, 7680);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.RuneOfAgilityFragment.get(9L), GT_Utility.getIntegratedCircuit(9), FluidRegistry.getFluidStack("endergoo", 1000), GT_ModHandler.getModItem("HardcoreEnderExpansion", "rune", 1L, 1), 2400, 7680);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.RuneOfVigorFragment.get(9L), GT_Utility.getIntegratedCircuit(9), FluidRegistry.getFluidStack("endergoo", 1000), GT_ModHandler.getModItem("HardcoreEnderExpansion", "rune", 1L, 2), 2400, 7680);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.RuneOfDefenseFragment.get(9L), GT_Utility.getIntegratedCircuit(9), FluidRegistry.getFluidStack("endergoo", 1000), GT_ModHandler.getModItem("HardcoreEnderExpansion", "rune", 1L, 3), 2400, 7680);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.RuneOfMagicFragment.get(9L), GT_Utility.getIntegratedCircuit(9), FluidRegistry.getFluidStack("endergoo", 1000), GT_ModHandler.getModItem("HardcoreEnderExpansion", "rune", 1L, 4), 2400, 7680);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.RuneOfVoidFragment.get(9L), GT_Utility.getIntegratedCircuit(9), FluidRegistry.getFluidStack("endergoo", 1000), GT_ModHandler.getModItem("HardcoreEnderExpansion", "rune", 1L, 5), 2400, 7680);

        //IC2 Charging Batteries
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("IC2", "itemBatREDischarged", 4L, GT_Values.W), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 4L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BatteryAlloy, 1L), GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getGas(144L), GT_ModHandler.getModItem("IC2", "itemBatChargeRE", 1L, 0), 200, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("IC2", "itemBatChargeRE", 1L, GT_Values.W), GT_ModHandler.getModItem("IC2", "itemAdvBat", 1L, GT_Values.W), GT_ModHandler.getModItem("IC2", "itemAdvBat", 1L, GT_Values.W), GT_ModHandler.getModItem("IC2", "itemAdvBat", 1L, GT_Values.W), GT_ModHandler.getModItem("IC2", "itemAdvBat", 1L, GT_Values.W), GT_ModHandler.getModItem("IC2", "reactorHeatSwitchSpread", 1L, 1), GT_ModHandler.getModItem("IC2", "reactorHeatSwitch", 1L, 1), GT_ModHandler.getModItem("IC2", "reactorHeatSwitch", 1L, 1), GT_ModHandler.getModItem("IC2", "reactorHeatSwitch", 1L, 1),}, Materials.SolderingAlloy.getGas(288L), GT_ModHandler.getModItem("IC2", "itemBatChargeAdv", 1L, 0), 200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("IC2", "itemBatChargeAdv", 1L, GT_Values.W), GT_ModHandler.getModItem("IC2", "itemBatCrystal", 1L, GT_Values.W), GT_ModHandler.getModItem("IC2", "itemBatCrystal", 1L, GT_Values.W), GT_ModHandler.getModItem("IC2", "itemBatCrystal", 1L, GT_Values.W), GT_ModHandler.getModItem("IC2", "itemBatCrystal", 1L, GT_Values.W), GT_ModHandler.getModItem("IC2", "reactorHeatSwitchSpread", 1L, 1), GT_ModHandler.getModItem("IC2", "reactorHeatSwitchSpread", 1L, 1), GT_ModHandler.getModItem("IC2", "reactorHeatSwitchSpread", 1L, 1), GT_ModHandler.getModItem("IC2", "reactorHeatSwitchSpread", 1L, 1)}, Materials.SolderingAlloy.getGas(576L), GT_ModHandler.getModItem("IC2", "itemBatChargeCrystal", 1L, 0), 200, 480);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("IC2", "itemBatChargeCrystal", 1L, GT_Values.W), GT_ModHandler.getModItem("IC2", "itemBatLamaCrystal", 1L, GT_Values.W), GT_ModHandler.getModItem("IC2", "itemBatLamaCrystal", 1L, GT_Values.W), GT_ModHandler.getModItem("IC2", "itemBatLamaCrystal", 1L, GT_Values.W), GT_ModHandler.getModItem("IC2", "itemBatLamaCrystal", 1L, GT_Values.W), GT_ModHandler.getModItem("IC2", "reactorHeatSwitchDiamond", 1L, 1), GT_ModHandler.getModItem("IC2", "reactorHeatSwitchDiamond", 1L, 1), GT_ModHandler.getModItem("IC2", "reactorHeatSwitchDiamond", 1L, 1), GT_ModHandler.getModItem("IC2", "reactorHeatSwitchDiamond", 1L, 1)}, Materials.SolderingAlloy.getGas(1440L), GT_ModHandler.getModItem("IC2", "itemBatChargeLamaCrystal", 1L, 0), 200, 1920);

        //Coins
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinAdventure.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinAdventureI.get(1L), 100, 30);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinAdventureI.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinAdventureII.get(1L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinAdventureII.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinAdventureIII.get(1L), 100, 480);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinAdventureIII.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinAdventureIV.get(1L), 100, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinBees.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinBeesI.get(1L), 100, 30);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinBeesI.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinBeesII.get(1L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinBeesII.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinBeesIII.get(1L), 100, 480);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinBeesIII.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinBeesIV.get(1L), 100, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinBlood.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinBloodI.get(1L), 100, 30);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinBloodI.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinBloodII.get(1L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinBloodII.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinBloodIII.get(1L), 100, 480);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinBloodIII.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinBloodIV.get(1L), 100, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinChemist.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinChemistI.get(1L), 100, 30);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinChemistI.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinChemistII.get(1L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinChemistII.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinChemistIII.get(1L), 100, 480);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinChemistIII.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinChemistIV.get(1L), 100, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinCook.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinCookI.get(1L), 100, 30);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinCookI.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinCookII.get(1L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinCookII.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinCookIII.get(1L), 100, 480);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinCookIII.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinCookIV.get(1L), 100, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinDarkWizard.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinDarkWizardI.get(1L), 100, 30);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinDarkWizardI.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinDarkWizardII.get(1L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinDarkWizardII.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinDarkWizardIII.get(1L), 100, 480);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinDarkWizardIII.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinDarkWizardIV.get(1L), 100, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinFarmer.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinFarmerI.get(1L), 100, 30);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinFarmerI.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinFarmerII.get(1L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinFarmerII.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinFarmerIII.get(1L), 100, 480);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinFarmerIII.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinFarmerIV.get(1L), 100, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinForestry.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinForestryI.get(1L), 100, 30);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinForestryI.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinForestryII.get(1L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinForestryII.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinForestryIII.get(1L), 100, 480);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinForestryIII.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinForestryIV.get(1L), 100, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinSpace.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinSpaceI.get(1L), 100, 30);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinSpaceI.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinSpaceII.get(1L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinSpaceII.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinSpaceIII.get(1L), 100, 480);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinSpaceIII.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinSpaceIV.get(1L), 100, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinSurvivor.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinSurvivorI.get(1L), 100, 30);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinSurvivorI.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinSurvivorII.get(1L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinSurvivorII.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinSurvivorIII.get(1L), 100, 480);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinSurvivorIII.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinSurvivorIV.get(1L), 100, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinTechnician.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinTechnicianI.get(1L), 100, 30);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinTechnicianI.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinTechnicianII.get(1L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinTechnicianII.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinTechnicianIII.get(1L), 100, 480);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinTechnicianIII.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinTechnicianIV.get(1L), 100, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinSmith.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinSmithI.get(1L), 100, 30);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinSmithI.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinSmithII.get(1L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinSmithII.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinSmithIII.get(1L), 100, 480);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinSmithIII.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinSmithIV.get(1L), 100, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinWitch.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinWitchI.get(1L), 100, 30);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinWitchI.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinWitchII.get(1L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinWitchII.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinWitchIII.get(1L), 100, 480);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinWitchIII.get(10L), GT_Utility.getIntegratedCircuit(10), CustomItemList.CoinWitchIV.get(1L), 100, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinAdventureI.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinAdventure.get(10L), 100, 30);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinAdventureII.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinAdventureI.get(10L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinAdventureIII.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinAdventureII.get(10L), 100, 480);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinAdventureIV.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinAdventureIII.get(10L), 100, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinBeesI.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinBees.get(10L), 100, 30);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinBeesII.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinBeesI.get(10L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinBeesIII.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinBeesII.get(10L), 100, 480);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinBeesIV.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinBeesIII.get(10L), 100, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinBloodI.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinBlood.get(10L), 100, 30);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinBloodII.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinBloodI.get(10L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinBloodIII.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinBloodII.get(10L), 100, 480);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinBloodIV.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinBloodIII.get(10L), 100, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinChemistI.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinChemist.get(10L), 100, 30);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinChemistII.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinChemistI.get(10L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinChemistIII.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinChemistII.get(10L), 100, 480);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinChemistIV.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinChemistIII.get(10L), 100, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinCookI.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinCook.get(10L), 100, 30);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinCookII.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinCookI.get(10L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinCookIII.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinCookII.get(10L), 100, 480);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinCookIV.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinCookIII.get(10L), 100, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinDarkWizardI.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinDarkWizard.get(10L), 100, 30);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinDarkWizardII.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinDarkWizardI.get(10L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinDarkWizardIII.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinDarkWizardII.get(10L), 100, 480);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinDarkWizardIV.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinDarkWizardIII.get(10L), 100, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinFarmerI.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinFarmer.get(10L), 100, 30);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinFarmerII.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinFarmerI.get(10L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinFarmerIII.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinFarmerII.get(10L), 100, 480);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinFarmerIV.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinFarmerIII.get(10L), 100, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinForestryI.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinForestry.get(10L), 100, 30);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinForestryII.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinForestryI.get(10L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinForestryIII.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinForestryII.get(10L), 100, 480);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinForestryIV.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinForestryIII.get(10L), 100, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinSpaceI.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinSpace.get(10L), 100, 30);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinSpaceII.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinSpaceI.get(10L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinSpaceIII.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinSpaceII.get(10L), 100, 480);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinSpaceIV.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinSpaceIII.get(10L), 100, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinSurvivorI.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinSurvivor.get(10L), 100, 30);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinSurvivorII.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinSurvivorI.get(10L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinSurvivorIII.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinSurvivorII.get(10L), 100, 480);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinSurvivorIV.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinSurvivorIII.get(10L), 100, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinTechnicianI.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinTechnician.get(10L), 100, 30);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinTechnicianII.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinTechnicianI.get(10L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinTechnicianIII.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinTechnicianII.get(10L), 100, 480);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinTechnicianIV.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinTechnicianIII.get(10L), 100, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinSmithI.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinSmith.get(10L), 100, 30);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinSmithII.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinSmithI.get(10L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinSmithIII.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinSmithII.get(10L), 100, 480);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinSmithIV.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinSmithIII.get(10L), 100, 1920);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinWitchI.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinWitch.get(10L), 100, 30);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinWitchII.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinWitchI.get(10L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinWitchIII.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinWitchII.get(10L), 100, 480);
        GT_Values.RA.addAssemblerRecipe(CustomItemList.CoinWitchIV.get(1L), GT_Utility.getIntegratedCircuit(1), CustomItemList.CoinWitchIII.get(10L), 100, 1920);

        //Air Filter stuff
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1L), GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getFluid(72), CustomItemList.Casing_AirFilter_Vent.get(1L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1L), GT_Utility.getIntegratedCircuit(1)}, Materials.Tin.getFluid(144), CustomItemList.Casing_AirFilter_Vent.get(1L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1L), GT_Utility.getIntegratedCircuit(1)}, Materials.Lead.getFluid(288), CustomItemList.Casing_AirFilter_Vent.get(1L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{CustomItemList.Casing_AirFilter_Vent.get(1L), GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.StainlessSteel, 2L), ItemList.Electric_Motor_HV.get(2L), GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getFluid(72), CustomItemList.Casing_AirFilter_Turbine.get(1L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{CustomItemList.Casing_AirFilter_Vent.get(1L), GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.StainlessSteel, 2L), ItemList.Electric_Motor_HV.get(2L), GT_Utility.getIntegratedCircuit(1)}, Materials.Tin.getFluid(144), CustomItemList.Casing_AirFilter_Turbine.get(1L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{CustomItemList.Casing_AirFilter_Vent.get(1L), GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.StainlessSteel, 2L), ItemList.Electric_Motor_HV.get(2L), GT_Utility.getIntegratedCircuit(1)}, Materials.Lead.getFluid(288), CustomItemList.Casing_AirFilter_Turbine.get(1L), 100, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_HV.get(1L), ItemList.Casing_Turbine1.get(1L), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1L), ItemList.Electric_Motor_HV.get(2L), ItemList.Electric_Pump_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1L), GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getFluid(144), CustomItemList.Machine_Multi_AirFilter.get(1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_HV.get(1L), ItemList.Casing_Turbine1.get(1L), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1L), ItemList.Electric_Motor_HV.get(2L), ItemList.Electric_Pump_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1L), GT_Utility.getIntegratedCircuit(1)}, Materials.Tin.getFluid(288), CustomItemList.Machine_Multi_AirFilter.get(1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_HV.get(1L), ItemList.Casing_Turbine1.get(1L), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1L), ItemList.Electric_Motor_HV.get(2L), ItemList.Electric_Pump_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1L), GT_Utility.getIntegratedCircuit(1)}, Materials.Lead.getFluid(576), CustomItemList.Machine_Multi_AirFilter.get(1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.StainlessSteel, 16L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 4L), CustomItemList.AdsorptionFilterCasing.get(1L), 200, 480);
        GT_Values.RA.addCannerRecipe(CustomItemList.AdsorptionFilterCasing.get(1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 32L), CustomItemList.AdsorptionFilter.get(1L), GT_Values.NI, 100, 120);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.AdsorptionFilterDirty.get(1L), GT_Values.NI, GT_Values.NF, new FluidStack(FluidRegistry.getFluid("pollution"), 100), CustomItemList.AdsorptionFilterCasing.get(1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 8L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAsh, 8L), GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{9000, 10000, 10000}, 1200, 480);

        //GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Platinum, 6L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Polytetrafluoroethylene, 4L), CustomItemList.NanoBoard.get(1L), 400, 1920);
        //GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Palladium, 8L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Polytetrafluoroethylene, 8L), CustomItemList.QuantumBoard.get(1L), 200, 7680);

        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 4L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 4L), ItemList.Electric_Motor_MV.get(4L), ItemList.Electric_Pump_MV.get(4L), GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Cobalt, 4L), GT_Utility.getIntegratedCircuit(2)}, Materials.SolderingAlloy.getFluid(18), ItemList.OilDrill1.get(1L), 400, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.OilDrill1.get(1L), GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 4L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4L), ItemList.Electric_Motor_HV.get(4L), ItemList.Electric_Pump_HV.get(4L), GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.BlueSteel, 4L), GT_Utility.getIntegratedCircuit(2)}, Materials.SolderingAlloy.getFluid(36), ItemList.OilDrill2.get(1L), 400, 480);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.OilDrill2.get(1L), GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 4L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4L), ItemList.Electric_Motor_EV.get(4L), ItemList.Electric_Pump_EV.get(4L), GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.TungstenSteel, 4L), GT_Utility.getIntegratedCircuit(2)}, Materials.SolderingAlloy.getFluid(72), ItemList.OilDrill3.get(1L), 400, 1920);

        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 4L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4L), ItemList.Electric_Motor_EV.get(4L), ItemList.Electric_Pump_EV.get(4L), ItemList.Conveyor_Module_EV.get(4L), GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Tungsten, 4L), GT_Utility.getIntegratedCircuit(2)}, Materials.SolderingAlloy.getFluid(72), ItemList.OreDrill1.get(1L), 400, 1920);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.OreDrill1.get(1L), GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 4L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4L), ItemList.Electric_Motor_IV.get(4L), ItemList.Electric_Pump_IV.get(4L), ItemList.Conveyor_Module_IV.get(4L), GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Iridium, 4L), GT_Utility.getIntegratedCircuit(2)}, Materials.SolderingAlloy.getFluid(144), ItemList.OreDrill2.get(1L), 400, 7680);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.OreDrill2.get(1L), GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Osmiridium, 4L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4L), ItemList.Electric_Motor_LuV.get(4L), ItemList.Electric_Pump_LuV.get(4L), ItemList.Conveyor_Module_LuV.get(4L), GT_OreDictUnificator.get(OrePrefixes.gearGt, Loader.isModLoaded("bartworks") ? getBartWorksMaterialByIGNName("Rhodium-Plated Palladium") : Materials.Chrome, 4L), GT_Utility.getIntegratedCircuit(2)}, Materials.SolderingAlloy.getFluid(288), ItemList.OreDrill3.get(1L), 400, 30720);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.OreDrill3.get(1L), GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Tritanium, 4L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 4L), ItemList.Electric_Motor_ZPM.get(4L), ItemList.Electric_Pump_ZPM.get(4L), ItemList.Conveyor_Module_ZPM.get(4L), GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.MysteriousCrystal, 4L), GT_Utility.getIntegratedCircuit(2)}, Materials.SolderingAlloy.getFluid(576), ItemList.OreDrill4.get(1L), 400, 122880);

        /*
        GT_Values.RA.addAssemblerRecipe(ItemList.Circuit_Data.get(1L), GT_ModHandler.getModItem("GalacticraftMars", "item.schematic", 0L, 2), CustomItemList.SchematicsAstroMiner.get(1L), 40, 480);
        GT_Values.RA.addAssemblerRecipe(ItemList.Circuit_Data.get(1L), GT_ModHandler.getModItem("GalacticraftMars", "item.schematic", 0L, 1), CustomItemList.SchematicsCargoRocket.get(1L), 40, 480);
        GT_Values.RA.addAssemblerRecipe(ItemList.Circuit_Data.get(1L), GT_ModHandler.getModItem("GalacticraftCore", "item.schematic", 0L, 0), CustomItemList.SchematicsMoonBuggy.get(1L), 20, 256);
        GT_Values.RA.addAssemblerRecipe(ItemList.Circuit_Data.get(1L), GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 9), CustomItemList.SchematicsTier1.get(1L), 10, 120);
        GT_Values.RA.addAssemblerRecipe(ItemList.Circuit_Data.get(1L), GT_ModHandler.getModItem("GalacticraftCore", "item.schematic", 0L, 1), CustomItemList.SchematicsTier2.get(1L), 20, 256);
        GT_Values.RA.addAssemblerRecipe(ItemList.Circuit_Data.get(1L), GT_ModHandler.getModItem("GalacticraftMars", "item.schematic", 0L, 0), CustomItemList.SchematicsTier3.get(1L), 40, 480);
        GT_Values.RA.addAssemblerRecipe(ItemList.Circuit_Data.get(1L), GT_ModHandler.getModItem("GalaxySpace", "item.SchematicTier4", 0L, 0), CustomItemList.SchematicsTier4.get(1L), 60, 1024);
        GT_Values.RA.addAssemblerRecipe(ItemList.Circuit_Data.get(1L), GT_ModHandler.getModItem("GalaxySpace", "item.SchematicTier5", 0L, 0), CustomItemList.SchematicsTier5.get(1L), 80, 1920);
        GT_Values.RA.addAssemblerRecipe(ItemList.Circuit_Data.get(1L), GT_ModHandler.getModItem("GalaxySpace", "item.SchematicTier6", 0L, 0), CustomItemList.SchematicsTier6.get(1L), 100, 4096);
        GT_Values.RA.addAssemblerRecipe(ItemList.Circuit_Data.get(1L), GT_ModHandler.getModItem("GalaxySpace", "item.SchematicTier7", 0L, 0), CustomItemList.SchematicsTier7.get(1L), 120, 7680);
        GT_Values.RA.addAssemblerRecipe(ItemList.Circuit_Data.get(1L), GT_ModHandler.getModItem("GalaxySpace", "item.SchematicTier8", 0L, 0), CustomItemList.SchematicsTier8.get(1L), 140, 30720);
        */

        GT_Values.RA.addAssemblerRecipe(CustomItemList.LedoxCompressedPlate.get(1L), CustomItemList.CallistoIceCompressedPlate.get(1L), new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000), CustomItemList.IceCompressedPlate.get(2L), 300, 7680);
//        GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 0), CustomItemList.IceCompressedPlate.get(6L), Materials.Osmium.getMolten(144L), CustomItemList.HeavyDutyAlloyIngotT4.get(1L), 300, 30720);
//        GT_Values.RA.addAssemblerRecipe(CustomItemList.HeavyDutyPlateTier4.get(1L), CustomItemList.QuantinumCompressedPlate.get(8L), Materials.NaquadahAlloy.getMolten(288L), CustomItemList.HeavyDutyAlloyIngotT5.get(1L), 300, 122880);
//        GT_Values.RA.addAssemblerRecipe(CustomItemList.HeavyDutyPlateTier5.get(1L), CustomItemList.LeadOriharukonPlate.get(10L),  Materials.Tritanium.getMolten(576L), CustomItemList.HeavyDutyAlloyIngotT6.get(1L), 300, 500000);
//        GT_Values.RA.addAssemblerRecipe(CustomItemList.HeavyDutyPlateTier6.get(1L), CustomItemList.MysteriousCrystalCompressedPlate.get(12L), Materials.Neutronium.getMolten(1152L), CustomItemList.HeavyDutyAlloyIngotT7.get(1L), 300, 2000000);
//        GT_Values.RA.addAssemblerRecipe(CustomItemList.HeavyDutyPlateTier7.get(1L), CustomItemList.BlackPlutoniumCompressedPlate.get(14L), Materials.Neutronium.getMolten(4608L), CustomItemList.HeavyDutyAlloyIngotT8.get(1L), 1200, 2000000);
        GT_Values.RA.addAssemblylineRecipe(
                GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 0),
                2500,
                new ItemStack[]{
                        GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 0),
                        CustomItemList.IceCompressedPlate.get(3L),
                        CustomItemList.IceCompressedPlate.get(3L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Osmiridium, 4)
                },
                new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(36)
                },
                CustomItemList.HeavyDutyAlloyIngotT4.get(1L), 300, 30720
        );
        GT_Values.RA.addAssemblylineRecipe(
                CustomItemList.HeavyDutyPlateTier4.get(1L),
                5000,
                new ItemStack[]{
                        CustomItemList.HeavyDutyPlateTier4.get(1L),
                        CustomItemList.QuantinumCompressedPlate.get(4L),
                        CustomItemList.QuantinumCompressedPlate.get(4L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Europium, 8)
                },
                new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(72)
                },
                CustomItemList.HeavyDutyAlloyIngotT5.get(1L), 300, 122880
        );
        GT_Values.RA.addAssemblylineRecipe(
                CustomItemList.HeavyDutyPlateTier5.get(1L),
                7500,
                new ItemStack[]{
                        CustomItemList.HeavyDutyPlateTier5.get(1L),
                        CustomItemList.LeadOriharukonPlate.get(5L),
                        CustomItemList.LeadOriharukonPlate.get(5L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tritanium, 8)
                },
                new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(144)
                },
                CustomItemList.HeavyDutyAlloyIngotT6.get(1L), 300, 500000
        );
        GT_Values.RA.addAssemblylineRecipe(
                CustomItemList.HeavyDutyPlateTier6.get(1L),
                10000,
                new ItemStack[]{
                        CustomItemList.HeavyDutyPlateTier6.get(1L),
                        CustomItemList.MysteriousCrystalCompressedPlate.get(6L),
                        CustomItemList.MysteriousCrystalCompressedPlate.get(6L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Neutronium, 10)
                },
                new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(288)
                },
                CustomItemList.HeavyDutyAlloyIngotT7.get(1L), 300, 2000000
        );
        GT_Values.RA.addAssemblylineRecipe(
                CustomItemList.HeavyDutyPlateTier7.get(1L),
                12500,
                new ItemStack[]{
                        CustomItemList.HeavyDutyPlateTier7.get(1L),
                        CustomItemList.BlackPlutoniumCompressedPlate.get(7L),
                        CustomItemList.BlackPlutoniumCompressedPlate.get(7L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.BlackPlutonium, 12)
                },
                new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(576)
                },
                CustomItemList.HeavyDutyAlloyIngotT8.get(1L), 300, 8000000
        );

        GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 7), GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 3), new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000), CustomItemList.LeadOriharukonPlate.get(2L), 300, 500000);

        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 9L), GT_Utility.getIntegratedCircuit(1), Materials.UUMatter.getMolten(1000L), GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0), 1, 122880);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Unstable, 9L), GT_Utility.getIntegratedCircuit(1), Materials.UUMatter.getMolten(1000L), GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2), 1, 122880);

        //UEV-UMV casings+hulls
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(CustomItemList.BedrockiumPlate.get(8L)), GT_Utility.getIntegratedCircuit(8), CustomItemList.Casing_UEV.get(1L), 50, 16);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 8L), GT_Utility.getIntegratedCircuit(8), CustomItemList.Casing_UIV.get(1L), 50, 16);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Draconium, 8L), GT_Utility.getIntegratedCircuit(8), CustomItemList.Casing_UMV.get(1L), 50, 16);

        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.cableGt08, Materials.Draconium, 2L), CustomItemList.Casing_UEV.get(1L), Materials.Polybenzimidazole.getMolten(576L), CustomItemList.Hull_UEV.get(1L), 50, 16);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.cableGt08, Materials.NetherStar, 2L), CustomItemList.Casing_UIV.get(1L), Materials.Polybenzimidazole.getMolten(576L), CustomItemList.Hull_UIV.get(1L), 50, 16);
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt12, Materials.Quantium, 2L), CustomItemList.Casing_UMV.get(1L), Materials.Polybenzimidazole.getMolten(576L), CustomItemList.Hull_UMV.get(1L), 50, 16);

        //Hermetic casings
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Plastic, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 8L), GT_Utility.getIntegratedCircuit(4)}, GT_Values.NF, ItemList.Casing_Tank_1.get(1L), 100, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.PolyvinylChloride, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 8L), GT_Utility.getIntegratedCircuit(4)}, GT_Values.NF, ItemList.Casing_Tank_2.get(1L), 100, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Polytetrafluoroethylene, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 8L), GT_Utility.getIntegratedCircuit(4)}, GT_Values.NF, ItemList.Casing_Tank_3.get(1L), 100, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.StainlessSteel, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 8L), GT_Utility.getIntegratedCircuit(4)}, GT_Values.NF, ItemList.Casing_Tank_4.get(1L), 100, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Titanium, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 8L), GT_Utility.getIntegratedCircuit(4)}, GT_Values.NF, ItemList.Casing_Tank_5.get(1L), 100, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.TungstenSteel, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 8L), GT_Utility.getIntegratedCircuit(4)}, GT_Values.NF, ItemList.Casing_Tank_6.get(1L), 100, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.NiobiumTitanium, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 8L), GT_Utility.getIntegratedCircuit(4)}, GT_Values.NF, ItemList.Casing_Tank_7.get(1L), 100, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Enderium, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmium, 8L), GT_Utility.getIntegratedCircuit(4)}, GT_Values.NF, ItemList.Casing_Tank_8.get(1L), 100, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Naquadah, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 8L), GT_Utility.getIntegratedCircuit(4)}, GT_Values.NF, ItemList.Casing_Tank_9.get(1L), 100, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.MysteriousCrystal, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bedrockium, 8L), GT_Utility.getIntegratedCircuit(4)}, GT_Values.NF, ItemList.Casing_Tank_10.get(1L), 100, 16);

        GT_Values.RA.addAssemblerRecipe(new ItemStack(Items.diamond, 1, 0), ItemList.Circuit_Basic.get(4L), CustomItemList.TwilightCrystal.get(1L), 600, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack(Items.diamond, 1, 0), GT_ModHandler.getModItem("IC2", "itemPartCircuit", 4L, 0), CustomItemList.TwilightCrystal.get(1L), 600, 16);

        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L), GT_Utility.getIntegratedCircuit(1)}, Materials.Glass.getMolten(72L), GT_ModHandler.getModItem("irontank", "goldDiamondUpgrade", 1L, 0), 600, 120);

        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{CustomItemList.RawLapotronCrystal.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L)}, GT_Values.NF, GT_ModHandler.getIC2Item("lapotronCrystal", 1L), 600, 1024);

        GT_Values.RA.addAssemblerRecipe(ItemList.Firebrick.get(24), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gypsum, 8L), new FluidStack(FluidRegistry.getFluid("concrete"), 4608), ItemList.Casing_Firebricks.get(4L), 200, 30);
        GT_Values.RA.addAssemblerRecipe(ItemList.Firebrick.get(24), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gypsum, 8L), Materials.Concrete.getMolten(4608L), ItemList.Casing_Firebricks.get(4L), 200, 30);

        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Blocks.brick_block), Materials.AnyBronze.getPlates(6)}, GT_Values.NF, ItemList.Casing_BronzePlatedBricks.get(1L), 200, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{Materials.Steel.getPlates(4), Materials.Iron.getPlates(2), ItemList.Casing_BronzePlatedBricks.get(1L)}, GT_Values.NF, CustomItemList.Casing_Pyrolyse.get(1L), 200, 30);

        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Carbon, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glowstone, 1L), GT_ModHandler.getModItem("FloodLights", "electricIncandescentLightBulb", 1L, 0), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, GT_ModHandler.getModItem("GalacticraftCore", "tile.glowstoneTorch", 32L, 0), 400, 192);

        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.log, Materials.Wood, 4L), GT_OreDictUnificator.get(OrePrefixes.treeSapling, 4L), new ItemStack(Items.compass, 1, 0)}, Materials.Glue.getFluid(144L), GT_ModHandler.getModItem("naturescompass", "NaturesCompass", 1L, 0), 200, 30);

        GT_Values.RA.addAssemblerRecipe(new ItemStack(Items.string, 3, 0), GT_Utility.getIntegratedCircuit(1), new ItemStack(Blocks.wool, 1, 0), 100, 4);

        GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem("dreamcraft", "item.CarbonPartHelmetNightVision", 1, 0), GT_ModHandler.getModItem("dreamcraft", "item.NanoCrystal", 1, 0), Materials.Redstone.getMolten(144L), GT_ModHandler.getModItem("IC2", "itemArmorNanoHelmet", 1), 600, 480);
        GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem("dreamcraft", "item.CarbonPartChestplate", 1, 0), GT_ModHandler.getModItem("dreamcraft", "item.NanoCrystal", 1, 0), Materials.Redstone.getMolten(144L), GT_ModHandler.getModItem("IC2", "itemArmorNanoChestplate", 1), 600, 480);
        GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem("dreamcraft", "item.CarbonPartLeggings", 1, 0), GT_ModHandler.getModItem("dreamcraft", "item.NanoCrystal", 1, 0), Materials.Redstone.getMolten(144L), GT_ModHandler.getModItem("IC2", "itemArmorNanoLegs", 1), 600, 480);
        GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem("dreamcraft", "item.CarbonPartBoots", 1, 0), GT_ModHandler.getModItem("dreamcraft", "item.NanoCrystal", 1, 0), Materials.Redstone.getMolten(144L), GT_ModHandler.getModItem("IC2", "itemArmorNanoBoots", 1), 600, 480);

        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_LV.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L), GT_ModHandler.getModItem("IronChest", "BlockIronChest", 1L, 0)}, GT_Values.NF, GT_ModHandler.getModItem("IC2", "blockPersonal", 1L, 0), 200, 30);

        if (Loader.isModLoaded("appliedenergistics2")) {
            GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 24), CustomItemList.EssentiaCircuit.get(1L), CustomItemList.EngineeringProcessorEssentiaPulsatingCore.get(1L), 100, 1920);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("TConstruct", "GlassPane", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 2L)}, GT_Values.NF, GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 39), 100, 16);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Blocks.glass_pane, 1, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 2L)}, GT_Values.NF, GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 39), 100, 16);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hatch_Output_Bus_HV.get(1L), GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiPart", 1L, 440), GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 4L, 30), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, ItemList.Hatch_Output_Bus_ME.get(1), 300, 480);

            GT_Values.RA.addMixerRecipe(CustomItemList.ChargedCertusQuartzDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(4), Materials.Water.getFluid(500L), GT_Values.NF, GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 2L, 8), 20, 16);
            GT_Values.RA.addMixerRecipe(CustomItemList.ChargedCertusQuartzDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(4), GT_ModHandler.getDistilledWater(500L), GT_Values.NF, GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 2L, 8), 20, 16);
        }

        GT_Values.RA.addAutoclaveRecipe(CustomItemList.LapotronDust.get(30L), Materials.EnergeticAlloy.getMolten(576L), CustomItemList.RawLapotronCrystal.get(1L), 10000, 2400, 480);
        GT_Values.RA.addAutoclaveRecipe(CustomItemList.LapotronDust.get(30L), Materials.VibrantAlloy.getMolten(288L), CustomItemList.RawLapotronCrystal.get(1L), 10000, 1200, 480);

        GT_Values.RA.addAutoclaveRecipe(GT_ModHandler.getModItem("EnderZoo", "enderFragment", 4L, 0), GT_Utility.getIntegratedCircuit(1), Materials.Water.getFluid(100), new ItemStack(Items.ender_pearl, 1, 0), 8000, 1200, 30, false);
        GT_Values.RA.addAutoclaveRecipe(GT_ModHandler.getModItem("EnderZoo", "enderFragment", 4L, 0), GT_Utility.getIntegratedCircuit(2), GT_ModHandler.getDistilledWater(50L), new ItemStack(Items.ender_pearl, 1, 0), 9000, 900, 30, false);
        GT_Values.RA.addAutoclaveRecipe(GT_ModHandler.getModItem("EnderZoo", "enderFragment", 4L, 0), GT_Utility.getIntegratedCircuit(3), Materials.Void.getMolten(18), new ItemStack(Items.ender_pearl, 1, 0), 10000, 600, 30, false);

        GT_Values.RA.addAutoclaveRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 1L), GT_Utility.getIntegratedCircuit(1), Materials.Water.getFluid(100), new ItemStack(Items.ender_pearl, 1, 0), 8000, 1500, 30, false);
        GT_Values.RA.addAutoclaveRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 1L), GT_Utility.getIntegratedCircuit(2), GT_ModHandler.getDistilledWater(75L), new ItemStack(Items.ender_pearl, 1, 0), 9000, 1200, 30, false);
        GT_Values.RA.addAutoclaveRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 1L), GT_Utility.getIntegratedCircuit(3), Materials.Void.getMolten(36), new ItemStack(Items.ender_pearl, 1, 0), 10000, 900, 30, false);

        GT_Values.RA.addBlastRecipe(CustomItemList.UncookedSlush.get(1L), GT_Utility.getIntegratedCircuit(1), Materials.Radon.getGas(1000L), GT_Values.NF, CustomItemList.GlowingMarshmallow.get(1L), GT_Values.NI, 2400, 1920, 4500);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.RedstoneAlloy, 1L), GT_Values.NI, 800, 120, 1000);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.RedstoneAlloy, 1L), GT_Values.NI, 1600, 120, 1200);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ConductiveIron, 1L), GT_Values.NI, 1200, 120, 1200);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ConductiveIron, 1L), GT_Values.NI, 2400, 120, 1500);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Hydrogen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EnergeticAlloy, 1L), GT_Values.NI, 1600, 120, 2200);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EnergeticAlloy, 1L), GT_Values.NI, 3200, 120, 2500);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticSilver, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Hydrogen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EnergeticSilver, 1L), GT_Values.NI, 1600, 120, 2200);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticSilver, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EnergeticSilver, 1L), GT_Values.NI, 3200, 120, 2500);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Hydrogen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VibrantAlloy, 1L), GT_Values.NI, 3000, 120, 3000);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VibrantAlloy, 1L), GT_Values.NI, 6000, 120, 3600);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VividAlloy, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Hydrogen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VividAlloy, 1L), GT_Values.NI, 3000, 120, 3000);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VividAlloy, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VividAlloy, 1L), GT_Values.NI, 6000, 120, 3600);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrystallineAlloy, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Helium.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CrystallineAlloy, 1L), GT_Values.NI, 1200, 1920, 4500);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrystallineAlloy, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CrystallineAlloy, 1L), GT_Values.NI, 1800, 1920, 5000);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrystallinePinkSlime, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Helium.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CrystallinePinkSlime, 1L), GT_Values.NI, 1800, 1920, 5000);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrystallinePinkSlime, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CrystallinePinkSlime, 1L), GT_Values.NI, 2400, 1920, 5600);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MelodicAlloy, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Helium.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.MelodicAlloy, 1L), GT_Values.NI, 3000, 1920, 5400);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MelodicAlloy, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.MelodicAlloy, 1L), GT_Values.NI, 4000, 1920, 5800);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StellarAlloy, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.StellarAlloy, 1L), GT_Values.NI, 4000, 30720, 7200);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StellarAlloy, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.StellarAlloy, 1L), GT_Values.NI, 5000, 30720, 9000);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectricalSteel, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ElectricalSteel, 1L), GT_Values.NI, 1200, 120, 1000);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectricalSteel, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ElectricalSteel, 1L), GT_Values.NI, 2400, 120, 1200);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PulsatingIron, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.PulsatingIron, 1L), GT_Values.NI, 1600, 120, 1800);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PulsatingIron, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.PulsatingIron, 1L), GT_Values.NI, 3200, 120, 2200);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Soularium, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Helium.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Soularium, 1L), GT_Values.NI, 1000, 120, 1000);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Soularium, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Soularium, 1L), GT_Values.NI, 2000, 120, 1200);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkSteel, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DarkSteel, 1L), GT_Values.NI, 1000, 120, 1800);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkSteel, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DarkSteel, 1L), GT_Values.NI, 2000, 120, 2200);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EndSteel, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Helium.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EndSteel, 1L), GT_Values.NI, 1200, 1920, 4500);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EndSteel, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EndSteel, 1L), GT_Values.NI, 1800, 1920, 5000);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderiumBase, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Helium.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.EnderiumBase, 1L), GT_Values.NI, 3000, 120, 3300);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderiumBase, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.EnderiumBase, 1L), GT_Values.NI, 6000, 120, 3600);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Enderium, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Helium.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Enderium, 1L), GT_Values.NI, 3500, 120, 4500);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Enderium, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Enderium, 1L), GT_Values.NI, 7000, 120, 4500);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Reinforced, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Reinforced, 1L), GT_Values.NI, 1200, 120, 1700);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Reinforced, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Reinforced, 1L), GT_Values.NI, 1400, 120, 1700);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Galgadorian, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Hydrogen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Galgadorian, 1L), GT_Values.NI, 2000, 120, 2800);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Galgadorian, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Galgadorian, 1L), GT_Values.NI, 4000, 120, 3000);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnhancedGalgadorian, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Hydrogen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.EnhancedGalgadorian, 1L), GT_Values.NI, 3000, 480, 4200);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Draconium, 1L), GT_Values.NI, 4000, 30720, 7200);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DraconiumAwakened, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.DraconiumAwakened, 1L), GT_Values.NI, 5000, 122880, 9900);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 1L), GT_Values.NI, 1400, 120, 1700);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 1L), GT_Values.NI, 1700, 120, 1700);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ardite, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Hydrogen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 1L), GT_Values.NI, 1800, 120, 1600);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ardite, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 1L), GT_Values.NI, 2400, 120, 1600);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Hydrogen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Manyullyn, 1L), GT_Values.NI, 1500, 480, 3300);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Manyullyn, 1L), GT_Values.NI, 2400, 480, 3600);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Desh, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Desh, 1L), GT_Values.NI, 2000, 480, 2500);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Desh, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Desh, 1L), GT_Values.NI, 2800, 480, 2500);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectrumFlux, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.ElectrumFlux, 1L), GT_Values.NI, 1000, 122880, 9000);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.FierySteel, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.FierySteel, 1L), GT_Values.NI, 1000, 120, 1600);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.FierySteel, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.FierySteel, 1L), GT_Values.NI, 2000, 120, 1900);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sunnarium, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Helium.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Sunnarium, 1L), GT_Values.NI, 1800, 1920, 4500);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sunnarium, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Sunnarium, 1L), GT_Values.NI, 2200, 1920, 4500);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSG, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSG, 1L), GT_Values.NI, 1800, 1920, 4200);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSG, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSG, 1L), GT_Values.NI, 4200, 2920, 4500);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSE, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Helium.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSE, 1L), GT_Values.NI, 2500, 1920, 5000);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSE, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSE, 1L), GT_Values.NI, 5000, 1920, 5400);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSS, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Helium.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSS, 1L), GT_Values.NI, 3000, 1920, 5000);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSS, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSS, 1L), GT_Values.NI, 9000, 1920, 5400);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Naquadah, 1L), GT_Values.NI, 500, 7680, 5000);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahAlloy, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NaquadahAlloy, 1L), GT_Values.NI, 1000, 62880, 7200);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahEnriched, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NaquadahEnriched, 1L), GT_Values.NI, 1000, 7680, 5350);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadria, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Naquadria, 1L), GT_Values.NI, 500, 122880, 9000);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Trinium, 1L), GT_Values.NI, 1500, 30720, 7200);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Helium.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Osmium, 1L), GT_Values.NI, 1000, 30720, 4500);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Osmium, 1L), GT_Values.NI, 3000, 30720, 4500);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Iridium, 1L), GT_Values.NI, 1000, 7680, 4500);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Iridium, 1L), GT_Values.NI, 2500, 7680, 4500);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Oriharukon, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Oriharukon, 1L), GT_Values.NI, 2300, 7680, 5400);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Oriharukon, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Oriharukon, 1L), GT_Values.NI, 2700, 7680, 5400);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.BlackPlutonium, 1L), GT_Values.NI, 6000, 122880, 9000);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.BlackPlutonium, 1L), GT_Values.NI, 7500, 122880, 9000);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Aluminium, 1L), GT_Values.NI, 1200, 120, 1700);

        //NEEDED TO MOVE FROM GREG, CODE WAS TOO LONG
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmiridium, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Helium.getGas(1000), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Osmiridium, 1L), GT_Values.NI, 1500, 30720, 4500);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1L), Materials.Ash.getDustTiny(1), 500, 120, 1000);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PigIron, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1L), Materials.Ash.getDustTiny(1), 100, 120, 1000);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.WroughtIron, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1L), Materials.Ash.getDustTiny(1), 100, 120, 1000);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ShadowIron, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ShadowSteel, 1L), GT_Values.NI, 500, 120, 1100);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeteoricIron, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricSteel, 1L), GT_Values.NI, 500, 120, 1200);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GalliumArsenide, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.GalliumArsenide, 1L), GT_Values.NI, 600, 120, 1200);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Aluminium, 3L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.DarkAsh, 1L), 400, 120, 1200);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GreenSapphire, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Aluminium, 3L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.DarkAsh, 1L), 400, 120, 1200);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sapphire, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Aluminium, 3L), GT_Values.NI, 400, 120, 1200);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ilmenite, 9L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 9L), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 4L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Rutile, 4L), 3200, 480, 1700);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 2L), GT_Utility.getIntegratedCircuit(12), Materials.Titaniumtetrachloride.getFluid(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Titanium, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesiumchloride, 2L), 800, 480, 2140);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.AnnealedCopper, 1L), GT_Values.NI, 500, 120, 1200);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Titanium, 1L), GT_Values.NI, (int) Math.max(Materials.Titanium.getMass() / 160L, 1L) * 2400, 1920, 1940);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Titanium, 1L), GT_Values.NI, (int) Math.max(Materials.Titanium.getMass() / 160L, 1L) * 1800, 1920, 1940);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tungsten, 1L), GT_Values.NI, (int) Math.max(Materials.Tungsten.getMass() / 160L, 1L) * 12000, 1920, 3000);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tungsten, 1L), GT_Values.NI, (int) Math.max(Materials.Tungsten.getMass() / 160L, 1L) * 10000, 1920, 3000);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TungstenSteel, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenSteel, 1L), GT_Values.NI, (int) Math.max(Materials.TungstenSteel.getMass() / 160L, 1L) * 3000, 1920, 3000);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TungstenSteel, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenSteel, 1L), GT_Values.NI, (int) Math.max(Materials.TungstenSteel.getMass() / 160L, 1L) * 2500, 1920, 3000);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TungstenCarbide, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenCarbide, 1L), GT_Values.NI, (int) Math.max(Materials.TungstenCarbide.getMass() / 40L, 1L) * 2460, 1920, 2460);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TungstenCarbide, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenCarbide, 1L), GT_Values.NI, (int) Math.max(Materials.TungstenCarbide.getMass() / 40L, 1L) * 2000, 1920, 2460);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VanadiumGallium, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VanadiumGallium, 1L), GT_Values.NI, (int) Math.max(Materials.VanadiumGallium.getMass() / 160L, 1L) * 4500, 480, 4500);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VanadiumGallium, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Helium.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VanadiumGallium, 1L), GT_Values.NI, (int) Math.max(Materials.VanadiumGallium.getMass() / 160L, 1L) * 4000, 480, 4500);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NiobiumTitanium, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NiobiumTitanium, 1L), GT_Values.NI, (int) Math.max(Materials.NiobiumTitanium.getMass() / 160L, 1L) * 4500, 480, 4500);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NiobiumTitanium, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Helium.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NiobiumTitanium, 1L), GT_Values.NI, (int) Math.max(Materials.NiobiumTitanium.getMass() / 160L, 1L) * 4000, 480, 4500);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nichrome, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Nichrome, 1L), GT_Values.NI, (int) Math.max(Materials.Nichrome.getMass() / 160L, 1L) * 5400, 480, 2700);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nichrome, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Nichrome, 1L), GT_Values.NI, (int) Math.max(Materials.Nichrome.getMass() / 160L, 1L) * 4000, 480, 2700);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StainlessSteel, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 1L), GT_Values.NI, 1700, 480, 1700);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StainlessSteel, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 1L), GT_Values.NI, 1200, 480, 1700);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Pentacadmiummagnesiumhexaoxid, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Pentacadmiummagnesiumhexaoxid, 1L), GT_Values.NI, 2400, 480, 2500);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Pentacadmiummagnesiumhexaoxid, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Pentacadmiummagnesiumhexaoxid, 1L), GT_Values.NI, 2000, 480, 2500);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titaniumonabariumdecacoppereikosaoxid, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Titaniumonabariumdecacoppereikosaoxid, 1L), GT_Values.NI, 2700, 480, 3300);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titaniumonabariumdecacoppereikosaoxid, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Titaniumonabariumdecacoppereikosaoxid, 1L), GT_Values.NI, 2300, 480, 3300);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uraniumtriplatinid, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Uraniumtriplatinid, 1L), GT_Values.NI, 3300, 1920, 4400);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uraniumtriplatinid, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Helium.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Uraniumtriplatinid, 1L), GT_Values.NI, 2800, 1920, 4400);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadiumtriindinid, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Vanadiumtriindinid, 1L), GT_Values.NI, 3800, 1920, 5200);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadiumtriindinid, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Helium.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Vanadiumtriindinid, 1L), GT_Values.NI, 3400, 1920, 5200);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid, 1L), GT_Values.NI, 5000, 7680, 6000);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid, 1L), GT_Values.NI, 4400, 7680, 6000);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DeepIron, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.DeepIron, 1L), GT_Values.NI, 6000, 7680, 7500);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DeepIron, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.DeepIron, 1L), GT_Values.NI, 5000, 7680, 7500);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L), GT_Values.NI, 6000, 7680, 9000);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L), GT_Values.NI, 5000, 7680, 9000);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforuvwire, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuvwire, 1L), GT_Values.NI, 7000, 30720, 9900);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforuvwire, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Radon.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuvwire, 1L), GT_Values.NI, 6000, 30720, 9900);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforuhvwire, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuhvwire, 1L), GT_Values.NI, 9000, 122880, 10800);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforuhvwire, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Radon.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuhvwire, 1L), GT_Values.NI, 7500, 122880, 10500);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tritanium, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tritanium, 1L), GT_Values.NI, 6000, 122880, 9900);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tritanium, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Radon.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tritanium, 1L), GT_Values.NI, 5000, 122880, 9900);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quantium, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Quantium, 1L), GT_Values.NI, 3500, 7680, 5400);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quantium, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Radon.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Quantium, 1L), GT_Values.NI, 3000, 7680, 5400);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Bedrockium, 1L), GT_Values.NI, 9000, 122880, 9900);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Radon.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Bedrockium, 1L), GT_Values.NI, 8000, 122880, 9900);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.MysteriousCrystal, 1L), GT_Values.NI, 6000, 122880, 7200);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Radon.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.MysteriousCrystal, 1L), GT_Values.NI, 4500, 122880, 7200);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CosmicNeutronium, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CosmicNeutronium, 1L), GT_Values.NI, 12000, 122880, 9900);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CosmicNeutronium, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Radon.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CosmicNeutronium, 1L), GT_Values.NI, 10000, 122880, 9900);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfinityCatalyst, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.InfinityCatalyst, 1L), GT_Values.NI, 15000, 500000, 10800);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfinityCatalyst, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Radon.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.InfinityCatalyst, 1L), GT_Values.NI, 12000, 500000, 10800);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Infinity, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Infinity, 1L), GT_Values.NI, 30000, 2000000, 10800);
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Infinity, 1L), GT_Utility.getIntegratedCircuit(11), Materials.Radon.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Infinity, 1L), GT_Values.NI, 25000, 2000000, 10800);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.FerriteMixture, 1L), GT_Values.NI, Materials.Oxygen.getGas(2000), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.NickelZincFerrite, 1L), GT_Values.NI, 600, 120, Materials.NickelZincFerrite.mBlastFurnaceTemp);

        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.BrickNether, 1L), GT_Utility.getIntegratedCircuit(1), Materials.Oxygen.getGas(1000L), GT_Values.NF, CustomItemList.HotNetherrackBrick.get(1L), GT_Values.NI, 600, 120, 1200);
        GT_Values.RA.addBlastRecipe(CustomItemList.InfernalBrick.get(1L), CustomItemList.CokeOvenBrick.get(1L), Materials.Oxygen.getGas(1000L), GT_Values.NF, CustomItemList.AdvancedCokeOvenBrick.get(2L), GT_Values.NI, 1200, 120, 1600);

        GT_Values.RA.addBlastRecipe(CustomItemList.RawNeutronium.get(1L), GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Neutronium, 1L), GT_Values.NI, 10000, 500000, 9000);

        GT_Values.RA.addBlastRecipe(Materials.Zincite.getDust(2), Materials.Carbon.getDust(1), GT_Values.NF, Materials.CarbonDioxide.getGas(1000L), Materials.Zinc.getIngots(3), Materials.Ash.getDustTiny(2), 240, 120, 1200);

        GT_Values.RA.addBrewingRecipe(GT_ModHandler.getModItem("IC2", "itemBiochaff", 1L, 0), FluidRegistry.getFluid("water"), FluidRegistry.getFluid("ic2biomass"), false);

        GT_Values.RA.addBrewingRecipeCustom(GT_ModHandler.getModItem("Genetics", "misc", 6L, 4), FluidRegistry.getFluidStack("water", 750), FluidRegistry.getFluidStack("binnie.growthmedium", 750), 600, 480, false);
        GT_Values.RA.addBrewingRecipeCustom(GT_ModHandler.getModItem("IC2", "itemBiochaff", 16L, 0), FluidRegistry.getFluidStack("binnie.growthmedium", 750), FluidRegistry.getFluidStack("binnie.bacteria", 750), 1200, 480, false);
        GT_Values.RA.addBrewingRecipeCustom(new ItemStack(Items.blaze_powder, 1, 0), FluidRegistry.getFluidStack("binnie.bacteria", 100), FluidRegistry.getFluidStack("binnie.bacteriavector", 100), 5, 60, false);
        GT_Values.RA.addBrewingRecipeCustom(new ItemStack(Items.dye, 1, 15), FluidRegistry.getFluidStack("binnie.bacteria", 100), FluidRegistry.getFluidStack("binnie.bacteriapoly", 100), 5, 60, false);

        GT_Values.RA.addBrewingRecipeCustom(GT_ModHandler.getModItem("harvestthenether", "ignisfruitItem", 45L, 0), FluidRegistry.getFluidStack("potion.awkward", 750), FluidRegistry.getFluidStack("potion.fireresistance", 750), 120, 8, false);

        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Stone, 2L), GT_ModHandler.getModItem("TConstruct", "GlassPane", 2L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Tin, 1L)}, GT_Values.NF, GT_ModHandler.getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepowercobblestone", 1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), GT_ModHandler.getModItem("TConstruct", "GlassPane", 2L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 1L)}, GT_Values.NF, GT_ModHandler.getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepowerwood", 1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), GT_ModHandler.getModItem("TConstruct", "GlassPane", 2L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 1L)}, GT_Values.NF, GT_ModHandler.getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepowerwood", 1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{CustomItemList.SandStoneRod.get(2L), GT_ModHandler.getModItem("TConstruct", "GlassPane", 2L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Cupronickel, 1L)}, GT_Values.NF, GT_ModHandler.getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepowersandstone", 1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("ForgeMicroblock", "stoneRod", 2L), GT_ModHandler.getModItem("TConstruct", "GlassPane", 2L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Nickel, 1L)}, GT_Values.NF, GT_ModHandler.getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepowerstone", 1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.NetherQuartz, 2L), GT_ModHandler.getModItem("TConstruct", "GlassPane", 2L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Silver, 1L)}, GT_Values.NF, GT_ModHandler.getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepowerquartz", 1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 2L), GT_ModHandler.getModItem("TConstruct", "GlassPane", 2L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Electrum, 1L)}, GT_Values.NF, GT_ModHandler.getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepoweriron", 1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Gold, 2L), GT_ModHandler.getModItem("TConstruct", "GlassPane", 2L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Aluminium, 1L)}, GT_Values.NF, GT_ModHandler.getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepowergold", 1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Emerald, 2L), GT_ModHandler.getModItem("TConstruct", "GlassPane", 2L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Nichrome, 1L)}, GT_Values.NF, GT_ModHandler.getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepoweremerald", 1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Diamond, 2L), GT_ModHandler.getModItem("TConstruct", "GlassPane", 2L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Platinum, 1L)}, GT_Values.NF, GT_ModHandler.getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepowerdiamond", 1L), 200, 120);

        // Add fermenter recipes from forestry into gregtech
        if (Loader.isModLoaded("Forestry")) {
            try {
                Class forestryFermenterRecipeManager = Class.forName("forestry.factory.recipes.FermenterRecipeManager");
                Field fieldFermenterRecipes = forestryFermenterRecipeManager.getDeclaredField("recipes");
                fieldFermenterRecipes.setAccessible(true);

                Iterable<IFermenterRecipe> recipes = (Iterable<IFermenterRecipe>) fieldFermenterRecipes.get(null);

                for (IFermenterRecipe recipe : recipes) {
                    ItemStack resource = recipe.getResource();

                    boolean alreadyHasRecipe = GT_Recipe.GT_Recipe_Map.sBrewingRecipes.containsInput(resource);
                    boolean resultsInBiomass = recipe.getOutput().equals(FluidRegistry.getFluid("biomass"));

                    if (!alreadyHasRecipe && resultsInBiomass) {
                        int amountIn = recipe.getFermentationValue() * 2;
                        int amountOut = amountIn;
                        GT_Values.RA.addBrewingRecipeCustom(resource, FluidRegistry.getFluidStack("water", amountIn), FluidRegistry.getFluidStack("biomass", amountOut), 8 * amountOut, 3, false);

                        amountOut = (int) (amountOut * 1.5);
                        GT_Values.RA.addBrewingRecipeCustom(resource, FluidRegistry.getFluidStack("juice", amountIn), FluidRegistry.getFluidStack("biomass", amountOut), 8 * amountOut, 3, false);
                        GT_Values.RA.addBrewingRecipeCustom(resource, FluidRegistry.getFluidStack("honey", amountIn), FluidRegistry.getFluidStack("biomass", amountOut), 8 * amountOut, 3, false);
                    }
                }

                GT_Values.RA.addDistilleryRecipe(GT_Utility.getIntegratedCircuit(1), Materials.Biomass.getFluid(40L), Materials.Ethanol.getFluid(20L), 16, 24, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getModItem("Forestry", "beeCombs", 1L, 9), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_ModHandler.getModItem("Forestry", "beeswax", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Iridium, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000, 100}, 300, 7680);

        GT_Values.RA.addCentrifugeRecipe(new ItemStack(Items.fire_charge, 1, 0), GT_Values.NI, GT_Values.NF, GT_Values.NF, new ItemStack(Items.blaze_powder, 1, 0), new ItemStack(Items.gunpowder, 1, 0), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000, 10000, 10000}, 400, 8);

        GT_Values.RA.addElectrolyzerRecipe(ItemList.Cell_Empty.get(1), GT_ModHandler.getModItem("TwilightForest", "tile.TFAuroraBrick", 1L, 0), GT_Values.NF, Materials.Helium_3.getFluid(100), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L), GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Helium, 1), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 600, 480);
        GT_Values.RA.addElectrolyzerRecipe(ItemList.Cell_Empty.get(1), GT_ModHandler.getModItem("TwilightForest", "tile.AuroraPillar", 1L, 0), GT_Values.NF, Materials.Helium_3.getFluid(200), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L), GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Helium, 1), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 600, 480);
        GT_Values.RA.addElectrolyzerRecipe(ItemList.Cell_Empty.get(1), GT_ModHandler.getModItem("TwilightForest", "tile.AuroraSlab", 2L, 0), GT_Values.NF, Materials.Helium_3.getFluid(50), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L), GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Helium, 1), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 600, 480);
        GT_Values.RA.addElectrolyzerRecipe(ItemList.Cell_Empty.get(1), GT_ModHandler.getModItem("TwilightForest", "tile.AuroraDoubleSlab", 1L, 0), GT_Values.NF, Materials.Helium_3.getFluid(100), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L), GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Helium, 1), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 600, 480);
        if (Loader.isModLoaded("gendustry"))
            GT_Values.RA.addCentrifugeRecipe(CustomItemList.FieryBloodDrop.get(1L), GT_Values.NI, GT_Values.NF, Materials.FierySteel.getFluid(10L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000}, 12, 480);

        GT_Values.RA.addCentrifugeRecipe(CustomItemList.MoonStoneDust.get(1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.SiliconDioxide, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Manganese, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Olivine, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.RareEarth, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Platinum, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Tungstate, 1L), new int[]{5000, 2000, 1000, 750, 500, 250}, 400, 30);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.MarsStoneDust.get(1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.BandedIron, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Magnesium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Aluminium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ruby, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Diamond, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Iridium, 1L), new int[]{5000, 3000, 1000, 750, 500, 250}, 600, 60);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.PhobosStoneDust.get(1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.BandedIron, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Bauxite, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Molybdenite, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Desh, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Uranium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Plutonium, 1L), new int[]{5000, 2500, 1000, 750, 500, 150}, 600, 60);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.DeimosStoneDust.get(1L), GT_Values.NI, GT_Values.NF, Materials.SulfuricAcid.getFluid(50L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Magnesite, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Lapis, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Pitchblende, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Cooperite, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Neodymium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Tungstate, 1L), new int[]{5000, 3000, 1000, 750, 650, 350}, 600, 60);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.AsteroidsStoneDust.get(1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Gold, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Lead, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Titanium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ruby, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Chrome, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Osmium, 1L), new int[]{5000, 3000, 1000, 750, 500, 150}, 800, 120);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.CeresStoneDust.get(1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.MeteoricIron, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Beryllium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Platinum, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Titanium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Tungsten, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Naquadah, 1L), new int[]{5000, 2500, 1000, 750, 500, 150}, 800, 120);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.EuropaIceDust.get(1L), GT_Values.NI, GT_Values.NF, Materials.Oxygen.getGas(50L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Ledox, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Lapis, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Lazurite, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Oriharukon, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Barium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Naquadah, 1L), new int[]{5000, 2500, 1250, 750, 500, 150}, 800, 120);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.EuropaStoneDust.get(1L), GT_Values.NI, GT_Values.NF, Materials.Nitrogen.getGas(100L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.SiliconDioxide, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iron, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Ledox, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Sodalite, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Barium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Uranium, 1L), new int[]{5000, 3000, 1000, 750, 500, 300}, 800, 120);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.GanymedeStoneDust.get(1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Titanium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Chromite, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Galena, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Diamond, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Uranium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Palladium, 1L), new int[]{5000, 3000, 1000, 750, 600, 250}, 800, 120);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.CallistoStoneDust.get(1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.CallistoIce, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Galena, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Topaz, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.BlueTopaz, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Lithium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Tungsten, 1L), new int[]{5000, 3000, 1000, 900, 750, 250}, 800, 120);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.IoStoneDust.get(1L), GT_Values.NI, GT_Values.NF, Materials.SulfuricGas.getGas(100L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Sulfur, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Tantalite, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Tungsten, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Jasper, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.InfusedGold, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Iridium, 1L), new int[]{5000, 3000, 1000, 750, 500, 250}, 1000, 256);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.VenusStoneDust.get(1L), GT_Values.NI, GT_Values.NF, Materials.CarbonDioxide.getGas(500L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Carbon, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Quantium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Mytryl, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Amethyst, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Mithril, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Draconium, 1L), new int[]{10000, 3000, 1000, 750, 500, 250}, 1000, 256);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.MercuryStoneDust.get(1L), GT_Values.NI, GT_Values.NF, Materials.Helium_3.getGas(50L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Vanadium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Tungstate, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Draconium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Titanium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Jade, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Diamond, 1L), new int[]{5000, 3000, 1000, 750, 500, 250}, 1000, 256);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.MercuryCoreDust.get(1L), GT_Values.NI, GT_Values.NF, Materials.Helium.getGas(250L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Ilmenite, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Tungstate, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Draconium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Titanium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Jade, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Diamond, 1L), new int[]{5000, 3000, 1000, 750, 500, 250}, 1000, 256);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.EnceladusIceDust.get(1L), GT_Values.NI, GT_Values.NF, Materials.Oxygen.getGas(150L), CustomItemList.MysteriousCrystalDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Chrome, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iridium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ledox, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Trinium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Naquadah, 1L), new int[]{5000, 3000, 1000, 750, 400, 200}, 1200, 480);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.EnceladusStoneDust.get(1L), GT_Values.NI, GT_Values.NF, Materials.Nitrogen.getGas(150L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Chrome, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iridium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Osmium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Opal, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Trinium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Naquadah, 1L), new int[]{5000, 3000, 1000, 750, 400, 100}, 1200, 480);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.TitanStoneDust.get(1L), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(100L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Nickel, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iridium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Osmium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Emerald, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Gallium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Trinium, 1L), new int[]{5000, 2500, 1000, 900, 500, 200}, 1200, 480);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.OberonStoneDust.get(1L), GT_Values.NI, GT_Values.NF, Materials.Argon.getGas(50L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iridium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Osmium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Naquadah, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Uranium235, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Plutonium241, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Trinium, 1L), new int[]{4000, 2000, 800, 300, 150, 150}, 1200, 480);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.MirandaStoneDust.get(1L), GT_Values.NI, GT_Values.NF, Materials.Argon.getGas(50L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Tin, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Tetrahedrite, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iridium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Desh, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Chrome, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Osmium, 1L), new int[]{4000, 2000, 1000, 750, 500, 350}, 1200, 480);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.TritonStoneDust.get(1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Gold, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Neodymium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.RareEarth, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Niobium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Yttrium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Gallium, 1L), new int[]{5000, 3000, 1000, 750, 500, 350}, 1400, 1024);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.ProteusStoneDust.get(1L), GT_Values.NI, GT_Values.NF, Materials.Radon.getGas(10L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Copper, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Uraninite, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Adamantium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Diamond, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Uranium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Plutonium, 1L), new int[]{5000, 2500, 1000, 750, 500, 350}, 1400, 1024);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.PlutoIceDust.get(1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Thorium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Uranium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Plutonium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.BlackPlutonium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ledox, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Naquadah, 1L), new int[]{5000, 2500, 1250, 750, 500, 400}, 1600, 1920);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.PlutoStoneDust.get(1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Thorium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Uranium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.BlackPlutonium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.GarnetRed, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.GarnetYellow, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Naquadah, 1L), new int[]{5000, 2500, 850, 500, 500, 300}, 1600, 1920);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.MakeMakeStoneDust.get(1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GarnetRed, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GarnetYellow, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.BlackPlutonium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Gallium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Yttrium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Niobium, 1L), new int[]{2500, 2500, 1000, 750, 500, 350}, 1600, 1920);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.HaumeaStoneDust.get(1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.InfusedGold, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Naquadah, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.NetherStar, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Lanthanum, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Caesium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Cerium, 1L), new int[]{5000, 2500, 850, 750, 500, 450}, 1600, 1920);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.CentauriASurfaceDust.get(1L), GT_Values.NI, GT_Values.NF, Materials.Mercury.getFluid(100L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iridium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.NaquadahEnriched, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Draconium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Iridium, 1L), GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 2), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.InfinityCatalyst, 1L), new int[]{5000, 3000, 1000, 1000, 100, 50}, 1800, 4096);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.CentauriAStoneDust.get(1L), GT_Values.NI, GT_Values.NF, Materials.Mercury.getFluid(200L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Osmium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.NaquadahEnriched, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Neutronium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.BlackPlutonium, 1L), GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 2), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.InfinityCatalyst, 1L), new int[]{5000, 2000, 500, 2500, 150, 80}, 1800, 4096);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.VegaBStoneDust.get(1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Uranium235, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Plutonium241, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Europium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Neutronium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Naquadria, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.DraconiumAwakened, 1L), new int[]{5000, 3000, 1500, 800, 500, 50}, 1800, 4096);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.BarnardaEStoneDust.get(1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Niobium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Yttrium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Gallium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Neutronium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Bedrockium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Unstable, 1L), new int[]{2500, 2000, 1500, 750, 250, 250}, 1800, 4096);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.BarnardaFStoneDust.get(1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Gallium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Yttrium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Niobium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Neutronium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Bedrockium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Unstable, 1L), new int[]{2500, 2000, 1500, 750, 250, 250}, 1800, 4096);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.TCetiEStoneDust.get(1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Lapis, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Apatite, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Bedrockium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Draconium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.InfinityCatalyst, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Trinium, 1L), new int[]{5000, 2500, 1000, 750, 150, 50}, 1800, 4096);

        GT_Values.RA.addCentrifugeRecipe(CustomItemList.CokeOvenBrickDust.get(1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Clay, 2L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.SiliconDioxide, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Brick, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000, 9000, 7500, 6500}, 400, 30);
        GT_Values.RA.addCentrifugeRecipe(CustomItemList.AdvancedCokeOvenBrickDust.get(1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, CustomItemList.CokeOvenBrickDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Netherrack, 2L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.SiliconDioxide, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Brick, 1L), GT_Values.NI, GT_Values.NI, new int[]{10000, 9000, 7500, 6500}, 400, 120);
        GT_Values.RA.addCentrifugeRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Brick, 19L), ItemList.Cell_Empty.get(12L), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 4L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 3L), GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 12L), GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000, 10000, 10000}, 400, 120);
        GT_Values.RA.addCentrifugeRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Fireclay, 19L), ItemList.Cell_Empty.get(12L), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 4L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 3L), GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 12L), GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000, 10000, 10000}, 200, 120);

        GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getModItem("BiomesOPlenty", "newBopGrass", 1L, 0), GT_Values.NI, GT_Values.NF, GT_Values.NF, new ItemStack(Blocks.dirt, 1, 0), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Clay, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000, 3300}, 100, 30);
        GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getModItem("BiomesOPlenty", "newBopDirt", 1L, 0), GT_Values.NI, GT_Values.NF, GT_Values.NF, new ItemStack(Blocks.dirt, 1, 0), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Clay, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000, 3300}, 100, 30);
        GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getModItem("BiomesOPlenty", "newBopDirt", 1L, 1), GT_Values.NI, GT_Values.NF, GT_Values.NF, new ItemStack(Blocks.dirt, 1, 0), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Clay, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000, 3300}, 100, 30);
        GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getModItem("BiomesOPlenty", "newBopDirt", 1L, 2), GT_Values.NI, GT_Values.NF, GT_Values.NF, new ItemStack(Blocks.dirt, 1, 0), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Flint, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000, 3300}, 100, 30);
        GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getModItem("BiomesOPlenty", "newBopDirt", 1L, 3), GT_Values.NI, GT_Values.NF, GT_Values.NF, new ItemStack(Blocks.dirt, 1, 0), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Flint, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000, 3300}, 100, 30);
        GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getModItem("BiomesOPlenty", "newBopGrass", 1L, 2), GT_Values.NI, GT_Values.NF, GT_Values.NF, new ItemStack(Blocks.dirt, 1, 0), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.QuartzSand, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000, 3300}, 100, 30);
        GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getModItem("BiomesOPlenty", "newBopDirt", 1L, 4), GT_Values.NI, GT_Values.NF, GT_Values.NF, new ItemStack(Blocks.dirt, 1, 0), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.QuartzSand, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000, 3300}, 100, 30);
        GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getModItem("BiomesOPlenty", "newBopDirt", 1L, 5), GT_Values.NI, GT_Values.NF, GT_Values.NF, new ItemStack(Blocks.dirt, 1, 0), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.QuartzSand, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000, 3300}, 100, 30);
        GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getModItem("BiomesOPlenty", "driedDirt", 1L, 0), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Clay, 1L), new ItemStack(Blocks.sand, 1, 0), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{9000, 5000, 2500}, 100, 30);

        GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getModItem("Thaumcraft", "blockEldritch", 1L, 4), GT_Values.NI, GT_Values.NF, GT_Values.NF, new ItemStack(Items.glowstone_dust, 1, 0), GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 1L, 14), GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 1L, 14), GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 1L, 14), GT_Values.NI, GT_Values.NI, new int[]{10000, 3300, 1000, 200}, 300, 480);
        GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.GlowstoneDusts", 1L, 0), GT_Values.NI, GT_Values.NF, GT_Values.NF, new ItemStack(Items.glowstone_dust, 2, 0), CustomItemList.CeresStoneDust.get(1L), CustomItemList.CeresStoneDust.get(1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000, 9000, 7500}, 300, 120);
        GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.GlowstoneDusts", 1L, 4), GT_Values.NI, GT_Values.NF, GT_Values.NF, new ItemStack(Items.glowstone_dust, 2, 0), CustomItemList.PlutoStoneDust.get(1L), CustomItemList.PlutoStoneDust.get(1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000, 9000, 7500}, 300, 120);
        GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.GlowstoneDusts", 1L, 1), GT_Values.NI, GT_Values.NF, GT_Values.NF, new ItemStack(Items.glowstone_dust, 2, 0), CustomItemList.IoStoneDust.get(1L), CustomItemList.IoStoneDust.get(1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000, 9000, 7500}, 300, 120);
        GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.GlowstoneDusts", 1L, 2), GT_Values.NI, GT_Values.NF, GT_Values.NF, new ItemStack(Items.glowstone_dust, 2, 0), CustomItemList.EnceladusStoneDust.get(1L), CustomItemList.EnceladusStoneDust.get(1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000, 9000, 7500}, 300, 120);
        GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.GlowstoneDusts", 1L, 3), GT_Values.NI, GT_Values.NF, GT_Values.NF, new ItemStack(Items.glowstone_dust, 2, 0), CustomItemList.ProteusStoneDust.get(1L), CustomItemList.ProteusStoneDust.get(1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000, 9000, 7500}, 300, 120);

        GT_Values.RA.addCentrifugeRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Stone, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.CertusQuartz, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.NetherQuartz, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Quartzite, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Cassiterite, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Silicon, 1L), new int[]{4000, 3000, 2000, 1500, 1000, 750}, 600, 16);

        GT_Values.RA.addCentrifugeRecipe(GT_OreDictUnificator.get(OrePrefixes.dust.get(Materials.DeepIron), 1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iron, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iron, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iron, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Trinium, 1L), GT_Values.NI, GT_Values.NI, new int[]{10000, 10000, 10000, 10000}, 200, 30720);

        GT_Values.RA.addCentrifugeRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 2), GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 2), GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 2), GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{5000, 2000, 1000}, 1200, 1920);

        GT_Values.RA.addCentrifugeRecipe(CustomItemList.MaceratedPlantmass.get(1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_ModHandler.getModItem("IC2", "itemBiochaff", 1L, 0), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000}, 300, 4);

        GT_Values.RA.addCentrifugeRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Electrotine, 8L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Electrum, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000, 10000}, 800, 30);

        GT_Values.RA.addCentrifugeRecipe(ItemList.Cell_Air.get(5L), GT_Values.NI, GT_Values.NF, Materials.Nitrogen.getGas(3900L), Materials.Oxygen.getCells(1), ItemList.Cell_Empty.get(4L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000, 10000}, 1600, 8);

        GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getModItem("IC2", "itemCellHydrant", 1L, GT_Values.W), GT_Values.NI, GT_Values.NF, GT_Values.NF, ItemList.Cell_Empty.get(1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000}, 100, 2);

        GT_Values.RA.addChemicalBathRecipe(CustomItemList.HotNetherrackBrick.get(1L), new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000), CustomItemList.InfernalBrick.get(1L), GT_Values.NI, GT_Values.NI, new int[]{10000}, 200, 30);

        GT_Values.RA.addChemicalBathRecipe(new ItemStack(Items.leather, 2, 0), Materials.PhosphoricAcid.getFluid(144), GT_ModHandler.getModItem("Backpack", "tannedLeather", 1L, 0), GT_Values.NI, GT_Values.NI, new int[]{10000}, 300, 30);
        GT_Values.RA.addChemicalBathRecipe(CustomItemList.ArtificialLeather.get(2L), Materials.PhosphoricAcid.getFluid(144), GT_ModHandler.getModItem("Backpack", "tannedLeather", 1L, 0), GT_Values.NI, GT_Values.NI, new int[]{10000}, 300, 30);
        //- Chlorine cleaning of pistons
        GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.sticky_piston, 1, 0), Materials.Chlorine.getGas(10L), new ItemStack(Blocks.piston, 1, 0), GT_Values.NI, GT_Values.NI, null, 30, 30);

        //Mysterious crystal upgrading
        GT_Values.RA.addLaserEngraverRecipe(CustomItemList.MysteriousCrystalPlate.get(9), GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderPearl, 1)), CustomItemList.MysteriousCrystal.get(1L), 1200, 480, true);
        GT_Values.RA.addLaserEngraverRecipe(CustomItemList.MysteriousCrystalPlate.get(9), GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 1)), CustomItemList.MysteriousCrystal.get(1L), 1200, 480, true);
        GT_Values.RA.addLaserEngraverRecipe(CustomItemList.MysteriousCrystal.get(3L), GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderPearl, 1)), CustomItemList.MysteriousCrystalGemFlawless.get(1L), 600, 122880, true);
        GT_Values.RA.addLaserEngraverRecipe(CustomItemList.MysteriousCrystal.get(3L), GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 1)), CustomItemList.MysteriousCrystalGemFlawless.get(1L), 600, 122880, true);
        GT_Values.RA.addLaserEngraverRecipe(CustomItemList.MysteriousCrystalGemFlawless.get(3L), GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderPearl, 1)), CustomItemList.MysteriousCrystalGemExquisite.get(1L), 600, 30720, true);
        GT_Values.RA.addLaserEngraverRecipe(CustomItemList.MysteriousCrystalGemFlawless.get(3L), GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 1)), CustomItemList.MysteriousCrystalGemExquisite.get(1L), 600, 30720, true);
        GT_Values.RA.addChemicalBathRecipe(CustomItemList.MysteriousCrystalGemExquisite.get(1L), Materials.UUMatter.getFluid(144), CustomItemList.MysteriousCrystalLens.get(1L), GT_Values.NI, GT_Values.NI, new int[]{10000}, 600, 500000);

        GT_Values.RA.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Mytryl, 9L), GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Topaz, 1)), CustomItemList.MytrylCrystal.get(1L), 1200, 256, true);
        GT_Values.RA.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Mytryl, 9L), GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Amber, 1)), CustomItemList.MytrylCrystal.get(1L), 1200, 256, true);

        GT_Values.RA.addCompressorRecipe(GT_ModHandler.getModItem("IC2", "itemWeed", 16L), ItemList.IC2_Plantball.get(1L), 300, 2);
        GT_Values.RA.addCompressorRecipe(GT_ModHandler.getModItem("ExtraTrees", "food", 64L, 24), ItemList.IC2_Plantball.get(1L), 300, 2);
        GT_Values.RA.addCompressorRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sunnarium, 1L), GT_ModHandler.getModItem("AdvancedSolarPanel", "asp_crafting_items", 1L, 0), 300, 2);
        GT_Values.RA.addCompressorRecipe(GT_ModHandler.getModItem("AdvancedSolarPanel", "asp_crafting_items", 9L, 9), GT_ModHandler.getModItem("AdvancedSolarPanel", "asp_crafting_items", 1L, 0), 300, 2);
        GT_Values.RA.addCompressorRecipe(GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.WroughtIron, 9L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 1L), 300, 2);
        GT_Values.RA.addCompressorRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L), 300, 2);
        GT_Values.RA.addCompressorRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L), 300, 2);
        GT_Values.RA.addCompressorRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Quartzite, 1L), 300, 2);
        GT_Values.RA.addCompressorRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lazurite, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lazurite, 1L), 300, 2);
        GT_Values.RA.addCompressorRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodalite, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Sodalite, 1L), 300, 2);
        GT_Values.RA.addCompressorRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnhancedGalgadorian, 9L), GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 1L, 48), 300, 2);

        GT_Values.RA.addCompressorRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Carbon, 1L), 300, 2);
        GT_Values.RA.addCompressorRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 9L), GT_OreDictUnificator.get(OrePrefixes.block, Materials.Cobalt, 1L), 300, 2);
        GT_Values.RA.addCompressorRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 9L), GT_OreDictUnificator.get(OrePrefixes.block, Materials.Ardite, 1L), 300, 2);
        GT_Values.RA.addCompressorRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Manyullyn, 9L), GT_OreDictUnificator.get(OrePrefixes.block, Materials.Manyullyn, 1L), 300, 2);
        GT_Values.RA.addCompressorRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Alumite, 9L), GT_OreDictUnificator.get(OrePrefixes.block, Materials.Alumite, 1L), 300, 2);
        this.run2();
    }

    private void makeCoilRecipes() {
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Cupronickel, 8L), CustomItemList.AluminoSilicateWool.get(12L), GT_Utility.getIntegratedCircuit(3)}, Materials.Tin.getMolten(288L), ItemList.Casing_Coil_Cupronickel.get(1L), 100, 7);

        //TODO: Rework other stuff (that depends on certain Heat Levels, mostly LuV+ stuff) so this can be wrapped into a oneliner.
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Cupronickel, 8L), CustomItemList.MicaInsulatorFoil.get(8L), GT_Utility.getIntegratedCircuit(3)}, Materials.Tin.getMolten(144L), ItemList.Casing_Coil_Cupronickel.get(1L), 200, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Kanthal, 8L), CustomItemList.MicaInsulatorFoil.get(12L), GT_Utility.getIntegratedCircuit(3)}, Materials.Cupronickel.getMolten(144L), ItemList.Casing_Coil_Kanthal.get(1L), 300, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Nichrome, 8L), CustomItemList.MicaInsulatorFoil.get(16L), GT_Utility.getIntegratedCircuit(3)}, Materials.Kanthal.getMolten(144L), ItemList.Casing_Coil_Nichrome.get(1L), 400, 480);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.TungstenSteel, 8L), CustomItemList.MicaInsulatorFoil.get(20L), GT_Utility.getIntegratedCircuit(3)}, Materials.Nichrome.getMolten(144L), ItemList.Casing_Coil_TungstenSteel.get(1L), 500, 1920);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.HSSG, 8L), CustomItemList.MicaInsulatorFoil.get(24L), GT_Utility.getIntegratedCircuit(3)}, Materials.TungstenSteel.getMolten(144L), ItemList.Casing_Coil_HSSG.get(1L), 600, 7680);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.HSSS, 8L), CustomItemList.MicaInsulatorFoil.get(28L), GT_Utility.getIntegratedCircuit(3)}, Materials.HSSG.getMolten(144L), ItemList.Casing_Coil_HSSS.get(1L), 700, 7680);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Naquadah, 8L), CustomItemList.MicaInsulatorFoil.get(32L), GT_Utility.getIntegratedCircuit(3)}, Materials.HSSS.getMolten(144L), ItemList.Casing_Coil_Naquadah.get(1L), 800, 30720);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.NaquadahAlloy, 8L), CustomItemList.MicaInsulatorFoil.get(36L), GT_Utility.getIntegratedCircuit(3)}, Materials.Naquadah.getMolten(144L), ItemList.Casing_Coil_NaquadahAlloy.get(1L), 900, 30720);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Trinium, 8L), CustomItemList.MicaInsulatorFoil.get(40L), GT_Utility.getIntegratedCircuit(3)}, Materials.NaquadahAlloy.getMolten(144L), ItemList.Casing_Coil_Trinium.get(1L), 1000, 122880);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.ElectrumFlux, 8L), CustomItemList.MicaInsulatorFoil.get(44L), GT_Utility.getIntegratedCircuit(3)}, Materials.Trinium.getMolten(144L), ItemList.Casing_Coil_ElectrumFlux.get(1L), 1100, 500000);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.DraconiumAwakened, 8L), CustomItemList.MicaInsulatorFoil.get(48L), GT_Utility.getIntegratedCircuit(3)}, Materials.ElectrumFlux.getMolten(144L), ItemList.Casing_Coil_AwakenedDraconium.get(1L), 1200, 2000000);
    }

    public void run2() {
        if (Loader.isModLoaded("TConstruct")) {
            GT_Values.RA.addCompressorRecipe(GT_ModHandler.getModItem("TConstruct", "materials", 9L, 14), GT_ModHandler.getModItem("TConstruct", "MetalBlock", 1L, 7), 300, 2);
            GT_Values.RA.addCompressorRecipe(GT_ModHandler.getModItem("TConstruct", "materials", 4L, 2), GT_ModHandler.getModItem("TConstruct", "Smeltery", 1L, 2), 300, 2);

            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("TConstruct", "materials", 1L, 4), new ItemStack[]{GT_ModHandler.getModItem("TConstruct", "materials", 1L, 38)}, new int[]{10000}, 300, 2);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("TConstruct", "MetalBlock", 1L, 1), new ItemStack[]{GT_ModHandler.getModItem("TConstruct", "materials", 9L, 38)}, new int[]{10000}, 300, 2);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("TConstruct", "SearedBrick", 1L, 1), new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Cobalt, 2L), GT_ModHandler.getModItem("TConstruct", "materials", 1L, 39)}, new int[]{10000, 1000}, 400, 2);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("TConstruct", "SearedBrick", 1L, 2), new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Ardite, 2L), GT_ModHandler.getModItem("TConstruct", "materials", 1L, 38)}, new int[]{10000, 1000}, 400, 2);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("TConstruct", "GravelOre", 1L, 4), new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Aluminium, 2L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bauxite, 1L)}, new int[]{10000, 1000}, 400, 2);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("TConstruct", "materials", 1L, 12), new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L)}, new int[]{10000}, 300, 2);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("TConstruct", "materials", 1L, 14), new ItemStack[]{GT_ModHandler.getModItem("TConstruct", "materials", 1L, 42)}, new int[]{10000}, 300, 2);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("TConstruct", "MetalBlock", 1L, 7), new ItemStack[]{GT_ModHandler.getModItem("TConstruct", "materials", 9L, 42)}, new int[]{10000}, 300, 2);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("TConstruct", "MetalBlock", 1L, 0), new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 9L)}, new int[]{10000}, 300, 2);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("TConstruct", "materials", 1L, 5), new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 1L)}, new int[]{10000}, 300, 2);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("TConstruct", "MetalBlock", 1L, 2), new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 9L)}, new int[]{10000}, 300, 2);

            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("TConstruct", "MetalBlock", 1L, 10), new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 9L)}, new int[]{10000}, 300, 2);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("TConstruct", "woodPattern", 1L, GT_Values.W), new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 1L)}, new int[]{10000}, 200, 2);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("TConstruct", "Pattern", 1L, GT_Values.W), new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 1L)}, new int[]{10000}, 200, 2);

            //Oreberries
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("TConstruct", "oreBerries", 1L, 0), new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Iron, 1L)}, new int[]{10000}, 300, 2);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("TConstruct", "oreBerries", 1L, 1), new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Gold, 1L)}, new int[]{10000}, 300, 2);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("TConstruct", "oreBerries", 1L, 2), new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Copper, 1L)}, new int[]{10000}, 300, 2);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("TConstruct", "oreBerries", 1L, 3), new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Tin, 1L)}, new int[]{10000}, 300, 2);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("TConstruct", "oreBerries", 1L, 4), new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Aluminium, 1L)}, new int[]{10000}, 300, 2);

            GT_Values.RA.addMixerRecipe(new ItemStack(Blocks.sand, 3, 0), new ItemStack(Blocks.gravel, 3, 0), new ItemStack(Blocks.clay, 2, 0), GT_Values.NI, Materials.Water.getFluid(2000L), GT_Values.NF, GT_ModHandler.getModItem("TConstruct", "CraftedSoil", 8L, 1), 200, 16);
            GT_Values.RA.addMixerRecipe(new ItemStack(Items.nether_wart, 1, 0), new ItemStack(Blocks.soul_sand, 1, 0), new ItemStack(Blocks.gravel, 1, 0), GT_ModHandler.getModItem("Natura", "soil.tainted", 1L, 0), GT_Utility.getIntegratedCircuit(1), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, Materials.Water.getFluid(2000L), GT_Values.NF, GT_ModHandler.getModItem("TConstruct", "CraftedSoil", 2L, 6), 200, 16);
            GT_Values.RA.addMixerRecipe(new ItemStack(Items.nether_wart, 1, 0), new ItemStack(Blocks.soul_sand, 1, 0), new ItemStack(Blocks.gravel, 1, 0), new ItemStack(Blocks.sand, 1, 32767), GT_Utility.getIntegratedCircuit(2), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, Materials.Water.getFluid(2000L), GT_Values.NF, GT_ModHandler.getModItem("TConstruct", "CraftedSoil", 2L, 6), 200, 16);

            GT_Values.RA.addForgeHammerRecipe(GT_ModHandler.getModItem("TConstruct", "Smeltery", 1L, 2), GT_ModHandler.getModItem("TConstruct", "materials", 3L, 2), 20, 16);

            GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Ball.get(0L), new FluidStack(FluidRegistry.getFluid("glue"), 144), GT_ModHandler.getModItem("TConstruct", "materials", 1L, 36), 100, 8); //maybe Materials.Glue.getFluid(144L) instead

            GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("TConstruct", "materials", 1L, 14), GT_Values.NI, FluidRegistry.getFluidStack("aluminumbrass.molten", 144), 10000, 24, 48);
            GT_Values.RA.addFluidSolidifierRecipe(GT_Utility.getIntegratedCircuit(1), FluidRegistry.getFluidStack("aluminumbrass.molten", 144), GT_ModHandler.getModItem("TConstruct", "blankPattern", 1L, 1), 32, 48);

            //Making molds
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormAnvil", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Anvil.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormArrowHead", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Arrow.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormBaguette", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Baguette.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormBall", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Ball.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormBlock", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Block.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormBolt", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Bolt.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormBottle", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Bottle.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormBread", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Bread.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormBuns", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Bun.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormCasing", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Casing.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormCoinage", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Credit.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormCylinder", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Cylinder.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormGear", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Gear.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormIngot", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Ingot.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MarshmallowFormMold", 1, 0), Materials.Steel.getMolten(576L), CustomItemList.MarshmallowForm.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormName", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Name.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormNuggets", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Nugget.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormPlate", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Plate.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormRing", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Ring.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormRound", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Round.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormRotor", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Rotor.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormScrew", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Screw.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormSmallGear", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Gear_Small.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormStick", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Rod.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormStickLong", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Rod_Long.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormPipeTiny", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Pipe_Tiny.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormPipeSmall", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Pipe_Small.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormPipeMedium", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Pipe_Medium.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormPipeLarge", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Pipe_Large.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormPipeHuge", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Pipe_Huge.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormTurbineBlade", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Mold_Turbine_Blade.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormBoots", 1, 0), Materials.Steel.getMolten(576L), GT_ModHandler.getModItem("dreamcraft", "item.MoldBoots", 1, 0), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormChestplate", 1, 0), Materials.Steel.getMolten(576L), GT_ModHandler.getModItem("dreamcraft", "item.MoldChestplate", 1, 0), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormLeggings", 1, 0), Materials.Steel.getMolten(576L), GT_ModHandler.getModItem("dreamcraft", "item.MoldLeggings", 1, 0), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.MoldFormHelmet", 1, 0), Materials.Steel.getMolten(576L), GT_ModHandler.getModItem("dreamcraft", "item.MoldHelmet", 1, 0), 200, 120);

            //Making shapes
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapeBolt", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_Bolt.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapeHoeHead", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_Hoe.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapeRing", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_Ring.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapeTurbineBlade", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_Turbine_Blade.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapeGear", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_Gear.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapeLargePipe", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_Pipe_Large.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapeShovelHead", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_Shovel.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapeCell", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_Cell.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapeAxeHead", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_Axe.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapeBlock", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_Block.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapeSwordBlade", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_Sword.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapePlate", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_Plate.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapeBoat", 1, 0), Materials.Steel.getMolten(576L), GT_ModHandler.getModItem("dreamcraft", "item.ExtruderShapeBoat", 1, 0), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapeCasing", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_Casing.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapeHugePipe", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_Pipe_Huge.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapeRod", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_Rod.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapeWire", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_Wire.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapeTinyPipe", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_Pipe_Tiny.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapeHammerHead", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_Hammer.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapeNormalPipe", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_Pipe_Medium.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapeFileHead", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_File.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapeBotte", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_Bottle.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapeSmallGear", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_Small_Gear.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapeSawBlade", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_Saw.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapeSmallPipe", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_Pipe_Small.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapeRotor", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_Rotor.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapePickaxeHead", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_Pickaxe.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapeIngot", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_Ingot.get(1L), 200, 120);
            GT_Values.RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("dreamcraft", "item.ShapeBottle", 1, 0), Materials.Steel.getMolten(576L), ItemList.Shape_Extruder_Bottle.get(1L), 200, 120);

            if (Loader.isModLoaded("OpenBlocks"))
                GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("TConstruct", "oreBerries", 1L, 5), GT_Values.NI, new FluidStack(FluidRegistry.getFluid("xpjuice"), 250), 10000, 100, 16);
            GT_Values.RA.addFluidExtractionRecipe(new ItemStack(Items.ender_pearl, 1, 0), GT_Values.NI, new FluidStack(FluidRegistry.getFluid("ender"), 250), 10000, 100, 30);
            GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("TConstruct", "MetalBlock", 1L, 10), GT_Values.NI, new FluidStack(FluidRegistry.getFluid("ender"), 2250), 10000, 200, 48);

            GT_Values.RA.addFluidExtractionRecipe(new ItemStack(Items.slime_ball, 1, 0), GT_Values.NI, new FluidStack(FluidRegistry.getFluid("glue"), 144), 10000, 100, 16);
            GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("TConstruct", "strangeFood", 1L, 0), GT_Values.NI, new FluidStack(FluidRegistry.getFluid("glue"), 144), 10000, 100, 16);
            GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("TConstruct", "strangeFood", 1L, 1), GT_Values.NI, new FluidStack(FluidRegistry.getFluid("glue"), 144), 10000, 100, 16);
            GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("TConstruct", "materials", 1L, 36), GT_Values.NI, new FluidStack(FluidRegistry.getFluid("glue"), 144), 10000, 100, 16);

            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("TConstruct", "slime.sapling", 1L, 0), GT_ModHandler.getModItem("TConstruct", "strangeFood", 1L, 0), 300, 2);
            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("TConstruct", "slime.gel", 1L, 0), GT_ModHandler.getModItem("TConstruct", "strangeFood", 4L, 0), 300, 2);
            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("TConstruct", "slime.gel", 1L, 1), new ItemStack(Items.slime_ball, 4, 0), 300, 2);
            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("TConstruct", "slime.leaves", 16L, 0), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RawRubber, 1L), 300, 2);

            //Assembler
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("TConstruct", "slime.gel", 1L, 1), GT_ModHandler.getModItem("IC2", "blockITNT", 1L, 0), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, GT_ModHandler.getModItem("TConstruct", "explosive.slime", 1L, 0), 600, 30);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("TConstruct", "slime.gel", 1L, 0), GT_ModHandler.getModItem("TConstruct", "explosive.slime", 1L, 0), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, GT_ModHandler.getModItem("TConstruct", "explosive.slime", 1L, 2), 600, 64);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Aluminium, 1L), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 4L), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, GT_ModHandler.getModItem("TConstruct", "heartCanister", 1L, 0), 2400, 480);

            //Blastfurnace
            GT_Values.RA.addBlastRecipe(new ItemStack(Blocks.glass, 1, 0), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_ModHandler.getModItem("TConstruct", "GlassBlock", 1L, 0), GT_Values.NI, 100, 120, 1000);
            GT_Values.RA.addBlastRecipe(new ItemStack(Blocks.glass_pane, 1, 0), GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_ModHandler.getModItem("TConstruct", "GlassPane", 1L, 0), GT_Values.NI, 100, 120, 1000);

            //Chemical Reactor
            GT_Values.RA.addChemicalRecipe(new ItemStack(Blocks.diamond_block, 8, 0), new ItemStack(Items.golden_apple, 1, 1), Materials.Blaze.getMolten(144), GT_Values.NF, GT_ModHandler.getModItem("TConstruct", "diamondApple", 1L, 0), GT_Values.NI, 3600, 480);

            //Slime crystals
            GT_Values.RA.addCompressorRecipe(GT_ModHandler.getModItem("TConstruct", "CraftedSoil", 4L, 0), GT_ModHandler.getModItem("TConstruct", "materials", 1L, 1), 300, 2);
            GT_Values.RA.addCompressorRecipe(GT_ModHandler.getModItem("TConstruct", "CraftedSoil", 4L, 2), GT_ModHandler.getModItem("TConstruct", "materials", 1L, 17), 300, 2);

            GT_Values.RA.addCompressorRecipe(new ItemStack(Items.paper, 64, 0), GT_ModHandler.getModItem("TConstruct", "materials", 1L, 0), 300, 2);

            //Centrifuge
            //GT_Values.RA.addCentrifugeRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_ModHandler.getModItem("TConstruct", "materials", 1L, 38), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000,10000}, 1200, 5);//auto recipe

            GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getModItem("TConstruct", "strangeFood", 1L, 0), GT_Values.NI, GT_Values.NF, Materials.Glue.getFluid(50), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RawRubber, 2L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000}, 300, 5);
            GT_Values.RA.addCentrifugeRecipe(new ItemStack(Items.slime_ball, 1, 0), GT_Values.NI, GT_Values.NF, Materials.Glue.getFluid(50), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RawRubber, 2L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000}, 300, 5);
            GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getModItem("TConstruct", "slime.gel", 1L, 2), GT_Values.NI, GT_Values.NF, Materials.Glue.getFluid(200), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Rubber, 8L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000}, 300, 5);
            GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getModItem("TConstruct", "slime.gel", 1L, 1), GT_Values.NI, GT_Values.NF, Materials.Glue.getFluid(200), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RawRubber, 8L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000}, 300, 5);
            GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getModItem("TConstruct", "slime.gel", 1L, 0), GT_Values.NI, GT_Values.NF, Materials.Glue.getFluid(200), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RawRubber, 8L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000}, 300, 5);

            //Cutting Saw
            GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem("TConstruct", "MetalBlock", 1L, 1), Materials.Water.getFluid(1000), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Ardite, 9L), GT_Values.NI, 4800, 30);
            GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem("TConstruct", "MetalBlock", 1L, 1), GT_ModHandler.getDistilledWater(750L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Ardite, 9L), GT_Values.NI, 4800, 30);
            GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem("TConstruct", "MetalBlock", 1L, 1), Materials.Lubricant.getFluid(250), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Ardite, 9L), GT_Values.NI, 2400, 30);
            GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem("TConstruct", "MetalBlock", 1L, 2), Materials.Water.getFluid(1000), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Manyullyn, 9L), GT_Values.NI, 9600, 30);
            GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem("TConstruct", "MetalBlock", 1L, 2), GT_ModHandler.getDistilledWater(750L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Manyullyn, 9L), GT_Values.NI, 9600, 30);
            GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem("TConstruct", "MetalBlock", 1L, 2), Materials.Lubricant.getFluid(250), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Manyullyn, 9L), GT_Values.NI, 4800, 30);

            //Tool Rods
            GT_Values.RA.addExtruderRecipe(Materials.Iron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1), GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 2), 250, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Obsidian.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1), GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 6), 179, 120);
            GT_Values.RA.addExtruderRecipe(new ItemStack(Items.netherbrick, 1, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1), GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 7), 122, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Cobalt.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1), GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 10), 800, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Ardite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1), GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 11), 606, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Manyullyn.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1), GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 12), 1200, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Copper.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1), GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 13), 180, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Bronze.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1), GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 14), 380, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Alumite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1), GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 15), 550, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Steel.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1), GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 16), 400, 30);
            GT_Values.RA.addExtruderRecipe(Materials.PigIron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1), GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 17), 666, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1), GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 314), 100, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1), GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 314), 100, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1), GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 315), 7500, 120);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1), GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 316), 97, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("BloodArsenal", "blood_infused_iron", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1), GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 251), 1800, 30);

            //Pickaxe Heads
            GT_Values.RA.addExtruderRecipe(Materials.Iron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2), GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 2), 501, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Obsidian.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2), GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 6), 179, 120);
            GT_Values.RA.addExtruderRecipe(new ItemStack(Items.netherbrick, 1, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2), GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 7), 245, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Cobalt.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2), GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 10), 1600, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Ardite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2), GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 11), 1213, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Manyullyn.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2), GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 12), 2400, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Copper.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2), GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 13), 360, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Bronze.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2), GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 14), 760, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Alumite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2), GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 15), 1101, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Steel.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2), GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 16), 800, 30);
            GT_Values.RA.addExtruderRecipe(Materials.PigIron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2), GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 17), 1333, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2), GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 314), 200, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2), GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 314), 200, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2), GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 315), 15000, 120);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2), GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 316), 195, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("BloodArsenal", "blood_infused_iron", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2), GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 251), 3600, 30);

            //Shovel Heads
            GT_Values.RA.addExtruderRecipe(Materials.Iron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3), GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 2), 501, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Obsidian.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3), GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 6), 179, 120);
            GT_Values.RA.addExtruderRecipe(new ItemStack(Items.netherbrick, 1, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3), GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 7), 245, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Cobalt.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3), GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 10), 1600, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Ardite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3), GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 11), 1213, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Manyullyn.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3), GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 12), 2400, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Copper.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3), GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 13), 360, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Bronze.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3), GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 14), 760, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Alumite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3), GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 15), 1101, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Steel.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3), GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 16), 800, 30);
            GT_Values.RA.addExtruderRecipe(Materials.PigIron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3), GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 17), 1333, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3), GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 314), 200, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3), GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 314), 200, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3), GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 315), 15000, 120);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3), GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 316), 195, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("BloodArsenal", "blood_infused_iron", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3), GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 251), 3600, 30);

            //Axe Heads
            GT_Values.RA.addExtruderRecipe(Materials.Iron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4), GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 2), 501, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Obsidian.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4), GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 6), 179, 120);
            GT_Values.RA.addExtruderRecipe(new ItemStack(Items.netherbrick, 1, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4), GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 7), 245, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Cobalt.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4), GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 10), 1600, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Ardite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4), GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 11), 1213, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Manyullyn.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4), GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 12), 2400, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Copper.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4), GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 13), 360, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Bronze.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4), GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 14), 760, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Alumite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4), GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 15), 1101, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Steel.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4), GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 16), 800, 30);
            GT_Values.RA.addExtruderRecipe(Materials.PigIron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4), GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 17), 1333, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4), GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 314), 200, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4), GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 314), 200, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4), GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 315), 15000, 120);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4), GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 316), 195, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("BloodArsenal", "blood_infused_iron", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4), GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 251), 3600, 30);

            //Sword Blade
            GT_Values.RA.addExtruderRecipe(Materials.Iron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5), GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 2), 501, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Obsidian.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5), GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 6), 179, 120);
            GT_Values.RA.addExtruderRecipe(new ItemStack(Items.netherbrick, 1, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5), GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 7), 245, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Cobalt.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5), GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 10), 1600, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Ardite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5), GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 11), 1213, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Manyullyn.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5), GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 12), 2400, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Copper.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5), GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 13), 360, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Bronze.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5), GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 14), 760, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Alumite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5), GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 15), 1101, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Steel.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5), GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 16), 800, 30);
            GT_Values.RA.addExtruderRecipe(Materials.PigIron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5), GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 17), 1333, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5), GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 314), 200, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5), GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 314), 200, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5), GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 315), 15000, 120);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5), GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 316), 195, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("BloodArsenal", "blood_infused_iron", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5), GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 251), 3600, 30);

            //Wide Guards
            GT_Values.RA.addExtruderRecipe(Materials.Iron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6), GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 2), 250, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Obsidian.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6), GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 6), 90, 120);
            GT_Values.RA.addExtruderRecipe(new ItemStack(Items.netherbrick, 1, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6), GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 7), 122, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Cobalt.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6), GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 10), 800, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Ardite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6), GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 11), 606, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Manyullyn.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6), GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 12), 1200, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Copper.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6), GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 13), 180, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Bronze.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6), GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 14), 380, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Alumite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6), GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 15), 550, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Steel.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6), GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 16), 400, 30);
            GT_Values.RA.addExtruderRecipe(Materials.PigIron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6), GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 17), 666, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6), GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 314), 100, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6), GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 314), 100, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6), GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 315), 7500, 120);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6), GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 316), 97, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("BloodArsenal", "blood_infused_iron", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6), GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 251), 1800, 30);

            //Hand Guards
            GT_Values.RA.addExtruderRecipe(Materials.Iron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7), GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 2), 250, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Obsidian.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7), GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 6), 90, 120);
            GT_Values.RA.addExtruderRecipe(new ItemStack(Items.netherbrick, 1, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7), GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 7), 122, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Cobalt.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7), GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 10), 800, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Ardite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7), GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 11), 606, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Manyullyn.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7), GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 12), 1200, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Copper.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7), GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 13), 180, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Bronze.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7), GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 14), 380, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Alumite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7), GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 15), 550, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Steel.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7), GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 16), 400, 30);
            GT_Values.RA.addExtruderRecipe(Materials.PigIron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7), GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 17), 666, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7), GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 314), 100, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7), GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 314), 100, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7), GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 315), 7500, 120);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7), GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 316), 97, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("BloodArsenal", "blood_infused_iron", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7), GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 251), 1800, 30);

            //Crossbars
            GT_Values.RA.addExtruderRecipe(Materials.Iron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8), GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 2), 250, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Obsidian.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8), GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 6), 90, 120);
            GT_Values.RA.addExtruderRecipe(new ItemStack(Items.netherbrick, 1, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8), GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 7), 122, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Cobalt.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8), GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 10), 800, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Ardite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8), GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 11), 606, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Manyullyn.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8), GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 12), 1200, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Copper.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8), GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 13), 180, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Bronze.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8), GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 14), 380, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Alumite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8), GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 15), 550, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Steel.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8), GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 16), 400, 30);
            GT_Values.RA.addExtruderRecipe(Materials.PigIron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8), GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 17), 666, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8), GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 314), 100, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8), GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 314), 100, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8), GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 315), 7500, 120);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8), GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 316), 97, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("BloodArsenal", "blood_infused_iron", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8), GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 251), 1800, 30);

            //Bindings
            GT_Values.RA.addExtruderRecipe(Materials.Iron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9), GT_ModHandler.getModItem("TConstruct", "binding", 1L, 2), 250, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Obsidian.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9), GT_ModHandler.getModItem("TConstruct", "binding", 1L, 6), 90, 120);
            GT_Values.RA.addExtruderRecipe(new ItemStack(Items.netherbrick, 1, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9), GT_ModHandler.getModItem("TConstruct", "binding", 1L, 7), 122, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Cobalt.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9), GT_ModHandler.getModItem("TConstruct", "binding", 1L, 10), 800, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Ardite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9), GT_ModHandler.getModItem("TConstruct", "binding", 1L, 11), 606, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Manyullyn.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9), GT_ModHandler.getModItem("TConstruct", "binding", 1L, 12), 1200, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Copper.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9), GT_ModHandler.getModItem("TConstruct", "binding", 1L, 13), 180, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Bronze.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9), GT_ModHandler.getModItem("TConstruct", "binding", 1L, 14), 380, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Alumite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9), GT_ModHandler.getModItem("TConstruct", "binding", 1L, 15), 550, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Steel.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9), GT_ModHandler.getModItem("TConstruct", "binding", 1L, 16), 400, 30);
            GT_Values.RA.addExtruderRecipe(Materials.PigIron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9), GT_ModHandler.getModItem("TConstruct", "binding", 1L, 17), 666, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9), GT_ModHandler.getModItem("TConstruct", "binding", 1L, 314), 100, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9), GT_ModHandler.getModItem("TConstruct", "binding", 1L, 314), 100, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9), GT_ModHandler.getModItem("TConstruct", "binding", 1L, 315), 7500, 120);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9), GT_ModHandler.getModItem("TConstruct", "binding", 1L, 316), 97, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("BloodArsenal", "blood_infused_iron", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9), GT_ModHandler.getModItem("TConstruct", "binding", 1L, 251), 1800, 30);

            //Fryingpan Heads (Time for Dream to duck!)
            GT_Values.RA.addExtruderRecipe(Materials.Iron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10), GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 2), 501, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Obsidian.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10), GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 6), 179, 120);
            GT_Values.RA.addExtruderRecipe(new ItemStack(Items.netherbrick, 1, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10), GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 7), 245, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Cobalt.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10), GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 10), 1600, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Ardite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10), GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 11), 1213, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Manyullyn.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10), GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 12), 2400, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Copper.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10), GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 13), 360, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Bronze.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10), GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 14), 760, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Alumite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10), GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 15), 1101, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Steel.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10), GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 16), 800, 30);
            GT_Values.RA.addExtruderRecipe(Materials.PigIron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10), GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 17), 1333, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10), GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 314), 200, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10), GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 314), 200, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10), GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 315), 15000, 120);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10), GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 316), 195, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("BloodArsenal", "blood_infused_iron", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10), GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 251), 3600, 30);

            //Sign Heads (To write on a wall)
            GT_Values.RA.addExtruderRecipe(Materials.Iron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11), GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 2), 501, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Obsidian.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11), GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 6), 179, 120);
            GT_Values.RA.addExtruderRecipe(new ItemStack(Items.netherbrick, 1, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11), GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 7), 245, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Cobalt.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11), GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 10), 1600, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Ardite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11), GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 11), 1213, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Manyullyn.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11), GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 12), 2400, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Copper.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11), GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 13), 360, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Bronze.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11), GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 14), 760, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Alumite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11), GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 15), 1101, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Steel.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11), GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 16), 800, 30);
            GT_Values.RA.addExtruderRecipe(Materials.PigIron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11), GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 17), 1333, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11), GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 314), 200, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11), GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 314), 200, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11), GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 315), 15000, 120);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11), GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 316), 195, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("BloodArsenal", "blood_infused_iron", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11), GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 251), 3600, 30);

            //Knife Blades (There are no winners in a knife fight)
            GT_Values.RA.addExtruderRecipe(Materials.Iron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12), GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 2), 250, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Obsidian.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12), GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 6), 90, 120);
            GT_Values.RA.addExtruderRecipe(new ItemStack(Items.netherbrick, 1, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12), GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 7), 122, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Cobalt.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12), GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 10), 800, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Ardite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12), GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 11), 606, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Manyullyn.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12), GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 12), 1200, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Copper.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12), GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 13), 180, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Bronze.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12), GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 14), 380, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Alumite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12), GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 15), 550, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Steel.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12), GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 16), 400, 30);
            GT_Values.RA.addExtruderRecipe(Materials.PigIron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12), GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 17), 666, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12), GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 314), 100, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12), GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 314), 100, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12), GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 315), 7500, 120);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12), GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 316), 97, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("BloodArsenal", "blood_infused_iron", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12), GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 251), 1800, 30);

            //Chisel Heads (Stonework galore)
            GT_Values.RA.addExtruderRecipe(Materials.Iron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13), GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 2), 250, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Obsidian.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13), GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 6), 90, 120);
            GT_Values.RA.addExtruderRecipe(new ItemStack(Items.netherbrick, 1, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13), GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 7), 122, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Cobalt.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13), GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 10), 800, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Ardite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13), GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 11), 606, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Manyullyn.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13), GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 12), 1200, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Copper.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13), GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 13), 180, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Bronze.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13), GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 14), 380, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Alumite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13), GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 15), 550, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Steel.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13), GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 16), 400, 30);
            GT_Values.RA.addExtruderRecipe(Materials.PigIron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13), GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 17), 666, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13), GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 314), 100, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13), GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 314), 100, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13), GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 315), 7500, 120);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13), GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 316), 97, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("BloodArsenal", "blood_infused_iron", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13), GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 251), 1800, 30);

            //Tough Tool Rods (The Tougher the Better)
            GT_Values.RA.addExtruderRecipe(Materials.Iron.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14), GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 2), 1503, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Obsidian.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14), GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 6), 537, 120);
            GT_Values.RA.addExtruderRecipe(new ItemStack(Items.netherbrick, 3, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14), GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 7), 735, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Cobalt.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14), GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 10), 4800, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Ardite.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14), GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 11), 3639, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Manyullyn.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14), GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 12), 7200, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Copper.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14), GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 13), 1080, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Bronze.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14), GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 14), 2280, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Alumite.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14), GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 15), 3303, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Steel.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14), GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 16), 2400, 30);
            GT_Values.RA.addExtruderRecipe(Materials.PigIron.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14), GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 17), 3999, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 3L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14), GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 314), 600, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 3L, 2), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14), GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 314), 600, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 3L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14), GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 315), 45000, 120);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 3L, 8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14), GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 316), 585, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("BloodArsenal", "blood_infused_iron", 3L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14), GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 251), 10800, 30);

            //Tough Bindings (To keep the toughness together)
            GT_Values.RA.addExtruderRecipe(Materials.Iron.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15), GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 2), 1503, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Obsidian.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15), GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 6), 537, 120);
            GT_Values.RA.addExtruderRecipe(new ItemStack(Items.netherbrick, 3, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15), GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 7), 735, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Cobalt.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15), GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 10), 4800, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Ardite.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15), GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 11), 3639, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Manyullyn.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15), GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 12), 7200, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Copper.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15), GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 13), 1080, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Bronze.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15), GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 14), 2280, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Alumite.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15), GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 15), 3303, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Steel.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15), GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 16), 2400, 30);
            GT_Values.RA.addExtruderRecipe(Materials.PigIron.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15), GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 17), 3999, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 3L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15), GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 314), 600, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 3L, 2), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15), GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 314), 600, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 3L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15), GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 315), 45000, 120);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 3L, 8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15), GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 316), 585, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("BloodArsenal", "blood_infused_iron", 3L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15), GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 251), 10800, 30);

            //Large Plates (Different from Small Plates)
            GT_Values.RA.addExtruderRecipe(Materials.Iron.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16), GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 2), 4008, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Obsidian.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16), GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 6), 1432, 120);
            GT_Values.RA.addExtruderRecipe(new ItemStack(Items.netherbrick, 8, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16), GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 7), 1960, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Cobalt.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16), GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 10), 12800, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Ardite.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16), GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 11), 9704, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Manyullyn.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16), GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 12), 19200, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Copper.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16), GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 13), 2880, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Bronze.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16), GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 14), 7680, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Alumite.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16), GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 15), 8808, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Steel.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16), GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 16), 6400, 30);
            GT_Values.RA.addExtruderRecipe(Materials.PigIron.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16), GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 17), 10664, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 8L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16), GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 314), 1600, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 8L, 2), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16), GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 314), 1600, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 8L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16), GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 315), 120000, 120);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 8L, 8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16), GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 316), 1560, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("BloodArsenal", "blood_infused_iron", 8L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16), GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 251), 28800, 30);

            //Broad Axe Heads (Cutting down a tree with every strike)
            GT_Values.RA.addExtruderRecipe(Materials.Iron.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17), GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 2), 4008, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Obsidian.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17), GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 6), 1432, 120);
            GT_Values.RA.addExtruderRecipe(new ItemStack(Items.netherbrick, 8, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17), GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 7), 1960, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Cobalt.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17), GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 10), 12800, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Ardite.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17), GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 11), 9704, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Manyullyn.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17), GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 12), 19200, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Copper.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17), GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 13), 2880, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Bronze.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17), GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 14), 7680, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Alumite.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17), GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 15), 8808, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Steel.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17), GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 16), 6400, 30);
            GT_Values.RA.addExtruderRecipe(Materials.PigIron.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17), GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 17), 10664, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 8L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17), GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 314), 1600, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 8L, 2), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17), GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 314), 1600, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 8L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17), GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 315), 120000, 120);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 8L, 8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17), GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 316), 1560, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("BloodArsenal", "blood_infused_iron", 8L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17), GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 251), 28800, 30);

            //Scythe Heads (Cutting down a a farm with every strike, or Deaths favorite weapon)
            GT_Values.RA.addExtruderRecipe(Materials.Iron.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18), GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 2), 4008, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Obsidian.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18), GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 6), 1432, 120);
            GT_Values.RA.addExtruderRecipe(new ItemStack(Items.netherbrick, 8, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18), GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 7), 1960, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Cobalt.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18), GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 10), 12800, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Ardite.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18), GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 11), 9704, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Manyullyn.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18), GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 12), 19200, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Copper.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18), GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 13), 2880, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Bronze.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18), GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 14), 7680, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Alumite.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18), GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 15), 8808, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Steel.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18), GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 16), 6400, 30);
            GT_Values.RA.addExtruderRecipe(Materials.PigIron.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18), GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 17), 10664, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 8L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18), GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 314), 1600, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 8L, 2), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18), GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 314), 1600, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 8L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18), GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 315), 120000, 120);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 8L, 8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18), GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 316), 1560, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("BloodArsenal", "blood_infused_iron", 8L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18), GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 251), 28800, 30);

            //Excavator Heads (Getting Dirty digging a hole)
            GT_Values.RA.addExtruderRecipe(Materials.Iron.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19), GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 2), 4008, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Obsidian.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19), GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 6), 1432, 120);
            GT_Values.RA.addExtruderRecipe(new ItemStack(Items.netherbrick, 8, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19), GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 7), 1960, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Cobalt.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19), GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 10), 12800, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Ardite.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19), GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 11), 9704, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Manyullyn.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19), GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 12), 19200, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Copper.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19), GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 13), 2880, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Bronze.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19), GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 14), 7680, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Alumite.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19), GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 15), 8808, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Steel.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19), GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 16), 6400, 30);
            GT_Values.RA.addExtruderRecipe(Materials.PigIron.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19), GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 17), 10664, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 8L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19), GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 314), 1600, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 8L, 2), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19), GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 314), 1600, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 8L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19), GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 315), 120000, 120);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 8L, 8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19), GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 316), 1560, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("BloodArsenal", "blood_infused_iron", 8L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19), GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 251), 28800, 30);

            //Large Sword Blades (Who has the largest sword?)
            GT_Values.RA.addExtruderRecipe(Materials.Iron.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20), GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 2), 4008, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Obsidian.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20), GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 6), 1432, 120);
            GT_Values.RA.addExtruderRecipe(new ItemStack(Items.netherbrick, 8, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20), GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 7), 1960, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Cobalt.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20), GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 10), 12800, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Ardite.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20), GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 11), 9704, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Manyullyn.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20), GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 12), 19200, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Copper.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20), GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 13), 2880, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Bronze.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20), GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 14), 7680, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Alumite.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20), GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 15), 8808, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Steel.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20), GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 16), 6400, 30);
            GT_Values.RA.addExtruderRecipe(Materials.PigIron.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20), GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 17), 10664, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 8L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20), GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 314), 1600, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 8L, 2), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20), GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 314), 1600, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 8L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20), GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 315), 120000, 120);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 8L, 8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20), GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 316), 1560, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("BloodArsenal", "blood_infused_iron", 8L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20), GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 251), 28800, 30);

            //Hammer Heads (It's Clobbering Time!)
            GT_Values.RA.addExtruderRecipe(Materials.Iron.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21), GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 2), 4008, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Obsidian.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21), GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 6), 1432, 120);
            GT_Values.RA.addExtruderRecipe(new ItemStack(Items.netherbrick, 8, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21), GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 7), 1960, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Cobalt.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21), GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 10), 12800, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Ardite.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21), GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 11), 9704, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Manyullyn.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21), GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 12), 19200, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Copper.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21), GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 13), 2880, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Bronze.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21), GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 14), 7680, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Alumite.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21), GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 15), 8808, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Steel.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21), GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 16), 6400, 30);
            GT_Values.RA.addExtruderRecipe(Materials.PigIron.getIngots(8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21), GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 17), 10664, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 8L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21), GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 314), 1600, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 8L, 2), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21), GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 314), 1600, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 8L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21), GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 315), 120000, 120);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 8L, 8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21), GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 316), 1560, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("BloodArsenal", "blood_infused_iron", 8L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21), GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 251), 28800, 30);

            //Full Guards (To guard your grip)
            GT_Values.RA.addExtruderRecipe(Materials.Iron.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22), GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 2), 1503, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Obsidian.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22), GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 6), 537, 120);
            GT_Values.RA.addExtruderRecipe(new ItemStack(Items.netherbrick, 3, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22), GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 7), 735, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Cobalt.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22), GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 10), 4800, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Ardite.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22), GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 11), 3639, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Manyullyn.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22), GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 12), 7200, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Copper.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22), GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 13), 1080, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Bronze.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22), GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 14), 2280, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Alumite.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22), GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 15), 3303, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Steel.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22), GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 16), 2400, 30);
            GT_Values.RA.addExtruderRecipe(Materials.PigIron.getIngots(3), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22), GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 17), 3999, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 3L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22), GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 314), 600, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 3L, 2), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22), GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 314), 600, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 3L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22), GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 315), 45000, 120);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 3L, 8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22), GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 316), 585, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("BloodArsenal", "blood_infused_iron", 3L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22), GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 251), 10800, 30);

            //Arrowheads (Hey, flying metal)
            GT_Values.RA.addExtruderRecipe(Materials.Iron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25), GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 2), 501, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Obsidian.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25), GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 6), 179, 120);
            GT_Values.RA.addExtruderRecipe(new ItemStack(Items.netherbrick, 1, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25), GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 7), 245, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Cobalt.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25), GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 10), 1600, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Ardite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25), GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 11), 1213, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Manyullyn.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25), GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 12), 2400, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Copper.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25), GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 13), 360, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Bronze.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25), GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 14), 760, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Alumite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25), GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 15), 1101, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Steel.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25), GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 16), 800, 30);
            GT_Values.RA.addExtruderRecipe(Materials.PigIron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25), GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 17), 1333, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25), GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 314), 200, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25), GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 314), 200, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25), GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 315), 15000, 120);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25), GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 316), 195, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("BloodArsenal", "blood_infused_iron", 1L, 0), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25), GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 251), 3600, 30);

            //Shurikens (Hey, Oriental flying metal)
            GT_Values.RA.addExtruderRecipe(Materials.Iron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0), GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 2), 250, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Obsidian.getIngots(1), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0), GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 6), 90, 120);
            GT_Values.RA.addExtruderRecipe(new ItemStack(Items.netherbrick, 1, 0), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0), GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 7), 122, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Cobalt.getIngots(1), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0), GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 10), 800, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Ardite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0), GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 11), 606, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Manyullyn.getIngots(1), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0), GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 12), 1200, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Copper.getIngots(1), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0), GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 13), 180, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Bronze.getIngots(1), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0), GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 14), 380, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Alumite.getIngots(1), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0), GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 15), 550, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Steel.getIngots(1), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0), GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 16), 400, 30);
            GT_Values.RA.addExtruderRecipe(Materials.PigIron.getIngots(1), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0), GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 17), 666, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0), GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 314), 100, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0), GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 314), 100, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0), GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 315), 7500, 120);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0), GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 316), 97, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("BloodArsenal", "blood_infused_iron", 1L, 0), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0), GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 251), 1800, 30);

            //Crossbow Limbs (The Dragon's worst enemy)
            GT_Values.RA.addExtruderRecipe(Materials.Iron.getIngots(4), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1), GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 2), 2004, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Obsidian.getIngots(4), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1), GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 6), 716, 120);
            GT_Values.RA.addExtruderRecipe(new ItemStack(Items.netherbrick, 4, 0), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1), GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 7), 980, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Cobalt.getIngots(4), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1), GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 10), 6400, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Ardite.getIngots(4), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1), GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 11), 4852, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Manyullyn.getIngots(4), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1), GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 12), 9600, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Copper.getIngots(4), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1), GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 13), 1440, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Bronze.getIngots(4), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1), GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 14), 3040, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Alumite.getIngots(4), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1), GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 15), 4404, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Steel.getIngots(4), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1), GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 16), 3200, 30);
            GT_Values.RA.addExtruderRecipe(Materials.PigIron.getIngots(4), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1), GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 17), 5332, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 4L, 0), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1), GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 314), 800, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 4L, 2), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1), GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 314), 800, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 4L, 0), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1), GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 315), 60000, 120);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 4L, 8), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1), GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 316), 780, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("BloodArsenal", "blood_infused_iron", 4L, 0), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1), GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 251), 14400, 30);

            //Crossbow Body (The Dragon's worst enemy, part 2)
            GT_Values.RA.addExtruderRecipe(Materials.Iron.getIngots(5), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2), GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 2), 2505, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Obsidian.getIngots(5), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2), GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 6), 895, 120);
            GT_Values.RA.addExtruderRecipe(new ItemStack(Items.netherbrick, 5, 0), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2), GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 7), 1225, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Cobalt.getIngots(5), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2), GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 10), 8000, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Ardite.getIngots(5), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2), GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 11), 6065, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Manyullyn.getIngots(5), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2), GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 12), 12000, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Copper.getIngots(5), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2), GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 13), 1800, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Bronze.getIngots(5), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2), GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 14), 3800, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Alumite.getIngots(5), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2), GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 15), 5505, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Steel.getIngots(5), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2), GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 16), 4000, 30);
            GT_Values.RA.addExtruderRecipe(Materials.PigIron.getIngots(5), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2), GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 17), 6665, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 5L, 0), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2), GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 314), 1000, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 5L, 2), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2), GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 314), 1000, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 5L, 0), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2), GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 315), 75000, 120);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 5L, 8), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2), GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 316), 975, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("BloodArsenal", "blood_infused_iron", 5L, 0), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2), GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 251), 18000, 30);

            //Bow Limbs (A skeletons favorite weapon, in pieces.)
            GT_Values.RA.addExtruderRecipe(Materials.Iron.getIngots(2), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3), GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 2), 752, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Obsidian.getIngots(2), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3), GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 6), 269, 120);
            GT_Values.RA.addExtruderRecipe(new ItemStack(Items.netherbrick, 2, 0), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3), GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 7), 368, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Cobalt.getIngots(2), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3), GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 10), 2400, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Ardite.getIngots(2), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3), GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 11), 1820, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Manyullyn.getIngots(2), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3), GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 12), 3600, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Copper.getIngots(2), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3), GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 13), 540, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Bronze.getIngots(2), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3), GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 14), 1140, 30);
            GT_Values.RA.addExtruderRecipe(Materials.Alumite.getIngots(2), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3), GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 15), 1652, 120);
            GT_Values.RA.addExtruderRecipe(Materials.Steel.getIngots(2), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3), GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 16), 1200, 30);
            GT_Values.RA.addExtruderRecipe(Materials.PigIron.getIngots(2), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3), GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 17), 2000, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 2L, 0), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3), GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 314), 300, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 2L, 2), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3), GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 314), 300, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 2L, 0), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3), GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 315), 22500, 120);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 2L, 8), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3), GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 316), 293, 30);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("BloodArsenal", "blood_infused_iron", 2L, 0), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3), GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 251), 5400, 30);
        }

        if (Loader.isModLoaded("Avaritia")) {
            GT_Values.RA.addPulveriserRecipe(new ItemStack(Items.record_11, 1, 0), new ItemStack[]{GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 7)}, new int[]{10000}, 300, 2);
            GT_Values.RA.addPulveriserRecipe(new ItemStack(Items.record_13, 1, 0), new ItemStack[]{GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 7)}, new int[]{10000}, 300, 2);
            GT_Values.RA.addPulveriserRecipe(new ItemStack(Items.record_cat, 1, 0), new ItemStack[]{GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 7)}, new int[]{10000}, 300, 2);
            GT_Values.RA.addPulveriserRecipe(new ItemStack(Items.record_blocks, 1, 0), new ItemStack[]{GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 7)}, new int[]{10000}, 300, 2);
            GT_Values.RA.addPulveriserRecipe(new ItemStack(Items.record_chirp, 1, 0), new ItemStack[]{GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 7)}, new int[]{10000}, 300, 2);
            GT_Values.RA.addPulveriserRecipe(new ItemStack(Items.record_far, 1, 0), new ItemStack[]{GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 7)}, new int[]{10000}, 300, 2);
            GT_Values.RA.addPulveriserRecipe(new ItemStack(Items.record_mellohi, 1, 0), new ItemStack[]{GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 7)}, new int[]{10000}, 300, 2);
            GT_Values.RA.addPulveriserRecipe(new ItemStack(Items.record_mall, 1, 0), new ItemStack[]{GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 7)}, new int[]{10000}, 300, 2);
            GT_Values.RA.addPulveriserRecipe(new ItemStack(Items.record_stal, 1, 0), new ItemStack[]{GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 7)}, new int[]{10000}, 300, 2);
            GT_Values.RA.addPulveriserRecipe(new ItemStack(Items.record_strad, 1, 0), new ItemStack[]{GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 7)}, new int[]{10000}, 300, 2);
            GT_Values.RA.addPulveriserRecipe(new ItemStack(Items.record_ward, 1, 0), new ItemStack[]{GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 7)}, new int[]{10000}, 300, 2);
            GT_Values.RA.addPulveriserRecipe(new ItemStack(Items.record_wait, 1, 0), new ItemStack[]{GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 7)}, new int[]{10000}, 300, 2);
        }

        if (Loader.isModLoaded("AdvancedSolarPanel")) {
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("AdvancedSolarPanel", "asp_crafting_items", 1L, 0), new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sunnarium, 1L)}, new int[]{10000}, 300, 2);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("AdvancedSolarPanel", "asp_crafting_items", 1L, 9), new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Sunnarium, 1L)}, new int[]{10000}, 30, 2);
        }

        if (Loader.isModLoaded("harvestthenether"))
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("harvestthenether", "fleshrootItem", 9L, 0), new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeatRaw, 1L)}, new int[]{10000}, 100, 2);

        if (Loader.isModLoaded("BiomesOPlenty")) {
            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("BiomesOPlenty", "flowers", 2L, 3), new ItemStack(Items.glowstone_dust, 1, 0), 300, 2);
            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("BiomesOPlenty", "mushrooms", 2L, 3), new ItemStack(Items.glowstone_dust, 1, 0), 300, 2);
            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("BiomesOPlenty", "coral1", 2L, 15), new ItemStack(Items.glowstone_dust, 1, 0), 300, 2);
        }

        if (Loader.isModLoaded("Natura")) {
            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("Natura", "Glowshroom", 2L, 0), new ItemStack(Items.glowstone_dust, 1, 0), 300, 2);
            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("Natura", "Glowshroom", 2L, 1), new ItemStack(Items.glowstone_dust, 1, 0), 300, 2);
            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("Natura", "Glowshroom", 2L, 2), new ItemStack(Items.glowstone_dust, 1, 0), 300, 2);
        }

        if (Loader.isModLoaded("BiomesOPlenty")) {
            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("BiomesOPlenty", "flowers", 2L, 13), new ItemStack(Items.spider_eye, 1, 0), 300, 2);
            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("BiomesOPlenty", "mudball", 1L, 0), new ItemStack(Items.clay_ball, 1, 0), 200, 2);
        }

        //GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("Natura", "Rare Tree", 1L, 0), GT_ModHandler.getModItem("harvestcraft", "maplesyrupItem", 1L, 0), 200, 2);
        if (Loader.isModLoaded("harvestcraft")) {
            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("harvestcraft", "pamMaple", 1L, 0), GT_ModHandler.getModItem("harvestcraft", "maplesyrupItem", 1L, 0), 200, 2);
            GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getModItem("harvestcraft", "coconutItem", 1L, 0), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_ModHandler.getModItem("harvestcraft", "coconutmilkItem", 9L, 0), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000}, 100, 2);
        }

        if (Loader.isModLoaded("Natura")) {
            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("Natura", "florasapling", 1L, 5), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), 100, 120);
            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("Natura", "floraleavesnocolor", 4L, 2), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), 100, 120);
            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("Natura", "bloodwood", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), 100, 120);
            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("Natura", "bloodwood", 1L, 15), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), 100, 120);
            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("Natura", "florasapling", 2L, 7), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gunpowder, 1L), 100, 120);
            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("Natura", "Dark Leaves", 8L, 3), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gunpowder, 1L), 100, 120);
            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("Natura", "Dark Tree", 2L, 1), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gunpowder, 1L), 100, 120);
            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("Natura", "florasapling", 2L, 6), ItemList.IC2_Fertilizer.get(1), 100, 120);
            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("Natura", "Dark Leaves", 8L, 0), ItemList.IC2_Fertilizer.get(1), 100, 120);
            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("Natura", "Dark Tree", 2L, 0), ItemList.IC2_Fertilizer.get(1), 100, 120);
            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("Natura", "Natura.netherfood", 1L, 0), ItemList.IC2_Fertilizer.get(4), 100, 120);
            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("Natura", "florasapling", 2L, 4), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bone, 1L), 100, 120);
            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("Natura", "floraleavesnocolor", 4L, 1), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bone, 1L), 100, 120);
            GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("Natura", "tree", 2L, 2), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bone, 1L), 100, 120);

            GT_Values.RA.addChemicalRecipe(GT_ModHandler.getModItem("Natura", "florasapling", 2L, 6), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1L), Materials.Water.getFluid(1000L), GT_Values.NF, ItemList.IC2_Fertilizer.get(2), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L), 200, 120);
            GT_Values.RA.addChemicalRecipe(GT_ModHandler.getModItem("Natura", "Dark Leaves", 8L, 0), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1L), Materials.Water.getFluid(1000L), GT_Values.NF, ItemList.IC2_Fertilizer.get(2), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L), 200, 120);
            GT_Values.RA.addChemicalRecipe(GT_ModHandler.getModItem("Natura", "Dark Tree", 2L, 0), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1L), Materials.Water.getFluid(1000L), GT_Values.NF, ItemList.IC2_Fertilizer.get(8), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TricalciumPhosphate, 1L), 200, 120);
            GT_Values.RA.addChemicalRecipe(GT_ModHandler.getModItem("Natura", "Natura.netherfood", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1L), Materials.Water.getFluid(1000L), GT_Values.NF, ItemList.IC2_Fertilizer.get(32), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TricalciumPhosphate, 1L), 200, 120);
        }

        GT_Values.RA.addDistillationTowerRecipe(new FluidStack(FluidRegistry.getFluid("pollution"), 1600), new FluidStack[]{Materials.SulfuricAcid.getFluid(50L), Materials.NitrogenDioxide.getGas(50L), Materials.Methane.getGas(50L), Materials.Mercury.getFluid(1L)}, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L), 600, 1920);

        GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Ball.get(0L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeblack"), 72), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32414), 100, 16);
        GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Ball.get(0L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyered"), 72), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32415), 100, 16);
        GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Ball.get(0L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyegreen"), 72), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32416), 100, 16);
        GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Ball.get(0L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyebrown"), 72), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32417), 100, 16);
        GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Ball.get(0L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeblue"), 72), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32418), 100, 16);
        GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Ball.get(0L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyepurple"), 72), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32419), 100, 16);
        GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Ball.get(0L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyecyan"), 72), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32420), 100, 16);
        GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Ball.get(0L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyelightgray"), 72), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32421), 100, 16);
        GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Ball.get(0L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyegray"), 72), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32422), 100, 16);
        GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Ball.get(0L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyepink"), 72), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32423), 100, 16);
        GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Ball.get(0L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyelime"), 72), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32424), 100, 16);
        GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Ball.get(0L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeyellow"), 72), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32425), 100, 16);
        GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Ball.get(0L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyelightblue"), 72), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32426), 100, 16);
        GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Ball.get(0L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyemagenta"), 72), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32427), 100, 16);
        GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Ball.get(0L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeorange"), 72), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32428), 100, 16);
        GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Ball.get(0L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyewhite"), 72), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32429), 100, 16);

        if (Loader.isModLoaded("miscutils")) //GT++ remove later
            new GTPPRecipeLoader().run();

        GT_Values.RA.addFormingPressRecipe(CustomItemList.MalformedSlush.get(2L), CustomItemList.MarshmallowForm.get(0L), CustomItemList.UncookedSlush.get(1L), 1200, 7680);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), CustomItemList.MarshmallowForm.get(0L), CustomItemList.MarshmallowForm.get(1L), 200, 256);
        if (Loader.isModLoaded("BuildCraft|Silicon"))
            GT_Values.RA.addFormingPressRecipe(ItemList.Circuit_Parts_Crystal_Chip_Master.get(1L), GT_ModHandler.getModItem("BuildCraft|Silicon", "redstoneChipset", 1L, 4), CustomItemList.EssentiaCircuit.get(1L), 300, 480);
        if (Loader.isModLoaded("ProjRed|Core"))
            GT_Values.RA.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Stone, 2L), CustomItemList.EtchedLowVoltageWiring.get(1L), GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 0), 100, 16);

        GT_Values.RA.addForgeHammerRecipe(new ItemStack(Items.nether_star, 1, 0), CustomItemList.NetherStarFragment.get(2L), 16, 30);

        if (Loader.isModLoaded("Thaumcraft"))
            GT_Values.RA.addForgeHammerRecipe(GT_ModHandler.getModItem("Thaumcraft", "ItemEldritchObject", 1L, 3), CustomItemList.PrimordialPearlFragment.get(3L), 16, 7680);

        GT_Values.RA.addFormingPressRecipe(CustomItemList.MicaBasedPulp.get(4L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Asbestos, 1L), CustomItemList.MicaBasedSheet.get(4L), 400, 28);

        GT_Values.RA.addBenderRecipe(GT_OreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.Steel, 1L), ItemList.Shape_Empty.get(1L), 200, 120);

        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Plate.get(0L), ItemList.Shape_Mold_Plate.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Casing.get(0L), ItemList.Shape_Mold_Casing.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Gear.get(0L), ItemList.Shape_Mold_Gear.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Credit.get(0L), ItemList.Shape_Mold_Credit.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Bottle.get(0L), ItemList.Shape_Mold_Bottle.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Ingot.get(0L), ItemList.Shape_Mold_Ingot.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Ball.get(0L), ItemList.Shape_Mold_Ball.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Block.get(0L), ItemList.Shape_Mold_Block.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Nugget.get(0L), ItemList.Shape_Mold_Nugget.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Bun.get(0L), ItemList.Shape_Mold_Bun.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Bread.get(0L), ItemList.Shape_Mold_Bread.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Baguette.get(0L), ItemList.Shape_Mold_Baguette.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Cylinder.get(0L), ItemList.Shape_Mold_Cylinder.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Anvil.get(0L), ItemList.Shape_Mold_Anvil.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Name.get(0L), ItemList.Shape_Mold_Name.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Arrow.get(0L), ItemList.Shape_Mold_Arrow.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Gear_Small.get(0L), ItemList.Shape_Mold_Gear_Small.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Rod.get(0L), ItemList.Shape_Mold_Rod.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Bolt.get(0L), ItemList.Shape_Mold_Bolt.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Round.get(0L), ItemList.Shape_Mold_Round.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Screw.get(0L), ItemList.Shape_Mold_Screw.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Ring.get(0L), ItemList.Shape_Mold_Ring.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Rod_Long.get(0L), ItemList.Shape_Mold_Rod_Long.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Rotor.get(0L), ItemList.Shape_Mold_Rotor.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Turbine_Blade.get(0L), ItemList.Shape_Mold_Turbine_Blade.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Pipe_Tiny.get(0L), ItemList.Shape_Mold_Pipe_Tiny.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Pipe_Small.get(0L), ItemList.Shape_Mold_Pipe_Small.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Pipe_Medium.get(0L), ItemList.Shape_Mold_Pipe_Medium.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Pipe_Large.get(0L), ItemList.Shape_Mold_Pipe_Large.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Pipe_Huge.get(0L), ItemList.Shape_Mold_Pipe_Huge.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), GT_ModHandler.getModItem("dreamcraft", "item.MoldHelmet", 0, 0), GT_ModHandler.getModItem("dreamcraft", "item.MoldHelmet", 1, 0), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), GT_ModHandler.getModItem("dreamcraft", "item.MoldChestplate", 0, 0), GT_ModHandler.getModItem("dreamcraft", "item.MoldChestplate", 1, 0), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), GT_ModHandler.getModItem("dreamcraft", "item.MoldLeggings", 0, 0), GT_ModHandler.getModItem("dreamcraft", "item.MoldLeggings", 1, 0), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), GT_ModHandler.getModItem("dreamcraft", "item.MoldBoots", 0, 0), GT_ModHandler.getModItem("dreamcraft", "item.MoldBoots", 1, 0), 200, 256);

        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Plate.get(0L), ItemList.Shape_Extruder_Plate.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Rod.get(0L), ItemList.Shape_Extruder_Rod.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Bolt.get(0L), ItemList.Shape_Extruder_Bolt.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Ring.get(0L), ItemList.Shape_Extruder_Ring.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Cell.get(0L), ItemList.Shape_Extruder_Cell.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Ingot.get(0L), ItemList.Shape_Extruder_Ingot.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Wire.get(0L), ItemList.Shape_Extruder_Wire.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Casing.get(0L), ItemList.Shape_Extruder_Casing.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Pipe_Tiny.get(0L), ItemList.Shape_Extruder_Pipe_Tiny.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Pipe_Small.get(0L), ItemList.Shape_Extruder_Pipe_Small.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Pipe_Medium.get(0L), ItemList.Shape_Extruder_Pipe_Medium.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Pipe_Large.get(0L), ItemList.Shape_Extruder_Pipe_Large.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Pipe_Huge.get(0L), ItemList.Shape_Extruder_Pipe_Huge.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Block.get(0L), ItemList.Shape_Extruder_Block.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Sword.get(0L), ItemList.Shape_Extruder_Sword.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Pickaxe.get(0L), ItemList.Shape_Extruder_Pickaxe.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Shovel.get(0L), ItemList.Shape_Extruder_Shovel.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Axe.get(0L), ItemList.Shape_Extruder_Axe.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Hoe.get(0L), ItemList.Shape_Extruder_Hoe.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Hammer.get(0L), ItemList.Shape_Extruder_Hammer.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_File.get(0L), ItemList.Shape_Extruder_File.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Saw.get(0L), ItemList.Shape_Extruder_Saw.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Gear.get(0L), ItemList.Shape_Extruder_Gear.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Bottle.get(0L), ItemList.Shape_Extruder_Bottle.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Rotor.get(0L), ItemList.Shape_Extruder_Rotor.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Small_Gear.get(0L), ItemList.Shape_Extruder_Small_Gear.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Turbine_Blade.get(0L), ItemList.Shape_Extruder_Turbine_Blade.get(1L), 200, 256);
        GT_Values.RA.addFormingPressRecipe(ItemList.Shape_Empty.get(1L), GT_ModHandler.getModItem("dreamcraft", "item.ExtruderShapeBoat", 0, 0), GT_ModHandler.getModItem("dreamcraft", "item.ExtruderShapeBoat", 1, 0), 200, 256);

        GT_Values.RA.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L), ItemList.Shape_Mold_Ball.get(0L), ItemList.Circuit_Parts_Glass_Tube.get(1L), 120, 30);
        GT_Values.RA.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L), ItemList.Shape_Mold_Bottle.get(0L), ItemList.Bottle_Empty.get(1L), 32, 8);
        GT_Values.RA.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L), ItemList.Shape_Mold_Block.get(0L), new ItemStack(Blocks.glass, 1, 0), 100, 30);
        if (Loader.isModLoaded("BloodArsenal"))
            GT_Values.RA.addFormingPressRecipe(GT_ModHandler.getModItem("BloodArsenal", "glass_shard", 2L, 0), ItemList.Shape_Mold_Block.get(0L), new ItemStack(Blocks.glass, 1, 0), 100, 30);

        GT_Values.RA.addExtruderRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.AnnealedCopper, 1L), ItemList.Shape_Extruder_Rod.get(0L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.AnnealedCopper, 2L), 200, 90);
        GT_Values.RA.addExtruderRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 1L), ItemList.Shape_Extruder_Rod.get(0L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.WroughtIron, 2L), 200, 90);

        if (Loader.isModLoaded("Avaritia") && (Loader.isModLoaded("TConstruct"))) {
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1), GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 500), 150, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("TConstruct", "toolShard", 1L, 500), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1), GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 500), 200, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2), GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 500), 200, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("TConstruct", "toolShard", 2L, 500), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2), GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 500), 300, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3), GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 500), 200, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("TConstruct", "toolShard", 2L, 500), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3), GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 500), 300, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4), GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 500), 200, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("TConstruct", "toolShard", 2L, 500), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4), GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 500), 300, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5), GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 500), 200, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("TConstruct", "toolShard", 2L, 500), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5), GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 500), 300, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6), GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 500), 150, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("TConstruct", "toolShard", 1L, 500), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6), GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 500), 200, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7), GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 500), 150, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("TConstruct", "toolShard", 1L, 500), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7), GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 500), 200, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8), GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 500), 150, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("TConstruct", "toolShard", 1L, 500), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8), GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 500), 200, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9), GT_ModHandler.getModItem("TConstruct", "binding", 1L, 500), 150, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("TConstruct", "toolShard", 1L, 500), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9), GT_ModHandler.getModItem("TConstruct", "binding", 1L, 500), 200, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10), GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 500), 200, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("TConstruct", "toolShard", 2L, 500), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10), GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 500), 300, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11), GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 500), 200, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("TConstruct", "toolShard", 2L, 500), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11), GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 500), 300, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12), GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 500), 150, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("TConstruct", "toolShard", 1L, 500), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12), GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 500), 200, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13), GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 500), 150, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("TConstruct", "toolShard", 1L, 500), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13), GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 500), 200, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 3L, 4), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14), GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 500), 300, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("TConstruct", "toolShard", 6L, 500), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14), GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 500), 400, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 3L, 4), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15), GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 500), 300, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("TConstruct", "toolShard", 6L, 500), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15), GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 500), 400, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 8L, 4), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16), GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 500), 800, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("TConstruct", "toolShard", 16L, 500), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16), GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 500), 1000, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 8L, 4), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17), GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 500), 800, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("TConstruct", "toolShard", 16L, 500), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17), GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 500), 1000, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 8L, 4), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18), GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 500), 800, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("TConstruct", "toolShard", 16L, 500), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18), GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 500), 1000, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 8L, 4), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19), GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 500), 800, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("TConstruct", "toolShard", 16L, 500), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19), GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 500), 1000, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 8L, 4), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20), GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 500), 800, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("TConstruct", "toolShard", 16L, 500), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20), GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 500), 1000, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 8L, 4), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21), GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 500), 800, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("TConstruct", "toolShard", 16L, 500), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21), GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 500), 1000, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 3L, 4), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22), GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 500), 300, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("TConstruct", "toolShard", 6L, 500), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22), GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 500), 400, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 3L, 4), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25), GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 500), 200, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("TConstruct", "toolShard", 6L, 500), GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25), GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 500), 300, 122880);

            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0), GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 500), 150, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("TConstruct", "toolShard", 1L, 500), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0), GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 500), 200, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 4L, 4), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1), GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 500), 400, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("TConstruct", "toolShard", 8L, 500), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1), GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 500), 500, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 5L, 4), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2), GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 500), 600, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("TConstruct", "toolShard", 10L, 500), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2), GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 500), 750, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 2L, 4), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3), GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 500), 350, 122880);
            GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("TConstruct", "toolShard", 3L, 500), GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3), GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 500), 450, 122880);
            if (Loader.isModLoaded("TGregworks"))
                GT_Values.RA.addExtruderRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4), GT_ModHandler.getModItem("TGregworks", "tgregworks.shardcast", 0L, 0), GT_ModHandler.getModItem("TConstruct", "toolShard", 2L, 500), 150, 122880);
        }

        GT_Values.RA.addExtruderRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 1L), ItemList.Shape_Extruder_Pipe_Tiny.get(0L), GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.WroughtIron, 2L), 4, 120);
        GT_Values.RA.addExtruderRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 1L), ItemList.Shape_Extruder_Pipe_Small.get(0L), GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.WroughtIron, 1L), 8, 120);
        GT_Values.RA.addExtruderRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 3L), ItemList.Shape_Extruder_Pipe_Medium.get(0L), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.WroughtIron, 1L), 24, 120);
        GT_Values.RA.addExtruderRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 6L), ItemList.Shape_Extruder_Pipe_Large.get(0L), GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.WroughtIron, 1L), 48, 120);
        GT_Values.RA.addExtruderRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 12L), ItemList.Shape_Extruder_Pipe_Huge.get(0L), GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.WroughtIron, 1L), 96, 120);

        GT_Values.RA.addExtruderRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 2L), ItemList.Shape_Extruder_Hoe.get(0L), GT_OreDictUnificator.get(OrePrefixes.toolHeadHoe, Materials.StainlessSteel, 1L), 150, 120);

        if (Loader.isModLoaded("miscutils")) { //GT++, remember to remove later
            GT_Values.RA.addExtruderRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Iron, 9L), GT_ModHandler.getModItem("miscutils", "MU-metaitem.01", 0L, 32040), ItemList.IC2_ShaftIron.get(1L), 640, 120);
            GT_Values.RA.addExtruderRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 9L), GT_ModHandler.getModItem("miscutils", "MU-metaitem.01", 0L, 32040), ItemList.IC2_ShaftIron.get(1L), 640, 120);
            GT_Values.RA.addExtruderRecipe(GT_OreDictUnificator.get(OrePrefixes.block, Materials.Iron, 1L), GT_ModHandler.getModItem("miscutils", "MU-metaitem.01", 0L, 32040), ItemList.IC2_ShaftIron.get(1L), 640, 120);
            GT_Values.RA.addExtruderRecipe(GT_OreDictUnificator.get(OrePrefixes.block, Materials.WroughtIron, 1L), GT_ModHandler.getModItem("miscutils", "MU-metaitem.01", 0L, 32040), ItemList.IC2_ShaftIron.get(1L), 640, 120);
            GT_Values.RA.addExtruderRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 9L), GT_ModHandler.getModItem("miscutils", "MU-metaitem.01", 0L, 32040), ItemList.IC2_ShaftSteel.get(1L), 1280, 120);
            GT_Values.RA.addExtruderRecipe(GT_OreDictUnificator.get(OrePrefixes.block, Materials.Steel, 1L), GT_ModHandler.getModItem("miscutils", "MU-metaitem.01", 0L, 32040), ItemList.IC2_ShaftSteel.get(1L), 1280, 120);
        }

        if (Loader.isModLoaded("TConstruct"))
            GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("TConstruct", "Smeltery", 1L, 2), GT_ModHandler.getModItem("TConstruct", "materials", 4L, 2));

        GT_Values.RA.addDistilleryRecipe(GT_Utility.getIntegratedCircuit(1), Materials.Milk.getFluid(1000L), FluidRegistry.getFluidStack("fluidmilk", 1000), 100, 2, false);
        GT_Values.RA.addDistilleryRecipe(GT_Utility.getIntegratedCircuit(1), FluidRegistry.getFluidStack("fluidmilk", 1000), Materials.Milk.getFluid(1000L), 100, 2, false);

        GT_Values.RA.addImplosionRecipe(CustomItemList.NetherStarFragment.get(2L), 1, new ItemStack(Items.nether_star, 1, 0), GT_Values.NI);
        if (Loader.isModLoaded("GalaxySpace")) {
            GT_Values.RA.addImplosionRecipe(GT_OreDictUnificator.get(OrePrefixes.compressed, Materials.Aluminium, 2L), 1, GT_ModHandler.getModItem("GalaxySpace", "item.CompressedDualAluminium", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L));
            GT_Values.RA.addImplosionRecipe(GT_OreDictUnificator.get(OrePrefixes.compressed, Materials.Bronze, 2L), 1, GT_ModHandler.getModItem("GalaxySpace", "item.CompressedDualBronze", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L));
            GT_Values.RA.addImplosionRecipe(CustomItemList.RawSDHCAlloy.get(1L), 5, GT_ModHandler.getModItem("GalaxySpace", "item.CompressedSDHD120", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.StainlessSteel, 1L));
            GT_Values.RA.addImplosionRecipe(GT_OreDictUnificator.get(OrePrefixes.block, Materials.Coal, 1L), 1, GT_ModHandler.getModItem("GalaxySpace", "item.CompressedCoal", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L));
            GT_Values.RA.addImplosionRecipe(GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.BlackPlutonium, 1L), 1, CustomItemList.BlackPlutoniumCompressedPlate.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L));
            GT_Values.RA.addImplosionRecipe(GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Adamantium, 1L), 1, GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L));
            GT_Values.RA.addImplosionRecipe(GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Cobalt, 1L), 1, GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 1), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L));
            GT_Values.RA.addImplosionRecipe(GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Duralumin, 1L), 1, GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 2), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L));
            GT_Values.RA.addImplosionRecipe(GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Lead, 1L), 1, GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 3), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L));
            GT_Values.RA.addImplosionRecipe(GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Magnesium, 1L), 1, GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 4), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L));
            GT_Values.RA.addImplosionRecipe(GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Mithril, 1L), 1, GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 5), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L));
            GT_Values.RA.addImplosionRecipe(GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Nickel, 1L), 1, GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 6), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L));
            GT_Values.RA.addImplosionRecipe(GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Oriharukon, 1L), 1, GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 7), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L));
            GT_Values.RA.addImplosionRecipe(GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Platinum, 1L), 1, GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 8), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L));
            GT_Values.RA.addImplosionRecipe(GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Tungsten, 1L), 1, GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 9), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L));
        }
        if (Loader.isModLoaded("GalacticraftMars")) {
            GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 2L, 6), 2, CustomItemList.TitaniumDualCompressedPlates.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L));
            GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("GalacticraftMars", "item.null", 2L, 5), 2, CustomItemList.DeshDualCompressedPlates.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L));
        }
        GT_Values.RA.addImplosionRecipe(CustomItemList.IceCompressedPlate.get(2L), 2, CustomItemList.IceDualCompressedPlates.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L));
        GT_Values.RA.addImplosionRecipe(CustomItemList.QuantinumCompressedPlate.get(2L), 2, CustomItemList.QuantinumDualCompressedPlates.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L));
        GT_Values.RA.addImplosionRecipe(CustomItemList.MysteriousCrystalPlate.get(3L), 1, CustomItemList.MysteriousCrystalCompressedPlate.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L));
        GT_Values.RA.addImplosionRecipe(GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Ledox, 1L), 1, CustomItemList.LedoxCompressedPlate.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L));
        GT_Values.RA.addImplosionRecipe(GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Mytryl, 1L), 1, CustomItemList.MytrylCompressedPlate.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L));
        GT_Values.RA.addImplosionRecipe(GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Quantium, 1L), 1, CustomItemList.QuantinumCompressedPlate.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L));
        GT_Values.RA.addImplosionRecipe(GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.CallistoIce, 1L), 1, CustomItemList.CallistoIceCompressedPlate.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 1L));

        GT_Values.RA.addImplosionRecipe(CustomItemList.MytrylCompressedPlate.get(2L), 2, CustomItemList.MytrylDualCompressedPlates.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L));
        GT_Values.RA.addImplosionRecipe(CustomItemList.MysteriousCrystalCompressedPlate.get(2L), 2, CustomItemList.MysteriousCrystalDualCompressedPlates.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L));
        if (Loader.isModLoaded("GalacticraftCore")) {
            GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 2L, 9), 2, CustomItemList.SteelDualCompressedPlates.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L));
            GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 2L, 7), 2, CustomItemList.TinDualCompressedPlates.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L));
            GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 2L, 6), 2, CustomItemList.CopperDualCompressedPlates.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L));
            GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 2L, 11), 2, CustomItemList.IronDualCompressedPlates.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L));
            GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.meteoricIronIngot", 2L, 1), 2, CustomItemList.MeteoricIronDualCompressedPlates.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L));
        }
        if (!Loader.isModLoaded("bartworks"))
            GT_Values.RA.addImplosionRecipe(CustomItemList.HeavyDutyAlloyIngotT4.get(1L), 32, CustomItemList.HeavyDutyPlateTier4.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Osmiridium, 4L));
        GT_Values.RA.addImplosionRecipe(CustomItemList.HeavyDutyAlloyIngotT5.get(1L), 40, CustomItemList.HeavyDutyPlateTier5.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Europium, 5L));
        GT_Values.RA.addImplosionRecipe(CustomItemList.HeavyDutyAlloyIngotT6.get(1L), 48, CustomItemList.HeavyDutyPlateTier6.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Tritanium, 6L));
        GT_Values.RA.addImplosionRecipe(CustomItemList.HeavyDutyAlloyIngotT7.get(1L), 56, CustomItemList.HeavyDutyPlateTier7.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Neutronium, 7L));
        GT_Values.RA.addImplosionRecipe(CustomItemList.HeavyDutyAlloyIngotT8.get(1L), 64, CustomItemList.HeavyDutyPlateTier8.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.BlackPlutonium, 8L));
        //Avaritia recipes
        if (Loader.isModLoaded("Avaritia")) {
            GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 2), 1, GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 3), GT_Values.NI);
            GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 3), 4, GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4), GT_Values.NI);
            GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 4), 16, GT_ModHandler.getModItem("Avaritia", "Resource_Block", 1L, 0), GT_Values.NI);
            GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 6), 64, GT_ModHandler.getModItem("Avaritia", "Resource_Block", 1L, 1), GT_Values.NI);
        }
        //extra utils
        if (Loader.isModLoaded("ExtraUtilities")) {
        	//CC
        	GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 9L, 0), 1, GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1L, 1), GT_Values.NI);
        	GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 9L, 1), 1, GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1L, 2), GT_Values.NI);
        	GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 9L, 2), 1, GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1L, 3), GT_Values.NI);
            GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 9L, 3), 1, GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1L, 4), GT_Values.NI);
            GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 9L, 4), 8, GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1L, 5), GT_Values.NI);
            GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 9L, 5), 10, GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1L, 6), GT_Values.NI);
            GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 9L, 6), 16, GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1L, 7), GT_Values.NI);
            //CD
            GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 9L, 8), 1, GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1L, 9), GT_Values.NI);
            GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 9L, 9), 2, GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1L, 10), GT_Values.NI);
            GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 9L, 10), 4, GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1L, 11), GT_Values.NI);
            //CG
            GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 9L, 12), 1, GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1L, 13), GT_Values.NI);
            //CS
            GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 9L, 14), 1, GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1L, 15), GT_Values.NI);
            
            GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 9), 8, GT_ModHandler.getModItem("ExtraUtilities", "block_bedrockium", 1L), GT_Values.NI);
        }

        if (Loader.isModLoaded("StevesCarts"))
            GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 1L, 18), 1, GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 1L, 19), GT_Values.NI);

        GT_Values.RA.addImplosionRecipe(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Diamond, 1L), 2, GT_ModHandler.getModItem("Translocator", "diamondNugget", 2L, 0), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.DarkAsh, 1L));

        if (Loader.isModLoaded("DraconicEvolution")) {
            GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("DraconicEvolution", "chaosFragment", 9L, 2), 8, GT_ModHandler.getModItem("DraconicEvolution", "chaosShard", 1L, 0), GT_Values.NI);
            GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("DraconicEvolution", "chaosFragment", 9L, 1), 4, GT_ModHandler.getModItem("DraconicEvolution", "chaosFragment", 1L, 2), GT_Values.NI);
            GT_Values.RA.addImplosionRecipe(GT_ModHandler.getModItem("DraconicEvolution", "chaosFragment", 9L, 0), 2, GT_ModHandler.getModItem("DraconicEvolution", "chaosFragment", 1L, 1), GT_Values.NI);
        }

        GT_Values.RA.addLatheRecipe(CustomItemList.ReinforcedGlassPLate.get(1L), CustomItemList.ReinforcedGlassLense.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Glass, 1L), 400, 16);

        if (Loader.isModLoaded("Thaumcraft") && (Loader.isModLoaded("DraconicEvolution")) && (Loader.isModLoaded("witchery")))
            GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wheat, 1L), GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 1L, 14), new ItemStack(Items.sugar, 1, 0), GT_ModHandler.getModItem("DraconicEvolution", "draconiumDust", 1L, 0), GT_Values.NI, GT_Utility.getIntegratedCircuit(2), FluidRegistry.getFluidStack("witchery:fluidspirit", 1000), GT_Values.NF, CustomItemList.MalformedSlush.get(2L), 600, 7680);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrudeSteel, 3L), 100, 8);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 3L), 100, 8);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 1L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 3L), 100, 8);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 1L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 3L), 100, 8);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 1L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticSilver, 3L), 100, 8);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 3L), 100, 8);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticSilver, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VividAlloy, 3L), 100, 8);
        if (Loader.isModLoaded("EnderIO"))
            GT_Values.RA.addMixerRecipe(GT_ModHandler.getModItem("EnderIO", "itemMaterial", 1L, 14), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Emerald, 1L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrystallineAlloy, 3L), 100, 8);
        if (Loader.isModLoaded("TConstruct"))
            GT_Values.RA.addMixerRecipe(GT_ModHandler.getModItem("TConstruct", "slime.gel", 1L, 2), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Diamond, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrystallineAlloy, 1L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrystallinePinkSlime, 3L), 100, 8);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EndSteel, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MelodicAlloy, 3L), 100, 8);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MelodicAlloy, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherStar, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StellarAlloy, 3L), 100, 8);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectricalSteel, 3L), 100, 8);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 1L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PulsatingIron, 3L), 100, 8);
        GT_Values.RA.addMixerRecipe(new ItemStack(Blocks.soul_sand, 1, 0), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Soularium, 3L), 100, 8);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectricalSteel, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkSteel, 3L), 100, 8);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkSteel, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Endstone, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EndSteel, 3L), 100, 8);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 2L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Platinum, 1L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderiumBase, 4L), 400, 8);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderiumBase, 2L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thaumium, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 1L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Enderium, 4L), 200, 8);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cadmium, 5L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), Materials.Oxygen.getGas(6000), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Pentacadmiummagnesiumhexaoxid, 12L), 1200, 120);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Barium, 9L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 10L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), Materials.Oxygen.getGas(20000), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titaniumonabariumdecacoppereikosaoxid, 40L), 2400, 120);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Platinum, 3L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uraniumtriplatinid, 4L), 400, 480);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadium, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Indium, 3L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadiumtriindinid, 4L), 400, 480);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Indium, 4L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 2L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Barium, 2L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 7L), GT_Utility.getIntegratedCircuit(3), Materials.Oxygen.getGas(14000), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid, 30L), 2400, 1920);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 4L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Indium, 2L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Palladium, 6L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1L), GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 13L), 1200, 1920);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadria, 4L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmiridium, 3L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Europium, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Samarium, 1L), GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforuvwire, 9L), 1800, 7680);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 6L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CosmicNeutronium, 7L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tritanium, 5L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Americium, 6L), GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforuhvwire, 24L), 3600, 30720);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ardite, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 2L), 400, 8);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mica, 3L), ItemList.IC2_Resin.get(1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, CustomItemList.MicaBasedPulp.get(4L), 400, 8);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mica, 3L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RawRubber, 2L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, CustomItemList.MicaBasedPulp.get(4L), 400, 8);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSG, 6L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 2L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.getDust(Materials.HSSS, 9L * OrePrefixes.dust.mMaterialAmount), (int) (800L * OrePrefixes.dust.mMaterialAmount / 3628800L), 4500);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 2L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.getDust(Materials.NaquadahAlloy, 4L * OrePrefixes.dust.mMaterialAmount), (int) (400L * OrePrefixes.dust.mMaterialAmount / 3628800L), 8000);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Barium, 2L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.AnyCopper, 3L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), Materials.Oxygen.getGas(7000), GT_Values.NF, GT_OreDictUnificator.getDust(Materials.YttriumBariumCuprate, 6L * OrePrefixes.dust.mMaterialAmount), (int) (600L * OrePrefixes.dust.mMaterialAmount / 3628800L), 2000);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 6L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.AnyCopper, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 1L), GT_Values.NI, GT_Utility.getIntegratedCircuit(3), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.getDust(Materials.Duralumin, 9L * OrePrefixes.dust.mMaterialAmount), (int) (900L * OrePrefixes.dust.mMaterialAmount / 3628800L), 2000);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 2L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 5L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 2L), GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NI, GT_Values.NF, GT_Values.NF, CustomItemList.AlumiteDust.get(9L), 200, 8);
        if (Loader.isModLoaded("TConstruct"))
            GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 3L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_ModHandler.getModItem("TConstruct", "materials", 4L, 42), 200, 8);
        GT_Values.RA.addMixerRecipe(ItemList.IC2_Energium_Dust.get(9L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 6L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, CustomItemList.LapotronDust.get(15L), 600, 480);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Flint, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 4L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 4L), 200, 8);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 16L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(4), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 16L), 800, 8);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Flint, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 4L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 5L), 160, 8);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 16L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(4), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 20L), 640, 8);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Arsenic, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GalliumArsenide, 2L), 300, 30);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadium, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 7L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VanadiumSteel, 9L), 100, 30);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 4L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RoseGold, 5L), 200, 120);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 6L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L), GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StainlessSteel, 9L), 900, 120);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RoseGold, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedGold, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.AstralSilver, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SterlingSilver, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SolderingAlloy, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedSteel, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlueSteel, 1l), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1L), GT_Utility.getIntegratedCircuit(4), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectrumFlux, 4L), 50, 900);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 9L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 6L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Molybdenum, 1L), GT_Values.NI, GT_Utility.getIntegratedCircuit(18), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DamascusSteel, 18L), 225, 900);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 9L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 4L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 4L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadium, 1L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(9), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DamascusSteel, 18L), 225, 900);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Electrum, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Electrotine, 1L), 200, 8);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, 2L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L), GT_Values.NI, GT_Utility.getIntegratedCircuit(2), Materials.Water.getFluid(2000L), Materials.Concrete.getMolten(2304L), GT_Values.NI, 100, 16);
        if (Loader.isModLoaded("ExtraTrees"))
            GT_Values.RA.addMixerRecipe(GT_ModHandler.getModItem("ExtraTrees", "misc", 4L, 2), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(1), Materials.Water.getFluid(500L), GT_Values.NF, ItemList.FR_Mulch.get(1L), 600, 2);
        if (Loader.isModLoaded("witchery") && (Loader.isModLoaded("Genetics"))) {
            GT_Values.RA.addMixerRecipe(new ItemStack(Items.sugar, 1, 0), new ItemStack(Items.bone, 1, 0), ItemList.FR_Mulch.get(1L), GT_ModHandler.getModItem("witchery", "ingredient", 1L, 18), GT_Values.NI, GT_Utility.getIntegratedCircuit(2), Materials.Water.getFluid(1000L), GT_Values.NF, GT_ModHandler.getModItem("Genetics", "misc", 1L, 4), 400, 16);
            GT_Values.RA.addMixerRecipe(new ItemStack(Items.sugar, 1, 0), new ItemStack(Items.bone, 1, 0), ItemList.FR_Mulch.get(1L), GT_ModHandler.getModItem("witchery", "ingredient", 1L, 18), GT_Values.NI, GT_Utility.getIntegratedCircuit(3), GT_ModHandler.getDistilledWater(800L), GT_Values.NF, GT_ModHandler.getModItem("Genetics", "misc", 1L, 4), 400, 16);
        }
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Clay, 8L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_ModHandler.getWater(1000L), GT_Values.NF, new ItemStack(Items.clay_ball, 4, 0), 100, 8);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 4L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedAlloy, 1L), 100, 16);
        if (Loader.isModLoaded("BiomesOPlenty"))
            GT_Values.RA.addMixerRecipe(new ItemStack(Blocks.dirt, 1, 0), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(4), Materials.Water.getFluid(1000L), GT_Values.NF, GT_ModHandler.getModItem("BiomesOPlenty", "mudball", 4L, 0), 50, 8);
        GT_Values.RA.addMixerRecipe(new ItemStack(Blocks.dirt, 1, 0), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 2L), new ItemStack(Blocks.sand, 4, 0), GT_Values.NI, Materials.Water.getFluid(1000L), GT_Values.NF, ItemList.IC2_Fertilizer.get(4), 100, 30);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lead, 4L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Antimony, 1L), GT_Values.NI, GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BatteryAlloy, 5L), 100, 4);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 9L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Antimony, 1L), GT_Values.NI, GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SolderingAlloy, 10L), 100, 8);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 2L), GT_Values.NI, GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnalium, 3L), 100, 4);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neutronium, 16L), GT_Values.NI, GT_Utility.getIntegratedCircuit(1), GT_Values.NI, Materials.Helium.getPlasma(2304L), GT_Values.NF, CustomItemList.RawNeutronium.get(16L), 3600, 122880);

        GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("concrete", 1000), Materials.Concrete.getMolten(1000L), 20, 16, false);
        GT_Values.RA.addFermentingRecipe(Materials.Concrete.getMolten(1000L), Materials.ConstructionFoam.getFluid(1000), 20, 16, false);
        GT_Values.RA.addFermentingRecipe(Materials.ConstructionFoam.getFluid(1000), FluidRegistry.getFluidStack("concrete", 1000), 20, 16, false);

        if (Loader.isModLoaded("harvestcraft") && (Loader.isModLoaded("Forestry")) && (Loader.isModLoaded("OpenComputers")))
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sugar, 1L), GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Fuel, 1L), GT_OreDictUnificator.get(OrePrefixes.cell, Materials.SulfuricAcid, 1L), GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Acetone, 1L), GT_ModHandler.getModItem("harvestcraft", "pepperoniItem", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.dye, Materials.Red, 1L), GT_Utility.getIntegratedCircuit(1)}, FluidRegistry.getFluidStack("mead", 1000), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 18), 12000, 480);

        GT_Values.RA.addVacuumFreezerRecipe(CustomItemList.GlowingMarshmallow.get(1L), CustomItemList.Marshmallow.get(1L), 48000, 1920);

        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Neutronium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Neutronium, 1L), 1250, 7860);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Bedrockium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bedrockium, 1L), 1200, 122880);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CosmicNeutronium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.CosmicNeutronium, 1L), 1100, 122880);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.StellarAlloy, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.StellarAlloy, 1L), 1000, 7860);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Naquadah, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Naquadah, 1L), 990, 7860);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tritanium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tritanium, 1L), 969, 7860);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Oriharukon, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Oriharukon, 1L), 603, 7680);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.MelodicAlloy, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.MelodicAlloy, 1L), 739, 4096);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Americium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Americium, 1L), 735, 4096);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CrystallinePinkSlime, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.CrystallinePinkSlime, 1L), 580, 1920);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Platinum, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Platinum, 1L), 585, 480);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Iridium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Iridium, 1L), 576, 1920);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Osmiridium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Osmiridium, 1L), 573, 1920);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CrystallineAlloy, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.CrystallineAlloy, 1L), 572, 1920);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Osmium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Osmium, 1L), 570, 1920);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tungsten, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tungsten, 1L), 549, 1920);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Europium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Europium, 1L), 453, 1920);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Samarium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Samarium, 1L), 450, 1920);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.EnderiumBase, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EnderiumBase, 1L), 402, 480);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSS, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSS, 1L), 387, 1920);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Enderium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Enderium, 1L), 378, 480);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenSteel, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.TungstenSteel, 1L), 357, 1920);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VibrantAlloy, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.VibrantAlloy, 1L), 321, 480);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VividAlloy, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.VividAlloy, 1L), 321, 480);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Palladium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Palladium, 1L), 318, 480);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Draconium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Draconium, 1L), 294, 7860);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSG, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSG, 1L), 294, 480);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Quantium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Quantium, 1L), 294, 7860);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NaquadahAlloy, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.NaquadahAlloy, 1L), 294, 7860);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.BlackPlutonium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.BlackPlutonium, 1L), 294, 7860);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Naquadria, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Naquadria, 1L), 294, 7860);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NaquadahEnriched, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.NaquadahEnriched, 1L), 294, 7860);
        if (Loader.isModLoaded("Avaritia"))
            GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Infinity, 1L), GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 6), 294, 2000000);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.InfinityCatalyst, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.InfinityCatalyst, 1L), 294, 500000);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Adamantium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Adamantium, 1L), 294, 7860);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.DeepIron, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DeepIron, 1L), 294, 7860);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.BlackPlutonium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.BlackPlutonium, 1L), 294, 122880);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.DraconiumAwakened, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DraconiumAwakened, 1L), 294, 30720);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.MysteriousCrystal, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.MysteriousCrystal, 1L), 294, 7680);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.ElectrumFlux, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ElectrumFlux, 1L), 294, 7860);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Trinium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Trinium, 1L), 294, 7860);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenCarbide, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.TungstenCarbide, 1L), 291, 1920);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSE, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSE, 1L), 243, 480);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NiobiumTitanium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.NiobiumTitanium, 1L), 213, 480);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Nichrome, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Nichrome, 1L), 168, 480);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VanadiumGallium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.VanadiumGallium, 1L), 165, 480);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.YttriumBariumCuprate, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.YttriumBariumCuprate, 1L), 153, 1920);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Desh, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Desh, 1L), 147, 480);
        GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Titanium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Titanium, 1L), 144, 480);
        GT_Values.RA.addVacuumFreezerRecipe(CustomItemList.HotNetherrackBrick.get(1L), CustomItemList.InfernalBrick.get(1L), 200, 120);

        GT_Values.RA.addLatheRecipe(new ItemStack(Blocks.wooden_slab, 1, 0), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
        GT_Values.RA.addLatheRecipe(new ItemStack(Blocks.wooden_slab, 1, 1), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
        GT_Values.RA.addLatheRecipe(new ItemStack(Blocks.wooden_slab, 1, 2), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
        GT_Values.RA.addLatheRecipe(new ItemStack(Blocks.wooden_slab, 1, 3), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
        GT_Values.RA.addLatheRecipe(new ItemStack(Blocks.wooden_slab, 1, 4), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
        GT_Values.RA.addLatheRecipe(new ItemStack(Blocks.wooden_slab, 1, 5), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
        if (Loader.isModLoaded("Forestry")) {
            GT_Values.RA.addLatheRecipe(GT_ModHandler.getModItem("Forestry", "slabs1", 1L, 0), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
            GT_Values.RA.addLatheRecipe(GT_ModHandler.getModItem("Forestry", "slabs1", 1L, 1), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
            GT_Values.RA.addLatheRecipe(GT_ModHandler.getModItem("Forestry", "slabs1", 1L, 2), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
            GT_Values.RA.addLatheRecipe(GT_ModHandler.getModItem("Forestry", "slabs1", 1L, 3), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
            GT_Values.RA.addLatheRecipe(GT_ModHandler.getModItem("Forestry", "slabs1", 1L, 4), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
            GT_Values.RA.addLatheRecipe(GT_ModHandler.getModItem("Forestry", "slabs1", 1L, 5), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
            GT_Values.RA.addLatheRecipe(GT_ModHandler.getModItem("Forestry", "slabs1", 1L, 6), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
            GT_Values.RA.addLatheRecipe(GT_ModHandler.getModItem("Forestry", "slabs1", 1L, 7), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
            GT_Values.RA.addLatheRecipe(GT_ModHandler.getModItem("Forestry", "slabs2", 1L, 0), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
            GT_Values.RA.addLatheRecipe(GT_ModHandler.getModItem("Forestry", "slabs2", 1L, 1), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
            GT_Values.RA.addLatheRecipe(GT_ModHandler.getModItem("Forestry", "slabs2", 1L, 2), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
            GT_Values.RA.addLatheRecipe(GT_ModHandler.getModItem("Forestry", "slabs2", 1L, 3), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
            GT_Values.RA.addLatheRecipe(GT_ModHandler.getModItem("Forestry", "slabs2", 1L, 4), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
            GT_Values.RA.addLatheRecipe(GT_ModHandler.getModItem("Forestry", "slabs2", 1L, 5), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
            GT_Values.RA.addLatheRecipe(GT_ModHandler.getModItem("Forestry", "slabs2", 1L, 6), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
            GT_Values.RA.addLatheRecipe(GT_ModHandler.getModItem("Forestry", "slabs2", 1L, 7), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
            GT_Values.RA.addLatheRecipe(GT_ModHandler.getModItem("Forestry", "slabs3", 1L, 0), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
            GT_Values.RA.addLatheRecipe(GT_ModHandler.getModItem("Forestry", "slabs3", 1L, 1), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
            GT_Values.RA.addLatheRecipe(GT_ModHandler.getModItem("Forestry", "slabs3", 1L, 2), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
            GT_Values.RA.addLatheRecipe(GT_ModHandler.getModItem("Forestry", "slabs3", 1L, 3), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
            GT_Values.RA.addLatheRecipe(GT_ModHandler.getModItem("Forestry", "slabs3", 1L, 4), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
            GT_Values.RA.addLatheRecipe(GT_ModHandler.getModItem("Forestry", "slabs3", 1L, 5), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
            GT_Values.RA.addLatheRecipe(GT_ModHandler.getModItem("Forestry", "slabs3", 1L, 6), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
            GT_Values.RA.addLatheRecipe(GT_ModHandler.getModItem("Forestry", "slabs3", 1L, 7), new ItemStack(Items.bowl, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1), 50, 8);
        }

        if (Loader.isModLoaded("GalacticraftCore")) {
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.moonBlock", 1L, 3), new ItemStack[]{CustomItemList.MoonStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.SiliconDioxide, 1)}, new int[]{10000, 5000}, 400, 30);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.moonBlock", 1L, 4), new ItemStack[]{CustomItemList.MoonStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.SiliconDioxide, 1)}, new int[]{10000, 5000}, 400, 30);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.moonBlock", 1L, 5), new ItemStack[]{CustomItemList.MoonStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.SiliconDioxide, 1)}, new int[]{10000, 5000}, 400, 30);
        }
        if (Loader.isModLoaded("GalacticraftMars")) {
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalacticraftMars", "tile.mars", 1L, 4), new ItemStack[]{CustomItemList.MarsStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.BandedIron, 1)}, new int[]{10000, 4000}, 400, 64);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalacticraftMars", "tile.mars", 1L, 5), new ItemStack[]{CustomItemList.MarsStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.BandedIron, 1)}, new int[]{10000, 4000}, 400, 64);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalacticraftMars", "tile.mars", 1L, 6), new ItemStack[]{CustomItemList.MarsStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.BandedIron, 1)}, new int[]{10000, 4000}, 400, 64);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalacticraftMars", "tile.mars", 1L, 9), new ItemStack[]{CustomItemList.MarsStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.BandedIron, 1)}, new int[]{10000, 4000}, 400, 64);
        }
        if (Loader.isModLoaded("GalaxySpace")) {
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "phobosblocks", 1L, 0), new ItemStack[]{CustomItemList.PhobosStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.BandedIron, 1)}, new int[]{10000, 5000}, 400, 64);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "phobosblocks", 1L, 1), new ItemStack[]{CustomItemList.PhobosStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.BandedIron, 1)}, new int[]{10000, 5000}, 400, 64);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "phobosblocks", 1L, 2), new ItemStack[]{CustomItemList.PhobosStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.BandedIron, 1)}, new int[]{10000, 5000}, 400, 64);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "deimosblocks", 1L, 0), new ItemStack[]{CustomItemList.DeimosStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Magnesite, 1)}, new int[]{10000, 5000}, 400, 64);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "deimosblocks", 1L, 1), new ItemStack[]{CustomItemList.DeimosStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Magnesite, 1)}, new int[]{10000, 5000}, 400, 64);
        }
        if (Loader.isModLoaded("GalacticraftMars")) {
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalacticraftMars", "tile.asteroidsBlock", 1L, 0), new ItemStack[]{CustomItemList.AsteroidsStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Gold, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Lead, 1)}, new int[]{10000, 4000, 2000}, 400, 120);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalacticraftMars", "tile.asteroidsBlock", 1L, 1), new ItemStack[]{CustomItemList.AsteroidsStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Gold, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Lead, 1)}, new int[]{10000, 4000, 2000}, 400, 120);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalacticraftMars", "tile.asteroidsBlock", 1L, 2), new ItemStack[]{CustomItemList.AsteroidsStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Gold, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Lead, 1)}, new int[]{10000, 4000, 2000}, 400, 120);
        }
        if (Loader.isModLoaded("GalaxySpace")) {
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "ceresblocks", 1L, 0), new ItemStack[]{CustomItemList.CeresStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.MeteoricIron, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Beryllium, 1)}, new int[]{10000, 5000, 2500}, 400, 120);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "ceresblocks", 1L, 1), new ItemStack[]{CustomItemList.CeresStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.MeteoricIron, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Beryllium, 1)}, new int[]{10000, 5000, 2500}, 400, 120);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "europagrunt", 1L, 1), new ItemStack[]{CustomItemList.EuropaIceDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Ledox, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Lapis, 1)}, new int[]{10000, 5000, 2500}, 400, 120);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "europaunderwatergeyser", 1L, 0), new ItemStack[]{CustomItemList.EuropaIceDust.get(2L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Ledox, 2), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Lapis, 2)}, new int[]{10000, 5000, 2500}, 400, 120);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "europagrunt", 1L, 0), new ItemStack[]{CustomItemList.EuropaStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.SiliconDioxide, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iron, 1)}, new int[]{10000, 5000, 2000}, 400, 120);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "europageyser", 1L, 0), new ItemStack[]{CustomItemList.EuropaStoneDust.get(2L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.SiliconDioxide, 2), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iron, 2)}, new int[]{10000, 5000, 3500}, 400, 120);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "ganymedeblocks", 1L, 0), new ItemStack[]{CustomItemList.GanymedeStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Titanium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Chromite, 1)}, new int[]{10000, 3500, 1000}, 400, 120);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "ganymedeblocks", 1L, 1), new ItemStack[]{CustomItemList.GanymedeStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Titanium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Chromite, 1)}, new int[]{10000, 3500, 1000}, 400, 120);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "callistoblocks", 1L, 0), new ItemStack[]{CustomItemList.CallistoStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.CallistoIce, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Galena, 1)}, new int[]{10000, 5000, 2500}, 400, 120);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "callistoblocks", 1L, 1), new ItemStack[]{CustomItemList.CallistoStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.CallistoIce, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Galena, 1)}, new int[]{10000, 5000, 2500}, 400, 120);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "ioblocks", 1L, 0), new ItemStack[]{CustomItemList.IoStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Sulfur, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Tantalite, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Tungsten, 1)}, new int[]{10000, 5000, 2500, 1500}, 400, 256);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "ioblocks", 1L, 1), new ItemStack[]{CustomItemList.IoStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Ash, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Sulfur, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Tantalite, 1)}, new int[]{10000, 5000, 3000, 2000}, 400, 256);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "ioblocks", 1L, 2), new ItemStack[]{CustomItemList.IoStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Sulfur, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Tantalite, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Tungsten, 1)}, new int[]{10000, 5000, 2500, 1500}, 400, 256);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "venusblocks", 1L, 0), new ItemStack[]{CustomItemList.VenusStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Tetrahedrite, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Quantium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Mytryl, 1)}, new int[]{10000, 4500, 2500, 1500}, 400, 256);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "venusblocks", 1L, 1), new ItemStack[]{CustomItemList.VenusStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Tetrahedrite, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Quantium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Mytryl, 1)}, new int[]{10000, 4500, 2500, 1500}, 400, 256);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "mercuryblocks", 1L, 0), new ItemStack[]{CustomItemList.MercuryStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Ilmenite, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Tungsten, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Draconium, 1)}, new int[]{10000, 3000, 2000, 1200}, 400, 256);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "mercuryblocks", 1L, 1), new ItemStack[]{CustomItemList.MercuryStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Ilmenite, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Tungsten, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Draconium, 1)}, new int[]{10000, 3000, 2000, 1200}, 400, 256);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "mercuryblocks", 1L, 2), new ItemStack[]{CustomItemList.MercuryCoreDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Ilmenite, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Tungsten, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Draconium, 1)}, new int[]{10000, 3000, 2000, 1200}, 400, 256);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "enceladusblocks", 1L, 0), new ItemStack[]{CustomItemList.EnceladusIceDust.get(1L), CustomItemList.MysteriousCrystalDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Chrome, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iridium, 1)}, new int[]{10000, 1500, 2000, 1000}, 400, 480);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "enceladusblocks", 1L, 1), new ItemStack[]{CustomItemList.EnceladusStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Chrome, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iridium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Osmium, 1)}, new int[]{10000, 3000, 2000, 1000}, 400, 480);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "enceladusblocks", 1L, 3), new ItemStack[]{CustomItemList.EnceladusIceDust.get(1L), CustomItemList.MysteriousCrystalDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Chrome, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iridium, 1)}, new int[]{10000, 1500, 2000, 1000}, 400, 480);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "titanblocks", 1L, 0), new ItemStack[]{CustomItemList.TitanStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Nickel, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iridium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Osmium, 1)}, new int[]{10000, 4500, 3000, 2000}, 400, 480);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "titanblocks", 1L, 1), new ItemStack[]{CustomItemList.TitanStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Nickel, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iridium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Osmium, 1)}, new int[]{10000, 4500, 3000, 2000}, 400, 480);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "titanblocks", 1L, 2), new ItemStack[]{CustomItemList.TitanStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Nickel, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iridium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Osmium, 1)}, new int[]{10000, 4500, 3000, 2000}, 400, 480);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "oberonblocks", 1L, 0), new ItemStack[]{CustomItemList.OberonStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iridium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Osmium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Naquadah, 1)}, new int[]{10000, 2000, 1000, 850}, 400, 480);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "oberonblocks", 1L, 1), new ItemStack[]{CustomItemList.OberonStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iridium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Osmium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Naquadah, 1)}, new int[]{10000, 2000, 1000, 850}, 400, 480);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "oberonblocks", 1L, 2), new ItemStack[]{CustomItemList.OberonStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iridium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Osmium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Naquadah, 1)}, new int[]{10000, 2000, 1000, 850}, 400, 480);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "mirandablocks", 1L, 0), new ItemStack[]{CustomItemList.MirandaStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Tin, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Tetrahedrite, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iridium, 1)}, new int[]{10000, 2500, 1500, 1000}, 400, 480);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "mirandablocks", 1L, 1), new ItemStack[]{CustomItemList.MirandaStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Tin, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Tetrahedrite, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iridium, 1)}, new int[]{10000, 2500, 1500, 1000}, 400, 480);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "mirandablocks", 1L, 2), new ItemStack[]{CustomItemList.MirandaStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Tin, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Tetrahedrite, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iridium, 1)}, new int[]{10000, 2500, 1500, 1000}, 400, 480);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "proteusblocks", 1L, 0), new ItemStack[]{CustomItemList.ProteusStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Copper, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Uraninite, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Adamantium, 1)}, new int[]{10000, 5000, 2500, 1000}, 400, 1024);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "proteusblocks", 1L, 1), new ItemStack[]{CustomItemList.ProteusStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Copper, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Uraninite, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Adamantium, 1)}, new int[]{10000, 5000, 2500, 1000}, 400, 1024);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "proteusblocks", 1L, 2), new ItemStack[]{CustomItemList.ProteusStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Copper, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Uraninite, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Adamantium, 1)}, new int[]{10000, 5000, 2500, 1000}, 400, 1024);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "tritonblocks", 1L, 0), new ItemStack[]{CustomItemList.TritonStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Gold, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Neodymium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.RareEarth, 1)}, new int[]{10000, 5000, 2500, 1000}, 400, 1024);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "tritonblocks", 1L, 1), new ItemStack[]{CustomItemList.TritonStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Gold, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Neodymium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.RareEarth, 1)}, new int[]{10000, 5000, 2500, 1000}, 400, 1024);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "tritonblocks", 1L, 2), new ItemStack[]{CustomItemList.TritonStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Gold, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Neodymium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.RareEarth, 1)}, new int[]{10000, 5000, 2500, 1000}, 400, 1024);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "plutoblocks", 1L, 0), new ItemStack[]{CustomItemList.PlutoIceDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Thorium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Uranium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Plutonium, 1)}, new int[]{10000, 5000, 2500, 1250}, 400, 1920);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "plutoblocks", 1L, 1), new ItemStack[]{CustomItemList.PlutoIceDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Thorium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Uranium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Plutonium, 1)}, new int[]{10000, 5000, 2500, 1250}, 400, 1920);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "plutoblocks", 1L, 2), new ItemStack[]{CustomItemList.PlutoIceDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Thorium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Uranium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Plutonium, 1)}, new int[]{10000, 5000, 2500, 1250}, 400, 1920);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "plutoblocks", 1L, 3), new ItemStack[]{CustomItemList.PlutoIceDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Thorium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Uranium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Plutonium, 1)}, new int[]{10000, 5000, 2500, 1250}, 400, 1920);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "plutoblocks", 1L, 4), new ItemStack[]{CustomItemList.PlutoIceDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Thorium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Uranium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Plutonium, 1)}, new int[]{10000, 5000, 2500, 1250}, 400, 1920);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "plutoblocks", 1L, 5), new ItemStack[]{CustomItemList.PlutoStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Uranium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Plutonium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.BlackPlutonium, 1)}, new int[]{10000, 5000, 2500, 850}, 400, 1920);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "makemakegrunt", 1L, 0), new ItemStack[]{CustomItemList.MakeMakeStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GarnetRed, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GarnetYellow, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.BlackPlutonium, 1)}, new int[]{10000, 2500, 2500, 1000}, 400, 1920);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "makemakegrunt", 1L, 1), new ItemStack[]{CustomItemList.MakeMakeStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GarnetRed, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GarnetYellow, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.BlackPlutonium, 1)}, new int[]{10000, 2500, 2500, 1000}, 400, 1920);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "haumeablocks", 1L, 0), new ItemStack[]{CustomItemList.HaumeaStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.InfusedGold, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Naquadah, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.NetherStar, 1)}, new int[]{10000, 5000, 2500, 850}, 400, 1920);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "acentauribbgrunt", 1L, 0), new ItemStack[]{CustomItemList.CentauriASurfaceDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iridium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.NaquadahEnriched, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Draconium, 1)}, new int[]{10000, 5000, 3000, 1000}, 400, 4096);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "acentauribbsubgrunt", 1L, 0), new ItemStack[]{CustomItemList.CentauriAStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Osmium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.NaquadahEnriched, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Neutronium, 1)}, new int[]{10000, 5000, 3000, 500}, 400, 4096);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "vegabsubgrunt", 1L, 0), new ItemStack[]{CustomItemList.VegaBStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Uranium235, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Plutonium241, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Europium, 1)}, new int[]{10000, 5000, 3000, 1500}, 400, 4096);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "vegabgrunt", 1L, 0), new ItemStack[]{CustomItemList.VegaBStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Uranium235, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Plutonium241, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Europium, 1)}, new int[]{10000, 5000, 3000, 1500}, 400, 4096);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "barnardaEgrunt", 1L, 0), new ItemStack[]{CustomItemList.BarnardaEStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Niobium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Yttrium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Gallium, 1)}, new int[]{10000, 2500, 2000, 1500}, 400, 4096);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "barnardaEsubgrunt", 1L, 0), new ItemStack[]{CustomItemList.BarnardaEStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Niobium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Yttrium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Gallium, 1)}, new int[]{10000, 2500, 2000, 1500}, 400, 4096);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "barnardaFgrunt", 1L, 0), new ItemStack[]{CustomItemList.BarnardaFStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Gallium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Yttrium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Niobium, 1)}, new int[]{10000, 2500, 2000, 1500}, 400, 4096);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "barnardaFsubgrunt", 1L, 0), new ItemStack[]{CustomItemList.BarnardaFStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Gallium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Yttrium, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Niobium, 1)}, new int[]{10000, 2500, 2000, 1500}, 400, 4096);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "tcetieblocks", 1L, 0), new ItemStack[]{CustomItemList.TCetiEStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Lapis, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Apatite, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Bedrockium, 1)}, new int[]{10000, 2500, 2000, 1500}, 400, 4096);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "tcetieblocks", 1L, 1), new ItemStack[]{CustomItemList.TCetiEStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Lapis, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Apatite, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Bedrockium, 1)}, new int[]{10000, 2500, 2000, 1500}, 400, 4096);
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "tcetieblocks", 1L, 2), new ItemStack[]{CustomItemList.TCetiEStoneDust.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Lapis, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Apatite, 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Bedrockium, 1)}, new int[]{10000, 2500, 2000, 1500}, 400, 4096);
        }

        GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("IC2", "itemFuelPlantBall", 2L, 0), new ItemStack[]{CustomItemList.MaceratedPlantmass.get(1L), CustomItemList.MaceratedPlantmass.get(1L), CustomItemList.MaceratedPlantmass.get(1L), CustomItemList.MaceratedPlantmass.get(1L)}, new int[]{10000, 10000, 5000, 2500}, 200, 30);
        GT_Values.RA.addPulveriserRecipe(new ItemStack(Items.flint, 2, 0), new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 1L)}, null, 800, 2);
        GT_Values.RA.addPulveriserRecipe(CustomItemList.CokeOvenBrick.get(1L), new ItemStack[]{CustomItemList.CokeOvenBrickDust.get(1L), CustomItemList.CokeOvenBrickDust.get(1L), CustomItemList.CokeOvenBrickDust.get(1L), CustomItemList.CokeOvenBrickDust.get(1L)}, new int[]{10000, 2500, 750, 500}, 200, 30);
        GT_Values.RA.addPulveriserRecipe(CustomItemList.AdvancedCokeOvenBrick.get(1L), new ItemStack[]{CustomItemList.AdvancedCokeOvenBrickDust.get(1L), CustomItemList.AdvancedCokeOvenBrickDust.get(1L), CustomItemList.AdvancedCokeOvenBrickDust.get(1L), CustomItemList.AdvancedCokeOvenBrickDust.get(1L)}, new int[]{10000, 2500, 750, 500}, 200, 120);

        GT_Values.RA.addWiremillRecipe(GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.MeteoricIron, 1L), CustomItemList.MeteoricIronString.get(4L), 600, 480);
        GT_Values.RA.addWiremillRecipe(GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Tungsten, 1L), CustomItemList.TungstenString.get(4L), 1200, 1024);

        if (Loader.isModLoaded("Natura"))
            GT_Values.RA.addWiremillRecipe(GT_ModHandler.getModItem("Natura", "barleyFood", 2L, 3), new ItemStack(Items.string, 1, 0), 200, 8);

        GT_Values.RA.addWiremillRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.NetherStar, 1L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.NetherStar, 1L), 100, 4);

        // Circuits and Boards
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32), GT_Utility.getIntegratedCircuit(6)}, FluidRegistry.getFluidStack("glue", 1152), ItemList.Circuit_Board_Coated_Basic.get(8L), 1600, 8);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32), GT_Utility.getIntegratedCircuit(6)}, Materials.Glue.getFluid(576L), ItemList.Circuit_Board_Coated_Basic.get(8L), 1600, 8);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32), GT_Utility.getIntegratedCircuit(6)}, Materials.Plastic.getMolten(288L), ItemList.Circuit_Board_Coated_Basic.get(16L), 1600, 8);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32), GT_Utility.getIntegratedCircuit(6)}, Materials.Polytetrafluoroethylene.getMolten(144L), ItemList.Circuit_Board_Coated_Basic.get(16L), 1600, 8);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32), GT_Utility.getIntegratedCircuit(6)}, Materials.Epoxid.getMolten(144L), ItemList.Circuit_Board_Coated_Basic.get(24L), 1600, 8);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32), GT_Utility.getIntegratedCircuit(6)}, Materials.Polybenzimidazole.getMolten(72L), ItemList.Circuit_Board_Coated_Basic.get(32L), 1600, 8);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 8), GT_Utility.getIntegratedCircuit(1)}, FluidRegistry.getFluidStack("glue", 576), ItemList.Circuit_Board_Phenolic.get(8L), 2400, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 8), GT_Utility.getIntegratedCircuit(1)}, Materials.Glue.getFluid(288), ItemList.Circuit_Board_Phenolic.get(8L), 2400, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 8), GT_Utility.getIntegratedCircuit(1)}, Materials.BisphenolA.getFluid(144), ItemList.Circuit_Board_Phenolic.get(16L), 2400, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 8), GT_Utility.getIntegratedCircuit(1)}, Materials.Epoxid.getMolten(144L), ItemList.Circuit_Board_Phenolic.get(24L), 2400, 30);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Phenolic.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 4), Materials.IronIIIChloride.getFluid(100L), GT_Values.NF, ItemList.Circuit_Board_Phenolic_Good.get(1L), 600, 30);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Phenolic.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 4), Materials.SodiumPersulfate.getFluid(200), GT_Values.NF, ItemList.Circuit_Board_Phenolic_Good.get(1L), 600, 30);

        GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 1), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 4), Materials.SulfuricAcid.getFluid(500L), GT_Values.NF, ItemList.Circuit_Board_Plastic.get(1L), 500, 10);
        GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.PolyvinylChloride, 1), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 4), Materials.SulfuricAcid.getFluid(500L), GT_Values.NF, ItemList.Circuit_Board_Plastic.get(2L), 500, 10);
        GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Polytetrafluoroethylene, 1), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 4), Materials.SulfuricAcid.getFluid(500L), GT_Values.NF, ItemList.Circuit_Board_Plastic.get(4L), 500, 10);
        GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Polybenzimidazole, 1), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 4), Materials.SulfuricAcid.getFluid(500L), GT_Values.NF, ItemList.Circuit_Board_Plastic.get(8L), 500, 10);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Plastic.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 6), Materials.IronIIIChloride.getFluid(250L), GT_Values.NF, ItemList.Circuit_Board_Plastic_Advanced.get(1L), 800, 30);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Plastic.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 6), Materials.SodiumPersulfate.getFluid(500), GT_Values.NF, ItemList.Circuit_Board_Plastic_Advanced.get(1L), 800, 30);

        GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Epoxid, 1), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 8), Materials.SulfuricAcid.getFluid(500L), GT_Values.NF, ItemList.Circuit_Board_Epoxy.get(1L), 600, 30);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Epoxy.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8), Materials.IronIIIChloride.getFluid(500L), GT_Values.NF, ItemList.Circuit_Board_Epoxy_Advanced.get(1L), 1200, 30);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Epoxy.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8), Materials.SodiumPersulfate.getFluid(1000L), GT_Values.NF, ItemList.Circuit_Board_Epoxy_Advanced.get(1L), 1200, 30);

        GT_Values.RA.addChemicalBathRecipe(ItemList.Circuit_Parts_GlassFiber.get(1L), Materials.Epoxid.getMolten(144L), Materials.EpoxidFiberReinforced.getPlates(1), GT_Values.NI, GT_Values.NI, new int[]{10000}, 240, 16);
        GT_Values.RA.addChemicalBathRecipe(GT_ModHandler.getIC2Item("carbonFiber", 1), Materials.Epoxid.getMolten(144L), Materials.EpoxidFiberReinforced.getPlates(1), GT_Values.NI, GT_Values.NI, new int[]{10000}, 240, 16);
        GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EpoxidFiberReinforced, 1), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 12), Materials.SulfuricAcid.getFluid(500L), GT_Values.NF, ItemList.Circuit_Board_Fiberglass.get(1L), 500, 10);

        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Fiberglass.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.AnnealedCopper, 12), Materials.IronIIIChloride.getFluid(1000L), GT_Values.NF, ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_Values.NI, 1800, 30, true);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Fiberglass.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.AnnealedCopper, 12), Materials.SodiumPersulfate.getFluid(2000L), GT_Values.NF, ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_Values.NI, 1800, 30, true);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Fiberglass.get(2L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Platinum, 16), Materials.SulfuricAcid.getFluid(500L), null, ItemList.Circuit_Board_Multifiberglass.get(1L), GT_Values.NI, 600, 480, true);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Multifiberglass.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Platinum, 16), Materials.IronIIIChloride.getFluid(2000L), GT_Values.NF, ItemList.Circuit_Board_Multifiberglass_Elite.get(1L), GT_Values.NI, 2400, 120, true);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Wetware.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 32), Materials.IronIIIChloride.getFluid(5000L), GT_Values.NF, ItemList.Circuit_Board_Wetware_Extreme.get(1L), GT_Values.NI, 3000, 480, true);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Multifiberglass.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Platinum, 16), Materials.SodiumPersulfate.getFluid(4000L), GT_Values.NF, ItemList.Circuit_Board_Multifiberglass_Elite.get(1L), GT_Values.NI, 2400, 120, true);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Wetware.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 32), Materials.SodiumPersulfate.getFluid(10000L), GT_Values.NF, ItemList.Circuit_Board_Wetware_Extreme.get(1L), GT_Values.NI, 3000, 480, true);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Bio.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Neutronium, 48), Materials.IronIIIChloride.getFluid(7500L), GT_Values.NF, ItemList.Circuit_Board_Bio_Ultra.get(1L), GT_Values.NI, 3600, 1920, true);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Board_Bio.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Neutronium, 48), Materials.SodiumPersulfate.getFluid(14000L), GT_Values.NF, ItemList.Circuit_Board_Bio_Ultra.get(1L), GT_Values.NI, 3600, 1920, true);

        if (Loader.isModLoaded("Genetics"))
            GT_Values.RA.addChemicalRecipe(new ItemStack(Items.spawn_egg, 1, GT_Values.W), GT_ModHandler.getModItem("Genetics", "misc", 64L, 4), FluidRegistry.getFluidStack("binnie.bacteria", 1000), GT_Values.NF, CustomItemList.TheBigEgg.get(1L), GT_Values.NI, 72000, 120, true);
        if (Loader.isModLoaded("gendustry"))
            GT_Values.RA.addChemicalRecipe(CustomItemList.TheBigEgg.get(1L), GT_ModHandler.getModItem("IC2", "itemUran238", 64L, 0), FluidRegistry.getFluidStack("mutagen", 1000), GT_Values.NF, CustomItemList.MutatedEgg.get(1L), GT_Values.NI, 72000, 256, true);
        GT_Values.RA.addChemicalRecipe(CustomItemList.MutatedEgg.get(1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HeeEndium, 64), FluidRegistry.getFluidStack("ender", 1000), GT_Values.NF, CustomItemList.EnderEgg.get(1L), GT_Values.NI, 72000, 480, true);
        if (Loader.isModLoaded("HardcoreEnderExpansion"))
            GT_Values.RA.addChemicalRecipe(CustomItemList.EnderEgg.get(1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 64), FluidRegistry.getFluidStack("endergoo", 1000), GT_Values.NF, CustomItemList.DraconiumEgg.get(1L), GT_Values.NI, 72000, 1024, true);
        if (Loader.isModLoaded("DraconicEvolution"))
            GT_Values.RA.addChemicalRecipe(CustomItemList.DraconiumEgg.get(1L), GT_ModHandler.getModItem("DraconicEvolution", "dragonHeart", 0L, 0), FluidRegistry.getFluidStack("molten.enderium", 1000), GT_Values.NF, new ItemStack(Blocks.dragon_egg, 1, 0), GT_Values.NI, 72000, 1920, true);
        if (Loader.isModLoaded("harvestcraft"))
            GT_Values.RA.addChemicalBathRecipe(GT_ModHandler.getModItem("harvestcraft", "wovencottonItem", 2L, 0), Materials.PolyvinylChloride.getMolten(144L), CustomItemList.ArtificialLeather.get(2L), GT_Values.NI, GT_Values.NI, new int[]{10000}, 300, 120);

        this.run3();
    }

    public void run3() {
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Parts_Glass_Tube.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 4), GT_Utility.getIntegratedCircuit(5)}, Materials.Redstone.getMolten(144L), ItemList.Circuit_Parts_Vacuum_Tube.get(2L), 160, 8);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Parts_Glass_Tube.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 4), GT_Utility.getIntegratedCircuit(5)}, Materials.RedAlloy.getMolten(72L), ItemList.Circuit_Parts_Vacuum_Tube.get(4L), 160, 8);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Parts_Glass_Tube.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 4), GT_Utility.getIntegratedCircuit(5)}, Materials.RedstoneAlloy.getMolten(72L), ItemList.Circuit_Parts_Vacuum_Tube.get(8L), 160, 8);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Parts_Glass_Tube.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 4), GT_Utility.getIntegratedCircuit(5)}, Materials.RedAlloy.getMolten(72L), ItemList.Circuit_Parts_Vacuum_Tube.get(8L), 160, 8);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Parts_Glass_Tube.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 4), GT_Utility.getIntegratedCircuit(5)}, Materials.RedstoneAlloy.getMolten(72L), ItemList.Circuit_Parts_Vacuum_Tube.get(16L), 160, 8);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4), GT_Utility.getIntegratedCircuit(3)}, Materials.Glue.getFluid(288), ItemList.Circuit_Parts_Resistor.get(4L), 320, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4), GT_Utility.getIntegratedCircuit(3)}, Materials.Glue.getFluid(288), ItemList.Circuit_Parts_Resistor.get(4L), 320, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4), GT_Utility.getIntegratedCircuit(3)}, Materials.Glue.getFluid(288), ItemList.Circuit_Parts_Resistor.get(4L), 320, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lignite, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4), GT_Utility.getIntegratedCircuit(3)}, Materials.Glue.getFluid(288), ItemList.Circuit_Parts_Resistor.get(4L), 320, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4), GT_Utility.getIntegratedCircuit(4)}, FluidRegistry.getFluidStack("glue", 576), ItemList.Circuit_Parts_Resistor.get(4L), 320, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4), GT_Utility.getIntegratedCircuit(4)}, FluidRegistry.getFluidStack("glue", 576), ItemList.Circuit_Parts_Resistor.get(4L), 320, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4), GT_Utility.getIntegratedCircuit(4)}, FluidRegistry.getFluidStack("glue", 576), ItemList.Circuit_Parts_Resistor.get(4L), 320, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lignite, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4), GT_Utility.getIntegratedCircuit(4)}, FluidRegistry.getFluidStack("glue", 576), ItemList.Circuit_Parts_Resistor.get(4L), 320, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4), GT_Utility.getIntegratedCircuit(4)}, Materials.Glue.getFluid(288), ItemList.Circuit_Parts_Resistor.get(8L), 320, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4), GT_Utility.getIntegratedCircuit(4)}, Materials.Glue.getFluid(288), ItemList.Circuit_Parts_Resistor.get(8L), 320, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4), GT_Utility.getIntegratedCircuit(4)}, Materials.Glue.getFluid(288), ItemList.Circuit_Parts_Resistor.get(8L), 320, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lignite, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4), GT_Utility.getIntegratedCircuit(4)}, Materials.Glue.getFluid(288), ItemList.Circuit_Parts_Resistor.get(8L), 320, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4), GT_Utility.getIntegratedCircuit(4)}, FluidRegistry.getFluidStack("glue", 576), ItemList.Circuit_Parts_Resistor.get(8L), 320, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4), GT_Utility.getIntegratedCircuit(4)}, FluidRegistry.getFluidStack("glue", 576), ItemList.Circuit_Parts_Resistor.get(8L), 320, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4), GT_Utility.getIntegratedCircuit(4)}, FluidRegistry.getFluidStack("glue", 576), ItemList.Circuit_Parts_Resistor.get(8L), 320, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lignite, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4), GT_Utility.getIntegratedCircuit(4)}, FluidRegistry.getFluidStack("glue", 576), ItemList.Circuit_Parts_Resistor.get(8L), 320, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 4), GT_Utility.getIntegratedCircuit(5)}, Materials.Plastic.getMolten(288L), ItemList.Circuit_Parts_ResistorSMD.get(16L), 320, 96);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphene, 4), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16), GT_Utility.getIntegratedCircuit(6)}, Materials.Polybenzimidazole.getMolten(1440L), ItemList.Circuit_Parts_ResistorASMD.get(64L), 640, 384);
        GT_Values.RA.addAlloySmelterRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1), ItemList.Shape_Mold_Ball.get(0), ItemList.Circuit_Parts_Glass_Tube.get(1L), 240, 16);
        GT_Values.RA.addAlloySmelterRecipe(new ItemStack(Blocks.obsidian, 1, 0), ItemList.Shape_Mold_Ingot.get(0L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Obsidian, 2L), 130, 3);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GalliumArsenide, 1), GT_Utility.getIntegratedCircuit(4)}, Materials.Plastic.getMolten(144L), ItemList.Circuit_Parts_Diode.get(4L), 600, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GalliumArsenide, 1), GT_Utility.getIntegratedCircuit(4)}, Materials.Glass.getMolten(288L), ItemList.Circuit_Parts_Diode.get(2L), 600, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GalliumArsenide, 1), GT_Utility.getIntegratedCircuit(4)}, FluidRegistry.getFluidStack("glass.molten", 1000), ItemList.Circuit_Parts_Diode.get(2L), 600, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4), ItemList.Circuit_Silicon_Wafer.get(1L), GT_Utility.getIntegratedCircuit(4)}, Materials.Plastic.getMolten(144L), ItemList.Circuit_Parts_Diode.get(2L), 600, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4), ItemList.Circuit_Silicon_Wafer.get(1L), GT_Utility.getIntegratedCircuit(4)}, FluidRegistry.getFluidStack("glass.molten", 1000), ItemList.Circuit_Parts_Diode.get(1L), 600, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4), ItemList.Circuit_Silicon_Wafer.get(1L), GT_Utility.getIntegratedCircuit(4)}, Materials.Glass.getMolten(288L), ItemList.Circuit_Parts_Diode.get(1L), 600, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GalliumArsenide, 1), GT_Utility.getIntegratedCircuit(4)}, Materials.Plastic.getMolten(144L), ItemList.Circuit_Parts_Diode.get(6L), 600, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4), ItemList.Circuit_Silicon_Wafer.get(1L), GT_Utility.getIntegratedCircuit(4)}, Materials.Plastic.getMolten(144L), ItemList.Circuit_Parts_Diode.get(4L), 600, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GalliumArsenide, 1),  GT_Utility.getIntegratedCircuit(3)}, Materials.Plastic.getMolten(576L), ItemList.Circuit_Parts_DiodeSMD.get(64L), 1200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IndiumGalliumPhosphide, 1), GT_Utility.getIntegratedCircuit(3)}, Materials.Polybenzimidazole.getMolten(288L), ItemList.Circuit_Parts_DiodeASMD.get(64L), 600, 480);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2), GT_Utility.getIntegratedCircuit(3)}, Materials.Plastic.getMolten(36L), ItemList.Circuit_Parts_Coil.get(2L), 320, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ring, Materials.NickelZincFerrite, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2), GT_Utility.getIntegratedCircuit(3)}, Materials.Plastic.getMolten(36L), ItemList.Circuit_Parts_Coil.get(4L), 320, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 2), GT_Utility.getIntegratedCircuit(3)}, Materials.Plastic.getMolten(36L), ItemList.Circuit_Parts_Coil.get(4L), 320, 60);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ring, Materials.NickelZincFerrite, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 2), GT_Utility.getIntegratedCircuit(3)}, Materials.Plastic.getMolten(36L), ItemList.Circuit_Parts_Coil.get(8L), 320, 60);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicon, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tin, 8), GT_Utility.getIntegratedCircuit(2)}, Materials.Plastic.getMolten(144L), ItemList.Circuit_Parts_Transistor.get(6L), 320, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gallium, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 8),  GT_Utility.getIntegratedCircuit(3)}, Materials.Plastic.getMolten(288L), ItemList.Circuit_Parts_TransistorSMD.get(16L), 320, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.foil, Materials.VanadiumGallium, 4), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.HSSG, 32),GT_Utility.getIntegratedCircuit(3)}, Materials.Polybenzimidazole.getMolten(576L), ItemList.Circuit_Parts_TransistorASMD.get(64L), 640, 480);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Plastic, 1), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 2), GT_Utility.getIntegratedCircuit(3)}, Materials.Plastic.getMolten(144L), ItemList.Circuit_Parts_Capacitor.get(8L), 320, 120);
        //SMD Capacitors
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicone, 2), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 2),  GT_Utility.getIntegratedCircuit(2)}, Materials.Plastic.getMolten(144L), ItemList.Circuit_Parts_CapacitorSMD.get(16L), 320, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.foil, Materials.PolyvinylChloride, 4), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 2), GT_Utility.getIntegratedCircuit(2)}, Materials.Plastic.getMolten(144L), ItemList.Circuit_Parts_CapacitorSMD.get(24L), 320, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicone, 2), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Tantalum, 2), GT_Utility.getIntegratedCircuit(2)}, Materials.Plastic.getMolten(144L), ItemList.Circuit_Parts_CapacitorSMD.get(32L), 320, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.foil, Materials.PolyvinylChloride, 4), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Tantalum, 2), GT_Utility.getIntegratedCircuit(2)}, Materials.Plastic.getMolten(144L), ItemList.Circuit_Parts_CapacitorSMD.get(48L), 320, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Polybenzimidazole, 16), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HSSS, 8), GT_Utility.getIntegratedCircuit(1)}, Materials.Polybenzimidazole.getMolten(288L), ItemList.Circuit_Parts_CapacitorASMD.get(64L), 640, 480);

        if (Loader.isModLoaded("JABBA")) {
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 0), 200, 16);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Copper, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 1), 200, 16);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 2), 200, 16);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Bronze, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 3), 200, 16);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 4), 200, 16);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 5), 200, 16);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 6), 200, 16);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 7), 200, 16);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 8), 200, 16);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Chrome, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 9), 200, 16);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iridium, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 10), 200, 16);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmium, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Osmium, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 11), 200, 16);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Neutronium, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 12), 200, 16);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("JABBA", "barrel", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.BlackPlutonium, 2)}, GT_Values.NF, GT_ModHandler.getModItem("JABBA", "upgradeStructural", 1L, 13), 200, 16);
        }
        GT_Values.RA.addExtruderRecipe(Materials.BorosilicateGlass.getIngots(1), ItemList.Shape_Extruder_Wire.get(0), ItemList.Circuit_Parts_GlassFiber.get(8L), 160, 96);
        GT_Values.RA.addWiremillRecipe(Materials.BorosilicateGlass.getIngots(1), ItemList.Circuit_Parts_GlassFiber.get(4L), 200, 120);

        GT_Values.RA.addLaserEngraverRecipe(ItemList.Circuit_Silicon_Wafer2.get(1L), GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderPearl, 1)), ItemList.Circuit_Wafer_NAND.get(1L), 900, 480, true);
        GT_Values.RA.addLaserEngraverRecipe(ItemList.Circuit_Silicon_Wafer3.get(1L), GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderPearl, 1)), ItemList.Circuit_Wafer_NAND.get(4L), 600, 1920, true);
        GT_Values.RA.addLaserEngraverRecipe(ItemList.Circuit_Silicon_Wafer4.get(1L), GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderPearl, 1)), ItemList.Circuit_Wafer_NAND.get(8L), 600, 7680, true);
        GT_Values.RA.addLaserEngraverRecipe(ItemList.Circuit_Silicon_Wafer5.get(1L), GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderPearl, 1)), ItemList.Circuit_Wafer_NAND.get(16L), 600, 30720, true);
        GT_Values.RA.addLaserEngraverRecipe(ItemList.Circuit_Silicon_Wafer2.get(1L), GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 1)), ItemList.Circuit_Wafer_NOR.get(1L), 900, 480, true);
        GT_Values.RA.addLaserEngraverRecipe(ItemList.Circuit_Silicon_Wafer3.get(1L), GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 1)), ItemList.Circuit_Wafer_NOR.get(4L), 600, 1920, true);
        GT_Values.RA.addLaserEngraverRecipe(ItemList.Circuit_Silicon_Wafer4.get(1L), GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 1)), ItemList.Circuit_Wafer_NOR.get(8L), 600, 7680, true);
        GT_Values.RA.addLaserEngraverRecipe(ItemList.Circuit_Silicon_Wafer5.get(1L), GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 1)), ItemList.Circuit_Wafer_NOR.get(16L), 600, 30720, true);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_ILC.get(1L), ItemList.Circuit_Chip_ILC.get(8L), GT_Values.NI, 900, 64);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_Ram.get(1L), ItemList.Circuit_Chip_Ram.get(32L), GT_Values.NI, 900, 96);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_NAND.get(1L), GT_Values.NI, ItemList.Circuit_Chip_NAND.get(32L), GT_Values.NI, 900, 192, true);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_NOR.get(1L), GT_Values.NI, ItemList.Circuit_Chip_NOR.get(16L), GT_Values.NI, 900, 192, true);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_CPU.get(1L), GT_Values.NI, ItemList.Circuit_Chip_CPU.get(8L), GT_Values.NI, 900, 120, true);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_Simple_SoC.get(1L), GT_Values.NI, ItemList.Circuit_Chip_Simple_SoC.get(6L), GT_Values.NI, 900, 64, false);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_SoC.get(1L), GT_Values.NI, ItemList.Circuit_Chip_SoC.get(6L), GT_Values.NI, 900, 480, true);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_SoC2.get(1L), GT_Values.NI, ItemList.Circuit_Chip_SoC2.get(6L), GT_Values.NI, 900, 1024, true);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_ULPIC.get(1L), GT_Values.NI, ItemList.Circuit_Chip_ULPIC.get(6L), GT_Values.NI, 900, 120, false);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_LPIC.get(1L), GT_Values.NI, ItemList.Circuit_Chip_LPIC.get(4L), GT_Values.NI, 900, 480, false);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_PIC.get(1L), GT_Values.NI, ItemList.Circuit_Chip_PIC.get(4L), GT_Values.NI, 900, 1920, true);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_HPIC.get(1L), GT_Values.NI, ItemList.Circuit_Chip_HPIC.get(2L), GT_Values.NI, 900, 7860, true);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_UHPIC.get(1L), GT_Values.NI, ItemList.Circuit_Chip_UHPIC.get(2L), GT_Values.NI, 900, 30720, true);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_NPIC.get(1L), GT_Values.NI, ItemList.Circuit_Chip_NPIC.get(2L), GT_Values.NI, 900, 122880, true);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_PPIC.get(1L), GT_Values.NI, ItemList.Circuit_Chip_PPIC.get(2L), GT_Values.NI, 900, 500000, true);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_QPIC.get(1L), GT_Values.NI, ItemList.Circuit_Chip_QPIC.get(2L), GT_Values.NI, 900, 2000000, true);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_NanoCPU.get(1L), GT_Values.NI, ItemList.Circuit_Chip_NanoCPU.get(8L), GT_Values.NI, 900, 480, true);
        GT_Values.RA.addCutterRecipe(ItemList.Circuit_Wafer_QuantumCPU.get(1L), GT_Values.NI, ItemList.Circuit_Chip_QuantumCPU.get(4L), GT_Values.NI, 900, 1920, true);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Wafer_PIC.get(1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IndiumGalliumPhosphide, 2), Materials.VanadiumGallium.getMolten(288L), GT_Values.NF, ItemList.Circuit_Wafer_HPIC.get(1L), GT_Values.NI, 1200, 7860, true);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Wafer_HPIC.get(1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IndiumGalliumPhosphide, 8), Materials.Naquadah.getMolten(576L), GT_Values.NF, ItemList.Circuit_Wafer_UHPIC.get(1L), GT_Values.NI, 1200, 30720, true);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Wafer_NPIC.get(1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IndiumGalliumPhosphide, 64), Materials.Sunnarium.getMolten(1440L), GT_Values.NF, ItemList.Circuit_Wafer_PPIC.get(1L), GT_Values.NI, 1200, 122880, true);

        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Wafer_CPU.get(1L), GT_Utility.copyAmount(16, Ic2Items.carbonFiber), Materials.Glowstone.getMolten(576L), GT_Values.NF, ItemList.Circuit_Wafer_NanoCPU.get(1L), GT_Values.NI, 1200, 1920, true);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Wafer_NanoCPU.get(1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IndiumGalliumPhosphide, 1), Materials.Radon.getGas(50L), GT_Values.NF, ItemList.Circuit_Wafer_QuantumCPU.get(1L), GT_Values.NI, 1200, 1920, true);
        GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Wafer_NanoCPU.get(1L), ItemList.QuantumEye.get(2L), Materials.GalliumArsenide.getMolten(288L), GT_Values.NF, ItemList.Circuit_Wafer_QuantumCPU.get(1L), GT_Values.NI, 900, 1920, true);

        GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem("IC2", "blockAlloyGlass", 1L, 0), CustomItemList.ReinforcedGlassPLate.get(2L), GT_Values.NI, 1200, 30);

        GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(Materials.Hydrogen.getCells(3)), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnetite, 0), Materials.Nitrogen.getGas(1000L), Materials.Ammonia.getGas(1000), ItemList.Cell_Empty.get(3L), 320, 384);

        //GT_Values.RA.addChemicalRecipe(ItemList.Circuit_Chip_Stemcell.get(4L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1), Materials.BioMediumRaw.getFluid(1000L), FluidRegistry.getFluidStack("mutagen", 250), ItemList.Circuit_Chip_Biocell.get(1L), 1200, 500000);

        GT_Values.RA.addAutoclaveSpaceRecipe(GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Emerald, 1), GT_Values.NI, Materials.Europium.getMolten(16), ItemList.Circuit_Parts_RawCrystalChip.get(1L), 1000, 12000, 320, true);
        GT_Values.RA.addAutoclaveSpaceRecipe(GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Olivine, 1), GT_Values.NI, Materials.Europium.getMolten(16), ItemList.Circuit_Parts_RawCrystalChip.get(1L), 1000, 12000, 320, true);

        GT_Values.RA.addForgeHammerRecipe(ItemList.Circuit_Parts_RawCrystalChip.get(1L), ItemList.Circuit_Parts_RawCrystalParts.get(9), 100, 480);
        if (Loader.isModLoaded("GalacticraftMars"))
            GT_Values.RA.addAutoclaveRecipe(ItemList.Circuit_Parts_RawCrystalParts.get(1L), FluidRegistry.getFluidStack("bacterialsludge", 250), ItemList.Circuit_Parts_RawCrystalChip.get(1L), 6000, 12000, 480);
        if (Loader.isModLoaded("gendustry"))
            GT_Values.RA.addAutoclaveRecipe(ItemList.Circuit_Parts_RawCrystalParts.get(1L), FluidRegistry.getFluidStack("mutagen", 250), ItemList.Circuit_Parts_RawCrystalChip.get(1L), 8000, 12000, 480);
        GT_Values.RA.addAutoclaveRecipe(ItemList.Circuit_Parts_RawCrystalParts.get(1L), Materials.Europium.getMolten(16), ItemList.Circuit_Parts_RawCrystalChip.get(1L), 10000, 12000, 480);

        GT_Values.RA.addAutoclaveSpaceRecipe(GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Emerald, 12), GT_Values.NI, Materials.UUMatter.getFluid(250L), ItemList.Tool_DataOrb.get(1L), 10000, 12000, 960, true);
        GT_Values.RA.addAutoclaveSpaceRecipe(GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Olivine, 12), GT_Values.NI, Materials.UUMatter.getFluid(250L), ItemList.Tool_DataOrb.get(1L), 10000, 12000, 960, true);
        //GT_ModHandler.addShapelessCraftingRecipe(ItemList.Circuit_Parts_RawCrystalChip.get(9), new Object[]{ItemList.Circuit_Chip_CrystalCPU.get(1L)});
        GT_Values.RA.addBlastRecipe(ItemList.Circuit_Parts_RawCrystalChip.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Emerald, 1), Materials.Helium.getGas(1000), GT_Values.NF, ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1L), GT_Values.NI, 900, 480, 5000);
        GT_Values.RA.addBlastRecipe(ItemList.Circuit_Parts_RawCrystalChip.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Olivine, 1), Materials.Helium.getGas(1000), GT_Values.NF, ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1L), GT_Values.NI, 900, 480, 5000);
        // GC/GS Wafer
        if (Loader.isModLoaded("GalacticraftCore")) {
            GT_Values.RA.addLaserEngraverRecipe(ItemList.Circuit_Silicon_Wafer.get(1L), CustomItemList.ReinforcedGlassLense.get(0), GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 13), 200, 256);
            GT_Values.RA.addLaserEngraverRecipe(ItemList.Circuit_Silicon_Wafer2.get(1L), CustomItemList.ReinforcedGlassLense.get(0), GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 14), 200, 480);
        }
        GT_Values.RA.addLaserEngraverRecipe(ItemList.Circuit_Silicon_Wafer3.get(1L), CustomItemList.ReinforcedGlassLense.get(0), CustomItemList.WaferTier3.get(1L), 200, 1024);

        //Field Generator
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 1), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),  GT_Utility.getIntegratedCircuit(1)}, Materials.RedSteel.getMolten(288), ItemList.Field_Generator_LV.get(1), 600, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 1), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),  GT_Utility.getIntegratedCircuit(1)}, Materials.TungstenSteel.getMolten(288), ItemList.Field_Generator_MV.get(1), 600, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.QuantumEye.get(1), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4),  GT_Utility.getIntegratedCircuit(1)}, Materials.NiobiumTitanium.getMolten(576), ItemList.Field_Generator_HV.get(1), 600, 480);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gem, Materials.NetherStar, 1), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4), GT_Utility.getIntegratedCircuit(13)}, Materials.HSSG.getMolten(576), ItemList.Field_Generator_EV.get(1), 600, 1920);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.QuantumStar.get(1L), ItemList.Circuit_Ultimate.get(4L), GT_Utility.getIntegratedCircuit(1)}, Materials.HSSS.getMolten(576), ItemList.Field_Generator_IV.get(1L), 600, 7680);

        //Motors
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.IronMagnetic, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.AnyIron, 2L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnyCopper, 4L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L)}, GT_Values.NF, ItemList.Electric_Motor_LV.get(1L), 200, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnyCopper, 4L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L)}, GT_Values.NF, ItemList.Electric_Motor_LV.get(1L), 200, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2L), GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Cupronickel, 4L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 2L)}, GT_Values.NF, ItemList.Electric_Motor_MV.get(1L), 200, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2L), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 4L), GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Silver, 2L)}, GT_Values.NF, ItemList.Electric_Motor_HV.get(1L), 200, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.NeodymiumMagnetic, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 2L), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.AnnealedCopper, 4L), GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Aluminium, 2L)}, GT_Values.NF, ItemList.Electric_Motor_EV.get(1L), 200, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.NeodymiumMagnetic, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 2L), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Graphene, 4L), GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Tungsten, 2L)}, GT_Values.NF, ItemList.Electric_Motor_IV.get(1L), 200, 30);

        //Pumps
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Tin, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Tin, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Bronze, 1)}, GT_Values.NF, ItemList.Electric_Pump_LV.get(1L), 20, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Tin, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Tin, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Bronze, 1)}, GT_Values.NF, ItemList.Electric_Pump_LV.get(1L), 20, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Tin, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Tin, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Bronze, 1)}, GT_Values.NF, ItemList.Electric_Pump_LV.get(1L), 20, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Bronze, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1)}, GT_Values.NF, ItemList.Electric_Pump_MV.get(1L), 20, 60);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Bronze, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1)}, GT_Values.NF, ItemList.Electric_Pump_MV.get(1L), 20, 60);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Bronze, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1)}, GT_Values.NF, ItemList.Electric_Pump_MV.get(1L), 20, 60);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Steel, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1)}, GT_Values.NF, ItemList.Electric_Pump_HV.get(1L), 20, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Steel, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1)}, GT_Values.NF, ItemList.Electric_Pump_HV.get(1L), 20, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Steel, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1)}, GT_Values.NF, ItemList.Electric_Pump_HV.get(1L), 20, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 1)}, GT_Values.NF, ItemList.Electric_Pump_EV.get(1L), 20, 240);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 1)}, GT_Values.NF, ItemList.Electric_Pump_EV.get(1L), 20, 240);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 1)}, GT_Values.NF, ItemList.Electric_Pump_EV.get(1L), 20, 240);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_IV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.TungstenSteel, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.TungstenSteel, 1)}, GT_Values.NF, ItemList.Electric_Pump_IV.get(1L), 20, 480);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_IV.get(1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.TungstenSteel, 1), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 1), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1), GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.TungstenSteel, 1)}, GT_Values.NF, ItemList.Electric_Pump_IV.get(1L), 20, 480);

        //Conveyors
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 6), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1)}, GT_Values.NF, ItemList.Conveyor_Module_LV.get(1L), 200, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1)}, GT_Values.NF, ItemList.Conveyor_Module_LV.get(1L), 200, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1)}, GT_Values.NF, ItemList.Conveyor_Module_LV.get(1L), 200, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 6), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 1)}, GT_Values.NF, ItemList.Conveyor_Module_MV.get(1L), 200, 60);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 1)}, GT_Values.NF, ItemList.Conveyor_Module_MV.get(1L), 200, 60);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 1)}, GT_Values.NF, ItemList.Conveyor_Module_MV.get(1L), 200, 60);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 6), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1)}, GT_Values.NF, ItemList.Conveyor_Module_HV.get(1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1)}, GT_Values.NF, ItemList.Conveyor_Module_HV.get(1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1)}, GT_Values.NF, ItemList.Conveyor_Module_HV.get(1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_EV.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1)}, GT_Values.NF, ItemList.Conveyor_Module_EV.get(1L), 200, 240);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_EV.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1)}, GT_Values.NF, ItemList.Conveyor_Module_EV.get(1L), 200, 240);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_IV.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1)}, GT_Values.NF, ItemList.Conveyor_Module_IV.get(1L), 200, 480);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_IV.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1)}, GT_Values.NF, ItemList.Conveyor_Module_IV.get(1L), 200, 480);

        //Pistons
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 3), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2), GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Steel, 1)}, GT_Values.NF, ItemList.Electric_Piston_LV.get(1L), 200, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 3), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 2), GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Aluminium, 1)}, GT_Values.NF, ItemList.Electric_Piston_MV.get(1L), 200, 60);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 3), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2), GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.StainlessSteel, 1)}, GT_Values.NF, ItemList.Electric_Piston_HV.get(1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 3), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 2), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 2), GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Titanium, 1)}, GT_Values.NF, ItemList.Electric_Piston_EV.get(1L), 200, 240);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_IV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 3), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 2), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 2), GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.TungstenSteel, 1)}, GT_Values.NF, ItemList.Electric_Piston_IV.get(1L), 200, 480);

        //Robot Arms
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(2L), ItemList.Electric_Piston_LV.get(1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 3)}, GT_Values.NF, ItemList.Robot_Arm_LV.get(1L), 200, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(2L), ItemList.Electric_Piston_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 3)}, GT_Values.NF, ItemList.Robot_Arm_MV.get(1L), 200, 60);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(2L), ItemList.Electric_Piston_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 3)}, GT_Values.NF, ItemList.Robot_Arm_HV.get(1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_EV.get(2L), ItemList.Electric_Piston_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 2), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 3)}, GT_Values.NF, ItemList.Robot_Arm_EV.get(1L), 200, 240);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_IV.get(2L), ItemList.Electric_Piston_IV.get(1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 2), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 3)}, GT_Values.NF, ItemList.Robot_Arm_IV.get(1L), 200, 480);

        //Emitter
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gem, Materials.CertusQuartz, 1), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Brass, 4), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 2L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2)}, GT_Values.NF, ItemList.Emitter_LV.get(1L), 200, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderPearl, 1), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Electrum, 4), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 2)}, GT_Values.NF, ItemList.Emitter_MV.get(1L), 200, 60);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderEye, 1), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Chrome, 4), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2)}, GT_Values.NF, ItemList.Emitter_HV.get(1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.QuantumEye.get(1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Platinum, 4), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 2)}, GT_Values.NF, ItemList.Emitter_EV.get(1L), 200, 240);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.QuantumStar.get(1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iridium, 4), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 2L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 2)}, GT_Values.NF, ItemList.Emitter_IV.get(1L), 200, 480);

        //Sensor
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gem, Materials.CertusQuartz, 1), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Brass, 1), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L),}, GT_Values.NF, ItemList.Sensor_LV.get(1L), 200, 30);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gemFlawless, Materials.Emerald, 1), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Electrum, 1), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L),}, GT_Values.NF, ItemList.Sensor_MV.get(1L), 200, 60);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderEye, 1), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Chrome, 1), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L),}, GT_Values.NF, ItemList.Sensor_HV.get(1L), 200, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.QuantumEye.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Platinum, 1), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1L),}, GT_Values.NF, ItemList.Sensor_EV.get(1L), 200, 240);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.QuantumStar.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 4), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iridium, 1), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L),}, GT_Values.NF, ItemList.Sensor_IV.get(1L), 200, 480);

        GT_Values.RA.addSifterRecipe(GT_OreDictUnificator.get(OrePrefixes.crushedPurified, Materials.Cinnabar, 1L), new ItemStack[]{Materials.Mercury.getGems(1), Materials.Mercury.getGems(1), Materials.Mercury.getGems(1), Materials.Mercury.getGems(1), Materials.Mercury.getGems(1), Materials.Mercury.getGems(1), Materials.Mercury.getGems(1), Materials.Mercury.getGems(1), Materials.Cinnabar.getDust(1)}, new int[]{100, 300, 500, 1000, 1000, 1500, 2300, 2500, 3500}, 7200, 30);

        if (Loader.isModLoaded("thaumicbases"))
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("thaumicbases", "resource", 1L, 7), new ItemStack[]{GT_ModHandler.getModItem("thaumicbases", "tobaccoPowder", 1L, 0)}, new int[]{10000}, 10, 2);

        // --- Stargates
        if (Loader.isModLoaded("GalaxySpace") && Loader.isModLoaded("SGCraft"))
            for (int i = 0; i < 6; ++i)
                GT_Values.RA.addExtractorRecipe(GT_ModHandler.getModItem("GalaxySpace", "tcetiedandelions", 64L, i), com.dreammaster.item.ItemList.TCetiESeaweedExtract.getIS(), 3600, 262144);
        GT_Values.RA.addMixerRecipe(com.dreammaster.item.ItemList.TCetiESeaweedExtract.getIS().splitStack(64), Materials.Dolomite.getDust(64), Materials.SamariumMagnetic.getDust(21), Materials.ChromiumDioxide.getDust(64), GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Jasper, 54L), GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Opal, 47L), GT_Values.NF, GT_Values.NF, com.dreammaster.item.ItemList.StargateCrystalDust.getIS(), 3600, 262144);
        if (Loader.isModLoaded("SGCraft"))
            GT_Values.RA.addAutoclaveSpaceRecipe(com.dreammaster.item.ItemList.StargateCrystalDust.getIS().splitStack(64), GT_Values.NI, Materials.Silver.getPlasma(8000L), GT_ModHandler.getModItem("SGCraft", "sgCoreCrystal", 1L), 10000, 3600, 131000, true);

        /*Stuff from CoreMod minetweaker script
         * AlloySmelter
         */
        GT_Values.RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("IC2", "itemPartIridium", 2L), ItemList.Shape_Mold_Casing.get(0), com.dreammaster.item.ItemList.IridiumAlloyItemCasing.getIS().splitStack(3), 1200, 256);

        for (int i = 0; i < OreDictionary.getOres("cropCotton").size(); ++i)
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Items.string, 4), OreDictionary.getOres("cropCotton").get(i).splitStack(3)}, GT_Values.NF, GT_ModHandler.getModItem("harvestcraft", "wovencottonItem", 1L, 0), 400, 30, false);

        /*GT_Values.RA.addAssemblerRecipe(new ItemStack[] {new ItemStack(Blocks.cobblestone),GT_OreDictUnificator.get(OrePrefixes.gearGtSmall,Materials.AnyIron,1L)}, Materials.Redstone.getMolten(72L), com.dreammaster.block.BlockList.PistonBlock.getIS(), 100, 30, false);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[] {new ItemStack(Blocks.fence),ItemList.Plank_Oak.get(1L)}, Materials.Redstone.getMolten(72L), com.dreammaster.item.ItemList.PistonPlate.getIS(), 100, 30, false);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[] {GT_ModHandler.getModItem("Natura","Natura.fence",1L),ItemList.Plank_Oak.get(1L)}, Materials.Redstone.getMolten(72L), com.dreammaster.item.ItemList.PistonPlate.getIS(), 100, 30, false);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[] {GT_ModHandler.getModItem("Forestry","fences",1L),ItemList.Plank_Oak.get(1L)}, Materials.Redstone.getMolten(72L), com.dreammaster.item.ItemList.PistonPlate.getIS(), 100, 30, false);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[] {GT_ModHandler.getModItem("ExtraTrees","fence",1L),ItemList.Plank_Oak.get(1L)}, Materials.Redstone.getMolten(72L), com.dreammaster.item.ItemList.PistonPlate.getIS(), 100, 30, false);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[] {GT_ModHandler.getModItem("Forestry","fencesFireproof",1L),ItemList.Plank_Oak.get(1L)}, Materials.Redstone.getMolten(72L), com.dreammaster.item.ItemList.PistonPlate.getIS(), 100, 30, false);
        */
        //recipes for everything that uses sand
        for (int i = 0; i < OreDictionary.getOres("sand").size(); ++i) {
            GT_Values.RA.addPulveriserRecipe(OreDictionary.getOres("sand").get(i), new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L)}, new int[]{10000, 2500, 2000, 1500}, 200, 8);
            GT_Values.RA.addAlloySmelterRecipe(OreDictionary.getOres("sand").get(i), new ItemStack(Items.clay_ball), com.dreammaster.item.ItemList.CokeOvenBrick.getIS().splitStack(2), 200, 8);
        }

        GT_Values.RA.addChemicalRecipe(new ItemStack(Items.ghast_tear), GT_Utility.getIntegratedCircuit(1), Materials.Water.getFluid(1000L), Materials.SaltWater.getFluid(1000L), Materials.Potassium.getDustTiny(1), Materials.Lithium.getDustTiny(1), 400, 30, false);
        GT_Values.RA.addChemicalRecipe(new ItemStack(Items.ghast_tear, 9, 0), GT_Utility.getIntegratedCircuit(9), Materials.Water.getFluid(9000L), Materials.SaltWater.getFluid(9000L), Materials.Potassium.getDust(1), Materials.Lithium.getDust(1), 3600, 30, false);
        GT_Values.RA.addChemicalBathRecipe(GT_ModHandler.getModItem("IC2", "itemBiochaff", 1L, 0), Materials.Water.getFluid(750L), GT_ModHandler.getModItem("Forestry", "mulch", 8L, 0), GT_ModHandler.getModItem("Forestry", "mulch", 4L, 0), GT_ModHandler.getModItem("Forestry", "mulch", 4L, 0), new int[]{10000, 3300, 2000}, 500, 30);

        //EnderIO Fused Quartz and Glass
        if (Loader.isModLoaded("EnderIO")) {
            GT_Values.RA.addAlloySmelterRecipe(Materials.CertusQuartz.getDust(2), Materials.Glass.getDust(1), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L), 500, 30);
            GT_Values.RA.addAlloySmelterRecipe(Materials.NetherQuartz.getDust(2), Materials.Glass.getDust(1), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L), 500, 30);
            GT_Values.RA.addAlloySmelterRecipe(Materials.CertusQuartz.getDust(2), Materials.Quartzite.getDust(2), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L), 500, 30);
            GT_Values.RA.addAlloySmelterRecipe(Materials.NetherQuartz.getDust(2), Materials.Quartzite.getDust(2), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L), 500, 30);
            GT_Values.RA.addAlloySmelterRecipe(Materials.CertusQuartz.getDust(1), Materials.BorosilicateGlass.getDust(1), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L), 500, 90);
            GT_Values.RA.addAlloySmelterRecipe(Materials.NetherQuartz.getDust(1), Materials.BorosilicateGlass.getDust(1), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L), 500, 90);

            GT_Values.RA.addAlloySmelterRecipe(Materials.Glass.getDust(3), GT_Utility.getIntegratedCircuit(1), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L, 1), 500, 30);
            GT_Values.RA.addAlloySmelterRecipe(Materials.Quartzite.getDust(4), GT_Utility.getIntegratedCircuit(1), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L, 1), 500, 30);
            GT_Values.RA.addAlloySmelterRecipe(Materials.BorosilicateGlass.getDust(1), GT_Utility.getIntegratedCircuit(1), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 2L, 1), 500, 90);

            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L), Materials.Glowstone.getDust(4), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L, 2), 500, 30);
            GT_Values.RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L, 1), Materials.Glowstone.getDust(4), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L, 3), 500, 30);
            GT_Values.RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L, 1), new ItemStack(Blocks.glowstone), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L, 3), 500, 30);

            GT_Values.RA.addBlastRecipe(Materials.CertusQuartz.getDust(2), Materials.Glass.getDust(1), GT_Values.NF, GT_Values.NF, GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L), GT_Values.NI, 100, 120, 1000);
            GT_Values.RA.addBlastRecipe(Materials.NetherQuartz.getDust(2), Materials.Glass.getDust(1), GT_Values.NF, GT_Values.NF, GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L), GT_Values.NI, 100, 120, 1000);
            GT_Values.RA.addBlastRecipe(Materials.CertusQuartz.getDust(2), Materials.Quartzite.getDust(2), GT_Values.NF, GT_Values.NF, GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L), GT_Values.NI, 100, 120, 1000);
            GT_Values.RA.addBlastRecipe(Materials.NetherQuartz.getDust(2), Materials.Quartzite.getDust(2), GT_Values.NF, GT_Values.NF, GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L), GT_Values.NI, 100, 120, 1000);
            GT_Values.RA.addBlastRecipe(Materials.CertusQuartz.getDust(1), Materials.BorosilicateGlass.getDust(1), GT_Values.NF, GT_Values.NF, GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L), GT_Values.NI, 200, 120, 1000);
            GT_Values.RA.addBlastRecipe(Materials.NetherQuartz.getDust(1), Materials.BorosilicateGlass.getDust(1), GT_Values.NF, GT_Values.NF, GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L), GT_Values.NI, 200, 120, 1000);

            for (int i = 0; i < OreDictionary.getOres("dyeBlack").size(); i++) {
                GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L), OreDictionary.getOres("dyeBlack").get(i).splitStack(4), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L, 4), 500, 30);
                GT_Values.RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L, 1), OreDictionary.getOres("dyeBlack").get(i).splitStack(4), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L, 5), 500, 30);
            }

            GT_Values.RA.addChemicalBathRecipe(GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeblack"), 72), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L, 4), GT_Values.NI, GT_Values.NI, new int[]{10000}, 500, 30);
            GT_Values.RA.addChemicalBathRecipe(GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L, 1), new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeblack"), 72), GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L, 5), GT_Values.NI, GT_Values.NI, new int[]{10000}, 500, 30);
        }

        GT_Values.RA.addLaserEngraverRecipe(ItemList.Circuit_Wafer_SoC2.get(1L), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.NetherStar, 1L).copy().splitStack(0), com.dreammaster.item.ItemList.RawPicoWafer.getIS(), 6000, (int) (GT_Values.V[8] - (GT_Values.V[8] / 10)), true);
        GT_Values.RA.addMultiblockChemicalRecipe(new ItemStack[]{com.dreammaster.item.ItemList.RawPicoWafer.getIS(), Materials.MysteriousCrystal.getDust(2), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.InfinityCatalyst, 1L).copy().splitStack(0), com.dreammaster.item.ItemList.TCetiESeaweedExtract.getIS(1)}, new FluidStack[]{Materials.Neutronium.getMolten(144L)}, new FluidStack[]{GT_Values.NF}, new ItemStack[]{com.dreammaster.item.ItemList.PicoWafer.getIS()}, 3000, (int) (GT_Values.V[9] - (GT_Values.V[9] / 10)));

        if (Loader.isModLoaded("OpenComputers")) {
            //cable
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.RedstoneAlloy, 1), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "cable", 1L, 0), 200, 120);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Emerald, 1), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "cable", 1L, 0), 200, 120);
            //keyboard
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Blocks.stone_button, 64), new ItemStack(Blocks.stone_button, 40), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L)}, GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "keyboard", 1L, 0), 200, 64);
            //case 1
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Aluminium, 2), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "case1", 1, 0), 200, 120);
            //case 2
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2), ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Aluminium, 2), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "case2", 1, 0), 200, 256);
            //case 3
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 2), ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Aluminium, 2), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "case3", 1, 0), 200, 480);
            //micro case 1
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 82), 200, 120);
            //mirco case 2
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_HV.get(1L), ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 86), 200, 256);
            //drone case 1
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 82), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 71), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Aluminium, 4L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L), ItemList.Electric_Motor_HV.get(4L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "item", 1, 83), 300, 256);
            //drone case 2
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 86), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 72), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Titanium, 4L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 1L), ItemList.Electric_Motor_EV.get(4L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "item", 1, 87), 300, 480);
            //Card
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 1), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 1), GT_Utility.getIntegratedCircuit(2)}, GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), 200, 64);
            //floppy
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 19), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Plastic, 4), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "item", 1L, 4), 200, 64);

            //floppys w NBT
            make_floppy("OpenOS (Operating System)", "openos", 2, 1);
            make_floppy("Plan9k (Operating System)", "plan9k", 1, 2);
            make_floppy("Network (Network Stack)", "network", 10, 3);
            make_floppy("Data Card Software", "data", 9, 4);
            make_floppy("OpenLoader (Boot Loader)", "openloader", 13, 5);
            make_floppy("Builder", "builder", 11, 6);
            make_floppy("Generator", "generator", 5, 7);
            make_floppy("OPPM (Package Manager)", "oppm", 6, 8);
            make_floppy("Digger", "dig", 3, 9);
            make_floppy("Mazer", "maze", 14, 10);
            make_floppy("OpenIRC (IRC Client)", "irc", 12, 11);

            //HDD 1
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 19), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 1), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "item", 1L, 5), 300, 120);
            //HDD 2
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 19), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 2), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "item", 1L, 6), 300, 256);
            //HDD 3
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L), GT_ModHandler.getModItem("OpenComputers", "item", 8L, 19), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 38), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "item", 1L, 7), 300, 480);
            //disk
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Glass, 1), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 4), GT_Utility.getIntegratedCircuit(1)}, Materials.Cobalt.getMolten(36L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 19), 200, 120);
            //rack
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "relay", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "powerDistributor", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13), ItemList.Circuit_Board_Plastic_Advanced.get(2L), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Aluminium, 4L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 4L), CustomItemList.SteelBars.get(2L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "rack", 1L, 0), 200, 256);
            //adapter block
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_LV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "adapter", 1L, 0), 200, 120);
            //assembler
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2), ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), ItemList.Robot_Arm_LV.get(3L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "assembler", 1L, 0), 200, 256);
            //disassembler
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_HV.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), ItemList.Robot_Arm_HV.get(2L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "disassembler", 1L, 0), 200, 256);
            //capacitor
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_LV.get(2L), GT_ModHandler.getModItem("IC2", "blockElectric", 1L, 7), ItemList.Circuit_Board_Plastic_Advanced.get(2L), ItemList.Circuit_Parts_Transistor.get(1L), GT_ModHandler.getModItem("OpenComputers", "cable", 2), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0), 200, 120);
            //charger
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_HV.get(1L), GT_ModHandler.getModItem("IC2", "blockChargepad", 2L, 2), ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_ModHandler.getModItem("OpenComputers", "cable", 2), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "charger", 1L, 0), 200, 256);
            //diskDrive
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_LV.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 3L, 25), ItemList.Electric_Motor_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.springSmall, Materials.Copper, 1), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.IronMagnetic, 1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Glass, 1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "diskDrive", 1L, 0), 200, 120);
            //diskDriver
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "diskDrive", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), ItemList.Circuit_Board_Epoxy_Advanced.get(1L), CustomItemList.SteelBars.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 4), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 109), 200, 480);
            //geolyzer
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), ItemList.Sensor_MV.get(2L), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 2), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "geolyzer", 1L, 0), 200, 120);
            //hologram1
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(2L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 2), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 2), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1), GT_Utility.getIntegratedCircuit(10)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "hologram1", 1L, 0), 200, 120);
            //hologram2
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(2L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 2), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 4), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Emerald, 1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Ruby, 1), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Sapphire, 1), GT_Utility.getIntegratedCircuit(10)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "hologram2", 1L, 0), 200, 256);
            //motionSensor
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 42), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 2), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), new ItemStack(Blocks.daylight_detector, 2, 0), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "motionSensor", 1L, 0), 200, 120);
            //netSplitter
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_LV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 4), GT_ModHandler.getModItem("OpenComputers", "cable", 3L, 0), ItemList.Electric_Piston_LV.get(1L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "netSplitter", 1L, 0), 200, 64);
            //printer
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Machine_HV_Printer.get(1L), ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 4), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "printer", 1L, 0), 200, 256);
            //powerConverter
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Transformer_HV_MV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(2L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "powerConverter", 1L, 0), 200, 256);
            //powerDistributor
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L), GT_ModHandler.getModItem("IC2", "blockElectric", 1L, 7), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "powerDistributor", 1L, 0), 200, 256);
            //raid
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "diskDrive", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 43), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 4), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "raid", 1L, 0), 200, 256);
            //redstone
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(2L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Redstone, 2), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 66), ItemList.Cover_ActivityDetector.get(1L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "redstone", 1L, 0), 200, 120);
            //relay
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 2), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "relay", 1L, 0), 200, 120);
            //transposer
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Automation_ChestBuffer_LV.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 61), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 77), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 2), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "transposer", 2L, 0), 400, 120);
            //waypoint
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 48), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), ItemList.Circuit_Parts_Transistor.get(2L), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "waypoint", 1L, 0), 200, 64);
            //cartridge empty
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), ItemList.Circuit_Parts_Transistor.get(2L), GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Plastic, 8), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(36L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 94), 200, 64);
            //cartridge full
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 94), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32414), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32420), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32425), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32427)}, Materials.Water.getFluid(1000L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 95), 200, 64);
            //Interweb
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 1), new ItemStack(Items.string, 8, 0), GT_Utility.getIntegratedCircuit(2)}, Materials.Glue.getFluid(576L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 48), 200, 64);
            //Linked Card
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 2L, 13), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 28), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 48), GT_Utility.getIntegratedCircuit(1)}, Materials.EnderEye.getMolten(288L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 51), 400, 480);
            //Manual
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Items.book, 1, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_Utility.getIntegratedCircuit(1)}, Materials.Glue.getFluid(144L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 98), 100, 30);
            //Nano Machine
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 2), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 42), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 18), GT_ModHandler.getModItem("OpenComputers", "item", 9L, 96)}, Materials.Plastic.getMolten(144L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 107), 400, 256);
            //Server Tier 1
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "case1", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 3), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(144L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 45), 400, 256);
            //Server Tier 2
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "case2", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 38), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(144L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 46), 400, 480);
            //Server Tier 3
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "case3", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 39), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(144L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 40), 400, 1024);
            //Tablet Case Tier 1
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 70), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 4L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 74), 400, 120);
            //Tablet Case Tier 2
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0), ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 72), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 4L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 92), 400, 256);
            //remote Monitor
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 34), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_ModHandler.getModItem("OpenComputers", "keyboard", 1L, 0), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(144L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 41), 400, 120);
            //Terminal Server
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 3L, 13), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 4L), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 108), 400, 480);
            //Block of Chamelium
            GT_Values.RA.addCompressorRecipe(GT_ModHandler.getModItem("OpenComputers", "item", 9L, 96), GT_ModHandler.getModItem("OpenComputers", "chameliumBlock", 1L, 0), 300, 2);
            //Chamelium
            GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 4L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 4L), GT_Values.NI, GT_Values.NI, GT_Utility.getIntegratedCircuit(2), Materials.Water.getFluid(1000L), GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "item", 9L, 96), 200, 120);
            //Open Printers
            //Printer
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Machine_MV_Printer.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("openprinter", "openprinter.printer", 1L, 0), 300, 120);
            //Shredder
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Machine_MV_Macerator.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("openprinter", "openprinter.shredder", 1L, 0), 300, 120);
            //Paper shreds
            GT_Values.RA.addPulveriserRecipe(GT_ModHandler.getModItem("openprinter", "openprinter.paperShreds", 1L, 0), new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Paper, 1L)}, new int[]{10000}, 20, 2);
            //Paper Roll
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Items.paper, 64, 0), new ItemStack(Items.paper, 64, 0), new ItemStack(Items.paper, 64, 0), new ItemStack(Items.paper, 64, 0), GT_Utility.getIntegratedCircuit(3)}, GT_Values.NF, GT_ModHandler.getModItem("openprinter", "openprinter.printerPaperRoll", 1L, 0), 200, 64);
            //Black Ink Cartridge
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 94), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32414), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32414), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32414), GT_Utility.getIntegratedCircuit(2)}, Materials.Water.getFluid(1000L), GT_ModHandler.getModItem("openprinter", "openprinter.printerInkBlack", 1L, GT_Values.W), 300, 120);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("openprinter", "openprinter.printerInkBlack", 1L, GT_Values.W), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32414), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32414), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32414), GT_Utility.getIntegratedCircuit(2)}, Materials.Water.getFluid(1000L), GT_ModHandler.getModItem("openprinter", "openprinter.printerInkBlack", 1L, GT_Values.W), 150, 120);
            //Color Ink Cartridge
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 94), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32415), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32416), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32418), GT_Utility.getIntegratedCircuit(2)}, Materials.Water.getFluid(1000L), GT_ModHandler.getModItem("openprinter", "openprinter.printerInkColor", 1L, GT_Values.W), 300, 120);
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("openprinter", "openprinter.printerInkColor", 1L, GT_Values.W), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32415), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32416), GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32418), GT_Utility.getIntegratedCircuit(2)}, Materials.Water.getFluid(1000L), GT_ModHandler.getModItem("openprinter", "openprinter.printerInkColor", 1L, GT_Values.W), 150, 120);
            //Open Security
            //Magnetic Card Reader
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), ItemList.Circuit_Parts_Transistor.get(2L), GT_Utility.getIntegratedCircuit(2)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "magreader", 1L, 0), 300, 256);
            //RFID Reader
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("opensecurity", "opensecurity.rfidReaderCard", 1L, 0), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_Utility.getIntegratedCircuit(2)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "rfidreader", 1L, 0), 300, 120);
            //Card writer
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), ItemList.Circuit_Parts_Transistor.get(2L)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "rfidwriter", 1L, 0), 300, 120);
            //Alarm
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Blocks.noteblock, 1, 0), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "alarm", 1L, 0), 300, 120);
            //Entity Detector
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "entitydetector", 1L, 0), 300, 120);
            //Door Controler
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), ItemList.Circuit_Parts_Transistor.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 4L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "doorcontroller", 1L, 0), 300, 120);
            //Data Block
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 104), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_ModHandler.getModItem("OpenComputers", "cable", 1L, 0), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "opensecurity.DataBlock", 1L, 0), 300, 120);
            //swtichable Hub
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "relay", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "cable", 4L, 0), ItemList.Circuit_Parts_Transistor.get(2L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "opensecurity.SwitchableHub", 1L, 0), 300, 120);
            //kvm Hub
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "relay", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "cable", 4L, 0), ItemList.Circuit_Parts_Transistor.get(2L), GT_Utility.getIntegratedCircuit(2)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "opensecurity.BlockKVM", 1L, 0), 300, 120);
            //energy turret
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("openmodularturrets", "laserTurret", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 25), GT_ModHandler.getModItem("OpenComputers", "cable", 4L, 0), ItemList.Circuit_Parts_Transistor.get(2L), GT_Utility.getIntegratedCircuit(2)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "energyTurretBlock", 1L, 0), 300, 120);
            //keypad
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "keyboard", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), ItemList.Circuit_Parts_Transistor.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L), GT_Utility.getIntegratedCircuit(2)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "keypadLock", 1L, 0), 300, 120);
            //biometric reader
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Glass, 4L), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), ItemList.Circuit_Parts_Transistor.get(2L), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "biometricScanner", 1L, 0), 300, 120);
            //magnetic stipe card
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Paper, 4L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IronMagnetic, 2L), ItemList.Circuit_Parts_Transistor.get(1L), GT_Utility.getIntegratedCircuit(1)}, Materials.Glue.getMolten(144L), GT_ModHandler.getModItem("opensecurity", "opensecurity.magCard", 2L, 0), 150, 64);
            //RFID Card
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Paper, 4L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IronMagnetic, 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), ItemList.Circuit_Parts_Transistor.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Glue.getMolten(144L), GT_ModHandler.getModItem("opensecurity", "opensecurity.rfidCard", 2L, 0), 150, 64);
            //RFID Reader Card
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), GT_Utility.getIntegratedCircuit(2)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "opensecurity.rfidReaderCard", 1L, 0), 300, 120);
            //Secure Network Card
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 11), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "opensecurity.secureNetworkCard", 1L, 0), 300, 256);
            //Secure Door
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Items.iron_door, 1), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), ItemList.Circuit_Parts_Transistor.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 4L), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, GT_ModHandler.getModItem("opensecurity", "opensecurity.securityDoor", 1L, 0), 300, 120);
            //Secure Private Door
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Items.iron_door, 1), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), ItemList.Circuit_Parts_Transistor.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 4L), GT_Utility.getIntegratedCircuit(2)}, GT_Values.NF, GT_ModHandler.getModItem("opensecurity", "opensecurity.securityDoorPrivate", 1L, 0), 300, 120);
            //Damage Upgrade
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), new ItemStack(Blocks.tnt, 1, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_Utility.getIntegratedCircuit(1)}, Materials.Redstone.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "opensecurity.damageUpgrade", 1L, 0), 300, 256);
            //Cooldown upgrade
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getIC2Item("reactorCoolantSimple", 1L, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_Utility.getIntegratedCircuit(1)}, Materials.Redstone.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "opensecurity.cooldownUpgrade", 1L, 0), 300, 256);
            //Energy Upgrade
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 63), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_Utility.getIntegratedCircuit(1)}, Materials.Redstone.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "opensecurity.energyUpgrade", 1L, 0), 300, 256);
            //Movement Upgrade
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Electric_Piston_MV.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_Utility.getIntegratedCircuit(1)}, Materials.Redstone.getMolten(72L), GT_ModHandler.getModItem("opensecurity", "opensecurity.movementUpgrade", 1L, 0), 300, 256);
            //OpenGlasses Terminal
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "geolyzer", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 43), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 38), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(144L), GT_ModHandler.getModItem("openglasses", "openglassesterminal", 1L, 0), 300, 480);
            //Open Glasses
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "screen3", 2L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 10), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13), GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L), GT_ModHandler.getModItem("openglasses", "openglasses", 1L, GT_Values.W), 300, 480);
         }

        if (Loader.isModLoaded("OpenBlocks") && Loader.isModLoaded("AWWayofTime")) {
            ItemStack[] trophies = {
                    GT_ModHandler.getModItem("OpenBlocks", "trophy", 1L),
                    GT_ModHandler.getModItem("OpenBlocks", "trophy", 1L),
                    GT_ModHandler.getModItem("OpenBlocks", "trophy", 1L),
                    GT_ModHandler.getModItem("OpenBlocks", "trophy", 1L),
            };

            NBTTagCompound[] tag = {
                    new NBTTagCompound(),
                    new NBTTagCompound(),
                    new NBTTagCompound(),
                    new NBTTagCompound(),
            };

            tag[0].setString("entity", "Bat");
            tag[1].setString("entity", "Cow");
            tag[2].setString("entity", "Chicken");
            tag[3].setString("entity", "Sheep");

            ItemStack flightpotion = GT_ModHandler.getModItem("AWWayofTime", "alchemyFlask", 1L);
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

            for (int i = 0; i < 4; ++i)
                trophies[i].setTagCompound(tag[i]);

            GT_Values.RA.addAssemblerRecipe(trophies[0], new ItemStack(Items.golden_carrot), new ItemStack(Items.potionitem, 1, 8262), 120, 120);
            GT_Values.RA.addAssemblerRecipe(trophies[1], new ItemStack(Items.iron_sword), new ItemStack(Items.leather, 64), 120, 120);
            GT_Values.RA.addAssemblerRecipe(trophies[2], new ItemStack(Items.feather), flightpotion, 120, 120);
            GT_Values.RA.addAssemblerRecipe(trophies[3], new ItemStack(Items.shears), new ItemStack(Blocks.wool, 64), 120, 120);
        }

        //Rocket Circuits
        final int[] EUperRecipe = new int[]{
                480,                //t2 = HV
                1920,                //t3 = EV
                7680,                //t4 = IV
                30720,                //t5 = LuV (Gated behind Assline)
                30720,                //t6 = LuV
                130870,                //t7 = ZPM
                520400,                //t8 = UV
        };

        ItemStack[] RocketMaterial = new ItemStack[8];
        RocketMaterial[0] = GT_ModHandler.getModItem("GalacticraftCore", "item.heavyPlating", 1L);
        RocketMaterial[1] = GT_ModHandler.getModItem("GalacticraftMars", "item.null", 1L, 3);
        RocketMaterial[2] = GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L);
        RocketMaterial[3] = CustomItemList.HeavyDutyPlateTier4.get(1L);
        RocketMaterial[4] = CustomItemList.HeavyDutyPlateTier5.get(1L);
        RocketMaterial[5] = CustomItemList.HeavyDutyPlateTier6.get(1L);
        RocketMaterial[6] = CustomItemList.HeavyDutyPlateTier7.get(1L);
        RocketMaterial[7] = CustomItemList.HeavyDutyPlateTier8.get(1L);

        ItemStack[] RocketChip = new ItemStack[8];
        RocketChip[0] = CustomItemList.SchematicsTier1.get(1L);
        RocketChip[1] = CustomItemList.SchematicsTier2.get(1L);
        RocketChip[2] = CustomItemList.SchematicsTier3.get(1L);
        RocketChip[3] = CustomItemList.SchematicsTier4.get(1L);
        RocketChip[4] = CustomItemList.SchematicsTier5.get(1L);
        RocketChip[5] = CustomItemList.SchematicsTier6.get(1L);
        RocketChip[6] = CustomItemList.SchematicsTier7.get(1L);
        RocketChip[7] = CustomItemList.SchematicsTier8.get(1L);

        ItemStack[] ExtraChips = new ItemStack[3];
        ExtraChips[0] = CustomItemList.SchematicsMoonBuggy.get(1L);
        ExtraChips[1] = CustomItemList.SchematicsCargoRocket.get(1L);
        ExtraChips[2] = CustomItemList.SchematicsAstroMiner.get(1L);

        for (Materials tMat : Materials.values()) {//TODO dream things using soldering go in here!
            if (tMat.mStandardMoltenFluid != null && tMat.contains(SubTag.SOLDERING_MATERIAL) && !(GregTech_API.mUseOnlyGoodSolderingMaterials && !tMat.contains(SubTag.SOLDERING_MATERIAL_GOOD))) {
                int tMultiplier = tMat.contains(SubTag.SOLDERING_MATERIAL_GOOD) ? 1 : tMat.contains(SubTag.SOLDERING_MATERIAL_BAD) ? 4 : 2;

                //Rocket Circuits
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Quantumprocessor.get(1L), RocketMaterial[0], GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(576L * tMultiplier / 2L), RocketChip[0], 9000, 480, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Data.get(1L), RocketMaterial[0], GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(576L * tMultiplier / 2L), RocketChip[0], 9000, 480, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Nanocomputer.get(1L), RocketMaterial[0], GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(576L * tMultiplier / 2L), RocketChip[0], 9000, 480, true);

                for (byte i = 2; i < 9; ++i) {
                    ItemStack DataStickWScheme = ItemList.Tool_DataStick.get(1L);
                    DataStickWScheme.setTagCompound(GT_Utility.getNBTContainingShort(new NBTTagCompound(), "rocket_tier", (short) i));
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{RocketMaterial[(i - 1)], ItemList.Circuit_Elite.get(1L), DataStickWScheme.splitStack(0)}, tMat.getMolten(576L * tMultiplier / 2L), RocketChip[(i - 1)], 9000, EUperRecipe[(i - 2)], true);
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{RocketMaterial[(i - 1)], ItemList.Circuit_Elitenanocomputer.get(1L), DataStickWScheme.splitStack(0)}, tMat.getMolten(576L * tMultiplier / 2L), RocketChip[(i - 1)], 9000, EUperRecipe[(i - 2)], true);
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{RocketMaterial[(i - 1)], ItemList.Circuit_Quantumcomputer.get(1L), DataStickWScheme.splitStack(0)}, tMat.getMolten(576L * tMultiplier / 2L), RocketChip[(i - 1)], 9000, EUperRecipe[(i - 2)], true);
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{RocketMaterial[(i - 1)], ItemList.Circuit_Crystalprocessor.get(1L), DataStickWScheme.splitStack(0)}, tMat.getMolten(576L * tMultiplier / 2L), RocketChip[(i - 1)], 9000, EUperRecipe[(i - 2)], true);
                }

                for (byte i = 0; i < 3; ++i) {
                    ItemStack DataStickWScheme = ItemList.Tool_DataStick.get(1L);
                    DataStickWScheme.setTagCompound(GT_Utility.getNBTContainingShort(new NBTTagCompound(), "rocket_tier", (short) (i + 100)));
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{RocketMaterial[i], ItemList.Circuit_Quantumprocessor.get(1L), DataStickWScheme.splitStack(0)}, tMat.getMolten(576L * tMultiplier / 2L), ExtraChips[i], 9000, EUperRecipe[i], true);
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{RocketMaterial[i], ItemList.Circuit_Data.get(1L), DataStickWScheme.splitStack(0)}, tMat.getMolten(576L * tMultiplier / 2L), ExtraChips[i], 9000, EUperRecipe[i], true);
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{RocketMaterial[i], ItemList.Circuit_Nanocomputer.get(1L), DataStickWScheme.splitStack(0)}, tMat.getMolten(576L * tMultiplier / 2L), ExtraChips[i], 9000, EUperRecipe[i], true);
                }
                //Primitive Circuit
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Chip_Simple_SoC.get(1L), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 2), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tin, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.NandChip.get(4L), 300, 120);

                //Basic Circuit
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Parts_Resistor.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 2), ItemList.Circuit_Parts_Vacuum_Tube.get(2L)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("IC2", "itemPartCircuit", 1L, 0), 200, 16);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 2), ItemList.Circuit_Parts_Vacuum_Tube.get(2L)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("IC2", "itemPartCircuit", 1L, 0), 200, 16);

                //Good Circuit
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), GT_ModHandler.getModItem("IC2", "itemPartCircuit", 2L, 0), ItemList.Circuit_Parts_Diode.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Good.get(1L), 300, 30);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), GT_ModHandler.getModItem("IC2", "itemPartCircuit", 2L, 0), ItemList.Circuit_Parts_DiodeSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Good.get(1L), 300, 30);

                //Integraded Circuits
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Chip_ILC.get(1L), ItemList.Circuit_Parts_Resistor.get(2L), ItemList.Circuit_Parts_Diode.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Basic.get(1L), 200, 16);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Chip_ILC.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L), ItemList.Circuit_Parts_Diode.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Basic.get(1L), 200, 16);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Chip_ILC.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Basic.get(1L), 200, 16);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Chip_ILC.get(1L), ItemList.Circuit_Parts_Resistor.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Basic.get(1L), 200, 16);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(2L), ItemList.Circuit_Parts_Resistor.get(4L), ItemList.Circuit_Parts_Diode.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Integrated_Good.get(1L), 400, 24);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(2L), ItemList.Circuit_Parts_ResistorSMD.get(4L), ItemList.Circuit_Parts_Diode.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Integrated_Good.get(1L), 400, 24);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(2L), ItemList.Circuit_Parts_ResistorSMD.get(4L), ItemList.Circuit_Parts_DiodeSMD.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Integrated_Good.get(1L), 400, 24);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(2L), ItemList.Circuit_Parts_ResistorASMD.get(1L), ItemList.Circuit_Parts_DiodeASMD.get(1L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Integrated_Good.get(1L), 200, 24);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(2L), ItemList.Circuit_Parts_Resistor.get(4L), ItemList.Circuit_Parts_DiodeSMD.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Integrated_Good.get(1L), 400, 24);

                //Advanced circuit
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Integrated_Good.get(1L), ItemList.Circuit_Chip_ILC.get(2L), ItemList.Circuit_Chip_Ram.get(2L), ItemList.Circuit_Parts_Transistor.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 8)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getIC2Item("advancedCircuit", 1L), 800, 30, false);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Integrated_Good.get(1L), ItemList.Circuit_Chip_ILC.get(2L), ItemList.Circuit_Chip_Ram.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 8)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getIC2Item("advancedCircuit", 1L), 800, 30, false);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Integrated_Good.get(1L), ItemList.Circuit_Chip_ILC.get(2L), ItemList.Circuit_Chip_Ram.get(2L), ItemList.Circuit_Parts_TransistorASMD.get(1L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 8)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getIC2Item("advancedCircuit", 1L), 400, 30, false);

                //Integrated Circuits
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(2L), ItemList.Circuit_Parts_Capacitor.get(2L), ItemList.Circuit_Parts_Transistor.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Microprocessor.get(2L), 200, 60, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L), ItemList.Circuit_Parts_Capacitor.get(2L), ItemList.Circuit_Parts_Transistor.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Microprocessor.get(2L), 200, 60, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(2L), ItemList.Circuit_Parts_CapacitorSMD.get(2L), ItemList.Circuit_Parts_Transistor.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Microprocessor.get(2L), 200, 60, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(2L), ItemList.Circuit_Parts_Capacitor.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Microprocessor.get(2L), 200, 60, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L), ItemList.Circuit_Parts_CapacitorSMD.get(2L), ItemList.Circuit_Parts_Transistor.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Microprocessor.get(2L), 200, 60, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L), ItemList.Circuit_Parts_Capacitor.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Microprocessor.get(2L), 200, 60, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(2L), ItemList.Circuit_Parts_CapacitorSMD.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Microprocessor.get(2L), 200, 60, true);

                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(4L), ItemList.Circuit_Parts_Capacitor.get(4L), ItemList.Circuit_Parts_Transistor.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 200, 60, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(4L), ItemList.Circuit_Parts_Capacitor.get(4L), ItemList.Circuit_Parts_Transistor.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 200, 60, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorASMD.get(1L), ItemList.Circuit_Parts_CapacitorASMD.get(1L), ItemList.Circuit_Parts_TransistorASMD.get(1L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 100, 60, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(4L), ItemList.Circuit_Parts_CapacitorSMD.get(4L), ItemList.Circuit_Parts_Transistor.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 200, 60, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(4L), ItemList.Circuit_Parts_Capacitor.get(4L), ItemList.Circuit_Parts_TransistorSMD.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 200, 60, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(4L), ItemList.Circuit_Parts_CapacitorSMD.get(4L), ItemList.Circuit_Parts_Transistor.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 200, 60, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(4L), ItemList.Circuit_Parts_Capacitor.get(4L), ItemList.Circuit_Parts_TransistorSMD.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 200, 60, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(4L), ItemList.Circuit_Parts_CapacitorSMD.get(4L), ItemList.Circuit_Parts_TransistorSMD.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 200, 60, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Processor.get(2L), ItemList.Circuit_Parts_Coil.get(4L), ItemList.Circuit_Parts_Capacitor.get(8L), ItemList.Circuit_Chip_Ram.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 8)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Computer.get(1L), 400, 120, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(2L), ItemList.Circuit_Chip_NAND.get(32L), ItemList.Circuit_Chip_Ram.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 16), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 4)}, tMat.getMolten(144L * tMultiplier), ItemList.Tool_DataStick.get(1L), 400, 90, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Advanced.get(2L), ItemList.Circuit_Parts_Diode.get(4L), ItemList.Circuit_Chip_Ram.get(8L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 16)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Data.get(1L), 400, 120, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2), ItemList.Circuit_Parts_Coil.get(12L), ItemList.Circuit_Parts_Capacitor.get(24), ItemList.Circuit_Chip_Ram.get(16L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 24)}, tMat.getMolten(144L * tMultiplier * 2), ItemList.Circuit_Elite.get(1L), 1600, 480, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L), ItemList.Circuit_Parts_CapacitorSMD.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Microprocessor.get(2L), 200, 60, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(4L), ItemList.Circuit_Parts_CapacitorSMD.get(4L), ItemList.Circuit_Parts_TransistorSMD.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 200, 60, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Processor.get(2L), ItemList.Circuit_Parts_Coil.get(4L), ItemList.Circuit_Parts_CapacitorSMD.get(8L), ItemList.Circuit_Chip_Ram.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 8)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Computer.get(1L), 400, 96, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorASMD.get(4L), ItemList.Circuit_Parts_CapacitorASMD.get(1L), ItemList.Circuit_Parts_TransistorASMD.get(1L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 100, 60, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Processor.get(2L), ItemList.Circuit_Parts_Coil.get(4L), ItemList.Circuit_Parts_CapacitorASMD.get(2L), ItemList.Circuit_Chip_Ram.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 8)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Computer.get(1L), 200, 96, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Advanced.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(4L), ItemList.Circuit_Chip_Ram.get(8L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 16)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Data.get(1L), 400, 120, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Advanced.get(2L), ItemList.Circuit_Parts_DiodeASMD.get(1L), ItemList.Circuit_Chip_Ram.get(8L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 16)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Data.get(1L), 200, 120, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2), ItemList.Circuit_Parts_Coil.get(12L), ItemList.Circuit_Parts_CapacitorSMD.get(16L), ItemList.Circuit_Chip_Ram.get(16L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 16)}, tMat.getMolten(144L * tMultiplier * 2), ItemList.Circuit_Elite.get(1L), 1600, 480, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2), ItemList.Circuit_Parts_Coil.get(12L), ItemList.Circuit_Parts_CapacitorASMD.get(4L), ItemList.Circuit_Chip_Ram.get(16L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 16)}, tMat.getMolten(144L * tMultiplier * 2), ItemList.Circuit_Elite.get(1L), 800, 480, true);

                //Nanotech Circuits
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Chip_NanoCPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(8L), ItemList.Circuit_Parts_CapacitorSMD.get(8L), ItemList.Circuit_Parts_TransistorSMD.get(8L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Nanoprocessor.get(1L), 200, 600, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Chip_NanoCPU.get(1L), ItemList.Circuit_Parts_ResistorASMD.get(2L), ItemList.Circuit_Parts_CapacitorASMD.get(2L), ItemList.Circuit_Parts_TransistorASMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Nanoprocessor.get(1L), 100, 600, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Nanoprocessor.get(2L), ItemList.Circuit_Parts_Coil.get(8L), ItemList.Circuit_Parts_CapacitorSMD.get(8L), ItemList.Circuit_Chip_Ram.get(8L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Nanocomputer.get(1L), 400, 600, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Nanoprocessor.get(2L), ItemList.Circuit_Parts_Coil.get(8L), ItemList.Circuit_Parts_CapacitorASMD.get(2L), ItemList.Circuit_Chip_Ram.get(8L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Nanocomputer.get(1L), 200, 600, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Nanoprocessor.get(2L), ItemList.Circuit_Chip_Ram.get(4L), ItemList.Circuit_Chip_NOR.get(32L), ItemList.Circuit_Chip_NAND.get(64L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 32)}, tMat.getMolten(144L * tMultiplier), ItemList.Tool_DataOrb.get(1L), 400, 1200, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Nanocomputer.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(8L), ItemList.Circuit_Chip_NOR.get(4L), ItemList.Circuit_Chip_Ram.get(16L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Elitenanocomputer.get(1L), 400, 600, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Nanocomputer.get(2L), ItemList.Circuit_Parts_DiodeASMD.get(2L), ItemList.Circuit_Chip_NOR.get(4L), ItemList.Circuit_Chip_Ram.get(16L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Elitenanocomputer.get(1L), 200, 600, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2), ItemList.Circuit_Elitenanocomputer.get(2L), ItemList.Circuit_Parts_Coil.get(16L), ItemList.Circuit_Parts_CapacitorSMD.get(32L), ItemList.Circuit_Chip_Ram.get(16L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 32)}, tMat.getMolten(144L * tMultiplier * 2), ItemList.Circuit_Master.get(1L), 1600, 1920, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2), ItemList.Circuit_Elitenanocomputer.get(2L), ItemList.Circuit_Parts_Coil.get(16L), ItemList.Circuit_Parts_CapacitorASMD.get(8L), ItemList.Circuit_Chip_Ram.get(16L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 32)}, tMat.getMolten(144L * tMultiplier * 2), ItemList.Circuit_Master.get(1L), 800, 1920, true);

                //Quantum Circuits
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Chip_QuantumCPU.get(1L), ItemList.Circuit_Chip_NanoCPU.get(1L), ItemList.Circuit_Parts_CapacitorSMD.get(12L), ItemList.Circuit_Parts_TransistorSMD.get(12L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Quantumprocessor.get(1L), 200, 2400, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Chip_QuantumCPU.get(1L), ItemList.Circuit_Chip_NanoCPU.get(1L), ItemList.Circuit_Parts_CapacitorASMD.get(3L), ItemList.Circuit_Parts_TransistorASMD.get(3L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Quantumprocessor.get(1L), 100, 2400, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Quantumprocessor.get(2L), ItemList.Circuit_Parts_Coil.get(12L), ItemList.Circuit_Parts_CapacitorSMD.get(16L), ItemList.Circuit_Chip_Ram.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 24)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Quantumcomputer.get(1L), 400, 2400, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Quantumprocessor.get(2L), ItemList.Circuit_Parts_Coil.get(12L), ItemList.Circuit_Parts_CapacitorASMD.get(4L), ItemList.Circuit_Chip_Ram.get(4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 24)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Quantumcomputer.get(1L), 200, 2400, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Quantumcomputer.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(8L), ItemList.Circuit_Chip_NOR.get(4L), ItemList.Circuit_Chip_Ram.get(16L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 48)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Masterquantumcomputer.get(1L), 400, 2400, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Quantumcomputer.get(2L), ItemList.Circuit_Parts_DiodeASMD.get(2L), ItemList.Circuit_Chip_NOR.get(4L), ItemList.Circuit_Chip_Ram.get(16L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 48)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Masterquantumcomputer.get(1L), 200, 2400, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2), ItemList.Circuit_Masterquantumcomputer.get(2L), ItemList.Circuit_Parts_Coil.get(24), ItemList.Circuit_Parts_CapacitorSMD.get(48L), ItemList.Circuit_Chip_Ram.get(24), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 48)}, tMat.getMolten(144L * tMultiplier * 2), ItemList.Circuit_Quantummainframe.get(1L), 1600, 7680, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2), ItemList.Circuit_Masterquantumcomputer.get(2L), ItemList.Circuit_Parts_Coil.get(24), ItemList.Circuit_Parts_CapacitorASMD.get(12L), ItemList.Circuit_Chip_Ram.get(24), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 48)}, tMat.getMolten(144L * tMultiplier * 2), ItemList.Circuit_Quantummainframe.get(1L), 800, 7680, true);

                //Crystallized Circuits
                //GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Multifiberglass_Elite.get(1L), ItemList.Circuit_Chip_CrystalCPU.get(1L), ItemList.Circuit_Chip_NanoCPU.get(2L), ItemList.Circuit_Parts_CapacitorSMD.get(24), ItemList.Circuit_Parts_TransistorSMD.get(24), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 8)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Crystalprocessor.get(1L), 200, 9600, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Multifiberglass_Elite.get(1L), ItemList.Circuit_Chip_CrystalCPU.get(1L), ItemList.Circuit_Chip_NanoCPU.get(2L), ItemList.Circuit_Parts_CapacitorASMD.get(6), ItemList.Circuit_Parts_TransistorASMD.get(6), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 8)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Crystalprocessor.get(1L), 100, 9600, true);
                //GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Multifiberglass_Elite.get(1L), ItemList.Circuit_Crystalprocessor.get(2L), ItemList.Circuit_Parts_Coil.get(24), ItemList.Circuit_Parts_CapacitorSMD.get(32L), ItemList.Circuit_Chip_Ram.get(24), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Crystalcomputer.get(1L), 400, 9600, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Multifiberglass_Elite.get(1L), ItemList.Circuit_Crystalprocessor.get(2L), ItemList.Circuit_Parts_Coil.get(24), ItemList.Circuit_Parts_CapacitorASMD.get(8L), ItemList.Circuit_Chip_Ram.get(24), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Crystalcomputer.get(1L), 200, 9600, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Multifiberglass_Elite.get(1L), ItemList.Circuit_Crystalcomputer.get(2L), ItemList.Circuit_Chip_Ram.get(4L), ItemList.Circuit_Chip_NOR.get(32L), ItemList.Circuit_Chip_NAND.get(64L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 32)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Ultimatecrystalcomputer.get(1L), 400, 9600, true);
                //GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2), ItemList.Circuit_Ultimatecrystalcomputer.get(2L), ItemList.Circuit_Parts_Coil.get(32L), ItemList.Circuit_Parts_CapacitorSMD.get(64L), ItemList.Circuit_Chip_Ram.get(32L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 16)}, tMat.getMolten(144L * tMultiplier * 2), ItemList.Circuit_Crystalmainframe.get(1L), 1600, 30720, true);                //Wetware Circuits
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2), ItemList.Circuit_Ultimatecrystalcomputer.get(2L), ItemList.Circuit_Parts_Coil.get(32L), ItemList.Circuit_Parts_CapacitorASMD.get(16L), ItemList.Circuit_Chip_Ram.get(32L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 16)}, tMat.getMolten(144L * tMultiplier * 2), ItemList.Circuit_Crystalmainframe.get(1L), 800, 30720, true);                //Wetware Circuits

                //Wetware Boards
                //GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Chip_NeuroCPU.get(1L),ItemList.Circuit_Chip_CrystalCPU.get(1L), ItemList.Circuit_Chip_NanoCPU.get(1L), ItemList.Circuit_Parts_CapacitorSMD.get(32L),ItemList.Circuit_Parts_TransistorSMD.get(32L),GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 8)},tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Neuroprocessor.get(1L), 400, 38400, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Chip_NeuroCPU.get(1L), ItemList.Circuit_Chip_CrystalCPU.get(1L), ItemList.Circuit_Chip_NanoCPU.get(1L), ItemList.Circuit_Parts_CapacitorASMD.get(8L), ItemList.Circuit_Parts_TransistorASMD.get(8L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 8)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Neuroprocessor.get(1L), 200, 38400, true);
                //GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Wetware_Extreme.get(1L), ItemList.Circuit_Neuroprocessor.get(2L), ItemList.Circuit_Parts_Coil.get(32L), ItemList.Circuit_Parts_CapacitorSMD.get(48L), ItemList.Circuit_Chip_Ram.get(24L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 16)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Wetwarecomputer.get(1L), 600, 38400, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Wetware_Extreme.get(1L), ItemList.Circuit_Neuroprocessor.get(2L), ItemList.Circuit_Parts_Coil.get(32L), ItemList.Circuit_Parts_CapacitorASMD.get(12L), ItemList.Circuit_Chip_Ram.get(24L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 16)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Wetwarecomputer.get(1L), 300, 38400, true);
                //GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Wetware_Extreme.get(2L), ItemList.Circuit_Wetwarecomputer.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(32L), ItemList.Circuit_Chip_NOR.get(16L), ItemList.Circuit_Chip_Ram.get(64L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 24)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Wetwaresupercomputer.get(1L), 600, 38400, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Wetware_Extreme.get(2L), ItemList.Circuit_Wetwarecomputer.get(2L), ItemList.Circuit_Parts_DiodeASMD.get(8L), ItemList.Circuit_Chip_NOR.get(16L), ItemList.Circuit_Chip_Ram.get(64L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 24)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Wetwaresupercomputer.get(1L), 600, 38400, true);

                //Bio Circuits
                //GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Chip_BioCPU.get(1L),ItemList.Circuit_Chip_CrystalSoC2.get(1L), ItemList.Circuit_Chip_NanoCPU.get(2L), ItemList.Circuit_Parts_CapacitorSMD.get(48L),ItemList.Circuit_Parts_TransistorSMD.get(48L),GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16)},tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Bioprocessor.get(1L), 600, 153600, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Chip_BioCPU.get(1L), ItemList.Circuit_Chip_CrystalSoC2.get(1L), ItemList.Circuit_Chip_NanoCPU.get(2L), ItemList.Circuit_Parts_CapacitorASMD.get(12L), ItemList.Circuit_Parts_TransistorASMD.get(12L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Bioprocessor.get(1L), 300, 153600, true);
                //GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Bio_Ultra.get(1L), ItemList.Circuit_Bioprocessor.get(2L), ItemList.Circuit_Parts_Coil.get(48L), ItemList.Circuit_Parts_CapacitorSMD.get(64L), ItemList.Circuit_Chip_Ram.get(32L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 24)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Biowarecomputer.get(1L), 800, 153600, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Bio_Ultra.get(1L), ItemList.Circuit_Bioprocessor.get(2L), ItemList.Circuit_Parts_Coil.get(48L), ItemList.Circuit_Parts_CapacitorASMD.get(16L), ItemList.Circuit_Chip_Ram.get(32L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 24)}, tMat.getMolten(144L * tMultiplier), ItemList.Circuit_Biowarecomputer.get(1L), 400, 153600, true);

                //SoC
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_SoC.get(1L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Copper, 2)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Microprocessor.get(2L), 50, 600, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_SoC.get(1L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 4)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Processor.get(1L), 50, 2400, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Chip_SoC2.get(1L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 8)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Nanoprocessor.get(1L), 50, 9600, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Chip_SoC2.get(1L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.NiobiumTitanium, 8)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Quantumprocessor.get(1L), 50, 38400, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Multifiberglass_Elite.get(1L), ItemList.Circuit_Chip_CrystalSoC.get(1L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 8), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.YttriumBariumCuprate, 8)}, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Crystalprocessor.get(1L), 50, 153600, true);

                //Lapo orbs
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Chip_PIC.get(4L), ItemList.Circuit_Parts_Crystal_Chip_Master.get(24L), ItemList.Circuit_Chip_NanoCPU.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Platinum, 8)}, tMat.getMolten(144L * tMultiplier), ItemList.Energy_LapotronicOrb.get(1L), 512, 1024, true);
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Chip_HPIC.get(4L), ItemList.Energy_LapotronicOrb.get(8L), ItemList.Circuit_Chip_QuantumCPU.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 16)}, tMat.getMolten(144L * tMultiplier), ItemList.Energy_LapotronicOrb2.get(1L), 1024, 4096, true);

                //Wetware Board
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Multifiberglass.get(16L), ItemList.Circuit_Parts_PetriDish.get(1L), ItemList.Electric_Pump_LuV.get(1L), ItemList.Sensor_IV.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 16L)}, Materials.GrowthMediumSterilized.getFluid(4000L), ItemList.Circuit_Board_Wetware.get(16L), 1200, 30720, true);

                //Bio Board
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Wetware.get(32L), ItemList.Circuit_Parts_PetriDish.get(8L), ItemList.Electric_Pump_UV.get(1L), ItemList.Sensor_LuV.get(2L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Neutronium, 32L)}, Materials.BioMediumSterilized.getFluid(16000L), ItemList.Circuit_Board_Bio.get(32L), 1200, 500000, true);

                //PCBs Steve Carts
                if (Loader.isModLoaded("StevesCarts")) {
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 8), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 1L, 9), 200, 30);
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 2L, 9), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 1L, 16), 400, 30);
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 8), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 1L, 9), 200, 30);
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 2L, 9), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 1L, 16), 200, 120);
                }

                //Energy Flow Circuit
                GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Multifiberglass_Elite.get(1L), ItemList.Circuit_Wetwarecomputer.get(2L), ItemList.Circuit_Chip_UHPIC.get(4L), ItemList.Circuit_Chip_QuantumCPU.get(2L), ItemList.Circuit_Chip_NanoCPU.get(2L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorZPM, 64)}, tMat.getMolten(576L * tMultiplier / 2L), CustomItemList.HighEnergyFlowCircuit.get(1L), 2400, 7680, true);

                // --- Advanced Solar Panel
                if (Loader.isModLoaded("AdvancedSolarPanel")) {
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_LV.get(1L), ItemList.Cover_SolarPanel_LV.get(1L), ItemList.Robot_Arm_LV.get(1L), ItemList.Battery_RE_LV_Lithium.get(1L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("AdvancedSolarPanel", "BlockAdvSolarPanel", 1L, 0), 800, 120);
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MV.get(1L), ItemList.Cover_SolarPanel_MV.get(1L), ItemList.Robot_Arm_MV.get(1L), ItemList.Battery_RE_MV_Lithium.get(1L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(576L * tMultiplier / 2L), GT_ModHandler.getModItem("AdvancedSolarPanel", "BlockAdvSolarPanel", 1L, 1), 1000, 480);
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_HV.get(1L), ItemList.Cover_SolarPanel_HV.get(1L), ItemList.Robot_Arm_HV.get(1L), ItemList.Battery_RE_HV_Lithium.get(1L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(864L * tMultiplier / 2L), GT_ModHandler.getModItem("AdvancedSolarPanel", "BlockAdvSolarPanel", 1L, 2), 1200, 1920);
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_EV.get(1L), ItemList.Cover_SolarPanel_EV.get(1L), ItemList.Robot_Arm_EV.get(1L), CustomItemList.BatteryHull_EV_Full.get(1L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(1152L * tMultiplier / 2L), GT_ModHandler.getModItem("AdvancedSolarPanel", "BlockAdvSolarPanel", 1L, 3), 1400, 7860);
                }

                // --- Super Solar Panel
                if (Loader.isModLoaded("supersolarpanel")) {
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_IV.get(1L), ItemList.Cover_SolarPanel_IV.get(1L), ItemList.Robot_Arm_IV.get(1L), CustomItemList.BatteryHull_IV_Full.get(1L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(1440 * tMultiplier / 2L), GT_ModHandler.getModItem("supersolarpanel", "SpectralSolarPanel", 1L, 0), 1600, 30720);
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_LuV.get(1L), ItemList.Cover_SolarPanel_LuV.get(1L), ItemList.Robot_Arm_LuV.get(1L), CustomItemList.BatteryHull_LuV_Full.get(1L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(1728 * tMultiplier / 2L), GT_ModHandler.getModItem("supersolarpanel", "SingularSolarPanel", 1L, 0), 1800, 122880);
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_ZPM.get(1L), ItemList.Cover_SolarPanel_ZPM.get(1L), ItemList.Robot_Arm_ZPM.get(1L), CustomItemList.BatteryHull_ZPM_Full.get(1L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(2016 * tMultiplier / 2L), GT_ModHandler.getModItem("supersolarpanel", "AdminSolarPanel", 1L, 0), 2000, 500000);
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UV.get(1L), ItemList.Cover_SolarPanel_UV.get(1L), ItemList.Robot_Arm_UV.get(1L), CustomItemList.BatteryHull_UV_Full.get(1L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(2304 * tMultiplier / 2L), GT_ModHandler.getModItem("supersolarpanel", "PhotonicSolarPanel", 1L, 0), 2200, 2000000);
                }

                //Quantum Armor
                GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumHelmet", 1, GT_Values.W));

                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{CustomItemList.QuantumPartHelmet.get(1L),
                                CustomItemList.QuantumCrystal.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 4),
                                ItemList.Energy_LapotronicOrb.get(1L),
                                ItemList.Sensor_IV.get(1L),
                                ItemList.Field_Generator_EV.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 4),
                                GT_Utility.getIntegratedCircuit(10)},
                        Materials.Titanium.getMolten(1728L),
                        GT_ModHandler.getIC2Item("quantumHelmet", 1L, 26), 1500, 7680);

                GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumBodyarmor", 1, GT_Values.W));

                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{CustomItemList.QuantumPartChestplate.get(1L),
                                CustomItemList.QuantumCrystal.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 6),
                                ItemList.Energy_LapotronicOrb.get(1L),
                                ItemList.Field_Generator_EV.get(3L),
                                ItemList.Electric_Motor_IV.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 4),
                                GT_Utility.getIntegratedCircuit(11)},
                        Materials.Titanium.getMolten(2880L),
                        GT_ModHandler.getIC2Item("quantumBodyarmor", 1L, 26), 1500, 7680);

                GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumLeggings", 1, GT_Values.W));

                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{CustomItemList.QuantumPartLeggings.get(1L),
                                CustomItemList.QuantumCrystal.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 6),
                                ItemList.Energy_LapotronicOrb.get(1L),
                                ItemList.Field_Generator_EV.get(2L),
                                ItemList.Electric_Motor_IV.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 4),
                                GT_Utility.getIntegratedCircuit(12)},
                        Materials.Titanium.getMolten(2304L),
                        GT_ModHandler.getIC2Item("quantumLeggings", 1L, 26), 1500, 7680);

                GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumBoots", 1, GT_Values.W));

                GT_Values.RA.addAssemblerRecipe(new ItemStack[]{CustomItemList.QuantumPartBoots.get(1L),
                                CustomItemList.QuantumCrystal.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 4),
                                ItemList.Energy_LapotronicOrb.get(1L),
                                ItemList.Field_Generator_EV.get(1L),
                                ItemList.Electric_Piston_IV.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 4),
                                GT_Utility.getIntegratedCircuit(13)},
                        Materials.Titanium.getMolten(1440L),
                        GT_ModHandler.getIC2Item("quantumBoots", 1L, 26), 1500, 7680);
                
                if (Loader.isModLoaded("OpenComputers")) {
                	make_lua_bios();
                	
                    //display t1
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L), ItemList.Cover_Screen.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L), ItemList.Circuit_Parts_Transistor.get(2L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "screen1", 1L, 0), 240, 64);
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L), ItemList.Cover_Screen.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L), ItemList.Circuit_Parts_TransistorSMD.get(1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "screen1", 1L, 0), 240, 64);
                    //display t2
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_HV.get(1L), GT_ModHandler.getModItem("OpenComputers", "screen1", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L), ItemList.Circuit_Parts_Transistor.get(4L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0), 240, 120);
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_HV.get(1L), GT_ModHandler.getModItem("OpenComputers", "screen1", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L), ItemList.Circuit_Parts_TransistorSMD.get(2L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0), 240, 120);
                    //display t3
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_EV.get(1L), GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L), ItemList.Circuit_Parts_Transistor.get(8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "screen3", 1L, 0), 240, 256);
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_EV.get(1L), GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L), ItemList.Circuit_Parts_TransistorSMD.get(4L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "screen3", 1L, 0), 240, 256);
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_EV.get(1L), GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L), ItemList.Circuit_Parts_TransistorASMD.get(1L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "screen3", 1L, 0), 120, 256);
                    //ALU
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_ILC.get(16L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 27), 400, 64);
                    //CU
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Parts_Transistor.get(4L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), 200, 30);
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Parts_TransistorSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), 200, 30);
                    //anylyser
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Tool_Scanner.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), ItemList.Circuit_Parts_Transistor.get(2L), ItemList.Sensor_HV.get(1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), 300, 120);
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Tool_Scanner.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), ItemList.Circuit_Parts_TransistorSMD.get(1L), ItemList.Sensor_HV.get(1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), 300, 120);
                    //CPU 1
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 8L, 27), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 29), 200, 120);
                    //CPU 2
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 12L, 27), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 28), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 42), 200, 120);
                    //CPU 3
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 16L, 27), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 28), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L), GT_Utility.getIntegratedCircuit(3)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 43), 200, 120);
                    //Graphics Card 1
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 8L, 27), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 1), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 8), 400, 120);
                    //Graphics Card 2
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 16L, 27), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 28), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 2), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 9), 400, 256);
                    //Graphics Card 3
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 32L, 27), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 28), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 26), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 38), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 10), 400, 480);
                    //Internet Crad
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 48), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 1L), GT_ModHandler.getModItem("ProjRed|Illumination", "projectred.illumination.lightbutton", 1L, 14), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 44), 400, 480);
                    //APU T1
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 32L, 27), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 28), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 101), 200, 256);
                    //APU T2
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 64L, 27), GT_ModHandler.getModItem("OpenComputers", "item", 8L, 28), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L), GT_Utility.getIntegratedCircuit(3)}, tMat.getMolten(288L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 102), 200, 480);
                    //EEPROM
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), ItemList.Circuit_Parts_Transistor.get(6L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 1), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "eeprom", 1L, 0), 200, 120);
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), ItemList.Circuit_Parts_TransistorSMD.get(6L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 1), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "eeprom", 1L, 0), 200, 120);

                    //RAM 1
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_Ram.get(16L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 1), 250, 64);
                    //RAM 1.5
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Circuit_Chip_Ram.get(32L), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 24), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 50), 250, 120);
                    //RAM 2
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Chip_Ram.get(64L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 2), 250, 256);
                    //RAM 2.5
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Chip_Ram.get(64L), ItemList.Circuit_Chip_NAND.get(16L), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 25), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 3), 250, 480);
                    //RAM 3
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Chip_Ram.get(64L), ItemList.Circuit_Chip_NAND.get(32L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 38), 250, 1024);
                    //RAM 3.5
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), ItemList.Circuit_Chip_Ram.get(64L), ItemList.Circuit_Chip_NAND.get(64L), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 26), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 39), 250, 1920);
                    //Circuit 1
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1), ItemList.Circuit_Parts_Transistor.get(4L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 4L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), 300, 120);
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1), ItemList.Circuit_Parts_TransistorSMD.get(4L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 4L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), 300, 120);
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1), ItemList.Circuit_Parts_TransistorASMD.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 4L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), 150, 120);
                    //Circuit 2
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1), ItemList.Circuit_Parts_Transistor.get(8L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), 300, 256);
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1), ItemList.Circuit_Parts_TransistorSMD.get(8L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), 300, 256);
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1), ItemList.Circuit_Parts_TransistorASMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8L), GT_Utility.getIntegratedCircuit(3)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), 150, 256);
                    //Circuit 3
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1), ItemList.Circuit_Parts_Transistor.get(16L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), 300, 480);
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1), ItemList.Circuit_Parts_TransistorSMD.get(16L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), 300, 480);
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1), ItemList.Circuit_Parts_TransistorASMD.get(4L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), 150, 480);
                    //network card
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 11), 200, 120);
                    //wlan card1
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 11), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), ItemList.Emitter_LV.get(1L), ItemList.Sensor_LV.get(1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 113), 200, 120);
                    //wlan card2
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 11), ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), ItemList.Emitter_HV.get(1L), ItemList.Sensor_HV.get(1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13), 200, 256);
                    //World sensor card
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_ModHandler.getModItem("GalacticraftCore", "item.sensorLens", 2L, 0), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 89), 200, 120);
                    //redstone card 1
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), ItemList.Circuit_Chip_ILC.get(4L), new ItemStack(Blocks.redstone_torch, 2), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 66), 200, 120);
                    //redstone card 2
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), ItemList.Circuit_Chip_ILC.get(16L), new ItemStack(Blocks.redstone_torch, 4), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 12), 200, 256);
                    //data card 1
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_ModHandler.getModItem("OpenComputers", "item", 4, 27), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 104), 300, 120);
                    //data card 2
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 1, 29), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 105), 300, 156);
                    //data card 3
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_ModHandler.getModItem("OpenComputers", "item", 1, 42), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 32L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 106), 300, 480);
                    //angel upgrade
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), GT_ModHandler.getModItem("ExtraUtilities", "angelBlock", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 49), 250, 256);
                    //hover upgrade Tier 1
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 4L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), ItemList.Electric_Motor_MV.get(1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 99), 250, 256);
                    //hover upgrade Tier 2
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 4L), GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 8L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), ItemList.Electric_Motor_HV.get(1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 100), 250, 480);
                    //battery upgrade 1
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0), ItemList.Circuit_Parts_Transistor.get(2L), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 4L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 63), 250, 120);
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0), ItemList.Circuit_Parts_TransistorSMD.get(1L), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 4L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 63), 250, 120);
                    //battery upgrade 2
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L), GT_ModHandler.getModItem("OpenComputers", "capacitor", 2L, 0), ItemList.Circuit_Parts_Transistor.get(4L), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 64), 250, 256);
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L), GT_ModHandler.getModItem("OpenComputers", "capacitor", 2L, 0), ItemList.Circuit_Parts_TransistorSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 64), 250, 256);
                    //battery upgrade 3
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L), GT_ModHandler.getModItem("OpenComputers", "capacitor", 4L, 0), ItemList.Circuit_Parts_Transistor.get(8L), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 65), 250, 480);
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L), GT_ModHandler.getModItem("OpenComputers", "capacitor", 4L, 0), ItemList.Circuit_Parts_TransistorSMD.get(4L), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 65), 250, 480);
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L), GT_ModHandler.getModItem("OpenComputers", "capacitor", 4L, 0), ItemList.Circuit_Parts_TransistorASMD.get(1L), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 65), 125, 480);
                    //inventory upgrade
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), new ItemStack(Blocks.chest, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 53), 300, 120);
                    //inventory controller upgrade
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 53), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 61), 300, 256);
                    //tank upgrade
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), GT_ModHandler.getModItem("BuildCraft|Factory", "tankBlock", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 76), 300, 120);
                    //tank controller upgrade
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 76), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 77), 300, 256);
                    //beekeper upgrade
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_ModHandler.getModItem("Forestry", "beealyzer", 1L, 0), ItemList.Sensor_MV.get(2L), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 2), GT_Utility.getIntegratedCircuit(10)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item.forestry", 1L, 0), 200, 120);
                    //card container 1
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), new ItemStack(Blocks.chest, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 57), 250, 120);
                    //card container 2
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L), new ItemStack(Blocks.chest, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 58), 250, 256);
                    //card container 3
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L), new ItemStack(Blocks.chest, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 59), 250, 480);
                    //upgrade container 1
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), new ItemStack(Blocks.chest, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.StainlessSteel, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 54), 250, 120);
                    //upgrade container 2
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L), new ItemStack(Blocks.chest, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Titanium, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 55), 250, 256);
                    //upgrade container 3
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L), new ItemStack(Blocks.chest, 1), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 8L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 56), 250, 480);
                    //component bus t1
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 4L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 70), 250, 120);
                    //component bus t2
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 28), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 2), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 71), 250, 256);
                    //component bus t3
                    GT_Values.RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_ModHandler.getModItem("OpenComputers", "item", 8L, 28), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 38), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Diamond, 16), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 72), 250, 480);
                    //database upgrade 1
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 5), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 78), 250, 120);
                    //database upgrade 2
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 6), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 79), 250, 256);
                    //database upgrade 3
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 7), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 80), 250, 480);
                    //experience upgrade
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Emerald, 2L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 52), 250, 120);
                    //crafting component
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_LV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), ItemList.Cover_Crafting.get(1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 14), 250, 120);
                    //generator upgrade
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("EnderIO", "blockStirlingGenerator", 1L, 0), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 15), 250, 120);
                    //leash upgrade
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), new ItemStack(Items.lead, 4), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 85), 250, 120);
                    //mfu upgrade
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "adapter", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 51), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 96), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 2L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 112), 250, 480);
                    //navigation upgrade
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MV.get(1L), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), new ItemStack(Items.compass, 1), new ItemStack(Items.filled_map, 1), GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Water, 1L)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 36), 250, 256);
                    //piston upgrade
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), ItemList.Electric_Piston_MV.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 75), 250, 120);
                    //sing IO upgrade
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), ItemList.Dye_SquidInk.get(1L), new ItemStack(Items.sign, 1), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 35), 250, 120);
                    //solar upgrade
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), ItemList.Cover_SolarPanel_LV.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 34), 250, 256);
                    //tractor beam upgrade
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0), ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), ItemList.Electric_Piston_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.IronMagnetic, 4L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 16L)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 67), 250, 480);
                    //trading upgrade
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 3L, 25), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 3L), ItemList.Electric_Piston_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Emerald, 2L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 110), 250, 256);
                    //hover Boots
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 83), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 100), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 4L), ItemList.Electric_Piston_MV.get(2L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("OpenComputers", "hoverBoots", 1L, GT_Values.W), 350, 256);
                    // ME Upgrade 1
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13), GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 41), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("extracells", "oc.upgrade", 1L, 2), 250, 256);
                    // ME Upgrade 2
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13), GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 41), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("extracells", "oc.upgrade", 1L, 1), 250, 1024);
                    // ME Upgrade 3
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Chrome, 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13), GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 41), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("extracells", "oc.upgrade", 1L), 250, 4096);
                }

                if (Loader.isModLoaded("computronics")) {
                    // Camera Upgrade
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("computronics", "computronics.camera", 1L, 0), ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), ItemList.Circuit_Parts_TransistorSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 0), 250, 256);
                    // Chat Upgrade
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("computronics", "computronics.chatBox", 1L, 0), ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), ItemList.Circuit_Parts_TransistorSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 1), 250, 256);
                    // Radar Upgrade
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("computronics", "computronics.radar", 1L, 0), ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), ItemList.Circuit_Parts_TransistorSMD.get(4L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 48), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 2), 250, 480);
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("computronics", "computronics.radar", 1L, 0), ItemList.Circuit_Board_Fiberglass_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), ItemList.Circuit_Parts_TransistorASMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 48), GT_Utility.getIntegratedCircuit(2)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 2), 250, 480);
                    // Particel Card
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), new ItemStack(Items.firework_charge, 1, W), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 3), 250, 480);
                    // Spoofing Card
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 11), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 50), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Clay, 2L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 4), 250, 480);
                    // Beep Card
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), GT_ModHandler.getModItem("computronics", "computronics.speaker", 1L, 0), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 5), 250, 480);
                    // Self Destruction Card
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 66), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), GT_ModHandler.getModItem("IC2", "blockITNT", 2L, 0), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 6), 250, 256);
                    // Colorful Upgrade
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), ItemList.Circuit_Parts_TransistorSMD.get(2L), GT_ModHandler.getModItem("computronics", "computronics.colorfulLamp", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 4L, 96), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 7), 250, 480);
                    // Noise Card
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 5), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 1), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 27), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 2L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 8), 250, 480);
                    // Sound Card
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 8), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 38), GT_ModHandler.getModItem("OpenComputers", "item", 1L, 29), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 9), 250, 1024);
                    // Light Board
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("computronics", "computronics.colorfulLamp", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 2L), ItemList.Dye_SquidInk.get(4L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 10), 250, 256);
                    // Server Selfdestructor
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("computronics", "computronics.ocParts", 2L, 6), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), ItemList.Dye_SquidInk.get(4L), GT_ModHandler.getModItem("IC2", "blockITNT", 2L, 0), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 11), 250, 256);
                    // Rack Capacitor
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 2L), ItemList.Dye_SquidInk.get(4L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 12), 250, 256);
                    // Switch Board
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24), new ItemStack(Blocks.stone_button, 64, 30720), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 2L), ItemList.Dye_SquidInk.get(4L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 13), 250, 256);
                    // Speech Upgrade
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("computronics", "computronics.speechBox", 1L, 0), ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), ItemList.Circuit_Parts_TransistorSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 14), 250, 256);
                    // Drone Docking Station
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L), GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25), ItemList.Circuit_Parts_TransistorSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 2L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("computronics", "computronics.droneStation", 1L, 0), 250, 480);
                    // Drone Docking Station Upgrade
                    GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("computronics", "computronics.droneStation", 1L, 0), GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26), ItemList.Circuit_Parts_TransistorSMD.get(2L), GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L), GT_Utility.getIntegratedCircuit(1)}, tMat.getMolten(144L * tMultiplier / 2L), GT_ModHandler.getModItem("computronics", "computronics.dockingUpgrade", 1L, 0), 250, 480);
                }

                if (Loader.isModLoaded("harvestcraft")) {
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "catfishrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "crayfishrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "jellyfishrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "mudfishrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "greenheartfishItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "catfishrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "anchovyrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "bassrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "carprawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "octopusrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "charrrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "clamrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "crabrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "crayfishrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "eelrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "frograwItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "grouperrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "herringrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "perchrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "scalloprawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "shrimprawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "snailrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "snapperrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "tilapiarawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "troutrawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "tunarawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "turtlerawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                    GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getModItem("harvestcraft", "walleyerawItem", 1, 0), GT_Values.NI, Materials.FishOil.getFluid(50L), 10000, 16, 4);
                }
            }
        }

        if (Loader.isModLoaded("irontank")) {
            // Copper Tank
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("BuildCraft|Factory", "tankBlock", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 1L), GT_Utility.getIntegratedCircuit(4)}, Materials.Glass.getMolten(144L), GT_ModHandler.getModItem("irontank", "copperTank", 1L, 0), 300, 30);
            // Iron Tank
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("BuildCraft|Factory", "tankBlock", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L), GT_Utility.getIntegratedCircuit(4)}, Materials.Glass.getMolten(144L), GT_ModHandler.getModItem("irontank", "ironTank", 1L, 0), 400, 30);
            // Steel Tank
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("BuildCraft|Factory", "tankBlock", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 1L), GT_Utility.getIntegratedCircuit(4)}, Materials.Glass.getMolten(144L), GT_ModHandler.getModItem("irontank", "silverTank", 1L, 0), 500, 30);
            // Gold Tank
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("BuildCraft|Factory", "tankBlock", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L), GT_Utility.getIntegratedCircuit(4)}, Materials.Glass.getMolten(144L), GT_ModHandler.getModItem("irontank", "goldTank", 1L, 0), 600, 30);
            // Diamond Tank
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("BuildCraft|Factory", "tankBlock", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L), GT_Utility.getIntegratedCircuit(4)}, Materials.Glass.getMolten(144L), GT_ModHandler.getModItem("irontank", "diamondTank", 1L, 0), 800, 30);
            // Obsidian Tank
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("BuildCraft|Factory", "tankBlock", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Obsidian, 1L), GT_Utility.getIntegratedCircuit(4)}, Materials.Glass.getMolten(144L), GT_ModHandler.getModItem("irontank", "obsidianTank", 1L, 0), 900, 30);
            // Aluminium Tank
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("BuildCraft|Factory", "tankBlock", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Aluminium, 1L), GT_Utility.getIntegratedCircuit(4)}, Materials.Glass.getMolten(144L), GT_ModHandler.getModItem("irontank", "emeraldTank", 1L, 0), 1000, 60);
            // Stainless Steel Tank
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("BuildCraft|Factory", "tankBlock", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.StainlessSteel, 1L), GT_Utility.getIntegratedCircuit(4)}, Materials.Glass.getMolten(144L), GT_ModHandler.getModItem("irontank", "stainlesssteelTank", 1L, 0), 1100, 120);
            // Titanium Tank
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("BuildCraft|Factory", "tankBlock", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Titanium, 1L), GT_Utility.getIntegratedCircuit(4)}, Materials.Glass.getMolten(144L), GT_ModHandler.getModItem("irontank", "titaniumTank", 1L, 0), 1200, 256);
            // Tungsten Steel Tank
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("BuildCraft|Factory", "tankBlock", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TungstenSteel, 1L), GT_Utility.getIntegratedCircuit(4)}, Materials.Glass.getMolten(144L), GT_ModHandler.getModItem("irontank", "tungstensteelTank", 1L, 0), 1300, 480);

            // --- Upgrade Glass to Copper Tank
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 1L), GT_Utility.getIntegratedCircuit(4)}, Materials.Glass.getMolten(72L), GT_ModHandler.getModItem("irontank", "glassCopperUpgrade", 1L, 0), 300, 30);
            // --- Upgrade Glass to Iron Tank
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L), GT_Utility.getIntegratedCircuit(4)}, Materials.Glass.getMolten(72L), GT_ModHandler.getModItem("irontank", "glassIronUpgrade", 1L, 0), 400, 30);
            // --- Upgrade Copper to Iron Tank
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 1L), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L), GT_Utility.getIntegratedCircuit(4)}, Materials.Glass.getMolten(72L), GT_ModHandler.getModItem("irontank", "copperIronUpgrade", 1L, 0), 500, 30);
            // --- Upgrade Copper to Steel Tank
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 1L), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 1L), GT_Utility.getIntegratedCircuit(4)}, Materials.Glass.getMolten(72L), GT_ModHandler.getModItem("irontank", "copperSilverUpgrade", 1L, 0), 600, 30);
            // --- Upgrade Iron to Gold Tank
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L), GT_Utility.getIntegratedCircuit(4)}, Materials.Glass.getMolten(72L), GT_ModHandler.getModItem("irontank", "ironGoldUpgrade", 1L, 0), 700, 30);
            // --- Upgrade Steel to Gold Tank
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L), GT_Utility.getIntegratedCircuit(4)}, Materials.Glass.getMolten(72L), GT_ModHandler.getModItem("irontank", "silverGoldUpgrade", 1L, 0), 700, 30);
            // --- Upgrade Steel to Diamond Tank
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 2L), GT_Utility.getIntegratedCircuit(4)}, Materials.Glass.getMolten(72L), GT_ModHandler.getModItem("irontank", "silverDiamondUpgrade", 1L, 0), 800, 30);
            // --- Upgrade Diamond to Obsidian
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L), GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Obsidian, 1L), GT_Utility.getIntegratedCircuit(4)}, Materials.Glass.getMolten(72L), GT_ModHandler.getModItem("irontank", "diamondObsidianUpgrade", 1L, 0), 900, 30);
            // --- Upgrade Diamond to Aluminium Tank
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Aluminium, 1L), GT_Utility.getIntegratedCircuit(4)}, Materials.Glass.getMolten(72L), GT_ModHandler.getModItem("irontank", "diamondEmeraldUpgrade", 1L, 0), 1000, 60);
            // --- Upgrade Aluminium to Stainless Steel Tank
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1L), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.StainlessSteel, 1L), GT_Utility.getIntegratedCircuit(4)}, Materials.Glass.getMolten(72L), GT_ModHandler.getModItem("irontank", "emeraldStainlesssteelUpgrade", 1L, 0), 1100, 120);
            // --- Upgrade Stainless Steel to Titanium Tank
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1L), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Titanium, 1L), GT_Utility.getIntegratedCircuit(4)}, Materials.Glass.getMolten(72L), GT_ModHandler.getModItem("irontank", "stainlesssteelTitaniumUpgrade", 1L, 0), 1200, 256);
            // --- Upgrade Titanium to Tungsten Steel Tank
            GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1L), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TungstenSteel, 1L), GT_Utility.getIntegratedCircuit(4)}, Materials.Glass.getMolten(72L), GT_ModHandler.getModItem("irontank", "titaniumTungstensteelUpgrade", 1L, 0), 1300, 480);
        }

        //Neutron reflector recipes. NR is in IC2 script, INR in GT script
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("IC2", "reactorReflector", 1L, 1), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, CustomItemList.NeutronReflectorSmallParts.get(1), 300, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{CustomItemList.NeutronReflectorSmallParts.get(5L), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Beryllium, 2L)}, GT_Values.NF, GT_ModHandler.getModItem("IC2", "reactorReflectorThick", 1L, 0), 600, 64);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{CustomItemList.NeutronReflectorSmallParts.get(5L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenCarbide, 2L)}, GT_Values.NF, GT_ModHandler.getModItem("IC2", "reactorReflectorThick", 1L, 0), 600, 64);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("IC2", "reactorReflectorThick", 1L, 0), GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, CustomItemList.NeutronReflectorParts.get(1), 600, 120);

        //Arcane Slabs -> Arcane Stone
        if (Loader.isModLoaded("Thaumcraft"))
            GT_Values.RA.addCompressorRecipe(GT_ModHandler.getModItem("Thaumcraft", "blockCosmeticSlabStone", 4L), GT_ModHandler.getModItem("Thaumcraft", "blockCosmeticSolid", 1L, 6), 160, 4);

        //Astral Silver & Soldering Alloy + reverse
        GT_Values.RA.addMixerRecipe(Materials.Silver.getDust(2), Materials.Thaumium.getDust(1), GT_Utility.getIntegratedCircuit(1), null, null, null, Materials.AstralSilver.getDust(3), 60, 480);
        GT_Values.RA.addMixerRecipe(Materials.Tin.getDust(9), Materials.Antimony.getDust(1), GT_Utility.getIntegratedCircuit(1), null, null, null, Materials.SolderingAlloy.getDust(10), 60, 30);
        GT_Values.RA.addCentrifugeRecipe(Materials.AstralSilver.getDust(3), null, null, null, Materials.Silver.getDust(2), Materials.Thaumium.getDust(1), null, null, null, null, null, 300, 480);
        GT_Values.RA.addCentrifugeRecipe(Materials.SolderingAlloy.getDust(10), null, null, null, Materials.Tin.getDust(9), Materials.Antimony.getDust(1), null, null, null, null, null, 300, 30);

        //Liquid Fertilizer reverse recipe
        GT_Values.RA.addCentrifugeRecipe(GT_Utility.getIntegratedCircuit(1), null, FluidRegistry.getFluidStack("fluid.fertiliser", 144), null, ItemList.IC2_Fertilizer.get(1L), null, null, null, null, null, null, 40, 16);

        //Mainframe Circuits and Neuro CPU
        GT_Values.RA.addAssemblylineRecipe(ItemList.Circuit_Crystalmainframe.get(1L), 72000, new Object[]{
                ItemList.Circuit_Board_Wetware_Extreme.get(1L),
                ItemList.Circuit_Chip_Stemcell.get(16L),
                ItemList.Circuit_Parts_Reinforced_Glass_Tube.get(16L),
                GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Polybenzimidazole, 8L),
                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.ElectrumFlux, 4L),
                new Object[]{OrePrefixes.foil.get(Materials.AnySyntheticRubber), 64L},
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSS, 32L),
        }, new FluidStack[]{
                Materials.GrowthMediumSterilized.getFluid(250L),
                Materials.UUMatter.getFluid(250L),
                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000)
        }, ItemList.Circuit_Chip_NeuroCPU.get(1L), 600, 80000);

        GT_Values.RA.addAssemblylineRecipe(ItemList.Circuit_Chip_NeuroCPU.get(1L), 144000, new Object[]{
                ItemList.Circuit_Board_Bio_Ultra.get(1L),
                ItemList.Circuit_Chip_Biocell.get(16L),
                ItemList.Circuit_Parts_Reinforced_Glass_Tube.get(16L),
                GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Polybenzimidazole, 16),
                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Tungsten, 16L),
                new Object[]{OrePrefixes.foil.get(Materials.AnySyntheticRubber), 64L},
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 32L),
        }, new FluidStack[]{
                Materials.BioMediumSterilized.getFluid(500L),
                Materials.UUMatter.getFluid(500L),
                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000)
        }, ItemList.Circuit_Chip_BioCPU.get(1L), 600, 600000);

        GT_Values.RA.addAssemblylineRecipe(ItemList.Energy_LapotronicOrb.get(1L), 288000, new Object[]{
                ItemList.Circuit_Board_Multifiberglass.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NaquadahAlloy, 64L),
                new Object[]{OrePrefixes.circuit.get(Materials.Master), 4L},
                ItemList.Circuit_Parts_Crystal_Chip_Master.get(36L),
                ItemList.Circuit_Parts_Crystal_Chip_Master.get(36L),
                ItemList.Circuit_Chip_HPIC.get(64L),
                ItemList.Circuit_Parts_DiodeASMD.get(8L),
                ItemList.Circuit_Parts_CapacitorASMD.get(8L),
                ItemList.Circuit_Parts_ResistorASMD.get(8L),
                ItemList.Circuit_Parts_TransistorASMD.get(8L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 64),
        }, new FluidStack[]{
                Materials.SolderingAlloy.getMolten(720L)
        }, ItemList.Energy_LapotronicOrb2.get(1L), 1000, 80000);

        if (Loader.isModLoaded("GraviSuite")) {
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "graviChestPlate", 1, GT_Values.W));

            GT_Values.RA.addAssemblylineRecipe(GT_ModHandler.getIC2Item("quantumBodyarmor", 1L, GT_Values.W), 144000, new Object[]{
                    GT_ModHandler.getIC2Item("quantumBodyarmor", 1L, 1),
                    ItemList.Transformer_ZPM_LuV.get(1L),
                    GT_ModHandler.getModItem("GraviSuite", "ultimateLappack", 1, 1),
                    GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 6, 1),
                    GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 2, 2),
                    GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 2, 3),
                    new Object[]{OrePrefixes.circuit.get(Materials.Ultimate), 2L},
                    GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Duranium, 2),
                    ItemList.Energy_LapotronicOrb2.get(1L),
                    ItemList.Field_Generator_IV.get(2L),
                    ItemList.Electric_Motor_ZPM.get(2L),
                    GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Duranium, 4)
            }, new FluidStack[]{
                    Materials.SolderingAlloy.getMolten(2304L),
                    Materials.Tritanium.getMolten(1440L)
            }, GT_ModHandler.getModItem("GraviSuite", "graviChestPlate", 1, 26), 1500, 16388);

            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "relocator", 1, GT_Values.W));

            GT_Values.RA.addAssemblylineRecipe(ItemList.Casing_Coil_Superconductor.get(1L), 288000, new Object[]{
                    ItemList.Casing_Fusion_Coil.get(16L),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUV, 16L),
                    new Object[]{OrePrefixes.circuit.get(Materials.Superconductor), 16L},
                    ItemList.Sensor_UV.get(16L),
                    ItemList.Emitter_UV.get(16L),
                    ItemList.Field_Generator_UV.get(8L),
                    ItemList.Circuit_Wafer_QPIC.get(64L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L)
            }, new FluidStack[]{
                    Materials.Longasssuperconductornameforuvwire.getMolten(2880L),
                    Materials.Americium.getPlasma(2880L),
                    Materials.Enderium.getMolten(5760L)
            }, GT_ModHandler.getModItem("GraviSuite", "relocator", 1, 26), 60000, 500000);
        }
    }

    private final static boolean make_floppy(String displayname, String name, int color, int circuit) {
        ItemStack floppy = GT_ModHandler.getModItem("OpenComputers", "item", 1L, 4);
        NBTTagCompound tag = new NBTTagCompound(),
                subtag = new NBTTagCompound();
        subtag.setString("Name", displayname);
        tag.setTag("display", subtag);
        subtag = new NBTTagCompound();
        subtag.setString("oc:fs.label", name);
        tag.setTag("oc:data", subtag);
        tag.setInteger("oc:color", color);
        tag.setString("oc:lootFactory", "OpenComputers:" + name);
        floppy.setTagCompound(tag);
        return GT_Values.RA.addLaserEngraverRecipe(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 4), GT_Utility.getIntegratedCircuit(circuit), floppy, 200, 120);
    }

    private final static boolean make_lua_bios() {
        ItemStack lua = GT_ModHandler.getModItem("OpenComputers", "eeprom", 1L, 0);
        NBTTagCompound tag = new NBTTagCompound(),
                subtag = new NBTTagCompound();
        subtag.setString("oc:label", "EEPROM (Lua Bios)");
        subtag.setBoolean("oc:readonly", false);
        final byte[] b = {
                108, 111, 99, 97, 108, 32, 99, 111, 109, 112, 111, 110, 101, 110, 116, 95, 105, 110, 118, 111, 107,
                101, 32, 61, 32, 99, 111, 109, 112, 111, 110, 101, 110, 116, 46, 105, 110, 118, 111, 107, 101, 10, 102, 117,
                110, 99, 116, 105, 111, 110, 32, 98, 111, 111, 116, 95, 105, 110, 118, 111, 107, 101, 40, 97, 100, 100, 114,
                101, 115, 115, 44, 32, 109, 101, 116, 104, 111, 100, 44, 32, 46, 46, 46, 41, 10, 32, 32, 108, 111, 99, 97,
                108, 32, 114, 101, 115, 117, 108, 116, 32, 61, 32, 116, 97, 98, 108, 101, 46, 112, 97, 99, 107, 40, 112, 99,
                97, 108, 108, 40, 99, 111, 109, 112, 111, 110, 101, 110, 116, 95, 105, 110, 118, 111, 107, 101, 44, 32, 97,
                100, 100, 114, 101, 115, 115, 44, 32, 109, 101, 116, 104, 111, 100, 44, 32, 46, 46, 46, 41, 41, 10, 32, 32,
                105, 102, 32, 110, 111, 116, 32, 114, 101, 115, 117, 108, 116, 91, 49, 93, 32, 116, 104, 101, 110, 10, 32, 32,
                32, 32, 114, 101, 116, 117, 114, 110, 32, 110, 105, 108, 44, 32, 114, 101, 115, 117, 108, 116, 91, 50, 93, 10,
                32, 32, 101, 108, 115, 101, 10, 32, 32, 32, 32, 114, 101, 116, 117, 114, 110, 32, 116, 97, 98, 108, 101, 46,
                117, 110, 112, 97, 99, 107, 40, 114, 101, 115, 117, 108, 116, 44, 32, 50, 44, 32, 114, 101, 115, 117, 108, 116,
                46, 110, 41, 10, 32, 32, 101, 110, 100, 10, 101, 110, 100, 10, 10, 45, 45, 32, 98, 97, 99, 107, 119, 97, 114,
                100, 115, 32, 99, 111, 109, 112, 97, 116, 105, 98, 105, 108, 105, 116, 121, 44, 32, 109, 97, 121, 32, 114, 101,
                109, 111, 118, 101, 32, 108, 97, 116, 101, 114, 10, 108, 111, 99, 97, 108, 32, 101, 101, 112, 114, 111, 109, 32,
                61, 32, 99, 111, 109, 112, 111, 110, 101, 110, 116, 46, 108, 105, 115, 116, 40, 34, 101, 101, 112, 114, 111, 109,
                34, 41, 40, 41, 10, 99, 111, 109, 112, 117, 116, 101, 114, 46, 103, 101, 116, 66, 111, 111, 116, 65, 100, 100,
                114, 101, 115, 115, 32, 61, 32, 102, 117, 110, 99, 116, 105, 111, 110, 40, 41, 10, 32, 32, 114, 101, 116, 117,
                114, 110, 32, 98, 111, 111, 116, 95, 105, 110, 118, 111, 107, 101, 40, 101, 101, 112, 114, 111, 109, 44, 32, 34,
                103, 101, 116, 68, 97, 116, 97, 34, 41, 10, 101, 110, 100, 10, 99, 111, 109, 112, 117, 116, 101, 114, 46, 115,
                101, 116, 66, 111, 111, 116, 65, 100, 100, 114, 101, 115, 115, 32, 61, 32, 102, 117, 110, 99, 116, 105, 111, 110,
                40, 97, 100, 100, 114, 101, 115, 115, 41, 10, 32, 32, 114, 101, 116, 117, 114, 110, 32, 98, 111, 111, 116, 95,
                105, 110, 118, 111, 107, 101, 40, 101, 101, 112, 114, 111, 109, 44, 32, 34, 115, 101, 116, 68, 97, 116, 97, 34,
                44, 32, 97, 100, 100, 114, 101, 115, 115, 41, 10, 101, 110, 100, 10, 10, 100, 111, 10, 32, 32, 108, 111, 99, 97,
                108, 32, 115, 99, 114, 101, 101, 110, 32, 61, 32, 99, 111, 109, 112, 111, 110, 101, 110, 116, 46, 108, 105, 115,
                116, 40, 34, 115, 99, 114, 101, 101, 110, 34, 41, 40, 41, 10, 32, 32, 108, 111, 99, 97, 108, 32, 103, 112, 117,
                32, 61, 32, 99, 111, 109, 112, 111, 110, 101, 110, 116, 46, 108, 105, 115, 116, 40, 34, 103, 112, 117, 34, 41,
                40, 41, 10, 32, 32, 105, 102, 32, 103, 112, 117, 32, 97, 110, 100, 32, 115, 99, 114, 101, 101, 110, 32, 116, 104,
                101, 110, 10, 32, 32, 32, 32, 98, 111, 111, 116, 95, 105, 110, 118, 111, 107, 101, 40, 103, 112, 117, 44, 32, 34,
                98, 105, 110, 100, 34, 44, 32, 115, 99, 114, 101, 101, 110, 41, 10, 32, 32, 101, 110, 100, 10, 101, 110, 100, 10,
                108, 111, 99, 97, 108, 32, 102, 117, 110, 99, 116, 105, 111, 110, 32, 116, 114, 121, 76, 111, 97, 100, 70, 114,
                111, 109, 40, 97, 100, 100, 114, 101, 115, 115, 41, 10, 32, 32, 108, 111, 99, 97, 108, 32, 104, 97, 110, 100, 108,
                101, 44, 32, 114, 101, 97, 115, 111, 110, 32, 61, 32, 98, 111, 111, 116, 95, 105, 110, 118, 111, 107, 101, 40, 97,
                100, 100, 114, 101, 115, 115, 44, 32, 34, 111, 112, 101, 110, 34, 44, 32, 34, 47, 105, 110, 105, 116, 46, 108, 117,
                97, 34, 41, 10, 32, 32, 105, 102, 32, 110, 111, 116, 32, 104, 97, 110, 100, 108, 101, 32, 116, 104, 101, 110, 10,
                32, 32, 32, 32, 114, 101, 116, 117, 114, 110, 32, 110, 105, 108, 44, 32, 114, 101, 97, 115, 111, 110, 10, 32, 32,
                101, 110, 100, 10, 32, 32, 108, 111, 99, 97, 108, 32, 98, 117, 102, 102, 101, 114, 32, 61, 32, 34, 34, 10, 32, 32,
                114, 101, 112, 101, 97, 116, 10, 32, 32, 32, 32, 108, 111, 99, 97, 108, 32, 100, 97, 116, 97, 44, 32, 114, 101, 97,
                115, 111, 110, 32, 61, 32, 98, 111, 111, 116, 95, 105, 110, 118, 111, 107, 101, 40, 97, 100, 100, 114, 101, 115, 115,
                44, 32, 34, 114, 101, 97, 100, 34, 44, 32, 104, 97, 110, 100, 108, 101, 44, 32, 109, 97, 116, 104, 46, 104, 117, 103,
                101, 41, 10, 32, 32, 32, 32, 105, 102, 32, 110, 111, 116, 32, 100, 97, 116, 97, 32, 97, 110, 100, 32, 114, 101, 97,
                115, 111, 110, 32, 116, 104, 101, 110, 10, 32, 32, 32, 32, 32, 32, 114, 101, 116, 117, 114, 110, 32, 110, 105, 108,
                44, 32, 114, 101, 97, 115, 111, 110, 10, 32, 32, 32, 32, 101, 110, 100, 10, 32, 32, 32, 32, 98, 117, 102, 102, 101,
                114, 32, 61, 32, 98, 117, 102, 102, 101, 114, 32, 46, 46, 32, 40, 100, 97, 116, 97, 32, 111, 114, 32, 34, 34, 41, 10,
                32, 32, 117, 110, 116, 105, 108, 32, 110, 111, 116, 32, 100, 97, 116, 97, 10, 32, 32, 98, 111, 111, 116, 95, 105, 110,
                118, 111, 107, 101, 40, 97, 100, 100, 114, 101, 115, 115, 44, 32, 34, 99, 108, 111, 115, 101, 34, 44, 32, 104, 97, 110,
                100, 108, 101, 41, 10, 32, 32, 114, 101, 116, 117, 114, 110, 32, 108, 111, 97, 100, 40, 98, 117, 102, 102, 101, 114, 44,
                32, 34, 61, 105, 110, 105, 116, 34, 41, 10, 101, 110, 100, 10, 108, 111, 99, 97, 108, 32, 105, 110, 105, 116, 44, 32,
                114, 101, 97, 115, 111, 110, 10, 105, 102, 32, 99, 111, 109, 112, 117, 116, 101, 114, 46, 103, 101, 116, 66, 111, 111,
                116, 65, 100, 100, 114, 101, 115, 115, 40, 41, 32, 116, 104, 101, 110, 10, 32, 32, 105, 110, 105, 116, 44, 32, 114, 101,
                97, 115, 111, 110, 32, 61, 32, 116, 114, 121, 76, 111, 97, 100, 70, 114, 111, 109, 40, 99, 111, 109, 112, 117, 116, 101,
                114, 46, 103, 101, 116, 66, 111, 111, 116, 65, 100, 100, 114, 101, 115, 115, 40, 41, 41, 10, 101, 110, 100, 10, 105, 102,
                32, 110, 111, 116, 32, 105, 110, 105, 116, 32, 116, 104, 101, 110, 10, 32, 32, 99, 111, 109, 112, 117, 116, 101, 114, 46,
                115, 101, 116, 66, 111, 111, 116, 65, 100, 100, 114, 101, 115, 115, 40, 41, 10, 32, 32, 102, 111, 114, 32, 97, 100, 100,
                114, 101, 115, 115, 32, 105, 110, 32, 99, 111, 109, 112, 111, 110, 101, 110, 116, 46, 108, 105, 115, 116, 40, 34, 102,
                105, 108, 101, 115, 121, 115, 116, 101, 109, 34, 41, 32, 100, 111, 10, 32, 32, 32, 32, 105, 110, 105, 116, 44, 32, 114,
                101, 97, 115, 111, 110, 32, 61, 32, 116, 114, 121, 76, 111, 97, 100, 70, 114, 111, 109, 40, 97, 100, 100, 114, 101, 115,
                115, 41, 10, 32, 32, 32, 32, 105, 102, 32, 105, 110, 105, 116, 32, 116, 104, 101, 110, 10, 32, 32, 32, 32, 32, 32, 99,
                111, 109, 112, 117, 116, 101, 114, 46, 115, 101, 116, 66, 111, 111, 116, 65, 100, 100, 114, 101, 115, 115, 40, 97, 100,
                100, 114, 101, 115, 115, 41, 10, 32, 32, 32, 32, 32, 32, 98, 114, 101, 97, 107, 10, 32, 32, 32, 32, 101, 110, 100, 10,
                32, 32, 101, 110, 100, 10, 101, 110, 100, 10, 105, 102, 32, 110, 111, 116, 32, 105, 110, 105, 116, 32, 116, 104, 101,
                110, 10, 32, 32, 101, 114, 114, 111, 114, 40, 34, 110, 111, 32, 98, 111, 111, 116, 97, 98, 108, 101, 32, 109, 101, 100,
                105, 117, 109, 32, 102, 111, 117, 110, 100, 34, 32, 46, 46, 32, 40, 114, 101, 97, 115, 111, 110, 32, 97, 110, 100, 32,
                40, 34, 58, 32, 34, 32, 46, 46, 32, 116, 111, 115, 116, 114, 105, 110, 103, 40, 114, 101, 97, 115, 111, 110, 41, 41, 32,
                111, 114, 32, 34, 34, 41, 44, 32, 48, 41, 10, 101, 110, 100, 10, 99, 111, 109, 112, 117, 116, 101, 114, 46, 98, 101, 101,
                112, 40, 49, 48, 48, 48, 44, 32, 48, 46, 50, 41, 10, 105, 110, 105, 116, 40, 41
        };
        subtag.setByteArray("oc:eeprom", b);
        tag.setTag("oc:data", subtag);
        lua.setTagCompound(tag);
        return GT_Values.RA.addLaserEngraverRecipe(GT_ModHandler.getModItem("OpenComputers", "eeprom", 1L, 0), GT_Utility.getIntegratedCircuit(1), lua, 200, 120);
    }
}
