package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.GalacticraftMars;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.ProjectRedIllumination;
import static gregtech.api.enums.Mods.StevesCarts2;
import static gregtech.api.recipe.RecipeMaps.circuitAssemblerRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.SubTag;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gtPlusPlus.core.material.MaterialsElements;

public class CircuitAssemblerRecipes implements Runnable {

    // put the soldering Materials in this array
    public final Materials[] solderingMaterials = new Materials[] { Materials.Lead, Materials.SolderingAlloy,
            Materials.Tin };

    public final ItemStack[] RocketMaterial = new ItemStack[] {
            GTModHandler.getModItem(GalacticraftCore.ID, "item.heavyPlating", 1L),
            GTModHandler.getModItem(GalacticraftMars.ID, "item.null", 1L, 3),
            GTModHandler.getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1L),
            CustomItemList.HeavyDutyPlateTier4.get(1L), CustomItemList.HeavyDutyPlateTier5.get(1L),
            CustomItemList.HeavyDutyPlateTier6.get(1L), CustomItemList.HeavyDutyPlateTier7.get(1L),
            CustomItemList.HeavyDutyPlateTier8.get(1L) };

    public final ItemStack[] RocketChip = new ItemStack[] { CustomItemList.SchematicsTier1.get(1L),
            CustomItemList.SchematicsTier2.get(1L), CustomItemList.SchematicsTier3.get(1L),
            CustomItemList.SchematicsTier4.get(1L), CustomItemList.SchematicsTier5.get(1L),
            CustomItemList.SchematicsTier6.get(1L), CustomItemList.SchematicsTier7.get(1L),
            CustomItemList.SchematicsTier8.get(1L), };

    // Rocket Circuits
    public final long[] EUperRecipe = new long[] { TierEU.RECIPE_HV, // t2 = HV
            TierEU.RECIPE_EV, // t3 = EV
            TierEU.RECIPE_IV, // t4 = IV
            TierEU.RECIPE_LuV, // t5 = LuV (Gated behind Assline)
            TierEU.RECIPE_LuV, // t6 = LuV
            TierEU.RECIPE_ZPM, // t7 = ZPM
            TierEU.RECIPE_UV, // t8 = UV
    };

    public final ItemStack[] ExtraChips = new ItemStack[] { CustomItemList.SchematicsMoonBuggy.get(1L),
            CustomItemList.SchematicsCargoRocket.get(1L), CustomItemList.SchematicsAstroMiner.get(1L) };

    @Override
    public void run() {
        this.solderingMaterials();
        // Recipes with High Tier Soldering
        Fluid solderIndalloy = FluidRegistry.getFluid("molten.indalloy140") != null
                ? FluidRegistry.getFluid("molten.indalloy140")
                : FluidRegistry.getFluid("molten.solderingalloy");

        Fluid solderUEV = FluidRegistry.getFluid("molten.mutatedlivingsolder") != null
                ? FluidRegistry.getFluid("molten.mutatedlivingsolder")
                : FluidRegistry.getFluid("molten.solderingalloy");

        // Wetware Board

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Multifiberglass.get(16L),
                        ItemList.Circuit_Parts_PetriDish.get(1L),
                        ItemList.Electric_Pump_LuV.get(1L),
                        ItemList.Sensor_IV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 1L),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 16L))
                .itemOutputs(ItemList.Circuit_Board_Wetware.get(16L))
                .fluidInputs(Materials.GrowthMediumSterilized.getFluid(4000L)).requiresCleanRoom()
                .duration(60 * SECONDS).eut(TierEU.RECIPE_LuV).addTo(circuitAssemblerRecipes);
        // Bio Board

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Wetware.get(32L),
                        ItemList.Circuit_Parts_PetriDish.get(8L),
                        ItemList.Electric_Pump_UV.get(1L),
                        ItemList.Sensor_LuV.get(2L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UV, 1L),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Neutronium, 32L))
                .itemOutputs(ItemList.Circuit_Board_Bio.get(32L))
                .fluidInputs(Materials.BioMediumSterilized.getFluid(16000L)).requiresCleanRoom().duration(60 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(circuitAssemblerRecipes);

        // Crystal Circuits

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                        ItemList.Circuit_Chip_CrystalCPU.get(1L),
                        ItemList.Circuit_Chip_NanoCPU.get(2L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(6),
                        ItemList.Circuit_Parts_TransistorASMD.get(6),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 8))
                .itemOutputs(ItemList.Circuit_Crystalprocessor.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 72))
                .requiresCleanRoom().duration(5 * SECONDS).eut(9600).addTo(circuitAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                        ItemList.Circuit_Crystalprocessor.get(2L),
                        ItemList.Circuit_Parts_InductorASMD.get(6L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(8L),
                        ItemList.Circuit_Chip_Ram.get(24),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16))
                .itemOutputs(ItemList.Circuit_Crystalcomputer.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 144))
                .requiresCleanRoom().duration(10 * SECONDS).eut(9600).addTo(circuitAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                        ItemList.Circuit_Crystalcomputer.get(2L),
                        ItemList.Circuit_Chip_Ram.get(4L),
                        ItemList.Circuit_Chip_NOR.get(32L),
                        ItemList.Circuit_Chip_NAND.get(64L),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 32))
                .itemOutputs(ItemList.Circuit_Ultimatecrystalcomputer.get(1L))
                .fluidInputs(new FluidStack(solderIndalloy, 144)).requiresCleanRoom().duration(20 * SECONDS).eut(9600)
                .addTo(circuitAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                        ItemList.Circuit_Ultimatecrystalcomputer.get(2L),
                        ItemList.Circuit_Parts_InductorASMD.get(8L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(16L),
                        ItemList.Circuit_Chip_Ram.get(32L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 16))
                .itemOutputs(ItemList.Circuit_Crystalmainframe.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 288))
                .requiresCleanRoom().duration(40 * SECONDS).eut(TierEU.RECIPE_LuV).addTo(circuitAssemblerRecipes);
        // Wetware Circuits

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Chip_NeuroCPU.get(1L),
                        ItemList.Circuit_Chip_CrystalCPU.get(1L),
                        ItemList.Circuit_Chip_NanoCPU.get(1L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(8L),
                        ItemList.Circuit_Parts_TransistorASMD.get(8L),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 8))
                .itemOutputs(ItemList.Circuit_Neuroprocessor.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 72))
                .requiresCleanRoom().duration(10 * SECONDS).eut(38400).addTo(circuitAssemblerRecipes);
        // Wetware SoC recipe

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Wetware_Extreme.get(1),
                        ItemList.Circuit_Parts_Crystal_Chip_Wetware.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 8),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.CosmicNeutronium, 8))
                .itemOutputs(ItemList.Circuit_Neuroprocessor.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 144))
                .requiresCleanRoom().duration(2 * SECONDS + 10 * TICKS).eut(614400).addTo(circuitAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Chip_NeuroCPU.get(1L),
                        ItemList.Circuit_Chip_CrystalCPU.get(1L),
                        ItemList.Circuit_Chip_NanoCPU.get(1L),
                        ItemList.Circuit_Parts_CapacitorXSMD.get(2L),
                        ItemList.Circuit_Parts_TransistorXSMD.get(2L),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 8))
                .itemOutputs(ItemList.Circuit_Neuroprocessor.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 72))
                .requiresCleanRoom().duration(1 * SECONDS + 5 * TICKS).eut(153600).addTo(circuitAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Wetware_Extreme.get(1L),
                        ItemList.Circuit_Neuroprocessor.get(2L),
                        ItemList.Circuit_Parts_InductorASMD.get(8L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(12L),
                        ItemList.Circuit_Chip_Ram.get(24L),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 16))
                .itemOutputs(ItemList.Circuit_Wetwarecomputer.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 144))
                .requiresCleanRoom().duration(15 * SECONDS).eut(38400).addTo(circuitAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Wetware_Extreme.get(1L),
                        ItemList.Circuit_Neuroprocessor.get(2L),
                        ItemList.Circuit_Parts_InductorXSMD.get(2L),
                        ItemList.Circuit_Parts_CapacitorXSMD.get(3L),
                        ItemList.Circuit_Chip_Ram.get(24L),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 16))
                .itemOutputs(ItemList.Circuit_Wetwarecomputer.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 144))
                .requiresCleanRoom().duration(1 * SECONDS + 17 * TICKS).eut(153600).addTo(circuitAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Wetware_Extreme.get(2L),
                        ItemList.Circuit_Wetwarecomputer.get(2L),
                        ItemList.Circuit_Parts_DiodeASMD.get(8L),
                        ItemList.Circuit_Chip_NOR.get(16L),
                        ItemList.Circuit_Chip_Ram.get(64L),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 24))
                .itemOutputs(ItemList.Circuit_Wetwaresupercomputer.get(1L))
                .fluidInputs(new FluidStack(solderIndalloy, 144)).requiresCleanRoom().duration(30 * SECONDS).eut(38400)
                .addTo(circuitAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Wetware_Extreme.get(2L),
                        ItemList.Circuit_Wetwarecomputer.get(2L),
                        ItemList.Circuit_Parts_DiodeXSMD.get(2L),
                        ItemList.Circuit_Chip_NOR.get(16L),
                        ItemList.Circuit_Chip_Ram.get(64L),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 24))
                .itemOutputs(ItemList.Circuit_Wetwaresupercomputer.get(1L))
                .fluidInputs(new FluidStack(solderIndalloy, 144)).requiresCleanRoom().duration(3 * SECONDS + 15 * TICKS)
                .eut(153600).addTo(circuitAssemblerRecipes);
        // Bio Circuits

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Chip_BioCPU.get(1L),
                        ItemList.Circuit_Chip_CrystalSoC2.get(1L),
                        ItemList.Circuit_Chip_NanoCPU.get(2L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(12L),
                        ItemList.Circuit_Parts_TransistorASMD.get(12L),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16))
                .itemOutputs(ItemList.Circuit_Bioprocessor.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 72))
                .requiresCleanRoom().duration(15 * SECONDS).eut(153600).addTo(circuitAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Chip_BioCPU.get(1L),
                        ItemList.Circuit_Chip_CrystalSoC2.get(1L),
                        ItemList.Circuit_Chip_NanoCPU.get(2L),
                        ItemList.Circuit_Parts_CapacitorXSMD.get(3L),
                        ItemList.Circuit_Parts_TransistorXSMD.get(3L),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16))
                .itemOutputs(ItemList.Circuit_Bioprocessor.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 72))
                .requiresCleanRoom().duration(1 * SECONDS + 17 * TICKS).eut(614400).addTo(circuitAssemblerRecipes);

        // Bio SoC
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Bio_Ultra.get(1L),
                        ItemList.Circuit_Parts_Chip_Bioware.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16),
                        MaterialsElements.STANDALONE.CHRONOMATIC_GLASS.getBolt(8))
                .itemOutputs(ItemList.Circuit_Bioprocessor.get(1L)).fluidInputs(new FluidStack(solderUEV, 144))
                .requiresCleanRoom().duration(3 * SECONDS + 15 * TICKS).eut(TierEU.RECIPE_UEV)
                .addTo(circuitAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Bio_Ultra.get(1L),
                        ItemList.Circuit_Bioprocessor.get(2L),
                        ItemList.Circuit_Parts_InductorASMD.get(12L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(16L),
                        ItemList.Circuit_Chip_Ram.get(32L),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 24))
                .itemOutputs(ItemList.Circuit_Biowarecomputer.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 144))
                .requiresCleanRoom().duration(20 * SECONDS).eut(153600).addTo(circuitAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Bio_Ultra.get(1L),
                        ItemList.Circuit_Bioprocessor.get(2L),
                        ItemList.Circuit_Parts_InductorXSMD.get(3L),
                        ItemList.Circuit_Parts_CapacitorXSMD.get(4L),
                        ItemList.Circuit_Chip_Ram.get(32L),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 24))
                .itemOutputs(ItemList.Circuit_Biowarecomputer.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 144))
                .requiresCleanRoom().duration(2 * SECONDS + 10 * TICKS).eut(614400).addTo(circuitAssemblerRecipes);
        // Energy Flow Circuit

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ZPM, 2),
                        ItemList.Circuit_Chip_UHPIC.get(4L),
                        ItemList.Circuit_Chip_QuantumCPU.get(2L),
                        ItemList.Circuit_Chip_NanoCPU.get(2L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorZPM, 64))
                .itemOutputs(CustomItemList.HighEnergyFlowCircuit.get(1L))
                .fluidInputs(new FluidStack(solderIndalloy, 288)).requiresCleanRoom().duration(2 * MINUTES)
                .eut(TierEU.RECIPE_IV).addTo(circuitAssemblerRecipes);
        // SoC for nano, quantum, crystal

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                        ItemList.Circuit_Chip_SoC2.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 8))
                .itemOutputs(ItemList.Circuit_Nanoprocessor.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 72))
                .requiresCleanRoom().duration(2 * SECONDS + 10 * TICKS).eut(9600).addTo(circuitAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                        ItemList.Circuit_Chip_SoC2.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.NiobiumTitanium, 8))
                .itemOutputs(ItemList.Circuit_Quantumprocessor.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 72))
                .requiresCleanRoom().duration(2 * SECONDS + 10 * TICKS).eut(38400).addTo(circuitAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                        ItemList.Circuit_Chip_CrystalSoC.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 8),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.YttriumBariumCuprate, 8))
                .itemOutputs(ItemList.Circuit_Crystalprocessor.get(1L)).fluidInputs(new FluidStack(solderIndalloy, 72))
                .requiresCleanRoom().duration(2 * SECONDS + 10 * TICKS).eut(153600).addTo(circuitAssemblerRecipes);

        if (AppliedEnergistics2.isModLoaded()) {
            // 1k ME Storage Component

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ULV, 2),
                            CustomItemList.ChargedCertusQuartzDust.get(2),
                            CustomItemList.LogicProcessorItemGoldCore.get(1),
                            ItemList.Circuit_Board_Basic.get(1),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 35))
                    .fluidInputs(Materials.Lead.getMolten(288)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                    .addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ULV, 2),
                            CustomItemList.ChargedCertusQuartzDust.get(2),
                            CustomItemList.LogicProcessorItemGoldCore.get(1),
                            ItemList.Circuit_Board_Basic.get(1),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 35))
                    .fluidInputs(Materials.Tin.getMolten(144)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                    .addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ULV, 2),
                            CustomItemList.ChargedCertusQuartzDust.get(2),
                            CustomItemList.LogicProcessorItemGoldCore.get(1),
                            ItemList.Circuit_Board_Basic.get(1),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 35))
                    .fluidInputs(Materials.SolderingAlloy.getMolten(72)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                    .addTo(circuitAssemblerRecipes);
            // 4k ME Storage Component

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ULV, 16),
                            CustomItemList.LogicProcessorItemGoldCore.get(1),
                            ItemList.Circuit_Board_Coated_Basic.get(1),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 36))
                    .fluidInputs(Materials.Lead.getMolten(288)).requiresCleanRoom().duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ULV, 16),
                            CustomItemList.LogicProcessorItemGoldCore.get(1),
                            ItemList.Circuit_Board_Coated_Basic.get(1),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 36))
                    .fluidInputs(Materials.Tin.getMolten(144)).requiresCleanRoom().duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ULV, 16),
                            CustomItemList.LogicProcessorItemGoldCore.get(1),
                            ItemList.Circuit_Board_Coated_Basic.get(1),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 36))
                    .fluidInputs(Materials.SolderingAlloy.getMolten(72)).requiresCleanRoom().duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(circuitAssemblerRecipes);
            // 16k ME Storage Component

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 16),
                            CustomItemList.EngineeringProcessorItemDiamondCore.get(1),
                            ItemList.Circuit_Board_Phenolic_Good.get(1),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 37))
                    .fluidInputs(Materials.Lead.getMolten(288)).requiresCleanRoom().duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 16),
                            CustomItemList.EngineeringProcessorItemDiamondCore.get(1),
                            ItemList.Circuit_Board_Phenolic_Good.get(1),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 37))
                    .fluidInputs(Materials.Tin.getMolten(144)).requiresCleanRoom().duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 16),
                            CustomItemList.EngineeringProcessorItemDiamondCore.get(1),
                            ItemList.Circuit_Board_Phenolic_Good.get(1),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 37))
                    .fluidInputs(Materials.SolderingAlloy.getMolten(72)).requiresCleanRoom().duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);
            // 64k ME Storage Component

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 16),
                            CustomItemList.EngineeringProcessorItemDiamondCore.get(1),
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 38))
                    .fluidInputs(Materials.Lead.getMolten(288)).requiresCleanRoom().duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 16),
                            CustomItemList.EngineeringProcessorItemDiamondCore.get(1),
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 38))
                    .fluidInputs(Materials.Tin.getMolten(144)).requiresCleanRoom().duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 16),
                            CustomItemList.EngineeringProcessorItemDiamondCore.get(1),
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(GTModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 38))
                    .fluidInputs(Materials.SolderingAlloy.getMolten(72)).requiresCleanRoom().duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(circuitAssemblerRecipes);

        }
    }

    public void solderingMaterials() {
        for (Materials tMat : solderingMaterials) {
            int tMultiplier = tMat.contains(SubTag.SOLDERING_MATERIAL_GOOD) ? 1
                    : tMat.contains(SubTag.SOLDERING_MATERIAL_BAD) ? 4 : 2;

            // Rocket Circuits

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            RocketMaterial[0],
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.EV, 1),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(RocketChip[0]).fluidInputs(tMat.getMolten(576L * tMultiplier / 2L)).requiresCleanRoom()
                    .duration(7 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_HV).addTo(circuitAssemblerRecipes);

            for (int i = 2; i < 9; ++i) {
                ItemStack DataStickWScheme = ItemList.Tool_DataStick.get(1L);
                DataStickWScheme.setTagCompound(
                        GTUtility.getNBTContainingShort(new NBTTagCompound(), "rocket_tier", (short) i));

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                RocketMaterial[(i - 1)],
                                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 1),
                                DataStickWScheme.splitStack(0),
                                GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(RocketChip[(i - 1)]).fluidInputs(tMat.getMolten(576L * tMultiplier / 2L))
                        .requiresCleanRoom().duration(7 * MINUTES + 30 * SECONDS).eut(EUperRecipe[(i - 2)])
                        .addTo(circuitAssemblerRecipes);
            }

            for (int i = 0; i < 3; ++i) {
                ItemStack DataStickWScheme = ItemList.Tool_DataStick.get(1L);
                DataStickWScheme.setTagCompound(
                        GTUtility.getNBTContainingShort(new NBTTagCompound(), "rocket_tier", (short) (i + 100)));
                int rocketTier = Math.min(i + 2, 3);
                GTValues.RA.stdBuilder()
                        .itemInputs(
                                RocketMaterial[rocketTier - 1],
                                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 1),
                                DataStickWScheme.splitStack(0),
                                GTUtility.getIntegratedCircuit(Math.max(i + 1, 2)))
                        .itemOutputs(ExtraChips[i]).fluidInputs(tMat.getMolten(576L * tMultiplier / 2L))
                        .requiresCleanRoom().duration(7 * MINUTES + 30 * SECONDS).eut(EUperRecipe[rocketTier - 2])
                        .addTo(circuitAssemblerRecipes);

            }
            // Primitive Circuit

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Phenolic_Good.get(1L),
                            ItemList.Circuit_Chip_Simple_SoC.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 1))
                    .itemOutputs(CustomItemList.NandChipBoard.get(1))
                    .fluidInputs(tMat.getMolten(36L * tMultiplier / 2L)).duration(15 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Phenolic_Good.get(1L),
                            ItemList.Circuit_Chip_Simple_SoC.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 1))
                    .itemOutputs(CustomItemList.NandChipBoard.get(1))
                    .fluidInputs(tMat.getMolten(36L * tMultiplier / 2L)).duration(7 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_Simple_SoC.get(2L),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 1))
                    .itemOutputs(CustomItemList.NandChipBoard.get(2))
                    .fluidInputs(tMat.getMolten(36L * tMultiplier / 2L)).duration(15 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_Simple_SoC.get(2L),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 1))
                    .itemOutputs(CustomItemList.NandChipBoard.get(2))
                    .fluidInputs(tMat.getMolten(36L * tMultiplier / 2L)).duration(7 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV).addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Chip_Simple_SoC.get(4L),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 1))
                    .itemOutputs(CustomItemList.NandChipBoard.get(4))
                    .fluidInputs(tMat.getMolten(36L * tMultiplier / 2L)).duration(15 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Chip_Simple_SoC.get(4L),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 1))
                    .itemOutputs(CustomItemList.NandChipBoard.get(4))
                    .fluidInputs(tMat.getMolten(36L * tMultiplier / 2L)).duration(7 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_EV).addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(2L),
                            ItemList.Circuit_Chip_NAND.get(32L),
                            ItemList.Circuit_Chip_Ram.get(4L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 16),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 4))
                    .itemOutputs(ItemList.Tool_DataStick.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier))
                    .requiresCleanRoom().duration(20 * SECONDS).eut(90).addTo(circuitAssemblerRecipes);

            // Basic Circuit
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Coated_Basic.get(1L),
                            ItemList.Circuit_Parts_Resistor.get(2L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 2),
                            ItemList.Circuit_Parts_Vacuum_Tube.get(2L))
                    .itemOutputs(GTModHandler.getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1L, 0))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(10 * SECONDS).eut(16)
                    .addTo(circuitAssemblerRecipes);

            // Good Circuit
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Phenolic_Good.get(1L),
                            GTModHandler.getModItem(IndustrialCraft2.ID, "itemPartCircuit", 2L, 0),
                            ItemList.Circuit_Parts_Diode.get(2L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 2))
                    .itemOutputs(ItemList.Circuit_Good.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier / 2L))
                    .duration(15 * SECONDS).eut(TierEU.RECIPE_LV).addTo(circuitAssemblerRecipes);

            // Integrated Logic Circuit
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Coated_Basic.get(1L),
                            ItemList.Circuit_Chip_ILC.get(1L),
                            ItemList.Circuit_Parts_Resistor.get(2L),
                            ItemList.Circuit_Parts_Diode.get(2L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2))
                    .itemOutputs(ItemList.Circuit_Basic.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier / 2L))
                    .duration(10 * SECONDS).eut(16).addTo(circuitAssemblerRecipes);

            // Good Integrated Circuit
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Phenolic_Good.get(1L),
                            ItemList.Circuit_Basic.get(2L),
                            ItemList.Circuit_Parts_Resistor.get(4L),
                            ItemList.Circuit_Parts_Diode.get(4L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4))
                    .itemOutputs(ItemList.Circuit_Integrated_Good.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(20 * SECONDS).eut(24)
                    .addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Phenolic_Good.get(1L),
                            ItemList.Circuit_Basic.get(2L),
                            ItemList.Circuit_Parts_ResistorASMD.get(1L),
                            ItemList.Circuit_Parts_DiodeASMD.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4))
                    .itemOutputs(ItemList.Circuit_Integrated_Good.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(10 * SECONDS).eut(24)
                    .addTo(circuitAssemblerRecipes);

            // Advanced circuit
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Integrated_Good.get(1L),
                            ItemList.Circuit_Chip_ILC.get(2L),
                            ItemList.Circuit_Chip_Ram.get(2L),
                            ItemList.Circuit_Parts_Transistor.get(4L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 8))
                    .itemOutputs(GTModHandler.getIC2Item("advancedCircuit", 1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(40 * SECONDS).eut(TierEU.RECIPE_LV)
                    .addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Integrated_Good.get(1L),
                            ItemList.Circuit_Chip_ILC.get(2L),
                            ItemList.Circuit_Chip_Ram.get(2L),
                            ItemList.Circuit_Parts_TransistorASMD.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 8))
                    .itemOutputs(GTModHandler.getIC2Item("advancedCircuit", 1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(20 * SECONDS).eut(TierEU.RECIPE_LV)
                    .addTo(circuitAssemblerRecipes);

            // Microprocessor
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L),
                            ItemList.Circuit_Parts_Resistor.get(2L),
                            ItemList.Circuit_Parts_Capacitor.get(2L),
                            ItemList.Circuit_Parts_Transistor.get(2L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2))
                    .itemOutputs(ItemList.Circuit_Microprocessor.get(2L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).requiresCleanRoom().duration(10 * SECONDS)
                    .eut(60).addTo(circuitAssemblerRecipes);

            // Integrated Processor
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L),
                            ItemList.Circuit_Parts_Resistor.get(4L),
                            ItemList.Circuit_Parts_Capacitor.get(4L),
                            ItemList.Circuit_Parts_Transistor.get(4L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4))
                    .itemOutputs(ItemList.Circuit_Processor.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).requiresCleanRoom().duration(10 * SECONDS)
                    .eut(60).addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_CPU.get(1L),
                            ItemList.Circuit_Parts_ResistorASMD.get(1L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(1L),
                            ItemList.Circuit_Parts_TransistorASMD.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4))
                    .itemOutputs(ItemList.Circuit_Processor.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).requiresCleanRoom().duration(5 * SECONDS)
                    .eut(60).addTo(circuitAssemblerRecipes);

            // Processor Assembly
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Processor.get(2L),
                            ItemList.Circuit_Parts_Coil.get(4L),
                            ItemList.Circuit_Parts_Capacitor.get(8L),
                            ItemList.Circuit_Chip_Ram.get(4L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 8))
                    .itemOutputs(ItemList.Circuit_Computer.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier))
                    .requiresCleanRoom().duration(20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Processor.get(2L),
                            ItemList.Circuit_Parts_InductorASMD.get(1L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(2L),
                            ItemList.Circuit_Chip_Ram.get(4L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 8))
                    .itemOutputs(ItemList.Circuit_Computer.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier))
                    .requiresCleanRoom().duration(10 * SECONDS).eut(96).addTo(circuitAssemblerRecipes);

            // Workstation
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Advanced.get(2L),
                            ItemList.Circuit_Parts_Diode.get(4L),
                            ItemList.Circuit_Chip_Ram.get(8L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 16))
                    .itemOutputs(ItemList.Circuit_Data.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier))
                    .requiresCleanRoom().duration(20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Advanced.get(2L),
                            ItemList.Circuit_Parts_DiodeASMD.get(1L),
                            ItemList.Circuit_Chip_Ram.get(8L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 16))
                    .itemOutputs(ItemList.Circuit_Data.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier))
                    .requiresCleanRoom().duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);

            // Mainframe
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                            ItemList.Circuit_Data.get(2),
                            ItemList.Circuit_Parts_Coil.get(12L),
                            ItemList.Circuit_Parts_Capacitor.get(24),
                            ItemList.Circuit_Chip_Ram.get(16L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 24))
                    .itemOutputs(ItemList.Circuit_Elite.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier * 2))
                    .requiresCleanRoom().duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                            ItemList.Circuit_Data.get(2),
                            ItemList.Circuit_Parts_InductorASMD.get(3L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(4L),
                            ItemList.Circuit_Chip_Ram.get(16L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 16))
                    .itemOutputs(ItemList.Circuit_Elite.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier * 2))
                    .requiresCleanRoom().duration(40 * SECONDS).eut(TierEU.RECIPE_HV).addTo(circuitAssemblerRecipes);

            // Nanotech Circuits
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Chip_NanoCPU.get(1L),
                            ItemList.Circuit_Parts_ResistorSMD.get(8L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(8L),
                            ItemList.Circuit_Parts_TransistorSMD.get(8L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8))
                    .itemOutputs(ItemList.Circuit_Nanoprocessor.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).requiresCleanRoom().duration(10 * SECONDS)
                    .eut(600).addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Chip_NanoCPU.get(1L),
                            ItemList.Circuit_Parts_ResistorASMD.get(2L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(2L),
                            ItemList.Circuit_Parts_TransistorASMD.get(2L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8))
                    .itemOutputs(ItemList.Circuit_Nanoprocessor.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).requiresCleanRoom().duration(5 * SECONDS)
                    .eut(600).addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Nanoprocessor.get(2L),
                            ItemList.Circuit_Parts_InductorSMD.get(8L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(8L),
                            ItemList.Circuit_Chip_Ram.get(8L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16))
                    .itemOutputs(ItemList.Circuit_Nanocomputer.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier))
                    .requiresCleanRoom().duration(20 * SECONDS).eut(600).addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Nanoprocessor.get(2L),
                            ItemList.Circuit_Parts_InductorASMD.get(2L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(2L),
                            ItemList.Circuit_Chip_Ram.get(8L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16))
                    .itemOutputs(ItemList.Circuit_Nanocomputer.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier))
                    .requiresCleanRoom().duration(10 * SECONDS).eut(600).addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Nanoprocessor.get(2L),
                            ItemList.Circuit_Chip_Ram.get(4L),
                            ItemList.Circuit_Chip_NOR.get(32L),
                            ItemList.Circuit_Chip_NAND.get(64L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 32))
                    .itemOutputs(ItemList.Tool_DataOrb.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier))
                    .requiresCleanRoom().duration(20 * SECONDS).eut(1200).addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Nanocomputer.get(2L),
                            ItemList.Circuit_Parts_DiodeSMD.get(8L),
                            ItemList.Circuit_Chip_NOR.get(4L),
                            ItemList.Circuit_Chip_Ram.get(16L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16))
                    .itemOutputs(ItemList.Circuit_Elitenanocomputer.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier)).requiresCleanRoom().duration(20 * SECONDS).eut(600)
                    .addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            ItemList.Circuit_Nanocomputer.get(2L),
                            ItemList.Circuit_Parts_DiodeASMD.get(2L),
                            ItemList.Circuit_Chip_NOR.get(4L),
                            ItemList.Circuit_Chip_Ram.get(16L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16))
                    .itemOutputs(ItemList.Circuit_Elitenanocomputer.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier)).requiresCleanRoom().duration(10 * SECONDS).eut(600)
                    .addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                            ItemList.Circuit_Elitenanocomputer.get(2L),
                            ItemList.Circuit_Parts_InductorSMD.get(16L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(32L),
                            ItemList.Circuit_Chip_Ram.get(16L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 32))
                    .itemOutputs(ItemList.Circuit_Master.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier * 2))
                    .requiresCleanRoom().duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                            ItemList.Circuit_Elitenanocomputer.get(2L),
                            ItemList.Circuit_Parts_InductorASMD.get(4L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(8L),
                            ItemList.Circuit_Chip_Ram.get(16L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 32))
                    .itemOutputs(ItemList.Circuit_Master.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier * 2))
                    .requiresCleanRoom().duration(40 * SECONDS).eut(TierEU.RECIPE_EV).addTo(circuitAssemblerRecipes);
            // Quantum Circuits

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Chip_QuantumCPU.get(1L),
                            ItemList.Circuit_Chip_NanoCPU.get(1L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(12L),
                            ItemList.Circuit_Parts_TransistorSMD.get(12L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16))
                    .itemOutputs(ItemList.Circuit_Quantumprocessor.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).requiresCleanRoom().duration(10 * SECONDS)
                    .eut(2400).addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Chip_QuantumCPU.get(1L),
                            ItemList.Circuit_Chip_NanoCPU.get(1L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(3L),
                            ItemList.Circuit_Parts_TransistorASMD.get(3L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16))
                    .itemOutputs(ItemList.Circuit_Quantumprocessor.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).requiresCleanRoom().duration(5 * SECONDS)
                    .eut(2400).addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Quantumprocessor.get(2L),
                            ItemList.Circuit_Parts_InductorSMD.get(12L),
                            ItemList.Circuit_Parts_CapacitorSMD.get(16L),
                            ItemList.Circuit_Chip_Ram.get(4L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 24))
                    .itemOutputs(ItemList.Circuit_Quantumcomputer.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier)).requiresCleanRoom().duration(20 * SECONDS)
                    .eut(2400).addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Quantumprocessor.get(2L),
                            ItemList.Circuit_Parts_InductorASMD.get(3L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(4L),
                            ItemList.Circuit_Chip_Ram.get(4L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 24))
                    .itemOutputs(ItemList.Circuit_Quantumcomputer.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier)).requiresCleanRoom().duration(10 * SECONDS)
                    .eut(2400).addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Quantumcomputer.get(2L),
                            ItemList.Circuit_Parts_DiodeSMD.get(8L),
                            ItemList.Circuit_Chip_NOR.get(4L),
                            ItemList.Circuit_Chip_Ram.get(16L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 48))
                    .itemOutputs(ItemList.Circuit_Masterquantumcomputer.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier)).requiresCleanRoom().duration(20 * SECONDS)
                    .eut(2400).addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Quantumcomputer.get(2L),
                            ItemList.Circuit_Parts_DiodeASMD.get(2L),
                            ItemList.Circuit_Chip_NOR.get(4L),
                            ItemList.Circuit_Chip_Ram.get(16L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 48))
                    .itemOutputs(ItemList.Circuit_Masterquantumcomputer.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier)).requiresCleanRoom().duration(10 * SECONDS)
                    .eut(2400).addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                            ItemList.Circuit_Masterquantumcomputer.get(2L),
                            ItemList.Circuit_Parts_InductorSMD.get(24),
                            ItemList.Circuit_Parts_CapacitorSMD.get(48L),
                            ItemList.Circuit_Chip_Ram.get(24),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 48))
                    .itemOutputs(ItemList.Circuit_Quantummainframe.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier * 2)).requiresCleanRoom()
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_IV).addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                            ItemList.Circuit_Masterquantumcomputer.get(2L),
                            ItemList.Circuit_Parts_InductorASMD.get(6L),
                            ItemList.Circuit_Parts_CapacitorASMD.get(12L),
                            ItemList.Circuit_Chip_Ram.get(24),
                            GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 48))
                    .itemOutputs(ItemList.Circuit_Quantummainframe.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier * 2)).requiresCleanRoom().duration(40 * SECONDS)
                    .eut(TierEU.RECIPE_IV).addTo(circuitAssemblerRecipes);
            // SoC

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_SoC.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Copper, 2))
                    .itemOutputs(ItemList.Circuit_Microprocessor.get(2L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).requiresCleanRoom()
                    .duration(2 * SECONDS + 10 * TICKS).eut(600).addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                            ItemList.Circuit_Chip_SoC.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4),
                            GTOreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 4))
                    .itemOutputs(ItemList.Circuit_Processor.get(1L))
                    .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).requiresCleanRoom()
                    .duration(2 * SECONDS + 10 * TICKS).eut(2400).addTo(circuitAssemblerRecipes);
            // Lapo orbs

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Chip_PIC.get(4L),
                            ItemList.Circuit_Parts_Crystal_Chip_Master.get(24L),
                            ItemList.Circuit_Chip_NanoCPU.get(2L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Platinum, 8))
                    .itemOutputs(ItemList.Energy_LapotronicOrb.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier))
                    .requiresCleanRoom().duration(25 * SECONDS + 12 * TICKS).eut(1024).addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                            ItemList.Circuit_Chip_HPIC.get(4L),
                            ItemList.Energy_LapotronicOrb.get(8L),
                            ItemList.Circuit_Chip_QuantumCPU.get(2L),
                            GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 16))
                    .itemOutputs(ItemList.Energy_LapotronicOrb2.get(1L)).fluidInputs(tMat.getMolten(144L * tMultiplier))
                    .requiresCleanRoom().duration(51 * SECONDS + 4 * TICKS).eut(4096).addTo(circuitAssemblerRecipes);

            // PCBs Steve Carts
            if (StevesCarts2.isModLoaded()) {

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Coated_Basic.get(1L),
                                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1),
                                GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 8),
                                GTUtility.getIntegratedCircuit(2))
                        .itemOutputs(GTModHandler.getModItem(StevesCarts2.ID, "ModuleComponents", 1L, 9))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_LV).addTo(circuitAssemblerRecipes);

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Phenolic_Good.get(1L),
                                GTModHandler.getModItem(StevesCarts2.ID, "ModuleComponents", 2L, 9),
                                GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16),
                                GTUtility.getIntegratedCircuit(2))
                        .itemOutputs(GTModHandler.getModItem(StevesCarts2.ID, "ModuleComponents", 1L, 16))
                        .fluidInputs(tMat.getMolten(288L * tMultiplier / 2L)).duration(20 * SECONDS)
                        .eut(TierEU.RECIPE_LV).addTo(circuitAssemblerRecipes);

            }

            if (OpenComputers.isModLoaded()) {
                // ALU

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Chip_ILC.get(16L),
                                GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 2L, 27))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(20 * SECONDS).eut(64)
                        .addTo(circuitAssemblerRecipes);
                // CU

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Parts_Transistor.get(4L),
                                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1),
                                GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 28))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_LV).addTo(circuitAssemblerRecipes);

                // anylyser

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Tool_Scanner.get(1L),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                                ItemList.Circuit_Parts_Transistor.get(2L),
                                ItemList.Sensor_HV.get(1L),
                                GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 0))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);

                // CPU 1

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                GTModHandler.getModItem(OpenComputers.ID, "item", 8L, 27),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 28),
                                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1),
                                GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 29))
                        .fluidInputs(tMat.getMolten(288L * tMultiplier / 2L)).duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);
                // CPU 2

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                GTModHandler.getModItem(OpenComputers.ID, "item", 12L, 27),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 2L, 28),
                                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1),
                                GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GTUtility.getIntegratedCircuit(2))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 42))
                        .fluidInputs(tMat.getMolten(288L * tMultiplier / 2L)).duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);
                // CPU 3

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                GTModHandler.getModItem(OpenComputers.ID, "item", 16L, 27),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 4L, 28),
                                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.EV, 1),
                                GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GTUtility.getIntegratedCircuit(3))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 43))
                        .fluidInputs(tMat.getMolten(288L * tMultiplier / 2L)).duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);
                // Graphics Card 1

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 33),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 8L, 27),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 28),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 24),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 1),
                                GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 8))
                        .fluidInputs(tMat.getMolten(288L * tMultiplier / 2L)).duration(20 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);
                // Graphics Card 2

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 33),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 16L, 27),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 2L, 28),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 2),
                                GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 9))
                        .fluidInputs(tMat.getMolten(288L * tMultiplier / 2L)).duration(20 * SECONDS).eut(256)
                        .addTo(circuitAssemblerRecipes);
                // Graphics Card 3

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 33),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 32L, 27),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 4L, 28),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 4L, 26),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 38),
                                GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 10))
                        .fluidInputs(tMat.getMolten(288L * tMultiplier / 2L)).duration(20 * SECONDS)
                        .eut(TierEU.RECIPE_HV).addTo(circuitAssemblerRecipes);
                // Internet Crad

                GTValues.RA.stdBuilder().itemInputs(
                        GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 13),
                        GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 48),
                        GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 26),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 1L),
                        GTModHandler
                                .getModItem(ProjectRedIllumination.ID, "projectred.illumination.lightbutton", 1L, 14),
                        GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 44))
                        .fluidInputs(tMat.getMolten(288L * tMultiplier / 2L)).duration(20 * SECONDS)
                        .eut(TierEU.RECIPE_HV).addTo(circuitAssemblerRecipes);
                // APU T1

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                GTModHandler.getModItem(OpenComputers.ID, "item", 32L, 27),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 4L, 28),
                                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.EV, 1),
                                GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GTUtility.getIntegratedCircuit(2))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 101))
                        .fluidInputs(tMat.getMolten(288L * tMultiplier / 2L)).duration(10 * SECONDS).eut(256)
                        .addTo(circuitAssemblerRecipes);
                // APU T2

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                GTModHandler.getModItem(OpenComputers.ID, "item", 64L, 27),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 8L, 28),
                                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 1),
                                GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GTUtility.getIntegratedCircuit(3))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 102))
                        .fluidInputs(tMat.getMolten(288L * tMultiplier / 2L)).duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_HV).addTo(circuitAssemblerRecipes);
                // EEPROM

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 24),
                                ItemList.Circuit_Parts_Transistor.get(6L),
                                GTOreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 1),
                                GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "eeprom", 1L, 0))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);

                // RAM 1

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(16L),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 2L, 24),
                                GTOreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 1))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(64).addTo(circuitAssemblerRecipes);
                // RAM 1.5

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(32L),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 4L, 24),
                                GTOreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GTUtility.getIntegratedCircuit(2))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 50))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);
                // RAM 2

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(64L),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                                GTOreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 2))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(256).addTo(circuitAssemblerRecipes);
                // RAM 2.5

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(64L),
                                ItemList.Circuit_Chip_NAND.get(16L),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 4L, 25),
                                GTOreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16),
                                GTUtility.getIntegratedCircuit(2))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 3))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_HV).addTo(circuitAssemblerRecipes);
                // RAM 3

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(64L),
                                ItemList.Circuit_Chip_NAND.get(32L),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 2L, 26),
                                GTOreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 38))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(1024).addTo(circuitAssemblerRecipes);
                // RAM 3.5

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(64L),
                                ItemList.Circuit_Chip_NAND.get(64L),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 4L, 26),
                                GTOreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GTUtility.getIntegratedCircuit(2))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 39))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_EV).addTo(circuitAssemblerRecipes);
                // Circuit 1

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1),
                                ItemList.Circuit_Parts_Transistor.get(4L),
                                GTOreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 4L),
                                GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 24))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1),
                                ItemList.Circuit_Parts_TransistorASMD.get(1L),
                                GTOreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 4L),
                                GTUtility.getIntegratedCircuit(2))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 24))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(7 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);
                // Circuit 2

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1),
                                ItemList.Circuit_Parts_Transistor.get(8L),
                                GTOreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8L),
                                GTUtility.getIntegratedCircuit(2))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 25))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(15 * SECONDS).eut(256)
                        .addTo(circuitAssemblerRecipes);

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1),
                                ItemList.Circuit_Parts_TransistorASMD.get(2L),
                                GTOreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8L),
                                GTUtility.getIntegratedCircuit(3))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 25))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(7 * SECONDS + 10 * TICKS)
                        .eut(256).addTo(circuitAssemblerRecipes);
                // Circuit 3

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.EV, 1),
                                ItemList.Circuit_Parts_Transistor.get(16L),
                                GTOreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 26))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_HV).addTo(circuitAssemblerRecipes);

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.EV, 1),
                                ItemList.Circuit_Parts_TransistorASMD.get(4L),
                                GTOreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GTUtility.getIntegratedCircuit(2))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 26))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(7 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_HV).addTo(circuitAssemblerRecipes);
                // network card

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 33),
                                GTModHandler.getModItem(OpenComputers.ID, "cable", 2L, 0),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 26),
                                GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L),
                                GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 11))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);
                // tps card

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                new ItemStack(Items.clock, 1),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 66),
                                ItemList.Emitter_HV.get(1L),
                                ItemList.Sensor_HV.get(1L),
                                GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 2),
                                GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 117))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);
                // wlan card1

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 11),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 25),
                                ItemList.Emitter_LV.get(1L),
                                ItemList.Sensor_LV.get(1L),
                                GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 113))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);
                // wlan card2

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 11),
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 26),
                                ItemList.Emitter_HV.get(1L),
                                ItemList.Sensor_HV.get(1L),
                                GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 13))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(10 * SECONDS).eut(256)
                        .addTo(circuitAssemblerRecipes);
                // World sensor card

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 33),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 25),
                                GTModHandler.getModItem(GalacticraftCore.ID, "item.sensorLens", 2L, 0),
                                GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 89))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);
                // redstone card 1

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 33),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 2L, 24),
                                GTModHandler.getModItem(OpenComputers.ID, "cable", 2L, 0),
                                ItemList.Circuit_Chip_ILC.get(4L),
                                new ItemStack(Blocks.redstone_torch, 2),
                                GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 66))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(10 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);
                // redstone card 2

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 33),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                                GTModHandler.getModItem(OpenComputers.ID, "cable", 2L, 0),
                                ItemList.Circuit_Chip_ILC.get(16L),
                                new ItemStack(Blocks.redstone_torch, 4),
                                GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 12))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(10 * SECONDS).eut(256)
                        .addTo(circuitAssemblerRecipes);
                // data card 1

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 33),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 24),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 4, 27),
                                GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L),
                                GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 104))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);
                // data card 2

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 33),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 25),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1, 29),
                                GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L),
                                GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 105))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(15 * SECONDS).eut(156)
                        .addTo(circuitAssemblerRecipes);
                // data card 3

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 33),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 26),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1, 42),
                                GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 32L),
                                GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 106))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_HV).addTo(circuitAssemblerRecipes);
                // component bus t1

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 2L, 24),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 28),
                                GTOreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 4L),
                                GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 70))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_MV).addTo(circuitAssemblerRecipes);
                // component bus t2

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 2L, 25),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 4L, 28),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 2),
                                GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8),
                                GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 71))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(256).addTo(circuitAssemblerRecipes);
                // component bus t3

                GTValues.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 2L, 26),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 8L, 28),
                                GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 38),
                                GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Diamond, 16),
                                GTUtility.getIntegratedCircuit(1))
                        .itemOutputs(GTModHandler.getModItem(OpenComputers.ID, "item", 1L, 72))
                        .fluidInputs(tMat.getMolten(144L * tMultiplier / 2L)).duration(12 * SECONDS + 10 * TICKS)
                        .eut(TierEU.RECIPE_HV).addTo(circuitAssemblerRecipes);

            }

        }

    }
}
