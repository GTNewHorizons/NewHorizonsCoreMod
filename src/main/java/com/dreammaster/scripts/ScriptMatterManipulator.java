package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AE2FluidCraft;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.GraviSuite;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.MatterManipulator;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicTinkerer;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.INGOTS;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.WILDCARD;
import static gregtech.api.util.GTRecipeConstants.AssemblyLine;
import static gregtech.api.util.GTRecipeConstants.RESEARCH_ITEM;
import static gregtech.api.util.GTRecipeConstants.SCANNING;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.recursive_pineapple.matter_manipulator.common.items.MMItemList;

import appeng.api.AEApi;
import appeng.api.util.AEColor;
import bartworks.system.material.WerkstoffLoader;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.Mods;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.recipe.RecipeMaps;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gregtech.api.util.recipe.Scanning;
import gtPlusPlus.core.item.ModItems;
import gtPlusPlus.core.material.MaterialsAlloy;
import gtPlusPlus.core.material.MaterialsElements;
import tectech.recipe.TTRecipeAdder;
import tectech.thing.CustomItemList;

@SuppressWarnings("deprecation")
public class ScriptMatterManipulator implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Matter Manipulator";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                AE2FluidCraft.ID,
                AppliedEnergistics2.ID,
                EnderIO.ID,
                GraviSuite.ID,
                MatterManipulator.ID,
                Thaumcraft.ID,
                ThaumicTinkerer.ID);
    }

    @Override
    public void loadRecipes() {
        addMK0Recipes();
        addMK1Recipes();
        addMK2Recipes();
        addMK3Recipe();
        addUplinkRecipes();
        addUpgradeRecipes();
    }

    private static void addMK0Recipes() {
        // Power core MK0
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.getIntegratedCircuit(5),
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.StainlessSteel, 8),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, WILDCARD), // energy crystal
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorHV, 12),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 2),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(INGOTS * 4)).itemOutputs(MMItemList.PowerCore0.get(1))
                .eut((int) TierEU.RECIPE_HV).duration(20 * SECONDS).addTo(RecipeMaps.assemblerRecipes);

        // Computer core MK0
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.getIntegratedCircuit(5),
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.StainlessSteel, 8),
                        new Object[] { OrePrefixes.circuit.get(Materials.IV), 2 },
                        getModItem(EnderIO.ID, "blockEndermanSkull", 1, 2), // tormented enderman skull
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorHV, 12),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 16))
                .fluidInputs(Materials.SolderingAlloy.getMolten(INGOTS * 8))
                .itemOutputs(MMItemList.ComputerCore0.get(1)).eut((int) TierEU.RECIPE_HV).duration(20 * SECONDS)
                .addTo(RecipeMaps.circuitAssemblerRecipes);

        // Teleporter core MK0
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.getIntegratedCircuit(5),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 1),
                        ItemList.Emitter_HV.get(2),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 15), // primal charm
                        ItemList.QuantumEye.get(2),
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.Thaumium, 8),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Thaumium, 16))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 2000)).itemOutputs(MMItemList.TeleporterCore0.get(1))
                .eut((int) TierEU.RECIPE_HV).duration(20 * SECONDS).addTo(RecipeMaps.assemblerRecipes);

        // Frame MK0
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.getIntegratedCircuit(10),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 16))
                .itemOutputs(MMItemList.Frame0.get(1)).eut((int) TierEU.RECIPE_HV).duration(20 * SECONDS)
                .addTo(RecipeMaps.benderRecipes);

        // Lens MK0
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.getIntegratedCircuit(5),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.StainlessSteel, 4),
                        getModItem(Thaumcraft.ID, "FocusTrade", 1), // equal trade focus
                        ItemList.Field_Generator_LV.get(1),
                        ItemList.Electric_Piston_HV.get(2),
                        ItemList.Electric_Motor_HV.get(2))
                .fluidInputs(Materials.SolderingAlloy.getMolten(INGOTS * 4)).itemOutputs(MMItemList.Lens0.get(1))
                .eut((int) TierEU.RECIPE_HV).duration(20 * SECONDS).addTo(RecipeMaps.assemblerRecipes);

        // Manipulator MK0
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.getIntegratedCircuit(5),
                        MMItemList.Lens0.get(1),
                        MMItemList.TeleporterCore0.get(1),
                        MMItemList.ComputerCore0.get(1),
                        MMItemList.PowerCore0.get(1),
                        MMItemList.Frame0.get(1))
                .fluidInputs(Materials.SolderingAlloy.getMolten(INGOTS * 8)).itemOutputs(MMItemList.MK0.get(1))
                .eut((int) TierEU.RECIPE_HV).duration(30 * SECONDS).addTo(RecipeMaps.assemblerRecipes);

    }

    private static void addMK1Recipes() {
        // Power core MK1
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.getIntegratedCircuit(5),
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 8),
                        ItemList.Energy_LapotronicOrb.get(1),
                        ItemList.Circuit_Chip_PIC.get(4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorIV, 6),
                        new Object[] { OrePrefixes.circuit.get(Materials.IV), 2 },
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 16))
                .fluidInputs(MaterialsAlloy.INDALLOY_140.getFluidStack(INGOTS * 8))
                .itemOutputs(MMItemList.PowerCore1.get(1)).eut((int) TierEU.RECIPE_IV).duration(20 * SECONDS)
                .addTo(RecipeMaps.assemblerRecipes);

        // Computer core MK1
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.getIntegratedCircuit(5),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 1),
                        new Object[] { OrePrefixes.circuit.get(Materials.ZPM), 2 },
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorIV, 12),
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 8),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 16))
                .fluidInputs(MaterialsAlloy.INDALLOY_140.getFluidStack(INGOTS * 16))
                .itemOutputs(MMItemList.ComputerCore1.get(1)).eut((int) TierEU.RECIPE_IV).duration(20 * SECONDS)
                .addTo(RecipeMaps.circuitAssemblerRecipes);

        // Teleporter core MK1
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.getIntegratedCircuit(5),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Enderium, 1),
                        getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 0), // teleporter
                        ItemList.Emitter_IV.get(2),
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 8),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 16))
                .fluidInputs(MaterialsAlloy.INDALLOY_140.getFluidStack(INGOTS * 16))
                .itemOutputs(MMItemList.TeleporterCore1.get(1)).eut((int) TierEU.RECIPE_IV).duration(20 * SECONDS)
                .addTo(RecipeMaps.assemblerRecipes);

        // Frame MK1
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.getIntegratedCircuit(10),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 32))
                .itemOutputs(MMItemList.Frame1.get(1)).eut((int) TierEU.RECIPE_IV).duration(20 * SECONDS)
                .addTo(RecipeMaps.benderRecipes);

        // Lens MK1
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.getIntegratedCircuit(5),
                        GTOreDictUnificator.get(OrePrefixes.lens, Materials.NetherStar, 2),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.TungstenSteel, 4),
                        ItemList.Field_Generator_IV.get(1),
                        ItemList.Electric_Piston_IV.get(2),
                        ItemList.Electric_Motor_IV.get(2))
                .fluidInputs(MaterialsAlloy.INDALLOY_140.getFluidStack(INGOTS * 4)).itemOutputs(MMItemList.Lens1.get(1))
                .eut((int) TierEU.RECIPE_IV).duration(20 * SECONDS).addTo(RecipeMaps.assemblerRecipes);

        // Manipulator MK1
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.getIntegratedCircuit(5),
                        MMItemList.Lens1.get(1),
                        MMItemList.TeleporterCore1.get(1),
                        MMItemList.ComputerCore1.get(1),
                        MMItemList.PowerCore1.get(1),
                        MMItemList.Frame1.get(1),
                        MMItemList.AEDownlink.get(1))
                .fluidInputs(MaterialsAlloy.INDALLOY_140.getFluidStack(INGOTS * 16)).itemOutputs(MMItemList.MK1.get(1))
                .eut((int) TierEU.RECIPE_IV).duration(30 * SECONDS).addTo(RecipeMaps.assemblerRecipes);
    }

    private static void addMK2Recipes() {
        // Power core MK2
        GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Circuit_Chip_HPIC.get(1))
                .metadata(SCANNING, new Scanning(1 * MINUTES, TierEU.RECIPE_LuV))
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.HSSS, 8),
                        ItemList.Energy_LapotronicOrb2.get(1),
                        ItemList.Circuit_Chip_HPIC.get(4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorLuV, 6),
                        new Object[] { OrePrefixes.circuit.get(Materials.LuV), 2 },
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.HSSS, 16))
                .fluidInputs(
                        MaterialsAlloy.INDALLOY_140.getFluidStack(INGOTS * 8),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 16000))
                .itemOutputs(MMItemList.PowerCore2.get(1)).duration(1 * MINUTES).eut((int) TierEU.RECIPE_LuV)
                .addTo(AssemblyLine);

        // Computer core MK2
        GTValues.RA.stdBuilder()
                .metadata(RESEARCH_ITEM, GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.HSSS, 1))
                .metadata(SCANNING, new Scanning(1 * MINUTES, TierEU.RECIPE_LuV))
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.HSSS, 1),
                        new Object[] { OrePrefixes.circuit.get(Materials.UV), 2 },
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 18),
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.HSSS, 8),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.HSSS, 16))
                .fluidInputs(
                        MaterialsAlloy.INDALLOY_140.getFluidStack(INGOTS * 16),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 32000))
                .itemOutputs(MMItemList.ComputerCore2.get(1)).duration(1 * MINUTES).eut((int) TierEU.RECIPE_LuV)
                .addTo(AssemblyLine);

        // Teleporter core MK2
        GTValues.RA.stdBuilder()
                .metadata(RESEARCH_ITEM, GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Quantium, 1))
                .metadata(SCANNING, new Scanning(1 * MINUTES, TierEU.RECIPE_LuV))
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Quantium, 1),
                        ItemList.Emitter_LuV.get(2),
                        ItemList.Field_Generator_LuV.get(1),
                        ItemList.QuantumStar.get(4),
                        getModItem(GraviSuite.ID, "itemSimpleItem", 4, 3), // gravitation engine
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.HSSS, 8),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.HSSS, 16))
                .fluidInputs(
                        MaterialsAlloy.INDALLOY_140.getFluidStack(INGOTS * 16),
                        Materials.Quantium.getMolten(INGOTS * 16),
                        Materials.Duranium.getMolten(INGOTS * 8),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 32000))
                .itemOutputs(MMItemList.TeleporterCore2.get(1)).duration(1 * MINUTES).eut((int) TierEU.RECIPE_LuV)
                .addTo(AssemblyLine);

        // Frame MK2
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.getIntegratedCircuit(10),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.HSSS, 48))
                .itemOutputs(MMItemList.Frame2.get(1)).eut((int) TierEU.RECIPE_LuV).duration(30 * SECONDS)
                .addTo(RecipeMaps.benderRecipes);

        // Lens MK2
        GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, WerkstoffLoader.RedZircon.get(OrePrefixes.lens, 1))
                .metadata(SCANNING, new Scanning(1 * MINUTES, TierEU.RECIPE_LuV))
                .itemInputs(
                        WerkstoffLoader.RedZircon.get(OrePrefixes.lens, 2),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.HSSS, 4),
                        ItemList.Field_Generator_LuV.get(1),
                        ItemList.Electric_Motor_LuV.get(2),
                        ItemList.Electric_Piston_LuV.get(2))
                .fluidInputs(MaterialsAlloy.INDALLOY_140.getFluidStack(INGOTS * 4)).itemOutputs(MMItemList.Lens2.get(1))
                .duration(1 * MINUTES).eut((int) TierEU.RECIPE_LuV).addTo(AssemblyLine);

        // Manipulator MK2
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.getIntegratedCircuit(5),
                        MMItemList.Lens2.get(1),
                        MMItemList.TeleporterCore2.get(1),
                        MMItemList.ComputerCore2.get(1),
                        MMItemList.PowerCore2.get(1),
                        MMItemList.Frame2.get(1),
                        MMItemList.AEDownlink.get(1))
                .fluidInputs(MaterialsAlloy.INDALLOY_140.getFluidStack(INGOTS * 16)).itemOutputs(MMItemList.MK2.get(1))
                .eut((int) TierEU.RECIPE_LuV).duration(30 * SECONDS).addTo(RecipeMaps.assemblerRecipes);
    }

    private static void addMK3Recipe() {
        // Power core MK3
        GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Circuit_Chip_UHPIC.get(1))
                .metadata(SCANNING, new Scanning(2 * MINUTES, TierEU.RECIPE_ZPM))
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.NaquadahAlloy, 8),
                        ItemList.Energy_Module.get(1),
                        ItemList.Circuit_Chip_UHPIC.get(8),
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorZPM, 12),
                        new Object[] { OrePrefixes.circuit.get(Materials.ZPM), 2 },
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.NaquadahAlloy, 16))
                .fluidInputs(
                        MaterialsAlloy.INDALLOY_140.getFluidStack(INGOTS * 16),
                        Materials.SuperCoolant.getFluid(32000))
                .itemOutputs(MMItemList.PowerCore3.get(1)).duration(1 * MINUTES).eut((int) TierEU.RECIPE_ZPM)
                .addTo(AssemblyLine);

        // Computer core MK3
        GTValues.RA.stdBuilder()
                .metadata(RESEARCH_ITEM, GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.NaquadahAlloy, 1))
                .metadata(SCANNING, new Scanning(2 * MINUTES, TierEU.RECIPE_ZPM))
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.NaquadahAlloy, 1),
                        new Object[] { OrePrefixes.circuit.get(Materials.UV), 2 },
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorZPM, 30),
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.NaquadahAlloy, 8),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.NaquadahAlloy, 16))
                .fluidInputs(
                        MaterialsAlloy.INDALLOY_140.getFluidStack(INGOTS * 32),
                        Materials.SuperCoolant.getFluid(64000))
                .itemOutputs(MMItemList.ComputerCore3.get(1)).duration(1 * MINUTES).eut((int) TierEU.RECIPE_ZPM)
                .addTo(AssemblyLine);

        // Teleporter core MK3
        GTValues.RA.stdBuilder()
                .metadata(RESEARCH_ITEM, GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.MysteriousCrystal, 1))
                .metadata(SCANNING, new Scanning(2 * MINUTES, TierEU.RECIPE_ZPM))
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.MysteriousCrystal, 1),
                        ItemList.Emitter_ZPM.get(2),
                        ItemList.Field_Generator_ZPM.get(1),
                        ItemList.Gravistar.get(4),
                        new ItemStack(ModItems.itemStandarParticleBase, 16, 0), // gravitons
                        getModItem(GraviSuite.ID, "itemSimpleItem", 16, 3), // gravitation engine
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.Trinium, 8),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Trinium, 16))
                .fluidInputs(
                        MaterialsAlloy.INDALLOY_140.getFluidStack(INGOTS * 16),
                        Materials.MysteriousCrystal.getMolten(INGOTS * 16),
                        Materials.Tritanium.getMolten(INGOTS * 16),
                        Materials.SuperCoolant.getFluid(32000))
                .itemOutputs(MMItemList.TeleporterCore3.get(1)).duration(1 * MINUTES).eut((int) TierEU.RECIPE_ZPM)
                .addTo(AssemblyLine);

        // Frame MK3
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.getIntegratedCircuit(10),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 64))
                .itemOutputs(MMItemList.Frame3.get(1)).eut((int) TierEU.RECIPE_ZPM).duration(30 * SECONDS)
                .addTo(RecipeMaps.benderRecipes);

        // Lens MK3
        GTValues.RA.stdBuilder().metadata(RESEARCH_ITEM, WerkstoffLoader.MagnetoResonaticDust.get(OrePrefixes.lens, 1))
                .metadata(SCANNING, new Scanning(2 * MINUTES, TierEU.RECIPE_ZPM))
                .itemInputs(
                        WerkstoffLoader.MagnetoResonaticDust.get(OrePrefixes.lens, 2),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.NaquadahAlloy, 4),
                        ItemList.Field_Generator_ZPM.get(1),
                        ItemList.Electric_Piston_ZPM.get(2),
                        ItemList.Electric_Motor_ZPM.get(2))
                .fluidInputs(MaterialsAlloy.INDALLOY_140.getFluidStack(INGOTS * 16))
                .itemOutputs(MMItemList.Lens3.get(1)).duration(1 * MINUTES).eut((int) TierEU.RECIPE_ZPM)
                .addTo(AssemblyLine);

        // ME Downlink
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.getIntegratedCircuit(5),
                        AEApi.instance().definitions().blocks().wireless().maybeStack(1).get(),
                        AEApi.instance().definitions().blocks().energyCell().maybeStack(1).get(),
                        AEApi.instance().definitions().materials().cell256kPart().maybeStack(1).get(),
                        getModItem(AE2FluidCraft.ID, "fluid_interface", 1),
                        ItemList.Conveyor_Module_IV.get(2),
                        ItemList.Electric_Pump_IV.get(2),
                        new Object[] { OrePrefixes.circuit.get(Materials.IV), 1 })
                .fluidInputs(MaterialsAlloy.INDALLOY_140.getFluidStack(INGOTS * 8))
                .itemOutputs(MMItemList.AEDownlink.get(1)).eut((int) TierEU.RECIPE_IV).duration(20 * SECONDS)
                .addTo(RecipeMaps.assemblerRecipes);

        // Quantum Downlink
        GTValues.RA.stdBuilder()
                .metadata(RESEARCH_ITEM, AEApi.instance().definitions().blocks().quantumRing().maybeStack(1).get())
                .metadata(SCANNING, new Scanning(4 * MINUTES, TierEU.RECIPE_LuV))
                .itemInputs(
                        AEApi.instance().definitions().blocks().quantumRing().maybeStack(8).get(),
                        AEApi.instance().definitions().blocks().quantumLink().maybeStack(1).get(),
                        AEApi.instance().definitions().blocks().controller().maybeStack(1).get(),
                        AEApi.instance().definitions().blocks().energyCellDense().maybeStack(1).get(),
                        AEApi.instance().definitions().materials().cell4096kPart().maybeStack(1).get(),
                        getModItem(AE2FluidCraft.ID, "fluid_interface", 1),
                        ItemList.Conveyor_Module_ZPM.get(2),
                        ItemList.Electric_Pump_ZPM.get(2),
                        new Object[] { OrePrefixes.circuit.get(Materials.UV), 4 })
                .fluidInputs(MaterialsAlloy.INDALLOY_140.getFluidStack(INGOTS * 32))
                .itemOutputs(MMItemList.QuantumDownlink.get(1)).duration(1 * MINUTES).eut((int) TierEU.RECIPE_ZPM)
                .addTo(AssemblyLine);

        // Manipulator MK3
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.getIntegratedCircuit(5),
                        MMItemList.Lens3.get(1),
                        MMItemList.TeleporterCore3.get(1),
                        MMItemList.ComputerCore3.get(1),
                        MMItemList.PowerCore3.get(1),
                        MMItemList.Frame3.get(1),
                        MMItemList.AEDownlink.get(1),
                        MMItemList.QuantumDownlink.get(1))
                .fluidInputs(MaterialsAlloy.INDALLOY_140.getFluidStack(INGOTS * 16)).itemOutputs(MMItemList.MK3.get(1))
                .eut((int) TierEU.RECIPE_ZPM).duration(30 * SECONDS).addTo(RecipeMaps.assemblerRecipes);
    }

    private static void addUplinkRecipes() {
        // Quantum Uplink ME Connector Hatch
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                AEApi.instance().definitions().parts().patternTerminal().maybeStack(1).get(),
                80_000,
                32,
                (int) TierEU.RECIPE_UV,
                2,
                new Object[] { CustomItemList.dataIn_Hatch.get(1),
                        AEApi.instance().definitions().materials().cell16384kPart().maybeStack(1).get(),
                        getModItem(AE2FluidCraft.ID, "fluid_interface", 1),
                        AEApi.instance().definitions().parts().patternTerminal().maybeStack(1).get(),
                        ItemList.Robot_Arm_UV.get(1),
                        AEApi.instance().definitions().materials().blankPattern().maybeStack(64).get(),
                        new Object[] { OrePrefixes.circuit.get(Materials.UV), 4 } },
                new FluidStack[] { MaterialsAlloy.INDALLOY_140.getFluidStack(INGOTS * 32),
                        Materials.Naquadria.getMolten(INGOTS * 16), },
                MMItemList.UplinkHatch.get(1),
                60 * SECONDS,
                (int) TierEU.RECIPE_UV);

        // Matter Manipulator Quantum Uplink
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                AEApi.instance().definitions().blocks().quantumLink().maybeStack(1).get(),
                160_000,
                32,
                (int) TierEU.RECIPE_UV,
                4,
                new Object[] { CustomItemList.Machine_Multi_DataBank.get(1),
                        AEApi.instance().definitions().blocks().controller().maybeStack(4).get(),
                        AEApi.instance().definitions().blocks().quantumRing().maybeStack(8).get(),
                        AEApi.instance().definitions().blocks().quantumLink().maybeStack(1).get(),
                        AEApi.instance().definitions().blocks().iOPort().maybeStack(1).get(),
                        AEApi.instance().definitions().materials().cardSuperSpeed().maybeStack(2).get(),
                        CustomItemList.dataOut_Hatch.get(1), CustomItemList.DATApipe.get(32),
                        new Object[] { OrePrefixes.circuit.get(Materials.UHV), 2 } },
                new FluidStack[] { MaterialsAlloy.INDALLOY_140.getFluidStack(INGOTS * 64),
                        Materials.Naquadria.getMolten(INGOTS * 32), },
                MMItemList.UplinkController.get(1),
                60 * SECONDS,
                (int) TierEU.RECIPE_UV);
    }

    private static void addUpgradeRecipes() {
        // Blank Manipulator Upgrade
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.VibrantAlloy, 16),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 8),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 16),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.EV, 2))
                .fluidInputs(Materials.SolderingAlloy.getMolten(INGOTS * 8)).itemOutputs(MMItemList.UpgradeBlank.get(1))
                .eut(TierEU.RECIPE_HV).duration(10 * SECONDS).addTo(RecipeMaps.assemblerRecipes);

        // Excavation Manipulator Upgrade
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MMItemList.UpgradeBlank.get(1),
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.Thaumium, 8),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Thaumium, 8),
                        getModItem(Thaumcraft.ID, "FocusExcavation"), // excavation focus
                        getModItem(Thaumcraft.ID, "WandRod", 1, 0), // greatwood wand
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 15)) // primal charm
                .fluidInputs(Materials.Shadow.getMolten(INGOTS * 8))
                .itemOutputs(MMItemList.UpgradePrototypeMining.get(1)).eut(TierEU.RECIPE_HV).duration(10 * SECONDS)
                .addTo(RecipeMaps.assemblerRecipes);

        // :derangedgregger:
        ItemStack jarredNode = getModItem(Thaumcraft.ID, "BlockJarNodeItem"); // node in a jar
        jarredNode.setStackDisplayName(EnumChatFormatting.RESET + "Any " + jarredNode.getDisplayName());

        // Auxiliary Teleporter Manipulator Upgrade
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MMItemList.UpgradeBlank.get(1),
                        ItemList.Field_Generator_HV.get(2),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 2),
                        getModItem(ThaumicTinkerer.ID, "focusDislocation"), // dislocation focus
                        getModItem(Thaumcraft.ID, "WandRod", 1, 2),
                        jarredNode,
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.Thaumium, 8),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Thaumium, 32))
                .fluidInputs(Materials.Void.getMolten(INGOTS * 8)).itemOutputs(MMItemList.UpgradeSpeed.get(1))
                .eut(TierEU.RECIPE_HV).duration(10 * SECONDS).addTo(RecipeMaps.assemblerRecipes);

        // Adaptive Wiring Harness Manipulator Upgrade
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MMItemList.UpgradeBlank.get(1),
                        getModItem(Mods.Automagy.ID, "crystalBrain", 1, 4), // crystalline brain: order
                        getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 100), // blank golem animation core
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.Thaumium, 8),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 2),
                        GTOreDictUnificator.get(OrePrefixes.gem, Materials.Mercury, 32),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.SuperconductorHVBase, 64))
                .fluidInputs(Materials.Void.getMolten(INGOTS * 8)).itemOutputs(MMItemList.UpgradePowerEff.get(1))
                .eut(TierEU.RECIPE_HV).duration(10 * SECONDS).addTo(RecipeMaps.assemblerRecipes);

        // Energy Tunnel Manipulator Upgrade
        TTRecipeAdder.addResearchableAssemblylineRecipe(
                AEApi.instance().definitions().parts().p2PTunnelGregtech().maybeStack(1).get(),
                256000,
                2048,
                (int) TierEU.RECIPE_UV,
                8,
                new Object[] { MMItemList.UpgradeBlank.get(1),
                        new Object[] { OrePrefixes.circuit.get(Materials.UEV), 4L },
                        AEApi.instance().definitions().parts().cableDense().stack(AEColor.Transparent, 16),
                        AEApi.instance().definitions().parts().p2PTunnelGregtech().maybeStack(4).get(),
                        CustomItemList.Machine_Multi_Transformer.get(1),
                        MaterialsElements.STANDALONE.CHRONOMATIC_GLASS.getPlate(8), ItemList.Circuit_Chip_QPIC.get(4),
                        CustomItemList.LASERpipe.get(64), ItemList.Reactor_Coolant_Sp_6.get(1), },
                new FluidStack[] { MaterialsAlloy.INDALLOY_140.getFluidStack(144 * 64),
                        Materials.CosmicNeutronium.getMolten(144 * 32), Materials.SuperCoolant.getFluid(256_000), },
                MMItemList.UpgradePowerP2P.get(1),
                10 * SECONDS,
                (int) TierEU.RECIPE_UEV);
    }
}
